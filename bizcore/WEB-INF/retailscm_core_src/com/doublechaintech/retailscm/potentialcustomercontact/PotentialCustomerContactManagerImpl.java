package com.doublechaintech.retailscm.potentialcustomercontact;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.citypartner.CandidateCityPartner;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.potentialcustomer.CandidatePotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomercontactperson.CandidatePotentialCustomerContactPerson;
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

public class PotentialCustomerContactManagerImpl extends CustomRetailscmCheckerManager
    implements PotentialCustomerContactManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "PotentialCustomerContact";

  @Override
  public PotentialCustomerContactDAO daoOf(RetailscmUserContext userContext) {
    return potentialCustomerContactDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws PotentialCustomerContactManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new PotentialCustomerContactManagerException(message);
  }

  protected PotentialCustomerContact savePotentialCustomerContact(
      RetailscmUserContext userContext,
      PotentialCustomerContact potentialCustomerContact,
      String[] tokensExpr)
      throws Exception {
    // return getPotentialCustomerContactDAO().save(potentialCustomerContact, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return savePotentialCustomerContact(userContext, potentialCustomerContact, tokens);
  }

  protected PotentialCustomerContact savePotentialCustomerContactDetail(
      RetailscmUserContext userContext, PotentialCustomerContact potentialCustomerContact)
      throws Exception {

    return savePotentialCustomerContact(userContext, potentialCustomerContact, allTokens());
  }

  public PotentialCustomerContact loadPotentialCustomerContact(
      RetailscmUserContext userContext, String potentialCustomerContactId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    PotentialCustomerContact potentialCustomerContact =
        loadPotentialCustomerContact(userContext, potentialCustomerContactId, tokens);
    // do some calc before sent to customer?
    return present(userContext, potentialCustomerContact, tokens);
  }

  public PotentialCustomerContact searchPotentialCustomerContact(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    PotentialCustomerContact potentialCustomerContact =
        loadPotentialCustomerContact(userContext, potentialCustomerContactId, tokens);
    // do some calc before sent to customer?
    return present(userContext, potentialCustomerContact, tokens);
  }

  protected PotentialCustomerContact present(
      RetailscmUserContext userContext,
      PotentialCustomerContact potentialCustomerContact,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, potentialCustomerContact, tokens);

    PotentialCustomerContact potentialCustomerContactToPresent =
        potentialCustomerContactDaoOf(userContext).present(potentialCustomerContact, tokens);

    List<BaseEntity> entityListToNaming =
        potentialCustomerContactToPresent.collectReferencesFromLists();
    potentialCustomerContactDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, potentialCustomerContact, tokens);

    return potentialCustomerContactToPresent;
  }

  public PotentialCustomerContact loadPotentialCustomerContactDetail(
      RetailscmUserContext userContext, String potentialCustomerContactId) throws Exception {
    PotentialCustomerContact potentialCustomerContact =
        loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());
    return present(userContext, potentialCustomerContact, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String potentialCustomerContactId)
      throws Exception {
    PotentialCustomerContact potentialCustomerContact =
        loadPotentialCustomerContact(userContext, potentialCustomerContactId, viewTokens());
    markVisited(userContext, potentialCustomerContact);
    return present(userContext, potentialCustomerContact, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String potentialCustomerContactId)
      throws Exception {
    PotentialCustomerContact potentialCustomerContact =
        loadPotentialCustomerContact(userContext, potentialCustomerContactId, viewTokens());
    potentialCustomerContact.summarySuffix();
    markVisited(userContext, potentialCustomerContact);
    return present(userContext, potentialCustomerContact, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String potentialCustomerContactId)
      throws Exception {
    PotentialCustomerContact potentialCustomerContact =
        loadPotentialCustomerContact(userContext, potentialCustomerContactId, analyzeTokens());
    markVisited(userContext, potentialCustomerContact);
    return present(userContext, potentialCustomerContact, analyzeTokens());
  }

  protected PotentialCustomerContact savePotentialCustomerContact(
      RetailscmUserContext userContext,
      PotentialCustomerContact potentialCustomerContact,
      Map<String, Object> tokens)
      throws Exception {

    return potentialCustomerContactDaoOf(userContext).save(potentialCustomerContact, tokens);
  }

  protected PotentialCustomerContact loadPotentialCustomerContact(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);

    return potentialCustomerContactDaoOf(userContext).load(potentialCustomerContactId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      PotentialCustomerContact potentialCustomerContact,
      Map<String, Object> tokens) {
    super.addActions(userContext, potentialCustomerContact, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, PotentialCustomerContact potentialCustomerContact, Map<String, Object> tokens){

  @Override
  public List<PotentialCustomerContact> searchPotentialCustomerContactList(
      RetailscmUserContext ctx, PotentialCustomerContactRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<PotentialCustomerContact> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public PotentialCustomerContact searchPotentialCustomerContact(
      RetailscmUserContext ctx, PotentialCustomerContactRequest pRequest) {
    pRequest.limit(0, 1);
    List<PotentialCustomerContact> list = searchPotentialCustomerContactList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public PotentialCustomerContact createPotentialCustomerContact(
      RetailscmUserContext userContext,
      String name,
      Date contactDate,
      String contactMethod,
      String potentialCustomerId,
      String cityPartnerId,
      String contactToId,
      String description)
      throws Exception {

    checkerOf(userContext).checkNameOfPotentialCustomerContact(name);
    checkerOf(userContext).checkContactDateOfPotentialCustomerContact(contactDate);
    checkerOf(userContext).checkContactMethodOfPotentialCustomerContact(contactMethod);
    checkerOf(userContext).checkDescriptionOfPotentialCustomerContact(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);

    PotentialCustomerContact potentialCustomerContact = createNewPotentialCustomerContact();

    potentialCustomerContact.setName(name);
    potentialCustomerContact.setContactDate(contactDate);
    potentialCustomerContact.setContactMethod(contactMethod);

    PotentialCustomer potentialCustomer =
        loadPotentialCustomer(userContext, potentialCustomerId, emptyOptions());
    potentialCustomerContact.setPotentialCustomer(potentialCustomer);

    CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, emptyOptions());
    potentialCustomerContact.setCityPartner(cityPartner);

    PotentialCustomerContactPerson contactTo =
        loadPotentialCustomerContactPerson(userContext, contactToId, emptyOptions());
    potentialCustomerContact.setContactTo(contactTo);

    potentialCustomerContact.setDescription(description);
    potentialCustomerContact.setLastUpdateTime(userContext.now());

    potentialCustomerContact =
        savePotentialCustomerContact(userContext, potentialCustomerContact, emptyOptions());

    onNewInstanceCreated(userContext, potentialCustomerContact);
    return potentialCustomerContact;
  }

  protected PotentialCustomerContact createNewPotentialCustomerContact() {

    return new PotentialCustomerContact();
  }

  protected void checkParamsForUpdatingPotentialCustomerContact(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

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
        .throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);
  }

  public PotentialCustomerContact clone(
      RetailscmUserContext userContext, String fromPotentialCustomerContactId) throws Exception {

    return potentialCustomerContactDaoOf(userContext)
        .clone(fromPotentialCustomerContactId, this.allTokens());
  }

  public PotentialCustomerContact internalSavePotentialCustomerContact(
      RetailscmUserContext userContext, PotentialCustomerContact potentialCustomerContact)
      throws Exception {
    return internalSavePotentialCustomerContact(userContext, potentialCustomerContact, allTokens());
  }

  public PotentialCustomerContact internalSavePotentialCustomerContact(
      RetailscmUserContext userContext,
      PotentialCustomerContact potentialCustomerContact,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingPotentialCustomerContact(userContext, potentialCustomerContactId,
    // potentialCustomerContactVersion, property, newValueExpr, tokensExpr);

    synchronized (potentialCustomerContact) {
      // will be good when the potentialCustomerContact loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PotentialCustomerContact.
      if (potentialCustomerContact.isChanged()) {
        potentialCustomerContact.updateLastUpdateTime(userContext.now());
      }

      // checkerOf(userContext).checkAndFixPotentialCustomerContact(potentialCustomerContact);
      potentialCustomerContact =
          savePotentialCustomerContact(userContext, potentialCustomerContact, options);
      return potentialCustomerContact;
    }
  }

  public PotentialCustomerContact updatePotentialCustomerContact(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPotentialCustomerContact(
        userContext,
        potentialCustomerContactId,
        potentialCustomerContactVersion,
        property,
        newValueExpr,
        tokensExpr);

    PotentialCustomerContact potentialCustomerContact =
        loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());
    if (potentialCustomerContact.getVersion() != potentialCustomerContactVersion) {
      String message =
          "The target version("
              + potentialCustomerContact.getVersion()
              + ") is not equals to version("
              + potentialCustomerContactVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (potentialCustomerContact) {
      // will be good when the potentialCustomerContact loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PotentialCustomerContact.
      potentialCustomerContact.updateLastUpdateTime(userContext.now());
      potentialCustomerContact.changeProperty(property, newValueExpr);
      potentialCustomerContact =
          savePotentialCustomerContact(userContext, potentialCustomerContact, tokens().done());
      return present(userContext, potentialCustomerContact, mergedAllTokens(tokensExpr));
      // return savePotentialCustomerContact(userContext, potentialCustomerContact,
      // tokens().done());
    }
  }

  public PotentialCustomerContact updatePotentialCustomerContactProperty(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPotentialCustomerContact(
        userContext,
        potentialCustomerContactId,
        potentialCustomerContactVersion,
        property,
        newValueExpr,
        tokensExpr);

    PotentialCustomerContact potentialCustomerContact =
        loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());
    if (potentialCustomerContact.getVersion() != potentialCustomerContactVersion) {
      String message =
          "The target version("
              + potentialCustomerContact.getVersion()
              + ") is not equals to version("
              + potentialCustomerContactVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (potentialCustomerContact) {
      // will be good when the potentialCustomerContact loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PotentialCustomerContact.

      potentialCustomerContact.changeProperty(property, newValueExpr);
      potentialCustomerContact.updateLastUpdateTime(userContext.now());
      potentialCustomerContact =
          savePotentialCustomerContact(userContext, potentialCustomerContact, tokens().done());
      return present(userContext, potentialCustomerContact, mergedAllTokens(tokensExpr));
      // return savePotentialCustomerContact(userContext, potentialCustomerContact,
      // tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected PotentialCustomerContactTokens tokens() {
    return PotentialCustomerContactTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return PotentialCustomerContactTokens.all();
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
    return PotentialCustomerContactTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherPotentialCustomer(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      String anotherPotentialCustomerId)
      throws Exception {

    checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
    checkerOf(userContext)
        .checkIdOfPotentialCustomer(anotherPotentialCustomerId); // check for optional reference

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);
  }

  public PotentialCustomerContact transferToAnotherPotentialCustomer(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      String anotherPotentialCustomerId)
      throws Exception {
    checkParamsForTransferingAnotherPotentialCustomer(
        userContext, potentialCustomerContactId, anotherPotentialCustomerId);

    PotentialCustomerContact potentialCustomerContact =
        loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());
    synchronized (potentialCustomerContact) {
      // will be good when the potentialCustomerContact loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      PotentialCustomer potentialCustomer =
          loadPotentialCustomer(userContext, anotherPotentialCustomerId, emptyOptions());
      potentialCustomerContact.updatePotentialCustomer(potentialCustomer);
      potentialCustomerContact.updateLastUpdateTime(userContext.now());
      potentialCustomerContact =
          savePotentialCustomerContact(userContext, potentialCustomerContact, emptyOptions());

      return present(userContext, potentialCustomerContact, allTokens());
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
            .requestCandidatePotentialCustomerForPotentialCustomerContact(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  protected void checkParamsForTransferingAnotherCityPartner(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      String anotherCityPartnerId)
      throws Exception {

    checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
    checkerOf(userContext)
        .checkIdOfCityPartner(anotherCityPartnerId); // check for optional reference

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);
  }

  public PotentialCustomerContact transferToAnotherCityPartner(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      String anotherCityPartnerId)
      throws Exception {
    checkParamsForTransferingAnotherCityPartner(
        userContext, potentialCustomerContactId, anotherCityPartnerId);

    PotentialCustomerContact potentialCustomerContact =
        loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());
    synchronized (potentialCustomerContact) {
      // will be good when the potentialCustomerContact loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      CityPartner cityPartner = loadCityPartner(userContext, anotherCityPartnerId, emptyOptions());
      potentialCustomerContact.updateCityPartner(cityPartner);
      potentialCustomerContact.updateLastUpdateTime(userContext.now());
      potentialCustomerContact =
          savePotentialCustomerContact(userContext, potentialCustomerContact, emptyOptions());

      return present(userContext, potentialCustomerContact, allTokens());
    }
  }

  public CandidateCityPartner requestCandidateCityPartner(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateCityPartner result = new CandidateCityPartner();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<CityPartner> candidateList =
        cityPartnerDaoOf(userContext)
            .requestCandidateCityPartnerForPotentialCustomerContact(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  protected void checkParamsForTransferingAnotherContactTo(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      String anotherContactToId)
      throws Exception {

    checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
    checkerOf(userContext)
        .checkIdOfPotentialCustomerContactPerson(
            anotherContactToId); // check for optional reference

    checkerOf(userContext)
        .throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);
  }

  public PotentialCustomerContact transferToAnotherContactTo(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      String anotherContactToId)
      throws Exception {
    checkParamsForTransferingAnotherContactTo(
        userContext, potentialCustomerContactId, anotherContactToId);

    PotentialCustomerContact potentialCustomerContact =
        loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());
    synchronized (potentialCustomerContact) {
      // will be good when the potentialCustomerContact loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      PotentialCustomerContactPerson contactTo =
          loadPotentialCustomerContactPerson(userContext, anotherContactToId, emptyOptions());
      potentialCustomerContact.updateContactTo(contactTo);
      potentialCustomerContact.updateLastUpdateTime(userContext.now());
      potentialCustomerContact =
          savePotentialCustomerContact(userContext, potentialCustomerContact, emptyOptions());

      return present(userContext, potentialCustomerContact, allTokens());
    }
  }

  public CandidatePotentialCustomerContactPerson requestCandidateContactTo(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidatePotentialCustomerContactPerson result = new CandidatePotentialCustomerContactPerson();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<PotentialCustomerContactPerson> candidateList =
        potentialCustomerContactPersonDaoOf(userContext)
            .requestCandidatePotentialCustomerContactPersonForPotentialCustomerContact(
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

  protected CityPartner loadCityPartner(
      RetailscmUserContext userContext, String newCityPartnerId, Map<String, Object> options)
      throws Exception {

    return cityPartnerDaoOf(userContext).load(newCityPartnerId, options);
  }

  protected PotentialCustomerContactPerson loadPotentialCustomerContactPerson(
      RetailscmUserContext userContext, String newContactToId, Map<String, Object> options)
      throws Exception {

    return potentialCustomerContactPersonDaoOf(userContext).load(newContactToId, options);
  }

  // --------------------------------------------------------------

  public PotentialCustomerContact forgetByAll(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion)
      throws Exception {
    return forgetByAllInternal(
        userContext, potentialCustomerContactId, potentialCustomerContactVersion);
  }

  protected PotentialCustomerContact forgetByAllInternal(
      RetailscmUserContext userContext,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion)
      throws Exception {

    return potentialCustomerContactDaoOf(userContext)
        .disconnectFromAll(potentialCustomerContactId, potentialCustomerContactVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new PotentialCustomerContactManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, PotentialCustomerContact newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    potentialCustomerContactDaoOf(ctx)
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
    //   PotentialCustomerContact newPotentialCustomerContact =
    // this.createPotentialCustomerContact(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newPotentialCustomerContact
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
    key.put(UserApp.APP_TYPE_PROPERTY, PotentialCustomerContact.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<PotentialCustomerContact> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<PotentialCustomer> potentialCustomerList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, PotentialCustomer.class);
    userContext.getDAOGroup().enhanceList(potentialCustomerList, PotentialCustomer.class);
    List<CityPartner> cityPartnerList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, CityPartner.class);
    userContext.getDAOGroup().enhanceList(cityPartnerList, CityPartner.class);
    List<PotentialCustomerContactPerson> contactToList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, PotentialCustomerContactPerson.class);
    userContext.getDAOGroup().enhanceList(contactToList, PotentialCustomerContactPerson.class);
  }

  public Object listByPotentialCustomer(
      RetailscmUserContext userContext, String potentialCustomerId) throws Exception {
    return listPageByPotentialCustomer(userContext, potentialCustomerId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByPotentialCustomer(
      RetailscmUserContext userContext, String potentialCustomerId, int start, int count)
      throws Exception {
    SmartList<PotentialCustomerContact> list =
        potentialCustomerContactDaoOf(userContext)
            .findPotentialCustomerContactByPotentialCustomer(
                potentialCustomerId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(PotentialCustomerContact.class);
    page.setContainerObject(PotentialCustomer.withId(potentialCustomerId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("潜在客户联系列表");
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

  public Object listByCityPartner(RetailscmUserContext userContext, String cityPartnerId)
      throws Exception {
    return listPageByCityPartner(userContext, cityPartnerId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByCityPartner(
      RetailscmUserContext userContext, String cityPartnerId, int start, int count)
      throws Exception {
    SmartList<PotentialCustomerContact> list =
        potentialCustomerContactDaoOf(userContext)
            .findPotentialCustomerContactByCityPartner(
                cityPartnerId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(PotentialCustomerContact.class);
    page.setContainerObject(CityPartner.withId(cityPartnerId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("潜在客户联系列表");
    page.setRequestName("listByCityPartner");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(
            String.format("%s/listByCityPartner/%s/", getBeanName(), cityPartnerId)));

    page.assemblerContent(userContext, "listByCityPartner");
    return page.doRender(userContext);
  }

  public Object listByContactTo(RetailscmUserContext userContext, String contactToId)
      throws Exception {
    return listPageByContactTo(userContext, contactToId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByContactTo(
      RetailscmUserContext userContext, String contactToId, int start, int count) throws Exception {
    SmartList<PotentialCustomerContact> list =
        potentialCustomerContactDaoOf(userContext)
            .findPotentialCustomerContactByContactTo(contactToId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(PotentialCustomerContact.class);
    page.setContainerObject(PotentialCustomerContactPerson.withId(contactToId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("潜在客户联系列表");
    page.setRequestName("listByContactTo");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByContactTo/%s/", getBeanName(), contactToId)));

    page.assemblerContent(userContext, "listByContactTo");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String potentialCustomerContactId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    PotentialCustomerContact merchantObj =
        (PotentialCustomerContact) this.view(userContext, potentialCustomerContactId);
    String merchantObjId = potentialCustomerContactId;
    String linkToUrl = "potentialCustomerContactManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "潜在客户联系" + "详情";
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
        MapUtil.put("id", "3-contactDate")
            .put("fieldName", "contactDate")
            .put("label", "接触日期")
            .put("type", "date")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("contactDate", merchantObj.getContactDate());

    propList.add(
        MapUtil.put("id", "4-contactMethod")
            .put("fieldName", "contactMethod")
            .put("label", "接触法")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("contactMethod", merchantObj.getContactMethod());

    propList.add(
        MapUtil.put("id", "5-potentialCustomer")
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
        MapUtil.put("id", "6-cityPartner")
            .put("fieldName", "cityPartner")
            .put("label", "城市合伙人")
            .put("type", "auto")
            .put("linkToUrl", "cityPartnerManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("cityPartner", merchantObj.getCityPartner());

    propList.add(
        MapUtil.put("id", "7-contactTo")
            .put("fieldName", "contactTo")
            .put("label", "接触")
            .put("type", "auto")
            .put("linkToUrl", "potentialCustomerContactPersonManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("contactTo", merchantObj.getContactTo());

    propList.add(
        MapUtil.put("id", "8-description")
            .put("fieldName", "description")
            .put("label", "描述")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("description", merchantObj.getDescription());

    propList.add(
        MapUtil.put("id", "9-lastUpdateTime")
            .put("fieldName", "lastUpdateTime")
            .put("label", "更新于")
            .put("type", "datetime")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

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
