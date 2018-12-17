
package com.doublechaintech.retailscm.retailstoreorderlineitem;

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

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.retailstoreorder.CandidateRetailStoreOrder;







public class RetailStoreOrderLineItemManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderLineItemManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderLineItem";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderLineItemManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderLineItemManagerException(message);

	}
	
	

 	protected RetailStoreOrderLineItem saveRetailStoreOrderLineItem(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderLineItemDAO().save(retailStoreOrderLineItem, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens);
 	}
 	
 	protected RetailStoreOrderLineItem saveRetailStoreOrderLineItemDetail(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem) throws Exception{	

 		
 		return saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, allTokens());
 	}
 	
 	public RetailStoreOrderLineItem loadRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderLineItemId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderLineItemManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem( userContext, retailStoreOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderLineItem, tokens);
 	}
 	
 	
 	 public RetailStoreOrderLineItem searchRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderLineItemId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderLineItemManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem( userContext, retailStoreOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderLineItem, tokens);
 	}
 	
 	

 	protected RetailStoreOrderLineItem present(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderLineItem,tokens);
		
		
		RetailStoreOrderLineItem  retailStoreOrderLineItemToPresent = userContext.getDAOGroup().getRetailStoreOrderLineItemDAO().present(retailStoreOrderLineItem, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderLineItemToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreOrderLineItemDAO().alias(entityListToNaming);
		
		return  retailStoreOrderLineItemToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderLineItem loadRetailStoreOrderLineItemDetail(RetailscmUserContext userContext, String retailStoreOrderLineItemId) throws Exception{	
 		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem( userContext, retailStoreOrderLineItemId, allTokens());
 		return present(userContext,retailStoreOrderLineItem, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderLineItemId) throws Exception{	
 		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem( userContext, retailStoreOrderLineItemId, viewTokens());
 		return present(userContext,retailStoreOrderLineItem, allTokens());
		
 	}
 	protected RetailStoreOrderLineItem saveRetailStoreOrderLineItem(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreOrderLineItemDAO().save(retailStoreOrderLineItem, tokens);
 	}
 	protected RetailStoreOrderLineItem loadRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderLineItemId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderLineItemManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreOrderLineItemDAO().load(retailStoreOrderLineItemId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderLineItem, tokens);
		
		addAction(userContext, retailStoreOrderLineItem, tokens,"@create","createRetailStoreOrderLineItem","createRetailStoreOrderLineItem/","main","primary");
		addAction(userContext, retailStoreOrderLineItem, tokens,"@update","updateRetailStoreOrderLineItem","updateRetailStoreOrderLineItem/"+retailStoreOrderLineItem.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderLineItem, tokens,"@copy","cloneRetailStoreOrderLineItem","cloneRetailStoreOrderLineItem/"+retailStoreOrderLineItem.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderLineItem, tokens,"retail_store_order_line_item.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreOrderLineItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderLineItem createRetailStoreOrderLineItem(RetailscmUserContext userContext,String bizOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement) throws Exception
	{
		
		

		

		userContext.getChecker().checkSkuIdOfRetailStoreOrderLineItem(skuId);
		userContext.getChecker().checkSkuNameOfRetailStoreOrderLineItem(skuName);
		userContext.getChecker().checkAmountOfRetailStoreOrderLineItem(amount);
		userContext.getChecker().checkQuantityOfRetailStoreOrderLineItem(quantity);
		userContext.getChecker().checkUnitOfMeasurementOfRetailStoreOrderLineItem(unitOfMeasurement);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderLineItemManagerException.class);


		RetailStoreOrderLineItem retailStoreOrderLineItem=createNewRetailStoreOrderLineItem();	

			
		RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, bizOrderId,emptyOptions());
		retailStoreOrderLineItem.setBizOrder(bizOrder);
		
		
		retailStoreOrderLineItem.setSkuId(skuId);
		retailStoreOrderLineItem.setSkuName(skuName);
		retailStoreOrderLineItem.setAmount(amount);
		retailStoreOrderLineItem.setQuantity(quantity);
		retailStoreOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);

		retailStoreOrderLineItem = saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderLineItem);
		return retailStoreOrderLineItem;

		
	}
	protected RetailStoreOrderLineItem createNewRetailStoreOrderLineItem() 
	{
		
		return new RetailStoreOrderLineItem();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderLineItem(RetailscmUserContext userContext,String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
		userContext.getChecker().checkVersionOfRetailStoreOrderLineItem( retailStoreOrderLineItemVersion);
		
		

		
		if(RetailStoreOrderLineItem.SKU_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkSkuIdOfRetailStoreOrderLineItem(parseString(newValueExpr));
		}
		if(RetailStoreOrderLineItem.SKU_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkSkuNameOfRetailStoreOrderLineItem(parseString(newValueExpr));
		}
		if(RetailStoreOrderLineItem.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfRetailStoreOrderLineItem(parseBigDecimal(newValueExpr));
		}
		if(RetailStoreOrderLineItem.QUANTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkQuantityOfRetailStoreOrderLineItem(parseInt(newValueExpr));
		}
		if(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkUnitOfMeasurementOfRetailStoreOrderLineItem(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderLineItemManagerException.class);
	
		
	}
	
	
	
	public RetailStoreOrderLineItem clone(RetailscmUserContext userContext, String fromRetailStoreOrderLineItemId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreOrderLineItemDAO().clone(fromRetailStoreOrderLineItemId, this.allTokens());
	}
	
	public RetailStoreOrderLineItem internalSaveRetailStoreOrderLineItem(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem) throws Exception 
	{
		return internalSaveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, allTokens());

	}
	public RetailStoreOrderLineItem internalSaveRetailStoreOrderLineItem(RetailscmUserContext userContext, RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreOrderLineItem){ 
			//will be good when the retailStoreOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderLineItem.
			
			
			retailStoreOrderLineItem = saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, options);
			return retailStoreOrderLineItem;
			
		}

	}
	
	public RetailStoreOrderLineItem updateRetailStoreOrderLineItem(RetailscmUserContext userContext,String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, allTokens());
		if(retailStoreOrderLineItem.getVersion() != retailStoreOrderLineItemVersion){
			String message = "The target version("+retailStoreOrderLineItem.getVersion()+") is not equals to version("+retailStoreOrderLineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderLineItem){ 
			//will be good when the retailStoreOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderLineItem.
			
			retailStoreOrderLineItem.changeProperty(property, newValueExpr);
			retailStoreOrderLineItem = saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens().done());
			return present(userContext,retailStoreOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens().done());
		}

	}
	
	public RetailStoreOrderLineItem updateRetailStoreOrderLineItemProperty(RetailscmUserContext userContext,String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, allTokens());
		if(retailStoreOrderLineItem.getVersion() != retailStoreOrderLineItemVersion){
			String message = "The target version("+retailStoreOrderLineItem.getVersion()+") is not equals to version("+retailStoreOrderLineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderLineItem){ 
			//will be good when the retailStoreOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderLineItem.
			
			retailStoreOrderLineItem.changeProperty(property, newValueExpr);
			
			retailStoreOrderLineItem = saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens().done());
			return present(userContext,retailStoreOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderLineItemTokens tokens(){
		return RetailStoreOrderLineItemTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderLineItemTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderLineItemTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
 		userContext.getChecker().checkIdOfRetailStoreOrder(anotherBizOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderLineItemManagerException.class);
 		
 	}
 	public RetailStoreOrderLineItem transferToAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreOrderLineItemId,anotherBizOrderId);
 
		RetailStoreOrderLineItem retailStoreOrderLineItem = loadRetailStoreOrderLineItem(userContext, retailStoreOrderLineItemId, allTokens());	
		synchronized(retailStoreOrderLineItem){
			//will be good when the retailStoreOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, anotherBizOrderId, emptyOptions());		
			retailStoreOrderLineItem.updateBizOrder(bizOrder);		
			retailStoreOrderLineItem = saveRetailStoreOrderLineItem(userContext, retailStoreOrderLineItem, emptyOptions());
			
			return present(userContext,retailStoreOrderLineItem, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreOrder requestCandidateBizOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOrder result = new CandidateRetailStoreOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("buyer");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOrder> candidateList = userContext.getDAOGroup().getRetailStoreOrderDAO().requestCandidateRetailStoreOrderForRetailStoreOrderLineItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreOrder loadRetailStoreOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreOrderDAO().load(newBizOrderId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreOrderLineItemDAO().delete(retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
	}
	
	public RetailStoreOrderLineItem forgetByAll(RetailscmUserContext userContext, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);		
	}
	protected RetailStoreOrderLineItem forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreOrderLineItemDAO().disconnectFromAll(retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderLineItemManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreOrderLineItemDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderLineItem newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


