package com.doublechaintech.retailscm.catalog;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.catalog.Catalog;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;
import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
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

public class CatalogManagerImpl extends CustomRetailscmCheckerManager
    implements CatalogManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens = CatalogTokens.start().withTokenFromListName(listName).done();
    Catalog catalog = (Catalog) this.loadCatalog(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = catalog.collectReferencesFromLists();
    catalogDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, catalog, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new CatalogGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "Catalog";

  @Override
  public CatalogDAO daoOf(RetailscmUserContext userContext) {
    return catalogDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws CatalogManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new CatalogManagerException(message);
  }

  protected Catalog saveCatalog(
      RetailscmUserContext userContext, Catalog catalog, String[] tokensExpr) throws Exception {
    // return getCatalogDAO().save(catalog, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveCatalog(userContext, catalog, tokens);
  }

  protected Catalog saveCatalogDetail(RetailscmUserContext userContext, Catalog catalog)
      throws Exception {

    return saveCatalog(userContext, catalog, allTokens());
  }

  public Catalog loadCatalog(
      RetailscmUserContext userContext, String catalogId, String[] tokensExpr) throws Exception {

    checkerOf(userContext).checkIdOfCatalog(catalogId);

    checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    Catalog catalog = loadCatalog(userContext, catalogId, tokens);
    // do some calc before sent to customer?
    return present(userContext, catalog, tokens);
  }

  public Catalog searchCatalog(
      RetailscmUserContext userContext, String catalogId, String textToSearch, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCatalog(catalogId);

    checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    Catalog catalog = loadCatalog(userContext, catalogId, tokens);
    // do some calc before sent to customer?
    return present(userContext, catalog, tokens);
  }

  protected Catalog present(
      RetailscmUserContext userContext, Catalog catalog, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, catalog, tokens);

    Catalog catalogToPresent = catalogDaoOf(userContext).present(catalog, tokens);

    List<BaseEntity> entityListToNaming = catalogToPresent.collectReferencesFromLists();
    catalogDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, catalog, tokens);

    return catalogToPresent;
  }

  public Catalog loadCatalogDetail(RetailscmUserContext userContext, String catalogId)
      throws Exception {
    Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
    return present(userContext, catalog, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String catalogId) throws Exception {
    Catalog catalog = loadCatalog(userContext, catalogId, viewTokens());
    markVisited(userContext, catalog);
    return present(userContext, catalog, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String catalogId) throws Exception {
    Catalog catalog = loadCatalog(userContext, catalogId, viewTokens());
    catalog.summarySuffix();
    markVisited(userContext, catalog);
    return present(userContext, catalog, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String catalogId) throws Exception {
    Catalog catalog = loadCatalog(userContext, catalogId, analyzeTokens());
    markVisited(userContext, catalog);
    return present(userContext, catalog, analyzeTokens());
  }

  protected Catalog saveCatalog(
      RetailscmUserContext userContext, Catalog catalog, Map<String, Object> tokens)
      throws Exception {

    return catalogDaoOf(userContext).save(catalog, tokens);
  }

  protected Catalog loadCatalog(
      RetailscmUserContext userContext, String catalogId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfCatalog(catalogId);

    checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);

    return catalogDaoOf(userContext).load(catalogId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, Catalog catalog, Map<String, Object> tokens) {
    super.addActions(userContext, catalog, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, Catalog catalog, Map<String, Object> tokens){

  @Override
  public List<Catalog> searchCatalogList(RetailscmUserContext ctx, CatalogRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<Catalog> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public Catalog searchCatalog(RetailscmUserContext ctx, CatalogRequest pRequest) {
    pRequest.limit(0, 1);
    List<Catalog> list = searchCatalogList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public Catalog createCatalog(
      RetailscmUserContext userContext,
      String name,
      String ownerId,
      int subCount,
      BigDecimal amount)
      throws Exception {

    checkerOf(userContext).checkNameOfCatalog(name);
    checkerOf(userContext).checkSubCountOfCatalog(subCount);
    checkerOf(userContext).checkAmountOfCatalog(amount);

    checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);

    Catalog catalog = createNewCatalog();

    catalog.setName(name);

    RetailStoreCountryCenter owner =
        loadRetailStoreCountryCenter(userContext, ownerId, emptyOptions());
    catalog.setOwner(owner);

    catalog.setSubCount(subCount);
    catalog.setAmount(amount);

    catalog = saveCatalog(userContext, catalog, emptyOptions());

    onNewInstanceCreated(userContext, catalog);
    return catalog;
  }

  protected Catalog createNewCatalog() {

    return new Catalog();
  }

  protected void checkParamsForUpdatingCatalog(
      RetailscmUserContext userContext,
      String catalogId,
      int catalogVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCatalog(catalogId);
    checkerOf(userContext).checkVersionOfCatalog(catalogVersion);

    if (Catalog.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfCatalog(parseString(newValueExpr));
    }

    if (Catalog.SUB_COUNT_PROPERTY.equals(property)) {

      checkerOf(userContext).checkSubCountOfCatalog(parseInt(newValueExpr));
    }
    if (Catalog.AMOUNT_PROPERTY.equals(property)) {

      checkerOf(userContext).checkAmountOfCatalog(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);
  }

  public Catalog clone(RetailscmUserContext userContext, String fromCatalogId) throws Exception {

    return catalogDaoOf(userContext).clone(fromCatalogId, this.allTokens());
  }

  public Catalog internalSaveCatalog(RetailscmUserContext userContext, Catalog catalog)
      throws Exception {
    return internalSaveCatalog(userContext, catalog, allTokens());
  }

  public Catalog internalSaveCatalog(
      RetailscmUserContext userContext, Catalog catalog, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingCatalog(userContext, catalogId, catalogVersion, property, newValueExpr,
    // tokensExpr);

    synchronized (catalog) {
      // will be good when the catalog loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to Catalog.
      if (catalog.isChanged()) {}

      // checkerOf(userContext).checkAndFixCatalog(catalog);
      catalog = saveCatalog(userContext, catalog, options);
      return catalog;
    }
  }

  public Catalog updateCatalog(
      RetailscmUserContext userContext,
      String catalogId,
      int catalogVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingCatalog(
        userContext, catalogId, catalogVersion, property, newValueExpr, tokensExpr);

    Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
    if (catalog.getVersion() != catalogVersion) {
      String message =
          "The target version("
              + catalog.getVersion()
              + ") is not equals to version("
              + catalogVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (catalog) {
      // will be good when the catalog loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to Catalog.

      catalog.changeProperty(property, newValueExpr);
      catalog = saveCatalog(userContext, catalog, tokens().done());
      return present(userContext, catalog, mergedAllTokens(tokensExpr));
      // return saveCatalog(userContext, catalog, tokens().done());
    }
  }

  public Catalog updateCatalogProperty(
      RetailscmUserContext userContext,
      String catalogId,
      int catalogVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingCatalog(
        userContext, catalogId, catalogVersion, property, newValueExpr, tokensExpr);

    Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
    if (catalog.getVersion() != catalogVersion) {
      String message =
          "The target version("
              + catalog.getVersion()
              + ") is not equals to version("
              + catalogVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (catalog) {
      // will be good when the catalog loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to Catalog.

      catalog.changeProperty(property, newValueExpr);

      catalog = saveCatalog(userContext, catalog, tokens().done());
      return present(userContext, catalog, mergedAllTokens(tokensExpr));
      // return saveCatalog(userContext, catalog, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected CatalogTokens tokens() {
    return CatalogTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return CatalogTokens.all();
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
        .sortLevelOneCategoryListWith(LevelOneCategory.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return CatalogTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherOwner(
      RetailscmUserContext userContext, String catalogId, String anotherOwnerId) throws Exception {

    checkerOf(userContext).checkIdOfCatalog(catalogId);
    checkerOf(userContext)
        .checkIdOfRetailStoreCountryCenter(anotherOwnerId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);
  }

  public Catalog transferToAnotherOwner(
      RetailscmUserContext userContext, String catalogId, String anotherOwnerId) throws Exception {
    checkParamsForTransferingAnotherOwner(userContext, catalogId, anotherOwnerId);

    Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
    synchronized (catalog) {
      // will be good when the catalog loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreCountryCenter owner =
          loadRetailStoreCountryCenter(userContext, anotherOwnerId, emptyOptions());
      catalog.updateOwner(owner);

      catalog = saveCatalog(userContext, catalog, emptyOptions());

      return present(userContext, catalog, allTokens());
    }
  }

  public CandidateRetailStoreCountryCenter requestCandidateOwner(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<RetailStoreCountryCenter> candidateList =
        retailStoreCountryCenterDaoOf(userContext)
            .requestCandidateRetailStoreCountryCenterForCatalog(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected RetailStoreCountryCenter loadRetailStoreCountryCenter(
      RetailscmUserContext userContext, String newOwnerId, Map<String, Object> options)
      throws Exception {

    return retailStoreCountryCenterDaoOf(userContext).load(newOwnerId, options);
  }

  // --------------------------------------------------------------

  public Catalog forgetByAll(RetailscmUserContext userContext, String catalogId, int catalogVersion)
      throws Exception {
    return forgetByAllInternal(userContext, catalogId, catalogVersion);
  }

  protected Catalog forgetByAllInternal(
      RetailscmUserContext userContext, String catalogId, int catalogVersion) throws Exception {

    return catalogDaoOf(userContext).disconnectFromAll(catalogId, catalogVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new CatalogManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingLevelOneCategory(
      RetailscmUserContext userContext, String catalogId, String name, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCatalog(catalogId);

    checkerOf(userContext).checkNameOfLevelOneCategory(name);

    checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);
  }

  public Catalog addLevelOneCategory(
      RetailscmUserContext userContext, String catalogId, String name, String[] tokensExpr)
      throws Exception {
    checkParamsForAddingLevelOneCategory(userContext, catalogId, name, tokensExpr);

    LevelOneCategory levelOneCategory = createLevelOneCategory(userContext, name);

    Catalog catalog = loadCatalog(userContext, catalogId, emptyOptions());
    synchronized (catalog) {
      // Will be good when the catalog loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      catalog.addLevelOneCategory(levelOneCategory);
      catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());

      levelOneCategoryManagerOf(userContext).onNewInstanceCreated(userContext, levelOneCategory);
      return present(userContext, catalog, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingLevelOneCategoryProperties(
      RetailscmUserContext userContext,
      String catalogId,
      String id,
      String name,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCatalog(catalogId);
    checkerOf(userContext).checkIdOfLevelOneCategory(id);

    checkerOf(userContext).checkNameOfLevelOneCategory(name);

    checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);
  }

  public Catalog updateLevelOneCategoryProperties(
      RetailscmUserContext userContext,
      String catalogId,
      String id,
      String name,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingLevelOneCategoryProperties(userContext, catalogId, id, name, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withLevelOneCategoryListList()
            .searchLevelOneCategoryListWith(LevelOneCategory.ID_PROPERTY, tokens().is(), id)
            .done();

    Catalog catalogToUpdate = loadCatalog(userContext, catalogId, options);

    if (catalogToUpdate.getLevelOneCategoryList().isEmpty()) {
      throw new CatalogManagerException("LevelOneCategory is NOT FOUND with id: '" + id + "'");
    }

    LevelOneCategory item = catalogToUpdate.getLevelOneCategoryList().first();
    beforeUpdateLevelOneCategoryProperties(userContext, item, catalogId, id, name, tokensExpr);
    item.updateName(name);

    // checkParamsForAddingLevelOneCategory(userContext,catalogId,name, code, used,tokensExpr);
    Catalog catalog =
        saveCatalog(userContext, catalogToUpdate, tokens().withLevelOneCategoryList().done());
    synchronized (catalog) {
      return present(userContext, catalog, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateLevelOneCategoryProperties(
      RetailscmUserContext userContext,
      LevelOneCategory item,
      String catalogId,
      String id,
      String name,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected LevelOneCategory createLevelOneCategory(RetailscmUserContext userContext, String name)
      throws Exception {

    LevelOneCategory levelOneCategory = new LevelOneCategory();

    levelOneCategory.setName(name);

    return levelOneCategory;
  }

  protected LevelOneCategory createIndexedLevelOneCategory(String id, int version) {

    LevelOneCategory levelOneCategory = new LevelOneCategory();
    levelOneCategory.setId(id);
    levelOneCategory.setVersion(version);
    return levelOneCategory;
  }

  protected void checkParamsForRemovingLevelOneCategoryList(
      RetailscmUserContext userContext,
      String catalogId,
      String levelOneCategoryIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCatalog(catalogId);
    for (String levelOneCategoryIdItem : levelOneCategoryIds) {
      checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);
  }

  public Catalog removeLevelOneCategoryList(
      RetailscmUserContext userContext,
      String catalogId,
      String levelOneCategoryIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingLevelOneCategoryList(
        userContext, catalogId, levelOneCategoryIds, tokensExpr);

    Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
    synchronized (catalog) {
      // Will be good when the catalog loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      catalogDaoOf(userContext)
          .planToRemoveLevelOneCategoryList(catalog, levelOneCategoryIds, allTokens());
      catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
      deleteRelationListInGraph(userContext, catalog.getLevelOneCategoryList());
      return present(userContext, catalog, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingLevelOneCategory(
      RetailscmUserContext userContext,
      String catalogId,
      String levelOneCategoryId,
      int levelOneCategoryVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCatalog(catalogId);
    checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
    checkerOf(userContext).checkVersionOfLevelOneCategory(levelOneCategoryVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);
  }

  public Catalog removeLevelOneCategory(
      RetailscmUserContext userContext,
      String catalogId,
      String levelOneCategoryId,
      int levelOneCategoryVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingLevelOneCategory(
        userContext, catalogId, levelOneCategoryId, levelOneCategoryVersion, tokensExpr);

    LevelOneCategory levelOneCategory =
        createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
    Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
    synchronized (catalog) {
      // Will be good when the catalog loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      catalog.removeLevelOneCategory(levelOneCategory);
      catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
      deleteRelationInGraph(userContext, levelOneCategory);
      return present(userContext, catalog, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingLevelOneCategory(
      RetailscmUserContext userContext,
      String catalogId,
      String levelOneCategoryId,
      int levelOneCategoryVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCatalog(catalogId);
    checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
    checkerOf(userContext).checkVersionOfLevelOneCategory(levelOneCategoryVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);
  }

  public Catalog copyLevelOneCategoryFrom(
      RetailscmUserContext userContext,
      String catalogId,
      String levelOneCategoryId,
      int levelOneCategoryVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingLevelOneCategory(
        userContext, catalogId, levelOneCategoryId, levelOneCategoryVersion, tokensExpr);

    LevelOneCategory levelOneCategory =
        createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);
    Catalog catalog = loadCatalog(userContext, catalogId, allTokens());
    synchronized (catalog) {
      // Will be good when the catalog loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      catalog.copyLevelOneCategoryFrom(levelOneCategory);
      catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());

      levelOneCategoryManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (LevelOneCategory) catalog.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, catalog, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingLevelOneCategory(
      RetailscmUserContext userContext,
      String catalogId,
      String levelOneCategoryId,
      int levelOneCategoryVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfCatalog(catalogId);
    checkerOf(userContext).checkIdOfLevelOneCategory(levelOneCategoryId);
    checkerOf(userContext).checkVersionOfLevelOneCategory(levelOneCategoryVersion);

    if (LevelOneCategory.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfLevelOneCategory(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(CatalogManagerException.class);
  }

  public Catalog updateLevelOneCategory(
      RetailscmUserContext userContext,
      String catalogId,
      String levelOneCategoryId,
      int levelOneCategoryVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingLevelOneCategory(
        userContext,
        catalogId,
        levelOneCategoryId,
        levelOneCategoryVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withLevelOneCategoryList()
            .searchLevelOneCategoryListWith(
                LevelOneCategory.ID_PROPERTY, tokens().equals(), levelOneCategoryId)
            .done();

    Catalog catalog = loadCatalog(userContext, catalogId, loadTokens);

    synchronized (catalog) {
      // Will be good when the catalog loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // catalog.removeLevelOneCategory( levelOneCategory );
      // make changes to AcceleraterAccount.
      LevelOneCategory levelOneCategoryIdVersionKey =
          createIndexedLevelOneCategory(levelOneCategoryId, levelOneCategoryVersion);

      LevelOneCategory levelOneCategory =
          catalog.findTheLevelOneCategory(levelOneCategoryIdVersionKey);
      if (levelOneCategory == null) {
        throw new CatalogManagerException(levelOneCategoryId + " is NOT FOUND");
      }

      beforeUpdateLevelOneCategory(
          userContext,
          levelOneCategory,
          catalogId,
          levelOneCategoryId,
          levelOneCategoryVersion,
          property,
          newValueExpr,
          tokensExpr);
      levelOneCategory.changeProperty(property, newValueExpr);

      catalog = saveCatalog(userContext, catalog, tokens().withLevelOneCategoryList().done());
      levelOneCategoryManagerOf(userContext)
          .onUpdated(userContext, levelOneCategory, this, "updateLevelOneCategory");
      return present(userContext, catalog, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateLevelOneCategory(
      RetailscmUserContext userContext,
      LevelOneCategory existed,
      String catalogId,
      String levelOneCategoryId,
      int levelOneCategoryVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, Catalog newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    catalogDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   Catalog newCatalog = this.createCatalog(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newCatalog
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
    key.put(UserApp.APP_TYPE_PROPERTY, Catalog.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(RetailscmUserContext userContext, SmartList<Catalog> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<RetailStoreCountryCenter> ownerList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, RetailStoreCountryCenter.class);
    userContext.getDAOGroup().enhanceList(ownerList, RetailStoreCountryCenter.class);
  }

  public Object listByOwner(RetailscmUserContext userContext, String ownerId) throws Exception {
    return listPageByOwner(userContext, ownerId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByOwner(
      RetailscmUserContext userContext, String ownerId, int start, int count) throws Exception {
    SmartList<Catalog> list =
        catalogDaoOf(userContext).findCatalogByOwner(ownerId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(Catalog.class);
    page.setContainerObject(RetailStoreCountryCenter.withId(ownerId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("目录列表");
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
  public Object wxappview(RetailscmUserContext userContext, String catalogId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    Catalog merchantObj = (Catalog) this.view(userContext, catalogId);
    String merchantObjId = catalogId;
    String linkToUrl = "catalogManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "目录" + "详情";
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
        MapUtil.put("id", "3-owner")
            .put("fieldName", "owner")
            .put("label", "业主")
            .put("type", "auto")
            .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("owner", merchantObj.getOwner());

    propList.add(
        MapUtil.put("id", "4-subCount")
            .put("fieldName", "subCount")
            .put("label", "子数")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("subCount", merchantObj.getSubCount());

    propList.add(
        MapUtil.put("id", "5-amount")
            .put("fieldName", "amount")
            .put("label", "金额")
            .put("type", "money")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("amount", merchantObj.getAmount());

    // 处理 sectionList

    // 处理Section：levelOneCategoryListSection
    Map levelOneCategoryListSection =
        ListofUtils.buildSection(
            "levelOneCategoryListSection",
            "一级类别列表",
            null,
            "",
            "__no_group",
            "levelOneCategoryManager/listByCatalog/" + merchantObjId + "/",
            "auto");
    sections.add(levelOneCategoryListSection);

    result.put(
        "levelOneCategoryListSection",
        ListofUtils.toShortList(merchantObj.getLevelOneCategoryList(), "levelOneCategory"));

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
