package com.doublechaintech.retailscm.uiaction;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.page.CandidatePage;
import com.doublechaintech.retailscm.page.Page;
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

public class UiActionManagerImpl extends CustomRetailscmCheckerManager
    implements UiActionManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "UiAction";

  @Override
  public UiActionDAO daoOf(RetailscmUserContext userContext) {
    return uiActionDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws UiActionManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new UiActionManagerException(message);
  }

  protected UiAction saveUiAction(
      RetailscmUserContext userContext, UiAction uiAction, String[] tokensExpr) throws Exception {
    // return getUiActionDAO().save(uiAction, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveUiAction(userContext, uiAction, tokens);
  }

  protected UiAction saveUiActionDetail(RetailscmUserContext userContext, UiAction uiAction)
      throws Exception {

    return saveUiAction(userContext, uiAction, allTokens());
  }

  public UiAction loadUiAction(
      RetailscmUserContext userContext, String uiActionId, String[] tokensExpr) throws Exception {

    checkerOf(userContext).checkIdOfUiAction(uiActionId);

    checkerOf(userContext).throwExceptionIfHasErrors(UiActionManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    UiAction uiAction = loadUiAction(userContext, uiActionId, tokens);
    // do some calc before sent to customer?
    return present(userContext, uiAction, tokens);
  }

  public UiAction searchUiAction(
      RetailscmUserContext userContext, String uiActionId, String textToSearch, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfUiAction(uiActionId);

    checkerOf(userContext).throwExceptionIfHasErrors(UiActionManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    UiAction uiAction = loadUiAction(userContext, uiActionId, tokens);
    // do some calc before sent to customer?
    return present(userContext, uiAction, tokens);
  }

  protected UiAction present(
      RetailscmUserContext userContext, UiAction uiAction, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, uiAction, tokens);

    UiAction uiActionToPresent = uiActionDaoOf(userContext).present(uiAction, tokens);

    List<BaseEntity> entityListToNaming = uiActionToPresent.collectReferencesFromLists();
    uiActionDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, uiAction, tokens);

    return uiActionToPresent;
  }

  public UiAction loadUiActionDetail(RetailscmUserContext userContext, String uiActionId)
      throws Exception {
    UiAction uiAction = loadUiAction(userContext, uiActionId, allTokens());
    return present(userContext, uiAction, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String uiActionId) throws Exception {
    UiAction uiAction = loadUiAction(userContext, uiActionId, viewTokens());
    markVisited(userContext, uiAction);
    return present(userContext, uiAction, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String uiActionId) throws Exception {
    UiAction uiAction = loadUiAction(userContext, uiActionId, viewTokens());
    uiAction.summarySuffix();
    markVisited(userContext, uiAction);
    return present(userContext, uiAction, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String uiActionId) throws Exception {
    UiAction uiAction = loadUiAction(userContext, uiActionId, analyzeTokens());
    markVisited(userContext, uiAction);
    return present(userContext, uiAction, analyzeTokens());
  }

  protected UiAction saveUiAction(
      RetailscmUserContext userContext, UiAction uiAction, Map<String, Object> tokens)
      throws Exception {

    return uiActionDaoOf(userContext).save(uiAction, tokens);
  }

  protected UiAction loadUiAction(
      RetailscmUserContext userContext, String uiActionId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfUiAction(uiActionId);

    checkerOf(userContext).throwExceptionIfHasErrors(UiActionManagerException.class);

    return uiActionDaoOf(userContext).load(uiActionId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, UiAction uiAction, Map<String, Object> tokens) {
    super.addActions(userContext, uiAction, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, UiAction uiAction, Map<String, Object> tokens){

  @Override
  public List<UiAction> searchUiActionList(RetailscmUserContext ctx, UiActionRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<UiAction> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public UiAction searchUiAction(RetailscmUserContext ctx, UiActionRequest pRequest) {
    pRequest.limit(0, 1);
    List<UiAction> list = searchUiActionList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public UiAction createUiAction(
      RetailscmUserContext userContext,
      String code,
      String icon,
      String title,
      int displayOrder,
      String brief,
      String imageUrl,
      String linkToUrl,
      String extraData,
      String pageId)
      throws Exception {

    checkerOf(userContext).checkCodeOfUiAction(code);
    checkerOf(userContext).checkIconOfUiAction(icon);
    checkerOf(userContext).checkTitleOfUiAction(title);
    checkerOf(userContext).checkDisplayOrderOfUiAction(displayOrder);
    checkerOf(userContext).checkBriefOfUiAction(brief);
    checkerOf(userContext).checkImageUrlOfUiAction(imageUrl);
    checkerOf(userContext).checkLinkToUrlOfUiAction(linkToUrl);
    checkerOf(userContext).checkExtraDataOfUiAction(extraData);

    checkerOf(userContext).throwExceptionIfHasErrors(UiActionManagerException.class);

    UiAction uiAction = createNewUiAction();

    uiAction.setCode(code);
    uiAction.setIcon(icon);
    uiAction.setTitle(title);
    uiAction.setDisplayOrder(displayOrder);
    uiAction.setBrief(brief);
    uiAction.setImageUrl(imageUrl);
    uiAction.setLinkToUrl(linkToUrl);
    uiAction.setExtraData(extraData);

    Page page = loadPage(userContext, pageId, emptyOptions());
    uiAction.setPage(page);

    uiAction = saveUiAction(userContext, uiAction, emptyOptions());

    onNewInstanceCreated(userContext, uiAction);
    return uiAction;
  }

  protected UiAction createNewUiAction() {

    return new UiAction();
  }

  protected void checkParamsForUpdatingUiAction(
      RetailscmUserContext userContext,
      String uiActionId,
      int uiActionVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfUiAction(uiActionId);
    checkerOf(userContext).checkVersionOfUiAction(uiActionVersion);

    if (UiAction.CODE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkCodeOfUiAction(parseString(newValueExpr));
    }
    if (UiAction.ICON_PROPERTY.equals(property)) {

      checkerOf(userContext).checkIconOfUiAction(parseString(newValueExpr));
    }
    if (UiAction.TITLE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkTitleOfUiAction(parseString(newValueExpr));
    }
    if (UiAction.DISPLAY_ORDER_PROPERTY.equals(property)) {

      checkerOf(userContext).checkDisplayOrderOfUiAction(parseInt(newValueExpr));
    }
    if (UiAction.BRIEF_PROPERTY.equals(property)) {

      checkerOf(userContext).checkBriefOfUiAction(parseString(newValueExpr));
    }
    if (UiAction.IMAGE_URL_PROPERTY.equals(property)) {

      checkerOf(userContext).checkImageUrlOfUiAction(parseString(newValueExpr));
    }
    if (UiAction.LINK_TO_URL_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLinkToUrlOfUiAction(parseString(newValueExpr));
    }
    if (UiAction.EXTRA_DATA_PROPERTY.equals(property)) {

      checkerOf(userContext).checkExtraDataOfUiAction(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(UiActionManagerException.class);
  }

  public UiAction clone(RetailscmUserContext userContext, String fromUiActionId) throws Exception {

    return uiActionDaoOf(userContext).clone(fromUiActionId, this.allTokens());
  }

  public UiAction internalSaveUiAction(RetailscmUserContext userContext, UiAction uiAction)
      throws Exception {
    return internalSaveUiAction(userContext, uiAction, allTokens());
  }

  public UiAction internalSaveUiAction(
      RetailscmUserContext userContext, UiAction uiAction, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingUiAction(userContext, uiActionId, uiActionVersion, property,
    // newValueExpr, tokensExpr);

    synchronized (uiAction) {
      // will be good when the uiAction loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to UiAction.
      if (uiAction.isChanged()) {}

      // checkerOf(userContext).checkAndFixUiAction(uiAction);
      uiAction = saveUiAction(userContext, uiAction, options);
      return uiAction;
    }
  }

  public UiAction updateUiAction(
      RetailscmUserContext userContext,
      String uiActionId,
      int uiActionVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingUiAction(
        userContext, uiActionId, uiActionVersion, property, newValueExpr, tokensExpr);

    UiAction uiAction = loadUiAction(userContext, uiActionId, allTokens());
    if (uiAction.getVersion() != uiActionVersion) {
      String message =
          "The target version("
              + uiAction.getVersion()
              + ") is not equals to version("
              + uiActionVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (uiAction) {
      // will be good when the uiAction loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to UiAction.

      uiAction.changeProperty(property, newValueExpr);
      uiAction = saveUiAction(userContext, uiAction, tokens().done());
      return present(userContext, uiAction, mergedAllTokens(tokensExpr));
      // return saveUiAction(userContext, uiAction, tokens().done());
    }
  }

  public UiAction updateUiActionProperty(
      RetailscmUserContext userContext,
      String uiActionId,
      int uiActionVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingUiAction(
        userContext, uiActionId, uiActionVersion, property, newValueExpr, tokensExpr);

    UiAction uiAction = loadUiAction(userContext, uiActionId, allTokens());
    if (uiAction.getVersion() != uiActionVersion) {
      String message =
          "The target version("
              + uiAction.getVersion()
              + ") is not equals to version("
              + uiActionVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (uiAction) {
      // will be good when the uiAction loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to UiAction.

      uiAction.changeProperty(property, newValueExpr);

      uiAction = saveUiAction(userContext, uiAction, tokens().done());
      return present(userContext, uiAction, mergedAllTokens(tokensExpr));
      // return saveUiAction(userContext, uiAction, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected UiActionTokens tokens() {
    return UiActionTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return UiActionTokens.all();
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
    return UiActionTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherPage(
      RetailscmUserContext userContext, String uiActionId, String anotherPageId) throws Exception {

    checkerOf(userContext).checkIdOfUiAction(uiActionId);
    checkerOf(userContext).checkIdOfPage(anotherPageId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(UiActionManagerException.class);
  }

  public UiAction transferToAnotherPage(
      RetailscmUserContext userContext, String uiActionId, String anotherPageId) throws Exception {
    checkParamsForTransferingAnotherPage(userContext, uiActionId, anotherPageId);

    UiAction uiAction = loadUiAction(userContext, uiActionId, allTokens());
    synchronized (uiAction) {
      // will be good when the uiAction loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      Page page = loadPage(userContext, anotherPageId, emptyOptions());
      uiAction.updatePage(page);

      uiAction = saveUiAction(userContext, uiAction, emptyOptions());

      return present(userContext, uiAction, allTokens());
    }
  }

  public CandidatePage requestCandidatePage(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidatePage result = new CandidatePage();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("pageTitle");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<Page> candidateList =
        pageDaoOf(userContext)
            .requestCandidatePageForUiAction(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected Page loadPage(
      RetailscmUserContext userContext, String newPageId, Map<String, Object> options)
      throws Exception {

    return pageDaoOf(userContext).load(newPageId, options);
  }

  // --------------------------------------------------------------

  public UiAction forgetByAll(
      RetailscmUserContext userContext, String uiActionId, int uiActionVersion) throws Exception {
    return forgetByAllInternal(userContext, uiActionId, uiActionVersion);
  }

  protected UiAction forgetByAllInternal(
      RetailscmUserContext userContext, String uiActionId, int uiActionVersion) throws Exception {

    return uiActionDaoOf(userContext).disconnectFromAll(uiActionId, uiActionVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new UiActionManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(RetailscmUserContext userContext, UiAction newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    uiActionDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   UiAction newUiAction = this.createUiAction(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newUiAction
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
    key.put(UserApp.APP_TYPE_PROPERTY, UiAction.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(RetailscmUserContext userContext, SmartList<UiAction> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<Page> pageList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Page.class);
    userContext.getDAOGroup().enhanceList(pageList, Page.class);
  }

  public Object listByPage(RetailscmUserContext userContext, String pageId) throws Exception {
    return listPageByPage(userContext, pageId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByPage(
      RetailscmUserContext userContext, String pageId, int start, int count) throws Exception {
    SmartList<UiAction> list =
        uiActionDaoOf(userContext).findUiActionByPage(pageId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(UiAction.class);
    page.setContainerObject(Page.withId(pageId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("用户界面操作列表");
    page.setRequestName("listByPage");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByPage/%s/", getBeanName(), pageId)));

    page.assemblerContent(userContext, "listByPage");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String uiActionId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    UiAction merchantObj = (UiAction) this.view(userContext, uiActionId);
    String merchantObjId = uiActionId;
    String linkToUrl = "uiActionManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "用户界面操作" + "详情";
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
        MapUtil.put("id", "3-icon")
            .put("fieldName", "icon")
            .put("label", "图标")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("icon", merchantObj.getIcon());

    propList.add(
        MapUtil.put("id", "4-title")
            .put("fieldName", "title")
            .put("label", "头衔")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("title", merchantObj.getTitle());

    propList.add(
        MapUtil.put("id", "5-displayOrder")
            .put("fieldName", "displayOrder")
            .put("label", "顺序")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("displayOrder", merchantObj.getDisplayOrder());

    propList.add(
        MapUtil.put("id", "6-brief")
            .put("fieldName", "brief")
            .put("label", "短暂的")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("brief", merchantObj.getBrief());

    propList.add(
        MapUtil.put("id", "7-imageUrl")
            .put("fieldName", "imageUrl")
            .put("label", "图片链接")
            .put("type", "image")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("imageUrl", merchantObj.getImageUrl());

    propList.add(
        MapUtil.put("id", "8-linkToUrl")
            .put("fieldName", "linkToUrl")
            .put("label", "链接网址")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("linkToUrl", merchantObj.getLinkToUrl());

    propList.add(
        MapUtil.put("id", "9-extraData")
            .put("fieldName", "extraData")
            .put("label", "额外的数据")
            .put("type", "longtext")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("extraData", merchantObj.getExtraData());

    propList.add(
        MapUtil.put("id", "10-page")
            .put("fieldName", "page")
            .put("label", "页面")
            .put("type", "auto")
            .put("linkToUrl", "pageManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"display_order\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"page_title\",\"imageList\":\"\"}")
            .into_map());
    result.put("page", merchantObj.getPage());

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
