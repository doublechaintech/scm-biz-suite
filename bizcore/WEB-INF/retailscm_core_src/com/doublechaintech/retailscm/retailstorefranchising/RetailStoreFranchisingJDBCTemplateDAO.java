
package com.doublechaintech.retailscm.retailstorefranchising;

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


import com.doublechaintech.retailscm.retailstore.RetailStore;

import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreFranchisingJDBCTemplateDAO extends RetailscmNamingServiceDAO implements RetailStoreFranchisingDAO{


			
		
	
  	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO pRetailStoreDAO){
 	
 		if(pRetailStoreDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreDAO to null.");
 		}
	 	this.retailStoreDAO = pRetailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
 		if(this.retailStoreDAO == null){
 			throw new IllegalStateException("The retailStoreDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreDAO;
 	}	
 	
			
		

	
	/*
	protected RetailStoreFranchising load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreFranchising(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreFranchising load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreFranchising(RetailStoreFranchisingTable.withId(id), options);
	}
	
	
	
	public RetailStoreFranchising save(RetailStoreFranchising retailStoreFranchising,Map<String,Object> options){
		
		String methodName="save(RetailStoreFranchising retailStoreFranchising,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreFranchising, methodName, "retailStoreFranchising");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreFranchising(retailStoreFranchising,options);
	}
	public RetailStoreFranchising clone(String retailStoreFranchisingId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreFranchisingTable.withId(retailStoreFranchisingId),options);
	}
	
	protected RetailStoreFranchising clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreFranchisingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreFranchising newRetailStoreFranchising = loadInternalRetailStoreFranchising(accessKey, options);
		newRetailStoreFranchising.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreFranchising.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreFranchising(newRetailStoreFranchising,options);
		
		return newRetailStoreFranchising;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreFranchisingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreFranchisingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreFranchisingNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreFranchisingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreFranchisingId, int version) throws Exception{
	
		String methodName="delete(String retailStoreFranchisingId, int version)";
		assertMethodArgumentNotNull(retailStoreFranchisingId, methodName, "retailStoreFranchisingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreFranchisingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreFranchisingId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreFranchising disconnectFromAll(String retailStoreFranchisingId, int version) throws Exception{
	
		
		RetailStoreFranchising retailStoreFranchising = loadInternalRetailStoreFranchising(RetailStoreFranchisingTable.withId(retailStoreFranchisingId), emptyOptions());
		retailStoreFranchising.clearFromAll();
		this.saveRetailStoreFranchising(retailStoreFranchising);
		return retailStoreFranchising;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreFranchisingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_franchising";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreFranchising";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreFranchisingTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreFranchisingTokens.RETAIL_STORE_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreFranchisingTokens.RETAIL_STORE_LIST+".analyze");
 	}

	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreFranchisingTokens.RETAIL_STORE_LIST);
		
 	}
 	
		

	

	protected RetailStoreFranchisingMapper getRetailStoreFranchisingMapper(){
		return new RetailStoreFranchisingMapper();
	}

	
	
	protected RetailStoreFranchising extractRetailStoreFranchising(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreFranchising retailStoreFranchising = loadSingleObject(accessKey, getRetailStoreFranchisingMapper());
			return retailStoreFranchising;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreFranchisingNotFoundException("RetailStoreFranchising("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreFranchising loadInternalRetailStoreFranchising(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreFranchising retailStoreFranchising = extractRetailStoreFranchising(accessKey, loadOptions);

		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreFranchising, loadOptions);
 		}	
 		if(isAnalyzeRetailStoreListEnabled(loadOptions)){
	 		// analyzeRetailStoreList(retailStoreFranchising, loadOptions);
 		}
 		
		
		return retailStoreFranchising;
		
	}

	
		
	protected void enhanceRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStoreFranchising extractRetailStoreList(RetailStoreFranchising retailStoreFranchising, Map<String,Object> options){
		
		
		if(retailStoreFranchising == null){
			return null;
		}
		if(retailStoreFranchising.getId() == null){
			return retailStoreFranchising;
		}

		
		
		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByFranchising(retailStoreFranchising.getId(),options);
		if(retailStoreList != null){
			enhanceRetailStoreList(retailStoreList,options);
			retailStoreFranchising.setRetailStoreList(retailStoreList);
		}
		
		return retailStoreFranchising;
	
	}	
	
	protected RetailStoreFranchising analyzeRetailStoreList(RetailStoreFranchising retailStoreFranchising, Map<String,Object> options){
		
		
		if(retailStoreFranchising == null){
			return null;
		}
		if(retailStoreFranchising.getId() == null){
			return retailStoreFranchising;
		}

		
		
		SmartList<RetailStore> retailStoreList = retailStoreFranchising.getRetailStoreList();
		if(retailStoreList != null){
			getRetailStoreDAO().analyzeRetailStoreByFranchising(retailStoreList, retailStoreFranchising.getId(), options);
			
		}
		
		return retailStoreFranchising;
	
	}	
	
		
		
 	
		
		
		

	

	protected RetailStoreFranchising saveRetailStoreFranchising(RetailStoreFranchising  retailStoreFranchising){
		
		if(!retailStoreFranchising.isChanged()){
			return retailStoreFranchising;
		}
		
		
		String SQL=this.getSaveRetailStoreFranchisingSQL(retailStoreFranchising);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreFranchisingParameters(retailStoreFranchising);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreFranchising.incVersion();
		return retailStoreFranchising;
	
	}
	public SmartList<RetailStoreFranchising> saveRetailStoreFranchisingList(SmartList<RetailStoreFranchising> retailStoreFranchisingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreFranchisingList(retailStoreFranchisingList);
		
		batchRetailStoreFranchisingCreate((List<RetailStoreFranchising>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreFranchisingUpdate((List<RetailStoreFranchising>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreFranchising retailStoreFranchising:retailStoreFranchisingList){
			if(retailStoreFranchising.isChanged()){
				retailStoreFranchising.incVersion();
			}
			
		
		}
		
		
		return retailStoreFranchisingList;
	}

	public SmartList<RetailStoreFranchising> removeRetailStoreFranchisingList(SmartList<RetailStoreFranchising> retailStoreFranchisingList,Map<String,Object> options){
		
		
		super.removeList(retailStoreFranchisingList, options);
		
		return retailStoreFranchisingList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreFranchisingBatchCreateArgs(List<RetailStoreFranchising> retailStoreFranchisingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreFranchising retailStoreFranchising:retailStoreFranchisingList ){
			Object [] parameters = prepareRetailStoreFranchisingCreateParameters(retailStoreFranchising);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreFranchisingBatchUpdateArgs(List<RetailStoreFranchising> retailStoreFranchisingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreFranchising retailStoreFranchising:retailStoreFranchisingList ){
			if(!retailStoreFranchising.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreFranchisingUpdateParameters(retailStoreFranchising);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreFranchisingCreate(List<RetailStoreFranchising> retailStoreFranchisingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreFranchisingBatchCreateArgs(retailStoreFranchisingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreFranchisingUpdate(List<RetailStoreFranchising> retailStoreFranchisingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreFranchisingBatchUpdateArgs(retailStoreFranchisingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreFranchisingList(List<RetailStoreFranchising> retailStoreFranchisingList){
		
		List<RetailStoreFranchising> retailStoreFranchisingCreateList=new ArrayList<RetailStoreFranchising>();
		List<RetailStoreFranchising> retailStoreFranchisingUpdateList=new ArrayList<RetailStoreFranchising>();
		
		for(RetailStoreFranchising retailStoreFranchising: retailStoreFranchisingList){
			if(isUpdateRequest(retailStoreFranchising)){
				retailStoreFranchisingUpdateList.add( retailStoreFranchising);
				continue;
			}
			retailStoreFranchisingCreateList.add(retailStoreFranchising);
		}
		
		return new Object[]{retailStoreFranchisingCreateList,retailStoreFranchisingUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreFranchising retailStoreFranchising){
 		return retailStoreFranchising.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreFranchisingSQL(RetailStoreFranchising retailStoreFranchising){
 		if(isUpdateRequest(retailStoreFranchising)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreFranchisingParameters(RetailStoreFranchising retailStoreFranchising){
 		if(isUpdateRequest(retailStoreFranchising) ){
 			return prepareRetailStoreFranchisingUpdateParameters(retailStoreFranchising);
 		}
 		return prepareRetailStoreFranchisingCreateParameters(retailStoreFranchising);
 	}
 	protected Object[] prepareRetailStoreFranchisingUpdateParameters(RetailStoreFranchising retailStoreFranchising){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = retailStoreFranchising.getComment();		
 		parameters[1] = retailStoreFranchising.nextVersion();
 		parameters[2] = retailStoreFranchising.getId();
 		parameters[3] = retailStoreFranchising.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreFranchisingCreateParameters(RetailStoreFranchising retailStoreFranchising){
		Object[] parameters = new Object[2];
		String newRetailStoreFranchisingId=getNextId();
		retailStoreFranchising.setId(newRetailStoreFranchisingId);
		parameters[0] =  retailStoreFranchising.getId();
 
 		parameters[1] = retailStoreFranchising.getComment();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreFranchising saveInternalRetailStoreFranchising(RetailStoreFranchising retailStoreFranchising, Map<String,Object> options){
		
		saveRetailStoreFranchising(retailStoreFranchising);

		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreFranchising, options);
	 		//removeRetailStoreList(retailStoreFranchising, options);
	 		//Not delete the record
	 		
 		}		
		
		return retailStoreFranchising;
		
	}
	
	
	
	//======================================================================================
	

	
	public RetailStoreFranchising planToRemoveRetailStoreList(RetailStoreFranchising retailStoreFranchising, String retailStoreIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.FRANCHISING_PROPERTY, retailStoreFranchising.getId());
		key.put(RetailStore.ID_PROPERTY, retailStoreIds);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreFranchising;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreFranchising;
		}
		
		for(RetailStore retailStore: externalRetailStoreList){

			retailStore.clearFromAll();
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreFranchising.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreFranchising;	
	
	}


	//disconnect RetailStoreFranchising with retail_store_country_center in RetailStore
	public RetailStoreFranchising planToRemoveRetailStoreListWithRetailStoreCountryCenter(RetailStoreFranchising retailStoreFranchising, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.FRANCHISING_PROPERTY, retailStoreFranchising.getId());
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreFranchising;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreFranchising;
		}
		
		for(RetailStore retailStore: externalRetailStoreList){
			retailStore.clearRetailStoreCountryCenter();
			retailStore.clearFranchising();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreFranchising.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreFranchising;
	}
	
	public int countRetailStoreListWithRetailStoreCountryCenter(String retailStoreFranchisingId, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.FRANCHISING_PROPERTY, retailStoreFranchisingId);
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreFranchising with city_service_center in RetailStore
	public RetailStoreFranchising planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreFranchising retailStoreFranchising, String cityServiceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.FRANCHISING_PROPERTY, retailStoreFranchising.getId());
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreFranchising;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreFranchising;
		}
		
		for(RetailStore retailStore: externalRetailStoreList){
			retailStore.clearCityServiceCenter();
			retailStore.clearFranchising();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreFranchising.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreFranchising;
	}
	
	public int countRetailStoreListWithCityServiceCenter(String retailStoreFranchisingId, String cityServiceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.FRANCHISING_PROPERTY, retailStoreFranchisingId);
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreFranchising saveRetailStoreList(RetailStoreFranchising retailStoreFranchising, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStore> retailStoreList = retailStoreFranchising.getRetailStoreList();
		if(retailStoreList == null){
			//null list means nothing
			return retailStoreFranchising;
		}
		SmartList<RetailStore> mergedUpdateRetailStoreList = new SmartList<RetailStore>();
		
		
		mergedUpdateRetailStoreList.addAll(retailStoreList); 
		if(retailStoreList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreList.addAll(retailStoreList.getToRemoveList());
			retailStoreList.removeAll(retailStoreList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRetailStoreDAO().saveRetailStoreList(mergedUpdateRetailStoreList,options);
		
		if(retailStoreList.getToRemoveList() != null){
			retailStoreList.removeAll(retailStoreList.getToRemoveList());
		}
		
		
		return retailStoreFranchising;
	
	}
	
	protected RetailStoreFranchising removeRetailStoreList(RetailStoreFranchising retailStoreFranchising, Map<String,Object> options){
	
	
		SmartList<RetailStore> retailStoreList = retailStoreFranchising.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreFranchising;
		}	
	
		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();
		
		if(toRemoveRetailStoreList == null){
			return retailStoreFranchising;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreFranchising;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);
		
		return retailStoreFranchising;
	
	}
	
	

 	
 	
	
	
	
		

	public RetailStoreFranchising present(RetailStoreFranchising retailStoreFranchising,Map<String, Object> options){
	
		presentRetailStoreList(retailStoreFranchising,options);

		return retailStoreFranchising;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreFranchising presentRetailStoreList(
			RetailStoreFranchising retailStoreFranchising,
			Map<String, Object> options) {

		SmartList<RetailStore> retailStoreList = retailStoreFranchising.getRetailStoreList();		
				SmartList<RetailStore> newList= presentSubList(retailStoreFranchising.getId(),
				retailStoreList,
				options,
				getRetailStoreDAO()::countRetailStoreByFranchising,
				getRetailStoreDAO()::findRetailStoreByFranchising
				);

		
		retailStoreFranchising.setRetailStoreList(newList);
		

		return retailStoreFranchising;
	}			
		

	
    public SmartList<RetailStoreFranchising> requestCandidateRetailStoreFranchisingForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreFranchisingTable.COLUMN_COMMENT, filterKey, pageNo, pageSize, getRetailStoreFranchisingMapper());
    }
		

	protected String getTableName(){
		return RetailStoreFranchisingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreFranchising> retailStoreFranchisingList) {		
		this.enhanceListInternal(retailStoreFranchisingList, this.getRetailStoreFranchisingMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreFranchising> retailStoreFranchisingList = ownerEntity.collectRefsWithType(RetailStoreFranchising.INTERNAL_TYPE);
		this.enhanceList(retailStoreFranchisingList);
		
	}
	
	@Override
	public SmartList<RetailStoreFranchising> findRetailStoreFranchisingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreFranchisingMapper());

	}
	@Override
	public int countRetailStoreFranchisingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreFranchisingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreFranchising> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreFranchisingMapper());
	}
}


