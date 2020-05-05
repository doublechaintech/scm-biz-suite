
package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;

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


public class RetailStoreInvestmentInvitationJDBCTemplateDAO extends RetailscmBaseDAOImpl implements RetailStoreInvestmentInvitationDAO{

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
	protected RetailStoreInvestmentInvitation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreInvestmentInvitation(accessKey, options);
	}
	*/
	
	public SmartList<RetailStoreInvestmentInvitation> loadAll() {
	    return this.loadAll(getRetailStoreInvestmentInvitationMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreInvestmentInvitation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreInvestmentInvitation(RetailStoreInvestmentInvitationTable.withId(id), options);
	}
	
	
	
	public RetailStoreInvestmentInvitation save(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String,Object> options){
		
		String methodName="save(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreInvestmentInvitation, methodName, "retailStoreInvestmentInvitation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreInvestmentInvitation(retailStoreInvestmentInvitation,options);
	}
	public RetailStoreInvestmentInvitation clone(String retailStoreInvestmentInvitationId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreInvestmentInvitationTable.withId(retailStoreInvestmentInvitationId),options);
	}
	
	protected RetailStoreInvestmentInvitation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreInvestmentInvitationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreInvestmentInvitation newRetailStoreInvestmentInvitation = loadInternalRetailStoreInvestmentInvitation(accessKey, options);
		newRetailStoreInvestmentInvitation.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreInvestmentInvitation.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreInvestmentInvitation(newRetailStoreInvestmentInvitation,options);
		
		return newRetailStoreInvestmentInvitation;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreInvestmentInvitationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreInvestmentInvitationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreInvestmentInvitationNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreInvestmentInvitationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreInvestmentInvitationId, int version) throws Exception{
	
		String methodName="delete(String retailStoreInvestmentInvitationId, int version)";
		assertMethodArgumentNotNull(retailStoreInvestmentInvitationId, methodName, "retailStoreInvestmentInvitationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreInvestmentInvitationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreInvestmentInvitationId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreInvestmentInvitation disconnectFromAll(String retailStoreInvestmentInvitationId, int version) throws Exception{
	
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadInternalRetailStoreInvestmentInvitation(RetailStoreInvestmentInvitationTable.withId(retailStoreInvestmentInvitationId), emptyOptions());
		retailStoreInvestmentInvitation.clearFromAll();
		this.saveRetailStoreInvestmentInvitation(retailStoreInvestmentInvitation);
		return retailStoreInvestmentInvitation;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreInvestmentInvitationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_investment_invitation";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreInvestmentInvitation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreInvestmentInvitationTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreInvestmentInvitationTokens.RETAIL_STORE_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreListEnabled(Map<String,Object> options){		 		
 		return RetailStoreInvestmentInvitationTokens.of(options).analyzeRetailStoreListEnabled();
 	}
	
	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreInvestmentInvitationTokens.RETAIL_STORE_LIST);
		
 	}
 	
		

	

	protected RetailStoreInvestmentInvitationMapper getRetailStoreInvestmentInvitationMapper(){
		return new RetailStoreInvestmentInvitationMapper();
	}

	
	
	protected RetailStoreInvestmentInvitation extractRetailStoreInvestmentInvitation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadSingleObject(accessKey, getRetailStoreInvestmentInvitationMapper());
			return retailStoreInvestmentInvitation;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreInvestmentInvitationNotFoundException("RetailStoreInvestmentInvitation("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreInvestmentInvitation loadInternalRetailStoreInvestmentInvitation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = extractRetailStoreInvestmentInvitation(accessKey, loadOptions);

		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreInvestmentInvitation, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeRetailStoreListEnabled(loadOptions)){
	 		analyzeRetailStoreList(retailStoreInvestmentInvitation, loadOptions);
 		}
 		
		
		return retailStoreInvestmentInvitation;
		
	}

	
		
	protected void enhanceRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStoreInvestmentInvitation extractRetailStoreList(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,Object> options){
		
		
		if(retailStoreInvestmentInvitation == null){
			return null;
		}
		if(retailStoreInvestmentInvitation.getId() == null){
			return retailStoreInvestmentInvitation;
		}

		
		
		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByInvestmentInvitation(retailStoreInvestmentInvitation.getId(),options);
		if(retailStoreList != null){
			enhanceRetailStoreList(retailStoreList,options);
			retailStoreInvestmentInvitation.setRetailStoreList(retailStoreList);
		}
		
		return retailStoreInvestmentInvitation;
	
	}	
	
	protected RetailStoreInvestmentInvitation analyzeRetailStoreList(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,Object> options){
		
		
		if(retailStoreInvestmentInvitation == null){
			return null;
		}
		if(retailStoreInvestmentInvitation.getId() == null){
			return retailStoreInvestmentInvitation;
		}

		
		
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();
		if(retailStoreList != null){
			getRetailStoreDAO().analyzeRetailStoreByInvestmentInvitation(retailStoreList, retailStoreInvestmentInvitation.getId(), options);
			
		}
		
		return retailStoreInvestmentInvitation;
	
	}	
	
		
		
 	
		
		
		

	

	protected RetailStoreInvestmentInvitation saveRetailStoreInvestmentInvitation(RetailStoreInvestmentInvitation  retailStoreInvestmentInvitation){
		
		if(!retailStoreInvestmentInvitation.isChanged()){
			return retailStoreInvestmentInvitation;
		}
		
		
		String SQL=this.getSaveRetailStoreInvestmentInvitationSQL(retailStoreInvestmentInvitation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreInvestmentInvitationParameters(retailStoreInvestmentInvitation);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreInvestmentInvitation.incVersion();
		return retailStoreInvestmentInvitation;
	
	}
	public SmartList<RetailStoreInvestmentInvitation> saveRetailStoreInvestmentInvitationList(SmartList<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreInvestmentInvitationList(retailStoreInvestmentInvitationList);
		
		batchRetailStoreInvestmentInvitationCreate((List<RetailStoreInvestmentInvitation>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreInvestmentInvitationUpdate((List<RetailStoreInvestmentInvitation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation:retailStoreInvestmentInvitationList){
			if(retailStoreInvestmentInvitation.isChanged()){
				retailStoreInvestmentInvitation.incVersion();
			}
			
		
		}
		
		
		return retailStoreInvestmentInvitationList;
	}

	public SmartList<RetailStoreInvestmentInvitation> removeRetailStoreInvestmentInvitationList(SmartList<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList,Map<String,Object> options){
		
		
		super.removeList(retailStoreInvestmentInvitationList, options);
		
		return retailStoreInvestmentInvitationList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreInvestmentInvitationBatchCreateArgs(List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation:retailStoreInvestmentInvitationList ){
			Object [] parameters = prepareRetailStoreInvestmentInvitationCreateParameters(retailStoreInvestmentInvitation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreInvestmentInvitationBatchUpdateArgs(List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation:retailStoreInvestmentInvitationList ){
			if(!retailStoreInvestmentInvitation.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreInvestmentInvitationUpdateParameters(retailStoreInvestmentInvitation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreInvestmentInvitationCreate(List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreInvestmentInvitationBatchCreateArgs(retailStoreInvestmentInvitationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreInvestmentInvitationUpdate(List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreInvestmentInvitationBatchUpdateArgs(retailStoreInvestmentInvitationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreInvestmentInvitationList(List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList){
		
		List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationCreateList=new ArrayList<RetailStoreInvestmentInvitation>();
		List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationUpdateList=new ArrayList<RetailStoreInvestmentInvitation>();
		
		for(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation: retailStoreInvestmentInvitationList){
			if(isUpdateRequest(retailStoreInvestmentInvitation)){
				retailStoreInvestmentInvitationUpdateList.add( retailStoreInvestmentInvitation);
				continue;
			}
			retailStoreInvestmentInvitationCreateList.add(retailStoreInvestmentInvitation);
		}
		
		return new Object[]{retailStoreInvestmentInvitationCreateList,retailStoreInvestmentInvitationUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation){
 		return retailStoreInvestmentInvitation.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreInvestmentInvitationSQL(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation){
 		if(isUpdateRequest(retailStoreInvestmentInvitation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreInvestmentInvitationParameters(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation){
 		if(isUpdateRequest(retailStoreInvestmentInvitation) ){
 			return prepareRetailStoreInvestmentInvitationUpdateParameters(retailStoreInvestmentInvitation);
 		}
 		return prepareRetailStoreInvestmentInvitationCreateParameters(retailStoreInvestmentInvitation);
 	}
 	protected Object[] prepareRetailStoreInvestmentInvitationUpdateParameters(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation){
 		Object[] parameters = new Object[4];
 
 		
 		parameters[0] = retailStoreInvestmentInvitation.getComment();
 				
 		parameters[1] = retailStoreInvestmentInvitation.nextVersion();
 		parameters[2] = retailStoreInvestmentInvitation.getId();
 		parameters[3] = retailStoreInvestmentInvitation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreInvestmentInvitationCreateParameters(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation){
		Object[] parameters = new Object[2];
		String newRetailStoreInvestmentInvitationId=getNextId();
		retailStoreInvestmentInvitation.setId(newRetailStoreInvestmentInvitationId);
		parameters[0] =  retailStoreInvestmentInvitation.getId();
 
 		
 		parameters[1] = retailStoreInvestmentInvitation.getComment();
 				
 				
 		return parameters;
 	}
 	
	protected RetailStoreInvestmentInvitation saveInternalRetailStoreInvestmentInvitation(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,Object> options){
		
		saveRetailStoreInvestmentInvitation(retailStoreInvestmentInvitation);

		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreInvestmentInvitation, options);
	 		//removeRetailStoreList(retailStoreInvestmentInvitation, options);
	 		//Not delete the record
	 		
 		}		
		
		return retailStoreInvestmentInvitation;
		
	}
	
	
	
	//======================================================================================
	

	
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreList(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String retailStoreIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitation.getId());
		key.put(RetailStore.ID_PROPERTY, retailStoreIds);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreInvestmentInvitation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreInvestmentInvitation;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){

			retailStoreItem.clearFromAll();
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreInvestmentInvitation;	
	
	}


	//disconnect RetailStoreInvestmentInvitation with retail_store_country_center in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithRetailStoreCountryCenter(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitation.getId());
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreInvestmentInvitation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreInvestmentInvitation;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearRetailStoreCountryCenter();
			retailStoreItem.clearInvestmentInvitation();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreInvestmentInvitation;
	}
	
	public int countRetailStoreListWithRetailStoreCountryCenter(String retailStoreInvestmentInvitationId, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitationId);
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreInvestmentInvitation with city_service_center in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String cityServiceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitation.getId());
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreInvestmentInvitation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreInvestmentInvitation;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearCityServiceCenter();
			retailStoreItem.clearInvestmentInvitation();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreInvestmentInvitation;
	}
	
	public int countRetailStoreListWithCityServiceCenter(String retailStoreInvestmentInvitationId, String cityServiceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitationId);
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreInvestmentInvitation with creation in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithCreation(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String creationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitation.getId());
		key.put(RetailStore.CREATION_PROPERTY, creationId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreInvestmentInvitation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreInvestmentInvitation;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearCreation();
			retailStoreItem.clearInvestmentInvitation();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreInvestmentInvitation;
	}
	
	public int countRetailStoreListWithCreation(String retailStoreInvestmentInvitationId, String creationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitationId);
		key.put(RetailStore.CREATION_PROPERTY, creationId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreInvestmentInvitation with franchising in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithFranchising(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String franchisingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitation.getId());
		key.put(RetailStore.FRANCHISING_PROPERTY, franchisingId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreInvestmentInvitation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreInvestmentInvitation;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearFranchising();
			retailStoreItem.clearInvestmentInvitation();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreInvestmentInvitation;
	}
	
	public int countRetailStoreListWithFranchising(String retailStoreInvestmentInvitationId, String franchisingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitationId);
		key.put(RetailStore.FRANCHISING_PROPERTY, franchisingId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreInvestmentInvitation with decoration in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithDecoration(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String decorationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitation.getId());
		key.put(RetailStore.DECORATION_PROPERTY, decorationId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreInvestmentInvitation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreInvestmentInvitation;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearDecoration();
			retailStoreItem.clearInvestmentInvitation();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreInvestmentInvitation;
	}
	
	public int countRetailStoreListWithDecoration(String retailStoreInvestmentInvitationId, String decorationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitationId);
		key.put(RetailStore.DECORATION_PROPERTY, decorationId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreInvestmentInvitation with opening in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithOpening(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String openingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitation.getId());
		key.put(RetailStore.OPENING_PROPERTY, openingId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreInvestmentInvitation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreInvestmentInvitation;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearOpening();
			retailStoreItem.clearInvestmentInvitation();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreInvestmentInvitation;
	}
	
	public int countRetailStoreListWithOpening(String retailStoreInvestmentInvitationId, String openingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitationId);
		key.put(RetailStore.OPENING_PROPERTY, openingId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreInvestmentInvitation with closing in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithClosing(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String closingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitation.getId());
		key.put(RetailStore.CLOSING_PROPERTY, closingId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreInvestmentInvitation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreInvestmentInvitation;
		}
		
		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearClosing();
			retailStoreItem.clearInvestmentInvitation();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreInvestmentInvitation;
	}
	
	public int countRetailStoreListWithClosing(String retailStoreInvestmentInvitationId, String closingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitationId);
		key.put(RetailStore.CLOSING_PROPERTY, closingId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreInvestmentInvitation saveRetailStoreList(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();
		if(retailStoreList == null){
			//null list means nothing
			return retailStoreInvestmentInvitation;
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
		
		
		return retailStoreInvestmentInvitation;
	
	}
	
	protected RetailStoreInvestmentInvitation removeRetailStoreList(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,Object> options){
	
	
		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreInvestmentInvitation;
		}	
	
		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();
		
		if(toRemoveRetailStoreList == null){
			return retailStoreInvestmentInvitation;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreInvestmentInvitation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);
		
		return retailStoreInvestmentInvitation;
	
	}
	
	

 	
 	
	
	
	
		

	public RetailStoreInvestmentInvitation present(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String, Object> options){
	
		presentRetailStoreList(retailStoreInvestmentInvitation,options);

		return retailStoreInvestmentInvitation;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreInvestmentInvitation presentRetailStoreList(
			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,
			Map<String, Object> options) {

		SmartList<RetailStore> retailStoreList = retailStoreInvestmentInvitation.getRetailStoreList();		
				SmartList<RetailStore> newList= presentSubList(retailStoreInvestmentInvitation.getId(),
				retailStoreList,
				options,
				getRetailStoreDAO()::countRetailStoreByInvestmentInvitation,
				getRetailStoreDAO()::findRetailStoreByInvestmentInvitation
				);

		
		retailStoreInvestmentInvitation.setRetailStoreList(newList);
		

		return retailStoreInvestmentInvitation;
	}			
		

	
    public SmartList<RetailStoreInvestmentInvitation> requestCandidateRetailStoreInvestmentInvitationForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreInvestmentInvitationTable.COLUMN_COMMENT, null, filterKey, pageNo, pageSize, getRetailStoreInvestmentInvitationMapper());
    }
		

	protected String getTableName(){
		return RetailStoreInvestmentInvitationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList) {		
		this.enhanceListInternal(retailStoreInvestmentInvitationList, this.getRetailStoreInvestmentInvitationMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:RetailStore的investmentInvitation的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(RetailscmUserContext userContext, List<RetailStoreInvestmentInvitation> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStore> loadedObjs = userContext.getDAOGroup().getRetailStoreDAO().findRetailStoreWithKey(key, options);
		Map<String, List<RetailStore>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getInvestmentInvitation().getId()));
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
		List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList = ownerEntity.collectRefsWithType(RetailStoreInvestmentInvitation.INTERNAL_TYPE);
		this.enhanceList(retailStoreInvestmentInvitationList);
		
	}
	
	@Override
	public SmartList<RetailStoreInvestmentInvitation> findRetailStoreInvestmentInvitationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreInvestmentInvitationMapper());

	}
	@Override
	public int countRetailStoreInvestmentInvitationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreInvestmentInvitationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreInvestmentInvitation> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreInvestmentInvitationMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateRetailStoreInvestmentInvitation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateRetailStoreInvestmentInvitation result = new CandidateRetailStoreInvestmentInvitation();
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


