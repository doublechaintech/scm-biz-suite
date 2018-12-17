
package com.doublechaintech.retailscm.retailstoreorder;

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

import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.doublechaintech.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.doublechaintech.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.doublechaintech.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoreordershipment.RetailStoreOrderShipment;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreorderapproval.CandidateRetailStoreOrderApproval;
import com.doublechaintech.retailscm.retailstore.CandidateRetailStore;
import com.doublechaintech.retailscm.retailstoreorderdelivery.CandidateRetailStoreOrderDelivery;
import com.doublechaintech.retailscm.retailstoreorderprocessing.CandidateRetailStoreOrderProcessing;
import com.doublechaintech.retailscm.retailstoreorderpicking.CandidateRetailStoreOrderPicking;
import com.doublechaintech.retailscm.retailstoreorderconfirmation.CandidateRetailStoreOrderConfirmation;
import com.doublechaintech.retailscm.retailstoreordershipment.CandidateRetailStoreOrderShipment;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodspackaging.GoodsPackaging;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;






public class RetailStoreOrderManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrder";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderManagerException(message);

	}
	
	

 	protected RetailStoreOrder saveRetailStoreOrder(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderDAO().save(retailStoreOrder, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrder(userContext, retailStoreOrder, tokens);
 	}
 	
 	protected RetailStoreOrder saveRetailStoreOrderDetail(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{	

 		
 		return saveRetailStoreOrder(userContext, retailStoreOrder, allTokens());
 	}
 	
 	public RetailStoreOrder loadRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder( userContext, retailStoreOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrder, tokens);
 	}
 	
 	
 	 public RetailStoreOrder searchRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder( userContext, retailStoreOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrder, tokens);
 	}
 	
 	

 	protected RetailStoreOrder present(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrder,tokens);
		
		
		RetailStoreOrder  retailStoreOrderToPresent = userContext.getDAOGroup().getRetailStoreOrderDAO().present(retailStoreOrder, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreOrderDAO().alias(entityListToNaming);
		
		return  retailStoreOrderToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrder loadRetailStoreOrderDetail(RetailscmUserContext userContext, String retailStoreOrderId) throws Exception{	
 		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder( userContext, retailStoreOrderId, allTokens());
 		return present(userContext,retailStoreOrder, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderId) throws Exception{	
 		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder( userContext, retailStoreOrderId, viewTokens());
 		return present(userContext,retailStoreOrder, allTokens());
		
 	}
 	protected RetailStoreOrder saveRetailStoreOrder(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreOrderDAO().save(retailStoreOrder, tokens);
 	}
 	protected RetailStoreOrder loadRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreOrderDAO().load(retailStoreOrderId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrder, tokens);
		
		addAction(userContext, retailStoreOrder, tokens,"@create","createRetailStoreOrder","createRetailStoreOrder/","main","primary");
		addAction(userContext, retailStoreOrder, tokens,"@update","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreOrder.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrder, tokens,"@copy","cloneRetailStoreOrder","cloneRetailStoreOrder/"+retailStoreOrder.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.transfer_to_buyer","transferToAnotherBuyer","transferToAnotherBuyer/"+retailStoreOrder.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.transfer_to_seller","transferToAnotherSeller","transferToAnotherSeller/"+retailStoreOrder.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.confirm","confirm","confirmActionForm/"+retailStoreOrder.getId()+"/","main","success");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.approve","approve","approveActionForm/"+retailStoreOrder.getId()+"/","main","success");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.process","process","processActionForm/"+retailStoreOrder.getId()+"/","main","info");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.pick","pick","pickActionForm/"+retailStoreOrder.getId()+"/","main","success");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.ship","ship","shipActionForm/"+retailStoreOrder.getId()+"/","main","success");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.deliver","deliver","deliverActionForm/"+retailStoreOrder.getId()+"/","main","success");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.addRetailStoreOrderLineItem","addRetailStoreOrderLineItem","addRetailStoreOrderLineItem/"+retailStoreOrder.getId()+"/","retailStoreOrderLineItemList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.removeRetailStoreOrderLineItem","removeRetailStoreOrderLineItem","removeRetailStoreOrderLineItem/"+retailStoreOrder.getId()+"/","retailStoreOrderLineItemList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.updateRetailStoreOrderLineItem","updateRetailStoreOrderLineItem","updateRetailStoreOrderLineItem/"+retailStoreOrder.getId()+"/","retailStoreOrderLineItemList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.copyRetailStoreOrderLineItemFrom","copyRetailStoreOrderLineItemFrom","copyRetailStoreOrderLineItemFrom/"+retailStoreOrder.getId()+"/","retailStoreOrderLineItemList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.addRetailStoreOrderShippingGroup","addRetailStoreOrderShippingGroup","addRetailStoreOrderShippingGroup/"+retailStoreOrder.getId()+"/","retailStoreOrderShippingGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.removeRetailStoreOrderShippingGroup","removeRetailStoreOrderShippingGroup","removeRetailStoreOrderShippingGroup/"+retailStoreOrder.getId()+"/","retailStoreOrderShippingGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.updateRetailStoreOrderShippingGroup","updateRetailStoreOrderShippingGroup","updateRetailStoreOrderShippingGroup/"+retailStoreOrder.getId()+"/","retailStoreOrderShippingGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.copyRetailStoreOrderShippingGroupFrom","copyRetailStoreOrderShippingGroupFrom","copyRetailStoreOrderShippingGroupFrom/"+retailStoreOrder.getId()+"/","retailStoreOrderShippingGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.addRetailStoreOrderPaymentGroup","addRetailStoreOrderPaymentGroup","addRetailStoreOrderPaymentGroup/"+retailStoreOrder.getId()+"/","retailStoreOrderPaymentGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.removeRetailStoreOrderPaymentGroup","removeRetailStoreOrderPaymentGroup","removeRetailStoreOrderPaymentGroup/"+retailStoreOrder.getId()+"/","retailStoreOrderPaymentGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.updateRetailStoreOrderPaymentGroup","updateRetailStoreOrderPaymentGroup","updateRetailStoreOrderPaymentGroup/"+retailStoreOrder.getId()+"/","retailStoreOrderPaymentGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.copyRetailStoreOrderPaymentGroupFrom","copyRetailStoreOrderPaymentGroupFrom","copyRetailStoreOrderPaymentGroupFrom/"+retailStoreOrder.getId()+"/","retailStoreOrderPaymentGroupList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.addGoods","addGoods","addGoods/"+retailStoreOrder.getId()+"/","goodsList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.removeGoods","removeGoods","removeGoods/"+retailStoreOrder.getId()+"/","goodsList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.updateGoods","updateGoods","updateGoods/"+retailStoreOrder.getId()+"/","goodsList","primary");
		addAction(userContext, retailStoreOrder, tokens,"retail_store_order.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+retailStoreOrder.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrder createRetailStoreOrder(RetailscmUserContext userContext,String buyerId, String sellerId, String title, BigDecimal totalAmount) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfRetailStoreOrder(title);
		userContext.getChecker().checkTotalAmountOfRetailStoreOrder(totalAmount);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);


		RetailStoreOrder retailStoreOrder=createNewRetailStoreOrder();	

			
		RetailStore buyer = loadRetailStore(userContext, buyerId,emptyOptions());
		retailStoreOrder.setBuyer(buyer);
		
		
			
		RetailStoreCountryCenter seller = loadRetailStoreCountryCenter(userContext, sellerId,emptyOptions());
		retailStoreOrder.setSeller(seller);
		
		
		retailStoreOrder.setTitle(title);
		retailStoreOrder.setTotalAmount(totalAmount);
		retailStoreOrder.setLastUpdateTime(userContext.now());
		retailStoreOrder.setCurrentStatus("INIT");

		retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrder);
		return retailStoreOrder;

		
	}
	protected RetailStoreOrder createNewRetailStoreOrder() 
	{
		
		return new RetailStoreOrder();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailscmUserContext userContext,String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder( retailStoreOrderVersion);
		
		

				

		
		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		}
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
		
	}
	
	
	
	public RetailStoreOrder clone(RetailscmUserContext userContext, String fromRetailStoreOrderId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreOrderDAO().clone(fromRetailStoreOrderId, this.allTokens());
	}
	
	public RetailStoreOrder internalSaveRetailStoreOrder(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception 
	{
		return internalSaveRetailStoreOrder(userContext, retailStoreOrder, allTokens());

	}
	public RetailStoreOrder internalSaveRetailStoreOrder(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreOrder){ 
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrder.
			
			
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, options);
			return retailStoreOrder;
			
		}

	}
	
	public RetailStoreOrder updateRetailStoreOrder(RetailscmUserContext userContext,String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		if(retailStoreOrder.getVersion() != retailStoreOrderVersion){
			String message = "The target version("+retailStoreOrder.getVersion()+") is not equals to version("+retailStoreOrderVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrder){ 
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrder.
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrder(userContext, retailStoreOrder, tokens().done());
		}

	}
	
	public RetailStoreOrder updateRetailStoreOrderProperty(RetailscmUserContext userContext,String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		if(retailStoreOrder.getVersion() != retailStoreOrderVersion){
			String message = "The target version("+retailStoreOrder.getVersion()+") is not equals to version("+retailStoreOrderVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrder){ 
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrder.
			
			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrder(userContext, retailStoreOrder, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderTokens tokens(){
		return RetailStoreOrderTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreOrderLineItemListWith("id","desc")
		.sortRetailStoreOrderShippingGroupListWith("id","desc")
		.sortRetailStoreOrderPaymentGroupListWith("id","desc")
		.sortGoodsListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderTokens.mergeAll(tokens).done();
	}
	
	private static final String [] STATUS_SEQUENCE={"CONFIRMED","APPROVED","PROCESSED","PICKED","SHIPPED","DELIVERED"};
 	protected String[] getNextCandidateStatus(RetailscmUserContext userContext, String currentStatus) throws Exception{
 	
 		if("INIT".equals(currentStatus)){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE;
 		}
 		/*
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throwExceptionWithMessage("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		
 		//this is not the last one, just return it.
 		*/
 		return STATUS_SEQUENCE;
 	
 	}/**/
 	protected void ensureStatus(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder, String expectedNextStatus) throws Exception{
		String currentStatus = retailStoreOrder.getCurrentStatus();
		//'null' is fine for function getNextStatus
		String candidateStatus[] = getNextCandidateStatus(userContext, currentStatus);
		
		if(candidateStatus == null){
			//no more next status
			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'HIDDEN'";
			throwExceptionWithMessage(message);
		}
		int index = Arrays.asList(candidateStatus).indexOf(expectedNextStatus);
		if(index<0){
			String message = "The current status '"+currentStatus+"' next candidate status should be one of '"+candidateStatus+"', but you want to transit the status to '"+expectedNextStatus+"'";
			throwExceptionWithMessage(message);
		}
	}
	
	protected void checkParamsForTransferingAnotherBuyer(RetailscmUserContext userContext, String retailStoreOrderId, String anotherBuyerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
 		userContext.getChecker().checkIdOfRetailStore(anotherBuyerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
 		
 	}
 	public RetailStoreOrder transferToAnotherBuyer(RetailscmUserContext userContext, String retailStoreOrderId, String anotherBuyerId) throws Exception
 	{
 		checkParamsForTransferingAnotherBuyer(userContext, retailStoreOrderId,anotherBuyerId);
 
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStore buyer = loadRetailStore(userContext, anotherBuyerId, emptyOptions());		
			retailStoreOrder.updateBuyer(buyer);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, emptyOptions());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStore requestCandidateBuyer(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStore result = new CandidateRetailStore();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStore> candidateList = userContext.getDAOGroup().getRetailStoreDAO().requestCandidateRetailStoreForRetailStoreOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherSeller(RetailscmUserContext userContext, String retailStoreOrderId, String anotherSellerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherSellerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
 		
 	}
 	public RetailStoreOrder transferToAnotherSeller(RetailscmUserContext userContext, String retailStoreOrderId, String anotherSellerId) throws Exception
 	{
 		checkParamsForTransferingAnotherSeller(userContext, retailStoreOrderId,anotherSellerId);
 
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter seller = loadRetailStoreCountryCenter(userContext, anotherSellerId, emptyOptions());		
			retailStoreOrder.updateSeller(seller);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, emptyOptions());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateSeller(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForRetailStoreOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherConfirmation(RetailscmUserContext userContext, String retailStoreOrderId, String anotherConfirmationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
 		userContext.getChecker().checkIdOfRetailStoreOrderConfirmation(anotherConfirmationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
 		
 	}
 	public RetailStoreOrder transferToAnotherConfirmation(RetailscmUserContext userContext, String retailStoreOrderId, String anotherConfirmationId) throws Exception
 	{
 		checkParamsForTransferingAnotherConfirmation(userContext, retailStoreOrderId,anotherConfirmationId);
 
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrderConfirmation confirmation = loadRetailStoreOrderConfirmation(userContext, anotherConfirmationId, emptyOptions());		
			retailStoreOrder.updateConfirmation(confirmation);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, emptyOptions());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreOrderConfirmation requestCandidateConfirmation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOrderConfirmation result = new CandidateRetailStoreOrderConfirmation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOrderConfirmation> candidateList = userContext.getDAOGroup().getRetailStoreOrderConfirmationDAO().requestCandidateRetailStoreOrderConfirmationForRetailStoreOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String CONFIRMED_STATUS = "CONFIRMED";
 	protected void checkParamsForConfirmation(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date confirmTime
) throws Exception
 	{
 				userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkWhoOfRetailStoreOrderConfirmation(who);
		userContext.getChecker().checkConfirmTimeOfRetailStoreOrderConfirmation(confirmTime);

	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);

 	}
 	public RetailStoreOrder confirm(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date confirmTime
) throws Exception
 	{
		checkParamsForConfirmation(userContext, retailStoreOrderId, who, confirmTime);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForConfirmation(userContext,retailStoreOrder);
 		

			retailStoreOrder.updateCurrentStatus(CONFIRMED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOrderConfirmation confirmation = createConfirmation(userContext, who, confirmTime);		
			retailStoreOrder.updateConfirmation(confirmation);		
			
			
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withConfirmation().done());
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public RetailStoreOrderForm confirmActionForm(RetailscmUserContext userContext, String retailStoreOrderId) throws Exception
 	{
		return new RetailStoreOrderForm()
			.withTitle("confirm")
			.retailStoreOrderIdField(retailStoreOrderId)
			.whoFieldOfRetailStoreOrderConfirmation()
			.confirmTimeFieldOfRetailStoreOrderConfirmation()
			.confirmAction();
 	}
	
 	
 	protected RetailStoreOrderConfirmation createConfirmation(RetailscmUserContext userContext, String who, Date confirmTime){
 		RetailStoreOrderConfirmation confirmation = new RetailStoreOrderConfirmation();
 		//who, confirmTime
 		
		confirmation.setWho(who);
		confirmation.setConfirmTime(confirmTime);

 		
 		
 		
 		return userContext.getDAOGroup().getRetailStoreOrderConfirmationDAO().save(confirmation,emptyOptions());
 	}
 	protected void checkIfEligibleForConfirmation(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{
 
 		ensureStatus(userContext,retailStoreOrder, CONFIRMED_STATUS);
 		
 		RetailStoreOrderConfirmation confirmation = retailStoreOrder.getConfirmation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = confirmation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( confirmation != null){
				throwExceptionWithMessage("The RetailStoreOrder("+retailStoreOrder.getId()+") has already been "+ CONFIRMED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherApproval(RetailscmUserContext userContext, String retailStoreOrderId, String anotherApprovalId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
 		userContext.getChecker().checkIdOfRetailStoreOrderApproval(anotherApprovalId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
 		
 	}
 	public RetailStoreOrder transferToAnotherApproval(RetailscmUserContext userContext, String retailStoreOrderId, String anotherApprovalId) throws Exception
 	{
 		checkParamsForTransferingAnotherApproval(userContext, retailStoreOrderId,anotherApprovalId);
 
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrderApproval approval = loadRetailStoreOrderApproval(userContext, anotherApprovalId, emptyOptions());		
			retailStoreOrder.updateApproval(approval);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, emptyOptions());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreOrderApproval requestCandidateApproval(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOrderApproval result = new CandidateRetailStoreOrderApproval();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOrderApproval> candidateList = userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().requestCandidateRetailStoreOrderApprovalForRetailStoreOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String APPROVED_STATUS = "APPROVED";
 	protected void checkParamsForApproval(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date approveTime
) throws Exception
 	{
 				userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkWhoOfRetailStoreOrderApproval(who);
		userContext.getChecker().checkApproveTimeOfRetailStoreOrderApproval(approveTime);

	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);

 	}
 	public RetailStoreOrder approve(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date approveTime
) throws Exception
 	{
		checkParamsForApproval(userContext, retailStoreOrderId, who, approveTime);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForApproval(userContext,retailStoreOrder);
 		

			retailStoreOrder.updateCurrentStatus(APPROVED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOrderApproval approval = createApproval(userContext, who, approveTime);		
			retailStoreOrder.updateApproval(approval);		
			
			
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withApproval().done());
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public RetailStoreOrderForm approveActionForm(RetailscmUserContext userContext, String retailStoreOrderId) throws Exception
 	{
		return new RetailStoreOrderForm()
			.withTitle("approve")
			.retailStoreOrderIdField(retailStoreOrderId)
			.whoFieldOfRetailStoreOrderApproval()
			.approveTimeFieldOfRetailStoreOrderApproval()
			.approveAction();
 	}
	
 	
 	protected RetailStoreOrderApproval createApproval(RetailscmUserContext userContext, String who, Date approveTime){
 		RetailStoreOrderApproval approval = new RetailStoreOrderApproval();
 		//who, approveTime
 		
		approval.setWho(who);
		approval.setApproveTime(approveTime);

 		
 		
 		
 		return userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().save(approval,emptyOptions());
 	}
 	protected void checkIfEligibleForApproval(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{
 
 		ensureStatus(userContext,retailStoreOrder, APPROVED_STATUS);
 		
 		RetailStoreOrderApproval approval = retailStoreOrder.getApproval();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = approval 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( approval != null){
				throwExceptionWithMessage("The RetailStoreOrder("+retailStoreOrder.getId()+") has already been "+ APPROVED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherProcessing(RetailscmUserContext userContext, String retailStoreOrderId, String anotherProcessingId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
 		userContext.getChecker().checkIdOfRetailStoreOrderProcessing(anotherProcessingId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
 		
 	}
 	public RetailStoreOrder transferToAnotherProcessing(RetailscmUserContext userContext, String retailStoreOrderId, String anotherProcessingId) throws Exception
 	{
 		checkParamsForTransferingAnotherProcessing(userContext, retailStoreOrderId,anotherProcessingId);
 
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrderProcessing processing = loadRetailStoreOrderProcessing(userContext, anotherProcessingId, emptyOptions());		
			retailStoreOrder.updateProcessing(processing);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, emptyOptions());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreOrderProcessing requestCandidateProcessing(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOrderProcessing result = new CandidateRetailStoreOrderProcessing();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOrderProcessing> candidateList = userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().requestCandidateRetailStoreOrderProcessingForRetailStoreOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String PROCESSED_STATUS = "PROCESSED";
 	protected void checkParamsForProcessing(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date processTime
) throws Exception
 	{
 				userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkWhoOfRetailStoreOrderProcessing(who);
		userContext.getChecker().checkProcessTimeOfRetailStoreOrderProcessing(processTime);

	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);

 	}
 	public RetailStoreOrder process(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date processTime
) throws Exception
 	{
		checkParamsForProcessing(userContext, retailStoreOrderId, who, processTime);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForProcessing(userContext,retailStoreOrder);
 		

			retailStoreOrder.updateCurrentStatus(PROCESSED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOrderProcessing processing = createProcessing(userContext, who, processTime);		
			retailStoreOrder.updateProcessing(processing);		
			
			
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withProcessing().done());
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public RetailStoreOrderForm processActionForm(RetailscmUserContext userContext, String retailStoreOrderId) throws Exception
 	{
		return new RetailStoreOrderForm()
			.withTitle("process")
			.retailStoreOrderIdField(retailStoreOrderId)
			.whoFieldOfRetailStoreOrderProcessing()
			.processTimeFieldOfRetailStoreOrderProcessing()
			.processAction();
 	}
	
 	
 	protected RetailStoreOrderProcessing createProcessing(RetailscmUserContext userContext, String who, Date processTime){
 		RetailStoreOrderProcessing processing = new RetailStoreOrderProcessing();
 		//who, processTime
 		
		processing.setWho(who);
		processing.setProcessTime(processTime);

 		
 		
 		
 		return userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().save(processing,emptyOptions());
 	}
 	protected void checkIfEligibleForProcessing(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{
 
 		ensureStatus(userContext,retailStoreOrder, PROCESSED_STATUS);
 		
 		RetailStoreOrderProcessing processing = retailStoreOrder.getProcessing();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = processing 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( processing != null){
				throwExceptionWithMessage("The RetailStoreOrder("+retailStoreOrder.getId()+") has already been "+ PROCESSED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherPicking(RetailscmUserContext userContext, String retailStoreOrderId, String anotherPickingId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
 		userContext.getChecker().checkIdOfRetailStoreOrderPicking(anotherPickingId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
 		
 	}
 	public RetailStoreOrder transferToAnotherPicking(RetailscmUserContext userContext, String retailStoreOrderId, String anotherPickingId) throws Exception
 	{
 		checkParamsForTransferingAnotherPicking(userContext, retailStoreOrderId,anotherPickingId);
 
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrderPicking picking = loadRetailStoreOrderPicking(userContext, anotherPickingId, emptyOptions());		
			retailStoreOrder.updatePicking(picking);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, emptyOptions());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreOrderPicking requestCandidatePicking(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOrderPicking result = new CandidateRetailStoreOrderPicking();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOrderPicking> candidateList = userContext.getDAOGroup().getRetailStoreOrderPickingDAO().requestCandidateRetailStoreOrderPickingForRetailStoreOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String PICKED_STATUS = "PICKED";
 	protected void checkParamsForPicking(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date processTime
) throws Exception
 	{
 				userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkWhoOfRetailStoreOrderPicking(who);
		userContext.getChecker().checkProcessTimeOfRetailStoreOrderPicking(processTime);

	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);

 	}
 	public RetailStoreOrder pick(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date processTime
) throws Exception
 	{
		checkParamsForPicking(userContext, retailStoreOrderId, who, processTime);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForPicking(userContext,retailStoreOrder);
 		

			retailStoreOrder.updateCurrentStatus(PICKED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOrderPicking picking = createPicking(userContext, who, processTime);		
			retailStoreOrder.updatePicking(picking);		
			
			
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withPicking().done());
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public RetailStoreOrderForm pickActionForm(RetailscmUserContext userContext, String retailStoreOrderId) throws Exception
 	{
		return new RetailStoreOrderForm()
			.withTitle("pick")
			.retailStoreOrderIdField(retailStoreOrderId)
			.whoFieldOfRetailStoreOrderPicking()
			.processTimeFieldOfRetailStoreOrderPicking()
			.pickAction();
 	}
	
 	
 	protected RetailStoreOrderPicking createPicking(RetailscmUserContext userContext, String who, Date processTime){
 		RetailStoreOrderPicking picking = new RetailStoreOrderPicking();
 		//who, processTime
 		
		picking.setWho(who);
		picking.setProcessTime(processTime);

 		
 		
 		
 		return userContext.getDAOGroup().getRetailStoreOrderPickingDAO().save(picking,emptyOptions());
 	}
 	protected void checkIfEligibleForPicking(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{
 
 		ensureStatus(userContext,retailStoreOrder, PICKED_STATUS);
 		
 		RetailStoreOrderPicking picking = retailStoreOrder.getPicking();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = picking 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( picking != null){
				throwExceptionWithMessage("The RetailStoreOrder("+retailStoreOrder.getId()+") has already been "+ PICKED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherShipment(RetailscmUserContext userContext, String retailStoreOrderId, String anotherShipmentId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
 		userContext.getChecker().checkIdOfRetailStoreOrderShipment(anotherShipmentId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
 		
 	}
 	public RetailStoreOrder transferToAnotherShipment(RetailscmUserContext userContext, String retailStoreOrderId, String anotherShipmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherShipment(userContext, retailStoreOrderId,anotherShipmentId);
 
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrderShipment shipment = loadRetailStoreOrderShipment(userContext, anotherShipmentId, emptyOptions());		
			retailStoreOrder.updateShipment(shipment);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, emptyOptions());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreOrderShipment requestCandidateShipment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOrderShipment result = new CandidateRetailStoreOrderShipment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOrderShipment> candidateList = userContext.getDAOGroup().getRetailStoreOrderShipmentDAO().requestCandidateRetailStoreOrderShipmentForRetailStoreOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String SHIPPED_STATUS = "SHIPPED";
 	protected void checkParamsForShipment(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date shipTime
) throws Exception
 	{
 				userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkWhoOfRetailStoreOrderShipment(who);
		userContext.getChecker().checkShipTimeOfRetailStoreOrderShipment(shipTime);

	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);

 	}
 	public RetailStoreOrder ship(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date shipTime
) throws Exception
 	{
		checkParamsForShipment(userContext, retailStoreOrderId, who, shipTime);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForShipment(userContext,retailStoreOrder);
 		

			retailStoreOrder.updateCurrentStatus(SHIPPED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOrderShipment shipment = createShipment(userContext, who, shipTime);		
			retailStoreOrder.updateShipment(shipment);		
			
			
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withShipment().done());
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public RetailStoreOrderForm shipActionForm(RetailscmUserContext userContext, String retailStoreOrderId) throws Exception
 	{
		return new RetailStoreOrderForm()
			.withTitle("ship")
			.retailStoreOrderIdField(retailStoreOrderId)
			.whoFieldOfRetailStoreOrderShipment()
			.shipTimeFieldOfRetailStoreOrderShipment()
			.shipAction();
 	}
	
 	
 	protected RetailStoreOrderShipment createShipment(RetailscmUserContext userContext, String who, Date shipTime){
 		RetailStoreOrderShipment shipment = new RetailStoreOrderShipment();
 		//who, shipTime
 		
		shipment.setWho(who);
		shipment.setShipTime(shipTime);

 		
 		
 		
 		return userContext.getDAOGroup().getRetailStoreOrderShipmentDAO().save(shipment,emptyOptions());
 	}
 	protected void checkIfEligibleForShipment(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{
 
 		ensureStatus(userContext,retailStoreOrder, SHIPPED_STATUS);
 		
 		RetailStoreOrderShipment shipment = retailStoreOrder.getShipment();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = shipment 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( shipment != null){
				throwExceptionWithMessage("The RetailStoreOrder("+retailStoreOrder.getId()+") has already been "+ SHIPPED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherDelivery(RetailscmUserContext userContext, String retailStoreOrderId, String anotherDeliveryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
 		userContext.getChecker().checkIdOfRetailStoreOrderDelivery(anotherDeliveryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
 		
 	}
 	public RetailStoreOrder transferToAnotherDelivery(RetailscmUserContext userContext, String retailStoreOrderId, String anotherDeliveryId) throws Exception
 	{
 		checkParamsForTransferingAnotherDelivery(userContext, retailStoreOrderId,anotherDeliveryId);
 
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrderDelivery delivery = loadRetailStoreOrderDelivery(userContext, anotherDeliveryId, emptyOptions());		
			retailStoreOrder.updateDelivery(delivery);		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, emptyOptions());
			
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreOrderDelivery requestCandidateDelivery(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOrderDelivery result = new CandidateRetailStoreOrderDelivery();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOrderDelivery> candidateList = userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().requestCandidateRetailStoreOrderDeliveryForRetailStoreOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String DELIVERED_STATUS = "DELIVERED";
 	protected void checkParamsForDelivery(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date deliveryTime
) throws Exception
 	{
 				userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkWhoOfRetailStoreOrderDelivery(who);
		userContext.getChecker().checkDeliveryTimeOfRetailStoreOrderDelivery(deliveryTime);

	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);

 	}
 	public RetailStoreOrder deliver(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date deliveryTime
) throws Exception
 	{
		checkParamsForDelivery(userContext, retailStoreOrderId, who, deliveryTime);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());	
		synchronized(retailStoreOrder){
			//will be good when the retailStoreOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForDelivery(userContext,retailStoreOrder);
 		

			retailStoreOrder.updateCurrentStatus(DELIVERED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOrderDelivery delivery = createDelivery(userContext, who, deliveryTime);		
			retailStoreOrder.updateDelivery(delivery);		
			
			
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withDelivery().done());
			return present(userContext,retailStoreOrder, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public RetailStoreOrderForm deliverActionForm(RetailscmUserContext userContext, String retailStoreOrderId) throws Exception
 	{
		return new RetailStoreOrderForm()
			.withTitle("deliver")
			.retailStoreOrderIdField(retailStoreOrderId)
			.whoFieldOfRetailStoreOrderDelivery()
			.deliveryTimeFieldOfRetailStoreOrderDelivery()
			.deliverAction();
 	}
	
 	
 	protected RetailStoreOrderDelivery createDelivery(RetailscmUserContext userContext, String who, Date deliveryTime){
 		RetailStoreOrderDelivery delivery = new RetailStoreOrderDelivery();
 		//who, deliveryTime
 		
		delivery.setWho(who);
		delivery.setDeliveryTime(deliveryTime);

 		
 		
 		
 		return userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().save(delivery,emptyOptions());
 	}
 	protected void checkIfEligibleForDelivery(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception{
 
 		ensureStatus(userContext,retailStoreOrder, DELIVERED_STATUS);
 		
 		RetailStoreOrderDelivery delivery = retailStoreOrder.getDelivery();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = delivery 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( delivery != null){
				throwExceptionWithMessage("The RetailStoreOrder("+retailStoreOrder.getId()+") has already been "+ DELIVERED_STATUS+".");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected RetailStoreOrderApproval loadRetailStoreOrderApproval(RetailscmUserContext userContext, String newApprovalId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreOrderApprovalDAO().load(newApprovalId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newSellerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newSellerId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreOrderDelivery loadRetailStoreOrderDelivery(RetailscmUserContext userContext, String newDeliveryId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreOrderDeliveryDAO().load(newDeliveryId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreOrderPicking loadRetailStoreOrderPicking(RetailscmUserContext userContext, String newPickingId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreOrderPickingDAO().load(newPickingId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreOrderShipment loadRetailStoreOrderShipment(RetailscmUserContext userContext, String newShipmentId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreOrderShipmentDAO().load(newShipmentId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreOrderConfirmation loadRetailStoreOrderConfirmation(RetailscmUserContext userContext, String newConfirmationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreOrderConfirmationDAO().load(newConfirmationId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStore loadRetailStore(RetailscmUserContext userContext, String newBuyerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreDAO().load(newBuyerId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreOrderProcessing loadRetailStoreOrderProcessing(RetailscmUserContext userContext, String newProcessingId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreOrderProcessingDAO().load(newProcessingId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOrderId, int retailStoreOrderVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderId, retailStoreOrderVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderId, int retailStoreOrderVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreOrderDAO().delete(retailStoreOrderId, retailStoreOrderVersion);
	}
	
	public RetailStoreOrder forgetByAll(RetailscmUserContext userContext, String retailStoreOrderId, int retailStoreOrderVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderId, retailStoreOrderVersion);		
	}
	protected RetailStoreOrder forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderId, int retailStoreOrderVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreOrderDAO().disconnectFromAll(retailStoreOrderId, retailStoreOrderVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreOrderDAO().deleteAll();
	}


	//disconnect RetailStoreOrder with sku_id in RetailStoreOrderLineItem
	protected RetailStoreOrder breakWithRetailStoreOrderLineItemBySkuId(RetailscmUserContext userContext, String retailStoreOrderId, String skuIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());

			synchronized(retailStoreOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveRetailStoreOrderLineItemListWithSkuId(retailStoreOrder, skuIdId, this.emptyOptions());

				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderLineItemList().done());
				return retailStoreOrder;
			}
	}
	//disconnect RetailStoreOrder with sku in Goods
	protected RetailStoreOrder breakWithGoodsBySku(RetailscmUserContext userContext, String retailStoreOrderId, String skuId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());

			synchronized(retailStoreOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveGoodsListWithSku(retailStoreOrder, skuId, this.emptyOptions());

				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
				return retailStoreOrder;
			}
	}
	//disconnect RetailStoreOrder with receiving_space in Goods
	protected RetailStoreOrder breakWithGoodsByReceivingSpace(RetailscmUserContext userContext, String retailStoreOrderId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());

			synchronized(retailStoreOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveGoodsListWithReceivingSpace(retailStoreOrder, receivingSpaceId, this.emptyOptions());

				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
				return retailStoreOrder;
			}
	}
	//disconnect RetailStoreOrder with goods_allocation in Goods
	protected RetailStoreOrder breakWithGoodsByGoodsAllocation(RetailscmUserContext userContext, String retailStoreOrderId, String goodsAllocationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());

			synchronized(retailStoreOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveGoodsListWithGoodsAllocation(retailStoreOrder, goodsAllocationId, this.emptyOptions());

				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
				return retailStoreOrder;
			}
	}
	//disconnect RetailStoreOrder with smart_pallet in Goods
	protected RetailStoreOrder breakWithGoodsBySmartPallet(RetailscmUserContext userContext, String retailStoreOrderId, String smartPalletId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());

			synchronized(retailStoreOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveGoodsListWithSmartPallet(retailStoreOrder, smartPalletId, this.emptyOptions());

				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
				return retailStoreOrder;
			}
	}
	//disconnect RetailStoreOrder with shipping_space in Goods
	protected RetailStoreOrder breakWithGoodsByShippingSpace(RetailscmUserContext userContext, String retailStoreOrderId, String shippingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());

			synchronized(retailStoreOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveGoodsListWithShippingSpace(retailStoreOrder, shippingSpaceId, this.emptyOptions());

				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
				return retailStoreOrder;
			}
	}
	//disconnect RetailStoreOrder with transport_task in Goods
	protected RetailStoreOrder breakWithGoodsByTransportTask(RetailscmUserContext userContext, String retailStoreOrderId, String transportTaskId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());

			synchronized(retailStoreOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveGoodsListWithTransportTask(retailStoreOrder, transportTaskId, this.emptyOptions());

				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
				return retailStoreOrder;
			}
	}
	//disconnect RetailStoreOrder with retail_store in Goods
	protected RetailStoreOrder breakWithGoodsByRetailStore(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());

			synchronized(retailStoreOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveGoodsListWithRetailStore(retailStoreOrder, retailStoreId, this.emptyOptions());

				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
				return retailStoreOrder;
			}
	}
	//disconnect RetailStoreOrder with biz_order in Goods
	protected RetailStoreOrder breakWithGoodsByBizOrder(RetailscmUserContext userContext, String retailStoreOrderId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());

			synchronized(retailStoreOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveGoodsListWithBizOrder(retailStoreOrder, bizOrderId, this.emptyOptions());

				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
				return retailStoreOrder;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);

		
		userContext.getChecker().checkSkuIdOfRetailStoreOrderLineItem(skuId);
		
		userContext.getChecker().checkSkuNameOfRetailStoreOrderLineItem(skuName);
		
		userContext.getChecker().checkAmountOfRetailStoreOrderLineItem(amount);
		
		userContext.getChecker().checkQuantityOfRetailStoreOrderLineItem(quantity);
		
		userContext.getChecker().checkUnitOfMeasurementOfRetailStoreOrderLineItem(unitOfMeasurement);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);

	
	}
	public  RetailStoreOrder addRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrderLineItem(userContext,retailStoreOrderId,skuId, skuName, amount, quantity, unitOfMeasurement,tokensExpr);
		
		RetailStoreOrderLineItem retailStoreOrderLineItem = createRetailStoreOrderLineItem(userContext,skuId, skuName, amount, quantity, unitOfMeasurement);
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.addRetailStoreOrderLineItem( retailStoreOrderLineItem );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderLineItemList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderLineItemManager().onNewInstanceCreated(userContext, retailStoreOrderLineItem);
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderLineItemProperties(RetailscmUserContext userContext, String retailStoreOrderId,String id,String skuId,String skuName,BigDecimal amount,int quantity,String unitOfMeasurement,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkIdOfRetailStoreOrderLineItem(id);
		
		userContext.getChecker().checkSkuIdOfRetailStoreOrderLineItem( skuId);
		userContext.getChecker().checkSkuNameOfRetailStoreOrderLineItem( skuName);
		userContext.getChecker().checkAmountOfRetailStoreOrderLineItem( amount);
		userContext.getChecker().checkQuantityOfRetailStoreOrderLineItem( quantity);
		userContext.getChecker().checkUnitOfMeasurementOfRetailStoreOrderLineItem( unitOfMeasurement);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
		
	}
	public  RetailStoreOrder updateRetailStoreOrderLineItemProperties(RetailscmUserContext userContext, String retailStoreOrderId, String id,String skuId,String skuName,BigDecimal amount,int quantity,String unitOfMeasurement, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreOrderLineItemProperties(userContext,retailStoreOrderId,id,skuId,skuName,amount,quantity,unitOfMeasurement,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderLineItemListList()
				.searchRetailStoreOrderLineItemListWith(RetailStoreOrderLineItem.ID_PROPERTY, "is", id).done();
		
		RetailStoreOrder retailStoreOrderToUpdate = loadRetailStoreOrder(userContext, retailStoreOrderId, options);
		
		if(retailStoreOrderToUpdate.getRetailStoreOrderLineItemList().isEmpty()){
			throw new RetailStoreOrderManagerException("RetailStoreOrderLineItem is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreOrderLineItem item = retailStoreOrderToUpdate.getRetailStoreOrderLineItemList().first();
		
		item.updateSkuId( skuId );
		item.updateSkuName( skuName );
		item.updateAmount( amount );
		item.updateQuantity( quantity );
		item.updateUnitOfMeasurement( unitOfMeasurement );

		
		//checkParamsForAddingRetailStoreOrderLineItem(userContext,retailStoreOrderId,name, code, used,tokensExpr);
		RetailStoreOrder retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrderToUpdate, tokens().withRetailStoreOrderLineItemList().done());
		synchronized(retailStoreOrder){ 
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RetailStoreOrderLineItem createRetailStoreOrderLineItem(RetailscmUserContext userContext, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement) throws Exception{

		RetailStoreOrderLineItem retailStoreOrderLineItem = new RetailStoreOrderLineItem();
		
		
		retailStoreOrderLineItem.setSkuId(skuId);		
		retailStoreOrderLineItem.setSkuName(skuName);		
		retailStoreOrderLineItem.setAmount(amount);		
		retailStoreOrderLineItem.setQuantity(quantity);		
		retailStoreOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);
	
		
		return retailStoreOrderLineItem;
	
		
	}
	
	protected RetailStoreOrderLineItem createIndexedRetailStoreOrderLineItem(String id, int version){

		RetailStoreOrderLineItem retailStoreOrderLineItem = new RetailStoreOrderLineItem();
		retailStoreOrderLineItem.setId(id);
		retailStoreOrderLineItem.setVersion(version);
		return retailStoreOrderLineItem;			
		
	}
	
	protected void checkParamsForRemovingRetailStoreOrderLineItemList(RetailscmUserContext userContext, String retailStoreOrderId, 
			String retailStoreOrderLineItemIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		for(String retailStoreOrderLineItemId: retailStoreOrderLineItemIds){
			userContext.getChecker().checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
		
	}
	public  RetailStoreOrder removeRetailStoreOrderLineItemList(RetailscmUserContext userContext, String retailStoreOrderId, 
			String retailStoreOrderLineItemIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreOrderLineItemList(userContext, retailStoreOrderId,  retailStoreOrderLineItemIds, tokensExpr);
			
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
			synchronized(retailStoreOrder){ 
				//Will be good when the retailStoreOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveRetailStoreOrderLineItemList(retailStoreOrder, retailStoreOrderLineItemIds, allTokens());
				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderLineItemList().done());
				deleteRelationListInGraph(userContext, retailStoreOrder.getRetailStoreOrderLineItemList());
				return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrder( retailStoreOrderId);
		userContext.getChecker().checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
		userContext.getChecker().checkVersionOfRetailStoreOrderLineItem(retailStoreOrderLineItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
	}
	public  RetailStoreOrder removeRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrderLineItem(userContext,retailStoreOrderId, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion,tokensExpr);
		
		RetailStoreOrderLineItem retailStoreOrderLineItem = createIndexedRetailStoreOrderLineItem(retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.removeRetailStoreOrderLineItem( retailStoreOrderLineItem );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderLineItemList().done());
			deleteRelationInGraph(userContext, retailStoreOrderLineItem);
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrder( retailStoreOrderId);
		userContext.getChecker().checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
		userContext.getChecker().checkVersionOfRetailStoreOrderLineItem(retailStoreOrderLineItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
	}
	public  RetailStoreOrder copyRetailStoreOrderLineItemFrom(RetailscmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrderLineItem(userContext,retailStoreOrderId, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion,tokensExpr);
		
		RetailStoreOrderLineItem retailStoreOrderLineItem = createIndexedRetailStoreOrderLineItem(retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStoreOrder.copyRetailStoreOrderLineItemFrom( retailStoreOrderLineItem );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderLineItemList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderLineItemManager().onNewInstanceCreated(userContext, (RetailStoreOrderLineItem)retailStoreOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkIdOfRetailStoreOrderLineItem(retailStoreOrderLineItemId);
		userContext.getChecker().checkVersionOfRetailStoreOrderLineItem(retailStoreOrderLineItemVersion);
		

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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
	}
	
	public  RetailStoreOrder updateRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrderLineItem(userContext, retailStoreOrderId, retailStoreOrderLineItemId, retailStoreOrderLineItemVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderLineItemList().searchRetailStoreOrderLineItemListWith(RetailStoreOrderLineItem.ID_PROPERTY, "eq", retailStoreOrderLineItemId).done();
		
		
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, loadTokens);
		
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrder.removeRetailStoreOrderLineItem( retailStoreOrderLineItem );	
			//make changes to AcceleraterAccount.
			RetailStoreOrderLineItem retailStoreOrderLineItemIndex = createIndexedRetailStoreOrderLineItem(retailStoreOrderLineItemId, retailStoreOrderLineItemVersion);
		
			RetailStoreOrderLineItem retailStoreOrderLineItem = retailStoreOrder.findTheRetailStoreOrderLineItem(retailStoreOrderLineItemIndex);
			if(retailStoreOrderLineItem == null){
				throw new RetailStoreOrderManagerException(retailStoreOrderLineItem+" is NOT FOUND" );
			}
			
			retailStoreOrderLineItem.changeProperty(property, newValueExpr);
			
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderLineItemList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderId, String name, BigDecimal amount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);

		
		userContext.getChecker().checkNameOfRetailStoreOrderShippingGroup(name);
		
		userContext.getChecker().checkAmountOfRetailStoreOrderShippingGroup(amount);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);

	
	}
	public  RetailStoreOrder addRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderId, String name, BigDecimal amount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrderShippingGroup(userContext,retailStoreOrderId,name, amount,tokensExpr);
		
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = createRetailStoreOrderShippingGroup(userContext,name, amount);
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.addRetailStoreOrderShippingGroup( retailStoreOrderShippingGroup );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderShippingGroupList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderShippingGroupManager().onNewInstanceCreated(userContext, retailStoreOrderShippingGroup);
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderShippingGroupProperties(RetailscmUserContext userContext, String retailStoreOrderId,String id,String name,BigDecimal amount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkIdOfRetailStoreOrderShippingGroup(id);
		
		userContext.getChecker().checkNameOfRetailStoreOrderShippingGroup( name);
		userContext.getChecker().checkAmountOfRetailStoreOrderShippingGroup( amount);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
		
	}
	public  RetailStoreOrder updateRetailStoreOrderShippingGroupProperties(RetailscmUserContext userContext, String retailStoreOrderId, String id,String name,BigDecimal amount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreOrderShippingGroupProperties(userContext,retailStoreOrderId,id,name,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderShippingGroupListList()
				.searchRetailStoreOrderShippingGroupListWith(RetailStoreOrderShippingGroup.ID_PROPERTY, "is", id).done();
		
		RetailStoreOrder retailStoreOrderToUpdate = loadRetailStoreOrder(userContext, retailStoreOrderId, options);
		
		if(retailStoreOrderToUpdate.getRetailStoreOrderShippingGroupList().isEmpty()){
			throw new RetailStoreOrderManagerException("RetailStoreOrderShippingGroup is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreOrderShippingGroup item = retailStoreOrderToUpdate.getRetailStoreOrderShippingGroupList().first();
		
		item.updateName( name );
		item.updateAmount( amount );

		
		//checkParamsForAddingRetailStoreOrderShippingGroup(userContext,retailStoreOrderId,name, code, used,tokensExpr);
		RetailStoreOrder retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrderToUpdate, tokens().withRetailStoreOrderShippingGroupList().done());
		synchronized(retailStoreOrder){ 
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RetailStoreOrderShippingGroup createRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String name, BigDecimal amount) throws Exception{

		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = new RetailStoreOrderShippingGroup();
		
		
		retailStoreOrderShippingGroup.setName(name);		
		retailStoreOrderShippingGroup.setAmount(amount);
	
		
		return retailStoreOrderShippingGroup;
	
		
	}
	
	protected RetailStoreOrderShippingGroup createIndexedRetailStoreOrderShippingGroup(String id, int version){

		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = new RetailStoreOrderShippingGroup();
		retailStoreOrderShippingGroup.setId(id);
		retailStoreOrderShippingGroup.setVersion(version);
		return retailStoreOrderShippingGroup;			
		
	}
	
	protected void checkParamsForRemovingRetailStoreOrderShippingGroupList(RetailscmUserContext userContext, String retailStoreOrderId, 
			String retailStoreOrderShippingGroupIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		for(String retailStoreOrderShippingGroupId: retailStoreOrderShippingGroupIds){
			userContext.getChecker().checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
		
	}
	public  RetailStoreOrder removeRetailStoreOrderShippingGroupList(RetailscmUserContext userContext, String retailStoreOrderId, 
			String retailStoreOrderShippingGroupIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreOrderShippingGroupList(userContext, retailStoreOrderId,  retailStoreOrderShippingGroupIds, tokensExpr);
			
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
			synchronized(retailStoreOrder){ 
				//Will be good when the retailStoreOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveRetailStoreOrderShippingGroupList(retailStoreOrder, retailStoreOrderShippingGroupIds, allTokens());
				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderShippingGroupList().done());
				deleteRelationListInGraph(userContext, retailStoreOrder.getRetailStoreOrderShippingGroupList());
				return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrder( retailStoreOrderId);
		userContext.getChecker().checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);
		userContext.getChecker().checkVersionOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
	}
	public  RetailStoreOrder removeRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrderShippingGroup(userContext,retailStoreOrderId, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion,tokensExpr);
		
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = createIndexedRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.removeRetailStoreOrderShippingGroup( retailStoreOrderShippingGroup );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderShippingGroupList().done());
			deleteRelationInGraph(userContext, retailStoreOrderShippingGroup);
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrder( retailStoreOrderId);
		userContext.getChecker().checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);
		userContext.getChecker().checkVersionOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
	}
	public  RetailStoreOrder copyRetailStoreOrderShippingGroupFrom(RetailscmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrderShippingGroup(userContext,retailStoreOrderId, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion,tokensExpr);
		
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = createIndexedRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStoreOrder.copyRetailStoreOrderShippingGroupFrom( retailStoreOrderShippingGroup );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderShippingGroupList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderShippingGroupManager().onNewInstanceCreated(userContext, (RetailStoreOrderShippingGroup)retailStoreOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);
		userContext.getChecker().checkVersionOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupVersion);
		

		if(RetailStoreOrderShippingGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStoreOrderShippingGroup(parseString(newValueExpr));
		}
		
		if(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfRetailStoreOrderShippingGroup(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
	}
	
	public  RetailStoreOrder updateRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrderShippingGroup(userContext, retailStoreOrderId, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderShippingGroupList().searchRetailStoreOrderShippingGroupListWith(RetailStoreOrderShippingGroup.ID_PROPERTY, "eq", retailStoreOrderShippingGroupId).done();
		
		
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, loadTokens);
		
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrder.removeRetailStoreOrderShippingGroup( retailStoreOrderShippingGroup );	
			//make changes to AcceleraterAccount.
			RetailStoreOrderShippingGroup retailStoreOrderShippingGroupIndex = createIndexedRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
		
			RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = retailStoreOrder.findTheRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupIndex);
			if(retailStoreOrderShippingGroup == null){
				throw new RetailStoreOrderManagerException(retailStoreOrderShippingGroup+" is NOT FOUND" );
			}
			
			retailStoreOrderShippingGroup.changeProperty(property, newValueExpr);
			
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderShippingGroupList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderId, String name, String cardNumber,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);

		
		userContext.getChecker().checkNameOfRetailStoreOrderPaymentGroup(name);
		
		userContext.getChecker().checkCardNumberOfRetailStoreOrderPaymentGroup(cardNumber);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);

	
	}
	public  RetailStoreOrder addRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderId, String name, String cardNumber, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrderPaymentGroup(userContext,retailStoreOrderId,name, cardNumber,tokensExpr);
		
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = createRetailStoreOrderPaymentGroup(userContext,name, cardNumber);
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.addRetailStoreOrderPaymentGroup( retailStoreOrderPaymentGroup );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderPaymentGroupList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderPaymentGroupManager().onNewInstanceCreated(userContext, retailStoreOrderPaymentGroup);
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderPaymentGroupProperties(RetailscmUserContext userContext, String retailStoreOrderId,String id,String name,String cardNumber,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkIdOfRetailStoreOrderPaymentGroup(id);
		
		userContext.getChecker().checkNameOfRetailStoreOrderPaymentGroup( name);
		userContext.getChecker().checkCardNumberOfRetailStoreOrderPaymentGroup( cardNumber);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
		
	}
	public  RetailStoreOrder updateRetailStoreOrderPaymentGroupProperties(RetailscmUserContext userContext, String retailStoreOrderId, String id,String name,String cardNumber, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreOrderPaymentGroupProperties(userContext,retailStoreOrderId,id,name,cardNumber,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderPaymentGroupListList()
				.searchRetailStoreOrderPaymentGroupListWith(RetailStoreOrderPaymentGroup.ID_PROPERTY, "is", id).done();
		
		RetailStoreOrder retailStoreOrderToUpdate = loadRetailStoreOrder(userContext, retailStoreOrderId, options);
		
		if(retailStoreOrderToUpdate.getRetailStoreOrderPaymentGroupList().isEmpty()){
			throw new RetailStoreOrderManagerException("RetailStoreOrderPaymentGroup is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreOrderPaymentGroup item = retailStoreOrderToUpdate.getRetailStoreOrderPaymentGroupList().first();
		
		item.updateName( name );
		item.updateCardNumber( cardNumber );

		
		//checkParamsForAddingRetailStoreOrderPaymentGroup(userContext,retailStoreOrderId,name, code, used,tokensExpr);
		RetailStoreOrder retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrderToUpdate, tokens().withRetailStoreOrderPaymentGroupList().done());
		synchronized(retailStoreOrder){ 
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String name, String cardNumber) throws Exception{

		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = new RetailStoreOrderPaymentGroup();
		
		
		retailStoreOrderPaymentGroup.setName(name);		
		retailStoreOrderPaymentGroup.setCardNumber(cardNumber);
	
		
		return retailStoreOrderPaymentGroup;
	
		
	}
	
	protected RetailStoreOrderPaymentGroup createIndexedRetailStoreOrderPaymentGroup(String id, int version){

		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = new RetailStoreOrderPaymentGroup();
		retailStoreOrderPaymentGroup.setId(id);
		retailStoreOrderPaymentGroup.setVersion(version);
		return retailStoreOrderPaymentGroup;			
		
	}
	
	protected void checkParamsForRemovingRetailStoreOrderPaymentGroupList(RetailscmUserContext userContext, String retailStoreOrderId, 
			String retailStoreOrderPaymentGroupIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		for(String retailStoreOrderPaymentGroupId: retailStoreOrderPaymentGroupIds){
			userContext.getChecker().checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
		
	}
	public  RetailStoreOrder removeRetailStoreOrderPaymentGroupList(RetailscmUserContext userContext, String retailStoreOrderId, 
			String retailStoreOrderPaymentGroupIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreOrderPaymentGroupList(userContext, retailStoreOrderId,  retailStoreOrderPaymentGroupIds, tokensExpr);
			
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
			synchronized(retailStoreOrder){ 
				//Will be good when the retailStoreOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveRetailStoreOrderPaymentGroupList(retailStoreOrder, retailStoreOrderPaymentGroupIds, allTokens());
				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderPaymentGroupList().done());
				deleteRelationListInGraph(userContext, retailStoreOrder.getRetailStoreOrderPaymentGroupList());
				return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrder( retailStoreOrderId);
		userContext.getChecker().checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		userContext.getChecker().checkVersionOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
	}
	public  RetailStoreOrder removeRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrderPaymentGroup(userContext,retailStoreOrderId, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion,tokensExpr);
		
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = createIndexedRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.removeRetailStoreOrderPaymentGroup( retailStoreOrderPaymentGroup );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderPaymentGroupList().done());
			deleteRelationInGraph(userContext, retailStoreOrderPaymentGroup);
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrder( retailStoreOrderId);
		userContext.getChecker().checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		userContext.getChecker().checkVersionOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
	}
	public  RetailStoreOrder copyRetailStoreOrderPaymentGroupFrom(RetailscmUserContext userContext, String retailStoreOrderId, 
		String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrderPaymentGroup(userContext,retailStoreOrderId, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion,tokensExpr);
		
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = createIndexedRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStoreOrder.copyRetailStoreOrderPaymentGroupFrom( retailStoreOrderPaymentGroup );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderPaymentGroupList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderPaymentGroupManager().onNewInstanceCreated(userContext, (RetailStoreOrderPaymentGroup)retailStoreOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		userContext.getChecker().checkVersionOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupVersion);
		

		if(RetailStoreOrderPaymentGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStoreOrderPaymentGroup(parseString(newValueExpr));
		}
		
		if(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkCardNumberOfRetailStoreOrderPaymentGroup(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
	}
	
	public  RetailStoreOrder updateRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrderPaymentGroup(userContext, retailStoreOrderId, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderPaymentGroupList().searchRetailStoreOrderPaymentGroupListWith(RetailStoreOrderPaymentGroup.ID_PROPERTY, "eq", retailStoreOrderPaymentGroupId).done();
		
		
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, loadTokens);
		
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrder.removeRetailStoreOrderPaymentGroup( retailStoreOrderPaymentGroup );	
			//make changes to AcceleraterAccount.
			RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroupIndex = createIndexedRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
		
			RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = retailStoreOrder.findTheRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupIndex);
			if(retailStoreOrderPaymentGroup == null){
				throw new RetailStoreOrderManagerException(retailStoreOrderPaymentGroup+" is NOT FOUND" );
			}
			
			retailStoreOrderPaymentGroup.changeProperty(property, newValueExpr);
			
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withRetailStoreOrderPaymentGroupList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String retailStoreOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);

		
		userContext.getChecker().checkNameOfGoods(name);
		
		userContext.getChecker().checkRfidOfGoods(rfid);
		
		userContext.getChecker().checkUomOfGoods(uom);
		
		userContext.getChecker().checkMaxPackageOfGoods(maxPackage);
		
		userContext.getChecker().checkExpireTimeOfGoods(expireTime);
		
		userContext.getChecker().checkSkuIdOfGoods(skuId);
		
		userContext.getChecker().checkReceivingSpaceIdOfGoods(receivingSpaceId);
		
		userContext.getChecker().checkGoodsAllocationIdOfGoods(goodsAllocationId);
		
		userContext.getChecker().checkSmartPalletIdOfGoods(smartPalletId);
		
		userContext.getChecker().checkShippingSpaceIdOfGoods(shippingSpaceId);
		
		userContext.getChecker().checkTransportTaskIdOfGoods(transportTaskId);
		
		userContext.getChecker().checkRetailStoreIdOfGoods(retailStoreId);
		
		userContext.getChecker().checkBizOrderIdOfGoods(bizOrderId);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);

	
	}
	public  RetailStoreOrder addGoods(RetailscmUserContext userContext, String retailStoreOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,retailStoreOrderId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, bizOrderId);
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.addGoods( goods );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, goods);
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String retailStoreOrderId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkIdOfGoods(id);
		
		userContext.getChecker().checkNameOfGoods( name);
		userContext.getChecker().checkRfidOfGoods( rfid);
		userContext.getChecker().checkUomOfGoods( uom);
		userContext.getChecker().checkMaxPackageOfGoods( maxPackage);
		userContext.getChecker().checkExpireTimeOfGoods( expireTime);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
		
	}
	public  RetailStoreOrder updateGoodsProperties(RetailscmUserContext userContext, String retailStoreOrderId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGoodsProperties(userContext,retailStoreOrderId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, "is", id).done();
		
		RetailStoreOrder retailStoreOrderToUpdate = loadRetailStoreOrder(userContext, retailStoreOrderId, options);
		
		if(retailStoreOrderToUpdate.getGoodsList().isEmpty()){
			throw new RetailStoreOrderManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}
		
		Goods item = retailStoreOrderToUpdate.getGoodsList().first();
		
		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );

		
		//checkParamsForAddingGoods(userContext,retailStoreOrderId,name, code, used,tokensExpr);
		RetailStoreOrder retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrderToUpdate, tokens().withGoodsList().done());
		synchronized(retailStoreOrder){ 
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Goods createGoods(RetailscmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId) throws Exception{

		Goods goods = new Goods();
		
		
		goods.setName(name);		
		goods.setRfid(rfid);		
		goods.setUom(uom);		
		goods.setMaxPackage(maxPackage);		
		goods.setExpireTime(expireTime);		
		Sku  sku = new Sku();
		sku.setId(skuId);		
		goods.setSku(sku);		
		ReceivingSpace  receivingSpace = new ReceivingSpace();
		receivingSpace.setId(receivingSpaceId);		
		goods.setReceivingSpace(receivingSpace);		
		GoodsAllocation  goodsAllocation = new GoodsAllocation();
		goodsAllocation.setId(goodsAllocationId);		
		goods.setGoodsAllocation(goodsAllocation);		
		SmartPallet  smartPallet = new SmartPallet();
		smartPallet.setId(smartPalletId);		
		goods.setSmartPallet(smartPallet);		
		ShippingSpace  shippingSpace = new ShippingSpace();
		shippingSpace.setId(shippingSpaceId);		
		goods.setShippingSpace(shippingSpace);		
		TransportTask  transportTask = new TransportTask();
		transportTask.setId(transportTaskId);		
		goods.setTransportTask(transportTask);		
		RetailStore  retailStore = new RetailStore();
		retailStore.setId(retailStoreId);		
		goods.setRetailStore(retailStore);		
		SupplyOrder  bizOrder = new SupplyOrder();
		bizOrder.setId(bizOrderId);		
		goods.setBizOrder(bizOrder);		
		goods.setCurrentStatus("INIT");
	
		
		return goods;
	
		
	}
	
	protected Goods createIndexedGoods(String id, int version){

		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(version);
		return goods;			
		
	}
	
	protected void checkParamsForRemovingGoodsList(RetailscmUserContext userContext, String retailStoreOrderId, 
			String goodsIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		for(String goodsId: goodsIds){
			userContext.getChecker().checkIdOfGoods(goodsId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
		
	}
	public  RetailStoreOrder removeGoodsList(RetailscmUserContext userContext, String retailStoreOrderId, 
			String goodsIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGoodsList(userContext, retailStoreOrderId,  goodsIds, tokensExpr);
			
			
			RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
			synchronized(retailStoreOrder){ 
				//Will be good when the retailStoreOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreOrderDAO().planToRemoveGoodsList(retailStoreOrder, goodsIds, allTokens());
				retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, retailStoreOrder.getGoodsList());
				return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String retailStoreOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrder( retailStoreOrderId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
	}
	public  RetailStoreOrder removeGoods(RetailscmUserContext userContext, String retailStoreOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,retailStoreOrderId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOrder.removeGoods( goods );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGoods(RetailscmUserContext userContext, String retailStoreOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOrder( retailStoreOrderId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
	}
	public  RetailStoreOrder copyGoodsFrom(RetailscmUserContext userContext, String retailStoreOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,retailStoreOrderId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, allTokens());
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStoreOrder.copyGoodsFrom( goods );		
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, (Goods)retailStoreOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String retailStoreOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		

		if(Goods.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.RFID_PROPERTY.equals(property)){
			userContext.getChecker().checkRfidOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.UOM_PROPERTY.equals(property)){
			userContext.getChecker().checkUomOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.MAX_PACKAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkMaxPackageOfGoods(parseInt(newValueExpr));
		}
		
		if(Goods.EXPIRE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkExpireTimeOfGoods(parseDate(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderManagerException.class);
	
	}
	
	public  RetailStoreOrder updateGoods(RetailscmUserContext userContext, String retailStoreOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, retailStoreOrderId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, "eq", goodsId).done();
		
		
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, loadTokens);
		
		synchronized(retailStoreOrder){ 
			//Will be good when the retailStoreOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOrder.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = retailStoreOrder.findTheGoods(goodsIndex);
			if(goods == null){
				throw new RetailStoreOrderManagerException(goods+" is NOT FOUND" );
			}
			
			goods.changeProperty(property, newValueExpr);
			
			retailStoreOrder = saveRetailStoreOrder(userContext, retailStoreOrder, tokens().withGoodsList().done());
			return present(userContext,retailStoreOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStoreOrder associateGoodsListToNewPackaging(RetailscmUserContext userContext, String retailStoreOrderId, String  goodsIds[], String packageName, String rfid, Date packageTime, String description, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().createGoodsPackaging(userContext,  packageName,  rfid,  packageTime,  description);
		
		for(Goods goods: retailStoreOrder.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveRetailStoreOrder(userContext, retailStoreOrder);
	}
	*/
	
	public  RetailStoreOrder associateGoodsListToPackaging(RetailscmUserContext userContext, String retailStoreOrderId, String  goodsIds[], String packagingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		RetailStoreOrder retailStoreOrder = loadRetailStoreOrder(userContext, retailStoreOrderId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().loadGoodsPackaging(userContext,packagingId,new String[]{"none"} );
		
		for(Goods goods: retailStoreOrder.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveRetailStoreOrder(userContext, retailStoreOrder);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrder newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


