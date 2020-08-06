
package com.doublechaintech.retailscm.transporttask;

import java.util.*;
import java.math.BigDecimal;
import com.terapico.caf.baseelement.PlainText;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;



import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;

import com.doublechaintech.retailscm.retailstore.CandidateRetailStore;
import com.doublechaintech.retailscm.transporttruck.CandidateTransportTruck;
import com.doublechaintech.retailscm.truckdriver.CandidateTruckDriver;
import com.doublechaintech.retailscm.transportfleet.CandidateTransportFleet;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;






public class TransportTaskManagerImpl extends CustomRetailscmCheckerManager implements TransportTaskManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = TransportTaskTokens.start().withTokenFromListName(listName).done();
		TransportTask  transportTask = (TransportTask) this.loadTransportTask(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = transportTask.collectRefercencesFromLists();
		transportTaskDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, transportTask, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new TransportTaskGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "TransportTask";
	@Override
	public TransportTaskDAO daoOf(RetailscmUserContext userContext) {
		return transportTaskDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws TransportTaskManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new TransportTaskManagerException(message);

	}



 	protected TransportTask saveTransportTask(RetailscmUserContext userContext, TransportTask transportTask, String [] tokensExpr) throws Exception{	
 		//return getTransportTaskDAO().save(transportTask, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportTask(userContext, transportTask, tokens);
 	}
 	
 	protected TransportTask saveTransportTaskDetail(RetailscmUserContext userContext, TransportTask transportTask) throws Exception{	

 		
 		return saveTransportTask(userContext, transportTask, allTokens());
 	}
 	
 	public TransportTask loadTransportTask(RetailscmUserContext userContext, String transportTaskId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).throwExceptionIfHasErrors( TransportTaskManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportTask transportTask = loadTransportTask( userContext, transportTaskId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTask, tokens);
 	}
 	
 	
 	 public TransportTask searchTransportTask(RetailscmUserContext userContext, String transportTaskId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).throwExceptionIfHasErrors( TransportTaskManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		TransportTask transportTask = loadTransportTask( userContext, transportTaskId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTask, tokens);
 	}
 	
 	

 	protected TransportTask present(RetailscmUserContext userContext, TransportTask transportTask, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportTask,tokens);
		
		
		TransportTask  transportTaskToPresent = transportTaskDaoOf(userContext).present(transportTask, tokens);
		
		List<BaseEntity> entityListToNaming = transportTaskToPresent.collectRefercencesFromLists();
		transportTaskDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,transportTask,tokens);
		
		return  transportTaskToPresent;
		
		
	}
 
 	
 	
 	public TransportTask loadTransportTaskDetail(RetailscmUserContext userContext, String transportTaskId) throws Exception{	
 		TransportTask transportTask = loadTransportTask( userContext, transportTaskId, allTokens());
 		return present(userContext,transportTask, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String transportTaskId) throws Exception{	
 		TransportTask transportTask = loadTransportTask( userContext, transportTaskId, viewTokens());
 		return present(userContext,transportTask, allTokens());
		
 	}
 	protected TransportTask saveTransportTask(RetailscmUserContext userContext, TransportTask transportTask, Map<String,Object>tokens) throws Exception{	
 		return transportTaskDaoOf(userContext).save(transportTask, tokens);
 	}
 	protected TransportTask loadTransportTask(RetailscmUserContext userContext, String transportTaskId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).throwExceptionIfHasErrors( TransportTaskManagerException.class);

 
 		return transportTaskDaoOf(userContext).load(transportTaskId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TransportTask transportTask, Map<String, Object> tokens){
		super.addActions(userContext, transportTask, tokens);
		
		addAction(userContext, transportTask, tokens,"@create","createTransportTask","createTransportTask/","main","primary");
		addAction(userContext, transportTask, tokens,"@update","updateTransportTask","updateTransportTask/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"@copy","cloneTransportTask","cloneTransportTask/"+transportTask.getId()+"/","main","primary");
		
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_end","transferToAnotherEnd","transferToAnotherEnd/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_driver","transferToAnotherDriver","transferToAnotherDriver/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_truck","transferToAnotherTruck","transferToAnotherTruck/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.addGoods","addGoods","addGoods/"+transportTask.getId()+"/","goodsList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.removeGoods","removeGoods","removeGoods/"+transportTask.getId()+"/","goodsList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.updateGoods","updateGoods","updateGoods/"+transportTask.getId()+"/","goodsList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+transportTask.getId()+"/","goodsList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.addTransportTaskTrack","addTransportTaskTrack","addTransportTaskTrack/"+transportTask.getId()+"/","transportTaskTrackList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.removeTransportTaskTrack","removeTransportTaskTrack","removeTransportTaskTrack/"+transportTask.getId()+"/","transportTaskTrackList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.updateTransportTaskTrack","updateTransportTaskTrack","updateTransportTaskTrack/"+transportTask.getId()+"/","transportTaskTrackList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.copyTransportTaskTrackFrom","copyTransportTaskTrackFrom","copyTransportTaskTrackFrom/"+transportTask.getId()+"/","transportTaskTrackList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TransportTask transportTask, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public TransportTask createTransportTask(RetailscmUserContext userContext, String name,String start,Date beginTime,String endId,String driverId,String truckId,String belongsToId,BigDecimal latitude,BigDecimal longitude) throws Exception
	//public TransportTask createTransportTask(RetailscmUserContext userContext,String name, String start, Date beginTime, String endId, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfTransportTask(name);
		checkerOf(userContext).checkStartOfTransportTask(start);
		checkerOf(userContext).checkBeginTimeOfTransportTask(beginTime);
		checkerOf(userContext).checkLatitudeOfTransportTask(latitude);
		checkerOf(userContext).checkLongitudeOfTransportTask(longitude);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);


		TransportTask transportTask=createNewTransportTask();	

		transportTask.setName(name);
		transportTask.setStart(start);
		transportTask.setBeginTime(beginTime);
			
		RetailStore end = loadRetailStore(userContext, endId,emptyOptions());
		transportTask.setEnd(end);
		
		
			
		TruckDriver driver = loadTruckDriver(userContext, driverId,emptyOptions());
		transportTask.setDriver(driver);
		
		
			
		TransportTruck truck = loadTransportTruck(userContext, truckId,emptyOptions());
		transportTask.setTruck(truck);
		
		
			
		TransportFleet belongsTo = loadTransportFleet(userContext, belongsToId,emptyOptions());
		transportTask.setBelongsTo(belongsTo);
		
		
		transportTask.setLatitude(latitude);
		transportTask.setLongitude(longitude);

		transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
		
		onNewInstanceCreated(userContext, transportTask);
		return transportTask;


	}
	protected TransportTask createNewTransportTask()
	{

		return new TransportTask();
	}

	protected void checkParamsForUpdatingTransportTask(RetailscmUserContext userContext,String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask( transportTaskVersion);
		

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
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);


	}



	public TransportTask clone(RetailscmUserContext userContext, String fromTransportTaskId) throws Exception{

		return transportTaskDaoOf(userContext).clone(fromTransportTaskId, this.allTokens());
	}

	public TransportTask internalSaveTransportTask(RetailscmUserContext userContext, TransportTask transportTask) throws Exception
	{
		return internalSaveTransportTask(userContext, transportTask, allTokens());

	}
	public TransportTask internalSaveTransportTask(RetailscmUserContext userContext, TransportTask transportTask, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingTransportTask(userContext, transportTaskId, transportTaskVersion, property, newValueExpr, tokensExpr);


		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTask.
			if (transportTask.isChanged()){
			
			}
			transportTask = saveTransportTask(userContext, transportTask, options);
			return transportTask;

		}

	}

	public TransportTask updateTransportTask(RetailscmUserContext userContext,String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportTask(userContext, transportTaskId, transportTaskVersion, property, newValueExpr, tokensExpr);



		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		if(transportTask.getVersion() != transportTaskVersion){
			String message = "The target version("+transportTask.getVersion()+") is not equals to version("+transportTaskVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTask.
			
			transportTask.changeProperty(property, newValueExpr);
			transportTask = saveTransportTask(userContext, transportTask, tokens().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
			//return saveTransportTask(userContext, transportTask, tokens().done());
		}

	}

	public TransportTask updateTransportTaskProperty(RetailscmUserContext userContext,String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportTask(userContext, transportTaskId, transportTaskVersion, property, newValueExpr, tokensExpr);

		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		if(transportTask.getVersion() != transportTaskVersion){
			String message = "The target version("+transportTask.getVersion()+") is not equals to version("+transportTaskVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTask.

			transportTask.changeProperty(property, newValueExpr);
			
			transportTask = saveTransportTask(userContext, transportTask, tokens().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
			//return saveTransportTask(userContext, transportTask, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected TransportTaskTokens tokens(){
		return TransportTaskTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportTaskTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsListWith("id","desc")
		.sortTransportTaskTrackListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportTaskTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherEnd(RetailscmUserContext userContext, String transportTaskId, String anotherEndId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
 		checkerOf(userContext).checkIdOfRetailStore(anotherEndId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

 	}
 	public TransportTask transferToAnotherEnd(RetailscmUserContext userContext, String transportTaskId, String anotherEndId) throws Exception
 	{
 		checkParamsForTransferingAnotherEnd(userContext, transportTaskId,anotherEndId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStore end = loadRetailStore(userContext, anotherEndId, emptyOptions());		
			transportTask.updateEnd(end);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}

	


	public CandidateRetailStore requestCandidateEnd(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStore result = new CandidateRetailStore();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStore> candidateList = retailStoreDaoOf(userContext).requestCandidateRetailStoreForTransportTask(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherDriver(RetailscmUserContext userContext, String transportTaskId, String anotherDriverId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
 		checkerOf(userContext).checkIdOfTruckDriver(anotherDriverId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

 	}
 	public TransportTask transferToAnotherDriver(RetailscmUserContext userContext, String transportTaskId, String anotherDriverId) throws Exception
 	{
 		checkParamsForTransferingAnotherDriver(userContext, transportTaskId,anotherDriverId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TruckDriver driver = loadTruckDriver(userContext, anotherDriverId, emptyOptions());		
			transportTask.updateDriver(driver);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}

	


	public CandidateTruckDriver requestCandidateDriver(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTruckDriver result = new CandidateTruckDriver();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TruckDriver> candidateList = truckDriverDaoOf(userContext).requestCandidateTruckDriverForTransportTask(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherTruck(RetailscmUserContext userContext, String transportTaskId, String anotherTruckId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
 		checkerOf(userContext).checkIdOfTransportTruck(anotherTruckId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

 	}
 	public TransportTask transferToAnotherTruck(RetailscmUserContext userContext, String transportTaskId, String anotherTruckId) throws Exception
 	{
 		checkParamsForTransferingAnotherTruck(userContext, transportTaskId,anotherTruckId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportTruck truck = loadTransportTruck(userContext, anotherTruckId, emptyOptions());		
			transportTask.updateTruck(truck);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}

	


	public CandidateTransportTruck requestCandidateTruck(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTransportTruck result = new CandidateTransportTruck();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TransportTruck> candidateList = transportTruckDaoOf(userContext).requestCandidateTransportTruckForTransportTask(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherBelongsTo(RetailscmUserContext userContext, String transportTaskId, String anotherBelongsToId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
 		checkerOf(userContext).checkIdOfTransportFleet(anotherBelongsToId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

 	}
 	public TransportTask transferToAnotherBelongsTo(RetailscmUserContext userContext, String transportTaskId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, transportTaskId,anotherBelongsToId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportFleet belongsTo = loadTransportFleet(userContext, anotherBelongsToId, emptyOptions());		
			transportTask.updateBelongsTo(belongsTo);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
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
		SmartList<TransportFleet> candidateList = transportFleetDaoOf(userContext).requestCandidateTransportFleetForTransportTask(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected TransportFleet loadTransportFleet(RetailscmUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{

 		return transportFleetDaoOf(userContext).load(newBelongsToId, options);
 	}
 	


	

 	protected TruckDriver loadTruckDriver(RetailscmUserContext userContext, String newDriverId, Map<String,Object> options) throws Exception
 	{

 		return truckDriverDaoOf(userContext).load(newDriverId, options);
 	}
 	


	

 	protected RetailStore loadRetailStore(RetailscmUserContext userContext, String newEndId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreDaoOf(userContext).load(newEndId, options);
 	}
 	


	

 	protected TransportTruck loadTransportTruck(RetailscmUserContext userContext, String newTruckId, Map<String,Object> options) throws Exception
 	{

 		return transportTruckDaoOf(userContext).load(newTruckId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String transportTaskId, int transportTaskVersion) throws Exception {
		//deleteInternal(userContext, transportTaskId, transportTaskVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String transportTaskId, int transportTaskVersion) throws Exception{

		transportTaskDaoOf(userContext).delete(transportTaskId, transportTaskVersion);
	}

	public TransportTask forgetByAll(RetailscmUserContext userContext, String transportTaskId, int transportTaskVersion) throws Exception {
		return forgetByAllInternal(userContext, transportTaskId, transportTaskVersion);
	}
	protected TransportTask forgetByAllInternal(RetailscmUserContext userContext,
			String transportTaskId, int transportTaskVersion) throws Exception{

		return transportTaskDaoOf(userContext).disconnectFromAll(transportTaskId, transportTaskVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportTaskManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return transportTaskDaoOf(userContext).deleteAll();
	}


	//disconnect TransportTask with sku in Goods
	protected TransportTask breakWithGoodsBySku(RetailscmUserContext userContext, String transportTaskId, String skuId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());

			synchronized(transportTask){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				transportTaskDaoOf(userContext).planToRemoveGoodsListWithSku(transportTask, skuId, this.emptyOptions());

				transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
				return transportTask;
			}
	}
	//disconnect TransportTask with receiving_space in Goods
	protected TransportTask breakWithGoodsByReceivingSpace(RetailscmUserContext userContext, String transportTaskId, String receivingSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());

			synchronized(transportTask){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				transportTaskDaoOf(userContext).planToRemoveGoodsListWithReceivingSpace(transportTask, receivingSpaceId, this.emptyOptions());

				transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
				return transportTask;
			}
	}
	//disconnect TransportTask with goods_allocation in Goods
	protected TransportTask breakWithGoodsByGoodsAllocation(RetailscmUserContext userContext, String transportTaskId, String goodsAllocationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());

			synchronized(transportTask){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				transportTaskDaoOf(userContext).planToRemoveGoodsListWithGoodsAllocation(transportTask, goodsAllocationId, this.emptyOptions());

				transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
				return transportTask;
			}
	}
	//disconnect TransportTask with smart_pallet in Goods
	protected TransportTask breakWithGoodsBySmartPallet(RetailscmUserContext userContext, String transportTaskId, String smartPalletId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());

			synchronized(transportTask){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				transportTaskDaoOf(userContext).planToRemoveGoodsListWithSmartPallet(transportTask, smartPalletId, this.emptyOptions());

				transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
				return transportTask;
			}
	}
	//disconnect TransportTask with shipping_space in Goods
	protected TransportTask breakWithGoodsByShippingSpace(RetailscmUserContext userContext, String transportTaskId, String shippingSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());

			synchronized(transportTask){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				transportTaskDaoOf(userContext).planToRemoveGoodsListWithShippingSpace(transportTask, shippingSpaceId, this.emptyOptions());

				transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
				return transportTask;
			}
	}
	//disconnect TransportTask with retail_store in Goods
	protected TransportTask breakWithGoodsByRetailStore(RetailscmUserContext userContext, String transportTaskId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());

			synchronized(transportTask){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				transportTaskDaoOf(userContext).planToRemoveGoodsListWithRetailStore(transportTask, retailStoreId, this.emptyOptions());

				transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
				return transportTask;
			}
	}
	//disconnect TransportTask with biz_order in Goods
	protected TransportTask breakWithGoodsByBizOrder(RetailscmUserContext userContext, String transportTaskId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());

			synchronized(transportTask){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				transportTaskDaoOf(userContext).planToRemoveGoodsListWithBizOrder(transportTask, bizOrderId, this.emptyOptions());

				transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
				return transportTask;
			}
	}
	//disconnect TransportTask with retail_store_order in Goods
	protected TransportTask breakWithGoodsByRetailStoreOrder(RetailscmUserContext userContext, String transportTaskId, String retailStoreOrderId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());

			synchronized(transportTask){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				transportTaskDaoOf(userContext).planToRemoveGoodsListWithRetailStoreOrder(transportTask, retailStoreOrderId, this.emptyOptions());

				transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
				return transportTask;
			}
	}






	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String transportTaskId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfTransportTask(transportTaskId);

		
		checkerOf(userContext).checkNameOfGoods(name);
		
		checkerOf(userContext).checkRfidOfGoods(rfid);
		
		checkerOf(userContext).checkUomOfGoods(uom);
		
		checkerOf(userContext).checkMaxPackageOfGoods(maxPackage);
		
		checkerOf(userContext).checkExpireTimeOfGoods(expireTime);
		
		checkerOf(userContext).checkSkuIdOfGoods(skuId);
		
		checkerOf(userContext).checkReceivingSpaceIdOfGoods(receivingSpaceId);
		
		checkerOf(userContext).checkGoodsAllocationIdOfGoods(goodsAllocationId);
		
		checkerOf(userContext).checkSmartPalletIdOfGoods(smartPalletId);
		
		checkerOf(userContext).checkShippingSpaceIdOfGoods(shippingSpaceId);
		
		checkerOf(userContext).checkRetailStoreIdOfGoods(retailStoreId);
		
		checkerOf(userContext).checkBizOrderIdOfGoods(bizOrderId);
		
		checkerOf(userContext).checkRetailStoreOrderIdOfGoods(retailStoreOrderId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);


	}
	public  TransportTask addGoods(RetailscmUserContext userContext, String transportTaskId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingGoods(userContext,transportTaskId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);

		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, retailStoreId, bizOrderId, retailStoreOrderId);

		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, emptyOptions());
		synchronized(transportTask){
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTask.addGoods( goods );
			transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
			
			goodsManagerOf(userContext).onNewInstanceCreated(userContext, goods);
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String transportTaskId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkIdOfGoods(id);

		checkerOf(userContext).checkNameOfGoods( name);
		checkerOf(userContext).checkRfidOfGoods( rfid);
		checkerOf(userContext).checkUomOfGoods( uom);
		checkerOf(userContext).checkMaxPackageOfGoods( maxPackage);
		checkerOf(userContext).checkExpireTimeOfGoods( expireTime);

		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

	}
	public  TransportTask updateGoodsProperties(RetailscmUserContext userContext, String transportTaskId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsProperties(userContext,transportTaskId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, tokens().is(), id).done();

		TransportTask transportTaskToUpdate = loadTransportTask(userContext, transportTaskId, options);

		if(transportTaskToUpdate.getGoodsList().isEmpty()){
			throw new TransportTaskManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}

		Goods item = transportTaskToUpdate.getGoodsList().first();
		beforeUpdateGoodsProperties(userContext,item, transportTaskId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);
		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );


		//checkParamsForAddingGoods(userContext,transportTaskId,name, code, used,tokensExpr);
		TransportTask transportTask = saveTransportTask(userContext, transportTaskToUpdate, tokens().withGoodsList().done());
		synchronized(transportTask){
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateGoodsProperties(RetailscmUserContext userContext, Goods item, String transportTaskId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected Goods createGoods(RetailscmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

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
		RetailStore  retailStore = new RetailStore();
		retailStore.setId(retailStoreId);		
		goods.setRetailStore(retailStore);		
		SupplyOrder  bizOrder = new SupplyOrder();
		bizOrder.setId(bizOrderId);		
		goods.setBizOrder(bizOrder);		
		RetailStoreOrder  retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(retailStoreOrderId);		
		goods.setRetailStoreOrder(retailStoreOrder);
	
		
		return goods;


	}

	protected Goods createIndexedGoods(String id, int version){

		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(version);
		return goods;

	}

	protected void checkParamsForRemovingGoodsList(RetailscmUserContext userContext, String transportTaskId,
			String goodsIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		for(String goodsIdItem: goodsIds){
			checkerOf(userContext).checkIdOfGoods(goodsIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

	}
	public  TransportTask removeGoodsList(RetailscmUserContext userContext, String transportTaskId,
			String goodsIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsList(userContext, transportTaskId,  goodsIds, tokensExpr);


			TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
			synchronized(transportTask){
				//Will be good when the transportTask loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				transportTaskDaoOf(userContext).planToRemoveGoodsList(transportTask, goodsIds, allTokens());
				transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, transportTask.getGoodsList());
				return present(userContext,transportTask, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String transportTaskId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransportTask( transportTaskId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

	}
	public  TransportTask removeGoods(RetailscmUserContext userContext, String transportTaskId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingGoods(userContext,transportTaskId, goodsId, goodsVersion,tokensExpr);

		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTask.removeGoods( goods );
			transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingGoods(RetailscmUserContext userContext, String transportTaskId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransportTask( transportTaskId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

	}
	public  TransportTask copyGoodsFrom(RetailscmUserContext userContext, String transportTaskId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingGoods(userContext,transportTaskId, goodsId, goodsVersion,tokensExpr);

		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			transportTask.copyGoodsFrom( goods );
			transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
			
			goodsManagerOf(userContext).onNewInstanceCreated(userContext, (Goods)transportTask.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String transportTaskId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);


		if(Goods.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.RFID_PROPERTY.equals(property)){
			checkerOf(userContext).checkRfidOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.UOM_PROPERTY.equals(property)){
			checkerOf(userContext).checkUomOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.MAX_PACKAGE_PROPERTY.equals(property)){
			checkerOf(userContext).checkMaxPackageOfGoods(parseInt(newValueExpr));
		}
		
		if(Goods.EXPIRE_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkExpireTimeOfGoods(parseDate(newValueExpr));
		}
		

		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

	}

	public  TransportTask updateGoods(RetailscmUserContext userContext, String transportTaskId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingGoods(userContext, transportTaskId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, tokens().equals(), goodsId).done();



		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, loadTokens);

		synchronized(transportTask){
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportTask.removeGoods( goods );
			//make changes to AcceleraterAccount.
			Goods goodsIdVersionKey = createIndexedGoods(goodsId, goodsVersion);

			Goods goods = transportTask.findTheGoods(goodsIdVersionKey);
			if(goods == null){
				throw new TransportTaskManagerException(goodsId+" is NOT FOUND" );
			}

			beforeUpdateGoods(userContext, goods, transportTaskId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
			goods.changeProperty(property, newValueExpr);
			
			transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateGoods(RetailscmUserContext userContext, Goods existed, String transportTaskId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingTransportTaskTrack(RetailscmUserContext userContext, String transportTaskId, Date trackTime, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfTransportTask(transportTaskId);

		
		checkerOf(userContext).checkTrackTimeOfTransportTaskTrack(trackTime);
		
		checkerOf(userContext).checkLatitudeOfTransportTaskTrack(latitude);
		
		checkerOf(userContext).checkLongitudeOfTransportTaskTrack(longitude);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);


	}
	public  TransportTask addTransportTaskTrack(RetailscmUserContext userContext, String transportTaskId, Date trackTime, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingTransportTaskTrack(userContext,transportTaskId,trackTime, latitude, longitude,tokensExpr);

		TransportTaskTrack transportTaskTrack = createTransportTaskTrack(userContext,trackTime, latitude, longitude);

		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, emptyOptions());
		synchronized(transportTask){
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTask.addTransportTaskTrack( transportTaskTrack );
			transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
			
			transportTaskTrackManagerOf(userContext).onNewInstanceCreated(userContext, transportTaskTrack);
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskTrackProperties(RetailscmUserContext userContext, String transportTaskId,String id,Date trackTime,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkIdOfTransportTaskTrack(id);

		checkerOf(userContext).checkTrackTimeOfTransportTaskTrack( trackTime);
		checkerOf(userContext).checkLatitudeOfTransportTaskTrack( latitude);
		checkerOf(userContext).checkLongitudeOfTransportTaskTrack( longitude);

		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

	}
	public  TransportTask updateTransportTaskTrackProperties(RetailscmUserContext userContext, String transportTaskId, String id,Date trackTime,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportTaskTrackProperties(userContext,transportTaskId,id,trackTime,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskTrackListList()
				.searchTransportTaskTrackListWith(TransportTaskTrack.ID_PROPERTY, tokens().is(), id).done();

		TransportTask transportTaskToUpdate = loadTransportTask(userContext, transportTaskId, options);

		if(transportTaskToUpdate.getTransportTaskTrackList().isEmpty()){
			throw new TransportTaskManagerException("TransportTaskTrack is NOT FOUND with id: '"+id+"'");
		}

		TransportTaskTrack item = transportTaskToUpdate.getTransportTaskTrackList().first();
		beforeUpdateTransportTaskTrackProperties(userContext,item, transportTaskId,id,trackTime,latitude,longitude,tokensExpr);
		item.updateTrackTime( trackTime );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );


		//checkParamsForAddingTransportTaskTrack(userContext,transportTaskId,name, code, used,tokensExpr);
		TransportTask transportTask = saveTransportTask(userContext, transportTaskToUpdate, tokens().withTransportTaskTrackList().done());
		synchronized(transportTask){
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateTransportTaskTrackProperties(RetailscmUserContext userContext, TransportTaskTrack item, String transportTaskId, String id,Date trackTime,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected TransportTaskTrack createTransportTaskTrack(RetailscmUserContext userContext, Date trackTime, BigDecimal latitude, BigDecimal longitude) throws Exception{

		TransportTaskTrack transportTaskTrack = new TransportTaskTrack();
		
		
		transportTaskTrack.setTrackTime(trackTime);		
		transportTaskTrack.setLatitude(latitude);		
		transportTaskTrack.setLongitude(longitude);
	
		
		return transportTaskTrack;


	}

	protected TransportTaskTrack createIndexedTransportTaskTrack(String id, int version){

		TransportTaskTrack transportTaskTrack = new TransportTaskTrack();
		transportTaskTrack.setId(id);
		transportTaskTrack.setVersion(version);
		return transportTaskTrack;

	}

	protected void checkParamsForRemovingTransportTaskTrackList(RetailscmUserContext userContext, String transportTaskId,
			String transportTaskTrackIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		for(String transportTaskTrackIdItem: transportTaskTrackIds){
			checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

	}
	public  TransportTask removeTransportTaskTrackList(RetailscmUserContext userContext, String transportTaskId,
			String transportTaskTrackIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTransportTaskTrackList(userContext, transportTaskId,  transportTaskTrackIds, tokensExpr);


			TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
			synchronized(transportTask){
				//Will be good when the transportTask loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				transportTaskDaoOf(userContext).planToRemoveTransportTaskTrackList(transportTask, transportTaskTrackIds, allTokens());
				transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
				deleteRelationListInGraph(userContext, transportTask.getTransportTaskTrackList());
				return present(userContext,transportTask, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTransportTaskTrack(RetailscmUserContext userContext, String transportTaskId,
		String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransportTask( transportTaskId);
		checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);
		checkerOf(userContext).checkVersionOfTransportTaskTrack(transportTaskTrackVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

	}
	public  TransportTask removeTransportTaskTrack(RetailscmUserContext userContext, String transportTaskId,
		String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingTransportTaskTrack(userContext,transportTaskId, transportTaskTrackId, transportTaskTrackVersion,tokensExpr);

		TransportTaskTrack transportTaskTrack = createIndexedTransportTaskTrack(transportTaskTrackId, transportTaskTrackVersion);
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTask.removeTransportTaskTrack( transportTaskTrack );
			transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
			deleteRelationInGraph(userContext, transportTaskTrack);
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingTransportTaskTrack(RetailscmUserContext userContext, String transportTaskId,
		String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransportTask( transportTaskId);
		checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);
		checkerOf(userContext).checkVersionOfTransportTaskTrack(transportTaskTrackVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

	}
	public  TransportTask copyTransportTaskTrackFrom(RetailscmUserContext userContext, String transportTaskId,
		String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingTransportTaskTrack(userContext,transportTaskId, transportTaskTrackId, transportTaskTrackVersion,tokensExpr);

		TransportTaskTrack transportTaskTrack = createIndexedTransportTaskTrack(transportTaskTrackId, transportTaskTrackVersion);
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			transportTask.copyTransportTaskTrackFrom( transportTaskTrack );
			transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
			
			transportTaskTrackManagerOf(userContext).onNewInstanceCreated(userContext, (TransportTaskTrack)transportTask.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingTransportTaskTrack(RetailscmUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkIdOfTransportTaskTrack(transportTaskTrackId);
		checkerOf(userContext).checkVersionOfTransportTaskTrack(transportTaskTrackVersion);


		if(TransportTaskTrack.TRACK_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkTrackTimeOfTransportTaskTrack(parseDate(newValueExpr));
		}
		
		if(TransportTaskTrack.LATITUDE_PROPERTY.equals(property)){
			checkerOf(userContext).checkLatitudeOfTransportTaskTrack(parseBigDecimal(newValueExpr));
		}
		
		if(TransportTaskTrack.LONGITUDE_PROPERTY.equals(property)){
			checkerOf(userContext).checkLongitudeOfTransportTaskTrack(parseBigDecimal(newValueExpr));
		}
		

		checkerOf(userContext).throwExceptionIfHasErrors(TransportTaskManagerException.class);

	}

	public  TransportTask updateTransportTaskTrack(RetailscmUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskId, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withTransportTaskTrackList().searchTransportTaskTrackListWith(TransportTaskTrack.ID_PROPERTY, tokens().equals(), transportTaskTrackId).done();



		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, loadTokens);

		synchronized(transportTask){
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportTask.removeTransportTaskTrack( transportTaskTrack );
			//make changes to AcceleraterAccount.
			TransportTaskTrack transportTaskTrackIdVersionKey = createIndexedTransportTaskTrack(transportTaskTrackId, transportTaskTrackVersion);

			TransportTaskTrack transportTaskTrack = transportTask.findTheTransportTaskTrack(transportTaskTrackIdVersionKey);
			if(transportTaskTrack == null){
				throw new TransportTaskManagerException(transportTaskTrackId+" is NOT FOUND" );
			}

			beforeUpdateTransportTaskTrack(userContext, transportTaskTrack, transportTaskId, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr,  tokensExpr);
			transportTaskTrack.changeProperty(property, newValueExpr);
			
			transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateTransportTaskTrack(RetailscmUserContext userContext, TransportTaskTrack existed, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, TransportTask newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    transportTaskDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
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
		//   TransportTask newTransportTask = this.createTransportTask(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newTransportTask
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, TransportTask.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<TransportTask> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStore> endList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStore.class);
		userContext.getDAOGroup().enhanceList(endList, RetailStore.class);
		List<TruckDriver> driverList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TruckDriver.class);
		userContext.getDAOGroup().enhanceList(driverList, TruckDriver.class);
		List<TransportTruck> truckList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TransportTruck.class);
		userContext.getDAOGroup().enhanceList(truckList, TransportTruck.class);
		List<TransportFleet> belongsToList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TransportFleet.class);
		userContext.getDAOGroup().enhanceList(belongsToList, TransportFleet.class);


    }
	
	public Object listByEnd(RetailscmUserContext userContext,String endId) throws Exception {
		return listPageByEnd(userContext, endId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByEnd(RetailscmUserContext userContext,String endId, int start, int count) throws Exception {
		SmartList<TransportTask> list = transportTaskDaoOf(userContext).findTransportTaskByEnd(endId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(TransportTask.class);
		page.setContainerObject(RetailStore.withId(endId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("运输任务列表");
		page.setRequestName("listByEnd");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByEnd/%s/",  getBeanName(), endId)));

		page.assemblerContent(userContext, "listByEnd");
		return page.doRender(userContext);
	}
  
	public Object listByDriver(RetailscmUserContext userContext,String driverId) throws Exception {
		return listPageByDriver(userContext, driverId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDriver(RetailscmUserContext userContext,String driverId, int start, int count) throws Exception {
		SmartList<TransportTask> list = transportTaskDaoOf(userContext).findTransportTaskByDriver(driverId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(TransportTask.class);
		page.setContainerObject(TruckDriver.withId(driverId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("运输任务列表");
		page.setRequestName("listByDriver");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDriver/%s/",  getBeanName(), driverId)));

		page.assemblerContent(userContext, "listByDriver");
		return page.doRender(userContext);
	}
  
	public Object listByTruck(RetailscmUserContext userContext,String truckId) throws Exception {
		return listPageByTruck(userContext, truckId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByTruck(RetailscmUserContext userContext,String truckId, int start, int count) throws Exception {
		SmartList<TransportTask> list = transportTaskDaoOf(userContext).findTransportTaskByTruck(truckId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(TransportTask.class);
		page.setContainerObject(TransportTruck.withId(truckId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("运输任务列表");
		page.setRequestName("listByTruck");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByTruck/%s/",  getBeanName(), truckId)));

		page.assemblerContent(userContext, "listByTruck");
		return page.doRender(userContext);
	}
  
	public Object listByBelongsTo(RetailscmUserContext userContext,String belongsToId) throws Exception {
		return listPageByBelongsTo(userContext, belongsToId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBelongsTo(RetailscmUserContext userContext,String belongsToId, int start, int count) throws Exception {
		SmartList<TransportTask> list = transportTaskDaoOf(userContext).findTransportTaskByBelongsTo(belongsToId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(TransportTask.class);
		page.setContainerObject(TransportFleet.withId(belongsToId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("运输任务列表");
		page.setRequestName("listByBelongsTo");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBelongsTo/%s/",  getBeanName(), belongsToId)));

		page.assemblerContent(userContext, "listByBelongsTo");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String transportTaskId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getTransportTaskDetailScope().clone();
		TransportTask merchantObj = (TransportTask) this.view(userContext, transportTaskId);
    String merchantObjId = transportTaskId;
    String linkToUrl =	"transportTaskManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "运输任务"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "ID")
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
				MapUtil.put("id", "3-start")
				    .put("fieldName", "start")
				    .put("label", "开始")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("start", merchantObj.getStart());

		propList.add(
				MapUtil.put("id", "4-beginTime")
				    .put("fieldName", "beginTime")
				    .put("label", "开始时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("beginTime", merchantObj.getBeginTime());

		propList.add(
				MapUtil.put("id", "5-end")
				    .put("fieldName", "end")
				    .put("label", "结束")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("end", merchantObj.getEnd());

		propList.add(
				MapUtil.put("id", "6-driver")
				    .put("fieldName", "driver")
				    .put("label", "司机")
				    .put("type", "auto")
				    .put("linkToUrl", "truckDriverManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"driver_license_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("driver", merchantObj.getDriver());

		propList.add(
				MapUtil.put("id", "7-truck")
				    .put("fieldName", "truck")
				    .put("label", "卡车")
				    .put("type", "auto")
				    .put("linkToUrl", "transportTruckManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"plate_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("truck", merchantObj.getTruck());

		propList.add(
				MapUtil.put("id", "8-belongsTo")
				    .put("fieldName", "belongsTo")
				    .put("label", "属于")
				    .put("type", "auto")
				    .put("linkToUrl", "transportFleetManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("belongsTo", merchantObj.getBelongsTo());

		propList.add(
				MapUtil.put("id", "9-latitude")
				    .put("fieldName", "latitude")
				    .put("label", "纬度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("latitude", merchantObj.getLatitude());

		propList.add(
				MapUtil.put("id", "10-longitude")
				    .put("fieldName", "longitude")
				    .put("label", "经度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("longitude", merchantObj.getLongitude());

		//处理 sectionList

		//处理Section：goodsListSection
		Map goodsListSection = ListofUtils.buildSection(
		    "goodsListSection",
		    "商品列表",
		    null,
		    "",
		    "__no_group",
		    "goodsManager/listByTransportTask/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(goodsListSection);

		result.put("goodsListSection", ListofUtils.toShortList(merchantObj.getGoodsList(), "goods"));
		vscope.field("goodsListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Goods.class.getName(), null));

		//处理Section：transportTaskTrackListSection
		Map transportTaskTrackListSection = ListofUtils.buildSection(
		    "transportTaskTrackListSection",
		    "传输任务跟踪列表",
		    null,
		    "",
		    "__no_group",
		    "transportTaskTrackManager/listByMovement/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(transportTaskTrackListSection);

		result.put("transportTaskTrackListSection", ListofUtils.toShortList(merchantObj.getTransportTaskTrackList(), "transportTaskTrack"));
		vscope.field("transportTaskTrackListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( TransportTaskTrack.class.getName(), null));

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


