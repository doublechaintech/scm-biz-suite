package com.doublechaintech.retailscm.transporttasktrack;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.transporttask.CandidateTransportTask;
import com.doublechaintech.retailscm.transporttask.TransportTask;
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

public class TransportTaskTrackManagerImpl extends CustomRetailscmCheckerManager
    implements TransportTaskTrackManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "TransportTaskTrack";

  @Override
  public TransportTaskTrackDAO daoOf(RetailscmUserContext userContext) {
    return transportTaskTrackDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws TransportTaskTrackManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new TransportTaskTrackManagerException(message);
  }

  protected TransportTaskTrack saveTransportTaskTrack(
      RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, String[] tokensExpr)
      throws Exception {
    // return getTransportTaskTrackDAO().save(transportTaskTrack, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveTransportTaskTrack(userContext, transportTaskTrack, tokens);
  }

  protected TransportTaskTrack saveTransportTaskTrackDetail(
      RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception {

    return saveTransportTaskTrack(userContext, transportTaskTrack, allTokens());
  }

  public TransportTaskTrack loadTransportTaskTrack(
      RetailscmUserContext userContext, String transportTaskTrackId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);

    checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    TransportTaskTrack transportTaskTrack =
        loadTransportTaskTrack(userContext, transportTaskTrackId, tokens);
    // do some calc before sent to customer?
    return present(userContext, transportTaskTrack, tokens);
  }

  public TransportTaskTrack searchTransportTaskTrack(
      RetailscmUserContext userContext,
      String transportTaskTrackId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);

    checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    TransportTaskTrack transportTaskTrack =
        loadTransportTaskTrack(userContext, transportTaskTrackId, tokens);
    // do some calc before sent to customer?
    return present(userContext, transportTaskTrack, tokens);
  }

  protected TransportTaskTrack present(
      RetailscmUserContext userContext,
      TransportTaskTrack transportTaskTrack,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, transportTaskTrack, tokens);

    TransportTaskTrack transportTaskTrackToPresent =
        transportTaskTrackDaoOf(userContext).present(transportTaskTrack, tokens);

    List<BaseEntity> entityListToNaming = transportTaskTrackToPresent.collectReferencesFromLists();
    transportTaskTrackDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, transportTaskTrack, tokens);

    return transportTaskTrackToPresent;
  }

  public TransportTaskTrack loadTransportTaskTrackDetail(
      RetailscmUserContext userContext, String transportTaskTrackId) throws Exception {
    TransportTaskTrack transportTaskTrack =
        loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());
    return present(userContext, transportTaskTrack, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String transportTaskTrackId)
      throws Exception {
    TransportTaskTrack transportTaskTrack =
        loadTransportTaskTrack(userContext, transportTaskTrackId, viewTokens());
    markVisited(userContext, transportTaskTrack);
    return present(userContext, transportTaskTrack, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String transportTaskTrackId)
      throws Exception {
    TransportTaskTrack transportTaskTrack =
        loadTransportTaskTrack(userContext, transportTaskTrackId, viewTokens());
    transportTaskTrack.summarySuffix();
    markVisited(userContext, transportTaskTrack);
    return present(userContext, transportTaskTrack, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String transportTaskTrackId)
      throws Exception {
    TransportTaskTrack transportTaskTrack =
        loadTransportTaskTrack(userContext, transportTaskTrackId, analyzeTokens());
    markVisited(userContext, transportTaskTrack);
    return present(userContext, transportTaskTrack, analyzeTokens());
  }

  protected TransportTaskTrack saveTransportTaskTrack(
      RetailscmUserContext userContext,
      TransportTaskTrack transportTaskTrack,
      Map<String, Object> tokens)
      throws Exception {

    return transportTaskTrackDaoOf(userContext).save(transportTaskTrack, tokens);
  }

  protected TransportTaskTrack loadTransportTaskTrack(
      RetailscmUserContext userContext, String transportTaskTrackId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);

    checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);

    return transportTaskTrackDaoOf(userContext).load(transportTaskTrackId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      TransportTaskTrack transportTaskTrack,
      Map<String, Object> tokens) {
    super.addActions(userContext, transportTaskTrack, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens){

  @Override
  public List<TransportTaskTrack> searchTransportTaskTrackList(
      RetailscmUserContext ctx, TransportTaskTrackRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<TransportTaskTrack> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public TransportTaskTrack searchTransportTaskTrack(
      RetailscmUserContext ctx, TransportTaskTrackRequest pRequest) {
    pRequest.limit(0, 1);
    List<TransportTaskTrack> list = searchTransportTaskTrackList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public TransportTaskTrack createTransportTaskTrack(
      RetailscmUserContext userContext,
      Date trackTime,
      BigDecimal latitude,
      BigDecimal longitude,
      String movementId)
      throws Exception {

    checkerOf(userContext).checkTrackTimeOfTransportTaskTrack(trackTime);
    checkerOf(userContext).checkLatitudeOfTransportTaskTrack(latitude);
    checkerOf(userContext).checkLongitudeOfTransportTaskTrack(longitude);

    checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);

    TransportTaskTrack transportTaskTrack = createNewTransportTaskTrack();

    transportTaskTrack.setTrackTime(trackTime);
    transportTaskTrack.setLatitude(latitude);
    transportTaskTrack.setLongitude(longitude);

    TransportTask movement = loadTransportTask(userContext, movementId, emptyOptions());
    transportTaskTrack.setMovement(movement);

    transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, emptyOptions());

    onNewInstanceCreated(userContext, transportTaskTrack);
    return transportTaskTrack;
  }

  protected TransportTaskTrack createNewTransportTaskTrack() {

    return new TransportTaskTrack();
  }

  protected void checkParamsForUpdatingTransportTaskTrack(
      RetailscmUserContext userContext,
      String transportTaskTrackId,
      int transportTaskTrackVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);
    checkerOf(userContext).checkVersionOfTransportTaskTrack(transportTaskTrackVersion);

    if (TransportTaskTrack.TRACK_TIME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkTrackTimeOfTransportTaskTrack(parseDate(newValueExpr));
    }
    if (TransportTaskTrack.LATITUDE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLatitudeOfTransportTaskTrack(parseBigDecimal(newValueExpr));
    }
    if (TransportTaskTrack.LONGITUDE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLongitudeOfTransportTaskTrack(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);
  }

  public TransportTaskTrack clone(RetailscmUserContext userContext, String fromTransportTaskTrackId)
      throws Exception {

    return transportTaskTrackDaoOf(userContext).clone(fromTransportTaskTrackId, this.allTokens());
  }

  public TransportTaskTrack internalSaveTransportTaskTrack(
      RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception {
    return internalSaveTransportTaskTrack(userContext, transportTaskTrack, allTokens());
  }

  public TransportTaskTrack internalSaveTransportTaskTrack(
      RetailscmUserContext userContext,
      TransportTaskTrack transportTaskTrack,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskTrackId,
    // transportTaskTrackVersion, property, newValueExpr, tokensExpr);

    synchronized (transportTaskTrack) {
      // will be good when the transportTaskTrack loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to TransportTaskTrack.
      if (transportTaskTrack.isChanged()) {}

      // checkerOf(userContext).checkAndFixTransportTaskTrack(transportTaskTrack);
      transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, options);
      return transportTaskTrack;
    }
  }

  public TransportTaskTrack updateTransportTaskTrack(
      RetailscmUserContext userContext,
      String transportTaskTrackId,
      int transportTaskTrackVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingTransportTaskTrack(
        userContext,
        transportTaskTrackId,
        transportTaskTrackVersion,
        property,
        newValueExpr,
        tokensExpr);

    TransportTaskTrack transportTaskTrack =
        loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());
    if (transportTaskTrack.getVersion() != transportTaskTrackVersion) {
      String message =
          "The target version("
              + transportTaskTrack.getVersion()
              + ") is not equals to version("
              + transportTaskTrackVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (transportTaskTrack) {
      // will be good when the transportTaskTrack loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to TransportTaskTrack.

      transportTaskTrack.changeProperty(property, newValueExpr);
      transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
      return present(userContext, transportTaskTrack, mergedAllTokens(tokensExpr));
      // return saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
    }
  }

  public TransportTaskTrack updateTransportTaskTrackProperty(
      RetailscmUserContext userContext,
      String transportTaskTrackId,
      int transportTaskTrackVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingTransportTaskTrack(
        userContext,
        transportTaskTrackId,
        transportTaskTrackVersion,
        property,
        newValueExpr,
        tokensExpr);

    TransportTaskTrack transportTaskTrack =
        loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());
    if (transportTaskTrack.getVersion() != transportTaskTrackVersion) {
      String message =
          "The target version("
              + transportTaskTrack.getVersion()
              + ") is not equals to version("
              + transportTaskTrackVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (transportTaskTrack) {
      // will be good when the transportTaskTrack loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to TransportTaskTrack.

      transportTaskTrack.changeProperty(property, newValueExpr);

      transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
      return present(userContext, transportTaskTrack, mergedAllTokens(tokensExpr));
      // return saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected TransportTaskTrackTokens tokens() {
    return TransportTaskTrackTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return TransportTaskTrackTokens.all();
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
    return TransportTaskTrackTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherMovement(
      RetailscmUserContext userContext, String transportTaskTrackId, String anotherMovementId)
      throws Exception {

    checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);
    checkerOf(userContext)
        .checkIdOfTransportTask(anotherMovementId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);
  }

  public TransportTaskTrack transferToAnotherMovement(
      RetailscmUserContext userContext, String transportTaskTrackId, String anotherMovementId)
      throws Exception {
    checkParamsForTransferingAnotherMovement(userContext, transportTaskTrackId, anotherMovementId);

    TransportTaskTrack transportTaskTrack =
        loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());
    synchronized (transportTaskTrack) {
      // will be good when the transportTaskTrack loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      TransportTask movement = loadTransportTask(userContext, anotherMovementId, emptyOptions());
      transportTaskTrack.updateMovement(movement);

      transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, emptyOptions());

      return present(userContext, transportTaskTrack, allTokens());
    }
  }

  public CandidateTransportTask requestCandidateMovement(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateTransportTask result = new CandidateTransportTask();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<TransportTask> candidateList =
        transportTaskDaoOf(userContext)
            .requestCandidateTransportTaskForTransportTaskTrack(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected TransportTask loadTransportTask(
      RetailscmUserContext userContext, String newMovementId, Map<String, Object> options)
      throws Exception {

    return transportTaskDaoOf(userContext).load(newMovementId, options);
  }

  // --------------------------------------------------------------

  public TransportTaskTrack forgetByAll(
      RetailscmUserContext userContext, String transportTaskTrackId, int transportTaskTrackVersion)
      throws Exception {
    return forgetByAllInternal(userContext, transportTaskTrackId, transportTaskTrackVersion);
  }

  protected TransportTaskTrack forgetByAllInternal(
      RetailscmUserContext userContext, String transportTaskTrackId, int transportTaskTrackVersion)
      throws Exception {

    return transportTaskTrackDaoOf(userContext)
        .disconnectFromAll(transportTaskTrackId, transportTaskTrackVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new TransportTaskTrackManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(RetailscmUserContext userContext, TransportTaskTrack newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    transportTaskTrackDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   TransportTaskTrack newTransportTaskTrack = this.createTransportTaskTrack(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newTransportTaskTrack
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
    key.put(UserApp.APP_TYPE_PROPERTY, TransportTaskTrack.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<TransportTaskTrack> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<TransportTask> movementList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TransportTask.class);
    userContext.getDAOGroup().enhanceList(movementList, TransportTask.class);
  }

  public Object listByMovement(RetailscmUserContext userContext, String movementId)
      throws Exception {
    return listPageByMovement(userContext, movementId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByMovement(
      RetailscmUserContext userContext, String movementId, int start, int count) throws Exception {
    SmartList<TransportTaskTrack> list =
        transportTaskTrackDaoOf(userContext)
            .findTransportTaskTrackByMovement(movementId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(TransportTaskTrack.class);
    page.setContainerObject(TransportTask.withId(movementId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("运输任务跟踪列表");
    page.setRequestName("listByMovement");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByMovement/%s/", getBeanName(), movementId)));

    page.assemblerContent(userContext, "listByMovement");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String transportTaskTrackId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    TransportTaskTrack merchantObj =
        (TransportTaskTrack) this.view(userContext, transportTaskTrackId);
    String merchantObjId = transportTaskTrackId;
    String linkToUrl = "transportTaskTrackManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "运输任务跟踪" + "详情";
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
        MapUtil.put("id", "2-trackTime")
            .put("fieldName", "trackTime")
            .put("label", "跟踪时间")
            .put("type", "date")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("trackTime", merchantObj.getTrackTime());

    propList.add(
        MapUtil.put("id", "3-latitude")
            .put("fieldName", "latitude")
            .put("label", "纬度")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("latitude", merchantObj.getLatitude());

    propList.add(
        MapUtil.put("id", "4-longitude")
            .put("fieldName", "longitude")
            .put("label", "经度")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("longitude", merchantObj.getLongitude());

    propList.add(
        MapUtil.put("id", "5-movement")
            .put("fieldName", "movement")
            .put("label", "运动")
            .put("type", "auto")
            .put("linkToUrl", "transportTaskManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"start\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("movement", merchantObj.getMovement());

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
