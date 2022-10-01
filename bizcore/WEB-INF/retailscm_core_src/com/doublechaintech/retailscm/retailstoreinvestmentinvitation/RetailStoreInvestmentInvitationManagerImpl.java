package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;

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

public class RetailStoreInvestmentInvitationManagerImpl extends CustomRetailscmCheckerManager
    implements RetailStoreInvestmentInvitationManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        RetailStoreInvestmentInvitationTokens.start().withTokenFromListName(listName).done();
    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        (RetailStoreInvestmentInvitation)
            this.loadRetailStoreInvestmentInvitation(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming =
        retailStoreInvestmentInvitation.collectReferencesFromLists();
    retailStoreInvestmentInvitationDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, retailStoreInvestmentInvitation, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new RetailStoreInvestmentInvitationGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "RetailStoreInvestmentInvitation";

  @Override
  public RetailStoreInvestmentInvitationDAO daoOf(RetailscmUserContext userContext) {
    return retailStoreInvestmentInvitationDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws RetailStoreInvestmentInvitationManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new RetailStoreInvestmentInvitationManagerException(message);
  }

  protected RetailStoreInvestmentInvitation saveRetailStoreInvestmentInvitation(
      RetailscmUserContext userContext,
      RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,
      String[] tokensExpr)
      throws Exception {
    // return getRetailStoreInvestmentInvitationDAO().save(retailStoreInvestmentInvitation, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveRetailStoreInvestmentInvitation(
        userContext, retailStoreInvestmentInvitation, tokens);
  }

  protected RetailStoreInvestmentInvitation saveRetailStoreInvestmentInvitationDetail(
      RetailscmUserContext userContext,
      RetailStoreInvestmentInvitation retailStoreInvestmentInvitation)
      throws Exception {

    return saveRetailStoreInvestmentInvitation(
        userContext, retailStoreInvestmentInvitation, allTokens());
  }

  public RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreInvestmentInvitation, tokens);
  }

  public RetailStoreInvestmentInvitation searchRetailStoreInvestmentInvitation(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreInvestmentInvitation, tokens);
  }

  protected RetailStoreInvestmentInvitation present(
      RetailscmUserContext userContext,
      RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, retailStoreInvestmentInvitation, tokens);

    RetailStoreInvestmentInvitation retailStoreInvestmentInvitationToPresent =
        retailStoreInvestmentInvitationDaoOf(userContext)
            .present(retailStoreInvestmentInvitation, tokens);

    List<BaseEntity> entityListToNaming =
        retailStoreInvestmentInvitationToPresent.collectReferencesFromLists();
    retailStoreInvestmentInvitationDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, retailStoreInvestmentInvitation, tokens);

    return retailStoreInvestmentInvitationToPresent;
  }

  public RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitationDetail(
      RetailscmUserContext userContext, String retailStoreInvestmentInvitationId) throws Exception {
    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitationId, allTokens());
    return present(userContext, retailStoreInvestmentInvitation, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId)
      throws Exception {
    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitationId, viewTokens());
    markVisited(userContext, retailStoreInvestmentInvitation);
    return present(userContext, retailStoreInvestmentInvitation, viewTokens());
  }

  public Object summaryView(
      RetailscmUserContext userContext, String retailStoreInvestmentInvitationId) throws Exception {
    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitationId, viewTokens());
    retailStoreInvestmentInvitation.summarySuffix();
    markVisited(userContext, retailStoreInvestmentInvitation);
    return present(userContext, retailStoreInvestmentInvitation, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId)
      throws Exception {
    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitationId, analyzeTokens());
    markVisited(userContext, retailStoreInvestmentInvitation);
    return present(userContext, retailStoreInvestmentInvitation, analyzeTokens());
  }

  protected RetailStoreInvestmentInvitation saveRetailStoreInvestmentInvitation(
      RetailscmUserContext userContext,
      RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,
      Map<String, Object> tokens)
      throws Exception {

    return retailStoreInvestmentInvitationDaoOf(userContext)
        .save(retailStoreInvestmentInvitation, tokens);
  }

  protected RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext)
        .checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);

    return retailStoreInvestmentInvitationDaoOf(userContext)
        .load(retailStoreInvestmentInvitationId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,
      Map<String, Object> tokens) {
    super.addActions(userContext, retailStoreInvestmentInvitation, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,
    // Object> tokens){

  @Override
  public List<RetailStoreInvestmentInvitation> searchRetailStoreInvestmentInvitationList(
      RetailscmUserContext ctx, RetailStoreInvestmentInvitationRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<RetailStoreInvestmentInvitation> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public RetailStoreInvestmentInvitation searchRetailStoreInvestmentInvitation(
      RetailscmUserContext ctx, RetailStoreInvestmentInvitationRequest pRequest) {
    pRequest.limit(0, 1);
    List<RetailStoreInvestmentInvitation> list =
        searchRetailStoreInvestmentInvitationList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(
      RetailscmUserContext userContext, String comment) throws Exception {

    checkerOf(userContext).checkCommentOfRetailStoreInvestmentInvitation(comment);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);

    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        createNewRetailStoreInvestmentInvitation();

    retailStoreInvestmentInvitation.setComment(comment);

    retailStoreInvestmentInvitation =
        saveRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitation, emptyOptions());

    onNewInstanceCreated(userContext, retailStoreInvestmentInvitation);
    return retailStoreInvestmentInvitation;
  }

  protected RetailStoreInvestmentInvitation createNewRetailStoreInvestmentInvitation() {

    return new RetailStoreInvestmentInvitation();
  }

  protected void checkParamsForUpdatingRetailStoreInvestmentInvitation(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      int retailStoreInvestmentInvitationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
    checkerOf(userContext)
        .checkVersionOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationVersion);

    if (RetailStoreInvestmentInvitation.COMMENT_PROPERTY.equals(property)) {

      checkerOf(userContext)
          .checkCommentOfRetailStoreInvestmentInvitation(parseString(newValueExpr));
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
  }

  public RetailStoreInvestmentInvitation clone(
      RetailscmUserContext userContext, String fromRetailStoreInvestmentInvitationId)
      throws Exception {

    return retailStoreInvestmentInvitationDaoOf(userContext)
        .clone(fromRetailStoreInvestmentInvitationId, this.allTokens());
  }

  public RetailStoreInvestmentInvitation internalSaveRetailStoreInvestmentInvitation(
      RetailscmUserContext userContext,
      RetailStoreInvestmentInvitation retailStoreInvestmentInvitation)
      throws Exception {
    return internalSaveRetailStoreInvestmentInvitation(
        userContext, retailStoreInvestmentInvitation, allTokens());
  }

  public RetailStoreInvestmentInvitation internalSaveRetailStoreInvestmentInvitation(
      RetailscmUserContext userContext,
      RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingRetailStoreInvestmentInvitation(userContext,
    // retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion, property,
    // newValueExpr, tokensExpr);

    synchronized (retailStoreInvestmentInvitation) {
      // will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreInvestmentInvitation.
      if (retailStoreInvestmentInvitation.isChanged()) {}

      // checkerOf(userContext).checkAndFixRetailStoreInvestmentInvitation(retailStoreInvestmentInvitation);
      retailStoreInvestmentInvitation =
          saveRetailStoreInvestmentInvitation(
              userContext, retailStoreInvestmentInvitation, options);
      return retailStoreInvestmentInvitation;
    }
  }

  public RetailStoreInvestmentInvitation updateRetailStoreInvestmentInvitation(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      int retailStoreInvestmentInvitationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreInvestmentInvitation(
        userContext,
        retailStoreInvestmentInvitationId,
        retailStoreInvestmentInvitationVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitationId, allTokens());
    if (retailStoreInvestmentInvitation.getVersion() != retailStoreInvestmentInvitationVersion) {
      String message =
          "The target version("
              + retailStoreInvestmentInvitation.getVersion()
              + ") is not equals to version("
              + retailStoreInvestmentInvitationVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreInvestmentInvitation) {
      // will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreInvestmentInvitation.

      retailStoreInvestmentInvitation.changeProperty(property, newValueExpr);
      retailStoreInvestmentInvitation =
          saveRetailStoreInvestmentInvitation(
              userContext, retailStoreInvestmentInvitation, tokens().done());
      return present(userContext, retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
      // return saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation,
      // tokens().done());
    }
  }

  public RetailStoreInvestmentInvitation updateRetailStoreInvestmentInvitationProperty(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      int retailStoreInvestmentInvitationVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreInvestmentInvitation(
        userContext,
        retailStoreInvestmentInvitationId,
        retailStoreInvestmentInvitationVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitationId, allTokens());
    if (retailStoreInvestmentInvitation.getVersion() != retailStoreInvestmentInvitationVersion) {
      String message =
          "The target version("
              + retailStoreInvestmentInvitation.getVersion()
              + ") is not equals to version("
              + retailStoreInvestmentInvitationVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreInvestmentInvitation) {
      // will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreInvestmentInvitation.

      retailStoreInvestmentInvitation.changeProperty(property, newValueExpr);

      retailStoreInvestmentInvitation =
          saveRetailStoreInvestmentInvitation(
              userContext, retailStoreInvestmentInvitation, tokens().done());
      return present(userContext, retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
      // return saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation,
      // tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected RetailStoreInvestmentInvitationTokens tokens() {
    return RetailStoreInvestmentInvitationTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return RetailStoreInvestmentInvitationTokens.all();
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
    return RetailStoreInvestmentInvitationTokens.mergeAll(tokens).done();
  }

  // --------------------------------------------------------------

  // --------------------------------------------------------------

  public RetailStoreInvestmentInvitation forgetByAll(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      int retailStoreInvestmentInvitationVersion)
      throws Exception {
    return forgetByAllInternal(
        userContext, retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion);
  }

  protected RetailStoreInvestmentInvitation forgetByAllInternal(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      int retailStoreInvestmentInvitationVersion)
      throws Exception {

    return retailStoreInvestmentInvitationDaoOf(userContext)
        .disconnectFromAll(
            retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new RetailStoreInvestmentInvitationManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      String name,
      String telephone,
      String owner,
      String retailStoreCountryCenterId,
      String cityServiceCenterId,
      String creationId,
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

    checkerOf(userContext)
        .checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);

    checkerOf(userContext).checkNameOfRetailStore(name);

    checkerOf(userContext).checkTelephoneOfRetailStore(telephone);

    checkerOf(userContext).checkOwnerOfRetailStore(owner);

    checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);

    checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);

    checkerOf(userContext).checkCreationIdOfRetailStore(creationId);

    checkerOf(userContext).checkFranchisingIdOfRetailStore(franchisingId);

    checkerOf(userContext).checkDecorationIdOfRetailStore(decorationId);

    checkerOf(userContext).checkOpeningIdOfRetailStore(openingId);

    checkerOf(userContext).checkClosingIdOfRetailStore(closingId);

    checkerOf(userContext).checkFoundedOfRetailStore(founded);

    checkerOf(userContext).checkLatitudeOfRetailStore(latitude);

    checkerOf(userContext).checkLongitudeOfRetailStore(longitude);

    checkerOf(userContext).checkDescriptionOfRetailStore(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
  }

  public RetailStoreInvestmentInvitation addRetailStore(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      String name,
      String telephone,
      String owner,
      String retailStoreCountryCenterId,
      String cityServiceCenterId,
      String creationId,
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
        retailStoreInvestmentInvitationId,
        name,
        telephone,
        owner,
        retailStoreCountryCenterId,
        cityServiceCenterId,
        creationId,
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
            creationId,
            franchisingId,
            decorationId,
            openingId,
            closingId,
            founded,
            latitude,
            longitude,
            description);

    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitationId, emptyOptions());
    synchronized (retailStoreInvestmentInvitation) {
      // Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreInvestmentInvitation.addRetailStore(retailStore);
      retailStoreInvestmentInvitation =
          saveRetailStoreInvestmentInvitation(
              userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());

      retailStoreManagerOf(userContext).onNewInstanceCreated(userContext, retailStore);
      return present(userContext, retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStoreProperties(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
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

    checkerOf(userContext)
        .checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
    checkerOf(userContext).checkIdOfRetailStore(id);

    checkerOf(userContext).checkNameOfRetailStore(name);
    checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
    checkerOf(userContext).checkOwnerOfRetailStore(owner);
    checkerOf(userContext).checkFoundedOfRetailStore(founded);
    checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
    checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
    checkerOf(userContext).checkDescriptionOfRetailStore(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
  }

  public RetailStoreInvestmentInvitation updateRetailStoreProperties(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
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
        retailStoreInvestmentInvitationId,
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

    RetailStoreInvestmentInvitation retailStoreInvestmentInvitationToUpdate =
        loadRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitationId, options);

    if (retailStoreInvestmentInvitationToUpdate.getRetailStoreList().isEmpty()) {
      throw new RetailStoreInvestmentInvitationManagerException(
          "RetailStore is NOT FOUND with id: '" + id + "'");
    }

    RetailStore item = retailStoreInvestmentInvitationToUpdate.getRetailStoreList().first();
    beforeUpdateRetailStoreProperties(
        userContext,
        item,
        retailStoreInvestmentInvitationId,
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

    // checkParamsForAddingRetailStore(userContext,retailStoreInvestmentInvitationId,name, code,
    // used,tokensExpr);
    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        saveRetailStoreInvestmentInvitation(
            userContext,
            retailStoreInvestmentInvitationToUpdate,
            tokens().withRetailStoreList().done());
    synchronized (retailStoreInvestmentInvitation) {
      return present(userContext, retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateRetailStoreProperties(
      RetailscmUserContext userContext,
      RetailStore item,
      String retailStoreInvestmentInvitationId,
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
    RetailStoreCreation creation = new RetailStoreCreation();
    creation.setId(creationId);
    retailStore.setCreation(creation);
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
      String retailStoreInvestmentInvitationId,
      String retailStoreIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
    for (String retailStoreIdItem : retailStoreIds) {
      checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
  }

  public RetailStoreInvestmentInvitation removeRetailStoreList(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      String retailStoreIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStoreList(
        userContext, retailStoreInvestmentInvitationId, retailStoreIds, tokensExpr);

    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitationId, allTokens());
    synchronized (retailStoreInvestmentInvitation) {
      // Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreInvestmentInvitationDaoOf(userContext)
          .planToRemoveRetailStoreList(
              retailStoreInvestmentInvitation, retailStoreIds, allTokens());
      retailStoreInvestmentInvitation =
          saveRetailStoreInvestmentInvitation(
              userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
      deleteRelationListInGraph(userContext, retailStoreInvestmentInvitation.getRetailStoreList());
      return present(userContext, retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
    checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
    checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
  }

  public RetailStoreInvestmentInvitation removeRetailStore(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStore(
        userContext,
        retailStoreInvestmentInvitationId,
        retailStoreId,
        retailStoreVersion,
        tokensExpr);

    RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitationId, allTokens());
    synchronized (retailStoreInvestmentInvitation) {
      // Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreInvestmentInvitation.removeRetailStore(retailStore);
      retailStoreInvestmentInvitation =
          saveRetailStoreInvestmentInvitation(
              userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
      deleteRelationInGraph(userContext, retailStore);
      return present(userContext, retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
    checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
    checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
  }

  public RetailStoreInvestmentInvitation copyRetailStoreFrom(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingRetailStore(
        userContext,
        retailStoreInvestmentInvitationId,
        retailStoreId,
        retailStoreVersion,
        tokensExpr);

    RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitationId, allTokens());
    synchronized (retailStoreInvestmentInvitation) {
      // Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      retailStore.updateLastUpdateTime(userContext.now());

      retailStoreInvestmentInvitation.copyRetailStoreFrom(retailStore);
      retailStoreInvestmentInvitation =
          saveRetailStoreInvestmentInvitation(
              userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());

      retailStoreManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (RetailStore)
                  retailStoreInvestmentInvitation
                      .getFlexiableObjects()
                      .get(BaseEntity.COPIED_CHILD));
      return present(userContext, retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext)
        .checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
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

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
  }

  public RetailStoreInvestmentInvitation updateRetailStore(
      RetailscmUserContext userContext,
      String retailStoreInvestmentInvitationId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingRetailStore(
        userContext,
        retailStoreInvestmentInvitationId,
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

    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        loadRetailStoreInvestmentInvitation(
            userContext, retailStoreInvestmentInvitationId, loadTokens);

    synchronized (retailStoreInvestmentInvitation) {
      // Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // retailStoreInvestmentInvitation.removeRetailStore( retailStore );
      // make changes to AcceleraterAccount.
      RetailStore retailStoreIdVersionKey =
          createIndexedRetailStore(retailStoreId, retailStoreVersion);

      RetailStore retailStore =
          retailStoreInvestmentInvitation.findTheRetailStore(retailStoreIdVersionKey);
      if (retailStore == null) {
        throw new RetailStoreInvestmentInvitationManagerException(retailStoreId + " is NOT FOUND");
      }

      beforeUpdateRetailStore(
          userContext,
          retailStore,
          retailStoreInvestmentInvitationId,
          retailStoreId,
          retailStoreVersion,
          property,
          newValueExpr,
          tokensExpr);
      retailStore.changeProperty(property, newValueExpr);
      retailStore.updateLastUpdateTime(userContext.now());
      retailStoreInvestmentInvitation =
          saveRetailStoreInvestmentInvitation(
              userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
      retailStoreManagerOf(userContext)
          .onUpdated(userContext, retailStore, this, "updateRetailStore");
      return present(userContext, retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateRetailStore(
      RetailscmUserContext userContext,
      RetailStore existed,
      String retailStoreInvestmentInvitationId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, RetailStoreInvestmentInvitation newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    retailStoreInvestmentInvitationDaoOf(ctx)
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
    //   RetailStoreInvestmentInvitation newRetailStoreInvestmentInvitation =
    // this.createRetailStoreInvestmentInvitation(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newRetailStoreInvestmentInvitation
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreInvestmentInvitation.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<RetailStoreInvestmentInvitation> list)
      throws Exception {
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
  public Object wxappview(
      RetailscmUserContext userContext, String retailStoreInvestmentInvitationId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    RetailStoreInvestmentInvitation merchantObj =
        (RetailStoreInvestmentInvitation) this.view(userContext, retailStoreInvestmentInvitationId);
    String merchantObjId = retailStoreInvestmentInvitationId;
    String linkToUrl = "retailStoreInvestmentInvitationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超招商" + "详情";
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
            "retailStoreManager/listByInvestmentInvitation/" + merchantObjId + "/",
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
