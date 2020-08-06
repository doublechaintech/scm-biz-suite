package com.doublechaintech.retailscm.iamservice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.UserContext;
import com.doublechaintech.retailscm.UserContextImpl;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.terapico.utils.*;


public abstract class BaseIamService {
	private static final Map<String, Object> EO = new HashMap<>();
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

	public LoginResult doLogin(RetailscmUserContextImpl userContext, LoginContext loginContext, BusinessHandler bizHandler) throws Exception {
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

  public Object doLogout(RetailscmUserContextImpl userContext, BusinessHandler bizHandler) throws Exception {
		// 回调业务
    Object logOutResult = bizHandler.onLogout(userContext, bizHandler);
    // 选一个token key
    getTokenKey(userContext);
    String cacheKey = getLoginInfoCacheKey(userContext);
    userContext.removeFromCache(cacheKey);
    return logOutResult;
	}
	/**
	 * 当登录认证通过,但是无法获得对应的secUser时(即一个新用户登入了),调用此接口.
	 * @throws Exception
	 */
	protected void onAuthenticateNewUserLogged(RetailscmUserContextImpl userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception {
		loginResult.setNewUser(true);
		// 先交给业务模块去处理此种情况,万一皆大欢喜了,就正常处理了
		bizHandler.onAuthenticateNewUserLogged(userContext, loginContext, loginResult, idHandler, bizHandler);
		if (loginResult.hasSecUser()) {
			// 业务模块将secUser正常归位了,就按正常的处理
			onAuthenticateUserLogged(userContext, loginContext, loginResult, idHandler, bizHandler);
			return;
		}
		// 业务模块也没有办法处理新用户, 只好结束了
		// return
	}

	/**
	 * 当登录认证通过,并且获得了确定的secUser时,调用此接口.
	 *
	 */
	protected void onAuthenticateUserLogged(RetailscmUserContextImpl userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception {
		// 回调业务
		bizHandler.onAuthenticateUserLogged(userContext, loginContext, loginResult, idHandler, bizHandler);
		// 选一个token key
		String tokenKey = userContext.tokenId();
		if (!isLoginClientSupportSession(userContext, loginContext, idHandler, bizHandler)) {
			tokenKey = "token_"+RandomUtil.randomNumAndChars(20);
			((UserContextImpl)userContext).setTokenId(tokenKey);
		}
		// 生成 jwtToken
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		String userId = secUser.getId();
		String userUploadHome = makeUserUploadHomeWhenLogged(secUser, userApp);
		String envType = userContext.isProductEnvironment()?"product":userContext.getEnvironmentName();
		String jToken = JWTUtil.getJwtToken(userId, userUploadHome, envType, tokenKey);
		// cache
		userContext.putToCache(this.getUserKey(userContext), secUser, getUserTtlInSecond());
		userContext.putToCache(this.getCurrentAppKey(userContext), userApp, getUserTtlInSecond());
		Map<String, Object> loginInfo = MapUtil.putIf(secUser!=null, "secUser", secUser.getId())
				.putIf(userApp != null, "userApp", userApp.getId())
				.put("tokenKey", tokenKey)
				.putIf("additionalInfo", loginResult.getLoginContext().getLoginTarget().getAdditionalInfo())
				.into_map();
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
		String envType = userContext.isProductEnvironment() ? "product" : userContext.getEnvironmentName();
		String jToken = JWTUtil.getJwtToken(userId, userUploadHome, envType, tokenKey);
		Map<String, Object> loginInfo = MapUtil.putIf(secUser!=null, "secUser", user.getId())
				.put("tokenKey", tokenKey)
				.into_map();
		userContext.putToCache(getLoginInfoCacheKey(userContext), loginInfo, getUserTtlInSecond());
		// set to header
		userContext.setResponseHeader(JWTUtil.HEADER_NAME, jToken);
	}

	/** 根据约定, 给出当前用户上传文件的根目录. 此参数是集成oss时启用的. 视项目情况,可以重载
	 *
	 * 默认是 upload/<user app type>/<user app id>
	 */
	protected String makeUserUploadHomeWhenLogged(SecUser secUser, UserApp userApp) {
		if (userApp == null && secUser == null) {
			return "upload/anonymuse";
		}
		if (secUser != null) {
			return String.format("upload/%s/%s", SecUser.INTERNAL_TYPE, secUser.getId());
		}
		return String.format("upload/%s/%s", userApp.getObjectType(), userApp.getObjectId());
	}

	/** 判断登录渠道的客户端,是否支持 session
	 *
	 * 默认都支持. 不支持的情况下,请重载此方法,根据项目上的约定,进行甄别.
	 */
	protected boolean isLoginClientSupportSession(RetailscmUserContextImpl userContext, LoginContext loginContext,
			IdentificationHandler idHandler, BusinessHandler bizHandler) {
		// 默认支持
		return true;
	}

	/**
	 * 当登录认证失败后,调用此接口.
	 *
	 * 默认只是调用biz-handler的事件处理而已
	 */
	protected void onAuthenticationFailed(RetailscmUserContextImpl userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception {
		bizHandler.onAuthenticationFailed(userContext, loginContext, loginResult, idHandler, bizHandler);
	}

	/**
	 * 根据登陆上下文, 确定使用哪个identification-handler.
	 *
	 * 默认实现为: 注册登录渠道的key,对应某个id-handler. 例如, 从 app 登录的, 使用手机号验证的, 通过'userService' bean 的 login 接口的key,
	 * 默认表达为 MOBILE://app/userService/login
	 * @param userContext
	 * @param loginContext
	 * @return
	 */
	protected IdentificationHandler selectIdentificationHandler(RetailscmUserContextImpl userContext, LoginContext loginContext) {
		if (idHandlers == null) {
			throw new RuntimeException("您必须首先初始化IamService的idHandlers");
		}
		String key = loginContext.getKey();
		// 这里使用 linkedHashMap, 会按照配置的顺序,逐个比较当前登陆渠道的key是否匹配配置的key
		Iterator<String> it = idHandlers.keySet().iterator();
		while(it.hasNext()) {
			String cfgKey = it.next();
			if (key.matches(cfgKey)) {
				return idHandlers.get(cfgKey);
			}
		}
		throw new RuntimeException("您未定义登录key="+key+"的认证器,请正确配置或重载selectIdentificationHandler()");
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
		for(Cookie cookie: cookies) {
			if (cookie.getName().equalsIgnoreCase(JWTUtil.HEADER_NAME)) {
				String jwtStr = cookie.getValue();
				return JWTUtil.decodeToken(jwtStr);
			}
		}
		return null;
	}
	protected DecodedJWT getJwtTokenFromHeader(RetailscmUserContextImpl userContext) {
		String jwtHeader = userContext.getRequestHeader(JWTUtil.HEADER_NAME);
		if(TextUtil.isBlank(jwtHeader)) {
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
	protected String getCacheKey(UserContext userContext, String prefix){
		return "retailscm:"+prefix+":"+userContext.tokenId();
	}
	protected String getUserKey(UserContext userContext){
		return "retailscm:user:"+userContext.tokenId();
	}
	protected String getCurrentAppKey(UserContext userContext){
		return getUserKey(userContext)+":currentApp";
	}
	protected void fixUserContextTokenId(RetailscmUserContextImpl userContext, String tokenKey) {
		if (!userContext.tokenId().equals(tokenKey)) {
			userContext.setTokenId(tokenKey);
		}
	}
	public SecUser tryToLoadSecUser(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo){
		if(loginInfo == null) {
			return null;
		}
		String secUserId = (String) loginInfo.get("secUser");
		if (TextUtil.isBlank(secUserId)) {
			return null;
		}
		try {
			return userContext.getDAOGroup().getSecUserDAO().load(secUserId, EO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("加载用户出错:"+e.getMessage(), e);
		}
	}
	public UserApp tryToLoadUserApp(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo){
		if(loginInfo == null) {
			return null;
		}

		String userAppId = (String) loginInfo.get("userApp");
		if (TextUtil.isBlank(userAppId)) {
			return null;
		}
		try {
			return userContext.getDAOGroup().getUserAppDAO().load(userAppId, EO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("加载用户出错:"+e.getMessage(), e);
		}
	}
	/** 当checkAccess() 没有找到secUser时调用
	 * @param loginInfo2 */
	public void onCheckAccessWhenAnonymousFound(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo) {
		if (loginInfo != null && loginInfo.get("tokenKey") != null) {
			return;
		}
		// 选一个token key
		String tokenKey = userContext.tokenId();
		if (!isLoginClientSupportSession(userContext, null, null, null)) {
			tokenKey = "token_" + RandomUtil.randomNumAndChars(20);
			((UserContextImpl) userContext).setTokenId(tokenKey);
		}
		// 生成 anonymous jwtToken
		String userId = "anonymous";
		String userUploadHome = makeUserUploadHomeWhenLogged(null, null);
		String envType = userContext.isProductEnvironment() ? "product" : userContext.getEnvironmentName();
		String jToken = JWTUtil.getJwtToken(userId, userUploadHome, envType, tokenKey);
		// cache
		loginInfo = MapUtil.put("tokenKey", tokenKey).into_map();
		userContext.putToCache(getLoginInfoCacheKey(userContext), loginInfo, getUserTtlInSecond());
		// set to header
		userContext.setResponseHeader(JWTUtil.HEADER_NAME, jToken);
	}

//	// //////////////////////////////////////////////////
//	// 登录用的例子
//	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
//			throws IllegalAccessException {
//		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl) baseUserContext;
//		String tokenKey = getTokenKey(userContext);
//		fixUserContextTokenId(userContext, tokenKey);
//
//		String cacheKey = this.getLoginInfoCacheKey(userContext);
//		Map<String, Object> loginInfo = userContext.getCachedObject(cacheKey, Map.class);
//
//		SecUser secUser = tryToLoadSecUser(userContext, loginInfo);
//		UserApp userApp = tryToLoadUserApp(userContext, loginInfo);
//		if (userApp != null) {
//			userApp.setSecUser(secUser);
//		}
//
//		boolean checkAccessPassed = false;
//		if (secUser != null) {
//			if (userApp != null) {
//				checkAccessPassed = onSecUserAppFoundWhenCheckAccess(userContext, loginInfo, secUser, userApp);
//			}else {
//				checkAccessPassed = onSecUserFoundWhenCheckAccess(userContext, loginInfo, secUser, userApp);
//			}
//		}else {
//			checkAccessPassed = onSecUserNotFoundWhenCheckAccess(userContext, loginInfo, secUser, userApp);
//		}
//		if (checkAccessPassed) {
//
//		}
//		return accessOK();
//	}
//
//
//	protected boolean onSecUserNotFoundWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
//			SecUser secUser, UserApp userApp) {
//		return false;
//	}
//	protected boolean onSecUserFoundWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
//			SecUser secUser, UserApp userApp) {
//		return true;
//	}
//	protected boolean onSecUserAppFoundWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
//			SecUser secUser, UserApp userApp) {
//		return true;
//	}
//	protected SecUser tryToLoadSecUser(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo){
//		if(loginInfo == null) {
//			return null;
//		}
//		String secUserId = (String) loginInfo.get("secUser");
//		if (TextUtil.isBlank(secUserId)) {
//			return null;
//		}
//		try {
//			return userContext.getDAOGroup().getSecUserDAO().load(secUserId, EO);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("加载用户出错:"+e.getMessage(), e);
//		}
//	}
//	protected UserApp tryToLoadUserApp(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo){
//		if(loginInfo == null) {
//			return null;
//		}
//
//		String userAppId = (String) loginInfo.get("userApp");
//		if (TextUtil.isBlank(userAppId)) {
//			return null;
//		}
//		try {
//			return userContext.getDAOGroup().getUserAppDAO().load(userAppId, EO);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("加载用户出错:"+e.getMessage(), e);
//		}
//	}
//
//
//
//
//	public Object exampleLoginByAccountPassword(RetailscmUserContextImpl userContext, String acct, String password) throws Exception {
//
//		BusinessHandler bizHandler = new BusinessHandler() {
//			public void onAuthenticationFailed(RetailscmUserContextImpl userContext, LoginContext loginContext,
//					LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
//					throws Exception {
//				onFailExample(userContext, loginContext, loginResult, idHandler, bizHandler);
//			}
//			public void onAuthenticateNewUserLogged(RetailscmUserContextImpl userContext, LoginContext loginContext,
//					LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
//					throws Exception {
//				onNewExample(userContext, loginContext, loginResult, idHandler, bizHandler);
//			}
//			public void onAuthenticateUserLogged(RetailscmUserContextImpl userContext, LoginContext loginContext,
//					LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
//					throws Exception {
//				onSuccessExample(userContext, loginContext, loginResult, idHandler, bizHandler);
//			}
//		};
//
//
//		// 下面演示了如何构造一个LoginContext
//		LoginChannel loginChannel = new LoginChannel();
//		loginChannel.setClientName("dev_test");
//		loginChannel.setServiceBeanName(this.getBeanName());
//		loginChannel.setServiceMethodName("exampleLoginByAccountPassword");
//
//		LoginData loginData = new LoginData();
//		loginData.setLoginId(acct);
//		loginData.setPassword(password);
//
//		LoginContext loginContext = new LoginContext();
//		loginContext.setLoginChannel(loginChannel);
//		loginContext.setLoginData(loginData);
//		loginContext.setLoginMethod(LoginMethod.PASSWORD);
//
//		// 调用登录处理
//		LoginResult loginResult = this.doLogin(userContext, loginContext, bizHandler);
//
//		// 根据登录结果
//		if (loginResult.isSuccess()) {
//			return loginResult.getLoginContext().getLoginTarget().getUserApp();
//		}
//		if (loginResult.isNewUser()) {
//			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
//		}
//		return new LoginForm();
//	}
//
//	protected Object onFailExample(RetailscmUserContextImpl userContext, LoginContext loginContext, LoginResult loginResult,
//			IdentificationHandler idHandler, BusinessHandler bizHandler) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	protected Object onNewExample(RetailscmUserContextImpl userContext, LoginContext loginContext, LoginResult loginResult,
//			IdentificationHandler idHandler, BusinessHandler bizHandler) {
//		// 新用户来了,我也不知道该干嘛,所以报错
//		loginResult.setSuccess(false);
//		loginResult.setMessage("新用户自己去登录");
//		return null;
//	}
//	protected Object onSuccessExample(RetailscmUserContextImpl userContext, LoginContext loginContext, LoginResult loginResult,
//			IdentificationHandler idHandler, BusinessHandler bizHandler) {
//		// 成功了就直接记载第一个userApp
//		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
//		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppBySecUser(secUser.getId(), EO);
//		loginResult.getLoginContext().getLoginTarget().setUserApp(userApps.first().updateSecUser(secUser));
//		return null;
//	}
}
















