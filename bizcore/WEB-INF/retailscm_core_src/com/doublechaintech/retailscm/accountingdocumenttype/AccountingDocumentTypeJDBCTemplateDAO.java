
package com.doublechaintech.retailscm.accountingdocumenttype;

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


import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.accountset.AccountSetDAO;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class AccountingDocumentTypeJDBCTemplateDAO extends RetailscmBaseDAOImpl implements AccountingDocumentTypeDAO{

	protected AccountSetDAO accountSetDAO;
	public void setAccountSetDAO(AccountSetDAO accountSetDAO){
 	
 		if(accountSetDAO == null){
 			throw new IllegalStateException("Do not try to set accountSetDAO to null.");
 		}
	 	this.accountSetDAO = accountSetDAO;
 	}
 	public AccountSetDAO getAccountSetDAO(){
 		if(this.accountSetDAO == null){
 			throw new IllegalStateException("The accountSetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountSetDAO;
 	}	

	protected AccountingDocumentDAO accountingDocumentDAO;
	public void setAccountingDocumentDAO(AccountingDocumentDAO accountingDocumentDAO){
 	
 		if(accountingDocumentDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentDAO to null.");
 		}
	 	this.accountingDocumentDAO = accountingDocumentDAO;
 	}
 	public AccountingDocumentDAO getAccountingDocumentDAO(){
 		if(this.accountingDocumentDAO == null){
 			throw new IllegalStateException("The accountingDocumentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentDAO;
 	}	

	
	/*
	protected AccountingDocumentType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentType(accessKey, options);
	}
	*/
	
	public SmartList<AccountingDocumentType> loadAll() {
	    return this.loadAll(getAccountingDocumentTypeMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public AccountingDocumentType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentType(AccountingDocumentTypeTable.withId(id), options);
	}
	
	
	
	public AccountingDocumentType save(AccountingDocumentType accountingDocumentType,Map<String,Object> options){
		
		String methodName="save(AccountingDocumentType accountingDocumentType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocumentType, methodName, "accountingDocumentType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocumentType(accountingDocumentType,options);
	}
	public AccountingDocumentType clone(String accountingDocumentTypeId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentTypeTable.withId(accountingDocumentTypeId),options);
	}
	
	protected AccountingDocumentType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocumentType newAccountingDocumentType = loadInternalAccountingDocumentType(accessKey, options);
		newAccountingDocumentType.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentListEnabled(options)){
 			for(AccountingDocument item: newAccountingDocumentType.getAccountingDocumentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingDocumentType(newAccountingDocumentType,options);
		
		return newAccountingDocumentType;
	}
	
	
	
	

	protected void throwIfHasException(String accountingDocumentTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new AccountingDocumentTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentTypeNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String accountingDocumentTypeId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentTypeId, int version)";
		assertMethodArgumentNotNull(accountingDocumentTypeId, methodName, "accountingDocumentTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentTypeId,version);
		}
		
	
	}
	
	
	
	
	

	public AccountingDocumentType disconnectFromAll(String accountingDocumentTypeId, int version) throws Exception{
	
		
		AccountingDocumentType accountingDocumentType = loadInternalAccountingDocumentType(AccountingDocumentTypeTable.withId(accountingDocumentTypeId), emptyOptions());
		accountingDocumentType.clearFromAll();
		this.saveAccountingDocumentType(accountingDocumentType);
		return accountingDocumentType;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return AccountingDocumentTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document_type";
	}
	@Override
	protected String getBeanName() {
		
		return "accountingDocumentType";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentTypeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractAccountingPeriodEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTypeTokens.ACCOUNTINGPERIOD);
 	}

 	protected boolean isSaveAccountingPeriodEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTypeTokens.ACCOUNTINGPERIOD);
 	}
 	

 	
 
		
	
	protected boolean isExtractAccountingDocumentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,AccountingDocumentTypeTokens.ACCOUNTING_DOCUMENT_LIST);
 	}
 	protected boolean isAnalyzeAccountingDocumentListEnabled(Map<String,Object> options){		 		
 		return AccountingDocumentTypeTokens.of(options).analyzeAccountingDocumentListEnabled();
 	}
	
	protected boolean isSaveAccountingDocumentListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentTypeTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}
 	
		

	

	protected AccountingDocumentTypeMapper getAccountingDocumentTypeMapper(){
		return new AccountingDocumentTypeMapper();
	}

	
	
	protected AccountingDocumentType extractAccountingDocumentType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			AccountingDocumentType accountingDocumentType = loadSingleObject(accessKey, getAccountingDocumentTypeMapper());
			return accountingDocumentType;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentTypeNotFoundException("AccountingDocumentType("+accessKey+") is not found!");
		}

	}

	
	

	protected AccountingDocumentType loadInternalAccountingDocumentType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocumentType accountingDocumentType = extractAccountingDocumentType(accessKey, loadOptions);
 	
 		if(isExtractAccountingPeriodEnabled(loadOptions)){
	 		extractAccountingPeriod(accountingDocumentType, loadOptions);
 		}
 
		
		if(isExtractAccountingDocumentListEnabled(loadOptions)){
	 		extractAccountingDocumentList(accountingDocumentType, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeAccountingDocumentListEnabled(loadOptions)){
	 		analyzeAccountingDocumentList(accountingDocumentType, loadOptions);
 		}
 		
		
		return accountingDocumentType;
		
	}

	 

 	protected AccountingDocumentType extractAccountingPeriod(AccountingDocumentType accountingDocumentType, Map<String,Object> options) throws Exception{

		if(accountingDocumentType.getAccountingPeriod() == null){
			return accountingDocumentType;
		}
		String accountingPeriodId = accountingDocumentType.getAccountingPeriod().getId();
		if( accountingPeriodId == null){
			return accountingDocumentType;
		}
		AccountSet accountingPeriod = getAccountSetDAO().load(accountingPeriodId,options);
		if(accountingPeriod != null){
			accountingDocumentType.setAccountingPeriod(accountingPeriod);
		}
		
 		
 		return accountingDocumentType;
 	}
 		
 
		
	protected void enhanceAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected AccountingDocumentType extractAccountingDocumentList(AccountingDocumentType accountingDocumentType, Map<String,Object> options){
		
		
		if(accountingDocumentType == null){
			return null;
		}
		if(accountingDocumentType.getId() == null){
			return accountingDocumentType;
		}

		
		
		SmartList<AccountingDocument> accountingDocumentList = getAccountingDocumentDAO().findAccountingDocumentByDocumentType(accountingDocumentType.getId(),options);
		if(accountingDocumentList != null){
			enhanceAccountingDocumentList(accountingDocumentList,options);
			accountingDocumentType.setAccountingDocumentList(accountingDocumentList);
		}
		
		return accountingDocumentType;
	
	}	
	
	protected AccountingDocumentType analyzeAccountingDocumentList(AccountingDocumentType accountingDocumentType, Map<String,Object> options){
		
		
		if(accountingDocumentType == null){
			return null;
		}
		if(accountingDocumentType.getId() == null){
			return accountingDocumentType;
		}

		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentType.getAccountingDocumentList();
		if(accountingDocumentList != null){
			getAccountingDocumentDAO().analyzeAccountingDocumentByDocumentType(accountingDocumentList, accountingDocumentType.getId(), options);
			
		}
		
		return accountingDocumentType;
	
	}	
	
		
		
  	
 	public SmartList<AccountingDocumentType> findAccountingDocumentTypeByAccountingPeriod(String accountSetId,Map<String,Object> options){
 	
  		SmartList<AccountingDocumentType> resultList = queryWith(AccountingDocumentTypeTable.COLUMN_ACCOUNTING_PERIOD, accountSetId, options, getAccountingDocumentTypeMapper());
		// analyzeAccountingDocumentTypeByAccountingPeriod(resultList, accountSetId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AccountingDocumentType> findAccountingDocumentTypeByAccountingPeriod(String accountSetId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AccountingDocumentType> resultList =  queryWithRange(AccountingDocumentTypeTable.COLUMN_ACCOUNTING_PERIOD, accountSetId, options, getAccountingDocumentTypeMapper(), start, count);
 		//analyzeAccountingDocumentTypeByAccountingPeriod(resultList, accountSetId, options);
 		return resultList;
 		
 	}
 	public void analyzeAccountingDocumentTypeByAccountingPeriod(SmartList<AccountingDocumentType> resultList, String accountSetId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countAccountingDocumentTypeByAccountingPeriod(String accountSetId,Map<String,Object> options){

 		return countWith(AccountingDocumentTypeTable.COLUMN_ACCOUNTING_PERIOD, accountSetId, options);
 	}
 	@Override
	public Map<String, Integer> countAccountingDocumentTypeByAccountingPeriodIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AccountingDocumentTypeTable.COLUMN_ACCOUNTING_PERIOD, ids, options);
	}
 	
 	
		
		
		

	

	protected AccountingDocumentType saveAccountingDocumentType(AccountingDocumentType  accountingDocumentType){
		
		if(!accountingDocumentType.isChanged()){
			return accountingDocumentType;
		}
		
		
		String SQL=this.getSaveAccountingDocumentTypeSQL(accountingDocumentType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentTypeParameters(accountingDocumentType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocumentType.incVersion();
		return accountingDocumentType;
	
	}
	public SmartList<AccountingDocumentType> saveAccountingDocumentTypeList(SmartList<AccountingDocumentType> accountingDocumentTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentTypeList(accountingDocumentTypeList);
		
		batchAccountingDocumentTypeCreate((List<AccountingDocumentType>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentTypeUpdate((List<AccountingDocumentType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocumentType accountingDocumentType:accountingDocumentTypeList){
			if(accountingDocumentType.isChanged()){
				accountingDocumentType.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentTypeList;
	}

	public SmartList<AccountingDocumentType> removeAccountingDocumentTypeList(SmartList<AccountingDocumentType> accountingDocumentTypeList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentTypeList, options);
		
		return accountingDocumentTypeList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentTypeBatchCreateArgs(List<AccountingDocumentType> accountingDocumentTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentType accountingDocumentType:accountingDocumentTypeList ){
			Object [] parameters = prepareAccountingDocumentTypeCreateParameters(accountingDocumentType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentTypeBatchUpdateArgs(List<AccountingDocumentType> accountingDocumentTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentType accountingDocumentType:accountingDocumentTypeList ){
			if(!accountingDocumentType.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentTypeUpdateParameters(accountingDocumentType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentTypeCreate(List<AccountingDocumentType> accountingDocumentTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentTypeBatchCreateArgs(accountingDocumentTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentTypeUpdate(List<AccountingDocumentType> accountingDocumentTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentTypeBatchUpdateArgs(accountingDocumentTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentTypeList(List<AccountingDocumentType> accountingDocumentTypeList){
		
		List<AccountingDocumentType> accountingDocumentTypeCreateList=new ArrayList<AccountingDocumentType>();
		List<AccountingDocumentType> accountingDocumentTypeUpdateList=new ArrayList<AccountingDocumentType>();
		
		for(AccountingDocumentType accountingDocumentType: accountingDocumentTypeList){
			if(isUpdateRequest(accountingDocumentType)){
				accountingDocumentTypeUpdateList.add( accountingDocumentType);
				continue;
			}
			accountingDocumentTypeCreateList.add(accountingDocumentType);
		}
		
		return new Object[]{accountingDocumentTypeCreateList,accountingDocumentTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocumentType accountingDocumentType){
 		return accountingDocumentType.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentTypeSQL(AccountingDocumentType accountingDocumentType){
 		if(isUpdateRequest(accountingDocumentType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentTypeParameters(AccountingDocumentType accountingDocumentType){
 		if(isUpdateRequest(accountingDocumentType) ){
 			return prepareAccountingDocumentTypeUpdateParameters(accountingDocumentType);
 		}
 		return prepareAccountingDocumentTypeCreateParameters(accountingDocumentType);
 	}
 	protected Object[] prepareAccountingDocumentTypeUpdateParameters(AccountingDocumentType accountingDocumentType){
 		Object[] parameters = new Object[6];
 
 		
 		parameters[0] = accountingDocumentType.getName();
 		
 		
 		parameters[1] = accountingDocumentType.getDescription();
 		 	
 		if(accountingDocumentType.getAccountingPeriod() != null){
 			parameters[2] = accountingDocumentType.getAccountingPeriod().getId();
 		}
 		
 		parameters[3] = accountingDocumentType.nextVersion();
 		parameters[4] = accountingDocumentType.getId();
 		parameters[5] = accountingDocumentType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentTypeCreateParameters(AccountingDocumentType accountingDocumentType){
		Object[] parameters = new Object[4];
		String newAccountingDocumentTypeId=getNextId();
		accountingDocumentType.setId(newAccountingDocumentTypeId);
		parameters[0] =  accountingDocumentType.getId();
 
 		
 		parameters[1] = accountingDocumentType.getName();
 		
 		
 		parameters[2] = accountingDocumentType.getDescription();
 		 	
 		if(accountingDocumentType.getAccountingPeriod() != null){
 			parameters[3] = accountingDocumentType.getAccountingPeriod().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected AccountingDocumentType saveInternalAccountingDocumentType(AccountingDocumentType accountingDocumentType, Map<String,Object> options){
		
		saveAccountingDocumentType(accountingDocumentType);
 	
 		if(isSaveAccountingPeriodEnabled(options)){
	 		saveAccountingPeriod(accountingDocumentType, options);
 		}
 
		
		if(isSaveAccountingDocumentListEnabled(options)){
	 		saveAccountingDocumentList(accountingDocumentType, options);
	 		//removeAccountingDocumentList(accountingDocumentType, options);
	 		//Not delete the record
	 		
 		}		
		
		return accountingDocumentType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected AccountingDocumentType saveAccountingPeriod(AccountingDocumentType accountingDocumentType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocumentType.getAccountingPeriod() == null){
 			return accountingDocumentType;//do nothing when it is null
 		}
 		
 		getAccountSetDAO().save(accountingDocumentType.getAccountingPeriod(),options);
 		return accountingDocumentType;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public AccountingDocumentType planToRemoveAccountingDocumentList(AccountingDocumentType accountingDocumentType, String accountingDocumentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, accountingDocumentType.getId());
		key.put(AccountingDocument.ID_PROPERTY, accountingDocumentIds);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentType;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentType;
		}
		
		for(AccountingDocument accountingDocumentItem: externalAccountingDocumentList){

			accountingDocumentItem.clearFromAll();
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentType.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentType;	
	
	}


	//disconnect AccountingDocumentType with accounting_period in AccountingDocument
	public AccountingDocumentType planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentType accountingDocumentType, String accountingPeriodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, accountingDocumentType.getId());
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriodId);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentType;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentType;
		}
		
		for(AccountingDocument accountingDocumentItem: externalAccountingDocumentList){
			accountingDocumentItem.clearAccountingPeriod();
			accountingDocumentItem.clearDocumentType();
			
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentType.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentType;
	}
	
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentTypeId, String accountingPeriodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, accountingDocumentTypeId);
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriodId);
		
		int count = getAccountingDocumentDAO().countAccountingDocumentWithKey(key, options);
		return count;
	}
	

		
	protected AccountingDocumentType saveAccountingDocumentList(AccountingDocumentType accountingDocumentType, Map<String,Object> options){
		
		
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentType.getAccountingDocumentList();
		if(accountingDocumentList == null){
			//null list means nothing
			return accountingDocumentType;
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
		
		
		return accountingDocumentType;
	
	}
	
	protected AccountingDocumentType removeAccountingDocumentList(AccountingDocumentType accountingDocumentType, Map<String,Object> options){
	
	
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentType.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentType;
		}	
	
		SmartList<AccountingDocument> toRemoveAccountingDocumentList = accountingDocumentList.getToRemoveList();
		
		if(toRemoveAccountingDocumentList == null){
			return accountingDocumentType;
		}
		if(toRemoveAccountingDocumentList.isEmpty()){
			return accountingDocumentType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentDAO().removeAccountingDocumentList(toRemoveAccountingDocumentList,options);
		
		return accountingDocumentType;
	
	}
	
	

 	
 	
	
	
	
		

	public AccountingDocumentType present(AccountingDocumentType accountingDocumentType,Map<String, Object> options){
	
		presentAccountingDocumentList(accountingDocumentType,options);

		return accountingDocumentType;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected AccountingDocumentType presentAccountingDocumentList(
			AccountingDocumentType accountingDocumentType,
			Map<String, Object> options) {

		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentType.getAccountingDocumentList();		
				SmartList<AccountingDocument> newList= presentSubList(accountingDocumentType.getId(),
				accountingDocumentList,
				options,
				getAccountingDocumentDAO()::countAccountingDocumentByDocumentType,
				getAccountingDocumentDAO()::findAccountingDocumentByDocumentType
				);

		
		accountingDocumentType.setAccountingDocumentList(newList);
		

		return accountingDocumentType;
	}			
		

	
    public SmartList<AccountingDocumentType> requestCandidateAccountingDocumentTypeForAccountingDocument(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(AccountingDocumentTypeTable.COLUMN_NAME, AccountingDocumentTypeTable.COLUMN_ACCOUNTING_PERIOD, filterKey, pageNo, pageSize, getAccountingDocumentTypeMapper());
    }
		

	protected String getTableName(){
		return AccountingDocumentTypeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<AccountingDocumentType> accountingDocumentTypeList) {		
		this.enhanceListInternal(accountingDocumentTypeList, this.getAccountingDocumentTypeMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:AccountingDocument的documentType的AccountingDocumentList
	public SmartList<AccountingDocument> loadOurAccountingDocumentList(RetailscmUserContext userContext, List<AccountingDocumentType> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<AccountingDocument> loadedObjs = userContext.getDAOGroup().getAccountingDocumentDAO().findAccountingDocumentWithKey(key, options);
		Map<String, List<AccountingDocument>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getDocumentType().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<AccountingDocument> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<AccountingDocument> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setAccountingDocumentList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<AccountingDocumentType> accountingDocumentTypeList = ownerEntity.collectRefsWithType(AccountingDocumentType.INTERNAL_TYPE);
		this.enhanceList(accountingDocumentTypeList);
		
	}
	
	@Override
	public SmartList<AccountingDocumentType> findAccountingDocumentTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getAccountingDocumentTypeMapper());

	}
	@Override
	public int countAccountingDocumentTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countAccountingDocumentTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<AccountingDocumentType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getAccountingDocumentTypeMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateAccountingDocumentType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateAccountingDocumentType result = new CandidateAccountingDocumentType();
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
	
	

}


