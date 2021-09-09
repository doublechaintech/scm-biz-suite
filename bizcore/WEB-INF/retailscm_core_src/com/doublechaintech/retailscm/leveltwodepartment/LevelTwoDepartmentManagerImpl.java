
package com.doublechaintech.retailscm.leveltwodepartment;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.levelonedepartment.CandidateLevelOneDepartment;import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class LevelTwoDepartmentManagerImpl extends CustomRetailscmCheckerManager implements LevelTwoDepartmentManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = LevelTwoDepartmentTokens.start().withTokenFromListName(listName).done();
		LevelTwoDepartment  levelTwoDepartment = (LevelTwoDepartment) this.loadLevelTwoDepartment(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = levelTwoDepartment.collectRefercencesFromLists();
		levelTwoDepartmentDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, levelTwoDepartment, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new LevelTwoDepartmentGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "LevelTwoDepartment";
	@Override
	public LevelTwoDepartmentDAO daoOf(RetailscmUserContext userContext) {
		return levelTwoDepartmentDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws LevelTwoDepartmentManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new LevelTwoDepartmentManagerException(message);

	}



 	protected LevelTwoDepartment saveLevelTwoDepartment(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment, String [] tokensExpr) throws Exception{
 		//return getLevelTwoDepartmentDAO().save(levelTwoDepartment, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens);
 	}

 	protected LevelTwoDepartment saveLevelTwoDepartmentDetail(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment) throws Exception{


 		return saveLevelTwoDepartment(userContext, levelTwoDepartment, allTokens());
 	}

 	public LevelTwoDepartment loadLevelTwoDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentId);

		checkerOf(userContext).throwExceptionIfHasErrors( LevelTwoDepartmentManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelTwoDepartment, tokens);
 	}


 	 public LevelTwoDepartment searchLevelTwoDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentId);

		checkerOf(userContext).throwExceptionIfHasErrors( LevelTwoDepartmentManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelTwoDepartment, tokens);
 	}



 	protected LevelTwoDepartment present(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String, Object> tokens) throws Exception {


		addActions(userContext,levelTwoDepartment,tokens);
    

		LevelTwoDepartment  levelTwoDepartmentToPresent = levelTwoDepartmentDaoOf(userContext).present(levelTwoDepartment, tokens);

		List<BaseEntity> entityListToNaming = levelTwoDepartmentToPresent.collectRefercencesFromLists();
		levelTwoDepartmentDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,levelTwoDepartment,tokens);

		return  levelTwoDepartmentToPresent;


	}



 	public LevelTwoDepartment loadLevelTwoDepartmentDetail(RetailscmUserContext userContext, String levelTwoDepartmentId) throws Exception{
 		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, allTokens());
 		return present(userContext,levelTwoDepartment, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String levelTwoDepartmentId) throws Exception{
 		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, viewTokens());
 		markVisited(userContext, levelTwoDepartment);
 		return present(userContext,levelTwoDepartment, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String levelTwoDepartmentId) throws Exception{
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, viewTokens());
		levelTwoDepartment.summarySuffix();
		markVisited(userContext, levelTwoDepartment);
 		return present(userContext,levelTwoDepartment, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String levelTwoDepartmentId) throws Exception{
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment( userContext, levelTwoDepartmentId, analyzeTokens());
		markVisited(userContext, levelTwoDepartment);
		return present(userContext,levelTwoDepartment, analyzeTokens());

	}
 	protected LevelTwoDepartment saveLevelTwoDepartment(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String,Object>tokens) throws Exception{
 	
 		return levelTwoDepartmentDaoOf(userContext).save(levelTwoDepartment, tokens);
 	}
 	protected LevelTwoDepartment loadLevelTwoDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentId);

		checkerOf(userContext).throwExceptionIfHasErrors( LevelTwoDepartmentManagerException.class);



 		return levelTwoDepartmentDaoOf(userContext).load(levelTwoDepartmentId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String, Object> tokens){
		super.addActions(userContext, levelTwoDepartment, tokens);

		addAction(userContext, levelTwoDepartment, tokens,"@create","createLevelTwoDepartment","createLevelTwoDepartment/","main","primary");
		addAction(userContext, levelTwoDepartment, tokens,"@update","updateLevelTwoDepartment","updateLevelTwoDepartment/"+levelTwoDepartment.getId()+"/","main","primary");
		addAction(userContext, levelTwoDepartment, tokens,"@copy","cloneLevelTwoDepartment","cloneLevelTwoDepartment/"+levelTwoDepartment.getId()+"/","main","primary");

		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+levelTwoDepartment.getId()+"/","main","primary");
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.addLevelThreeDepartment","addLevelThreeDepartment","addLevelThreeDepartment/"+levelTwoDepartment.getId()+"/","levelThreeDepartmentList","primary");
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.removeLevelThreeDepartment","removeLevelThreeDepartment","removeLevelThreeDepartment/"+levelTwoDepartment.getId()+"/","levelThreeDepartmentList","primary");
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.updateLevelThreeDepartment","updateLevelThreeDepartment","updateLevelThreeDepartment/"+levelTwoDepartment.getId()+"/","levelThreeDepartmentList","primary");
		addAction(userContext, levelTwoDepartment, tokens,"level_two_department.copyLevelThreeDepartmentFrom","copyLevelThreeDepartmentFrom","copyLevelThreeDepartmentFrom/"+levelTwoDepartment.getId()+"/","levelThreeDepartmentList","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String, Object> tokens){








  @Override
  public List<LevelTwoDepartment> searchLevelTwoDepartmentList(RetailscmUserContext ctx, LevelTwoDepartmentRequest pRequest){
      pRequest.setUserContext(ctx);
      List<LevelTwoDepartment> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public LevelTwoDepartment searchLevelTwoDepartment(RetailscmUserContext ctx, LevelTwoDepartmentRequest pRequest){
    pRequest.limit(0, 1);
    List<LevelTwoDepartment> list = searchLevelTwoDepartmentList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public LevelTwoDepartment createLevelTwoDepartment(RetailscmUserContext userContext, String belongsToId,String name,String description,Date founded) throws Exception
	{





		checkerOf(userContext).checkNameOfLevelTwoDepartment(name);
		checkerOf(userContext).checkDescriptionOfLevelTwoDepartment(description);
		checkerOf(userContext).checkFoundedOfLevelTwoDepartment(founded);


		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);



		LevelTwoDepartment levelTwoDepartment=createNewLevelTwoDepartment();	

			
		LevelOneDepartment belongsTo = loadLevelOneDepartment(userContext, belongsToId,emptyOptions());
		levelTwoDepartment.setBelongsTo(belongsTo);
		
		
		levelTwoDepartment.setName(name);
		levelTwoDepartment.setDescription(description);
		levelTwoDepartment.setFounded(founded);

		levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, emptyOptions());
		
		onNewInstanceCreated(userContext, levelTwoDepartment);
		return levelTwoDepartment;


	}
	protected LevelTwoDepartment createNewLevelTwoDepartment()
	{

		return new LevelTwoDepartment();
	}

	protected void checkParamsForUpdatingLevelTwoDepartment(RetailscmUserContext userContext,String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		checkerOf(userContext).checkVersionOfLevelTwoDepartment( levelTwoDepartmentVersion);



		
		if(LevelTwoDepartment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfLevelTwoDepartment(parseString(newValueExpr));
		

		}
		if(LevelTwoDepartment.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfLevelTwoDepartment(parseString(newValueExpr));
		

		}
		if(LevelTwoDepartment.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfLevelTwoDepartment(parseDate(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);



	}



	public LevelTwoDepartment clone(RetailscmUserContext userContext, String fromLevelTwoDepartmentId) throws Exception{

		return levelTwoDepartmentDaoOf(userContext).clone(fromLevelTwoDepartmentId, this.allTokens());
	}

	public LevelTwoDepartment internalSaveLevelTwoDepartment(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment) throws Exception
	{
		return internalSaveLevelTwoDepartment(userContext, levelTwoDepartment, allTokens());

	}
	public LevelTwoDepartment internalSaveLevelTwoDepartment(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingLevelTwoDepartment(userContext, levelTwoDepartmentId, levelTwoDepartmentVersion, property, newValueExpr, tokensExpr);


		synchronized(levelTwoDepartment){
			//will be good when the levelTwoDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoDepartment.
			if (levelTwoDepartment.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixLevelTwoDepartment(levelTwoDepartment);
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, options);
			return levelTwoDepartment;

		}

	}

	public LevelTwoDepartment updateLevelTwoDepartment(RetailscmUserContext userContext,String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelTwoDepartment(userContext, levelTwoDepartmentId, levelTwoDepartmentVersion, property, newValueExpr, tokensExpr);



		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		if(levelTwoDepartment.getVersion() != levelTwoDepartmentVersion){
			String message = "The target version("+levelTwoDepartment.getVersion()+") is not equals to version("+levelTwoDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelTwoDepartment){
			//will be good when the levelTwoDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoDepartment.
			
			levelTwoDepartment.changeProperty(property, newValueExpr);
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().done());
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().done());
		}

	}

	public LevelTwoDepartment updateLevelTwoDepartmentProperty(RetailscmUserContext userContext,String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelTwoDepartment(userContext, levelTwoDepartmentId, levelTwoDepartmentVersion, property, newValueExpr, tokensExpr);

		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		if(levelTwoDepartment.getVersion() != levelTwoDepartmentVersion){
			String message = "The target version("+levelTwoDepartment.getVersion()+") is not equals to version("+levelTwoDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelTwoDepartment){
			//will be good when the levelTwoDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoDepartment.

			levelTwoDepartment.changeProperty(property, newValueExpr);
			
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().done());
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected LevelTwoDepartmentTokens tokens(){
		return LevelTwoDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelTwoDepartmentTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLevelThreeDepartmentListWith(LevelThreeDepartment.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelTwoDepartmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailscmUserContext userContext, String levelTwoDepartmentId, String anotherBelongsToId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
 		checkerOf(userContext).checkIdOfLevelOneDepartment(anotherBelongsToId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);

 	}
 	public LevelTwoDepartment transferToAnotherBelongsTo(RetailscmUserContext userContext, String levelTwoDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, levelTwoDepartmentId,anotherBelongsToId);
 
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		synchronized(levelTwoDepartment){
			//will be good when the levelTwoDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelOneDepartment belongsTo = loadLevelOneDepartment(userContext, anotherBelongsToId, emptyOptions());
			levelTwoDepartment.updateBelongsTo(belongsTo);
			
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, emptyOptions());

			return present(userContext,levelTwoDepartment, allTokens());

		}

 	}

	


	public CandidateLevelOneDepartment requestCandidateBelongsTo(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelOneDepartment result = new CandidateLevelOneDepartment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("belongsTo");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelOneDepartment> candidateList = levelOneDepartmentDaoOf(userContext).requestCandidateLevelOneDepartmentForLevelTwoDepartment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected LevelOneDepartment loadLevelOneDepartment(RetailscmUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{
    
 		return levelOneDepartmentDaoOf(userContext).load(newBelongsToId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String levelTwoDepartmentId, int levelTwoDepartmentVersion) throws Exception {
		//deleteInternal(userContext, levelTwoDepartmentId, levelTwoDepartmentVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String levelTwoDepartmentId, int levelTwoDepartmentVersion) throws Exception{

		levelTwoDepartmentDaoOf(userContext).delete(levelTwoDepartmentId, levelTwoDepartmentVersion);
	}

	public LevelTwoDepartment forgetByAll(RetailscmUserContext userContext, String levelTwoDepartmentId, int levelTwoDepartmentVersion) throws Exception {
		return forgetByAllInternal(userContext, levelTwoDepartmentId, levelTwoDepartmentVersion);
	}
	protected LevelTwoDepartment forgetByAllInternal(RetailscmUserContext userContext,
			String levelTwoDepartmentId, int levelTwoDepartmentVersion) throws Exception{

		return levelTwoDepartmentDaoOf(userContext).disconnectFromAll(levelTwoDepartmentId, levelTwoDepartmentVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelTwoDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return levelTwoDepartmentDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String name, String description, Date founded,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentId);


		checkerOf(userContext).checkNameOfLevelThreeDepartment(name);

		checkerOf(userContext).checkDescriptionOfLevelThreeDepartment(description);

		checkerOf(userContext).checkFoundedOfLevelThreeDepartment(founded);


		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);



	}
	public  LevelTwoDepartment addLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String name, String description, Date founded, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingLevelThreeDepartment(userContext,levelTwoDepartmentId,name, description, founded,tokensExpr);

		LevelThreeDepartment levelThreeDepartment = createLevelThreeDepartment(userContext,name, description, founded);

		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, emptyOptions());
		synchronized(levelTwoDepartment){
			//Will be good when the levelTwoDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoDepartment.addLevelThreeDepartment( levelThreeDepartment );
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
			
			levelThreeDepartmentManagerOf(userContext).onNewInstanceCreated(userContext, levelThreeDepartment);
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelThreeDepartmentProperties(RetailscmUserContext userContext, String levelTwoDepartmentId,String id,String name,String description,Date founded,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		checkerOf(userContext).checkIdOfLevelThreeDepartment(id);

		checkerOf(userContext).checkNameOfLevelThreeDepartment( name);
		checkerOf(userContext).checkDescriptionOfLevelThreeDepartment( description);
		checkerOf(userContext).checkFoundedOfLevelThreeDepartment( founded);


		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);


	}
	public  LevelTwoDepartment updateLevelThreeDepartmentProperties(RetailscmUserContext userContext, String levelTwoDepartmentId, String id,String name,String description,Date founded, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelThreeDepartmentProperties(userContext,levelTwoDepartmentId,id,name,description,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelThreeDepartmentListList()
				.searchLevelThreeDepartmentListWith(LevelThreeDepartment.ID_PROPERTY, tokens().is(), id).done();

		LevelTwoDepartment levelTwoDepartmentToUpdate = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, options);

		if(levelTwoDepartmentToUpdate.getLevelThreeDepartmentList().isEmpty()){
			throw new LevelTwoDepartmentManagerException("LevelThreeDepartment is NOT FOUND with id: '"+id+"'");
		}

		LevelThreeDepartment item = levelTwoDepartmentToUpdate.getLevelThreeDepartmentList().first();
		beforeUpdateLevelThreeDepartmentProperties(userContext,item, levelTwoDepartmentId,id,name,description,founded,tokensExpr);
		item.updateName( name );
		item.updateDescription( description );
		item.updateFounded( founded );


		//checkParamsForAddingLevelThreeDepartment(userContext,levelTwoDepartmentId,name, code, used,tokensExpr);
		LevelTwoDepartment levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartmentToUpdate, tokens().withLevelThreeDepartmentList().done());
		synchronized(levelTwoDepartment){
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateLevelThreeDepartmentProperties(RetailscmUserContext userContext, LevelThreeDepartment item, String levelTwoDepartmentId, String id,String name,String description,Date founded, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected LevelThreeDepartment createLevelThreeDepartment(RetailscmUserContext userContext, String name, String description, Date founded) throws Exception{

		LevelThreeDepartment levelThreeDepartment = new LevelThreeDepartment();
		
		
		levelThreeDepartment.setName(name);		
		levelThreeDepartment.setDescription(description);		
		levelThreeDepartment.setFounded(founded);
	
		
		return levelThreeDepartment;


	}

	protected LevelThreeDepartment createIndexedLevelThreeDepartment(String id, int version){

		LevelThreeDepartment levelThreeDepartment = new LevelThreeDepartment();
		levelThreeDepartment.setId(id);
		levelThreeDepartment.setVersion(version);
		return levelThreeDepartment;

	}

	protected void checkParamsForRemovingLevelThreeDepartmentList(RetailscmUserContext userContext, String levelTwoDepartmentId,
			String levelThreeDepartmentIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		for(String levelThreeDepartmentIdItem: levelThreeDepartmentIds){
			checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);

	}
	public  LevelTwoDepartment removeLevelThreeDepartmentList(RetailscmUserContext userContext, String levelTwoDepartmentId,
			String levelThreeDepartmentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingLevelThreeDepartmentList(userContext, levelTwoDepartmentId,  levelThreeDepartmentIds, tokensExpr);


			LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
			synchronized(levelTwoDepartment){
				//Will be good when the levelTwoDepartment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				levelTwoDepartmentDaoOf(userContext).planToRemoveLevelThreeDepartmentList(levelTwoDepartment, levelThreeDepartmentIds, allTokens());
				levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
				deleteRelationListInGraph(userContext, levelTwoDepartment.getLevelThreeDepartmentList());
				return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId,
		String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLevelTwoDepartment( levelTwoDepartmentId);
		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).checkVersionOfLevelThreeDepartment(levelThreeDepartmentVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);


	}
	public  LevelTwoDepartment removeLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId,
		String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingLevelThreeDepartment(userContext,levelTwoDepartmentId, levelThreeDepartmentId, levelThreeDepartmentVersion,tokensExpr);

		LevelThreeDepartment levelThreeDepartment = createIndexedLevelThreeDepartment(levelThreeDepartmentId, levelThreeDepartmentVersion);
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		synchronized(levelTwoDepartment){
			//Will be good when the levelTwoDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoDepartment.removeLevelThreeDepartment( levelThreeDepartment );
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
			deleteRelationInGraph(userContext, levelThreeDepartment);
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId,
		String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLevelTwoDepartment( levelTwoDepartmentId);
		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).checkVersionOfLevelThreeDepartment(levelThreeDepartmentVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);


	}
	public  LevelTwoDepartment copyLevelThreeDepartmentFrom(RetailscmUserContext userContext, String levelTwoDepartmentId,
		String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingLevelThreeDepartment(userContext,levelTwoDepartmentId, levelThreeDepartmentId, levelThreeDepartmentVersion,tokensExpr);

		LevelThreeDepartment levelThreeDepartment = createIndexedLevelThreeDepartment(levelThreeDepartmentId, levelThreeDepartmentVersion);
		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, allTokens());
		synchronized(levelTwoDepartment){
			//Will be good when the levelTwoDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			levelTwoDepartment.copyLevelThreeDepartmentFrom( levelThreeDepartment );
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
			
			levelThreeDepartmentManagerOf(userContext).onNewInstanceCreated(userContext, (LevelThreeDepartment)levelTwoDepartment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfLevelTwoDepartment(levelTwoDepartmentId);
		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).checkVersionOfLevelThreeDepartment(levelThreeDepartmentVersion);


		if(LevelThreeDepartment.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfLevelThreeDepartment(parseString(newValueExpr));
		}
		
		if(LevelThreeDepartment.DESCRIPTION_PROPERTY.equals(property)){
			checkerOf(userContext).checkDescriptionOfLevelThreeDepartment(parseString(newValueExpr));
		}
		
		if(LevelThreeDepartment.FOUNDED_PROPERTY.equals(property)){
			checkerOf(userContext).checkFoundedOfLevelThreeDepartment(parseDate(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoDepartmentManagerException.class);


	}

	public  LevelTwoDepartment updateLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingLevelThreeDepartment(userContext, levelTwoDepartmentId, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withLevelThreeDepartmentList().searchLevelThreeDepartmentListWith(LevelThreeDepartment.ID_PROPERTY, tokens().equals(), levelThreeDepartmentId).done();



		LevelTwoDepartment levelTwoDepartment = loadLevelTwoDepartment(userContext, levelTwoDepartmentId, loadTokens);

		synchronized(levelTwoDepartment){
			//Will be good when the levelTwoDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelTwoDepartment.removeLevelThreeDepartment( levelThreeDepartment );
			//make changes to AcceleraterAccount.
			LevelThreeDepartment levelThreeDepartmentIdVersionKey = createIndexedLevelThreeDepartment(levelThreeDepartmentId, levelThreeDepartmentVersion);

			LevelThreeDepartment levelThreeDepartment = levelTwoDepartment.findTheLevelThreeDepartment(levelThreeDepartmentIdVersionKey);
			if(levelThreeDepartment == null){
				throw new LevelTwoDepartmentManagerException(levelThreeDepartmentId+" is NOT FOUND" );
			}

			beforeUpdateLevelThreeDepartment(userContext, levelThreeDepartment, levelTwoDepartmentId, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr,  tokensExpr);
			levelThreeDepartment.changeProperty(property, newValueExpr);
			
			levelTwoDepartment = saveLevelTwoDepartment(userContext, levelTwoDepartment, tokens().withLevelThreeDepartmentList().done());
			levelThreeDepartmentManagerOf(userContext).onUpdated(userContext, levelThreeDepartment, this, "updateLevelThreeDepartment");
			return present(userContext,levelTwoDepartment, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment existed, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelTwoDepartment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    levelTwoDepartmentDaoOf(ctx).loadAllAsStream().forEach(
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
		//   LevelTwoDepartment newLevelTwoDepartment = this.createLevelTwoDepartment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newLevelTwoDepartment
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
    key.put(UserApp.APP_TYPE_PROPERTY, LevelTwoDepartment.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<LevelTwoDepartment> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<LevelOneDepartment> belongsToList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, LevelOneDepartment.class);
		userContext.getDAOGroup().enhanceList(belongsToList, LevelOneDepartment.class);


    }
	
	public Object listByBelongsTo(RetailscmUserContext userContext,String belongsToId) throws Exception {
		return listPageByBelongsTo(userContext, belongsToId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBelongsTo(RetailscmUserContext userContext,String belongsToId, int start, int count) throws Exception {
		SmartList<LevelTwoDepartment> list = levelTwoDepartmentDaoOf(userContext).findLevelTwoDepartmentByBelongsTo(belongsToId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(LevelTwoDepartment.class);
		page.setContainerObject(LevelOneDepartment.withId(belongsToId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("二级部门列表");
		page.setRequestName("listByBelongsTo");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBelongsTo/%s/",  getBeanName(), belongsToId)));

		page.assemblerContent(userContext, "listByBelongsTo");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String levelTwoDepartmentId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		LevelTwoDepartment merchantObj = (LevelTwoDepartment) this.view(userContext, levelTwoDepartmentId);
    String merchantObjId = levelTwoDepartmentId;
    String linkToUrl =	"levelTwoDepartmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "二级部门"+"详情";
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
				MapUtil.put("id", "2-belongsTo")
				    .put("fieldName", "belongsTo")
				    .put("label", "属于")
				    .put("type", "auto")
				    .put("linkToUrl", "levelOneDepartmentManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("belongsTo", merchantObj.getBelongsTo());

		propList.add(
				MapUtil.put("id", "3-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "4-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "5-founded")
				    .put("fieldName", "founded")
				    .put("label", "成立")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("founded", merchantObj.getFounded());

		//处理 sectionList

		//处理Section：levelThreeDepartmentListSection
		Map levelThreeDepartmentListSection = ListofUtils.buildSection(
		    "levelThreeDepartmentListSection",
		    "三级部门名单",
		    null,
		    "",
		    "__no_group",
		    "levelThreeDepartmentManager/listByBelongsTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(levelThreeDepartmentListSection);

		result.put("levelThreeDepartmentListSection", ListofUtils.toShortList(merchantObj.getLevelThreeDepartmentList(), "levelThreeDepartment"));

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




