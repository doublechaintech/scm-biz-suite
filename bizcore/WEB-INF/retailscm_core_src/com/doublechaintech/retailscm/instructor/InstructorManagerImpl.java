
package com.doublechaintech.retailscm.instructor;

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
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;






public class InstructorManagerImpl extends CustomRetailscmCheckerManager implements InstructorManager {
	
	private static final String SERVICE_TYPE = "Instructor";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws InstructorManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new InstructorManagerException(message);

	}
	
	

 	protected Instructor saveInstructor(RetailscmUserContext userContext, Instructor instructor, String [] tokensExpr) throws Exception{	
 		//return getInstructorDAO().save(instructor, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveInstructor(userContext, instructor, tokens);
 	}
 	
 	protected Instructor saveInstructorDetail(RetailscmUserContext userContext, Instructor instructor) throws Exception{	

 		
 		return saveInstructor(userContext, instructor, allTokens());
 	}
 	
 	public Instructor loadInstructor(RetailscmUserContext userContext, String instructorId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfInstructor(instructorId);
		userContext.getChecker().throwExceptionIfHasErrors( InstructorManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Instructor instructor = loadInstructor( userContext, instructorId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,instructor, tokens);
 	}
 	
 	
 	 public Instructor searchInstructor(RetailscmUserContext userContext, String instructorId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfInstructor(instructorId);
		userContext.getChecker().throwExceptionIfHasErrors( InstructorManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Instructor instructor = loadInstructor( userContext, instructorId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,instructor, tokens);
 	}
 	
 	

 	protected Instructor present(RetailscmUserContext userContext, Instructor instructor, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,instructor,tokens);
		
		
		Instructor  instructorToPresent = userContext.getDAOGroup().getInstructorDAO().present(instructor, tokens);
		
		List<BaseEntity> entityListToNaming = instructorToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getInstructorDAO().alias(entityListToNaming);
		
		return  instructorToPresent;
		
		
	}
 
 	
 	
 	public Instructor loadInstructorDetail(RetailscmUserContext userContext, String instructorId) throws Exception{	
 		Instructor instructor = loadInstructor( userContext, instructorId, allTokens());
 		return present(userContext,instructor, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String instructorId) throws Exception{	
 		Instructor instructor = loadInstructor( userContext, instructorId, viewTokens());
 		return present(userContext,instructor, allTokens());
		
 	}
 	protected Instructor saveInstructor(RetailscmUserContext userContext, Instructor instructor, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getInstructorDAO().save(instructor, tokens);
 	}
 	protected Instructor loadInstructor(RetailscmUserContext userContext, String instructorId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfInstructor(instructorId);
		userContext.getChecker().throwExceptionIfHasErrors( InstructorManagerException.class);

 
 		return userContext.getDAOGroup().getInstructorDAO().load(instructorId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Instructor instructor, Map<String, Object> tokens){
		super.addActions(userContext, instructor, tokens);
		
		addAction(userContext, instructor, tokens,"@create","createInstructor","createInstructor/","main","primary");
		addAction(userContext, instructor, tokens,"@update","updateInstructor","updateInstructor/"+instructor.getId()+"/","main","primary");
		addAction(userContext, instructor, tokens,"@copy","cloneInstructor","cloneInstructor/"+instructor.getId()+"/","main","primary");
		
		addAction(userContext, instructor, tokens,"instructor.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+instructor.getId()+"/","main","primary");
		addAction(userContext, instructor, tokens,"instructor.addCompanyTraining","addCompanyTraining","addCompanyTraining/"+instructor.getId()+"/","companyTrainingList","primary");
		addAction(userContext, instructor, tokens,"instructor.removeCompanyTraining","removeCompanyTraining","removeCompanyTraining/"+instructor.getId()+"/","companyTrainingList","primary");
		addAction(userContext, instructor, tokens,"instructor.updateCompanyTraining","updateCompanyTraining","updateCompanyTraining/"+instructor.getId()+"/","companyTrainingList","primary");
		addAction(userContext, instructor, tokens,"instructor.copyCompanyTrainingFrom","copyCompanyTrainingFrom","copyCompanyTrainingFrom/"+instructor.getId()+"/","companyTrainingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Instructor instructor, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Instructor createInstructor(RetailscmUserContext userContext,String title, String familyName, String givenName, String cellPhone, String email, String companyId, String introduction) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfInstructor(title);
		userContext.getChecker().checkFamilyNameOfInstructor(familyName);
		userContext.getChecker().checkGivenNameOfInstructor(givenName);
		userContext.getChecker().checkCellPhoneOfInstructor(cellPhone);
		userContext.getChecker().checkEmailOfInstructor(email);
		userContext.getChecker().checkIntroductionOfInstructor(introduction);
	
		userContext.getChecker().throwExceptionIfHasErrors(InstructorManagerException.class);


		Instructor instructor=createNewInstructor();	

		instructor.setTitle(title);
		instructor.setFamilyName(familyName);
		instructor.setGivenName(givenName);
		instructor.setCellPhone(cellPhone);
		instructor.setEmail(email);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		instructor.setCompany(company);
		
		
		instructor.setIntroduction(introduction);
		instructor.setLastUpdateTime(userContext.now());

		instructor = saveInstructor(userContext, instructor, emptyOptions());
		
		onNewInstanceCreated(userContext, instructor);
		return instructor;

		
	}
	protected Instructor createNewInstructor() 
	{
		
		return new Instructor();		
	}
	
	protected void checkParamsForUpdatingInstructor(RetailscmUserContext userContext,String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfInstructor(instructorId);
		userContext.getChecker().checkVersionOfInstructor( instructorVersion);
		

		if(Instructor.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfInstructor(parseString(newValueExpr));
		}
		if(Instructor.FAMILY_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkFamilyNameOfInstructor(parseString(newValueExpr));
		}
		if(Instructor.GIVEN_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkGivenNameOfInstructor(parseString(newValueExpr));
		}
		if(Instructor.CELL_PHONE_PROPERTY.equals(property)){
			userContext.getChecker().checkCellPhoneOfInstructor(parseString(newValueExpr));
		}
		if(Instructor.EMAIL_PROPERTY.equals(property)){
			userContext.getChecker().checkEmailOfInstructor(parseString(newValueExpr));
		}		

		
		if(Instructor.INTRODUCTION_PROPERTY.equals(property)){
			userContext.getChecker().checkIntroductionOfInstructor(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(InstructorManagerException.class);
	
		
	}
	
	
	
	public Instructor clone(RetailscmUserContext userContext, String fromInstructorId) throws Exception{
		
		return userContext.getDAOGroup().getInstructorDAO().clone(fromInstructorId, this.allTokens());
	}
	
	public Instructor internalSaveInstructor(RetailscmUserContext userContext, Instructor instructor) throws Exception 
	{
		return internalSaveInstructor(userContext, instructor, allTokens());

	}
	public Instructor internalSaveInstructor(RetailscmUserContext userContext, Instructor instructor, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingInstructor(userContext, instructorId, instructorVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(instructor){ 
			//will be good when the instructor loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Instructor.
			
			
			instructor = saveInstructor(userContext, instructor, options);
			return instructor;
			
		}

	}
	
	public Instructor updateInstructor(RetailscmUserContext userContext,String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingInstructor(userContext, instructorId, instructorVersion, property, newValueExpr, tokensExpr);
		
		
		
		Instructor instructor = loadInstructor(userContext, instructorId, allTokens());
		if(instructor.getVersion() != instructorVersion){
			String message = "The target version("+instructor.getVersion()+") is not equals to version("+instructorVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(instructor){ 
			//will be good when the instructor loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Instructor.
			instructor.updateLastUpdateTime(userContext.now());
			instructor.changeProperty(property, newValueExpr);
			instructor = saveInstructor(userContext, instructor, tokens().done());
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
			//return saveInstructor(userContext, instructor, tokens().done());
		}

	}
	
	public Instructor updateInstructorProperty(RetailscmUserContext userContext,String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingInstructor(userContext, instructorId, instructorVersion, property, newValueExpr, tokensExpr);
		
		Instructor instructor = loadInstructor(userContext, instructorId, allTokens());
		if(instructor.getVersion() != instructorVersion){
			String message = "The target version("+instructor.getVersion()+") is not equals to version("+instructorVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(instructor){ 
			//will be good when the instructor loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Instructor.
			
			instructor.changeProperty(property, newValueExpr);
			instructor.updateLastUpdateTime(userContext.now());
			instructor = saveInstructor(userContext, instructor, tokens().done());
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
			//return saveInstructor(userContext, instructor, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected InstructorTokens tokens(){
		return InstructorTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return InstructorTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortCompanyTrainingListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return InstructorTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String instructorId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfInstructor(instructorId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(InstructorManagerException.class);
 		
 	}
 	public Instructor transferToAnotherCompany(RetailscmUserContext userContext, String instructorId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, instructorId,anotherCompanyId);
 
		Instructor instructor = loadInstructor(userContext, instructorId, allTokens());	
		synchronized(instructor){
			//will be good when the instructor loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			instructor.updateCompany(company);		
			instructor = saveInstructor(userContext, instructor, emptyOptions());
			
			return present(userContext,instructor, allTokens());
			
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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForInstructor(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String instructorId, int instructorVersion) throws Exception {
		//deleteInternal(userContext, instructorId, instructorVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String instructorId, int instructorVersion) throws Exception{
			
		userContext.getDAOGroup().getInstructorDAO().delete(instructorId, instructorVersion);
	}
	
	public Instructor forgetByAll(RetailscmUserContext userContext, String instructorId, int instructorVersion) throws Exception {
		return forgetByAllInternal(userContext, instructorId, instructorVersion);		
	}
	protected Instructor forgetByAllInternal(RetailscmUserContext userContext,
			String instructorId, int instructorVersion) throws Exception{
			
		return userContext.getDAOGroup().getInstructorDAO().disconnectFromAll(instructorId, instructorVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new InstructorManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getInstructorDAO().deleteAll();
	}


	//disconnect Instructor with company in CompanyTraining
	protected Instructor breakWithCompanyTrainingByCompany(RetailscmUserContext userContext, String instructorId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Instructor instructor = loadInstructor(userContext, instructorId, allTokens());

			synchronized(instructor){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getInstructorDAO().planToRemoveCompanyTrainingListWithCompany(instructor, companyId, this.emptyOptions());

				instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
				return instructor;
			}
	}
	//disconnect Instructor with training_course_type in CompanyTraining
	protected Instructor breakWithCompanyTrainingByTrainingCourseType(RetailscmUserContext userContext, String instructorId, String trainingCourseTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Instructor instructor = loadInstructor(userContext, instructorId, allTokens());

			synchronized(instructor){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getInstructorDAO().planToRemoveCompanyTrainingListWithTrainingCourseType(instructor, trainingCourseTypeId, this.emptyOptions());

				instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
				return instructor;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingCompanyTraining(RetailscmUserContext userContext, String instructorId, String title, String companyId, String trainingCourseTypeId, Date timeStart, int durationHours,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfInstructor(instructorId);

		
		userContext.getChecker().checkTitleOfCompanyTraining(title);
		
		userContext.getChecker().checkCompanyIdOfCompanyTraining(companyId);
		
		userContext.getChecker().checkTrainingCourseTypeIdOfCompanyTraining(trainingCourseTypeId);
		
		userContext.getChecker().checkTimeStartOfCompanyTraining(timeStart);
		
		userContext.getChecker().checkDurationHoursOfCompanyTraining(durationHours);
	
		userContext.getChecker().throwExceptionIfHasErrors(InstructorManagerException.class);

	
	}
	public  Instructor addCompanyTraining(RetailscmUserContext userContext, String instructorId, String title, String companyId, String trainingCourseTypeId, Date timeStart, int durationHours, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCompanyTraining(userContext,instructorId,title, companyId, trainingCourseTypeId, timeStart, durationHours,tokensExpr);
		
		CompanyTraining companyTraining = createCompanyTraining(userContext,title, companyId, trainingCourseTypeId, timeStart, durationHours);
		
		Instructor instructor = loadInstructor(userContext, instructorId, allTokens());
		synchronized(instructor){ 
			//Will be good when the instructor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			instructor.addCompanyTraining( companyTraining );		
			instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
			
			userContext.getManagerGroup().getCompanyTrainingManager().onNewInstanceCreated(userContext, companyTraining);
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCompanyTrainingProperties(RetailscmUserContext userContext, String instructorId,String id,String title,Date timeStart,int durationHours,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfInstructor(instructorId);
		userContext.getChecker().checkIdOfCompanyTraining(id);
		
		userContext.getChecker().checkTitleOfCompanyTraining( title);
		userContext.getChecker().checkTimeStartOfCompanyTraining( timeStart);
		userContext.getChecker().checkDurationHoursOfCompanyTraining( durationHours);

		userContext.getChecker().throwExceptionIfHasErrors(InstructorManagerException.class);
		
	}
	public  Instructor updateCompanyTrainingProperties(RetailscmUserContext userContext, String instructorId, String id,String title,Date timeStart,int durationHours, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingCompanyTrainingProperties(userContext,instructorId,id,title,timeStart,durationHours,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCompanyTrainingListList()
				.searchCompanyTrainingListWith(CompanyTraining.ID_PROPERTY, "is", id).done();
		
		Instructor instructorToUpdate = loadInstructor(userContext, instructorId, options);
		
		if(instructorToUpdate.getCompanyTrainingList().isEmpty()){
			throw new InstructorManagerException("CompanyTraining is NOT FOUND with id: '"+id+"'");
		}
		
		CompanyTraining item = instructorToUpdate.getCompanyTrainingList().first();
		
		item.updateTitle( title );
		item.updateTimeStart( timeStart );
		item.updateDurationHours( durationHours );

		
		//checkParamsForAddingCompanyTraining(userContext,instructorId,name, code, used,tokensExpr);
		Instructor instructor = saveInstructor(userContext, instructorToUpdate, tokens().withCompanyTrainingList().done());
		synchronized(instructor){ 
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected CompanyTraining createCompanyTraining(RetailscmUserContext userContext, String title, String companyId, String trainingCourseTypeId, Date timeStart, int durationHours) throws Exception{

		CompanyTraining companyTraining = new CompanyTraining();
		
		
		companyTraining.setTitle(title);		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		companyTraining.setCompany(company);		
		TrainingCourseType  trainingCourseType = new TrainingCourseType();
		trainingCourseType.setId(trainingCourseTypeId);		
		companyTraining.setTrainingCourseType(trainingCourseType);		
		companyTraining.setTimeStart(timeStart);		
		companyTraining.setDurationHours(durationHours);		
		companyTraining.setLastUpdateTime(userContext.now());
	
		
		return companyTraining;
	
		
	}
	
	protected CompanyTraining createIndexedCompanyTraining(String id, int version){

		CompanyTraining companyTraining = new CompanyTraining();
		companyTraining.setId(id);
		companyTraining.setVersion(version);
		return companyTraining;			
		
	}
	
	protected void checkParamsForRemovingCompanyTrainingList(RetailscmUserContext userContext, String instructorId, 
			String companyTrainingIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfInstructor(instructorId);
		for(String companyTrainingId: companyTrainingIds){
			userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(InstructorManagerException.class);
		
	}
	public  Instructor removeCompanyTrainingList(RetailscmUserContext userContext, String instructorId, 
			String companyTrainingIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingCompanyTrainingList(userContext, instructorId,  companyTrainingIds, tokensExpr);
			
			
			Instructor instructor = loadInstructor(userContext, instructorId, allTokens());
			synchronized(instructor){ 
				//Will be good when the instructor loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getInstructorDAO().planToRemoveCompanyTrainingList(instructor, companyTrainingIds, allTokens());
				instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
				deleteRelationListInGraph(userContext, instructor.getCompanyTrainingList());
				return present(userContext,instructor, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingCompanyTraining(RetailscmUserContext userContext, String instructorId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfInstructor( instructorId);
		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		userContext.getChecker().checkVersionOfCompanyTraining(companyTrainingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(InstructorManagerException.class);
	
	}
	public  Instructor removeCompanyTraining(RetailscmUserContext userContext, String instructorId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCompanyTraining(userContext,instructorId, companyTrainingId, companyTrainingVersion,tokensExpr);
		
		CompanyTraining companyTraining = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		Instructor instructor = loadInstructor(userContext, instructorId, allTokens());
		synchronized(instructor){ 
			//Will be good when the instructor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			instructor.removeCompanyTraining( companyTraining );		
			instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
			deleteRelationInGraph(userContext, companyTraining);
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingCompanyTraining(RetailscmUserContext userContext, String instructorId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfInstructor( instructorId);
		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		userContext.getChecker().checkVersionOfCompanyTraining(companyTrainingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(InstructorManagerException.class);
	
	}
	public  Instructor copyCompanyTrainingFrom(RetailscmUserContext userContext, String instructorId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCompanyTraining(userContext,instructorId, companyTrainingId, companyTrainingVersion,tokensExpr);
		
		CompanyTraining companyTraining = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		Instructor instructor = loadInstructor(userContext, instructorId, allTokens());
		synchronized(instructor){ 
			//Will be good when the instructor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			companyTraining.updateLastUpdateTime(userContext.now());
			
			instructor.copyCompanyTrainingFrom( companyTraining );		
			instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
			
			userContext.getManagerGroup().getCompanyTrainingManager().onNewInstanceCreated(userContext, (CompanyTraining)instructor.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingCompanyTraining(RetailscmUserContext userContext, String instructorId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfInstructor(instructorId);
		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		userContext.getChecker().checkVersionOfCompanyTraining(companyTrainingVersion);
		

		if(CompanyTraining.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfCompanyTraining(parseString(newValueExpr));
		}
		
		if(CompanyTraining.TIME_START_PROPERTY.equals(property)){
			userContext.getChecker().checkTimeStartOfCompanyTraining(parseDate(newValueExpr));
		}
		
		if(CompanyTraining.DURATION_HOURS_PROPERTY.equals(property)){
			userContext.getChecker().checkDurationHoursOfCompanyTraining(parseInt(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(InstructorManagerException.class);
	
	}
	
	public  Instructor updateCompanyTraining(RetailscmUserContext userContext, String instructorId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCompanyTraining(userContext, instructorId, companyTrainingId, companyTrainingVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withCompanyTrainingList().searchCompanyTrainingListWith(CompanyTraining.ID_PROPERTY, "eq", companyTrainingId).done();
		
		
		
		Instructor instructor = loadInstructor(userContext, instructorId, loadTokens);
		
		synchronized(instructor){ 
			//Will be good when the instructor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//instructor.removeCompanyTraining( companyTraining );	
			//make changes to AcceleraterAccount.
			CompanyTraining companyTrainingIndex = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		
			CompanyTraining companyTraining = instructor.findTheCompanyTraining(companyTrainingIndex);
			if(companyTraining == null){
				throw new InstructorManagerException(companyTraining+" is NOT FOUND" );
			}
			
			companyTraining.changeProperty(property, newValueExpr);
			companyTraining.updateLastUpdateTime(userContext.now());
			instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, Instructor newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


