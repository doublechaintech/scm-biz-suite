package com.doublechaintech.retailscm.retailstoreprovincecenter;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
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

public class RetailStoreProvinceCenterManagerImpl extends CustomRetailscmCheckerManager
    implements RetailStoreProvinceCenterManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        RetailStoreProvinceCenterTokens.start().withTokenFromListName(listName).done();
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        (RetailStoreProvinceCenter) this.loadRetailStoreProvinceCenter(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = retailStoreProvinceCenter.collectReferencesFromLists();
    retailStoreProvinceCenterDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, retailStoreProvinceCenter, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new RetailStoreProvinceCenterGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "RetailStoreProvinceCenter";

  @Override
  public RetailStoreProvinceCenterDAO daoOf(RetailscmUserContext userContext) {
    return retailStoreProvinceCenterDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws RetailStoreProvinceCenterManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new RetailStoreProvinceCenterManagerException(message);
  }

  protected RetailStoreProvinceCenter saveRetailStoreProvinceCenter(
      RetailscmUserContext userContext,
      RetailStoreProvinceCenter retailStoreProvinceCenter,
      String[] tokensExpr)
      throws Exception {
    // return getRetailStoreProvinceCenterDAO().save(retailStoreProvinceCenter, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens);
  }

  protected RetailStoreProvinceCenter saveRetailStoreProvinceCenterDetail(
      RetailscmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter)
      throws Exception {

    return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, allTokens());
  }

  public RetailStoreProvinceCenter loadRetailStoreProvinceCenter(
      RetailscmUserContext userContext, String retailStoreProvinceCenterId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreProvinceCenter, tokens);
  }

  public RetailStoreProvinceCenter searchRetailStoreProvinceCenter(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreProvinceCenter, tokens);
  }

  protected RetailStoreProvinceCenter present(
      RetailscmUserContext userContext,
      RetailStoreProvinceCenter retailStoreProvinceCenter,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, retailStoreProvinceCenter, tokens);

    RetailStoreProvinceCenter retailStoreProvinceCenterToPresent =
        retailStoreProvinceCenterDaoOf(userContext).present(retailStoreProvinceCenter, tokens);

    List<BaseEntity> entityListToNaming =
        retailStoreProvinceCenterToPresent.collectReferencesFromLists();
    retailStoreProvinceCenterDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, retailStoreProvinceCenter, tokens);

    return retailStoreProvinceCenterToPresent;
  }

  public RetailStoreProvinceCenter loadRetailStoreProvinceCenterDetail(
      RetailscmUserContext userContext, String retailStoreProvinceCenterId) throws Exception {
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    return present(userContext, retailStoreProvinceCenter, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String retailStoreProvinceCenterId)
      throws Exception {
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, viewTokens());
    markVisited(userContext, retailStoreProvinceCenter);
    return present(userContext, retailStoreProvinceCenter, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String retailStoreProvinceCenterId)
      throws Exception {
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, viewTokens());
    retailStoreProvinceCenter.summarySuffix();
    markVisited(userContext, retailStoreProvinceCenter);
    return present(userContext, retailStoreProvinceCenter, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String retailStoreProvinceCenterId)
      throws Exception {
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, analyzeTokens());
    markVisited(userContext, retailStoreProvinceCenter);
    return present(userContext, retailStoreProvinceCenter, analyzeTokens());
  }

  protected RetailStoreProvinceCenter saveRetailStoreProvinceCenter(
      RetailscmUserContext userContext,
      RetailStoreProvinceCenter retailStoreProvinceCenter,
      Map<String, Object> tokens)
      throws Exception {

    return retailStoreProvinceCenterDaoOf(userContext).save(retailStoreProvinceCenter, tokens);
  }

  protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

    return retailStoreProvinceCenterDaoOf(userContext).load(retailStoreProvinceCenterId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      RetailStoreProvinceCenter retailStoreProvinceCenter,
      Map<String, Object> tokens) {
    super.addActions(userContext, retailStoreProvinceCenter, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String, Object>
    // tokens){

  @Override
  public List<RetailStoreProvinceCenter> searchRetailStoreProvinceCenterList(
      RetailscmUserContext ctx, RetailStoreProvinceCenterRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<RetailStoreProvinceCenter> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public RetailStoreProvinceCenter searchRetailStoreProvinceCenter(
      RetailscmUserContext ctx, RetailStoreProvinceCenterRequest pRequest) {
    pRequest.limit(0, 1);
    List<RetailStoreProvinceCenter> list = searchRetailStoreProvinceCenterList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public RetailStoreProvinceCenter createRetailStoreProvinceCenter(
      RetailscmUserContext userContext, String name, Date founded, String countryId)
      throws Exception {

    checkerOf(userContext).checkNameOfRetailStoreProvinceCenter(name);
    checkerOf(userContext).checkFoundedOfRetailStoreProvinceCenter(founded);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);

    RetailStoreProvinceCenter retailStoreProvinceCenter = createNewRetailStoreProvinceCenter();

    retailStoreProvinceCenter.setName(name);
    retailStoreProvinceCenter.setFounded(founded);

    RetailStoreCountryCenter country =
        loadRetailStoreCountryCenter(userContext, countryId, emptyOptions());
    retailStoreProvinceCenter.setCountry(country);

    retailStoreProvinceCenter.setLastUpdateTime(userContext.now());

    retailStoreProvinceCenter =
        saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, emptyOptions());

    onNewInstanceCreated(userContext, retailStoreProvinceCenter);
    return retailStoreProvinceCenter;
  }

  protected RetailStoreProvinceCenter createNewRetailStoreProvinceCenter() {

    return new RetailStoreProvinceCenter();
  }

  protected void checkParamsForUpdatingRetailStoreProvinceCenter(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      int retailStoreProvinceCenterVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext)
        .checkVersionOfRetailStoreProvinceCenter(retailStoreProvinceCenterVersion);

    if (RetailStoreProvinceCenter.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfRetailStoreProvinceCenter(parseString(newValueExpr));
    }
    if (RetailStoreProvinceCenter.FOUNDED_PROPERTY.equals(property)) {

      checkerOf(userContext).checkFoundedOfRetailStoreProvinceCenter(parseDate(newValueExpr));
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter clone(
      RetailscmUserContext userContext, String fromRetailStoreProvinceCenterId) throws Exception {

    return retailStoreProvinceCenterDaoOf(userContext)
        .clone(fromRetailStoreProvinceCenterId, this.allTokens());
  }

  public RetailStoreProvinceCenter internalSaveRetailStoreProvinceCenter(
      RetailscmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter)
      throws Exception {
    return internalSaveRetailStoreProvinceCenter(
        userContext, retailStoreProvinceCenter, allTokens());
  }

  public RetailStoreProvinceCenter internalSaveRetailStoreProvinceCenter(
      RetailscmUserContext userContext,
      RetailStoreProvinceCenter retailStoreProvinceCenter,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId,
    // retailStoreProvinceCenterVersion, property, newValueExpr, tokensExpr);

    synchronized (retailStoreProvinceCenter) {
      // will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreProvinceCenter.
      if (retailStoreProvinceCenter.isChanged()) {
        retailStoreProvinceCenter.updateLastUpdateTime(userContext.now());
      }

      // checkerOf(userContext).checkAndFixRetailStoreProvinceCenter(retailStoreProvinceCenter);
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, options);
      return retailStoreProvinceCenter;
    }
  }

  public RetailStoreProvinceCenter updateRetailStoreProvinceCenter(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      int retailStoreProvinceCenterVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreProvinceCenter(
        userContext,
        retailStoreProvinceCenterId,
        retailStoreProvinceCenterVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    if (retailStoreProvinceCenter.getVersion() != retailStoreProvinceCenterVersion) {
      String message =
          "The target version("
              + retailStoreProvinceCenter.getVersion()
              + ") is not equals to version("
              + retailStoreProvinceCenterVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreProvinceCenter) {
      // will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreProvinceCenter.
      retailStoreProvinceCenter.updateLastUpdateTime(userContext.now());
      retailStoreProvinceCenter.changeProperty(property, newValueExpr);
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().done());
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
      // return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter,
      // tokens().done());
    }
  }

  public RetailStoreProvinceCenter updateRetailStoreProvinceCenterProperty(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      int retailStoreProvinceCenterVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreProvinceCenter(
        userContext,
        retailStoreProvinceCenterId,
        retailStoreProvinceCenterVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    if (retailStoreProvinceCenter.getVersion() != retailStoreProvinceCenterVersion) {
      String message =
          "The target version("
              + retailStoreProvinceCenter.getVersion()
              + ") is not equals to version("
              + retailStoreProvinceCenterVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreProvinceCenter) {
      // will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreProvinceCenter.

      retailStoreProvinceCenter.changeProperty(property, newValueExpr);
      retailStoreProvinceCenter.updateLastUpdateTime(userContext.now());
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, tokens().done());
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
      // return saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter,
      // tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected RetailStoreProvinceCenterTokens tokens() {
    return RetailStoreProvinceCenterTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return RetailStoreProvinceCenterTokens.all();
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
        .sortProvinceCenterDepartmentListWith(ProvinceCenterDepartment.ID_PROPERTY, sortDesc())
        .sortProvinceCenterEmployeeListWith(ProvinceCenterEmployee.ID_PROPERTY, sortDesc())
        .sortRetailStoreCityServiceCenterListWith(
            RetailStoreCityServiceCenter.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return RetailStoreProvinceCenterTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherCountry(
      RetailscmUserContext userContext, String retailStoreProvinceCenterId, String anotherCountryId)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext)
        .checkIdOfRetailStoreCountryCenter(anotherCountryId); // check for optional reference

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter transferToAnotherCountry(
      RetailscmUserContext userContext, String retailStoreProvinceCenterId, String anotherCountryId)
      throws Exception {
    checkParamsForTransferingAnotherCountry(
        userContext, retailStoreProvinceCenterId, anotherCountryId);

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    synchronized (retailStoreProvinceCenter) {
      // will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreCountryCenter country =
          loadRetailStoreCountryCenter(userContext, anotherCountryId, emptyOptions());
      retailStoreProvinceCenter.updateCountry(country);
      retailStoreProvinceCenter.updateLastUpdateTime(userContext.now());
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(userContext, retailStoreProvinceCenter, emptyOptions());

      return present(userContext, retailStoreProvinceCenter, allTokens());
    }
  }

  public CandidateRetailStoreCountryCenter requestCandidateCountry(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<RetailStoreCountryCenter> candidateList =
        retailStoreCountryCenterDaoOf(userContext)
            .requestCandidateRetailStoreCountryCenterForRetailStoreProvinceCenter(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected RetailStoreCountryCenter loadRetailStoreCountryCenter(
      RetailscmUserContext userContext, String newCountryId, Map<String, Object> options)
      throws Exception {

    return retailStoreCountryCenterDaoOf(userContext).load(newCountryId, options);
  }

  // --------------------------------------------------------------

  public RetailStoreProvinceCenter forgetByAll(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      int retailStoreProvinceCenterVersion)
      throws Exception {
    return forgetByAllInternal(
        userContext, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
  }

  protected RetailStoreProvinceCenter forgetByAllInternal(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      int retailStoreProvinceCenterVersion)
      throws Exception {

    return retailStoreProvinceCenterDaoOf(userContext)
        .disconnectFromAll(retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new RetailStoreProvinceCenterManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingProvinceCenterDepartment(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String name,
      Date founded,
      String manager,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);

    checkerOf(userContext).checkNameOfProvinceCenterDepartment(name);

    checkerOf(userContext).checkFoundedOfProvinceCenterDepartment(founded);

    checkerOf(userContext).checkManagerOfProvinceCenterDepartment(manager);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter addProvinceCenterDepartment(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String name,
      Date founded,
      String manager,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingProvinceCenterDepartment(
        userContext, retailStoreProvinceCenterId, name, founded, manager, tokensExpr);

    ProvinceCenterDepartment provinceCenterDepartment =
        createProvinceCenterDepartment(userContext, name, founded, manager);

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, emptyOptions());
    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreProvinceCenter.addProvinceCenterDepartment(provinceCenterDepartment);
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withProvinceCenterDepartmentList().done());

      provinceCenterDepartmentManagerOf(userContext)
          .onNewInstanceCreated(userContext, provinceCenterDepartment);
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingProvinceCenterDepartmentProperties(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String id,
      String name,
      Date founded,
      String manager,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext).checkIdOfProvinceCenterDepartment(id);

    checkerOf(userContext).checkNameOfProvinceCenterDepartment(name);
    checkerOf(userContext).checkFoundedOfProvinceCenterDepartment(founded);
    checkerOf(userContext).checkManagerOfProvinceCenterDepartment(manager);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter updateProvinceCenterDepartmentProperties(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String id,
      String name,
      Date founded,
      String manager,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingProvinceCenterDepartmentProperties(
        userContext, retailStoreProvinceCenterId, id, name, founded, manager, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withProvinceCenterDepartmentListList()
            .searchProvinceCenterDepartmentListWith(
                ProvinceCenterDepartment.ID_PROPERTY, tokens().is(), id)
            .done();

    RetailStoreProvinceCenter retailStoreProvinceCenterToUpdate =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, options);

    if (retailStoreProvinceCenterToUpdate.getProvinceCenterDepartmentList().isEmpty()) {
      throw new RetailStoreProvinceCenterManagerException(
          "ProvinceCenterDepartment is NOT FOUND with id: '" + id + "'");
    }

    ProvinceCenterDepartment item =
        retailStoreProvinceCenterToUpdate.getProvinceCenterDepartmentList().first();
    beforeUpdateProvinceCenterDepartmentProperties(
        userContext, item, retailStoreProvinceCenterId, id, name, founded, manager, tokensExpr);
    item.updateName(name);
    item.updateFounded(founded);
    item.updateManager(manager);

    // checkParamsForAddingProvinceCenterDepartment(userContext,retailStoreProvinceCenterId,name,
    // code, used,tokensExpr);
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        saveRetailStoreProvinceCenter(
            userContext,
            retailStoreProvinceCenterToUpdate,
            tokens().withProvinceCenterDepartmentList().done());
    synchronized (retailStoreProvinceCenter) {
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateProvinceCenterDepartmentProperties(
      RetailscmUserContext userContext,
      ProvinceCenterDepartment item,
      String retailStoreProvinceCenterId,
      String id,
      String name,
      Date founded,
      String manager,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected ProvinceCenterDepartment createProvinceCenterDepartment(
      RetailscmUserContext userContext, String name, Date founded, String manager)
      throws Exception {

    ProvinceCenterDepartment provinceCenterDepartment = new ProvinceCenterDepartment();

    provinceCenterDepartment.setName(name);
    provinceCenterDepartment.setFounded(founded);
    provinceCenterDepartment.setManager(manager);

    return provinceCenterDepartment;
  }

  protected ProvinceCenterDepartment createIndexedProvinceCenterDepartment(String id, int version) {

    ProvinceCenterDepartment provinceCenterDepartment = new ProvinceCenterDepartment();
    provinceCenterDepartment.setId(id);
    provinceCenterDepartment.setVersion(version);
    return provinceCenterDepartment;
  }

  protected void checkParamsForRemovingProvinceCenterDepartmentList(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterDepartmentIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    for (String provinceCenterDepartmentIdItem : provinceCenterDepartmentIds) {
      checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentIdItem);
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter removeProvinceCenterDepartmentList(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterDepartmentIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingProvinceCenterDepartmentList(
        userContext, retailStoreProvinceCenterId, provinceCenterDepartmentIds, tokensExpr);

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreProvinceCenterDaoOf(userContext)
          .planToRemoveProvinceCenterDepartmentList(
              retailStoreProvinceCenter, provinceCenterDepartmentIds, allTokens());
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withProvinceCenterDepartmentList().done());
      deleteRelationListInGraph(
          userContext, retailStoreProvinceCenter.getProvinceCenterDepartmentList());
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingProvinceCenterDepartment(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterDepartmentId,
      int provinceCenterDepartmentVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
    checkerOf(userContext).checkVersionOfProvinceCenterDepartment(provinceCenterDepartmentVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter removeProvinceCenterDepartment(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterDepartmentId,
      int provinceCenterDepartmentVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingProvinceCenterDepartment(
        userContext,
        retailStoreProvinceCenterId,
        provinceCenterDepartmentId,
        provinceCenterDepartmentVersion,
        tokensExpr);

    ProvinceCenterDepartment provinceCenterDepartment =
        createIndexedProvinceCenterDepartment(
            provinceCenterDepartmentId, provinceCenterDepartmentVersion);
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreProvinceCenter.removeProvinceCenterDepartment(provinceCenterDepartment);
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withProvinceCenterDepartmentList().done());
      deleteRelationInGraph(userContext, provinceCenterDepartment);
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingProvinceCenterDepartment(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterDepartmentId,
      int provinceCenterDepartmentVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
    checkerOf(userContext).checkVersionOfProvinceCenterDepartment(provinceCenterDepartmentVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter copyProvinceCenterDepartmentFrom(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterDepartmentId,
      int provinceCenterDepartmentVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingProvinceCenterDepartment(
        userContext,
        retailStoreProvinceCenterId,
        provinceCenterDepartmentId,
        provinceCenterDepartmentVersion,
        tokensExpr);

    ProvinceCenterDepartment provinceCenterDepartment =
        createIndexedProvinceCenterDepartment(
            provinceCenterDepartmentId, provinceCenterDepartmentVersion);
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      retailStoreProvinceCenter.copyProvinceCenterDepartmentFrom(provinceCenterDepartment);
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withProvinceCenterDepartmentList().done());

      provinceCenterDepartmentManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (ProvinceCenterDepartment)
                  retailStoreProvinceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingProvinceCenterDepartment(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterDepartmentId,
      int provinceCenterDepartmentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
    checkerOf(userContext).checkVersionOfProvinceCenterDepartment(provinceCenterDepartmentVersion);

    if (ProvinceCenterDepartment.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfProvinceCenterDepartment(parseString(newValueExpr));
    }

    if (ProvinceCenterDepartment.FOUNDED_PROPERTY.equals(property)) {
      checkerOf(userContext).checkFoundedOfProvinceCenterDepartment(parseDate(newValueExpr));
    }

    if (ProvinceCenterDepartment.MANAGER_PROPERTY.equals(property)) {
      checkerOf(userContext).checkManagerOfProvinceCenterDepartment(parseString(newValueExpr));
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter updateProvinceCenterDepartment(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterDepartmentId,
      int provinceCenterDepartmentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingProvinceCenterDepartment(
        userContext,
        retailStoreProvinceCenterId,
        provinceCenterDepartmentId,
        provinceCenterDepartmentVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withProvinceCenterDepartmentList()
            .searchProvinceCenterDepartmentListWith(
                ProvinceCenterDepartment.ID_PROPERTY, tokens().equals(), provinceCenterDepartmentId)
            .done();

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, loadTokens);

    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // retailStoreProvinceCenter.removeProvinceCenterDepartment( provinceCenterDepartment );
      // make changes to AcceleraterAccount.
      ProvinceCenterDepartment provinceCenterDepartmentIdVersionKey =
          createIndexedProvinceCenterDepartment(
              provinceCenterDepartmentId, provinceCenterDepartmentVersion);

      ProvinceCenterDepartment provinceCenterDepartment =
          retailStoreProvinceCenter.findTheProvinceCenterDepartment(
              provinceCenterDepartmentIdVersionKey);
      if (provinceCenterDepartment == null) {
        throw new RetailStoreProvinceCenterManagerException(
            provinceCenterDepartmentId + " is NOT FOUND");
      }

      beforeUpdateProvinceCenterDepartment(
          userContext,
          provinceCenterDepartment,
          retailStoreProvinceCenterId,
          provinceCenterDepartmentId,
          provinceCenterDepartmentVersion,
          property,
          newValueExpr,
          tokensExpr);
      provinceCenterDepartment.changeProperty(property, newValueExpr);

      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withProvinceCenterDepartmentList().done());
      provinceCenterDepartmentManagerOf(userContext)
          .onUpdated(userContext, provinceCenterDepartment, this, "updateProvinceCenterDepartment");
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateProvinceCenterDepartment(
      RetailscmUserContext userContext,
      ProvinceCenterDepartment existed,
      String retailStoreProvinceCenterId,
      String provinceCenterDepartmentId,
      int provinceCenterDepartmentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  protected void checkParamsForAddingProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String name,
      String mobile,
      String email,
      Date founded,
      String departmentId,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);

    checkerOf(userContext).checkNameOfProvinceCenterEmployee(name);

    checkerOf(userContext).checkMobileOfProvinceCenterEmployee(mobile);

    checkerOf(userContext).checkEmailOfProvinceCenterEmployee(email);

    checkerOf(userContext).checkFoundedOfProvinceCenterEmployee(founded);

    checkerOf(userContext).checkDepartmentIdOfProvinceCenterEmployee(departmentId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter addProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String name,
      String mobile,
      String email,
      Date founded,
      String departmentId,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingProvinceCenterEmployee(
        userContext,
        retailStoreProvinceCenterId,
        name,
        mobile,
        email,
        founded,
        departmentId,
        tokensExpr);

    ProvinceCenterEmployee provinceCenterEmployee =
        createProvinceCenterEmployee(userContext, name, mobile, email, founded, departmentId);

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, emptyOptions());
    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreProvinceCenter.addProvinceCenterEmployee(provinceCenterEmployee);
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withProvinceCenterEmployeeList().done());

      provinceCenterEmployeeManagerOf(userContext)
          .onNewInstanceCreated(userContext, provinceCenterEmployee);
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingProvinceCenterEmployeeProperties(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String id,
      String name,
      String mobile,
      String email,
      Date founded,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext).checkIdOfProvinceCenterEmployee(id);

    checkerOf(userContext).checkNameOfProvinceCenterEmployee(name);
    checkerOf(userContext).checkMobileOfProvinceCenterEmployee(mobile);
    checkerOf(userContext).checkEmailOfProvinceCenterEmployee(email);
    checkerOf(userContext).checkFoundedOfProvinceCenterEmployee(founded);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter updateProvinceCenterEmployeeProperties(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String id,
      String name,
      String mobile,
      String email,
      Date founded,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingProvinceCenterEmployeeProperties(
        userContext, retailStoreProvinceCenterId, id, name, mobile, email, founded, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withProvinceCenterEmployeeListList()
            .searchProvinceCenterEmployeeListWith(
                ProvinceCenterEmployee.ID_PROPERTY, tokens().is(), id)
            .done();

    RetailStoreProvinceCenter retailStoreProvinceCenterToUpdate =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, options);

    if (retailStoreProvinceCenterToUpdate.getProvinceCenterEmployeeList().isEmpty()) {
      throw new RetailStoreProvinceCenterManagerException(
          "ProvinceCenterEmployee is NOT FOUND with id: '" + id + "'");
    }

    ProvinceCenterEmployee item =
        retailStoreProvinceCenterToUpdate.getProvinceCenterEmployeeList().first();
    beforeUpdateProvinceCenterEmployeeProperties(
        userContext,
        item,
        retailStoreProvinceCenterId,
        id,
        name,
        mobile,
        email,
        founded,
        tokensExpr);
    item.updateName(name);
    item.updateMobile(mobile);
    item.updateEmail(email);
    item.updateFounded(founded);

    // checkParamsForAddingProvinceCenterEmployee(userContext,retailStoreProvinceCenterId,name,
    // code, used,tokensExpr);
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        saveRetailStoreProvinceCenter(
            userContext,
            retailStoreProvinceCenterToUpdate,
            tokens().withProvinceCenterEmployeeList().done());
    synchronized (retailStoreProvinceCenter) {
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateProvinceCenterEmployeeProperties(
      RetailscmUserContext userContext,
      ProvinceCenterEmployee item,
      String retailStoreProvinceCenterId,
      String id,
      String name,
      String mobile,
      String email,
      Date founded,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected ProvinceCenterEmployee createProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String name,
      String mobile,
      String email,
      Date founded,
      String departmentId)
      throws Exception {

    ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();

    provinceCenterEmployee.setName(name);
    provinceCenterEmployee.setMobile(mobile);
    provinceCenterEmployee.setEmail(email);
    provinceCenterEmployee.setFounded(founded);
    ProvinceCenterDepartment department = new ProvinceCenterDepartment();
    department.setId(departmentId);
    provinceCenterEmployee.setDepartment(department);

    return provinceCenterEmployee;
  }

  protected ProvinceCenterEmployee createIndexedProvinceCenterEmployee(String id, int version) {

    ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
    provinceCenterEmployee.setId(id);
    provinceCenterEmployee.setVersion(version);
    return provinceCenterEmployee;
  }

  protected void checkParamsForRemovingProvinceCenterEmployeeList(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterEmployeeIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    for (String provinceCenterEmployeeIdItem : provinceCenterEmployeeIds) {
      checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeIdItem);
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter removeProvinceCenterEmployeeList(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterEmployeeIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingProvinceCenterEmployeeList(
        userContext, retailStoreProvinceCenterId, provinceCenterEmployeeIds, tokensExpr);

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreProvinceCenterDaoOf(userContext)
          .planToRemoveProvinceCenterEmployeeList(
              retailStoreProvinceCenter, provinceCenterEmployeeIds, allTokens());
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withProvinceCenterEmployeeList().done());
      deleteRelationListInGraph(
          userContext, retailStoreProvinceCenter.getProvinceCenterEmployeeList());
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
    checkerOf(userContext).checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter removeProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingProvinceCenterEmployee(
        userContext,
        retailStoreProvinceCenterId,
        provinceCenterEmployeeId,
        provinceCenterEmployeeVersion,
        tokensExpr);

    ProvinceCenterEmployee provinceCenterEmployee =
        createIndexedProvinceCenterEmployee(
            provinceCenterEmployeeId, provinceCenterEmployeeVersion);
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreProvinceCenter.removeProvinceCenterEmployee(provinceCenterEmployee);
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withProvinceCenterEmployeeList().done());
      deleteRelationInGraph(userContext, provinceCenterEmployee);
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
    checkerOf(userContext).checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter copyProvinceCenterEmployeeFrom(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingProvinceCenterEmployee(
        userContext,
        retailStoreProvinceCenterId,
        provinceCenterEmployeeId,
        provinceCenterEmployeeVersion,
        tokensExpr);

    ProvinceCenterEmployee provinceCenterEmployee =
        createIndexedProvinceCenterEmployee(
            provinceCenterEmployeeId, provinceCenterEmployeeVersion);
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      retailStoreProvinceCenter.copyProvinceCenterEmployeeFrom(provinceCenterEmployee);
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withProvinceCenterEmployeeList().done());

      provinceCenterEmployeeManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (ProvinceCenterEmployee)
                  retailStoreProvinceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
    checkerOf(userContext).checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);

    if (ProvinceCenterEmployee.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfProvinceCenterEmployee(parseString(newValueExpr));
    }

    if (ProvinceCenterEmployee.MOBILE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkMobileOfProvinceCenterEmployee(parseString(newValueExpr));
    }

    if (ProvinceCenterEmployee.EMAIL_PROPERTY.equals(property)) {
      checkerOf(userContext).checkEmailOfProvinceCenterEmployee(parseString(newValueExpr));
    }

    if (ProvinceCenterEmployee.FOUNDED_PROPERTY.equals(property)) {
      checkerOf(userContext).checkFoundedOfProvinceCenterEmployee(parseDate(newValueExpr));
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter updateProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingProvinceCenterEmployee(
        userContext,
        retailStoreProvinceCenterId,
        provinceCenterEmployeeId,
        provinceCenterEmployeeVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withProvinceCenterEmployeeList()
            .searchProvinceCenterEmployeeListWith(
                ProvinceCenterEmployee.ID_PROPERTY, tokens().equals(), provinceCenterEmployeeId)
            .done();

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, loadTokens);

    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // retailStoreProvinceCenter.removeProvinceCenterEmployee( provinceCenterEmployee );
      // make changes to AcceleraterAccount.
      ProvinceCenterEmployee provinceCenterEmployeeIdVersionKey =
          createIndexedProvinceCenterEmployee(
              provinceCenterEmployeeId, provinceCenterEmployeeVersion);

      ProvinceCenterEmployee provinceCenterEmployee =
          retailStoreProvinceCenter.findTheProvinceCenterEmployee(
              provinceCenterEmployeeIdVersionKey);
      if (provinceCenterEmployee == null) {
        throw new RetailStoreProvinceCenterManagerException(
            provinceCenterEmployeeId + " is NOT FOUND");
      }

      beforeUpdateProvinceCenterEmployee(
          userContext,
          provinceCenterEmployee,
          retailStoreProvinceCenterId,
          provinceCenterEmployeeId,
          provinceCenterEmployeeVersion,
          property,
          newValueExpr,
          tokensExpr);
      provinceCenterEmployee.changeProperty(property, newValueExpr);

      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withProvinceCenterEmployeeList().done());
      provinceCenterEmployeeManagerOf(userContext)
          .onUpdated(userContext, provinceCenterEmployee, this, "updateProvinceCenterEmployee");
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateProvinceCenterEmployee(
      RetailscmUserContext userContext,
      ProvinceCenterEmployee existed,
      String retailStoreProvinceCenterId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  protected void checkParamsForAddingRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String name,
      Date founded,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);

    checkerOf(userContext).checkNameOfRetailStoreCityServiceCenter(name);

    checkerOf(userContext).checkFoundedOfRetailStoreCityServiceCenter(founded);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter addRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String name,
      Date founded,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingRetailStoreCityServiceCenter(
        userContext, retailStoreProvinceCenterId, name, founded, tokensExpr);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        createRetailStoreCityServiceCenter(userContext, name, founded);

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, emptyOptions());
    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreProvinceCenter.addRetailStoreCityServiceCenter(retailStoreCityServiceCenter);
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withRetailStoreCityServiceCenterList().done());

      retailStoreCityServiceCenterManagerOf(userContext)
          .onNewInstanceCreated(userContext, retailStoreCityServiceCenter);
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStoreCityServiceCenterProperties(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String id,
      String name,
      Date founded,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(id);

    checkerOf(userContext).checkNameOfRetailStoreCityServiceCenter(name);
    checkerOf(userContext).checkFoundedOfRetailStoreCityServiceCenter(founded);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter updateRetailStoreCityServiceCenterProperties(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String id,
      String name,
      Date founded,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreCityServiceCenterProperties(
        userContext, retailStoreProvinceCenterId, id, name, founded, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withRetailStoreCityServiceCenterListList()
            .searchRetailStoreCityServiceCenterListWith(
                RetailStoreCityServiceCenter.ID_PROPERTY, tokens().is(), id)
            .done();

    RetailStoreProvinceCenter retailStoreProvinceCenterToUpdate =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, options);

    if (retailStoreProvinceCenterToUpdate.getRetailStoreCityServiceCenterList().isEmpty()) {
      throw new RetailStoreProvinceCenterManagerException(
          "RetailStoreCityServiceCenter is NOT FOUND with id: '" + id + "'");
    }

    RetailStoreCityServiceCenter item =
        retailStoreProvinceCenterToUpdate.getRetailStoreCityServiceCenterList().first();
    beforeUpdateRetailStoreCityServiceCenterProperties(
        userContext, item, retailStoreProvinceCenterId, id, name, founded, tokensExpr);
    item.updateName(name);
    item.updateFounded(founded);

    // checkParamsForAddingRetailStoreCityServiceCenter(userContext,retailStoreProvinceCenterId,name, code, used,tokensExpr);
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        saveRetailStoreProvinceCenter(
            userContext,
            retailStoreProvinceCenterToUpdate,
            tokens().withRetailStoreCityServiceCenterList().done());
    synchronized (retailStoreProvinceCenter) {
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateRetailStoreCityServiceCenterProperties(
      RetailscmUserContext userContext,
      RetailStoreCityServiceCenter item,
      String retailStoreProvinceCenterId,
      String id,
      String name,
      Date founded,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected RetailStoreCityServiceCenter createRetailStoreCityServiceCenter(
      RetailscmUserContext userContext, String name, Date founded) throws Exception {

    RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();

    retailStoreCityServiceCenter.setName(name);
    retailStoreCityServiceCenter.setFounded(founded);
    retailStoreCityServiceCenter.setLastUpdateTime(userContext.now());

    return retailStoreCityServiceCenter;
  }

  protected RetailStoreCityServiceCenter createIndexedRetailStoreCityServiceCenter(
      String id, int version) {

    RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
    retailStoreCityServiceCenter.setId(id);
    retailStoreCityServiceCenter.setVersion(version);
    return retailStoreCityServiceCenter;
  }

  protected void checkParamsForRemovingRetailStoreCityServiceCenterList(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String retailStoreCityServiceCenterIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    for (String retailStoreCityServiceCenterIdItem : retailStoreCityServiceCenterIds) {
      checkerOf(userContext)
          .checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterIdItem);
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter removeRetailStoreCityServiceCenterList(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String retailStoreCityServiceCenterIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStoreCityServiceCenterList(
        userContext, retailStoreProvinceCenterId, retailStoreCityServiceCenterIds, tokensExpr);

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreProvinceCenterDaoOf(userContext)
          .planToRemoveRetailStoreCityServiceCenterList(
              retailStoreProvinceCenter, retailStoreCityServiceCenterIds, allTokens());
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withRetailStoreCityServiceCenterList().done());
      deleteRelationListInGraph(
          userContext, retailStoreProvinceCenter.getRetailStoreCityServiceCenterList());
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String retailStoreCityServiceCenterId,
      int retailStoreCityServiceCenterVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext)
        .checkVersionOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter removeRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String retailStoreCityServiceCenterId,
      int retailStoreCityServiceCenterVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingRetailStoreCityServiceCenter(
        userContext,
        retailStoreProvinceCenterId,
        retailStoreCityServiceCenterId,
        retailStoreCityServiceCenterVersion,
        tokensExpr);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        createIndexedRetailStoreCityServiceCenter(
            retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      retailStoreProvinceCenter.removeRetailStoreCityServiceCenter(retailStoreCityServiceCenter);
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withRetailStoreCityServiceCenterList().done());
      deleteRelationInGraph(userContext, retailStoreCityServiceCenter);
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String retailStoreCityServiceCenterId,
      int retailStoreCityServiceCenterVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
    checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterId);
    checkerOf(userContext)
        .checkVersionOfRetailStoreCityServiceCenter(retailStoreCityServiceCenterVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter copyRetailStoreCityServiceCenterFrom(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String retailStoreCityServiceCenterId,
      int retailStoreCityServiceCenterVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingRetailStoreCityServiceCenter(
        userContext,
        retailStoreProvinceCenterId,
        retailStoreCityServiceCenterId,
        retailStoreCityServiceCenterVersion,
        tokensExpr);

    RetailStoreCityServiceCenter retailStoreCityServiceCenter =
        createIndexedRetailStoreCityServiceCenter(
            retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, allTokens());
    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      retailStoreCityServiceCenter.updateLastUpdateTime(userContext.now());

      retailStoreProvinceCenter.copyRetailStoreCityServiceCenterFrom(retailStoreCityServiceCenter);
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withRetailStoreCityServiceCenterList().done());

      retailStoreCityServiceCenterManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (RetailStoreCityServiceCenter)
                  retailStoreProvinceCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String retailStoreCityServiceCenterId,
      int retailStoreCityServiceCenterVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
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
        .throwExceptionIfHasErrors(RetailStoreProvinceCenterManagerException.class);
  }

  public RetailStoreProvinceCenter updateRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      String retailStoreProvinceCenterId,
      String retailStoreCityServiceCenterId,
      int retailStoreCityServiceCenterVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingRetailStoreCityServiceCenter(
        userContext,
        retailStoreProvinceCenterId,
        retailStoreCityServiceCenterId,
        retailStoreCityServiceCenterVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withRetailStoreCityServiceCenterList()
            .searchRetailStoreCityServiceCenterListWith(
                RetailStoreCityServiceCenter.ID_PROPERTY,
                tokens().equals(),
                retailStoreCityServiceCenterId)
            .done();

    RetailStoreProvinceCenter retailStoreProvinceCenter =
        loadRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, loadTokens);

    synchronized (retailStoreProvinceCenter) {
      // Will be good when the retailStoreProvinceCenter loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // retailStoreProvinceCenter.removeRetailStoreCityServiceCenter( retailStoreCityServiceCenter
      // );
      // make changes to AcceleraterAccount.
      RetailStoreCityServiceCenter retailStoreCityServiceCenterIdVersionKey =
          createIndexedRetailStoreCityServiceCenter(
              retailStoreCityServiceCenterId, retailStoreCityServiceCenterVersion);

      RetailStoreCityServiceCenter retailStoreCityServiceCenter =
          retailStoreProvinceCenter.findTheRetailStoreCityServiceCenter(
              retailStoreCityServiceCenterIdVersionKey);
      if (retailStoreCityServiceCenter == null) {
        throw new RetailStoreProvinceCenterManagerException(
            retailStoreCityServiceCenterId + " is NOT FOUND");
      }

      beforeUpdateRetailStoreCityServiceCenter(
          userContext,
          retailStoreCityServiceCenter,
          retailStoreProvinceCenterId,
          retailStoreCityServiceCenterId,
          retailStoreCityServiceCenterVersion,
          property,
          newValueExpr,
          tokensExpr);
      retailStoreCityServiceCenter.changeProperty(property, newValueExpr);
      retailStoreCityServiceCenter.updateLastUpdateTime(userContext.now());
      retailStoreProvinceCenter =
          saveRetailStoreProvinceCenter(
              userContext,
              retailStoreProvinceCenter,
              tokens().withRetailStoreCityServiceCenterList().done());
      retailStoreCityServiceCenterManagerOf(userContext)
          .onUpdated(
              userContext,
              retailStoreCityServiceCenter,
              this,
              "updateRetailStoreCityServiceCenter");
      return present(userContext, retailStoreProvinceCenter, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateRetailStoreCityServiceCenter(
      RetailscmUserContext userContext,
      RetailStoreCityServiceCenter existed,
      String retailStoreProvinceCenterId,
      String retailStoreCityServiceCenterId,
      int retailStoreCityServiceCenterVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, RetailStoreProvinceCenter newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    retailStoreProvinceCenterDaoOf(ctx)
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
    //   RetailStoreProvinceCenter newRetailStoreProvinceCenter =
    // this.createRetailStoreProvinceCenter(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newRetailStoreProvinceCenter
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreProvinceCenter.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<RetailStoreProvinceCenter> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<RetailStoreCountryCenter> countryList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, RetailStoreCountryCenter.class);
    userContext.getDAOGroup().enhanceList(countryList, RetailStoreCountryCenter.class);
  }

  public Object listByCountry(RetailscmUserContext userContext, String countryId) throws Exception {
    return listPageByCountry(userContext, countryId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByCountry(
      RetailscmUserContext userContext, String countryId, int start, int count) throws Exception {
    SmartList<RetailStoreProvinceCenter> list =
        retailStoreProvinceCenterDaoOf(userContext)
            .findRetailStoreProvinceCenterByCountry(countryId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(RetailStoreProvinceCenter.class);
    page.setContainerObject(RetailStoreCountryCenter.withId(countryId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("双链小超省中心列表");
    page.setRequestName("listByCountry");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByCountry/%s/", getBeanName(), countryId)));

    page.assemblerContent(userContext, "listByCountry");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String retailStoreProvinceCenterId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    RetailStoreProvinceCenter merchantObj =
        (RetailStoreProvinceCenter) this.view(userContext, retailStoreProvinceCenterId);
    String merchantObjId = retailStoreProvinceCenterId;
    String linkToUrl = "retailStoreProvinceCenterManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "双链小超省中心" + "详情";
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
        MapUtil.put("id", "4-country")
            .put("fieldName", "country")
            .put("label", "国")
            .put("type", "auto")
            .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("country", merchantObj.getCountry());

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

    // 处理Section：provinceCenterEmployeeListSection
    Map provinceCenterEmployeeListSection =
        ListofUtils.buildSection(
            "provinceCenterEmployeeListSection",
            "省中心员工名单",
            null,
            "",
            "__no_group",
            "provinceCenterEmployeeManager/listByProvinceCenter/" + merchantObjId + "/",
            "auto");
    sections.add(provinceCenterEmployeeListSection);

    result.put(
        "provinceCenterEmployeeListSection",
        ListofUtils.toShortList(
            merchantObj.getProvinceCenterEmployeeList(), "provinceCenterEmployee"));

    // 处理Section：retailStoreCityServiceCenterListSection
    Map retailStoreCityServiceCenterListSection =
        ListofUtils.buildSection(
            "retailStoreCityServiceCenterListSection",
            "零售门店城市服务中心名单",
            null,
            "",
            "__no_group",
            "retailStoreCityServiceCenterManager/listByBelongsTo/" + merchantObjId + "/",
            "auto");
    sections.add(retailStoreCityServiceCenterListSection);

    result.put(
        "retailStoreCityServiceCenterListSection",
        ListofUtils.toShortList(
            merchantObj.getRetailStoreCityServiceCenterList(), "retailStoreCityServiceCenter"));

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
