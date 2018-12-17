
package com.doublechaintech.retailscm.supplyorderprocessing;

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






public class SupplyOrderProcessingManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderProcessingManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderProcessing";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplyOrderProcessingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderProcessingManagerException(message);

	}
	
	

 	protected SupplyOrderProcessing saveSupplyOrderProcessing(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderProcessingDAO().save(supplyOrderProcessing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens);
 	}
 	
 	protected SupplyOrderProcessing saveSupplyOrderProcessingDetail(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing) throws Exception{	

 		
 		return saveSupplyOrderProcessing(userContext, supplyOrderProcessing, allTokens());
 	}
 	
 	public SupplyOrderProcessing loadSupplyOrderProcessing(RetailscmUserContext userContext, String supplyOrderProcessingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderProcessingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing( userContext, supplyOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderProcessing, tokens);
 	}
 	
 	
 	 public SupplyOrderProcessing searchSupplyOrderProcessing(RetailscmUserContext userContext, String supplyOrderProcessingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderProcessingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing( userContext, supplyOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderProcessing, tokens);
 	}
 	
 	

 	protected SupplyOrderProcessing present(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderProcessing,tokens);
		
		
		SupplyOrderProcessing  supplyOrderProcessingToPresent = userContext.getDAOGroup().getSupplyOrderProcessingDAO().present(supplyOrderProcessing, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderProcessingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSupplyOrderProcessingDAO().alias(entityListToNaming);
		
		return  supplyOrderProcessingToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderProcessing loadSupplyOrderProcessingDetail(RetailscmUserContext userContext, String supplyOrderProcessingId) throws Exception{	
 		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing( userContext, supplyOrderProcessingId, allTokens());
 		return present(userContext,supplyOrderProcessing, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplyOrderProcessingId) throws Exception{	
 		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing( userContext, supplyOrderProcessingId, viewTokens());
 		return present(userContext,supplyOrderProcessing, allTokens());
		
 	}
 	protected SupplyOrderProcessing saveSupplyOrderProcessing(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSupplyOrderProcessingDAO().save(supplyOrderProcessing, tokens);
 	}
 	protected SupplyOrderProcessing loadSupplyOrderProcessing(RetailscmUserContext userContext, String supplyOrderProcessingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderProcessingManagerException.class);

 
 		return userContext.getDAOGroup().getSupplyOrderProcessingDAO().load(supplyOrderProcessingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderProcessing, tokens);
		
		addAction(userContext, supplyOrderProcessing, tokens,"@create","createSupplyOrderProcessing","createSupplyOrderProcessing/","main","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"@update","updateSupplyOrderProcessing","updateSupplyOrderProcessing/"+supplyOrderProcessing.getId()+"/","main","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"@copy","cloneSupplyOrderProcessing","cloneSupplyOrderProcessing/"+supplyOrderProcessing.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+supplyOrderProcessing.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+supplyOrderProcessing.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+supplyOrderProcessing.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+supplyOrderProcessing.getId()+"/","consumerOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderProcessing.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderProcessing.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderProcessing.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderProcessing, tokens,"supply_order_processing.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderProcessing.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderProcessing createSupplyOrderProcessing(RetailscmUserContext userContext,String who, Date processTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfSupplyOrderProcessing(who);
		userContext.getChecker().checkProcessTimeOfSupplyOrderProcessing(processTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);


		SupplyOrderProcessing supplyOrderProcessing=createNewSupplyOrderProcessing();	

		supplyOrderProcessing.setWho(who);
		supplyOrderProcessing.setProcessTime(processTime);

		supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderProcessing);
		return supplyOrderProcessing;

		
	}
	protected SupplyOrderProcessing createNewSupplyOrderProcessing() 
	{
		
		return new SupplyOrderProcessing();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderProcessing(RetailscmUserContext userContext,String supplyOrderProcessingId, int supplyOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		userContext.getChecker().checkVersionOfSupplyOrderProcessing( supplyOrderProcessingVersion);
		

		if(SupplyOrderProcessing.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfSupplyOrderProcessing(parseString(newValueExpr));
		}
		if(SupplyOrderProcessing.PROCESS_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkProcessTimeOfSupplyOrderProcessing(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
		
	}
	
	
	
	public SupplyOrderProcessing clone(RetailscmUserContext userContext, String fromSupplyOrderProcessingId) throws Exception{
		
		return userContext.getDAOGroup().getSupplyOrderProcessingDAO().clone(fromSupplyOrderProcessingId, this.allTokens());
	}
	
	public SupplyOrderProcessing internalSaveSupplyOrderProcessing(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing) throws Exception 
	{
		return internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing, allTokens());

	}
	public SupplyOrderProcessing internalSaveSupplyOrderProcessing(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplyOrderProcessing(userContext, supplyOrderProcessingId, supplyOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplyOrderProcessing){ 
			//will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderProcessing.
			
			
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, options);
			return supplyOrderProcessing;
			
		}

	}
	
	public SupplyOrderProcessing updateSupplyOrderProcessing(RetailscmUserContext userContext,String supplyOrderProcessingId, int supplyOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderProcessing(userContext, supplyOrderProcessingId, supplyOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		if(supplyOrderProcessing.getVersion() != supplyOrderProcessingVersion){
			String message = "The target version("+supplyOrderProcessing.getVersion()+") is not equals to version("+supplyOrderProcessingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderProcessing){ 
			//will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderProcessing.
			
			supplyOrderProcessing.changeProperty(property, newValueExpr);
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().done());
		}

	}
	
	public SupplyOrderProcessing updateSupplyOrderProcessingProperty(RetailscmUserContext userContext,String supplyOrderProcessingId, int supplyOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderProcessing(userContext, supplyOrderProcessingId, supplyOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		if(supplyOrderProcessing.getVersion() != supplyOrderProcessingVersion){
			String message = "The target version("+supplyOrderProcessing.getVersion()+") is not equals to version("+supplyOrderProcessingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderProcessing){ 
			//will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderProcessing.
			
			supplyOrderProcessing.changeProperty(property, newValueExpr);
			
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderProcessingTokens tokens(){
		return SupplyOrderProcessingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderProcessingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderProcessingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplyOrderProcessingId, int supplyOrderProcessingVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderProcessingId, supplyOrderProcessingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderProcessingId, int supplyOrderProcessingVersion) throws Exception{
			
		userContext.getDAOGroup().getSupplyOrderProcessingDAO().delete(supplyOrderProcessingId, supplyOrderProcessingVersion);
	}
	
	public SupplyOrderProcessing forgetByAll(RetailscmUserContext userContext, String supplyOrderProcessingId, int supplyOrderProcessingVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderProcessingId, supplyOrderProcessingVersion);		
	}
	protected SupplyOrderProcessing forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderProcessingId, int supplyOrderProcessingVersion) throws Exception{
			
		return userContext.getDAOGroup().getSupplyOrderProcessingDAO().disconnectFromAll(supplyOrderProcessingId, supplyOrderProcessingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderProcessingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSupplyOrderProcessingDAO().deleteAll();
	}


	//disconnect SupplyOrderProcessing with consumer in ConsumerOrder
	protected SupplyOrderProcessing breakWithConsumerOrderByConsumer(RetailscmUserContext userContext, String supplyOrderProcessingId, String consumerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderProcessingDAO().planToRemoveConsumerOrderListWithConsumer(supplyOrderProcessing, consumerId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with store in ConsumerOrder
	protected SupplyOrderProcessing breakWithConsumerOrderByStore(RetailscmUserContext userContext, String supplyOrderProcessingId, String storeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderProcessingDAO().planToRemoveConsumerOrderListWithStore(supplyOrderProcessing, storeId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with buyer in SupplyOrder
	protected SupplyOrderProcessing breakWithSupplyOrderByBuyer(RetailscmUserContext userContext, String supplyOrderProcessingId, String buyerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderProcessingDAO().planToRemoveSupplyOrderListWithBuyer(supplyOrderProcessing, buyerId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
				return supplyOrderProcessing;
			}
	}
	//disconnect SupplyOrderProcessing with seller in SupplyOrder
	protected SupplyOrderProcessing breakWithSupplyOrderBySeller(RetailscmUserContext userContext, String supplyOrderProcessingId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());

			synchronized(supplyOrderProcessing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplyOrderProcessingDAO().planToRemoveSupplyOrderListWithSeller(supplyOrderProcessing, sellerId, this.emptyOptions());

				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
				return supplyOrderProcessing;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String storeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);

		
		userContext.getChecker().checkTitleOfConsumerOrder(title);
		
		userContext.getChecker().checkConsumerIdOfConsumerOrder(consumerId);
		
		userContext.getChecker().checkStoreIdOfConsumerOrder(storeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);

	
	}
	public  SupplyOrderProcessing addConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,supplyOrderProcessingId,title, consumerId, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId, storeId);
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.addConsumerOrder( consumerOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderProcessingId,String id,String title,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		userContext.getChecker().checkIdOfConsumerOrder(id);
		
		userContext.getChecker().checkTitleOfConsumerOrder( title);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
		
	}
	public  SupplyOrderProcessing updateConsumerOrderProperties(RetailscmUserContext userContext, String supplyOrderProcessingId, String id,String title, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingConsumerOrderProperties(userContext,supplyOrderProcessingId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderProcessing supplyOrderProcessingToUpdate = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		if(supplyOrderProcessingToUpdate.getConsumerOrderList().isEmpty()){
			throw new SupplyOrderProcessingManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}
		
		ConsumerOrder item = supplyOrderProcessingToUpdate.getConsumerOrderList().first();
		
		item.updateTitle( title );

		
		//checkParamsForAddingConsumerOrder(userContext,supplyOrderProcessingId,name, code, used,tokensExpr);
		SupplyOrderProcessing supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessingToUpdate, tokens().withConsumerOrderList().done());
		synchronized(supplyOrderProcessing){ 
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingConsumerOrderList(RetailscmUserContext userContext, String supplyOrderProcessingId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		for(String consumerOrderId: consumerOrderIds){
			userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
		
	}
	public  SupplyOrderProcessing removeConsumerOrderList(RetailscmUserContext userContext, String supplyOrderProcessingId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingConsumerOrderList(userContext, supplyOrderProcessingId,  consumerOrderIds, tokensExpr);
			
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
			synchronized(supplyOrderProcessing){ 
				//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderProcessingDAO().planToRemoveConsumerOrderList(supplyOrderProcessing, consumerOrderIds, allTokens());
				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderProcessing.getConsumerOrderList());
				return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderProcessing( supplyOrderProcessingId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
	}
	public  SupplyOrderProcessing removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,supplyOrderProcessingId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.removeConsumerOrder( consumerOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderProcessing( supplyOrderProcessingId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
	}
	public  SupplyOrderProcessing copyConsumerOrderFrom(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,supplyOrderProcessingId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			consumerOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderProcessing.copyConsumerOrderFrom( consumerOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)supplyOrderProcessing.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfConsumerOrder(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
	}
	
	public  SupplyOrderProcessing updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, supplyOrderProcessingId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();
		
		
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, loadTokens);
		
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderProcessing.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = supplyOrderProcessing.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new SupplyOrderProcessingManagerException(consumerOrder+" is NOT FOUND" );
			}
			
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withConsumerOrderList().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SupplyOrderProcessing associateConsumerOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().createSupplyOrderConfirmation(userContext,  who,  confirmTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderProcessing.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateConsumerOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().createSupplyOrderApproval(userContext,  who,  approveTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderProcessing.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateConsumerOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().createSupplyOrderShipment(userContext,  who,  shipTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderProcessing.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateConsumerOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().createSupplyOrderDelivery(userContext,  who,  deliveryTime);
		
		for(ConsumerOrder consumerOrder: supplyOrderProcessing.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}
	*/
	
	public  SupplyOrderProcessing associateConsumerOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().loadSupplyOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderProcessing.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateConsumerOrderListToApproval(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().loadSupplyOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderProcessing.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateConsumerOrderListToShipment(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().loadSupplyOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderProcessing.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateConsumerOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().loadSupplyOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: supplyOrderProcessing.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}


	protected void checkParamsForAddingSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);

		
		userContext.getChecker().checkBuyerIdOfSupplyOrder(buyerId);
		
		userContext.getChecker().checkSellerIdOfSupplyOrder(sellerId);
		
		userContext.getChecker().checkTitleOfSupplyOrder(title);
		
		userContext.getChecker().checkTotalAmountOfSupplyOrder(totalAmount);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);

	
	}
	public  SupplyOrderProcessing addSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderProcessingId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.addSupplyOrder( supplyOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderProcessingId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		userContext.getChecker().checkIdOfSupplyOrder(id);
		
		userContext.getChecker().checkTitleOfSupplyOrder( title);
		userContext.getChecker().checkTotalAmountOfSupplyOrder( totalAmount);

		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
		
	}
	public  SupplyOrderProcessing updateSupplyOrderProperties(RetailscmUserContext userContext, String supplyOrderProcessingId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSupplyOrderProperties(userContext,supplyOrderProcessingId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();
		
		SupplyOrderProcessing supplyOrderProcessingToUpdate = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		if(supplyOrderProcessingToUpdate.getSupplyOrderList().isEmpty()){
			throw new SupplyOrderProcessingManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}
		
		SupplyOrder item = supplyOrderProcessingToUpdate.getSupplyOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingSupplyOrder(userContext,supplyOrderProcessingId,name, code, used,tokensExpr);
		SupplyOrderProcessing supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessingToUpdate, tokens().withSupplyOrderList().done());
		synchronized(supplyOrderProcessing){ 
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingSupplyOrderList(RetailscmUserContext userContext, String supplyOrderProcessingId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		for(String supplyOrderId: supplyOrderIds){
			userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
		
	}
	public  SupplyOrderProcessing removeSupplyOrderList(RetailscmUserContext userContext, String supplyOrderProcessingId, 
			String supplyOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSupplyOrderList(userContext, supplyOrderProcessingId,  supplyOrderIds, tokensExpr);
			
			
			SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
			synchronized(supplyOrderProcessing){ 
				//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplyOrderProcessingDAO().planToRemoveSupplyOrderList(supplyOrderProcessing, supplyOrderIds, allTokens());
				supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, supplyOrderProcessing.getSupplyOrderList());
				return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderProcessing( supplyOrderProcessingId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
	}
	public  SupplyOrderProcessing removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderProcessingId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderProcessing.removeSupplyOrder( supplyOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplyOrderProcessing( supplyOrderProcessingId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
	}
	public  SupplyOrderProcessing copySupplyOrderFrom(RetailscmUserContext userContext, String supplyOrderProcessingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderProcessingId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, allTokens());
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			supplyOrder.updateLastUpdateTime(userContext.now());
			
			supplyOrderProcessing.copySupplyOrderFrom( supplyOrder );		
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)supplyOrderProcessing.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplyOrderProcessing(supplyOrderProcessingId);
		userContext.getChecker().checkIdOfSupplyOrder(supplyOrderId);
		userContext.getChecker().checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfSupplyOrder(parseString(newValueExpr));
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderProcessingManagerException.class);
	
	}
	
	public  SupplyOrderProcessing updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderProcessingId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();
		
		
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, loadTokens);
		
		synchronized(supplyOrderProcessing){ 
			//Will be good when the supplyOrderProcessing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderProcessing.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderProcessing.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderProcessingManagerException(supplyOrder+" is NOT FOUND" );
			}
			
			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			supplyOrderProcessing = saveSupplyOrderProcessing(userContext, supplyOrderProcessing, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderProcessing, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  SupplyOrderProcessing associateSupplyOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().createSupplyOrderConfirmation(userContext,  who,  confirmTime);
		
		for(SupplyOrder supplyOrder: supplyOrderProcessing.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateSupplyOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().createSupplyOrderApproval(userContext,  who,  approveTime);
		
		for(SupplyOrder supplyOrder: supplyOrderProcessing.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateSupplyOrderListToNewPicking(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderPicking picking = userContext.getManagerGroup().getSupplyOrderPickingManager().createSupplyOrderPicking(userContext,  who,  processTime);
		
		for(SupplyOrder supplyOrder: supplyOrderProcessing.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updatePicking(picking);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateSupplyOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().createSupplyOrderShipment(userContext,  who,  shipTime);
		
		for(SupplyOrder supplyOrder: supplyOrderProcessing.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateSupplyOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().createSupplyOrderDelivery(userContext,  who,  deliveryTime);
		
		for(SupplyOrder supplyOrder: supplyOrderProcessing.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}
	*/
	
	public  SupplyOrderProcessing associateSupplyOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().loadSupplyOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderProcessing.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateSupplyOrderListToApproval(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().loadSupplyOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderProcessing.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateApproval(approval);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateSupplyOrderListToPicking(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String pickingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderPicking picking = userContext.getManagerGroup().getSupplyOrderPickingManager().loadSupplyOrderPicking(userContext,pickingId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderProcessing.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updatePicking(picking);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateSupplyOrderListToShipment(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().loadSupplyOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderProcessing.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateShipment(shipment);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}	public  SupplyOrderProcessing associateSupplyOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "oneof", this.joinArray("|", supplyOrderIds)).done();
		
		SupplyOrderProcessing supplyOrderProcessing = loadSupplyOrderProcessing(userContext, supplyOrderProcessingId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().loadSupplyOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(SupplyOrder supplyOrder: supplyOrderProcessing.getSupplyOrderList()) {
			//TODO: need to check if already associated
			supplyOrder.updateDelivery(delivery);
		}
		return this.internalSaveSupplyOrderProcessing(userContext, supplyOrderProcessing);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderProcessing newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


