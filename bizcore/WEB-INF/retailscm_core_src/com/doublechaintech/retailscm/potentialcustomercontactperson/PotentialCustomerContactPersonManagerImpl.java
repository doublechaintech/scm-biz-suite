package com.doublechaintech.retailscm.potentialcustomercontactperson;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.potentialcustomer.CandidatePotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
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

public class PotentialCustomerContactPersonManagerImpl extends CustomRetailscmCheckerManager
    implements PotentialCustomerContactPersonManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        PotentialCustomerContactPersonTokens.start().withTokenFromListName(listName).done();
    PotentialCustomerContactPerson potentialCustomerContactPerson =
        (PotentialCustomerContactPerson)
            this.loadPotentialCustomerContactPerson(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming =
        potentialCustomerContactPerson.collectReferencesFromLists();
    potentialCustomerContactPersonDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, potentialCustomerContactPerson, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new PotentialCustomerContactPersonGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "PotentialCustomerContactPerson";

  @Override
  public PotentialCustomerContactPersonDAO daoOf(RetailscmUserContext userContext) {
    return potentialCustomerContactPersonDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws PotentialCustomerContactPersonManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new PotentialCustomerContactPersonManagerException(message);
  }

  protected PotentialCustomerContactPerson savePotentialCustomerContactPerson(
      RetailscmUserContext userContext,
      PotentialCustomerContactPerson potentialCustomerContactPerson,
      String[] tokensExpr)
      throws Exception {
    // return getPotentialCustomerContactPersonDAO().save(potentialCustomerContactPerson, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens);
  }

  protected PotentialCustomerContactPerson savePotentialCustomerContactPersonDetail(
      RetailscmUserContext userContext,
      PotentialCustomerContactPerson potentialCustomerContactPerson)
      throws Exception {

    return savePotentialCustomerContactPerson(
        userContext, potentialCustomerContactPerson, allTokens());
  }

  public PotentialCustomerContactPerson loadPotentialCustomerContactPerson(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, tokens);
    // do some calc before sent to customer?
    return present(userContext, potentialCustomerContactPerson, tokens);
  }

  public PotentialCustomerContactPerson searchPotentialCustomerContactPerson(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, tokens);
    // do some calc before sent to customer?
    return present(userContext, potentialCustomerContactPerson, tokens);
  }

  protected PotentialCustomerContactPerson present(
      RetailscmUserContext userContext,
      PotentialCustomerContactPerson potentialCustomerContactPerson,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, potentialCustomerContactPerson, tokens);

    PotentialCustomerContactPerson potentialCustomerContactPersonToPresent =
        potentialCustomerContactPersonDaoOf(userContext)
            .present(potentialCustomerContactPerson, tokens);

    List<BaseEntity> entityListToNaming =
        potentialCustomerContactPersonToPresent.collectReferencesFromLists();
    potentialCustomerContactPersonDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, potentialCustomerContactPerson, tokens);

    return potentialCustomerContactPersonToPresent;
  }

  public PotentialCustomerContactPerson loadPotentialCustomerContactPersonDetail(
      RetailscmUserContext userContext, String potentialCustomerContactPersonId) throws Exception {
    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(
            userContext, potentialCustomerContactPersonId, allTokens());
    return present(userContext, potentialCustomerContactPerson, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String potentialCustomerContactPersonId)
      throws Exception {
    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(
            userContext, potentialCustomerContactPersonId, viewTokens());
    markVisited(userContext, potentialCustomerContactPerson);
    return present(userContext, potentialCustomerContactPerson, viewTokens());
  }

  public Object summaryView(
      RetailscmUserContext userContext, String potentialCustomerContactPersonId) throws Exception {
    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(
            userContext, potentialCustomerContactPersonId, viewTokens());
    potentialCustomerContactPerson.summarySuffix();
    markVisited(userContext, potentialCustomerContactPerson);
    return present(userContext, potentialCustomerContactPerson, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String potentialCustomerContactPersonId)
      throws Exception {
    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(
            userContext, potentialCustomerContactPersonId, analyzeTokens());
    markVisited(userContext, potentialCustomerContactPerson);
    return present(userContext, potentialCustomerContactPerson, analyzeTokens());
  }

  protected PotentialCustomerContactPerson savePotentialCustomerContactPerson(
      RetailscmUserContext userContext,
      PotentialCustomerContactPerson potentialCustomerContactPerson,
      Map<String, Object> tokens)
      throws Exception {

    return potentialCustomerContactPersonDaoOf(userContext)
        .save(potentialCustomerContactPerson, tokens);
  }

  protected PotentialCustomerContactPerson loadPotentialCustomerContactPerson(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext)
        .checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);

    return potentialCustomerContactPersonDaoOf(userContext)
        .load(potentialCustomerContactPersonId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      PotentialCustomerContactPerson potentialCustomerContactPerson,
      Map<String, Object> tokens) {
    super.addActions(userContext, potentialCustomerContactPerson, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,
    // Object> tokens){

  @Override
  public List<PotentialCustomerContactPerson> searchPotentialCustomerContactPersonList(
      RetailscmUserContext ctx, PotentialCustomerContactPersonRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<PotentialCustomerContactPerson> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public PotentialCustomerContactPerson searchPotentialCustomerContactPerson(
      RetailscmUserContext ctx, PotentialCustomerContactPersonRequest pRequest) {
    pRequest.limit(0, 1);
    List<PotentialCustomerContactPerson> list =
        searchPotentialCustomerContactPersonList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public PotentialCustomerContactPerson createPotentialCustomerContactPerson(
      RetailscmUserContext userContext,
      String name,
      String mobile,
      String potentialCustomerId,
      String description)
      throws Exception {

    checkerOf(userContext).checkNameOfPotentialCustomerContactPerson(name);
    checkerOf(userContext).checkMobileOfPotentialCustomerContactPerson(mobile);
    checkerOf(userContext).checkDescriptionOfPotentialCustomerContactPerson(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);

    PotentialCustomerContactPerson potentialCustomerContactPerson =
        createNewPotentialCustomerContactPerson();

    potentialCustomerContactPerson.setName(name);
    potentialCustomerContactPerson.setMobile(mobile);

    PotentialCustomer potentialCustomer =
        loadPotentialCustomer(userContext, potentialCustomerId, emptyOptions());
    potentialCustomerContactPerson.setPotentialCustomer(potentialCustomer);

    potentialCustomerContactPerson.setDescription(description);

    potentialCustomerContactPerson =
        savePotentialCustomerContactPerson(
            userContext, potentialCustomerContactPerson, emptyOptions());

    onNewInstanceCreated(userContext, potentialCustomerContactPerson);
    return potentialCustomerContactPerson;
  }

  protected PotentialCustomerContactPerson createNewPotentialCustomerContactPerson() {

    return new PotentialCustomerContactPerson();
  }

  protected void checkParamsForUpdatingPotentialCustomerContactPerson(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      int potentialCustomerContactPersonVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
    checkerOf(userContext)
        .checkVersionOfPotentialCustomerContactPerson(potentialCustomerContactPersonVersion);

    if (PotentialCustomerContactPerson.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfPotentialCustomerContactPerson(parseString(newValueExpr));
    }
    if (PotentialCustomerContactPerson.MOBILE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkMobileOfPotentialCustomerContactPerson(parseString(newValueExpr));
    }

    if (PotentialCustomerContactPerson.DESCRIPTION_PROPERTY.equals(property)) {

      checkerOf(userContext)
          .checkDescriptionOfPotentialCustomerContactPerson(parseString(newValueExpr));
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
  }

  public PotentialCustomerContactPerson clone(
      RetailscmUserContext userContext, String fromPotentialCustomerContactPersonId)
      throws Exception {

    return potentialCustomerContactPersonDaoOf(userContext)
        .clone(fromPotentialCustomerContactPersonId, this.allTokens());
  }

  public PotentialCustomerContactPerson internalSavePotentialCustomerContactPerson(
      RetailscmUserContext userContext,
      PotentialCustomerContactPerson potentialCustomerContactPerson)
      throws Exception {
    return internalSavePotentialCustomerContactPerson(
        userContext, potentialCustomerContactPerson, allTokens());
  }

  public PotentialCustomerContactPerson internalSavePotentialCustomerContactPerson(
      RetailscmUserContext userContext,
      PotentialCustomerContactPerson potentialCustomerContactPerson,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingPotentialCustomerContactPerson(userContext,
    // potentialCustomerContactPersonId, potentialCustomerContactPersonVersion, property,
    // newValueExpr, tokensExpr);

    synchronized (potentialCustomerContactPerson) {
      // will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PotentialCustomerContactPerson.
      if (potentialCustomerContactPerson.isChanged()) {}

      // checkerOf(userContext).checkAndFixPotentialCustomerContactPerson(potentialCustomerContactPerson);
      potentialCustomerContactPerson =
          savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, options);
      return potentialCustomerContactPerson;
    }
  }

  public PotentialCustomerContactPerson updatePotentialCustomerContactPerson(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      int potentialCustomerContactPersonVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPotentialCustomerContactPerson(
        userContext,
        potentialCustomerContactPersonId,
        potentialCustomerContactPersonVersion,
        property,
        newValueExpr,
        tokensExpr);

    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(
            userContext, potentialCustomerContactPersonId, allTokens());
    if (potentialCustomerContactPerson.getVersion() != potentialCustomerContactPersonVersion) {
      String message =
          "The target version("
              + potentialCustomerContactPerson.getVersion()
              + ") is not equals to version("
              + potentialCustomerContactPersonVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (potentialCustomerContactPerson) {
      // will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PotentialCustomerContactPerson.

      potentialCustomerContactPerson.changeProperty(property, newValueExpr);
      potentialCustomerContactPerson =
          savePotentialCustomerContactPerson(
              userContext, potentialCustomerContactPerson, tokens().done());
      return present(userContext, potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
      // return savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson,
      // tokens().done());
    }
  }

  public PotentialCustomerContactPerson updatePotentialCustomerContactPersonProperty(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      int potentialCustomerContactPersonVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPotentialCustomerContactPerson(
        userContext,
        potentialCustomerContactPersonId,
        potentialCustomerContactPersonVersion,
        property,
        newValueExpr,
        tokensExpr);

    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(
            userContext, potentialCustomerContactPersonId, allTokens());
    if (potentialCustomerContactPerson.getVersion() != potentialCustomerContactPersonVersion) {
      String message =
          "The target version("
              + potentialCustomerContactPerson.getVersion()
              + ") is not equals to version("
              + potentialCustomerContactPersonVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (potentialCustomerContactPerson) {
      // will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PotentialCustomerContactPerson.

      potentialCustomerContactPerson.changeProperty(property, newValueExpr);

      potentialCustomerContactPerson =
          savePotentialCustomerContactPerson(
              userContext, potentialCustomerContactPerson, tokens().done());
      return present(userContext, potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
      // return savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson,
      // tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected PotentialCustomerContactPersonTokens tokens() {
    return PotentialCustomerContactPersonTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return PotentialCustomerContactPersonTokens.all();
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
        .sortPotentialCustomerContactListWith(PotentialCustomerContact.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return PotentialCustomerContactPersonTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherPotentialCustomer(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String anotherPotentialCustomerId)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
    checkerOf(userContext)
        .checkIdOfPotentialCustomer(anotherPotentialCustomerId); // check for optional reference

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
  }

  public PotentialCustomerContactPerson transferToAnotherPotentialCustomer(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String anotherPotentialCustomerId)
      throws Exception {
    checkParamsForTransferingAnotherPotentialCustomer(
        userContext, potentialCustomerContactPersonId, anotherPotentialCustomerId);

    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(
            userContext, potentialCustomerContactPersonId, allTokens());
    synchronized (potentialCustomerContactPerson) {
      // will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      PotentialCustomer potentialCustomer =
          loadPotentialCustomer(userContext, anotherPotentialCustomerId, emptyOptions());
      potentialCustomerContactPerson.updatePotentialCustomer(potentialCustomer);

      potentialCustomerContactPerson =
          savePotentialCustomerContactPerson(
              userContext, potentialCustomerContactPerson, emptyOptions());

      return present(userContext, potentialCustomerContactPerson, allTokens());
    }
  }

  public CandidatePotentialCustomer requestCandidatePotentialCustomer(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidatePotentialCustomer result = new CandidatePotentialCustomer();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<PotentialCustomer> candidateList =
        potentialCustomerDaoOf(userContext)
            .requestCandidatePotentialCustomerForPotentialCustomerContactPerson(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected PotentialCustomer loadPotentialCustomer(
      RetailscmUserContext userContext, String newPotentialCustomerId, Map<String, Object> options)
      throws Exception {

    return potentialCustomerDaoOf(userContext).load(newPotentialCustomerId, options);
  }

  // --------------------------------------------------------------

  public PotentialCustomerContactPerson forgetByAll(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      int potentialCustomerContactPersonVersion)
      throws Exception {
    return forgetByAllInternal(
        userContext, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);
  }

  protected PotentialCustomerContactPerson forgetByAllInternal(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      int potentialCustomerContactPersonVersion)
      throws Exception {

    return potentialCustomerContactPersonDaoOf(userContext)
        .disconnectFromAll(potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new PotentialCustomerContactPersonManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingPotentialCustomerContact(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String name,
      Date contactDate,
      String contactMethod,
      String potentialCustomerId,
      String cityPartnerId,
      String description,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);

    checkerOf(userContext).checkNameOfPotentialCustomerContact(name);

    checkerOf(userContext).checkContactDateOfPotentialCustomerContact(contactDate);

    checkerOf(userContext).checkContactMethodOfPotentialCustomerContact(contactMethod);

    checkerOf(userContext).checkPotentialCustomerIdOfPotentialCustomerContact(potentialCustomerId);

    checkerOf(userContext).checkCityPartnerIdOfPotentialCustomerContact(cityPartnerId);

    checkerOf(userContext).checkDescriptionOfPotentialCustomerContact(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
  }

  public PotentialCustomerContactPerson addPotentialCustomerContact(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String name,
      Date contactDate,
      String contactMethod,
      String potentialCustomerId,
      String cityPartnerId,
      String description,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingPotentialCustomerContact(
        userContext,
        potentialCustomerContactPersonId,
        name,
        contactDate,
        contactMethod,
        potentialCustomerId,
        cityPartnerId,
        description,
        tokensExpr);

    PotentialCustomerContact potentialCustomerContact =
        createPotentialCustomerContact(
            userContext,
            name,
            contactDate,
            contactMethod,
            potentialCustomerId,
            cityPartnerId,
            description);

    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(
            userContext, potentialCustomerContactPersonId, emptyOptions());
    synchronized (potentialCustomerContactPerson) {
      // Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      potentialCustomerContactPerson.addPotentialCustomerContact(potentialCustomerContact);
      potentialCustomerContactPerson =
          savePotentialCustomerContactPerson(
              userContext,
              potentialCustomerContactPerson,
              tokens().withPotentialCustomerContactList().done());

      potentialCustomerContactManagerOf(userContext)
          .onNewInstanceCreated(userContext, potentialCustomerContact);
      return present(userContext, potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingPotentialCustomerContactProperties(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String id,
      String name,
      Date contactDate,
      String contactMethod,
      String description,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
    checkerOf(userContext).checkIdOfPotentialCustomerContact(id);

    checkerOf(userContext).checkNameOfPotentialCustomerContact(name);
    checkerOf(userContext).checkContactDateOfPotentialCustomerContact(contactDate);
    checkerOf(userContext).checkContactMethodOfPotentialCustomerContact(contactMethod);
    checkerOf(userContext).checkDescriptionOfPotentialCustomerContact(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
  }

  public PotentialCustomerContactPerson updatePotentialCustomerContactProperties(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String id,
      String name,
      Date contactDate,
      String contactMethod,
      String description,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPotentialCustomerContactProperties(
        userContext,
        potentialCustomerContactPersonId,
        id,
        name,
        contactDate,
        contactMethod,
        description,
        tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withPotentialCustomerContactListList()
            .searchPotentialCustomerContactListWith(
                PotentialCustomerContact.ID_PROPERTY, tokens().is(), id)
            .done();

    PotentialCustomerContactPerson potentialCustomerContactPersonToUpdate =
        loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, options);

    if (potentialCustomerContactPersonToUpdate.getPotentialCustomerContactList().isEmpty()) {
      throw new PotentialCustomerContactPersonManagerException(
          "PotentialCustomerContact is NOT FOUND with id: '" + id + "'");
    }

    PotentialCustomerContact item =
        potentialCustomerContactPersonToUpdate.getPotentialCustomerContactList().first();
    beforeUpdatePotentialCustomerContactProperties(
        userContext,
        item,
        potentialCustomerContactPersonId,
        id,
        name,
        contactDate,
        contactMethod,
        description,
        tokensExpr);
    item.updateName(name);
    item.updateContactDate(contactDate);
    item.updateContactMethod(contactMethod);
    item.updateDescription(description);

    // checkParamsForAddingPotentialCustomerContact(userContext,potentialCustomerContactPersonId,name, code, used,tokensExpr);
    PotentialCustomerContactPerson potentialCustomerContactPerson =
        savePotentialCustomerContactPerson(
            userContext,
            potentialCustomerContactPersonToUpdate,
            tokens().withPotentialCustomerContactList().done());
    synchronized (potentialCustomerContactPerson) {
      return present(userContext, potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdatePotentialCustomerContactProperties(
      RetailscmUserContext userContext,
      PotentialCustomerContact item,
      String potentialCustomerContactPersonId,
      String id,
      String name,
      Date contactDate,
      String contactMethod,
      String description,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected PotentialCustomerContact createPotentialCustomerContact(
      RetailscmUserContext userContext,
      String name,
      Date contactDate,
      String contactMethod,
      String potentialCustomerId,
      String cityPartnerId,
      String description)
      throws Exception {

    PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();

    potentialCustomerContact.setName(name);
    potentialCustomerContact.setContactDate(contactDate);
    potentialCustomerContact.setContactMethod(contactMethod);
    PotentialCustomer potentialCustomer = new PotentialCustomer();
    potentialCustomer.setId(potentialCustomerId);
    potentialCustomerContact.setPotentialCustomer(potentialCustomer);
    CityPartner cityPartner = new CityPartner();
    cityPartner.setId(cityPartnerId);
    potentialCustomerContact.setCityPartner(cityPartner);
    potentialCustomerContact.setDescription(description);
    potentialCustomerContact.setLastUpdateTime(userContext.now());

    return potentialCustomerContact;
  }

  protected PotentialCustomerContact createIndexedPotentialCustomerContact(String id, int version) {

    PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();
    potentialCustomerContact.setId(id);
    potentialCustomerContact.setVersion(version);
    return potentialCustomerContact;
  }

  protected void checkParamsForRemovingPotentialCustomerContactList(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String potentialCustomerContactIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
    for (String potentialCustomerContactIdItem : potentialCustomerContactIds) {
      checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactIdItem);
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
  }

  public PotentialCustomerContactPerson removePotentialCustomerContactList(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String potentialCustomerContactIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingPotentialCustomerContactList(
        userContext, potentialCustomerContactPersonId, potentialCustomerContactIds, tokensExpr);

    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(
            userContext, potentialCustomerContactPersonId, allTokens());
    synchronized (potentialCustomerContactPerson) {
      // Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      potentialCustomerContactPersonDaoOf(userContext)
          .planToRemovePotentialCustomerContactList(
              potentialCustomerContactPerson, potentialCustomerContactIds, allTokens());
      potentialCustomerContactPerson =
          savePotentialCustomerContactPerson(
              userContext,
              potentialCustomerContactPerson,
              tokens().withPotentialCustomerContactList().done());
      deleteRelationListInGraph(
          userContext, potentialCustomerContactPerson.getPotentialCustomerContactList());
      return present(userContext, potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingPotentialCustomerContact(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
    checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
    checkerOf(userContext).checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
  }

  public PotentialCustomerContactPerson removePotentialCustomerContact(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingPotentialCustomerContact(
        userContext,
        potentialCustomerContactPersonId,
        potentialCustomerContactId,
        potentialCustomerContactVersion,
        tokensExpr);

    PotentialCustomerContact potentialCustomerContact =
        createIndexedPotentialCustomerContact(
            potentialCustomerContactId, potentialCustomerContactVersion);
    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(
            userContext, potentialCustomerContactPersonId, allTokens());
    synchronized (potentialCustomerContactPerson) {
      // Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      potentialCustomerContactPerson.removePotentialCustomerContact(potentialCustomerContact);
      potentialCustomerContactPerson =
          savePotentialCustomerContactPerson(
              userContext,
              potentialCustomerContactPerson,
              tokens().withPotentialCustomerContactList().done());
      deleteRelationInGraph(userContext, potentialCustomerContact);
      return present(userContext, potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingPotentialCustomerContact(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
    checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
    checkerOf(userContext).checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
  }

  public PotentialCustomerContactPerson copyPotentialCustomerContactFrom(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingPotentialCustomerContact(
        userContext,
        potentialCustomerContactPersonId,
        potentialCustomerContactId,
        potentialCustomerContactVersion,
        tokensExpr);

    PotentialCustomerContact potentialCustomerContact =
        createIndexedPotentialCustomerContact(
            potentialCustomerContactId, potentialCustomerContactVersion);
    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(
            userContext, potentialCustomerContactPersonId, allTokens());
    synchronized (potentialCustomerContactPerson) {
      // Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      potentialCustomerContact.updateLastUpdateTime(userContext.now());

      potentialCustomerContactPerson.copyPotentialCustomerContactFrom(potentialCustomerContact);
      potentialCustomerContactPerson =
          savePotentialCustomerContactPerson(
              userContext,
              potentialCustomerContactPerson,
              tokens().withPotentialCustomerContactList().done());

      potentialCustomerContactManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (PotentialCustomerContact)
                  potentialCustomerContactPerson
                      .getFlexiableObjects()
                      .get(BaseEntity.COPIED_CHILD));
      return present(userContext, potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingPotentialCustomerContact(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
    checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
    checkerOf(userContext).checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);

    if (PotentialCustomerContact.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfPotentialCustomerContact(parseString(newValueExpr));
    }

    if (PotentialCustomerContact.CONTACT_DATE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkContactDateOfPotentialCustomerContact(parseDate(newValueExpr));
    }

    if (PotentialCustomerContact.CONTACT_METHOD_PROPERTY.equals(property)) {
      checkerOf(userContext)
          .checkContactMethodOfPotentialCustomerContact(parseString(newValueExpr));
    }

    if (PotentialCustomerContact.DESCRIPTION_PROPERTY.equals(property)) {
      checkerOf(userContext).checkDescriptionOfPotentialCustomerContact(parseString(newValueExpr));
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
  }

  public PotentialCustomerContactPerson updatePotentialCustomerContact(
      RetailscmUserContext userContext,
      String potentialCustomerContactPersonId,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingPotentialCustomerContact(
        userContext,
        potentialCustomerContactPersonId,
        potentialCustomerContactId,
        potentialCustomerContactVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withPotentialCustomerContactList()
            .searchPotentialCustomerContactListWith(
                PotentialCustomerContact.ID_PROPERTY, tokens().equals(), potentialCustomerContactId)
            .done();

    PotentialCustomerContactPerson potentialCustomerContactPerson =
        loadPotentialCustomerContactPerson(
            userContext, potentialCustomerContactPersonId, loadTokens);

    synchronized (potentialCustomerContactPerson) {
      // Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // potentialCustomerContactPerson.removePotentialCustomerContact( potentialCustomerContact );
      // make changes to AcceleraterAccount.
      PotentialCustomerContact potentialCustomerContactIdVersionKey =
          createIndexedPotentialCustomerContact(
              potentialCustomerContactId, potentialCustomerContactVersion);

      PotentialCustomerContact potentialCustomerContact =
          potentialCustomerContactPerson.findThePotentialCustomerContact(
              potentialCustomerContactIdVersionKey);
      if (potentialCustomerContact == null) {
        throw new PotentialCustomerContactPersonManagerException(
            potentialCustomerContactId + " is NOT FOUND");
      }

      beforeUpdatePotentialCustomerContact(
          userContext,
          potentialCustomerContact,
          potentialCustomerContactPersonId,
          potentialCustomerContactId,
          potentialCustomerContactVersion,
          property,
          newValueExpr,
          tokensExpr);
      potentialCustomerContact.changeProperty(property, newValueExpr);
      potentialCustomerContact.updateLastUpdateTime(userContext.now());
      potentialCustomerContactPerson =
          savePotentialCustomerContactPerson(
              userContext,
              potentialCustomerContactPerson,
              tokens().withPotentialCustomerContactList().done());
      potentialCustomerContactManagerOf(userContext)
          .onUpdated(userContext, potentialCustomerContact, this, "updatePotentialCustomerContact");
      return present(userContext, potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdatePotentialCustomerContact(
      RetailscmUserContext userContext,
      PotentialCustomerContact existed,
      String potentialCustomerContactPersonId,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, PotentialCustomerContactPerson newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    potentialCustomerContactPersonDaoOf(ctx)
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
    //   PotentialCustomerContactPerson newPotentialCustomerContactPerson =
    // this.createPotentialCustomerContactPerson(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newPotentialCustomerContactPerson
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
    key.put(UserApp.APP_TYPE_PROPERTY, PotentialCustomerContactPerson.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<PotentialCustomerContactPerson> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<PotentialCustomer> potentialCustomerList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, PotentialCustomer.class);
    userContext.getDAOGroup().enhanceList(potentialCustomerList, PotentialCustomer.class);
  }

  public Object listByPotentialCustomer(
      RetailscmUserContext userContext, String potentialCustomerId) throws Exception {
    return listPageByPotentialCustomer(userContext, potentialCustomerId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByPotentialCustomer(
      RetailscmUserContext userContext, String potentialCustomerId, int start, int count)
      throws Exception {
    SmartList<PotentialCustomerContactPerson> list =
        potentialCustomerContactPersonDaoOf(userContext)
            .findPotentialCustomerContactPersonByPotentialCustomer(
                potentialCustomerId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(PotentialCustomerContactPerson.class);
    page.setContainerObject(PotentialCustomer.withId(potentialCustomerId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("潜在客户联络人列表");
    page.setRequestName("listByPotentialCustomer");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(
            String.format("%s/listByPotentialCustomer/%s/", getBeanName(), potentialCustomerId)));

    page.assemblerContent(userContext, "listByPotentialCustomer");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String potentialCustomerContactPersonId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    PotentialCustomerContactPerson merchantObj =
        (PotentialCustomerContactPerson) this.view(userContext, potentialCustomerContactPersonId);
    String merchantObjId = potentialCustomerContactPersonId;
    String linkToUrl = "potentialCustomerContactPersonManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "潜在客户联络人" + "详情";
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
        MapUtil.put("id", "3-mobile")
            .put("fieldName", "mobile")
            .put("label", "手机")
            .put("type", "mobile")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("mobile", merchantObj.getMobile());

    propList.add(
        MapUtil.put("id", "4-potentialCustomer")
            .put("fieldName", "potentialCustomer")
            .put("label", "潜在的客户")
            .put("type", "auto")
            .put("linkToUrl", "potentialCustomerManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("potentialCustomer", merchantObj.getPotentialCustomer());

    propList.add(
        MapUtil.put("id", "5-description")
            .put("fieldName", "description")
            .put("label", "描述")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("description", merchantObj.getDescription());

    // 处理 sectionList

    // 处理Section：potentialCustomerContactListSection
    Map potentialCustomerContactListSection =
        ListofUtils.buildSection(
            "potentialCustomerContactListSection",
            "潜在客户联络名单",
            null,
            "",
            "__no_group",
            "potentialCustomerContactManager/listByContactTo/" + merchantObjId + "/",
            "auto");
    sections.add(potentialCustomerContactListSection);

    result.put(
        "potentialCustomerContactListSection",
        ListofUtils.toShortList(
            merchantObj.getPotentialCustomerContactList(), "potentialCustomerContact"));

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
