
package com.doublechaintech.retailscm.accountingdocumentline;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;

import com.doublechaintech.retailscm.accountingdocument.CandidateAccountingDocument;
import com.doublechaintech.retailscm.accountingsubject.CandidateAccountingSubject;







public class AccountingDocumentLineManagerImpl extends CustomRetailscmCheckerManager implements AccountingDocumentLineManager, BusinessHandler{

	// Only some of ods have such function
	
	



  


	private static final String SERVICE_TYPE = "AccountingDocumentLine";
	@Override
	public AccountingDocumentLineDAO daoOf(RetailscmUserContext userContext) {
		return accountingDocumentLineDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws AccountingDocumentLineManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new AccountingDocumentLineManagerException(message);

	}



 	protected AccountingDocumentLine saveAccountingDocumentLine(RetailscmUserContext userContext, AccountingDocumentLine accountingDocumentLine, String [] tokensExpr) throws Exception{	
 		//return getAccountingDocumentLineDAO().save(accountingDocumentLine, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAccountingDocumentLine(userContext, accountingDocumentLine, tokens);
 	}
 	
 	protected AccountingDocumentLine saveAccountingDocumentLineDetail(RetailscmUserContext userContext, AccountingDocumentLine accountingDocumentLine) throws Exception{	

 		
 		return saveAccountingDocumentLine(userContext, accountingDocumentLine, allTokens());
 	}
 	
 	public AccountingDocumentLine loadAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentLineId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentLineManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine( userContext, accountingDocumentLineId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentLine, tokens);
 	}
 	
 	
 	 public AccountingDocumentLine searchAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentLineId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentLineManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine( userContext, accountingDocumentLineId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,accountingDocumentLine, tokens);
 	}
 	
 	

 	protected AccountingDocumentLine present(RetailscmUserContext userContext, AccountingDocumentLine accountingDocumentLine, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,accountingDocumentLine,tokens);
		
		
		AccountingDocumentLine  accountingDocumentLineToPresent = accountingDocumentLineDaoOf(userContext).present(accountingDocumentLine, tokens);
		
		List<BaseEntity> entityListToNaming = accountingDocumentLineToPresent.collectRefercencesFromLists();
		accountingDocumentLineDaoOf(userContext).alias(entityListToNaming);
		
		return  accountingDocumentLineToPresent;
		
		
	}
 
 	
 	
 	public AccountingDocumentLine loadAccountingDocumentLineDetail(RetailscmUserContext userContext, String accountingDocumentLineId) throws Exception{	
 		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine( userContext, accountingDocumentLineId, allTokens());
 		return present(userContext,accountingDocumentLine, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String accountingDocumentLineId) throws Exception{	
 		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine( userContext, accountingDocumentLineId, viewTokens());
 		return present(userContext,accountingDocumentLine, allTokens());
		
 	}
 	protected AccountingDocumentLine saveAccountingDocumentLine(RetailscmUserContext userContext, AccountingDocumentLine accountingDocumentLine, Map<String,Object>tokens) throws Exception{	
 		return accountingDocumentLineDaoOf(userContext).save(accountingDocumentLine, tokens);
 	}
 	protected AccountingDocumentLine loadAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentLineId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		checkerOf(userContext).throwExceptionIfHasErrors( AccountingDocumentLineManagerException.class);

 
 		return accountingDocumentLineDaoOf(userContext).load(accountingDocumentLineId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentLine accountingDocumentLine, Map<String, Object> tokens){
		super.addActions(userContext, accountingDocumentLine, tokens);
		
		addAction(userContext, accountingDocumentLine, tokens,"@create","createAccountingDocumentLine","createAccountingDocumentLine/","main","primary");
		addAction(userContext, accountingDocumentLine, tokens,"@update","updateAccountingDocumentLine","updateAccountingDocumentLine/"+accountingDocumentLine.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentLine, tokens,"@copy","cloneAccountingDocumentLine","cloneAccountingDocumentLine/"+accountingDocumentLine.getId()+"/","main","primary");
		
		addAction(userContext, accountingDocumentLine, tokens,"accounting_document_line.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+accountingDocumentLine.getId()+"/","main","primary");
		addAction(userContext, accountingDocumentLine, tokens,"accounting_document_line.transfer_to_accounting_subject","transferToAnotherAccountingSubject","transferToAnotherAccountingSubject/"+accountingDocumentLine.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, AccountingDocumentLine accountingDocumentLine, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public AccountingDocumentLine createAccountingDocumentLine(RetailscmUserContext userContext, String name,String code,String direct,BigDecimal amount,String belongsToId,String accountingSubjectId) throws Exception
	//public AccountingDocumentLine createAccountingDocumentLine(RetailscmUserContext userContext,String name, String code, String direct, BigDecimal amount, String belongsToId, String accountingSubjectId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfAccountingDocumentLine(name);
		checkerOf(userContext).checkCodeOfAccountingDocumentLine(code);
		checkerOf(userContext).checkDirectOfAccountingDocumentLine(direct);
		checkerOf(userContext).checkAmountOfAccountingDocumentLine(amount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentLineManagerException.class);


		AccountingDocumentLine accountingDocumentLine=createNewAccountingDocumentLine();	

		accountingDocumentLine.setName(name);
		accountingDocumentLine.setCode(code);
		accountingDocumentLine.setDirect(direct);
		accountingDocumentLine.setAmount(amount);
			
		AccountingDocument belongsTo = loadAccountingDocument(userContext, belongsToId,emptyOptions());
		accountingDocumentLine.setBelongsTo(belongsTo);
		
		
			
		AccountingSubject accountingSubject = loadAccountingSubject(userContext, accountingSubjectId,emptyOptions());
		accountingDocumentLine.setAccountingSubject(accountingSubject);
		
		

		accountingDocumentLine = saveAccountingDocumentLine(userContext, accountingDocumentLine, emptyOptions());
		
		onNewInstanceCreated(userContext, accountingDocumentLine);
		return accountingDocumentLine;


	}
	protected AccountingDocumentLine createNewAccountingDocumentLine()
	{

		return new AccountingDocumentLine();
	}

	protected void checkParamsForUpdatingAccountingDocumentLine(RetailscmUserContext userContext,String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
		checkerOf(userContext).checkVersionOfAccountingDocumentLine( accountingDocumentLineVersion);
		

		if(AccountingDocumentLine.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfAccountingDocumentLine(parseString(newValueExpr));
		
			
		}
		if(AccountingDocumentLine.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfAccountingDocumentLine(parseString(newValueExpr));
		
			
		}
		if(AccountingDocumentLine.DIRECT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDirectOfAccountingDocumentLine(parseString(newValueExpr));
		
			
		}
		if(AccountingDocumentLine.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfAccountingDocumentLine(parseBigDecimal(newValueExpr));
		
			
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentLineManagerException.class);


	}



	public AccountingDocumentLine clone(RetailscmUserContext userContext, String fromAccountingDocumentLineId) throws Exception{

		return accountingDocumentLineDaoOf(userContext).clone(fromAccountingDocumentLineId, this.allTokens());
	}

	public AccountingDocumentLine internalSaveAccountingDocumentLine(RetailscmUserContext userContext, AccountingDocumentLine accountingDocumentLine) throws Exception
	{
		return internalSaveAccountingDocumentLine(userContext, accountingDocumentLine, allTokens());

	}
	public AccountingDocumentLine internalSaveAccountingDocumentLine(RetailscmUserContext userContext, AccountingDocumentLine accountingDocumentLine, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingAccountingDocumentLine(userContext, accountingDocumentLineId, accountingDocumentLineVersion, property, newValueExpr, tokensExpr);


		synchronized(accountingDocumentLine){
			//will be good when the accountingDocumentLine loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentLine.
			if (accountingDocumentLine.isChanged()){
			
			}
			accountingDocumentLine = saveAccountingDocumentLine(userContext, accountingDocumentLine, options);
			return accountingDocumentLine;

		}

	}

	public AccountingDocumentLine updateAccountingDocumentLine(RetailscmUserContext userContext,String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentLine(userContext, accountingDocumentLineId, accountingDocumentLineVersion, property, newValueExpr, tokensExpr);



		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine(userContext, accountingDocumentLineId, allTokens());
		if(accountingDocumentLine.getVersion() != accountingDocumentLineVersion){
			String message = "The target version("+accountingDocumentLine.getVersion()+") is not equals to version("+accountingDocumentLineVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentLine){
			//will be good when the accountingDocumentLine loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentLine.
			
			accountingDocumentLine.changeProperty(property, newValueExpr);
			accountingDocumentLine = saveAccountingDocumentLine(userContext, accountingDocumentLine, tokens().done());
			return present(userContext,accountingDocumentLine, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentLine(userContext, accountingDocumentLine, tokens().done());
		}

	}

	public AccountingDocumentLine updateAccountingDocumentLineProperty(RetailscmUserContext userContext,String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountingDocumentLine(userContext, accountingDocumentLineId, accountingDocumentLineVersion, property, newValueExpr, tokensExpr);

		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine(userContext, accountingDocumentLineId, allTokens());
		if(accountingDocumentLine.getVersion() != accountingDocumentLineVersion){
			String message = "The target version("+accountingDocumentLine.getVersion()+") is not equals to version("+accountingDocumentLineVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(accountingDocumentLine){
			//will be good when the accountingDocumentLine loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AccountingDocumentLine.

			accountingDocumentLine.changeProperty(property, newValueExpr);
			
			accountingDocumentLine = saveAccountingDocumentLine(userContext, accountingDocumentLine, tokens().done());
			return present(userContext,accountingDocumentLine, mergedAllTokens(tokensExpr));
			//return saveAccountingDocumentLine(userContext, accountingDocumentLine, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected AccountingDocumentLineTokens tokens(){
		return AccountingDocumentLineTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AccountingDocumentLineTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AccountingDocumentLineTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailscmUserContext userContext, String accountingDocumentLineId, String anotherBelongsToId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
 		checkerOf(userContext).checkIdOfAccountingDocument(anotherBelongsToId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentLineManagerException.class);

 	}
 	public AccountingDocumentLine transferToAnotherBelongsTo(RetailscmUserContext userContext, String accountingDocumentLineId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, accountingDocumentLineId,anotherBelongsToId);
 
		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine(userContext, accountingDocumentLineId, allTokens());	
		synchronized(accountingDocumentLine){
			//will be good when the accountingDocumentLine loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocument belongsTo = loadAccountingDocument(userContext, anotherBelongsToId, emptyOptions());		
			accountingDocumentLine.updateBelongsTo(belongsTo);		
			accountingDocumentLine = saveAccountingDocumentLine(userContext, accountingDocumentLine, emptyOptions());
			
			return present(userContext,accountingDocumentLine, allTokens());
			
		}

 	}

	


	public CandidateAccountingDocument requestCandidateBelongsTo(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocument result = new CandidateAccountingDocument();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocument> candidateList = accountingDocumentDaoOf(userContext).requestCandidateAccountingDocumentForAccountingDocumentLine(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherAccountingSubject(RetailscmUserContext userContext, String accountingDocumentLineId, String anotherAccountingSubjectId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfAccountingDocumentLine(accountingDocumentLineId);
 		checkerOf(userContext).checkIdOfAccountingSubject(anotherAccountingSubjectId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AccountingDocumentLineManagerException.class);

 	}
 	public AccountingDocumentLine transferToAnotherAccountingSubject(RetailscmUserContext userContext, String accountingDocumentLineId, String anotherAccountingSubjectId) throws Exception
 	{
 		checkParamsForTransferingAnotherAccountingSubject(userContext, accountingDocumentLineId,anotherAccountingSubjectId);
 
		AccountingDocumentLine accountingDocumentLine = loadAccountingDocumentLine(userContext, accountingDocumentLineId, allTokens());	
		synchronized(accountingDocumentLine){
			//will be good when the accountingDocumentLine loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingSubject accountingSubject = loadAccountingSubject(userContext, anotherAccountingSubjectId, emptyOptions());		
			accountingDocumentLine.updateAccountingSubject(accountingSubject);		
			accountingDocumentLine = saveAccountingDocumentLine(userContext, accountingDocumentLine, emptyOptions());
			
			return present(userContext,accountingDocumentLine, allTokens());
			
		}

 	}

	


	public CandidateAccountingSubject requestCandidateAccountingSubject(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingSubject result = new CandidateAccountingSubject();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("accountingSubjectCode");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingSubject> candidateList = accountingSubjectDaoOf(userContext).requestCandidateAccountingSubjectForAccountingDocumentLine(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected AccountingDocument loadAccountingDocument(RetailscmUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{

 		return accountingDocumentDaoOf(userContext).load(newBelongsToId, options);
 	}
 	


	

 	protected AccountingSubject loadAccountingSubject(RetailscmUserContext userContext, String newAccountingSubjectId, Map<String,Object> options) throws Exception
 	{

 		return accountingSubjectDaoOf(userContext).load(newAccountingSubjectId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String accountingDocumentLineId, int accountingDocumentLineVersion) throws Exception {
		//deleteInternal(userContext, accountingDocumentLineId, accountingDocumentLineVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String accountingDocumentLineId, int accountingDocumentLineVersion) throws Exception{

		accountingDocumentLineDaoOf(userContext).delete(accountingDocumentLineId, accountingDocumentLineVersion);
	}

	public AccountingDocumentLine forgetByAll(RetailscmUserContext userContext, String accountingDocumentLineId, int accountingDocumentLineVersion) throws Exception {
		return forgetByAllInternal(userContext, accountingDocumentLineId, accountingDocumentLineVersion);
	}
	protected AccountingDocumentLine forgetByAllInternal(RetailscmUserContext userContext,
			String accountingDocumentLineId, int accountingDocumentLineVersion) throws Exception{

		return accountingDocumentLineDaoOf(userContext).disconnectFromAll(accountingDocumentLineId, accountingDocumentLineVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AccountingDocumentLineManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return accountingDocumentLineDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentLine newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
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
		//   AccountingDocumentLine newAccountingDocumentLine = this.createAccountingDocumentLine(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newAccountingDocumentLine
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, AccountingDocumentLine.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<AccountingDocumentLine> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<AccountingDocument> belongsToList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, AccountingDocument.class);
		userContext.getDAOGroup().enhanceList(belongsToList, AccountingDocument.class);
		List<AccountingSubject> accountingSubjectList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, AccountingSubject.class);
		userContext.getDAOGroup().enhanceList(accountingSubjectList, AccountingSubject.class);


    }
	
	public Object listByBelongsTo(RetailscmUserContext userContext,String belongsToId) throws Exception {
		return listPageByBelongsTo(userContext, belongsToId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBelongsTo(RetailscmUserContext userContext,String belongsToId, int start, int count) throws Exception {
		SmartList<AccountingDocumentLine> list = accountingDocumentLineDaoOf(userContext).findAccountingDocumentLineByBelongsTo(belongsToId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(AccountingDocumentLine.class);
		page.setContainerObject(AccountingDocument.withId(belongsToId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计凭证行列表");
		page.setRequestName("listByBelongsTo");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBelongsTo/%s/",  getBeanName(), belongsToId)));

		page.assemblerContent(userContext, "listByBelongsTo");
		return page.doRender(userContext);
	}
  
	public Object listByAccountingSubject(RetailscmUserContext userContext,String accountingSubjectId) throws Exception {
		return listPageByAccountingSubject(userContext, accountingSubjectId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByAccountingSubject(RetailscmUserContext userContext,String accountingSubjectId, int start, int count) throws Exception {
		SmartList<AccountingDocumentLine> list = accountingDocumentLineDaoOf(userContext).findAccountingDocumentLineByAccountingSubject(accountingSubjectId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(AccountingDocumentLine.class);
		page.setContainerObject(AccountingSubject.withId(accountingSubjectId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("会计凭证行列表");
		page.setRequestName("listByAccountingSubject");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByAccountingSubject/%s/",  getBeanName(), accountingSubjectId)));

		page.assemblerContent(userContext, "listByAccountingSubject");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String accountingDocumentLineId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getAccountingDocumentLineDetailScope().clone();
		AccountingDocumentLine merchantObj = (AccountingDocumentLine) this.view(userContext, accountingDocumentLineId);
    String merchantObjId = accountingDocumentLineId;
    String linkToUrl =	"accountingDocumentLineManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会计凭证行"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
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
				MapUtil.put("id", "3-code")
				    .put("fieldName", "code")
				    .put("label", "代码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("code", merchantObj.getCode());

		propList.add(
				MapUtil.put("id", "4-direct")
				    .put("fieldName", "direct")
				    .put("label", "直接")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("direct", merchantObj.getDirect());

		propList.add(
				MapUtil.put("id", "5-amount")
				    .put("fieldName", "amount")
				    .put("label", "金额")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("amount", merchantObj.getAmount());

		propList.add(
				MapUtil.put("id", "6-belongsTo")
				    .put("fieldName", "belongsTo")
				    .put("label", "属于")
				    .put("type", "auto")
				    .put("linkToUrl", "accountingDocumentManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"accounting_document_date\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("belongsTo", merchantObj.getBelongsTo());

		propList.add(
				MapUtil.put("id", "7-accountingSubject")
				    .put("fieldName", "accountingSubject")
				    .put("label", "会计科目")
				    .put("type", "auto")
				    .put("linkToUrl", "accountingSubjectManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"accounting_subject_class_code\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"accounting_subject_name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("accountingSubject", merchantObj.getAccountingSubject());

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


