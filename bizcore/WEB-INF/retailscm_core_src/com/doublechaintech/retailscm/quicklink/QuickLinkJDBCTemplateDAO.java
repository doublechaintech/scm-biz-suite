
package com.doublechaintech.retailscm.quicklink;

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


import com.doublechaintech.retailscm.userapp.UserApp;

import com.doublechaintech.retailscm.userapp.UserAppDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class QuickLinkJDBCTemplateDAO extends RetailscmBaseDAOImpl implements QuickLinkDAO{

	protected UserAppDAO userAppDAO;
	public void setUserAppDAO(UserAppDAO userAppDAO){
 	
 		if(userAppDAO == null){
 			throw new IllegalStateException("Do not try to set userAppDAO to null.");
 		}
	 	this.userAppDAO = userAppDAO;
 	}
 	public UserAppDAO getUserAppDAO(){
 		if(this.userAppDAO == null){
 			throw new IllegalStateException("The userAppDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userAppDAO;
 	}	


	/*
	protected QuickLink load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalQuickLink(accessKey, options);
	}
	*/

	public SmartList<QuickLink> loadAll() {
	    return this.loadAll(getQuickLinkMapper());
	}

  public Stream<QuickLink> loadAllAsStream() {
      return this.loadAllAsStream(getQuickLinkMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public QuickLink load(String id,Map<String,Object> options) throws Exception{
		return loadInternalQuickLink(QuickLinkTable.withId(id), options);
	}

	

	public QuickLink save(QuickLink quickLink,Map<String,Object> options){

		String methodName="save(QuickLink quickLink,Map<String,Object> options)";

		assertMethodArgumentNotNull(quickLink, methodName, "quickLink");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalQuickLink(quickLink,options);
	}
	public QuickLink clone(String quickLinkId, Map<String,Object> options) throws Exception{

		return clone(QuickLinkTable.withId(quickLinkId),options);
	}

	protected QuickLink clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String quickLinkId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		QuickLink newQuickLink = loadInternalQuickLink(accessKey, options);
		newQuickLink.setVersion(0);
		
		


		saveInternalQuickLink(newQuickLink,options);

		return newQuickLink;
	}

	



	protected void throwIfHasException(String quickLinkId,int version,int count) throws Exception{
		if (count == 1) {
			throw new QuickLinkVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new QuickLinkNotFoundException(
					"The " + this.getTableName() + "(" + quickLinkId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String quickLinkId, int version) throws Exception{

		String methodName="delete(String quickLinkId, int version)";
		assertMethodArgumentNotNull(quickLinkId, methodName, "quickLinkId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{quickLinkId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(quickLinkId,version);
		}


	}






	public QuickLink disconnectFromAll(String quickLinkId, int version) throws Exception{


		QuickLink quickLink = loadInternalQuickLink(QuickLinkTable.withId(quickLinkId), emptyOptions());
		quickLink.clearFromAll();
		this.saveQuickLink(quickLink);
		return quickLink;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return QuickLinkTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "quick_link";
	}
	@Override
	protected String getBeanName() {

		return "quickLink";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return QuickLinkTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractAppEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, QuickLinkTokens.APP);
 	}

 	protected boolean isSaveAppEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, QuickLinkTokens.APP);
 	}
 	

 	
 
		

	

	protected QuickLinkMapper getQuickLinkMapper(){
		return new QuickLinkMapper();
	}

	
	
	protected QuickLink extractQuickLink(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			QuickLink quickLink = loadSingleObject(accessKey, getQuickLinkMapper());
			return quickLink;
		}catch(EmptyResultDataAccessException e){
			throw new QuickLinkNotFoundException("QuickLink("+accessKey+") is not found!");
		}

	}

	
	

	protected QuickLink loadInternalQuickLink(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		QuickLink quickLink = extractQuickLink(accessKey, loadOptions);
 	
 		if(isExtractAppEnabled(loadOptions)){
	 		extractApp(quickLink, loadOptions);
 		}
 
		
		return quickLink;
		
	}

	 

 	protected QuickLink extractApp(QuickLink quickLink, Map<String,Object> options) throws Exception{

		if(quickLink.getApp() == null){
			return quickLink;
		}
		String appId = quickLink.getApp().getId();
		if( appId == null){
			return quickLink;
		}
		UserApp app = getUserAppDAO().load(appId,options);
		if(app != null){
			quickLink.setApp(app);
		}
		
 		
 		return quickLink;
 	}
 		
 
		
		
  	
 	public SmartList<QuickLink> findQuickLinkByApp(String userAppId,Map<String,Object> options){
 	
  		SmartList<QuickLink> resultList = queryWith(QuickLinkTable.COLUMN_APP, userAppId, options, getQuickLinkMapper());
		// analyzeQuickLinkByApp(resultList, userAppId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<QuickLink> findQuickLinkByApp(String userAppId, int start, int count,Map<String,Object> options){
 		
 		SmartList<QuickLink> resultList =  queryWithRange(QuickLinkTable.COLUMN_APP, userAppId, options, getQuickLinkMapper(), start, count);
 		//analyzeQuickLinkByApp(resultList, userAppId, options);
 		return resultList;
 		
 	}
 	public void analyzeQuickLinkByApp(SmartList<QuickLink> resultList, String userAppId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(QuickLink.APP_PROPERTY, userAppId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//QuickLink.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("快速链接");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(QuickLink.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(QuickLink.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countQuickLinkByApp(String userAppId,Map<String,Object> options){

 		return countWith(QuickLinkTable.COLUMN_APP, userAppId, options);
 	}
 	@Override
	public Map<String, Integer> countQuickLinkByAppIds(String[] ids, Map<String, Object> options) {
		return countWithIds(QuickLinkTable.COLUMN_APP, ids, options);
	}
 	
 	
		
		
		

	

	protected QuickLink saveQuickLink(QuickLink  quickLink){
		
		if(!quickLink.isChanged()){
			return quickLink;
		}
		

		String SQL=this.getSaveQuickLinkSQL(quickLink);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveQuickLinkParameters(quickLink);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		quickLink.incVersion();
		return quickLink;

	}
	public SmartList<QuickLink> saveQuickLinkList(SmartList<QuickLink> quickLinkList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitQuickLinkList(quickLinkList);

		batchQuickLinkCreate((List<QuickLink>)lists[CREATE_LIST_INDEX]);

		batchQuickLinkUpdate((List<QuickLink>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(QuickLink quickLink:quickLinkList){
			if(quickLink.isChanged()){
				quickLink.incVersion();
			}


		}


		return quickLinkList;
	}

	public SmartList<QuickLink> removeQuickLinkList(SmartList<QuickLink> quickLinkList,Map<String,Object> options){


		super.removeList(quickLinkList, options);

		return quickLinkList;


	}

	protected List<Object[]> prepareQuickLinkBatchCreateArgs(List<QuickLink> quickLinkList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(QuickLink quickLink:quickLinkList ){
			Object [] parameters = prepareQuickLinkCreateParameters(quickLink);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareQuickLinkBatchUpdateArgs(List<QuickLink> quickLinkList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(QuickLink quickLink:quickLinkList ){
			if(!quickLink.isChanged()){
				continue;
			}
			Object [] parameters = prepareQuickLinkUpdateParameters(quickLink);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchQuickLinkCreate(List<QuickLink> quickLinkList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareQuickLinkBatchCreateArgs(quickLinkList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchQuickLinkUpdate(List<QuickLink> quickLinkList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareQuickLinkBatchUpdateArgs(quickLinkList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitQuickLinkList(List<QuickLink> quickLinkList){

		List<QuickLink> quickLinkCreateList=new ArrayList<QuickLink>();
		List<QuickLink> quickLinkUpdateList=new ArrayList<QuickLink>();

		for(QuickLink quickLink: quickLinkList){
			if(isUpdateRequest(quickLink)){
				quickLinkUpdateList.add( quickLink);
				continue;
			}
			quickLinkCreateList.add(quickLink);
		}

		return new Object[]{quickLinkCreateList,quickLinkUpdateList};
	}

	protected boolean isUpdateRequest(QuickLink quickLink){
 		return quickLink.getVersion() > 0;
 	}
 	protected String getSaveQuickLinkSQL(QuickLink quickLink){
 		if(isUpdateRequest(quickLink)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveQuickLinkParameters(QuickLink quickLink){
 		if(isUpdateRequest(quickLink) ){
 			return prepareQuickLinkUpdateParameters(quickLink);
 		}
 		return prepareQuickLinkCreateParameters(quickLink);
 	}
 	protected Object[] prepareQuickLinkUpdateParameters(QuickLink quickLink){
 		Object[] parameters = new Object[9];
 
 		
 		parameters[0] = quickLink.getName();
 		
 		
 		parameters[1] = quickLink.getIcon();
 		
 		
 		parameters[2] = quickLink.getImagePath();
 		
 		
 		parameters[3] = quickLink.getLinkTarget();
 		
 		
 		parameters[4] = quickLink.getCreateTime();
 		
 		if(quickLink.getApp() != null){
 			parameters[5] = quickLink.getApp().getId();
 		}
 
 		parameters[6] = quickLink.nextVersion();
 		parameters[7] = quickLink.getId();
 		parameters[8] = quickLink.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareQuickLinkCreateParameters(QuickLink quickLink){
		Object[] parameters = new Object[7];
        if(quickLink.getId() == null){
          String newQuickLinkId=getNextId();
          quickLink.setId(newQuickLinkId);
        }
		parameters[0] =  quickLink.getId();
 
 		
 		parameters[1] = quickLink.getName();
 		
 		
 		parameters[2] = quickLink.getIcon();
 		
 		
 		parameters[3] = quickLink.getImagePath();
 		
 		
 		parameters[4] = quickLink.getLinkTarget();
 		
 		
 		parameters[5] = quickLink.getCreateTime();
 		
 		if(quickLink.getApp() != null){
 			parameters[6] = quickLink.getApp().getId();

 		}
 		

 		return parameters;
 	}

	protected QuickLink saveInternalQuickLink(QuickLink quickLink, Map<String,Object> options){

		saveQuickLink(quickLink);

 		if(isSaveAppEnabled(options)){
	 		saveApp(quickLink, options);
 		}
 
		
		return quickLink;

	}



	//======================================================================================
	

 	protected QuickLink saveApp(QuickLink quickLink, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(quickLink.getApp() == null){
 			return quickLink;//do nothing when it is null
 		}

 		getUserAppDAO().save(quickLink.getApp(),options);
 		return quickLink;

 	}





 

	

		

	public QuickLink present(QuickLink quickLink,Map<String, Object> options){
	

		return quickLink;
	
	}
		

	

	protected String getTableName(){
		return QuickLinkTable.TABLE_NAME;
	}



	public void enhanceList(List<QuickLink> quickLinkList) {
		this.enhanceListInternal(quickLinkList, this.getQuickLinkMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<QuickLink> quickLinkList = ownerEntity.collectRefsWithType(QuickLink.INTERNAL_TYPE);
		this.enhanceList(quickLinkList);

	}

	@Override
	public SmartList<QuickLink> findQuickLinkWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getQuickLinkMapper());

	}
	@Override
	public int countQuickLinkWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countQuickLinkWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<QuickLink> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getQuickLinkMapper());
	}

  @Override
  public Stream<QuickLink> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getQuickLinkMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateQuickLink executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateQuickLink result = new CandidateQuickLink();
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


