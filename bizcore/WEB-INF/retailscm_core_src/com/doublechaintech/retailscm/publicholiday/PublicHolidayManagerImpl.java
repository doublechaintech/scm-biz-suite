package com.doublechaintech.retailscm.publicholiday;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
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

public class PublicHolidayManagerImpl extends CustomRetailscmCheckerManager
    implements PublicHolidayManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "PublicHoliday";

  @Override
  public PublicHolidayDAO daoOf(RetailscmUserContext userContext) {
    return publicHolidayDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws PublicHolidayManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new PublicHolidayManagerException(message);
  }

  protected PublicHoliday savePublicHoliday(
      RetailscmUserContext userContext, PublicHoliday publicHoliday, String[] tokensExpr)
      throws Exception {
    // return getPublicHolidayDAO().save(publicHoliday, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return savePublicHoliday(userContext, publicHoliday, tokens);
  }

  protected PublicHoliday savePublicHolidayDetail(
      RetailscmUserContext userContext, PublicHoliday publicHoliday) throws Exception {

    return savePublicHoliday(userContext, publicHoliday, allTokens());
  }

  public PublicHoliday loadPublicHoliday(
      RetailscmUserContext userContext, String publicHolidayId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);

    checkerOf(userContext).throwExceptionIfHasErrors(PublicHolidayManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, tokens);
    // do some calc before sent to customer?
    return present(userContext, publicHoliday, tokens);
  }

  public PublicHoliday searchPublicHoliday(
      RetailscmUserContext userContext,
      String publicHolidayId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);

    checkerOf(userContext).throwExceptionIfHasErrors(PublicHolidayManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, tokens);
    // do some calc before sent to customer?
    return present(userContext, publicHoliday, tokens);
  }

  protected PublicHoliday present(
      RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, publicHoliday, tokens);

    PublicHoliday publicHolidayToPresent =
        publicHolidayDaoOf(userContext).present(publicHoliday, tokens);

    List<BaseEntity> entityListToNaming = publicHolidayToPresent.collectReferencesFromLists();
    publicHolidayDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, publicHoliday, tokens);

    return publicHolidayToPresent;
  }

  public PublicHoliday loadPublicHolidayDetail(
      RetailscmUserContext userContext, String publicHolidayId) throws Exception {
    PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, allTokens());
    return present(userContext, publicHoliday, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String publicHolidayId) throws Exception {
    PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, viewTokens());
    markVisited(userContext, publicHoliday);
    return present(userContext, publicHoliday, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String publicHolidayId)
      throws Exception {
    PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, viewTokens());
    publicHoliday.summarySuffix();
    markVisited(userContext, publicHoliday);
    return present(userContext, publicHoliday, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String publicHolidayId) throws Exception {
    PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, analyzeTokens());
    markVisited(userContext, publicHoliday);
    return present(userContext, publicHoliday, analyzeTokens());
  }

  protected PublicHoliday savePublicHoliday(
      RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> tokens)
      throws Exception {

    return publicHolidayDaoOf(userContext).save(publicHoliday, tokens);
  }

  protected PublicHoliday loadPublicHoliday(
      RetailscmUserContext userContext, String publicHolidayId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);

    checkerOf(userContext).throwExceptionIfHasErrors(PublicHolidayManagerException.class);

    return publicHolidayDaoOf(userContext).load(publicHolidayId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> tokens) {
    super.addActions(userContext, publicHoliday, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, PublicHoliday publicHoliday, Map<String, Object> tokens){

  @Override
  public List<PublicHoliday> searchPublicHolidayList(
      RetailscmUserContext ctx, PublicHolidayRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<PublicHoliday> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public PublicHoliday searchPublicHoliday(
      RetailscmUserContext ctx, PublicHolidayRequest pRequest) {
    pRequest.limit(0, 1);
    List<PublicHoliday> list = searchPublicHolidayList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public PublicHoliday createPublicHoliday(
      RetailscmUserContext userContext,
      String code,
      String companyId,
      String name,
      String description)
      throws Exception {

    checkerOf(userContext).checkCodeOfPublicHoliday(code);
    checkerOf(userContext).checkNameOfPublicHoliday(name);
    checkerOf(userContext).checkDescriptionOfPublicHoliday(description);

    checkerOf(userContext).throwExceptionIfHasErrors(PublicHolidayManagerException.class);

    PublicHoliday publicHoliday = createNewPublicHoliday();

    publicHoliday.setCode(code);

    RetailStoreCountryCenter company =
        loadRetailStoreCountryCenter(userContext, companyId, emptyOptions());
    publicHoliday.setCompany(company);

    publicHoliday.setName(name);
    publicHoliday.setDescription(description);

    publicHoliday = savePublicHoliday(userContext, publicHoliday, emptyOptions());

    onNewInstanceCreated(userContext, publicHoliday);
    return publicHoliday;
  }

  protected PublicHoliday createNewPublicHoliday() {

    return new PublicHoliday();
  }

  protected void checkParamsForUpdatingPublicHoliday(
      RetailscmUserContext userContext,
      String publicHolidayId,
      int publicHolidayVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);
    checkerOf(userContext).checkVersionOfPublicHoliday(publicHolidayVersion);

    if (PublicHoliday.CODE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkCodeOfPublicHoliday(parseString(newValueExpr));
    }

    if (PublicHoliday.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfPublicHoliday(parseString(newValueExpr));
    }
    if (PublicHoliday.DESCRIPTION_PROPERTY.equals(property)) {

      checkerOf(userContext).checkDescriptionOfPublicHoliday(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(PublicHolidayManagerException.class);
  }

  public PublicHoliday clone(RetailscmUserContext userContext, String fromPublicHolidayId)
      throws Exception {

    return publicHolidayDaoOf(userContext).clone(fromPublicHolidayId, this.allTokens());
  }

  public PublicHoliday internalSavePublicHoliday(
      RetailscmUserContext userContext, PublicHoliday publicHoliday) throws Exception {
    return internalSavePublicHoliday(userContext, publicHoliday, allTokens());
  }

  public PublicHoliday internalSavePublicHoliday(
      RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingPublicHoliday(userContext, publicHolidayId, publicHolidayVersion,
    // property, newValueExpr, tokensExpr);

    synchronized (publicHoliday) {
      // will be good when the publicHoliday loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PublicHoliday.
      if (publicHoliday.isChanged()) {}

      // checkerOf(userContext).checkAndFixPublicHoliday(publicHoliday);
      publicHoliday = savePublicHoliday(userContext, publicHoliday, options);
      return publicHoliday;
    }
  }

  public PublicHoliday updatePublicHoliday(
      RetailscmUserContext userContext,
      String publicHolidayId,
      int publicHolidayVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPublicHoliday(
        userContext, publicHolidayId, publicHolidayVersion, property, newValueExpr, tokensExpr);

    PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, allTokens());
    if (publicHoliday.getVersion() != publicHolidayVersion) {
      String message =
          "The target version("
              + publicHoliday.getVersion()
              + ") is not equals to version("
              + publicHolidayVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (publicHoliday) {
      // will be good when the publicHoliday loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PublicHoliday.

      publicHoliday.changeProperty(property, newValueExpr);
      publicHoliday = savePublicHoliday(userContext, publicHoliday, tokens().done());
      return present(userContext, publicHoliday, mergedAllTokens(tokensExpr));
      // return savePublicHoliday(userContext, publicHoliday, tokens().done());
    }
  }

  public PublicHoliday updatePublicHolidayProperty(
      RetailscmUserContext userContext,
      String publicHolidayId,
      int publicHolidayVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPublicHoliday(
        userContext, publicHolidayId, publicHolidayVersion, property, newValueExpr, tokensExpr);

    PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, allTokens());
    if (publicHoliday.getVersion() != publicHolidayVersion) {
      String message =
          "The target version("
              + publicHoliday.getVersion()
              + ") is not equals to version("
              + publicHolidayVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (publicHoliday) {
      // will be good when the publicHoliday loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PublicHoliday.

      publicHoliday.changeProperty(property, newValueExpr);

      publicHoliday = savePublicHoliday(userContext, publicHoliday, tokens().done());
      return present(userContext, publicHoliday, mergedAllTokens(tokensExpr));
      // return savePublicHoliday(userContext, publicHoliday, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected PublicHolidayTokens tokens() {
    return PublicHolidayTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return PublicHolidayTokens.all();
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
    return PublicHolidayTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherCompany(
      RetailscmUserContext userContext, String publicHolidayId, String anotherCompanyId)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);
    checkerOf(userContext)
        .checkIdOfRetailStoreCountryCenter(anotherCompanyId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(PublicHolidayManagerException.class);
  }

  public PublicHoliday transferToAnotherCompany(
      RetailscmUserContext userContext, String publicHolidayId, String anotherCompanyId)
      throws Exception {
    checkParamsForTransferingAnotherCompany(userContext, publicHolidayId, anotherCompanyId);

    PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, allTokens());
    synchronized (publicHoliday) {
      // will be good when the publicHoliday loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreCountryCenter company =
          loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());
      publicHoliday.updateCompany(company);

      publicHoliday = savePublicHoliday(userContext, publicHoliday, emptyOptions());

      return present(userContext, publicHoliday, allTokens());
    }
  }

  public CandidateRetailStoreCountryCenter requestCandidateCompany(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<RetailStoreCountryCenter> candidateList =
        retailStoreCountryCenterDaoOf(userContext)
            .requestCandidateRetailStoreCountryCenterForPublicHoliday(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected RetailStoreCountryCenter loadRetailStoreCountryCenter(
      RetailscmUserContext userContext, String newCompanyId, Map<String, Object> options)
      throws Exception {

    return retailStoreCountryCenterDaoOf(userContext).load(newCompanyId, options);
  }

  // --------------------------------------------------------------

  public PublicHoliday forgetByAll(
      RetailscmUserContext userContext, String publicHolidayId, int publicHolidayVersion)
      throws Exception {
    return forgetByAllInternal(userContext, publicHolidayId, publicHolidayVersion);
  }

  protected PublicHoliday forgetByAllInternal(
      RetailscmUserContext userContext, String publicHolidayId, int publicHolidayVersion)
      throws Exception {

    return publicHolidayDaoOf(userContext).disconnectFromAll(publicHolidayId, publicHolidayVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new PublicHolidayManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(RetailscmUserContext userContext, PublicHoliday newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    publicHolidayDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   PublicHoliday newPublicHoliday = this.createPublicHoliday(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newPublicHoliday
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
    key.put(UserApp.APP_TYPE_PROPERTY, PublicHoliday.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<PublicHoliday> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<RetailStoreCountryCenter> companyList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, RetailStoreCountryCenter.class);
    userContext.getDAOGroup().enhanceList(companyList, RetailStoreCountryCenter.class);
  }

  public Object listByCompany(RetailscmUserContext userContext, String companyId) throws Exception {
    return listPageByCompany(userContext, companyId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByCompany(
      RetailscmUserContext userContext, String companyId, int start, int count) throws Exception {
    SmartList<PublicHoliday> list =
        publicHolidayDaoOf(userContext)
            .findPublicHolidayByCompany(companyId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(PublicHoliday.class);
    page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("公共假日列表");
    page.setRequestName("listByCompany");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByCompany/%s/", getBeanName(), companyId)));

    page.assemblerContent(userContext, "listByCompany");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String publicHolidayId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    PublicHoliday merchantObj = (PublicHoliday) this.view(userContext, publicHolidayId);
    String merchantObjId = publicHolidayId;
    String linkToUrl = "publicHolidayManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "公共假日" + "详情";
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
        MapUtil.put("id", "2-code")
            .put("fieldName", "code")
            .put("label", "代码")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("code", merchantObj.getCode());

    propList.add(
        MapUtil.put("id", "3-company")
            .put("fieldName", "company")
            .put("label", "公司")
            .put("type", "auto")
            .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("company", merchantObj.getCompany());

    propList.add(
        MapUtil.put("id", "4-name")
            .put("fieldName", "name")
            .put("label", "名称")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("name", merchantObj.getName());

    propList.add(
        MapUtil.put("id", "5-description")
            .put("fieldName", "description")
            .put("label", "描述")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("description", merchantObj.getDescription());

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
