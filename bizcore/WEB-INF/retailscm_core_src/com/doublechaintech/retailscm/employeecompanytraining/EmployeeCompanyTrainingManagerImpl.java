
package com.doublechaintech.retailscm.employeecompanytraining;

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

import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

import com.doublechaintech.retailscm.scoring.CandidateScoring;
import com.doublechaintech.retailscm.employee.CandidateEmployee;
import com.doublechaintech.retailscm.companytraining.CandidateCompanyTraining;







public class EmployeeCompanyTrainingManagerImpl extends CustomRetailscmCheckerManager implements EmployeeCompanyTrainingManager {
	
	private static final String SERVICE_TYPE = "EmployeeCompanyTraining";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws EmployeeCompanyTrainingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new EmployeeCompanyTrainingManagerException(message);

	}
	
	

 	protected EmployeeCompanyTraining saveEmployeeCompanyTraining(RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, String [] tokensExpr) throws Exception{	
 		//return getEmployeeCompanyTrainingDAO().save(employeeCompanyTraining, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens);
 	}
 	
 	protected EmployeeCompanyTraining saveEmployeeCompanyTrainingDetail(RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining) throws Exception{	

 		
 		return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, allTokens());
 	}
 	
 	public EmployeeCompanyTraining loadEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeCompanyTrainingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeCompanyTrainingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining( userContext, employeeCompanyTrainingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeCompanyTraining, tokens);
 	}
 	
 	
 	 public EmployeeCompanyTraining searchEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeCompanyTrainingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeCompanyTrainingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining( userContext, employeeCompanyTrainingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeCompanyTraining, tokens);
 	}
 	
 	

 	protected EmployeeCompanyTraining present(RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeCompanyTraining,tokens);
		
		
		EmployeeCompanyTraining  employeeCompanyTrainingToPresent = userContext.getDAOGroup().getEmployeeCompanyTrainingDAO().present(employeeCompanyTraining, tokens);
		
		List<BaseEntity> entityListToNaming = employeeCompanyTrainingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getEmployeeCompanyTrainingDAO().alias(entityListToNaming);
		
		return  employeeCompanyTrainingToPresent;
		
		
	}
 
 	
 	
 	public EmployeeCompanyTraining loadEmployeeCompanyTrainingDetail(RetailscmUserContext userContext, String employeeCompanyTrainingId) throws Exception{	
 		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining( userContext, employeeCompanyTrainingId, allTokens());
 		return present(userContext,employeeCompanyTraining, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String employeeCompanyTrainingId) throws Exception{	
 		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining( userContext, employeeCompanyTrainingId, viewTokens());
 		return present(userContext,employeeCompanyTraining, allTokens());
		
 	}
 	protected EmployeeCompanyTraining saveEmployeeCompanyTraining(RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getEmployeeCompanyTrainingDAO().save(employeeCompanyTraining, tokens);
 	}
 	protected EmployeeCompanyTraining loadEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeCompanyTrainingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().throwExceptionIfHasErrors( EmployeeCompanyTrainingManagerException.class);

 
 		return userContext.getDAOGroup().getEmployeeCompanyTrainingDAO().load(employeeCompanyTrainingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String, Object> tokens){
		super.addActions(userContext, employeeCompanyTraining, tokens);
		
		addAction(userContext, employeeCompanyTraining, tokens,"@create","createEmployeeCompanyTraining","createEmployeeCompanyTraining/","main","primary");
		addAction(userContext, employeeCompanyTraining, tokens,"@update","updateEmployeeCompanyTraining","updateEmployeeCompanyTraining/"+employeeCompanyTraining.getId()+"/","main","primary");
		addAction(userContext, employeeCompanyTraining, tokens,"@copy","cloneEmployeeCompanyTraining","cloneEmployeeCompanyTraining/"+employeeCompanyTraining.getId()+"/","main","primary");
		
		addAction(userContext, employeeCompanyTraining, tokens,"employee_company_training.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeCompanyTraining.getId()+"/","main","primary");
		addAction(userContext, employeeCompanyTraining, tokens,"employee_company_training.transfer_to_training","transferToAnotherTraining","transferToAnotherTraining/"+employeeCompanyTraining.getId()+"/","main","primary");
		addAction(userContext, employeeCompanyTraining, tokens,"employee_company_training.score","score","scoreActionForm/"+employeeCompanyTraining.getId()+"/","main","success");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeCompanyTraining createEmployeeCompanyTraining(RetailscmUserContext userContext,String employeeId, String trainingId) throws Exception
	{
		
		

		

	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);


		EmployeeCompanyTraining employeeCompanyTraining=createNewEmployeeCompanyTraining();	

			
		Employee employee = loadEmployee(userContext, employeeId,emptyOptions());
		employeeCompanyTraining.setEmployee(employee);
		
		
			
		CompanyTraining training = loadCompanyTraining(userContext, trainingId,emptyOptions());
		employeeCompanyTraining.setTraining(training);
		
		
		employeeCompanyTraining.setCurrentStatus("INIT");

		employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());
		
		onNewInstanceCreated(userContext, employeeCompanyTraining);
		return employeeCompanyTraining;

		
	}
	protected EmployeeCompanyTraining createNewEmployeeCompanyTraining() 
	{
		
		return new EmployeeCompanyTraining();		
	}
	
	protected void checkParamsForUpdatingEmployeeCompanyTraining(RetailscmUserContext userContext,String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().checkVersionOfEmployeeCompanyTraining( employeeCompanyTrainingVersion);
		
		

				

		
	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);
	
		
	}
	
	
	
	public EmployeeCompanyTraining clone(RetailscmUserContext userContext, String fromEmployeeCompanyTrainingId) throws Exception{
		
		return userContext.getDAOGroup().getEmployeeCompanyTrainingDAO().clone(fromEmployeeCompanyTrainingId, this.allTokens());
	}
	
	public EmployeeCompanyTraining internalSaveEmployeeCompanyTraining(RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining) throws Exception 
	{
		return internalSaveEmployeeCompanyTraining(userContext, employeeCompanyTraining, allTokens());

	}
	public EmployeeCompanyTraining internalSaveEmployeeCompanyTraining(RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(employeeCompanyTraining){ 
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeCompanyTraining.
			
			
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, options);
			return employeeCompanyTraining;
			
		}

	}
	
	public EmployeeCompanyTraining updateEmployeeCompanyTraining(RetailscmUserContext userContext,String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr, tokensExpr);
		
		
		
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());
		if(employeeCompanyTraining.getVersion() != employeeCompanyTrainingVersion){
			String message = "The target version("+employeeCompanyTraining.getVersion()+") is not equals to version("+employeeCompanyTrainingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeCompanyTraining){ 
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeCompanyTraining.
			
			employeeCompanyTraining.changeProperty(property, newValueExpr);
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
			return present(userContext,employeeCompanyTraining, mergedAllTokens(tokensExpr));
			//return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
		}

	}
	
	public EmployeeCompanyTraining updateEmployeeCompanyTrainingProperty(RetailscmUserContext userContext,String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr, tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());
		if(employeeCompanyTraining.getVersion() != employeeCompanyTrainingVersion){
			String message = "The target version("+employeeCompanyTraining.getVersion()+") is not equals to version("+employeeCompanyTrainingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(employeeCompanyTraining){ 
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeCompanyTraining.
			
			employeeCompanyTraining.changeProperty(property, newValueExpr);
			
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
			return present(userContext,employeeCompanyTraining, mergedAllTokens(tokensExpr));
			//return saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeCompanyTrainingTokens tokens(){
		return EmployeeCompanyTrainingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeCompanyTrainingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeCompanyTrainingTokens.mergeAll(tokens).done();
	}
	
	private static final String [] STATUS_SEQUENCE={"SCORED"};
 	protected String[] getNextCandidateStatus(RetailscmUserContext userContext, String currentStatus) throws Exception{
 	
 		if("INIT".equals(currentStatus)){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE;
 		}
 		/*
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throwExceptionWithMessage("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		
 		//this is not the last one, just return it.
 		*/
 		return STATUS_SEQUENCE;
 	
 	}/**/
 	protected void ensureStatus(RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining, String expectedNextStatus) throws Exception{
		String currentStatus = employeeCompanyTraining.getCurrentStatus();
		//'null' is fine for function getNextStatus
		String candidateStatus[] = getNextCandidateStatus(userContext, currentStatus);
		
		if(candidateStatus == null){
			//no more next status
			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'HIDDEN'";
			throwExceptionWithMessage(message);
		}
		int index = Arrays.asList(candidateStatus).indexOf(expectedNextStatus);
		if(index<0){
			String message = "The current status '"+currentStatus+"' next candidate status should be one of '"+candidateStatus+"', but you want to transit the status to '"+expectedNextStatus+"'";
			throwExceptionWithMessage(message);
		}
	}
	
	protected void checkParamsForTransferingAnotherEmployee(RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherEmployeeId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
 		userContext.getChecker().checkIdOfEmployee(anotherEmployeeId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);
 		
 	}
 	public EmployeeCompanyTraining transferToAnotherEmployee(RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeCompanyTrainingId,anotherEmployeeId);
 
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());	
		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(userContext, anotherEmployeeId, emptyOptions());		
			employeeCompanyTraining.updateEmployee(employee);		
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());
			
			return present(userContext,employeeCompanyTraining, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateEmployee requestCandidateEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateEmployee result = new CandidateEmployee();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("company");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Employee> candidateList = userContext.getDAOGroup().getEmployeeDAO().requestCandidateEmployeeForEmployeeCompanyTraining(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherTraining(RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherTrainingId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
 		userContext.getChecker().checkIdOfCompanyTraining(anotherTrainingId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);
 		
 	}
 	public EmployeeCompanyTraining transferToAnotherTraining(RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherTrainingId) throws Exception
 	{
 		checkParamsForTransferingAnotherTraining(userContext, employeeCompanyTrainingId,anotherTrainingId);
 
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());	
		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			CompanyTraining training = loadCompanyTraining(userContext, anotherTrainingId, emptyOptions());		
			employeeCompanyTraining.updateTraining(training);		
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());
			
			return present(userContext,employeeCompanyTraining, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateCompanyTraining requestCandidateTraining(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCompanyTraining result = new CandidateCompanyTraining();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<CompanyTraining> candidateList = userContext.getDAOGroup().getCompanyTrainingDAO().requestCandidateCompanyTrainingForEmployeeCompanyTraining(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherScoring(RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherScoringId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
 		userContext.getChecker().checkIdOfScoring(anotherScoringId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);
 		
 	}
 	public EmployeeCompanyTraining transferToAnotherScoring(RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherScoringId) throws Exception
 	{
 		checkParamsForTransferingAnotherScoring(userContext, employeeCompanyTrainingId,anotherScoringId);
 
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());	
		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Scoring scoring = loadScoring(userContext, anotherScoringId, emptyOptions());		
			employeeCompanyTraining.updateScoring(scoring);		
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, emptyOptions());
			
			return present(userContext,employeeCompanyTraining, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateScoring requestCandidateScoring(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateScoring result = new CandidateScoring();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("scoredBy");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Scoring> candidateList = userContext.getDAOGroup().getScoringDAO().requestCandidateScoringForEmployeeCompanyTraining(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String SCORED_STATUS = "SCORED";
 	protected void checkParamsForScoring(RetailscmUserContext userContext, String employeeCompanyTrainingId, String scoredBy, int score, String comment
) throws Exception
 	{
 				userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().checkScoredByOfScoring(scoredBy);
		userContext.getChecker().checkScoreOfScoring(score);
		userContext.getChecker().checkCommentOfScoring(comment);

	
		userContext.getChecker().throwExceptionIfHasErrors(EmployeeCompanyTrainingManagerException.class);

 	}
 	public EmployeeCompanyTraining score(RetailscmUserContext userContext, String employeeCompanyTrainingId, String scoredBy, int score, String comment
) throws Exception
 	{
		checkParamsForScoring(userContext, employeeCompanyTrainingId, scoredBy, score, comment);
		EmployeeCompanyTraining employeeCompanyTraining = loadEmployeeCompanyTraining(userContext, employeeCompanyTrainingId, allTokens());	
		synchronized(employeeCompanyTraining){
			//will be good when the employeeCompanyTraining loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForScoring(userContext,employeeCompanyTraining);
 		

			employeeCompanyTraining.updateCurrentStatus(SCORED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			Scoring scoring = createScoring(userContext, scoredBy, score, comment);		
			employeeCompanyTraining.updateScoring(scoring);		
			
			
			employeeCompanyTraining = saveEmployeeCompanyTraining(userContext, employeeCompanyTraining, tokens().withScoring().done());
			return present(userContext,employeeCompanyTraining, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public EmployeeCompanyTrainingForm scoreActionForm(RetailscmUserContext userContext, String employeeCompanyTrainingId) throws Exception
 	{
		return new EmployeeCompanyTrainingForm()
			.withTitle("score")
			.employeeCompanyTrainingIdField(employeeCompanyTrainingId)
			.scoredByFieldOfScoring()
			.scoreFieldOfScoring()
			.commentFieldOfScoring()
			.scoreAction();
 	}
	
 	
 	protected Scoring createScoring(RetailscmUserContext userContext, String scoredBy, int score, String comment){
 		Scoring scoring = new Scoring();
 		//scoredBy, score, comment
 		
		scoring.setScoredBy(scoredBy);
		scoring.setScore(score);
		scoring.setComment(comment);

 		
 		
 		
 		return userContext.getDAOGroup().getScoringDAO().save(scoring,emptyOptions());
 	}
 	protected void checkIfEligibleForScoring(RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining) throws Exception{
 
 		ensureStatus(userContext,employeeCompanyTraining, SCORED_STATUS);
 		
 		Scoring scoring = employeeCompanyTraining.getScoring();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = scoring 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( scoring != null){
				throwExceptionWithMessage("The EmployeeCompanyTraining("+employeeCompanyTraining.getId()+") has already been "+ SCORED_STATUS+".");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected CompanyTraining loadCompanyTraining(RetailscmUserContext userContext, String newTrainingId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getCompanyTrainingDAO().load(newTrainingId, options);
 	}
 	
 	
 	
	
	 	
 	protected Scoring loadScoring(RetailscmUserContext userContext, String newScoringId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getScoringDAO().load(newScoringId, options);
 	}
 	
 	
 	
	
	 	
 	protected Employee loadEmployee(RetailscmUserContext userContext, String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getEmployeeDAO().load(newEmployeeId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion) throws Exception {
		//deleteInternal(userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String employeeCompanyTrainingId, int employeeCompanyTrainingVersion) throws Exception{
			
		userContext.getDAOGroup().getEmployeeCompanyTrainingDAO().delete(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
	}
	
	public EmployeeCompanyTraining forgetByAll(RetailscmUserContext userContext, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion) throws Exception {
		return forgetByAllInternal(userContext, employeeCompanyTrainingId, employeeCompanyTrainingVersion);		
	}
	protected EmployeeCompanyTraining forgetByAllInternal(RetailscmUserContext userContext,
			String employeeCompanyTrainingId, int employeeCompanyTrainingVersion) throws Exception{
			
		return userContext.getDAOGroup().getEmployeeCompanyTrainingDAO().disconnectFromAll(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeCompanyTrainingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getEmployeeCompanyTrainingDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeCompanyTraining newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


