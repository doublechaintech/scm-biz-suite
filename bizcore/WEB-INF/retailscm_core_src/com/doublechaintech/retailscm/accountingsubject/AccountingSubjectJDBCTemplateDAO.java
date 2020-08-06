
package com.doublechaintech.retailscm.accountingsubject;

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


import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineDAO;
import com.doublechaintech.retailscm.accountset.AccountSetDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class AccountingSubjectJDBCTemplateDAO extends RetailscmBaseDAOImpl implements AccountingSubjectDAO{

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

	protected AccountingDocumentLineDAO accountingDocumentLineDAO;
	public void setAccountingDocumentLineDAO(AccountingDocumentLineDAO accountingDocumentLineDAO){
 	
 		if(accountingDocumentLineDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentLineDAO to null.");
 		}
	 	this.accountingDocumentLineDAO = accountingDocumentLineDAO;
 	}
 	public AccountingDocumentLineDAO getAccountingDocumentLineDAO(){
 		if(this.accountingDocumentLineDAO == null){
 			throw new IllegalStateException("The accountingDocumentLineDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentLineDAO;
 	}	


	/*
	protected AccountingSubject load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingSubject(accessKey, options);
	}
	*/

	public SmartList<AccountingSubject> loadAll() {
	    return this.loadAll(getAccountingSubjectMapper());
	}

  public Stream<AccountingSubject> loadAllAsStream() {
      return this.loadAllAsStream(getAccountingSubjectMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public AccountingSubject load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingSubject(AccountingSubjectTable.withId(id), options);
	}

	

	public AccountingSubject save(AccountingSubject accountingSubject,Map<String,Object> options){

		String methodName="save(AccountingSubject accountingSubject,Map<String,Object> options)";

		assertMethodArgumentNotNull(accountingSubject, methodName, "accountingSubject");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalAccountingSubject(accountingSubject,options);
	}
	public AccountingSubject clone(String accountingSubjectId, Map<String,Object> options) throws Exception{

		return clone(AccountingSubjectTable.withId(accountingSubjectId),options);
	}

	protected AccountingSubject clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String accountingSubjectId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		AccountingSubject newAccountingSubject = loadInternalAccountingSubject(accessKey, options);
		newAccountingSubject.setVersion(0);
		
		
 		
 		if(isSaveAccountingDocumentLineListEnabled(options)){
 			for(AccountingDocumentLine item: newAccountingSubject.getAccountingDocumentLineList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalAccountingSubject(newAccountingSubject,options);

		return newAccountingSubject;
	}

	



	protected void throwIfHasException(String accountingSubjectId,int version,int count) throws Exception{
		if (count == 1) {
			throw new AccountingSubjectVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingSubjectNotFoundException(
					"The " + this.getTableName() + "(" + accountingSubjectId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String accountingSubjectId, int version) throws Exception{

		String methodName="delete(String accountingSubjectId, int version)";
		assertMethodArgumentNotNull(accountingSubjectId, methodName, "accountingSubjectId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingSubjectId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingSubjectId,version);
		}


	}






	public AccountingSubject disconnectFromAll(String accountingSubjectId, int version) throws Exception{


		AccountingSubject accountingSubject = loadInternalAccountingSubject(AccountingSubjectTable.withId(accountingSubjectId), emptyOptions());
		accountingSubject.clearFromAll();
		this.saveAccountingSubject(accountingSubject);
		return accountingSubject;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return AccountingSubjectTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "accounting_subject";
	}
	@Override
	protected String getBeanName() {

		return "accountingSubject";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingSubjectTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractAccountSetEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingSubjectTokens.ACCOUNTSET);
 	}

 	protected boolean isSaveAccountSetEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingSubjectTokens.ACCOUNTSET);
 	}
 	

 	
 
		
	
	protected boolean isExtractAccountingDocumentLineListEnabled(Map<String,Object> options){		
 		return checkOptions(options,AccountingSubjectTokens.ACCOUNTING_DOCUMENT_LINE_LIST);
 	}
 	protected boolean isAnalyzeAccountingDocumentLineListEnabled(Map<String,Object> options){		 		
 		return AccountingSubjectTokens.of(options).analyzeAccountingDocumentLineListEnabled();
 	}
	
	protected boolean isSaveAccountingDocumentLineListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingSubjectTokens.ACCOUNTING_DOCUMENT_LINE_LIST);
		
 	}
 	
		

	

	protected AccountingSubjectMapper getAccountingSubjectMapper(){
		return new AccountingSubjectMapper();
	}

	
	
	protected AccountingSubject extractAccountingSubject(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			AccountingSubject accountingSubject = loadSingleObject(accessKey, getAccountingSubjectMapper());
			return accountingSubject;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingSubjectNotFoundException("AccountingSubject("+accessKey+") is not found!");
		}

	}

	
	

	protected AccountingSubject loadInternalAccountingSubject(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingSubject accountingSubject = extractAccountingSubject(accessKey, loadOptions);
 	
 		if(isExtractAccountSetEnabled(loadOptions)){
	 		extractAccountSet(accountingSubject, loadOptions);
 		}
 
		
		if(isExtractAccountingDocumentLineListEnabled(loadOptions)){
	 		extractAccountingDocumentLineList(accountingSubject, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeAccountingDocumentLineListEnabled(loadOptions)){
	 		analyzeAccountingDocumentLineList(accountingSubject, loadOptions);
 		}
 		
		
		return accountingSubject;
		
	}

	 

 	protected AccountingSubject extractAccountSet(AccountingSubject accountingSubject, Map<String,Object> options) throws Exception{

		if(accountingSubject.getAccountSet() == null){
			return accountingSubject;
		}
		String accountSetId = accountingSubject.getAccountSet().getId();
		if( accountSetId == null){
			return accountingSubject;
		}
		AccountSet accountSet = getAccountSetDAO().load(accountSetId,options);
		if(accountSet != null){
			accountingSubject.setAccountSet(accountSet);
		}
		
 		
 		return accountingSubject;
 	}
 		
 
		
	protected void enhanceAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected AccountingSubject extractAccountingDocumentLineList(AccountingSubject accountingSubject, Map<String,Object> options){
		
		
		if(accountingSubject == null){
			return null;
		}
		if(accountingSubject.getId() == null){
			return accountingSubject;
		}

		
		
		SmartList<AccountingDocumentLine> accountingDocumentLineList = getAccountingDocumentLineDAO().findAccountingDocumentLineByAccountingSubject(accountingSubject.getId(),options);
		if(accountingDocumentLineList != null){
			enhanceAccountingDocumentLineList(accountingDocumentLineList,options);
			accountingSubject.setAccountingDocumentLineList(accountingDocumentLineList);
		}
		
		return accountingSubject;
	
	}	
	
	protected AccountingSubject analyzeAccountingDocumentLineList(AccountingSubject accountingSubject, Map<String,Object> options){
		
		
		if(accountingSubject == null){
			return null;
		}
		if(accountingSubject.getId() == null){
			return accountingSubject;
		}

		
		
		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingSubject.getAccountingDocumentLineList();
		if(accountingDocumentLineList != null){
			getAccountingDocumentLineDAO().analyzeAccountingDocumentLineByAccountingSubject(accountingDocumentLineList, accountingSubject.getId(), options);
			
		}
		
		return accountingSubject;
	
	}	
	
		
		
  	
 	public SmartList<AccountingSubject> findAccountingSubjectByAccountSet(String accountSetId,Map<String,Object> options){
 	
  		SmartList<AccountingSubject> resultList = queryWith(AccountingSubjectTable.COLUMN_ACCOUNT_SET, accountSetId, options, getAccountingSubjectMapper());
		// analyzeAccountingSubjectByAccountSet(resultList, accountSetId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AccountingSubject> findAccountingSubjectByAccountSet(String accountSetId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AccountingSubject> resultList =  queryWithRange(AccountingSubjectTable.COLUMN_ACCOUNT_SET, accountSetId, options, getAccountingSubjectMapper(), start, count);
 		//analyzeAccountingSubjectByAccountSet(resultList, accountSetId, options);
 		return resultList;
 		
 	}
 	public void analyzeAccountingSubjectByAccountSet(SmartList<AccountingSubject> resultList, String accountSetId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countAccountingSubjectByAccountSet(String accountSetId,Map<String,Object> options){

 		return countWith(AccountingSubjectTable.COLUMN_ACCOUNT_SET, accountSetId, options);
 	}
 	@Override
	public Map<String, Integer> countAccountingSubjectByAccountSetIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AccountingSubjectTable.COLUMN_ACCOUNT_SET, ids, options);
	}
 	
 	
		
		
		

	

	protected AccountingSubject saveAccountingSubject(AccountingSubject  accountingSubject){
		
		if(!accountingSubject.isChanged()){
			return accountingSubject;
		}
		

		String SQL=this.getSaveAccountingSubjectSQL(accountingSubject);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingSubjectParameters(accountingSubject);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		accountingSubject.incVersion();
		return accountingSubject;

	}
	public SmartList<AccountingSubject> saveAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingSubjectList(accountingSubjectList);

		batchAccountingSubjectCreate((List<AccountingSubject>)lists[CREATE_LIST_INDEX]);

		batchAccountingSubjectUpdate((List<AccountingSubject>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(AccountingSubject accountingSubject:accountingSubjectList){
			if(accountingSubject.isChanged()){
				accountingSubject.incVersion();
			}


		}


		return accountingSubjectList;
	}

	public SmartList<AccountingSubject> removeAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList,Map<String,Object> options){


		super.removeList(accountingSubjectList, options);

		return accountingSubjectList;


	}

	protected List<Object[]> prepareAccountingSubjectBatchCreateArgs(List<AccountingSubject> accountingSubjectList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingSubject accountingSubject:accountingSubjectList ){
			Object [] parameters = prepareAccountingSubjectCreateParameters(accountingSubject);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareAccountingSubjectBatchUpdateArgs(List<AccountingSubject> accountingSubjectList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingSubject accountingSubject:accountingSubjectList ){
			if(!accountingSubject.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingSubjectUpdateParameters(accountingSubject);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchAccountingSubjectCreate(List<AccountingSubject> accountingSubjectList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingSubjectBatchCreateArgs(accountingSubjectList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchAccountingSubjectUpdate(List<AccountingSubject> accountingSubjectList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingSubjectBatchUpdateArgs(accountingSubjectList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitAccountingSubjectList(List<AccountingSubject> accountingSubjectList){

		List<AccountingSubject> accountingSubjectCreateList=new ArrayList<AccountingSubject>();
		List<AccountingSubject> accountingSubjectUpdateList=new ArrayList<AccountingSubject>();

		for(AccountingSubject accountingSubject: accountingSubjectList){
			if(isUpdateRequest(accountingSubject)){
				accountingSubjectUpdateList.add( accountingSubject);
				continue;
			}
			accountingSubjectCreateList.add(accountingSubject);
		}

		return new Object[]{accountingSubjectCreateList,accountingSubjectUpdateList};
	}

	protected boolean isUpdateRequest(AccountingSubject accountingSubject){
 		return accountingSubject.getVersion() > 0;
 	}
 	protected String getSaveAccountingSubjectSQL(AccountingSubject accountingSubject){
 		if(isUpdateRequest(accountingSubject)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveAccountingSubjectParameters(AccountingSubject accountingSubject){
 		if(isUpdateRequest(accountingSubject) ){
 			return prepareAccountingSubjectUpdateParameters(accountingSubject);
 		}
 		return prepareAccountingSubjectCreateParameters(accountingSubject);
 	}
 	protected Object[] prepareAccountingSubjectUpdateParameters(AccountingSubject accountingSubject){
 		Object[] parameters = new Object[8];
 
 		
 		parameters[0] = accountingSubject.getAccountingSubjectCode();
 		
 		
 		parameters[1] = accountingSubject.getAccountingSubjectName();
 		
 		
 		parameters[2] = accountingSubject.getAccountingSubjectClassCode();
 		
 		
 		parameters[3] = accountingSubject.getAccountingSubjectClassName();
 		
 		if(accountingSubject.getAccountSet() != null){
 			parameters[4] = accountingSubject.getAccountSet().getId();
 		}
 
 		parameters[5] = accountingSubject.nextVersion();
 		parameters[6] = accountingSubject.getId();
 		parameters[7] = accountingSubject.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareAccountingSubjectCreateParameters(AccountingSubject accountingSubject){
		Object[] parameters = new Object[6];
        if(accountingSubject.getId() == null){
          String newAccountingSubjectId=getNextId();
          accountingSubject.setId(newAccountingSubjectId);
        }
		parameters[0] =  accountingSubject.getId();
 
 		
 		parameters[1] = accountingSubject.getAccountingSubjectCode();
 		
 		
 		parameters[2] = accountingSubject.getAccountingSubjectName();
 		
 		
 		parameters[3] = accountingSubject.getAccountingSubjectClassCode();
 		
 		
 		parameters[4] = accountingSubject.getAccountingSubjectClassName();
 		
 		if(accountingSubject.getAccountSet() != null){
 			parameters[5] = accountingSubject.getAccountSet().getId();

 		}
 		

 		return parameters;
 	}

	protected AccountingSubject saveInternalAccountingSubject(AccountingSubject accountingSubject, Map<String,Object> options){

		saveAccountingSubject(accountingSubject);

 		if(isSaveAccountSetEnabled(options)){
	 		saveAccountSet(accountingSubject, options);
 		}
 
		
		if(isSaveAccountingDocumentLineListEnabled(options)){
	 		saveAccountingDocumentLineList(accountingSubject, options);
	 		//removeAccountingDocumentLineList(accountingSubject, options);
	 		//Not delete the record

 		}
		
		return accountingSubject;

	}



	//======================================================================================
	

 	protected AccountingSubject saveAccountSet(AccountingSubject accountingSubject, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingSubject.getAccountSet() == null){
 			return accountingSubject;//do nothing when it is null
 		}

 		getAccountSetDAO().save(accountingSubject.getAccountSet(),options);
 		return accountingSubject;

 	}





 

	
	public AccountingSubject planToRemoveAccountingDocumentLineList(AccountingSubject accountingSubject, String accountingDocumentLineIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, accountingSubject.getId());
		key.put(AccountingDocumentLine.ID_PROPERTY, accountingDocumentLineIds);

		SmartList<AccountingDocumentLine> externalAccountingDocumentLineList = getAccountingDocumentLineDAO().
				findAccountingDocumentLineWithKey(key, options);
		if(externalAccountingDocumentLineList == null){
			return accountingSubject;
		}
		if(externalAccountingDocumentLineList.isEmpty()){
			return accountingSubject;
		}

		for(AccountingDocumentLine accountingDocumentLineItem: externalAccountingDocumentLineList){

			accountingDocumentLineItem.clearFromAll();
		}


		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingSubject.getAccountingDocumentLineList();
		accountingDocumentLineList.addAllToRemoveList(externalAccountingDocumentLineList);
		return accountingSubject;

	}


	//disconnect AccountingSubject with belongs_to in AccountingDocumentLine
	public AccountingSubject planToRemoveAccountingDocumentLineListWithBelongsTo(AccountingSubject accountingSubject, String belongsToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, accountingSubject.getId());
		key.put(AccountingDocumentLine.BELONGS_TO_PROPERTY, belongsToId);

		SmartList<AccountingDocumentLine> externalAccountingDocumentLineList = getAccountingDocumentLineDAO().
				findAccountingDocumentLineWithKey(key, options);
		if(externalAccountingDocumentLineList == null){
			return accountingSubject;
		}
		if(externalAccountingDocumentLineList.isEmpty()){
			return accountingSubject;
		}

		for(AccountingDocumentLine accountingDocumentLineItem: externalAccountingDocumentLineList){
			accountingDocumentLineItem.clearBelongsTo();
			accountingDocumentLineItem.clearAccountingSubject();

		}


		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingSubject.getAccountingDocumentLineList();
		accountingDocumentLineList.addAllToRemoveList(externalAccountingDocumentLineList);
		return accountingSubject;
	}

	public int countAccountingDocumentLineListWithBelongsTo(String accountingSubjectId, String belongsToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, accountingSubjectId);
		key.put(AccountingDocumentLine.BELONGS_TO_PROPERTY, belongsToId);

		int count = getAccountingDocumentLineDAO().countAccountingDocumentLineWithKey(key, options);
		return count;
	}
	

		
	protected AccountingSubject saveAccountingDocumentLineList(AccountingSubject accountingSubject, Map<String,Object> options){




		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingSubject.getAccountingDocumentLineList();
		if(accountingDocumentLineList == null){
			//null list means nothing
			return accountingSubject;
		}
		SmartList<AccountingDocumentLine> mergedUpdateAccountingDocumentLineList = new SmartList<AccountingDocumentLine>();


		mergedUpdateAccountingDocumentLineList.addAll(accountingDocumentLineList);
		if(accountingDocumentLineList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateAccountingDocumentLineList.addAll(accountingDocumentLineList.getToRemoveList());
			accountingDocumentLineList.removeAll(accountingDocumentLineList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getAccountingDocumentLineDAO().saveAccountingDocumentLineList(mergedUpdateAccountingDocumentLineList,options);

		if(accountingDocumentLineList.getToRemoveList() != null){
			accountingDocumentLineList.removeAll(accountingDocumentLineList.getToRemoveList());
		}


		return accountingSubject;

	}

	protected AccountingSubject removeAccountingDocumentLineList(AccountingSubject accountingSubject, Map<String,Object> options){


		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingSubject.getAccountingDocumentLineList();
		if(accountingDocumentLineList == null){
			return accountingSubject;
		}

		SmartList<AccountingDocumentLine> toRemoveAccountingDocumentLineList = accountingDocumentLineList.getToRemoveList();

		if(toRemoveAccountingDocumentLineList == null){
			return accountingSubject;
		}
		if(toRemoveAccountingDocumentLineList.isEmpty()){
			return accountingSubject;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getAccountingDocumentLineDAO().removeAccountingDocumentLineList(toRemoveAccountingDocumentLineList,options);

		return accountingSubject;

	}








		

	public AccountingSubject present(AccountingSubject accountingSubject,Map<String, Object> options){
	
		presentAccountingDocumentLineList(accountingSubject,options);

		return accountingSubject;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected AccountingSubject presentAccountingDocumentLineList(
			AccountingSubject accountingSubject,
			Map<String, Object> options) {

		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingSubject.getAccountingDocumentLineList();		
				SmartList<AccountingDocumentLine> newList= presentSubList(accountingSubject.getId(),
				accountingDocumentLineList,
				options,
				getAccountingDocumentLineDAO()::countAccountingDocumentLineByAccountingSubject,
				getAccountingDocumentLineDAO()::findAccountingDocumentLineByAccountingSubject
				);

		
		accountingSubject.setAccountingDocumentLineList(newList);
		

		return accountingSubject;
	}			
		

	
    public SmartList<AccountingSubject> requestCandidateAccountingSubjectForAccountingDocumentLine(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(AccountingSubjectTable.COLUMN_ACCOUNTING_SUBJECT_CODE, AccountingSubjectTable.COLUMN_ACCOUNT_SET, filterKey, pageNo, pageSize, getAccountingSubjectMapper());
    }
		

	protected String getTableName(){
		return AccountingSubjectTable.TABLE_NAME;
	}



	public void enhanceList(List<AccountingSubject> accountingSubjectList) {
		this.enhanceListInternal(accountingSubjectList, this.getAccountingSubjectMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:AccountingDocumentLine的accountingSubject的AccountingDocumentLineList
	public SmartList<AccountingDocumentLine> loadOurAccountingDocumentLineList(RetailscmUserContext userContext, List<AccountingSubject> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<AccountingDocumentLine> loadedObjs = userContext.getDAOGroup().getAccountingDocumentLineDAO().findAccountingDocumentLineWithKey(key, options);
		Map<String, List<AccountingDocumentLine>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getAccountingSubject().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<AccountingDocumentLine> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<AccountingDocumentLine> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setAccountingDocumentLineList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<AccountingSubject> accountingSubjectList = ownerEntity.collectRefsWithType(AccountingSubject.INTERNAL_TYPE);
		this.enhanceList(accountingSubjectList);

	}

	@Override
	public SmartList<AccountingSubject> findAccountingSubjectWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getAccountingSubjectMapper());

	}
	@Override
	public int countAccountingSubjectWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countAccountingSubjectWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<AccountingSubject> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getAccountingSubjectMapper());
	}

  @Override
  public Stream<AccountingSubject> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getAccountingSubjectMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateAccountingSubject executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateAccountingSubject result = new CandidateAccountingSubject();
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


