package com.doublechaintech.retailscm.employeequalifier;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.employee.CandidateEmployee;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.iamservice.*;
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

public class EmployeeQualifierManagerImpl extends CustomRetailscmCheckerManager
    implements EmployeeQualifierManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "EmployeeQualifier";

  @Override
  public EmployeeQualifierDAO daoOf(RetailscmUserContext userContext) {
    return employeeQualifierDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws EmployeeQualifierManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new EmployeeQualifierManagerException(message);
  }

  protected EmployeeQualifier saveEmployeeQualifier(
      RetailscmUserContext userContext, EmployeeQualifier employeeQualifier, String[] tokensExpr)
      throws Exception {
    // return getEmployeeQualifierDAO().save(employeeQualifier, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveEmployeeQualifier(userContext, employeeQualifier, tokens);
  }

  protected EmployeeQualifier saveEmployeeQualifierDetail(
      RetailscmUserContext userContext, EmployeeQualifier employeeQualifier) throws Exception {

    return saveEmployeeQualifier(userContext, employeeQualifier, allTokens());
  }

  public EmployeeQualifier loadEmployeeQualifier(
      RetailscmUserContext userContext, String employeeQualifierId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeQualifierManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    EmployeeQualifier employeeQualifier =
        loadEmployeeQualifier(userContext, employeeQualifierId, tokens);
    // do some calc before sent to customer?
    return present(userContext, employeeQualifier, tokens);
  }

  public EmployeeQualifier searchEmployeeQualifier(
      RetailscmUserContext userContext,
      String employeeQualifierId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeQualifierManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    EmployeeQualifier employeeQualifier =
        loadEmployeeQualifier(userContext, employeeQualifierId, tokens);
    // do some calc before sent to customer?
    return present(userContext, employeeQualifier, tokens);
  }

  protected EmployeeQualifier present(
      RetailscmUserContext userContext,
      EmployeeQualifier employeeQualifier,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, employeeQualifier, tokens);

    EmployeeQualifier employeeQualifierToPresent =
        employeeQualifierDaoOf(userContext).present(employeeQualifier, tokens);

    List<BaseEntity> entityListToNaming = employeeQualifierToPresent.collectReferencesFromLists();
    employeeQualifierDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, employeeQualifier, tokens);

    return employeeQualifierToPresent;
  }

  public EmployeeQualifier loadEmployeeQualifierDetail(
      RetailscmUserContext userContext, String employeeQualifierId) throws Exception {
    EmployeeQualifier employeeQualifier =
        loadEmployeeQualifier(userContext, employeeQualifierId, allTokens());
    return present(userContext, employeeQualifier, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String employeeQualifierId)
      throws Exception {
    EmployeeQualifier employeeQualifier =
        loadEmployeeQualifier(userContext, employeeQualifierId, viewTokens());
    markVisited(userContext, employeeQualifier);
    return present(userContext, employeeQualifier, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String employeeQualifierId)
      throws Exception {
    EmployeeQualifier employeeQualifier =
        loadEmployeeQualifier(userContext, employeeQualifierId, viewTokens());
    employeeQualifier.summarySuffix();
    markVisited(userContext, employeeQualifier);
    return present(userContext, employeeQualifier, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String employeeQualifierId)
      throws Exception {
    EmployeeQualifier employeeQualifier =
        loadEmployeeQualifier(userContext, employeeQualifierId, analyzeTokens());
    markVisited(userContext, employeeQualifier);
    return present(userContext, employeeQualifier, analyzeTokens());
  }

  protected EmployeeQualifier saveEmployeeQualifier(
      RetailscmUserContext userContext,
      EmployeeQualifier employeeQualifier,
      Map<String, Object> tokens)
      throws Exception {

    return employeeQualifierDaoOf(userContext).save(employeeQualifier, tokens);
  }

  protected EmployeeQualifier loadEmployeeQualifier(
      RetailscmUserContext userContext, String employeeQualifierId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeQualifierManagerException.class);

    return employeeQualifierDaoOf(userContext).load(employeeQualifierId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      EmployeeQualifier employeeQualifier,
      Map<String, Object> tokens) {
    super.addActions(userContext, employeeQualifier, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, EmployeeQualifier employeeQualifier, Map<String, Object> tokens){

  @Override
  public List<EmployeeQualifier> searchEmployeeQualifierList(
      RetailscmUserContext ctx, EmployeeQualifierRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<EmployeeQualifier> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public EmployeeQualifier searchEmployeeQualifier(
      RetailscmUserContext ctx, EmployeeQualifierRequest pRequest) {
    pRequest.limit(0, 1);
    List<EmployeeQualifier> list = searchEmployeeQualifierList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public EmployeeQualifier createEmployeeQualifier(
      RetailscmUserContext userContext,
      String employeeId,
      Date qualifiedTime,
      String type,
      String level,
      String remark)
      throws Exception {

    checkerOf(userContext).checkQualifiedTimeOfEmployeeQualifier(qualifiedTime);
    checkerOf(userContext).checkTypeOfEmployeeQualifier(type);
    checkerOf(userContext).checkLevelOfEmployeeQualifier(level);
    checkerOf(userContext).checkRemarkOfEmployeeQualifier(remark);

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeQualifierManagerException.class);

    EmployeeQualifier employeeQualifier = createNewEmployeeQualifier();

    Employee employee = loadEmployee(userContext, employeeId, emptyOptions());
    employeeQualifier.setEmployee(employee);

    employeeQualifier.setQualifiedTime(qualifiedTime);
    employeeQualifier.setType(type);
    employeeQualifier.setLevel(level);
    employeeQualifier.setRemark(remark);

    employeeQualifier = saveEmployeeQualifier(userContext, employeeQualifier, emptyOptions());

    onNewInstanceCreated(userContext, employeeQualifier);
    return employeeQualifier;
  }

  protected EmployeeQualifier createNewEmployeeQualifier() {

    return new EmployeeQualifier();
  }

  protected void checkParamsForUpdatingEmployeeQualifier(
      RetailscmUserContext userContext,
      String employeeQualifierId,
      int employeeQualifierVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);
    checkerOf(userContext).checkVersionOfEmployeeQualifier(employeeQualifierVersion);

    if (EmployeeQualifier.QUALIFIED_TIME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkQualifiedTimeOfEmployeeQualifier(parseDate(newValueExpr));
    }
    if (EmployeeQualifier.TYPE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkTypeOfEmployeeQualifier(parseString(newValueExpr));
    }
    if (EmployeeQualifier.LEVEL_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLevelOfEmployeeQualifier(parseString(newValueExpr));
    }
    if (EmployeeQualifier.REMARK_PROPERTY.equals(property)) {

      checkerOf(userContext).checkRemarkOfEmployeeQualifier(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeQualifierManagerException.class);
  }

  public EmployeeQualifier clone(RetailscmUserContext userContext, String fromEmployeeQualifierId)
      throws Exception {

    return employeeQualifierDaoOf(userContext).clone(fromEmployeeQualifierId, this.allTokens());
  }

  public EmployeeQualifier internalSaveEmployeeQualifier(
      RetailscmUserContext userContext, EmployeeQualifier employeeQualifier) throws Exception {
    return internalSaveEmployeeQualifier(userContext, employeeQualifier, allTokens());
  }

  public EmployeeQualifier internalSaveEmployeeQualifier(
      RetailscmUserContext userContext,
      EmployeeQualifier employeeQualifier,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingEmployeeQualifier(userContext, employeeQualifierId,
    // employeeQualifierVersion, property, newValueExpr, tokensExpr);

    synchronized (employeeQualifier) {
      // will be good when the employeeQualifier loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to EmployeeQualifier.
      if (employeeQualifier.isChanged()) {}

      // checkerOf(userContext).checkAndFixEmployeeQualifier(employeeQualifier);
      employeeQualifier = saveEmployeeQualifier(userContext, employeeQualifier, options);
      return employeeQualifier;
    }
  }

  public EmployeeQualifier updateEmployeeQualifier(
      RetailscmUserContext userContext,
      String employeeQualifierId,
      int employeeQualifierVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingEmployeeQualifier(
        userContext,
        employeeQualifierId,
        employeeQualifierVersion,
        property,
        newValueExpr,
        tokensExpr);

    EmployeeQualifier employeeQualifier =
        loadEmployeeQualifier(userContext, employeeQualifierId, allTokens());
    if (employeeQualifier.getVersion() != employeeQualifierVersion) {
      String message =
          "The target version("
              + employeeQualifier.getVersion()
              + ") is not equals to version("
              + employeeQualifierVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (employeeQualifier) {
      // will be good when the employeeQualifier loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to EmployeeQualifier.

      employeeQualifier.changeProperty(property, newValueExpr);
      employeeQualifier = saveEmployeeQualifier(userContext, employeeQualifier, tokens().done());
      return present(userContext, employeeQualifier, mergedAllTokens(tokensExpr));
      // return saveEmployeeQualifier(userContext, employeeQualifier, tokens().done());
    }
  }

  public EmployeeQualifier updateEmployeeQualifierProperty(
      RetailscmUserContext userContext,
      String employeeQualifierId,
      int employeeQualifierVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingEmployeeQualifier(
        userContext,
        employeeQualifierId,
        employeeQualifierVersion,
        property,
        newValueExpr,
        tokensExpr);

    EmployeeQualifier employeeQualifier =
        loadEmployeeQualifier(userContext, employeeQualifierId, allTokens());
    if (employeeQualifier.getVersion() != employeeQualifierVersion) {
      String message =
          "The target version("
              + employeeQualifier.getVersion()
              + ") is not equals to version("
              + employeeQualifierVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (employeeQualifier) {
      // will be good when the employeeQualifier loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to EmployeeQualifier.

      employeeQualifier.changeProperty(property, newValueExpr);

      employeeQualifier = saveEmployeeQualifier(userContext, employeeQualifier, tokens().done());
      return present(userContext, employeeQualifier, mergedAllTokens(tokensExpr));
      // return saveEmployeeQualifier(userContext, employeeQualifier, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected EmployeeQualifierTokens tokens() {
    return EmployeeQualifierTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return EmployeeQualifierTokens.all();
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
    return EmployeeQualifierTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherEmployee(
      RetailscmUserContext userContext, String employeeQualifierId, String anotherEmployeeId)
      throws Exception {

    checkerOf(userContext).checkIdOfEmployeeQualifier(employeeQualifierId);
    checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(EmployeeQualifierManagerException.class);
  }

  public EmployeeQualifier transferToAnotherEmployee(
      RetailscmUserContext userContext, String employeeQualifierId, String anotherEmployeeId)
      throws Exception {
    checkParamsForTransferingAnotherEmployee(userContext, employeeQualifierId, anotherEmployeeId);

    EmployeeQualifier employeeQualifier =
        loadEmployeeQualifier(userContext, employeeQualifierId, allTokens());
    synchronized (employeeQualifier) {
      // will be good when the employeeQualifier loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());
      employeeQualifier.updateEmployee(employee);

      employeeQualifier = saveEmployeeQualifier(userContext, employeeQualifier, emptyOptions());

      return present(userContext, employeeQualifier, allTokens());
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
            .requestCandidateEmployeeForEmployeeQualifier(
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

  // --------------------------------------------------------------

  public EmployeeQualifier forgetByAll(
      RetailscmUserContext userContext, String employeeQualifierId, int employeeQualifierVersion)
      throws Exception {
    return forgetByAllInternal(userContext, employeeQualifierId, employeeQualifierVersion);
  }

  protected EmployeeQualifier forgetByAllInternal(
      RetailscmUserContext userContext, String employeeQualifierId, int employeeQualifierVersion)
      throws Exception {

    return employeeQualifierDaoOf(userContext)
        .disconnectFromAll(employeeQualifierId, employeeQualifierVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new EmployeeQualifierManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeQualifier newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    employeeQualifierDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   EmployeeQualifier newEmployeeQualifier = this.createEmployeeQualifier(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newEmployeeQualifier
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
    key.put(UserApp.APP_TYPE_PROPERTY, EmployeeQualifier.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<EmployeeQualifier> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<Employee> employeeList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Employee.class);
    userContext.getDAOGroup().enhanceList(employeeList, Employee.class);
  }

  public Object listByEmployee(RetailscmUserContext userContext, String employeeId)
      throws Exception {
    return listPageByEmployee(userContext, employeeId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByEmployee(
      RetailscmUserContext userContext, String employeeId, int start, int count) throws Exception {
    SmartList<EmployeeQualifier> list =
        employeeQualifierDaoOf(userContext)
            .findEmployeeQualifierByEmployee(employeeId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(EmployeeQualifier.class);
    page.setContainerObject(Employee.withId(employeeId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("员工资质列表");
    page.setRequestName("listByEmployee");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByEmployee/%s/", getBeanName(), employeeId)));

    page.assemblerContent(userContext, "listByEmployee");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String employeeQualifierId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    EmployeeQualifier merchantObj = (EmployeeQualifier) this.view(userContext, employeeQualifierId);
    String merchantObjId = employeeQualifierId;
    String linkToUrl = "employeeQualifierManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工资质" + "详情";
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
        MapUtil.put("id", "3-qualifiedTime")
            .put("fieldName", "qualifiedTime")
            .put("label", "合格的时间")
            .put("type", "date")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("qualifiedTime", merchantObj.getQualifiedTime());

    propList.add(
        MapUtil.put("id", "4-type")
            .put("fieldName", "type")
            .put("label", "类型")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("type", merchantObj.getType());

    propList.add(
        MapUtil.put("id", "5-level")
            .put("fieldName", "level")
            .put("label", "水平")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("level", merchantObj.getLevel());

    propList.add(
        MapUtil.put("id", "6-remark")
            .put("fieldName", "remark")
            .put("label", "备注")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("remark", merchantObj.getRemark());

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
