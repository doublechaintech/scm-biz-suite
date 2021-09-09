
package com.doublechaintech.retailscm.goodsshelfstockcount;

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


import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack;

import com.doublechaintech.retailscm.goodsshelf.GoodsShelfDAO;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class GoodsShelfStockCountJDBCTemplateDAO extends RetailscmBaseDAOImpl implements GoodsShelfStockCountDAO{

	protected GoodsShelfDAO goodsShelfDAO;
	public void setGoodsShelfDAO(GoodsShelfDAO goodsShelfDAO){

 		if(goodsShelfDAO == null){
 			throw new IllegalStateException("Do not try to set goodsShelfDAO to null.");
 		}
	 	this.goodsShelfDAO = goodsShelfDAO;
 	}
 	public GoodsShelfDAO getGoodsShelfDAO(){
 		if(this.goodsShelfDAO == null){
 			throw new IllegalStateException("The goodsShelfDAO is not configured yet, please config it some where.");
 		}

	 	return this.goodsShelfDAO;
 	}

	protected StockCountIssueTrackDAO stockCountIssueTrackDAO;
	public void setStockCountIssueTrackDAO(StockCountIssueTrackDAO stockCountIssueTrackDAO){

 		if(stockCountIssueTrackDAO == null){
 			throw new IllegalStateException("Do not try to set stockCountIssueTrackDAO to null.");
 		}
	 	this.stockCountIssueTrackDAO = stockCountIssueTrackDAO;
 	}
 	public StockCountIssueTrackDAO getStockCountIssueTrackDAO(){
 		if(this.stockCountIssueTrackDAO == null){
 			throw new IllegalStateException("The stockCountIssueTrackDAO is not configured yet, please config it some where.");
 		}

	 	return this.stockCountIssueTrackDAO;
 	}



	/*
	protected GoodsShelfStockCount load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGoodsShelfStockCount(accessKey, options);
	}
	*/

	public SmartList<GoodsShelfStockCount> loadAll() {
	    return this.loadAll(getGoodsShelfStockCountMapper());
	}

  public Stream<GoodsShelfStockCount> loadAllAsStream() {
      return this.loadAllAsStream(getGoodsShelfStockCountMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public GoodsShelfStockCount load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGoodsShelfStockCount(GoodsShelfStockCountTable.withId(id), options);
	}

	

	public GoodsShelfStockCount save(GoodsShelfStockCount goodsShelfStockCount,Map<String,Object> options){

		String methodName="save(GoodsShelfStockCount goodsShelfStockCount,Map<String,Object> options)";

		assertMethodArgumentNotNull(goodsShelfStockCount, methodName, "goodsShelfStockCount");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalGoodsShelfStockCount(goodsShelfStockCount,options);
	}
	public GoodsShelfStockCount clone(String goodsShelfStockCountId, Map<String,Object> options) throws Exception{

		return clone(GoodsShelfStockCountTable.withId(goodsShelfStockCountId),options);
	}

	protected GoodsShelfStockCount clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String goodsShelfStockCountId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		GoodsShelfStockCount newGoodsShelfStockCount = loadInternalGoodsShelfStockCount(accessKey, options);
		newGoodsShelfStockCount.setVersion(0);
		
		

 		if(isSaveStockCountIssueTrackListEnabled(options)){
 			for(StockCountIssueTrack item: newGoodsShelfStockCount.getStockCountIssueTrackList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalGoodsShelfStockCount(newGoodsShelfStockCount,options);

		return newGoodsShelfStockCount;
	}

	



	protected void throwIfHasException(String goodsShelfStockCountId,int version,int count) throws Exception{
		if (count == 1) {
			throw new GoodsShelfStockCountVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GoodsShelfStockCountNotFoundException(
					"The " + this.getTableName() + "(" + goodsShelfStockCountId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String goodsShelfStockCountId, int version) throws Exception{

		String methodName="delete(String goodsShelfStockCountId, int version)";
		assertMethodArgumentNotNull(goodsShelfStockCountId, methodName, "goodsShelfStockCountId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{goodsShelfStockCountId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(goodsShelfStockCountId,version);
		}


	}






	public GoodsShelfStockCount disconnectFromAll(String goodsShelfStockCountId, int version) throws Exception{


		GoodsShelfStockCount goodsShelfStockCount = loadInternalGoodsShelfStockCount(GoodsShelfStockCountTable.withId(goodsShelfStockCountId), emptyOptions());
		goodsShelfStockCount.clearFromAll();
		this.saveGoodsShelfStockCount(goodsShelfStockCount);
		return goodsShelfStockCount;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return GoodsShelfStockCountTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "goods_shelf_stock_count";
	}
	@Override
	protected String getBeanName() {

		return "goodsShelfStockCount";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return GoodsShelfStockCountTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractShelfEnabled(Map<String,Object> options){

	 	return checkOptions(options, GoodsShelfStockCountTokens.SHELF);
 	}

 	protected boolean isSaveShelfEnabled(Map<String,Object> options){

 		return checkOptions(options, GoodsShelfStockCountTokens.SHELF);
 	}



 
		

	protected boolean isExtractStockCountIssueTrackListEnabled(Map<String,Object> options){
 		return checkOptions(options,GoodsShelfStockCountTokens.STOCK_COUNT_ISSUE_TRACK_LIST);
 	}
 	protected boolean isAnalyzeStockCountIssueTrackListEnabled(Map<String,Object> options){
 		return GoodsShelfStockCountTokens.of(options).analyzeStockCountIssueTrackListEnabled();
 	}

	protected boolean isSaveStockCountIssueTrackListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsShelfStockCountTokens.STOCK_COUNT_ISSUE_TRACK_LIST);

 	}

		

	

	protected GoodsShelfStockCountMapper getGoodsShelfStockCountMapper(){
		return new GoodsShelfStockCountMapper();
	}



	protected GoodsShelfStockCount extractGoodsShelfStockCount(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			GoodsShelfStockCount goodsShelfStockCount = loadSingleObject(accessKey, getGoodsShelfStockCountMapper());
			return goodsShelfStockCount;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsShelfStockCountNotFoundException("GoodsShelfStockCount("+accessKey+") is not found!");
		}

	}




	protected GoodsShelfStockCount loadInternalGoodsShelfStockCount(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		GoodsShelfStockCount goodsShelfStockCount = extractGoodsShelfStockCount(accessKey, loadOptions);

 		if(isExtractShelfEnabled(loadOptions)){
	 		extractShelf(goodsShelfStockCount, loadOptions);
 		}
 
		
		if(isExtractStockCountIssueTrackListEnabled(loadOptions)){
	 		extractStockCountIssueTrackList(goodsShelfStockCount, loadOptions);
 		}

 		
 		if(isAnalyzeStockCountIssueTrackListEnabled(loadOptions)){
	 		analyzeStockCountIssueTrackList(goodsShelfStockCount, loadOptions);
 		}
 		
		
		return goodsShelfStockCount;

	}

	

 	protected GoodsShelfStockCount extractShelf(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options) throws Exception{
  

		if(goodsShelfStockCount.getShelf() == null){
			return goodsShelfStockCount;
		}
		String shelfId = goodsShelfStockCount.getShelf().getId();
		if( shelfId == null){
			return goodsShelfStockCount;
		}
		GoodsShelf shelf = getGoodsShelfDAO().load(shelfId,options);
		if(shelf != null){
			goodsShelfStockCount.setShelf(shelf);
		}


 		return goodsShelfStockCount;
 	}

 
		
	protected void enhanceStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected GoodsShelfStockCount extractStockCountIssueTrackList(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options){
    

		if(goodsShelfStockCount == null){
			return null;
		}
		if(goodsShelfStockCount.getId() == null){
			return goodsShelfStockCount;
		}



		SmartList<StockCountIssueTrack> stockCountIssueTrackList = getStockCountIssueTrackDAO().findStockCountIssueTrackByStockCount(goodsShelfStockCount.getId(),options);
		if(stockCountIssueTrackList != null){
			enhanceStockCountIssueTrackList(stockCountIssueTrackList,options);
			goodsShelfStockCount.setStockCountIssueTrackList(stockCountIssueTrackList);
		}

		return goodsShelfStockCount;
  
	}

	protected GoodsShelfStockCount analyzeStockCountIssueTrackList(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options){
     
		if(goodsShelfStockCount == null){
			return null;
		}
		if(goodsShelfStockCount.getId() == null){
			return goodsShelfStockCount;
		}



		SmartList<StockCountIssueTrack> stockCountIssueTrackList = goodsShelfStockCount.getStockCountIssueTrackList();
		if(stockCountIssueTrackList != null){
			getStockCountIssueTrackDAO().analyzeStockCountIssueTrackByStockCount(stockCountIssueTrackList, goodsShelfStockCount.getId(), options);

		}

		return goodsShelfStockCount;
    
	}

		

 
 	public SmartList<GoodsShelfStockCount> findGoodsShelfStockCountByShelf(String goodsShelfId,Map<String,Object> options){

  		SmartList<GoodsShelfStockCount> resultList = queryWith(GoodsShelfStockCountTable.COLUMN_SHELF, goodsShelfId, options, getGoodsShelfStockCountMapper());
		// analyzeGoodsShelfStockCountByShelf(resultList, goodsShelfId, options);
		return resultList;
 	}
 	

 	public SmartList<GoodsShelfStockCount> findGoodsShelfStockCountByShelf(String goodsShelfId, int start, int count,Map<String,Object> options){

 		SmartList<GoodsShelfStockCount> resultList =  queryWithRange(GoodsShelfStockCountTable.COLUMN_SHELF, goodsShelfId, options, getGoodsShelfStockCountMapper(), start, count);
 		//analyzeGoodsShelfStockCountByShelf(resultList, goodsShelfId, options);
 		return resultList;

 	}
 	public void analyzeGoodsShelfStockCountByShelf(SmartList<GoodsShelfStockCount> resultList, String goodsShelfId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countGoodsShelfStockCountByShelf(String goodsShelfId,Map<String,Object> options){

 		return countWith(GoodsShelfStockCountTable.COLUMN_SHELF, goodsShelfId, options);
 	}
 	@Override
	public Map<String, Integer> countGoodsShelfStockCountByShelfIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GoodsShelfStockCountTable.COLUMN_SHELF, ids, options);
	}

 




	

	protected GoodsShelfStockCount saveGoodsShelfStockCount(GoodsShelfStockCount  goodsShelfStockCount){
    

		
		if(!goodsShelfStockCount.isChanged()){
			return goodsShelfStockCount;
		}
		

    Beans.dbUtil().cacheCleanUp(goodsShelfStockCount);
		String SQL=this.getSaveGoodsShelfStockCountSQL(goodsShelfStockCount);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGoodsShelfStockCountParameters(goodsShelfStockCount);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		goodsShelfStockCount.incVersion();
		goodsShelfStockCount.afterSave();
		return goodsShelfStockCount;

	}
	public SmartList<GoodsShelfStockCount> saveGoodsShelfStockCountList(SmartList<GoodsShelfStockCount> goodsShelfStockCountList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGoodsShelfStockCountList(goodsShelfStockCountList);

		batchGoodsShelfStockCountCreate((List<GoodsShelfStockCount>)lists[CREATE_LIST_INDEX]);

		batchGoodsShelfStockCountUpdate((List<GoodsShelfStockCount>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(GoodsShelfStockCount goodsShelfStockCount:goodsShelfStockCountList){
			if(goodsShelfStockCount.isChanged()){
				goodsShelfStockCount.incVersion();
				goodsShelfStockCount.afterSave();
			}


		}


		return goodsShelfStockCountList;
	}

	public SmartList<GoodsShelfStockCount> removeGoodsShelfStockCountList(SmartList<GoodsShelfStockCount> goodsShelfStockCountList,Map<String,Object> options){


		super.removeList(goodsShelfStockCountList, options);

		return goodsShelfStockCountList;


	}

	protected List<Object[]> prepareGoodsShelfStockCountBatchCreateArgs(List<GoodsShelfStockCount> goodsShelfStockCountList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsShelfStockCount goodsShelfStockCount:goodsShelfStockCountList ){
			Object [] parameters = prepareGoodsShelfStockCountCreateParameters(goodsShelfStockCount);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareGoodsShelfStockCountBatchUpdateArgs(List<GoodsShelfStockCount> goodsShelfStockCountList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsShelfStockCount goodsShelfStockCount:goodsShelfStockCountList ){
			if(!goodsShelfStockCount.isChanged()){
				continue;
			}
			Object [] parameters = prepareGoodsShelfStockCountUpdateParameters(goodsShelfStockCount);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchGoodsShelfStockCountCreate(List<GoodsShelfStockCount> goodsShelfStockCountList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGoodsShelfStockCountBatchCreateArgs(goodsShelfStockCountList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchGoodsShelfStockCountUpdate(List<GoodsShelfStockCount> goodsShelfStockCountList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGoodsShelfStockCountBatchUpdateArgs(goodsShelfStockCountList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitGoodsShelfStockCountList(List<GoodsShelfStockCount> goodsShelfStockCountList){

		List<GoodsShelfStockCount> goodsShelfStockCountCreateList=new ArrayList<GoodsShelfStockCount>();
		List<GoodsShelfStockCount> goodsShelfStockCountUpdateList=new ArrayList<GoodsShelfStockCount>();

		for(GoodsShelfStockCount goodsShelfStockCount: goodsShelfStockCountList){
			if(isUpdateRequest(goodsShelfStockCount)){
				goodsShelfStockCountUpdateList.add( goodsShelfStockCount);
				continue;
			}
			goodsShelfStockCountCreateList.add(goodsShelfStockCount);
		}

		return new Object[]{goodsShelfStockCountCreateList,goodsShelfStockCountUpdateList};
	}

	protected boolean isUpdateRequest(GoodsShelfStockCount goodsShelfStockCount){
 		return goodsShelfStockCount.getVersion() > 0;
 	}
 	protected String getSaveGoodsShelfStockCountSQL(GoodsShelfStockCount goodsShelfStockCount){
 		if(isUpdateRequest(goodsShelfStockCount)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveGoodsShelfStockCountParameters(GoodsShelfStockCount goodsShelfStockCount){
 		if(isUpdateRequest(goodsShelfStockCount) ){
 			return prepareGoodsShelfStockCountUpdateParameters(goodsShelfStockCount);
 		}
 		return prepareGoodsShelfStockCountCreateParameters(goodsShelfStockCount);
 	}
 	protected Object[] prepareGoodsShelfStockCountUpdateParameters(GoodsShelfStockCount goodsShelfStockCount){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = goodsShelfStockCount.getTitle();
 		
 		parameters[1] = goodsShelfStockCount.getCountTime();
 		
 		parameters[2] = goodsShelfStockCount.getSummary();
 		
 		if(goodsShelfStockCount.getShelf() != null){
 			parameters[3] = goodsShelfStockCount.getShelf().getId();
 		}
    
 		parameters[4] = goodsShelfStockCount.nextVersion();
 		parameters[5] = goodsShelfStockCount.getId();
 		parameters[6] = goodsShelfStockCount.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareGoodsShelfStockCountCreateParameters(GoodsShelfStockCount goodsShelfStockCount){
		Object[] parameters = new Object[5];
        if(goodsShelfStockCount.getId() == null){
          String newGoodsShelfStockCountId=getNextId();
          goodsShelfStockCount.setId(newGoodsShelfStockCountId);
        }
		parameters[0] =  goodsShelfStockCount.getId();
 
 		parameters[1] = goodsShelfStockCount.getTitle();
 		
 		parameters[2] = goodsShelfStockCount.getCountTime();
 		
 		parameters[3] = goodsShelfStockCount.getSummary();
 		
 		if(goodsShelfStockCount.getShelf() != null){
 			parameters[4] = goodsShelfStockCount.getShelf().getId();
 		}
 		

 		return parameters;
 	}

	protected GoodsShelfStockCount saveInternalGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options){

 		if(isSaveShelfEnabled(options)){
	 		saveShelf(goodsShelfStockCount, options);
 		}
 
   saveGoodsShelfStockCount(goodsShelfStockCount);
		
		if(isSaveStockCountIssueTrackListEnabled(options)){
	 		saveStockCountIssueTrackList(goodsShelfStockCount, options);
	 		//removeStockCountIssueTrackList(goodsShelfStockCount, options);
	 		//Not delete the record

 		}
		
		return goodsShelfStockCount;

	}



	//======================================================================================
	

 	protected GoodsShelfStockCount saveShelf(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(goodsShelfStockCount.getShelf() == null){
 			return goodsShelfStockCount;//do nothing when it is null
 		}

 		getGoodsShelfDAO().save(goodsShelfStockCount.getShelf(),options);
 		return goodsShelfStockCount;

 	}
 

	
	public GoodsShelfStockCount planToRemoveStockCountIssueTrackList(GoodsShelfStockCount goodsShelfStockCount, String stockCountIssueTrackIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(StockCountIssueTrack.STOCK_COUNT_PROPERTY, goodsShelfStockCount.getId());
		key.put(StockCountIssueTrack.ID_PROPERTY, stockCountIssueTrackIds);

		SmartList<StockCountIssueTrack> externalStockCountIssueTrackList = getStockCountIssueTrackDAO().
				findStockCountIssueTrackWithKey(key, options);
		if(externalStockCountIssueTrackList == null){
			return goodsShelfStockCount;
		}
		if(externalStockCountIssueTrackList.isEmpty()){
			return goodsShelfStockCount;
		}

		for(StockCountIssueTrack stockCountIssueTrackItem: externalStockCountIssueTrackList){

			stockCountIssueTrackItem.clearFromAll();
		}


		SmartList<StockCountIssueTrack> stockCountIssueTrackList = goodsShelfStockCount.getStockCountIssueTrackList();
		stockCountIssueTrackList.addAllToRemoveList(externalStockCountIssueTrackList);
		return goodsShelfStockCount;

	}



		
	protected GoodsShelfStockCount saveStockCountIssueTrackList(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options){
    



		SmartList<StockCountIssueTrack> stockCountIssueTrackList = goodsShelfStockCount.getStockCountIssueTrackList();
		if(stockCountIssueTrackList == null){
			//null list means nothing
			return goodsShelfStockCount;
		}
		SmartList<StockCountIssueTrack> mergedUpdateStockCountIssueTrackList = new SmartList<StockCountIssueTrack>();


		mergedUpdateStockCountIssueTrackList.addAll(stockCountIssueTrackList);
		if(stockCountIssueTrackList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateStockCountIssueTrackList.addAll(stockCountIssueTrackList.getToRemoveList());
			stockCountIssueTrackList.removeAll(stockCountIssueTrackList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getStockCountIssueTrackDAO().saveStockCountIssueTrackList(mergedUpdateStockCountIssueTrackList,options);

		if(stockCountIssueTrackList.getToRemoveList() != null){
			stockCountIssueTrackList.removeAll(stockCountIssueTrackList.getToRemoveList());
		}


		return goodsShelfStockCount;

	}

	protected GoodsShelfStockCount removeStockCountIssueTrackList(GoodsShelfStockCount goodsShelfStockCount, Map<String,Object> options){


		SmartList<StockCountIssueTrack> stockCountIssueTrackList = goodsShelfStockCount.getStockCountIssueTrackList();
		if(stockCountIssueTrackList == null){
			return goodsShelfStockCount;
		}

		SmartList<StockCountIssueTrack> toRemoveStockCountIssueTrackList = stockCountIssueTrackList.getToRemoveList();

		if(toRemoveStockCountIssueTrackList == null){
			return goodsShelfStockCount;
		}
		if(toRemoveStockCountIssueTrackList.isEmpty()){
			return goodsShelfStockCount;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getStockCountIssueTrackDAO().removeStockCountIssueTrackList(toRemoveStockCountIssueTrackList,options);

		return goodsShelfStockCount;

	}








		

	public GoodsShelfStockCount present(GoodsShelfStockCount goodsShelfStockCount,Map<String, Object> options){

		presentStockCountIssueTrackList(goodsShelfStockCount,options);

		return goodsShelfStockCount;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected GoodsShelfStockCount presentStockCountIssueTrackList(
			GoodsShelfStockCount goodsShelfStockCount,
			Map<String, Object> options) {
    
		SmartList<StockCountIssueTrack> stockCountIssueTrackList = goodsShelfStockCount.getStockCountIssueTrackList();
				SmartList<StockCountIssueTrack> newList= presentSubList(goodsShelfStockCount.getId(),
				stockCountIssueTrackList,
				options,
				getStockCountIssueTrackDAO()::countStockCountIssueTrackByStockCount,
				getStockCountIssueTrackDAO()::findStockCountIssueTrackByStockCount
				);


		goodsShelfStockCount.setStockCountIssueTrackList(newList);


		return goodsShelfStockCount;
	}
		

	
    public SmartList<GoodsShelfStockCount> requestCandidateGoodsShelfStockCountForStockCountIssueTrack(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(GoodsShelfStockCountTable.COLUMN_TITLE, GoodsShelfStockCountTable.COLUMN_SHELF, filterKey, pageNo, pageSize, getGoodsShelfStockCountMapper());
    }
		

	protected String getTableName(){
		return GoodsShelfStockCountTable.TABLE_NAME;
	}



	public void enhanceList(List<GoodsShelfStockCount> goodsShelfStockCountList) {
		this.enhanceListInternal(goodsShelfStockCountList, this.getGoodsShelfStockCountMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:StockCountIssueTrack的stockCount的StockCountIssueTrackList
	public SmartList<StockCountIssueTrack> loadOurStockCountIssueTrackList(RetailscmUserContext userContext, List<GoodsShelfStockCount> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(StockCountIssueTrack.STOCK_COUNT_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<StockCountIssueTrack> loadedObjs = userContext.getDAOGroup().getStockCountIssueTrackDAO().findStockCountIssueTrackWithKey(key, options);
		Map<String, List<StockCountIssueTrack>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getStockCount().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<StockCountIssueTrack> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<StockCountIssueTrack> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setStockCountIssueTrackList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<GoodsShelfStockCount> goodsShelfStockCountList = ownerEntity.collectRefsWithType(GoodsShelfStockCount.INTERNAL_TYPE);
		this.enhanceList(goodsShelfStockCountList);

	}

	@Override
	public SmartList<GoodsShelfStockCount> findGoodsShelfStockCountWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getGoodsShelfStockCountMapper());

	}
	@Override
	public int countGoodsShelfStockCountWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countGoodsShelfStockCountWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<GoodsShelfStockCount> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getGoodsShelfStockCountMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<GoodsShelfStockCount> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getGoodsShelfStockCountMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateGoodsShelfStockCount executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateGoodsShelfStockCount result = new CandidateGoodsShelfStockCount();
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
  public List<GoodsShelfStockCount> search(GoodsShelfStockCountRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected GoodsShelfStockCountMapper mapper() {
    return getGoodsShelfStockCountMapper();
  }
}


