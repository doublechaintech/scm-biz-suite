
package com.doublechaintech.retailscm.accountingdocumentauditing;

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

public class AccountingDocumentAuditingJDBCTemplateDAO extends RetailscmNamingServiceDAO implements AccountingDocumentAuditingDAO{


			
		
	
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
	protected AccountingDocumentAuditing load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentAuditing(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public AccountingDocumentAuditing load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentAuditing(AccountingDocumentAuditingTable.withId(id), options);
	}
	
	
	
	public AccountingDocumentAuditing save(AccountingDocumentAuditing accountingDocumentAuditing,Map<String,Object> options){
		
		String methodName="save(AccountingDocumentAuditing accountingDocumentAuditing,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocumentAuditing, methodName, "accountingDocumentAuditing");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocumentAuditing(accountingDocumentAuditing,options);
	}
	public AccountingDocumentAuditing clone(String accountingDocumentAuditingId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentAuditingTable.withId(accountingDocumentAuditingId),options);
	}
	
	protected AccountingDocumentAuditing clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentAuditingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocumentAuditing newAccountingDocumentAuditing = loadInternalAccountingDocumentAuditing(accessKey, options);
		newAccountingDocumentAuditing.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentListEnabled(options)){
 			for(AccountingDocument item: newAccountingDocumentAuditing.getAccountingDocumentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingDocumentAuditing(newAccountingDocumentAuditing,options);
		
		return newAccountingDocumentAuditing;
	}
	
	
	
	

	protected void throwIfHasException(String accountingDocumentAuditingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new AccountingDocumentAuditingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentAuditingNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentAuditingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String accountingDocumentAuditingId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentAuditingId, int version)";
		assertMethodArgumentNotNull(accountingDocumentAuditingId, methodName, "accountingDocumentAuditingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentAuditingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentAuditingId,version);
		}
		
	
	}
	
	
	
	
	

	public AccountingDocumentAuditing disconnectFromAll(String accountingDocumentAuditingId, int version) throws Exception{
	
		
		AccountingDocumentAuditing accountingDocumentAuditing = loadInternalAccountingDocumentAuditing(AccountingDocumentAuditingTable.withId(accountingDocumentAuditingId), emptyOptions());
		accountingDocumentAuditing.clearFromAll();
		this.saveAccountingDocumentAuditing(accountingDocumentAuditing);
		return accountingDocumentAuditing;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return AccountingDocumentAuditingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document_auditing";
	}
	@Override
	protected String getBeanName() {
		
		return "accountingDocumentAuditing";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentAuditingTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractAccountingDocumentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,AccountingDocumentAuditingTokens.ACCOUNTING_DOCUMENT_LIST);
 	}
 	protected boolean isAnalyzeAccountingDocumentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,AccountingDocumentAuditingTokens.ACCOUNTING_DOCUMENT_LIST+".analyze");
 	}

	protected boolean isSaveAccountingDocumentListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentAuditingTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}
 	
		

	

	protected AccountingDocumentAuditingMapper getAccountingDocumentAuditingMapper(){
		return new AccountingDocumentAuditingMapper();
	}

	
	
	protected AccountingDocumentAuditing extractAccountingDocumentAuditing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			AccountingDocumentAuditing accountingDocumentAuditing = loadSingleObject(accessKey, getAccountingDocumentAuditingMapper());
			return accountingDocumentAuditing;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentAuditingNotFoundException("AccountingDocumentAuditing("+accessKey+") is not found!");
		}

	}

	
	

	protected AccountingDocumentAuditing loadInternalAccountingDocumentAuditing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocumentAuditing accountingDocumentAuditing = extractAccountingDocumentAuditing(accessKey, loadOptions);

		
		if(isExtractAccountingDocumentListEnabled(loadOptions)){
	 		extractAccountingDocumentList(accountingDocumentAuditing, loadOptions);
 		}	
 		if(isAnalyzeAccountingDocumentListEnabled(loadOptions)){
	 		// analyzeAccountingDocumentList(accountingDocumentAuditing, loadOptions);
 		}
 		
		
		return accountingDocumentAuditing;
		
	}

	
		
	protected void enhanceAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected AccountingDocumentAuditing extractAccountingDocumentList(AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object> options){
		
		
		if(accountingDocumentAuditing == null){
			return null;
		}
		if(accountingDocumentAuditing.getId() == null){
			return accountingDocumentAuditing;
		}

		
		
		SmartList<AccountingDocument> accountingDocumentList = getAccountingDocumentDAO().findAccountingDocumentByAuditing(accountingDocumentAuditing.getId(),options);
		if(accountingDocumentList != null){
			enhanceAccountingDocumentList(accountingDocumentList,options);
			accountingDocumentAuditing.setAccountingDocumentList(accountingDocumentList);
		}
		
		return accountingDocumentAuditing;
	
	}	
	
	protected AccountingDocumentAuditing analyzeAccountingDocumentList(AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object> options){
		
		
		if(accountingDocumentAuditing == null){
			return null;
		}
		if(accountingDocumentAuditing.getId() == null){
			return accountingDocumentAuditing;
		}

		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentAuditing.getAccountingDocumentList();
		if(accountingDocumentList != null){
			getAccountingDocumentDAO().analyzeAccountingDocumentByAuditing(accountingDocumentList, accountingDocumentAuditing.getId(), options);
			
		}
		
		return accountingDocumentAuditing;
	
	}	
	
		
		
 	
		
		
		

	

	protected AccountingDocumentAuditing saveAccountingDocumentAuditing(AccountingDocumentAuditing  accountingDocumentAuditing){
		
		if(!accountingDocumentAuditing.isChanged()){
			return accountingDocumentAuditing;
		}
		
		
		String SQL=this.getSaveAccountingDocumentAuditingSQL(accountingDocumentAuditing);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentAuditingParameters(accountingDocumentAuditing);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocumentAuditing.incVersion();
		return accountingDocumentAuditing;
	
	}
	public SmartList<AccountingDocumentAuditing> saveAccountingDocumentAuditingList(SmartList<AccountingDocumentAuditing> accountingDocumentAuditingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentAuditingList(accountingDocumentAuditingList);
		
		batchAccountingDocumentAuditingCreate((List<AccountingDocumentAuditing>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentAuditingUpdate((List<AccountingDocumentAuditing>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocumentAuditing accountingDocumentAuditing:accountingDocumentAuditingList){
			if(accountingDocumentAuditing.isChanged()){
				accountingDocumentAuditing.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentAuditingList;
	}

	public SmartList<AccountingDocumentAuditing> removeAccountingDocumentAuditingList(SmartList<AccountingDocumentAuditing> accountingDocumentAuditingList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentAuditingList, options);
		
		return accountingDocumentAuditingList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentAuditingBatchCreateArgs(List<AccountingDocumentAuditing> accountingDocumentAuditingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentAuditing accountingDocumentAuditing:accountingDocumentAuditingList ){
			Object [] parameters = prepareAccountingDocumentAuditingCreateParameters(accountingDocumentAuditing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentAuditingBatchUpdateArgs(List<AccountingDocumentAuditing> accountingDocumentAuditingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentAuditing accountingDocumentAuditing:accountingDocumentAuditingList ){
			if(!accountingDocumentAuditing.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentAuditingUpdateParameters(accountingDocumentAuditing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentAuditingCreate(List<AccountingDocumentAuditing> accountingDocumentAuditingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentAuditingBatchCreateArgs(accountingDocumentAuditingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentAuditingUpdate(List<AccountingDocumentAuditing> accountingDocumentAuditingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentAuditingBatchUpdateArgs(accountingDocumentAuditingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentAuditingList(List<AccountingDocumentAuditing> accountingDocumentAuditingList){
		
		List<AccountingDocumentAuditing> accountingDocumentAuditingCreateList=new ArrayList<AccountingDocumentAuditing>();
		List<AccountingDocumentAuditing> accountingDocumentAuditingUpdateList=new ArrayList<AccountingDocumentAuditing>();
		
		for(AccountingDocumentAuditing accountingDocumentAuditing: accountingDocumentAuditingList){
			if(isUpdateRequest(accountingDocumentAuditing)){
				accountingDocumentAuditingUpdateList.add( accountingDocumentAuditing);
				continue;
			}
			accountingDocumentAuditingCreateList.add(accountingDocumentAuditing);
		}
		
		return new Object[]{accountingDocumentAuditingCreateList,accountingDocumentAuditingUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocumentAuditing accountingDocumentAuditing){
 		return accountingDocumentAuditing.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentAuditingSQL(AccountingDocumentAuditing accountingDocumentAuditing){
 		if(isUpdateRequest(accountingDocumentAuditing)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentAuditingParameters(AccountingDocumentAuditing accountingDocumentAuditing){
 		if(isUpdateRequest(accountingDocumentAuditing) ){
 			return prepareAccountingDocumentAuditingUpdateParameters(accountingDocumentAuditing);
 		}
 		return prepareAccountingDocumentAuditingCreateParameters(accountingDocumentAuditing);
 	}
 	protected Object[] prepareAccountingDocumentAuditingUpdateParameters(AccountingDocumentAuditing accountingDocumentAuditing){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = accountingDocumentAuditing.getWho();
 		parameters[1] = accountingDocumentAuditing.getComments();
 		parameters[2] = accountingDocumentAuditing.getMakeDate();		
 		parameters[3] = accountingDocumentAuditing.nextVersion();
 		parameters[4] = accountingDocumentAuditing.getId();
 		parameters[5] = accountingDocumentAuditing.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentAuditingCreateParameters(AccountingDocumentAuditing accountingDocumentAuditing){
		Object[] parameters = new Object[4];
		String newAccountingDocumentAuditingId=getNextId();
		accountingDocumentAuditing.setId(newAccountingDocumentAuditingId);
		parameters[0] =  accountingDocumentAuditing.getId();
 
 		parameters[1] = accountingDocumentAuditing.getWho();
 		parameters[2] = accountingDocumentAuditing.getComments();
 		parameters[3] = accountingDocumentAuditing.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected AccountingDocumentAuditing saveInternalAccountingDocumentAuditing(AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object> options){
		
		saveAccountingDocumentAuditing(accountingDocumentAuditing);

		
		if(isSaveAccountingDocumentListEnabled(options)){
	 		saveAccountingDocumentList(accountingDocumentAuditing, options);
	 		//removeAccountingDocumentList(accountingDocumentAuditing, options);
	 		//Not delete the record
	 		
 		}		
		
		return accountingDocumentAuditing;
		
	}
	
	
	
	//======================================================================================
	

	
	public AccountingDocumentAuditing planToRemoveAccountingDocumentList(AccountingDocumentAuditing accountingDocumentAuditing, String accountingDocumentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.AUDITING_PROPERTY, accountingDocumentAuditing.getId());
		key.put(AccountingDocument.ID_PROPERTY, accountingDocumentIds);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentAuditing;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentAuditing;
		}
		
		for(AccountingDocument accountingDocument: externalAccountingDocumentList){

			accountingDocument.clearFromAll();
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentAuditing.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentAuditing;	
	
	}


	//disconnect AccountingDocumentAuditing with accounting_period in AccountingDocument
	public AccountingDocumentAuditing planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentAuditing accountingDocumentAuditing, String accountingPeriodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.AUDITING_PROPERTY, accountingDocumentAuditing.getId());
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriodId);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentAuditing;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentAuditing;
		}
		
		for(AccountingDocument accountingDocument: externalAccountingDocumentList){
			accountingDocument.clearAccountingPeriod();
			accountingDocument.clearAuditing();
			
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentAuditing.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentAuditing;
	}
	
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentAuditingId, String accountingPeriodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.AUDITING_PROPERTY, accountingDocumentAuditingId);
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriodId);
		
		int count = getAccountingDocumentDAO().countAccountingDocumentWithKey(key, options);
		return count;
	}
	
	//disconnect AccountingDocumentAuditing with document_type in AccountingDocument
	public AccountingDocumentAuditing planToRemoveAccountingDocumentListWithDocumentType(AccountingDocumentAuditing accountingDocumentAuditing, String documentTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.AUDITING_PROPERTY, accountingDocumentAuditing.getId());
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, documentTypeId);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentAuditing;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentAuditing;
		}
		
		for(AccountingDocument accountingDocument: externalAccountingDocumentList){
			accountingDocument.clearDocumentType();
			accountingDocument.clearAuditing();
			
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentAuditing.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentAuditing;
	}
	
	public int countAccountingDocumentListWithDocumentType(String accountingDocumentAuditingId, String documentTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.AUDITING_PROPERTY, accountingDocumentAuditingId);
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, documentTypeId);
		
		int count = getAccountingDocumentDAO().countAccountingDocumentWithKey(key, options);
		return count;
	}
	

		
	protected AccountingDocumentAuditing saveAccountingDocumentList(AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object> options){
		
		
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentAuditing.getAccountingDocumentList();
		if(accountingDocumentList == null){
			//null list means nothing
			return accountingDocumentAuditing;
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
		
		
		return accountingDocumentAuditing;
	
	}
	
	protected AccountingDocumentAuditing removeAccountingDocumentList(AccountingDocumentAuditing accountingDocumentAuditing, Map<String,Object> options){
	
	
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentAuditing.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentAuditing;
		}	
	
		SmartList<AccountingDocument> toRemoveAccountingDocumentList = accountingDocumentList.getToRemoveList();
		
		if(toRemoveAccountingDocumentList == null){
			return accountingDocumentAuditing;
		}
		if(toRemoveAccountingDocumentList.isEmpty()){
			return accountingDocumentAuditing;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentDAO().removeAccountingDocumentList(toRemoveAccountingDocumentList,options);
		
		return accountingDocumentAuditing;
	
	}
	
	

 	
 	
	
	
	
		

	public AccountingDocumentAuditing present(AccountingDocumentAuditing accountingDocumentAuditing,Map<String, Object> options){
	
		presentAccountingDocumentList(accountingDocumentAuditing,options);

		return accountingDocumentAuditing;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected AccountingDocumentAuditing presentAccountingDocumentList(
			AccountingDocumentAuditing accountingDocumentAuditing,
			Map<String, Object> options) {

		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentAuditing.getAccountingDocumentList();		
				SmartList<AccountingDocument> newList= presentSubList(accountingDocumentAuditing.getId(),
				accountingDocumentList,
				options,
				getAccountingDocumentDAO()::countAccountingDocumentByAuditing,
				getAccountingDocumentDAO()::findAccountingDocumentByAuditing
				);

		
		accountingDocumentAuditing.setAccountingDocumentList(newList);
		

		return accountingDocumentAuditing;
	}			
		

	
    public SmartList<AccountingDocumentAuditing> requestCandidateAccountingDocumentAuditingForAccountingDocument(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(AccountingDocumentAuditingTable.COLUMN_WHO, filterKey, pageNo, pageSize, getAccountingDocumentAuditingMapper());
    }
		

	protected String getTableName(){
		return AccountingDocumentAuditingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<AccountingDocumentAuditing> accountingDocumentAuditingList) {		
		this.enhanceListInternal(accountingDocumentAuditingList, this.getAccountingDocumentAuditingMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<AccountingDocumentAuditing> accountingDocumentAuditingList = ownerEntity.collectRefsWithType(AccountingDocumentAuditing.INTERNAL_TYPE);
		this.enhanceList(accountingDocumentAuditingList);
		
	}
	
	@Override
	public SmartList<AccountingDocumentAuditing> findAccountingDocumentAuditingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getAccountingDocumentAuditingMapper());

	}
	@Override
	public int countAccountingDocumentAuditingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countAccountingDocumentAuditingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<AccountingDocumentAuditing> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getAccountingDocumentAuditingMapper());
	}
}


