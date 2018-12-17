
package com.doublechaintech.retailscm.accountingdocumentcreation;

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

public class AccountingDocumentCreationJDBCTemplateDAO extends RetailscmNamingServiceDAO implements AccountingDocumentCreationDAO{


			
		
	
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
	protected AccountingDocumentCreation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentCreation(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public AccountingDocumentCreation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentCreation(AccountingDocumentCreationTable.withId(id), options);
	}
	
	
	
	public AccountingDocumentCreation save(AccountingDocumentCreation accountingDocumentCreation,Map<String,Object> options){
		
		String methodName="save(AccountingDocumentCreation accountingDocumentCreation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocumentCreation, methodName, "accountingDocumentCreation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocumentCreation(accountingDocumentCreation,options);
	}
	public AccountingDocumentCreation clone(String accountingDocumentCreationId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentCreationTable.withId(accountingDocumentCreationId),options);
	}
	
	protected AccountingDocumentCreation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentCreationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocumentCreation newAccountingDocumentCreation = loadInternalAccountingDocumentCreation(accessKey, options);
		newAccountingDocumentCreation.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentListEnabled(options)){
 			for(AccountingDocument item: newAccountingDocumentCreation.getAccountingDocumentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingDocumentCreation(newAccountingDocumentCreation,options);
		
		return newAccountingDocumentCreation;
	}
	
	
	
	

	protected void throwIfHasException(String accountingDocumentCreationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new AccountingDocumentCreationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentCreationNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentCreationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String accountingDocumentCreationId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentCreationId, int version)";
		assertMethodArgumentNotNull(accountingDocumentCreationId, methodName, "accountingDocumentCreationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentCreationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentCreationId,version);
		}
		
	
	}
	
	
	
	
	

	public AccountingDocumentCreation disconnectFromAll(String accountingDocumentCreationId, int version) throws Exception{
	
		
		AccountingDocumentCreation accountingDocumentCreation = loadInternalAccountingDocumentCreation(AccountingDocumentCreationTable.withId(accountingDocumentCreationId), emptyOptions());
		accountingDocumentCreation.clearFromAll();
		this.saveAccountingDocumentCreation(accountingDocumentCreation);
		return accountingDocumentCreation;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return AccountingDocumentCreationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document_creation";
	}
	@Override
	protected String getBeanName() {
		
		return "accountingDocumentCreation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentCreationTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractAccountingDocumentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountingDocumentCreationTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}

	protected boolean isSaveAccountingDocumentListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentCreationTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}
 	
 	
			
		

	

	protected AccountingDocumentCreationMapper getAccountingDocumentCreationMapper(){
		return new AccountingDocumentCreationMapper();
	}

	
	
	protected AccountingDocumentCreation extractAccountingDocumentCreation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			AccountingDocumentCreation accountingDocumentCreation = loadSingleObject(accessKey, getAccountingDocumentCreationMapper());
			return accountingDocumentCreation;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentCreationNotFoundException("AccountingDocumentCreation("+accessKey+") is not found!");
		}

	}

	
	

	protected AccountingDocumentCreation loadInternalAccountingDocumentCreation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocumentCreation accountingDocumentCreation = extractAccountingDocumentCreation(accessKey, loadOptions);

		
		if(isExtractAccountingDocumentListEnabled(loadOptions)){
	 		extractAccountingDocumentList(accountingDocumentCreation, loadOptions);
 		}		
		
		return accountingDocumentCreation;
		
	}



	
	
	
		
	protected void enhanceAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected AccountingDocumentCreation extractAccountingDocumentList(AccountingDocumentCreation accountingDocumentCreation, Map<String,Object> options){
		
		
		if(accountingDocumentCreation == null){
			return null;
		}
		if(accountingDocumentCreation.getId() == null){
			return accountingDocumentCreation;
		}

		
		
		SmartList<AccountingDocument> accountingDocumentList = getAccountingDocumentDAO().findAccountingDocumentByCreation(accountingDocumentCreation.getId(),options);
		if(accountingDocumentList != null){
			enhanceAccountingDocumentList(accountingDocumentList,options);
			accountingDocumentCreation.setAccountingDocumentList(accountingDocumentList);
		}
		
		return accountingDocumentCreation;
	
	}	
		
		
 	
		
		
		

	

	protected AccountingDocumentCreation saveAccountingDocumentCreation(AccountingDocumentCreation  accountingDocumentCreation){
		
		if(!accountingDocumentCreation.isChanged()){
			return accountingDocumentCreation;
		}
		
		
		String SQL=this.getSaveAccountingDocumentCreationSQL(accountingDocumentCreation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentCreationParameters(accountingDocumentCreation);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocumentCreation.incVersion();
		return accountingDocumentCreation;
	
	}
	public SmartList<AccountingDocumentCreation> saveAccountingDocumentCreationList(SmartList<AccountingDocumentCreation> accountingDocumentCreationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentCreationList(accountingDocumentCreationList);
		
		batchAccountingDocumentCreationCreate((List<AccountingDocumentCreation>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentCreationUpdate((List<AccountingDocumentCreation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocumentCreation accountingDocumentCreation:accountingDocumentCreationList){
			if(accountingDocumentCreation.isChanged()){
				accountingDocumentCreation.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentCreationList;
	}

	public SmartList<AccountingDocumentCreation> removeAccountingDocumentCreationList(SmartList<AccountingDocumentCreation> accountingDocumentCreationList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentCreationList, options);
		
		return accountingDocumentCreationList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentCreationBatchCreateArgs(List<AccountingDocumentCreation> accountingDocumentCreationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentCreation accountingDocumentCreation:accountingDocumentCreationList ){
			Object [] parameters = prepareAccountingDocumentCreationCreateParameters(accountingDocumentCreation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentCreationBatchUpdateArgs(List<AccountingDocumentCreation> accountingDocumentCreationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentCreation accountingDocumentCreation:accountingDocumentCreationList ){
			if(!accountingDocumentCreation.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentCreationUpdateParameters(accountingDocumentCreation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentCreationCreate(List<AccountingDocumentCreation> accountingDocumentCreationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentCreationBatchCreateArgs(accountingDocumentCreationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentCreationUpdate(List<AccountingDocumentCreation> accountingDocumentCreationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentCreationBatchUpdateArgs(accountingDocumentCreationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentCreationList(List<AccountingDocumentCreation> accountingDocumentCreationList){
		
		List<AccountingDocumentCreation> accountingDocumentCreationCreateList=new ArrayList<AccountingDocumentCreation>();
		List<AccountingDocumentCreation> accountingDocumentCreationUpdateList=new ArrayList<AccountingDocumentCreation>();
		
		for(AccountingDocumentCreation accountingDocumentCreation: accountingDocumentCreationList){
			if(isUpdateRequest(accountingDocumentCreation)){
				accountingDocumentCreationUpdateList.add( accountingDocumentCreation);
				continue;
			}
			accountingDocumentCreationCreateList.add(accountingDocumentCreation);
		}
		
		return new Object[]{accountingDocumentCreationCreateList,accountingDocumentCreationUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocumentCreation accountingDocumentCreation){
 		return accountingDocumentCreation.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentCreationSQL(AccountingDocumentCreation accountingDocumentCreation){
 		if(isUpdateRequest(accountingDocumentCreation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentCreationParameters(AccountingDocumentCreation accountingDocumentCreation){
 		if(isUpdateRequest(accountingDocumentCreation) ){
 			return prepareAccountingDocumentCreationUpdateParameters(accountingDocumentCreation);
 		}
 		return prepareAccountingDocumentCreationCreateParameters(accountingDocumentCreation);
 	}
 	protected Object[] prepareAccountingDocumentCreationUpdateParameters(AccountingDocumentCreation accountingDocumentCreation){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = accountingDocumentCreation.getWho();
 		parameters[1] = accountingDocumentCreation.getComments();
 		parameters[2] = accountingDocumentCreation.getMakeDate();		
 		parameters[3] = accountingDocumentCreation.nextVersion();
 		parameters[4] = accountingDocumentCreation.getId();
 		parameters[5] = accountingDocumentCreation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentCreationCreateParameters(AccountingDocumentCreation accountingDocumentCreation){
		Object[] parameters = new Object[4];
		String newAccountingDocumentCreationId=getNextId();
		accountingDocumentCreation.setId(newAccountingDocumentCreationId);
		parameters[0] =  accountingDocumentCreation.getId();
 
 		parameters[1] = accountingDocumentCreation.getWho();
 		parameters[2] = accountingDocumentCreation.getComments();
 		parameters[3] = accountingDocumentCreation.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected AccountingDocumentCreation saveInternalAccountingDocumentCreation(AccountingDocumentCreation accountingDocumentCreation, Map<String,Object> options){
		
		saveAccountingDocumentCreation(accountingDocumentCreation);

		
		if(isSaveAccountingDocumentListEnabled(options)){
	 		saveAccountingDocumentList(accountingDocumentCreation, options);
	 		//removeAccountingDocumentList(accountingDocumentCreation, options);
	 		//Not delete the record
	 		
 		}		
		
		return accountingDocumentCreation;
		
	}
	
	
	
	//======================================================================================
	

	
	public AccountingDocumentCreation planToRemoveAccountingDocumentList(AccountingDocumentCreation accountingDocumentCreation, String accountingDocumentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.CREATION_PROPERTY, accountingDocumentCreation.getId());
		key.put(AccountingDocument.ID_PROPERTY, accountingDocumentIds);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentCreation;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentCreation;
		}
		
		for(AccountingDocument accountingDocument: externalAccountingDocumentList){

			accountingDocument.clearFromAll();
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentCreation.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentCreation;	
	
	}


	//disconnect AccountingDocumentCreation with accounting_period in AccountingDocument
	public AccountingDocumentCreation planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentCreation accountingDocumentCreation, String accountingPeriodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.CREATION_PROPERTY, accountingDocumentCreation.getId());
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriodId);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentCreation;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentCreation;
		}
		
		for(AccountingDocument accountingDocument: externalAccountingDocumentList){
			accountingDocument.clearAccountingPeriod();
			accountingDocument.clearCreation();
			
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentCreation.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentCreation;
	}
	
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentCreationId, String accountingPeriodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.CREATION_PROPERTY, accountingDocumentCreationId);
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriodId);
		
		int count = getAccountingDocumentDAO().countAccountingDocumentWithKey(key, options);
		return count;
	}
	
	//disconnect AccountingDocumentCreation with document_type in AccountingDocument
	public AccountingDocumentCreation planToRemoveAccountingDocumentListWithDocumentType(AccountingDocumentCreation accountingDocumentCreation, String documentTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.CREATION_PROPERTY, accountingDocumentCreation.getId());
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, documentTypeId);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentCreation;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentCreation;
		}
		
		for(AccountingDocument accountingDocument: externalAccountingDocumentList){
			accountingDocument.clearDocumentType();
			accountingDocument.clearCreation();
			
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentCreation.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentCreation;
	}
	
	public int countAccountingDocumentListWithDocumentType(String accountingDocumentCreationId, String documentTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.CREATION_PROPERTY, accountingDocumentCreationId);
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, documentTypeId);
		
		int count = getAccountingDocumentDAO().countAccountingDocumentWithKey(key, options);
		return count;
	}
	

		
	protected AccountingDocumentCreation saveAccountingDocumentList(AccountingDocumentCreation accountingDocumentCreation, Map<String,Object> options){
		
		
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentCreation.getAccountingDocumentList();
		if(accountingDocumentList == null){
			//null list means nothing
			return accountingDocumentCreation;
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
		
		
		return accountingDocumentCreation;
	
	}
	
	protected AccountingDocumentCreation removeAccountingDocumentList(AccountingDocumentCreation accountingDocumentCreation, Map<String,Object> options){
	
	
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentCreation.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentCreation;
		}	
	
		SmartList<AccountingDocument> toRemoveAccountingDocumentList = accountingDocumentList.getToRemoveList();
		
		if(toRemoveAccountingDocumentList == null){
			return accountingDocumentCreation;
		}
		if(toRemoveAccountingDocumentList.isEmpty()){
			return accountingDocumentCreation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentDAO().removeAccountingDocumentList(toRemoveAccountingDocumentList,options);
		
		return accountingDocumentCreation;
	
	}
	
	

 	
 	
	
	
	
		

	public AccountingDocumentCreation present(AccountingDocumentCreation accountingDocumentCreation,Map<String, Object> options){
	
		presentAccountingDocumentList(accountingDocumentCreation,options);

		return accountingDocumentCreation;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected AccountingDocumentCreation presentAccountingDocumentList(
			AccountingDocumentCreation accountingDocumentCreation,
			Map<String, Object> options) {

		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentCreation.getAccountingDocumentList();		
				SmartList<AccountingDocument> newList= presentSubList(accountingDocumentCreation.getId(),
				accountingDocumentList,
				options,
				getAccountingDocumentDAO()::countAccountingDocumentByCreation,
				getAccountingDocumentDAO()::findAccountingDocumentByCreation
				);

		
		accountingDocumentCreation.setAccountingDocumentList(newList);
		

		return accountingDocumentCreation;
	}			
		

	
    public SmartList<AccountingDocumentCreation> requestCandidateAccountingDocumentCreationForAccountingDocument(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(AccountingDocumentCreationTable.COLUMN_WHO, filterKey, pageNo, pageSize, getAccountingDocumentCreationMapper());
    }
		

	protected String getTableName(){
		return AccountingDocumentCreationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<AccountingDocumentCreation> accountingDocumentCreationList) {		
		this.enhanceListInternal(accountingDocumentCreationList, this.getAccountingDocumentCreationMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<AccountingDocumentCreation> accountingDocumentCreationList = ownerEntity.collectRefsWithType(AccountingDocumentCreation.INTERNAL_TYPE);
		this.enhanceList(accountingDocumentCreationList);
		
	}
	
	@Override
	public SmartList<AccountingDocumentCreation> findAccountingDocumentCreationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getAccountingDocumentCreationMapper());

	}
	@Override
	public int countAccountingDocumentCreationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countAccountingDocumentCreationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<AccountingDocumentCreation> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getAccountingDocumentCreationMapper());
	}
}


