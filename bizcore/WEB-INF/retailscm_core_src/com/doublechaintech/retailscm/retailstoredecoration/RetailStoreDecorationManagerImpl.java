package com.doublechaintech.retailscm.retailstoredecoration;

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

public class RetailStoreDecorationManagerImpl extends CustomRetailscmCheckerManager
    implements RetailStoreDecorationManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        RetailStoreDecorationTokens.start().withTokenFromListName(listName).done();
    RetailStoreDecoration retailStoreDecoration =
        (RetailStoreDecoration) this.loadRetailStoreDecoration(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = retailStoreDecoration.collectReferencesFromLists();
    retailStoreDecorationDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, retailStoreDecoration, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new RetailStoreDecorationGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "RetailStoreDecoration";

  @Override
  public RetailStoreDecorationDAO daoOf(RetailscmUserContext userContext) {
    return retailStoreDecorationDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws RetailStoreDecorationManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new RetailStoreDecorationManagerException(message);
  }

  protected RetailStoreDecoration saveRetailStoreDecoration(
      RetailscmUserContext userContext,
      RetailStoreDecoration retailStoreDecoration,
      String[] tokensExpr)
      throws Exception {
    // return getRetailStoreDecorationDAO().save(retailStoreDecoration, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens);
  }

  protected RetailStoreDecoration saveRetailStoreDecorationDetail(
      RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration)
      throws Exception {

    return saveRetailStoreDecoration(userContext, retailStoreDecoration, allTokens());
  }

  public RetailStoreDecoration loadRetailStoreDecoration(
      RetailscmUserContext userContext, String retailStoreDecorationId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreDecoration, tokens);
  }

  public RetailStoreDecoration searchRetailStoreDecoration(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreDecoration, tokens);
  }

  protected RetailStoreDecoration present(
      RetailscmUserContext userContext,
      RetailStoreDecoration retailStoreDecoration,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, retailStoreDecoration, tokens);

    RetailStoreDecoration retailStoreDecorationToPresent =
        retailStoreDecorationDaoOf(userContext).present(retailStoreDecoration, tokens);

    List<BaseEntity> entityListToNaming =
        retailStoreDecorationToPresent.collectReferencesFromLists();
    retailStoreDecorationDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, retailStoreDecoration, tokens);

    return retailStoreDecorationToPresent;
  }

  public RetailStoreDecoration loadRetailStoreDecorationDetail(
      RetailscmUserContext userContext, String retailStoreDecorationId) throws Exception {
    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
    return present(userContext, retailStoreDecoration, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String retailStoreDecorationId)
      throws Exception {
    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, viewTokens());
    markVisited(userContext, retailStoreDecoration);
    return present(userContext, retailStoreDecoration, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String retailStoreDecorationId)
      throws Exception {
    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, viewTokens());
    retailStoreDecoration.summarySuffix();
    markVisited(userContext, retailStoreDecoration);
    return present(userContext, retailStoreDecoration, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String retailStoreDecorationId)
      throws Exception {
    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, analyzeTokens());
    markVisited(userContext, retailStoreDecoration);
    return present(userContext, retailStoreDecoration, analyzeTokens());
  }

  protected RetailStoreDecoration saveRetailStoreDecoration(
      RetailscmUserContext userContext,
      RetailStoreDecoration retailStoreDecoration,
      Map<String, Object> tokens)
      throws Exception {

    return retailStoreDecorationDaoOf(userContext).save(retailStoreDecoration, tokens);
  }

  protected RetailStoreDecoration loadRetailStoreDecoration(
      RetailscmUserContext userContext, String retailStoreDecorationId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);

    return retailStoreDecorationDaoOf(userContext).load(retailStoreDecorationId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      RetailStoreDecoration retailStoreDecoration,
      Map<String, Object> tokens) {
    super.addActions(userContext, retailStoreDecoration, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, RetailStoreDecoration retailStoreDecoration, Map<String, Object> tokens){

  @Override
  public List<RetailStoreDecoration> searchRetailStoreDecorationList(
      RetailscmUserContext ctx, RetailStoreDecorationRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<RetailStoreDecoration> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public RetailStoreDecoration searchRetailStoreDecoration(
      RetailscmUserContext ctx, RetailStoreDecorationRequest pRequest) {
    pRequest.limit(0, 1);
    List<RetailStoreDecoration> list = searchRetailStoreDecorationList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public RetailStoreDecoration createRetailStoreDecoration(
      RetailscmUserContext userContext, String comment) throws Exception {

    checkerOf(userContext).checkCommentOfRetailStoreDecoration(comment);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);

    RetailStoreDecoration retailStoreDecoration = createNewRetailStoreDecoration();

    retailStoreDecoration.setComment(comment);

    retailStoreDecoration =
        saveRetailStoreDecoration(userContext, retailStoreDecoration, emptyOptions());

    onNewInstanceCreated(userContext, retailStoreDecoration);
    return retailStoreDecoration;
  }

  protected RetailStoreDecoration createNewRetailStoreDecoration() {

    return new RetailStoreDecoration();
  }

  protected void checkParamsForUpdatingRetailStoreDecoration(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      int retailStoreDecorationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
    checkerOf(userContext).checkVersionOfRetailStoreDecoration(retailStoreDecorationVersion);

    if (RetailStoreDecoration.COMMENT_PROPERTY.equals(property)) {

      checkerOf(userContext).checkCommentOfRetailStoreDecoration(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
  }

  public RetailStoreDecoration clone(
      RetailscmUserContext userContext, String fromRetailStoreDecorationId) throws Exception {

    return retailStoreDecorationDaoOf(userContext)
        .clone(fromRetailStoreDecorationId, this.allTokens());
  }

  public RetailStoreDecoration internalSaveRetailStoreDecoration(
      RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration)
      throws Exception {
    return internalSaveRetailStoreDecoration(userContext, retailStoreDecoration, allTokens());
  }

  public RetailStoreDecoration internalSaveRetailStoreDecoration(
      RetailscmUserContext userContext,
      RetailStoreDecoration retailStoreDecoration,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingRetailStoreDecoration(userContext, retailStoreDecorationId,
    // retailStoreDecorationVersion, property, newValueExpr, tokensExpr);

    synchronized (retailStoreDecoration) {
      // will be good when the retailStoreDecoration loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreDecoration.
      if (retailStoreDecoration.isChanged()) {}

      // checkerOf(userContext).checkAndFixRetailStoreDecoration(retailStoreDecoration);
      retailStoreDecoration =
          saveRetailStoreDecoration(userContext, retailStoreDecoration, options);
      return retailStoreDecoration;
    }
  }

  public RetailStoreDecoration updateRetailStoreDecoration(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      int retailStoreDecorationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreDecoration(
        userContext,
        retailStoreDecorationId,
        retailStoreDecorationVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
    if (retailStoreDecoration.getVersion() != retailStoreDecorationVersion) {
      String message =
          "The target version("
              + retailStoreDecoration.getVersion()
              + ") is not equals to version("
              + retailStoreDecorationVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreDecoration) {
      // will be good when the retailStoreDecoration loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreDecoration.

      retailStoreDecoration.changeProperty(property, newValueExpr);
      retailStoreDecoration =
          saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().done());
      return present(userContext, retailStoreDecoration, mergedAllTokens(tokensExpr));
      // return saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().done());
    }
  }

  public RetailStoreDecoration updateRetailStoreDecorationProperty(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      int retailStoreDecorationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreDecoration(
        userContext,
        retailStoreDecorationId,
        retailStoreDecorationVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
    if (retailStoreDecoration.getVersion() != retailStoreDecorationVersion) {
      String message =
          "The target version("
              + retailStoreDecoration.getVersion()
              + ") is not equals to version("
              + retailStoreDecorationVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreDecoration) {
      // will be good when the retailStoreDecoration loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreDecoration.

      retailStoreDecoration.changeProperty(property, newValueExpr);

      retailStoreDecoration =
          saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().done());
      return present(userContext, retailStoreDecoration, mergedAllTokens(tokensExpr));
      // return saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected RetailStoreDecorationTokens tokens() {
    return RetailStoreDecorationTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return RetailStoreDecorationTokens.all();
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
    return RetailStoreDecorationTokens.mergeAll(tokens).done();
  }

  // --------------------------------------------------------------

  // --------------------------------------------------------------

  public RetailStoreDecoration forgetByAll(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      int retailStoreDecorationVersion)
      throws Exception {
    return forgetByAllInternal(userContext, retailStoreDecorationId, retailStoreDecorationVersion);
  }

  protected RetailStoreDecoration forgetByAllInternal(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      int retailStoreDecorationVersion)
      throws Exception {

    return retailStoreDecorationDaoOf(userContext)
        .disconnectFromAll(retailStoreDecorationId, retailStoreDecorationVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new RetailStoreDecorationManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      String name,
      String telephone,
      String owner,
      String retailStoreCountryCenterId,
      String cityServiceCenterId,
      String creationId,
      String investmentInvitationId,
      String franchisingId,
      String openingId,
      String closingId,
      Date founded,
      BigDecimal latitude,
      BigDecimal longitude,
      String description,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);

    checkerOf(userContext).checkNameOfRetailStore(name);

    checkerOf(userContext).checkTelephoneOfRetailStore(telephone);

    checkerOf(userContext).checkOwnerOfRetailStore(owner);

    checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);

    checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);

    checkerOf(userContext).checkCreationIdOfRetailStore(creationId);

    checkerOf(userContext).checkInvestmentInvitationIdOfRetailStore(investmentInvitationId);

    checkerOf(userContext).checkFranchisingIdOfRetailStore(franchisingId);

    checkerOf(userContext).checkOpeningIdOfRetailStore(openingId);

    checkerOf(userContext).checkClosingIdOfRetailStore(closingId);

    checkerOf(userContext).checkFoundedOfRetailStore(founded);

    checkerOf(userContext).checkLatitudeOfRetailStore(latitude);

    checkerOf(userContext).checkLongitudeOfRetailStore(longitude);

    checkerOf(userContext).checkDescriptionOfRetailStore(description);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
  }

  public RetailStoreDecoration addRetailStore(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      String name,
      String telephone,
      String owner,
      String retailStoreCountryCenterId,
      String cityServiceCenterId,
      String creationId,
      String investmentInvitationId,
      String franchisingId,
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
        retailStoreDecorationId,
        name,
        telephone,
        owner,
        retailStoreCountryCenterId,
        cityServiceCenterId,
        creationId,
        investmentInvitationId,
        franchisingId,
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
            creationId,
            investmentInvitationId,
            franchisingId,
            openingId,
            closingId,
            founded,
            latitude,
            longitude,
            description);

    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, emptyOptions());
    synchronized (retailStoreDecoration) {
      // Will be good when the retailStoreDecoration loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreDecoration.addRetailStore(retailStore);
      retailStoreDecoration =
          saveRetailStoreDecoration(
              userContext, retailStoreDecoration, tokens().withRetailStoreList().done());

      retailStoreManagerOf(userContext).onNewInstanceCreated(userContext, retailStore);
      return present(userContext, retailStoreDecoration, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStoreProperties(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
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

    checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
    checkerOf(userContext).checkIdOfRetailStore(id);

    checkerOf(userContext).checkNameOfRetailStore(name);
    checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
    checkerOf(userContext).checkOwnerOfRetailStore(owner);
    checkerOf(userContext).checkFoundedOfRetailStore(founded);
    checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
    checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
    checkerOf(userContext).checkDescriptionOfRetailStore(description);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
  }

  public RetailStoreDecoration updateRetailStoreProperties(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
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
        retailStoreDecorationId,
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

    RetailStoreDecoration retailStoreDecorationToUpdate =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);

    if (retailStoreDecorationToUpdate.getRetailStoreList().isEmpty()) {
      throw new RetailStoreDecorationManagerException(
          "RetailStore is NOT FOUND with id: '" + id + "'");
    }

    RetailStore item = retailStoreDecorationToUpdate.getRetailStoreList().first();
    beforeUpdateRetailStoreProperties(
        userContext,
        item,
        retailStoreDecorationId,
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

    // checkParamsForAddingRetailStore(userContext,retailStoreDecorationId,name, code,
    // used,tokensExpr);
    RetailStoreDecoration retailStoreDecoration =
        saveRetailStoreDecoration(
            userContext, retailStoreDecorationToUpdate, tokens().withRetailStoreList().done());
    synchronized (retailStoreDecoration) {
      return present(userContext, retailStoreDecoration, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateRetailStoreProperties(
      RetailscmUserContext userContext,
      RetailStore item,
      String retailStoreDecorationId,
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
      String creationId,
      String investmentInvitationId,
      String franchisingId,
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
    RetailStoreCreation creation = new RetailStoreCreation();
    creation.setId(creationId);
    retailStore.setCreation(creation);
    RetailStoreInvestmentInvitation investmentInvitation = new RetailStoreInvestmentInvitation();
    investmentInvitation.setId(investmentInvitationId);
    retailStore.setInvestmentInvitation(investmentInvitation);
    RetailStoreFranchising franchising = new RetailStoreFranchising();
    franchising.setId(franchisingId);
    retailStore.setFranchising(franchising);
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
      String retailStoreDecorationId,
      String retailStoreIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
    for (String retailStoreIdItem : retailStoreIds) {
      checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
  }

  public RetailStoreDecoration removeRetailStoreList(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      String retailStoreIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStoreList(
        userContext, retailStoreDecorationId, retailStoreIds, tokensExpr);

    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
    synchronized (retailStoreDecoration) {
      // Will be good when the retailStoreDecoration loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreDecorationDaoOf(userContext)
          .planToRemoveRetailStoreList(retailStoreDecoration, retailStoreIds, allTokens());
      retailStoreDecoration =
          saveRetailStoreDecoration(
              userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
      deleteRelationListInGraph(userContext, retailStoreDecoration.getRetailStoreList());
      return present(userContext, retailStoreDecoration, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
    checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
    checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
  }

  public RetailStoreDecoration removeRetailStore(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStore(
        userContext, retailStoreDecorationId, retailStoreId, retailStoreVersion, tokensExpr);

    RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
    synchronized (retailStoreDecoration) {
      // Will be good when the retailStoreDecoration loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreDecoration.removeRetailStore(retailStore);
      retailStoreDecoration =
          saveRetailStoreDecoration(
              userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
      deleteRelationInGraph(userContext, retailStore);
      return present(userContext, retailStoreDecoration, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
    checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
    checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
  }

  public RetailStoreDecoration copyRetailStoreFrom(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingRetailStore(
        userContext, retailStoreDecorationId, retailStoreId, retailStoreVersion, tokensExpr);

    RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
    synchronized (retailStoreDecoration) {
      // Will be good when the retailStoreDecoration loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      retailStore.updateLastUpdateTime(userContext.now());

      retailStoreDecoration.copyRetailStoreFrom(retailStore);
      retailStoreDecoration =
          saveRetailStoreDecoration(
              userContext, retailStoreDecoration, tokens().withRetailStoreList().done());

      retailStoreManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (RetailStore)
                  retailStoreDecoration.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, retailStoreDecoration, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
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

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
  }

  public RetailStoreDecoration updateRetailStore(
      RetailscmUserContext userContext,
      String retailStoreDecorationId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingRetailStore(
        userContext,
        retailStoreDecorationId,
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

    RetailStoreDecoration retailStoreDecoration =
        loadRetailStoreDecoration(userContext, retailStoreDecorationId, loadTokens);

    synchronized (retailStoreDecoration) {
      // Will be good when the retailStoreDecoration loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // retailStoreDecoration.removeRetailStore( retailStore );
      // make changes to AcceleraterAccount.
      RetailStore retailStoreIdVersionKey =
          createIndexedRetailStore(retailStoreId, retailStoreVersion);

      RetailStore retailStore = retailStoreDecoration.findTheRetailStore(retailStoreIdVersionKey);
      if (retailStore == null) {
        throw new RetailStoreDecorationManagerException(retailStoreId + " is NOT FOUND");
      }

      beforeUpdateRetailStore(
          userContext,
          retailStore,
          retailStoreDecorationId,
          retailStoreId,
          retailStoreVersion,
          property,
          newValueExpr,
          tokensExpr);
      retailStore.changeProperty(property, newValueExpr);
      retailStore.updateLastUpdateTime(userContext.now());
      retailStoreDecoration =
          saveRetailStoreDecoration(
              userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
      retailStoreManagerOf(userContext)
          .onUpdated(userContext, retailStore, this, "updateRetailStore");
      return present(userContext, retailStoreDecoration, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateRetailStore(
      RetailscmUserContext userContext,
      RetailStore existed,
      String retailStoreDecorationId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, RetailStoreDecoration newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    retailStoreDecorationDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   RetailStoreDecoration newRetailStoreDecoration =
    // this.createRetailStoreDecoration(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newRetailStoreDecoration
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreDecoration.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<RetailStoreDecoration> list) throws Exception {
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
  public Object wxappview(RetailscmUserContext userContext, String retailStoreDecorationId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    RetailStoreDecoration merchantObj =
        (RetailStoreDecoration) this.view(userContext, retailStoreDecorationId);
    String merchantObjId = retailStoreDecorationId;
    String linkToUrl = "retailStoreDecorationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超装修" + "详情";
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
            "retailStoreManager/listByDecoration/" + merchantObjId + "/",
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
