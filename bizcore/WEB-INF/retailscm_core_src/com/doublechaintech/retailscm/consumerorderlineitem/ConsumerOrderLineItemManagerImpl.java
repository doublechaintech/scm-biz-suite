
package com.doublechaintech.retailscm.consumerorderlineitem;

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

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

import com.doublechaintech.retailscm.consumerorder.CandidateConsumerOrder;







public class ConsumerOrderLineItemManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderLineItemManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderLineItem";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ConsumerOrderLineItemManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderLineItemManagerException(message);

	}
	
	

 	protected ConsumerOrderLineItem saveConsumerOrderLineItem(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderLineItemDAO().save(consumerOrderLineItem, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens);
 	}
 	
 	protected ConsumerOrderLineItem saveConsumerOrderLineItemDetail(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem) throws Exception{	

 		
 		return saveConsumerOrderLineItem(userContext, consumerOrderLineItem, allTokens());
 	}
 	
 	public ConsumerOrderLineItem loadConsumerOrderLineItem(RetailscmUserContext userContext, String consumerOrderLineItemId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderLineItemManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem( userContext, consumerOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderLineItem, tokens);
 	}
 	
 	
 	 public ConsumerOrderLineItem searchConsumerOrderLineItem(RetailscmUserContext userContext, String consumerOrderLineItemId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderLineItemManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem( userContext, consumerOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderLineItem, tokens);
 	}
 	
 	

 	protected ConsumerOrderLineItem present(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderLineItem,tokens);
		
		
		ConsumerOrderLineItem  consumerOrderLineItemToPresent = userContext.getDAOGroup().getConsumerOrderLineItemDAO().present(consumerOrderLineItem, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderLineItemToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getConsumerOrderLineItemDAO().alias(entityListToNaming);
		
		return  consumerOrderLineItemToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderLineItem loadConsumerOrderLineItemDetail(RetailscmUserContext userContext, String consumerOrderLineItemId) throws Exception{	
 		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem( userContext, consumerOrderLineItemId, allTokens());
 		return present(userContext,consumerOrderLineItem, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String consumerOrderLineItemId) throws Exception{	
 		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem( userContext, consumerOrderLineItemId, viewTokens());
 		return present(userContext,consumerOrderLineItem, allTokens());
		
 	}
 	protected ConsumerOrderLineItem saveConsumerOrderLineItem(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getConsumerOrderLineItemDAO().save(consumerOrderLineItem, tokens);
 	}
 	protected ConsumerOrderLineItem loadConsumerOrderLineItem(RetailscmUserContext userContext, String consumerOrderLineItemId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderLineItemManagerException.class);

 
 		return userContext.getDAOGroup().getConsumerOrderLineItemDAO().load(consumerOrderLineItemId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderLineItem, tokens);
		
		addAction(userContext, consumerOrderLineItem, tokens,"@create","createConsumerOrderLineItem","createConsumerOrderLineItem/","main","primary");
		addAction(userContext, consumerOrderLineItem, tokens,"@update","updateConsumerOrderLineItem","updateConsumerOrderLineItem/"+consumerOrderLineItem.getId()+"/","main","primary");
		addAction(userContext, consumerOrderLineItem, tokens,"@copy","cloneConsumerOrderLineItem","cloneConsumerOrderLineItem/"+consumerOrderLineItem.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrderLineItem, tokens,"consumer_order_line_item.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderLineItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderLineItem createConsumerOrderLineItem(RetailscmUserContext userContext,String bizOrderId, String skuId, String skuName, BigDecimal price, BigDecimal quantity, BigDecimal amount) throws Exception
	{
		
		

		

		userContext.getChecker().checkSkuIdOfConsumerOrderLineItem(skuId);
		userContext.getChecker().checkSkuNameOfConsumerOrderLineItem(skuName);
		userContext.getChecker().checkPriceOfConsumerOrderLineItem(price);
		userContext.getChecker().checkQuantityOfConsumerOrderLineItem(quantity);
		userContext.getChecker().checkAmountOfConsumerOrderLineItem(amount);
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderLineItemManagerException.class);


		ConsumerOrderLineItem consumerOrderLineItem=createNewConsumerOrderLineItem();	

			
		ConsumerOrder bizOrder = loadConsumerOrder(userContext, bizOrderId,emptyOptions());
		consumerOrderLineItem.setBizOrder(bizOrder);
		
		
		consumerOrderLineItem.setSkuId(skuId);
		consumerOrderLineItem.setSkuName(skuName);
		consumerOrderLineItem.setPrice(price);
		consumerOrderLineItem.setQuantity(quantity);
		consumerOrderLineItem.setAmount(amount);

		consumerOrderLineItem = saveConsumerOrderLineItem(userContext, consumerOrderLineItem, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderLineItem);
		return consumerOrderLineItem;

		
	}
	protected ConsumerOrderLineItem createNewConsumerOrderLineItem() 
	{
		
		return new ConsumerOrderLineItem();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderLineItem(RetailscmUserContext userContext,String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
		userContext.getChecker().checkVersionOfConsumerOrderLineItem( consumerOrderLineItemVersion);
		
		

		
		if(ConsumerOrderLineItem.SKU_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkSkuIdOfConsumerOrderLineItem(parseString(newValueExpr));
		}
		if(ConsumerOrderLineItem.SKU_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkSkuNameOfConsumerOrderLineItem(parseString(newValueExpr));
		}
		if(ConsumerOrderLineItem.PRICE_PROPERTY.equals(property)){
			userContext.getChecker().checkPriceOfConsumerOrderLineItem(parseBigDecimal(newValueExpr));
		}
		if(ConsumerOrderLineItem.QUANTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkQuantityOfConsumerOrderLineItem(parseBigDecimal(newValueExpr));
		}
		if(ConsumerOrderLineItem.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfConsumerOrderLineItem(parseBigDecimal(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderLineItemManagerException.class);
	
		
	}
	
	
	
	public ConsumerOrderLineItem clone(RetailscmUserContext userContext, String fromConsumerOrderLineItemId) throws Exception{
		
		return userContext.getDAOGroup().getConsumerOrderLineItemDAO().clone(fromConsumerOrderLineItemId, this.allTokens());
	}
	
	public ConsumerOrderLineItem internalSaveConsumerOrderLineItem(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem) throws Exception 
	{
		return internalSaveConsumerOrderLineItem(userContext, consumerOrderLineItem, allTokens());

	}
	public ConsumerOrderLineItem internalSaveConsumerOrderLineItem(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingConsumerOrderLineItem(userContext, consumerOrderLineItemId, consumerOrderLineItemVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(consumerOrderLineItem){ 
			//will be good when the consumerOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderLineItem.
			
			
			consumerOrderLineItem = saveConsumerOrderLineItem(userContext, consumerOrderLineItem, options);
			return consumerOrderLineItem;
			
		}

	}
	
	public ConsumerOrderLineItem updateConsumerOrderLineItem(RetailscmUserContext userContext,String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderLineItem(userContext, consumerOrderLineItemId, consumerOrderLineItemVersion, property, newValueExpr, tokensExpr);
		
		
		
		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem(userContext, consumerOrderLineItemId, allTokens());
		if(consumerOrderLineItem.getVersion() != consumerOrderLineItemVersion){
			String message = "The target version("+consumerOrderLineItem.getVersion()+") is not equals to version("+consumerOrderLineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderLineItem){ 
			//will be good when the consumerOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderLineItem.
			
			consumerOrderLineItem.changeProperty(property, newValueExpr);
			consumerOrderLineItem = saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens().done());
			return present(userContext,consumerOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens().done());
		}

	}
	
	public ConsumerOrderLineItem updateConsumerOrderLineItemProperty(RetailscmUserContext userContext,String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderLineItem(userContext, consumerOrderLineItemId, consumerOrderLineItemVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem(userContext, consumerOrderLineItemId, allTokens());
		if(consumerOrderLineItem.getVersion() != consumerOrderLineItemVersion){
			String message = "The target version("+consumerOrderLineItem.getVersion()+") is not equals to version("+consumerOrderLineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderLineItem){ 
			//will be good when the consumerOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderLineItem.
			
			consumerOrderLineItem.changeProperty(property, newValueExpr);
			
			consumerOrderLineItem = saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens().done());
			return present(userContext,consumerOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderLineItem(userContext, consumerOrderLineItem, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderLineItemTokens tokens(){
		return ConsumerOrderLineItemTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderLineItemTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderLineItemTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfConsumerOrderLineItem(consumerOrderLineItemId);
 		userContext.getChecker().checkIdOfConsumerOrder(anotherBizOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderLineItemManagerException.class);
 		
 	}
 	public ConsumerOrderLineItem transferToAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderLineItemId,anotherBizOrderId);
 
		ConsumerOrderLineItem consumerOrderLineItem = loadConsumerOrderLineItem(userContext, consumerOrderLineItemId, allTokens());	
		synchronized(consumerOrderLineItem){
			//will be good when the consumerOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(userContext, anotherBizOrderId, emptyOptions());		
			consumerOrderLineItem.updateBizOrder(bizOrder);		
			consumerOrderLineItem = saveConsumerOrderLineItem(userContext, consumerOrderLineItem, emptyOptions());
			
			return present(userContext,consumerOrderLineItem, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateConsumerOrder requestCandidateBizOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateConsumerOrder result = new CandidateConsumerOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ConsumerOrder> candidateList = userContext.getDAOGroup().getConsumerOrderDAO().requestCandidateConsumerOrderForConsumerOrderLineItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected ConsumerOrder loadConsumerOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getConsumerOrderDAO().load(newBizOrderId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String consumerOrderLineItemId, int consumerOrderLineItemVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderLineItemId, consumerOrderLineItemVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderLineItemId, int consumerOrderLineItemVersion) throws Exception{
			
		userContext.getDAOGroup().getConsumerOrderLineItemDAO().delete(consumerOrderLineItemId, consumerOrderLineItemVersion);
	}
	
	public ConsumerOrderLineItem forgetByAll(RetailscmUserContext userContext, String consumerOrderLineItemId, int consumerOrderLineItemVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderLineItemId, consumerOrderLineItemVersion);		
	}
	protected ConsumerOrderLineItem forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderLineItemId, int consumerOrderLineItemVersion) throws Exception{
			
		return userContext.getDAOGroup().getConsumerOrderLineItemDAO().disconnectFromAll(consumerOrderLineItemId, consumerOrderLineItemVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderLineItemManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getConsumerOrderLineItemDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderLineItem newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


