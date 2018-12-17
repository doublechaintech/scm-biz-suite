
package com.doublechaintech.retailscm.retailstoreorderapproval;

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






public class RetailStoreOrderApprovalManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderApprovalManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderApproval";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderApprovalManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderApprovalManagerException(message);

	}
	
	

 	protected RetailStoreOrderApproval saveRetailStoreOrderApproval(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderApprovalDAO().save(retailStoreOrderApproval, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens);
 	}
 	
 	protected RetailStoreOrderApproval saveRetailStoreOrderApprovalDetail(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval) throws Exception{	

 		
 		return saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, allTokens());
 	}
 	
 	public RetailStoreOrderApproval loadRetailStoreOrderApproval(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderApprovalManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval( userContext, retailStoreOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderApproval, tokens);
 	}
 	
 	
 	 public RetailStoreOrderApproval searchRetailStoreOrderApproval(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderApprovalManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval( userContext, retailStoreOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderApproval, tokens);
 	}
 	
 	

 	protected RetailStoreOrderApproval present(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderApproval,tokens);
		
		
		RetailStoreOrderApproval  retailStoreOrderApprovalToPresent = userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().present(retailStoreOrderApproval, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderApprovalToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().alias(entityListToNaming);
		
		return  retailStoreOrderApprovalToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderApproval loadRetailStoreOrderApprovalDetail(RetailscmUserContext userContext, String retailStoreOrderApprovalId) throws Exception{	
 		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval( userContext, retailStoreOrderApprovalId, allTokens());
 		return present(userContext,retailStoreOrderApproval, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderApprovalId) throws Exception{	
 		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval( userContext, retailStoreOrderApprovalId, viewTokens());
 		return present(userContext,retailStoreOrderApproval, allTokens());
		
 	}
 	protected RetailStoreOrderApproval saveRetailStoreOrderApproval(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().save(retailStoreOrderApproval, tokens);
 	}
 	protected RetailStoreOrderApproval loadRetailStoreOrderApproval(RetailscmUserContext userContext, String retailStoreOrderApprovalId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderApprovalManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().load(retailStoreOrderApprovalId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderApproval, tokens);
		
		addAction(userContext, retailStoreOrderApproval, tokens,"@create","createRetailStoreOrderApproval","createRetailStoreOrderApproval/","main","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"@update","updateRetailStoreOrderApproval","updateRetailStoreOrderApproval/"+retailStoreOrderApproval.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"@copy","cloneRetailStoreOrderApproval","cloneRetailStoreOrderApproval/"+retailStoreOrderApproval.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderApproval, tokens,"retail_store_order_approval.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreOrderApproval.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"retail_store_order_approval.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreOrderApproval.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"retail_store_order_approval.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrderApproval.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreOrderApproval, tokens,"retail_store_order_approval.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreOrderApproval.getId()+"/","retailStoreOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderApproval createRetailStoreOrderApproval(RetailscmUserContext userContext,String who, Date approveTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfRetailStoreOrderApproval(who);
		userContext.getChecker().checkApproveTimeOfRetailStoreOrderApproval(approveTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);


		RetailStoreOrderApproval retailStoreOrderApproval=createNewRetailStoreOrderApproval();	

		retailStoreOrderApproval.setWho(who);
		retailStoreOrderApproval.setApproveTime(approveTime);

		retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderApproval);
		return retailStoreOrderApproval;

		
	}
	protected RetailStoreOrderApproval createNewRetailStoreOrderApproval() 
	{
		
		return new RetailStoreOrderApproval();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderApproval(RetailscmUserContext userContext,String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		userContext.getChecker().checkVersionOfRetailStoreOrderApproval( retailStoreOrderApprovalVersion);
		

		if(RetailStoreOrderApproval.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfRetailStoreOrderApproval(parseString(newValueExpr));
		}
		if(RetailStoreOrderApproval.APPROVE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkApproveTimeOfRetailStoreOrderApproval(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);
	
		
	}
	
	
	
	public RetailStoreOrderApproval clone(RetailscmUserContext userContext, String fromRetailStoreOrderApprovalId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().clone(fromRetailStoreOrderApprovalId, this.allTokens());
	}
	
	public RetailStoreOrderApproval internalSaveRetailStoreOrderApproval(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval) throws Exception 
	{
		return internalSaveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, allTokens());

	}
	public RetailStoreOrderApproval internalSaveRetailStoreOrderApproval(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, retailStoreOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreOrderApproval){ 
			//will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderApproval.
			
			
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, options);
			return retailStoreOrderApproval;
			
		}

	}
	
	public RetailStoreOrderApproval updateRetailStoreOrderApproval(RetailscmUserContext userContext,String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, retailStoreOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		if(retailStoreOrderApproval.getVersion() != retailStoreOrderApprovalVersion){
			String message = "The target version("+retailStoreOrderApproval.getVersion()+") is not equals to version("+retailStoreOrderApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderApproval){ 
			//will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderApproval.
			
			retailStoreOrderApproval.changeProperty(property, newValueExpr);
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().done());
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().done());
		}

	}
	
	public RetailStoreOrderApproval updateRetailStoreOrderApprovalProperty(RetailscmUserContext userContext,String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, retailStoreOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		if(retailStoreOrderApproval.getVersion() != retailStoreOrderApprovalVersion){
			String message = "The target version("+retailStoreOrderApproval.getVersion()+") is not equals to version("+retailStoreOrderApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderApproval){ 
			//will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderApproval.
			
			retailStoreOrderApproval.changeProperty(property, newValueExpr);
			
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().done());
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderApprovalTokens tokens(){
		return RetailStoreOrderApprovalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderApprovalTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreOrderListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderApprovalTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderApprovalId, retailStoreOrderApprovalVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().delete(retailStoreOrderApprovalId, retailStoreOrderApprovalVersion);
	}
	
	public RetailStoreOrderApproval forgetByAll(RetailscmUserContext userContext, String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderApprovalId, retailStoreOrderApprovalVersion);		
	}
	protected RetailStoreOrderApproval forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().disconnectFromAll(retailStoreOrderApprovalId, retailStoreOrderApprovalVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderApprovalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().deleteAll();
	}


	//disconnect RetailStoreOrderApproval with buyer in RetailStoreOrder
	protected RetailStoreOrderApproval breakWithRetailStoreOrderByBuyer(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String buyerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());

			synchronized(retailStoreOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().planToRemoveRetailStoreOrderListWithBuyer(retailStoreOrderApproval, buyerId, this.emptyOptions());

				retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderApproval;
			}
	}
	//disconnect RetailStoreOrderApproval with seller in RetailStoreOrder
	protected RetailStoreOrderApproval breakWithRetailStoreOrderBySeller(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());

			synchronized(retailStoreOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().planToRemoveRetailStoreOrderListWithSeller(retailStoreOrderApproval, sellerId, this.emptyOptions());

				retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
				return retailStoreOrderApproval;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);

		
		userContext.getChecker().checkBuyerIdOfRetailStoreOrder(buyerId);
		
		userContext.getChecker().checkSellerIdOfRetailStoreOrder(sellerId);
		
		userContext.getChecker().checkTitleOfRetailStoreOrder(title);
		
		userContext.getChecker().checkTotalAmountOfRetailStoreOrder(totalAmount);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);

	
	}
	public  RetailStoreOrderApproval addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderApprovalId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		synchronized(retailStoreOrderApproval){ 
			//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderApproval.addRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderApprovalId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		userContext.getChecker().checkIdOfRetailStoreOrder(id);
		
		userContext.getChecker().checkTitleOfRetailStoreOrder( title);
		userContext.getChecker().checkTotalAmountOfRetailStoreOrder( totalAmount);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);
		
	}
	public  RetailStoreOrderApproval updateRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreOrderProperties(userContext,retailStoreOrderApprovalId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderListList()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "is", id).done();
		
		RetailStoreOrderApproval retailStoreOrderApprovalToUpdate = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, options);
		
		if(retailStoreOrderApprovalToUpdate.getRetailStoreOrderList().isEmpty()){
			throw new RetailStoreOrderApprovalManagerException("RetailStoreOrder is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreOrder item = retailStoreOrderApprovalToUpdate.getRetailStoreOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingRetailStoreOrder(userContext,retailStoreOrderApprovalId,name, code, used,tokensExpr);
		RetailStoreOrderApproval retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApprovalToUpdate, tokens().withRetailStoreOrderList().done());
		synchronized(retailStoreOrderApproval){ 
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderApprovalId, 
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		for(String retailStoreOrderId: retailStoreOrderIds){
			userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);
		
	}
	public  RetailStoreOrderApproval removeRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreOrderApprovalId, 
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreOrderList(userContext, retailStoreOrderApprovalId,  retailStoreOrderIds, tokensExpr);
			
			
			RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
			synchronized(retailStoreOrderApproval){ 
				//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().planToRemoveRetailStoreOrderList(retailStoreOrderApproval, retailStoreOrderIds, allTokens());
				retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreOrderApproval.getRetailStoreOrderList());
				return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrderApproval( retailStoreOrderApprovalId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);
	
	}
	public  RetailStoreOrderApproval removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreOrderApprovalId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		synchronized(retailStoreOrderApproval){ 
			//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrderApproval.removeRetailStoreOrder( retailStoreOrder );		
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
			deleteRelationInGraph(userContext, retailStoreOrder);
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrderApproval( retailStoreOrderApprovalId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);
	
	}
	public  RetailStoreOrderApproval copyRetailStoreOrderFrom(RetailscmUserContext userContext, String retailStoreOrderApprovalId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreOrderApprovalId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, allTokens());
		synchronized(retailStoreOrderApproval){ 
			//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			
			retailStoreOrderApproval.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, (RetailStoreOrder)retailStoreOrderApproval.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreOrderApproval(retailStoreOrderApprovalId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderApprovalManagerException.class);
	
	}
	
	public  RetailStoreOrderApproval updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderApprovalId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderList().searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "eq", retailStoreOrderId).done();
		
		
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, loadTokens);
		
		synchronized(retailStoreOrderApproval){ 
			//Will be good when the retailStoreOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrderApproval.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStoreOrderApproval.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreOrderApprovalManagerException(retailStoreOrder+" is NOT FOUND" );
			}
			
			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStoreOrderApproval = saveRetailStoreOrderApproval(userContext, retailStoreOrderApproval, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreOrderApproval, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStoreOrderApproval associateRetailStoreOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, options);
		
		RetailStoreOrderConfirmation confirmation = userContext.getManagerGroup().getRetailStoreOrderConfirmationManager().createRetailStoreOrderConfirmation(userContext,  who,  confirmTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderApproval.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStoreOrderApproval(userContext, retailStoreOrderApproval);
	}	public  RetailStoreOrderApproval associateRetailStoreOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, options);
		
		RetailStoreOrderProcessing processing = userContext.getManagerGroup().getRetailStoreOrderProcessingManager().createRetailStoreOrderProcessing(userContext,  who,  processTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderApproval.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateProcessing(processing);
		}
		return this.internalSaveRetailStoreOrderApproval(userContext, retailStoreOrderApproval);
	}	public  RetailStoreOrderApproval associateRetailStoreOrderListToNewPicking(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, options);
		
		RetailStoreOrderPicking picking = userContext.getManagerGroup().getRetailStoreOrderPickingManager().createRetailStoreOrderPicking(userContext,  who,  processTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderApproval.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updatePicking(picking);
		}
		return this.internalSaveRetailStoreOrderApproval(userContext, retailStoreOrderApproval);
	}	public  RetailStoreOrderApproval associateRetailStoreOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, options);
		
		RetailStoreOrderShipment shipment = userContext.getManagerGroup().getRetailStoreOrderShipmentManager().createRetailStoreOrderShipment(userContext,  who,  shipTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderApproval.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStoreOrderApproval(userContext, retailStoreOrderApproval);
	}	public  RetailStoreOrderApproval associateRetailStoreOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, options);
		
		RetailStoreOrderDelivery delivery = userContext.getManagerGroup().getRetailStoreOrderDeliveryManager().createRetailStoreOrderDelivery(userContext,  who,  deliveryTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderApproval.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateDelivery(delivery);
		}
		return this.internalSaveRetailStoreOrderApproval(userContext, retailStoreOrderApproval);
	}
	*/
	
	public  RetailStoreOrderApproval associateRetailStoreOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, options);
		
		RetailStoreOrderConfirmation confirmation = userContext.getManagerGroup().getRetailStoreOrderConfirmationManager().loadRetailStoreOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderApproval.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStoreOrderApproval(userContext, retailStoreOrderApproval);
	}	public  RetailStoreOrderApproval associateRetailStoreOrderListToProcessing(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, options);
		
		RetailStoreOrderProcessing processing = userContext.getManagerGroup().getRetailStoreOrderProcessingManager().loadRetailStoreOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderApproval.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateProcessing(processing);
		}
		return this.internalSaveRetailStoreOrderApproval(userContext, retailStoreOrderApproval);
	}	public  RetailStoreOrderApproval associateRetailStoreOrderListToPicking(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String pickingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, options);
		
		RetailStoreOrderPicking picking = userContext.getManagerGroup().getRetailStoreOrderPickingManager().loadRetailStoreOrderPicking(userContext,pickingId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderApproval.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updatePicking(picking);
		}
		return this.internalSaveRetailStoreOrderApproval(userContext, retailStoreOrderApproval);
	}	public  RetailStoreOrderApproval associateRetailStoreOrderListToShipment(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, options);
		
		RetailStoreOrderShipment shipment = userContext.getManagerGroup().getRetailStoreOrderShipmentManager().loadRetailStoreOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderApproval.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStoreOrderApproval(userContext, retailStoreOrderApproval);
	}	public  RetailStoreOrderApproval associateRetailStoreOrderListToDelivery(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadRetailStoreOrderApproval(userContext, retailStoreOrderApprovalId, options);
		
		RetailStoreOrderDelivery delivery = userContext.getManagerGroup().getRetailStoreOrderDeliveryManager().loadRetailStoreOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderApproval.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateDelivery(delivery);
		}
		return this.internalSaveRetailStoreOrderApproval(userContext, retailStoreOrderApproval);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderApproval newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


