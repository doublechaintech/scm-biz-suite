package com.doublechaintech.retailscm.goodsmovement;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.goods.CandidateGoods;
import com.doublechaintech.retailscm.goods.Goods;
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

public class GoodsMovementManagerImpl extends CustomRetailscmCheckerManager
    implements GoodsMovementManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "GoodsMovement";

  @Override
  public GoodsMovementDAO daoOf(RetailscmUserContext userContext) {
    return goodsMovementDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws GoodsMovementManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new GoodsMovementManagerException(message);
  }

  protected GoodsMovement saveGoodsMovement(
      RetailscmUserContext userContext, GoodsMovement goodsMovement, String[] tokensExpr)
      throws Exception {
    // return getGoodsMovementDAO().save(goodsMovement, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveGoodsMovement(userContext, goodsMovement, tokens);
  }

  protected GoodsMovement saveGoodsMovementDetail(
      RetailscmUserContext userContext, GoodsMovement goodsMovement) throws Exception {

    return saveGoodsMovement(userContext, goodsMovement, allTokens());
  }

  public GoodsMovement loadGoodsMovement(
      RetailscmUserContext userContext, String goodsMovementId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsMovement(goodsMovementId);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsMovementManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    GoodsMovement goodsMovement = loadGoodsMovement(userContext, goodsMovementId, tokens);
    // do some calc before sent to customer?
    return present(userContext, goodsMovement, tokens);
  }

  public GoodsMovement searchGoodsMovement(
      RetailscmUserContext userContext,
      String goodsMovementId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsMovement(goodsMovementId);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsMovementManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    GoodsMovement goodsMovement = loadGoodsMovement(userContext, goodsMovementId, tokens);
    // do some calc before sent to customer?
    return present(userContext, goodsMovement, tokens);
  }

  protected GoodsMovement present(
      RetailscmUserContext userContext, GoodsMovement goodsMovement, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, goodsMovement, tokens);

    GoodsMovement goodsMovementToPresent =
        goodsMovementDaoOf(userContext).present(goodsMovement, tokens);

    List<BaseEntity> entityListToNaming = goodsMovementToPresent.collectReferencesFromLists();
    goodsMovementDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, goodsMovement, tokens);

    return goodsMovementToPresent;
  }

  public GoodsMovement loadGoodsMovementDetail(
      RetailscmUserContext userContext, String goodsMovementId) throws Exception {
    GoodsMovement goodsMovement = loadGoodsMovement(userContext, goodsMovementId, allTokens());
    return present(userContext, goodsMovement, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String goodsMovementId) throws Exception {
    GoodsMovement goodsMovement = loadGoodsMovement(userContext, goodsMovementId, viewTokens());
    markVisited(userContext, goodsMovement);
    return present(userContext, goodsMovement, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String goodsMovementId)
      throws Exception {
    GoodsMovement goodsMovement = loadGoodsMovement(userContext, goodsMovementId, viewTokens());
    goodsMovement.summarySuffix();
    markVisited(userContext, goodsMovement);
    return present(userContext, goodsMovement, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String goodsMovementId) throws Exception {
    GoodsMovement goodsMovement = loadGoodsMovement(userContext, goodsMovementId, analyzeTokens());
    markVisited(userContext, goodsMovement);
    return present(userContext, goodsMovement, analyzeTokens());
  }

  protected GoodsMovement saveGoodsMovement(
      RetailscmUserContext userContext, GoodsMovement goodsMovement, Map<String, Object> tokens)
      throws Exception {

    return goodsMovementDaoOf(userContext).save(goodsMovement, tokens);
  }

  protected GoodsMovement loadGoodsMovement(
      RetailscmUserContext userContext, String goodsMovementId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfGoodsMovement(goodsMovementId);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsMovementManagerException.class);

    return goodsMovementDaoOf(userContext).load(goodsMovementId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, GoodsMovement goodsMovement, Map<String, Object> tokens) {
    super.addActions(userContext, goodsMovement, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, GoodsMovement goodsMovement, Map<String, Object> tokens){

  @Override
  public List<GoodsMovement> searchGoodsMovementList(
      RetailscmUserContext ctx, GoodsMovementRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<GoodsMovement> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public GoodsMovement searchGoodsMovement(
      RetailscmUserContext ctx, GoodsMovementRequest pRequest) {
    pRequest.limit(0, 1);
    List<GoodsMovement> list = searchGoodsMovementList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public GoodsMovement createGoodsMovement(
      RetailscmUserContext userContext,
      DateTime moveTime,
      String facility,
      String facilityId,
      String fromIp,
      String userAgent,
      String sessionId,
      BigDecimal latitude,
      BigDecimal longitude,
      String goodsId)
      throws Exception {

    checkerOf(userContext).checkMoveTimeOfGoodsMovement(moveTime);
    checkerOf(userContext).checkFacilityOfGoodsMovement(facility);
    checkerOf(userContext).checkFacilityIdOfGoodsMovement(facilityId);
    checkerOf(userContext).checkFromIpOfGoodsMovement(fromIp);
    checkerOf(userContext).checkUserAgentOfGoodsMovement(userAgent);
    checkerOf(userContext).checkSessionIdOfGoodsMovement(sessionId);
    checkerOf(userContext).checkLatitudeOfGoodsMovement(latitude);
    checkerOf(userContext).checkLongitudeOfGoodsMovement(longitude);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsMovementManagerException.class);

    GoodsMovement goodsMovement = createNewGoodsMovement();

    goodsMovement.setMoveTime(moveTime);
    goodsMovement.setFacility(facility);
    goodsMovement.setFacilityId(facilityId);
    goodsMovement.setFromIp(fromIp);
    goodsMovement.setUserAgent(userAgent);
    goodsMovement.setSessionId(sessionId);
    goodsMovement.setLatitude(latitude);
    goodsMovement.setLongitude(longitude);

    Goods goods = loadGoods(userContext, goodsId, emptyOptions());
    goodsMovement.setGoods(goods);

    goodsMovement = saveGoodsMovement(userContext, goodsMovement, emptyOptions());

    onNewInstanceCreated(userContext, goodsMovement);
    return goodsMovement;
  }

  protected GoodsMovement createNewGoodsMovement() {

    return new GoodsMovement();
  }

  protected void checkParamsForUpdatingGoodsMovement(
      RetailscmUserContext userContext,
      String goodsMovementId,
      int goodsMovementVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsMovement(goodsMovementId);
    checkerOf(userContext).checkVersionOfGoodsMovement(goodsMovementVersion);

    if (GoodsMovement.MOVE_TIME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkMoveTimeOfGoodsMovement(parseTimestamp(newValueExpr));
    }
    if (GoodsMovement.FACILITY_PROPERTY.equals(property)) {

      checkerOf(userContext).checkFacilityOfGoodsMovement(parseString(newValueExpr));
    }
    if (GoodsMovement.FACILITY_ID_PROPERTY.equals(property)) {

      checkerOf(userContext).checkFacilityIdOfGoodsMovement(parseString(newValueExpr));
    }
    if (GoodsMovement.FROM_IP_PROPERTY.equals(property)) {

      checkerOf(userContext).checkFromIpOfGoodsMovement(parseString(newValueExpr));
    }
    if (GoodsMovement.USER_AGENT_PROPERTY.equals(property)) {

      checkerOf(userContext).checkUserAgentOfGoodsMovement(parseString(newValueExpr));
    }
    if (GoodsMovement.SESSION_ID_PROPERTY.equals(property)) {

      checkerOf(userContext).checkSessionIdOfGoodsMovement(parseString(newValueExpr));
    }
    if (GoodsMovement.LATITUDE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLatitudeOfGoodsMovement(parseBigDecimal(newValueExpr));
    }
    if (GoodsMovement.LONGITUDE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLongitudeOfGoodsMovement(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsMovementManagerException.class);
  }

  public GoodsMovement clone(RetailscmUserContext userContext, String fromGoodsMovementId)
      throws Exception {

    return goodsMovementDaoOf(userContext).clone(fromGoodsMovementId, this.allTokens());
  }

  public GoodsMovement internalSaveGoodsMovement(
      RetailscmUserContext userContext, GoodsMovement goodsMovement) throws Exception {
    return internalSaveGoodsMovement(userContext, goodsMovement, allTokens());
  }

  public GoodsMovement internalSaveGoodsMovement(
      RetailscmUserContext userContext, GoodsMovement goodsMovement, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingGoodsMovement(userContext, goodsMovementId, goodsMovementVersion,
    // property, newValueExpr, tokensExpr);

    synchronized (goodsMovement) {
      // will be good when the goodsMovement loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to GoodsMovement.
      if (goodsMovement.isChanged()) {}

      // checkerOf(userContext).checkAndFixGoodsMovement(goodsMovement);
      goodsMovement = saveGoodsMovement(userContext, goodsMovement, options);
      return goodsMovement;
    }
  }

  public GoodsMovement updateGoodsMovement(
      RetailscmUserContext userContext,
      String goodsMovementId,
      int goodsMovementVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingGoodsMovement(
        userContext, goodsMovementId, goodsMovementVersion, property, newValueExpr, tokensExpr);

    GoodsMovement goodsMovement = loadGoodsMovement(userContext, goodsMovementId, allTokens());
    if (goodsMovement.getVersion() != goodsMovementVersion) {
      String message =
          "The target version("
              + goodsMovement.getVersion()
              + ") is not equals to version("
              + goodsMovementVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (goodsMovement) {
      // will be good when the goodsMovement loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to GoodsMovement.

      goodsMovement.changeProperty(property, newValueExpr);
      goodsMovement = saveGoodsMovement(userContext, goodsMovement, tokens().done());
      return present(userContext, goodsMovement, mergedAllTokens(tokensExpr));
      // return saveGoodsMovement(userContext, goodsMovement, tokens().done());
    }
  }

  public GoodsMovement updateGoodsMovementProperty(
      RetailscmUserContext userContext,
      String goodsMovementId,
      int goodsMovementVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingGoodsMovement(
        userContext, goodsMovementId, goodsMovementVersion, property, newValueExpr, tokensExpr);

    GoodsMovement goodsMovement = loadGoodsMovement(userContext, goodsMovementId, allTokens());
    if (goodsMovement.getVersion() != goodsMovementVersion) {
      String message =
          "The target version("
              + goodsMovement.getVersion()
              + ") is not equals to version("
              + goodsMovementVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (goodsMovement) {
      // will be good when the goodsMovement loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to GoodsMovement.

      goodsMovement.changeProperty(property, newValueExpr);

      goodsMovement = saveGoodsMovement(userContext, goodsMovement, tokens().done());
      return present(userContext, goodsMovement, mergedAllTokens(tokensExpr));
      // return saveGoodsMovement(userContext, goodsMovement, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected GoodsMovementTokens tokens() {
    return GoodsMovementTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return GoodsMovementTokens.all();
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
    return GoodsMovementTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherGoods(
      RetailscmUserContext userContext, String goodsMovementId, String anotherGoodsId)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsMovement(goodsMovementId);
    checkerOf(userContext).checkIdOfGoods(anotherGoodsId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsMovementManagerException.class);
  }

  public GoodsMovement transferToAnotherGoods(
      RetailscmUserContext userContext, String goodsMovementId, String anotherGoodsId)
      throws Exception {
    checkParamsForTransferingAnotherGoods(userContext, goodsMovementId, anotherGoodsId);

    GoodsMovement goodsMovement = loadGoodsMovement(userContext, goodsMovementId, allTokens());
    synchronized (goodsMovement) {
      // will be good when the goodsMovement loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      Goods goods = loadGoods(userContext, anotherGoodsId, emptyOptions());
      goodsMovement.updateGoods(goods);

      goodsMovement = saveGoodsMovement(userContext, goodsMovement, emptyOptions());

      return present(userContext, goodsMovement, allTokens());
    }
  }

  public CandidateGoods requestCandidateGoods(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateGoods result = new CandidateGoods();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<Goods> candidateList =
        goodsDaoOf(userContext)
            .requestCandidateGoodsForGoodsMovement(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected Goods loadGoods(
      RetailscmUserContext userContext, String newGoodsId, Map<String, Object> options)
      throws Exception {

    return goodsDaoOf(userContext).load(newGoodsId, options);
  }

  // --------------------------------------------------------------

  public GoodsMovement forgetByAll(
      RetailscmUserContext userContext, String goodsMovementId, int goodsMovementVersion)
      throws Exception {
    return forgetByAllInternal(userContext, goodsMovementId, goodsMovementVersion);
  }

  protected GoodsMovement forgetByAllInternal(
      RetailscmUserContext userContext, String goodsMovementId, int goodsMovementVersion)
      throws Exception {

    return goodsMovementDaoOf(userContext).disconnectFromAll(goodsMovementId, goodsMovementVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new GoodsMovementManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsMovement newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    goodsMovementDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   GoodsMovement newGoodsMovement = this.createGoodsMovement(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newGoodsMovement
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
    key.put(UserApp.APP_TYPE_PROPERTY, GoodsMovement.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<GoodsMovement> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<Goods> goodsList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Goods.class);
    userContext.getDAOGroup().enhanceList(goodsList, Goods.class);
  }

  public Object listByGoods(RetailscmUserContext userContext, String goodsId) throws Exception {
    return listPageByGoods(userContext, goodsId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByGoods(
      RetailscmUserContext userContext, String goodsId, int start, int count) throws Exception {
    SmartList<GoodsMovement> list =
        goodsMovementDaoOf(userContext)
            .findGoodsMovementByGoods(goodsId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(GoodsMovement.class);
    page.setContainerObject(Goods.withId(goodsId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("货物移动列表");
    page.setRequestName("listByGoods");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByGoods/%s/", getBeanName(), goodsId)));

    page.assemblerContent(userContext, "listByGoods");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String goodsMovementId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    GoodsMovement merchantObj = (GoodsMovement) this.view(userContext, goodsMovementId);
    String merchantObjId = goodsMovementId;
    String linkToUrl = "goodsMovementManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "货物移动" + "详情";
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
        MapUtil.put("id", "2-moveTime")
            .put("fieldName", "moveTime")
            .put("label", "移动时间")
            .put("type", "datetime")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("moveTime", merchantObj.getMoveTime());

    propList.add(
        MapUtil.put("id", "3-facility")
            .put("fieldName", "facility")
            .put("label", "设施")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("facility", merchantObj.getFacility());

    propList.add(
        MapUtil.put("id", "4-facilityId")
            .put("fieldName", "facilityId")
            .put("label", "设备ID")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("facilityId", merchantObj.getFacilityId());

    propList.add(
        MapUtil.put("id", "5-fromIp")
            .put("fieldName", "fromIp")
            .put("label", "从IP")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("fromIp", merchantObj.getFromIp());

    propList.add(
        MapUtil.put("id", "6-userAgent")
            .put("fieldName", "userAgent")
            .put("label", "用户代理")
            .put("type", "longtext")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("userAgent", merchantObj.getUserAgent());

    propList.add(
        MapUtil.put("id", "7-sessionId")
            .put("fieldName", "sessionId")
            .put("label", "会话ID")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("sessionId", merchantObj.getSessionId());

    propList.add(
        MapUtil.put("id", "8-latitude")
            .put("fieldName", "latitude")
            .put("label", "纬度")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("latitude", merchantObj.getLatitude());

    propList.add(
        MapUtil.put("id", "9-longitude")
            .put("fieldName", "longitude")
            .put("label", "经度")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("longitude", merchantObj.getLongitude());

    propList.add(
        MapUtil.put("id", "10-goods")
            .put("fieldName", "goods")
            .put("label", "货物")
            .put("type", "auto")
            .put("linkToUrl", "goodsManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"max_package\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("goods", merchantObj.getGoods());

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
