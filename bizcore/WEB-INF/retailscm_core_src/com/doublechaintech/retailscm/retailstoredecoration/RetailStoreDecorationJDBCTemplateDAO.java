
package com.doublechaintech.retailscm.retailstoredecoration;

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


import com.doublechaintech.retailscm.retailstore.RetailStore;

import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class RetailStoreDecorationJDBCTemplateDAO extends RetailscmBaseDAOImpl implements RetailStoreDecorationDAO{

	protected RetailStoreDAO retailStoreDAO;
	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
 	
 		if(retailStoreDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreDAO to null.");
 		}
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
 		if(this.retailStoreDAO == null){
 			throw new IllegalStateException("The retailStoreDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreDAO;
 	}	

	
	/*
	protected RetailStoreDecoration load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreDecoration(accessKey, options);
	}
	*/
	
	public SmartList<RetailStoreDecoration> loadAll() {
	    return this.loadAll(getRetailStoreDecorationMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreDecoration load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreDecoration(RetailStoreDecorationTable.withId(id), options);
	}
	
	
	
	public RetailStoreDecoration save(RetailStoreDecoration retailStoreDecoration,Map<String,Object> options){
		
		String methodName="save(RetailStoreDecoration retailStoreDecoration,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreDecoration, methodName, "retailStoreDecoration");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreDecoration(retailStoreDecoration,options);
	}
	public RetailStoreDecoration clone(String retailStoreDecorationId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreDecorationTable.withId(retailStoreDecorationId),options);
	}
	
	protected RetailStoreDecoration clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreDecorationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreDecoration newRetailStoreDecoration = loadInternalRetailStoreDecoration(accessKey, options);
		newRetailStoreDecoration.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreDecoration.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreDecoration(newRetailStoreDecoration,options);
		
		return newRetailStoreDecoration;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreDecorationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreDecorationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreDecorationNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreDecorationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreDecorationId, int version) throws Exception{
	
		String methodName="delete(String retailStoreDecorationId, int version)";
		assertMethodArgumentNotNull(retailStoreDecorationId, methodName, "retailStoreDecorationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreDecorationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreDecorationId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreDecoration disconnectFromAll(String retailStoreDecorationId, int version) throws Exception{
	
		
		RetailStoreDecoration retailStoreDecoration = loadInternalRetailStoreDecoration(RetailStoreDecorationTable.withId(retailStoreDecorationId), emptyOptions());
		retailStoreDecoration.clearFromAll();
		this.saveRetailStoreDecoration(retailStoreDecoration);
		return retailStoreDecoration;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreDecorationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_decoration";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreDecoration";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreDecorationTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreDecorationTokens.RETAIL_STORE_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreListEnabled(Map<String,Object> options){		 		
 		return RetailStoreDecorationTokens.of(options).analyzeRetailStoreListEnabled();
 	}
	
	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreDecorationTokens.RETAIL_STORE_LIST);
		
 	}
 	
		

	

	protected RetailStoreDecorationMapper getRetailStoreDecorationMapper(){
		return new RetailStoreDecorationMapper();
	}

	
	
	protected RetailStoreDecoration extractRetailStoreDecoration(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreDecoration retailStoreDecoration = loadSingleObject(accessKey, getRetailStoreDecorationMapper());
			return retailStoreDecoration;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreDecorationNotFoundException("RetailStoreDecoration("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreDecoration loadInternalRetailStoreDecoration(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreDecoration retailStoreDecoration = extractRetailStoreDecoration(accessKey, loadOptions);

		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreDecoration, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeRetailStoreListEnabled(loadOptions)){
	 		analyzeRetailStoreList(retailStoreDecoration, loadOptions);
 		}
 		
		
		return retailStoreDecoration;
		
	}

	
		
	protected void enhanceRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStoreDecoration extractRetailStoreList(RetailStoreDecoration retailStoreDecoration, Map<String,Object> options){
		
		
		if(retailStoreDecoration == null){
			return null;
		}
		if(retailStoreDecoration.getId() == null){
			return retailStoreDecoration;
		}

		
		
		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByDecoration(retailStoreDecoration.getId(),options);
		if(retailStoreList != null){
			enhanceRetailStoreList(retailStoreList,options);
			retailStoreDecoration.setRetailStoreList(retailStoreList);
		}
		
		return retailStoreDecoration;
	
	}	
	
	protected RetailStoreDecoration analyzeRetailStoreList(RetailStoreDecoration retailStoreDecoration, Map<String,Object> options){
		
		
		if(retailStoreDecoration == null){
			return null;
		}
		if(retailStoreDecoration.getId() == null){
			return retailStoreDecoration;
		}

		
		
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();
		if(retailStoreList != null){
			getRetailStoreDAO().analyzeRetailStoreByDecoration(retailStoreList, retailStoreDecoration.getId(), options);
			
		}
		
		return retailStoreDecoration;
	
	}	
	
		
		
 	
		
		
		

	

	protected RetailStoreDecoration saveRetailStoreDecoration(RetailStoreDecoration  retailStoreDecoration){
		
		if(!retailStoreDecoration.isChanged()){
			return retailStoreDecoration;
		}
		
		
		String SQL=this.getSaveRetailStoreDecorationSQL(retailStoreDecoration);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreDecorationParameters(retailStoreDecoration);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreDecoration.incVersion();
		return retailStoreDecoration;
	
	}
	public SmartList<RetailStoreDecoration> saveRetailStoreDecorationList(SmartList<RetailStoreDecoration> retailStoreDecorationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreDecorationList(retailStoreDecorationList);
		
		batchRetailStoreDecorationCreate((List<RetailStoreDecoration>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreDecorationUpdate((List<RetailStoreDecoration>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreDecoration retailStoreDecoration:retailStoreDecorationList){
			if(retailStoreDecoration.isChanged()){
				retailStoreDecoration.incVersion();
			}
			
		
		}
		
		
		return retailStoreDecorationList;
	}

	public SmartList<RetailStoreDecoration> removeRetailStoreDecorationList(SmartList<RetailStoreDecoration> retailStoreDecorationList,Map<String,Object> options){
		
		
		super.removeList(retailStoreDecorationList, options);
		
		return retailStoreDecorationList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreDecorationBatchCreateArgs(List<RetailStoreDecoration> retailStoreDecorationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreDecoration retailStoreDecoration:retailStoreDecorationList ){
			Object [] parameters = prepareRetailStoreDecorationCreateParameters(retailStoreDecoration);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreDecorationBatchUpdateArgs(List<RetailStoreDecoration> retailStoreDecorationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreDecoration retailStoreDecoration:retailStoreDecorationList ){
			if(!retailStoreDecoration.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreDecorationUpdateParameters(retailStoreDecoration);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreDecorationCreate(List<RetailStoreDecoration> retailStoreDecorationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreDecorationBatchCreateArgs(retailStoreDecorationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreDecorationUpdate(List<RetailStoreDecoration> retailStoreDecorationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreDecorationBatchUpdateArgs(retailStoreDecorationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreDecorationList(List<RetailStoreDecoration> retailStoreDecorationList){
		
		List<RetailStoreDecoration> retailStoreDecorationCreateList=new ArrayList<RetailStoreDecoration>();
		List<RetailStoreDecoration> retailStoreDecorationUpdateList=new ArrayList<RetailStoreDecoration>();
		
		for(RetailStoreDecoration retailStoreDecoration: retailStoreDecorationList){
			if(isUpdateRequest(retailStoreDecoration)){
				retailStoreDecorationUpdateList.add( retailStoreDecoration);
				continue;
			}
			retailStoreDecorationCreateList.add(retailStoreDecoration);
		}
		
		return new Object[]{retailStoreDecorationCreateList,retailStoreDecorationUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreDecoration retailStoreDecoration){
 		return retailStoreDecoration.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreDecorationSQL(RetailStoreDecoration retailStoreDecoration){
 		if(isUpdateRequest(retailStoreDecoration)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreDecorationParameters(RetailStoreDecoration retailStoreDecoration){
 		if(isUpdateRequest(retailStoreDecoration) ){
 			return prepareRetailStoreDecorationUpdateParameters(retailStoreDecoration);
 		}
 		return prepareRetailStoreDecorationCreateParameters(retailStoreDecoration);
 	}
 	protected Object[] prepareRetailStoreDecorationUpdateParameters(RetailStoreDecoration retailStoreDecoration){
 		Object[] parameters = new Object[4];
 
 		
 		parameters[0] = retailStoreDecoration.getComment();
 				
 		parameters[1] = retailStoreDecoration.nextVersion();
 		parameters[2] = retailStoreDecoration.getId();
 		parameters[3] = retailStoreDecoration.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreDecorationCreateParameters(RetailStoreDecoration retailStoreDecoration){
		Object[] parameters = new Object[2];
		String newRetailStoreDecorationId=getNextId();
		retailStoreDecoration.setId(newRetailStoreDecorationId);
		parameters[0] =  retailStoreDecoration.getId();
 
 		
 		parameters[1] = retailStoreDecoration.getComment();
 				
 				
 		return parameters;
 	}
 	
	protected RetailStoreDecoration saveInternalRetailStoreDecoration(RetailStoreDecoration retailStoreDecoration, Map<String,Object> options){
		
		saveRetailStoreDecoration(retailStoreDecoration);

		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreDecoration, options);
	 		//removeRetailStoreList(retailStoreDecoration, options);
	 		//Not delete the record
	 		
 		}		
		
		return retailStoreDecoration;
		
	}
	
	
	
	//======================================================================================
	

	
	public RetailStoreDecoration planToRemoveRetailStoreList(RetailStoreDecoration retailStoreDecoration, String retailStoreIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecoration.getId());
		key.put(RetailStore.ID_PROPERTY, retailStoreIds);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreDecoration;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreDecoration;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){

			retailStoreItem.clearFromAll();
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreDecoration;	
	
	}


	//disconnect RetailStoreDecoration with retail_store_country_center in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithRetailStoreCountryCenter(RetailStoreDecoration retailStoreDecoration, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecoration.getId());
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreDecoration;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreDecoration;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearRetailStoreCountryCenter();
			retailStoreItem.clearDecoration();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreDecoration;
	}
	
	public int countRetailStoreListWithRetailStoreCountryCenter(String retailStoreDecorationId, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecorationId);
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreDecoration with city_service_center in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreDecoration retailStoreDecoration, String cityServiceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecoration.getId());
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreDecoration;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreDecoration;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearCityServiceCenter();
			retailStoreItem.clearDecoration();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreDecoration;
	}
	
	public int countRetailStoreListWithCityServiceCenter(String retailStoreDecorationId, String cityServiceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecorationId);
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreDecoration with creation in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithCreation(RetailStoreDecoration retailStoreDecoration, String creationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecoration.getId());
		key.put(RetailStore.CREATION_PROPERTY, creationId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreDecoration;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreDecoration;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearCreation();
			retailStoreItem.clearDecoration();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreDecoration;
	}
	
	public int countRetailStoreListWithCreation(String retailStoreDecorationId, String creationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecorationId);
		key.put(RetailStore.CREATION_PROPERTY, creationId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreDecoration with investment_invitation in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithInvestmentInvitation(RetailStoreDecoration retailStoreDecoration, String investmentInvitationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecoration.getId());
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, investmentInvitationId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreDecoration;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreDecoration;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearInvestmentInvitation();
			retailStoreItem.clearDecoration();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreDecoration;
	}
	
	public int countRetailStoreListWithInvestmentInvitation(String retailStoreDecorationId, String investmentInvitationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecorationId);
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, investmentInvitationId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreDecoration with franchising in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithFranchising(RetailStoreDecoration retailStoreDecoration, String franchisingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecoration.getId());
		key.put(RetailStore.FRANCHISING_PROPERTY, franchisingId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreDecoration;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreDecoration;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearFranchising();
			retailStoreItem.clearDecoration();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreDecoration;
	}
	
	public int countRetailStoreListWithFranchising(String retailStoreDecorationId, String franchisingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecorationId);
		key.put(RetailStore.FRANCHISING_PROPERTY, franchisingId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreDecoration with opening in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithOpening(RetailStoreDecoration retailStoreDecoration, String openingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecoration.getId());
		key.put(RetailStore.OPENING_PROPERTY, openingId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreDecoration;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreDecoration;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearOpening();
			retailStoreItem.clearDecoration();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreDecoration;
	}
	
	public int countRetailStoreListWithOpening(String retailStoreDecorationId, String openingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecorationId);
		key.put(RetailStore.OPENING_PROPERTY, openingId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreDecoration with closing in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithClosing(RetailStoreDecoration retailStoreDecoration, String closingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecoration.getId());
		key.put(RetailStore.CLOSING_PROPERTY, closingId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreDecoration;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreDecoration;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearClosing();
			retailStoreItem.clearDecoration();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreDecoration;
	}
	
	public int countRetailStoreListWithClosing(String retailStoreDecorationId, String closingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, retailStoreDecorationId);
		key.put(RetailStore.CLOSING_PROPERTY, closingId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreDecoration saveRetailStoreList(RetailStoreDecoration retailStoreDecoration, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();
		if(retailStoreList == null){
			//null list means nothing
			return retailStoreDecoration;
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
		
		
		return retailStoreDecoration;
	
	}
	
	protected RetailStoreDecoration removeRetailStoreList(RetailStoreDecoration retailStoreDecoration, Map<String,Object> options){
	
	
		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreDecoration;
		}	
	
		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();
		
		if(toRemoveRetailStoreList == null){
			return retailStoreDecoration;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreDecoration;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);
		
		return retailStoreDecoration;
	
	}
	
	

 	
 	
	
	
	
		

	public RetailStoreDecoration present(RetailStoreDecoration retailStoreDecoration,Map<String, Object> options){
	
		presentRetailStoreList(retailStoreDecoration,options);

		return retailStoreDecoration;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreDecoration presentRetailStoreList(
			RetailStoreDecoration retailStoreDecoration,
			Map<String, Object> options) {

		SmartList<RetailStore> retailStoreList = retailStoreDecoration.getRetailStoreList();		
				SmartList<RetailStore> newList= presentSubList(retailStoreDecoration.getId(),
				retailStoreList,
				options,
				getRetailStoreDAO()::countRetailStoreByDecoration,
				getRetailStoreDAO()::findRetailStoreByDecoration
				);

		
		retailStoreDecoration.setRetailStoreList(newList);
		

		return retailStoreDecoration;
	}			
		

	
    public SmartList<RetailStoreDecoration> requestCandidateRetailStoreDecorationForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreDecorationTable.COLUMN_COMMENT, null, filterKey, pageNo, pageSize, getRetailStoreDecorationMapper());
    }
		

	protected String getTableName(){
		return RetailStoreDecorationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreDecoration> retailStoreDecorationList) {		
		this.enhanceListInternal(retailStoreDecorationList, this.getRetailStoreDecorationMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:RetailStore的decoration的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(RetailscmUserContext userContext, List<RetailStoreDecoration> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.DECORATION_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStore> loadedObjs = userContext.getDAOGroup().getRetailStoreDAO().findRetailStoreWithKey(key, options);
		Map<String, List<RetailStore>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getDecoration().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStore> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStore> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreDecoration> retailStoreDecorationList = ownerEntity.collectRefsWithType(RetailStoreDecoration.INTERNAL_TYPE);
		this.enhanceList(retailStoreDecorationList);
		
	}
	
	@Override
	public SmartList<RetailStoreDecoration> findRetailStoreDecorationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreDecorationMapper());

	}
	@Override
	public int countRetailStoreDecorationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreDecorationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreDecoration> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreDecorationMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateRetailStoreDecoration executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateRetailStoreDecoration result = new CandidateRetailStoreDecoration();
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


