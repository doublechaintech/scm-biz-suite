package com.doublechaintech.retailscm.wechatminiappidentity;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.secuser.CandidateSecUser;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.caf.baseelement.PlainText;
import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;

public class WechatMiniappIdentityManagerImpl extends CustomRetailscmCheckerManager
    implements WechatMiniappIdentityManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "WechatMiniappIdentity";

  @Override
  public WechatMiniappIdentityDAO daoOf(RetailscmUserContext userContext) {
    return wechatMiniappIdentityDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws WechatMiniappIdentityManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new WechatMiniappIdentityManagerException(message);
  }

  protected WechatMiniappIdentity saveWechatMiniappIdentity(
      RetailscmUserContext userContext,
      WechatMiniappIdentity wechatMiniappIdentity,
      String[] tokensExpr)
      throws Exception {
    // return getWechatMiniappIdentityDAO().save(wechatMiniappIdentity, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveWechatMiniappIdentity(userContext, wechatMiniappIdentity, tokens);
  }

  protected WechatMiniappIdentity saveWechatMiniappIdentityDetail(
      RetailscmUserContext userContext, WechatMiniappIdentity wechatMiniappIdentity)
      throws Exception {

    return saveWechatMiniappIdentity(userContext, wechatMiniappIdentity, allTokens());
  }

  public WechatMiniappIdentity loadWechatMiniappIdentity(
      RetailscmUserContext userContext, String wechatMiniappIdentityId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatMiniappIdentity(wechatMiniappIdentityId);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentityManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    WechatMiniappIdentity wechatMiniappIdentity =
        loadWechatMiniappIdentity(userContext, wechatMiniappIdentityId, tokens);
    // do some calc before sent to customer?
    return present(userContext, wechatMiniappIdentity, tokens);
  }

  public WechatMiniappIdentity searchWechatMiniappIdentity(
      RetailscmUserContext userContext,
      String wechatMiniappIdentityId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatMiniappIdentity(wechatMiniappIdentityId);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentityManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    WechatMiniappIdentity wechatMiniappIdentity =
        loadWechatMiniappIdentity(userContext, wechatMiniappIdentityId, tokens);
    // do some calc before sent to customer?
    return present(userContext, wechatMiniappIdentity, tokens);
  }

  protected WechatMiniappIdentity present(
      RetailscmUserContext userContext,
      WechatMiniappIdentity wechatMiniappIdentity,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, wechatMiniappIdentity, tokens);

    WechatMiniappIdentity wechatMiniappIdentityToPresent =
        wechatMiniappIdentityDaoOf(userContext).present(wechatMiniappIdentity, tokens);

    List<BaseEntity> entityListToNaming =
        wechatMiniappIdentityToPresent.collectReferencesFromLists();
    wechatMiniappIdentityDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, wechatMiniappIdentity, tokens);

    return wechatMiniappIdentityToPresent;
  }

  public WechatMiniappIdentity loadWechatMiniappIdentityDetail(
      RetailscmUserContext userContext, String wechatMiniappIdentityId) throws Exception {
    WechatMiniappIdentity wechatMiniappIdentity =
        loadWechatMiniappIdentity(userContext, wechatMiniappIdentityId, allTokens());
    return present(userContext, wechatMiniappIdentity, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String wechatMiniappIdentityId)
      throws Exception {
    WechatMiniappIdentity wechatMiniappIdentity =
        loadWechatMiniappIdentity(userContext, wechatMiniappIdentityId, viewTokens());
    markVisited(userContext, wechatMiniappIdentity);
    return present(userContext, wechatMiniappIdentity, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String wechatMiniappIdentityId)
      throws Exception {
    WechatMiniappIdentity wechatMiniappIdentity =
        loadWechatMiniappIdentity(userContext, wechatMiniappIdentityId, viewTokens());
    wechatMiniappIdentity.summarySuffix();
    markVisited(userContext, wechatMiniappIdentity);
    return present(userContext, wechatMiniappIdentity, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String wechatMiniappIdentityId)
      throws Exception {
    WechatMiniappIdentity wechatMiniappIdentity =
        loadWechatMiniappIdentity(userContext, wechatMiniappIdentityId, analyzeTokens());
    markVisited(userContext, wechatMiniappIdentity);
    return present(userContext, wechatMiniappIdentity, analyzeTokens());
  }

  protected WechatMiniappIdentity saveWechatMiniappIdentity(
      RetailscmUserContext userContext,
      WechatMiniappIdentity wechatMiniappIdentity,
      Map<String, Object> tokens)
      throws Exception {

    return wechatMiniappIdentityDaoOf(userContext).save(wechatMiniappIdentity, tokens);
  }

  protected WechatMiniappIdentity loadWechatMiniappIdentity(
      RetailscmUserContext userContext, String wechatMiniappIdentityId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfWechatMiniappIdentity(wechatMiniappIdentityId);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentityManagerException.class);

    return wechatMiniappIdentityDaoOf(userContext).load(wechatMiniappIdentityId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      WechatMiniappIdentity wechatMiniappIdentity,
      Map<String, Object> tokens) {
    super.addActions(userContext, wechatMiniappIdentity, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, WechatMiniappIdentity wechatMiniappIdentity, Map<String, Object> tokens){

  @Override
  public List<WechatMiniappIdentity> searchWechatMiniappIdentityList(
      RetailscmUserContext ctx, WechatMiniappIdentityRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<WechatMiniappIdentity> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public WechatMiniappIdentity searchWechatMiniappIdentity(
      RetailscmUserContext ctx, WechatMiniappIdentityRequest pRequest) {
    pRequest.limit(0, 1);
    List<WechatMiniappIdentity> list = searchWechatMiniappIdentityList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public WechatMiniappIdentity createWechatMiniappIdentity(
      RetailscmUserContext userContext,
      String openId,
      String appId,
      String unionId,
      String secUserId,
      DateTime lastLoginTime)
      throws Exception {

    checkerOf(userContext).checkOpenIdOfWechatMiniappIdentity(openId);
    checkerOf(userContext).checkAppIdOfWechatMiniappIdentity(appId);
    checkerOf(userContext).checkUnionIdOfWechatMiniappIdentity(unionId);
    checkerOf(userContext).checkLastLoginTimeOfWechatMiniappIdentity(lastLoginTime);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentityManagerException.class);

    WechatMiniappIdentity wechatMiniappIdentity = createNewWechatMiniappIdentity();

    wechatMiniappIdentity.setOpenId(openId);
    wechatMiniappIdentity.setAppId(appId);
    wechatMiniappIdentity.setUnionId(unionId);

    SecUser secUser = loadSecUser(userContext, secUserId, emptyOptions());
    wechatMiniappIdentity.setSecUser(secUser);

    wechatMiniappIdentity.setCreateTime(userContext.now());
    wechatMiniappIdentity.setLastLoginTime(lastLoginTime);

    wechatMiniappIdentity =
        saveWechatMiniappIdentity(userContext, wechatMiniappIdentity, emptyOptions());

    onNewInstanceCreated(userContext, wechatMiniappIdentity);
    return wechatMiniappIdentity;
  }

  protected WechatMiniappIdentity createNewWechatMiniappIdentity() {

    return new WechatMiniappIdentity();
  }

  protected void checkParamsForUpdatingWechatMiniappIdentity(
      RetailscmUserContext userContext,
      String wechatMiniappIdentityId,
      int wechatMiniappIdentityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatMiniappIdentity(wechatMiniappIdentityId);
    checkerOf(userContext).checkVersionOfWechatMiniappIdentity(wechatMiniappIdentityVersion);

    if (WechatMiniappIdentity.OPEN_ID_PROPERTY.equals(property)) {

      checkerOf(userContext).checkOpenIdOfWechatMiniappIdentity(parseString(newValueExpr));
    }
    if (WechatMiniappIdentity.APP_ID_PROPERTY.equals(property)) {

      checkerOf(userContext).checkAppIdOfWechatMiniappIdentity(parseString(newValueExpr));
    }
    if (WechatMiniappIdentity.UNION_ID_PROPERTY.equals(property)) {

      checkerOf(userContext).checkUnionIdOfWechatMiniappIdentity(parseString(newValueExpr));
    }

    if (WechatMiniappIdentity.LAST_LOGIN_TIME_PROPERTY.equals(property)) {

      checkerOf(userContext)
          .checkLastLoginTimeOfWechatMiniappIdentity(parseTimestamp(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentityManagerException.class);
  }

  public WechatMiniappIdentity clone(
      RetailscmUserContext userContext, String fromWechatMiniappIdentityId) throws Exception {

    return wechatMiniappIdentityDaoOf(userContext)
        .clone(fromWechatMiniappIdentityId, this.allTokens());
  }

  public WechatMiniappIdentity internalSaveWechatMiniappIdentity(
      RetailscmUserContext userContext, WechatMiniappIdentity wechatMiniappIdentity)
      throws Exception {
    return internalSaveWechatMiniappIdentity(userContext, wechatMiniappIdentity, allTokens());
  }

  public WechatMiniappIdentity internalSaveWechatMiniappIdentity(
      RetailscmUserContext userContext,
      WechatMiniappIdentity wechatMiniappIdentity,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingWechatMiniappIdentity(userContext, wechatMiniappIdentityId,
    // wechatMiniappIdentityVersion, property, newValueExpr, tokensExpr);

    synchronized (wechatMiniappIdentity) {
      // will be good when the wechatMiniappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to WechatMiniappIdentity.
      if (wechatMiniappIdentity.isChanged()) {}

      // checkerOf(userContext).checkAndFixWechatMiniappIdentity(wechatMiniappIdentity);
      wechatMiniappIdentity =
          saveWechatMiniappIdentity(userContext, wechatMiniappIdentity, options);
      return wechatMiniappIdentity;
    }
  }

  public WechatMiniappIdentity updateWechatMiniappIdentity(
      RetailscmUserContext userContext,
      String wechatMiniappIdentityId,
      int wechatMiniappIdentityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingWechatMiniappIdentity(
        userContext,
        wechatMiniappIdentityId,
        wechatMiniappIdentityVersion,
        property,
        newValueExpr,
        tokensExpr);

    WechatMiniappIdentity wechatMiniappIdentity =
        loadWechatMiniappIdentity(userContext, wechatMiniappIdentityId, allTokens());
    if (wechatMiniappIdentity.getVersion() != wechatMiniappIdentityVersion) {
      String message =
          "The target version("
              + wechatMiniappIdentity.getVersion()
              + ") is not equals to version("
              + wechatMiniappIdentityVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (wechatMiniappIdentity) {
      // will be good when the wechatMiniappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to WechatMiniappIdentity.

      wechatMiniappIdentity.changeProperty(property, newValueExpr);
      wechatMiniappIdentity =
          saveWechatMiniappIdentity(userContext, wechatMiniappIdentity, tokens().done());
      return present(userContext, wechatMiniappIdentity, mergedAllTokens(tokensExpr));
      // return saveWechatMiniappIdentity(userContext, wechatMiniappIdentity, tokens().done());
    }
  }

  public WechatMiniappIdentity updateWechatMiniappIdentityProperty(
      RetailscmUserContext userContext,
      String wechatMiniappIdentityId,
      int wechatMiniappIdentityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingWechatMiniappIdentity(
        userContext,
        wechatMiniappIdentityId,
        wechatMiniappIdentityVersion,
        property,
        newValueExpr,
        tokensExpr);

    WechatMiniappIdentity wechatMiniappIdentity =
        loadWechatMiniappIdentity(userContext, wechatMiniappIdentityId, allTokens());
    if (wechatMiniappIdentity.getVersion() != wechatMiniappIdentityVersion) {
      String message =
          "The target version("
              + wechatMiniappIdentity.getVersion()
              + ") is not equals to version("
              + wechatMiniappIdentityVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (wechatMiniappIdentity) {
      // will be good when the wechatMiniappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to WechatMiniappIdentity.

      wechatMiniappIdentity.changeProperty(property, newValueExpr);

      wechatMiniappIdentity =
          saveWechatMiniappIdentity(userContext, wechatMiniappIdentity, tokens().done());
      return present(userContext, wechatMiniappIdentity, mergedAllTokens(tokensExpr));
      // return saveWechatMiniappIdentity(userContext, wechatMiniappIdentity, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected WechatMiniappIdentityTokens tokens() {
    return WechatMiniappIdentityTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return WechatMiniappIdentityTokens.all();
  }

  protected Map<String, Object> analyzeTokens() {
    return tokens().allTokens().analyzeAllLists().done();
  }

  protected Map<String, Object> summaryTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> viewTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return WechatMiniappIdentityTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherSecUser(
      RetailscmUserContext userContext, String wechatMiniappIdentityId, String anotherSecUserId)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatMiniappIdentity(wechatMiniappIdentityId);
    checkerOf(userContext).checkIdOfSecUser(anotherSecUserId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentityManagerException.class);
  }

  public WechatMiniappIdentity transferToAnotherSecUser(
      RetailscmUserContext userContext, String wechatMiniappIdentityId, String anotherSecUserId)
      throws Exception {
    checkParamsForTransferingAnotherSecUser(userContext, wechatMiniappIdentityId, anotherSecUserId);

    WechatMiniappIdentity wechatMiniappIdentity =
        loadWechatMiniappIdentity(userContext, wechatMiniappIdentityId, allTokens());
    synchronized (wechatMiniappIdentity) {
      // will be good when the wechatMiniappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());
      wechatMiniappIdentity.updateSecUser(secUser);

      wechatMiniappIdentity =
          saveWechatMiniappIdentity(userContext, wechatMiniappIdentity, emptyOptions());

      return present(userContext, wechatMiniappIdentity, allTokens());
    }
  }

  protected void checkParamsForTransferingAnotherSecUserWithLogin(
      RetailscmUserContext userContext, String wechatMiniappIdentityId, String anotherLogin)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatMiniappIdentity(wechatMiniappIdentityId);
    checkerOf(userContext).checkLoginOfSecUser(anotherLogin);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentityManagerException.class);
  }

  public WechatMiniappIdentity transferToAnotherSecUserWithLogin(
      RetailscmUserContext userContext, String wechatMiniappIdentityId, String anotherLogin)
      throws Exception {
    checkParamsForTransferingAnotherSecUserWithLogin(
        userContext, wechatMiniappIdentityId, anotherLogin);
    WechatMiniappIdentity wechatMiniappIdentity =
        loadWechatMiniappIdentity(userContext, wechatMiniappIdentityId, allTokens());
    synchronized (wechatMiniappIdentity) {
      // will be good when the wechatMiniappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());
      wechatMiniappIdentity.updateSecUser(secUser);
      wechatMiniappIdentity =
          saveWechatMiniappIdentity(userContext, wechatMiniappIdentity, emptyOptions());

      return present(userContext, wechatMiniappIdentity, allTokens());
    }
  }

  protected void checkParamsForTransferingAnotherSecUserWithEmail(
      RetailscmUserContext userContext, String wechatMiniappIdentityId, String anotherEmail)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatMiniappIdentity(wechatMiniappIdentityId);
    checkerOf(userContext).checkEmailOfSecUser(anotherEmail);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentityManagerException.class);
  }

  public WechatMiniappIdentity transferToAnotherSecUserWithEmail(
      RetailscmUserContext userContext, String wechatMiniappIdentityId, String anotherEmail)
      throws Exception {
    checkParamsForTransferingAnotherSecUserWithEmail(
        userContext, wechatMiniappIdentityId, anotherEmail);
    WechatMiniappIdentity wechatMiniappIdentity =
        loadWechatMiniappIdentity(userContext, wechatMiniappIdentityId, allTokens());
    synchronized (wechatMiniappIdentity) {
      // will be good when the wechatMiniappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());
      wechatMiniappIdentity.updateSecUser(secUser);
      wechatMiniappIdentity =
          saveWechatMiniappIdentity(userContext, wechatMiniappIdentity, emptyOptions());

      return present(userContext, wechatMiniappIdentity, allTokens());
    }
  }

  protected void checkParamsForTransferingAnotherSecUserWithMobile(
      RetailscmUserContext userContext, String wechatMiniappIdentityId, String anotherMobile)
      throws Exception {

    checkerOf(userContext).checkIdOfWechatMiniappIdentity(wechatMiniappIdentityId);
    checkerOf(userContext).checkMobileOfSecUser(anotherMobile);

    checkerOf(userContext).throwExceptionIfHasErrors(WechatMiniappIdentityManagerException.class);
  }

  public WechatMiniappIdentity transferToAnotherSecUserWithMobile(
      RetailscmUserContext userContext, String wechatMiniappIdentityId, String anotherMobile)
      throws Exception {
    checkParamsForTransferingAnotherSecUserWithMobile(
        userContext, wechatMiniappIdentityId, anotherMobile);
    WechatMiniappIdentity wechatMiniappIdentity =
        loadWechatMiniappIdentity(userContext, wechatMiniappIdentityId, allTokens());
    synchronized (wechatMiniappIdentity) {
      // will be good when the wechatMiniappIdentity loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());
      wechatMiniappIdentity.updateSecUser(secUser);
      wechatMiniappIdentity =
          saveWechatMiniappIdentity(userContext, wechatMiniappIdentity, emptyOptions());

      return present(userContext, wechatMiniappIdentity, allTokens());
    }
  }

  public CandidateSecUser requestCandidateSecUser(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateSecUser result = new CandidateSecUser();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("login");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<SecUser> candidateList =
        secUserDaoOf(userContext)
            .requestCandidateSecUserForWechatMiniappIdentity(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected SecUser loadSecUser(
      RetailscmUserContext userContext, String newSecUserId, Map<String, Object> options)
      throws Exception {

    return secUserDaoOf(userContext).load(newSecUserId, options);
  }

  protected SecUser loadSecUserWithLogin(
      RetailscmUserContext userContext, String newLogin, Map<String, Object> options)
      throws Exception {

    return secUserDaoOf(userContext).loadByLogin(newLogin, options);
  }

  protected SecUser loadSecUserWithEmail(
      RetailscmUserContext userContext, String newEmail, Map<String, Object> options)
      throws Exception {

    return secUserDaoOf(userContext).loadByEmail(newEmail, options);
  }

  protected SecUser loadSecUserWithMobile(
      RetailscmUserContext userContext, String newMobile, Map<String, Object> options)
      throws Exception {

    return secUserDaoOf(userContext).loadByMobile(newMobile, options);
  }

  // --------------------------------------------------------------

  public WechatMiniappIdentity forgetByAll(
      RetailscmUserContext userContext,
      String wechatMiniappIdentityId,
      int wechatMiniappIdentityVersion)
      throws Exception {
    return forgetByAllInternal(userContext, wechatMiniappIdentityId, wechatMiniappIdentityVersion);
  }

  protected WechatMiniappIdentity forgetByAllInternal(
      RetailscmUserContext userContext,
      String wechatMiniappIdentityId,
      int wechatMiniappIdentityVersion)
      throws Exception {

    return wechatMiniappIdentityDaoOf(userContext)
        .disconnectFromAll(wechatMiniappIdentityId, wechatMiniappIdentityVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new WechatMiniappIdentityManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, WechatMiniappIdentity newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    wechatMiniappIdentityDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
  }

  // -----------------------------------//  登录部分处理 \\-----------------------------------
  @Override
  protected BusinessHandler getLoginProcessBizHandler(RetailscmUserContextImpl userContext) {
    return this;
  }

  public void onAuthenticationFailed(
      RetailscmUserContext userContext,
      LoginContext loginContext,
      LoginResult loginResult,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler)
      throws Exception {
    // by default, failed is failed, nothing can do
  }
  // when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd
  // party service.
  public void onAuthenticateNewUserLogged(
      RetailscmUserContext userContext,
      LoginContext loginContext,
      LoginResult loginResult,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler)
      throws Exception {
    // Generally speaking, when authenticated user logined, we will create a new account for
    // him/her.
    // you need do it like :
    // First, you should create new data such as:
    //   WechatMiniappIdentity newWechatMiniappIdentity =
    // this.createWechatMiniappIdentity(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newWechatMiniappIdentity
    //   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(),
    // ...
    // Also, set it into loginContext:
    //   loginContext.getLoginTarget().setUserApp(userApp);
    // and in most case, this should be considered as "login success"
    //   loginResult.setSuccess(true);
    //
    // Since many of detailed info were depending business requirement, So,
    throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
  }

  protected SmartList<UserApp> getRelatedUserAppList(
      RetailscmUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, WechatMiniappIdentity.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<WechatMiniappIdentity> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<SecUser> secUserList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SecUser.class);
    userContext.getDAOGroup().enhanceList(secUserList, SecUser.class);
  }

  public Object listBySecUser(RetailscmUserContext userContext, String secUserId) throws Exception {
    return listPageBySecUser(userContext, secUserId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageBySecUser(
      RetailscmUserContext userContext, String secUserId, int start, int count) throws Exception {
    SmartList<WechatMiniappIdentity> list =
        wechatMiniappIdentityDaoOf(userContext)
            .findWechatMiniappIdentityBySecUser(secUserId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(WechatMiniappIdentity.class);
    page.setContainerObject(SecUser.withId(secUserId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("微信小程序认证列表");
    page.setRequestName("listBySecUser");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listBySecUser/%s/", getBeanName(), secUserId)));

    page.assemblerContent(userContext, "listBySecUser");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String wechatMiniappIdentityId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    WechatMiniappIdentity merchantObj =
        (WechatMiniappIdentity) this.view(userContext, wechatMiniappIdentityId);
    String merchantObjId = wechatMiniappIdentityId;
    String linkToUrl = "wechatMiniappIdentityManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "微信小程序认证" + "详情";
    Map result = new HashMap();
    List propList = new ArrayList();
    List sections = new ArrayList();

    propList.add(
        MapUtil.put("id", "1-id")
            .put("fieldName", "id")
            .put("label", "ID")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("id", merchantObj.getId());

    propList.add(
        MapUtil.put("id", "2-openId")
            .put("fieldName", "openId")
            .put("label", "开放Id")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("openId", merchantObj.getOpenId());

    propList.add(
        MapUtil.put("id", "3-appId")
            .put("fieldName", "appId")
            .put("label", "应用程序Id")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("appId", merchantObj.getAppId());

    propList.add(
        MapUtil.put("id", "4-unionId")
            .put("fieldName", "unionId")
            .put("label", "联盟Id")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("unionId", merchantObj.getUnionId());

    propList.add(
        MapUtil.put("id", "5-secUser")
            .put("fieldName", "secUser")
            .put("label", "安全用户")
            .put("type", "auto")
            .put("linkToUrl", "secUserManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"verification_code\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"login\",\"imageList\":\"\"}")
            .into_map());
    result.put("secUser", merchantObj.getSecUser());

    propList.add(
        MapUtil.put("id", "6-createTime")
            .put("fieldName", "createTime")
            .put("label", "创建于")
            .put("type", "datetime")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("createTime", merchantObj.getCreateTime());

    propList.add(
        MapUtil.put("id", "7-lastLoginTime")
            .put("fieldName", "lastLoginTime")
            .put("label", "最后登录时间")
            .put("type", "datetime")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("lastLoginTime", merchantObj.getLastLoginTime());

    // 处理 sectionList

    result.put("propList", propList);
    result.put("sectionList", sections);
    result.put("pageTitle", pageTitle);
    result.put("linkToUrl", linkToUrl);

    vscope
        .field("propList", SerializeScope.EXCLUDE())
        .field("sectionList", SerializeScope.EXCLUDE())
        .field("pageTitle", SerializeScope.EXCLUDE())
        .field("linkToUrl", SerializeScope.EXCLUDE());
    userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
    return BaseViewPage.serialize(result, vscope);
  }
}
