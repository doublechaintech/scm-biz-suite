
package com.doublechaintech.retailscm.supplyorderconfirmation;

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






public class SupplyOrderConfirmationManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderConfirmationManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderConfirmation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplyOrderConfirmationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderConfirmationManagerException(message);

	}
	
	

 	protected SupplyOrderConfirmation saveSupplyOrderConfirmation(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderConfirmationDAO().save(supplyOrderConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens);
 	}
 	
 	protected SupplyOrderConfirmation saveSupplyOrderConfirmationDetail(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation) throws Exception{	

 		
 		return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, allTokens());
 	}
 	
 	public SupplyOrderConfirmation loadSupplyOrderConfirmation(RetailscmUserContext userContext, String supplyOrderConfirmationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderConfirmationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderConfirmation, tokens);
 	}
 	
 	
 	 public SupplyOrderConfirmation searchSupplyOrderConfirmation(RetailscmUserContext userContext, String supplyOrderConfirmationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderConfirmationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderConfirmation, tokens);
 	}
 	
 	

 	protected SupplyOrderConfirmation present(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderConfirmation,tokens);
		
		
		SupplyOrderConfirmation  supplyOrderConfirmationToPresent = userContext.getDAOGroup().getSupplyOrderConfirmationDAO().present(supplyOrderConfirmation, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderConfirmationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSupplyOrderConfirmationDAO().alias(entityListToNaming);
		
		return  supplyOrderConfirmationToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderConfirmation loadSupplyOrderConfirmationDetail(RetailscmUserContext userContext, String supplyOrderConfirmationId) throws Exception{	
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, allTokens());
 		return present(userContext,supplyOrderConfirmation, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplyOrderConfirmationId) throws Exception{	
 		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation( userContext, supplyOrderConfirmationId, viewTokens());
 		return present(userContext,supplyOrderConfirmation, allTokens());
		
 	}
 	protected SupplyOrderConfirmation saveSupplyOrderConfirmation(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSupplyOrderConfirmationDAO().save(supplyOrderConfirmation, tokens);
 	}
 	protected SupplyOrderConfirmation loadSupplyOrderConfirmation(RetailscmUserContext userContext, String supplyOrderConfirmationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderConfirmationManagerException.class);

 
 		return userContext.getDAOGroup().getSupplyOrderConfirmationDAO().load(supplyOrderConfirmationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderConfirmation, tokens);
		
		addAction(userContext, supplyOrderConfirmation, tokens,"@create","createSupplyOrderConfirmation","createSupplyOrderConfirmation/","main","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"@update","updateSupplyOrderConfirmation","updateSupplyOrderConfirmation/"+supplyOrderConfirmation.getId()+"/","main","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"@copy","cloneSupplyOrderConfirmation","cloneSupplyOrderConfirmation/"+supplyOrderConfirmation.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderConfirmation.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderConfirmation, tokens,"supply_order_confirmation.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderConfirmation.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderConfirmation createSupplyOrderConfirmation(RetailscmUserContext userContext,String who, Date confirmTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfSupplyOrderConfirmation(who);
		userContext.getChecker().checkConfirmTimeOfSupplyOrderConfirmation(confirmTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);


		SupplyOrderConfirmation supplyOrderConfirmation=createNewSupplyOrderConfirmation();	

		supplyOrderConfirmation.setWho(who);
		supplyOrderConfirmation.setConfirmTime(confirmTime);

		supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderConfirmation);
		return supplyOrderConfirmation;

		
	}
	protected SupplyOrderConfirmation createNewSupplyOrderConfirmation() 
	{
		
		return new SupplyOrderConfirmation();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderConfirmation(RetailscmUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		userContext.getChecker().checkVersionOfSupplyOrderConfirmation( supplyOrderConfirmationVersion);
		

		if(SupplyOrderConfirmation.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfSupplyOrderConfirmation(parseString(newValueExpr));
		}
		if(SupplyOrderConfirmation.CONFIRM_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkConfirmTimeOfSupplyOrderConfirmation(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
		
	}
	
	
	
	public SupplyOrderConfirmation clone(RetailscmUserContext userContext, String fromSupplyOrderConfirmationId) throws Exception{
		
		return userContext.getDAOGroup().getSupplyOrderConfirmationDAO().clone(fromSupplyOrderConfirmationId, this.allTokens());
	}
	
	public SupplyOrderConfirmation internalSaveSupplyOrderConfirmation(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation) throws Exception 
	{
		return internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, allTokens());

	}
	public SupplyOrderConfirmation internalSaveSupplyOrderConfirmation(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplyOrderConfirmation){ 
			//will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderConfirmation.
			
			
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, options);
			return supplyOrderConfirmation;
			
		}

	}
	
	public SupplyOrderConfirmation updateSupplyOrderConfirmation(RetailscmUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		if(supplyOrderConfirmation.getVersion() != supplyOrderConfirmationVersion){
			String message = "The target version("+supplyOrderConfirmation.getVersion()+") is not equals to version("+supplyOrderConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderConfirmation){ 
			//will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderConfirmation.
			
			supplyOrderConfirmation.changeProperty(property, newValueExpr);
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
		}

	}
	
	public SupplyOrderConfirmation updateSupplyOrderConfirmationProperty(RetailscmUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		if(supplyOrderConfirmation.getVersion() != supplyOrderConfirmationVersion){
			String message = "The target version("+supplyOrderConfirmation.getVersion()+") is not equals to version("+supplyOrderConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderConfirmation){ 
			//will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderConfirmation.
			
			supplyOrderConfirmation.changeProperty(property, newValueExpr);
			
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderConfirmationTokens tokens(){
		return SupplyOrderConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderConfirmationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderConfirmationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception{
			
		userContext.getDAOGroup().getSupplyOrderConfirmationDAO().delete(supplyOrderConfirmationId, supplyOrderConfirmationVersion);
	}
	
	public SupplyOrderConfirmation forgetByAll(RetailscmUserContext userContext, String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderConfirmationId, supplyOrderConfirmationVersion);		
	}
	protected SupplyOrderConfirmation forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderConfirmationId, int supplyOrderConfirmationVersion) throws Exception{
			
		return userContext.getDAOGroup().getSupplyOrderConfirmationDAO().disconnectFromAll(supplyOrderConfirmationId, supplyOrderConfirmationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSupplyOrderConfirmationDAO().deleteAll();
	}


	//disconnect SupplyOrderConfirmation with consumer in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByConsumer(RetailscmUserContext userContext, String supplyOrderConfirmationId, String consumerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderConfirmationDAO().planToRemoveConsumerOrderListWithConsumer(supplyOrderConfirmation, consumerId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with store in ConsumerOrder
	protected SupplyOrderConfirmation breakWithConsumerOrderByStore(RetailscmUserContext userContext, String supplyOrderConfirmationId, String storeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderConfirmationDAO().planToRemoveConsumerOrderListWithStore(supplyOrderConfirmation, storeId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with buyer in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderByBuyer(RetailscmUserContext userContext, String supplyOrderConfirmationId, String buyerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderConfirmationDAO().planToRemoveSupplyOrderListWithBuyer(supplyOrderConfirmation, buyerId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	//disconnect SupplyOrderConfirmation with seller in SupplyOrder
	protected SupplyOrderConfirmation breakWithSupplyOrderBySeller(RetailscmUserContext userContext, String supplyOrderConfirmationId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());

			synchronized(supplyOrderConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderConfirmationDAO().planToRemoveSupplyOrderListWithSeller(supplyOrderConfirmation, sellerId, this.emptyOptions());

				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				return supplyOrderConfirmation;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String storeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);

		
		userContext.getChecker().checkTitleOfConsumerOrder(title);
		
		userContext.getChecker().checkConsumerIdOfConsumerOrder(consumerId);
		
		userContext.getChecker().checkStoreIdOfConsumerOrder(storeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	
	}
	public  SupplyOrderConfirmation addConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderConfirmationId,title, consumerId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, storeId);
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.addConsumerOrder( consumerOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderConfirmationId,String id,String title,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		userContext.getChecker().checkIdOfConsumerOrder(id);
		
		userContext.getChecker().checkTitleOfConsumerOrder( title);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
		
	}
	public  SupplyOrderConfirmation updateConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderConfirmationId, String id,String title, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingConsumerOrderProperties(userContext,supplyOrderConfirmationId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderConfirmation supplyOrderConfirmationToUpdate = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		if(supplyOrderConfirmationToUpdate.getConsumerOrderList().isEmpty()){
			throw new SupplyOrderConfirmationManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}
		
		ConsumerOrder item = supplyOrderConfirmationToUpdate.getConsumerOrderList().first();
		
		item.updateTitle( title );

		
		//checkParamsForAddingConsumerOrder(userContext,supplyOrderConfirmationId,name, code, used,tokensExpr);
		SupplyOrderConfirmation supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmationToUpdate, tokens().withConsumerOrderList().done());
		synchronized(supplyOrderConfirmation){ 
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingConsumerOrderList(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		for(String consumerOrderId: consumerOrderIds){
			userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
		
	}
	public  SupplyOrderConfirmation removeConsumerOrderList(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingConsumerOrderList(userContext, supplyOrderConfirmationId,  consumerOrderIds, tokensExpr);
			
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
			synchronized(supplyOrderConfirmation){ 
				//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderConfirmationDAO().planToRemoveConsumerOrderList(supplyOrderConfirmation, consumerOrderIds, allTokens());
				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderConfirmation.getConsumerOrderList());
				return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation( supplyOrderConfirmationId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
	}
	public  SupplyOrderConfirmation removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderConfirmationId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.removeConsumerOrder( consumerOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation( supplyOrderConfirmationId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
	}
	public  SupplyOrderConfirmation copyConsumerOrderFrom(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderConfirmationId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			consumerOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderConfirmation.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)supplyOrderConfirmation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfConsumerOrder(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
	}
	
	public  SupplyOrderConfirmation updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderConfirmationId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();
		
		
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, loadTokens);
		
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderConfirmation.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderConfirmation.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderConfirmationManagerException(consumerOrder+" is NOT FOUND" );
			}
			
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SupplyOrderConfirmation associateConsumerOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().createSupplyOrderApproval(userContext,  who,  approveTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderConfirmation.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateConsumerOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().createSupplyOrderProcessing(userContext,  who,  processTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderConfirmation.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateConsumerOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().createSupplyOrderShipment(userContext,  who,  shipTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderConfirmation.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateConsumerOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().createSupplyOrderDelivery(userContext,  who,  deliveryTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderConfirmation.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}
	*/
	
	public  SupplyOrderConfirmation associateConsumerOrderListToApproval(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().loadSupplyOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderConfirmation.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateConsumerOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().loadSupplyOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderConfirmation.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateConsumerOrderListToShipment(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().loadSupplyOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderConfirmation.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateConsumerOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().loadSupplyOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderConfirmation.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}


	protected void checkParamsForAddingSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);

		
		userContext.getChecker().checkBuyerIdOfSupplyOrder(buyerId);
		
		userContext.getChecker().checkSellerIdOfSupplyOrder(sellerId);
		
		userContext.getChecker().checkTitleOfSupplyOrder(title);
		
		userContext.getChecker().checkTotalAmountOfSupplyOrder(totalAmount);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);

	
	}
	public  SupplyOrderConfirmation addSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderConfirmationId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.addSupplyOrder( supplyOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderConfirmationId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		userContext.getChecker().checkIdOfSupplyOrder(id);
		
		userContext.getChecker().checkTitleOfSupplyOrder( title);
		userContext.getChecker().checkTotalAmountOfSupplyOrder( totalAmount);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
		
	}
	public  SupplyOrderConfirmation updateSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderConfirmationId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSupplyOrderProperties(userContext,supplyOrderConfirmationId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderConfirmation supplyOrderConfirmationToUpdate = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		if(supplyOrderConfirmationToUpdate.getSupplyOrderList().isEmpty()){
			throw new SupplyOrderConfirmationManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}
		
		SupplyOrder item = supplyOrderConfirmationToUpdate.getSupplyOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingSupplyOrder(userContext,supplyOrderConfirmationId,name, code, used,tokensExpr);
		SupplyOrderConfirmation supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmationToUpdate, tokens().withSupplyOrderList().done());
		synchronized(supplyOrderConfirmation){ 
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingSupplyOrderList(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		for(String supplyOrderId: supplyOrderIds){
			userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
		
	}
	public  SupplyOrderConfirmation removeSupplyOrderList(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSupplyOrderList(userContext, supplyOrderConfirmationId,  supplyOrderIds, tokensExpr);
			
			
			SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
			synchronized(supplyOrderConfirmation){ 
				//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderConfirmationDAO().planToRemoveSupplyOrderList(supplyOrderConfirmation, supplyOrderIds, allTokens());
				supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderConfirmation.getSupplyOrderList());
				return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation( supplyOrderConfirmationId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
	}
	public  SupplyOrderConfirmation removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderConfirmationId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderConfirmation.removeSupplyOrder( supplyOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation( supplyOrderConfirmationId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
	}
	public  SupplyOrderConfirmation copySupplyOrderFrom(RetailscmUserContext userContext, String supplyOrderConfirmationId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderConfirmationId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, allTokens());
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			supplyOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderConfirmation.copySupplyOrderFrom( supplyOrder );		
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)supplyOrderConfirmation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrderConfirmation(supplyOrderConfirmationId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfSupplyOrder(parseString(newValueExpr));
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderConfirmationManagerException.class);
	
	}
	
	public  SupplyOrderConfirmation updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderConfirmationId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();
		
		
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, loadTokens);
		
		synchronized(supplyOrderConfirmation){ 
			//Will be good when the supplyOrderConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderConfirmation.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderConfirmation.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderConfirmationManagerException(supplyOrder+" is NOT FOUND" );
			}
			
			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrderConfirmation = saveSupplyOrderConfirmation(userContext, supplyOrderConfirmation, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SupplyOrderConfirmation associateSupplyOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().createSupplyOrderApproval(userContext,  who,  approveTime);
		
		for(SupplyOrder supplyOrder: supplyOrderConfirmation.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateSupplyOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().createSupplyOrderProcessing(userContext,  who,  processTime);
		
		for(SupplyOrder supplyOrder: supplyOrderConfirmation.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateSupplyOrderListToNewPicking(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderPicking picking = userContext.getManagerGroup().getSupplyOrderPickingManager().createSupplyOrderPicking(userContext,  who,  processTime);
		
		for(SupplyOrder supplyOrder: supplyOrderConfirmation.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updatePicking(picking);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateSupplyOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().createSupplyOrderShipment(userContext,  who,  shipTime);
		
		for(SupplyOrder supplyOrder: supplyOrderConfirmation.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateSupplyOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().createSupplyOrderDelivery(userContext,  who,  deliveryTime);
		
		for(SupplyOrder supplyOrder: supplyOrderConfirmation.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}
	*/
	
	public  SupplyOrderConfirmation associateSupplyOrderListToApproval(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().loadSupplyOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderConfirmation.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateSupplyOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().loadSupplyOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderConfirmation.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateProcessing(processing);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateSupplyOrderListToPicking(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String pickingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderPicking picking = userContext.getManagerGroup().getSupplyOrderPickingManager().loadSupplyOrderPicking(userContext,pickingId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderConfirmation.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updatePicking(picking);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateSupplyOrderListToShipment(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().loadSupplyOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderConfirmation.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}	public  SupplyOrderConfirmation associateSupplyOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadSupplyOrderConfirmation(userContext, supplyOrderConfirmationId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().loadSupplyOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderConfirmation.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderConfirmation(userContext, supplyOrderConfirmation);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderConfirmation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


