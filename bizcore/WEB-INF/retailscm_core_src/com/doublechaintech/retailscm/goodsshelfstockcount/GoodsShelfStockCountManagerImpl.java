
package com.doublechaintech.retailscm.goodsshelfstockcount;

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

import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack;

import com.doublechaintech.retailscm.goodsshelf.CandidateGoodsShelf;

import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;






public class GoodsShelfStockCountManagerImpl extends CustomRetailscmCheckerManager implements GoodsShelfStockCountManager {
	
	private static final String SERVICE_TYPE = "GoodsShelfStockCount";
	
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
 
 		userContext.getChecker().checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		userContext.getChecker().throwExceptionIfHasErrors( GoodsShelfStockCountManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount( userContext, goodsShelfStockCountId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsShelfStockCount, tokens);
 	}
 	
 	
 	 public GoodsShelfStockCount searchGoodsShelfStockCount(RetailscmUserContext userContext, String goodsShelfStockCountId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		userContext.getChecker().throwExceptionIfHasErrors( GoodsShelfStockCountManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount( userContext, goodsShelfStockCountId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsShelfStockCount, tokens);
 	}
 	
 	

 	protected GoodsShelfStockCount present(RetailscmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsShelfStockCount,tokens);
		
		
		GoodsShelfStockCount  goodsShelfStockCountToPresent = userContext.getDAOGroup().getGoodsShelfStockCountDAO().present(goodsShelfStockCount, tokens);
		
		List<BaseEntity> entityListToNaming = goodsShelfStockCountToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getGoodsShelfStockCountDAO().alias(entityListToNaming);
		
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
 		return userContext.getDAOGroup().getGoodsShelfStockCountDAO().save(goodsShelfStockCount, tokens);
 	}
 	protected GoodsShelfStockCount loadGoodsShelfStockCount(RetailscmUserContext userContext, String goodsShelfStockCountId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		userContext.getChecker().throwExceptionIfHasErrors( GoodsShelfStockCountManagerException.class);

 
 		return userContext.getDAOGroup().getGoodsShelfStockCountDAO().load(goodsShelfStockCountId, tokens);
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
	
 	
 	
 
 	
 	


	public GoodsShelfStockCount createGoodsShelfStockCount(RetailscmUserContext userContext,String title, Date countTime, String summary, String shelfId) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfGoodsShelfStockCount(title);
		userContext.getChecker().checkCountTimeOfGoodsShelfStockCount(countTime);
		userContext.getChecker().checkSummaryOfGoodsShelfStockCount(summary);
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);


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
		

		
		
		userContext.getChecker().checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		userContext.getChecker().checkVersionOfGoodsShelfStockCount( goodsShelfStockCountVersion);
		

		if(GoodsShelfStockCount.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfGoodsShelfStockCount(parseString(newValueExpr));
		}
		if(GoodsShelfStockCount.COUNT_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkCountTimeOfGoodsShelfStockCount(parseDate(newValueExpr));
		}
		if(GoodsShelfStockCount.SUMMARY_PROPERTY.equals(property)){
			userContext.getChecker().checkSummaryOfGoodsShelfStockCount(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
	
		
	}
	
	
	
	public GoodsShelfStockCount clone(RetailscmUserContext userContext, String fromGoodsShelfStockCountId) throws Exception{
		
		return userContext.getDAOGroup().getGoodsShelfStockCountDAO().clone(fromGoodsShelfStockCountId, this.allTokens());
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
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsShelfStockCountTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherShelf(RetailscmUserContext userContext, String goodsShelfStockCountId, String anotherShelfId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
 		userContext.getChecker().checkIdOfGoodsShelf(anotherShelfId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
 		
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
		SmartList<GoodsShelf> candidateList = userContext.getDAOGroup().getGoodsShelfDAO().requestCandidateGoodsShelfForGoodsShelfStockCount(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected GoodsShelf loadGoodsShelf(RetailscmUserContext userContext, String newShelfId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getGoodsShelfDAO().load(newShelfId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String goodsShelfStockCountId, int goodsShelfStockCountVersion) throws Exception {
		//deleteInternal(userContext, goodsShelfStockCountId, goodsShelfStockCountVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String goodsShelfStockCountId, int goodsShelfStockCountVersion) throws Exception{
			
		userContext.getDAOGroup().getGoodsShelfStockCountDAO().delete(goodsShelfStockCountId, goodsShelfStockCountVersion);
	}
	
	public GoodsShelfStockCount forgetByAll(RetailscmUserContext userContext, String goodsShelfStockCountId, int goodsShelfStockCountVersion) throws Exception {
		return forgetByAllInternal(userContext, goodsShelfStockCountId, goodsShelfStockCountVersion);		
	}
	protected GoodsShelfStockCount forgetByAllInternal(RetailscmUserContext userContext,
			String goodsShelfStockCountId, int goodsShelfStockCountVersion) throws Exception{
			
		return userContext.getDAOGroup().getGoodsShelfStockCountDAO().disconnectFromAll(goodsShelfStockCountId, goodsShelfStockCountVersion);
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
		return userContext.getDAOGroup().getGoodsShelfStockCountDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingStockCountIssueTrack(RetailscmUserContext userContext, String goodsShelfStockCountId, String title, Date countTime, String summary,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);

		
		userContext.getChecker().checkTitleOfStockCountIssueTrack(title);
		
		userContext.getChecker().checkCountTimeOfStockCountIssueTrack(countTime);
		
		userContext.getChecker().checkSummaryOfStockCountIssueTrack(summary);
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);

	
	}
	public  GoodsShelfStockCount addStockCountIssueTrack(RetailscmUserContext userContext, String goodsShelfStockCountId, String title, Date countTime, String summary, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingStockCountIssueTrack(userContext,goodsShelfStockCountId,title, countTime, summary,tokensExpr);
		
		StockCountIssueTrack stockCountIssueTrack = createStockCountIssueTrack(userContext,title, countTime, summary);
		
		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
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
		
		userContext.getChecker().checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		userContext.getChecker().checkIdOfStockCountIssueTrack(id);
		
		userContext.getChecker().checkTitleOfStockCountIssueTrack( title);
		userContext.getChecker().checkCountTimeOfStockCountIssueTrack( countTime);
		userContext.getChecker().checkSummaryOfStockCountIssueTrack( summary);

		userContext.getChecker().throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
		
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
		
		userContext.getChecker().checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		for(String stockCountIssueTrackId: stockCountIssueTrackIds){
			userContext.getChecker().checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
		
	}
	public  GoodsShelfStockCount removeStockCountIssueTrackList(RetailscmUserContext userContext, String goodsShelfStockCountId, 
			String stockCountIssueTrackIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingStockCountIssueTrackList(userContext, goodsShelfStockCountId,  stockCountIssueTrackIds, tokensExpr);
			
			
			GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
			synchronized(goodsShelfStockCount){ 
				//Will be good when the goodsShelfStockCount loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getGoodsShelfStockCountDAO().planToRemoveStockCountIssueTrackList(goodsShelfStockCount, stockCountIssueTrackIds, allTokens());
				goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
				deleteRelationListInGraph(userContext, goodsShelfStockCount.getStockCountIssueTrackList());
				return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingStockCountIssueTrack(RetailscmUserContext userContext, String goodsShelfStockCountId, 
		String stockCountIssueTrackId, int stockCountIssueTrackVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfGoodsShelfStockCount( goodsShelfStockCountId);
		userContext.getChecker().checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		userContext.getChecker().checkVersionOfStockCountIssueTrack(stockCountIssueTrackVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
	
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
		
		userContext.getChecker().checkIdOfGoodsShelfStockCount( goodsShelfStockCountId);
		userContext.getChecker().checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		userContext.getChecker().checkVersionOfStockCountIssueTrack(stockCountIssueTrackVersion);
		userContext.getChecker().throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
	
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
		

		
		userContext.getChecker().checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
		userContext.getChecker().checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		userContext.getChecker().checkVersionOfStockCountIssueTrack(stockCountIssueTrackVersion);
		

		if(StockCountIssueTrack.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfStockCountIssueTrack(parseString(newValueExpr));
		}
		
		if(StockCountIssueTrack.COUNT_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkCountTimeOfStockCountIssueTrack(parseDate(newValueExpr));
		}
		
		if(StockCountIssueTrack.SUMMARY_PROPERTY.equals(property)){
			userContext.getChecker().checkSummaryOfStockCountIssueTrack(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
	
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

}


