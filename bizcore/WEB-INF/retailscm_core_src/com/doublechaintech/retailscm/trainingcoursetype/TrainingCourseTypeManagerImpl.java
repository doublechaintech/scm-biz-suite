
package com.doublechaintech.retailscm.trainingcoursetype;

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






public class TrainingCourseTypeManagerImpl extends CustomRetailscmCheckerManager implements TrainingCourseTypeManager {
	
	private static final String SERVICE_TYPE = "TrainingCourseType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TrainingCourseTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TrainingCourseTypeManagerException(message);

	}
	
	

 	protected TrainingCourseType saveTrainingCourseType(RetailscmUserContext userContext, TrainingCourseType trainingCourseType, String [] tokensExpr) throws Exception{	
 		//return getTrainingCourseTypeDAO().save(trainingCourseType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTrainingCourseType(userContext, trainingCourseType, tokens);
 	}
 	
 	protected TrainingCourseType saveTrainingCourseTypeDetail(RetailscmUserContext userContext, TrainingCourseType trainingCourseType) throws Exception{	

 		
 		return saveTrainingCourseType(userContext, trainingCourseType, allTokens());
 	}
 	
 	public TrainingCourseType loadTrainingCourseType(RetailscmUserContext userContext, String trainingCourseTypeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTrainingCourseType(trainingCourseTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( TrainingCourseTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,trainingCourseType, tokens);
 	}
 	
 	
 	 public TrainingCourseType searchTrainingCourseType(RetailscmUserContext userContext, String trainingCourseTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTrainingCourseType(trainingCourseTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( TrainingCourseTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,trainingCourseType, tokens);
 	}
 	
 	

 	protected TrainingCourseType present(RetailscmUserContext userContext, TrainingCourseType trainingCourseType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,trainingCourseType,tokens);
		
		
		TrainingCourseType  trainingCourseTypeToPresent = userContext.getDAOGroup().getTrainingCourseTypeDAO().present(trainingCourseType, tokens);
		
		List<BaseEntity> entityListToNaming = trainingCourseTypeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTrainingCourseTypeDAO().alias(entityListToNaming);
		
		return  trainingCourseTypeToPresent;
		
		
	}
 
 	
 	
 	public TrainingCourseType loadTrainingCourseTypeDetail(RetailscmUserContext userContext, String trainingCourseTypeId) throws Exception{	
 		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, allTokens());
 		return present(userContext,trainingCourseType, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String trainingCourseTypeId) throws Exception{	
 		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, viewTokens());
 		return present(userContext,trainingCourseType, allTokens());
		
 	}
 	protected TrainingCourseType saveTrainingCourseType(RetailscmUserContext userContext, TrainingCourseType trainingCourseType, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTrainingCourseTypeDAO().save(trainingCourseType, tokens);
 	}
 	protected TrainingCourseType loadTrainingCourseType(RetailscmUserContext userContext, String trainingCourseTypeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTrainingCourseType(trainingCourseTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( TrainingCourseTypeManagerException.class);

 
 		return userContext.getDAOGroup().getTrainingCourseTypeDAO().load(trainingCourseTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TrainingCourseType trainingCourseType, Map<String, Object> tokens){
		super.addActions(userContext, trainingCourseType, tokens);
		
		addAction(userContext, trainingCourseType, tokens,"@create","createTrainingCourseType","createTrainingCourseType/","main","primary");
		addAction(userContext, trainingCourseType, tokens,"@update","updateTrainingCourseType","updateTrainingCourseType/"+trainingCourseType.getId()+"/","main","primary");
		addAction(userContext, trainingCourseType, tokens,"@copy","cloneTrainingCourseType","cloneTrainingCourseType/"+trainingCourseType.getId()+"/","main","primary");
		
		addAction(userContext, trainingCourseType, tokens,"training_course_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+trainingCourseType.getId()+"/","main","primary");
		addAction(userContext, trainingCourseType, tokens,"training_course_type.addCompanyTraining","addCompanyTraining","addCompanyTraining/"+trainingCourseType.getId()+"/","companyTrainingList","primary");
		addAction(userContext, trainingCourseType, tokens,"training_course_type.removeCompanyTraining","removeCompanyTraining","removeCompanyTraining/"+trainingCourseType.getId()+"/","companyTrainingList","primary");
		addAction(userContext, trainingCourseType, tokens,"training_course_type.updateCompanyTraining","updateCompanyTraining","updateCompanyTraining/"+trainingCourseType.getId()+"/","companyTrainingList","primary");
		addAction(userContext, trainingCourseType, tokens,"training_course_type.copyCompanyTrainingFrom","copyCompanyTrainingFrom","copyCompanyTrainingFrom/"+trainingCourseType.getId()+"/","companyTrainingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TrainingCourseType trainingCourseType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TrainingCourseType createTrainingCourseType(RetailscmUserContext userContext,String code, String companyId, String name, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkCodeOfTrainingCourseType(code);
		userContext.getChecker().checkNameOfTrainingCourseType(name);
		userContext.getChecker().checkDescriptionOfTrainingCourseType(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);


		TrainingCourseType trainingCourseType=createNewTrainingCourseType();	

		trainingCourseType.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		trainingCourseType.setCompany(company);
		
		
		trainingCourseType.setName(name);
		trainingCourseType.setDescription(description);

		trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, emptyOptions());
		
		onNewInstanceCreated(userContext, trainingCourseType);
		return trainingCourseType;

		
	}
	protected TrainingCourseType createNewTrainingCourseType() 
	{
		
		return new TrainingCourseType();		
	}
	
	protected void checkParamsForUpdatingTrainingCourseType(RetailscmUserContext userContext,String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTrainingCourseType(trainingCourseTypeId);
		userContext.getChecker().checkVersionOfTrainingCourseType( trainingCourseTypeVersion);
		

		if(TrainingCourseType.CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkCodeOfTrainingCourseType(parseString(newValueExpr));
		}		

		
		if(TrainingCourseType.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTrainingCourseType(parseString(newValueExpr));
		}
		if(TrainingCourseType.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfTrainingCourseType(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);
	
		
	}
	
	
	
	public TrainingCourseType clone(RetailscmUserContext userContext, String fromTrainingCourseTypeId) throws Exception{
		
		return userContext.getDAOGroup().getTrainingCourseTypeDAO().clone(fromTrainingCourseTypeId, this.allTokens());
	}
	
	public TrainingCourseType internalSaveTrainingCourseType(RetailscmUserContext userContext, TrainingCourseType trainingCourseType) throws Exception 
	{
		return internalSaveTrainingCourseType(userContext, trainingCourseType, allTokens());

	}
	public TrainingCourseType internalSaveTrainingCourseType(RetailscmUserContext userContext, TrainingCourseType trainingCourseType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTrainingCourseType(userContext, trainingCourseTypeId, trainingCourseTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(trainingCourseType){ 
			//will be good when the trainingCourseType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TrainingCourseType.
			
			
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, options);
			return trainingCourseType;
			
		}

	}
	
	public TrainingCourseType updateTrainingCourseType(RetailscmUserContext userContext,String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTrainingCourseType(userContext, trainingCourseTypeId, trainingCourseTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());
		if(trainingCourseType.getVersion() != trainingCourseTypeVersion){
			String message = "The target version("+trainingCourseType.getVersion()+") is not equals to version("+trainingCourseTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(trainingCourseType){ 
			//will be good when the trainingCourseType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TrainingCourseType.
			
			trainingCourseType.changeProperty(property, newValueExpr);
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().done());
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
			//return saveTrainingCourseType(userContext, trainingCourseType, tokens().done());
		}

	}
	
	public TrainingCourseType updateTrainingCourseTypeProperty(RetailscmUserContext userContext,String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTrainingCourseType(userContext, trainingCourseTypeId, trainingCourseTypeVersion, property, newValueExpr, tokensExpr);
		
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());
		if(trainingCourseType.getVersion() != trainingCourseTypeVersion){
			String message = "The target version("+trainingCourseType.getVersion()+") is not equals to version("+trainingCourseTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(trainingCourseType){ 
			//will be good when the trainingCourseType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TrainingCourseType.
			
			trainingCourseType.changeProperty(property, newValueExpr);
			
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().done());
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
			//return saveTrainingCourseType(userContext, trainingCourseType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TrainingCourseTypeTokens tokens(){
		return TrainingCourseTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TrainingCourseTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortCompanyTrainingListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TrainingCourseTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String trainingCourseTypeId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTrainingCourseType(trainingCourseTypeId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);
 		
 	}
 	public TrainingCourseType transferToAnotherCompany(RetailscmUserContext userContext, String trainingCourseTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, trainingCourseTypeId,anotherCompanyId);
 
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());	
		synchronized(trainingCourseType){
			//will be good when the trainingCourseType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			trainingCourseType.updateCompany(company);		
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, emptyOptions());
			
			return present(userContext,trainingCourseType, allTokens());
			
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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForTrainingCourseType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String trainingCourseTypeId, int trainingCourseTypeVersion) throws Exception {
		//deleteInternal(userContext, trainingCourseTypeId, trainingCourseTypeVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String trainingCourseTypeId, int trainingCourseTypeVersion) throws Exception{
			
		userContext.getDAOGroup().getTrainingCourseTypeDAO().delete(trainingCourseTypeId, trainingCourseTypeVersion);
	}
	
	public TrainingCourseType forgetByAll(RetailscmUserContext userContext, String trainingCourseTypeId, int trainingCourseTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, trainingCourseTypeId, trainingCourseTypeVersion);		
	}
	protected TrainingCourseType forgetByAllInternal(RetailscmUserContext userContext,
			String trainingCourseTypeId, int trainingCourseTypeVersion) throws Exception{
			
		return userContext.getDAOGroup().getTrainingCourseTypeDAO().disconnectFromAll(trainingCourseTypeId, trainingCourseTypeVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TrainingCourseTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTrainingCourseTypeDAO().deleteAll();
	}


	//disconnect TrainingCourseType with company in CompanyTraining
	protected TrainingCourseType breakWithCompanyTrainingByCompany(RetailscmUserContext userContext, String trainingCourseTypeId, String companyId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());

			synchronized(trainingCourseType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTrainingCourseTypeDAO().planToRemoveCompanyTrainingListWithCompany(trainingCourseType, companyId, this.emptyOptions());

				trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
				return trainingCourseType;
			}
	}
	//disconnect TrainingCourseType with instructor in CompanyTraining
	protected TrainingCourseType breakWithCompanyTrainingByInstructor(RetailscmUserContext userContext, String trainingCourseTypeId, String instructorId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());

			synchronized(trainingCourseType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTrainingCourseTypeDAO().planToRemoveCompanyTrainingListWithInstructor(trainingCourseType, instructorId, this.emptyOptions());

				trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
				return trainingCourseType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, String title, String companyId, String instructorId, Date timeStart, int durationHours,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTrainingCourseType(trainingCourseTypeId);

		
		userContext.getChecker().checkTitleOfCompanyTraining(title);
		
		userContext.getChecker().checkCompanyIdOfCompanyTraining(companyId);
		
		userContext.getChecker().checkInstructorIdOfCompanyTraining(instructorId);
		
		userContext.getChecker().checkTimeStartOfCompanyTraining(timeStart);
		
		userContext.getChecker().checkDurationHoursOfCompanyTraining(durationHours);
	
		userContext.getChecker().throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);

	
	}
	public  TrainingCourseType addCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, String title, String companyId, String instructorId, Date timeStart, int durationHours, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCompanyTraining(userContext,trainingCourseTypeId,title, companyId, instructorId, timeStart, durationHours,tokensExpr);
		
		CompanyTraining companyTraining = createCompanyTraining(userContext,title, companyId, instructorId, timeStart, durationHours);
		
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());
		synchronized(trainingCourseType){ 
			//Will be good when the trainingCourseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			trainingCourseType.addCompanyTraining( companyTraining );		
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
			
			userContext.getManagerGroup().getCompanyTrainingManager().onNewInstanceCreated(userContext, companyTraining);
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCompanyTrainingProperties(RetailscmUserContext userContext, String trainingCourseTypeId,String id,String title,Date timeStart,int durationHours,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTrainingCourseType(trainingCourseTypeId);
		userContext.getChecker().checkIdOfCompanyTraining(id);
		
		userContext.getChecker().checkTitleOfCompanyTraining( title);
		userContext.getChecker().checkTimeStartOfCompanyTraining( timeStart);
		userContext.getChecker().checkDurationHoursOfCompanyTraining( durationHours);

		userContext.getChecker().throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);
		
	}
	public  TrainingCourseType updateCompanyTrainingProperties(RetailscmUserContext userContext, String trainingCourseTypeId, String id,String title,Date timeStart,int durationHours, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingCompanyTrainingProperties(userContext,trainingCourseTypeId,id,title,timeStart,durationHours,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCompanyTrainingListList()
				.searchCompanyTrainingListWith(CompanyTraining.ID_PROPERTY, "is", id).done();
		
		TrainingCourseType trainingCourseTypeToUpdate = loadTrainingCourseType(userContext, trainingCourseTypeId, options);
		
		if(trainingCourseTypeToUpdate.getCompanyTrainingList().isEmpty()){
			throw new TrainingCourseTypeManagerException("CompanyTraining is NOT FOUND with id: '"+id+"'");
		}
		
		CompanyTraining item = trainingCourseTypeToUpdate.getCompanyTrainingList().first();
		
		item.updateTitle( title );
		item.updateTimeStart( timeStart );
		item.updateDurationHours( durationHours );

		
		//checkParamsForAddingCompanyTraining(userContext,trainingCourseTypeId,name, code, used,tokensExpr);
		TrainingCourseType trainingCourseType = saveTrainingCourseType(userContext, trainingCourseTypeToUpdate, tokens().withCompanyTrainingList().done());
		synchronized(trainingCourseType){ 
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected CompanyTraining createCompanyTraining(RetailscmUserContext userContext, String title, String companyId, String instructorId, Date timeStart, int durationHours) throws Exception{

		CompanyTraining companyTraining = new CompanyTraining();
		
		
		companyTraining.setTitle(title);		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		companyTraining.setCompany(company);		
		Instructor  instructor = new Instructor();
		instructor.setId(instructorId);		
		companyTraining.setInstructor(instructor);		
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
	
	protected void checkParamsForRemovingCompanyTrainingList(RetailscmUserContext userContext, String trainingCourseTypeId, 
			String companyTrainingIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTrainingCourseType(trainingCourseTypeId);
		for(String companyTrainingId: companyTrainingIds){
			userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);
		
	}
	public  TrainingCourseType removeCompanyTrainingList(RetailscmUserContext userContext, String trainingCourseTypeId, 
			String companyTrainingIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingCompanyTrainingList(userContext, trainingCourseTypeId,  companyTrainingIds, tokensExpr);
			
			
			TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());
			synchronized(trainingCourseType){ 
				//Will be good when the trainingCourseType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTrainingCourseTypeDAO().planToRemoveCompanyTrainingList(trainingCourseType, companyTrainingIds, allTokens());
				trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
				deleteRelationListInGraph(userContext, trainingCourseType.getCompanyTrainingList());
				return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTrainingCourseType( trainingCourseTypeId);
		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		userContext.getChecker().checkVersionOfCompanyTraining(companyTrainingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);
	
	}
	public  TrainingCourseType removeCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCompanyTraining(userContext,trainingCourseTypeId, companyTrainingId, companyTrainingVersion,tokensExpr);
		
		CompanyTraining companyTraining = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());
		synchronized(trainingCourseType){ 
			//Will be good when the trainingCourseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			trainingCourseType.removeCompanyTraining( companyTraining );		
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
			deleteRelationInGraph(userContext, companyTraining);
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTrainingCourseType( trainingCourseTypeId);
		userContext.getChecker().checkIdOfCompanyTraining(companyTrainingId);
		userContext.getChecker().checkVersionOfCompanyTraining(companyTrainingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);
	
	}
	public  TrainingCourseType copyCompanyTrainingFrom(RetailscmUserContext userContext, String trainingCourseTypeId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCompanyTraining(userContext,trainingCourseTypeId, companyTrainingId, companyTrainingVersion,tokensExpr);
		
		CompanyTraining companyTraining = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());
		synchronized(trainingCourseType){ 
			//Will be good when the trainingCourseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			companyTraining.updateLastUpdateTime(userContext.now());
			
			trainingCourseType.copyCompanyTrainingFrom( companyTraining );		
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
			
			userContext.getManagerGroup().getCompanyTrainingManager().onNewInstanceCreated(userContext, (CompanyTraining)trainingCourseType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTrainingCourseType(trainingCourseTypeId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);
	
	}
	
	public  TrainingCourseType updateCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCompanyTraining(userContext, trainingCourseTypeId, companyTrainingId, companyTrainingVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withCompanyTrainingList().searchCompanyTrainingListWith(CompanyTraining.ID_PROPERTY, "eq", companyTrainingId).done();
		
		
		
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, loadTokens);
		
		synchronized(trainingCourseType){ 
			//Will be good when the trainingCourseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//trainingCourseType.removeCompanyTraining( companyTraining );	
			//make changes to AcceleraterAccount.
			CompanyTraining companyTrainingIndex = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		
			CompanyTraining companyTraining = trainingCourseType.findTheCompanyTraining(companyTrainingIndex);
			if(companyTraining == null){
				throw new TrainingCourseTypeManagerException(companyTraining+" is NOT FOUND" );
			}
			
			companyTraining.changeProperty(property, newValueExpr);
			companyTraining.updateLastUpdateTime(userContext.now());
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, TrainingCourseType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


