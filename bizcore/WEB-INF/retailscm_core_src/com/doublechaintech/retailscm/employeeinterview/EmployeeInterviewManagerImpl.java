
package com.doublechaintech.retailscm.employeeinterview;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.employee.CandidateEmployee;import com.doublechaintech.retailscm.employee.Employee;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.interviewtype.CandidateInterviewType;import com.doublechaintech.retailscm.interviewtype.InterviewType;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class EmployeeInterviewManagerImpl extends CustomRetailscmCheckerManager implements EmployeeInterviewManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "EmployeeInterview";
	@Override
	public EmployeeInterviewDAO daoOf(RetailscmUserContext userContext) {
		return employeeInterviewDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws EmployeeInterviewManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EmployeeInterviewManagerException(message);

	}



 	protected EmployeeInterview saveEmployeeInterview(RetailscmUserContext userContext, EmployeeInterview employeeInterview, String [] tokensExpr) throws Exception{
 		//return getEmployeeInterviewDAO().save(employeeInterview, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveEmployeeInterview(userContext, employeeInterview, tokens);
 	}

 	protected EmployeeInterview saveEmployeeInterviewDetail(RetailscmUserContext userContext, EmployeeInterview employeeInterview) throws Exception{


 		return saveEmployeeInterview(userContext, employeeInterview, allTokens());
 	}

 	public EmployeeInterview loadEmployeeInterview(RetailscmUserContext userContext, String employeeInterviewId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeInterviewManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeInterview, tokens);
 	}


 	 public EmployeeInterview searchEmployeeInterview(RetailscmUserContext userContext, String employeeInterviewId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeInterviewManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeInterview, tokens);
 	}



 	protected EmployeeInterview present(RetailscmUserContext userContext, EmployeeInterview employeeInterview, Map<String, Object> tokens) throws Exception {


		addActions(userContext,employeeInterview,tokens);
    

		EmployeeInterview  employeeInterviewToPresent = employeeInterviewDaoOf(userContext).present(employeeInterview, tokens);

		List<BaseEntity> entityListToNaming = employeeInterviewToPresent.collectRefercencesFromLists();
		employeeInterviewDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,employeeInterview,tokens);

		return  employeeInterviewToPresent;


	}



 	public EmployeeInterview loadEmployeeInterviewDetail(RetailscmUserContext userContext, String employeeInterviewId) throws Exception{
 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, allTokens());
 		return present(userContext,employeeInterview, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String employeeInterviewId) throws Exception{
 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, viewTokens());
 		markVisited(userContext, employeeInterview);
 		return present(userContext,employeeInterview, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String employeeInterviewId) throws Exception{
		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, viewTokens());
		employeeInterview.summarySuffix();
		markVisited(userContext, employeeInterview);
 		return present(userContext,employeeInterview, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String employeeInterviewId) throws Exception{
		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, analyzeTokens());
		markVisited(userContext, employeeInterview);
		return present(userContext,employeeInterview, analyzeTokens());

	}
 	protected EmployeeInterview saveEmployeeInterview(RetailscmUserContext userContext, EmployeeInterview employeeInterview, Map<String,Object>tokens) throws Exception{
 	
 		return employeeInterviewDaoOf(userContext).save(employeeInterview, tokens);
 	}
 	protected EmployeeInterview loadEmployeeInterview(RetailscmUserContext userContext, String employeeInterviewId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeInterviewManagerException.class);



 		return employeeInterviewDaoOf(userContext).load(employeeInterviewId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeInterview employeeInterview, Map<String, Object> tokens){
		super.addActions(userContext, employeeInterview, tokens);

		addAction(userContext, employeeInterview, tokens,"@create","createEmployeeInterview","createEmployeeInterview/","main","primary");
		addAction(userContext, employeeInterview, tokens,"@update","updateEmployeeInterview","updateEmployeeInterview/"+employeeInterview.getId()+"/","main","primary");
		addAction(userContext, employeeInterview, tokens,"@copy","cloneEmployeeInterview","cloneEmployeeInterview/"+employeeInterview.getId()+"/","main","primary");

		addAction(userContext, employeeInterview, tokens,"employee_interview.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeInterview.getId()+"/","main","primary");
		addAction(userContext, employeeInterview, tokens,"employee_interview.transfer_to_interview_type","transferToAnotherInterviewType","transferToAnotherInterviewType/"+employeeInterview.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeInterview employeeInterview, Map<String, Object> tokens){








  @Override
  public List<EmployeeInterview> searchEmployeeInterviewList(RetailscmUserContext ctx, EmployeeInterviewRequest pRequest){
      pRequest.setUserContext(ctx);
      List<EmployeeInterview> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public EmployeeInterview searchEmployeeInterview(RetailscmUserContext ctx, EmployeeInterviewRequest pRequest){
    pRequest.limit(0, 1);
    List<EmployeeInterview> list = searchEmployeeInterviewList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public EmployeeInterview createEmployeeInterview(RetailscmUserContext userContext, String employeeId,String interviewTypeId,String remark) throws Exception
	{





		checkerOf(userContext).checkRemarkOfEmployeeInterview(remark);


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeInterviewManagerException.class);



		EmployeeInterview employeeInterview=createNewEmployeeInterview();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeInterview.setEmployee(employee);
		
		
			
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId,emptyOptions());
		employeeInterview.setInterviewType(interviewType);
		
		
		employeeInterview.setRemark(remark);

		employeeInterview = saveEmployeeInterview(userContext, employeeInterview, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeInterview);
		return employeeInterview;


	}
	protected EmployeeInterview createNewEmployeeInterview()
	{

		return new EmployeeInterview();
	}

	protected void checkParamsForUpdatingEmployeeInterview(RetailscmUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);
		checkerOf(userContext).checkVersionOfEmployeeInterview( employeeInterviewVersion);



		

		
		if(EmployeeInterview.REMARK_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemarkOfEmployeeInterview(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeInterviewManagerException.class);



	}



	public EmployeeInterview clone(RetailscmUserContext userContext, String fromEmployeeInterviewId) throws Exception{

		return employeeInterviewDaoOf(userContext).clone(fromEmployeeInterviewId, this.allTokens());
	}

	public EmployeeInterview internalSaveEmployeeInterview(RetailscmUserContext userContext, EmployeeInterview employeeInterview) throws Exception
	{
		return internalSaveEmployeeInterview(userContext, employeeInterview, allTokens());

	}
	public EmployeeInterview internalSaveEmployeeInterview(RetailscmUserContext userContext, EmployeeInterview employeeInterview, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEmployeeInterview(userContext, employeeInterviewId, employeeInterviewVersion, property, newValueExpr, tokensExpr);


		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeInterview.
			if (employeeInterview.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixEmployeeInterview(employeeInterview);
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, options);
			return employeeInterview;

		}

	}

	public EmployeeInterview updateEmployeeInterview(RetailscmUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeInterview(userContext, employeeInterviewId, employeeInterviewVersion, property, newValueExpr, tokensExpr);



		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());
		if(employeeInterview.getVersion() != employeeInterviewVersion){
			String message = "The target version("+employeeInterview.getVersion()+") is not equals to version("+employeeInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeInterview.
			
			employeeInterview.changeProperty(property, newValueExpr);
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, tokens().done());
			return present(userContext,employeeInterview, mergedAllTokens(tokensExpr));
			//return saveEmployeeInterview(userContext, employeeInterview, tokens().done());
		}

	}

	public EmployeeInterview updateEmployeeInterviewProperty(RetailscmUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeInterview(userContext, employeeInterviewId, employeeInterviewVersion, property, newValueExpr, tokensExpr);

		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());
		if(employeeInterview.getVersion() != employeeInterviewVersion){
			String message = "The target version("+employeeInterview.getVersion()+") is not equals to version("+employeeInterviewVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeInterview.

			employeeInterview.changeProperty(property, newValueExpr);
			
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, tokens().done());
			return present(userContext,employeeInterview, mergedAllTokens(tokensExpr));
			//return saveEmployeeInterview(userContext, employeeInterview, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EmployeeInterviewTokens tokens(){
		return EmployeeInterviewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeInterviewTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeInterviewTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeInterviewId, String anotherEmployeeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);
 		checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeInterviewManagerException.class);

 	}
 	public EmployeeInterview transferToAnotherEmployee(RetailscmUserContext userContext, String employeeInterviewId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeInterviewId,anotherEmployeeId);
 
		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());
		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());
			employeeInterview.updateEmployee(employee);
			
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, emptyOptions());

			return present(userContext,employeeInterview, allTokens());

		}

 	}

	


	public CandidateEmployee requestCandidateEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateEmployee result = new CandidateEmployee();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("company");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForEmployeeInterview(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherInterviewType(RetailscmUserContext userContext, String employeeInterviewId, String anotherInterviewTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeInterview(employeeInterviewId);
 		checkerOf(userContext).checkIdOfInterviewType(anotherInterviewTypeId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeInterviewManagerException.class);

 	}
 	public EmployeeInterview transferToAnotherInterviewType(RetailscmUserContext userContext, String employeeInterviewId, String anotherInterviewTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherInterviewType(userContext, employeeInterviewId,anotherInterviewTypeId);
 
		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());
		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			InterviewType interviewType = loadInterviewType(userContext, anotherInterviewTypeId, emptyOptions());
			employeeInterview.updateInterviewType(interviewType);
			
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, emptyOptions());

			return present(userContext,employeeInterview, allTokens());

		}

 	}

	


	public CandidateInterviewType requestCandidateInterviewType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateInterviewType result = new CandidateInterviewType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<InterviewType> candidateList = interviewTypeDaoOf(userContext).requestCandidateInterviewTypeForEmployeeInterview(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Employee loadEmployee(RetailscmUserContext userContext, String newEmployeeId, Map<String,Object> options) throws Exception
 	{
    
 		return employeeDaoOf(userContext).load(newEmployeeId, options);
 	  
 	}
 	


	

 	protected InterviewType loadInterviewType(RetailscmUserContext userContext, String newInterviewTypeId, Map<String,Object> options) throws Exception
 	{
    
 		return interviewTypeDaoOf(userContext).load(newInterviewTypeId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeInterviewId, int employeeInterviewVersion) throws Exception {
		//deleteInternal(userContext, employeeInterviewId, employeeInterviewVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeInterviewId, int employeeInterviewVersion) throws Exception{

		employeeInterviewDaoOf(userContext).delete(employeeInterviewId, employeeInterviewVersion);
	}

	public EmployeeInterview forgetByAll(RetailscmUserContext userContext, String employeeInterviewId, int employeeInterviewVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeInterviewId, employeeInterviewVersion);
	}
	protected EmployeeInterview forgetByAllInternal(RetailscmUserContext userContext,
			String employeeInterviewId, int employeeInterviewVersion) throws Exception{

		return employeeInterviewDaoOf(userContext).disconnectFromAll(employeeInterviewId, employeeInterviewVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeInterviewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return employeeInterviewDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeInterview newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    employeeInterviewDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
  }



	// -----------------------------------//  登录部分处理 \\-----------------------------------
	@Override
  protected BusinessHandler getLoginProcessBizHandler(RetailscmUserContextImpl userContext) {
    return this;
  }

	public void onAuthenticationFailed(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   EmployeeInterview newEmployeeInterview = this.createEmployeeInterview(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeeInterview
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// and in most case, this should be considered as "login success"
		//   loginResult.setSuccess(true);
		//
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	protected SmartList<UserApp> getRelatedUserAppList(RetailscmUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, EmployeeInterview.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<EmployeeInterview> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Employee> employeeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Employee.class);
		userContext.getDAOGroup().enhanceList(employeeList, Employee.class);
		List<InterviewType> interviewTypeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, InterviewType.class);
		userContext.getDAOGroup().enhanceList(interviewTypeList, InterviewType.class);


    }
	
	public Object listByEmployee(RetailscmUserContext userContext,String employeeId) throws Exception {
		return listPageByEmployee(userContext, employeeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByEmployee(RetailscmUserContext userContext,String employeeId, int start, int count) throws Exception {
		SmartList<EmployeeInterview> list = employeeInterviewDaoOf(userContext).findEmployeeInterviewByEmployee(employeeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EmployeeInterview.class);
		page.setContainerObject(Employee.withId(employeeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工面试列表");
		page.setRequestName("listByEmployee");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByEmployee/%s/",  getBeanName(), employeeId)));

		page.assemblerContent(userContext, "listByEmployee");
		return page.doRender(userContext);
	}
  
	public Object listByInterviewType(RetailscmUserContext userContext,String interviewTypeId) throws Exception {
		return listPageByInterviewType(userContext, interviewTypeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByInterviewType(RetailscmUserContext userContext,String interviewTypeId, int start, int count) throws Exception {
		SmartList<EmployeeInterview> list = employeeInterviewDaoOf(userContext).findEmployeeInterviewByInterviewType(interviewTypeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EmployeeInterview.class);
		page.setContainerObject(InterviewType.withId(interviewTypeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工面试列表");
		page.setRequestName("listByInterviewType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByInterviewType/%s/",  getBeanName(), interviewTypeId)));

		page.assemblerContent(userContext, "listByInterviewType");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String employeeInterviewId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		EmployeeInterview merchantObj = (EmployeeInterview) this.view(userContext, employeeInterviewId);
    String merchantObjId = employeeInterviewId;
    String linkToUrl =	"employeeInterviewManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工面试"+"详情";
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
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-employee")
				    .put("fieldName", "employee")
				    .put("label", "员工")
				    .put("type", "auto")
				    .put("linkToUrl", "employeeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"family_name\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("employee", merchantObj.getEmployee());

		propList.add(
				MapUtil.put("id", "3-interviewType")
				    .put("fieldName", "interviewType")
				    .put("label", "面试类型")
				    .put("type", "auto")
				    .put("linkToUrl", "interviewTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"code\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("interviewType", merchantObj.getInterviewType());

		propList.add(
				MapUtil.put("id", "4-remark")
				    .put("fieldName", "remark")
				    .put("label", "备注")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("remark", merchantObj.getRemark());

		//处理 sectionList

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

  










}




