
package com.doublechaintech.retailscm.accountingdocumentconfirmation;

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

public class AccountingDocumentConfirmationJDBCTemplateDAO extends RetailscmNamingServiceDAO implements AccountingDocumentConfirmationDAO{


			
		
	
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
	protected AccountingDocumentConfirmation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentConfirmation(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public AccountingDocumentConfirmation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentConfirmation(AccountingDocumentConfirmationTable.withId(id), options);
	}
	
	
	
	public AccountingDocumentConfirmation save(AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String,Object> options){
		
		String methodName="save(AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocumentConfirmation, methodName, "accountingDocumentConfirmation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocumentConfirmation(accountingDocumentConfirmation,options);
	}
	public AccountingDocumentConfirmation clone(String accountingDocumentConfirmationId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentConfirmationTable.withId(accountingDocumentConfirmationId),options);
	}
	
	protected AccountingDocumentConfirmation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentConfirmationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocumentConfirmation newAccountingDocumentConfirmation = loadInternalAccountingDocumentConfirmation(accessKey, options);
		newAccountingDocumentConfirmation.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentListEnabled(options)){
 			for(AccountingDocument item: newAccountingDocumentConfirmation.getAccountingDocumentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingDocumentConfirmation(newAccountingDocumentConfirmation,options);
		
		return newAccountingDocumentConfirmation;
	}
	
	
	
	

	protected void throwIfHasException(String accountingDocumentConfirmationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new AccountingDocumentConfirmationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentConfirmationNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentConfirmationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String accountingDocumentConfirmationId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentConfirmationId, int version)";
		assertMethodArgumentNotNull(accountingDocumentConfirmationId, methodName, "accountingDocumentConfirmationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentConfirmationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentConfirmationId,version);
		}
		
	
	}
	
	
	
	
	

	public AccountingDocumentConfirmation disconnectFromAll(String accountingDocumentConfirmationId, int version) throws Exception{
	
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = loadInternalAccountingDocumentConfirmation(AccountingDocumentConfirmationTable.withId(accountingDocumentConfirmationId), emptyOptions());
		accountingDocumentConfirmation.clearFromAll();
		this.saveAccountingDocumentConfirmation(accountingDocumentConfirmation);
		return accountingDocumentConfirmation;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return AccountingDocumentConfirmationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document_confirmation";
	}
	@Override
	protected String getBeanName() {
		
		return "accountingDocumentConfirmation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentConfirmationTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractAccountingDocumentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,AccountingDocumentConfirmationTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}

	protected boolean isSaveAccountingDocumentListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentConfirmationTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}
 	
 	
			
		

	

	protected AccountingDocumentConfirmationMapper getAccountingDocumentConfirmationMapper(){
		return new AccountingDocumentConfirmationMapper();
	}

	
	
	protected AccountingDocumentConfirmation extractAccountingDocumentConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			AccountingDocumentConfirmation accountingDocumentConfirmation = loadSingleObject(accessKey, getAccountingDocumentConfirmationMapper());
			return accountingDocumentConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentConfirmationNotFoundException("AccountingDocumentConfirmation("+accessKey+") is not found!");
		}

	}

	
	

	protected AccountingDocumentConfirmation loadInternalAccountingDocumentConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocumentConfirmation accountingDocumentConfirmation = extractAccountingDocumentConfirmation(accessKey, loadOptions);

		
		if(isExtractAccountingDocumentListEnabled(loadOptions)){
	 		extractAccountingDocumentList(accountingDocumentConfirmation, loadOptions);
 		}		
		
		return accountingDocumentConfirmation;
		
	}



	
	
	
		
	protected void enhanceAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected AccountingDocumentConfirmation extractAccountingDocumentList(AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object> options){
		
		
		if(accountingDocumentConfirmation == null){
			return null;
		}
		if(accountingDocumentConfirmation.getId() == null){
			return accountingDocumentConfirmation;
		}

		
		
		SmartList<AccountingDocument> accountingDocumentList = getAccountingDocumentDAO().findAccountingDocumentByConfirmation(accountingDocumentConfirmation.getId(),options);
		if(accountingDocumentList != null){
			enhanceAccountingDocumentList(accountingDocumentList,options);
			accountingDocumentConfirmation.setAccountingDocumentList(accountingDocumentList);
		}
		
		return accountingDocumentConfirmation;
	
	}	
		
		
 	
		
		
		

	

	protected AccountingDocumentConfirmation saveAccountingDocumentConfirmation(AccountingDocumentConfirmation  accountingDocumentConfirmation){
		
		if(!accountingDocumentConfirmation.isChanged()){
			return accountingDocumentConfirmation;
		}
		
		
		String SQL=this.getSaveAccountingDocumentConfirmationSQL(accountingDocumentConfirmation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentConfirmationParameters(accountingDocumentConfirmation);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocumentConfirmation.incVersion();
		return accountingDocumentConfirmation;
	
	}
	public SmartList<AccountingDocumentConfirmation> saveAccountingDocumentConfirmationList(SmartList<AccountingDocumentConfirmation> accountingDocumentConfirmationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentConfirmationList(accountingDocumentConfirmationList);
		
		batchAccountingDocumentConfirmationCreate((List<AccountingDocumentConfirmation>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentConfirmationUpdate((List<AccountingDocumentConfirmation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocumentConfirmation accountingDocumentConfirmation:accountingDocumentConfirmationList){
			if(accountingDocumentConfirmation.isChanged()){
				accountingDocumentConfirmation.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentConfirmationList;
	}

	public SmartList<AccountingDocumentConfirmation> removeAccountingDocumentConfirmationList(SmartList<AccountingDocumentConfirmation> accountingDocumentConfirmationList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentConfirmationList, options);
		
		return accountingDocumentConfirmationList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentConfirmationBatchCreateArgs(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentConfirmation accountingDocumentConfirmation:accountingDocumentConfirmationList ){
			Object [] parameters = prepareAccountingDocumentConfirmationCreateParameters(accountingDocumentConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentConfirmationBatchUpdateArgs(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentConfirmation accountingDocumentConfirmation:accountingDocumentConfirmationList ){
			if(!accountingDocumentConfirmation.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentConfirmationUpdateParameters(accountingDocumentConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentConfirmationCreate(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentConfirmationBatchCreateArgs(accountingDocumentConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentConfirmationUpdate(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentConfirmationBatchUpdateArgs(accountingDocumentConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentConfirmationList(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList){
		
		List<AccountingDocumentConfirmation> accountingDocumentConfirmationCreateList=new ArrayList<AccountingDocumentConfirmation>();
		List<AccountingDocumentConfirmation> accountingDocumentConfirmationUpdateList=new ArrayList<AccountingDocumentConfirmation>();
		
		for(AccountingDocumentConfirmation accountingDocumentConfirmation: accountingDocumentConfirmationList){
			if(isUpdateRequest(accountingDocumentConfirmation)){
				accountingDocumentConfirmationUpdateList.add( accountingDocumentConfirmation);
				continue;
			}
			accountingDocumentConfirmationCreateList.add(accountingDocumentConfirmation);
		}
		
		return new Object[]{accountingDocumentConfirmationCreateList,accountingDocumentConfirmationUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocumentConfirmation accountingDocumentConfirmation){
 		return accountingDocumentConfirmation.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentConfirmationSQL(AccountingDocumentConfirmation accountingDocumentConfirmation){
 		if(isUpdateRequest(accountingDocumentConfirmation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentConfirmationParameters(AccountingDocumentConfirmation accountingDocumentConfirmation){
 		if(isUpdateRequest(accountingDocumentConfirmation) ){
 			return prepareAccountingDocumentConfirmationUpdateParameters(accountingDocumentConfirmation);
 		}
 		return prepareAccountingDocumentConfirmationCreateParameters(accountingDocumentConfirmation);
 	}
 	protected Object[] prepareAccountingDocumentConfirmationUpdateParameters(AccountingDocumentConfirmation accountingDocumentConfirmation){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = accountingDocumentConfirmation.getWho();
 		parameters[1] = accountingDocumentConfirmation.getComments();
 		parameters[2] = accountingDocumentConfirmation.getMakeDate();		
 		parameters[3] = accountingDocumentConfirmation.nextVersion();
 		parameters[4] = accountingDocumentConfirmation.getId();
 		parameters[5] = accountingDocumentConfirmation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentConfirmationCreateParameters(AccountingDocumentConfirmation accountingDocumentConfirmation){
		Object[] parameters = new Object[4];
		String newAccountingDocumentConfirmationId=getNextId();
		accountingDocumentConfirmation.setId(newAccountingDocumentConfirmationId);
		parameters[0] =  accountingDocumentConfirmation.getId();
 
 		parameters[1] = accountingDocumentConfirmation.getWho();
 		parameters[2] = accountingDocumentConfirmation.getComments();
 		parameters[3] = accountingDocumentConfirmation.getMakeDate();		
 				
 		return parameters;
 	}
 	
	protected AccountingDocumentConfirmation saveInternalAccountingDocumentConfirmation(AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object> options){
		
		saveAccountingDocumentConfirmation(accountingDocumentConfirmation);

		
		if(isSaveAccountingDocumentListEnabled(options)){
	 		saveAccountingDocumentList(accountingDocumentConfirmation, options);
	 		//removeAccountingDocumentList(accountingDocumentConfirmation, options);
	 		//Not delete the record
	 		
 		}		
		
		return accountingDocumentConfirmation;
		
	}
	
	
	
	//======================================================================================
	

	
	public AccountingDocumentConfirmation planToRemoveAccountingDocumentList(AccountingDocumentConfirmation accountingDocumentConfirmation, String accountingDocumentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.CONFIRMATION_PROPERTY, accountingDocumentConfirmation.getId());
		key.put(AccountingDocument.ID_PROPERTY, accountingDocumentIds);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentConfirmation;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentConfirmation;
		}
		
		for(AccountingDocument accountingDocument: externalAccountingDocumentList){

			accountingDocument.clearFromAll();
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentConfirmation.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentConfirmation;	
	
	}


	//disconnect AccountingDocumentConfirmation with accounting_period in AccountingDocument
	public AccountingDocumentConfirmation planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentConfirmation accountingDocumentConfirmation, String accountingPeriodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.CONFIRMATION_PROPERTY, accountingDocumentConfirmation.getId());
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriodId);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentConfirmation;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentConfirmation;
		}
		
		for(AccountingDocument accountingDocument: externalAccountingDocumentList){
			accountingDocument.clearAccountingPeriod();
			accountingDocument.clearConfirmation();
			
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentConfirmation.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentConfirmation;
	}
	
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentConfirmationId, String accountingPeriodId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.CONFIRMATION_PROPERTY, accountingDocumentConfirmationId);
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriodId);
		
		int count = getAccountingDocumentDAO().countAccountingDocumentWithKey(key, options);
		return count;
	}
	
	//disconnect AccountingDocumentConfirmation with document_type in AccountingDocument
	public AccountingDocumentConfirmation planToRemoveAccountingDocumentListWithDocumentType(AccountingDocumentConfirmation accountingDocumentConfirmation, String documentTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.CONFIRMATION_PROPERTY, accountingDocumentConfirmation.getId());
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, documentTypeId);
		
		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingDocumentConfirmation;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingDocumentConfirmation;
		}
		
		for(AccountingDocument accountingDocument: externalAccountingDocumentList){
			accountingDocument.clearDocumentType();
			accountingDocument.clearConfirmation();
			
		}
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentConfirmation.getAccountingDocumentList();		
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingDocumentConfirmation;
	}
	
	public int countAccountingDocumentListWithDocumentType(String accountingDocumentConfirmationId, String documentTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.CONFIRMATION_PROPERTY, accountingDocumentConfirmationId);
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, documentTypeId);
		
		int count = getAccountingDocumentDAO().countAccountingDocumentWithKey(key, options);
		return count;
	}
	

		
	protected AccountingDocumentConfirmation saveAccountingDocumentList(AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object> options){
		
		
		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentConfirmation.getAccountingDocumentList();
		if(accountingDocumentList == null){
			//null list means nothing
			return accountingDocumentConfirmation;
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
		
		
		return accountingDocumentConfirmation;
	
	}
	
	protected AccountingDocumentConfirmation removeAccountingDocumentList(AccountingDocumentConfirmation accountingDocumentConfirmation, Map<String,Object> options){
	
	
		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentConfirmation.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingDocumentConfirmation;
		}	
	
		SmartList<AccountingDocument> toRemoveAccountingDocumentList = accountingDocumentList.getToRemoveList();
		
		if(toRemoveAccountingDocumentList == null){
			return accountingDocumentConfirmation;
		}
		if(toRemoveAccountingDocumentList.isEmpty()){
			return accountingDocumentConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentDAO().removeAccountingDocumentList(toRemoveAccountingDocumentList,options);
		
		return accountingDocumentConfirmation;
	
	}
	
	

 	
 	
	
	
	
		

	public AccountingDocumentConfirmation present(AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String, Object> options){
	
		presentAccountingDocumentList(accountingDocumentConfirmation,options);

		return accountingDocumentConfirmation;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected AccountingDocumentConfirmation presentAccountingDocumentList(
			AccountingDocumentConfirmation accountingDocumentConfirmation,
			Map<String, Object> options) {

		SmartList<AccountingDocument> accountingDocumentList = accountingDocumentConfirmation.getAccountingDocumentList();		
				SmartList<AccountingDocument> newList= presentSubList(accountingDocumentConfirmation.getId(),
				accountingDocumentList,
				options,
				getAccountingDocumentDAO()::countAccountingDocumentByConfirmation,
				getAccountingDocumentDAO()::findAccountingDocumentByConfirmation
				);

		
		accountingDocumentConfirmation.setAccountingDocumentList(newList);
		

		return accountingDocumentConfirmation;
	}			
		

	
    public SmartList<AccountingDocumentConfirmation> requestCandidateAccountingDocumentConfirmationForAccountingDocument(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(AccountingDocumentConfirmationTable.COLUMN_WHO, filterKey, pageNo, pageSize, getAccountingDocumentConfirmationMapper());
    }
		

	protected String getTableName(){
		return AccountingDocumentConfirmationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList) {		
		this.enhanceListInternal(accountingDocumentConfirmationList, this.getAccountingDocumentConfirmationMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<AccountingDocumentConfirmation> accountingDocumentConfirmationList = ownerEntity.collectRefsWithType(AccountingDocumentConfirmation.INTERNAL_TYPE);
		this.enhanceList(accountingDocumentConfirmationList);
		
	}
	
	@Override
	public SmartList<AccountingDocumentConfirmation> findAccountingDocumentConfirmationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getAccountingDocumentConfirmationMapper());

	}
	@Override
	public int countAccountingDocumentConfirmationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countAccountingDocumentConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<AccountingDocumentConfirmation> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getAccountingDocumentConfirmationMapper());
	}
}


