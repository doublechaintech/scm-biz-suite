
package com.doublechaintech.retailscm.transporttask;

import com.doublechaintech.retailscm.Beans;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.retailscm.RetailscmBaseDAOImpl;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;

import com.doublechaintech.retailscm.transporttruck.TransportTruckDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackDAO;
import com.doublechaintech.retailscm.transportfleet.TransportFleetDAO;
import com.doublechaintech.retailscm.truckdriver.TruckDriverDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class TransportTaskJDBCTemplateDAO extends RetailscmBaseDAOImpl implements TransportTaskDAO{

	protected RetailStoreDAO retailStoreDAO;
	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){

 		if(retailStoreDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreDAO to null.");
 		}
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
 		if(this.retailStoreDAO == null){
 			throw new IllegalStateException("The retailStoreDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreDAO;
 	}

	protected TruckDriverDAO truckDriverDAO;
	public void setTruckDriverDAO(TruckDriverDAO truckDriverDAO){

 		if(truckDriverDAO == null){
 			throw new IllegalStateException("Do not try to set truckDriverDAO to null.");
 		}
	 	this.truckDriverDAO = truckDriverDAO;
 	}
 	public TruckDriverDAO getTruckDriverDAO(){
 		if(this.truckDriverDAO == null){
 			throw new IllegalStateException("The truckDriverDAO is not configured yet, please config it some where.");
 		}

	 	return this.truckDriverDAO;
 	}

	protected TransportTruckDAO transportTruckDAO;
	public void setTransportTruckDAO(TransportTruckDAO transportTruckDAO){

 		if(transportTruckDAO == null){
 			throw new IllegalStateException("Do not try to set transportTruckDAO to null.");
 		}
	 	this.transportTruckDAO = transportTruckDAO;
 	}
 	public TransportTruckDAO getTransportTruckDAO(){
 		if(this.transportTruckDAO == null){
 			throw new IllegalStateException("The transportTruckDAO is not configured yet, please config it some where.");
 		}

	 	return this.transportTruckDAO;
 	}

	protected TransportFleetDAO transportFleetDAO;
	public void setTransportFleetDAO(TransportFleetDAO transportFleetDAO){

 		if(transportFleetDAO == null){
 			throw new IllegalStateException("Do not try to set transportFleetDAO to null.");
 		}
	 	this.transportFleetDAO = transportFleetDAO;
 	}
 	public TransportFleetDAO getTransportFleetDAO(){
 		if(this.transportFleetDAO == null){
 			throw new IllegalStateException("The transportFleetDAO is not configured yet, please config it some where.");
 		}

	 	return this.transportFleetDAO;
 	}

	protected GoodsDAO goodsDAO;
	public void setGoodsDAO(GoodsDAO goodsDAO){

 		if(goodsDAO == null){
 			throw new IllegalStateException("Do not try to set goodsDAO to null.");
 		}
	 	this.goodsDAO = goodsDAO;
 	}
 	public GoodsDAO getGoodsDAO(){
 		if(this.goodsDAO == null){
 			throw new IllegalStateException("The goodsDAO is not configured yet, please config it some where.");
 		}

	 	return this.goodsDAO;
 	}

	protected TransportTaskTrackDAO transportTaskTrackDAO;
	public void setTransportTaskTrackDAO(TransportTaskTrackDAO transportTaskTrackDAO){

 		if(transportTaskTrackDAO == null){
 			throw new IllegalStateException("Do not try to set transportTaskTrackDAO to null.");
 		}
	 	this.transportTaskTrackDAO = transportTaskTrackDAO;
 	}
 	public TransportTaskTrackDAO getTransportTaskTrackDAO(){
 		if(this.transportTaskTrackDAO == null){
 			throw new IllegalStateException("The transportTaskTrackDAO is not configured yet, please config it some where.");
 		}

	 	return this.transportTaskTrackDAO;
 	}



	/*
	protected TransportTask load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportTask(accessKey, options);
	}
	*/

	public SmartList<TransportTask> loadAll() {
	    return this.loadAll(getTransportTaskMapper());
	}

  public Stream<TransportTask> loadAllAsStream() {
      return this.loadAllAsStream(getTransportTaskMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public TransportTask load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportTask(TransportTaskTable.withId(id), options);
	}

	

	public TransportTask save(TransportTask transportTask,Map<String,Object> options){

		String methodName="save(TransportTask transportTask,Map<String,Object> options)";

		assertMethodArgumentNotNull(transportTask, methodName, "transportTask");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalTransportTask(transportTask,options);
	}
	public TransportTask clone(String transportTaskId, Map<String,Object> options) throws Exception{

		return clone(TransportTaskTable.withId(transportTaskId),options);
	}

	protected TransportTask clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String transportTaskId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		TransportTask newTransportTask = loadInternalTransportTask(accessKey, options);
		newTransportTask.setVersion(0);
		
		

 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newTransportTask.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveTransportTaskTrackListEnabled(options)){
 			for(TransportTaskTrack item: newTransportTask.getTransportTaskTrackList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalTransportTask(newTransportTask,options);

		return newTransportTask;
	}

	



	protected void throwIfHasException(String transportTaskId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TransportTaskVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportTaskNotFoundException(
					"The " + this.getTableName() + "(" + transportTaskId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String transportTaskId, int version) throws Exception{

		String methodName="delete(String transportTaskId, int version)";
		assertMethodArgumentNotNull(transportTaskId, methodName, "transportTaskId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportTaskId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportTaskId,version);
		}


	}






	public TransportTask disconnectFromAll(String transportTaskId, int version) throws Exception{


		TransportTask transportTask = loadInternalTransportTask(TransportTaskTable.withId(transportTaskId), emptyOptions());
		transportTask.clearFromAll();
		this.saveTransportTask(transportTask);
		return transportTask;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return TransportTaskTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "transport_task";
	}
	@Override
	protected String getBeanName() {

		return "transportTask";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return TransportTaskTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractEndEnabled(Map<String,Object> options){

	 	return checkOptions(options, TransportTaskTokens.END);
 	}

 	protected boolean isSaveEndEnabled(Map<String,Object> options){

 		return checkOptions(options, TransportTaskTokens.END);
 	}



 

 	protected boolean isExtractDriverEnabled(Map<String,Object> options){

	 	return checkOptions(options, TransportTaskTokens.DRIVER);
 	}

 	protected boolean isSaveDriverEnabled(Map<String,Object> options){

 		return checkOptions(options, TransportTaskTokens.DRIVER);
 	}



 

 	protected boolean isExtractTruckEnabled(Map<String,Object> options){

	 	return checkOptions(options, TransportTaskTokens.TRUCK);
 	}

 	protected boolean isSaveTruckEnabled(Map<String,Object> options){

 		return checkOptions(options, TransportTaskTokens.TRUCK);
 	}



 

 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){

	 	return checkOptions(options, TransportTaskTokens.BELONGSTO);
 	}

 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){

 		return checkOptions(options, TransportTaskTokens.BELONGSTO);
 	}



 
		

	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
 		return checkOptions(options,TransportTaskTokens.GOODS_LIST);
 	}
 	protected boolean isAnalyzeGoodsListEnabled(Map<String,Object> options){
 		return TransportTaskTokens.of(options).analyzeGoodsListEnabled();
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportTaskTokens.GOODS_LIST);

 	}

		

	protected boolean isExtractTransportTaskTrackListEnabled(Map<String,Object> options){
 		return checkOptions(options,TransportTaskTokens.TRANSPORT_TASK_TRACK_LIST);
 	}
 	protected boolean isAnalyzeTransportTaskTrackListEnabled(Map<String,Object> options){
 		return TransportTaskTokens.of(options).analyzeTransportTaskTrackListEnabled();
 	}

	protected boolean isSaveTransportTaskTrackListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportTaskTokens.TRANSPORT_TASK_TRACK_LIST);

 	}

		

	

	protected TransportTaskMapper getTransportTaskMapper(){
		return new TransportTaskMapper();
	}



	protected TransportTask extractTransportTask(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TransportTask transportTask = loadSingleObject(accessKey, getTransportTaskMapper());
			return transportTask;
		}catch(EmptyResultDataAccessException e){
			throw new TransportTaskNotFoundException("TransportTask("+accessKey+") is not found!");
		}

	}




	protected TransportTask loadInternalTransportTask(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		TransportTask transportTask = extractTransportTask(accessKey, loadOptions);

 		if(isExtractEndEnabled(loadOptions)){
	 		extractEnd(transportTask, loadOptions);
 		}
 
 		if(isExtractDriverEnabled(loadOptions)){
	 		extractDriver(transportTask, loadOptions);
 		}
 
 		if(isExtractTruckEnabled(loadOptions)){
	 		extractTruck(transportTask, loadOptions);
 		}
 
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(transportTask, loadOptions);
 		}
 
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(transportTask, loadOptions);
 		}

 		
 		if(isAnalyzeGoodsListEnabled(loadOptions)){
	 		analyzeGoodsList(transportTask, loadOptions);
 		}
 		
		
		if(isExtractTransportTaskTrackListEnabled(loadOptions)){
	 		extractTransportTaskTrackList(transportTask, loadOptions);
 		}

 		
 		if(isAnalyzeTransportTaskTrackListEnabled(loadOptions)){
	 		analyzeTransportTaskTrackList(transportTask, loadOptions);
 		}
 		
		
		return transportTask;

	}

	

 	protected TransportTask extractEnd(TransportTask transportTask, Map<String,Object> options) throws Exception{
  

		if(transportTask.getEnd() == null){
			return transportTask;
		}
		String endId = transportTask.getEnd().getId();
		if( endId == null){
			return transportTask;
		}
		RetailStore end = getRetailStoreDAO().load(endId,options);
		if(end != null){
			transportTask.setEnd(end);
		}


 		return transportTask;
 	}

 

 	protected TransportTask extractDriver(TransportTask transportTask, Map<String,Object> options) throws Exception{
  

		if(transportTask.getDriver() == null){
			return transportTask;
		}
		String driverId = transportTask.getDriver().getId();
		if( driverId == null){
			return transportTask;
		}
		TruckDriver driver = getTruckDriverDAO().load(driverId,options);
		if(driver != null){
			transportTask.setDriver(driver);
		}


 		return transportTask;
 	}

 

 	protected TransportTask extractTruck(TransportTask transportTask, Map<String,Object> options) throws Exception{
  

		if(transportTask.getTruck() == null){
			return transportTask;
		}
		String truckId = transportTask.getTruck().getId();
		if( truckId == null){
			return transportTask;
		}
		TransportTruck truck = getTransportTruckDAO().load(truckId,options);
		if(truck != null){
			transportTask.setTruck(truck);
		}


 		return transportTask;
 	}

 

 	protected TransportTask extractBelongsTo(TransportTask transportTask, Map<String,Object> options) throws Exception{
  

		if(transportTask.getBelongsTo() == null){
			return transportTask;
		}
		String belongsToId = transportTask.getBelongsTo().getId();
		if( belongsToId == null){
			return transportTask;
		}
		TransportFleet belongsTo = getTransportFleetDAO().load(belongsToId,options);
		if(belongsTo != null){
			transportTask.setBelongsTo(belongsTo);
		}


 		return transportTask;
 	}

 
		
	protected void enhanceGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected TransportTask extractGoodsList(TransportTask transportTask, Map<String,Object> options){
    

		if(transportTask == null){
			return null;
		}
		if(transportTask.getId() == null){
			return transportTask;
		}



		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByTransportTask(transportTask.getId(),options);
		if(goodsList != null){
			enhanceGoodsList(goodsList,options);
			transportTask.setGoodsList(goodsList);
		}

		return transportTask;
  
	}

	protected TransportTask analyzeGoodsList(TransportTask transportTask, Map<String,Object> options){
     
		if(transportTask == null){
			return null;
		}
		if(transportTask.getId() == null){
			return transportTask;
		}



		SmartList<Goods> goodsList = transportTask.getGoodsList();
		if(goodsList != null){
			getGoodsDAO().analyzeGoodsByTransportTask(goodsList, transportTask.getId(), options);

		}

		return transportTask;
    
	}

		
	protected void enhanceTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected TransportTask extractTransportTaskTrackList(TransportTask transportTask, Map<String,Object> options){
    

		if(transportTask == null){
			return null;
		}
		if(transportTask.getId() == null){
			return transportTask;
		}



		SmartList<TransportTaskTrack> transportTaskTrackList = getTransportTaskTrackDAO().findTransportTaskTrackByMovement(transportTask.getId(),options);
		if(transportTaskTrackList != null){
			enhanceTransportTaskTrackList(transportTaskTrackList,options);
			transportTask.setTransportTaskTrackList(transportTaskTrackList);
		}

		return transportTask;
  
	}

	protected TransportTask analyzeTransportTaskTrackList(TransportTask transportTask, Map<String,Object> options){
     
		if(transportTask == null){
			return null;
		}
		if(transportTask.getId() == null){
			return transportTask;
		}



		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();
		if(transportTaskTrackList != null){
			getTransportTaskTrackDAO().analyzeTransportTaskTrackByMovement(transportTaskTrackList, transportTask.getId(), options);

		}

		return transportTask;
    
	}

		

 
 	public SmartList<TransportTask> findTransportTaskByEnd(String retailStoreId,Map<String,Object> options){

  		SmartList<TransportTask> resultList = queryWith(TransportTaskTable.COLUMN_END, retailStoreId, options, getTransportTaskMapper());
		// analyzeTransportTaskByEnd(resultList, retailStoreId, options);
		return resultList;
 	}
 	

 	public SmartList<TransportTask> findTransportTaskByEnd(String retailStoreId, int start, int count,Map<String,Object> options){

 		SmartList<TransportTask> resultList =  queryWithRange(TransportTaskTable.COLUMN_END, retailStoreId, options, getTransportTaskMapper(), start, count);
 		//analyzeTransportTaskByEnd(resultList, retailStoreId, options);
 		return resultList;

 	}
 	public void analyzeTransportTaskByEnd(SmartList<TransportTask> resultList, String retailStoreId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportTask.END_PROPERTY, retailStoreId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countTransportTaskByEnd(String retailStoreId,Map<String,Object> options){

 		return countWith(TransportTaskTable.COLUMN_END, retailStoreId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskByEndIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTable.COLUMN_END, ids, options);
	}

 
 	public SmartList<TransportTask> findTransportTaskByDriver(String truckDriverId,Map<String,Object> options){

  		SmartList<TransportTask> resultList = queryWith(TransportTaskTable.COLUMN_DRIVER, truckDriverId, options, getTransportTaskMapper());
		// analyzeTransportTaskByDriver(resultList, truckDriverId, options);
		return resultList;
 	}
 	

 	public SmartList<TransportTask> findTransportTaskByDriver(String truckDriverId, int start, int count,Map<String,Object> options){

 		SmartList<TransportTask> resultList =  queryWithRange(TransportTaskTable.COLUMN_DRIVER, truckDriverId, options, getTransportTaskMapper(), start, count);
 		//analyzeTransportTaskByDriver(resultList, truckDriverId, options);
 		return resultList;

 	}
 	public void analyzeTransportTaskByDriver(SmartList<TransportTask> resultList, String truckDriverId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportTask.DRIVER_PROPERTY, truckDriverId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countTransportTaskByDriver(String truckDriverId,Map<String,Object> options){

 		return countWith(TransportTaskTable.COLUMN_DRIVER, truckDriverId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskByDriverIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTable.COLUMN_DRIVER, ids, options);
	}

 
 	public SmartList<TransportTask> findTransportTaskByTruck(String transportTruckId,Map<String,Object> options){

  		SmartList<TransportTask> resultList = queryWith(TransportTaskTable.COLUMN_TRUCK, transportTruckId, options, getTransportTaskMapper());
		// analyzeTransportTaskByTruck(resultList, transportTruckId, options);
		return resultList;
 	}
 	

 	public SmartList<TransportTask> findTransportTaskByTruck(String transportTruckId, int start, int count,Map<String,Object> options){

 		SmartList<TransportTask> resultList =  queryWithRange(TransportTaskTable.COLUMN_TRUCK, transportTruckId, options, getTransportTaskMapper(), start, count);
 		//analyzeTransportTaskByTruck(resultList, transportTruckId, options);
 		return resultList;

 	}
 	public void analyzeTransportTaskByTruck(SmartList<TransportTask> resultList, String transportTruckId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportTask.TRUCK_PROPERTY, transportTruckId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countTransportTaskByTruck(String transportTruckId,Map<String,Object> options){

 		return countWith(TransportTaskTable.COLUMN_TRUCK, transportTruckId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskByTruckIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTable.COLUMN_TRUCK, ids, options);
	}

 
 	public SmartList<TransportTask> findTransportTaskByBelongsTo(String transportFleetId,Map<String,Object> options){

  		SmartList<TransportTask> resultList = queryWith(TransportTaskTable.COLUMN_BELONGS_TO, transportFleetId, options, getTransportTaskMapper());
		// analyzeTransportTaskByBelongsTo(resultList, transportFleetId, options);
		return resultList;
 	}
 	

 	public SmartList<TransportTask> findTransportTaskByBelongsTo(String transportFleetId, int start, int count,Map<String,Object> options){

 		SmartList<TransportTask> resultList =  queryWithRange(TransportTaskTable.COLUMN_BELONGS_TO, transportFleetId, options, getTransportTaskMapper(), start, count);
 		//analyzeTransportTaskByBelongsTo(resultList, transportFleetId, options);
 		return resultList;

 	}
 	public void analyzeTransportTaskByBelongsTo(SmartList<TransportTask> resultList, String transportFleetId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportTask.BELONGS_TO_PROPERTY, transportFleetId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countTransportTaskByBelongsTo(String transportFleetId,Map<String,Object> options){

 		return countWith(TransportTaskTable.COLUMN_BELONGS_TO, transportFleetId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskByBelongsToIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTable.COLUMN_BELONGS_TO, ids, options);
	}

 




	

	protected TransportTask saveTransportTask(TransportTask  transportTask){
    

		
		if(!transportTask.isChanged()){
			return transportTask;
		}
		

    Beans.dbUtil().cacheCleanUp(transportTask);
		String SQL=this.getSaveTransportTaskSQL(transportTask);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportTaskParameters(transportTask);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		transportTask.incVersion();
		transportTask.afterSave();
		return transportTask;

	}
	public SmartList<TransportTask> saveTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportTaskList(transportTaskList);

		batchTransportTaskCreate((List<TransportTask>)lists[CREATE_LIST_INDEX]);

		batchTransportTaskUpdate((List<TransportTask>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(TransportTask transportTask:transportTaskList){
			if(transportTask.isChanged()){
				transportTask.incVersion();
				transportTask.afterSave();
			}


		}


		return transportTaskList;
	}

	public SmartList<TransportTask> removeTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options){


		super.removeList(transportTaskList, options);

		return transportTaskList;


	}

	protected List<Object[]> prepareTransportTaskBatchCreateArgs(List<TransportTask> transportTaskList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTask transportTask:transportTaskList ){
			Object [] parameters = prepareTransportTaskCreateParameters(transportTask);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareTransportTaskBatchUpdateArgs(List<TransportTask> transportTaskList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTask transportTask:transportTaskList ){
			if(!transportTask.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportTaskUpdateParameters(transportTask);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchTransportTaskCreate(List<TransportTask> transportTaskList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportTaskBatchCreateArgs(transportTaskList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchTransportTaskUpdate(List<TransportTask> transportTaskList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportTaskBatchUpdateArgs(transportTaskList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitTransportTaskList(List<TransportTask> transportTaskList){

		List<TransportTask> transportTaskCreateList=new ArrayList<TransportTask>();
		List<TransportTask> transportTaskUpdateList=new ArrayList<TransportTask>();

		for(TransportTask transportTask: transportTaskList){
			if(isUpdateRequest(transportTask)){
				transportTaskUpdateList.add( transportTask);
				continue;
			}
			transportTaskCreateList.add(transportTask);
		}

		return new Object[]{transportTaskCreateList,transportTaskUpdateList};
	}

	protected boolean isUpdateRequest(TransportTask transportTask){
 		return transportTask.getVersion() > 0;
 	}
 	protected String getSaveTransportTaskSQL(TransportTask transportTask){
 		if(isUpdateRequest(transportTask)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveTransportTaskParameters(TransportTask transportTask){
 		if(isUpdateRequest(transportTask) ){
 			return prepareTransportTaskUpdateParameters(transportTask);
 		}
 		return prepareTransportTaskCreateParameters(transportTask);
 	}
 	protected Object[] prepareTransportTaskUpdateParameters(TransportTask transportTask){
 		Object[] parameters = new Object[12];
 
 		parameters[0] = transportTask.getName();
 		
 		parameters[1] = transportTask.getStart();
 		
 		parameters[2] = transportTask.getBeginTime();
 		
 		if(transportTask.getEnd() != null){
 			parameters[3] = transportTask.getEnd().getId();
 		}
    
 		if(transportTask.getDriver() != null){
 			parameters[4] = transportTask.getDriver().getId();
 		}
    
 		if(transportTask.getTruck() != null){
 			parameters[5] = transportTask.getTruck().getId();
 		}
    
 		if(transportTask.getBelongsTo() != null){
 			parameters[6] = transportTask.getBelongsTo().getId();
 		}
    
 		parameters[7] = transportTask.getLatitude();
 		
 		parameters[8] = transportTask.getLongitude();
 		
 		parameters[9] = transportTask.nextVersion();
 		parameters[10] = transportTask.getId();
 		parameters[11] = transportTask.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareTransportTaskCreateParameters(TransportTask transportTask){
		Object[] parameters = new Object[10];
        if(transportTask.getId() == null){
          String newTransportTaskId=getNextId();
          transportTask.setId(newTransportTaskId);
        }
		parameters[0] =  transportTask.getId();
 
 		parameters[1] = transportTask.getName();
 		
 		parameters[2] = transportTask.getStart();
 		
 		parameters[3] = transportTask.getBeginTime();
 		
 		if(transportTask.getEnd() != null){
 			parameters[4] = transportTask.getEnd().getId();
 		}
 		
 		if(transportTask.getDriver() != null){
 			parameters[5] = transportTask.getDriver().getId();
 		}
 		
 		if(transportTask.getTruck() != null){
 			parameters[6] = transportTask.getTruck().getId();
 		}
 		
 		if(transportTask.getBelongsTo() != null){
 			parameters[7] = transportTask.getBelongsTo().getId();
 		}
 		
 		parameters[8] = transportTask.getLatitude();
 		
 		parameters[9] = transportTask.getLongitude();
 		

 		return parameters;
 	}

	protected TransportTask saveInternalTransportTask(TransportTask transportTask, Map<String,Object> options){

 		if(isSaveEndEnabled(options)){
	 		saveEnd(transportTask, options);
 		}
 
 		if(isSaveDriverEnabled(options)){
	 		saveDriver(transportTask, options);
 		}
 
 		if(isSaveTruckEnabled(options)){
	 		saveTruck(transportTask, options);
 		}
 
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(transportTask, options);
 		}
 
   saveTransportTask(transportTask);
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(transportTask, options);
	 		//removeGoodsList(transportTask, options);
	 		//Not delete the record

 		}
		
		if(isSaveTransportTaskTrackListEnabled(options)){
	 		saveTransportTaskTrackList(transportTask, options);
	 		//removeTransportTaskTrackList(transportTask, options);
	 		//Not delete the record

 		}
		
		return transportTask;

	}



	//======================================================================================
	

 	protected TransportTask saveEnd(TransportTask transportTask, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(transportTask.getEnd() == null){
 			return transportTask;//do nothing when it is null
 		}

 		getRetailStoreDAO().save(transportTask.getEnd(),options);
 		return transportTask;

 	}
 

 	protected TransportTask saveDriver(TransportTask transportTask, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(transportTask.getDriver() == null){
 			return transportTask;//do nothing when it is null
 		}

 		getTruckDriverDAO().save(transportTask.getDriver(),options);
 		return transportTask;

 	}
 

 	protected TransportTask saveTruck(TransportTask transportTask, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(transportTask.getTruck() == null){
 			return transportTask;//do nothing when it is null
 		}

 		getTransportTruckDAO().save(transportTask.getTruck(),options);
 		return transportTask;

 	}
 

 	protected TransportTask saveBelongsTo(TransportTask transportTask, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(transportTask.getBelongsTo() == null){
 			return transportTask;//do nothing when it is null
 		}

 		getTransportFleetDAO().save(transportTask.getBelongsTo(),options);
 		return transportTask;

 	}
 

	
	public TransportTask planToRemoveGoodsList(TransportTask transportTask, String goodsIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTask.getId());
		key.put(Goods.ID_PROPERTY, goodsIds);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return transportTask;
		}
		if(externalGoodsList.isEmpty()){
			return transportTask;
		}

		for(Goods goodsItem: externalGoodsList){

			goodsItem.clearFromAll();
		}


		SmartList<Goods> goodsList = transportTask.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return transportTask;

	}


	//disconnect TransportTask with sku in Goods
	public TransportTask planToRemoveGoodsListWithSku(TransportTask transportTask, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTask.getId());
		key.put(Goods.SKU_PROPERTY, skuId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return transportTask;
		}
		if(externalGoodsList.isEmpty()){
			return transportTask;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSku();
			goodsItem.clearTransportTask();

		}


		SmartList<Goods> goodsList = transportTask.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return transportTask;
	}

	public int countGoodsListWithSku(String transportTaskId, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		key.put(Goods.SKU_PROPERTY, skuId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTask with receiving_space in Goods
	public TransportTask planToRemoveGoodsListWithReceivingSpace(TransportTask transportTask, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTask.getId());
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return transportTask;
		}
		if(externalGoodsList.isEmpty()){
			return transportTask;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearReceivingSpace();
			goodsItem.clearTransportTask();

		}


		SmartList<Goods> goodsList = transportTask.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return transportTask;
	}

	public int countGoodsListWithReceivingSpace(String transportTaskId, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTask with goods_allocation in Goods
	public TransportTask planToRemoveGoodsListWithGoodsAllocation(TransportTask transportTask, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTask.getId());
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return transportTask;
		}
		if(externalGoodsList.isEmpty()){
			return transportTask;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearGoodsAllocation();
			goodsItem.clearTransportTask();

		}


		SmartList<Goods> goodsList = transportTask.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return transportTask;
	}

	public int countGoodsListWithGoodsAllocation(String transportTaskId, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTask with smart_pallet in Goods
	public TransportTask planToRemoveGoodsListWithSmartPallet(TransportTask transportTask, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTask.getId());
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return transportTask;
		}
		if(externalGoodsList.isEmpty()){
			return transportTask;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSmartPallet();
			goodsItem.clearTransportTask();

		}


		SmartList<Goods> goodsList = transportTask.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return transportTask;
	}

	public int countGoodsListWithSmartPallet(String transportTaskId, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTask with shipping_space in Goods
	public TransportTask planToRemoveGoodsListWithShippingSpace(TransportTask transportTask, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTask.getId());
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return transportTask;
		}
		if(externalGoodsList.isEmpty()){
			return transportTask;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearShippingSpace();
			goodsItem.clearTransportTask();

		}


		SmartList<Goods> goodsList = transportTask.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return transportTask;
	}

	public int countGoodsListWithShippingSpace(String transportTaskId, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTask with retail_store in Goods
	public TransportTask planToRemoveGoodsListWithRetailStore(TransportTask transportTask, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTask.getId());
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return transportTask;
		}
		if(externalGoodsList.isEmpty()){
			return transportTask;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStore();
			goodsItem.clearTransportTask();

		}


		SmartList<Goods> goodsList = transportTask.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return transportTask;
	}

	public int countGoodsListWithRetailStore(String transportTaskId, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTask with biz_order in Goods
	public TransportTask planToRemoveGoodsListWithBizOrder(TransportTask transportTask, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTask.getId());
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return transportTask;
		}
		if(externalGoodsList.isEmpty()){
			return transportTask;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearBizOrder();
			goodsItem.clearTransportTask();

		}


		SmartList<Goods> goodsList = transportTask.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return transportTask;
	}

	public int countGoodsListWithBizOrder(String transportTaskId, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTask with retail_store_order in Goods
	public TransportTask planToRemoveGoodsListWithRetailStoreOrder(TransportTask transportTask, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTask.getId());
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return transportTask;
		}
		if(externalGoodsList.isEmpty()){
			return transportTask;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStoreOrder();
			goodsItem.clearTransportTask();

		}


		SmartList<Goods> goodsList = transportTask.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return transportTask;
	}

	public int countGoodsListWithRetailStoreOrder(String transportTaskId, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	public TransportTask planToRemoveTransportTaskTrackList(TransportTask transportTask, String transportTaskTrackIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTaskTrack.MOVEMENT_PROPERTY, transportTask.getId());
		key.put(TransportTaskTrack.ID_PROPERTY, transportTaskTrackIds);

		SmartList<TransportTaskTrack> externalTransportTaskTrackList = getTransportTaskTrackDAO().
				findTransportTaskTrackWithKey(key, options);
		if(externalTransportTaskTrackList == null){
			return transportTask;
		}
		if(externalTransportTaskTrackList.isEmpty()){
			return transportTask;
		}

		for(TransportTaskTrack transportTaskTrackItem: externalTransportTaskTrackList){

			transportTaskTrackItem.clearFromAll();
		}


		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();
		transportTaskTrackList.addAllToRemoveList(externalTransportTaskTrackList);
		return transportTask;

	}



		
	protected TransportTask saveGoodsList(TransportTask transportTask, Map<String,Object> options){
    



		SmartList<Goods> goodsList = transportTask.getGoodsList();
		if(goodsList == null){
			//null list means nothing
			return transportTask;
		}
		SmartList<Goods> mergedUpdateGoodsList = new SmartList<Goods>();


		mergedUpdateGoodsList.addAll(goodsList);
		if(goodsList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateGoodsList.addAll(goodsList.getToRemoveList());
			goodsList.removeAll(goodsList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getGoodsDAO().saveGoodsList(mergedUpdateGoodsList,options);

		if(goodsList.getToRemoveList() != null){
			goodsList.removeAll(goodsList.getToRemoveList());
		}


		return transportTask;

	}

	protected TransportTask removeGoodsList(TransportTask transportTask, Map<String,Object> options){


		SmartList<Goods> goodsList = transportTask.getGoodsList();
		if(goodsList == null){
			return transportTask;
		}

		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();

		if(toRemoveGoodsList == null){
			return transportTask;
		}
		if(toRemoveGoodsList.isEmpty()){
			return transportTask;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);

		return transportTask;

	}








		
	protected TransportTask saveTransportTaskTrackList(TransportTask transportTask, Map<String,Object> options){
    



		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();
		if(transportTaskTrackList == null){
			//null list means nothing
			return transportTask;
		}
		SmartList<TransportTaskTrack> mergedUpdateTransportTaskTrackList = new SmartList<TransportTaskTrack>();


		mergedUpdateTransportTaskTrackList.addAll(transportTaskTrackList);
		if(transportTaskTrackList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportTaskTrackList.addAll(transportTaskTrackList.getToRemoveList());
			transportTaskTrackList.removeAll(transportTaskTrackList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getTransportTaskTrackDAO().saveTransportTaskTrackList(mergedUpdateTransportTaskTrackList,options);

		if(transportTaskTrackList.getToRemoveList() != null){
			transportTaskTrackList.removeAll(transportTaskTrackList.getToRemoveList());
		}


		return transportTask;

	}

	protected TransportTask removeTransportTaskTrackList(TransportTask transportTask, Map<String,Object> options){


		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();
		if(transportTaskTrackList == null){
			return transportTask;
		}

		SmartList<TransportTaskTrack> toRemoveTransportTaskTrackList = transportTaskTrackList.getToRemoveList();

		if(toRemoveTransportTaskTrackList == null){
			return transportTask;
		}
		if(toRemoveTransportTaskTrackList.isEmpty()){
			return transportTask;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getTransportTaskTrackDAO().removeTransportTaskTrackList(toRemoveTransportTaskTrackList,options);

		return transportTask;

	}








		

	public TransportTask present(TransportTask transportTask,Map<String, Object> options){

		presentGoodsList(transportTask,options);
		presentTransportTaskTrackList(transportTask,options);

		return transportTask;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected TransportTask presentGoodsList(
			TransportTask transportTask,
			Map<String, Object> options) {
    
		SmartList<Goods> goodsList = transportTask.getGoodsList();
				SmartList<Goods> newList= presentSubList(transportTask.getId(),
				goodsList,
				options,
				getGoodsDAO()::countGoodsByTransportTask,
				getGoodsDAO()::findGoodsByTransportTask
				);


		transportTask.setGoodsList(newList);


		return transportTask;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected TransportTask presentTransportTaskTrackList(
			TransportTask transportTask,
			Map<String, Object> options) {
    
		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();
				SmartList<TransportTaskTrack> newList= presentSubList(transportTask.getId(),
				transportTaskTrackList,
				options,
				getTransportTaskTrackDAO()::countTransportTaskTrackByMovement,
				getTransportTaskTrackDAO()::findTransportTaskTrackByMovement
				);


		transportTask.setTransportTaskTrackList(newList);


		return transportTask;
	}
		

	
    public SmartList<TransportTask> requestCandidateTransportTaskForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TransportTaskTable.COLUMN_NAME, TransportTaskTable.COLUMN_END, filterKey, pageNo, pageSize, getTransportTaskMapper());
    }
		
    public SmartList<TransportTask> requestCandidateTransportTaskForTransportTaskTrack(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TransportTaskTable.COLUMN_NAME, TransportTaskTable.COLUMN_END, filterKey, pageNo, pageSize, getTransportTaskMapper());
    }
		

	protected String getTableName(){
		return TransportTaskTable.TABLE_NAME;
	}



	public void enhanceList(List<TransportTask> transportTaskList) {
		this.enhanceListInternal(transportTaskList, this.getTransportTaskMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:Goods的transportTask的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<TransportTask> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.TRANSPORT_TASK_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Goods> loadedObjs = userContext.getDAOGroup().getGoodsDAO().findGoodsWithKey(key, options);
		Map<String, List<Goods>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getTransportTask().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Goods> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Goods> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setGoodsList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:TransportTaskTrack的movement的TransportTaskTrackList
	public SmartList<TransportTaskTrack> loadOurTransportTaskTrackList(RetailscmUserContext userContext, List<TransportTask> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTaskTrack.MOVEMENT_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<TransportTaskTrack> loadedObjs = userContext.getDAOGroup().getTransportTaskTrackDAO().findTransportTaskTrackWithKey(key, options);
		Map<String, List<TransportTaskTrack>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getMovement().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<TransportTaskTrack> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<TransportTaskTrack> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setTransportTaskTrackList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TransportTask> transportTaskList = ownerEntity.collectRefsWithType(TransportTask.INTERNAL_TYPE);
		this.enhanceList(transportTaskList);

	}

	@Override
	public SmartList<TransportTask> findTransportTaskWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getTransportTaskMapper());

	}
	@Override
	public int countTransportTaskWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countTransportTaskWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<TransportTask> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTransportTaskMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<TransportTask> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getTransportTaskMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateTransportTask executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateTransportTask result = new CandidateTransportTask();
		int pageNo = Math.max(1, query.getPageNo());
		result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
		result.setOwnerId(query.getOwnerId());
		result.setFilterKey(query.getFilterKey());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
		result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

		SmartList candidateList = queryList(sql, parmeters);
		this.alias(candidateList);
		result.setCandidates(candidateList);
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}

	

  @Override
  public List<TransportTask> search(TransportTaskRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected TransportTaskMapper mapper() {
    return getTransportTaskMapper();
  }
}


