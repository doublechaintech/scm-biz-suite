package com.doublechaintech.retailscm;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import java.net.URLEncoder;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.skynet.infrastructure.GraphService;
import com.terapico.caf.baseelement.Event;
import com.terapico.caf.BlobObject;
import com.terapico.caf.xls.Block;
import com.skynet.infrastructure.EventService;
import com.skynet.infrastructure.graphservice.GraphServiceImpl;
import com.skynet.infrastructure.TokenTool;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.utils.*;

import com.doublechaintech.retailscm.listaccess.ListAccess;
import org.springframework.beans.factory.BeanNameAware;
import java.math.BigDecimal;

import com.terapico.uccaf.AccessControledService;
import com.terapico.uccaf.BaseUserContext;
import java.util.concurrent.Callable;

import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.terapico.caf.Password;

public class BaseManagerImpl implements AccessControledService, BeanNameAware {

  protected String beanName;

  // 用户定制token的时候使用常数，而不是直接使用字符串来过滤，排序

  public String verbIs() {
    return "is";
  }

  public String verbNOT() {
    return "not";
  }

  public String verbEQ() {
    return "eq";
  }

  public String verbEQUALS() {
    return verbEQ();
  }

  public String verbGT() {
    return "gt";
  }

  public String verbGTE() {
    return "gte";
  }

  public String verbLessThan() {
    return verbLT();
  }

  public String verbLT() {
    return "lt";
  }

  public String verbLTE() {
    return "lte";
  }

  public String verbLessThanOrEquals() {
    return verbLTE();
  }

  public String verbContains() {
    return "contains";
  }

  public String verbEndsWith() {
    return "endsWith";
  }

  public String verbStartsWith() {
    return "startsWith";
  }

  public String sortDesc() {
    return "desc";
  }

  public String sortAsc() {
    return "asc";
  }

  public String filterRange() {
    return "range";
  }

  public String filterBetween() {
    return "between";
  }

  public String filterOneOf() {
    return "oneof";
  }

  public String filterNoneof() {
    return "noneof";
  }

  public String thisWeekExpr() {
    return "thisweek";
  }

  public String thisMonthExpr() {
    return "thismonth";
  }

  public String thisYearExpr() {
    return "thisyear";
  }

  public String todayExpr() {
    return "today";
  }

  public String pastExpr() {
    return "past";
  }

  protected void renderActionForList(
      UserContext userContext, BaseEntity objectToRender, Map<String, Object> tokens) {

    objectToRender
        .getAllRelatedLists()
        .forEach(
            oneList -> {
              oneList.forEach(item -> renderItemAction(item, "", objectToRender));
            });
  }

  protected void renderItemAction(BaseEntity entity, String role, BaseEntity parent) {
    String path = String.format("#/%s/%s/workbench", entity.getPresentType(), entity.getId());
    Action action =
        new Action().withActionName("详情").withActionGroup("custom").withActionPath(path);
    entity.addAction(action);

    path =
        String.format(
            "#/%s/%s/list/%sUpdateForm",
            parent.getPresentType(), parent.getId(), entity.getPresentType());
    action = new Action().withActionName("编辑").withActionGroup("custom").withActionPath(path);

    entity.addAction(action);

    path =
        String.format(
            "#/%s/%s/list/%sCreateForm",
            parent.getPresentType(), parent.getId(), entity.getPresentType());
    action = new Action().withActionName("复制").withActionGroup("custom").withActionPath(path);
    entity.addAction(action);
  }

  public BaseGridViewGenerator gridViewGenerator() {
    throw new IllegalStateException(
        "Sub class of BaseManagerImpl must override method gridViewGenerator()");
  }

  protected BlobObject exportListToExcel(
      UserContext userContext, BaseEntity targetObject, String listName) throws IOException {

    BaseGridViewGenerator generator = gridViewGenerator();
    List<Block> blocks = generator.allBlocks(targetObject, listName);
    fixBlocks(userContext, blocks);
    return generator.exportExcel("file", blocks);
  }

  protected String beanNameFromUserApp(BaseUserContext userContext, UserApp userApp) {

    String target = userApp.getAppType();
    String lowerCase = target.substring(0, 1).toLowerCase() + target.substring(1);
    return lowerCase + "Manager";
  }

  protected SecUser cachedUser(RetailscmUserContext userContext) {
    return (SecUser) userContext.getCachedObject(this.getUserKey(userContext), SecUser.class);
  }

  public Optional<UserApp> findOutUserApp(RetailscmUserContext userContext, String userAppId)
      throws Exception {
    SecUser user = cachedUser(userContext);
    if (user == null) {
      throw new IllegalStateException("对不起，你的会话过期，请重新登录");
    }
    List<UserApp> userApps = user.getUserAppList();
    for (UserApp userApp : userApps) {
      if (userApp.getId().equals(userAppId)) {
        return Optional.of(userApp);
      }
    }
    return Optional.ofNullable(null);
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    throw new IllegalAccessException(
        "Method BaseManagerImpl.prepareContextForUserApp Access Denied");
  }

  protected UserApp updateCurrentApp(BaseUserContext baseUserContext, UserApp userApp) {
    if (baseUserContext == null) {
      throw new IllegalStateException("Not able to get a context from");
    }
    UserContext userContext = (UserContext) baseUserContext;

    String currentUserAppKey = this.getCurrentAppKey(userContext);
    userContext.putIntoContextLocalStorage(currentUserAppKey, userApp);
    userContext.putToCache(currentUserAppKey, userApp, 86400);
    return userApp;
  }

  public Object accessUserApp(BaseUserContext userContext, String targetUserAppId)
      throws Exception {
    RetailscmUserContext dmosUserContext = (RetailscmUserContext) userContext;
    dmosUserContext.log("trying to access user app " + targetUserAppId);

    Optional<UserApp> opUserApp = findOutUserApp(dmosUserContext, targetUserAppId);
    if (!opUserApp.isPresent()) {
      throw new IllegalStateException("未找到 " + targetUserAppId + "对应的UserApp");
    }

    UserApp userApp = (UserApp) opUserApp.get();
    String beanName = beanNameFromUserApp(userContext, userApp);
    Object targetBean = dmosUserContext.getBean(beanName);

    if (targetBean == null) {
      throw new IllegalAccessException("Not able to find for bean name " + beanName);
    }

    if (!(targetBean instanceof AccessControledService)) {

      throw new IllegalAccessException(
          "A bean without implement AccessControledService not allowed to be accessed");
    }
    AccessControledService targetService = (AccessControledService) targetBean;

    return targetService.prepareContextForUserApp(userContext, userApp);
  }

  protected void fixBlocks(UserContext userContext, List<Block> blocks) {
    BaseGridViewGenerator generator = gridViewGenerator();

    RetailscmUserContext dmosUserContext = (RetailscmUserContext) userContext;

    for (Block block : blocks) {
      if (generator.isHeaderBlock(block)) {
        block.setValue(dmosUserContext.getLocaleKey(block.getValue().toString()));
      }
      String pageName = dmosUserContext.getLocaleKey(block.getPage());
      block.setPage(pageName);
    }
  }

  // To enable the class to get the bean name, then all managers know who they are,
  // so that the actions can be added with manager bean name
  protected UserApp currentApp(BaseUserContext baseUserContext) {
    if (baseUserContext == null) {
      throw new IllegalStateException("Not able to get a context from");
    }
    UserContext userContext = (UserContext) baseUserContext;

    String currentUserAppKey = this.getCurrentAppKey(userContext);

    Object localCachedUserApp = userContext.getFromContextLocalStorage(currentUserAppKey);

    if (localCachedUserApp != null) {
      return (UserApp) localCachedUserApp;
    }
    Object remoteObject =
        userContext.getCachedObject(this.getCurrentAppKey(userContext), UserApp.class);
    userContext.putIntoContextLocalStorage(currentUserAppKey, remoteObject);
    return (UserApp) remoteObject;
  }

  protected void markVisited(UserContext userContext, BaseEntity visited) {
    String key = userContext.tokenId() + "_visit_" + visited.getInternalType();
    userContext.putToCache(key, visited.getId(), 365 * 24 * 60 * 60);
  }

  public static String getSystemInternalName() {
    return "retailscm";
  }

  public String getBeanName() {
    return beanName;
  }

  public void setBeanName(String beanName) {
    this.beanName = beanName;
  }

  public String encodeURL(String urlToEncode) {
    try {
      return URLEncoder.encode(urlToEncode, "UTF-8");
    } catch (Exception e) {
      System.err.println(
          "FATAL ERROR, SYSTEM IS NOT ABLE TO RUN CAUSE OF UNSUPPORTING FOR ENCODING UTF-8");
      return "SYSTEM IS NOT ABLE TO RUN CAUSE OF UNSUPPORTING FOR ENCODING UTF-8";
    }
  }

  public void ensureRelationInGraph(UserContext userContext, BaseEntity sourceEntity) {

    GraphService graphService = ((RetailscmUserContextImpl) userContext).getGraphService();
    if (graphService instanceof GraphServiceImpl) {
      ((GraphServiceImpl) graphService)
          .addNode(getSystemInternalName(), sourceEntity.getInternalType(), sourceEntity.getId());
      //	List<BaseEntity> entityList = new SmartList<BaseEntity>();
      //	sourceEntity.collectReferences(sourceEntity, entityList);
      //	for (BaseEntity entity : entityList) {
      //		((GraphServiceImpl) graphService).addEdge(getSystemInternalName(),
      // sourceEntity.getInternalType() + "_" + entity.getInternalType(),
      // sourceEntity.getInternalType(), entity.getInternalType(), sourceEntity.getId(),
      // entity.getId());
      //	}
    }
  }

  public void sendCreationEvent(UserContext userContext, BaseEntity sourceEntity) {
    EventService eventService = ((RetailscmUserContextImpl) userContext).getEventService();
    if (eventService == null) {
      return;
    }
    Event event = new Event();
    event.setTarget(getSystemInternalName());
    event.setMessage(sourceEntity);
    eventService.sendEvent(event);
  }

  public void sendInitEvent(UserContext userContext, BaseEntity sourceEntity) {
    EventService eventService = ((RetailscmUserContextImpl) userContext).getEventService();
    if (eventService == null) {
      return;
    }
    Event event = new Event();
    event.setTarget(getSystemInternalName() + ".init");
    event.setMessage(sourceEntity);
    eventService.sendEvent(event);
  }

  public void deleteRelationInGraph(UserContext userContext, BaseEntity sourceEntity) {

    GraphService graphService = ((RetailscmUserContextImpl) userContext).getGraphService();
    if (graphService instanceof GraphServiceImpl) {
      ((GraphServiceImpl) graphService)
          .deleteNode(
              getSystemInternalName(), sourceEntity.getInternalType(), sourceEntity.getId());
    }
  }

  public <T extends BaseEntity> void deleteRelationListInGraph(
      UserContext userContext, SmartList<T> entityList) {
    SmartList<T> toRemoveList = entityList.getToRemoveList();
    if (toRemoveList == null || toRemoveList.isEmpty()) {
      return;
    }
    for (BaseEntity baseEntity : toRemoveList) {
      deleteRelationInGraph(userContext, baseEntity);
    }
  }

  protected Object accessOK() {
    return null;
  }

  protected Object accessFail(UserContext userContext, String message) {
    LoginForm form = new LoginForm();
    form.addErrorMessage(message, null);
    return form;
  }

  public Object checkBasicAccess(
      BaseUserContext baseUserContext, String methodName, Object[] parameters)
      throws IllegalAccessException {
    if (baseUserContext == null) {
      return accessOK();
    }

    UserContext userContext = (UserContext) baseUserContext;
    logCall(userContext, methodName, parameters);

    // 如果来自本地IP，则放开访问
    UserApp app = this.currentApp(baseUserContext);
    if (app == null) {
      userContext.log("app is null!");
      return accessFail(userContext, "没有选择App");
    }
    // userContext.log("trying to log all access list");
    // for(ObjectAccess oa:app.getObjectAccessList()){
    //	userContext.log(oa.toString());
    // }
    // userContext.log("/trying to log all access list");

    if (true) {
      return accessOK(); // 暂时不适用graph来确定权限
    }
    String sourceType = app.getAppType(); // temp here
    String sourceId = app.getAppId(); // temp here

    String targetId = this.targetIdOf(methodName, parameters);
    String operation = this.operationTypeOf(methodName, parameters);
    String targetObjectType = this.serviceFor();
    userContext.log(
        "The user wants to do '" + operation + "' to " + targetObjectType + ":" + targetId);
    String permission = app.getPermission();
    if (targetObjectType.equals(sourceType)) {
      if (targetId.equals(sourceId)) {
        // 直接权限分配，直接检查操作类型是不是子集就好了
        if (hasDirectRight(permission, operation)) {
          return accessOK();
        }

        return accessFail(
            userContext, "你直接访问" + sourceType + "(" + sourceId + ") 失败，你不具有" + operation + "权限");
      }
    }

    // userContext.relationBetween(sourceId, sourceType, targetType, targetId)
    List<String[]> relations =
        userContext.relationBetween(targetObjectType, targetId, sourceType, sourceId);

    logRelation(relations);

    if (hasIndirectRight(userContext, permission, operation, relations)) {
      return accessOK();
    }
    String message =
        "你以持有对"
            + sourceType
            + "("
            + sourceId
            + ")的 '"
            + permission
            + "' 权限被禁止以 '"
            + operation
            + "' 访问: "
            + targetObjectType
            + "("
            + targetId
            + ")";

    return accessFail(userContext, message);
  }

  public boolean hasDirectRight(String permission, String requiredPermission) {
    String[] tokens = {permission, requiredPermission};
    return TokenTool.encodeTokens(tokens) > 0;
  }

  protected boolean hasIndirectRight(
      UserContext userContext,
      String permission,
      String requiredPermission,
      List<String[]> relations) {
    // String [] tokens = {permission,requiredPermission};
    if (relations.size() == 0) {
      return false;
    }
    String[] tokens = {
      permission, requiredPermission.toUpperCase()
    }; // only MXWR can extend to sub objects
    int simpleCheck = TokenTool.encodeTokens(tokens);
    if (simpleCheck <= 0) {
      return false;
    }

    int value = TokenTool.finalTokensOf(relations);

    return (simpleCheck & value) > 0;
  }

  protected void logRelation(List<String[]> relations) {

    System.out.print("Relations: ");

    for (String[] rels : relations) {
      System.out.print("\tline: ");

      for (String r : rels) {
        System.out.print(r + " ,");
      }
      System.out.println();
    }
  }

  // static String secondParameterHeaders[]={"load","update"};
  protected int indexOfTargetId(String methodName) {

    if (methodName.startsWith("create")) {
      return -1;
    }
    if (methodName.startsWith("deleteAll")) {
      return -1;
    }
    return 1;
  }

  protected String targetIdOf(String methodName, Object[] parameters) {
    // 如果第一个是Context，那么通常第二个就是Id，结合方法名，可以找得比较准确
    // 所有的public方法第一个参数都必须是UserContext，第二餐参数可能id或者没有就像deleteAll

    if (parameters.length == 0) {
      return null; // 什么都没有，无法判断权限
    }
    Object object = parameters[0];
    if (!(object instanceof BaseUserContext)) {
      return null; // 第一个不是，也无法判断权限，通常这样的方法不允许在manager方法出现
    }
    if (parameters.length == 1) {
      // 只有UC，没有其他参数
      return null;
    }

    // 第一个是UC，而且至少有第二个参数，而且是String，而且方法的名字不是deleteAll和create，都应该是第二个
    int index = indexOfTargetId(methodName);
    if (index < 0) {
      return null; // 不存在targetId
    }

    if (index >= parameters.length) {
      return null; // 得到的Index超过范围，也不知道是怎么算的
    }

    Object secondParameter = parameters[index];

    if (secondParameter instanceof String) {
      return (String) secondParameter;
    }

    return null;
  }

  static final String[] readMethodPrefixes = {"find", "load", "search", "select", "view"};
  // 保持字母顺序，查找很快, 但是你得非常小心，如果排序没对，就惨了
  static final String[] writeMethodPrefixes = {"add", "update"}; // 保持字母顺序，查找很快
  static final String[] managementMethodPrefixes = {"assign", "delete"}; // 保持字母顺序，查找很快

  protected String operationTypeOf(String methodName, Object[] parameters) {
    // 每个方法都对应着唯一的操作类型

    String prefix = getMethodPrefix(methodName);

    int index = Arrays.binarySearch(readMethodPrefixes, prefix);
    if (index >= 0) {
      return "r";
    }
    index = Arrays.binarySearch(writeMethodPrefixes, prefix);
    if (index >= 0) {
      return "w";
    }
    index = Arrays.binarySearch(managementMethodPrefixes, prefix);
    if (index >= 0) {
      return "m";
    }
    return "x"; // 执行的词汇非常多，默认是执行
  }
  // 找到第一个大写字母或者结束，都算prefix
  protected String getMethodPrefix(String methodName) {

    char[] methodNameArray = methodName.toCharArray();
    for (int i = 0; i < methodNameArray.length; i++) {
      if (Character.isUpperCase(methodNameArray[i])) {

        return methodName.substring(0, i);
      }
    }

    return methodName;
  }

  public static void main(String[] args) {
    BaseManagerImpl manager = new BaseManagerImpl();
    String value = manager.getMethodPrefix("loadPa");
    System.out.println(value);
    value = manager.getMethodPrefix("load");
    System.out.println(value);

    value = manager.operationTypeOf("load", new Object[] {});
    System.out.println(value);

    value = manager.operationTypeOf("delete", new Object[] {});
    System.out.println(value);

    value = manager.operationTypeOf("add", new Object[] {});
    System.out.println(value);
    value = manager.operationTypeOf("address", new Object[] {});
    System.out.println(value);
  }

  public String serviceFor() {
    return "BASE";
  }

  protected void logCall(UserContext userContext, String methodName, Object[] parameters) {
    if (userContext == null) {
      return;
    }

    userContext.log(callingLog(methodName, parameters));
  }

  protected String callingLog(String methodName, Object[] parameters) {
    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(this.getClass().getSimpleName());
    stringBuilder.append(".");
    stringBuilder.append(methodName);
    stringBuilder.append("(");
    wrapParameters(stringBuilder, parameters);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }

  protected String wrapValueIn(Object value) {
    if (value == null) {
      return "NULL";
    }

    if (value instanceof DateTime) {
      DateTime dateTimeValue = (DateTime) value;
      return this.join("'", timeExpr(dateTimeValue), "'");
    }
    if (value instanceof Date) {
      Date dateValue = (Date) value;
      return this.join("'", dateExpr(dateValue), "'");
    }
    if (value instanceof Number) {
      return value.toString();
    }
    if (value instanceof String) {
      String strValue = (String) value;
      String escapedValue = strValue.replace("\'", "''");
      return this.join("'", escapedValue, "'");
    }

    return this.join("'", value, "'");
  }

  protected String join(Object... objs) {
    StringBuilder internalPresentBuffer = new StringBuilder();

    for (Object o : objs) {
      if (o == null) {
        continue;
      }
      internalPresentBuffer.append(o);
    }

    return internalPresentBuffer.toString();
  }

  protected String timeExpr(DateTime dateTimeValue) {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // It is not thread safe, how silly the JDK is!!!
    return simpleDateFormat.format(dateTimeValue);
  }

  protected String dateExpr(Date dateValue) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // It is not thread safe, how silly the JDK is!!!
    return simpleDateFormat.format(dateValue);
  }

  protected String timeExpr() {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd'T'HH:mm:ss.SSS");
    // It is not thread safe, how silly the JDK is!!!
    return simpleDateFormat.format(new java.util.Date());
  }

  protected void wrapParameters(StringBuilder stringBuilder, Object[] parameters) {
    for (int i = 1; i < parameters.length; i++) {
      if (i > 1) {
        stringBuilder.append(", ");
      }
      wrapParameter(stringBuilder, parameters[i]);
    }
  }

  protected void wrapParameter(StringBuilder stringBuilder, Object parameter) {
    if (parameter == null) {
      stringBuilder.append("<null>");
      return;
    }
    if (parameter instanceof String) {
      wrapString(stringBuilder, parameter.toString());
      return;
    }
    //
    if (isArrayType(parameter.getClass())) {
      Object[] objects = (Object[]) parameter;
      stringBuilder.append("[");
      for (int i = 0; i < objects.length; i++) {
        if (i > 0) {
          stringBuilder.append(", ");
        }
        Object object = objects[i];
        wrapParameter(stringBuilder, object);
      }
      stringBuilder.append("]");
      return;
    }

    stringBuilder.append(this.wrapValueIn(parameter));
  }

  protected boolean isArrayType(Type type) {

    Class<?> typeClazz = (Class<?>) type;
    if (typeClazz.isArray()) {
      return true;
    }
    return false;
  }

  protected void wrapString(StringBuilder stringBuilder, String parameter) {

    stringBuilder.append("\'");
    stringBuilder.append(parameter);
    stringBuilder.append("\'");
  }

  protected String getCacheKey(UserContext userContext, String prefix) {
    return "retailscm:" + prefix + ":" + userContext.tokenId();
  }

  protected String getUserKey(UserContext userContext) {
    return "retailscm:user:" + userContext.tokenId();
  }

  protected String getCurrentAppKey(UserContext userContext) {
    return getUserKey(userContext) + ":currentApp";
  }

  protected Object invokeWithOneString(
      BaseUserContext baseUserContext,
      String beanName,
      String methodName,
      String classBaseName,
      String parameter)
      throws Exception {
    UserContext userContext = (UserContext) baseUserContext;
    Object target = userContext.getBean(beanName);
    Method method =
        target
            .getClass()
            .getMethod(
                methodName, (Class<?>[]) new Class<?>[] {RetailscmUserContext.class, String.class});
    UserContext targetUserContext = (UserContext) baseUserContext; // userContext.castTo(implClass);
    // Method main = c.getDeclaredMethod("main", argTypes);
    return method.invoke(target, targetUserContext, parameter);
  }

  protected Double parseDouble(String doubleExpr) {
    // support for money types
    char firstChar = doubleExpr.charAt(0);

    if (Character.isDigit(firstChar)) {

      return Double.parseDouble(doubleExpr);
    }

    NumberFormat format = NumberFormat.getCurrencyInstance(Locale.SIMPLIFIED_CHINESE);
    try {
      return format.parse(doubleExpr).doubleValue();
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      throw new NumberFormatException("The value: " + doubleExpr + " is not for a number");
    }

    // return Double.parseDouble(doubleExpr.substring(1));

  }

  protected Double parseDouble(String doubleExpr, int precision) {
    return Double.parseDouble(doubleExpr);
  }

  protected Float parseFloat(String floatExpr) {
    return Float.parseFloat(floatExpr);
  }

  protected Integer parseInt(String intExpr) {
    return Integer.parseInt(intExpr);
  }

  protected Boolean parseBoolean(String booleanExpr) {
    return Boolean.parseBoolean(booleanExpr);
  }
  // protected Double parseTime(String timeExpr){
  //	return Double.parseDouble(timeExpr);
  // }
  protected Date parseTime(String dateExpr) {
    String defaultFormat = "HH:mm:ss";
    DateFormat formatter = new SimpleDateFormat(defaultFormat);
    try {
      return formatter.parse(dateExpr);
    } catch (ParseException e) {
      throw new IllegalArgumentException(
          "The value '" + dateExpr + "' could not be parsed to a Time.");
    }
  }

  protected Date parseDate(String dateExpr) {
    String defaultFormat = "yyyy-MM-dd";
    DateFormat formatter = new SimpleDateFormat(defaultFormat);
    try {
      return formatter.parse(dateExpr);
    } catch (ParseException e) {
      throw new IllegalArgumentException(
          "The value '" + dateExpr + "' could not be parsed to a Date.");
    }
  }

  protected DateTime parseTimestamp(String timeStampExpr) {
    String defaultFormat = "yyyy-MM-dd'T'hh:mm";
    DateFormat formatter = new SimpleDateFormat(defaultFormat);
    try {
      return DateTime.fromDate(formatter.parse(timeStampExpr));
    } catch (ParseException e) {
      throw new IllegalArgumentException(
          "The value '" + timeStampExpr + "' could not be parsed to a TimeStamp.");
    }
  }

  protected String parseString(String stringExpr) {
    return stringExpr;
  }

  protected Images parseImages(String stringExpr) {
    return Images.fromString(stringExpr);
  }

  protected boolean integerValueInClosedRange(int value, int min, int max) {
    if (value < min) {
      return false;
    }
    if (value > max) {
      return false;
    }
    return true;
  }

  protected void packMessage(
      List<Message> messageList,
      String subject,
      String propertykey,
      Object[] parameters,
      String defaultMessage) {
    Message errorMsg = new Message();
    errorMsg.setLevel("warning");
    errorMsg.setSubject(subject);
    errorMsg.setParameters(parameters);
    errorMsg.setBody(defaultMessage);
    errorMsg.setPropertyKey(propertykey);
    messageList.add(errorMsg);
    return;
  }

  protected void checkLongtext(
      String value, int minLength, int maxLength, String propertyKey, List<Message> messageList) {
    checkStringLengthRange(value, minLength, maxLength, propertyKey, messageList);
  }

  protected void checkStringLengthRange(
      String value, int minLength, int maxLength, String propertyKey, List<Message> messageList) {

    if (value == null) {
      if (minLength == 0) {
        // 如果最小长度为0，则改值允许为NULL
        return;
      }
      packMessage(
          messageList,
          "STRING_NOT_ALLOW_TO_BE_NULL",
          propertyKey,
          new Object[] {propertyKey, value, minLength, maxLength},
          "您输入的 '" + propertyKey + "' 的值'" + value + "'长度有误，该值最少" + minLength + "个字符.");
      return;
    }

    if (integerValueInClosedRange(value.length(), minLength, maxLength)) {
      return;
    }

    if (minLength == maxLength) {
      // 固定长度，

      // errorMsg.setBody("您输入的"+propertyKey+":'"+value+"'长度有误, 该值长度为 "+ value.length()+",
      // 系统预期是固定长度为"+minLength + "之间的文本");
      packMessage(
          messageList,
          "STRING_NOT_FIXED_LENGTH",
          propertyKey,
          new Object[] {propertyKey, value, minLength, maxLength, value.length()},
          "您输入的 '"
              + propertyKey
              + "' 的值'"
              + value
              + "'长度不对, 该值长度为 "
              + value.length()
              + ", 系统预期是固定长度为 "
              + minLength
              + " 文本.");
      return;
    }
    if (value.length() > maxLength) {
      packMessage(
          messageList,
          "STRING_TOO_LONG",
          propertyKey,
          new Object[] {propertyKey, value, minLength, maxLength, value.length()},
          "您输入的 '"
              + propertyKey
              + "' 的值'"
              + value
              + "'长度太长, 该值长度为 "
              + value.length()
              + ", 系统预期最多 "
              + maxLength
              + " 个字符.");
      return;
    }
    if (value.length() < minLength) {

      packMessage(
          messageList,
          "STRING_TOO_SHORT",
          propertyKey,
          new Object[] {propertyKey, value, minLength, maxLength, value.length()},
          "您输入的 '"
              + propertyKey
              + "' 的值'"
              + value
              + "'长度太短, 该值长度为 "
              + value.length()
              + ", 系统预期是最短 "
              + minLength
              + " 个字符.");
      return;
    }
  }

  protected boolean prefixedWith(String value, String prefixes[]) {

    for (String prefix : prefixes) {

      if (value.startsWith(prefix)) {
        return true;
      }
    }
    return false;
  }

  protected String joinArray(String delimiter, Object[] args) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < args.length; i++) {
      if (i > 0) stringBuilder.append(delimiter);
      stringBuilder.append(args[i]);
    }
    return stringBuilder.toString();
  }

  protected void checkChinaMobilePhone(
      String value, int minLength, int maxLength, String propertyKey, List<Message> messageList) {
    // checkStringLengthRange(value, 11, 11, propertyKey, messageList);
    // 中国的手机号目前都只有11位,全部数字，并且是以13 15 17 18 开头

    if (value == null) {
      if (minLength == 0) {
        // 如果最小长度为0，则改值允许为NULL
        return;
      }
      packMessage(
          messageList,
          "CHINA_MOBILE_NOT_ALLOW_TO_BE_NULL",
          propertyKey,
          new Object[] {propertyKey, value, minLength, maxLength},
          "您输入的 '" + propertyKey + "' 的值 '" + value + "' 长度有误，该值为11个数字的手机号.");
      return;
    }

    if (!integerValueInClosedRange(value.length(), 11, 11)) {
      packMessage(
          messageList,
          "CHINA_MOBILE_NOT_FIXED_LENGTH",
          propertyKey,
          new Object[] {propertyKey, value, minLength, maxLength, value.length()},
          "您输入的 '"
              + propertyKey
              + "' 的值 '"
              + value
              + "' 长度不对, 该值长度为 "
              + value.length()
              + ", 系统预期是固定长度为 "
              + minLength
              + "，而且全部为数字的手机号.");

      return;
    }
    String prefixes[] = {"13", "14", "15", "17", "18", "166", "199"};

    if (!prefixedWith(value, prefixes)) {
      String errorForPrefixes = this.joinArray("、", prefixes);
      packMessage(
          messageList,
          "CHINA_MOBILE_FORMAT_ISSUE",
          propertyKey,
          new Object[] {propertyKey, value, minLength, maxLength, value.length()},
          "您输入的 '"
              + propertyKey
              + "' 的值 '"
              + value
              + "' 格式错误, 开头应为"
              + errorForPrefixes
              + "而且全部为半角字符数字的手机号.");
      return;
    }
    char digits[] = value.toCharArray();
    for (char ch : digits) {
      if (Character.isDigit(ch)) {
        continue;
      }
      packMessage(
          messageList,
          "CHINA_MOBILE_CONTAIN_INVALID_CHAR",
          propertyKey,
          new Object[] {propertyKey, value, minLength, maxLength, ch + ""},
          "您输入的 '" + propertyKey + "' 的值 '" + value + "'包含非数字字符 '" + ch + "', 系统预期是全部为数字的手机号.");
      return;
    }
  }

  protected void checkDateTime(
      Date value, Date minDate, Date maxDate, String propertyKey, List<Message> messageList) {
    this.checkDateRange(value, minDate, maxDate, propertyKey, messageList);
  }

  protected void checkDateRange(
      Date value, Date minDate, Date maxDate, String propertyKey, List<Message> messageList) {
    if (value == null) {

      packMessage(
          messageList,
          "DATE_NOT_ALLOWED_TO_BE_NULL",
          propertyKey,
          new Object[] {propertyKey, value, minDate, maxDate},
          "您输入的 '" + propertyKey + "' 为空，系统预期为一个日期.");
      return;
    }
    Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    if (minDate.after(value)) {
      packMessage(
          messageList,
          "DATE_BEFORE_START",
          propertyKey,
          new Object[] {propertyKey, value, minDate, maxDate},
          "您输入的 '" + propertyKey + "' 在允许最早日期" + formatter.format(minDate) + "之前，请修正");

      return;
    }
    if (maxDate.before(value)) {
      packMessage(
          messageList,
          "DATE_AFTER_END",
          propertyKey,
          new Object[] {propertyKey, value, minDate, maxDate},
          "您输入的 '" + propertyKey + "' 在允许最晚日期" + formatter.format(maxDate) + "之后，请修正");

      return;
    }
  }

  protected void checkTimeRange(
      Date value, Date minDate, Date maxDate, String propertyKey, List<Message> messageList) {
    if (value == null) {

      packMessage(
          messageList,
          "DATE_NOT_ALLOWED_TO_BE_NULL",
          propertyKey,
          new Object[] {propertyKey, value, minDate, maxDate},
          "您输入的 '" + propertyKey + "' 为空，系统预期为一个时间.");
      return;
    }
    Format formatter = new SimpleDateFormat("HH:mm:ss");
    long valTime = value.getHours() * 3600 + value.getMinutes() * 60 + value.getSeconds();
    long minTime = minDate.getHours() * 3600 + minDate.getMinutes() * 60 + minDate.getSeconds();
    if (minTime > valTime) {
      packMessage(
          messageList,
          "DATE_BEFORE_START",
          propertyKey,
          new Object[] {propertyKey, value, minDate, maxDate},
          "您输入的 '" + propertyKey + "' 在允许最早时间" + formatter.format(minDate) + "之前，请修正");

      return;
    }
    long maxTime = maxDate.getHours() * 3600 + maxDate.getMinutes() * 60 + maxDate.getSeconds();
    if (maxTime < valTime) {
      packMessage(
          messageList,
          "DATE_AFTER_END",
          propertyKey,
          new Object[] {propertyKey, value, minDate, maxDate},
          "您输入的 '" + propertyKey + "' 在允许最晚时间" + formatter.format(maxDate) + "之后，请修正");

      return;
    }
  }

  protected void checkDatePast(
      Date value, Date minDate, Date maxDate, String propertyKey, List<Message> messageList) {
    if (value == null) {

      packMessage(
          messageList,
          "DATE_NOT_ALLOWED_TO_BE_NULL",
          propertyKey,
          new Object[] {propertyKey, value, minDate, maxDate},
          "您输入的 '" + propertyKey + "' 为空，系统预期为一个日期.");
      return;
    }
    Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    if (minDate.after(value)) {
      packMessage(
          messageList,
          "DATE_BEFORE_START",
          propertyKey,
          new Object[] {propertyKey, value, minDate, maxDate},
          "您输入的 '" + propertyKey + "' 在最早的日期" + formatter.format(minDate) + "之前，请修正");

      return;
    }
    if (maxDate.before(value)) {
      packMessage(
          messageList,
          "DATE_AFTER_END",
          propertyKey,
          new Object[] {propertyKey, value, minDate, maxDate},
          "您输入的 '" + propertyKey + "' 在最晚的日期" + formatter.format(maxDate) + "之后，请修正");

      return;
    }
  }

  protected void checkEmail(
      String value, int min, int max, String propertyKey, List<Message> messageList) {
    if (min == 0 && (value == null || value.isEmpty())) {
      return;
    }
    checkStringLengthRange(value, min, max, propertyKey, messageList);
    /*
     * The maximum length is specified in RFC 5321: "The maximum total length of
     * a reverse-path or forward-path is 256 characters"
     *
     * */

  }

  protected void checkPassword(
      String value, int min, int max, String propertyKey, List<Message> messageList) {
    checkStringLengthRange(value, 6, 24, propertyKey, messageList);
  }

  protected void checkMoneyAmount(
      double value, double min, double max, String propertyKey, List<Message> messageList) {
    checkDoubleRange(value, min, max, propertyKey, messageList);
  }
  /*
  	 *
  您输入的姓名阿布切诺-买买提有误，该值长度 7 ，系统预期是长度2到6之间的文本

  您输入的支付金额 ‘100.00’ 有误， 该值低于系统预期范围，系统期望是从101.00到121.00之间

  您输入的支付金额 ‘啊100.00’ 有误， 该输入正确的格式是像 123.09 的小数

  您输入的出生日期格式有误，该输入正确的的格式是像 2017-09-09的日期
  	 *
  	 *
  	 * */
  protected void checkDoubleRange(
      double value, double min, double max, String propertyKey, List<Message> messageList) {
    if (value > max) {
      packMessage(
          messageList,
          "NUMBER_GREATER_THAN_MAX",
          propertyKey,
          new Object[] {propertyKey, value, min, max},
          "您输入的 '" + propertyKey + "' 在比允许的最大值" + max + "还要大，请修正。");

      return;
    }
    if (value < min) {
      packMessage(
          messageList,
          "NUMBER_LESS_THAN_MIN",
          propertyKey,
          new Object[] {propertyKey, value, min, max},
          "您输入的 '" + propertyKey + "' 在比允许的最小值" + min + "还要小，请修正。");

      return;
    }
  }

  protected void checkUrl(
      String pActionLink,
      int pI,
      int pI2,
      String pActionLinkOfAcceleratorAccount,
      List<Message> messageList) {}

  protected void checkBooleanRange(
      boolean pFullAccess,
      boolean pI,
      boolean pB,
      String pFullAccessOfUserApp,
      List<Message> messageList) {}

  protected void checkImage(
      String pAppIcon, int pI, int pI2, String pAppIconOfUserApp, List<Message> messageList) {}

  protected void checkDocument(
      String pAppIcon, int pI, int pI2, String pAppIconOfUserApp, List<Message> messageList) {}

  protected void checkIntegerRange(
      int value, int min, int max, String propertyKey, List<Message> messageList) {
    if (value > max) {
      packMessage(
          messageList,
          "INTEGER_GREATER_THAN_MAX",
          propertyKey,
          new Object[] {propertyKey, value, min, max},
          "您输入的" + propertyKey + "在比允许的最大值" + max + "还要大，请修正。");

      return;
    }
    if (value < min) {
      packMessage(
          messageList,
          "INTEGER_LESS_THAN_MIN",
          propertyKey,
          new Object[] {propertyKey, value, min, max},
          "您输入的" + propertyKey + "在比允许的最小值" + min + "还要小，请修正。");

      return;
    }
  }

  protected String hashStringWithSHA256(String valueToHash, String salt) {

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

  protected <T extends BaseEntity> void addActions(
      BaseUserContext baseUserContext, T entity, Map<String, Object> tokens) {

    entity.addAction(
        createAction("@view", "view", "view/" + entity.getId() + "/", "main", "primary"));
  }

  protected <T extends BaseEntity> void addAction(
      BaseUserContext userContext,
      BaseEntity baseEntity,
      Map<String, Object> tokens,
      String localeKey,
      String key,
      String path,
      String group,
      String level) {

    baseEntity.addAction(createAction(localeKey, key, path, group, level));
  }

  protected Action createAction(
      String localeKey, String key, String path, String actionGroup, String actionLevel) {

    return new Action()
        .withLocaleKey(localeKey)
        .withActionKey(key)
        .withManagerBeanName(this.getBeanName())
        .withActionPath(path)
        .withActionGroup(actionGroup)
        .withActionLevel(actionLevel);
  }

  public void onAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters) {
    RetailscmUserContextImpl ctx = (RetailscmUserContextImpl) baseUserContext;
    ctx.setOwnerBeanName(this.getBeanName());
  }

  public void afterInvoke(
      BaseUserContext baseUserContext,
      String methodName,
      Object[] parameters,
      boolean success,
      Object result,
      Throwable throwable) {
    RetailscmBizUserContextImpl ctx = (RetailscmBizUserContextImpl) baseUserContext;
    if (throwable != null) {
      if (throwable instanceof ErrorMessageException) {
        ctx.preventExceptionEmail();
      } else if (throwable instanceof ErrorOccurredException) {
        ctx.preventExceptionEmail();
      }
      return;
    }
    ctx.postProcessing();
  }

  protected void checkMoneyAmount(
      BigDecimal value, double min, double max, String propertyKey, List<Message> messageList) {
    checkDoubleRange(value.doubleValue(), min, max, propertyKey, messageList);
  }

  protected BigDecimal parseBigDecimal(String bigDecimalExpr) {

    if (bigDecimalExpr == null) {
      throw new NumberFormatException(
          "The value: " + bigDecimalExpr + " is null, not for a number");
    }
    if (bigDecimalExpr.isEmpty()) {
      throw new NumberFormatException(
          "The value: " + bigDecimalExpr + " is empty, not for a number");
    }
    try {
      char firstChar = bigDecimalExpr.charAt(0);

      if (Character.isDigit(firstChar)) {

        return new BigDecimal(bigDecimalExpr);
      }
      return new BigDecimal(bigDecimalExpr.substring(1));
    } catch (Exception e) {
      throw new NumberFormatException("The value: " + bigDecimalExpr + " is not a number");
    }
  }

  protected void checkBigDecimalRange(
      BigDecimal value, double min, double max, String propertyKey, List<Message> messageList) {
    if (value.compareTo(new BigDecimal(max)) > 0) {
      packMessage(
          messageList,
          "NUMBER_GREATER_THAN_MAX",
          propertyKey,
          new Object[] {propertyKey, value, min, max},
          "您输入的 '" + propertyKey + "' 在比允许的最大值" + max + "还要大，请修正。");

      return;
    }
    if (value.compareTo(new BigDecimal(min)) < 0) {
      packMessage(
          messageList,
          "NUMBER_LESS_THAN_MIN",
          propertyKey,
          new Object[] {propertyKey, value, min, max},
          "您输入的 '" + propertyKey + "' 在比允许的最小值" + min + "还要小，请修正。");

      return;
    }
  }

  protected void checkTaxpayerid(
      String value, int min, int max, String propertyKey, List<Message> messageList) {
    if (value == null || value.trim().length() != 15) {
      packMessage(
          messageList,
          "STRING_NOT_FIXED_LENGTH",
          propertyKey,
          new Object[] {propertyKey, value, 15},
          "您输入的 '" + propertyKey + "' 不是15位的有效税号，请修正。");
      return;
    }
  }

  protected AccessInfo convertToAccessInfo(ListAccess listAccess) {

    AccessInfo accessInfo = new AccessInfo();
    if (!isExplicitListAccess()) {
      // 无需显式声明权限，则有读权限
      accessInfo.setReadPermission(true);
      return accessInfo;
    }

    if (listAccess == null) {
      return accessInfo; // all fasle
    }

    accessInfo.setInternalName(listAccess.getInternalName());
    accessInfo.setReadPermission(listAccess.getReadPermission());
    accessInfo.setCreatePermission(listAccess.getCreatePermission());
    accessInfo.setDeletePermission(listAccess.getDeletePermission());
    accessInfo.setUpdatePermission(listAccess.getUpdatePermission());
    accessInfo.setExecutionPermission(listAccess.getExecutionPermission());

    return accessInfo;
  }

  public void enforceAccess(BaseUserContext baseUserContext, Object targetObject) {
    if (baseUserContext == null) {
      return;
    }

    UserContext userContext = (UserContext) baseUserContext;

    this.applyAccessList(userContext, targetObject);
  }

  protected Map<String, ListAccess> toMap(SmartList<ListAccess> listAccessList) {

    Map<String, ListAccess> map = new HashMap<String, ListAccess>();

    for (ListAccess listAccess : listAccessList) {

      map.put(listAccess.getInternalName(), listAccess);
    }

    return map;
  }

  protected boolean isExplicitListAccess() {
    return false;
  }

  protected void applyAccessList(UserContext userContext, Object targetObject) {

    if (!(targetObject instanceof BaseEntity)) {

      userContext.log("no applied to target object " + targetObject.getClass().getName());
      return;
    }

    BaseEntity entity = (BaseEntity) targetObject;

    UserApp app = currentApp(userContext);

    if (app == null) {
      userContext.log("no app");
      return;
    }

    List<SmartList<?>> allLists = entity.getAllRelatedLists();

    if (allLists == null) {
      userContext.log("no list");
      return;
    }

    if (!app.getAppType().equalsIgnoreCase(entity.getInternalType())) {
      userContext.log("no match type");
      return;
    }
    if (!app.getAppId().equals(entity.getId())) {
      userContext.log("no match id");
      return;
    }
    SmartList<ListAccess> listAccessList = app.getListAccessList();
    // then apply to the list;
    Map<String, ListAccess> accessListMap = toMap(listAccessList);

    for (SmartList<?> list : allLists) {

      String listName = list.getListInternalName();
      userContext.log("---------------" + list.getListInternalName() + "");

      ListAccess listAccess = accessListMap.get(listName);
      // AccessInfo
      SmartListMetaInfo metaInfo = new SmartListMetaInfo();

      AccessInfo accessInfo = convertToAccessInfo(listAccess);
      userContext.log(
          list.getListInternalName() + " has read permission: " + accessInfo.getReadPermission());
      metaInfo.setAccessInfo(accessInfo);

      list.setMetaInfo(metaInfo);

      if (!accessInfo.getReadPermission()) {

        list.clear();
      }
    }

    userContext.log(" All list size: " + allLists.size());
  }

  protected long parseLong(String longExpr) {
    return Long.valueOf(longExpr);
  }

  protected void throwException(
      String message, Throwable e, boolean rollback, boolean sendMonitorEmail) {
    if (rollback) {
      if (sendMonitorEmail) {
        throw new FatalOccurredException(message, e);
      } else {
        throw new ErrorOccurredException(message, e);
      }
    } else {
      if (sendMonitorEmail) {
        throw new FatalMessageException(message, e);
      } else {
        throw new ErrorMessageException(message, e);
      }
    }
  }

  /** 发出一个错误消息. 这个实际上是一个RuntimeException的子类, 但是不导致事务回滚(因为是 message 为主), 而是发送监控邮件 */
  protected void fatalMessage(String message) {
    throwException(message, null, false, true);
  }

  protected void fatalMessage(Throwable throwable) {
    throwException(throwable.getMessage(), throwable, false, true);
  }
  /** 发生了一个错误, 会同时发送一个错误消息. 这个是一个RuntimeException的子类, 并且导致事务回滚(因为是 error 为主),并发送监控邮件 */
  protected void fatalOccurred(String message) {
    throwException(message, null, true, true);
  }

  protected void fatalOccurred(Throwable throwable) {
    throwException(throwable.getMessage(), throwable, true, true);
  }

  /** 发出一个错误消息. 这个实际上是一个RuntimeException的子类, 但是不导致事务回滚(因为是 message 为主). 但是不发送监控邮件 */
  protected void errorMessage(String message) {
    throwException(message, null, false, false);
  }

  protected void errorMessage(Throwable throwable) {
    throwException(throwable.getMessage(), throwable, false, false);
  }
  /** 发生了一个错误, 会同时发送一个错误消息. 这个是一个RuntimeException的子类, 并且导致事务回滚(因为是 error 为主) 但是不发送监控邮件 */
  protected void errorOccurred(String message) {
    throwException(message, null, true, false);
  }

  protected void errorOccurred(Throwable throwable) {
    throwException(throwable.getMessage(), throwable, true, false);
  }

  protected <T> T orNull(Callable<T> call) {
    return RetailscmBaseUtils.orNull(call);
  }

  protected <T> T ifNull(T call, T defaultValue) {
    return RetailscmBaseUtils.ifNull(call, defaultValue);
  }

  protected <T> T orElse(Callable<T> call, T defaultValue) {
    return RetailscmBaseUtils.orElse(call, defaultValue);
  }

  // -----------------------------------//  登录部分处理 \\-----------------------------------
  // 调试时直接使用ID登录, 注意是 fullId
  public Object loginById4Debug(RetailscmUserContext userContext, String fullId) throws Exception {
    LoginChannel loginChannel =
        LoginChannel.of(
            RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginById");
    LoginData loginData = new LoginData();
    loginData.setLoginId(fullId);

    LoginContext loginContext = LoginContext.of(LoginMethod.ID_4_DEBUG, loginChannel, loginData);
    return processLoginRequest(userContext, loginContext);
  }
  // 手机号+短信验证码 登录
  public Object loginByMobile(RetailscmUserContext userContext, String mobile, String verifyCode)
      throws Exception {
    LoginChannel loginChannel =
        LoginChannel.of(
            RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByMobile");
    LoginData loginData = new LoginData();
    loginData.setMobile(mobile);
    loginData.setVerifyCode(verifyCode);

    LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
    return processLoginRequest(userContext, loginContext);
  }
  // 账号+密码登录
  public Object loginByPassword(RetailscmUserContext userContext, String loginId, Password password)
      throws Exception {
    LoginChannel loginChannel =
        LoginChannel.of(
            RetailscmBaseUtils.getRequestAppType(userContext),
            this.getBeanName(),
            "loginByPassword");
    LoginData loginData = new LoginData();
    loginData.setLoginId(loginId);
    loginData.setPassword(password.getClearTextPassword());

    LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
    return processLoginRequest(userContext, loginContext);
  }
  // 微信小程序登录
  public Object loginByWechatMiniProgram(RetailscmUserContext userContext, String code)
      throws Exception {
    LoginChannel loginChannel =
        LoginChannel.of(
            RetailscmBaseUtils.getRequestAppType(userContext),
            this.getBeanName(),
            "loginByWechatMiniProgram");
    LoginData loginData = new LoginData();
    loginData.setCode(code);

    LoginContext loginContext =
        LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
    return processLoginRequest(userContext, loginContext);
  }
  // 微信小程序获取手机号快速登录
  public Object loginByWechatMobile(
      RetailscmUserContext userContext, String code, String encryptedData, String iv)
      throws Exception {
    LoginChannel loginChannel =
        LoginChannel.of(
            RetailscmBaseUtils.getRequestAppType(userContext),
            this.getBeanName(),
            "loginByWechatMobile");
    LoginData loginData = new LoginData();
    loginData.setCode(code);
    loginData.setEncryptedData(encryptedData);
    loginData.setIv(iv);

    LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MOBILE, loginChannel, loginData);
    return processLoginRequest(userContext, loginContext);
  }
  // 企业微信小程序登录
  public Object loginByWechatWorkMiniProgram(RetailscmUserContext userContext, String code)
      throws Exception {
    LoginChannel loginChannel =
        LoginChannel.of(
            RetailscmBaseUtils.getRequestAppType(userContext),
            this.getBeanName(),
            "loginByWechatWorkMiniProgram");
    LoginData loginData = new LoginData();
    loginData.setCode(code);

    LoginContext loginContext =
        LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
    return processLoginRequest(userContext, loginContext);
  }
  // 调用登录处理
  protected Object processLoginRequest(
      RetailscmUserContext baseUserContext, LoginContext loginContext) throws Exception {
    RetailscmUserContextImpl userContext = (RetailscmUserContextImpl) baseUserContext;

    IamService iamService = (IamService) userContext.getBean("iamService");
    LoginResult loginResult =
        iamService.doLogin(userContext, loginContext, getLoginProcessBizHandler(userContext));
    // 根据登录结果
    if (!loginResult.isAuthenticated()) {
      throw new Exception(loginResult.getMessage());
    }
    if (loginResult.isSuccess()) {
      return onLoginSuccess(userContext, loginResult);
    }
    if (loginResult.isNewUser()) {
      throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
    }
    return new LoginForm();
  }

  @Override
  public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
      throws IllegalAccessException {
    RetailscmUserContextImpl userContext = (RetailscmUserContextImpl) baseUserContext;
    IamService iamService = (IamService) userContext.getBean("iamService");
    Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

    SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
    UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
    userContext.setSecUser(secUser);
    userContext.setUserApp(userApp);
    if (userApp != null) {
      userApp.setSecUser(secUser);
    }
    if (secUser == null) {
      iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
    }
    afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
    if (!isMethodNeedLogin(userContext, methodName, parameters)) {
      return accessOK();
    }

    return checkBasicAccess(baseUserContext, methodName, parameters);
  }

  // 判断哪些接口需要登录后才能执行. 默认除了几个特别的,其他都要登录
  protected boolean isMethodNeedLogin(
      RetailscmUserContext userContext, String methodName, Object[] parameters) {
    if (methodName.startsWith("loginBy")) {
      return false;
    }
    if (methodName.startsWith("logout")) {
      return false;
    }
    if (methodName.startsWith("ensureModelInDB")) {
      return false;
    }
    return true;
  }

  // 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
  protected void afterSecUserAppLoadedWhenCheckAccess(
      RetailscmUserContext userContext,
      Map<String, Object> loginInfo,
      SecUser secUser,
      UserApp userApp)
      throws IllegalAccessException {}

  protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult)
      throws Exception {
    // by default, return the view of this object
    UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
    return this.view(userContext, userApp.getAppId());
  }

  public void onAuthenticateUserLogged(
      RetailscmUserContext userContext,
      LoginContext loginContext,
      LoginResult loginResult,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler)
      throws Exception {
    // by default, find the correct user-app
    SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
    SmartList<UserApp> userApps = getRelatedUserAppList(userContext, secUser);
    if (userApps == null || userApps.isEmpty()) {
      throw new Exception("您的账号未关联系统账号,请联系客服处理账号异常.");
    }
    UserApp userApp = userApps.first();
    userApp.setSecUser(secUser);
    loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
    BaseEntity app =
        userContext.getDAOGroup().loadBasicData(userApp.getAppType(), userApp.getAppId());
    ((RetailscmBizUserContextImpl) userContext).setCurrentUserInfo(app);
  }

  public Object view(RetailscmUserContext userContext, String id) throws Exception {
    throw new UnsupportedOperationException("view 接口尚未实现");
  }

  protected BusinessHandler getLoginProcessBizHandler(RetailscmUserContextImpl userContext) {
    throw new UnsupportedOperationException("getLoginProcessBizHandler 接口尚未实现");
  }

  protected SmartList<UserApp> getRelatedUserAppList(
      RetailscmUserContext userContext, SecUser secUser) {
    throw new UnsupportedOperationException("getRelatedUserAppList 接口尚未实现");
  }

  // -----------------------------------\\  登录部分处理 //-----------------------------------

}
