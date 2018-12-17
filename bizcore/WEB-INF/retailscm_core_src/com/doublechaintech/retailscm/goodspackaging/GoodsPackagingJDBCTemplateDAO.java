
package com.doublechaintech.retailscm.goodspackaging;

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


import com.doublechaintech.retailscm.goods.Goods;

import com.doublechaintech.retailscm.goods.GoodsDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class GoodsPackagingJDBCTemplateDAO extends RetailscmNamingServiceDAO implements GoodsPackagingDAO{


			
		
	
  	private  GoodsDAO  goodsDAO;
 	public void setGoodsDAO(GoodsDAO pGoodsDAO){
 	
 		if(pGoodsDAO == null){
 			throw new IllegalStateException("Do not try to set goodsDAO to null.");
 		}
	 	this.goodsDAO = pGoodsDAO;
 	}
 	public GoodsDAO getGoodsDAO(){
 		if(this.goodsDAO == null){
 			throw new IllegalStateException("The goodsDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsDAO;
 	}	
 	
			
		

	
	/*
	protected GoodsPackaging load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGoodsPackaging(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public GoodsPackaging load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGoodsPackaging(GoodsPackagingTable.withId(id), options);
	}
	
	
	
	public GoodsPackaging save(GoodsPackaging goodsPackaging,Map<String,Object> options){
		
		String methodName="save(GoodsPackaging goodsPackaging,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(goodsPackaging, methodName, "goodsPackaging");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalGoodsPackaging(goodsPackaging,options);
	}
	public GoodsPackaging clone(String goodsPackagingId, Map<String,Object> options) throws Exception{
	
		return clone(GoodsPackagingTable.withId(goodsPackagingId),options);
	}
	
	protected GoodsPackaging clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String goodsPackagingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		GoodsPackaging newGoodsPackaging = loadInternalGoodsPackaging(accessKey, options);
		newGoodsPackaging.setVersion(0);
		
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newGoodsPackaging.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalGoodsPackaging(newGoodsPackaging,options);
		
		return newGoodsPackaging;
	}
	
	
	
	

	protected void throwIfHasException(String goodsPackagingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new GoodsPackagingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GoodsPackagingNotFoundException(
					"The " + this.getTableName() + "(" + goodsPackagingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String goodsPackagingId, int version) throws Exception{
	
		String methodName="delete(String goodsPackagingId, int version)";
		assertMethodArgumentNotNull(goodsPackagingId, methodName, "goodsPackagingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{goodsPackagingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(goodsPackagingId,version);
		}
		
	
	}
	
	
	
	
	

	public GoodsPackaging disconnectFromAll(String goodsPackagingId, int version) throws Exception{
	
		
		GoodsPackaging goodsPackaging = loadInternalGoodsPackaging(GoodsPackagingTable.withId(goodsPackagingId), emptyOptions());
		goodsPackaging.clearFromAll();
		this.saveGoodsPackaging(goodsPackaging);
		return goodsPackaging;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return GoodsPackagingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "goods_packaging";
	}
	@Override
	protected String getBeanName() {
		
		return "goodsPackaging";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return GoodsPackagingTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,GoodsPackagingTokens.GOODS_LIST);
		
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsPackagingTokens.GOODS_LIST);
		
 	}
 	
 	
			
		

	

	protected GoodsPackagingMapper getGoodsPackagingMapper(){
		return new GoodsPackagingMapper();
	}

	
	
	protected GoodsPackaging extractGoodsPackaging(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			GoodsPackaging goodsPackaging = loadSingleObject(accessKey, getGoodsPackagingMapper());
			return goodsPackaging;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsPackagingNotFoundException("GoodsPackaging("+accessKey+") is not found!");
		}

	}

	
	

	protected GoodsPackaging loadInternalGoodsPackaging(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		GoodsPackaging goodsPackaging = extractGoodsPackaging(accessKey, loadOptions);

		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(goodsPackaging, loadOptions);
 		}		
		
		return goodsPackaging;
		
	}



	
	
	
		
	protected void enhanceGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected GoodsPackaging extractGoodsList(GoodsPackaging goodsPackaging, Map<String,Object> options){
		
		
		if(goodsPackaging == null){
			return null;
		}
		if(goodsPackaging.getId() == null){
			return goodsPackaging;
		}

		
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByPackaging(goodsPackaging.getId(),options);
		if(goodsList != null){
			enhanceGoodsList(goodsList,options);
			goodsPackaging.setGoodsList(goodsList);
		}
		
		return goodsPackaging;
	
	}	
		
		
 	
		
		
		

	

	protected GoodsPackaging saveGoodsPackaging(GoodsPackaging  goodsPackaging){
		
		if(!goodsPackaging.isChanged()){
			return goodsPackaging;
		}
		
		
		String SQL=this.getSaveGoodsPackagingSQL(goodsPackaging);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGoodsPackagingParameters(goodsPackaging);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		goodsPackaging.incVersion();
		return goodsPackaging;
	
	}
	public SmartList<GoodsPackaging> saveGoodsPackagingList(SmartList<GoodsPackaging> goodsPackagingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGoodsPackagingList(goodsPackagingList);
		
		batchGoodsPackagingCreate((List<GoodsPackaging>)lists[CREATE_LIST_INDEX]);
		
		batchGoodsPackagingUpdate((List<GoodsPackaging>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(GoodsPackaging goodsPackaging:goodsPackagingList){
			if(goodsPackaging.isChanged()){
				goodsPackaging.incVersion();
			}
			
		
		}
		
		
		return goodsPackagingList;
	}

	public SmartList<GoodsPackaging> removeGoodsPackagingList(SmartList<GoodsPackaging> goodsPackagingList,Map<String,Object> options){
		
		
		super.removeList(goodsPackagingList, options);
		
		return goodsPackagingList;
		
		
	}
	
	protected List<Object[]> prepareGoodsPackagingBatchCreateArgs(List<GoodsPackaging> goodsPackagingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsPackaging goodsPackaging:goodsPackagingList ){
			Object [] parameters = prepareGoodsPackagingCreateParameters(goodsPackaging);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareGoodsPackagingBatchUpdateArgs(List<GoodsPackaging> goodsPackagingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsPackaging goodsPackaging:goodsPackagingList ){
			if(!goodsPackaging.isChanged()){
				continue;
			}
			Object [] parameters = prepareGoodsPackagingUpdateParameters(goodsPackaging);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchGoodsPackagingCreate(List<GoodsPackaging> goodsPackagingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGoodsPackagingBatchCreateArgs(goodsPackagingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchGoodsPackagingUpdate(List<GoodsPackaging> goodsPackagingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGoodsPackagingBatchUpdateArgs(goodsPackagingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitGoodsPackagingList(List<GoodsPackaging> goodsPackagingList){
		
		List<GoodsPackaging> goodsPackagingCreateList=new ArrayList<GoodsPackaging>();
		List<GoodsPackaging> goodsPackagingUpdateList=new ArrayList<GoodsPackaging>();
		
		for(GoodsPackaging goodsPackaging: goodsPackagingList){
			if(isUpdateRequest(goodsPackaging)){
				goodsPackagingUpdateList.add( goodsPackaging);
				continue;
			}
			goodsPackagingCreateList.add(goodsPackaging);
		}
		
		return new Object[]{goodsPackagingCreateList,goodsPackagingUpdateList};
	}
	
	protected boolean isUpdateRequest(GoodsPackaging goodsPackaging){
 		return goodsPackaging.getVersion() > 0;
 	}
 	protected String getSaveGoodsPackagingSQL(GoodsPackaging goodsPackaging){
 		if(isUpdateRequest(goodsPackaging)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveGoodsPackagingParameters(GoodsPackaging goodsPackaging){
 		if(isUpdateRequest(goodsPackaging) ){
 			return prepareGoodsPackagingUpdateParameters(goodsPackaging);
 		}
 		return prepareGoodsPackagingCreateParameters(goodsPackaging);
 	}
 	protected Object[] prepareGoodsPackagingUpdateParameters(GoodsPackaging goodsPackaging){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = goodsPackaging.getPackageName();
 		parameters[1] = goodsPackaging.getRfid();
 		parameters[2] = goodsPackaging.getPackageTime();
 		parameters[3] = goodsPackaging.getDescription();		
 		parameters[4] = goodsPackaging.nextVersion();
 		parameters[5] = goodsPackaging.getId();
 		parameters[6] = goodsPackaging.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareGoodsPackagingCreateParameters(GoodsPackaging goodsPackaging){
		Object[] parameters = new Object[5];
		String newGoodsPackagingId=getNextId();
		goodsPackaging.setId(newGoodsPackagingId);
		parameters[0] =  goodsPackaging.getId();
 
 		parameters[1] = goodsPackaging.getPackageName();
 		parameters[2] = goodsPackaging.getRfid();
 		parameters[3] = goodsPackaging.getPackageTime();
 		parameters[4] = goodsPackaging.getDescription();		
 				
 		return parameters;
 	}
 	
	protected GoodsPackaging saveInternalGoodsPackaging(GoodsPackaging goodsPackaging, Map<String,Object> options){
		
		saveGoodsPackaging(goodsPackaging);

		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(goodsPackaging, options);
	 		//removeGoodsList(goodsPackaging, options);
	 		//Not delete the record
	 		
 		}		
		
		return goodsPackaging;
		
	}
	
	
	
	//======================================================================================
	

	
	public GoodsPackaging planToRemoveGoodsList(GoodsPackaging goodsPackaging, String goodsIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackaging.getId());
		key.put(Goods.ID_PROPERTY, goodsIds);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsPackaging;
		}
		if(externalGoodsList.isEmpty()){
			return goodsPackaging;
		}
		
		for(Goods goods: externalGoodsList){

			goods.clearFromAll();
		}
		
		
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsPackaging;	
	
	}


	//disconnect GoodsPackaging with sku in Goods
	public GoodsPackaging planToRemoveGoodsListWithSku(GoodsPackaging goodsPackaging, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackaging.getId());
		key.put(Goods.SKU_PROPERTY, skuId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsPackaging;
		}
		if(externalGoodsList.isEmpty()){
			return goodsPackaging;
		}
		
		for(Goods goods: externalGoodsList){
			goods.clearSku();
			goods.clearPackaging();
			
		}
		
		
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsPackaging;
	}
	
	public int countGoodsListWithSku(String goodsPackagingId, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackagingId);
		key.put(Goods.SKU_PROPERTY, skuId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsPackaging with receiving_space in Goods
	public GoodsPackaging planToRemoveGoodsListWithReceivingSpace(GoodsPackaging goodsPackaging, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackaging.getId());
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsPackaging;
		}
		if(externalGoodsList.isEmpty()){
			return goodsPackaging;
		}
		
		for(Goods goods: externalGoodsList){
			goods.clearReceivingSpace();
			goods.clearPackaging();
			
		}
		
		
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsPackaging;
	}
	
	public int countGoodsListWithReceivingSpace(String goodsPackagingId, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackagingId);
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsPackaging with goods_allocation in Goods
	public GoodsPackaging planToRemoveGoodsListWithGoodsAllocation(GoodsPackaging goodsPackaging, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackaging.getId());
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsPackaging;
		}
		if(externalGoodsList.isEmpty()){
			return goodsPackaging;
		}
		
		for(Goods goods: externalGoodsList){
			goods.clearGoodsAllocation();
			goods.clearPackaging();
			
		}
		
		
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsPackaging;
	}
	
	public int countGoodsListWithGoodsAllocation(String goodsPackagingId, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackagingId);
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsPackaging with smart_pallet in Goods
	public GoodsPackaging planToRemoveGoodsListWithSmartPallet(GoodsPackaging goodsPackaging, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackaging.getId());
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsPackaging;
		}
		if(externalGoodsList.isEmpty()){
			return goodsPackaging;
		}
		
		for(Goods goods: externalGoodsList){
			goods.clearSmartPallet();
			goods.clearPackaging();
			
		}
		
		
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsPackaging;
	}
	
	public int countGoodsListWithSmartPallet(String goodsPackagingId, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackagingId);
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsPackaging with shipping_space in Goods
	public GoodsPackaging planToRemoveGoodsListWithShippingSpace(GoodsPackaging goodsPackaging, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackaging.getId());
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsPackaging;
		}
		if(externalGoodsList.isEmpty()){
			return goodsPackaging;
		}
		
		for(Goods goods: externalGoodsList){
			goods.clearShippingSpace();
			goods.clearPackaging();
			
		}
		
		
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsPackaging;
	}
	
	public int countGoodsListWithShippingSpace(String goodsPackagingId, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackagingId);
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsPackaging with transport_task in Goods
	public GoodsPackaging planToRemoveGoodsListWithTransportTask(GoodsPackaging goodsPackaging, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackaging.getId());
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsPackaging;
		}
		if(externalGoodsList.isEmpty()){
			return goodsPackaging;
		}
		
		for(Goods goods: externalGoodsList){
			goods.clearTransportTask();
			goods.clearPackaging();
			
		}
		
		
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsPackaging;
	}
	
	public int countGoodsListWithTransportTask(String goodsPackagingId, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackagingId);
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsPackaging with retail_store in Goods
	public GoodsPackaging planToRemoveGoodsListWithRetailStore(GoodsPackaging goodsPackaging, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackaging.getId());
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsPackaging;
		}
		if(externalGoodsList.isEmpty()){
			return goodsPackaging;
		}
		
		for(Goods goods: externalGoodsList){
			goods.clearRetailStore();
			goods.clearPackaging();
			
		}
		
		
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsPackaging;
	}
	
	public int countGoodsListWithRetailStore(String goodsPackagingId, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackagingId);
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsPackaging with biz_order in Goods
	public GoodsPackaging planToRemoveGoodsListWithBizOrder(GoodsPackaging goodsPackaging, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackaging.getId());
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsPackaging;
		}
		if(externalGoodsList.isEmpty()){
			return goodsPackaging;
		}
		
		for(Goods goods: externalGoodsList){
			goods.clearBizOrder();
			goods.clearPackaging();
			
		}
		
		
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsPackaging;
	}
	
	public int countGoodsListWithBizOrder(String goodsPackagingId, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackagingId);
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsPackaging with retail_store_order in Goods
	public GoodsPackaging planToRemoveGoodsListWithRetailStoreOrder(GoodsPackaging goodsPackaging, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackaging.getId());
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsPackaging;
		}
		if(externalGoodsList.isEmpty()){
			return goodsPackaging;
		}
		
		for(Goods goods: externalGoodsList){
			goods.clearRetailStoreOrder();
			goods.clearPackaging();
			
		}
		
		
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsPackaging;
	}
	
	public int countGoodsListWithRetailStoreOrder(String goodsPackagingId, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.PACKAGING_PROPERTY, goodsPackagingId);
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	

		
	protected GoodsPackaging saveGoodsList(GoodsPackaging goodsPackaging, Map<String,Object> options){
		
		
		
		
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();
		if(goodsList == null){
			//null list means nothing
			return goodsPackaging;
		}
		SmartList<Goods> mergedUpdateGoodsList = new SmartList<Goods>();
		
		
		mergedUpdateGoodsList.addAll(goodsList); 
		if(goodsList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateGoodsList.addAll(goodsList.getToRemoveList());
			goodsList.removeAll(goodsList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getGoodsDAO().saveGoodsList(mergedUpdateGoodsList,options);
		
		if(goodsList.getToRemoveList() != null){
			goodsList.removeAll(goodsList.getToRemoveList());
		}
		
		
		return goodsPackaging;
	
	}
	
	protected GoodsPackaging removeGoodsList(GoodsPackaging goodsPackaging, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();
		if(goodsList == null){
			return goodsPackaging;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return goodsPackaging;
		}
		if(toRemoveGoodsList.isEmpty()){
			return goodsPackaging;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return goodsPackaging;
	
	}
	
	

 	
 	
	
	
	
		

	public GoodsPackaging present(GoodsPackaging goodsPackaging,Map<String, Object> options){
	
		presentGoodsList(goodsPackaging,options);

		return goodsPackaging;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected GoodsPackaging presentGoodsList(
			GoodsPackaging goodsPackaging,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = goodsPackaging.getGoodsList();		
				SmartList<Goods> newList= presentSubList(goodsPackaging.getId(),
				goodsList,
				options,
				getGoodsDAO()::countGoodsByPackaging,
				getGoodsDAO()::findGoodsByPackaging
				);

		
		goodsPackaging.setGoodsList(newList);
		

		return goodsPackaging;
	}			
		

	
    public SmartList<GoodsPackaging> requestCandidateGoodsPackagingForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(GoodsPackagingTable.COLUMN_PACKAGE_NAME, filterKey, pageNo, pageSize, getGoodsPackagingMapper());
    }
		

	protected String getTableName(){
		return GoodsPackagingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<GoodsPackaging> goodsPackagingList) {		
		this.enhanceListInternal(goodsPackagingList, this.getGoodsPackagingMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<GoodsPackaging> goodsPackagingList = ownerEntity.collectRefsWithType(GoodsPackaging.INTERNAL_TYPE);
		this.enhanceList(goodsPackagingList);
		
	}
	
	@Override
	public SmartList<GoodsPackaging> findGoodsPackagingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getGoodsPackagingMapper());

	}
	@Override
	public int countGoodsPackagingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countGoodsPackagingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<GoodsPackaging> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getGoodsPackagingMapper());
	}
}


