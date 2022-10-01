package com.doublechaintech.retailscm.retailstorecityservicecenter;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.cityevent.CityEvent;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.retailstoreprovincecenter.CandidateRetailStoreProvinceCenter;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
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

public class RetailStoreCityServiceCenterManagerImpl extends CustomRetailscmCheckerManager
    implements RetailStoreCityServiceCenterManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        RetailStoreCityServiceCenterTokens.start().withTokenFromListName(listName).done();
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        (RetailStoreCityServiceCenter)
            this.loadRetailStoreCityServiceCenter(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = retailStoreCityServiceCenter.collectReferencesFromLists();
    retailStoreCityServiceCenterDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, retailStoreCityServiceCenter, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new RetailStoreCityServiceCenterGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "RetailStoreCityServiceCenter";

  @Override
  public RetailStoreCityServiceCenterDAO daoOf(RetailscmUserContext userContext) {
    return retailStoreCityServiceCenterDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws RetailStoreCityServiceCenterManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new RetailStoreCityServiceCenterManagerException(message);
  }

  protected RetailStoreCityServiceCenter saveRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      RetailStoreCityServiceCenter retailStoreCityServiceCenter,
      String[] tokensExpr)
      throws Exception {
    // return getRetailStoreCityServiceCenterDAO().save(retailStoreCityServiceCenter, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, tokens);
  }

  protected RetailStoreCityServiceCenter saveRetailStoreCityServiceCenterDetail(
      RetailscmUserContext userContext, RetailStoreCityServiceCenter retailStoreCityServiceCenter)
      throws Exception {

    return saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, allTokens());
  }

  public RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(
      RetailscmUserContext userContext, String retailStoreCityServiceCenterId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreCityServiceCenter, tokens);
  }

  public RetailStoreCityServiceCenter searchRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreCityServiceCenter, tokens);
  }

  protected RetailStoreCityServiceCenter present(
      RetailscmUserContext userContext,
      RetailStoreCityServiceCenter retailStoreCityServiceCenter,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, retailStoreCityServiceCenter, tokens);

    RetailStoreCityServiceCenter retailStoreCityServiceCenterToPresent =
        retailStoreCityServiceCenterDaoOf(userContext)
            .present(retailStoreCityServiceCenter, tokens);

    List<BaseEntity> entityListToNaming =
        retailStoreCityServiceCenterToPresent.collectReferencesFromLists();
    retailStoreCityServiceCenterDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, retailStoreCityServiceCenter, tokens);

    return retailStoreCityServiceCenterToPresent;
  }

  public RetailStoreCityServiceCenter loadRetailStoreCityServiceCenterDetail(
      RetailscmUserContext userContext, String retailStoreCityServiceCenterId) throws Exception {
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    return present(userContext, retailStoreCityServiceCenter, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String retailStoreCityServiceCenterId)
      throws Exception {
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, viewTokens());
    markVisited(userContext, retailStoreCityServiceCenter);
    return present(userContext, retailStoreCityServiceCenter, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String retailStoreCityServiceCenterId)
      throws Exception {
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, viewTokens());
    retailStoreCityServiceCenter.summarySuffix();
    markVisited(userContext, retailStoreCityServiceCenter);
    return present(userContext, retailStoreCityServiceCenter, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String retailStoreCityServiceCenterId)
      throws Exception {
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(
            userContext, retailStoreCityServiceCenterId, analyzeTokens());
    markVisited(userContext, retailStoreCityServiceCenter);
    return present(userContext, retailStoreCityServiceCenter, analyzeTokens());
  }

  protected RetailStoreCityServiceCenter saveRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      RetailStoreCityServiceCenter retailStoreCityServiceCenter,
      Map<String, Object> tokens)
      throws Exception {

    return retailStoreCityServiceCenterDaoOf(userContext)
        .save(retailStoreCityServiceCenter, tokens);
  }

  protected RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);

    return retailStoreCityServiceCenterDaoOf(userContext)
        .load(retailStoreCityServiceCenterId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      RetailStoreCityServiceCenter retailStoreCityServiceCenter,
      Map<String, Object> tokens) {
    super.addActions(userContext, retailStoreCityServiceCenter, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String, Object>
    // tokens){

  @Override
  public List<RetailStoreCityServiceCenter> searchRetailStoreCityServiceCenterList(
      RetailscmUserContext ctx, RetailStoreCityServiceCenterRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<RetailStoreCityServiceCenter> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public RetailStoreCityServiceCenter searchRetailStoreCityServiceCenter(
      RetailscmUserContext ctx, RetailStoreCityServiceCenterRequest pRequest) {
    pRequest.limit(0, 1);
    List<RetailStoreCityServiceCenter> list = searchRetailStoreCityServiceCenterList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public RetailStoreCityServiceCenter createRetailStoreCityServiceCenter(
      RetailscmUserContext userContext, String name, Date founded, String belongsToId)
      throws Exception {

    checkerOf(userContext).checkNameOfRetailStoreCityServiceCenter(name);
    checkerOf(userContext).checkFoundedOfRetailStoreCityServiceCenter(founded);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        createNewRetailStoreCityServiceCenter();

    retailStoreCityServiceCenter.setName(name);
    retailStoreCityServiceCenter.setFounded(founded);

    RetailStoreProvinceCenter belongsTo =
        loadRetailStoreProvinceCenter(userContext, belongsToId, emptyOptions());
    retailStoreCityServiceCenter.setBelongsTo(belongsTo);

    retailStoreCityServiceCenter.setLastUpdateTime(userContext.now());

    retailStoreCityServiceCenter =
        saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, emptyOptions());

    onNewInstanceCreated(userContext, retailStoreCityServiceCenter);
    return retailStoreCityServiceCenter;
  }

  protected RetailStoreCityServiceCenter createNewRetailStoreCityServiceCenter() {

    return new RetailStoreCityServiceCenter();
  }

  protected void checkParamsForUpdatingRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      int retailStoreCityServiceCenterVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext)
        .checkVersionOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterVersion);

    if (RetailStoreCityServiceCenter.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfRetailStoreCityServiceCenter(parseString(newValueExpr));
    }
    if (RetailStoreCityServiceCenter.FOUNDED_PROPERTY.equals(property)) {

      checkerOf(userContext).checkFoundedOfRetailStoreCityServiceCenter(parseDate(newValueExpr));
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter clone(
      RetailscmUserContext userContext, String fromRetailStoreCityServiceCenterId)
      throws Exception {

    return retailStoreCityServiceCenterDaoOf(userContext)
        .clone(fromRetailStoreCityServiceCenterId, this.allTokens());
  }

  public RetailStoreCityServiceCenter internalSaveRetailStoreCityServiceCenter(
      RetailscmUserContext userContext, RetailStoreCityServiceCenter retailStoreCityServiceCenter)
      throws Exception {
    return internalSaveRetailStoreCityServiceCenter(
        userContext, retailStoreCityServiceCenter, allTokens());
  }

  public RetailStoreCityServiceCenter internalSaveRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      RetailStoreCityServiceCenter retailStoreCityServiceCenter,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingRetailStoreCityServiceCenter(userContext,
    // retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion, property, newValueExpr,
    // tokensExpr);

    synchronized (retailStoreCityServiceCenter) {
      // will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreCityServiceCenter.
      if (retailStoreCityServiceCenter.isChanged()) {
        retailStoreCityServiceCenter.updateLastUpdateTime(userContext.now());
      }

      // checkerOf(userContext).checkAndFixRetailStoreCityServiceCenter(retailStoreCityServiceCenter);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter, options);
      return retailStoreCityServiceCenter;
    }
  }

  public RetailStoreCityServiceCenter updateRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      int retailStoreCityServiceCenterVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreCityServiceCenter(
        userContext,
        retailStoreCityServiceCenterId,
        retailStoreCityServiceCenterVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    if (retailStoreCityServiceCenter.getVersion() != retailStoreCityServiceCenterVersion) {
      String message =
          "The target version("
              + retailStoreCityServiceCenter.getVersion()
              + ") is not equals to version("
              + retailStoreCityServiceCenterVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreCityServiceCenter) {
      // will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreCityServiceCenter.
      retailStoreCityServiceCenter.updateLastUpdateTime(userContext.now());
      retailStoreCityServiceCenter.changeProperty(property, newValueExpr);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().done());
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
      // return saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter,
      // tokens().done());
    }
  }

  public RetailStoreCityServiceCenter updateRetailStoreCityServiceCenterProperty(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      int retailStoreCityServiceCenterVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreCityServiceCenter(
        userContext,
        retailStoreCityServiceCenterId,
        retailStoreCityServiceCenterVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    if (retailStoreCityServiceCenter.getVersion() != retailStoreCityServiceCenterVersion) {
      String message =
          "The target version("
              + retailStoreCityServiceCenter.getVersion()
              + ") is not equals to version("
              + retailStoreCityServiceCenterVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreCityServiceCenter) {
      // will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreCityServiceCenter.

      retailStoreCityServiceCenter.changeProperty(property, newValueExpr);
      retailStoreCityServiceCenter.updateLastUpdateTime(userContext.now());
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().done());
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
      // return saveRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenter,
      // tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected RetailStoreCityServiceCenterTokens tokens() {
    return RetailStoreCityServiceCenterTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return RetailStoreCityServiceCenterTokens.all();
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
        .sortCityPartnerListWith(CityPartner.ID_PROPERTY, sortDesc())
        .sortPotentialCustomerListWith(PotentialCustomer.ID_PROPERTY, sortDesc())
        .sortCityEventListWith(CityEvent.ID_PROPERTY, sortDesc())
        .sortRetailStoreListWith(RetailStore.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return RetailStoreCityServiceCenterTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherBelongsTo(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String anotherBelongsToId)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext)
        .checkIdOfRetailStoreProvinceCenter(anotherBelongsToId); // check for optional reference

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter transferToAnotherBelongsTo(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String anotherBelongsToId)
      throws Exception {
    checkParamsForTransferingAnotherBelongsTo(
        userContext, retailStoreCityServiceCenterId, anotherBelongsToId);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreProvinceCenter belongsTo =
          loadRetailStoreProvinceCenter(userContext, anotherBelongsToId, emptyOptions());
      retailStoreCityServiceCenter.updateBelongsTo(belongsTo);
      retailStoreCityServiceCenter.updateLastUpdateTime(userContext.now());
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, emptyOptions());

      return present(userContext, retailStoreCityServiceCenter, allTokens());
    }
  }

  public CandidateRetailStoreProvinceCenter requestCandidateBelongsTo(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateRetailStoreProvinceCenter result = new CandidateRetailStoreProvinceCenter();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<RetailStoreProvinceCenter> candidateList =
        retailStoreProvinceCenterDaoOf(userContext)
            .requestCandidateRetailStoreProvinceCenterForRetailStoreCityServiceCenter(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(
      RetailscmUserContext userContext, String newBelongsToId, Map<String, Object> options)
      throws Exception {

    return retailStoreProvinceCenterDaoOf(userContext).load(newBelongsToId, options);
  }

  // --------------------------------------------------------------

  public RetailStoreCityServiceCenter forgetByAll(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      int retailStoreCityServiceCenterVersion)
      throws Exception {
    return forgetByAllInternal(
        userContext, retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
  }

  protected RetailStoreCityServiceCenter forgetByAllInternal(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      int retailStoreCityServiceCenterVersion)
      throws Exception {

    return retailStoreCityServiceCenterDaoOf(userContext)
        .disconnectFromAll(retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new RetailStoreCityServiceCenterManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingCityPartner(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);

    checkerOf(userContext).checkNameOfCityPartner(name);

    checkerOf(userContext).checkMobileOfCityPartner(mobile);

    checkerOf(userContext).checkDescriptionOfCityPartner(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter addCityPartner(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingCityPartner(
        userContext, retailStoreCityServiceCenterId, name, mobile, description, tokensExpr);

    CityPartner cityPartner = createCityPartner(userContext, name, mobile, description);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(
            userContext, retailStoreCityServiceCenterId, emptyOptions());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCityServiceCenter.addCityPartner(cityPartner);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withCityPartnerList().done());

      cityPartnerManagerOf(userContext).onNewInstanceCreated(userContext, cityPartner);
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingCityPartnerProperties(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String id,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfCityPartner(id);

    checkerOf(userContext).checkNameOfCityPartner(name);
    checkerOf(userContext).checkMobileOfCityPartner(mobile);
    checkerOf(userContext).checkDescriptionOfCityPartner(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter updateCityPartnerProperties(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String id,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingCityPartnerProperties(
        userContext, retailStoreCityServiceCenterId, id, name, mobile, description, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withCityPartnerListList()
            .searchCityPartnerListWith(CityPartner.ID_PROPERTY, tokens().is(), id)
            .done();

    RetailStoreCityServiceCenter retailStoreCityServiceCenterToUpdate =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, options);

    if (retailStoreCityServiceCenterToUpdate.getCityPartnerList().isEmpty()) {
      throw new RetailStoreCityServiceCenterManagerException(
          "CityPartner is NOT FOUND with id: '" + id + "'");
    }

    CityPartner item = retailStoreCityServiceCenterToUpdate.getCityPartnerList().first();
    beforeUpdateCityPartnerProperties(
        userContext,
        item,
        retailStoreCityServiceCenterId,
        id,
        name,
        mobile,
        description,
        tokensExpr);
    item.updateName(name);
    item.updateMobile(mobile);
    item.updateDescription(description);

    // checkParamsForAddingCityPartner(userContext,retailStoreCityServiceCenterId,name, code,
    // used,tokensExpr);
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        saveRetailStoreCityServiceCenter(
            userContext,
            retailStoreCityServiceCenterToUpdate,
            tokens().withCityPartnerList().done());
    synchronized (retailStoreCityServiceCenter) {
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateCityPartnerProperties(
      RetailscmUserContext userContext,
      CityPartner item,
      String retailStoreCityServiceCenterId,
      String id,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected CityPartner createCityPartner(
      RetailscmUserContext userContext, String name, String mobile, String description)
      throws Exception {

    CityPartner cityPartner = new CityPartner();

    cityPartner.setName(name);
    cityPartner.setMobile(mobile);
    cityPartner.setDescription(description);
    cityPartner.setLastUpdateTime(userContext.now());

    return cityPartner;
  }

  protected CityPartner createIndexedCityPartner(String id, int version) {

    CityPartner cityPartner = new CityPartner();
    cityPartner.setId(id);
    cityPartner.setVersion(version);
    return cityPartner;
  }

  protected void checkParamsForRemovingCityPartnerList(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityPartnerIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    for (String cityPartnerIdItem : cityPartnerIds) {
      checkerOf(userContext).checkIdOfCityPartner(cityPartnerIdItem);
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter removeCityPartnerList(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityPartnerIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingCityPartnerList(
        userContext, retailStoreCityServiceCenterId, cityPartnerIds, tokensExpr);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCityServiceCenterDaoOf(userContext)
          .planToRemoveCityPartnerList(retailStoreCityServiceCenter, cityPartnerIds, allTokens());
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withCityPartnerList().done());
      deleteRelationListInGraph(userContext, retailStoreCityServiceCenter.getCityPartnerList());
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingCityPartner(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityPartnerId,
      int cityPartnerVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
    checkerOf(userContext).checkVersionOfCityPartner(cityPartnerVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter removeCityPartner(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityPartnerId,
      int cityPartnerVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingCityPartner(
        userContext, retailStoreCityServiceCenterId, cityPartnerId, cityPartnerVersion, tokensExpr);

    CityPartner cityPartner = createIndexedCityPartner(cityPartnerId, cityPartnerVersion);
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCityServiceCenter.removeCityPartner(cityPartner);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withCityPartnerList().done());
      deleteRelationInGraph(userContext, cityPartner);
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingCityPartner(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityPartnerId,
      int cityPartnerVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
    checkerOf(userContext).checkVersionOfCityPartner(cityPartnerVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter copyCityPartnerFrom(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityPartnerId,
      int cityPartnerVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingCityPartner(
        userContext, retailStoreCityServiceCenterId, cityPartnerId, cityPartnerVersion, tokensExpr);

    CityPartner cityPartner = createIndexedCityPartner(cityPartnerId, cityPartnerVersion);
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      cityPartner.updateLastUpdateTime(userContext.now());

      retailStoreCityServiceCenter.copyCityPartnerFrom(cityPartner);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withCityPartnerList().done());

      cityPartnerManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (CityPartner)
                  retailStoreCityServiceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingCityPartner(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityPartnerId,
      int cityPartnerVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
    checkerOf(userContext).checkVersionOfCityPartner(cityPartnerVersion);

    if (CityPartner.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfCityPartner(parseString(newValueExpr));
    }

    if (CityPartner.MOBILE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkMobileOfCityPartner(parseString(newValueExpr));
    }

    if (CityPartner.DESCRIPTION_PROPERTY.equals(property)) {
      checkerOf(userContext).checkDescriptionOfCityPartner(parseString(newValueExpr));
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter updateCityPartner(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityPartnerId,
      int cityPartnerVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingCityPartner(
        userContext,
        retailStoreCityServiceCenterId,
        cityPartnerId,
        cityPartnerVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withCityPartnerList()
            .searchCityPartnerListWith(CityPartner.ID_PROPERTY, tokens().equals(), cityPartnerId)
            .done();

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, loadTokens);

    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // retailStoreCityServiceCenter.removeCityPartner( cityPartner );
      // make changes to AcceleraterAccount.
      CityPartner cityPartnerIdVersionKey =
          createIndexedCityPartner(cityPartnerId, cityPartnerVersion);

      CityPartner cityPartner =
          retailStoreCityServiceCenter.findTheCityPartner(cityPartnerIdVersionKey);
      if (cityPartner == null) {
        throw new RetailStoreCityServiceCenterManagerException(cityPartnerId + " is NOT FOUND");
      }

      beforeUpdateCityPartner(
          userContext,
          cityPartner,
          retailStoreCityServiceCenterId,
          cityPartnerId,
          cityPartnerVersion,
          property,
          newValueExpr,
          tokensExpr);
      cityPartner.changeProperty(property, newValueExpr);
      cityPartner.updateLastUpdateTime(userContext.now());
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withCityPartnerList().done());
      cityPartnerManagerOf(userContext)
          .onUpdated(userContext, cityPartner, this, "updateCityPartner");
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateCityPartner(
      RetailscmUserContext userContext,
      CityPartner existed,
      String retailStoreCityServiceCenterId,
      String cityPartnerId,
      int cityPartnerVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  protected void checkParamsForAddingPotentialCustomer(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String name,
      String mobile,
      String cityPartnerId,
      String description,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);

    checkerOf(userContext).checkNameOfPotentialCustomer(name);

    checkerOf(userContext).checkMobileOfPotentialCustomer(mobile);

    checkerOf(userContext).checkCityPartnerIdOfPotentialCustomer(cityPartnerId);

    checkerOf(userContext).checkDescriptionOfPotentialCustomer(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter addPotentialCustomer(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String name,
      String mobile,
      String cityPartnerId,
      String description,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingPotentialCustomer(
        userContext,
        retailStoreCityServiceCenterId,
        name,
        mobile,
        cityPartnerId,
        description,
        tokensExpr);

    PotentialCustomer potentialCustomer =
        createPotentialCustomer(userContext, name, mobile, cityPartnerId, description);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(
            userContext, retailStoreCityServiceCenterId, emptyOptions());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCityServiceCenter.addPotentialCustomer(potentialCustomer);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext,
              retailStoreCityServiceCenter,
              tokens().withPotentialCustomerList().done());

      potentialCustomerManagerOf(userContext).onNewInstanceCreated(userContext, potentialCustomer);
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingPotentialCustomerProperties(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String id,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfPotentialCustomer(id);

    checkerOf(userContext).checkNameOfPotentialCustomer(name);
    checkerOf(userContext).checkMobileOfPotentialCustomer(mobile);
    checkerOf(userContext).checkDescriptionOfPotentialCustomer(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter updatePotentialCustomerProperties(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String id,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPotentialCustomerProperties(
        userContext, retailStoreCityServiceCenterId, id, name, mobile, description, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withPotentialCustomerListList()
            .searchPotentialCustomerListWith(PotentialCustomer.ID_PROPERTY, tokens().is(), id)
            .done();

    RetailStoreCityServiceCenter retailStoreCityServiceCenterToUpdate =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, options);

    if (retailStoreCityServiceCenterToUpdate.getPotentialCustomerList().isEmpty()) {
      throw new RetailStoreCityServiceCenterManagerException(
          "PotentialCustomer is NOT FOUND with id: '" + id + "'");
    }

    PotentialCustomer item =
        retailStoreCityServiceCenterToUpdate.getPotentialCustomerList().first();
    beforeUpdatePotentialCustomerProperties(
        userContext,
        item,
        retailStoreCityServiceCenterId,
        id,
        name,
        mobile,
        description,
        tokensExpr);
    item.updateName(name);
    item.updateMobile(mobile);
    item.updateDescription(description);

    // checkParamsForAddingPotentialCustomer(userContext,retailStoreCityServiceCenterId,name, code,
    // used,tokensExpr);
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        saveRetailStoreCityServiceCenter(
            userContext,
            retailStoreCityServiceCenterToUpdate,
            tokens().withPotentialCustomerList().done());
    synchronized (retailStoreCityServiceCenter) {
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdatePotentialCustomerProperties(
      RetailscmUserContext userContext,
      PotentialCustomer item,
      String retailStoreCityServiceCenterId,
      String id,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected PotentialCustomer createPotentialCustomer(
      RetailscmUserContext userContext,
      String name,
      String mobile,
      String cityPartnerId,
      String description)
      throws Exception {

    PotentialCustomer potentialCustomer = new PotentialCustomer();

    potentialCustomer.setName(name);
    potentialCustomer.setMobile(mobile);
    CityPartner cityPartner = new CityPartner();
    cityPartner.setId(cityPartnerId);
    potentialCustomer.setCityPartner(cityPartner);
    potentialCustomer.setDescription(description);
    potentialCustomer.setLastUpdateTime(userContext.now());

    return potentialCustomer;
  }

  protected PotentialCustomer createIndexedPotentialCustomer(String id, int version) {

    PotentialCustomer potentialCustomer = new PotentialCustomer();
    potentialCustomer.setId(id);
    potentialCustomer.setVersion(version);
    return potentialCustomer;
  }

  protected void checkParamsForRemovingPotentialCustomerList(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String potentialCustomerIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    for (String potentialCustomerIdItem : potentialCustomerIds) {
      checkerOf(userContext).checkIdOfPotentialCustomer(potentialCustomerIdItem);
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter removePotentialCustomerList(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String potentialCustomerIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingPotentialCustomerList(
        userContext, retailStoreCityServiceCenterId, potentialCustomerIds, tokensExpr);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCityServiceCenterDaoOf(userContext)
          .planToRemovePotentialCustomerList(
              retailStoreCityServiceCenter, potentialCustomerIds, allTokens());
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext,
              retailStoreCityServiceCenter,
              tokens().withPotentialCustomerList().done());
      deleteRelationListInGraph(
          userContext, retailStoreCityServiceCenter.getPotentialCustomerList());
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingPotentialCustomer(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String potentialCustomerId,
      int potentialCustomerVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfPotentialCustomer(potentialCustomerId);
    checkerOf(userContext).checkVersionOfPotentialCustomer(potentialCustomerVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter removePotentialCustomer(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String potentialCustomerId,
      int potentialCustomerVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingPotentialCustomer(
        userContext,
        retailStoreCityServiceCenterId,
        potentialCustomerId,
        potentialCustomerVersion,
        tokensExpr);

    PotentialCustomer potentialCustomer =
        createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCityServiceCenter.removePotentialCustomer(potentialCustomer);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext,
              retailStoreCityServiceCenter,
              tokens().withPotentialCustomerList().done());
      deleteRelationInGraph(userContext, potentialCustomer);
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingPotentialCustomer(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String potentialCustomerId,
      int potentialCustomerVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfPotentialCustomer(potentialCustomerId);
    checkerOf(userContext).checkVersionOfPotentialCustomer(potentialCustomerVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter copyPotentialCustomerFrom(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String potentialCustomerId,
      int potentialCustomerVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingPotentialCustomer(
        userContext,
        retailStoreCityServiceCenterId,
        potentialCustomerId,
        potentialCustomerVersion,
        tokensExpr);

    PotentialCustomer potentialCustomer =
        createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      potentialCustomer.updateLastUpdateTime(userContext.now());

      retailStoreCityServiceCenter.copyPotentialCustomerFrom(potentialCustomer);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext,
              retailStoreCityServiceCenter,
              tokens().withPotentialCustomerList().done());

      potentialCustomerManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (PotentialCustomer)
                  retailStoreCityServiceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingPotentialCustomer(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String potentialCustomerId,
      int potentialCustomerVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfPotentialCustomer(potentialCustomerId);
    checkerOf(userContext).checkVersionOfPotentialCustomer(potentialCustomerVersion);

    if (PotentialCustomer.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfPotentialCustomer(parseString(newValueExpr));
    }

    if (PotentialCustomer.MOBILE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkMobileOfPotentialCustomer(parseString(newValueExpr));
    }

    if (PotentialCustomer.DESCRIPTION_PROPERTY.equals(property)) {
      checkerOf(userContext).checkDescriptionOfPotentialCustomer(parseString(newValueExpr));
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter updatePotentialCustomer(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String potentialCustomerId,
      int potentialCustomerVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingPotentialCustomer(
        userContext,
        retailStoreCityServiceCenterId,
        potentialCustomerId,
        potentialCustomerVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withPotentialCustomerList()
            .searchPotentialCustomerListWith(
                PotentialCustomer.ID_PROPERTY, tokens().equals(), potentialCustomerId)
            .done();

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, loadTokens);

    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // retailStoreCityServiceCenter.removePotentialCustomer( potentialCustomer );
      // make changes to AcceleraterAccount.
      PotentialCustomer potentialCustomerIdVersionKey =
          createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);

      PotentialCustomer potentialCustomer =
          retailStoreCityServiceCenter.findThePotentialCustomer(potentialCustomerIdVersionKey);
      if (potentialCustomer == null) {
        throw new RetailStoreCityServiceCenterManagerException(
            potentialCustomerId + " is NOT FOUND");
      }

      beforeUpdatePotentialCustomer(
          userContext,
          potentialCustomer,
          retailStoreCityServiceCenterId,
          potentialCustomerId,
          potentialCustomerVersion,
          property,
          newValueExpr,
          tokensExpr);
      potentialCustomer.changeProperty(property, newValueExpr);
      potentialCustomer.updateLastUpdateTime(userContext.now());
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext,
              retailStoreCityServiceCenter,
              tokens().withPotentialCustomerList().done());
      potentialCustomerManagerOf(userContext)
          .onUpdated(userContext, potentialCustomer, this, "updatePotentialCustomer");
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdatePotentialCustomer(
      RetailscmUserContext userContext,
      PotentialCustomer existed,
      String retailStoreCityServiceCenterId,
      String potentialCustomerId,
      int potentialCustomerVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  protected void checkParamsForAddingCityEvent(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);

    checkerOf(userContext).checkNameOfCityEvent(name);

    checkerOf(userContext).checkMobileOfCityEvent(mobile);

    checkerOf(userContext).checkDescriptionOfCityEvent(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter addCityEvent(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingCityEvent(
        userContext, retailStoreCityServiceCenterId, name, mobile, description, tokensExpr);

    CityEvent cityEvent = createCityEvent(userContext, name, mobile, description);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(
            userContext, retailStoreCityServiceCenterId, emptyOptions());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCityServiceCenter.addCityEvent(cityEvent);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withCityEventList().done());

      cityEventManagerOf(userContext).onNewInstanceCreated(userContext, cityEvent);
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingCityEventProperties(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String id,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfCityEvent(id);

    checkerOf(userContext).checkNameOfCityEvent(name);
    checkerOf(userContext).checkMobileOfCityEvent(mobile);
    checkerOf(userContext).checkDescriptionOfCityEvent(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter updateCityEventProperties(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String id,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingCityEventProperties(
        userContext, retailStoreCityServiceCenterId, id, name, mobile, description, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withCityEventListList()
            .searchCityEventListWith(CityEvent.ID_PROPERTY, tokens().is(), id)
            .done();

    RetailStoreCityServiceCenter retailStoreCityServiceCenterToUpdate =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, options);

    if (retailStoreCityServiceCenterToUpdate.getCityEventList().isEmpty()) {
      throw new RetailStoreCityServiceCenterManagerException(
          "CityEvent is NOT FOUND with id: '" + id + "'");
    }

    CityEvent item = retailStoreCityServiceCenterToUpdate.getCityEventList().first();
    beforeUpdateCityEventProperties(
        userContext,
        item,
        retailStoreCityServiceCenterId,
        id,
        name,
        mobile,
        description,
        tokensExpr);
    item.updateName(name);
    item.updateMobile(mobile);
    item.updateDescription(description);

    // checkParamsForAddingCityEvent(userContext,retailStoreCityServiceCenterId,name, code,
    // used,tokensExpr);
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        saveRetailStoreCityServiceCenter(
            userContext, retailStoreCityServiceCenterToUpdate, tokens().withCityEventList().done());
    synchronized (retailStoreCityServiceCenter) {
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateCityEventProperties(
      RetailscmUserContext userContext,
      CityEvent item,
      String retailStoreCityServiceCenterId,
      String id,
      String name,
      String mobile,
      String description,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected CityEvent createCityEvent(
      RetailscmUserContext userContext, String name, String mobile, String description)
      throws Exception {

    CityEvent cityEvent = new CityEvent();

    cityEvent.setName(name);
    cityEvent.setMobile(mobile);
    cityEvent.setDescription(description);
    cityEvent.setLastUpdateTime(userContext.now());

    return cityEvent;
  }

  protected CityEvent createIndexedCityEvent(String id, int version) {

    CityEvent cityEvent = new CityEvent();
    cityEvent.setId(id);
    cityEvent.setVersion(version);
    return cityEvent;
  }

  protected void checkParamsForRemovingCityEventList(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityEventIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    for (String cityEventIdItem : cityEventIds) {
      checkerOf(userContext).checkIdOfCityEvent(cityEventIdItem);
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter removeCityEventList(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityEventIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingCityEventList(
        userContext, retailStoreCityServiceCenterId, cityEventIds, tokensExpr);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCityServiceCenterDaoOf(userContext)
          .planToRemoveCityEventList(retailStoreCityServiceCenter, cityEventIds, allTokens());
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withCityEventList().done());
      deleteRelationListInGraph(userContext, retailStoreCityServiceCenter.getCityEventList());
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingCityEvent(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityEventId,
      int cityEventVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfCityEvent(cityEventId);
    checkerOf(userContext).checkVersionOfCityEvent(cityEventVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter removeCityEvent(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityEventId,
      int cityEventVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingCityEvent(
        userContext, retailStoreCityServiceCenterId, cityEventId, cityEventVersion, tokensExpr);

    CityEvent cityEvent = createIndexedCityEvent(cityEventId, cityEventVersion);
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCityServiceCenter.removeCityEvent(cityEvent);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withCityEventList().done());
      deleteRelationInGraph(userContext, cityEvent);
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingCityEvent(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityEventId,
      int cityEventVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfCityEvent(cityEventId);
    checkerOf(userContext).checkVersionOfCityEvent(cityEventVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter copyCityEventFrom(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityEventId,
      int cityEventVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingCityEvent(
        userContext, retailStoreCityServiceCenterId, cityEventId, cityEventVersion, tokensExpr);

    CityEvent cityEvent = createIndexedCityEvent(cityEventId, cityEventVersion);
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      cityEvent.updateLastUpdateTime(userContext.now());

      retailStoreCityServiceCenter.copyCityEventFrom(cityEvent);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withCityEventList().done());

      cityEventManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (CityEvent)
                  retailStoreCityServiceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingCityEvent(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityEventId,
      int cityEventVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfCityEvent(cityEventId);
    checkerOf(userContext).checkVersionOfCityEvent(cityEventVersion);

    if (CityEvent.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfCityEvent(parseString(newValueExpr));
    }

    if (CityEvent.MOBILE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkMobileOfCityEvent(parseString(newValueExpr));
    }

    if (CityEvent.DESCRIPTION_PROPERTY.equals(property)) {
      checkerOf(userContext).checkDescriptionOfCityEvent(parseString(newValueExpr));
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter updateCityEvent(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String cityEventId,
      int cityEventVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingCityEvent(
        userContext,
        retailStoreCityServiceCenterId,
        cityEventId,
        cityEventVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withCityEventList()
            .searchCityEventListWith(CityEvent.ID_PROPERTY, tokens().equals(), cityEventId)
            .done();

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, loadTokens);

    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // retailStoreCityServiceCenter.removeCityEvent( cityEvent );
      // make changes to AcceleraterAccount.
      CityEvent cityEventIdVersionKey = createIndexedCityEvent(cityEventId, cityEventVersion);

      CityEvent cityEvent = retailStoreCityServiceCenter.findTheCityEvent(cityEventIdVersionKey);
      if (cityEvent == null) {
        throw new RetailStoreCityServiceCenterManagerException(cityEventId + " is NOT FOUND");
      }

      beforeUpdateCityEvent(
          userContext,
          cityEvent,
          retailStoreCityServiceCenterId,
          cityEventId,
          cityEventVersion,
          property,
          newValueExpr,
          tokensExpr);
      cityEvent.changeProperty(property, newValueExpr);
      cityEvent.updateLastUpdateTime(userContext.now());
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withCityEventList().done());
      cityEventManagerOf(userContext).onUpdated(userContext, cityEvent, this, "updateCityEvent");
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateCityEvent(
      RetailscmUserContext userContext,
      CityEvent existed,
      String retailStoreCityServiceCenterId,
      String cityEventId,
      int cityEventVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  protected void checkParamsForAddingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String name,
      String telephone,
      String owner,
      String retailStoreCountryCenterId,
      String creationId,
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

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);

    checkerOf(userContext).checkNameOfRetailStore(name);

    checkerOf(userContext).checkTelephoneOfRetailStore(telephone);

    checkerOf(userContext).checkOwnerOfRetailStore(owner);

    checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);

    checkerOf(userContext).checkCreationIdOfRetailStore(creationId);

    checkerOf(userContext).checkInvestmentInvitationIdOfRetailStore(investmentInvitationId);

    checkerOf(userContext).checkFranchisingIdOfRetailStore(franchisingId);

    checkerOf(userContext).checkDecorationIdOfRetailStore(decorationId);

    checkerOf(userContext).checkOpeningIdOfRetailStore(openingId);

    checkerOf(userContext).checkClosingIdOfRetailStore(closingId);

    checkerOf(userContext).checkFoundedOfRetailStore(founded);

    checkerOf(userContext).checkLatitudeOfRetailStore(latitude);

    checkerOf(userContext).checkLongitudeOfRetailStore(longitude);

    checkerOf(userContext).checkDescriptionOfRetailStore(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter addRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String name,
      String telephone,
      String owner,
      String retailStoreCountryCenterId,
      String creationId,
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
        retailStoreCityServiceCenterId,
        name,
        telephone,
        owner,
        retailStoreCountryCenterId,
        creationId,
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
            creationId,
            investmentInvitationId,
            franchisingId,
            decorationId,
            openingId,
            closingId,
            founded,
            latitude,
            longitude,
            description);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(
            userContext, retailStoreCityServiceCenterId, emptyOptions());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCityServiceCenter.addRetailStore(retailStore);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withRetailStoreList().done());

      retailStoreManagerOf(userContext).onNewInstanceCreated(userContext, retailStore);
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStoreProperties(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
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

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfRetailStore(id);

    checkerOf(userContext).checkNameOfRetailStore(name);
    checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
    checkerOf(userContext).checkOwnerOfRetailStore(owner);
    checkerOf(userContext).checkFoundedOfRetailStore(founded);
    checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
    checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
    checkerOf(userContext).checkDescriptionOfRetailStore(description);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter updateRetailStoreProperties(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
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
        retailStoreCityServiceCenterId,
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

    RetailStoreCityServiceCenter retailStoreCityServiceCenterToUpdate =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, options);

    if (retailStoreCityServiceCenterToUpdate.getRetailStoreList().isEmpty()) {
      throw new RetailStoreCityServiceCenterManagerException(
          "RetailStore is NOT FOUND with id: '" + id + "'");
    }

    RetailStore item = retailStoreCityServiceCenterToUpdate.getRetailStoreList().first();
    beforeUpdateRetailStoreProperties(
        userContext,
        item,
        retailStoreCityServiceCenterId,
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

    // checkParamsForAddingRetailStore(userContext,retailStoreCityServiceCenterId,name, code,
    // used,tokensExpr);
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        saveRetailStoreCityServiceCenter(
            userContext,
            retailStoreCityServiceCenterToUpdate,
            tokens().withRetailStoreList().done());
    synchronized (retailStoreCityServiceCenter) {
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateRetailStoreProperties(
      RetailscmUserContext userContext,
      RetailStore item,
      String retailStoreCityServiceCenterId,
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
      String creationId,
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
    RetailStoreCreation creation = new RetailStoreCreation();
    creation.setId(creationId);
    retailStore.setCreation(creation);
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
      String retailStoreCityServiceCenterId,
      String retailStoreIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    for (String retailStoreIdItem : retailStoreIds) {
      checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter removeRetailStoreList(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String retailStoreIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStoreList(
        userContext, retailStoreCityServiceCenterId, retailStoreIds, tokensExpr);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCityServiceCenterDaoOf(userContext)
          .planToRemoveRetailStoreList(retailStoreCityServiceCenter, retailStoreIds, allTokens());
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withRetailStoreList().done());
      deleteRelationListInGraph(userContext, retailStoreCityServiceCenter.getRetailStoreList());
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
    checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter removeRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStore(
        userContext, retailStoreCityServiceCenterId, retailStoreId, retailStoreVersion, tokensExpr);

    RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreCityServiceCenter.removeRetailStore(retailStore);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withRetailStoreList().done());
      deleteRelationInGraph(userContext, retailStore);
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
    checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter copyRetailStoreFrom(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingRetailStore(
        userContext, retailStoreCityServiceCenterId, retailStoreId, retailStoreVersion, tokensExpr);

    RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, allTokens());
    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      retailStore.updateLastUpdateTime(userContext.now());

      retailStoreCityServiceCenter.copyRetailStoreFrom(retailStore);
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withRetailStoreList().done());

      retailStoreManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (RetailStore)
                  retailStoreCityServiceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
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
        .throwExceptionIfHasErrors(RetailStoreCityServiceCenterManagerException.class);
  }

  public RetailStoreCityServiceCenter updateRetailStore(
      RetailscmUserContext userContext,
      String retailStoreCityServiceCenterId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingRetailStore(
        userContext,
        retailStoreCityServiceCenterId,
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

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        loadRetailStoreCityServiceCenter(userContext, retailStoreCityServiceCenterId, loadTokens);

    synchronized (retailStoreCityServiceCenter) {
      // Will be good when the retailStoreCityServiceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // retailStoreCityServiceCenter.removeRetailStore( retailStore );
      // make changes to AcceleraterAccount.
      RetailStore retailStoreIdVersionKey =
          createIndexedRetailStore(retailStoreId, retailStoreVersion);

      RetailStore retailStore =
          retailStoreCityServiceCenter.findTheRetailStore(retailStoreIdVersionKey);
      if (retailStore == null) {
        throw new RetailStoreCityServiceCenterManagerException(retailStoreId + " is NOT FOUND");
      }

      beforeUpdateRetailStore(
          userContext,
          retailStore,
          retailStoreCityServiceCenterId,
          retailStoreId,
          retailStoreVersion,
          property,
          newValueExpr,
          tokensExpr);
      retailStore.changeProperty(property, newValueExpr);
      retailStore.updateLastUpdateTime(userContext.now());
      retailStoreCityServiceCenter =
          saveRetailStoreCityServiceCenter(
              userContext, retailStoreCityServiceCenter, tokens().withRetailStoreList().done());
      retailStoreManagerOf(userContext)
          .onUpdated(userContext, retailStore, this, "updateRetailStore");
      return present(userContext, retailStoreCityServiceCenter, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateRetailStore(
      RetailscmUserContext userContext,
      RetailStore existed,
      String retailStoreCityServiceCenterId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, RetailStoreCityServiceCenter newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    retailStoreCityServiceCenterDaoOf(ctx)
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
    //   RetailStoreCityServiceCenter newRetailStoreCityServiceCenter =
    // this.createRetailStoreCityServiceCenter(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newRetailStoreCityServiceCenter
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreCityServiceCenter.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<RetailStoreCityServiceCenter> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<RetailStoreProvinceCenter> belongsToList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, RetailStoreProvinceCenter.class);
    userContext.getDAOGroup().enhanceList(belongsToList, RetailStoreProvinceCenter.class);
  }

  public Object listByBelongsTo(RetailscmUserContext userContext, String belongsToId)
      throws Exception {
    return listPageByBelongsTo(userContext, belongsToId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByBelongsTo(
      RetailscmUserContext userContext, String belongsToId, int start, int count) throws Exception {
    SmartList<RetailStoreCityServiceCenter> list =
        retailStoreCityServiceCenterDaoOf(userContext)
            .findRetailStoreCityServiceCenterByBelongsTo(
                belongsToId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(RetailStoreCityServiceCenter.class);
    page.setContainerObject(RetailStoreProvinceCenter.withId(belongsToId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("双链小超城市服务中心列表");
    page.setRequestName("listByBelongsTo");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByBelongsTo/%s/", getBeanName(), belongsToId)));

    page.assemblerContent(userContext, "listByBelongsTo");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String retailStoreCityServiceCenterId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    RetailStoreCityServiceCenter merchantObj =
        (RetailStoreCityServiceCenter) this.view(userContext, retailStoreCityServiceCenterId);
    String merchantObjId = retailStoreCityServiceCenterId;
    String linkToUrl = "retailStoreCityServiceCenterManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "双链小超城市服务中心" + "详情";
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
        MapUtil.put("id", "3-founded")
            .put("fieldName", "founded")
            .put("label", "成立")
            .put("type", "date")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("founded", merchantObj.getFounded());

    propList.add(
        MapUtil.put("id", "4-belongsTo")
            .put("fieldName", "belongsTo")
            .put("label", "属于")
            .put("type", "auto")
            .put("linkToUrl", "retailStoreProvinceCenterManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("belongsTo", merchantObj.getBelongsTo());

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

    // 处理Section：cityPartnerListSection
    Map cityPartnerListSection =
        ListofUtils.buildSection(
            "cityPartnerListSection",
            "城市的合作伙伴名单",
            null,
            "",
            "__no_group",
            "cityPartnerManager/listByCityServiceCenter/" + merchantObjId + "/",
            "auto");
    sections.add(cityPartnerListSection);

    result.put(
        "cityPartnerListSection",
        ListofUtils.toShortList(merchantObj.getCityPartnerList(), "cityPartner"));

    // 处理Section：potentialCustomerListSection
    Map potentialCustomerListSection =
        ListofUtils.buildSection(
            "potentialCustomerListSection",
            "潜在客户列表",
            null,
            "",
            "__no_group",
            "potentialCustomerManager/listByCityServiceCenter/" + merchantObjId + "/",
            "auto");
    sections.add(potentialCustomerListSection);

    result.put(
        "potentialCustomerListSection",
        ListofUtils.toShortList(merchantObj.getPotentialCustomerList(), "potentialCustomer"));

    // 处理Section：cityEventListSection
    Map cityEventListSection =
        ListofUtils.buildSection(
            "cityEventListSection",
            "城市事件列表",
            null,
            "",
            "__no_group",
            "cityEventManager/listByCityServiceCenter/" + merchantObjId + "/",
            "auto");
    sections.add(cityEventListSection);

    result.put(
        "cityEventListSection",
        ListofUtils.toShortList(merchantObj.getCityEventList(), "cityEvent"));

    // 处理Section：retailStoreListSection
    Map retailStoreListSection =
        ListofUtils.buildSection(
            "retailStoreListSection",
            "零售门店列表",
            null,
            "",
            "__no_group",
            "retailStoreManager/listByCityServiceCenter/" + merchantObjId + "/",
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
