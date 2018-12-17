
package com.doublechaintech.retailscm.stockcountissuetrack;

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

import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;

import com.doublechaintech.retailscm.goodsshelfstockcount.CandidateGoodsShelfStockCount;







public class StockCountIssueTrackManagerImpl extends CustomRetailscmCheckerManager implements StockCountIssueTrackManager {
	
	private static final String SERVICE_TYPE = "StockCountIssueTrack";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws StockCountIssueTrackManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new StockCountIssueTrackManagerException(message);

	}
	
	

 	protected StockCountIssueTrack saveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, String [] tokensExpr) throws Exception{	
 		//return getStockCountIssueTrackDAO().save(stockCountIssueTrack, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens);
 	}
 	
 	protected StockCountIssueTrack saveStockCountIssueTrackDetail(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack) throws Exception{	

 		
 		return saveStockCountIssueTrack(userContext, stockCountIssueTrack, allTokens());
 	}
 	
 	public StockCountIssueTrack loadStockCountIssueTrack(RetailscmUserContext userContext, String stockCountIssueTrackId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		userContext.getChecker().throwExceptionIfHasErrors( StockCountIssueTrackManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,stockCountIssueTrack, tokens);
 	}
 	
 	
 	 public StockCountIssueTrack searchStockCountIssueTrack(RetailscmUserContext userContext, String stockCountIssueTrackId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		userContext.getChecker().throwExceptionIfHasErrors( StockCountIssueTrackManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,stockCountIssueTrack, tokens);
 	}
 	
 	

 	protected StockCountIssueTrack present(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,stockCountIssueTrack,tokens);
		
		
		StockCountIssueTrack  stockCountIssueTrackToPresent = userContext.getDAOGroup().getStockCountIssueTrackDAO().present(stockCountIssueTrack, tokens);
		
		List<BaseEntity> entityListToNaming = stockCountIssueTrackToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getStockCountIssueTrackDAO().alias(entityListToNaming);
		
		return  stockCountIssueTrackToPresent;
		
		
	}
 
 	
 	
 	public StockCountIssueTrack loadStockCountIssueTrackDetail(RetailscmUserContext userContext, String stockCountIssueTrackId) throws Exception{	
 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, allTokens());
 		return present(userContext,stockCountIssueTrack, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String stockCountIssueTrackId) throws Exception{	
 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, viewTokens());
 		return present(userContext,stockCountIssueTrack, allTokens());
		
 	}
 	protected StockCountIssueTrack saveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getStockCountIssueTrackDAO().save(stockCountIssueTrack, tokens);
 	}
 	protected StockCountIssueTrack loadStockCountIssueTrack(RetailscmUserContext userContext, String stockCountIssueTrackId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		userContext.getChecker().throwExceptionIfHasErrors( StockCountIssueTrackManagerException.class);

 
 		return userContext.getDAOGroup().getStockCountIssueTrackDAO().load(stockCountIssueTrackId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String, Object> tokens){
		super.addActions(userContext, stockCountIssueTrack, tokens);
		
		addAction(userContext, stockCountIssueTrack, tokens,"@create","createStockCountIssueTrack","createStockCountIssueTrack/","main","primary");
		addAction(userContext, stockCountIssueTrack, tokens,"@update","updateStockCountIssueTrack","updateStockCountIssueTrack/"+stockCountIssueTrack.getId()+"/","main","primary");
		addAction(userContext, stockCountIssueTrack, tokens,"@copy","cloneStockCountIssueTrack","cloneStockCountIssueTrack/"+stockCountIssueTrack.getId()+"/","main","primary");
		
		addAction(userContext, stockCountIssueTrack, tokens,"stock_count_issue_track.transfer_to_stock_count","transferToAnotherStockCount","transferToAnotherStockCount/"+stockCountIssueTrack.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public StockCountIssueTrack createStockCountIssueTrack(RetailscmUserContext userContext,String title, Date countTime, String summary, String stockCountId) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfStockCountIssueTrack(title);
		userContext.getChecker().checkCountTimeOfStockCountIssueTrack(countTime);
		userContext.getChecker().checkSummaryOfStockCountIssueTrack(summary);
	
		userContext.getChecker().throwExceptionIfHasErrors(StockCountIssueTrackManagerException.class);


		StockCountIssueTrack stockCountIssueTrack=createNewStockCountIssueTrack();	

		stockCountIssueTrack.setTitle(title);
		stockCountIssueTrack.setCountTime(countTime);
		stockCountIssueTrack.setSummary(summary);
			
		GoodsShelfStockCount stockCount = loadGoodsShelfStockCount(userContext, stockCountId,emptyOptions());
		stockCountIssueTrack.setStockCount(stockCount);
		
		

		stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, emptyOptions());
		
		onNewInstanceCreated(userContext, stockCountIssueTrack);
		return stockCountIssueTrack;

		
	}
	protected StockCountIssueTrack createNewStockCountIssueTrack() 
	{
		
		return new StockCountIssueTrack();		
	}
	
	protected void checkParamsForUpdatingStockCountIssueTrack(RetailscmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		userContext.getChecker().checkVersionOfStockCountIssueTrack( stockCountIssueTrackVersion);
		

		if(StockCountIssueTrack.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfStockCountIssueTrack(parseString(newValueExpr));
		}
		if(StockCountIssueTrack.COUNT_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkCountTimeOfStockCountIssueTrack(parseDate(newValueExpr));
		}
		if(StockCountIssueTrack.SUMMARY_PROPERTY.equals(property)){
			userContext.getChecker().checkSummaryOfStockCountIssueTrack(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(StockCountIssueTrackManagerException.class);
	
		
	}
	
	
	
	public StockCountIssueTrack clone(RetailscmUserContext userContext, String fromStockCountIssueTrackId) throws Exception{
		
		return userContext.getDAOGroup().getStockCountIssueTrackDAO().clone(fromStockCountIssueTrackId, this.allTokens());
	}
	
	public StockCountIssueTrack internalSaveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack) throws Exception 
	{
		return internalSaveStockCountIssueTrack(userContext, stockCountIssueTrack, allTokens());

	}
	public StockCountIssueTrack internalSaveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingStockCountIssueTrack(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(stockCountIssueTrack){ 
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StockCountIssueTrack.
			
			
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, options);
			return stockCountIssueTrack;
			
		}

	}
	
	public StockCountIssueTrack updateStockCountIssueTrack(RetailscmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingStockCountIssueTrack(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion, property, newValueExpr, tokensExpr);
		
		
		
		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack(userContext, stockCountIssueTrackId, allTokens());
		if(stockCountIssueTrack.getVersion() != stockCountIssueTrackVersion){
			String message = "The target version("+stockCountIssueTrack.getVersion()+") is not equals to version("+stockCountIssueTrackVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(stockCountIssueTrack){ 
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StockCountIssueTrack.
			
			stockCountIssueTrack.changeProperty(property, newValueExpr);
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
			return present(userContext,stockCountIssueTrack, mergedAllTokens(tokensExpr));
			//return saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
		}

	}
	
	public StockCountIssueTrack updateStockCountIssueTrackProperty(RetailscmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingStockCountIssueTrack(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion, property, newValueExpr, tokensExpr);
		
		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack(userContext, stockCountIssueTrackId, allTokens());
		if(stockCountIssueTrack.getVersion() != stockCountIssueTrackVersion){
			String message = "The target version("+stockCountIssueTrack.getVersion()+") is not equals to version("+stockCountIssueTrackVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(stockCountIssueTrack){ 
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StockCountIssueTrack.
			
			stockCountIssueTrack.changeProperty(property, newValueExpr);
			
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
			return present(userContext,stockCountIssueTrack, mergedAllTokens(tokensExpr));
			//return saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected StockCountIssueTrackTokens tokens(){
		return StockCountIssueTrackTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return StockCountIssueTrackTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return StockCountIssueTrackTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherStockCount(RetailscmUserContext userContext, String stockCountIssueTrackId, String anotherStockCountId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
 		userContext.getChecker().checkIdOfGoodsShelfStockCount(anotherStockCountId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(StockCountIssueTrackManagerException.class);
 		
 	}
 	public StockCountIssueTrack transferToAnotherStockCount(RetailscmUserContext userContext, String stockCountIssueTrackId, String anotherStockCountId) throws Exception
 	{
 		checkParamsForTransferingAnotherStockCount(userContext, stockCountIssueTrackId,anotherStockCountId);
 
		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack(userContext, stockCountIssueTrackId, allTokens());	
		synchronized(stockCountIssueTrack){
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsShelfStockCount stockCount = loadGoodsShelfStockCount(userContext, anotherStockCountId, emptyOptions());		
			stockCountIssueTrack.updateStockCount(stockCount);		
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, emptyOptions());
			
			return present(userContext,stockCountIssueTrack, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateGoodsShelfStockCount requestCandidateStockCount(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGoodsShelfStockCount result = new CandidateGoodsShelfStockCount();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GoodsShelfStockCount> candidateList = userContext.getDAOGroup().getGoodsShelfStockCountDAO().requestCandidateGoodsShelfStockCountForStockCountIssueTrack(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected GoodsShelfStockCount loadGoodsShelfStockCount(RetailscmUserContext userContext, String newStockCountId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getGoodsShelfStockCountDAO().load(newStockCountId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception {
		//deleteInternal(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception{
			
		userContext.getDAOGroup().getStockCountIssueTrackDAO().delete(stockCountIssueTrackId, stockCountIssueTrackVersion);
	}
	
	public StockCountIssueTrack forgetByAll(RetailscmUserContext userContext, String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception {
		return forgetByAllInternal(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion);		
	}
	protected StockCountIssueTrack forgetByAllInternal(RetailscmUserContext userContext,
			String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception{
			
		return userContext.getDAOGroup().getStockCountIssueTrackDAO().disconnectFromAll(stockCountIssueTrackId, stockCountIssueTrackVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new StockCountIssueTrackManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getStockCountIssueTrackDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, StockCountIssueTrack newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


