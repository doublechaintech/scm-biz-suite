
package com.doublechaintech.retailscm.transporttruck;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.transportfleet.CandidateTransportFleet;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;






public class TransportTruckManagerImpl extends CustomRetailscmCheckerManager implements TransportTruckManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = TransportTruckTokens.start().withTokenFromListName(listName).done();
		TransportTruck  transportTruck = (TransportTruck) this.loadTransportTruck(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = transportTruck.collectRefercencesFromLists();
		transportTruckDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, transportTruck, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new TransportTruckGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "TransportTruck";
	@Override
	public TransportTruckDAO daoOf(RetailscmUserContext userContext) {
		return transportTruckDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfTransportTruck(transportTruckId);
		checkerOf(userContext).throwExceptionIfHasErrors( TransportTruckManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportTruck transportTruck = loadTransportTruck( userContext, transportTruckId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTruck, tokens);
 	}
 	
 	
 	 public TransportTruck searchTransportTruck(RetailscmUserContext userContext, String transportTruckId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTransportTruck(transportTruckId);
		checkerOf(userContext).throwExceptionIfHasErrors( TransportTruckManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TransportTruck transportTruck = loadTransportTruck( userContext, transportTruckId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTruck, tokens);
 	}
 	
 	

 	protected TransportTruck present(RetailscmUserContext userContext, TransportTruck transportTruck, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportTruck,tokens);
		
		
		TransportTruck  transportTruckToPresent = transportTruckDaoOf(userContext).present(transportTruck, tokens);
		
		List<BaseEntity> entityListToNaming = transportTruckToPresent.collectRefercencesFromLists();
		transportTruckDaoOf(userContext).alias(entityListToNaming);
		
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
 		return transportTruckDaoOf(userContext).save(transportTruck, tokens);
 	}
 	protected TransportTruck loadTransportTruck(RetailscmUserContext userContext, String transportTruckId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfTransportTruck(transportTruckId);
		checkerOf(userContext).throwExceptionIfHasErrors( TransportTruckManagerException.class);

 
 		return transportTruckDaoOf(userContext).load(transportTruckId, tokens);
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
	
 	
 	
 
 	
 	

	public TransportTruck createTransportTruck(RetailscmUserContext userContext, String name,String plateNumber,String contactNumber,String vehicleLicenseNumber,String engineNumber,Date makeDate,String mileage,String bodyColor,String ownerId) throws Exception
	//public TransportTruck createTransportTruck(RetailscmUserContext userContext,String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor, String ownerId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfTransportTruck(name);
		checkerOf(userContext).checkPlateNumberOfTransportTruck(plateNumber);
		checkerOf(userContext).checkContactNumberOfTransportTruck(contactNumber);
		checkerOf(userContext).checkVehicleLicenseNumberOfTransportTruck(vehicleLicenseNumber);
		checkerOf(userContext).checkEngineNumberOfTransportTruck(engineNumber);
		checkerOf(userContext).checkMakeDateOfTransportTruck(makeDate);
		checkerOf(userContext).checkMileageOfTransportTruck(mileage);
		checkerOf(userContext).checkBodyColorOfTransportTruck(bodyColor);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTruckManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfTransportTruck(transportTruckId);
		checkerOf(userContext).checkVersionOfTransportTruck( transportTruckVersion);
		

		if(TransportTruck.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfTransportTruck(parseString(newValueExpr));
		
			
		}
		if(TransportTruck.PLATE_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPlateNumberOfTransportTruck(parseString(newValueExpr));
		
			
		}
		if(TransportTruck.CONTACT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkContactNumberOfTransportTruck(parseString(newValueExpr));
		
			
		}
		if(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkVehicleLicenseNumberOfTransportTruck(parseString(newValueExpr));
		
			
		}
		if(TransportTruck.ENGINE_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEngineNumberOfTransportTruck(parseString(newValueExpr));
		
			
		}
		if(TransportTruck.MAKE_DATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMakeDateOfTransportTruck(parseDate(newValueExpr));
		
			
		}
		if(TransportTruck.MILEAGE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMileageOfTransportTruck(parseString(newValueExpr));
		
			
		}
		if(TransportTruck.BODY_COLOR_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBodyColorOfTransportTruck(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTruckManagerException.class);


	}



	public TransportTruck clone(RetailscmUserContext userContext, String fromTransportTruckId) throws Exception{

		return transportTruckDaoOf(userContext).clone(fromTransportTruckId, this.allTokens());
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
			if (transportTruck.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportTruckTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String transportTruckId, String anotherOwnerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTransportTruck(transportTruckId);
 		checkerOf(userContext).checkIdOfTransportFleet(anotherOwnerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TransportTruckManagerException.class);

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
		SmartList<TransportFleet> candidateList = transportFleetDaoOf(userContext).requestCandidateTransportFleetForTransportTruck(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected TransportFleet loadTransportFleet(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{

 		return transportFleetDaoOf(userContext).load(newOwnerId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String transportTruckId, int transportTruckVersion) throws Exception {
		//deleteInternal(userContext, transportTruckId, transportTruckVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String transportTruckId, int transportTruckVersion) throws Exception{

		transportTruckDaoOf(userContext).delete(transportTruckId, transportTruckVersion);
	}

	public TransportTruck forgetByAll(RetailscmUserContext userContext, String transportTruckId, int transportTruckVersion) throws Exception {
		return forgetByAllInternal(userContext, transportTruckId, transportTruckVersion);
	}
	protected TransportTruck forgetByAllInternal(RetailscmUserContext userContext,
			String transportTruckId, int transportTruckVersion) throws Exception{

		return transportTruckDaoOf(userContext).disconnectFromAll(transportTruckId, transportTruckVersion);
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
		return transportTruckDaoOf(userContext).deleteAll();
	}


	//disconnect TransportTruck with end in TransportTask
	protected TransportTruck breakWithTransportTaskByEnd(RetailscmUserContext userContext, String transportTruckId, String endId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());

			synchronized(transportTruck){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				transportTruckDaoOf(userContext).planToRemoveTransportTaskListWithEnd(transportTruck, endId, this.emptyOptions());

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

				transportTruckDaoOf(userContext).planToRemoveTransportTaskListWithDriver(transportTruck, driverId, this.emptyOptions());

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

				transportTruckDaoOf(userContext).planToRemoveTransportTaskListWithBelongsTo(transportTruck, belongsToId, this.emptyOptions());

				transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
				return transportTruck;
			}
	}






	protected void checkParamsForAddingTransportTask(RetailscmUserContext userContext, String transportTruckId, String name, String start, Date beginTime, String endId, String driverId, String belongsToId, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfTransportTruck(transportTruckId);

		
		checkerOf(userContext).checkNameOfTransportTask(name);
		
		checkerOf(userContext).checkStartOfTransportTask(start);
		
		checkerOf(userContext).checkBeginTimeOfTransportTask(beginTime);
		
		checkerOf(userContext).checkEndIdOfTransportTask(endId);
		
		checkerOf(userContext).checkDriverIdOfTransportTask(driverId);
		
		checkerOf(userContext).checkBelongsToIdOfTransportTask(belongsToId);
		
		checkerOf(userContext).checkLatitudeOfTransportTask(latitude);
		
		checkerOf(userContext).checkLongitudeOfTransportTask(longitude);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTruckManagerException.class);


	}
	public  TransportTruck addTransportTask(RetailscmUserContext userContext, String transportTruckId, String name, String start, Date beginTime, String endId, String driverId, String belongsToId, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingTransportTask(userContext,transportTruckId,name, start, beginTime, endId, driverId, belongsToId, latitude, longitude,tokensExpr);

		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, endId, driverId, belongsToId, latitude, longitude);

		TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, emptyOptions());
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

		checkerOf(userContext).checkIdOfTransportTruck(transportTruckId);
		checkerOf(userContext).checkIdOfTransportTask(id);

		checkerOf(userContext).checkNameOfTransportTask( name);
		checkerOf(userContext).checkStartOfTransportTask( start);
		checkerOf(userContext).checkBeginTimeOfTransportTask( beginTime);
		checkerOf(userContext).checkLatitudeOfTransportTask( latitude);
		checkerOf(userContext).checkLongitudeOfTransportTask( longitude);

		checkerOf(userContext).throwExceptionIfHasErrors(TransportTruckManagerException.class);

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

		checkerOf(userContext).checkIdOfTransportTruck(transportTruckId);
		for(String transportTaskIdItem: transportTaskIds){
			checkerOf(userContext).checkIdOfTransportTask(transportTaskIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(TransportTruckManagerException.class);

	}
	public  TransportTruck removeTransportTaskList(RetailscmUserContext userContext, String transportTruckId,
			String transportTaskIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTransportTaskList(userContext, transportTruckId,  transportTaskIds, tokensExpr);


			TransportTruck transportTruck = loadTransportTruck(userContext, transportTruckId, allTokens());
			synchronized(transportTruck){
				//Will be good when the transportTruck loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				transportTruckDaoOf(userContext).planToRemoveTransportTaskList(transportTruck, transportTaskIds, allTokens());
				transportTruck = saveTransportTruck(userContext, transportTruck, tokens().withTransportTaskList().done());
				deleteRelationListInGraph(userContext, transportTruck.getTransportTaskList());
				return present(userContext,transportTruck, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTransportTask(RetailscmUserContext userContext, String transportTruckId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransportTruck( transportTruckId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTruckManagerException.class);

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
		
		checkerOf(userContext).checkIdOfTransportTruck( transportTruckId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTruckManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfTransportTruck(transportTruckId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfTransportTask(parseString(newValueExpr));
		
		}
		
		if(TransportTask.START_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkStartOfTransportTask(parseString(newValueExpr));
		
		}
		
		if(TransportTask.BEGIN_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBeginTimeOfTransportTask(parseDate(newValueExpr));
		
		}
		
		if(TransportTask.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfTransportTask(parseBigDecimal(newValueExpr));
		
		}
		
		if(TransportTask.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfTransportTask(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTruckManagerException.class);

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

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   TransportTruck newTransportTruck = this.createTransportTruck(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newTransportTruck
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, TransportTruck.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<TransportTruck> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<TransportFleet> ownerList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TransportFleet.class);
		userContext.getDAOGroup().enhanceList(ownerList, TransportFleet.class);


    }
	
	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception {
		return listPageByOwner(userContext, ownerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception {
		SmartList<TransportTruck> list = transportTruckDaoOf(userContext).findTransportTruckByOwner(ownerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(TransportTruck.class);
		page.setContainerObject(TransportFleet.withId(ownerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("运输车列表");
		page.setRequestName("listByOwner");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByOwner/%s/",  getBeanName(), ownerId)));

		page.assemblerContent(userContext, "listByOwner");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String transportTruckId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getTransportTruckDetailScope().clone();
		TransportTruck merchantObj = (TransportTruck) this.view(userContext, transportTruckId);
    String merchantObjId = transportTruckId;
    String linkToUrl =	"transportTruckManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "运输车"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-plateNumber")
				    .put("fieldName", "plateNumber")
				    .put("label", "车牌号码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("plateNumber", merchantObj.getPlateNumber());

		propList.add(
				MapUtil.put("id", "4-contactNumber")
				    .put("fieldName", "contactNumber")
				    .put("label", "联系电话")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("contactNumber", merchantObj.getContactNumber());

		propList.add(
				MapUtil.put("id", "5-vehicleLicenseNumber")
				    .put("fieldName", "vehicleLicenseNumber")
				    .put("label", "汽车牌照号码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("vehicleLicenseNumber", merchantObj.getVehicleLicenseNumber());

		propList.add(
				MapUtil.put("id", "6-engineNumber")
				    .put("fieldName", "engineNumber")
				    .put("label", "发动机号")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("engineNumber", merchantObj.getEngineNumber());

		propList.add(
				MapUtil.put("id", "7-makeDate")
				    .put("fieldName", "makeDate")
				    .put("label", "制造日期")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("makeDate", merchantObj.getMakeDate());

		propList.add(
				MapUtil.put("id", "8-mileage")
				    .put("fieldName", "mileage")
				    .put("label", "里程")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("mileage", merchantObj.getMileage());

		propList.add(
				MapUtil.put("id", "9-bodyColor")
				    .put("fieldName", "bodyColor")
				    .put("label", "车身颜色")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("bodyColor", merchantObj.getBodyColor());

		propList.add(
				MapUtil.put("id", "10-owner")
				    .put("fieldName", "owner")
				    .put("label", "业主")
				    .put("type", "auto")
				    .put("linkToUrl", "transportFleetManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("owner", merchantObj.getOwner());

		//处理 sectionList

		//处理Section：transportTaskListSection
		Map transportTaskListSection = ListofUtils.buildSection(
		    "transportTaskListSection",
		    "运输任务列表",
		    null,
		    "",
		    "__no_group",
		    "transportTaskManager/listByTruck/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(transportTaskListSection);

		result.put("transportTaskListSection", ListofUtils.toShortList(merchantObj.getTransportTaskList(), "transportTask"));
		vscope.field("transportTaskListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( TransportTask.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

}


