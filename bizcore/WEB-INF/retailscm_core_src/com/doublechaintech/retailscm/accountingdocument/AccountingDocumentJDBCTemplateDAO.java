
package com.doublechaintech.retailscm.accountingdocument;

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


import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.accountingdocumentposting.AccountingDocumentPosting;
import com.doublechaintech.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.doublechaintech.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.doublechaintech.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;

import com.doublechaintech.retailscm.accountingdocumentcreation.AccountingDocumentCreationDAO;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodDAO;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucherDAO;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineDAO;
import com.doublechaintech.retailscm.accountingdocumentauditing.AccountingDocumentAuditingDAO;
import com.doublechaintech.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmationDAO;
import com.doublechaintech.retailscm.accountingdocumentposting.AccountingDocumentPostingDAO;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class AccountingDocumentJDBCTemplateDAO extends RetailscmNamingServiceDAO implements AccountingDocumentDAO{
 
 	
 	private  AccountingDocumentTypeDAO  accountingDocumentTypeDAO;
 	public void setAccountingDocumentTypeDAO(AccountingDocumentTypeDAO accountingDocumentTypeDAO){
	 	this.accountingDocumentTypeDAO = accountingDocumentTypeDAO;
 	}
 	public AccountingDocumentTypeDAO getAccountingDocumentTypeDAO(){
	 	return this.accountingDocumentTypeDAO;
 	}
 
 	
 	private  AccountingDocumentPostingDAO  accountingDocumentPostingDAO;
 	public void setAccountingDocumentPostingDAO(AccountingDocumentPostingDAO accountingDocumentPostingDAO){
	 	this.accountingDocumentPostingDAO = accountingDocumentPostingDAO;
 	}
 	public AccountingDocumentPostingDAO getAccountingDocumentPostingDAO(){
	 	return this.accountingDocumentPostingDAO;
 	}
 
 	
 	private  AccountingDocumentCreationDAO  accountingDocumentCreationDAO;
 	public void setAccountingDocumentCreationDAO(AccountingDocumentCreationDAO accountingDocumentCreationDAO){
	 	this.accountingDocumentCreationDAO = accountingDocumentCreationDAO;
 	}
 	public AccountingDocumentCreationDAO getAccountingDocumentCreationDAO(){
	 	return this.accountingDocumentCreationDAO;
 	}
 
 	
 	private  AccountingPeriodDAO  accountingPeriodDAO;
 	public void setAccountingPeriodDAO(AccountingPeriodDAO accountingPeriodDAO){
	 	this.accountingPeriodDAO = accountingPeriodDAO;
 	}
 	public AccountingPeriodDAO getAccountingPeriodDAO(){
	 	return this.accountingPeriodDAO;
 	}
 
 	
 	private  AccountingDocumentAuditingDAO  accountingDocumentAuditingDAO;
 	public void setAccountingDocumentAuditingDAO(AccountingDocumentAuditingDAO accountingDocumentAuditingDAO){
	 	this.accountingDocumentAuditingDAO = accountingDocumentAuditingDAO;
 	}
 	public AccountingDocumentAuditingDAO getAccountingDocumentAuditingDAO(){
	 	return this.accountingDocumentAuditingDAO;
 	}
 
 	
 	private  AccountingDocumentConfirmationDAO  accountingDocumentConfirmationDAO;
 	public void setAccountingDocumentConfirmationDAO(AccountingDocumentConfirmationDAO accountingDocumentConfirmationDAO){
	 	this.accountingDocumentConfirmationDAO = accountingDocumentConfirmationDAO;
 	}
 	public AccountingDocumentConfirmationDAO getAccountingDocumentConfirmationDAO(){
	 	return this.accountingDocumentConfirmationDAO;
 	}


			
		
	
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
 	
			
		
	
  	private  AccountingDocumentLineDAO  accountingDocumentLineDAO;
 	public void setAccountingDocumentLineDAO(AccountingDocumentLineDAO pAccountingDocumentLineDAO){
 	
 		if(pAccountingDocumentLineDAO == null){
 			throw new IllegalStateException("Do not try to set accountingDocumentLineDAO to null.");
 		}
	 	this.accountingDocumentLineDAO = pAccountingDocumentLineDAO;
 	}
 	public AccountingDocumentLineDAO getAccountingDocumentLineDAO(){
 		if(this.accountingDocumentLineDAO == null){
 			throw new IllegalStateException("The accountingDocumentLineDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountingDocumentLineDAO;
 	}	
 	
			
		

	
	/*
	protected AccountingDocument load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocument(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public AccountingDocument load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAccountingDocument(AccountingDocumentTable.withId(id), options);
	}
	
	
	
	public AccountingDocument save(AccountingDocument accountingDocument,Map<String,Object> options){
		
		String methodName="save(AccountingDocument accountingDocument,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accountingDocument, methodName, "accountingDocument");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAccountingDocument(accountingDocument,options);
	}
	public AccountingDocument clone(String accountingDocumentId, Map<String,Object> options) throws Exception{
	
		return clone(AccountingDocumentTable.withId(accountingDocumentId),options);
	}
	
	protected AccountingDocument clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String accountingDocumentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AccountingDocument newAccountingDocument = loadInternalAccountingDocument(accessKey, options);
		newAccountingDocument.setVersion(0);
		
		
 		
 		if(isSaveOriginalVoucherListEnabled(options)){
 			for(OriginalVoucher item: newAccountingDocument.getOriginalVoucherList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveAccountingDocumentLineListEnabled(options)){
 			for(AccountingDocumentLine item: newAccountingDocument.getAccountingDocumentLineList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalAccountingDocument(newAccountingDocument,options);
		
		return newAccountingDocument;
	}
	
	
	
	

	protected void throwIfHasException(String accountingDocumentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new AccountingDocumentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AccountingDocumentNotFoundException(
					"The " + this.getTableName() + "(" + accountingDocumentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String accountingDocumentId, int version) throws Exception{
	
		String methodName="delete(String accountingDocumentId, int version)";
		assertMethodArgumentNotNull(accountingDocumentId, methodName, "accountingDocumentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{accountingDocumentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(accountingDocumentId,version);
		}
		
	
	}
	
	
	
	
	

	public AccountingDocument disconnectFromAll(String accountingDocumentId, int version) throws Exception{
	
		
		AccountingDocument accountingDocument = loadInternalAccountingDocument(AccountingDocumentTable.withId(accountingDocumentId), emptyOptions());
		accountingDocument.clearFromAll();
		this.saveAccountingDocument(accountingDocument);
		return accountingDocument;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return AccountingDocumentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "accounting_document";
	}
	@Override
	protected String getBeanName() {
		
		return "accountingDocument";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AccountingDocumentTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractAccountingPeriodEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTokens.ACCOUNTINGPERIOD);
 	}

 	protected boolean isSaveAccountingPeriodEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTokens.ACCOUNTINGPERIOD);
 	}
 	

 	
  

 	protected boolean isExtractDocumentTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTokens.DOCUMENTTYPE);
 	}

 	protected boolean isSaveDocumentTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTokens.DOCUMENTTYPE);
 	}
 	

 	
  

 	protected boolean isExtractCreationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTokens.CREATION);
 	}

 	protected boolean isSaveCreationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTokens.CREATION);
 	}
 	

 	
  

 	protected boolean isExtractConfirmationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTokens.CONFIRMATION);
 	}

 	protected boolean isSaveConfirmationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTokens.CONFIRMATION);
 	}
 	

 	
  

 	protected boolean isExtractAuditingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTokens.AUDITING);
 	}

 	protected boolean isSaveAuditingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTokens.AUDITING);
 	}
 	

 	
  

 	protected boolean isExtractPostingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AccountingDocumentTokens.POSTING);
 	}

 	protected boolean isSavePostingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AccountingDocumentTokens.POSTING);
 	}
 	

 	
 
		
	
	protected boolean isExtractOriginalVoucherListEnabled(Map<String,Object> options){		
 		return checkOptions(options,AccountingDocumentTokens.ORIGINAL_VOUCHER_LIST);
 	}
 	protected boolean isAnalyzeOriginalVoucherListEnabled(Map<String,Object> options){		
 		return checkOptions(options,AccountingDocumentTokens.ORIGINAL_VOUCHER_LIST+".analyze");
 	}

	protected boolean isSaveOriginalVoucherListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentTokens.ORIGINAL_VOUCHER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractAccountingDocumentLineListEnabled(Map<String,Object> options){		
 		return checkOptions(options,AccountingDocumentTokens.ACCOUNTING_DOCUMENT_LINE_LIST);
 	}
 	protected boolean isAnalyzeAccountingDocumentLineListEnabled(Map<String,Object> options){		
 		return checkOptions(options,AccountingDocumentTokens.ACCOUNTING_DOCUMENT_LINE_LIST+".analyze");
 	}

	protected boolean isSaveAccountingDocumentLineListEnabled(Map<String,Object> options){
		return checkOptions(options, AccountingDocumentTokens.ACCOUNTING_DOCUMENT_LINE_LIST);
		
 	}
 	
		

	

	protected AccountingDocumentMapper getAccountingDocumentMapper(){
		return new AccountingDocumentMapper();
	}

	
	
	protected AccountingDocument extractAccountingDocument(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			AccountingDocument accountingDocument = loadSingleObject(accessKey, getAccountingDocumentMapper());
			return accountingDocument;
		}catch(EmptyResultDataAccessException e){
			throw new AccountingDocumentNotFoundException("AccountingDocument("+accessKey+") is not found!");
		}

	}

	
	

	protected AccountingDocument loadInternalAccountingDocument(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AccountingDocument accountingDocument = extractAccountingDocument(accessKey, loadOptions);
 	
 		if(isExtractAccountingPeriodEnabled(loadOptions)){
	 		extractAccountingPeriod(accountingDocument, loadOptions);
 		}
  	
 		if(isExtractDocumentTypeEnabled(loadOptions)){
	 		extractDocumentType(accountingDocument, loadOptions);
 		}
  	
 		if(isExtractCreationEnabled(loadOptions)){
	 		extractCreation(accountingDocument, loadOptions);
 		}
  	
 		if(isExtractConfirmationEnabled(loadOptions)){
	 		extractConfirmation(accountingDocument, loadOptions);
 		}
  	
 		if(isExtractAuditingEnabled(loadOptions)){
	 		extractAuditing(accountingDocument, loadOptions);
 		}
  	
 		if(isExtractPostingEnabled(loadOptions)){
	 		extractPosting(accountingDocument, loadOptions);
 		}
 
		
		if(isExtractOriginalVoucherListEnabled(loadOptions)){
	 		extractOriginalVoucherList(accountingDocument, loadOptions);
 		}	
 		if(isAnalyzeOriginalVoucherListEnabled(loadOptions)){
	 		// analyzeOriginalVoucherList(accountingDocument, loadOptions);
 		}
 		
		
		if(isExtractAccountingDocumentLineListEnabled(loadOptions)){
	 		extractAccountingDocumentLineList(accountingDocument, loadOptions);
 		}	
 		if(isAnalyzeAccountingDocumentLineListEnabled(loadOptions)){
	 		// analyzeAccountingDocumentLineList(accountingDocument, loadOptions);
 		}
 		
		
		return accountingDocument;
		
	}

	 

 	protected AccountingDocument extractAccountingPeriod(AccountingDocument accountingDocument, Map<String,Object> options) throws Exception{

		if(accountingDocument.getAccountingPeriod() == null){
			return accountingDocument;
		}
		String accountingPeriodId = accountingDocument.getAccountingPeriod().getId();
		if( accountingPeriodId == null){
			return accountingDocument;
		}
		AccountingPeriod accountingPeriod = getAccountingPeriodDAO().load(accountingPeriodId,options);
		if(accountingPeriod != null){
			accountingDocument.setAccountingPeriod(accountingPeriod);
		}
		
 		
 		return accountingDocument;
 	}
 		
  

 	protected AccountingDocument extractDocumentType(AccountingDocument accountingDocument, Map<String,Object> options) throws Exception{

		if(accountingDocument.getDocumentType() == null){
			return accountingDocument;
		}
		String documentTypeId = accountingDocument.getDocumentType().getId();
		if( documentTypeId == null){
			return accountingDocument;
		}
		AccountingDocumentType documentType = getAccountingDocumentTypeDAO().load(documentTypeId,options);
		if(documentType != null){
			accountingDocument.setDocumentType(documentType);
		}
		
 		
 		return accountingDocument;
 	}
 		
  

 	protected AccountingDocument extractCreation(AccountingDocument accountingDocument, Map<String,Object> options) throws Exception{

		if(accountingDocument.getCreation() == null){
			return accountingDocument;
		}
		String creationId = accountingDocument.getCreation().getId();
		if( creationId == null){
			return accountingDocument;
		}
		AccountingDocumentCreation creation = getAccountingDocumentCreationDAO().load(creationId,options);
		if(creation != null){
			accountingDocument.setCreation(creation);
		}
		
 		
 		return accountingDocument;
 	}
 		
  

 	protected AccountingDocument extractConfirmation(AccountingDocument accountingDocument, Map<String,Object> options) throws Exception{

		if(accountingDocument.getConfirmation() == null){
			return accountingDocument;
		}
		String confirmationId = accountingDocument.getConfirmation().getId();
		if( confirmationId == null){
			return accountingDocument;
		}
		AccountingDocumentConfirmation confirmation = getAccountingDocumentConfirmationDAO().load(confirmationId,options);
		if(confirmation != null){
			accountingDocument.setConfirmation(confirmation);
		}
		
 		
 		return accountingDocument;
 	}
 		
  

 	protected AccountingDocument extractAuditing(AccountingDocument accountingDocument, Map<String,Object> options) throws Exception{

		if(accountingDocument.getAuditing() == null){
			return accountingDocument;
		}
		String auditingId = accountingDocument.getAuditing().getId();
		if( auditingId == null){
			return accountingDocument;
		}
		AccountingDocumentAuditing auditing = getAccountingDocumentAuditingDAO().load(auditingId,options);
		if(auditing != null){
			accountingDocument.setAuditing(auditing);
		}
		
 		
 		return accountingDocument;
 	}
 		
  

 	protected AccountingDocument extractPosting(AccountingDocument accountingDocument, Map<String,Object> options) throws Exception{

		if(accountingDocument.getPosting() == null){
			return accountingDocument;
		}
		String postingId = accountingDocument.getPosting().getId();
		if( postingId == null){
			return accountingDocument;
		}
		AccountingDocumentPosting posting = getAccountingDocumentPostingDAO().load(postingId,options);
		if(posting != null){
			accountingDocument.setPosting(posting);
		}
		
 		
 		return accountingDocument;
 	}
 		
 
		
	protected void enhanceOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected AccountingDocument extractOriginalVoucherList(AccountingDocument accountingDocument, Map<String,Object> options){
		
		
		if(accountingDocument == null){
			return null;
		}
		if(accountingDocument.getId() == null){
			return accountingDocument;
		}

		
		
		SmartList<OriginalVoucher> originalVoucherList = getOriginalVoucherDAO().findOriginalVoucherByBelongsTo(accountingDocument.getId(),options);
		if(originalVoucherList != null){
			enhanceOriginalVoucherList(originalVoucherList,options);
			accountingDocument.setOriginalVoucherList(originalVoucherList);
		}
		
		return accountingDocument;
	
	}	
	
	protected AccountingDocument analyzeOriginalVoucherList(AccountingDocument accountingDocument, Map<String,Object> options){
		
		
		if(accountingDocument == null){
			return null;
		}
		if(accountingDocument.getId() == null){
			return accountingDocument;
		}

		
		
		SmartList<OriginalVoucher> originalVoucherList = accountingDocument.getOriginalVoucherList();
		if(originalVoucherList != null){
			getOriginalVoucherDAO().analyzeOriginalVoucherByBelongsTo(originalVoucherList, accountingDocument.getId(), options);
			
		}
		
		return accountingDocument;
	
	}	
	
		
	protected void enhanceAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected AccountingDocument extractAccountingDocumentLineList(AccountingDocument accountingDocument, Map<String,Object> options){
		
		
		if(accountingDocument == null){
			return null;
		}
		if(accountingDocument.getId() == null){
			return accountingDocument;
		}

		
		
		SmartList<AccountingDocumentLine> accountingDocumentLineList = getAccountingDocumentLineDAO().findAccountingDocumentLineByBelongsTo(accountingDocument.getId(),options);
		if(accountingDocumentLineList != null){
			enhanceAccountingDocumentLineList(accountingDocumentLineList,options);
			accountingDocument.setAccountingDocumentLineList(accountingDocumentLineList);
		}
		
		return accountingDocument;
	
	}	
	
	protected AccountingDocument analyzeAccountingDocumentLineList(AccountingDocument accountingDocument, Map<String,Object> options){
		
		
		if(accountingDocument == null){
			return null;
		}
		if(accountingDocument.getId() == null){
			return accountingDocument;
		}

		
		
		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingDocument.getAccountingDocumentLineList();
		if(accountingDocumentLineList != null){
			getAccountingDocumentLineDAO().analyzeAccountingDocumentLineByBelongsTo(accountingDocumentLineList, accountingDocument.getId(), options);
			
		}
		
		return accountingDocument;
	
	}	
	
		
		
  	
 	public SmartList<AccountingDocument> findAccountingDocumentByAccountingPeriod(String accountingPeriodId,Map<String,Object> options){
 	
  		SmartList<AccountingDocument> resultList = queryWith(AccountingDocumentTable.COLUMN_ACCOUNTING_PERIOD, accountingPeriodId, options, getAccountingDocumentMapper());
		// analyzeAccountingDocumentByAccountingPeriod(resultList, accountingPeriodId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AccountingDocument> findAccountingDocumentByAccountingPeriod(String accountingPeriodId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AccountingDocument> resultList =  queryWithRange(AccountingDocumentTable.COLUMN_ACCOUNTING_PERIOD, accountingPeriodId, options, getAccountingDocumentMapper(), start, count);
 		//analyzeAccountingDocumentByAccountingPeriod(resultList, accountingPeriodId, options);
 		return resultList;
 		
 	}
 	public void analyzeAccountingDocumentByAccountingPeriod(SmartList<AccountingDocument> resultList, String accountingPeriodId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingPeriodId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countAccountingDocumentByAccountingPeriod(String accountingPeriodId,Map<String,Object> options){

 		return countWith(AccountingDocumentTable.COLUMN_ACCOUNTING_PERIOD, accountingPeriodId, options);
 	}
 	@Override
	public Map<String, Integer> countAccountingDocumentByAccountingPeriodIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AccountingDocumentTable.COLUMN_ACCOUNTING_PERIOD, ids, options);
	}
 	
  	
 	public SmartList<AccountingDocument> findAccountingDocumentByDocumentType(String accountingDocumentTypeId,Map<String,Object> options){
 	
  		SmartList<AccountingDocument> resultList = queryWith(AccountingDocumentTable.COLUMN_DOCUMENT_TYPE, accountingDocumentTypeId, options, getAccountingDocumentMapper());
		// analyzeAccountingDocumentByDocumentType(resultList, accountingDocumentTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AccountingDocument> findAccountingDocumentByDocumentType(String accountingDocumentTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AccountingDocument> resultList =  queryWithRange(AccountingDocumentTable.COLUMN_DOCUMENT_TYPE, accountingDocumentTypeId, options, getAccountingDocumentMapper(), start, count);
 		//analyzeAccountingDocumentByDocumentType(resultList, accountingDocumentTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeAccountingDocumentByDocumentType(SmartList<AccountingDocument> resultList, String accountingDocumentTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(AccountingDocument.DOCUMENT_TYPE_PROPERTY, accountingDocumentTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countAccountingDocumentByDocumentType(String accountingDocumentTypeId,Map<String,Object> options){

 		return countWith(AccountingDocumentTable.COLUMN_DOCUMENT_TYPE, accountingDocumentTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countAccountingDocumentByDocumentTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AccountingDocumentTable.COLUMN_DOCUMENT_TYPE, ids, options);
	}
 	
  	
 	public SmartList<AccountingDocument> findAccountingDocumentByCreation(String accountingDocumentCreationId,Map<String,Object> options){
 	
  		SmartList<AccountingDocument> resultList = queryWith(AccountingDocumentTable.COLUMN_CREATION, accountingDocumentCreationId, options, getAccountingDocumentMapper());
		// analyzeAccountingDocumentByCreation(resultList, accountingDocumentCreationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AccountingDocument> findAccountingDocumentByCreation(String accountingDocumentCreationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AccountingDocument> resultList =  queryWithRange(AccountingDocumentTable.COLUMN_CREATION, accountingDocumentCreationId, options, getAccountingDocumentMapper(), start, count);
 		//analyzeAccountingDocumentByCreation(resultList, accountingDocumentCreationId, options);
 		return resultList;
 		
 	}
 	public void analyzeAccountingDocumentByCreation(SmartList<AccountingDocument> resultList, String accountingDocumentCreationId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(AccountingDocument.CREATION_PROPERTY, accountingDocumentCreationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countAccountingDocumentByCreation(String accountingDocumentCreationId,Map<String,Object> options){

 		return countWith(AccountingDocumentTable.COLUMN_CREATION, accountingDocumentCreationId, options);
 	}
 	@Override
	public Map<String, Integer> countAccountingDocumentByCreationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AccountingDocumentTable.COLUMN_CREATION, ids, options);
	}
 	
  	
 	public SmartList<AccountingDocument> findAccountingDocumentByConfirmation(String accountingDocumentConfirmationId,Map<String,Object> options){
 	
  		SmartList<AccountingDocument> resultList = queryWith(AccountingDocumentTable.COLUMN_CONFIRMATION, accountingDocumentConfirmationId, options, getAccountingDocumentMapper());
		// analyzeAccountingDocumentByConfirmation(resultList, accountingDocumentConfirmationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AccountingDocument> findAccountingDocumentByConfirmation(String accountingDocumentConfirmationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AccountingDocument> resultList =  queryWithRange(AccountingDocumentTable.COLUMN_CONFIRMATION, accountingDocumentConfirmationId, options, getAccountingDocumentMapper(), start, count);
 		//analyzeAccountingDocumentByConfirmation(resultList, accountingDocumentConfirmationId, options);
 		return resultList;
 		
 	}
 	public void analyzeAccountingDocumentByConfirmation(SmartList<AccountingDocument> resultList, String accountingDocumentConfirmationId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(AccountingDocument.CONFIRMATION_PROPERTY, accountingDocumentConfirmationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countAccountingDocumentByConfirmation(String accountingDocumentConfirmationId,Map<String,Object> options){

 		return countWith(AccountingDocumentTable.COLUMN_CONFIRMATION, accountingDocumentConfirmationId, options);
 	}
 	@Override
	public Map<String, Integer> countAccountingDocumentByConfirmationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AccountingDocumentTable.COLUMN_CONFIRMATION, ids, options);
	}
 	
  	
 	public SmartList<AccountingDocument> findAccountingDocumentByAuditing(String accountingDocumentAuditingId,Map<String,Object> options){
 	
  		SmartList<AccountingDocument> resultList = queryWith(AccountingDocumentTable.COLUMN_AUDITING, accountingDocumentAuditingId, options, getAccountingDocumentMapper());
		// analyzeAccountingDocumentByAuditing(resultList, accountingDocumentAuditingId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AccountingDocument> findAccountingDocumentByAuditing(String accountingDocumentAuditingId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AccountingDocument> resultList =  queryWithRange(AccountingDocumentTable.COLUMN_AUDITING, accountingDocumentAuditingId, options, getAccountingDocumentMapper(), start, count);
 		//analyzeAccountingDocumentByAuditing(resultList, accountingDocumentAuditingId, options);
 		return resultList;
 		
 	}
 	public void analyzeAccountingDocumentByAuditing(SmartList<AccountingDocument> resultList, String accountingDocumentAuditingId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(AccountingDocument.AUDITING_PROPERTY, accountingDocumentAuditingId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countAccountingDocumentByAuditing(String accountingDocumentAuditingId,Map<String,Object> options){

 		return countWith(AccountingDocumentTable.COLUMN_AUDITING, accountingDocumentAuditingId, options);
 	}
 	@Override
	public Map<String, Integer> countAccountingDocumentByAuditingIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AccountingDocumentTable.COLUMN_AUDITING, ids, options);
	}
 	
  	
 	public SmartList<AccountingDocument> findAccountingDocumentByPosting(String accountingDocumentPostingId,Map<String,Object> options){
 	
  		SmartList<AccountingDocument> resultList = queryWith(AccountingDocumentTable.COLUMN_POSTING, accountingDocumentPostingId, options, getAccountingDocumentMapper());
		// analyzeAccountingDocumentByPosting(resultList, accountingDocumentPostingId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AccountingDocument> findAccountingDocumentByPosting(String accountingDocumentPostingId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AccountingDocument> resultList =  queryWithRange(AccountingDocumentTable.COLUMN_POSTING, accountingDocumentPostingId, options, getAccountingDocumentMapper(), start, count);
 		//analyzeAccountingDocumentByPosting(resultList, accountingDocumentPostingId, options);
 		return resultList;
 		
 	}
 	public void analyzeAccountingDocumentByPosting(SmartList<AccountingDocument> resultList, String accountingDocumentPostingId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(AccountingDocument.POSTING_PROPERTY, accountingDocumentPostingId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countAccountingDocumentByPosting(String accountingDocumentPostingId,Map<String,Object> options){

 		return countWith(AccountingDocumentTable.COLUMN_POSTING, accountingDocumentPostingId, options);
 	}
 	@Override
	public Map<String, Integer> countAccountingDocumentByPostingIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AccountingDocumentTable.COLUMN_POSTING, ids, options);
	}
 	
 	
		
		
		

	

	protected AccountingDocument saveAccountingDocument(AccountingDocument  accountingDocument){
		
		if(!accountingDocument.isChanged()){
			return accountingDocument;
		}
		
		
		String SQL=this.getSaveAccountingDocumentSQL(accountingDocument);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAccountingDocumentParameters(accountingDocument);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		accountingDocument.incVersion();
		return accountingDocument;
	
	}
	public SmartList<AccountingDocument> saveAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAccountingDocumentList(accountingDocumentList);
		
		batchAccountingDocumentCreate((List<AccountingDocument>)lists[CREATE_LIST_INDEX]);
		
		batchAccountingDocumentUpdate((List<AccountingDocument>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AccountingDocument accountingDocument:accountingDocumentList){
			if(accountingDocument.isChanged()){
				accountingDocument.incVersion();
			}
			
		
		}
		
		
		return accountingDocumentList;
	}

	public SmartList<AccountingDocument> removeAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options){
		
		
		super.removeList(accountingDocumentList, options);
		
		return accountingDocumentList;
		
		
	}
	
	protected List<Object[]> prepareAccountingDocumentBatchCreateArgs(List<AccountingDocument> accountingDocumentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocument accountingDocument:accountingDocumentList ){
			Object [] parameters = prepareAccountingDocumentCreateParameters(accountingDocument);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAccountingDocumentBatchUpdateArgs(List<AccountingDocument> accountingDocumentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AccountingDocument accountingDocument:accountingDocumentList ){
			if(!accountingDocument.isChanged()){
				continue;
			}
			Object [] parameters = prepareAccountingDocumentUpdateParameters(accountingDocument);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAccountingDocumentCreate(List<AccountingDocument> accountingDocumentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAccountingDocumentBatchCreateArgs(accountingDocumentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAccountingDocumentUpdate(List<AccountingDocument> accountingDocumentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAccountingDocumentBatchUpdateArgs(accountingDocumentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAccountingDocumentList(List<AccountingDocument> accountingDocumentList){
		
		List<AccountingDocument> accountingDocumentCreateList=new ArrayList<AccountingDocument>();
		List<AccountingDocument> accountingDocumentUpdateList=new ArrayList<AccountingDocument>();
		
		for(AccountingDocument accountingDocument: accountingDocumentList){
			if(isUpdateRequest(accountingDocument)){
				accountingDocumentUpdateList.add( accountingDocument);
				continue;
			}
			accountingDocumentCreateList.add(accountingDocument);
		}
		
		return new Object[]{accountingDocumentCreateList,accountingDocumentUpdateList};
	}
	
	protected boolean isUpdateRequest(AccountingDocument accountingDocument){
 		return accountingDocument.getVersion() > 0;
 	}
 	protected String getSaveAccountingDocumentSQL(AccountingDocument accountingDocument){
 		if(isUpdateRequest(accountingDocument)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAccountingDocumentParameters(AccountingDocument accountingDocument){
 		if(isUpdateRequest(accountingDocument) ){
 			return prepareAccountingDocumentUpdateParameters(accountingDocument);
 		}
 		return prepareAccountingDocumentCreateParameters(accountingDocument);
 	}
 	protected Object[] prepareAccountingDocumentUpdateParameters(AccountingDocument accountingDocument){
 		Object[] parameters = new Object[12];
 
 		parameters[0] = accountingDocument.getName();
 		parameters[1] = accountingDocument.getAccountingDocumentDate(); 	
 		if(accountingDocument.getAccountingPeriod() != null){
 			parameters[2] = accountingDocument.getAccountingPeriod().getId();
 		}
  	
 		if(accountingDocument.getDocumentType() != null){
 			parameters[3] = accountingDocument.getDocumentType().getId();
 		}
  	
 		if(accountingDocument.getCreation() != null){
 			parameters[4] = accountingDocument.getCreation().getId();
 		}
  	
 		if(accountingDocument.getConfirmation() != null){
 			parameters[5] = accountingDocument.getConfirmation().getId();
 		}
  	
 		if(accountingDocument.getAuditing() != null){
 			parameters[6] = accountingDocument.getAuditing().getId();
 		}
  	
 		if(accountingDocument.getPosting() != null){
 			parameters[7] = accountingDocument.getPosting().getId();
 		}
 
 		parameters[8] = accountingDocument.getCurrentStatus();		
 		parameters[9] = accountingDocument.nextVersion();
 		parameters[10] = accountingDocument.getId();
 		parameters[11] = accountingDocument.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAccountingDocumentCreateParameters(AccountingDocument accountingDocument){
		Object[] parameters = new Object[10];
		String newAccountingDocumentId=getNextId();
		accountingDocument.setId(newAccountingDocumentId);
		parameters[0] =  accountingDocument.getId();
 
 		parameters[1] = accountingDocument.getName();
 		parameters[2] = accountingDocument.getAccountingDocumentDate(); 	
 		if(accountingDocument.getAccountingPeriod() != null){
 			parameters[3] = accountingDocument.getAccountingPeriod().getId();
 		
 		}
 		 	
 		if(accountingDocument.getDocumentType() != null){
 			parameters[4] = accountingDocument.getDocumentType().getId();
 		
 		}
 		 	
 		if(accountingDocument.getCreation() != null){
 			parameters[5] = accountingDocument.getCreation().getId();
 		
 		}
 		 	
 		if(accountingDocument.getConfirmation() != null){
 			parameters[6] = accountingDocument.getConfirmation().getId();
 		
 		}
 		 	
 		if(accountingDocument.getAuditing() != null){
 			parameters[7] = accountingDocument.getAuditing().getId();
 		
 		}
 		 	
 		if(accountingDocument.getPosting() != null){
 			parameters[8] = accountingDocument.getPosting().getId();
 		
 		}
 		
 		parameters[9] = accountingDocument.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected AccountingDocument saveInternalAccountingDocument(AccountingDocument accountingDocument, Map<String,Object> options){
		
		saveAccountingDocument(accountingDocument);
 	
 		if(isSaveAccountingPeriodEnabled(options)){
	 		saveAccountingPeriod(accountingDocument, options);
 		}
  	
 		if(isSaveDocumentTypeEnabled(options)){
	 		saveDocumentType(accountingDocument, options);
 		}
  	
 		if(isSaveCreationEnabled(options)){
	 		saveCreation(accountingDocument, options);
 		}
  	
 		if(isSaveConfirmationEnabled(options)){
	 		saveConfirmation(accountingDocument, options);
 		}
  	
 		if(isSaveAuditingEnabled(options)){
	 		saveAuditing(accountingDocument, options);
 		}
  	
 		if(isSavePostingEnabled(options)){
	 		savePosting(accountingDocument, options);
 		}
 
		
		if(isSaveOriginalVoucherListEnabled(options)){
	 		saveOriginalVoucherList(accountingDocument, options);
	 		//removeOriginalVoucherList(accountingDocument, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveAccountingDocumentLineListEnabled(options)){
	 		saveAccountingDocumentLineList(accountingDocument, options);
	 		//removeAccountingDocumentLineList(accountingDocument, options);
	 		//Not delete the record
	 		
 		}		
		
		return accountingDocument;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected AccountingDocument saveAccountingPeriod(AccountingDocument accountingDocument, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocument.getAccountingPeriod() == null){
 			return accountingDocument;//do nothing when it is null
 		}
 		
 		getAccountingPeriodDAO().save(accountingDocument.getAccountingPeriod(),options);
 		return accountingDocument;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountingDocument saveDocumentType(AccountingDocument accountingDocument, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocument.getDocumentType() == null){
 			return accountingDocument;//do nothing when it is null
 		}
 		
 		getAccountingDocumentTypeDAO().save(accountingDocument.getDocumentType(),options);
 		return accountingDocument;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountingDocument saveCreation(AccountingDocument accountingDocument, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocument.getCreation() == null){
 			return accountingDocument;//do nothing when it is null
 		}
 		
 		getAccountingDocumentCreationDAO().save(accountingDocument.getCreation(),options);
 		return accountingDocument;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountingDocument saveConfirmation(AccountingDocument accountingDocument, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocument.getConfirmation() == null){
 			return accountingDocument;//do nothing when it is null
 		}
 		
 		getAccountingDocumentConfirmationDAO().save(accountingDocument.getConfirmation(),options);
 		return accountingDocument;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountingDocument saveAuditing(AccountingDocument accountingDocument, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocument.getAuditing() == null){
 			return accountingDocument;//do nothing when it is null
 		}
 		
 		getAccountingDocumentAuditingDAO().save(accountingDocument.getAuditing(),options);
 		return accountingDocument;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AccountingDocument savePosting(AccountingDocument accountingDocument, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(accountingDocument.getPosting() == null){
 			return accountingDocument;//do nothing when it is null
 		}
 		
 		getAccountingDocumentPostingDAO().save(accountingDocument.getPosting(),options);
 		return accountingDocument;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public AccountingDocument planToRemoveOriginalVoucherList(AccountingDocument accountingDocument, String originalVoucherIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(OriginalVoucher.BELONGS_TO_PROPERTY, accountingDocument.getId());
		key.put(OriginalVoucher.ID_PROPERTY, originalVoucherIds);
		
		SmartList<OriginalVoucher> externalOriginalVoucherList = getOriginalVoucherDAO().
				findOriginalVoucherWithKey(key, options);
		if(externalOriginalVoucherList == null){
			return accountingDocument;
		}
		if(externalOriginalVoucherList.isEmpty()){
			return accountingDocument;
		}
		
		for(OriginalVoucher originalVoucher: externalOriginalVoucherList){

			originalVoucher.clearFromAll();
		}
		
		
		SmartList<OriginalVoucher> originalVoucherList = accountingDocument.getOriginalVoucherList();		
		originalVoucherList.addAllToRemoveList(externalOriginalVoucherList);
		return accountingDocument;	
	
	}


	public AccountingDocument planToRemoveAccountingDocumentLineList(AccountingDocument accountingDocument, String accountingDocumentLineIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocumentLine.BELONGS_TO_PROPERTY, accountingDocument.getId());
		key.put(AccountingDocumentLine.ID_PROPERTY, accountingDocumentLineIds);
		
		SmartList<AccountingDocumentLine> externalAccountingDocumentLineList = getAccountingDocumentLineDAO().
				findAccountingDocumentLineWithKey(key, options);
		if(externalAccountingDocumentLineList == null){
			return accountingDocument;
		}
		if(externalAccountingDocumentLineList.isEmpty()){
			return accountingDocument;
		}
		
		for(AccountingDocumentLine accountingDocumentLine: externalAccountingDocumentLineList){

			accountingDocumentLine.clearFromAll();
		}
		
		
		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingDocument.getAccountingDocumentLineList();		
		accountingDocumentLineList.addAllToRemoveList(externalAccountingDocumentLineList);
		return accountingDocument;	
	
	}


	//disconnect AccountingDocument with accounting_subject in AccountingDocumentLine
	public AccountingDocument planToRemoveAccountingDocumentLineListWithAccountingSubject(AccountingDocument accountingDocument, String accountingSubjectId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocumentLine.BELONGS_TO_PROPERTY, accountingDocument.getId());
		key.put(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, accountingSubjectId);
		
		SmartList<AccountingDocumentLine> externalAccountingDocumentLineList = getAccountingDocumentLineDAO().
				findAccountingDocumentLineWithKey(key, options);
		if(externalAccountingDocumentLineList == null){
			return accountingDocument;
		}
		if(externalAccountingDocumentLineList.isEmpty()){
			return accountingDocument;
		}
		
		for(AccountingDocumentLine accountingDocumentLine: externalAccountingDocumentLineList){
			accountingDocumentLine.clearAccountingSubject();
			accountingDocumentLine.clearBelongsTo();
			
		}
		
		
		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingDocument.getAccountingDocumentLineList();		
		accountingDocumentLineList.addAllToRemoveList(externalAccountingDocumentLineList);
		return accountingDocument;
	}
	
	public int countAccountingDocumentLineListWithAccountingSubject(String accountingDocumentId, String accountingSubjectId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountingDocumentLine.BELONGS_TO_PROPERTY, accountingDocumentId);
		key.put(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, accountingSubjectId);
		
		int count = getAccountingDocumentLineDAO().countAccountingDocumentLineWithKey(key, options);
		return count;
	}
	

		
	protected AccountingDocument saveOriginalVoucherList(AccountingDocument accountingDocument, Map<String,Object> options){
		
		
		
		
		SmartList<OriginalVoucher> originalVoucherList = accountingDocument.getOriginalVoucherList();
		if(originalVoucherList == null){
			//null list means nothing
			return accountingDocument;
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
		
		
		return accountingDocument;
	
	}
	
	protected AccountingDocument removeOriginalVoucherList(AccountingDocument accountingDocument, Map<String,Object> options){
	
	
		SmartList<OriginalVoucher> originalVoucherList = accountingDocument.getOriginalVoucherList();
		if(originalVoucherList == null){
			return accountingDocument;
		}	
	
		SmartList<OriginalVoucher> toRemoveOriginalVoucherList = originalVoucherList.getToRemoveList();
		
		if(toRemoveOriginalVoucherList == null){
			return accountingDocument;
		}
		if(toRemoveOriginalVoucherList.isEmpty()){
			return accountingDocument;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getOriginalVoucherDAO().removeOriginalVoucherList(toRemoveOriginalVoucherList,options);
		
		return accountingDocument;
	
	}
	
	

 	
 	
	
	
	
		
	protected AccountingDocument saveAccountingDocumentLineList(AccountingDocument accountingDocument, Map<String,Object> options){
		
		
		
		
		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingDocument.getAccountingDocumentLineList();
		if(accountingDocumentLineList == null){
			//null list means nothing
			return accountingDocument;
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
		
		
		return accountingDocument;
	
	}
	
	protected AccountingDocument removeAccountingDocumentLineList(AccountingDocument accountingDocument, Map<String,Object> options){
	
	
		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingDocument.getAccountingDocumentLineList();
		if(accountingDocumentLineList == null){
			return accountingDocument;
		}	
	
		SmartList<AccountingDocumentLine> toRemoveAccountingDocumentLineList = accountingDocumentLineList.getToRemoveList();
		
		if(toRemoveAccountingDocumentLineList == null){
			return accountingDocument;
		}
		if(toRemoveAccountingDocumentLineList.isEmpty()){
			return accountingDocument;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountingDocumentLineDAO().removeAccountingDocumentLineList(toRemoveAccountingDocumentLineList,options);
		
		return accountingDocument;
	
	}
	
	

 	
 	
	
	
	
		

	public AccountingDocument present(AccountingDocument accountingDocument,Map<String, Object> options){
	
		presentOriginalVoucherList(accountingDocument,options);
		presentAccountingDocumentLineList(accountingDocument,options);

		return accountingDocument;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected AccountingDocument presentOriginalVoucherList(
			AccountingDocument accountingDocument,
			Map<String, Object> options) {

		SmartList<OriginalVoucher> originalVoucherList = accountingDocument.getOriginalVoucherList();		
				SmartList<OriginalVoucher> newList= presentSubList(accountingDocument.getId(),
				originalVoucherList,
				options,
				getOriginalVoucherDAO()::countOriginalVoucherByBelongsTo,
				getOriginalVoucherDAO()::findOriginalVoucherByBelongsTo
				);

		
		accountingDocument.setOriginalVoucherList(newList);
		

		return accountingDocument;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected AccountingDocument presentAccountingDocumentLineList(
			AccountingDocument accountingDocument,
			Map<String, Object> options) {

		SmartList<AccountingDocumentLine> accountingDocumentLineList = accountingDocument.getAccountingDocumentLineList();		
				SmartList<AccountingDocumentLine> newList= presentSubList(accountingDocument.getId(),
				accountingDocumentLineList,
				options,
				getAccountingDocumentLineDAO()::countAccountingDocumentLineByBelongsTo,
				getAccountingDocumentLineDAO()::findAccountingDocumentLineByBelongsTo
				);

		
		accountingDocument.setAccountingDocumentLineList(newList);
		

		return accountingDocument;
	}			
		

	
    public SmartList<AccountingDocument> requestCandidateAccountingDocumentForOriginalVoucher(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(AccountingDocumentTable.COLUMN_NAME, filterKey, pageNo, pageSize, getAccountingDocumentMapper());
    }
		
    public SmartList<AccountingDocument> requestCandidateAccountingDocumentForAccountingDocumentLine(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(AccountingDocumentTable.COLUMN_NAME, filterKey, pageNo, pageSize, getAccountingDocumentMapper());
    }
		

	protected String getTableName(){
		return AccountingDocumentTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<AccountingDocument> accountingDocumentList) {		
		this.enhanceListInternal(accountingDocumentList, this.getAccountingDocumentMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<AccountingDocument> accountingDocumentList = ownerEntity.collectRefsWithType(AccountingDocument.INTERNAL_TYPE);
		this.enhanceList(accountingDocumentList);
		
	}
	
	@Override
	public SmartList<AccountingDocument> findAccountingDocumentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getAccountingDocumentMapper());

	}
	@Override
	public int countAccountingDocumentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countAccountingDocumentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<AccountingDocument> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getAccountingDocumentMapper());
	}
}


