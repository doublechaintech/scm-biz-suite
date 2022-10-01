package com.doublechaintech.retailscm.goodsshelf;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.damagespace.CandidateDamageSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.storagespace.CandidateStorageSpace;
import com.doublechaintech.retailscm.storagespace.StorageSpace;
import com.doublechaintech.retailscm.supplierspace.CandidateSupplierSpace;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
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

public class GoodsShelfManagerImpl extends CustomRetailscmCheckerManager
    implements GoodsShelfManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens = GoodsShelfTokens.start().withTokenFromListName(listName).done();
    GoodsShelf goodsShelf = (GoodsShelf) this.loadGoodsShelf(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = goodsShelf.collectReferencesFromLists();
    goodsShelfDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, goodsShelf, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new GoodsShelfGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "GoodsShelf";

  @Override
  public GoodsShelfDAO daoOf(RetailscmUserContext userContext) {
    return goodsShelfDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws GoodsShelfManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new GoodsShelfManagerException(message);
  }

  protected GoodsShelf saveGoodsShelf(
      RetailscmUserContext userContext, GoodsShelf goodsShelf, String[] tokensExpr)
      throws Exception {
    // return getGoodsShelfDAO().save(goodsShelf, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveGoodsShelf(userContext, goodsShelf, tokens);
  }

  protected GoodsShelf saveGoodsShelfDetail(RetailscmUserContext userContext, GoodsShelf goodsShelf)
      throws Exception {

    return saveGoodsShelf(userContext, goodsShelf, allTokens());
  }

  public GoodsShelf loadGoodsShelf(
      RetailscmUserContext userContext, String goodsShelfId, String[] tokensExpr) throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, tokens);
    // do some calc before sent to customer?
    return present(userContext, goodsShelf, tokens);
  }

  public GoodsShelf searchGoodsShelf(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, tokens);
    // do some calc before sent to customer?
    return present(userContext, goodsShelf, tokens);
  }

  protected GoodsShelf present(
      RetailscmUserContext userContext, GoodsShelf goodsShelf, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, goodsShelf, tokens);

    GoodsShelf goodsShelfToPresent = goodsShelfDaoOf(userContext).present(goodsShelf, tokens);

    List<BaseEntity> entityListToNaming = goodsShelfToPresent.collectReferencesFromLists();
    goodsShelfDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, goodsShelf, tokens);

    return goodsShelfToPresent;
  }

  public GoodsShelf loadGoodsShelfDetail(RetailscmUserContext userContext, String goodsShelfId)
      throws Exception {
    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
    return present(userContext, goodsShelf, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String goodsShelfId) throws Exception {
    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, viewTokens());
    markVisited(userContext, goodsShelf);
    return present(userContext, goodsShelf, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String goodsShelfId)
      throws Exception {
    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, viewTokens());
    goodsShelf.summarySuffix();
    markVisited(userContext, goodsShelf);
    return present(userContext, goodsShelf, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String goodsShelfId) throws Exception {
    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, analyzeTokens());
    markVisited(userContext, goodsShelf);
    return present(userContext, goodsShelf, analyzeTokens());
  }

  protected GoodsShelf saveGoodsShelf(
      RetailscmUserContext userContext, GoodsShelf goodsShelf, Map<String, Object> tokens)
      throws Exception {

    return goodsShelfDaoOf(userContext).save(goodsShelf, tokens);
  }

  protected GoodsShelf loadGoodsShelf(
      RetailscmUserContext userContext, String goodsShelfId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);

    return goodsShelfDaoOf(userContext).load(goodsShelfId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, GoodsShelf goodsShelf, Map<String, Object> tokens) {
    super.addActions(userContext, goodsShelf, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, GoodsShelf goodsShelf, Map<String, Object> tokens){

  @Override
  public List<GoodsShelf> searchGoodsShelfList(
      RetailscmUserContext ctx, GoodsShelfRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<GoodsShelf> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public GoodsShelf searchGoodsShelf(RetailscmUserContext ctx, GoodsShelfRequest pRequest) {
    pRequest.limit(0, 1);
    List<GoodsShelf> list = searchGoodsShelfList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public GoodsShelf createGoodsShelf(
      RetailscmUserContext userContext,
      String location,
      String storageSpaceId,
      String supplierSpaceId,
      String damageSpaceId)
      throws Exception {

    checkerOf(userContext).checkLocationOfGoodsShelf(location);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);

    GoodsShelf goodsShelf = createNewGoodsShelf();

    goodsShelf.setLocation(location);

    StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, emptyOptions());
    goodsShelf.setStorageSpace(storageSpace);

    SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, emptyOptions());
    goodsShelf.setSupplierSpace(supplierSpace);

    DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, emptyOptions());
    goodsShelf.setDamageSpace(damageSpace);

    goodsShelf.setLastUpdateTime(userContext.now());

    goodsShelf = saveGoodsShelf(userContext, goodsShelf, emptyOptions());

    onNewInstanceCreated(userContext, goodsShelf);
    return goodsShelf;
  }

  protected GoodsShelf createNewGoodsShelf() {

    return new GoodsShelf();
  }

  protected void checkParamsForUpdatingGoodsShelf(
      RetailscmUserContext userContext,
      String goodsShelfId,
      int goodsShelfVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);

    if (GoodsShelf.LOCATION_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLocationOfGoodsShelf(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf clone(RetailscmUserContext userContext, String fromGoodsShelfId)
      throws Exception {

    return goodsShelfDaoOf(userContext).clone(fromGoodsShelfId, this.allTokens());
  }

  public GoodsShelf internalSaveGoodsShelf(RetailscmUserContext userContext, GoodsShelf goodsShelf)
      throws Exception {
    return internalSaveGoodsShelf(userContext, goodsShelf, allTokens());
  }

  public GoodsShelf internalSaveGoodsShelf(
      RetailscmUserContext userContext, GoodsShelf goodsShelf, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingGoodsShelf(userContext, goodsShelfId, goodsShelfVersion, property,
    // newValueExpr, tokensExpr);

    synchronized (goodsShelf) {
      // will be good when the goodsShelf loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to GoodsShelf.
      if (goodsShelf.isChanged()) {
        goodsShelf.updateLastUpdateTime(userContext.now());
      }

      // checkerOf(userContext).checkAndFixGoodsShelf(goodsShelf);
      goodsShelf = saveGoodsShelf(userContext, goodsShelf, options);
      return goodsShelf;
    }
  }

  public GoodsShelf updateGoodsShelf(
      RetailscmUserContext userContext,
      String goodsShelfId,
      int goodsShelfVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingGoodsShelf(
        userContext, goodsShelfId, goodsShelfVersion, property, newValueExpr, tokensExpr);

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
    if (goodsShelf.getVersion() != goodsShelfVersion) {
      String message =
          "The target version("
              + goodsShelf.getVersion()
              + ") is not equals to version("
              + goodsShelfVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (goodsShelf) {
      // will be good when the goodsShelf loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to GoodsShelf.
      goodsShelf.updateLastUpdateTime(userContext.now());
      goodsShelf.changeProperty(property, newValueExpr);
      goodsShelf = saveGoodsShelf(userContext, goodsShelf, tokens().done());
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
      // return saveGoodsShelf(userContext, goodsShelf, tokens().done());
    }
  }

  public GoodsShelf updateGoodsShelfProperty(
      RetailscmUserContext userContext,
      String goodsShelfId,
      int goodsShelfVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingGoodsShelf(
        userContext, goodsShelfId, goodsShelfVersion, property, newValueExpr, tokensExpr);

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
    if (goodsShelf.getVersion() != goodsShelfVersion) {
      String message =
          "The target version("
              + goodsShelf.getVersion()
              + ") is not equals to version("
              + goodsShelfVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (goodsShelf) {
      // will be good when the goodsShelf loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to GoodsShelf.

      goodsShelf.changeProperty(property, newValueExpr);
      goodsShelf.updateLastUpdateTime(userContext.now());
      goodsShelf = saveGoodsShelf(userContext, goodsShelf, tokens().done());
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
      // return saveGoodsShelf(userContext, goodsShelf, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected GoodsShelfTokens tokens() {
    return GoodsShelfTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return GoodsShelfTokens.all();
  }

  protected Map<String, Object> analyzeTokens() {
    return tokens().allTokens().analyzeAllLists().done();
  }

  protected Map<String, Object> summaryTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> viewTokens() {
    return tokens()
        .allTokens()
        .sortGoodsShelfStockCountListWith(GoodsShelfStockCount.ID_PROPERTY, sortDesc())
        .sortGoodsAllocationListWith(GoodsAllocation.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return GoodsShelfTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherStorageSpace(
      RetailscmUserContext userContext, String goodsShelfId, String anotherStorageSpaceId)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext)
        .checkIdOfStorageSpace(anotherStorageSpaceId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf transferToAnotherStorageSpace(
      RetailscmUserContext userContext, String goodsShelfId, String anotherStorageSpaceId)
      throws Exception {
    checkParamsForTransferingAnotherStorageSpace(userContext, goodsShelfId, anotherStorageSpaceId);

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
    synchronized (goodsShelf) {
      // will be good when the goodsShelf loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      StorageSpace storageSpace =
          loadStorageSpace(userContext, anotherStorageSpaceId, emptyOptions());
      goodsShelf.updateStorageSpace(storageSpace);
      goodsShelf.updateLastUpdateTime(userContext.now());
      goodsShelf = saveGoodsShelf(userContext, goodsShelf, emptyOptions());

      return present(userContext, goodsShelf, allTokens());
    }
  }

  public CandidateStorageSpace requestCandidateStorageSpace(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateStorageSpace result = new CandidateStorageSpace();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("location");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<StorageSpace> candidateList =
        storageSpaceDaoOf(userContext)
            .requestCandidateStorageSpaceForGoodsShelf(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  protected void checkParamsForTransferingAnotherSupplierSpace(
      RetailscmUserContext userContext, String goodsShelfId, String anotherSupplierSpaceId)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext)
        .checkIdOfSupplierSpace(anotherSupplierSpaceId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf transferToAnotherSupplierSpace(
      RetailscmUserContext userContext, String goodsShelfId, String anotherSupplierSpaceId)
      throws Exception {
    checkParamsForTransferingAnotherSupplierSpace(
        userContext, goodsShelfId, anotherSupplierSpaceId);

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
    synchronized (goodsShelf) {
      // will be good when the goodsShelf loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      SupplierSpace supplierSpace =
          loadSupplierSpace(userContext, anotherSupplierSpaceId, emptyOptions());
      goodsShelf.updateSupplierSpace(supplierSpace);
      goodsShelf.updateLastUpdateTime(userContext.now());
      goodsShelf = saveGoodsShelf(userContext, goodsShelf, emptyOptions());

      return present(userContext, goodsShelf, allTokens());
    }
  }

  public CandidateSupplierSpace requestCandidateSupplierSpace(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateSupplierSpace result = new CandidateSupplierSpace();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("location");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<SupplierSpace> candidateList =
        supplierSpaceDaoOf(userContext)
            .requestCandidateSupplierSpaceForGoodsShelf(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  protected void checkParamsForTransferingAnotherDamageSpace(
      RetailscmUserContext userContext, String goodsShelfId, String anotherDamageSpaceId)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext)
        .checkIdOfDamageSpace(anotherDamageSpaceId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf transferToAnotherDamageSpace(
      RetailscmUserContext userContext, String goodsShelfId, String anotherDamageSpaceId)
      throws Exception {
    checkParamsForTransferingAnotherDamageSpace(userContext, goodsShelfId, anotherDamageSpaceId);

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
    synchronized (goodsShelf) {
      // will be good when the goodsShelf loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      DamageSpace damageSpace = loadDamageSpace(userContext, anotherDamageSpaceId, emptyOptions());
      goodsShelf.updateDamageSpace(damageSpace);
      goodsShelf.updateLastUpdateTime(userContext.now());
      goodsShelf = saveGoodsShelf(userContext, goodsShelf, emptyOptions());

      return present(userContext, goodsShelf, allTokens());
    }
  }

  public CandidateDamageSpace requestCandidateDamageSpace(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateDamageSpace result = new CandidateDamageSpace();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("location");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<DamageSpace> candidateList =
        damageSpaceDaoOf(userContext)
            .requestCandidateDamageSpaceForGoodsShelf(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected SupplierSpace loadSupplierSpace(
      RetailscmUserContext userContext, String newSupplierSpaceId, Map<String, Object> options)
      throws Exception {

    return supplierSpaceDaoOf(userContext).load(newSupplierSpaceId, options);
  }

  protected DamageSpace loadDamageSpace(
      RetailscmUserContext userContext, String newDamageSpaceId, Map<String, Object> options)
      throws Exception {

    return damageSpaceDaoOf(userContext).load(newDamageSpaceId, options);
  }

  protected StorageSpace loadStorageSpace(
      RetailscmUserContext userContext, String newStorageSpaceId, Map<String, Object> options)
      throws Exception {

    return storageSpaceDaoOf(userContext).load(newStorageSpaceId, options);
  }

  // --------------------------------------------------------------

  public GoodsShelf forgetByAll(
      RetailscmUserContext userContext, String goodsShelfId, int goodsShelfVersion)
      throws Exception {
    return forgetByAllInternal(userContext, goodsShelfId, goodsShelfVersion);
  }

  protected GoodsShelf forgetByAllInternal(
      RetailscmUserContext userContext, String goodsShelfId, int goodsShelfVersion)
      throws Exception {

    return goodsShelfDaoOf(userContext).disconnectFromAll(goodsShelfId, goodsShelfVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new GoodsShelfManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String title,
      Date countTime,
      String summary,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);

    checkerOf(userContext).checkTitleOfGoodsShelfStockCount(title);

    checkerOf(userContext).checkCountTimeOfGoodsShelfStockCount(countTime);

    checkerOf(userContext).checkSummaryOfGoodsShelfStockCount(summary);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf addGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String title,
      Date countTime,
      String summary,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingGoodsShelfStockCount(
        userContext, goodsShelfId, title, countTime, summary, tokensExpr);

    GoodsShelfStockCount goodsShelfStockCount =
        createGoodsShelfStockCount(userContext, title, countTime, summary);

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, emptyOptions());
    synchronized (goodsShelf) {
      // Will be good when the goodsShelf loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      goodsShelf.addGoodsShelfStockCount(goodsShelfStockCount);
      goodsShelf =
          saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsShelfStockCountList().done());

      goodsShelfStockCountManagerOf(userContext)
          .onNewInstanceCreated(userContext, goodsShelfStockCount);
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingGoodsShelfStockCountProperties(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String id,
      String title,
      Date countTime,
      String summary,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkIdOfGoodsShelfStockCount(id);

    checkerOf(userContext).checkTitleOfGoodsShelfStockCount(title);
    checkerOf(userContext).checkCountTimeOfGoodsShelfStockCount(countTime);
    checkerOf(userContext).checkSummaryOfGoodsShelfStockCount(summary);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf updateGoodsShelfStockCountProperties(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String id,
      String title,
      Date countTime,
      String summary,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingGoodsShelfStockCountProperties(
        userContext, goodsShelfId, id, title, countTime, summary, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withGoodsShelfStockCountListList()
            .searchGoodsShelfStockCountListWith(GoodsShelfStockCount.ID_PROPERTY, tokens().is(), id)
            .done();

    GoodsShelf goodsShelfToUpdate = loadGoodsShelf(userContext, goodsShelfId, options);

    if (goodsShelfToUpdate.getGoodsShelfStockCountList().isEmpty()) {
      throw new GoodsShelfManagerException(
          "GoodsShelfStockCount is NOT FOUND with id: '" + id + "'");
    }

    GoodsShelfStockCount item = goodsShelfToUpdate.getGoodsShelfStockCountList().first();
    beforeUpdateGoodsShelfStockCountProperties(
        userContext, item, goodsShelfId, id, title, countTime, summary, tokensExpr);
    item.updateTitle(title);
    item.updateCountTime(countTime);
    item.updateSummary(summary);

    // checkParamsForAddingGoodsShelfStockCount(userContext,goodsShelfId,name, code,
    // used,tokensExpr);
    GoodsShelf goodsShelf =
        saveGoodsShelf(
            userContext, goodsShelfToUpdate, tokens().withGoodsShelfStockCountList().done());
    synchronized (goodsShelf) {
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateGoodsShelfStockCountProperties(
      RetailscmUserContext userContext,
      GoodsShelfStockCount item,
      String goodsShelfId,
      String id,
      String title,
      Date countTime,
      String summary,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected GoodsShelfStockCount createGoodsShelfStockCount(
      RetailscmUserContext userContext, String title, Date countTime, String summary)
      throws Exception {

    GoodsShelfStockCount goodsShelfStockCount = new GoodsShelfStockCount();

    goodsShelfStockCount.setTitle(title);
    goodsShelfStockCount.setCountTime(countTime);
    goodsShelfStockCount.setSummary(summary);

    return goodsShelfStockCount;
  }

  protected GoodsShelfStockCount createIndexedGoodsShelfStockCount(String id, int version) {

    GoodsShelfStockCount goodsShelfStockCount = new GoodsShelfStockCount();
    goodsShelfStockCount.setId(id);
    goodsShelfStockCount.setVersion(version);
    return goodsShelfStockCount;
  }

  protected void checkParamsForRemovingGoodsShelfStockCountList(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsShelfStockCountIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    for (String goodsShelfStockCountIdItem : goodsShelfStockCountIds) {
      checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf removeGoodsShelfStockCountList(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsShelfStockCountIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingGoodsShelfStockCountList(
        userContext, goodsShelfId, goodsShelfStockCountIds, tokensExpr);

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
    synchronized (goodsShelf) {
      // Will be good when the goodsShelf loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      goodsShelfDaoOf(userContext)
          .planToRemoveGoodsShelfStockCountList(goodsShelf, goodsShelfStockCountIds, allTokens());
      goodsShelf =
          saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsShelfStockCountList().done());
      deleteRelationListInGraph(userContext, goodsShelf.getGoodsShelfStockCountList());
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
    checkerOf(userContext).checkVersionOfGoodsShelfStockCount(goodsShelfStockCountVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf removeGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingGoodsShelfStockCount(
        userContext, goodsShelfId, goodsShelfStockCountId, goodsShelfStockCountVersion, tokensExpr);

    GoodsShelfStockCount goodsShelfStockCount =
        createIndexedGoodsShelfStockCount(goodsShelfStockCountId, goodsShelfStockCountVersion);
    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
    synchronized (goodsShelf) {
      // Will be good when the goodsShelf loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      goodsShelf.removeGoodsShelfStockCount(goodsShelfStockCount);
      goodsShelf =
          saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsShelfStockCountList().done());
      deleteRelationInGraph(userContext, goodsShelfStockCount);
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
    checkerOf(userContext).checkVersionOfGoodsShelfStockCount(goodsShelfStockCountVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf copyGoodsShelfStockCountFrom(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingGoodsShelfStockCount(
        userContext, goodsShelfId, goodsShelfStockCountId, goodsShelfStockCountVersion, tokensExpr);

    GoodsShelfStockCount goodsShelfStockCount =
        createIndexedGoodsShelfStockCount(goodsShelfStockCountId, goodsShelfStockCountVersion);
    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
    synchronized (goodsShelf) {
      // Will be good when the goodsShelf loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      goodsShelf.copyGoodsShelfStockCountFrom(goodsShelfStockCount);
      goodsShelf =
          saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsShelfStockCountList().done());

      goodsShelfStockCountManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (GoodsShelfStockCount) goodsShelf.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
    checkerOf(userContext).checkVersionOfGoodsShelfStockCount(goodsShelfStockCountVersion);

    if (GoodsShelfStockCount.TITLE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkTitleOfGoodsShelfStockCount(parseString(newValueExpr));
    }

    if (GoodsShelfStockCount.COUNT_TIME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkCountTimeOfGoodsShelfStockCount(parseDate(newValueExpr));
    }

    if (GoodsShelfStockCount.SUMMARY_PROPERTY.equals(property)) {
      checkerOf(userContext).checkSummaryOfGoodsShelfStockCount(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf updateGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingGoodsShelfStockCount(
        userContext,
        goodsShelfId,
        goodsShelfStockCountId,
        goodsShelfStockCountVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withGoodsShelfStockCountList()
            .searchGoodsShelfStockCountListWith(
                GoodsShelfStockCount.ID_PROPERTY, tokens().equals(), goodsShelfStockCountId)
            .done();

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, loadTokens);

    synchronized (goodsShelf) {
      // Will be good when the goodsShelf loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // goodsShelf.removeGoodsShelfStockCount( goodsShelfStockCount );
      // make changes to AcceleraterAccount.
      GoodsShelfStockCount goodsShelfStockCountIdVersionKey =
          createIndexedGoodsShelfStockCount(goodsShelfStockCountId, goodsShelfStockCountVersion);

      GoodsShelfStockCount goodsShelfStockCount =
          goodsShelf.findTheGoodsShelfStockCount(goodsShelfStockCountIdVersionKey);
      if (goodsShelfStockCount == null) {
        throw new GoodsShelfManagerException(goodsShelfStockCountId + " is NOT FOUND");
      }

      beforeUpdateGoodsShelfStockCount(
          userContext,
          goodsShelfStockCount,
          goodsShelfId,
          goodsShelfStockCountId,
          goodsShelfStockCountVersion,
          property,
          newValueExpr,
          tokensExpr);
      goodsShelfStockCount.changeProperty(property, newValueExpr);

      goodsShelf =
          saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsShelfStockCountList().done());
      goodsShelfStockCountManagerOf(userContext)
          .onUpdated(userContext, goodsShelfStockCount, this, "updateGoodsShelfStockCount");
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateGoodsShelfStockCount(
      RetailscmUserContext userContext,
      GoodsShelfStockCount existed,
      String goodsShelfId,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  protected void checkParamsForAddingGoodsAllocation(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String location,
      BigDecimal latitude,
      BigDecimal longitude,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);

    checkerOf(userContext).checkLocationOfGoodsAllocation(location);

    checkerOf(userContext).checkLatitudeOfGoodsAllocation(latitude);

    checkerOf(userContext).checkLongitudeOfGoodsAllocation(longitude);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf addGoodsAllocation(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String location,
      BigDecimal latitude,
      BigDecimal longitude,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingGoodsAllocation(
        userContext, goodsShelfId, location, latitude, longitude, tokensExpr);

    GoodsAllocation goodsAllocation =
        createGoodsAllocation(userContext, location, latitude, longitude);

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, emptyOptions());
    synchronized (goodsShelf) {
      // Will be good when the goodsShelf loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      goodsShelf.addGoodsAllocation(goodsAllocation);
      goodsShelf =
          saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsAllocationList().done());

      goodsAllocationManagerOf(userContext).onNewInstanceCreated(userContext, goodsAllocation);
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingGoodsAllocationProperties(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String id,
      String location,
      BigDecimal latitude,
      BigDecimal longitude,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkIdOfGoodsAllocation(id);

    checkerOf(userContext).checkLocationOfGoodsAllocation(location);
    checkerOf(userContext).checkLatitudeOfGoodsAllocation(latitude);
    checkerOf(userContext).checkLongitudeOfGoodsAllocation(longitude);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf updateGoodsAllocationProperties(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String id,
      String location,
      BigDecimal latitude,
      BigDecimal longitude,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingGoodsAllocationProperties(
        userContext, goodsShelfId, id, location, latitude, longitude, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withGoodsAllocationListList()
            .searchGoodsAllocationListWith(GoodsAllocation.ID_PROPERTY, tokens().is(), id)
            .done();

    GoodsShelf goodsShelfToUpdate = loadGoodsShelf(userContext, goodsShelfId, options);

    if (goodsShelfToUpdate.getGoodsAllocationList().isEmpty()) {
      throw new GoodsShelfManagerException("GoodsAllocation is NOT FOUND with id: '" + id + "'");
    }

    GoodsAllocation item = goodsShelfToUpdate.getGoodsAllocationList().first();
    beforeUpdateGoodsAllocationProperties(
        userContext, item, goodsShelfId, id, location, latitude, longitude, tokensExpr);
    item.updateLocation(location);
    item.updateLatitude(latitude);
    item.updateLongitude(longitude);

    // checkParamsForAddingGoodsAllocation(userContext,goodsShelfId,name, code, used,tokensExpr);
    GoodsShelf goodsShelf =
        saveGoodsShelf(userContext, goodsShelfToUpdate, tokens().withGoodsAllocationList().done());
    synchronized (goodsShelf) {
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateGoodsAllocationProperties(
      RetailscmUserContext userContext,
      GoodsAllocation item,
      String goodsShelfId,
      String id,
      String location,
      BigDecimal latitude,
      BigDecimal longitude,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected GoodsAllocation createGoodsAllocation(
      RetailscmUserContext userContext, String location, BigDecimal latitude, BigDecimal longitude)
      throws Exception {

    GoodsAllocation goodsAllocation = new GoodsAllocation();

    goodsAllocation.setLocation(location);
    goodsAllocation.setLatitude(latitude);
    goodsAllocation.setLongitude(longitude);

    return goodsAllocation;
  }

  protected GoodsAllocation createIndexedGoodsAllocation(String id, int version) {

    GoodsAllocation goodsAllocation = new GoodsAllocation();
    goodsAllocation.setId(id);
    goodsAllocation.setVersion(version);
    return goodsAllocation;
  }

  protected void checkParamsForRemovingGoodsAllocationList(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsAllocationIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    for (String goodsAllocationIdItem : goodsAllocationIds) {
      checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf removeGoodsAllocationList(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsAllocationIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingGoodsAllocationList(
        userContext, goodsShelfId, goodsAllocationIds, tokensExpr);

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
    synchronized (goodsShelf) {
      // Will be good when the goodsShelf loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      goodsShelfDaoOf(userContext)
          .planToRemoveGoodsAllocationList(goodsShelf, goodsAllocationIds, allTokens());
      goodsShelf =
          saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsAllocationList().done());
      deleteRelationListInGraph(userContext, goodsShelf.getGoodsAllocationList());
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingGoodsAllocation(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsAllocationId,
      int goodsAllocationVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationId);
    checkerOf(userContext).checkVersionOfGoodsAllocation(goodsAllocationVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf removeGoodsAllocation(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsAllocationId,
      int goodsAllocationVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingGoodsAllocation(
        userContext, goodsShelfId, goodsAllocationId, goodsAllocationVersion, tokensExpr);

    GoodsAllocation goodsAllocation =
        createIndexedGoodsAllocation(goodsAllocationId, goodsAllocationVersion);
    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
    synchronized (goodsShelf) {
      // Will be good when the goodsShelf loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      goodsShelf.removeGoodsAllocation(goodsAllocation);
      goodsShelf =
          saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsAllocationList().done());
      deleteRelationInGraph(userContext, goodsAllocation);
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingGoodsAllocation(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsAllocationId,
      int goodsAllocationVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationId);
    checkerOf(userContext).checkVersionOfGoodsAllocation(goodsAllocationVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf copyGoodsAllocationFrom(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsAllocationId,
      int goodsAllocationVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingGoodsAllocation(
        userContext, goodsShelfId, goodsAllocationId, goodsAllocationVersion, tokensExpr);

    GoodsAllocation goodsAllocation =
        createIndexedGoodsAllocation(goodsAllocationId, goodsAllocationVersion);
    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
    synchronized (goodsShelf) {
      // Will be good when the goodsShelf loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      goodsShelf.copyGoodsAllocationFrom(goodsAllocation);
      goodsShelf =
          saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsAllocationList().done());

      goodsAllocationManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (GoodsAllocation) goodsShelf.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingGoodsAllocation(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsAllocationId,
      int goodsAllocationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
    checkerOf(userContext).checkIdOfGoodsAllocation(goodsAllocationId);
    checkerOf(userContext).checkVersionOfGoodsAllocation(goodsAllocationVersion);

    if (GoodsAllocation.LOCATION_PROPERTY.equals(property)) {
      checkerOf(userContext).checkLocationOfGoodsAllocation(parseString(newValueExpr));
    }

    if (GoodsAllocation.LATITUDE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkLatitudeOfGoodsAllocation(parseBigDecimal(newValueExpr));
    }

    if (GoodsAllocation.LONGITUDE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkLongitudeOfGoodsAllocation(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfManagerException.class);
  }

  public GoodsShelf updateGoodsAllocation(
      RetailscmUserContext userContext,
      String goodsShelfId,
      String goodsAllocationId,
      int goodsAllocationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingGoodsAllocation(
        userContext,
        goodsShelfId,
        goodsAllocationId,
        goodsAllocationVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withGoodsAllocationList()
            .searchGoodsAllocationListWith(
                GoodsAllocation.ID_PROPERTY, tokens().equals(), goodsAllocationId)
            .done();

    GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, loadTokens);

    synchronized (goodsShelf) {
      // Will be good when the goodsShelf loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // goodsShelf.removeGoodsAllocation( goodsAllocation );
      // make changes to AcceleraterAccount.
      GoodsAllocation goodsAllocationIdVersionKey =
          createIndexedGoodsAllocation(goodsAllocationId, goodsAllocationVersion);

      GoodsAllocation goodsAllocation =
          goodsShelf.findTheGoodsAllocation(goodsAllocationIdVersionKey);
      if (goodsAllocation == null) {
        throw new GoodsShelfManagerException(goodsAllocationId + " is NOT FOUND");
      }

      beforeUpdateGoodsAllocation(
          userContext,
          goodsAllocation,
          goodsShelfId,
          goodsAllocationId,
          goodsAllocationVersion,
          property,
          newValueExpr,
          tokensExpr);
      goodsAllocation.changeProperty(property, newValueExpr);

      goodsShelf =
          saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsAllocationList().done());
      goodsAllocationManagerOf(userContext)
          .onUpdated(userContext, goodsAllocation, this, "updateGoodsAllocation");
      return present(userContext, goodsShelf, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateGoodsAllocation(
      RetailscmUserContext userContext,
      GoodsAllocation existed,
      String goodsShelfId,
      String goodsAllocationId,
      int goodsAllocationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsShelf newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    goodsShelfDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   GoodsShelf newGoodsShelf = this.createGoodsShelf(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newGoodsShelf
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
    key.put(UserApp.APP_TYPE_PROPERTY, GoodsShelf.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(RetailscmUserContext userContext, SmartList<GoodsShelf> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<StorageSpace> storageSpaceList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, StorageSpace.class);
    userContext.getDAOGroup().enhanceList(storageSpaceList, StorageSpace.class);
    List<SupplierSpace> supplierSpaceList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SupplierSpace.class);
    userContext.getDAOGroup().enhanceList(supplierSpaceList, SupplierSpace.class);
    List<DamageSpace> damageSpaceList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, DamageSpace.class);
    userContext.getDAOGroup().enhanceList(damageSpaceList, DamageSpace.class);
  }

  public Object listByStorageSpace(RetailscmUserContext userContext, String storageSpaceId)
      throws Exception {
    return listPageByStorageSpace(userContext, storageSpaceId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByStorageSpace(
      RetailscmUserContext userContext, String storageSpaceId, int start, int count)
      throws Exception {
    SmartList<GoodsShelf> list =
        goodsShelfDaoOf(userContext)
            .findGoodsShelfByStorageSpace(storageSpaceId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(GoodsShelf.class);
    page.setContainerObject(StorageSpace.withId(storageSpaceId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("货架列表");
    page.setRequestName("listByStorageSpace");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(
            String.format("%s/listByStorageSpace/%s/", getBeanName(), storageSpaceId)));

    page.assemblerContent(userContext, "listByStorageSpace");
    return page.doRender(userContext);
  }

  public Object listBySupplierSpace(RetailscmUserContext userContext, String supplierSpaceId)
      throws Exception {
    return listPageBySupplierSpace(userContext, supplierSpaceId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageBySupplierSpace(
      RetailscmUserContext userContext, String supplierSpaceId, int start, int count)
      throws Exception {
    SmartList<GoodsShelf> list =
        goodsShelfDaoOf(userContext)
            .findGoodsShelfBySupplierSpace(supplierSpaceId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(GoodsShelf.class);
    page.setContainerObject(SupplierSpace.withId(supplierSpaceId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("货架列表");
    page.setRequestName("listBySupplierSpace");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(
            String.format("%s/listBySupplierSpace/%s/", getBeanName(), supplierSpaceId)));

    page.assemblerContent(userContext, "listBySupplierSpace");
    return page.doRender(userContext);
  }

  public Object listByDamageSpace(RetailscmUserContext userContext, String damageSpaceId)
      throws Exception {
    return listPageByDamageSpace(userContext, damageSpaceId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByDamageSpace(
      RetailscmUserContext userContext, String damageSpaceId, int start, int count)
      throws Exception {
    SmartList<GoodsShelf> list =
        goodsShelfDaoOf(userContext)
            .findGoodsShelfByDamageSpace(damageSpaceId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(GoodsShelf.class);
    page.setContainerObject(DamageSpace.withId(damageSpaceId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("货架列表");
    page.setRequestName("listByDamageSpace");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(
            String.format("%s/listByDamageSpace/%s/", getBeanName(), damageSpaceId)));

    page.assemblerContent(userContext, "listByDamageSpace");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String goodsShelfId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    GoodsShelf merchantObj = (GoodsShelf) this.view(userContext, goodsShelfId);
    String merchantObjId = goodsShelfId;
    String linkToUrl = "goodsShelfManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "货架" + "详情";
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
        MapUtil.put("id", "3-storageSpace")
            .put("fieldName", "storageSpace")
            .put("label", "存货区")
            .put("type", "auto")
            .put("linkToUrl", "storageSpaceManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
            .into_map());
    result.put("storageSpace", merchantObj.getStorageSpace());

    propList.add(
        MapUtil.put("id", "4-supplierSpace")
            .put("fieldName", "supplierSpace")
            .put("label", "供应商的空间")
            .put("type", "auto")
            .put("linkToUrl", "supplierSpaceManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
            .into_map());
    result.put("supplierSpace", merchantObj.getSupplierSpace());

    propList.add(
        MapUtil.put("id", "5-damageSpace")
            .put("fieldName", "damageSpace")
            .put("label", "残次货物存放区")
            .put("type", "auto")
            .put("linkToUrl", "damageSpaceManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
            .into_map());
    result.put("damageSpace", merchantObj.getDamageSpace());

    propList.add(
        MapUtil.put("id", "6-lastUpdateTime")
            .put("fieldName", "lastUpdateTime")
            .put("label", "更新于")
            .put("type", "datetime")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

    // 处理 sectionList

    // 处理Section：goodsShelfStockCountListSection
    Map goodsShelfStockCountListSection =
        ListofUtils.buildSection(
            "goodsShelfStockCountListSection",
            "库存盘点清单",
            null,
            "",
            "__no_group",
            "goodsShelfStockCountManager/listByShelf/" + merchantObjId + "/",
            "auto");
    sections.add(goodsShelfStockCountListSection);

    result.put(
        "goodsShelfStockCountListSection",
        ListofUtils.toShortList(merchantObj.getGoodsShelfStockCountList(), "goodsShelfStockCount"));

    // 处理Section：goodsAllocationListSection
    Map goodsAllocationListSection =
        ListofUtils.buildSection(
            "goodsAllocationListSection",
            "货物分配列表",
            null,
            "",
            "__no_group",
            "goodsAllocationManager/listByGoodsShelf/" + merchantObjId + "/",
            "auto");
    sections.add(goodsAllocationListSection);

    result.put(
        "goodsAllocationListSection",
        ListofUtils.toShortList(merchantObj.getGoodsAllocationList(), "goodsAllocation"));

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
