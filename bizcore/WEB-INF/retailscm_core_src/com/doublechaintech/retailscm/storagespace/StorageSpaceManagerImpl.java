package com.doublechaintech.retailscm.storagespace;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.storagespace.StorageSpace;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
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

public class StorageSpaceManagerImpl extends CustomRetailscmCheckerManager
    implements StorageSpaceManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens = StorageSpaceTokens.start().withTokenFromListName(listName).done();
    StorageSpace storageSpace = (StorageSpace) this.loadStorageSpace(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = storageSpace.collectReferencesFromLists();
    storageSpaceDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, storageSpace, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new StorageSpaceGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "StorageSpace";

  @Override
  public StorageSpaceDAO daoOf(RetailscmUserContext userContext) {
    return storageSpaceDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws StorageSpaceManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new StorageSpaceManagerException(message);
  }

  protected StorageSpace saveStorageSpace(
      RetailscmUserContext userContext, StorageSpace storageSpace, String[] tokensExpr)
      throws Exception {
    // return getStorageSpaceDAO().save(storageSpace, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveStorageSpace(userContext, storageSpace, tokens);
  }

  protected StorageSpace saveStorageSpaceDetail(
      RetailscmUserContext userContext, StorageSpace storageSpace) throws Exception {

    return saveStorageSpace(userContext, storageSpace, allTokens());
  }

  public StorageSpace loadStorageSpace(
      RetailscmUserContext userContext, String storageSpaceId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);

    checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, tokens);
    // do some calc before sent to customer?
    return present(userContext, storageSpace, tokens);
  }

  public StorageSpace searchStorageSpace(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);

    checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, tokens);
    // do some calc before sent to customer?
    return present(userContext, storageSpace, tokens);
  }

  protected StorageSpace present(
      RetailscmUserContext userContext, StorageSpace storageSpace, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, storageSpace, tokens);

    StorageSpace storageSpaceToPresent =
        storageSpaceDaoOf(userContext).present(storageSpace, tokens);

    List<BaseEntity> entityListToNaming = storageSpaceToPresent.collectReferencesFromLists();
    storageSpaceDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, storageSpace, tokens);

    return storageSpaceToPresent;
  }

  public StorageSpace loadStorageSpaceDetail(
      RetailscmUserContext userContext, String storageSpaceId) throws Exception {
    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
    return present(userContext, storageSpace, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String storageSpaceId) throws Exception {
    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, viewTokens());
    markVisited(userContext, storageSpace);
    return present(userContext, storageSpace, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String storageSpaceId)
      throws Exception {
    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, viewTokens());
    storageSpace.summarySuffix();
    markVisited(userContext, storageSpace);
    return present(userContext, storageSpace, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String storageSpaceId) throws Exception {
    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, analyzeTokens());
    markVisited(userContext, storageSpace);
    return present(userContext, storageSpace, analyzeTokens());
  }

  protected StorageSpace saveStorageSpace(
      RetailscmUserContext userContext, StorageSpace storageSpace, Map<String, Object> tokens)
      throws Exception {

    return storageSpaceDaoOf(userContext).save(storageSpace, tokens);
  }

  protected StorageSpace loadStorageSpace(
      RetailscmUserContext userContext, String storageSpaceId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);

    checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);

    return storageSpaceDaoOf(userContext).load(storageSpaceId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, StorageSpace storageSpace, Map<String, Object> tokens) {
    super.addActions(userContext, storageSpace, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, StorageSpace storageSpace, Map<String, Object> tokens){

  @Override
  public List<StorageSpace> searchStorageSpaceList(
      RetailscmUserContext ctx, StorageSpaceRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<StorageSpace> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public StorageSpace searchStorageSpace(RetailscmUserContext ctx, StorageSpaceRequest pRequest) {
    pRequest.limit(0, 1);
    List<StorageSpace> list = searchStorageSpaceList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public StorageSpace createStorageSpace(
      RetailscmUserContext userContext,
      String location,
      String contactNumber,
      String totalArea,
      String warehouseId,
      BigDecimal latitude,
      BigDecimal longitude)
      throws Exception {

    checkerOf(userContext).checkLocationOfStorageSpace(location);
    checkerOf(userContext).checkContactNumberOfStorageSpace(contactNumber);
    checkerOf(userContext).checkTotalAreaOfStorageSpace(totalArea);
    checkerOf(userContext).checkLatitudeOfStorageSpace(latitude);
    checkerOf(userContext).checkLongitudeOfStorageSpace(longitude);

    checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);

    StorageSpace storageSpace = createNewStorageSpace();

    storageSpace.setLocation(location);
    storageSpace.setContactNumber(contactNumber);
    storageSpace.setTotalArea(totalArea);

    Warehouse warehouse = loadWarehouse(userContext, warehouseId, emptyOptions());
    storageSpace.setWarehouse(warehouse);

    storageSpace.setLatitude(latitude);
    storageSpace.setLongitude(longitude);
    storageSpace.setLastUpdateTime(userContext.now());

    storageSpace = saveStorageSpace(userContext, storageSpace, emptyOptions());

    onNewInstanceCreated(userContext, storageSpace);
    return storageSpace;
  }

  protected StorageSpace createNewStorageSpace() {

    return new StorageSpace();
  }

  protected void checkParamsForUpdatingStorageSpace(
      RetailscmUserContext userContext,
      String storageSpaceId,
      int storageSpaceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
    checkerOf(userContext).checkVersionOfStorageSpace(storageSpaceVersion);

    if (StorageSpace.LOCATION_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLocationOfStorageSpace(parseString(newValueExpr));
    }
    if (StorageSpace.CONTACT_NUMBER_PROPERTY.equals(property)) {

      checkerOf(userContext).checkContactNumberOfStorageSpace(parseString(newValueExpr));
    }
    if (StorageSpace.TOTAL_AREA_PROPERTY.equals(property)) {

      checkerOf(userContext).checkTotalAreaOfStorageSpace(parseString(newValueExpr));
    }

    if (StorageSpace.LATITUDE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLatitudeOfStorageSpace(parseBigDecimal(newValueExpr));
    }
    if (StorageSpace.LONGITUDE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLongitudeOfStorageSpace(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);
  }

  public StorageSpace clone(RetailscmUserContext userContext, String fromStorageSpaceId)
      throws Exception {

    return storageSpaceDaoOf(userContext).clone(fromStorageSpaceId, this.allTokens());
  }

  public StorageSpace internalSaveStorageSpace(
      RetailscmUserContext userContext, StorageSpace storageSpace) throws Exception {
    return internalSaveStorageSpace(userContext, storageSpace, allTokens());
  }

  public StorageSpace internalSaveStorageSpace(
      RetailscmUserContext userContext, StorageSpace storageSpace, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingStorageSpace(userContext, storageSpaceId, storageSpaceVersion,
    // property, newValueExpr, tokensExpr);

    synchronized (storageSpace) {
      // will be good when the storageSpace loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to StorageSpace.
      if (storageSpace.isChanged()) {
        storageSpace.updateLastUpdateTime(userContext.now());
      }

      // checkerOf(userContext).checkAndFixStorageSpace(storageSpace);
      storageSpace = saveStorageSpace(userContext, storageSpace, options);
      return storageSpace;
    }
  }

  public StorageSpace updateStorageSpace(
      RetailscmUserContext userContext,
      String storageSpaceId,
      int storageSpaceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingStorageSpace(
        userContext, storageSpaceId, storageSpaceVersion, property, newValueExpr, tokensExpr);

    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
    if (storageSpace.getVersion() != storageSpaceVersion) {
      String message =
          "The target version("
              + storageSpace.getVersion()
              + ") is not equals to version("
              + storageSpaceVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (storageSpace) {
      // will be good when the storageSpace loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to StorageSpace.
      storageSpace.updateLastUpdateTime(userContext.now());
      storageSpace.changeProperty(property, newValueExpr);
      storageSpace = saveStorageSpace(userContext, storageSpace, tokens().done());
      return present(userContext, storageSpace, mergedAllTokens(tokensExpr));
      // return saveStorageSpace(userContext, storageSpace, tokens().done());
    }
  }

  public StorageSpace updateStorageSpaceProperty(
      RetailscmUserContext userContext,
      String storageSpaceId,
      int storageSpaceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingStorageSpace(
        userContext, storageSpaceId, storageSpaceVersion, property, newValueExpr, tokensExpr);

    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
    if (storageSpace.getVersion() != storageSpaceVersion) {
      String message =
          "The target version("
              + storageSpace.getVersion()
              + ") is not equals to version("
              + storageSpaceVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (storageSpace) {
      // will be good when the storageSpace loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to StorageSpace.

      storageSpace.changeProperty(property, newValueExpr);
      storageSpace.updateLastUpdateTime(userContext.now());
      storageSpace = saveStorageSpace(userContext, storageSpace, tokens().done());
      return present(userContext, storageSpace, mergedAllTokens(tokensExpr));
      // return saveStorageSpace(userContext, storageSpace, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected StorageSpaceTokens tokens() {
    return StorageSpaceTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return StorageSpaceTokens.all();
  }

  protected Map<String, Object> analyzeTokens() {
    return tokens().allTokens().analyzeAllLists().done();
  }

  protected Map<String, Object> summaryTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> viewTokens() {
    return tokens().allTokens().sortGoodsShelfListWith(GoodsShelf.ID_PROPERTY, sortDesc()).done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return StorageSpaceTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherWarehouse(
      RetailscmUserContext userContext, String storageSpaceId, String anotherWarehouseId)
      throws Exception {

    checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
    checkerOf(userContext).checkIdOfWarehouse(anotherWarehouseId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);
  }

  public StorageSpace transferToAnotherWarehouse(
      RetailscmUserContext userContext, String storageSpaceId, String anotherWarehouseId)
      throws Exception {
    checkParamsForTransferingAnotherWarehouse(userContext, storageSpaceId, anotherWarehouseId);

    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
    synchronized (storageSpace) {
      // will be good when the storageSpace loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      Warehouse warehouse = loadWarehouse(userContext, anotherWarehouseId, emptyOptions());
      storageSpace.updateWarehouse(warehouse);
      storageSpace.updateLastUpdateTime(userContext.now());
      storageSpace = saveStorageSpace(userContext, storageSpace, emptyOptions());

      return present(userContext, storageSpace, allTokens());
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
            .requestCandidateWarehouseForStorageSpace(
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

  public StorageSpace forgetByAll(
      RetailscmUserContext userContext, String storageSpaceId, int storageSpaceVersion)
      throws Exception {
    return forgetByAllInternal(userContext, storageSpaceId, storageSpaceVersion);
  }

  protected StorageSpace forgetByAllInternal(
      RetailscmUserContext userContext, String storageSpaceId, int storageSpaceVersion)
      throws Exception {

    return storageSpaceDaoOf(userContext).disconnectFromAll(storageSpaceId, storageSpaceVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new StorageSpaceManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingGoodsShelf(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String location,
      String supplierSpaceId,
      String damageSpaceId,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);

    checkerOf(userContext).checkLocationOfGoodsShelf(location);

    checkerOf(userContext).checkSupplierSpaceIdOfGoodsShelf(supplierSpaceId);

    checkerOf(userContext).checkDamageSpaceIdOfGoodsShelf(damageSpaceId);

    checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);
  }

  public StorageSpace addGoodsShelf(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String location,
      String supplierSpaceId,
      String damageSpaceId,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingGoodsShelf(
        userContext, storageSpaceId, location, supplierSpaceId, damageSpaceId, tokensExpr);

    GoodsShelf goodsShelf = createGoodsShelf(userContext, location, supplierSpaceId, damageSpaceId);

    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, emptyOptions());
    synchronized (storageSpace) {
      // Will be good when the storageSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      storageSpace.addGoodsShelf(goodsShelf);
      storageSpace =
          saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());

      goodsShelfManagerOf(userContext).onNewInstanceCreated(userContext, goodsShelf);
      return present(userContext, storageSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingGoodsShelfProperties(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String id,
      String location,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
    checkerOf(userContext).checkIdOfGoodsShelf(id);

    checkerOf(userContext).checkLocationOfGoodsShelf(location);

    checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);
  }

  public StorageSpace updateGoodsShelfProperties(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String id,
      String location,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingGoodsShelfProperties(
        userContext, storageSpaceId, id, location, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withGoodsShelfListList()
            .searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, tokens().is(), id)
            .done();

    StorageSpace storageSpaceToUpdate = loadStorageSpace(userContext, storageSpaceId, options);

    if (storageSpaceToUpdate.getGoodsShelfList().isEmpty()) {
      throw new StorageSpaceManagerException("GoodsShelf is NOT FOUND with id: '" + id + "'");
    }

    GoodsShelf item = storageSpaceToUpdate.getGoodsShelfList().first();
    beforeUpdateGoodsShelfProperties(userContext, item, storageSpaceId, id, location, tokensExpr);
    item.updateLocation(location);

    // checkParamsForAddingGoodsShelf(userContext,storageSpaceId,name, code, used,tokensExpr);
    StorageSpace storageSpace =
        saveStorageSpace(userContext, storageSpaceToUpdate, tokens().withGoodsShelfList().done());
    synchronized (storageSpace) {
      return present(userContext, storageSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateGoodsShelfProperties(
      RetailscmUserContext userContext,
      GoodsShelf item,
      String storageSpaceId,
      String id,
      String location,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected GoodsShelf createGoodsShelf(
      RetailscmUserContext userContext,
      String location,
      String supplierSpaceId,
      String damageSpaceId)
      throws Exception {

    GoodsShelf goodsShelf = new GoodsShelf();

    goodsShelf.setLocation(location);
    SupplierSpace supplierSpace = new SupplierSpace();
    supplierSpace.setId(supplierSpaceId);
    goodsShelf.setSupplierSpace(supplierSpace);
    DamageSpace damageSpace = new DamageSpace();
    damageSpace.setId(damageSpaceId);
    goodsShelf.setDamageSpace(damageSpace);
    goodsShelf.setLastUpdateTime(userContext.now());

    return goodsShelf;
  }

  protected GoodsShelf createIndexedGoodsShelf(String id, int version) {

    GoodsShelf goodsShelf = new GoodsShelf();
    goodsShelf.setId(id);
    goodsShelf.setVersion(version);
    return goodsShelf;
  }

  protected void checkParamsForRemovingGoodsShelfList(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String goodsShelfIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
    for (String goodsShelfIdItem : goodsShelfIds) {
      checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);
  }

  public StorageSpace removeGoodsShelfList(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String goodsShelfIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingGoodsShelfList(userContext, storageSpaceId, goodsShelfIds, tokensExpr);

    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
    synchronized (storageSpace) {
      // Will be good when the storageSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      storageSpaceDaoOf(userContext)
          .planToRemoveGoodsShelfList(storageSpace, goodsShelfIds, allTokens());
      storageSpace =
          saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
      deleteRelationListInGraph(userContext, storageSpace.getGoodsShelfList());
      return present(userContext, storageSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingGoodsShelf(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);
  }

  public StorageSpace removeGoodsShelf(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingGoodsShelf(
        userContext, storageSpaceId, goodsShelfId, goodsShelfVersion, tokensExpr);

    GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
    synchronized (storageSpace) {
      // Will be good when the storageSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      storageSpace.removeGoodsShelf(goodsShelf);
      storageSpace =
          saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
      deleteRelationInGraph(userContext, goodsShelf);
      return present(userContext, storageSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingGoodsShelf(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);
  }

  public StorageSpace copyGoodsShelfFrom(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingGoodsShelf(
        userContext, storageSpaceId, goodsShelfId, goodsShelfVersion, tokensExpr);

    GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
    synchronized (storageSpace) {
      // Will be good when the storageSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      goodsShelf.updateLastUpdateTime(userContext.now());

      storageSpace.copyGoodsShelfFrom(goodsShelf);
      storageSpace =
          saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());

      goodsShelfManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (GoodsShelf) storageSpace.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, storageSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingGoodsShelf(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfStorageSpace(storageSpaceId);
    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);

    if (GoodsShelf.LOCATION_PROPERTY.equals(property)) {
      checkerOf(userContext).checkLocationOfGoodsShelf(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(StorageSpaceManagerException.class);
  }

  public StorageSpace updateGoodsShelf(
      RetailscmUserContext userContext,
      String storageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingGoodsShelf(
        userContext,
        storageSpaceId,
        goodsShelfId,
        goodsShelfVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withGoodsShelfList()
            .searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, tokens().equals(), goodsShelfId)
            .done();

    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, loadTokens);

    synchronized (storageSpace) {
      // Will be good when the storageSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // storageSpace.removeGoodsShelf( goodsShelf );
      // make changes to AcceleraterAccount.
      GoodsShelf goodsShelfIdVersionKey = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);

      GoodsShelf goodsShelf = storageSpace.findTheGoodsShelf(goodsShelfIdVersionKey);
      if (goodsShelf == null) {
        throw new StorageSpaceManagerException(goodsShelfId + " is NOT FOUND");
      }

      beforeUpdateGoodsShelf(
          userContext,
          goodsShelf,
          storageSpaceId,
          goodsShelfId,
          goodsShelfVersion,
          property,
          newValueExpr,
          tokensExpr);
      goodsShelf.changeProperty(property, newValueExpr);
      goodsShelf.updateLastUpdateTime(userContext.now());
      storageSpace =
          saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
      goodsShelfManagerOf(userContext).onUpdated(userContext, goodsShelf, this, "updateGoodsShelf");
      return present(userContext, storageSpace, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateGoodsShelf(
      RetailscmUserContext userContext,
      GoodsShelf existed,
      String storageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, StorageSpace newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    storageSpaceDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   StorageSpace newStorageSpace = this.createStorageSpace(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newStorageSpace
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
    key.put(UserApp.APP_TYPE_PROPERTY, StorageSpace.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<StorageSpace> list) throws Exception {
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
    SmartList<StorageSpace> list =
        storageSpaceDaoOf(userContext)
            .findStorageSpaceByWarehouse(warehouseId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(StorageSpace.class);
    page.setContainerObject(Warehouse.withId(warehouseId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("存货区列表");
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
  public Object wxappview(RetailscmUserContext userContext, String storageSpaceId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    StorageSpace merchantObj = (StorageSpace) this.view(userContext, storageSpaceId);
    String merchantObjId = storageSpaceId;
    String linkToUrl = "storageSpaceManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "存货区" + "详情";
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
        MapUtil.put("id", "4-totalArea")
            .put("fieldName", "totalArea")
            .put("label", "总面积")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("totalArea", merchantObj.getTotalArea());

    propList.add(
        MapUtil.put("id", "5-warehouse")
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
        MapUtil.put("id", "6-latitude")
            .put("fieldName", "latitude")
            .put("label", "纬度")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("latitude", merchantObj.getLatitude());

    propList.add(
        MapUtil.put("id", "7-longitude")
            .put("fieldName", "longitude")
            .put("label", "经度")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("longitude", merchantObj.getLongitude());

    propList.add(
        MapUtil.put("id", "8-lastUpdateTime")
            .put("fieldName", "lastUpdateTime")
            .put("label", "更新于")
            .put("type", "datetime")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

    // 处理 sectionList

    // 处理Section：goodsShelfListSection
    Map goodsShelfListSection =
        ListofUtils.buildSection(
            "goodsShelfListSection",
            "货架列表",
            null,
            "",
            "__no_group",
            "goodsShelfManager/listByStorageSpace/" + merchantObjId + "/",
            "auto");
    sections.add(goodsShelfListSection);

    result.put(
        "goodsShelfListSection",
        ListofUtils.toShortList(merchantObj.getGoodsShelfList(), "goodsShelf"));

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
