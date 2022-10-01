package com.doublechaintech.retailscm.salarygrade;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
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

public class SalaryGradeManagerImpl extends CustomRetailscmCheckerManager
    implements SalaryGradeManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens = SalaryGradeTokens.start().withTokenFromListName(listName).done();
    SalaryGrade salaryGrade = (SalaryGrade) this.loadSalaryGrade(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = salaryGrade.collectReferencesFromLists();
    salaryGradeDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, salaryGrade, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new SalaryGradeGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "SalaryGrade";

  @Override
  public SalaryGradeDAO daoOf(RetailscmUserContext userContext) {
    return salaryGradeDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws SalaryGradeManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new SalaryGradeManagerException(message);
  }

  protected SalaryGrade saveSalaryGrade(
      RetailscmUserContext userContext, SalaryGrade salaryGrade, String[] tokensExpr)
      throws Exception {
    // return getSalaryGradeDAO().save(salaryGrade, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveSalaryGrade(userContext, salaryGrade, tokens);
  }

  protected SalaryGrade saveSalaryGradeDetail(
      RetailscmUserContext userContext, SalaryGrade salaryGrade) throws Exception {

    return saveSalaryGrade(userContext, salaryGrade, allTokens());
  }

  public SalaryGrade loadSalaryGrade(
      RetailscmUserContext userContext, String salaryGradeId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, salaryGrade, tokens);
  }

  public SalaryGrade searchSalaryGrade(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, salaryGrade, tokens);
  }

  protected SalaryGrade present(
      RetailscmUserContext userContext, SalaryGrade salaryGrade, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, salaryGrade, tokens);

    SalaryGrade salaryGradeToPresent = salaryGradeDaoOf(userContext).present(salaryGrade, tokens);

    List<BaseEntity> entityListToNaming = salaryGradeToPresent.collectReferencesFromLists();
    salaryGradeDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, salaryGrade, tokens);

    return salaryGradeToPresent;
  }

  public SalaryGrade loadSalaryGradeDetail(RetailscmUserContext userContext, String salaryGradeId)
      throws Exception {
    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
    return present(userContext, salaryGrade, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String salaryGradeId) throws Exception {
    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, viewTokens());
    markVisited(userContext, salaryGrade);
    return present(userContext, salaryGrade, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String salaryGradeId)
      throws Exception {
    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, viewTokens());
    salaryGrade.summarySuffix();
    markVisited(userContext, salaryGrade);
    return present(userContext, salaryGrade, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String salaryGradeId) throws Exception {
    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, analyzeTokens());
    markVisited(userContext, salaryGrade);
    return present(userContext, salaryGrade, analyzeTokens());
  }

  protected SalaryGrade saveSalaryGrade(
      RetailscmUserContext userContext, SalaryGrade salaryGrade, Map<String, Object> tokens)
      throws Exception {

    return salaryGradeDaoOf(userContext).save(salaryGrade, tokens);
  }

  protected SalaryGrade loadSalaryGrade(
      RetailscmUserContext userContext, String salaryGradeId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);

    return salaryGradeDaoOf(userContext).load(salaryGradeId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, SalaryGrade salaryGrade, Map<String, Object> tokens) {
    super.addActions(userContext, salaryGrade, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, SalaryGrade salaryGrade, Map<String, Object> tokens){

  @Override
  public List<SalaryGrade> searchSalaryGradeList(
      RetailscmUserContext ctx, SalaryGradeRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<SalaryGrade> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public SalaryGrade searchSalaryGrade(RetailscmUserContext ctx, SalaryGradeRequest pRequest) {
    pRequest.limit(0, 1);
    List<SalaryGrade> list = searchSalaryGradeList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public SalaryGrade createSalaryGrade(
      RetailscmUserContext userContext,
      String code,
      String companyId,
      String name,
      String detailDescription)
      throws Exception {

    checkerOf(userContext).checkCodeOfSalaryGrade(code);
    checkerOf(userContext).checkNameOfSalaryGrade(name);
    checkerOf(userContext).checkDetailDescriptionOfSalaryGrade(detailDescription);

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);

    SalaryGrade salaryGrade = createNewSalaryGrade();

    salaryGrade.setCode(code);

    RetailStoreCountryCenter company =
        loadRetailStoreCountryCenter(userContext, companyId, emptyOptions());
    salaryGrade.setCompany(company);

    salaryGrade.setName(name);
    salaryGrade.setDetailDescription(detailDescription);

    salaryGrade = saveSalaryGrade(userContext, salaryGrade, emptyOptions());

    onNewInstanceCreated(userContext, salaryGrade);
    return salaryGrade;
  }

  protected SalaryGrade createNewSalaryGrade() {

    return new SalaryGrade();
  }

  protected void checkParamsForUpdatingSalaryGrade(
      RetailscmUserContext userContext,
      String salaryGradeId,
      int salaryGradeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
    checkerOf(userContext).checkVersionOfSalaryGrade(salaryGradeVersion);

    if (SalaryGrade.CODE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkCodeOfSalaryGrade(parseString(newValueExpr));
    }

    if (SalaryGrade.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfSalaryGrade(parseString(newValueExpr));
    }
    if (SalaryGrade.DETAIL_DESCRIPTION_PROPERTY.equals(property)) {

      checkerOf(userContext).checkDetailDescriptionOfSalaryGrade(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade clone(RetailscmUserContext userContext, String fromSalaryGradeId)
      throws Exception {

    return salaryGradeDaoOf(userContext).clone(fromSalaryGradeId, this.allTokens());
  }

  public SalaryGrade internalSaveSalaryGrade(
      RetailscmUserContext userContext, SalaryGrade salaryGrade) throws Exception {
    return internalSaveSalaryGrade(userContext, salaryGrade, allTokens());
  }

  public SalaryGrade internalSaveSalaryGrade(
      RetailscmUserContext userContext, SalaryGrade salaryGrade, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingSalaryGrade(userContext, salaryGradeId, salaryGradeVersion, property,
    // newValueExpr, tokensExpr);

    synchronized (salaryGrade) {
      // will be good when the salaryGrade loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to SalaryGrade.
      if (salaryGrade.isChanged()) {}

      // checkerOf(userContext).checkAndFixSalaryGrade(salaryGrade);
      salaryGrade = saveSalaryGrade(userContext, salaryGrade, options);
      return salaryGrade;
    }
  }

  public SalaryGrade updateSalaryGrade(
      RetailscmUserContext userContext,
      String salaryGradeId,
      int salaryGradeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingSalaryGrade(
        userContext, salaryGradeId, salaryGradeVersion, property, newValueExpr, tokensExpr);

    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
    if (salaryGrade.getVersion() != salaryGradeVersion) {
      String message =
          "The target version("
              + salaryGrade.getVersion()
              + ") is not equals to version("
              + salaryGradeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (salaryGrade) {
      // will be good when the salaryGrade loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to SalaryGrade.

      salaryGrade.changeProperty(property, newValueExpr);
      salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().done());
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
      // return saveSalaryGrade(userContext, salaryGrade, tokens().done());
    }
  }

  public SalaryGrade updateSalaryGradeProperty(
      RetailscmUserContext userContext,
      String salaryGradeId,
      int salaryGradeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingSalaryGrade(
        userContext, salaryGradeId, salaryGradeVersion, property, newValueExpr, tokensExpr);

    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
    if (salaryGrade.getVersion() != salaryGradeVersion) {
      String message =
          "The target version("
              + salaryGrade.getVersion()
              + ") is not equals to version("
              + salaryGradeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (salaryGrade) {
      // will be good when the salaryGrade loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to SalaryGrade.

      salaryGrade.changeProperty(property, newValueExpr);

      salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().done());
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
      // return saveSalaryGrade(userContext, salaryGrade, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected SalaryGradeTokens tokens() {
    return SalaryGradeTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return SalaryGradeTokens.all();
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
        .sortEmployeeListWith(Employee.ID_PROPERTY, sortDesc())
        .sortEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return SalaryGradeTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherCompany(
      RetailscmUserContext userContext, String salaryGradeId, String anotherCompanyId)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
    checkerOf(userContext)
        .checkIdOfRetailStoreCountryCenter(anotherCompanyId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade transferToAnotherCompany(
      RetailscmUserContext userContext, String salaryGradeId, String anotherCompanyId)
      throws Exception {
    checkParamsForTransferingAnotherCompany(userContext, salaryGradeId, anotherCompanyId);

    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
    synchronized (salaryGrade) {
      // will be good when the salaryGrade loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreCountryCenter company =
          loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());
      salaryGrade.updateCompany(company);

      salaryGrade = saveSalaryGrade(userContext, salaryGrade, emptyOptions());

      return present(userContext, salaryGrade, allTokens());
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
            .requestCandidateRetailStoreCountryCenterForSalaryGrade(
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

  public SalaryGrade forgetByAll(
      RetailscmUserContext userContext, String salaryGradeId, int salaryGradeVersion)
      throws Exception {
    return forgetByAllInternal(userContext, salaryGradeId, salaryGradeVersion);
  }

  protected SalaryGrade forgetByAllInternal(
      RetailscmUserContext userContext, String salaryGradeId, int salaryGradeVersion)
      throws Exception {

    return salaryGradeDaoOf(userContext).disconnectFromAll(salaryGradeId, salaryGradeVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new SalaryGradeManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingEmployee(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String companyId,
      String title,
      String departmentId,
      String familyName,
      String givenName,
      String email,
      String city,
      String address,
      String cellPhone,
      String occupationId,
      String responsibleForId,
      String salaryAccount,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);

    checkerOf(userContext).checkCompanyIdOfEmployee(companyId);

    checkerOf(userContext).checkTitleOfEmployee(title);

    checkerOf(userContext).checkDepartmentIdOfEmployee(departmentId);

    checkerOf(userContext).checkFamilyNameOfEmployee(familyName);

    checkerOf(userContext).checkGivenNameOfEmployee(givenName);

    checkerOf(userContext).checkEmailOfEmployee(email);

    checkerOf(userContext).checkCityOfEmployee(city);

    checkerOf(userContext).checkAddressOfEmployee(address);

    checkerOf(userContext).checkCellPhoneOfEmployee(cellPhone);

    checkerOf(userContext).checkOccupationIdOfEmployee(occupationId);

    checkerOf(userContext).checkResponsibleForIdOfEmployee(responsibleForId);

    checkerOf(userContext).checkSalaryAccountOfEmployee(salaryAccount);

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade addEmployee(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String companyId,
      String title,
      String departmentId,
      String familyName,
      String givenName,
      String email,
      String city,
      String address,
      String cellPhone,
      String occupationId,
      String responsibleForId,
      String salaryAccount,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingEmployee(
        userContext,
        salaryGradeId,
        companyId,
        title,
        departmentId,
        familyName,
        givenName,
        email,
        city,
        address,
        cellPhone,
        occupationId,
        responsibleForId,
        salaryAccount,
        tokensExpr);

    Employee employee =
        createEmployee(
            userContext,
            companyId,
            title,
            departmentId,
            familyName,
            givenName,
            email,
            city,
            address,
            cellPhone,
            occupationId,
            responsibleForId,
            salaryAccount);

    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, emptyOptions());
    synchronized (salaryGrade) {
      // Will be good when the salaryGrade loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      salaryGrade.addEmployee(employee);
      salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());

      employeeManagerOf(userContext).onNewInstanceCreated(userContext, employee);
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingEmployeeProperties(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String id,
      String title,
      String familyName,
      String givenName,
      String email,
      String city,
      String address,
      String cellPhone,
      String salaryAccount,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
    checkerOf(userContext).checkIdOfEmployee(id);

    checkerOf(userContext).checkTitleOfEmployee(title);
    checkerOf(userContext).checkFamilyNameOfEmployee(familyName);
    checkerOf(userContext).checkGivenNameOfEmployee(givenName);
    checkerOf(userContext).checkEmailOfEmployee(email);
    checkerOf(userContext).checkCityOfEmployee(city);
    checkerOf(userContext).checkAddressOfEmployee(address);
    checkerOf(userContext).checkCellPhoneOfEmployee(cellPhone);
    checkerOf(userContext).checkSalaryAccountOfEmployee(salaryAccount);

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade updateEmployeeProperties(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String id,
      String title,
      String familyName,
      String givenName,
      String email,
      String city,
      String address,
      String cellPhone,
      String salaryAccount,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingEmployeeProperties(
        userContext,
        salaryGradeId,
        id,
        title,
        familyName,
        givenName,
        email,
        city,
        address,
        cellPhone,
        salaryAccount,
        tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withEmployeeListList()
            .searchEmployeeListWith(Employee.ID_PROPERTY, tokens().is(), id)
            .done();

    SalaryGrade salaryGradeToUpdate = loadSalaryGrade(userContext, salaryGradeId, options);

    if (salaryGradeToUpdate.getEmployeeList().isEmpty()) {
      throw new SalaryGradeManagerException("Employee is NOT FOUND with id: '" + id + "'");
    }

    Employee item = salaryGradeToUpdate.getEmployeeList().first();
    beforeUpdateEmployeeProperties(
        userContext,
        item,
        salaryGradeId,
        id,
        title,
        familyName,
        givenName,
        email,
        city,
        address,
        cellPhone,
        salaryAccount,
        tokensExpr);
    item.updateTitle(title);
    item.updateFamilyName(familyName);
    item.updateGivenName(givenName);
    item.updateEmail(email);
    item.updateCity(city);
    item.updateAddress(address);
    item.updateCellPhone(cellPhone);
    item.updateSalaryAccount(salaryAccount);

    // checkParamsForAddingEmployee(userContext,salaryGradeId,name, code, used,tokensExpr);
    SalaryGrade salaryGrade =
        saveSalaryGrade(userContext, salaryGradeToUpdate, tokens().withEmployeeList().done());
    synchronized (salaryGrade) {
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateEmployeeProperties(
      RetailscmUserContext userContext,
      Employee item,
      String salaryGradeId,
      String id,
      String title,
      String familyName,
      String givenName,
      String email,
      String city,
      String address,
      String cellPhone,
      String salaryAccount,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected Employee createEmployee(
      RetailscmUserContext userContext,
      String companyId,
      String title,
      String departmentId,
      String familyName,
      String givenName,
      String email,
      String city,
      String address,
      String cellPhone,
      String occupationId,
      String responsibleForId,
      String salaryAccount)
      throws Exception {

    Employee employee = new Employee();

    RetailStoreCountryCenter company = new RetailStoreCountryCenter();
    company.setId(companyId);
    employee.setCompany(company);
    employee.setTitle(title);
    LevelThreeDepartment department = new LevelThreeDepartment();
    department.setId(departmentId);
    employee.setDepartment(department);
    employee.setFamilyName(familyName);
    employee.setGivenName(givenName);
    employee.setEmail(email);
    employee.setCity(city);
    employee.setAddress(address);
    employee.setCellPhone(cellPhone);
    OccupationType occupation = new OccupationType();
    occupation.setId(occupationId);
    employee.setOccupation(occupation);
    ResponsibilityType responsibleFor = new ResponsibilityType();
    responsibleFor.setId(responsibleForId);
    employee.setResponsibleFor(responsibleFor);
    employee.setSalaryAccount(salaryAccount);
    employee.setLastUpdateTime(userContext.now());

    return employee;
  }

  protected Employee createIndexedEmployee(String id, int version) {

    Employee employee = new Employee();
    employee.setId(id);
    employee.setVersion(version);
    return employee;
  }

  protected void checkParamsForRemovingEmployeeList(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
    for (String employeeIdItem : employeeIds) {
      checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade removeEmployeeList(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingEmployeeList(userContext, salaryGradeId, employeeIds, tokensExpr);

    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
    synchronized (salaryGrade) {
      // Will be good when the salaryGrade loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      salaryGradeDaoOf(userContext).planToRemoveEmployeeList(salaryGrade, employeeIds, allTokens());
      salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
      deleteRelationListInGraph(userContext, salaryGrade.getEmployeeList());
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingEmployee(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeId,
      int employeeVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
    checkerOf(userContext).checkIdOfEmployee(employeeId);
    checkerOf(userContext).checkVersionOfEmployee(employeeVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade removeEmployee(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeId,
      int employeeVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingEmployee(
        userContext, salaryGradeId, employeeId, employeeVersion, tokensExpr);

    Employee employee = createIndexedEmployee(employeeId, employeeVersion);
    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
    synchronized (salaryGrade) {
      // Will be good when the salaryGrade loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      salaryGrade.removeEmployee(employee);
      salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
      deleteRelationInGraph(userContext, employee);
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingEmployee(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeId,
      int employeeVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
    checkerOf(userContext).checkIdOfEmployee(employeeId);
    checkerOf(userContext).checkVersionOfEmployee(employeeVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade copyEmployeeFrom(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeId,
      int employeeVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingEmployee(
        userContext, salaryGradeId, employeeId, employeeVersion, tokensExpr);

    Employee employee = createIndexedEmployee(employeeId, employeeVersion);
    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
    synchronized (salaryGrade) {
      // Will be good when the salaryGrade loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      employee.updateLastUpdateTime(userContext.now());

      salaryGrade.copyEmployeeFrom(employee);
      salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());

      employeeManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (Employee) salaryGrade.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingEmployee(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeId,
      int employeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
    checkerOf(userContext).checkIdOfEmployee(employeeId);
    checkerOf(userContext).checkVersionOfEmployee(employeeVersion);

    if (Employee.TITLE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkTitleOfEmployee(parseString(newValueExpr));
    }

    if (Employee.FAMILY_NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkFamilyNameOfEmployee(parseString(newValueExpr));
    }

    if (Employee.GIVEN_NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkGivenNameOfEmployee(parseString(newValueExpr));
    }

    if (Employee.EMAIL_PROPERTY.equals(property)) {
      checkerOf(userContext).checkEmailOfEmployee(parseString(newValueExpr));
    }

    if (Employee.CITY_PROPERTY.equals(property)) {
      checkerOf(userContext).checkCityOfEmployee(parseString(newValueExpr));
    }

    if (Employee.ADDRESS_PROPERTY.equals(property)) {
      checkerOf(userContext).checkAddressOfEmployee(parseString(newValueExpr));
    }

    if (Employee.CELL_PHONE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkCellPhoneOfEmployee(parseString(newValueExpr));
    }

    if (Employee.SALARY_ACCOUNT_PROPERTY.equals(property)) {
      checkerOf(userContext).checkSalaryAccountOfEmployee(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade updateEmployee(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeId,
      int employeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingEmployee(
        userContext,
        salaryGradeId,
        employeeId,
        employeeVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withEmployeeList()
            .searchEmployeeListWith(Employee.ID_PROPERTY, tokens().equals(), employeeId)
            .done();

    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, loadTokens);

    synchronized (salaryGrade) {
      // Will be good when the salaryGrade loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // salaryGrade.removeEmployee( employee );
      // make changes to AcceleraterAccount.
      Employee employeeIdVersionKey = createIndexedEmployee(employeeId, employeeVersion);

      Employee employee = salaryGrade.findTheEmployee(employeeIdVersionKey);
      if (employee == null) {
        throw new SalaryGradeManagerException(employeeId + " is NOT FOUND");
      }

      beforeUpdateEmployee(
          userContext,
          employee,
          salaryGradeId,
          employeeId,
          employeeVersion,
          property,
          newValueExpr,
          tokensExpr);
      employee.changeProperty(property, newValueExpr);
      employee.updateLastUpdateTime(userContext.now());
      salaryGrade = saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeList().done());
      employeeManagerOf(userContext).onUpdated(userContext, employee, this, "updateEmployee");
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateEmployee(
      RetailscmUserContext userContext,
      Employee existed,
      String salaryGradeId,
      String employeeId,
      int employeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  protected void checkParamsForAddingEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeId,
      BigDecimal baseSalary,
      BigDecimal bonus,
      BigDecimal reward,
      BigDecimal personalTax,
      BigDecimal socialSecurity,
      BigDecimal housingFound,
      BigDecimal jobInsurance,
      String payingOffId,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);

    checkerOf(userContext).checkEmployeeIdOfEmployeeSalarySheet(employeeId);

    checkerOf(userContext).checkBaseSalaryOfEmployeeSalarySheet(baseSalary);

    checkerOf(userContext).checkBonusOfEmployeeSalarySheet(bonus);

    checkerOf(userContext).checkRewardOfEmployeeSalarySheet(reward);

    checkerOf(userContext).checkPersonalTaxOfEmployeeSalarySheet(personalTax);

    checkerOf(userContext).checkSocialSecurityOfEmployeeSalarySheet(socialSecurity);

    checkerOf(userContext).checkHousingFoundOfEmployeeSalarySheet(housingFound);

    checkerOf(userContext).checkJobInsuranceOfEmployeeSalarySheet(jobInsurance);

    checkerOf(userContext).checkPayingOffIdOfEmployeeSalarySheet(payingOffId);

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade addEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeId,
      BigDecimal baseSalary,
      BigDecimal bonus,
      BigDecimal reward,
      BigDecimal personalTax,
      BigDecimal socialSecurity,
      BigDecimal housingFound,
      BigDecimal jobInsurance,
      String payingOffId,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingEmployeeSalarySheet(
        userContext,
        salaryGradeId,
        employeeId,
        baseSalary,
        bonus,
        reward,
        personalTax,
        socialSecurity,
        housingFound,
        jobInsurance,
        payingOffId,
        tokensExpr);

    EmployeeSalarySheet employeeSalarySheet =
        createEmployeeSalarySheet(
            userContext,
            employeeId,
            baseSalary,
            bonus,
            reward,
            personalTax,
            socialSecurity,
            housingFound,
            jobInsurance,
            payingOffId);

    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, emptyOptions());
    synchronized (salaryGrade) {
      // Will be good when the salaryGrade loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      salaryGrade.addEmployeeSalarySheet(employeeSalarySheet);
      salaryGrade =
          saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());

      employeeSalarySheetManagerOf(userContext)
          .onNewInstanceCreated(userContext, employeeSalarySheet);
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingEmployeeSalarySheetProperties(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String id,
      BigDecimal baseSalary,
      BigDecimal bonus,
      BigDecimal reward,
      BigDecimal personalTax,
      BigDecimal socialSecurity,
      BigDecimal housingFound,
      BigDecimal jobInsurance,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
    checkerOf(userContext).checkIdOfEmployeeSalarySheet(id);

    checkerOf(userContext).checkBaseSalaryOfEmployeeSalarySheet(baseSalary);
    checkerOf(userContext).checkBonusOfEmployeeSalarySheet(bonus);
    checkerOf(userContext).checkRewardOfEmployeeSalarySheet(reward);
    checkerOf(userContext).checkPersonalTaxOfEmployeeSalarySheet(personalTax);
    checkerOf(userContext).checkSocialSecurityOfEmployeeSalarySheet(socialSecurity);
    checkerOf(userContext).checkHousingFoundOfEmployeeSalarySheet(housingFound);
    checkerOf(userContext).checkJobInsuranceOfEmployeeSalarySheet(jobInsurance);

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade updateEmployeeSalarySheetProperties(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String id,
      BigDecimal baseSalary,
      BigDecimal bonus,
      BigDecimal reward,
      BigDecimal personalTax,
      BigDecimal socialSecurity,
      BigDecimal housingFound,
      BigDecimal jobInsurance,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingEmployeeSalarySheetProperties(
        userContext,
        salaryGradeId,
        id,
        baseSalary,
        bonus,
        reward,
        personalTax,
        socialSecurity,
        housingFound,
        jobInsurance,
        tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withEmployeeSalarySheetListList()
            .searchEmployeeSalarySheetListWith(EmployeeSalarySheet.ID_PROPERTY, tokens().is(), id)
            .done();

    SalaryGrade salaryGradeToUpdate = loadSalaryGrade(userContext, salaryGradeId, options);

    if (salaryGradeToUpdate.getEmployeeSalarySheetList().isEmpty()) {
      throw new SalaryGradeManagerException(
          "EmployeeSalarySheet is NOT FOUND with id: '" + id + "'");
    }

    EmployeeSalarySheet item = salaryGradeToUpdate.getEmployeeSalarySheetList().first();
    beforeUpdateEmployeeSalarySheetProperties(
        userContext,
        item,
        salaryGradeId,
        id,
        baseSalary,
        bonus,
        reward,
        personalTax,
        socialSecurity,
        housingFound,
        jobInsurance,
        tokensExpr);
    item.updateBaseSalary(baseSalary);
    item.updateBonus(bonus);
    item.updateReward(reward);
    item.updatePersonalTax(personalTax);
    item.updateSocialSecurity(socialSecurity);
    item.updateHousingFound(housingFound);
    item.updateJobInsurance(jobInsurance);

    // checkParamsForAddingEmployeeSalarySheet(userContext,salaryGradeId,name, code,
    // used,tokensExpr);
    SalaryGrade salaryGrade =
        saveSalaryGrade(
            userContext, salaryGradeToUpdate, tokens().withEmployeeSalarySheetList().done());
    synchronized (salaryGrade) {
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateEmployeeSalarySheetProperties(
      RetailscmUserContext userContext,
      EmployeeSalarySheet item,
      String salaryGradeId,
      String id,
      BigDecimal baseSalary,
      BigDecimal bonus,
      BigDecimal reward,
      BigDecimal personalTax,
      BigDecimal socialSecurity,
      BigDecimal housingFound,
      BigDecimal jobInsurance,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected EmployeeSalarySheet createEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String employeeId,
      BigDecimal baseSalary,
      BigDecimal bonus,
      BigDecimal reward,
      BigDecimal personalTax,
      BigDecimal socialSecurity,
      BigDecimal housingFound,
      BigDecimal jobInsurance,
      String payingOffId)
      throws Exception {

    EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();

    Employee employee = new Employee();
    employee.setId(employeeId);
    employeeSalarySheet.setEmployee(employee);
    employeeSalarySheet.setBaseSalary(baseSalary);
    employeeSalarySheet.setBonus(bonus);
    employeeSalarySheet.setReward(reward);
    employeeSalarySheet.setPersonalTax(personalTax);
    employeeSalarySheet.setSocialSecurity(socialSecurity);
    employeeSalarySheet.setHousingFound(housingFound);
    employeeSalarySheet.setJobInsurance(jobInsurance);
    PayingOff payingOff = new PayingOff();
    payingOff.setId(payingOffId);
    employeeSalarySheet.setPayingOff(payingOff);

    return employeeSalarySheet;
  }

  protected EmployeeSalarySheet createIndexedEmployeeSalarySheet(String id, int version) {

    EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
    employeeSalarySheet.setId(id);
    employeeSalarySheet.setVersion(version);
    return employeeSalarySheet;
  }

  protected void checkParamsForRemovingEmployeeSalarySheetList(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeSalarySheetIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
    for (String employeeSalarySheetIdItem : employeeSalarySheetIds) {
      checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade removeEmployeeSalarySheetList(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeSalarySheetIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingEmployeeSalarySheetList(
        userContext, salaryGradeId, employeeSalarySheetIds, tokensExpr);

    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
    synchronized (salaryGrade) {
      // Will be good when the salaryGrade loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      salaryGradeDaoOf(userContext)
          .planToRemoveEmployeeSalarySheetList(salaryGrade, employeeSalarySheetIds, allTokens());
      salaryGrade =
          saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
      deleteRelationListInGraph(userContext, salaryGrade.getEmployeeSalarySheetList());
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeSalarySheetId,
      int employeeSalarySheetVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
    checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
    checkerOf(userContext).checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade removeEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeSalarySheetId,
      int employeeSalarySheetVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingEmployeeSalarySheet(
        userContext, salaryGradeId, employeeSalarySheetId, employeeSalarySheetVersion, tokensExpr);

    EmployeeSalarySheet employeeSalarySheet =
        createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
    synchronized (salaryGrade) {
      // Will be good when the salaryGrade loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      salaryGrade.removeEmployeeSalarySheet(employeeSalarySheet);
      salaryGrade =
          saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
      deleteRelationInGraph(userContext, employeeSalarySheet);
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeSalarySheetId,
      int employeeSalarySheetVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
    checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
    checkerOf(userContext).checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade copyEmployeeSalarySheetFrom(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeSalarySheetId,
      int employeeSalarySheetVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingEmployeeSalarySheet(
        userContext, salaryGradeId, employeeSalarySheetId, employeeSalarySheetVersion, tokensExpr);

    EmployeeSalarySheet employeeSalarySheet =
        createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);
    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, allTokens());
    synchronized (salaryGrade) {
      // Will be good when the salaryGrade loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      salaryGrade.copyEmployeeSalarySheetFrom(employeeSalarySheet);
      salaryGrade =
          saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());

      employeeSalarySheetManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (EmployeeSalarySheet) salaryGrade.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeSalarySheetId,
      int employeeSalarySheetVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
    checkerOf(userContext).checkIdOfEmployeeSalarySheet(employeeSalarySheetId);
    checkerOf(userContext).checkVersionOfEmployeeSalarySheet(employeeSalarySheetVersion);

    if (EmployeeSalarySheet.BASE_SALARY_PROPERTY.equals(property)) {
      checkerOf(userContext).checkBaseSalaryOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
    }

    if (EmployeeSalarySheet.BONUS_PROPERTY.equals(property)) {
      checkerOf(userContext).checkBonusOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
    }

    if (EmployeeSalarySheet.REWARD_PROPERTY.equals(property)) {
      checkerOf(userContext).checkRewardOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
    }

    if (EmployeeSalarySheet.PERSONAL_TAX_PROPERTY.equals(property)) {
      checkerOf(userContext).checkPersonalTaxOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
    }

    if (EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY.equals(property)) {
      checkerOf(userContext)
          .checkSocialSecurityOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
    }

    if (EmployeeSalarySheet.HOUSING_FOUND_PROPERTY.equals(property)) {
      checkerOf(userContext).checkHousingFoundOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
    }

    if (EmployeeSalarySheet.JOB_INSURANCE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkJobInsuranceOfEmployeeSalarySheet(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(SalaryGradeManagerException.class);
  }

  public SalaryGrade updateEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeSalarySheetId,
      int employeeSalarySheetVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingEmployeeSalarySheet(
        userContext,
        salaryGradeId,
        employeeSalarySheetId,
        employeeSalarySheetVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withEmployeeSalarySheetList()
            .searchEmployeeSalarySheetListWith(
                EmployeeSalarySheet.ID_PROPERTY, tokens().equals(), employeeSalarySheetId)
            .done();

    SalaryGrade salaryGrade = loadSalaryGrade(userContext, salaryGradeId, loadTokens);

    synchronized (salaryGrade) {
      // Will be good when the salaryGrade loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // salaryGrade.removeEmployeeSalarySheet( employeeSalarySheet );
      // make changes to AcceleraterAccount.
      EmployeeSalarySheet employeeSalarySheetIdVersionKey =
          createIndexedEmployeeSalarySheet(employeeSalarySheetId, employeeSalarySheetVersion);

      EmployeeSalarySheet employeeSalarySheet =
          salaryGrade.findTheEmployeeSalarySheet(employeeSalarySheetIdVersionKey);
      if (employeeSalarySheet == null) {
        throw new SalaryGradeManagerException(employeeSalarySheetId + " is NOT FOUND");
      }

      beforeUpdateEmployeeSalarySheet(
          userContext,
          employeeSalarySheet,
          salaryGradeId,
          employeeSalarySheetId,
          employeeSalarySheetVersion,
          property,
          newValueExpr,
          tokensExpr);
      employeeSalarySheet.changeProperty(property, newValueExpr);

      salaryGrade =
          saveSalaryGrade(userContext, salaryGrade, tokens().withEmployeeSalarySheetList().done());
      employeeSalarySheetManagerOf(userContext)
          .onUpdated(userContext, employeeSalarySheet, this, "updateEmployeeSalarySheet");
      return present(userContext, salaryGrade, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateEmployeeSalarySheet(
      RetailscmUserContext userContext,
      EmployeeSalarySheet existed,
      String salaryGradeId,
      String employeeSalarySheetId,
      int employeeSalarySheetVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, SalaryGrade newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    salaryGradeDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   SalaryGrade newSalaryGrade = this.createSalaryGrade(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newSalaryGrade
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
    key.put(UserApp.APP_TYPE_PROPERTY, SalaryGrade.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(RetailscmUserContext userContext, SmartList<SalaryGrade> list)
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
    SmartList<SalaryGrade> list =
        salaryGradeDaoOf(userContext)
            .findSalaryGradeByCompany(companyId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(SalaryGrade.class);
    page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("工资等级列表");
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
  public Object wxappview(RetailscmUserContext userContext, String salaryGradeId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    SalaryGrade merchantObj = (SalaryGrade) this.view(userContext, salaryGradeId);
    String merchantObjId = salaryGradeId;
    String linkToUrl = "salaryGradeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "工资等级" + "详情";
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
        MapUtil.put("id", "4-name")
            .put("fieldName", "name")
            .put("label", "名称")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("name", merchantObj.getName());

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

    // 处理Section：employeeListSection
    Map employeeListSection =
        ListofUtils.buildSection(
            "employeeListSection",
            "员工列表",
            null,
            "",
            "__no_group",
            "employeeManager/listByCurrentSalaryGrade/" + merchantObjId + "/",
            "auto");
    sections.add(employeeListSection);

    result.put(
        "employeeListSection", ListofUtils.toShortList(merchantObj.getEmployeeList(), "employee"));

    // 处理Section：employeeSalarySheetListSection
    Map employeeSalarySheetListSection =
        ListofUtils.buildSection(
            "employeeSalarySheetListSection",
            "员工工资表",
            null,
            "",
            "__no_group",
            "employeeSalarySheetManager/listByCurrentSalaryGrade/" + merchantObjId + "/",
            "auto");
    sections.add(employeeSalarySheetListSection);

    result.put(
        "employeeSalarySheetListSection",
        ListofUtils.toShortList(merchantObj.getEmployeeSalarySheetList(), "employeeSalarySheet"));

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
