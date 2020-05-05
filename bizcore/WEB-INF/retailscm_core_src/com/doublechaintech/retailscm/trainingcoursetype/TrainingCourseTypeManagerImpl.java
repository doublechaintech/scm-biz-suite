
package com.doublechaintech.retailscm.trainingcoursetype;

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


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;






public class TrainingCourseTypeManagerImpl extends CustomRetailscmCheckerManager implements TrainingCourseTypeManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = TrainingCourseTypeTokens.start().withTokenFromListName(listName).done();
		TrainingCourseType  trainingCourseType = (TrainingCourseType) this.loadTrainingCourseType(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = trainingCourseType.collectRefercencesFromLists();
		trainingCourseTypeDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, trainingCourseType, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new TrainingCourseTypeGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "TrainingCourseType";
	@Override
	public TrainingCourseTypeDAO daoOf(RetailscmUserContext userContext) {
		return trainingCourseTypeDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( TrainingCourseTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,trainingCourseType, tokens);
 	}
 	
 	
 	 public TrainingCourseType searchTrainingCourseType(RetailscmUserContext userContext, String trainingCourseTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( TrainingCourseTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,trainingCourseType, tokens);
 	}
 	
 	

 	protected TrainingCourseType present(RetailscmUserContext userContext, TrainingCourseType trainingCourseType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,trainingCourseType,tokens);
		
		
		TrainingCourseType  trainingCourseTypeToPresent = trainingCourseTypeDaoOf(userContext).present(trainingCourseType, tokens);
		
		List<BaseEntity> entityListToNaming = trainingCourseTypeToPresent.collectRefercencesFromLists();
		trainingCourseTypeDaoOf(userContext).alias(entityListToNaming);
		
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
 		return trainingCourseTypeDaoOf(userContext).save(trainingCourseType, tokens);
 	}
 	protected TrainingCourseType loadTrainingCourseType(RetailscmUserContext userContext, String trainingCourseTypeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( TrainingCourseTypeManagerException.class);

 
 		return trainingCourseTypeDaoOf(userContext).load(trainingCourseTypeId, tokens);
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
	
 	
 	
 
 	
 	

	public TrainingCourseType createTrainingCourseType(RetailscmUserContext userContext, String code,String companyId,String name,String description) throws Exception
	//public TrainingCourseType createTrainingCourseType(RetailscmUserContext userContext,String code, String companyId, String name, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkCodeOfTrainingCourseType(code);
		checkerOf(userContext).checkNameOfTrainingCourseType(name);
		checkerOf(userContext).checkDescriptionOfTrainingCourseType(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeId);
		checkerOf(userContext).checkVersionOfTrainingCourseType( trainingCourseTypeVersion);
		

		if(TrainingCourseType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfTrainingCourseType(parseString(newValueExpr));
		
			
		}		

		
		if(TrainingCourseType.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfTrainingCourseType(parseString(newValueExpr));
		
			
		}
		if(TrainingCourseType.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfTrainingCourseType(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);


	}



	public TrainingCourseType clone(RetailscmUserContext userContext, String fromTrainingCourseTypeId) throws Exception{

		return trainingCourseTypeDaoOf(userContext).clone(fromTrainingCourseTypeId, this.allTokens());
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
			if (trainingCourseType.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TrainingCourseTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String trainingCourseTypeId, String anotherCompanyId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForTrainingCourseType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newCompanyId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String trainingCourseTypeId, int trainingCourseTypeVersion) throws Exception {
		//deleteInternal(userContext, trainingCourseTypeId, trainingCourseTypeVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String trainingCourseTypeId, int trainingCourseTypeVersion) throws Exception{

		trainingCourseTypeDaoOf(userContext).delete(trainingCourseTypeId, trainingCourseTypeVersion);
	}

	public TrainingCourseType forgetByAll(RetailscmUserContext userContext, String trainingCourseTypeId, int trainingCourseTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, trainingCourseTypeId, trainingCourseTypeVersion);
	}
	protected TrainingCourseType forgetByAllInternal(RetailscmUserContext userContext,
			String trainingCourseTypeId, int trainingCourseTypeVersion) throws Exception{

		return trainingCourseTypeDaoOf(userContext).disconnectFromAll(trainingCourseTypeId, trainingCourseTypeVersion);
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
		return trainingCourseTypeDaoOf(userContext).deleteAll();
	}


	//disconnect TrainingCourseType with company in CompanyTraining
	protected TrainingCourseType breakWithCompanyTrainingByCompany(RetailscmUserContext userContext, String trainingCourseTypeId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());

			synchronized(trainingCourseType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				trainingCourseTypeDaoOf(userContext).planToRemoveCompanyTrainingListWithCompany(trainingCourseType, companyId, this.emptyOptions());

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

				trainingCourseTypeDaoOf(userContext).planToRemoveCompanyTrainingListWithInstructor(trainingCourseType, instructorId, this.emptyOptions());

				trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
				return trainingCourseType;
			}
	}






	protected void checkParamsForAddingCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, String title, String companyId, String instructorId, Date timeStart, int durationHours,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeId);

		
		checkerOf(userContext).checkTitleOfCompanyTraining(title);
		
		checkerOf(userContext).checkCompanyIdOfCompanyTraining(companyId);
		
		checkerOf(userContext).checkInstructorIdOfCompanyTraining(instructorId);
		
		checkerOf(userContext).checkTimeStartOfCompanyTraining(timeStart);
		
		checkerOf(userContext).checkDurationHoursOfCompanyTraining(durationHours);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);


	}
	public  TrainingCourseType addCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, String title, String companyId, String instructorId, Date timeStart, int durationHours, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingCompanyTraining(userContext,trainingCourseTypeId,title, companyId, instructorId, timeStart, durationHours,tokensExpr);

		CompanyTraining companyTraining = createCompanyTraining(userContext,title, companyId, instructorId, timeStart, durationHours);

		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeId);
		checkerOf(userContext).checkIdOfCompanyTraining(id);

		checkerOf(userContext).checkTitleOfCompanyTraining( title);
		checkerOf(userContext).checkTimeStartOfCompanyTraining( timeStart);
		checkerOf(userContext).checkDurationHoursOfCompanyTraining( durationHours);

		checkerOf(userContext).throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);

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

		checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeId);
		for(String companyTrainingIdItem: companyTrainingIds){
			checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);

	}
	public  TrainingCourseType removeCompanyTrainingList(RetailscmUserContext userContext, String trainingCourseTypeId,
			String companyTrainingIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCompanyTrainingList(userContext, trainingCourseTypeId,  companyTrainingIds, tokensExpr);


			TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, allTokens());
			synchronized(trainingCourseType){
				//Will be good when the trainingCourseType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				trainingCourseTypeDaoOf(userContext).planToRemoveCompanyTrainingList(trainingCourseType, companyTrainingIds, allTokens());
				trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
				deleteRelationListInGraph(userContext, trainingCourseType.getCompanyTrainingList());
				return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId,
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTrainingCourseType( trainingCourseTypeId);
		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).checkVersionOfCompanyTraining(companyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfTrainingCourseType( trainingCourseTypeId);
		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).checkVersionOfCompanyTraining(companyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeId);
		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).checkVersionOfCompanyTraining(companyTrainingVersion);
		

		if(CompanyTraining.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfCompanyTraining(parseString(newValueExpr));
		
		}
		
		if(CompanyTraining.TIME_START_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTimeStartOfCompanyTraining(parseDate(newValueExpr));
		
		}
		
		if(CompanyTraining.DURATION_HOURS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDurationHoursOfCompanyTraining(parseInt(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(TrainingCourseTypeManagerException.class);

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
		//   TrainingCourseType newTrainingCourseType = this.createTrainingCourseType(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newTrainingCourseType
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, TrainingCourseType.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<TrainingCourseType> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> companyList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(companyList, RetailStoreCountryCenter.class);


    }
	
	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception {
		return listPageByCompany(userContext, companyId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception {
		SmartList<TrainingCourseType> list = trainingCourseTypeDaoOf(userContext).findTrainingCourseTypeByCompany(companyId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(TrainingCourseType.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("培训课程类型列表");
		page.setRequestName("listByCompany");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCompany/%s/",  getBeanName(), companyId)));

		page.assemblerContent(userContext, "listByCompany");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String trainingCourseTypeId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getTrainingCourseTypeDetailScope().clone();
		TrainingCourseType merchantObj = (TrainingCourseType) this.view(userContext, trainingCourseTypeId);
    String merchantObjId = trainingCourseTypeId;
    String linkToUrl =	"trainingCourseTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "培训课程类型"+"详情";
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
				MapUtil.put("id", "2-code")
				    .put("fieldName", "code")
				    .put("label", "代码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("code", merchantObj.getCode());

		propList.add(
				MapUtil.put("id", "3-company")
				    .put("fieldName", "company")
				    .put("label", "公司")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("company", merchantObj.getCompany());

		propList.add(
				MapUtil.put("id", "4-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "5-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		//处理 sectionList

		//处理Section：companyTrainingListSection
		Map companyTrainingListSection = ListofUtils.buildSection(
		    "companyTrainingListSection",
		    "公司培训名单",
		    null,
		    "",
		    "__no_group",
		    "companyTrainingManager/listByTrainingCourseType/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(companyTrainingListSection);

		result.put("companyTrainingListSection", ListofUtils.toShortList(merchantObj.getCompanyTrainingList(), "companyTraining"));
		vscope.field("companyTrainingListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( CompanyTraining.class.getName(), null));

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


