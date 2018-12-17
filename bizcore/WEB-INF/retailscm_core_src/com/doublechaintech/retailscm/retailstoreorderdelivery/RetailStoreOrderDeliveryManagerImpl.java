
package com.doublechaintech.retailscm.retailstoreorderdelivery;

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






public class RetailStoreOrderDeliveryManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderDeliveryManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderDelivery";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderDeliveryManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderDeliveryManagerException(message);

	}
	
	

 	protected RetailStoreOrderDelivery saveRetailStoreOrderDelivery(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderDeliveryDAO().save(retailStoreOrderDelivery, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens);
 	}
 	
 	protected RetailStoreOrderDelivery saveRetailStoreOrderDeliveryDetail(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery) throws Exception{	

 		
 		return saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, allTokens());
 	}
 	
 	public RetailStoreOrderDelivery loadRetailStoreOrderDelivery(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderDeliveryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery( userContext, retailStoreOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderDelivery, tokens);
 	}
 	
 	
 	 public RetailStoreOrderDelivery searchRetailStoreOrderDelivery(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderDeliveryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery( userContext, retailStoreOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderDelivery, tokens);
 	}
 	
 	

 	protected RetailStoreOrderDelivery present(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderDelivery,tokens);
		
		
		RetailStoreOrderDelivery  retailStoreOrderDeliveryToPresent = userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().present(retailStoreOrderDelivery, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderDeliveryToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().alias(entityListToNaming);
		
		return  retailStoreOrderDeliveryToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderDelivery loadRetailStoreOrderDeliveryDetail(RetailscmUserContext userContext, String retailStoreOrderDeliveryId) throws Exception{	
 		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery( userContext, retailStoreOrderDeliveryId, allTokens());
 		return present(userContext,retailStoreOrderDelivery, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderDeliveryId) throws Exception{	
 		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery( userContext, retailStoreOrderDeliveryId, viewTokens());
 		return present(userContext,retailStoreOrderDelivery, allTokens());
		
 	}
 	protected RetailStoreOrderDelivery saveRetailStoreOrderDelivery(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().save(retailStoreOrderDelivery, tokens);
 	}
 	protected RetailStoreOrderDelivery loadRetailStoreOrderDelivery(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderDeliveryManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().load(retailStoreOrderDeliveryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderDelivery, tokens);
		
		addAction(userContext, retailStoreOrderDelivery, tokens,"@create","createRetailStoreOrderDelivery","createRetailStoreOrderDelivery/","main","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"@update","updateRetailStoreOrderDelivery","updateRetailStoreOrderDelivery/"+retailStoreOrderDelivery.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"@copy","cloneRetailStoreOrderDelivery","cloneRetailStoreOrderDelivery/"+retailStoreOrderDelivery.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderDelivery, tokens,"retail_store_order_delivery.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderDelivery.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"retail_store_order_delivery.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderDelivery.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"retail_store_order_delivery.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderDelivery.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderDelivery, tokens,"retail_store_order_delivery.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderDelivery.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderDelivery createRetailStoreOrderDelivery(RetailscmUserContext userContext,String who, Date deliveryTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfRetailStoreOrderDelivery(who);
		userContext.getChecker().checkDeliveryTimeOfRetailStoreOrderDelivery(deliveryTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);


		RetailStoreOrderDelivery retailStoreOrderDelivery=createNewRetailStoreOrderDelivery();	

		retailStoreOrderDelivery.setWho(who);
		retailStoreOrderDelivery.setDeliveryTime(deliveryTime);

		retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderDelivery);
		return retailStoreOrderDelivery;

		
	}
	protected RetailStoreOrderDelivery createNewRetailStoreOrderDelivery() 
	{
		
		return new RetailStoreOrderDelivery();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderDelivery(RetailscmUserContext userContext,String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		userContext.getChecker().checkVersionOfRetailStoreOrderDelivery( retailStoreOrderDeliveryVersion);
		

		if(RetailStoreOrderDelivery.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfRetailStoreOrderDelivery(parseString(newValueExpr));
		}
		if(RetailStoreOrderDelivery.DELIVERY_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkDeliveryTimeOfRetailStoreOrderDelivery(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);
	
		
	}
	
	
	
	public RetailStoreOrderDelivery clone(RetailscmUserContext userContext, String fromRetailStoreOrderDeliveryId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().clone(fromRetailStoreOrderDeliveryId, this.allTokens());
	}
	
	public RetailStoreOrderDelivery internalSaveRetailStoreOrderDelivery(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery) throws Exception 
	{
		return internalSaveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, allTokens());

	}
	public RetailStoreOrderDelivery internalSaveRetailStoreOrderDelivery(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreOrderDelivery){ 
			//will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderDelivery.
			
			
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, options);
			return retailStoreOrderDelivery;
			
		}

	}
	
	public RetailStoreOrderDelivery updateRetailStoreOrderDelivery(RetailscmUserContext userContext,String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		if(retailStoreOrderDelivery.getVersion() != retailStoreOrderDeliveryVersion){
			String message = "The target version("+retailStoreOrderDelivery.getVersion()+") is not equals to version("+retailStoreOrderDeliveryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderDelivery){ 
			//will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderDelivery.
			
			retailStoreOrderDelivery.changeProperty(property, newValueExpr);
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().done());
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().done());
		}

	}
	
	public RetailStoreOrderDelivery updateRetailStoreOrderDeliveryProperty(RetailscmUserContext userContext,String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		if(retailStoreOrderDelivery.getVersion() != retailStoreOrderDeliveryVersion){
			String message = "The target version("+retailStoreOrderDelivery.getVersion()+") is not equals to version("+retailStoreOrderDeliveryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderDelivery){ 
			//will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderDelivery.
			
			retailStoreOrderDelivery.changeProperty(property, newValueExpr);
			
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().done());
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderDeliveryTokens tokens(){
		return RetailStoreOrderDeliveryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderDeliveryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreOrderListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderDeliveryTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().delete(retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion);
	}
	
	public RetailStoreOrderDelivery forgetByAll(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion);		
	}
	protected RetailStoreOrderDelivery forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().disconnectFromAll(retailStoreOrderDeliveryId, retailStoreOrderDeliveryVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderDeliveryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().deleteAll();
	}


	//disconnect RetailStoreOrderDelivery with buyer in RetailStoreOrder
	protected RetailStoreOrderDelivery breakWithRetailStoreOrderByBuyer(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String buyerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());

			synchronized(retailStoreOrderDelivery){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().planToRemoveRetailStoreOrderListWithBuyer(retailStoreOrderDelivery, buyerId, this.emptyOptions());

				retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderDelivery;
			}
	}
	//disconnect RetailStoreOrderDelivery with seller in RetailStoreOrder
	protected RetailStoreOrderDelivery breakWithRetailStoreOrderBySeller(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());

			synchronized(retailStoreOrderDelivery){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().planToRemoveRetailStoreOrderListWithSeller(retailStoreOrderDelivery, sellerId, this.emptyOptions());

				retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderDelivery;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);

		
		userContext.getChecker().checkBuyerIdOfRetailStoreOrder(buyerId);
		
		userContext.getChecker().checkSellerIdOfRetailStoreOrder(sellerId);
		
		userContext.getChecker().checkTitleOfRetailStoreOrder(title);
		
		userContext.getChecker().checkTotalAmountOfRetailStoreOrder(totalAmount);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);

	
	}
	public  RetailStoreOrderDelivery addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderDeliveryId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		synchronized(retailStoreOrderDelivery){ 
			//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderDelivery.addRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderDeliveryId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		userContext.getChecker().checkIdOfRetailStoreOrder(id);
		
		userContext.getChecker().checkTitleOfRetailStoreOrder( title);
		userContext.getChecker().checkTotalAmountOfRetailStoreOrder( totalAmount);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);
		
	}
	public  RetailStoreOrderDelivery updateRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreOrderProperties(userContext,retailStoreOrderDeliveryId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderListList()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "is", id).done();
		
		RetailStoreOrderDelivery retailStoreOrderDeliveryToUpdate = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, options);
		
		if(retailStoreOrderDeliveryToUpdate.getRetailStoreOrderList().isEmpty()){
			throw new RetailStoreOrderDeliveryManagerException("RetailStoreOrder is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreOrder item = retailStoreOrderDeliveryToUpdate.getRetailStoreOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderDeliveryId,name, code, used,tokensExpr);
		RetailStoreOrderDelivery retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryToUpdate, tokens().withRetailStoreOrderList().done());
		synchronized(retailStoreOrderDelivery){ 
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, 
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		for(String retailStoreOrderId: retailStoreOrderIds){
			userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);
		
	}
	public  RetailStoreOrderDelivery removeRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, 
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreOrderList(userContext, retailStoreOrderDeliveryId,  retailStoreOrderIds, tokensExpr);
			
			
			RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
			synchronized(retailStoreOrderDelivery){ 
				//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().planToRemoveRetailStoreOrderList(retailStoreOrderDelivery, retailStoreOrderIds, allTokens());
				retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreOrderDelivery.getRetailStoreOrderList());
				return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrderDelivery( retailStoreOrderDeliveryId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);
	
	}
	public  RetailStoreOrderDelivery removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderDeliveryId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		synchronized(retailStoreOrderDelivery){ 
			//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderDelivery.removeRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
			deleteRelationInGraph(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrderDelivery( retailStoreOrderDeliveryId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);
	
	}
	public  RetailStoreOrderDelivery copyRetailStoreOrderFrom(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderDeliveryId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, allTokens());
		synchronized(retailStoreOrderDelivery){ 
			//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			
			retailStoreOrderDelivery.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, (RetailStoreOrder)retailStoreOrderDelivery.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreOrderDelivery(retailStoreOrderDeliveryId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderDeliveryManagerException.class);
	
	}
	
	public  RetailStoreOrderDelivery updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderDeliveryId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderList().searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "eq", retailStoreOrderId).done();
		
		
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, loadTokens);
		
		synchronized(retailStoreOrderDelivery){ 
			//Will be good when the retailStoreOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderDelivery.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStoreOrderDelivery.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderDeliveryManagerException(retailStoreOrder+" is NOT FOUND" );
			}
			
			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStoreOrderDelivery = saveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderDelivery, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStoreOrderDelivery associateRetailStoreOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, options);
		
		RetailStoreOrderConfirmation confirmation = userContext.getManagerGroup().getRetailStoreOrderConfirmationManager().createRetailStoreOrderConfirmation(userContext,  who,  confirmTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderDelivery.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery);
	}	public  RetailStoreOrderDelivery associateRetailStoreOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, options);
		
		RetailStoreOrderApproval approval = userContext.getManagerGroup().getRetailStoreOrderApprovalManager().createRetailStoreOrderApproval(userContext,  who,  approveTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderDelivery.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateApproval(approval);
		}
		return this.internalSaveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery);
	}	public  RetailStoreOrderDelivery associateRetailStoreOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, options);
		
		RetailStoreOrderProcessing processing = userContext.getManagerGroup().getRetailStoreOrderProcessingManager().createRetailStoreOrderProcessing(userContext,  who,  processTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderDelivery.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateProcessing(processing);
		}
		return this.internalSaveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery);
	}	public  RetailStoreOrderDelivery associateRetailStoreOrderListToNewPicking(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, options);
		
		RetailStoreOrderPicking picking = userContext.getManagerGroup().getRetailStoreOrderPickingManager().createRetailStoreOrderPicking(userContext,  who,  processTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderDelivery.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updatePicking(picking);
		}
		return this.internalSaveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery);
	}	public  RetailStoreOrderDelivery associateRetailStoreOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, options);
		
		RetailStoreOrderShipment shipment = userContext.getManagerGroup().getRetailStoreOrderShipmentManager().createRetailStoreOrderShipment(userContext,  who,  shipTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderDelivery.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery);
	}
	*/
	
	public  RetailStoreOrderDelivery associateRetailStoreOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, options);
		
		RetailStoreOrderConfirmation confirmation = userContext.getManagerGroup().getRetailStoreOrderConfirmationManager().loadRetailStoreOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderDelivery.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery);
	}	public  RetailStoreOrderDelivery associateRetailStoreOrderListToApproval(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, options);
		
		RetailStoreOrderApproval approval = userContext.getManagerGroup().getRetailStoreOrderApprovalManager().loadRetailStoreOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderDelivery.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateApproval(approval);
		}
		return this.internalSaveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery);
	}	public  RetailStoreOrderDelivery associateRetailStoreOrderListToProcessing(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, options);
		
		RetailStoreOrderProcessing processing = userContext.getManagerGroup().getRetailStoreOrderProcessingManager().loadRetailStoreOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderDelivery.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateProcessing(processing);
		}
		return this.internalSaveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery);
	}	public  RetailStoreOrderDelivery associateRetailStoreOrderListToPicking(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String pickingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, options);
		
		RetailStoreOrderPicking picking = userContext.getManagerGroup().getRetailStoreOrderPickingManager().loadRetailStoreOrderPicking(userContext,pickingId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderDelivery.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updatePicking(picking);
		}
		return this.internalSaveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery);
	}	public  RetailStoreOrderDelivery associateRetailStoreOrderListToShipment(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadRetailStoreOrderDelivery(userContext, retailStoreOrderDeliveryId, options);
		
		RetailStoreOrderShipment shipment = userContext.getManagerGroup().getRetailStoreOrderShipmentManager().loadRetailStoreOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderDelivery.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStoreOrderDelivery(userContext, retailStoreOrderDelivery);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderDelivery newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


