package com.doublechaintech.retailscm.pagetype;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.mobileapp.CandidateMobileApp;
import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.pagetype.PageType;
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

public class PageTypeManagerImpl extends CustomRetailscmCheckerManager
    implements PageTypeManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "PageType";

  @Override
  public PageTypeDAO daoOf(RetailscmUserContext userContext) {
    return pageTypeDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws PageTypeManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new PageTypeManagerException(message);
  }

  protected PageType savePageType(
      RetailscmUserContext userContext, PageType pageType, String[] tokensExpr) throws Exception {
    // return getPageTypeDAO().save(pageType, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return savePageType(userContext, pageType, tokens);
  }

  protected PageType savePageTypeDetail(RetailscmUserContext userContext, PageType pageType)
      throws Exception {

    return savePageType(userContext, pageType, allTokens());
  }

  public PageType loadPageType(
      RetailscmUserContext userContext, String pageTypeId, String[] tokensExpr) throws Exception {

    checkerOf(userContext).checkIdOfPageType(pageTypeId);

    checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    PageType pageType = loadPageType(userContext, pageTypeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, pageType, tokens);
  }

  public PageType searchPageType(
      RetailscmUserContext userContext, String pageTypeId, String textToSearch, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPageType(pageTypeId);

    checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    PageType pageType = loadPageType(userContext, pageTypeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, pageType, tokens);
  }

  protected PageType present(
      RetailscmUserContext userContext, PageType pageType, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, pageType, tokens);

    PageType pageTypeToPresent = pageTypeDaoOf(userContext).present(pageType, tokens);

    List<BaseEntity> entityListToNaming = pageTypeToPresent.collectReferencesFromLists();
    pageTypeDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, pageType, tokens);

    return pageTypeToPresent;
  }

  public PageType loadPageTypeDetail(RetailscmUserContext userContext, String pageTypeId)
      throws Exception {
    PageType pageType = loadPageType(userContext, pageTypeId, allTokens());
    return present(userContext, pageType, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String pageTypeId) throws Exception {
    PageType pageType = loadPageType(userContext, pageTypeId, viewTokens());
    markVisited(userContext, pageType);
    return present(userContext, pageType, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String pageTypeId) throws Exception {
    PageType pageType = loadPageType(userContext, pageTypeId, viewTokens());
    pageType.summarySuffix();
    markVisited(userContext, pageType);
    return present(userContext, pageType, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String pageTypeId) throws Exception {
    PageType pageType = loadPageType(userContext, pageTypeId, analyzeTokens());
    markVisited(userContext, pageType);
    return present(userContext, pageType, analyzeTokens());
  }

  protected PageType savePageType(
      RetailscmUserContext userContext, PageType pageType, Map<String, Object> tokens)
      throws Exception {

    if (pageType.getId() == null) {
      pageType.setId(pageType.getCode());
    }

    return pageTypeDaoOf(userContext).save(pageType, tokens);
  }

  protected PageType loadPageType(
      RetailscmUserContext userContext, String pageTypeId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfPageType(pageTypeId);

    checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);

    return pageTypeDaoOf(userContext).load(pageTypeId, tokens);
  }

  public PageType loadPageTypeWithCode(
      RetailscmUserContext userContext, String code, Map<String, Object> tokens) throws Exception {
    return pageTypeDaoOf(userContext).loadByCode(code, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, PageType pageType, Map<String, Object> tokens) {
    super.addActions(userContext, pageType, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, PageType pageType, Map<String, Object> tokens){

  @Override
  public List<PageType> searchPageTypeList(RetailscmUserContext ctx, PageTypeRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<PageType> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public PageType searchPageType(RetailscmUserContext ctx, PageTypeRequest pRequest) {
    pRequest.limit(0, 1);
    List<PageType> list = searchPageTypeList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public PageType createPageType(
      RetailscmUserContext userContext,
      String name,
      String code,
      String mobileAppId,
      boolean footerTab)
      throws Exception {

    checkerOf(userContext).checkNameOfPageType(name);
    checkerOf(userContext).checkCodeOfPageType(code);
    checkerOf(userContext).checkFooterTabOfPageType(footerTab);

    checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);

    PageType pageType = createNewPageType();

    pageType.setName(name);
    pageType.setCode(code);

    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, emptyOptions());
    pageType.setMobileApp(mobileApp);

    pageType.setFooterTab(footerTab);

    pageType = savePageType(userContext, pageType, emptyOptions());

    onNewInstanceCreated(userContext, pageType);
    return pageType;
  }

  protected PageType createNewPageType() {

    return new PageType();
  }

  protected void checkParamsForUpdatingPageType(
      RetailscmUserContext userContext,
      String pageTypeId,
      int pageTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPageType(pageTypeId);
    checkerOf(userContext).checkVersionOfPageType(pageTypeVersion);

    if (PageType.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfPageType(parseString(newValueExpr));
    }
    if (PageType.CODE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkCodeOfPageType(parseString(newValueExpr));
    }

    if (PageType.FOOTER_TAB_PROPERTY.equals(property)) {

      checkerOf(userContext).checkFooterTabOfPageType(parseBoolean(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);
  }

  public PageType clone(RetailscmUserContext userContext, String fromPageTypeId) throws Exception {

    return pageTypeDaoOf(userContext).clone(fromPageTypeId, this.allTokens());
  }

  public PageType internalSavePageType(RetailscmUserContext userContext, PageType pageType)
      throws Exception {
    return internalSavePageType(userContext, pageType, allTokens());
  }

  public PageType internalSavePageType(
      RetailscmUserContext userContext, PageType pageType, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingPageType(userContext, pageTypeId, pageTypeVersion, property,
    // newValueExpr, tokensExpr);

    synchronized (pageType) {
      // will be good when the pageType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PageType.
      if (pageType.isChanged()) {}

      // checkerOf(userContext).checkAndFixPageType(pageType);
      pageType = savePageType(userContext, pageType, options);
      return pageType;
    }
  }

  public PageType updatePageType(
      RetailscmUserContext userContext,
      String pageTypeId,
      int pageTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPageType(
        userContext, pageTypeId, pageTypeVersion, property, newValueExpr, tokensExpr);

    PageType pageType = loadPageType(userContext, pageTypeId, allTokens());
    if (pageType.getVersion() != pageTypeVersion) {
      String message =
          "The target version("
              + pageType.getVersion()
              + ") is not equals to version("
              + pageTypeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (pageType) {
      // will be good when the pageType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PageType.

      pageType.changeProperty(property, newValueExpr);
      pageType = savePageType(userContext, pageType, tokens().done());
      return present(userContext, pageType, mergedAllTokens(tokensExpr));
      // return savePageType(userContext, pageType, tokens().done());
    }
  }

  public PageType updatePageTypeProperty(
      RetailscmUserContext userContext,
      String pageTypeId,
      int pageTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPageType(
        userContext, pageTypeId, pageTypeVersion, property, newValueExpr, tokensExpr);

    PageType pageType = loadPageType(userContext, pageTypeId, allTokens());
    if (pageType.getVersion() != pageTypeVersion) {
      String message =
          "The target version("
              + pageType.getVersion()
              + ") is not equals to version("
              + pageTypeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (pageType) {
      // will be good when the pageType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PageType.

      pageType.changeProperty(property, newValueExpr);

      pageType = savePageType(userContext, pageType, tokens().done());
      return present(userContext, pageType, mergedAllTokens(tokensExpr));
      // return savePageType(userContext, pageType, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected PageTypeTokens tokens() {
    return PageTypeTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return PageTypeTokens.all();
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
    return PageTypeTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherMobileApp(
      RetailscmUserContext userContext, String pageTypeId, String anotherMobileAppId)
      throws Exception {

    checkerOf(userContext).checkIdOfPageType(pageTypeId);
    checkerOf(userContext).checkIdOfMobileApp(anotherMobileAppId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(PageTypeManagerException.class);
  }

  public PageType transferToAnotherMobileApp(
      RetailscmUserContext userContext, String pageTypeId, String anotherMobileAppId)
      throws Exception {
    checkParamsForTransferingAnotherMobileApp(userContext, pageTypeId, anotherMobileAppId);

    PageType pageType = loadPageType(userContext, pageTypeId, allTokens());
    synchronized (pageType) {
      // will be good when the pageType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      MobileApp mobileApp = loadMobileApp(userContext, anotherMobileAppId, emptyOptions());
      pageType.updateMobileApp(mobileApp);

      pageType = savePageType(userContext, pageType, emptyOptions());

      return present(userContext, pageType, allTokens());
    }
  }

  public CandidateMobileApp requestCandidateMobileApp(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateMobileApp result = new CandidateMobileApp();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<MobileApp> candidateList =
        mobileAppDaoOf(userContext)
            .requestCandidateMobileAppForPageType(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected MobileApp loadMobileApp(
      RetailscmUserContext userContext, String newMobileAppId, Map<String, Object> options)
      throws Exception {

    return mobileAppDaoOf(userContext).load(newMobileAppId, options);
  }

  // --------------------------------------------------------------

  public PageType forgetByAll(
      RetailscmUserContext userContext, String pageTypeId, int pageTypeVersion) throws Exception {
    return forgetByAllInternal(userContext, pageTypeId, pageTypeVersion);
  }

  protected PageType forgetByAllInternal(
      RetailscmUserContext userContext, String pageTypeId, int pageTypeVersion) throws Exception {

    return pageTypeDaoOf(userContext).disconnectFromAll(pageTypeId, pageTypeVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new PageTypeManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(RetailscmUserContext userContext, PageType newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    pageTypeDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   PageType newPageType = this.createPageType(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newPageType
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
    key.put(UserApp.APP_TYPE_PROPERTY, PageType.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(RetailscmUserContext userContext, SmartList<PageType> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<MobileApp> mobileAppList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, MobileApp.class);
    userContext.getDAOGroup().enhanceList(mobileAppList, MobileApp.class);
  }

  public Object listByMobileApp(RetailscmUserContext userContext, String mobileAppId)
      throws Exception {
    return listPageByMobileApp(userContext, mobileAppId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByMobileApp(
      RetailscmUserContext userContext, String mobileAppId, int start, int count) throws Exception {
    SmartList<PageType> list =
        pageTypeDaoOf(userContext)
            .findPageTypeByMobileApp(mobileAppId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(PageType.class);
    page.setContainerObject(MobileApp.withId(mobileAppId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("页面类型列表");
    page.setRequestName("listByMobileApp");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByMobileApp/%s/", getBeanName(), mobileAppId)));

    page.assemblerContent(userContext, "listByMobileApp");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String pageTypeId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    PageType merchantObj = (PageType) this.view(userContext, pageTypeId);
    String merchantObjId = pageTypeId;
    String linkToUrl = "pageTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "页面类型" + "详情";
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
        MapUtil.put("id", "2-name")
            .put("fieldName", "name")
            .put("label", "名称")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("name", merchantObj.getName());

    propList.add(
        MapUtil.put("id", "3-code")
            .put("fieldName", "code")
            .put("label", "代码")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("code", merchantObj.getCode());

    propList.add(
        MapUtil.put("id", "4-mobileApp")
            .put("fieldName", "mobileApp")
            .put("label", "手机应用程序")
            .put("type", "auto")
            .put("linkToUrl", "mobileAppManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("mobileApp", merchantObj.getMobileApp());

    propList.add(
        MapUtil.put("id", "5-footerTab")
            .put("fieldName", "footerTab")
            .put("label", "页脚选项卡")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("footerTab", merchantObj.getFooterTab());

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
