
package com.doublechaintech.retailscm.retailstoreorderpicking;

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






public class RetailStoreOrderPickingManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderPickingManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderPicking";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderPickingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderPickingManagerException(message);

	}
	
	

 	protected RetailStoreOrderPicking saveRetailStoreOrderPicking(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderPickingDAO().save(retailStoreOrderPicking, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens);
 	}
 	
 	protected RetailStoreOrderPicking saveRetailStoreOrderPickingDetail(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking) throws Exception{	

 		
 		return saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, allTokens());
 	}
 	
 	public RetailStoreOrderPicking loadRetailStoreOrderPicking(RetailscmUserContext userContext, String retailStoreOrderPickingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderPickingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking( userContext, retailStoreOrderPickingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderPicking, tokens);
 	}
 	
 	
 	 public RetailStoreOrderPicking searchRetailStoreOrderPicking(RetailscmUserContext userContext, String retailStoreOrderPickingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderPickingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking( userContext, retailStoreOrderPickingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderPicking, tokens);
 	}
 	
 	

 	protected RetailStoreOrderPicking present(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderPicking,tokens);
		
		
		RetailStoreOrderPicking  retailStoreOrderPickingToPresent = userContext.getDAOGroup().getRetailStoreOrderPickingDAO().present(retailStoreOrderPicking, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderPickingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreOrderPickingDAO().alias(entityListToNaming);
		
		return  retailStoreOrderPickingToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderPicking loadRetailStoreOrderPickingDetail(RetailscmUserContext userContext, String retailStoreOrderPickingId) throws Exception{	
 		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking( userContext, retailStoreOrderPickingId, allTokens());
 		return present(userContext,retailStoreOrderPicking, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderPickingId) throws Exception{	
 		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking( userContext, retailStoreOrderPickingId, viewTokens());
 		return present(userContext,retailStoreOrderPicking, allTokens());
		
 	}
 	protected RetailStoreOrderPicking saveRetailStoreOrderPicking(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreOrderPickingDAO().save(retailStoreOrderPicking, tokens);
 	}
 	protected RetailStoreOrderPicking loadRetailStoreOrderPicking(RetailscmUserContext userContext, String retailStoreOrderPickingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderPickingManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreOrderPickingDAO().load(retailStoreOrderPickingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderPicking, tokens);
		
		addAction(userContext, retailStoreOrderPicking, tokens,"@create","createRetailStoreOrderPicking","createRetailStoreOrderPicking/","main","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"@update","updateRetailStoreOrderPicking","updateRetailStoreOrderPicking/"+retailStoreOrderPicking.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"@copy","cloneRetailStoreOrderPicking","cloneRetailStoreOrderPicking/"+retailStoreOrderPicking.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderPicking, tokens,"retail_store_order_picking.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderPicking.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"retail_store_order_picking.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderPicking.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"retail_store_order_picking.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderPicking.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderPicking, tokens,"retail_store_order_picking.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderPicking.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderPicking createRetailStoreOrderPicking(RetailscmUserContext userContext,String who, Date processTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfRetailStoreOrderPicking(who);
		userContext.getChecker().checkProcessTimeOfRetailStoreOrderPicking(processTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);


		RetailStoreOrderPicking retailStoreOrderPicking=createNewRetailStoreOrderPicking();	

		retailStoreOrderPicking.setWho(who);
		retailStoreOrderPicking.setProcessTime(processTime);

		retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderPicking);
		return retailStoreOrderPicking;

		
	}
	protected RetailStoreOrderPicking createNewRetailStoreOrderPicking() 
	{
		
		return new RetailStoreOrderPicking();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderPicking(RetailscmUserContext userContext,String retailStoreOrderPickingId, int retailStoreOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		userContext.getChecker().checkVersionOfRetailStoreOrderPicking( retailStoreOrderPickingVersion);
		

		if(RetailStoreOrderPicking.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfRetailStoreOrderPicking(parseString(newValueExpr));
		}
		if(RetailStoreOrderPicking.PROCESS_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkProcessTimeOfRetailStoreOrderPicking(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);
	
		
	}
	
	
	
	public RetailStoreOrderPicking clone(RetailscmUserContext userContext, String fromRetailStoreOrderPickingId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreOrderPickingDAO().clone(fromRetailStoreOrderPickingId, this.allTokens());
	}
	
	public RetailStoreOrderPicking internalSaveRetailStoreOrderPicking(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking) throws Exception 
	{
		return internalSaveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, allTokens());

	}
	public RetailStoreOrderPicking internalSaveRetailStoreOrderPicking(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, retailStoreOrderPickingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreOrderPicking){ 
			//will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPicking.
			
			
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, options);
			return retailStoreOrderPicking;
			
		}

	}
	
	public RetailStoreOrderPicking updateRetailStoreOrderPicking(RetailscmUserContext userContext,String retailStoreOrderPickingId, int retailStoreOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, retailStoreOrderPickingVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		if(retailStoreOrderPicking.getVersion() != retailStoreOrderPickingVersion){
			String message = "The target version("+retailStoreOrderPicking.getVersion()+") is not equals to version("+retailStoreOrderPickingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderPicking){ 
			//will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPicking.
			
			retailStoreOrderPicking.changeProperty(property, newValueExpr);
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().done());
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().done());
		}

	}
	
	public RetailStoreOrderPicking updateRetailStoreOrderPickingProperty(RetailscmUserContext userContext,String retailStoreOrderPickingId, int retailStoreOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, retailStoreOrderPickingVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		if(retailStoreOrderPicking.getVersion() != retailStoreOrderPickingVersion){
			String message = "The target version("+retailStoreOrderPicking.getVersion()+") is not equals to version("+retailStoreOrderPickingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderPicking){ 
			//will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPicking.
			
			retailStoreOrderPicking.changeProperty(property, newValueExpr);
			
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().done());
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderPickingTokens tokens(){
		return RetailStoreOrderPickingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderPickingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreOrderListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderPickingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOrderPickingId, int retailStoreOrderPickingVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderPickingId, retailStoreOrderPickingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderPickingId, int retailStoreOrderPickingVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreOrderPickingDAO().delete(retailStoreOrderPickingId, retailStoreOrderPickingVersion);
	}
	
	public RetailStoreOrderPicking forgetByAll(RetailscmUserContext userContext, String retailStoreOrderPickingId, int retailStoreOrderPickingVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderPickingId, retailStoreOrderPickingVersion);		
	}
	protected RetailStoreOrderPicking forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderPickingId, int retailStoreOrderPickingVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreOrderPickingDAO().disconnectFromAll(retailStoreOrderPickingId, retailStoreOrderPickingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderPickingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreOrderPickingDAO().deleteAll();
	}


	//disconnect RetailStoreOrderPicking with buyer in RetailStoreOrder
	protected RetailStoreOrderPicking breakWithRetailStoreOrderByBuyer(RetailscmUserContext userContext, String retailStoreOrderPickingId, String buyerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());

			synchronized(retailStoreOrderPicking){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderPickingDAO().planToRemoveRetailStoreOrderListWithBuyer(retailStoreOrderPicking, buyerId, this.emptyOptions());

				retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderPicking;
			}
	}
	//disconnect RetailStoreOrderPicking with seller in RetailStoreOrder
	protected RetailStoreOrderPicking breakWithRetailStoreOrderBySeller(RetailscmUserContext userContext, String retailStoreOrderPickingId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());

			synchronized(retailStoreOrderPicking){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderPickingDAO().planToRemoveRetailStoreOrderListWithSeller(retailStoreOrderPicking, sellerId, this.emptyOptions());

				retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderPicking;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);

		
		userContext.getChecker().checkBuyerIdOfRetailStoreOrder(buyerId);
		
		userContext.getChecker().checkSellerIdOfRetailStoreOrder(sellerId);
		
		userContext.getChecker().checkTitleOfRetailStoreOrder(title);
		
		userContext.getChecker().checkTotalAmountOfRetailStoreOrder(totalAmount);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);

	
	}
	public  RetailStoreOrderPicking addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderPickingId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		synchronized(retailStoreOrderPicking){ 
			//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderPicking.addRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderPickingId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		userContext.getChecker().checkIdOfRetailStoreOrder(id);
		
		userContext.getChecker().checkTitleOfRetailStoreOrder( title);
		userContext.getChecker().checkTotalAmountOfRetailStoreOrder( totalAmount);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);
		
	}
	public  RetailStoreOrderPicking updateRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderPickingId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreOrderProperties(userContext,retailStoreOrderPickingId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderListList()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "is", id).done();
		
		RetailStoreOrderPicking retailStoreOrderPickingToUpdate = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, options);
		
		if(retailStoreOrderPickingToUpdate.getRetailStoreOrderList().isEmpty()){
			throw new RetailStoreOrderPickingManagerException("RetailStoreOrder is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreOrder item = retailStoreOrderPickingToUpdate.getRetailStoreOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderPickingId,name, code, used,tokensExpr);
		RetailStoreOrderPicking retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPickingToUpdate, tokens().withRetailStoreOrderList().done());
		synchronized(retailStoreOrderPicking){ 
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderPickingId, 
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		for(String retailStoreOrderId: retailStoreOrderIds){
			userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);
		
	}
	public  RetailStoreOrderPicking removeRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderPickingId, 
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreOrderList(userContext, retailStoreOrderPickingId,  retailStoreOrderIds, tokensExpr);
			
			
			RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
			synchronized(retailStoreOrderPicking){ 
				//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreOrderPickingDAO().planToRemoveRetailStoreOrderList(retailStoreOrderPicking, retailStoreOrderIds, allTokens());
				retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreOrderPicking.getRetailStoreOrderList());
				return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrderPicking( retailStoreOrderPickingId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);
	
	}
	public  RetailStoreOrderPicking removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderPickingId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		synchronized(retailStoreOrderPicking){ 
			//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderPicking.removeRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
			deleteRelationInGraph(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrderPicking( retailStoreOrderPickingId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);
	
	}
	public  RetailStoreOrderPicking copyRetailStoreOrderFrom(RetailscmUserContext userContext, String retailStoreOrderPickingId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderPickingId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, allTokens());
		synchronized(retailStoreOrderPicking){ 
			//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			
			retailStoreOrderPicking.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, (RetailStoreOrder)retailStoreOrderPicking.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreOrderPicking(retailStoreOrderPickingId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderPickingManagerException.class);
	
	}
	
	public  RetailStoreOrderPicking updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderPickingId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderList().searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "eq", retailStoreOrderId).done();
		
		
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, loadTokens);
		
		synchronized(retailStoreOrderPicking){ 
			//Will be good when the retailStoreOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderPicking.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStoreOrderPicking.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderPickingManagerException(retailStoreOrder+" is NOT FOUND" );
			}
			
			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStoreOrderPicking = saveRetailStoreOrderPicking(userContext, retailStoreOrderPicking, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderPicking, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStoreOrderPicking associateRetailStoreOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, options);
		
		RetailStoreOrderConfirmation confirmation = userContext.getManagerGroup().getRetailStoreOrderConfirmationManager().createRetailStoreOrderConfirmation(userContext,  who,  confirmTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderPicking.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStoreOrderPicking(userContext, retailStoreOrderPicking);
	}	public  RetailStoreOrderPicking associateRetailStoreOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, options);
		
		RetailStoreOrderApproval approval = userContext.getManagerGroup().getRetailStoreOrderApprovalManager().createRetailStoreOrderApproval(userContext,  who,  approveTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderPicking.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateApproval(approval);
		}
		return this.internalSaveRetailStoreOrderPicking(userContext, retailStoreOrderPicking);
	}	public  RetailStoreOrderPicking associateRetailStoreOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, options);
		
		RetailStoreOrderProcessing processing = userContext.getManagerGroup().getRetailStoreOrderProcessingManager().createRetailStoreOrderProcessing(userContext,  who,  processTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderPicking.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateProcessing(processing);
		}
		return this.internalSaveRetailStoreOrderPicking(userContext, retailStoreOrderPicking);
	}	public  RetailStoreOrderPicking associateRetailStoreOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, options);
		
		RetailStoreOrderShipment shipment = userContext.getManagerGroup().getRetailStoreOrderShipmentManager().createRetailStoreOrderShipment(userContext,  who,  shipTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderPicking.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStoreOrderPicking(userContext, retailStoreOrderPicking);
	}	public  RetailStoreOrderPicking associateRetailStoreOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, options);
		
		RetailStoreOrderDelivery delivery = userContext.getManagerGroup().getRetailStoreOrderDeliveryManager().createRetailStoreOrderDelivery(userContext,  who,  deliveryTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderPicking.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateDelivery(delivery);
		}
		return this.internalSaveRetailStoreOrderPicking(userContext, retailStoreOrderPicking);
	}
	*/
	
	public  RetailStoreOrderPicking associateRetailStoreOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, options);
		
		RetailStoreOrderConfirmation confirmation = userContext.getManagerGroup().getRetailStoreOrderConfirmationManager().loadRetailStoreOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderPicking.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStoreOrderPicking(userContext, retailStoreOrderPicking);
	}	public  RetailStoreOrderPicking associateRetailStoreOrderListToApproval(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, options);
		
		RetailStoreOrderApproval approval = userContext.getManagerGroup().getRetailStoreOrderApprovalManager().loadRetailStoreOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderPicking.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateApproval(approval);
		}
		return this.internalSaveRetailStoreOrderPicking(userContext, retailStoreOrderPicking);
	}	public  RetailStoreOrderPicking associateRetailStoreOrderListToProcessing(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, options);
		
		RetailStoreOrderProcessing processing = userContext.getManagerGroup().getRetailStoreOrderProcessingManager().loadRetailStoreOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderPicking.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateProcessing(processing);
		}
		return this.internalSaveRetailStoreOrderPicking(userContext, retailStoreOrderPicking);
	}	public  RetailStoreOrderPicking associateRetailStoreOrderListToShipment(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, options);
		
		RetailStoreOrderShipment shipment = userContext.getManagerGroup().getRetailStoreOrderShipmentManager().loadRetailStoreOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderPicking.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStoreOrderPicking(userContext, retailStoreOrderPicking);
	}	public  RetailStoreOrderPicking associateRetailStoreOrderListToDelivery(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadRetailStoreOrderPicking(userContext, retailStoreOrderPickingId, options);
		
		RetailStoreOrderDelivery delivery = userContext.getManagerGroup().getRetailStoreOrderDeliveryManager().loadRetailStoreOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderPicking.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateDelivery(delivery);
		}
		return this.internalSaveRetailStoreOrderPicking(userContext, retailStoreOrderPicking);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderPicking newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


