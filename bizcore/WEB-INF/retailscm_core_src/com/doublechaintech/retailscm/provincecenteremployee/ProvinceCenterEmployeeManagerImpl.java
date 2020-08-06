
package com.doublechaintech.retailscm.provincecenteremployee;

import java.util.*;
import java.math.BigDecimal;
import com.terapico.caf.baseelement.PlainText;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;



import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;

import com.doublechaintech.retailscm.provincecenterdepartment.CandidateProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.CandidateRetailStoreProvinceCenter;







public class ProvinceCenterEmployeeManagerImpl extends CustomRetailscmCheckerManager implements ProvinceCenterEmployeeManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "ProvinceCenterEmployee";
	@Override
	public ProvinceCenterEmployeeDAO daoOf(RetailscmUserContext userContext) {
		return provinceCenterEmployeeDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ProvinceCenterEmployeeManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ProvinceCenterEmployeeManagerException(message);

	}



 	protected ProvinceCenterEmployee saveProvinceCenterEmployee(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, String [] tokensExpr) throws Exception{	
 		//return getProvinceCenterEmployeeDAO().save(provinceCenterEmployee, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens);
 	}
 	
 	protected ProvinceCenterEmployee saveProvinceCenterEmployeeDetail(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee) throws Exception{	

 		
 		return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, allTokens());
 	}
 	
 	public ProvinceCenterEmployee loadProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterEmployeeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProvinceCenterEmployeeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee( userContext, provinceCenterEmployeeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,provinceCenterEmployee, tokens);
 	}
 	
 	
 	 public ProvinceCenterEmployee searchProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterEmployeeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProvinceCenterEmployeeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee( userContext, provinceCenterEmployeeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,provinceCenterEmployee, tokens);
 	}
 	
 	

 	protected ProvinceCenterEmployee present(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,provinceCenterEmployee,tokens);
		
		
		ProvinceCenterEmployee  provinceCenterEmployeeToPresent = provinceCenterEmployeeDaoOf(userContext).present(provinceCenterEmployee, tokens);
		
		List<BaseEntity> entityListToNaming = provinceCenterEmployeeToPresent.collectRefercencesFromLists();
		provinceCenterEmployeeDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,provinceCenterEmployee,tokens);
		
		return  provinceCenterEmployeeToPresent;
		
		
	}
 
 	
 	
 	public ProvinceCenterEmployee loadProvinceCenterEmployeeDetail(RetailscmUserContext userContext, String provinceCenterEmployeeId) throws Exception{	
 		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee( userContext, provinceCenterEmployeeId, allTokens());
 		return present(userContext,provinceCenterEmployee, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String provinceCenterEmployeeId) throws Exception{	
 		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee( userContext, provinceCenterEmployeeId, viewTokens());
 		return present(userContext,provinceCenterEmployee, allTokens());
		
 	}
 	protected ProvinceCenterEmployee saveProvinceCenterEmployee(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object>tokens) throws Exception{	
 		return provinceCenterEmployeeDaoOf(userContext).save(provinceCenterEmployee, tokens);
 	}
 	protected ProvinceCenterEmployee loadProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterEmployeeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProvinceCenterEmployeeManagerException.class);

 
 		return provinceCenterEmployeeDaoOf(userContext).load(provinceCenterEmployeeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String, Object> tokens){
		super.addActions(userContext, provinceCenterEmployee, tokens);
		
		addAction(userContext, provinceCenterEmployee, tokens,"@create","createProvinceCenterEmployee","createProvinceCenterEmployee/","main","primary");
		addAction(userContext, provinceCenterEmployee, tokens,"@update","updateProvinceCenterEmployee","updateProvinceCenterEmployee/"+provinceCenterEmployee.getId()+"/","main","primary");
		addAction(userContext, provinceCenterEmployee, tokens,"@copy","cloneProvinceCenterEmployee","cloneProvinceCenterEmployee/"+provinceCenterEmployee.getId()+"/","main","primary");
		
		addAction(userContext, provinceCenterEmployee, tokens,"province_center_employee.transfer_to_department","transferToAnotherDepartment","transferToAnotherDepartment/"+provinceCenterEmployee.getId()+"/","main","primary");
		addAction(userContext, provinceCenterEmployee, tokens,"province_center_employee.transfer_to_province_center","transferToAnotherProvinceCenter","transferToAnotherProvinceCenter/"+provinceCenterEmployee.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ProvinceCenterEmployee createProvinceCenterEmployee(RetailscmUserContext userContext, String name,String mobile,String email,Date founded,String departmentId,String provinceCenterId) throws Exception
	//public ProvinceCenterEmployee createProvinceCenterEmployee(RetailscmUserContext userContext,String name, String mobile, String email, Date founded, String departmentId, String provinceCenterId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfProvinceCenterEmployee(name);
		checkerOf(userContext).checkMobileOfProvinceCenterEmployee(mobile);
		checkerOf(userContext).checkEmailOfProvinceCenterEmployee(email);
		checkerOf(userContext).checkFoundedOfProvinceCenterEmployee(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);


		ProvinceCenterEmployee provinceCenterEmployee=createNewProvinceCenterEmployee();	

		provinceCenterEmployee.setName(name);
		provinceCenterEmployee.setMobile(mobile);
		provinceCenterEmployee.setEmail(email);
		provinceCenterEmployee.setFounded(founded);
			
		ProvinceCenterDepartment department = loadProvinceCenterDepartment(userContext, departmentId,emptyOptions());
		provinceCenterEmployee.setDepartment(department);
		
		
			
		RetailStoreProvinceCenter provinceCenter = loadRetailStoreProvinceCenter(userContext, provinceCenterId,emptyOptions());
		provinceCenterEmployee.setProvinceCenter(provinceCenter);
		
		

		provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, emptyOptions());
		
		onNewInstanceCreated(userContext, provinceCenterEmployee);
		return provinceCenterEmployee;


	}
	protected ProvinceCenterEmployee createNewProvinceCenterEmployee()
	{

		return new ProvinceCenterEmployee();
	}

	protected void checkParamsForUpdatingProvinceCenterEmployee(RetailscmUserContext userContext,String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		checkerOf(userContext).checkVersionOfProvinceCenterEmployee( provinceCenterEmployeeVersion);
		

		if(ProvinceCenterEmployee.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfProvinceCenterEmployee(parseString(newValueExpr));
		
			
		}
		if(ProvinceCenterEmployee.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfProvinceCenterEmployee(parseString(newValueExpr));
		
			
		}
		if(ProvinceCenterEmployee.EMAIL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmailOfProvinceCenterEmployee(parseString(newValueExpr));
		
			
		}
		if(ProvinceCenterEmployee.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfProvinceCenterEmployee(parseDate(newValueExpr));
		
			
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);


	}



	public ProvinceCenterEmployee clone(RetailscmUserContext userContext, String fromProvinceCenterEmployeeId) throws Exception{

		return provinceCenterEmployeeDaoOf(userContext).clone(fromProvinceCenterEmployeeId, this.allTokens());
	}

	public ProvinceCenterEmployee internalSaveProvinceCenterEmployee(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee) throws Exception
	{
		return internalSaveProvinceCenterEmployee(userContext, provinceCenterEmployee, allTokens());

	}
	public ProvinceCenterEmployee internalSaveProvinceCenterEmployee(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingProvinceCenterEmployee(userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr, tokensExpr);


		synchronized(provinceCenterEmployee){
			//will be good when the provinceCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterEmployee.
			if (provinceCenterEmployee.isChanged()){
			
			}
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, options);
			return provinceCenterEmployee;

		}

	}

	public ProvinceCenterEmployee updateProvinceCenterEmployee(RetailscmUserContext userContext,String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProvinceCenterEmployee(userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr, tokensExpr);



		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());
		if(provinceCenterEmployee.getVersion() != provinceCenterEmployeeVersion){
			String message = "The target version("+provinceCenterEmployee.getVersion()+") is not equals to version("+provinceCenterEmployeeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(provinceCenterEmployee){
			//will be good when the provinceCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterEmployee.
			
			provinceCenterEmployee.changeProperty(property, newValueExpr);
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
			return present(userContext,provinceCenterEmployee, mergedAllTokens(tokensExpr));
			//return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
		}

	}

	public ProvinceCenterEmployee updateProvinceCenterEmployeeProperty(RetailscmUserContext userContext,String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProvinceCenterEmployee(userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr, tokensExpr);

		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());
		if(provinceCenterEmployee.getVersion() != provinceCenterEmployeeVersion){
			String message = "The target version("+provinceCenterEmployee.getVersion()+") is not equals to version("+provinceCenterEmployeeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(provinceCenterEmployee){
			//will be good when the provinceCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterEmployee.

			provinceCenterEmployee.changeProperty(property, newValueExpr);
			
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
			return present(userContext,provinceCenterEmployee, mergedAllTokens(tokensExpr));
			//return saveProvinceCenterEmployee(userContext, provinceCenterEmployee, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ProvinceCenterEmployeeTokens tokens(){
		return ProvinceCenterEmployeeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProvinceCenterEmployeeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProvinceCenterEmployeeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherDepartment(RetailscmUserContext userContext, String provinceCenterEmployeeId, String anotherDepartmentId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
 		checkerOf(userContext).checkIdOfProvinceCenterDepartment(anotherDepartmentId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);

 	}
 	public ProvinceCenterEmployee transferToAnotherDepartment(RetailscmUserContext userContext, String provinceCenterEmployeeId, String anotherDepartmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherDepartment(userContext, provinceCenterEmployeeId,anotherDepartmentId);
 
		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());	
		synchronized(provinceCenterEmployee){
			//will be good when the provinceCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ProvinceCenterDepartment department = loadProvinceCenterDepartment(userContext, anotherDepartmentId, emptyOptions());		
			provinceCenterEmployee.updateDepartment(department);		
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, emptyOptions());
			
			return present(userContext,provinceCenterEmployee, allTokens());
			
		}

 	}

	


	public CandidateProvinceCenterDepartment requestCandidateDepartment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProvinceCenterDepartment result = new CandidateProvinceCenterDepartment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ProvinceCenterDepartment> candidateList = provinceCenterDepartmentDaoOf(userContext).requestCandidateProvinceCenterDepartmentForProvinceCenterEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherProvinceCenter(RetailscmUserContext userContext, String provinceCenterEmployeeId, String anotherProvinceCenterId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
 		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(anotherProvinceCenterId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterEmployeeManagerException.class);

 	}
 	public ProvinceCenterEmployee transferToAnotherProvinceCenter(RetailscmUserContext userContext, String provinceCenterEmployeeId, String anotherProvinceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherProvinceCenter(userContext, provinceCenterEmployeeId,anotherProvinceCenterId);
 
		ProvinceCenterEmployee provinceCenterEmployee = loadProvinceCenterEmployee(userContext, provinceCenterEmployeeId, allTokens());	
		synchronized(provinceCenterEmployee){
			//will be good when the provinceCenterEmployee loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreProvinceCenter provinceCenter = loadRetailStoreProvinceCenter(userContext, anotherProvinceCenterId, emptyOptions());		
			provinceCenterEmployee.updateProvinceCenter(provinceCenter);		
			provinceCenterEmployee = saveProvinceCenterEmployee(userContext, provinceCenterEmployee, emptyOptions());
			
			return present(userContext,provinceCenterEmployee, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreProvinceCenter requestCandidateProvinceCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreProvinceCenter result = new CandidateRetailStoreProvinceCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreProvinceCenter> candidateList = retailStoreProvinceCenterDaoOf(userContext).requestCandidateRetailStoreProvinceCenterForProvinceCenterEmployee(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected ProvinceCenterDepartment loadProvinceCenterDepartment(RetailscmUserContext userContext, String newDepartmentId, Map<String,Object> options) throws Exception
 	{

 		return provinceCenterDepartmentDaoOf(userContext).load(newDepartmentId, options);
 	}
 	


	

 	protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(RetailscmUserContext userContext, String newProvinceCenterId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreProvinceCenterDaoOf(userContext).load(newProvinceCenterId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion) throws Exception {
		//deleteInternal(userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String provinceCenterEmployeeId, int provinceCenterEmployeeVersion) throws Exception{

		provinceCenterEmployeeDaoOf(userContext).delete(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
	}

	public ProvinceCenterEmployee forgetByAll(RetailscmUserContext userContext, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion) throws Exception {
		return forgetByAllInternal(userContext, provinceCenterEmployeeId, provinceCenterEmployeeVersion);
	}
	protected ProvinceCenterEmployee forgetByAllInternal(RetailscmUserContext userContext,
			String provinceCenterEmployeeId, int provinceCenterEmployeeVersion) throws Exception{

		return provinceCenterEmployeeDaoOf(userContext).disconnectFromAll(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProvinceCenterEmployeeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return provinceCenterEmployeeDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, ProvinceCenterEmployee newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    provinceCenterEmployeeDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
  }

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}

		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
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
		//   ProvinceCenterEmployee newProvinceCenterEmployee = this.createProvinceCenterEmployee(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newProvinceCenterEmployee
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ProvinceCenterEmployee.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<ProvinceCenterEmployee> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<ProvinceCenterDepartment> departmentList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, ProvinceCenterDepartment.class);
		userContext.getDAOGroup().enhanceList(departmentList, ProvinceCenterDepartment.class);
		List<RetailStoreProvinceCenter> provinceCenterList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreProvinceCenter.class);
		userContext.getDAOGroup().enhanceList(provinceCenterList, RetailStoreProvinceCenter.class);


    }
	
	public Object listByDepartment(RetailscmUserContext userContext,String departmentId) throws Exception {
		return listPageByDepartment(userContext, departmentId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDepartment(RetailscmUserContext userContext,String departmentId, int start, int count) throws Exception {
		SmartList<ProvinceCenterEmployee> list = provinceCenterEmployeeDaoOf(userContext).findProvinceCenterEmployeeByDepartment(departmentId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(ProvinceCenterEmployee.class);
		page.setContainerObject(ProvinceCenterDepartment.withId(departmentId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("省中心员工列表");
		page.setRequestName("listByDepartment");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDepartment/%s/",  getBeanName(), departmentId)));

		page.assemblerContent(userContext, "listByDepartment");
		return page.doRender(userContext);
	}
  
	public Object listByProvinceCenter(RetailscmUserContext userContext,String provinceCenterId) throws Exception {
		return listPageByProvinceCenter(userContext, provinceCenterId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByProvinceCenter(RetailscmUserContext userContext,String provinceCenterId, int start, int count) throws Exception {
		SmartList<ProvinceCenterEmployee> list = provinceCenterEmployeeDaoOf(userContext).findProvinceCenterEmployeeByProvinceCenter(provinceCenterId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(ProvinceCenterEmployee.class);
		page.setContainerObject(RetailStoreProvinceCenter.withId(provinceCenterId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("省中心员工列表");
		page.setRequestName("listByProvinceCenter");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByProvinceCenter/%s/",  getBeanName(), provinceCenterId)));

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
 	public Object wxappview(RetailscmUserContext userContext, String provinceCenterEmployeeId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getProvinceCenterEmployeeDetailScope().clone();
		ProvinceCenterEmployee merchantObj = (ProvinceCenterEmployee) this.view(userContext, provinceCenterEmployeeId);
    String merchantObjId = provinceCenterEmployeeId;
    String linkToUrl =	"provinceCenterEmployeeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "省中心员工"+"详情";
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
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-mobile")
				    .put("fieldName", "mobile")
				    .put("label", "手机")
				    .put("type", "mobile")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("mobile", merchantObj.getMobile());

		propList.add(
				MapUtil.put("id", "4-email")
				    .put("fieldName", "email")
				    .put("label", "电子邮件")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("email", merchantObj.getEmail());

		propList.add(
				MapUtil.put("id", "5-founded")
				    .put("fieldName", "founded")
				    .put("label", "成立")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("founded", merchantObj.getFounded());

		propList.add(
				MapUtil.put("id", "6-department")
				    .put("fieldName", "department")
				    .put("label", "部门")
				    .put("type", "auto")
				    .put("linkToUrl", "provinceCenterDepartmentManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"manager\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("department", merchantObj.getDepartment());

		propList.add(
				MapUtil.put("id", "7-provinceCenter")
				    .put("fieldName", "provinceCenter")
				    .put("label", "省中心")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreProvinceCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("provinceCenter", merchantObj.getProvinceCenter());

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


