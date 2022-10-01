package com.doublechaintech.retailscm.accountingdocumenttype;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.accountset.CandidateAccountSet;
import com.doublechaintech.retailscm.iamservice.*;
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

public class AccountingDocumentTypeManagerImpl extends CustomRetailscmCheckerManager
    implements AccountingDocumentTypeManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        AccountingDocumentTypeTokens.start().withTokenFromListName(listName).done();
    AccountingDocumentType accountingDocumentType =
        (AccountingDocumentType) this.loadAccountingDocumentType(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = accountingDocumentType.collectReferencesFromLists();
    accountingDocumentTypeDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, accountingDocumentType, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new AccountingDocumentTypeGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "AccountingDocumentType";

  @Override
  public AccountingDocumentTypeDAO daoOf(RetailscmUserContext userContext) {
    return accountingDocumentTypeDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws AccountingDocumentTypeManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new AccountingDocumentTypeManagerException(message);
  }

  protected AccountingDocumentType saveAccountingDocumentType(
      RetailscmUserContext userContext,
      AccountingDocumentType accountingDocumentType,
      String[] tokensExpr)
      throws Exception {
    // return getAccountingDocumentTypeDAO().save(accountingDocumentType, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveAccountingDocumentType(userContext, accountingDocumentType, tokens);
  }

  protected AccountingDocumentType saveAccountingDocumentTypeDetail(
      RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType)
      throws Exception {

    return saveAccountingDocumentType(userContext, accountingDocumentType, allTokens());
  }

  public AccountingDocumentType loadAccountingDocumentType(
      RetailscmUserContext userContext, String accountingDocumentTypeId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);

    checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, accountingDocumentType, tokens);
  }

  public AccountingDocumentType searchAccountingDocumentType(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);

    checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, accountingDocumentType, tokens);
  }

  protected AccountingDocumentType present(
      RetailscmUserContext userContext,
      AccountingDocumentType accountingDocumentType,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, accountingDocumentType, tokens);

    AccountingDocumentType accountingDocumentTypeToPresent =
        accountingDocumentTypeDaoOf(userContext).present(accountingDocumentType, tokens);

    List<BaseEntity> entityListToNaming =
        accountingDocumentTypeToPresent.collectReferencesFromLists();
    accountingDocumentTypeDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, accountingDocumentType, tokens);

    return accountingDocumentTypeToPresent;
  }

  public AccountingDocumentType loadAccountingDocumentTypeDetail(
      RetailscmUserContext userContext, String accountingDocumentTypeId) throws Exception {
    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
    return present(userContext, accountingDocumentType, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String accountingDocumentTypeId)
      throws Exception {
    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, viewTokens());
    markVisited(userContext, accountingDocumentType);
    return present(userContext, accountingDocumentType, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String accountingDocumentTypeId)
      throws Exception {
    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, viewTokens());
    accountingDocumentType.summarySuffix();
    markVisited(userContext, accountingDocumentType);
    return present(userContext, accountingDocumentType, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String accountingDocumentTypeId)
      throws Exception {
    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, analyzeTokens());
    markVisited(userContext, accountingDocumentType);
    return present(userContext, accountingDocumentType, analyzeTokens());
  }

  protected AccountingDocumentType saveAccountingDocumentType(
      RetailscmUserContext userContext,
      AccountingDocumentType accountingDocumentType,
      Map<String, Object> tokens)
      throws Exception {

    return accountingDocumentTypeDaoOf(userContext).save(accountingDocumentType, tokens);
  }

  protected AccountingDocumentType loadAccountingDocumentType(
      RetailscmUserContext userContext, String accountingDocumentTypeId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);

    checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);

    return accountingDocumentTypeDaoOf(userContext).load(accountingDocumentTypeId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      AccountingDocumentType accountingDocumentType,
      Map<String, Object> tokens) {
    super.addActions(userContext, accountingDocumentType, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, AccountingDocumentType accountingDocumentType, Map<String, Object> tokens){

  @Override
  public List<AccountingDocumentType> searchAccountingDocumentTypeList(
      RetailscmUserContext ctx, AccountingDocumentTypeRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<AccountingDocumentType> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public AccountingDocumentType searchAccountingDocumentType(
      RetailscmUserContext ctx, AccountingDocumentTypeRequest pRequest) {
    pRequest.limit(0, 1);
    List<AccountingDocumentType> list = searchAccountingDocumentTypeList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public AccountingDocumentType createAccountingDocumentType(
      RetailscmUserContext userContext, String name, String description, String accountingPeriodId)
      throws Exception {

    checkerOf(userContext).checkNameOfAccountingDocumentType(name);
    checkerOf(userContext).checkDescriptionOfAccountingDocumentType(description);

    checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);

    AccountingDocumentType accountingDocumentType = createNewAccountingDocumentType();

    accountingDocumentType.setName(name);
    accountingDocumentType.setDescription(description);

    AccountSet accountingPeriod = loadAccountSet(userContext, accountingPeriodId, emptyOptions());
    accountingDocumentType.setAccountingPeriod(accountingPeriod);

    accountingDocumentType =
        saveAccountingDocumentType(userContext, accountingDocumentType, emptyOptions());

    onNewInstanceCreated(userContext, accountingDocumentType);
    return accountingDocumentType;
  }

  protected AccountingDocumentType createNewAccountingDocumentType() {

    return new AccountingDocumentType();
  }

  protected void checkParamsForUpdatingAccountingDocumentType(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      int accountingDocumentTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
    checkerOf(userContext).checkVersionOfAccountingDocumentType(accountingDocumentTypeVersion);

    if (AccountingDocumentType.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfAccountingDocumentType(parseString(newValueExpr));
    }
    if (AccountingDocumentType.DESCRIPTION_PROPERTY.equals(property)) {

      checkerOf(userContext).checkDescriptionOfAccountingDocumentType(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
  }

  public AccountingDocumentType clone(
      RetailscmUserContext userContext, String fromAccountingDocumentTypeId) throws Exception {

    return accountingDocumentTypeDaoOf(userContext)
        .clone(fromAccountingDocumentTypeId, this.allTokens());
  }

  public AccountingDocumentType internalSaveAccountingDocumentType(
      RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType)
      throws Exception {
    return internalSaveAccountingDocumentType(userContext, accountingDocumentType, allTokens());
  }

  public AccountingDocumentType internalSaveAccountingDocumentType(
      RetailscmUserContext userContext,
      AccountingDocumentType accountingDocumentType,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingAccountingDocumentType(userContext, accountingDocumentTypeId,
    // accountingDocumentTypeVersion, property, newValueExpr, tokensExpr);

    synchronized (accountingDocumentType) {
      // will be good when the accountingDocumentType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to AccountingDocumentType.
      if (accountingDocumentType.isChanged()) {}

      // checkerOf(userContext).checkAndFixAccountingDocumentType(accountingDocumentType);
      accountingDocumentType =
          saveAccountingDocumentType(userContext, accountingDocumentType, options);
      return accountingDocumentType;
    }
  }

  public AccountingDocumentType updateAccountingDocumentType(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      int accountingDocumentTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingAccountingDocumentType(
        userContext,
        accountingDocumentTypeId,
        accountingDocumentTypeVersion,
        property,
        newValueExpr,
        tokensExpr);

    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
    if (accountingDocumentType.getVersion() != accountingDocumentTypeVersion) {
      String message =
          "The target version("
              + accountingDocumentType.getVersion()
              + ") is not equals to version("
              + accountingDocumentTypeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (accountingDocumentType) {
      // will be good when the accountingDocumentType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to AccountingDocumentType.

      accountingDocumentType.changeProperty(property, newValueExpr);
      accountingDocumentType =
          saveAccountingDocumentType(userContext, accountingDocumentType, tokens().done());
      return present(userContext, accountingDocumentType, mergedAllTokens(tokensExpr));
      // return saveAccountingDocumentType(userContext, accountingDocumentType, tokens().done());
    }
  }

  public AccountingDocumentType updateAccountingDocumentTypeProperty(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      int accountingDocumentTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingAccountingDocumentType(
        userContext,
        accountingDocumentTypeId,
        accountingDocumentTypeVersion,
        property,
        newValueExpr,
        tokensExpr);

    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
    if (accountingDocumentType.getVersion() != accountingDocumentTypeVersion) {
      String message =
          "The target version("
              + accountingDocumentType.getVersion()
              + ") is not equals to version("
              + accountingDocumentTypeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (accountingDocumentType) {
      // will be good when the accountingDocumentType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to AccountingDocumentType.

      accountingDocumentType.changeProperty(property, newValueExpr);

      accountingDocumentType =
          saveAccountingDocumentType(userContext, accountingDocumentType, tokens().done());
      return present(userContext, accountingDocumentType, mergedAllTokens(tokensExpr));
      // return saveAccountingDocumentType(userContext, accountingDocumentType, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected AccountingDocumentTypeTokens tokens() {
    return AccountingDocumentTypeTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return AccountingDocumentTypeTokens.all();
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
        .sortAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return AccountingDocumentTypeTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherAccountingPeriod(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String anotherAccountingPeriodId)
      throws Exception {

    checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
    checkerOf(userContext)
        .checkIdOfAccountSet(anotherAccountingPeriodId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
  }

  public AccountingDocumentType transferToAnotherAccountingPeriod(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String anotherAccountingPeriodId)
      throws Exception {
    checkParamsForTransferingAnotherAccountingPeriod(
        userContext, accountingDocumentTypeId, anotherAccountingPeriodId);

    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
    synchronized (accountingDocumentType) {
      // will be good when the accountingDocumentType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      AccountSet accountingPeriod =
          loadAccountSet(userContext, anotherAccountingPeriodId, emptyOptions());
      accountingDocumentType.updateAccountingPeriod(accountingPeriod);

      accountingDocumentType =
          saveAccountingDocumentType(userContext, accountingDocumentType, emptyOptions());

      return present(userContext, accountingDocumentType, allTokens());
    }
  }

  public CandidateAccountSet requestCandidateAccountingPeriod(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateAccountSet result = new CandidateAccountSet();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<AccountSet> candidateList =
        accountSetDaoOf(userContext)
            .requestCandidateAccountSetForAccountingDocumentType(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected AccountSet loadAccountSet(
      RetailscmUserContext userContext, String newAccountingPeriodId, Map<String, Object> options)
      throws Exception {

    return accountSetDaoOf(userContext).load(newAccountingPeriodId, options);
  }

  // --------------------------------------------------------------

  public AccountingDocumentType forgetByAll(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      int accountingDocumentTypeVersion)
      throws Exception {
    return forgetByAllInternal(
        userContext, accountingDocumentTypeId, accountingDocumentTypeVersion);
  }

  protected AccountingDocumentType forgetByAllInternal(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      int accountingDocumentTypeVersion)
      throws Exception {

    return accountingDocumentTypeDaoOf(userContext)
        .disconnectFromAll(accountingDocumentTypeId, accountingDocumentTypeVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new AccountingDocumentTypeManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingAccountingDocument(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String name,
      Date accountingDocumentDate,
      String accountingPeriodId,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);

    checkerOf(userContext).checkNameOfAccountingDocument(name);

    checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);

    checkerOf(userContext).checkAccountingPeriodIdOfAccountingDocument(accountingPeriodId);

    checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
  }

  public AccountingDocumentType addAccountingDocument(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String name,
      Date accountingDocumentDate,
      String accountingPeriodId,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingAccountingDocument(
        userContext,
        accountingDocumentTypeId,
        name,
        accountingDocumentDate,
        accountingPeriodId,
        tokensExpr);

    AccountingDocument accountingDocument =
        createAccountingDocument(userContext, name, accountingDocumentDate, accountingPeriodId);

    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, emptyOptions());
    synchronized (accountingDocumentType) {
      // Will be good when the accountingDocumentType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      accountingDocumentType.addAccountingDocument(accountingDocument);
      accountingDocumentType =
          saveAccountingDocumentType(
              userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());

      accountingDocumentManagerOf(userContext)
          .onNewInstanceCreated(userContext, accountingDocument);
      return present(userContext, accountingDocumentType, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingAccountingDocumentProperties(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String id,
      String name,
      Date accountingDocumentDate,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
    checkerOf(userContext).checkIdOfAccountingDocument(id);

    checkerOf(userContext).checkNameOfAccountingDocument(name);
    checkerOf(userContext).checkAccountingDocumentDateOfAccountingDocument(accountingDocumentDate);

    checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
  }

  public AccountingDocumentType updateAccountingDocumentProperties(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String id,
      String name,
      Date accountingDocumentDate,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingAccountingDocumentProperties(
        userContext, accountingDocumentTypeId, id, name, accountingDocumentDate, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withAccountingDocumentListList()
            .searchAccountingDocumentListWith(AccountingDocument.ID_PROPERTY, tokens().is(), id)
            .done();

    AccountingDocumentType accountingDocumentTypeToUpdate =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, options);

    if (accountingDocumentTypeToUpdate.getAccountingDocumentList().isEmpty()) {
      throw new AccountingDocumentTypeManagerException(
          "AccountingDocument is NOT FOUND with id: '" + id + "'");
    }

    AccountingDocument item = accountingDocumentTypeToUpdate.getAccountingDocumentList().first();
    beforeUpdateAccountingDocumentProperties(
        userContext, item, accountingDocumentTypeId, id, name, accountingDocumentDate, tokensExpr);
    item.updateName(name);
    item.updateAccountingDocumentDate(accountingDocumentDate);

    // checkParamsForAddingAccountingDocument(userContext,accountingDocumentTypeId,name, code,
    // used,tokensExpr);
    AccountingDocumentType accountingDocumentType =
        saveAccountingDocumentType(
            userContext,
            accountingDocumentTypeToUpdate,
            tokens().withAccountingDocumentList().done());
    synchronized (accountingDocumentType) {
      return present(userContext, accountingDocumentType, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateAccountingDocumentProperties(
      RetailscmUserContext userContext,
      AccountingDocument item,
      String accountingDocumentTypeId,
      String id,
      String name,
      Date accountingDocumentDate,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected AccountingDocument createAccountingDocument(
      RetailscmUserContext userContext,
      String name,
      Date accountingDocumentDate,
      String accountingPeriodId)
      throws Exception {

    AccountingDocument accountingDocument = new AccountingDocument();

    accountingDocument.setName(name);
    accountingDocument.setAccountingDocumentDate(accountingDocumentDate);
    AccountingPeriod accountingPeriod = new AccountingPeriod();
    accountingPeriod.setId(accountingPeriodId);
    accountingDocument.setAccountingPeriod(accountingPeriod);

    return accountingDocument;
  }

  protected AccountingDocument createIndexedAccountingDocument(String id, int version) {

    AccountingDocument accountingDocument = new AccountingDocument();
    accountingDocument.setId(id);
    accountingDocument.setVersion(version);
    return accountingDocument;
  }

  protected void checkParamsForRemovingAccountingDocumentList(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String accountingDocumentIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
    for (String accountingDocumentIdItem : accountingDocumentIds) {
      checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
  }

  public AccountingDocumentType removeAccountingDocumentList(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String accountingDocumentIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingAccountingDocumentList(
        userContext, accountingDocumentTypeId, accountingDocumentIds, tokensExpr);

    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
    synchronized (accountingDocumentType) {
      // Will be good when the accountingDocumentType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      accountingDocumentTypeDaoOf(userContext)
          .planToRemoveAccountingDocumentList(
              accountingDocumentType, accountingDocumentIds, allTokens());
      accountingDocumentType =
          saveAccountingDocumentType(
              userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
      deleteRelationListInGraph(userContext, accountingDocumentType.getAccountingDocumentList());
      return present(userContext, accountingDocumentType, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingAccountingDocument(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String accountingDocumentId,
      int accountingDocumentVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
    checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
    checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
  }

  public AccountingDocumentType removeAccountingDocument(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String accountingDocumentId,
      int accountingDocumentVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingAccountingDocument(
        userContext,
        accountingDocumentTypeId,
        accountingDocumentId,
        accountingDocumentVersion,
        tokensExpr);

    AccountingDocument accountingDocument =
        createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
    synchronized (accountingDocumentType) {
      // Will be good when the accountingDocumentType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      accountingDocumentType.removeAccountingDocument(accountingDocument);
      accountingDocumentType =
          saveAccountingDocumentType(
              userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
      deleteRelationInGraph(userContext, accountingDocument);
      return present(userContext, accountingDocumentType, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingAccountingDocument(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String accountingDocumentId,
      int accountingDocumentVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
    checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
    checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
  }

  public AccountingDocumentType copyAccountingDocumentFrom(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String accountingDocumentId,
      int accountingDocumentVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingAccountingDocument(
        userContext,
        accountingDocumentTypeId,
        accountingDocumentId,
        accountingDocumentVersion,
        tokensExpr);

    AccountingDocument accountingDocument =
        createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);
    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, allTokens());
    synchronized (accountingDocumentType) {
      // Will be good when the accountingDocumentType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      accountingDocumentType.copyAccountingDocumentFrom(accountingDocument);
      accountingDocumentType =
          saveAccountingDocumentType(
              userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());

      accountingDocumentManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (AccountingDocument)
                  accountingDocumentType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, accountingDocumentType, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingAccountingDocument(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String accountingDocumentId,
      int accountingDocumentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfAccountingDocumentType(accountingDocumentTypeId);
    checkerOf(userContext).checkIdOfAccountingDocument(accountingDocumentId);
    checkerOf(userContext).checkVersionOfAccountingDocument(accountingDocumentVersion);

    if (AccountingDocument.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfAccountingDocument(parseString(newValueExpr));
    }

    if (AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)) {
      checkerOf(userContext)
          .checkAccountingDocumentDateOfAccountingDocument(parseDate(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentTypeManagerException.class);
  }

  public AccountingDocumentType updateAccountingDocument(
      RetailscmUserContext userContext,
      String accountingDocumentTypeId,
      String accountingDocumentId,
      int accountingDocumentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingAccountingDocument(
        userContext,
        accountingDocumentTypeId,
        accountingDocumentId,
        accountingDocumentVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withAccountingDocumentList()
            .searchAccountingDocumentListWith(
                AccountingDocument.ID_PROPERTY, tokens().equals(), accountingDocumentId)
            .done();

    AccountingDocumentType accountingDocumentType =
        loadAccountingDocumentType(userContext, accountingDocumentTypeId, loadTokens);

    synchronized (accountingDocumentType) {
      // Will be good when the accountingDocumentType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // accountingDocumentType.removeAccountingDocument( accountingDocument );
      // make changes to AcceleraterAccount.
      AccountingDocument accountingDocumentIdVersionKey =
          createIndexedAccountingDocument(accountingDocumentId, accountingDocumentVersion);

      AccountingDocument accountingDocument =
          accountingDocumentType.findTheAccountingDocument(accountingDocumentIdVersionKey);
      if (accountingDocument == null) {
        throw new AccountingDocumentTypeManagerException(accountingDocumentId + " is NOT FOUND");
      }

      beforeUpdateAccountingDocument(
          userContext,
          accountingDocument,
          accountingDocumentTypeId,
          accountingDocumentId,
          accountingDocumentVersion,
          property,
          newValueExpr,
          tokensExpr);
      accountingDocument.changeProperty(property, newValueExpr);

      accountingDocumentType =
          saveAccountingDocumentType(
              userContext, accountingDocumentType, tokens().withAccountingDocumentList().done());
      accountingDocumentManagerOf(userContext)
          .onUpdated(userContext, accountingDocument, this, "updateAccountingDocument");
      return present(userContext, accountingDocumentType, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateAccountingDocument(
      RetailscmUserContext userContext,
      AccountingDocument existed,
      String accountingDocumentTypeId,
      String accountingDocumentId,
      int accountingDocumentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, AccountingDocumentType newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    accountingDocumentTypeDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   AccountingDocumentType newAccountingDocumentType =
    // this.createAccountingDocumentType(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newAccountingDocumentType
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
    key.put(UserApp.APP_TYPE_PROPERTY, AccountingDocumentType.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<AccountingDocumentType> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<AccountSet> accountingPeriodList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, AccountSet.class);
    userContext.getDAOGroup().enhanceList(accountingPeriodList, AccountSet.class);
  }

  public Object listByAccountingPeriod(RetailscmUserContext userContext, String accountingPeriodId)
      throws Exception {
    return listPageByAccountingPeriod(userContext, accountingPeriodId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByAccountingPeriod(
      RetailscmUserContext userContext, String accountingPeriodId, int start, int count)
      throws Exception {
    SmartList<AccountingDocumentType> list =
        accountingDocumentTypeDaoOf(userContext)
            .findAccountingDocumentTypeByAccountingPeriod(
                accountingPeriodId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(AccountingDocumentType.class);
    page.setContainerObject(AccountSet.withId(accountingPeriodId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("会计凭证类型列表");
    page.setRequestName("listByAccountingPeriod");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(
            String.format("%s/listByAccountingPeriod/%s/", getBeanName(), accountingPeriodId)));

    page.assemblerContent(userContext, "listByAccountingPeriod");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String accountingDocumentTypeId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    AccountingDocumentType merchantObj =
        (AccountingDocumentType) this.view(userContext, accountingDocumentTypeId);
    String merchantObjId = accountingDocumentTypeId;
    String linkToUrl = "accountingDocumentTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会计凭证类型" + "详情";
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
        MapUtil.put("id", "3-description")
            .put("fieldName", "description")
            .put("label", "描述")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("description", merchantObj.getDescription());

    propList.add(
        MapUtil.put("id", "4-accountingPeriod")
            .put("fieldName", "accountingPeriod")
            .put("label", "会计期间")
            .put("type", "auto")
            .put("linkToUrl", "accountSetManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"year_set\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("accountingPeriod", merchantObj.getAccountingPeriod());

    // 处理 sectionList

    // 处理Section：accountingDocumentListSection
    Map accountingDocumentListSection =
        ListofUtils.buildSection(
            "accountingDocumentListSection",
            "会计文档列表",
            null,
            "",
            "__no_group",
            "accountingDocumentManager/listByDocumentType/" + merchantObjId + "/",
            "auto");
    sections.add(accountingDocumentListSection);

    result.put(
        "accountingDocumentListSection",
        ListofUtils.toShortList(merchantObj.getAccountingDocumentList(), "accountingDocument"));

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
