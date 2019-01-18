
package com.doublechaintech.retailscm.accountingdocumentposting;

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


import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class AccountingDocumentPostingJDBCTemplateDAO extends RetailscmNamingServiceDAO implements AccountingDocumentPostingDAO{


			
		
	
  	private  AccountingDocumentDAO  accountingDocumentDAO;
 	public void setAccountingDocumentDAO(AccountingDocumentDAO pAccountingDocumentDAO){
 	
 		if(pAccountingDocumentDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentDAO to null.");
 		}
	 	this.accountingDocumentDAO = pAccountingDocumentDAO;
 	}
 	public AccountingDocumentDAO getAccountingDocumentDAO(){
 		if(this.accountingDocumentDAO == null){
 			throw new IllegalStateException("The accountingDocumentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentDAO;
 	}	
 	
			
		

	
	/*
	protected AccountingDocumentPosting load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentPosting(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public AccountingDocumentPosting load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentPosting(AccountingDocumentPostingTable.withId(id), options);
	}
	
	
	
	public AccountingDocumentPosting save(AccountingDocumentPosting accountingDocumentPosting,Map<String,Object> options){
		
		String methodName="save(AccountingDocumentPosting accountingDocumentPosting,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocumentPosting, methodName, "accountingDocumentPosting");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocumentPosting(accountingDocumentPosting,options);
	}
	public AccountingDocumentPosting clone(String accountingDocumentPostingId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentPostingTable.withId(accountingDocumentPostingId),options);
	}
	
	protected AccountingDocumentPosting clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentPostingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocumentPosting newAccountingDocumentPosting = loadInternalAccountingDocumentPosting(accessKey, options);
		newAccountingDocumentPosting.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentListEnabled(options)){
 			for(AccountingDocument item: newAccountingDocumentPosting.getAccountingDocumentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingDocumentPosting(newAccountingDocumentPosting,options);
		
		return newAccountingDocumentPosting;
	}
	
	
	
	

	protected void throwIfHasException(String accountingDocumentPostingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new AccountingDocumentPostingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentPostingNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentPostingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String accountingDocumentPostingId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentPostingId, int version)";
		assertMethodArgumentNotNull(accountingDocumentPostingId, methodName, "accountingDocumentPostingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentPostingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentPostingId,version);
		}
		
	
	}
	
	
	
	
	

	public AccountingDocumentPosting disconnectFromAll(String accountingDocumentPostingId, int version) throws Exception{
	
		
		AccountingDocumentPosting accountingDocumentPosting = loadInternalAccountingDocumentPosting(AccountingDocumentPostingTable.withId(accountingDocumentPostingId), emptyOptions());
		accountingDocumentPosting.clearFromAll();
		this.saveAccountingDocumentPosting(accountingDocumentPosting);
		return accountingDocumentPosting;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return AccountingDocumentPostingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document_posting";
	}
	@Override
	protected String getBeanName() {
		
		return "accountingDocumentPosting";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentPostingTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractAccountingDocumentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,AccountingDocumentPostingTokens.ACCOUNTING_DOCUMENT_LIST);
 	}
 	protected boolean isAnalyzeAccountingDocumentListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,AccountingDocumentPostingTokens.ACCOUNTING_DOCUMENT_LIST+".analyze");
 	}
	
	protected boolean isSaveAccountingDocumentListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentPostingTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}
 	
		

	

	protected AccountingDocumentPostingMapper getAccountingDocumentPostingMapper(){
		return new AccountingDocumentPostingMapper();
	}

	
	
	protected AccountingDocumentPosting extractAccountingDocumentPosting(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			AccountingDocumentPosting accountingDocumentPosting = loadSingleObject(accessKey, getAccountingDocumentPostingMapper());
			return accountingDocumentPosting;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentPostingNotFoundException("AccountingDocumentPosting("+accessKey+") is not found!");
		}

	}

	
	

	protected AccountingDocumentPosting loadInternalAccountingDocumentPosting(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocumentPosting accountingDocumentPosting = extractAccountingDocumentPosting(accessKey, loadOptions);

		
		if(isExtractAccountingDocumentListEnabled(loadOptions)){
	 		extractAccountingDocumentList(accountingDocumentPosting, loadOptions);
 		}	
 		if(isAnalyzeAccountingDocumentListEnabled(loadOptions)){
	 		analyzeAccountingDocumentList(accountingDocumentPosting, loadOptions);
 		}
 		
		
		return accountingDocumentPosting;
		
	}

	
		
	protected void enhanceAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected AccountingDocumentPosting extractAccountingDocumentList(AccountingDocumentPosting accountingDocumentPosting, Map<String,Object> options){
		
		
		if(accountingDocumentPosting == null){
			return null;
		}
		if(accountingDocumentPosting.getId() == null){
			return accountingDocumentPosting;
		}

		
		
		SmartList<AccountingDocument> accountingDocumentList = getAccountingDocumentDAO().findAccountingDocumentByPosting(accountingDocumentPosting.getId(),options);
		if(accountingDocumentList != null){
			enhanceAccountingDocumentList(accountingDocumentList,options);
			accountingDocumentPosting.setAccountingDocumentList(accountingDocumentList);
		}
		
		return accountingDocumentPosting;
	
	}	
	
	protected AccountingDocumentPosting analyzeAccountingDocumentList(AccountingDocumentPosting accountingDocumentPosting, Map<String,Object> options){
		
		
		if(accountingDocumentPosting == null){
			return null;
		}
		if(accountingDocumentPosting.getId() == null){
			return accountingDocumentPosting;
		}

		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentPosting.getAccountingDocumentList();
		if(accountingDocumentList != null){
			getAccountingDocumentDAO().analyzeAccountingDocumentByPosting(accountingDocumentList, accountingDocumentPosting.getId(), options);
			
		}
		
		return accountingDocumentPosting;
	
	}	
	
		
		
 	
		
		
		

	

	protected AccountingDocumentPosting saveAccountingDocumentPosting(AccountingDocumentPosting  accountingDocumentPosting){
		
		if(!accountingDocumentPosting.isChanged()){
			return accountingDocumentPosting;
		}
		
		
		String SQL=this.getSaveAccountingDocumentPostingSQL(accountingDocumentPosting);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentPostingParameters(accountingDocumentPosting);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocumentPosting.incVersion();
		return accountingDocumentPosting;
	
	}
	public SmartList<AccountingDocumentPosting> saveAccountingDocumentPostingList(SmartList<AccountingDocumentPosting> accountingDocumentPostingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentPostingList(accountingDocumentPostingList);
		
		batchAccountingDocumentPostingCreate((List<AccountingDocumentPosting>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentPostingUpdate((List<AccountingDocumentPosting>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocumentPosting accountingDocumentPosting:accountingDocumentPostingList){
			if(accountingDocumentPosting.isChanged()){
				accountingDocumentPosting.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentPostingList;
	}

	public SmartList<AccountingDocumentPosting> removeAccountingDocumentPostingList(SmartList<AccountingDocumentPosting> accountingDocumentPostingList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentPostingList, options);
		
		return accountingDocumentPostingList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentPostingBatchCreateArgs(List<AccountingDocumentPosting> accountingDocumentPostingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentPosting accountingDocumentPosting:accountingDocumentPostingList ){
			Object [] parameters = prepareAccountingDocumentPostingCreateParameters(accountingDocumentPosting);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentPostingBatchUpdateArgs(List<AccountingDocumentPosting> accountingDocumentPostingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentPosting accountingDocumentPosting:accountingDocumentPostingList ){
			if(!accountingDocumentPosting.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentPostingUpdateParameters(accountingDocumentPosting);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentPostingCreate(List<AccountingDocumentPosting> accountingDocumentPostingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentPostingBatchCreateArgs(accountingDocumentPostingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentPostingUpdate(List<AccountingDocumentPosting> accountingDocumentPostingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentPostingBatchUpdateArgs(accountingDocumentPostingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentPostingList(List<AccountingDocumentPosting> accountingDocumentPostingList){
		
		List<AccountingDocumentPosting> accountingDocumentPostingCreateList=new ArrayList<AccountingDocumentPosting>();
		List<AccountingDocumentPosting> accountingDocumentPostingUpdateList=new ArrayList<AccountingDocumentPosting>();
		
		for(AccountingDocumentPosting accountingDocumentPosting: accountingDocumentPostingList){
			if(isUpdateRequest(accountingDocumentPosting)){
				accountingDocumentPostingUpdateList.add( accountingDocumentPosting);
				continue;
			}
			accountingDocumentPostingCreateList.add(accountingDocumentPosting);
		}
		
		return new Object[]{accountingDocumentPostingCreateList,accountingDocumentPostingUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocumentPosting accountingDocumentPosting){
 		return accountingDocumentPosting.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentPostingSQL(AccountingDocumentPosting accountingDocumentPosting){
 		if(isUpdateRequest(accountingDocumentPosting)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentPostingParameters(AccountingDocumentPosting accountingDocumentPosting){
 		if(isUpdateRequest(accountingDocumentPosting) ){
 			return prepareAccountingDocumentPostingUpdateParameters(accountingDocumentPosting);
 		}
 		return prepareAccountingDocumentPostingCreateParameters(accountingDocumentPosting);
 	}
 	protected Object[] prepareAccountingDocumentPostingUpdateParameters(AccountingDocumentPosting accountingDocumentPosting){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = accountingDocumentPosting.getWho();
 		parameters[1] = accountingDocumentPosting.getComments();
 		parameters[2] = accountingDocumentPosting.getMakeDate();		
 		parameters[3] = accountingDocumentPosting.nextVersion();
 		parameters[4] = accountingDocumentPosting.getId();
 		parameters[5] = accountingDocumentPosting.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentPostingCreateParameters(AccountingDocumentPosting accountingDocumentPosting){
		Object[] parameters = new Object[4];
		String newAccountingDocumentPostingId=getNextId();
		accountingDocumentPosting.setId(newAccountingDocumentPostingId);
		parameters[0] =  accountingDocumentPosting.getId();
 
 		parameters[1] = accountingDocumentPosting.getWho();
 		parameters[2] = accountingDocumentPosting.getComments();
 		parameters[3] = accountingDocumentPosting.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected AccountingDocumentPosting saveInternalAccountingDocumentPosting(AccountingDocumentPosting accountingDocumentPosting, Map<String,Object> options){
		
		saveAccountingDocumentPosting(accountingDocumentPosting);

		
		if(isSaveAccountingDocumentListEnabled(options)){
	 		saveAccountingDocumentList(accountingDocumentPosting, options);
	 		//removeAccountingDocumentList(accountingDocumentPosting, options);
	 		//Not delete the record
	 		
 		}		
		
		return accountingDocumentPosting;
		
	}
	
	
	
	//======================================================================================
	

	
	public AccountingDocumentPosting planToRemoveAccountingDocumentList(AccountingDocumentPosting accountingDocumentPosting, String accountingDocumentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.POSTING_PROPERTY, accountingDocumentPosting.getId());
		key.put(AccountingDocument.ID_PROPERTY, accountingDocumentIds);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentPosting;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentPosting;
		}
		
		for(AccountingDocument accountingDocument: externalAccountingDocumentList){

			accountingDocument.clearFromAll();
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentPosting.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentPosting;	
	
	}


	//disconnect AccountingDocumentPosting with accounting_period in AccountingDocument
	public AccountingDocumentPosting planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentPosting accountingDocumentPosting, String accountingPeriodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.POSTING_PROPERTY, accountingDocumentPosting.getId());
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriodId);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentPosting;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentPosting;
		}
		
		for(AccountingDocument accountingDocument: externalAccountingDocumentList){
			accountingDocument.clearAccountingPeriod();
			accountingDocument.clearPosting();
			
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentPosting.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentPosting;
	}
	
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentPostingId, String accountingPeriodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.POSTING_PROPERTY, accountingDocumentPostingId);
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriodId);
		
		int count = getAccountingDocumentDAO().countAccountingDocumentWithKey(key, options);
		return count;
	}
	
	//disconnect AccountingDocumentPosting with document_type in AccountingDocument
	public AccountingDocumentPosting planToRemoveAccountingDocumentListWithDocumentType(AccountingDocumentPosting accountingDocumentPosting, String documentTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.POSTING_PROPERTY, accountingDocumentPosting.getId());
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, documentTypeId);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentPosting;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentPosting;
		}
		
		for(AccountingDocument accountingDocument: externalAccountingDocumentList){
			accountingDocument.clearDocumentType();
			accountingDocument.clearPosting();
			
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentPosting.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentPosting;
	}
	
	public int countAccountingDocumentListWithDocumentType(String accountingDocumentPostingId, String documentTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.POSTING_PROPERTY, accountingDocumentPostingId);
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, documentTypeId);
		
		int count = getAccountingDocumentDAO().countAccountingDocumentWithKey(key, options);
		return count;
	}
	

		
	protected AccountingDocumentPosting saveAccountingDocumentList(AccountingDocumentPosting accountingDocumentPosting, Map<String,Object> options){
		
		
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentPosting.getAccountingDocumentList();
		if(accountingDocumentList == null){
			//null list means nothing
			return accountingDocumentPosting;
		}
		SmartList<AccountingDocument> mergedUpdateAccountingDocumentList = new SmartList<AccountingDocument>();
		
		
		mergedUpdateAccountingDocumentList.addAll(accountingDocumentList); 
		if(accountingDocumentList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateAccountingDocumentList.addAll(accountingDocumentList.getToRemoveList());
			accountingDocumentList.removeAll(accountingDocumentList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getAccountingDocumentDAO().saveAccountingDocumentList(mergedUpdateAccountingDocumentList,options);
		
		if(accountingDocumentList.getToRemoveList() != null){
			accountingDocumentList.removeAll(accountingDocumentList.getToRemoveList());
		}
		
		
		return accountingDocumentPosting;
	
	}
	
	protected AccountingDocumentPosting removeAccountingDocumentList(AccountingDocumentPosting accountingDocumentPosting, Map<String,Object> options){
	
	
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentPosting.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentPosting;
		}	
	
		SmartList<AccountingDocument> toRemoveAccountingDocumentList = accountingDocumentList.getToRemoveList();
		
		if(toRemoveAccountingDocumentList == null){
			return accountingDocumentPosting;
		}
		if(toRemoveAccountingDocumentList.isEmpty()){
			return accountingDocumentPosting;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentDAO().removeAccountingDocumentList(toRemoveAccountingDocumentList,options);
		
		return accountingDocumentPosting;
	
	}
	
	

 	
 	
	
	
	
		

	public AccountingDocumentPosting present(AccountingDocumentPosting accountingDocumentPosting,Map<String, Object> options){
	
		presentAccountingDocumentList(accountingDocumentPosting,options);

		return accountingDocumentPosting;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected AccountingDocumentPosting presentAccountingDocumentList(
			AccountingDocumentPosting accountingDocumentPosting,
			Map<String, Object> options) {

		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentPosting.getAccountingDocumentList();		
				SmartList<AccountingDocument> newList= presentSubList(accountingDocumentPosting.getId(),
				accountingDocumentList,
				options,
				getAccountingDocumentDAO()::countAccountingDocumentByPosting,
				getAccountingDocumentDAO()::findAccountingDocumentByPosting
				);

		
		accountingDocumentPosting.setAccountingDocumentList(newList);
		

		return accountingDocumentPosting;
	}			
		

	
    public SmartList<AccountingDocumentPosting> requestCandidateAccountingDocumentPostingForAccountingDocument(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(AccountingDocumentPostingTable.COLUMN_WHO, filterKey, pageNo, pageSize, getAccountingDocumentPostingMapper());
    }
		

	protected String getTableName(){
		return AccountingDocumentPostingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<AccountingDocumentPosting> accountingDocumentPostingList) {		
		this.enhanceListInternal(accountingDocumentPostingList, this.getAccountingDocumentPostingMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<AccountingDocumentPosting> accountingDocumentPostingList = ownerEntity.collectRefsWithType(AccountingDocumentPosting.INTERNAL_TYPE);
		this.enhanceList(accountingDocumentPostingList);
		
	}
	
	@Override
	public SmartList<AccountingDocumentPosting> findAccountingDocumentPostingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getAccountingDocumentPostingMapper());

	}
	@Override
	public int countAccountingDocumentPostingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countAccountingDocumentPostingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<AccountingDocumentPosting> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getAccountingDocumentPostingMapper());
	}
}


