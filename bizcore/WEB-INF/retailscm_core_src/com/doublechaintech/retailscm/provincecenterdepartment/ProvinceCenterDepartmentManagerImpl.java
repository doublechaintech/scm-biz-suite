package com.doublechaintech.retailscm.provincecenterdepartment;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
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

public class ProvinceCenterDepartmentManagerImpl extends CustomRetailscmCheckerManager
    implements ProvinceCenterDepartmentManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        ProvinceCenterDepartmentTokens.start().withTokenFromListName(listName).done();
    ProvinceCenterDepartment provinceCenterDepartment =
        (ProvinceCenterDepartment) this.loadProvinceCenterDepartment(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = provinceCenterDepartment.collectReferencesFromLists();
    provinceCenterDepartmentDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, provinceCenterDepartment, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new ProvinceCenterDepartmentGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "ProvinceCenterDepartment";

  @Override
  public ProvinceCenterDepartmentDAO daoOf(RetailscmUserContext userContext) {
    return provinceCenterDepartmentDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws ProvinceCenterDepartmentManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new ProvinceCenterDepartmentManagerException(message);
  }

  protected ProvinceCenterDepartment saveProvinceCenterDepartment(
      RetailscmUserContext userContext,
      ProvinceCenterDepartment provinceCenterDepartment,
      String[] tokensExpr)
      throws Exception {
    // return getProvinceCenterDepartmentDAO().save(provinceCenterDepartment, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens);
  }

  protected ProvinceCenterDepartment saveProvinceCenterDepartmentDetail(
      RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment)
      throws Exception {

    return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, allTokens());
  }

  public ProvinceCenterDepartment loadProvinceCenterDepartment(
      RetailscmUserContext userContext, String provinceCenterDepartmentId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, tokens);
    // do some calc before sent to customer?
    return present(userContext, provinceCenterDepartment, tokens);
  }

  public ProvinceCenterDepartment searchProvinceCenterDepartment(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, tokens);
    // do some calc before sent to customer?
    return present(userContext, provinceCenterDepartment, tokens);
  }

  protected ProvinceCenterDepartment present(
      RetailscmUserContext userContext,
      ProvinceCenterDepartment provinceCenterDepartment,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, provinceCenterDepartment, tokens);

    ProvinceCenterDepartment provinceCenterDepartmentToPresent =
        provinceCenterDepartmentDaoOf(userContext).present(provinceCenterDepartment, tokens);

    List<BaseEntity> entityListToNaming =
        provinceCenterDepartmentToPresent.collectReferencesFromLists();
    provinceCenterDepartmentDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, provinceCenterDepartment, tokens);

    return provinceCenterDepartmentToPresent;
  }

  public ProvinceCenterDepartment loadProvinceCenterDepartmentDetail(
      RetailscmUserContext userContext, String provinceCenterDepartmentId) throws Exception {
    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
    return present(userContext, provinceCenterDepartment, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String provinceCenterDepartmentId)
      throws Exception {
    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, viewTokens());
    markVisited(userContext, provinceCenterDepartment);
    return present(userContext, provinceCenterDepartment, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String provinceCenterDepartmentId)
      throws Exception {
    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, viewTokens());
    provinceCenterDepartment.summarySuffix();
    markVisited(userContext, provinceCenterDepartment);
    return present(userContext, provinceCenterDepartment, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String provinceCenterDepartmentId)
      throws Exception {
    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, analyzeTokens());
    markVisited(userContext, provinceCenterDepartment);
    return present(userContext, provinceCenterDepartment, analyzeTokens());
  }

  protected ProvinceCenterDepartment saveProvinceCenterDepartment(
      RetailscmUserContext userContext,
      ProvinceCenterDepartment provinceCenterDepartment,
      Map<String, Object> tokens)
      throws Exception {

    return provinceCenterDepartmentDaoOf(userContext).save(provinceCenterDepartment, tokens);
  }

  protected ProvinceCenterDepartment loadProvinceCenterDepartment(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);

    return provinceCenterDepartmentDaoOf(userContext).load(provinceCenterDepartmentId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      ProvinceCenterDepartment provinceCenterDepartment,
      Map<String, Object> tokens) {
    super.addActions(userContext, provinceCenterDepartment, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String, Object> tokens){

  @Override
  public List<ProvinceCenterDepartment> searchProvinceCenterDepartmentList(
      RetailscmUserContext ctx, ProvinceCenterDepartmentRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<ProvinceCenterDepartment> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public ProvinceCenterDepartment searchProvinceCenterDepartment(
      RetailscmUserContext ctx, ProvinceCenterDepartmentRequest pRequest) {
    pRequest.limit(0, 1);
    List<ProvinceCenterDepartment> list = searchProvinceCenterDepartmentList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public ProvinceCenterDepartment createProvinceCenterDepartment(
      RetailscmUserContext userContext,
      String name,
      Date founded,
      String provinceCenterId,
      String manager)
      throws Exception {

    checkerOf(userContext).checkNameOfProvinceCenterDepartment(name);
    checkerOf(userContext).checkFoundedOfProvinceCenterDepartment(founded);
    checkerOf(userContext).checkManagerOfProvinceCenterDepartment(manager);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);

    ProvinceCenterDepartment provinceCenterDepartment = createNewProvinceCenterDepartment();

    provinceCenterDepartment.setName(name);
    provinceCenterDepartment.setFounded(founded);

    RetailStoreProvinceCenter provinceCenter =
        loadRetailStoreProvinceCenter(userContext, provinceCenterId, emptyOptions());
    provinceCenterDepartment.setProvinceCenter(provinceCenter);

    provinceCenterDepartment.setManager(manager);

    provinceCenterDepartment =
        saveProvinceCenterDepartment(userContext, provinceCenterDepartment, emptyOptions());

    onNewInstanceCreated(userContext, provinceCenterDepartment);
    return provinceCenterDepartment;
  }

  protected ProvinceCenterDepartment createNewProvinceCenterDepartment() {

    return new ProvinceCenterDepartment();
  }

  protected void checkParamsForUpdatingProvinceCenterDepartment(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      int provinceCenterDepartmentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

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
        .throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
  }

  public ProvinceCenterDepartment clone(
      RetailscmUserContext userContext, String fromProvinceCenterDepartmentId) throws Exception {

    return provinceCenterDepartmentDaoOf(userContext)
        .clone(fromProvinceCenterDepartmentId, this.allTokens());
  }

  public ProvinceCenterDepartment internalSaveProvinceCenterDepartment(
      RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment)
      throws Exception {
    return internalSaveProvinceCenterDepartment(userContext, provinceCenterDepartment, allTokens());
  }

  public ProvinceCenterDepartment internalSaveProvinceCenterDepartment(
      RetailscmUserContext userContext,
      ProvinceCenterDepartment provinceCenterDepartment,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingProvinceCenterDepartment(userContext, provinceCenterDepartmentId,
    // provinceCenterDepartmentVersion, property, newValueExpr, tokensExpr);

    synchronized (provinceCenterDepartment) {
      // will be good when the provinceCenterDepartment loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ProvinceCenterDepartment.
      if (provinceCenterDepartment.isChanged()) {}

      // checkerOf(userContext).checkAndFixProvinceCenterDepartment(provinceCenterDepartment);
      provinceCenterDepartment =
          saveProvinceCenterDepartment(userContext, provinceCenterDepartment, options);
      return provinceCenterDepartment;
    }
  }

  public ProvinceCenterDepartment updateProvinceCenterDepartment(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      int provinceCenterDepartmentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingProvinceCenterDepartment(
        userContext,
        provinceCenterDepartmentId,
        provinceCenterDepartmentVersion,
        property,
        newValueExpr,
        tokensExpr);

    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
    if (provinceCenterDepartment.getVersion() != provinceCenterDepartmentVersion) {
      String message =
          "The target version("
              + provinceCenterDepartment.getVersion()
              + ") is not equals to version("
              + provinceCenterDepartmentVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (provinceCenterDepartment) {
      // will be good when the provinceCenterDepartment loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ProvinceCenterDepartment.

      provinceCenterDepartment.changeProperty(property, newValueExpr);
      provinceCenterDepartment =
          saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().done());
      return present(userContext, provinceCenterDepartment, mergedAllTokens(tokensExpr));
      // return saveProvinceCenterDepartment(userContext, provinceCenterDepartment,
      // tokens().done());
    }
  }

  public ProvinceCenterDepartment updateProvinceCenterDepartmentProperty(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      int provinceCenterDepartmentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingProvinceCenterDepartment(
        userContext,
        provinceCenterDepartmentId,
        provinceCenterDepartmentVersion,
        property,
        newValueExpr,
        tokensExpr);

    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
    if (provinceCenterDepartment.getVersion() != provinceCenterDepartmentVersion) {
      String message =
          "The target version("
              + provinceCenterDepartment.getVersion()
              + ") is not equals to version("
              + provinceCenterDepartmentVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (provinceCenterDepartment) {
      // will be good when the provinceCenterDepartment loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ProvinceCenterDepartment.

      provinceCenterDepartment.changeProperty(property, newValueExpr);

      provinceCenterDepartment =
          saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().done());
      return present(userContext, provinceCenterDepartment, mergedAllTokens(tokensExpr));
      // return saveProvinceCenterDepartment(userContext, provinceCenterDepartment,
      // tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected ProvinceCenterDepartmentTokens tokens() {
    return ProvinceCenterDepartmentTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return ProvinceCenterDepartmentTokens.all();
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
        .sortProvinceCenterEmployeeListWith(ProvinceCenterEmployee.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return ProvinceCenterDepartmentTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherProvinceCenter(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String anotherProvinceCenterId)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
    checkerOf(userContext)
        .checkIdOfRetailStoreProvinceCenter(
            anotherProvinceCenterId); // check for optional reference

    checkerOf(userContext)
        .throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
  }

  public ProvinceCenterDepartment transferToAnotherProvinceCenter(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String anotherProvinceCenterId)
      throws Exception {
    checkParamsForTransferingAnotherProvinceCenter(
        userContext, provinceCenterDepartmentId, anotherProvinceCenterId);

    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
    synchronized (provinceCenterDepartment) {
      // will be good when the provinceCenterDepartment loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreProvinceCenter provinceCenter =
          loadRetailStoreProvinceCenter(userContext, anotherProvinceCenterId, emptyOptions());
      provinceCenterDepartment.updateProvinceCenter(provinceCenter);

      provinceCenterDepartment =
          saveProvinceCenterDepartment(userContext, provinceCenterDepartment, emptyOptions());

      return present(userContext, provinceCenterDepartment, allTokens());
    }
  }

  public CandidateRetailStoreProvinceCenter requestCandidateProvinceCenter(
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
            .requestCandidateRetailStoreProvinceCenterForProvinceCenterDepartment(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(
      RetailscmUserContext userContext, String newProvinceCenterId, Map<String, Object> options)
      throws Exception {

    return retailStoreProvinceCenterDaoOf(userContext).load(newProvinceCenterId, options);
  }

  // --------------------------------------------------------------

  public ProvinceCenterDepartment forgetByAll(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      int provinceCenterDepartmentVersion)
      throws Exception {
    return forgetByAllInternal(
        userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion);
  }

  protected ProvinceCenterDepartment forgetByAllInternal(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      int provinceCenterDepartmentVersion)
      throws Exception {

    return provinceCenterDepartmentDaoOf(userContext)
        .disconnectFromAll(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new ProvinceCenterDepartmentManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String name,
      String mobile,
      String email,
      Date founded,
      String provinceCenterId,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);

    checkerOf(userContext).checkNameOfProvinceCenterEmployee(name);

    checkerOf(userContext).checkMobileOfProvinceCenterEmployee(mobile);

    checkerOf(userContext).checkEmailOfProvinceCenterEmployee(email);

    checkerOf(userContext).checkFoundedOfProvinceCenterEmployee(founded);

    checkerOf(userContext).checkProvinceCenterIdOfProvinceCenterEmployee(provinceCenterId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
  }

  public ProvinceCenterDepartment addProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String name,
      String mobile,
      String email,
      Date founded,
      String provinceCenterId,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingProvinceCenterEmployee(
        userContext,
        provinceCenterDepartmentId,
        name,
        mobile,
        email,
        founded,
        provinceCenterId,
        tokensExpr);

    ProvinceCenterEmployee provinceCenterEmployee =
        createProvinceCenterEmployee(userContext, name, mobile, email, founded, provinceCenterId);

    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, emptyOptions());
    synchronized (provinceCenterDepartment) {
      // Will be good when the provinceCenterDepartment loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      provinceCenterDepartment.addProvinceCenterEmployee(provinceCenterEmployee);
      provinceCenterDepartment =
          saveProvinceCenterDepartment(
              userContext,
              provinceCenterDepartment,
              tokens().withProvinceCenterEmployeeList().done());

      provinceCenterEmployeeManagerOf(userContext)
          .onNewInstanceCreated(userContext, provinceCenterEmployee);
      return present(userContext, provinceCenterDepartment, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingProvinceCenterEmployeeProperties(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String id,
      String name,
      String mobile,
      String email,
      Date founded,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
    checkerOf(userContext).checkIdOfProvinceCenterEmployee(id);

    checkerOf(userContext).checkNameOfProvinceCenterEmployee(name);
    checkerOf(userContext).checkMobileOfProvinceCenterEmployee(mobile);
    checkerOf(userContext).checkEmailOfProvinceCenterEmployee(email);
    checkerOf(userContext).checkFoundedOfProvinceCenterEmployee(founded);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
  }

  public ProvinceCenterDepartment updateProvinceCenterEmployeeProperties(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String id,
      String name,
      String mobile,
      String email,
      Date founded,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingProvinceCenterEmployeeProperties(
        userContext, provinceCenterDepartmentId, id, name, mobile, email, founded, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withProvinceCenterEmployeeListList()
            .searchProvinceCenterEmployeeListWith(
                ProvinceCenterEmployee.ID_PROPERTY, tokens().is(), id)
            .done();

    ProvinceCenterDepartment provinceCenterDepartmentToUpdate =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, options);

    if (provinceCenterDepartmentToUpdate.getProvinceCenterEmployeeList().isEmpty()) {
      throw new ProvinceCenterDepartmentManagerException(
          "ProvinceCenterEmployee is NOT FOUND with id: '" + id + "'");
    }

    ProvinceCenterEmployee item =
        provinceCenterDepartmentToUpdate.getProvinceCenterEmployeeList().first();
    beforeUpdateProvinceCenterEmployeeProperties(
        userContext,
        item,
        provinceCenterDepartmentId,
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

    // checkParamsForAddingProvinceCenterEmployee(userContext,provinceCenterDepartmentId,name, code,
    // used,tokensExpr);
    ProvinceCenterDepartment provinceCenterDepartment =
        saveProvinceCenterDepartment(
            userContext,
            provinceCenterDepartmentToUpdate,
            tokens().withProvinceCenterEmployeeList().done());
    synchronized (provinceCenterDepartment) {
      return present(userContext, provinceCenterDepartment, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateProvinceCenterEmployeeProperties(
      RetailscmUserContext userContext,
      ProvinceCenterEmployee item,
      String provinceCenterDepartmentId,
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
      String provinceCenterId)
      throws Exception {

    ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();

    provinceCenterEmployee.setName(name);
    provinceCenterEmployee.setMobile(mobile);
    provinceCenterEmployee.setEmail(email);
    provinceCenterEmployee.setFounded(founded);
    RetailStoreProvinceCenter provinceCenter = new RetailStoreProvinceCenter();
    provinceCenter.setId(provinceCenterId);
    provinceCenterEmployee.setProvinceCenter(provinceCenter);

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
      String provinceCenterDepartmentId,
      String provinceCenterEmployeeIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
    for (String provinceCenterEmployeeIdItem : provinceCenterEmployeeIds) {
      checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeIdItem);
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
  }

  public ProvinceCenterDepartment removeProvinceCenterEmployeeList(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String provinceCenterEmployeeIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingProvinceCenterEmployeeList(
        userContext, provinceCenterDepartmentId, provinceCenterEmployeeIds, tokensExpr);

    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
    synchronized (provinceCenterDepartment) {
      // Will be good when the provinceCenterDepartment loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      provinceCenterDepartmentDaoOf(userContext)
          .planToRemoveProvinceCenterEmployeeList(
              provinceCenterDepartment, provinceCenterEmployeeIds, allTokens());
      provinceCenterDepartment =
          saveProvinceCenterDepartment(
              userContext,
              provinceCenterDepartment,
              tokens().withProvinceCenterEmployeeList().done());
      deleteRelationListInGraph(
          userContext, provinceCenterDepartment.getProvinceCenterEmployeeList());
      return present(userContext, provinceCenterDepartment, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
    checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
    checkerOf(userContext).checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
  }

  public ProvinceCenterDepartment removeProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingProvinceCenterEmployee(
        userContext,
        provinceCenterDepartmentId,
        provinceCenterEmployeeId,
        provinceCenterEmployeeVersion,
        tokensExpr);

    ProvinceCenterEmployee provinceCenterEmployee =
        createIndexedProvinceCenterEmployee(
            provinceCenterEmployeeId, provinceCenterEmployeeVersion);
    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
    synchronized (provinceCenterDepartment) {
      // Will be good when the provinceCenterDepartment loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      provinceCenterDepartment.removeProvinceCenterEmployee(provinceCenterEmployee);
      provinceCenterDepartment =
          saveProvinceCenterDepartment(
              userContext,
              provinceCenterDepartment,
              tokens().withProvinceCenterEmployeeList().done());
      deleteRelationInGraph(userContext, provinceCenterEmployee);
      return present(userContext, provinceCenterDepartment, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
    checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
    checkerOf(userContext).checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
  }

  public ProvinceCenterDepartment copyProvinceCenterEmployeeFrom(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingProvinceCenterEmployee(
        userContext,
        provinceCenterDepartmentId,
        provinceCenterEmployeeId,
        provinceCenterEmployeeVersion,
        tokensExpr);

    ProvinceCenterEmployee provinceCenterEmployee =
        createIndexedProvinceCenterEmployee(
            provinceCenterEmployeeId, provinceCenterEmployeeVersion);
    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
    synchronized (provinceCenterDepartment) {
      // Will be good when the provinceCenterDepartment loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      provinceCenterDepartment.copyProvinceCenterEmployeeFrom(provinceCenterEmployee);
      provinceCenterDepartment =
          saveProvinceCenterDepartment(
              userContext,
              provinceCenterDepartment,
              tokens().withProvinceCenterEmployeeList().done());

      provinceCenterEmployeeManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (ProvinceCenterEmployee)
                  provinceCenterDepartment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, provinceCenterDepartment, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
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
        .throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);
  }

  public ProvinceCenterDepartment updateProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String provinceCenterDepartmentId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingProvinceCenterEmployee(
        userContext,
        provinceCenterDepartmentId,
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

    ProvinceCenterDepartment provinceCenterDepartment =
        loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, loadTokens);

    synchronized (provinceCenterDepartment) {
      // Will be good when the provinceCenterDepartment loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // provinceCenterDepartment.removeProvinceCenterEmployee( provinceCenterEmployee );
      // make changes to AcceleraterAccount.
      ProvinceCenterEmployee provinceCenterEmployeeIdVersionKey =
          createIndexedProvinceCenterEmployee(
              provinceCenterEmployeeId, provinceCenterEmployeeVersion);

      ProvinceCenterEmployee provinceCenterEmployee =
          provinceCenterDepartment.findTheProvinceCenterEmployee(
              provinceCenterEmployeeIdVersionKey);
      if (provinceCenterEmployee == null) {
        throw new ProvinceCenterDepartmentManagerException(
            provinceCenterEmployeeId + " is NOT FOUND");
      }

      beforeUpdateProvinceCenterEmployee(
          userContext,
          provinceCenterEmployee,
          provinceCenterDepartmentId,
          provinceCenterEmployeeId,
          provinceCenterEmployeeVersion,
          property,
          newValueExpr,
          tokensExpr);
      provinceCenterEmployee.changeProperty(property, newValueExpr);

      provinceCenterDepartment =
          saveProvinceCenterDepartment(
              userContext,
              provinceCenterDepartment,
              tokens().withProvinceCenterEmployeeList().done());
      provinceCenterEmployeeManagerOf(userContext)
          .onUpdated(userContext, provinceCenterEmployee, this, "updateProvinceCenterEmployee");
      return present(userContext, provinceCenterDepartment, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateProvinceCenterEmployee(
      RetailscmUserContext userContext,
      ProvinceCenterEmployee existed,
      String provinceCenterDepartmentId,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, ProvinceCenterDepartment newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    provinceCenterDepartmentDaoOf(ctx)
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
    //   ProvinceCenterDepartment newProvinceCenterDepartment =
    // this.createProvinceCenterDepartment(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newProvinceCenterDepartment
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
    key.put(UserApp.APP_TYPE_PROPERTY, ProvinceCenterDepartment.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<ProvinceCenterDepartment> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<RetailStoreProvinceCenter> provinceCenterList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, RetailStoreProvinceCenter.class);
    userContext.getDAOGroup().enhanceList(provinceCenterList, RetailStoreProvinceCenter.class);
  }

  public Object listByProvinceCenter(RetailscmUserContext userContext, String provinceCenterId)
      throws Exception {
    return listPageByProvinceCenter(userContext, provinceCenterId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByProvinceCenter(
      RetailscmUserContext userContext, String provinceCenterId, int start, int count)
      throws Exception {
    SmartList<ProvinceCenterDepartment> list =
        provinceCenterDepartmentDaoOf(userContext)
            .findProvinceCenterDepartmentByProvinceCenter(
                provinceCenterId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(ProvinceCenterDepartment.class);
    page.setContainerObject(RetailStoreProvinceCenter.withId(provinceCenterId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("省中心列表");
    page.setRequestName("listByProvinceCenter");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(
            String.format("%s/listByProvinceCenter/%s/", getBeanName(), provinceCenterId)));

    page.assemblerContent(userContext, "listByProvinceCenter");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String provinceCenterDepartmentId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    ProvinceCenterDepartment merchantObj =
        (ProvinceCenterDepartment) this.view(userContext, provinceCenterDepartmentId);
    String merchantObjId = provinceCenterDepartmentId;
    String linkToUrl = "provinceCenterDepartmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "省中心" + "详情";
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
        MapUtil.put("id", "4-provinceCenter")
            .put("fieldName", "provinceCenter")
            .put("label", "省中心")
            .put("type", "auto")
            .put("linkToUrl", "retailStoreProvinceCenterManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("provinceCenter", merchantObj.getProvinceCenter());

    propList.add(
        MapUtil.put("id", "5-manager")
            .put("fieldName", "manager")
            .put("label", "经理")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("manager", merchantObj.getManager());

    // 处理 sectionList

    // 处理Section：provinceCenterEmployeeListSection
    Map provinceCenterEmployeeListSection =
        ListofUtils.buildSection(
            "provinceCenterEmployeeListSection",
            "省中心员工名单",
            null,
            "",
            "__no_group",
            "provinceCenterEmployeeManager/listByDepartment/" + merchantObjId + "/",
            "auto");
    sections.add(provinceCenterEmployeeListSection);

    result.put(
        "provinceCenterEmployeeListSection",
        ListofUtils.toShortList(
            merchantObj.getProvinceCenterEmployeeList(), "provinceCenterEmployee"));

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
