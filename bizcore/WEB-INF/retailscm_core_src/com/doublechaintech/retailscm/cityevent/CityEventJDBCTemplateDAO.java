
package com.doublechaintech.retailscm.cityevent;

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


import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.doublechaintech.retailscm.eventattendance.EventAttendanceDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class CityEventJDBCTemplateDAO extends RetailscmBaseDAOImpl implements CityEventDAO{

	protected RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO;
	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO){
 	
 		if(retailStoreCityServiceCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCityServiceCenterDAO to null.");
 		}
	 	this.retailStoreCityServiceCenterDAO = retailStoreCityServiceCenterDAO;
 	}
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
 		if(this.retailStoreCityServiceCenterDAO == null){
 			throw new IllegalStateException("The retailStoreCityServiceCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreCityServiceCenterDAO;
 	}	

	protected EventAttendanceDAO eventAttendanceDAO;
	public void setEventAttendanceDAO(EventAttendanceDAO eventAttendanceDAO){
 	
 		if(eventAttendanceDAO == null){
 			throw new IllegalStateException("Do not try to set eventAttendanceDAO to null.");
 		}
	 	this.eventAttendanceDAO = eventAttendanceDAO;
 	}
 	public EventAttendanceDAO getEventAttendanceDAO(){
 		if(this.eventAttendanceDAO == null){
 			throw new IllegalStateException("The eventAttendanceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.eventAttendanceDAO;
 	}	

	
	/*
	protected CityEvent load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCityEvent(accessKey, options);
	}
	*/
	
	public SmartList<CityEvent> loadAll() {
	    return this.loadAll(getCityEventMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public CityEvent load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCityEvent(CityEventTable.withId(id), options);
	}
	
	
	
	public CityEvent save(CityEvent cityEvent,Map<String,Object> options){
		
		String methodName="save(CityEvent cityEvent,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(cityEvent, methodName, "cityEvent");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCityEvent(cityEvent,options);
	}
	public CityEvent clone(String cityEventId, Map<String,Object> options) throws Exception{
	
		return clone(CityEventTable.withId(cityEventId),options);
	}
	
	protected CityEvent clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String cityEventId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		CityEvent newCityEvent = loadInternalCityEvent(accessKey, options);
		newCityEvent.setVersion(0);
		
		
 		
 		if(isSaveEventAttendanceListEnabled(options)){
 			for(EventAttendance item: newCityEvent.getEventAttendanceList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalCityEvent(newCityEvent,options);
		
		return newCityEvent;
	}
	
	
	
	

	protected void throwIfHasException(String cityEventId,int version,int count) throws Exception{
		if (count == 1) {
			throw new CityEventVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CityEventNotFoundException(
					"The " + this.getTableName() + "(" + cityEventId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String cityEventId, int version) throws Exception{
	
		String methodName="delete(String cityEventId, int version)";
		assertMethodArgumentNotNull(cityEventId, methodName, "cityEventId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{cityEventId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(cityEventId,version);
		}
		
	
	}
	
	
	
	
	

	public CityEvent disconnectFromAll(String cityEventId, int version) throws Exception{
	
		
		CityEvent cityEvent = loadInternalCityEvent(CityEventTable.withId(cityEventId), emptyOptions());
		cityEvent.clearFromAll();
		this.saveCityEvent(cityEvent);
		return cityEvent;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return CityEventTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "city_event";
	}
	@Override
	protected String getBeanName() {
		
		return "cityEvent";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CityEventTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractCityServiceCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CityEventTokens.CITYSERVICECENTER);
 	}

 	protected boolean isSaveCityServiceCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CityEventTokens.CITYSERVICECENTER);
 	}
 	

 	
 
		
	
	protected boolean isExtractEventAttendanceListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CityEventTokens.EVENT_ATTENDANCE_LIST);
 	}
 	protected boolean isAnalyzeEventAttendanceListEnabled(Map<String,Object> options){		 		
 		return CityEventTokens.of(options).analyzeEventAttendanceListEnabled();
 	}
	
	protected boolean isSaveEventAttendanceListEnabled(Map<String,Object> options){
		return checkOptions(options, CityEventTokens.EVENT_ATTENDANCE_LIST);
		
 	}
 	
		

	

	protected CityEventMapper getCityEventMapper(){
		return new CityEventMapper();
	}

	
	
	protected CityEvent extractCityEvent(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			CityEvent cityEvent = loadSingleObject(accessKey, getCityEventMapper());
			return cityEvent;
		}catch(EmptyResultDataAccessException e){
			throw new CityEventNotFoundException("CityEvent("+accessKey+") is not found!");
		}

	}

	
	

	protected CityEvent loadInternalCityEvent(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		CityEvent cityEvent = extractCityEvent(accessKey, loadOptions);
 	
 		if(isExtractCityServiceCenterEnabled(loadOptions)){
	 		extractCityServiceCenter(cityEvent, loadOptions);
 		}
 
		
		if(isExtractEventAttendanceListEnabled(loadOptions)){
	 		extractEventAttendanceList(cityEvent, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeEventAttendanceListEnabled(loadOptions)){
	 		analyzeEventAttendanceList(cityEvent, loadOptions);
 		}
 		
		
		return cityEvent;
		
	}

	 

 	protected CityEvent extractCityServiceCenter(CityEvent cityEvent, Map<String,Object> options) throws Exception{

		if(cityEvent.getCityServiceCenter() == null){
			return cityEvent;
		}
		String cityServiceCenterId = cityEvent.getCityServiceCenter().getId();
		if( cityServiceCenterId == null){
			return cityEvent;
		}
		RetailStoreCityServiceCenter cityServiceCenter = getRetailStoreCityServiceCenterDAO().load(cityServiceCenterId,options);
		if(cityServiceCenter != null){
			cityEvent.setCityServiceCenter(cityServiceCenter);
		}
		
 		
 		return cityEvent;
 	}
 		
 
		
	protected void enhanceEventAttendanceList(SmartList<EventAttendance> eventAttendanceList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected CityEvent extractEventAttendanceList(CityEvent cityEvent, Map<String,Object> options){
		
		
		if(cityEvent == null){
			return null;
		}
		if(cityEvent.getId() == null){
			return cityEvent;
		}

		
		
		SmartList<EventAttendance> eventAttendanceList = getEventAttendanceDAO().findEventAttendanceByCityEvent(cityEvent.getId(),options);
		if(eventAttendanceList != null){
			enhanceEventAttendanceList(eventAttendanceList,options);
			cityEvent.setEventAttendanceList(eventAttendanceList);
		}
		
		return cityEvent;
	
	}	
	
	protected CityEvent analyzeEventAttendanceList(CityEvent cityEvent, Map<String,Object> options){
		
		
		if(cityEvent == null){
			return null;
		}
		if(cityEvent.getId() == null){
			return cityEvent;
		}

		
		
		SmartList<EventAttendance> eventAttendanceList = cityEvent.getEventAttendanceList();
		if(eventAttendanceList != null){
			getEventAttendanceDAO().analyzeEventAttendanceByCityEvent(eventAttendanceList, cityEvent.getId(), options);
			
		}
		
		return cityEvent;
	
	}	
	
		
		
  	
 	public SmartList<CityEvent> findCityEventByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){
 	
  		SmartList<CityEvent> resultList = queryWith(CityEventTable.COLUMN_CITY_SERVICE_CENTER, retailStoreCityServiceCenterId, options, getCityEventMapper());
		// analyzeCityEventByCityServiceCenter(resultList, retailStoreCityServiceCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<CityEvent> findCityEventByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<CityEvent> resultList =  queryWithRange(CityEventTable.COLUMN_CITY_SERVICE_CENTER, retailStoreCityServiceCenterId, options, getCityEventMapper(), start, count);
 		//analyzeCityEventByCityServiceCenter(resultList, retailStoreCityServiceCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeCityEventByCityServiceCenter(SmartList<CityEvent> resultList, String retailStoreCityServiceCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(CityEvent.CITY_SERVICE_CENTER_PROPERTY, retailStoreCityServiceCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//CityEvent.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("城市活动");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(CityEvent.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(CityEvent.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countCityEventByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){

 		return countWith(CityEventTable.COLUMN_CITY_SERVICE_CENTER, retailStoreCityServiceCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countCityEventByCityServiceCenterIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CityEventTable.COLUMN_CITY_SERVICE_CENTER, ids, options);
	}
 	
 	
		
		
		

	

	protected CityEvent saveCityEvent(CityEvent  cityEvent){
		
		if(!cityEvent.isChanged()){
			return cityEvent;
		}
		
		
		String SQL=this.getSaveCityEventSQL(cityEvent);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCityEventParameters(cityEvent);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		cityEvent.incVersion();
		return cityEvent;
	
	}
	public SmartList<CityEvent> saveCityEventList(SmartList<CityEvent> cityEventList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCityEventList(cityEventList);
		
		batchCityEventCreate((List<CityEvent>)lists[CREATE_LIST_INDEX]);
		
		batchCityEventUpdate((List<CityEvent>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(CityEvent cityEvent:cityEventList){
			if(cityEvent.isChanged()){
				cityEvent.incVersion();
			}
			
		
		}
		
		
		return cityEventList;
	}

	public SmartList<CityEvent> removeCityEventList(SmartList<CityEvent> cityEventList,Map<String,Object> options){
		
		
		super.removeList(cityEventList, options);
		
		return cityEventList;
		
		
	}
	
	protected List<Object[]> prepareCityEventBatchCreateArgs(List<CityEvent> cityEventList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CityEvent cityEvent:cityEventList ){
			Object [] parameters = prepareCityEventCreateParameters(cityEvent);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareCityEventBatchUpdateArgs(List<CityEvent> cityEventList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CityEvent cityEvent:cityEventList ){
			if(!cityEvent.isChanged()){
				continue;
			}
			Object [] parameters = prepareCityEventUpdateParameters(cityEvent);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCityEventCreate(List<CityEvent> cityEventList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCityEventBatchCreateArgs(cityEventList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchCityEventUpdate(List<CityEvent> cityEventList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCityEventBatchUpdateArgs(cityEventList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCityEventList(List<CityEvent> cityEventList){
		
		List<CityEvent> cityEventCreateList=new ArrayList<CityEvent>();
		List<CityEvent> cityEventUpdateList=new ArrayList<CityEvent>();
		
		for(CityEvent cityEvent: cityEventList){
			if(isUpdateRequest(cityEvent)){
				cityEventUpdateList.add( cityEvent);
				continue;
			}
			cityEventCreateList.add(cityEvent);
		}
		
		return new Object[]{cityEventCreateList,cityEventUpdateList};
	}
	
	protected boolean isUpdateRequest(CityEvent cityEvent){
 		return cityEvent.getVersion() > 0;
 	}
 	protected String getSaveCityEventSQL(CityEvent cityEvent){
 		if(isUpdateRequest(cityEvent)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCityEventParameters(CityEvent cityEvent){
 		if(isUpdateRequest(cityEvent) ){
 			return prepareCityEventUpdateParameters(cityEvent);
 		}
 		return prepareCityEventCreateParameters(cityEvent);
 	}
 	protected Object[] prepareCityEventUpdateParameters(CityEvent cityEvent){
 		Object[] parameters = new Object[8];
 
 		
 		parameters[0] = cityEvent.getName();
 		
 		
 		parameters[1] = cityEvent.getMobile();
 		 	
 		if(cityEvent.getCityServiceCenter() != null){
 			parameters[2] = cityEvent.getCityServiceCenter().getId();
 		}
 
 		
 		parameters[3] = cityEvent.getDescription();
 		
 		
 		parameters[4] = cityEvent.getLastUpdateTime();
 				
 		parameters[5] = cityEvent.nextVersion();
 		parameters[6] = cityEvent.getId();
 		parameters[7] = cityEvent.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCityEventCreateParameters(CityEvent cityEvent){
		Object[] parameters = new Object[6];
		String newCityEventId=getNextId();
		cityEvent.setId(newCityEventId);
		parameters[0] =  cityEvent.getId();
 
 		
 		parameters[1] = cityEvent.getName();
 		
 		
 		parameters[2] = cityEvent.getMobile();
 		 	
 		if(cityEvent.getCityServiceCenter() != null){
 			parameters[3] = cityEvent.getCityServiceCenter().getId();
 		
 		}
 		
 		
 		parameters[4] = cityEvent.getDescription();
 		
 		
 		parameters[5] = cityEvent.getLastUpdateTime();
 				
 				
 		return parameters;
 	}
 	
	protected CityEvent saveInternalCityEvent(CityEvent cityEvent, Map<String,Object> options){
		
		saveCityEvent(cityEvent);
 	
 		if(isSaveCityServiceCenterEnabled(options)){
	 		saveCityServiceCenter(cityEvent, options);
 		}
 
		
		if(isSaveEventAttendanceListEnabled(options)){
	 		saveEventAttendanceList(cityEvent, options);
	 		//removeEventAttendanceList(cityEvent, options);
	 		//Not delete the record
	 		
 		}		
		
		return cityEvent;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected CityEvent saveCityServiceCenter(CityEvent cityEvent, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(cityEvent.getCityServiceCenter() == null){
 			return cityEvent;//do nothing when it is null
 		}
 		
 		getRetailStoreCityServiceCenterDAO().save(cityEvent.getCityServiceCenter(),options);
 		return cityEvent;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public CityEvent planToRemoveEventAttendanceList(CityEvent cityEvent, String eventAttendanceIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EventAttendance.CITY_EVENT_PROPERTY, cityEvent.getId());
		key.put(EventAttendance.ID_PROPERTY, eventAttendanceIds);
		
		SmartList<EventAttendance> externalEventAttendanceList = getEventAttendanceDAO().
				findEventAttendanceWithKey(key, options);
		if(externalEventAttendanceList == null){
			return cityEvent;
		}
		if(externalEventAttendanceList.isEmpty()){
			return cityEvent;
		}
		
		for(EventAttendance eventAttendanceItem: externalEventAttendanceList){

			eventAttendanceItem.clearFromAll();
		}
		
		
		SmartList<EventAttendance> eventAttendanceList = cityEvent.getEventAttendanceList();		
		eventAttendanceList.addAllToRemoveList(externalEventAttendanceList);
		return cityEvent;	
	
	}


	//disconnect CityEvent with potential_customer in EventAttendance
	public CityEvent planToRemoveEventAttendanceListWithPotentialCustomer(CityEvent cityEvent, String potentialCustomerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EventAttendance.CITY_EVENT_PROPERTY, cityEvent.getId());
		key.put(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerId);
		
		SmartList<EventAttendance> externalEventAttendanceList = getEventAttendanceDAO().
				findEventAttendanceWithKey(key, options);
		if(externalEventAttendanceList == null){
			return cityEvent;
		}
		if(externalEventAttendanceList.isEmpty()){
			return cityEvent;
		}
		
		for(EventAttendance eventAttendanceItem: externalEventAttendanceList){
			eventAttendanceItem.clearPotentialCustomer();
			eventAttendanceItem.clearCityEvent();
			
		}
		
		
		SmartList<EventAttendance> eventAttendanceList = cityEvent.getEventAttendanceList();		
		eventAttendanceList.addAllToRemoveList(externalEventAttendanceList);
		return cityEvent;
	}
	
	public int countEventAttendanceListWithPotentialCustomer(String cityEventId, String potentialCustomerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EventAttendance.CITY_EVENT_PROPERTY, cityEventId);
		key.put(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerId);
		
		int count = getEventAttendanceDAO().countEventAttendanceWithKey(key, options);
		return count;
	}
	

		
	protected CityEvent saveEventAttendanceList(CityEvent cityEvent, Map<String,Object> options){
		
		
		
		
		SmartList<EventAttendance> eventAttendanceList = cityEvent.getEventAttendanceList();
		if(eventAttendanceList == null){
			//null list means nothing
			return cityEvent;
		}
		SmartList<EventAttendance> mergedUpdateEventAttendanceList = new SmartList<EventAttendance>();
		
		
		mergedUpdateEventAttendanceList.addAll(eventAttendanceList); 
		if(eventAttendanceList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateEventAttendanceList.addAll(eventAttendanceList.getToRemoveList());
			eventAttendanceList.removeAll(eventAttendanceList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getEventAttendanceDAO().saveEventAttendanceList(mergedUpdateEventAttendanceList,options);
		
		if(eventAttendanceList.getToRemoveList() != null){
			eventAttendanceList.removeAll(eventAttendanceList.getToRemoveList());
		}
		
		
		return cityEvent;
	
	}
	
	protected CityEvent removeEventAttendanceList(CityEvent cityEvent, Map<String,Object> options){
	
	
		SmartList<EventAttendance> eventAttendanceList = cityEvent.getEventAttendanceList();
		if(eventAttendanceList == null){
			return cityEvent;
		}	
	
		SmartList<EventAttendance> toRemoveEventAttendanceList = eventAttendanceList.getToRemoveList();
		
		if(toRemoveEventAttendanceList == null){
			return cityEvent;
		}
		if(toRemoveEventAttendanceList.isEmpty()){
			return cityEvent;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEventAttendanceDAO().removeEventAttendanceList(toRemoveEventAttendanceList,options);
		
		return cityEvent;
	
	}
	
	

 	
 	
	
	
	
		

	public CityEvent present(CityEvent cityEvent,Map<String, Object> options){
	
		presentEventAttendanceList(cityEvent,options);

		return cityEvent;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected CityEvent presentEventAttendanceList(
			CityEvent cityEvent,
			Map<String, Object> options) {

		SmartList<EventAttendance> eventAttendanceList = cityEvent.getEventAttendanceList();		
				SmartList<EventAttendance> newList= presentSubList(cityEvent.getId(),
				eventAttendanceList,
				options,
				getEventAttendanceDAO()::countEventAttendanceByCityEvent,
				getEventAttendanceDAO()::findEventAttendanceByCityEvent
				);

		
		cityEvent.setEventAttendanceList(newList);
		

		return cityEvent;
	}			
		

	
    public SmartList<CityEvent> requestCandidateCityEventForEventAttendance(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CityEventTable.COLUMN_NAME, CityEventTable.COLUMN_CITY_SERVICE_CENTER, filterKey, pageNo, pageSize, getCityEventMapper());
    }
		

	protected String getTableName(){
		return CityEventTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<CityEvent> cityEventList) {		
		this.enhanceListInternal(cityEventList, this.getCityEventMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:EventAttendance的cityEvent的EventAttendanceList
	public SmartList<EventAttendance> loadOurEventAttendanceList(RetailscmUserContext userContext, List<CityEvent> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EventAttendance.CITY_EVENT_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<EventAttendance> loadedObjs = userContext.getDAOGroup().getEventAttendanceDAO().findEventAttendanceWithKey(key, options);
		Map<String, List<EventAttendance>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCityEvent().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<EventAttendance> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<EventAttendance> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setEventAttendanceList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<CityEvent> cityEventList = ownerEntity.collectRefsWithType(CityEvent.INTERNAL_TYPE);
		this.enhanceList(cityEventList);
		
	}
	
	@Override
	public SmartList<CityEvent> findCityEventWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getCityEventMapper());

	}
	@Override
	public int countCityEventWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countCityEventWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<CityEvent> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getCityEventMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateCityEvent executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateCityEvent result = new CandidateCityEvent();
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


