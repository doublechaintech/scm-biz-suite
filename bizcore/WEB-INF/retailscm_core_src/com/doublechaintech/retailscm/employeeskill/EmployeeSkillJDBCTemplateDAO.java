
package com.doublechaintech.retailscm.employeeskill;

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


import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.skilltype.SkillTypeDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class EmployeeSkillJDBCTemplateDAO extends RetailscmBaseDAOImpl implements EmployeeSkillDAO{

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

	protected SkillTypeDAO skillTypeDAO;
	public void setSkillTypeDAO(SkillTypeDAO skillTypeDAO){
 	
 		if(skillTypeDAO == null){
 			throw new IllegalStateException("Do not try to set skillTypeDAO to null.");
 		}
	 	this.skillTypeDAO = skillTypeDAO;
 	}
 	public SkillTypeDAO getSkillTypeDAO(){
 		if(this.skillTypeDAO == null){
 			throw new IllegalStateException("The skillTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.skillTypeDAO;
 	}	

	
	/*
	protected EmployeeSkill load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeSkill(accessKey, options);
	}
	*/
	
	public SmartList<EmployeeSkill> loadAll() {
	    return this.loadAll(getEmployeeSkillMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public EmployeeSkill load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeSkill(EmployeeSkillTable.withId(id), options);
	}
	
	
	
	public EmployeeSkill save(EmployeeSkill employeeSkill,Map<String,Object> options){
		
		String methodName="save(EmployeeSkill employeeSkill,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeSkill, methodName, "employeeSkill");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeSkill(employeeSkill,options);
	}
	public EmployeeSkill clone(String employeeSkillId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeSkillTable.withId(employeeSkillId),options);
	}
	
	protected EmployeeSkill clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeSkillId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeSkill newEmployeeSkill = loadInternalEmployeeSkill(accessKey, options);
		newEmployeeSkill.setVersion(0);
		
		

		
		saveInternalEmployeeSkill(newEmployeeSkill,options);
		
		return newEmployeeSkill;
	}
	
	
	
	

	protected void throwIfHasException(String employeeSkillId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EmployeeSkillVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeSkillNotFoundException(
					"The " + this.getTableName() + "(" + employeeSkillId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String employeeSkillId, int version) throws Exception{
	
		String methodName="delete(String employeeSkillId, int version)";
		assertMethodArgumentNotNull(employeeSkillId, methodName, "employeeSkillId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeSkillId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeSkillId,version);
		}
		
	
	}
	
	
	
	
	

	public EmployeeSkill disconnectFromAll(String employeeSkillId, int version) throws Exception{
	
		
		EmployeeSkill employeeSkill = loadInternalEmployeeSkill(EmployeeSkillTable.withId(employeeSkillId), emptyOptions());
		employeeSkill.clearFromAll();
		this.saveEmployeeSkill(employeeSkill);
		return employeeSkill;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return EmployeeSkillTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_skill";
	}
	@Override
	protected String getBeanName() {
		
		return "employeeSkill";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeSkillTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeSkillTokens.EMPLOYEE);
 	}

 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeSkillTokens.EMPLOYEE);
 	}
 	

 	
  

 	protected boolean isExtractSkillTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeSkillTokens.SKILLTYPE);
 	}

 	protected boolean isSaveSkillTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeSkillTokens.SKILLTYPE);
 	}
 	

 	
 
		

	

	protected EmployeeSkillMapper getEmployeeSkillMapper(){
		return new EmployeeSkillMapper();
	}

	
	
	protected EmployeeSkill extractEmployeeSkill(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EmployeeSkill employeeSkill = loadSingleObject(accessKey, getEmployeeSkillMapper());
			return employeeSkill;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeSkillNotFoundException("EmployeeSkill("+accessKey+") is not found!");
		}

	}

	
	

	protected EmployeeSkill loadInternalEmployeeSkill(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeSkill employeeSkill = extractEmployeeSkill(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeSkill, loadOptions);
 		}
  	
 		if(isExtractSkillTypeEnabled(loadOptions)){
	 		extractSkillType(employeeSkill, loadOptions);
 		}
 
		
		return employeeSkill;
		
	}

	 

 	protected EmployeeSkill extractEmployee(EmployeeSkill employeeSkill, Map<String,Object> options) throws Exception{

		if(employeeSkill.getEmployee() == null){
			return employeeSkill;
		}
		String employeeId = employeeSkill.getEmployee().getId();
		if( employeeId == null){
			return employeeSkill;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeSkill.setEmployee(employee);
		}
		
 		
 		return employeeSkill;
 	}
 		
  

 	protected EmployeeSkill extractSkillType(EmployeeSkill employeeSkill, Map<String,Object> options) throws Exception{

		if(employeeSkill.getSkillType() == null){
			return employeeSkill;
		}
		String skillTypeId = employeeSkill.getSkillType().getId();
		if( skillTypeId == null){
			return employeeSkill;
		}
		SkillType skillType = getSkillTypeDAO().load(skillTypeId,options);
		if(skillType != null){
			employeeSkill.setSkillType(skillType);
		}
		
 		
 		return employeeSkill;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeSkill> findEmployeeSkillByEmployee(String employeeId,Map<String,Object> options){
 	
  		SmartList<EmployeeSkill> resultList = queryWith(EmployeeSkillTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeSkillMapper());
		// analyzeEmployeeSkillByEmployee(resultList, employeeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeeSkill> findEmployeeSkillByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeeSkill> resultList =  queryWithRange(EmployeeSkillTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeSkillMapper(), start, count);
 		//analyzeEmployeeSkillByEmployee(resultList, employeeId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeeSkillByEmployee(SmartList<EmployeeSkill> resultList, String employeeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EmployeeSkill.EMPLOYEE_PROPERTY, employeeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEmployeeSkillByEmployee(String employeeId,Map<String,Object> options){

 		return countWith(EmployeeSkillTable.COLUMN_EMPLOYEE, employeeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeSkillByEmployeeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeSkillTable.COLUMN_EMPLOYEE, ids, options);
	}
 	
  	
 	public SmartList<EmployeeSkill> findEmployeeSkillBySkillType(String skillTypeId,Map<String,Object> options){
 	
  		SmartList<EmployeeSkill> resultList = queryWith(EmployeeSkillTable.COLUMN_SKILL_TYPE, skillTypeId, options, getEmployeeSkillMapper());
		// analyzeEmployeeSkillBySkillType(resultList, skillTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeeSkill> findEmployeeSkillBySkillType(String skillTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeeSkill> resultList =  queryWithRange(EmployeeSkillTable.COLUMN_SKILL_TYPE, skillTypeId, options, getEmployeeSkillMapper(), start, count);
 		//analyzeEmployeeSkillBySkillType(resultList, skillTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeeSkillBySkillType(SmartList<EmployeeSkill> resultList, String skillTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EmployeeSkill.SKILL_TYPE_PROPERTY, skillTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEmployeeSkillBySkillType(String skillTypeId,Map<String,Object> options){

 		return countWith(EmployeeSkillTable.COLUMN_SKILL_TYPE, skillTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeSkillBySkillTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeSkillTable.COLUMN_SKILL_TYPE, ids, options);
	}
 	
 	
		
		
		

	

	protected EmployeeSkill saveEmployeeSkill(EmployeeSkill  employeeSkill){
		
		if(!employeeSkill.isChanged()){
			return employeeSkill;
		}
		
		
		String SQL=this.getSaveEmployeeSkillSQL(employeeSkill);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeSkillParameters(employeeSkill);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeSkill.incVersion();
		return employeeSkill;
	
	}
	public SmartList<EmployeeSkill> saveEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeSkillList(employeeSkillList);
		
		batchEmployeeSkillCreate((List<EmployeeSkill>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeSkillUpdate((List<EmployeeSkill>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeSkill employeeSkill:employeeSkillList){
			if(employeeSkill.isChanged()){
				employeeSkill.incVersion();
			}
			
		
		}
		
		
		return employeeSkillList;
	}

	public SmartList<EmployeeSkill> removeEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList,Map<String,Object> options){
		
		
		super.removeList(employeeSkillList, options);
		
		return employeeSkillList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeSkillBatchCreateArgs(List<EmployeeSkill> employeeSkillList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeSkill employeeSkill:employeeSkillList ){
			Object [] parameters = prepareEmployeeSkillCreateParameters(employeeSkill);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeSkillBatchUpdateArgs(List<EmployeeSkill> employeeSkillList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeSkill employeeSkill:employeeSkillList ){
			if(!employeeSkill.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeSkillUpdateParameters(employeeSkill);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeSkillCreate(List<EmployeeSkill> employeeSkillList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeSkillBatchCreateArgs(employeeSkillList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeSkillUpdate(List<EmployeeSkill> employeeSkillList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeSkillBatchUpdateArgs(employeeSkillList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeSkillList(List<EmployeeSkill> employeeSkillList){
		
		List<EmployeeSkill> employeeSkillCreateList=new ArrayList<EmployeeSkill>();
		List<EmployeeSkill> employeeSkillUpdateList=new ArrayList<EmployeeSkill>();
		
		for(EmployeeSkill employeeSkill: employeeSkillList){
			if(isUpdateRequest(employeeSkill)){
				employeeSkillUpdateList.add( employeeSkill);
				continue;
			}
			employeeSkillCreateList.add(employeeSkill);
		}
		
		return new Object[]{employeeSkillCreateList,employeeSkillUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeSkill employeeSkill){
 		return employeeSkill.getVersion() > 0;
 	}
 	protected String getSaveEmployeeSkillSQL(EmployeeSkill employeeSkill){
 		if(isUpdateRequest(employeeSkill)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeSkillParameters(EmployeeSkill employeeSkill){
 		if(isUpdateRequest(employeeSkill) ){
 			return prepareEmployeeSkillUpdateParameters(employeeSkill);
 		}
 		return prepareEmployeeSkillCreateParameters(employeeSkill);
 	}
 	protected Object[] prepareEmployeeSkillUpdateParameters(EmployeeSkill employeeSkill){
 		Object[] parameters = new Object[6];
  	
 		if(employeeSkill.getEmployee() != null){
 			parameters[0] = employeeSkill.getEmployee().getId();
 		}
  	
 		if(employeeSkill.getSkillType() != null){
 			parameters[1] = employeeSkill.getSkillType().getId();
 		}
 
 		
 		parameters[2] = employeeSkill.getDescription();
 				
 		parameters[3] = employeeSkill.nextVersion();
 		parameters[4] = employeeSkill.getId();
 		parameters[5] = employeeSkill.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeSkillCreateParameters(EmployeeSkill employeeSkill){
		Object[] parameters = new Object[4];
		String newEmployeeSkillId=getNextId();
		employeeSkill.setId(newEmployeeSkillId);
		parameters[0] =  employeeSkill.getId();
  	
 		if(employeeSkill.getEmployee() != null){
 			parameters[1] = employeeSkill.getEmployee().getId();
 		
 		}
 		 	
 		if(employeeSkill.getSkillType() != null){
 			parameters[2] = employeeSkill.getSkillType().getId();
 		
 		}
 		
 		
 		parameters[3] = employeeSkill.getDescription();
 				
 				
 		return parameters;
 	}
 	
	protected EmployeeSkill saveInternalEmployeeSkill(EmployeeSkill employeeSkill, Map<String,Object> options){
		
		saveEmployeeSkill(employeeSkill);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeSkill, options);
 		}
  	
 		if(isSaveSkillTypeEnabled(options)){
	 		saveSkillType(employeeSkill, options);
 		}
 
		
		return employeeSkill;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeSkill saveEmployee(EmployeeSkill employeeSkill, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeSkill.getEmployee() == null){
 			return employeeSkill;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeSkill.getEmployee(),options);
 		return employeeSkill;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EmployeeSkill saveSkillType(EmployeeSkill employeeSkill, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeSkill.getSkillType() == null){
 			return employeeSkill;//do nothing when it is null
 		}
 		
 		getSkillTypeDAO().save(employeeSkill.getSkillType(),options);
 		return employeeSkill;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public EmployeeSkill present(EmployeeSkill employeeSkill,Map<String, Object> options){
	

		return employeeSkill;
	
	}
		

	

	protected String getTableName(){
		return EmployeeSkillTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<EmployeeSkill> employeeSkillList) {		
		this.enhanceListInternal(employeeSkillList, this.getEmployeeSkillMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EmployeeSkill> employeeSkillList = ownerEntity.collectRefsWithType(EmployeeSkill.INTERNAL_TYPE);
		this.enhanceList(employeeSkillList);
		
	}
	
	@Override
	public SmartList<EmployeeSkill> findEmployeeSkillWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getEmployeeSkillMapper());

	}
	@Override
	public int countEmployeeSkillWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countEmployeeSkillWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<EmployeeSkill> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEmployeeSkillMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateEmployeeSkill executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateEmployeeSkill result = new CandidateEmployeeSkill();
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


