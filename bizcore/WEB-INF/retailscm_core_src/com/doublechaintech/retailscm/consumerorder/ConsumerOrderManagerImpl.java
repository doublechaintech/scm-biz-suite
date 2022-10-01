package com.doublechaintech.retailscm.consumerorder;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.retailstore.CandidateRetailStore;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoremember.CandidateRetailStoreMember;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
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

public class ConsumerOrderManagerImpl extends CustomRetailscmCheckerManager
    implements ConsumerOrderManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens = ConsumerOrderTokens.start().withTokenFromListName(listName).done();
    ConsumerOrder consumerOrder = (ConsumerOrder) this.loadConsumerOrder(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = consumerOrder.collectReferencesFromLists();
    consumerOrderDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, consumerOrder, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new ConsumerOrderGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "ConsumerOrder";

  @Override
  public ConsumerOrderDAO daoOf(RetailscmUserContext userContext) {
    return consumerOrderDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws ConsumerOrderManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new ConsumerOrderManagerException(message);
  }

  protected ConsumerOrder saveConsumerOrder(
      RetailscmUserContext userContext, ConsumerOrder consumerOrder, String[] tokensExpr)
      throws Exception {
    // return getConsumerOrderDAO().save(consumerOrder, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveConsumerOrder(userContext, consumerOrder, tokens);
  }

  protected ConsumerOrder saveConsumerOrderDetail(
      RetailscmUserContext userContext, ConsumerOrder consumerOrder) throws Exception {

    return saveConsumerOrder(userContext, consumerOrder, allTokens());
  }

  public ConsumerOrder loadConsumerOrder(
      RetailscmUserContext userContext, String consumerOrderId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, tokens);
    // do some calc before sent to customer?
    return present(userContext, consumerOrder, tokens);
  }

  public ConsumerOrder searchConsumerOrder(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, tokens);
    // do some calc before sent to customer?
    return present(userContext, consumerOrder, tokens);
  }

  protected ConsumerOrder present(
      RetailscmUserContext userContext, ConsumerOrder consumerOrder, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, consumerOrder, tokens);

    ConsumerOrder consumerOrderToPresent =
        consumerOrderDaoOf(userContext).present(consumerOrder, tokens);

    List<BaseEntity> entityListToNaming = consumerOrderToPresent.collectReferencesFromLists();
    consumerOrderDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, consumerOrder, tokens);

    return consumerOrderToPresent;
  }

  public ConsumerOrder loadConsumerOrderDetail(
      RetailscmUserContext userContext, String consumerOrderId) throws Exception {
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    return present(userContext, consumerOrder, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String consumerOrderId) throws Exception {
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, viewTokens());
    markVisited(userContext, consumerOrder);
    return present(userContext, consumerOrder, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String consumerOrderId)
      throws Exception {
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, viewTokens());
    consumerOrder.summarySuffix();
    markVisited(userContext, consumerOrder);
    return present(userContext, consumerOrder, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String consumerOrderId) throws Exception {
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, analyzeTokens());
    markVisited(userContext, consumerOrder);
    return present(userContext, consumerOrder, analyzeTokens());
  }

  protected ConsumerOrder saveConsumerOrder(
      RetailscmUserContext userContext, ConsumerOrder consumerOrder, Map<String, Object> tokens)
      throws Exception {

    return consumerOrderDaoOf(userContext).save(consumerOrder, tokens);
  }

  protected ConsumerOrder loadConsumerOrder(
      RetailscmUserContext userContext, String consumerOrderId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

    return consumerOrderDaoOf(userContext).load(consumerOrderId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, ConsumerOrder consumerOrder, Map<String, Object> tokens) {
    super.addActions(userContext, consumerOrder, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, ConsumerOrder consumerOrder, Map<String, Object> tokens){

  @Override
  public List<ConsumerOrder> searchConsumerOrderList(
      RetailscmUserContext ctx, ConsumerOrderRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<ConsumerOrder> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public ConsumerOrder searchConsumerOrder(
      RetailscmUserContext ctx, ConsumerOrderRequest pRequest) {
    pRequest.limit(0, 1);
    List<ConsumerOrder> list = searchConsumerOrderList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public ConsumerOrder createConsumerOrder(
      RetailscmUserContext userContext, String title, String consumerId, String storeId)
      throws Exception {

    checkerOf(userContext).checkTitleOfConsumerOrder(title);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);

    ConsumerOrder consumerOrder = createNewConsumerOrder();

    consumerOrder.setTitle(title);

    RetailStoreMember consumer = loadRetailStoreMember(userContext, consumerId, emptyOptions());
    consumerOrder.setConsumer(consumer);

    RetailStore store = loadRetailStore(userContext, storeId, emptyOptions());
    consumerOrder.setStore(store);

    consumerOrder.setLastUpdateTime(userContext.now());

    consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());

    onNewInstanceCreated(userContext, consumerOrder);
    return consumerOrder;
  }

  protected ConsumerOrder createNewConsumerOrder() {

    return new ConsumerOrder();
  }

  protected void checkParamsForUpdatingConsumerOrder(
      RetailscmUserContext userContext,
      String consumerOrderId,
      int consumerOrderVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);

    if (ConsumerOrder.TITLE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder clone(RetailscmUserContext userContext, String fromConsumerOrderId)
      throws Exception {

    return consumerOrderDaoOf(userContext).clone(fromConsumerOrderId, this.allTokens());
  }

  public ConsumerOrder internalSaveConsumerOrder(
      RetailscmUserContext userContext, ConsumerOrder consumerOrder) throws Exception {
    return internalSaveConsumerOrder(userContext, consumerOrder, allTokens());
  }

  public ConsumerOrder internalSaveConsumerOrder(
      RetailscmUserContext userContext, ConsumerOrder consumerOrder, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingConsumerOrder(userContext, consumerOrderId, consumerOrderVersion,
    // property, newValueExpr, tokensExpr);

    synchronized (consumerOrder) {
      // will be good when the consumerOrder loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ConsumerOrder.
      if (consumerOrder.isChanged()) {
        consumerOrder.updateLastUpdateTime(userContext.now());
      }

      // checkerOf(userContext).checkAndFixConsumerOrder(consumerOrder);
      consumerOrder = saveConsumerOrder(userContext, consumerOrder, options);
      return consumerOrder;
    }
  }

  public ConsumerOrder updateConsumerOrder(
      RetailscmUserContext userContext,
      String consumerOrderId,
      int consumerOrderVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingConsumerOrder(
        userContext, consumerOrderId, consumerOrderVersion, property, newValueExpr, tokensExpr);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    if (consumerOrder.getVersion() != consumerOrderVersion) {
      String message =
          "The target version("
              + consumerOrder.getVersion()
              + ") is not equals to version("
              + consumerOrderVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (consumerOrder) {
      // will be good when the consumerOrder loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ConsumerOrder.
      consumerOrder.updateLastUpdateTime(userContext.now());
      consumerOrder.changeProperty(property, newValueExpr);
      consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().done());
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
      // return saveConsumerOrder(userContext, consumerOrder, tokens().done());
    }
  }

  public ConsumerOrder updateConsumerOrderProperty(
      RetailscmUserContext userContext,
      String consumerOrderId,
      int consumerOrderVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingConsumerOrder(
        userContext, consumerOrderId, consumerOrderVersion, property, newValueExpr, tokensExpr);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    if (consumerOrder.getVersion() != consumerOrderVersion) {
      String message =
          "The target version("
              + consumerOrder.getVersion()
              + ") is not equals to version("
              + consumerOrderVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (consumerOrder) {
      // will be good when the consumerOrder loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ConsumerOrder.

      consumerOrder.changeProperty(property, newValueExpr);
      consumerOrder.updateLastUpdateTime(userContext.now());
      consumerOrder = saveConsumerOrder(userContext, consumerOrder, tokens().done());
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
      // return saveConsumerOrder(userContext, consumerOrder, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected ConsumerOrderTokens tokens() {
    return ConsumerOrderTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return ConsumerOrderTokens.all();
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
        .sortConsumerOrderLineItemListWith(ConsumerOrderLineItem.ID_PROPERTY, sortDesc())
        .sortConsumerOrderShippingGroupListWith(ConsumerOrderShippingGroup.ID_PROPERTY, sortDesc())
        .sortConsumerOrderPaymentGroupListWith(ConsumerOrderPaymentGroup.ID_PROPERTY, sortDesc())
        .sortConsumerOrderPriceAdjustmentListWith(
            ConsumerOrderPriceAdjustment.ID_PROPERTY, sortDesc())
        .sortRetailStoreMemberGiftCardConsumeRecordListWith(
            RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return ConsumerOrderTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherConsumer(
      RetailscmUserContext userContext, String consumerOrderId, String anotherConsumerId)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext)
        .checkIdOfRetailStoreMember(anotherConsumerId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder transferToAnotherConsumer(
      RetailscmUserContext userContext, String consumerOrderId, String anotherConsumerId)
      throws Exception {
    checkParamsForTransferingAnotherConsumer(userContext, consumerOrderId, anotherConsumerId);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // will be good when the consumerOrder loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreMember consumer =
          loadRetailStoreMember(userContext, anotherConsumerId, emptyOptions());
      consumerOrder.updateConsumer(consumer);
      consumerOrder.updateLastUpdateTime(userContext.now());
      consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());

      return present(userContext, consumerOrder, allTokens());
    }
  }

  public CandidateRetailStoreMember requestCandidateConsumer(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateRetailStoreMember result = new CandidateRetailStoreMember();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<RetailStoreMember> candidateList =
        retailStoreMemberDaoOf(userContext)
            .requestCandidateRetailStoreMemberForConsumerOrder(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  protected void checkParamsForTransferingAnotherStore(
      RetailscmUserContext userContext, String consumerOrderId, String anotherStoreId)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfRetailStore(anotherStoreId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder transferToAnotherStore(
      RetailscmUserContext userContext, String consumerOrderId, String anotherStoreId)
      throws Exception {
    checkParamsForTransferingAnotherStore(userContext, consumerOrderId, anotherStoreId);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // will be good when the consumerOrder loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStore store = loadRetailStore(userContext, anotherStoreId, emptyOptions());
      consumerOrder.updateStore(store);
      consumerOrder.updateLastUpdateTime(userContext.now());
      consumerOrder = saveConsumerOrder(userContext, consumerOrder, emptyOptions());

      return present(userContext, consumerOrder, allTokens());
    }
  }

  public CandidateRetailStore requestCandidateStore(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateRetailStore result = new CandidateRetailStore();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<RetailStore> candidateList =
        retailStoreDaoOf(userContext)
            .requestCandidateRetailStoreForConsumerOrder(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected RetailStoreMember loadRetailStoreMember(
      RetailscmUserContext userContext, String newConsumerId, Map<String, Object> options)
      throws Exception {

    return retailStoreMemberDaoOf(userContext).load(newConsumerId, options);
  }

  protected RetailStore loadRetailStore(
      RetailscmUserContext userContext, String newStoreId, Map<String, Object> options)
      throws Exception {

    return retailStoreDaoOf(userContext).load(newStoreId, options);
  }

  // --------------------------------------------------------------

  public ConsumerOrder forgetByAll(
      RetailscmUserContext userContext, String consumerOrderId, int consumerOrderVersion)
      throws Exception {
    return forgetByAllInternal(userContext, consumerOrderId, consumerOrderVersion);
  }

  protected ConsumerOrder forgetByAllInternal(
      RetailscmUserContext userContext, String consumerOrderId, int consumerOrderVersion)
      throws Exception {

    return consumerOrderDaoOf(userContext).disconnectFromAll(consumerOrderId, consumerOrderVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new ConsumerOrderManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingConsumerOrderLineItem(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String skuId,
      String skuName,
      BigDecimal price,
      BigDecimal quantity,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

    checkerOf(userContext).checkSkuIdOfConsumerOrderLineItem(skuId);

    checkerOf(userContext).checkSkuNameOfConsumerOrderLineItem(skuName);

    checkerOf(userContext).checkPriceOfConsumerOrderLineItem(price);

    checkerOf(userContext).checkQuantityOfConsumerOrderLineItem(quantity);

    checkerOf(userContext).checkAmountOfConsumerOrderLineItem(amount);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder addConsumerOrderLineItem(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String skuId,
      String skuName,
      BigDecimal price,
      BigDecimal quantity,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingConsumerOrderLineItem(
        userContext, consumerOrderId, skuId, skuName, price, quantity, amount, tokensExpr);

    ConsumerOrderLineItem consumerOrderLineItem =
        createConsumerOrderLineItem(userContext, skuId, skuName, price, quantity, amount);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, emptyOptions());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrder.addConsumerOrderLineItem(consumerOrderLineItem);
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());

      consumerOrderLineItemManagerOf(userContext)
          .onNewInstanceCreated(userContext, consumerOrderLineItem);
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingConsumerOrderLineItemProperties(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String id,
      String skuId,
      String skuName,
      BigDecimal price,
      BigDecimal quantity,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderLineItem(id);

    checkerOf(userContext).checkSkuIdOfConsumerOrderLineItem(skuId);
    checkerOf(userContext).checkSkuNameOfConsumerOrderLineItem(skuName);
    checkerOf(userContext).checkPriceOfConsumerOrderLineItem(price);
    checkerOf(userContext).checkQuantityOfConsumerOrderLineItem(quantity);
    checkerOf(userContext).checkAmountOfConsumerOrderLineItem(amount);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder updateConsumerOrderLineItemProperties(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String id,
      String skuId,
      String skuName,
      BigDecimal price,
      BigDecimal quantity,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingConsumerOrderLineItemProperties(
        userContext, consumerOrderId, id, skuId, skuName, price, quantity, amount, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withConsumerOrderLineItemListList()
            .searchConsumerOrderLineItemListWith(
                ConsumerOrderLineItem.ID_PROPERTY, tokens().is(), id)
            .done();

    ConsumerOrder consumerOrderToUpdate = loadConsumerOrder(userContext, consumerOrderId, options);

    if (consumerOrderToUpdate.getConsumerOrderLineItemList().isEmpty()) {
      throw new ConsumerOrderManagerException(
          "ConsumerOrderLineItem is NOT FOUND with id: '" + id + "'");
    }

    ConsumerOrderLineItem item = consumerOrderToUpdate.getConsumerOrderLineItemList().first();
    beforeUpdateConsumerOrderLineItemProperties(
        userContext,
        item,
        consumerOrderId,
        id,
        skuId,
        skuName,
        price,
        quantity,
        amount,
        tokensExpr);
    item.updateSkuId(skuId);
    item.updateSkuName(skuName);
    item.updatePrice(price);
    item.updateQuantity(quantity);
    item.updateAmount(amount);

    // checkParamsForAddingConsumerOrderLineItem(userContext,consumerOrderId,name, code,
    // used,tokensExpr);
    ConsumerOrder consumerOrder =
        saveConsumerOrder(
            userContext, consumerOrderToUpdate, tokens().withConsumerOrderLineItemList().done());
    synchronized (consumerOrder) {
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateConsumerOrderLineItemProperties(
      RetailscmUserContext userContext,
      ConsumerOrderLineItem item,
      String consumerOrderId,
      String id,
      String skuId,
      String skuName,
      BigDecimal price,
      BigDecimal quantity,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected ConsumerOrderLineItem createConsumerOrderLineItem(
      RetailscmUserContext userContext,
      String skuId,
      String skuName,
      BigDecimal price,
      BigDecimal quantity,
      BigDecimal amount)
      throws Exception {

    ConsumerOrderLineItem consumerOrderLineItem = new ConsumerOrderLineItem();

    consumerOrderLineItem.setSkuId(skuId);
    consumerOrderLineItem.setSkuName(skuName);
    consumerOrderLineItem.setPrice(price);
    consumerOrderLineItem.setQuantity(quantity);
    consumerOrderLineItem.setAmount(amount);
    consumerOrderLineItem.setLastUpdateTime(userContext.now());

    return consumerOrderLineItem;
  }

  protected ConsumerOrderLineItem createIndexedConsumerOrderLineItem(String id, int version) {

    ConsumerOrderLineItem consumerOrderLineItem = new ConsumerOrderLineItem();
    consumerOrderLineItem.setId(id);
    consumerOrderLineItem.setVersion(version);
    return consumerOrderLineItem;
  }

  protected void checkParamsForRemovingConsumerOrderLineItemList(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderLineItemIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    for (String consumerOrderLineItemIdItem : consumerOrderLineItemIds) {
      checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder removeConsumerOrderLineItemList(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderLineItemIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingConsumerOrderLineItemList(
        userContext, consumerOrderId, consumerOrderLineItemIds, tokensExpr);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrderDaoOf(userContext)
          .planToRemoveConsumerOrderLineItemList(
              consumerOrder, consumerOrderLineItemIds, allTokens());
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
      deleteRelationListInGraph(userContext, consumerOrder.getConsumerOrderLineItemList());
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingConsumerOrderLineItem(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderLineItemId,
      int consumerOrderLineItemVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
    checkerOf(userContext).checkVersionOfConsumerOrderLineItem(consumerOrderLineItemVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder removeConsumerOrderLineItem(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderLineItemId,
      int consumerOrderLineItemVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingConsumerOrderLineItem(
        userContext,
        consumerOrderId,
        consumerOrderLineItemId,
        consumerOrderLineItemVersion,
        tokensExpr);

    ConsumerOrderLineItem consumerOrderLineItem =
        createIndexedConsumerOrderLineItem(consumerOrderLineItemId, consumerOrderLineItemVersion);
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrder.removeConsumerOrderLineItem(consumerOrderLineItem);
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
      deleteRelationInGraph(userContext, consumerOrderLineItem);
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingConsumerOrderLineItem(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderLineItemId,
      int consumerOrderLineItemVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
    checkerOf(userContext).checkVersionOfConsumerOrderLineItem(consumerOrderLineItemVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder copyConsumerOrderLineItemFrom(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderLineItemId,
      int consumerOrderLineItemVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingConsumerOrderLineItem(
        userContext,
        consumerOrderId,
        consumerOrderLineItemId,
        consumerOrderLineItemVersion,
        tokensExpr);

    ConsumerOrderLineItem consumerOrderLineItem =
        createIndexedConsumerOrderLineItem(consumerOrderLineItemId, consumerOrderLineItemVersion);
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      consumerOrderLineItem.updateLastUpdateTime(userContext.now());

      consumerOrder.copyConsumerOrderLineItemFrom(consumerOrderLineItem);
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());

      consumerOrderLineItemManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (ConsumerOrderLineItem)
                  consumerOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingConsumerOrderLineItem(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderLineItemId,
      int consumerOrderLineItemVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
    checkerOf(userContext).checkVersionOfConsumerOrderLineItem(consumerOrderLineItemVersion);

    if (ConsumerOrderLineItem.SKU_ID_PROPERTY.equals(property)) {
      checkerOf(userContext).checkSkuIdOfConsumerOrderLineItem(parseString(newValueExpr));
    }

    if (ConsumerOrderLineItem.SKU_NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkSkuNameOfConsumerOrderLineItem(parseString(newValueExpr));
    }

    if (ConsumerOrderLineItem.PRICE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkPriceOfConsumerOrderLineItem(parseBigDecimal(newValueExpr));
    }

    if (ConsumerOrderLineItem.QUANTITY_PROPERTY.equals(property)) {
      checkerOf(userContext).checkQuantityOfConsumerOrderLineItem(parseBigDecimal(newValueExpr));
    }

    if (ConsumerOrderLineItem.AMOUNT_PROPERTY.equals(property)) {
      checkerOf(userContext).checkAmountOfConsumerOrderLineItem(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder updateConsumerOrderLineItem(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderLineItemId,
      int consumerOrderLineItemVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingConsumerOrderLineItem(
        userContext,
        consumerOrderId,
        consumerOrderLineItemId,
        consumerOrderLineItemVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withConsumerOrderLineItemList()
            .searchConsumerOrderLineItemListWith(
                ConsumerOrderLineItem.ID_PROPERTY, tokens().equals(), consumerOrderLineItemId)
            .done();

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, loadTokens);

    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // consumerOrder.removeConsumerOrderLineItem( consumerOrderLineItem );
      // make changes to AcceleraterAccount.
      ConsumerOrderLineItem consumerOrderLineItemIdVersionKey =
          createIndexedConsumerOrderLineItem(consumerOrderLineItemId, consumerOrderLineItemVersion);

      ConsumerOrderLineItem consumerOrderLineItem =
          consumerOrder.findTheConsumerOrderLineItem(consumerOrderLineItemIdVersionKey);
      if (consumerOrderLineItem == null) {
        throw new ConsumerOrderManagerException(consumerOrderLineItemId + " is NOT FOUND");
      }

      beforeUpdateConsumerOrderLineItem(
          userContext,
          consumerOrderLineItem,
          consumerOrderId,
          consumerOrderLineItemId,
          consumerOrderLineItemVersion,
          property,
          newValueExpr,
          tokensExpr);
      consumerOrderLineItem.changeProperty(property, newValueExpr);
      consumerOrderLineItem.updateLastUpdateTime(userContext.now());
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderLineItemList().done());
      consumerOrderLineItemManagerOf(userContext)
          .onUpdated(userContext, consumerOrderLineItem, this, "updateConsumerOrderLineItem");
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateConsumerOrderLineItem(
      RetailscmUserContext userContext,
      ConsumerOrderLineItem existed,
      String consumerOrderId,
      String consumerOrderLineItemId,
      int consumerOrderLineItemVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  protected void checkParamsForAddingConsumerOrderShippingGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String name,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

    checkerOf(userContext).checkNameOfConsumerOrderShippingGroup(name);

    checkerOf(userContext).checkAmountOfConsumerOrderShippingGroup(amount);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder addConsumerOrderShippingGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String name,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingConsumerOrderShippingGroup(
        userContext, consumerOrderId, name, amount, tokensExpr);

    ConsumerOrderShippingGroup consumerOrderShippingGroup =
        createConsumerOrderShippingGroup(userContext, name, amount);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, emptyOptions());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrder.addConsumerOrderShippingGroup(consumerOrderShippingGroup);
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());

      consumerOrderShippingGroupManagerOf(userContext)
          .onNewInstanceCreated(userContext, consumerOrderShippingGroup);
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingConsumerOrderShippingGroupProperties(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String id,
      String name,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(id);

    checkerOf(userContext).checkNameOfConsumerOrderShippingGroup(name);
    checkerOf(userContext).checkAmountOfConsumerOrderShippingGroup(amount);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder updateConsumerOrderShippingGroupProperties(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String id,
      String name,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingConsumerOrderShippingGroupProperties(
        userContext, consumerOrderId, id, name, amount, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withConsumerOrderShippingGroupListList()
            .searchConsumerOrderShippingGroupListWith(
                ConsumerOrderShippingGroup.ID_PROPERTY, tokens().is(), id)
            .done();

    ConsumerOrder consumerOrderToUpdate = loadConsumerOrder(userContext, consumerOrderId, options);

    if (consumerOrderToUpdate.getConsumerOrderShippingGroupList().isEmpty()) {
      throw new ConsumerOrderManagerException(
          "ConsumerOrderShippingGroup is NOT FOUND with id: '" + id + "'");
    }

    ConsumerOrderShippingGroup item =
        consumerOrderToUpdate.getConsumerOrderShippingGroupList().first();
    beforeUpdateConsumerOrderShippingGroupProperties(
        userContext, item, consumerOrderId, id, name, amount, tokensExpr);
    item.updateName(name);
    item.updateAmount(amount);

    // checkParamsForAddingConsumerOrderShippingGroup(userContext,consumerOrderId,name, code,
    // used,tokensExpr);
    ConsumerOrder consumerOrder =
        saveConsumerOrder(
            userContext,
            consumerOrderToUpdate,
            tokens().withConsumerOrderShippingGroupList().done());
    synchronized (consumerOrder) {
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateConsumerOrderShippingGroupProperties(
      RetailscmUserContext userContext,
      ConsumerOrderShippingGroup item,
      String consumerOrderId,
      String id,
      String name,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected ConsumerOrderShippingGroup createConsumerOrderShippingGroup(
      RetailscmUserContext userContext, String name, BigDecimal amount) throws Exception {

    ConsumerOrderShippingGroup consumerOrderShippingGroup = new ConsumerOrderShippingGroup();

    consumerOrderShippingGroup.setName(name);
    consumerOrderShippingGroup.setAmount(amount);

    return consumerOrderShippingGroup;
  }

  protected ConsumerOrderShippingGroup createIndexedConsumerOrderShippingGroup(
      String id, int version) {

    ConsumerOrderShippingGroup consumerOrderShippingGroup = new ConsumerOrderShippingGroup();
    consumerOrderShippingGroup.setId(id);
    consumerOrderShippingGroup.setVersion(version);
    return consumerOrderShippingGroup;
  }

  protected void checkParamsForRemovingConsumerOrderShippingGroupList(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderShippingGroupIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    for (String consumerOrderShippingGroupIdItem : consumerOrderShippingGroupIds) {
      checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder removeConsumerOrderShippingGroupList(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderShippingGroupIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingConsumerOrderShippingGroupList(
        userContext, consumerOrderId, consumerOrderShippingGroupIds, tokensExpr);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrderDaoOf(userContext)
          .planToRemoveConsumerOrderShippingGroupList(
              consumerOrder, consumerOrderShippingGroupIds, allTokens());
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());
      deleteRelationListInGraph(userContext, consumerOrder.getConsumerOrderShippingGroupList());
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingConsumerOrderShippingGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderShippingGroupId,
      int consumerOrderShippingGroupVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
    checkerOf(userContext)
        .checkVersionOfConsumerOrderShippingGroup(consumerOrderShippingGroupVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder removeConsumerOrderShippingGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderShippingGroupId,
      int consumerOrderShippingGroupVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingConsumerOrderShippingGroup(
        userContext,
        consumerOrderId,
        consumerOrderShippingGroupId,
        consumerOrderShippingGroupVersion,
        tokensExpr);

    ConsumerOrderShippingGroup consumerOrderShippingGroup =
        createIndexedConsumerOrderShippingGroup(
            consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrder.removeConsumerOrderShippingGroup(consumerOrderShippingGroup);
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());
      deleteRelationInGraph(userContext, consumerOrderShippingGroup);
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingConsumerOrderShippingGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderShippingGroupId,
      int consumerOrderShippingGroupVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
    checkerOf(userContext)
        .checkVersionOfConsumerOrderShippingGroup(consumerOrderShippingGroupVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder copyConsumerOrderShippingGroupFrom(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderShippingGroupId,
      int consumerOrderShippingGroupVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingConsumerOrderShippingGroup(
        userContext,
        consumerOrderId,
        consumerOrderShippingGroupId,
        consumerOrderShippingGroupVersion,
        tokensExpr);

    ConsumerOrderShippingGroup consumerOrderShippingGroup =
        createIndexedConsumerOrderShippingGroup(
            consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      consumerOrder.copyConsumerOrderShippingGroupFrom(consumerOrderShippingGroup);
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());

      consumerOrderShippingGroupManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (ConsumerOrderShippingGroup)
                  consumerOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingConsumerOrderShippingGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderShippingGroupId,
      int consumerOrderShippingGroupVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
    checkerOf(userContext)
        .checkVersionOfConsumerOrderShippingGroup(consumerOrderShippingGroupVersion);

    if (ConsumerOrderShippingGroup.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfConsumerOrderShippingGroup(parseString(newValueExpr));
    }

    if (ConsumerOrderShippingGroup.AMOUNT_PROPERTY.equals(property)) {
      checkerOf(userContext).checkAmountOfConsumerOrderShippingGroup(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder updateConsumerOrderShippingGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderShippingGroupId,
      int consumerOrderShippingGroupVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingConsumerOrderShippingGroup(
        userContext,
        consumerOrderId,
        consumerOrderShippingGroupId,
        consumerOrderShippingGroupVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withConsumerOrderShippingGroupList()
            .searchConsumerOrderShippingGroupListWith(
                ConsumerOrderShippingGroup.ID_PROPERTY,
                tokens().equals(),
                consumerOrderShippingGroupId)
            .done();

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, loadTokens);

    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // consumerOrder.removeConsumerOrderShippingGroup( consumerOrderShippingGroup );
      // make changes to AcceleraterAccount.
      ConsumerOrderShippingGroup consumerOrderShippingGroupIdVersionKey =
          createIndexedConsumerOrderShippingGroup(
              consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);

      ConsumerOrderShippingGroup consumerOrderShippingGroup =
          consumerOrder.findTheConsumerOrderShippingGroup(consumerOrderShippingGroupIdVersionKey);
      if (consumerOrderShippingGroup == null) {
        throw new ConsumerOrderManagerException(consumerOrderShippingGroupId + " is NOT FOUND");
      }

      beforeUpdateConsumerOrderShippingGroup(
          userContext,
          consumerOrderShippingGroup,
          consumerOrderId,
          consumerOrderShippingGroupId,
          consumerOrderShippingGroupVersion,
          property,
          newValueExpr,
          tokensExpr);
      consumerOrderShippingGroup.changeProperty(property, newValueExpr);

      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderShippingGroupList().done());
      consumerOrderShippingGroupManagerOf(userContext)
          .onUpdated(
              userContext, consumerOrderShippingGroup, this, "updateConsumerOrderShippingGroup");
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateConsumerOrderShippingGroup(
      RetailscmUserContext userContext,
      ConsumerOrderShippingGroup existed,
      String consumerOrderId,
      String consumerOrderShippingGroupId,
      int consumerOrderShippingGroupVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  protected void checkParamsForAddingConsumerOrderPaymentGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String name,
      String cardNumber,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

    checkerOf(userContext).checkNameOfConsumerOrderPaymentGroup(name);

    checkerOf(userContext).checkCardNumberOfConsumerOrderPaymentGroup(cardNumber);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder addConsumerOrderPaymentGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String name,
      String cardNumber,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingConsumerOrderPaymentGroup(
        userContext, consumerOrderId, name, cardNumber, tokensExpr);

    ConsumerOrderPaymentGroup consumerOrderPaymentGroup =
        createConsumerOrderPaymentGroup(userContext, name, cardNumber);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, emptyOptions());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrder.addConsumerOrderPaymentGroup(consumerOrderPaymentGroup);
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());

      consumerOrderPaymentGroupManagerOf(userContext)
          .onNewInstanceCreated(userContext, consumerOrderPaymentGroup);
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingConsumerOrderPaymentGroupProperties(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String id,
      String name,
      String cardNumber,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderPaymentGroup(id);

    checkerOf(userContext).checkNameOfConsumerOrderPaymentGroup(name);
    checkerOf(userContext).checkCardNumberOfConsumerOrderPaymentGroup(cardNumber);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder updateConsumerOrderPaymentGroupProperties(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String id,
      String name,
      String cardNumber,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingConsumerOrderPaymentGroupProperties(
        userContext, consumerOrderId, id, name, cardNumber, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withConsumerOrderPaymentGroupListList()
            .searchConsumerOrderPaymentGroupListWith(
                ConsumerOrderPaymentGroup.ID_PROPERTY, tokens().is(), id)
            .done();

    ConsumerOrder consumerOrderToUpdate = loadConsumerOrder(userContext, consumerOrderId, options);

    if (consumerOrderToUpdate.getConsumerOrderPaymentGroupList().isEmpty()) {
      throw new ConsumerOrderManagerException(
          "ConsumerOrderPaymentGroup is NOT FOUND with id: '" + id + "'");
    }

    ConsumerOrderPaymentGroup item =
        consumerOrderToUpdate.getConsumerOrderPaymentGroupList().first();
    beforeUpdateConsumerOrderPaymentGroupProperties(
        userContext, item, consumerOrderId, id, name, cardNumber, tokensExpr);
    item.updateName(name);
    item.updateCardNumber(cardNumber);

    // checkParamsForAddingConsumerOrderPaymentGroup(userContext,consumerOrderId,name, code,
    // used,tokensExpr);
    ConsumerOrder consumerOrder =
        saveConsumerOrder(
            userContext,
            consumerOrderToUpdate,
            tokens().withConsumerOrderPaymentGroupList().done());
    synchronized (consumerOrder) {
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateConsumerOrderPaymentGroupProperties(
      RetailscmUserContext userContext,
      ConsumerOrderPaymentGroup item,
      String consumerOrderId,
      String id,
      String name,
      String cardNumber,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected ConsumerOrderPaymentGroup createConsumerOrderPaymentGroup(
      RetailscmUserContext userContext, String name, String cardNumber) throws Exception {

    ConsumerOrderPaymentGroup consumerOrderPaymentGroup = new ConsumerOrderPaymentGroup();

    consumerOrderPaymentGroup.setName(name);
    consumerOrderPaymentGroup.setCardNumber(cardNumber);

    return consumerOrderPaymentGroup;
  }

  protected ConsumerOrderPaymentGroup createIndexedConsumerOrderPaymentGroup(
      String id, int version) {

    ConsumerOrderPaymentGroup consumerOrderPaymentGroup = new ConsumerOrderPaymentGroup();
    consumerOrderPaymentGroup.setId(id);
    consumerOrderPaymentGroup.setVersion(version);
    return consumerOrderPaymentGroup;
  }

  protected void checkParamsForRemovingConsumerOrderPaymentGroupList(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPaymentGroupIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    for (String consumerOrderPaymentGroupIdItem : consumerOrderPaymentGroupIds) {
      checkerOf(userContext).checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder removeConsumerOrderPaymentGroupList(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPaymentGroupIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingConsumerOrderPaymentGroupList(
        userContext, consumerOrderId, consumerOrderPaymentGroupIds, tokensExpr);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrderDaoOf(userContext)
          .planToRemoveConsumerOrderPaymentGroupList(
              consumerOrder, consumerOrderPaymentGroupIds, allTokens());
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());
      deleteRelationListInGraph(userContext, consumerOrder.getConsumerOrderPaymentGroupList());
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingConsumerOrderPaymentGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPaymentGroupId,
      int consumerOrderPaymentGroupVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupId);
    checkerOf(userContext)
        .checkVersionOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder removeConsumerOrderPaymentGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPaymentGroupId,
      int consumerOrderPaymentGroupVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingConsumerOrderPaymentGroup(
        userContext,
        consumerOrderId,
        consumerOrderPaymentGroupId,
        consumerOrderPaymentGroupVersion,
        tokensExpr);

    ConsumerOrderPaymentGroup consumerOrderPaymentGroup =
        createIndexedConsumerOrderPaymentGroup(
            consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrder.removeConsumerOrderPaymentGroup(consumerOrderPaymentGroup);
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());
      deleteRelationInGraph(userContext, consumerOrderPaymentGroup);
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingConsumerOrderPaymentGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPaymentGroupId,
      int consumerOrderPaymentGroupVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupId);
    checkerOf(userContext)
        .checkVersionOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder copyConsumerOrderPaymentGroupFrom(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPaymentGroupId,
      int consumerOrderPaymentGroupVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingConsumerOrderPaymentGroup(
        userContext,
        consumerOrderId,
        consumerOrderPaymentGroupId,
        consumerOrderPaymentGroupVersion,
        tokensExpr);

    ConsumerOrderPaymentGroup consumerOrderPaymentGroup =
        createIndexedConsumerOrderPaymentGroup(
            consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      consumerOrder.copyConsumerOrderPaymentGroupFrom(consumerOrderPaymentGroup);
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());

      consumerOrderPaymentGroupManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (ConsumerOrderPaymentGroup)
                  consumerOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingConsumerOrderPaymentGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPaymentGroupId,
      int consumerOrderPaymentGroupVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupId);
    checkerOf(userContext)
        .checkVersionOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupVersion);

    if (ConsumerOrderPaymentGroup.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfConsumerOrderPaymentGroup(parseString(newValueExpr));
    }

    if (ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)) {
      checkerOf(userContext).checkCardNumberOfConsumerOrderPaymentGroup(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder updateConsumerOrderPaymentGroup(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPaymentGroupId,
      int consumerOrderPaymentGroupVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingConsumerOrderPaymentGroup(
        userContext,
        consumerOrderId,
        consumerOrderPaymentGroupId,
        consumerOrderPaymentGroupVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withConsumerOrderPaymentGroupList()
            .searchConsumerOrderPaymentGroupListWith(
                ConsumerOrderPaymentGroup.ID_PROPERTY,
                tokens().equals(),
                consumerOrderPaymentGroupId)
            .done();

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, loadTokens);

    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // consumerOrder.removeConsumerOrderPaymentGroup( consumerOrderPaymentGroup );
      // make changes to AcceleraterAccount.
      ConsumerOrderPaymentGroup consumerOrderPaymentGroupIdVersionKey =
          createIndexedConsumerOrderPaymentGroup(
              consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);

      ConsumerOrderPaymentGroup consumerOrderPaymentGroup =
          consumerOrder.findTheConsumerOrderPaymentGroup(consumerOrderPaymentGroupIdVersionKey);
      if (consumerOrderPaymentGroup == null) {
        throw new ConsumerOrderManagerException(consumerOrderPaymentGroupId + " is NOT FOUND");
      }

      beforeUpdateConsumerOrderPaymentGroup(
          userContext,
          consumerOrderPaymentGroup,
          consumerOrderId,
          consumerOrderPaymentGroupId,
          consumerOrderPaymentGroupVersion,
          property,
          newValueExpr,
          tokensExpr);
      consumerOrderPaymentGroup.changeProperty(property, newValueExpr);

      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderPaymentGroupList().done());
      consumerOrderPaymentGroupManagerOf(userContext)
          .onUpdated(
              userContext, consumerOrderPaymentGroup, this, "updateConsumerOrderPaymentGroup");
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateConsumerOrderPaymentGroup(
      RetailscmUserContext userContext,
      ConsumerOrderPaymentGroup existed,
      String consumerOrderId,
      String consumerOrderPaymentGroupId,
      int consumerOrderPaymentGroupVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  protected void checkParamsForAddingConsumerOrderPriceAdjustment(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String name,
      BigDecimal amount,
      String provider,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

    checkerOf(userContext).checkNameOfConsumerOrderPriceAdjustment(name);

    checkerOf(userContext).checkAmountOfConsumerOrderPriceAdjustment(amount);

    checkerOf(userContext).checkProviderOfConsumerOrderPriceAdjustment(provider);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder addConsumerOrderPriceAdjustment(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String name,
      BigDecimal amount,
      String provider,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingConsumerOrderPriceAdjustment(
        userContext, consumerOrderId, name, amount, provider, tokensExpr);

    ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment =
        createConsumerOrderPriceAdjustment(userContext, name, amount, provider);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, emptyOptions());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrder.addConsumerOrderPriceAdjustment(consumerOrderPriceAdjustment);
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());

      consumerOrderPriceAdjustmentManagerOf(userContext)
          .onNewInstanceCreated(userContext, consumerOrderPriceAdjustment);
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingConsumerOrderPriceAdjustmentProperties(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String id,
      String name,
      BigDecimal amount,
      String provider,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(id);

    checkerOf(userContext).checkNameOfConsumerOrderPriceAdjustment(name);
    checkerOf(userContext).checkAmountOfConsumerOrderPriceAdjustment(amount);
    checkerOf(userContext).checkProviderOfConsumerOrderPriceAdjustment(provider);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder updateConsumerOrderPriceAdjustmentProperties(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String id,
      String name,
      BigDecimal amount,
      String provider,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingConsumerOrderPriceAdjustmentProperties(
        userContext, consumerOrderId, id, name, amount, provider, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withConsumerOrderPriceAdjustmentListList()
            .searchConsumerOrderPriceAdjustmentListWith(
                ConsumerOrderPriceAdjustment.ID_PROPERTY, tokens().is(), id)
            .done();

    ConsumerOrder consumerOrderToUpdate = loadConsumerOrder(userContext, consumerOrderId, options);

    if (consumerOrderToUpdate.getConsumerOrderPriceAdjustmentList().isEmpty()) {
      throw new ConsumerOrderManagerException(
          "ConsumerOrderPriceAdjustment is NOT FOUND with id: '" + id + "'");
    }

    ConsumerOrderPriceAdjustment item =
        consumerOrderToUpdate.getConsumerOrderPriceAdjustmentList().first();
    beforeUpdateConsumerOrderPriceAdjustmentProperties(
        userContext, item, consumerOrderId, id, name, amount, provider, tokensExpr);
    item.updateName(name);
    item.updateAmount(amount);
    item.updateProvider(provider);

    // checkParamsForAddingConsumerOrderPriceAdjustment(userContext,consumerOrderId,name, code,
    // used,tokensExpr);
    ConsumerOrder consumerOrder =
        saveConsumerOrder(
            userContext,
            consumerOrderToUpdate,
            tokens().withConsumerOrderPriceAdjustmentList().done());
    synchronized (consumerOrder) {
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateConsumerOrderPriceAdjustmentProperties(
      RetailscmUserContext userContext,
      ConsumerOrderPriceAdjustment item,
      String consumerOrderId,
      String id,
      String name,
      BigDecimal amount,
      String provider,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(
      RetailscmUserContext userContext, String name, BigDecimal amount, String provider)
      throws Exception {

    ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = new ConsumerOrderPriceAdjustment();

    consumerOrderPriceAdjustment.setName(name);
    consumerOrderPriceAdjustment.setAmount(amount);
    consumerOrderPriceAdjustment.setProvider(provider);

    return consumerOrderPriceAdjustment;
  }

  protected ConsumerOrderPriceAdjustment createIndexedConsumerOrderPriceAdjustment(
      String id, int version) {

    ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = new ConsumerOrderPriceAdjustment();
    consumerOrderPriceAdjustment.setId(id);
    consumerOrderPriceAdjustment.setVersion(version);
    return consumerOrderPriceAdjustment;
  }

  protected void checkParamsForRemovingConsumerOrderPriceAdjustmentList(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPriceAdjustmentIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    for (String consumerOrderPriceAdjustmentIdItem : consumerOrderPriceAdjustmentIds) {
      checkerOf(userContext)
          .checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder removeConsumerOrderPriceAdjustmentList(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPriceAdjustmentIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingConsumerOrderPriceAdjustmentList(
        userContext, consumerOrderId, consumerOrderPriceAdjustmentIds, tokensExpr);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrderDaoOf(userContext)
          .planToRemoveConsumerOrderPriceAdjustmentList(
              consumerOrder, consumerOrderPriceAdjustmentIds, allTokens());
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());
      deleteRelationListInGraph(userContext, consumerOrder.getConsumerOrderPriceAdjustmentList());
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingConsumerOrderPriceAdjustment(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPriceAdjustmentId,
      int consumerOrderPriceAdjustmentVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
    checkerOf(userContext)
        .checkVersionOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder removeConsumerOrderPriceAdjustment(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPriceAdjustmentId,
      int consumerOrderPriceAdjustmentVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingConsumerOrderPriceAdjustment(
        userContext,
        consumerOrderId,
        consumerOrderPriceAdjustmentId,
        consumerOrderPriceAdjustmentVersion,
        tokensExpr);

    ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment =
        createIndexedConsumerOrderPriceAdjustment(
            consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrder.removeConsumerOrderPriceAdjustment(consumerOrderPriceAdjustment);
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());
      deleteRelationInGraph(userContext, consumerOrderPriceAdjustment);
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingConsumerOrderPriceAdjustment(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPriceAdjustmentId,
      int consumerOrderPriceAdjustmentVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
    checkerOf(userContext)
        .checkVersionOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder copyConsumerOrderPriceAdjustmentFrom(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPriceAdjustmentId,
      int consumerOrderPriceAdjustmentVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingConsumerOrderPriceAdjustment(
        userContext,
        consumerOrderId,
        consumerOrderPriceAdjustmentId,
        consumerOrderPriceAdjustmentVersion,
        tokensExpr);

    ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment =
        createIndexedConsumerOrderPriceAdjustment(
            consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      consumerOrder.copyConsumerOrderPriceAdjustmentFrom(consumerOrderPriceAdjustment);
      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());

      consumerOrderPriceAdjustmentManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (ConsumerOrderPriceAdjustment)
                  consumerOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingConsumerOrderPriceAdjustment(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPriceAdjustmentId,
      int consumerOrderPriceAdjustmentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
    checkerOf(userContext)
        .checkVersionOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentVersion);

    if (ConsumerOrderPriceAdjustment.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfConsumerOrderPriceAdjustment(parseString(newValueExpr));
    }

    if (ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY.equals(property)) {
      checkerOf(userContext)
          .checkAmountOfConsumerOrderPriceAdjustment(parseBigDecimal(newValueExpr));
    }

    if (ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY.equals(property)) {
      checkerOf(userContext).checkProviderOfConsumerOrderPriceAdjustment(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder updateConsumerOrderPriceAdjustment(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String consumerOrderPriceAdjustmentId,
      int consumerOrderPriceAdjustmentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingConsumerOrderPriceAdjustment(
        userContext,
        consumerOrderId,
        consumerOrderPriceAdjustmentId,
        consumerOrderPriceAdjustmentVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withConsumerOrderPriceAdjustmentList()
            .searchConsumerOrderPriceAdjustmentListWith(
                ConsumerOrderPriceAdjustment.ID_PROPERTY,
                tokens().equals(),
                consumerOrderPriceAdjustmentId)
            .done();

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, loadTokens);

    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // consumerOrder.removeConsumerOrderPriceAdjustment( consumerOrderPriceAdjustment );
      // make changes to AcceleraterAccount.
      ConsumerOrderPriceAdjustment consumerOrderPriceAdjustmentIdVersionKey =
          createIndexedConsumerOrderPriceAdjustment(
              consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);

      ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment =
          consumerOrder.findTheConsumerOrderPriceAdjustment(
              consumerOrderPriceAdjustmentIdVersionKey);
      if (consumerOrderPriceAdjustment == null) {
        throw new ConsumerOrderManagerException(consumerOrderPriceAdjustmentId + " is NOT FOUND");
      }

      beforeUpdateConsumerOrderPriceAdjustment(
          userContext,
          consumerOrderPriceAdjustment,
          consumerOrderId,
          consumerOrderPriceAdjustmentId,
          consumerOrderPriceAdjustmentVersion,
          property,
          newValueExpr,
          tokensExpr);
      consumerOrderPriceAdjustment.changeProperty(property, newValueExpr);

      consumerOrder =
          saveConsumerOrder(
              userContext, consumerOrder, tokens().withConsumerOrderPriceAdjustmentList().done());
      consumerOrderPriceAdjustmentManagerOf(userContext)
          .onUpdated(
              userContext,
              consumerOrderPriceAdjustment,
              this,
              "updateConsumerOrderPriceAdjustment");
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateConsumerOrderPriceAdjustment(
      RetailscmUserContext userContext,
      ConsumerOrderPriceAdjustment existed,
      String consumerOrderId,
      String consumerOrderPriceAdjustmentId,
      int consumerOrderPriceAdjustmentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  protected void checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String consumerOrderId,
      Date occureTime,
      String ownerId,
      String number,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);

    checkerOf(userContext).checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(occureTime);

    checkerOf(userContext).checkOwnerIdOfRetailStoreMemberGiftCardConsumeRecord(ownerId);

    checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCardConsumeRecord(number);

    checkerOf(userContext).checkAmountOfRetailStoreMemberGiftCardConsumeRecord(amount);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder addRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String consumerOrderId,
      Date occureTime,
      String ownerId,
      String number,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(
        userContext, consumerOrderId, occureTime, ownerId, number, amount, tokensExpr);

    RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
        createRetailStoreMemberGiftCardConsumeRecord(
            userContext, occureTime, ownerId, number, amount);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, emptyOptions());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrder.addRetailStoreMemberGiftCardConsumeRecord(
          retailStoreMemberGiftCardConsumeRecord);
      consumerOrder =
          saveConsumerOrder(
              userContext,
              consumerOrder,
              tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());

      retailStoreMemberGiftCardConsumeRecordManagerOf(userContext)
          .onNewInstanceCreated(userContext, retailStoreMemberGiftCardConsumeRecord);
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecordProperties(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String id,
      Date occureTime,
      String number,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(id);

    checkerOf(userContext).checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(occureTime);
    checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCardConsumeRecord(number);
    checkerOf(userContext).checkAmountOfRetailStoreMemberGiftCardConsumeRecord(amount);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder updateRetailStoreMemberGiftCardConsumeRecordProperties(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String id,
      Date occureTime,
      String number,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecordProperties(
        userContext, consumerOrderId, id, occureTime, number, amount, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withRetailStoreMemberGiftCardConsumeRecordListList()
            .searchRetailStoreMemberGiftCardConsumeRecordListWith(
                RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY, tokens().is(), id)
            .done();

    ConsumerOrder consumerOrderToUpdate = loadConsumerOrder(userContext, consumerOrderId, options);

    if (consumerOrderToUpdate.getRetailStoreMemberGiftCardConsumeRecordList().isEmpty()) {
      throw new ConsumerOrderManagerException(
          "RetailStoreMemberGiftCardConsumeRecord is NOT FOUND with id: '" + id + "'");
    }

    RetailStoreMemberGiftCardConsumeRecord item =
        consumerOrderToUpdate.getRetailStoreMemberGiftCardConsumeRecordList().first();
    beforeUpdateRetailStoreMemberGiftCardConsumeRecordProperties(
        userContext, item, consumerOrderId, id, occureTime, number, amount, tokensExpr);
    item.updateOccureTime(occureTime);
    item.updateNumber(number);
    item.updateAmount(amount);

    // checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(userContext,consumerOrderId,name,
    // code, used,tokensExpr);
    ConsumerOrder consumerOrder =
        saveConsumerOrder(
            userContext,
            consumerOrderToUpdate,
            tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
    synchronized (consumerOrder) {
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateRetailStoreMemberGiftCardConsumeRecordProperties(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCardConsumeRecord item,
      String consumerOrderId,
      String id,
      Date occureTime,
      String number,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      Date occureTime,
      String ownerId,
      String number,
      BigDecimal amount)
      throws Exception {

    RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
        new RetailStoreMemberGiftCardConsumeRecord();

    retailStoreMemberGiftCardConsumeRecord.setOccureTime(occureTime);
    RetailStoreMemberGiftCard owner = new RetailStoreMemberGiftCard();
    owner.setId(ownerId);
    retailStoreMemberGiftCardConsumeRecord.setOwner(owner);
    retailStoreMemberGiftCardConsumeRecord.setNumber(number);
    retailStoreMemberGiftCardConsumeRecord.setAmount(amount);

    return retailStoreMemberGiftCardConsumeRecord;
  }

  protected RetailStoreMemberGiftCardConsumeRecord
      createIndexedRetailStoreMemberGiftCardConsumeRecord(String id, int version) {

    RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
        new RetailStoreMemberGiftCardConsumeRecord();
    retailStoreMemberGiftCardConsumeRecord.setId(id);
    retailStoreMemberGiftCardConsumeRecord.setVersion(version);
    return retailStoreMemberGiftCardConsumeRecord;
  }

  protected void checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecordList(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String retailStoreMemberGiftCardConsumeRecordIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    for (String retailStoreMemberGiftCardConsumeRecordIdItem :
        retailStoreMemberGiftCardConsumeRecordIds) {
      checkerOf(userContext)
          .checkIdOfRetailStoreMemberGiftCardConsumeRecord(
              retailStoreMemberGiftCardConsumeRecordIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder removeRetailStoreMemberGiftCardConsumeRecordList(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String retailStoreMemberGiftCardConsumeRecordIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecordList(
        userContext, consumerOrderId, retailStoreMemberGiftCardConsumeRecordIds, tokensExpr);

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrderDaoOf(userContext)
          .planToRemoveRetailStoreMemberGiftCardConsumeRecordList(
              consumerOrder, retailStoreMemberGiftCardConsumeRecordIds, allTokens());
      consumerOrder =
          saveConsumerOrder(
              userContext,
              consumerOrder,
              tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
      deleteRelationListInGraph(
          userContext, consumerOrder.getRetailStoreMemberGiftCardConsumeRecordList());
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext)
        .checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
    checkerOf(userContext)
        .checkVersionOfRetailStoreMemberGiftCardConsumeRecord(
            retailStoreMemberGiftCardConsumeRecordVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder removeRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(
        userContext,
        consumerOrderId,
        retailStoreMemberGiftCardConsumeRecordId,
        retailStoreMemberGiftCardConsumeRecordVersion,
        tokensExpr);

    RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
        createIndexedRetailStoreMemberGiftCardConsumeRecord(
            retailStoreMemberGiftCardConsumeRecordId,
            retailStoreMemberGiftCardConsumeRecordVersion);
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      consumerOrder.removeRetailStoreMemberGiftCardConsumeRecord(
          retailStoreMemberGiftCardConsumeRecord);
      consumerOrder =
          saveConsumerOrder(
              userContext,
              consumerOrder,
              tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
      deleteRelationInGraph(userContext, retailStoreMemberGiftCardConsumeRecord);
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext)
        .checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
    checkerOf(userContext)
        .checkVersionOfRetailStoreMemberGiftCardConsumeRecord(
            retailStoreMemberGiftCardConsumeRecordVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder copyRetailStoreMemberGiftCardConsumeRecordFrom(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingRetailStoreMemberGiftCardConsumeRecord(
        userContext,
        consumerOrderId,
        retailStoreMemberGiftCardConsumeRecordId,
        retailStoreMemberGiftCardConsumeRecordVersion,
        tokensExpr);

    RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
        createIndexedRetailStoreMemberGiftCardConsumeRecord(
            retailStoreMemberGiftCardConsumeRecordId,
            retailStoreMemberGiftCardConsumeRecordVersion);
    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, allTokens());
    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      consumerOrder.copyRetailStoreMemberGiftCardConsumeRecordFrom(
          retailStoreMemberGiftCardConsumeRecord);
      consumerOrder =
          saveConsumerOrder(
              userContext,
              consumerOrder,
              tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());

      retailStoreMemberGiftCardConsumeRecordManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (RetailStoreMemberGiftCardConsumeRecord)
                  consumerOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
    checkerOf(userContext)
        .checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
    checkerOf(userContext)
        .checkVersionOfRetailStoreMemberGiftCardConsumeRecord(
            retailStoreMemberGiftCardConsumeRecordVersion);

    if (RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY.equals(property)) {
      checkerOf(userContext)
          .checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(parseDate(newValueExpr));
    }

    if (RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY.equals(property)) {
      checkerOf(userContext)
          .checkNumberOfRetailStoreMemberGiftCardConsumeRecord(parseString(newValueExpr));
    }

    if (RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY.equals(property)) {
      checkerOf(userContext)
          .checkAmountOfRetailStoreMemberGiftCardConsumeRecord(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderManagerException.class);
  }

  public ConsumerOrder updateRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String consumerOrderId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(
        userContext,
        consumerOrderId,
        retailStoreMemberGiftCardConsumeRecordId,
        retailStoreMemberGiftCardConsumeRecordVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withRetailStoreMemberGiftCardConsumeRecordList()
            .searchRetailStoreMemberGiftCardConsumeRecordListWith(
                RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY,
                tokens().equals(),
                retailStoreMemberGiftCardConsumeRecordId)
            .done();

    ConsumerOrder consumerOrder = loadConsumerOrder(userContext, consumerOrderId, loadTokens);

    synchronized (consumerOrder) {
      // Will be good when the consumerOrder loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // consumerOrder.removeRetailStoreMemberGiftCardConsumeRecord(
      // retailStoreMemberGiftCardConsumeRecord );
      // make changes to AcceleraterAccount.
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordIdVersionKey =
          createIndexedRetailStoreMemberGiftCardConsumeRecord(
              retailStoreMemberGiftCardConsumeRecordId,
              retailStoreMemberGiftCardConsumeRecordVersion);

      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
          consumerOrder.findTheRetailStoreMemberGiftCardConsumeRecord(
              retailStoreMemberGiftCardConsumeRecordIdVersionKey);
      if (retailStoreMemberGiftCardConsumeRecord == null) {
        throw new ConsumerOrderManagerException(
            retailStoreMemberGiftCardConsumeRecordId + " is NOT FOUND");
      }

      beforeUpdateRetailStoreMemberGiftCardConsumeRecord(
          userContext,
          retailStoreMemberGiftCardConsumeRecord,
          consumerOrderId,
          retailStoreMemberGiftCardConsumeRecordId,
          retailStoreMemberGiftCardConsumeRecordVersion,
          property,
          newValueExpr,
          tokensExpr);
      retailStoreMemberGiftCardConsumeRecord.changeProperty(property, newValueExpr);

      consumerOrder =
          saveConsumerOrder(
              userContext,
              consumerOrder,
              tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
      retailStoreMemberGiftCardConsumeRecordManagerOf(userContext)
          .onUpdated(
              userContext,
              retailStoreMemberGiftCardConsumeRecord,
              this,
              "updateRetailStoreMemberGiftCardConsumeRecord");
      return present(userContext, consumerOrder, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCardConsumeRecord existed,
      String consumerOrderId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrder newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    consumerOrderDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   ConsumerOrder newConsumerOrder = this.createConsumerOrder(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newConsumerOrder
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
    key.put(UserApp.APP_TYPE_PROPERTY, ConsumerOrder.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<ConsumerOrder> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<RetailStoreMember> consumerList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, RetailStoreMember.class);
    userContext.getDAOGroup().enhanceList(consumerList, RetailStoreMember.class);
    List<RetailStore> storeList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStore.class);
    userContext.getDAOGroup().enhanceList(storeList, RetailStore.class);
  }

  public Object listByConsumer(RetailscmUserContext userContext, String consumerId)
      throws Exception {
    return listPageByConsumer(userContext, consumerId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByConsumer(
      RetailscmUserContext userContext, String consumerId, int start, int count) throws Exception {
    SmartList<ConsumerOrder> list =
        consumerOrderDaoOf(userContext)
            .findConsumerOrderByConsumer(consumerId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(ConsumerOrder.class);
    page.setContainerObject(RetailStoreMember.withId(consumerId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("消费者订单列表");
    page.setRequestName("listByConsumer");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByConsumer/%s/", getBeanName(), consumerId)));

    page.assemblerContent(userContext, "listByConsumer");
    return page.doRender(userContext);
  }

  public Object listByStore(RetailscmUserContext userContext, String storeId) throws Exception {
    return listPageByStore(userContext, storeId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByStore(
      RetailscmUserContext userContext, String storeId, int start, int count) throws Exception {
    SmartList<ConsumerOrder> list =
        consumerOrderDaoOf(userContext)
            .findConsumerOrderByStore(storeId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(ConsumerOrder.class);
    page.setContainerObject(RetailStore.withId(storeId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("消费者订单列表");
    page.setRequestName("listByStore");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByStore/%s/", getBeanName(), storeId)));

    page.assemblerContent(userContext, "listByStore");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String consumerOrderId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    ConsumerOrder merchantObj = (ConsumerOrder) this.view(userContext, consumerOrderId);
    String merchantObjId = consumerOrderId;
    String linkToUrl = "consumerOrderManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "消费者订单" + "详情";
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
        MapUtil.put("id", "2-title")
            .put("fieldName", "title")
            .put("label", "头衔")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("title", merchantObj.getTitle());

    propList.add(
        MapUtil.put("id", "3-consumer")
            .put("fieldName", "consumer")
            .put("label", "消费者")
            .put("type", "auto")
            .put("linkToUrl", "retailStoreMemberManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"mobile_phone\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("consumer", merchantObj.getConsumer());

    propList.add(
        MapUtil.put("id", "4-store")
            .put("fieldName", "store")
            .put("label", "商场")
            .put("type", "auto")
            .put("linkToUrl", "retailStoreManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("store", merchantObj.getStore());

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

    // 处理Section：consumerOrderLineItemListSection
    Map consumerOrderLineItemListSection =
        ListofUtils.buildSection(
            "consumerOrderLineItemListSection",
            "消费者订单行项目列表",
            null,
            "",
            "__no_group",
            "consumerOrderLineItemManager/listByBizOrder/" + merchantObjId + "/",
            "auto");
    sections.add(consumerOrderLineItemListSection);

    result.put(
        "consumerOrderLineItemListSection",
        ListofUtils.toShortList(
            merchantObj.getConsumerOrderLineItemList(), "consumerOrderLineItem"));

    // 处理Section：consumerOrderShippingGroupListSection
    Map consumerOrderShippingGroupListSection =
        ListofUtils.buildSection(
            "consumerOrderShippingGroupListSection",
            "消费者订单发货组列表",
            null,
            "",
            "__no_group",
            "consumerOrderShippingGroupManager/listByBizOrder/" + merchantObjId + "/",
            "auto");
    sections.add(consumerOrderShippingGroupListSection);

    result.put(
        "consumerOrderShippingGroupListSection",
        ListofUtils.toShortList(
            merchantObj.getConsumerOrderShippingGroupList(), "consumerOrderShippingGroup"));

    // 处理Section：consumerOrderPaymentGroupListSection
    Map consumerOrderPaymentGroupListSection =
        ListofUtils.buildSection(
            "consumerOrderPaymentGroupListSection",
            "消费者订单支付组列表",
            null,
            "",
            "__no_group",
            "consumerOrderPaymentGroupManager/listByBizOrder/" + merchantObjId + "/",
            "auto");
    sections.add(consumerOrderPaymentGroupListSection);

    result.put(
        "consumerOrderPaymentGroupListSection",
        ListofUtils.toShortList(
            merchantObj.getConsumerOrderPaymentGroupList(), "consumerOrderPaymentGroup"));

    // 处理Section：consumerOrderPriceAdjustmentListSection
    Map consumerOrderPriceAdjustmentListSection =
        ListofUtils.buildSection(
            "consumerOrderPriceAdjustmentListSection",
            "消费者订单价格调整表",
            null,
            "",
            "__no_group",
            "consumerOrderPriceAdjustmentManager/listByBizOrder/" + merchantObjId + "/",
            "auto");
    sections.add(consumerOrderPriceAdjustmentListSection);

    result.put(
        "consumerOrderPriceAdjustmentListSection",
        ListofUtils.toShortList(
            merchantObj.getConsumerOrderPriceAdjustmentList(), "consumerOrderPriceAdjustment"));

    // 处理Section：retailStoreMemberGiftCardConsumeRecordListSection
    Map retailStoreMemberGiftCardConsumeRecordListSection =
        ListofUtils.buildSection(
            "retailStoreMemberGiftCardConsumeRecordListSection",
            "零售会员礼品卡消费记录列表",
            null,
            "",
            "__no_group",
            "retailStoreMemberGiftCardConsumeRecordManager/listByBizOrder/" + merchantObjId + "/",
            "auto");
    sections.add(retailStoreMemberGiftCardConsumeRecordListSection);

    result.put(
        "retailStoreMemberGiftCardConsumeRecordListSection",
        ListofUtils.toShortList(
            merchantObj.getRetailStoreMemberGiftCardConsumeRecordList(),
            "retailStoreMemberGiftCardConsumeRecord"));

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
