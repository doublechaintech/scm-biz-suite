
package com.doublechaintech.retailscm.supplyordershipment;

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






public class SupplyOrderShipmentManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderShipmentManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderShipment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplyOrderShipmentManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderShipmentManagerException(message);

	}
	
	

 	protected SupplyOrderShipment saveSupplyOrderShipment(RetailscmUserContext userContext, SupplyOrderShipment supplyOrderShipment, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderShipmentDAO().save(supplyOrderShipment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens);
 	}
 	
 	protected SupplyOrderShipment saveSupplyOrderShipmentDetail(RetailscmUserContext userContext, SupplyOrderShipment supplyOrderShipment) throws Exception{	

 		
 		return saveSupplyOrderShipment(userContext, supplyOrderShipment, allTokens());
 	}
 	
 	public SupplyOrderShipment loadSupplyOrderShipment(RetailscmUserContext userContext, String supplyOrderShipmentId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderShipmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment( userContext, supplyOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderShipment, tokens);
 	}
 	
 	
 	 public SupplyOrderShipment searchSupplyOrderShipment(RetailscmUserContext userContext, String supplyOrderShipmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderShipmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment( userContext, supplyOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderShipment, tokens);
 	}
 	
 	

 	protected SupplyOrderShipment present(RetailscmUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderShipment,tokens);
		
		
		SupplyOrderShipment  supplyOrderShipmentToPresent = userContext.getDAOGroup().getSupplyOrderShipmentDAO().present(supplyOrderShipment, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderShipmentToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSupplyOrderShipmentDAO().alias(entityListToNaming);
		
		return  supplyOrderShipmentToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderShipment loadSupplyOrderShipmentDetail(RetailscmUserContext userContext, String supplyOrderShipmentId) throws Exception{	
 		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment( userContext, supplyOrderShipmentId, allTokens());
 		return present(userContext,supplyOrderShipment, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplyOrderShipmentId) throws Exception{	
 		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment( userContext, supplyOrderShipmentId, viewTokens());
 		return present(userContext,supplyOrderShipment, allTokens());
		
 	}
 	protected SupplyOrderShipment saveSupplyOrderShipment(RetailscmUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSupplyOrderShipmentDAO().save(supplyOrderShipment, tokens);
 	}
 	protected SupplyOrderShipment loadSupplyOrderShipment(RetailscmUserContext userContext, String supplyOrderShipmentId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderShipmentManagerException.class);

 
 		return userContext.getDAOGroup().getSupplyOrderShipmentDAO().load(supplyOrderShipmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderShipment, tokens);
		
		addAction(userContext, supplyOrderShipment, tokens,"@create","createSupplyOrderShipment","createSupplyOrderShipment/","main","primary");
		addAction(userContext, supplyOrderShipment, tokens,"@update","updateSupplyOrderShipment","updateSupplyOrderShipment/"+supplyOrderShipment.getId()+"/","main","primary");
		addAction(userContext, supplyOrderShipment, tokens,"@copy","cloneSupplyOrderShipment","cloneSupplyOrderShipment/"+supplyOrderShipment.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderShipment.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderShipment.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderShipment.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderShipment.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderShipment.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderShipment.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderShipment.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderShipment, tokens,"supply_order_shipment.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderShipment.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderShipment createSupplyOrderShipment(RetailscmUserContext userContext,String who, Date shipTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfSupplyOrderShipment(who);
		userContext.getChecker().checkShipTimeOfSupplyOrderShipment(shipTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);


		SupplyOrderShipment supplyOrderShipment=createNewSupplyOrderShipment();	

		supplyOrderShipment.setWho(who);
		supplyOrderShipment.setShipTime(shipTime);

		supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderShipment);
		return supplyOrderShipment;

		
	}
	protected SupplyOrderShipment createNewSupplyOrderShipment() 
	{
		
		return new SupplyOrderShipment();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderShipment(RetailscmUserContext userContext,String supplyOrderShipmentId, int supplyOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		userContext.getChecker().checkVersionOfSupplyOrderShipment( supplyOrderShipmentVersion);
		

		if(SupplyOrderShipment.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfSupplyOrderShipment(parseString(newValueExpr));
		}
		if(SupplyOrderShipment.SHIP_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkShipTimeOfSupplyOrderShipment(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);
	
		
	}
	
	
	
	public SupplyOrderShipment clone(RetailscmUserContext userContext, String fromSupplyOrderShipmentId) throws Exception{
		
		return userContext.getDAOGroup().getSupplyOrderShipmentDAO().clone(fromSupplyOrderShipmentId, this.allTokens());
	}
	
	public SupplyOrderShipment internalSaveSupplyOrderShipment(RetailscmUserContext userContext, SupplyOrderShipment supplyOrderShipment) throws Exception 
	{
		return internalSaveSupplyOrderShipment(userContext, supplyOrderShipment, allTokens());

	}
	public SupplyOrderShipment internalSaveSupplyOrderShipment(RetailscmUserContext userContext, SupplyOrderShipment supplyOrderShipment, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplyOrderShipment(userContext, supplyOrderShipmentId, supplyOrderShipmentVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplyOrderShipment){ 
			//will be good when the supplyOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderShipment.
			
			
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, options);
			return supplyOrderShipment;
			
		}

	}
	
	public SupplyOrderShipment updateSupplyOrderShipment(RetailscmUserContext userContext,String supplyOrderShipmentId, int supplyOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderShipment(userContext, supplyOrderShipmentId, supplyOrderShipmentVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		if(supplyOrderShipment.getVersion() != supplyOrderShipmentVersion){
			String message = "The target version("+supplyOrderShipment.getVersion()+") is not equals to version("+supplyOrderShipmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderShipment){ 
			//will be good when the supplyOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderShipment.
			
			supplyOrderShipment.changeProperty(property, newValueExpr);
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().done());
		}

	}
	
	public SupplyOrderShipment updateSupplyOrderShipmentProperty(RetailscmUserContext userContext,String supplyOrderShipmentId, int supplyOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderShipment(userContext, supplyOrderShipmentId, supplyOrderShipmentVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		if(supplyOrderShipment.getVersion() != supplyOrderShipmentVersion){
			String message = "The target version("+supplyOrderShipment.getVersion()+") is not equals to version("+supplyOrderShipmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderShipment){ 
			//will be good when the supplyOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderShipment.
			
			supplyOrderShipment.changeProperty(property, newValueExpr);
			
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderShipmentTokens tokens(){
		return SupplyOrderShipmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderShipmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderShipmentTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplyOrderShipmentId, int supplyOrderShipmentVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderShipmentId, supplyOrderShipmentVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderShipmentId, int supplyOrderShipmentVersion) throws Exception{
			
		userContext.getDAOGroup().getSupplyOrderShipmentDAO().delete(supplyOrderShipmentId, supplyOrderShipmentVersion);
	}
	
	public SupplyOrderShipment forgetByAll(RetailscmUserContext userContext, String supplyOrderShipmentId, int supplyOrderShipmentVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderShipmentId, supplyOrderShipmentVersion);		
	}
	protected SupplyOrderShipment forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderShipmentId, int supplyOrderShipmentVersion) throws Exception{
			
		return userContext.getDAOGroup().getSupplyOrderShipmentDAO().disconnectFromAll(supplyOrderShipmentId, supplyOrderShipmentVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderShipmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSupplyOrderShipmentDAO().deleteAll();
	}


	//disconnect SupplyOrderShipment with consumer in ConsumerOrder
	protected SupplyOrderShipment breakWithConsumerOrderByConsumer(RetailscmUserContext userContext, String supplyOrderShipmentId, String consumerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderShipmentDAO().planToRemoveConsumerOrderListWithConsumer(supplyOrderShipment, consumerId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with store in ConsumerOrder
	protected SupplyOrderShipment breakWithConsumerOrderByStore(RetailscmUserContext userContext, String supplyOrderShipmentId, String storeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderShipmentDAO().planToRemoveConsumerOrderListWithStore(supplyOrderShipment, storeId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with buyer in SupplyOrder
	protected SupplyOrderShipment breakWithSupplyOrderByBuyer(RetailscmUserContext userContext, String supplyOrderShipmentId, String buyerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderShipmentDAO().planToRemoveSupplyOrderListWithBuyer(supplyOrderShipment, buyerId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
				return supplyOrderShipment;
			}
	}
	//disconnect SupplyOrderShipment with seller in SupplyOrder
	protected SupplyOrderShipment breakWithSupplyOrderBySeller(RetailscmUserContext userContext, String supplyOrderShipmentId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());

			synchronized(supplyOrderShipment){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderShipmentDAO().planToRemoveSupplyOrderListWithSeller(supplyOrderShipment, sellerId, this.emptyOptions());

				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
				return supplyOrderShipment;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String storeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderShipment(supplyOrderShipmentId);

		
		userContext.getChecker().checkTitleOfConsumerOrder(title);
		
		userContext.getChecker().checkConsumerIdOfConsumerOrder(consumerId);
		
		userContext.getChecker().checkStoreIdOfConsumerOrder(storeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);

	
	}
	public  SupplyOrderShipment addConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderShipmentId,title, consumerId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, storeId);
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.addConsumerOrder( consumerOrder );		
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderShipmentId,String id,String title,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		userContext.getChecker().checkIdOfConsumerOrder(id);
		
		userContext.getChecker().checkTitleOfConsumerOrder( title);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);
		
	}
	public  SupplyOrderShipment updateConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderShipmentId, String id,String title, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingConsumerOrderProperties(userContext,supplyOrderShipmentId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderShipment supplyOrderShipmentToUpdate = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		if(supplyOrderShipmentToUpdate.getConsumerOrderList().isEmpty()){
			throw new SupplyOrderShipmentManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}
		
		ConsumerOrder item = supplyOrderShipmentToUpdate.getConsumerOrderList().first();
		
		item.updateTitle( title );

		
		//checkParamsForAddingConsumerOrder(userContext,supplyOrderShipmentId,name, code, used,tokensExpr);
		SupplyOrderShipment supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipmentToUpdate, tokens().withConsumerOrderList().done());
		synchronized(supplyOrderShipment){ 
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingConsumerOrderList(RetailscmUserContext userContext, String supplyOrderShipmentId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		for(String consumerOrderId: consumerOrderIds){
			userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);
		
	}
	public  SupplyOrderShipment removeConsumerOrderList(RetailscmUserContext userContext, String supplyOrderShipmentId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingConsumerOrderList(userContext, supplyOrderShipmentId,  consumerOrderIds, tokensExpr);
			
			
			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
			synchronized(supplyOrderShipment){ 
				//Will be good when the supplyOrderShipment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderShipmentDAO().planToRemoveConsumerOrderList(supplyOrderShipment, consumerOrderIds, allTokens());
				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderShipment.getConsumerOrderList());
				return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderShipment( supplyOrderShipmentId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);
	
	}
	public  SupplyOrderShipment removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderShipmentId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.removeConsumerOrder( consumerOrder );		
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderShipment( supplyOrderShipmentId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);
	
	}
	public  SupplyOrderShipment copyConsumerOrderFrom(RetailscmUserContext userContext, String supplyOrderShipmentId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderShipmentId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			consumerOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderShipment.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)supplyOrderShipment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfConsumerOrder(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);
	
	}
	
	public  SupplyOrderShipment updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderShipmentId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();
		
		
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, loadTokens);
		
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderShipment.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderShipment.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderShipmentManagerException(consumerOrder+" is NOT FOUND" );
			}
			
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SupplyOrderShipment associateConsumerOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().createSupplyOrderConfirmation(userContext,  who,  confirmTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderShipment.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateConsumerOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().createSupplyOrderApproval(userContext,  who,  approveTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderShipment.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateConsumerOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().createSupplyOrderProcessing(userContext,  who,  processTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderShipment.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateConsumerOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().createSupplyOrderDelivery(userContext,  who,  deliveryTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderShipment.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}
	*/
	
	public  SupplyOrderShipment associateConsumerOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().loadSupplyOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderShipment.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateConsumerOrderListToApproval(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().loadSupplyOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderShipment.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateConsumerOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().loadSupplyOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderShipment.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateConsumerOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().loadSupplyOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderShipment.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}


	protected void checkParamsForAddingSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderShipment(supplyOrderShipmentId);

		
		userContext.getChecker().checkBuyerIdOfSupplyOrder(buyerId);
		
		userContext.getChecker().checkSellerIdOfSupplyOrder(sellerId);
		
		userContext.getChecker().checkTitleOfSupplyOrder(title);
		
		userContext.getChecker().checkTotalAmountOfSupplyOrder(totalAmount);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);

	
	}
	public  SupplyOrderShipment addSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderShipmentId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.addSupplyOrder( supplyOrder );		
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderShipmentId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		userContext.getChecker().checkIdOfSupplyOrder(id);
		
		userContext.getChecker().checkTitleOfSupplyOrder( title);
		userContext.getChecker().checkTotalAmountOfSupplyOrder( totalAmount);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);
		
	}
	public  SupplyOrderShipment updateSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderShipmentId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSupplyOrderProperties(userContext,supplyOrderShipmentId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderShipment supplyOrderShipmentToUpdate = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		if(supplyOrderShipmentToUpdate.getSupplyOrderList().isEmpty()){
			throw new SupplyOrderShipmentManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}
		
		SupplyOrder item = supplyOrderShipmentToUpdate.getSupplyOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingSupplyOrder(userContext,supplyOrderShipmentId,name, code, used,tokensExpr);
		SupplyOrderShipment supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipmentToUpdate, tokens().withSupplyOrderList().done());
		synchronized(supplyOrderShipment){ 
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingSupplyOrderList(RetailscmUserContext userContext, String supplyOrderShipmentId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		for(String supplyOrderId: supplyOrderIds){
			userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);
		
	}
	public  SupplyOrderShipment removeSupplyOrderList(RetailscmUserContext userContext, String supplyOrderShipmentId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSupplyOrderList(userContext, supplyOrderShipmentId,  supplyOrderIds, tokensExpr);
			
			
			SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
			synchronized(supplyOrderShipment){ 
				//Will be good when the supplyOrderShipment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderShipmentDAO().planToRemoveSupplyOrderList(supplyOrderShipment, supplyOrderIds, allTokens());
				supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderShipment.getSupplyOrderList());
				return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderShipment( supplyOrderShipmentId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);
	
	}
	public  SupplyOrderShipment removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderShipmentId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderShipment.removeSupplyOrder( supplyOrder );		
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderShipment( supplyOrderShipmentId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);
	
	}
	public  SupplyOrderShipment copySupplyOrderFrom(RetailscmUserContext userContext, String supplyOrderShipmentId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderShipmentId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, allTokens());
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			supplyOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderShipment.copySupplyOrderFrom( supplyOrder );		
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)supplyOrderShipment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrderShipment(supplyOrderShipmentId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfSupplyOrder(parseString(newValueExpr));
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShipmentManagerException.class);
	
	}
	
	public  SupplyOrderShipment updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderShipmentId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();
		
		
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, loadTokens);
		
		synchronized(supplyOrderShipment){ 
			//Will be good when the supplyOrderShipment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderShipment.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderShipment.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderShipmentManagerException(supplyOrder+" is NOT FOUND" );
			}
			
			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrderShipment = saveSupplyOrderShipment(userContext, supplyOrderShipment, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderShipment, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SupplyOrderShipment associateSupplyOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().createSupplyOrderConfirmation(userContext,  who,  confirmTime);
		
		for(SupplyOrder supplyOrder: supplyOrderShipment.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateSupplyOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().createSupplyOrderApproval(userContext,  who,  approveTime);
		
		for(SupplyOrder supplyOrder: supplyOrderShipment.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateSupplyOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().createSupplyOrderProcessing(userContext,  who,  processTime);
		
		for(SupplyOrder supplyOrder: supplyOrderShipment.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateSupplyOrderListToNewPicking(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderPicking picking = userContext.getManagerGroup().getSupplyOrderPickingManager().createSupplyOrderPicking(userContext,  who,  processTime);
		
		for(SupplyOrder supplyOrder: supplyOrderShipment.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updatePicking(picking);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateSupplyOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().createSupplyOrderDelivery(userContext,  who,  deliveryTime);
		
		for(SupplyOrder supplyOrder: supplyOrderShipment.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}
	*/
	
	public  SupplyOrderShipment associateSupplyOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().loadSupplyOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderShipment.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateSupplyOrderListToApproval(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().loadSupplyOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderShipment.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateSupplyOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().loadSupplyOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderShipment.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateSupplyOrderListToPicking(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String pickingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderPicking picking = userContext.getManagerGroup().getSupplyOrderPickingManager().loadSupplyOrderPicking(userContext,pickingId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderShipment.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updatePicking(picking);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}	public  SupplyOrderShipment associateSupplyOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderShipment supplyOrderShipment = loadSupplyOrderShipment(userContext, supplyOrderShipmentId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().loadSupplyOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderShipment.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderShipment(userContext, supplyOrderShipment);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderShipment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


