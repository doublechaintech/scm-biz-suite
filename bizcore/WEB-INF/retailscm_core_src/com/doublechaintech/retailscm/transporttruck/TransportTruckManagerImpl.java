
package com.doublechaintech.retailscm.transporttruck;

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

import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.transportfleet.CandidateTransportFleet;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;






public class TransportTruckManagerImpl extends CustomRetailscmCheckerManager implements TransportTruckManager {
	
	private static final String SERVICE_TYPE = "TransportTruck";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TransportTruckManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TransportTruckManagerException(message);

	}
	
	

 	protected TransportTruck saveTransportTruck(RetailscmUserContext userContext, TransportTruck transportTruck, String [] tokensExpr) throws Exception{	
 		//return getTransportTruckDAO().save(transportTruck, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportTruck(userContext, transportTruck, tokens);
 	}
 	
 	protected TransportTruck saveTransportTruckDetail(RetailscmUserContext userContext, TransportTruck transportTruck) throws Exception{	

 		
 		return saveTransportTruck(userContext, transportTruck, allTokens());
 	}
 	
 	public TransportTruck loadTransportTruck(RetailscmUserContext userContext, String transportTruckId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportTruck(transportTruckId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTruckManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportTruck transportTruck = loadTransportTruck( userContext, transportTruckId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTruck, tokens);
 	}
 	
 	
 	 public TransportTruck searchTransportTruck(RetailscmUserContext userContext, String transportTruckId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportTruck(transportTruckId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTruckManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TransportTruck transportTruck = loadTransportTruck( userContext, transportTruckId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTruck, tokens);
 	}
 	
 	

 	protected TransportTruck present(RetailscmUserContext userContext, TransportTruck transportTruck, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportTruck,tokens);
		
		
		TransportTruck  transportTruckToPresent = userContext.getDAOGroup().getTransportTruckDAO().present(transportTruck, tokens);
		
		List<BaseEntity> entityListToNaming = transportTruckToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTransportTruckDAO().alias(entityListToNaming);
		
		return  transportTruckToPresent;
		
		
	}
 
 	
 	
 	public TransportTruck loadTransportTruckDetail(RetailscmUserContext userContext, String transportTruckId) throws Exception{	
 		TransportTruck transportTruck = loadTransportTruck( userContext, transportTruckId, allTokens());
 		return present(userContext,transportTruck, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String transportTruckId) throws Exception{	
 		TransportTruck transportTruck = loadTransportTruck( userContext, transportTruckId, viewTokens());
 		return present(userContext,transportTruck, allTokens());
		
 	}
 	protected TransportTruck saveTransportTruck(RetailscmUserContext userContext, TransportTruck transportTruck, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTransportTruckDAO().save(transportTruck, tokens);
 	}
 	protected TransportTruck loadTransportTruck(RetailscmUserContext userContext, String transportTruckId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTransportTruck(transportTruckId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTruckManagerException.class);

 
 		return userContext.getDAOGroup().getTransportTruckDAO().load(transportTruckId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TransportTruck transportTruck, Map<String, Object> tokens){
		super.addActions(userContext, transportTruck, tokens);
		
		addAction(userContext, transportTruck, tokens,"@create","createTransportTruck","createTransportTruck/","main","primary");
		addAction(userContext, transportTruck, tokens,"@update","updateTransportTruck","updateTransportTruck/"+transportTruck.getId()+"/","main","primary");
		addAction(userContext, transportTruck, tokens,"@copy","cloneTransportTruck","cloneTransportTruck/"+transportTruck.getId()+"/","main","primary");
		
		addAction(userContext, transportTruck, tokens,"transport_truck.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+transportTruck.getId()+"/","main","primary");
		addAction(userContext, transportTruck, tokens,"transport_truck.addTransportTask","addTransportTask","addTransportTask/"+transportTruck.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportTruck, tokens,"transport_truck.removeTransportTask","removeTransportTask","removeTransportTask/"+transportTruck.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportTruck, tokens,"transport_truck.updateTransportTask","updateTransportTask","updateTransportTask/"+transportTruck.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportTruck, tokens,"transport_truck.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+transportTruck.getId()+"/","transportTaskList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TransportTruck transportTruck, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransportTruck createTransportTruck(RetailscmUserContext userContext,String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor, String ownerId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTransportTruck(name);
		userContext.getChecker().checkPlateNumberOfTransportTruck(plateNumber);
		userContext.getChecker().checkContactNumberOfTransportTruck(contactNumber);
		userContext.getChecker().checkVehicleLicenseNumberOfTransportTruck(vehicleLicenseNumber);
		userContext.getChecker().checkEngineNumberOfTransportTruck(engineNumber);
		userContext.getChecker().checkMakeDateOfTransportTruck(makeDate);
		userContext.getChecker().checkMileageOfTransportTruck(mileage);
		userContext.getChecker().checkBodyColorOfTransportTruck(bodyColor);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTruckManagerException.class);


		TransportTruck transportTruck=createNewTransportTruck();	

		transportTruck.setName(name);
		transportTruck.setPlateNumber(plateNumber);
		transportTruck.setContactNumber(contactNumber);
		transportTruck.setVehicleLicenseNumber(vehicleLicenseNumber);
		transportTruck.setEngineNumber(engineNumber);
		transportTruck.setMakeDate(makeDate);
		transportTruck.setMileage(mileage);
		transportTruck.setBodyColor(bodyColor);
			
		TransportFleet owner = loadTransportFleet(userContext, ownerId,emptyOptions());
		transportTruck.setOwner(owner);
		
		

		transportTruck = saveTransportTruck(userContext, transportTruck, emptyOptions());
		
		onNewInstanceCreated(userContext, transportTruck);
		return transportTruck;

		
	}
	protected TransportTruck createNewTransportTruck() 
	{
		
		return new TransportTruck();		
	}
	
	protected void checkParamsForUpdatingTransportTruck(RetailscmUserContext userContext,String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTransportTruck(transportTruckId);
		userContext.getChecker().checkVersionOfTransportTruck( transportTruckVersion);
		

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

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTruckManagerException.class);
	
		
	}
	
	
	
	public TransportTruck clone(RetailscmUserContext userContext, String fromTransportTruckId) throws Exception{
		
		return userContext.getDAOGroup().getTransportTruckDAO().clone(fromTransportTruckId, this.allTokens());
	}
	
	public TransportTruck internalSaveTransportTruck(RetailscmUserContext userContext, TransportTruck transportTruck) throws Exception 
	{
		return internalSaveTransportTruck(userContext, transportTruck, allTokens());

	}
	public TransportTruck internalSaveTransportTruck(RetailscmUserContext userContext, TransportTruck transportTruck, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTransportTruck(userContext, transportTruckId, transportTruckVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(transportTruck){ 
			//will be good when the transportTruck loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTruck.
			
			
			transportTruck = saveTransportTruck(userContext, transportTruck, options);
			return transportTruck;
			
		}

	}
	
	public TransportTruck updateTransportTruck(RetailscmUserContext userContext,String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTruck(userContext, transportTruckId, transportTruckVersion, property, newValueExpr, tokensExpr);
		
		
		
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());
		if(transportTruck.getVersion() != transportTruckVersion){
			String message = "The target version("+transportTruck.getVersion()+") is not equals to version("+transportTruckVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTruck){ 
			//will be good when the transportTruck loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTruck.
			
			transportTruck.changeProperty(property, newValueExpr);
			transportTruck = saveTransportTruck(userContext, transportTruck, tokens().done());
			return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
			//return saveTransportTruck(userContext, transportTruck, tokens().done());
		}

	}
	
	public TransportTruck updateTransportTruckProperty(RetailscmUserContext userContext,String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTruck(userContext, transportTruckId, transportTruckVersion, property, newValueExpr, tokensExpr);
		
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());
		if(transportTruck.getVersion() != transportTruckVersion){
			String message = "The target version("+transportTruck.getVersion()+") is not equals to version("+transportTruckVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTruck){ 
			//will be good when the transportTruck loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTruck.
			
			transportTruck.changeProperty(property, newValueExpr);
			
			transportTruck = saveTransportTruck(userContext, transportTruck, tokens().done());
			return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
			//return saveTransportTruck(userContext, transportTruck, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransportTruckTokens tokens(){
		return TransportTruckTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportTruckTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransportTaskListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportTruckTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String transportTruckId, String anotherOwnerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportTruck(transportTruckId);
 		userContext.getChecker().checkIdOfTransportFleet(anotherOwnerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportTruckManagerException.class);
 		
 	}
 	public TransportTruck transferToAnotherOwner(RetailscmUserContext userContext, String transportTruckId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, transportTruckId,anotherOwnerId);
 
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());	
		synchronized(transportTruck){
			//will be good when the transportTruck loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportFleet owner = loadTransportFleet(userContext, anotherOwnerId, emptyOptions());		
			transportTruck.updateOwner(owner);		
			transportTruck = saveTransportTruck(userContext, transportTruck, emptyOptions());
			
			return present(userContext,transportTruck, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateTransportFleet requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTransportFleet result = new CandidateTransportFleet();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TransportFleet> candidateList = userContext.getDAOGroup().getTransportFleetDAO().requestCandidateTransportFleetForTransportTruck(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected TransportFleet loadTransportFleet(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTransportFleetDAO().load(newOwnerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String transportTruckId, int transportTruckVersion) throws Exception {
		//deleteInternal(userContext, transportTruckId, transportTruckVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String transportTruckId, int transportTruckVersion) throws Exception{
			
		userContext.getDAOGroup().getTransportTruckDAO().delete(transportTruckId, transportTruckVersion);
	}
	
	public TransportTruck forgetByAll(RetailscmUserContext userContext, String transportTruckId, int transportTruckVersion) throws Exception {
		return forgetByAllInternal(userContext, transportTruckId, transportTruckVersion);		
	}
	protected TransportTruck forgetByAllInternal(RetailscmUserContext userContext,
			String transportTruckId, int transportTruckVersion) throws Exception{
			
		return userContext.getDAOGroup().getTransportTruckDAO().disconnectFromAll(transportTruckId, transportTruckVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportTruckManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTransportTruckDAO().deleteAll();
	}


	//disconnect TransportTruck with end in TransportTask
	protected TransportTruck breakWithTransportTaskByEnd(RetailscmUserContext userContext, String transportTruckId, String endId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());

			synchronized(transportTruck){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportTruckDAO().planToRemoveTransportTaskListWithEnd(transportTruck, endId, this.emptyOptions());

				transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
				return transportTruck;
			}
	}
	//disconnect TransportTruck with driver in TransportTask
	protected TransportTruck breakWithTransportTaskByDriver(RetailscmUserContext userContext, String transportTruckId, String driverId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());

			synchronized(transportTruck){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportTruckDAO().planToRemoveTransportTaskListWithDriver(transportTruck, driverId, this.emptyOptions());

				transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
				return transportTruck;
			}
	}
	//disconnect TransportTruck with belongs_to in TransportTask
	protected TransportTruck breakWithTransportTaskByBelongsTo(RetailscmUserContext userContext, String transportTruckId, String belongsToId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());

			synchronized(transportTruck){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTransportTruckDAO().planToRemoveTransportTaskListWithBelongsTo(transportTruck, belongsToId, this.emptyOptions());

				transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
				return transportTruck;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTransportTask(RetailscmUserContext userContext, String transportTruckId, String name, String start, Date beginTime, String endId, String driverId, String belongsToId, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTransportTruck(transportTruckId);

		
		userContext.getChecker().checkNameOfTransportTask(name);
		
		userContext.getChecker().checkStartOfTransportTask(start);
		
		userContext.getChecker().checkBeginTimeOfTransportTask(beginTime);
		
		userContext.getChecker().checkEndIdOfTransportTask(endId);
		
		userContext.getChecker().checkDriverIdOfTransportTask(driverId);
		
		userContext.getChecker().checkBelongsToIdOfTransportTask(belongsToId);
		
		userContext.getChecker().checkLatitudeOfTransportTask(latitude);
		
		userContext.getChecker().checkLongitudeOfTransportTask(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTruckManagerException.class);

	
	}
	public  TransportTruck addTransportTask(RetailscmUserContext userContext, String transportTruckId, String name, String start, Date beginTime, String endId, String driverId, String belongsToId, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTask(userContext,transportTruckId,name, start, beginTime, endId, driverId, belongsToId, latitude, longitude,tokensExpr);
		
		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, endId, driverId, belongsToId, latitude, longitude);
		
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());
		synchronized(transportTruck){ 
			//Will be good when the transportTruck loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTruck.addTransportTask( transportTask );		
			transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskProperties(RetailscmUserContext userContext, String transportTruckId,String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportTruck(transportTruckId);
		userContext.getChecker().checkIdOfTransportTask(id);
		
		userContext.getChecker().checkNameOfTransportTask( name);
		userContext.getChecker().checkStartOfTransportTask( start);
		userContext.getChecker().checkBeginTimeOfTransportTask( beginTime);
		userContext.getChecker().checkLatitudeOfTransportTask( latitude);
		userContext.getChecker().checkLongitudeOfTransportTask( longitude);

		userContext.getChecker().throwExceptionIfHasErrors(TransportTruckManagerException.class);
		
	}
	public  TransportTruck updateTransportTaskProperties(RetailscmUserContext userContext, String transportTruckId, String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskProperties(userContext,transportTruckId,id,name,start,beginTime,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListList()
				.searchTransportTaskListWith(TransportTask.ID_PROPERTY, "is", id).done();
		
		TransportTruck transportTruckToUpdate = loadTransportTruck(userContext, transportTruckId, options);
		
		if(transportTruckToUpdate.getTransportTaskList().isEmpty()){
			throw new TransportTruckManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTask item = transportTruckToUpdate.getTransportTaskList().first();
		
		item.updateName( name );
		item.updateStart( start );
		item.updateBeginTime( beginTime );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );

		
		//checkParamsForAddingTransportTask(userContext,transportTruckId,name, code, used,tokensExpr);
		TransportTruck transportTruck = saveTransportTruck(userContext, transportTruckToUpdate, tokens().withTransportTaskList().done());
		synchronized(transportTruck){ 
			return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTask createTransportTask(RetailscmUserContext userContext, String name, String start, Date beginTime, String endId, String driverId, String belongsToId, BigDecimal latitude, BigDecimal longitude) throws Exception{

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
	
	protected void checkParamsForRemovingTransportTaskList(RetailscmUserContext userContext, String transportTruckId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTransportTruck(transportTruckId);
		for(String transportTaskId: transportTaskIds){
			userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TransportTruckManagerException.class);
		
	}
	public  TransportTruck removeTransportTaskList(RetailscmUserContext userContext, String transportTruckId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskList(userContext, transportTruckId,  transportTaskIds, tokensExpr);
			
			
			TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());
			synchronized(transportTruck){ 
				//Will be good when the transportTruck loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTransportTruckDAO().planToRemoveTransportTaskList(transportTruck, transportTaskIds, allTokens());
				transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
				deleteRelationListInGraph(userContext, transportTruck.getTransportTaskList());
				return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTask(RetailscmUserContext userContext, String transportTruckId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportTruck( transportTruckId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportTruckManagerException.class);
	
	}
	public  TransportTruck removeTransportTask(RetailscmUserContext userContext, String transportTruckId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTask(userContext,transportTruckId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());
		synchronized(transportTruck){ 
			//Will be good when the transportTruck loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTruck.removeTransportTask( transportTask );		
			transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTask(RetailscmUserContext userContext, String transportTruckId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTransportTruck( transportTruckId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TransportTruckManagerException.class);
	
	}
	public  TransportTruck copyTransportTaskFrom(RetailscmUserContext userContext, String transportTruckId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTask(userContext,transportTruckId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());
		synchronized(transportTruck){ 
			//Will be good when the transportTruck loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			transportTruck.copyTransportTaskFrom( transportTask );		
			transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)transportTruck.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTask(RetailscmUserContext userContext, String transportTruckId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTransportTruck(transportTruckId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTruckManagerException.class);
	
	}
	
	public  TransportTruck updateTransportTask(RetailscmUserContext userContext, String transportTruckId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTask(userContext, transportTruckId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskList().searchTransportTaskListWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();
		
		
		
		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, loadTokens);
		
		synchronized(transportTruck){ 
			//Will be good when the transportTruck loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportTruck.removeTransportTask( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		
			TransportTask transportTask = transportTruck.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new TransportTruckManagerException(transportTask+" is NOT FOUND" );
			}
			
			transportTask.changeProperty(property, newValueExpr);
			
			transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
			return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, TransportTruck newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


