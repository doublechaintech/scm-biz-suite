
package com.doublechaintech.retailscm.accountingperiod;

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
import java.util.stream.Stream;

public class AccountingPeriodJDBCTemplateDAO extends RetailscmBaseDAOImpl implements AccountingPeriodDAO{

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
	protected AccountingPeriod load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingPeriod(accessKey, options);
	}
	*/

	public SmartList<AccountingPeriod> loadAll() {
	    return this.loadAll(getAccountingPeriodMapper());
	}

  public Stream<AccountingPeriod> loadAllAsStream() {
      return this.loadAllAsStream(getAccountingPeriodMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public AccountingPeriod load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingPeriod(AccountingPeriodTable.withId(id), options);
	}

	

	public AccountingPeriod save(AccountingPeriod accountingPeriod,Map<String,Object> options){

		String methodName="save(AccountingPeriod accountingPeriod,Map<String,Object> options)";

		assertMethodArgumentNotNull(accountingPeriod, methodName, "accountingPeriod");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalAccountingPeriod(accountingPeriod,options);
	}
	public AccountingPeriod clone(String accountingPeriodId, Map<String,Object> options) throws Exception{

		return clone(AccountingPeriodTable.withId(accountingPeriodId),options);
	}

	protected AccountingPeriod clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String accountingPeriodId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		AccountingPeriod newAccountingPeriod = loadInternalAccountingPeriod(accessKey, options);
		newAccountingPeriod.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentListEnabled(options)){
 			for(AccountingDocument item: newAccountingPeriod.getAccountingDocumentList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalAccountingPeriod(newAccountingPeriod,options);

		return newAccountingPeriod;
	}

	



	protected void throwIfHasException(String accountingPeriodId,int version,int count) throws Exception{
		if (count == 1) {
			throw new AccountingPeriodVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingPeriodNotFoundException(
					"The " + this.getTableName() + "(" + accountingPeriodId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String accountingPeriodId, int version) throws Exception{

		String methodName="delete(String accountingPeriodId, int version)";
		assertMethodArgumentNotNull(accountingPeriodId, methodName, "accountingPeriodId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingPeriodId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingPeriodId,version);
		}


	}






	public AccountingPeriod disconnectFromAll(String accountingPeriodId, int version) throws Exception{


		AccountingPeriod accountingPeriod = loadInternalAccountingPeriod(AccountingPeriodTable.withId(accountingPeriodId), emptyOptions());
		accountingPeriod.clearFromAll();
		this.saveAccountingPeriod(accountingPeriod);
		return accountingPeriod;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return AccountingPeriodTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "accounting_period";
	}
	@Override
	protected String getBeanName() {

		return "accountingPeriod";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingPeriodTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractAccountSetEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingPeriodTokens.ACCOUNTSET);
 	}

 	protected boolean isSaveAccountSetEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingPeriodTokens.ACCOUNTSET);
 	}
 	

 	
 
		
	
	protected boolean isExtractAccountingDocumentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,AccountingPeriodTokens.ACCOUNTING_DOCUMENT_LIST);
 	}
 	protected boolean isAnalyzeAccountingDocumentListEnabled(Map<String,Object> options){		 		
 		return AccountingPeriodTokens.of(options).analyzeAccountingDocumentListEnabled();
 	}
	
	protected boolean isSaveAccountingDocumentListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingPeriodTokens.ACCOUNTING_DOCUMENT_LIST);
		
 	}
 	
		

	

	protected AccountingPeriodMapper getAccountingPeriodMapper(){
		return new AccountingPeriodMapper();
	}

	
	
	protected AccountingPeriod extractAccountingPeriod(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			AccountingPeriod accountingPeriod = loadSingleObject(accessKey, getAccountingPeriodMapper());
			return accountingPeriod;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingPeriodNotFoundException("AccountingPeriod("+accessKey+") is not found!");
		}

	}

	
	

	protected AccountingPeriod loadInternalAccountingPeriod(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingPeriod accountingPeriod = extractAccountingPeriod(accessKey, loadOptions);
 	
 		if(isExtractAccountSetEnabled(loadOptions)){
	 		extractAccountSet(accountingPeriod, loadOptions);
 		}
 
		
		if(isExtractAccountingDocumentListEnabled(loadOptions)){
	 		extractAccountingDocumentList(accountingPeriod, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeAccountingDocumentListEnabled(loadOptions)){
	 		analyzeAccountingDocumentList(accountingPeriod, loadOptions);
 		}
 		
		
		return accountingPeriod;
		
	}

	 

 	protected AccountingPeriod extractAccountSet(AccountingPeriod accountingPeriod, Map<String,Object> options) throws Exception{

		if(accountingPeriod.getAccountSet() == null){
			return accountingPeriod;
		}
		String accountSetId = accountingPeriod.getAccountSet().getId();
		if( accountSetId == null){
			return accountingPeriod;
		}
		AccountSet accountSet = getAccountSetDAO().load(accountSetId,options);
		if(accountSet != null){
			accountingPeriod.setAccountSet(accountSet);
		}
		
 		
 		return accountingPeriod;
 	}
 		
 
		
	protected void enhanceAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected AccountingPeriod extractAccountingDocumentList(AccountingPeriod accountingPeriod, Map<String,Object> options){
		
		
		if(accountingPeriod == null){
			return null;
		}
		if(accountingPeriod.getId() == null){
			return accountingPeriod;
		}

		
		
		SmartList<AccountingDocument> accountingDocumentList = getAccountingDocumentDAO().findAccountingDocumentByAccountingPeriod(accountingPeriod.getId(),options);
		if(accountingDocumentList != null){
			enhanceAccountingDocumentList(accountingDocumentList,options);
			accountingPeriod.setAccountingDocumentList(accountingDocumentList);
		}
		
		return accountingPeriod;
	
	}	
	
	protected AccountingPeriod analyzeAccountingDocumentList(AccountingPeriod accountingPeriod, Map<String,Object> options){
		
		
		if(accountingPeriod == null){
			return null;
		}
		if(accountingPeriod.getId() == null){
			return accountingPeriod;
		}

		
		
		SmartList<AccountingDocument> accountingDocumentList = accountingPeriod.getAccountingDocumentList();
		if(accountingDocumentList != null){
			getAccountingDocumentDAO().analyzeAccountingDocumentByAccountingPeriod(accountingDocumentList, accountingPeriod.getId(), options);
			
		}
		
		return accountingPeriod;
	
	}	
	
		
		
  	
 	public SmartList<AccountingPeriod> findAccountingPeriodByAccountSet(String accountSetId,Map<String,Object> options){
 	
  		SmartList<AccountingPeriod> resultList = queryWith(AccountingPeriodTable.COLUMN_ACCOUNT_SET, accountSetId, options, getAccountingPeriodMapper());
		// analyzeAccountingPeriodByAccountSet(resultList, accountSetId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AccountingPeriod> findAccountingPeriodByAccountSet(String accountSetId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AccountingPeriod> resultList =  queryWithRange(AccountingPeriodTable.COLUMN_ACCOUNT_SET, accountSetId, options, getAccountingPeriodMapper(), start, count);
 		//analyzeAccountingPeriodByAccountSet(resultList, accountSetId, options);
 		return resultList;
 		
 	}
 	public void analyzeAccountingPeriodByAccountSet(SmartList<AccountingPeriod> resultList, String accountSetId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countAccountingPeriodByAccountSet(String accountSetId,Map<String,Object> options){

 		return countWith(AccountingPeriodTable.COLUMN_ACCOUNT_SET, accountSetId, options);
 	}
 	@Override
	public Map<String, Integer> countAccountingPeriodByAccountSetIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AccountingPeriodTable.COLUMN_ACCOUNT_SET, ids, options);
	}
 	
 	
		
		
		

	

	protected AccountingPeriod saveAccountingPeriod(AccountingPeriod  accountingPeriod){
		
		if(!accountingPeriod.isChanged()){
			return accountingPeriod;
		}
		

		String SQL=this.getSaveAccountingPeriodSQL(accountingPeriod);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingPeriodParameters(accountingPeriod);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		accountingPeriod.incVersion();
		return accountingPeriod;

	}
	public SmartList<AccountingPeriod> saveAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingPeriodList(accountingPeriodList);

		batchAccountingPeriodCreate((List<AccountingPeriod>)lists[CREATE_LIST_INDEX]);

		batchAccountingPeriodUpdate((List<AccountingPeriod>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(AccountingPeriod accountingPeriod:accountingPeriodList){
			if(accountingPeriod.isChanged()){
				accountingPeriod.incVersion();
			}


		}


		return accountingPeriodList;
	}

	public SmartList<AccountingPeriod> removeAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList,Map<String,Object> options){


		super.removeList(accountingPeriodList, options);

		return accountingPeriodList;


	}

	protected List<Object[]> prepareAccountingPeriodBatchCreateArgs(List<AccountingPeriod> accountingPeriodList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingPeriod accountingPeriod:accountingPeriodList ){
			Object [] parameters = prepareAccountingPeriodCreateParameters(accountingPeriod);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareAccountingPeriodBatchUpdateArgs(List<AccountingPeriod> accountingPeriodList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingPeriod accountingPeriod:accountingPeriodList ){
			if(!accountingPeriod.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingPeriodUpdateParameters(accountingPeriod);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchAccountingPeriodCreate(List<AccountingPeriod> accountingPeriodList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingPeriodBatchCreateArgs(accountingPeriodList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchAccountingPeriodUpdate(List<AccountingPeriod> accountingPeriodList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingPeriodBatchUpdateArgs(accountingPeriodList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitAccountingPeriodList(List<AccountingPeriod> accountingPeriodList){

		List<AccountingPeriod> accountingPeriodCreateList=new ArrayList<AccountingPeriod>();
		List<AccountingPeriod> accountingPeriodUpdateList=new ArrayList<AccountingPeriod>();

		for(AccountingPeriod accountingPeriod: accountingPeriodList){
			if(isUpdateRequest(accountingPeriod)){
				accountingPeriodUpdateList.add( accountingPeriod);
				continue;
			}
			accountingPeriodCreateList.add(accountingPeriod);
		}

		return new Object[]{accountingPeriodCreateList,accountingPeriodUpdateList};
	}

	protected boolean isUpdateRequest(AccountingPeriod accountingPeriod){
 		return accountingPeriod.getVersion() > 0;
 	}
 	protected String getSaveAccountingPeriodSQL(AccountingPeriod accountingPeriod){
 		if(isUpdateRequest(accountingPeriod)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveAccountingPeriodParameters(AccountingPeriod accountingPeriod){
 		if(isUpdateRequest(accountingPeriod) ){
 			return prepareAccountingPeriodUpdateParameters(accountingPeriod);
 		}
 		return prepareAccountingPeriodCreateParameters(accountingPeriod);
 	}
 	protected Object[] prepareAccountingPeriodUpdateParameters(AccountingPeriod accountingPeriod){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = accountingPeriod.getName();
 		
 		
 		parameters[1] = accountingPeriod.getStartDate();
 		
 		
 		parameters[2] = accountingPeriod.getEndDate();
 		
 		if(accountingPeriod.getAccountSet() != null){
 			parameters[3] = accountingPeriod.getAccountSet().getId();
 		}
 
 		parameters[4] = accountingPeriod.nextVersion();
 		parameters[5] = accountingPeriod.getId();
 		parameters[6] = accountingPeriod.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareAccountingPeriodCreateParameters(AccountingPeriod accountingPeriod){
		Object[] parameters = new Object[5];
        if(accountingPeriod.getId() == null){
          String newAccountingPeriodId=getNextId();
          accountingPeriod.setId(newAccountingPeriodId);
        }
		parameters[0] =  accountingPeriod.getId();
 
 		
 		parameters[1] = accountingPeriod.getName();
 		
 		
 		parameters[2] = accountingPeriod.getStartDate();
 		
 		
 		parameters[3] = accountingPeriod.getEndDate();
 		
 		if(accountingPeriod.getAccountSet() != null){
 			parameters[4] = accountingPeriod.getAccountSet().getId();

 		}
 		

 		return parameters;
 	}

	protected AccountingPeriod saveInternalAccountingPeriod(AccountingPeriod accountingPeriod, Map<String,Object> options){

		saveAccountingPeriod(accountingPeriod);

 		if(isSaveAccountSetEnabled(options)){
	 		saveAccountSet(accountingPeriod, options);
 		}
 
		
		if(isSaveAccountingDocumentListEnabled(options)){
	 		saveAccountingDocumentList(accountingPeriod, options);
	 		//removeAccountingDocumentList(accountingPeriod, options);
	 		//Not delete the record

 		}
		
		return accountingPeriod;

	}



	//======================================================================================
	

 	protected AccountingPeriod saveAccountSet(AccountingPeriod accountingPeriod, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingPeriod.getAccountSet() == null){
 			return accountingPeriod;//do nothing when it is null
 		}

 		getAccountSetDAO().save(accountingPeriod.getAccountSet(),options);
 		return accountingPeriod;

 	}





 

	
	public AccountingPeriod planToRemoveAccountingDocumentList(AccountingPeriod accountingPeriod, String accountingDocumentIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriod.getId());
		key.put(AccountingDocument.ID_PROPERTY, accountingDocumentIds);

		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingPeriod;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingPeriod;
		}

		for(AccountingDocument accountingDocumentItem: externalAccountingDocumentList){

			accountingDocumentItem.clearFromAll();
		}


		SmartList<AccountingDocument> accountingDocumentList = accountingPeriod.getAccountingDocumentList();
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingPeriod;

	}


	//disconnect AccountingPeriod with document_type in AccountingDocument
	public AccountingPeriod planToRemoveAccountingDocumentListWithDocumentType(AccountingPeriod accountingPeriod, String documentTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriod.getId());
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, documentTypeId);

		SmartList<AccountingDocument> externalAccountingDocumentList = getAccountingDocumentDAO().
				findAccountingDocumentWithKey(key, options);
		if(externalAccountingDocumentList == null){
			return accountingPeriod;
		}
		if(externalAccountingDocumentList.isEmpty()){
			return accountingPeriod;
		}

		for(AccountingDocument accountingDocumentItem: externalAccountingDocumentList){
			accountingDocumentItem.clearDocumentType();
			accountingDocumentItem.clearAccountingPeriod();

		}


		SmartList<AccountingDocument> accountingDocumentList = accountingPeriod.getAccountingDocumentList();
		accountingDocumentList.addAllToRemoveList(externalAccountingDocumentList);
		return accountingPeriod;
	}

	public int countAccountingDocumentListWithDocumentType(String accountingPeriodId, String documentTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriodId);
		key.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, documentTypeId);

		int count = getAccountingDocumentDAO().countAccountingDocumentWithKey(key, options);
		return count;
	}
	

		
	protected AccountingPeriod saveAccountingDocumentList(AccountingPeriod accountingPeriod, Map<String,Object> options){




		SmartList<AccountingDocument> accountingDocumentList = accountingPeriod.getAccountingDocumentList();
		if(accountingDocumentList == null){
			//null list means nothing
			return accountingPeriod;
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


		return accountingPeriod;

	}

	protected AccountingPeriod removeAccountingDocumentList(AccountingPeriod accountingPeriod, Map<String,Object> options){


		SmartList<AccountingDocument> accountingDocumentList = accountingPeriod.getAccountingDocumentList();
		if(accountingDocumentList == null){
			return accountingPeriod;
		}

		SmartList<AccountingDocument> toRemoveAccountingDocumentList = accountingDocumentList.getToRemoveList();

		if(toRemoveAccountingDocumentList == null){
			return accountingPeriod;
		}
		if(toRemoveAccountingDocumentList.isEmpty()){
			return accountingPeriod;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getAccountingDocumentDAO().removeAccountingDocumentList(toRemoveAccountingDocumentList,options);

		return accountingPeriod;

	}








		

	public AccountingPeriod present(AccountingPeriod accountingPeriod,Map<String, Object> options){
	
		presentAccountingDocumentList(accountingPeriod,options);

		return accountingPeriod;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected AccountingPeriod presentAccountingDocumentList(
			AccountingPeriod accountingPeriod,
			Map<String, Object> options) {

		SmartList<AccountingDocument> accountingDocumentList = accountingPeriod.getAccountingDocumentList();		
				SmartList<AccountingDocument> newList= presentSubList(accountingPeriod.getId(),
				accountingDocumentList,
				options,
				getAccountingDocumentDAO()::countAccountingDocumentByAccountingPeriod,
				getAccountingDocumentDAO()::findAccountingDocumentByAccountingPeriod
				);

		
		accountingPeriod.setAccountingDocumentList(newList);
		

		return accountingPeriod;
	}			
		

	
    public SmartList<AccountingPeriod> requestCandidateAccountingPeriodForAccountingDocument(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(AccountingPeriodTable.COLUMN_NAME, AccountingPeriodTable.COLUMN_ACCOUNT_SET, filterKey, pageNo, pageSize, getAccountingPeriodMapper());
    }
		

	protected String getTableName(){
		return AccountingPeriodTable.TABLE_NAME;
	}



	public void enhanceList(List<AccountingPeriod> accountingPeriodList) {
		this.enhanceListInternal(accountingPeriodList, this.getAccountingPeriodMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:AccountingDocument的accountingPeriod的AccountingDocumentList
	public SmartList<AccountingDocument> loadOurAccountingDocumentList(RetailscmUserContext userContext, List<AccountingPeriod> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<AccountingDocument> loadedObjs = userContext.getDAOGroup().getAccountingDocumentDAO().findAccountingDocumentWithKey(key, options);
		Map<String, List<AccountingDocument>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getAccountingPeriod().getId()));
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
		List<AccountingPeriod> accountingPeriodList = ownerEntity.collectRefsWithType(AccountingPeriod.INTERNAL_TYPE);
		this.enhanceList(accountingPeriodList);

	}

	@Override
	public SmartList<AccountingPeriod> findAccountingPeriodWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getAccountingPeriodMapper());

	}
	@Override
	public int countAccountingPeriodWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countAccountingPeriodWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<AccountingPeriod> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getAccountingPeriodMapper());
	}

  @Override
  public Stream<AccountingPeriod> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getAccountingPeriodMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateAccountingPeriod executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateAccountingPeriod result = new CandidateAccountingPeriod();
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


