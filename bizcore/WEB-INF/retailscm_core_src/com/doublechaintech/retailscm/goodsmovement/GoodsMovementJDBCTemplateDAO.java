
package com.doublechaintech.retailscm.goodsmovement;

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


import com.doublechaintech.retailscm.goods.Goods;

import com.doublechaintech.retailscm.goods.GoodsDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class GoodsMovementJDBCTemplateDAO extends RetailscmBaseDAOImpl implements GoodsMovementDAO{

	protected GoodsDAO goodsDAO;
	public void setGoodsDAO(GoodsDAO goodsDAO){

 		if(goodsDAO == null){
 			throw new IllegalStateException("Do not try to set goodsDAO to null.");
 		}
	 	this.goodsDAO = goodsDAO;
 	}
 	public GoodsDAO getGoodsDAO(){
 		if(this.goodsDAO == null){
 			throw new IllegalStateException("The goodsDAO is not configured yet, please config it some where.");
 		}

	 	return this.goodsDAO;
 	}



	/*
	protected GoodsMovement load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGoodsMovement(accessKey, options);
	}
	*/

	public SmartList<GoodsMovement> loadAll() {
	    return this.loadAll(getGoodsMovementMapper());
	}

  public Stream<GoodsMovement> loadAllAsStream() {
      return this.loadAllAsStream(getGoodsMovementMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public GoodsMovement load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGoodsMovement(GoodsMovementTable.withId(id), options);
	}

	

	public GoodsMovement save(GoodsMovement goodsMovement,Map<String,Object> options){

		String methodName="save(GoodsMovement goodsMovement,Map<String,Object> options)";

		assertMethodArgumentNotNull(goodsMovement, methodName, "goodsMovement");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalGoodsMovement(goodsMovement,options);
	}
	public GoodsMovement clone(String goodsMovementId, Map<String,Object> options) throws Exception{

		return clone(GoodsMovementTable.withId(goodsMovementId),options);
	}

	protected GoodsMovement clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String goodsMovementId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		GoodsMovement newGoodsMovement = loadInternalGoodsMovement(accessKey, options);
		newGoodsMovement.setVersion(0);
		
		


		saveInternalGoodsMovement(newGoodsMovement,options);

		return newGoodsMovement;
	}

	



	protected void throwIfHasException(String goodsMovementId,int version,int count) throws Exception{
		if (count == 1) {
			throw new GoodsMovementVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GoodsMovementNotFoundException(
					"The " + this.getTableName() + "(" + goodsMovementId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String goodsMovementId, int version) throws Exception{

		String methodName="delete(String goodsMovementId, int version)";
		assertMethodArgumentNotNull(goodsMovementId, methodName, "goodsMovementId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{goodsMovementId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(goodsMovementId,version);
		}


	}






	public GoodsMovement disconnectFromAll(String goodsMovementId, int version) throws Exception{


		GoodsMovement goodsMovement = loadInternalGoodsMovement(GoodsMovementTable.withId(goodsMovementId), emptyOptions());
		goodsMovement.clearFromAll();
		this.saveGoodsMovement(goodsMovement);
		return goodsMovement;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return GoodsMovementTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "goods_movement";
	}
	@Override
	protected String getBeanName() {

		return "goodsMovement";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return GoodsMovementTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractGoodsEnabled(Map<String,Object> options){

	 	return checkOptions(options, GoodsMovementTokens.GOODS);
 	}

 	protected boolean isSaveGoodsEnabled(Map<String,Object> options){

 		return checkOptions(options, GoodsMovementTokens.GOODS);
 	}



 
		

	

	protected GoodsMovementMapper getGoodsMovementMapper(){
		return new GoodsMovementMapper();
	}



	protected GoodsMovement extractGoodsMovement(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			GoodsMovement goodsMovement = loadSingleObject(accessKey, getGoodsMovementMapper());
			return goodsMovement;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsMovementNotFoundException("GoodsMovement("+accessKey+") is not found!");
		}

	}




	protected GoodsMovement loadInternalGoodsMovement(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		GoodsMovement goodsMovement = extractGoodsMovement(accessKey, loadOptions);

 		if(isExtractGoodsEnabled(loadOptions)){
	 		extractGoods(goodsMovement, loadOptions);
 		}
 
		
		return goodsMovement;

	}

	

 	protected GoodsMovement extractGoods(GoodsMovement goodsMovement, Map<String,Object> options) throws Exception{
  

		if(goodsMovement.getGoods() == null){
			return goodsMovement;
		}
		String goodsId = goodsMovement.getGoods().getId();
		if( goodsId == null){
			return goodsMovement;
		}
		Goods goods = getGoodsDAO().load(goodsId,options);
		if(goods != null){
			goodsMovement.setGoods(goods);
		}


 		return goodsMovement;
 	}

 
		

 
 	public SmartList<GoodsMovement> findGoodsMovementByGoods(String goodsId,Map<String,Object> options){

  		SmartList<GoodsMovement> resultList = queryWith(GoodsMovementTable.COLUMN_GOODS, goodsId, options, getGoodsMovementMapper());
		// analyzeGoodsMovementByGoods(resultList, goodsId, options);
		return resultList;
 	}
 	

 	public SmartList<GoodsMovement> findGoodsMovementByGoods(String goodsId, int start, int count,Map<String,Object> options){

 		SmartList<GoodsMovement> resultList =  queryWithRange(GoodsMovementTable.COLUMN_GOODS, goodsId, options, getGoodsMovementMapper(), start, count);
 		//analyzeGoodsMovementByGoods(resultList, goodsId, options);
 		return resultList;

 	}
 	public void analyzeGoodsMovementByGoods(SmartList<GoodsMovement> resultList, String goodsId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(GoodsMovement.GOODS_PROPERTY, goodsId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
		StatsItem moveTimeStatsItem = new StatsItem();
		//GoodsMovement.MOVE_TIME_PROPERTY
		moveTimeStatsItem.setDisplayName("货物移动");
		moveTimeStatsItem.setInternalName(formatKeyForDateLine(GoodsMovement.MOVE_TIME_PROPERTY));
		moveTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(GoodsMovement.MOVE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(moveTimeStatsItem);
 		
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countGoodsMovementByGoods(String goodsId,Map<String,Object> options){

 		return countWith(GoodsMovementTable.COLUMN_GOODS, goodsId, options);
 	}
 	@Override
	public Map<String, Integer> countGoodsMovementByGoodsIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GoodsMovementTable.COLUMN_GOODS, ids, options);
	}

 




	

	protected GoodsMovement saveGoodsMovement(GoodsMovement  goodsMovement){
    

		
		if(!goodsMovement.isChanged()){
			return goodsMovement;
		}
		

    Beans.dbUtil().cacheCleanUp(goodsMovement);
		String SQL=this.getSaveGoodsMovementSQL(goodsMovement);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGoodsMovementParameters(goodsMovement);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		goodsMovement.incVersion();
		goodsMovement.afterSave();
		return goodsMovement;

	}
	public SmartList<GoodsMovement> saveGoodsMovementList(SmartList<GoodsMovement> goodsMovementList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGoodsMovementList(goodsMovementList);

		batchGoodsMovementCreate((List<GoodsMovement>)lists[CREATE_LIST_INDEX]);

		batchGoodsMovementUpdate((List<GoodsMovement>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(GoodsMovement goodsMovement:goodsMovementList){
			if(goodsMovement.isChanged()){
				goodsMovement.incVersion();
				goodsMovement.afterSave();
			}


		}


		return goodsMovementList;
	}

	public SmartList<GoodsMovement> removeGoodsMovementList(SmartList<GoodsMovement> goodsMovementList,Map<String,Object> options){


		super.removeList(goodsMovementList, options);

		return goodsMovementList;


	}

	protected List<Object[]> prepareGoodsMovementBatchCreateArgs(List<GoodsMovement> goodsMovementList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsMovement goodsMovement:goodsMovementList ){
			Object [] parameters = prepareGoodsMovementCreateParameters(goodsMovement);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareGoodsMovementBatchUpdateArgs(List<GoodsMovement> goodsMovementList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsMovement goodsMovement:goodsMovementList ){
			if(!goodsMovement.isChanged()){
				continue;
			}
			Object [] parameters = prepareGoodsMovementUpdateParameters(goodsMovement);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchGoodsMovementCreate(List<GoodsMovement> goodsMovementList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGoodsMovementBatchCreateArgs(goodsMovementList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchGoodsMovementUpdate(List<GoodsMovement> goodsMovementList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGoodsMovementBatchUpdateArgs(goodsMovementList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitGoodsMovementList(List<GoodsMovement> goodsMovementList){

		List<GoodsMovement> goodsMovementCreateList=new ArrayList<GoodsMovement>();
		List<GoodsMovement> goodsMovementUpdateList=new ArrayList<GoodsMovement>();

		for(GoodsMovement goodsMovement: goodsMovementList){
			if(isUpdateRequest(goodsMovement)){
				goodsMovementUpdateList.add( goodsMovement);
				continue;
			}
			goodsMovementCreateList.add(goodsMovement);
		}

		return new Object[]{goodsMovementCreateList,goodsMovementUpdateList};
	}

	protected boolean isUpdateRequest(GoodsMovement goodsMovement){
 		return goodsMovement.getVersion() > 0;
 	}
 	protected String getSaveGoodsMovementSQL(GoodsMovement goodsMovement){
 		if(isUpdateRequest(goodsMovement)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveGoodsMovementParameters(GoodsMovement goodsMovement){
 		if(isUpdateRequest(goodsMovement) ){
 			return prepareGoodsMovementUpdateParameters(goodsMovement);
 		}
 		return prepareGoodsMovementCreateParameters(goodsMovement);
 	}
 	protected Object[] prepareGoodsMovementUpdateParameters(GoodsMovement goodsMovement){
 		Object[] parameters = new Object[12];
 
 		parameters[0] = goodsMovement.getMoveTime();
 		
 		parameters[1] = goodsMovement.getFacility();
 		
 		parameters[2] = goodsMovement.getFacilityId();
 		
 		parameters[3] = goodsMovement.getFromIp();
 		
 		parameters[4] = goodsMovement.getUserAgent();
 		
 		parameters[5] = goodsMovement.getSessionId();
 		
 		parameters[6] = goodsMovement.getLatitude();
 		
 		parameters[7] = goodsMovement.getLongitude();
 		
 		if(goodsMovement.getGoods() != null){
 			parameters[8] = goodsMovement.getGoods().getId();
 		}
    
 		parameters[9] = goodsMovement.nextVersion();
 		parameters[10] = goodsMovement.getId();
 		parameters[11] = goodsMovement.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareGoodsMovementCreateParameters(GoodsMovement goodsMovement){
		Object[] parameters = new Object[10];
        if(goodsMovement.getId() == null){
          String newGoodsMovementId=getNextId();
          goodsMovement.setId(newGoodsMovementId);
        }
		parameters[0] =  goodsMovement.getId();
 
 		parameters[1] = goodsMovement.getMoveTime();
 		
 		parameters[2] = goodsMovement.getFacility();
 		
 		parameters[3] = goodsMovement.getFacilityId();
 		
 		parameters[4] = goodsMovement.getFromIp();
 		
 		parameters[5] = goodsMovement.getUserAgent();
 		
 		parameters[6] = goodsMovement.getSessionId();
 		
 		parameters[7] = goodsMovement.getLatitude();
 		
 		parameters[8] = goodsMovement.getLongitude();
 		
 		if(goodsMovement.getGoods() != null){
 			parameters[9] = goodsMovement.getGoods().getId();
 		}
 		

 		return parameters;
 	}

	protected GoodsMovement saveInternalGoodsMovement(GoodsMovement goodsMovement, Map<String,Object> options){

 		if(isSaveGoodsEnabled(options)){
	 		saveGoods(goodsMovement, options);
 		}
 
   saveGoodsMovement(goodsMovement);
		
		return goodsMovement;

	}



	//======================================================================================
	

 	protected GoodsMovement saveGoods(GoodsMovement goodsMovement, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(goodsMovement.getGoods() == null){
 			return goodsMovement;//do nothing when it is null
 		}

 		getGoodsDAO().save(goodsMovement.getGoods(),options);
 		return goodsMovement;

 	}
 

	

		

	public GoodsMovement present(GoodsMovement goodsMovement,Map<String, Object> options){


		return goodsMovement;

	}
		

	

	protected String getTableName(){
		return GoodsMovementTable.TABLE_NAME;
	}



	public void enhanceList(List<GoodsMovement> goodsMovementList) {
		this.enhanceListInternal(goodsMovementList, this.getGoodsMovementMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<GoodsMovement> goodsMovementList = ownerEntity.collectRefsWithType(GoodsMovement.INTERNAL_TYPE);
		this.enhanceList(goodsMovementList);

	}

	@Override
	public SmartList<GoodsMovement> findGoodsMovementWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getGoodsMovementMapper());

	}
	@Override
	public int countGoodsMovementWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countGoodsMovementWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<GoodsMovement> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getGoodsMovementMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<GoodsMovement> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getGoodsMovementMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateGoodsMovement executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateGoodsMovement result = new CandidateGoodsMovement();
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
  public List<GoodsMovement> search(GoodsMovementRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected GoodsMovementMapper mapper() {
    return getGoodsMovementMapper();
  }
}


