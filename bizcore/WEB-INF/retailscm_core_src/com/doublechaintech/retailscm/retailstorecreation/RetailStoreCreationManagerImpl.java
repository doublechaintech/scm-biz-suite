package com.doublechaintech.retailscm.retailstorecreation;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
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

public class RetailStoreCreationManagerImpl extends CustomRetailscmCheckerManager
    implements RetailStoreCreationManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        RetailStoreCreationTokens.start().withTokenFromListName(listName).done();
    RetailStoreCreation retailStoreCreation =
        (RetailStoreCreation) this.loadRetailStoreCreation(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = retailStoreCreation.collectReferencesFromLists();
    retailStoreCreationDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, retailStoreCreation, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new RetailStoreCreationGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "RetailStoreCreation";

  @Override
  public RetailStoreCreationDAO daoOf(RetailscmUserContext userContext) {
    return retailStoreCreationDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws RetailStoreCreationManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new RetailStoreCreationManagerException(message);
  }

  protected RetailStoreCreation saveRetailStoreCreation(
      RetailscmUserContext userContext,
      RetailStoreCreation retailStoreCreation,
      String[] tokensExpr)
      throws Exception {
    // return getRetailStoreCreationDAO().save(retailStoreCreation, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveRetailStoreCreation(userContext, retailStoreCreation, tokens);
  }

  protected RetailStoreCreation saveRetailStoreCreationDetail(
      RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation) throws Exception {

    return saveRetailStoreCreation(userContext, retailStoreCreation, allTokens());
  }

  public RetailStoreCreation loadRetailStoreCreation(
      RetailscmUserContext userContext, String retailStoreCreationId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreCreation, tokens);
  }

  public RetailStoreCreation searchRetailStoreCreation(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreCreation, tokens);
  }

  protected RetailStoreCreation present(
      RetailscmUserContext userContext,
      RetailStoreCreation retailStoreCreation,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, retailStoreCreation, tokens);

    RetailStoreCreation retailStoreCreationToPresent =
        retailStoreCreationDaoOf(userContext).present(retailStoreCreation, tokens);

    List<BaseEntity> entityListToNaming = retailStoreCreationToPresent.collectReferencesFromLists();
    retailStoreCreationDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, retailStoreCreation, tokens);

    return retailStoreCreationToPresent;
  }

  public RetailStoreCreation loadRetailStoreCreationDetail(
      RetailscmUserContext userContext, String retailStoreCreationId) throws Exception {
    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
    return present(userContext, retailStoreCreation, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String retailStoreCreationId)
      throws Exception {
    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, viewTokens());
    markVisited(userContext, retailStoreCreation);
    return present(userContext, retailStoreCreation, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String retailStoreCreationId)
      throws Exception {
    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, viewTokens());
    retailStoreCreation.summarySuffix();
    markVisited(userContext, retailStoreCreation);
    return present(userContext, retailStoreCreation, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String retailStoreCreationId)
      throws Exception {
    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, analyzeTokens());
    markVisited(userContext, retailStoreCreation);
    return present(userContext, retailStoreCreation, analyzeTokens());
  }

  protected RetailStoreCreation saveRetailStoreCreation(
      RetailscmUserContext userContext,
      RetailStoreCreation retailStoreCreation,
      Map<String, Object> tokens)
      throws Exception {

    return retailStoreCreationDaoOf(userContext).save(retailStoreCreation, tokens);
  }

  protected RetailStoreCreation loadRetailStoreCreation(
      RetailscmUserContext userContext, String retailStoreCreationId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);

    return retailStoreCreationDaoOf(userContext).load(retailStoreCreationId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      RetailStoreCreation retailStoreCreation,
      Map<String, Object> tokens) {
    super.addActions(userContext, retailStoreCreation, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, RetailStoreCreation retailStoreCreation, Map<String, Object> tokens){

  @Override
  public List<RetailStoreCreation> searchRetailStoreCreationList(
      RetailscmUserContext ctx, RetailStoreCreationRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<RetailStoreCreation> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public RetailStoreCreation searchRetailStoreCreation(
      RetailscmUserContext ctx, RetailStoreCreationRequest pRequest) {
    pRequest.limit(0, 1);
    List<RetailStoreCreation> list = searchRetailStoreCreationList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public RetailStoreCreation createRetailStoreCreation(
      RetailscmUserContext userContext, String comment) throws Exception {

    checkerOf(userContext).checkCommentOfRetailStoreCreation(comment);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);

    RetailStoreCreation retailStoreCreation = createNewRetailStoreCreation();

    retailStoreCreation.setComment(comment);

    retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, emptyOptions());

    onNewInstanceCreated(userContext, retailStoreCreation);
    return retailStoreCreation;
  }

  protected RetailStoreCreation createNewRetailStoreCreation() {

    return new RetailStoreCreation();
  }

  protected void checkParamsForUpdatingRetailStoreCreation(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      int retailStoreCreationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
    checkerOf(userContext).checkVersionOfRetailStoreCreation(retailStoreCreationVersion);

    if (RetailStoreCreation.COMMENT_PROPERTY.equals(property)) {

      checkerOf(userContext).checkCommentOfRetailStoreCreation(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
  }

  public RetailStoreCreation clone(
      RetailscmUserContext userContext, String fromRetailStoreCreationId) throws Exception {

    return retailStoreCreationDaoOf(userContext).clone(fromRetailStoreCreationId, this.allTokens());
  }

  public RetailStoreCreation internalSaveRetailStoreCreation(
      RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation) throws Exception {
    return internalSaveRetailStoreCreation(userContext, retailStoreCreation, allTokens());
  }

  public RetailStoreCreation internalSaveRetailStoreCreation(
      RetailscmUserContext userContext,
      RetailStoreCreation retailStoreCreation,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingRetailStoreCreation(userContext, retailStoreCreationId,
    // retailStoreCreationVersion, property, newValueExpr, tokensExpr);

    synchronized (retailStoreCreation) {
      // will be good when the retailStoreCreation loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreCreation.
      if (retailStoreCreation.isChanged()) {}

      // checkerOf(userContext).checkAndFixRetailStoreCreation(retailStoreCreation);
      retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, options);
      return retailStoreCreation;
    }
  }

  public RetailStoreCreation updateRetailStoreCreation(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      int retailStoreCreationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreCreation(
        userContext,
        retailStoreCreationId,
        retailStoreCreationVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
    if (retailStoreCreation.getVersion() != retailStoreCreationVersion) {
      String message =
          "The target version("
              + retailStoreCreation.getVersion()
              + ") is not equals to version("
              + retailStoreCreationVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreCreation) {
      // will be good when the retailStoreCreation loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreCreation.

      retailStoreCreation.changeProperty(property, newValueExpr);
      retailStoreCreation =
          saveRetailStoreCreation(userContext, retailStoreCreation, tokens().done());
      return present(userContext, retailStoreCreation, mergedAllTokens(tokensExpr));
      // return saveRetailStoreCreation(userContext, retailStoreCreation, tokens().done());
    }
  }

  public RetailStoreCreation updateRetailStoreCreationProperty(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      int retailStoreCreationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreCreation(
        userContext,
        retailStoreCreationId,
        retailStoreCreationVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
    if (retailStoreCreation.getVersion() != retailStoreCreationVersion) {
      String message =
          "The target version("
              + retailStoreCreation.getVersion()
              + ") is not equals to version("
              + retailStoreCreationVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreCreation) {
      // will be good when the retailStoreCreation loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreCreation.

      retailStoreCreation.changeProperty(property, newValueExpr);

      retailStoreCreation =
          saveRetailStoreCreation(userContext, retailStoreCreation, tokens().done());
      return present(userContext, retailStoreCreation, mergedAllTokens(tokensExpr));
      // return saveRetailStoreCreation(userContext, retailStoreCreation, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected RetailStoreCreationTokens tokens() {
    return RetailStoreCreationTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return RetailStoreCreationTokens.all();
  }

  protected Map<String, Object> analyzeTokens() {
    return tokens().allTokens().analyzeAllLists().done();
  }

  protected Map<String, Object> summaryTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> viewTokens() {
    return tokens().allTokens().sortRetailStoreListWith(RetailStore.ID_PROPERTY, sortDesc()).done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return RetailStoreCreationTokens.mergeAll(tokens).done();
  }

  // --------------------------------------------------------------

  // --------------------------------------------------------------

  public RetailStoreCreation forgetByAll(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      int retailStoreCreationVersion)
      throws Exception {
    return forgetByAllInternal(userContext, retailStoreCreationId, retailStoreCreationVersion);
  }

  protected RetailStoreCreation forgetByAllInternal(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      int retailStoreCreationVersion)
      throws Exception {

    return retailStoreCreationDaoOf(userContext)
        .disconnectFromAll(retailStoreCreationId, retailStoreCreationVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new RetailStoreCreationManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String name,
      String telephone,
      String owner,
      String retailStoreCountryCenterId,
      String cityServiceCenterId,
      String investmentInvitationId,
      String franchisingId,
      String decorationId,
      String openingId,
      String closingId,
      Date founded,
      BigDecimal latitude,
      BigDecimal longitude,
      String description,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);

    checkerOf(userContext).checkNameOfRetailStore(name);

    checkerOf(userContext).checkTelephoneOfRetailStore(telephone);

    checkerOf(userContext).checkOwnerOfRetailStore(owner);

    checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);

    checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);

    checkerOf(userContext).checkInvestmentInvitationIdOfRetailStore(investmentInvitationId);

    checkerOf(userContext).checkFranchisingIdOfRetailStore(franchisingId);

    checkerOf(userContext).checkDecorationIdOfRetailStore(decorationId);

    checkerOf(userContext).checkOpeningIdOfRetailStore(openingId);

    checkerOf(userContext).checkClosingIdOfRetailStore(closingId);

    checkerOf(userContext).checkFoundedOfRetailStore(founded);

    checkerOf(userContext).checkLatitudeOfRetailStore(latitude);

    checkerOf(userContext).checkLongitudeOfRetailStore(longitude);

    checkerOf(userContext).checkDescriptionOfRetailStore(description);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
  }

  public RetailStoreCreation addRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String name,
      String telephone,
      String owner,
      String retailStoreCountryCenterId,
      String cityServiceCenterId,
      String investmentInvitationId,
      String franchisingId,
      String decorationId,
      String openingId,
      String closingId,
      Date founded,
      BigDecimal latitude,
      BigDecimal longitude,
      String description,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingRetailStore(
        userContext,
        retailStoreCreationId,
        name,
        telephone,
        owner,
        retailStoreCountryCenterId,
        cityServiceCenterId,
        investmentInvitationId,
        franchisingId,
        decorationId,
        openingId,
        closingId,
        founded,
        latitude,
        longitude,
        description,
        tokensExpr);

    RetailStore retailStore =
        createRetailStore(
            userContext,
            name,
            telephone,
            owner,
            retailStoreCountryCenterId,
            cityServiceCenterId,
            investmentInvitationId,
            franchisingId,
            decorationId,
            openingId,
            closingId,
            founded,
            latitude,
            longitude,
            description);

    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, emptyOptions());
    synchronized (retailStoreCreation) {
      // Will be good when the retailStoreCreation loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCreation.addRetailStore(retailStore);
      retailStoreCreation =
          saveRetailStoreCreation(
              userContext, retailStoreCreation, tokens().withRetailStoreList().done());

      retailStoreManagerOf(userContext).onNewInstanceCreated(userContext, retailStore);
      return present(userContext, retailStoreCreation, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStoreProperties(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String id,
      String name,
      String telephone,
      String owner,
      Date founded,
      BigDecimal latitude,
      BigDecimal longitude,
      String description,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
    checkerOf(userContext).checkIdOfRetailStore(id);

    checkerOf(userContext).checkNameOfRetailStore(name);
    checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
    checkerOf(userContext).checkOwnerOfRetailStore(owner);
    checkerOf(userContext).checkFoundedOfRetailStore(founded);
    checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
    checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
    checkerOf(userContext).checkDescriptionOfRetailStore(description);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
  }

  public RetailStoreCreation updateRetailStoreProperties(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String id,
      String name,
      String telephone,
      String owner,
      Date founded,
      BigDecimal latitude,
      BigDecimal longitude,
      String description,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreProperties(
        userContext,
        retailStoreCreationId,
        id,
        name,
        telephone,
        owner,
        founded,
        latitude,
        longitude,
        description,
        tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withRetailStoreListList()
            .searchRetailStoreListWith(RetailStore.ID_PROPERTY, tokens().is(), id)
            .done();

    RetailStoreCreation retailStoreCreationToUpdate =
        loadRetailStoreCreation(userContext, retailStoreCreationId, options);

    if (retailStoreCreationToUpdate.getRetailStoreList().isEmpty()) {
      throw new RetailStoreCreationManagerException(
          "RetailStore is NOT FOUND with id: '" + id + "'");
    }

    RetailStore item = retailStoreCreationToUpdate.getRetailStoreList().first();
    beforeUpdateRetailStoreProperties(
        userContext,
        item,
        retailStoreCreationId,
        id,
        name,
        telephone,
        owner,
        founded,
        latitude,
        longitude,
        description,
        tokensExpr);
    item.updateName(name);
    item.updateTelephone(telephone);
    item.updateOwner(owner);
    item.updateFounded(founded);
    item.updateLatitude(latitude);
    item.updateLongitude(longitude);
    item.updateDescription(description);

    // checkParamsForAddingRetailStore(userContext,retailStoreCreationId,name, code,
    // used,tokensExpr);
    RetailStoreCreation retailStoreCreation =
        saveRetailStoreCreation(
            userContext, retailStoreCreationToUpdate, tokens().withRetailStoreList().done());
    synchronized (retailStoreCreation) {
      return present(userContext, retailStoreCreation, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateRetailStoreProperties(
      RetailscmUserContext userContext,
      RetailStore item,
      String retailStoreCreationId,
      String id,
      String name,
      String telephone,
      String owner,
      Date founded,
      BigDecimal latitude,
      BigDecimal longitude,
      String description,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected RetailStore createRetailStore(
      RetailscmUserContext userContext,
      String name,
      String telephone,
      String owner,
      String retailStoreCountryCenterId,
      String cityServiceCenterId,
      String investmentInvitationId,
      String franchisingId,
      String decorationId,
      String openingId,
      String closingId,
      Date founded,
      BigDecimal latitude,
      BigDecimal longitude,
      String description)
      throws Exception {

    RetailStore retailStore = new RetailStore();

    retailStore.setName(name);
    retailStore.setTelephone(telephone);
    retailStore.setOwner(owner);
    RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
    retailStoreCountryCenter.setId(retailStoreCountryCenterId);
    retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);
    RetailStoreCityServiceCenter cityServiceCenter = new RetailStoreCityServiceCenter();
    cityServiceCenter.setId(cityServiceCenterId);
    retailStore.setCityServiceCenter(cityServiceCenter);
    RetailStoreInvestmentInvitation investmentInvitation = new RetailStoreInvestmentInvitation();
    investmentInvitation.setId(investmentInvitationId);
    retailStore.setInvestmentInvitation(investmentInvitation);
    RetailStoreFranchising franchising = new RetailStoreFranchising();
    franchising.setId(franchisingId);
    retailStore.setFranchising(franchising);
    RetailStoreDecoration decoration = new RetailStoreDecoration();
    decoration.setId(decorationId);
    retailStore.setDecoration(decoration);
    RetailStoreOpening opening = new RetailStoreOpening();
    opening.setId(openingId);
    retailStore.setOpening(opening);
    RetailStoreClosing closing = new RetailStoreClosing();
    closing.setId(closingId);
    retailStore.setClosing(closing);
    retailStore.setFounded(founded);
    retailStore.setLatitude(latitude);
    retailStore.setLongitude(longitude);
    retailStore.setDescription(description);
    retailStore.setLastUpdateTime(userContext.now());

    return retailStore;
  }

  protected RetailStore createIndexedRetailStore(String id, int version) {

    RetailStore retailStore = new RetailStore();
    retailStore.setId(id);
    retailStore.setVersion(version);
    return retailStore;
  }

  protected void checkParamsForRemovingRetailStoreList(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String retailStoreIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
    for (String retailStoreIdItem : retailStoreIds) {
      checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
  }

  public RetailStoreCreation removeRetailStoreList(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String retailStoreIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStoreList(
        userContext, retailStoreCreationId, retailStoreIds, tokensExpr);

    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
    synchronized (retailStoreCreation) {
      // Will be good when the retailStoreCreation loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCreationDaoOf(userContext)
          .planToRemoveRetailStoreList(retailStoreCreation, retailStoreIds, allTokens());
      retailStoreCreation =
          saveRetailStoreCreation(
              userContext, retailStoreCreation, tokens().withRetailStoreList().done());
      deleteRelationListInGraph(userContext, retailStoreCreation.getRetailStoreList());
      return present(userContext, retailStoreCreation, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
    checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
    checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
  }

  public RetailStoreCreation removeRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStore(
        userContext, retailStoreCreationId, retailStoreId, retailStoreVersion, tokensExpr);

    RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
    synchronized (retailStoreCreation) {
      // Will be good when the retailStoreCreation loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCreation.removeRetailStore(retailStore);
      retailStoreCreation =
          saveRetailStoreCreation(
              userContext, retailStoreCreation, tokens().withRetailStoreList().done());
      deleteRelationInGraph(userContext, retailStore);
      return present(userContext, retailStoreCreation, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
    checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
    checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
  }

  public RetailStoreCreation copyRetailStoreFrom(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingRetailStore(
        userContext, retailStoreCreationId, retailStoreId, retailStoreVersion, tokensExpr);

    RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
    synchronized (retailStoreCreation) {
      // Will be good when the retailStoreCreation loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      retailStore.updateLastUpdateTime(userContext.now());

      retailStoreCreation.copyRetailStoreFrom(retailStore);
      retailStoreCreation =
          saveRetailStoreCreation(
              userContext, retailStoreCreation, tokens().withRetailStoreList().done());

      retailStoreManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (RetailStore) retailStoreCreation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, retailStoreCreation, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
    checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
    checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

    if (RetailStore.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfRetailStore(parseString(newValueExpr));
    }

    if (RetailStore.TELEPHONE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkTelephoneOfRetailStore(parseString(newValueExpr));
    }

    if (RetailStore.OWNER_PROPERTY.equals(property)) {
      checkerOf(userContext).checkOwnerOfRetailStore(parseString(newValueExpr));
    }

    if (RetailStore.FOUNDED_PROPERTY.equals(property)) {
      checkerOf(userContext).checkFoundedOfRetailStore(parseDate(newValueExpr));
    }

    if (RetailStore.LATITUDE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkLatitudeOfRetailStore(parseBigDecimal(newValueExpr));
    }

    if (RetailStore.LONGITUDE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkLongitudeOfRetailStore(parseBigDecimal(newValueExpr));
    }

    if (RetailStore.DESCRIPTION_PROPERTY.equals(property)) {
      checkerOf(userContext).checkDescriptionOfRetailStore(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
  }

  public RetailStoreCreation updateRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCreationId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingRetailStore(
        userContext,
        retailStoreCreationId,
        retailStoreId,
        retailStoreVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withRetailStoreList()
            .searchRetailStoreListWith(RetailStore.ID_PROPERTY, tokens().equals(), retailStoreId)
            .done();

    RetailStoreCreation retailStoreCreation =
        loadRetailStoreCreation(userContext, retailStoreCreationId, loadTokens);

    synchronized (retailStoreCreation) {
      // Will be good when the retailStoreCreation loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // retailStoreCreation.removeRetailStore( retailStore );
      // make changes to AcceleraterAccount.
      RetailStore retailStoreIdVersionKey =
          createIndexedRetailStore(retailStoreId, retailStoreVersion);

      RetailStore retailStore = retailStoreCreation.findTheRetailStore(retailStoreIdVersionKey);
      if (retailStore == null) {
        throw new RetailStoreCreationManagerException(retailStoreId + " is NOT FOUND");
      }

      beforeUpdateRetailStore(
          userContext,
          retailStore,
          retailStoreCreationId,
          retailStoreId,
          retailStoreVersion,
          property,
          newValueExpr,
          tokensExpr);
      retailStore.changeProperty(property, newValueExpr);
      retailStore.updateLastUpdateTime(userContext.now());
      retailStoreCreation =
          saveRetailStoreCreation(
              userContext, retailStoreCreation, tokens().withRetailStoreList().done());
      retailStoreManagerOf(userContext)
          .onUpdated(userContext, retailStore, this, "updateRetailStore");
      return present(userContext, retailStoreCreation, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateRetailStore(
      RetailscmUserContext userContext,
      RetailStore existed,
      String retailStoreCreationId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreCreation newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    retailStoreCreationDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   RetailStoreCreation newRetailStoreCreation = this.createRetailStoreCreation(userContext,
    // ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newRetailStoreCreation
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreCreation.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<RetailStoreCreation> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String retailStoreCreationId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    RetailStoreCreation merchantObj =
        (RetailStoreCreation) this.view(userContext, retailStoreCreationId);
    String merchantObjId = retailStoreCreationId;
    String linkToUrl = "retailStoreCreationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "双链小超的创作" + "详情";
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
        MapUtil.put("id", "2-comment")
            .put("fieldName", "comment")
            .put("label", "评论")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("comment", merchantObj.getComment());

    // 处理 sectionList

    // 处理Section：retailStoreListSection
    Map retailStoreListSection =
        ListofUtils.buildSection(
            "retailStoreListSection",
            "零售门店列表",
            null,
            "",
            "__no_group",
            "retailStoreManager/listByCreation/" + merchantObjId + "/",
            "auto");
    sections.add(retailStoreListSection);

    result.put(
        "retailStoreListSection",
        ListofUtils.toShortList(merchantObj.getRetailStoreList(), "retailStore"));

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
