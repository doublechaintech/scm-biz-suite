package com.doublechaintech.retailscm.warehouseasset;

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
import com.doublechaintech.retailscm.warehouse.CandidateWarehouse;
import com.doublechaintech.retailscm.warehouse.Warehouse;
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

public class WarehouseAssetManagerImpl extends CustomRetailscmCheckerManager
    implements WarehouseAssetManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "WarehouseAsset";

  @Override
  public WarehouseAssetDAO daoOf(RetailscmUserContext userContext) {
    return warehouseAssetDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws WarehouseAssetManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new WarehouseAssetManagerException(message);
  }

  protected WarehouseAsset saveWarehouseAsset(
      RetailscmUserContext userContext, WarehouseAsset warehouseAsset, String[] tokensExpr)
      throws Exception {
    // return getWarehouseAssetDAO().save(warehouseAsset, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveWarehouseAsset(userContext, warehouseAsset, tokens);
  }

  protected WarehouseAsset saveWarehouseAssetDetail(
      RetailscmUserContext userContext, WarehouseAsset warehouseAsset) throws Exception {

    return saveWarehouseAsset(userContext, warehouseAsset, allTokens());
  }

  public WarehouseAsset loadWarehouseAsset(
      RetailscmUserContext userContext, String warehouseAssetId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfWarehouseAsset(warehouseAssetId);

    checkerOf(userContext).throwExceptionIfHasErrors(WarehouseAssetManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, tokens);
    // do some calc before sent to customer?
    return present(userContext, warehouseAsset, tokens);
  }

  public WarehouseAsset searchWarehouseAsset(
      RetailscmUserContext userContext,
      String warehouseAssetId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfWarehouseAsset(warehouseAssetId);

    checkerOf(userContext).throwExceptionIfHasErrors(WarehouseAssetManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, tokens);
    // do some calc before sent to customer?
    return present(userContext, warehouseAsset, tokens);
  }

  protected WarehouseAsset present(
      RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, warehouseAsset, tokens);

    WarehouseAsset warehouseAssetToPresent =
        warehouseAssetDaoOf(userContext).present(warehouseAsset, tokens);

    List<BaseEntity> entityListToNaming = warehouseAssetToPresent.collectReferencesFromLists();
    warehouseAssetDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, warehouseAsset, tokens);

    return warehouseAssetToPresent;
  }

  public WarehouseAsset loadWarehouseAssetDetail(
      RetailscmUserContext userContext, String warehouseAssetId) throws Exception {
    WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, allTokens());
    return present(userContext, warehouseAsset, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String warehouseAssetId) throws Exception {
    WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, viewTokens());
    markVisited(userContext, warehouseAsset);
    return present(userContext, warehouseAsset, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String warehouseAssetId)
      throws Exception {
    WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, viewTokens());
    warehouseAsset.summarySuffix();
    markVisited(userContext, warehouseAsset);
    return present(userContext, warehouseAsset, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String warehouseAssetId)
      throws Exception {
    WarehouseAsset warehouseAsset =
        loadWarehouseAsset(userContext, warehouseAssetId, analyzeTokens());
    markVisited(userContext, warehouseAsset);
    return present(userContext, warehouseAsset, analyzeTokens());
  }

  protected WarehouseAsset saveWarehouseAsset(
      RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens)
      throws Exception {

    return warehouseAssetDaoOf(userContext).save(warehouseAsset, tokens);
  }

  protected WarehouseAsset loadWarehouseAsset(
      RetailscmUserContext userContext, String warehouseAssetId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfWarehouseAsset(warehouseAssetId);

    checkerOf(userContext).throwExceptionIfHasErrors(WarehouseAssetManagerException.class);

    return warehouseAssetDaoOf(userContext).load(warehouseAssetId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens) {
    super.addActions(userContext, warehouseAsset, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens){

  @Override
  public List<WarehouseAsset> searchWarehouseAssetList(
      RetailscmUserContext ctx, WarehouseAssetRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<WarehouseAsset> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public WarehouseAsset searchWarehouseAsset(
      RetailscmUserContext ctx, WarehouseAssetRequest pRequest) {
    pRequest.limit(0, 1);
    List<WarehouseAsset> list = searchWarehouseAssetList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public WarehouseAsset createWarehouseAsset(
      RetailscmUserContext userContext, String name, String position, String ownerId)
      throws Exception {

    checkerOf(userContext).checkNameOfWarehouseAsset(name);
    checkerOf(userContext).checkPositionOfWarehouseAsset(position);

    checkerOf(userContext).throwExceptionIfHasErrors(WarehouseAssetManagerException.class);

    WarehouseAsset warehouseAsset = createNewWarehouseAsset();

    warehouseAsset.setName(name);
    warehouseAsset.setPosition(position);

    Warehouse owner = loadWarehouse(userContext, ownerId, emptyOptions());
    warehouseAsset.setOwner(owner);

    warehouseAsset.setLastUpdateTime(userContext.now());

    warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, emptyOptions());

    onNewInstanceCreated(userContext, warehouseAsset);
    return warehouseAsset;
  }

  protected WarehouseAsset createNewWarehouseAsset() {

    return new WarehouseAsset();
  }

  protected void checkParamsForUpdatingWarehouseAsset(
      RetailscmUserContext userContext,
      String warehouseAssetId,
      int warehouseAssetVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfWarehouseAsset(warehouseAssetId);
    checkerOf(userContext).checkVersionOfWarehouseAsset(warehouseAssetVersion);

    if (WarehouseAsset.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfWarehouseAsset(parseString(newValueExpr));
    }
    if (WarehouseAsset.POSITION_PROPERTY.equals(property)) {

      checkerOf(userContext).checkPositionOfWarehouseAsset(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(WarehouseAssetManagerException.class);
  }

  public WarehouseAsset clone(RetailscmUserContext userContext, String fromWarehouseAssetId)
      throws Exception {

    return warehouseAssetDaoOf(userContext).clone(fromWarehouseAssetId, this.allTokens());
  }

  public WarehouseAsset internalSaveWarehouseAsset(
      RetailscmUserContext userContext, WarehouseAsset warehouseAsset) throws Exception {
    return internalSaveWarehouseAsset(userContext, warehouseAsset, allTokens());
  }

  public WarehouseAsset internalSaveWarehouseAsset(
      RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingWarehouseAsset(userContext, warehouseAssetId, warehouseAssetVersion,
    // property, newValueExpr, tokensExpr);

    synchronized (warehouseAsset) {
      // will be good when the warehouseAsset loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to WarehouseAsset.
      if (warehouseAsset.isChanged()) {
        warehouseAsset.updateLastUpdateTime(userContext.now());
      }

      // checkerOf(userContext).checkAndFixWarehouseAsset(warehouseAsset);
      warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, options);
      return warehouseAsset;
    }
  }

  public WarehouseAsset updateWarehouseAsset(
      RetailscmUserContext userContext,
      String warehouseAssetId,
      int warehouseAssetVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingWarehouseAsset(
        userContext, warehouseAssetId, warehouseAssetVersion, property, newValueExpr, tokensExpr);

    WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, allTokens());
    if (warehouseAsset.getVersion() != warehouseAssetVersion) {
      String message =
          "The target version("
              + warehouseAsset.getVersion()
              + ") is not equals to version("
              + warehouseAssetVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (warehouseAsset) {
      // will be good when the warehouseAsset loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to WarehouseAsset.
      warehouseAsset.updateLastUpdateTime(userContext.now());
      warehouseAsset.changeProperty(property, newValueExpr);
      warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
      return present(userContext, warehouseAsset, mergedAllTokens(tokensExpr));
      // return saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
    }
  }

  public WarehouseAsset updateWarehouseAssetProperty(
      RetailscmUserContext userContext,
      String warehouseAssetId,
      int warehouseAssetVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingWarehouseAsset(
        userContext, warehouseAssetId, warehouseAssetVersion, property, newValueExpr, tokensExpr);

    WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, allTokens());
    if (warehouseAsset.getVersion() != warehouseAssetVersion) {
      String message =
          "The target version("
              + warehouseAsset.getVersion()
              + ") is not equals to version("
              + warehouseAssetVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (warehouseAsset) {
      // will be good when the warehouseAsset loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to WarehouseAsset.

      warehouseAsset.changeProperty(property, newValueExpr);
      warehouseAsset.updateLastUpdateTime(userContext.now());
      warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
      return present(userContext, warehouseAsset, mergedAllTokens(tokensExpr));
      // return saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected WarehouseAssetTokens tokens() {
    return WarehouseAssetTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return WarehouseAssetTokens.all();
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
    return WarehouseAssetTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherOwner(
      RetailscmUserContext userContext, String warehouseAssetId, String anotherOwnerId)
      throws Exception {

    checkerOf(userContext).checkIdOfWarehouseAsset(warehouseAssetId);
    checkerOf(userContext).checkIdOfWarehouse(anotherOwnerId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(WarehouseAssetManagerException.class);
  }

  public WarehouseAsset transferToAnotherOwner(
      RetailscmUserContext userContext, String warehouseAssetId, String anotherOwnerId)
      throws Exception {
    checkParamsForTransferingAnotherOwner(userContext, warehouseAssetId, anotherOwnerId);

    WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, allTokens());
    synchronized (warehouseAsset) {
      // will be good when the warehouseAsset loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      Warehouse owner = loadWarehouse(userContext, anotherOwnerId, emptyOptions());
      warehouseAsset.updateOwner(owner);
      warehouseAsset.updateLastUpdateTime(userContext.now());
      warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, emptyOptions());

      return present(userContext, warehouseAsset, allTokens());
    }
  }

  public CandidateWarehouse requestCandidateOwner(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateWarehouse result = new CandidateWarehouse();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("location");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<Warehouse> candidateList =
        warehouseDaoOf(userContext)
            .requestCandidateWarehouseForWarehouseAsset(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected Warehouse loadWarehouse(
      RetailscmUserContext userContext, String newOwnerId, Map<String, Object> options)
      throws Exception {

    return warehouseDaoOf(userContext).load(newOwnerId, options);
  }

  // --------------------------------------------------------------

  public WarehouseAsset forgetByAll(
      RetailscmUserContext userContext, String warehouseAssetId, int warehouseAssetVersion)
      throws Exception {
    return forgetByAllInternal(userContext, warehouseAssetId, warehouseAssetVersion);
  }

  protected WarehouseAsset forgetByAllInternal(
      RetailscmUserContext userContext, String warehouseAssetId, int warehouseAssetVersion)
      throws Exception {

    return warehouseAssetDaoOf(userContext)
        .disconnectFromAll(warehouseAssetId, warehouseAssetVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new WarehouseAssetManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(RetailscmUserContext userContext, WarehouseAsset newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    warehouseAssetDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   WarehouseAsset newWarehouseAsset = this.createWarehouseAsset(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newWarehouseAsset
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
    key.put(UserApp.APP_TYPE_PROPERTY, WarehouseAsset.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<WarehouseAsset> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<Warehouse> ownerList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Warehouse.class);
    userContext.getDAOGroup().enhanceList(ownerList, Warehouse.class);
  }

  public Object listByOwner(RetailscmUserContext userContext, String ownerId) throws Exception {
    return listPageByOwner(userContext, ownerId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByOwner(
      RetailscmUserContext userContext, String ownerId, int start, int count) throws Exception {
    SmartList<WarehouseAsset> list =
        warehouseAssetDaoOf(userContext)
            .findWarehouseAssetByOwner(ownerId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(WarehouseAsset.class);
    page.setContainerObject(Warehouse.withId(ownerId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("仓库资产列表");
    page.setRequestName("listByOwner");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByOwner/%s/", getBeanName(), ownerId)));

    page.assemblerContent(userContext, "listByOwner");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String warehouseAssetId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    WarehouseAsset merchantObj = (WarehouseAsset) this.view(userContext, warehouseAssetId);
    String merchantObjId = warehouseAssetId;
    String linkToUrl = "warehouseAssetManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "仓库资产" + "详情";
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
        MapUtil.put("id", "3-position")
            .put("fieldName", "position")
            .put("label", "位置")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("position", merchantObj.getPosition());

    propList.add(
        MapUtil.put("id", "4-owner")
            .put("fieldName", "owner")
            .put("label", "业主")
            .put("type", "document")
            .put("linkToUrl", "warehouseManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"document\",\"title\":\"location\",\"imageList\":\"\"}")
            .into_map());
    result.put("owner", merchantObj.getOwner());

    propList.add(
        MapUtil.put("id", "5-lastUpdateTime")
            .put("fieldName", "lastUpdateTime")
            .put("label", "更新于")
            .put("type", "datetime")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

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
