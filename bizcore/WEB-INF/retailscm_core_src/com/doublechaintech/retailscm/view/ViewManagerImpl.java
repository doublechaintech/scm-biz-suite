package com.doublechaintech.retailscm.view;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
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

public class ViewManagerImpl extends CustomRetailscmCheckerManager
    implements ViewManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "View";

  @Override
  public ViewDAO daoOf(RetailscmUserContext userContext) {
    return viewDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws ViewManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new ViewManagerException(message);
  }

  protected View saveView(RetailscmUserContext userContext, View view, String[] tokensExpr)
      throws Exception {
    // return getViewDAO().save(view, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveView(userContext, view, tokens);
  }

  protected View saveViewDetail(RetailscmUserContext userContext, View view) throws Exception {

    return saveView(userContext, view, allTokens());
  }

  public View loadView(RetailscmUserContext userContext, String viewId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfView(viewId);

    checkerOf(userContext).throwExceptionIfHasErrors(ViewManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    View view = loadView(userContext, viewId, tokens);
    // do some calc before sent to customer?
    return present(userContext, view, tokens);
  }

  public View searchView(
      RetailscmUserContext userContext, String viewId, String textToSearch, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfView(viewId);

    checkerOf(userContext).throwExceptionIfHasErrors(ViewManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    View view = loadView(userContext, viewId, tokens);
    // do some calc before sent to customer?
    return present(userContext, view, tokens);
  }

  protected View present(RetailscmUserContext userContext, View view, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, view, tokens);

    View viewToPresent = viewDaoOf(userContext).present(view, tokens);

    List<BaseEntity> entityListToNaming = viewToPresent.collectReferencesFromLists();
    viewDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, view, tokens);

    return viewToPresent;
  }

  public View loadViewDetail(RetailscmUserContext userContext, String viewId) throws Exception {
    View view = loadView(userContext, viewId, allTokens());
    return present(userContext, view, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String viewId) throws Exception {
    View view = loadView(userContext, viewId, viewTokens());
    markVisited(userContext, view);
    return present(userContext, view, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String viewId) throws Exception {
    View view = loadView(userContext, viewId, viewTokens());
    view.summarySuffix();
    markVisited(userContext, view);
    return present(userContext, view, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String viewId) throws Exception {
    View view = loadView(userContext, viewId, analyzeTokens());
    markVisited(userContext, view);
    return present(userContext, view, analyzeTokens());
  }

  protected View saveView(RetailscmUserContext userContext, View view, Map<String, Object> tokens)
      throws Exception {

    return viewDaoOf(userContext).save(view, tokens);
  }

  protected View loadView(
      RetailscmUserContext userContext, String viewId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfView(viewId);

    checkerOf(userContext).throwExceptionIfHasErrors(ViewManagerException.class);

    return viewDaoOf(userContext).load(viewId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, View view, Map<String, Object> tokens) {
    super.addActions(userContext, view, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, View view, Map<String, Object> tokens){

  @Override
  public List<View> searchViewList(RetailscmUserContext ctx, ViewRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<View> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public View searchView(RetailscmUserContext ctx, ViewRequest pRequest) {
    pRequest.limit(0, 1);
    List<View> list = searchViewList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public View createView(
      RetailscmUserContext userContext, String who, String assessment, Date interviewTime)
      throws Exception {

    checkerOf(userContext).checkWhoOfView(who);
    checkerOf(userContext).checkAssessmentOfView(assessment);
    checkerOf(userContext).checkInterviewTimeOfView(interviewTime);

    checkerOf(userContext).throwExceptionIfHasErrors(ViewManagerException.class);

    View view = createNewView();

    view.setWho(who);
    view.setAssessment(assessment);
    view.setInterviewTime(interviewTime);

    view = saveView(userContext, view, emptyOptions());

    onNewInstanceCreated(userContext, view);
    return view;
  }

  protected View createNewView() {

    return new View();
  }

  protected void checkParamsForUpdatingView(
      RetailscmUserContext userContext,
      String viewId,
      int viewVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfView(viewId);
    checkerOf(userContext).checkVersionOfView(viewVersion);

    if (View.WHO_PROPERTY.equals(property)) {

      checkerOf(userContext).checkWhoOfView(parseString(newValueExpr));
    }
    if (View.ASSESSMENT_PROPERTY.equals(property)) {

      checkerOf(userContext).checkAssessmentOfView(parseString(newValueExpr));
    }
    if (View.INTERVIEW_TIME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkInterviewTimeOfView(parseDate(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ViewManagerException.class);
  }

  public View clone(RetailscmUserContext userContext, String fromViewId) throws Exception {

    return viewDaoOf(userContext).clone(fromViewId, this.allTokens());
  }

  public View internalSaveView(RetailscmUserContext userContext, View view) throws Exception {
    return internalSaveView(userContext, view, allTokens());
  }

  public View internalSaveView(
      RetailscmUserContext userContext, View view, Map<String, Object> options) throws Exception {
    // checkParamsForUpdatingView(userContext, viewId, viewVersion, property, newValueExpr,
    // tokensExpr);

    synchronized (view) {
      // will be good when the view loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to View.
      if (view.isChanged()) {}

      // checkerOf(userContext).checkAndFixView(view);
      view = saveView(userContext, view, options);
      return view;
    }
  }

  public View updateView(
      RetailscmUserContext userContext,
      String viewId,
      int viewVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingView(
        userContext, viewId, viewVersion, property, newValueExpr, tokensExpr);

    View view = loadView(userContext, viewId, allTokens());
    if (view.getVersion() != viewVersion) {
      String message =
          "The target version("
              + view.getVersion()
              + ") is not equals to version("
              + viewVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (view) {
      // will be good when the view loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to View.

      view.changeProperty(property, newValueExpr);
      view = saveView(userContext, view, tokens().done());
      return present(userContext, view, mergedAllTokens(tokensExpr));
      // return saveView(userContext, view, tokens().done());
    }
  }

  public View updateViewProperty(
      RetailscmUserContext userContext,
      String viewId,
      int viewVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingView(
        userContext, viewId, viewVersion, property, newValueExpr, tokensExpr);

    View view = loadView(userContext, viewId, allTokens());
    if (view.getVersion() != viewVersion) {
      String message =
          "The target version("
              + view.getVersion()
              + ") is not equals to version("
              + viewVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (view) {
      // will be good when the view loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to View.

      view.changeProperty(property, newValueExpr);

      view = saveView(userContext, view, tokens().done());
      return present(userContext, view, mergedAllTokens(tokensExpr));
      // return saveView(userContext, view, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected ViewTokens tokens() {
    return ViewTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return ViewTokens.all();
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
    return ViewTokens.mergeAll(tokens).done();
  }

  // --------------------------------------------------------------

  // --------------------------------------------------------------

  public View forgetByAll(RetailscmUserContext userContext, String viewId, int viewVersion)
      throws Exception {
    return forgetByAllInternal(userContext, viewId, viewVersion);
  }

  protected View forgetByAllInternal(
      RetailscmUserContext userContext, String viewId, int viewVersion) throws Exception {

    return viewDaoOf(userContext).disconnectFromAll(viewId, viewVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new ViewManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(RetailscmUserContext userContext, View newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    viewDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   View newView = this.createView(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newView
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
    key.put(UserApp.APP_TYPE_PROPERTY, View.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(RetailscmUserContext userContext, SmartList<View> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String viewId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    View merchantObj = (View) this.view(userContext, viewId);
    String merchantObjId = viewId;
    String linkToUrl = "viewManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "观" + "详情";
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
        MapUtil.put("id", "2-who")
            .put("fieldName", "who")
            .put("label", "谁")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("who", merchantObj.getWho());

    propList.add(
        MapUtil.put("id", "3-assessment")
            .put("fieldName", "assessment")
            .put("label", "评估")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("assessment", merchantObj.getAssessment());

    propList.add(
        MapUtil.put("id", "4-interviewTime")
            .put("fieldName", "interviewTime")
            .put("label", "面试时间")
            .put("type", "date")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("interviewTime", merchantObj.getInterviewTime());

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
