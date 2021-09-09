package com.doublechaintech.retailscm;


import com.doublechaintech.retailscm.cache.CacheOperator;
import com.doublechaintech.retailscm.cache.NonCacheOperator;
import com.doublechaintech.retailscm.utils.BeanUtils;
import com.doublechaintech.retailscm.search.*;
import com.terapico.utils.DebugUtil;
import com.terapico.utils.MapUtil;
import com.terapico.utils.TextUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static com.doublechaintech.retailscm.BaseEntity.*;

public class DBUtil implements ApplicationContextAware {

  public static final String SEARCH_PROPERTY_ENHANCE_PATHS = "$enhancePaths";
  public static final String SEARCH_PROPERTY_SEARCH_CRITERIA = "$SearchCriteria";
  public static final String SEARCH_PROPERTY_START_RECORD = "$startRecord";
  public static final String SEARCH_PROPERTY_RECORD_COUNT = "$recordCount";
  public static final String SEARCH_PROPERTY_ORDER_BY = "$orderBy";
  public static final String SEARCH_PROPERTY_SEARCH_ENHANCED = "$searchEnhanced";
  public static final String METHOD_SEARCH_EXAMPLE = "searchExample";
  public static final String SEARCH_PROPERTY_SEARCH_EXAMPLE_IGNORE = "$searchExampleIgnore";
  public static final String ENTITY_CACHE = "entityCache";

  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  private BeanFactory beanFactory;

  private CacheOperator cacheOperator = new NonCacheOperator();

  // 清理所有cache
  public void clearAllCache() {
    cacheOperator.clear(ENTITY_CACHE);
  }

  public <T extends BaseEntity> SmartList<T> search(T example, Object... overrideProperties) {
    updateOverrideProperties(example, overrideProperties);

    Map<String, Object> parameters = new HashMap<>();
    String sql = prepareParametersSql(parameters, example);

    sql = addLimitSql(parameters, example, sql);

    try {
      System.out.println(sql);
      System.out.println(DebugUtil.dumpAsJson(parameters, true));
    } catch (Exception e) {
      e.printStackTrace();
    }
    List<? extends BaseEntity> results =
        namedParameterJdbcTemplate.query(sql, parameters, mapper(example.getClass()));
    SmartList<T> res = new SmartList<T>();
    if (results != null) {
      // enhance
      enhanceWithMeta(example, results);
      for (BaseEntity e : results) {
        res.add((T) e);
      }
    }
    return res;
  }

  public <T extends BaseEntity> void enhanceWithMeta(
      T example, List<? extends BaseEntity> results) {
    List<List<Path>> enhancePaths = getEnhancePaths(example);
    if (enhancePaths == null || enhancePaths.isEmpty()) {
      return;
    }
    for (List<Path> onePath : enhancePaths) {
      enhance(results, onePath);
    }
  }

  public void enhance(BaseEntity entity, List<Path> onePath) {
    List<BaseEntity> results = new ArrayList<>();
    results.add(entity);
    enhance(results, onePath);
  }

  public void enhance(List<? extends BaseEntity> results, List<Path> onePath) {
    if (results == null || results.isEmpty() || onePath == null) {
      return;
    }

    List<? extends BaseEntity> starts = new ArrayList<>(results);
    for (Path p : onePath) {
      String property = p.getUpProperty();
      Class<? extends BaseEntity> clazz = p.getClazz();

      if (p.isUpStream()) {
        // 收集并enhance
        starts =
            starts.stream()
                .map(s -> (BaseEntity) s.propertyOf(property))
                .filter(i -> i != null)
                .collect(Collectors.toList());
        enhanceList(starts, p.getClazz());
      } else {
        // 记录当前所有的item, 以支持链式enhance
        List<? extends BaseEntity> backs = new ArrayList<>(starts);
        String downProperty = p.getDownProperty();

        // 如果downProperty为空， 计算它并记录
        if (downProperty == null) {
          BaseEntity first = starts.get(0);
          downProperty = findDownProperty(first.getClass(), p.getClazz(), property);
          p.setDownProperty(downProperty);
        }
        // 如果有数据， 略过
        // 否则会尝试在数据库中抽取sub list
        starts = calculateSubNeedEnhanced(starts, p);

        // 重新计算需要一次enhance的list
        starts = calculateSubNeedEnhanced(starts, p);

        Map<String, ? extends List<? extends BaseEntity>> idEntityMapping =
            starts.stream().collect(Collectors.groupingBy(BaseEntity::getId));

        // 有需要enhance的
        if (!idEntityMapping.isEmpty()) {
          BaseEntity subExample = searchExample(clazz);
          addSearchExamplePropertyValues(subExample, property, idEntityMapping.keySet());
          SmartList<BaseEntity> subs = search(subExample);
          for (BaseEntity sub : subs) {
            String parentId = ((BaseEntity) sub.propertyOf(property)).getId();
            List<? extends BaseEntity> parents = idEntityMapping.get(parentId);
            addChild(parents, sub, property);
          }
        }

        // 新的起点
        starts =
            backs.stream()
                .flatMap(
                    e -> {
                      List<BaseEntity> l = (List<BaseEntity>) e.propertyOf(p.getDownProperty());
                      return l.stream();
                    })
                .collect(Collectors.toList());
      }
    }
  }

  private List<? extends BaseEntity> calculateSubNeedEnhanced(
      List<? extends BaseEntity> starts, Path p) {
    if (starts == null) {
      return Collections.emptyList();
    }

    if (p == null || p.isUpStream()) {
      return Collections.emptyList();
    }

    return starts.stream()
        .filter(
            e -> {
              Object v = e.propertyOf(p.getDownProperty());
              if (v == null) {
                return true;
              }
              if (v instanceof List) {
                return ((List) v).isEmpty();
              }
              return false;
            })
        .collect(Collectors.toList());
  }

  private String findDownProperty(
      Class<? extends BaseEntity> parentClass,
      Class<? extends BaseEntity> clazz,
      String upProperty) {

    String simpleProperty = TextUtil.uncapFirstChar(clazz.getSimpleName() + "List");
    String optional = simpleProperty + "As" + TextUtil.capFirstChar(upProperty);
    try {
      Field field =
          ReflectionUtils.findField(parentClass, "m" + TextUtil.capFirstChar(simpleProperty));
      if (field != null) {
        return simpleProperty;
      } else {
        return optional;
      }
    } catch (Exception e) {
      return optional;
    }
  }

  private void addChild(List<? extends BaseEntity> parents, BaseEntity sub, String property) {
    for (BaseEntity p : parents) {
      Method addChildMethod = findAddChildMethod(p.getClass(), sub.getClass(), property);
      try {
        addChildMethod.invoke(p, sub);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public Method findAddChildMethod(Class parent, Class child, String property) {
    Method method = ReflectionUtils.findMethod(parent, "add" + child.getSimpleName(), child);
    if (method == null) {
      method =
          ReflectionUtils.findMethod(
              parent,
              "add" + child.getSimpleName() + "As" + TextUtil.capFirstChar(property),
              child);
    }
    return method;
  }

  private void enhanceList(List<? extends BaseEntity> list, Class<? extends BaseEntity> clazz) {
    if (list == null || list.isEmpty()) {
      return;
    }
    // 尝试enhance未enhance的item
    tryEnhanceFromCache(list);

    // 收集未被enhance的item ids
    Set<String> ids =
        list.stream()
            .filter(e -> !isEnhanced(e))
            .map(BaseEntity::getId)
            .collect(Collectors.toSet());
    if (ids.isEmpty()) {
      return;
    }
    BaseEntity example = searchExample(clazz);
    if (example == null) {
      return;
    }
    addSearchExamplePropertyValues(example, "id", ids);

    // 从数据库中抽取，而且这个item都会在mapper中cache
    SmartList<BaseEntity> results = search(example);
    merge(list, results);
  }

  private void tryEnhanceFromCache(List<? extends BaseEntity> list) {
    if (list == null || list.isEmpty()) {
      return;
    }

    for (BaseEntity item : list) {
      if (item == null) {
        continue;
      }
      if (isEnhanced(item)) {
        continue;
      }
      BaseEntity o = cacheOperator.get(ENTITY_CACHE, cacheKey(item));
      enhance(item, o);
    }
  }

  private Object cacheKey(BaseEntity item) {
    if (item == null) {
      return null;
    }
    return item.getClass() + item.getId();
  }

  private void merge(List<? extends BaseEntity> list, SmartList<BaseEntity> results) {
    if (list == null || results == null || results.isEmpty()) {
      return;
    }
    Map<String, BaseEntity> db =
        results.stream().collect(Collectors.toMap(BaseEntity::getId, e -> e, (v1, v2) -> v1));

    for (BaseEntity e : list) {
      BaseEntity baseEntity = db.get(e.getId());
      if (baseEntity == null) {
        continue;
      }
      enhance(e, baseEntity);
    }
  }

  public  <T extends BaseEntity> T searchExample(Class<T> clazz) {
      Method searchExample = ReflectionUtils.findMethod(clazz, METHOD_SEARCH_EXAMPLE);
      try {
        BaseEntity example = (BaseEntity) searchExample.invoke(clazz);
        String[] propertyNames = example.getPropertyNames();
        for (String property: propertyNames){
          Field field = ReflectionUtils.findField(clazz, "m" + TextUtil.capFirstChar(property));
          if (field == null){
            continue;
          }
          Class<?> type = field.getType();
          if (Boolean.TYPE.equals(type)){
            addIgnoreProperty(example, property);
          }
        }
        return (T) example;
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }

  public boolean isEnhanced(BaseEntity baseEntity) {
    Object searchEnhanced =
        extractSearchExamplePropertyValues(baseEntity, SEARCH_PROPERTY_SEARCH_ENHANCED);
    if (searchEnhanced == null) {
      return false;
    }
    return (boolean) searchEnhanced;
  }

  public void markEnhanced(BaseEntity baseEntity) {
    addSearchExamplePropertyValues(baseEntity, SEARCH_PROPERTY_SEARCH_ENHANCED, true);
  }

  private <T extends BaseEntity> List<List<Path>> getEnhancePaths(T example) {
    return (List<List<Path>>)
        extractSearchExamplePropertyValues(example, SEARCH_PROPERTY_ENHANCE_PATHS);
  }

  public static <T extends BaseEntity> void addEnhancePaths(T example, List<Path> path) {
    List<List<Path>> enhancePaths =
        (List<List<Path>>)
            extractSearchExamplePropertyValues(example, SEARCH_PROPERTY_ENHANCE_PATHS);

    if (enhancePaths == null) {
      enhancePaths = new ArrayList<>();
      addSearchExamplePropertyValues(example, SEARCH_PROPERTY_ENHANCE_PATHS, enhancePaths);
    }
    enhancePaths.add(path);
  }

  public static <T extends BaseEntity> void addStart(T example, long start) {
    addSearchExamplePropertyValues(example, SEARCH_PROPERTY_START_RECORD, start);
  }

  public static <T extends BaseEntity> Long getStart(T example) {
    return (Long) extractSearchExamplePropertyValues(example, SEARCH_PROPERTY_START_RECORD);
  }

  public static <T extends BaseEntity> void addRecordCount(T example, long count) {
    addSearchExamplePropertyValues(example, SEARCH_PROPERTY_RECORD_COUNT, count);
  }

  public static <T extends BaseEntity> Long getRecordCount(T example) {
    return (Long) extractSearchExamplePropertyValues(example, SEARCH_PROPERTY_RECORD_COUNT);
  }

  public static <T extends BaseEntity> void addOrderBy(T example, String property, boolean asc) {
    example.propertyOf(property);
    List<OrderBy> orderBy = getOrderBy(example);
    if (orderBy == null) {
      orderBy = new ArrayList<>();
      addSearchExamplePropertyValues(example, SEARCH_PROPERTY_ORDER_BY, orderBy);
    }
    orderBy.add(new OrderByImpl(example, property, asc));
  }

  public static <T extends BaseEntity> List<OrderBy> getOrderBy(T example) {
    return (List<OrderBy>) extractSearchExamplePropertyValues(example, SEARCH_PROPERTY_ORDER_BY);
  }

  public <T extends BaseEntity> T searchOne(T example, Object... overrideProperties) {
    updateOverrideProperties(example, overrideProperties);

    Map<String, Object> parameters = new HashMap<>();
    String sql = prepareParametersSql(parameters, example);

    sql = sql + " limit 1";

    try {
      System.out.println(sql);
      System.out.println(DebugUtil.dumpAsJson(parameters, true));
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      BaseEntity entity =
          namedParameterJdbcTemplate.queryForObject(sql, parameters, mapper(example.getClass()));
      List<BaseEntity> l = new ArrayList<>();
      l.add(entity);
      enhanceWithMeta(example, l);
      return (T) entity;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  private <T extends BaseEntity> void updateOverrideProperties(
      T example, Object[] overrideProperties) {
    if (overrideProperties != null) {
      for (int i = 0; i < overrideProperties.length; ) {
        Object o = overrideProperties[i];
        if (o instanceof SearchCriteria) {
          addSearchCriteria(example, (SearchCriteria) o);
          i++;
          continue;
        }
        String key = String.valueOf(o);
        Object value = overrideProperties[i + 1];

        // operator
        if (value instanceof QueryOperator) {
          if (((QueryOperator) value).hasParameter()) {
            Object parameter = overrideProperties[i + 2];
            addSearchCriteria(
                example, new BasicSearchCriteria(example, key, parameter, (QueryOperator) value));
            i += 3;
            continue;
          } else {
            addSearchCriteria(
                example, new BasicSearchCriteria(example, key, (QueryOperator) value));
            i += 2;
          }
        } else {
          addSearchExamplePropertyValues(example, key, value);
          i += 2;
        }
      }
    }
  }

  public static void addSearchCriteria(SearchCriteria criteria) {
    if (criteria == null) {
      return;
    }
    if (criteria instanceof BasicSearchCriteria) {
      addSearchCriteria(((BasicSearchCriteria) criteria).getHolder(), criteria);
    }
  }

  public static <T extends BaseEntity> void addSearchCriteria(T example, SearchCriteria criteria) {
    List<SearchCriteria> searchCriteria = getSearchCriteria(example);
    if (searchCriteria == null) {
      searchCriteria = new ArrayList<>();
      addSearchExamplePropertyValues(example, SEARCH_PROPERTY_SEARCH_CRITERIA, searchCriteria);
    }
    searchCriteria.add(criteria);
  }

  public static <T extends BaseEntity> List<SearchCriteria> getSearchCriteria(T example) {
    return (List<SearchCriteria>)
        extractSearchExamplePropertyValues(example, SEARCH_PROPERTY_SEARCH_CRITERIA);
  }

  public <T extends BaseEntity> int count(T example, Object... overrideProperties) {
    updateOverrideProperties(example, overrideProperties);
    Map<String, Object> parameters = new HashMap<>();
    String sql = prepareParametersCountSql(parameters, example);
    try {
      System.out.println(sql);
      System.out.println(DebugUtil.dumpAsJson(parameters, true));
    } catch (Exception e) {
      e.printStackTrace();
    }
    Integer count = namedParameterJdbcTemplate.queryForObject(sql, parameters, Integer.class);
    if (count != null) {
      return count;
    }
    return 0;
  }

  public <T extends BaseEntity> T ensure(T entity) throws Exception {
    T t = searchOne(entity);
    if (t != null) {
      return t;
    }
    return save(entity);
  }

  public <T extends BaseEntity> T save(T entity) throws Exception {
    fixIdAndVersion(entity, new HashSet<>());
    Class<? extends BaseEntity> entityClass = entity.getClass();
    String name = entityClass.getSimpleName();
    CommonJDBCTemplateDAO dao =
        (CommonJDBCTemplateDAO) beanFactory.getBean(TextUtil.uncapFirstChar(name + "DAO"));

    BaseChecker checker = checker();
    Method checkMethod =
        ReflectionUtils.findMethod(checker.getClass(), "checkAndFix" + name, BaseEntity.class);
    checkMethod.invoke(checker, entity);
    checker.throwExceptionIfHasErrors(
        (Class<? extends Exception>) Class.forName(entityClass.getName() + "ManagerException"));
    Method saveMethod = ReflectionUtils.findMethod(dao.getClass(), "save", entityClass, Map.class);
    return (T) saveMethod.invoke(dao, entity, MapUtil.put("__all__", "all").into_map());
  }

  private void fixIdAndVersion(BaseEntity entity, Set<BaseEntity> visited) throws Exception {

    if (visited.contains(entity)) {
      return;
    }
    visited.add(entity);

    Class<? extends BaseEntity> entityClass = entity.getClass();
    String name = entityClass.getSimpleName();
    CommonJDBCTemplateDAO dao =
        (CommonJDBCTemplateDAO) beanFactory.getBean(TextUtil.uncapFirstChar(name + "DAO"));

    // 新建对象时，设置Id, version这样checker才能过
    if (entity.getId() == null) {
      entity.setId(dao.getNextId());
    }

    String[] propertyNames = entity.getPropertyNames();
    for (String property : propertyNames) {
      Object value = entity.propertyOf(property);

      if (value instanceof BaseEntity) {
        fixIdAndVersion((BaseEntity) value, visited);
      } else if (UNSET_INT.equals(value)) {
        BeanUtils.setPropertyValue(entity, property, 0);
      } else if (UNSET_DOUBLE.equals(value)) {
        BeanUtils.setPropertyValue(entity, property, 0d);
      } else if (UNSET_FLOAT.equals(value)) {
        BeanUtils.setPropertyValue(entity, property, 0f);
      }
    }
  }

  public <T extends BaseEntity> String prepareParametersSql(
      Map<String, Object> parameters, T example) {
    String alias = alias(example.getClass());
    String sql = String.format("select %s.* ", alias);
    return prepareParametersAndSql(parameters, sql, alias, example);
  }

  private <T extends BaseEntity> String prepareParametersCountSql(
      Map<String, Object> parameters, T example) {
    String alias = alias(example.getClass());
    String countSql = "select count(*) ";
    return prepareParametersAndSql(parameters, countSql, alias, example);
  }

  private <T extends BaseEntity> String prepareParametersAndSql(
      Map<String, Object> parameters, String preSql, String alias, T example) {
    if (preSql == null) {
      preSql = "";
    }
    if (alias == null) {
      alias = alias(example);
    }
    String tableName = findTableName(example.getClass());
    String sql = String.format(" %s from %s as %s ", preSql, tableName, alias);
    sql =
        sql + leftJoinSql(alias, example) + " where 1 = 1 " + prepareParameter(parameters, example);

    sql = addOrderBy(parameters, example, sql);
    return sql;
  }

  private <T extends BaseEntity> String commonSearchCriteria(
      T example, Map<String, Object> parameters) {
    List<SearchCriteria> searchCriteria = getSearchCriteria(example);
    if (searchCriteria == null || searchCriteria.isEmpty()) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    for (SearchCriteria criteria : searchCriteria) {
      if (criteria == null) {
        continue;
      }
      String sub = criteria.prepareParameterAndSql(parameters);

      if (StringUtils.hasText(sub)) {
        sb.append(" and ").append(sub);
      }
    }
    return sb.toString();
  }

  private <T extends BaseEntity> String addOrderBy(
      Map<String, Object> parameters, T example, String sql) {
    List<OrderBy> orderBy = collectOrderBy(example);
    if (orderBy == null || orderBy.isEmpty()) {
      return sql;
    }

    String orderByClause = orderBy.stream().map(OrderBy::toSql).collect(Collectors.joining(", "));
    sql = sql + " order by " + orderByClause;
    return sql;
  }

  private <T extends BaseEntity> List<OrderBy> collectOrderBy(T example) {
    if (example == null) {
      return Collections.emptyList();
    }

    Set<String> parents = example.getParentProperties().keySet();
    List<OrderBy> all = new ArrayList<>();
    for (String property : parents) {
      List<OrderBy> orderBIES = collectOrderBy((BaseEntity) example.propertyOf(property));
      all.addAll(orderBIES);
    }

    List<OrderBy> current = getOrderBy(example);
    if (current != null) {
      all.addAll(current);
    }
    return all;
  }

  private <T extends BaseEntity> String addLimitSql(
      Map<String, Object> parameters, T example, String sql) {
    Long count = getRecordCount(example);
    if (count != null) {
      Long start = getStart(example);
      if (start == null) {
        start = 0l;
      }
      sql = sql + " limit :startRecord, :recordCounts";
      parameters.put("startRecord", start);
      parameters.put("recordCounts", count);
    }
    return sql;
  }

  // 1. 收集需要Left join的表
  // 2. 数组，集合(包含base entity处理)
  // 返回需要left join的表
  private <T extends BaseEntity> Map<String, BaseEntity> valueCleanUp(T example) {
    Map<String, BaseEntity> leftJoinProperties = new HashMap<>();
    for (String property : example.getPropertyNames()) {
      if (getIgnoreProperties(example).contains(property)) {
        continue;
      }
      Object value = extractSearchExamplePropertyValues(example, property);
      if (value == null) {
        continue;
      }
      if (value.getClass().isArray()) {
        // 多值,数组
        int length = Array.getLength(value);
        if (length == 0) {
          continue;
        }
        // base entity, 直接取id ，作id in
        Set v;
        if (value.getClass().getComponentType().isAssignableFrom(BaseEntity.class)) {
          v =
              Arrays.asList(value).stream()
                  .map(e -> ((BaseEntity) e).getId())
                  .collect(Collectors.toSet());
        } else {
          v = Arrays.asList(value).stream().collect(Collectors.toSet());
        }
        addSearchExamplePropertyValues(example, property, v);
      } else if (value instanceof Collection) {
        // 多值,集合
        int length = ((Collection) value).size();
        if (length == 0) {
          continue;
        }
        boolean entity = false;
        for (Object e : (Collection) value) {
          if (e instanceof BaseEntity) {
            entity = true;
          }
          break;
        }

        Object v;
        if (entity) {
          v =
              ((Collection<?>) value)
                  .stream().map(e -> ((BaseEntity) e).getId()).collect(Collectors.toSet());
        } else {
          v = new HashSet<>((Collection<?>) value);
        }
        addSearchExamplePropertyValues(example, property, v);
      } else if (value instanceof BaseEntity
          && !StringUtils.hasText(((BaseEntity) value).getId())) {
        // 单值， 需要left join 的对象, 没有指定id
        leftJoinProperties.put(property, (BaseEntity) value);
      } else if (value instanceof BaseEntity) {
        // 单值， 指定id的， 不需要再left join
        addSearchExamplePropertyValues(example, property, ((BaseEntity) value).getId());
      }
    }
    return leftJoinProperties;
  }

  private static <T extends BaseEntity> Object extractSearchExamplePropertyValues(
      T example, String property) {
    example.ensureValueMap();
    try {
      Object o = example.getValueMap().get("searchExample_" + property);
      if (o != null) {
        return o;
      }
      return example.propertyOf(property);
    } catch (Exception e) {
      return null;
    }
  }

  public static <T extends BaseEntity> String alias(T example) {
    String alias = getAlias(example);
    if (alias == null) {
      alias = alias(example.getClass());
      updateAlias(example, alias);
    }
    return alias;
  }

  private static <T extends BaseEntity> String getAlias(T example) {
    example.ensureValueMap();
    return (String) example.getValueMap().getOrDefault("searchAlias", alias(example.getClass()));
  }

  private static <T extends BaseEntity> void updateAlias(T example, String alias) {
    example.ensureValueMap();
    example.getValueMap().put("searchAlias", alias);
  }

  private static <T extends BaseEntity> void addSearchExamplePropertyValues(
      T example, String property, Object value) {
    example.ensureValueMap();
    example.getValueMap().put("searchExample_" + property, value);
  }

  public static <T extends BaseEntity> void addIgnoreProperty(T example, String property) {
    Set<String> ignoreProperties =
        (Set<String>)
            extractSearchExamplePropertyValues(example, SEARCH_PROPERTY_SEARCH_EXAMPLE_IGNORE);

    if (ignoreProperties == null) {
      ignoreProperties = new HashSet<>();
      addSearchExamplePropertyValues(
          example, SEARCH_PROPERTY_SEARCH_EXAMPLE_IGNORE, ignoreProperties);
    }
    ignoreProperties.add(property);
  }

  private <T extends BaseEntity> Set<String> getIgnoreProperties(T example) {
    Set<String> ignoreProperties =
        (Set<String>)
            extractSearchExamplePropertyValues(example, SEARCH_PROPERTY_SEARCH_EXAMPLE_IGNORE);
    if (ignoreProperties == null) {
      return new HashSet<>();
    }
    return ignoreProperties;
  }

  private <T extends BaseEntity> RowMapper<T> mapper(Class<T> clazz) {
    String name = clazz.getName();
    try {
      Class<?> mapperClass = Class.forName(name + "Mapper");
      return (RowMapper<T>) mapperClass.newInstance();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public String findColumnNameParameterName(String alias, String propertyName) {
    return alias + TextUtil.capFirstChar(propertyName);
  }

  public static String findColumnName(String propertyName) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < propertyName.length(); i++) {
      char c = propertyName.charAt(i);
      if (Character.isUpperCase(c)) {
        sb.append("_");
        sb.append(Character.toLowerCase(c));
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  private <T extends BaseEntity> String findTableName(Class<T> clazz) {
    String simpleName = clazz.getSimpleName();
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (int i = 0; i < simpleName.length(); i++) {
      char c = simpleName.charAt(i);
      if (Character.isUpperCase(c)) {
        if (first) {
          sb.append(Character.toLowerCase(c));
          first = false;
        } else {
          sb.append("_");
          sb.append(Character.toLowerCase(c));
        }
      } else {
        sb.append(c);
      }
    }
    sb.append("_data");
    return sb.toString();
  }

  private <T extends BaseEntity> String leftJoinSql(String alias, T example) {
    if (alias != null) {
      updateAlias(example, alias);
    }
    alias = getAlias(example);
    Map<String, BaseEntity> sub = valueCleanUp(example);
    if (sub == null || sub.isEmpty()) {
      return "";
    }
    String sql = "";
    for (Entry<String, BaseEntity> entry : sub.entrySet()) {
      String property = entry.getKey();
      BaseEntity target = entry.getValue();
      sql =
          sql
              + String.format(
                  " left join %s as %s on %s = %s ",
                  findTableName(target.getClass()),
                  property,
                  alias + "." + findColumnName(property),
                  property + ".id");
      sql = sql + leftJoinSql(property, target);
    }
    return sql;
  }

  private <T extends BaseEntity> String prepareParameter(
      Map<String, Object> parameters, T example) {
    String sql = "";
    for (String property : example.getPropertyNames()) {
      if (getIgnoreProperties(example).contains(property)) {
        continue;
      }
      Object value = extractSearchExamplePropertyValues(example, property);
      String columnRefer = getColumnRefer(example, property);
      String key = getAlias(example) + TextUtil.capFirstChar(property);

      while (parameters.containsKey(key)) {
        key = increaseKey(key);
      }
      if (value == null) {
        continue;
      } else if ("".equals(value)) {
        sql = sql + String.format(" and ( %s is null or %s = '') ", columnRefer, columnRefer);
      } else if (Collection.class.isInstance(value)) {
        int length = ((Collection) value).size();
        if (length > 0) {
          sql = sql + String.format(" and  %s in (:%s) ", columnRefer, key);
          parameters.put(key, value);
        }
      } else if (UNSET_DOUBLE.equals(value)
          || UNSET_INT.equals(value)
          || UNSET_FLOAT.equals(value)) {
        continue;
      } else if (value instanceof BaseEntity) {
        sql = sql + prepareParameter(parameters, (BaseEntity) value);
      } else {
        sql = sql + String.format(" and  %s = :%s ", columnRefer, key);
        parameters.put(key, value);
      }
    }

    Map<String, String> referProperties = example.getReferProperties();
    Set<String> keys = referProperties.keySet();
    for (String key : keys) {
      Object value = example.propertyOf(key);

      if (value == null) {
        continue;
      }
      if (!(value instanceof List)) {
        continue;
      }

      List<?> listValue = (List<?>) value;
      if (listValue.isEmpty()) {
        continue;
      }

      Object e = listValue.get(0);
      if (!(e instanceof BaseEntity)) {
        continue;
      }

      BaseEntity baseEntity = (BaseEntity) e;
      addIgnoreProperty(baseEntity, referProperties.get(key));
      String innerSql = prepareParametersSql(parameters, baseEntity);
      sql =
          sql
              + String.format(
                  " and exists(%s and %s.id = %s.%s)",
                  innerSql,
                  getAlias(example),
                  getAlias(baseEntity),
                  findColumnName(referProperties.get(key)));
    }

    sql = sql + commonSearchCriteria(example, parameters);
    return sql;
  }

  public static <T extends BaseEntity> String getColumnRefer(T example, String property) {
    return alias(example) + "." + findColumnName(property);
  }

  private String increaseKey(String key) {
    char c = key.charAt(key.length() - 1);
    if (!Character.isDigit(c)) {
      return key + "0";
    } else {
      // 基本可用
      return key.substring(0, key.length() - 1) + (char) (c + 1);
    }
  }

  private static String alias(Class clazz) {
    String simpleName = clazz.getSimpleName();
    return TextUtil.uncapFirstChar(simpleName);
  }

  public static List<List<Path>> detectShortestPath(
      Class<? extends BaseEntity> start, Class<? extends BaseEntity> endClass) {
    List<List<Path>> paths = parentShortPath(start, endClass);
    if (paths == null || paths.isEmpty()) {
      // try children
      List<List<Path>> downPath = parentShortPath(endClass, start);
      if (downPath == null || downPath.isEmpty()) {
        throw new RuntimeException("不支持转弯， 只能upStream, downStream");
      }
      paths = new ArrayList<>();

      for (List<Path> onPath : downPath) {
        List<Path> one = new ArrayList<>();
        for (int i = onPath.size() - 1; i >= 0; i--) {
          Path p = new Path();
          p.setUpStream(false);
          p.setUpProperty((onPath.get(i).getUpProperty()));
          if (i - 1 < 0) {
            p.setClazz(endClass);
          } else {
            p.setClazz(onPath.get(i - 1).getClazz());
          }
          one.add(p);
        }
        if (!one.isEmpty()) {
          paths.add(one);
        }
      }
    }
    return paths;
  }

  private static List<List<Path>> parentShortPath(
      Class<? extends BaseEntity> start, Class<? extends BaseEntity> endClass) {
    try {
      return parentPath(start.newInstance(), endClass);
    } catch (Exception e) {
      e.printStackTrace();
      return Collections.emptyList();
    }
  }

  private static List<List<Path>> parentPath(
      BaseEntity start, Class<? extends BaseEntity> endClass) {
    try {
      List<List<Path>> shortest = new ArrayList<>();
      List<List<Path>> allPaths = new ArrayList<>();
      parentPath(start, new LinkedList<>(), endClass, allPaths);
      allPaths.sort(Comparator.comparingInt(List::size));
      if (allPaths == null || allPaths.isEmpty()) {
        return null;
      }

      int minSize = allPaths.get(0).size();
      for (List<Path> p : allPaths) {
        if (p.size() == minSize) {
          shortest.add(p);
        }
      }
      return shortest;
    } catch (Exception e) {
      e.printStackTrace();
      return Collections.emptyList();
    }
  }

  private static void parentPath(
      BaseEntity start,
      LinkedList<Path> path,
      Class<? extends BaseEntity> endClass,
      List<List<Path>> results)
      throws Exception {
    if (start.getClass().equals(endClass)) {
      results.add(new ArrayList<>(path));
    }

    Map<String, Class<? extends BaseEntity>> parentProperties = start.getParentProperties();
    Set<Entry<String, Class<? extends BaseEntity>>> entries = parentProperties.entrySet();
    for (Entry<String, Class<? extends BaseEntity>> entry : entries) {
      Class<? extends BaseEntity> value = entry.getValue();
      Path p = new Path();
      p.setClazz(value);
      p.setUpProperty(entry.getKey());
      p.setUpStream(true);
      path.add(p);
      parentPath(value.newInstance(), path, endClass, results);
      path.removeLast();
    }
  }

  public BaseChecker checker() {
    return (BaseChecker) beanFactory.getBean("checker");
  }

  public <T extends BaseEntity> T reload(T entity) {
    return reload(entity, true);
  }

  public <T extends BaseEntity> T reload(T entity, boolean check) {
    if (entity == null || isEnhanced(entity)) {
      return entity;
    }

    String id = entity.getId();
    if (!StringUtils.hasText(id)) {
      if (check) {
        throw new RuntimeException(String.format("实体不存在Id"));
      }
      return entity;
    }

    BaseEntity dbEntity = loadDBEntity(entity.getClass(), id);
    if (dbEntity == null) {
      if (check) {
        throw new RuntimeException(String.format("实体%s(%s)不存在", entity.getInternalType(), id));
      } else {
        return entity;
      }
    }
    enhance(entity, dbEntity);
    return entity;
  }

  private void enhance(BaseEntity entity, BaseEntity dbEntity) {
    if (dbEntity == null || entity == null) {
      return;
    }

    try {
      String[] propertyNames = entity.getPropertyNames();
      for (String property : propertyNames) {
        Object dbV = dbEntity.propertyOf(property);
        Object oldV = entity.propertyOf(property);
        if (oldV == null && dbV instanceof BaseEntity) {
          BaseEntity copy = (BaseEntity) dbV.getClass().newInstance();
          copy.setId(((BaseEntity) dbV).getId());
          copy.setVersion(Integer.MAX_VALUE);
          copy.setChecked(true);
          entity.setPropertyOf(property, copy);
        } else {
          Method method =
              ReflectionUtils.findMethod(
                  entity.getClass(), "set" + TextUtil.capFirstChar(property), (Class[]) null);
          method.invoke(entity, dbV);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    markEnhanced(entity);
  }

  /**
   * db entity cache, key = class + id, value 只包含自身的信息
   *
   * <p>先尝试从cache里面获取， 如果cache里没有，从db中load并缓存
   *
   * @param type
   * @param id
   * @return
   */
  public <T extends BaseEntity> T loadDBEntity(Class<T> type, String id) {
    if (!StringUtils.hasText(id)) {
      return null;
    }

    String key = type + id;
    if (cacheOperator.contains(ENTITY_CACHE, key)) {
      return cacheOperator.get(ENTITY_CACHE, key);
    }

    BaseEntity idExample = searchExample(type);
    idExample.setId(id);

    BaseEntity dbEntity = searchOne(idExample);
    return (T) dbEntity;
  }

  /**
   * copy the properties, save in the db entity cache
   *
   * @param entity
   * @return
   */
  public BaseEntity cache(Object entity) {
    if (!(entity instanceof BaseEntity)) {
      return null;
    }

    if (cacheOperator.contains(ENTITY_CACHE, cacheKey((BaseEntity) entity))) {
      return null;
    }

    try {
      BaseEntity o = (BaseEntity) entity.getClass().newInstance();
      BaseEntity source = (BaseEntity) entity;

      String[] propertyNames = source.getPropertyNames();
      for (String property : propertyNames) {
        Object v = source.propertyOf(property);
        if (v instanceof BaseEntity) {
          BaseEntity copy = (BaseEntity) v.getClass().newInstance();
          copy.setId(((BaseEntity) v).getId());
          o.setPropertyOf(property, copy);
        } else {
          Method method =
              ReflectionUtils.findMethod(
                  entity.getClass(), "set" + TextUtil.capFirstChar(property), (Class[]) null);
          method.invoke(o, v);
        }
      }
      cacheOperator.put(ENTITY_CACHE, cacheKey(o), o);
      return o;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public void cacheCleanUp(BaseEntity entity) {
    if (entity == null) {
      return;
    }

    String id = entity.getId();
    if (!StringUtils.hasText(id)) {
      return;
    }
    cacheOperator.clear(ENTITY_CACHE, cacheKey(entity));
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.beanFactory = applicationContext;
  }

  public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
    return namedParameterJdbcTemplate;
  }

  public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate pNamedParameterJdbcTemplate) {
    namedParameterJdbcTemplate = pNamedParameterJdbcTemplate;
  }

  public CacheOperator getCacheOperator() {
    return cacheOperator;
  }

  public void setCacheOperator(CacheOperator pCacheOperator) {
    cacheOperator = pCacheOperator;
  }

  public static class Path {
    private String upProperty;
    private String downProperty;
    private boolean upStream;
    private Class<? extends BaseEntity> clazz;

    public String getDownProperty() {
      return downProperty;
    }

    public void setDownProperty(String downProperty) {
      this.downProperty = downProperty;
    }

    public boolean isUpStream() {
      return upStream;
    }

    public void setUpStream(boolean upStream) {
      this.upStream = upStream;
    }

    public String getUpProperty() {
      return upProperty;
    }

    public void setUpProperty(String upProperty) {
      this.upProperty = upProperty;
    }

    public Class<? extends BaseEntity> getClazz() {
      return clazz;
    }

    public void setClazz(Class<? extends BaseEntity> clazz) {
      this.clazz = clazz;
    }

    @Override
    public String toString() {
      return "Path{"
          + "property='"
          + upProperty
          + '\''
          + ", upStream="
          + upStream
          + ", clazz="
          + clazz
          + '}';
    }
  }
}



