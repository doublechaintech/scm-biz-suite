package com.doublechaintech.retailscm.iamservice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.terapico.utils.*;

public abstract class BaseIamService {
  public static final Map<String, Object> EO = new HashMap<>();
  // 按照配置的顺序决定先用哪个id-handler,所以用LinkedHashMap
  protected LinkedHashMap<String, IdentificationHandler> idHandlers;
  // user time-to-live in seconds. By default it's 1 week.
  protected int userTtlInSecond = (int) (7 * DateTimeUtil.DAY_IN_MS / DateTimeUtil.SECOND_IN_MS);

  public int getUserTtlInSecond() {
    return userTtlInSecond;
  }

  public void setUserTtlInSecond(int userTtlInSecond) {
    this.userTtlInSecond = userTtlInSecond;
  }

  public LinkedHashMap<String, IdentificationHandler> getIdHandlers() {
    return idHandlers;
  }

  public void setIdHandlers(LinkedHashMap<String, IdentificationHandler> idHandlers) {
    this.idHandlers = idHandlers;
  }

  public LoginResult doLogin(
      RetailscmUserContextImpl userContext, LoginContext loginContext, BusinessHandler bizHandler)
      throws Exception {
    IdentificationHandler handler = selectIdentificationHandler(userContext, loginContext);
    LoginResult loginResult = handler.authenticate(userContext, loginContext);
    if (!loginResult.isAuthenticated()) {
      onAuthenticationFailed(userContext, loginContext, loginResult, handler, bizHandler);
      return loginResult;
    }

    if (loginResult.hasSecUser()) {
      onAuthenticateUserLogged(userContext, loginContext, loginResult, handler, bizHandler);
      return loginResult;
    }

    onAuthenticateNewUserLogged(userContext, loginContext, loginResult, handler, bizHandler);
    return loginResult;
  }

  public Object doLogout(RetailscmUserContextImpl userContext, BusinessHandler bizHandler)
      throws Exception {
    // 回调业务
    Object logOutResult = bizHandler.onLogout(userContext, bizHandler);
    // 选一个token key
    getTokenKey(userContext);
    String cacheKey = getLoginInfoCacheKey(userContext);
    userContext.removeFromCache(cacheKey);

    // 生成 anonymous jwtToken
    userContext.setTokenId("anonymous" + RandomUtil.randomNumAndChars(12));
    String tokenKey = userContext.tokenId();
    String userId = "anonymous";
    String userUploadHome = makeUserUploadHomeWhenLogged(null, null);
    String envType =
        userContext.isProductEnvironment() ? "product" : userContext.getEnvironmentName();
    String jToken = JWTUtil.getJwtToken(userId, userUploadHome, envType, tokenKey);
    // cache
    Map<String, Object> loginInfo = MapUtil.put("tokenKey", tokenKey).into_map();
    userContext.putToCache(getLoginInfoCacheKey(userContext), loginInfo, getUserTtlInSecond());
    // set to header
    userContext.setResponseHeader(JWTUtil.HEADER_NAME, jToken);

    return logOutResult;
  }
  /**
   * 当登录认证通过,但是无法获得对应的secUser时(即一个新用户登入了),调用此接口.
   *
   * @throws Exception
   */
  protected void onAuthenticateNewUserLogged(
      RetailscmUserContextImpl userContext,
      LoginContext loginContext,
      LoginResult loginResult,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler)
      throws Exception {
    loginResult.setNewUser(true);
    // 先交给业务模块去处理此种情况,万一皆大欢喜了,就正常处理了
    bizHandler.onAuthenticateNewUserLogged(
        userContext, loginContext, loginResult, idHandler, bizHandler);
    if (loginResult.hasSecUser()) {
      idHandler.bindWithSecUser(userContext, loginContext);
      // 业务模块将secUser正常归位了,就按正常的处理
      onAuthenticateUserLogged(userContext, loginContext, loginResult, idHandler, bizHandler);
      return;
    }
    // 业务模块也没有办法处理新用户, 只好结束了
    // return
  }

  /** 当登录认证通过,并且获得了确定的secUser时,调用此接口. */
  protected void onAuthenticateUserLogged(
      RetailscmUserContextImpl userContext,
      LoginContext loginContext,
      LoginResult loginResult,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler)
      throws Exception {
    // 回调业务
    bizHandler.onAuthenticateUserLogged(
        userContext, loginContext, loginResult, idHandler, bizHandler);
    // 选一个token key
    String tokenKey = userContext.tokenId();
    if (!isLoginClientSupportSession(userContext, loginContext, idHandler, bizHandler)) {
      if (TextUtil.isBlank(userContext.tokenId())) {
        tokenKey = "token_" + RandomUtil.randomNumAndChars(20);
        ((UserContextImpl) userContext).setTokenId(tokenKey);
      }
    }
    // 生成 jwtToken
    SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
    userContext.setSecUser(secUser);
    UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
    userContext.setUserApp(userApp);
    String userId = secUser == null ? "anonymous" : secUser.getId();
    String userUploadHome = makeUserUploadHomeWhenLogged(secUser, userApp);
    String envType =
        userContext.isProductEnvironment() ? "product" : userContext.getEnvironmentName();
    String jToken = JWTUtil.getJwtToken(userId, userUploadHome, envType, tokenKey);
    // cache
    userContext.putToCache(this.getUserKey(userContext), secUser, getUserTtlInSecond());
    userContext.putToCache(this.getCurrentAppKey(userContext), userApp, getUserTtlInSecond());
    Map<String, Object> loginInfo = new HashMap<>();
    if (secUser != null) {
      loginInfo.put("secUser", secUser.getId());
    }
    if (userApp != null) {
      loginInfo.put("userApp", userApp.getId());
    }
    loginInfo.put("tokenKey", tokenKey);
    loginInfo.put(
        "additionalInfo", loginResult.getLoginContext().getLoginTarget().getAdditionalInfo());
    userContext.putToCache(getLoginInfoCacheKey(userContext), loginInfo, getUserTtlInSecond());
    // set to header
    userContext.setResponseHeader(JWTUtil.HEADER_NAME, jToken);
    // cookie 不用设置,默认在JSP的场景下,由jsp自己处理. 现在JSP不是推荐的C端技术
  }

  // 为兼容旧版本secUser登录接口
  public void onLoginSecUserInternalSuccess(RetailscmUserContextImpl userContext, SecUser user) {
    String tokenKey = userContext.tokenId();
    // 生成 jwtToken
    SecUser secUser = user;
    String userId = secUser.getId();
    String userUploadHome = makeUserUploadHomeWhenLogged(secUser, null);
    String envType =
        userContext.isProductEnvironment() ? "product" : userContext.getEnvironmentName();
    String jToken = JWTUtil.getJwtToken(userId, userUploadHome, envType, tokenKey);
    Map<String, Object> loginInfo =
        MapUtil.putIf(secUser != null, "secUser", user.getId())
            .put("tokenKey", tokenKey)
            .into_map();
    userContext.putToCache(getLoginInfoCacheKey(userContext), loginInfo, getUserTtlInSecond());
    // set to header
    userContext.setResponseHeader(JWTUtil.HEADER_NAME, jToken);
  }

  /**
   * 根据约定, 给出当前用户上传文件的根目录. 此参数是集成oss时启用的. 视项目情况,可以重载
   *
   * <p>默认是 upload/<user app type>/<user app id>
   */
  protected String makeUserUploadHomeWhenLogged(SecUser secUser, UserApp userApp) {
    if (userApp == null && secUser == null) {
      return "upload/retailscm/anonymous";
    }
    if (secUser != null) {
      return String.format("upload/retailscm/%s/%s", SecUser.INTERNAL_TYPE, secUser.getId());
    }
    return String.format("upload/retailscm/%s/%s", userApp.getAppType(), userApp.getAppId());
  }

  /**
   * 判断登录渠道的客户端,是否支持 session
   *
   * <p>默认都支持. 不支持的情况下,请重载此方法,根据项目上的约定,进行甄别.
   */
  protected boolean isLoginClientSupportSession(
      RetailscmUserContextImpl userContext,
      LoginContext loginContext,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler) {
    // 默认支持
    return true;
  }

  /**
   * 当登录认证失败后,调用此接口.
   *
   * <p>默认只是调用biz-handler的事件处理而已
   */
  protected void onAuthenticationFailed(
      RetailscmUserContextImpl userContext,
      LoginContext loginContext,
      LoginResult loginResult,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler)
      throws Exception {
    bizHandler.onAuthenticationFailed(
        userContext, loginContext, loginResult, idHandler, bizHandler);
  }

  /**
   * 根据登陆上下文, 确定使用哪个identification-handler.
   *
   * <p>默认实现为: 注册登录渠道的key,对应某个id-handler. 例如, 从 app 登录的, 使用手机号验证的, 通过'userService' bean 的 login
   * 接口的key, 默认表达为 MOBILE://app/userService/login
   *
   * @param userContext
   * @param loginContext
   * @return
   */
  protected IdentificationHandler selectIdentificationHandler(
      RetailscmUserContextImpl userContext, LoginContext loginContext) {
    if (loginContext.getLoginMethod().equals(LoginMethod.ID_4_DEBUG)) {
      return new IdentificationHandler() {

        @Override
        public LoginResult authenticate(
            RetailscmUserContext userContext, LoginContext loginContext) {
          LoginResult result = new LoginResult();
          result.setLoginContext(loginContext);
          result.setAuthenticated(true);
          result.setSuccess(true);
          result.setNewUser(false);

          String id = loginContext.getLoginData().getLoginId();
          int idx = id.indexOf("_");
          String objType = id.substring(0, idx);
          String objId = id.substring(idx + 1);

          UserApp userApp =
              RetailscmUserContextImpl.getUserAppByBindedEntity(
                  userContext, BaseEntity.pretendToBe(objType, objId));
          if (userApp == null) {
            throw new ErrorMessageException("输入的" + id + "没有对应的userApp被创建");
          }
          loginContext.getLoginTarget().setUserApp(userApp);
          loginContext.getLoginTarget().setSecUser(userApp.getSecUser());

          return result;
        }

        @Override
        public void bindWithSecUser(RetailscmUserContext userContext, LoginContext loginContext)
            throws Exception {
          // nothing to do
        }
      };
    }
    if (idHandlers == null) {
      throw new RuntimeException("您必须首先初始化IamService的idHandlers");
    }
    String key = loginContext.getKey();
    // 这里使用 linkedHashMap, 会按照配置的顺序,逐个比较当前登陆渠道的key是否匹配配置的key
    Iterator<String> it = idHandlers.keySet().iterator();
    while (it.hasNext()) {
      String cfgKey = it.next();
      if (key.matches(cfgKey)) {
        return idHandlers.get(cfgKey);
      }
    }
    throw new RuntimeException("您未定义登录key=" + key + "的认证器,请正确配置或重载selectIdentificationHandler()");
  }

  protected String getLoginInfoCacheKey(RetailscmUserContextImpl userContext) {
    return this.getCacheKey(userContext, "loginInfo");
  }

  protected String getJwtTokenCacheKey(RetailscmUserContextImpl userContext) {
    return this.getCacheKey(userContext, "jwtToken");
  }

  // 获取token key的优先级为: jwtToken->cookie->session id
  public String getTokenKey(RetailscmUserContextImpl userContext) {
    DecodedJWT jwtToken = getJwtTokenFromHeader(userContext);
    if (jwtToken == null) {
      jwtToken = getJwtTokenFromCookie(userContext);
    }
    if (jwtToken != null) {
      cacheJwtToken(userContext, jwtToken);
      String tokenKey = jwtToken.getClaim("tokenKey").asString();
      fixUserContextTokenId(userContext, tokenKey);
      return tokenKey;
    }
    return userContext.tokenId();
  }

  protected void cacheJwtToken(RetailscmUserContextImpl userContext, DecodedJWT jwtToken) {
    userContext.putIntoContextLocalStorage(getJwtTokenCacheKey(userContext), jwtToken);
  }

  protected DecodedJWT getCachedJwtToken(RetailscmUserContextImpl userContext) {
    return (DecodedJWT) userContext.getFromContextLocalStorage(getJwtTokenCacheKey(userContext));
  }

  protected DecodedJWT getJwtTokenFromCookie(RetailscmUserContextImpl userContext) {
    Cookie[] cookies = userContext.getRequestCookies();
    if (cookies == null) {
      return null;
    }
    for (Cookie cookie : cookies) {
      if (cookie.getName().equalsIgnoreCase(JWTUtil.HEADER_NAME)) {
        String jwtStr = cookie.getValue();
        return JWTUtil.decodeToken(jwtStr);
      }
    }
    return null;
  }

  protected DecodedJWT getJwtTokenFromHeader(RetailscmUserContextImpl userContext) {
    String jwtHeader = userContext.getRequestHeader(JWTUtil.HEADER_NAME);
    if (TextUtil.isBlank(jwtHeader)) {
      return null;
    }
    return JWTUtil.decodeToken(jwtHeader);
  }

  public Map<String, Object> getCachedLoginInfo(RetailscmUserContextImpl userContext) {
    getTokenKey(userContext);
    String cacheKey = getLoginInfoCacheKey(userContext);
    return userContext.getCachedObject(cacheKey, Map.class);
  }

  // //////////////////////////////////////////////////
  protected String getCacheKey(UserContext userContext, String prefix) {
    return "retailscm:" + prefix + ":" + userContext.tokenId();
  }

  protected String getUserKey(UserContext userContext) {
    return "retailscm:user:" + userContext.tokenId();
  }

  protected String getCurrentAppKey(UserContext userContext) {
    return getUserKey(userContext) + ":currentApp";
  }

  protected void fixUserContextTokenId(RetailscmUserContextImpl userContext, String tokenKey) {
    if (!userContext.tokenId().equals(tokenKey)) {
      userContext.setTokenId(tokenKey);
    }
  }

  public SecUser tryToLoadSecUser(
      RetailscmUserContextImpl userContext, Map<String, Object> loginInfo) {
    if (loginInfo == null) {
      userContext.removeFromCache(getUserKey(userContext));
      return null;
    }
    String secUserId = (String) loginInfo.get("secUser");
    if (TextUtil.isBlank(secUserId)) {
      userContext.removeFromCache(getUserKey(userContext));
      return null;
    }
    try {
      return userContext.getDAOGroup().getSecUserDAO().load(secUserId, EO);
    } catch (Exception e) {
      e.printStackTrace();
      // throw new RuntimeException("加载用户出错:"+e.getMessage(), e);
      userContext.removeFromCache(getUserKey(userContext));
      return null;
    }
  }

  public UserApp tryToLoadUserApp(
      RetailscmUserContextImpl userContext, Map<String, Object> loginInfo) {
    if (loginInfo == null) {
      userContext.removeFromCache(getCurrentAppKey(userContext));
      return null;
    }

    String userAppId = (String) loginInfo.get("userApp");
    if (TextUtil.isBlank(userAppId)) {
      userContext.removeFromCache(getCurrentAppKey(userContext));
      return null;
    }
    try {
      return userContext.getDAOGroup().getUserAppDAO().load(userAppId, EO);
    } catch (Exception e) {
      e.printStackTrace();
      // throw new RuntimeException("加载用户出错:"+e.getMessage(), e);
      userContext.removeFromCache(getCurrentAppKey(userContext));
      return null;
    }
  }
  /**
   * 当checkAccess() 没有找到secUser时调用
   *
   * @param loginInfo
   */
  public void onCheckAccessWhenAnonymousFound(
      RetailscmUserContextImpl userContext, Map<String, Object> loginInfo) {
    if (loginInfo != null && loginInfo.get("tokenKey") != null) {
      return;
    }
    // 选一个token key
    String tokenKey = userContext.tokenId();
    if (!isLoginClientSupportSession(userContext, null, null, null)) {
      if (TextUtil.isBlank(tokenKey)) {
        tokenKey = "token_" + RandomUtil.randomNumAndChars(20);
        ((UserContextImpl) userContext).setTokenId(tokenKey);
      }
    }
    // 生成 anonymous jwtToken
    String userId = "anonymous";
    String userUploadHome = makeUserUploadHomeWhenLogged(null, null);
    String envType =
        userContext.isProductEnvironment() ? "product" : userContext.getEnvironmentName();
    String jToken = JWTUtil.getJwtToken(userId, userUploadHome, envType, tokenKey);
    // cache
    loginInfo = MapUtil.put("tokenKey", tokenKey).into_map();
    userContext.putToCache(getLoginInfoCacheKey(userContext), loginInfo, getUserTtlInSecond());
    // set to header
    userContext.setResponseHeader(JWTUtil.HEADER_NAME, jToken);
  }

  public Object forceLoginAs(
      RetailscmUserContextImpl userContext, BaseEntity loginTarget, BusinessHandler bizHandler)
      throws Exception {
    if (userContext.isProductEnvironment()) {
      throw new Exception("只有测试环境才可使用此方法");
    }
    UserApp userApp = RetailscmUserContextImpl.getUserAppByBindedEntity(userContext, loginTarget);
    if (userApp == null) {
      throw new Exception(loginTarget.fullId() + "还没有绑定userApp");
    }
    SecUser secUser = userApp.getSecUser();
    LoginResult loginResult = new LoginResult();

    LoginContext loginContext = new LoginContext();
    loginContext.setLoginChannel(LoginChannel.of("debug", null, "testLogin"));
    LoginTarget lgTarget = new LoginTarget();
    lgTarget.setUserApp(userApp);
    lgTarget.setSecUser(secUser);
    loginContext.setLoginTarget(lgTarget);
    loginResult.setLoginContext(loginContext);
    loginResult.setSuccess(true);
    loginResult.setAuthenticated(true);
    loginResult.setMessage("测试登录");
    loginResult.setNewUser(false);

    onAuthenticateUserLogged(userContext, loginContext, loginResult, null, bizHandler);
    return loginResult;
  }

  public void selectUserApp(RetailscmUserContext userContext, UserApp userApp) throws Exception {
    RetailscmUserContextImpl ctx = (RetailscmUserContextImpl) userContext;
    String key = getLoginInfoCacheKey(ctx);
    Map<String, Object> loginInfo = ctx.getCachedObject(key, Map.class);
    loginInfo.put("userApp", userApp.getId());
    ctx.putToCache(key, loginInfo, getUserTtlInSecond());
  }
}
