
package com.doublechaintech.retailscm.supplyorderapproval;

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
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;


import com.doublechaintech.retailscm.supplyorderapproval.SupplyOrderApproval;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.doublechaintech.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.doublechaintech.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.doublechaintech.retailscm.supplyordershipment.SupplyOrderShipment;






public class SupplyOrderApprovalManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderApprovalManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderApproval";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplyOrderApprovalManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderApprovalManagerException(message);

	}
	
	

 	protected SupplyOrderApproval saveSupplyOrderApproval(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderApprovalDAO().save(supplyOrderApproval, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens);
 	}
 	
 	protected SupplyOrderApproval saveSupplyOrderApprovalDetail(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval) throws Exception{	

 		
 		return saveSupplyOrderApproval(userContext, supplyOrderApproval, allTokens());
 	}
 	
 	public SupplyOrderApproval loadSupplyOrderApproval(RetailscmUserContext userContext, String supplyOrderApprovalId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderApprovalManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderApproval, tokens);
 	}
 	
 	
 	 public SupplyOrderApproval searchSupplyOrderApproval(RetailscmUserContext userContext, String supplyOrderApprovalId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderApprovalManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderApproval, tokens);
 	}
 	
 	

 	protected SupplyOrderApproval present(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderApproval,tokens);
		
		
		SupplyOrderApproval  supplyOrderApprovalToPresent = userContext.getDAOGroup().getSupplyOrderApprovalDAO().present(supplyOrderApproval, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderApprovalToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSupplyOrderApprovalDAO().alias(entityListToNaming);
		
		return  supplyOrderApprovalToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderApproval loadSupplyOrderApprovalDetail(RetailscmUserContext userContext, String supplyOrderApprovalId) throws Exception{	
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, allTokens());
 		return present(userContext,supplyOrderApproval, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplyOrderApprovalId) throws Exception{	
 		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval( userContext, supplyOrderApprovalId, viewTokens());
 		return present(userContext,supplyOrderApproval, allTokens());
		
 	}
 	protected SupplyOrderApproval saveSupplyOrderApproval(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSupplyOrderApprovalDAO().save(supplyOrderApproval, tokens);
 	}
 	protected SupplyOrderApproval loadSupplyOrderApproval(RetailscmUserContext userContext, String supplyOrderApprovalId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderApprovalManagerException.class);

 
 		return userContext.getDAOGroup().getSupplyOrderApprovalDAO().load(supplyOrderApprovalId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderApproval, tokens);
		
		addAction(userContext, supplyOrderApproval, tokens,"@create","createSupplyOrderApproval","createSupplyOrderApproval/","main","primary");
		addAction(userContext, supplyOrderApproval, tokens,"@update","updateSupplyOrderApproval","updateSupplyOrderApproval/"+supplyOrderApproval.getId()+"/","main","primary");
		addAction(userContext, supplyOrderApproval, tokens,"@copy","cloneSupplyOrderApproval","cloneSupplyOrderApproval/"+supplyOrderApproval.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderApproval.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderApproval, tokens,"supply_order_approval.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderApproval.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderApproval createSupplyOrderApproval(RetailscmUserContext userContext,String who, Date approveTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfSupplyOrderApproval(who);
		userContext.getChecker().checkApproveTimeOfSupplyOrderApproval(approveTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);


		SupplyOrderApproval supplyOrderApproval=createNewSupplyOrderApproval();	

		supplyOrderApproval.setWho(who);
		supplyOrderApproval.setApproveTime(approveTime);

		supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderApproval);
		return supplyOrderApproval;

		
	}
	protected SupplyOrderApproval createNewSupplyOrderApproval() 
	{
		
		return new SupplyOrderApproval();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderApproval(RetailscmUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		userContext.getChecker().checkVersionOfSupplyOrderApproval( supplyOrderApprovalVersion);
		

		if(SupplyOrderApproval.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfSupplyOrderApproval(parseString(newValueExpr));
		}
		if(SupplyOrderApproval.APPROVE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkApproveTimeOfSupplyOrderApproval(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
		
	}
	
	
	
	public SupplyOrderApproval clone(RetailscmUserContext userContext, String fromSupplyOrderApprovalId) throws Exception{
		
		return userContext.getDAOGroup().getSupplyOrderApprovalDAO().clone(fromSupplyOrderApprovalId, this.allTokens());
	}
	
	public SupplyOrderApproval internalSaveSupplyOrderApproval(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval) throws Exception 
	{
		return internalSaveSupplyOrderApproval(userContext, supplyOrderApproval, allTokens());

	}
	public SupplyOrderApproval internalSaveSupplyOrderApproval(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplyOrderApproval(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplyOrderApproval){ 
			//will be good when the supplyOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderApproval.
			
			
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, options);
			return supplyOrderApproval;
			
		}

	}
	
	public SupplyOrderApproval updateSupplyOrderApproval(RetailscmUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderApproval(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		if(supplyOrderApproval.getVersion() != supplyOrderApprovalVersion){
			String message = "The target version("+supplyOrderApproval.getVersion()+") is not equals to version("+supplyOrderApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderApproval){ 
			//will be good when the supplyOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderApproval.
			
			supplyOrderApproval.changeProperty(property, newValueExpr);
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
		}

	}
	
	public SupplyOrderApproval updateSupplyOrderApprovalProperty(RetailscmUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderApproval(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		if(supplyOrderApproval.getVersion() != supplyOrderApprovalVersion){
			String message = "The target version("+supplyOrderApproval.getVersion()+") is not equals to version("+supplyOrderApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderApproval){ 
			//will be good when the supplyOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderApproval.
			
			supplyOrderApproval.changeProperty(property, newValueExpr);
			
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderApprovalTokens tokens(){
		return SupplyOrderApprovalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderApprovalTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderApprovalTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception{
			
		userContext.getDAOGroup().getSupplyOrderApprovalDAO().delete(supplyOrderApprovalId, supplyOrderApprovalVersion);
	}
	
	public SupplyOrderApproval forgetByAll(RetailscmUserContext userContext, String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderApprovalId, supplyOrderApprovalVersion);		
	}
	protected SupplyOrderApproval forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderApprovalId, int supplyOrderApprovalVersion) throws Exception{
			
		return userContext.getDAOGroup().getSupplyOrderApprovalDAO().disconnectFromAll(supplyOrderApprovalId, supplyOrderApprovalVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderApprovalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSupplyOrderApprovalDAO().deleteAll();
	}


	//disconnect SupplyOrderApproval with consumer in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByConsumer(RetailscmUserContext userContext, String supplyOrderApprovalId, String consumerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderApprovalDAO().planToRemoveConsumerOrderListWithConsumer(supplyOrderApproval, consumerId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with store in ConsumerOrder
	protected SupplyOrderApproval breakWithConsumerOrderByStore(RetailscmUserContext userContext, String supplyOrderApprovalId, String storeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderApprovalDAO().planToRemoveConsumerOrderListWithStore(supplyOrderApproval, storeId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with buyer in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderByBuyer(RetailscmUserContext userContext, String supplyOrderApprovalId, String buyerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderApprovalDAO().planToRemoveSupplyOrderListWithBuyer(supplyOrderApproval, buyerId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	//disconnect SupplyOrderApproval with seller in SupplyOrder
	protected SupplyOrderApproval breakWithSupplyOrderBySeller(RetailscmUserContext userContext, String supplyOrderApprovalId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());

			synchronized(supplyOrderApproval){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderApprovalDAO().planToRemoveSupplyOrderListWithSeller(supplyOrderApproval, sellerId, this.emptyOptions());

				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				return supplyOrderApproval;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String storeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderApproval(supplyOrderApprovalId);

		
		userContext.getChecker().checkTitleOfConsumerOrder(title);
		
		userContext.getChecker().checkConsumerIdOfConsumerOrder(consumerId);
		
		userContext.getChecker().checkStoreIdOfConsumerOrder(storeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	
	}
	public  SupplyOrderApproval addConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderApprovalId,title, consumerId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, storeId);
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.addConsumerOrder( consumerOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderApprovalId,String id,String title,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		userContext.getChecker().checkIdOfConsumerOrder(id);
		
		userContext.getChecker().checkTitleOfConsumerOrder( title);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
		
	}
	public  SupplyOrderApproval updateConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderApprovalId, String id,String title, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingConsumerOrderProperties(userContext,supplyOrderApprovalId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderApproval supplyOrderApprovalToUpdate = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		if(supplyOrderApprovalToUpdate.getConsumerOrderList().isEmpty()){
			throw new SupplyOrderApprovalManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}
		
		ConsumerOrder item = supplyOrderApprovalToUpdate.getConsumerOrderList().first();
		
		item.updateTitle( title );

		
		//checkParamsForAddingConsumerOrder(userContext,supplyOrderApprovalId,name, code, used,tokensExpr);
		SupplyOrderApproval supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApprovalToUpdate, tokens().withConsumerOrderList().done());
		synchronized(supplyOrderApproval){ 
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ConsumerOrder createConsumerOrder(RetailscmUserContext userContext, String title, String consumerId, String storeId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStoreMember  consumer = new RetailStoreMember();
		consumer.setId(consumerId);		
		consumerOrder.setConsumer(consumer);		
		RetailStore  store = new RetailStore();
		store.setId(storeId);		
		consumerOrder.setStore(store);		
		consumerOrder.setLastUpdateTime(userContext.now());		
		consumerOrder.setCurrentStatus("INIT");
	
		
		return consumerOrder;
	
		
	}
	
	protected ConsumerOrder createIndexedConsumerOrder(String id, int version){

		ConsumerOrder consumerOrder = new ConsumerOrder();
		consumerOrder.setId(id);
		consumerOrder.setVersion(version);
		return consumerOrder;			
		
	}
	
	protected void checkParamsForRemovingConsumerOrderList(RetailscmUserContext userContext, String supplyOrderApprovalId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		for(String consumerOrderId: consumerOrderIds){
			userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
		
	}
	public  SupplyOrderApproval removeConsumerOrderList(RetailscmUserContext userContext, String supplyOrderApprovalId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingConsumerOrderList(userContext, supplyOrderApprovalId,  consumerOrderIds, tokensExpr);
			
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
			synchronized(supplyOrderApproval){ 
				//Will be good when the supplyOrderApproval loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderApprovalDAO().planToRemoveConsumerOrderList(supplyOrderApproval, consumerOrderIds, allTokens());
				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderApproval.getConsumerOrderList());
				return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderApproval( supplyOrderApprovalId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
	}
	public  SupplyOrderApproval removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderApprovalId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.removeConsumerOrder( consumerOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderApproval( supplyOrderApprovalId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
	}
	public  SupplyOrderApproval copyConsumerOrderFrom(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderApprovalId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			consumerOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderApproval.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)supplyOrderApproval.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfConsumerOrder(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
	}
	
	public  SupplyOrderApproval updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderApprovalId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();
		
		
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, loadTokens);
		
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderApproval.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderApproval.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderApprovalManagerException(consumerOrder+" is NOT FOUND" );
			}
			
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SupplyOrderApproval associateConsumerOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().createSupplyOrderConfirmation(userContext,  who,  confirmTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderApproval.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateConsumerOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().createSupplyOrderProcessing(userContext,  who,  processTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderApproval.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateConsumerOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().createSupplyOrderShipment(userContext,  who,  shipTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderApproval.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateConsumerOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().createSupplyOrderDelivery(userContext,  who,  deliveryTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderApproval.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}
	*/
	
	public  SupplyOrderApproval associateConsumerOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().loadSupplyOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderApproval.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateConsumerOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().loadSupplyOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderApproval.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateConsumerOrderListToShipment(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().loadSupplyOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderApproval.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateConsumerOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().loadSupplyOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderApproval.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}


	protected void checkParamsForAddingSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderApproval(supplyOrderApprovalId);

		
		userContext.getChecker().checkBuyerIdOfSupplyOrder(buyerId);
		
		userContext.getChecker().checkSellerIdOfSupplyOrder(sellerId);
		
		userContext.getChecker().checkTitleOfSupplyOrder(title);
		
		userContext.getChecker().checkTotalAmountOfSupplyOrder(totalAmount);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);

	
	}
	public  SupplyOrderApproval addSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderApprovalId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.addSupplyOrder( supplyOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderApprovalId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		userContext.getChecker().checkIdOfSupplyOrder(id);
		
		userContext.getChecker().checkTitleOfSupplyOrder( title);
		userContext.getChecker().checkTotalAmountOfSupplyOrder( totalAmount);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
		
	}
	public  SupplyOrderApproval updateSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderApprovalId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSupplyOrderProperties(userContext,supplyOrderApprovalId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderApproval supplyOrderApprovalToUpdate = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		if(supplyOrderApprovalToUpdate.getSupplyOrderList().isEmpty()){
			throw new SupplyOrderApprovalManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}
		
		SupplyOrder item = supplyOrderApprovalToUpdate.getSupplyOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingSupplyOrder(userContext,supplyOrderApprovalId,name, code, used,tokensExpr);
		SupplyOrderApproval supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApprovalToUpdate, tokens().withSupplyOrderList().done());
		synchronized(supplyOrderApproval){ 
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected SupplyOrder createSupplyOrder(RetailscmUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount) throws Exception{

		SupplyOrder supplyOrder = new SupplyOrder();
		
		
		RetailStoreCountryCenter  buyer = new RetailStoreCountryCenter();
		buyer.setId(buyerId);		
		supplyOrder.setBuyer(buyer);		
		GoodsSupplier  seller = new GoodsSupplier();
		seller.setId(sellerId);		
		supplyOrder.setSeller(seller);		
		supplyOrder.setTitle(title);		
		supplyOrder.setTotalAmount(totalAmount);		
		supplyOrder.setLastUpdateTime(userContext.now());		
		supplyOrder.setCurrentStatus("INIT");
	
		
		return supplyOrder;
	
		
	}
	
	protected SupplyOrder createIndexedSupplyOrder(String id, int version){

		SupplyOrder supplyOrder = new SupplyOrder();
		supplyOrder.setId(id);
		supplyOrder.setVersion(version);
		return supplyOrder;			
		
	}
	
	protected void checkParamsForRemovingSupplyOrderList(RetailscmUserContext userContext, String supplyOrderApprovalId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		for(String supplyOrderId: supplyOrderIds){
			userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
		
	}
	public  SupplyOrderApproval removeSupplyOrderList(RetailscmUserContext userContext, String supplyOrderApprovalId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSupplyOrderList(userContext, supplyOrderApprovalId,  supplyOrderIds, tokensExpr);
			
			
			SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
			synchronized(supplyOrderApproval){ 
				//Will be good when the supplyOrderApproval loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderApprovalDAO().planToRemoveSupplyOrderList(supplyOrderApproval, supplyOrderIds, allTokens());
				supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderApproval.getSupplyOrderList());
				return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderApproval( supplyOrderApprovalId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
	}
	public  SupplyOrderApproval removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderApprovalId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderApproval.removeSupplyOrder( supplyOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderApproval( supplyOrderApprovalId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
	}
	public  SupplyOrderApproval copySupplyOrderFrom(RetailscmUserContext userContext, String supplyOrderApprovalId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderApprovalId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, allTokens());
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			supplyOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderApproval.copySupplyOrderFrom( supplyOrder );		
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)supplyOrderApproval.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrderApproval(supplyOrderApprovalId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfSupplyOrder(parseString(newValueExpr));
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderApprovalManagerException.class);
	
	}
	
	public  SupplyOrderApproval updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderApprovalId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();
		
		
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, loadTokens);
		
		synchronized(supplyOrderApproval){ 
			//Will be good when the supplyOrderApproval loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderApproval.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderApproval.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderApprovalManagerException(supplyOrder+" is NOT FOUND" );
			}
			
			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrderApproval = saveSupplyOrderApproval(userContext, supplyOrderApproval, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderApproval, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SupplyOrderApproval associateSupplyOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().createSupplyOrderConfirmation(userContext,  who,  confirmTime);
		
		for(SupplyOrder supplyOrder: supplyOrderApproval.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateSupplyOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().createSupplyOrderProcessing(userContext,  who,  processTime);
		
		for(SupplyOrder supplyOrder: supplyOrderApproval.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateSupplyOrderListToNewPicking(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderPicking picking = userContext.getManagerGroup().getSupplyOrderPickingManager().createSupplyOrderPicking(userContext,  who,  processTime);
		
		for(SupplyOrder supplyOrder: supplyOrderApproval.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updatePicking(picking);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateSupplyOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().createSupplyOrderShipment(userContext,  who,  shipTime);
		
		for(SupplyOrder supplyOrder: supplyOrderApproval.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateSupplyOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().createSupplyOrderDelivery(userContext,  who,  deliveryTime);
		
		for(SupplyOrder supplyOrder: supplyOrderApproval.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}
	*/
	
	public  SupplyOrderApproval associateSupplyOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().loadSupplyOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderApproval.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateSupplyOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().loadSupplyOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderApproval.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateSupplyOrderListToPicking(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String pickingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderPicking picking = userContext.getManagerGroup().getSupplyOrderPickingManager().loadSupplyOrderPicking(userContext,pickingId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderApproval.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updatePicking(picking);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateSupplyOrderListToShipment(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().loadSupplyOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderApproval.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}	public  SupplyOrderApproval associateSupplyOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderApproval supplyOrderApproval = loadSupplyOrderApproval(userContext, supplyOrderApprovalId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().loadSupplyOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderApproval.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderApproval(userContext, supplyOrderApproval);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderApproval newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


