
package com.doublechaintech.retailscm.transporttruck;

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


public class TransportTruckJDBCTemplateDAO extends RetailscmBaseDAOImpl implements TransportTruckDAO{

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
	protected TransportTruck load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportTruck(accessKey, options);
	}
	*/
	
	public SmartList<TransportTruck> loadAll() {
	    return this.loadAll(getTransportTruckMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public TransportTruck load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportTruck(TransportTruckTable.withId(id), options);
	}
	
	
	
	public TransportTruck save(TransportTruck transportTruck,Map<String,Object> options){
		
		String methodName="save(TransportTruck transportTruck,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transportTruck, methodName, "transportTruck");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransportTruck(transportTruck,options);
	}
	public TransportTruck clone(String transportTruckId, Map<String,Object> options) throws Exception{
	
		return clone(TransportTruckTable.withId(transportTruckId),options);
	}
	
	protected TransportTruck clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transportTruckId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TransportTruck newTransportTruck = loadInternalTransportTruck(accessKey, options);
		newTransportTruck.setVersion(0);
		
		
 		
 		if(isSaveTransportTaskListEnabled(options)){
 			for(TransportTask item: newTransportTruck.getTransportTaskList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTransportTruck(newTransportTruck,options);
		
		return newTransportTruck;
	}
	
	
	
	

	protected void throwIfHasException(String transportTruckId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TransportTruckVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportTruckNotFoundException(
					"The " + this.getTableName() + "(" + transportTruckId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String transportTruckId, int version) throws Exception{
	
		String methodName="delete(String transportTruckId, int version)";
		assertMethodArgumentNotNull(transportTruckId, methodName, "transportTruckId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportTruckId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportTruckId,version);
		}
		
	
	}
	
	
	
	
	

	public TransportTruck disconnectFromAll(String transportTruckId, int version) throws Exception{
	
		
		TransportTruck transportTruck = loadInternalTransportTruck(TransportTruckTable.withId(transportTruckId), emptyOptions());
		transportTruck.clearFromAll();
		this.saveTransportTruck(transportTruck);
		return transportTruck;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TransportTruckTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transport_truck";
	}
	@Override
	protected String getBeanName() {
		
		return "transportTruck";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransportTruckTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTruckTokens.OWNER);
 	}

 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTruckTokens.OWNER);
 	}
 	

 	
 
		
	
	protected boolean isExtractTransportTaskListEnabled(Map<String,Object> options){		
 		return checkOptions(options,TransportTruckTokens.TRANSPORT_TASK_LIST);
 	}
 	protected boolean isAnalyzeTransportTaskListEnabled(Map<String,Object> options){		 		
 		return TransportTruckTokens.of(options).analyzeTransportTaskListEnabled();
 	}
	
	protected boolean isSaveTransportTaskListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportTruckTokens.TRANSPORT_TASK_LIST);
		
 	}
 	
		

	

	protected TransportTruckMapper getTransportTruckMapper(){
		return new TransportTruckMapper();
	}

	
	
	protected TransportTruck extractTransportTruck(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TransportTruck transportTruck = loadSingleObject(accessKey, getTransportTruckMapper());
			return transportTruck;
		}catch(EmptyResultDataAccessException e){
			throw new TransportTruckNotFoundException("TransportTruck("+accessKey+") is not found!");
		}

	}

	
	

	protected TransportTruck loadInternalTransportTruck(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransportTruck transportTruck = extractTransportTruck(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(transportTruck, loadOptions);
 		}
 
		
		if(isExtractTransportTaskListEnabled(loadOptions)){
	 		extractTransportTaskList(transportTruck, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeTransportTaskListEnabled(loadOptions)){
	 		analyzeTransportTaskList(transportTruck, loadOptions);
 		}
 		
		
		return transportTruck;
		
	}

	 

 	protected TransportTruck extractOwner(TransportTruck transportTruck, Map<String,Object> options) throws Exception{

		if(transportTruck.getOwner() == null){
			return transportTruck;
		}
		String ownerId = transportTruck.getOwner().getId();
		if( ownerId == null){
			return transportTruck;
		}
		TransportFleet owner = getTransportFleetDAO().load(ownerId,options);
		if(owner != null){
			transportTruck.setOwner(owner);
		}
		
 		
 		return transportTruck;
 	}
 		
 
		
	protected void enhanceTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected TransportTruck extractTransportTaskList(TransportTruck transportTruck, Map<String,Object> options){
		
		
		if(transportTruck == null){
			return null;
		}
		if(transportTruck.getId() == null){
			return transportTruck;
		}

		
		
		SmartList<TransportTask> transportTaskList = getTransportTaskDAO().findTransportTaskByTruck(transportTruck.getId(),options);
		if(transportTaskList != null){
			enhanceTransportTaskList(transportTaskList,options);
			transportTruck.setTransportTaskList(transportTaskList);
		}
		
		return transportTruck;
	
	}	
	
	protected TransportTruck analyzeTransportTaskList(TransportTruck transportTruck, Map<String,Object> options){
		
		
		if(transportTruck == null){
			return null;
		}
		if(transportTruck.getId() == null){
			return transportTruck;
		}

		
		
		SmartList<TransportTask> transportTaskList = transportTruck.getTransportTaskList();
		if(transportTaskList != null){
			getTransportTaskDAO().analyzeTransportTaskByTruck(transportTaskList, transportTruck.getId(), options);
			
		}
		
		return transportTruck;
	
	}	
	
		
		
  	
 	public SmartList<TransportTruck> findTransportTruckByOwner(String transportFleetId,Map<String,Object> options){
 	
  		SmartList<TransportTruck> resultList = queryWith(TransportTruckTable.COLUMN_OWNER, transportFleetId, options, getTransportTruckMapper());
		// analyzeTransportTruckByOwner(resultList, transportFleetId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportTruck> findTransportTruckByOwner(String transportFleetId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportTruck> resultList =  queryWithRange(TransportTruckTable.COLUMN_OWNER, transportFleetId, options, getTransportTruckMapper(), start, count);
 		//analyzeTransportTruckByOwner(resultList, transportFleetId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportTruckByOwner(SmartList<TransportTruck> resultList, String transportFleetId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countTransportTruckByOwner(String transportFleetId,Map<String,Object> options){

 		return countWith(TransportTruckTable.COLUMN_OWNER, transportFleetId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTruckByOwnerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTruckTable.COLUMN_OWNER, ids, options);
	}
 	
 	
		
		
		

	

	protected TransportTruck saveTransportTruck(TransportTruck  transportTruck){
		
		if(!transportTruck.isChanged()){
			return transportTruck;
		}
		
		
		String SQL=this.getSaveTransportTruckSQL(transportTruck);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportTruckParameters(transportTruck);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transportTruck.incVersion();
		return transportTruck;
	
	}
	public SmartList<TransportTruck> saveTransportTruckList(SmartList<TransportTruck> transportTruckList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportTruckList(transportTruckList);
		
		batchTransportTruckCreate((List<TransportTruck>)lists[CREATE_LIST_INDEX]);
		
		batchTransportTruckUpdate((List<TransportTruck>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TransportTruck transportTruck:transportTruckList){
			if(transportTruck.isChanged()){
				transportTruck.incVersion();
			}
			
		
		}
		
		
		return transportTruckList;
	}

	public SmartList<TransportTruck> removeTransportTruckList(SmartList<TransportTruck> transportTruckList,Map<String,Object> options){
		
		
		super.removeList(transportTruckList, options);
		
		return transportTruckList;
		
		
	}
	
	protected List<Object[]> prepareTransportTruckBatchCreateArgs(List<TransportTruck> transportTruckList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTruck transportTruck:transportTruckList ){
			Object [] parameters = prepareTransportTruckCreateParameters(transportTruck);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransportTruckBatchUpdateArgs(List<TransportTruck> transportTruckList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTruck transportTruck:transportTruckList ){
			if(!transportTruck.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportTruckUpdateParameters(transportTruck);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransportTruckCreate(List<TransportTruck> transportTruckList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportTruckBatchCreateArgs(transportTruckList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransportTruckUpdate(List<TransportTruck> transportTruckList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportTruckBatchUpdateArgs(transportTruckList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransportTruckList(List<TransportTruck> transportTruckList){
		
		List<TransportTruck> transportTruckCreateList=new ArrayList<TransportTruck>();
		List<TransportTruck> transportTruckUpdateList=new ArrayList<TransportTruck>();
		
		for(TransportTruck transportTruck: transportTruckList){
			if(isUpdateRequest(transportTruck)){
				transportTruckUpdateList.add( transportTruck);
				continue;
			}
			transportTruckCreateList.add(transportTruck);
		}
		
		return new Object[]{transportTruckCreateList,transportTruckUpdateList};
	}
	
	protected boolean isUpdateRequest(TransportTruck transportTruck){
 		return transportTruck.getVersion() > 0;
 	}
 	protected String getSaveTransportTruckSQL(TransportTruck transportTruck){
 		if(isUpdateRequest(transportTruck)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransportTruckParameters(TransportTruck transportTruck){
 		if(isUpdateRequest(transportTruck) ){
 			return prepareTransportTruckUpdateParameters(transportTruck);
 		}
 		return prepareTransportTruckCreateParameters(transportTruck);
 	}
 	protected Object[] prepareTransportTruckUpdateParameters(TransportTruck transportTruck){
 		Object[] parameters = new Object[12];
 
 		
 		parameters[0] = transportTruck.getName();
 		
 		
 		parameters[1] = transportTruck.getPlateNumber();
 		
 		
 		parameters[2] = transportTruck.getContactNumber();
 		
 		
 		parameters[3] = transportTruck.getVehicleLicenseNumber();
 		
 		
 		parameters[4] = transportTruck.getEngineNumber();
 		
 		
 		parameters[5] = transportTruck.getMakeDate();
 		
 		
 		parameters[6] = transportTruck.getMileage();
 		
 		
 		parameters[7] = transportTruck.getBodyColor();
 		 	
 		if(transportTruck.getOwner() != null){
 			parameters[8] = transportTruck.getOwner().getId();
 		}
 		
 		parameters[9] = transportTruck.nextVersion();
 		parameters[10] = transportTruck.getId();
 		parameters[11] = transportTruck.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransportTruckCreateParameters(TransportTruck transportTruck){
		Object[] parameters = new Object[10];
		String newTransportTruckId=getNextId();
		transportTruck.setId(newTransportTruckId);
		parameters[0] =  transportTruck.getId();
 
 		
 		parameters[1] = transportTruck.getName();
 		
 		
 		parameters[2] = transportTruck.getPlateNumber();
 		
 		
 		parameters[3] = transportTruck.getContactNumber();
 		
 		
 		parameters[4] = transportTruck.getVehicleLicenseNumber();
 		
 		
 		parameters[5] = transportTruck.getEngineNumber();
 		
 		
 		parameters[6] = transportTruck.getMakeDate();
 		
 		
 		parameters[7] = transportTruck.getMileage();
 		
 		
 		parameters[8] = transportTruck.getBodyColor();
 		 	
 		if(transportTruck.getOwner() != null){
 			parameters[9] = transportTruck.getOwner().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected TransportTruck saveInternalTransportTruck(TransportTruck transportTruck, Map<String,Object> options){
		
		saveTransportTruck(transportTruck);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(transportTruck, options);
 		}
 
		
		if(isSaveTransportTaskListEnabled(options)){
	 		saveTransportTaskList(transportTruck, options);
	 		//removeTransportTaskList(transportTruck, options);
	 		//Not delete the record
	 		
 		}		
		
		return transportTruck;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TransportTruck saveOwner(TransportTruck transportTruck, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTruck.getOwner() == null){
 			return transportTruck;//do nothing when it is null
 		}
 		
 		getTransportFleetDAO().save(transportTruck.getOwner(),options);
 		return transportTruck;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public TransportTruck planToRemoveTransportTaskList(TransportTruck transportTruck, String transportTaskIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.TRUCK_PROPERTY, transportTruck.getId());
		key.put(TransportTask.ID_PROPERTY, transportTaskIds);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportTruck;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportTruck;
		}
		
		for(TransportTask transportTaskItem: externalTransportTaskList){

			transportTaskItem.clearFromAll();
		}
		
		
		SmartList<TransportTask> transportTaskList = transportTruck.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportTruck;	
	
	}


	//disconnect TransportTruck with end in TransportTask
	public TransportTruck planToRemoveTransportTaskListWithEnd(TransportTruck transportTruck, String endId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.TRUCK_PROPERTY, transportTruck.getId());
		key.put(TransportTask.END_PROPERTY, endId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportTruck;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportTruck;
		}
		
		for(TransportTask transportTaskItem: externalTransportTaskList){
			transportTaskItem.clearEnd();
			transportTaskItem.clearTruck();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = transportTruck.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportTruck;
	}
	
	public int countTransportTaskListWithEnd(String transportTruckId, String endId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.TRUCK_PROPERTY, transportTruckId);
		key.put(TransportTask.END_PROPERTY, endId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTruck with driver in TransportTask
	public TransportTruck planToRemoveTransportTaskListWithDriver(TransportTruck transportTruck, String driverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.TRUCK_PROPERTY, transportTruck.getId());
		key.put(TransportTask.DRIVER_PROPERTY, driverId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportTruck;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportTruck;
		}
		
		for(TransportTask transportTaskItem: externalTransportTaskList){
			transportTaskItem.clearDriver();
			transportTaskItem.clearTruck();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = transportTruck.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportTruck;
	}
	
	public int countTransportTaskListWithDriver(String transportTruckId, String driverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.TRUCK_PROPERTY, transportTruckId);
		key.put(TransportTask.DRIVER_PROPERTY, driverId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect TransportTruck with belongs_to in TransportTask
	public TransportTruck planToRemoveTransportTaskListWithBelongsTo(TransportTruck transportTruck, String belongsToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.TRUCK_PROPERTY, transportTruck.getId());
		key.put(TransportTask.BELONGS_TO_PROPERTY, belongsToId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportTruck;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportTruck;
		}
		
		for(TransportTask transportTaskItem: externalTransportTaskList){
			transportTaskItem.clearBelongsTo();
			transportTaskItem.clearTruck();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = transportTruck.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportTruck;
	}
	
	public int countTransportTaskListWithBelongsTo(String transportTruckId, String belongsToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.TRUCK_PROPERTY, transportTruckId);
		key.put(TransportTask.BELONGS_TO_PROPERTY, belongsToId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	

		
	protected TransportTruck saveTransportTaskList(TransportTruck transportTruck, Map<String,Object> options){
		
		
		
		
		SmartList<TransportTask> transportTaskList = transportTruck.getTransportTaskList();
		if(transportTaskList == null){
			//null list means nothing
			return transportTruck;
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
		
		
		return transportTruck;
	
	}
	
	protected TransportTruck removeTransportTaskList(TransportTruck transportTruck, Map<String,Object> options){
	
	
		SmartList<TransportTask> transportTaskList = transportTruck.getTransportTaskList();
		if(transportTaskList == null){
			return transportTruck;
		}	
	
		SmartList<TransportTask> toRemoveTransportTaskList = transportTaskList.getToRemoveList();
		
		if(toRemoveTransportTaskList == null){
			return transportTruck;
		}
		if(toRemoveTransportTaskList.isEmpty()){
			return transportTruck;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskList,options);
		
		return transportTruck;
	
	}
	
	

 	
 	
	
	
	
		

	public TransportTruck present(TransportTruck transportTruck,Map<String, Object> options){
	
		presentTransportTaskList(transportTruck,options);

		return transportTruck;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected TransportTruck presentTransportTaskList(
			TransportTruck transportTruck,
			Map<String, Object> options) {

		SmartList<TransportTask> transportTaskList = transportTruck.getTransportTaskList();		
				SmartList<TransportTask> newList= presentSubList(transportTruck.getId(),
				transportTaskList,
				options,
				getTransportTaskDAO()::countTransportTaskByTruck,
				getTransportTaskDAO()::findTransportTaskByTruck
				);

		
		transportTruck.setTransportTaskList(newList);
		

		return transportTruck;
	}			
		

	
    public SmartList<TransportTruck> requestCandidateTransportTruckForTransportTask(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TransportTruckTable.COLUMN_NAME, TransportTruckTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getTransportTruckMapper());
    }
		

	protected String getTableName(){
		return TransportTruckTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<TransportTruck> transportTruckList) {		
		this.enhanceListInternal(transportTruckList, this.getTransportTruckMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:TransportTask的truck的TransportTaskList
	public SmartList<TransportTask> loadOurTransportTaskList(RetailscmUserContext userContext, List<TransportTruck> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.TRUCK_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<TransportTask> loadedObjs = userContext.getDAOGroup().getTransportTaskDAO().findTransportTaskWithKey(key, options);
		Map<String, List<TransportTask>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getTruck().getId()));
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
		List<TransportTruck> transportTruckList = ownerEntity.collectRefsWithType(TransportTruck.INTERNAL_TYPE);
		this.enhanceList(transportTruckList);
		
	}
	
	@Override
	public SmartList<TransportTruck> findTransportTruckWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTransportTruckMapper());

	}
	@Override
	public int countTransportTruckWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTransportTruckWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<TransportTruck> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTransportTruckMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateTransportTruck executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateTransportTruck result = new CandidateTransportTruck();
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
	
	

}


