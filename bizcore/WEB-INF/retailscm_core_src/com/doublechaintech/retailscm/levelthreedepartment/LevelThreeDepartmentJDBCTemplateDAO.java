
package com.doublechaintech.retailscm.levelthreedepartment;

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


import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class LevelThreeDepartmentJDBCTemplateDAO extends RetailscmBaseDAOImpl implements LevelThreeDepartmentDAO{

	protected LevelTwoDepartmentDAO levelTwoDepartmentDAO;
	public void setLevelTwoDepartmentDAO(LevelTwoDepartmentDAO levelTwoDepartmentDAO){
 	
 		if(levelTwoDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set levelTwoDepartmentDAO to null.");
 		}
	 	this.levelTwoDepartmentDAO = levelTwoDepartmentDAO;
 	}
 	public LevelTwoDepartmentDAO getLevelTwoDepartmentDAO(){
 		if(this.levelTwoDepartmentDAO == null){
 			throw new IllegalStateException("The levelTwoDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelTwoDepartmentDAO;
 	}	

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


	/*
	protected LevelThreeDepartment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelThreeDepartment(accessKey, options);
	}
	*/

	public SmartList<LevelThreeDepartment> loadAll() {
	    return this.loadAll(getLevelThreeDepartmentMapper());
	}

  public Stream<LevelThreeDepartment> loadAllAsStream() {
      return this.loadAllAsStream(getLevelThreeDepartmentMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public LevelThreeDepartment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelThreeDepartment(LevelThreeDepartmentTable.withId(id), options);
	}

	

	public LevelThreeDepartment save(LevelThreeDepartment levelThreeDepartment,Map<String,Object> options){

		String methodName="save(LevelThreeDepartment levelThreeDepartment,Map<String,Object> options)";

		assertMethodArgumentNotNull(levelThreeDepartment, methodName, "levelThreeDepartment");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalLevelThreeDepartment(levelThreeDepartment,options);
	}
	public LevelThreeDepartment clone(String levelThreeDepartmentId, Map<String,Object> options) throws Exception{

		return clone(LevelThreeDepartmentTable.withId(levelThreeDepartmentId),options);
	}

	protected LevelThreeDepartment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String levelThreeDepartmentId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		LevelThreeDepartment newLevelThreeDepartment = loadInternalLevelThreeDepartment(accessKey, options);
		newLevelThreeDepartment.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newLevelThreeDepartment.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalLevelThreeDepartment(newLevelThreeDepartment,options);

		return newLevelThreeDepartment;
	}

	



	protected void throwIfHasException(String levelThreeDepartmentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LevelThreeDepartmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelThreeDepartmentNotFoundException(
					"The " + this.getTableName() + "(" + levelThreeDepartmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String levelThreeDepartmentId, int version) throws Exception{

		String methodName="delete(String levelThreeDepartmentId, int version)";
		assertMethodArgumentNotNull(levelThreeDepartmentId, methodName, "levelThreeDepartmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelThreeDepartmentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelThreeDepartmentId,version);
		}


	}






	public LevelThreeDepartment disconnectFromAll(String levelThreeDepartmentId, int version) throws Exception{


		LevelThreeDepartment levelThreeDepartment = loadInternalLevelThreeDepartment(LevelThreeDepartmentTable.withId(levelThreeDepartmentId), emptyOptions());
		levelThreeDepartment.clearFromAll();
		this.saveLevelThreeDepartment(levelThreeDepartment);
		return levelThreeDepartment;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return LevelThreeDepartmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "level_three_department";
	}
	@Override
	protected String getBeanName() {

		return "levelThreeDepartment";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelThreeDepartmentTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelThreeDepartmentTokens.BELONGSTO);
 	}

 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelThreeDepartmentTokens.BELONGSTO);
 	}
 	

 	
 
		
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LevelThreeDepartmentTokens.EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeEmployeeListEnabled(Map<String,Object> options){		 		
 		return LevelThreeDepartmentTokens.of(options).analyzeEmployeeListEnabled();
 	}
	
	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelThreeDepartmentTokens.EMPLOYEE_LIST);
		
 	}
 	
		

	

	protected LevelThreeDepartmentMapper getLevelThreeDepartmentMapper(){
		return new LevelThreeDepartmentMapper();
	}

	
	
	protected LevelThreeDepartment extractLevelThreeDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LevelThreeDepartment levelThreeDepartment = loadSingleObject(accessKey, getLevelThreeDepartmentMapper());
			return levelThreeDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new LevelThreeDepartmentNotFoundException("LevelThreeDepartment("+accessKey+") is not found!");
		}

	}

	
	

	protected LevelThreeDepartment loadInternalLevelThreeDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelThreeDepartment levelThreeDepartment = extractLevelThreeDepartment(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(levelThreeDepartment, loadOptions);
 		}
 
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(levelThreeDepartment, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeEmployeeListEnabled(loadOptions)){
	 		analyzeEmployeeList(levelThreeDepartment, loadOptions);
 		}
 		
		
		return levelThreeDepartment;
		
	}

	 

 	protected LevelThreeDepartment extractBelongsTo(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options) throws Exception{

		if(levelThreeDepartment.getBelongsTo() == null){
			return levelThreeDepartment;
		}
		String belongsToId = levelThreeDepartment.getBelongsTo().getId();
		if( belongsToId == null){
			return levelThreeDepartment;
		}
		LevelTwoDepartment belongsTo = getLevelTwoDepartmentDAO().load(belongsToId,options);
		if(belongsTo != null){
			levelThreeDepartment.setBelongsTo(belongsTo);
		}
		
 		
 		return levelThreeDepartment;
 	}
 		
 
		
	protected void enhanceEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LevelThreeDepartment extractEmployeeList(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options){
		
		
		if(levelThreeDepartment == null){
			return null;
		}
		if(levelThreeDepartment.getId() == null){
			return levelThreeDepartment;
		}

		
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByDepartment(levelThreeDepartment.getId(),options);
		if(employeeList != null){
			enhanceEmployeeList(employeeList,options);
			levelThreeDepartment.setEmployeeList(employeeList);
		}
		
		return levelThreeDepartment;
	
	}	
	
	protected LevelThreeDepartment analyzeEmployeeList(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options){
		
		
		if(levelThreeDepartment == null){
			return null;
		}
		if(levelThreeDepartment.getId() == null){
			return levelThreeDepartment;
		}

		
		
		SmartList<Employee> employeeList = levelThreeDepartment.getEmployeeList();
		if(employeeList != null){
			getEmployeeDAO().analyzeEmployeeByDepartment(employeeList, levelThreeDepartment.getId(), options);
			
		}
		
		return levelThreeDepartment;
	
	}	
	
		
		
  	
 	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId,Map<String,Object> options){
 	
  		SmartList<LevelThreeDepartment> resultList = queryWith(LevelThreeDepartmentTable.COLUMN_BELONGS_TO, levelTwoDepartmentId, options, getLevelThreeDepartmentMapper());
		// analyzeLevelThreeDepartmentByBelongsTo(resultList, levelTwoDepartmentId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LevelThreeDepartment> resultList =  queryWithRange(LevelThreeDepartmentTable.COLUMN_BELONGS_TO, levelTwoDepartmentId, options, getLevelThreeDepartmentMapper(), start, count);
 		//analyzeLevelThreeDepartmentByBelongsTo(resultList, levelTwoDepartmentId, options);
 		return resultList;
 		
 	}
 	public void analyzeLevelThreeDepartmentByBelongsTo(SmartList<LevelThreeDepartment> resultList, String levelTwoDepartmentId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId,Map<String,Object> options){

 		return countWith(LevelThreeDepartmentTable.COLUMN_BELONGS_TO, levelTwoDepartmentId, options);
 	}
 	@Override
	public Map<String, Integer> countLevelThreeDepartmentByBelongsToIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LevelThreeDepartmentTable.COLUMN_BELONGS_TO, ids, options);
	}
 	
 	
		
		
		

	

	protected LevelThreeDepartment saveLevelThreeDepartment(LevelThreeDepartment  levelThreeDepartment){
		
		if(!levelThreeDepartment.isChanged()){
			return levelThreeDepartment;
		}
		

		String SQL=this.getSaveLevelThreeDepartmentSQL(levelThreeDepartment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelThreeDepartmentParameters(levelThreeDepartment);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		levelThreeDepartment.incVersion();
		return levelThreeDepartment;

	}
	public SmartList<LevelThreeDepartment> saveLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelThreeDepartmentList(levelThreeDepartmentList);

		batchLevelThreeDepartmentCreate((List<LevelThreeDepartment>)lists[CREATE_LIST_INDEX]);

		batchLevelThreeDepartmentUpdate((List<LevelThreeDepartment>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(LevelThreeDepartment levelThreeDepartment:levelThreeDepartmentList){
			if(levelThreeDepartment.isChanged()){
				levelThreeDepartment.incVersion();
			}


		}


		return levelThreeDepartmentList;
	}

	public SmartList<LevelThreeDepartment> removeLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList,Map<String,Object> options){


		super.removeList(levelThreeDepartmentList, options);

		return levelThreeDepartmentList;


	}

	protected List<Object[]> prepareLevelThreeDepartmentBatchCreateArgs(List<LevelThreeDepartment> levelThreeDepartmentList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelThreeDepartment levelThreeDepartment:levelThreeDepartmentList ){
			Object [] parameters = prepareLevelThreeDepartmentCreateParameters(levelThreeDepartment);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareLevelThreeDepartmentBatchUpdateArgs(List<LevelThreeDepartment> levelThreeDepartmentList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelThreeDepartment levelThreeDepartment:levelThreeDepartmentList ){
			if(!levelThreeDepartment.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelThreeDepartmentUpdateParameters(levelThreeDepartment);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchLevelThreeDepartmentCreate(List<LevelThreeDepartment> levelThreeDepartmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelThreeDepartmentBatchCreateArgs(levelThreeDepartmentList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchLevelThreeDepartmentUpdate(List<LevelThreeDepartment> levelThreeDepartmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelThreeDepartmentBatchUpdateArgs(levelThreeDepartmentList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitLevelThreeDepartmentList(List<LevelThreeDepartment> levelThreeDepartmentList){

		List<LevelThreeDepartment> levelThreeDepartmentCreateList=new ArrayList<LevelThreeDepartment>();
		List<LevelThreeDepartment> levelThreeDepartmentUpdateList=new ArrayList<LevelThreeDepartment>();

		for(LevelThreeDepartment levelThreeDepartment: levelThreeDepartmentList){
			if(isUpdateRequest(levelThreeDepartment)){
				levelThreeDepartmentUpdateList.add( levelThreeDepartment);
				continue;
			}
			levelThreeDepartmentCreateList.add(levelThreeDepartment);
		}

		return new Object[]{levelThreeDepartmentCreateList,levelThreeDepartmentUpdateList};
	}

	protected boolean isUpdateRequest(LevelThreeDepartment levelThreeDepartment){
 		return levelThreeDepartment.getVersion() > 0;
 	}
 	protected String getSaveLevelThreeDepartmentSQL(LevelThreeDepartment levelThreeDepartment){
 		if(isUpdateRequest(levelThreeDepartment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveLevelThreeDepartmentParameters(LevelThreeDepartment levelThreeDepartment){
 		if(isUpdateRequest(levelThreeDepartment) ){
 			return prepareLevelThreeDepartmentUpdateParameters(levelThreeDepartment);
 		}
 		return prepareLevelThreeDepartmentCreateParameters(levelThreeDepartment);
 	}
 	protected Object[] prepareLevelThreeDepartmentUpdateParameters(LevelThreeDepartment levelThreeDepartment){
 		Object[] parameters = new Object[7];
 
 		if(levelThreeDepartment.getBelongsTo() != null){
 			parameters[0] = levelThreeDepartment.getBelongsTo().getId();
 		}
 
 		
 		parameters[1] = levelThreeDepartment.getName();
 		
 		
 		parameters[2] = levelThreeDepartment.getDescription();
 		
 		
 		parameters[3] = levelThreeDepartment.getFounded();
 		
 		parameters[4] = levelThreeDepartment.nextVersion();
 		parameters[5] = levelThreeDepartment.getId();
 		parameters[6] = levelThreeDepartment.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareLevelThreeDepartmentCreateParameters(LevelThreeDepartment levelThreeDepartment){
		Object[] parameters = new Object[5];
        if(levelThreeDepartment.getId() == null){
          String newLevelThreeDepartmentId=getNextId();
          levelThreeDepartment.setId(newLevelThreeDepartmentId);
        }
		parameters[0] =  levelThreeDepartment.getId();
 
 		if(levelThreeDepartment.getBelongsTo() != null){
 			parameters[1] = levelThreeDepartment.getBelongsTo().getId();

 		}
 		
 		
 		parameters[2] = levelThreeDepartment.getName();
 		
 		
 		parameters[3] = levelThreeDepartment.getDescription();
 		
 		
 		parameters[4] = levelThreeDepartment.getFounded();
 		

 		return parameters;
 	}

	protected LevelThreeDepartment saveInternalLevelThreeDepartment(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options){

		saveLevelThreeDepartment(levelThreeDepartment);

 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(levelThreeDepartment, options);
 		}
 
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(levelThreeDepartment, options);
	 		//removeEmployeeList(levelThreeDepartment, options);
	 		//Not delete the record

 		}
		
		return levelThreeDepartment;

	}



	//======================================================================================
	

 	protected LevelThreeDepartment saveBelongsTo(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelThreeDepartment.getBelongsTo() == null){
 			return levelThreeDepartment;//do nothing when it is null
 		}

 		getLevelTwoDepartmentDAO().save(levelThreeDepartment.getBelongsTo(),options);
 		return levelThreeDepartment;

 	}





 

	
	public LevelThreeDepartment planToRemoveEmployeeList(LevelThreeDepartment levelThreeDepartment, String employeeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.DEPARTMENT_PROPERTY, levelThreeDepartment.getId());
		key.put(Employee.ID_PROPERTY, employeeIds);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return levelThreeDepartment;
		}
		if(externalEmployeeList.isEmpty()){
			return levelThreeDepartment;
		}

		for(Employee employeeItem: externalEmployeeList){

			employeeItem.clearFromAll();
		}


		SmartList<Employee> employeeList = levelThreeDepartment.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return levelThreeDepartment;

	}


	//disconnect LevelThreeDepartment with company in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithCompany(LevelThreeDepartment levelThreeDepartment, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.DEPARTMENT_PROPERTY, levelThreeDepartment.getId());
		key.put(Employee.COMPANY_PROPERTY, companyId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return levelThreeDepartment;
		}
		if(externalEmployeeList.isEmpty()){
			return levelThreeDepartment;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearCompany();
			employeeItem.clearDepartment();

		}


		SmartList<Employee> employeeList = levelThreeDepartment.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return levelThreeDepartment;
	}

	public int countEmployeeListWithCompany(String levelThreeDepartmentId, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.DEPARTMENT_PROPERTY, levelThreeDepartmentId);
		key.put(Employee.COMPANY_PROPERTY, companyId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect LevelThreeDepartment with occupation in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithOccupation(LevelThreeDepartment levelThreeDepartment, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.DEPARTMENT_PROPERTY, levelThreeDepartment.getId());
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return levelThreeDepartment;
		}
		if(externalEmployeeList.isEmpty()){
			return levelThreeDepartment;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearOccupation();
			employeeItem.clearDepartment();

		}


		SmartList<Employee> employeeList = levelThreeDepartment.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return levelThreeDepartment;
	}

	public int countEmployeeListWithOccupation(String levelThreeDepartmentId, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.DEPARTMENT_PROPERTY, levelThreeDepartmentId);
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect LevelThreeDepartment with responsible_for in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithResponsibleFor(LevelThreeDepartment levelThreeDepartment, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.DEPARTMENT_PROPERTY, levelThreeDepartment.getId());
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return levelThreeDepartment;
		}
		if(externalEmployeeList.isEmpty()){
			return levelThreeDepartment;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearResponsibleFor();
			employeeItem.clearDepartment();

		}


		SmartList<Employee> employeeList = levelThreeDepartment.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return levelThreeDepartment;
	}

	public int countEmployeeListWithResponsibleFor(String levelThreeDepartmentId, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.DEPARTMENT_PROPERTY, levelThreeDepartmentId);
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect LevelThreeDepartment with current_salary_grade in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithCurrentSalaryGrade(LevelThreeDepartment levelThreeDepartment, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.DEPARTMENT_PROPERTY, levelThreeDepartment.getId());
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return levelThreeDepartment;
		}
		if(externalEmployeeList.isEmpty()){
			return levelThreeDepartment;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearCurrentSalaryGrade();
			employeeItem.clearDepartment();

		}


		SmartList<Employee> employeeList = levelThreeDepartment.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return levelThreeDepartment;
	}

	public int countEmployeeListWithCurrentSalaryGrade(String levelThreeDepartmentId, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.DEPARTMENT_PROPERTY, levelThreeDepartmentId);
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	

		
	protected LevelThreeDepartment saveEmployeeList(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options){




		SmartList<Employee> employeeList = levelThreeDepartment.getEmployeeList();
		if(employeeList == null){
			//null list means nothing
			return levelThreeDepartment;
		}
		SmartList<Employee> mergedUpdateEmployeeList = new SmartList<Employee>();


		mergedUpdateEmployeeList.addAll(employeeList);
		if(employeeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateEmployeeList.addAll(employeeList.getToRemoveList());
			employeeList.removeAll(employeeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getEmployeeDAO().saveEmployeeList(mergedUpdateEmployeeList,options);

		if(employeeList.getToRemoveList() != null){
			employeeList.removeAll(employeeList.getToRemoveList());
		}


		return levelThreeDepartment;

	}

	protected LevelThreeDepartment removeEmployeeList(LevelThreeDepartment levelThreeDepartment, Map<String,Object> options){


		SmartList<Employee> employeeList = levelThreeDepartment.getEmployeeList();
		if(employeeList == null){
			return levelThreeDepartment;
		}

		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();

		if(toRemoveEmployeeList == null){
			return levelThreeDepartment;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return levelThreeDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);

		return levelThreeDepartment;

	}








		

	public LevelThreeDepartment present(LevelThreeDepartment levelThreeDepartment,Map<String, Object> options){
	
		presentEmployeeList(levelThreeDepartment,options);

		return levelThreeDepartment;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected LevelThreeDepartment presentEmployeeList(
			LevelThreeDepartment levelThreeDepartment,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = levelThreeDepartment.getEmployeeList();		
				SmartList<Employee> newList= presentSubList(levelThreeDepartment.getId(),
				employeeList,
				options,
				getEmployeeDAO()::countEmployeeByDepartment,
				getEmployeeDAO()::findEmployeeByDepartment
				);

		
		levelThreeDepartment.setEmployeeList(newList);
		

		return levelThreeDepartment;
	}			
		

	
    public SmartList<LevelThreeDepartment> requestCandidateLevelThreeDepartmentForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LevelThreeDepartmentTable.COLUMN_BELONGS_TO, LevelThreeDepartmentTable.COLUMN_BELONGS_TO, filterKey, pageNo, pageSize, getLevelThreeDepartmentMapper());
    }
		

	protected String getTableName(){
		return LevelThreeDepartmentTable.TABLE_NAME;
	}



	public void enhanceList(List<LevelThreeDepartment> levelThreeDepartmentList) {
		this.enhanceListInternal(levelThreeDepartmentList, this.getLevelThreeDepartmentMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:Employee的department的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<LevelThreeDepartment> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.DEPARTMENT_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Employee> loadedObjs = userContext.getDAOGroup().getEmployeeDAO().findEmployeeWithKey(key, options);
		Map<String, List<Employee>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getDepartment().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Employee> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Employee> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setEmployeeList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LevelThreeDepartment> levelThreeDepartmentList = ownerEntity.collectRefsWithType(LevelThreeDepartment.INTERNAL_TYPE);
		this.enhanceList(levelThreeDepartmentList);

	}

	@Override
	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getLevelThreeDepartmentMapper());

	}
	@Override
	public int countLevelThreeDepartmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countLevelThreeDepartmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<LevelThreeDepartment> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLevelThreeDepartmentMapper());
	}

  @Override
  public Stream<LevelThreeDepartment> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getLevelThreeDepartmentMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateLevelThreeDepartment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateLevelThreeDepartment result = new CandidateLevelThreeDepartment();
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


