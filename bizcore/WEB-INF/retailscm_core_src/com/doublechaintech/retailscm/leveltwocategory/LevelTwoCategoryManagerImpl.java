
package com.doublechaintech.retailscm.leveltwocategory;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.levelonecategory.CandidateLevelOneCategory;import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class LevelTwoCategoryManagerImpl extends CustomRetailscmCheckerManager implements LevelTwoCategoryManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = LevelTwoCategoryTokens.start().withTokenFromListName(listName).done();
		LevelTwoCategory  levelTwoCategory = (LevelTwoCategory) this.loadLevelTwoCategory(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = levelTwoCategory.collectRefercencesFromLists();
		levelTwoCategoryDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, levelTwoCategory, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new LevelTwoCategoryGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "LevelTwoCategory";
	@Override
	public LevelTwoCategoryDAO daoOf(RetailscmUserContext userContext) {
		return levelTwoCategoryDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws LevelTwoCategoryManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new LevelTwoCategoryManagerException(message);

	}



 	protected LevelTwoCategory saveLevelTwoCategory(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory, String [] tokensExpr) throws Exception{
 		//return getLevelTwoCategoryDAO().save(levelTwoCategory, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveLevelTwoCategory(userContext, levelTwoCategory, tokens);
 	}

 	protected LevelTwoCategory saveLevelTwoCategoryDetail(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory) throws Exception{


 		return saveLevelTwoCategory(userContext, levelTwoCategory, allTokens());
 	}

 	public LevelTwoCategory loadLevelTwoCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryId);

		checkerOf(userContext).throwExceptionIfHasErrors( LevelTwoCategoryManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelTwoCategory, tokens);
 	}


 	 public LevelTwoCategory searchLevelTwoCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryId);

		checkerOf(userContext).throwExceptionIfHasErrors( LevelTwoCategoryManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelTwoCategory, tokens);
 	}



 	protected LevelTwoCategory present(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String, Object> tokens) throws Exception {


		addActions(userContext,levelTwoCategory,tokens);
    

		LevelTwoCategory  levelTwoCategoryToPresent = levelTwoCategoryDaoOf(userContext).present(levelTwoCategory, tokens);

		List<BaseEntity> entityListToNaming = levelTwoCategoryToPresent.collectRefercencesFromLists();
		levelTwoCategoryDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,levelTwoCategory,tokens);

		return  levelTwoCategoryToPresent;


	}



 	public LevelTwoCategory loadLevelTwoCategoryDetail(RetailscmUserContext userContext, String levelTwoCategoryId) throws Exception{
 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, allTokens());
 		return present(userContext,levelTwoCategory, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String levelTwoCategoryId) throws Exception{
 		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, viewTokens());
 		markVisited(userContext, levelTwoCategory);
 		return present(userContext,levelTwoCategory, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String levelTwoCategoryId) throws Exception{
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, viewTokens());
		levelTwoCategory.summarySuffix();
		markVisited(userContext, levelTwoCategory);
 		return present(userContext,levelTwoCategory, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String levelTwoCategoryId) throws Exception{
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory( userContext, levelTwoCategoryId, analyzeTokens());
		markVisited(userContext, levelTwoCategory);
		return present(userContext,levelTwoCategory, analyzeTokens());

	}
 	protected LevelTwoCategory saveLevelTwoCategory(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String,Object>tokens) throws Exception{
 	
 		return levelTwoCategoryDaoOf(userContext).save(levelTwoCategory, tokens);
 	}
 	protected LevelTwoCategory loadLevelTwoCategory(RetailscmUserContext userContext, String levelTwoCategoryId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryId);

		checkerOf(userContext).throwExceptionIfHasErrors( LevelTwoCategoryManagerException.class);



 		return levelTwoCategoryDaoOf(userContext).load(levelTwoCategoryId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String, Object> tokens){
		super.addActions(userContext, levelTwoCategory, tokens);

		addAction(userContext, levelTwoCategory, tokens,"@create","createLevelTwoCategory","createLevelTwoCategory/","main","primary");
		addAction(userContext, levelTwoCategory, tokens,"@update","updateLevelTwoCategory","updateLevelTwoCategory/"+levelTwoCategory.getId()+"/","main","primary");
		addAction(userContext, levelTwoCategory, tokens,"@copy","cloneLevelTwoCategory","cloneLevelTwoCategory/"+levelTwoCategory.getId()+"/","main","primary");

		addAction(userContext, levelTwoCategory, tokens,"level_two_category.transfer_to_parent_category","transferToAnotherParentCategory","transferToAnotherParentCategory/"+levelTwoCategory.getId()+"/","main","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.addLevelThreeCategory","addLevelThreeCategory","addLevelThreeCategory/"+levelTwoCategory.getId()+"/","levelThreeCategoryList","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.removeLevelThreeCategory","removeLevelThreeCategory","removeLevelThreeCategory/"+levelTwoCategory.getId()+"/","levelThreeCategoryList","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.updateLevelThreeCategory","updateLevelThreeCategory","updateLevelThreeCategory/"+levelTwoCategory.getId()+"/","levelThreeCategoryList","primary");
		addAction(userContext, levelTwoCategory, tokens,"level_two_category.copyLevelThreeCategoryFrom","copyLevelThreeCategoryFrom","copyLevelThreeCategoryFrom/"+levelTwoCategory.getId()+"/","levelThreeCategoryList","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String, Object> tokens){








  @Override
  public List<LevelTwoCategory> searchLevelTwoCategoryList(RetailscmUserContext ctx, LevelTwoCategoryRequest pRequest){
      pRequest.setUserContext(ctx);
      List<LevelTwoCategory> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public LevelTwoCategory searchLevelTwoCategory(RetailscmUserContext ctx, LevelTwoCategoryRequest pRequest){
    pRequest.limit(0, 1);
    List<LevelTwoCategory> list = searchLevelTwoCategoryList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public LevelTwoCategory createLevelTwoCategory(RetailscmUserContext userContext, String parentCategoryId,String name) throws Exception
	{





		checkerOf(userContext).checkNameOfLevelTwoCategory(name);


		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);



		LevelTwoCategory levelTwoCategory=createNewLevelTwoCategory();	

			
		LevelOneCategory parentCategory = loadLevelOneCategory(userContext, parentCategoryId,emptyOptions());
		levelTwoCategory.setParentCategory(parentCategory);
		
		
		levelTwoCategory.setName(name);

		levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, emptyOptions());
		
		onNewInstanceCreated(userContext, levelTwoCategory);
		return levelTwoCategory;


	}
	protected LevelTwoCategory createNewLevelTwoCategory()
	{

		return new LevelTwoCategory();
	}

	protected void checkParamsForUpdatingLevelTwoCategory(RetailscmUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryId);
		checkerOf(userContext).checkVersionOfLevelTwoCategory( levelTwoCategoryVersion);



		
		if(LevelTwoCategory.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfLevelTwoCategory(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);



	}



	public LevelTwoCategory clone(RetailscmUserContext userContext, String fromLevelTwoCategoryId) throws Exception{

		return levelTwoCategoryDaoOf(userContext).clone(fromLevelTwoCategoryId, this.allTokens());
	}

	public LevelTwoCategory internalSaveLevelTwoCategory(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory) throws Exception
	{
		return internalSaveLevelTwoCategory(userContext, levelTwoCategory, allTokens());

	}
	public LevelTwoCategory internalSaveLevelTwoCategory(RetailscmUserContext userContext, LevelTwoCategory levelTwoCategory, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingLevelTwoCategory(userContext, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr, tokensExpr);


		synchronized(levelTwoCategory){
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoCategory.
			if (levelTwoCategory.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixLevelTwoCategory(levelTwoCategory);
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, options);
			return levelTwoCategory;

		}

	}

	public LevelTwoCategory updateLevelTwoCategory(RetailscmUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelTwoCategory(userContext, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr, tokensExpr);



		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		if(levelTwoCategory.getVersion() != levelTwoCategoryVersion){
			String message = "The target version("+levelTwoCategory.getVersion()+") is not equals to version("+levelTwoCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelTwoCategory){
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoCategory.
			
			levelTwoCategory.changeProperty(property, newValueExpr);
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
			//return saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
		}

	}

	public LevelTwoCategory updateLevelTwoCategoryProperty(RetailscmUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelTwoCategory(userContext, levelTwoCategoryId, levelTwoCategoryVersion, property, newValueExpr, tokensExpr);

		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		if(levelTwoCategory.getVersion() != levelTwoCategoryVersion){
			String message = "The target version("+levelTwoCategory.getVersion()+") is not equals to version("+levelTwoCategoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelTwoCategory){
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelTwoCategory.

			levelTwoCategory.changeProperty(property, newValueExpr);
			
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
			//return saveLevelTwoCategory(userContext, levelTwoCategory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected LevelTwoCategoryTokens tokens(){
		return LevelTwoCategoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelTwoCategoryTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLevelThreeCategoryListWith(LevelThreeCategory.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelTwoCategoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherParentCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryId);
 		checkerOf(userContext).checkIdOfLevelOneCategory(anotherParentCategoryId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);

 	}
 	public LevelTwoCategory transferToAnotherParentCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId) throws Exception
 	{
 		checkParamsForTransferingAnotherParentCategory(userContext, levelTwoCategoryId,anotherParentCategoryId);
 
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		synchronized(levelTwoCategory){
			//will be good when the levelTwoCategory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelOneCategory parentCategory = loadLevelOneCategory(userContext, anotherParentCategoryId, emptyOptions());
			levelTwoCategory.updateParentCategory(parentCategory);
			
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, emptyOptions());

			return present(userContext,levelTwoCategory, allTokens());

		}

 	}

	


	public CandidateLevelOneCategory requestCandidateParentCategory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelOneCategory result = new CandidateLevelOneCategory();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("catalog");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelOneCategory> candidateList = levelOneCategoryDaoOf(userContext).requestCandidateLevelOneCategoryForLevelTwoCategory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected LevelOneCategory loadLevelOneCategory(RetailscmUserContext userContext, String newParentCategoryId, Map<String,Object> options) throws Exception
 	{
    
 		return levelOneCategoryDaoOf(userContext).load(newParentCategoryId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception {
		//deleteInternal(userContext, levelTwoCategoryId, levelTwoCategoryVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception{

		levelTwoCategoryDaoOf(userContext).delete(levelTwoCategoryId, levelTwoCategoryVersion);
	}

	public LevelTwoCategory forgetByAll(RetailscmUserContext userContext, String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception {
		return forgetByAllInternal(userContext, levelTwoCategoryId, levelTwoCategoryVersion);
	}
	protected LevelTwoCategory forgetByAllInternal(RetailscmUserContext userContext,
			String levelTwoCategoryId, int levelTwoCategoryVersion) throws Exception{

		return levelTwoCategoryDaoOf(userContext).disconnectFromAll(levelTwoCategoryId, levelTwoCategoryVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelTwoCategoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return levelTwoCategoryDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String name,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryId);


		checkerOf(userContext).checkNameOfLevelThreeCategory(name);


		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);



	}
	public  LevelTwoCategory addLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String name, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingLevelThreeCategory(userContext,levelTwoCategoryId,name,tokensExpr);

		LevelThreeCategory levelThreeCategory = createLevelThreeCategory(userContext,name);

		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, emptyOptions());
		synchronized(levelTwoCategory){
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoCategory.addLevelThreeCategory( levelThreeCategory );
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
			
			levelThreeCategoryManagerOf(userContext).onNewInstanceCreated(userContext, levelThreeCategory);
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelThreeCategoryProperties(RetailscmUserContext userContext, String levelTwoCategoryId,String id,String name,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryId);
		checkerOf(userContext).checkIdOfLevelThreeCategory(id);

		checkerOf(userContext).checkNameOfLevelThreeCategory( name);


		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);


	}
	public  LevelTwoCategory updateLevelThreeCategoryProperties(RetailscmUserContext userContext, String levelTwoCategoryId, String id,String name, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelThreeCategoryProperties(userContext,levelTwoCategoryId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelThreeCategoryListList()
				.searchLevelThreeCategoryListWith(LevelThreeCategory.ID_PROPERTY, tokens().is(), id).done();

		LevelTwoCategory levelTwoCategoryToUpdate = loadLevelTwoCategory(userContext, levelTwoCategoryId, options);

		if(levelTwoCategoryToUpdate.getLevelThreeCategoryList().isEmpty()){
			throw new LevelTwoCategoryManagerException("LevelThreeCategory is NOT FOUND with id: '"+id+"'");
		}

		LevelThreeCategory item = levelTwoCategoryToUpdate.getLevelThreeCategoryList().first();
		beforeUpdateLevelThreeCategoryProperties(userContext,item, levelTwoCategoryId,id,name,tokensExpr);
		item.updateName( name );


		//checkParamsForAddingLevelThreeCategory(userContext,levelTwoCategoryId,name, code, used,tokensExpr);
		LevelTwoCategory levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategoryToUpdate, tokens().withLevelThreeCategoryList().done());
		synchronized(levelTwoCategory){
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateLevelThreeCategoryProperties(RetailscmUserContext userContext, LevelThreeCategory item, String levelTwoCategoryId, String id,String name, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected LevelThreeCategory createLevelThreeCategory(RetailscmUserContext userContext, String name) throws Exception{

		LevelThreeCategory levelThreeCategory = new LevelThreeCategory();
		
		
		levelThreeCategory.setName(name);
	
		
		return levelThreeCategory;


	}

	protected LevelThreeCategory createIndexedLevelThreeCategory(String id, int version){

		LevelThreeCategory levelThreeCategory = new LevelThreeCategory();
		levelThreeCategory.setId(id);
		levelThreeCategory.setVersion(version);
		return levelThreeCategory;

	}

	protected void checkParamsForRemovingLevelThreeCategoryList(RetailscmUserContext userContext, String levelTwoCategoryId,
			String levelThreeCategoryIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryId);
		for(String levelThreeCategoryIdItem: levelThreeCategoryIds){
			checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);

	}
	public  LevelTwoCategory removeLevelThreeCategoryList(RetailscmUserContext userContext, String levelTwoCategoryId,
			String levelThreeCategoryIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingLevelThreeCategoryList(userContext, levelTwoCategoryId,  levelThreeCategoryIds, tokensExpr);


			LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
			synchronized(levelTwoCategory){
				//Will be good when the levelTwoCategory loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				levelTwoCategoryDaoOf(userContext).planToRemoveLevelThreeCategoryList(levelTwoCategory, levelThreeCategoryIds, allTokens());
				levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
				deleteRelationListInGraph(userContext, levelTwoCategory.getLevelThreeCategoryList());
				return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId,
		String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLevelTwoCategory( levelTwoCategoryId);
		checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryId);
		checkerOf(userContext).checkVersionOfLevelThreeCategory(levelThreeCategoryVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);


	}
	public  LevelTwoCategory removeLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId,
		String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingLevelThreeCategory(userContext,levelTwoCategoryId, levelThreeCategoryId, levelThreeCategoryVersion,tokensExpr);

		LevelThreeCategory levelThreeCategory = createIndexedLevelThreeCategory(levelThreeCategoryId, levelThreeCategoryVersion);
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		synchronized(levelTwoCategory){
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelTwoCategory.removeLevelThreeCategory( levelThreeCategory );
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
			deleteRelationInGraph(userContext, levelThreeCategory);
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId,
		String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLevelTwoCategory( levelTwoCategoryId);
		checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryId);
		checkerOf(userContext).checkVersionOfLevelThreeCategory(levelThreeCategoryVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);


	}
	public  LevelTwoCategory copyLevelThreeCategoryFrom(RetailscmUserContext userContext, String levelTwoCategoryId,
		String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingLevelThreeCategory(userContext,levelTwoCategoryId, levelThreeCategoryId, levelThreeCategoryVersion,tokensExpr);

		LevelThreeCategory levelThreeCategory = createIndexedLevelThreeCategory(levelThreeCategoryId, levelThreeCategoryVersion);
		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, allTokens());
		synchronized(levelTwoCategory){
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			levelTwoCategory.copyLevelThreeCategoryFrom( levelThreeCategory );
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
			
			levelThreeCategoryManagerOf(userContext).onNewInstanceCreated(userContext, (LevelThreeCategory)levelTwoCategory.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfLevelTwoCategory(levelTwoCategoryId);
		checkerOf(userContext).checkIdOfLevelThreeCategory(levelThreeCategoryId);
		checkerOf(userContext).checkVersionOfLevelThreeCategory(levelThreeCategoryVersion);


		if(LevelThreeCategory.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfLevelThreeCategory(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(LevelTwoCategoryManagerException.class);


	}

	public  LevelTwoCategory updateLevelThreeCategory(RetailscmUserContext userContext, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingLevelThreeCategory(userContext, levelTwoCategoryId, levelThreeCategoryId, levelThreeCategoryVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withLevelThreeCategoryList().searchLevelThreeCategoryListWith(LevelThreeCategory.ID_PROPERTY, tokens().equals(), levelThreeCategoryId).done();



		LevelTwoCategory levelTwoCategory = loadLevelTwoCategory(userContext, levelTwoCategoryId, loadTokens);

		synchronized(levelTwoCategory){
			//Will be good when the levelTwoCategory loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelTwoCategory.removeLevelThreeCategory( levelThreeCategory );
			//make changes to AcceleraterAccount.
			LevelThreeCategory levelThreeCategoryIdVersionKey = createIndexedLevelThreeCategory(levelThreeCategoryId, levelThreeCategoryVersion);

			LevelThreeCategory levelThreeCategory = levelTwoCategory.findTheLevelThreeCategory(levelThreeCategoryIdVersionKey);
			if(levelThreeCategory == null){
				throw new LevelTwoCategoryManagerException(levelThreeCategoryId+" is NOT FOUND" );
			}

			beforeUpdateLevelThreeCategory(userContext, levelThreeCategory, levelTwoCategoryId, levelThreeCategoryId, levelThreeCategoryVersion, property, newValueExpr,  tokensExpr);
			levelThreeCategory.changeProperty(property, newValueExpr);
			
			levelTwoCategory = saveLevelTwoCategory(userContext, levelTwoCategory, tokens().withLevelThreeCategoryList().done());
			levelThreeCategoryManagerOf(userContext).onUpdated(userContext, levelThreeCategory, this, "updateLevelThreeCategory");
			return present(userContext,levelTwoCategory, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateLevelThreeCategory(RetailscmUserContext userContext, LevelThreeCategory existed, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelTwoCategory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    levelTwoCategoryDaoOf(ctx).loadAllAsStream().forEach(
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
		//   LevelTwoCategory newLevelTwoCategory = this.createLevelTwoCategory(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newLevelTwoCategory
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
    key.put(UserApp.APP_TYPE_PROPERTY, LevelTwoCategory.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<LevelTwoCategory> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<LevelOneCategory> parentCategoryList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, LevelOneCategory.class);
		userContext.getDAOGroup().enhanceList(parentCategoryList, LevelOneCategory.class);


    }
	
	public Object listByParentCategory(RetailscmUserContext userContext,String parentCategoryId) throws Exception {
		return listPageByParentCategory(userContext, parentCategoryId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByParentCategory(RetailscmUserContext userContext,String parentCategoryId, int start, int count) throws Exception {
		SmartList<LevelTwoCategory> list = levelTwoCategoryDaoOf(userContext).findLevelTwoCategoryByParentCategory(parentCategoryId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(LevelTwoCategory.class);
		page.setContainerObject(LevelOneCategory.withId(parentCategoryId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("二级分类列表");
		page.setRequestName("listByParentCategory");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByParentCategory/%s/",  getBeanName(), parentCategoryId)));

		page.assemblerContent(userContext, "listByParentCategory");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String levelTwoCategoryId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		LevelTwoCategory merchantObj = (LevelTwoCategory) this.view(userContext, levelTwoCategoryId);
    String merchantObjId = levelTwoCategoryId;
    String linkToUrl =	"levelTwoCategoryManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "二级分类"+"详情";
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
				MapUtil.put("id", "2-parentCategory")
				    .put("fieldName", "parentCategory")
				    .put("label", "父类")
				    .put("type", "auto")
				    .put("linkToUrl", "levelOneCategoryManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("parentCategory", merchantObj.getParentCategory());

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

		//处理 sectionList

		//处理Section：levelThreeCategoryListSection
		Map levelThreeCategoryListSection = ListofUtils.buildSection(
		    "levelThreeCategoryListSection",
		    "三级类别表",
		    null,
		    "",
		    "__no_group",
		    "levelThreeCategoryManager/listByParentCategory/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(levelThreeCategoryListSection);

		result.put("levelThreeCategoryListSection", ListofUtils.toShortList(merchantObj.getLevelThreeCategoryList(), "levelThreeCategory"));

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




