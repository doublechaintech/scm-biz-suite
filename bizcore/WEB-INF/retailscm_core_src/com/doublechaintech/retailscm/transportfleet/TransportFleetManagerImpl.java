
package com.doublechaintech.retailscm.transportfleet;

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
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;






public class TransportFleetManagerImpl extends CustomRetailscmCheckerManager implements TransportFleetManager {
	
	private static final String SERVICE_TYPE = "TransportFleet";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TransportFleetManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TransportFleetManagerException(message);

	}
	
	

 	protected TransportFleet saveTransportFleet(RetailscmUserContext userContext, TransportFleet transportFleet, String [] tokensExpr) throws Exception{	
 		//return getTransportFleetDAO().save(transportFleet, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportFleet(userContext, transportFleet, tokens);
 	}
 	
 	protected TransportFleet saveTransportFleetDetail(RetailscmUserContext userContext, TransportFleet transportFleet) throws Exception{	

 		
 		return saveTransportFleet(userContext, transportFleet, allTokens());
 	}
 	
 	public TransportFleet loadTransportFleet(RetailscmUserContext userContext, String transportFleetId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportFleetManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportFleet, tokens);
 	}
 	
 	
 	 public TransportFleet searchTransportFleet(RetailscmUserContext userContext, String transportFleetId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportFleetManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportFleet, tokens);
 	}
 	
 	

 	protected TransportFleet present(RetailscmUserContext userContext, TransportFleet transportFleet, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportFleet,tokens);
		
		
		TransportFleet  transportFleetToPresent = userContext.getDAOGroup().getTransportFleetDAO().present(transportFleet, tokens);
		
		List<BaseEntity> entityListToNaming = transportFleetToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTransportFleetDAO().alias(entityListToNaming);
		
		return  transportFleetToPresent;
		
		
	}
 
 	
 	
 	public TransportFleet loadTransportFleetDetail(RetailscmUserContext userContext, String transportFleetId) throws Exception{	
 		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, allTokens());
 		return present(userContext,transportFleet, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String transportFleetId) throws Exception{	
 		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, viewTokens());
 		return present(userContext,transportFleet, allTokens());
		
 	}
 	protected TransportFleet saveTransportFleet(RetailscmUserContext userContext, TransportFleet transportFleet, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTransportFleetDAO().save(transportFleet, tokens);
 	}
 	protected TransportFleet loadTransportFleet(RetailscmUserContext userContext, String transportFleetId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportFleetManagerException.class);

 
 		return userContext.getDAOGroup().getTransportFleetDAO().load(transportFleetId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TransportFleet transportFleet, Map<String, Object> tokens){
		super.addActions(userContext, transportFleet, tokens);
		
		addAction(userContext, transportFleet, tokens,"@create","createTransportFleet","createTransportFleet/","main","primary");
		addAction(userContext, transportFleet, tokens,"@update","updateTransportFleet","updateTransportFleet/"+transportFleet.getId()+"/","main","primary");
		addAction(userContext, transportFleet, tokens,"@copy","cloneTransportFleet","cloneTransportFleet/"+transportFleet.getId()+"/","main","primary");
		
		addAction(userContext, transportFleet, tokens,"transport_fleet.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+transportFleet.getId()+"/","main","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.addTransportTruck","addTransportTruck","addTransportTruck/"+transportFleet.getId()+"/","transportTruckList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.removeTransportTruck","removeTransportTruck","removeTransportTruck/"+transportFleet.getId()+"/","transportTruckList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.updateTransportTruck","updateTransportTruck","updateTransportTruck/"+transportFleet.getId()+"/","transportTruckList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.copyTransportTruckFrom","copyTransportTruckFrom","copyTransportTruckFrom/"+transportFleet.getId()+"/","transportTruckList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.addTruckDriver","addTruckDriver","addTruckDriver/"+transportFleet.getId()+"/","truckDriverList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.removeTruckDriver","removeTruckDriver","removeTruckDriver/"+transportFleet.getId()+"/","truckDriverList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.updateTruckDriver","updateTruckDriver","updateTruckDriver/"+transportFleet.getId()+"/","truckDriverList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.copyTruckDriverFrom","copyTruckDriverFrom","copyTruckDriverFrom/"+transportFleet.getId()+"/","truckDriverList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.addTransportTask","addTransportTask","addTransportTask/"+transportFleet.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.removeTransportTask","removeTransportTask","removeTransportTask/"+transportFleet.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.updateTransportTask","updateTransportTask","updateTransportTask/"+transportFleet.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+transportFleet.getId()+"/","transportTaskList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TransportFleet transportFleet, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransportFleet createTransportFleet(RetailscmUserContext userContext,String name, String contactNumber, String ownerId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTransportFleet(name);
		userContext.getChecker().checkContactNumberOfTransportFleet(contactNumber);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);


		TransportFleet transportFleet=createNewTransportFleet();	

		transportFleet.setName(name);
		transportFleet.setContactNumber(contactNumber);
			
		RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, ownerId,emptyOptions());
		transportFleet.setOwner(owner);
		
		
		transportFleet.setLastUpdateTime(userContext.now());

		transportFleet = saveTransportFleet(userContext, transportFleet, emptyOptions());
		
		onNewInstanceCreated(userContext, transportFleet);
		return transportFleet;

		
	}
	protected TransportFleet createNewTransportFleet() 
	{
		
		return new TransportFleet();		
	}
	
	protected void checkParamsForUpdatingTransportFleet(RetailscmUserContext userContext,String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
		userContext.getChecker().checkVersionOfTransportFleet( transportFleetVersion);
		

		if(TransportFleet.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportFleet(parseString(newValueExpr));
		}
		if(TransportFleet.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfTransportFleet(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
	
		
	}
	
	
	
	public TransportFleet clone(RetailscmUserContext userContext, String fromTransportFleetId) throws Exception{
		
		return userContext.getDAOGroup().getTransportFleetDAO().clone(fromTransportFleetId, this.allTokens());
	}
	
	public TransportFleet internalSaveTransportFleet(RetailscmUserContext userContext, TransportFleet transportFleet) throws Exception 
	{
		return internalSaveTransportFleet(userContext, transportFleet, allTokens());

	}
	public TransportFleet internalSaveTransportFleet(RetailscmUserContext userContext, TransportFleet transportFleet, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTransportFleet(userContext, transportFleetId, transportFleetVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(transportFleet){ 
			//will be good when the transportFleet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportFleet.
			
			
			transportFleet = saveTransportFleet(userContext, transportFleet, options);
			return transportFleet;
			
		}

	}
	
	public TransportFleet updateTransportFleet(RetailscmUserContext userContext,String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportFleet(userContext, transportFleetId, transportFleetVersion, property, newValueExpr, tokensExpr);
		
		
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		if(transportFleet.getVersion() != transportFleetVersion){
			String message = "The target version("+transportFleet.getVersion()+") is not equals to version("+transportFleetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportFleet){ 
			//will be good when the transportFleet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportFleet.
			transportFleet.updateLastUpdateTime(userContext.now());
			transportFleet.changeProperty(property, newValueExpr);
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
			//return saveTransportFleet(userContext, transportFleet, tokens().done());
		}

	}
	
	public TransportFleet updateTransportFleetProperty(RetailscmUserContext userContext,String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportFleet(userContext, transportFleetId, transportFleetVersion, property, newValueExpr, tokensExpr);
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		if(transportFleet.getVersion() != transportFleetVersion){
			String message = "The target version("+transportFleet.getVersion()+") is not equals to version("+transportFleetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportFleet){ 
			//will be good when the transportFleet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportFleet.
			
			transportFleet.changeProperty(property, newValueExpr);
			transportFleet.updateLastUpdateTime(userContext.now());
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
			//return saveTransportFleet(userContext, transportFleet, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransportFleetTokens tokens(){
		return TransportFleetTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportFleetTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransportTruckListWith("id","desc")
		.sortTruckDriverListWith("id","desc")
		.sortTransportTaskListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportFleetTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String transportFleetId, String anotherOwnerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherOwnerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
 		
 	}
 	public TransportFleet transferToAnotherOwner(RetailscmUserContext userContext, String transportFleetId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, transportFleetId,anotherOwnerId);
 
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());	
		synchronized(transportFleet){
			//will be good when the transportFleet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, anotherOwnerId, emptyOptions());		
			transportFleet.updateOwner(owner);		
			transportFleet = saveTransportFleet(userContext, transportFleet, emptyOptions());
			
			return present(userContext,transportFleet, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForTransportFleet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newOwnerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String transportFleetId, int transportFleetVersion) throws Exception {
		//deleteInternal(userContext, transportFleetId, transportFleetVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String transportFleetId, int transportFleetVersion) throws Exception{
			
		userContext.getDAOGroup().getTransportFleetDAO().delete(transportFleetId, transportFleetVersion);
	}
	
	public TransportFleet forgetByAll(RetailscmUserContext userContext, String transportFleetId, int transportFleetVersion) throws Exception {
		return forgetByAllInternal(userContext, transportFleetId, transportFleetVersion);		
	}
	protected TransportFleet forgetByAllInternal(RetailscmUserContext userContext,
			String transportFleetId, int transportFleetVersion) throws Exception{
			
		return userContext.getDAOGroup().getTransportFleetDAO().disconnectFromAll(transportFleetId, transportFleetVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportFleetManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTransportFleetDAO().deleteAll();
	}


	//disconnect TransportFleet with end in TransportTask
	protected TransportFleet breakWithTransportTaskByEnd(RetailscmUserContext userContext, String transportFleetId, String endId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());

			synchronized(transportFleet){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportFleetDAO().planToRemoveTransportTaskListWithEnd(transportFleet, endId, this.emptyOptions());

				transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
				return transportFleet;
			}
	}
	//disconnect TransportFleet with driver in TransportTask
	protected TransportFleet breakWithTransportTaskByDriver(RetailscmUserContext userContext, String transportFleetId, String driverId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());

			synchronized(transportFleet){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportFleetDAO().planToRemoveTransportTaskListWithDriver(transportFleet, driverId, this.emptyOptions());

				transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
				return transportFleet;
			}
	}
	//disconnect TransportFleet with truck in TransportTask
	protected TransportFleet breakWithTransportTaskByTruck(RetailscmUserContext userContext, String transportFleetId, String truckId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());

			synchronized(transportFleet){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportFleetDAO().planToRemoveTransportTaskListWithTruck(transportFleet, truckId, this.emptyOptions());

				transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
				return transportFleet;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTransportTruck(RetailscmUserContext userContext, String transportFleetId, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);

		
		userContext.getChecker().checkNameOfTransportTruck(name);
		
		userContext.getChecker().checkPlateNumberOfTransportTruck(plateNumber);
		
		userContext.getChecker().checkContactNumberOfTransportTruck(contactNumber);
		
		userContext.getChecker().checkVehicleLicenseNumberOfTransportTruck(vehicleLicenseNumber);
		
		userContext.getChecker().checkEngineNumberOfTransportTruck(engineNumber);
		
		userContext.getChecker().checkMakeDateOfTransportTruck(makeDate);
		
		userContext.getChecker().checkMileageOfTransportTruck(mileage);
		
		userContext.getChecker().checkBodyColorOfTransportTruck(bodyColor);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);

	
	}
	public  TransportFleet addTransportTruck(RetailscmUserContext userContext, String transportFleetId, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTruck(userContext,transportFleetId,name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor,tokensExpr);
		
		TransportTruck transportTruck = createTransportTruck(userContext,name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor);
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.addTransportTruck( transportTruck );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
			
			userContext.getManagerGroup().getTransportTruckManager().onNewInstanceCreated(userContext, transportTruck);
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTruckProperties(RetailscmUserContext userContext, String transportFleetId,String id,String name,String plateNumber,String contactNumber,String vehicleLicenseNumber,String engineNumber,Date makeDate,String mileage,String bodyColor,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
		userContext.getChecker().checkIdOfTransportTruck(id);
		
		userContext.getChecker().checkNameOfTransportTruck( name);
		userContext.getChecker().checkPlateNumberOfTransportTruck( plateNumber);
		userContext.getChecker().checkContactNumberOfTransportTruck( contactNumber);
		userContext.getChecker().checkVehicleLicenseNumberOfTransportTruck( vehicleLicenseNumber);
		userContext.getChecker().checkEngineNumberOfTransportTruck( engineNumber);
		userContext.getChecker().checkMakeDateOfTransportTruck( makeDate);
		userContext.getChecker().checkMileageOfTransportTruck( mileage);
		userContext.getChecker().checkBodyColorOfTransportTruck( bodyColor);

		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
		
	}
	public  TransportFleet updateTransportTruckProperties(RetailscmUserContext userContext, String transportFleetId, String id,String name,String plateNumber,String contactNumber,String vehicleLicenseNumber,String engineNumber,Date makeDate,String mileage,String bodyColor, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTruckProperties(userContext,transportFleetId,id,name,plateNumber,contactNumber,vehicleLicenseNumber,engineNumber,makeDate,mileage,bodyColor,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTruckListList()
				.searchTransportTruckListWith(TransportTruck.ID_PROPERTY, "is", id).done();
		
		TransportFleet transportFleetToUpdate = loadTransportFleet(userContext, transportFleetId, options);
		
		if(transportFleetToUpdate.getTransportTruckList().isEmpty()){
			throw new TransportFleetManagerException("TransportTruck is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTruck item = transportFleetToUpdate.getTransportTruckList().first();
		
		item.updateName( name );
		item.updatePlateNumber( plateNumber );
		item.updateContactNumber( contactNumber );
		item.updateVehicleLicenseNumber( vehicleLicenseNumber );
		item.updateEngineNumber( engineNumber );
		item.updateMakeDate( makeDate );
		item.updateMileage( mileage );
		item.updateBodyColor( bodyColor );

		
		//checkParamsForAddingTransportTruck(userContext,transportFleetId,name, code, used,tokensExpr);
		TransportFleet transportFleet = saveTransportFleet(userContext, transportFleetToUpdate, tokens().withTransportTruckList().done());
		synchronized(transportFleet){ 
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTruck createTransportTruck(RetailscmUserContext userContext, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor) throws Exception{

		TransportTruck transportTruck = new TransportTruck();
		
		
		transportTruck.setName(name);		
		transportTruck.setPlateNumber(plateNumber);		
		transportTruck.setContactNumber(contactNumber);		
		transportTruck.setVehicleLicenseNumber(vehicleLicenseNumber);		
		transportTruck.setEngineNumber(engineNumber);		
		transportTruck.setMakeDate(makeDate);		
		transportTruck.setMileage(mileage);		
		transportTruck.setBodyColor(bodyColor);
	
		
		return transportTruck;
	
		
	}
	
	protected TransportTruck createIndexedTransportTruck(String id, int version){

		TransportTruck transportTruck = new TransportTruck();
		transportTruck.setId(id);
		transportTruck.setVersion(version);
		return transportTruck;			
		
	}
	
	protected void checkParamsForRemovingTransportTruckList(RetailscmUserContext userContext, String transportFleetId, 
			String transportTruckIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
		for(String transportTruckId: transportTruckIds){
			userContext.getChecker().checkIdOfTransportTruck(transportTruckId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
		
	}
	public  TransportFleet removeTransportTruckList(RetailscmUserContext userContext, String transportFleetId, 
			String transportTruckIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTruckList(userContext, transportFleetId,  transportTruckIds, tokensExpr);
			
			
			TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
			synchronized(transportFleet){ 
				//Will be good when the transportFleet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTransportFleetDAO().planToRemoveTransportTruckList(transportFleet, transportTruckIds, allTokens());
				transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
				deleteRelationListInGraph(userContext, transportFleet.getTransportTruckList());
				return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTruck(RetailscmUserContext userContext, String transportFleetId, 
		String transportTruckId, int transportTruckVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportFleet( transportFleetId);
		userContext.getChecker().checkIdOfTransportTruck(transportTruckId);
		userContext.getChecker().checkVersionOfTransportTruck(transportTruckVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
	
	}
	public  TransportFleet removeTransportTruck(RetailscmUserContext userContext, String transportFleetId, 
		String transportTruckId, int transportTruckVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTruck(userContext,transportFleetId, transportTruckId, transportTruckVersion,tokensExpr);
		
		TransportTruck transportTruck = createIndexedTransportTruck(transportTruckId, transportTruckVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.removeTransportTruck( transportTruck );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
			deleteRelationInGraph(userContext, transportTruck);
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTruck(RetailscmUserContext userContext, String transportFleetId, 
		String transportTruckId, int transportTruckVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportFleet( transportFleetId);
		userContext.getChecker().checkIdOfTransportTruck(transportTruckId);
		userContext.getChecker().checkVersionOfTransportTruck(transportTruckVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
	
	}
	public  TransportFleet copyTransportTruckFrom(RetailscmUserContext userContext, String transportFleetId, 
		String transportTruckId, int transportTruckVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTruck(userContext,transportFleetId, transportTruckId, transportTruckVersion,tokensExpr);
		
		TransportTruck transportTruck = createIndexedTransportTruck(transportTruckId, transportTruckVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			transportFleet.copyTransportTruckFrom( transportTruck );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
			
			userContext.getManagerGroup().getTransportTruckManager().onNewInstanceCreated(userContext, (TransportTruck)transportFleet.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTruck(RetailscmUserContext userContext, String transportFleetId, String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
		userContext.getChecker().checkIdOfTransportTruck(transportTruckId);
		userContext.getChecker().checkVersionOfTransportTruck(transportTruckVersion);
		

		if(TransportTruck.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTransportTruck(parseString(newValueExpr));
		}
		
		if(TransportTruck.PLATE_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkPlateNumberOfTransportTruck(parseString(newValueExpr));
		}
		
		if(TransportTruck.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfTransportTruck(parseString(newValueExpr));
		}
		
		if(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkVehicleLicenseNumberOfTransportTruck(parseString(newValueExpr));
		}
		
		if(TransportTruck.ENGINE_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkEngineNumberOfTransportTruck(parseString(newValueExpr));
		}
		
		if(TransportTruck.MAKE_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkMakeDateOfTransportTruck(parseDate(newValueExpr));
		}
		
		if(TransportTruck.MILEAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkMileageOfTransportTruck(parseString(newValueExpr));
		}
		
		if(TransportTruck.BODY_COLOR_PROPERTY.equals(property)){
			userContext.getChecker().checkBodyColorOfTransportTruck(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
	
	}
	
	public  TransportFleet updateTransportTruck(RetailscmUserContext userContext, String transportFleetId, String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTruck(userContext, transportFleetId, transportTruckId, transportTruckVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTruckList().searchTransportTruckListWith(TransportTruck.ID_PROPERTY, "eq", transportTruckId).done();
		
		
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, loadTokens);
		
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportFleet.removeTransportTruck( transportTruck );	
			//make changes to AcceleraterAccount.
			TransportTruck transportTruckIndex = createIndexedTransportTruck(transportTruckId, transportTruckVersion);
		
			TransportTruck transportTruck = transportFleet.findTheTransportTruck(transportTruckIndex);
			if(transportTruck == null){
				throw new TransportFleetManagerException(transportTruck+" is NOT FOUND" );
			}
			
			transportTruck.changeProperty(property, newValueExpr);
			
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTruckDriver(RetailscmUserContext userContext, String transportFleetId, String name, String driverLicenseNumber, String contactNumber,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);

		
		userContext.getChecker().checkNameOfTruckDriver(name);
		
		userContext.getChecker().checkDriverLicenseNumberOfTruckDriver(driverLicenseNumber);
		
		userContext.getChecker().checkContactNumberOfTruckDriver(contactNumber);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);

	
	}
	public  TransportFleet addTruckDriver(RetailscmUserContext userContext, String transportFleetId, String name, String driverLicenseNumber, String contactNumber, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTruckDriver(userContext,transportFleetId,name, driverLicenseNumber, contactNumber,tokensExpr);
		
		TruckDriver truckDriver = createTruckDriver(userContext,name, driverLicenseNumber, contactNumber);
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.addTruckDriver( truckDriver );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
			
			userContext.getManagerGroup().getTruckDriverManager().onNewInstanceCreated(userContext, truckDriver);
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTruckDriverProperties(RetailscmUserContext userContext, String transportFleetId,String id,String name,String driverLicenseNumber,String contactNumber,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
		userContext.getChecker().checkIdOfTruckDriver(id);
		
		userContext.getChecker().checkNameOfTruckDriver( name);
		userContext.getChecker().checkDriverLicenseNumberOfTruckDriver( driverLicenseNumber);
		userContext.getChecker().checkContactNumberOfTruckDriver( contactNumber);

		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
		
	}
	public  TransportFleet updateTruckDriverProperties(RetailscmUserContext userContext, String transportFleetId, String id,String name,String driverLicenseNumber,String contactNumber, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTruckDriverProperties(userContext,transportFleetId,id,name,driverLicenseNumber,contactNumber,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTruckDriverListList()
				.searchTruckDriverListWith(TruckDriver.ID_PROPERTY, "is", id).done();
		
		TransportFleet transportFleetToUpdate = loadTransportFleet(userContext, transportFleetId, options);
		
		if(transportFleetToUpdate.getTruckDriverList().isEmpty()){
			throw new TransportFleetManagerException("TruckDriver is NOT FOUND with id: '"+id+"'");
		}
		
		TruckDriver item = transportFleetToUpdate.getTruckDriverList().first();
		
		item.updateName( name );
		item.updateDriverLicenseNumber( driverLicenseNumber );
		item.updateContactNumber( contactNumber );

		
		//checkParamsForAddingTruckDriver(userContext,transportFleetId,name, code, used,tokensExpr);
		TransportFleet transportFleet = saveTransportFleet(userContext, transportFleetToUpdate, tokens().withTruckDriverList().done());
		synchronized(transportFleet){ 
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TruckDriver createTruckDriver(RetailscmUserContext userContext, String name, String driverLicenseNumber, String contactNumber) throws Exception{

		TruckDriver truckDriver = new TruckDriver();
		
		
		truckDriver.setName(name);		
		truckDriver.setDriverLicenseNumber(driverLicenseNumber);		
		truckDriver.setContactNumber(contactNumber);
	
		
		return truckDriver;
	
		
	}
	
	protected TruckDriver createIndexedTruckDriver(String id, int version){

		TruckDriver truckDriver = new TruckDriver();
		truckDriver.setId(id);
		truckDriver.setVersion(version);
		return truckDriver;			
		
	}
	
	protected void checkParamsForRemovingTruckDriverList(RetailscmUserContext userContext, String transportFleetId, 
			String truckDriverIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
		for(String truckDriverId: truckDriverIds){
			userContext.getChecker().checkIdOfTruckDriver(truckDriverId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
		
	}
	public  TransportFleet removeTruckDriverList(RetailscmUserContext userContext, String transportFleetId, 
			String truckDriverIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTruckDriverList(userContext, transportFleetId,  truckDriverIds, tokensExpr);
			
			
			TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
			synchronized(transportFleet){ 
				//Will be good when the transportFleet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTransportFleetDAO().planToRemoveTruckDriverList(transportFleet, truckDriverIds, allTokens());
				transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
				deleteRelationListInGraph(userContext, transportFleet.getTruckDriverList());
				return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTruckDriver(RetailscmUserContext userContext, String transportFleetId, 
		String truckDriverId, int truckDriverVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportFleet( transportFleetId);
		userContext.getChecker().checkIdOfTruckDriver(truckDriverId);
		userContext.getChecker().checkVersionOfTruckDriver(truckDriverVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
	
	}
	public  TransportFleet removeTruckDriver(RetailscmUserContext userContext, String transportFleetId, 
		String truckDriverId, int truckDriverVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTruckDriver(userContext,transportFleetId, truckDriverId, truckDriverVersion,tokensExpr);
		
		TruckDriver truckDriver = createIndexedTruckDriver(truckDriverId, truckDriverVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.removeTruckDriver( truckDriver );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
			deleteRelationInGraph(userContext, truckDriver);
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTruckDriver(RetailscmUserContext userContext, String transportFleetId, 
		String truckDriverId, int truckDriverVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportFleet( transportFleetId);
		userContext.getChecker().checkIdOfTruckDriver(truckDriverId);
		userContext.getChecker().checkVersionOfTruckDriver(truckDriverVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
	
	}
	public  TransportFleet copyTruckDriverFrom(RetailscmUserContext userContext, String transportFleetId, 
		String truckDriverId, int truckDriverVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTruckDriver(userContext,transportFleetId, truckDriverId, truckDriverVersion,tokensExpr);
		
		TruckDriver truckDriver = createIndexedTruckDriver(truckDriverId, truckDriverVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			transportFleet.copyTruckDriverFrom( truckDriver );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
			
			userContext.getManagerGroup().getTruckDriverManager().onNewInstanceCreated(userContext, (TruckDriver)transportFleet.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTruckDriver(RetailscmUserContext userContext, String transportFleetId, String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
		userContext.getChecker().checkIdOfTruckDriver(truckDriverId);
		userContext.getChecker().checkVersionOfTruckDriver(truckDriverVersion);
		

		if(TruckDriver.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTruckDriver(parseString(newValueExpr));
		}
		
		if(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkDriverLicenseNumberOfTruckDriver(parseString(newValueExpr));
		}
		
		if(TruckDriver.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfTruckDriver(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
	
	}
	
	public  TransportFleet updateTruckDriver(RetailscmUserContext userContext, String transportFleetId, String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTruckDriver(userContext, transportFleetId, truckDriverId, truckDriverVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTruckDriverList().searchTruckDriverListWith(TruckDriver.ID_PROPERTY, "eq", truckDriverId).done();
		
		
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, loadTokens);
		
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportFleet.removeTruckDriver( truckDriver );	
			//make changes to AcceleraterAccount.
			TruckDriver truckDriverIndex = createIndexedTruckDriver(truckDriverId, truckDriverVersion);
		
			TruckDriver truckDriver = transportFleet.findTheTruckDriver(truckDriverIndex);
			if(truckDriver == null){
				throw new TransportFleetManagerException(truckDriver+" is NOT FOUND" );
			}
			
			truckDriver.changeProperty(property, newValueExpr);
			
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingTransportTask(RetailscmUserContext userContext, String transportFleetId, String name, String start, Date beginTime, String endId, String driverId, String truckId, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);

		
		userContext.getChecker().checkNameOfTransportTask(name);
		
		userContext.getChecker().checkStartOfTransportTask(start);
		
		userContext.getChecker().checkBeginTimeOfTransportTask(beginTime);
		
		userContext.getChecker().checkEndIdOfTransportTask(endId);
		
		userContext.getChecker().checkDriverIdOfTransportTask(driverId);
		
		userContext.getChecker().checkTruckIdOfTransportTask(truckId);
		
		userContext.getChecker().checkLatitudeOfTransportTask(latitude);
		
		userContext.getChecker().checkLongitudeOfTransportTask(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);

	
	}
	public  TransportFleet addTransportTask(RetailscmUserContext userContext, String transportFleetId, String name, String start, Date beginTime, String endId, String driverId, String truckId, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTask(userContext,transportFleetId,name, start, beginTime, endId, driverId, truckId, latitude, longitude,tokensExpr);
		
		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, endId, driverId, truckId, latitude, longitude);
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.addTransportTask( transportTask );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskProperties(RetailscmUserContext userContext, String transportFleetId,String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
		userContext.getChecker().checkIdOfTransportTask(id);
		
		userContext.getChecker().checkNameOfTransportTask( name);
		userContext.getChecker().checkStartOfTransportTask( start);
		userContext.getChecker().checkBeginTimeOfTransportTask( beginTime);
		userContext.getChecker().checkLatitudeOfTransportTask( latitude);
		userContext.getChecker().checkLongitudeOfTransportTask( longitude);

		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
		
	}
	public  TransportFleet updateTransportTaskProperties(RetailscmUserContext userContext, String transportFleetId, String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskProperties(userContext,transportFleetId,id,name,start,beginTime,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListList()
				.searchTransportTaskListWith(TransportTask.ID_PROPERTY, "is", id).done();
		
		TransportFleet transportFleetToUpdate = loadTransportFleet(userContext, transportFleetId, options);
		
		if(transportFleetToUpdate.getTransportTaskList().isEmpty()){
			throw new TransportFleetManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTask item = transportFleetToUpdate.getTransportTaskList().first();
		
		item.updateName( name );
		item.updateStart( start );
		item.updateBeginTime( beginTime );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );

		
		//checkParamsForAddingTransportTask(userContext,transportFleetId,name, code, used,tokensExpr);
		TransportFleet transportFleet = saveTransportFleet(userContext, transportFleetToUpdate, tokens().withTransportTaskList().done());
		synchronized(transportFleet){ 
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTask createTransportTask(RetailscmUserContext userContext, String name, String start, Date beginTime, String endId, String driverId, String truckId, BigDecimal latitude, BigDecimal longitude) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		transportTask.setStart(start);		
		transportTask.setBeginTime(beginTime);		
		RetailStore  end = new RetailStore();
		end.setId(endId);		
		transportTask.setEnd(end);		
		TruckDriver  driver = new TruckDriver();
		driver.setId(driverId);		
		transportTask.setDriver(driver);		
		TransportTruck  truck = new TransportTruck();
		truck.setId(truckId);		
		transportTask.setTruck(truck);		
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
	
	protected void checkParamsForRemovingTransportTaskList(RetailscmUserContext userContext, String transportFleetId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
		for(String transportTaskId: transportTaskIds){
			userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
		
	}
	public  TransportFleet removeTransportTaskList(RetailscmUserContext userContext, String transportFleetId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskList(userContext, transportFleetId,  transportTaskIds, tokensExpr);
			
			
			TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
			synchronized(transportFleet){ 
				//Will be good when the transportFleet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTransportFleetDAO().planToRemoveTransportTaskList(transportFleet, transportTaskIds, allTokens());
				transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
				deleteRelationListInGraph(userContext, transportFleet.getTransportTaskList());
				return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTask(RetailscmUserContext userContext, String transportFleetId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportFleet( transportFleetId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
	
	}
	public  TransportFleet removeTransportTask(RetailscmUserContext userContext, String transportFleetId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTask(userContext,transportFleetId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.removeTransportTask( transportTask );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTask(RetailscmUserContext userContext, String transportFleetId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportFleet( transportFleetId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
	
	}
	public  TransportFleet copyTransportTaskFrom(RetailscmUserContext userContext, String transportFleetId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTask(userContext,transportFleetId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			transportFleet.copyTransportTaskFrom( transportTask );		
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)transportFleet.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTask(RetailscmUserContext userContext, String transportFleetId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTransportFleet(transportFleetId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportFleetManagerException.class);
	
	}
	
	public  TransportFleet updateTransportTask(RetailscmUserContext userContext, String transportFleetId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTask(userContext, transportFleetId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskList().searchTransportTaskListWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();
		
		
		
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, loadTokens);
		
		synchronized(transportFleet){ 
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportFleet.removeTransportTask( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		
			TransportTask transportTask = transportFleet.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new TransportFleetManagerException(transportTask+" is NOT FOUND" );
			}
			
			transportTask.changeProperty(property, newValueExpr);
			
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, TransportFleet newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


