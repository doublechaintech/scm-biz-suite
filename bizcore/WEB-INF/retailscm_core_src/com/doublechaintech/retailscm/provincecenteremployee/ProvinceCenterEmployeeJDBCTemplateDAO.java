
package com.doublechaintech.retailscm.provincecenteremployee;

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


import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;

import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentDAO;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class ProvinceCenterEmployeeJDBCTemplateDAO extends RetailscmBaseDAOImpl implements ProvinceCenterEmployeeDAO{

	protected ProvinceCenterDepartmentDAO provinceCenterDepartmentDAO;
	public void setProvinceCenterDepartmentDAO(ProvinceCenterDepartmentDAO provinceCenterDepartmentDAO){
 	
 		if(provinceCenterDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set provinceCenterDepartmentDAO to null.");
 		}
	 	this.provinceCenterDepartmentDAO = provinceCenterDepartmentDAO;
 	}
 	public ProvinceCenterDepartmentDAO getProvinceCenterDepartmentDAO(){
 		if(this.provinceCenterDepartmentDAO == null){
 			throw new IllegalStateException("The provinceCenterDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.provinceCenterDepartmentDAO;
 	}	

	protected RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO;
	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO){
 	
 		if(retailStoreProvinceCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreProvinceCenterDAO to null.");
 		}
	 	this.retailStoreProvinceCenterDAO = retailStoreProvinceCenterDAO;
 	}
 	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
 		if(this.retailStoreProvinceCenterDAO == null){
 			throw new IllegalStateException("The retailStoreProvinceCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreProvinceCenterDAO;
 	}	


	/*
	protected ProvinceCenterEmployee load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProvinceCenterEmployee(accessKey, options);
	}
	*/

	public SmartList<ProvinceCenterEmployee> loadAll() {
	    return this.loadAll(getProvinceCenterEmployeeMapper());
	}

  public Stream<ProvinceCenterEmployee> loadAllAsStream() {
      return this.loadAllAsStream(getProvinceCenterEmployeeMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public ProvinceCenterEmployee load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProvinceCenterEmployee(ProvinceCenterEmployeeTable.withId(id), options);
	}

	

	public ProvinceCenterEmployee save(ProvinceCenterEmployee provinceCenterEmployee,Map<String,Object> options){

		String methodName="save(ProvinceCenterEmployee provinceCenterEmployee,Map<String,Object> options)";

		assertMethodArgumentNotNull(provinceCenterEmployee, methodName, "provinceCenterEmployee");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalProvinceCenterEmployee(provinceCenterEmployee,options);
	}
	public ProvinceCenterEmployee clone(String provinceCenterEmployeeId, Map<String,Object> options) throws Exception{

		return clone(ProvinceCenterEmployeeTable.withId(provinceCenterEmployeeId),options);
	}

	protected ProvinceCenterEmployee clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String provinceCenterEmployeeId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		ProvinceCenterEmployee newProvinceCenterEmployee = loadInternalProvinceCenterEmployee(accessKey, options);
		newProvinceCenterEmployee.setVersion(0);
		
		


		saveInternalProvinceCenterEmployee(newProvinceCenterEmployee,options);

		return newProvinceCenterEmployee;
	}

	



	protected void throwIfHasException(String provinceCenterEmployeeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ProvinceCenterEmployeeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProvinceCenterEmployeeNotFoundException(
					"The " + this.getTableName() + "(" + provinceCenterEmployeeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String provinceCenterEmployeeId, int version) throws Exception{

		String methodName="delete(String provinceCenterEmployeeId, int version)";
		assertMethodArgumentNotNull(provinceCenterEmployeeId, methodName, "provinceCenterEmployeeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{provinceCenterEmployeeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(provinceCenterEmployeeId,version);
		}


	}






	public ProvinceCenterEmployee disconnectFromAll(String provinceCenterEmployeeId, int version) throws Exception{


		ProvinceCenterEmployee provinceCenterEmployee = loadInternalProvinceCenterEmployee(ProvinceCenterEmployeeTable.withId(provinceCenterEmployeeId), emptyOptions());
		provinceCenterEmployee.clearFromAll();
		this.saveProvinceCenterEmployee(provinceCenterEmployee);
		return provinceCenterEmployee;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return ProvinceCenterEmployeeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "province_center_employee";
	}
	@Override
	protected String getBeanName() {

		return "provinceCenterEmployee";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProvinceCenterEmployeeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractDepartmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProvinceCenterEmployeeTokens.DEPARTMENT);
 	}

 	protected boolean isSaveDepartmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProvinceCenterEmployeeTokens.DEPARTMENT);
 	}
 	

 	
  

 	protected boolean isExtractProvinceCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProvinceCenterEmployeeTokens.PROVINCECENTER);
 	}

 	protected boolean isSaveProvinceCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProvinceCenterEmployeeTokens.PROVINCECENTER);
 	}
 	

 	
 
		

	

	protected ProvinceCenterEmployeeMapper getProvinceCenterEmployeeMapper(){
		return new ProvinceCenterEmployeeMapper();
	}

	
	
	protected ProvinceCenterEmployee extractProvinceCenterEmployee(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ProvinceCenterEmployee provinceCenterEmployee = loadSingleObject(accessKey, getProvinceCenterEmployeeMapper());
			return provinceCenterEmployee;
		}catch(EmptyResultDataAccessException e){
			throw new ProvinceCenterEmployeeNotFoundException("ProvinceCenterEmployee("+accessKey+") is not found!");
		}

	}

	
	

	protected ProvinceCenterEmployee loadInternalProvinceCenterEmployee(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ProvinceCenterEmployee provinceCenterEmployee = extractProvinceCenterEmployee(accessKey, loadOptions);
 	
 		if(isExtractDepartmentEnabled(loadOptions)){
	 		extractDepartment(provinceCenterEmployee, loadOptions);
 		}
  	
 		if(isExtractProvinceCenterEnabled(loadOptions)){
	 		extractProvinceCenter(provinceCenterEmployee, loadOptions);
 		}
 
		
		return provinceCenterEmployee;
		
	}

	 

 	protected ProvinceCenterEmployee extractDepartment(ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object> options) throws Exception{

		if(provinceCenterEmployee.getDepartment() == null){
			return provinceCenterEmployee;
		}
		String departmentId = provinceCenterEmployee.getDepartment().getId();
		if( departmentId == null){
			return provinceCenterEmployee;
		}
		ProvinceCenterDepartment department = getProvinceCenterDepartmentDAO().load(departmentId,options);
		if(department != null){
			provinceCenterEmployee.setDepartment(department);
		}
		
 		
 		return provinceCenterEmployee;
 	}
 		
  

 	protected ProvinceCenterEmployee extractProvinceCenter(ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object> options) throws Exception{

		if(provinceCenterEmployee.getProvinceCenter() == null){
			return provinceCenterEmployee;
		}
		String provinceCenterId = provinceCenterEmployee.getProvinceCenter().getId();
		if( provinceCenterId == null){
			return provinceCenterEmployee;
		}
		RetailStoreProvinceCenter provinceCenter = getRetailStoreProvinceCenterDAO().load(provinceCenterId,options);
		if(provinceCenter != null){
			provinceCenterEmployee.setProvinceCenter(provinceCenter);
		}
		
 		
 		return provinceCenterEmployee;
 	}
 		
 
		
		
  	
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByDepartment(String provinceCenterDepartmentId,Map<String,Object> options){
 	
  		SmartList<ProvinceCenterEmployee> resultList = queryWith(ProvinceCenterEmployeeTable.COLUMN_DEPARTMENT, provinceCenterDepartmentId, options, getProvinceCenterEmployeeMapper());
		// analyzeProvinceCenterEmployeeByDepartment(resultList, provinceCenterDepartmentId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByDepartment(String provinceCenterDepartmentId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ProvinceCenterEmployee> resultList =  queryWithRange(ProvinceCenterEmployeeTable.COLUMN_DEPARTMENT, provinceCenterDepartmentId, options, getProvinceCenterEmployeeMapper(), start, count);
 		//analyzeProvinceCenterEmployeeByDepartment(resultList, provinceCenterDepartmentId, options);
 		return resultList;
 		
 	}
 	public void analyzeProvinceCenterEmployeeByDepartment(SmartList<ProvinceCenterEmployee> resultList, String provinceCenterDepartmentId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, provinceCenterDepartmentId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countProvinceCenterEmployeeByDepartment(String provinceCenterDepartmentId,Map<String,Object> options){

 		return countWith(ProvinceCenterEmployeeTable.COLUMN_DEPARTMENT, provinceCenterDepartmentId, options);
 	}
 	@Override
	public Map<String, Integer> countProvinceCenterEmployeeByDepartmentIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ProvinceCenterEmployeeTable.COLUMN_DEPARTMENT, ids, options);
	}
 	
  	
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByProvinceCenter(String retailStoreProvinceCenterId,Map<String,Object> options){
 	
  		SmartList<ProvinceCenterEmployee> resultList = queryWith(ProvinceCenterEmployeeTable.COLUMN_PROVINCE_CENTER, retailStoreProvinceCenterId, options, getProvinceCenterEmployeeMapper());
		// analyzeProvinceCenterEmployeeByProvinceCenter(resultList, retailStoreProvinceCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByProvinceCenter(String retailStoreProvinceCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ProvinceCenterEmployee> resultList =  queryWithRange(ProvinceCenterEmployeeTable.COLUMN_PROVINCE_CENTER, retailStoreProvinceCenterId, options, getProvinceCenterEmployeeMapper(), start, count);
 		//analyzeProvinceCenterEmployeeByProvinceCenter(resultList, retailStoreProvinceCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeProvinceCenterEmployeeByProvinceCenter(SmartList<ProvinceCenterEmployee> resultList, String retailStoreProvinceCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, retailStoreProvinceCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countProvinceCenterEmployeeByProvinceCenter(String retailStoreProvinceCenterId,Map<String,Object> options){

 		return countWith(ProvinceCenterEmployeeTable.COLUMN_PROVINCE_CENTER, retailStoreProvinceCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countProvinceCenterEmployeeByProvinceCenterIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ProvinceCenterEmployeeTable.COLUMN_PROVINCE_CENTER, ids, options);
	}
 	
 	
		
		
		

	

	protected ProvinceCenterEmployee saveProvinceCenterEmployee(ProvinceCenterEmployee  provinceCenterEmployee){
		
		if(!provinceCenterEmployee.isChanged()){
			return provinceCenterEmployee;
		}
		

		String SQL=this.getSaveProvinceCenterEmployeeSQL(provinceCenterEmployee);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProvinceCenterEmployeeParameters(provinceCenterEmployee);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		provinceCenterEmployee.incVersion();
		return provinceCenterEmployee;

	}
	public SmartList<ProvinceCenterEmployee> saveProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProvinceCenterEmployeeList(provinceCenterEmployeeList);

		batchProvinceCenterEmployeeCreate((List<ProvinceCenterEmployee>)lists[CREATE_LIST_INDEX]);

		batchProvinceCenterEmployeeUpdate((List<ProvinceCenterEmployee>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList){
			if(provinceCenterEmployee.isChanged()){
				provinceCenterEmployee.incVersion();
			}


		}


		return provinceCenterEmployeeList;
	}

	public SmartList<ProvinceCenterEmployee> removeProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList,Map<String,Object> options){


		super.removeList(provinceCenterEmployeeList, options);

		return provinceCenterEmployeeList;


	}

	protected List<Object[]> prepareProvinceCenterEmployeeBatchCreateArgs(List<ProvinceCenterEmployee> provinceCenterEmployeeList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList ){
			Object [] parameters = prepareProvinceCenterEmployeeCreateParameters(provinceCenterEmployee);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareProvinceCenterEmployeeBatchUpdateArgs(List<ProvinceCenterEmployee> provinceCenterEmployeeList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList ){
			if(!provinceCenterEmployee.isChanged()){
				continue;
			}
			Object [] parameters = prepareProvinceCenterEmployeeUpdateParameters(provinceCenterEmployee);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchProvinceCenterEmployeeCreate(List<ProvinceCenterEmployee> provinceCenterEmployeeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProvinceCenterEmployeeBatchCreateArgs(provinceCenterEmployeeList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchProvinceCenterEmployeeUpdate(List<ProvinceCenterEmployee> provinceCenterEmployeeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProvinceCenterEmployeeBatchUpdateArgs(provinceCenterEmployeeList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitProvinceCenterEmployeeList(List<ProvinceCenterEmployee> provinceCenterEmployeeList){

		List<ProvinceCenterEmployee> provinceCenterEmployeeCreateList=new ArrayList<ProvinceCenterEmployee>();
		List<ProvinceCenterEmployee> provinceCenterEmployeeUpdateList=new ArrayList<ProvinceCenterEmployee>();

		for(ProvinceCenterEmployee provinceCenterEmployee: provinceCenterEmployeeList){
			if(isUpdateRequest(provinceCenterEmployee)){
				provinceCenterEmployeeUpdateList.add( provinceCenterEmployee);
				continue;
			}
			provinceCenterEmployeeCreateList.add(provinceCenterEmployee);
		}

		return new Object[]{provinceCenterEmployeeCreateList,provinceCenterEmployeeUpdateList};
	}

	protected boolean isUpdateRequest(ProvinceCenterEmployee provinceCenterEmployee){
 		return provinceCenterEmployee.getVersion() > 0;
 	}
 	protected String getSaveProvinceCenterEmployeeSQL(ProvinceCenterEmployee provinceCenterEmployee){
 		if(isUpdateRequest(provinceCenterEmployee)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveProvinceCenterEmployeeParameters(ProvinceCenterEmployee provinceCenterEmployee){
 		if(isUpdateRequest(provinceCenterEmployee) ){
 			return prepareProvinceCenterEmployeeUpdateParameters(provinceCenterEmployee);
 		}
 		return prepareProvinceCenterEmployeeCreateParameters(provinceCenterEmployee);
 	}
 	protected Object[] prepareProvinceCenterEmployeeUpdateParameters(ProvinceCenterEmployee provinceCenterEmployee){
 		Object[] parameters = new Object[9];
 
 		
 		parameters[0] = provinceCenterEmployee.getName();
 		
 		
 		parameters[1] = provinceCenterEmployee.getMobile();
 		
 		
 		parameters[2] = provinceCenterEmployee.getEmail();
 		
 		
 		parameters[3] = provinceCenterEmployee.getFounded();
 		
 		if(provinceCenterEmployee.getDepartment() != null){
 			parameters[4] = provinceCenterEmployee.getDepartment().getId();
 		}
 
 		if(provinceCenterEmployee.getProvinceCenter() != null){
 			parameters[5] = provinceCenterEmployee.getProvinceCenter().getId();
 		}
 
 		parameters[6] = provinceCenterEmployee.nextVersion();
 		parameters[7] = provinceCenterEmployee.getId();
 		parameters[8] = provinceCenterEmployee.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareProvinceCenterEmployeeCreateParameters(ProvinceCenterEmployee provinceCenterEmployee){
		Object[] parameters = new Object[7];
        if(provinceCenterEmployee.getId() == null){
          String newProvinceCenterEmployeeId=getNextId();
          provinceCenterEmployee.setId(newProvinceCenterEmployeeId);
        }
		parameters[0] =  provinceCenterEmployee.getId();
 
 		
 		parameters[1] = provinceCenterEmployee.getName();
 		
 		
 		parameters[2] = provinceCenterEmployee.getMobile();
 		
 		
 		parameters[3] = provinceCenterEmployee.getEmail();
 		
 		
 		parameters[4] = provinceCenterEmployee.getFounded();
 		
 		if(provinceCenterEmployee.getDepartment() != null){
 			parameters[5] = provinceCenterEmployee.getDepartment().getId();

 		}
 		
 		if(provinceCenterEmployee.getProvinceCenter() != null){
 			parameters[6] = provinceCenterEmployee.getProvinceCenter().getId();

 		}
 		

 		return parameters;
 	}

	protected ProvinceCenterEmployee saveInternalProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object> options){

		saveProvinceCenterEmployee(provinceCenterEmployee);

 		if(isSaveDepartmentEnabled(options)){
	 		saveDepartment(provinceCenterEmployee, options);
 		}
 
 		if(isSaveProvinceCenterEnabled(options)){
	 		saveProvinceCenter(provinceCenterEmployee, options);
 		}
 
		
		return provinceCenterEmployee;

	}



	//======================================================================================
	

 	protected ProvinceCenterEmployee saveDepartment(ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(provinceCenterEmployee.getDepartment() == null){
 			return provinceCenterEmployee;//do nothing when it is null
 		}

 		getProvinceCenterDepartmentDAO().save(provinceCenterEmployee.getDepartment(),options);
 		return provinceCenterEmployee;

 	}





 

 	protected ProvinceCenterEmployee saveProvinceCenter(ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(provinceCenterEmployee.getProvinceCenter() == null){
 			return provinceCenterEmployee;//do nothing when it is null
 		}

 		getRetailStoreProvinceCenterDAO().save(provinceCenterEmployee.getProvinceCenter(),options);
 		return provinceCenterEmployee;

 	}





 

	

		

	public ProvinceCenterEmployee present(ProvinceCenterEmployee provinceCenterEmployee,Map<String, Object> options){
	

		return provinceCenterEmployee;
	
	}
		

	

	protected String getTableName(){
		return ProvinceCenterEmployeeTable.TABLE_NAME;
	}



	public void enhanceList(List<ProvinceCenterEmployee> provinceCenterEmployeeList) {
		this.enhanceListInternal(provinceCenterEmployeeList, this.getProvinceCenterEmployeeMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ProvinceCenterEmployee> provinceCenterEmployeeList = ownerEntity.collectRefsWithType(ProvinceCenterEmployee.INTERNAL_TYPE);
		this.enhanceList(provinceCenterEmployeeList);

	}

	@Override
	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getProvinceCenterEmployeeMapper());

	}
	@Override
	public int countProvinceCenterEmployeeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countProvinceCenterEmployeeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<ProvinceCenterEmployee> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getProvinceCenterEmployeeMapper());
	}

  @Override
  public Stream<ProvinceCenterEmployee> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getProvinceCenterEmployeeMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateProvinceCenterEmployee executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateProvinceCenterEmployee result = new CandidateProvinceCenterEmployee();
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


