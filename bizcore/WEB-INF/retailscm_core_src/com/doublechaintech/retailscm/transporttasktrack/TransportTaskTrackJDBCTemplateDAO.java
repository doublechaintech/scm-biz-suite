
package com.doublechaintech.retailscm.transporttasktrack;

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


import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.transporttask.TransportTaskDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class TransportTaskTrackJDBCTemplateDAO extends RetailscmBaseDAOImpl implements TransportTaskTrackDAO{

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
	protected TransportTaskTrack load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportTaskTrack(accessKey, options);
	}
	*/

	public SmartList<TransportTaskTrack> loadAll() {
	    return this.loadAll(getTransportTaskTrackMapper());
	}

  public Stream<TransportTaskTrack> loadAllAsStream() {
      return this.loadAllAsStream(getTransportTaskTrackMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public TransportTaskTrack load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportTaskTrack(TransportTaskTrackTable.withId(id), options);
	}

	

	public TransportTaskTrack save(TransportTaskTrack transportTaskTrack,Map<String,Object> options){

		String methodName="save(TransportTaskTrack transportTaskTrack,Map<String,Object> options)";

		assertMethodArgumentNotNull(transportTaskTrack, methodName, "transportTaskTrack");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalTransportTaskTrack(transportTaskTrack,options);
	}
	public TransportTaskTrack clone(String transportTaskTrackId, Map<String,Object> options) throws Exception{

		return clone(TransportTaskTrackTable.withId(transportTaskTrackId),options);
	}

	protected TransportTaskTrack clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String transportTaskTrackId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		TransportTaskTrack newTransportTaskTrack = loadInternalTransportTaskTrack(accessKey, options);
		newTransportTaskTrack.setVersion(0);
		
		


		saveInternalTransportTaskTrack(newTransportTaskTrack,options);

		return newTransportTaskTrack;
	}

	



	protected void throwIfHasException(String transportTaskTrackId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TransportTaskTrackVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportTaskTrackNotFoundException(
					"The " + this.getTableName() + "(" + transportTaskTrackId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String transportTaskTrackId, int version) throws Exception{

		String methodName="delete(String transportTaskTrackId, int version)";
		assertMethodArgumentNotNull(transportTaskTrackId, methodName, "transportTaskTrackId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportTaskTrackId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportTaskTrackId,version);
		}


	}






	public TransportTaskTrack disconnectFromAll(String transportTaskTrackId, int version) throws Exception{


		TransportTaskTrack transportTaskTrack = loadInternalTransportTaskTrack(TransportTaskTrackTable.withId(transportTaskTrackId), emptyOptions());
		transportTaskTrack.clearFromAll();
		this.saveTransportTaskTrack(transportTaskTrack);
		return transportTaskTrack;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return TransportTaskTrackTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "transport_task_track";
	}
	@Override
	protected String getBeanName() {

		return "transportTaskTrack";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransportTaskTrackTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractMovementEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTrackTokens.MOVEMENT);
 	}

 	protected boolean isSaveMovementEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTrackTokens.MOVEMENT);
 	}
 	

 	
 
		

	

	protected TransportTaskTrackMapper getTransportTaskTrackMapper(){
		return new TransportTaskTrackMapper();
	}

	
	
	protected TransportTaskTrack extractTransportTaskTrack(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TransportTaskTrack transportTaskTrack = loadSingleObject(accessKey, getTransportTaskTrackMapper());
			return transportTaskTrack;
		}catch(EmptyResultDataAccessException e){
			throw new TransportTaskTrackNotFoundException("TransportTaskTrack("+accessKey+") is not found!");
		}

	}

	
	

	protected TransportTaskTrack loadInternalTransportTaskTrack(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransportTaskTrack transportTaskTrack = extractTransportTaskTrack(accessKey, loadOptions);
 	
 		if(isExtractMovementEnabled(loadOptions)){
	 		extractMovement(transportTaskTrack, loadOptions);
 		}
 
		
		return transportTaskTrack;
		
	}

	 

 	protected TransportTaskTrack extractMovement(TransportTaskTrack transportTaskTrack, Map<String,Object> options) throws Exception{

		if(transportTaskTrack.getMovement() == null){
			return transportTaskTrack;
		}
		String movementId = transportTaskTrack.getMovement().getId();
		if( movementId == null){
			return transportTaskTrack;
		}
		TransportTask movement = getTransportTaskDAO().load(movementId,options);
		if(movement != null){
			transportTaskTrack.setMovement(movement);
		}
		
 		
 		return transportTaskTrack;
 	}
 		
 
		
		
  	
 	public SmartList<TransportTaskTrack> findTransportTaskTrackByMovement(String transportTaskId,Map<String,Object> options){
 	
  		SmartList<TransportTaskTrack> resultList = queryWith(TransportTaskTrackTable.COLUMN_MOVEMENT, transportTaskId, options, getTransportTaskTrackMapper());
		// analyzeTransportTaskTrackByMovement(resultList, transportTaskId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TransportTaskTrack> findTransportTaskTrackByMovement(String transportTaskId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TransportTaskTrack> resultList =  queryWithRange(TransportTaskTrackTable.COLUMN_MOVEMENT, transportTaskId, options, getTransportTaskTrackMapper(), start, count);
 		//analyzeTransportTaskTrackByMovement(resultList, transportTaskId, options);
 		return resultList;
 		
 	}
 	public void analyzeTransportTaskTrackByMovement(SmartList<TransportTaskTrack> resultList, String transportTaskId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countTransportTaskTrackByMovement(String transportTaskId,Map<String,Object> options){

 		return countWith(TransportTaskTrackTable.COLUMN_MOVEMENT, transportTaskId, options);
 	}
 	@Override
	public Map<String, Integer> countTransportTaskTrackByMovementIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TransportTaskTrackTable.COLUMN_MOVEMENT, ids, options);
	}
 	
 	
		
		
		

	

	protected TransportTaskTrack saveTransportTaskTrack(TransportTaskTrack  transportTaskTrack){
		
		if(!transportTaskTrack.isChanged()){
			return transportTaskTrack;
		}
		

		String SQL=this.getSaveTransportTaskTrackSQL(transportTaskTrack);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportTaskTrackParameters(transportTaskTrack);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		transportTaskTrack.incVersion();
		return transportTaskTrack;

	}
	public SmartList<TransportTaskTrack> saveTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportTaskTrackList(transportTaskTrackList);

		batchTransportTaskTrackCreate((List<TransportTaskTrack>)lists[CREATE_LIST_INDEX]);

		batchTransportTaskTrackUpdate((List<TransportTaskTrack>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(TransportTaskTrack transportTaskTrack:transportTaskTrackList){
			if(transportTaskTrack.isChanged()){
				transportTaskTrack.incVersion();
			}


		}


		return transportTaskTrackList;
	}

	public SmartList<TransportTaskTrack> removeTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options){


		super.removeList(transportTaskTrackList, options);

		return transportTaskTrackList;


	}

	protected List<Object[]> prepareTransportTaskTrackBatchCreateArgs(List<TransportTaskTrack> transportTaskTrackList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTaskTrack transportTaskTrack:transportTaskTrackList ){
			Object [] parameters = prepareTransportTaskTrackCreateParameters(transportTaskTrack);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareTransportTaskTrackBatchUpdateArgs(List<TransportTaskTrack> transportTaskTrackList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTaskTrack transportTaskTrack:transportTaskTrackList ){
			if(!transportTaskTrack.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportTaskTrackUpdateParameters(transportTaskTrack);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchTransportTaskTrackCreate(List<TransportTaskTrack> transportTaskTrackList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportTaskTrackBatchCreateArgs(transportTaskTrackList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchTransportTaskTrackUpdate(List<TransportTaskTrack> transportTaskTrackList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportTaskTrackBatchUpdateArgs(transportTaskTrackList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitTransportTaskTrackList(List<TransportTaskTrack> transportTaskTrackList){

		List<TransportTaskTrack> transportTaskTrackCreateList=new ArrayList<TransportTaskTrack>();
		List<TransportTaskTrack> transportTaskTrackUpdateList=new ArrayList<TransportTaskTrack>();

		for(TransportTaskTrack transportTaskTrack: transportTaskTrackList){
			if(isUpdateRequest(transportTaskTrack)){
				transportTaskTrackUpdateList.add( transportTaskTrack);
				continue;
			}
			transportTaskTrackCreateList.add(transportTaskTrack);
		}

		return new Object[]{transportTaskTrackCreateList,transportTaskTrackUpdateList};
	}

	protected boolean isUpdateRequest(TransportTaskTrack transportTaskTrack){
 		return transportTaskTrack.getVersion() > 0;
 	}
 	protected String getSaveTransportTaskTrackSQL(TransportTaskTrack transportTaskTrack){
 		if(isUpdateRequest(transportTaskTrack)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveTransportTaskTrackParameters(TransportTaskTrack transportTaskTrack){
 		if(isUpdateRequest(transportTaskTrack) ){
 			return prepareTransportTaskTrackUpdateParameters(transportTaskTrack);
 		}
 		return prepareTransportTaskTrackCreateParameters(transportTaskTrack);
 	}
 	protected Object[] prepareTransportTaskTrackUpdateParameters(TransportTaskTrack transportTaskTrack){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = transportTaskTrack.getTrackTime();
 		
 		
 		parameters[1] = transportTaskTrack.getLatitude();
 		
 		
 		parameters[2] = transportTaskTrack.getLongitude();
 		
 		if(transportTaskTrack.getMovement() != null){
 			parameters[3] = transportTaskTrack.getMovement().getId();
 		}
 
 		parameters[4] = transportTaskTrack.nextVersion();
 		parameters[5] = transportTaskTrack.getId();
 		parameters[6] = transportTaskTrack.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareTransportTaskTrackCreateParameters(TransportTaskTrack transportTaskTrack){
		Object[] parameters = new Object[5];
        if(transportTaskTrack.getId() == null){
          String newTransportTaskTrackId=getNextId();
          transportTaskTrack.setId(newTransportTaskTrackId);
        }
		parameters[0] =  transportTaskTrack.getId();
 
 		
 		parameters[1] = transportTaskTrack.getTrackTime();
 		
 		
 		parameters[2] = transportTaskTrack.getLatitude();
 		
 		
 		parameters[3] = transportTaskTrack.getLongitude();
 		
 		if(transportTaskTrack.getMovement() != null){
 			parameters[4] = transportTaskTrack.getMovement().getId();

 		}
 		

 		return parameters;
 	}

	protected TransportTaskTrack saveInternalTransportTaskTrack(TransportTaskTrack transportTaskTrack, Map<String,Object> options){

		saveTransportTaskTrack(transportTaskTrack);

 		if(isSaveMovementEnabled(options)){
	 		saveMovement(transportTaskTrack, options);
 		}
 
		
		return transportTaskTrack;

	}



	//======================================================================================
	

 	protected TransportTaskTrack saveMovement(TransportTaskTrack transportTaskTrack, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTaskTrack.getMovement() == null){
 			return transportTaskTrack;//do nothing when it is null
 		}

 		getTransportTaskDAO().save(transportTaskTrack.getMovement(),options);
 		return transportTaskTrack;

 	}





 

	

		

	public TransportTaskTrack present(TransportTaskTrack transportTaskTrack,Map<String, Object> options){
	

		return transportTaskTrack;
	
	}
		

	

	protected String getTableName(){
		return TransportTaskTrackTable.TABLE_NAME;
	}



	public void enhanceList(List<TransportTaskTrack> transportTaskTrackList) {
		this.enhanceListInternal(transportTaskTrackList, this.getTransportTaskTrackMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TransportTaskTrack> transportTaskTrackList = ownerEntity.collectRefsWithType(TransportTaskTrack.INTERNAL_TYPE);
		this.enhanceList(transportTaskTrackList);

	}

	@Override
	public SmartList<TransportTaskTrack> findTransportTaskTrackWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getTransportTaskTrackMapper());

	}
	@Override
	public int countTransportTaskTrackWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countTransportTaskTrackWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<TransportTaskTrack> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTransportTaskTrackMapper());
	}

  @Override
  public Stream<TransportTaskTrack> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getTransportTaskTrackMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateTransportTaskTrack executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateTransportTaskTrack result = new CandidateTransportTaskTrack();
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


