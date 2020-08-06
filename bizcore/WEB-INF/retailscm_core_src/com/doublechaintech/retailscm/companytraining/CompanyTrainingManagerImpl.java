
package com.doublechaintech.retailscm.companytraining;

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
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.instructor.CandidateInstructor;
import com.doublechaintech.retailscm.trainingcoursetype.CandidateTrainingCourseType;

import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;






public class CompanyTrainingManagerImpl extends CustomRetailscmCheckerManager implements CompanyTrainingManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = CompanyTrainingTokens.start().withTokenFromListName(listName).done();
		CompanyTraining  companyTraining = (CompanyTraining) this.loadCompanyTraining(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = companyTraining.collectRefercencesFromLists();
		companyTrainingDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, companyTraining, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new CompanyTrainingGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "CompanyTraining";
	@Override
	public CompanyTrainingDAO daoOf(RetailscmUserContext userContext) {
		return companyTrainingDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws CompanyTrainingManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new CompanyTrainingManagerException(message);

	}



 	protected CompanyTraining saveCompanyTraining(RetailscmUserContext userContext, CompanyTraining companyTraining, String [] tokensExpr) throws Exception{	
 		//return getCompanyTrainingDAO().save(companyTraining, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCompanyTraining(userContext, companyTraining, tokens);
 	}
 	
 	protected CompanyTraining saveCompanyTrainingDetail(RetailscmUserContext userContext, CompanyTraining companyTraining) throws Exception{	

 		
 		return saveCompanyTraining(userContext, companyTraining, allTokens());
 	}
 	
 	public CompanyTraining loadCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).throwExceptionIfHasErrors( CompanyTrainingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CompanyTraining companyTraining = loadCompanyTraining( userContext, companyTrainingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,companyTraining, tokens);
 	}
 	
 	
 	 public CompanyTraining searchCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).throwExceptionIfHasErrors( CompanyTrainingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		CompanyTraining companyTraining = loadCompanyTraining( userContext, companyTrainingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,companyTraining, tokens);
 	}
 	
 	

 	protected CompanyTraining present(RetailscmUserContext userContext, CompanyTraining companyTraining, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,companyTraining,tokens);
		
		
		CompanyTraining  companyTrainingToPresent = companyTrainingDaoOf(userContext).present(companyTraining, tokens);
		
		List<BaseEntity> entityListToNaming = companyTrainingToPresent.collectRefercencesFromLists();
		companyTrainingDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,companyTraining,tokens);
		
		return  companyTrainingToPresent;
		
		
	}
 
 	
 	
 	public CompanyTraining loadCompanyTrainingDetail(RetailscmUserContext userContext, String companyTrainingId) throws Exception{	
 		CompanyTraining companyTraining = loadCompanyTraining( userContext, companyTrainingId, allTokens());
 		return present(userContext,companyTraining, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String companyTrainingId) throws Exception{	
 		CompanyTraining companyTraining = loadCompanyTraining( userContext, companyTrainingId, viewTokens());
 		return present(userContext,companyTraining, allTokens());
		
 	}
 	protected CompanyTraining saveCompanyTraining(RetailscmUserContext userContext, CompanyTraining companyTraining, Map<String,Object>tokens) throws Exception{	
 		return companyTrainingDaoOf(userContext).save(companyTraining, tokens);
 	}
 	protected CompanyTraining loadCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).throwExceptionIfHasErrors( CompanyTrainingManagerException.class);

 
 		return companyTrainingDaoOf(userContext).load(companyTrainingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, CompanyTraining companyTraining, Map<String, Object> tokens){
		super.addActions(userContext, companyTraining, tokens);
		
		addAction(userContext, companyTraining, tokens,"@create","createCompanyTraining","createCompanyTraining/","main","primary");
		addAction(userContext, companyTraining, tokens,"@update","updateCompanyTraining","updateCompanyTraining/"+companyTraining.getId()+"/","main","primary");
		addAction(userContext, companyTraining, tokens,"@copy","cloneCompanyTraining","cloneCompanyTraining/"+companyTraining.getId()+"/","main","primary");
		
		addAction(userContext, companyTraining, tokens,"company_training.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+companyTraining.getId()+"/","main","primary");
		addAction(userContext, companyTraining, tokens,"company_training.transfer_to_instructor","transferToAnotherInstructor","transferToAnotherInstructor/"+companyTraining.getId()+"/","main","primary");
		addAction(userContext, companyTraining, tokens,"company_training.transfer_to_training_course_type","transferToAnotherTrainingCourseType","transferToAnotherTrainingCourseType/"+companyTraining.getId()+"/","main","primary");
		addAction(userContext, companyTraining, tokens,"company_training.addEmployeeCompanyTraining","addEmployeeCompanyTraining","addEmployeeCompanyTraining/"+companyTraining.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, companyTraining, tokens,"company_training.removeEmployeeCompanyTraining","removeEmployeeCompanyTraining","removeEmployeeCompanyTraining/"+companyTraining.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, companyTraining, tokens,"company_training.updateEmployeeCompanyTraining","updateEmployeeCompanyTraining","updateEmployeeCompanyTraining/"+companyTraining.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, companyTraining, tokens,"company_training.copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom/"+companyTraining.getId()+"/","employeeCompanyTrainingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, CompanyTraining companyTraining, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public CompanyTraining createCompanyTraining(RetailscmUserContext userContext, String title,String companyId,String instructorId,String trainingCourseTypeId,Date timeStart,int durationHours) throws Exception
	//public CompanyTraining createCompanyTraining(RetailscmUserContext userContext,String title, String companyId, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours) throws Exception
	{

		

		

		checkerOf(userContext).checkTitleOfCompanyTraining(title);
		checkerOf(userContext).checkTimeStartOfCompanyTraining(timeStart);
		checkerOf(userContext).checkDurationHoursOfCompanyTraining(durationHours);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CompanyTrainingManagerException.class);


		CompanyTraining companyTraining=createNewCompanyTraining();	

		companyTraining.setTitle(title);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		companyTraining.setCompany(company);
		
		
			
		Instructor instructor = loadInstructor(userContext, instructorId,emptyOptions());
		companyTraining.setInstructor(instructor);
		
		
			
		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId,emptyOptions());
		companyTraining.setTrainingCourseType(trainingCourseType);
		
		
		companyTraining.setTimeStart(timeStart);
		companyTraining.setDurationHours(durationHours);
		companyTraining.setLastUpdateTime(userContext.now());

		companyTraining = saveCompanyTraining(userContext, companyTraining, emptyOptions());
		
		onNewInstanceCreated(userContext, companyTraining);
		return companyTraining;


	}
	protected CompanyTraining createNewCompanyTraining()
	{

		return new CompanyTraining();
	}

	protected void checkParamsForUpdatingCompanyTraining(RetailscmUserContext userContext,String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).checkVersionOfCompanyTraining( companyTrainingVersion);
		

		if(CompanyTraining.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfCompanyTraining(parseString(newValueExpr));
		
			
		}		

				

				

		
		if(CompanyTraining.TIME_START_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTimeStartOfCompanyTraining(parseDate(newValueExpr));
		
			
		}
		if(CompanyTraining.DURATION_HOURS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDurationHoursOfCompanyTraining(parseInt(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(CompanyTrainingManagerException.class);


	}



	public CompanyTraining clone(RetailscmUserContext userContext, String fromCompanyTrainingId) throws Exception{

		return companyTrainingDaoOf(userContext).clone(fromCompanyTrainingId, this.allTokens());
	}

	public CompanyTraining internalSaveCompanyTraining(RetailscmUserContext userContext, CompanyTraining companyTraining) throws Exception
	{
		return internalSaveCompanyTraining(userContext, companyTraining, allTokens());

	}
	public CompanyTraining internalSaveCompanyTraining(RetailscmUserContext userContext, CompanyTraining companyTraining, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingCompanyTraining(userContext, companyTrainingId, companyTrainingVersion, property, newValueExpr, tokensExpr);


		synchronized(companyTraining){
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CompanyTraining.
			if (companyTraining.isChanged()){
			companyTraining.updateLastUpdateTime(userContext.now());
			}
			companyTraining = saveCompanyTraining(userContext, companyTraining, options);
			return companyTraining;

		}

	}

	public CompanyTraining updateCompanyTraining(RetailscmUserContext userContext,String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCompanyTraining(userContext, companyTrainingId, companyTrainingVersion, property, newValueExpr, tokensExpr);



		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		if(companyTraining.getVersion() != companyTrainingVersion){
			String message = "The target version("+companyTraining.getVersion()+") is not equals to version("+companyTrainingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(companyTraining){
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CompanyTraining.
			companyTraining.updateLastUpdateTime(userContext.now());
			companyTraining.changeProperty(property, newValueExpr);
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().done());
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
			//return saveCompanyTraining(userContext, companyTraining, tokens().done());
		}

	}

	public CompanyTraining updateCompanyTrainingProperty(RetailscmUserContext userContext,String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCompanyTraining(userContext, companyTrainingId, companyTrainingVersion, property, newValueExpr, tokensExpr);

		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		if(companyTraining.getVersion() != companyTrainingVersion){
			String message = "The target version("+companyTraining.getVersion()+") is not equals to version("+companyTrainingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(companyTraining){
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CompanyTraining.

			companyTraining.changeProperty(property, newValueExpr);
			companyTraining.updateLastUpdateTime(userContext.now());
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().done());
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
			//return saveCompanyTraining(userContext, companyTraining, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected CompanyTrainingTokens tokens(){
		return CompanyTrainingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CompanyTrainingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeCompanyTrainingListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CompanyTrainingTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String companyTrainingId, String anotherCompanyId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CompanyTrainingManagerException.class);

 	}
 	public CompanyTraining transferToAnotherCompany(RetailscmUserContext userContext, String companyTrainingId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, companyTrainingId,anotherCompanyId);
 
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());	
		synchronized(companyTraining){
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			companyTraining.updateCompany(company);		
			companyTraining = saveCompanyTraining(userContext, companyTraining, emptyOptions());
			
			return present(userContext,companyTraining, allTokens());
			
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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForCompanyTraining(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherInstructor(RetailscmUserContext userContext, String companyTrainingId, String anotherInstructorId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
 		checkerOf(userContext).checkIdOfInstructor(anotherInstructorId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CompanyTrainingManagerException.class);

 	}
 	public CompanyTraining transferToAnotherInstructor(RetailscmUserContext userContext, String companyTrainingId, String anotherInstructorId) throws Exception
 	{
 		checkParamsForTransferingAnotherInstructor(userContext, companyTrainingId,anotherInstructorId);
 
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());	
		synchronized(companyTraining){
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Instructor instructor = loadInstructor(userContext, anotherInstructorId, emptyOptions());		
			companyTraining.updateInstructor(instructor);		
			companyTraining = saveCompanyTraining(userContext, companyTraining, emptyOptions());
			
			return present(userContext,companyTraining, allTokens());
			
		}

 	}

	


	public CandidateInstructor requestCandidateInstructor(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateInstructor result = new CandidateInstructor();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Instructor> candidateList = instructorDaoOf(userContext).requestCandidateInstructorForCompanyTraining(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherTrainingCourseType(RetailscmUserContext userContext, String companyTrainingId, String anotherTrainingCourseTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
 		checkerOf(userContext).checkIdOfTrainingCourseType(anotherTrainingCourseTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CompanyTrainingManagerException.class);

 	}
 	public CompanyTraining transferToAnotherTrainingCourseType(RetailscmUserContext userContext, String companyTrainingId, String anotherTrainingCourseTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherTrainingCourseType(userContext, companyTrainingId,anotherTrainingCourseTypeId);
 
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());	
		synchronized(companyTraining){
			//will be good when the companyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, anotherTrainingCourseTypeId, emptyOptions());		
			companyTraining.updateTrainingCourseType(trainingCourseType);		
			companyTraining = saveCompanyTraining(userContext, companyTraining, emptyOptions());
			
			return present(userContext,companyTraining, allTokens());
			
		}

 	}

	


	public CandidateTrainingCourseType requestCandidateTrainingCourseType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTrainingCourseType result = new CandidateTrainingCourseType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TrainingCourseType> candidateList = trainingCourseTypeDaoOf(userContext).requestCandidateTrainingCourseTypeForCompanyTraining(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Instructor loadInstructor(RetailscmUserContext userContext, String newInstructorId, Map<String,Object> options) throws Exception
 	{

 		return instructorDaoOf(userContext).load(newInstructorId, options);
 	}
 	


	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newCompanyId, options);
 	}
 	


	

 	protected TrainingCourseType loadTrainingCourseType(RetailscmUserContext userContext, String newTrainingCourseTypeId, Map<String,Object> options) throws Exception
 	{

 		return trainingCourseTypeDaoOf(userContext).load(newTrainingCourseTypeId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String companyTrainingId, int companyTrainingVersion) throws Exception {
		//deleteInternal(userContext, companyTrainingId, companyTrainingVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String companyTrainingId, int companyTrainingVersion) throws Exception{

		companyTrainingDaoOf(userContext).delete(companyTrainingId, companyTrainingVersion);
	}

	public CompanyTraining forgetByAll(RetailscmUserContext userContext, String companyTrainingId, int companyTrainingVersion) throws Exception {
		return forgetByAllInternal(userContext, companyTrainingId, companyTrainingVersion);
	}
	protected CompanyTraining forgetByAllInternal(RetailscmUserContext userContext,
			String companyTrainingId, int companyTrainingVersion) throws Exception{

		return companyTrainingDaoOf(userContext).disconnectFromAll(companyTrainingId, companyTrainingVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CompanyTrainingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return companyTrainingDaoOf(userContext).deleteAll();
	}


	//disconnect CompanyTraining with employee in EmployeeCompanyTraining
	protected CompanyTraining breakWithEmployeeCompanyTrainingByEmployee(RetailscmUserContext userContext, String companyTrainingId, String employeeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());

			synchronized(companyTraining){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				companyTrainingDaoOf(userContext).planToRemoveEmployeeCompanyTrainingListWithEmployee(companyTraining, employeeId, this.emptyOptions());

				companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
				return companyTraining;
			}
	}
	//disconnect CompanyTraining with scoring in EmployeeCompanyTraining
	protected CompanyTraining breakWithEmployeeCompanyTrainingByScoring(RetailscmUserContext userContext, String companyTrainingId, String scoringId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());

			synchronized(companyTraining){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				companyTrainingDaoOf(userContext).planToRemoveEmployeeCompanyTrainingListWithScoring(companyTraining, scoringId, this.emptyOptions());

				companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
				return companyTraining;
			}
	}






	protected void checkParamsForAddingEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeId, String scoringId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);

		
		checkerOf(userContext).checkEmployeeIdOfEmployeeCompanyTraining(employeeId);
		
		checkerOf(userContext).checkScoringIdOfEmployeeCompanyTraining(scoringId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CompanyTrainingManagerException.class);


	}
	public  CompanyTraining addEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeId, String scoringId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeCompanyTraining(userContext,companyTrainingId,employeeId, scoringId,tokensExpr);

		EmployeeCompanyTraining employeeCompanyTraining = createEmployeeCompanyTraining(userContext,employeeId, scoringId);

		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, emptyOptions());
		synchronized(companyTraining){
			//Will be good when the companyTraining loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			companyTraining.addEmployeeCompanyTraining( employeeCompanyTraining );
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
			
			employeeCompanyTrainingManagerOf(userContext).onNewInstanceCreated(userContext, employeeCompanyTraining);
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeCompanyTrainingProperties(RetailscmUserContext userContext, String companyTrainingId,String id,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(id);


		checkerOf(userContext).throwExceptionIfHasErrors(CompanyTrainingManagerException.class);

	}
	public  CompanyTraining updateEmployeeCompanyTrainingProperties(RetailscmUserContext userContext, String companyTrainingId, String id, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeCompanyTrainingProperties(userContext,companyTrainingId,id,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeCompanyTrainingListList()
				.searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, tokens().is(), id).done();

		CompanyTraining companyTrainingToUpdate = loadCompanyTraining(userContext, companyTrainingId, options);

		if(companyTrainingToUpdate.getEmployeeCompanyTrainingList().isEmpty()){
			throw new CompanyTrainingManagerException("EmployeeCompanyTraining is NOT FOUND with id: '"+id+"'");
		}

		EmployeeCompanyTraining item = companyTrainingToUpdate.getEmployeeCompanyTrainingList().first();
		beforeUpdateEmployeeCompanyTrainingProperties(userContext,item, companyTrainingId,id,tokensExpr);


		//checkParamsForAddingEmployeeCompanyTraining(userContext,companyTrainingId,name, code, used,tokensExpr);
		CompanyTraining companyTraining = saveCompanyTraining(userContext, companyTrainingToUpdate, tokens().withEmployeeCompanyTrainingList().done());
		synchronized(companyTraining){
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateEmployeeCompanyTrainingProperties(RetailscmUserContext userContext, EmployeeCompanyTraining item, String companyTrainingId, String id, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected EmployeeCompanyTraining createEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, String scoringId) throws Exception{

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeCompanyTraining.setEmployee(employee);		
		Scoring  scoring = new Scoring();
		scoring.setId(scoringId);		
		employeeCompanyTraining.setScoring(scoring);
	
		
		return employeeCompanyTraining;


	}

	protected EmployeeCompanyTraining createIndexedEmployeeCompanyTraining(String id, int version){

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		employeeCompanyTraining.setId(id);
		employeeCompanyTraining.setVersion(version);
		return employeeCompanyTraining;

	}

	protected void checkParamsForRemovingEmployeeCompanyTrainingList(RetailscmUserContext userContext, String companyTrainingId,
			String employeeCompanyTrainingIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		for(String employeeCompanyTrainingIdItem: employeeCompanyTrainingIds){
			checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(CompanyTrainingManagerException.class);

	}
	public  CompanyTraining removeEmployeeCompanyTrainingList(RetailscmUserContext userContext, String companyTrainingId,
			String employeeCompanyTrainingIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeCompanyTrainingList(userContext, companyTrainingId,  employeeCompanyTrainingIds, tokensExpr);


			CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
			synchronized(companyTraining){
				//Will be good when the companyTraining loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				companyTrainingDaoOf(userContext).planToRemoveEmployeeCompanyTrainingList(companyTraining, employeeCompanyTrainingIds, allTokens());
				companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
				deleteRelationListInGraph(userContext, companyTraining.getEmployeeCompanyTrainingList());
				return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId,
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCompanyTraining( companyTrainingId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CompanyTrainingManagerException.class);

	}
	public  CompanyTraining removeEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId,
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployeeCompanyTraining(userContext,companyTrainingId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);

		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		synchronized(companyTraining){
			//Will be good when the companyTraining loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			companyTraining.removeEmployeeCompanyTraining( employeeCompanyTraining );
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
			deleteRelationInGraph(userContext, employeeCompanyTraining);
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId,
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCompanyTraining( companyTrainingId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CompanyTrainingManagerException.class);

	}
	public  CompanyTraining copyEmployeeCompanyTrainingFrom(RetailscmUserContext userContext, String companyTrainingId,
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployeeCompanyTraining(userContext,companyTrainingId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);

		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, allTokens());
		synchronized(companyTraining){
			//Will be good when the companyTraining loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			companyTraining.copyEmployeeCompanyTrainingFrom( employeeCompanyTraining );
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
			
			employeeCompanyTrainingManagerOf(userContext).onNewInstanceCreated(userContext, (EmployeeCompanyTraining)companyTraining.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);



		checkerOf(userContext).throwExceptionIfHasErrors(CompanyTrainingManagerException.class);

	}

	public  CompanyTraining updateEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployeeCompanyTraining(userContext, companyTrainingId, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeCompanyTrainingList().searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, tokens().equals(), employeeCompanyTrainingId).done();



		CompanyTraining companyTraining = loadCompanyTraining(userContext, companyTrainingId, loadTokens);

		synchronized(companyTraining){
			//Will be good when the companyTraining loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//companyTraining.removeEmployeeCompanyTraining( employeeCompanyTraining );
			//make changes to AcceleraterAccount.
			EmployeeCompanyTraining employeeCompanyTrainingIdVersionKey = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);

			EmployeeCompanyTraining employeeCompanyTraining = companyTraining.findTheEmployeeCompanyTraining(employeeCompanyTrainingIdVersionKey);
			if(employeeCompanyTraining == null){
				throw new CompanyTrainingManagerException(employeeCompanyTrainingId+" is NOT FOUND" );
			}

			beforeUpdateEmployeeCompanyTraining(userContext, employeeCompanyTraining, companyTrainingId, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr,  tokensExpr);
			employeeCompanyTraining.changeProperty(property, newValueExpr);
			
			companyTraining = saveCompanyTraining(userContext, companyTraining, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,companyTraining, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateEmployeeCompanyTraining(RetailscmUserContext userContext, EmployeeCompanyTraining existed, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, CompanyTraining newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    companyTrainingDaoOf(ctx).loadAllAsStream().forEach(
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
		//   CompanyTraining newCompanyTraining = this.createCompanyTraining(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newCompanyTraining
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, CompanyTraining.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<CompanyTraining> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> companyList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(companyList, RetailStoreCountryCenter.class);
		List<Instructor> instructorList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Instructor.class);
		userContext.getDAOGroup().enhanceList(instructorList, Instructor.class);
		List<TrainingCourseType> trainingCourseTypeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TrainingCourseType.class);
		userContext.getDAOGroup().enhanceList(trainingCourseTypeList, TrainingCourseType.class);


    }
	
	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception {
		return listPageByCompany(userContext, companyId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception {
		SmartList<CompanyTraining> list = companyTrainingDaoOf(userContext).findCompanyTrainingByCompany(companyId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(CompanyTraining.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("公司培训列表");
		page.setRequestName("listByCompany");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCompany/%s/",  getBeanName(), companyId)));

		page.assemblerContent(userContext, "listByCompany");
		return page.doRender(userContext);
	}
  
	public Object listByInstructor(RetailscmUserContext userContext,String instructorId) throws Exception {
		return listPageByInstructor(userContext, instructorId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByInstructor(RetailscmUserContext userContext,String instructorId, int start, int count) throws Exception {
		SmartList<CompanyTraining> list = companyTrainingDaoOf(userContext).findCompanyTrainingByInstructor(instructorId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(CompanyTraining.class);
		page.setContainerObject(Instructor.withId(instructorId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("公司培训列表");
		page.setRequestName("listByInstructor");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByInstructor/%s/",  getBeanName(), instructorId)));

		page.assemblerContent(userContext, "listByInstructor");
		return page.doRender(userContext);
	}
  
	public Object listByTrainingCourseType(RetailscmUserContext userContext,String trainingCourseTypeId) throws Exception {
		return listPageByTrainingCourseType(userContext, trainingCourseTypeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByTrainingCourseType(RetailscmUserContext userContext,String trainingCourseTypeId, int start, int count) throws Exception {
		SmartList<CompanyTraining> list = companyTrainingDaoOf(userContext).findCompanyTrainingByTrainingCourseType(trainingCourseTypeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(CompanyTraining.class);
		page.setContainerObject(TrainingCourseType.withId(trainingCourseTypeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("公司培训列表");
		page.setRequestName("listByTrainingCourseType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByTrainingCourseType/%s/",  getBeanName(), trainingCourseTypeId)));

		page.assemblerContent(userContext, "listByTrainingCourseType");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String companyTrainingId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getCompanyTrainingDetailScope().clone();
		CompanyTraining merchantObj = (CompanyTraining) this.view(userContext, companyTrainingId);
    String merchantObjId = companyTrainingId;
    String linkToUrl =	"companyTrainingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "公司培训"+"详情";
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
				MapUtil.put("id", "4-instructor")
				    .put("fieldName", "instructor")
				    .put("label", "讲师")
				    .put("type", "auto")
				    .put("linkToUrl", "instructorManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"family_name\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("instructor", merchantObj.getInstructor());

		propList.add(
				MapUtil.put("id", "5-trainingCourseType")
				    .put("fieldName", "trainingCourseType")
				    .put("label", "培训课程类型")
				    .put("type", "auto")
				    .put("linkToUrl", "trainingCourseTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("trainingCourseType", merchantObj.getTrainingCourseType());

		propList.add(
				MapUtil.put("id", "6-timeStart")
				    .put("fieldName", "timeStart")
				    .put("label", "时间开始")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("timeStart", merchantObj.getTimeStart());

		propList.add(
				MapUtil.put("id", "7-durationHours")
				    .put("fieldName", "durationHours")
				    .put("label", "持续时间")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("durationHours", merchantObj.getDurationHours());

		propList.add(
				MapUtil.put("id", "8-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "更新于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：employeeCompanyTrainingListSection
		Map employeeCompanyTrainingListSection = ListofUtils.buildSection(
		    "employeeCompanyTrainingListSection",
		    "员工公司培训名单",
		    null,
		    "",
		    "__no_group",
		    "employeeCompanyTrainingManager/listByTraining/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeCompanyTrainingListSection);

		result.put("employeeCompanyTrainingListSection", ListofUtils.toShortList(merchantObj.getEmployeeCompanyTrainingList(), "employeeCompanyTraining"));
		vscope.field("employeeCompanyTrainingListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeCompanyTraining.class.getName(), null));

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


