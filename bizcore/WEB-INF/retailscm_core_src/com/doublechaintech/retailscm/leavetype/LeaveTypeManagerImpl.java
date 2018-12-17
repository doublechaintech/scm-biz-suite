
package com.doublechaintech.retailscm.leavetype;

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
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.leavetype.LeaveType;






public class LeaveTypeManagerImpl extends CustomRetailscmCheckerManager implements LeaveTypeManager {
	
	private static final String SERVICE_TYPE = "LeaveType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LeaveTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LeaveTypeManagerException(message);

	}
	
	

 	protected LeaveType saveLeaveType(RetailscmUserContext userContext, LeaveType leaveType, String [] tokensExpr) throws Exception{	
 		//return getLeaveTypeDAO().save(leaveType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLeaveType(userContext, leaveType, tokens);
 	}
 	
 	protected LeaveType saveLeaveTypeDetail(RetailscmUserContext userContext, LeaveType leaveType) throws Exception{	

 		
 		return saveLeaveType(userContext, leaveType, allTokens());
 	}
 	
 	public LeaveType loadLeaveType(RetailscmUserContext userContext, String leaveTypeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLeaveType(leaveTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( LeaveTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LeaveType leaveType = loadLeaveType( userContext, leaveTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,leaveType, tokens);
 	}
 	
 	
 	 public LeaveType searchLeaveType(RetailscmUserContext userContext, String leaveTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfLeaveType(leaveTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( LeaveTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LeaveType leaveType = loadLeaveType( userContext, leaveTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,leaveType, tokens);
 	}
 	
 	

 	protected LeaveType present(RetailscmUserContext userContext, LeaveType leaveType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,leaveType,tokens);
		
		
		LeaveType  leaveTypeToPresent = userContext.getDAOGroup().getLeaveTypeDAO().present(leaveType, tokens);
		
		List<BaseEntity> entityListToNaming = leaveTypeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getLeaveTypeDAO().alias(entityListToNaming);
		
		return  leaveTypeToPresent;
		
		
	}
 
 	
 	
 	public LeaveType loadLeaveTypeDetail(RetailscmUserContext userContext, String leaveTypeId) throws Exception{	
 		LeaveType leaveType = loadLeaveType( userContext, leaveTypeId, allTokens());
 		return present(userContext,leaveType, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String leaveTypeId) throws Exception{	
 		LeaveType leaveType = loadLeaveType( userContext, leaveTypeId, viewTokens());
 		return present(userContext,leaveType, allTokens());
		
 	}
 	protected LeaveType saveLeaveType(RetailscmUserContext userContext, LeaveType leaveType, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getLeaveTypeDAO().save(leaveType, tokens);
 	}
 	protected LeaveType loadLeaveType(RetailscmUserContext userContext, String leaveTypeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfLeaveType(leaveTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( LeaveTypeManagerException.class);

 
 		return userContext.getDAOGroup().getLeaveTypeDAO().load(leaveTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LeaveType leaveType, Map<String, Object> tokens){
		super.addActions(userContext, leaveType, tokens);
		
		addAction(userContext, leaveType, tokens,"@create","createLeaveType","createLeaveType/","main","primary");
		addAction(userContext, leaveType, tokens,"@update","updateLeaveType","updateLeaveType/"+leaveType.getId()+"/","main","primary");
		addAction(userContext, leaveType, tokens,"@copy","cloneLeaveType","cloneLeaveType/"+leaveType.getId()+"/","main","primary");
		
		addAction(userContext, leaveType, tokens,"leave_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+leaveType.getId()+"/","main","primary");
		addAction(userContext, leaveType, tokens,"leave_type.addEmployeeLeave","addEmployeeLeave","addEmployeeLeave/"+leaveType.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, leaveType, tokens,"leave_type.removeEmployeeLeave","removeEmployeeLeave","removeEmployeeLeave/"+leaveType.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, leaveType, tokens,"leave_type.updateEmployeeLeave","updateEmployeeLeave","updateEmployeeLeave/"+leaveType.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, leaveType, tokens,"leave_type.copyEmployeeLeaveFrom","copyEmployeeLeaveFrom","copyEmployeeLeaveFrom/"+leaveType.getId()+"/","employeeLeaveList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LeaveType leaveType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LeaveType createLeaveType(RetailscmUserContext userContext,String code, String companyId, String description, String detailDescription) throws Exception
	{
		
		

		

		userContext.getChecker().checkCodeOfLeaveType(code);
		userContext.getChecker().checkDescriptionOfLeaveType(description);
		userContext.getChecker().checkDetailDescriptionOfLeaveType(detailDescription);
	
		userContext.getChecker().throwExceptionIfHasErrors(LeaveTypeManagerException.class);


		LeaveType leaveType=createNewLeaveType();	

		leaveType.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		leaveType.setCompany(company);
		
		
		leaveType.setDescription(description);
		leaveType.setDetailDescription(detailDescription);

		leaveType = saveLeaveType(userContext, leaveType, emptyOptions());
		
		onNewInstanceCreated(userContext, leaveType);
		return leaveType;

		
	}
	protected LeaveType createNewLeaveType() 
	{
		
		return new LeaveType();		
	}
	
	protected void checkParamsForUpdatingLeaveType(RetailscmUserContext userContext,String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfLeaveType(leaveTypeId);
		userContext.getChecker().checkVersionOfLeaveType( leaveTypeVersion);
		

		if(LeaveType.CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkCodeOfLeaveType(parseString(newValueExpr));
		}		

		
		if(LeaveType.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfLeaveType(parseString(newValueExpr));
		}
		if(LeaveType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDetailDescriptionOfLeaveType(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(LeaveTypeManagerException.class);
	
		
	}
	
	
	
	public LeaveType clone(RetailscmUserContext userContext, String fromLeaveTypeId) throws Exception{
		
		return userContext.getDAOGroup().getLeaveTypeDAO().clone(fromLeaveTypeId, this.allTokens());
	}
	
	public LeaveType internalSaveLeaveType(RetailscmUserContext userContext, LeaveType leaveType) throws Exception 
	{
		return internalSaveLeaveType(userContext, leaveType, allTokens());

	}
	public LeaveType internalSaveLeaveType(RetailscmUserContext userContext, LeaveType leaveType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLeaveType(userContext, leaveTypeId, leaveTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(leaveType){ 
			//will be good when the leaveType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LeaveType.
			
			
			leaveType = saveLeaveType(userContext, leaveType, options);
			return leaveType;
			
		}

	}
	
	public LeaveType updateLeaveType(RetailscmUserContext userContext,String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLeaveType(userContext, leaveTypeId, leaveTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
		if(leaveType.getVersion() != leaveTypeVersion){
			String message = "The target version("+leaveType.getVersion()+") is not equals to version("+leaveTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(leaveType){ 
			//will be good when the leaveType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LeaveType.
			
			leaveType.changeProperty(property, newValueExpr);
			leaveType = saveLeaveType(userContext, leaveType, tokens().done());
			return present(userContext,leaveType, mergedAllTokens(tokensExpr));
			//return saveLeaveType(userContext, leaveType, tokens().done());
		}

	}
	
	public LeaveType updateLeaveTypeProperty(RetailscmUserContext userContext,String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLeaveType(userContext, leaveTypeId, leaveTypeVersion, property, newValueExpr, tokensExpr);
		
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
		if(leaveType.getVersion() != leaveTypeVersion){
			String message = "The target version("+leaveType.getVersion()+") is not equals to version("+leaveTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(leaveType){ 
			//will be good when the leaveType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LeaveType.
			
			leaveType.changeProperty(property, newValueExpr);
			
			leaveType = saveLeaveType(userContext, leaveType, tokens().done());
			return present(userContext,leaveType, mergedAllTokens(tokensExpr));
			//return saveLeaveType(userContext, leaveType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LeaveTypeTokens tokens(){
		return LeaveTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LeaveTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeLeaveListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LeaveTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String leaveTypeId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfLeaveType(leaveTypeId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(LeaveTypeManagerException.class);
 		
 	}
 	public LeaveType transferToAnotherCompany(RetailscmUserContext userContext, String leaveTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, leaveTypeId,anotherCompanyId);
 
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());	
		synchronized(leaveType){
			//will be good when the leaveType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			leaveType.updateCompany(company);		
			leaveType = saveLeaveType(userContext, leaveType, emptyOptions());
			
			return present(userContext,leaveType, allTokens());
			
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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForLeaveType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String leaveTypeId, int leaveTypeVersion) throws Exception {
		//deleteInternal(userContext, leaveTypeId, leaveTypeVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String leaveTypeId, int leaveTypeVersion) throws Exception{
			
		userContext.getDAOGroup().getLeaveTypeDAO().delete(leaveTypeId, leaveTypeVersion);
	}
	
	public LeaveType forgetByAll(RetailscmUserContext userContext, String leaveTypeId, int leaveTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, leaveTypeId, leaveTypeVersion);		
	}
	protected LeaveType forgetByAllInternal(RetailscmUserContext userContext,
			String leaveTypeId, int leaveTypeVersion) throws Exception{
			
		return userContext.getDAOGroup().getLeaveTypeDAO().disconnectFromAll(leaveTypeId, leaveTypeVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LeaveTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getLeaveTypeDAO().deleteAll();
	}


	//disconnect LeaveType with who in EmployeeLeave
	protected LeaveType breakWithEmployeeLeaveByWho(RetailscmUserContext userContext, String leaveTypeId, String whoId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());

			synchronized(leaveType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getLeaveTypeDAO().planToRemoveEmployeeLeaveListWithWho(leaveType, whoId, this.emptyOptions());

				leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
				return leaveType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, String whoId, int leaveDurationHour, String remark,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfLeaveType(leaveTypeId);

		
		userContext.getChecker().checkWhoIdOfEmployeeLeave(whoId);
		
		userContext.getChecker().checkLeaveDurationHourOfEmployeeLeave(leaveDurationHour);
		
		userContext.getChecker().checkRemarkOfEmployeeLeave(remark);
	
		userContext.getChecker().throwExceptionIfHasErrors(LeaveTypeManagerException.class);

	
	}
	public  LeaveType addEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, String whoId, int leaveDurationHour, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeLeave(userContext,leaveTypeId,whoId, leaveDurationHour, remark,tokensExpr);
		
		EmployeeLeave employeeLeave = createEmployeeLeave(userContext,whoId, leaveDurationHour, remark);
		
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
		synchronized(leaveType){ 
			//Will be good when the leaveType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			leaveType.addEmployeeLeave( employeeLeave );		
			leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
			
			userContext.getManagerGroup().getEmployeeLeaveManager().onNewInstanceCreated(userContext, employeeLeave);
			return present(userContext,leaveType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeLeaveProperties(RetailscmUserContext userContext, String leaveTypeId,String id,int leaveDurationHour,String remark,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLeaveType(leaveTypeId);
		userContext.getChecker().checkIdOfEmployeeLeave(id);
		
		userContext.getChecker().checkLeaveDurationHourOfEmployeeLeave( leaveDurationHour);
		userContext.getChecker().checkRemarkOfEmployeeLeave( remark);

		userContext.getChecker().throwExceptionIfHasErrors(LeaveTypeManagerException.class);
		
	}
	public  LeaveType updateEmployeeLeaveProperties(RetailscmUserContext userContext, String leaveTypeId, String id,int leaveDurationHour,String remark, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeLeaveProperties(userContext,leaveTypeId,id,leaveDurationHour,remark,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeLeaveListList()
				.searchEmployeeLeaveListWith(EmployeeLeave.ID_PROPERTY, "is", id).done();
		
		LeaveType leaveTypeToUpdate = loadLeaveType(userContext, leaveTypeId, options);
		
		if(leaveTypeToUpdate.getEmployeeLeaveList().isEmpty()){
			throw new LeaveTypeManagerException("EmployeeLeave is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeLeave item = leaveTypeToUpdate.getEmployeeLeaveList().first();
		
		item.updateLeaveDurationHour( leaveDurationHour );
		item.updateRemark( remark );

		
		//checkParamsForAddingEmployeeLeave(userContext,leaveTypeId,name, code, used,tokensExpr);
		LeaveType leaveType = saveLeaveType(userContext, leaveTypeToUpdate, tokens().withEmployeeLeaveList().done());
		synchronized(leaveType){ 
			return present(userContext,leaveType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeLeave createEmployeeLeave(RetailscmUserContext userContext, String whoId, int leaveDurationHour, String remark) throws Exception{

		EmployeeLeave employeeLeave = new EmployeeLeave();
		
		
		Employee  who = new Employee();
		who.setId(whoId);		
		employeeLeave.setWho(who);		
		employeeLeave.setLeaveDurationHour(leaveDurationHour);		
		employeeLeave.setRemark(remark);
	
		
		return employeeLeave;
	
		
	}
	
	protected EmployeeLeave createIndexedEmployeeLeave(String id, int version){

		EmployeeLeave employeeLeave = new EmployeeLeave();
		employeeLeave.setId(id);
		employeeLeave.setVersion(version);
		return employeeLeave;			
		
	}
	
	protected void checkParamsForRemovingEmployeeLeaveList(RetailscmUserContext userContext, String leaveTypeId, 
			String employeeLeaveIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfLeaveType(leaveTypeId);
		for(String employeeLeaveId: employeeLeaveIds){
			userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(LeaveTypeManagerException.class);
		
	}
	public  LeaveType removeEmployeeLeaveList(RetailscmUserContext userContext, String leaveTypeId, 
			String employeeLeaveIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeLeaveList(userContext, leaveTypeId,  employeeLeaveIds, tokensExpr);
			
			
			LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
			synchronized(leaveType){ 
				//Will be good when the leaveType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getLeaveTypeDAO().planToRemoveEmployeeLeaveList(leaveType, employeeLeaveIds, allTokens());
				leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
				deleteRelationListInGraph(userContext, leaveType.getEmployeeLeaveList());
				return present(userContext,leaveType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLeaveType( leaveTypeId);
		userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
		userContext.getChecker().checkVersionOfEmployeeLeave(employeeLeaveVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LeaveTypeManagerException.class);
	
	}
	public  LeaveType removeEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeLeave(userContext,leaveTypeId, employeeLeaveId, employeeLeaveVersion,tokensExpr);
		
		EmployeeLeave employeeLeave = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
		synchronized(leaveType){ 
			//Will be good when the leaveType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			leaveType.removeEmployeeLeave( employeeLeave );		
			leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
			deleteRelationInGraph(userContext, employeeLeave);
			return present(userContext,leaveType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfLeaveType( leaveTypeId);
		userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
		userContext.getChecker().checkVersionOfEmployeeLeave(employeeLeaveVersion);
		userContext.getChecker().throwExceptionIfHasErrors(LeaveTypeManagerException.class);
	
	}
	public  LeaveType copyEmployeeLeaveFrom(RetailscmUserContext userContext, String leaveTypeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeLeave(userContext,leaveTypeId, employeeLeaveId, employeeLeaveVersion,tokensExpr);
		
		EmployeeLeave employeeLeave = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
		synchronized(leaveType){ 
			//Will be good when the leaveType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			leaveType.copyEmployeeLeaveFrom( employeeLeave );		
			leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
			
			userContext.getManagerGroup().getEmployeeLeaveManager().onNewInstanceCreated(userContext, (EmployeeLeave)leaveType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,leaveType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfLeaveType(leaveTypeId);
		userContext.getChecker().checkIdOfEmployeeLeave(employeeLeaveId);
		userContext.getChecker().checkVersionOfEmployeeLeave(employeeLeaveVersion);
		

		if(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY.equals(property)){
			userContext.getChecker().checkLeaveDurationHourOfEmployeeLeave(parseInt(newValueExpr));
		}
		
		if(EmployeeLeave.REMARK_PROPERTY.equals(property)){
			userContext.getChecker().checkRemarkOfEmployeeLeave(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(LeaveTypeManagerException.class);
	
	}
	
	public  LeaveType updateEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeLeave(userContext, leaveTypeId, employeeLeaveId, employeeLeaveVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeLeaveList().searchEmployeeLeaveListWith(EmployeeLeave.ID_PROPERTY, "eq", employeeLeaveId).done();
		
		
		
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, loadTokens);
		
		synchronized(leaveType){ 
			//Will be good when the leaveType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//leaveType.removeEmployeeLeave( employeeLeave );	
			//make changes to AcceleraterAccount.
			EmployeeLeave employeeLeaveIndex = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
		
			EmployeeLeave employeeLeave = leaveType.findTheEmployeeLeave(employeeLeaveIndex);
			if(employeeLeave == null){
				throw new LeaveTypeManagerException(employeeLeave+" is NOT FOUND" );
			}
			
			employeeLeave.changeProperty(property, newValueExpr);
			
			leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
			return present(userContext,leaveType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, LeaveType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


