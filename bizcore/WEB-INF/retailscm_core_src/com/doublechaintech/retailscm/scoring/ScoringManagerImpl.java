
package com.doublechaintech.retailscm.scoring;

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

import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;


import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;






public class ScoringManagerImpl extends CustomRetailscmCheckerManager implements ScoringManager {
	
	private static final String SERVICE_TYPE = "Scoring";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ScoringManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ScoringManagerException(message);

	}
	
	

 	protected Scoring saveScoring(RetailscmUserContext userContext, Scoring scoring, String [] tokensExpr) throws Exception{	
 		//return getScoringDAO().save(scoring, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveScoring(userContext, scoring, tokens);
 	}
 	
 	protected Scoring saveScoringDetail(RetailscmUserContext userContext, Scoring scoring) throws Exception{	

 		
 		return saveScoring(userContext, scoring, allTokens());
 	}
 	
 	public Scoring loadScoring(RetailscmUserContext userContext, String scoringId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfScoring(scoringId);
		userContext.getChecker().throwExceptionIfHasErrors( ScoringManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Scoring scoring = loadScoring( userContext, scoringId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,scoring, tokens);
 	}
 	
 	
 	 public Scoring searchScoring(RetailscmUserContext userContext, String scoringId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfScoring(scoringId);
		userContext.getChecker().throwExceptionIfHasErrors( ScoringManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Scoring scoring = loadScoring( userContext, scoringId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,scoring, tokens);
 	}
 	
 	

 	protected Scoring present(RetailscmUserContext userContext, Scoring scoring, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,scoring,tokens);
		
		
		Scoring  scoringToPresent = userContext.getDAOGroup().getScoringDAO().present(scoring, tokens);
		
		List<BaseEntity> entityListToNaming = scoringToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getScoringDAO().alias(entityListToNaming);
		
		return  scoringToPresent;
		
		
	}
 
 	
 	
 	public Scoring loadScoringDetail(RetailscmUserContext userContext, String scoringId) throws Exception{	
 		Scoring scoring = loadScoring( userContext, scoringId, allTokens());
 		return present(userContext,scoring, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String scoringId) throws Exception{	
 		Scoring scoring = loadScoring( userContext, scoringId, viewTokens());
 		return present(userContext,scoring, allTokens());
		
 	}
 	protected Scoring saveScoring(RetailscmUserContext userContext, Scoring scoring, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getScoringDAO().save(scoring, tokens);
 	}
 	protected Scoring loadScoring(RetailscmUserContext userContext, String scoringId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfScoring(scoringId);
		userContext.getChecker().throwExceptionIfHasErrors( ScoringManagerException.class);

 
 		return userContext.getDAOGroup().getScoringDAO().load(scoringId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Scoring scoring, Map<String, Object> tokens){
		super.addActions(userContext, scoring, tokens);
		
		addAction(userContext, scoring, tokens,"@create","createScoring","createScoring/","main","primary");
		addAction(userContext, scoring, tokens,"@update","updateScoring","updateScoring/"+scoring.getId()+"/","main","primary");
		addAction(userContext, scoring, tokens,"@copy","cloneScoring","cloneScoring/"+scoring.getId()+"/","main","primary");
		
		addAction(userContext, scoring, tokens,"scoring.addEmployeeCompanyTraining","addEmployeeCompanyTraining","addEmployeeCompanyTraining/"+scoring.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, scoring, tokens,"scoring.removeEmployeeCompanyTraining","removeEmployeeCompanyTraining","removeEmployeeCompanyTraining/"+scoring.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, scoring, tokens,"scoring.updateEmployeeCompanyTraining","updateEmployeeCompanyTraining","updateEmployeeCompanyTraining/"+scoring.getId()+"/","employeeCompanyTrainingList","primary");
		addAction(userContext, scoring, tokens,"scoring.copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom","copyEmployeeCompanyTrainingFrom/"+scoring.getId()+"/","employeeCompanyTrainingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Scoring scoring, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Scoring createScoring(RetailscmUserContext userContext,String scoredBy, int score, String comment) throws Exception
	{
		
		

		

		userContext.getChecker().checkScoredByOfScoring(scoredBy);
		userContext.getChecker().checkScoreOfScoring(score);
		userContext.getChecker().checkCommentOfScoring(comment);
	
		userContext.getChecker().throwExceptionIfHasErrors(ScoringManagerException.class);


		Scoring scoring=createNewScoring();	

		scoring.setScoredBy(scoredBy);
		scoring.setScore(score);
		scoring.setComment(comment);

		scoring = saveScoring(userContext, scoring, emptyOptions());
		
		onNewInstanceCreated(userContext, scoring);
		return scoring;

		
	}
	protected Scoring createNewScoring() 
	{
		
		return new Scoring();		
	}
	
	protected void checkParamsForUpdatingScoring(RetailscmUserContext userContext,String scoringId, int scoringVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfScoring(scoringId);
		userContext.getChecker().checkVersionOfScoring( scoringVersion);
		

		if(Scoring.SCORED_BY_PROPERTY.equals(property)){
			userContext.getChecker().checkScoredByOfScoring(parseString(newValueExpr));
		}
		if(Scoring.SCORE_PROPERTY.equals(property)){
			userContext.getChecker().checkScoreOfScoring(parseInt(newValueExpr));
		}
		if(Scoring.COMMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentOfScoring(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ScoringManagerException.class);
	
		
	}
	
	
	
	public Scoring clone(RetailscmUserContext userContext, String fromScoringId) throws Exception{
		
		return userContext.getDAOGroup().getScoringDAO().clone(fromScoringId, this.allTokens());
	}
	
	public Scoring internalSaveScoring(RetailscmUserContext userContext, Scoring scoring) throws Exception 
	{
		return internalSaveScoring(userContext, scoring, allTokens());

	}
	public Scoring internalSaveScoring(RetailscmUserContext userContext, Scoring scoring, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingScoring(userContext, scoringId, scoringVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(scoring){ 
			//will be good when the scoring loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Scoring.
			
			
			scoring = saveScoring(userContext, scoring, options);
			return scoring;
			
		}

	}
	
	public Scoring updateScoring(RetailscmUserContext userContext,String scoringId, int scoringVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingScoring(userContext, scoringId, scoringVersion, property, newValueExpr, tokensExpr);
		
		
		
		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		if(scoring.getVersion() != scoringVersion){
			String message = "The target version("+scoring.getVersion()+") is not equals to version("+scoringVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(scoring){ 
			//will be good when the scoring loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Scoring.
			
			scoring.changeProperty(property, newValueExpr);
			scoring = saveScoring(userContext, scoring, tokens().done());
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
			//return saveScoring(userContext, scoring, tokens().done());
		}

	}
	
	public Scoring updateScoringProperty(RetailscmUserContext userContext,String scoringId, int scoringVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingScoring(userContext, scoringId, scoringVersion, property, newValueExpr, tokensExpr);
		
		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		if(scoring.getVersion() != scoringVersion){
			String message = "The target version("+scoring.getVersion()+") is not equals to version("+scoringVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(scoring){ 
			//will be good when the scoring loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Scoring.
			
			scoring.changeProperty(property, newValueExpr);
			
			scoring = saveScoring(userContext, scoring, tokens().done());
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
			//return saveScoring(userContext, scoring, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ScoringTokens tokens(){
		return ScoringTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ScoringTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeCompanyTrainingListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ScoringTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String scoringId, int scoringVersion) throws Exception {
		//deleteInternal(userContext, scoringId, scoringVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String scoringId, int scoringVersion) throws Exception{
			
		userContext.getDAOGroup().getScoringDAO().delete(scoringId, scoringVersion);
	}
	
	public Scoring forgetByAll(RetailscmUserContext userContext, String scoringId, int scoringVersion) throws Exception {
		return forgetByAllInternal(userContext, scoringId, scoringVersion);		
	}
	protected Scoring forgetByAllInternal(RetailscmUserContext userContext,
			String scoringId, int scoringVersion) throws Exception{
			
		return userContext.getDAOGroup().getScoringDAO().disconnectFromAll(scoringId, scoringVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ScoringManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getScoringDAO().deleteAll();
	}


	//disconnect Scoring with employee in EmployeeCompanyTraining
	protected Scoring breakWithEmployeeCompanyTrainingByEmployee(RetailscmUserContext userContext, String scoringId, String employeeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Scoring scoring = loadScoring(userContext, scoringId, allTokens());

			synchronized(scoring){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getScoringDAO().planToRemoveEmployeeCompanyTrainingListWithEmployee(scoring, employeeId, this.emptyOptions());

				scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
				return scoring;
			}
	}
	//disconnect Scoring with training in EmployeeCompanyTraining
	protected Scoring breakWithEmployeeCompanyTrainingByTraining(RetailscmUserContext userContext, String scoringId, String trainingId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Scoring scoring = loadScoring(userContext, scoringId, allTokens());

			synchronized(scoring){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getScoringDAO().planToRemoveEmployeeCompanyTrainingListWithTraining(scoring, trainingId, this.emptyOptions());

				scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
				return scoring;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, String employeeId, String trainingId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfScoring(scoringId);

		
		userContext.getChecker().checkEmployeeIdOfEmployeeCompanyTraining(employeeId);
		
		userContext.getChecker().checkTrainingIdOfEmployeeCompanyTraining(trainingId);
	
		userContext.getChecker().throwExceptionIfHasErrors(ScoringManagerException.class);

	
	}
	public  Scoring addEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, String employeeId, String trainingId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeCompanyTraining(userContext,scoringId,employeeId, trainingId,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createEmployeeCompanyTraining(userContext,employeeId, trainingId);
		
		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		synchronized(scoring){ 
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			scoring.addEmployeeCompanyTraining( employeeCompanyTraining );		
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			
			userContext.getManagerGroup().getEmployeeCompanyTrainingManager().onNewInstanceCreated(userContext, employeeCompanyTraining);
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeCompanyTrainingProperties(RetailscmUserContext userContext, String scoringId,String id,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfScoring(scoringId);
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(id);
		

		userContext.getChecker().throwExceptionIfHasErrors(ScoringManagerException.class);
		
	}
	public  Scoring updateEmployeeCompanyTrainingProperties(RetailscmUserContext userContext, String scoringId, String id, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeCompanyTrainingProperties(userContext,scoringId,id,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeCompanyTrainingListList()
				.searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, "is", id).done();
		
		Scoring scoringToUpdate = loadScoring(userContext, scoringId, options);
		
		if(scoringToUpdate.getEmployeeCompanyTrainingList().isEmpty()){
			throw new ScoringManagerException("EmployeeCompanyTraining is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeCompanyTraining item = scoringToUpdate.getEmployeeCompanyTrainingList().first();
		

		
		//checkParamsForAddingEmployeeCompanyTraining(userContext,scoringId,name, code, used,tokensExpr);
		Scoring scoring = saveScoring(userContext, scoringToUpdate, tokens().withEmployeeCompanyTrainingList().done());
		synchronized(scoring){ 
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeCompanyTraining createEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, String trainingId) throws Exception{

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeCompanyTraining.setEmployee(employee);		
		CompanyTraining  training = new CompanyTraining();
		training.setId(trainingId);		
		employeeCompanyTraining.setTraining(training);		
		employeeCompanyTraining.setCurrentStatus("INIT");
	
		
		return employeeCompanyTraining;
	
		
	}
	
	protected EmployeeCompanyTraining createIndexedEmployeeCompanyTraining(String id, int version){

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		employeeCompanyTraining.setId(id);
		employeeCompanyTraining.setVersion(version);
		return employeeCompanyTraining;			
		
	}
	
	protected void checkParamsForRemovingEmployeeCompanyTrainingList(RetailscmUserContext userContext, String scoringId, 
			String employeeCompanyTrainingIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfScoring(scoringId);
		for(String employeeCompanyTrainingId: employeeCompanyTrainingIds){
			userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(ScoringManagerException.class);
		
	}
	public  Scoring removeEmployeeCompanyTrainingList(RetailscmUserContext userContext, String scoringId, 
			String employeeCompanyTrainingIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeCompanyTrainingList(userContext, scoringId,  employeeCompanyTrainingIds, tokensExpr);
			
			
			Scoring scoring = loadScoring(userContext, scoringId, allTokens());
			synchronized(scoring){ 
				//Will be good when the scoring loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getScoringDAO().planToRemoveEmployeeCompanyTrainingList(scoring, employeeCompanyTrainingIds, allTokens());
				scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
				deleteRelationListInGraph(userContext, scoring.getEmployeeCompanyTrainingList());
				return present(userContext,scoring, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfScoring( scoringId);
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ScoringManagerException.class);
	
	}
	public  Scoring removeEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeCompanyTraining(userContext,scoringId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		synchronized(scoring){ 
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			scoring.removeEmployeeCompanyTraining( employeeCompanyTraining );		
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			deleteRelationInGraph(userContext, employeeCompanyTraining);
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfScoring( scoringId);
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		userContext.getChecker().throwExceptionIfHasErrors(ScoringManagerException.class);
	
	}
	public  Scoring copyEmployeeCompanyTrainingFrom(RetailscmUserContext userContext, String scoringId, 
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeCompanyTraining(userContext,scoringId, employeeCompanyTrainingId, employeeCompanyTrainingVersion,tokensExpr);
		
		EmployeeCompanyTraining employeeCompanyTraining = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		Scoring scoring = loadScoring(userContext, scoringId, allTokens());
		synchronized(scoring){ 
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			scoring.copyEmployeeCompanyTrainingFrom( employeeCompanyTraining );		
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			
			userContext.getManagerGroup().getEmployeeCompanyTrainingManager().onNewInstanceCreated(userContext, (EmployeeCompanyTraining)scoring.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfScoring(scoringId);
		userContext.getChecker().checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		userContext.getChecker().checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		

	
		userContext.getChecker().throwExceptionIfHasErrors(ScoringManagerException.class);
	
	}
	
	public  Scoring updateEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeCompanyTraining(userContext, scoringId, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeCompanyTrainingList().searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, "eq", employeeCompanyTrainingId).done();
		
		
		
		Scoring scoring = loadScoring(userContext, scoringId, loadTokens);
		
		synchronized(scoring){ 
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//scoring.removeEmployeeCompanyTraining( employeeCompanyTraining );	
			//make changes to AcceleraterAccount.
			EmployeeCompanyTraining employeeCompanyTrainingIndex = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);
		
			EmployeeCompanyTraining employeeCompanyTraining = scoring.findTheEmployeeCompanyTraining(employeeCompanyTrainingIndex);
			if(employeeCompanyTraining == null){
				throw new ScoringManagerException(employeeCompanyTraining+" is NOT FOUND" );
			}
			
			employeeCompanyTraining.changeProperty(property, newValueExpr);
			
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, Scoring newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


