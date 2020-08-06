
package com.doublechaintech.retailscm.instructor;

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



import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;






public class InstructorManagerImpl extends CustomRetailscmCheckerManager implements InstructorManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = InstructorTokens.start().withTokenFromListName(listName).done();
		Instructor  instructor = (Instructor) this.loadInstructor(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = instructor.collectRefercencesFromLists();
		instructorDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, instructor, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new InstructorGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "Instructor";
	@Override
	public InstructorDAO daoOf(RetailscmUserContext userContext) {
		return instructorDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfInstructor(instructorId);
		checkerOf(userContext).throwExceptionIfHasErrors( InstructorManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Instructor instructor = loadInstructor( userContext, instructorId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,instructor, tokens);
 	}
 	
 	
 	 public Instructor searchInstructor(RetailscmUserContext userContext, String instructorId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfInstructor(instructorId);
		checkerOf(userContext).throwExceptionIfHasErrors( InstructorManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		Instructor instructor = loadInstructor( userContext, instructorId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,instructor, tokens);
 	}
 	
 	

 	protected Instructor present(RetailscmUserContext userContext, Instructor instructor, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,instructor,tokens);
		
		
		Instructor  instructorToPresent = instructorDaoOf(userContext).present(instructor, tokens);
		
		List<BaseEntity> entityListToNaming = instructorToPresent.collectRefercencesFromLists();
		instructorDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,instructor,tokens);
		
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
 		return instructorDaoOf(userContext).save(instructor, tokens);
 	}
 	protected Instructor loadInstructor(RetailscmUserContext userContext, String instructorId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfInstructor(instructorId);
		checkerOf(userContext).throwExceptionIfHasErrors( InstructorManagerException.class);

 
 		return instructorDaoOf(userContext).load(instructorId, tokens);
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
	
 	
 	
 
 	
 	

	public Instructor createInstructor(RetailscmUserContext userContext, String title,String familyName,String givenName,String cellPhone,String email,String companyId,String introduction) throws Exception
	//public Instructor createInstructor(RetailscmUserContext userContext,String title, String familyName, String givenName, String cellPhone, String email, String companyId, String introduction) throws Exception
	{

		

		

		checkerOf(userContext).checkTitleOfInstructor(title);
		checkerOf(userContext).checkFamilyNameOfInstructor(familyName);
		checkerOf(userContext).checkGivenNameOfInstructor(givenName);
		checkerOf(userContext).checkCellPhoneOfInstructor(cellPhone);
		checkerOf(userContext).checkEmailOfInstructor(email);
		checkerOf(userContext).checkIntroductionOfInstructor(introduction);
	
		checkerOf(userContext).throwExceptionIfHasErrors(InstructorManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfInstructor(instructorId);
		checkerOf(userContext).checkVersionOfInstructor( instructorVersion);
		

		if(Instructor.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfInstructor(parseString(newValueExpr));
		
			
		}
		if(Instructor.FAMILY_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFamilyNameOfInstructor(parseString(newValueExpr));
		
			
		}
		if(Instructor.GIVEN_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkGivenNameOfInstructor(parseString(newValueExpr));
		
			
		}
		if(Instructor.CELL_PHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCellPhoneOfInstructor(parseString(newValueExpr));
		
			
		}
		if(Instructor.EMAIL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmailOfInstructor(parseString(newValueExpr));
		
			
		}		

		
		if(Instructor.INTRODUCTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkIntroductionOfInstructor(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(InstructorManagerException.class);


	}



	public Instructor clone(RetailscmUserContext userContext, String fromInstructorId) throws Exception{

		return instructorDaoOf(userContext).clone(fromInstructorId, this.allTokens());
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
			if (instructor.isChanged()){
			instructor.updateLastUpdateTime(userContext.now());
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return InstructorTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String instructorId, String anotherCompanyId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfInstructor(instructorId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(InstructorManagerException.class);

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForInstructor(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String instructorId, int instructorVersion) throws Exception {
		//deleteInternal(userContext, instructorId, instructorVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String instructorId, int instructorVersion) throws Exception{

		instructorDaoOf(userContext).delete(instructorId, instructorVersion);
	}

	public Instructor forgetByAll(RetailscmUserContext userContext, String instructorId, int instructorVersion) throws Exception {
		return forgetByAllInternal(userContext, instructorId, instructorVersion);
	}
	protected Instructor forgetByAllInternal(RetailscmUserContext userContext,
			String instructorId, int instructorVersion) throws Exception{

		return instructorDaoOf(userContext).disconnectFromAll(instructorId, instructorVersion);
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
		return instructorDaoOf(userContext).deleteAll();
	}


	//disconnect Instructor with company in CompanyTraining
	protected Instructor breakWithCompanyTrainingByCompany(RetailscmUserContext userContext, String instructorId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Instructor instructor = loadInstructor(userContext, instructorId, allTokens());

			synchronized(instructor){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				instructorDaoOf(userContext).planToRemoveCompanyTrainingListWithCompany(instructor, companyId, this.emptyOptions());

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

				instructorDaoOf(userContext).planToRemoveCompanyTrainingListWithTrainingCourseType(instructor, trainingCourseTypeId, this.emptyOptions());

				instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
				return instructor;
			}
	}






	protected void checkParamsForAddingCompanyTraining(RetailscmUserContext userContext, String instructorId, String title, String companyId, String trainingCourseTypeId, Date timeStart, int durationHours,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfInstructor(instructorId);

		
		checkerOf(userContext).checkTitleOfCompanyTraining(title);
		
		checkerOf(userContext).checkCompanyIdOfCompanyTraining(companyId);
		
		checkerOf(userContext).checkTrainingCourseTypeIdOfCompanyTraining(trainingCourseTypeId);
		
		checkerOf(userContext).checkTimeStartOfCompanyTraining(timeStart);
		
		checkerOf(userContext).checkDurationHoursOfCompanyTraining(durationHours);
	
		checkerOf(userContext).throwExceptionIfHasErrors(InstructorManagerException.class);


	}
	public  Instructor addCompanyTraining(RetailscmUserContext userContext, String instructorId, String title, String companyId, String trainingCourseTypeId, Date timeStart, int durationHours, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingCompanyTraining(userContext,instructorId,title, companyId, trainingCourseTypeId, timeStart, durationHours,tokensExpr);

		CompanyTraining companyTraining = createCompanyTraining(userContext,title, companyId, trainingCourseTypeId, timeStart, durationHours);

		Instructor instructor = loadInstructor(userContext, instructorId, emptyOptions());
		synchronized(instructor){
			//Will be good when the instructor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			instructor.addCompanyTraining( companyTraining );
			instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
			
			companyTrainingManagerOf(userContext).onNewInstanceCreated(userContext, companyTraining);
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCompanyTrainingProperties(RetailscmUserContext userContext, String instructorId,String id,String title,Date timeStart,int durationHours,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfInstructor(instructorId);
		checkerOf(userContext).checkIdOfCompanyTraining(id);

		checkerOf(userContext).checkTitleOfCompanyTraining( title);
		checkerOf(userContext).checkTimeStartOfCompanyTraining( timeStart);
		checkerOf(userContext).checkDurationHoursOfCompanyTraining( durationHours);

		checkerOf(userContext).throwExceptionIfHasErrors(InstructorManagerException.class);

	}
	public  Instructor updateCompanyTrainingProperties(RetailscmUserContext userContext, String instructorId, String id,String title,Date timeStart,int durationHours, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCompanyTrainingProperties(userContext,instructorId,id,title,timeStart,durationHours,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCompanyTrainingListList()
				.searchCompanyTrainingListWith(CompanyTraining.ID_PROPERTY, tokens().is(), id).done();

		Instructor instructorToUpdate = loadInstructor(userContext, instructorId, options);

		if(instructorToUpdate.getCompanyTrainingList().isEmpty()){
			throw new InstructorManagerException("CompanyTraining is NOT FOUND with id: '"+id+"'");
		}

		CompanyTraining item = instructorToUpdate.getCompanyTrainingList().first();
		beforeUpdateCompanyTrainingProperties(userContext,item, instructorId,id,title,timeStart,durationHours,tokensExpr);
		item.updateTitle( title );
		item.updateTimeStart( timeStart );
		item.updateDurationHours( durationHours );


		//checkParamsForAddingCompanyTraining(userContext,instructorId,name, code, used,tokensExpr);
		Instructor instructor = saveInstructor(userContext, instructorToUpdate, tokens().withCompanyTrainingList().done());
		synchronized(instructor){
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateCompanyTrainingProperties(RetailscmUserContext userContext, CompanyTraining item, String instructorId, String id,String title,Date timeStart,int durationHours, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfInstructor(instructorId);
		for(String companyTrainingIdItem: companyTrainingIds){
			checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(InstructorManagerException.class);

	}
	public  Instructor removeCompanyTrainingList(RetailscmUserContext userContext, String instructorId,
			String companyTrainingIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCompanyTrainingList(userContext, instructorId,  companyTrainingIds, tokensExpr);


			Instructor instructor = loadInstructor(userContext, instructorId, allTokens());
			synchronized(instructor){
				//Will be good when the instructor loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				instructorDaoOf(userContext).planToRemoveCompanyTrainingList(instructor, companyTrainingIds, allTokens());
				instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
				deleteRelationListInGraph(userContext, instructor.getCompanyTrainingList());
				return present(userContext,instructor, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCompanyTraining(RetailscmUserContext userContext, String instructorId,
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfInstructor( instructorId);
		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).checkVersionOfCompanyTraining(companyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(InstructorManagerException.class);

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
		
		checkerOf(userContext).checkIdOfInstructor( instructorId);
		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).checkVersionOfCompanyTraining(companyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(InstructorManagerException.class);

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
			
			companyTrainingManagerOf(userContext).onNewInstanceCreated(userContext, (CompanyTraining)instructor.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingCompanyTraining(RetailscmUserContext userContext, String instructorId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfInstructor(instructorId);
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
		

		checkerOf(userContext).throwExceptionIfHasErrors(InstructorManagerException.class);

	}

	public  Instructor updateCompanyTraining(RetailscmUserContext userContext, String instructorId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingCompanyTraining(userContext, instructorId, companyTrainingId, companyTrainingVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withCompanyTrainingList().searchCompanyTrainingListWith(CompanyTraining.ID_PROPERTY, tokens().equals(), companyTrainingId).done();



		Instructor instructor = loadInstructor(userContext, instructorId, loadTokens);

		synchronized(instructor){
			//Will be good when the instructor loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//instructor.removeCompanyTraining( companyTraining );
			//make changes to AcceleraterAccount.
			CompanyTraining companyTrainingIdVersionKey = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);

			CompanyTraining companyTraining = instructor.findTheCompanyTraining(companyTrainingIdVersionKey);
			if(companyTraining == null){
				throw new InstructorManagerException(companyTrainingId+" is NOT FOUND" );
			}

			beforeUpdateCompanyTraining(userContext, companyTraining, instructorId, companyTrainingId, companyTrainingVersion, property, newValueExpr,  tokensExpr);
			companyTraining.changeProperty(property, newValueExpr);
			companyTraining.updateLastUpdateTime(userContext.now());
			instructor = saveInstructor(userContext, instructor, tokens().withCompanyTrainingList().done());
			return present(userContext,instructor, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateCompanyTraining(RetailscmUserContext userContext, CompanyTraining existed, String instructorId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, Instructor newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    instructorDaoOf(ctx).loadAllAsStream().forEach(
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
		//   Instructor newInstructor = this.createInstructor(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newInstructor
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Instructor.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<Instructor> list) throws Exception {
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
		SmartList<Instructor> list = instructorDaoOf(userContext).findInstructorByCompany(companyId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Instructor.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("讲师列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String instructorId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getInstructorDetailScope().clone();
		Instructor merchantObj = (Instructor) this.view(userContext, instructorId);
    String merchantObjId = instructorId;
    String linkToUrl =	"instructorManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "讲师"+"详情";
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
				MapUtil.put("id", "2-title")
				    .put("fieldName", "title")
				    .put("label", "头衔")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("title", merchantObj.getTitle());

		propList.add(
				MapUtil.put("id", "3-familyName")
				    .put("fieldName", "familyName")
				    .put("label", "姓")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("familyName", merchantObj.getFamilyName());

		propList.add(
				MapUtil.put("id", "4-givenName")
				    .put("fieldName", "givenName")
				    .put("label", "名")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("givenName", merchantObj.getGivenName());

		propList.add(
				MapUtil.put("id", "5-cellPhone")
				    .put("fieldName", "cellPhone")
				    .put("label", "手机")
				    .put("type", "mobile")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("cellPhone", merchantObj.getCellPhone());

		propList.add(
				MapUtil.put("id", "6-email")
				    .put("fieldName", "email")
				    .put("label", "电子邮件")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("email", merchantObj.getEmail());

		propList.add(
				MapUtil.put("id", "7-company")
				    .put("fieldName", "company")
				    .put("label", "公司")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("company", merchantObj.getCompany());

		propList.add(
				MapUtil.put("id", "8-introduction")
				    .put("fieldName", "introduction")
				    .put("label", "介绍")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("introduction", merchantObj.getIntroduction());

		propList.add(
				MapUtil.put("id", "9-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "更新于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：companyTrainingListSection
		Map companyTrainingListSection = ListofUtils.buildSection(
		    "companyTrainingListSection",
		    "公司培训名单",
		    null,
		    "",
		    "__no_group",
		    "companyTrainingManager/listByInstructor/"+merchantObjId+"/",
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


