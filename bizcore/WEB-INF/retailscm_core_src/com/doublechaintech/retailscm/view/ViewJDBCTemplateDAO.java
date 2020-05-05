
package com.doublechaintech.retailscm.view;

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






import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ViewJDBCTemplateDAO extends RetailscmBaseDAOImpl implements ViewDAO{

	
	/*
	protected View load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalView(accessKey, options);
	}
	*/
	
	public SmartList<View> loadAll() {
	    return this.loadAll(getViewMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public View load(String id,Map<String,Object> options) throws Exception{
		return loadInternalView(ViewTable.withId(id), options);
	}
	
	
	
	public View save(View view,Map<String,Object> options){
		
		String methodName="save(View view,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(view, methodName, "view");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalView(view,options);
	}
	public View clone(String viewId, Map<String,Object> options) throws Exception{
	
		return clone(ViewTable.withId(viewId),options);
	}
	
	protected View clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String viewId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		View newView = loadInternalView(accessKey, options);
		newView.setVersion(0);
		
		

		
		saveInternalView(newView,options);
		
		return newView;
	}
	
	
	
	

	protected void throwIfHasException(String viewId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ViewVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ViewNotFoundException(
					"The " + this.getTableName() + "(" + viewId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String viewId, int version) throws Exception{
	
		String methodName="delete(String viewId, int version)";
		assertMethodArgumentNotNull(viewId, methodName, "viewId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{viewId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(viewId,version);
		}
		
	
	}
	
	
	
	
	

	public View disconnectFromAll(String viewId, int version) throws Exception{
	
		
		View view = loadInternalView(ViewTable.withId(viewId), emptyOptions());
		view.clearFromAll();
		this.saveView(view);
		return view;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ViewTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "view";
	}
	@Override
	protected String getBeanName() {
		
		return "view";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ViewTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected ViewMapper getViewMapper(){
		return new ViewMapper();
	}

	
	
	protected View extractView(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			View view = loadSingleObject(accessKey, getViewMapper());
			return view;
		}catch(EmptyResultDataAccessException e){
			throw new ViewNotFoundException("View("+accessKey+") is not found!");
		}

	}

	
	

	protected View loadInternalView(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		View view = extractView(accessKey, loadOptions);

		
		return view;
		
	}

	
		
		
 	
		
		
		

	

	protected View saveView(View  view){
		
		if(!view.isChanged()){
			return view;
		}
		
		
		String SQL=this.getSaveViewSQL(view);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveViewParameters(view);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		view.incVersion();
		return view;
	
	}
	public SmartList<View> saveViewList(SmartList<View> viewList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitViewList(viewList);
		
		batchViewCreate((List<View>)lists[CREATE_LIST_INDEX]);
		
		batchViewUpdate((List<View>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(View view:viewList){
			if(view.isChanged()){
				view.incVersion();
			}
			
		
		}
		
		
		return viewList;
	}

	public SmartList<View> removeViewList(SmartList<View> viewList,Map<String,Object> options){
		
		
		super.removeList(viewList, options);
		
		return viewList;
		
		
	}
	
	protected List<Object[]> prepareViewBatchCreateArgs(List<View> viewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(View view:viewList ){
			Object [] parameters = prepareViewCreateParameters(view);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareViewBatchUpdateArgs(List<View> viewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(View view:viewList ){
			if(!view.isChanged()){
				continue;
			}
			Object [] parameters = prepareViewUpdateParameters(view);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchViewCreate(List<View> viewList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareViewBatchCreateArgs(viewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchViewUpdate(List<View> viewList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareViewBatchUpdateArgs(viewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitViewList(List<View> viewList){
		
		List<View> viewCreateList=new ArrayList<View>();
		List<View> viewUpdateList=new ArrayList<View>();
		
		for(View view: viewList){
			if(isUpdateRequest(view)){
				viewUpdateList.add( view);
				continue;
			}
			viewCreateList.add(view);
		}
		
		return new Object[]{viewCreateList,viewUpdateList};
	}
	
	protected boolean isUpdateRequest(View view){
 		return view.getVersion() > 0;
 	}
 	protected String getSaveViewSQL(View view){
 		if(isUpdateRequest(view)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveViewParameters(View view){
 		if(isUpdateRequest(view) ){
 			return prepareViewUpdateParameters(view);
 		}
 		return prepareViewCreateParameters(view);
 	}
 	protected Object[] prepareViewUpdateParameters(View view){
 		Object[] parameters = new Object[6];
 
 		
 		parameters[0] = view.getWho();
 		
 		
 		parameters[1] = view.getAssessment();
 		
 		
 		parameters[2] = view.getInterviewTime();
 				
 		parameters[3] = view.nextVersion();
 		parameters[4] = view.getId();
 		parameters[5] = view.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareViewCreateParameters(View view){
		Object[] parameters = new Object[4];
		String newViewId=getNextId();
		view.setId(newViewId);
		parameters[0] =  view.getId();
 
 		
 		parameters[1] = view.getWho();
 		
 		
 		parameters[2] = view.getAssessment();
 		
 		
 		parameters[3] = view.getInterviewTime();
 				
 				
 		return parameters;
 	}
 	
	protected View saveInternalView(View view, Map<String,Object> options){
		
		saveView(view);

		
		return view;
		
	}
	
	
	
	//======================================================================================
	

	

		

	public View present(View view,Map<String, Object> options){
	

		return view;
	
	}
		

	

	protected String getTableName(){
		return ViewTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<View> viewList) {		
		this.enhanceListInternal(viewList, this.getViewMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<View> viewList = ownerEntity.collectRefsWithType(View.INTERNAL_TYPE);
		this.enhanceList(viewList);
		
	}
	
	@Override
	public SmartList<View> findViewWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getViewMapper());

	}
	@Override
	public int countViewWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countViewWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<View> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getViewMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateView executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateView result = new CandidateView();
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
	
	
    
	public Map<String, Integer> countBySql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			return new HashMap<>();
		}
		List<Map<String, Object>> result = this.getJdbcTemplateObject().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = (String) data.get("id");
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplateObject().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplateObject().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplateObject().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplateObject().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplateObject().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplateObject().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplateObject().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplateObject().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplateObject().execute(sql);
	}


}


