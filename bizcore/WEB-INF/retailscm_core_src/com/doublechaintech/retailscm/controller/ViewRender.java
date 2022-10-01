package com.doublechaintech.retailscm.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.*;
import cn.hutool.json.JSONUtil;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.search.BaseRequest;
import com.doublechaintech.retailscm.search.Searcher;
import com.terapico.meta.BaseMeta;
import com.terapico.meta.EntityMeta;
import com.terapico.meta.MetaProvider;
import com.terapico.meta.PropertyMeta;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.MapUtil;
import org.springframework.beans.factory.BeanNameAware;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public abstract class ViewRender extends RetailscmCheckerManager implements BeanNameAware {

  public static final String FORM = "form";
  public static final String LIST = "list";
  public static final String UI_ATTRIBUTE_PREFIX = "ui_";
  public static final String UI_FIELD_ACTION_SUFFIX = "_action";
  public static final String UI_PASS_THROUGH_ATTRIBUTE_PREFIX = "ui-";
  public static final String UI_CANDIDATE_ATTRIBUTE_PREFIX = "ui_candidate_";
  public static final String TEMPLATE = "$template";
  public static final String NUMBER_TYPE = "_number";
  public static final String BOOL_TYPE = "_bool";

  private String beanName;

  public String getBeanName() {
    return beanName;
  }

  @Override
  public void setBeanName(String pBeanName) {
    beanName = pBeanName;
  }

  public Object view(CustomRetailscmUserContextImpl ctx, Object data) throws Exception {
    if (data == null) {
      return null;
    }

    Method showPop = ReflectUtil.getMethodByName(getTemplateRender().getClass(), "showPop");
    if (showPop != null) {
      Object o = ReflectUtil.invoke(getTemplateRender(), showPop, ctx, data);
      if (o != null) {
        return o;
      }
    }

    invokeBeforeView(ctx, data);
    EntityMeta meta = MetaProvider.entity(data.getClass());
    Map<String, Object> page = new HashMap<>();
    switch (getPageType(meta)) {
      case FORM:
        renderAsForm(ctx, page, meta, data);
        break;
      case LIST:
        renderAsList(ctx, page, meta, data);
        break;
      default:
        return data;
    }
    return page;
  }

  private void renderAsList(
      CustomRetailscmUserContextImpl ctx, Object page, EntityMeta meta, Object data) {
    addListClass(ctx, page, meta, data);
    addPageTitle(ctx, page, meta, data);
    addListData(ctx, page, meta, data);
    setUIPassThrough(meta, page);
  }

  private void addListData(
      CustomRetailscmUserContextImpl ctx, Object page, EntityMeta meta, Object data) {
    for (Map.Entry<String, PropertyMeta> entry : meta.getProperties().entrySet()) {
      PropertyMeta fieldMeta = entry.getValue();
      List candidates = prepareCandidates(ctx, meta, fieldMeta, data);
      if (candidates != null) {
        for (Object candidate : candidates) {
          Object refinedCandidate = buildItemOfList(ctx, fieldMeta, candidate, data);
          Object id = getProperty(refinedCandidate, "id");
          if (ObjectUtil.isEmpty(id)) {
            continue;
          }
          addValue(page, "list", MapUtil.put("id", id).into_map());
          setValue(page, "dataContainer." + id, refinedCandidate);
        }
        setListMeta(ctx, page, fieldMeta, candidates, data);
        break;
      }
    }
  }

  private Object buildItemOfList(
      CustomRetailscmUserContextImpl ctx,
      PropertyMeta fieldMeta,
      Object candidateItem,
      Object data) {
    boolean noCandidateMapping = getBoolean(fieldMeta, "candidate-without-mapping", false);
    if (noCandidateMapping) {
      return buildItemOfListDirectly(ctx, fieldMeta, candidateItem, data);
    }
    Map<String, Object> ret = new HashMap<>();
    String idProp = getCandidateProperty(ctx, fieldMeta, "id");
    Object idPropertyValue = getCandidateValue(ctx, candidateItem, idProp);
    if (ObjectUtil.isEmpty(candidateItem)) {
      return null;
    }
    setValue(ret, "id", idPropertyValue);

    addCandidateCommonProperty(ctx, fieldMeta, ret, candidateItem);

    fieldMeta.forEach(
        (k, value) -> {
          String key = k;
          if (!key.startsWith(UI_ATTRIBUTE_PREFIX)) {
            return;
          }
          if (!key.endsWith(UI_FIELD_ACTION_SUFFIX)) {
            return;
          }
          addValue(
              candidateItem,
              "actionList",
              buildSelectAction(
                  ctx, data, (String) value, (String) fieldMeta.get("name"), idPropertyValue));
        });
    return ret;
  }

  private Object buildItemOfListDirectly(
      CustomRetailscmUserContextImpl ctx, PropertyMeta meta, Object candidate, Object data) {
    Map<String, Object> mapping = BeanUtil.beanToMap(candidate);
    Map<String, Object> ret = new HashMap<>();
    mapping.forEach(
        (k, v) -> {
          if ("actionList".equals(k)) {
            if (v == null) {
              return;
            }
            Iterable l = (Iterable) v;
            for (Object action : l) {
              addValue(
                  ret,
                  "actionList",
                  buildSelectAction(
                      ctx,
                      data,
                      String.valueOf(action),
                      (String) meta.get("name"),
                      mapping.get("id")));
            }
            return;
          }

          char c = k.charAt(0);
          if (!CharUtil.isLetter(c)) {
            addValue(ret, "infoList", MapUtil.put("title", k).put("value", v).into_map());
            addValue(ret, "infoList", null);
          } else {
            setValue(ret, k, v);
          }
        });

    return ret;
  }

  private void setListMeta(
      CustomRetailscmUserContextImpl ctx,
      Object page,
      BaseMeta meta,
      List candidates,
      Object data) {
    String nextPage =
        String.format("prepareNextPageUrlFor%s", StrUtil.upperFirst((String) meta.get("name")));

    Object nextPageUrl = null;
    if (hasCustomized(ctx, data, nextPage)) {
      nextPageUrl = invokeCandidateAction(ctx, data, nextPage);
    }

    setValue(page, "listMeta.linkToUrl", nextPageUrl);
  }

  private void addListClass(
      CustomRetailscmUserContextImpl ctx, Object page, EntityMeta meta, Object data) {
    ctx.forceResponseXClassHeader("com.terapico.appview.ListOfPage");
  }

  private Object getTemplateRender() {
    return Beans.getBean("templateRender");
  }

  private void invokeBeforeView(CustomRetailscmUserContextImpl pCtx, Object pData) {
    Object bean = Beans.getBean(ClassUtil.loadClass(pData.getClass().getName() + "Processor"));
    ReflectUtil.invoke(bean, "beforeView", pCtx, pData);
  }

  public Object renderAsForm(
      CustomRetailscmUserContextImpl ctx, Object page, EntityMeta meta, Object data) {
    addFormClass(ctx, page, meta, data);
    addFormId(ctx, page, meta, data);
    addPageTitle(ctx, page, meta, data);
    addFormActions(ctx, page, meta, data);
    addFormFields(ctx, page, meta, data);
    setUIPassThrough(meta, page);
    addRequestId(ctx, page);
    return page;
  }

  private void addRequestId(CustomRetailscmUserContextImpl ctx, Object page) {
    Object defaultGroup = ensureFormGroup(page, "default");
    addValue(
        defaultGroup,
        "fieldList",
        MapUtil.put("name", "_req")
            .put("label", "_req")
            .put("type", "text")
            .putIf("value", IdUtil.fastSimpleUUID())
            .put("hidden", true)
            .into_map());
  }

  private void addFormFields(
      CustomRetailscmUserContextImpl ctx, Object page, EntityMeta meta, Object data) {
    meta.getProperties()
        .entrySet()
        .forEach(
            entry -> {
              addFormField(ctx, page, meta, entry.getKey(), entry.getValue(), data);
            });
  }

  private void addFormField(
      CustomRetailscmUserContextImpl ctx,
      Object page,
      EntityMeta meta,
      String fieldName,
      PropertyMeta fieldMeta,
      Object data) {
    Boolean ignored = getBoolean(fieldMeta, "ignore", false);
    if (ignored) {
      return;
    }
    String groupName = getStr(fieldMeta, "group", "default");
    Object group = ensureFormGroup(page, groupName);

    Object formField = createFormField(ctx, meta, fieldName, fieldMeta, data);
    if (formField == null) {
      return;
    }
    addValue(group, "fieldList", formField);
  }

  private Object createFormField(
      CustomRetailscmUserContextImpl ctx,
      EntityMeta pMeta,
      String pFieldName,
      PropertyMeta pFieldMeta,
      Object pData) {
    Object fieldValue = getFieldValue(pData, pFieldName, pFieldMeta);
    Boolean ignoreIfNull = getBoolean(pFieldMeta, "ignore-if-null", false);
    if (ignoreIfNull && fieldValue == null) {
      return null;
    }
    Object currentFieldValue = format(ctx, pFieldMeta, fieldValue);
    List candidates = prepareCandidates(ctx, pMeta, pFieldMeta, pData);
    Object uiField =
        MapUtil.put("name", pFieldName)
            .put("label", pFieldMeta.getStr("zh_CN", pFieldName))
            .put(
                "type",
                pFieldMeta.getStr(
                    "ui-type", defaultFormFieldType(ctx, pFieldMeta, currentFieldValue)))
            .putIf("value", currentFieldValue)
            .into_map();
    if (getBoolean(pFieldMeta, "no_label", false)) {
      setValue(uiField, "label", null);
    }

    if (candidates != null) {
      candidates = CollectionUtil.sub(candidates, 0, getCandidateLimit(pFieldMeta));
      List mappingCandidates =
          (List)
              candidates.stream()
                  .map(c -> buildCandidate(ctx, pFieldMeta, c, currentFieldValue))
                  .collect(Collectors.toList());

      renderCandidateValues(ctx, pFieldMeta, fieldValue, candidates, mappingCandidates, uiField);
    }
    renderFieldValue(ctx, uiField, pMeta, pFieldMeta, fieldValue);
    buildFieldActions(ctx, uiField, pMeta, pFieldMeta, pData);
    setUIPassThrough(pFieldMeta, uiField);
    return uiField;
  }

  private void renderCandidateValues(
      CustomRetailscmUserContextImpl ctx,
      PropertyMeta pFieldMeta,
      Object pFieldValue,
      List candidates,
      List mappingCandidates,
      Object uiField) {
    String template = getCandidateProperty(ctx, pFieldMeta, TEMPLATE, null);
    if (template != null) {
      Method templateRender = ReflectUtil.getMethodByName(getTemplateRender().getClass(), template);
      if (templateRender == null) {
        return;
      }
      ReflectUtil.invoke(
          getTemplateRender(),
          templateRender,
          ctx,
          pFieldMeta,
          uiField,
          pFieldValue,
          candidates,
          mappingCandidates);
      return;
    }
    String candidateContainer =
        getCandidateProperty(ctx, pFieldMeta, "$container", "candidateValues");
    setValue(uiField, candidateContainer, null);
    mappingCandidates.forEach(
        candidate -> {
          addValue(uiField, candidateContainer, candidate);
        });
  }

  public void renderFieldValue(
      CustomRetailscmUserContextImpl ctx,
      Object uiField,
      EntityMeta pMeta,
      PropertyMeta pFieldMeta,
      Object fieldValue) {
    String template = getStr(pFieldMeta, TEMPLATE, null);
    if (template != null) {
      Method templateRender = ReflectUtil.getMethodByName(getTemplateRender().getClass(), template);
      if (templateRender == null) {
        return;
      }
      ReflectUtil.invoke(getTemplateRender(), templateRender, ctx, pFieldMeta, uiField, fieldValue);
    }
  }

  private Object getFieldValue(Object data, String fieldName, PropertyMeta meta) {
    if (data == null) {
      return null;
    }
    String vpath = getStr(meta, "vpath", fieldName);

    return getEnhancedProperty(data, vpath);
  }

  private Object getEnhancedProperty(Object data, String vpath) {
    if (data == null) {
      return null;
    }

    String[] vpaths = vpath.split("\\.");
    return getEnhancedProperty(data, vpaths);
  }

  private Object getEnhancedProperty(Object data, String[] vpath) {
    if (vpath == null || vpath.length == 0) {
      return data;
    }
    String property = vpath[0];
    if (data instanceof BaseEntity) {
      data = RetailscmBaseUtils.itemView((BaseEntity) data);
    }

    Object newV;
    if (property.startsWith("$")) {
      newV = ReflectUtil.invoke(this, property.substring(1), data);
    } else {
      newV = getProperty(data, property);
    }

    return getEnhancedProperty(getProperty(data, property), ArrayUtil.sub(vpath, 1, vpath.length));
  }

  private void buildFieldActions(
      CustomRetailscmUserContextImpl ctx,
      Object field,
      EntityMeta meta,
      PropertyMeta fieldMeta,
      Object pData) {
    fieldMeta.forEach(
        (k, value) -> {
          String key = k;
          if (!key.startsWith(UI_ATTRIBUTE_PREFIX)) {
            return;
          }
          if (!key.endsWith(UI_FIELD_ACTION_SUFFIX)) {
            return;
          }
          setValue(
              field,
              StrUtil.removeSuffix(
                  StrUtil.removePrefix(key, UI_ATTRIBUTE_PREFIX), UI_FIELD_ACTION_SUFFIX),
              createAction(pData, (String) value));
        });
  }

  private Object buildCandidate(
      CustomRetailscmUserContextImpl ctx,
      PropertyMeta meta,
      Object candidate,
      Object currentValue) {
    Map<String, Object> ret = new HashMap<>();
    String idProp = getCandidateProperty(ctx, meta, "id");
    Object idPropertyValue = getCandidateValue(ctx, candidate, idProp);
    Object currentIdPropertyValue = getCandidateValue(ctx, currentValue, idProp);
    setValue(ret, "id", idPropertyValue);
    if (currentIdPropertyValue != null && getBoolean(meta, "candidate_$select", true)) {
      setValue(ret, "selected", ObjectUtil.equals(idPropertyValue, currentIdPropertyValue));
    }
    addCandidateCommonProperty(ctx, meta, ret, candidate);
    return ret;
  }

  private void addCandidateCommonProperty(
      CustomRetailscmUserContextImpl ctx,
      PropertyMeta meta,
      Object uiCandidate,
      Object candidateValue) {
    if (candidateValue == null) {
      return;
    }
    meta.forEach(
        (k, v) -> {
          if (!k.startsWith(UI_CANDIDATE_ATTRIBUTE_PREFIX)) {
            return;
          }
          String key = StrUtil.removePrefix(k, UI_CANDIDATE_ATTRIBUTE_PREFIX);
          if (key.startsWith("$")) {
            return;
          }
          setValue(uiCandidate, key, getCandidateValue(ctx, candidateValue, (String) v));
        });
  }

  private String getCandidateProperty(
      CustomRetailscmUserContextImpl ctx, PropertyMeta meta, String property) {
    return getCandidateProperty(ctx, meta, property, property);
  }

  private String getCandidateProperty(
      CustomRetailscmUserContextImpl ctx,
      PropertyMeta meta,
      String property,
      String defaultProperty) {
    return meta.getStr(UI_CANDIDATE_ATTRIBUTE_PREFIX + property, defaultProperty);
  }

  private Object getCandidateValue(
      CustomRetailscmUserContextImpl ctx, Object value, String property) {
    String defaultValue = null;
    if (property.contains(":")) {
      defaultValue = property.substring(property.indexOf(":") + 1);
      property = property.substring(0, property.indexOf(":"));
    }
    if (value == null) {
      return defaultValue;
    }
    try {
      Class clazz = ClassUtil.loadClass(value.getClass().getName() + "CandidateWrapper");
      value = ReflectUtil.newInstance(clazz, value);
    } catch (Exception e) {

    }

    if (ClassUtil.isSimpleValueType(value.getClass())) {
      return value;
    }

    if (value instanceof BaseEntity && "displayName".equals(property)) {
      return ((BaseEntity) value).getDisplayName();
    }

    if (value instanceof KeyValuePair && "displayName".equals(property)) {
      return ((KeyValuePair) value).getValue();
    }

    if (value instanceof KeyValuePair && "id".equals(property)) {
      return ((KeyValuePair) value).getKey();
    }

    Object v = getEnhancedProperty(value, property);
    if (v == null) {
      return defaultValue;
    }
    return v;
  }

  private void setUIPassThrough(BaseMeta meta, Object uiElement) {
    meta.forEach(
        (k, value) -> {
          String key = (String) k;
          if (!key.startsWith(UI_PASS_THROUGH_ATTRIBUTE_PREFIX)) {
            return;
          }
          String property = StrUtil.removePrefix(key, UI_PASS_THROUGH_ATTRIBUTE_PREFIX);

          if (StrUtil.endWith(property, NUMBER_TYPE)) {
            property = StrUtil.removeSuffix(property, NUMBER_TYPE);
            setValue(uiElement, property, NumberUtil.parseNumber((String) value));
            return;
          }

          if (StrUtil.endWith(property, BOOL_TYPE)) {
            property = StrUtil.removeSuffix(property, BOOL_TYPE);
            setValue(uiElement, property, BooleanUtil.toBoolean((String) value));
            return;
          }
          setValue(uiElement, property, value);
        });
  }

  private List prepareCandidates(
      CustomRetailscmUserContextImpl pCtx,
      EntityMeta pMeta,
      PropertyMeta pFieldMeta,
      Object pData) {
    boolean ignoreCandidate = getBoolean(pFieldMeta, "no-candidate", false);
    if (ignoreCandidate) {
      return null;
    }

    String candidateAction =
        String.format(
            "prepareCandidatesFor%s", StrUtil.upperFirst((String) pFieldMeta.get("name")));

    if (hasCustomized(pCtx, pData, candidateAction)) {
      return invokeCandidateAction(pCtx, pData, candidateAction);
    }

    if (pFieldMeta.isObj() && pFieldMeta.isConstant()) {
      return loadConstants(pFieldMeta.getParentType());
    }

    if (pFieldMeta.isObj() && !pFieldMeta.isConstant()) {
      return loadTop(pCtx, pFieldMeta);
    }
    return null;
  }

  private boolean hasCustomized(
      CustomRetailscmUserContextImpl pCtx, Object pData, String pCandidateAction) {
    Object bean = Beans.getBean(ClassUtil.loadClass(pData.getClass().getName() + "Processor"));
    Method method = ReflectUtil.getMethodOfObj(bean, pCandidateAction, pCtx, pData);
    return method != null;
  }

  private List loadConstants(Class pParentType) {
    return (List)
        ReflectUtil.getStaticFieldValue(ReflectUtil.getField(pParentType, "CODE_NAME_LIST"));
  }

  public List loadTop(CustomRetailscmUserContextImpl pCtx, PropertyMeta meta) {
    if (meta == null) {
      return null;
    }
    Class parentType = meta.getParentType();
    Class<? extends BaseRequest> requestClass =
        ClassUtil.loadClass(parentType.getName() + "Request");

    Method newInstance = ReflectUtil.getMethod(requestClass, "newInstance");
    BaseRequest request = ReflectUtil.invokeStatic(newInstance);
    Method selectSelf = ReflectUtil.getMethod(requestClass, "selectSelf");
    ReflectUtil.invoke(request, selectSelf);
    request.setSize(getCandidateLimit(meta));
    return Searcher.search(pCtx, request);
  }

  private Integer getCandidateLimit(PropertyMeta meta) {
    return getInt(meta, "candidate-limit", 50);
  }

  private <T> T invokeCandidateAction(
      CustomRetailscmUserContextImpl pCtx, Object pData, String pCandidateAction) {
    Object bean = Beans.getBean(ClassUtil.loadClass(pData.getClass().getName() + "Processor"));
    return ReflectUtil.invoke(bean, pCandidateAction, pCtx, pData);
  }

  public String defaultFormFieldType(
      CustomRetailscmUserContextImpl pCtx, PropertyMeta pFieldMeta, Object pCurrentFieldValue) {
    if (pFieldMeta.isObj() && pFieldMeta.isConstant()) {
      return "single-select";
    }

    if (pFieldMeta.isDate()) {
      return "datetime";
    }

    if (pFieldMeta.isDouble()) {
      return "double";
    }

    if (pFieldMeta.isInt() || pFieldMeta.isLong()) {
      return "integer";
    }

    return "text";
  }

  public Object format(CustomRetailscmUserContextImpl ctx, PropertyMeta meta, Object value) {
    String idProp = getCandidateProperty(ctx, meta, "id");
    return getCandidateValue(ctx, value, idProp);
  }

  private Object ensureFormGroup(Object page, String groupName) {
    Object group = MapUtil.put("name", groupName).into_map();
    Object groupList = getProperty(page, "groupList");
    if (groupList == null) {
      addValue(page, "groupList", group);
      return group;
    }
    List l = (List) groupList;
    for (Object oneGroup : l) {
      Object name = getProperty(oneGroup, "name");
      if (groupName.equals(name)) {
        return oneGroup;
      }
    }
    addValue(page, "groupList", group);
    return group;
  }

  private void addFormActions(
      CustomRetailscmUserContextImpl ctx, Object page, EntityMeta meta, Object data) {
    List<String> actions = getList(meta, "action", ListUtil.empty());
    actions.forEach(
        action -> {
          addValue(page, "actionList", createAction(data, action));
        });
  }

  public Map<String, Object> createAction(Object data, String action) {
    String[] actionDes = action.split(":");
    String title, code;
    title = actionDes[0];
    if (actionDes.length > 1) {
      code = actionDes[1];
    } else {
      code = actionDes[0];
    }
    return MapUtil.put("title", title)
        .put("code", code)
        .put("linkToUrl", makeActionUrl(code, data))
        .into_map();
  }

  public Map<String, Object> buildSelectAction(
      CustomRetailscmUserContextImpl ctx, Object data, String action, String fieldName, Object id) {
    String[] actionDes = action.split(":");
    String title, code;
    title = actionDes[0];
    if (actionDes.length > 1) {
      code = actionDes[1];
    } else {
      code = actionDes[0];
    }
    return MapUtil.put("title", title)
        .put("code", code)
        .put("linkToUrl", makeGetActionUrl(ctx, code, data, MapUtil.put(fieldName, id).into_map()))
        .into_map();
  }

  public static void addValue(Object page, String key, Object value) {
    Object current = getProperty(page, key);
    if (current instanceof List) {
      ((List) current).add(value);
      return;
    }
    List l = new ArrayList();
    if (current != null) {
      l.add(current);
    }
    l.add(value);
    setValue(page, key, l);
  }

  public String makeActionUrl(String action, Object data) {
    if (data == null) {
      return String.format("%s/%s/", getBeanName(), action);
    } else {
      EntityMeta entity = MetaProvider.entities.get(data.getClass().getName());
      return makeActionUrl(action, entity, data);
    }
  }

  public String makeGetActionUrl(
      CustomRetailscmUserContextImpl ctx,
      String action,
      Object data,
      Map<String, Object> additional) {
    if (data == null) {
      return String.format("%s/%s/", getBeanName(), action);
    } else {
      EntityMeta entity = MetaProvider.entities.get(data.getClass().getName());
      return makeGetActionUrl(ctx, action, entity, data, additional);
    }
  }

  public String makeActionUrl(String action, EntityMeta meta, Object data) {
    if (meta == null) {
      return String.format("%s/%s/", getBeanName(), action);
    } else {
      ViewRender bean = Beans.getBean(ClassUtil.loadClass(meta.getType().getName() + "Processor"));
      return String.format("%s/%s/", bean.getBeanName(), action);
    }
  }

  public String makeGetActionUrl(
      CustomRetailscmUserContextImpl ctx,
      String action,
      EntityMeta meta,
      Object data,
      Map<String, Object> additional) {
    if (meta == null) {
      return String.format("%s/%s/", getBeanName(), action);
    } else {
      ViewRender bean = Beans.getBean(ClassUtil.loadClass(meta.getType().getName() + "Processor"));
      return String.format(
          "%s/%s/%s/", bean.getBeanName(), action + "AsGet", encode(ctx, data, additional));
    }
  }

  public String encode(
      CustomRetailscmUserContextImpl ctx, Object data, Map<String, Object> additional) {
    if (data == null) {
      errorMessage("data should not null");
    }
    EntityMeta entity = MetaProvider.entities.get(data.getClass().getName());
    Map<String, Object> values = new HashMap<>();
    for (Map.Entry<String, PropertyMeta> entry : entity.getProperties().entrySet()) {
      String k = entry.getKey();
      PropertyMeta v = entry.getValue();
      Object fieldValue = getFieldValue(data, k, v);
      if (fieldValue == null) {
        continue;
      }
      Object currentFieldValue = format(ctx, v, fieldValue);
      values.put(k, currentFieldValue);
    }
    values.putAll(additional);
    return Base64Encoder.encodeUrlSafe(JSONUtil.toJsonStr(values));
  }

  private void addPageTitle(
      CustomRetailscmUserContextImpl ctx, Object page, EntityMeta meta, Object data) {
    setValue(page, "pageTitle", getStr(meta, "name", "默认页面"));
  }

  private void addFormId(
      CustomRetailscmUserContextImpl ctx, Object page, EntityMeta meta, Object data) {
    setValue(page, "id", data.getClass());
  }

  public static void setValue(Object page, String propertyPath, Object value) {
    BeanUtil.setProperty(page, propertyPath, value);
  }

  public void addFormClass(
      CustomRetailscmUserContextImpl ctx, Object page, Object meta, Object data) {
    ctx.forceResponseXClassHeader("com.terapico.caf.viewcomponent.GenericFormPage");
  }

  public String getPageType(BaseMeta data) {
    return getStr(data, "page-type", FORM);
  }

  private String getStr(BaseMeta data, String key, String defaultValue) {
    return data.getStr(UI_ATTRIBUTE_PREFIX + key, defaultValue);
  }

  private Integer getInt(BaseMeta data, String key, Integer defaultValue) {
    try {
      return parseInt(getStr(data, key, null));
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public boolean getBoolean(BaseMeta data, String key, boolean defaultValue) {
    return data.getBoolean(UI_ATTRIBUTE_PREFIX + key, defaultValue);
  }

  public List<String> getList(BaseMeta data, String key, List<String> defaultValue) {
    return data.getList(UI_ATTRIBUTE_PREFIX + key, defaultValue);
  }

  public static Object getProperty(Object value, String property) {
    if (value == null) {
      return null;
    }
    return BeanUtil.getProperty(value, property);
  }

  public void setFormAction(Object view, Object ret, String action) {
    setValue(view, "actionList", null);
    addValue(view, "actionList", createAction(ret, action));
  }

  public void addFormAction(Object view, Object ret, String action) {
    addValue(view, "actionList", createAction(ret, action));
  }

  public Object getAction(Object view, String action) {
    List actions = BeanUtil.getProperty(view, "actionList");
    if (ObjectUtil.isEmpty(actions)) {
      return null;
    }

    String[] actionDes = action.split(":");
    String code;
    if (actionDes.length > 1) {
      code = actionDes[1];
    } else {
      code = actionDes[0];
    }

    for (Object uiAction : actions) {
      if (code.equals(BeanUtil.getProperty(uiAction, "code"))) {
        return uiAction;
      }
    }
    return null;
  }

  public Object getField(Object view, String name) {
    List groups = BeanUtil.getProperty(view, "groupList");
    if (ObjectUtil.isEmpty(groups)) {
      return new HashMap<>();
    }
    for (Object group : groups) {
      List fieldList = BeanUtil.getProperty(group, "fieldList");
      for (Object field : fieldList) {
        if (name.equals(BeanUtil.getProperty(field, "name"))) {
          return field;
        }
      }
    }
    return new HashMap<>();
  }

  public Object checkAccess(BaseUserContext ctx, String methodName, Object[] parameters)
      throws IllegalAccessException {
    return ((CustomRetailscmUserContextImpl) ctx).needLogin();
  }

  public Object gotoNextView(BaseEntity currentView, Class<? extends BaseEntity> nextView) {
    if (ObjectUtil.isEmpty(currentView)) {
      return currentView;
    }
    if (ObjectUtil.isEmpty(nextView)) {
      return currentView;
    }
    Object o = ReflectUtil.newInstance(nextView);
    Object request = ReflectUtil.invoke(currentView, "getRequest");
    ReflectUtil.invoke(o, "setRequest", request);
    return o;
  }
}
