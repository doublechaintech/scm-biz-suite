
package com.doublechaintech.retailscm.supplyordershipment;

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

public class SupplyOrderShipmentJDBCTemplateDAO extends RetailscmNamingServiceDAO implements SupplyOrderShipmentDAO{


			
		
	
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
	protected SupplyOrderShipment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderShipment(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SupplyOrderShipment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderShipment(SupplyOrderShipmentTable.withId(id), options);
	}
	
	
	
	public SupplyOrderShipment save(SupplyOrderShipment supplyOrderShipment,Map<String,Object> options){
		
		String methodName="save(SupplyOrderShipment supplyOrderShipment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderShipment, methodName, "supplyOrderShipment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderShipment(supplyOrderShipment,options);
	}
	public SupplyOrderShipment clone(String supplyOrderShipmentId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderShipmentTable.withId(supplyOrderShipmentId),options);
	}
	
	protected SupplyOrderShipment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderShipmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderShipment newSupplyOrderShipment = loadInternalSupplyOrderShipment(accessKey, options);
		newSupplyOrderShipment.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newSupplyOrderShipment.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderShipment.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderShipment(newSupplyOrderShipment,options);
		
		return newSupplyOrderShipment;
	}
	
	
	
	

	protected void throwIfHasException(String supplyOrderShipmentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SupplyOrderShipmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderShipmentNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderShipmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String supplyOrderShipmentId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderShipmentId, int version)";
		assertMethodArgumentNotNull(supplyOrderShipmentId, methodName, "supplyOrderShipmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderShipmentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderShipmentId,version);
		}
		
	
	}
	
	
	
	
	

	public SupplyOrderShipment disconnectFromAll(String supplyOrderShipmentId, int version) throws Exception{
	
		
		SupplyOrderShipment supplyOrderShipment = loadInternalSupplyOrderShipment(SupplyOrderShipmentTable.withId(supplyOrderShipmentId), emptyOptions());
		supplyOrderShipment.clearFromAll();
		this.saveSupplyOrderShipment(supplyOrderShipment);
		return supplyOrderShipment;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SupplyOrderShipmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_shipment";
	}
	@Override
	protected String getBeanName() {
		
		return "supplyOrderShipment";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderShipmentTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SupplyOrderShipmentTokens.CONSUMER_ORDER_LIST);
 	}
 	protected boolean isAnalyzeConsumerOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SupplyOrderShipmentTokens.CONSUMER_ORDER_LIST+".analyze");
 	}

	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderShipmentTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SupplyOrderShipmentTokens.SUPPLY_ORDER_LIST);
 	}
 	protected boolean isAnalyzeSupplyOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SupplyOrderShipmentTokens.SUPPLY_ORDER_LIST+".analyze");
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderShipmentTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
		

	

	protected SupplyOrderShipmentMapper getSupplyOrderShipmentMapper(){
		return new SupplyOrderShipmentMapper();
	}

	
	
	protected SupplyOrderShipment extractSupplyOrderShipment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SupplyOrderShipment supplyOrderShipment = loadSingleObject(accessKey, getSupplyOrderShipmentMapper());
			return supplyOrderShipment;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderShipmentNotFoundException("SupplyOrderShipment("+accessKey+") is not found!");
		}

	}

	
	

	protected SupplyOrderShipment loadInternalSupplyOrderShipment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderShipment supplyOrderShipment = extractSupplyOrderShipment(accessKey, loadOptions);

		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(supplyOrderShipment, loadOptions);
 		}	
 		if(isAnalyzeConsumerOrderListEnabled(loadOptions)){
	 		// analyzeConsumerOrderList(supplyOrderShipment, loadOptions);
 		}
 		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderShipment, loadOptions);
 		}	
 		if(isAnalyzeSupplyOrderListEnabled(loadOptions)){
	 		// analyzeSupplyOrderList(supplyOrderShipment, loadOptions);
 		}
 		
		
		return supplyOrderShipment;
		
	}

	
		
	protected void enhanceConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SupplyOrderShipment extractConsumerOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
		
		
		if(supplyOrderShipment == null){
			return null;
		}
		if(supplyOrderShipment.getId() == null){
			return supplyOrderShipment;
		}

		
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByShipment(supplyOrderShipment.getId(),options);
		if(consumerOrderList != null){
			enhanceConsumerOrderList(consumerOrderList,options);
			supplyOrderShipment.setConsumerOrderList(consumerOrderList);
		}
		
		return supplyOrderShipment;
	
	}	
	
	protected SupplyOrderShipment analyzeConsumerOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
		
		
		if(supplyOrderShipment == null){
			return null;
		}
		if(supplyOrderShipment.getId() == null){
			return supplyOrderShipment;
		}

		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderShipment.getConsumerOrderList();
		if(consumerOrderList != null){
			getConsumerOrderDAO().analyzeConsumerOrderByShipment(consumerOrderList, supplyOrderShipment.getId(), options);
			
		}
		
		return supplyOrderShipment;
	
	}	
	
		
	protected void enhanceSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SupplyOrderShipment extractSupplyOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
		
		
		if(supplyOrderShipment == null){
			return null;
		}
		if(supplyOrderShipment.getId() == null){
			return supplyOrderShipment;
		}

		
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByShipment(supplyOrderShipment.getId(),options);
		if(supplyOrderList != null){
			enhanceSupplyOrderList(supplyOrderList,options);
			supplyOrderShipment.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderShipment;
	
	}	
	
	protected SupplyOrderShipment analyzeSupplyOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
		
		
		if(supplyOrderShipment == null){
			return null;
		}
		if(supplyOrderShipment.getId() == null){
			return supplyOrderShipment;
		}

		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderShipment.getSupplyOrderList();
		if(supplyOrderList != null){
			getSupplyOrderDAO().analyzeSupplyOrderByShipment(supplyOrderList, supplyOrderShipment.getId(), options);
			
		}
		
		return supplyOrderShipment;
	
	}	
	
		
		
 	
		
		
		

	

	protected SupplyOrderShipment saveSupplyOrderShipment(SupplyOrderShipment  supplyOrderShipment){
		
		if(!supplyOrderShipment.isChanged()){
			return supplyOrderShipment;
		}
		
		
		String SQL=this.getSaveSupplyOrderShipmentSQL(supplyOrderShipment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderShipmentParameters(supplyOrderShipment);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderShipment.incVersion();
		return supplyOrderShipment;
	
	}
	public SmartList<SupplyOrderShipment> saveSupplyOrderShipmentList(SmartList<SupplyOrderShipment> supplyOrderShipmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderShipmentList(supplyOrderShipmentList);
		
		batchSupplyOrderShipmentCreate((List<SupplyOrderShipment>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderShipmentUpdate((List<SupplyOrderShipment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderShipment supplyOrderShipment:supplyOrderShipmentList){
			if(supplyOrderShipment.isChanged()){
				supplyOrderShipment.incVersion();
			}
			
		
		}
		
		
		return supplyOrderShipmentList;
	}

	public SmartList<SupplyOrderShipment> removeSupplyOrderShipmentList(SmartList<SupplyOrderShipment> supplyOrderShipmentList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderShipmentList, options);
		
		return supplyOrderShipmentList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderShipmentBatchCreateArgs(List<SupplyOrderShipment> supplyOrderShipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderShipment supplyOrderShipment:supplyOrderShipmentList ){
			Object [] parameters = prepareSupplyOrderShipmentCreateParameters(supplyOrderShipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderShipmentBatchUpdateArgs(List<SupplyOrderShipment> supplyOrderShipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderShipment supplyOrderShipment:supplyOrderShipmentList ){
			if(!supplyOrderShipment.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderShipmentUpdateParameters(supplyOrderShipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderShipmentCreate(List<SupplyOrderShipment> supplyOrderShipmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderShipmentBatchCreateArgs(supplyOrderShipmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderShipmentUpdate(List<SupplyOrderShipment> supplyOrderShipmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderShipmentBatchUpdateArgs(supplyOrderShipmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderShipmentList(List<SupplyOrderShipment> supplyOrderShipmentList){
		
		List<SupplyOrderShipment> supplyOrderShipmentCreateList=new ArrayList<SupplyOrderShipment>();
		List<SupplyOrderShipment> supplyOrderShipmentUpdateList=new ArrayList<SupplyOrderShipment>();
		
		for(SupplyOrderShipment supplyOrderShipment: supplyOrderShipmentList){
			if(isUpdateRequest(supplyOrderShipment)){
				supplyOrderShipmentUpdateList.add( supplyOrderShipment);
				continue;
			}
			supplyOrderShipmentCreateList.add(supplyOrderShipment);
		}
		
		return new Object[]{supplyOrderShipmentCreateList,supplyOrderShipmentUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderShipment supplyOrderShipment){
 		return supplyOrderShipment.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderShipmentSQL(SupplyOrderShipment supplyOrderShipment){
 		if(isUpdateRequest(supplyOrderShipment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderShipmentParameters(SupplyOrderShipment supplyOrderShipment){
 		if(isUpdateRequest(supplyOrderShipment) ){
 			return prepareSupplyOrderShipmentUpdateParameters(supplyOrderShipment);
 		}
 		return prepareSupplyOrderShipmentCreateParameters(supplyOrderShipment);
 	}
 	protected Object[] prepareSupplyOrderShipmentUpdateParameters(SupplyOrderShipment supplyOrderShipment){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = supplyOrderShipment.getWho();
 		parameters[1] = supplyOrderShipment.getShipTime();		
 		parameters[2] = supplyOrderShipment.nextVersion();
 		parameters[3] = supplyOrderShipment.getId();
 		parameters[4] = supplyOrderShipment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderShipmentCreateParameters(SupplyOrderShipment supplyOrderShipment){
		Object[] parameters = new Object[3];
		String newSupplyOrderShipmentId=getNextId();
		supplyOrderShipment.setId(newSupplyOrderShipmentId);
		parameters[0] =  supplyOrderShipment.getId();
 
 		parameters[1] = supplyOrderShipment.getWho();
 		parameters[2] = supplyOrderShipment.getShipTime();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderShipment saveInternalSupplyOrderShipment(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
		
		saveSupplyOrderShipment(supplyOrderShipment);

		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(supplyOrderShipment, options);
	 		//removeConsumerOrderList(supplyOrderShipment, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderShipment, options);
	 		//removeSupplyOrderList(supplyOrderShipment, options);
	 		//Not delete the record
	 		
 		}		
		
		return supplyOrderShipment;
		
	}
	
	
	
	//======================================================================================
	

	
	public SupplyOrderShipment planToRemoveConsumerOrderList(SupplyOrderShipment supplyOrderShipment, String consumerOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.SHIPMENT_PROPERTY, supplyOrderShipment.getId());
		key.put(ConsumerOrder.ID_PROPERTY, consumerOrderIds);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderShipment;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderShipment;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){

			consumerOrder.clearFromAll();
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderShipment.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderShipment;	
	
	}


	//disconnect SupplyOrderShipment with consumer in ConsumerOrder
	public SupplyOrderShipment planToRemoveConsumerOrderListWithConsumer(SupplyOrderShipment supplyOrderShipment, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.SHIPMENT_PROPERTY, supplyOrderShipment.getId());
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderShipment;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderShipment;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){
			consumerOrder.clearConsumer();
			consumerOrder.clearShipment();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderShipment.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderShipment;
	}
	
	public int countConsumerOrderListWithConsumer(String supplyOrderShipmentId, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.SHIPMENT_PROPERTY, supplyOrderShipmentId);
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderShipment with store in ConsumerOrder
	public SupplyOrderShipment planToRemoveConsumerOrderListWithStore(SupplyOrderShipment supplyOrderShipment, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.SHIPMENT_PROPERTY, supplyOrderShipment.getId());
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderShipment;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderShipment;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){
			consumerOrder.clearStore();
			consumerOrder.clearShipment();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderShipment.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderShipment;
	}
	
	public int countConsumerOrderListWithStore(String supplyOrderShipmentId, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.SHIPMENT_PROPERTY, supplyOrderShipmentId);
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	public SupplyOrderShipment planToRemoveSupplyOrderList(SupplyOrderShipment supplyOrderShipment, String supplyOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.SHIPMENT_PROPERTY, supplyOrderShipment.getId());
		key.put(SupplyOrder.ID_PROPERTY, supplyOrderIds);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderShipment;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderShipment;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){

			supplyOrder.clearFromAll();
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderShipment.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderShipment;	
	
	}


	//disconnect SupplyOrderShipment with buyer in SupplyOrder
	public SupplyOrderShipment planToRemoveSupplyOrderListWithBuyer(SupplyOrderShipment supplyOrderShipment, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.SHIPMENT_PROPERTY, supplyOrderShipment.getId());
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderShipment;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderShipment;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){
			supplyOrder.clearBuyer();
			supplyOrder.clearShipment();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderShipment.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderShipment;
	}
	
	public int countSupplyOrderListWithBuyer(String supplyOrderShipmentId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.SHIPMENT_PROPERTY, supplyOrderShipmentId);
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderShipment with seller in SupplyOrder
	public SupplyOrderShipment planToRemoveSupplyOrderListWithSeller(SupplyOrderShipment supplyOrderShipment, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.SHIPMENT_PROPERTY, supplyOrderShipment.getId());
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderShipment;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderShipment;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){
			supplyOrder.clearSeller();
			supplyOrder.clearShipment();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderShipment.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderShipment;
	}
	
	public int countSupplyOrderListWithSeller(String supplyOrderShipmentId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.SHIPMENT_PROPERTY, supplyOrderShipmentId);
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	

		
	protected SupplyOrderShipment saveConsumerOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
		
		
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderShipment.getConsumerOrderList();
		if(consumerOrderList == null){
			//null list means nothing
			return supplyOrderShipment;
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
		
		
		return supplyOrderShipment;
	
	}
	
	protected SupplyOrderShipment removeConsumerOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderShipment.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderShipment;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return supplyOrderShipment;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return supplyOrderShipment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return supplyOrderShipment;
	
	}
	
	

 	
 	
	
	
	
		
	protected SupplyOrderShipment saveSupplyOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
		
		
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderShipment.getSupplyOrderList();
		if(supplyOrderList == null){
			//null list means nothing
			return supplyOrderShipment;
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
		
		
		return supplyOrderShipment;
	
	}
	
	protected SupplyOrderShipment removeSupplyOrderList(SupplyOrderShipment supplyOrderShipment, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderShipment.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderShipment;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderShipment;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderShipment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderShipment;
	
	}
	
	

 	
 	
	
	
	
		

	public SupplyOrderShipment present(SupplyOrderShipment supplyOrderShipment,Map<String, Object> options){
	
		presentConsumerOrderList(supplyOrderShipment,options);
		presentSupplyOrderList(supplyOrderShipment,options);

		return supplyOrderShipment;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderShipment presentConsumerOrderList(
			SupplyOrderShipment supplyOrderShipment,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = supplyOrderShipment.getConsumerOrderList();		
				SmartList<ConsumerOrder> newList= presentSubList(supplyOrderShipment.getId(),
				consumerOrderList,
				options,
				getConsumerOrderDAO()::countConsumerOrderByShipment,
				getConsumerOrderDAO()::findConsumerOrderByShipment
				);

		
		supplyOrderShipment.setConsumerOrderList(newList);
		

		return supplyOrderShipment;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderShipment presentSupplyOrderList(
			SupplyOrderShipment supplyOrderShipment,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderShipment.getSupplyOrderList();		
				SmartList<SupplyOrder> newList= presentSubList(supplyOrderShipment.getId(),
				supplyOrderList,
				options,
				getSupplyOrderDAO()::countSupplyOrderByShipment,
				getSupplyOrderDAO()::findSupplyOrderByShipment
				);

		
		supplyOrderShipment.setSupplyOrderList(newList);
		

		return supplyOrderShipment;
	}			
		

	
    public SmartList<SupplyOrderShipment> requestCandidateSupplyOrderShipmentForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderShipmentTable.COLUMN_WHO, filterKey, pageNo, pageSize, getSupplyOrderShipmentMapper());
    }
		
    public SmartList<SupplyOrderShipment> requestCandidateSupplyOrderShipmentForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderShipmentTable.COLUMN_WHO, filterKey, pageNo, pageSize, getSupplyOrderShipmentMapper());
    }
		

	protected String getTableName(){
		return SupplyOrderShipmentTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SupplyOrderShipment> supplyOrderShipmentList) {		
		this.enhanceListInternal(supplyOrderShipmentList, this.getSupplyOrderShipmentMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SupplyOrderShipment> supplyOrderShipmentList = ownerEntity.collectRefsWithType(SupplyOrderShipment.INTERNAL_TYPE);
		this.enhanceList(supplyOrderShipmentList);
		
	}
	
	@Override
	public SmartList<SupplyOrderShipment> findSupplyOrderShipmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSupplyOrderShipmentMapper());

	}
	@Override
	public int countSupplyOrderShipmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSupplyOrderShipmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SupplyOrderShipment> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSupplyOrderShipmentMapper());
	}
}


