package com.doublechaintech.retailscm.provincecenteremployee;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.provincecenterdepartment.CandidateProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
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

public class ProvinceCenterEmployeeManagerImpl extends CustomRetailscmCheckerManager
    implements ProvinceCenterEmployeeManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "ProvinceCenterEmployee";

  @Override
  public ProvinceCenterEmployeeDAO daoOf(RetailscmUserContext userContext) {
    return provinceCenterEmployeeDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws ProvinceCenterEmployeeManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new ProvinceCenterEmployeeManagerException(message);
  }

  protected ProvinceCenterEmployee saveProvinceCenterEmployee(
      RetailscmUserContext userContext,
      ProvinceCenterEmployee provinceCenterEmployee,
      String[] tokensExpr)
      throws Exception {
    // return getProvinceCenterEmployeeDAO().save(provinceCenterEmployee, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens);
  }

  protected ProvinceCenterEmployee saveProvinceCenterEmployeeDetail(
      RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee)
      throws Exception {

    return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, allTokens());
  }

  public ProvinceCenterEmployee loadProvinceCenterEmployee(
      RetailscmUserContext userContext, String provinceCenterEmployeeId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);

    checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    ProvinceCenterEmployee provinceCenterEmployee =
        loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, provinceCenterEmployee, tokens);
  }

  public ProvinceCenterEmployee searchProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String provinceCenterEmployeeId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);

    checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    ProvinceCenterEmployee provinceCenterEmployee =
        loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, provinceCenterEmployee, tokens);
  }

  protected ProvinceCenterEmployee present(
      RetailscmUserContext userContext,
      ProvinceCenterEmployee provinceCenterEmployee,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, provinceCenterEmployee, tokens);

    ProvinceCenterEmployee provinceCenterEmployeeToPresent =
        provinceCenterEmployeeDaoOf(userContext).present(provinceCenterEmployee, tokens);

    List<BaseEntity> entityListToNaming =
        provinceCenterEmployeeToPresent.collectReferencesFromLists();
    provinceCenterEmployeeDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, provinceCenterEmployee, tokens);

    return provinceCenterEmployeeToPresent;
  }

  public ProvinceCenterEmployee loadProvinceCenterEmployeeDetail(
      RetailscmUserContext userContext, String provinceCenterEmployeeId) throws Exception {
    ProvinceCenterEmployee provinceCenterEmployee =
        loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());
    return present(userContext, provinceCenterEmployee, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String provinceCenterEmployeeId)
      throws Exception {
    ProvinceCenterEmployee provinceCenterEmployee =
        loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, viewTokens());
    markVisited(userContext, provinceCenterEmployee);
    return present(userContext, provinceCenterEmployee, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String provinceCenterEmployeeId)
      throws Exception {
    ProvinceCenterEmployee provinceCenterEmployee =
        loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, viewTokens());
    provinceCenterEmployee.summarySuffix();
    markVisited(userContext, provinceCenterEmployee);
    return present(userContext, provinceCenterEmployee, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String provinceCenterEmployeeId)
      throws Exception {
    ProvinceCenterEmployee provinceCenterEmployee =
        loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, analyzeTokens());
    markVisited(userContext, provinceCenterEmployee);
    return present(userContext, provinceCenterEmployee, analyzeTokens());
  }

  protected ProvinceCenterEmployee saveProvinceCenterEmployee(
      RetailscmUserContext userContext,
      ProvinceCenterEmployee provinceCenterEmployee,
      Map<String, Object> tokens)
      throws Exception {

    return provinceCenterEmployeeDaoOf(userContext).save(provinceCenterEmployee, tokens);
  }

  protected ProvinceCenterEmployee loadProvinceCenterEmployee(
      RetailscmUserContext userContext, String provinceCenterEmployeeId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);

    checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);

    return provinceCenterEmployeeDaoOf(userContext).load(provinceCenterEmployeeId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      ProvinceCenterEmployee provinceCenterEmployee,
      Map<String, Object> tokens) {
    super.addActions(userContext, provinceCenterEmployee, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String, Object> tokens){

  @Override
  public List<ProvinceCenterEmployee> searchProvinceCenterEmployeeList(
      RetailscmUserContext ctx, ProvinceCenterEmployeeRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<ProvinceCenterEmployee> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public ProvinceCenterEmployee searchProvinceCenterEmployee(
      RetailscmUserContext ctx, ProvinceCenterEmployeeRequest pRequest) {
    pRequest.limit(0, 1);
    List<ProvinceCenterEmployee> list = searchProvinceCenterEmployeeList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public ProvinceCenterEmployee createProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String name,
      String mobile,
      String email,
      Date founded,
      String departmentId,
      String provinceCenterId)
      throws Exception {

    checkerOf(userContext).checkNameOfProvinceCenterEmployee(name);
    checkerOf(userContext).checkMobileOfProvinceCenterEmployee(mobile);
    checkerOf(userContext).checkEmailOfProvinceCenterEmployee(email);
    checkerOf(userContext).checkFoundedOfProvinceCenterEmployee(founded);

    checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);

    ProvinceCenterEmployee provinceCenterEmployee = createNewProvinceCenterEmployee();

    provinceCenterEmployee.setName(name);
    provinceCenterEmployee.setMobile(mobile);
    provinceCenterEmployee.setEmail(email);
    provinceCenterEmployee.setFounded(founded);

    ProvinceCenterDepartment department =
        loadProvinceCenterDepartment(userContext, departmentId, emptyOptions());
    provinceCenterEmployee.setDepartment(department);

    RetailStoreProvinceCenter provinceCenter =
        loadRetailStoreProvinceCenter(userContext, provinceCenterId, emptyOptions());
    provinceCenterEmployee.setProvinceCenter(provinceCenter);

    provinceCenterEmployee =
        saveProvinceCenterEmployee(userContext, provinceCenterEmployee, emptyOptions());

    onNewInstanceCreated(userContext, provinceCenterEmployee);
    return provinceCenterEmployee;
  }

  protected ProvinceCenterEmployee createNewProvinceCenterEmployee() {

    return new ProvinceCenterEmployee();
  }

  protected void checkParamsForUpdatingProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

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

    checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);
  }

  public ProvinceCenterEmployee clone(
      RetailscmUserContext userContext, String fromProvinceCenterEmployeeId) throws Exception {

    return provinceCenterEmployeeDaoOf(userContext)
        .clone(fromProvinceCenterEmployeeId, this.allTokens());
  }

  public ProvinceCenterEmployee internalSaveProvinceCenterEmployee(
      RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee)
      throws Exception {
    return internalSaveProvinceCenterEmployee(userContext, provinceCenterEmployee, allTokens());
  }

  public ProvinceCenterEmployee internalSaveProvinceCenterEmployee(
      RetailscmUserContext userContext,
      ProvinceCenterEmployee provinceCenterEmployee,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingProvinceCenterEmployee(userContext, provinceCenterEmployeeId,
    // provinceCenterEmployeeVersion, property, newValueExpr, tokensExpr);

    synchronized (provinceCenterEmployee) {
      // will be good when the provinceCenterEmployee loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ProvinceCenterEmployee.
      if (provinceCenterEmployee.isChanged()) {}

      // checkerOf(userContext).checkAndFixProvinceCenterEmployee(provinceCenterEmployee);
      provinceCenterEmployee =
          saveProvinceCenterEmployee(userContext, provinceCenterEmployee, options);
      return provinceCenterEmployee;
    }
  }

  public ProvinceCenterEmployee updateProvinceCenterEmployee(
      RetailscmUserContext userContext,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingProvinceCenterEmployee(
        userContext,
        provinceCenterEmployeeId,
        provinceCenterEmployeeVersion,
        property,
        newValueExpr,
        tokensExpr);

    ProvinceCenterEmployee provinceCenterEmployee =
        loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());
    if (provinceCenterEmployee.getVersion() != provinceCenterEmployeeVersion) {
      String message =
          "The target version("
              + provinceCenterEmployee.getVersion()
              + ") is not equals to version("
              + provinceCenterEmployeeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (provinceCenterEmployee) {
      // will be good when the provinceCenterEmployee loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ProvinceCenterEmployee.

      provinceCenterEmployee.changeProperty(property, newValueExpr);
      provinceCenterEmployee =
          saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
      return present(userContext, provinceCenterEmployee, mergedAllTokens(tokensExpr));
      // return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
    }
  }

  public ProvinceCenterEmployee updateProvinceCenterEmployeeProperty(
      RetailscmUserContext userContext,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingProvinceCenterEmployee(
        userContext,
        provinceCenterEmployeeId,
        provinceCenterEmployeeVersion,
        property,
        newValueExpr,
        tokensExpr);

    ProvinceCenterEmployee provinceCenterEmployee =
        loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());
    if (provinceCenterEmployee.getVersion() != provinceCenterEmployeeVersion) {
      String message =
          "The target version("
              + provinceCenterEmployee.getVersion()
              + ") is not equals to version("
              + provinceCenterEmployeeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (provinceCenterEmployee) {
      // will be good when the provinceCenterEmployee loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to ProvinceCenterEmployee.

      provinceCenterEmployee.changeProperty(property, newValueExpr);

      provinceCenterEmployee =
          saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
      return present(userContext, provinceCenterEmployee, mergedAllTokens(tokensExpr));
      // return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected ProvinceCenterEmployeeTokens tokens() {
    return ProvinceCenterEmployeeTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return ProvinceCenterEmployeeTokens.all();
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
    return ProvinceCenterEmployeeTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherDepartment(
      RetailscmUserContext userContext, String provinceCenterEmployeeId, String anotherDepartmentId)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
    checkerOf(userContext)
        .checkIdOfProvinceCenterDepartment(anotherDepartmentId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);
  }

  public ProvinceCenterEmployee transferToAnotherDepartment(
      RetailscmUserContext userContext, String provinceCenterEmployeeId, String anotherDepartmentId)
      throws Exception {
    checkParamsForTransferingAnotherDepartment(
        userContext, provinceCenterEmployeeId, anotherDepartmentId);

    ProvinceCenterEmployee provinceCenterEmployee =
        loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());
    synchronized (provinceCenterEmployee) {
      // will be good when the provinceCenterEmployee loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      ProvinceCenterDepartment department =
          loadProvinceCenterDepartment(userContext, anotherDepartmentId, emptyOptions());
      provinceCenterEmployee.updateDepartment(department);

      provinceCenterEmployee =
          saveProvinceCenterEmployee(userContext, provinceCenterEmployee, emptyOptions());

      return present(userContext, provinceCenterEmployee, allTokens());
    }
  }

  public CandidateProvinceCenterDepartment requestCandidateDepartment(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateProvinceCenterDepartment result = new CandidateProvinceCenterDepartment();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<ProvinceCenterDepartment> candidateList =
        provinceCenterDepartmentDaoOf(userContext)
            .requestCandidateProvinceCenterDepartmentForProvinceCenterEmployee(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  protected void checkParamsForTransferingAnotherProvinceCenter(
      RetailscmUserContext userContext,
      String provinceCenterEmployeeId,
      String anotherProvinceCenterId)
      throws Exception {

    checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
    checkerOf(userContext)
        .checkIdOfRetailStoreProvinceCenter(
            anotherProvinceCenterId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);
  }

  public ProvinceCenterEmployee transferToAnotherProvinceCenter(
      RetailscmUserContext userContext,
      String provinceCenterEmployeeId,
      String anotherProvinceCenterId)
      throws Exception {
    checkParamsForTransferingAnotherProvinceCenter(
        userContext, provinceCenterEmployeeId, anotherProvinceCenterId);

    ProvinceCenterEmployee provinceCenterEmployee =
        loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());
    synchronized (provinceCenterEmployee) {
      // will be good when the provinceCenterEmployee loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreProvinceCenter provinceCenter =
          loadRetailStoreProvinceCenter(userContext, anotherProvinceCenterId, emptyOptions());
      provinceCenterEmployee.updateProvinceCenter(provinceCenter);

      provinceCenterEmployee =
          saveProvinceCenterEmployee(userContext, provinceCenterEmployee, emptyOptions());

      return present(userContext, provinceCenterEmployee, allTokens());
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
            .requestCandidateRetailStoreProvinceCenterForProvinceCenterEmployee(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected ProvinceCenterDepartment loadProvinceCenterDepartment(
      RetailscmUserContext userContext, String newDepartmentId, Map<String, Object> options)
      throws Exception {

    return provinceCenterDepartmentDaoOf(userContext).load(newDepartmentId, options);
  }

  protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(
      RetailscmUserContext userContext, String newProvinceCenterId, Map<String, Object> options)
      throws Exception {

    return retailStoreProvinceCenterDaoOf(userContext).load(newProvinceCenterId, options);
  }

  // --------------------------------------------------------------

  public ProvinceCenterEmployee forgetByAll(
      RetailscmUserContext userContext,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion)
      throws Exception {
    return forgetByAllInternal(
        userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion);
  }

  protected ProvinceCenterEmployee forgetByAllInternal(
      RetailscmUserContext userContext,
      String provinceCenterEmployeeId,
      int provinceCenterEmployeeVersion)
      throws Exception {

    return provinceCenterEmployeeDaoOf(userContext)
        .disconnectFromAll(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new ProvinceCenterEmployeeManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, ProvinceCenterEmployee newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    provinceCenterEmployeeDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   ProvinceCenterEmployee newProvinceCenterEmployee =
    // this.createProvinceCenterEmployee(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newProvinceCenterEmployee
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
    key.put(UserApp.APP_TYPE_PROPERTY, ProvinceCenterEmployee.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<ProvinceCenterEmployee> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<ProvinceCenterDepartment> departmentList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, ProvinceCenterDepartment.class);
    userContext.getDAOGroup().enhanceList(departmentList, ProvinceCenterDepartment.class);
    List<RetailStoreProvinceCenter> provinceCenterList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, RetailStoreProvinceCenter.class);
    userContext.getDAOGroup().enhanceList(provinceCenterList, RetailStoreProvinceCenter.class);
  }

  public Object listByDepartment(RetailscmUserContext userContext, String departmentId)
      throws Exception {
    return listPageByDepartment(userContext, departmentId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByDepartment(
      RetailscmUserContext userContext, String departmentId, int start, int count)
      throws Exception {
    SmartList<ProvinceCenterEmployee> list =
        provinceCenterEmployeeDaoOf(userContext)
            .findProvinceCenterEmployeeByDepartment(departmentId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(ProvinceCenterEmployee.class);
    page.setContainerObject(ProvinceCenterDepartment.withId(departmentId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("省中心员工列表");
    page.setRequestName("listByDepartment");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByDepartment/%s/", getBeanName(), departmentId)));

    page.assemblerContent(userContext, "listByDepartment");
    return page.doRender(userContext);
  }

  public Object listByProvinceCenter(RetailscmUserContext userContext, String provinceCenterId)
      throws Exception {
    return listPageByProvinceCenter(userContext, provinceCenterId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByProvinceCenter(
      RetailscmUserContext userContext, String provinceCenterId, int start, int count)
      throws Exception {
    SmartList<ProvinceCenterEmployee> list =
        provinceCenterEmployeeDaoOf(userContext)
            .findProvinceCenterEmployeeByProvinceCenter(
                provinceCenterId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(ProvinceCenterEmployee.class);
    page.setContainerObject(RetailStoreProvinceCenter.withId(provinceCenterId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("省中心员工列表");
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
  public Object wxappview(RetailscmUserContext userContext, String provinceCenterEmployeeId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    ProvinceCenterEmployee merchantObj =
        (ProvinceCenterEmployee) this.view(userContext, provinceCenterEmployeeId);
    String merchantObjId = provinceCenterEmployeeId;
    String linkToUrl = "provinceCenterEmployeeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "省中心员工" + "详情";
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
        MapUtil.put("id", "3-mobile")
            .put("fieldName", "mobile")
            .put("label", "手机")
            .put("type", "mobile")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("mobile", merchantObj.getMobile());

    propList.add(
        MapUtil.put("id", "4-email")
            .put("fieldName", "email")
            .put("label", "电子邮件")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("email", merchantObj.getEmail());

    propList.add(
        MapUtil.put("id", "5-founded")
            .put("fieldName", "founded")
            .put("label", "成立")
            .put("type", "date")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("founded", merchantObj.getFounded());

    propList.add(
        MapUtil.put("id", "6-department")
            .put("fieldName", "department")
            .put("label", "部门")
            .put("type", "auto")
            .put("linkToUrl", "provinceCenterDepartmentManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"manager\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("department", merchantObj.getDepartment());

    propList.add(
        MapUtil.put("id", "7-provinceCenter")
            .put("fieldName", "provinceCenter")
            .put("label", "省中心")
            .put("type", "auto")
            .put("linkToUrl", "retailStoreProvinceCenterManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("provinceCenter", merchantObj.getProvinceCenter());

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
