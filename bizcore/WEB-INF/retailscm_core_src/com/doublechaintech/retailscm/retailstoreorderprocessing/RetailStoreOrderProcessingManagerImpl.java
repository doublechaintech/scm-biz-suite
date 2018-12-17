
package com.doublechaintech.retailscm.retailstoreorderprocessing;

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


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.doublechaintech.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.doublechaintech.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.doublechaintech.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.doublechaintech.retailscm.retailstoreordershipment.RetailStoreOrderShipment;






public class RetailStoreOrderProcessingManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderProcessingManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderProcessing";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderProcessingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderProcessingManagerException(message);

	}
	
	

 	protected RetailStoreOrderProcessing saveRetailStoreOrderProcessing(RetailscmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderProcessingDAO().save(retailStoreOrderProcessing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens);
 	}
 	
 	protected RetailStoreOrderProcessing saveRetailStoreOrderProcessingDetail(RetailscmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing) throws Exception{	

 		
 		return saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, allTokens());
 	}
 	
 	public RetailStoreOrderProcessing loadRetailStoreOrderProcessing(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderProcessing(retailStoreOrderProcessingId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderProcessingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing( userContext, retailStoreOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderProcessing, tokens);
 	}
 	
 	
 	 public RetailStoreOrderProcessing searchRetailStoreOrderProcessing(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderProcessing(retailStoreOrderProcessingId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderProcessingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing( userContext, retailStoreOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderProcessing, tokens);
 	}
 	
 	

 	protected RetailStoreOrderProcessing present(RetailscmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderProcessing,tokens);
		
		
		RetailStoreOrderProcessing  retailStoreOrderProcessingToPresent = userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().present(retailStoreOrderProcessing, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderProcessingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().alias(entityListToNaming);
		
		return  retailStoreOrderProcessingToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderProcessing loadRetailStoreOrderProcessingDetail(RetailscmUserContext userContext, String retailStoreOrderProcessingId) throws Exception{	
 		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing( userContext, retailStoreOrderProcessingId, allTokens());
 		return present(userContext,retailStoreOrderProcessing, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderProcessingId) throws Exception{	
 		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing( userContext, retailStoreOrderProcessingId, viewTokens());
 		return present(userContext,retailStoreOrderProcessing, allTokens());
		
 	}
 	protected RetailStoreOrderProcessing saveRetailStoreOrderProcessing(RetailscmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().save(retailStoreOrderProcessing, tokens);
 	}
 	protected RetailStoreOrderProcessing loadRetailStoreOrderProcessing(RetailscmUserContext userContext, String retailStoreOrderProcessingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreOrderProcessing(retailStoreOrderProcessingId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderProcessingManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().load(retailStoreOrderProcessingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderProcessing, tokens);
		
		addAction(userContext, retailStoreOrderProcessing, tokens,"@create","createRetailStoreOrderProcessing","createRetailStoreOrderProcessing/","main","primary");
		addAction(userContext, retailStoreOrderProcessing, tokens,"@update","updateRetailStoreOrderProcessing","updateRetailStoreOrderProcessing/"+retailStoreOrderProcessing.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderProcessing, tokens,"@copy","cloneRetailStoreOrderProcessing","cloneRetailStoreOrderProcessing/"+retailStoreOrderProcessing.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderProcessing, tokens,"retail_store_order_processing.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderProcessing.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderProcessing, tokens,"retail_store_order_processing.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderProcessing.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderProcessing, tokens,"retail_store_order_processing.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderProcessing.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderProcessing, tokens,"retail_store_order_processing.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderProcessing.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderProcessing createRetailStoreOrderProcessing(RetailscmUserContext userContext,String who, Date processTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfRetailStoreOrderProcessing(who);
		userContext.getChecker().checkProcessTimeOfRetailStoreOrderProcessing(processTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderProcessingManagerException.class);


		RetailStoreOrderProcessing retailStoreOrderProcessing=createNewRetailStoreOrderProcessing();	

		retailStoreOrderProcessing.setWho(who);
		retailStoreOrderProcessing.setProcessTime(processTime);

		retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderProcessing);
		return retailStoreOrderProcessing;

		
	}
	protected RetailStoreOrderProcessing createNewRetailStoreOrderProcessing() 
	{
		
		return new RetailStoreOrderProcessing();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderProcessing(RetailscmUserContext userContext,String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrderProcessing(retailStoreOrderProcessingId);
		userContext.getChecker().checkVersionOfRetailStoreOrderProcessing( retailStoreOrderProcessingVersion);
		

		if(RetailStoreOrderProcessing.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfRetailStoreOrderProcessing(parseString(newValueExpr));
		}
		if(RetailStoreOrderProcessing.PROCESS_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkProcessTimeOfRetailStoreOrderProcessing(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderProcessingManagerException.class);
	
		
	}
	
	
	
	public RetailStoreOrderProcessing clone(RetailscmUserContext userContext, String fromRetailStoreOrderProcessingId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().clone(fromRetailStoreOrderProcessingId, this.allTokens());
	}
	
	public RetailStoreOrderProcessing internalSaveRetailStoreOrderProcessing(RetailscmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing) throws Exception 
	{
		return internalSaveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, allTokens());

	}
	public RetailStoreOrderProcessing internalSaveRetailStoreOrderProcessing(RetailscmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, retailStoreOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreOrderProcessing){ 
			//will be good when the retailStoreOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderProcessing.
			
			
			retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, options);
			return retailStoreOrderProcessing;
			
		}

	}
	
	public RetailStoreOrderProcessing updateRetailStoreOrderProcessing(RetailscmUserContext userContext,String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, retailStoreOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());
		if(retailStoreOrderProcessing.getVersion() != retailStoreOrderProcessingVersion){
			String message = "The target version("+retailStoreOrderProcessing.getVersion()+") is not equals to version("+retailStoreOrderProcessingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderProcessing){ 
			//will be good when the retailStoreOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderProcessing.
			
			retailStoreOrderProcessing.changeProperty(property, newValueExpr);
			retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().done());
			return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().done());
		}

	}
	
	public RetailStoreOrderProcessing updateRetailStoreOrderProcessingProperty(RetailscmUserContext userContext,String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, retailStoreOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());
		if(retailStoreOrderProcessing.getVersion() != retailStoreOrderProcessingVersion){
			String message = "The target version("+retailStoreOrderProcessing.getVersion()+") is not equals to version("+retailStoreOrderProcessingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderProcessing){ 
			//will be good when the retailStoreOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderProcessing.
			
			retailStoreOrderProcessing.changeProperty(property, newValueExpr);
			
			retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().done());
			return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderProcessingTokens tokens(){
		return RetailStoreOrderProcessingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderProcessingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreOrderListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderProcessingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderProcessingId, retailStoreOrderProcessingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().delete(retailStoreOrderProcessingId, retailStoreOrderProcessingVersion);
	}
	
	public RetailStoreOrderProcessing forgetByAll(RetailscmUserContext userContext, String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderProcessingId, retailStoreOrderProcessingVersion);		
	}
	protected RetailStoreOrderProcessing forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().disconnectFromAll(retailStoreOrderProcessingId, retailStoreOrderProcessingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderProcessingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().deleteAll();
	}


	//disconnect RetailStoreOrderProcessing with buyer in RetailStoreOrder
	protected RetailStoreOrderProcessing breakWithRetailStoreOrderByBuyer(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String buyerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());

			synchronized(retailStoreOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().planToRemoveRetailStoreOrderListWithBuyer(retailStoreOrderProcessing, buyerId, this.emptyOptions());

				retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderProcessing;
			}
	}
	//disconnect RetailStoreOrderProcessing with seller in RetailStoreOrder
	protected RetailStoreOrderProcessing breakWithRetailStoreOrderBySeller(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());

			synchronized(retailStoreOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().planToRemoveRetailStoreOrderListWithSeller(retailStoreOrderProcessing, sellerId, this.emptyOptions());

				retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderProcessing;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrderProcessing(retailStoreOrderProcessingId);

		
		userContext.getChecker().checkBuyerIdOfRetailStoreOrder(buyerId);
		
		userContext.getChecker().checkSellerIdOfRetailStoreOrder(sellerId);
		
		userContext.getChecker().checkTitleOfRetailStoreOrder(title);
		
		userContext.getChecker().checkTotalAmountOfRetailStoreOrder(totalAmount);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderProcessingManagerException.class);

	
	}
	public  RetailStoreOrderProcessing addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderProcessingId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());
		synchronized(retailStoreOrderProcessing){ 
			//Will be good when the retailStoreOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderProcessing.addRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderProcessingId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrderProcessing(retailStoreOrderProcessingId);
		userContext.getChecker().checkIdOfRetailStoreOrder(id);
		
		userContext.getChecker().checkTitleOfRetailStoreOrder( title);
		userContext.getChecker().checkTotalAmountOfRetailStoreOrder( totalAmount);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderProcessingManagerException.class);
		
	}
	public  RetailStoreOrderProcessing updateRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreOrderProperties(userContext,retailStoreOrderProcessingId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderListList()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "is", id).done();
		
		RetailStoreOrderProcessing retailStoreOrderProcessingToUpdate = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, options);
		
		if(retailStoreOrderProcessingToUpdate.getRetailStoreOrderList().isEmpty()){
			throw new RetailStoreOrderProcessingManagerException("RetailStoreOrder is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreOrder item = retailStoreOrderProcessingToUpdate.getRetailStoreOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderProcessingId,name, code, used,tokensExpr);
		RetailStoreOrderProcessing retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingToUpdate, tokens().withRetailStoreOrderList().done());
		synchronized(retailStoreOrderProcessing){ 
			return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RetailStoreOrder createRetailStoreOrder(RetailscmUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount) throws Exception{

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		
		
		RetailStore  buyer = new RetailStore();
		buyer.setId(buyerId);		
		retailStoreOrder.setBuyer(buyer);		
		RetailStoreCountryCenter  seller = new RetailStoreCountryCenter();
		seller.setId(sellerId);		
		retailStoreOrder.setSeller(seller);		
		retailStoreOrder.setTitle(title);		
		retailStoreOrder.setTotalAmount(totalAmount);		
		retailStoreOrder.setLastUpdateTime(userContext.now());		
		retailStoreOrder.setCurrentStatus("INIT");
	
		
		return retailStoreOrder;
	
		
	}
	
	protected RetailStoreOrder createIndexedRetailStoreOrder(String id, int version){

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(id);
		retailStoreOrder.setVersion(version);
		return retailStoreOrder;			
		
	}
	
	protected void checkParamsForRemovingRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderProcessingId, 
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrderProcessing(retailStoreOrderProcessingId);
		for(String retailStoreOrderId: retailStoreOrderIds){
			userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderProcessingManagerException.class);
		
	}
	public  RetailStoreOrderProcessing removeRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderProcessingId, 
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreOrderList(userContext, retailStoreOrderProcessingId,  retailStoreOrderIds, tokensExpr);
			
			
			RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());
			synchronized(retailStoreOrderProcessing){ 
				//Will be good when the retailStoreOrderProcessing loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().planToRemoveRetailStoreOrderList(retailStoreOrderProcessing, retailStoreOrderIds, allTokens());
				retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().withRetailStoreOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreOrderProcessing.getRetailStoreOrderList());
				return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrderProcessing( retailStoreOrderProcessingId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderProcessingManagerException.class);
	
	}
	public  RetailStoreOrderProcessing removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderProcessingId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());
		synchronized(retailStoreOrderProcessing){ 
			//Will be good when the retailStoreOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderProcessing.removeRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().withRetailStoreOrderList().done());
			deleteRelationInGraph(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrderProcessing( retailStoreOrderProcessingId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderProcessingManagerException.class);
	
	}
	public  RetailStoreOrderProcessing copyRetailStoreOrderFrom(RetailscmUserContext userContext, String retailStoreOrderProcessingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderProcessingId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, allTokens());
		synchronized(retailStoreOrderProcessing){ 
			//Will be good when the retailStoreOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			
			retailStoreOrderProcessing.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, (RetailStoreOrder)retailStoreOrderProcessing.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreOrderProcessing(retailStoreOrderProcessingId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderProcessingManagerException.class);
	
	}
	
	public  RetailStoreOrderProcessing updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderProcessingId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderList().searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "eq", retailStoreOrderId).done();
		
		
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, loadTokens);
		
		synchronized(retailStoreOrderProcessing){ 
			//Will be good when the retailStoreOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderProcessing.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStoreOrderProcessing.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderProcessingManagerException(retailStoreOrder+" is NOT FOUND" );
			}
			
			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStoreOrderProcessing = saveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderProcessing, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStoreOrderProcessing associateRetailStoreOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, options);
		
		RetailStoreOrderConfirmation confirmation = userContext.getManagerGroup().getRetailStoreOrderConfirmationManager().createRetailStoreOrderConfirmation(userContext,  who,  confirmTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderProcessing.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing);
	}	public  RetailStoreOrderProcessing associateRetailStoreOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, options);
		
		RetailStoreOrderApproval approval = userContext.getManagerGroup().getRetailStoreOrderApprovalManager().createRetailStoreOrderApproval(userContext,  who,  approveTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderProcessing.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateApproval(approval);
		}
		return this.internalSaveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing);
	}	public  RetailStoreOrderProcessing associateRetailStoreOrderListToNewPicking(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, options);
		
		RetailStoreOrderPicking picking = userContext.getManagerGroup().getRetailStoreOrderPickingManager().createRetailStoreOrderPicking(userContext,  who,  processTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderProcessing.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updatePicking(picking);
		}
		return this.internalSaveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing);
	}	public  RetailStoreOrderProcessing associateRetailStoreOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, options);
		
		RetailStoreOrderShipment shipment = userContext.getManagerGroup().getRetailStoreOrderShipmentManager().createRetailStoreOrderShipment(userContext,  who,  shipTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderProcessing.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing);
	}	public  RetailStoreOrderProcessing associateRetailStoreOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, options);
		
		RetailStoreOrderDelivery delivery = userContext.getManagerGroup().getRetailStoreOrderDeliveryManager().createRetailStoreOrderDelivery(userContext,  who,  deliveryTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderProcessing.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateDelivery(delivery);
		}
		return this.internalSaveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing);
	}
	*/
	
	public  RetailStoreOrderProcessing associateRetailStoreOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, options);
		
		RetailStoreOrderConfirmation confirmation = userContext.getManagerGroup().getRetailStoreOrderConfirmationManager().loadRetailStoreOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderProcessing.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing);
	}	public  RetailStoreOrderProcessing associateRetailStoreOrderListToApproval(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, options);
		
		RetailStoreOrderApproval approval = userContext.getManagerGroup().getRetailStoreOrderApprovalManager().loadRetailStoreOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderProcessing.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateApproval(approval);
		}
		return this.internalSaveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing);
	}	public  RetailStoreOrderProcessing associateRetailStoreOrderListToPicking(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String pickingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, options);
		
		RetailStoreOrderPicking picking = userContext.getManagerGroup().getRetailStoreOrderPickingManager().loadRetailStoreOrderPicking(userContext,pickingId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderProcessing.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updatePicking(picking);
		}
		return this.internalSaveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing);
	}	public  RetailStoreOrderProcessing associateRetailStoreOrderListToShipment(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, options);
		
		RetailStoreOrderShipment shipment = userContext.getManagerGroup().getRetailStoreOrderShipmentManager().loadRetailStoreOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderProcessing.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing);
	}	public  RetailStoreOrderProcessing associateRetailStoreOrderListToDelivery(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadRetailStoreOrderProcessing(userContext, retailStoreOrderProcessingId, options);
		
		RetailStoreOrderDelivery delivery = userContext.getManagerGroup().getRetailStoreOrderDeliveryManager().loadRetailStoreOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderProcessing.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateDelivery(delivery);
		}
		return this.internalSaveRetailStoreOrderProcessing(userContext, retailStoreOrderProcessing);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderProcessing newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


