package com.doublechaintech.retailscm.employeecompanytraining;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.companytraining.CandidateCompanyTraining;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.employee.CandidateEmployee;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.scoring.CandidateScoring;
import com.doublechaintech.retailscm.scoring.Scoring;
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

public class EmployeeCompanyTrainingManagerImpl extends CustomRetailscmCheckerManager
    implements EmployeeCompanyTrainingManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "EmployeeCompanyTraining";

  @Override
  public EmployeeCompanyTrainingDAO daoOf(RetailscmUserContext userContext) {
    return employeeCompanyTrainingDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws EmployeeCompanyTrainingManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new EmployeeCompanyTrainingManagerException(message);
  }

  protected EmployeeCompanyTraining saveEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      EmployeeCompanyTraining employeeCompanyTraining,
      String[] tokensExpr)
      throws Exception {
    // return getEmployeeCompanyTrainingDAO().save(employeeCompanyTraining, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens);
  }

  protected EmployeeCompanyTraining saveEmployeeCompanyTrainingDetail(
      RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining)
      throws Exception {

    return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, allTokens());
  }

  public EmployeeCompanyTraining loadEmployeeCompanyTraining(
      RetailscmUserContext userContext, String employeeCompanyTrainingId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    EmployeeCompanyTraining employeeCompanyTraining =
        loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, tokens);
    // do some calc before sent to customer?
    return present(userContext, employeeCompanyTraining, tokens);
  }

  public EmployeeCompanyTraining searchEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      String employeeCompanyTrainingId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    EmployeeCompanyTraining employeeCompanyTraining =
        loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, tokens);
    // do some calc before sent to customer?
    return present(userContext, employeeCompanyTraining, tokens);
  }

  protected EmployeeCompanyTraining present(
      RetailscmUserContext userContext,
      EmployeeCompanyTraining employeeCompanyTraining,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, employeeCompanyTraining, tokens);

    EmployeeCompanyTraining employeeCompanyTrainingToPresent =
        employeeCompanyTrainingDaoOf(userContext).present(employeeCompanyTraining, tokens);

    List<BaseEntity> entityListToNaming =
        employeeCompanyTrainingToPresent.collectReferencesFromLists();
    employeeCompanyTrainingDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, employeeCompanyTraining, tokens);

    return employeeCompanyTrainingToPresent;
  }

  public EmployeeCompanyTraining loadEmployeeCompanyTrainingDetail(
      RetailscmUserContext userContext, String employeeCompanyTrainingId) throws Exception {
    EmployeeCompanyTraining employeeCompanyTraining =
        loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());
    return present(userContext, employeeCompanyTraining, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String employeeCompanyTrainingId)
      throws Exception {
    EmployeeCompanyTraining employeeCompanyTraining =
        loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, viewTokens());
    markVisited(userContext, employeeCompanyTraining);
    return present(userContext, employeeCompanyTraining, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String employeeCompanyTrainingId)
      throws Exception {
    EmployeeCompanyTraining employeeCompanyTraining =
        loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, viewTokens());
    employeeCompanyTraining.summarySuffix();
    markVisited(userContext, employeeCompanyTraining);
    return present(userContext, employeeCompanyTraining, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String employeeCompanyTrainingId)
      throws Exception {
    EmployeeCompanyTraining employeeCompanyTraining =
        loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, analyzeTokens());
    markVisited(userContext, employeeCompanyTraining);
    return present(userContext, employeeCompanyTraining, analyzeTokens());
  }

  protected EmployeeCompanyTraining saveEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      EmployeeCompanyTraining employeeCompanyTraining,
      Map<String, Object> tokens)
      throws Exception {

    return employeeCompanyTrainingDaoOf(userContext).save(employeeCompanyTraining, tokens);
  }

  protected EmployeeCompanyTraining loadEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      String employeeCompanyTrainingId,
      Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);

    return employeeCompanyTrainingDaoOf(userContext).load(employeeCompanyTrainingId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      EmployeeCompanyTraining employeeCompanyTraining,
      Map<String, Object> tokens) {
    super.addActions(userContext, employeeCompanyTraining, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String, Object> tokens){

  @Override
  public List<EmployeeCompanyTraining> searchEmployeeCompanyTrainingList(
      RetailscmUserContext ctx, EmployeeCompanyTrainingRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<EmployeeCompanyTraining> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public EmployeeCompanyTraining searchEmployeeCompanyTraining(
      RetailscmUserContext ctx, EmployeeCompanyTrainingRequest pRequest) {
    pRequest.limit(0, 1);
    List<EmployeeCompanyTraining> list = searchEmployeeCompanyTrainingList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public EmployeeCompanyTraining createEmployeeCompanyTraining(
      RetailscmUserContext userContext, String employeeId, String trainingId, String scoringId)
      throws Exception {

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);

    EmployeeCompanyTraining employeeCompanyTraining = createNewEmployeeCompanyTraining();

    Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
    employeeCompanyTraining.setEmployee(employee);

    CompanyTraining training = loadCompanyTraining(userContext, trainingId, emptyOptions());
    employeeCompanyTraining.setTraining(training);

    Scoring scoring = loadScoring(userContext, scoringId, emptyOptions());
    employeeCompanyTraining.setScoring(scoring);

    employeeCompanyTraining =
        saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());

    onNewInstanceCreated(userContext, employeeCompanyTraining);
    return employeeCompanyTraining;
  }

  protected EmployeeCompanyTraining createNewEmployeeCompanyTraining() {

    return new EmployeeCompanyTraining();
  }

  protected void checkParamsForUpdatingEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      String employeeCompanyTrainingId,
      int employeeCompanyTrainingVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
    checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);
  }

  public EmployeeCompanyTraining clone(
      RetailscmUserContext userContext, String fromEmployeeCompanyTrainingId) throws Exception {

    return employeeCompanyTrainingDaoOf(userContext)
        .clone(fromEmployeeCompanyTrainingId, this.allTokens());
  }

  public EmployeeCompanyTraining internalSaveEmployeeCompanyTraining(
      RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining)
      throws Exception {
    return internalSaveEmployeeCompanyTraining(userContext, employeeCompanyTraining, allTokens());
  }

  public EmployeeCompanyTraining internalSaveEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      EmployeeCompanyTraining employeeCompanyTraining,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingEmployeeCompanyTraining(userContext, employeeCompanyTrainingId,
    // employeeCompanyTrainingVersion, property, newValueExpr, tokensExpr);

    synchronized (employeeCompanyTraining) {
      // will be good when the employeeCompanyTraining loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to EmployeeCompanyTraining.
      if (employeeCompanyTraining.isChanged()) {}

      // checkerOf(userContext).checkAndFixEmployeeCompanyTraining(employeeCompanyTraining);
      employeeCompanyTraining =
          saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, options);
      return employeeCompanyTraining;
    }
  }

  public EmployeeCompanyTraining updateEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      String employeeCompanyTrainingId,
      int employeeCompanyTrainingVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingEmployeeCompanyTraining(
        userContext,
        employeeCompanyTrainingId,
        employeeCompanyTrainingVersion,
        property,
        newValueExpr,
        tokensExpr);

    EmployeeCompanyTraining employeeCompanyTraining =
        loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());
    if (employeeCompanyTraining.getVersion() != employeeCompanyTrainingVersion) {
      String message =
          "The target version("
              + employeeCompanyTraining.getVersion()
              + ") is not equals to version("
              + employeeCompanyTrainingVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (employeeCompanyTraining) {
      // will be good when the employeeCompanyTraining loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to EmployeeCompanyTraining.

      employeeCompanyTraining.changeProperty(property, newValueExpr);
      employeeCompanyTraining =
          saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
      return present(userContext, employeeCompanyTraining, mergedAllTokens(tokensExpr));
      // return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
    }
  }

  public EmployeeCompanyTraining updateEmployeeCompanyTrainingProperty(
      RetailscmUserContext userContext,
      String employeeCompanyTrainingId,
      int employeeCompanyTrainingVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingEmployeeCompanyTraining(
        userContext,
        employeeCompanyTrainingId,
        employeeCompanyTrainingVersion,
        property,
        newValueExpr,
        tokensExpr);

    EmployeeCompanyTraining employeeCompanyTraining =
        loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());
    if (employeeCompanyTraining.getVersion() != employeeCompanyTrainingVersion) {
      String message =
          "The target version("
              + employeeCompanyTraining.getVersion()
              + ") is not equals to version("
              + employeeCompanyTrainingVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (employeeCompanyTraining) {
      // will be good when the employeeCompanyTraining loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to EmployeeCompanyTraining.

      employeeCompanyTraining.changeProperty(property, newValueExpr);

      employeeCompanyTraining =
          saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
      return present(userContext, employeeCompanyTraining, mergedAllTokens(tokensExpr));
      // return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected EmployeeCompanyTrainingTokens tokens() {
    return EmployeeCompanyTrainingTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return EmployeeCompanyTrainingTokens.all();
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
    return EmployeeCompanyTrainingTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherEmployee(
      RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherEmployeeId)
      throws Exception {

    checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
    checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);
  }

  public EmployeeCompanyTraining transferToAnotherEmployee(
      RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherEmployeeId)
      throws Exception {
    checkParamsForTransferingAnotherEmployee(
        userContext, employeeCompanyTrainingId, anotherEmployeeId);

    EmployeeCompanyTraining employeeCompanyTraining =
        loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());
    synchronized (employeeCompanyTraining) {
      // will be good when the employeeCompanyTraining loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());
      employeeCompanyTraining.updateEmployee(employee);

      employeeCompanyTraining =
          saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());

      return present(userContext, employeeCompanyTraining, allTokens());
    }
  }

  public CandidateEmployee requestCandidateEmployee(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateEmployee result = new CandidateEmployee();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("company");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<Employee> candidateList =
        employeeDaoOf(userContext)
            .requestCandidateEmployeeForEmployeeCompanyTraining(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  protected void checkParamsForTransferingAnotherTraining(
      RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherTrainingId)
      throws Exception {

    checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
    checkerOf(userContext)
        .checkIdOfCompanyTraining(anotherTrainingId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);
  }

  public EmployeeCompanyTraining transferToAnotherTraining(
      RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherTrainingId)
      throws Exception {
    checkParamsForTransferingAnotherTraining(
        userContext, employeeCompanyTrainingId, anotherTrainingId);

    EmployeeCompanyTraining employeeCompanyTraining =
        loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());
    synchronized (employeeCompanyTraining) {
      // will be good when the employeeCompanyTraining loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      CompanyTraining training =
          loadCompanyTraining(userContext, anotherTrainingId, emptyOptions());
      employeeCompanyTraining.updateTraining(training);

      employeeCompanyTraining =
          saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());

      return present(userContext, employeeCompanyTraining, allTokens());
    }
  }

  public CandidateCompanyTraining requestCandidateTraining(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateCompanyTraining result = new CandidateCompanyTraining();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("title");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<CompanyTraining> candidateList =
        companyTrainingDaoOf(userContext)
            .requestCandidateCompanyTrainingForEmployeeCompanyTraining(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  protected void checkParamsForTransferingAnotherScoring(
      RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherScoringId)
      throws Exception {

    checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
    checkerOf(userContext).checkIdOfScoring(anotherScoringId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);
  }

  public EmployeeCompanyTraining transferToAnotherScoring(
      RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherScoringId)
      throws Exception {
    checkParamsForTransferingAnotherScoring(
        userContext, employeeCompanyTrainingId, anotherScoringId);

    EmployeeCompanyTraining employeeCompanyTraining =
        loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());
    synchronized (employeeCompanyTraining) {
      // will be good when the employeeCompanyTraining loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      Scoring scoring = loadScoring(userContext, anotherScoringId, emptyOptions());
      employeeCompanyTraining.updateScoring(scoring);

      employeeCompanyTraining =
          saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());

      return present(userContext, employeeCompanyTraining, allTokens());
    }
  }

  public CandidateScoring requestCandidateScoring(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateScoring result = new CandidateScoring();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("scoredBy");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<Scoring> candidateList =
        scoringDaoOf(userContext)
            .requestCandidateScoringForEmployeeCompanyTraining(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected Employee loadEmployee(
      RetailscmUserContext userContext, String newEmployeeId, Map<String, Object> options)
      throws Exception {

    return employeeDaoOf(userContext).load(newEmployeeId, options);
  }

  protected Scoring loadScoring(
      RetailscmUserContext userContext, String newScoringId, Map<String, Object> options)
      throws Exception {

    return scoringDaoOf(userContext).load(newScoringId, options);
  }

  protected CompanyTraining loadCompanyTraining(
      RetailscmUserContext userContext, String newTrainingId, Map<String, Object> options)
      throws Exception {

    return companyTrainingDaoOf(userContext).load(newTrainingId, options);
  }

  // --------------------------------------------------------------

  public EmployeeCompanyTraining forgetByAll(
      RetailscmUserContext userContext,
      String employeeCompanyTrainingId,
      int employeeCompanyTrainingVersion)
      throws Exception {
    return forgetByAllInternal(
        userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion);
  }

  protected EmployeeCompanyTraining forgetByAllInternal(
      RetailscmUserContext userContext,
      String employeeCompanyTrainingId,
      int employeeCompanyTrainingVersion)
      throws Exception {

    return employeeCompanyTrainingDaoOf(userContext)
        .disconnectFromAll(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new EmployeeCompanyTrainingManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, EmployeeCompanyTraining newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    employeeCompanyTrainingDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   EmployeeCompanyTraining newEmployeeCompanyTraining =
    // this.createEmployeeCompanyTraining(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newEmployeeCompanyTraining
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
    key.put(UserApp.APP_TYPE_PROPERTY, EmployeeCompanyTraining.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<EmployeeCompanyTraining> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<Employee> employeeList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Employee.class);
    userContext.getDAOGroup().enhanceList(employeeList, Employee.class);
    List<CompanyTraining> trainingList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, CompanyTraining.class);
    userContext.getDAOGroup().enhanceList(trainingList, CompanyTraining.class);
    List<Scoring> scoringList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Scoring.class);
    userContext.getDAOGroup().enhanceList(scoringList, Scoring.class);
  }

  public Object listByEmployee(RetailscmUserContext userContext, String employeeId)
      throws Exception {
    return listPageByEmployee(userContext, employeeId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByEmployee(
      RetailscmUserContext userContext, String employeeId, int start, int count) throws Exception {
    SmartList<EmployeeCompanyTraining> list =
        employeeCompanyTrainingDaoOf(userContext)
            .findEmployeeCompanyTrainingByEmployee(employeeId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(EmployeeCompanyTraining.class);
    page.setContainerObject(Employee.withId(employeeId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("员工参与的公司培训列表");
    page.setRequestName("listByEmployee");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByEmployee/%s/", getBeanName(), employeeId)));

    page.assemblerContent(userContext, "listByEmployee");
    return page.doRender(userContext);
  }

  public Object listByTraining(RetailscmUserContext userContext, String trainingId)
      throws Exception {
    return listPageByTraining(userContext, trainingId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByTraining(
      RetailscmUserContext userContext, String trainingId, int start, int count) throws Exception {
    SmartList<EmployeeCompanyTraining> list =
        employeeCompanyTrainingDaoOf(userContext)
            .findEmployeeCompanyTrainingByTraining(trainingId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(EmployeeCompanyTraining.class);
    page.setContainerObject(CompanyTraining.withId(trainingId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("员工参与的公司培训列表");
    page.setRequestName("listByTraining");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByTraining/%s/", getBeanName(), trainingId)));

    page.assemblerContent(userContext, "listByTraining");
    return page.doRender(userContext);
  }

  public Object listByScoring(RetailscmUserContext userContext, String scoringId) throws Exception {
    return listPageByScoring(userContext, scoringId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByScoring(
      RetailscmUserContext userContext, String scoringId, int start, int count) throws Exception {
    SmartList<EmployeeCompanyTraining> list =
        employeeCompanyTrainingDaoOf(userContext)
            .findEmployeeCompanyTrainingByScoring(scoringId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(EmployeeCompanyTraining.class);
    page.setContainerObject(Scoring.withId(scoringId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("员工参与的公司培训列表");
    page.setRequestName("listByScoring");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByScoring/%s/", getBeanName(), scoringId)));

    page.assemblerContent(userContext, "listByScoring");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String employeeCompanyTrainingId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    EmployeeCompanyTraining merchantObj =
        (EmployeeCompanyTraining) this.view(userContext, employeeCompanyTrainingId);
    String merchantObjId = employeeCompanyTrainingId;
    String linkToUrl = "employeeCompanyTrainingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工参与的公司培训" + "详情";
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
        MapUtil.put("id", "2-employee")
            .put("fieldName", "employee")
            .put("label", "员工")
            .put("type", "auto")
            .put("linkToUrl", "employeeManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"family_name\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
            .into_map());
    result.put("employee", merchantObj.getEmployee());

    propList.add(
        MapUtil.put("id", "3-training")
            .put("fieldName", "training")
            .put("label", "训练")
            .put("type", "auto")
            .put("linkToUrl", "companyTrainingManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"duration_hours\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
            .into_map());
    result.put("training", merchantObj.getTraining());

    propList.add(
        MapUtil.put("id", "4-scoring")
            .put("fieldName", "scoring")
            .put("label", "评分")
            .put("type", "auto")
            .put("linkToUrl", "scoringManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"score\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"scored_by\",\"imageList\":\"\"}")
            .into_map());
    result.put("scoring", merchantObj.getScoring());

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
