package com.doublechaintech.retailscm;

import java.lang.reflect.Field;
import cn.hutool.core.collection.CollectionUtil;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.doublechaintech.retailscm.search.*;
import cn.hutool.json.JSONUtil;
import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.form.ImageInfo;
import com.terapico.caf.viewcomponent.ButtonViewComponent;
import com.terapico.utils.*;
import com.doublechaintech.retailscm.search.Searcher;
import com.google.gson.Gson;
import com.skynet.infrastructure.ConversionService;
import com.terapico.meta.*;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.collection.ListUtil;
import com.doublechaintech.retailscm.pagetype.PageType;

import static com.doublechaintech.retailscm.controller.ViewRender.UI_CANDIDATE_ATTRIBUTE_PREFIX;

public class RetailscmBaseUtils {
  protected static final Map<String, Object> emptyOptions = new HashMap<>();
  protected static final Map<String, Object> EO = new HashMap<>();

  public static <T> T ifNull(T input, T defaultVal) {
    return TextUtil.isBlank(input) ? defaultVal : input;
  }

  public static <T> T orNull(Callable<T> call) {
    return orElse(call, null);
  }

  public static <T> T orElse(Callable<T> call, T defaultValue) {
    try {
      return call.call();
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public static String getOssUploadFolderName(String tokenType, String token, boolean isProdEnv) {
    String folderName;
    folderName = String.format("upload%s/%s/%s", isProdEnv ? "" : "/test", tokenType, token);
    return folderName;
  }

  public static String hashWithSHA256(String valueToHash, String salt) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      String textToHash = valueToHash + ":" + salt;
      byte[] hash = digest.digest(textToHash.getBytes(StandardCharsets.UTF_8));
      StringBuilder stringBuilder = new StringBuilder();
      for (byte b : hash) {
        stringBuilder.append(String.format("%02X", b));
      }
      return stringBuilder.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException(e);
    }
  }

  public static String formatChinaMobile(String mobile) {
    return TextUtil.formatChinaMobile(mobile);
  }

  public static String checkChinaMobile(String mobile) throws Exception {
    String cleanMobile = formatChinaMobile(mobile);
    if (cleanMobile == null) {
      throw new ErrorMessageException(
          "您输入的"
              + ifNull(mobile, "(无)")
              + orElse(() -> "(长度" + mobile.length() + ")", "")
              + "不是有效的中国大陆手机号");
    }
    return cleanMobile;
  }

  public static String getCacheAccessKey(RetailscmUserContext ctx) {
    return ctx.tokenId() + ":access_page_without_footprint";
  }

  public static <T> Set<Object> toSet(List<T> list, Function<T, ? extends Object> mapper) {
    return list.stream().map(mapper).collect(Collectors.toSet());
  }

  protected static BaseEntity loadCanCacheInLocal(
      RetailscmUserContext userContext, String type, String id) throws Exception {
    String key = "baseentity:" + type + ":" + id;
    BaseEntity result = (BaseEntity) userContext.getFromContextLocalStorage(key);
    if (result != null) {
      return result;
    }
    result = userContext.getDAOGroup().loadBasicData(type, id);
    userContext.putIntoContextLocalStorage(key, result);
    return result;
  }

  public static <T extends BaseEntity> List<T> collectReferencedObjectWithType(
      RetailscmUserContext userContext, BaseEntity rootObject, Class<T> clazz) throws Exception {
    List<T> referedObject = new LinkedList<>();
    Set<Object> checkedObject = new HashSet<>();
    collectReferedObjectIdSet(userContext, referedObject, checkedObject, rootObject, clazz, "/");
    return referedObject;
  }

  public static <T extends BaseEntity> List<T> collectReferencedObjectWithType(
      RetailscmUserContext userContext,
      SmartList<? extends BaseEntity> rootObjectList,
      Class<T> clazz)
      throws Exception {
    return collectReferencedObjectWithType(userContext, (List<BaseEntity>) rootObjectList, clazz);
  }

  public static <T extends BaseEntity> List<T> collectReferencedObjectWithType(
      RetailscmUserContext userContext, List<? extends BaseEntity> rootObjectList, Class<T> clazz)
      throws Exception {
    List<T> referedObject = new LinkedList<>();
    Set<Object> checkedObject = new HashSet<>();
    if (rootObjectList == null || rootObjectList.isEmpty()) {
      return referedObject;
    }
    for (BaseEntity refObj : rootObjectList) {
      collectReferedObjectIdSet(userContext, referedObject, checkedObject, refObj, clazz, "/");
    }
    return referedObject;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  private static <T extends BaseEntity> void collectReferedObjectIdSet(
      RetailscmUserContext userContext,
      List<T> referedObject,
      Set<Object> checkedObject,
      BaseEntity rootObject,
      Class<T> clazz,
      String path)
      throws Exception {
    if (rootObject == null) {
      return;
    }
    if (checkedObject.contains(rootObject)) {
      return;
    }
    checkedObject.add(rootObject);
    String pathKey = rootObject.hashCode() + "/";
    if (path.contains("/" + pathKey)) {
      // System.out.println("skip, since already collected object " + rootObject);
      return;
    }
    path += pathKey;
    if (clazz.isAssignableFrom(rootObject.getClass())) {
      referedObject.add((T) rootObject);
    }
    Field[] fields = ReflectUtil.getFields(rootObject.getClass());
    for (Field field : fields) {
      boolean isStatic = Modifier.isStatic(field.getModifiers());
      if (isStatic) {
        continue;
      }
      field.setAccessible(true);
      Object value = field.get(rootObject);
      if (List.class.isAssignableFrom(field.getType())) {
        field.setAccessible(true);
        List fieldList = (List) value;
        if (fieldList != null && !fieldList.isEmpty()) {
          for (int i = 0; i < fieldList.size(); i++) {
            Object objData = fieldList.get(i);
            if (objData instanceof BaseEntity) {
              collectReferedObjectIdSet(
                  userContext, referedObject, checkedObject, (BaseEntity) objData, clazz, path);
            }
          }
        }
        continue;
      }
      if (value instanceof BaseEntity) {
        collectReferedObjectIdSet(
            userContext, referedObject, checkedObject, (BaseEntity) value, clazz, path);
        continue;
      }
    }
  }

  public static String getImageFromArray(List<ImageInfo> imageArray, int idx) {
    if (imageArray == null || imageArray.size() <= idx) {
      return null;
    }
    return imageArray.get(idx).getImageUrl();
  }

  public static boolean isDivisible(BigDecimal divisor, BigDecimal dividend) throws Exception {
    if (dividend.signum() == 0) {
      throw new Exception("请不要输入0");
    }
    BigDecimal[] quotient = divisor.divideAndRemainder(dividend);
    if (quotient.length == 1) {
      return true;
    }
    if (quotient[1].signum() == 0) {
      return true;
    }
    return false;
  }

  static Pattern ptnVersionSegment = Pattern.compile("\\d+");

  public static int getBuildVersion(String appVersionStr) {
    if (appVersionStr == null || appVersionStr.isEmpty()) {
      return 0;
    }
    int pos = appVersionStr.lastIndexOf(".");
    if (pos < 0) {
      return Integer.parseInt(appVersionStr);
    }
    // return Integer.parseInt(appVersionStr.substring(pos+1));
    List<String> list = TextUtil.findAllMatched(appVersionStr, ptnVersionSegment);
    return Integer.parseInt(list.get(0));
  }

  public static int getAppBuildVersion(RetailscmUserContext ctx) {
    return getBuildVersion(getRequestAppVersion(ctx));
  }

  protected static boolean startFromVersion(RetailscmUserContext ctx, int version) {
    if (!ctx.isProductEnvironment()) {
      return true;
    }
    return getAppBuildVersion(ctx) >= version;
  }
  /*
   * "x-app-device" : "EML-AL00",
   * "x-app-type" : "CommunityUser",
   * "X-Forwarded-For" : "123.121.90.15",
   * "X-Real-IP" : "123.121.90.15",
   * "X-Forwarded-Server" : "app.art0x.com",
   * "x-app-version" : "9"
   */
  public static String getRequestAppVersion(RetailscmUserContext userContext) {
    return userContext.getRequestHeader("x-app-version");
  }

  public static String getRequestAppDevice(RetailscmUserContext userContext) {
    return userContext.getRequestHeader("x-app-device");
  }

  public static String getRequestAppType(RetailscmUserContext userContext) {
    return userContext.getRequestHeader("x-app-type");
  }

  protected static final NumberFormat cashFormat = new DecimalFormat("#,##0.00");
  protected static final NumberFormat exRateFormat = new DecimalFormat("#,##0.00#");

  public static String formatCash(BigDecimal amount) {
    return cashFormat.format(amount) + "元";
  }

  public static String formatExchangeRate(BigDecimal amount) {
    return exRateFormat.format(amount);
  }

  public static PageType getPageType(RetailscmUserContext userContext, String code)
      throws Exception {
    String key = "enum:" + PageType.INTERNAL_TYPE + ":" + code;
    PageType data = (PageType) userContext.getFromContextLocalStorage(key);
    if (data != null) {
      return data;
    }
    data = userContext.getDAOGroup().getPageTypeDAO().loadByCode(code, emptyOptions);
    userContext.putIntoContextLocalStorage(key, data);
    return data;
  }

  public static <T> T loadBaseEntityById(RetailscmUserContext ctx, String type, String id)
      throws Exception {
    return loadBaseEntityById(ctx, type, id, null);
  }

  public static <T> T loadBaseEntityById(
      RetailscmUserContext ctx, String type, String id, Consumer<T> enhancer) throws Exception {
    String key = type + ":" + id;
    BaseEntity cachedValue = (BaseEntity) ctx.getFromContextLocalStorage(key);
    if (cachedValue != null) {
      if (cachedValue.getInternalType().equals(type) && cachedValue.getId().equals(id)) {
        return (T) cachedValue;
      }
    }
    T enObj = (T) ctx.getDAOGroup().loadBasicData(type, id);
    if (enhancer != null) {
      enhancer.accept(enObj);
    }
    ctx.putIntoContextLocalStorage(key, enObj);
    return enObj;
  }

  public static <T extends BaseEntity> void appendLinkToUrl(
      RetailscmUserContext ctx, List<T> list, Function<T, String> makeFunc) {
    if (list == null || list.isEmpty()) {
      return;
    }
    list.forEach(
        it -> {
          it.addItemToValueMap(RetailscmBaseConstants.X_LINK_TO_URL, makeFunc.apply(it));
        });
  }

  public static <T extends BaseEntity> void appendLinkToUrl(
      RetailscmUserContext ctx, T obj, String url) {
    if (obj == null) {
      return;
    }
    obj.addItemToValueMap(RetailscmBaseConstants.X_LINK_TO_URL, url);
  }

  public static ButtonViewComponent addAction(
      RetailscmUserContext ctx, BaseEntity obj, String title, String code, String linkToUrl) {
    ButtonViewComponent actionBtn = new ButtonViewComponent(title, null, code);
    actionBtn.setLinkToUrl(linkToUrl);
    List<ButtonViewComponent> actions = (List<ButtonViewComponent>) obj.valueByKey("actionList");
    if (actions == null) {
      actions = new ArrayList<>();
      obj.addItemToValueMap("actionList", actions);
    }
    actions.add(actionBtn);
    return actionBtn;
  }

  public static void setAction(
      RetailscmUserContext ctx, BaseEntity obj, String title, String code, String linkToUrl) {
    ButtonViewComponent actionBtn = new ButtonViewComponent(title, null, code);
    actionBtn.setLinkToUrl(linkToUrl);
    obj.addItemToValueMap("action", actionBtn);
  }

  public static void ensureTable(
      RetailscmUserContext userContext,
      Map<String, Object> result,
      String tableName,
      String[][] fieldInfo,
      String title,
      String[] indexSqls,
      String[] constraintSqls)
      throws Exception {
    // throw new Exception("RetailscmBaseUtils::ensureTable()尚未实现");

    DBQuerier querier = (DBQuerier) userContext.getBean("dbQuerier");
    Map<String, Object> checkResult =
        DBChecker.verifyTable(
            "retailscm", tableName, title, fieldInfo, indexSqls, constraintSqls, querier);

    boolean success = DataTypeUtil.getBoolean(checkResult.get("result"), null); // if null, it's bug
    List<String> report = (List<String>) result.get("ensureTableReport");
    if (report == null) {
      report = new ArrayList<>();
      result.put("ensureTableReport", report);
    }
    report.add("\r\n");
    if (success) {
      report.add("## " + tableName + " is ready");
    } else {
      report.add("## " + tableName + " is different with current model");
      report.add("## " + (String) checkResult.get("message"));
      report.add("## use below sql to update");
      report.add((String) checkResult.get("sql"));
    }
  }

  public static void ensureDataByCode(
      RetailscmUserContext userContext,
      Map<String, Object> result,
      String tableName,
      String[][] rowData)
      throws Exception {
    // throw new Exception("RetailscmBaseUtils::ensureDataByCode()尚未实现");
    DBQuerier querier = (DBQuerier) userContext.getBean("dbQuerier");
    Map<String, Object> checkResult = DBChecker.verifyData(tableName, rowData, querier);
    List<String> report = (List<String>) result.get("ensureDataReport");
    if (report == null) {
      report = new ArrayList<>();
      result.put("ensureDataReport", report);
    }
    report.add("\r\n");
    boolean success = DataTypeUtil.getBoolean(checkResult.get("result"), null); // if null, it's bug
    if (success) {
      report.add("## " + tableName + " data is ready");
    } else {
      report.add("## " + tableName + " data is different with current model");
      report.add("## use below sql to update");
      report.add((String) checkResult.get("sql"));
    }
  }

  public static void enhanceRequest(BaseRequest request) {
    createParentRequests(request);
    createSubRequests(request);
  }

  public static void createParentRequests(BaseRequest request) {
    Class current = internalTypeToClass(request.getInternalType());
    String parentLinkName = getParentLinkName(request.getInternalType());
    if (ObjectUtil.isEmpty(parentLinkName)) {
      return;
    }
    BaseRequest parentRequest = getParentRequest(request);
    if (parentRequest == null) {
      parentRequest = createSimpleRequest(getDirectParent(current));
      request.selectParent(parentLinkName, parentRequest);
    }
    createParentRequests(parentRequest);
  }

  public static BaseRequest getParentRequest(BaseRequest request) {
    String parentLinkName = getParentLinkName(request.getInternalType());
    if (ObjectUtil.isEmpty(parentLinkName)) {
      return null;
    }
    return (BaseRequest) request.getParentSelects().get(parentLinkName);
  }

  public static void createSubRequests(BaseRequest request) {
    Class current = internalTypeToClass(request.getInternalType());
    List<Class> directSubClasses = getDirectSubClasses(current);
    if (ObjectUtil.isEmpty(directSubClasses)) {
      return;
    }
    for (Class directSubClass : directSubClasses) {
      BaseRequest simpleRequest = createSimpleRequest(directSubClass);
      String parentLinkName = getParentLinkName(directSubClass.getName());
      BaseRequest child =
          (BaseRequest)
              request.getChildrenSelects().get(simpleRequest.getInternalType() + parentLinkName);
      if (child == null) {
        child = simpleRequest;
        request.selectChild(parentLinkName, simpleRequest);
      }
      createSubRequests(child);
    }
  }

  public static Class getDirectParent(Class clazz) {
    PropertyMeta parentLinkProperty = getParentLinkProperty(clazz);
    if (parentLinkProperty == null) {
      return null;
    }
    String parentType = (String) parentLinkProperty.get("parentType");
    return internalTypeToClass(parentType);
  }

  public static <T extends BaseEntity> T getType(BaseEntity entity, Class<T> type) {
    if (entity == null || type == null) {
      return null;
    }

    if (type.isAssignableFrom(entity.getClass())) {
      return (T) entity;
    }

    List<Class> parentClasses = getParentClasses(entity.getClass());
    boolean isParent = CollectionUtil.findOne(parentClasses, c -> c.isAssignableFrom(type)) != null;
    if (isParent) {
      BaseEntity item = entity;
      while (item != null) {
        if (type.isAssignableFrom(item.getClass())) {
          return (T) item;
        }
        String parentLinkName = getParentLinkName(item.getInternalType());
        if (ObjectUtil.isEmpty(parentLinkName)) {
          return null;
        }
        item = (BaseEntity) item.propertyOf(parentLinkName);
      }
      return null;
    }

    List<Class> childrenClasses = getSubClasses(internalTypeToClass(entity.getInternalType()));
    boolean isChild =
        CollectionUtil.findOne(childrenClasses, c -> c.isAssignableFrom(type)) != null;
    if (!isChild) {
      return null;
    }
    BaseEntity item = entity;
    boolean tryFindSub = true;
    while (tryFindSub) {
      List<BaseEntity> subList = getSubList(item);
      Set<Class> subTypes = new HashSet<>(getDirectSubClasses(item.getClass()));
      tryFindSub = false;
      for (BaseEntity child : subList) {
        if (type.isAssignableFrom(child.getClass())) {
          return (T) child;
        }
        if (subTypes.contains(internalTypeToClass(child.getInternalType()))) {
          item = child;
          tryFindSub = true;
          break;
        }
      }
    }
    return null;
  }

  public static List<Class> getDirectSubClasses(Class clazz) {
    if (clazz == null) {
      return Collections.emptyList();
    }
    EntityMeta entityMeta = MetaProvider.entities.get(clazz.getName());
    if (entityMeta == null) {
      return getDirectSubClasses(clazz.getSuperclass());
    }
    List childrenTypes = (List) entityMeta.get("childrenTypes");
    if (ObjectUtil.isEmpty(childrenTypes)) {
      return Collections.emptyList();
    }
    List<Class> rets = new ArrayList<>();
    for (Object childrenType : childrenTypes) {
      Class sub = internalTypeToClass((String) childrenType);
      rets.add(sub);
    }
    return rets;
  }

  public static Map<String, Object> itemView(BaseEntity entity) {
    return itemView(entity, false);
  }

  /**
   * entity的common view，尝试展开entity的所有属性，如果引用的是对象，则 通用的展开为id, displayName
   *
   * @param entity
   * @return
   */
  public static Map<String, Object> itemView(BaseEntity entity, boolean withLabel) {
    if (entity == null) {
      return Collections.emptyMap();
    }

    List<Class> all = guessTypes(entity.getInternalType());
    Map<String, Object> view = new LinkedHashMap<>();
    for (Class aClass : all) {
      BaseEntity item = null;
      try {
        item = getType(entity, aClass);
      } catch (Exception pE) {
      }
      if (item == null) {
        continue;
      }
      String[] propertyNames = item.getPropertyNames();
      Map<String, Object> additionalInfo = new HashMap<>(item.getAdditionalInfo());
      for (String propertyName : propertyNames) {
        Object o = additionalInfo.remove(propertyName);
        if (o == null) {
          o = ReflectUtil.getFieldValue(item, propertyName);
        }
        if (withLabel) {
          propertyName =
              MetaProvider.entity(internalTypeToClass(item.getInternalType()))
                  .property(propertyName)
                  .getStr("zh_CN", propertyName);
        }
        view.putIfAbsent(propertyName, o);
      }
      view.putAll(additionalInfo);
    }
    view.putIfAbsent("displayName", entity.getDisplayName());
    return view;
  }

  public static <T extends BaseEntity> T buildItem(
      CustomRetailscmUserContextImpl ctx, Class<T> type) {
    String requestParameter = getFormData(ctx);
    if (ObjectUtil.isEmpty(requestParameter)) {
      return buildItemFromBody(ctx, type);
    }
    return buildItemFromFormData(ctx, type, requestParameter);
  }

  private static <T extends BaseEntity> T buildItemFromBody(
      CustomRetailscmUserContextImpl ctx, Class<T> type) {
    byte[] requestBody = ctx.getRequestBody();
    Gson gson = new Gson();
    return gson.fromJson(new String(requestBody), type);
  }

  private static <T extends BaseEntity> T buildItemFromFormData(
      CustomRetailscmUserContextImpl ctx, Class<T> type, String requestParameter) {
    Gson gson = new Gson();
    System.out.println("formDate:" + requestParameter);
    Map map = gson.fromJson(requestParameter, Map.class);
    return buildItem(ctx, (Map<String, Object>) map, type);
  }

  private static String getFormData(CustomRetailscmUserContextImpl ctx) {
    String[] requestParameters = (String[]) ctx.getRequestParameters().get("formData");
    String requestParameter = null;
    if (requestParameters != null && requestParameters.length > 0) {
      requestParameter = requestParameters[0];
    }
    return requestParameter;
  }

  public static <T extends BaseEntity> T buildItem(
      CustomRetailscmUserContextImpl ctx, Map<String, Object> data, Class<T> type) {
    String req = (String) data.get("_req");
    if (!ObjectUtil.isEmpty(req)) {
      ctx.putIntoContextLocalStorage("_req", req);
      String cachedObject = ctx.getCachedObject(req, String.class);
      if (cachedObject == null) {
        ctx.putToCache(req, req, 10);
      } else {
        throw new com.doublechaintech.retailscm.form.DuplicatedFormException("你的请求已处理，请勿重复提交！");
      }
    }
    try {
      T t = type.newInstance();
      String[] propertyNames = t.getPropertyNames();
      for (String propertyName : propertyNames) {
        if (!data.containsKey(propertyName)) {
          continue;
        }
        Object propertyValue = data.remove(propertyName);
        updatePropertyValue(ctx, data, t, propertyName, propertyValue);
      }

      PropertyMeta parentLinkProperty = getParentLinkProperty(type);
      if (parentLinkProperty != null) {
        String parentProperty = (String) parentLinkProperty.get("name");
        BaseEntity parent = (BaseEntity) t.propertyOf(parentProperty);
        if (parent == null) {
          Method updateMethod =
              ReflectUtil.getMethodByName(type, "update" + StrUtil.upperFirst(parentProperty));
          updateMethod.invoke(t, buildItem(ctx, data, getDirectParent(type)));
        }
      }
      return t;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private static <T extends BaseEntity> void updatePropertyValue(
      CustomRetailscmUserContextImpl ctx,
      Map<String, Object> data,
      T t,
      String propertyName,
      Object propertyValue)
      throws Exception {
    boolean ignoreForm =
        MetaProvider.entity(internalTypeToClass(t.getInternalType()))
            .property(propertyName)
            .getBoolean("ui_ignore-form", false);
    if (ignoreForm) {
      return;
    }
    Method updateMethod =
        ReflectUtil.getMethodByName(t.getClass(), "update" + StrUtil.upperFirst(propertyName));
    Class<?> parameterType = updateMethod.getParameterTypes()[0];

    if (BaseEntity.class.isAssignableFrom(parameterType)) {
      try {
        propertyValue =
            convertToType(ctx, t.getClass(), parameterType, propertyName, propertyValue);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        return;
      }
      updateMethod.invoke(t, propertyValue);
    } else if (String.class.isAssignableFrom(parameterType)
        && (propertyValue instanceof Collection || propertyValue instanceof Map)) {
      updateMethod.invoke(t, JSONUtil.toJsonStr(propertyValue));
    } else {
      updateMethod.invoke(t, getConversionService().convert(propertyValue, parameterType));
    }
  }

  private static ConversionService getConversionService() {
    return new ConversionService();
  }

  private static Object convertToType(
      CustomRetailscmUserContextImpl ctx,
      Class<? extends BaseEntity> ownerType,
      Class<?> referType,
      String propertyName,
      Object propertyValue)
      throws Exception {
    if (propertyValue == null) {
      return null;
    }

    if (referType.isAssignableFrom(propertyValue.getClass())) {
      return propertyValue;
    }

    String valueProp =
        MetaProvider.entity(ownerType)
            .property(propertyName)
            .getStr(UI_CANDIDATE_ATTRIBUTE_PREFIX + "id", "id");

    String value;
    if (propertyValue instanceof String) {
      value = (String) propertyValue;
    } else {
      value = BeanUtil.getProperty(propertyValue, valueProp);
    }

    if (StrUtil.isEmpty(value)) {
      return null;
    }

    // 值 是id时，使用with id
    Method withId = ReflectUtil.getMethod(referType, "withId", String.class);
    if ("id".equals(valueProp)) {
      return ReflectUtil.invokeStatic(withId, value);
    } else if ("name".equals(valueProp)) {
      // 常量时可以不查询数据库
      if (MetaProvider.entity(referType).isConstant()) {
        Method getCode = ReflectUtil.getMethod(referType, "getCode", String.class);
        String code = ReflectUtil.invokeStatic(getCode, value);
        Object o = ReflectUtil.invokeStatic(withId, code);
        ReflectUtil.invoke(o, "updateName", value);
        return o;
      }
    }
    BaseEntity o = (BaseEntity) ReflectUtil.newInstance(referType);
    ReflectUtil.invoke(o, "setPropertyOf", valueProp, value);
    BaseEntity dbItem = reload(ctx, o);
    if (dbItem == null) {
      return o;
    }
    return dbItem;
  }

  private static BaseRequest createSimpleRequest(Class type) {
    String aPackage = ClassUtil.getPackage(type);
    Class<? extends BaseRequest> requestClass =
        ClassUtil.loadClass(aPackage + "." + type.getSimpleName() + "Request");
    Method newInstance = ClassUtil.getDeclaredMethod(requestClass, "newInstance");
    BaseRequest request = ReflectUtil.invokeStatic(newInstance);
    Method selectAll = ClassUtil.getDeclaredMethod(requestClass, "selectAll");
    ReflectUtil.invoke(request, selectAll);
    Method unlimited = ClassUtil.getDeclaredMethod(requestClass, "unlimited");
    ReflectUtil.invoke(request, unlimited);
    return request;
  }

  private static BaseRequest createSimpleSelfRequest(Class type) {
    String aPackage = ClassUtil.getPackage(type);
    Class<? extends BaseRequest> requestClass =
        ClassUtil.loadClass(aPackage + "." + type.getSimpleName() + "Request");
    Method newInstance = ClassUtil.getDeclaredMethod(requestClass, "newInstance");
    BaseRequest request = ReflectUtil.invokeStatic(newInstance);
    Method selectSelf = ClassUtil.getDeclaredMethod(requestClass, "selectSelf");
    ReflectUtil.invoke(request, selectSelf);
    return request;
  }

  private static List<Class> guessTypes(String pInternalType) {
    Class internalClass = internalTypeToClass(pInternalType);
    Set<Class> possibleTypes = new LinkedHashSet<>();
    possibleTypes.addAll(getParentClasses(internalClass));
    possibleTypes.add(internalClass);
    possibleTypes.addAll(getSubClasses(internalClass));
    return new ArrayList<>(possibleTypes);
  }

  private static List<BaseEntity> getSubList(BaseEntity entity) {
    if (entity == null) {
      return Collections.emptyList();
    }

    List<BaseEntity> entityList = new ArrayList<>();
    List<SmartList<?>> allRelatedLists = entity.getAllRelatedLists();
    for (SmartList<?> allRelatedList : allRelatedLists) {
      entityList.addAll(allRelatedList);
    }
    return entityList;
  }

  public static <T extends BaseEntity> T getItem(BaseEntity pAsset, Class<T> pClass)
      throws Exception {
    List<T> assets = collectReferencedObjectWithType(null, pAsset, pClass);
    if (!assets.isEmpty()) {
      return assets.get(0);
    }
    return null;
  }

  public static Class internalTypeToClass(String internalType) {
    internalType =
        StrUtil.sub(internalType, internalType.lastIndexOf('.') + 1, internalType.length());
    String internalClass =
        ClassUtil.getPackage(BaseEntity.class)
            + "."
            + internalType.toLowerCase()
            + "."
            + internalType;
    return ClassUtil.loadClass(internalClass);
  }

  public static List<Class> getSubClasses(Class clazz) {
    if (clazz == null) {
      return Collections.emptyList();
    }

    EntityMeta entityMeta = MetaProvider.entities.get(clazz.getName());
    if (entityMeta == null) {
      return getSubClasses(clazz.getSuperclass());
    }

    List childrenTypes = (List) entityMeta.get("childrenTypes");
    if (ObjectUtil.isEmpty(childrenTypes)) {
      return Collections.emptyList();
    }
    List<Class> rets = new ArrayList<>();
    for (Object childrenType : childrenTypes) {
      Class sub = internalTypeToClass((String) childrenType);
      List<Class> subOfSub = getSubClasses(sub);
      rets.addAll(subOfSub);
      rets.add(sub);
    }
    return rets;
  }

  public static List<Class> getParentClasses(Class clazz) {
    PropertyMeta parentLinkProperty = getParentLinkProperty(clazz);
    if (parentLinkProperty == null) {
      return Collections.emptyList();
    }
    List<Class> parents = new ArrayList<>();
    String parentType = (String) parentLinkProperty.get("parentType");
    Class aClass = internalTypeToClass(parentType);
    parents.add(aClass);
    parents.addAll(getParentClasses(aClass));
    return parents;
  }

  public static PropertyMeta getParentLinkProperty(Class clazz) {
    if (clazz == null) {
      return null;
    }
    EntityMeta entity = MetaProvider.entities.get(clazz.getName());
    if (entity == null) {
      return getParentLinkProperty(clazz.getSuperclass());
    }

    Map<String, PropertyMeta> properties = entity.getProperties();
    for (PropertyMeta property : properties.values()) {
      if (Boolean.valueOf((String) property.get("parentLink"))) {
        return property;
      }
    }
    return null;
  }

  public static String getParentLinkName(String type) {
    PropertyMeta parentLinkProperty = getParentLinkProperty(internalTypeToClass(type));
    if (parentLinkProperty == null) {
      return null;
    }
    return parentLinkProperty.getStr("name", null);
  }

  public static <T extends BaseEntity> T ensure(
      RetailscmUserContext ctx, T item, Consumer<T> enhancer) throws Exception {
    if (item == null) {
      return null;
    }
    T dbItem = reload(ctx, item);
    if (dbItem == null) {
      if (enhancer != null) {
        enhancer.accept(item);
      }
      return saveItem(ctx, item);
    }
    return dbItem;
  }

  public static <T extends BaseEntity> T saveItem(RetailscmUserContext ctx, T pItem)
      throws Exception {
    if (pItem == null) {
      return null;
    }
    ReflectUtil.invoke(ctx.getChecker(), "checkAndFix" + pItem.getInternalType(), pItem);
    ctx.getChecker().throwExceptionIfHasErrors(RetailscmException.class);
    Object bean = Beans.getBean(StrUtil.lowerFirst(pItem.getInternalType()) + "Manager");
    return ReflectUtil.invoke(
        bean,
        "internalSave" + pItem.getInternalType(),
        ctx,
        pItem,
        MapUtil.of("__all__", "__all__"));
  }

  // 只处理string或引用类型的相等
  public static <T extends BaseEntity> T reload(RetailscmUserContext ctx, T pItem)
      throws Exception {
    BaseRequest request = createReloadRequest(pItem);
    return (T) Searcher.searchOne(ctx, request);
  }

  public static <T extends BaseEntity> T reloadSelf(RetailscmUserContext ctx, T pItem)
      throws Exception {
    BaseRequest request = createReloadSelfRequest(pItem);
    return (T) Searcher.searchOne(ctx, request);
  }

  private static <T extends BaseEntity> BaseRequest createReloadSelfRequest(T pItem) {
    BaseRequest request = createSimpleSelfRequest(internalTypeToClass(pItem.getInternalType()));
    String[] propertyNames = pItem.getPropertyNames();
    for (String propertyName : propertyNames) {
      Object propertyValue = pItem.propertyOf(propertyName);
      if (propertyValue == null) {
        continue;
      }
      // 处理string
      if (propertyValue instanceof String) {
        ReflectUtil.invoke(
            request, "where", propertyName, QueryOperator.EQUAL, new Object[] {propertyValue});
      }

      // 日期
      if (propertyValue instanceof Date) {
        ReflectUtil.invoke(
            request, "where", propertyName, QueryOperator.EQUAL, new Object[] {propertyValue});
      }

      // 处理引用
      if (propertyValue instanceof BaseEntity) {
        if (((BaseEntity) propertyValue).getId() != null) {
          ReflectUtil.invoke(
              request, "where", propertyName, QueryOperator.EQUAL, new Object[] {propertyValue});
        } else {
          ReflectUtil.invoke(
              request,
              "filterBy" + StrUtil.upperFirst(propertyName),
              createReloadRequest((BaseEntity) propertyValue));
        }
      }

      if ("id".equals(propertyName)) {
        break;
      }
    }
    return request;
  }

  public static <T extends BaseEntity> BaseRequest createReloadRequest(T pItem) {
    BaseRequest request = createSimpleRequest(internalTypeToClass(pItem.getInternalType()));
    String[] propertyNames = pItem.getPropertyNames();
    for (String propertyName : propertyNames) {
      Object propertyValue = pItem.propertyOf(propertyName);
      if (propertyValue == null) {
        continue;
      }
      // 处理string
      if (propertyValue instanceof String) {
        ReflectUtil.invoke(
            request, "where", propertyName, QueryOperator.EQUAL, new Object[] {propertyValue});
      }

      // 日期
      if (propertyValue instanceof Date) {
        ReflectUtil.invoke(
            request, "where", propertyName, QueryOperator.EQUAL, new Object[] {propertyValue});
      }

      // 处理引用
      if (propertyValue instanceof BaseEntity) {
        if (((BaseEntity) propertyValue).getId() != null) {
          ReflectUtil.invoke(
              request, "where", propertyName, QueryOperator.EQUAL, new Object[] {propertyValue});
        } else {
          ReflectUtil.invoke(
              request,
              "filterBy" + StrUtil.upperFirst(propertyName),
              createReloadRequest((BaseEntity) propertyValue));
        }
      }

      if ("id".equals(propertyName)) {
        break;
      }
    }
    return request;
  }

  public static Map<String, Object> collectSubInfo(BaseEntity entity) {
    if (entity == null) {
      return Collections.emptyMap();
    }
    List<SmartList<?>> allRelatedLists = entity.getAllRelatedLists();
    Map<String, Object> ret = new HashMap<>();
    allRelatedLists.stream().flatMap(l -> l.stream()).forEach(e -> ret.putAll(itemView(e)));
    return ret;
  }

  public static <T extends BaseEntity> T getParent(BaseEntity entity) {
    if (entity == null) {
      return null;
    }
    Class directParent = getDirectParent(internalTypeToClass(entity.getInternalType()));
    return (T) getType(entity, directParent);
  }

  public static <T extends BaseEntity> T getChild(BaseEntity entity) {
    if (entity == null) {
      return null;
    }
    List<Class> subs = getDirectSubClasses(internalTypeToClass(entity.getInternalType()));
    for (Class sub : subs) {
      BaseEntity item = getType(entity, sub);
      if (item != null) {
        return (T) item;
      }
    }
    return null;
  }

  public static <T extends BaseEntity> void saveItemSelf(RetailscmUserContext ctx, T... pItems)
      throws Exception {
    saveItemSelf(ctx, ListUtil.of(pItems));
  }

  public static <T extends BaseEntity> void saveItemSelf(RetailscmUserContext ctx, List<T> pItems)
      throws Exception {
    if (ObjectUtil.isEmpty(pItems)) {
      return;
    }

    for (T item : pItems) {
      ReflectUtil.invoke(ctx.getChecker(), "checkAndFix" + item.getInternalType(), item);
      ctx.getChecker().throwExceptionIfHasErrors(RetailscmException.class);
    }

    T item = pItems.get(0);
    Object bean = Beans.getBean(StrUtil.lowerFirst(item.getInternalType()) + "DAO");
    ReflectUtil.invoke(
        bean,
        "save" + item.getInternalType() + "List",
        new SmartList<T>(pItems),
        MapUtil.of("__all__", "__all__"));
  }

  public static <T extends BaseEntity> void saveGraph(RetailscmUserContext ctx, T... pItems)
      throws Exception {
    saveGraph(ctx, ListUtil.of(pItems), new ArrayList<>());
  }

  public static void saveGraph(RetailscmUserContext ctx, List<BaseEntity> pItems) throws Exception {
    saveGraph(ctx, pItems, new ArrayList<>());
  }

  private static void saveGraph(
      RetailscmUserContext ctx, List<BaseEntity> nodes, List<BaseEntity> handled) throws Exception {
    nodes = removeHandledNodes(nodes, handled);
    if (ObjectUtil.isEmpty(nodes)) {
      return;
    }
    BaseEntity t = nodes.get(0);
    Map<String, Class<? extends BaseEntity>> parentProperties = t.getParentProperties();
    Set<String> parentProperNames = parentProperties.keySet();

    // save parents
    for (String parentProperName : parentProperNames) {
      List<BaseEntity> parentNodes =
          nodes.stream()
              .map(item -> (BaseEntity) item.propertyOf(parentProperName))
              .filter(item -> item != null)
              .collect(Collectors.toList());
      saveGraph(ctx, parentNodes, handled);
    }

    // save item self
    List<BaseEntity> currentNodes =
        new ArrayList<>(
            CollectionUtil.filterNew(
                nodes, n -> n.isChanged() || n.isToRemove() || n.isToRecover()));
    saveItemSelf(ctx, currentNodes);

    // save children
    List<BaseEntity> children = new ArrayList<>();
    for (BaseEntity node : nodes) {
      List<SmartList<?>> allRelatedLists = node.getAllRelatedLists();
      for (SmartList<?> allRelatedList : allRelatedLists) {
        children.addAll(allRelatedList);
      }
    }

    Map<String, List<BaseEntity>> parentsByType =
        children.stream().collect(Collectors.groupingBy(BaseEntity::getInternalType));

    for (List<BaseEntity> value : parentsByType.values()) {
      saveGraph(ctx, value, handled);
    }
  }

  private static List<BaseEntity> removeHandledNodes(
      List<BaseEntity> pItems, List<BaseEntity> handled) {
    List<BaseEntity> nodes = new ArrayList<>();
    for (BaseEntity item : pItems) {
      if (item == null) {
        continue;
      }
      // 已经加到列表里
      BaseEntity duplicate = CollectionUtil.findOne(nodes, i -> i == item);
      if (duplicate != null) {
        continue;
      }

      // 已经处理过
      BaseEntity existing = CollectionUtil.findOne(handled, i -> i == item);
      if (existing != null) {
        continue;
      }

      // 加到列表里
      nodes.add(item);
      handled.add(item);
    }
    return nodes;
  }
}
