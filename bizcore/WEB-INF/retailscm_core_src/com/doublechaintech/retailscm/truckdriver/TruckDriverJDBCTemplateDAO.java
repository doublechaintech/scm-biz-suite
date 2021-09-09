
package com.doublechaintech.retailscm.truckdriver;

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


import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.transportfleet.TransportFleetDAO;
import com.doublechaintech.retailscm.transporttask.TransportTaskDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class TruckDriverJDBCTemplateDAO extends RetailscmBaseDAOImpl implements TruckDriverDAO{

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

	protected TransportTaskDAO transportTaskDAO;
	public void setTransportTaskDAO(TransportTaskDAO transportTaskDAO){

 		if(transportTaskDAO == null){
 			throw new IllegalStateException("Do not try to set transportTaskDAO to null.");
 		}
	 	this.transportTaskDAO = transportTaskDAO;
 	}
 	public TransportTaskDAO getTransportTaskDAO(){
 		if(this.transportTaskDAO == null){
 			throw new IllegalStateException("The transportTaskDAO is not configured yet, please config it some where.");
 		}

	 	return this.transportTaskDAO;
 	}



	/*
	protected TruckDriver load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTruckDriver(accessKey, options);
	}
	*/

	public SmartList<TruckDriver> loadAll() {
	    return this.loadAll(getTruckDriverMapper());
	}

  public Stream<TruckDriver> loadAllAsStream() {
      return this.loadAllAsStream(getTruckDriverMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public TruckDriver load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTruckDriver(TruckDriverTable.withId(id), options);
	}

	

	public TruckDriver save(TruckDriver truckDriver,Map<String,Object> options){

		String methodName="save(TruckDriver truckDriver,Map<String,Object> options)";

		assertMethodArgumentNotNull(truckDriver, methodName, "truckDriver");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalTruckDriver(truckDriver,options);
	}
	public TruckDriver clone(String truckDriverId, Map<String,Object> options) throws Exception{

		return clone(TruckDriverTable.withId(truckDriverId),options);
	}

	protected TruckDriver clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String truckDriverId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		TruckDriver newTruckDriver = loadInternalTruckDriver(accessKey, options);
		newTruckDriver.setVersion(0);
		
		

 		if(isSaveTransportTaskListEnabled(options)){
 			for(TransportTask item: newTruckDriver.getTransportTaskList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalTruckDriver(newTruckDriver,options);

		return newTruckDriver;
	}

	



	protected void throwIfHasException(String truckDriverId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TruckDriverVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TruckDriverNotFoundException(
					"The " + this.getTableName() + "(" + truckDriverId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String truckDriverId, int version) throws Exception{

		String methodName="delete(String truckDriverId, int version)";
		assertMethodArgumentNotNull(truckDriverId, methodName, "truckDriverId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{truckDriverId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(truckDriverId,version);
		}


	}






	public TruckDriver disconnectFromAll(String truckDriverId, int version) throws Exception{


		TruckDriver truckDriver = loadInternalTruckDriver(TruckDriverTable.withId(truckDriverId), emptyOptions());
		truckDriver.clearFromAll();
		this.saveTruckDriver(truckDriver);
		return truckDriver;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return TruckDriverTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "truck_driver";
	}
	@Override
	protected String getBeanName() {

		return "truckDriver";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return TruckDriverTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){

	 	return checkOptions(options, TruckDriverTokens.BELONGSTO);
 	}

 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){

 		return checkOptions(options, TruckDriverTokens.BELONGSTO);
 	}



 
		

	protected boolean isExtractTransportTaskListEnabled(Map<String,Object> options){
 		return checkOptions(options,TruckDriverTokens.TRANSPORT_TASK_LIST);
 	}
 	protected boolean isAnalyzeTransportTaskListEnabled(Map<String,Object> options){
 		return TruckDriverTokens.of(options).analyzeTransportTaskListEnabled();
 	}

	protected boolean isSaveTransportTaskListEnabled(Map<String,Object> options){
		return checkOptions(options, TruckDriverTokens.TRANSPORT_TASK_LIST);

 	}

		

	

	protected TruckDriverMapper getTruckDriverMapper(){
		return new TruckDriverMapper();
	}



	protected TruckDriver extractTruckDriver(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TruckDriver truckDriver = loadSingleObject(accessKey, getTruckDriverMapper());
			return truckDriver;
		}catch(EmptyResultDataAccessException e){
			throw new TruckDriverNotFoundException("TruckDriver("+accessKey+") is not found!");
		}

	}




	protected TruckDriver loadInternalTruckDriver(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		TruckDriver truckDriver = extractTruckDriver(accessKey, loadOptions);

 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(truckDriver, loadOptions);
 		}
 
		
		if(isExtractTransportTaskListEnabled(loadOptions)){
	 		extractTransportTaskList(truckDriver, loadOptions);
 		}

 		
 		if(isAnalyzeTransportTaskListEnabled(loadOptions)){
	 		analyzeTransportTaskList(truckDriver, loadOptions);
 		}
 		
		
		return truckDriver;

	}

	

 	protected TruckDriver extractBelongsTo(TruckDriver truckDriver, Map<String,Object> options) throws Exception{
  

		if(truckDriver.getBelongsTo() == null){
			return truckDriver;
		}
		String belongsToId = truckDriver.getBelongsTo().getId();
		if( belongsToId == null){
			return truckDriver;
		}
		TransportFleet belongsTo = getTransportFleetDAO().load(belongsToId,options);
		if(belongsTo != null){
			truckDriver.setBelongsTo(belongsTo);
		}


 		return truckDriver;
 	}

 
		
	protected void enhanceTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected TruckDriver extractTransportTaskList(TruckDriver truckDriver, Map<String,Object> options){
    

		if(truckDriver == null){
			return null;
		}
		if(truckDriver.getId() == null){
			return truckDriver;
		}



		SmartList<TransportTask> transportTaskList = getTransportTaskDAO().findTransportTaskByDriver(truckDriver.getId(),options);
		if(transportTaskList != null){
			enhanceTransportTaskList(transportTaskList,options);
			truckDriver.setTransportTaskList(transportTaskList);
		}

		return truckDriver;
  
	}

	protected TruckDriver analyzeTransportTaskList(TruckDriver truckDriver, Map<String,Object> options){
     
		if(truckDriver == null){
			return null;
		}
		if(truckDriver.getId() == null){
			return truckDriver;
		}



		SmartList<TransportTask> transportTaskList = truckDriver.getTransportTaskList();
		if(transportTaskList != null){
			getTransportTaskDAO().analyzeTransportTaskByDriver(transportTaskList, truckDriver.getId(), options);

		}

		return truckDriver;
    
	}

		

 
 	public SmartList<TruckDriver> findTruckDriverByBelongsTo(String transportFleetId,Map<String,Object> options){

  		SmartList<TruckDriver> resultList = queryWith(TruckDriverTable.COLUMN_BELONGS_TO, transportFleetId, options, getTruckDriverMapper());
		// analyzeTruckDriverByBelongsTo(resultList, transportFleetId, options);
		return resultList;
 	}
 	

 	public SmartList<TruckDriver> findTruckDriverByBelongsTo(String transportFleetId, int start, int count,Map<String,Object> options){

 		SmartList<TruckDriver> resultList =  queryWithRange(TruckDriverTable.COLUMN_BELONGS_TO, transportFleetId, options, getTruckDriverMapper(), start, count);
 		//analyzeTruckDriverByBelongsTo(resultList, transportFleetId, options);
 		return resultList;

 	}
 	public void analyzeTruckDriverByBelongsTo(SmartList<TruckDriver> resultList, String transportFleetId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countTruckDriverByBelongsTo(String transportFleetId,Map<String,Object> options){

 		return countWith(TruckDriverTable.COLUMN_BELONGS_TO, transportFleetId, options);
 	}
 	@Override
	public Map<String, Integer> countTruckDriverByBelongsToIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TruckDriverTable.COLUMN_BELONGS_TO, ids, options);
	}

 




	

	protected TruckDriver saveTruckDriver(TruckDriver  truckDriver){
    

		
		if(!truckDriver.isChanged()){
			return truckDriver;
		}
		

    Beans.dbUtil().cacheCleanUp(truckDriver);
		String SQL=this.getSaveTruckDriverSQL(truckDriver);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTruckDriverParameters(truckDriver);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		truckDriver.incVersion();
		truckDriver.afterSave();
		return truckDriver;

	}
	public SmartList<TruckDriver> saveTruckDriverList(SmartList<TruckDriver> truckDriverList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTruckDriverList(truckDriverList);

		batchTruckDriverCreate((List<TruckDriver>)lists[CREATE_LIST_INDEX]);

		batchTruckDriverUpdate((List<TruckDriver>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(TruckDriver truckDriver:truckDriverList){
			if(truckDriver.isChanged()){
				truckDriver.incVersion();
				truckDriver.afterSave();
			}


		}


		return truckDriverList;
	}

	public SmartList<TruckDriver> removeTruckDriverList(SmartList<TruckDriver> truckDriverList,Map<String,Object> options){


		super.removeList(truckDriverList, options);

		return truckDriverList;


	}

	protected List<Object[]> prepareTruckDriverBatchCreateArgs(List<TruckDriver> truckDriverList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TruckDriver truckDriver:truckDriverList ){
			Object [] parameters = prepareTruckDriverCreateParameters(truckDriver);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareTruckDriverBatchUpdateArgs(List<TruckDriver> truckDriverList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TruckDriver truckDriver:truckDriverList ){
			if(!truckDriver.isChanged()){
				continue;
			}
			Object [] parameters = prepareTruckDriverUpdateParameters(truckDriver);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchTruckDriverCreate(List<TruckDriver> truckDriverList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTruckDriverBatchCreateArgs(truckDriverList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchTruckDriverUpdate(List<TruckDriver> truckDriverList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTruckDriverBatchUpdateArgs(truckDriverList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitTruckDriverList(List<TruckDriver> truckDriverList){

		List<TruckDriver> truckDriverCreateList=new ArrayList<TruckDriver>();
		List<TruckDriver> truckDriverUpdateList=new ArrayList<TruckDriver>();

		for(TruckDriver truckDriver: truckDriverList){
			if(isUpdateRequest(truckDriver)){
				truckDriverUpdateList.add( truckDriver);
				continue;
			}
			truckDriverCreateList.add(truckDriver);
		}

		return new Object[]{truckDriverCreateList,truckDriverUpdateList};
	}

	protected boolean isUpdateRequest(TruckDriver truckDriver){
 		return truckDriver.getVersion() > 0;
 	}
 	protected String getSaveTruckDriverSQL(TruckDriver truckDriver){
 		if(isUpdateRequest(truckDriver)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveTruckDriverParameters(TruckDriver truckDriver){
 		if(isUpdateRequest(truckDriver) ){
 			return prepareTruckDriverUpdateParameters(truckDriver);
 		}
 		return prepareTruckDriverCreateParameters(truckDriver);
 	}
 	protected Object[] prepareTruckDriverUpdateParameters(TruckDriver truckDriver){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = truckDriver.getName();
 		
 		parameters[1] = truckDriver.getDriverLicenseNumber();
 		
 		parameters[2] = truckDriver.getContactNumber();
 		
 		if(truckDriver.getBelongsTo() != null){
 			parameters[3] = truckDriver.getBelongsTo().getId();
 		}
    
 		parameters[4] = truckDriver.nextVersion();
 		parameters[5] = truckDriver.getId();
 		parameters[6] = truckDriver.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareTruckDriverCreateParameters(TruckDriver truckDriver){
		Object[] parameters = new Object[5];
        if(truckDriver.getId() == null){
          String newTruckDriverId=getNextId();
          truckDriver.setId(newTruckDriverId);
        }
		parameters[0] =  truckDriver.getId();
 
 		parameters[1] = truckDriver.getName();
 		
 		parameters[2] = truckDriver.getDriverLicenseNumber();
 		
 		parameters[3] = truckDriver.getContactNumber();
 		
 		if(truckDriver.getBelongsTo() != null){
 			parameters[4] = truckDriver.getBelongsTo().getId();
 		}
 		

 		return parameters;
 	}

	protected TruckDriver saveInternalTruckDriver(TruckDriver truckDriver, Map<String,Object> options){

 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(truckDriver, options);
 		}
 
   saveTruckDriver(truckDriver);
		
		if(isSaveTransportTaskListEnabled(options)){
	 		saveTransportTaskList(truckDriver, options);
	 		//removeTransportTaskList(truckDriver, options);
	 		//Not delete the record

 		}
		
		return truckDriver;

	}



	//======================================================================================
	

 	protected TruckDriver saveBelongsTo(TruckDriver truckDriver, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(truckDriver.getBelongsTo() == null){
 			return truckDriver;//do nothing when it is null
 		}

 		getTransportFleetDAO().save(truckDriver.getBelongsTo(),options);
 		return truckDriver;

 	}
 

	
	public TruckDriver planToRemoveTransportTaskList(TruckDriver truckDriver, String transportTaskIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.DRIVER_PROPERTY, truckDriver.getId());
		key.put(TransportTask.ID_PROPERTY, transportTaskIds);

		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return truckDriver;
		}
		if(externalTransportTaskList.isEmpty()){
			return truckDriver;
		}

		for(TransportTask transportTaskItem: externalTransportTaskList){

			transportTaskItem.clearFromAll();
		}


		SmartList<TransportTask> transportTaskList = truckDriver.getTransportTaskList();
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return truckDriver;

	}


	//disconnect TruckDriver with end in TransportTask
	public TruckDriver planToRemoveTransportTaskListWithEnd(TruckDriver truckDriver, String endId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.DRIVER_PROPERTY, truckDriver.getId());
		key.put(TransportTask.END_PROPERTY, endId);

		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return truckDriver;
		}
		if(externalTransportTaskList.isEmpty()){
			return truckDriver;
		}

		for(TransportTask transportTaskItem: externalTransportTaskList){
			transportTaskItem.clearEnd();
			transportTaskItem.clearDriver();

		}


		SmartList<TransportTask> transportTaskList = truckDriver.getTransportTaskList();
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return truckDriver;
	}

	public int countTransportTaskListWithEnd(String truckDriverId, String endId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.DRIVER_PROPERTY, truckDriverId);
		key.put(TransportTask.END_PROPERTY, endId);

		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect TruckDriver with truck in TransportTask
	public TruckDriver planToRemoveTransportTaskListWithTruck(TruckDriver truckDriver, String truckId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.DRIVER_PROPERTY, truckDriver.getId());
		key.put(TransportTask.TRUCK_PROPERTY, truckId);

		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return truckDriver;
		}
		if(externalTransportTaskList.isEmpty()){
			return truckDriver;
		}

		for(TransportTask transportTaskItem: externalTransportTaskList){
			transportTaskItem.clearTruck();
			transportTaskItem.clearDriver();

		}


		SmartList<TransportTask> transportTaskList = truckDriver.getTransportTaskList();
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return truckDriver;
	}

	public int countTransportTaskListWithTruck(String truckDriverId, String truckId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.DRIVER_PROPERTY, truckDriverId);
		key.put(TransportTask.TRUCK_PROPERTY, truckId);

		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect TruckDriver with belongs_to in TransportTask
	public TruckDriver planToRemoveTransportTaskListWithBelongsTo(TruckDriver truckDriver, String belongsToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.DRIVER_PROPERTY, truckDriver.getId());
		key.put(TransportTask.BELONGS_TO_PROPERTY, belongsToId);

		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return truckDriver;
		}
		if(externalTransportTaskList.isEmpty()){
			return truckDriver;
		}

		for(TransportTask transportTaskItem: externalTransportTaskList){
			transportTaskItem.clearBelongsTo();
			transportTaskItem.clearDriver();

		}


		SmartList<TransportTask> transportTaskList = truckDriver.getTransportTaskList();
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return truckDriver;
	}

	public int countTransportTaskListWithBelongsTo(String truckDriverId, String belongsToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.DRIVER_PROPERTY, truckDriverId);
		key.put(TransportTask.BELONGS_TO_PROPERTY, belongsToId);

		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	

		
	protected TruckDriver saveTransportTaskList(TruckDriver truckDriver, Map<String,Object> options){
    



		SmartList<TransportTask> transportTaskList = truckDriver.getTransportTaskList();
		if(transportTaskList == null){
			//null list means nothing
			return truckDriver;
		}
		SmartList<TransportTask> mergedUpdateTransportTaskList = new SmartList<TransportTask>();


		mergedUpdateTransportTaskList.addAll(transportTaskList);
		if(transportTaskList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportTaskList.addAll(transportTaskList.getToRemoveList());
			transportTaskList.removeAll(transportTaskList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getTransportTaskDAO().saveTransportTaskList(mergedUpdateTransportTaskList,options);

		if(transportTaskList.getToRemoveList() != null){
			transportTaskList.removeAll(transportTaskList.getToRemoveList());
		}


		return truckDriver;

	}

	protected TruckDriver removeTransportTaskList(TruckDriver truckDriver, Map<String,Object> options){


		SmartList<TransportTask> transportTaskList = truckDriver.getTransportTaskList();
		if(transportTaskList == null){
			return truckDriver;
		}

		SmartList<TransportTask> toRemoveTransportTaskList = transportTaskList.getToRemoveList();

		if(toRemoveTransportTaskList == null){
			return truckDriver;
		}
		if(toRemoveTransportTaskList.isEmpty()){
			return truckDriver;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskList,options);

		return truckDriver;

	}








		

	public TruckDriver present(TruckDriver truckDriver,Map<String, Object> options){

		presentTransportTaskList(truckDriver,options);

		return truckDriver;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected TruckDriver presentTransportTaskList(
			TruckDriver truckDriver,
			Map<String, Object> options) {
    
		SmartList<TransportTask> transportTaskList = truckDriver.getTransportTaskList();
				SmartList<TransportTask> newList= presentSubList(truckDriver.getId(),
				transportTaskList,
				options,
				getTransportTaskDAO()::countTransportTaskByDriver,
				getTransportTaskDAO()::findTransportTaskByDriver
				);


		truckDriver.setTransportTaskList(newList);


		return truckDriver;
	}
		

	
    public SmartList<TruckDriver> requestCandidateTruckDriverForTransportTask(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TruckDriverTable.COLUMN_NAME, TruckDriverTable.COLUMN_BELONGS_TO, filterKey, pageNo, pageSize, getTruckDriverMapper());
    }
		

	protected String getTableName(){
		return TruckDriverTable.TABLE_NAME;
	}



	public void enhanceList(List<TruckDriver> truckDriverList) {
		this.enhanceListInternal(truckDriverList, this.getTruckDriverMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:TransportTask的driver的TransportTaskList
	public SmartList<TransportTask> loadOurTransportTaskList(RetailscmUserContext userContext, List<TruckDriver> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.DRIVER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<TransportTask> loadedObjs = userContext.getDAOGroup().getTransportTaskDAO().findTransportTaskWithKey(key, options);
		Map<String, List<TransportTask>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getDriver().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<TransportTask> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<TransportTask> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setTransportTaskList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TruckDriver> truckDriverList = ownerEntity.collectRefsWithType(TruckDriver.INTERNAL_TYPE);
		this.enhanceList(truckDriverList);

	}

	@Override
	public SmartList<TruckDriver> findTruckDriverWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getTruckDriverMapper());

	}
	@Override
	public int countTruckDriverWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countTruckDriverWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<TruckDriver> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTruckDriverMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<TruckDriver> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getTruckDriverMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateTruckDriver executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateTruckDriver result = new CandidateTruckDriver();
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
  public List<TruckDriver> search(TruckDriverRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected TruckDriverMapper mapper() {
    return getTruckDriverMapper();
  }
}


