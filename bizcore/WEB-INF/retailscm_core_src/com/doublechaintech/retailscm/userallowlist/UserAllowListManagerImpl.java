package com.doublechaintech.retailscm.userallowlist;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.userdomain.CandidateUserDomain;
import com.doublechaintech.retailscm.userdomain.UserDomain;
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

public class UserAllowListManagerImpl extends CustomRetailscmCheckerManager
    implements UserAllowListManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "UserAllowList";

  @Override
  public UserAllowListDAO daoOf(RetailscmUserContext userContext) {
    return userAllowListDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws UserAllowListManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new UserAllowListManagerException(message);
  }

  protected UserAllowList saveUserAllowList(
      RetailscmUserContext userContext, UserAllowList userAllowList, String[] tokensExpr)
      throws Exception {
    // return getUserAllowListDAO().save(userAllowList, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveUserAllowList(userContext, userAllowList, tokens);
  }

  protected UserAllowList saveUserAllowListDetail(
      RetailscmUserContext userContext, UserAllowList userAllowList) throws Exception {

    return saveUserAllowList(userContext, userAllowList, allTokens());
  }

  public UserAllowList loadUserAllowList(
      RetailscmUserContext userContext, String userAllowListId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);

    checkerOf(userContext).throwExceptionIfHasErrors(UserAllowListManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    UserAllowList userAllowList = loadUserAllowList(userContext, userAllowListId, tokens);
    // do some calc before sent to customer?
    return present(userContext, userAllowList, tokens);
  }

  public UserAllowList searchUserAllowList(
      RetailscmUserContext userContext,
      String userAllowListId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);

    checkerOf(userContext).throwExceptionIfHasErrors(UserAllowListManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    UserAllowList userAllowList = loadUserAllowList(userContext, userAllowListId, tokens);
    // do some calc before sent to customer?
    return present(userContext, userAllowList, tokens);
  }

  protected UserAllowList present(
      RetailscmUserContext userContext, UserAllowList userAllowList, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, userAllowList, tokens);

    UserAllowList userAllowListToPresent =
        userAllowListDaoOf(userContext).present(userAllowList, tokens);

    List<BaseEntity> entityListToNaming = userAllowListToPresent.collectReferencesFromLists();
    userAllowListDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, userAllowList, tokens);

    return userAllowListToPresent;
  }

  public UserAllowList loadUserAllowListDetail(
      RetailscmUserContext userContext, String userAllowListId) throws Exception {
    UserAllowList userAllowList = loadUserAllowList(userContext, userAllowListId, allTokens());
    return present(userContext, userAllowList, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String userAllowListId) throws Exception {
    UserAllowList userAllowList = loadUserAllowList(userContext, userAllowListId, viewTokens());
    markVisited(userContext, userAllowList);
    return present(userContext, userAllowList, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String userAllowListId)
      throws Exception {
    UserAllowList userAllowList = loadUserAllowList(userContext, userAllowListId, viewTokens());
    userAllowList.summarySuffix();
    markVisited(userContext, userAllowList);
    return present(userContext, userAllowList, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String userAllowListId) throws Exception {
    UserAllowList userAllowList = loadUserAllowList(userContext, userAllowListId, analyzeTokens());
    markVisited(userContext, userAllowList);
    return present(userContext, userAllowList, analyzeTokens());
  }

  protected UserAllowList saveUserAllowList(
      RetailscmUserContext userContext, UserAllowList userAllowList, Map<String, Object> tokens)
      throws Exception {

    return userAllowListDaoOf(userContext).save(userAllowList, tokens);
  }

  protected UserAllowList loadUserAllowList(
      RetailscmUserContext userContext, String userAllowListId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);

    checkerOf(userContext).throwExceptionIfHasErrors(UserAllowListManagerException.class);

    return userAllowListDaoOf(userContext).load(userAllowListId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, UserAllowList userAllowList, Map<String, Object> tokens) {
    super.addActions(userContext, userAllowList, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, UserAllowList userAllowList, Map<String, Object> tokens){

  @Override
  public List<UserAllowList> searchUserAllowListList(
      RetailscmUserContext ctx, UserAllowListRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<UserAllowList> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public UserAllowList searchUserAllowList(
      RetailscmUserContext ctx, UserAllowListRequest pRequest) {
    pRequest.limit(0, 1);
    List<UserAllowList> list = searchUserAllowListList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public UserAllowList createUserAllowList(
      RetailscmUserContext userContext,
      String userIdentity,
      String userSpecialFunctions,
      String domainId)
      throws Exception {

    checkerOf(userContext).checkUserIdentityOfUserAllowList(userIdentity);
    checkerOf(userContext).checkUserSpecialFunctionsOfUserAllowList(userSpecialFunctions);

    checkerOf(userContext).throwExceptionIfHasErrors(UserAllowListManagerException.class);

    UserAllowList userAllowList = createNewUserAllowList();

    userAllowList.setUserIdentity(userIdentity);
    userAllowList.setUserSpecialFunctions(userSpecialFunctions);

    UserDomain domain = loadUserDomain(userContext, domainId, emptyOptions());
    userAllowList.setDomain(domain);

    userAllowList = saveUserAllowList(userContext, userAllowList, emptyOptions());

    onNewInstanceCreated(userContext, userAllowList);
    return userAllowList;
  }

  protected UserAllowList createNewUserAllowList() {

    return new UserAllowList();
  }

  protected void checkParamsForUpdatingUserAllowList(
      RetailscmUserContext userContext,
      String userAllowListId,
      int userAllowListVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);
    checkerOf(userContext).checkVersionOfUserAllowList(userAllowListVersion);

    if (UserAllowList.USER_IDENTITY_PROPERTY.equals(property)) {

      checkerOf(userContext).checkUserIdentityOfUserAllowList(parseString(newValueExpr));
    }
    if (UserAllowList.USER_SPECIAL_FUNCTIONS_PROPERTY.equals(property)) {

      checkerOf(userContext).checkUserSpecialFunctionsOfUserAllowList(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(UserAllowListManagerException.class);
  }

  public UserAllowList clone(RetailscmUserContext userContext, String fromUserAllowListId)
      throws Exception {

    return userAllowListDaoOf(userContext).clone(fromUserAllowListId, this.allTokens());
  }

  public UserAllowList internalSaveUserAllowList(
      RetailscmUserContext userContext, UserAllowList userAllowList) throws Exception {
    return internalSaveUserAllowList(userContext, userAllowList, allTokens());
  }

  public UserAllowList internalSaveUserAllowList(
      RetailscmUserContext userContext, UserAllowList userAllowList, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingUserAllowList(userContext, userAllowListId, userAllowListVersion,
    // property, newValueExpr, tokensExpr);

    synchronized (userAllowList) {
      // will be good when the userAllowList loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to UserAllowList.
      if (userAllowList.isChanged()) {}

      // checkerOf(userContext).checkAndFixUserAllowList(userAllowList);
      userAllowList = saveUserAllowList(userContext, userAllowList, options);
      return userAllowList;
    }
  }

  public UserAllowList updateUserAllowList(
      RetailscmUserContext userContext,
      String userAllowListId,
      int userAllowListVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingUserAllowList(
        userContext, userAllowListId, userAllowListVersion, property, newValueExpr, tokensExpr);

    UserAllowList userAllowList = loadUserAllowList(userContext, userAllowListId, allTokens());
    if (userAllowList.getVersion() != userAllowListVersion) {
      String message =
          "The target version("
              + userAllowList.getVersion()
              + ") is not equals to version("
              + userAllowListVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (userAllowList) {
      // will be good when the userAllowList loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to UserAllowList.

      userAllowList.changeProperty(property, newValueExpr);
      userAllowList = saveUserAllowList(userContext, userAllowList, tokens().done());
      return present(userContext, userAllowList, mergedAllTokens(tokensExpr));
      // return saveUserAllowList(userContext, userAllowList, tokens().done());
    }
  }

  public UserAllowList updateUserAllowListProperty(
      RetailscmUserContext userContext,
      String userAllowListId,
      int userAllowListVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingUserAllowList(
        userContext, userAllowListId, userAllowListVersion, property, newValueExpr, tokensExpr);

    UserAllowList userAllowList = loadUserAllowList(userContext, userAllowListId, allTokens());
    if (userAllowList.getVersion() != userAllowListVersion) {
      String message =
          "The target version("
              + userAllowList.getVersion()
              + ") is not equals to version("
              + userAllowListVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (userAllowList) {
      // will be good when the userAllowList loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to UserAllowList.

      userAllowList.changeProperty(property, newValueExpr);

      userAllowList = saveUserAllowList(userContext, userAllowList, tokens().done());
      return present(userContext, userAllowList, mergedAllTokens(tokensExpr));
      // return saveUserAllowList(userContext, userAllowList, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected UserAllowListTokens tokens() {
    return UserAllowListTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return UserAllowListTokens.all();
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
    return UserAllowListTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherDomain(
      RetailscmUserContext userContext, String userAllowListId, String anotherDomainId)
      throws Exception {

    checkerOf(userContext).checkIdOfUserAllowList(userAllowListId);
    checkerOf(userContext).checkIdOfUserDomain(anotherDomainId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(UserAllowListManagerException.class);
  }

  public UserAllowList transferToAnotherDomain(
      RetailscmUserContext userContext, String userAllowListId, String anotherDomainId)
      throws Exception {
    checkParamsForTransferingAnotherDomain(userContext, userAllowListId, anotherDomainId);

    UserAllowList userAllowList = loadUserAllowList(userContext, userAllowListId, allTokens());
    synchronized (userAllowList) {
      // will be good when the userAllowList loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      UserDomain domain = loadUserDomain(userContext, anotherDomainId, emptyOptions());
      userAllowList.updateDomain(domain);

      userAllowList = saveUserAllowList(userContext, userAllowList, emptyOptions());

      return present(userContext, userAllowList, allTokens());
    }
  }

  public CandidateUserDomain requestCandidateDomain(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateUserDomain result = new CandidateUserDomain();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<UserDomain> candidateList =
        userDomainDaoOf(userContext)
            .requestCandidateUserDomainForUserAllowList(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected UserDomain loadUserDomain(
      RetailscmUserContext userContext, String newDomainId, Map<String, Object> options)
      throws Exception {

    return userDomainDaoOf(userContext).load(newDomainId, options);
  }

  // --------------------------------------------------------------

  public UserAllowList forgetByAll(
      RetailscmUserContext userContext, String userAllowListId, int userAllowListVersion)
      throws Exception {
    return forgetByAllInternal(userContext, userAllowListId, userAllowListVersion);
  }

  protected UserAllowList forgetByAllInternal(
      RetailscmUserContext userContext, String userAllowListId, int userAllowListVersion)
      throws Exception {

    return userAllowListDaoOf(userContext).disconnectFromAll(userAllowListId, userAllowListVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new UserAllowListManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(RetailscmUserContext userContext, UserAllowList newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    userAllowListDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
  }

  protected String getRootUserDomainId(RetailscmUserContext ctx) {
    return "UD000001";
  }

  public UserAllowList updateUserRole(
      RetailscmUserContext ctx, String userIdentity, String roleName, boolean add)
      throws Exception {
    UserAllowList rcd = getByIdentity(ctx, userIdentity);
    String roleSeg = ";" + roleName + ";";
    if (rcd == null) {
      // 指定记录不存在
      if (!add) {
        return null;
      }
      return this.createUserAllowList(ctx, userIdentity, roleSeg, getRootUserDomainId(ctx));
    }
    // 记录存在
    String oldRoles = rcd.getUserSpecialFunctions();
    if (oldRoles.contains(roleSeg) == add) {
      // 如果'已包含' 和 '要赋予' 一致, 那么就什么都不用做
      return rcd;
    }
    if (add) {
      rcd.updateUserSpecialFunctions(oldRoles + roleName + ";");
    } else {
      rcd.updateUserSpecialFunctions(oldRoles.replace(roleSeg, ";"));
    }
    return internalSaveUserAllowList(ctx, rcd, EO);
  }

  public UserAllowList getByIdentity(RetailscmUserContext ctx, String userIdentity) {
    String sql =
        "SELECT * FROM "
            + UserAllowListTable.TABLE_NAME
            + " where "
            + UserAllowListTable.COLUMN_USER_IDENTITY
            + "=? and "
            + UserAllowListTable.COLUMN_DOMAIN
            + " is not null";

    SmartList<UserAllowList> list = daoOf(ctx).queryList(sql, userIdentity);
    return list.first();
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
    //   UserAllowList newUserAllowList = this.createUserAllowList(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newUserAllowList
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
    key.put(UserApp.APP_TYPE_PROPERTY, UserAllowList.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<UserAllowList> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<UserDomain> domainList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, UserDomain.class);
    userContext.getDAOGroup().enhanceList(domainList, UserDomain.class);
  }

  public Object listByDomain(RetailscmUserContext userContext, String domainId) throws Exception {
    return listPageByDomain(userContext, domainId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByDomain(
      RetailscmUserContext userContext, String domainId, int start, int count) throws Exception {
    SmartList<UserAllowList> list =
        userAllowListDaoOf(userContext)
            .findUserAllowListByDomain(domainId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(UserAllowList.class);
    page.setContainerObject(UserDomain.withId(domainId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("用户权限列表列表");
    page.setRequestName("listByDomain");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByDomain/%s/", getBeanName(), domainId)));

    page.assemblerContent(userContext, "listByDomain");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String userAllowListId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    UserAllowList merchantObj = (UserAllowList) this.view(userContext, userAllowListId);
    String merchantObjId = userAllowListId;
    String linkToUrl = "userAllowListManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "用户权限列表" + "详情";
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
        MapUtil.put("id", "2-userIdentity")
            .put("fieldName", "userIdentity")
            .put("label", "用户身份")
            .put("type", "mobile")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("userIdentity", merchantObj.getUserIdentity());

    propList.add(
        MapUtil.put("id", "3-userSpecialFunctions")
            .put("fieldName", "userSpecialFunctions")
            .put("label", "用户特殊功能")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("userSpecialFunctions", merchantObj.getUserSpecialFunctions());

    propList.add(
        MapUtil.put("id", "4-domain")
            .put("fieldName", "domain")
            .put("label", "域")
            .put("type", "auto")
            .put("linkToUrl", "userDomainManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("domain", merchantObj.getDomain());

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
