
package com.doublechaintech.retailscm.retailstore;

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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreclosing.CandidateRetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.CandidateRetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.retailstoredecoration.CandidateRetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorecreation.CandidateRetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreopening.CandidateRetailStoreOpening;
import com.doublechaintech.retailscm.retailstorecityservicecenter.CandidateRetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstorefranchising.CandidateRetailStoreFranchising;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.doublechaintech.retailscm.goodspackaging.GoodsPackaging;
import com.doublechaintech.retailscm.retailstoreordershipment.RetailStoreOrderShipment;
import com.doublechaintech.retailscm.supplyordershipment.SupplyOrderShipment;
import com.doublechaintech.retailscm.supplyorderapproval.SupplyOrderApproval;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.doublechaintech.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;






public class RetailStoreManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreManager {
	
	private static final String SERVICE_TYPE = "RetailStore";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreManagerException(message);

	}
	
	

 	protected RetailStore saveRetailStore(RetailscmUserContext userContext, RetailStore retailStore, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreDAO().save(retailStore, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStore(userContext, retailStore, tokens);
 	}
 	
 	protected RetailStore saveRetailStoreDetail(RetailscmUserContext userContext, RetailStore retailStore) throws Exception{	

 		
 		return saveRetailStore(userContext, retailStore, allTokens());
 	}
 	
 	public RetailStore loadRetailStore(RetailscmUserContext userContext, String retailStoreId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStore, tokens);
 	}
 	
 	
 	 public RetailStore searchRetailStore(RetailscmUserContext userContext, String retailStoreId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStore, tokens);
 	}
 	
 	

 	protected RetailStore present(RetailscmUserContext userContext, RetailStore retailStore, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStore,tokens);
		
		
		RetailStore  retailStoreToPresent = userContext.getDAOGroup().getRetailStoreDAO().present(retailStore, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreDAO().alias(entityListToNaming);
		
		return  retailStoreToPresent;
		
		
	}
 
 	
 	
 	public RetailStore loadRetailStoreDetail(RetailscmUserContext userContext, String retailStoreId) throws Exception{	
 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, allTokens());
 		return present(userContext,retailStore, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreId) throws Exception{	
 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, viewTokens());
 		return present(userContext,retailStore, allTokens());
		
 	}
 	protected RetailStore saveRetailStore(RetailscmUserContext userContext, RetailStore retailStore, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreDAO().save(retailStore, tokens);
 	}
 	protected RetailStore loadRetailStore(RetailscmUserContext userContext, String retailStoreId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreDAO().load(retailStoreId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStore retailStore, Map<String, Object> tokens){
		super.addActions(userContext, retailStore, tokens);
		
		addAction(userContext, retailStore, tokens,"@create","createRetailStore","createRetailStore/","main","primary");
		addAction(userContext, retailStore, tokens,"@update","updateRetailStore","updateRetailStore/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"@copy","cloneRetailStore","cloneRetailStore/"+retailStore.getId()+"/","main","primary");
		
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_retail_store_country_center","transferToAnotherRetailStoreCountryCenter","transferToAnotherRetailStoreCountryCenter/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_city_service_center","transferToAnotherCityServiceCenter","transferToAnotherCityServiceCenter/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.create","create","createActionForm/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.inviteInvestment","inviteInvestment","inviteInvestmentActionForm/"+retailStore.getId()+"/","main","success");
		addAction(userContext, retailStore, tokens,"retail_store.franchise","franchise","franchiseActionForm/"+retailStore.getId()+"/","main","success");
		addAction(userContext, retailStore, tokens,"retail_store.decorate","decorate","decorateActionForm/"+retailStore.getId()+"/","main","info");
		addAction(userContext, retailStore, tokens,"retail_store.open","open","openActionForm/"+retailStore.getId()+"/","main","success");
		addAction(userContext, retailStore, tokens,"retail_store.close","close","closeActionForm/"+retailStore.getId()+"/","main","danger");
		addAction(userContext, retailStore, tokens,"retail_store.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addGoods","addGoods","addGoods/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeGoods","removeGoods","removeGoods/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateGoods","updateGoods","updateGoods/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addTransportTask","addTransportTask","addTransportTask/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeTransportTask","removeTransportTask","removeTransportTask/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateTransportTask","updateTransportTask","updateTransportTask/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addAccountSet","addAccountSet","addAccountSet/"+retailStore.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeAccountSet","removeAccountSet","removeAccountSet/"+retailStore.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateAccountSet","updateAccountSet","updateAccountSet/"+retailStore.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyAccountSetFrom","copyAccountSetFrom","copyAccountSetFrom/"+retailStore.getId()+"/","accountSetList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStore retailStore, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStore createRetailStore(RetailscmUserContext userContext,String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfRetailStore(name);
		userContext.getChecker().checkTelephoneOfRetailStore(telephone);
		userContext.getChecker().checkOwnerOfRetailStore(owner);
		userContext.getChecker().checkFoundedOfRetailStore(founded);
		userContext.getChecker().checkLatitudeOfRetailStore(latitude);
		userContext.getChecker().checkLongitudeOfRetailStore(longitude);
		userContext.getChecker().checkDescriptionOfRetailStore(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);


		RetailStore retailStore=createNewRetailStore();	

		retailStore.setName(name);
		retailStore.setTelephone(telephone);
		retailStore.setOwner(owner);
			
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId,emptyOptions());
		retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);
		
		
			
		RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(userContext, cityServiceCenterId,emptyOptions());
		retailStore.setCityServiceCenter(cityServiceCenter);
		
		
		retailStore.setFounded(founded);
		retailStore.setLatitude(latitude);
		retailStore.setLongitude(longitude);
		retailStore.setDescription(description);
		retailStore.setLastUpdateTime(userContext.now());
		retailStore.setCurrentStatus("INIT");

		retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStore);
		return retailStore;

		
	}
	protected RetailStore createNewRetailStore() 
	{
		
		return new RetailStore();		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailscmUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore( retailStoreVersion);
		

		if(RetailStore.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStore(parseString(newValueExpr));
		}
		if(RetailStore.TELEPHONE_PROPERTY.equals(property)){
			userContext.getChecker().checkTelephoneOfRetailStore(parseString(newValueExpr));
		}
		if(RetailStore.OWNER_PROPERTY.equals(property)){
			userContext.getChecker().checkOwnerOfRetailStore(parseString(newValueExpr));
		}		

				

		
		if(RetailStore.FOUNDED_PROPERTY.equals(property)){
			userContext.getChecker().checkFoundedOfRetailStore(parseDate(newValueExpr));
		}
		if(RetailStore.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfRetailStore(parseBigDecimal(newValueExpr));
		}
		if(RetailStore.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfRetailStore(parseBigDecimal(newValueExpr));
		}
		if(RetailStore.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfRetailStore(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
		
	}
	
	
	
	public RetailStore clone(RetailscmUserContext userContext, String fromRetailStoreId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreDAO().clone(fromRetailStoreId, this.allTokens());
	}
	
	public RetailStore internalSaveRetailStore(RetailscmUserContext userContext, RetailStore retailStore) throws Exception 
	{
		return internalSaveRetailStore(userContext, retailStore, allTokens());

	}
	public RetailStore internalSaveRetailStore(RetailscmUserContext userContext, RetailStore retailStore, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStore(userContext, retailStoreId, retailStoreVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStore){ 
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStore.
			
			
			retailStore = saveRetailStore(userContext, retailStore, options);
			return retailStore;
			
		}

	}
	
	public RetailStore updateRetailStore(RetailscmUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStore(userContext, retailStoreId, retailStoreVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		if(retailStore.getVersion() != retailStoreVersion){
			String message = "The target version("+retailStore.getVersion()+") is not equals to version("+retailStoreVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStore){ 
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStore.
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore.changeProperty(property, newValueExpr);
			retailStore = saveRetailStore(userContext, retailStore, tokens().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			//return saveRetailStore(userContext, retailStore, tokens().done());
		}

	}
	
	public RetailStore updateRetailStoreProperty(RetailscmUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStore(userContext, retailStoreId, retailStoreVersion, property, newValueExpr, tokensExpr);
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		if(retailStore.getVersion() != retailStoreVersion){
			String message = "The target version("+retailStore.getVersion()+") is not equals to version("+retailStoreVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStore){ 
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStore.
			
			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, tokens().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			//return saveRetailStore(userContext, retailStore, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreTokens tokens(){
		return RetailStoreTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortRetailStoreOrderListWith("id","desc")
		.sortGoodsListWith("id","desc")
		.sortTransportTaskListWith("id","desc")
		.sortAccountSetListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreTokens.mergeAll(tokens).done();
	}
	
	private static final String [] STATUS_SEQUENCE={"CREATED","INVESTMENT_INVITED","FRANCHISED","DECORATED","OPENNED","CLOSED"};
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
 	protected void ensureStatus(RetailscmUserContext userContext, RetailStore retailStore, String expectedNextStatus) throws Exception{
		String currentStatus = retailStore.getCurrentStatus();
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
	
	protected void checkParamsForTransferingAnotherRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreId, String anotherRetailStoreCountryCenterId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherRetailStoreCountryCenterId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
 		
 	}
 	public RetailStore transferToAnotherRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreId, String anotherRetailStoreCountryCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherRetailStoreCountryCenter(userContext, retailStoreId,anotherRetailStoreCountryCenterId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, anotherRetailStoreCountryCenterId, emptyOptions());		
			retailStore.updateRetailStoreCountryCenter(retailStoreCountryCenter);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateRetailStoreCountryCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherCityServiceCenter(RetailscmUserContext userContext, String retailStoreId, String anotherCityServiceCenterId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
 		userContext.getChecker().checkIdOfRetailStoreCityServiceCenter(anotherCityServiceCenterId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
 		
 	}
 	public RetailStore transferToAnotherCityServiceCenter(RetailscmUserContext userContext, String retailStoreId, String anotherCityServiceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityServiceCenter(userContext, retailStoreId,anotherCityServiceCenterId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(userContext, anotherCityServiceCenterId, emptyOptions());		
			retailStore.updateCityServiceCenter(cityServiceCenter);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCityServiceCenter requestCandidateCityServiceCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCityServiceCenter result = new CandidateRetailStoreCityServiceCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCityServiceCenter> candidateList = userContext.getDAOGroup().getRetailStoreCityServiceCenterDAO().requestCandidateRetailStoreCityServiceCenterForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherCreation(RetailscmUserContext userContext, String retailStoreId, String anotherCreationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
 		userContext.getChecker().checkIdOfRetailStoreCreation(anotherCreationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
 		
 	}
 	public RetailStore transferToAnotherCreation(RetailscmUserContext userContext, String retailStoreId, String anotherCreationId) throws Exception
 	{
 		checkParamsForTransferingAnotherCreation(userContext, retailStoreId,anotherCreationId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCreation creation = loadRetailStoreCreation(userContext, anotherCreationId, emptyOptions());		
			retailStore.updateCreation(creation);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCreation requestCandidateCreation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCreation result = new CandidateRetailStoreCreation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCreation> candidateList = userContext.getDAOGroup().getRetailStoreCreationDAO().requestCandidateRetailStoreCreationForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String CREATED_STATUS = "CREATED";
 	protected void checkParamsForCreation(RetailscmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
 				userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkCommentOfRetailStoreCreation(comment);

	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore create(RetailscmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
		checkParamsForCreation(userContext, retailStoreId, comment);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForCreation(userContext,retailStore);
 		

			retailStore.updateCurrentStatus(CREATED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreCreation creation = createCreation(userContext, comment);		
			retailStore.updateCreation(creation);		
			
			
			retailStore = saveRetailStore(userContext, retailStore, tokens().withCreation().done());
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public RetailStoreForm createActionForm(RetailscmUserContext userContext, String retailStoreId) throws Exception
 	{
		return new RetailStoreForm()
			.withTitle("create")
			.retailStoreIdField(retailStoreId)
			.commentFieldOfRetailStoreCreation()
			.createAction();
 	}
	
 	
 	protected RetailStoreCreation createCreation(RetailscmUserContext userContext, String comment){
 		RetailStoreCreation creation = new RetailStoreCreation();
 		//comment
 		
		creation.setComment(comment);

 		
 		
 		
 		return userContext.getDAOGroup().getRetailStoreCreationDAO().save(creation,emptyOptions());
 	}
 	protected void checkIfEligibleForCreation(RetailscmUserContext userContext, RetailStore retailStore) throws Exception{
 
 		ensureStatus(userContext,retailStore, CREATED_STATUS);
 		
 		RetailStoreCreation creation = retailStore.getCreation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = creation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( creation != null){
				throwExceptionWithMessage("The RetailStore("+retailStore.getId()+") has already been "+ CREATED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherInvestmentInvitation(RetailscmUserContext userContext, String retailStoreId, String anotherInvestmentInvitationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
 		userContext.getChecker().checkIdOfRetailStoreInvestmentInvitation(anotherInvestmentInvitationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
 		
 	}
 	public RetailStore transferToAnotherInvestmentInvitation(RetailscmUserContext userContext, String retailStoreId, String anotherInvestmentInvitationId) throws Exception
 	{
 		checkParamsForTransferingAnotherInvestmentInvitation(userContext, retailStoreId,anotherInvestmentInvitationId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreInvestmentInvitation investmentInvitation = loadRetailStoreInvestmentInvitation(userContext, anotherInvestmentInvitationId, emptyOptions());		
			retailStore.updateInvestmentInvitation(investmentInvitation);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreInvestmentInvitation requestCandidateInvestmentInvitation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreInvestmentInvitation result = new CandidateRetailStoreInvestmentInvitation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreInvestmentInvitation> candidateList = userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().requestCandidateRetailStoreInvestmentInvitationForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String INVESTMENT_INVITED_STATUS = "INVESTMENT_INVITED";
 	protected void checkParamsForInvestmentInvitation(RetailscmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
 				userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkCommentOfRetailStoreInvestmentInvitation(comment);

	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore inviteInvestment(RetailscmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
		checkParamsForInvestmentInvitation(userContext, retailStoreId, comment);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForInvestmentInvitation(userContext,retailStore);
 		

			retailStore.updateCurrentStatus(INVESTMENT_INVITED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreInvestmentInvitation investmentInvitation = createInvestmentInvitation(userContext, comment);		
			retailStore.updateInvestmentInvitation(investmentInvitation);		
			
			
			retailStore = saveRetailStore(userContext, retailStore, tokens().withInvestmentInvitation().done());
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public RetailStoreForm inviteInvestmentActionForm(RetailscmUserContext userContext, String retailStoreId) throws Exception
 	{
		return new RetailStoreForm()
			.withTitle("inviteInvestment")
			.retailStoreIdField(retailStoreId)
			.commentFieldOfRetailStoreInvestmentInvitation()
			.inviteInvestmentAction();
 	}
	
 	
 	protected RetailStoreInvestmentInvitation createInvestmentInvitation(RetailscmUserContext userContext, String comment){
 		RetailStoreInvestmentInvitation investmentInvitation = new RetailStoreInvestmentInvitation();
 		//comment
 		
		investmentInvitation.setComment(comment);

 		
 		
 		
 		return userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().save(investmentInvitation,emptyOptions());
 	}
 	protected void checkIfEligibleForInvestmentInvitation(RetailscmUserContext userContext, RetailStore retailStore) throws Exception{
 
 		ensureStatus(userContext,retailStore, INVESTMENT_INVITED_STATUS);
 		
 		RetailStoreInvestmentInvitation investmentInvitation = retailStore.getInvestmentInvitation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = investmentInvitation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( investmentInvitation != null){
				throwExceptionWithMessage("The RetailStore("+retailStore.getId()+") has already been "+ INVESTMENT_INVITED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherFranchising(RetailscmUserContext userContext, String retailStoreId, String anotherFranchisingId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
 		userContext.getChecker().checkIdOfRetailStoreFranchising(anotherFranchisingId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
 		
 	}
 	public RetailStore transferToAnotherFranchising(RetailscmUserContext userContext, String retailStoreId, String anotherFranchisingId) throws Exception
 	{
 		checkParamsForTransferingAnotherFranchising(userContext, retailStoreId,anotherFranchisingId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreFranchising franchising = loadRetailStoreFranchising(userContext, anotherFranchisingId, emptyOptions());		
			retailStore.updateFranchising(franchising);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreFranchising requestCandidateFranchising(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreFranchising result = new CandidateRetailStoreFranchising();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreFranchising> candidateList = userContext.getDAOGroup().getRetailStoreFranchisingDAO().requestCandidateRetailStoreFranchisingForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String FRANCHISED_STATUS = "FRANCHISED";
 	protected void checkParamsForFranchising(RetailscmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
 				userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkCommentOfRetailStoreFranchising(comment);

	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore franchise(RetailscmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
		checkParamsForFranchising(userContext, retailStoreId, comment);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForFranchising(userContext,retailStore);
 		

			retailStore.updateCurrentStatus(FRANCHISED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreFranchising franchising = createFranchising(userContext, comment);		
			retailStore.updateFranchising(franchising);		
			
			
			retailStore = saveRetailStore(userContext, retailStore, tokens().withFranchising().done());
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public RetailStoreForm franchiseActionForm(RetailscmUserContext userContext, String retailStoreId) throws Exception
 	{
		return new RetailStoreForm()
			.withTitle("franchise")
			.retailStoreIdField(retailStoreId)
			.commentFieldOfRetailStoreFranchising()
			.franchiseAction();
 	}
	
 	
 	protected RetailStoreFranchising createFranchising(RetailscmUserContext userContext, String comment){
 		RetailStoreFranchising franchising = new RetailStoreFranchising();
 		//comment
 		
		franchising.setComment(comment);

 		
 		
 		
 		return userContext.getDAOGroup().getRetailStoreFranchisingDAO().save(franchising,emptyOptions());
 	}
 	protected void checkIfEligibleForFranchising(RetailscmUserContext userContext, RetailStore retailStore) throws Exception{
 
 		ensureStatus(userContext,retailStore, FRANCHISED_STATUS);
 		
 		RetailStoreFranchising franchising = retailStore.getFranchising();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = franchising 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( franchising != null){
				throwExceptionWithMessage("The RetailStore("+retailStore.getId()+") has already been "+ FRANCHISED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherDecoration(RetailscmUserContext userContext, String retailStoreId, String anotherDecorationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
 		userContext.getChecker().checkIdOfRetailStoreDecoration(anotherDecorationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
 		
 	}
 	public RetailStore transferToAnotherDecoration(RetailscmUserContext userContext, String retailStoreId, String anotherDecorationId) throws Exception
 	{
 		checkParamsForTransferingAnotherDecoration(userContext, retailStoreId,anotherDecorationId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreDecoration decoration = loadRetailStoreDecoration(userContext, anotherDecorationId, emptyOptions());		
			retailStore.updateDecoration(decoration);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreDecoration requestCandidateDecoration(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreDecoration result = new CandidateRetailStoreDecoration();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreDecoration> candidateList = userContext.getDAOGroup().getRetailStoreDecorationDAO().requestCandidateRetailStoreDecorationForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String DECORATED_STATUS = "DECORATED";
 	protected void checkParamsForDecoration(RetailscmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
 				userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkCommentOfRetailStoreDecoration(comment);

	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore decorate(RetailscmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
		checkParamsForDecoration(userContext, retailStoreId, comment);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForDecoration(userContext,retailStore);
 		

			retailStore.updateCurrentStatus(DECORATED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreDecoration decoration = createDecoration(userContext, comment);		
			retailStore.updateDecoration(decoration);		
			
			
			retailStore = saveRetailStore(userContext, retailStore, tokens().withDecoration().done());
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public RetailStoreForm decorateActionForm(RetailscmUserContext userContext, String retailStoreId) throws Exception
 	{
		return new RetailStoreForm()
			.withTitle("decorate")
			.retailStoreIdField(retailStoreId)
			.commentFieldOfRetailStoreDecoration()
			.decorateAction();
 	}
	
 	
 	protected RetailStoreDecoration createDecoration(RetailscmUserContext userContext, String comment){
 		RetailStoreDecoration decoration = new RetailStoreDecoration();
 		//comment
 		
		decoration.setComment(comment);

 		
 		
 		
 		return userContext.getDAOGroup().getRetailStoreDecorationDAO().save(decoration,emptyOptions());
 	}
 	protected void checkIfEligibleForDecoration(RetailscmUserContext userContext, RetailStore retailStore) throws Exception{
 
 		ensureStatus(userContext,retailStore, DECORATED_STATUS);
 		
 		RetailStoreDecoration decoration = retailStore.getDecoration();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = decoration 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( decoration != null){
				throwExceptionWithMessage("The RetailStore("+retailStore.getId()+") has already been "+ DECORATED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherOpening(RetailscmUserContext userContext, String retailStoreId, String anotherOpeningId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
 		userContext.getChecker().checkIdOfRetailStoreOpening(anotherOpeningId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
 		
 	}
 	public RetailStore transferToAnotherOpening(RetailscmUserContext userContext, String retailStoreId, String anotherOpeningId) throws Exception
 	{
 		checkParamsForTransferingAnotherOpening(userContext, retailStoreId,anotherOpeningId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOpening opening = loadRetailStoreOpening(userContext, anotherOpeningId, emptyOptions());		
			retailStore.updateOpening(opening);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreOpening requestCandidateOpening(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOpening result = new CandidateRetailStoreOpening();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOpening> candidateList = userContext.getDAOGroup().getRetailStoreOpeningDAO().requestCandidateRetailStoreOpeningForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String OPENNED_STATUS = "OPENNED";
 	protected void checkParamsForOpening(RetailscmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
 				userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkCommentOfRetailStoreOpening(comment);

	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore open(RetailscmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
		checkParamsForOpening(userContext, retailStoreId, comment);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForOpening(userContext,retailStore);
 		

			retailStore.updateCurrentStatus(OPENNED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOpening opening = createOpening(userContext, comment);		
			retailStore.updateOpening(opening);		
			
			
			retailStore = saveRetailStore(userContext, retailStore, tokens().withOpening().done());
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public RetailStoreForm openActionForm(RetailscmUserContext userContext, String retailStoreId) throws Exception
 	{
		return new RetailStoreForm()
			.withTitle("open")
			.retailStoreIdField(retailStoreId)
			.commentFieldOfRetailStoreOpening()
			.openAction();
 	}
	
 	
 	protected RetailStoreOpening createOpening(RetailscmUserContext userContext, String comment){
 		RetailStoreOpening opening = new RetailStoreOpening();
 		//comment
 		
		opening.setComment(comment);

 		
 		
 		
 		return userContext.getDAOGroup().getRetailStoreOpeningDAO().save(opening,emptyOptions());
 	}
 	protected void checkIfEligibleForOpening(RetailscmUserContext userContext, RetailStore retailStore) throws Exception{
 
 		ensureStatus(userContext,retailStore, OPENNED_STATUS);
 		
 		RetailStoreOpening opening = retailStore.getOpening();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = opening 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( opening != null){
				throwExceptionWithMessage("The RetailStore("+retailStore.getId()+") has already been "+ OPENNED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherClosing(RetailscmUserContext userContext, String retailStoreId, String anotherClosingId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
 		userContext.getChecker().checkIdOfRetailStoreClosing(anotherClosingId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
 		
 	}
 	public RetailStore transferToAnotherClosing(RetailscmUserContext userContext, String retailStoreId, String anotherClosingId) throws Exception
 	{
 		checkParamsForTransferingAnotherClosing(userContext, retailStoreId,anotherClosingId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreClosing closing = loadRetailStoreClosing(userContext, anotherClosingId, emptyOptions());		
			retailStore.updateClosing(closing);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreClosing requestCandidateClosing(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreClosing result = new CandidateRetailStoreClosing();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreClosing> candidateList = userContext.getDAOGroup().getRetailStoreClosingDAO().requestCandidateRetailStoreClosingForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String CLOSED_STATUS = "CLOSED";
 	protected void checkParamsForClosing(RetailscmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
 				userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkCommentOfRetailStoreClosing(comment);

	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore close(RetailscmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
		checkParamsForClosing(userContext, retailStoreId, comment);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForClosing(userContext,retailStore);
 		

			retailStore.updateCurrentStatus(CLOSED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreClosing closing = createClosing(userContext, comment);		
			retailStore.updateClosing(closing);		
			
			
			retailStore = saveRetailStore(userContext, retailStore, tokens().withClosing().done());
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public RetailStoreForm closeActionForm(RetailscmUserContext userContext, String retailStoreId) throws Exception
 	{
		return new RetailStoreForm()
			.withTitle("close")
			.retailStoreIdField(retailStoreId)
			.commentFieldOfRetailStoreClosing()
			.closeAction();
 	}
	
 	
 	protected RetailStoreClosing createClosing(RetailscmUserContext userContext, String comment){
 		RetailStoreClosing closing = new RetailStoreClosing();
 		//comment
 		
		closing.setComment(comment);

 		
 		
 		
 		return userContext.getDAOGroup().getRetailStoreClosingDAO().save(closing,emptyOptions());
 	}
 	protected void checkIfEligibleForClosing(RetailscmUserContext userContext, RetailStore retailStore) throws Exception{
 
 		ensureStatus(userContext,retailStore, CLOSED_STATUS);
 		
 		RetailStoreClosing closing = retailStore.getClosing();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = closing 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( closing != null){
				throwExceptionWithMessage("The RetailStore("+retailStore.getId()+") has already been "+ CLOSED_STATUS+".");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newRetailStoreCountryCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newRetailStoreCountryCenterId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreFranchising loadRetailStoreFranchising(RetailscmUserContext userContext, String newFranchisingId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreFranchisingDAO().load(newFranchisingId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreDecoration loadRetailStoreDecoration(RetailscmUserContext userContext, String newDecorationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreDecorationDAO().load(newDecorationId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreClosing loadRetailStoreClosing(RetailscmUserContext userContext, String newClosingId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreClosingDAO().load(newClosingId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreCreation loadRetailStoreCreation(RetailscmUserContext userContext, String newCreationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCreationDAO().load(newCreationId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(RetailscmUserContext userContext, String newCityServiceCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCityServiceCenterDAO().load(newCityServiceCenterId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String newInvestmentInvitationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().load(newInvestmentInvitationId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreOpening loadRetailStoreOpening(RetailscmUserContext userContext, String newOpeningId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreOpeningDAO().load(newOpeningId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreId, int retailStoreVersion) throws Exception {
		//deleteInternal(userContext, retailStoreId, retailStoreVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreId, int retailStoreVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreDAO().delete(retailStoreId, retailStoreVersion);
	}
	
	public RetailStore forgetByAll(RetailscmUserContext userContext, String retailStoreId, int retailStoreVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreId, retailStoreVersion);		
	}
	protected RetailStore forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreId, int retailStoreVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreDAO().disconnectFromAll(retailStoreId, retailStoreVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreDAO().deleteAll();
	}


	//disconnect RetailStore with consumer in ConsumerOrder
	protected RetailStore breakWithConsumerOrderByConsumer(RetailscmUserContext userContext, String retailStoreId, String consumerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveConsumerOrderListWithConsumer(retailStore, consumerId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with seller in RetailStoreOrder
	protected RetailStore breakWithRetailStoreOrderBySeller(RetailscmUserContext userContext, String retailStoreId, String sellerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveRetailStoreOrderListWithSeller(retailStore, sellerId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with sku in Goods
	protected RetailStore breakWithGoodsBySku(RetailscmUserContext userContext, String retailStoreId, String skuId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveGoodsListWithSku(retailStore, skuId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with receiving_space in Goods
	protected RetailStore breakWithGoodsByReceivingSpace(RetailscmUserContext userContext, String retailStoreId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveGoodsListWithReceivingSpace(retailStore, receivingSpaceId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with goods_allocation in Goods
	protected RetailStore breakWithGoodsByGoodsAllocation(RetailscmUserContext userContext, String retailStoreId, String goodsAllocationId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveGoodsListWithGoodsAllocation(retailStore, goodsAllocationId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with smart_pallet in Goods
	protected RetailStore breakWithGoodsBySmartPallet(RetailscmUserContext userContext, String retailStoreId, String smartPalletId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveGoodsListWithSmartPallet(retailStore, smartPalletId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with shipping_space in Goods
	protected RetailStore breakWithGoodsByShippingSpace(RetailscmUserContext userContext, String retailStoreId, String shippingSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveGoodsListWithShippingSpace(retailStore, shippingSpaceId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with transport_task in Goods
	protected RetailStore breakWithGoodsByTransportTask(RetailscmUserContext userContext, String retailStoreId, String transportTaskId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveGoodsListWithTransportTask(retailStore, transportTaskId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with biz_order in Goods
	protected RetailStore breakWithGoodsByBizOrder(RetailscmUserContext userContext, String retailStoreId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveGoodsListWithBizOrder(retailStore, bizOrderId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with retail_store_order in Goods
	protected RetailStore breakWithGoodsByRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, String retailStoreOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveGoodsListWithRetailStoreOrder(retailStore, retailStoreOrderId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with driver in TransportTask
	protected RetailStore breakWithTransportTaskByDriver(RetailscmUserContext userContext, String retailStoreId, String driverId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveTransportTaskListWithDriver(retailStore, driverId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with truck in TransportTask
	protected RetailStore breakWithTransportTaskByTruck(RetailscmUserContext userContext, String retailStoreId, String truckId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveTransportTaskListWithTruck(retailStore, truckId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with belongs_to in TransportTask
	protected RetailStore breakWithTransportTaskByBelongsTo(RetailscmUserContext userContext, String retailStoreId, String belongsToId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveTransportTaskListWithBelongsTo(retailStore, belongsToId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with country_center in AccountSet
	protected RetailStore breakWithAccountSetByCountryCenter(RetailscmUserContext userContext, String retailStoreId, String countryCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveAccountSetListWithCountryCenter(retailStore, countryCenterId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
				return retailStore;
			}
	}
	//disconnect RetailStore with goods_supplier in AccountSet
	protected RetailStore breakWithAccountSetByGoodsSupplier(RetailscmUserContext userContext, String retailStoreId, String goodsSupplierId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());

			synchronized(retailStore){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveAccountSetListWithGoodsSupplier(retailStore, goodsSupplierId, this.emptyOptions());

				retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
				return retailStore;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingConsumerOrder(RetailscmUserContext userContext, String retailStoreId, String title, String consumerId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);

		
		userContext.getChecker().checkTitleOfConsumerOrder(title);
		
		userContext.getChecker().checkConsumerIdOfConsumerOrder(consumerId);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);

	
	}
	public  RetailStore addConsumerOrder(RetailscmUserContext userContext, String retailStoreId, String title, String consumerId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,retailStoreId,title, consumerId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId);
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addConsumerOrder( consumerOrder );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(RetailscmUserContext userContext, String retailStoreId,String id,String title,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkIdOfConsumerOrder(id);
		
		userContext.getChecker().checkTitleOfConsumerOrder( title);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
		
	}
	public  RetailStore updateConsumerOrderProperties(RetailscmUserContext userContext, String retailStoreId, String id,String title, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingConsumerOrderProperties(userContext,retailStoreId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();
		
		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);
		
		if(retailStoreToUpdate.getConsumerOrderList().isEmpty()){
			throw new RetailStoreManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}
		
		ConsumerOrder item = retailStoreToUpdate.getConsumerOrderList().first();
		
		item.updateTitle( title );

		
		//checkParamsForAddingConsumerOrder(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withConsumerOrderList().done());
		synchronized(retailStore){ 
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ConsumerOrder createConsumerOrder(RetailscmUserContext userContext, String title, String consumerId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStoreMember  consumer = new RetailStoreMember();
		consumer.setId(consumerId);		
		consumerOrder.setConsumer(consumer);		
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
	
	protected void checkParamsForRemovingConsumerOrderList(RetailscmUserContext userContext, String retailStoreId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		for(String consumerOrderId: consumerOrderIds){
			userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
		
	}
	public  RetailStore removeConsumerOrderList(RetailscmUserContext userContext, String retailStoreId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingConsumerOrderList(userContext, retailStoreId,  consumerOrderIds, tokensExpr);
			
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){ 
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveConsumerOrderList(retailStore, consumerOrderIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, retailStore.getConsumerOrderList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingConsumerOrder(RetailscmUserContext userContext, String retailStoreId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStore( retailStoreId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	public  RetailStore removeConsumerOrder(RetailscmUserContext userContext, String retailStoreId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,retailStoreId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeConsumerOrder( consumerOrder );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailscmUserContext userContext, String retailStoreId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStore( retailStoreId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	public  RetailStore copyConsumerOrderFrom(RetailscmUserContext userContext, String retailStoreId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,retailStoreId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			consumerOrder.updateLastUpdateTime(userContext.now());
			
			retailStore.copyConsumerOrderFrom( consumerOrder );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailscmUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfConsumerOrder(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	
	public  RetailStore updateConsumerOrder(RetailscmUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, retailStoreId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();
		
		
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);
		
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = retailStore.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new RetailStoreManagerException(consumerOrder+" is NOT FOUND" );
			}
			
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStore associateConsumerOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().createSupplyOrderConfirmation(userContext,  who,  confirmTime);
		
		for(ConsumerOrder consumerOrder: retailStore.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateConsumerOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().createSupplyOrderApproval(userContext,  who,  approveTime);
		
		for(ConsumerOrder consumerOrder: retailStore.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateApproval(approval);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateConsumerOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().createSupplyOrderProcessing(userContext,  who,  processTime);
		
		for(ConsumerOrder consumerOrder: retailStore.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateProcessing(processing);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateConsumerOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().createSupplyOrderShipment(userContext,  who,  shipTime);
		
		for(ConsumerOrder consumerOrder: retailStore.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateConsumerOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().createSupplyOrderDelivery(userContext,  who,  deliveryTime);
		
		for(ConsumerOrder consumerOrder: retailStore.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateDelivery(delivery);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}
	*/
	
	public  RetailStore associateConsumerOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().loadSupplyOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: retailStore.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateConsumerOrderListToApproval(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().loadSupplyOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: retailStore.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateApproval(approval);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateConsumerOrderListToProcessing(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().loadSupplyOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: retailStore.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateProcessing(processing);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateConsumerOrderListToShipment(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().loadSupplyOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: retailStore.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateConsumerOrderListToDelivery(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().loadSupplyOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: retailStore.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateDelivery(delivery);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}


	protected void checkParamsForAddingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, String sellerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);

		
		userContext.getChecker().checkSellerIdOfRetailStoreOrder(sellerId);
		
		userContext.getChecker().checkTitleOfRetailStoreOrder(title);
		
		userContext.getChecker().checkTotalAmountOfRetailStoreOrder(totalAmount);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);

	
	}
	public  RetailStore addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, String sellerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreId,sellerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,sellerId, title, totalAmount);
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addRetailStoreOrder( retailStoreOrder );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, retailStoreOrder);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkIdOfRetailStoreOrder(id);
		
		userContext.getChecker().checkTitleOfRetailStoreOrder( title);
		userContext.getChecker().checkTotalAmountOfRetailStoreOrder( totalAmount);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
		
	}
	public  RetailStore updateRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreOrderProperties(userContext,retailStoreId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderListList()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "is", id).done();
		
		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);
		
		if(retailStoreToUpdate.getRetailStoreOrderList().isEmpty()){
			throw new RetailStoreManagerException("RetailStoreOrder is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreOrder item = retailStoreToUpdate.getRetailStoreOrderList().first();
		
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );

		
		//checkParamsForAddingRetailStoreOrder(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withRetailStoreOrderList().done());
		synchronized(retailStore){ 
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RetailStoreOrder createRetailStoreOrder(RetailscmUserContext userContext, String sellerId, String title, BigDecimal totalAmount) throws Exception{

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		
		
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
	
	protected void checkParamsForRemovingRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreId, 
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		for(String retailStoreOrderId: retailStoreOrderIds){
			userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
		
	}
	public  RetailStore removeRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreId, 
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreOrderList(userContext, retailStoreId,  retailStoreOrderIds, tokensExpr);
			
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){ 
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveRetailStoreOrderList(retailStore, retailStoreOrderIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
				deleteRelationListInGraph(userContext, retailStore.getRetailStoreOrderList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStore( retailStoreId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	public  RetailStore removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeRetailStoreOrder( retailStoreOrder );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			deleteRelationInGraph(userContext, retailStoreOrder);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStore( retailStoreId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	public  RetailStore copyRetailStoreOrderFrom(RetailscmUserContext userContext, String retailStoreId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			
			retailStore.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, (RetailStoreOrder)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkIdOfRetailStoreOrder(retailStoreOrderId);
		userContext.getChecker().checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	
	public  RetailStore updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderList().searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "eq", retailStoreOrderId).done();
		
		
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);
		
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStore.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreManagerException(retailStoreOrder+" is NOT FOUND" );
			}
			
			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStore associateRetailStoreOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		RetailStoreOrderConfirmation confirmation = userContext.getManagerGroup().getRetailStoreOrderConfirmationManager().createRetailStoreOrderConfirmation(userContext,  who,  confirmTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStore.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateRetailStoreOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		RetailStoreOrderApproval approval = userContext.getManagerGroup().getRetailStoreOrderApprovalManager().createRetailStoreOrderApproval(userContext,  who,  approveTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStore.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateApproval(approval);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateRetailStoreOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		RetailStoreOrderProcessing processing = userContext.getManagerGroup().getRetailStoreOrderProcessingManager().createRetailStoreOrderProcessing(userContext,  who,  processTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStore.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateProcessing(processing);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateRetailStoreOrderListToNewPicking(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		RetailStoreOrderPicking picking = userContext.getManagerGroup().getRetailStoreOrderPickingManager().createRetailStoreOrderPicking(userContext,  who,  processTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStore.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updatePicking(picking);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateRetailStoreOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		RetailStoreOrderShipment shipment = userContext.getManagerGroup().getRetailStoreOrderShipmentManager().createRetailStoreOrderShipment(userContext,  who,  shipTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStore.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateRetailStoreOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		RetailStoreOrderDelivery delivery = userContext.getManagerGroup().getRetailStoreOrderDeliveryManager().createRetailStoreOrderDelivery(userContext,  who,  deliveryTime);
		
		for(RetailStoreOrder retailStoreOrder: retailStore.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateDelivery(delivery);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}
	*/
	
	public  RetailStore associateRetailStoreOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		RetailStoreOrderConfirmation confirmation = userContext.getManagerGroup().getRetailStoreOrderConfirmationManager().loadRetailStoreOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStore.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateRetailStoreOrderListToApproval(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		RetailStoreOrderApproval approval = userContext.getManagerGroup().getRetailStoreOrderApprovalManager().loadRetailStoreOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStore.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateApproval(approval);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateRetailStoreOrderListToProcessing(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		RetailStoreOrderProcessing processing = userContext.getManagerGroup().getRetailStoreOrderProcessingManager().loadRetailStoreOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStore.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateProcessing(processing);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateRetailStoreOrderListToPicking(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String pickingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		RetailStoreOrderPicking picking = userContext.getManagerGroup().getRetailStoreOrderPickingManager().loadRetailStoreOrderPicking(userContext,pickingId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStore.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updatePicking(picking);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateRetailStoreOrderListToShipment(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		RetailStoreOrderShipment shipment = userContext.getManagerGroup().getRetailStoreOrderShipmentManager().loadRetailStoreOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStore.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}	public  RetailStore associateRetailStoreOrderListToDelivery(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreOrderIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		RetailStoreOrderDelivery delivery = userContext.getManagerGroup().getRetailStoreOrderDeliveryManager().loadRetailStoreOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(RetailStoreOrder retailStoreOrder: retailStore.getRetailStoreOrderList()) {
			//TODO: need to check if already associated
			retailStoreOrder.updateDelivery(delivery);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}


	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);

		
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
		
		userContext.getChecker().checkBizOrderIdOfGoods(bizOrderId);
		
		userContext.getChecker().checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);

	
	}
	public  RetailStore addGoods(RetailscmUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,retailStoreId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, bizOrderId, retailStoreOrderId);
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addGoods( goods );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, goods);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String retailStoreId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkIdOfGoods(id);
		
		userContext.getChecker().checkNameOfGoods( name);
		userContext.getChecker().checkRfidOfGoods( rfid);
		userContext.getChecker().checkUomOfGoods( uom);
		userContext.getChecker().checkMaxPackageOfGoods( maxPackage);
		userContext.getChecker().checkExpireTimeOfGoods( expireTime);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
		
	}
	public  RetailStore updateGoodsProperties(RetailscmUserContext userContext, String retailStoreId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGoodsProperties(userContext,retailStoreId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, "is", id).done();
		
		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);
		
		if(retailStoreToUpdate.getGoodsList().isEmpty()){
			throw new RetailStoreManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}
		
		Goods item = retailStoreToUpdate.getGoodsList().first();
		
		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );

		
		//checkParamsForAddingGoods(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withGoodsList().done());
		synchronized(retailStore){ 
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Goods createGoods(RetailscmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId) throws Exception{

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
		SupplyOrder  bizOrder = new SupplyOrder();
		bizOrder.setId(bizOrderId);		
		goods.setBizOrder(bizOrder);		
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
	
	protected void checkParamsForRemovingGoodsList(RetailscmUserContext userContext, String retailStoreId, 
			String goodsIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		for(String goodsId: goodsIds){
			userContext.getChecker().checkIdOfGoods(goodsId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
		
	}
	public  RetailStore removeGoodsList(RetailscmUserContext userContext, String retailStoreId, 
			String goodsIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGoodsList(userContext, retailStoreId,  goodsIds, tokensExpr);
			
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){ 
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveGoodsList(retailStore, goodsIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, retailStore.getGoodsList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String retailStoreId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStore( retailStoreId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	public  RetailStore removeGoods(RetailscmUserContext userContext, String retailStoreId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,retailStoreId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeGoods( goods );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGoods(RetailscmUserContext userContext, String retailStoreId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStore( retailStoreId);
		userContext.getChecker().checkIdOfGoods(goodsId);
		userContext.getChecker().checkVersionOfGoods(goodsVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	public  RetailStore copyGoodsFrom(RetailscmUserContext userContext, String retailStoreId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,retailStoreId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStore.copyGoodsFrom( goods );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			
			userContext.getManagerGroup().getGoodsManager().onNewInstanceCreated(userContext, (Goods)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String retailStoreId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	
	public  RetailStore updateGoods(RetailscmUserContext userContext, String retailStoreId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, retailStoreId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, "eq", goodsId).done();
		
		
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);
		
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = retailStore.findTheGoods(goodsIndex);
			if(goods == null){
				throw new RetailStoreManagerException(goods+" is NOT FOUND" );
			}
			
			goods.changeProperty(property, newValueExpr);
			
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStore associateGoodsListToNewPackaging(RetailscmUserContext userContext, String retailStoreId, String  goodsIds[], String packageName, String rfid, Date packageTime, String description, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().createGoodsPackaging(userContext,  packageName,  rfid,  packageTime,  description);
		
		for(Goods goods: retailStore.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}
	*/
	
	public  RetailStore associateGoodsListToPackaging(RetailscmUserContext userContext, String retailStoreId, String  goodsIds[], String packagingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchGoodsListWith(Goods.ID_PROPERTY, "oneof", this.joinArray("|", goodsIds)).done();
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, options);
		
		GoodsPackaging packaging = userContext.getManagerGroup().getGoodsPackagingManager().loadGoodsPackaging(userContext,packagingId,new String[]{"none"} );
		
		for(Goods goods: retailStore.getGoodsList()) {
			//TODO: need to check if already associated
			goods.updatePackaging(packaging);
		}
		return this.internalSaveRetailStore(userContext, retailStore);
	}


	protected void checkParamsForAddingTransportTask(RetailscmUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);

		
		userContext.getChecker().checkNameOfTransportTask(name);
		
		userContext.getChecker().checkStartOfTransportTask(start);
		
		userContext.getChecker().checkBeginTimeOfTransportTask(beginTime);
		
		userContext.getChecker().checkDriverIdOfTransportTask(driverId);
		
		userContext.getChecker().checkTruckIdOfTransportTask(truckId);
		
		userContext.getChecker().checkBelongsToIdOfTransportTask(belongsToId);
		
		userContext.getChecker().checkLatitudeOfTransportTask(latitude);
		
		userContext.getChecker().checkLongitudeOfTransportTask(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);

	
	}
	public  RetailStore addTransportTask(RetailscmUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTask(userContext,retailStoreId,name, start, beginTime, driverId, truckId, belongsToId, latitude, longitude,tokensExpr);
		
		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, driverId, truckId, belongsToId, latitude, longitude);
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addTransportTask( transportTask );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskProperties(RetailscmUserContext userContext, String retailStoreId,String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkIdOfTransportTask(id);
		
		userContext.getChecker().checkNameOfTransportTask( name);
		userContext.getChecker().checkStartOfTransportTask( start);
		userContext.getChecker().checkBeginTimeOfTransportTask( beginTime);
		userContext.getChecker().checkLatitudeOfTransportTask( latitude);
		userContext.getChecker().checkLongitudeOfTransportTask( longitude);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
		
	}
	public  RetailStore updateTransportTaskProperties(RetailscmUserContext userContext, String retailStoreId, String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskProperties(userContext,retailStoreId,id,name,start,beginTime,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListList()
				.searchTransportTaskListWith(TransportTask.ID_PROPERTY, "is", id).done();
		
		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);
		
		if(retailStoreToUpdate.getTransportTaskList().isEmpty()){
			throw new RetailStoreManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTask item = retailStoreToUpdate.getTransportTaskList().first();
		
		item.updateName( name );
		item.updateStart( start );
		item.updateBeginTime( beginTime );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );

		
		//checkParamsForAddingTransportTask(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withTransportTaskList().done());
		synchronized(retailStore){ 
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTask createTransportTask(RetailscmUserContext userContext, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		transportTask.setStart(start);		
		transportTask.setBeginTime(beginTime);		
		TruckDriver  driver = new TruckDriver();
		driver.setId(driverId);		
		transportTask.setDriver(driver);		
		TransportTruck  truck = new TransportTruck();
		truck.setId(truckId);		
		transportTask.setTruck(truck);		
		TransportFleet  belongsTo = new TransportFleet();
		belongsTo.setId(belongsToId);		
		transportTask.setBelongsTo(belongsTo);		
		transportTask.setLatitude(latitude);		
		transportTask.setLongitude(longitude);
	
		
		return transportTask;
	
		
	}
	
	protected TransportTask createIndexedTransportTask(String id, int version){

		TransportTask transportTask = new TransportTask();
		transportTask.setId(id);
		transportTask.setVersion(version);
		return transportTask;			
		
	}
	
	protected void checkParamsForRemovingTransportTaskList(RetailscmUserContext userContext, String retailStoreId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		for(String transportTaskId: transportTaskIds){
			userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
		
	}
	public  RetailStore removeTransportTaskList(RetailscmUserContext userContext, String retailStoreId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskList(userContext, retailStoreId,  transportTaskIds, tokensExpr);
			
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){ 
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveTransportTaskList(retailStore, transportTaskIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
				deleteRelationListInGraph(userContext, retailStore.getTransportTaskList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTask(RetailscmUserContext userContext, String retailStoreId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStore( retailStoreId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	public  RetailStore removeTransportTask(RetailscmUserContext userContext, String retailStoreId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTask(userContext,retailStoreId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeTransportTask( transportTask );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTask(RetailscmUserContext userContext, String retailStoreId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStore( retailStoreId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	public  RetailStore copyTransportTaskFrom(RetailscmUserContext userContext, String retailStoreId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTask(userContext,retailStoreId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStore.copyTransportTaskFrom( transportTask );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTask(RetailscmUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTask(parseString(newValueExpr));
		}
		
		if(TransportTask.START_PROPERTY.equals(property)){
			userContext.getChecker().checkStartOfTransportTask(parseString(newValueExpr));
		}
		
		if(TransportTask.BEGIN_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkBeginTimeOfTransportTask(parseDate(newValueExpr));
		}
		
		if(TransportTask.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfTransportTask(parseBigDecimal(newValueExpr));
		}
		
		if(TransportTask.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfTransportTask(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	
	public  RetailStore updateTransportTask(RetailscmUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTask(userContext, retailStoreId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskList().searchTransportTaskListWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();
		
		
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);
		
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeTransportTask( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		
			TransportTask transportTask = retailStore.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new RetailStoreManagerException(transportTask+" is NOT FOUND" );
			}
			
			transportTask.changeProperty(property, newValueExpr);
			
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingAccountSet(RetailscmUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);

		
		userContext.getChecker().checkNameOfAccountSet(name);
		
		userContext.getChecker().checkYearSetOfAccountSet(yearSet);
		
		userContext.getChecker().checkEffectiveDateOfAccountSet(effectiveDate);
		
		userContext.getChecker().checkAccountingSystemOfAccountSet(accountingSystem);
		
		userContext.getChecker().checkDomesticCurrencyCodeOfAccountSet(domesticCurrencyCode);
		
		userContext.getChecker().checkDomesticCurrencyNameOfAccountSet(domesticCurrencyName);
		
		userContext.getChecker().checkOpeningBankOfAccountSet(openingBank);
		
		userContext.getChecker().checkAccountNumberOfAccountSet(accountNumber);
		
		userContext.getChecker().checkCountryCenterIdOfAccountSet(countryCenterId);
		
		userContext.getChecker().checkGoodsSupplierIdOfAccountSet(goodsSupplierId);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);

	
	}
	public  RetailStore addAccountSet(RetailscmUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountSet(userContext,retailStoreId,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, goodsSupplierId,tokensExpr);
		
		AccountSet accountSet = createAccountSet(userContext,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, goodsSupplierId);
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addAccountSet( accountSet );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			
			userContext.getManagerGroup().getAccountSetManager().onNewInstanceCreated(userContext, accountSet);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountSetProperties(RetailscmUserContext userContext, String retailStoreId,String id,String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkIdOfAccountSet(id);
		
		userContext.getChecker().checkNameOfAccountSet( name);
		userContext.getChecker().checkYearSetOfAccountSet( yearSet);
		userContext.getChecker().checkEffectiveDateOfAccountSet( effectiveDate);
		userContext.getChecker().checkAccountingSystemOfAccountSet( accountingSystem);
		userContext.getChecker().checkDomesticCurrencyCodeOfAccountSet( domesticCurrencyCode);
		userContext.getChecker().checkDomesticCurrencyNameOfAccountSet( domesticCurrencyName);
		userContext.getChecker().checkOpeningBankOfAccountSet( openingBank);
		userContext.getChecker().checkAccountNumberOfAccountSet( accountNumber);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
		
	}
	public  RetailStore updateAccountSetProperties(RetailscmUserContext userContext, String retailStoreId, String id,String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingAccountSetProperties(userContext,retailStoreId,id,name,yearSet,effectiveDate,accountingSystem,domesticCurrencyCode,domesticCurrencyName,openingBank,accountNumber,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountSetListList()
				.searchAccountSetListWith(AccountSet.ID_PROPERTY, "is", id).done();
		
		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);
		
		if(retailStoreToUpdate.getAccountSetList().isEmpty()){
			throw new RetailStoreManagerException("AccountSet is NOT FOUND with id: '"+id+"'");
		}
		
		AccountSet item = retailStoreToUpdate.getAccountSetList().first();
		
		item.updateName( name );
		item.updateYearSet( yearSet );
		item.updateEffectiveDate( effectiveDate );
		item.updateAccountingSystem( accountingSystem );
		item.updateDomesticCurrencyCode( domesticCurrencyCode );
		item.updateDomesticCurrencyName( domesticCurrencyName );
		item.updateOpeningBank( openingBank );
		item.updateAccountNumber( accountNumber );

		
		//checkParamsForAddingAccountSet(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withAccountSetList().done());
		synchronized(retailStore){ 
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected AccountSet createAccountSet(RetailscmUserContext userContext, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId) throws Exception{

		AccountSet accountSet = new AccountSet();
		
		
		accountSet.setName(name);		
		accountSet.setYearSet(yearSet);		
		accountSet.setEffectiveDate(effectiveDate);		
		accountSet.setAccountingSystem(accountingSystem);		
		accountSet.setDomesticCurrencyCode(domesticCurrencyCode);		
		accountSet.setDomesticCurrencyName(domesticCurrencyName);		
		accountSet.setOpeningBank(openingBank);		
		accountSet.setAccountNumber(accountNumber);		
		RetailStoreCountryCenter  countryCenter = new RetailStoreCountryCenter();
		countryCenter.setId(countryCenterId);		
		accountSet.setCountryCenter(countryCenter);		
		GoodsSupplier  goodsSupplier = new GoodsSupplier();
		goodsSupplier.setId(goodsSupplierId);		
		accountSet.setGoodsSupplier(goodsSupplier);		
		accountSet.setLastUpdateTime(userContext.now());
	
		
		return accountSet;
	
		
	}
	
	protected AccountSet createIndexedAccountSet(String id, int version){

		AccountSet accountSet = new AccountSet();
		accountSet.setId(id);
		accountSet.setVersion(version);
		return accountSet;			
		
	}
	
	protected void checkParamsForRemovingAccountSetList(RetailscmUserContext userContext, String retailStoreId, 
			String accountSetIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		for(String accountSetId: accountSetIds){
			userContext.getChecker().checkIdOfAccountSet(accountSetId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
		
	}
	public  RetailStore removeAccountSetList(RetailscmUserContext userContext, String retailStoreId, 
			String accountSetIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAccountSetList(userContext, retailStoreId,  accountSetIds, tokensExpr);
			
			
			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){ 
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreDAO().planToRemoveAccountSetList(retailStore, accountSetIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
				deleteRelationListInGraph(userContext, retailStore.getAccountSetList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAccountSet(RetailscmUserContext userContext, String retailStoreId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStore( retailStoreId);
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().checkVersionOfAccountSet(accountSetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	public  RetailStore removeAccountSet(RetailscmUserContext userContext, String retailStoreId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountSet(userContext,retailStoreId, accountSetId, accountSetVersion,tokensExpr);
		
		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeAccountSet( accountSet );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			deleteRelationInGraph(userContext, accountSet);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingAccountSet(RetailscmUserContext userContext, String retailStoreId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStore( retailStoreId);
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().checkVersionOfAccountSet(accountSetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	public  RetailStore copyAccountSetFrom(RetailscmUserContext userContext, String retailStoreId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountSet(userContext,retailStoreId, accountSetId, accountSetVersion,tokensExpr);
		
		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			accountSet.updateLastUpdateTime(userContext.now());
			
			retailStore.copyAccountSetFrom( accountSet );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			
			userContext.getManagerGroup().getAccountSetManager().onNewInstanceCreated(userContext, (AccountSet)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingAccountSet(RetailscmUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkIdOfAccountSet(accountSetId);
		userContext.getChecker().checkVersionOfAccountSet(accountSetVersion);
		

		if(AccountSet.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfAccountSet(parseString(newValueExpr));
		}
		
		if(AccountSet.YEAR_SET_PROPERTY.equals(property)){
			userContext.getChecker().checkYearSetOfAccountSet(parseString(newValueExpr));
		}
		
		if(AccountSet.EFFECTIVE_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkEffectiveDateOfAccountSet(parseDate(newValueExpr));
		}
		
		if(AccountSet.ACCOUNTING_SYSTEM_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountingSystemOfAccountSet(parseString(newValueExpr));
		}
		
		if(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkDomesticCurrencyCodeOfAccountSet(parseString(newValueExpr));
		}
		
		if(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkDomesticCurrencyNameOfAccountSet(parseString(newValueExpr));
		}
		
		if(AccountSet.OPENING_BANK_PROPERTY.equals(property)){
			userContext.getChecker().checkOpeningBankOfAccountSet(parseString(newValueExpr));
		}
		
		if(AccountSet.ACCOUNT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkAccountNumberOfAccountSet(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreManagerException.class);
	
	}
	
	public  RetailStore updateAccountSet(RetailscmUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountSet(userContext, retailStoreId, accountSetId, accountSetVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withAccountSetList().searchAccountSetListWith(AccountSet.ID_PROPERTY, "eq", accountSetId).done();
		
		
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);
		
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeAccountSet( accountSet );	
			//make changes to AcceleraterAccount.
			AccountSet accountSetIndex = createIndexedAccountSet(accountSetId, accountSetVersion);
		
			AccountSet accountSet = retailStore.findTheAccountSet(accountSetIndex);
			if(accountSet == null){
				throw new RetailStoreManagerException(accountSet+" is NOT FOUND" );
			}
			
			accountSet.changeProperty(property, newValueExpr);
			accountSet.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStore newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


