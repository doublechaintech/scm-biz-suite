
package com.doublechaintech.retailscm.employeeleave;

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


import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.leavetype.LeaveType;

import com.doublechaintech.retailscm.leavetype.LeaveTypeDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class EmployeeLeaveJDBCTemplateDAO extends RetailscmBaseDAOImpl implements EmployeeLeaveDAO{

	protected EmployeeDAO employeeDAO;
	public void setEmployeeDAO(EmployeeDAO employeeDAO){
 	
 		if(employeeDAO == null){
 			throw new IllegalStateException("Do not try to set employeeDAO to null.");
 		}
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
 		if(this.employeeDAO == null){
 			throw new IllegalStateException("The employeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeDAO;
 	}	

	protected LeaveTypeDAO leaveTypeDAO;
	public void setLeaveTypeDAO(LeaveTypeDAO leaveTypeDAO){
 	
 		if(leaveTypeDAO == null){
 			throw new IllegalStateException("Do not try to set leaveTypeDAO to null.");
 		}
	 	this.leaveTypeDAO = leaveTypeDAO;
 	}
 	public LeaveTypeDAO getLeaveTypeDAO(){
 		if(this.leaveTypeDAO == null){
 			throw new IllegalStateException("The leaveTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.leaveTypeDAO;
 	}	

	
	/*
	protected EmployeeLeave load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeLeave(accessKey, options);
	}
	*/
	
	public SmartList<EmployeeLeave> loadAll() {
	    return this.loadAll(getEmployeeLeaveMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public EmployeeLeave load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeLeave(EmployeeLeaveTable.withId(id), options);
	}
	
	
	
	public EmployeeLeave save(EmployeeLeave employeeLeave,Map<String,Object> options){
		
		String methodName="save(EmployeeLeave employeeLeave,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeLeave, methodName, "employeeLeave");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeLeave(employeeLeave,options);
	}
	public EmployeeLeave clone(String employeeLeaveId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeLeaveTable.withId(employeeLeaveId),options);
	}
	
	protected EmployeeLeave clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeLeaveId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeLeave newEmployeeLeave = loadInternalEmployeeLeave(accessKey, options);
		newEmployeeLeave.setVersion(0);
		
		

		
		saveInternalEmployeeLeave(newEmployeeLeave,options);
		
		return newEmployeeLeave;
	}
	
	
	
	

	protected void throwIfHasException(String employeeLeaveId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EmployeeLeaveVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeLeaveNotFoundException(
					"The " + this.getTableName() + "(" + employeeLeaveId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String employeeLeaveId, int version) throws Exception{
	
		String methodName="delete(String employeeLeaveId, int version)";
		assertMethodArgumentNotNull(employeeLeaveId, methodName, "employeeLeaveId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeLeaveId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeLeaveId,version);
		}
		
	
	}
	
	
	
	
	

	public EmployeeLeave disconnectFromAll(String employeeLeaveId, int version) throws Exception{
	
		
		EmployeeLeave employeeLeave = loadInternalEmployeeLeave(EmployeeLeaveTable.withId(employeeLeaveId), emptyOptions());
		employeeLeave.clearFromAll();
		this.saveEmployeeLeave(employeeLeave);
		return employeeLeave;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return EmployeeLeaveTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_leave";
	}
	@Override
	protected String getBeanName() {
		
		return "employeeLeave";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeLeaveTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractWhoEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeLeaveTokens.WHO);
 	}

 	protected boolean isSaveWhoEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeLeaveTokens.WHO);
 	}
 	

 	
  

 	protected boolean isExtractTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeLeaveTokens.TYPE);
 	}

 	protected boolean isSaveTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeLeaveTokens.TYPE);
 	}
 	

 	
 
		

	

	protected EmployeeLeaveMapper getEmployeeLeaveMapper(){
		return new EmployeeLeaveMapper();
	}

	
	
	protected EmployeeLeave extractEmployeeLeave(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EmployeeLeave employeeLeave = loadSingleObject(accessKey, getEmployeeLeaveMapper());
			return employeeLeave;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeLeaveNotFoundException("EmployeeLeave("+accessKey+") is not found!");
		}

	}

	
	

	protected EmployeeLeave loadInternalEmployeeLeave(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeLeave employeeLeave = extractEmployeeLeave(accessKey, loadOptions);
 	
 		if(isExtractWhoEnabled(loadOptions)){
	 		extractWho(employeeLeave, loadOptions);
 		}
  	
 		if(isExtractTypeEnabled(loadOptions)){
	 		extractType(employeeLeave, loadOptions);
 		}
 
		
		return employeeLeave;
		
	}

	 

 	protected EmployeeLeave extractWho(EmployeeLeave employeeLeave, Map<String,Object> options) throws Exception{

		if(employeeLeave.getWho() == null){
			return employeeLeave;
		}
		String whoId = employeeLeave.getWho().getId();
		if( whoId == null){
			return employeeLeave;
		}
		Employee who = getEmployeeDAO().load(whoId,options);
		if(who != null){
			employeeLeave.setWho(who);
		}
		
 		
 		return employeeLeave;
 	}
 		
  

 	protected EmployeeLeave extractType(EmployeeLeave employeeLeave, Map<String,Object> options) throws Exception{

		if(employeeLeave.getType() == null){
			return employeeLeave;
		}
		String typeId = employeeLeave.getType().getId();
		if( typeId == null){
			return employeeLeave;
		}
		LeaveType type = getLeaveTypeDAO().load(typeId,options);
		if(type != null){
			employeeLeave.setType(type);
		}
		
 		
 		return employeeLeave;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeLeave> findEmployeeLeaveByWho(String employeeId,Map<String,Object> options){
 	
  		SmartList<EmployeeLeave> resultList = queryWith(EmployeeLeaveTable.COLUMN_WHO, employeeId, options, getEmployeeLeaveMapper());
		// analyzeEmployeeLeaveByWho(resultList, employeeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeeLeave> findEmployeeLeaveByWho(String employeeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeeLeave> resultList =  queryWithRange(EmployeeLeaveTable.COLUMN_WHO, employeeId, options, getEmployeeLeaveMapper(), start, count);
 		//analyzeEmployeeLeaveByWho(resultList, employeeId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeeLeaveByWho(SmartList<EmployeeLeave> resultList, String employeeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EmployeeLeave.WHO_PROPERTY, employeeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEmployeeLeaveByWho(String employeeId,Map<String,Object> options){

 		return countWith(EmployeeLeaveTable.COLUMN_WHO, employeeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeLeaveByWhoIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeLeaveTable.COLUMN_WHO, ids, options);
	}
 	
  	
 	public SmartList<EmployeeLeave> findEmployeeLeaveByType(String leaveTypeId,Map<String,Object> options){
 	
  		SmartList<EmployeeLeave> resultList = queryWith(EmployeeLeaveTable.COLUMN_TYPE, leaveTypeId, options, getEmployeeLeaveMapper());
		// analyzeEmployeeLeaveByType(resultList, leaveTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeeLeave> findEmployeeLeaveByType(String leaveTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeeLeave> resultList =  queryWithRange(EmployeeLeaveTable.COLUMN_TYPE, leaveTypeId, options, getEmployeeLeaveMapper(), start, count);
 		//analyzeEmployeeLeaveByType(resultList, leaveTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeeLeaveByType(SmartList<EmployeeLeave> resultList, String leaveTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EmployeeLeave.TYPE_PROPERTY, leaveTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEmployeeLeaveByType(String leaveTypeId,Map<String,Object> options){

 		return countWith(EmployeeLeaveTable.COLUMN_TYPE, leaveTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeLeaveByTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeLeaveTable.COLUMN_TYPE, ids, options);
	}
 	
 	
		
		
		

	

	protected EmployeeLeave saveEmployeeLeave(EmployeeLeave  employeeLeave){
		
		if(!employeeLeave.isChanged()){
			return employeeLeave;
		}
		
		
		String SQL=this.getSaveEmployeeLeaveSQL(employeeLeave);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeLeaveParameters(employeeLeave);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeLeave.incVersion();
		return employeeLeave;
	
	}
	public SmartList<EmployeeLeave> saveEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeLeaveList(employeeLeaveList);
		
		batchEmployeeLeaveCreate((List<EmployeeLeave>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeLeaveUpdate((List<EmployeeLeave>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeLeave employeeLeave:employeeLeaveList){
			if(employeeLeave.isChanged()){
				employeeLeave.incVersion();
			}
			
		
		}
		
		
		return employeeLeaveList;
	}

	public SmartList<EmployeeLeave> removeEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList,Map<String,Object> options){
		
		
		super.removeList(employeeLeaveList, options);
		
		return employeeLeaveList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeLeaveBatchCreateArgs(List<EmployeeLeave> employeeLeaveList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeLeave employeeLeave:employeeLeaveList ){
			Object [] parameters = prepareEmployeeLeaveCreateParameters(employeeLeave);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeLeaveBatchUpdateArgs(List<EmployeeLeave> employeeLeaveList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeLeave employeeLeave:employeeLeaveList ){
			if(!employeeLeave.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeLeaveUpdateParameters(employeeLeave);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeLeaveCreate(List<EmployeeLeave> employeeLeaveList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeLeaveBatchCreateArgs(employeeLeaveList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeLeaveUpdate(List<EmployeeLeave> employeeLeaveList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeLeaveBatchUpdateArgs(employeeLeaveList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeLeaveList(List<EmployeeLeave> employeeLeaveList){
		
		List<EmployeeLeave> employeeLeaveCreateList=new ArrayList<EmployeeLeave>();
		List<EmployeeLeave> employeeLeaveUpdateList=new ArrayList<EmployeeLeave>();
		
		for(EmployeeLeave employeeLeave: employeeLeaveList){
			if(isUpdateRequest(employeeLeave)){
				employeeLeaveUpdateList.add( employeeLeave);
				continue;
			}
			employeeLeaveCreateList.add(employeeLeave);
		}
		
		return new Object[]{employeeLeaveCreateList,employeeLeaveUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeLeave employeeLeave){
 		return employeeLeave.getVersion() > 0;
 	}
 	protected String getSaveEmployeeLeaveSQL(EmployeeLeave employeeLeave){
 		if(isUpdateRequest(employeeLeave)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeLeaveParameters(EmployeeLeave employeeLeave){
 		if(isUpdateRequest(employeeLeave) ){
 			return prepareEmployeeLeaveUpdateParameters(employeeLeave);
 		}
 		return prepareEmployeeLeaveCreateParameters(employeeLeave);
 	}
 	protected Object[] prepareEmployeeLeaveUpdateParameters(EmployeeLeave employeeLeave){
 		Object[] parameters = new Object[7];
  	
 		if(employeeLeave.getWho() != null){
 			parameters[0] = employeeLeave.getWho().getId();
 		}
  	
 		if(employeeLeave.getType() != null){
 			parameters[1] = employeeLeave.getType().getId();
 		}
 
 		
 		parameters[2] = employeeLeave.getLeaveDurationHour();
 		
 		
 		parameters[3] = employeeLeave.getRemark();
 				
 		parameters[4] = employeeLeave.nextVersion();
 		parameters[5] = employeeLeave.getId();
 		parameters[6] = employeeLeave.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeLeaveCreateParameters(EmployeeLeave employeeLeave){
		Object[] parameters = new Object[5];
		String newEmployeeLeaveId=getNextId();
		employeeLeave.setId(newEmployeeLeaveId);
		parameters[0] =  employeeLeave.getId();
  	
 		if(employeeLeave.getWho() != null){
 			parameters[1] = employeeLeave.getWho().getId();
 		
 		}
 		 	
 		if(employeeLeave.getType() != null){
 			parameters[2] = employeeLeave.getType().getId();
 		
 		}
 		
 		
 		parameters[3] = employeeLeave.getLeaveDurationHour();
 		
 		
 		parameters[4] = employeeLeave.getRemark();
 				
 				
 		return parameters;
 	}
 	
	protected EmployeeLeave saveInternalEmployeeLeave(EmployeeLeave employeeLeave, Map<String,Object> options){
		
		saveEmployeeLeave(employeeLeave);
 	
 		if(isSaveWhoEnabled(options)){
	 		saveWho(employeeLeave, options);
 		}
  	
 		if(isSaveTypeEnabled(options)){
	 		saveType(employeeLeave, options);
 		}
 
		
		return employeeLeave;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeLeave saveWho(EmployeeLeave employeeLeave, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeLeave.getWho() == null){
 			return employeeLeave;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeLeave.getWho(),options);
 		return employeeLeave;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EmployeeLeave saveType(EmployeeLeave employeeLeave, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeLeave.getType() == null){
 			return employeeLeave;//do nothing when it is null
 		}
 		
 		getLeaveTypeDAO().save(employeeLeave.getType(),options);
 		return employeeLeave;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public EmployeeLeave present(EmployeeLeave employeeLeave,Map<String, Object> options){
	

		return employeeLeave;
	
	}
		

	

	protected String getTableName(){
		return EmployeeLeaveTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<EmployeeLeave> employeeLeaveList) {		
		this.enhanceListInternal(employeeLeaveList, this.getEmployeeLeaveMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EmployeeLeave> employeeLeaveList = ownerEntity.collectRefsWithType(EmployeeLeave.INTERNAL_TYPE);
		this.enhanceList(employeeLeaveList);
		
	}
	
	@Override
	public SmartList<EmployeeLeave> findEmployeeLeaveWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getEmployeeLeaveMapper());

	}
	@Override
	public int countEmployeeLeaveWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countEmployeeLeaveWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<EmployeeLeave> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEmployeeLeaveMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateEmployeeLeave executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateEmployeeLeave result = new CandidateEmployeeLeave();
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


