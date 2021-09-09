
package com.doublechaintech.retailscm.employeeworkexperience;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.employee.CandidateEmployee;import com.doublechaintech.retailscm.employee.Employee;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class EmployeeWorkExperienceManagerImpl extends CustomRetailscmCheckerManager implements EmployeeWorkExperienceManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "EmployeeWorkExperience";
	@Override
	public EmployeeWorkExperienceDAO daoOf(RetailscmUserContext userContext) {
		return employeeWorkExperienceDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws EmployeeWorkExperienceManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new EmployeeWorkExperienceManagerException(message);

	}



 	protected EmployeeWorkExperience saveEmployeeWorkExperience(RetailscmUserContext userContext, EmployeeWorkExperience employeeWorkExperience, String [] tokensExpr) throws Exception{
 		//return getEmployeeWorkExperienceDAO().save(employeeWorkExperience, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveEmployeeWorkExperience(userContext, employeeWorkExperience, tokens);
 	}

 	protected EmployeeWorkExperience saveEmployeeWorkExperienceDetail(RetailscmUserContext userContext, EmployeeWorkExperience employeeWorkExperience) throws Exception{


 		return saveEmployeeWorkExperience(userContext, employeeWorkExperience, allTokens());
 	}

 	public EmployeeWorkExperience loadEmployeeWorkExperience(RetailscmUserContext userContext, String employeeWorkExperienceId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfEmployeeWorkExperience(employeeWorkExperienceId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeWorkExperienceManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience( userContext, employeeWorkExperienceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeWorkExperience, tokens);
 	}


 	 public EmployeeWorkExperience searchEmployeeWorkExperience(RetailscmUserContext userContext, String employeeWorkExperienceId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfEmployeeWorkExperience(employeeWorkExperienceId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeWorkExperienceManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience( userContext, employeeWorkExperienceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeWorkExperience, tokens);
 	}



 	protected EmployeeWorkExperience present(RetailscmUserContext userContext, EmployeeWorkExperience employeeWorkExperience, Map<String, Object> tokens) throws Exception {


		addActions(userContext,employeeWorkExperience,tokens);
    

		EmployeeWorkExperience  employeeWorkExperienceToPresent = employeeWorkExperienceDaoOf(userContext).present(employeeWorkExperience, tokens);

		List<BaseEntity> entityListToNaming = employeeWorkExperienceToPresent.collectRefercencesFromLists();
		employeeWorkExperienceDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,employeeWorkExperience,tokens);

		return  employeeWorkExperienceToPresent;


	}



 	public EmployeeWorkExperience loadEmployeeWorkExperienceDetail(RetailscmUserContext userContext, String employeeWorkExperienceId) throws Exception{
 		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience( userContext, employeeWorkExperienceId, allTokens());
 		return present(userContext,employeeWorkExperience, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String employeeWorkExperienceId) throws Exception{
 		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience( userContext, employeeWorkExperienceId, viewTokens());
 		markVisited(userContext, employeeWorkExperience);
 		return present(userContext,employeeWorkExperience, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String employeeWorkExperienceId) throws Exception{
		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience( userContext, employeeWorkExperienceId, viewTokens());
		employeeWorkExperience.summarySuffix();
		markVisited(userContext, employeeWorkExperience);
 		return present(userContext,employeeWorkExperience, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String employeeWorkExperienceId) throws Exception{
		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience( userContext, employeeWorkExperienceId, analyzeTokens());
		markVisited(userContext, employeeWorkExperience);
		return present(userContext,employeeWorkExperience, analyzeTokens());

	}
 	protected EmployeeWorkExperience saveEmployeeWorkExperience(RetailscmUserContext userContext, EmployeeWorkExperience employeeWorkExperience, Map<String,Object>tokens) throws Exception{
 	
 		return employeeWorkExperienceDaoOf(userContext).save(employeeWorkExperience, tokens);
 	}
 	protected EmployeeWorkExperience loadEmployeeWorkExperience(RetailscmUserContext userContext, String employeeWorkExperienceId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfEmployeeWorkExperience(employeeWorkExperienceId);

		checkerOf(userContext).throwExceptionIfHasErrors( EmployeeWorkExperienceManagerException.class);



 		return employeeWorkExperienceDaoOf(userContext).load(employeeWorkExperienceId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeWorkExperience employeeWorkExperience, Map<String, Object> tokens){
		super.addActions(userContext, employeeWorkExperience, tokens);

		addAction(userContext, employeeWorkExperience, tokens,"@create","createEmployeeWorkExperience","createEmployeeWorkExperience/","main","primary");
		addAction(userContext, employeeWorkExperience, tokens,"@update","updateEmployeeWorkExperience","updateEmployeeWorkExperience/"+employeeWorkExperience.getId()+"/","main","primary");
		addAction(userContext, employeeWorkExperience, tokens,"@copy","cloneEmployeeWorkExperience","cloneEmployeeWorkExperience/"+employeeWorkExperience.getId()+"/","main","primary");

		addAction(userContext, employeeWorkExperience, tokens,"employee_work_experience.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeWorkExperience.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeWorkExperience employeeWorkExperience, Map<String, Object> tokens){








  @Override
  public List<EmployeeWorkExperience> searchEmployeeWorkExperienceList(RetailscmUserContext ctx, EmployeeWorkExperienceRequest pRequest){
      pRequest.setUserContext(ctx);
      List<EmployeeWorkExperience> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public EmployeeWorkExperience searchEmployeeWorkExperience(RetailscmUserContext ctx, EmployeeWorkExperienceRequest pRequest){
    pRequest.limit(0, 1);
    List<EmployeeWorkExperience> list = searchEmployeeWorkExperienceList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public EmployeeWorkExperience createEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId,Date start,Date end,String company,String description) throws Exception
	{





		checkerOf(userContext).checkStartOfEmployeeWorkExperience(start);
		checkerOf(userContext).checkEndOfEmployeeWorkExperience(end);
		checkerOf(userContext).checkCompanyOfEmployeeWorkExperience(company);
		checkerOf(userContext).checkDescriptionOfEmployeeWorkExperience(description);


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeWorkExperienceManagerException.class);



		EmployeeWorkExperience employeeWorkExperience=createNewEmployeeWorkExperience();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeWorkExperience.setEmployee(employee);
		
		
		employeeWorkExperience.setStart(start);
		employeeWorkExperience.setEnd(end);
		employeeWorkExperience.setCompany(company);
		employeeWorkExperience.setDescription(description);

		employeeWorkExperience = saveEmployeeWorkExperience(userContext, employeeWorkExperience, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeWorkExperience);
		return employeeWorkExperience;


	}
	protected EmployeeWorkExperience createNewEmployeeWorkExperience()
	{

		return new EmployeeWorkExperience();
	}

	protected void checkParamsForUpdatingEmployeeWorkExperience(RetailscmUserContext userContext,String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfEmployeeWorkExperience(employeeWorkExperienceId);
		checkerOf(userContext).checkVersionOfEmployeeWorkExperience( employeeWorkExperienceVersion);



		
		if(EmployeeWorkExperience.START_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkStartOfEmployeeWorkExperience(parseDate(newValueExpr));
		

		}
		if(EmployeeWorkExperience.END_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEndOfEmployeeWorkExperience(parseDate(newValueExpr));
		

		}
		if(EmployeeWorkExperience.COMPANY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCompanyOfEmployeeWorkExperience(parseString(newValueExpr));
		

		}
		if(EmployeeWorkExperience.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfEmployeeWorkExperience(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeWorkExperienceManagerException.class);



	}



	public EmployeeWorkExperience clone(RetailscmUserContext userContext, String fromEmployeeWorkExperienceId) throws Exception{

		return employeeWorkExperienceDaoOf(userContext).clone(fromEmployeeWorkExperienceId, this.allTokens());
	}

	public EmployeeWorkExperience internalSaveEmployeeWorkExperience(RetailscmUserContext userContext, EmployeeWorkExperience employeeWorkExperience) throws Exception
	{
		return internalSaveEmployeeWorkExperience(userContext, employeeWorkExperience, allTokens());

	}
	public EmployeeWorkExperience internalSaveEmployeeWorkExperience(RetailscmUserContext userContext, EmployeeWorkExperience employeeWorkExperience, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingEmployeeWorkExperience(userContext, employeeWorkExperienceId, employeeWorkExperienceVersion, property, newValueExpr, tokensExpr);


		synchronized(employeeWorkExperience){
			//will be good when the employeeWorkExperience loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeWorkExperience.
			if (employeeWorkExperience.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixEmployeeWorkExperience(employeeWorkExperience);
			employeeWorkExperience = saveEmployeeWorkExperience(userContext, employeeWorkExperience, options);
			return employeeWorkExperience;

		}

	}

	public EmployeeWorkExperience updateEmployeeWorkExperience(RetailscmUserContext userContext,String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeWorkExperience(userContext, employeeWorkExperienceId, employeeWorkExperienceVersion, property, newValueExpr, tokensExpr);



		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience(userContext, employeeWorkExperienceId, allTokens());
		if(employeeWorkExperience.getVersion() != employeeWorkExperienceVersion){
			String message = "The target version("+employeeWorkExperience.getVersion()+") is not equals to version("+employeeWorkExperienceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeWorkExperience){
			//will be good when the employeeWorkExperience loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeWorkExperience.
			
			employeeWorkExperience.changeProperty(property, newValueExpr);
			employeeWorkExperience = saveEmployeeWorkExperience(userContext, employeeWorkExperience, tokens().done());
			return present(userContext,employeeWorkExperience, mergedAllTokens(tokensExpr));
			//return saveEmployeeWorkExperience(userContext, employeeWorkExperience, tokens().done());
		}

	}

	public EmployeeWorkExperience updateEmployeeWorkExperienceProperty(RetailscmUserContext userContext,String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeWorkExperience(userContext, employeeWorkExperienceId, employeeWorkExperienceVersion, property, newValueExpr, tokensExpr);

		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience(userContext, employeeWorkExperienceId, allTokens());
		if(employeeWorkExperience.getVersion() != employeeWorkExperienceVersion){
			String message = "The target version("+employeeWorkExperience.getVersion()+") is not equals to version("+employeeWorkExperienceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeWorkExperience){
			//will be good when the employeeWorkExperience loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeWorkExperience.

			employeeWorkExperience.changeProperty(property, newValueExpr);
			
			employeeWorkExperience = saveEmployeeWorkExperience(userContext, employeeWorkExperience, tokens().done());
			return present(userContext,employeeWorkExperience, mergedAllTokens(tokensExpr));
			//return saveEmployeeWorkExperience(userContext, employeeWorkExperience, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected EmployeeWorkExperienceTokens tokens(){
		return EmployeeWorkExperienceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeWorkExperienceTokens.all();
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
		return EmployeeWorkExperienceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeWorkExperienceId, String anotherEmployeeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfEmployeeWorkExperience(employeeWorkExperienceId);
 		checkerOf(userContext).checkIdOfEmployee(anotherEmployeeId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(EmployeeWorkExperienceManagerException.class);

 	}
 	public EmployeeWorkExperience transferToAnotherEmployee(RetailscmUserContext userContext, String employeeWorkExperienceId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeWorkExperienceId,anotherEmployeeId);
 
		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience(userContext, employeeWorkExperienceId, allTokens());
		synchronized(employeeWorkExperience){
			//will be good when the employeeWorkExperience loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());
			employeeWorkExperience.updateEmployee(employee);
			
			employeeWorkExperience = saveEmployeeWorkExperience(userContext, employeeWorkExperience, emptyOptions());

			return present(userContext,employeeWorkExperience, allTokens());

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
		SmartList<Employee> candidateList = employeeDaoOf(userContext).requestCandidateEmployeeForEmployeeWorkExperience(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeWorkExperienceId, int employeeWorkExperienceVersion) throws Exception {
		//deleteInternal(userContext, employeeWorkExperienceId, employeeWorkExperienceVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeWorkExperienceId, int employeeWorkExperienceVersion) throws Exception{

		employeeWorkExperienceDaoOf(userContext).delete(employeeWorkExperienceId, employeeWorkExperienceVersion);
	}

	public EmployeeWorkExperience forgetByAll(RetailscmUserContext userContext, String employeeWorkExperienceId, int employeeWorkExperienceVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeWorkExperienceId, employeeWorkExperienceVersion);
	}
	protected EmployeeWorkExperience forgetByAllInternal(RetailscmUserContext userContext,
			String employeeWorkExperienceId, int employeeWorkExperienceVersion) throws Exception{

		return employeeWorkExperienceDaoOf(userContext).disconnectFromAll(employeeWorkExperienceId, employeeWorkExperienceVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeWorkExperienceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return employeeWorkExperienceDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeWorkExperience newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    employeeWorkExperienceDaoOf(ctx).loadAllAsStream().forEach(
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
		//   EmployeeWorkExperience newEmployeeWorkExperience = this.createEmployeeWorkExperience(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newEmployeeWorkExperience
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
    key.put(UserApp.APP_TYPE_PROPERTY, EmployeeWorkExperience.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<EmployeeWorkExperience> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Employee> employeeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Employee.class);
		userContext.getDAOGroup().enhanceList(employeeList, Employee.class);


    }
	
	public Object listByEmployee(RetailscmUserContext userContext,String employeeId) throws Exception {
		return listPageByEmployee(userContext, employeeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByEmployee(RetailscmUserContext userContext,String employeeId, int start, int count) throws Exception {
		SmartList<EmployeeWorkExperience> list = employeeWorkExperienceDaoOf(userContext).findEmployeeWorkExperienceByEmployee(employeeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(EmployeeWorkExperience.class);
		page.setContainerObject(Employee.withId(employeeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("员工工作经验列表");
		page.setRequestName("listByEmployee");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByEmployee/%s/",  getBeanName(), employeeId)));

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
 	public Object wxappview(RetailscmUserContext userContext, String employeeWorkExperienceId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		EmployeeWorkExperience merchantObj = (EmployeeWorkExperience) this.view(userContext, employeeWorkExperienceId);
    String merchantObjId = employeeWorkExperienceId;
    String linkToUrl =	"employeeWorkExperienceManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "员工工作经验"+"详情";
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
				MapUtil.put("id", "3-start")
				    .put("fieldName", "start")
				    .put("label", "开始")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("start", merchantObj.getStart());

		propList.add(
				MapUtil.put("id", "4-end")
				    .put("fieldName", "end")
				    .put("label", "结束")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("end", merchantObj.getEnd());

		propList.add(
				MapUtil.put("id", "5-company")
				    .put("fieldName", "company")
				    .put("label", "公司")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("company", merchantObj.getCompany());

		propList.add(
				MapUtil.put("id", "6-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

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




