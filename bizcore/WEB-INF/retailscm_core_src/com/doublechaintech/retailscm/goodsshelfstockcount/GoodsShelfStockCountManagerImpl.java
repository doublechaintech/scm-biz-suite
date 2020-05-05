
package com.doublechaintech.retailscm.goodsshelfstockcount;

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


import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack;

import com.doublechaintech.retailscm.goodsshelf.CandidateGoodsShelf;

import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;






public class GoodsShelfStockCountManagerImpl extends CustomRetailscmCheckerManager implements GoodsShelfStockCountManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = GoodsShelfStockCountTokens.start().withTokenFromListName(listName).done();
		GoodsShelfStockCount  goodsShelfStockCount = (GoodsShelfStockCount) this.loadGoodsShelfStockCount(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = goodsShelfStockCount.collectRefercencesFromLists();
		goodsShelfStockCountDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, goodsShelfStockCount, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new GoodsShelfStockCountGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "GoodsShelfStockCount";
	@Override
	public GoodsShelfStockCountDAO daoOf(RetailscmUserContext userContext) {
		return goodsShelfStockCountDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws GoodsShelfStockCountManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new GoodsShelfStockCountManagerException(message);

	}



 	protected GoodsShelfStockCount saveGoodsShelfStockCount(RetailscmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount, String [] tokensExpr) throws Exception{	
 		//return getGoodsShelfStockCountDAO().save(goodsShelfStockCount, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens);
 	}
 	
 	protected GoodsShelfStockCount saveGoodsShelfStockCountDetail(RetailscmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount) throws Exception{	

 		
 		return saveGoodsShelfStockCount(userContext, goodsShelfStockCount, allTokens());
 	}
 	
 	public GoodsShelfStockCount loadGoodsShelfStockCount(RetailscmUserContext userContext, String goodsShelfStockCountId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		checkerOf(userContext).throwExceptionIfHasErrors( GoodsShelfStockCountManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount( userContext, goodsShelfStockCountId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsShelfStockCount, tokens);
 	}
 	
 	
 	 public GoodsShelfStockCount searchGoodsShelfStockCount(RetailscmUserContext userContext, String goodsShelfStockCountId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		checkerOf(userContext).throwExceptionIfHasErrors( GoodsShelfStockCountManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount( userContext, goodsShelfStockCountId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsShelfStockCount, tokens);
 	}
 	
 	

 	protected GoodsShelfStockCount present(RetailscmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsShelfStockCount,tokens);
		
		
		GoodsShelfStockCount  goodsShelfStockCountToPresent = goodsShelfStockCountDaoOf(userContext).present(goodsShelfStockCount, tokens);
		
		List<BaseEntity> entityListToNaming = goodsShelfStockCountToPresent.collectRefercencesFromLists();
		goodsShelfStockCountDaoOf(userContext).alias(entityListToNaming);
		
		return  goodsShelfStockCountToPresent;
		
		
	}
 
 	
 	
 	public GoodsShelfStockCount loadGoodsShelfStockCountDetail(RetailscmUserContext userContext, String goodsShelfStockCountId) throws Exception{	
 		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount( userContext, goodsShelfStockCountId, allTokens());
 		return present(userContext,goodsShelfStockCount, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String goodsShelfStockCountId) throws Exception{	
 		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount( userContext, goodsShelfStockCountId, viewTokens());
 		return present(userContext,goodsShelfStockCount, allTokens());
		
 	}
 	protected GoodsShelfStockCount saveGoodsShelfStockCount(RetailscmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount, Map<String,Object>tokens) throws Exception{	
 		return goodsShelfStockCountDaoOf(userContext).save(goodsShelfStockCount, tokens);
 	}
 	protected GoodsShelfStockCount loadGoodsShelfStockCount(RetailscmUserContext userContext, String goodsShelfStockCountId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		checkerOf(userContext).throwExceptionIfHasErrors( GoodsShelfStockCountManagerException.class);

 
 		return goodsShelfStockCountDaoOf(userContext).load(goodsShelfStockCountId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount, Map<String, Object> tokens){
		super.addActions(userContext, goodsShelfStockCount, tokens);
		
		addAction(userContext, goodsShelfStockCount, tokens,"@create","createGoodsShelfStockCount","createGoodsShelfStockCount/","main","primary");
		addAction(userContext, goodsShelfStockCount, tokens,"@update","updateGoodsShelfStockCount","updateGoodsShelfStockCount/"+goodsShelfStockCount.getId()+"/","main","primary");
		addAction(userContext, goodsShelfStockCount, tokens,"@copy","cloneGoodsShelfStockCount","cloneGoodsShelfStockCount/"+goodsShelfStockCount.getId()+"/","main","primary");
		
		addAction(userContext, goodsShelfStockCount, tokens,"goods_shelf_stock_count.transfer_to_shelf","transferToAnotherShelf","transferToAnotherShelf/"+goodsShelfStockCount.getId()+"/","main","primary");
		addAction(userContext, goodsShelfStockCount, tokens,"goods_shelf_stock_count.addStockCountIssueTrack","addStockCountIssueTrack","addStockCountIssueTrack/"+goodsShelfStockCount.getId()+"/","stockCountIssueTrackList","primary");
		addAction(userContext, goodsShelfStockCount, tokens,"goods_shelf_stock_count.removeStockCountIssueTrack","removeStockCountIssueTrack","removeStockCountIssueTrack/"+goodsShelfStockCount.getId()+"/","stockCountIssueTrackList","primary");
		addAction(userContext, goodsShelfStockCount, tokens,"goods_shelf_stock_count.updateStockCountIssueTrack","updateStockCountIssueTrack","updateStockCountIssueTrack/"+goodsShelfStockCount.getId()+"/","stockCountIssueTrackList","primary");
		addAction(userContext, goodsShelfStockCount, tokens,"goods_shelf_stock_count.copyStockCountIssueTrackFrom","copyStockCountIssueTrackFrom","copyStockCountIssueTrackFrom/"+goodsShelfStockCount.getId()+"/","stockCountIssueTrackList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public GoodsShelfStockCount createGoodsShelfStockCount(RetailscmUserContext userContext, String title,Date countTime,String summary,String shelfId) throws Exception
	//public GoodsShelfStockCount createGoodsShelfStockCount(RetailscmUserContext userContext,String title, Date countTime, String summary, String shelfId) throws Exception
	{

		

		

		checkerOf(userContext).checkTitleOfGoodsShelfStockCount(title);
		checkerOf(userContext).checkCountTimeOfGoodsShelfStockCount(countTime);
		checkerOf(userContext).checkSummaryOfGoodsShelfStockCount(summary);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);


		GoodsShelfStockCount goodsShelfStockCount=createNewGoodsShelfStockCount();	

		goodsShelfStockCount.setTitle(title);
		goodsShelfStockCount.setCountTime(countTime);
		goodsShelfStockCount.setSummary(summary);
			
		GoodsShelf shelf = loadGoodsShelf(userContext, shelfId,emptyOptions());
		goodsShelfStockCount.setShelf(shelf);
		
		

		goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, emptyOptions());
		
		onNewInstanceCreated(userContext, goodsShelfStockCount);
		return goodsShelfStockCount;


	}
	protected GoodsShelfStockCount createNewGoodsShelfStockCount()
	{

		return new GoodsShelfStockCount();
	}

	protected void checkParamsForUpdatingGoodsShelfStockCount(RetailscmUserContext userContext,String goodsShelfStockCountId, int goodsShelfStockCountVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		checkerOf(userContext).checkVersionOfGoodsShelfStockCount( goodsShelfStockCountVersion);
		

		if(GoodsShelfStockCount.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfGoodsShelfStockCount(parseString(newValueExpr));
		
			
		}
		if(GoodsShelfStockCount.COUNT_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCountTimeOfGoodsShelfStockCount(parseDate(newValueExpr));
		
			
		}
		if(GoodsShelfStockCount.SUMMARY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSummaryOfGoodsShelfStockCount(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);


	}



	public GoodsShelfStockCount clone(RetailscmUserContext userContext, String fromGoodsShelfStockCountId) throws Exception{

		return goodsShelfStockCountDaoOf(userContext).clone(fromGoodsShelfStockCountId, this.allTokens());
	}

	public GoodsShelfStockCount internalSaveGoodsShelfStockCount(RetailscmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount) throws Exception
	{
		return internalSaveGoodsShelfStockCount(userContext, goodsShelfStockCount, allTokens());

	}
	public GoodsShelfStockCount internalSaveGoodsShelfStockCount(RetailscmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingGoodsShelfStockCount(userContext, goodsShelfStockCountId, goodsShelfStockCountVersion, property, newValueExpr, tokensExpr);


		synchronized(goodsShelfStockCount){
			//will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsShelfStockCount.
			if (goodsShelfStockCount.isChanged()){
			
			}
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, options);
			return goodsShelfStockCount;

		}

	}

	public GoodsShelfStockCount updateGoodsShelfStockCount(RetailscmUserContext userContext,String goodsShelfStockCountId, int goodsShelfStockCountVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsShelfStockCount(userContext, goodsShelfStockCountId, goodsShelfStockCountVersion, property, newValueExpr, tokensExpr);



		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
		if(goodsShelfStockCount.getVersion() != goodsShelfStockCountVersion){
			String message = "The target version("+goodsShelfStockCount.getVersion()+") is not equals to version("+goodsShelfStockCountVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(goodsShelfStockCount){
			//will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsShelfStockCount.
			
			goodsShelfStockCount.changeProperty(property, newValueExpr);
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().done());
			return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
			//return saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().done());
		}

	}

	public GoodsShelfStockCount updateGoodsShelfStockCountProperty(RetailscmUserContext userContext,String goodsShelfStockCountId, int goodsShelfStockCountVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsShelfStockCount(userContext, goodsShelfStockCountId, goodsShelfStockCountVersion, property, newValueExpr, tokensExpr);

		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
		if(goodsShelfStockCount.getVersion() != goodsShelfStockCountVersion){
			String message = "The target version("+goodsShelfStockCount.getVersion()+") is not equals to version("+goodsShelfStockCountVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(goodsShelfStockCount){
			//will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsShelfStockCount.

			goodsShelfStockCount.changeProperty(property, newValueExpr);
			
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().done());
			return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
			//return saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected GoodsShelfStockCountTokens tokens(){
		return GoodsShelfStockCountTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsShelfStockCountTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortStockCountIssueTrackListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsShelfStockCountTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherShelf(RetailscmUserContext userContext, String goodsShelfStockCountId, String anotherShelfId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
 		checkerOf(userContext).checkIdOfGoodsShelf(anotherShelfId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);

 	}
 	public GoodsShelfStockCount transferToAnotherShelf(RetailscmUserContext userContext, String goodsShelfStockCountId, String anotherShelfId) throws Exception
 	{
 		checkParamsForTransferingAnotherShelf(userContext, goodsShelfStockCountId,anotherShelfId);
 
		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());	
		synchronized(goodsShelfStockCount){
			//will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsShelf shelf = loadGoodsShelf(userContext, anotherShelfId, emptyOptions());		
			goodsShelfStockCount.updateShelf(shelf);		
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, emptyOptions());
			
			return present(userContext,goodsShelfStockCount, allTokens());
			
		}

 	}

	


	public CandidateGoodsShelf requestCandidateShelf(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGoodsShelf result = new CandidateGoodsShelf();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("location");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GoodsShelf> candidateList = goodsShelfDaoOf(userContext).requestCandidateGoodsShelfForGoodsShelfStockCount(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected GoodsShelf loadGoodsShelf(RetailscmUserContext userContext, String newShelfId, Map<String,Object> options) throws Exception
 	{

 		return goodsShelfDaoOf(userContext).load(newShelfId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String goodsShelfStockCountId, int goodsShelfStockCountVersion) throws Exception {
		//deleteInternal(userContext, goodsShelfStockCountId, goodsShelfStockCountVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String goodsShelfStockCountId, int goodsShelfStockCountVersion) throws Exception{

		goodsShelfStockCountDaoOf(userContext).delete(goodsShelfStockCountId, goodsShelfStockCountVersion);
	}

	public GoodsShelfStockCount forgetByAll(RetailscmUserContext userContext, String goodsShelfStockCountId, int goodsShelfStockCountVersion) throws Exception {
		return forgetByAllInternal(userContext, goodsShelfStockCountId, goodsShelfStockCountVersion);
	}
	protected GoodsShelfStockCount forgetByAllInternal(RetailscmUserContext userContext,
			String goodsShelfStockCountId, int goodsShelfStockCountVersion) throws Exception{

		return goodsShelfStockCountDaoOf(userContext).disconnectFromAll(goodsShelfStockCountId, goodsShelfStockCountVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsShelfStockCountManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return goodsShelfStockCountDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingStockCountIssueTrack(RetailscmUserContext userContext, String goodsShelfStockCountId, String title, Date countTime, String summary,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);

		
		checkerOf(userContext).checkTitleOfStockCountIssueTrack(title);
		
		checkerOf(userContext).checkCountTimeOfStockCountIssueTrack(countTime);
		
		checkerOf(userContext).checkSummaryOfStockCountIssueTrack(summary);
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);


	}
	public  GoodsShelfStockCount addStockCountIssueTrack(RetailscmUserContext userContext, String goodsShelfStockCountId, String title, Date countTime, String summary, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingStockCountIssueTrack(userContext,goodsShelfStockCountId,title, countTime, summary,tokensExpr);

		StockCountIssueTrack stockCountIssueTrack = createStockCountIssueTrack(userContext,title, countTime, summary);

		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, emptyOptions());
		synchronized(goodsShelfStockCount){
			//Will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsShelfStockCount.addStockCountIssueTrack( stockCountIssueTrack );
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
			
			userContext.getManagerGroup().getStockCountIssueTrackManager().onNewInstanceCreated(userContext, stockCountIssueTrack);
			return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingStockCountIssueTrackProperties(RetailscmUserContext userContext, String goodsShelfStockCountId,String id,String title,Date countTime,String summary,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		checkerOf(userContext).checkIdOfStockCountIssueTrack(id);

		checkerOf(userContext).checkTitleOfStockCountIssueTrack( title);
		checkerOf(userContext).checkCountTimeOfStockCountIssueTrack( countTime);
		checkerOf(userContext).checkSummaryOfStockCountIssueTrack( summary);

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);

	}
	public  GoodsShelfStockCount updateStockCountIssueTrackProperties(RetailscmUserContext userContext, String goodsShelfStockCountId, String id,String title,Date countTime,String summary, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingStockCountIssueTrackProperties(userContext,goodsShelfStockCountId,id,title,countTime,summary,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withStockCountIssueTrackListList()
				.searchStockCountIssueTrackListWith(StockCountIssueTrack.ID_PROPERTY, "is", id).done();

		GoodsShelfStockCount goodsShelfStockCountToUpdate = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, options);

		if(goodsShelfStockCountToUpdate.getStockCountIssueTrackList().isEmpty()){
			throw new GoodsShelfStockCountManagerException("StockCountIssueTrack is NOT FOUND with id: '"+id+"'");
		}

		StockCountIssueTrack item = goodsShelfStockCountToUpdate.getStockCountIssueTrackList().first();

		item.updateTitle( title );
		item.updateCountTime( countTime );
		item.updateSummary( summary );


		//checkParamsForAddingStockCountIssueTrack(userContext,goodsShelfStockCountId,name, code, used,tokensExpr);
		GoodsShelfStockCount goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCountToUpdate, tokens().withStockCountIssueTrackList().done());
		synchronized(goodsShelfStockCount){
			return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
		}
	}


	protected StockCountIssueTrack createStockCountIssueTrack(RetailscmUserContext userContext, String title, Date countTime, String summary) throws Exception{

		StockCountIssueTrack stockCountIssueTrack = new StockCountIssueTrack();
		
		
		stockCountIssueTrack.setTitle(title);		
		stockCountIssueTrack.setCountTime(countTime);		
		stockCountIssueTrack.setSummary(summary);
	
		
		return stockCountIssueTrack;


	}

	protected StockCountIssueTrack createIndexedStockCountIssueTrack(String id, int version){

		StockCountIssueTrack stockCountIssueTrack = new StockCountIssueTrack();
		stockCountIssueTrack.setId(id);
		stockCountIssueTrack.setVersion(version);
		return stockCountIssueTrack;

	}

	protected void checkParamsForRemovingStockCountIssueTrackList(RetailscmUserContext userContext, String goodsShelfStockCountId,
			String stockCountIssueTrackIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		for(String stockCountIssueTrackIdItem: stockCountIssueTrackIds){
			checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);

	}
	public  GoodsShelfStockCount removeStockCountIssueTrackList(RetailscmUserContext userContext, String goodsShelfStockCountId,
			String stockCountIssueTrackIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingStockCountIssueTrackList(userContext, goodsShelfStockCountId,  stockCountIssueTrackIds, tokensExpr);


			GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
			synchronized(goodsShelfStockCount){
				//Will be good when the goodsShelfStockCount loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				goodsShelfStockCountDaoOf(userContext).planToRemoveStockCountIssueTrackList(goodsShelfStockCount, stockCountIssueTrackIds, allTokens());
				goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
				deleteRelationListInGraph(userContext, goodsShelfStockCount.getStockCountIssueTrackList());
				return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingStockCountIssueTrack(RetailscmUserContext userContext, String goodsShelfStockCountId,
		String stockCountIssueTrackId, int stockCountIssueTrackVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGoodsShelfStockCount( goodsShelfStockCountId);
		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		checkerOf(userContext).checkVersionOfStockCountIssueTrack(stockCountIssueTrackVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);

	}
	public  GoodsShelfStockCount removeStockCountIssueTrack(RetailscmUserContext userContext, String goodsShelfStockCountId,
		String stockCountIssueTrackId, int stockCountIssueTrackVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingStockCountIssueTrack(userContext,goodsShelfStockCountId, stockCountIssueTrackId, stockCountIssueTrackVersion,tokensExpr);

		StockCountIssueTrack stockCountIssueTrack = createIndexedStockCountIssueTrack(stockCountIssueTrackId, stockCountIssueTrackVersion);
		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
		synchronized(goodsShelfStockCount){
			//Will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsShelfStockCount.removeStockCountIssueTrack( stockCountIssueTrack );
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
			deleteRelationInGraph(userContext, stockCountIssueTrack);
			return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingStockCountIssueTrack(RetailscmUserContext userContext, String goodsShelfStockCountId,
		String stockCountIssueTrackId, int stockCountIssueTrackVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfGoodsShelfStockCount( goodsShelfStockCountId);
		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		checkerOf(userContext).checkVersionOfStockCountIssueTrack(stockCountIssueTrackVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);

	}
	public  GoodsShelfStockCount copyStockCountIssueTrackFrom(RetailscmUserContext userContext, String goodsShelfStockCountId,
		String stockCountIssueTrackId, int stockCountIssueTrackVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingStockCountIssueTrack(userContext,goodsShelfStockCountId, stockCountIssueTrackId, stockCountIssueTrackVersion,tokensExpr);

		StockCountIssueTrack stockCountIssueTrack = createIndexedStockCountIssueTrack(stockCountIssueTrackId, stockCountIssueTrackVersion);
		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
		synchronized(goodsShelfStockCount){
			//Will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			goodsShelfStockCount.copyStockCountIssueTrackFrom( stockCountIssueTrack );
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
			
			userContext.getManagerGroup().getStockCountIssueTrackManager().onNewInstanceCreated(userContext, (StockCountIssueTrack)goodsShelfStockCount.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingStockCountIssueTrack(RetailscmUserContext userContext, String goodsShelfStockCountId, String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		checkerOf(userContext).checkVersionOfStockCountIssueTrack(stockCountIssueTrackVersion);
		

		if(StockCountIssueTrack.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfStockCountIssueTrack(parseString(newValueExpr));
		
		}
		
		if(StockCountIssueTrack.COUNT_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCountTimeOfStockCountIssueTrack(parseDate(newValueExpr));
		
		}
		
		if(StockCountIssueTrack.SUMMARY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSummaryOfStockCountIssueTrack(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);

	}

	public  GoodsShelfStockCount updateStockCountIssueTrack(RetailscmUserContext userContext, String goodsShelfStockCountId, String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingStockCountIssueTrack(userContext, goodsShelfStockCountId, stockCountIssueTrackId, stockCountIssueTrackVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withStockCountIssueTrackList().searchStockCountIssueTrackListWith(StockCountIssueTrack.ID_PROPERTY, "eq", stockCountIssueTrackId).done();



		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, loadTokens);

		synchronized(goodsShelfStockCount){
			//Will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsShelfStockCount.removeStockCountIssueTrack( stockCountIssueTrack );
			//make changes to AcceleraterAccount.
			StockCountIssueTrack stockCountIssueTrackIndex = createIndexedStockCountIssueTrack(stockCountIssueTrackId, stockCountIssueTrackVersion);

			StockCountIssueTrack stockCountIssueTrack = goodsShelfStockCount.findTheStockCountIssueTrack(stockCountIssueTrackIndex);
			if(stockCountIssueTrack == null){
				throw new GoodsShelfStockCountManagerException(stockCountIssueTrack+" is NOT FOUND" );
			}

			stockCountIssueTrack.changeProperty(property, newValueExpr);
			
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
			return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsShelfStockCount newCreated) throws Exception{
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
		//   GoodsShelfStockCount newGoodsShelfStockCount = this.createGoodsShelfStockCount(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newGoodsShelfStockCount
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, GoodsShelfStockCount.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<GoodsShelfStockCount> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<GoodsShelf> shelfList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, GoodsShelf.class);
		userContext.getDAOGroup().enhanceList(shelfList, GoodsShelf.class);


    }
	
	public Object listByShelf(RetailscmUserContext userContext,String shelfId) throws Exception {
		return listPageByShelf(userContext, shelfId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByShelf(RetailscmUserContext userContext,String shelfId, int start, int count) throws Exception {
		SmartList<GoodsShelfStockCount> list = goodsShelfStockCountDaoOf(userContext).findGoodsShelfStockCountByShelf(shelfId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(GoodsShelfStockCount.class);
		page.setContainerObject(GoodsShelf.withId(shelfId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("货架库存盘点列表");
		page.setRequestName("listByShelf");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByShelf/%s/",  getBeanName(), shelfId)));

		page.assemblerContent(userContext, "listByShelf");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String goodsShelfStockCountId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getGoodsShelfStockCountDetailScope().clone();
		GoodsShelfStockCount merchantObj = (GoodsShelfStockCount) this.view(userContext, goodsShelfStockCountId);
    String merchantObjId = goodsShelfStockCountId;
    String linkToUrl =	"goodsShelfStockCountManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "货架库存盘点"+"详情";
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
				MapUtil.put("id", "3-countTime")
				    .put("fieldName", "countTime")
				    .put("label", "计数时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("countTime", merchantObj.getCountTime());

		propList.add(
				MapUtil.put("id", "4-summary")
				    .put("fieldName", "summary")
				    .put("label", "概览")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("summary", merchantObj.getSummary());

		propList.add(
				MapUtil.put("id", "5-shelf")
				    .put("fieldName", "shelf")
				    .put("label", "架")
				    .put("type", "auto")
				    .put("linkToUrl", "goodsShelfManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("shelf", merchantObj.getShelf());

		//处理 sectionList

		//处理Section：stockCountIssueTrackListSection
		Map stockCountIssueTrackListSection = ListofUtils.buildSection(
		    "stockCountIssueTrackListSection",
		    "盘点发行跟踪清单",
		    null,
		    "",
		    "__no_group",
		    "stockCountIssueTrackManager/listByStockCount/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(stockCountIssueTrackListSection);

		result.put("stockCountIssueTrackListSection", ListofUtils.toShortList(merchantObj.getStockCountIssueTrackList(), "stockCountIssueTrack"));
		vscope.field("stockCountIssueTrackListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( StockCountIssueTrack.class.getName(), null));

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


