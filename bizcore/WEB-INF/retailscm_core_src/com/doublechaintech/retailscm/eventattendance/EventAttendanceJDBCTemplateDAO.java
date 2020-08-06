
package com.doublechaintech.retailscm.eventattendance;

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


import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEvent;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.doublechaintech.retailscm.cityevent.CityEventDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class EventAttendanceJDBCTemplateDAO extends RetailscmBaseDAOImpl implements EventAttendanceDAO{

	protected PotentialCustomerDAO potentialCustomerDAO;
	public void setPotentialCustomerDAO(PotentialCustomerDAO potentialCustomerDAO){
 	
 		if(potentialCustomerDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerDAO to null.");
 		}
	 	this.potentialCustomerDAO = potentialCustomerDAO;
 	}
 	public PotentialCustomerDAO getPotentialCustomerDAO(){
 		if(this.potentialCustomerDAO == null){
 			throw new IllegalStateException("The potentialCustomerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerDAO;
 	}	

	protected CityEventDAO cityEventDAO;
	public void setCityEventDAO(CityEventDAO cityEventDAO){
 	
 		if(cityEventDAO == null){
 			throw new IllegalStateException("Do not try to set cityEventDAO to null.");
 		}
	 	this.cityEventDAO = cityEventDAO;
 	}
 	public CityEventDAO getCityEventDAO(){
 		if(this.cityEventDAO == null){
 			throw new IllegalStateException("The cityEventDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityEventDAO;
 	}	


	/*
	protected EventAttendance load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEventAttendance(accessKey, options);
	}
	*/

	public SmartList<EventAttendance> loadAll() {
	    return this.loadAll(getEventAttendanceMapper());
	}

  public Stream<EventAttendance> loadAllAsStream() {
      return this.loadAllAsStream(getEventAttendanceMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public EventAttendance load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEventAttendance(EventAttendanceTable.withId(id), options);
	}

	

	public EventAttendance save(EventAttendance eventAttendance,Map<String,Object> options){

		String methodName="save(EventAttendance eventAttendance,Map<String,Object> options)";

		assertMethodArgumentNotNull(eventAttendance, methodName, "eventAttendance");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalEventAttendance(eventAttendance,options);
	}
	public EventAttendance clone(String eventAttendanceId, Map<String,Object> options) throws Exception{

		return clone(EventAttendanceTable.withId(eventAttendanceId),options);
	}

	protected EventAttendance clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String eventAttendanceId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		EventAttendance newEventAttendance = loadInternalEventAttendance(accessKey, options);
		newEventAttendance.setVersion(0);
		
		


		saveInternalEventAttendance(newEventAttendance,options);

		return newEventAttendance;
	}

	



	protected void throwIfHasException(String eventAttendanceId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EventAttendanceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EventAttendanceNotFoundException(
					"The " + this.getTableName() + "(" + eventAttendanceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String eventAttendanceId, int version) throws Exception{

		String methodName="delete(String eventAttendanceId, int version)";
		assertMethodArgumentNotNull(eventAttendanceId, methodName, "eventAttendanceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{eventAttendanceId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(eventAttendanceId,version);
		}


	}






	public EventAttendance disconnectFromAll(String eventAttendanceId, int version) throws Exception{


		EventAttendance eventAttendance = loadInternalEventAttendance(EventAttendanceTable.withId(eventAttendanceId), emptyOptions());
		eventAttendance.clearFromAll();
		this.saveEventAttendance(eventAttendance);
		return eventAttendance;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return EventAttendanceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "event_attendance";
	}
	@Override
	protected String getBeanName() {

		return "eventAttendance";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EventAttendanceTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPotentialCustomerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EventAttendanceTokens.POTENTIALCUSTOMER);
 	}

 	protected boolean isSavePotentialCustomerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EventAttendanceTokens.POTENTIALCUSTOMER);
 	}
 	

 	
  

 	protected boolean isExtractCityEventEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EventAttendanceTokens.CITYEVENT);
 	}

 	protected boolean isSaveCityEventEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EventAttendanceTokens.CITYEVENT);
 	}
 	

 	
 
		

	

	protected EventAttendanceMapper getEventAttendanceMapper(){
		return new EventAttendanceMapper();
	}

	
	
	protected EventAttendance extractEventAttendance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EventAttendance eventAttendance = loadSingleObject(accessKey, getEventAttendanceMapper());
			return eventAttendance;
		}catch(EmptyResultDataAccessException e){
			throw new EventAttendanceNotFoundException("EventAttendance("+accessKey+") is not found!");
		}

	}

	
	

	protected EventAttendance loadInternalEventAttendance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EventAttendance eventAttendance = extractEventAttendance(accessKey, loadOptions);
 	
 		if(isExtractPotentialCustomerEnabled(loadOptions)){
	 		extractPotentialCustomer(eventAttendance, loadOptions);
 		}
  	
 		if(isExtractCityEventEnabled(loadOptions)){
	 		extractCityEvent(eventAttendance, loadOptions);
 		}
 
		
		return eventAttendance;
		
	}

	 

 	protected EventAttendance extractPotentialCustomer(EventAttendance eventAttendance, Map<String,Object> options) throws Exception{

		if(eventAttendance.getPotentialCustomer() == null){
			return eventAttendance;
		}
		String potentialCustomerId = eventAttendance.getPotentialCustomer().getId();
		if( potentialCustomerId == null){
			return eventAttendance;
		}
		PotentialCustomer potentialCustomer = getPotentialCustomerDAO().load(potentialCustomerId,options);
		if(potentialCustomer != null){
			eventAttendance.setPotentialCustomer(potentialCustomer);
		}
		
 		
 		return eventAttendance;
 	}
 		
  

 	protected EventAttendance extractCityEvent(EventAttendance eventAttendance, Map<String,Object> options) throws Exception{

		if(eventAttendance.getCityEvent() == null){
			return eventAttendance;
		}
		String cityEventId = eventAttendance.getCityEvent().getId();
		if( cityEventId == null){
			return eventAttendance;
		}
		CityEvent cityEvent = getCityEventDAO().load(cityEventId,options);
		if(cityEvent != null){
			eventAttendance.setCityEvent(cityEvent);
		}
		
 		
 		return eventAttendance;
 	}
 		
 
		
		
  	
 	public SmartList<EventAttendance> findEventAttendanceByPotentialCustomer(String potentialCustomerId,Map<String,Object> options){
 	
  		SmartList<EventAttendance> resultList = queryWith(EventAttendanceTable.COLUMN_POTENTIAL_CUSTOMER, potentialCustomerId, options, getEventAttendanceMapper());
		// analyzeEventAttendanceByPotentialCustomer(resultList, potentialCustomerId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EventAttendance> findEventAttendanceByPotentialCustomer(String potentialCustomerId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EventAttendance> resultList =  queryWithRange(EventAttendanceTable.COLUMN_POTENTIAL_CUSTOMER, potentialCustomerId, options, getEventAttendanceMapper(), start, count);
 		//analyzeEventAttendanceByPotentialCustomer(resultList, potentialCustomerId, options);
 		return resultList;
 		
 	}
 	public void analyzeEventAttendanceByPotentialCustomer(SmartList<EventAttendance> resultList, String potentialCustomerId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEventAttendanceByPotentialCustomer(String potentialCustomerId,Map<String,Object> options){

 		return countWith(EventAttendanceTable.COLUMN_POTENTIAL_CUSTOMER, potentialCustomerId, options);
 	}
 	@Override
	public Map<String, Integer> countEventAttendanceByPotentialCustomerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EventAttendanceTable.COLUMN_POTENTIAL_CUSTOMER, ids, options);
	}
 	
  	
 	public SmartList<EventAttendance> findEventAttendanceByCityEvent(String cityEventId,Map<String,Object> options){
 	
  		SmartList<EventAttendance> resultList = queryWith(EventAttendanceTable.COLUMN_CITY_EVENT, cityEventId, options, getEventAttendanceMapper());
		// analyzeEventAttendanceByCityEvent(resultList, cityEventId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EventAttendance> findEventAttendanceByCityEvent(String cityEventId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EventAttendance> resultList =  queryWithRange(EventAttendanceTable.COLUMN_CITY_EVENT, cityEventId, options, getEventAttendanceMapper(), start, count);
 		//analyzeEventAttendanceByCityEvent(resultList, cityEventId, options);
 		return resultList;
 		
 	}
 	public void analyzeEventAttendanceByCityEvent(SmartList<EventAttendance> resultList, String cityEventId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EventAttendance.CITY_EVENT_PROPERTY, cityEventId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEventAttendanceByCityEvent(String cityEventId,Map<String,Object> options){

 		return countWith(EventAttendanceTable.COLUMN_CITY_EVENT, cityEventId, options);
 	}
 	@Override
	public Map<String, Integer> countEventAttendanceByCityEventIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EventAttendanceTable.COLUMN_CITY_EVENT, ids, options);
	}
 	
 	
		
		
		

	

	protected EventAttendance saveEventAttendance(EventAttendance  eventAttendance){
		
		if(!eventAttendance.isChanged()){
			return eventAttendance;
		}
		

		String SQL=this.getSaveEventAttendanceSQL(eventAttendance);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEventAttendanceParameters(eventAttendance);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		eventAttendance.incVersion();
		return eventAttendance;

	}
	public SmartList<EventAttendance> saveEventAttendanceList(SmartList<EventAttendance> eventAttendanceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEventAttendanceList(eventAttendanceList);

		batchEventAttendanceCreate((List<EventAttendance>)lists[CREATE_LIST_INDEX]);

		batchEventAttendanceUpdate((List<EventAttendance>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(EventAttendance eventAttendance:eventAttendanceList){
			if(eventAttendance.isChanged()){
				eventAttendance.incVersion();
			}


		}


		return eventAttendanceList;
	}

	public SmartList<EventAttendance> removeEventAttendanceList(SmartList<EventAttendance> eventAttendanceList,Map<String,Object> options){


		super.removeList(eventAttendanceList, options);

		return eventAttendanceList;


	}

	protected List<Object[]> prepareEventAttendanceBatchCreateArgs(List<EventAttendance> eventAttendanceList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EventAttendance eventAttendance:eventAttendanceList ){
			Object [] parameters = prepareEventAttendanceCreateParameters(eventAttendance);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareEventAttendanceBatchUpdateArgs(List<EventAttendance> eventAttendanceList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EventAttendance eventAttendance:eventAttendanceList ){
			if(!eventAttendance.isChanged()){
				continue;
			}
			Object [] parameters = prepareEventAttendanceUpdateParameters(eventAttendance);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchEventAttendanceCreate(List<EventAttendance> eventAttendanceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEventAttendanceBatchCreateArgs(eventAttendanceList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchEventAttendanceUpdate(List<EventAttendance> eventAttendanceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEventAttendanceBatchUpdateArgs(eventAttendanceList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitEventAttendanceList(List<EventAttendance> eventAttendanceList){

		List<EventAttendance> eventAttendanceCreateList=new ArrayList<EventAttendance>();
		List<EventAttendance> eventAttendanceUpdateList=new ArrayList<EventAttendance>();

		for(EventAttendance eventAttendance: eventAttendanceList){
			if(isUpdateRequest(eventAttendance)){
				eventAttendanceUpdateList.add( eventAttendance);
				continue;
			}
			eventAttendanceCreateList.add(eventAttendance);
		}

		return new Object[]{eventAttendanceCreateList,eventAttendanceUpdateList};
	}

	protected boolean isUpdateRequest(EventAttendance eventAttendance){
 		return eventAttendance.getVersion() > 0;
 	}
 	protected String getSaveEventAttendanceSQL(EventAttendance eventAttendance){
 		if(isUpdateRequest(eventAttendance)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveEventAttendanceParameters(EventAttendance eventAttendance){
 		if(isUpdateRequest(eventAttendance) ){
 			return prepareEventAttendanceUpdateParameters(eventAttendance);
 		}
 		return prepareEventAttendanceCreateParameters(eventAttendance);
 	}
 	protected Object[] prepareEventAttendanceUpdateParameters(EventAttendance eventAttendance){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = eventAttendance.getName();
 		
 		if(eventAttendance.getPotentialCustomer() != null){
 			parameters[1] = eventAttendance.getPotentialCustomer().getId();
 		}
 
 		if(eventAttendance.getCityEvent() != null){
 			parameters[2] = eventAttendance.getCityEvent().getId();
 		}
 
 		
 		parameters[3] = eventAttendance.getDescription();
 		
 		parameters[4] = eventAttendance.nextVersion();
 		parameters[5] = eventAttendance.getId();
 		parameters[6] = eventAttendance.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareEventAttendanceCreateParameters(EventAttendance eventAttendance){
		Object[] parameters = new Object[5];
        if(eventAttendance.getId() == null){
          String newEventAttendanceId=getNextId();
          eventAttendance.setId(newEventAttendanceId);
        }
		parameters[0] =  eventAttendance.getId();
 
 		
 		parameters[1] = eventAttendance.getName();
 		
 		if(eventAttendance.getPotentialCustomer() != null){
 			parameters[2] = eventAttendance.getPotentialCustomer().getId();

 		}
 		
 		if(eventAttendance.getCityEvent() != null){
 			parameters[3] = eventAttendance.getCityEvent().getId();

 		}
 		
 		
 		parameters[4] = eventAttendance.getDescription();
 		

 		return parameters;
 	}

	protected EventAttendance saveInternalEventAttendance(EventAttendance eventAttendance, Map<String,Object> options){

		saveEventAttendance(eventAttendance);

 		if(isSavePotentialCustomerEnabled(options)){
	 		savePotentialCustomer(eventAttendance, options);
 		}
 
 		if(isSaveCityEventEnabled(options)){
	 		saveCityEvent(eventAttendance, options);
 		}
 
		
		return eventAttendance;

	}



	//======================================================================================
	

 	protected EventAttendance savePotentialCustomer(EventAttendance eventAttendance, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(eventAttendance.getPotentialCustomer() == null){
 			return eventAttendance;//do nothing when it is null
 		}

 		getPotentialCustomerDAO().save(eventAttendance.getPotentialCustomer(),options);
 		return eventAttendance;

 	}





 

 	protected EventAttendance saveCityEvent(EventAttendance eventAttendance, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(eventAttendance.getCityEvent() == null){
 			return eventAttendance;//do nothing when it is null
 		}

 		getCityEventDAO().save(eventAttendance.getCityEvent(),options);
 		return eventAttendance;

 	}





 

	

		

	public EventAttendance present(EventAttendance eventAttendance,Map<String, Object> options){
	

		return eventAttendance;
	
	}
		

	

	protected String getTableName(){
		return EventAttendanceTable.TABLE_NAME;
	}



	public void enhanceList(List<EventAttendance> eventAttendanceList) {
		this.enhanceListInternal(eventAttendanceList, this.getEventAttendanceMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EventAttendance> eventAttendanceList = ownerEntity.collectRefsWithType(EventAttendance.INTERNAL_TYPE);
		this.enhanceList(eventAttendanceList);

	}

	@Override
	public SmartList<EventAttendance> findEventAttendanceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getEventAttendanceMapper());

	}
	@Override
	public int countEventAttendanceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countEventAttendanceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<EventAttendance> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEventAttendanceMapper());
	}

  @Override
  public Stream<EventAttendance> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getEventAttendanceMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateEventAttendance executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateEventAttendance result = new CandidateEventAttendance();
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


