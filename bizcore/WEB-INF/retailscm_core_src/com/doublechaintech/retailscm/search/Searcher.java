package com.doublechaintech.retailscm.search;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.Beans;
import com.doublechaintech.retailscm.SmartList;
import com.terapico.utils.TextUtil;

import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Searcher {
  public static final String AGGREGATIONS = "aggregations";

  public static List<AggregationResult> statsOf(BaseEntity bean) {
    if (bean == null) {
      return new ArrayList<>();
    }
    Object object = bean.valueByKey(AGGREGATIONS);
    if (object == null) {
      return new ArrayList<>();
    }
    return (List<AggregationResult>) object;
  }

  public static Long valueToLong(Object value) {

    if (!(value instanceof Number)) {
      return 0L;
    }
    Number numberValue = (Number) value;
    return numberValue.longValue();
  }

  public static Long assignCountValue(SmartList smartList) {

    if (smartList == null) {
      return 0L;
    }
    Object object = smartList.valueByKey(AGGREGATIONS);
    if (object == null) {
      return 0L;
    }
    List<AggregationResult> resultList = (List<AggregationResult>) object;
    if (resultList.isEmpty()) {
      return 0L;
    }
    AggregationResult result = resultList.get(0);
    if (result.getData() == null || result.getData().isEmpty()) {
      return 0L;
    }
    Long count =
        result.getData().stream()
            .mapToLong(item -> valueToLong(item.getValues().get("count")))
            .sum();

    smartList.setTotalCount(count.intValue());
    return count;
  }

  public static <T extends BaseEntity> Long singleCountValue(
      Object userContext, BaseRequest<T> pRequest) {
    BaseEntity bean = search(userContext, pRequest);
    return assignCountValue((SmartList) bean);
  }

  public static <T extends BaseEntity> Stream<T> searchAsStream(
      Object userContext, BaseRequest<T> pRequest, int batch) {
    return StreamSupport.stream(
        new RequestIterable(userContext, pRequest, batch).spliterator(), false);
  }

  public static <T extends BaseEntity> Stream<T> searchAsStream(
      Object userContext, BaseRequest<T> pRequest) {
    return searchAsStream(userContext, pRequest, 1000);
  }

  public static <T extends BaseEntity> SmartList<T> search(
      Object userContext, BaseRequest<T> pRequest) {
    String internalType = pRequest.getInternalType();
    Object manager = Beans.getBean(TextUtil.uncapFirstChar(internalType) + "Manager");

    Method searchMethod =
        ReflectUtil.getMethodByName(manager.getClass(), "search" + internalType + "List");
    try {
      SmartList<T> resultList = (SmartList<T>) searchMethod.invoke(manager, userContext, pRequest);
      assignCountValue(resultList);
      return resultList;
    } catch (Exception pE) {
      throw ExceptionUtil.wrapRuntime(ExceptionUtil.unwrap(pE));
    }
  }

  public static <T extends BaseEntity> T searchOne(Object userContext, BaseRequest<T> pRequest) {
    String internalType = pRequest.getInternalType();
    Object manager = Beans.getBean(TextUtil.uncapFirstChar(internalType) + "Manager");
    try {
      return (T) ReflectUtil.invoke(manager, "search" + internalType, userContext, pRequest);
    } catch (Exception pE) {
      pE.printStackTrace();
      return null;
    }
  }

  public static <T extends BaseEntity> void enhance(List<T> list, BaseRequest<T> pRequest) {
    if (list == null || list.isEmpty()) {
      return;
    }
    Map<String, BaseRequest> parentSelects = pRequest.getParentSelects();
    parentSelects.forEach(
        (k, v) -> {
          List<BaseEntity> parentsIdOnly =
              list.stream()
                  .map(item -> (BaseEntity) item.propertyOf(k))
                  .filter(n -> n != null)
                  .collect(Collectors.toList());
          if (parentsIdOnly.isEmpty()) {
            return;
          }
          Map<BaseEntity, BaseEntity> parentMapping =
              CollectionUtil.toMap(
                  list, new HashMap<>(), item -> item, item -> (BaseEntity) item.propertyOf(k));
          v.doAddSearchCriteria(new SimplePropertyCriteria("id", QueryOperator.IN, parentsIdOnly));
          Map<String, BaseEntity> parentFull =
              (Map<String, BaseEntity>)
                  search(pRequest.getUserContext(), v).stream()
                      .collect(
                          Collectors.toMap(
                              item -> ((BaseEntity) item).getId(), p -> p, (v1, v2) -> v1));
          parentMapping.forEach(
              (c, p) -> {
                if (p == null) {
                  return;
                }
                BaseEntity baseEntity = parentFull.get(p.getId());
                // parent不存在，设置为空
                if (baseEntity == null) {
                  Method m =
                      ReflectUtil.getMethodByName(c.getClass(), "set" + StrUtil.upperFirst(k));
                  if (m != null) {
                    ReflectUtil.invoke(c, m, (Object[]) null);
                  }
                  return;
                }
                // parent存在，尝试维护关系
                Method addChildMethod = findAddChildMethod(p.getClass(), c.getInternalType(), k);
                if (addChildMethod != null) {
                  try {
                    addChildMethod.invoke(baseEntity, c);
                  } catch (Exception pE) {
                    pE.printStackTrace();
                  }
                  return;
                }
                // 查询结果不作复制
                Method m = ReflectUtil.getMethodByName(c.getClass(), "set" + StrUtil.upperFirst(k));
                if (m != null) {
                  ReflectUtil.invoke(c, m, baseEntity);
                }
              });
        });
    Map<String, BaseRequest> childrenSelects = pRequest.getChildrenSelects();
    Map<String, T> map =
        list.stream().collect(Collectors.toMap(BaseEntity::getId, n -> n, (v1, v2) -> v1));
    childrenSelects.forEach(
        (k, v) -> {
          k = k.substring(v.getInternalType().length());
          v.select(k);
          if (v.hasLimit()) {
            v.setPartitionProperty(k);
          }
          v.doAddSearchCriteria(new SimplePropertyCriteria(k, QueryOperator.IN, list));
          List<BaseEntity> children = search(pRequest.getUserContext(), v);
          for (BaseEntity child : children) {
            BaseEntity baseEntity = (BaseEntity) child.propertyOf(k);
            if (baseEntity == null) {
              continue;
            }
            T t = map.get(baseEntity.getId());
            Method addChildMethod = findAddChildMethod(t.getClass(), child.getInternalType(), k);
            try {
              addChildMethod.invoke(t, child);
            } catch (Exception pE) {
              pE.printStackTrace();
            }
          }
        });
  }

  public static Method findAddChildMethod(
      Class<? extends BaseEntity> parent, String child, String property) {
    Method method = ReflectUtil.getMethodByName(parent, "add" + child);
    if (method == null) {
      method =
          ReflectUtil.getMethodByName(
              parent, "add" + child + "As" + TextUtil.capFirstChar(property));
    }
    return method;
  }

  public static List<AggregationResult> aggregations(Object userContext, BaseRequest pRequest) {
    SmartList ret = search(userContext, pRequest);
    return (List<AggregationResult>) ret.valueByKey(AGGREGATIONS);
  }

  public static AggregationResult aggregation(Object userContext, BaseRequest pRequest) {
    List<AggregationResult> aggregations = aggregations(userContext, pRequest);
    return CollectionUtil.getFirst(aggregations);
  }
}
