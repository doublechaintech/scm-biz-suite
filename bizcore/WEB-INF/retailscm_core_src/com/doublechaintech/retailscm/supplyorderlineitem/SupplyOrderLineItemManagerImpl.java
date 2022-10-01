package com.doublechaintech.retailscm.supplyorderlineitem;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.supplyorder.CandidateSupplyOrder;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
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

public class SupplyOrderLineItemManagerImpl extends CustomRetailscmCheckerManager
    implements SupplyOrderLineItemManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "SupplyOrderLineItem";

  @Override
  public SupplyOrderLineItemDAO daoOf(RetailscmUserContext userContext) {
    return supplyOrderLineItemDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws SupplyOrderLineItemManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new SupplyOrderLineItemManagerException(message);
  }

  protected SupplyOrderLineItem saveSupplyOrderLineItem(
      RetailscmUserContext userContext,
      SupplyOrderLineItem supplyOrderLineItem,
      String[] tokensExpr)
      throws Exception {
    // return getSupplyOrderLineItemDAO().save(supplyOrderLineItem, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens);
  }

  protected SupplyOrderLineItem saveSupplyOrderLineItemDetail(
      RetailscmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem) throws Exception {

    return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, allTokens());
  }

  public SupplyOrderLineItem loadSupplyOrderLineItem(
      RetailscmUserContext userContext, String supplyOrderLineItemId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);

    checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderLineItemManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    SupplyOrderLineItem supplyOrderLineItem =
        loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, tokens);
    // do some calc before sent to customer?
    return present(userContext, supplyOrderLineItem, tokens);
  }

  public SupplyOrderLineItem searchSupplyOrderLineItem(
      RetailscmUserContext userContext,
      String supplyOrderLineItemId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);

    checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderLineItemManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    SupplyOrderLineItem supplyOrderLineItem =
        loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, tokens);
    // do some calc before sent to customer?
    return present(userContext, supplyOrderLineItem, tokens);
  }

  protected SupplyOrderLineItem present(
      RetailscmUserContext userContext,
      SupplyOrderLineItem supplyOrderLineItem,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, supplyOrderLineItem, tokens);

    SupplyOrderLineItem supplyOrderLineItemToPresent =
        supplyOrderLineItemDaoOf(userContext).present(supplyOrderLineItem, tokens);

    List<BaseEntity> entityListToNaming = supplyOrderLineItemToPresent.collectReferencesFromLists();
    supplyOrderLineItemDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, supplyOrderLineItem, tokens);

    return supplyOrderLineItemToPresent;
  }

  public SupplyOrderLineItem loadSupplyOrderLineItemDetail(
      RetailscmUserContext userContext, String supplyOrderLineItemId) throws Exception {
    SupplyOrderLineItem supplyOrderLineItem =
        loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, allTokens());
    return present(userContext, supplyOrderLineItem, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String supplyOrderLineItemId)
      throws Exception {
    SupplyOrderLineItem supplyOrderLineItem =
        loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, viewTokens());
    markVisited(userContext, supplyOrderLineItem);
    return present(userContext, supplyOrderLineItem, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String supplyOrderLineItemId)
      throws Exception {
    SupplyOrderLineItem supplyOrderLineItem =
        loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, viewTokens());
    supplyOrderLineItem.summarySuffix();
    markVisited(userContext, supplyOrderLineItem);
    return present(userContext, supplyOrderLineItem, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String supplyOrderLineItemId)
      throws Exception {
    SupplyOrderLineItem supplyOrderLineItem =
        loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, analyzeTokens());
    markVisited(userContext, supplyOrderLineItem);
    return present(userContext, supplyOrderLineItem, analyzeTokens());
  }

  protected SupplyOrderLineItem saveSupplyOrderLineItem(
      RetailscmUserContext userContext,
      SupplyOrderLineItem supplyOrderLineItem,
      Map<String, Object> tokens)
      throws Exception {

    return supplyOrderLineItemDaoOf(userContext).save(supplyOrderLineItem, tokens);
  }

  protected SupplyOrderLineItem loadSupplyOrderLineItem(
      RetailscmUserContext userContext, String supplyOrderLineItemId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);

    checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderLineItemManagerException.class);

    return supplyOrderLineItemDaoOf(userContext).load(supplyOrderLineItemId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      SupplyOrderLineItem supplyOrderLineItem,
      Map<String, Object> tokens) {
    super.addActions(userContext, supplyOrderLineItem, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> tokens){

  @Override
  public List<SupplyOrderLineItem> searchSupplyOrderLineItemList(
      RetailscmUserContext ctx, SupplyOrderLineItemRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<SupplyOrderLineItem> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public SupplyOrderLineItem searchSupplyOrderLineItem(
      RetailscmUserContext ctx, SupplyOrderLineItemRequest pRequest) {
    pRequest.limit(0, 1);
    List<SupplyOrderLineItem> list = searchSupplyOrderLineItemList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public SupplyOrderLineItem createSupplyOrderLineItem(
      RetailscmUserContext userContext,
      String bizOrderId,
      String skuId,
      String skuName,
      BigDecimal amount,
      int quantity,
      String unitOfMeasurement)
      throws Exception {

    checkerOf(userContext).checkSkuIdOfSupplyOrderLineItem(skuId);
    checkerOf(userContext).checkSkuNameOfSupplyOrderLineItem(skuName);
    checkerOf(userContext).checkAmountOfSupplyOrderLineItem(amount);
    checkerOf(userContext).checkQuantityOfSupplyOrderLineItem(quantity);
    checkerOf(userContext).checkUnitOfMeasurementOfSupplyOrderLineItem(unitOfMeasurement);

    checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderLineItemManagerException.class);

    SupplyOrderLineItem supplyOrderLineItem = createNewSupplyOrderLineItem();

    SupplyOrder bizOrder = loadSupplyOrder(userContext, bizOrderId, emptyOptions());
    supplyOrderLineItem.setBizOrder(bizOrder);

    supplyOrderLineItem.setSkuId(skuId);
    supplyOrderLineItem.setSkuName(skuName);
    supplyOrderLineItem.setAmount(amount);
    supplyOrderLineItem.setQuantity(quantity);
    supplyOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);

    supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, emptyOptions());

    onNewInstanceCreated(userContext, supplyOrderLineItem);
    return supplyOrderLineItem;
  }

  protected SupplyOrderLineItem createNewSupplyOrderLineItem() {

    return new SupplyOrderLineItem();
  }

  protected void checkParamsForUpdatingSupplyOrderLineItem(
      RetailscmUserContext userContext,
      String supplyOrderLineItemId,
      int supplyOrderLineItemVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
    checkerOf(userContext).checkVersionOfSupplyOrderLineItem(supplyOrderLineItemVersion);

    if (SupplyOrderLineItem.SKU_ID_PROPERTY.equals(property)) {

      checkerOf(userContext).checkSkuIdOfSupplyOrderLineItem(parseString(newValueExpr));
    }
    if (SupplyOrderLineItem.SKU_NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkSkuNameOfSupplyOrderLineItem(parseString(newValueExpr));
    }
    if (SupplyOrderLineItem.AMOUNT_PROPERTY.equals(property)) {

      checkerOf(userContext).checkAmountOfSupplyOrderLineItem(parseBigDecimal(newValueExpr));
    }
    if (SupplyOrderLineItem.QUANTITY_PROPERTY.equals(property)) {

      checkerOf(userContext).checkQuantityOfSupplyOrderLineItem(parseInt(newValueExpr));
    }
    if (SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY.equals(property)) {

      checkerOf(userContext).checkUnitOfMeasurementOfSupplyOrderLineItem(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderLineItemManagerException.class);
  }

  public SupplyOrderLineItem clone(
      RetailscmUserContext userContext, String fromSupplyOrderLineItemId) throws Exception {

    return supplyOrderLineItemDaoOf(userContext).clone(fromSupplyOrderLineItemId, this.allTokens());
  }

  public SupplyOrderLineItem internalSaveSupplyOrderLineItem(
      RetailscmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem) throws Exception {
    return internalSaveSupplyOrderLineItem(userContext, supplyOrderLineItem, allTokens());
  }

  public SupplyOrderLineItem internalSaveSupplyOrderLineItem(
      RetailscmUserContext userContext,
      SupplyOrderLineItem supplyOrderLineItem,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingSupplyOrderLineItem(userContext, supplyOrderLineItemId,
    // supplyOrderLineItemVersion, property, newValueExpr, tokensExpr);

    synchronized (supplyOrderLineItem) {
      // will be good when the supplyOrderLineItem loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to SupplyOrderLineItem.
      if (supplyOrderLineItem.isChanged()) {}

      // checkerOf(userContext).checkAndFixSupplyOrderLineItem(supplyOrderLineItem);
      supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, options);
      return supplyOrderLineItem;
    }
  }

  public SupplyOrderLineItem updateSupplyOrderLineItem(
      RetailscmUserContext userContext,
      String supplyOrderLineItemId,
      int supplyOrderLineItemVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingSupplyOrderLineItem(
        userContext,
        supplyOrderLineItemId,
        supplyOrderLineItemVersion,
        property,
        newValueExpr,
        tokensExpr);

    SupplyOrderLineItem supplyOrderLineItem =
        loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, allTokens());
    if (supplyOrderLineItem.getVersion() != supplyOrderLineItemVersion) {
      String message =
          "The target version("
              + supplyOrderLineItem.getVersion()
              + ") is not equals to version("
              + supplyOrderLineItemVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (supplyOrderLineItem) {
      // will be good when the supplyOrderLineItem loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to SupplyOrderLineItem.

      supplyOrderLineItem.changeProperty(property, newValueExpr);
      supplyOrderLineItem =
          saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
      return present(userContext, supplyOrderLineItem, mergedAllTokens(tokensExpr));
      // return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
    }
  }

  public SupplyOrderLineItem updateSupplyOrderLineItemProperty(
      RetailscmUserContext userContext,
      String supplyOrderLineItemId,
      int supplyOrderLineItemVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingSupplyOrderLineItem(
        userContext,
        supplyOrderLineItemId,
        supplyOrderLineItemVersion,
        property,
        newValueExpr,
        tokensExpr);

    SupplyOrderLineItem supplyOrderLineItem =
        loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, allTokens());
    if (supplyOrderLineItem.getVersion() != supplyOrderLineItemVersion) {
      String message =
          "The target version("
              + supplyOrderLineItem.getVersion()
              + ") is not equals to version("
              + supplyOrderLineItemVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (supplyOrderLineItem) {
      // will be good when the supplyOrderLineItem loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to SupplyOrderLineItem.

      supplyOrderLineItem.changeProperty(property, newValueExpr);

      supplyOrderLineItem =
          saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
      return present(userContext, supplyOrderLineItem, mergedAllTokens(tokensExpr));
      // return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected SupplyOrderLineItemTokens tokens() {
    return SupplyOrderLineItemTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return SupplyOrderLineItemTokens.all();
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
    return SupplyOrderLineItemTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherBizOrder(
      RetailscmUserContext userContext, String supplyOrderLineItemId, String anotherBizOrderId)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
    checkerOf(userContext).checkIdOfSupplyOrder(anotherBizOrderId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderLineItemManagerException.class);
  }

  public SupplyOrderLineItem transferToAnotherBizOrder(
      RetailscmUserContext userContext, String supplyOrderLineItemId, String anotherBizOrderId)
      throws Exception {
    checkParamsForTransferingAnotherBizOrder(userContext, supplyOrderLineItemId, anotherBizOrderId);

    SupplyOrderLineItem supplyOrderLineItem =
        loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, allTokens());
    synchronized (supplyOrderLineItem) {
      // will be good when the supplyOrderLineItem loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      SupplyOrder bizOrder = loadSupplyOrder(userContext, anotherBizOrderId, emptyOptions());
      supplyOrderLineItem.updateBizOrder(bizOrder);

      supplyOrderLineItem =
          saveSupplyOrderLineItem(userContext, supplyOrderLineItem, emptyOptions());

      return present(userContext, supplyOrderLineItem, allTokens());
    }
  }

  public CandidateSupplyOrder requestCandidateBizOrder(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateSupplyOrder result = new CandidateSupplyOrder();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("buyer");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<SupplyOrder> candidateList =
        supplyOrderDaoOf(userContext)
            .requestCandidateSupplyOrderForSupplyOrderLineItem(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected SupplyOrder loadSupplyOrder(
      RetailscmUserContext userContext, String newBizOrderId, Map<String, Object> options)
      throws Exception {

    return supplyOrderDaoOf(userContext).load(newBizOrderId, options);
  }

  // --------------------------------------------------------------

  public SupplyOrderLineItem forgetByAll(
      RetailscmUserContext userContext,
      String supplyOrderLineItemId,
      int supplyOrderLineItemVersion)
      throws Exception {
    return forgetByAllInternal(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion);
  }

  protected SupplyOrderLineItem forgetByAllInternal(
      RetailscmUserContext userContext,
      String supplyOrderLineItemId,
      int supplyOrderLineItemVersion)
      throws Exception {

    return supplyOrderLineItemDaoOf(userContext)
        .disconnectFromAll(supplyOrderLineItemId, supplyOrderLineItemVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new SupplyOrderLineItemManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderLineItem newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    supplyOrderLineItemDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   SupplyOrderLineItem newSupplyOrderLineItem = this.createSupplyOrderLineItem(userContext,
    // ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newSupplyOrderLineItem
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
    key.put(UserApp.APP_TYPE_PROPERTY, SupplyOrderLineItem.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<SupplyOrderLineItem> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<SupplyOrder> bizOrderList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrder.class);
    userContext.getDAOGroup().enhanceList(bizOrderList, SupplyOrder.class);
  }

  public Object listByBizOrder(RetailscmUserContext userContext, String bizOrderId)
      throws Exception {
    return listPageByBizOrder(userContext, bizOrderId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByBizOrder(
      RetailscmUserContext userContext, String bizOrderId, int start, int count) throws Exception {
    SmartList<SupplyOrderLineItem> list =
        supplyOrderLineItemDaoOf(userContext)
            .findSupplyOrderLineItemByBizOrder(bizOrderId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(SupplyOrderLineItem.class);
    page.setContainerObject(SupplyOrder.withId(bizOrderId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("供应订单行项目列表");
    page.setRequestName("listByBizOrder");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByBizOrder/%s/", getBeanName(), bizOrderId)));

    page.assemblerContent(userContext, "listByBizOrder");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String supplyOrderLineItemId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    SupplyOrderLineItem merchantObj =
        (SupplyOrderLineItem) this.view(userContext, supplyOrderLineItemId);
    String merchantObjId = supplyOrderLineItemId;
    String linkToUrl = "supplyOrderLineItemManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "供应订单行项目" + "详情";
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
        MapUtil.put("id", "2-bizOrder")
            .put("fieldName", "bizOrder")
            .put("label", "订单")
            .put("type", "document")
            .put("linkToUrl", "supplyOrderManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"total_amount\",\"imageUrl\":\"\",\"name\":\"document\",\"title\":\"title\",\"imageList\":\"\"}")
            .into_map());
    result.put("bizOrder", merchantObj.getBizOrder());

    propList.add(
        MapUtil.put("id", "3-skuId")
            .put("fieldName", "skuId")
            .put("label", "产品ID")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("skuId", merchantObj.getSkuId());

    propList.add(
        MapUtil.put("id", "4-skuName")
            .put("fieldName", "skuName")
            .put("label", "产品名称")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("skuName", merchantObj.getSkuName());

    propList.add(
        MapUtil.put("id", "5-amount")
            .put("fieldName", "amount")
            .put("label", "金额")
            .put("type", "money")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("amount", merchantObj.getAmount());

    propList.add(
        MapUtil.put("id", "6-quantity")
            .put("fieldName", "quantity")
            .put("label", "数量")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("quantity", merchantObj.getQuantity());

    propList.add(
        MapUtil.put("id", "7-unitOfMeasurement")
            .put("fieldName", "unitOfMeasurement")
            .put("label", "测量单位")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("unitOfMeasurement", merchantObj.getUnitOfMeasurement());

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
