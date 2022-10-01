package com.doublechaintech.retailscm.retailstorefranchising;

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

public class RetailStoreFranchisingManagerImpl extends CustomRetailscmCheckerManager
    implements RetailStoreFranchisingManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        RetailStoreFranchisingTokens.start().withTokenFromListName(listName).done();
    RetailStoreFranchising retailStoreFranchising =
        (RetailStoreFranchising) this.loadRetailStoreFranchising(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = retailStoreFranchising.collectReferencesFromLists();
    retailStoreFranchisingDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, retailStoreFranchising, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new RetailStoreFranchisingGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "RetailStoreFranchising";

  @Override
  public RetailStoreFranchisingDAO daoOf(RetailscmUserContext userContext) {
    return retailStoreFranchisingDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws RetailStoreFranchisingManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new RetailStoreFranchisingManagerException(message);
  }

  protected RetailStoreFranchising saveRetailStoreFranchising(
      RetailscmUserContext userContext,
      RetailStoreFranchising retailStoreFranchising,
      String[] tokensExpr)
      throws Exception {
    // return getRetailStoreFranchisingDAO().save(retailStoreFranchising, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens);
  }

  protected RetailStoreFranchising saveRetailStoreFranchisingDetail(
      RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising)
      throws Exception {

    return saveRetailStoreFranchising(userContext, retailStoreFranchising, allTokens());
  }

  public RetailStoreFranchising loadRetailStoreFranchising(
      RetailscmUserContext userContext, String retailStoreFranchisingId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreFranchising, tokens);
  }

  public RetailStoreFranchising searchRetailStoreFranchising(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreFranchising, tokens);
  }

  protected RetailStoreFranchising present(
      RetailscmUserContext userContext,
      RetailStoreFranchising retailStoreFranchising,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, retailStoreFranchising, tokens);

    RetailStoreFranchising retailStoreFranchisingToPresent =
        retailStoreFranchisingDaoOf(userContext).present(retailStoreFranchising, tokens);

    List<BaseEntity> entityListToNaming =
        retailStoreFranchisingToPresent.collectReferencesFromLists();
    retailStoreFranchisingDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, retailStoreFranchising, tokens);

    return retailStoreFranchisingToPresent;
  }

  public RetailStoreFranchising loadRetailStoreFranchisingDetail(
      RetailscmUserContext userContext, String retailStoreFranchisingId) throws Exception {
    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
    return present(userContext, retailStoreFranchising, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String retailStoreFranchisingId)
      throws Exception {
    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, viewTokens());
    markVisited(userContext, retailStoreFranchising);
    return present(userContext, retailStoreFranchising, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String retailStoreFranchisingId)
      throws Exception {
    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, viewTokens());
    retailStoreFranchising.summarySuffix();
    markVisited(userContext, retailStoreFranchising);
    return present(userContext, retailStoreFranchising, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String retailStoreFranchisingId)
      throws Exception {
    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, analyzeTokens());
    markVisited(userContext, retailStoreFranchising);
    return present(userContext, retailStoreFranchising, analyzeTokens());
  }

  protected RetailStoreFranchising saveRetailStoreFranchising(
      RetailscmUserContext userContext,
      RetailStoreFranchising retailStoreFranchising,
      Map<String, Object> tokens)
      throws Exception {

    return retailStoreFranchisingDaoOf(userContext).save(retailStoreFranchising, tokens);
  }

  protected RetailStoreFranchising loadRetailStoreFranchising(
      RetailscmUserContext userContext, String retailStoreFranchisingId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);

    return retailStoreFranchisingDaoOf(userContext).load(retailStoreFranchisingId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      RetailStoreFranchising retailStoreFranchising,
      Map<String, Object> tokens) {
    super.addActions(userContext, retailStoreFranchising, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, RetailStoreFranchising retailStoreFranchising, Map<String, Object> tokens){

  @Override
  public List<RetailStoreFranchising> searchRetailStoreFranchisingList(
      RetailscmUserContext ctx, RetailStoreFranchisingRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<RetailStoreFranchising> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public RetailStoreFranchising searchRetailStoreFranchising(
      RetailscmUserContext ctx, RetailStoreFranchisingRequest pRequest) {
    pRequest.limit(0, 1);
    List<RetailStoreFranchising> list = searchRetailStoreFranchisingList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public RetailStoreFranchising createRetailStoreFranchising(
      RetailscmUserContext userContext, String comment) throws Exception {

    checkerOf(userContext).checkCommentOfRetailStoreFranchising(comment);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);

    RetailStoreFranchising retailStoreFranchising = createNewRetailStoreFranchising();

    retailStoreFranchising.setComment(comment);

    retailStoreFranchising =
        saveRetailStoreFranchising(userContext, retailStoreFranchising, emptyOptions());

    onNewInstanceCreated(userContext, retailStoreFranchising);
    return retailStoreFranchising;
  }

  protected RetailStoreFranchising createNewRetailStoreFranchising() {

    return new RetailStoreFranchising();
  }

  protected void checkParamsForUpdatingRetailStoreFranchising(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      int retailStoreFranchisingVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
    checkerOf(userContext).checkVersionOfRetailStoreFranchising(retailStoreFranchisingVersion);

    if (RetailStoreFranchising.COMMENT_PROPERTY.equals(property)) {

      checkerOf(userContext).checkCommentOfRetailStoreFranchising(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
  }

  public RetailStoreFranchising clone(
      RetailscmUserContext userContext, String fromRetailStoreFranchisingId) throws Exception {

    return retailStoreFranchisingDaoOf(userContext)
        .clone(fromRetailStoreFranchisingId, this.allTokens());
  }

  public RetailStoreFranchising internalSaveRetailStoreFranchising(
      RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising)
      throws Exception {
    return internalSaveRetailStoreFranchising(userContext, retailStoreFranchising, allTokens());
  }

  public RetailStoreFranchising internalSaveRetailStoreFranchising(
      RetailscmUserContext userContext,
      RetailStoreFranchising retailStoreFranchising,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingRetailStoreFranchising(userContext, retailStoreFranchisingId,
    // retailStoreFranchisingVersion, property, newValueExpr, tokensExpr);

    synchronized (retailStoreFranchising) {
      // will be good when the retailStoreFranchising loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreFranchising.
      if (retailStoreFranchising.isChanged()) {}

      // checkerOf(userContext).checkAndFixRetailStoreFranchising(retailStoreFranchising);
      retailStoreFranchising =
          saveRetailStoreFranchising(userContext, retailStoreFranchising, options);
      return retailStoreFranchising;
    }
  }

  public RetailStoreFranchising updateRetailStoreFranchising(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      int retailStoreFranchisingVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreFranchising(
        userContext,
        retailStoreFranchisingId,
        retailStoreFranchisingVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
    if (retailStoreFranchising.getVersion() != retailStoreFranchisingVersion) {
      String message =
          "The target version("
              + retailStoreFranchising.getVersion()
              + ") is not equals to version("
              + retailStoreFranchisingVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreFranchising) {
      // will be good when the retailStoreFranchising loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreFranchising.

      retailStoreFranchising.changeProperty(property, newValueExpr);
      retailStoreFranchising =
          saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
      return present(userContext, retailStoreFranchising, mergedAllTokens(tokensExpr));
      // return saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
    }
  }

  public RetailStoreFranchising updateRetailStoreFranchisingProperty(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      int retailStoreFranchisingVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreFranchising(
        userContext,
        retailStoreFranchisingId,
        retailStoreFranchisingVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
    if (retailStoreFranchising.getVersion() != retailStoreFranchisingVersion) {
      String message =
          "The target version("
              + retailStoreFranchising.getVersion()
              + ") is not equals to version("
              + retailStoreFranchisingVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreFranchising) {
      // will be good when the retailStoreFranchising loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreFranchising.

      retailStoreFranchising.changeProperty(property, newValueExpr);

      retailStoreFranchising =
          saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
      return present(userContext, retailStoreFranchising, mergedAllTokens(tokensExpr));
      // return saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected RetailStoreFranchisingTokens tokens() {
    return RetailStoreFranchisingTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return RetailStoreFranchisingTokens.all();
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
    return RetailStoreFranchisingTokens.mergeAll(tokens).done();
  }

  // --------------------------------------------------------------

  // --------------------------------------------------------------

  public RetailStoreFranchising forgetByAll(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      int retailStoreFranchisingVersion)
      throws Exception {
    return forgetByAllInternal(
        userContext, retailStoreFranchisingId, retailStoreFranchisingVersion);
  }

  protected RetailStoreFranchising forgetByAllInternal(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      int retailStoreFranchisingVersion)
      throws Exception {

    return retailStoreFranchisingDaoOf(userContext)
        .disconnectFromAll(retailStoreFranchisingId, retailStoreFranchisingVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new RetailStoreFranchisingManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      String name,
      String telephone,
      String owner,
      String retailStoreCountryCenterId,
      String cityServiceCenterId,
      String creationId,
      String investmentInvitationId,
      String decorationId,
      String openingId,
      String closingId,
      Date founded,
      BigDecimal latitude,
      BigDecimal longitude,
      String description,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);

    checkerOf(userContext).checkNameOfRetailStore(name);

    checkerOf(userContext).checkTelephoneOfRetailStore(telephone);

    checkerOf(userContext).checkOwnerOfRetailStore(owner);

    checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);

    checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);

    checkerOf(userContext).checkCreationIdOfRetailStore(creationId);

    checkerOf(userContext).checkInvestmentInvitationIdOfRetailStore(investmentInvitationId);

    checkerOf(userContext).checkDecorationIdOfRetailStore(decorationId);

    checkerOf(userContext).checkOpeningIdOfRetailStore(openingId);

    checkerOf(userContext).checkClosingIdOfRetailStore(closingId);

    checkerOf(userContext).checkFoundedOfRetailStore(founded);

    checkerOf(userContext).checkLatitudeOfRetailStore(latitude);

    checkerOf(userContext).checkLongitudeOfRetailStore(longitude);

    checkerOf(userContext).checkDescriptionOfRetailStore(description);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
  }

  public RetailStoreFranchising addRetailStore(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      String name,
      String telephone,
      String owner,
      String retailStoreCountryCenterId,
      String cityServiceCenterId,
      String creationId,
      String investmentInvitationId,
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
        retailStoreFranchisingId,
        name,
        telephone,
        owner,
        retailStoreCountryCenterId,
        cityServiceCenterId,
        creationId,
        investmentInvitationId,
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
            investmentInvitationId,
            decorationId,
            openingId,
            closingId,
            founded,
            latitude,
            longitude,
            description);

    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, emptyOptions());
    synchronized (retailStoreFranchising) {
      // Will be good when the retailStoreFranchising loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreFranchising.addRetailStore(retailStore);
      retailStoreFranchising =
          saveRetailStoreFranchising(
              userContext, retailStoreFranchising, tokens().withRetailStoreList().done());

      retailStoreManagerOf(userContext).onNewInstanceCreated(userContext, retailStore);
      return present(userContext, retailStoreFranchising, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStoreProperties(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
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

    checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
    checkerOf(userContext).checkIdOfRetailStore(id);

    checkerOf(userContext).checkNameOfRetailStore(name);
    checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
    checkerOf(userContext).checkOwnerOfRetailStore(owner);
    checkerOf(userContext).checkFoundedOfRetailStore(founded);
    checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
    checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
    checkerOf(userContext).checkDescriptionOfRetailStore(description);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
  }

  public RetailStoreFranchising updateRetailStoreProperties(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
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
        retailStoreFranchisingId,
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

    RetailStoreFranchising retailStoreFranchisingToUpdate =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);

    if (retailStoreFranchisingToUpdate.getRetailStoreList().isEmpty()) {
      throw new RetailStoreFranchisingManagerException(
          "RetailStore is NOT FOUND with id: '" + id + "'");
    }

    RetailStore item = retailStoreFranchisingToUpdate.getRetailStoreList().first();
    beforeUpdateRetailStoreProperties(
        userContext,
        item,
        retailStoreFranchisingId,
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

    // checkParamsForAddingRetailStore(userContext,retailStoreFranchisingId,name, code,
    // used,tokensExpr);
    RetailStoreFranchising retailStoreFranchising =
        saveRetailStoreFranchising(
            userContext, retailStoreFranchisingToUpdate, tokens().withRetailStoreList().done());
    synchronized (retailStoreFranchising) {
      return present(userContext, retailStoreFranchising, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateRetailStoreProperties(
      RetailscmUserContext userContext,
      RetailStore item,
      String retailStoreFranchisingId,
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
    RetailStoreInvestmentInvitation investmentInvitation = new RetailStoreInvestmentInvitation();
    investmentInvitation.setId(investmentInvitationId);
    retailStore.setInvestmentInvitation(investmentInvitation);
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
      String retailStoreFranchisingId,
      String retailStoreIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
    for (String retailStoreIdItem : retailStoreIds) {
      checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
  }

  public RetailStoreFranchising removeRetailStoreList(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      String retailStoreIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStoreList(
        userContext, retailStoreFranchisingId, retailStoreIds, tokensExpr);

    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
    synchronized (retailStoreFranchising) {
      // Will be good when the retailStoreFranchising loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreFranchisingDaoOf(userContext)
          .planToRemoveRetailStoreList(retailStoreFranchising, retailStoreIds, allTokens());
      retailStoreFranchising =
          saveRetailStoreFranchising(
              userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
      deleteRelationListInGraph(userContext, retailStoreFranchising.getRetailStoreList());
      return present(userContext, retailStoreFranchising, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
    checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
    checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
  }

  public RetailStoreFranchising removeRetailStore(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStore(
        userContext, retailStoreFranchisingId, retailStoreId, retailStoreVersion, tokensExpr);

    RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
    synchronized (retailStoreFranchising) {
      // Will be good when the retailStoreFranchising loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreFranchising.removeRetailStore(retailStore);
      retailStoreFranchising =
          saveRetailStoreFranchising(
              userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
      deleteRelationInGraph(userContext, retailStore);
      return present(userContext, retailStoreFranchising, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
    checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
    checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
  }

  public RetailStoreFranchising copyRetailStoreFrom(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingRetailStore(
        userContext, retailStoreFranchisingId, retailStoreId, retailStoreVersion, tokensExpr);

    RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
    synchronized (retailStoreFranchising) {
      // Will be good when the retailStoreFranchising loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      retailStore.updateLastUpdateTime(userContext.now());

      retailStoreFranchising.copyRetailStoreFrom(retailStore);
      retailStoreFranchising =
          saveRetailStoreFranchising(
              userContext, retailStoreFranchising, tokens().withRetailStoreList().done());

      retailStoreManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (RetailStore)
                  retailStoreFranchising.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, retailStoreFranchising, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
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

    checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
  }

  public RetailStoreFranchising updateRetailStore(
      RetailscmUserContext userContext,
      String retailStoreFranchisingId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingRetailStore(
        userContext,
        retailStoreFranchisingId,
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

    RetailStoreFranchising retailStoreFranchising =
        loadRetailStoreFranchising(userContext, retailStoreFranchisingId, loadTokens);

    synchronized (retailStoreFranchising) {
      // Will be good when the retailStoreFranchising loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // retailStoreFranchising.removeRetailStore( retailStore );
      // make changes to AcceleraterAccount.
      RetailStore retailStoreIdVersionKey =
          createIndexedRetailStore(retailStoreId, retailStoreVersion);

      RetailStore retailStore = retailStoreFranchising.findTheRetailStore(retailStoreIdVersionKey);
      if (retailStore == null) {
        throw new RetailStoreFranchisingManagerException(retailStoreId + " is NOT FOUND");
      }

      beforeUpdateRetailStore(
          userContext,
          retailStore,
          retailStoreFranchisingId,
          retailStoreId,
          retailStoreVersion,
          property,
          newValueExpr,
          tokensExpr);
      retailStore.changeProperty(property, newValueExpr);
      retailStore.updateLastUpdateTime(userContext.now());
      retailStoreFranchising =
          saveRetailStoreFranchising(
              userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
      retailStoreManagerOf(userContext)
          .onUpdated(userContext, retailStore, this, "updateRetailStore");
      return present(userContext, retailStoreFranchising, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateRetailStore(
      RetailscmUserContext userContext,
      RetailStore existed,
      String retailStoreFranchisingId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, RetailStoreFranchising newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    retailStoreFranchisingDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   RetailStoreFranchising newRetailStoreFranchising =
    // this.createRetailStoreFranchising(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newRetailStoreFranchising
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreFranchising.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<RetailStoreFranchising> list) throws Exception {
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
  public Object wxappview(RetailscmUserContext userContext, String retailStoreFranchisingId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    RetailStoreFranchising merchantObj =
        (RetailStoreFranchising) this.view(userContext, retailStoreFranchisingId);
    String merchantObjId = retailStoreFranchisingId;
    String linkToUrl = "retailStoreFranchisingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超的特许经营" + "详情";
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
            "retailStoreManager/listByFranchising/" + merchantObjId + "/",
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
