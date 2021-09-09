package com.doublechaintech.retailscm.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.Beans;
import com.doublechaintech.retailscm.RetailscmCheckerManager;
import com.doublechaintech.retailscm.CustomRetailscmUserContextImpl;
import com.doublechaintech.retailscm.search.BaseRequest;
import com.doublechaintech.retailscm.search.Searcher;
import com.terapico.meta.BaseMeta;
import com.terapico.meta.EntityMeta;
import com.terapico.meta.MetaProvider;
import com.terapico.meta.PropertyMeta;
import com.terapico.utils.MapUtil;
import org.springframework.beans.factory.BeanNameAware;

import java.lang.reflect.Method;
import java.util.*;

public abstract class ViewRender extends RetailscmCheckerManager implements BeanNameAware {

  public static final String FORM = "form";
  public static final String UI_ATTRIBUTE_PREFIX = "ui_";
  public static final String UI_PASS_THROUGH_ATTRIBUTE_PREFIX = "ui-";

  private String beanName;

  public String getBeanName() {
    return beanName;
  }

  @Override
  public void setBeanName(String pBeanName) {
    beanName = pBeanName;
  }

  public Object view(CustomRetailscmUserContextImpl ctx, Object data) {
    if (data == null) {
      return null;
    }

    EntityMeta meta = MetaProvider.entity(data.getClass());
    Map<String, Object> page = new HashMap<>();
    switch (getPageType(meta)) {
      case FORM:
        renderAsForm(ctx, page, meta, data);
        break;
      default:
        return data;
    }
    return page;
  }

  public Object renderAsForm(
      CustomRetailscmUserContextImpl ctx, Object page, EntityMeta meta, Object data) {
    addFormClass(ctx, page, meta, data);
    addFormId(ctx, page, meta, data);
    addPageTitle(ctx, page, meta, data);
    addFormActions(ctx, page, meta, data);
    addFormFields(ctx, page, meta, data);
    setUIPassThrough(meta, page);
    return page;
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
    addValue(group, "fieldList", formField);
  }

  private Object createFormField(
      CustomRetailscmUserContextImpl ctx,
      EntityMeta pMeta,
      String pFieldName,
      PropertyMeta pFieldMeta,
      Object pData) {
    Object fieldValue = getProperty(pData, pFieldName);
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
    if (candidates != null) {
      candidates = CollectionUtil.sub(candidates, 0, getCandidateLimit(pFieldMeta));
      String idProperty =
          getStr(pFieldMeta, "candidate-idProp", pFieldMeta.isConstant() ? "key" : "id");
      String titleProperty =
          getStr(pFieldMeta, "candidate-titleProp", pFieldMeta.isConstant() ? "value" : null);
      Object fieldIdValue = getProperty(fieldValue, idProperty);
      candidates.forEach(
          candidate -> {
            Object title;
            if (titleProperty != null) {
              title = getProperty(candidate, titleProperty);
            } else if (candidate instanceof BaseEntity) {
              title = ((BaseEntity) candidate).getDisplayName();
            } else {
              title = getProperty(candidate, idProperty);
            }

            Object uiCandidate =
                MapUtil.put("id", getProperty(candidate, idProperty))
                    .put("title", title)
                    .put(
                        "selected",
                        Objects.equals(
                            getProperty(candidate, idProperty), fieldIdValue))
                    .into_map();
            addValue(uiField, "candidateValues", uiCandidate);
          });
    }

    setUIPassThrough(pFieldMeta, uiField);
    return uiField;
  }

  private void setUIPassThrough(BaseMeta meta, Object uiElement) {
    meta.forEach(
        (k, value) -> {
          String key = (String) k;
          if (!key.startsWith(UI_PASS_THROUGH_ATTRIBUTE_PREFIX)) {
            return;
          }
          setValue(uiElement, StrUtil.removePrefix(key, UI_PASS_THROUGH_ATTRIBUTE_PREFIX), value);
        });
  }

  private List prepareCandidates(
      CustomRetailscmUserContextImpl pCtx, EntityMeta pMeta, PropertyMeta pFieldMeta, Object pData) {
    boolean ignoreCandidate = getBoolean(pFieldMeta, "no-candidate", false);
    if (ignoreCandidate) {
      return null;
    }

    String candidateAction =
        String.format("prepareCandidatesFor%s", StrUtil.upperFirst((String) pFieldMeta.get("name")));

    try {
      return invokeCandidateAction(pCtx, pData, candidateAction);
    } catch (Exception e) {

    }

    if (pFieldMeta.isObj() && pFieldMeta.isConstant()) {
      return loadConstants(pFieldMeta.getParentType());
    }

    if (pFieldMeta.isObj() && !pFieldMeta.isConstant()) {
      return loadTop(pCtx, pFieldMeta);
    }
    return null;
  }

  private List loadConstants(Class pParentType) {
    return (List)
        ReflectUtil.getStaticFieldValue(ReflectUtil.getField(pParentType, "CODE_NAME_LIST"));
  }

  public List loadTop(CustomRetailscmUserContextImpl pCtx, PropertyMeta meta) {
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
    return getInt(meta, "candidate-limit", 20);
  }

  private List invokeCandidateAction(
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
    if (value == null) {
      return null;
    }

    if (meta.isObj()) {
      return getProperty(value, "id");
    }
    return value;
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
    List<String> actions = getList(meta, "action", ListUtil.of("提交:submit"));

    actions.forEach(
          action -> {
            addValue(page, "actionList", createAction(data, action));
          }
        );
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

  public void addValue(Object page, String key, Object value) {
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
     if(data == null){
       return String.format("%s/%s/", getBeanName(), action);
     }else{
       EntityMeta entity = MetaProvider.entities.get(data.getClass().getName());
       return makeActionUrl(action, entity, data);
     }
   }

   public String makeActionUrl(String action, EntityMeta meta, Object data) {
     if (meta == null){
       return String.format("%s/%s/", getBeanName(), action);
     }else{
       ViewRender bean = Beans.getBean(ClassUtil.loadClass(meta.getType().getName() + "Processor"));
       return String.format("%s/%s/", bean.getBeanName(), action);
     }
   }

  private void addPageTitle(
      CustomRetailscmUserContextImpl ctx, Object page, EntityMeta meta, Object data) {
    setValue(page, "pageTitle", getStr(meta, "name", "默认页面"));
  }

  private void addFormId(CustomRetailscmUserContextImpl ctx, Object page, EntityMeta meta, Object data) {
    setValue(page, "id", data.getClass());
  }

  public void setValue(Object page, String propertyPath, Object value) {
    BeanUtil.setProperty(page, propertyPath, value);
  }

  public void addFormClass(CustomRetailscmUserContextImpl ctx, Object page, Object meta, Object data) {
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

  private boolean getBoolean(BaseMeta data, String key, boolean defaultValue) {
    return data.getBoolean(UI_ATTRIBUTE_PREFIX + key, defaultValue);
  }

  private List<String> getList(BaseMeta data, String key, List<String> defaultValue) {
    return data.getList(UI_ATTRIBUTE_PREFIX + key, defaultValue);
  }

  public static Object getProperty(Object value, String property){
    if (value == null){
      return null;
    }
    return BeanUtil.getProperty(value, property);
  }

  public void setFormAction(Object view, Object ret, String action) {
    setValue(view, "actionList", null);
    addValue(view, "actionList", createAction(ret, action));
  }
}

















































