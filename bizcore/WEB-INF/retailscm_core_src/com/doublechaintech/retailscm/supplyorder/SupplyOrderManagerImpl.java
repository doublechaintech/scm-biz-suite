
package com.doublechaintech.retailscm.supplyorder;

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

import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.supplyorderapproval.SupplyOrderApproval;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.doublechaintech.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.doublechaintech.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.doublechaintech.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.doublechaintech.retailscm.supplyordershipment.SupplyOrderShipment;

import com.doublechaintech.retailscm.supplyorderapproval.CandidateSupplyOrderApproval;
import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.CandidateGoodsSupplier;
import com.doublechaintech.retailscm.supplyorderdelivery.CandidateSupplyOrderDelivery;
import com.doublechaintech.retailscm.supplyorderpicking.CandidateSupplyOrderPicking;
import com.doublechaintech.retailscm.supplyorderprocessing.CandidateSupplyOrderProcessing;
import com.doublechaintech.retailscm.supplyorderconfirmation.CandidateSupplyOrderConfirmation;
import com.doublechaintech.retailscm.supplyordershipment.CandidateSupplyOrderShipment;

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






public class SupplyOrderManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderManager {
	
	private static final String SERVICE_TYPE = "SupplyOrder";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplyOrderManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderManagerException(message);

	}
	
	

 	protected SupplyOrder saveSupplyOrder(RetailscmUserContext userContext, SupplyOrder supplyOrder, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderDAO().save(supplyOrder, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrder(userContext, supplyOrder, tokens);
 	}
 	
 	protected SupplyOrder saveSupplyOrderDetail(RetailscmUserContext userContext, SupplyOrder supplyOrder) throws Exception{	

 		
 		return saveSupplyOrder(userContext, supplyOrder, allTokens());
 	}
 	
 	public SupplyOrder loadSupplyOrder(RetailscmUserContext userContext, String supplyOrderId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrder supplyOrder = loadSupplyOrder( userContext, supplyOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrder, tokens);
 	}
 	
 	
 	 public SupplyOrder searchSupplyOrder(RetailscmUserContext userContext, String supplyOrderId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrder supplyOrder = loadSupplyOrder( userContext, supplyOrderId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrder, tokens);
 	}
 	
 	

 	protected SupplyOrder present(RetailscmUserContext userContext, SupplyOrder supplyOrder, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrder,tokens);
		
		
		SupplyOrder  supplyOrderToPresent = userContext.getDAOGroup().getSupplyOrderDAO().present(supplyOrder, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSupplyOrderDAO().alias(entityListToNaming);
		
		return  supplyOrderToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrder loadSupplyOrderDetail(RetailscmUserContext userContext, String supplyOrderId) throws Exception{	
 		SupplyOrder supplyOrder = loadSupplyOrder( userContext, supplyOrderId, allTokens());
 		return present(userContext,supplyOrder, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplyOrderId) throws Exception{	
 		SupplyOrder supplyOrder = loadSupplyOrder( userContext, supplyOrderId, viewTokens());
 		return present(userContext,supplyOrder, allTokens());
		
 	}
 	protected SupplyOrder saveSupplyOrder(RetailscmUserContext userContext, SupplyOrder supplyOrder, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSupplyOrderDAO().save(supplyOrder, tokens);
 	}
 	protected SupplyOrder loadSupplyOrder(RetailscmUserContext userContext, String supplyOrderId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderManagerException.class);

 
 		return userContext.getDAOGroup().getSupplyOrderDAO().load(supplyOrderId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrder supplyOrder, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrder, tokens);
		
		addAction(userContext, supplyOrder, tokens,"@create","createSupplyOrder","createSupplyOrder/","main","primary");
		addAction(userContext, supplyOrder, tokens,"@update","updateSupplyOrder","updateSupplyOrder/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"@copy","cloneSupplyOrder","cloneSupplyOrder/"+supplyOrder.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrder, tokens,"supply_order.transfer_to_buyer","transferToAnotherBuyer","transferToAnotherBuyer/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.transfer_to_seller","transferToAnotherSeller","transferToAnotherSeller/"+supplyOrder.getId()+"/","main","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.confirm","confirm","confirmActionForm/"+supplyOrder.getId()+"/","main","success");
		addAction(userContext, supplyOrder, tokens,"supply_order.approve","approve","approveActionForm/"+supplyOrder.getId()+"/","main","success");
		addAction(userContext, supplyOrder, tokens,"supply_order.process","process","processActionForm/"+supplyOrder.getId()+"/","main","info");
		addAction(userContext, supplyOrder, tokens,"supply_order.pick","pick","pickActionForm/"+supplyOrder.getId()+"/","main","success");
		addAction(userContext, supplyOrder, tokens,"supply_order.ship","ship","shipActionForm/"+supplyOrder.getId()+"/","main","success");
		addAction(userContext, supplyOrder, tokens,"supply_order.deliver","deliver","deliverActionForm/"+supplyOrder.getId()+"/","main","success");
		addAction(userContext, supplyOrder, tokens,"supply_order.addSupplyOrderLineItem","addSupplyOrderLineItem","addSupplyOrderLineItem/"+supplyOrder.getId()+"/","supplyOrderLineItemList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.removeSupplyOrderLineItem","removeSupplyOrderLineItem","removeSupplyOrderLineItem/"+supplyOrder.getId()+"/","supplyOrderLineItemList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.updateSupplyOrderLineItem","updateSupplyOrderLineItem","updateSupplyOrderLineItem/"+supplyOrder.getId()+"/","supplyOrderLineItemList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.copySupplyOrderLineItemFrom","copySupplyOrderLineItemFrom","copySupplyOrderLineItemFrom/"+supplyOrder.getId()+"/","supplyOrderLineItemList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.addSupplyOrderShippingGroup","addSupplyOrderShippingGroup","addSupplyOrderShippingGroup/"+supplyOrder.getId()+"/","supplyOrderShippingGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.removeSupplyOrderShippingGroup","removeSupplyOrderShippingGroup","removeSupplyOrderShippingGroup/"+supplyOrder.getId()+"/","supplyOrderShippingGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.updateSupplyOrderShippingGroup","updateSupplyOrderShippingGroup","updateSupplyOrderShippingGroup/"+supplyOrder.getId()+"/","supplyOrderShippingGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.copySupplyOrderShippingGroupFrom","copySupplyOrderShippingGroupFrom","copySupplyOrderShippingGroupFrom/"+supplyOrder.getId()+"/","supplyOrderShippingGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.addSupplyOrderPaymentGroup","addSupplyOrderPaymentGroup","addSupplyOrderPaymentGroup/"+supplyOrder.getId()+"/","supplyOrderPaymentGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.removeSupplyOrderPaymentGroup","removeSupplyOrderPaymentGroup","removeSupplyOrderPaymentGroup/"+supplyOrder.getId()+"/","supplyOrderPaymentGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.updateSupplyOrderPaymentGroup","updateSupplyOrderPaymentGroup","updateSupplyOrderPaymentGroup/"+supplyOrder.getId()+"/","supplyOrderPaymentGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.copySupplyOrderPaymentGroupFrom","copySupplyOrderPaymentGroupFrom","copySupplyOrderPaymentGroupFrom/"+supplyOrder.getId()+"/","supplyOrderPaymentGroupList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.addGoods","addGoods","addGoods/"+supplyOrder.getId()+"/","goodsList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.removeGoods","removeGoods","removeGoods/"+supplyOrder.getId()+"/","goodsList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.updateGoods","updateGoods","updateGoods/"+supplyOrder.getId()+"/","goodsList","primary");
		addAction(userContext, supplyOrder, tokens,"supply_order.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+supplyOrder.getId()+"/","goodsList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrder supplyOrder, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrder createSupplyOrder(RetailscmUserContext userContext,String buyerId, String sellerId, String title, BigDecimal totalAmount) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfSupplyOrder(title);
		userContext.getChecker().checkTotalAmountOfSupplyOrder(totalAmount);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);


		SupplyOrder supplyOrder=createNewSupplyOrder();	

			
		RetailStoreCountryCenter buyer = loadRetailStoreCountryCenter(userContext, buyerId,emptyOptions());
		supplyOrder.setBuyer(buyer);
		
		
			
		GoodsSupplier seller = loadGoodsSupplier(userContext, sellerId,emptyOptions());
		supplyOrder.setSeller(seller);
		
		
		supplyOrder.setTitle(title);
		supplyOrder.setTotalAmount(totalAmount);
		supplyOrder.setLastUpdateTime(userContext.now());
		supplyOrder.setCurrentStatus("INIT");

		supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrder);
		return supplyOrder;

		
	}
	protected SupplyOrder createNewSupplyOrder() 
	{
		
		return new SupplyOrder();		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailscmUserContext userContext,String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder( supplyOrderVersion);
		
		

				

		
		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfSupplyOrder(parseString(newValueExpr));
		}
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
		
	}
	
	
	
	public SupplyOrder clone(RetailscmUserContext userContext, String fromSupplyOrderId) throws Exception{
		
		return userContext.getDAOGroup().getSupplyOrderDAO().clone(fromSupplyOrderId, this.allTokens());
	}
	
	public SupplyOrder internalSaveSupplyOrder(RetailscmUserContext userContext, SupplyOrder supplyOrder) throws Exception 
	{
		return internalSaveSupplyOrder(userContext, supplyOrder, allTokens());

	}
	public SupplyOrder internalSaveSupplyOrder(RetailscmUserContext userContext, SupplyOrder supplyOrder, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplyOrder(userContext, supplyOrderId, supplyOrderVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplyOrder){ 
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrder.
			
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, options);
			return supplyOrder;
			
		}

	}
	
	public SupplyOrder updateSupplyOrder(RetailscmUserContext userContext,String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderId, supplyOrderVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		if(supplyOrder.getVersion() != supplyOrderVersion){
			String message = "The target version("+supplyOrder.getVersion()+") is not equals to version("+supplyOrderVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrder){ 
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrder.
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			//return saveSupplyOrder(userContext, supplyOrder, tokens().done());
		}

	}
	
	public SupplyOrder updateSupplyOrderProperty(RetailscmUserContext userContext,String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderId, supplyOrderVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		if(supplyOrder.getVersion() != supplyOrderVersion){
			String message = "The target version("+supplyOrder.getVersion()+") is not equals to version("+supplyOrderVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrder){ 
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrder.
			
			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			//return saveSupplyOrder(userContext, supplyOrder, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderTokens tokens(){
		return SupplyOrderTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortSupplyOrderLineItemListWith("id","desc")
		.sortSupplyOrderShippingGroupListWith("id","desc")
		.sortSupplyOrderPaymentGroupListWith("id","desc")
		.sortGoodsListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderTokens.mergeAll(tokens).done();
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
 	protected void ensureStatus(RetailscmUserContext userContext, SupplyOrder supplyOrder, String expectedNextStatus) throws Exception{
		String currentStatus = supplyOrder.getCurrentStatus();
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
	
	protected void checkParamsForTransferingAnotherBuyer(RetailscmUserContext userContext, String supplyOrderId, String anotherBuyerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherBuyerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
 		
 	}
 	public SupplyOrder transferToAnotherBuyer(RetailscmUserContext userContext, String supplyOrderId, String anotherBuyerId) throws Exception
 	{
 		checkParamsForTransferingAnotherBuyer(userContext, supplyOrderId,anotherBuyerId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter buyer = loadRetailStoreCountryCenter(userContext, anotherBuyerId, emptyOptions());		
			supplyOrder.updateBuyer(buyer);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateBuyer(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherSeller(RetailscmUserContext userContext, String supplyOrderId, String anotherSellerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
 		userContext.getChecker().checkIdOfGoodsSupplier(anotherSellerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
 		
 	}
 	public SupplyOrder transferToAnotherSeller(RetailscmUserContext userContext, String supplyOrderId, String anotherSellerId) throws Exception
 	{
 		checkParamsForTransferingAnotherSeller(userContext, supplyOrderId,anotherSellerId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsSupplier seller = loadGoodsSupplier(userContext, anotherSellerId, emptyOptions());		
			supplyOrder.updateSeller(seller);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateGoodsSupplier requestCandidateSeller(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGoodsSupplier result = new CandidateGoodsSupplier();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GoodsSupplier> candidateList = userContext.getDAOGroup().getGoodsSupplierDAO().requestCandidateGoodsSupplierForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherConfirmation(RetailscmUserContext userContext, String supplyOrderId, String anotherConfirmationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
 		userContext.getChecker().checkIdOfSupplyOrderConfirmation(anotherConfirmationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
 		
 	}
 	public SupplyOrder transferToAnotherConfirmation(RetailscmUserContext userContext, String supplyOrderId, String anotherConfirmationId) throws Exception
 	{
 		checkParamsForTransferingAnotherConfirmation(userContext, supplyOrderId,anotherConfirmationId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderConfirmation confirmation = loadSupplyOrderConfirmation(userContext, anotherConfirmationId, emptyOptions());		
			supplyOrder.updateConfirmation(confirmation);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSupplyOrderConfirmation requestCandidateConfirmation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrderConfirmation result = new CandidateSupplyOrderConfirmation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrderConfirmation> candidateList = userContext.getDAOGroup().getSupplyOrderConfirmationDAO().requestCandidateSupplyOrderConfirmationForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String CONFIRMED_STATUS = "CONFIRMED";
 	protected void checkParamsForConfirmation(RetailscmUserContext userContext, String supplyOrderId, String who, Date confirmTime
) throws Exception
 	{
 				userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkWhoOfSupplyOrderConfirmation(who);
		userContext.getChecker().checkConfirmTimeOfSupplyOrderConfirmation(confirmTime);

	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder confirm(RetailscmUserContext userContext, String supplyOrderId, String who, Date confirmTime
) throws Exception
 	{
		checkParamsForConfirmation(userContext, supplyOrderId, who, confirmTime);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForConfirmation(userContext,supplyOrder);
 		

			supplyOrder.updateCurrentStatus(CONFIRMED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderConfirmation confirmation = createConfirmation(userContext, who, confirmTime);		
			supplyOrder.updateConfirmation(confirmation);		
			
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withConfirmation().done());
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public SupplyOrderForm confirmActionForm(RetailscmUserContext userContext, String supplyOrderId) throws Exception
 	{
		return new SupplyOrderForm()
			.withTitle("confirm")
			.supplyOrderIdField(supplyOrderId)
			.whoFieldOfSupplyOrderConfirmation()
			.confirmTimeFieldOfSupplyOrderConfirmation()
			.confirmAction();
 	}
	
 	
 	protected SupplyOrderConfirmation createConfirmation(RetailscmUserContext userContext, String who, Date confirmTime){
 		SupplyOrderConfirmation confirmation = new SupplyOrderConfirmation();
 		//who, confirmTime
 		
		confirmation.setWho(who);
		confirmation.setConfirmTime(confirmTime);

 		
 		
 		
 		return userContext.getDAOGroup().getSupplyOrderConfirmationDAO().save(confirmation,emptyOptions());
 	}
 	protected void checkIfEligibleForConfirmation(RetailscmUserContext userContext, SupplyOrder supplyOrder) throws Exception{
 
 		ensureStatus(userContext,supplyOrder, CONFIRMED_STATUS);
 		
 		SupplyOrderConfirmation confirmation = supplyOrder.getConfirmation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = confirmation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( confirmation != null){
				throwExceptionWithMessage("The SupplyOrder("+supplyOrder.getId()+") has already been "+ CONFIRMED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherApproval(RetailscmUserContext userContext, String supplyOrderId, String anotherApprovalId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
 		userContext.getChecker().checkIdOfSupplyOrderApproval(anotherApprovalId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
 		
 	}
 	public SupplyOrder transferToAnotherApproval(RetailscmUserContext userContext, String supplyOrderId, String anotherApprovalId) throws Exception
 	{
 		checkParamsForTransferingAnotherApproval(userContext, supplyOrderId,anotherApprovalId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderApproval approval = loadSupplyOrderApproval(userContext, anotherApprovalId, emptyOptions());		
			supplyOrder.updateApproval(approval);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSupplyOrderApproval requestCandidateApproval(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrderApproval result = new CandidateSupplyOrderApproval();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrderApproval> candidateList = userContext.getDAOGroup().getSupplyOrderApprovalDAO().requestCandidateSupplyOrderApprovalForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String APPROVED_STATUS = "APPROVED";
 	protected void checkParamsForApproval(RetailscmUserContext userContext, String supplyOrderId, String who, Date approveTime
) throws Exception
 	{
 				userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkWhoOfSupplyOrderApproval(who);
		userContext.getChecker().checkApproveTimeOfSupplyOrderApproval(approveTime);

	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder approve(RetailscmUserContext userContext, String supplyOrderId, String who, Date approveTime
) throws Exception
 	{
		checkParamsForApproval(userContext, supplyOrderId, who, approveTime);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForApproval(userContext,supplyOrder);
 		

			supplyOrder.updateCurrentStatus(APPROVED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderApproval approval = createApproval(userContext, who, approveTime);		
			supplyOrder.updateApproval(approval);		
			
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withApproval().done());
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public SupplyOrderForm approveActionForm(RetailscmUserContext userContext, String supplyOrderId) throws Exception
 	{
		return new SupplyOrderForm()
			.withTitle("approve")
			.supplyOrderIdField(supplyOrderId)
			.whoFieldOfSupplyOrderApproval()
			.approveTimeFieldOfSupplyOrderApproval()
			.approveAction();
 	}
	
 	
 	protected SupplyOrderApproval createApproval(RetailscmUserContext userContext, String who, Date approveTime){
 		SupplyOrderApproval approval = new SupplyOrderApproval();
 		//who, approveTime
 		
		approval.setWho(who);
		approval.setApproveTime(approveTime);

 		
 		
 		
 		return userContext.getDAOGroup().getSupplyOrderApprovalDAO().save(approval,emptyOptions());
 	}
 	protected void checkIfEligibleForApproval(RetailscmUserContext userContext, SupplyOrder supplyOrder) throws Exception{
 
 		ensureStatus(userContext,supplyOrder, APPROVED_STATUS);
 		
 		SupplyOrderApproval approval = supplyOrder.getApproval();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = approval 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( approval != null){
				throwExceptionWithMessage("The SupplyOrder("+supplyOrder.getId()+") has already been "+ APPROVED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherProcessing(RetailscmUserContext userContext, String supplyOrderId, String anotherProcessingId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
 		userContext.getChecker().checkIdOfSupplyOrderProcessing(anotherProcessingId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
 		
 	}
 	public SupplyOrder transferToAnotherProcessing(RetailscmUserContext userContext, String supplyOrderId, String anotherProcessingId) throws Exception
 	{
 		checkParamsForTransferingAnotherProcessing(userContext, supplyOrderId,anotherProcessingId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderProcessing processing = loadSupplyOrderProcessing(userContext, anotherProcessingId, emptyOptions());		
			supplyOrder.updateProcessing(processing);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSupplyOrderProcessing requestCandidateProcessing(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrderProcessing result = new CandidateSupplyOrderProcessing();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrderProcessing> candidateList = userContext.getDAOGroup().getSupplyOrderProcessingDAO().requestCandidateSupplyOrderProcessingForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String PROCESSED_STATUS = "PROCESSED";
 	protected void checkParamsForProcessing(RetailscmUserContext userContext, String supplyOrderId, String who, Date processTime
) throws Exception
 	{
 				userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkWhoOfSupplyOrderProcessing(who);
		userContext.getChecker().checkProcessTimeOfSupplyOrderProcessing(processTime);

	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder process(RetailscmUserContext userContext, String supplyOrderId, String who, Date processTime
) throws Exception
 	{
		checkParamsForProcessing(userContext, supplyOrderId, who, processTime);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForProcessing(userContext,supplyOrder);
 		

			supplyOrder.updateCurrentStatus(PROCESSED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderProcessing processing = createProcessing(userContext, who, processTime);		
			supplyOrder.updateProcessing(processing);		
			
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withProcessing().done());
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public SupplyOrderForm processActionForm(RetailscmUserContext userContext, String supplyOrderId) throws Exception
 	{
		return new SupplyOrderForm()
			.withTitle("process")
			.supplyOrderIdField(supplyOrderId)
			.whoFieldOfSupplyOrderProcessing()
			.processTimeFieldOfSupplyOrderProcessing()
			.processAction();
 	}
	
 	
 	protected SupplyOrderProcessing createProcessing(RetailscmUserContext userContext, String who, Date processTime){
 		SupplyOrderProcessing processing = new SupplyOrderProcessing();
 		//who, processTime
 		
		processing.setWho(who);
		processing.setProcessTime(processTime);

 		
 		
 		
 		return userContext.getDAOGroup().getSupplyOrderProcessingDAO().save(processing,emptyOptions());
 	}
 	protected void checkIfEligibleForProcessing(RetailscmUserContext userContext, SupplyOrder supplyOrder) throws Exception{
 
 		ensureStatus(userContext,supplyOrder, PROCESSED_STATUS);
 		
 		SupplyOrderProcessing processing = supplyOrder.getProcessing();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = processing 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( processing != null){
				throwExceptionWithMessage("The SupplyOrder("+supplyOrder.getId()+") has already been "+ PROCESSED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherPicking(RetailscmUserContext userContext, String supplyOrderId, String anotherPickingId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
 		userContext.getChecker().checkIdOfSupplyOrderPicking(anotherPickingId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
 		
 	}
 	public SupplyOrder transferToAnotherPicking(RetailscmUserContext userContext, String supplyOrderId, String anotherPickingId) throws Exception
 	{
 		checkParamsForTransferingAnotherPicking(userContext, supplyOrderId,anotherPickingId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderPicking picking = loadSupplyOrderPicking(userContext, anotherPickingId, emptyOptions());		
			supplyOrder.updatePicking(picking);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSupplyOrderPicking requestCandidatePicking(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrderPicking result = new CandidateSupplyOrderPicking();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrderPicking> candidateList = userContext.getDAOGroup().getSupplyOrderPickingDAO().requestCandidateSupplyOrderPickingForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String PICKED_STATUS = "PICKED";
 	protected void checkParamsForPicking(RetailscmUserContext userContext, String supplyOrderId, String who, Date processTime
) throws Exception
 	{
 				userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkWhoOfSupplyOrderPicking(who);
		userContext.getChecker().checkProcessTimeOfSupplyOrderPicking(processTime);

	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder pick(RetailscmUserContext userContext, String supplyOrderId, String who, Date processTime
) throws Exception
 	{
		checkParamsForPicking(userContext, supplyOrderId, who, processTime);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForPicking(userContext,supplyOrder);
 		

			supplyOrder.updateCurrentStatus(PICKED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderPicking picking = createPicking(userContext, who, processTime);		
			supplyOrder.updatePicking(picking);		
			
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withPicking().done());
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public SupplyOrderForm pickActionForm(RetailscmUserContext userContext, String supplyOrderId) throws Exception
 	{
		return new SupplyOrderForm()
			.withTitle("pick")
			.supplyOrderIdField(supplyOrderId)
			.whoFieldOfSupplyOrderPicking()
			.processTimeFieldOfSupplyOrderPicking()
			.pickAction();
 	}
	
 	
 	protected SupplyOrderPicking createPicking(RetailscmUserContext userContext, String who, Date processTime){
 		SupplyOrderPicking picking = new SupplyOrderPicking();
 		//who, processTime
 		
		picking.setWho(who);
		picking.setProcessTime(processTime);

 		
 		
 		
 		return userContext.getDAOGroup().getSupplyOrderPickingDAO().save(picking,emptyOptions());
 	}
 	protected void checkIfEligibleForPicking(RetailscmUserContext userContext, SupplyOrder supplyOrder) throws Exception{
 
 		ensureStatus(userContext,supplyOrder, PICKED_STATUS);
 		
 		SupplyOrderPicking picking = supplyOrder.getPicking();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = picking 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( picking != null){
				throwExceptionWithMessage("The SupplyOrder("+supplyOrder.getId()+") has already been "+ PICKED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherShipment(RetailscmUserContext userContext, String supplyOrderId, String anotherShipmentId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
 		userContext.getChecker().checkIdOfSupplyOrderShipment(anotherShipmentId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
 		
 	}
 	public SupplyOrder transferToAnotherShipment(RetailscmUserContext userContext, String supplyOrderId, String anotherShipmentId) throws Exception
 	{
 		checkParamsForTransferingAnotherShipment(userContext, supplyOrderId,anotherShipmentId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderShipment shipment = loadSupplyOrderShipment(userContext, anotherShipmentId, emptyOptions());		
			supplyOrder.updateShipment(shipment);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSupplyOrderShipment requestCandidateShipment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrderShipment result = new CandidateSupplyOrderShipment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrderShipment> candidateList = userContext.getDAOGroup().getSupplyOrderShipmentDAO().requestCandidateSupplyOrderShipmentForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String SHIPPED_STATUS = "SHIPPED";
 	protected void checkParamsForShipment(RetailscmUserContext userContext, String supplyOrderId, String who, Date shipTime
) throws Exception
 	{
 				userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkWhoOfSupplyOrderShipment(who);
		userContext.getChecker().checkShipTimeOfSupplyOrderShipment(shipTime);

	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder ship(RetailscmUserContext userContext, String supplyOrderId, String who, Date shipTime
) throws Exception
 	{
		checkParamsForShipment(userContext, supplyOrderId, who, shipTime);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForShipment(userContext,supplyOrder);
 		

			supplyOrder.updateCurrentStatus(SHIPPED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderShipment shipment = createShipment(userContext, who, shipTime);		
			supplyOrder.updateShipment(shipment);		
			
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withShipment().done());
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public SupplyOrderForm shipActionForm(RetailscmUserContext userContext, String supplyOrderId) throws Exception
 	{
		return new SupplyOrderForm()
			.withTitle("ship")
			.supplyOrderIdField(supplyOrderId)
			.whoFieldOfSupplyOrderShipment()
			.shipTimeFieldOfSupplyOrderShipment()
			.shipAction();
 	}
	
 	
 	protected SupplyOrderShipment createShipment(RetailscmUserContext userContext, String who, Date shipTime){
 		SupplyOrderShipment shipment = new SupplyOrderShipment();
 		//who, shipTime
 		
		shipment.setWho(who);
		shipment.setShipTime(shipTime);

 		
 		
 		
 		return userContext.getDAOGroup().getSupplyOrderShipmentDAO().save(shipment,emptyOptions());
 	}
 	protected void checkIfEligibleForShipment(RetailscmUserContext userContext, SupplyOrder supplyOrder) throws Exception{
 
 		ensureStatus(userContext,supplyOrder, SHIPPED_STATUS);
 		
 		SupplyOrderShipment shipment = supplyOrder.getShipment();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = shipment 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( shipment != null){
				throwExceptionWithMessage("The SupplyOrder("+supplyOrder.getId()+") has already been "+ SHIPPED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherDelivery(RetailscmUserContext userContext, String supplyOrderId, String anotherDeliveryId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
 		userContext.getChecker().checkIdOfSupplyOrderDelivery(anotherDeliveryId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
 		
 	}
 	public SupplyOrder transferToAnotherDelivery(RetailscmUserContext userContext, String supplyOrderId, String anotherDeliveryId) throws Exception
 	{
 		checkParamsForTransferingAnotherDelivery(userContext, supplyOrderId,anotherDeliveryId);
 
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrderDelivery delivery = loadSupplyOrderDelivery(userContext, anotherDeliveryId, emptyOptions());		
			supplyOrder.updateDelivery(delivery);		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, emptyOptions());
			
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSupplyOrderDelivery requestCandidateDelivery(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrderDelivery result = new CandidateSupplyOrderDelivery();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrderDelivery> candidateList = userContext.getDAOGroup().getSupplyOrderDeliveryDAO().requestCandidateSupplyOrderDeliveryForSupplyOrder(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String DELIVERED_STATUS = "DELIVERED";
 	protected void checkParamsForDelivery(RetailscmUserContext userContext, String supplyOrderId, String who, Date deliveryTime
) throws Exception
 	{
 				userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkWhoOfSupplyOrderDelivery(who);
		userContext.getChecker().checkDeliveryTimeOfSupplyOrderDelivery(deliveryTime);

	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);

 	}
 	public SupplyOrder deliver(RetailscmUserContext userContext, String supplyOrderId, String who, Date deliveryTime
) throws Exception
 	{
		checkParamsForDelivery(userContext, supplyOrderId, who, deliveryTime);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());	
		synchronized(supplyOrder){
			//will be good when the supplyOrder loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForDelivery(userContext,supplyOrder);
 		

			supplyOrder.updateCurrentStatus(DELIVERED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SupplyOrderDelivery delivery = createDelivery(userContext, who, deliveryTime);		
			supplyOrder.updateDelivery(delivery);		
			
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withDelivery().done());
			return present(userContext,supplyOrder, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public SupplyOrderForm deliverActionForm(RetailscmUserContext userContext, String supplyOrderId) throws Exception
 	{
		return new SupplyOrderForm()
			.withTitle("deliver")
			.supplyOrderIdField(supplyOrderId)
			.whoFieldOfSupplyOrderDelivery()
			.deliveryTimeFieldOfSupplyOrderDelivery()
			.deliverAction();
 	}
	
 	
 	protected SupplyOrderDelivery createDelivery(RetailscmUserContext userContext, String who, Date deliveryTime){
 		SupplyOrderDelivery delivery = new SupplyOrderDelivery();
 		//who, deliveryTime
 		
		delivery.setWho(who);
		delivery.setDeliveryTime(deliveryTime);

 		
 		
 		
 		return userContext.getDAOGroup().getSupplyOrderDeliveryDAO().save(delivery,emptyOptions());
 	}
 	protected void checkIfEligibleForDelivery(RetailscmUserContext userContext, SupplyOrder supplyOrder) throws Exception{
 
 		ensureStatus(userContext,supplyOrder, DELIVERED_STATUS);
 		
 		SupplyOrderDelivery delivery = supplyOrder.getDelivery();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = delivery 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( delivery != null){
				throwExceptionWithMessage("The SupplyOrder("+supplyOrder.getId()+") has already been "+ DELIVERED_STATUS+".");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected SupplyOrderApproval loadSupplyOrderApproval(RetailscmUserContext userContext, String newApprovalId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSupplyOrderApprovalDAO().load(newApprovalId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newBuyerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newBuyerId, options);
 	}
 	
 	
 	
	
	 	
 	protected SupplyOrderDelivery loadSupplyOrderDelivery(RetailscmUserContext userContext, String newDeliveryId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSupplyOrderDeliveryDAO().load(newDeliveryId, options);
 	}
 	
 	
 	
	
	 	
 	protected GoodsSupplier loadGoodsSupplier(RetailscmUserContext userContext, String newSellerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getGoodsSupplierDAO().load(newSellerId, options);
 	}
 	
 	
 	
	
	 	
 	protected SupplyOrderPicking loadSupplyOrderPicking(RetailscmUserContext userContext, String newPickingId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSupplyOrderPickingDAO().load(newPickingId, options);
 	}
 	
 	
 	
	
	 	
 	protected SupplyOrderShipment loadSupplyOrderShipment(RetailscmUserContext userContext, String newShipmentId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSupplyOrderShipmentDAO().load(newShipmentId, options);
 	}
 	
 	
 	
	
	 	
 	protected SupplyOrderConfirmation loadSupplyOrderConfirmation(RetailscmUserContext userContext, String newConfirmationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSupplyOrderConfirmationDAO().load(newConfirmationId, options);
 	}
 	
 	
 	
	
	 	
 	protected SupplyOrderProcessing loadSupplyOrderProcessing(RetailscmUserContext userContext, String newProcessingId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSupplyOrderProcessingDAO().load(newProcessingId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplyOrderId, int supplyOrderVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderId, supplyOrderVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderId, int supplyOrderVersion) throws Exception{
			
		userContext.getDAOGroup().getSupplyOrderDAO().delete(supplyOrderId, supplyOrderVersion);
	}
	
	public SupplyOrder forgetByAll(RetailscmUserContext userContext, String supplyOrderId, int supplyOrderVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderId, supplyOrderVersion);		
	}
	protected SupplyOrder forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderId, int supplyOrderVersion) throws Exception{
			
		return userContext.getDAOGroup().getSupplyOrderDAO().disconnectFromAll(supplyOrderId, supplyOrderVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSupplyOrderDAO().deleteAll();
	}


	//disconnect SupplyOrder with sku_id in SupplyOrderLineItem
	protected SupplyOrder breakWithSupplyOrderLineItemBySkuId(RetailscmUserContext userContext, String supplyOrderId, String skuIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveSupplyOrderLineItemListWithSkuId(supplyOrder, skuIdId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with sku in Goods
	protected SupplyOrder breakWithGoodsBySku(RetailscmUserContext userContext, String supplyOrderId, String skuId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveGoodsListWithSku(supplyOrder, skuId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with receiving_space in Goods
	protected SupplyOrder breakWithGoodsByReceivingSpace(RetailscmUserContext userContext, String supplyOrderId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveGoodsListWithReceivingSpace(supplyOrder, receivingSpaceId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with goods_allocation in Goods
	protected SupplyOrder breakWithGoodsByGoodsAllocation(RetailscmUserContext userContext, String supplyOrderId, String goodsAllocationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveGoodsListWithGoodsAllocation(supplyOrder, goodsAllocationId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with smart_pallet in Goods
	protected SupplyOrder breakWithGoodsBySmartPallet(RetailscmUserContext userContext, String supplyOrderId, String smartPalletId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveGoodsListWithSmartPallet(supplyOrder, smartPalletId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with shipping_space in Goods
	protected SupplyOrder breakWithGoodsByShippingSpace(RetailscmUserContext userContext, String supplyOrderId, String shippingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveGoodsListWithShippingSpace(supplyOrder, shippingSpaceId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with transport_task in Goods
	protected SupplyOrder breakWithGoodsByTransportTask(RetailscmUserContext userContext, String supplyOrderId, String transportTaskId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveGoodsListWithTransportTask(supplyOrder, transportTaskId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with retail_store in Goods
	protected SupplyOrder breakWithGoodsByRetailStore(RetailscmUserContext userContext, String supplyOrderId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveGoodsListWithRetailStore(supplyOrder, retailStoreId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	//disconnect SupplyOrder with retail_store_order in Goods
	protected SupplyOrder breakWithGoodsByRetailStoreOrder(RetailscmUserContext userContext, String supplyOrderId, String retailStoreOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());

			synchronized(supplyOrder){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveGoodsListWithRetailStoreOrder(supplyOrder, retailStoreOrderId, this.emptyOptions());

				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				return supplyOrder;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);

		
		userContext.getChecker().checkSkuIdOfSupplyOrderLineItem(skuId);
		
		userContext.getChecker().checkSkuNameOfSupplyOrderLineItem(skuName);
		
		userContext.getChecker().checkAmountOfSupplyOrderLineItem(amount);
		
		userContext.getChecker().checkQuantityOfSupplyOrderLineItem(quantity);
		
		userContext.getChecker().checkUnitOfMeasurementOfSupplyOrderLineItem(unitOfMeasurement);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	
	}
	public  SupplyOrder addSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrderLineItem(userContext,supplyOrderId,skuId, skuName, amount, quantity, unitOfMeasurement,tokensExpr);
		
		SupplyOrderLineItem supplyOrderLineItem = createSupplyOrderLineItem(userContext,skuId, skuName, amount, quantity, unitOfMeasurement);
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.addSupplyOrderLineItem( supplyOrderLineItem );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
			
			userContext.getManagerGroup().getSupplyOrderLineItemManager().onNewInstanceCreated(userContext, supplyOrderLineItem);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderLineItemProperties(RetailscmUserContext userContext, String supplyOrderId,String id,String skuId,String skuName,BigDecimal amount,int quantity,String unitOfMeasurement,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkIdOfSupplyOrderLineItem(id);
		
		userContext.getChecker().checkSkuIdOfSupplyOrderLineItem( skuId);
		userContext.getChecker().checkSkuNameOfSupplyOrderLineItem( skuName);
		userContext.getChecker().checkAmountOfSupplyOrderLineItem( amount);
		userContext.getChecker().checkQuantityOfSupplyOrderLineItem( quantity);
		userContext.getChecker().checkUnitOfMeasurementOfSupplyOrderLineItem( unitOfMeasurement);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
		
	}
	public  SupplyOrder updateSupplyOrderLineItemProperties(RetailscmUserContext userContext, String supplyOrderId, String id,String skuId,String skuName,BigDecimal amount,int quantity,String unitOfMeasurement, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSupplyOrderLineItemProperties(userContext,supplyOrderId,id,skuId,skuName,amount,quantity,unitOfMeasurement,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderLineItemListList()
				.searchSupplyOrderLineItemListWith(SupplyOrderLineItem.ID_PROPERTY, "is", id).done();
		
		SupplyOrder supplyOrderToUpdate = loadSupplyOrder(userContext, supplyOrderId, options);
		
		if(supplyOrderToUpdate.getSupplyOrderLineItemList().isEmpty()){
			throw new SupplyOrderManagerException("SupplyOrderLineItem is NOT FOUND with id: '"+id+"'");
		}
		
		SupplyOrderLineItem item = supplyOrderToUpdate.getSupplyOrderLineItemList().first();
		
		item.updateSkuId( skuId );
		item.updateSkuName( skuName );
		item.updateAmount( amount );
		item.updateQuantity( quantity );
		item.updateUnitOfMeasurement( unitOfMeasurement );

		
		//checkParamsForAddingSupplyOrderLineItem(userContext,supplyOrderId,name, code, used,tokensExpr);
		SupplyOrder supplyOrder = saveSupplyOrder(userContext, supplyOrderToUpdate, tokens().withSupplyOrderLineItemList().done());
		synchronized(supplyOrder){ 
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected SupplyOrderLineItem createSupplyOrderLineItem(RetailscmUserContext userContext, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement) throws Exception{

		SupplyOrderLineItem supplyOrderLineItem = new SupplyOrderLineItem();
		
		
		supplyOrderLineItem.setSkuId(skuId);		
		supplyOrderLineItem.setSkuName(skuName);		
		supplyOrderLineItem.setAmount(amount);		
		supplyOrderLineItem.setQuantity(quantity);		
		supplyOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);
	
		
		return supplyOrderLineItem;
	
		
	}
	
	protected SupplyOrderLineItem createIndexedSupplyOrderLineItem(String id, int version){

		SupplyOrderLineItem supplyOrderLineItem = new SupplyOrderLineItem();
		supplyOrderLineItem.setId(id);
		supplyOrderLineItem.setVersion(version);
		return supplyOrderLineItem;			
		
	}
	
	protected void checkParamsForRemovingSupplyOrderLineItemList(RetailscmUserContext userContext, String supplyOrderId, 
			String supplyOrderLineItemIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		for(String supplyOrderLineItemId: supplyOrderLineItemIds){
			userContext.getChecker().checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
		
	}
	public  SupplyOrder removeSupplyOrderLineItemList(RetailscmUserContext userContext, String supplyOrderId, 
			String supplyOrderLineItemIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSupplyOrderLineItemList(userContext, supplyOrderId,  supplyOrderLineItemIds, tokensExpr);
			
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
			synchronized(supplyOrder){ 
				//Will be good when the supplyOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveSupplyOrderLineItemList(supplyOrder, supplyOrderLineItemIds, allTokens());
				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
				deleteRelationListInGraph(userContext, supplyOrder.getSupplyOrderLineItemList());
				return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderId, 
		String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrder( supplyOrderId);
		userContext.getChecker().checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		userContext.getChecker().checkVersionOfSupplyOrderLineItem(supplyOrderLineItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
	}
	public  SupplyOrder removeSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderId, 
		String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrderLineItem(userContext,supplyOrderId, supplyOrderLineItemId, supplyOrderLineItemVersion,tokensExpr);
		
		SupplyOrderLineItem supplyOrderLineItem = createIndexedSupplyOrderLineItem(supplyOrderLineItemId, supplyOrderLineItemVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.removeSupplyOrderLineItem( supplyOrderLineItem );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
			deleteRelationInGraph(userContext, supplyOrderLineItem);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderId, 
		String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrder( supplyOrderId);
		userContext.getChecker().checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		userContext.getChecker().checkVersionOfSupplyOrderLineItem(supplyOrderLineItemVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
	}
	public  SupplyOrder copySupplyOrderLineItemFrom(RetailscmUserContext userContext, String supplyOrderId, 
		String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrderLineItem(userContext,supplyOrderId, supplyOrderLineItemId, supplyOrderLineItemVersion,tokensExpr);
		
		SupplyOrderLineItem supplyOrderLineItem = createIndexedSupplyOrderLineItem(supplyOrderLineItemId, supplyOrderLineItemVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			supplyOrder.copySupplyOrderLineItemFrom( supplyOrderLineItem );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
			
			userContext.getManagerGroup().getSupplyOrderLineItemManager().onNewInstanceCreated(userContext, (SupplyOrderLineItem)supplyOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderId, String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		userContext.getChecker().checkVersionOfSupplyOrderLineItem(supplyOrderLineItemVersion);
		

		if(SupplyOrderLineItem.SKU_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkSkuIdOfSupplyOrderLineItem(parseString(newValueExpr));
		}
		
		if(SupplyOrderLineItem.SKU_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkSkuNameOfSupplyOrderLineItem(parseString(newValueExpr));
		}
		
		if(SupplyOrderLineItem.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfSupplyOrderLineItem(parseBigDecimal(newValueExpr));
		}
		
		if(SupplyOrderLineItem.QUANTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkQuantityOfSupplyOrderLineItem(parseInt(newValueExpr));
		}
		
		if(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkUnitOfMeasurementOfSupplyOrderLineItem(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
	}
	
	public  SupplyOrder updateSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderId, String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrderLineItem(userContext, supplyOrderId, supplyOrderLineItemId, supplyOrderLineItemVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSupplyOrderLineItemList().searchSupplyOrderLineItemListWith(SupplyOrderLineItem.ID_PROPERTY, "eq", supplyOrderLineItemId).done();
		
		
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, loadTokens);
		
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrder.removeSupplyOrderLineItem( supplyOrderLineItem );	
			//make changes to AcceleraterAccount.
			SupplyOrderLineItem supplyOrderLineItemIndex = createIndexedSupplyOrderLineItem(supplyOrderLineItemId, supplyOrderLineItemVersion);
		
			SupplyOrderLineItem supplyOrderLineItem = supplyOrder.findTheSupplyOrderLineItem(supplyOrderLineItemIndex);
			if(supplyOrderLineItem == null){
				throw new SupplyOrderManagerException(supplyOrderLineItem+" is NOT FOUND" );
			}
			
			supplyOrderLineItem.changeProperty(property, newValueExpr);
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderLineItemList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderId, String name, BigDecimal amount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);

		
		userContext.getChecker().checkNameOfSupplyOrderShippingGroup(name);
		
		userContext.getChecker().checkAmountOfSupplyOrderShippingGroup(amount);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	
	}
	public  SupplyOrder addSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderId, String name, BigDecimal amount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrderShippingGroup(userContext,supplyOrderId,name, amount,tokensExpr);
		
		SupplyOrderShippingGroup supplyOrderShippingGroup = createSupplyOrderShippingGroup(userContext,name, amount);
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.addSupplyOrderShippingGroup( supplyOrderShippingGroup );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
			
			userContext.getManagerGroup().getSupplyOrderShippingGroupManager().onNewInstanceCreated(userContext, supplyOrderShippingGroup);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderShippingGroupProperties(RetailscmUserContext userContext, String supplyOrderId,String id,String name,BigDecimal amount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkIdOfSupplyOrderShippingGroup(id);
		
		userContext.getChecker().checkNameOfSupplyOrderShippingGroup( name);
		userContext.getChecker().checkAmountOfSupplyOrderShippingGroup( amount);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
		
	}
	public  SupplyOrder updateSupplyOrderShippingGroupProperties(RetailscmUserContext userContext, String supplyOrderId, String id,String name,BigDecimal amount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSupplyOrderShippingGroupProperties(userContext,supplyOrderId,id,name,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderShippingGroupListList()
				.searchSupplyOrderShippingGroupListWith(SupplyOrderShippingGroup.ID_PROPERTY, "is", id).done();
		
		SupplyOrder supplyOrderToUpdate = loadSupplyOrder(userContext, supplyOrderId, options);
		
		if(supplyOrderToUpdate.getSupplyOrderShippingGroupList().isEmpty()){
			throw new SupplyOrderManagerException("SupplyOrderShippingGroup is NOT FOUND with id: '"+id+"'");
		}
		
		SupplyOrderShippingGroup item = supplyOrderToUpdate.getSupplyOrderShippingGroupList().first();
		
		item.updateName( name );
		item.updateAmount( amount );

		
		//checkParamsForAddingSupplyOrderShippingGroup(userContext,supplyOrderId,name, code, used,tokensExpr);
		SupplyOrder supplyOrder = saveSupplyOrder(userContext, supplyOrderToUpdate, tokens().withSupplyOrderShippingGroupList().done());
		synchronized(supplyOrder){ 
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected SupplyOrderShippingGroup createSupplyOrderShippingGroup(RetailscmUserContext userContext, String name, BigDecimal amount) throws Exception{

		SupplyOrderShippingGroup supplyOrderShippingGroup = new SupplyOrderShippingGroup();
		
		
		supplyOrderShippingGroup.setName(name);		
		supplyOrderShippingGroup.setAmount(amount);
	
		
		return supplyOrderShippingGroup;
	
		
	}
	
	protected SupplyOrderShippingGroup createIndexedSupplyOrderShippingGroup(String id, int version){

		SupplyOrderShippingGroup supplyOrderShippingGroup = new SupplyOrderShippingGroup();
		supplyOrderShippingGroup.setId(id);
		supplyOrderShippingGroup.setVersion(version);
		return supplyOrderShippingGroup;			
		
	}
	
	protected void checkParamsForRemovingSupplyOrderShippingGroupList(RetailscmUserContext userContext, String supplyOrderId, 
			String supplyOrderShippingGroupIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		for(String supplyOrderShippingGroupId: supplyOrderShippingGroupIds){
			userContext.getChecker().checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
		
	}
	public  SupplyOrder removeSupplyOrderShippingGroupList(RetailscmUserContext userContext, String supplyOrderId, 
			String supplyOrderShippingGroupIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSupplyOrderShippingGroupList(userContext, supplyOrderId,  supplyOrderShippingGroupIds, tokensExpr);
			
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
			synchronized(supplyOrder){ 
				//Will be good when the supplyOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveSupplyOrderShippingGroupList(supplyOrder, supplyOrderShippingGroupIds, allTokens());
				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
				deleteRelationListInGraph(userContext, supplyOrder.getSupplyOrderShippingGroupList());
				return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderId, 
		String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrder( supplyOrderId);
		userContext.getChecker().checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupId);
		userContext.getChecker().checkVersionOfSupplyOrderShippingGroup(supplyOrderShippingGroupVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
	}
	public  SupplyOrder removeSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderId, 
		String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrderShippingGroup(userContext,supplyOrderId, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion,tokensExpr);
		
		SupplyOrderShippingGroup supplyOrderShippingGroup = createIndexedSupplyOrderShippingGroup(supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.removeSupplyOrderShippingGroup( supplyOrderShippingGroup );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
			deleteRelationInGraph(userContext, supplyOrderShippingGroup);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderId, 
		String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrder( supplyOrderId);
		userContext.getChecker().checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupId);
		userContext.getChecker().checkVersionOfSupplyOrderShippingGroup(supplyOrderShippingGroupVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
	}
	public  SupplyOrder copySupplyOrderShippingGroupFrom(RetailscmUserContext userContext, String supplyOrderId, 
		String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrderShippingGroup(userContext,supplyOrderId, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion,tokensExpr);
		
		SupplyOrderShippingGroup supplyOrderShippingGroup = createIndexedSupplyOrderShippingGroup(supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			supplyOrder.copySupplyOrderShippingGroupFrom( supplyOrderShippingGroup );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
			
			userContext.getManagerGroup().getSupplyOrderShippingGroupManager().onNewInstanceCreated(userContext, (SupplyOrderShippingGroup)supplyOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderId, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupId);
		userContext.getChecker().checkVersionOfSupplyOrderShippingGroup(supplyOrderShippingGroupVersion);
		

		if(SupplyOrderShippingGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfSupplyOrderShippingGroup(parseString(newValueExpr));
		}
		
		if(SupplyOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfSupplyOrderShippingGroup(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
	}
	
	public  SupplyOrder updateSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderId, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrderShippingGroup(userContext, supplyOrderId, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSupplyOrderShippingGroupList().searchSupplyOrderShippingGroupListWith(SupplyOrderShippingGroup.ID_PROPERTY, "eq", supplyOrderShippingGroupId).done();
		
		
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, loadTokens);
		
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrder.removeSupplyOrderShippingGroup( supplyOrderShippingGroup );	
			//make changes to AcceleraterAccount.
			SupplyOrderShippingGroup supplyOrderShippingGroupIndex = createIndexedSupplyOrderShippingGroup(supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);
		
			SupplyOrderShippingGroup supplyOrderShippingGroup = supplyOrder.findTheSupplyOrderShippingGroup(supplyOrderShippingGroupIndex);
			if(supplyOrderShippingGroup == null){
				throw new SupplyOrderManagerException(supplyOrderShippingGroup+" is NOT FOUND" );
			}
			
			supplyOrderShippingGroup.changeProperty(property, newValueExpr);
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderShippingGroupList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderId, String name, String cardNumber,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);

		
		userContext.getChecker().checkNameOfSupplyOrderPaymentGroup(name);
		
		userContext.getChecker().checkCardNumberOfSupplyOrderPaymentGroup(cardNumber);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	
	}
	public  SupplyOrder addSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderId, String name, String cardNumber, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrderPaymentGroup(userContext,supplyOrderId,name, cardNumber,tokensExpr);
		
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = createSupplyOrderPaymentGroup(userContext,name, cardNumber);
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.addSupplyOrderPaymentGroup( supplyOrderPaymentGroup );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
			
			userContext.getManagerGroup().getSupplyOrderPaymentGroupManager().onNewInstanceCreated(userContext, supplyOrderPaymentGroup);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderPaymentGroupProperties(RetailscmUserContext userContext, String supplyOrderId,String id,String name,String cardNumber,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkIdOfSupplyOrderPaymentGroup(id);
		
		userContext.getChecker().checkNameOfSupplyOrderPaymentGroup( name);
		userContext.getChecker().checkCardNumberOfSupplyOrderPaymentGroup( cardNumber);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
		
	}
	public  SupplyOrder updateSupplyOrderPaymentGroupProperties(RetailscmUserContext userContext, String supplyOrderId, String id,String name,String cardNumber, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSupplyOrderPaymentGroupProperties(userContext,supplyOrderId,id,name,cardNumber,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderPaymentGroupListList()
				.searchSupplyOrderPaymentGroupListWith(SupplyOrderPaymentGroup.ID_PROPERTY, "is", id).done();
		
		SupplyOrder supplyOrderToUpdate = loadSupplyOrder(userContext, supplyOrderId, options);
		
		if(supplyOrderToUpdate.getSupplyOrderPaymentGroupList().isEmpty()){
			throw new SupplyOrderManagerException("SupplyOrderPaymentGroup is NOT FOUND with id: '"+id+"'");
		}
		
		SupplyOrderPaymentGroup item = supplyOrderToUpdate.getSupplyOrderPaymentGroupList().first();
		
		item.updateName( name );
		item.updateCardNumber( cardNumber );

		
		//checkParamsForAddingSupplyOrderPaymentGroup(userContext,supplyOrderId,name, code, used,tokensExpr);
		SupplyOrder supplyOrder = saveSupplyOrder(userContext, supplyOrderToUpdate, tokens().withSupplyOrderPaymentGroupList().done());
		synchronized(supplyOrder){ 
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected SupplyOrderPaymentGroup createSupplyOrderPaymentGroup(RetailscmUserContext userContext, String name, String cardNumber) throws Exception{

		SupplyOrderPaymentGroup supplyOrderPaymentGroup = new SupplyOrderPaymentGroup();
		
		
		supplyOrderPaymentGroup.setName(name);		
		supplyOrderPaymentGroup.setCardNumber(cardNumber);
	
		
		return supplyOrderPaymentGroup;
	
		
	}
	
	protected SupplyOrderPaymentGroup createIndexedSupplyOrderPaymentGroup(String id, int version){

		SupplyOrderPaymentGroup supplyOrderPaymentGroup = new SupplyOrderPaymentGroup();
		supplyOrderPaymentGroup.setId(id);
		supplyOrderPaymentGroup.setVersion(version);
		return supplyOrderPaymentGroup;			
		
	}
	
	protected void checkParamsForRemovingSupplyOrderPaymentGroupList(RetailscmUserContext userContext, String supplyOrderId, 
			String supplyOrderPaymentGroupIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		for(String supplyOrderPaymentGroupId: supplyOrderPaymentGroupIds){
			userContext.getChecker().checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
		
	}
	public  SupplyOrder removeSupplyOrderPaymentGroupList(RetailscmUserContext userContext, String supplyOrderId, 
			String supplyOrderPaymentGroupIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSupplyOrderPaymentGroupList(userContext, supplyOrderId,  supplyOrderPaymentGroupIds, tokensExpr);
			
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
			synchronized(supplyOrder){ 
				//Will be good when the supplyOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveSupplyOrderPaymentGroupList(supplyOrder, supplyOrderPaymentGroupIds, allTokens());
				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
				deleteRelationListInGraph(userContext, supplyOrder.getSupplyOrderPaymentGroupList());
				return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderId, 
		String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrder( supplyOrderId);
		userContext.getChecker().checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
		userContext.getChecker().checkVersionOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
	}
	public  SupplyOrder removeSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderId, 
		String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrderPaymentGroup(userContext,supplyOrderId, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion,tokensExpr);
		
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = createIndexedSupplyOrderPaymentGroup(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.removeSupplyOrderPaymentGroup( supplyOrderPaymentGroup );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
			deleteRelationInGraph(userContext, supplyOrderPaymentGroup);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderId, 
		String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrder( supplyOrderId);
		userContext.getChecker().checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
		userContext.getChecker().checkVersionOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
	}
	public  SupplyOrder copySupplyOrderPaymentGroupFrom(RetailscmUserContext userContext, String supplyOrderId, 
		String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrderPaymentGroup(userContext,supplyOrderId, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion,tokensExpr);
		
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = createIndexedSupplyOrderPaymentGroup(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			supplyOrder.copySupplyOrderPaymentGroupFrom( supplyOrderPaymentGroup );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
			
			userContext.getManagerGroup().getSupplyOrderPaymentGroupManager().onNewInstanceCreated(userContext, (SupplyOrderPaymentGroup)supplyOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderId, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
		userContext.getChecker().checkVersionOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupVersion);
		

		if(SupplyOrderPaymentGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfSupplyOrderPaymentGroup(parseString(newValueExpr));
		}
		
		if(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkCardNumberOfSupplyOrderPaymentGroup(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
	}
	
	public  SupplyOrder updateSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderId, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrderPaymentGroup(userContext, supplyOrderId, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSupplyOrderPaymentGroupList().searchSupplyOrderPaymentGroupListWith(SupplyOrderPaymentGroup.ID_PROPERTY, "eq", supplyOrderPaymentGroupId).done();
		
		
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, loadTokens);
		
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrder.removeSupplyOrderPaymentGroup( supplyOrderPaymentGroup );	
			//make changes to AcceleraterAccount.
			SupplyOrderPaymentGroup supplyOrderPaymentGroupIndex = createIndexedSupplyOrderPaymentGroup(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
		
			SupplyOrderPaymentGroup supplyOrderPaymentGroup = supplyOrder.findTheSupplyOrderPaymentGroup(supplyOrderPaymentGroupIndex);
			if(supplyOrderPaymentGroup == null){
				throw new SupplyOrderManagerException(supplyOrderPaymentGroup+" is NOT FOUND" );
			}
			
			supplyOrderPaymentGroup.changeProperty(property, newValueExpr);
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withSupplyOrderPaymentGroupList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String supplyOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);

		
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
		
		userContext.getChecker().checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);

	
	}
	public  SupplyOrder addGoods(RetailscmUserContext userContext, String supplyOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,supplyOrderId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, retailStoreId, retailStoreOrderId);
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.addGoods( goods );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, goods);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String supplyOrderId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkIdOfGoods(id);
		
		userContext.getChecker().checkNameOfGoods( name);
		userContext.getChecker().checkRfidOfGoods( rfid);
		userContext.getChecker().checkUomOfGoods( uom);
		userContext.getChecker().checkMaxPackageOfGoods( maxPackage);
		userContext.getChecker().checkExpireTimeOfGoods( expireTime);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
		
	}
	public  SupplyOrder updateGoodsProperties(RetailscmUserContext userContext, String supplyOrderId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGoodsProperties(userContext,supplyOrderId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, "is", id).done();
		
		SupplyOrder supplyOrderToUpdate = loadSupplyOrder(userContext, supplyOrderId, options);
		
		if(supplyOrderToUpdate.getGoodsList().isEmpty()){
			throw new SupplyOrderManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}
		
		Goods item = supplyOrderToUpdate.getGoodsList().first();
		
		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );

		
		//checkParamsForAddingGoods(userContext,supplyOrderId,name, code, used,tokensExpr);
		SupplyOrder supplyOrder = saveSupplyOrder(userContext, supplyOrderToUpdate, tokens().withGoodsList().done());
		synchronized(supplyOrder){ 
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Goods createGoods(RetailscmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId) throws Exception{

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
		RetailStoreOrder  retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(retailStoreOrderId);		
		goods.setRetailStoreOrder(retailStoreOrder);		
		goods.setCurrentStatus("INIT");
	
		
		return goods;
	
		
	}
	
	protected Goods createIndexedGoods(String id, int version){

		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(version);
		return goods;			
		
	}
	
	protected void checkParamsForRemovingGoodsList(RetailscmUserContext userContext, String supplyOrderId, 
			String goodsIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		for(String goodsId: goodsIds){
			userContext.getChecker().checkIdOfGoods(goodsId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
		
	}
	public  SupplyOrder removeGoodsList(RetailscmUserContext userContext, String supplyOrderId, 
			String goodsIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGoodsList(userContext, supplyOrderId,  goodsIds, tokensExpr);
			
			
			SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
			synchronized(supplyOrder){ 
				//Will be good when the supplyOrder loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderDAO().planToRemoveGoodsList(supplyOrder, goodsIds, allTokens());
				supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, supplyOrder.getGoodsList());
				return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String supplyOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrder( supplyOrderId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
	}
	public  SupplyOrder removeGoods(RetailscmUserContext userContext, String supplyOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,supplyOrderId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrder.removeGoods( goods );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGoods(RetailscmUserContext userContext, String supplyOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrder( supplyOrderId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
	}
	public  SupplyOrder copyGoodsFrom(RetailscmUserContext userContext, String supplyOrderId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,supplyOrderId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, allTokens());
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			supplyOrder.copyGoodsFrom( goods );		
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, (Goods)supplyOrder.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String supplyOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderManagerException.class);
	
	}
	
	public  SupplyOrder updateGoods(RetailscmUserContext userContext, String supplyOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, supplyOrderId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, "eq", goodsId).done();
		
		
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, loadTokens);
		
		synchronized(supplyOrder){ 
			//Will be good when the supplyOrder loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrder.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = supplyOrder.findTheGoods(goodsIndex);
			if(goods == null){
				throw new SupplyOrderManagerException(goods+" is NOT FOUND" );
			}
			
			goods.changeProperty(property, newValueExpr);
			
			supplyOrder = saveSupplyOrder(userContext, supplyOrder, tokens().withGoodsList().done());
			return present(userContext,supplyOrder, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SupplyOrder associateGoodsListToNewPackaging(RetailscmUserContext userContext, String supplyOrderId, String  goodsIds[], String packageName, String rfid, Date packageTime, String description, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().createGoodsPackaging(userContext,  packageName,  rfid,  packageTime,  description);
		
		for(Goods goods: supplyOrder.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveSupplyOrder(userContext, supplyOrder);
	}
	*/
	
	public  SupplyOrder associateGoodsListToPackaging(RetailscmUserContext userContext, String supplyOrderId, String  goodsIds[], String packagingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		SupplyOrder supplyOrder = loadSupplyOrder(userContext, supplyOrderId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().loadGoodsPackaging(userContext,packagingId,new String[]{"none"} );
		
		for(Goods goods: supplyOrder.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveSupplyOrder(userContext, supplyOrder);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrder newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


