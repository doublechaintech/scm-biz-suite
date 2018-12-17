
package com.doublechaintech.retailscm.supplyorderapproval;

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


import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class SupplyOrderApprovalJDBCTemplateDAO extends RetailscmNamingServiceDAO implements SupplyOrderApprovalDAO{


			
		
	
  	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO pConsumerOrderDAO){
 	
 		if(pConsumerOrderDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderDAO to null.");
 		}
	 	this.consumerOrderDAO = pConsumerOrderDAO;
 	}
 	public ConsumerOrderDAO getConsumerOrderDAO(){
 		if(this.consumerOrderDAO == null){
 			throw new IllegalStateException("The consumerOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderDAO;
 	}	
 	
			
		
	
  	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO pSupplyOrderDAO){
 	
 		if(pSupplyOrderDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderDAO to null.");
 		}
	 	this.supplyOrderDAO = pSupplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
 		if(this.supplyOrderDAO == null){
 			throw new IllegalStateException("The supplyOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderDAO;
 	}	
 	
			
		

	
	/*
	protected SupplyOrderApproval load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderApproval(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SupplyOrderApproval load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderApproval(SupplyOrderApprovalTable.withId(id), options);
	}
	
	
	
	public SupplyOrderApproval save(SupplyOrderApproval supplyOrderApproval,Map<String,Object> options){
		
		String methodName="save(SupplyOrderApproval supplyOrderApproval,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderApproval, methodName, "supplyOrderApproval");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderApproval(supplyOrderApproval,options);
	}
	public SupplyOrderApproval clone(String supplyOrderApprovalId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderApprovalTable.withId(supplyOrderApprovalId),options);
	}
	
	protected SupplyOrderApproval clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderApprovalId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderApproval newSupplyOrderApproval = loadInternalSupplyOrderApproval(accessKey, options);
		newSupplyOrderApproval.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newSupplyOrderApproval.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderApproval.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderApproval(newSupplyOrderApproval,options);
		
		return newSupplyOrderApproval;
	}
	
	
	
	

	protected void throwIfHasException(String supplyOrderApprovalId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SupplyOrderApprovalVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderApprovalNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderApprovalId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String supplyOrderApprovalId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderApprovalId, int version)";
		assertMethodArgumentNotNull(supplyOrderApprovalId, methodName, "supplyOrderApprovalId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderApprovalId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderApprovalId,version);
		}
		
	
	}
	
	
	
	
	

	public SupplyOrderApproval disconnectFromAll(String supplyOrderApprovalId, int version) throws Exception{
	
		
		SupplyOrderApproval supplyOrderApproval = loadInternalSupplyOrderApproval(SupplyOrderApprovalTable.withId(supplyOrderApprovalId), emptyOptions());
		supplyOrderApproval.clearFromAll();
		this.saveSupplyOrderApproval(supplyOrderApproval);
		return supplyOrderApproval;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SupplyOrderApprovalTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_approval";
	}
	@Override
	protected String getBeanName() {
		
		return "supplyOrderApproval";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderApprovalTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderApprovalTokens.CONSUMER_ORDER_LIST);
		
 	}

	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderApprovalTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
 	
			
		
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderApprovalTokens.SUPPLY_ORDER_LIST);
		
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderApprovalTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplyOrderApprovalMapper getSupplyOrderApprovalMapper(){
		return new SupplyOrderApprovalMapper();
	}

	
	
	protected SupplyOrderApproval extractSupplyOrderApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SupplyOrderApproval supplyOrderApproval = loadSingleObject(accessKey, getSupplyOrderApprovalMapper());
			return supplyOrderApproval;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderApprovalNotFoundException("SupplyOrderApproval("+accessKey+") is not found!");
		}

	}

	
	

	protected SupplyOrderApproval loadInternalSupplyOrderApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderApproval supplyOrderApproval = extractSupplyOrderApproval(accessKey, loadOptions);

		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(supplyOrderApproval, loadOptions);
 		}		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderApproval, loadOptions);
 		}		
		
		return supplyOrderApproval;
		
	}



	
	
	
		
	protected void enhanceConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected SupplyOrderApproval extractConsumerOrderList(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
		
		
		if(supplyOrderApproval == null){
			return null;
		}
		if(supplyOrderApproval.getId() == null){
			return supplyOrderApproval;
		}

		
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByApproval(supplyOrderApproval.getId(),options);
		if(consumerOrderList != null){
			enhanceConsumerOrderList(consumerOrderList,options);
			supplyOrderApproval.setConsumerOrderList(consumerOrderList);
		}
		
		return supplyOrderApproval;
	
	}	
		
	protected void enhanceSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected SupplyOrderApproval extractSupplyOrderList(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
		
		
		if(supplyOrderApproval == null){
			return null;
		}
		if(supplyOrderApproval.getId() == null){
			return supplyOrderApproval;
		}

		
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByApproval(supplyOrderApproval.getId(),options);
		if(supplyOrderList != null){
			enhanceSupplyOrderList(supplyOrderList,options);
			supplyOrderApproval.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderApproval;
	
	}	
		
		
 	
		
		
		

	

	protected SupplyOrderApproval saveSupplyOrderApproval(SupplyOrderApproval  supplyOrderApproval){
		
		if(!supplyOrderApproval.isChanged()){
			return supplyOrderApproval;
		}
		
		
		String SQL=this.getSaveSupplyOrderApprovalSQL(supplyOrderApproval);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderApprovalParameters(supplyOrderApproval);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderApproval.incVersion();
		return supplyOrderApproval;
	
	}
	public SmartList<SupplyOrderApproval> saveSupplyOrderApprovalList(SmartList<SupplyOrderApproval> supplyOrderApprovalList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderApprovalList(supplyOrderApprovalList);
		
		batchSupplyOrderApprovalCreate((List<SupplyOrderApproval>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderApprovalUpdate((List<SupplyOrderApproval>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderApproval supplyOrderApproval:supplyOrderApprovalList){
			if(supplyOrderApproval.isChanged()){
				supplyOrderApproval.incVersion();
			}
			
		
		}
		
		
		return supplyOrderApprovalList;
	}

	public SmartList<SupplyOrderApproval> removeSupplyOrderApprovalList(SmartList<SupplyOrderApproval> supplyOrderApprovalList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderApprovalList, options);
		
		return supplyOrderApprovalList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderApprovalBatchCreateArgs(List<SupplyOrderApproval> supplyOrderApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderApproval supplyOrderApproval:supplyOrderApprovalList ){
			Object [] parameters = prepareSupplyOrderApprovalCreateParameters(supplyOrderApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderApprovalBatchUpdateArgs(List<SupplyOrderApproval> supplyOrderApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderApproval supplyOrderApproval:supplyOrderApprovalList ){
			if(!supplyOrderApproval.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderApprovalUpdateParameters(supplyOrderApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderApprovalCreate(List<SupplyOrderApproval> supplyOrderApprovalList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderApprovalBatchCreateArgs(supplyOrderApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderApprovalUpdate(List<SupplyOrderApproval> supplyOrderApprovalList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderApprovalBatchUpdateArgs(supplyOrderApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderApprovalList(List<SupplyOrderApproval> supplyOrderApprovalList){
		
		List<SupplyOrderApproval> supplyOrderApprovalCreateList=new ArrayList<SupplyOrderApproval>();
		List<SupplyOrderApproval> supplyOrderApprovalUpdateList=new ArrayList<SupplyOrderApproval>();
		
		for(SupplyOrderApproval supplyOrderApproval: supplyOrderApprovalList){
			if(isUpdateRequest(supplyOrderApproval)){
				supplyOrderApprovalUpdateList.add( supplyOrderApproval);
				continue;
			}
			supplyOrderApprovalCreateList.add(supplyOrderApproval);
		}
		
		return new Object[]{supplyOrderApprovalCreateList,supplyOrderApprovalUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderApproval supplyOrderApproval){
 		return supplyOrderApproval.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderApprovalSQL(SupplyOrderApproval supplyOrderApproval){
 		if(isUpdateRequest(supplyOrderApproval)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderApprovalParameters(SupplyOrderApproval supplyOrderApproval){
 		if(isUpdateRequest(supplyOrderApproval) ){
 			return prepareSupplyOrderApprovalUpdateParameters(supplyOrderApproval);
 		}
 		return prepareSupplyOrderApprovalCreateParameters(supplyOrderApproval);
 	}
 	protected Object[] prepareSupplyOrderApprovalUpdateParameters(SupplyOrderApproval supplyOrderApproval){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = supplyOrderApproval.getWho();
 		parameters[1] = supplyOrderApproval.getApproveTime();		
 		parameters[2] = supplyOrderApproval.nextVersion();
 		parameters[3] = supplyOrderApproval.getId();
 		parameters[4] = supplyOrderApproval.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderApprovalCreateParameters(SupplyOrderApproval supplyOrderApproval){
		Object[] parameters = new Object[3];
		String newSupplyOrderApprovalId=getNextId();
		supplyOrderApproval.setId(newSupplyOrderApprovalId);
		parameters[0] =  supplyOrderApproval.getId();
 
 		parameters[1] = supplyOrderApproval.getWho();
 		parameters[2] = supplyOrderApproval.getApproveTime();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderApproval saveInternalSupplyOrderApproval(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
		
		saveSupplyOrderApproval(supplyOrderApproval);

		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(supplyOrderApproval, options);
	 		//removeConsumerOrderList(supplyOrderApproval, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderApproval, options);
	 		//removeSupplyOrderList(supplyOrderApproval, options);
	 		//Not delete the record
	 		
 		}		
		
		return supplyOrderApproval;
		
	}
	
	
	
	//======================================================================================
	

	
	public SupplyOrderApproval planToRemoveConsumerOrderList(SupplyOrderApproval supplyOrderApproval, String consumerOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.APPROVAL_PROPERTY, supplyOrderApproval.getId());
		key.put(ConsumerOrder.ID_PROPERTY, consumerOrderIds);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderApproval;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderApproval;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){

			consumerOrder.clearFromAll();
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderApproval.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderApproval;	
	
	}


	//disconnect SupplyOrderApproval with consumer in ConsumerOrder
	public SupplyOrderApproval planToRemoveConsumerOrderListWithConsumer(SupplyOrderApproval supplyOrderApproval, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.APPROVAL_PROPERTY, supplyOrderApproval.getId());
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderApproval;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderApproval;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){
			consumerOrder.clearConsumer();
			consumerOrder.clearApproval();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderApproval.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderApproval;
	}
	
	public int countConsumerOrderListWithConsumer(String supplyOrderApprovalId, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.APPROVAL_PROPERTY, supplyOrderApprovalId);
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderApproval with store in ConsumerOrder
	public SupplyOrderApproval planToRemoveConsumerOrderListWithStore(SupplyOrderApproval supplyOrderApproval, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.APPROVAL_PROPERTY, supplyOrderApproval.getId());
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderApproval;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderApproval;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){
			consumerOrder.clearStore();
			consumerOrder.clearApproval();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderApproval.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderApproval;
	}
	
	public int countConsumerOrderListWithStore(String supplyOrderApprovalId, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.APPROVAL_PROPERTY, supplyOrderApprovalId);
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	public SupplyOrderApproval planToRemoveSupplyOrderList(SupplyOrderApproval supplyOrderApproval, String supplyOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.APPROVAL_PROPERTY, supplyOrderApproval.getId());
		key.put(SupplyOrder.ID_PROPERTY, supplyOrderIds);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderApproval;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderApproval;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){

			supplyOrder.clearFromAll();
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderApproval.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderApproval;	
	
	}


	//disconnect SupplyOrderApproval with buyer in SupplyOrder
	public SupplyOrderApproval planToRemoveSupplyOrderListWithBuyer(SupplyOrderApproval supplyOrderApproval, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.APPROVAL_PROPERTY, supplyOrderApproval.getId());
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderApproval;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderApproval;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){
			supplyOrder.clearBuyer();
			supplyOrder.clearApproval();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderApproval.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderApproval;
	}
	
	public int countSupplyOrderListWithBuyer(String supplyOrderApprovalId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.APPROVAL_PROPERTY, supplyOrderApprovalId);
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderApproval with seller in SupplyOrder
	public SupplyOrderApproval planToRemoveSupplyOrderListWithSeller(SupplyOrderApproval supplyOrderApproval, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.APPROVAL_PROPERTY, supplyOrderApproval.getId());
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderApproval;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderApproval;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){
			supplyOrder.clearSeller();
			supplyOrder.clearApproval();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderApproval.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderApproval;
	}
	
	public int countSupplyOrderListWithSeller(String supplyOrderApprovalId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.APPROVAL_PROPERTY, supplyOrderApprovalId);
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	

		
	protected SupplyOrderApproval saveConsumerOrderList(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
		
		
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderApproval.getConsumerOrderList();
		if(consumerOrderList == null){
			//null list means nothing
			return supplyOrderApproval;
		}
		SmartList<ConsumerOrder> mergedUpdateConsumerOrderList = new SmartList<ConsumerOrder>();
		
		
		mergedUpdateConsumerOrderList.addAll(consumerOrderList); 
		if(consumerOrderList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateConsumerOrderList.addAll(consumerOrderList.getToRemoveList());
			consumerOrderList.removeAll(consumerOrderList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getConsumerOrderDAO().saveConsumerOrderList(mergedUpdateConsumerOrderList,options);
		
		if(consumerOrderList.getToRemoveList() != null){
			consumerOrderList.removeAll(consumerOrderList.getToRemoveList());
		}
		
		
		return supplyOrderApproval;
	
	}
	
	protected SupplyOrderApproval removeConsumerOrderList(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderApproval.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderApproval;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return supplyOrderApproval;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return supplyOrderApproval;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return supplyOrderApproval;
	
	}
	
	

 	
 	
	
	
	
		
	protected SupplyOrderApproval saveSupplyOrderList(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
		
		
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderApproval.getSupplyOrderList();
		if(supplyOrderList == null){
			//null list means nothing
			return supplyOrderApproval;
		}
		SmartList<SupplyOrder> mergedUpdateSupplyOrderList = new SmartList<SupplyOrder>();
		
		
		mergedUpdateSupplyOrderList.addAll(supplyOrderList); 
		if(supplyOrderList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSupplyOrderList.addAll(supplyOrderList.getToRemoveList());
			supplyOrderList.removeAll(supplyOrderList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getSupplyOrderDAO().saveSupplyOrderList(mergedUpdateSupplyOrderList,options);
		
		if(supplyOrderList.getToRemoveList() != null){
			supplyOrderList.removeAll(supplyOrderList.getToRemoveList());
		}
		
		
		return supplyOrderApproval;
	
	}
	
	protected SupplyOrderApproval removeSupplyOrderList(SupplyOrderApproval supplyOrderApproval, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderApproval.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderApproval;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderApproval;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderApproval;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderApproval;
	
	}
	
	

 	
 	
	
	
	
		

	public SupplyOrderApproval present(SupplyOrderApproval supplyOrderApproval,Map<String, Object> options){
	
		presentConsumerOrderList(supplyOrderApproval,options);
		presentSupplyOrderList(supplyOrderApproval,options);

		return supplyOrderApproval;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderApproval presentConsumerOrderList(
			SupplyOrderApproval supplyOrderApproval,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = supplyOrderApproval.getConsumerOrderList();		
				SmartList<ConsumerOrder> newList= presentSubList(supplyOrderApproval.getId(),
				consumerOrderList,
				options,
				getConsumerOrderDAO()::countConsumerOrderByApproval,
				getConsumerOrderDAO()::findConsumerOrderByApproval
				);

		
		supplyOrderApproval.setConsumerOrderList(newList);
		

		return supplyOrderApproval;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderApproval presentSupplyOrderList(
			SupplyOrderApproval supplyOrderApproval,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderApproval.getSupplyOrderList();		
				SmartList<SupplyOrder> newList= presentSubList(supplyOrderApproval.getId(),
				supplyOrderList,
				options,
				getSupplyOrderDAO()::countSupplyOrderByApproval,
				getSupplyOrderDAO()::findSupplyOrderByApproval
				);

		
		supplyOrderApproval.setSupplyOrderList(newList);
		

		return supplyOrderApproval;
	}			
		

	
    public SmartList<SupplyOrderApproval> requestCandidateSupplyOrderApprovalForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderApprovalTable.COLUMN_WHO, filterKey, pageNo, pageSize, getSupplyOrderApprovalMapper());
    }
		
    public SmartList<SupplyOrderApproval> requestCandidateSupplyOrderApprovalForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderApprovalTable.COLUMN_WHO, filterKey, pageNo, pageSize, getSupplyOrderApprovalMapper());
    }
		

	protected String getTableName(){
		return SupplyOrderApprovalTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SupplyOrderApproval> supplyOrderApprovalList) {		
		this.enhanceListInternal(supplyOrderApprovalList, this.getSupplyOrderApprovalMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SupplyOrderApproval> supplyOrderApprovalList = ownerEntity.collectRefsWithType(SupplyOrderApproval.INTERNAL_TYPE);
		this.enhanceList(supplyOrderApprovalList);
		
	}
	
	@Override
	public SmartList<SupplyOrderApproval> findSupplyOrderApprovalWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSupplyOrderApprovalMapper());

	}
	@Override
	public int countSupplyOrderApprovalWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSupplyOrderApprovalWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SupplyOrderApproval> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSupplyOrderApprovalMapper());
	}
}


