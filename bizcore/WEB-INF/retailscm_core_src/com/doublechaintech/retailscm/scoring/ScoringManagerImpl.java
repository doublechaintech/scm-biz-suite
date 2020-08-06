
package com.doublechaintech.retailscm.scoring;

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



import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;


import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;






public class ScoringManagerImpl extends CustomRetailscmCheckerManager implements ScoringManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = ScoringTokens.start().withTokenFromListName(listName).done();
		Scoring  scoring = (Scoring) this.loadScoring(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = scoring.collectRefercencesFromLists();
		scoringDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, scoring, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new ScoringGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "Scoring";
	@Override
	public ScoringDAO daoOf(RetailscmUserContext userContext) {
		return scoringDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfScoring(scoringId);
		checkerOf(userContext).throwExceptionIfHasErrors( ScoringManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Scoring scoring = loadScoring( userContext, scoringId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,scoring, tokens);
 	}
 	
 	
 	 public Scoring searchScoring(RetailscmUserContext userContext, String scoringId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfScoring(scoringId);
		checkerOf(userContext).throwExceptionIfHasErrors( ScoringManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		Scoring scoring = loadScoring( userContext, scoringId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,scoring, tokens);
 	}
 	
 	

 	protected Scoring present(RetailscmUserContext userContext, Scoring scoring, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,scoring,tokens);
		
		
		Scoring  scoringToPresent = scoringDaoOf(userContext).present(scoring, tokens);
		
		List<BaseEntity> entityListToNaming = scoringToPresent.collectRefercencesFromLists();
		scoringDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,scoring,tokens);
		
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
 		return scoringDaoOf(userContext).save(scoring, tokens);
 	}
 	protected Scoring loadScoring(RetailscmUserContext userContext, String scoringId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfScoring(scoringId);
		checkerOf(userContext).throwExceptionIfHasErrors( ScoringManagerException.class);

 
 		return scoringDaoOf(userContext).load(scoringId, tokens);
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
	
 	
 	
 
 	
 	

	public Scoring createScoring(RetailscmUserContext userContext, String scoredBy,int score,String comment) throws Exception
	//public Scoring createScoring(RetailscmUserContext userContext,String scoredBy, int score, String comment) throws Exception
	{

		

		

		checkerOf(userContext).checkScoredByOfScoring(scoredBy);
		checkerOf(userContext).checkScoreOfScoring(score);
		checkerOf(userContext).checkCommentOfScoring(comment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfScoring(scoringId);
		checkerOf(userContext).checkVersionOfScoring( scoringVersion);
		

		if(Scoring.SCORED_BY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkScoredByOfScoring(parseString(newValueExpr));
		
			
		}
		if(Scoring.SCORE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkScoreOfScoring(parseInt(newValueExpr));
		
			
		}
		if(Scoring.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfScoring(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);


	}



	public Scoring clone(RetailscmUserContext userContext, String fromScoringId) throws Exception{

		return scoringDaoOf(userContext).clone(fromScoringId, this.allTokens());
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
			if (scoring.isChanged()){
			
			}
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
		.analyzeAllLists().done();

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

		scoringDaoOf(userContext).delete(scoringId, scoringVersion);
	}

	public Scoring forgetByAll(RetailscmUserContext userContext, String scoringId, int scoringVersion) throws Exception {
		return forgetByAllInternal(userContext, scoringId, scoringVersion);
	}
	protected Scoring forgetByAllInternal(RetailscmUserContext userContext,
			String scoringId, int scoringVersion) throws Exception{

		return scoringDaoOf(userContext).disconnectFromAll(scoringId, scoringVersion);
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
		return scoringDaoOf(userContext).deleteAll();
	}


	//disconnect Scoring with employee in EmployeeCompanyTraining
	protected Scoring breakWithEmployeeCompanyTrainingByEmployee(RetailscmUserContext userContext, String scoringId, String employeeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Scoring scoring = loadScoring(userContext, scoringId, allTokens());

			synchronized(scoring){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				scoringDaoOf(userContext).planToRemoveEmployeeCompanyTrainingListWithEmployee(scoring, employeeId, this.emptyOptions());

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

				scoringDaoOf(userContext).planToRemoveEmployeeCompanyTrainingListWithTraining(scoring, trainingId, this.emptyOptions());

				scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
				return scoring;
			}
	}






	protected void checkParamsForAddingEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, String employeeId, String trainingId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfScoring(scoringId);

		
		checkerOf(userContext).checkEmployeeIdOfEmployeeCompanyTraining(employeeId);
		
		checkerOf(userContext).checkTrainingIdOfEmployeeCompanyTraining(trainingId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);


	}
	public  Scoring addEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, String employeeId, String trainingId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeCompanyTraining(userContext,scoringId,employeeId, trainingId,tokensExpr);

		EmployeeCompanyTraining employeeCompanyTraining = createEmployeeCompanyTraining(userContext,employeeId, trainingId);

		Scoring scoring = loadScoring(userContext, scoringId, emptyOptions());
		synchronized(scoring){
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			scoring.addEmployeeCompanyTraining( employeeCompanyTraining );
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			
			employeeCompanyTrainingManagerOf(userContext).onNewInstanceCreated(userContext, employeeCompanyTraining);
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeCompanyTrainingProperties(RetailscmUserContext userContext, String scoringId,String id,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfScoring(scoringId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(id);


		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

	}
	public  Scoring updateEmployeeCompanyTrainingProperties(RetailscmUserContext userContext, String scoringId, String id, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeCompanyTrainingProperties(userContext,scoringId,id,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeCompanyTrainingListList()
				.searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, tokens().is(), id).done();

		Scoring scoringToUpdate = loadScoring(userContext, scoringId, options);

		if(scoringToUpdate.getEmployeeCompanyTrainingList().isEmpty()){
			throw new ScoringManagerException("EmployeeCompanyTraining is NOT FOUND with id: '"+id+"'");
		}

		EmployeeCompanyTraining item = scoringToUpdate.getEmployeeCompanyTrainingList().first();
		beforeUpdateEmployeeCompanyTrainingProperties(userContext,item, scoringId,id,tokensExpr);


		//checkParamsForAddingEmployeeCompanyTraining(userContext,scoringId,name, code, used,tokensExpr);
		Scoring scoring = saveScoring(userContext, scoringToUpdate, tokens().withEmployeeCompanyTrainingList().done());
		synchronized(scoring){
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateEmployeeCompanyTrainingProperties(RetailscmUserContext userContext, EmployeeCompanyTraining item, String scoringId, String id, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected EmployeeCompanyTraining createEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, String trainingId) throws Exception{

		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeCompanyTraining.setEmployee(employee);		
		CompanyTraining  training = new CompanyTraining();
		training.setId(trainingId);		
		employeeCompanyTraining.setTraining(training);
	
		
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

		checkerOf(userContext).checkIdOfScoring(scoringId);
		for(String employeeCompanyTrainingIdItem: employeeCompanyTrainingIds){
			checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

	}
	public  Scoring removeEmployeeCompanyTrainingList(RetailscmUserContext userContext, String scoringId,
			String employeeCompanyTrainingIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeCompanyTrainingList(userContext, scoringId,  employeeCompanyTrainingIds, tokensExpr);


			Scoring scoring = loadScoring(userContext, scoringId, allTokens());
			synchronized(scoring){
				//Will be good when the scoring loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				scoringDaoOf(userContext).planToRemoveEmployeeCompanyTrainingList(scoring, employeeCompanyTrainingIds, allTokens());
				scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
				deleteRelationListInGraph(userContext, scoring.getEmployeeCompanyTrainingList());
				return present(userContext,scoring, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId,
		String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfScoring( scoringId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

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
		
		checkerOf(userContext).checkIdOfScoring( scoringId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

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
			
			employeeCompanyTrainingManagerOf(userContext).onNewInstanceCreated(userContext, (EmployeeCompanyTraining)scoring.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfScoring(scoringId);
		checkerOf(userContext).checkIdOfEmployeeCompanyTraining(employeeCompanyTrainingId);
		checkerOf(userContext).checkVersionOfEmployeeCompanyTraining(employeeCompanyTrainingVersion);



		checkerOf(userContext).throwExceptionIfHasErrors(ScoringManagerException.class);

	}

	public  Scoring updateEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployeeCompanyTraining(userContext, scoringId, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeCompanyTrainingList().searchEmployeeCompanyTrainingListWith(EmployeeCompanyTraining.ID_PROPERTY, tokens().equals(), employeeCompanyTrainingId).done();



		Scoring scoring = loadScoring(userContext, scoringId, loadTokens);

		synchronized(scoring){
			//Will be good when the scoring loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//scoring.removeEmployeeCompanyTraining( employeeCompanyTraining );
			//make changes to AcceleraterAccount.
			EmployeeCompanyTraining employeeCompanyTrainingIdVersionKey = createIndexedEmployeeCompanyTraining(employeeCompanyTrainingId, employeeCompanyTrainingVersion);

			EmployeeCompanyTraining employeeCompanyTraining = scoring.findTheEmployeeCompanyTraining(employeeCompanyTrainingIdVersionKey);
			if(employeeCompanyTraining == null){
				throw new ScoringManagerException(employeeCompanyTrainingId+" is NOT FOUND" );
			}

			beforeUpdateEmployeeCompanyTraining(userContext, employeeCompanyTraining, scoringId, employeeCompanyTrainingId, employeeCompanyTrainingVersion, property, newValueExpr,  tokensExpr);
			employeeCompanyTraining.changeProperty(property, newValueExpr);
			
			scoring = saveScoring(userContext, scoring, tokens().withEmployeeCompanyTrainingList().done());
			return present(userContext,scoring, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateEmployeeCompanyTraining(RetailscmUserContext userContext, EmployeeCompanyTraining existed, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, Scoring newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    scoringDaoOf(ctx).loadAllAsStream().forEach(
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

    if (methodName.equals("ensureModelInDB")){
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
		//   Scoring newScoring = this.createScoring(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newScoring
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Scoring.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<Scoring> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String scoringId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getScoringDetailScope().clone();
		Scoring merchantObj = (Scoring) this.view(userContext, scoringId);
    String merchantObjId = scoringId;
    String linkToUrl =	"scoringManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "评分"+"详情";
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
				MapUtil.put("id", "2-scoredBy")
				    .put("fieldName", "scoredBy")
				    .put("label", "由谁打分")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("scoredBy", merchantObj.getScoredBy());

		propList.add(
				MapUtil.put("id", "3-score")
				    .put("fieldName", "score")
				    .put("label", "分数")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("score", merchantObj.getScore());

		propList.add(
				MapUtil.put("id", "4-comment")
				    .put("fieldName", "comment")
				    .put("label", "评论")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("comment", merchantObj.getComment());

		//处理 sectionList

		//处理Section：employeeCompanyTrainingListSection
		Map employeeCompanyTrainingListSection = ListofUtils.buildSection(
		    "employeeCompanyTrainingListSection",
		    "员工公司培训名单",
		    null,
		    "",
		    "__no_group",
		    "employeeCompanyTrainingManager/listByScoring/"+merchantObjId+"/",
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


