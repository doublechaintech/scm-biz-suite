
package com.doublechaintech.retailscm.transportfleet;

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


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.transporttruck.TransportTruckDAO;
import com.doublechaintech.retailscm.truckdriver.TruckDriverDAO;
import com.doublechaintech.retailscm.transporttask.TransportTaskDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class TransportFleetJDBCTemplateDAO extends RetailscmBaseDAOImpl implements TransportFleetDAO{

	protected RetailStoreCountryCenterDAO retailStoreCountryCenterDAO;
	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){

 		if(retailStoreCountryCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCountryCenterDAO to null.");
 		}
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
 		if(this.retailStoreCountryCenterDAO == null){
 			throw new IllegalStateException("The retailStoreCountryCenterDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreCountryCenterDAO;
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
	protected TransportFleet load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportFleet(accessKey, options);
	}
	*/

	public SmartList<TransportFleet> loadAll() {
	    return this.loadAll(getTransportFleetMapper());
	}

  public Stream<TransportFleet> loadAllAsStream() {
      return this.loadAllAsStream(getTransportFleetMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public TransportFleet load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportFleet(TransportFleetTable.withId(id), options);
	}

	

	public TransportFleet save(TransportFleet transportFleet,Map<String,Object> options){

		String methodName="save(TransportFleet transportFleet,Map<String,Object> options)";

		assertMethodArgumentNotNull(transportFleet, methodName, "transportFleet");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalTransportFleet(transportFleet,options);
	}
	public TransportFleet clone(String transportFleetId, Map<String,Object> options) throws Exception{

		return clone(TransportFleetTable.withId(transportFleetId),options);
	}

	protected TransportFleet clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String transportFleetId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		TransportFleet newTransportFleet = loadInternalTransportFleet(accessKey, options);
		newTransportFleet.setVersion(0);
		
		

 		if(isSaveTransportTruckListEnabled(options)){
 			for(TransportTruck item: newTransportFleet.getTransportTruckList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveTruckDriverListEnabled(options)){
 			for(TruckDriver item: newTransportFleet.getTruckDriverList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveTransportTaskListEnabled(options)){
 			for(TransportTask item: newTransportFleet.getTransportTaskList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalTransportFleet(newTransportFleet,options);

		return newTransportFleet;
	}

	



	protected void throwIfHasException(String transportFleetId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TransportFleetVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportFleetNotFoundException(
					"The " + this.getTableName() + "(" + transportFleetId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String transportFleetId, int version) throws Exception{

		String methodName="delete(String transportFleetId, int version)";
		assertMethodArgumentNotNull(transportFleetId, methodName, "transportFleetId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportFleetId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportFleetId,version);
		}


	}






	public TransportFleet disconnectFromAll(String transportFleetId, int version) throws Exception{


		TransportFleet transportFleet = loadInternalTransportFleet(TransportFleetTable.withId(transportFleetId), emptyOptions());
		transportFleet.clearFromAll();
		this.saveTransportFleet(transportFleet);
		return transportFleet;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return TransportFleetTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "transport_fleet";
	}
	@Override
	protected String getBeanName() {

		return "transportFleet";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return TransportFleetTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){

	 	return checkOptions(options, TransportFleetTokens.OWNER);
 	}

 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){

 		return checkOptions(options, TransportFleetTokens.OWNER);
 	}



 
		

	protected boolean isExtractTransportTruckListEnabled(Map<String,Object> options){
 		return checkOptions(options,TransportFleetTokens.TRANSPORT_TRUCK_LIST);
 	}
 	protected boolean isAnalyzeTransportTruckListEnabled(Map<String,Object> options){
 		return TransportFleetTokens.of(options).analyzeTransportTruckListEnabled();
 	}

	protected boolean isSaveTransportTruckListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportFleetTokens.TRANSPORT_TRUCK_LIST);

 	}

		

	protected boolean isExtractTruckDriverListEnabled(Map<String,Object> options){
 		return checkOptions(options,TransportFleetTokens.TRUCK_DRIVER_LIST);
 	}
 	protected boolean isAnalyzeTruckDriverListEnabled(Map<String,Object> options){
 		return TransportFleetTokens.of(options).analyzeTruckDriverListEnabled();
 	}

	protected boolean isSaveTruckDriverListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportFleetTokens.TRUCK_DRIVER_LIST);

 	}

		

	protected boolean isExtractTransportTaskListEnabled(Map<String,Object> options){
 		return checkOptions(options,TransportFleetTokens.TRANSPORT_TASK_LIST);
 	}
 	protected boolean isAnalyzeTransportTaskListEnabled(Map<String,Object> options){
 		return TransportFleetTokens.of(options).analyzeTransportTaskListEnabled();
 	}

	protected boolean isSaveTransportTaskListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportFleetTokens.TRANSPORT_TASK_LIST);

 	}

		

	

	protected TransportFleetMapper getTransportFleetMapper(){
		return new TransportFleetMapper();
	}



	protected TransportFleet extractTransportFleet(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TransportFleet transportFleet = loadSingleObject(accessKey, getTransportFleetMapper());
			return transportFleet;
		}catch(EmptyResultDataAccessException e){
			throw new TransportFleetNotFoundException("TransportFleet("+accessKey+") is not found!");
		}

	}




	protected TransportFleet loadInternalTransportFleet(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		TransportFleet transportFleet = extractTransportFleet(accessKey, loadOptions);

 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(transportFleet, loadOptions);
 		}
 
		
		if(isExtractTransportTruckListEnabled(loadOptions)){
	 		extractTransportTruckList(transportFleet, loadOptions);
 		}

 		
 		if(isAnalyzeTransportTruckListEnabled(loadOptions)){
	 		analyzeTransportTruckList(transportFleet, loadOptions);
 		}
 		
		
		if(isExtractTruckDriverListEnabled(loadOptions)){
	 		extractTruckDriverList(transportFleet, loadOptions);
 		}

 		
 		if(isAnalyzeTruckDriverListEnabled(loadOptions)){
	 		analyzeTruckDriverList(transportFleet, loadOptions);
 		}
 		
		
		if(isExtractTransportTaskListEnabled(loadOptions)){
	 		extractTransportTaskList(transportFleet, loadOptions);
 		}

 		
 		if(isAnalyzeTransportTaskListEnabled(loadOptions)){
	 		analyzeTransportTaskList(transportFleet, loadOptions);
 		}
 		
		
		return transportFleet;

	}

	

 	protected TransportFleet extractOwner(TransportFleet transportFleet, Map<String,Object> options) throws Exception{
  

		if(transportFleet.getOwner() == null){
			return transportFleet;
		}
		String ownerId = transportFleet.getOwner().getId();
		if( ownerId == null){
			return transportFleet;
		}
		RetailStoreCountryCenter owner = getRetailStoreCountryCenterDAO().load(ownerId,options);
		if(owner != null){
			transportFleet.setOwner(owner);
		}


 		return transportFleet;
 	}

 
		
	protected void enhanceTransportTruckList(SmartList<TransportTruck> transportTruckList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected TransportFleet extractTransportTruckList(TransportFleet transportFleet, Map<String,Object> options){
    

		if(transportFleet == null){
			return null;
		}
		if(transportFleet.getId() == null){
			return transportFleet;
		}



		SmartList<TransportTruck> transportTruckList = getTransportTruckDAO().findTransportTruckByOwner(transportFleet.getId(),options);
		if(transportTruckList != null){
			enhanceTransportTruckList(transportTruckList,options);
			transportFleet.setTransportTruckList(transportTruckList);
		}

		return transportFleet;
  
	}

	protected TransportFleet analyzeTransportTruckList(TransportFleet transportFleet, Map<String,Object> options){
     
		if(transportFleet == null){
			return null;
		}
		if(transportFleet.getId() == null){
			return transportFleet;
		}



		SmartList<TransportTruck> transportTruckList = transportFleet.getTransportTruckList();
		if(transportTruckList != null){
			getTransportTruckDAO().analyzeTransportTruckByOwner(transportTruckList, transportFleet.getId(), options);

		}

		return transportFleet;
    
	}

		
	protected void enhanceTruckDriverList(SmartList<TruckDriver> truckDriverList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected TransportFleet extractTruckDriverList(TransportFleet transportFleet, Map<String,Object> options){
    

		if(transportFleet == null){
			return null;
		}
		if(transportFleet.getId() == null){
			return transportFleet;
		}



		SmartList<TruckDriver> truckDriverList = getTruckDriverDAO().findTruckDriverByBelongsTo(transportFleet.getId(),options);
		if(truckDriverList != null){
			enhanceTruckDriverList(truckDriverList,options);
			transportFleet.setTruckDriverList(truckDriverList);
		}

		return transportFleet;
  
	}

	protected TransportFleet analyzeTruckDriverList(TransportFleet transportFleet, Map<String,Object> options){
     
		if(transportFleet == null){
			return null;
		}
		if(transportFleet.getId() == null){
			return transportFleet;
		}



		SmartList<TruckDriver> truckDriverList = transportFleet.getTruckDriverList();
		if(truckDriverList != null){
			getTruckDriverDAO().analyzeTruckDriverByBelongsTo(truckDriverList, transportFleet.getId(), options);

		}

		return transportFleet;
    
	}

		
	protected void enhanceTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected TransportFleet extractTransportTaskList(TransportFleet transportFleet, Map<String,Object> options){
    

		if(transportFleet == null){
			return null;
		}
		if(transportFleet.getId() == null){
			return transportFleet;
		}



		SmartList<TransportTask> transportTaskList = getTransportTaskDAO().findTransportTaskByBelongsTo(transportFleet.getId(),options);
		if(transportTaskList != null){
			enhanceTransportTaskList(transportTaskList,options);
			transportFleet.setTransportTaskList(transportTaskList);
		}

		return transportFleet;
  
	}

	protected TransportFleet analyzeTransportTaskList(TransportFleet transportFleet, Map<String,Object> options){
     
		if(transportFleet == null){
			return null;
		}
		if(transportFleet.getId() == null){
			return transportFleet;
		}



		SmartList<TransportTask> transportTaskList = transportFleet.getTransportTaskList();
		if(transportTaskList != null){
			getTransportTaskDAO().analyzeTransportTaskByBelongsTo(transportTaskList, transportFleet.getId(), options);

		}

		return transportFleet;
    
	}

		

 
 	public SmartList<TransportFleet> findTransportFleetByOwner(String retailStoreCountryCenterId,Map<String,Object> options){

  		SmartList<TransportFleet> resultList = queryWith(TransportFleetTable.COLUMN_OWNER, retailStoreCountryCenterId, options, getTransportFleetMapper());
		// analyzeTransportFleetByOwner(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	

 	public SmartList<TransportFleet> findTransportFleetByOwner(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){

 		SmartList<TransportFleet> resultList =  queryWithRange(TransportFleetTable.COLUMN_OWNER, retailStoreCountryCenterId, options, getTransportFleetMapper(), start, count);
 		//analyzeTransportFleetByOwner(resultList, retailStoreCountryCenterId, options);
 		return resultList;

 	}
 	public void analyzeTransportFleetByOwner(SmartList<TransportFleet> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(TransportFleet.OWNER_PROPERTY, retailStoreCountryCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//TransportFleet.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("运输车队");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(TransportFleet.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(TransportFleet.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 		
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countTransportFleetByOwner(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(TransportFleetTable.COLUMN_OWNER, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportFleetByOwnerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportFleetTable.COLUMN_OWNER, ids, options);
	}

 




	

	protected TransportFleet saveTransportFleet(TransportFleet  transportFleet){
    

		
		if(!transportFleet.isChanged()){
			return transportFleet;
		}
		

    Beans.dbUtil().cacheCleanUp(transportFleet);
		String SQL=this.getSaveTransportFleetSQL(transportFleet);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportFleetParameters(transportFleet);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		transportFleet.incVersion();
		transportFleet.afterSave();
		return transportFleet;

	}
	public SmartList<TransportFleet> saveTransportFleetList(SmartList<TransportFleet> transportFleetList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportFleetList(transportFleetList);

		batchTransportFleetCreate((List<TransportFleet>)lists[CREATE_LIST_INDEX]);

		batchTransportFleetUpdate((List<TransportFleet>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(TransportFleet transportFleet:transportFleetList){
			if(transportFleet.isChanged()){
				transportFleet.incVersion();
				transportFleet.afterSave();
			}


		}


		return transportFleetList;
	}

	public SmartList<TransportFleet> removeTransportFleetList(SmartList<TransportFleet> transportFleetList,Map<String,Object> options){


		super.removeList(transportFleetList, options);

		return transportFleetList;


	}

	protected List<Object[]> prepareTransportFleetBatchCreateArgs(List<TransportFleet> transportFleetList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportFleet transportFleet:transportFleetList ){
			Object [] parameters = prepareTransportFleetCreateParameters(transportFleet);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareTransportFleetBatchUpdateArgs(List<TransportFleet> transportFleetList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportFleet transportFleet:transportFleetList ){
			if(!transportFleet.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportFleetUpdateParameters(transportFleet);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchTransportFleetCreate(List<TransportFleet> transportFleetList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportFleetBatchCreateArgs(transportFleetList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchTransportFleetUpdate(List<TransportFleet> transportFleetList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportFleetBatchUpdateArgs(transportFleetList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitTransportFleetList(List<TransportFleet> transportFleetList){

		List<TransportFleet> transportFleetCreateList=new ArrayList<TransportFleet>();
		List<TransportFleet> transportFleetUpdateList=new ArrayList<TransportFleet>();

		for(TransportFleet transportFleet: transportFleetList){
			if(isUpdateRequest(transportFleet)){
				transportFleetUpdateList.add( transportFleet);
				continue;
			}
			transportFleetCreateList.add(transportFleet);
		}

		return new Object[]{transportFleetCreateList,transportFleetUpdateList};
	}

	protected boolean isUpdateRequest(TransportFleet transportFleet){
 		return transportFleet.getVersion() > 0;
 	}
 	protected String getSaveTransportFleetSQL(TransportFleet transportFleet){
 		if(isUpdateRequest(transportFleet)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveTransportFleetParameters(TransportFleet transportFleet){
 		if(isUpdateRequest(transportFleet) ){
 			return prepareTransportFleetUpdateParameters(transportFleet);
 		}
 		return prepareTransportFleetCreateParameters(transportFleet);
 	}
 	protected Object[] prepareTransportFleetUpdateParameters(TransportFleet transportFleet){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = transportFleet.getName();
 		
 		parameters[1] = transportFleet.getContactNumber();
 		
 		if(transportFleet.getOwner() != null){
 			parameters[2] = transportFleet.getOwner().getId();
 		}
    
 		parameters[3] = transportFleet.getContract();
 		
 		parameters[4] = transportFleet.getLastUpdateTime();
 		
 		parameters[5] = transportFleet.nextVersion();
 		parameters[6] = transportFleet.getId();
 		parameters[7] = transportFleet.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareTransportFleetCreateParameters(TransportFleet transportFleet){
		Object[] parameters = new Object[6];
        if(transportFleet.getId() == null){
          String newTransportFleetId=getNextId();
          transportFleet.setId(newTransportFleetId);
        }
		parameters[0] =  transportFleet.getId();
 
 		parameters[1] = transportFleet.getName();
 		
 		parameters[2] = transportFleet.getContactNumber();
 		
 		if(transportFleet.getOwner() != null){
 			parameters[3] = transportFleet.getOwner().getId();
 		}
 		
 		parameters[4] = transportFleet.getContract();
 		
 		parameters[5] = transportFleet.getLastUpdateTime();
 		

 		return parameters;
 	}

	protected TransportFleet saveInternalTransportFleet(TransportFleet transportFleet, Map<String,Object> options){

 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(transportFleet, options);
 		}
 
   saveTransportFleet(transportFleet);
		
		if(isSaveTransportTruckListEnabled(options)){
	 		saveTransportTruckList(transportFleet, options);
	 		//removeTransportTruckList(transportFleet, options);
	 		//Not delete the record

 		}
		
		if(isSaveTruckDriverListEnabled(options)){
	 		saveTruckDriverList(transportFleet, options);
	 		//removeTruckDriverList(transportFleet, options);
	 		//Not delete the record

 		}
		
		if(isSaveTransportTaskListEnabled(options)){
	 		saveTransportTaskList(transportFleet, options);
	 		//removeTransportTaskList(transportFleet, options);
	 		//Not delete the record

 		}
		
		return transportFleet;

	}



	//======================================================================================
	

 	protected TransportFleet saveOwner(TransportFleet transportFleet, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(transportFleet.getOwner() == null){
 			return transportFleet;//do nothing when it is null
 		}

 		getRetailStoreCountryCenterDAO().save(transportFleet.getOwner(),options);
 		return transportFleet;

 	}
 

	
	public TransportFleet planToRemoveTransportTruckList(TransportFleet transportFleet, String transportTruckIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTruck.OWNER_PROPERTY, transportFleet.getId());
		key.put(TransportTruck.ID_PROPERTY, transportTruckIds);

		SmartList<TransportTruck> externalTransportTruckList = getTransportTruckDAO().
				findTransportTruckWithKey(key, options);
		if(externalTransportTruckList == null){
			return transportFleet;
		}
		if(externalTransportTruckList.isEmpty()){
			return transportFleet;
		}

		for(TransportTruck transportTruckItem: externalTransportTruckList){

			transportTruckItem.clearFromAll();
		}


		SmartList<TransportTruck> transportTruckList = transportFleet.getTransportTruckList();
		transportTruckList.addAllToRemoveList(externalTransportTruckList);
		return transportFleet;

	}


	public TransportFleet planToRemoveTruckDriverList(TransportFleet transportFleet, String truckDriverIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TruckDriver.BELONGS_TO_PROPERTY, transportFleet.getId());
		key.put(TruckDriver.ID_PROPERTY, truckDriverIds);

		SmartList<TruckDriver> externalTruckDriverList = getTruckDriverDAO().
				findTruckDriverWithKey(key, options);
		if(externalTruckDriverList == null){
			return transportFleet;
		}
		if(externalTruckDriverList.isEmpty()){
			return transportFleet;
		}

		for(TruckDriver truckDriverItem: externalTruckDriverList){

			truckDriverItem.clearFromAll();
		}


		SmartList<TruckDriver> truckDriverList = transportFleet.getTruckDriverList();
		truckDriverList.addAllToRemoveList(externalTruckDriverList);
		return transportFleet;

	}


	public TransportFleet planToRemoveTransportTaskList(TransportFleet transportFleet, String transportTaskIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.BELONGS_TO_PROPERTY, transportFleet.getId());
		key.put(TransportTask.ID_PROPERTY, transportTaskIds);

		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportFleet;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportFleet;
		}

		for(TransportTask transportTaskItem: externalTransportTaskList){

			transportTaskItem.clearFromAll();
		}


		SmartList<TransportTask> transportTaskList = transportFleet.getTransportTaskList();
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportFleet;

	}


	//disconnect TransportFleet with end in TransportTask
	public TransportFleet planToRemoveTransportTaskListWithEnd(TransportFleet transportFleet, String endId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.BELONGS_TO_PROPERTY, transportFleet.getId());
		key.put(TransportTask.END_PROPERTY, endId);

		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportFleet;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportFleet;
		}

		for(TransportTask transportTaskItem: externalTransportTaskList){
			transportTaskItem.clearEnd();
			transportTaskItem.clearBelongsTo();

		}


		SmartList<TransportTask> transportTaskList = transportFleet.getTransportTaskList();
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportFleet;
	}

	public int countTransportTaskListWithEnd(String transportFleetId, String endId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.BELONGS_TO_PROPERTY, transportFleetId);
		key.put(TransportTask.END_PROPERTY, endId);

		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect TransportFleet with driver in TransportTask
	public TransportFleet planToRemoveTransportTaskListWithDriver(TransportFleet transportFleet, String driverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.BELONGS_TO_PROPERTY, transportFleet.getId());
		key.put(TransportTask.DRIVER_PROPERTY, driverId);

		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportFleet;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportFleet;
		}

		for(TransportTask transportTaskItem: externalTransportTaskList){
			transportTaskItem.clearDriver();
			transportTaskItem.clearBelongsTo();

		}


		SmartList<TransportTask> transportTaskList = transportFleet.getTransportTaskList();
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportFleet;
	}

	public int countTransportTaskListWithDriver(String transportFleetId, String driverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.BELONGS_TO_PROPERTY, transportFleetId);
		key.put(TransportTask.DRIVER_PROPERTY, driverId);

		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect TransportFleet with truck in TransportTask
	public TransportFleet planToRemoveTransportTaskListWithTruck(TransportFleet transportFleet, String truckId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.BELONGS_TO_PROPERTY, transportFleet.getId());
		key.put(TransportTask.TRUCK_PROPERTY, truckId);

		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return transportFleet;
		}
		if(externalTransportTaskList.isEmpty()){
			return transportFleet;
		}

		for(TransportTask transportTaskItem: externalTransportTaskList){
			transportTaskItem.clearTruck();
			transportTaskItem.clearBelongsTo();

		}


		SmartList<TransportTask> transportTaskList = transportFleet.getTransportTaskList();
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return transportFleet;
	}

	public int countTransportTaskListWithTruck(String transportFleetId, String truckId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.BELONGS_TO_PROPERTY, transportFleetId);
		key.put(TransportTask.TRUCK_PROPERTY, truckId);

		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	

		
	protected TransportFleet saveTransportTruckList(TransportFleet transportFleet, Map<String,Object> options){
    



		SmartList<TransportTruck> transportTruckList = transportFleet.getTransportTruckList();
		if(transportTruckList == null){
			//null list means nothing
			return transportFleet;
		}
		SmartList<TransportTruck> mergedUpdateTransportTruckList = new SmartList<TransportTruck>();


		mergedUpdateTransportTruckList.addAll(transportTruckList);
		if(transportTruckList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportTruckList.addAll(transportTruckList.getToRemoveList());
			transportTruckList.removeAll(transportTruckList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getTransportTruckDAO().saveTransportTruckList(mergedUpdateTransportTruckList,options);

		if(transportTruckList.getToRemoveList() != null){
			transportTruckList.removeAll(transportTruckList.getToRemoveList());
		}


		return transportFleet;

	}

	protected TransportFleet removeTransportTruckList(TransportFleet transportFleet, Map<String,Object> options){


		SmartList<TransportTruck> transportTruckList = transportFleet.getTransportTruckList();
		if(transportTruckList == null){
			return transportFleet;
		}

		SmartList<TransportTruck> toRemoveTransportTruckList = transportTruckList.getToRemoveList();

		if(toRemoveTransportTruckList == null){
			return transportFleet;
		}
		if(toRemoveTransportTruckList.isEmpty()){
			return transportFleet;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getTransportTruckDAO().removeTransportTruckList(toRemoveTransportTruckList,options);

		return transportFleet;

	}








		
	protected TransportFleet saveTruckDriverList(TransportFleet transportFleet, Map<String,Object> options){
    



		SmartList<TruckDriver> truckDriverList = transportFleet.getTruckDriverList();
		if(truckDriverList == null){
			//null list means nothing
			return transportFleet;
		}
		SmartList<TruckDriver> mergedUpdateTruckDriverList = new SmartList<TruckDriver>();


		mergedUpdateTruckDriverList.addAll(truckDriverList);
		if(truckDriverList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTruckDriverList.addAll(truckDriverList.getToRemoveList());
			truckDriverList.removeAll(truckDriverList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getTruckDriverDAO().saveTruckDriverList(mergedUpdateTruckDriverList,options);

		if(truckDriverList.getToRemoveList() != null){
			truckDriverList.removeAll(truckDriverList.getToRemoveList());
		}


		return transportFleet;

	}

	protected TransportFleet removeTruckDriverList(TransportFleet transportFleet, Map<String,Object> options){


		SmartList<TruckDriver> truckDriverList = transportFleet.getTruckDriverList();
		if(truckDriverList == null){
			return transportFleet;
		}

		SmartList<TruckDriver> toRemoveTruckDriverList = truckDriverList.getToRemoveList();

		if(toRemoveTruckDriverList == null){
			return transportFleet;
		}
		if(toRemoveTruckDriverList.isEmpty()){
			return transportFleet;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getTruckDriverDAO().removeTruckDriverList(toRemoveTruckDriverList,options);

		return transportFleet;

	}








		
	protected TransportFleet saveTransportTaskList(TransportFleet transportFleet, Map<String,Object> options){
    



		SmartList<TransportTask> transportTaskList = transportFleet.getTransportTaskList();
		if(transportTaskList == null){
			//null list means nothing
			return transportFleet;
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


		return transportFleet;

	}

	protected TransportFleet removeTransportTaskList(TransportFleet transportFleet, Map<String,Object> options){


		SmartList<TransportTask> transportTaskList = transportFleet.getTransportTaskList();
		if(transportTaskList == null){
			return transportFleet;
		}

		SmartList<TransportTask> toRemoveTransportTaskList = transportTaskList.getToRemoveList();

		if(toRemoveTransportTaskList == null){
			return transportFleet;
		}
		if(toRemoveTransportTaskList.isEmpty()){
			return transportFleet;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskList,options);

		return transportFleet;

	}








		

	public TransportFleet present(TransportFleet transportFleet,Map<String, Object> options){

		presentTransportTruckList(transportFleet,options);
		presentTruckDriverList(transportFleet,options);
		presentTransportTaskList(transportFleet,options);

		return transportFleet;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected TransportFleet presentTransportTruckList(
			TransportFleet transportFleet,
			Map<String, Object> options) {
    
		SmartList<TransportTruck> transportTruckList = transportFleet.getTransportTruckList();
				SmartList<TransportTruck> newList= presentSubList(transportFleet.getId(),
				transportTruckList,
				options,
				getTransportTruckDAO()::countTransportTruckByOwner,
				getTransportTruckDAO()::findTransportTruckByOwner
				);


		transportFleet.setTransportTruckList(newList);


		return transportFleet;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected TransportFleet presentTruckDriverList(
			TransportFleet transportFleet,
			Map<String, Object> options) {
    
		SmartList<TruckDriver> truckDriverList = transportFleet.getTruckDriverList();
				SmartList<TruckDriver> newList= presentSubList(transportFleet.getId(),
				truckDriverList,
				options,
				getTruckDriverDAO()::countTruckDriverByBelongsTo,
				getTruckDriverDAO()::findTruckDriverByBelongsTo
				);


		transportFleet.setTruckDriverList(newList);


		return transportFleet;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected TransportFleet presentTransportTaskList(
			TransportFleet transportFleet,
			Map<String, Object> options) {
    
		SmartList<TransportTask> transportTaskList = transportFleet.getTransportTaskList();
				SmartList<TransportTask> newList= presentSubList(transportFleet.getId(),
				transportTaskList,
				options,
				getTransportTaskDAO()::countTransportTaskByBelongsTo,
				getTransportTaskDAO()::findTransportTaskByBelongsTo
				);


		transportFleet.setTransportTaskList(newList);


		return transportFleet;
	}
		

	
    public SmartList<TransportFleet> requestCandidateTransportFleetForTransportTruck(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TransportFleetTable.COLUMN_NAME, TransportFleetTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getTransportFleetMapper());
    }
		
    public SmartList<TransportFleet> requestCandidateTransportFleetForTruckDriver(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TransportFleetTable.COLUMN_NAME, TransportFleetTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getTransportFleetMapper());
    }
		
    public SmartList<TransportFleet> requestCandidateTransportFleetForTransportTask(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TransportFleetTable.COLUMN_NAME, TransportFleetTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getTransportFleetMapper());
    }
		

	protected String getTableName(){
		return TransportFleetTable.TABLE_NAME;
	}



	public void enhanceList(List<TransportFleet> transportFleetList) {
		this.enhanceListInternal(transportFleetList, this.getTransportFleetMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:TransportTruck的owner的TransportTruckList
	public SmartList<TransportTruck> loadOurTransportTruckList(RetailscmUserContext userContext, List<TransportFleet> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTruck.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<TransportTruck> loadedObjs = userContext.getDAOGroup().getTransportTruckDAO().findTransportTruckWithKey(key, options);
		Map<String, List<TransportTruck>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<TransportTruck> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<TransportTruck> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setTransportTruckList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:TruckDriver的belongsTo的TruckDriverList
	public SmartList<TruckDriver> loadOurTruckDriverList(RetailscmUserContext userContext, List<TransportFleet> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TruckDriver.BELONGS_TO_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<TruckDriver> loadedObjs = userContext.getDAOGroup().getTruckDriverDAO().findTruckDriverWithKey(key, options);
		Map<String, List<TruckDriver>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBelongsTo().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<TruckDriver> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<TruckDriver> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setTruckDriverList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:TransportTask的belongsTo的TransportTaskList
	public SmartList<TransportTask> loadOurTransportTaskList(RetailscmUserContext userContext, List<TransportFleet> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.BELONGS_TO_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<TransportTask> loadedObjs = userContext.getDAOGroup().getTransportTaskDAO().findTransportTaskWithKey(key, options);
		Map<String, List<TransportTask>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBelongsTo().getId()));
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
		List<TransportFleet> transportFleetList = ownerEntity.collectRefsWithType(TransportFleet.INTERNAL_TYPE);
		this.enhanceList(transportFleetList);

	}

	@Override
	public SmartList<TransportFleet> findTransportFleetWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getTransportFleetMapper());

	}
	@Override
	public int countTransportFleetWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countTransportFleetWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<TransportFleet> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTransportFleetMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<TransportFleet> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getTransportFleetMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateTransportFleet executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateTransportFleet result = new CandidateTransportFleet();
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
  public List<TransportFleet> search(TransportFleetRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected TransportFleetMapper mapper() {
    return getTransportFleetMapper();
  }
}


