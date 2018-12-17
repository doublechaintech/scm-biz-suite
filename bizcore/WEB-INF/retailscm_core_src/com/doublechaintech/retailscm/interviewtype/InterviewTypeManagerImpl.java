
package com.doublechaintech.retailscm.interviewtype;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;


import com.doublechaintech.retailscm.Message;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;

import com.doublechaintech.retailscm.RetailscmUserContext;
//import com.doublechaintech.retailscm.BaseManagerImpl;
import com.doublechaintech.retailscm.RetailscmCheckerManager;
import com.doublechaintech.retailscm.CustomRetailscmCheckerManager;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.interviewtype.InterviewType;






public class InterviewTypeManagerImpl extends CustomRetailscmCheckerManager implements InterviewTypeManager {
	
	private static final String SERVICE_TYPE = "InterviewType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws InterviewTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new InterviewTypeManagerException(message);

	}
	
	

 	protected InterviewType saveInterviewType(RetailscmUserContext userContext, InterviewType interviewType, String [] tokensExpr) throws Exception{	
 		//return getInterviewTypeDAO().save(interviewType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveInterviewType(userContext, interviewType, tokens);
 	}
 	
 	protected InterviewType saveInterviewTypeDetail(RetailscmUserContext userContext, InterviewType interviewType) throws Exception{	

 		
 		return saveInterviewType(userContext, interviewType, allTokens());
 	}
 	
 	public InterviewType loadInterviewType(RetailscmUserContext userContext, String interviewTypeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfInterviewType(interviewTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( InterviewTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		InterviewType interviewType = loadInterviewType( userContext, interviewTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,interviewType, tokens);
 	}
 	
 	
 	 public InterviewType searchInterviewType(RetailscmUserContext userContext, String interviewTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfInterviewType(interviewTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( InterviewTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		InterviewType interviewType = loadInterviewType( userContext, interviewTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,interviewType, tokens);
 	}
 	
 	

 	protected InterviewType present(RetailscmUserContext userContext, InterviewType interviewType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,interviewType,tokens);
		
		
		InterviewType  interviewTypeToPresent = userContext.getDAOGroup().getInterviewTypeDAO().present(interviewType, tokens);
		
		List<BaseEntity> entityListToNaming = interviewTypeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getInterviewTypeDAO().alias(entityListToNaming);
		
		return  interviewTypeToPresent;
		
		
	}
 
 	
 	
 	public InterviewType loadInterviewTypeDetail(RetailscmUserContext userContext, String interviewTypeId) throws Exception{	
 		InterviewType interviewType = loadInterviewType( userContext, interviewTypeId, allTokens());
 		return present(userContext,interviewType, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String interviewTypeId) throws Exception{	
 		InterviewType interviewType = loadInterviewType( userContext, interviewTypeId, viewTokens());
 		return present(userContext,interviewType, allTokens());
		
 	}
 	protected InterviewType saveInterviewType(RetailscmUserContext userContext, InterviewType interviewType, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getInterviewTypeDAO().save(interviewType, tokens);
 	}
 	protected InterviewType loadInterviewType(RetailscmUserContext userContext, String interviewTypeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfInterviewType(interviewTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( InterviewTypeManagerException.class);

 
 		return userContext.getDAOGroup().getInterviewTypeDAO().load(interviewTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, InterviewType interviewType, Map<String, Object> tokens){
		super.addActions(userContext, interviewType, tokens);
		
		addAction(userContext, interviewType, tokens,"@create","createInterviewType","createInterviewType/","main","primary");
		addAction(userContext, interviewType, tokens,"@update","updateInterviewType","updateInterviewType/"+interviewType.getId()+"/","main","primary");
		addAction(userContext, interviewType, tokens,"@copy","cloneInterviewType","cloneInterviewType/"+interviewType.getId()+"/","main","primary");
		
		addAction(userContext, interviewType, tokens,"interview_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+interviewType.getId()+"/","main","primary");
		addAction(userContext, interviewType, tokens,"interview_type.addEmployeeInterview","addEmployeeInterview","addEmployeeInterview/"+interviewType.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, interviewType, tokens,"interview_type.removeEmployeeInterview","removeEmployeeInterview","removeEmployeeInterview/"+interviewType.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, interviewType, tokens,"interview_type.updateEmployeeInterview","updateEmployeeInterview","updateEmployeeInterview/"+interviewType.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, interviewType, tokens,"interview_type.copyEmployeeInterviewFrom","copyEmployeeInterviewFrom","copyEmployeeInterviewFrom/"+interviewType.getId()+"/","employeeInterviewList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, InterviewType interviewType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public InterviewType createInterviewType(RetailscmUserContext userContext,String code, String companyId, String description, String detailDescription) throws Exception
	{
		
		

		

		userContext.getChecker().checkCodeOfInterviewType(code);
		userContext.getChecker().checkDescriptionOfInterviewType(description);
		userContext.getChecker().checkDetailDescriptionOfInterviewType(detailDescription);
	
		userContext.getChecker().throwExceptionIfHasErrors(InterviewTypeManagerException.class);


		InterviewType interviewType=createNewInterviewType();	

		interviewType.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		interviewType.setCompany(company);
		
		
		interviewType.setDescription(description);
		interviewType.setDetailDescription(detailDescription);

		interviewType = saveInterviewType(userContext, interviewType, emptyOptions());
		
		onNewInstanceCreated(userContext, interviewType);
		return interviewType;

		
	}
	protected InterviewType createNewInterviewType() 
	{
		
		return new InterviewType();		
	}
	
	protected void checkParamsForUpdatingInterviewType(RetailscmUserContext userContext,String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfInterviewType(interviewTypeId);
		userContext.getChecker().checkVersionOfInterviewType( interviewTypeVersion);
		

		if(InterviewType.CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkCodeOfInterviewType(parseString(newValueExpr));
		}		

		
		if(InterviewType.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfInterviewType(parseString(newValueExpr));
		}
		if(InterviewType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDetailDescriptionOfInterviewType(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(InterviewTypeManagerException.class);
	
		
	}
	
	
	
	public InterviewType clone(RetailscmUserContext userContext, String fromInterviewTypeId) throws Exception{
		
		return userContext.getDAOGroup().getInterviewTypeDAO().clone(fromInterviewTypeId, this.allTokens());
	}
	
	public InterviewType internalSaveInterviewType(RetailscmUserContext userContext, InterviewType interviewType) throws Exception 
	{
		return internalSaveInterviewType(userContext, interviewType, allTokens());

	}
	public InterviewType internalSaveInterviewType(RetailscmUserContext userContext, InterviewType interviewType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingInterviewType(userContext, interviewTypeId, interviewTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(interviewType){ 
			//will be good when the interviewType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to InterviewType.
			
			
			interviewType = saveInterviewType(userContext, interviewType, options);
			return interviewType;
			
		}

	}
	
	public InterviewType updateInterviewType(RetailscmUserContext userContext,String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingInterviewType(userContext, interviewTypeId, interviewTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());
		if(interviewType.getVersion() != interviewTypeVersion){
			String message = "The target version("+interviewType.getVersion()+") is not equals to version("+interviewTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(interviewType){ 
			//will be good when the interviewType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to InterviewType.
			
			interviewType.changeProperty(property, newValueExpr);
			interviewType = saveInterviewType(userContext, interviewType, tokens().done());
			return present(userContext,interviewType, mergedAllTokens(tokensExpr));
			//return saveInterviewType(userContext, interviewType, tokens().done());
		}

	}
	
	public InterviewType updateInterviewTypeProperty(RetailscmUserContext userContext,String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingInterviewType(userContext, interviewTypeId, interviewTypeVersion, property, newValueExpr, tokensExpr);
		
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());
		if(interviewType.getVersion() != interviewTypeVersion){
			String message = "The target version("+interviewType.getVersion()+") is not equals to version("+interviewTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(interviewType){ 
			//will be good when the interviewType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to InterviewType.
			
			interviewType.changeProperty(property, newValueExpr);
			
			interviewType = saveInterviewType(userContext, interviewType, tokens().done());
			return present(userContext,interviewType, mergedAllTokens(tokensExpr));
			//return saveInterviewType(userContext, interviewType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected InterviewTypeTokens tokens(){
		return InterviewTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return InterviewTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeInterviewListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return InterviewTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String interviewTypeId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfInterviewType(interviewTypeId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(InterviewTypeManagerException.class);
 		
 	}
 	public InterviewType transferToAnotherCompany(RetailscmUserContext userContext, String interviewTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, interviewTypeId,anotherCompanyId);
 
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());	
		synchronized(interviewType){
			//will be good when the interviewType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			interviewType.updateCompany(company);		
			interviewType = saveInterviewType(userContext, interviewType, emptyOptions());
			
			return present(userContext,interviewType, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateCompany(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForInterviewType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String interviewTypeId, int interviewTypeVersion) throws Exception {
		//deleteInternal(userContext, interviewTypeId, interviewTypeVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String interviewTypeId, int interviewTypeVersion) throws Exception{
			
		userContext.getDAOGroup().getInterviewTypeDAO().delete(interviewTypeId, interviewTypeVersion);
	}
	
	public InterviewType forgetByAll(RetailscmUserContext userContext, String interviewTypeId, int interviewTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, interviewTypeId, interviewTypeVersion);		
	}
	protected InterviewType forgetByAllInternal(RetailscmUserContext userContext,
			String interviewTypeId, int interviewTypeVersion) throws Exception{
			
		return userContext.getDAOGroup().getInterviewTypeDAO().disconnectFromAll(interviewTypeId, interviewTypeVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new InterviewTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getInterviewTypeDAO().deleteAll();
	}


	//disconnect InterviewType with employee in EmployeeInterview
	protected InterviewType breakWithEmployeeInterviewByEmployee(RetailscmUserContext userContext, String interviewTypeId, String employeeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());

			synchronized(interviewType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getInterviewTypeDAO().planToRemoveEmployeeInterviewListWithEmployee(interviewType, employeeId, this.emptyOptions());

				interviewType = saveInterviewType(userContext, interviewType, tokens().withEmployeeInterviewList().done());
				return interviewType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployeeInterview(RetailscmUserContext userContext, String interviewTypeId, String employeeId, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfInterviewType(interviewTypeId);

		
		userContext.getChecker().checkEmployeeIdOfEmployeeInterview(employeeId);
		
		userContext.getChecker().checkRemarkOfEmployeeInterview(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(InterviewTypeManagerException.class);

	
	}
	public  InterviewType addEmployeeInterview(RetailscmUserContext userContext, String interviewTypeId, String employeeId, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeInterview(userContext,interviewTypeId,employeeId, remark,tokensExpr);
		
		EmployeeInterview employeeInterview = createEmployeeInterview(userContext,employeeId, remark);
		
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());
		synchronized(interviewType){ 
			//Will be good when the interviewType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			interviewType.addEmployeeInterview( employeeInterview );		
			interviewType = saveInterviewType(userContext, interviewType, tokens().withEmployeeInterviewList().done());
			
			userContext.getManagerGroup().getEmployeeInterviewManager().onNewInstanceCreated(userContext, employeeInterview);
			return present(userContext,interviewType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeInterviewProperties(RetailscmUserContext userContext, String interviewTypeId,String id,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfInterviewType(interviewTypeId);
		userContext.getChecker().checkIdOfEmployeeInterview(id);
		
		userContext.getChecker().checkRemarkOfEmployeeInterview( remark);

		userContext.getChecker().throwExceptionIfHasErrors(InterviewTypeManagerException.class);
		
	}
	public  InterviewType updateEmployeeInterviewProperties(RetailscmUserContext userContext, String interviewTypeId, String id,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeInterviewProperties(userContext,interviewTypeId,id,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeInterviewListList()
				.searchEmployeeInterviewListWith(EmployeeInterview.ID_PROPERTY, "is", id).done();
		
		InterviewType interviewTypeToUpdate = loadInterviewType(userContext, interviewTypeId, options);
		
		if(interviewTypeToUpdate.getEmployeeInterviewList().isEmpty()){
			throw new InterviewTypeManagerException("EmployeeInterview is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeInterview item = interviewTypeToUpdate.getEmployeeInterviewList().first();
		
		item.updateRemark( remark );

		
		//checkParamsForAddingEmployeeInterview(userContext,interviewTypeId,name, code, used,tokensExpr);
		InterviewType interviewType = saveInterviewType(userContext, interviewTypeToUpdate, tokens().withEmployeeInterviewList().done());
		synchronized(interviewType){ 
			return present(userContext,interviewType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeInterview createEmployeeInterview(RetailscmUserContext userContext, String employeeId, String remark) throws Exception{

		EmployeeInterview employeeInterview = new EmployeeInterview();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeInterview.setEmployee(employee);		
		employeeInterview.setRemark(remark);
	
		
		return employeeInterview;
	
		
	}
	
	protected EmployeeInterview createIndexedEmployeeInterview(String id, int version){

		EmployeeInterview employeeInterview = new EmployeeInterview();
		employeeInterview.setId(id);
		employeeInterview.setVersion(version);
		return employeeInterview;			
		
	}
	
	protected void checkParamsForRemovingEmployeeInterviewList(RetailscmUserContext userContext, String interviewTypeId, 
			String employeeInterviewIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfInterviewType(interviewTypeId);
		for(String employeeInterviewId: employeeInterviewIds){
			userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(InterviewTypeManagerException.class);
		
	}
	public  InterviewType removeEmployeeInterviewList(RetailscmUserContext userContext, String interviewTypeId, 
			String employeeInterviewIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeInterviewList(userContext, interviewTypeId,  employeeInterviewIds, tokensExpr);
			
			
			InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());
			synchronized(interviewType){ 
				//Will be good when the interviewType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getInterviewTypeDAO().planToRemoveEmployeeInterviewList(interviewType, employeeInterviewIds, allTokens());
				interviewType = saveInterviewType(userContext, interviewType, tokens().withEmployeeInterviewList().done());
				deleteRelationListInGraph(userContext, interviewType.getEmployeeInterviewList());
				return present(userContext,interviewType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeInterview(RetailscmUserContext userContext, String interviewTypeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfInterviewType( interviewTypeId);
		userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
		userContext.getChecker().checkVersionOfEmployeeInterview(employeeInterviewVersion);
		userContext.getChecker().throwExceptionIfHasErrors(InterviewTypeManagerException.class);
	
	}
	public  InterviewType removeEmployeeInterview(RetailscmUserContext userContext, String interviewTypeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeInterview(userContext,interviewTypeId, employeeInterviewId, employeeInterviewVersion,tokensExpr);
		
		EmployeeInterview employeeInterview = createIndexedEmployeeInterview(employeeInterviewId, employeeInterviewVersion);
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());
		synchronized(interviewType){ 
			//Will be good when the interviewType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			interviewType.removeEmployeeInterview( employeeInterview );		
			interviewType = saveInterviewType(userContext, interviewType, tokens().withEmployeeInterviewList().done());
			deleteRelationInGraph(userContext, employeeInterview);
			return present(userContext,interviewType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeInterview(RetailscmUserContext userContext, String interviewTypeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfInterviewType( interviewTypeId);
		userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
		userContext.getChecker().checkVersionOfEmployeeInterview(employeeInterviewVersion);
		userContext.getChecker().throwExceptionIfHasErrors(InterviewTypeManagerException.class);
	
	}
	public  InterviewType copyEmployeeInterviewFrom(RetailscmUserContext userContext, String interviewTypeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeInterview(userContext,interviewTypeId, employeeInterviewId, employeeInterviewVersion,tokensExpr);
		
		EmployeeInterview employeeInterview = createIndexedEmployeeInterview(employeeInterviewId, employeeInterviewVersion);
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());
		synchronized(interviewType){ 
			//Will be good when the interviewType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			interviewType.copyEmployeeInterviewFrom( employeeInterview );		
			interviewType = saveInterviewType(userContext, interviewType, tokens().withEmployeeInterviewList().done());
			
			userContext.getManagerGroup().getEmployeeInterviewManager().onNewInstanceCreated(userContext, (EmployeeInterview)interviewType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,interviewType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeInterview(RetailscmUserContext userContext, String interviewTypeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfInterviewType(interviewTypeId);
		userContext.getChecker().checkIdOfEmployeeInterview(employeeInterviewId);
		userContext.getChecker().checkVersionOfEmployeeInterview(employeeInterviewVersion);
		

		if(EmployeeInterview.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEmployeeInterview(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(InterviewTypeManagerException.class);
	
	}
	
	public  InterviewType updateEmployeeInterview(RetailscmUserContext userContext, String interviewTypeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeInterview(userContext, interviewTypeId, employeeInterviewId, employeeInterviewVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeInterviewList().searchEmployeeInterviewListWith(EmployeeInterview.ID_PROPERTY, "eq", employeeInterviewId).done();
		
		
		
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, loadTokens);
		
		synchronized(interviewType){ 
			//Will be good when the interviewType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//interviewType.removeEmployeeInterview( employeeInterview );	
			//make changes to AcceleraterAccount.
			EmployeeInterview employeeInterviewIndex = createIndexedEmployeeInterview(employeeInterviewId, employeeInterviewVersion);
		
			EmployeeInterview employeeInterview = interviewType.findTheEmployeeInterview(employeeInterviewIndex);
			if(employeeInterview == null){
				throw new InterviewTypeManagerException(employeeInterview+" is NOT FOUND" );
			}
			
			employeeInterview.changeProperty(property, newValueExpr);
			
			interviewType = saveInterviewType(userContext, interviewType, tokens().withEmployeeInterviewList().done());
			return present(userContext,interviewType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, InterviewType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


