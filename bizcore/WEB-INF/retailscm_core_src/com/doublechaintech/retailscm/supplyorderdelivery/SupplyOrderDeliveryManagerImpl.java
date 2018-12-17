
package com.doublechaintech.retailscm.supplyorderdelivery;

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






public class SupplyOrderDeliveryManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderDeliveryManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderDelivery";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplyOrderDeliveryManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderDeliveryManagerException(message);

	}
	
	

 	protected SupplyOrderDelivery saveSupplyOrderDelivery(RetailscmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderDeliveryDAO().save(supplyOrderDelivery, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens);
 	}
 	
 	protected SupplyOrderDelivery saveSupplyOrderDeliveryDetail(RetailscmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery) throws Exception{	

 		
 		return saveSupplyOrderDelivery(userContext, supplyOrderDelivery, allTokens());
 	}
 	
 	public SupplyOrderDelivery loadSupplyOrderDelivery(RetailscmUserContext userContext, String supplyOrderDeliveryId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderDeliveryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery( userContext, supplyOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderDelivery, tokens);
 	}
 	
 	
 	 public SupplyOrderDelivery searchSupplyOrderDelivery(RetailscmUserContext userContext, String supplyOrderDeliveryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderDeliveryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery( userContext, supplyOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderDelivery, tokens);
 	}
 	
 	

 	protected SupplyOrderDelivery present(RetailscmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderDelivery,tokens);
		
		
		SupplyOrderDelivery  supplyOrderDeliveryToPresent = userContext.getDAOGroup().getSupplyOrderDeliveryDAO().present(supplyOrderDelivery, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderDeliveryToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSupplyOrderDeliveryDAO().alias(entityListToNaming);
		
		return  supplyOrderDeliveryToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderDelivery loadSupplyOrderDeliveryDetail(RetailscmUserContext userContext, String supplyOrderDeliveryId) throws Exception{	
 		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery( userContext, supplyOrderDeliveryId, allTokens());
 		return present(userContext,supplyOrderDelivery, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplyOrderDeliveryId) throws Exception{	
 		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery( userContext, supplyOrderDeliveryId, viewTokens());
 		return present(userContext,supplyOrderDelivery, allTokens());
		
 	}
 	protected SupplyOrderDelivery saveSupplyOrderDelivery(RetailscmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSupplyOrderDeliveryDAO().save(supplyOrderDelivery, tokens);
 	}
 	protected SupplyOrderDelivery loadSupplyOrderDelivery(RetailscmUserContext userContext, String supplyOrderDeliveryId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderDeliveryManagerException.class);

 
 		return userContext.getDAOGroup().getSupplyOrderDeliveryDAO().load(supplyOrderDeliveryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderDelivery, tokens);
		
		addAction(userContext, supplyOrderDelivery, tokens,"@create","createSupplyOrderDelivery","createSupplyOrderDelivery/","main","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"@update","updateSupplyOrderDelivery","updateSupplyOrderDelivery/"+supplyOrderDelivery.getId()+"/","main","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"@copy","cloneSupplyOrderDelivery","cloneSupplyOrderDelivery/"+supplyOrderDelivery.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderDelivery.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderDelivery.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderDelivery.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderDelivery.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderDelivery.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderDelivery.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderDelivery.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderDelivery, tokens,"supply_order_delivery.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderDelivery.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderDelivery createSupplyOrderDelivery(RetailscmUserContext userContext,String who, Date deliveryTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfSupplyOrderDelivery(who);
		userContext.getChecker().checkDeliveryTimeOfSupplyOrderDelivery(deliveryTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);


		SupplyOrderDelivery supplyOrderDelivery=createNewSupplyOrderDelivery();	

		supplyOrderDelivery.setWho(who);
		supplyOrderDelivery.setDeliveryTime(deliveryTime);

		supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderDelivery);
		return supplyOrderDelivery;

		
	}
	protected SupplyOrderDelivery createNewSupplyOrderDelivery() 
	{
		
		return new SupplyOrderDelivery();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderDelivery(RetailscmUserContext userContext,String supplyOrderDeliveryId, int supplyOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		userContext.getChecker().checkVersionOfSupplyOrderDelivery( supplyOrderDeliveryVersion);
		

		if(SupplyOrderDelivery.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfSupplyOrderDelivery(parseString(newValueExpr));
		}
		if(SupplyOrderDelivery.DELIVERY_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkDeliveryTimeOfSupplyOrderDelivery(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);
	
		
	}
	
	
	
	public SupplyOrderDelivery clone(RetailscmUserContext userContext, String fromSupplyOrderDeliveryId) throws Exception{
		
		return userContext.getDAOGroup().getSupplyOrderDeliveryDAO().clone(fromSupplyOrderDeliveryId, this.allTokens());
	}
	
	public SupplyOrderDelivery internalSaveSupplyOrderDelivery(RetailscmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery) throws Exception 
	{
		return internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery, allTokens());

	}
	public SupplyOrderDelivery internalSaveSupplyOrderDelivery(RetailscmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplyOrderDelivery(userContext, supplyOrderDeliveryId, supplyOrderDeliveryVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplyOrderDelivery){ 
			//will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderDelivery.
			
			
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, options);
			return supplyOrderDelivery;
			
		}

	}
	
	public SupplyOrderDelivery updateSupplyOrderDelivery(RetailscmUserContext userContext,String supplyOrderDeliveryId, int supplyOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderDelivery(userContext, supplyOrderDeliveryId, supplyOrderDeliveryVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		if(supplyOrderDelivery.getVersion() != supplyOrderDeliveryVersion){
			String message = "The target version("+supplyOrderDelivery.getVersion()+") is not equals to version("+supplyOrderDeliveryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderDelivery){ 
			//will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderDelivery.
			
			supplyOrderDelivery.changeProperty(property, newValueExpr);
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().done());
		}

	}
	
	public SupplyOrderDelivery updateSupplyOrderDeliveryProperty(RetailscmUserContext userContext,String supplyOrderDeliveryId, int supplyOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderDelivery(userContext, supplyOrderDeliveryId, supplyOrderDeliveryVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		if(supplyOrderDelivery.getVersion() != supplyOrderDeliveryVersion){
			String message = "The target version("+supplyOrderDelivery.getVersion()+") is not equals to version("+supplyOrderDeliveryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderDelivery){ 
			//will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderDelivery.
			
			supplyOrderDelivery.changeProperty(property, newValueExpr);
			
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderDeliveryTokens tokens(){
		return SupplyOrderDeliveryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderDeliveryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderDeliveryTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplyOrderDeliveryId, int supplyOrderDeliveryVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderDeliveryId, supplyOrderDeliveryVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderDeliveryId, int supplyOrderDeliveryVersion) throws Exception{
			
		userContext.getDAOGroup().getSupplyOrderDeliveryDAO().delete(supplyOrderDeliveryId, supplyOrderDeliveryVersion);
	}
	
	public SupplyOrderDelivery forgetByAll(RetailscmUserContext userContext, String supplyOrderDeliveryId, int supplyOrderDeliveryVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderDeliveryId, supplyOrderDeliveryVersion);		
	}
	protected SupplyOrderDelivery forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderDeliveryId, int supplyOrderDeliveryVersion) throws Exception{
			
		return userContext.getDAOGroup().getSupplyOrderDeliveryDAO().disconnectFromAll(supplyOrderDeliveryId, supplyOrderDeliveryVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderDeliveryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSupplyOrderDeliveryDAO().deleteAll();
	}


	//disconnect SupplyOrderDelivery with consumer in ConsumerOrder
	protected SupplyOrderDelivery breakWithConsumerOrderByConsumer(RetailscmUserContext userContext, String supplyOrderDeliveryId, String consumerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDeliveryDAO().planToRemoveConsumerOrderListWithConsumer(supplyOrderDelivery, consumerId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with store in ConsumerOrder
	protected SupplyOrderDelivery breakWithConsumerOrderByStore(RetailscmUserContext userContext, String supplyOrderDeliveryId, String storeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDeliveryDAO().planToRemoveConsumerOrderListWithStore(supplyOrderDelivery, storeId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with buyer in SupplyOrder
	protected SupplyOrderDelivery breakWithSupplyOrderByBuyer(RetailscmUserContext userContext, String supplyOrderDeliveryId, String buyerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDeliveryDAO().planToRemoveSupplyOrderListWithBuyer(supplyOrderDelivery, buyerId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
				return supplyOrderDelivery;
			}
	}
	//disconnect SupplyOrderDelivery with seller in SupplyOrder
	protected SupplyOrderDelivery breakWithSupplyOrderBySeller(RetailscmUserContext userContext, String supplyOrderDeliveryId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());

			synchronized(supplyOrderDelivery){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderDeliveryDAO().planToRemoveSupplyOrderListWithSeller(supplyOrderDelivery, sellerId, this.emptyOptions());

				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
				return supplyOrderDelivery;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String storeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);

		
		userContext.getChecker().checkTitleOfConsumerOrder(title);
		
		userContext.getChecker().checkConsumerIdOfConsumerOrder(consumerId);
		
		userContext.getChecker().checkStoreIdOfConsumerOrder(storeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);

	
	}
	public  SupplyOrderDelivery addConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderDeliveryId,title, consumerId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, storeId);
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.addConsumerOrder( consumerOrder );		
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderDeliveryId,String id,String title,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		userContext.getChecker().checkIdOfConsumerOrder(id);
		
		userContext.getChecker().checkTitleOfConsumerOrder( title);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);
		
	}
	public  SupplyOrderDelivery updateConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderDeliveryId, String id,String title, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingConsumerOrderProperties(userContext,supplyOrderDeliveryId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderDelivery supplyOrderDeliveryToUpdate = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		if(supplyOrderDeliveryToUpdate.getConsumerOrderList().isEmpty()){
			throw new SupplyOrderDeliveryManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}
		
		ConsumerOrder item = supplyOrderDeliveryToUpdate.getConsumerOrderList().first();
		
		item.updateTitle( title );

		
		//checkParamsForAddingConsumerOrder(userContext,supplyOrderDeliveryId,name, code, used,tokensExpr);
		SupplyOrderDelivery supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDeliveryToUpdate, tokens().withConsumerOrderList().done());
		synchronized(supplyOrderDelivery){ 
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingConsumerOrderList(RetailscmUserContext userContext, String supplyOrderDeliveryId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		for(String consumerOrderId: consumerOrderIds){
			userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);
		
	}
	public  SupplyOrderDelivery removeConsumerOrderList(RetailscmUserContext userContext, String supplyOrderDeliveryId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingConsumerOrderList(userContext, supplyOrderDeliveryId,  consumerOrderIds, tokensExpr);
			
			
			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
			synchronized(supplyOrderDelivery){ 
				//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderDeliveryDAO().planToRemoveConsumerOrderList(supplyOrderDelivery, consumerOrderIds, allTokens());
				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderDelivery.getConsumerOrderList());
				return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderDelivery( supplyOrderDeliveryId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);
	
	}
	public  SupplyOrderDelivery removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderDeliveryId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.removeConsumerOrder( consumerOrder );		
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderDelivery( supplyOrderDeliveryId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);
	
	}
	public  SupplyOrderDelivery copyConsumerOrderFrom(RetailscmUserContext userContext, String supplyOrderDeliveryId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderDeliveryId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			consumerOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderDelivery.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)supplyOrderDelivery.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfConsumerOrder(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);
	
	}
	
	public  SupplyOrderDelivery updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderDeliveryId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();
		
		
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, loadTokens);
		
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderDelivery.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderDelivery.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderDeliveryManagerException(consumerOrder+" is NOT FOUND" );
			}
			
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SupplyOrderDelivery associateConsumerOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().createSupplyOrderConfirmation(userContext,  who,  confirmTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderDelivery.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateConsumerOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().createSupplyOrderApproval(userContext,  who,  approveTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderDelivery.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateConsumerOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().createSupplyOrderProcessing(userContext,  who,  processTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderDelivery.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateConsumerOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().createSupplyOrderShipment(userContext,  who,  shipTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderDelivery.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}
	*/
	
	public  SupplyOrderDelivery associateConsumerOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().loadSupplyOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderDelivery.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateConsumerOrderListToApproval(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().loadSupplyOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderDelivery.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateConsumerOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().loadSupplyOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderDelivery.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateConsumerOrderListToShipment(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().loadSupplyOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderDelivery.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}


	protected void checkParamsForAddingSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);

		
		userContext.getChecker().checkBuyerIdOfSupplyOrder(buyerId);
		
		userContext.getChecker().checkSellerIdOfSupplyOrder(sellerId);
		
		userContext.getChecker().checkTitleOfSupplyOrder(title);
		
		userContext.getChecker().checkTotalAmountOfSupplyOrder(totalAmount);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);

	
	}
	public  SupplyOrderDelivery addSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderDeliveryId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.addSupplyOrder( supplyOrder );		
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderDeliveryId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		userContext.getChecker().checkIdOfSupplyOrder(id);
		
		userContext.getChecker().checkTitleOfSupplyOrder( title);
		userContext.getChecker().checkTotalAmountOfSupplyOrder( totalAmount);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);
		
	}
	public  SupplyOrderDelivery updateSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderDeliveryId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSupplyOrderProperties(userContext,supplyOrderDeliveryId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderDelivery supplyOrderDeliveryToUpdate = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		if(supplyOrderDeliveryToUpdate.getSupplyOrderList().isEmpty()){
			throw new SupplyOrderDeliveryManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}
		
		SupplyOrder item = supplyOrderDeliveryToUpdate.getSupplyOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingSupplyOrder(userContext,supplyOrderDeliveryId,name, code, used,tokensExpr);
		SupplyOrderDelivery supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDeliveryToUpdate, tokens().withSupplyOrderList().done());
		synchronized(supplyOrderDelivery){ 
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingSupplyOrderList(RetailscmUserContext userContext, String supplyOrderDeliveryId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		for(String supplyOrderId: supplyOrderIds){
			userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);
		
	}
	public  SupplyOrderDelivery removeSupplyOrderList(RetailscmUserContext userContext, String supplyOrderDeliveryId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSupplyOrderList(userContext, supplyOrderDeliveryId,  supplyOrderIds, tokensExpr);
			
			
			SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
			synchronized(supplyOrderDelivery){ 
				//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderDeliveryDAO().planToRemoveSupplyOrderList(supplyOrderDelivery, supplyOrderIds, allTokens());
				supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderDelivery.getSupplyOrderList());
				return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderDelivery( supplyOrderDeliveryId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);
	
	}
	public  SupplyOrderDelivery removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderDeliveryId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderDelivery.removeSupplyOrder( supplyOrder );		
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderDelivery( supplyOrderDeliveryId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);
	
	}
	public  SupplyOrderDelivery copySupplyOrderFrom(RetailscmUserContext userContext, String supplyOrderDeliveryId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderDeliveryId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, allTokens());
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			supplyOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderDelivery.copySupplyOrderFrom( supplyOrder );		
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)supplyOrderDelivery.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrderDelivery(supplyOrderDeliveryId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfSupplyOrder(parseString(newValueExpr));
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderDeliveryManagerException.class);
	
	}
	
	public  SupplyOrderDelivery updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderDeliveryId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();
		
		
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, loadTokens);
		
		synchronized(supplyOrderDelivery){ 
			//Will be good when the supplyOrderDelivery loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderDelivery.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderDelivery.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderDeliveryManagerException(supplyOrder+" is NOT FOUND" );
			}
			
			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrderDelivery = saveSupplyOrderDelivery(userContext, supplyOrderDelivery, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderDelivery, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SupplyOrderDelivery associateSupplyOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().createSupplyOrderConfirmation(userContext,  who,  confirmTime);
		
		for(SupplyOrder supplyOrder: supplyOrderDelivery.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateSupplyOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().createSupplyOrderApproval(userContext,  who,  approveTime);
		
		for(SupplyOrder supplyOrder: supplyOrderDelivery.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateSupplyOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().createSupplyOrderProcessing(userContext,  who,  processTime);
		
		for(SupplyOrder supplyOrder: supplyOrderDelivery.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateSupplyOrderListToNewPicking(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderPicking picking = userContext.getManagerGroup().getSupplyOrderPickingManager().createSupplyOrderPicking(userContext,  who,  processTime);
		
		for(SupplyOrder supplyOrder: supplyOrderDelivery.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updatePicking(picking);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateSupplyOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().createSupplyOrderShipment(userContext,  who,  shipTime);
		
		for(SupplyOrder supplyOrder: supplyOrderDelivery.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}
	*/
	
	public  SupplyOrderDelivery associateSupplyOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().loadSupplyOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderDelivery.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateSupplyOrderListToApproval(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().loadSupplyOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderDelivery.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateSupplyOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().loadSupplyOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderDelivery.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateSupplyOrderListToPicking(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String pickingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderPicking picking = userContext.getManagerGroup().getSupplyOrderPickingManager().loadSupplyOrderPicking(userContext,pickingId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderDelivery.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updatePicking(picking);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}	public  SupplyOrderDelivery associateSupplyOrderListToShipment(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderDelivery supplyOrderDelivery = loadSupplyOrderDelivery(userContext, supplyOrderDeliveryId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().loadSupplyOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderDelivery.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderDelivery(userContext, supplyOrderDelivery);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderDelivery newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


