package com.doublechaintech.retailscm.productsupplyduration;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.supplierproduct.CandidateSupplierProduct;
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

public class ProductSupplyDurationManagerImpl extends CustomRetailscmCheckerManager
    implements ProductSupplyDurationManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "ProductSupplyDuration";

  @Override
  public ProductSupplyDurationDAO daoOf(RetailscmUserContext userContext) {
    return productSupplyDurationDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws ProductSupplyDurationManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new ProductSupplyDurationManagerException(message);
  }

  protected ProductSupplyDuration saveProductSupplyDuration(
      RetailscmUserContext userContext,
      ProductSupplyDuration productSupplyDuration,
      String[] tokensExpr)
      throws Exception {
    // return getProductSupplyDurationDAO().save(productSupplyDuration, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveProductSupplyDuration(userContext, productSupplyDuration, tokens);
  }

  protected ProductSupplyDuration saveProductSupplyDurationDetail(
      RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration)
      throws Exception {

    return saveProductSupplyDuration(userContext, productSupplyDuration, allTokens());
  }

  public ProductSupplyDuration loadProductSupplyDuration(
      RetailscmUserContext userContext, String productSupplyDurationId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);

    checkerOf(userContext).throwExceptionIfHasErrors(ProductSupplyDurationManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    ProductSupplyDuration productSupplyDuration =
        loadProductSupplyDuration(userContext, productSupplyDurationId, tokens);
    // do some calc before sent to customer?
    return present(userContext, productSupplyDuration, tokens);
  }

  public ProductSupplyDuration searchProductSupplyDuration(
      RetailscmUserContext userContext,
      String productSupplyDurationId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);

    checkerOf(userContext).throwExceptionIfHasErrors(ProductSupplyDurationManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    ProductSupplyDuration productSupplyDuration =
        loadProductSupplyDuration(userContext, productSupplyDurationId, tokens);
    // do some calc before sent to customer?
    return present(userContext, productSupplyDuration, tokens);
  }

  protected ProductSupplyDuration present(
      RetailscmUserContext userContext,
      ProductSupplyDuration productSupplyDuration,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, productSupplyDuration, tokens);

    ProductSupplyDuration productSupplyDurationToPresent =
        productSupplyDurationDaoOf(userContext).present(productSupplyDuration, tokens);

    List<BaseEntity> entityListToNaming =
        productSupplyDurationToPresent.collectReferencesFromLists();
    productSupplyDurationDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, productSupplyDuration, tokens);

    return productSupplyDurationToPresent;
  }

  public ProductSupplyDuration loadProductSupplyDurationDetail(
      RetailscmUserContext userContext, String productSupplyDurationId) throws Exception {
    ProductSupplyDuration productSupplyDuration =
        loadProductSupplyDuration(userContext, productSupplyDurationId, allTokens());
    return present(userContext, productSupplyDuration, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String productSupplyDurationId)
      throws Exception {
    ProductSupplyDuration productSupplyDuration =
        loadProductSupplyDuration(userContext, productSupplyDurationId, viewTokens());
    markVisited(userContext, productSupplyDuration);
    return present(userContext, productSupplyDuration, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String productSupplyDurationId)
      throws Exception {
    ProductSupplyDuration productSupplyDuration =
        loadProductSupplyDuration(userContext, productSupplyDurationId, viewTokens());
    productSupplyDuration.summarySuffix();
    markVisited(userContext, productSupplyDuration);
    return present(userContext, productSupplyDuration, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String productSupplyDurationId)
      throws Exception {
    ProductSupplyDuration productSupplyDuration =
        loadProductSupplyDuration(userContext, productSupplyDurationId, analyzeTokens());
    markVisited(userContext, productSupplyDuration);
    return present(userContext, productSupplyDuration, analyzeTokens());
  }

  protected ProductSupplyDuration saveProductSupplyDuration(
      RetailscmUserContext userContext,
      ProductSupplyDuration productSupplyDuration,
      Map<String, Object> tokens)
      throws Exception {

    return productSupplyDurationDaoOf(userContext).save(productSupplyDuration, tokens);
  }

  protected ProductSupplyDuration loadProductSupplyDuration(
      RetailscmUserContext userContext, String productSupplyDurationId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);

    checkerOf(userContext).throwExceptionIfHasErrors(ProductSupplyDurationManagerException.class);

    return productSupplyDurationDaoOf(userContext).load(productSupplyDurationId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      ProductSupplyDuration productSupplyDuration,
      Map<String, Object> tokens) {
    super.addActions(userContext, productSupplyDuration, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, ProductSupplyDuration productSupplyDuration, Map<String, Object> tokens){

  @Override
  public List<ProductSupplyDuration> searchProductSupplyDurationList(
      RetailscmUserContext ctx, ProductSupplyDurationRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<ProductSupplyDuration> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public ProductSupplyDuration searchProductSupplyDuration(
      RetailscmUserContext ctx, ProductSupplyDurationRequest pRequest) {
    pRequest.limit(0, 1);
    List<ProductSupplyDuration> list = searchProductSupplyDurationList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public ProductSupplyDuration createProductSupplyDuration(
      RetailscmUserContext userContext,
      int quantity,
      String duration,
      BigDecimal price,
      String productId)
      throws Exception {

    checkerOf(userContext).checkQuantityOfProductSupplyDuration(quantity);
    checkerOf(userContext).checkDurationOfProductSupplyDuration(duration);
    checkerOf(userContext).checkPriceOfProductSupplyDuration(price);

    checkerOf(userContext).throwExceptionIfHasErrors(ProductSupplyDurationManagerException.class);

    ProductSupplyDuration productSupplyDuration = createNewProductSupplyDuration();

    productSupplyDuration.setQuantity(quantity);
    productSupplyDuration.setDuration(duration);
    productSupplyDuration.setPrice(price);

    SupplierProduct product = loadSupplierProduct(userContext, productId, emptyOptions());
    productSupplyDuration.setProduct(product);

    productSupplyDuration =
        saveProductSupplyDuration(userContext, productSupplyDuration, emptyOptions());

    onNewInstanceCreated(userContext, productSupplyDuration);
    return productSupplyDuration;
  }

  protected ProductSupplyDuration createNewProductSupplyDuration() {

    return new ProductSupplyDuration();
  }

  protected void checkParamsForUpdatingProductSupplyDuration(
      RetailscmUserContext userContext,
      String productSupplyDurationId,
      int productSupplyDurationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

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

    checkerOf(userContext).throwExceptionIfHasErrors(ProductSupplyDurationManagerException.class);
  }

  public ProductSupplyDuration clone(
      RetailscmUserContext userContext, String fromProductSupplyDurationId) throws Exception {

    return productSupplyDurationDaoOf(userContext)
        .clone(fromProductSupplyDurationId, this.allTokens());
  }

  public ProductSupplyDuration internalSaveProductSupplyDuration(
      RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration)
      throws Exception {
    return internalSaveProductSupplyDuration(userContext, productSupplyDuration, allTokens());
  }

  public ProductSupplyDuration internalSaveProductSupplyDuration(
      RetailscmUserContext userContext,
      ProductSupplyDuration productSupplyDuration,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingProductSupplyDuration(userContext, productSupplyDurationId,
    // productSupplyDurationVersion, property, newValueExpr, tokensExpr);

    synchronized (productSupplyDuration) {
      // will be good when the productSupplyDuration loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ProductSupplyDuration.
      if (productSupplyDuration.isChanged()) {}

      // checkerOf(userContext).checkAndFixProductSupplyDuration(productSupplyDuration);
      productSupplyDuration =
          saveProductSupplyDuration(userContext, productSupplyDuration, options);
      return productSupplyDuration;
    }
  }

  public ProductSupplyDuration updateProductSupplyDuration(
      RetailscmUserContext userContext,
      String productSupplyDurationId,
      int productSupplyDurationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingProductSupplyDuration(
        userContext,
        productSupplyDurationId,
        productSupplyDurationVersion,
        property,
        newValueExpr,
        tokensExpr);

    ProductSupplyDuration productSupplyDuration =
        loadProductSupplyDuration(userContext, productSupplyDurationId, allTokens());
    if (productSupplyDuration.getVersion() != productSupplyDurationVersion) {
      String message =
          "The target version("
              + productSupplyDuration.getVersion()
              + ") is not equals to version("
              + productSupplyDurationVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (productSupplyDuration) {
      // will be good when the productSupplyDuration loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ProductSupplyDuration.

      productSupplyDuration.changeProperty(property, newValueExpr);
      productSupplyDuration =
          saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
      return present(userContext, productSupplyDuration, mergedAllTokens(tokensExpr));
      // return saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
    }
  }

  public ProductSupplyDuration updateProductSupplyDurationProperty(
      RetailscmUserContext userContext,
      String productSupplyDurationId,
      int productSupplyDurationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingProductSupplyDuration(
        userContext,
        productSupplyDurationId,
        productSupplyDurationVersion,
        property,
        newValueExpr,
        tokensExpr);

    ProductSupplyDuration productSupplyDuration =
        loadProductSupplyDuration(userContext, productSupplyDurationId, allTokens());
    if (productSupplyDuration.getVersion() != productSupplyDurationVersion) {
      String message =
          "The target version("
              + productSupplyDuration.getVersion()
              + ") is not equals to version("
              + productSupplyDurationVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (productSupplyDuration) {
      // will be good when the productSupplyDuration loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ProductSupplyDuration.

      productSupplyDuration.changeProperty(property, newValueExpr);

      productSupplyDuration =
          saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
      return present(userContext, productSupplyDuration, mergedAllTokens(tokensExpr));
      // return saveProductSupplyDuration(userContext, productSupplyDuration, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected ProductSupplyDurationTokens tokens() {
    return ProductSupplyDurationTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return ProductSupplyDurationTokens.all();
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
    return ProductSupplyDurationTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherProduct(
      RetailscmUserContext userContext, String productSupplyDurationId, String anotherProductId)
      throws Exception {

    checkerOf(userContext).checkIdOfProductSupplyDuration(productSupplyDurationId);
    checkerOf(userContext)
        .checkIdOfSupplierProduct(anotherProductId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(ProductSupplyDurationManagerException.class);
  }

  public ProductSupplyDuration transferToAnotherProduct(
      RetailscmUserContext userContext, String productSupplyDurationId, String anotherProductId)
      throws Exception {
    checkParamsForTransferingAnotherProduct(userContext, productSupplyDurationId, anotherProductId);

    ProductSupplyDuration productSupplyDuration =
        loadProductSupplyDuration(userContext, productSupplyDurationId, allTokens());
    synchronized (productSupplyDuration) {
      // will be good when the productSupplyDuration loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      SupplierProduct product = loadSupplierProduct(userContext, anotherProductId, emptyOptions());
      productSupplyDuration.updateProduct(product);

      productSupplyDuration =
          saveProductSupplyDuration(userContext, productSupplyDuration, emptyOptions());

      return present(userContext, productSupplyDuration, allTokens());
    }
  }

  public CandidateSupplierProduct requestCandidateProduct(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateSupplierProduct result = new CandidateSupplierProduct();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("productName");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<SupplierProduct> candidateList =
        supplierProductDaoOf(userContext)
            .requestCandidateSupplierProductForProductSupplyDuration(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected SupplierProduct loadSupplierProduct(
      RetailscmUserContext userContext, String newProductId, Map<String, Object> options)
      throws Exception {

    return supplierProductDaoOf(userContext).load(newProductId, options);
  }

  // --------------------------------------------------------------

  public ProductSupplyDuration forgetByAll(
      RetailscmUserContext userContext,
      String productSupplyDurationId,
      int productSupplyDurationVersion)
      throws Exception {
    return forgetByAllInternal(userContext, productSupplyDurationId, productSupplyDurationVersion);
  }

  protected ProductSupplyDuration forgetByAllInternal(
      RetailscmUserContext userContext,
      String productSupplyDurationId,
      int productSupplyDurationVersion)
      throws Exception {

    return productSupplyDurationDaoOf(userContext)
        .disconnectFromAll(productSupplyDurationId, productSupplyDurationVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new ProductSupplyDurationManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, ProductSupplyDuration newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    productSupplyDurationDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   ProductSupplyDuration newProductSupplyDuration =
    // this.createProductSupplyDuration(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newProductSupplyDuration
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
    key.put(UserApp.APP_TYPE_PROPERTY, ProductSupplyDuration.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<ProductSupplyDuration> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<SupplierProduct> productList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, SupplierProduct.class);
    userContext.getDAOGroup().enhanceList(productList, SupplierProduct.class);
  }

  public Object listByProduct(RetailscmUserContext userContext, String productId) throws Exception {
    return listPageByProduct(userContext, productId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByProduct(
      RetailscmUserContext userContext, String productId, int start, int count) throws Exception {
    SmartList<ProductSupplyDuration> list =
        productSupplyDurationDaoOf(userContext)
            .findProductSupplyDurationByProduct(productId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(ProductSupplyDuration.class);
    page.setContainerObject(SupplierProduct.withId(productId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("产品供应时间列表");
    page.setRequestName("listByProduct");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByProduct/%s/", getBeanName(), productId)));

    page.assemblerContent(userContext, "listByProduct");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String productSupplyDurationId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    ProductSupplyDuration merchantObj =
        (ProductSupplyDuration) this.view(userContext, productSupplyDurationId);
    String merchantObjId = productSupplyDurationId;
    String linkToUrl = "productSupplyDurationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "产品供应时间" + "详情";
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
        MapUtil.put("id", "2-quantity")
            .put("fieldName", "quantity")
            .put("label", "数量")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("quantity", merchantObj.getQuantity());

    propList.add(
        MapUtil.put("id", "3-duration")
            .put("fieldName", "duration")
            .put("label", "持续时间")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("duration", merchantObj.getDuration());

    propList.add(
        MapUtil.put("id", "4-price")
            .put("fieldName", "price")
            .put("label", "价格")
            .put("type", "money")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("price", merchantObj.getPrice());

    propList.add(
        MapUtil.put("id", "5-product")
            .put("fieldName", "product")
            .put("label", "产品")
            .put("type", "auto")
            .put("linkToUrl", "supplierProductManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"product_description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"product_name\",\"imageList\":\"\"}")
            .into_map());
    result.put("product", merchantObj.getProduct());

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
