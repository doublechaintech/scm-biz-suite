
package com.doublechaintech.retailscm.retailstorecreation;

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


import com.doublechaintech.retailscm.retailstore.RetailStore;

import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class RetailStoreCreationJDBCTemplateDAO extends RetailscmBaseDAOImpl implements RetailStoreCreationDAO{

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
	protected RetailStoreCreation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreCreation(accessKey, options);
	}
	*/

	public SmartList<RetailStoreCreation> loadAll() {
	    return this.loadAll(getRetailStoreCreationMapper());
	}

  public Stream<RetailStoreCreation> loadAllAsStream() {
      return this.loadAllAsStream(getRetailStoreCreationMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public RetailStoreCreation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreCreation(RetailStoreCreationTable.withId(id), options);
	}

	

	public RetailStoreCreation save(RetailStoreCreation retailStoreCreation,Map<String,Object> options){

		String methodName="save(RetailStoreCreation retailStoreCreation,Map<String,Object> options)";

		assertMethodArgumentNotNull(retailStoreCreation, methodName, "retailStoreCreation");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalRetailStoreCreation(retailStoreCreation,options);
	}
	public RetailStoreCreation clone(String retailStoreCreationId, Map<String,Object> options) throws Exception{

		return clone(RetailStoreCreationTable.withId(retailStoreCreationId),options);
	}

	protected RetailStoreCreation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String retailStoreCreationId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		RetailStoreCreation newRetailStoreCreation = loadInternalRetailStoreCreation(accessKey, options);
		newRetailStoreCreation.setVersion(0);
		
		

 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreCreation.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalRetailStoreCreation(newRetailStoreCreation,options);

		return newRetailStoreCreation;
	}

	



	protected void throwIfHasException(String retailStoreCreationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreCreationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreCreationNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreCreationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String retailStoreCreationId, int version) throws Exception{

		String methodName="delete(String retailStoreCreationId, int version)";
		assertMethodArgumentNotNull(retailStoreCreationId, methodName, "retailStoreCreationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreCreationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreCreationId,version);
		}


	}






	public RetailStoreCreation disconnectFromAll(String retailStoreCreationId, int version) throws Exception{


		RetailStoreCreation retailStoreCreation = loadInternalRetailStoreCreation(RetailStoreCreationTable.withId(retailStoreCreationId), emptyOptions());
		retailStoreCreation.clearFromAll();
		this.saveRetailStoreCreation(retailStoreCreation);
		return retailStoreCreation;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreCreationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "retail_store_creation";
	}
	@Override
	protected String getBeanName() {

		return "retailStoreCreation";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return RetailStoreCreationTokens.checkOptions(options, optionToCheck);

	}


		

	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCreationTokens.RETAIL_STORE_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreListEnabled(Map<String,Object> options){
 		return RetailStoreCreationTokens.of(options).analyzeRetailStoreListEnabled();
 	}

	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCreationTokens.RETAIL_STORE_LIST);

 	}

		

	

	protected RetailStoreCreationMapper getRetailStoreCreationMapper(){
		return new RetailStoreCreationMapper();
	}



	protected RetailStoreCreation extractRetailStoreCreation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreCreation retailStoreCreation = loadSingleObject(accessKey, getRetailStoreCreationMapper());
			return retailStoreCreation;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreCreationNotFoundException("RetailStoreCreation("+accessKey+") is not found!");
		}

	}




	protected RetailStoreCreation loadInternalRetailStoreCreation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		RetailStoreCreation retailStoreCreation = extractRetailStoreCreation(accessKey, loadOptions);

		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreCreation, loadOptions);
 		}

 		
 		if(isAnalyzeRetailStoreListEnabled(loadOptions)){
	 		analyzeRetailStoreList(retailStoreCreation, loadOptions);
 		}
 		
		
		return retailStoreCreation;

	}

	
		
	protected void enhanceRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCreation extractRetailStoreList(RetailStoreCreation retailStoreCreation, Map<String,Object> options){
    

		if(retailStoreCreation == null){
			return null;
		}
		if(retailStoreCreation.getId() == null){
			return retailStoreCreation;
		}



		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByCreation(retailStoreCreation.getId(),options);
		if(retailStoreList != null){
			enhanceRetailStoreList(retailStoreList,options);
			retailStoreCreation.setRetailStoreList(retailStoreList);
		}

		return retailStoreCreation;
  
	}

	protected RetailStoreCreation analyzeRetailStoreList(RetailStoreCreation retailStoreCreation, Map<String,Object> options){
     
		if(retailStoreCreation == null){
			return null;
		}
		if(retailStoreCreation.getId() == null){
			return retailStoreCreation;
		}



		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		if(retailStoreList != null){
			getRetailStoreDAO().analyzeRetailStoreByCreation(retailStoreList, retailStoreCreation.getId(), options);

		}

		return retailStoreCreation;
    
	}

		

 




	

	protected RetailStoreCreation saveRetailStoreCreation(RetailStoreCreation  retailStoreCreation){
    

		
		if(!retailStoreCreation.isChanged()){
			return retailStoreCreation;
		}
		

    Beans.dbUtil().cacheCleanUp(retailStoreCreation);
		String SQL=this.getSaveRetailStoreCreationSQL(retailStoreCreation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreCreationParameters(retailStoreCreation);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		retailStoreCreation.incVersion();
		retailStoreCreation.afterSave();
		return retailStoreCreation;

	}
	public SmartList<RetailStoreCreation> saveRetailStoreCreationList(SmartList<RetailStoreCreation> retailStoreCreationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreCreationList(retailStoreCreationList);

		batchRetailStoreCreationCreate((List<RetailStoreCreation>)lists[CREATE_LIST_INDEX]);

		batchRetailStoreCreationUpdate((List<RetailStoreCreation>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(RetailStoreCreation retailStoreCreation:retailStoreCreationList){
			if(retailStoreCreation.isChanged()){
				retailStoreCreation.incVersion();
				retailStoreCreation.afterSave();
			}


		}


		return retailStoreCreationList;
	}

	public SmartList<RetailStoreCreation> removeRetailStoreCreationList(SmartList<RetailStoreCreation> retailStoreCreationList,Map<String,Object> options){


		super.removeList(retailStoreCreationList, options);

		return retailStoreCreationList;


	}

	protected List<Object[]> prepareRetailStoreCreationBatchCreateArgs(List<RetailStoreCreation> retailStoreCreationList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreCreation retailStoreCreation:retailStoreCreationList ){
			Object [] parameters = prepareRetailStoreCreationCreateParameters(retailStoreCreation);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareRetailStoreCreationBatchUpdateArgs(List<RetailStoreCreation> retailStoreCreationList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreCreation retailStoreCreation:retailStoreCreationList ){
			if(!retailStoreCreation.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreCreationUpdateParameters(retailStoreCreation);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchRetailStoreCreationCreate(List<RetailStoreCreation> retailStoreCreationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreCreationBatchCreateArgs(retailStoreCreationList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchRetailStoreCreationUpdate(List<RetailStoreCreation> retailStoreCreationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreCreationBatchUpdateArgs(retailStoreCreationList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitRetailStoreCreationList(List<RetailStoreCreation> retailStoreCreationList){

		List<RetailStoreCreation> retailStoreCreationCreateList=new ArrayList<RetailStoreCreation>();
		List<RetailStoreCreation> retailStoreCreationUpdateList=new ArrayList<RetailStoreCreation>();

		for(RetailStoreCreation retailStoreCreation: retailStoreCreationList){
			if(isUpdateRequest(retailStoreCreation)){
				retailStoreCreationUpdateList.add( retailStoreCreation);
				continue;
			}
			retailStoreCreationCreateList.add(retailStoreCreation);
		}

		return new Object[]{retailStoreCreationCreateList,retailStoreCreationUpdateList};
	}

	protected boolean isUpdateRequest(RetailStoreCreation retailStoreCreation){
 		return retailStoreCreation.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreCreationSQL(RetailStoreCreation retailStoreCreation){
 		if(isUpdateRequest(retailStoreCreation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveRetailStoreCreationParameters(RetailStoreCreation retailStoreCreation){
 		if(isUpdateRequest(retailStoreCreation) ){
 			return prepareRetailStoreCreationUpdateParameters(retailStoreCreation);
 		}
 		return prepareRetailStoreCreationCreateParameters(retailStoreCreation);
 	}
 	protected Object[] prepareRetailStoreCreationUpdateParameters(RetailStoreCreation retailStoreCreation){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = retailStoreCreation.getComment();
 		
 		parameters[1] = retailStoreCreation.nextVersion();
 		parameters[2] = retailStoreCreation.getId();
 		parameters[3] = retailStoreCreation.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareRetailStoreCreationCreateParameters(RetailStoreCreation retailStoreCreation){
		Object[] parameters = new Object[2];
        if(retailStoreCreation.getId() == null){
          String newRetailStoreCreationId=getNextId();
          retailStoreCreation.setId(newRetailStoreCreationId);
        }
		parameters[0] =  retailStoreCreation.getId();
 
 		parameters[1] = retailStoreCreation.getComment();
 		

 		return parameters;
 	}

	protected RetailStoreCreation saveInternalRetailStoreCreation(RetailStoreCreation retailStoreCreation, Map<String,Object> options){

   saveRetailStoreCreation(retailStoreCreation);
		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreCreation, options);
	 		//removeRetailStoreList(retailStoreCreation, options);
	 		//Not delete the record

 		}
		
		return retailStoreCreation;

	}



	//======================================================================================
	

	
	public RetailStoreCreation planToRemoveRetailStoreList(RetailStoreCreation retailStoreCreation, String retailStoreIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreation.getId());
		key.put(RetailStore.ID_PROPERTY, retailStoreIds);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCreation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCreation;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){

			retailStoreItem.clearFromAll();
		}


		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCreation;

	}


	//disconnect RetailStoreCreation with retail_store_country_center in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithRetailStoreCountryCenter(RetailStoreCreation retailStoreCreation, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreation.getId());
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCreation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCreation;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearRetailStoreCountryCenter();
			retailStoreItem.clearCreation();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCreation;
	}

	public int countRetailStoreListWithRetailStoreCountryCenter(String retailStoreCreationId, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreationId);
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCreation with city_service_center in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreCreation retailStoreCreation, String cityServiceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreation.getId());
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCreation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCreation;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearCityServiceCenter();
			retailStoreItem.clearCreation();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCreation;
	}

	public int countRetailStoreListWithCityServiceCenter(String retailStoreCreationId, String cityServiceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreationId);
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCreation with investment_invitation in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithInvestmentInvitation(RetailStoreCreation retailStoreCreation, String investmentInvitationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreation.getId());
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, investmentInvitationId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCreation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCreation;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearInvestmentInvitation();
			retailStoreItem.clearCreation();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCreation;
	}

	public int countRetailStoreListWithInvestmentInvitation(String retailStoreCreationId, String investmentInvitationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreationId);
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, investmentInvitationId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCreation with franchising in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithFranchising(RetailStoreCreation retailStoreCreation, String franchisingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreation.getId());
		key.put(RetailStore.FRANCHISING_PROPERTY, franchisingId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCreation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCreation;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearFranchising();
			retailStoreItem.clearCreation();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCreation;
	}

	public int countRetailStoreListWithFranchising(String retailStoreCreationId, String franchisingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreationId);
		key.put(RetailStore.FRANCHISING_PROPERTY, franchisingId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCreation with decoration in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithDecoration(RetailStoreCreation retailStoreCreation, String decorationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreation.getId());
		key.put(RetailStore.DECORATION_PROPERTY, decorationId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCreation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCreation;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearDecoration();
			retailStoreItem.clearCreation();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCreation;
	}

	public int countRetailStoreListWithDecoration(String retailStoreCreationId, String decorationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreationId);
		key.put(RetailStore.DECORATION_PROPERTY, decorationId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCreation with opening in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithOpening(RetailStoreCreation retailStoreCreation, String openingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreation.getId());
		key.put(RetailStore.OPENING_PROPERTY, openingId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCreation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCreation;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearOpening();
			retailStoreItem.clearCreation();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCreation;
	}

	public int countRetailStoreListWithOpening(String retailStoreCreationId, String openingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreationId);
		key.put(RetailStore.OPENING_PROPERTY, openingId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCreation with closing in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithClosing(RetailStoreCreation retailStoreCreation, String closingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreation.getId());
		key.put(RetailStore.CLOSING_PROPERTY, closingId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCreation;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCreation;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearClosing();
			retailStoreItem.clearCreation();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCreation;
	}

	public int countRetailStoreListWithClosing(String retailStoreCreationId, String closingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, retailStoreCreationId);
		key.put(RetailStore.CLOSING_PROPERTY, closingId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreCreation saveRetailStoreList(RetailStoreCreation retailStoreCreation, Map<String,Object> options){
    



		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		if(retailStoreList == null){
			//null list means nothing
			return retailStoreCreation;
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


		return retailStoreCreation;

	}

	protected RetailStoreCreation removeRetailStoreList(RetailStoreCreation retailStoreCreation, Map<String,Object> options){


		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreCreation;
		}

		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();

		if(toRemoveRetailStoreList == null){
			return retailStoreCreation;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreCreation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);

		return retailStoreCreation;

	}








		

	public RetailStoreCreation present(RetailStoreCreation retailStoreCreation,Map<String, Object> options){

		presentRetailStoreList(retailStoreCreation,options);

		return retailStoreCreation;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCreation presentRetailStoreList(
			RetailStoreCreation retailStoreCreation,
			Map<String, Object> options) {
    
		SmartList<RetailStore> retailStoreList = retailStoreCreation.getRetailStoreList();
				SmartList<RetailStore> newList= presentSubList(retailStoreCreation.getId(),
				retailStoreList,
				options,
				getRetailStoreDAO()::countRetailStoreByCreation,
				getRetailStoreDAO()::findRetailStoreByCreation
				);


		retailStoreCreation.setRetailStoreList(newList);


		return retailStoreCreation;
	}
		

	
    public SmartList<RetailStoreCreation> requestCandidateRetailStoreCreationForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCreationTable.COLUMN_COMMENT, null, filterKey, pageNo, pageSize, getRetailStoreCreationMapper());
    }
		

	protected String getTableName(){
		return RetailStoreCreationTable.TABLE_NAME;
	}



	public void enhanceList(List<RetailStoreCreation> retailStoreCreationList) {
		this.enhanceListInternal(retailStoreCreationList, this.getRetailStoreCreationMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:RetailStore的creation的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(RetailscmUserContext userContext, List<RetailStoreCreation> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CREATION_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStore> loadedObjs = userContext.getDAOGroup().getRetailStoreDAO().findRetailStoreWithKey(key, options);
		Map<String, List<RetailStore>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCreation().getId()));
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
		List<RetailStoreCreation> retailStoreCreationList = ownerEntity.collectRefsWithType(RetailStoreCreation.INTERNAL_TYPE);
		this.enhanceList(retailStoreCreationList);

	}

	@Override
	public SmartList<RetailStoreCreation> findRetailStoreCreationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getRetailStoreCreationMapper());

	}
	@Override
	public int countRetailStoreCreationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreCreationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<RetailStoreCreation> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreCreationMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<RetailStoreCreation> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getRetailStoreCreationMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateRetailStoreCreation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateRetailStoreCreation result = new CandidateRetailStoreCreation();
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
		List<Map<String, Object>> result = this.getJdbcTemplate().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = String.valueOf(data.get("id"));
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplate().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplate().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplate().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplate().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplate().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplate().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplate().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplate().execute(sql);
	}


  @Override
  public List<RetailStoreCreation> search(RetailStoreCreationRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected RetailStoreCreationMapper mapper() {
    return getRetailStoreCreationMapper();
  }
}


