package com.doublechaintech.retailscm.supplierproduct;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.goodssupplier.CandidateGoodsSupplier;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;
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

public class SupplierProductManagerImpl extends CustomRetailscmCheckerManager
    implements SupplierProductManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        SupplierProductTokens.start().withTokenFromListName(listName).done();
    SupplierProduct supplierProduct =
        (SupplierProduct) this.loadSupplierProduct(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = supplierProduct.collectReferencesFromLists();
    supplierProductDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, supplierProduct, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new SupplierProductGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "SupplierProduct";

  @Override
  public SupplierProductDAO daoOf(RetailscmUserContext userContext) {
    return supplierProductDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws SupplierProductManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new SupplierProductManagerException(message);
  }

  protected SupplierProduct saveSupplierProduct(
      RetailscmUserContext userContext, SupplierProduct supplierProduct, String[] tokensExpr)
      throws Exception {
    // return getSupplierProductDAO().save(supplierProduct, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveSupplierProduct(userContext, supplierProduct, tokens);
  }

  protected SupplierProduct saveSupplierProductDetail(
      RetailscmUserContext userContext, SupplierProduct supplierProduct) throws Exception {

    return saveSupplierProduct(userContext, supplierProduct, allTokens());
  }

  public SupplierProduct loadSupplierProduct(
      RetailscmUserContext userContext, String supplierProductId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);

    checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, tokens);
    // do some calc before sent to customer?
    return present(userContext, supplierProduct, tokens);
  }

  public SupplierProduct searchSupplierProduct(
      RetailscmUserContext userContext,
      String supplierProductId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);

    checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    SupplierProduct supplierProduct = loadSupplierProduct(userContext, supplierProductId, tokens);
    // do some calc before sent to customer?
    return present(userContext, supplierProduct, tokens);
  }

  protected SupplierProduct present(
      RetailscmUserContext userContext, SupplierProduct supplierProduct, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, supplierProduct, tokens);

    SupplierProduct supplierProductToPresent =
        supplierProductDaoOf(userContext).present(supplierProduct, tokens);

    List<BaseEntity> entityListToNaming = supplierProductToPresent.collectReferencesFromLists();
    supplierProductDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, supplierProduct, tokens);

    return supplierProductToPresent;
  }

  public SupplierProduct loadSupplierProductDetail(
      RetailscmUserContext userContext, String supplierProductId) throws Exception {
    SupplierProduct supplierProduct =
        loadSupplierProduct(userContext, supplierProductId, allTokens());
    return present(userContext, supplierProduct, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String supplierProductId) throws Exception {
    SupplierProduct supplierProduct =
        loadSupplierProduct(userContext, supplierProductId, viewTokens());
    markVisited(userContext, supplierProduct);
    return present(userContext, supplierProduct, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String supplierProductId)
      throws Exception {
    SupplierProduct supplierProduct =
        loadSupplierProduct(userContext, supplierProductId, viewTokens());
    supplierProduct.summarySuffix();
    markVisited(userContext, supplierProduct);
    return present(userContext, supplierProduct, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String supplierProductId)
      throws Exception {
    SupplierProduct supplierProduct =
        loadSupplierProduct(userContext, supplierProductId, analyzeTokens());
    markVisited(userContext, supplierProduct);
    return present(userContext, supplierProduct, analyzeTokens());
  }

  protected SupplierProduct saveSupplierProduct(
      RetailscmUserContext userContext, SupplierProduct supplierProduct, Map<String, Object> tokens)
      throws Exception {

    return supplierProductDaoOf(userContext).save(supplierProduct, tokens);
  }

  protected SupplierProduct loadSupplierProduct(
      RetailscmUserContext userContext, String supplierProductId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);

    checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);

    return supplierProductDaoOf(userContext).load(supplierProductId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      SupplierProduct supplierProduct,
      Map<String, Object> tokens) {
    super.addActions(userContext, supplierProduct, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, SupplierProduct supplierProduct, Map<String, Object> tokens){

  @Override
  public List<SupplierProduct> searchSupplierProductList(
      RetailscmUserContext ctx, SupplierProductRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<SupplierProduct> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public SupplierProduct searchSupplierProduct(
      RetailscmUserContext ctx, SupplierProductRequest pRequest) {
    pRequest.limit(0, 1);
    List<SupplierProduct> list = searchSupplierProductList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public SupplierProduct createSupplierProduct(
      RetailscmUserContext userContext,
      String productName,
      String productDescription,
      String productUnit,
      String supplierId)
      throws Exception {

    checkerOf(userContext).checkProductNameOfSupplierProduct(productName);
    checkerOf(userContext).checkProductDescriptionOfSupplierProduct(productDescription);
    checkerOf(userContext).checkProductUnitOfSupplierProduct(productUnit);

    checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);

    SupplierProduct supplierProduct = createNewSupplierProduct();

    supplierProduct.setProductName(productName);
    supplierProduct.setProductDescription(productDescription);
    supplierProduct.setProductUnit(productUnit);

    GoodsSupplier supplier = loadGoodsSupplier(userContext, supplierId, emptyOptions());
    supplierProduct.setSupplier(supplier);

    supplierProduct = saveSupplierProduct(userContext, supplierProduct, emptyOptions());

    onNewInstanceCreated(userContext, supplierProduct);
    return supplierProduct;
  }

  protected SupplierProduct createNewSupplierProduct() {

    return new SupplierProduct();
  }

  protected void checkParamsForUpdatingSupplierProduct(
      RetailscmUserContext userContext,
      String supplierProductId,
      int supplierProductVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
    checkerOf(userContext).checkVersionOfSupplierProduct(supplierProductVersion);

    if (SupplierProduct.PRODUCT_NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkProductNameOfSupplierProduct(parseString(newValueExpr));
    }
    if (SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY.equals(property)) {

      checkerOf(userContext).checkProductDescriptionOfSupplierProduct(parseString(newValueExpr));
    }
    if (SupplierProduct.PRODUCT_UNIT_PROPERTY.equals(property)) {

      checkerOf(userContext).checkProductUnitOfSupplierProduct(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);
  }

  public SupplierProduct clone(RetailscmUserContext userContext, String fromSupplierProductId)
      throws Exception {

    return supplierProductDaoOf(userContext).clone(fromSupplierProductId, this.allTokens());
  }

  public SupplierProduct internalSaveSupplierProduct(
      RetailscmUserContext userContext, SupplierProduct supplierProduct) throws Exception {
    return internalSaveSupplierProduct(userContext, supplierProduct, allTokens());
  }

  public SupplierProduct internalSaveSupplierProduct(
      RetailscmUserContext userContext,
      SupplierProduct supplierProduct,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingSupplierProduct(userContext, supplierProductId, supplierProductVersion,
    // property, newValueExpr, tokensExpr);

    synchronized (supplierProduct) {
      // will be good when the supplierProduct loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to SupplierProduct.
      if (supplierProduct.isChanged()) {}

      // checkerOf(userContext).checkAndFixSupplierProduct(supplierProduct);
      supplierProduct = saveSupplierProduct(userContext, supplierProduct, options);
      return supplierProduct;
    }
  }

  public SupplierProduct updateSupplierProduct(
      RetailscmUserContext userContext,
      String supplierProductId,
      int supplierProductVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingSupplierProduct(
        userContext, supplierProductId, supplierProductVersion, property, newValueExpr, tokensExpr);

    SupplierProduct supplierProduct =
        loadSupplierProduct(userContext, supplierProductId, allTokens());
    if (supplierProduct.getVersion() != supplierProductVersion) {
      String message =
          "The target version("
              + supplierProduct.getVersion()
              + ") is not equals to version("
              + supplierProductVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (supplierProduct) {
      // will be good when the supplierProduct loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to SupplierProduct.

      supplierProduct.changeProperty(property, newValueExpr);
      supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().done());
      return present(userContext, supplierProduct, mergedAllTokens(tokensExpr));
      // return saveSupplierProduct(userContext, supplierProduct, tokens().done());
    }
  }

  public SupplierProduct updateSupplierProductProperty(
      RetailscmUserContext userContext,
      String supplierProductId,
      int supplierProductVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingSupplierProduct(
        userContext, supplierProductId, supplierProductVersion, property, newValueExpr, tokensExpr);

    SupplierProduct supplierProduct =
        loadSupplierProduct(userContext, supplierProductId, allTokens());
    if (supplierProduct.getVersion() != supplierProductVersion) {
      String message =
          "The target version("
              + supplierProduct.getVersion()
              + ") is not equals to version("
              + supplierProductVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (supplierProduct) {
      // will be good when the supplierProduct loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to SupplierProduct.

      supplierProduct.changeProperty(property, newValueExpr);

      supplierProduct = saveSupplierProduct(userContext, supplierProduct, tokens().done());
      return present(userContext, supplierProduct, mergedAllTokens(tokensExpr));
      // return saveSupplierProduct(userContext, supplierProduct, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected SupplierProductTokens tokens() {
    return SupplierProductTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return SupplierProductTokens.all();
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
        .sortProductSupplyDurationListWith(ProductSupplyDuration.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return SupplierProductTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherSupplier(
      RetailscmUserContext userContext, String supplierProductId, String anotherSupplierId)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
    checkerOf(userContext)
        .checkIdOfGoodsSupplier(anotherSupplierId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);
  }

  public SupplierProduct transferToAnotherSupplier(
      RetailscmUserContext userContext, String supplierProductId, String anotherSupplierId)
      throws Exception {
    checkParamsForTransferingAnotherSupplier(userContext, supplierProductId, anotherSupplierId);

    SupplierProduct supplierProduct =
        loadSupplierProduct(userContext, supplierProductId, allTokens());
    synchronized (supplierProduct) {
      // will be good when the supplierProduct loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      GoodsSupplier supplier = loadGoodsSupplier(userContext, anotherSupplierId, emptyOptions());
      supplierProduct.updateSupplier(supplier);

      supplierProduct = saveSupplierProduct(userContext, supplierProduct, emptyOptions());

      return present(userContext, supplierProduct, allTokens());
    }
  }

  public CandidateGoodsSupplier requestCandidateSupplier(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateGoodsSupplier result = new CandidateGoodsSupplier();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<GoodsSupplier> candidateList =
        goodsSupplierDaoOf(userContext)
            .requestCandidateGoodsSupplierForSupplierProduct(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected GoodsSupplier loadGoodsSupplier(
      RetailscmUserContext userContext, String newSupplierId, Map<String, Object> options)
      throws Exception {

    return goodsSupplierDaoOf(userContext).load(newSupplierId, options);
  }

  // --------------------------------------------------------------

  public SupplierProduct forgetByAll(
      RetailscmUserContext userContext, String supplierProductId, int supplierProductVersion)
      throws Exception {
    return forgetByAllInternal(userContext, supplierProductId, supplierProductVersion);
  }

  protected SupplierProduct forgetByAllInternal(
      RetailscmUserContext userContext, String supplierProductId, int supplierProductVersion)
      throws Exception {

    return supplierProductDaoOf(userContext)
        .disconnectFromAll(supplierProductId, supplierProductVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new SupplierProductManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingProductSupplyDuration(
      RetailscmUserContext userContext,
      String supplierProductId,
      int quantity,
      String duration,
      BigDecimal price,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);

    checkerOf(userContext).checkQuantityOfProductSupplyDuration(quantity);

    checkerOf(userContext).checkDurationOfProductSupplyDuration(duration);

    checkerOf(userContext).checkPriceOfProductSupplyDuration(price);

    checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);
  }

  public SupplierProduct addProductSupplyDuration(
      RetailscmUserContext userContext,
      String supplierProductId,
      int quantity,
      String duration,
      BigDecimal price,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingProductSupplyDuration(
        userContext, supplierProductId, quantity, duration, price, tokensExpr);

    ProductSupplyDuration productSupplyDuration =
        createProductSupplyDuration(userContext, quantity, duration, price);

    SupplierProduct supplierProduct =
        loadSupplierProduct(userContext, supplierProductId, emptyOptions());
    synchronized (supplierProduct) {
      // Will be good when the supplierProduct loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      supplierProduct.addProductSupplyDuration(productSupplyDuration);
      supplierProduct =
          saveSupplierProduct(
              userContext, supplierProduct, tokens().withProductSupplyDurationList().done());

      productSupplyDurationManagerOf(userContext)
          .onNewInstanceCreated(userContext, productSupplyDuration);
      return present(userContext, supplierProduct, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingProductSupplyDurationProperties(
      RetailscmUserContext userContext,
      String supplierProductId,
      String id,
      int quantity,
      String duration,
      BigDecimal price,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
    checkerOf(userContext).checkIdOfProductSupplyDuration(id);

    checkerOf(userContext).checkQuantityOfProductSupplyDuration(quantity);
    checkerOf(userContext).checkDurationOfProductSupplyDuration(duration);
    checkerOf(userContext).checkPriceOfProductSupplyDuration(price);

    checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);
  }

  public SupplierProduct updateProductSupplyDurationProperties(
      RetailscmUserContext userContext,
      String supplierProductId,
      String id,
      int quantity,
      String duration,
      BigDecimal price,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingProductSupplyDurationProperties(
        userContext, supplierProductId, id, quantity, duration, price, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withProductSupplyDurationListList()
            .searchProductSupplyDurationListWith(
                ProductSupplyDuration.ID_PROPERTY, tokens().is(), id)
            .done();

    SupplierProduct supplierProductToUpdate =
        loadSupplierProduct(userContext, supplierProductId, options);

    if (supplierProductToUpdate.getProductSupplyDurationList().isEmpty()) {
      throw new SupplierProductManagerException(
          "ProductSupplyDuration is NOT FOUND with id: '" + id + "'");
    }

    ProductSupplyDuration item = supplierProductToUpdate.getProductSupplyDurationList().first();
    beforeUpdateProductSupplyDurationProperties(
        userContext, item, supplierProductId, id, quantity, duration, price, tokensExpr);
    item.updateQuantity(quantity);
    item.updateDuration(duration);
    item.updatePrice(price);

    // checkParamsForAddingProductSupplyDuration(userContext,supplierProductId,name, code,
    // used,tokensExpr);
    SupplierProduct supplierProduct =
        saveSupplierProduct(
            userContext, supplierProductToUpdate, tokens().withProductSupplyDurationList().done());
    synchronized (supplierProduct) {
      return present(userContext, supplierProduct, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateProductSupplyDurationProperties(
      RetailscmUserContext userContext,
      ProductSupplyDuration item,
      String supplierProductId,
      String id,
      int quantity,
      String duration,
      BigDecimal price,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected ProductSupplyDuration createProductSupplyDuration(
      RetailscmUserContext userContext, int quantity, String duration, BigDecimal price)
      throws Exception {

    ProductSupplyDuration productSupplyDuration = new ProductSupplyDuration();

    productSupplyDuration.setQuantity(quantity);
    productSupplyDuration.setDuration(duration);
    productSupplyDuration.setPrice(price);

    return productSupplyDuration;
  }

  protected ProductSupplyDuration createIndexedProductSupplyDuration(String id, int version) {

    ProductSupplyDuration productSupplyDuration = new ProductSupplyDuration();
    productSupplyDuration.setId(id);
    productSupplyDuration.setVersion(version);
    return productSupplyDuration;
  }

  protected void checkParamsForRemovingProductSupplyDurationList(
      RetailscmUserContext userContext,
      String supplierProductId,
      String productSupplyDurationIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
    for (String productSupplyDurationIdItem : productSupplyDurationIds) {
      checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);
  }

  public SupplierProduct removeProductSupplyDurationList(
      RetailscmUserContext userContext,
      String supplierProductId,
      String productSupplyDurationIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingProductSupplyDurationList(
        userContext, supplierProductId, productSupplyDurationIds, tokensExpr);

    SupplierProduct supplierProduct =
        loadSupplierProduct(userContext, supplierProductId, allTokens());
    synchronized (supplierProduct) {
      // Will be good when the supplierProduct loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      supplierProductDaoOf(userContext)
          .planToRemoveProductSupplyDurationList(
              supplierProduct, productSupplyDurationIds, allTokens());
      supplierProduct =
          saveSupplierProduct(
              userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
      deleteRelationListInGraph(userContext, supplierProduct.getProductSupplyDurationList());
      return present(userContext, supplierProduct, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingProductSupplyDuration(
      RetailscmUserContext userContext,
      String supplierProductId,
      String productSupplyDurationId,
      int productSupplyDurationVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
    checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);
    checkerOf(userContext).checkVersionOfProductSupplyDuration(productSupplyDurationVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);
  }

  public SupplierProduct removeProductSupplyDuration(
      RetailscmUserContext userContext,
      String supplierProductId,
      String productSupplyDurationId,
      int productSupplyDurationVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingProductSupplyDuration(
        userContext,
        supplierProductId,
        productSupplyDurationId,
        productSupplyDurationVersion,
        tokensExpr);

    ProductSupplyDuration productSupplyDuration =
        createIndexedProductSupplyDuration(productSupplyDurationId, productSupplyDurationVersion);
    SupplierProduct supplierProduct =
        loadSupplierProduct(userContext, supplierProductId, allTokens());
    synchronized (supplierProduct) {
      // Will be good when the supplierProduct loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      supplierProduct.removeProductSupplyDuration(productSupplyDuration);
      supplierProduct =
          saveSupplierProduct(
              userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
      deleteRelationInGraph(userContext, productSupplyDuration);
      return present(userContext, supplierProduct, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingProductSupplyDuration(
      RetailscmUserContext userContext,
      String supplierProductId,
      String productSupplyDurationId,
      int productSupplyDurationVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
    checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);
    checkerOf(userContext).checkVersionOfProductSupplyDuration(productSupplyDurationVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);
  }

  public SupplierProduct copyProductSupplyDurationFrom(
      RetailscmUserContext userContext,
      String supplierProductId,
      String productSupplyDurationId,
      int productSupplyDurationVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingProductSupplyDuration(
        userContext,
        supplierProductId,
        productSupplyDurationId,
        productSupplyDurationVersion,
        tokensExpr);

    ProductSupplyDuration productSupplyDuration =
        createIndexedProductSupplyDuration(productSupplyDurationId, productSupplyDurationVersion);
    SupplierProduct supplierProduct =
        loadSupplierProduct(userContext, supplierProductId, allTokens());
    synchronized (supplierProduct) {
      // Will be good when the supplierProduct loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      supplierProduct.copyProductSupplyDurationFrom(productSupplyDuration);
      supplierProduct =
          saveSupplierProduct(
              userContext, supplierProduct, tokens().withProductSupplyDurationList().done());

      productSupplyDurationManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (ProductSupplyDuration)
                  supplierProduct.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, supplierProduct, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingProductSupplyDuration(
      RetailscmUserContext userContext,
      String supplierProductId,
      String productSupplyDurationId,
      int productSupplyDurationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSupplierProduct(supplierProductId);
    checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);
    checkerOf(userContext).checkVersionOfProductSupplyDuration(productSupplyDurationVersion);

    if (ProductSupplyDuration.QUANTITY_PROPERTY.equals(property)) {
      checkerOf(userContext).checkQuantityOfProductSupplyDuration(parseInt(newValueExpr));
    }

    if (ProductSupplyDuration.DURATION_PROPERTY.equals(property)) {
      checkerOf(userContext).checkDurationOfProductSupplyDuration(parseString(newValueExpr));
    }

    if (ProductSupplyDuration.PRICE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkPriceOfProductSupplyDuration(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(SupplierProductManagerException.class);
  }

  public SupplierProduct updateProductSupplyDuration(
      RetailscmUserContext userContext,
      String supplierProductId,
      String productSupplyDurationId,
      int productSupplyDurationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingProductSupplyDuration(
        userContext,
        supplierProductId,
        productSupplyDurationId,
        productSupplyDurationVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withProductSupplyDurationList()
            .searchProductSupplyDurationListWith(
                ProductSupplyDuration.ID_PROPERTY, tokens().equals(), productSupplyDurationId)
            .done();

    SupplierProduct supplierProduct =
        loadSupplierProduct(userContext, supplierProductId, loadTokens);

    synchronized (supplierProduct) {
      // Will be good when the supplierProduct loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // supplierProduct.removeProductSupplyDuration( productSupplyDuration );
      // make changes to AcceleraterAccount.
      ProductSupplyDuration productSupplyDurationIdVersionKey =
          createIndexedProductSupplyDuration(productSupplyDurationId, productSupplyDurationVersion);

      ProductSupplyDuration productSupplyDuration =
          supplierProduct.findTheProductSupplyDuration(productSupplyDurationIdVersionKey);
      if (productSupplyDuration == null) {
        throw new SupplierProductManagerException(productSupplyDurationId + " is NOT FOUND");
      }

      beforeUpdateProductSupplyDuration(
          userContext,
          productSupplyDuration,
          supplierProductId,
          productSupplyDurationId,
          productSupplyDurationVersion,
          property,
          newValueExpr,
          tokensExpr);
      productSupplyDuration.changeProperty(property, newValueExpr);

      supplierProduct =
          saveSupplierProduct(
              userContext, supplierProduct, tokens().withProductSupplyDurationList().done());
      productSupplyDurationManagerOf(userContext)
          .onUpdated(userContext, productSupplyDuration, this, "updateProductSupplyDuration");
      return present(userContext, supplierProduct, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateProductSupplyDuration(
      RetailscmUserContext userContext,
      ProductSupplyDuration existed,
      String supplierProductId,
      String productSupplyDurationId,
      int productSupplyDurationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, SupplierProduct newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    supplierProductDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   SupplierProduct newSupplierProduct = this.createSupplierProduct(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newSupplierProduct
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
    key.put(UserApp.APP_TYPE_PROPERTY, SupplierProduct.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<SupplierProduct> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<GoodsSupplier> supplierList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, GoodsSupplier.class);
    userContext.getDAOGroup().enhanceList(supplierList, GoodsSupplier.class);
  }

  public Object listBySupplier(RetailscmUserContext userContext, String supplierId)
      throws Exception {
    return listPageBySupplier(userContext, supplierId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageBySupplier(
      RetailscmUserContext userContext, String supplierId, int start, int count) throws Exception {
    SmartList<SupplierProduct> list =
        supplierProductDaoOf(userContext)
            .findSupplierProductBySupplier(supplierId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(SupplierProduct.class);
    page.setContainerObject(GoodsSupplier.withId(supplierId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("供应商的产品列表");
    page.setRequestName("listBySupplier");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listBySupplier/%s/", getBeanName(), supplierId)));

    page.assemblerContent(userContext, "listBySupplier");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String supplierProductId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    SupplierProduct merchantObj = (SupplierProduct) this.view(userContext, supplierProductId);
    String merchantObjId = supplierProductId;
    String linkToUrl = "supplierProductManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "供应商的产品" + "详情";
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
        MapUtil.put("id", "2-productName")
            .put("fieldName", "productName")
            .put("label", "品名")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("productName", merchantObj.getProductName());

    propList.add(
        MapUtil.put("id", "3-productDescription")
            .put("fieldName", "productDescription")
            .put("label", "产品描述")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("productDescription", merchantObj.getProductDescription());

    propList.add(
        MapUtil.put("id", "4-productUnit")
            .put("fieldName", "productUnit")
            .put("label", "产品单元")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("productUnit", merchantObj.getProductUnit());

    propList.add(
        MapUtil.put("id", "5-supplier")
            .put("fieldName", "supplier")
            .put("label", "供应商")
            .put("type", "auto")
            .put("linkToUrl", "goodsSupplierManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("supplier", merchantObj.getSupplier());

    // 处理 sectionList

    // 处理Section：productSupplyDurationListSection
    Map productSupplyDurationListSection =
        ListofUtils.buildSection(
            "productSupplyDurationListSection",
            "产品供货期限清单",
            null,
            "",
            "__no_group",
            "productSupplyDurationManager/listByProduct/" + merchantObjId + "/",
            "auto");
    sections.add(productSupplyDurationListSection);

    result.put(
        "productSupplyDurationListSection",
        ListofUtils.toShortList(
            merchantObj.getProductSupplyDurationList(), "productSupplyDuration"));

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
