package com.doublechaintech.retailscm.damagespace;

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

public class DamageSpaceManagerImpl extends CustomRetailscmCheckerManager
    implements DamageSpaceManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens = DamageSpaceTokens.start().withTokenFromListName(listName).done();
    DamageSpace damageSpace = (DamageSpace) this.loadDamageSpace(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = damageSpace.collectReferencesFromLists();
    damageSpaceDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, damageSpace, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new DamageSpaceGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "DamageSpace";

  @Override
  public DamageSpaceDAO daoOf(RetailscmUserContext userContext) {
    return damageSpaceDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws DamageSpaceManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new DamageSpaceManagerException(message);
  }

  protected DamageSpace saveDamageSpace(
      RetailscmUserContext userContext, DamageSpace damageSpace, String[] tokensExpr)
      throws Exception {
    // return getDamageSpaceDAO().save(damageSpace, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveDamageSpace(userContext, damageSpace, tokens);
  }

  protected DamageSpace saveDamageSpaceDetail(
      RetailscmUserContext userContext, DamageSpace damageSpace) throws Exception {

    return saveDamageSpace(userContext, damageSpace, allTokens());
  }

  public DamageSpace loadDamageSpace(
      RetailscmUserContext userContext, String damageSpaceId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfDamageSpace(damageSpaceId);

    checkerOf(userContext).throwExceptionIfHasErrors(DamageSpaceManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, tokens);
    // do some calc before sent to customer?
    return present(userContext, damageSpace, tokens);
  }

  public DamageSpace searchDamageSpace(
      RetailscmUserContext userContext,
      String damageSpaceId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfDamageSpace(damageSpaceId);

    checkerOf(userContext).throwExceptionIfHasErrors(DamageSpaceManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, tokens);
    // do some calc before sent to customer?
    return present(userContext, damageSpace, tokens);
  }

  protected DamageSpace present(
      RetailscmUserContext userContext, DamageSpace damageSpace, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, damageSpace, tokens);

    DamageSpace damageSpaceToPresent = damageSpaceDaoOf(userContext).present(damageSpace, tokens);

    List<BaseEntity> entityListToNaming = damageSpaceToPresent.collectReferencesFromLists();
    damageSpaceDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, damageSpace, tokens);

    return damageSpaceToPresent;
  }

  public DamageSpace loadDamageSpaceDetail(RetailscmUserContext userContext, String damageSpaceId)
      throws Exception {
    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
    return present(userContext, damageSpace, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String damageSpaceId) throws Exception {
    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, viewTokens());
    markVisited(userContext, damageSpace);
    return present(userContext, damageSpace, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String damageSpaceId)
      throws Exception {
    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, viewTokens());
    damageSpace.summarySuffix();
    markVisited(userContext, damageSpace);
    return present(userContext, damageSpace, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String damageSpaceId) throws Exception {
    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, analyzeTokens());
    markVisited(userContext, damageSpace);
    return present(userContext, damageSpace, analyzeTokens());
  }

  protected DamageSpace saveDamageSpace(
      RetailscmUserContext userContext, DamageSpace damageSpace, Map<String, Object> tokens)
      throws Exception {

    return damageSpaceDaoOf(userContext).save(damageSpace, tokens);
  }

  protected DamageSpace loadDamageSpace(
      RetailscmUserContext userContext, String damageSpaceId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfDamageSpace(damageSpaceId);

    checkerOf(userContext).throwExceptionIfHasErrors(DamageSpaceManagerException.class);

    return damageSpaceDaoOf(userContext).load(damageSpaceId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, DamageSpace damageSpace, Map<String, Object> tokens) {
    super.addActions(userContext, damageSpace, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, DamageSpace damageSpace, Map<String, Object> tokens){

  @Override
  public List<DamageSpace> searchDamageSpaceList(
      RetailscmUserContext ctx, DamageSpaceRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<DamageSpace> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public DamageSpace searchDamageSpace(RetailscmUserContext ctx, DamageSpaceRequest pRequest) {
    pRequest.limit(0, 1);
    List<DamageSpace> list = searchDamageSpaceList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public DamageSpace createDamageSpace(
      RetailscmUserContext userContext,
      String location,
      String contactNumber,
      String totalArea,
      BigDecimal latitude,
      BigDecimal longitude,
      String warehouseId)
      throws Exception {

    checkerOf(userContext).checkLocationOfDamageSpace(location);
    checkerOf(userContext).checkContactNumberOfDamageSpace(contactNumber);
    checkerOf(userContext).checkTotalAreaOfDamageSpace(totalArea);
    checkerOf(userContext).checkLatitudeOfDamageSpace(latitude);
    checkerOf(userContext).checkLongitudeOfDamageSpace(longitude);

    checkerOf(userContext).throwExceptionIfHasErrors(DamageSpaceManagerException.class);

    DamageSpace damageSpace = createNewDamageSpace();

    damageSpace.setLocation(location);
    damageSpace.setContactNumber(contactNumber);
    damageSpace.setTotalArea(totalArea);
    damageSpace.setLatitude(latitude);
    damageSpace.setLongitude(longitude);

    Warehouse warehouse = loadWarehouse(userContext, warehouseId, emptyOptions());
    damageSpace.setWarehouse(warehouse);

    damageSpace.setLastUpdateTime(userContext.now());

    damageSpace = saveDamageSpace(userContext, damageSpace, emptyOptions());

    onNewInstanceCreated(userContext, damageSpace);
    return damageSpace;
  }

  protected DamageSpace createNewDamageSpace() {

    return new DamageSpace();
  }

  protected void checkParamsForUpdatingDamageSpace(
      RetailscmUserContext userContext,
      String damageSpaceId,
      int damageSpaceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfDamageSpace(damageSpaceId);
    checkerOf(userContext).checkVersionOfDamageSpace(damageSpaceVersion);

    if (DamageSpace.LOCATION_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLocationOfDamageSpace(parseString(newValueExpr));
    }
    if (DamageSpace.CONTACT_NUMBER_PROPERTY.equals(property)) {

      checkerOf(userContext).checkContactNumberOfDamageSpace(parseString(newValueExpr));
    }
    if (DamageSpace.TOTAL_AREA_PROPERTY.equals(property)) {

      checkerOf(userContext).checkTotalAreaOfDamageSpace(parseString(newValueExpr));
    }
    if (DamageSpace.LATITUDE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLatitudeOfDamageSpace(parseBigDecimal(newValueExpr));
    }
    if (DamageSpace.LONGITUDE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLongitudeOfDamageSpace(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(DamageSpaceManagerException.class);
  }

  public DamageSpace clone(RetailscmUserContext userContext, String fromDamageSpaceId)
      throws Exception {

    return damageSpaceDaoOf(userContext).clone(fromDamageSpaceId, this.allTokens());
  }

  public DamageSpace internalSaveDamageSpace(
      RetailscmUserContext userContext, DamageSpace damageSpace) throws Exception {
    return internalSaveDamageSpace(userContext, damageSpace, allTokens());
  }

  public DamageSpace internalSaveDamageSpace(
      RetailscmUserContext userContext, DamageSpace damageSpace, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingDamageSpace(userContext, damageSpaceId, damageSpaceVersion, property,
    // newValueExpr, tokensExpr);

    synchronized (damageSpace) {
      // will be good when the damageSpace loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to DamageSpace.
      if (damageSpace.isChanged()) {
        damageSpace.updateLastUpdateTime(userContext.now());
      }

      // checkerOf(userContext).checkAndFixDamageSpace(damageSpace);
      damageSpace = saveDamageSpace(userContext, damageSpace, options);
      return damageSpace;
    }
  }

  public DamageSpace updateDamageSpace(
      RetailscmUserContext userContext,
      String damageSpaceId,
      int damageSpaceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingDamageSpace(
        userContext, damageSpaceId, damageSpaceVersion, property, newValueExpr, tokensExpr);

    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
    if (damageSpace.getVersion() != damageSpaceVersion) {
      String message =
          "The target version("
              + damageSpace.getVersion()
              + ") is not equals to version("
              + damageSpaceVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (damageSpace) {
      // will be good when the damageSpace loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to DamageSpace.
      damageSpace.updateLastUpdateTime(userContext.now());
      damageSpace.changeProperty(property, newValueExpr);
      damageSpace = saveDamageSpace(userContext, damageSpace, tokens().done());
      return present(userContext, damageSpace, mergedAllTokens(tokensExpr));
      // return saveDamageSpace(userContext, damageSpace, tokens().done());
    }
  }

  public DamageSpace updateDamageSpaceProperty(
      RetailscmUserContext userContext,
      String damageSpaceId,
      int damageSpaceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingDamageSpace(
        userContext, damageSpaceId, damageSpaceVersion, property, newValueExpr, tokensExpr);

    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
    if (damageSpace.getVersion() != damageSpaceVersion) {
      String message =
          "The target version("
              + damageSpace.getVersion()
              + ") is not equals to version("
              + damageSpaceVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (damageSpace) {
      // will be good when the damageSpace loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to DamageSpace.

      damageSpace.changeProperty(property, newValueExpr);
      damageSpace.updateLastUpdateTime(userContext.now());
      damageSpace = saveDamageSpace(userContext, damageSpace, tokens().done());
      return present(userContext, damageSpace, mergedAllTokens(tokensExpr));
      // return saveDamageSpace(userContext, damageSpace, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected DamageSpaceTokens tokens() {
    return DamageSpaceTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return DamageSpaceTokens.all();
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
    return DamageSpaceTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherWarehouse(
      RetailscmUserContext userContext, String damageSpaceId, String anotherWarehouseId)
      throws Exception {

    checkerOf(userContext).checkIdOfDamageSpace(damageSpaceId);
    checkerOf(userContext).checkIdOfWarehouse(anotherWarehouseId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(DamageSpaceManagerException.class);
  }

  public DamageSpace transferToAnotherWarehouse(
      RetailscmUserContext userContext, String damageSpaceId, String anotherWarehouseId)
      throws Exception {
    checkParamsForTransferingAnotherWarehouse(userContext, damageSpaceId, anotherWarehouseId);

    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
    synchronized (damageSpace) {
      // will be good when the damageSpace loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      Warehouse warehouse = loadWarehouse(userContext, anotherWarehouseId, emptyOptions());
      damageSpace.updateWarehouse(warehouse);
      damageSpace.updateLastUpdateTime(userContext.now());
      damageSpace = saveDamageSpace(userContext, damageSpace, emptyOptions());

      return present(userContext, damageSpace, allTokens());
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
            .requestCandidateWarehouseForDamageSpace(
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

  public DamageSpace forgetByAll(
      RetailscmUserContext userContext, String damageSpaceId, int damageSpaceVersion)
      throws Exception {
    return forgetByAllInternal(userContext, damageSpaceId, damageSpaceVersion);
  }

  protected DamageSpace forgetByAllInternal(
      RetailscmUserContext userContext, String damageSpaceId, int damageSpaceVersion)
      throws Exception {

    return damageSpaceDaoOf(userContext).disconnectFromAll(damageSpaceId, damageSpaceVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new DamageSpaceManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingGoodsShelf(
      RetailscmUserContext userContext,
      String damageSpaceId,
      String location,
      String storageSpaceId,
      String supplierSpaceId,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfDamageSpace(damageSpaceId);

    checkerOf(userContext).checkLocationOfGoodsShelf(location);

    checkerOf(userContext).checkStorageSpaceIdOfGoodsShelf(storageSpaceId);

    checkerOf(userContext).checkSupplierSpaceIdOfGoodsShelf(supplierSpaceId);

    checkerOf(userContext).throwExceptionIfHasErrors(DamageSpaceManagerException.class);
  }

  public DamageSpace addGoodsShelf(
      RetailscmUserContext userContext,
      String damageSpaceId,
      String location,
      String storageSpaceId,
      String supplierSpaceId,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingGoodsShelf(
        userContext, damageSpaceId, location, storageSpaceId, supplierSpaceId, tokensExpr);

    GoodsShelf goodsShelf =
        createGoodsShelf(userContext, location, storageSpaceId, supplierSpaceId);

    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, emptyOptions());
    synchronized (damageSpace) {
      // Will be good when the damageSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      damageSpace.addGoodsShelf(goodsShelf);
      damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());

      goodsShelfManagerOf(userContext).onNewInstanceCreated(userContext, goodsShelf);
      return present(userContext, damageSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingGoodsShelfProperties(
      RetailscmUserContext userContext,
      String damageSpaceId,
      String id,
      String location,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfDamageSpace(damageSpaceId);
    checkerOf(userContext).checkIdOfGoodsShelf(id);

    checkerOf(userContext).checkLocationOfGoodsShelf(location);

    checkerOf(userContext).throwExceptionIfHasErrors(DamageSpaceManagerException.class);
  }

  public DamageSpace updateGoodsShelfProperties(
      RetailscmUserContext userContext,
      String damageSpaceId,
      String id,
      String location,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingGoodsShelfProperties(
        userContext, damageSpaceId, id, location, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withGoodsShelfListList()
            .searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, tokens().is(), id)
            .done();

    DamageSpace damageSpaceToUpdate = loadDamageSpace(userContext, damageSpaceId, options);

    if (damageSpaceToUpdate.getGoodsShelfList().isEmpty()) {
      throw new DamageSpaceManagerException("GoodsShelf is NOT FOUND with id: '" + id + "'");
    }

    GoodsShelf item = damageSpaceToUpdate.getGoodsShelfList().first();
    beforeUpdateGoodsShelfProperties(userContext, item, damageSpaceId, id, location, tokensExpr);
    item.updateLocation(location);

    // checkParamsForAddingGoodsShelf(userContext,damageSpaceId,name, code, used,tokensExpr);
    DamageSpace damageSpace =
        saveDamageSpace(userContext, damageSpaceToUpdate, tokens().withGoodsShelfList().done());
    synchronized (damageSpace) {
      return present(userContext, damageSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateGoodsShelfProperties(
      RetailscmUserContext userContext,
      GoodsShelf item,
      String damageSpaceId,
      String id,
      String location,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected GoodsShelf createGoodsShelf(
      RetailscmUserContext userContext,
      String location,
      String storageSpaceId,
      String supplierSpaceId)
      throws Exception {

    GoodsShelf goodsShelf = new GoodsShelf();

    goodsShelf.setLocation(location);
    StorageSpace storageSpace = new StorageSpace();
    storageSpace.setId(storageSpaceId);
    goodsShelf.setStorageSpace(storageSpace);
    SupplierSpace supplierSpace = new SupplierSpace();
    supplierSpace.setId(supplierSpaceId);
    goodsShelf.setSupplierSpace(supplierSpace);
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
      String damageSpaceId,
      String goodsShelfIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfDamageSpace(damageSpaceId);
    for (String goodsShelfIdItem : goodsShelfIds) {
      checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(DamageSpaceManagerException.class);
  }

  public DamageSpace removeGoodsShelfList(
      RetailscmUserContext userContext,
      String damageSpaceId,
      String goodsShelfIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingGoodsShelfList(userContext, damageSpaceId, goodsShelfIds, tokensExpr);

    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
    synchronized (damageSpace) {
      // Will be good when the damageSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      damageSpaceDaoOf(userContext)
          .planToRemoveGoodsShelfList(damageSpace, goodsShelfIds, allTokens());
      damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
      deleteRelationListInGraph(userContext, damageSpace.getGoodsShelfList());
      return present(userContext, damageSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingGoodsShelf(
      RetailscmUserContext userContext,
      String damageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfDamageSpace(damageSpaceId);
    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(DamageSpaceManagerException.class);
  }

  public DamageSpace removeGoodsShelf(
      RetailscmUserContext userContext,
      String damageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingGoodsShelf(
        userContext, damageSpaceId, goodsShelfId, goodsShelfVersion, tokensExpr);

    GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
    synchronized (damageSpace) {
      // Will be good when the damageSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      damageSpace.removeGoodsShelf(goodsShelf);
      damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
      deleteRelationInGraph(userContext, goodsShelf);
      return present(userContext, damageSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingGoodsShelf(
      RetailscmUserContext userContext,
      String damageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfDamageSpace(damageSpaceId);
    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(DamageSpaceManagerException.class);
  }

  public DamageSpace copyGoodsShelfFrom(
      RetailscmUserContext userContext,
      String damageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingGoodsShelf(
        userContext, damageSpaceId, goodsShelfId, goodsShelfVersion, tokensExpr);

    GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
    synchronized (damageSpace) {
      // Will be good when the damageSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      goodsShelf.updateLastUpdateTime(userContext.now());

      damageSpace.copyGoodsShelfFrom(goodsShelf);
      damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());

      goodsShelfManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (GoodsShelf) damageSpace.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, damageSpace, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingGoodsShelf(
      RetailscmUserContext userContext,
      String damageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfDamageSpace(damageSpaceId);
    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);

    if (GoodsShelf.LOCATION_PROPERTY.equals(property)) {
      checkerOf(userContext).checkLocationOfGoodsShelf(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(DamageSpaceManagerException.class);
  }

  public DamageSpace updateGoodsShelf(
      RetailscmUserContext userContext,
      String damageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingGoodsShelf(
        userContext,
        damageSpaceId,
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

    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, loadTokens);

    synchronized (damageSpace) {
      // Will be good when the damageSpace loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // damageSpace.removeGoodsShelf( goodsShelf );
      // make changes to AcceleraterAccount.
      GoodsShelf goodsShelfIdVersionKey = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);

      GoodsShelf goodsShelf = damageSpace.findTheGoodsShelf(goodsShelfIdVersionKey);
      if (goodsShelf == null) {
        throw new DamageSpaceManagerException(goodsShelfId + " is NOT FOUND");
      }

      beforeUpdateGoodsShelf(
          userContext,
          goodsShelf,
          damageSpaceId,
          goodsShelfId,
          goodsShelfVersion,
          property,
          newValueExpr,
          tokensExpr);
      goodsShelf.changeProperty(property, newValueExpr);
      goodsShelf.updateLastUpdateTime(userContext.now());
      damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
      goodsShelfManagerOf(userContext).onUpdated(userContext, goodsShelf, this, "updateGoodsShelf");
      return present(userContext, damageSpace, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateGoodsShelf(
      RetailscmUserContext userContext,
      GoodsShelf existed,
      String damageSpaceId,
      String goodsShelfId,
      int goodsShelfVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, DamageSpace newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    damageSpaceDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   DamageSpace newDamageSpace = this.createDamageSpace(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newDamageSpace
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
    key.put(UserApp.APP_TYPE_PROPERTY, DamageSpace.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(RetailscmUserContext userContext, SmartList<DamageSpace> list)
      throws Exception {
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
    SmartList<DamageSpace> list =
        damageSpaceDaoOf(userContext)
            .findDamageSpaceByWarehouse(warehouseId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(DamageSpace.class);
    page.setContainerObject(Warehouse.withId(warehouseId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("残次货物存放区列表");
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
  public Object wxappview(RetailscmUserContext userContext, String damageSpaceId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    DamageSpace merchantObj = (DamageSpace) this.view(userContext, damageSpaceId);
    String merchantObjId = damageSpaceId;
    String linkToUrl = "damageSpaceManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "残次货物存放区" + "详情";
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
        MapUtil.put("id", "5-latitude")
            .put("fieldName", "latitude")
            .put("label", "纬度")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("latitude", merchantObj.getLatitude());

    propList.add(
        MapUtil.put("id", "6-longitude")
            .put("fieldName", "longitude")
            .put("label", "经度")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("longitude", merchantObj.getLongitude());

    propList.add(
        MapUtil.put("id", "7-warehouse")
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
            "goodsShelfManager/listByDamageSpace/" + merchantObjId + "/",
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
