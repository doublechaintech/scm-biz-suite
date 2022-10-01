package com.doublechaintech.retailscm.leavetype;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.leavetype.LeaveType;
import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
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

public class LeaveTypeManagerImpl extends CustomRetailscmCheckerManager
    implements LeaveTypeManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens = LeaveTypeTokens.start().withTokenFromListName(listName).done();
    LeaveType leaveType = (LeaveType) this.loadLeaveType(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = leaveType.collectReferencesFromLists();
    leaveTypeDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, leaveType, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new LeaveTypeGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "LeaveType";

  @Override
  public LeaveTypeDAO daoOf(RetailscmUserContext userContext) {
    return leaveTypeDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws LeaveTypeManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new LeaveTypeManagerException(message);
  }

  protected LeaveType saveLeaveType(
      RetailscmUserContext userContext, LeaveType leaveType, String[] tokensExpr) throws Exception {
    // return getLeaveTypeDAO().save(leaveType, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveLeaveType(userContext, leaveType, tokens);
  }

  protected LeaveType saveLeaveTypeDetail(RetailscmUserContext userContext, LeaveType leaveType)
      throws Exception {

    return saveLeaveType(userContext, leaveType, allTokens());
  }

  public LeaveType loadLeaveType(
      RetailscmUserContext userContext, String leaveTypeId, String[] tokensExpr) throws Exception {

    checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);

    checkerOf(userContext).throwExceptionIfHasErrors(LeaveTypeManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, leaveType, tokens);
  }

  public LeaveType searchLeaveType(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);

    checkerOf(userContext).throwExceptionIfHasErrors(LeaveTypeManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, leaveType, tokens);
  }

  protected LeaveType present(
      RetailscmUserContext userContext, LeaveType leaveType, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, leaveType, tokens);

    LeaveType leaveTypeToPresent = leaveTypeDaoOf(userContext).present(leaveType, tokens);

    List<BaseEntity> entityListToNaming = leaveTypeToPresent.collectReferencesFromLists();
    leaveTypeDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, leaveType, tokens);

    return leaveTypeToPresent;
  }

  public LeaveType loadLeaveTypeDetail(RetailscmUserContext userContext, String leaveTypeId)
      throws Exception {
    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
    return present(userContext, leaveType, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String leaveTypeId) throws Exception {
    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, viewTokens());
    markVisited(userContext, leaveType);
    return present(userContext, leaveType, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String leaveTypeId) throws Exception {
    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, viewTokens());
    leaveType.summarySuffix();
    markVisited(userContext, leaveType);
    return present(userContext, leaveType, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String leaveTypeId) throws Exception {
    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, analyzeTokens());
    markVisited(userContext, leaveType);
    return present(userContext, leaveType, analyzeTokens());
  }

  protected LeaveType saveLeaveType(
      RetailscmUserContext userContext, LeaveType leaveType, Map<String, Object> tokens)
      throws Exception {

    return leaveTypeDaoOf(userContext).save(leaveType, tokens);
  }

  protected LeaveType loadLeaveType(
      RetailscmUserContext userContext, String leaveTypeId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);

    checkerOf(userContext).throwExceptionIfHasErrors(LeaveTypeManagerException.class);

    return leaveTypeDaoOf(userContext).load(leaveTypeId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, LeaveType leaveType, Map<String, Object> tokens) {
    super.addActions(userContext, leaveType, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, LeaveType leaveType, Map<String, Object> tokens){

  @Override
  public List<LeaveType> searchLeaveTypeList(RetailscmUserContext ctx, LeaveTypeRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<LeaveType> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public LeaveType searchLeaveType(RetailscmUserContext ctx, LeaveTypeRequest pRequest) {
    pRequest.limit(0, 1);
    List<LeaveType> list = searchLeaveTypeList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public LeaveType createLeaveType(
      RetailscmUserContext userContext,
      String code,
      String companyId,
      String description,
      String detailDescription)
      throws Exception {

    checkerOf(userContext).checkCodeOfLeaveType(code);
    checkerOf(userContext).checkDescriptionOfLeaveType(description);
    checkerOf(userContext).checkDetailDescriptionOfLeaveType(detailDescription);

    checkerOf(userContext).throwExceptionIfHasErrors(LeaveTypeManagerException.class);

    LeaveType leaveType = createNewLeaveType();

    leaveType.setCode(code);

    RetailStoreCountryCenter company =
        loadRetailStoreCountryCenter(userContext, companyId, emptyOptions());
    leaveType.setCompany(company);

    leaveType.setDescription(description);
    leaveType.setDetailDescription(detailDescription);

    leaveType = saveLeaveType(userContext, leaveType, emptyOptions());

    onNewInstanceCreated(userContext, leaveType);
    return leaveType;
  }

  protected LeaveType createNewLeaveType() {

    return new LeaveType();
  }

  protected void checkParamsForUpdatingLeaveType(
      RetailscmUserContext userContext,
      String leaveTypeId,
      int leaveTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);
    checkerOf(userContext).checkVersionOfLeaveType(leaveTypeVersion);

    if (LeaveType.CODE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkCodeOfLeaveType(parseString(newValueExpr));
    }

    if (LeaveType.DESCRIPTION_PROPERTY.equals(property)) {

      checkerOf(userContext).checkDescriptionOfLeaveType(parseString(newValueExpr));
    }
    if (LeaveType.DETAIL_DESCRIPTION_PROPERTY.equals(property)) {

      checkerOf(userContext).checkDetailDescriptionOfLeaveType(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(LeaveTypeManagerException.class);
  }

  public LeaveType clone(RetailscmUserContext userContext, String fromLeaveTypeId)
      throws Exception {

    return leaveTypeDaoOf(userContext).clone(fromLeaveTypeId, this.allTokens());
  }

  public LeaveType internalSaveLeaveType(RetailscmUserContext userContext, LeaveType leaveType)
      throws Exception {
    return internalSaveLeaveType(userContext, leaveType, allTokens());
  }

  public LeaveType internalSaveLeaveType(
      RetailscmUserContext userContext, LeaveType leaveType, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingLeaveType(userContext, leaveTypeId, leaveTypeVersion, property,
    // newValueExpr, tokensExpr);

    synchronized (leaveType) {
      // will be good when the leaveType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to LeaveType.
      if (leaveType.isChanged()) {}

      // checkerOf(userContext).checkAndFixLeaveType(leaveType);
      leaveType = saveLeaveType(userContext, leaveType, options);
      return leaveType;
    }
  }

  public LeaveType updateLeaveType(
      RetailscmUserContext userContext,
      String leaveTypeId,
      int leaveTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingLeaveType(
        userContext, leaveTypeId, leaveTypeVersion, property, newValueExpr, tokensExpr);

    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
    if (leaveType.getVersion() != leaveTypeVersion) {
      String message =
          "The target version("
              + leaveType.getVersion()
              + ") is not equals to version("
              + leaveTypeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (leaveType) {
      // will be good when the leaveType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to LeaveType.

      leaveType.changeProperty(property, newValueExpr);
      leaveType = saveLeaveType(userContext, leaveType, tokens().done());
      return present(userContext, leaveType, mergedAllTokens(tokensExpr));
      // return saveLeaveType(userContext, leaveType, tokens().done());
    }
  }

  public LeaveType updateLeaveTypeProperty(
      RetailscmUserContext userContext,
      String leaveTypeId,
      int leaveTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingLeaveType(
        userContext, leaveTypeId, leaveTypeVersion, property, newValueExpr, tokensExpr);

    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
    if (leaveType.getVersion() != leaveTypeVersion) {
      String message =
          "The target version("
              + leaveType.getVersion()
              + ") is not equals to version("
              + leaveTypeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (leaveType) {
      // will be good when the leaveType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to LeaveType.

      leaveType.changeProperty(property, newValueExpr);

      leaveType = saveLeaveType(userContext, leaveType, tokens().done());
      return present(userContext, leaveType, mergedAllTokens(tokensExpr));
      // return saveLeaveType(userContext, leaveType, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected LeaveTypeTokens tokens() {
    return LeaveTypeTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return LeaveTypeTokens.all();
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
        .sortEmployeeLeaveListWith(EmployeeLeave.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return LeaveTypeTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherCompany(
      RetailscmUserContext userContext, String leaveTypeId, String anotherCompanyId)
      throws Exception {

    checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);
    checkerOf(userContext)
        .checkIdOfRetailStoreCountryCenter(anotherCompanyId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(LeaveTypeManagerException.class);
  }

  public LeaveType transferToAnotherCompany(
      RetailscmUserContext userContext, String leaveTypeId, String anotherCompanyId)
      throws Exception {
    checkParamsForTransferingAnotherCompany(userContext, leaveTypeId, anotherCompanyId);

    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
    synchronized (leaveType) {
      // will be good when the leaveType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreCountryCenter company =
          loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());
      leaveType.updateCompany(company);

      leaveType = saveLeaveType(userContext, leaveType, emptyOptions());

      return present(userContext, leaveType, allTokens());
    }
  }

  public CandidateRetailStoreCountryCenter requestCandidateCompany(
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
            .requestCandidateRetailStoreCountryCenterForLeaveType(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected RetailStoreCountryCenter loadRetailStoreCountryCenter(
      RetailscmUserContext userContext, String newCompanyId, Map<String, Object> options)
      throws Exception {

    return retailStoreCountryCenterDaoOf(userContext).load(newCompanyId, options);
  }

  // --------------------------------------------------------------

  public LeaveType forgetByAll(
      RetailscmUserContext userContext, String leaveTypeId, int leaveTypeVersion) throws Exception {
    return forgetByAllInternal(userContext, leaveTypeId, leaveTypeVersion);
  }

  protected LeaveType forgetByAllInternal(
      RetailscmUserContext userContext, String leaveTypeId, int leaveTypeVersion) throws Exception {

    return leaveTypeDaoOf(userContext).disconnectFromAll(leaveTypeId, leaveTypeVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new LeaveTypeManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingEmployeeLeave(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String whoId,
      int leaveDurationHour,
      String remark,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);

    checkerOf(userContext).checkWhoIdOfEmployeeLeave(whoId);

    checkerOf(userContext).checkLeaveDurationHourOfEmployeeLeave(leaveDurationHour);

    checkerOf(userContext).checkRemarkOfEmployeeLeave(remark);

    checkerOf(userContext).throwExceptionIfHasErrors(LeaveTypeManagerException.class);
  }

  public LeaveType addEmployeeLeave(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String whoId,
      int leaveDurationHour,
      String remark,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingEmployeeLeave(
        userContext, leaveTypeId, whoId, leaveDurationHour, remark, tokensExpr);

    EmployeeLeave employeeLeave =
        createEmployeeLeave(userContext, whoId, leaveDurationHour, remark);

    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, emptyOptions());
    synchronized (leaveType) {
      // Will be good when the leaveType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      leaveType.addEmployeeLeave(employeeLeave);
      leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());

      employeeLeaveManagerOf(userContext).onNewInstanceCreated(userContext, employeeLeave);
      return present(userContext, leaveType, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingEmployeeLeaveProperties(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String id,
      int leaveDurationHour,
      String remark,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);
    checkerOf(userContext).checkIdOfEmployeeLeave(id);

    checkerOf(userContext).checkLeaveDurationHourOfEmployeeLeave(leaveDurationHour);
    checkerOf(userContext).checkRemarkOfEmployeeLeave(remark);

    checkerOf(userContext).throwExceptionIfHasErrors(LeaveTypeManagerException.class);
  }

  public LeaveType updateEmployeeLeaveProperties(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String id,
      int leaveDurationHour,
      String remark,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingEmployeeLeaveProperties(
        userContext, leaveTypeId, id, leaveDurationHour, remark, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withEmployeeLeaveListList()
            .searchEmployeeLeaveListWith(EmployeeLeave.ID_PROPERTY, tokens().is(), id)
            .done();

    LeaveType leaveTypeToUpdate = loadLeaveType(userContext, leaveTypeId, options);

    if (leaveTypeToUpdate.getEmployeeLeaveList().isEmpty()) {
      throw new LeaveTypeManagerException("EmployeeLeave is NOT FOUND with id: '" + id + "'");
    }

    EmployeeLeave item = leaveTypeToUpdate.getEmployeeLeaveList().first();
    beforeUpdateEmployeeLeaveProperties(
        userContext, item, leaveTypeId, id, leaveDurationHour, remark, tokensExpr);
    item.updateLeaveDurationHour(leaveDurationHour);
    item.updateRemark(remark);

    // checkParamsForAddingEmployeeLeave(userContext,leaveTypeId,name, code, used,tokensExpr);
    LeaveType leaveType =
        saveLeaveType(userContext, leaveTypeToUpdate, tokens().withEmployeeLeaveList().done());
    synchronized (leaveType) {
      return present(userContext, leaveType, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateEmployeeLeaveProperties(
      RetailscmUserContext userContext,
      EmployeeLeave item,
      String leaveTypeId,
      String id,
      int leaveDurationHour,
      String remark,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected EmployeeLeave createEmployeeLeave(
      RetailscmUserContext userContext, String whoId, int leaveDurationHour, String remark)
      throws Exception {

    EmployeeLeave employeeLeave = new EmployeeLeave();

    Employee who = new Employee();
    who.setId(whoId);
    employeeLeave.setWho(who);
    employeeLeave.setLeaveDurationHour(leaveDurationHour);
    employeeLeave.setRemark(remark);

    return employeeLeave;
  }

  protected EmployeeLeave createIndexedEmployeeLeave(String id, int version) {

    EmployeeLeave employeeLeave = new EmployeeLeave();
    employeeLeave.setId(id);
    employeeLeave.setVersion(version);
    return employeeLeave;
  }

  protected void checkParamsForRemovingEmployeeLeaveList(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String employeeLeaveIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);
    for (String employeeLeaveIdItem : employeeLeaveIds) {
      checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(LeaveTypeManagerException.class);
  }

  public LeaveType removeEmployeeLeaveList(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String employeeLeaveIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingEmployeeLeaveList(userContext, leaveTypeId, employeeLeaveIds, tokensExpr);

    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
    synchronized (leaveType) {
      // Will be good when the leaveType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      leaveTypeDaoOf(userContext)
          .planToRemoveEmployeeLeaveList(leaveType, employeeLeaveIds, allTokens());
      leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
      deleteRelationListInGraph(userContext, leaveType.getEmployeeLeaveList());
      return present(userContext, leaveType, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingEmployeeLeave(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String employeeLeaveId,
      int employeeLeaveVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);
    checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveId);
    checkerOf(userContext).checkVersionOfEmployeeLeave(employeeLeaveVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(LeaveTypeManagerException.class);
  }

  public LeaveType removeEmployeeLeave(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String employeeLeaveId,
      int employeeLeaveVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingEmployeeLeave(
        userContext, leaveTypeId, employeeLeaveId, employeeLeaveVersion, tokensExpr);

    EmployeeLeave employeeLeave = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
    synchronized (leaveType) {
      // Will be good when the leaveType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      leaveType.removeEmployeeLeave(employeeLeave);
      leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
      deleteRelationInGraph(userContext, employeeLeave);
      return present(userContext, leaveType, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingEmployeeLeave(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String employeeLeaveId,
      int employeeLeaveVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);
    checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveId);
    checkerOf(userContext).checkVersionOfEmployeeLeave(employeeLeaveVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(LeaveTypeManagerException.class);
  }

  public LeaveType copyEmployeeLeaveFrom(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String employeeLeaveId,
      int employeeLeaveVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingEmployeeLeave(
        userContext, leaveTypeId, employeeLeaveId, employeeLeaveVersion, tokensExpr);

    EmployeeLeave employeeLeave = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
    synchronized (leaveType) {
      // Will be good when the leaveType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      leaveType.copyEmployeeLeaveFrom(employeeLeave);
      leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());

      employeeLeaveManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (EmployeeLeave) leaveType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, leaveType, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingEmployeeLeave(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String employeeLeaveId,
      int employeeLeaveVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);
    checkerOf(userContext).checkIdOfEmployeeLeave(employeeLeaveId);
    checkerOf(userContext).checkVersionOfEmployeeLeave(employeeLeaveVersion);

    if (EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY.equals(property)) {
      checkerOf(userContext).checkLeaveDurationHourOfEmployeeLeave(parseInt(newValueExpr));
    }

    if (EmployeeLeave.REMARK_PROPERTY.equals(property)) {
      checkerOf(userContext).checkRemarkOfEmployeeLeave(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(LeaveTypeManagerException.class);
  }

  public LeaveType updateEmployeeLeave(
      RetailscmUserContext userContext,
      String leaveTypeId,
      String employeeLeaveId,
      int employeeLeaveVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingEmployeeLeave(
        userContext,
        leaveTypeId,
        employeeLeaveId,
        employeeLeaveVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withEmployeeLeaveList()
            .searchEmployeeLeaveListWith(
                EmployeeLeave.ID_PROPERTY, tokens().equals(), employeeLeaveId)
            .done();

    LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, loadTokens);

    synchronized (leaveType) {
      // Will be good when the leaveType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // leaveType.removeEmployeeLeave( employeeLeave );
      // make changes to AcceleraterAccount.
      EmployeeLeave employeeLeaveIdVersionKey =
          createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);

      EmployeeLeave employeeLeave = leaveType.findTheEmployeeLeave(employeeLeaveIdVersionKey);
      if (employeeLeave == null) {
        throw new LeaveTypeManagerException(employeeLeaveId + " is NOT FOUND");
      }

      beforeUpdateEmployeeLeave(
          userContext,
          employeeLeave,
          leaveTypeId,
          employeeLeaveId,
          employeeLeaveVersion,
          property,
          newValueExpr,
          tokensExpr);
      employeeLeave.changeProperty(property, newValueExpr);

      leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
      employeeLeaveManagerOf(userContext)
          .onUpdated(userContext, employeeLeave, this, "updateEmployeeLeave");
      return present(userContext, leaveType, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateEmployeeLeave(
      RetailscmUserContext userContext,
      EmployeeLeave existed,
      String leaveTypeId,
      String employeeLeaveId,
      int employeeLeaveVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, LeaveType newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    leaveTypeDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   LeaveType newLeaveType = this.createLeaveType(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newLeaveType
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
    key.put(UserApp.APP_TYPE_PROPERTY, LeaveType.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(RetailscmUserContext userContext, SmartList<LeaveType> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<RetailStoreCountryCenter> companyList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, RetailStoreCountryCenter.class);
    userContext.getDAOGroup().enhanceList(companyList, RetailStoreCountryCenter.class);
  }

  public Object listByCompany(RetailscmUserContext userContext, String companyId) throws Exception {
    return listPageByCompany(userContext, companyId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByCompany(
      RetailscmUserContext userContext, String companyId, int start, int count) throws Exception {
    SmartList<LeaveType> list =
        leaveTypeDaoOf(userContext)
            .findLeaveTypeByCompany(companyId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(LeaveType.class);
    page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("请假类型列表");
    page.setRequestName("listByCompany");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByCompany/%s/", getBeanName(), companyId)));

    page.assemblerContent(userContext, "listByCompany");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String leaveTypeId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    LeaveType merchantObj = (LeaveType) this.view(userContext, leaveTypeId);
    String merchantObjId = leaveTypeId;
    String linkToUrl = "leaveTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "请假类型" + "详情";
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
        MapUtil.put("id", "2-code")
            .put("fieldName", "code")
            .put("label", "代码")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("code", merchantObj.getCode());

    propList.add(
        MapUtil.put("id", "3-company")
            .put("fieldName", "company")
            .put("label", "公司")
            .put("type", "auto")
            .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("company", merchantObj.getCompany());

    propList.add(
        MapUtil.put("id", "4-description")
            .put("fieldName", "description")
            .put("label", "描述")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("description", merchantObj.getDescription());

    propList.add(
        MapUtil.put("id", "5-detailDescription")
            .put("fieldName", "detailDescription")
            .put("label", "详细描述")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("detailDescription", merchantObj.getDetailDescription());

    // 处理 sectionList

    // 处理Section：employeeLeaveListSection
    Map employeeLeaveListSection =
        ListofUtils.buildSection(
            "employeeLeaveListSection",
            "员工离开列表",
            null,
            "",
            "__no_group",
            "employeeLeaveManager/listByType/" + merchantObjId + "/",
            "auto");
    sections.add(employeeLeaveListSection);

    result.put(
        "employeeLeaveListSection",
        ListofUtils.toShortList(merchantObj.getEmployeeLeaveList(), "employeeLeave"));

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
