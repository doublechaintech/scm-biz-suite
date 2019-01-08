
package com.doublechaintech.retailscm.originalvoucherauditing;

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

public class OriginalVoucherAuditingJDBCTemplateDAO extends RetailscmNamingServiceDAO implements OriginalVoucherAuditingDAO{


			
		
	
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
	protected OriginalVoucherAuditing load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucherAuditing(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public OriginalVoucherAuditing load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucherAuditing(OriginalVoucherAuditingTable.withId(id), options);
	}
	
	
	
	public OriginalVoucherAuditing save(OriginalVoucherAuditing originalVoucherAuditing,Map<String,Object> options){
		
		String methodName="save(OriginalVoucherAuditing originalVoucherAuditing,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(originalVoucherAuditing, methodName, "originalVoucherAuditing");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOriginalVoucherAuditing(originalVoucherAuditing,options);
	}
	public OriginalVoucherAuditing clone(String originalVoucherAuditingId, Map<String,Object> options) throws Exception{
	
		return clone(OriginalVoucherAuditingTable.withId(originalVoucherAuditingId),options);
	}
	
	protected OriginalVoucherAuditing clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String originalVoucherAuditingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OriginalVoucherAuditing newOriginalVoucherAuditing = loadInternalOriginalVoucherAuditing(accessKey, options);
		newOriginalVoucherAuditing.setVersion(0);
		
		
 		
 		if(isSaveOriginalVoucherListEnabled(options)){
 			for(OriginalVoucher item: newOriginalVoucherAuditing.getOriginalVoucherList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalOriginalVoucherAuditing(newOriginalVoucherAuditing,options);
		
		return newOriginalVoucherAuditing;
	}
	
	
	
	

	protected void throwIfHasException(String originalVoucherAuditingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new OriginalVoucherAuditingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OriginalVoucherAuditingNotFoundException(
					"The " + this.getTableName() + "(" + originalVoucherAuditingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String originalVoucherAuditingId, int version) throws Exception{
	
		String methodName="delete(String originalVoucherAuditingId, int version)";
		assertMethodArgumentNotNull(originalVoucherAuditingId, methodName, "originalVoucherAuditingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{originalVoucherAuditingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(originalVoucherAuditingId,version);
		}
		
	
	}
	
	
	
	
	

	public OriginalVoucherAuditing disconnectFromAll(String originalVoucherAuditingId, int version) throws Exception{
	
		
		OriginalVoucherAuditing originalVoucherAuditing = loadInternalOriginalVoucherAuditing(OriginalVoucherAuditingTable.withId(originalVoucherAuditingId), emptyOptions());
		originalVoucherAuditing.clearFromAll();
		this.saveOriginalVoucherAuditing(originalVoucherAuditing);
		return originalVoucherAuditing;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return OriginalVoucherAuditingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "original_voucher_auditing";
	}
	@Override
	protected String getBeanName() {
		
		return "originalVoucherAuditing";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OriginalVoucherAuditingTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractOriginalVoucherListEnabled(Map<String,Object> options){		
 		return checkOptions(options,OriginalVoucherAuditingTokens.ORIGINAL_VOUCHER_LIST);
 	}
 	protected boolean isAnalyzeOriginalVoucherListEnabled(Map<String,Object> options){		
 		return checkOptions(options,OriginalVoucherAuditingTokens.ORIGINAL_VOUCHER_LIST+".analyze");
 	}

	protected boolean isSaveOriginalVoucherListEnabled(Map<String,Object> options){
		return checkOptions(options, OriginalVoucherAuditingTokens.ORIGINAL_VOUCHER_LIST);
		
 	}
 	
		

	

	protected OriginalVoucherAuditingMapper getOriginalVoucherAuditingMapper(){
		return new OriginalVoucherAuditingMapper();
	}

	
	
	protected OriginalVoucherAuditing extractOriginalVoucherAuditing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			OriginalVoucherAuditing originalVoucherAuditing = loadSingleObject(accessKey, getOriginalVoucherAuditingMapper());
			return originalVoucherAuditing;
		}catch(EmptyResultDataAccessException e){
			throw new OriginalVoucherAuditingNotFoundException("OriginalVoucherAuditing("+accessKey+") is not found!");
		}

	}

	
	

	protected OriginalVoucherAuditing loadInternalOriginalVoucherAuditing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OriginalVoucherAuditing originalVoucherAuditing = extractOriginalVoucherAuditing(accessKey, loadOptions);

		
		if(isExtractOriginalVoucherListEnabled(loadOptions)){
	 		extractOriginalVoucherList(originalVoucherAuditing, loadOptions);
 		}	
 		if(isAnalyzeOriginalVoucherListEnabled(loadOptions)){
	 		// analyzeOriginalVoucherList(originalVoucherAuditing, loadOptions);
 		}
 		
		
		return originalVoucherAuditing;
		
	}

	
		
	protected void enhanceOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected OriginalVoucherAuditing extractOriginalVoucherList(OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object> options){
		
		
		if(originalVoucherAuditing == null){
			return null;
		}
		if(originalVoucherAuditing.getId() == null){
			return originalVoucherAuditing;
		}

		
		
		SmartList<OriginalVoucher> originalVoucherList = getOriginalVoucherDAO().findOriginalVoucherByAuditing(originalVoucherAuditing.getId(),options);
		if(originalVoucherList != null){
			enhanceOriginalVoucherList(originalVoucherList,options);
			originalVoucherAuditing.setOriginalVoucherList(originalVoucherList);
		}
		
		return originalVoucherAuditing;
	
	}	
	
	protected OriginalVoucherAuditing analyzeOriginalVoucherList(OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object> options){
		
		
		if(originalVoucherAuditing == null){
			return null;
		}
		if(originalVoucherAuditing.getId() == null){
			return originalVoucherAuditing;
		}

		
		
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherAuditing.getOriginalVoucherList();
		if(originalVoucherList != null){
			getOriginalVoucherDAO().analyzeOriginalVoucherByAuditing(originalVoucherList, originalVoucherAuditing.getId(), options);
			
		}
		
		return originalVoucherAuditing;
	
	}	
	
		
		
 	
		
		
		

	

	protected OriginalVoucherAuditing saveOriginalVoucherAuditing(OriginalVoucherAuditing  originalVoucherAuditing){
		
		if(!originalVoucherAuditing.isChanged()){
			return originalVoucherAuditing;
		}
		
		
		String SQL=this.getSaveOriginalVoucherAuditingSQL(originalVoucherAuditing);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOriginalVoucherAuditingParameters(originalVoucherAuditing);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		originalVoucherAuditing.incVersion();
		return originalVoucherAuditing;
	
	}
	public SmartList<OriginalVoucherAuditing> saveOriginalVoucherAuditingList(SmartList<OriginalVoucherAuditing> originalVoucherAuditingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOriginalVoucherAuditingList(originalVoucherAuditingList);
		
		batchOriginalVoucherAuditingCreate((List<OriginalVoucherAuditing>)lists[CREATE_LIST_INDEX]);
		
		batchOriginalVoucherAuditingUpdate((List<OriginalVoucherAuditing>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OriginalVoucherAuditing originalVoucherAuditing:originalVoucherAuditingList){
			if(originalVoucherAuditing.isChanged()){
				originalVoucherAuditing.incVersion();
			}
			
		
		}
		
		
		return originalVoucherAuditingList;
	}

	public SmartList<OriginalVoucherAuditing> removeOriginalVoucherAuditingList(SmartList<OriginalVoucherAuditing> originalVoucherAuditingList,Map<String,Object> options){
		
		
		super.removeList(originalVoucherAuditingList, options);
		
		return originalVoucherAuditingList;
		
		
	}
	
	protected List<Object[]> prepareOriginalVoucherAuditingBatchCreateArgs(List<OriginalVoucherAuditing> originalVoucherAuditingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucherAuditing originalVoucherAuditing:originalVoucherAuditingList ){
			Object [] parameters = prepareOriginalVoucherAuditingCreateParameters(originalVoucherAuditing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOriginalVoucherAuditingBatchUpdateArgs(List<OriginalVoucherAuditing> originalVoucherAuditingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucherAuditing originalVoucherAuditing:originalVoucherAuditingList ){
			if(!originalVoucherAuditing.isChanged()){
				continue;
			}
			Object [] parameters = prepareOriginalVoucherAuditingUpdateParameters(originalVoucherAuditing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOriginalVoucherAuditingCreate(List<OriginalVoucherAuditing> originalVoucherAuditingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOriginalVoucherAuditingBatchCreateArgs(originalVoucherAuditingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOriginalVoucherAuditingUpdate(List<OriginalVoucherAuditing> originalVoucherAuditingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOriginalVoucherAuditingBatchUpdateArgs(originalVoucherAuditingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOriginalVoucherAuditingList(List<OriginalVoucherAuditing> originalVoucherAuditingList){
		
		List<OriginalVoucherAuditing> originalVoucherAuditingCreateList=new ArrayList<OriginalVoucherAuditing>();
		List<OriginalVoucherAuditing> originalVoucherAuditingUpdateList=new ArrayList<OriginalVoucherAuditing>();
		
		for(OriginalVoucherAuditing originalVoucherAuditing: originalVoucherAuditingList){
			if(isUpdateRequest(originalVoucherAuditing)){
				originalVoucherAuditingUpdateList.add( originalVoucherAuditing);
				continue;
			}
			originalVoucherAuditingCreateList.add(originalVoucherAuditing);
		}
		
		return new Object[]{originalVoucherAuditingCreateList,originalVoucherAuditingUpdateList};
	}
	
	protected boolean isUpdateRequest(OriginalVoucherAuditing originalVoucherAuditing){
 		return originalVoucherAuditing.getVersion() > 0;
 	}
 	protected String getSaveOriginalVoucherAuditingSQL(OriginalVoucherAuditing originalVoucherAuditing){
 		if(isUpdateRequest(originalVoucherAuditing)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOriginalVoucherAuditingParameters(OriginalVoucherAuditing originalVoucherAuditing){
 		if(isUpdateRequest(originalVoucherAuditing) ){
 			return prepareOriginalVoucherAuditingUpdateParameters(originalVoucherAuditing);
 		}
 		return prepareOriginalVoucherAuditingCreateParameters(originalVoucherAuditing);
 	}
 	protected Object[] prepareOriginalVoucherAuditingUpdateParameters(OriginalVoucherAuditing originalVoucherAuditing){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = originalVoucherAuditing.getWho();
 		parameters[1] = originalVoucherAuditing.getComments();
 		parameters[2] = originalVoucherAuditing.getMakeDate();		
 		parameters[3] = originalVoucherAuditing.nextVersion();
 		parameters[4] = originalVoucherAuditing.getId();
 		parameters[5] = originalVoucherAuditing.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOriginalVoucherAuditingCreateParameters(OriginalVoucherAuditing originalVoucherAuditing){
		Object[] parameters = new Object[4];
		String newOriginalVoucherAuditingId=getNextId();
		originalVoucherAuditing.setId(newOriginalVoucherAuditingId);
		parameters[0] =  originalVoucherAuditing.getId();
 
 		parameters[1] = originalVoucherAuditing.getWho();
 		parameters[2] = originalVoucherAuditing.getComments();
 		parameters[3] = originalVoucherAuditing.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected OriginalVoucherAuditing saveInternalOriginalVoucherAuditing(OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object> options){
		
		saveOriginalVoucherAuditing(originalVoucherAuditing);

		
		if(isSaveOriginalVoucherListEnabled(options)){
	 		saveOriginalVoucherList(originalVoucherAuditing, options);
	 		//removeOriginalVoucherList(originalVoucherAuditing, options);
	 		//Not delete the record
	 		
 		}		
		
		return originalVoucherAuditing;
		
	}
	
	
	
	//======================================================================================
	

	
	public OriginalVoucherAuditing planToRemoveOriginalVoucherList(OriginalVoucherAuditing originalVoucherAuditing, String originalVoucherIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(OriginalVoucher.AUDITING_PROPERTY, originalVoucherAuditing.getId());
		key.put(OriginalVoucher.ID_PROPERTY, originalVoucherIds);
		
		SmartList<OriginalVoucher> externalOriginalVoucherList = getOriginalVoucherDAO().
				findOriginalVoucherWithKey(key, options);
		if(externalOriginalVoucherList == null){
			return originalVoucherAuditing;
		}
		if(externalOriginalVoucherList.isEmpty()){
			return originalVoucherAuditing;
		}
		
		for(OriginalVoucher originalVoucher: externalOriginalVoucherList){

			originalVoucher.clearFromAll();
		}
		
		
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherAuditing.getOriginalVoucherList();		
		originalVoucherList.addAllToRemoveList(externalOriginalVoucherList);
		return originalVoucherAuditing;	
	
	}


	//disconnect OriginalVoucherAuditing with belongs_to in OriginalVoucher
	public OriginalVoucherAuditing planToRemoveOriginalVoucherListWithBelongsTo(OriginalVoucherAuditing originalVoucherAuditing, String belongsToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(OriginalVoucher.AUDITING_PROPERTY, originalVoucherAuditing.getId());
		key.put(OriginalVoucher.BELONGS_TO_PROPERTY, belongsToId);
		
		SmartList<OriginalVoucher> externalOriginalVoucherList = getOriginalVoucherDAO().
				findOriginalVoucherWithKey(key, options);
		if(externalOriginalVoucherList == null){
			return originalVoucherAuditing;
		}
		if(externalOriginalVoucherList.isEmpty()){
			return originalVoucherAuditing;
		}
		
		for(OriginalVoucher originalVoucher: externalOriginalVoucherList){
			originalVoucher.clearBelongsTo();
			originalVoucher.clearAuditing();
			
		}
		
		
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherAuditing.getOriginalVoucherList();		
		originalVoucherList.addAllToRemoveList(externalOriginalVoucherList);
		return originalVoucherAuditing;
	}
	
	public int countOriginalVoucherListWithBelongsTo(String originalVoucherAuditingId, String belongsToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(OriginalVoucher.AUDITING_PROPERTY, originalVoucherAuditingId);
		key.put(OriginalVoucher.BELONGS_TO_PROPERTY, belongsToId);
		
		int count = getOriginalVoucherDAO().countOriginalVoucherWithKey(key, options);
		return count;
	}
	

		
	protected OriginalVoucherAuditing saveOriginalVoucherList(OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object> options){
		
		
		
		
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherAuditing.getOriginalVoucherList();
		if(originalVoucherList == null){
			//null list means nothing
			return originalVoucherAuditing;
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
		
		
		return originalVoucherAuditing;
	
	}
	
	protected OriginalVoucherAuditing removeOriginalVoucherList(OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object> options){
	
	
		SmartList<OriginalVoucher> originalVoucherList = originalVoucherAuditing.getOriginalVoucherList();
		if(originalVoucherList == null){
			return originalVoucherAuditing;
		}	
	
		SmartList<OriginalVoucher> toRemoveOriginalVoucherList = originalVoucherList.getToRemoveList();
		
		if(toRemoveOriginalVoucherList == null){
			return originalVoucherAuditing;
		}
		if(toRemoveOriginalVoucherList.isEmpty()){
			return originalVoucherAuditing;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getOriginalVoucherDAO().removeOriginalVoucherList(toRemoveOriginalVoucherList,options);
		
		return originalVoucherAuditing;
	
	}
	
	

 	
 	
	
	
	
		

	public OriginalVoucherAuditing present(OriginalVoucherAuditing originalVoucherAuditing,Map<String, Object> options){
	
		presentOriginalVoucherList(originalVoucherAuditing,options);

		return originalVoucherAuditing;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected OriginalVoucherAuditing presentOriginalVoucherList(
			OriginalVoucherAuditing originalVoucherAuditing,
			Map<String, Object> options) {

		SmartList<OriginalVoucher> originalVoucherList = originalVoucherAuditing.getOriginalVoucherList();		
				SmartList<OriginalVoucher> newList= presentSubList(originalVoucherAuditing.getId(),
				originalVoucherList,
				options,
				getOriginalVoucherDAO()::countOriginalVoucherByAuditing,
				getOriginalVoucherDAO()::findOriginalVoucherByAuditing
				);

		
		originalVoucherAuditing.setOriginalVoucherList(newList);
		

		return originalVoucherAuditing;
	}			
		

	
    public SmartList<OriginalVoucherAuditing> requestCandidateOriginalVoucherAuditingForOriginalVoucher(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(OriginalVoucherAuditingTable.COLUMN_WHO, filterKey, pageNo, pageSize, getOriginalVoucherAuditingMapper());
    }
		

	protected String getTableName(){
		return OriginalVoucherAuditingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<OriginalVoucherAuditing> originalVoucherAuditingList) {		
		this.enhanceListInternal(originalVoucherAuditingList, this.getOriginalVoucherAuditingMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<OriginalVoucherAuditing> originalVoucherAuditingList = ownerEntity.collectRefsWithType(OriginalVoucherAuditing.INTERNAL_TYPE);
		this.enhanceList(originalVoucherAuditingList);
		
	}
	
	@Override
	public SmartList<OriginalVoucherAuditing> findOriginalVoucherAuditingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getOriginalVoucherAuditingMapper());

	}
	@Override
	public int countOriginalVoucherAuditingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countOriginalVoucherAuditingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<OriginalVoucherAuditing> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getOriginalVoucherAuditingMapper());
	}
}


