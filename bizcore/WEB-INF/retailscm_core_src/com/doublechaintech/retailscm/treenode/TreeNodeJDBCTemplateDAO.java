
package com.doublechaintech.retailscm.treenode;

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


public class TreeNodeJDBCTemplateDAO extends RetailscmBaseDAOImpl implements TreeNodeDAO{

	
	/*
	protected TreeNode load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTreeNode(accessKey, options);
	}
	*/
	
	public SmartList<TreeNode> loadAll() {
	    return this.loadAll(getTreeNodeMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public TreeNode load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTreeNode(TreeNodeTable.withId(id), options);
	}
	
	
	
	public TreeNode save(TreeNode treeNode,Map<String,Object> options){
		
		String methodName="save(TreeNode treeNode,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(treeNode, methodName, "treeNode");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTreeNode(treeNode,options);
	}
	public TreeNode clone(String treeNodeId, Map<String,Object> options) throws Exception{
	
		return clone(TreeNodeTable.withId(treeNodeId),options);
	}
	
	protected TreeNode clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String treeNodeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TreeNode newTreeNode = loadInternalTreeNode(accessKey, options);
		newTreeNode.setVersion(0);
		
		

		
		saveInternalTreeNode(newTreeNode,options);
		
		return newTreeNode;
	}
	
	
	
	

	protected void throwIfHasException(String treeNodeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TreeNodeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TreeNodeNotFoundException(
					"The " + this.getTableName() + "(" + treeNodeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String treeNodeId, int version) throws Exception{
	
		String methodName="delete(String treeNodeId, int version)";
		assertMethodArgumentNotNull(treeNodeId, methodName, "treeNodeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{treeNodeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(treeNodeId,version);
		}
		
	
	}
	
	
	
	
	

	public TreeNode disconnectFromAll(String treeNodeId, int version) throws Exception{
	
		
		TreeNode treeNode = loadInternalTreeNode(TreeNodeTable.withId(treeNodeId), emptyOptions());
		treeNode.clearFromAll();
		this.saveTreeNode(treeNode);
		return treeNode;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TreeNodeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "tree_node";
	}
	@Override
	protected String getBeanName() {
		
		return "treeNode";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TreeNodeTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected TreeNodeMapper getTreeNodeMapper(){
		return new TreeNodeMapper();
	}

	
	
	protected TreeNode extractTreeNode(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TreeNode treeNode = loadSingleObject(accessKey, getTreeNodeMapper());
			return treeNode;
		}catch(EmptyResultDataAccessException e){
			throw new TreeNodeNotFoundException("TreeNode("+accessKey+") is not found!");
		}

	}

	
	

	protected TreeNode loadInternalTreeNode(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TreeNode treeNode = extractTreeNode(accessKey, loadOptions);

		
		return treeNode;
		
	}

	
		
		
 	
		
		
		

	

	protected TreeNode saveTreeNode(TreeNode  treeNode){
		
		if(!treeNode.isChanged()){
			return treeNode;
		}
		
		
		String SQL=this.getSaveTreeNodeSQL(treeNode);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTreeNodeParameters(treeNode);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		treeNode.incVersion();
		return treeNode;
	
	}
	public SmartList<TreeNode> saveTreeNodeList(SmartList<TreeNode> treeNodeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTreeNodeList(treeNodeList);
		
		batchTreeNodeCreate((List<TreeNode>)lists[CREATE_LIST_INDEX]);
		
		batchTreeNodeUpdate((List<TreeNode>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TreeNode treeNode:treeNodeList){
			if(treeNode.isChanged()){
				treeNode.incVersion();
			}
			
		
		}
		
		
		return treeNodeList;
	}

	public SmartList<TreeNode> removeTreeNodeList(SmartList<TreeNode> treeNodeList,Map<String,Object> options){
		
		
		super.removeList(treeNodeList, options);
		
		return treeNodeList;
		
		
	}
	
	protected List<Object[]> prepareTreeNodeBatchCreateArgs(List<TreeNode> treeNodeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TreeNode treeNode:treeNodeList ){
			Object [] parameters = prepareTreeNodeCreateParameters(treeNode);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTreeNodeBatchUpdateArgs(List<TreeNode> treeNodeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TreeNode treeNode:treeNodeList ){
			if(!treeNode.isChanged()){
				continue;
			}
			Object [] parameters = prepareTreeNodeUpdateParameters(treeNode);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTreeNodeCreate(List<TreeNode> treeNodeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTreeNodeBatchCreateArgs(treeNodeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTreeNodeUpdate(List<TreeNode> treeNodeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTreeNodeBatchUpdateArgs(treeNodeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTreeNodeList(List<TreeNode> treeNodeList){
		
		List<TreeNode> treeNodeCreateList=new ArrayList<TreeNode>();
		List<TreeNode> treeNodeUpdateList=new ArrayList<TreeNode>();
		
		for(TreeNode treeNode: treeNodeList){
			if(isUpdateRequest(treeNode)){
				treeNodeUpdateList.add( treeNode);
				continue;
			}
			treeNodeCreateList.add(treeNode);
		}
		
		return new Object[]{treeNodeCreateList,treeNodeUpdateList};
	}
	
	protected boolean isUpdateRequest(TreeNode treeNode){
 		return treeNode.getVersion() > 0;
 	}
 	protected String getSaveTreeNodeSQL(TreeNode treeNode){
 		if(isUpdateRequest(treeNode)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTreeNodeParameters(TreeNode treeNode){
 		if(isUpdateRequest(treeNode) ){
 			return prepareTreeNodeUpdateParameters(treeNode);
 		}
 		return prepareTreeNodeCreateParameters(treeNode);
 	}
 	protected Object[] prepareTreeNodeUpdateParameters(TreeNode treeNode){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = treeNode.getNodeId();
 		
 		
 		parameters[1] = treeNode.getNodeType();
 		
 		
 		parameters[2] = treeNode.getLeftValue();
 		
 		
 		parameters[3] = treeNode.getRightValue();
 				
 		parameters[4] = treeNode.nextVersion();
 		parameters[5] = treeNode.getId();
 		parameters[6] = treeNode.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTreeNodeCreateParameters(TreeNode treeNode){
		Object[] parameters = new Object[5];
		String newTreeNodeId=getNextId();
		treeNode.setId(newTreeNodeId);
		parameters[0] =  treeNode.getId();
 
 		
 		parameters[1] = treeNode.getNodeId();
 		
 		
 		parameters[2] = treeNode.getNodeType();
 		
 		
 		parameters[3] = treeNode.getLeftValue();
 		
 		
 		parameters[4] = treeNode.getRightValue();
 				
 				
 		return parameters;
 	}
 	
	protected TreeNode saveInternalTreeNode(TreeNode treeNode, Map<String,Object> options){
		
		saveTreeNode(treeNode);

		
		return treeNode;
		
	}
	
	
	
	//======================================================================================
	

	

		

	public TreeNode present(TreeNode treeNode,Map<String, Object> options){
	

		return treeNode;
	
	}
		

	

	protected String getTableName(){
		return TreeNodeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<TreeNode> treeNodeList) {		
		this.enhanceListInternal(treeNodeList, this.getTreeNodeMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TreeNode> treeNodeList = ownerEntity.collectRefsWithType(TreeNode.INTERNAL_TYPE);
		this.enhanceList(treeNodeList);
		
	}
	
	@Override
	public SmartList<TreeNode> findTreeNodeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTreeNodeMapper());

	}
	@Override
	public int countTreeNodeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTreeNodeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<TreeNode> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTreeNodeMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateTreeNode executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateTreeNode result = new CandidateTreeNode();
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





















