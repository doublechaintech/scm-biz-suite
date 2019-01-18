
package com.doublechaintech.retailscm.originalvoucherconfirmation;

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


import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;

import com.doublechaintech.retailscm.originalvoucher.OriginalVoucherDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class OriginalVoucherConfirmationJDBCTemplateDAO extends RetailscmNamingServiceDAO implements OriginalVoucherConfirmationDAO{


			
		
	
  	private  OriginalVoucherDAO  originalVoucherDAO;
 	public void setOriginalVoucherDAO(OriginalVoucherDAO pOriginalVoucherDAO){
 	
 		if(pOriginalVoucherDAO == null){
 			throw new IllegalStateException("Do not try to set originalVoucherDAO to null.");
 		}
	 	this.originalVoucherDAO = pOriginalVoucherDAO;
 	}
 	public OriginalVoucherDAO getOriginalVoucherDAO(){
 		if(this.originalVoucherDAO == null){
 			throw new IllegalStateException("The originalVoucherDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.originalVoucherDAO;
 	}	
 	
			
		

	
	/*
	protected OriginalVoucherConfirmation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucherConfirmation(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public OriginalVoucherConfirmation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucherConfirmation(OriginalVoucherConfirmationTable.withId(id), options);
	}
	
	
	
	public OriginalVoucherConfirmation save(OriginalVoucherConfirmation originalVoucherConfirmation,Map<String,Object> options){
		
		String methodName="save(OriginalVoucherConfirmation originalVoucherConfirmation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(originalVoucherConfirmation, methodName, "originalVoucherConfirmation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOriginalVoucherConfirmation(originalVoucherConfirmation,options);
	}
	public OriginalVoucherConfirmation clone(String originalVoucherConfirmationId, Map<String,Object> options) throws Exception{
	
		return clone(OriginalVoucherConfirmationTable.withId(originalVoucherConfirmationId),options);
	}
	
	protected OriginalVoucherConfirmation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String originalVoucherConfirmationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OriginalVoucherConfirmation newOriginalVoucherConfirmation = loadInternalOriginalVoucherConfirmation(accessKey, options);
		newOriginalVoucherConfirmation.setVersion(0);
		
		
 		
 		if(isSaveOriginalVoucherListEnabled(options)){
 			for(OriginalVoucher item: newOriginalVoucherConfirmation.getOriginalVoucherList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalOriginalVoucherConfirmation(newOriginalVoucherConfirmation,options);
		
		return newOriginalVoucherConfirmation;
	}
	
	
	
	

	protected void throwIfHasException(String originalVoucherConfirmationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new OriginalVoucherConfirmationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OriginalVoucherConfirmationNotFoundException(
					"The " + this.getTableName() + "(" + originalVoucherConfirmationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String originalVoucherConfirmationId, int version) throws Exception{
	
		String methodName="delete(String originalVoucherConfirmationId, int version)";
		assertMethodArgumentNotNull(originalVoucherConfirmationId, methodName, "originalVoucherConfirmationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{originalVoucherConfirmationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(originalVoucherConfirmationId,version);
		}
		
	
	}
	
	
	
	
	

	public OriginalVoucherConfirmation disconnectFromAll(String originalVoucherConfirmationId, int version) throws Exception{
	
		
		OriginalVoucherConfirmation originalVoucherConfirmation = loadInternalOriginalVoucherConfirmation(OriginalVoucherConfirmationTable.withId(originalVoucherConfirmationId), emptyOptions());
		originalVoucherConfirmation.clearFromAll();
		this.saveOriginalVoucherConfirmation(originalVoucherConfirmation);
		return originalVoucherConfirmation;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return OriginalVoucherConfirmationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "original_voucher_confirmation";
	}
	@Override
	protected String getBeanName() {
		
		return "originalVoucherConfirmation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OriginalVoucherConfirmationTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractOriginalVoucherListEnabled(Map<String,Object> options){		
 		return checkOptions(options,OriginalVoucherConfirmationTokens.ORIGINAL_VOUCHER_LIST);
 	}
 	protected boolean isAnalyzeOriginalVoucherListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,OriginalVoucherConfirmationTokens.ORIGINAL_VOUCHER_LIST+".analyze");
 	}
	
	protected boolean isSaveOriginalVoucherListEnabled(Map<String,Object> options){
		return checkOptions(options, OriginalVoucherConfirmationTokens.ORIGINAL_VOUCHER_LIST);
		
 	}
 	
		

	

	protected OriginalVoucherConfirmationMapper getOriginalVoucherConfirmationMapper(){
		return new OriginalVoucherConfirmationMapper();
	}

	
	
	protected OriginalVoucherConfirmation extractOriginalVoucherConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			OriginalVoucherConfirmation originalVoucherConfirmation = loadSingleObject(accessKey, getOriginalVoucherConfirmationMapper());
			return originalVoucherConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new OriginalVoucherConfirmationNotFoundException("OriginalVoucherConfirmation("+accessKey+") is not found!");
		}

	}

	
	

	protected OriginalVoucherConfirmation loadInternalOriginalVoucherConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OriginalVoucherConfirmation originalVoucherConfirmation = extractOriginalVoucherConfirmation(accessKey, loadOptions);

		
		if(isExtractOriginalVoucherListEnabled(loadOptions)){
	 		extractOriginalVoucherList(originalVoucherConfirmation, loadOptions);
 		}	
 		if(isAnalyzeOriginalVoucherListEnabled(loadOptions)){
	 		analyzeOriginalVoucherList(originalVoucherConfirmation, loadOptions);
 		}
 		
		
		return originalVoucherConfirmation;
		
	}

	
		
	protected void enhanceOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected OriginalVoucherConfirmation extractOriginalVoucherList(OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object> options){
		
		
		if(originalVoucherConfirmation == null){
			return null;
		}
		if(originalVoucherConfirmation.getId() == null){
			return originalVoucherConfirmation;
		}

		
		
		SmartList<OriginalVoucher> originalVoucherList = getOriginalVoucherDAO().findOriginalVoucherByConfirmation(originalVoucherConfirmation.getId(),options);
		if(originalVoucherList != null){
			enhanceOriginalVoucherList(originalVoucherList,options);
			originalVoucherConfirmation.setOriginalVoucherList(originalVoucherList);
		}
		
		return originalVoucherConfirmation;
	
	}	
	
	protected OriginalVoucherConfirmation analyzeOriginalVoucherList(OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object> options){
		
		
		if(originalVoucherConfirmation == null){
			return null;
		}
		if(originalVoucherConfirmation.getId() == null){
			return originalVoucherConfirmation;
		}

		
		
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherConfirmation.getOriginalVoucherList();
		if(originalVoucherList != null){
			getOriginalVoucherDAO().analyzeOriginalVoucherByConfirmation(originalVoucherList, originalVoucherConfirmation.getId(), options);
			
		}
		
		return originalVoucherConfirmation;
	
	}	
	
		
		
 	
		
		
		

	

	protected OriginalVoucherConfirmation saveOriginalVoucherConfirmation(OriginalVoucherConfirmation  originalVoucherConfirmation){
		
		if(!originalVoucherConfirmation.isChanged()){
			return originalVoucherConfirmation;
		}
		
		
		String SQL=this.getSaveOriginalVoucherConfirmationSQL(originalVoucherConfirmation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOriginalVoucherConfirmationParameters(originalVoucherConfirmation);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		originalVoucherConfirmation.incVersion();
		return originalVoucherConfirmation;
	
	}
	public SmartList<OriginalVoucherConfirmation> saveOriginalVoucherConfirmationList(SmartList<OriginalVoucherConfirmation> originalVoucherConfirmationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOriginalVoucherConfirmationList(originalVoucherConfirmationList);
		
		batchOriginalVoucherConfirmationCreate((List<OriginalVoucherConfirmation>)lists[CREATE_LIST_INDEX]);
		
		batchOriginalVoucherConfirmationUpdate((List<OriginalVoucherConfirmation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OriginalVoucherConfirmation originalVoucherConfirmation:originalVoucherConfirmationList){
			if(originalVoucherConfirmation.isChanged()){
				originalVoucherConfirmation.incVersion();
			}
			
		
		}
		
		
		return originalVoucherConfirmationList;
	}

	public SmartList<OriginalVoucherConfirmation> removeOriginalVoucherConfirmationList(SmartList<OriginalVoucherConfirmation> originalVoucherConfirmationList,Map<String,Object> options){
		
		
		super.removeList(originalVoucherConfirmationList, options);
		
		return originalVoucherConfirmationList;
		
		
	}
	
	protected List<Object[]> prepareOriginalVoucherConfirmationBatchCreateArgs(List<OriginalVoucherConfirmation> originalVoucherConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucherConfirmation originalVoucherConfirmation:originalVoucherConfirmationList ){
			Object [] parameters = prepareOriginalVoucherConfirmationCreateParameters(originalVoucherConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOriginalVoucherConfirmationBatchUpdateArgs(List<OriginalVoucherConfirmation> originalVoucherConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucherConfirmation originalVoucherConfirmation:originalVoucherConfirmationList ){
			if(!originalVoucherConfirmation.isChanged()){
				continue;
			}
			Object [] parameters = prepareOriginalVoucherConfirmationUpdateParameters(originalVoucherConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOriginalVoucherConfirmationCreate(List<OriginalVoucherConfirmation> originalVoucherConfirmationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOriginalVoucherConfirmationBatchCreateArgs(originalVoucherConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOriginalVoucherConfirmationUpdate(List<OriginalVoucherConfirmation> originalVoucherConfirmationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOriginalVoucherConfirmationBatchUpdateArgs(originalVoucherConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOriginalVoucherConfirmationList(List<OriginalVoucherConfirmation> originalVoucherConfirmationList){
		
		List<OriginalVoucherConfirmation> originalVoucherConfirmationCreateList=new ArrayList<OriginalVoucherConfirmation>();
		List<OriginalVoucherConfirmation> originalVoucherConfirmationUpdateList=new ArrayList<OriginalVoucherConfirmation>();
		
		for(OriginalVoucherConfirmation originalVoucherConfirmation: originalVoucherConfirmationList){
			if(isUpdateRequest(originalVoucherConfirmation)){
				originalVoucherConfirmationUpdateList.add( originalVoucherConfirmation);
				continue;
			}
			originalVoucherConfirmationCreateList.add(originalVoucherConfirmation);
		}
		
		return new Object[]{originalVoucherConfirmationCreateList,originalVoucherConfirmationUpdateList};
	}
	
	protected boolean isUpdateRequest(OriginalVoucherConfirmation originalVoucherConfirmation){
 		return originalVoucherConfirmation.getVersion() > 0;
 	}
 	protected String getSaveOriginalVoucherConfirmationSQL(OriginalVoucherConfirmation originalVoucherConfirmation){
 		if(isUpdateRequest(originalVoucherConfirmation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOriginalVoucherConfirmationParameters(OriginalVoucherConfirmation originalVoucherConfirmation){
 		if(isUpdateRequest(originalVoucherConfirmation) ){
 			return prepareOriginalVoucherConfirmationUpdateParameters(originalVoucherConfirmation);
 		}
 		return prepareOriginalVoucherConfirmationCreateParameters(originalVoucherConfirmation);
 	}
 	protected Object[] prepareOriginalVoucherConfirmationUpdateParameters(OriginalVoucherConfirmation originalVoucherConfirmation){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = originalVoucherConfirmation.getWho();
 		parameters[1] = originalVoucherConfirmation.getComments();
 		parameters[2] = originalVoucherConfirmation.getMakeDate();		
 		parameters[3] = originalVoucherConfirmation.nextVersion();
 		parameters[4] = originalVoucherConfirmation.getId();
 		parameters[5] = originalVoucherConfirmation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOriginalVoucherConfirmationCreateParameters(OriginalVoucherConfirmation originalVoucherConfirmation){
		Object[] parameters = new Object[4];
		String newOriginalVoucherConfirmationId=getNextId();
		originalVoucherConfirmation.setId(newOriginalVoucherConfirmationId);
		parameters[0] =  originalVoucherConfirmation.getId();
 
 		parameters[1] = originalVoucherConfirmation.getWho();
 		parameters[2] = originalVoucherConfirmation.getComments();
 		parameters[3] = originalVoucherConfirmation.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected OriginalVoucherConfirmation saveInternalOriginalVoucherConfirmation(OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object> options){
		
		saveOriginalVoucherConfirmation(originalVoucherConfirmation);

		
		if(isSaveOriginalVoucherListEnabled(options)){
	 		saveOriginalVoucherList(originalVoucherConfirmation, options);
	 		//removeOriginalVoucherList(originalVoucherConfirmation, options);
	 		//Not delete the record
	 		
 		}		
		
		return originalVoucherConfirmation;
		
	}
	
	
	
	//======================================================================================
	

	
	public OriginalVoucherConfirmation planToRemoveOriginalVoucherList(OriginalVoucherConfirmation originalVoucherConfirmation, String originalVoucherIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(OriginalVoucher.CONFIRMATION_PROPERTY, originalVoucherConfirmation.getId());
		key.put(OriginalVoucher.ID_PROPERTY, originalVoucherIds);
		
		SmartList<OriginalVoucher> externalOriginalVoucherList = getOriginalVoucherDAO().
				findOriginalVoucherWithKey(key, options);
		if(externalOriginalVoucherList == null){
			return originalVoucherConfirmation;
		}
		if(externalOriginalVoucherList.isEmpty()){
			return originalVoucherConfirmation;
		}
		
		for(OriginalVoucher originalVoucher: externalOriginalVoucherList){

			originalVoucher.clearFromAll();
		}
		
		
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherConfirmation.getOriginalVoucherList();		
		originalVoucherList.addAllToRemoveList(externalOriginalVoucherList);
		return originalVoucherConfirmation;	
	
	}


	//disconnect OriginalVoucherConfirmation with belongs_to in OriginalVoucher
	public OriginalVoucherConfirmation planToRemoveOriginalVoucherListWithBelongsTo(OriginalVoucherConfirmation originalVoucherConfirmation, String belongsToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(OriginalVoucher.CONFIRMATION_PROPERTY, originalVoucherConfirmation.getId());
		key.put(OriginalVoucher.BELONGS_TO_PROPERTY, belongsToId);
		
		SmartList<OriginalVoucher> externalOriginalVoucherList = getOriginalVoucherDAO().
				findOriginalVoucherWithKey(key, options);
		if(externalOriginalVoucherList == null){
			return originalVoucherConfirmation;
		}
		if(externalOriginalVoucherList.isEmpty()){
			return originalVoucherConfirmation;
		}
		
		for(OriginalVoucher originalVoucher: externalOriginalVoucherList){
			originalVoucher.clearBelongsTo();
			originalVoucher.clearConfirmation();
			
		}
		
		
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherConfirmation.getOriginalVoucherList();		
		originalVoucherList.addAllToRemoveList(externalOriginalVoucherList);
		return originalVoucherConfirmation;
	}
	
	public int countOriginalVoucherListWithBelongsTo(String originalVoucherConfirmationId, String belongsToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(OriginalVoucher.CONFIRMATION_PROPERTY, originalVoucherConfirmationId);
		key.put(OriginalVoucher.BELONGS_TO_PROPERTY, belongsToId);
		
		int count = getOriginalVoucherDAO().countOriginalVoucherWithKey(key, options);
		return count;
	}
	

		
	protected OriginalVoucherConfirmation saveOriginalVoucherList(OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object> options){
		
		
		
		
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherConfirmation.getOriginalVoucherList();
		if(originalVoucherList == null){
			//null list means nothing
			return originalVoucherConfirmation;
		}
		SmartList<OriginalVoucher> mergedUpdateOriginalVoucherList = new SmartList<OriginalVoucher>();
		
		
		mergedUpdateOriginalVoucherList.addAll(originalVoucherList); 
		if(originalVoucherList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateOriginalVoucherList.addAll(originalVoucherList.getToRemoveList());
			originalVoucherList.removeAll(originalVoucherList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getOriginalVoucherDAO().saveOriginalVoucherList(mergedUpdateOriginalVoucherList,options);
		
		if(originalVoucherList.getToRemoveList() != null){
			originalVoucherList.removeAll(originalVoucherList.getToRemoveList());
		}
		
		
		return originalVoucherConfirmation;
	
	}
	
	protected OriginalVoucherConfirmation removeOriginalVoucherList(OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object> options){
	
	
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherConfirmation.getOriginalVoucherList();
		if(originalVoucherList == null){
			return originalVoucherConfirmation;
		}	
	
		SmartList<OriginalVoucher> toRemoveOriginalVoucherList = originalVoucherList.getToRemoveList();
		
		if(toRemoveOriginalVoucherList == null){
			return originalVoucherConfirmation;
		}
		if(toRemoveOriginalVoucherList.isEmpty()){
			return originalVoucherConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getOriginalVoucherDAO().removeOriginalVoucherList(toRemoveOriginalVoucherList,options);
		
		return originalVoucherConfirmation;
	
	}
	
	

 	
 	
	
	
	
		

	public OriginalVoucherConfirmation present(OriginalVoucherConfirmation originalVoucherConfirmation,Map<String, Object> options){
	
		presentOriginalVoucherList(originalVoucherConfirmation,options);

		return originalVoucherConfirmation;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected OriginalVoucherConfirmation presentOriginalVoucherList(
			OriginalVoucherConfirmation originalVoucherConfirmation,
			Map<String, Object> options) {

		SmartList<OriginalVoucher> originalVoucherList = originalVoucherConfirmation.getOriginalVoucherList();		
				SmartList<OriginalVoucher> newList= presentSubList(originalVoucherConfirmation.getId(),
				originalVoucherList,
				options,
				getOriginalVoucherDAO()::countOriginalVoucherByConfirmation,
				getOriginalVoucherDAO()::findOriginalVoucherByConfirmation
				);

		
		originalVoucherConfirmation.setOriginalVoucherList(newList);
		

		return originalVoucherConfirmation;
	}			
		

	
    public SmartList<OriginalVoucherConfirmation> requestCandidateOriginalVoucherConfirmationForOriginalVoucher(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(OriginalVoucherConfirmationTable.COLUMN_WHO, filterKey, pageNo, pageSize, getOriginalVoucherConfirmationMapper());
    }
		

	protected String getTableName(){
		return OriginalVoucherConfirmationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<OriginalVoucherConfirmation> originalVoucherConfirmationList) {		
		this.enhanceListInternal(originalVoucherConfirmationList, this.getOriginalVoucherConfirmationMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<OriginalVoucherConfirmation> originalVoucherConfirmationList = ownerEntity.collectRefsWithType(OriginalVoucherConfirmation.INTERNAL_TYPE);
		this.enhanceList(originalVoucherConfirmationList);
		
	}
	
	@Override
	public SmartList<OriginalVoucherConfirmation> findOriginalVoucherConfirmationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getOriginalVoucherConfirmationMapper());

	}
	@Override
	public int countOriginalVoucherConfirmationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countOriginalVoucherConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<OriginalVoucherConfirmation> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getOriginalVoucherConfirmationMapper());
	}
}


