
package com.doublechaintech.retailscm.leveltwodepartment;

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


import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;

import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentDAO;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class LevelTwoDepartmentJDBCTemplateDAO extends RetailscmBaseDAOImpl implements LevelTwoDepartmentDAO{

	protected LevelOneDepartmentDAO levelOneDepartmentDAO;
	public void setLevelOneDepartmentDAO(LevelOneDepartmentDAO levelOneDepartmentDAO){
 	
 		if(levelOneDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set levelOneDepartmentDAO to null.");
 		}
	 	this.levelOneDepartmentDAO = levelOneDepartmentDAO;
 	}
 	public LevelOneDepartmentDAO getLevelOneDepartmentDAO(){
 		if(this.levelOneDepartmentDAO == null){
 			throw new IllegalStateException("The levelOneDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelOneDepartmentDAO;
 	}	

	protected LevelThreeDepartmentDAO levelThreeDepartmentDAO;
	public void setLevelThreeDepartmentDAO(LevelThreeDepartmentDAO levelThreeDepartmentDAO){
 	
 		if(levelThreeDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set levelThreeDepartmentDAO to null.");
 		}
	 	this.levelThreeDepartmentDAO = levelThreeDepartmentDAO;
 	}
 	public LevelThreeDepartmentDAO getLevelThreeDepartmentDAO(){
 		if(this.levelThreeDepartmentDAO == null){
 			throw new IllegalStateException("The levelThreeDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelThreeDepartmentDAO;
 	}	


	/*
	protected LevelTwoDepartment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelTwoDepartment(accessKey, options);
	}
	*/

	public SmartList<LevelTwoDepartment> loadAll() {
	    return this.loadAll(getLevelTwoDepartmentMapper());
	}

  public Stream<LevelTwoDepartment> loadAllAsStream() {
      return this.loadAllAsStream(getLevelTwoDepartmentMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public LevelTwoDepartment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelTwoDepartment(LevelTwoDepartmentTable.withId(id), options);
	}

	

	public LevelTwoDepartment save(LevelTwoDepartment levelTwoDepartment,Map<String,Object> options){

		String methodName="save(LevelTwoDepartment levelTwoDepartment,Map<String,Object> options)";

		assertMethodArgumentNotNull(levelTwoDepartment, methodName, "levelTwoDepartment");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalLevelTwoDepartment(levelTwoDepartment,options);
	}
	public LevelTwoDepartment clone(String levelTwoDepartmentId, Map<String,Object> options) throws Exception{

		return clone(LevelTwoDepartmentTable.withId(levelTwoDepartmentId),options);
	}

	protected LevelTwoDepartment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String levelTwoDepartmentId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		LevelTwoDepartment newLevelTwoDepartment = loadInternalLevelTwoDepartment(accessKey, options);
		newLevelTwoDepartment.setVersion(0);
		
		
 		
 		if(isSaveLevelThreeDepartmentListEnabled(options)){
 			for(LevelThreeDepartment item: newLevelTwoDepartment.getLevelThreeDepartmentList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalLevelTwoDepartment(newLevelTwoDepartment,options);

		return newLevelTwoDepartment;
	}

	



	protected void throwIfHasException(String levelTwoDepartmentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LevelTwoDepartmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelTwoDepartmentNotFoundException(
					"The " + this.getTableName() + "(" + levelTwoDepartmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String levelTwoDepartmentId, int version) throws Exception{

		String methodName="delete(String levelTwoDepartmentId, int version)";
		assertMethodArgumentNotNull(levelTwoDepartmentId, methodName, "levelTwoDepartmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelTwoDepartmentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelTwoDepartmentId,version);
		}


	}






	public LevelTwoDepartment disconnectFromAll(String levelTwoDepartmentId, int version) throws Exception{


		LevelTwoDepartment levelTwoDepartment = loadInternalLevelTwoDepartment(LevelTwoDepartmentTable.withId(levelTwoDepartmentId), emptyOptions());
		levelTwoDepartment.clearFromAll();
		this.saveLevelTwoDepartment(levelTwoDepartment);
		return levelTwoDepartment;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return LevelTwoDepartmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "level_two_department";
	}
	@Override
	protected String getBeanName() {

		return "levelTwoDepartment";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelTwoDepartmentTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelTwoDepartmentTokens.BELONGSTO);
 	}

 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelTwoDepartmentTokens.BELONGSTO);
 	}
 	

 	
 
		
	
	protected boolean isExtractLevelThreeDepartmentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LevelTwoDepartmentTokens.LEVEL_THREE_DEPARTMENT_LIST);
 	}
 	protected boolean isAnalyzeLevelThreeDepartmentListEnabled(Map<String,Object> options){		 		
 		return LevelTwoDepartmentTokens.of(options).analyzeLevelThreeDepartmentListEnabled();
 	}
	
	protected boolean isSaveLevelThreeDepartmentListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelTwoDepartmentTokens.LEVEL_THREE_DEPARTMENT_LIST);
		
 	}
 	
		

	

	protected LevelTwoDepartmentMapper getLevelTwoDepartmentMapper(){
		return new LevelTwoDepartmentMapper();
	}

	
	
	protected LevelTwoDepartment extractLevelTwoDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LevelTwoDepartment levelTwoDepartment = loadSingleObject(accessKey, getLevelTwoDepartmentMapper());
			return levelTwoDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new LevelTwoDepartmentNotFoundException("LevelTwoDepartment("+accessKey+") is not found!");
		}

	}

	
	

	protected LevelTwoDepartment loadInternalLevelTwoDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelTwoDepartment levelTwoDepartment = extractLevelTwoDepartment(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(levelTwoDepartment, loadOptions);
 		}
 
		
		if(isExtractLevelThreeDepartmentListEnabled(loadOptions)){
	 		extractLevelThreeDepartmentList(levelTwoDepartment, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeLevelThreeDepartmentListEnabled(loadOptions)){
	 		analyzeLevelThreeDepartmentList(levelTwoDepartment, loadOptions);
 		}
 		
		
		return levelTwoDepartment;
		
	}

	 

 	protected LevelTwoDepartment extractBelongsTo(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options) throws Exception{

		if(levelTwoDepartment.getBelongsTo() == null){
			return levelTwoDepartment;
		}
		String belongsToId = levelTwoDepartment.getBelongsTo().getId();
		if( belongsToId == null){
			return levelTwoDepartment;
		}
		LevelOneDepartment belongsTo = getLevelOneDepartmentDAO().load(belongsToId,options);
		if(belongsTo != null){
			levelTwoDepartment.setBelongsTo(belongsTo);
		}
		
 		
 		return levelTwoDepartment;
 	}
 		
 
		
	protected void enhanceLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LevelTwoDepartment extractLevelThreeDepartmentList(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options){
		
		
		if(levelTwoDepartment == null){
			return null;
		}
		if(levelTwoDepartment.getId() == null){
			return levelTwoDepartment;
		}

		
		
		SmartList<LevelThreeDepartment> levelThreeDepartmentList = getLevelThreeDepartmentDAO().findLevelThreeDepartmentByBelongsTo(levelTwoDepartment.getId(),options);
		if(levelThreeDepartmentList != null){
			enhanceLevelThreeDepartmentList(levelThreeDepartmentList,options);
			levelTwoDepartment.setLevelThreeDepartmentList(levelThreeDepartmentList);
		}
		
		return levelTwoDepartment;
	
	}	
	
	protected LevelTwoDepartment analyzeLevelThreeDepartmentList(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options){
		
		
		if(levelTwoDepartment == null){
			return null;
		}
		if(levelTwoDepartment.getId() == null){
			return levelTwoDepartment;
		}

		
		
		SmartList<LevelThreeDepartment> levelThreeDepartmentList = levelTwoDepartment.getLevelThreeDepartmentList();
		if(levelThreeDepartmentList != null){
			getLevelThreeDepartmentDAO().analyzeLevelThreeDepartmentByBelongsTo(levelThreeDepartmentList, levelTwoDepartment.getId(), options);
			
		}
		
		return levelTwoDepartment;
	
	}	
	
		
		
  	
 	public SmartList<LevelTwoDepartment> findLevelTwoDepartmentByBelongsTo(String levelOneDepartmentId,Map<String,Object> options){
 	
  		SmartList<LevelTwoDepartment> resultList = queryWith(LevelTwoDepartmentTable.COLUMN_BELONGS_TO, levelOneDepartmentId, options, getLevelTwoDepartmentMapper());
		// analyzeLevelTwoDepartmentByBelongsTo(resultList, levelOneDepartmentId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LevelTwoDepartment> findLevelTwoDepartmentByBelongsTo(String levelOneDepartmentId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LevelTwoDepartment> resultList =  queryWithRange(LevelTwoDepartmentTable.COLUMN_BELONGS_TO, levelOneDepartmentId, options, getLevelTwoDepartmentMapper(), start, count);
 		//analyzeLevelTwoDepartmentByBelongsTo(resultList, levelOneDepartmentId, options);
 		return resultList;
 		
 	}
 	public void analyzeLevelTwoDepartmentByBelongsTo(SmartList<LevelTwoDepartment> resultList, String levelOneDepartmentId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countLevelTwoDepartmentByBelongsTo(String levelOneDepartmentId,Map<String,Object> options){

 		return countWith(LevelTwoDepartmentTable.COLUMN_BELONGS_TO, levelOneDepartmentId, options);
 	}
 	@Override
	public Map<String, Integer> countLevelTwoDepartmentByBelongsToIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LevelTwoDepartmentTable.COLUMN_BELONGS_TO, ids, options);
	}
 	
 	
		
		
		

	

	protected LevelTwoDepartment saveLevelTwoDepartment(LevelTwoDepartment  levelTwoDepartment){
		
		if(!levelTwoDepartment.isChanged()){
			return levelTwoDepartment;
		}
		

		String SQL=this.getSaveLevelTwoDepartmentSQL(levelTwoDepartment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelTwoDepartmentParameters(levelTwoDepartment);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		levelTwoDepartment.incVersion();
		return levelTwoDepartment;

	}
	public SmartList<LevelTwoDepartment> saveLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelTwoDepartmentList(levelTwoDepartmentList);

		batchLevelTwoDepartmentCreate((List<LevelTwoDepartment>)lists[CREATE_LIST_INDEX]);

		batchLevelTwoDepartmentUpdate((List<LevelTwoDepartment>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(LevelTwoDepartment levelTwoDepartment:levelTwoDepartmentList){
			if(levelTwoDepartment.isChanged()){
				levelTwoDepartment.incVersion();
			}


		}


		return levelTwoDepartmentList;
	}

	public SmartList<LevelTwoDepartment> removeLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList,Map<String,Object> options){


		super.removeList(levelTwoDepartmentList, options);

		return levelTwoDepartmentList;


	}

	protected List<Object[]> prepareLevelTwoDepartmentBatchCreateArgs(List<LevelTwoDepartment> levelTwoDepartmentList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelTwoDepartment levelTwoDepartment:levelTwoDepartmentList ){
			Object [] parameters = prepareLevelTwoDepartmentCreateParameters(levelTwoDepartment);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareLevelTwoDepartmentBatchUpdateArgs(List<LevelTwoDepartment> levelTwoDepartmentList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelTwoDepartment levelTwoDepartment:levelTwoDepartmentList ){
			if(!levelTwoDepartment.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelTwoDepartmentUpdateParameters(levelTwoDepartment);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchLevelTwoDepartmentCreate(List<LevelTwoDepartment> levelTwoDepartmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelTwoDepartmentBatchCreateArgs(levelTwoDepartmentList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchLevelTwoDepartmentUpdate(List<LevelTwoDepartment> levelTwoDepartmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelTwoDepartmentBatchUpdateArgs(levelTwoDepartmentList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitLevelTwoDepartmentList(List<LevelTwoDepartment> levelTwoDepartmentList){

		List<LevelTwoDepartment> levelTwoDepartmentCreateList=new ArrayList<LevelTwoDepartment>();
		List<LevelTwoDepartment> levelTwoDepartmentUpdateList=new ArrayList<LevelTwoDepartment>();

		for(LevelTwoDepartment levelTwoDepartment: levelTwoDepartmentList){
			if(isUpdateRequest(levelTwoDepartment)){
				levelTwoDepartmentUpdateList.add( levelTwoDepartment);
				continue;
			}
			levelTwoDepartmentCreateList.add(levelTwoDepartment);
		}

		return new Object[]{levelTwoDepartmentCreateList,levelTwoDepartmentUpdateList};
	}

	protected boolean isUpdateRequest(LevelTwoDepartment levelTwoDepartment){
 		return levelTwoDepartment.getVersion() > 0;
 	}
 	protected String getSaveLevelTwoDepartmentSQL(LevelTwoDepartment levelTwoDepartment){
 		if(isUpdateRequest(levelTwoDepartment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveLevelTwoDepartmentParameters(LevelTwoDepartment levelTwoDepartment){
 		if(isUpdateRequest(levelTwoDepartment) ){
 			return prepareLevelTwoDepartmentUpdateParameters(levelTwoDepartment);
 		}
 		return prepareLevelTwoDepartmentCreateParameters(levelTwoDepartment);
 	}
 	protected Object[] prepareLevelTwoDepartmentUpdateParameters(LevelTwoDepartment levelTwoDepartment){
 		Object[] parameters = new Object[7];
 
 		if(levelTwoDepartment.getBelongsTo() != null){
 			parameters[0] = levelTwoDepartment.getBelongsTo().getId();
 		}
 
 		
 		parameters[1] = levelTwoDepartment.getName();
 		
 		
 		parameters[2] = levelTwoDepartment.getDescription();
 		
 		
 		parameters[3] = levelTwoDepartment.getFounded();
 		
 		parameters[4] = levelTwoDepartment.nextVersion();
 		parameters[5] = levelTwoDepartment.getId();
 		parameters[6] = levelTwoDepartment.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareLevelTwoDepartmentCreateParameters(LevelTwoDepartment levelTwoDepartment){
		Object[] parameters = new Object[5];
        if(levelTwoDepartment.getId() == null){
          String newLevelTwoDepartmentId=getNextId();
          levelTwoDepartment.setId(newLevelTwoDepartmentId);
        }
		parameters[0] =  levelTwoDepartment.getId();
 
 		if(levelTwoDepartment.getBelongsTo() != null){
 			parameters[1] = levelTwoDepartment.getBelongsTo().getId();

 		}
 		
 		
 		parameters[2] = levelTwoDepartment.getName();
 		
 		
 		parameters[3] = levelTwoDepartment.getDescription();
 		
 		
 		parameters[4] = levelTwoDepartment.getFounded();
 		

 		return parameters;
 	}

	protected LevelTwoDepartment saveInternalLevelTwoDepartment(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options){

		saveLevelTwoDepartment(levelTwoDepartment);

 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(levelTwoDepartment, options);
 		}
 
		
		if(isSaveLevelThreeDepartmentListEnabled(options)){
	 		saveLevelThreeDepartmentList(levelTwoDepartment, options);
	 		//removeLevelThreeDepartmentList(levelTwoDepartment, options);
	 		//Not delete the record

 		}
		
		return levelTwoDepartment;

	}



	//======================================================================================
	

 	protected LevelTwoDepartment saveBelongsTo(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelTwoDepartment.getBelongsTo() == null){
 			return levelTwoDepartment;//do nothing when it is null
 		}

 		getLevelOneDepartmentDAO().save(levelTwoDepartment.getBelongsTo(),options);
 		return levelTwoDepartment;

 	}





 

	
	public LevelTwoDepartment planToRemoveLevelThreeDepartmentList(LevelTwoDepartment levelTwoDepartment, String levelThreeDepartmentIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelThreeDepartment.BELONGS_TO_PROPERTY, levelTwoDepartment.getId());
		key.put(LevelThreeDepartment.ID_PROPERTY, levelThreeDepartmentIds);

		SmartList<LevelThreeDepartment> externalLevelThreeDepartmentList = getLevelThreeDepartmentDAO().
				findLevelThreeDepartmentWithKey(key, options);
		if(externalLevelThreeDepartmentList == null){
			return levelTwoDepartment;
		}
		if(externalLevelThreeDepartmentList.isEmpty()){
			return levelTwoDepartment;
		}

		for(LevelThreeDepartment levelThreeDepartmentItem: externalLevelThreeDepartmentList){

			levelThreeDepartmentItem.clearFromAll();
		}


		SmartList<LevelThreeDepartment> levelThreeDepartmentList = levelTwoDepartment.getLevelThreeDepartmentList();
		levelThreeDepartmentList.addAllToRemoveList(externalLevelThreeDepartmentList);
		return levelTwoDepartment;

	}



		
	protected LevelTwoDepartment saveLevelThreeDepartmentList(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options){




		SmartList<LevelThreeDepartment> levelThreeDepartmentList = levelTwoDepartment.getLevelThreeDepartmentList();
		if(levelThreeDepartmentList == null){
			//null list means nothing
			return levelTwoDepartment;
		}
		SmartList<LevelThreeDepartment> mergedUpdateLevelThreeDepartmentList = new SmartList<LevelThreeDepartment>();


		mergedUpdateLevelThreeDepartmentList.addAll(levelThreeDepartmentList);
		if(levelThreeDepartmentList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLevelThreeDepartmentList.addAll(levelThreeDepartmentList.getToRemoveList());
			levelThreeDepartmentList.removeAll(levelThreeDepartmentList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getLevelThreeDepartmentDAO().saveLevelThreeDepartmentList(mergedUpdateLevelThreeDepartmentList,options);

		if(levelThreeDepartmentList.getToRemoveList() != null){
			levelThreeDepartmentList.removeAll(levelThreeDepartmentList.getToRemoveList());
		}


		return levelTwoDepartment;

	}

	protected LevelTwoDepartment removeLevelThreeDepartmentList(LevelTwoDepartment levelTwoDepartment, Map<String,Object> options){


		SmartList<LevelThreeDepartment> levelThreeDepartmentList = levelTwoDepartment.getLevelThreeDepartmentList();
		if(levelThreeDepartmentList == null){
			return levelTwoDepartment;
		}

		SmartList<LevelThreeDepartment> toRemoveLevelThreeDepartmentList = levelThreeDepartmentList.getToRemoveList();

		if(toRemoveLevelThreeDepartmentList == null){
			return levelTwoDepartment;
		}
		if(toRemoveLevelThreeDepartmentList.isEmpty()){
			return levelTwoDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getLevelThreeDepartmentDAO().removeLevelThreeDepartmentList(toRemoveLevelThreeDepartmentList,options);

		return levelTwoDepartment;

	}








		

	public LevelTwoDepartment present(LevelTwoDepartment levelTwoDepartment,Map<String, Object> options){
	
		presentLevelThreeDepartmentList(levelTwoDepartment,options);

		return levelTwoDepartment;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected LevelTwoDepartment presentLevelThreeDepartmentList(
			LevelTwoDepartment levelTwoDepartment,
			Map<String, Object> options) {

		SmartList<LevelThreeDepartment> levelThreeDepartmentList = levelTwoDepartment.getLevelThreeDepartmentList();		
				SmartList<LevelThreeDepartment> newList= presentSubList(levelTwoDepartment.getId(),
				levelThreeDepartmentList,
				options,
				getLevelThreeDepartmentDAO()::countLevelThreeDepartmentByBelongsTo,
				getLevelThreeDepartmentDAO()::findLevelThreeDepartmentByBelongsTo
				);

		
		levelTwoDepartment.setLevelThreeDepartmentList(newList);
		

		return levelTwoDepartment;
	}			
		

	
    public SmartList<LevelTwoDepartment> requestCandidateLevelTwoDepartmentForLevelThreeDepartment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LevelTwoDepartmentTable.COLUMN_BELONGS_TO, LevelTwoDepartmentTable.COLUMN_BELONGS_TO, filterKey, pageNo, pageSize, getLevelTwoDepartmentMapper());
    }
		

	protected String getTableName(){
		return LevelTwoDepartmentTable.TABLE_NAME;
	}



	public void enhanceList(List<LevelTwoDepartment> levelTwoDepartmentList) {
		this.enhanceListInternal(levelTwoDepartmentList, this.getLevelTwoDepartmentMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:LevelThreeDepartment的belongsTo的LevelThreeDepartmentList
	public SmartList<LevelThreeDepartment> loadOurLevelThreeDepartmentList(RetailscmUserContext userContext, List<LevelTwoDepartment> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelThreeDepartment.BELONGS_TO_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<LevelThreeDepartment> loadedObjs = userContext.getDAOGroup().getLevelThreeDepartmentDAO().findLevelThreeDepartmentWithKey(key, options);
		Map<String, List<LevelThreeDepartment>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBelongsTo().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<LevelThreeDepartment> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<LevelThreeDepartment> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setLevelThreeDepartmentList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LevelTwoDepartment> levelTwoDepartmentList = ownerEntity.collectRefsWithType(LevelTwoDepartment.INTERNAL_TYPE);
		this.enhanceList(levelTwoDepartmentList);

	}

	@Override
	public SmartList<LevelTwoDepartment> findLevelTwoDepartmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getLevelTwoDepartmentMapper());

	}
	@Override
	public int countLevelTwoDepartmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countLevelTwoDepartmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<LevelTwoDepartment> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLevelTwoDepartmentMapper());
	}

  @Override
  public Stream<LevelTwoDepartment> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getLevelTwoDepartmentMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateLevelTwoDepartment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateLevelTwoDepartment result = new CandidateLevelTwoDepartment();
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


