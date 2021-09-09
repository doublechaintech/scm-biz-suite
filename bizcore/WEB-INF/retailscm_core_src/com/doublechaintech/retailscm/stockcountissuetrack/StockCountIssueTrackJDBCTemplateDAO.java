
package com.doublechaintech.retailscm.stockcountissuetrack;

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


import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;

import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class StockCountIssueTrackJDBCTemplateDAO extends RetailscmBaseDAOImpl implements StockCountIssueTrackDAO{

	protected GoodsShelfStockCountDAO goodsShelfStockCountDAO;
	public void setGoodsShelfStockCountDAO(GoodsShelfStockCountDAO goodsShelfStockCountDAO){

 		if(goodsShelfStockCountDAO == null){
 			throw new IllegalStateException("Do not try to set goodsShelfStockCountDAO to null.");
 		}
	 	this.goodsShelfStockCountDAO = goodsShelfStockCountDAO;
 	}
 	public GoodsShelfStockCountDAO getGoodsShelfStockCountDAO(){
 		if(this.goodsShelfStockCountDAO == null){
 			throw new IllegalStateException("The goodsShelfStockCountDAO is not configured yet, please config it some where.");
 		}

	 	return this.goodsShelfStockCountDAO;
 	}



	/*
	protected StockCountIssueTrack load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalStockCountIssueTrack(accessKey, options);
	}
	*/

	public SmartList<StockCountIssueTrack> loadAll() {
	    return this.loadAll(getStockCountIssueTrackMapper());
	}

  public Stream<StockCountIssueTrack> loadAllAsStream() {
      return this.loadAllAsStream(getStockCountIssueTrackMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public StockCountIssueTrack load(String id,Map<String,Object> options) throws Exception{
		return loadInternalStockCountIssueTrack(StockCountIssueTrackTable.withId(id), options);
	}

	

	public StockCountIssueTrack save(StockCountIssueTrack stockCountIssueTrack,Map<String,Object> options){

		String methodName="save(StockCountIssueTrack stockCountIssueTrack,Map<String,Object> options)";

		assertMethodArgumentNotNull(stockCountIssueTrack, methodName, "stockCountIssueTrack");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalStockCountIssueTrack(stockCountIssueTrack,options);
	}
	public StockCountIssueTrack clone(String stockCountIssueTrackId, Map<String,Object> options) throws Exception{

		return clone(StockCountIssueTrackTable.withId(stockCountIssueTrackId),options);
	}

	protected StockCountIssueTrack clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String stockCountIssueTrackId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		StockCountIssueTrack newStockCountIssueTrack = loadInternalStockCountIssueTrack(accessKey, options);
		newStockCountIssueTrack.setVersion(0);
		
		


		saveInternalStockCountIssueTrack(newStockCountIssueTrack,options);

		return newStockCountIssueTrack;
	}

	



	protected void throwIfHasException(String stockCountIssueTrackId,int version,int count) throws Exception{
		if (count == 1) {
			throw new StockCountIssueTrackVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new StockCountIssueTrackNotFoundException(
					"The " + this.getTableName() + "(" + stockCountIssueTrackId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String stockCountIssueTrackId, int version) throws Exception{

		String methodName="delete(String stockCountIssueTrackId, int version)";
		assertMethodArgumentNotNull(stockCountIssueTrackId, methodName, "stockCountIssueTrackId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{stockCountIssueTrackId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(stockCountIssueTrackId,version);
		}


	}






	public StockCountIssueTrack disconnectFromAll(String stockCountIssueTrackId, int version) throws Exception{


		StockCountIssueTrack stockCountIssueTrack = loadInternalStockCountIssueTrack(StockCountIssueTrackTable.withId(stockCountIssueTrackId), emptyOptions());
		stockCountIssueTrack.clearFromAll();
		this.saveStockCountIssueTrack(stockCountIssueTrack);
		return stockCountIssueTrack;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return StockCountIssueTrackTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "stock_count_issue_track";
	}
	@Override
	protected String getBeanName() {

		return "stockCountIssueTrack";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return StockCountIssueTrackTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractStockCountEnabled(Map<String,Object> options){

	 	return checkOptions(options, StockCountIssueTrackTokens.STOCKCOUNT);
 	}

 	protected boolean isSaveStockCountEnabled(Map<String,Object> options){

 		return checkOptions(options, StockCountIssueTrackTokens.STOCKCOUNT);
 	}



 
		

	

	protected StockCountIssueTrackMapper getStockCountIssueTrackMapper(){
		return new StockCountIssueTrackMapper();
	}



	protected StockCountIssueTrack extractStockCountIssueTrack(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			StockCountIssueTrack stockCountIssueTrack = loadSingleObject(accessKey, getStockCountIssueTrackMapper());
			return stockCountIssueTrack;
		}catch(EmptyResultDataAccessException e){
			throw new StockCountIssueTrackNotFoundException("StockCountIssueTrack("+accessKey+") is not found!");
		}

	}




	protected StockCountIssueTrack loadInternalStockCountIssueTrack(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		StockCountIssueTrack stockCountIssueTrack = extractStockCountIssueTrack(accessKey, loadOptions);

 		if(isExtractStockCountEnabled(loadOptions)){
	 		extractStockCount(stockCountIssueTrack, loadOptions);
 		}
 
		
		return stockCountIssueTrack;

	}

	

 	protected StockCountIssueTrack extractStockCount(StockCountIssueTrack stockCountIssueTrack, Map<String,Object> options) throws Exception{
  

		if(stockCountIssueTrack.getStockCount() == null){
			return stockCountIssueTrack;
		}
		String stockCountId = stockCountIssueTrack.getStockCount().getId();
		if( stockCountId == null){
			return stockCountIssueTrack;
		}
		GoodsShelfStockCount stockCount = getGoodsShelfStockCountDAO().load(stockCountId,options);
		if(stockCount != null){
			stockCountIssueTrack.setStockCount(stockCount);
		}


 		return stockCountIssueTrack;
 	}

 
		

 
 	public SmartList<StockCountIssueTrack> findStockCountIssueTrackByStockCount(String goodsShelfStockCountId,Map<String,Object> options){

  		SmartList<StockCountIssueTrack> resultList = queryWith(StockCountIssueTrackTable.COLUMN_STOCK_COUNT, goodsShelfStockCountId, options, getStockCountIssueTrackMapper());
		// analyzeStockCountIssueTrackByStockCount(resultList, goodsShelfStockCountId, options);
		return resultList;
 	}
 	

 	public SmartList<StockCountIssueTrack> findStockCountIssueTrackByStockCount(String goodsShelfStockCountId, int start, int count,Map<String,Object> options){

 		SmartList<StockCountIssueTrack> resultList =  queryWithRange(StockCountIssueTrackTable.COLUMN_STOCK_COUNT, goodsShelfStockCountId, options, getStockCountIssueTrackMapper(), start, count);
 		//analyzeStockCountIssueTrackByStockCount(resultList, goodsShelfStockCountId, options);
 		return resultList;

 	}
 	public void analyzeStockCountIssueTrackByStockCount(SmartList<StockCountIssueTrack> resultList, String goodsShelfStockCountId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countStockCountIssueTrackByStockCount(String goodsShelfStockCountId,Map<String,Object> options){

 		return countWith(StockCountIssueTrackTable.COLUMN_STOCK_COUNT, goodsShelfStockCountId, options);
 	}
 	@Override
	public Map<String, Integer> countStockCountIssueTrackByStockCountIds(String[] ids, Map<String, Object> options) {
		return countWithIds(StockCountIssueTrackTable.COLUMN_STOCK_COUNT, ids, options);
	}

 




	

	protected StockCountIssueTrack saveStockCountIssueTrack(StockCountIssueTrack  stockCountIssueTrack){
    

		
		if(!stockCountIssueTrack.isChanged()){
			return stockCountIssueTrack;
		}
		

    Beans.dbUtil().cacheCleanUp(stockCountIssueTrack);
		String SQL=this.getSaveStockCountIssueTrackSQL(stockCountIssueTrack);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveStockCountIssueTrackParameters(stockCountIssueTrack);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		stockCountIssueTrack.incVersion();
		stockCountIssueTrack.afterSave();
		return stockCountIssueTrack;

	}
	public SmartList<StockCountIssueTrack> saveStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitStockCountIssueTrackList(stockCountIssueTrackList);

		batchStockCountIssueTrackCreate((List<StockCountIssueTrack>)lists[CREATE_LIST_INDEX]);

		batchStockCountIssueTrackUpdate((List<StockCountIssueTrack>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(StockCountIssueTrack stockCountIssueTrack:stockCountIssueTrackList){
			if(stockCountIssueTrack.isChanged()){
				stockCountIssueTrack.incVersion();
				stockCountIssueTrack.afterSave();
			}


		}


		return stockCountIssueTrackList;
	}

	public SmartList<StockCountIssueTrack> removeStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList,Map<String,Object> options){


		super.removeList(stockCountIssueTrackList, options);

		return stockCountIssueTrackList;


	}

	protected List<Object[]> prepareStockCountIssueTrackBatchCreateArgs(List<StockCountIssueTrack> stockCountIssueTrackList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(StockCountIssueTrack stockCountIssueTrack:stockCountIssueTrackList ){
			Object [] parameters = prepareStockCountIssueTrackCreateParameters(stockCountIssueTrack);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareStockCountIssueTrackBatchUpdateArgs(List<StockCountIssueTrack> stockCountIssueTrackList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(StockCountIssueTrack stockCountIssueTrack:stockCountIssueTrackList ){
			if(!stockCountIssueTrack.isChanged()){
				continue;
			}
			Object [] parameters = prepareStockCountIssueTrackUpdateParameters(stockCountIssueTrack);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchStockCountIssueTrackCreate(List<StockCountIssueTrack> stockCountIssueTrackList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareStockCountIssueTrackBatchCreateArgs(stockCountIssueTrackList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchStockCountIssueTrackUpdate(List<StockCountIssueTrack> stockCountIssueTrackList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareStockCountIssueTrackBatchUpdateArgs(stockCountIssueTrackList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitStockCountIssueTrackList(List<StockCountIssueTrack> stockCountIssueTrackList){

		List<StockCountIssueTrack> stockCountIssueTrackCreateList=new ArrayList<StockCountIssueTrack>();
		List<StockCountIssueTrack> stockCountIssueTrackUpdateList=new ArrayList<StockCountIssueTrack>();

		for(StockCountIssueTrack stockCountIssueTrack: stockCountIssueTrackList){
			if(isUpdateRequest(stockCountIssueTrack)){
				stockCountIssueTrackUpdateList.add( stockCountIssueTrack);
				continue;
			}
			stockCountIssueTrackCreateList.add(stockCountIssueTrack);
		}

		return new Object[]{stockCountIssueTrackCreateList,stockCountIssueTrackUpdateList};
	}

	protected boolean isUpdateRequest(StockCountIssueTrack stockCountIssueTrack){
 		return stockCountIssueTrack.getVersion() > 0;
 	}
 	protected String getSaveStockCountIssueTrackSQL(StockCountIssueTrack stockCountIssueTrack){
 		if(isUpdateRequest(stockCountIssueTrack)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveStockCountIssueTrackParameters(StockCountIssueTrack stockCountIssueTrack){
 		if(isUpdateRequest(stockCountIssueTrack) ){
 			return prepareStockCountIssueTrackUpdateParameters(stockCountIssueTrack);
 		}
 		return prepareStockCountIssueTrackCreateParameters(stockCountIssueTrack);
 	}
 	protected Object[] prepareStockCountIssueTrackUpdateParameters(StockCountIssueTrack stockCountIssueTrack){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = stockCountIssueTrack.getTitle();
 		
 		parameters[1] = stockCountIssueTrack.getCountTime();
 		
 		parameters[2] = stockCountIssueTrack.getSummary();
 		
 		if(stockCountIssueTrack.getStockCount() != null){
 			parameters[3] = stockCountIssueTrack.getStockCount().getId();
 		}
    
 		parameters[4] = stockCountIssueTrack.nextVersion();
 		parameters[5] = stockCountIssueTrack.getId();
 		parameters[6] = stockCountIssueTrack.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareStockCountIssueTrackCreateParameters(StockCountIssueTrack stockCountIssueTrack){
		Object[] parameters = new Object[5];
        if(stockCountIssueTrack.getId() == null){
          String newStockCountIssueTrackId=getNextId();
          stockCountIssueTrack.setId(newStockCountIssueTrackId);
        }
		parameters[0] =  stockCountIssueTrack.getId();
 
 		parameters[1] = stockCountIssueTrack.getTitle();
 		
 		parameters[2] = stockCountIssueTrack.getCountTime();
 		
 		parameters[3] = stockCountIssueTrack.getSummary();
 		
 		if(stockCountIssueTrack.getStockCount() != null){
 			parameters[4] = stockCountIssueTrack.getStockCount().getId();
 		}
 		

 		return parameters;
 	}

	protected StockCountIssueTrack saveInternalStockCountIssueTrack(StockCountIssueTrack stockCountIssueTrack, Map<String,Object> options){

 		if(isSaveStockCountEnabled(options)){
	 		saveStockCount(stockCountIssueTrack, options);
 		}
 
   saveStockCountIssueTrack(stockCountIssueTrack);
		
		return stockCountIssueTrack;

	}



	//======================================================================================
	

 	protected StockCountIssueTrack saveStockCount(StockCountIssueTrack stockCountIssueTrack, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(stockCountIssueTrack.getStockCount() == null){
 			return stockCountIssueTrack;//do nothing when it is null
 		}

 		getGoodsShelfStockCountDAO().save(stockCountIssueTrack.getStockCount(),options);
 		return stockCountIssueTrack;

 	}
 

	

		

	public StockCountIssueTrack present(StockCountIssueTrack stockCountIssueTrack,Map<String, Object> options){


		return stockCountIssueTrack;

	}
		

	

	protected String getTableName(){
		return StockCountIssueTrackTable.TABLE_NAME;
	}



	public void enhanceList(List<StockCountIssueTrack> stockCountIssueTrackList) {
		this.enhanceListInternal(stockCountIssueTrackList, this.getStockCountIssueTrackMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<StockCountIssueTrack> stockCountIssueTrackList = ownerEntity.collectRefsWithType(StockCountIssueTrack.INTERNAL_TYPE);
		this.enhanceList(stockCountIssueTrackList);

	}

	@Override
	public SmartList<StockCountIssueTrack> findStockCountIssueTrackWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getStockCountIssueTrackMapper());

	}
	@Override
	public int countStockCountIssueTrackWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countStockCountIssueTrackWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<StockCountIssueTrack> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getStockCountIssueTrackMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<StockCountIssueTrack> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getStockCountIssueTrackMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateStockCountIssueTrack executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateStockCountIssueTrack result = new CandidateStockCountIssueTrack();
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
  public List<StockCountIssueTrack> search(StockCountIssueTrackRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected StockCountIssueTrackMapper mapper() {
    return getStockCountIssueTrackMapper();
  }
}


