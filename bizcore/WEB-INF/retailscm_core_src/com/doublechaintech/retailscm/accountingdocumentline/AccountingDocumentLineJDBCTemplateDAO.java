
package com.doublechaintech.retailscm.accountingdocumentline;

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


import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;

import com.doublechaintech.retailscm.accountingsubject.AccountingSubjectDAO;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class AccountingDocumentLineJDBCTemplateDAO extends RetailscmBaseDAOImpl implements AccountingDocumentLineDAO{

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

	protected AccountingSubjectDAO accountingSubjectDAO;
	public void setAccountingSubjectDAO(AccountingSubjectDAO accountingSubjectDAO){

 		if(accountingSubjectDAO == null){
 			throw new IllegalStateException("Do not try to set accountingSubjectDAO to null.");
 		}
	 	this.accountingSubjectDAO = accountingSubjectDAO;
 	}
 	public AccountingSubjectDAO getAccountingSubjectDAO(){
 		if(this.accountingSubjectDAO == null){
 			throw new IllegalStateException("The accountingSubjectDAO is not configured yet, please config it some where.");
 		}

	 	return this.accountingSubjectDAO;
 	}



	/*
	protected AccountingDocumentLine load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentLine(accessKey, options);
	}
	*/

	public SmartList<AccountingDocumentLine> loadAll() {
	    return this.loadAll(getAccountingDocumentLineMapper());
	}

  public Stream<AccountingDocumentLine> loadAllAsStream() {
      return this.loadAllAsStream(getAccountingDocumentLineMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public AccountingDocumentLine load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocumentLine(AccountingDocumentLineTable.withId(id), options);
	}

	

	public AccountingDocumentLine save(AccountingDocumentLine accountingDocumentLine,Map<String,Object> options){

		String methodName="save(AccountingDocumentLine accountingDocumentLine,Map<String,Object> options)";

		assertMethodArgumentNotNull(accountingDocumentLine, methodName, "accountingDocumentLine");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalAccountingDocumentLine(accountingDocumentLine,options);
	}
	public AccountingDocumentLine clone(String accountingDocumentLineId, Map<String,Object> options) throws Exception{

		return clone(AccountingDocumentLineTable.withId(accountingDocumentLineId),options);
	}

	protected AccountingDocumentLine clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String accountingDocumentLineId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		AccountingDocumentLine newAccountingDocumentLine = loadInternalAccountingDocumentLine(accessKey, options);
		newAccountingDocumentLine.setVersion(0);
		
		


		saveInternalAccountingDocumentLine(newAccountingDocumentLine,options);

		return newAccountingDocumentLine;
	}

	



	protected void throwIfHasException(String accountingDocumentLineId,int version,int count) throws Exception{
		if (count == 1) {
			throw new AccountingDocumentLineVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentLineNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentLineId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String accountingDocumentLineId, int version) throws Exception{

		String methodName="delete(String accountingDocumentLineId, int version)";
		assertMethodArgumentNotNull(accountingDocumentLineId, methodName, "accountingDocumentLineId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentLineId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentLineId,version);
		}


	}






	public AccountingDocumentLine disconnectFromAll(String accountingDocumentLineId, int version) throws Exception{


		AccountingDocumentLine accountingDocumentLine = loadInternalAccountingDocumentLine(AccountingDocumentLineTable.withId(accountingDocumentLineId), emptyOptions());
		accountingDocumentLine.clearFromAll();
		this.saveAccountingDocumentLine(accountingDocumentLine);
		return accountingDocumentLine;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return AccountingDocumentLineTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "accounting_document_line";
	}
	@Override
	protected String getBeanName() {

		return "accountingDocumentLine";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return AccountingDocumentLineTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){

	 	return checkOptions(options, AccountingDocumentLineTokens.BELONGSTO);
 	}

 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){

 		return checkOptions(options, AccountingDocumentLineTokens.BELONGSTO);
 	}



 

 	protected boolean isExtractAccountingSubjectEnabled(Map<String,Object> options){

	 	return checkOptions(options, AccountingDocumentLineTokens.ACCOUNTINGSUBJECT);
 	}

 	protected boolean isSaveAccountingSubjectEnabled(Map<String,Object> options){

 		return checkOptions(options, AccountingDocumentLineTokens.ACCOUNTINGSUBJECT);
 	}



 
		

	

	protected AccountingDocumentLineMapper getAccountingDocumentLineMapper(){
		return new AccountingDocumentLineMapper();
	}



	protected AccountingDocumentLine extractAccountingDocumentLine(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			AccountingDocumentLine accountingDocumentLine = loadSingleObject(accessKey, getAccountingDocumentLineMapper());
			return accountingDocumentLine;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentLineNotFoundException("AccountingDocumentLine("+accessKey+") is not found!");
		}

	}




	protected AccountingDocumentLine loadInternalAccountingDocumentLine(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		AccountingDocumentLine accountingDocumentLine = extractAccountingDocumentLine(accessKey, loadOptions);

 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(accountingDocumentLine, loadOptions);
 		}
 
 		if(isExtractAccountingSubjectEnabled(loadOptions)){
	 		extractAccountingSubject(accountingDocumentLine, loadOptions);
 		}
 
		
		return accountingDocumentLine;

	}

	

 	protected AccountingDocumentLine extractBelongsTo(AccountingDocumentLine accountingDocumentLine, Map<String,Object> options) throws Exception{
  

		if(accountingDocumentLine.getBelongsTo() == null){
			return accountingDocumentLine;
		}
		String belongsToId = accountingDocumentLine.getBelongsTo().getId();
		if( belongsToId == null){
			return accountingDocumentLine;
		}
		AccountingDocument belongsTo = getAccountingDocumentDAO().load(belongsToId,options);
		if(belongsTo != null){
			accountingDocumentLine.setBelongsTo(belongsTo);
		}


 		return accountingDocumentLine;
 	}

 

 	protected AccountingDocumentLine extractAccountingSubject(AccountingDocumentLine accountingDocumentLine, Map<String,Object> options) throws Exception{
  

		if(accountingDocumentLine.getAccountingSubject() == null){
			return accountingDocumentLine;
		}
		String accountingSubjectId = accountingDocumentLine.getAccountingSubject().getId();
		if( accountingSubjectId == null){
			return accountingDocumentLine;
		}
		AccountingSubject accountingSubject = getAccountingSubjectDAO().load(accountingSubjectId,options);
		if(accountingSubject != null){
			accountingDocumentLine.setAccountingSubject(accountingSubject);
		}


 		return accountingDocumentLine;
 	}

 
		

 
 	public SmartList<AccountingDocumentLine> findAccountingDocumentLineByBelongsTo(String accountingDocumentId,Map<String,Object> options){

  		SmartList<AccountingDocumentLine> resultList = queryWith(AccountingDocumentLineTable.COLUMN_BELONGS_TO, accountingDocumentId, options, getAccountingDocumentLineMapper());
		// analyzeAccountingDocumentLineByBelongsTo(resultList, accountingDocumentId, options);
		return resultList;
 	}
 	

 	public SmartList<AccountingDocumentLine> findAccountingDocumentLineByBelongsTo(String accountingDocumentId, int start, int count,Map<String,Object> options){

 		SmartList<AccountingDocumentLine> resultList =  queryWithRange(AccountingDocumentLineTable.COLUMN_BELONGS_TO, accountingDocumentId, options, getAccountingDocumentLineMapper(), start, count);
 		//analyzeAccountingDocumentLineByBelongsTo(resultList, accountingDocumentId, options);
 		return resultList;

 	}
 	public void analyzeAccountingDocumentLineByBelongsTo(SmartList<AccountingDocumentLine> resultList, String accountingDocumentId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(AccountingDocumentLine.BELONGS_TO_PROPERTY, accountingDocumentId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countAccountingDocumentLineByBelongsTo(String accountingDocumentId,Map<String,Object> options){

 		return countWith(AccountingDocumentLineTable.COLUMN_BELONGS_TO, accountingDocumentId, options);
 	}
 	@Override
	public Map<String, Integer> countAccountingDocumentLineByBelongsToIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AccountingDocumentLineTable.COLUMN_BELONGS_TO, ids, options);
	}

 
 	public SmartList<AccountingDocumentLine> findAccountingDocumentLineByAccountingSubject(String accountingSubjectId,Map<String,Object> options){

  		SmartList<AccountingDocumentLine> resultList = queryWith(AccountingDocumentLineTable.COLUMN_ACCOUNTING_SUBJECT, accountingSubjectId, options, getAccountingDocumentLineMapper());
		// analyzeAccountingDocumentLineByAccountingSubject(resultList, accountingSubjectId, options);
		return resultList;
 	}
 	

 	public SmartList<AccountingDocumentLine> findAccountingDocumentLineByAccountingSubject(String accountingSubjectId, int start, int count,Map<String,Object> options){

 		SmartList<AccountingDocumentLine> resultList =  queryWithRange(AccountingDocumentLineTable.COLUMN_ACCOUNTING_SUBJECT, accountingSubjectId, options, getAccountingDocumentLineMapper(), start, count);
 		//analyzeAccountingDocumentLineByAccountingSubject(resultList, accountingSubjectId, options);
 		return resultList;

 	}
 	public void analyzeAccountingDocumentLineByAccountingSubject(SmartList<AccountingDocumentLine> resultList, String accountingSubjectId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, accountingSubjectId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countAccountingDocumentLineByAccountingSubject(String accountingSubjectId,Map<String,Object> options){

 		return countWith(AccountingDocumentLineTable.COLUMN_ACCOUNTING_SUBJECT, accountingSubjectId, options);
 	}
 	@Override
	public Map<String, Integer> countAccountingDocumentLineByAccountingSubjectIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AccountingDocumentLineTable.COLUMN_ACCOUNTING_SUBJECT, ids, options);
	}

 




	

	protected AccountingDocumentLine saveAccountingDocumentLine(AccountingDocumentLine  accountingDocumentLine){
    

		
		if(!accountingDocumentLine.isChanged()){
			return accountingDocumentLine;
		}
		

    Beans.dbUtil().cacheCleanUp(accountingDocumentLine);
		String SQL=this.getSaveAccountingDocumentLineSQL(accountingDocumentLine);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentLineParameters(accountingDocumentLine);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		accountingDocumentLine.incVersion();
		accountingDocumentLine.afterSave();
		return accountingDocumentLine;

	}
	public SmartList<AccountingDocumentLine> saveAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentLineList(accountingDocumentLineList);

		batchAccountingDocumentLineCreate((List<AccountingDocumentLine>)lists[CREATE_LIST_INDEX]);

		batchAccountingDocumentLineUpdate((List<AccountingDocumentLine>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList){
			if(accountingDocumentLine.isChanged()){
				accountingDocumentLine.incVersion();
				accountingDocumentLine.afterSave();
			}


		}


		return accountingDocumentLineList;
	}

	public SmartList<AccountingDocumentLine> removeAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList,Map<String,Object> options){


		super.removeList(accountingDocumentLineList, options);

		return accountingDocumentLineList;


	}

	protected List<Object[]> prepareAccountingDocumentLineBatchCreateArgs(List<AccountingDocumentLine> accountingDocumentLineList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList ){
			Object [] parameters = prepareAccountingDocumentLineCreateParameters(accountingDocumentLine);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareAccountingDocumentLineBatchUpdateArgs(List<AccountingDocumentLine> accountingDocumentLineList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList ){
			if(!accountingDocumentLine.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentLineUpdateParameters(accountingDocumentLine);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchAccountingDocumentLineCreate(List<AccountingDocumentLine> accountingDocumentLineList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentLineBatchCreateArgs(accountingDocumentLineList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchAccountingDocumentLineUpdate(List<AccountingDocumentLine> accountingDocumentLineList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentLineBatchUpdateArgs(accountingDocumentLineList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitAccountingDocumentLineList(List<AccountingDocumentLine> accountingDocumentLineList){

		List<AccountingDocumentLine> accountingDocumentLineCreateList=new ArrayList<AccountingDocumentLine>();
		List<AccountingDocumentLine> accountingDocumentLineUpdateList=new ArrayList<AccountingDocumentLine>();

		for(AccountingDocumentLine accountingDocumentLine: accountingDocumentLineList){
			if(isUpdateRequest(accountingDocumentLine)){
				accountingDocumentLineUpdateList.add( accountingDocumentLine);
				continue;
			}
			accountingDocumentLineCreateList.add(accountingDocumentLine);
		}

		return new Object[]{accountingDocumentLineCreateList,accountingDocumentLineUpdateList};
	}

	protected boolean isUpdateRequest(AccountingDocumentLine accountingDocumentLine){
 		return accountingDocumentLine.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentLineSQL(AccountingDocumentLine accountingDocumentLine){
 		if(isUpdateRequest(accountingDocumentLine)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveAccountingDocumentLineParameters(AccountingDocumentLine accountingDocumentLine){
 		if(isUpdateRequest(accountingDocumentLine) ){
 			return prepareAccountingDocumentLineUpdateParameters(accountingDocumentLine);
 		}
 		return prepareAccountingDocumentLineCreateParameters(accountingDocumentLine);
 	}
 	protected Object[] prepareAccountingDocumentLineUpdateParameters(AccountingDocumentLine accountingDocumentLine){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = accountingDocumentLine.getName();
 		
 		parameters[1] = accountingDocumentLine.getCode();
 		
 		parameters[2] = accountingDocumentLine.getDirect();
 		
 		parameters[3] = accountingDocumentLine.getAmount();
 		
 		if(accountingDocumentLine.getBelongsTo() != null){
 			parameters[4] = accountingDocumentLine.getBelongsTo().getId();
 		}
    
 		if(accountingDocumentLine.getAccountingSubject() != null){
 			parameters[5] = accountingDocumentLine.getAccountingSubject().getId();
 		}
    
 		parameters[6] = accountingDocumentLine.nextVersion();
 		parameters[7] = accountingDocumentLine.getId();
 		parameters[8] = accountingDocumentLine.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentLineCreateParameters(AccountingDocumentLine accountingDocumentLine){
		Object[] parameters = new Object[7];
        if(accountingDocumentLine.getId() == null){
          String newAccountingDocumentLineId=getNextId();
          accountingDocumentLine.setId(newAccountingDocumentLineId);
        }
		parameters[0] =  accountingDocumentLine.getId();
 
 		parameters[1] = accountingDocumentLine.getName();
 		
 		parameters[2] = accountingDocumentLine.getCode();
 		
 		parameters[3] = accountingDocumentLine.getDirect();
 		
 		parameters[4] = accountingDocumentLine.getAmount();
 		
 		if(accountingDocumentLine.getBelongsTo() != null){
 			parameters[5] = accountingDocumentLine.getBelongsTo().getId();
 		}
 		
 		if(accountingDocumentLine.getAccountingSubject() != null){
 			parameters[6] = accountingDocumentLine.getAccountingSubject().getId();
 		}
 		

 		return parameters;
 	}

	protected AccountingDocumentLine saveInternalAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine, Map<String,Object> options){

 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(accountingDocumentLine, options);
 		}
 
 		if(isSaveAccountingSubjectEnabled(options)){
	 		saveAccountingSubject(accountingDocumentLine, options);
 		}
 
   saveAccountingDocumentLine(accountingDocumentLine);
		
		return accountingDocumentLine;

	}



	//======================================================================================
	

 	protected AccountingDocumentLine saveBelongsTo(AccountingDocumentLine accountingDocumentLine, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(accountingDocumentLine.getBelongsTo() == null){
 			return accountingDocumentLine;//do nothing when it is null
 		}

 		getAccountingDocumentDAO().save(accountingDocumentLine.getBelongsTo(),options);
 		return accountingDocumentLine;

 	}
 

 	protected AccountingDocumentLine saveAccountingSubject(AccountingDocumentLine accountingDocumentLine, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(accountingDocumentLine.getAccountingSubject() == null){
 			return accountingDocumentLine;//do nothing when it is null
 		}

 		getAccountingSubjectDAO().save(accountingDocumentLine.getAccountingSubject(),options);
 		return accountingDocumentLine;

 	}
 

	

		

	public AccountingDocumentLine present(AccountingDocumentLine accountingDocumentLine,Map<String, Object> options){


		return accountingDocumentLine;

	}
		

	

	protected String getTableName(){
		return AccountingDocumentLineTable.TABLE_NAME;
	}



	public void enhanceList(List<AccountingDocumentLine> accountingDocumentLineList) {
		this.enhanceListInternal(accountingDocumentLineList, this.getAccountingDocumentLineMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<AccountingDocumentLine> accountingDocumentLineList = ownerEntity.collectRefsWithType(AccountingDocumentLine.INTERNAL_TYPE);
		this.enhanceList(accountingDocumentLineList);

	}

	@Override
	public SmartList<AccountingDocumentLine> findAccountingDocumentLineWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getAccountingDocumentLineMapper());

	}
	@Override
	public int countAccountingDocumentLineWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countAccountingDocumentLineWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<AccountingDocumentLine> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getAccountingDocumentLineMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<AccountingDocumentLine> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getAccountingDocumentLineMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateAccountingDocumentLine executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateAccountingDocumentLine result = new CandidateAccountingDocumentLine();
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

	

  @Override
  public List<AccountingDocumentLine> search(AccountingDocumentLineRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected AccountingDocumentLineMapper mapper() {
    return getAccountingDocumentLineMapper();
  }
}


