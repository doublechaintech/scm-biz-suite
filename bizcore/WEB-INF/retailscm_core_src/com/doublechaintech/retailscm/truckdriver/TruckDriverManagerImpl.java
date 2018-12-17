
package com.doublechaintech.retailscm.truckdriver;

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






public class TruckDriverManagerImpl extends CustomRetailscmCheckerManager implements TruckDriverManager {
	
	private static final String SERVICE_TYPE = "TruckDriver";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TruckDriverManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TruckDriverManagerException(message);

	}
	
	

 	protected TruckDriver saveTruckDriver(RetailscmUserContext userContext, TruckDriver truckDriver, String [] tokensExpr) throws Exception{	
 		//return getTruckDriverDAO().save(truckDriver, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTruckDriver(userContext, truckDriver, tokens);
 	}
 	
 	protected TruckDriver saveTruckDriverDetail(RetailscmUserContext userContext, TruckDriver truckDriver) throws Exception{	

 		
 		return saveTruckDriver(userContext, truckDriver, allTokens());
 	}
 	
 	public TruckDriver loadTruckDriver(RetailscmUserContext userContext, String truckDriverId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTruckDriver(truckDriverId);
		userContext.getChecker().throwExceptionIfHasErrors( TruckDriverManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TruckDriver truckDriver = loadTruckDriver( userContext, truckDriverId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,truckDriver, tokens);
 	}
 	
 	
 	 public TruckDriver searchTruckDriver(RetailscmUserContext userContext, String truckDriverId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTruckDriver(truckDriverId);
		userContext.getChecker().throwExceptionIfHasErrors( TruckDriverManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TruckDriver truckDriver = loadTruckDriver( userContext, truckDriverId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,truckDriver, tokens);
 	}
 	
 	

 	protected TruckDriver present(RetailscmUserContext userContext, TruckDriver truckDriver, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,truckDriver,tokens);
		
		
		TruckDriver  truckDriverToPresent = userContext.getDAOGroup().getTruckDriverDAO().present(truckDriver, tokens);
		
		List<BaseEntity> entityListToNaming = truckDriverToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTruckDriverDAO().alias(entityListToNaming);
		
		return  truckDriverToPresent;
		
		
	}
 
 	
 	
 	public TruckDriver loadTruckDriverDetail(RetailscmUserContext userContext, String truckDriverId) throws Exception{	
 		TruckDriver truckDriver = loadTruckDriver( userContext, truckDriverId, allTokens());
 		return present(userContext,truckDriver, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String truckDriverId) throws Exception{	
 		TruckDriver truckDriver = loadTruckDriver( userContext, truckDriverId, viewTokens());
 		return present(userContext,truckDriver, allTokens());
		
 	}
 	protected TruckDriver saveTruckDriver(RetailscmUserContext userContext, TruckDriver truckDriver, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTruckDriverDAO().save(truckDriver, tokens);
 	}
 	protected TruckDriver loadTruckDriver(RetailscmUserContext userContext, String truckDriverId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTruckDriver(truckDriverId);
		userContext.getChecker().throwExceptionIfHasErrors( TruckDriverManagerException.class);

 
 		return userContext.getDAOGroup().getTruckDriverDAO().load(truckDriverId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TruckDriver truckDriver, Map<String, Object> tokens){
		super.addActions(userContext, truckDriver, tokens);
		
		addAction(userContext, truckDriver, tokens,"@create","createTruckDriver","createTruckDriver/","main","primary");
		addAction(userContext, truckDriver, tokens,"@update","updateTruckDriver","updateTruckDriver/"+truckDriver.getId()+"/","main","primary");
		addAction(userContext, truckDriver, tokens,"@copy","cloneTruckDriver","cloneTruckDriver/"+truckDriver.getId()+"/","main","primary");
		
		addAction(userContext, truckDriver, tokens,"truck_driver.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+truckDriver.getId()+"/","main","primary");
		addAction(userContext, truckDriver, tokens,"truck_driver.addTransportTask","addTransportTask","addTransportTask/"+truckDriver.getId()+"/","transportTaskList","primary");
		addAction(userContext, truckDriver, tokens,"truck_driver.removeTransportTask","removeTransportTask","removeTransportTask/"+truckDriver.getId()+"/","transportTaskList","primary");
		addAction(userContext, truckDriver, tokens,"truck_driver.updateTransportTask","updateTransportTask","updateTransportTask/"+truckDriver.getId()+"/","transportTaskList","primary");
		addAction(userContext, truckDriver, tokens,"truck_driver.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+truckDriver.getId()+"/","transportTaskList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TruckDriver truckDriver, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TruckDriver createTruckDriver(RetailscmUserContext userContext,String name, String driverLicenseNumber, String contactNumber, String belongsToId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfTruckDriver(name);
		userContext.getChecker().checkDriverLicenseNumberOfTruckDriver(driverLicenseNumber);
		userContext.getChecker().checkContactNumberOfTruckDriver(contactNumber);
	
		userContext.getChecker().throwExceptionIfHasErrors(TruckDriverManagerException.class);


		TruckDriver truckDriver=createNewTruckDriver();	

		truckDriver.setName(name);
		truckDriver.setDriverLicenseNumber(driverLicenseNumber);
		truckDriver.setContactNumber(contactNumber);
			
		TransportFleet belongsTo = loadTransportFleet(userContext, belongsToId,emptyOptions());
		truckDriver.setBelongsTo(belongsTo);
		
		

		truckDriver = saveTruckDriver(userContext, truckDriver, emptyOptions());
		
		onNewInstanceCreated(userContext, truckDriver);
		return truckDriver;

		
	}
	protected TruckDriver createNewTruckDriver() 
	{
		
		return new TruckDriver();		
	}
	
	protected void checkParamsForUpdatingTruckDriver(RetailscmUserContext userContext,String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTruckDriver(truckDriverId);
		userContext.getChecker().checkVersionOfTruckDriver( truckDriverVersion);
		

		if(TruckDriver.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfTruckDriver(parseString(newValueExpr));
		}
		if(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkDriverLicenseNumberOfTruckDriver(parseString(newValueExpr));
		}
		if(TruckDriver.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfTruckDriver(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TruckDriverManagerException.class);
	
		
	}
	
	
	
	public TruckDriver clone(RetailscmUserContext userContext, String fromTruckDriverId) throws Exception{
		
		return userContext.getDAOGroup().getTruckDriverDAO().clone(fromTruckDriverId, this.allTokens());
	}
	
	public TruckDriver internalSaveTruckDriver(RetailscmUserContext userContext, TruckDriver truckDriver) throws Exception 
	{
		return internalSaveTruckDriver(userContext, truckDriver, allTokens());

	}
	public TruckDriver internalSaveTruckDriver(RetailscmUserContext userContext, TruckDriver truckDriver, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTruckDriver(userContext, truckDriverId, truckDriverVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(truckDriver){ 
			//will be good when the truckDriver loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TruckDriver.
			
			
			truckDriver = saveTruckDriver(userContext, truckDriver, options);
			return truckDriver;
			
		}

	}
	
	public TruckDriver updateTruckDriver(RetailscmUserContext userContext,String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTruckDriver(userContext, truckDriverId, truckDriverVersion, property, newValueExpr, tokensExpr);
		
		
		
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		if(truckDriver.getVersion() != truckDriverVersion){
			String message = "The target version("+truckDriver.getVersion()+") is not equals to version("+truckDriverVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(truckDriver){ 
			//will be good when the truckDriver loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TruckDriver.
			
			truckDriver.changeProperty(property, newValueExpr);
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().done());
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
			//return saveTruckDriver(userContext, truckDriver, tokens().done());
		}

	}
	
	public TruckDriver updateTruckDriverProperty(RetailscmUserContext userContext,String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTruckDriver(userContext, truckDriverId, truckDriverVersion, property, newValueExpr, tokensExpr);
		
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		if(truckDriver.getVersion() != truckDriverVersion){
			String message = "The target version("+truckDriver.getVersion()+") is not equals to version("+truckDriverVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(truckDriver){ 
			//will be good when the truckDriver loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TruckDriver.
			
			truckDriver.changeProperty(property, newValueExpr);
			
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().done());
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
			//return saveTruckDriver(userContext, truckDriver, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TruckDriverTokens tokens(){
		return TruckDriverTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TruckDriverTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransportTaskListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TruckDriverTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailscmUserContext userContext, String truckDriverId, String anotherBelongsToId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTruckDriver(truckDriverId);
 		userContext.getChecker().checkIdOfTransportFleet(anotherBelongsToId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TruckDriverManagerException.class);
 		
 	}
 	public TruckDriver transferToAnotherBelongsTo(RetailscmUserContext userContext, String truckDriverId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, truckDriverId,anotherBelongsToId);
 
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());	
		synchronized(truckDriver){
			//will be good when the truckDriver loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportFleet belongsTo = loadTransportFleet(userContext, anotherBelongsToId, emptyOptions());		
			truckDriver.updateBelongsTo(belongsTo);		
			truckDriver = saveTruckDriver(userContext, truckDriver, emptyOptions());
			
			return present(userContext,truckDriver, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateTransportFleet requestCandidateBelongsTo(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<TransportFleet> candidateList = userContext.getDAOGroup().getTransportFleetDAO().requestCandidateTransportFleetForTruckDriver(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected TransportFleet loadTransportFleet(RetailscmUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTransportFleetDAO().load(newBelongsToId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String truckDriverId, int truckDriverVersion) throws Exception {
		//deleteInternal(userContext, truckDriverId, truckDriverVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String truckDriverId, int truckDriverVersion) throws Exception{
			
		userContext.getDAOGroup().getTruckDriverDAO().delete(truckDriverId, truckDriverVersion);
	}
	
	public TruckDriver forgetByAll(RetailscmUserContext userContext, String truckDriverId, int truckDriverVersion) throws Exception {
		return forgetByAllInternal(userContext, truckDriverId, truckDriverVersion);		
	}
	protected TruckDriver forgetByAllInternal(RetailscmUserContext userContext,
			String truckDriverId, int truckDriverVersion) throws Exception{
			
		return userContext.getDAOGroup().getTruckDriverDAO().disconnectFromAll(truckDriverId, truckDriverVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TruckDriverManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTruckDriverDAO().deleteAll();
	}


	//disconnect TruckDriver with end in TransportTask
	protected TruckDriver breakWithTransportTaskByEnd(RetailscmUserContext userContext, String truckDriverId, String endId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());

			synchronized(truckDriver){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTruckDriverDAO().planToRemoveTransportTaskListWithEnd(truckDriver, endId, this.emptyOptions());

				truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
				return truckDriver;
			}
	}
	//disconnect TruckDriver with truck in TransportTask
	protected TruckDriver breakWithTransportTaskByTruck(RetailscmUserContext userContext, String truckDriverId, String truckId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());

			synchronized(truckDriver){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTruckDriverDAO().planToRemoveTransportTaskListWithTruck(truckDriver, truckId, this.emptyOptions());

				truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
				return truckDriver;
			}
	}
	//disconnect TruckDriver with belongs_to in TransportTask
	protected TruckDriver breakWithTransportTaskByBelongsTo(RetailscmUserContext userContext, String truckDriverId, String belongsToId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());

			synchronized(truckDriver){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTruckDriverDAO().planToRemoveTransportTaskListWithBelongsTo(truckDriver, belongsToId, this.emptyOptions());

				truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
				return truckDriver;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTransportTask(RetailscmUserContext userContext, String truckDriverId, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTruckDriver(truckDriverId);

		
		userContext.getChecker().checkNameOfTransportTask(name);
		
		userContext.getChecker().checkStartOfTransportTask(start);
		
		userContext.getChecker().checkBeginTimeOfTransportTask(beginTime);
		
		userContext.getChecker().checkEndIdOfTransportTask(endId);
		
		userContext.getChecker().checkTruckIdOfTransportTask(truckId);
		
		userContext.getChecker().checkBelongsToIdOfTransportTask(belongsToId);
		
		userContext.getChecker().checkLatitudeOfTransportTask(latitude);
		
		userContext.getChecker().checkLongitudeOfTransportTask(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(TruckDriverManagerException.class);

	
	}
	public  TruckDriver addTransportTask(RetailscmUserContext userContext, String truckDriverId, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTask(userContext,truckDriverId,name, start, beginTime, endId, truckId, belongsToId, latitude, longitude,tokensExpr);
		
		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, endId, truckId, belongsToId, latitude, longitude);
		
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		synchronized(truckDriver){ 
			//Will be good when the truckDriver loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			truckDriver.addTransportTask( transportTask );		
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, transportTask);
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskProperties(RetailscmUserContext userContext, String truckDriverId,String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTruckDriver(truckDriverId);
		userContext.getChecker().checkIdOfTransportTask(id);
		
		userContext.getChecker().checkNameOfTransportTask( name);
		userContext.getChecker().checkStartOfTransportTask( start);
		userContext.getChecker().checkBeginTimeOfTransportTask( beginTime);
		userContext.getChecker().checkLatitudeOfTransportTask( latitude);
		userContext.getChecker().checkLongitudeOfTransportTask( longitude);

		userContext.getChecker().throwExceptionIfHasErrors(TruckDriverManagerException.class);
		
	}
	public  TruckDriver updateTransportTaskProperties(RetailscmUserContext userContext, String truckDriverId, String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTransportTaskProperties(userContext,truckDriverId,id,name,start,beginTime,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListList()
				.searchTransportTaskListWith(TransportTask.ID_PROPERTY, "is", id).done();
		
		TruckDriver truckDriverToUpdate = loadTruckDriver(userContext, truckDriverId, options);
		
		if(truckDriverToUpdate.getTransportTaskList().isEmpty()){
			throw new TruckDriverManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}
		
		TransportTask item = truckDriverToUpdate.getTransportTaskList().first();
		
		item.updateName( name );
		item.updateStart( start );
		item.updateBeginTime( beginTime );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );

		
		//checkParamsForAddingTransportTask(userContext,truckDriverId,name, code, used,tokensExpr);
		TruckDriver truckDriver = saveTruckDriver(userContext, truckDriverToUpdate, tokens().withTransportTaskList().done());
		synchronized(truckDriver){ 
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected TransportTask createTransportTask(RetailscmUserContext userContext, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		transportTask.setStart(start);		
		transportTask.setBeginTime(beginTime);		
		RetailStore  end = new RetailStore();
		end.setId(endId);		
		transportTask.setEnd(end);		
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
	
	protected void checkParamsForRemovingTransportTaskList(RetailscmUserContext userContext, String truckDriverId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTruckDriver(truckDriverId);
		for(String transportTaskId: transportTaskIds){
			userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TruckDriverManagerException.class);
		
	}
	public  TruckDriver removeTransportTaskList(RetailscmUserContext userContext, String truckDriverId, 
			String transportTaskIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTransportTaskList(userContext, truckDriverId,  transportTaskIds, tokensExpr);
			
			
			TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
			synchronized(truckDriver){ 
				//Will be good when the truckDriver loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTruckDriverDAO().planToRemoveTransportTaskList(truckDriver, transportTaskIds, allTokens());
				truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
				deleteRelationListInGraph(userContext, truckDriver.getTransportTaskList());
				return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTransportTask(RetailscmUserContext userContext, String truckDriverId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTruckDriver( truckDriverId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TruckDriverManagerException.class);
	
	}
	public  TruckDriver removeTransportTask(RetailscmUserContext userContext, String truckDriverId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTask(userContext,truckDriverId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		synchronized(truckDriver){ 
			//Will be good when the truckDriver loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			truckDriver.removeTransportTask( transportTask );		
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTransportTask(RetailscmUserContext userContext, String truckDriverId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTruckDriver( truckDriverId);
		userContext.getChecker().checkIdOfTransportTask(transportTaskId);
		userContext.getChecker().checkVersionOfTransportTask(transportTaskVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TruckDriverManagerException.class);
	
	}
	public  TruckDriver copyTransportTaskFrom(RetailscmUserContext userContext, String truckDriverId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTask(userContext,truckDriverId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
		synchronized(truckDriver){ 
			//Will be good when the truckDriver loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			truckDriver.copyTransportTaskFrom( transportTask );		
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
			
			userContext.getManagerGroup().getTransportTaskManager().onNewInstanceCreated(userContext, (TransportTask)truckDriver.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTransportTask(RetailscmUserContext userContext, String truckDriverId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTruckDriver(truckDriverId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TruckDriverManagerException.class);
	
	}
	
	public  TruckDriver updateTransportTask(RetailscmUserContext userContext, String truckDriverId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTask(userContext, truckDriverId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTransportTaskList().searchTransportTaskListWith(TransportTask.ID_PROPERTY, "eq", transportTaskId).done();
		
		
		
		TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, loadTokens);
		
		synchronized(truckDriver){ 
			//Will be good when the truckDriver loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//truckDriver.removeTransportTask( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		
			TransportTask transportTask = truckDriver.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new TruckDriverManagerException(transportTask+" is NOT FOUND" );
			}
			
			transportTask.changeProperty(property, newValueExpr);
			
			truckDriver = saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
			return present(userContext,truckDriver, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, TruckDriver newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


