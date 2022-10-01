package com.doublechaintech.retailscm.secuser;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.util.StreamUtils;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.userapp.*;
import com.doublechaintech.retailscm.listaccess.*;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.search.Q;
import com.doublechaintech.retailscm.search.Searcher;

import com.terapico.uccaf.BaseUserContext;
import com.terapico.uccaf.UserContextProvider;
import com.terapico.caf.BeanFactory;
import com.terapico.caf.Password;
import com.terapico.utils.*;
import com.skynet.infrastructure.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import com.terapico.uccaf.AccessControledService;

public class CustomSecUserManagerImpl extends SecUserManagerImpl implements UserContextProvider {
  public static ThreadLocal<UserContextImpl> GLOBAL_CONTEXT = new ThreadLocal<>();
  protected LocationService locationService;

  public LocationService getLocationService() {
    return locationService;
  }

  public void setLocationService(LocationService locationService) {
    this.locationService = locationService;
  }

  protected StorageService storageService;
  protected BlockChainAdvancer blockChainAdvancer;
  protected TreeServiceImpl mTreeService;

  public TreeServiceImpl getTreeService() {
    return mTreeService;
  }

  public void setTreeService(TreeServiceImpl treeService) {
    mTreeService = treeService;
  }

  protected String environmentName;
  protected Boolean productEnvironment;
  protected DAOGroup daoGroup;
  protected ManagerGroup managerGroup;
  protected EventService eventService;
  protected String checkerBeanName = "checker";

  public BlockChainAdvancer getBlockChainAdvancer() {
    return blockChainAdvancer;
  }

  public void setBlockChainAdvancer(BlockChainAdvancer pBlockChainAdvancer) {
    blockChainAdvancer = pBlockChainAdvancer;
  }

  public StorageService getStorageService() {
    return storageService;
  }

  public void setStorageService(StorageService pStorageService) {
    storageService = pStorageService;
  }

  public String getCheckerBeanName() {
    return checkerBeanName;
  }

  public void setCheckerBeanName(String checkerBeanName) {
    this.checkerBeanName = checkerBeanName;
  }

  public EventService getEventService() {
    return eventService;
  }

  public void setEventService(EventService eventService) {
    this.eventService = eventService;
  }

  public String getEnvironmentName() {
    return environmentName;
  }

  public void setEnvironmentName(String environmentName) {
    this.environmentName = environmentName;
  }

  public DAOGroup getDaoGroup() {
    return daoGroup;
  }

  public void setDaoGroup(DAOGroup daoGroup) {
    this.daoGroup = daoGroup;
  }

  public ManagerGroup getManagerGroup() {
    return managerGroup;
  }

  public void setManagerGroup(ManagerGroup managerGroup) {
    this.managerGroup = managerGroup;
  }

  public Boolean getProductEnvironment() {
    return productEnvironment;
  }

  public void setProductEnvironment(Boolean productEnvironment) {
    this.productEnvironment = productEnvironment;
  }

  public CustomSecUserManagerImpl() {
    // TODO Auto-generated constructor stub
  }

  public String confirmSession(RetailscmUserContext userContext) {
    SecUser user = cachedUser(userContext);
    if (user == null) {
      return "FAIL";
    }
    return "OK";
  }

  public Object resetPassword(
      RetailscmUserContext userContext, String mobile, int verifycationCode, String newPassword) {

    SecUser user;
    try {
      user = this.loadUserWith(userContext, "mobile", mobile);
      if (isVerificationCodeExpired(user)) {
        return "VERIFIICATION_CODE_EXPIRED";
      }
      if (verifycationCode != user.getVerificationCode()) {
        return "VERIFIICATION_CODE_NOT_MATCH";
      }

      String hasedPassword = this.hashStringWithSHA256(newPassword, user.getId());
      user.setPwd(hasedPassword);
      this.saveSecUser(userContext, user, SecUserTokens.withoutLists());
      Password pwd = new Password(newPassword);
      return this.loginWithMobile(userContext, mobile, pwd);

    } catch (Exception e) {
      return "FAIL";
    }

    // return this.getSecUserDAO().clone(fromSecUserId, this.allTokens());
  }

  public Object resetPasswordWithoutLogin(
      RetailscmUserContext userContext,
      String loginType,
      String loginKey,
      int verifycationCode,
      String newPassword) {
    SecUser user;
    try {
      user = this.loadUserWith(userContext, loginType, loginKey);
      if (isVerificationCodeExpired(user)) {
        return "VERIFIICATION_CODE_EXPIRED";
      }
      if (verifycationCode != user.getVerificationCode()) {
        return "VERIFIICATION_CODE_NOT_MATCH";
      }

      // String hasedPassword = this.hashStringWithSHA256(newPassword, user.getId());
      user.updatePwd(newPassword);
      return this.saveSecUser(userContext, user, SecUserTokens.empty());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      return "FAIL";
    }
  }

  protected boolean isVerificationCodeExpired(SecUser user) {
    // TODO Auto-generated method stub
    return false;
  }

  public SecUser manage(RetailscmUserContext userContext) throws Exception {
    SecUser user = cachedUser(userContext);
    SecUser user2 = this.loadSecUser(userContext, user.getId(), this.allTokens());
    return this.present(userContext, user2, this.allTokens());
  }

  protected SecUser cachedUser(RetailscmUserContext userContext) {
    return (SecUser) userContext.getCachedObject(this.getUserKey(userContext), SecUser.class);
  }

  public SecUser getCachedSecUser(RetailscmUserContext userContext) {
    return cachedUser(userContext);
  }

  protected BaseEntity error(String message) {
    BaseEntity entity = new CommonError();
    entity.addErrorMessage(message, null);
    return entity;
  }

  public Object accessUserApp(RetailscmUserContext userContext, String targetUserAppId)
      throws Exception {

    Optional<UserApp> opUserApp = findOutUserApp(userContext, targetUserAppId);
    if (!opUserApp.isPresent()) {
      throw new IllegalStateException("未找到 " + targetUserAppId + "对应的UserApp");
    }

    UserApp userApp = (UserApp) opUserApp.get();

    UserApp fullAppData = userAppDaoOf(userContext).load(userApp.getId(), UserAppTokens.all());
    userContext.putToCache(getCurrentAppKey(userContext), fullAppData, 1000000);
    IamService iamService = (IamService) userContext.getBean("iamService");
    iamService.selectUserApp(userContext, fullAppData);

    String beanName = beanNameFromUserApp(userContext, userApp);
    Object targetBean = userContext.getBean(beanName);

    if (targetBean == null) {
      throw new IllegalAccessException("Not able to find for bean name " + beanName);
    }

    if (!(targetBean instanceof AccessControledService)) {

      throw new IllegalAccessException(
          "A bean without implement AccessControledService not allowed to be accessed");
    }

    AccessControledService targetService = (AccessControledService) targetBean;
    userContext.log("trying to access service " + targetService);

    return targetService.prepareContextForUserApp(userContext, userApp);
  }

  protected Object gotoApp(RetailscmUserContext userContext, UserApp app) throws Exception {

    UserApp fullAppData = userAppDaoOf(userContext).load(app.getId(), UserAppTokens.all());
    userContext.putToCache(getCurrentAppKey(userContext), fullAppData, 1000000);
    IamService iamService = (IamService) userContext.getBean("iamService");
    iamService.selectUserApp(userContext, fullAppData);
    // the app has all the accessable objects
    String targetBeanName = getBeanName(userContext, app);
    if (targetBeanName == null) {
      return error("targetBeanName is null");
    }
    Object targetObject = userContext.getBean(targetBeanName);
    if (targetObject == null) {
      userContext.log("出现这个错误很可能是数据库因为各种原因没到导入完成或者导入了错误的数据库脚本");
      return error("targetObject is not found for bean name " + targetBeanName);
    }

    String targetId = getTargetObjectId(userContext, app);
    if (targetId == null) {
      return error("targetId is null");
    }
    String serviceType = getServiceType(userContext, app);
    if (serviceType == null) {
      return error("serviceType is null");
    }
    String methodName = getMethodName(userContext, app);
    if (methodName == null) {
      return error("methodName is null");
    }

    // String
    try {

      String className = ucClassNameOf(serviceType);
      return invokeWithOneString(userContext, targetBeanName, methodName, className, targetId);
    } catch (NoSuchMethodException e) {

      return error("NoSuchMethodException: " + e.getMessage());
    } catch (SecurityException e) {

      return error("SecurityException: " + e.getMessage());
    } catch (IllegalAccessException e) {

      return error("IllegalAccessException: " + e.getMessage());
    } catch (IllegalArgumentException e) {

      return error("IllegalArgumentException: " + e.getMessage());
    } catch (InvocationTargetException e) {
      Throwable rootCause = e;
      while ((rootCause != null) && !(rootCause instanceof java.sql.SQLException)) {
        rootCause = rootCause.getCause();
      }
      if (rootCause instanceof java.sql.SQLException) {
        userContext.log(
            "SQL出错, 很可能模型更新后，JAVA代码更新了，但是数据库没有重新导入: " + e.getTargetException().getMessage());
      }
      return error("InvocationTargetException: 服务器出错，请管理员帮忙查看服务器端日志");

    } catch (Exception e) {
      e.printStackTrace();
      return error("Exception1: " + e.getMessage());
    }
  }

  public String showMessage(BaseUserContext baseUserContext) {
    return "hello";
  }

  public String getVerificationCode(RetailscmUserContext userContext, String mobile) {

    try {
      SecUser user = this.loadUserWith(userContext, "mobile", mobile);
      int verificationCode = getRandomVerificationCode(userContext, 6);
      user.setVerificationCode(verificationCode);
      user.setVerificationCodeExpire(userContext.now());

      sendVerificationCode(userContext, mobile, verificationCode + "");

      this.saveSecUser(userContext, user, SecUserTokens.withoutLists());

    } catch (Exception e) {
      // TODO Auto-generated catch block
      return "USER_NOT_FOUNT";
    }

    return "OK";
  }

  protected void sendVerificationCode(RetailscmUserContext userContext, String mobile, String code)
      throws Exception {
    Map<String, String> parameters = new HashMap<String, String>();

    parameters.put("passcode", code);

    userContext.sendMessage("13880964614", "开心帮帮兔", "SMS_33585577", parameters);
  }

  protected int getRandomVerificationCode(RetailscmUserContext userContex, int length) {
    int base = (int) Math.pow(10, length - 1);
    return base + (int) (9 * base * Math.random());
    // like 100+900*random

  }

  public String showMessage2(BaseUserContext baseUserContext) {
    return "hello";
  }

  protected String ucClassNameOf(String type) {
    // com.skynet.scm;
    String packageName = "com.skynet.scm";
    return packageName + "." + type.toLowerCase() + "." + type + "UserContext";
  }

  protected String getBeanName(RetailscmUserContext userContext, UserApp app) {

    String target = app.getAppType();
    String lowerCase = target.substring(0, 1).toLowerCase() + target.substring(1);
    return lowerCase + "Manager";
  }

  protected String getTargetObjectId(RetailscmUserContext userContext, UserApp app) {

    return app.getAppId();
  }

  protected String getServiceType(RetailscmUserContext userContext, UserApp app) {

    return app.getAppType();
  }

  protected String getMethodName(RetailscmUserContext userContext, UserApp app) {
    // return "load"+app.getAppType()+"Detail";
    return "view";
  }

  public Object home(RetailscmUserContext userContext) {
    SecUser user = (SecUser) userContext.getCachedObject(getUserKey(userContext), SecUser.class);
    if (user == null) {
      return showSessionExpired(userContext);
    }
    CustomSecUser customUser = new CustomSecUser();
    user.copyTo(customUser);
    return customUser;
  }

  public Object loginWithEmail(RetailscmUserContext userContext, String email, Password password) {

    return loginInternal(userContext, "email", email, password);
  }

  public Object login(RetailscmUserContext userContext, String email, Password password) {
    if (email.matches("1[3-9]\\d{9}")) {
      return loginWithMobile(userContext, email, password);
    }
    return loginInternal(userContext, "userId", email, password);
  }

  public Object loginWithLogin(RetailscmUserContext userContext, String email, Password password) {

    return loginInternal(userContext, "login", email, password);
  }

  public Object loginWithMobile(RetailscmUserContext userContext, String email, Password password) {
    return loginInternal(userContext, "mobile", email, password);
  }

  protected SecUser loadUserWith(RetailscmUserContext userContext, String type, String userId)
      throws Exception {
    if ("email".equals(type)) {
      return Q.secUser().filterByEmail(userId).selectUserAppList().execute(userContext);
      // return this.loadSecUserWithEmail(userContext, userId, this.allTokens());
    }
    if ("mobile".equals(type)) {
      return Q.secUser().filterByMobile(userId).selectUserAppList().execute(userContext);
      // return this.loadSecUserWithMobile(userContext, userId, this.allTokens());
    }
    if ("login".equals(type)) {
      return Q.secUser().filterByLogin(userId).selectUserAppList().execute(userContext);
      // return this.loadSecUserWithLogin(userContext, userId, this.allTokens());
    }
    return Q.secUser().filterById(userId).selectUserAppList().execute(userContext);
    // return this.loadSecUser(userContext, userId, this.allTokens());
  }
  // return a form or a user
  protected Object loginInternal(
      RetailscmUserContext userContext, String type, String userId, Password password) {

    try {
      SecUser user = this.loadUserWith(userContext, type, userId);

      String hashedPassed =
          this.hashStringWithSHA256(password.getClearTextPassword(), user.getId());
      log("hashed pass: " + hashedPassed);
      log("stored pass: " + user.getPwd());

      if (!user.getPwd().equals(hashedPassed)) {
        this.addLoginHistory(
            userContext, user.getId(), userContext.getRemoteIP(), "密码错误", "x".split("."));
        return errorLogin("密码错了!");
      }

      return loginTheSecUserInternal(userContext, user, "成功登陆");
    } catch (SecUserNotFoundException e) {
      return errorLogin("对不起，不认识你");
    } catch (Exception e) {
      return errorLogin("对不起, 系统出错，跟你没关系哈，你等会再试下" + e.getMessage());
    }
  }
  /** 内部登录。使用场景是当通过其他方式（微信，短信码等）验证了用户身份后，直接使用secUser对象登录。 */
  protected Object loginTheSecUserInternal(
      RetailscmUserContext userContext, SecUser user, String loginComments) throws Exception {
    // save it to Redis, then use it later
    Map<String, Object> tokens = new HashMap<String, Object>();
    tokens.put("userAppList", "userAppList");
    tokens.put("secUserList", "secUserList");
    tokens.put("objectAccessList", "objectAccessList");
    userContext.addAccessTokens(tokens);

    userContext.putToCache(getUserKey(userContext), user, 100000);
    IamService iamService = (IamService) userContext.getBean("iamService");
    iamService.onLoginSecUserInternalSuccess((RetailscmUserContextImpl) userContext, user);

    CustomSecUser customUser = new CustomSecUser();
    user.copyTo(customUser);

    user.addLoginHistory(
        this.createLoginHistory(
            userContext, userContext.getRemoteIP(), TextUtil.firstChars(loginComments, 16)));
    user.setLastLoginTime(userContext.now());
    this.saveSecUser(userContext, user, this.allTokens());

    return customUser;
  }

  public Object showlogin(RetailscmUserContext userContext) {

    userContext.removeFromCache(getUserKey(userContext));

    LoginForm form = new LoginForm();

    return form;
  }

  protected LoginForm showSessionExpired(RetailscmUserContext userContext) {

    LoginForm form = new LoginForm();
    form.addErrorMessage("登录过期了", null);
    // form.addErrorMessage(errorMessage, null);
    return form;
  }

  private void log(String message) {
    System.out.println("Message: " + message);
  }

  protected LoginForm errorLogin(String errorMessage) {
    LoginForm form = new LoginForm();
    form.addErrorMessage(errorMessage, null);
    return form;
  }

  public BaseUserContext loadUserConext(HttpServletRequest request) throws Exception {
    String path = getRequestPath(request);
    RetailscmUserContextImpl uc = createNewConext(path);
    init(uc, request);
    return uc;
  }

  private CacheService cacheService;

  public CacheService getCacheService() {
    return cacheService;
  }

  public void setCacheService(CacheService cacheService) {
    this.cacheService = cacheService;
  }

  private SMTPService smtpService;

  public SMTPService getSmtpService() {
    return smtpService;
  }

  public void setSmtpService(SMTPService smtpService) {
    this.smtpService = smtpService;
  }

  private MessageService messageService;

  public MessageService getMessageService() {
    return messageService;
  }

  public void setMessageService(MessageService messageService) {
    this.messageService = messageService;
  }

  private GraphService graphService;

  public GraphService getGraphService() {
    return graphService;
  }

  public void setGraphService(GraphService graphService) {
    this.graphService = graphService;
  }

  protected String publicMediaServicePrefix;

  public String getPublicMediaServicePrefix() {
    return publicMediaServicePrefix;
  }

  public void setPublicMediaServicePrefix(String publicMediaServicePrefix) {
    this.publicMediaServicePrefix = publicMediaServicePrefix;
  }

  protected RetailscmObjectChecker checker;

  public RetailscmObjectChecker getChecker() {
    return checker;
  }

  public void setChecker(RetailscmObjectChecker checker) {
    this.checker = checker;
  }

  protected Map<String, List<String>> allTerms;

  public Map<String, List<String>> getAllTerms() {
    return allTerms;
  }

  public void setAllTerms(Map<String, List<String>> allTerms) {
    this.allTerms = allTerms;
  }

  protected void init(UserContextImpl userContext, HttpServletRequest request) {

    BeanFactory beanFactory = (BeanFactory) request.getAttribute("beanFactory");
    userContext.setProductEnvironment(getProductEnvironment());
    userContext.setEnvironmentName(getEnvironmentName());
    userContext.setBeanFactory(beanFactory);
    userContext.setRemoteIP(getRemoteIP(request));
    userContext.setCacheService(cacheService);
    userContext.setLocationService(this.getLocationService());
    userContext.setChecker((RetailscmObjectChecker) beanFactory.getBean(getCheckerBeanName()));
    userContext.setSmtpService(smtpService);
    userContext.setGraphService(graphService);
    userContext.setMessageService(messageService);
    userContext.setBlockChainAdvancer(blockChainAdvancer);
    userContext.setTokenId(request.getSession().getId());
    userContext.setAllTerms(allTerms);
    userContext.setUserAgent(request.getHeader("User-Agent"));
    Enumeration<String> headerNames = request.getHeaderNames();
    if (headerNames != null) {
      while (headerNames.hasMoreElements()) {
        String name = headerNames.nextElement();
        String value = request.getHeader(name);
        userContext.putHeader(name.toLowerCase(), value);
      }
    }
    userContext.setPublicMediaServicePrefix(getPublicMediaServicePrefix());

    userContext.setRequestParameters((Map) request.getParameterMap());
    userContext.setRequestCookies(request.getCookies());
    userContext.setDaoGroup(getDaoGroup());
    userContext.setEventService(this.getEventService());
    userContext.setRequestUrl(request.getRequestURL().toString());
    userContext.setManagerGroup(getManagerGroup());
    userContext.setTreeService(getTreeService());
    userContext.setRequestBody(readBodyAsBytes(request));
    try {
      handleFormResubmit((RetailscmUserContextImpl) userContext, request);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected byte[] readBodyAsBytes(HttpServletRequest request) {
    try {
      return StreamUtils.copyToByteArray(request.getInputStream());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      return null;
    }
  }

  protected String getRemoteIP(HttpServletRequest request) {
    String remoteHost = request.getHeader("X-Forwarded-For");
    if (remoteHost != null) {
      return remoteHost;
    }
    return request.getRemoteAddr();
  }

  protected String getRequestPath(HttpServletRequest request) {
    String path = request.getRequestURI().substring(request.getContextPath().length());
    return path;
  }

  protected RetailscmUserContextImpl createNewConext(String path) {
    return new CustomRetailscmUserContextImpl();
  }

  protected void handleFormResubmit(RetailscmUserContextImpl ctx, HttpServletRequest request)
      throws Exception {
    boolean isPost = request.getMethod().equalsIgnoreCase("post");
    if (!isPost) {
      return;
    }
    byte[] bytes = ctx.getRequestBody();
    if (bytes == null) {
      bytes = new byte[] {};
    }
    String md5 = calcPostBodyMd5(ctx, request, bytes);
    String existedPostMd5 = (String) ctx.getCachedObject(getPostMd5Key(ctx), String.class);
    if (existedPostMd5 != null && existedPostMd5.equals(md5)) {
      System.out.println("[ DEBUG ]" + existedPostMd5 + " VS " + md5 + ", Put into cache");
      ctx.putIntoContextLocalStorage(RetailscmBaseConstants.KEY_RE_SUBMIT, true);
      return;
    }
    System.out.println("[ DEBUG ]" + existedPostMd5 + " VS " + md5 + ", update cache");
    ctx.putToCache(getPostMd5Key(ctx), md5, 30); // 30秒内不得重新提交
  }

  public static String getPostMd5Key(RetailscmUserContextImpl ctx) {
    return ctx.tokenId() + ":postMd5Key";
  }

  protected String calcPostBodyMd5(
      RetailscmUserContextImpl ctx, HttpServletRequest request, byte[] bytes) throws Exception {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      String contentStr = request.getRequestURI() + ":";
      try {
        contentStr +=
            ctx.getRequestParameters() == null
                ? ""
                : DebugUtil.getObjectMapper().writeValueAsString(ctx.getRequestParameters());
      } catch (JsonProcessingException e) {
      }
      int tokenLength = contentStr.getBytes(StandardCharsets.UTF_8).length;
      byte[] contentBytes = new byte[tokenLength + bytes.length];
      System.arraycopy(
          contentStr.getBytes(StandardCharsets.UTF_8), 0, contentBytes, 0, tokenLength);
      System.arraycopy(bytes, 0, contentBytes, tokenLength, bytes.length);
      byte[] hash = digest.digest(contentBytes);
      StringBuilder stringBuilder = new StringBuilder();
      for (byte b : hash) {
        stringBuilder.append(String.format("%02X", b));
      }
      return stringBuilder.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException(e);
    }
  }

  public void saveUserContext(BaseUserContext uc) throws Exception {
    // TODO Auto-generated method stub

  }

  public Object checkOtherLogin(RetailscmUserContext userContext) throws Exception {

    SecUser user = (SecUser) userContext.getCachedObject(getUserKey(userContext), SecUser.class);
    // compare the user in db;
    String tokens[] =
        SecUserTokens.start()
            .withLoginHistoryList()
            .sortLoginHistoryListWith(LoginHistory.LOGIN_TIME_PROPERTY, "desc")
            .toArray();

    SecUser userInDB =
        userContext
            .getManagerGroup()
            .getSecUserManager()
            .loadSecUser(userContext, user.getId(), tokens);
    if (user.getLastLoginTime().after(userInDB.getLastLoginTime())) {
      // 如果不一样，而且比缓存里面的用户更新一些
      return "OK";
    }
    // 如果标记为已经处理过了，则不显示消息。
    String key = getUserKey(userContext) + ":loginfromotherip";
    String fromIp = userInDB.getLoginHistoryList().first().getFromIp();
    String proceedIp = (String) userContext.getCachedObject(key, String.class);
    if (fromIp.equals(proceedIp)) {

      return "PROCEED";
    }

    userContext.putToCache(key, fromIp, 86400);
    return "有其他人用跟你同一个账号在" + fromIp + "登录";
    // 有其他人登录

  }

  //////////////////////////// START OF THE CUSTOM IMPL FUNCITONS///////////////////////////////////

  boolean isOneOf(String value, String candiates[]) {
    for (String candidate : candiates) {
      if (value.equals(candidate)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
      throws IllegalAccessException {

    if (methodName.startsWith("login")) {
      return accessOK();
    }
    if (methodName.startsWith("show")) {
      return accessOK();
    }
    if (methodName.startsWith("accessUserApp")) {
      return accessOK();
    }
    if (methodName.startsWith("accessUserApp")) {
      return accessOK();
    }
    if (methodName.startsWith("home")) {
      return accessOK();
    }
    if (methodName.startsWith("resetPassForm")) {
      return accessOK();
    }
    if (methodName.startsWith("verificationCodeForm")) {
      return accessOK();
    }
    if (methodName.startsWith("changeCurUserPassword")) {
      return accessOK();
    }
    String managementAccessMethods[] =
        new String[] {
          "updateAppPermission",
          "updateListAccess",
          "loadUserAppWithUser",
          "updateListAccess",
          "testIfHasManagementAccess"
        };

    if (this.isOneOf(methodName, managementAccessMethods)) {

      return this.accessOK();
    }

    return super.checkAccess(baseUserContext, methodName, parameters);
  }

  protected boolean isMe(UserApp app, String appType, String appId) {

    if (!app.getAppType().equalsIgnoreCase(appType)) {
      return false;
    }
    if (!app.getAppId().equals(appId)) {
      return false;
    }
    return true;
  }

  protected void checkUserHasManagementAccess(
      RetailscmUserContext userContext, String appType, String appId)
      throws SecUserManagerException {

    final String MANAGEMENT_TOKEN = "M";
    UserApp app =
        (UserApp) userContext.getCachedObject(this.getCurrentAppKey(userContext), UserApp.class);

    if (app == null) {
      userContext.log("app is null!");
      this.throwExceptionWithMessage("你没有管理该对象的权限，");
    }

    if (isMe(app, appType, appId)) {
      String permission = app.getPermission();
      if (permission.contains(MANAGEMENT_TOKEN)) {
        return; // has direct access
      }
    }
    // 不是本级权限，需要查询关系

    List<String[]> relations =
        userContext.relationBetween(appType, appId, app.getAppType(), app.getAppId());
    if (this.hasIndirectRight(userContext, app.getPermission(), MANAGEMENT_TOKEN, relations)) {
      return;
    }

    this.throwExceptionWithMessage("你没有管理该对象的权限，");
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Start Of privilege control
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  protected SecUserTokens buildLoadTokens(String appType, String appId) {
    SecUserTokens tokens =
        SecUserTokens.start()
            .withUserAppList()
            .searchUserAppListWith(UserApp.APP_TYPE_PROPERTY, tokens().equals(), appType)
            .searchUserAppListWith(UserApp.APP_ID_PROPERTY, tokens().equals(), appId);

    return tokens;
  }

  public UserApp updateAppPermission(
      RetailscmUserContext userContext,
      String secUserId,
      String userAppId,
      int version,
      String permission)
      throws Exception {

    String targetPermission = permission;
    return userContext
        .getManagerGroup()
        .getUserAppManager()
        .updateUserApp(
            userContext,
            userAppId,
            version,
            "permission",
            targetPermission,
            UserAppTokens.mergeAll(new String[] {}).toArray());
  }

  protected UserApp patchWithTokens(UserApp userApp, String tokensExpr, String displayName) {

    // this.checkUserHasManagementAccess(userContext, userApp.getAppType(), userApp.getAppId());

    for (ListAccess access : userApp.getListAccessList()) {
      resetListAccess(access);
    }

    if (tokensExpr == null) {
      return userApp;
    }
    String tokens[] = tokensExpr.split(",");

    for (String token : tokens) {

      String keyValuePair[] = token.split("\\.");
      if (keyValuePair.length < 2) {
        continue;
      }
      String key = keyValuePair[0];
      ListAccess access = searchOrCreateListAccess(userApp, key);
      access.updateName(displayName);
      String value = keyValuePair[1];
      eval(access, value);
    }

    return userApp;
  }

  protected void resetListAccess(ListAccess access) {
    // TODO Auto-generated method stub
    access.updateReadPermission(false);
    access.updateCreatePermission(false);
    access.updateUpdatePermission(false);
    access.updateDeletePermission(false);
    access.updateExecutionPermission(false);
  }

  protected ListAccess eval(ListAccess access, String value) {
    // 其他的情况不改
    if (value.endsWith("Permission")) {
      access.changeProperty(value, "true");
    }

    return access;
  }

  protected ListAccess searchOrCreateListAccess(UserApp userApp, String key) {

    for (ListAccess access : userApp.getListAccessList()) {
      if (access.getInternalName().equals(key)) {
        return access;
      }
    }
    ListAccess listAccess = new ListAccess();
    listAccess.setInternalName(key);
    userApp.addListAccess(listAccess);

    return listAccess;
  }

  public UserApp updateListAccess(
      RetailscmUserContext userContext,
      String secUserId,
      String userAppId,
      String displayName,
      String permissionTokens)
      throws Exception {

    UserAppTokens token = UserAppTokens.start().withListAccessList();

    UserApp userApp =
        userContext
            .getManagerGroup()
            .getUserAppManager()
            .loadUserApp(userContext, userAppId, token.toArray());

    this.checkUserHasManagementAccess(userContext, userApp.getAppType(), userApp.getAppId());

    this.patchWithTokens(userApp, permissionTokens, displayName);

    return userContext
        .getManagerGroup()
        .getUserAppManager()
        .internalSaveUserApp(userContext, userApp, token.done());
  }

  public UserApp loadUserAppWithUser(
      RetailscmUserContext userContext,
      String secUserId,
      String appType,
      String appId,
      String title,
      String appIcon)
      throws Exception {

    userContext
        .getChecker()
        .checkIdOfSecUser(secUserId)
        .checkAppTypeOfUserApp(appType)
        .checkAppIdOfUserApp(appId)
        .throwExceptionIfHasErrors(SecUserManagerException.class);

    this.checkUserHasManagementAccess(userContext, appType, appId);

    SecUser secUser =
        this.loadSecUser(userContext, secUserId, buildLoadTokens(appType, appId).done());

    if (secUser.getUserAppList().isEmpty()) {

      UserApp newApp = new UserApp();

      newApp
          .updateTitle(title)
          .updateAppIcon(appIcon)
          .updateAppType(appType)
          .updateAppId(appId)
          .updateFullAccess(true)
          .updateLocation("nolink");

      secUser.addUserApp(newApp);
      this.saveSecUser(userContext, secUser, this.tokens().withUserAppList().done());

      return newApp;
    }

    UserApp userApp = secUser.getUserAppList().first();

    UserAppTokens token = UserAppTokens.start().withListAccessList();

    UserApp userAppInDB =
        userContext
            .getManagerGroup()
            .getUserAppManager()
            .loadUserApp(userContext, userApp.getId(), token.toArray());

    return userAppInDB;
  }

  public Object changeCurUserPassword(
      RetailscmUserContext userContext, String currentPassword, String newPassword)
      throws Exception {
    SecUser curUser = cachedUser(userContext);

    if (curUser == null) {
      this.throwExceptionWithMessage("修改密码之前必须登录，如果当前您已经登录，请退出后再试");
    }

    curUser = this.loadSecUser(userContext, curUser.getId(), new String[] {});

    String hasedPassword = this.hashStringWithSHA256(currentPassword, curUser.getId());

    if (!hasedPassword.equals(curUser.getPwd())) {
      throw new SecUserManagerException("当前密码输入错误, 请重新输入");
    }
    String newHasedPassword = this.hashStringWithSHA256(newPassword, curUser.getId());
    curUser.updatePwd(newPassword);
    this.saveSecUser(userContext, curUser, SecUserTokens.withoutLists());
    return "OK";
  }

  public String testIfHasManagementAccess(
      RetailscmUserContext userContext, String appType, String appId) {
    try {
      this.checkUserHasManagementAccess(userContext, appType, appId);
      return "OK";
    } catch (Exception e) {
      return "FAIL";
    }
  }

  public Map<String, Object> testoss(RetailscmUserContext userContext)
      throws SecUserManagerException {

    String key = this.getCurrentAppKey(userContext);
    UserApp userApp = (UserApp) userContext.getCachedObject(key, UserApp.class);
    if (userApp == null) {
      throwExceptionWithMessage("用户要访问此功能，至少需要登录，并且选择了一个确定的App");
    }
    String folderName = String.format("upload/%s/%s", userApp.getAppType(), userApp.getAppId());
    Map<String, Object> ossToken = storageService.genToken(folderName);
    System.out.println("ossToken=" + ossToken);
    return ossToken;
  }
}
