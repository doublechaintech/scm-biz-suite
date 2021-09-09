
package com.doublechaintech.retailscm.employeecompanytraining;

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


import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

import com.doublechaintech.retailscm.companytraining.CompanyTrainingDAO;
import com.doublechaintech.retailscm.scoring.ScoringDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class EmployeeCompanyTrainingJDBCTemplateDAO extends RetailscmBaseDAOImpl implements EmployeeCompanyTrainingDAO{

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

	protected CompanyTrainingDAO companyTrainingDAO;
	public void setCompanyTrainingDAO(CompanyTrainingDAO companyTrainingDAO){

 		if(companyTrainingDAO == null){
 			throw new IllegalStateException("Do not try to set companyTrainingDAO to null.");
 		}
	 	this.companyTrainingDAO = companyTrainingDAO;
 	}
 	public CompanyTrainingDAO getCompanyTrainingDAO(){
 		if(this.companyTrainingDAO == null){
 			throw new IllegalStateException("The companyTrainingDAO is not configured yet, please config it some where.");
 		}

	 	return this.companyTrainingDAO;
 	}

	protected ScoringDAO scoringDAO;
	public void setScoringDAO(ScoringDAO scoringDAO){

 		if(scoringDAO == null){
 			throw new IllegalStateException("Do not try to set scoringDAO to null.");
 		}
	 	this.scoringDAO = scoringDAO;
 	}
 	public ScoringDAO getScoringDAO(){
 		if(this.scoringDAO == null){
 			throw new IllegalStateException("The scoringDAO is not configured yet, please config it some where.");
 		}

	 	return this.scoringDAO;
 	}



	/*
	protected EmployeeCompanyTraining load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeCompanyTraining(accessKey, options);
	}
	*/

	public SmartList<EmployeeCompanyTraining> loadAll() {
	    return this.loadAll(getEmployeeCompanyTrainingMapper());
	}

  public Stream<EmployeeCompanyTraining> loadAllAsStream() {
      return this.loadAllAsStream(getEmployeeCompanyTrainingMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public EmployeeCompanyTraining load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeCompanyTraining(EmployeeCompanyTrainingTable.withId(id), options);
	}

	

	public EmployeeCompanyTraining save(EmployeeCompanyTraining employeeCompanyTraining,Map<String,Object> options){

		String methodName="save(EmployeeCompanyTraining employeeCompanyTraining,Map<String,Object> options)";

		assertMethodArgumentNotNull(employeeCompanyTraining, methodName, "employeeCompanyTraining");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalEmployeeCompanyTraining(employeeCompanyTraining,options);
	}
	public EmployeeCompanyTraining clone(String employeeCompanyTrainingId, Map<String,Object> options) throws Exception{

		return clone(EmployeeCompanyTrainingTable.withId(employeeCompanyTrainingId),options);
	}

	protected EmployeeCompanyTraining clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String employeeCompanyTrainingId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		EmployeeCompanyTraining newEmployeeCompanyTraining = loadInternalEmployeeCompanyTraining(accessKey, options);
		newEmployeeCompanyTraining.setVersion(0);
		
		


		saveInternalEmployeeCompanyTraining(newEmployeeCompanyTraining,options);

		return newEmployeeCompanyTraining;
	}

	



	protected void throwIfHasException(String employeeCompanyTrainingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EmployeeCompanyTrainingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeCompanyTrainingNotFoundException(
					"The " + this.getTableName() + "(" + employeeCompanyTrainingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String employeeCompanyTrainingId, int version) throws Exception{

		String methodName="delete(String employeeCompanyTrainingId, int version)";
		assertMethodArgumentNotNull(employeeCompanyTrainingId, methodName, "employeeCompanyTrainingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeCompanyTrainingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeCompanyTrainingId,version);
		}


	}






	public EmployeeCompanyTraining disconnectFromAll(String employeeCompanyTrainingId, int version) throws Exception{


		EmployeeCompanyTraining employeeCompanyTraining = loadInternalEmployeeCompanyTraining(EmployeeCompanyTrainingTable.withId(employeeCompanyTrainingId), emptyOptions());
		employeeCompanyTraining.clearFromAll();
		this.saveEmployeeCompanyTraining(employeeCompanyTraining);
		return employeeCompanyTraining;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return EmployeeCompanyTrainingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "employee_company_training";
	}
	@Override
	protected String getBeanName() {

		return "employeeCompanyTraining";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return EmployeeCompanyTrainingTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){

	 	return checkOptions(options, EmployeeCompanyTrainingTokens.EMPLOYEE);
 	}

 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){

 		return checkOptions(options, EmployeeCompanyTrainingTokens.EMPLOYEE);
 	}



 

 	protected boolean isExtractTrainingEnabled(Map<String,Object> options){

	 	return checkOptions(options, EmployeeCompanyTrainingTokens.TRAINING);
 	}

 	protected boolean isSaveTrainingEnabled(Map<String,Object> options){

 		return checkOptions(options, EmployeeCompanyTrainingTokens.TRAINING);
 	}



 

 	protected boolean isExtractScoringEnabled(Map<String,Object> options){

	 	return checkOptions(options, EmployeeCompanyTrainingTokens.SCORING);
 	}

 	protected boolean isSaveScoringEnabled(Map<String,Object> options){

 		return checkOptions(options, EmployeeCompanyTrainingTokens.SCORING);
 	}



 
		

	

	protected EmployeeCompanyTrainingMapper getEmployeeCompanyTrainingMapper(){
		return new EmployeeCompanyTrainingMapper();
	}



	protected EmployeeCompanyTraining extractEmployeeCompanyTraining(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EmployeeCompanyTraining employeeCompanyTraining = loadSingleObject(accessKey, getEmployeeCompanyTrainingMapper());
			return employeeCompanyTraining;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeCompanyTrainingNotFoundException("EmployeeCompanyTraining("+accessKey+") is not found!");
		}

	}




	protected EmployeeCompanyTraining loadInternalEmployeeCompanyTraining(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		EmployeeCompanyTraining employeeCompanyTraining = extractEmployeeCompanyTraining(accessKey, loadOptions);

 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeCompanyTraining, loadOptions);
 		}
 
 		if(isExtractTrainingEnabled(loadOptions)){
	 		extractTraining(employeeCompanyTraining, loadOptions);
 		}
 
 		if(isExtractScoringEnabled(loadOptions)){
	 		extractScoring(employeeCompanyTraining, loadOptions);
 		}
 
		
		return employeeCompanyTraining;

	}

	

 	protected EmployeeCompanyTraining extractEmployee(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options) throws Exception{
  

		if(employeeCompanyTraining.getEmployee() == null){
			return employeeCompanyTraining;
		}
		String employeeId = employeeCompanyTraining.getEmployee().getId();
		if( employeeId == null){
			return employeeCompanyTraining;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeCompanyTraining.setEmployee(employee);
		}


 		return employeeCompanyTraining;
 	}

 

 	protected EmployeeCompanyTraining extractTraining(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options) throws Exception{
  

		if(employeeCompanyTraining.getTraining() == null){
			return employeeCompanyTraining;
		}
		String trainingId = employeeCompanyTraining.getTraining().getId();
		if( trainingId == null){
			return employeeCompanyTraining;
		}
		CompanyTraining training = getCompanyTrainingDAO().load(trainingId,options);
		if(training != null){
			employeeCompanyTraining.setTraining(training);
		}


 		return employeeCompanyTraining;
 	}

 

 	protected EmployeeCompanyTraining extractScoring(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options) throws Exception{
  

		if(employeeCompanyTraining.getScoring() == null){
			return employeeCompanyTraining;
		}
		String scoringId = employeeCompanyTraining.getScoring().getId();
		if( scoringId == null){
			return employeeCompanyTraining;
		}
		Scoring scoring = getScoringDAO().load(scoringId,options);
		if(scoring != null){
			employeeCompanyTraining.setScoring(scoring);
		}


 		return employeeCompanyTraining;
 	}

 
		

 
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByEmployee(String employeeId,Map<String,Object> options){

  		SmartList<EmployeeCompanyTraining> resultList = queryWith(EmployeeCompanyTrainingTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeCompanyTrainingMapper());
		// analyzeEmployeeCompanyTrainingByEmployee(resultList, employeeId, options);
		return resultList;
 	}
 	

 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByEmployee(String employeeId, int start, int count,Map<String,Object> options){

 		SmartList<EmployeeCompanyTraining> resultList =  queryWithRange(EmployeeCompanyTrainingTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeCompanyTrainingMapper(), start, count);
 		//analyzeEmployeeCompanyTrainingByEmployee(resultList, employeeId, options);
 		return resultList;

 	}
 	public void analyzeEmployeeCompanyTrainingByEmployee(SmartList<EmployeeCompanyTraining> resultList, String employeeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employeeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countEmployeeCompanyTrainingByEmployee(String employeeId,Map<String,Object> options){

 		return countWith(EmployeeCompanyTrainingTable.COLUMN_EMPLOYEE, employeeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeCompanyTrainingByEmployeeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeCompanyTrainingTable.COLUMN_EMPLOYEE, ids, options);
	}

 
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByTraining(String companyTrainingId,Map<String,Object> options){

  		SmartList<EmployeeCompanyTraining> resultList = queryWith(EmployeeCompanyTrainingTable.COLUMN_TRAINING, companyTrainingId, options, getEmployeeCompanyTrainingMapper());
		// analyzeEmployeeCompanyTrainingByTraining(resultList, companyTrainingId, options);
		return resultList;
 	}
 	

 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByTraining(String companyTrainingId, int start, int count,Map<String,Object> options){

 		SmartList<EmployeeCompanyTraining> resultList =  queryWithRange(EmployeeCompanyTrainingTable.COLUMN_TRAINING, companyTrainingId, options, getEmployeeCompanyTrainingMapper(), start, count);
 		//analyzeEmployeeCompanyTrainingByTraining(resultList, companyTrainingId, options);
 		return resultList;

 	}
 	public void analyzeEmployeeCompanyTrainingByTraining(SmartList<EmployeeCompanyTraining> resultList, String companyTrainingId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EmployeeCompanyTraining.TRAINING_PROPERTY, companyTrainingId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countEmployeeCompanyTrainingByTraining(String companyTrainingId,Map<String,Object> options){

 		return countWith(EmployeeCompanyTrainingTable.COLUMN_TRAINING, companyTrainingId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeCompanyTrainingByTrainingIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeCompanyTrainingTable.COLUMN_TRAINING, ids, options);
	}

 
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByScoring(String scoringId,Map<String,Object> options){

  		SmartList<EmployeeCompanyTraining> resultList = queryWith(EmployeeCompanyTrainingTable.COLUMN_SCORING, scoringId, options, getEmployeeCompanyTrainingMapper());
		// analyzeEmployeeCompanyTrainingByScoring(resultList, scoringId, options);
		return resultList;
 	}
 	

 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByScoring(String scoringId, int start, int count,Map<String,Object> options){

 		SmartList<EmployeeCompanyTraining> resultList =  queryWithRange(EmployeeCompanyTrainingTable.COLUMN_SCORING, scoringId, options, getEmployeeCompanyTrainingMapper(), start, count);
 		//analyzeEmployeeCompanyTrainingByScoring(resultList, scoringId, options);
 		return resultList;

 	}
 	public void analyzeEmployeeCompanyTrainingByScoring(SmartList<EmployeeCompanyTraining> resultList, String scoringId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoringId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countEmployeeCompanyTrainingByScoring(String scoringId,Map<String,Object> options){

 		return countWith(EmployeeCompanyTrainingTable.COLUMN_SCORING, scoringId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeCompanyTrainingByScoringIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeCompanyTrainingTable.COLUMN_SCORING, ids, options);
	}

 




	

	protected EmployeeCompanyTraining saveEmployeeCompanyTraining(EmployeeCompanyTraining  employeeCompanyTraining){
    

		
		if(!employeeCompanyTraining.isChanged()){
			return employeeCompanyTraining;
		}
		

    Beans.dbUtil().cacheCleanUp(employeeCompanyTraining);
		String SQL=this.getSaveEmployeeCompanyTrainingSQL(employeeCompanyTraining);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeCompanyTrainingParameters(employeeCompanyTraining);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		employeeCompanyTraining.incVersion();
		employeeCompanyTraining.afterSave();
		return employeeCompanyTraining;

	}
	public SmartList<EmployeeCompanyTraining> saveEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeCompanyTrainingList(employeeCompanyTrainingList);

		batchEmployeeCompanyTrainingCreate((List<EmployeeCompanyTraining>)lists[CREATE_LIST_INDEX]);

		batchEmployeeCompanyTrainingUpdate((List<EmployeeCompanyTraining>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			if(employeeCompanyTraining.isChanged()){
				employeeCompanyTraining.incVersion();
				employeeCompanyTraining.afterSave();
			}


		}


		return employeeCompanyTrainingList;
	}

	public SmartList<EmployeeCompanyTraining> removeEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList,Map<String,Object> options){


		super.removeList(employeeCompanyTrainingList, options);

		return employeeCompanyTrainingList;


	}

	protected List<Object[]> prepareEmployeeCompanyTrainingBatchCreateArgs(List<EmployeeCompanyTraining> employeeCompanyTrainingList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList ){
			Object [] parameters = prepareEmployeeCompanyTrainingCreateParameters(employeeCompanyTraining);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareEmployeeCompanyTrainingBatchUpdateArgs(List<EmployeeCompanyTraining> employeeCompanyTrainingList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList ){
			if(!employeeCompanyTraining.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeCompanyTrainingUpdateParameters(employeeCompanyTraining);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchEmployeeCompanyTrainingCreate(List<EmployeeCompanyTraining> employeeCompanyTrainingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeCompanyTrainingBatchCreateArgs(employeeCompanyTrainingList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchEmployeeCompanyTrainingUpdate(List<EmployeeCompanyTraining> employeeCompanyTrainingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeCompanyTrainingBatchUpdateArgs(employeeCompanyTrainingList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitEmployeeCompanyTrainingList(List<EmployeeCompanyTraining> employeeCompanyTrainingList){

		List<EmployeeCompanyTraining> employeeCompanyTrainingCreateList=new ArrayList<EmployeeCompanyTraining>();
		List<EmployeeCompanyTraining> employeeCompanyTrainingUpdateList=new ArrayList<EmployeeCompanyTraining>();

		for(EmployeeCompanyTraining employeeCompanyTraining: employeeCompanyTrainingList){
			if(isUpdateRequest(employeeCompanyTraining)){
				employeeCompanyTrainingUpdateList.add( employeeCompanyTraining);
				continue;
			}
			employeeCompanyTrainingCreateList.add(employeeCompanyTraining);
		}

		return new Object[]{employeeCompanyTrainingCreateList,employeeCompanyTrainingUpdateList};
	}

	protected boolean isUpdateRequest(EmployeeCompanyTraining employeeCompanyTraining){
 		return employeeCompanyTraining.getVersion() > 0;
 	}
 	protected String getSaveEmployeeCompanyTrainingSQL(EmployeeCompanyTraining employeeCompanyTraining){
 		if(isUpdateRequest(employeeCompanyTraining)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveEmployeeCompanyTrainingParameters(EmployeeCompanyTraining employeeCompanyTraining){
 		if(isUpdateRequest(employeeCompanyTraining) ){
 			return prepareEmployeeCompanyTrainingUpdateParameters(employeeCompanyTraining);
 		}
 		return prepareEmployeeCompanyTrainingCreateParameters(employeeCompanyTraining);
 	}
 	protected Object[] prepareEmployeeCompanyTrainingUpdateParameters(EmployeeCompanyTraining employeeCompanyTraining){
 		Object[] parameters = new Object[6];
 
 		if(employeeCompanyTraining.getEmployee() != null){
 			parameters[0] = employeeCompanyTraining.getEmployee().getId();
 		}
    
 		if(employeeCompanyTraining.getTraining() != null){
 			parameters[1] = employeeCompanyTraining.getTraining().getId();
 		}
    
 		if(employeeCompanyTraining.getScoring() != null){
 			parameters[2] = employeeCompanyTraining.getScoring().getId();
 		}
    
 		parameters[3] = employeeCompanyTraining.nextVersion();
 		parameters[4] = employeeCompanyTraining.getId();
 		parameters[5] = employeeCompanyTraining.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareEmployeeCompanyTrainingCreateParameters(EmployeeCompanyTraining employeeCompanyTraining){
		Object[] parameters = new Object[4];
        if(employeeCompanyTraining.getId() == null){
          String newEmployeeCompanyTrainingId=getNextId();
          employeeCompanyTraining.setId(newEmployeeCompanyTrainingId);
        }
		parameters[0] =  employeeCompanyTraining.getId();
 
 		if(employeeCompanyTraining.getEmployee() != null){
 			parameters[1] = employeeCompanyTraining.getEmployee().getId();
 		}
 		
 		if(employeeCompanyTraining.getTraining() != null){
 			parameters[2] = employeeCompanyTraining.getTraining().getId();
 		}
 		
 		if(employeeCompanyTraining.getScoring() != null){
 			parameters[3] = employeeCompanyTraining.getScoring().getId();
 		}
 		

 		return parameters;
 	}

	protected EmployeeCompanyTraining saveInternalEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options){

 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeCompanyTraining, options);
 		}
 
 		if(isSaveTrainingEnabled(options)){
	 		saveTraining(employeeCompanyTraining, options);
 		}
 
 		if(isSaveScoringEnabled(options)){
	 		saveScoring(employeeCompanyTraining, options);
 		}
 
   saveEmployeeCompanyTraining(employeeCompanyTraining);
		
		return employeeCompanyTraining;

	}



	//======================================================================================
	

 	protected EmployeeCompanyTraining saveEmployee(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(employeeCompanyTraining.getEmployee() == null){
 			return employeeCompanyTraining;//do nothing when it is null
 		}

 		getEmployeeDAO().save(employeeCompanyTraining.getEmployee(),options);
 		return employeeCompanyTraining;

 	}
 

 	protected EmployeeCompanyTraining saveTraining(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(employeeCompanyTraining.getTraining() == null){
 			return employeeCompanyTraining;//do nothing when it is null
 		}

 		getCompanyTrainingDAO().save(employeeCompanyTraining.getTraining(),options);
 		return employeeCompanyTraining;

 	}
 

 	protected EmployeeCompanyTraining saveScoring(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(employeeCompanyTraining.getScoring() == null){
 			return employeeCompanyTraining;//do nothing when it is null
 		}

 		getScoringDAO().save(employeeCompanyTraining.getScoring(),options);
 		return employeeCompanyTraining;

 	}
 

	

		

	public EmployeeCompanyTraining present(EmployeeCompanyTraining employeeCompanyTraining,Map<String, Object> options){


		return employeeCompanyTraining;

	}
		

	

	protected String getTableName(){
		return EmployeeCompanyTrainingTable.TABLE_NAME;
	}



	public void enhanceList(List<EmployeeCompanyTraining> employeeCompanyTrainingList) {
		this.enhanceListInternal(employeeCompanyTrainingList, this.getEmployeeCompanyTrainingMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EmployeeCompanyTraining> employeeCompanyTrainingList = ownerEntity.collectRefsWithType(EmployeeCompanyTraining.INTERNAL_TYPE);
		this.enhanceList(employeeCompanyTrainingList);

	}

	@Override
	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getEmployeeCompanyTrainingMapper());

	}
	@Override
	public int countEmployeeCompanyTrainingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countEmployeeCompanyTrainingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<EmployeeCompanyTraining> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEmployeeCompanyTrainingMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<EmployeeCompanyTraining> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getEmployeeCompanyTrainingMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateEmployeeCompanyTraining executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateEmployeeCompanyTraining result = new CandidateEmployeeCompanyTraining();
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
  public List<EmployeeCompanyTraining> search(EmployeeCompanyTrainingRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected EmployeeCompanyTrainingMapper mapper() {
    return getEmployeeCompanyTrainingMapper();
  }
}


