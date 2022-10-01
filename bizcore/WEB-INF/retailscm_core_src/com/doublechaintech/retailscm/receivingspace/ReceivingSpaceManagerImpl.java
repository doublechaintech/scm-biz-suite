package com.doublechaintech.retailscm.receivingspace;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.transporttask.TransportTask;
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

public class ReceivingSpaceManagerImpl extends CustomRetailscmCheckerManager
    implements ReceivingSpaceManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        ReceivingSpaceTokens.start().withTokenFromListName(listName).done();
    ReceivingSpace receivingSpace =
        (ReceivingSpace) this.loadReceivingSpace(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = receivingSpace.collectReferencesFromLists();
    receivingSpaceDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, receivingSpace, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new ReceivingSpaceGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "ReceivingSpace";

  @Override
  public ReceivingSpaceDAO daoOf(RetailscmUserContext userContext) {
    return receivingSpaceDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws ReceivingSpaceManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new ReceivingSpaceManagerException(message);
  }

  protected ReceivingSpace saveReceivingSpace(
      RetailscmUserContext userContext, ReceivingSpace receivingSpace, String[] tokensExpr)
      throws Exception {
    // return getReceivingSpaceDAO().save(receivingSpace, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveReceivingSpace(userContext, receivingSpace, tokens);
  }

  protected ReceivingSpace saveReceivingSpaceDetail(
      RetailscmUserContext userContext, ReceivingSpace receivingSpace) throws Exception {

    return saveReceivingSpace(userContext, receivingSpace, allTokens());
  }

  public ReceivingSpace loadReceivingSpace(
      RetailscmUserContext userContext, String receivingSpaceId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfReceivingSpace(receivingSpaceId);

    checkerOf(userContext).throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, tokens);
    // do some calc before sent to customer?
    return present(userContext, receivingSpace, tokens);
  }

  public ReceivingSpace searchReceivingSpace(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfReceivingSpace(receivingSpaceId);

    checkerOf(userContext).throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, tokens);
    // do some calc before sent to customer?
    return present(userContext, receivingSpace, tokens);
  }

  protected ReceivingSpace present(
      RetailscmUserContext userContext, ReceivingSpace receivingSpace, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, receivingSpace, tokens);

    ReceivingSpace receivingSpaceToPresent =
        receivingSpaceDaoOf(userContext).present(receivingSpace, tokens);

    List<BaseEntity> entityListToNaming = receivingSpaceToPresent.collectReferencesFromLists();
    receivingSpaceDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, receivingSpace, tokens);

    return receivingSpaceToPresent;
  }

  public ReceivingSpace loadReceivingSpaceDetail(
      RetailscmUserContext userContext, String receivingSpaceId) throws Exception {
    ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
    return present(userContext, receivingSpace, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String receivingSpaceId) throws Exception {
    ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, viewTokens());
    markVisited(userContext, receivingSpace);
    return present(userContext, receivingSpace, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String receivingSpaceId)
      throws Exception {
    ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, viewTokens());
    receivingSpace.summarySuffix();
    markVisited(userContext, receivingSpace);
    return present(userContext, receivingSpace, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String receivingSpaceId)
      throws Exception {
    ReceivingSpace receivingSpace =
        loadReceivingSpace(userContext, receivingSpaceId, analyzeTokens());
    markVisited(userContext, receivingSpace);
    return present(userContext, receivingSpace, analyzeTokens());
  }

  protected ReceivingSpace saveReceivingSpace(
      RetailscmUserContext userContext, ReceivingSpace receivingSpace, Map<String, Object> tokens)
      throws Exception {

    return receivingSpaceDaoOf(userContext).save(receivingSpace, tokens);
  }

  protected ReceivingSpace loadReceivingSpace(
      RetailscmUserContext userContext, String receivingSpaceId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfReceivingSpace(receivingSpaceId);

    checkerOf(userContext).throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);

    return receivingSpaceDaoOf(userContext).load(receivingSpaceId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, ReceivingSpace receivingSpace, Map<String, Object> tokens) {
    super.addActions(userContext, receivingSpace, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, ReceivingSpace receivingSpace, Map<String, Object> tokens){

  @Override
  public List<ReceivingSpace> searchReceivingSpaceList(
      RetailscmUserContext ctx, ReceivingSpaceRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<ReceivingSpace> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public ReceivingSpace searchReceivingSpace(
      RetailscmUserContext ctx, ReceivingSpaceRequest pRequest) {
    pRequest.limit(0, 1);
    List<ReceivingSpace> list = searchReceivingSpaceList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public ReceivingSpace createReceivingSpace(
      RetailscmUserContext userContext,
      String location,
      String contactNumber,
      String description,
      String totalArea,
      String warehouseId,
      BigDecimal latitude,
      BigDecimal longitude)
      throws Exception {

    checkerOf(userContext).checkLocationOfReceivingSpace(location);
    checkerOf(userContext).checkContactNumberOfReceivingSpace(contactNumber);
    checkerOf(userContext).checkDescriptionOfReceivingSpace(description);
    checkerOf(userContext).checkTotalAreaOfReceivingSpace(totalArea);
    checkerOf(userContext).checkLatitudeOfReceivingSpace(latitude);
    checkerOf(userContext).checkLongitudeOfReceivingSpace(longitude);

    checkerOf(userContext).throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);

    ReceivingSpace receivingSpace = createNewReceivingSpace();

    receivingSpace.setLocation(location);
    receivingSpace.setContactNumber(contactNumber);
    receivingSpace.setDescription(description);
    receivingSpace.setTotalArea(totalArea);

    Warehouse warehouse = loadWarehouse(userContext, warehouseId, emptyOptions());
    receivingSpace.setWarehouse(warehouse);

    receivingSpace.setLatitude(latitude);
    receivingSpace.setLongitude(longitude);
    receivingSpace.setLastUpdateTime(userContext.now());

    receivingSpace = saveReceivingSpace(userContext, receivingSpace, emptyOptions());

    onNewInstanceCreated(userContext, receivingSpace);
    return receivingSpace;
  }

  protected ReceivingSpace createNewReceivingSpace() {

    return new ReceivingSpace();
  }

  protected void checkParamsForUpdatingReceivingSpace(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      int receivingSpaceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfReceivingSpace(receivingSpaceId);
    checkerOf(userContext).checkVersionOfReceivingSpace(receivingSpaceVersion);

    if (ReceivingSpace.LOCATION_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLocationOfReceivingSpace(parseString(newValueExpr));
    }
    if (ReceivingSpace.CONTACT_NUMBER_PROPERTY.equals(property)) {

      checkerOf(userContext).checkContactNumberOfReceivingSpace(parseString(newValueExpr));
    }
    if (ReceivingSpace.DESCRIPTION_PROPERTY.equals(property)) {

      checkerOf(userContext).checkDescriptionOfReceivingSpace(parseString(newValueExpr));
    }
    if (ReceivingSpace.TOTAL_AREA_PROPERTY.equals(property)) {

      checkerOf(userContext).checkTotalAreaOfReceivingSpace(parseString(newValueExpr));
    }

    if (ReceivingSpace.LATITUDE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLatitudeOfReceivingSpace(parseBigDecimal(newValueExpr));
    }
    if (ReceivingSpace.LONGITUDE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLongitudeOfReceivingSpace(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
  }

  public ReceivingSpace clone(RetailscmUserContext userContext, String fromReceivingSpaceId)
      throws Exception {

    return receivingSpaceDaoOf(userContext).clone(fromReceivingSpaceId, this.allTokens());
  }

  public ReceivingSpace internalSaveReceivingSpace(
      RetailscmUserContext userContext, ReceivingSpace receivingSpace) throws Exception {
    return internalSaveReceivingSpace(userContext, receivingSpace, allTokens());
  }

  public ReceivingSpace internalSaveReceivingSpace(
      RetailscmUserContext userContext, ReceivingSpace receivingSpace, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingReceivingSpace(userContext, receivingSpaceId, receivingSpaceVersion,
    // property, newValueExpr, tokensExpr);

    synchronized (receivingSpace) {
      // will be good when the receivingSpace loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ReceivingSpace.
      if (receivingSpace.isChanged()) {
        receivingSpace.updateLastUpdateTime(userContext.now());
      }

      // checkerOf(userContext).checkAndFixReceivingSpace(receivingSpace);
      receivingSpace = saveReceivingSpace(userContext, receivingSpace, options);
      return receivingSpace;
    }
  }

  public ReceivingSpace updateReceivingSpace(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      int receivingSpaceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingReceivingSpace(
        userContext, receivingSpaceId, receivingSpaceVersion, property, newValueExpr, tokensExpr);

    ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
    if (receivingSpace.getVersion() != receivingSpaceVersion) {
      String message =
          "The target version("
              + receivingSpace.getVersion()
              + ") is not equals to version("
              + receivingSpaceVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (receivingSpace) {
      // will be good when the receivingSpace loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ReceivingSpace.
      receivingSpace.updateLastUpdateTime(userContext.now());
      receivingSpace.changeProperty(property, newValueExpr);
      receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().done());
      return present(userContext, receivingSpace, mergedAllTokens(tokensExpr));
      // return saveReceivingSpace(userContext, receivingSpace, tokens().done());
    }
  }

  public ReceivingSpace updateReceivingSpaceProperty(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      int receivingSpaceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingReceivingSpace(
        userContext, receivingSpaceId, receivingSpaceVersion, property, newValueExpr, tokensExpr);

    ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
    if (receivingSpace.getVersion() != receivingSpaceVersion) {
      String message =
          "The target version("
              + receivingSpace.getVersion()
              + ") is not equals to version("
              + receivingSpaceVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (receivingSpace) {
      // will be good when the receivingSpace loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ReceivingSpace.

      receivingSpace.changeProperty(property, newValueExpr);
      receivingSpace.updateLastUpdateTime(userContext.now());
      receivingSpace = saveReceivingSpace(userContext, receivingSpace, tokens().done());
      return present(userContext, receivingSpace, mergedAllTokens(tokensExpr));
      // return saveReceivingSpace(userContext, receivingSpace, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected ReceivingSpaceTokens tokens() {
    return ReceivingSpaceTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return ReceivingSpaceTokens.all();
  }

  protected Map<String, Object> analyzeTokens() {
    return tokens().allTokens().analyzeAllLists().done();
  }

  protected Map<String, Object> summaryTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> viewTokens() {
    return tokens().allTokens().sortGoodsListWith(Goods.ID_PROPERTY, sortDesc()).done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return ReceivingSpaceTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherWarehouse(
      RetailscmUserContext userContext, String receivingSpaceId, String anotherWarehouseId)
      throws Exception {

    checkerOf(userContext).checkIdOfReceivingSpace(receivingSpaceId);
    checkerOf(userContext).checkIdOfWarehouse(anotherWarehouseId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
  }

  public ReceivingSpace transferToAnotherWarehouse(
      RetailscmUserContext userContext, String receivingSpaceId, String anotherWarehouseId)
      throws Exception {
    checkParamsForTransferingAnotherWarehouse(userContext, receivingSpaceId, anotherWarehouseId);

    ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
    synchronized (receivingSpace) {
      // will be good when the receivingSpace loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      Warehouse warehouse = loadWarehouse(userContext, anotherWarehouseId, emptyOptions());
      receivingSpace.updateWarehouse(warehouse);
      receivingSpace.updateLastUpdateTime(userContext.now());
      receivingSpace = saveReceivingSpace(userContext, receivingSpace, emptyOptions());

      return present(userContext, receivingSpace, allTokens());
    }
  }

  public CandidateWarehouse requestCandidateWarehouse(
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
            .requestCandidateWarehouseForReceivingSpace(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected Warehouse loadWarehouse(
      RetailscmUserContext userContext, String newWarehouseId, Map<String, Object> options)
      throws Exception {

    return warehouseDaoOf(userContext).load(newWarehouseId, options);
  }

  // --------------------------------------------------------------

  public ReceivingSpace forgetByAll(
      RetailscmUserContext userContext, String receivingSpaceId, int receivingSpaceVersion)
      throws Exception {
    return forgetByAllInternal(userContext, receivingSpaceId, receivingSpaceVersion);
  }

  protected ReceivingSpace forgetByAllInternal(
      RetailscmUserContext userContext, String receivingSpaceId, int receivingSpaceVersion)
      throws Exception {

    return receivingSpaceDaoOf(userContext)
        .disconnectFromAll(receivingSpaceId, receivingSpaceVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new ReceivingSpaceManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingGoods(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String name,
      String rfid,
      String uom,
      int maxPackage,
      Date expireTime,
      String skuId,
      String goodsAllocationId,
      String smartPalletId,
      String shippingSpaceId,
      String transportTaskId,
      String retailStoreId,
      String bizOrderId,
      String retailStoreOrderId,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfReceivingSpace(receivingSpaceId);

    checkerOf(userContext).checkNameOfGoods(name);

    checkerOf(userContext).checkRfidOfGoods(rfid);

    checkerOf(userContext).checkUomOfGoods(uom);

    checkerOf(userContext).checkMaxPackageOfGoods(maxPackage);

    checkerOf(userContext).checkExpireTimeOfGoods(expireTime);

    checkerOf(userContext).checkSkuIdOfGoods(skuId);

    checkerOf(userContext).checkGoodsAllocationIdOfGoods(goodsAllocationId);

    checkerOf(userContext).checkSmartPalletIdOfGoods(smartPalletId);

    checkerOf(userContext).checkShippingSpaceIdOfGoods(shippingSpaceId);

    checkerOf(userContext).checkTransportTaskIdOfGoods(transportTaskId);

    checkerOf(userContext).checkRetailStoreIdOfGoods(retailStoreId);

    checkerOf(userContext).checkBizOrderIdOfGoods(bizOrderId);

    checkerOf(userContext).checkRetailStoreOrderIdOfGoods(retailStoreOrderId);

    checkerOf(userContext).throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
  }

  public ReceivingSpace addGoods(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String name,
      String rfid,
      String uom,
      int maxPackage,
      Date expireTime,
      String skuId,
      String goodsAllocationId,
      String smartPalletId,
      String shippingSpaceId,
      String transportTaskId,
      String retailStoreId,
      String bizOrderId,
      String retailStoreOrderId,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingGoods(
        userContext,
        receivingSpaceId,
        name,
        rfid,
        uom,
        maxPackage,
        expireTime,
        skuId,
        goodsAllocationId,
        smartPalletId,
        shippingSpaceId,
        transportTaskId,
        retailStoreId,
        bizOrderId,
        retailStoreOrderId,
        tokensExpr);

    Goods goods =
        createGoods(
            userContext,
            name,
            rfid,
            uom,
            maxPackage,
            expireTime,
            skuId,
            goodsAllocationId,
            smartPalletId,
            shippingSpaceId,
            transportTaskId,
            retailStoreId,
            bizOrderId,
            retailStoreOrderId);

    ReceivingSpace receivingSpace =
        loadReceivingSpace(userContext, receivingSpaceId, emptyOptions());
    synchronized (receivingSpace) {
      // Will be good when the receivingSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      receivingSpace.addGoods(goods);
      receivingSpace =
          saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());

      goodsManagerOf(userContext).onNewInstanceCreated(userContext, goods);
      return present(userContext, receivingSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingGoodsProperties(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String id,
      String name,
      String rfid,
      String uom,
      int maxPackage,
      Date expireTime,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfReceivingSpace(receivingSpaceId);
    checkerOf(userContext).checkIdOfGoods(id);

    checkerOf(userContext).checkNameOfGoods(name);
    checkerOf(userContext).checkRfidOfGoods(rfid);
    checkerOf(userContext).checkUomOfGoods(uom);
    checkerOf(userContext).checkMaxPackageOfGoods(maxPackage);
    checkerOf(userContext).checkExpireTimeOfGoods(expireTime);

    checkerOf(userContext).throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
  }

  public ReceivingSpace updateGoodsProperties(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String id,
      String name,
      String rfid,
      String uom,
      int maxPackage,
      Date expireTime,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingGoodsProperties(
        userContext, receivingSpaceId, id, name, rfid, uom, maxPackage, expireTime, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withGoodsListList()
            .searchGoodsListWith(Goods.ID_PROPERTY, tokens().is(), id)
            .done();

    ReceivingSpace receivingSpaceToUpdate =
        loadReceivingSpace(userContext, receivingSpaceId, options);

    if (receivingSpaceToUpdate.getGoodsList().isEmpty()) {
      throw new ReceivingSpaceManagerException("Goods is NOT FOUND with id: '" + id + "'");
    }

    Goods item = receivingSpaceToUpdate.getGoodsList().first();
    beforeUpdateGoodsProperties(
        userContext,
        item,
        receivingSpaceId,
        id,
        name,
        rfid,
        uom,
        maxPackage,
        expireTime,
        tokensExpr);
    item.updateName(name);
    item.updateRfid(rfid);
    item.updateUom(uom);
    item.updateMaxPackage(maxPackage);
    item.updateExpireTime(expireTime);

    // checkParamsForAddingGoods(userContext,receivingSpaceId,name, code, used,tokensExpr);
    ReceivingSpace receivingSpace =
        saveReceivingSpace(userContext, receivingSpaceToUpdate, tokens().withGoodsList().done());
    synchronized (receivingSpace) {
      return present(userContext, receivingSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateGoodsProperties(
      RetailscmUserContext userContext,
      Goods item,
      String receivingSpaceId,
      String id,
      String name,
      String rfid,
      String uom,
      int maxPackage,
      Date expireTime,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected Goods createGoods(
      RetailscmUserContext userContext,
      String name,
      String rfid,
      String uom,
      int maxPackage,
      Date expireTime,
      String skuId,
      String goodsAllocationId,
      String smartPalletId,
      String shippingSpaceId,
      String transportTaskId,
      String retailStoreId,
      String bizOrderId,
      String retailStoreOrderId)
      throws Exception {

    Goods goods = new Goods();

    goods.setName(name);
    goods.setRfid(rfid);
    goods.setUom(uom);
    goods.setMaxPackage(maxPackage);
    goods.setExpireTime(expireTime);
    Sku sku = new Sku();
    sku.setId(skuId);
    goods.setSku(sku);
    GoodsAllocation goodsAllocation = new GoodsAllocation();
    goodsAllocation.setId(goodsAllocationId);
    goods.setGoodsAllocation(goodsAllocation);
    SmartPallet smartPallet = new SmartPallet();
    smartPallet.setId(smartPalletId);
    goods.setSmartPallet(smartPallet);
    ShippingSpace shippingSpace = new ShippingSpace();
    shippingSpace.setId(shippingSpaceId);
    goods.setShippingSpace(shippingSpace);
    TransportTask transportTask = new TransportTask();
    transportTask.setId(transportTaskId);
    goods.setTransportTask(transportTask);
    RetailStore retailStore = new RetailStore();
    retailStore.setId(retailStoreId);
    goods.setRetailStore(retailStore);
    SupplyOrder bizOrder = new SupplyOrder();
    bizOrder.setId(bizOrderId);
    goods.setBizOrder(bizOrder);
    RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
    retailStoreOrder.setId(retailStoreOrderId);
    goods.setRetailStoreOrder(retailStoreOrder);

    return goods;
  }

  protected Goods createIndexedGoods(String id, int version) {

    Goods goods = new Goods();
    goods.setId(id);
    goods.setVersion(version);
    return goods;
  }

  protected void checkParamsForRemovingGoodsList(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String goodsIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfReceivingSpace(receivingSpaceId);
    for (String goodsIdItem : goodsIds) {
      checkerOf(userContext).checkIdOfGoods(goodsIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
  }

  public ReceivingSpace removeGoodsList(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String goodsIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingGoodsList(userContext, receivingSpaceId, goodsIds, tokensExpr);

    ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
    synchronized (receivingSpace) {
      // Will be good when the receivingSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      receivingSpaceDaoOf(userContext).planToRemoveGoodsList(receivingSpace, goodsIds, allTokens());
      receivingSpace =
          saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
      deleteRelationListInGraph(userContext, receivingSpace.getGoodsList());
      return present(userContext, receivingSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingGoods(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String goodsId,
      int goodsVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfReceivingSpace(receivingSpaceId);
    checkerOf(userContext).checkIdOfGoods(goodsId);
    checkerOf(userContext).checkVersionOfGoods(goodsVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
  }

  public ReceivingSpace removeGoods(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String goodsId,
      int goodsVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingGoods(userContext, receivingSpaceId, goodsId, goodsVersion, tokensExpr);

    Goods goods = createIndexedGoods(goodsId, goodsVersion);
    ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
    synchronized (receivingSpace) {
      // Will be good when the receivingSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      receivingSpace.removeGoods(goods);
      receivingSpace =
          saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
      deleteRelationInGraph(userContext, goods);
      return present(userContext, receivingSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingGoods(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String goodsId,
      int goodsVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfReceivingSpace(receivingSpaceId);
    checkerOf(userContext).checkIdOfGoods(goodsId);
    checkerOf(userContext).checkVersionOfGoods(goodsVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
  }

  public ReceivingSpace copyGoodsFrom(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String goodsId,
      int goodsVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingGoods(userContext, receivingSpaceId, goodsId, goodsVersion, tokensExpr);

    Goods goods = createIndexedGoods(goodsId, goodsVersion);
    ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, allTokens());
    synchronized (receivingSpace) {
      // Will be good when the receivingSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      receivingSpace.copyGoodsFrom(goods);
      receivingSpace =
          saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());

      goodsManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (Goods) receivingSpace.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, receivingSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingGoods(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String goodsId,
      int goodsVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfReceivingSpace(receivingSpaceId);
    checkerOf(userContext).checkIdOfGoods(goodsId);
    checkerOf(userContext).checkVersionOfGoods(goodsVersion);

    if (Goods.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfGoods(parseString(newValueExpr));
    }

    if (Goods.RFID_PROPERTY.equals(property)) {
      checkerOf(userContext).checkRfidOfGoods(parseString(newValueExpr));
    }

    if (Goods.UOM_PROPERTY.equals(property)) {
      checkerOf(userContext).checkUomOfGoods(parseString(newValueExpr));
    }

    if (Goods.MAX_PACKAGE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkMaxPackageOfGoods(parseInt(newValueExpr));
    }

    if (Goods.EXPIRE_TIME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkExpireTimeOfGoods(parseDate(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ReceivingSpaceManagerException.class);
  }

  public ReceivingSpace updateGoods(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String goodsId,
      int goodsVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingGoods(
        userContext, receivingSpaceId, goodsId, goodsVersion, property, newValueExpr, tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withGoodsList()
            .searchGoodsListWith(Goods.ID_PROPERTY, tokens().equals(), goodsId)
            .done();

    ReceivingSpace receivingSpace = loadReceivingSpace(userContext, receivingSpaceId, loadTokens);

    synchronized (receivingSpace) {
      // Will be good when the receivingSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // receivingSpace.removeGoods( goods );
      // make changes to AcceleraterAccount.
      Goods goodsIdVersionKey = createIndexedGoods(goodsId, goodsVersion);

      Goods goods = receivingSpace.findTheGoods(goodsIdVersionKey);
      if (goods == null) {
        throw new ReceivingSpaceManagerException(goodsId + " is NOT FOUND");
      }

      beforeUpdateGoods(
          userContext,
          goods,
          receivingSpaceId,
          goodsId,
          goodsVersion,
          property,
          newValueExpr,
          tokensExpr);
      goods.changeProperty(property, newValueExpr);

      receivingSpace =
          saveReceivingSpace(userContext, receivingSpace, tokens().withGoodsList().done());
      goodsManagerOf(userContext).onUpdated(userContext, goods, this, "updateGoods");
      return present(userContext, receivingSpace, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateGoods(
      RetailscmUserContext userContext,
      Goods existed,
      String receivingSpaceId,
      String goodsId,
      int goodsVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, ReceivingSpace newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    receivingSpaceDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   ReceivingSpace newReceivingSpace = this.createReceivingSpace(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newReceivingSpace
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
    key.put(UserApp.APP_TYPE_PROPERTY, ReceivingSpace.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<ReceivingSpace> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<Warehouse> warehouseList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Warehouse.class);
    userContext.getDAOGroup().enhanceList(warehouseList, Warehouse.class);
  }

  public Object listByWarehouse(RetailscmUserContext userContext, String warehouseId)
      throws Exception {
    return listPageByWarehouse(userContext, warehouseId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByWarehouse(
      RetailscmUserContext userContext, String warehouseId, int start, int count) throws Exception {
    SmartList<ReceivingSpace> list =
        receivingSpaceDaoOf(userContext)
            .findReceivingSpaceByWarehouse(warehouseId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(ReceivingSpace.class);
    page.setContainerObject(Warehouse.withId(warehouseId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("收货区列表");
    page.setRequestName("listByWarehouse");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByWarehouse/%s/", getBeanName(), warehouseId)));

    page.assemblerContent(userContext, "listByWarehouse");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String receivingSpaceId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    ReceivingSpace merchantObj = (ReceivingSpace) this.view(userContext, receivingSpaceId);
    String merchantObjId = receivingSpaceId;
    String linkToUrl = "receivingSpaceManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "收货区" + "详情";
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
        MapUtil.put("id", "2-location")
            .put("fieldName", "location")
            .put("label", "位置")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("location", merchantObj.getLocation());

    propList.add(
        MapUtil.put("id", "3-contactNumber")
            .put("fieldName", "contactNumber")
            .put("label", "联系电话")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("contactNumber", merchantObj.getContactNumber());

    propList.add(
        MapUtil.put("id", "4-description")
            .put("fieldName", "description")
            .put("label", "描述")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("description", merchantObj.getDescription());

    propList.add(
        MapUtil.put("id", "5-totalArea")
            .put("fieldName", "totalArea")
            .put("label", "总面积")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("totalArea", merchantObj.getTotalArea());

    propList.add(
        MapUtil.put("id", "6-warehouse")
            .put("fieldName", "warehouse")
            .put("label", "仓库")
            .put("type", "document")
            .put("linkToUrl", "warehouseManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"document\",\"title\":\"location\",\"imageList\":\"\"}")
            .into_map());
    result.put("warehouse", merchantObj.getWarehouse());

    propList.add(
        MapUtil.put("id", "7-latitude")
            .put("fieldName", "latitude")
            .put("label", "纬度")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("latitude", merchantObj.getLatitude());

    propList.add(
        MapUtil.put("id", "8-longitude")
            .put("fieldName", "longitude")
            .put("label", "经度")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("longitude", merchantObj.getLongitude());

    propList.add(
        MapUtil.put("id", "9-lastUpdateTime")
            .put("fieldName", "lastUpdateTime")
            .put("label", "更新于")
            .put("type", "datetime")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

    // 处理 sectionList

    // 处理Section：goodsListSection
    Map goodsListSection =
        ListofUtils.buildSection(
            "goodsListSection",
            "商品列表",
            null,
            "",
            "__no_group",
            "goodsManager/listByReceivingSpace/" + merchantObjId + "/",
            "auto");
    sections.add(goodsListSection);

    result.put("goodsListSection", ListofUtils.toShortList(merchantObj.getGoodsList(), "goods"));

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
