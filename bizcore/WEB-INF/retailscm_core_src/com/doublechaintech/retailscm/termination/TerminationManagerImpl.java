
package com.doublechaintech.retailscm.termination;

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

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;

import com.doublechaintech.retailscm.terminationtype.CandidateTerminationType;
import com.doublechaintech.retailscm.terminationreason.CandidateTerminationReason;

import com.doublechaintech.retailscm.hrinterview.HrInterview;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.jobapplication.JobApplication;
import com.doublechaintech.retailscm.professioninterview.ProfessionInterview;
import com.doublechaintech.retailscm.offeracceptance.OfferAcceptance;
import com.doublechaintech.retailscm.employeeboarding.EmployeeBoarding;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.offerapproval.OfferApproval;






public class TerminationManagerImpl extends CustomRetailscmCheckerManager implements TerminationManager {
	
	private static final String SERVICE_TYPE = "Termination";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TerminationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TerminationManagerException(message);

	}
	
	

 	protected Termination saveTermination(RetailscmUserContext userContext, Termination termination, String [] tokensExpr) throws Exception{	
 		//return getTerminationDAO().save(termination, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTermination(userContext, termination, tokens);
 	}
 	
 	protected Termination saveTerminationDetail(RetailscmUserContext userContext, Termination termination) throws Exception{	

 		
 		return saveTermination(userContext, termination, allTokens());
 	}
 	
 	public Termination loadTermination(RetailscmUserContext userContext, String terminationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTermination(terminationId);
		userContext.getChecker().throwExceptionIfHasErrors( TerminationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Termination termination = loadTermination( userContext, terminationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,termination, tokens);
 	}
 	
 	
 	 public Termination searchTermination(RetailscmUserContext userContext, String terminationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTermination(terminationId);
		userContext.getChecker().throwExceptionIfHasErrors( TerminationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Termination termination = loadTermination( userContext, terminationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,termination, tokens);
 	}
 	
 	

 	protected Termination present(RetailscmUserContext userContext, Termination termination, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,termination,tokens);
		
		
		Termination  terminationToPresent = userContext.getDAOGroup().getTerminationDAO().present(termination, tokens);
		
		List<BaseEntity> entityListToNaming = terminationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTerminationDAO().alias(entityListToNaming);
		
		return  terminationToPresent;
		
		
	}
 
 	
 	
 	public Termination loadTerminationDetail(RetailscmUserContext userContext, String terminationId) throws Exception{	
 		Termination termination = loadTermination( userContext, terminationId, allTokens());
 		return present(userContext,termination, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String terminationId) throws Exception{	
 		Termination termination = loadTermination( userContext, terminationId, viewTokens());
 		return present(userContext,termination, allTokens());
		
 	}
 	protected Termination saveTermination(RetailscmUserContext userContext, Termination termination, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTerminationDAO().save(termination, tokens);
 	}
 	protected Termination loadTermination(RetailscmUserContext userContext, String terminationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTermination(terminationId);
		userContext.getChecker().throwExceptionIfHasErrors( TerminationManagerException.class);

 
 		return userContext.getDAOGroup().getTerminationDAO().load(terminationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Termination termination, Map<String, Object> tokens){
		super.addActions(userContext, termination, tokens);
		
		addAction(userContext, termination, tokens,"@create","createTermination","createTermination/","main","primary");
		addAction(userContext, termination, tokens,"@update","updateTermination","updateTermination/"+termination.getId()+"/","main","primary");
		addAction(userContext, termination, tokens,"@copy","cloneTermination","cloneTermination/"+termination.getId()+"/","main","primary");
		
		addAction(userContext, termination, tokens,"termination.transfer_to_reason","transferToAnotherReason","transferToAnotherReason/"+termination.getId()+"/","main","primary");
		addAction(userContext, termination, tokens,"termination.transfer_to_type","transferToAnotherType","transferToAnotherType/"+termination.getId()+"/","main","primary");
		addAction(userContext, termination, tokens,"termination.addEmployee","addEmployee","addEmployee/"+termination.getId()+"/","employeeList","primary");
		addAction(userContext, termination, tokens,"termination.removeEmployee","removeEmployee","removeEmployee/"+termination.getId()+"/","employeeList","primary");
		addAction(userContext, termination, tokens,"termination.updateEmployee","updateEmployee","updateEmployee/"+termination.getId()+"/","employeeList","primary");
		addAction(userContext, termination, tokens,"termination.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+termination.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Termination termination, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Termination createTermination(RetailscmUserContext userContext,String reasonId, String typeId, String comment) throws Exception
	{
		
		

		

		userContext.getChecker().checkCommentOfTermination(comment);
	
		userContext.getChecker().throwExceptionIfHasErrors(TerminationManagerException.class);


		Termination termination=createNewTermination();	

			
		TerminationReason reason = loadTerminationReason(userContext, reasonId,emptyOptions());
		termination.setReason(reason);
		
		
			
		TerminationType type = loadTerminationType(userContext, typeId,emptyOptions());
		termination.setType(type);
		
		
		termination.setComment(comment);

		termination = saveTermination(userContext, termination, emptyOptions());
		
		onNewInstanceCreated(userContext, termination);
		return termination;

		
	}
	protected Termination createNewTermination() 
	{
		
		return new Termination();		
	}
	
	protected void checkParamsForUpdatingTermination(RetailscmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTermination(terminationId);
		userContext.getChecker().checkVersionOfTermination( terminationVersion);
		
		

				

		
		if(Termination.COMMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentOfTermination(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(TerminationManagerException.class);
	
		
	}
	
	
	
	public Termination clone(RetailscmUserContext userContext, String fromTerminationId) throws Exception{
		
		return userContext.getDAOGroup().getTerminationDAO().clone(fromTerminationId, this.allTokens());
	}
	
	public Termination internalSaveTermination(RetailscmUserContext userContext, Termination termination) throws Exception 
	{
		return internalSaveTermination(userContext, termination, allTokens());

	}
	public Termination internalSaveTermination(RetailscmUserContext userContext, Termination termination, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTermination(userContext, terminationId, terminationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(termination){ 
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Termination.
			
			
			termination = saveTermination(userContext, termination, options);
			return termination;
			
		}

	}
	
	public Termination updateTermination(RetailscmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTermination(userContext, terminationId, terminationVersion, property, newValueExpr, tokensExpr);
		
		
		
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		if(termination.getVersion() != terminationVersion){
			String message = "The target version("+termination.getVersion()+") is not equals to version("+terminationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(termination){ 
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Termination.
			
			termination.changeProperty(property, newValueExpr);
			termination = saveTermination(userContext, termination, tokens().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
			//return saveTermination(userContext, termination, tokens().done());
		}

	}
	
	public Termination updateTerminationProperty(RetailscmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTermination(userContext, terminationId, terminationVersion, property, newValueExpr, tokensExpr);
		
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		if(termination.getVersion() != terminationVersion){
			String message = "The target version("+termination.getVersion()+") is not equals to version("+terminationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(termination){ 
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Termination.
			
			termination.changeProperty(property, newValueExpr);
			
			termination = saveTermination(userContext, termination, tokens().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
			//return saveTermination(userContext, termination, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TerminationTokens tokens(){
		return TerminationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TerminationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TerminationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherReason(RetailscmUserContext userContext, String terminationId, String anotherReasonId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTermination(terminationId);
 		userContext.getChecker().checkIdOfTerminationReason(anotherReasonId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TerminationManagerException.class);
 		
 	}
 	public Termination transferToAnotherReason(RetailscmUserContext userContext, String terminationId, String anotherReasonId) throws Exception
 	{
 		checkParamsForTransferingAnotherReason(userContext, terminationId,anotherReasonId);
 
		Termination termination = loadTermination(userContext, terminationId, allTokens());	
		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TerminationReason reason = loadTerminationReason(userContext, anotherReasonId, emptyOptions());		
			termination.updateReason(reason);		
			termination = saveTermination(userContext, termination, emptyOptions());
			
			return present(userContext,termination, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateTerminationReason requestCandidateReason(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTerminationReason result = new CandidateTerminationReason();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TerminationReason> candidateList = userContext.getDAOGroup().getTerminationReasonDAO().requestCandidateTerminationReasonForTermination(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherType(RetailscmUserContext userContext, String terminationId, String anotherTypeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTermination(terminationId);
 		userContext.getChecker().checkIdOfTerminationType(anotherTypeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TerminationManagerException.class);
 		
 	}
 	public Termination transferToAnotherType(RetailscmUserContext userContext, String terminationId, String anotherTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherType(userContext, terminationId,anotherTypeId);
 
		Termination termination = loadTermination(userContext, terminationId, allTokens());	
		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TerminationType type = loadTerminationType(userContext, anotherTypeId, emptyOptions());		
			termination.updateType(type);		
			termination = saveTermination(userContext, termination, emptyOptions());
			
			return present(userContext,termination, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateTerminationType requestCandidateType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTerminationType result = new CandidateTerminationType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TerminationType> candidateList = userContext.getDAOGroup().getTerminationTypeDAO().requestCandidateTerminationTypeForTermination(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected TerminationType loadTerminationType(RetailscmUserContext userContext, String newTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTerminationTypeDAO().load(newTypeId, options);
 	}
 	
 	
 	
	
	 	
 	protected TerminationReason loadTerminationReason(RetailscmUserContext userContext, String newReasonId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTerminationReasonDAO().load(newReasonId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String terminationId, int terminationVersion) throws Exception {
		//deleteInternal(userContext, terminationId, terminationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String terminationId, int terminationVersion) throws Exception{
			
		userContext.getDAOGroup().getTerminationDAO().delete(terminationId, terminationVersion);
	}
	
	public Termination forgetByAll(RetailscmUserContext userContext, String terminationId, int terminationVersion) throws Exception {
		return forgetByAllInternal(userContext, terminationId, terminationVersion);		
	}
	protected Termination forgetByAllInternal(RetailscmUserContext userContext,
			String terminationId, int terminationVersion) throws Exception{
			
		return userContext.getDAOGroup().getTerminationDAO().disconnectFromAll(terminationId, terminationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TerminationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTerminationDAO().deleteAll();
	}


	//disconnect Termination with company in Employee
	protected Termination breakWithEmployeeByCompany(RetailscmUserContext userContext, String terminationId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTerminationDAO().planToRemoveEmployeeListWithCompany(termination, companyId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with department in Employee
	protected Termination breakWithEmployeeByDepartment(RetailscmUserContext userContext, String terminationId, String departmentId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTerminationDAO().planToRemoveEmployeeListWithDepartment(termination, departmentId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with occupation in Employee
	protected Termination breakWithEmployeeByOccupation(RetailscmUserContext userContext, String terminationId, String occupationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTerminationDAO().planToRemoveEmployeeListWithOccupation(termination, occupationId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with responsible_for in Employee
	protected Termination breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String terminationId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTerminationDAO().planToRemoveEmployeeListWithResponsibleFor(termination, responsibleForId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	//disconnect Termination with current_salary_grade in Employee
	protected Termination breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String terminationId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Termination termination = loadTermination(userContext, terminationId, allTokens());

			synchronized(termination){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTerminationDAO().planToRemoveEmployeeListWithCurrentSalaryGrade(termination, currentSalaryGradeId, this.emptyOptions());

				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				return termination;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String terminationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTermination(terminationId);

		
		userContext.getChecker().checkCompanyIdOfEmployee(companyId);
		
		userContext.getChecker().checkTitleOfEmployee(title);
		
		userContext.getChecker().checkDepartmentIdOfEmployee(departmentId);
		
		userContext.getChecker().checkFamilyNameOfEmployee(familyName);
		
		userContext.getChecker().checkGivenNameOfEmployee(givenName);
		
		userContext.getChecker().checkEmailOfEmployee(email);
		
		userContext.getChecker().checkCityOfEmployee(city);
		
		userContext.getChecker().checkAddressOfEmployee(address);
		
		userContext.getChecker().checkCellPhoneOfEmployee(cellPhone);
		
		userContext.getChecker().checkOccupationIdOfEmployee(occupationId);
		
		userContext.getChecker().checkResponsibleForIdOfEmployee(responsibleForId);
		
		userContext.getChecker().checkCurrentSalaryGradeIdOfEmployee(currentSalaryGradeId);
		
		userContext.getChecker().checkSalaryAccountOfEmployee(salaryAccount);
	
		userContext.getChecker().throwExceptionIfHasErrors(TerminationManagerException.class);

	
	}
	public  Termination addEmployee(RetailscmUserContext userContext, String terminationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,terminationId,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,companyId, title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		synchronized(termination){ 
			//Will be good when the termination loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			termination.addEmployee( employee );		
			termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String terminationId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTermination(terminationId);
		userContext.getChecker().checkIdOfEmployee(id);
		
		userContext.getChecker().checkTitleOfEmployee( title);
		userContext.getChecker().checkFamilyNameOfEmployee( familyName);
		userContext.getChecker().checkGivenNameOfEmployee( givenName);
		userContext.getChecker().checkEmailOfEmployee( email);
		userContext.getChecker().checkCityOfEmployee( city);
		userContext.getChecker().checkAddressOfEmployee( address);
		userContext.getChecker().checkCellPhoneOfEmployee( cellPhone);
		userContext.getChecker().checkSalaryAccountOfEmployee( salaryAccount);

		userContext.getChecker().throwExceptionIfHasErrors(TerminationManagerException.class);
		
	}
	public  Termination updateEmployeeProperties(RetailscmUserContext userContext, String terminationId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeProperties(userContext,terminationId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();
		
		Termination terminationToUpdate = loadTermination(userContext, terminationId, options);
		
		if(terminationToUpdate.getEmployeeList().isEmpty()){
			throw new TerminationManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}
		
		Employee item = terminationToUpdate.getEmployeeList().first();
		
		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );

		
		//checkParamsForAddingEmployee(userContext,terminationId,name, code, used,tokensExpr);
		Termination termination = saveTermination(userContext, terminationToUpdate, tokens().withEmployeeList().done());
		synchronized(termination){ 
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Employee createEmployee(RetailscmUserContext userContext, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount) throws Exception{

		Employee employee = new Employee();
		
		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		employee.setCompany(company);		
		employee.setTitle(title);		
		LevelThreeDepartment  department = new LevelThreeDepartment();
		department.setId(departmentId);		
		employee.setDepartment(department);		
		employee.setFamilyName(familyName);		
		employee.setGivenName(givenName);		
		employee.setEmail(email);		
		employee.setCity(city);		
		employee.setAddress(address);		
		employee.setCellPhone(cellPhone);		
		OccupationType  occupation = new OccupationType();
		occupation.setId(occupationId);		
		employee.setOccupation(occupation);		
		ResponsibilityType  responsibleFor = new ResponsibilityType();
		responsibleFor.setId(responsibleForId);		
		employee.setResponsibleFor(responsibleFor);		
		SalaryGrade  currentSalaryGrade = new SalaryGrade();
		currentSalaryGrade.setId(currentSalaryGradeId);		
		employee.setCurrentSalaryGrade(currentSalaryGrade);		
		employee.setSalaryAccount(salaryAccount);		
		employee.setLastUpdateTime(userContext.now());		
		employee.setCurrentStatus("INIT");
	
		
		return employee;
	
		
	}
	
	protected Employee createIndexedEmployee(String id, int version){

		Employee employee = new Employee();
		employee.setId(id);
		employee.setVersion(version);
		return employee;			
		
	}
	
	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String terminationId, 
			String employeeIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTermination(terminationId);
		for(String employeeId: employeeIds){
			userContext.getChecker().checkIdOfEmployee(employeeId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TerminationManagerException.class);
		
	}
	public  Termination removeEmployeeList(RetailscmUserContext userContext, String terminationId, 
			String employeeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeList(userContext, terminationId,  employeeIds, tokensExpr);
			
			
			Termination termination = loadTermination(userContext, terminationId, allTokens());
			synchronized(termination){ 
				//Will be good when the termination loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTerminationDAO().planToRemoveEmployeeList(termination, employeeIds, allTokens());
				termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, termination.getEmployeeList());
				return present(userContext,termination, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String terminationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTermination( terminationId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TerminationManagerException.class);
	
	}
	public  Termination removeEmployee(RetailscmUserContext userContext, String terminationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,terminationId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		synchronized(termination){ 
			//Will be good when the termination loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			termination.removeEmployee( employee );		
			termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String terminationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTermination( terminationId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TerminationManagerException.class);
	
	}
	public  Termination copyEmployeeFrom(RetailscmUserContext userContext, String terminationId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,terminationId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		synchronized(termination){ 
			//Will be good when the termination loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			employee.updateLastUpdateTime(userContext.now());
			
			termination.copyEmployeeFrom( employee );		
			termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)termination.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String terminationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTermination(terminationId);
		userContext.getChecker().checkIdOfEmployee(employeeId);
		userContext.getChecker().checkVersionOfEmployee(employeeVersion);
		

		if(Employee.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.FAMILY_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkFamilyNameOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.GIVEN_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkGivenNameOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.EMAIL_PROPERTY.equals(property)){
			userContext.getChecker().checkEmailOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.CITY_PROPERTY.equals(property)){
			userContext.getChecker().checkCityOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.ADDRESS_PROPERTY.equals(property)){
			userContext.getChecker().checkAddressOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.CELL_PHONE_PROPERTY.equals(property)){
			userContext.getChecker().checkCellPhoneOfEmployee(parseString(newValueExpr));
		}
		
		if(Employee.SALARY_ACCOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkSalaryAccountOfEmployee(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TerminationManagerException.class);
	
	}
	
	public  Termination updateEmployee(RetailscmUserContext userContext, String terminationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, terminationId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();
		
		
		
		Termination termination = loadTermination(userContext, terminationId, loadTokens);
		
		synchronized(termination){ 
			//Will be good when the termination loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//termination.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = termination.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new TerminationManagerException(employee+" is NOT FOUND" );
			}
			
			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			termination = saveTermination(userContext, termination, tokens().withEmployeeList().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  Termination associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String terminationId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		Termination termination = loadTermination(userContext, terminationId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().createJobApplication(userContext,  applicationTime,  who,  comments);
		
		for(Employee employee: termination.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveTermination(userContext, termination);
	}	public  Termination associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String terminationId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		Termination termination = loadTermination(userContext, terminationId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().createProfessionInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: termination.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveTermination(userContext, termination);
	}	public  Termination associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String terminationId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		Termination termination = loadTermination(userContext, terminationId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().createHrInterview(userContext,  who,  interviewTime,  comments);
		
		for(Employee employee: termination.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveTermination(userContext, termination);
	}	public  Termination associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String terminationId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		Termination termination = loadTermination(userContext, terminationId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().createOfferApproval(userContext,  who,  approveTime,  comments);
		
		for(Employee employee: termination.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveTermination(userContext, termination);
	}	public  Termination associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String terminationId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		Termination termination = loadTermination(userContext, terminationId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().createOfferAcceptance(userContext,  who,  acceptTime,  comments);
		
		for(Employee employee: termination.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveTermination(userContext, termination);
	}	public  Termination associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String terminationId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		Termination termination = loadTermination(userContext, terminationId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().createEmployeeBoarding(userContext,  who,  employTime,  comments);
		
		for(Employee employee: termination.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveTermination(userContext, termination);
	}
	*/
	
	public  Termination associateEmployeeListToJobApplication(RetailscmUserContext userContext, String terminationId, String  employeeIds[], String jobApplicationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		Termination termination = loadTermination(userContext, terminationId, options);
		
		JobApplication jobApplication = userContext.getManagerGroup().getJobApplicationManager().loadJobApplication(userContext,jobApplicationId,new String[]{"none"} );
		
		for(Employee employee: termination.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateJobApplication(jobApplication);
		}
		return this.internalSaveTermination(userContext, termination);
	}	public  Termination associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String terminationId, String  employeeIds[], String professionInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		Termination termination = loadTermination(userContext, terminationId, options);
		
		ProfessionInterview professionInterview = userContext.getManagerGroup().getProfessionInterviewManager().loadProfessionInterview(userContext,professionInterviewId,new String[]{"none"} );
		
		for(Employee employee: termination.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateProfessionInterview(professionInterview);
		}
		return this.internalSaveTermination(userContext, termination);
	}	public  Termination associateEmployeeListToHrInterview(RetailscmUserContext userContext, String terminationId, String  employeeIds[], String hrInterviewId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		Termination termination = loadTermination(userContext, terminationId, options);
		
		HrInterview hrInterview = userContext.getManagerGroup().getHrInterviewManager().loadHrInterview(userContext,hrInterviewId,new String[]{"none"} );
		
		for(Employee employee: termination.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateHrInterview(hrInterview);
		}
		return this.internalSaveTermination(userContext, termination);
	}	public  Termination associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String terminationId, String  employeeIds[], String offerApprovalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		Termination termination = loadTermination(userContext, terminationId, options);
		
		OfferApproval offerApproval = userContext.getManagerGroup().getOfferApprovalManager().loadOfferApproval(userContext,offerApprovalId,new String[]{"none"} );
		
		for(Employee employee: termination.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferApproval(offerApproval);
		}
		return this.internalSaveTermination(userContext, termination);
	}	public  Termination associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String terminationId, String  employeeIds[], String offerAcceptanceId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		Termination termination = loadTermination(userContext, terminationId, options);
		
		OfferAcceptance offerAcceptance = userContext.getManagerGroup().getOfferAcceptanceManager().loadOfferAcceptance(userContext,offerAcceptanceId,new String[]{"none"} );
		
		for(Employee employee: termination.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateOfferAcceptance(offerAcceptance);
		}
		return this.internalSaveTermination(userContext, termination);
	}	public  Termination associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String terminationId, String  employeeIds[], String employeeBoardingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "oneof", this.joinArray("|", employeeIds)).done();
		
		Termination termination = loadTermination(userContext, terminationId, options);
		
		EmployeeBoarding employeeBoarding = userContext.getManagerGroup().getEmployeeBoardingManager().loadEmployeeBoarding(userContext,employeeBoardingId,new String[]{"none"} );
		
		for(Employee employee: termination.getEmployeeList()) {
			//TODO: need to check if already associated
			employee.updateEmployeeBoarding(employeeBoarding);
		}
		return this.internalSaveTermination(userContext, termination);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, Termination newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


