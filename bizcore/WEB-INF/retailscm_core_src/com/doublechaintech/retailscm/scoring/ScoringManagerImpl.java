package com.doublechaintech.retailscm.scoring;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.iamservice.*;
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

public class ScoringManagerImpl extends CustomRetailscmCheckerManager
    implements ScoringManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens = ScoringTokens.start().withTokenFromListName(listName).done();
    Scoring scoring = (Scoring) this.loadScoring(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = scoring.collectReferencesFromLists();
    scoringDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, scoring, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new ScoringGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "Scoring";

  @Override
  public ScoringDAO daoOf(RetailscmUserContext userContext) {
    return scoringDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws ScoringManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new ScoringManagerException(message);
  }

  protected Scoring saveScoring(
      RetailscmUserContext userContext, Scoring scoring, String[] tokensExpr) throws Exception {
    // return getScoringDAO().save(scoring, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveScoring(userContext, scoring, tokens);
  }

  protected Scoring saveScoringDetail(RetailscmUserContext userContext, Scoring scoring)
      throws Exception {

    return saveScoring(userContext, scoring, allTokens());
  }

  public Scoring loadScoring(
      RetailscmUserContext userContext, String scoringId, String[] tokensExpr) throws Exception {

    checkerOf(userContext).checkIdOfScoring(scoringId);

    checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    Scoring scoring = loadScoring(userContext, scoringId, tokens);
    // do some calc before sent to customer?
    return present(userContext, scoring, tokens);
  }

  public Scoring searchScoring(
      RetailscmUserContext userContext, String scoringId, String textToSearch, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfScoring(scoringId);

    checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    Scoring scoring = loadScoring(userContext, scoringId, tokens);
    // do some calc before sent to customer?
    return present(userContext, scoring, tokens);
  }

  protected Scoring present(
      RetailscmUserContext userContext, Scoring scoring, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, scoring, tokens);

    Scoring scoringToPresent = scoringDaoOf(userContext).present(scoring, tokens);

    List<BaseEntity> entityListToNaming = scoringToPresent.collectReferencesFromLists();
    scoringDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, scoring, tokens);

    return scoringToPresent;
  }

  public Scoring loadScoringDetail(RetailscmUserContext userContext, String scoringId)
      throws Exception {
    Scoring scoring = loadScoring(userContext, scoringId, allTokens());
    return present(userContext, scoring, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String scoringId) throws Exception {
    Scoring scoring = loadScoring(userContext, scoringId, viewTokens());
    markVisited(userContext, scoring);
    return present(userContext, scoring, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String scoringId) throws Exception {
    Scoring scoring = loadScoring(userContext, scoringId, viewTokens());
    scoring.summarySuffix();
    markVisited(userContext, scoring);
    return present(userContext, scoring, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String scoringId) throws Exception {
    Scoring scoring = loadScoring(userContext, scoringId, analyzeTokens());
    markVisited(userContext, scoring);
    return present(userContext, scoring, analyzeTokens());
  }

  protected Scoring saveScoring(
      RetailscmUserContext userContext, Scoring scoring, Map<String, Object> tokens)
      throws Exception {

    return scoringDaoOf(userContext).save(scoring, tokens);
  }

  protected Scoring loadScoring(
      RetailscmUserContext userContext, String scoringId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfScoring(scoringId);

    checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

    return scoringDaoOf(userContext).load(scoringId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, Scoring scoring, Map<String, Object> tokens) {
    super.addActions(userContext, scoring, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, Scoring scoring, Map<String, Object> tokens){

  @Override
  public List<Scoring> searchScoringList(RetailscmUserContext ctx, ScoringRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<Scoring> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public Scoring searchScoring(RetailscmUserContext ctx, ScoringRequest pRequest) {
    pRequest.limit(0, 1);
    List<Scoring> list = searchScoringList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public Scoring createScoring(
      RetailscmUserContext userContext, String scoredBy, int score, String comment)
      throws Exception {

    checkerOf(userContext).checkScoredByOfScoring(scoredBy);
    checkerOf(userContext).checkScoreOfScoring(score);
    checkerOf(userContext).checkCommentOfScoring(comment);

    checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

    Scoring scoring = createNewScoring();

    scoring.setScoredBy(scoredBy);
    scoring.setScore(score);
    scoring.setComment(comment);

    scoring = saveScoring(userContext, scoring, emptyOptions());

    onNewInstanceCreated(userContext, scoring);
    return scoring;
  }

  protected Scoring createNewScoring() {

    return new Scoring();
  }

  protected void checkParamsForUpdatingScoring(
      RetailscmUserContext userContext,
      String scoringId,
      int scoringVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfScoring(scoringId);
    checkerOf(userContext).checkVersionOfScoring(scoringVersion);

    if (Scoring.SCORED_BY_PROPERTY.equals(property)) {

      checkerOf(userContext).checkScoredByOfScoring(parseString(newValueExpr));
    }
    if (Scoring.SCORE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkScoreOfScoring(parseInt(newValueExpr));
    }
    if (Scoring.COMMENT_PROPERTY.equals(property)) {

      checkerOf(userContext).checkCommentOfScoring(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);
  }

  public Scoring clone(RetailscmUserContext userContext, String fromScoringId) throws Exception {

    return scoringDaoOf(userContext).clone(fromScoringId, this.allTokens());
  }

  public Scoring internalSaveScoring(RetailscmUserContext userContext, Scoring scoring)
      throws Exception {
    return internalSaveScoring(userContext, scoring, allTokens());
  }

  public Scoring internalSaveScoring(
      RetailscmUserContext userContext, Scoring scoring, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingScoring(userContext, scoringId, scoringVersion, property, newValueExpr,
    // tokensExpr);

    synchronized (scoring) {
      // will be good when the scoring loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to Scoring.
      if (scoring.isChanged()) {}

      // checkerOf(userContext).checkAndFixScoring(scoring);
      scoring = saveScoring(userContext, scoring, options);
      return scoring;
    }
  }

  public Scoring updateScoring(
      RetailscmUserContext userContext,
      String scoringId,
      int scoringVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingScoring(
        userContext, scoringId, scoringVersion, property, newValueExpr, tokensExpr);

    Scoring scoring = loadScoring(userContext, scoringId, allTokens());
    if (scoring.getVersion() != scoringVersion) {
      String message =
          "The target version("
              + scoring.getVersion()
              + ") is not equals to version("
              + scoringVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (scoring) {
      // will be good when the scoring loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to Scoring.

      scoring.changeProperty(property, newValueExpr);
      scoring = saveScoring(userContext, scoring, tokens().done());
      return present(userContext, scoring, mergedAllTokens(tokensExpr));
      // return saveScoring(userContext, scoring, tokens().done());
    }
  }

  public Scoring updateScoringProperty(
      RetailscmUserContext userContext,
      String scoringId,
      int scoringVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingScoring(
        userContext, scoringId, scoringVersion, property, newValueExpr, tokensExpr);

    Scoring scoring = loadScoring(userContext, scoringId, allTokens());
    if (scoring.getVersion() != scoringVersion) {
      String message =
          "The target version("
              + scoring.getVersion()
              + ") is not equals to version("
              + scoringVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (scoring) {
      // will be good when the scoring loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to Scoring.

      scoring.changeProperty(property, newValueExpr);

      scoring = saveScoring(userContext, scoring, tokens().done());
      return present(userContext, scoring, mergedAllTokens(tokensExpr));
      // return saveScoring(userContext, scoring, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected ScoringTokens tokens() {
    return ScoringTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return ScoringTokens.all();
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
        .sortEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return ScoringTokens.mergeAll(tokens).done();
  }

  // --------------------------------------------------------------

  // --------------------------------------------------------------

  public Scoring forgetByAll(RetailscmUserContext userContext, String scoringId, int scoringVersion)
      throws Exception {
    return forgetByAllInternal(userContext, scoringId, scoringVersion);
  }

  protected Scoring forgetByAllInternal(
      RetailscmUserContext userContext, String scoringId, int scoringVersion) throws Exception {

    return scoringDaoOf(userContext).disconnectFromAll(scoringId, scoringVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new ScoringManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      String scoringId,
      String employeeId,
      String trainingId,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfScoring(scoringId);

    checkerOf(userContext).checkEmployeeIdOfEmployeeCompanyTraining(employeeId);

    checkerOf(userContext).checkTrainingIdOfEmployeeCompanyTraining(trainingId);

    checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);
  }

  public Scoring addEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      String scoringId,
      String employeeId,
      String trainingId,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingEmployeeCompanyTraining(
        userContext, scoringId, employeeId, trainingId, tokensExpr);

    EmployeeCompanyTraining employeeCompanyTraining =
        createEmployeeCompanyTraining(userContext, employeeId, trainingId);

    Scoring scoring = loadScoring(userContext, scoringId, emptyOptions());
    synchronized (scoring) {
      // Will be good when the scoring loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      scoring.addEmployeeCompanyTraining(employeeCompanyTraining);
      scoring =
          saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());

      employeeCompanyTrainingManagerOf(userContext)
          .onNewInstanceCreated(userContext, employeeCompanyTraining);
      return present(userContext, scoring, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingEmployeeCompanyTrainingProperties(
      RetailscmUserContext userContext, String scoringId, String id, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfScoring(scoringId);
    checkerOf(userContext).checkIdOfEmployeeCompanyTraining(id);

    checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);
  }

  public Scoring updateEmployeeCompanyTrainingProperties(
      RetailscmUserContext userContext, String scoringId, String id, String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingEmployeeCompanyTrainingProperties(userContext, scoringId, id, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withEmployeeCompanyTrainingListList()
            .searchEmployeeCompanyTrainingListWith(
                EmployeeCompanyTraining.ID_PROPERTY, tokens().is(), id)
            .done();

    Scoring scoringToUpdate = loadScoring(userContext, scoringId, options);

    if (scoringToUpdate.getEmployeeCompanyTrainingList().isEmpty()) {
      throw new ScoringManagerException(
          "EmployeeCompanyTraining is NOT FOUND with id: '" + id + "'");
    }

    EmployeeCompanyTraining item = scoringToUpdate.getEmployeeCompanyTrainingList().first();
    beforeUpdateEmployeeCompanyTrainingProperties(userContext, item, scoringId, id, tokensExpr);

    // checkParamsForAddingEmployeeCompanyTraining(userContext,scoringId,name, code,
    // used,tokensExpr);
    Scoring scoring =
        saveScoring(
            userContext, scoringToUpdate, tokens().withEmployeeCompanyTrainingList().done());
    synchronized (scoring) {
      return present(userContext, scoring, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateEmployeeCompanyTrainingProperties(
      RetailscmUserContext userContext,
      EmployeeCompanyTraining item,
      String scoringId,
      String id,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected EmployeeCompanyTraining createEmployeeCompanyTraining(
      RetailscmUserContext userContext, String employeeId, String trainingId) throws Exception {

    EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();

    Employee employee = new Employee();
    employee.setId(employeeId);
    employeeCompanyTraining.setEmployee(employee);
    CompanyTraining training = new CompanyTraining();
    training.setId(trainingId);
    employeeCompanyTraining.setTraining(training);

    return employeeCompanyTraining;
  }

  protected EmployeeCompanyTraining createIndexedEmployeeCompanyTraining(String id, int version) {

    EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
    employeeCompanyTraining.setId(id);
    employeeCompanyTraining.setVersion(version);
    return employeeCompanyTraining;
  }

  protected void checkParamsForRemovingEmployeeCompanyTrainingList(
      RetailscmUserContext userContext,
      String scoringId,
      String employeeCompanyTrainingIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfScoring(scoringId);
    for (String employeeCompanyTrainingIdItem : employeeCompanyTrainingIds) {
      checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);
  }

  public Scoring removeEmployeeCompanyTrainingList(
      RetailscmUserContext userContext,
      String scoringId,
      String employeeCompanyTrainingIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingEmployeeCompanyTrainingList(
        userContext, scoringId, employeeCompanyTrainingIds, tokensExpr);

    Scoring scoring = loadScoring(userContext, scoringId, allTokens());
    synchronized (scoring) {
      // Will be good when the scoring loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      scoringDaoOf(userContext)
          .planToRemoveEmployeeCompanyTrainingList(
              scoring, employeeCompanyTrainingIds, allTokens());
      scoring =
          saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
      deleteRelationListInGraph(userContext, scoring.getEmployeeCompanyTrainingList());
      return present(userContext, scoring, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      String scoringId,
      String employeeCompanyTrainingId,
      int employeeCompanyTrainingVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfScoring(scoringId);
    checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
    checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);
  }

  public Scoring removeEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      String scoringId,
      String employeeCompanyTrainingId,
      int employeeCompanyTrainingVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingEmployeeCompanyTraining(
        userContext,
        scoringId,
        employeeCompanyTrainingId,
        employeeCompanyTrainingVersion,
        tokensExpr);

    EmployeeCompanyTraining employeeCompanyTraining =
        createIndexedEmployeeCompanyTraining(
            employeeCompanyTrainingId, employeeCompanyTrainingVersion);
    Scoring scoring = loadScoring(userContext, scoringId, allTokens());
    synchronized (scoring) {
      // Will be good when the scoring loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      scoring.removeEmployeeCompanyTraining(employeeCompanyTraining);
      scoring =
          saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
      deleteRelationInGraph(userContext, employeeCompanyTraining);
      return present(userContext, scoring, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      String scoringId,
      String employeeCompanyTrainingId,
      int employeeCompanyTrainingVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfScoring(scoringId);
    checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
    checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);
  }

  public Scoring copyEmployeeCompanyTrainingFrom(
      RetailscmUserContext userContext,
      String scoringId,
      String employeeCompanyTrainingId,
      int employeeCompanyTrainingVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingEmployeeCompanyTraining(
        userContext,
        scoringId,
        employeeCompanyTrainingId,
        employeeCompanyTrainingVersion,
        tokensExpr);

    EmployeeCompanyTraining employeeCompanyTraining =
        createIndexedEmployeeCompanyTraining(
            employeeCompanyTrainingId, employeeCompanyTrainingVersion);
    Scoring scoring = loadScoring(userContext, scoringId, allTokens());
    synchronized (scoring) {
      // Will be good when the scoring loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      scoring.copyEmployeeCompanyTrainingFrom(employeeCompanyTraining);
      scoring =
          saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());

      employeeCompanyTrainingManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (EmployeeCompanyTraining) scoring.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, scoring, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      String scoringId,
      String employeeCompanyTrainingId,
      int employeeCompanyTrainingVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfScoring(scoringId);
    checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
    checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);
  }

  public Scoring updateEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      String scoringId,
      String employeeCompanyTrainingId,
      int employeeCompanyTrainingVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingEmployeeCompanyTraining(
        userContext,
        scoringId,
        employeeCompanyTrainingId,
        employeeCompanyTrainingVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withEmployeeCompanyTrainingList()
            .searchEmployeeCompanyTrainingListWith(
                EmployeeCompanyTraining.ID_PROPERTY, tokens().equals(), employeeCompanyTrainingId)
            .done();

    Scoring scoring = loadScoring(userContext, scoringId, loadTokens);

    synchronized (scoring) {
      // Will be good when the scoring loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // scoring.removeEmployeeCompanyTraining( employeeCompanyTraining );
      // make changes to AcceleraterAccount.
      EmployeeCompanyTraining employeeCompanyTrainingIdVersionKey =
          createIndexedEmployeeCompanyTraining(
              employeeCompanyTrainingId, employeeCompanyTrainingVersion);

      EmployeeCompanyTraining employeeCompanyTraining =
          scoring.findTheEmployeeCompanyTraining(employeeCompanyTrainingIdVersionKey);
      if (employeeCompanyTraining == null) {
        throw new ScoringManagerException(employeeCompanyTrainingId + " is NOT FOUND");
      }

      beforeUpdateEmployeeCompanyTraining(
          userContext,
          employeeCompanyTraining,
          scoringId,
          employeeCompanyTrainingId,
          employeeCompanyTrainingVersion,
          property,
          newValueExpr,
          tokensExpr);
      employeeCompanyTraining.changeProperty(property, newValueExpr);

      scoring =
          saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
      employeeCompanyTrainingManagerOf(userContext)
          .onUpdated(userContext, employeeCompanyTraining, this, "updateEmployeeCompanyTraining");
      return present(userContext, scoring, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      EmployeeCompanyTraining existed,
      String scoringId,
      String employeeCompanyTrainingId,
      int employeeCompanyTrainingVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, Scoring newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    scoringDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   Scoring newScoring = this.createScoring(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newScoring
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
    key.put(UserApp.APP_TYPE_PROPERTY, Scoring.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(RetailscmUserContext userContext, SmartList<Scoring> list)
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
  public Object wxappview(RetailscmUserContext userContext, String scoringId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    Scoring merchantObj = (Scoring) this.view(userContext, scoringId);
    String merchantObjId = scoringId;
    String linkToUrl = "scoringManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "评分" + "详情";
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
        MapUtil.put("id", "2-scoredBy")
            .put("fieldName", "scoredBy")
            .put("label", "由谁打分")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("scoredBy", merchantObj.getScoredBy());

    propList.add(
        MapUtil.put("id", "3-score")
            .put("fieldName", "score")
            .put("label", "分数")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("score", merchantObj.getScore());

    propList.add(
        MapUtil.put("id", "4-comment")
            .put("fieldName", "comment")
            .put("label", "评论")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("comment", merchantObj.getComment());

    // 处理 sectionList

    // 处理Section：employeeCompanyTrainingListSection
    Map employeeCompanyTrainingListSection =
        ListofUtils.buildSection(
            "employeeCompanyTrainingListSection",
            "员工公司培训名单",
            null,
            "",
            "__no_group",
            "employeeCompanyTrainingManager/listByScoring/" + merchantObjId + "/",
            "auto");
    sections.add(employeeCompanyTrainingListSection);

    result.put(
        "employeeCompanyTrainingListSection",
        ListofUtils.toShortList(
            merchantObj.getEmployeeCompanyTrainingList(), "employeeCompanyTraining"));

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
