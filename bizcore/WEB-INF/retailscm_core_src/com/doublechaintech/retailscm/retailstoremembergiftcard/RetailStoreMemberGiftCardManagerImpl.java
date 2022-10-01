package com.doublechaintech.retailscm.retailstoremembergiftcard;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.iamservice.*;
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

public class RetailStoreMemberGiftCardManagerImpl extends CustomRetailscmCheckerManager
    implements RetailStoreMemberGiftCardManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        RetailStoreMemberGiftCardTokens.start().withTokenFromListName(listName).done();
    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        (RetailStoreMemberGiftCard) this.loadRetailStoreMemberGiftCard(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = retailStoreMemberGiftCard.collectReferencesFromLists();
    retailStoreMemberGiftCardDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, retailStoreMemberGiftCard, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new RetailStoreMemberGiftCardGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "RetailStoreMemberGiftCard";

  @Override
  public RetailStoreMemberGiftCardDAO daoOf(RetailscmUserContext userContext) {
    return retailStoreMemberGiftCardDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws RetailStoreMemberGiftCardManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new RetailStoreMemberGiftCardManagerException(message);
  }

  protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCard(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCard retailStoreMemberGiftCard,
      String[] tokensExpr)
      throws Exception {
    // return getRetailStoreMemberGiftCardDAO().save(retailStoreMemberGiftCard, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens);
  }

  protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCardDetail(
      RetailscmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard)
      throws Exception {

    return saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, allTokens());
  }

  public RetailStoreMemberGiftCard loadRetailStoreMemberGiftCard(
      RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreMemberGiftCard, tokens);
  }

  public RetailStoreMemberGiftCard searchRetailStoreMemberGiftCard(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreMemberGiftCard, tokens);
  }

  protected RetailStoreMemberGiftCard present(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCard retailStoreMemberGiftCard,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, retailStoreMemberGiftCard, tokens);

    RetailStoreMemberGiftCard retailStoreMemberGiftCardToPresent =
        retailStoreMemberGiftCardDaoOf(userContext).present(retailStoreMemberGiftCard, tokens);

    List<BaseEntity> entityListToNaming =
        retailStoreMemberGiftCardToPresent.collectReferencesFromLists();
    retailStoreMemberGiftCardDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, retailStoreMemberGiftCard, tokens);

    return retailStoreMemberGiftCardToPresent;
  }

  public RetailStoreMemberGiftCard loadRetailStoreMemberGiftCardDetail(
      RetailscmUserContext userContext, String retailStoreMemberGiftCardId) throws Exception {
    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
    return present(userContext, retailStoreMemberGiftCard, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String retailStoreMemberGiftCardId)
      throws Exception {
    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, viewTokens());
    markVisited(userContext, retailStoreMemberGiftCard);
    return present(userContext, retailStoreMemberGiftCard, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String retailStoreMemberGiftCardId)
      throws Exception {
    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, viewTokens());
    retailStoreMemberGiftCard.summarySuffix();
    markVisited(userContext, retailStoreMemberGiftCard);
    return present(userContext, retailStoreMemberGiftCard, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String retailStoreMemberGiftCardId)
      throws Exception {
    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, analyzeTokens());
    markVisited(userContext, retailStoreMemberGiftCard);
    return present(userContext, retailStoreMemberGiftCard, analyzeTokens());
  }

  protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCard(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCard retailStoreMemberGiftCard,
      Map<String, Object> tokens)
      throws Exception {

    return retailStoreMemberGiftCardDaoOf(userContext).save(retailStoreMemberGiftCard, tokens);
  }

  protected RetailStoreMemberGiftCard loadRetailStoreMemberGiftCard(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);

    return retailStoreMemberGiftCardDaoOf(userContext).load(retailStoreMemberGiftCardId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCard retailStoreMemberGiftCard,
      Map<String, Object> tokens) {
    super.addActions(userContext, retailStoreMemberGiftCard, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object>
    // tokens){

  @Override
  public List<RetailStoreMemberGiftCard> searchRetailStoreMemberGiftCardList(
      RetailscmUserContext ctx, RetailStoreMemberGiftCardRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<RetailStoreMemberGiftCard> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public RetailStoreMemberGiftCard searchRetailStoreMemberGiftCard(
      RetailscmUserContext ctx, RetailStoreMemberGiftCardRequest pRequest) {
    pRequest.limit(0, 1);
    List<RetailStoreMemberGiftCard> list = searchRetailStoreMemberGiftCardList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(
      RetailscmUserContext userContext,
      String name,
      String ownerId,
      String number,
      BigDecimal remain)
      throws Exception {

    checkerOf(userContext).checkNameOfRetailStoreMemberGiftCard(name);
    checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCard(number);
    checkerOf(userContext).checkRemainOfRetailStoreMemberGiftCard(remain);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);

    RetailStoreMemberGiftCard retailStoreMemberGiftCard = createNewRetailStoreMemberGiftCard();

    retailStoreMemberGiftCard.setName(name);

    RetailStoreMember owner = loadRetailStoreMember(userContext, ownerId, emptyOptions());
    retailStoreMemberGiftCard.setOwner(owner);

    retailStoreMemberGiftCard.setNumber(number);
    retailStoreMemberGiftCard.setRemain(remain);

    retailStoreMemberGiftCard =
        saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, emptyOptions());

    onNewInstanceCreated(userContext, retailStoreMemberGiftCard);
    return retailStoreMemberGiftCard;
  }

  protected RetailStoreMemberGiftCard createNewRetailStoreMemberGiftCard() {

    return new RetailStoreMemberGiftCard();
  }

  protected void checkParamsForUpdatingRetailStoreMemberGiftCard(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      int retailStoreMemberGiftCardVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
    checkerOf(userContext)
        .checkVersionOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardVersion);

    if (RetailStoreMemberGiftCard.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfRetailStoreMemberGiftCard(parseString(newValueExpr));
    }

    if (RetailStoreMemberGiftCard.NUMBER_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCard(parseString(newValueExpr));
    }
    if (RetailStoreMemberGiftCard.REMAIN_PROPERTY.equals(property)) {

      checkerOf(userContext).checkRemainOfRetailStoreMemberGiftCard(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
  }

  public RetailStoreMemberGiftCard clone(
      RetailscmUserContext userContext, String fromRetailStoreMemberGiftCardId) throws Exception {

    return retailStoreMemberGiftCardDaoOf(userContext)
        .clone(fromRetailStoreMemberGiftCardId, this.allTokens());
  }

  public RetailStoreMemberGiftCard internalSaveRetailStoreMemberGiftCard(
      RetailscmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard)
      throws Exception {
    return internalSaveRetailStoreMemberGiftCard(
        userContext, retailStoreMemberGiftCard, allTokens());
  }

  public RetailStoreMemberGiftCard internalSaveRetailStoreMemberGiftCard(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCard retailStoreMemberGiftCard,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId,
    // retailStoreMemberGiftCardVersion, property, newValueExpr, tokensExpr);

    synchronized (retailStoreMemberGiftCard) {
      // will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreMemberGiftCard.
      if (retailStoreMemberGiftCard.isChanged()) {}

      // checkerOf(userContext).checkAndFixRetailStoreMemberGiftCard(retailStoreMemberGiftCard);
      retailStoreMemberGiftCard =
          saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, options);
      return retailStoreMemberGiftCard;
    }
  }

  public RetailStoreMemberGiftCard updateRetailStoreMemberGiftCard(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      int retailStoreMemberGiftCardVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreMemberGiftCard(
        userContext,
        retailStoreMemberGiftCardId,
        retailStoreMemberGiftCardVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
    if (retailStoreMemberGiftCard.getVersion() != retailStoreMemberGiftCardVersion) {
      String message =
          "The target version("
              + retailStoreMemberGiftCard.getVersion()
              + ") is not equals to version("
              + retailStoreMemberGiftCardVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreMemberGiftCard) {
      // will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreMemberGiftCard.

      retailStoreMemberGiftCard.changeProperty(property, newValueExpr);
      retailStoreMemberGiftCard =
          saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().done());
      return present(userContext, retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
      // return saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard,
      // tokens().done());
    }
  }

  public RetailStoreMemberGiftCard updateRetailStoreMemberGiftCardProperty(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      int retailStoreMemberGiftCardVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreMemberGiftCard(
        userContext,
        retailStoreMemberGiftCardId,
        retailStoreMemberGiftCardVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
    if (retailStoreMemberGiftCard.getVersion() != retailStoreMemberGiftCardVersion) {
      String message =
          "The target version("
              + retailStoreMemberGiftCard.getVersion()
              + ") is not equals to version("
              + retailStoreMemberGiftCardVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreMemberGiftCard) {
      // will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreMemberGiftCard.

      retailStoreMemberGiftCard.changeProperty(property, newValueExpr);

      retailStoreMemberGiftCard =
          saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().done());
      return present(userContext, retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
      // return saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard,
      // tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected RetailStoreMemberGiftCardTokens tokens() {
    return RetailStoreMemberGiftCardTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return RetailStoreMemberGiftCardTokens.all();
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
        .sortRetailStoreMemberGiftCardConsumeRecordListWith(
            RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return RetailStoreMemberGiftCardTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherOwner(
      RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String anotherOwnerId)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
    checkerOf(userContext)
        .checkIdOfRetailStoreMember(anotherOwnerId); // check for optional reference

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
  }

  public RetailStoreMemberGiftCard transferToAnotherOwner(
      RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String anotherOwnerId)
      throws Exception {
    checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberGiftCardId, anotherOwnerId);

    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
    synchronized (retailStoreMemberGiftCard) {
      // will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreMember owner = loadRetailStoreMember(userContext, anotherOwnerId, emptyOptions());
      retailStoreMemberGiftCard.updateOwner(owner);

      retailStoreMemberGiftCard =
          saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, emptyOptions());

      return present(userContext, retailStoreMemberGiftCard, allTokens());
    }
  }

  public CandidateRetailStoreMember requestCandidateOwner(
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
            .requestCandidateRetailStoreMemberForRetailStoreMemberGiftCard(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected RetailStoreMember loadRetailStoreMember(
      RetailscmUserContext userContext, String newOwnerId, Map<String, Object> options)
      throws Exception {

    return retailStoreMemberDaoOf(userContext).load(newOwnerId, options);
  }

  // --------------------------------------------------------------

  public RetailStoreMemberGiftCard forgetByAll(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      int retailStoreMemberGiftCardVersion)
      throws Exception {
    return forgetByAllInternal(
        userContext, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
  }

  protected RetailStoreMemberGiftCard forgetByAllInternal(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      int retailStoreMemberGiftCardVersion)
      throws Exception {

    return retailStoreMemberGiftCardDaoOf(userContext)
        .disconnectFromAll(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new RetailStoreMemberGiftCardManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      Date occureTime,
      String bizOrderId,
      String number,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);

    checkerOf(userContext).checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(occureTime);

    checkerOf(userContext).checkBizOrderIdOfRetailStoreMemberGiftCardConsumeRecord(bizOrderId);

    checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCardConsumeRecord(number);

    checkerOf(userContext).checkAmountOfRetailStoreMemberGiftCardConsumeRecord(amount);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
  }

  public RetailStoreMemberGiftCard addRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      Date occureTime,
      String bizOrderId,
      String number,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(
        userContext,
        retailStoreMemberGiftCardId,
        occureTime,
        bizOrderId,
        number,
        amount,
        tokensExpr);

    RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
        createRetailStoreMemberGiftCardConsumeRecord(
            userContext, occureTime, bizOrderId, number, amount);

    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, emptyOptions());
    synchronized (retailStoreMemberGiftCard) {
      // Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreMemberGiftCard.addRetailStoreMemberGiftCardConsumeRecord(
          retailStoreMemberGiftCardConsumeRecord);
      retailStoreMemberGiftCard =
          saveRetailStoreMemberGiftCard(
              userContext,
              retailStoreMemberGiftCard,
              tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());

      retailStoreMemberGiftCardConsumeRecordManagerOf(userContext)
          .onNewInstanceCreated(userContext, retailStoreMemberGiftCardConsumeRecord);
      return present(userContext, retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecordProperties(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      String id,
      Date occureTime,
      String number,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(id);

    checkerOf(userContext).checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(occureTime);
    checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCardConsumeRecord(number);
    checkerOf(userContext).checkAmountOfRetailStoreMemberGiftCardConsumeRecord(amount);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
  }

  public RetailStoreMemberGiftCard updateRetailStoreMemberGiftCardConsumeRecordProperties(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      String id,
      Date occureTime,
      String number,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecordProperties(
        userContext, retailStoreMemberGiftCardId, id, occureTime, number, amount, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withRetailStoreMemberGiftCardConsumeRecordListList()
            .searchRetailStoreMemberGiftCardConsumeRecordListWith(
                RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY, tokens().is(), id)
            .done();

    RetailStoreMemberGiftCard retailStoreMemberGiftCardToUpdate =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, options);

    if (retailStoreMemberGiftCardToUpdate
        .getRetailStoreMemberGiftCardConsumeRecordList()
        .isEmpty()) {
      throw new RetailStoreMemberGiftCardManagerException(
          "RetailStoreMemberGiftCardConsumeRecord is NOT FOUND with id: '" + id + "'");
    }

    RetailStoreMemberGiftCardConsumeRecord item =
        retailStoreMemberGiftCardToUpdate.getRetailStoreMemberGiftCardConsumeRecordList().first();
    beforeUpdateRetailStoreMemberGiftCardConsumeRecordProperties(
        userContext, item, retailStoreMemberGiftCardId, id, occureTime, number, amount, tokensExpr);
    item.updateOccureTime(occureTime);
    item.updateNumber(number);
    item.updateAmount(amount);

    // checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(userContext,retailStoreMemberGiftCardId,name, code, used,tokensExpr);
    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        saveRetailStoreMemberGiftCard(
            userContext,
            retailStoreMemberGiftCardToUpdate,
            tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
    synchronized (retailStoreMemberGiftCard) {
      return present(userContext, retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateRetailStoreMemberGiftCardConsumeRecordProperties(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCardConsumeRecord item,
      String retailStoreMemberGiftCardId,
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
      String bizOrderId,
      String number,
      BigDecimal amount)
      throws Exception {

    RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
        new RetailStoreMemberGiftCardConsumeRecord();

    retailStoreMemberGiftCardConsumeRecord.setOccureTime(occureTime);
    ConsumerOrder bizOrder = new ConsumerOrder();
    bizOrder.setId(bizOrderId);
    retailStoreMemberGiftCardConsumeRecord.setBizOrder(bizOrder);
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
      String retailStoreMemberGiftCardId,
      String retailStoreMemberGiftCardConsumeRecordIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
    for (String retailStoreMemberGiftCardConsumeRecordIdItem :
        retailStoreMemberGiftCardConsumeRecordIds) {
      checkerOf(userContext)
          .checkIdOfRetailStoreMemberGiftCardConsumeRecord(
              retailStoreMemberGiftCardConsumeRecordIdItem);
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
  }

  public RetailStoreMemberGiftCard removeRetailStoreMemberGiftCardConsumeRecordList(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      String retailStoreMemberGiftCardConsumeRecordIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecordList(
        userContext,
        retailStoreMemberGiftCardId,
        retailStoreMemberGiftCardConsumeRecordIds,
        tokensExpr);

    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
    synchronized (retailStoreMemberGiftCard) {
      // Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreMemberGiftCardDaoOf(userContext)
          .planToRemoveRetailStoreMemberGiftCardConsumeRecordList(
              retailStoreMemberGiftCard, retailStoreMemberGiftCardConsumeRecordIds, allTokens());
      retailStoreMemberGiftCard =
          saveRetailStoreMemberGiftCard(
              userContext,
              retailStoreMemberGiftCard,
              tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
      deleteRelationListInGraph(
          userContext, retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList());
      return present(userContext, retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
    checkerOf(userContext)
        .checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
    checkerOf(userContext)
        .checkVersionOfRetailStoreMemberGiftCardConsumeRecord(
            retailStoreMemberGiftCardConsumeRecordVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
  }

  public RetailStoreMemberGiftCard removeRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(
        userContext,
        retailStoreMemberGiftCardId,
        retailStoreMemberGiftCardConsumeRecordId,
        retailStoreMemberGiftCardConsumeRecordVersion,
        tokensExpr);

    RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
        createIndexedRetailStoreMemberGiftCardConsumeRecord(
            retailStoreMemberGiftCardConsumeRecordId,
            retailStoreMemberGiftCardConsumeRecordVersion);
    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
    synchronized (retailStoreMemberGiftCard) {
      // Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreMemberGiftCard.removeRetailStoreMemberGiftCardConsumeRecord(
          retailStoreMemberGiftCardConsumeRecord);
      retailStoreMemberGiftCard =
          saveRetailStoreMemberGiftCard(
              userContext,
              retailStoreMemberGiftCard,
              tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
      deleteRelationInGraph(userContext, retailStoreMemberGiftCardConsumeRecord);
      return present(userContext, retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
    checkerOf(userContext)
        .checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
    checkerOf(userContext)
        .checkVersionOfRetailStoreMemberGiftCardConsumeRecord(
            retailStoreMemberGiftCardConsumeRecordVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
  }

  public RetailStoreMemberGiftCard copyRetailStoreMemberGiftCardConsumeRecordFrom(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingRetailStoreMemberGiftCardConsumeRecord(
        userContext,
        retailStoreMemberGiftCardId,
        retailStoreMemberGiftCardConsumeRecordId,
        retailStoreMemberGiftCardConsumeRecordVersion,
        tokensExpr);

    RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
        createIndexedRetailStoreMemberGiftCardConsumeRecord(
            retailStoreMemberGiftCardConsumeRecordId,
            retailStoreMemberGiftCardConsumeRecordVersion);
    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
    synchronized (retailStoreMemberGiftCard) {
      // Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      retailStoreMemberGiftCard.copyRetailStoreMemberGiftCardConsumeRecordFrom(
          retailStoreMemberGiftCardConsumeRecord);
      retailStoreMemberGiftCard =
          saveRetailStoreMemberGiftCard(
              userContext,
              retailStoreMemberGiftCard,
              tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());

      retailStoreMemberGiftCardConsumeRecordManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (RetailStoreMemberGiftCardConsumeRecord)
                  retailStoreMemberGiftCard.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
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

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
  }

  public RetailStoreMemberGiftCard updateRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(
        userContext,
        retailStoreMemberGiftCardId,
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

    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, loadTokens);

    synchronized (retailStoreMemberGiftCard) {
      // Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // retailStoreMemberGiftCard.removeRetailStoreMemberGiftCardConsumeRecord(
      // retailStoreMemberGiftCardConsumeRecord );
      // make changes to AcceleraterAccount.
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordIdVersionKey =
          createIndexedRetailStoreMemberGiftCardConsumeRecord(
              retailStoreMemberGiftCardConsumeRecordId,
              retailStoreMemberGiftCardConsumeRecordVersion);

      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
          retailStoreMemberGiftCard.findTheRetailStoreMemberGiftCardConsumeRecord(
              retailStoreMemberGiftCardConsumeRecordIdVersionKey);
      if (retailStoreMemberGiftCardConsumeRecord == null) {
        throw new RetailStoreMemberGiftCardManagerException(
            retailStoreMemberGiftCardConsumeRecordId + " is NOT FOUND");
      }

      beforeUpdateRetailStoreMemberGiftCardConsumeRecord(
          userContext,
          retailStoreMemberGiftCardConsumeRecord,
          retailStoreMemberGiftCardId,
          retailStoreMemberGiftCardConsumeRecordId,
          retailStoreMemberGiftCardConsumeRecordVersion,
          property,
          newValueExpr,
          tokensExpr);
      retailStoreMemberGiftCardConsumeRecord.changeProperty(property, newValueExpr);

      retailStoreMemberGiftCard =
          saveRetailStoreMemberGiftCard(
              userContext,
              retailStoreMemberGiftCard,
              tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
      retailStoreMemberGiftCardConsumeRecordManagerOf(userContext)
          .onUpdated(
              userContext,
              retailStoreMemberGiftCardConsumeRecord,
              this,
              "updateRetailStoreMemberGiftCardConsumeRecord");
      return present(userContext, retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCardConsumeRecord existed,
      String retailStoreMemberGiftCardId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, RetailStoreMemberGiftCard newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    retailStoreMemberGiftCardDaoOf(ctx)
        .loadAllAsStream()
        .forEach(event -> sendInitEvent(ctx, event));
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
    //   RetailStoreMemberGiftCard newRetailStoreMemberGiftCard =
    // this.createRetailStoreMemberGiftCard(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newRetailStoreMemberGiftCard
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreMemberGiftCard.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<RetailStoreMemberGiftCard> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<RetailStoreMember> ownerList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, RetailStoreMember.class);
    userContext.getDAOGroup().enhanceList(ownerList, RetailStoreMember.class);
  }

  public Object listByOwner(RetailscmUserContext userContext, String ownerId) throws Exception {
    return listPageByOwner(userContext, ownerId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByOwner(
      RetailscmUserContext userContext, String ownerId, int start, int count) throws Exception {
    SmartList<RetailStoreMemberGiftCard> list =
        retailStoreMemberGiftCardDaoOf(userContext)
            .findRetailStoreMemberGiftCardByOwner(ownerId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(RetailStoreMemberGiftCard.class);
    page.setContainerObject(RetailStoreMember.withId(ownerId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("零售店会员礼品卡列表");
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
  public Object wxappview(RetailscmUserContext userContext, String retailStoreMemberGiftCardId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    RetailStoreMemberGiftCard merchantObj =
        (RetailStoreMemberGiftCard) this.view(userContext, retailStoreMemberGiftCardId);
    String merchantObjId = retailStoreMemberGiftCardId;
    String linkToUrl = "retailStoreMemberGiftCardManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "零售店会员礼品卡" + "详情";
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
            .put("linkToUrl", "retailStoreMemberManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"mobile_phone\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("owner", merchantObj.getOwner());

    propList.add(
        MapUtil.put("id", "4-number")
            .put("fieldName", "number")
            .put("label", "数")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("number", merchantObj.getNumber());

    propList.add(
        MapUtil.put("id", "5-remain")
            .put("fieldName", "remain")
            .put("label", "保持")
            .put("type", "money")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("remain", merchantObj.getRemain());

    // 处理 sectionList

    // 处理Section：retailStoreMemberGiftCardConsumeRecordListSection
    Map retailStoreMemberGiftCardConsumeRecordListSection =
        ListofUtils.buildSection(
            "retailStoreMemberGiftCardConsumeRecordListSection",
            "零售会员礼品卡消费记录列表",
            null,
            "",
            "__no_group",
            "retailStoreMemberGiftCardConsumeRecordManager/listByOwner/" + merchantObjId + "/",
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
