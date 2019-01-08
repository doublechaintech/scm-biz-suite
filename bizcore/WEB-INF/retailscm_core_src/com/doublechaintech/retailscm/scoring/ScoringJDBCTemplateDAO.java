
package com.doublechaintech.retailscm.scoring;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.RetailscmNamingServiceDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class ScoringJDBCTemplateDAO extends RetailscmNamingServiceDAO implements ScoringDAO{


			
		
	
  	private  EmployeeCompanyTrainingDAO  employeeCompanyTrainingDAO;
 	public void setEmployeeCompanyTrainingDAO(EmployeeCompanyTrainingDAO pEmployeeCompanyTrainingDAO){
 	
 		if(pEmployeeCompanyTrainingDAO == null){
 			throw new IllegalStateException("Do not try to set employeeCompanyTrainingDAO to null.");
 		}
	 	this.employeeCompanyTrainingDAO = pEmployeeCompanyTrainingDAO;
 	}
 	public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO(){
 		if(this.employeeCompanyTrainingDAO == null){
 			throw new IllegalStateException("The employeeCompanyTrainingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeCompanyTrainingDAO;
 	}	
 	
			
		

	
	/*
	protected Scoring load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalScoring(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Scoring load(String id,Map<String,Object> options) throws Exception{
		return loadInternalScoring(ScoringTable.withId(id), options);
	}
	
	
	
	public Scoring save(Scoring scoring,Map<String,Object> options){
		
		String methodName="save(Scoring scoring,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(scoring, methodName, "scoring");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalScoring(scoring,options);
	}
	public Scoring clone(String scoringId, Map<String,Object> options) throws Exception{
	
		return clone(ScoringTable.withId(scoringId),options);
	}
	
	protected Scoring clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String scoringId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Scoring newScoring = loadInternalScoring(accessKey, options);
		newScoring.setVersion(0);
		
		
 		
 		if(isSaveEmployeeCompanyTrainingListEnabled(options)){
 			for(EmployeeCompanyTraining item: newScoring.getEmployeeCompanyTrainingList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalScoring(newScoring,options);
		
		return newScoring;
	}
	
	
	
	

	protected void throwIfHasException(String scoringId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ScoringVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ScoringNotFoundException(
					"The " + this.getTableName() + "(" + scoringId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String scoringId, int version) throws Exception{
	
		String methodName="delete(String scoringId, int version)";
		assertMethodArgumentNotNull(scoringId, methodName, "scoringId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{scoringId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(scoringId,version);
		}
		
	
	}
	
	
	
	
	

	public Scoring disconnectFromAll(String scoringId, int version) throws Exception{
	
		
		Scoring scoring = loadInternalScoring(ScoringTable.withId(scoringId), emptyOptions());
		scoring.clearFromAll();
		this.saveScoring(scoring);
		return scoring;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ScoringTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "scoring";
	}
	@Override
	protected String getBeanName() {
		
		return "scoring";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ScoringTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractEmployeeCompanyTrainingListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ScoringTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
 	}
 	protected boolean isAnalyzeEmployeeCompanyTrainingListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ScoringTokens.EMPLOYEE_COMPANY_TRAINING_LIST+".analyze");
 	}

	protected boolean isSaveEmployeeCompanyTrainingListEnabled(Map<String,Object> options){
		return checkOptions(options, ScoringTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
		
 	}
 	
		

	

	protected ScoringMapper getScoringMapper(){
		return new ScoringMapper();
	}

	
	
	protected Scoring extractScoring(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Scoring scoring = loadSingleObject(accessKey, getScoringMapper());
			return scoring;
		}catch(EmptyResultDataAccessException e){
			throw new ScoringNotFoundException("Scoring("+accessKey+") is not found!");
		}

	}

	
	

	protected Scoring loadInternalScoring(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Scoring scoring = extractScoring(accessKey, loadOptions);

		
		if(isExtractEmployeeCompanyTrainingListEnabled(loadOptions)){
	 		extractEmployeeCompanyTrainingList(scoring, loadOptions);
 		}	
 		if(isAnalyzeEmployeeCompanyTrainingListEnabled(loadOptions)){
	 		// analyzeEmployeeCompanyTrainingList(scoring, loadOptions);
 		}
 		
		
		return scoring;
		
	}

	
		
	protected void enhanceEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Scoring extractEmployeeCompanyTrainingList(Scoring scoring, Map<String,Object> options){
		
		
		if(scoring == null){
			return null;
		}
		if(scoring.getId() == null){
			return scoring;
		}

		
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingByScoring(scoring.getId(),options);
		if(employeeCompanyTrainingList != null){
			enhanceEmployeeCompanyTrainingList(employeeCompanyTrainingList,options);
			scoring.setEmployeeCompanyTrainingList(employeeCompanyTrainingList);
		}
		
		return scoring;
	
	}	
	
	protected Scoring analyzeEmployeeCompanyTrainingList(Scoring scoring, Map<String,Object> options){
		
		
		if(scoring == null){
			return null;
		}
		if(scoring.getId() == null){
			return scoring;
		}

		
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = scoring.getEmployeeCompanyTrainingList();
		if(employeeCompanyTrainingList != null){
			getEmployeeCompanyTrainingDAO().analyzeEmployeeCompanyTrainingByScoring(employeeCompanyTrainingList, scoring.getId(), options);
			
		}
		
		return scoring;
	
	}	
	
		
		
 	
		
		
		

	

	protected Scoring saveScoring(Scoring  scoring){
		
		if(!scoring.isChanged()){
			return scoring;
		}
		
		
		String SQL=this.getSaveScoringSQL(scoring);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveScoringParameters(scoring);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		scoring.incVersion();
		return scoring;
	
	}
	public SmartList<Scoring> saveScoringList(SmartList<Scoring> scoringList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitScoringList(scoringList);
		
		batchScoringCreate((List<Scoring>)lists[CREATE_LIST_INDEX]);
		
		batchScoringUpdate((List<Scoring>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Scoring scoring:scoringList){
			if(scoring.isChanged()){
				scoring.incVersion();
			}
			
		
		}
		
		
		return scoringList;
	}

	public SmartList<Scoring> removeScoringList(SmartList<Scoring> scoringList,Map<String,Object> options){
		
		
		super.removeList(scoringList, options);
		
		return scoringList;
		
		
	}
	
	protected List<Object[]> prepareScoringBatchCreateArgs(List<Scoring> scoringList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Scoring scoring:scoringList ){
			Object [] parameters = prepareScoringCreateParameters(scoring);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareScoringBatchUpdateArgs(List<Scoring> scoringList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Scoring scoring:scoringList ){
			if(!scoring.isChanged()){
				continue;
			}
			Object [] parameters = prepareScoringUpdateParameters(scoring);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchScoringCreate(List<Scoring> scoringList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareScoringBatchCreateArgs(scoringList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchScoringUpdate(List<Scoring> scoringList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareScoringBatchUpdateArgs(scoringList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitScoringList(List<Scoring> scoringList){
		
		List<Scoring> scoringCreateList=new ArrayList<Scoring>();
		List<Scoring> scoringUpdateList=new ArrayList<Scoring>();
		
		for(Scoring scoring: scoringList){
			if(isUpdateRequest(scoring)){
				scoringUpdateList.add( scoring);
				continue;
			}
			scoringCreateList.add(scoring);
		}
		
		return new Object[]{scoringCreateList,scoringUpdateList};
	}
	
	protected boolean isUpdateRequest(Scoring scoring){
 		return scoring.getVersion() > 0;
 	}
 	protected String getSaveScoringSQL(Scoring scoring){
 		if(isUpdateRequest(scoring)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveScoringParameters(Scoring scoring){
 		if(isUpdateRequest(scoring) ){
 			return prepareScoringUpdateParameters(scoring);
 		}
 		return prepareScoringCreateParameters(scoring);
 	}
 	protected Object[] prepareScoringUpdateParameters(Scoring scoring){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = scoring.getScoredBy();
 		parameters[1] = scoring.getScore();
 		parameters[2] = scoring.getComment();		
 		parameters[3] = scoring.nextVersion();
 		parameters[4] = scoring.getId();
 		parameters[5] = scoring.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareScoringCreateParameters(Scoring scoring){
		Object[] parameters = new Object[4];
		String newScoringId=getNextId();
		scoring.setId(newScoringId);
		parameters[0] =  scoring.getId();
 
 		parameters[1] = scoring.getScoredBy();
 		parameters[2] = scoring.getScore();
 		parameters[3] = scoring.getComment();		
 				
 		return parameters;
 	}
 	
	protected Scoring saveInternalScoring(Scoring scoring, Map<String,Object> options){
		
		saveScoring(scoring);

		
		if(isSaveEmployeeCompanyTrainingListEnabled(options)){
	 		saveEmployeeCompanyTrainingList(scoring, options);
	 		//removeEmployeeCompanyTrainingList(scoring, options);
	 		//Not delete the record
	 		
 		}		
		
		return scoring;
		
	}
	
	
	
	//======================================================================================
	

	
	public Scoring planToRemoveEmployeeCompanyTrainingList(Scoring scoring, String employeeCompanyTrainingIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoring.getId());
		key.put(EmployeeCompanyTraining.ID_PROPERTY, employeeCompanyTrainingIds);
		
		SmartList<EmployeeCompanyTraining> externalEmployeeCompanyTrainingList = getEmployeeCompanyTrainingDAO().
				findEmployeeCompanyTrainingWithKey(key, options);
		if(externalEmployeeCompanyTrainingList == null){
			return scoring;
		}
		if(externalEmployeeCompanyTrainingList.isEmpty()){
			return scoring;
		}
		
		for(EmployeeCompanyTraining employeeCompanyTraining: externalEmployeeCompanyTrainingList){

			employeeCompanyTraining.clearFromAll();
		}
		
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = scoring.getEmployeeCompanyTrainingList();		
		employeeCompanyTrainingList.addAllToRemoveList(externalEmployeeCompanyTrainingList);
		return scoring;	
	
	}


	//disconnect Scoring with employee in EmployeeCompanyTraining
	public Scoring planToRemoveEmployeeCompanyTrainingListWithEmployee(Scoring scoring, String employeeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoring.getId());
		key.put(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employeeId);
		
		SmartList<EmployeeCompanyTraining> externalEmployeeCompanyTrainingList = getEmployeeCompanyTrainingDAO().
				findEmployeeCompanyTrainingWithKey(key, options);
		if(externalEmployeeCompanyTrainingList == null){
			return scoring;
		}
		if(externalEmployeeCompanyTrainingList.isEmpty()){
			return scoring;
		}
		
		for(EmployeeCompanyTraining employeeCompanyTraining: externalEmployeeCompanyTrainingList){
			employeeCompanyTraining.clearEmployee();
			employeeCompanyTraining.clearScoring();
			
		}
		
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = scoring.getEmployeeCompanyTrainingList();		
		employeeCompanyTrainingList.addAllToRemoveList(externalEmployeeCompanyTrainingList);
		return scoring;
	}
	
	public int countEmployeeCompanyTrainingListWithEmployee(String scoringId, String employeeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoringId);
		key.put(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employeeId);
		
		int count = getEmployeeCompanyTrainingDAO().countEmployeeCompanyTrainingWithKey(key, options);
		return count;
	}
	
	//disconnect Scoring with training in EmployeeCompanyTraining
	public Scoring planToRemoveEmployeeCompanyTrainingListWithTraining(Scoring scoring, String trainingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoring.getId());
		key.put(EmployeeCompanyTraining.TRAINING_PROPERTY, trainingId);
		
		SmartList<EmployeeCompanyTraining> externalEmployeeCompanyTrainingList = getEmployeeCompanyTrainingDAO().
				findEmployeeCompanyTrainingWithKey(key, options);
		if(externalEmployeeCompanyTrainingList == null){
			return scoring;
		}
		if(externalEmployeeCompanyTrainingList.isEmpty()){
			return scoring;
		}
		
		for(EmployeeCompanyTraining employeeCompanyTraining: externalEmployeeCompanyTrainingList){
			employeeCompanyTraining.clearTraining();
			employeeCompanyTraining.clearScoring();
			
		}
		
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = scoring.getEmployeeCompanyTrainingList();		
		employeeCompanyTrainingList.addAllToRemoveList(externalEmployeeCompanyTrainingList);
		return scoring;
	}
	
	public int countEmployeeCompanyTrainingListWithTraining(String scoringId, String trainingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoringId);
		key.put(EmployeeCompanyTraining.TRAINING_PROPERTY, trainingId);
		
		int count = getEmployeeCompanyTrainingDAO().countEmployeeCompanyTrainingWithKey(key, options);
		return count;
	}
	

		
	protected Scoring saveEmployeeCompanyTrainingList(Scoring scoring, Map<String,Object> options){
		
		
		
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = scoring.getEmployeeCompanyTrainingList();
		if(employeeCompanyTrainingList == null){
			//null list means nothing
			return scoring;
		}
		SmartList<EmployeeCompanyTraining> mergedUpdateEmployeeCompanyTrainingList = new SmartList<EmployeeCompanyTraining>();
		
		
		mergedUpdateEmployeeCompanyTrainingList.addAll(employeeCompanyTrainingList); 
		if(employeeCompanyTrainingList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateEmployeeCompanyTrainingList.addAll(employeeCompanyTrainingList.getToRemoveList());
			employeeCompanyTrainingList.removeAll(employeeCompanyTrainingList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getEmployeeCompanyTrainingDAO().saveEmployeeCompanyTrainingList(mergedUpdateEmployeeCompanyTrainingList,options);
		
		if(employeeCompanyTrainingList.getToRemoveList() != null){
			employeeCompanyTrainingList.removeAll(employeeCompanyTrainingList.getToRemoveList());
		}
		
		
		return scoring;
	
	}
	
	protected Scoring removeEmployeeCompanyTrainingList(Scoring scoring, Map<String,Object> options){
	
	
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = scoring.getEmployeeCompanyTrainingList();
		if(employeeCompanyTrainingList == null){
			return scoring;
		}	
	
		SmartList<EmployeeCompanyTraining> toRemoveEmployeeCompanyTrainingList = employeeCompanyTrainingList.getToRemoveList();
		
		if(toRemoveEmployeeCompanyTrainingList == null){
			return scoring;
		}
		if(toRemoveEmployeeCompanyTrainingList.isEmpty()){
			return scoring;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeCompanyTrainingDAO().removeEmployeeCompanyTrainingList(toRemoveEmployeeCompanyTrainingList,options);
		
		return scoring;
	
	}
	
	

 	
 	
	
	
	
		

	public Scoring present(Scoring scoring,Map<String, Object> options){
	
		presentEmployeeCompanyTrainingList(scoring,options);

		return scoring;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Scoring presentEmployeeCompanyTrainingList(
			Scoring scoring,
			Map<String, Object> options) {

		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = scoring.getEmployeeCompanyTrainingList();		
				SmartList<EmployeeCompanyTraining> newList= presentSubList(scoring.getId(),
				employeeCompanyTrainingList,
				options,
				getEmployeeCompanyTrainingDAO()::countEmployeeCompanyTrainingByScoring,
				getEmployeeCompanyTrainingDAO()::findEmployeeCompanyTrainingByScoring
				);

		
		scoring.setEmployeeCompanyTrainingList(newList);
		

		return scoring;
	}			
		

	
    public SmartList<Scoring> requestCandidateScoringForEmployeeCompanyTraining(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ScoringTable.COLUMN_SCORED_BY, filterKey, pageNo, pageSize, getScoringMapper());
    }
		

	protected String getTableName(){
		return ScoringTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Scoring> scoringList) {		
		this.enhanceListInternal(scoringList, this.getScoringMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Scoring> scoringList = ownerEntity.collectRefsWithType(Scoring.INTERNAL_TYPE);
		this.enhanceList(scoringList);
		
	}
	
	@Override
	public SmartList<Scoring> findScoringWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getScoringMapper());

	}
	@Override
	public int countScoringWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countScoringWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Scoring> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getScoringMapper());
	}
}


