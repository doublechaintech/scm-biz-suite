
package com.doublechaintech.retailscm.trainingcoursetype;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.companytraining.CompanyTraining;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.instructor.Instructor;import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


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



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,trainingCourseType, tokens);
 	}



 	protected TrainingCourseType present(RetailscmUserContext userContext, TrainingCourseType trainingCourseType, Map<String, Object> tokens) throws Exception {


		addActions(userContext,trainingCourseType,tokens);
    

		TrainingCourseType  trainingCourseTypeToPresent = trainingCourseTypeDaoOf(userContext).present(trainingCourseType, tokens);

		List<BaseEntity> entityListToNaming = trainingCourseTypeToPresent.collectRefercencesFromLists();
		trainingCourseTypeDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,trainingCourseType,tokens);

		return  trainingCourseTypeToPresent;


	}



 	public TrainingCourseType loadTrainingCourseTypeDetail(RetailscmUserContext userContext, String trainingCourseTypeId) throws Exception{
 		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, allTokens());
 		return present(userContext,trainingCourseType, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String trainingCourseTypeId) throws Exception{
 		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, viewTokens());
 		markVisited(userContext, trainingCourseType);
 		return present(userContext,trainingCourseType, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String trainingCourseTypeId) throws Exception{
		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, viewTokens());
		trainingCourseType.summarySuffix();
		markVisited(userContext, trainingCourseType);
 		return present(userContext,trainingCourseType, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String trainingCourseTypeId) throws Exception{
		TrainingCourseType trainingCourseType = loadTrainingCourseType( userContext, trainingCourseTypeId, analyzeTokens());
		markVisited(userContext, trainingCourseType);
		return present(userContext,trainingCourseType, analyzeTokens());

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








  @Override
  public List<TrainingCourseType> searchTrainingCourseTypeList(RetailscmUserContext ctx, TrainingCourseTypeRequest pRequest){
      pRequest.setUserContext(ctx);
      List<TrainingCourseType> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public TrainingCourseType searchTrainingCourseType(RetailscmUserContext ctx, TrainingCourseTypeRequest pRequest){
    pRequest.limit(0, 1);
    List<TrainingCourseType> list = searchTrainingCourseTypeList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public TrainingCourseType createTrainingCourseType(RetailscmUserContext userContext, String code,String companyId,String name,String description) throws Exception
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

      //checkerOf(userContext).checkAndFixTrainingCourseType(trainingCourseType);
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
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortCompanyTrainingListWith(CompanyTraining.ID_PROPERTY,sortDesc())
		.done();

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
			
			companyTrainingManagerOf(userContext).onNewInstanceCreated(userContext, companyTraining);
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
				.searchCompanyTrainingListWith(CompanyTraining.ID_PROPERTY, tokens().is(), id).done();

		TrainingCourseType trainingCourseTypeToUpdate = loadTrainingCourseType(userContext, trainingCourseTypeId, options);

		if(trainingCourseTypeToUpdate.getCompanyTrainingList().isEmpty()){
			throw new TrainingCourseTypeManagerException("CompanyTraining is NOT FOUND with id: '"+id+"'");
		}

		CompanyTraining item = trainingCourseTypeToUpdate.getCompanyTrainingList().first();
		beforeUpdateCompanyTrainingProperties(userContext,item, trainingCourseTypeId,id,title,timeStart,durationHours,tokensExpr);
		item.updateTitle( title );
		item.updateTimeStart( timeStart );
		item.updateDurationHours( durationHours );


		//checkParamsForAddingCompanyTraining(userContext,trainingCourseTypeId,name, code, used,tokensExpr);
		TrainingCourseType trainingCourseType = saveTrainingCourseType(userContext, trainingCourseTypeToUpdate, tokens().withCompanyTrainingList().done());
		synchronized(trainingCourseType){
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateCompanyTrainingProperties(RetailscmUserContext userContext, CompanyTraining item, String trainingCourseTypeId, String id,String title,Date timeStart,int durationHours, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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
			
			companyTrainingManagerOf(userContext).onNewInstanceCreated(userContext, (CompanyTraining)trainingCourseType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
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

		Map<String,Object> loadTokens = this.tokens().withCompanyTrainingList().searchCompanyTrainingListWith(CompanyTraining.ID_PROPERTY, tokens().equals(), companyTrainingId).done();



		TrainingCourseType trainingCourseType = loadTrainingCourseType(userContext, trainingCourseTypeId, loadTokens);

		synchronized(trainingCourseType){
			//Will be good when the trainingCourseType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//trainingCourseType.removeCompanyTraining( companyTraining );
			//make changes to AcceleraterAccount.
			CompanyTraining companyTrainingIdVersionKey = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);

			CompanyTraining companyTraining = trainingCourseType.findTheCompanyTraining(companyTrainingIdVersionKey);
			if(companyTraining == null){
				throw new TrainingCourseTypeManagerException(companyTrainingId+" is NOT FOUND" );
			}

			beforeUpdateCompanyTraining(userContext, companyTraining, trainingCourseTypeId, companyTrainingId, companyTrainingVersion, property, newValueExpr,  tokensExpr);
			companyTraining.changeProperty(property, newValueExpr);
			companyTraining.updateLastUpdateTime(userContext.now());
			trainingCourseType = saveTrainingCourseType(userContext, trainingCourseType, tokens().withCompanyTrainingList().done());
			companyTrainingManagerOf(userContext).onUpdated(userContext, companyTraining, this, "updateCompanyTraining");
			return present(userContext,trainingCourseType, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateCompanyTraining(RetailscmUserContext userContext, CompanyTraining existed, String trainingCourseTypeId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, TrainingCourseType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    trainingCourseTypeDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
  }



	// -----------------------------------//  登录部分处理 \\-----------------------------------
	@Override
  protected BusinessHandler getLoginProcessBizHandler(RetailscmUserContextImpl userContext) {
    return this;
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
		// and in most case, this should be considered as "login success"
		//   loginResult.setSuccess(true);
		//
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	protected SmartList<UserApp> getRelatedUserAppList(RetailscmUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, TrainingCourseType.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
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
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
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
				    .put("label", "ID")
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




