
package com.doublechaintech.retailscm.candidateelement;

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


import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;

import com.doublechaintech.retailscm.candidatecontainer.CandidateContainerDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class CandidateElementJDBCTemplateDAO extends RetailscmBaseDAOImpl implements CandidateElementDAO{

	protected CandidateContainerDAO candidateContainerDAO;
	public void setCandidateContainerDAO(CandidateContainerDAO candidateContainerDAO){

 		if(candidateContainerDAO == null){
 			throw new IllegalStateException("Do not try to set candidateContainerDAO to null.");
 		}
	 	this.candidateContainerDAO = candidateContainerDAO;
 	}
 	public CandidateContainerDAO getCandidateContainerDAO(){
 		if(this.candidateContainerDAO == null){
 			throw new IllegalStateException("The candidateContainerDAO is not configured yet, please config it some where.");
 		}

	 	return this.candidateContainerDAO;
 	}



	/*
	protected CandidateElement load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCandidateElement(accessKey, options);
	}
	*/

	public SmartList<CandidateElement> loadAll() {
	    return this.loadAll(getCandidateElementMapper());
	}

  public Stream<CandidateElement> loadAllAsStream() {
      return this.loadAllAsStream(getCandidateElementMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public CandidateElement load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCandidateElement(CandidateElementTable.withId(id), options);
	}

	

	public CandidateElement save(CandidateElement candidateElement,Map<String,Object> options){

		String methodName="save(CandidateElement candidateElement,Map<String,Object> options)";

		assertMethodArgumentNotNull(candidateElement, methodName, "candidateElement");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalCandidateElement(candidateElement,options);
	}
	public CandidateElement clone(String candidateElementId, Map<String,Object> options) throws Exception{

		return clone(CandidateElementTable.withId(candidateElementId),options);
	}

	protected CandidateElement clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String candidateElementId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		CandidateElement newCandidateElement = loadInternalCandidateElement(accessKey, options);
		newCandidateElement.setVersion(0);
		
		


		saveInternalCandidateElement(newCandidateElement,options);

		return newCandidateElement;
	}

	



	protected void throwIfHasException(String candidateElementId,int version,int count) throws Exception{
		if (count == 1) {
			throw new CandidateElementVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CandidateElementNotFoundException(
					"The " + this.getTableName() + "(" + candidateElementId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String candidateElementId, int version) throws Exception{

		String methodName="delete(String candidateElementId, int version)";
		assertMethodArgumentNotNull(candidateElementId, methodName, "candidateElementId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{candidateElementId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(candidateElementId,version);
		}


	}






	public CandidateElement disconnectFromAll(String candidateElementId, int version) throws Exception{


		CandidateElement candidateElement = loadInternalCandidateElement(CandidateElementTable.withId(candidateElementId), emptyOptions());
		candidateElement.clearFromAll();
		this.saveCandidateElement(candidateElement);
		return candidateElement;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return CandidateElementTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "candidate_element";
	}
	@Override
	protected String getBeanName() {

		return "candidateElement";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return CandidateElementTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractContainerEnabled(Map<String,Object> options){

	 	return checkOptions(options, CandidateElementTokens.CONTAINER);
 	}

 	protected boolean isSaveContainerEnabled(Map<String,Object> options){

 		return checkOptions(options, CandidateElementTokens.CONTAINER);
 	}



 
		

	

	protected CandidateElementMapper getCandidateElementMapper(){
		return new CandidateElementMapper();
	}



	protected CandidateElement extractCandidateElement(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			CandidateElement candidateElement = loadSingleObject(accessKey, getCandidateElementMapper());
			return candidateElement;
		}catch(EmptyResultDataAccessException e){
			throw new CandidateElementNotFoundException("CandidateElement("+accessKey+") is not found!");
		}

	}




	protected CandidateElement loadInternalCandidateElement(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		CandidateElement candidateElement = extractCandidateElement(accessKey, loadOptions);

 		if(isExtractContainerEnabled(loadOptions)){
	 		extractContainer(candidateElement, loadOptions);
 		}
 
		
		return candidateElement;

	}

	

 	protected CandidateElement extractContainer(CandidateElement candidateElement, Map<String,Object> options) throws Exception{
  

		if(candidateElement.getContainer() == null){
			return candidateElement;
		}
		String containerId = candidateElement.getContainer().getId();
		if( containerId == null){
			return candidateElement;
		}
		CandidateContainer container = getCandidateContainerDAO().load(containerId,options);
		if(container != null){
			candidateElement.setContainer(container);
		}


 		return candidateElement;
 	}

 
		

 
 	public SmartList<CandidateElement> findCandidateElementByContainer(String candidateContainerId,Map<String,Object> options){

  		SmartList<CandidateElement> resultList = queryWith(CandidateElementTable.COLUMN_CONTAINER, candidateContainerId, options, getCandidateElementMapper());
		// analyzeCandidateElementByContainer(resultList, candidateContainerId, options);
		return resultList;
 	}
 	

 	public SmartList<CandidateElement> findCandidateElementByContainer(String candidateContainerId, int start, int count,Map<String,Object> options){

 		SmartList<CandidateElement> resultList =  queryWithRange(CandidateElementTable.COLUMN_CONTAINER, candidateContainerId, options, getCandidateElementMapper(), start, count);
 		//analyzeCandidateElementByContainer(resultList, candidateContainerId, options);
 		return resultList;

 	}
 	public void analyzeCandidateElementByContainer(SmartList<CandidateElement> resultList, String candidateContainerId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countCandidateElementByContainer(String candidateContainerId,Map<String,Object> options){

 		return countWith(CandidateElementTable.COLUMN_CONTAINER, candidateContainerId, options);
 	}
 	@Override
	public Map<String, Integer> countCandidateElementByContainerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CandidateElementTable.COLUMN_CONTAINER, ids, options);
	}

 




	

	protected CandidateElement saveCandidateElement(CandidateElement  candidateElement){
    

		
		if(!candidateElement.isChanged()){
			return candidateElement;
		}
		

    Beans.dbUtil().cacheCleanUp(candidateElement);
		String SQL=this.getSaveCandidateElementSQL(candidateElement);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCandidateElementParameters(candidateElement);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		candidateElement.incVersion();
		candidateElement.afterSave();
		return candidateElement;

	}
	public SmartList<CandidateElement> saveCandidateElementList(SmartList<CandidateElement> candidateElementList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCandidateElementList(candidateElementList);

		batchCandidateElementCreate((List<CandidateElement>)lists[CREATE_LIST_INDEX]);

		batchCandidateElementUpdate((List<CandidateElement>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(CandidateElement candidateElement:candidateElementList){
			if(candidateElement.isChanged()){
				candidateElement.incVersion();
				candidateElement.afterSave();
			}


		}


		return candidateElementList;
	}

	public SmartList<CandidateElement> removeCandidateElementList(SmartList<CandidateElement> candidateElementList,Map<String,Object> options){


		super.removeList(candidateElementList, options);

		return candidateElementList;


	}

	protected List<Object[]> prepareCandidateElementBatchCreateArgs(List<CandidateElement> candidateElementList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CandidateElement candidateElement:candidateElementList ){
			Object [] parameters = prepareCandidateElementCreateParameters(candidateElement);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareCandidateElementBatchUpdateArgs(List<CandidateElement> candidateElementList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CandidateElement candidateElement:candidateElementList ){
			if(!candidateElement.isChanged()){
				continue;
			}
			Object [] parameters = prepareCandidateElementUpdateParameters(candidateElement);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchCandidateElementCreate(List<CandidateElement> candidateElementList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCandidateElementBatchCreateArgs(candidateElementList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchCandidateElementUpdate(List<CandidateElement> candidateElementList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCandidateElementBatchUpdateArgs(candidateElementList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitCandidateElementList(List<CandidateElement> candidateElementList){

		List<CandidateElement> candidateElementCreateList=new ArrayList<CandidateElement>();
		List<CandidateElement> candidateElementUpdateList=new ArrayList<CandidateElement>();

		for(CandidateElement candidateElement: candidateElementList){
			if(isUpdateRequest(candidateElement)){
				candidateElementUpdateList.add( candidateElement);
				continue;
			}
			candidateElementCreateList.add(candidateElement);
		}

		return new Object[]{candidateElementCreateList,candidateElementUpdateList};
	}

	protected boolean isUpdateRequest(CandidateElement candidateElement){
 		return candidateElement.getVersion() > 0;
 	}
 	protected String getSaveCandidateElementSQL(CandidateElement candidateElement){
 		if(isUpdateRequest(candidateElement)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveCandidateElementParameters(CandidateElement candidateElement){
 		if(isUpdateRequest(candidateElement) ){
 			return prepareCandidateElementUpdateParameters(candidateElement);
 		}
 		return prepareCandidateElementCreateParameters(candidateElement);
 	}
 	protected Object[] prepareCandidateElementUpdateParameters(CandidateElement candidateElement){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = candidateElement.getName();
 		
 		parameters[1] = candidateElement.getType();
 		
 		parameters[2] = candidateElement.getImage();
 		
 		if(candidateElement.getContainer() != null){
 			parameters[3] = candidateElement.getContainer().getId();
 		}
    
 		parameters[4] = candidateElement.nextVersion();
 		parameters[5] = candidateElement.getId();
 		parameters[6] = candidateElement.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareCandidateElementCreateParameters(CandidateElement candidateElement){
		Object[] parameters = new Object[5];
        if(candidateElement.getId() == null){
          String newCandidateElementId=getNextId();
          candidateElement.setId(newCandidateElementId);
        }
		parameters[0] =  candidateElement.getId();
 
 		parameters[1] = candidateElement.getName();
 		
 		parameters[2] = candidateElement.getType();
 		
 		parameters[3] = candidateElement.getImage();
 		
 		if(candidateElement.getContainer() != null){
 			parameters[4] = candidateElement.getContainer().getId();
 		}
 		

 		return parameters;
 	}

	protected CandidateElement saveInternalCandidateElement(CandidateElement candidateElement, Map<String,Object> options){

 		if(isSaveContainerEnabled(options)){
	 		saveContainer(candidateElement, options);
 		}
 
   saveCandidateElement(candidateElement);
		
		return candidateElement;

	}



	//======================================================================================
	

 	protected CandidateElement saveContainer(CandidateElement candidateElement, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(candidateElement.getContainer() == null){
 			return candidateElement;//do nothing when it is null
 		}

 		getCandidateContainerDAO().save(candidateElement.getContainer(),options);
 		return candidateElement;

 	}
 

	

		

	public CandidateElement present(CandidateElement candidateElement,Map<String, Object> options){


		return candidateElement;

	}
		

	

	protected String getTableName(){
		return CandidateElementTable.TABLE_NAME;
	}



	public void enhanceList(List<CandidateElement> candidateElementList) {
		this.enhanceListInternal(candidateElementList, this.getCandidateElementMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<CandidateElement> candidateElementList = ownerEntity.collectRefsWithType(CandidateElement.INTERNAL_TYPE);
		this.enhanceList(candidateElementList);

	}

	@Override
	public SmartList<CandidateElement> findCandidateElementWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getCandidateElementMapper());

	}
	@Override
	public int countCandidateElementWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countCandidateElementWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<CandidateElement> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getCandidateElementMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<CandidateElement> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getCandidateElementMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateCandidateElement executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateCandidateElement result = new CandidateCandidateElement();
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
  public List<CandidateElement> search(CandidateElementRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected CandidateElementMapper mapper() {
    return getCandidateElementMapper();
  }
}


