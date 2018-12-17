
package com.doublechaintech.retailscm.originalvoucher;

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
import com.doublechaintech.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.doublechaintech.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.doublechaintech.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;

import com.doublechaintech.retailscm.originalvoucherauditing.OriginalVoucherAuditingDAO;
import com.doublechaintech.retailscm.originalvouchercreation.OriginalVoucherCreationDAO;
import com.doublechaintech.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmationDAO;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class OriginalVoucherJDBCTemplateDAO extends RetailscmNamingServiceDAO implements OriginalVoucherDAO{
 
 	
 	private  OriginalVoucherCreationDAO  originalVoucherCreationDAO;
 	public void setOriginalVoucherCreationDAO(OriginalVoucherCreationDAO originalVoucherCreationDAO){
	 	this.originalVoucherCreationDAO = originalVoucherCreationDAO;
 	}
 	public OriginalVoucherCreationDAO getOriginalVoucherCreationDAO(){
	 	return this.originalVoucherCreationDAO;
 	}
 
 	
 	private  AccountingDocumentDAO  accountingDocumentDAO;
 	public void setAccountingDocumentDAO(AccountingDocumentDAO accountingDocumentDAO){
	 	this.accountingDocumentDAO = accountingDocumentDAO;
 	}
 	public AccountingDocumentDAO getAccountingDocumentDAO(){
	 	return this.accountingDocumentDAO;
 	}
 
 	
 	private  OriginalVoucherConfirmationDAO  originalVoucherConfirmationDAO;
 	public void setOriginalVoucherConfirmationDAO(OriginalVoucherConfirmationDAO originalVoucherConfirmationDAO){
	 	this.originalVoucherConfirmationDAO = originalVoucherConfirmationDAO;
 	}
 	public OriginalVoucherConfirmationDAO getOriginalVoucherConfirmationDAO(){
	 	return this.originalVoucherConfirmationDAO;
 	}
 
 	
 	private  OriginalVoucherAuditingDAO  originalVoucherAuditingDAO;
 	public void setOriginalVoucherAuditingDAO(OriginalVoucherAuditingDAO originalVoucherAuditingDAO){
	 	this.originalVoucherAuditingDAO = originalVoucherAuditingDAO;
 	}
 	public OriginalVoucherAuditingDAO getOriginalVoucherAuditingDAO(){
	 	return this.originalVoucherAuditingDAO;
 	}


			
		

	
	/*
	protected OriginalVoucher load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucher(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public OriginalVoucher load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucher(OriginalVoucherTable.withId(id), options);
	}
	
	
	
	public OriginalVoucher save(OriginalVoucher originalVoucher,Map<String,Object> options){
		
		String methodName="save(OriginalVoucher originalVoucher,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(originalVoucher, methodName, "originalVoucher");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOriginalVoucher(originalVoucher,options);
	}
	public OriginalVoucher clone(String originalVoucherId, Map<String,Object> options) throws Exception{
	
		return clone(OriginalVoucherTable.withId(originalVoucherId),options);
	}
	
	protected OriginalVoucher clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String originalVoucherId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OriginalVoucher newOriginalVoucher = loadInternalOriginalVoucher(accessKey, options);
		newOriginalVoucher.setVersion(0);
		
		

		
		saveInternalOriginalVoucher(newOriginalVoucher,options);
		
		return newOriginalVoucher;
	}
	
	
	
	

	protected void throwIfHasException(String originalVoucherId,int version,int count) throws Exception{
		if (count == 1) {
			throw new OriginalVoucherVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OriginalVoucherNotFoundException(
					"The " + this.getTableName() + "(" + originalVoucherId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String originalVoucherId, int version) throws Exception{
	
		String methodName="delete(String originalVoucherId, int version)";
		assertMethodArgumentNotNull(originalVoucherId, methodName, "originalVoucherId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{originalVoucherId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(originalVoucherId,version);
		}
		
	
	}
	
	
	
	
	

	public OriginalVoucher disconnectFromAll(String originalVoucherId, int version) throws Exception{
	
		
		OriginalVoucher originalVoucher = loadInternalOriginalVoucher(OriginalVoucherTable.withId(originalVoucherId), emptyOptions());
		originalVoucher.clearFromAll();
		this.saveOriginalVoucher(originalVoucher);
		return originalVoucher;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return OriginalVoucherTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "original_voucher";
	}
	@Override
	protected String getBeanName() {
		
		return "originalVoucher";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OriginalVoucherTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OriginalVoucherTokens.BELONGSTO);
 	}

 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OriginalVoucherTokens.BELONGSTO);
 	}
 	

 	
  

 	protected boolean isExtractCreationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OriginalVoucherTokens.CREATION);
 	}

 	protected boolean isSaveCreationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OriginalVoucherTokens.CREATION);
 	}
 	

 	
  

 	protected boolean isExtractConfirmationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OriginalVoucherTokens.CONFIRMATION);
 	}

 	protected boolean isSaveConfirmationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OriginalVoucherTokens.CONFIRMATION);
 	}
 	

 	
  

 	protected boolean isExtractAuditingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OriginalVoucherTokens.AUDITING);
 	}

 	protected boolean isSaveAuditingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OriginalVoucherTokens.AUDITING);
 	}
 	

 	
 
		

	

	protected OriginalVoucherMapper getOriginalVoucherMapper(){
		return new OriginalVoucherMapper();
	}

	
	
	protected OriginalVoucher extractOriginalVoucher(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			OriginalVoucher originalVoucher = loadSingleObject(accessKey, getOriginalVoucherMapper());
			return originalVoucher;
		}catch(EmptyResultDataAccessException e){
			throw new OriginalVoucherNotFoundException("OriginalVoucher("+accessKey+") is not found!");
		}

	}

	
	

	protected OriginalVoucher loadInternalOriginalVoucher(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OriginalVoucher originalVoucher = extractOriginalVoucher(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(originalVoucher, loadOptions);
 		}
  	
 		if(isExtractCreationEnabled(loadOptions)){
	 		extractCreation(originalVoucher, loadOptions);
 		}
  	
 		if(isExtractConfirmationEnabled(loadOptions)){
	 		extractConfirmation(originalVoucher, loadOptions);
 		}
  	
 		if(isExtractAuditingEnabled(loadOptions)){
	 		extractAuditing(originalVoucher, loadOptions);
 		}
 
		
		return originalVoucher;
		
	}



	
	
	 

 	protected OriginalVoucher extractBelongsTo(OriginalVoucher originalVoucher, Map<String,Object> options) throws Exception{

		if(originalVoucher.getBelongsTo() == null){
			return originalVoucher;
		}
		String belongsToId = originalVoucher.getBelongsTo().getId();
		if( belongsToId == null){
			return originalVoucher;
		}
		AccountingDocument belongsTo = getAccountingDocumentDAO().load(belongsToId,options);
		if(belongsTo != null){
			originalVoucher.setBelongsTo(belongsTo);
		}
		
 		
 		return originalVoucher;
 	}
 		
  

 	protected OriginalVoucher extractCreation(OriginalVoucher originalVoucher, Map<String,Object> options) throws Exception{

		if(originalVoucher.getCreation() == null){
			return originalVoucher;
		}
		String creationId = originalVoucher.getCreation().getId();
		if( creationId == null){
			return originalVoucher;
		}
		OriginalVoucherCreation creation = getOriginalVoucherCreationDAO().load(creationId,options);
		if(creation != null){
			originalVoucher.setCreation(creation);
		}
		
 		
 		return originalVoucher;
 	}
 		
  

 	protected OriginalVoucher extractConfirmation(OriginalVoucher originalVoucher, Map<String,Object> options) throws Exception{

		if(originalVoucher.getConfirmation() == null){
			return originalVoucher;
		}
		String confirmationId = originalVoucher.getConfirmation().getId();
		if( confirmationId == null){
			return originalVoucher;
		}
		OriginalVoucherConfirmation confirmation = getOriginalVoucherConfirmationDAO().load(confirmationId,options);
		if(confirmation != null){
			originalVoucher.setConfirmation(confirmation);
		}
		
 		
 		return originalVoucher;
 	}
 		
  

 	protected OriginalVoucher extractAuditing(OriginalVoucher originalVoucher, Map<String,Object> options) throws Exception{

		if(originalVoucher.getAuditing() == null){
			return originalVoucher;
		}
		String auditingId = originalVoucher.getAuditing().getId();
		if( auditingId == null){
			return originalVoucher;
		}
		OriginalVoucherAuditing auditing = getOriginalVoucherAuditingDAO().load(auditingId,options);
		if(auditing != null){
			originalVoucher.setAuditing(auditing);
		}
		
 		
 		return originalVoucher;
 	}
 		
 
		
		
  	
 	public SmartList<OriginalVoucher> findOriginalVoucherByBelongsTo(String accountingDocumentId,Map<String,Object> options){
 	
  		SmartList<OriginalVoucher> resultList = queryWith(OriginalVoucherTable.COLUMN_BELONGS_TO, accountingDocumentId, options, getOriginalVoucherMapper());
		analyzeOriginalVoucherByBelongsTo(resultList, accountingDocumentId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<OriginalVoucher> findOriginalVoucherByBelongsTo(String accountingDocumentId, int start, int count,Map<String,Object> options){
 		
 		SmartList<OriginalVoucher> resultList =  queryWithRange(OriginalVoucherTable.COLUMN_BELONGS_TO, accountingDocumentId, options, getOriginalVoucherMapper(), start, count);
 		analyzeOriginalVoucherByBelongsTo(resultList, accountingDocumentId, options);
 		return resultList;
 		
 	}
 	public void analyzeOriginalVoucherByBelongsTo(SmartList<OriginalVoucher> resultList, String accountingDocumentId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(OriginalVoucher.BELONGS_TO_PROPERTY, accountingDocumentId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countOriginalVoucherByBelongsTo(String accountingDocumentId,Map<String,Object> options){

 		return countWith(OriginalVoucherTable.COLUMN_BELONGS_TO, accountingDocumentId, options);
 	}
 	@Override
	public Map<String, Integer> countOriginalVoucherByBelongsToIds(String[] ids, Map<String, Object> options) {
		return countWithIds(OriginalVoucherTable.COLUMN_BELONGS_TO, ids, options);
	}
 	
  	
 	public SmartList<OriginalVoucher> findOriginalVoucherByCreation(String originalVoucherCreationId,Map<String,Object> options){
 	
  		SmartList<OriginalVoucher> resultList = queryWith(OriginalVoucherTable.COLUMN_CREATION, originalVoucherCreationId, options, getOriginalVoucherMapper());
		analyzeOriginalVoucherByCreation(resultList, originalVoucherCreationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<OriginalVoucher> findOriginalVoucherByCreation(String originalVoucherCreationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<OriginalVoucher> resultList =  queryWithRange(OriginalVoucherTable.COLUMN_CREATION, originalVoucherCreationId, options, getOriginalVoucherMapper(), start, count);
 		analyzeOriginalVoucherByCreation(resultList, originalVoucherCreationId, options);
 		return resultList;
 		
 	}
 	public void analyzeOriginalVoucherByCreation(SmartList<OriginalVoucher> resultList, String originalVoucherCreationId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(OriginalVoucher.CREATION_PROPERTY, originalVoucherCreationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countOriginalVoucherByCreation(String originalVoucherCreationId,Map<String,Object> options){

 		return countWith(OriginalVoucherTable.COLUMN_CREATION, originalVoucherCreationId, options);
 	}
 	@Override
	public Map<String, Integer> countOriginalVoucherByCreationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(OriginalVoucherTable.COLUMN_CREATION, ids, options);
	}
 	
  	
 	public SmartList<OriginalVoucher> findOriginalVoucherByConfirmation(String originalVoucherConfirmationId,Map<String,Object> options){
 	
  		SmartList<OriginalVoucher> resultList = queryWith(OriginalVoucherTable.COLUMN_CONFIRMATION, originalVoucherConfirmationId, options, getOriginalVoucherMapper());
		analyzeOriginalVoucherByConfirmation(resultList, originalVoucherConfirmationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<OriginalVoucher> findOriginalVoucherByConfirmation(String originalVoucherConfirmationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<OriginalVoucher> resultList =  queryWithRange(OriginalVoucherTable.COLUMN_CONFIRMATION, originalVoucherConfirmationId, options, getOriginalVoucherMapper(), start, count);
 		analyzeOriginalVoucherByConfirmation(resultList, originalVoucherConfirmationId, options);
 		return resultList;
 		
 	}
 	public void analyzeOriginalVoucherByConfirmation(SmartList<OriginalVoucher> resultList, String originalVoucherConfirmationId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(OriginalVoucher.CONFIRMATION_PROPERTY, originalVoucherConfirmationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countOriginalVoucherByConfirmation(String originalVoucherConfirmationId,Map<String,Object> options){

 		return countWith(OriginalVoucherTable.COLUMN_CONFIRMATION, originalVoucherConfirmationId, options);
 	}
 	@Override
	public Map<String, Integer> countOriginalVoucherByConfirmationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(OriginalVoucherTable.COLUMN_CONFIRMATION, ids, options);
	}
 	
  	
 	public SmartList<OriginalVoucher> findOriginalVoucherByAuditing(String originalVoucherAuditingId,Map<String,Object> options){
 	
  		SmartList<OriginalVoucher> resultList = queryWith(OriginalVoucherTable.COLUMN_AUDITING, originalVoucherAuditingId, options, getOriginalVoucherMapper());
		analyzeOriginalVoucherByAuditing(resultList, originalVoucherAuditingId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<OriginalVoucher> findOriginalVoucherByAuditing(String originalVoucherAuditingId, int start, int count,Map<String,Object> options){
 		
 		SmartList<OriginalVoucher> resultList =  queryWithRange(OriginalVoucherTable.COLUMN_AUDITING, originalVoucherAuditingId, options, getOriginalVoucherMapper(), start, count);
 		analyzeOriginalVoucherByAuditing(resultList, originalVoucherAuditingId, options);
 		return resultList;
 		
 	}
 	public void analyzeOriginalVoucherByAuditing(SmartList<OriginalVoucher> resultList, String originalVoucherAuditingId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(OriginalVoucher.AUDITING_PROPERTY, originalVoucherAuditingId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countOriginalVoucherByAuditing(String originalVoucherAuditingId,Map<String,Object> options){

 		return countWith(OriginalVoucherTable.COLUMN_AUDITING, originalVoucherAuditingId, options);
 	}
 	@Override
	public Map<String, Integer> countOriginalVoucherByAuditingIds(String[] ids, Map<String, Object> options) {
		return countWithIds(OriginalVoucherTable.COLUMN_AUDITING, ids, options);
	}
 	
 	
		
		
		

	

	protected OriginalVoucher saveOriginalVoucher(OriginalVoucher  originalVoucher){
		
		if(!originalVoucher.isChanged()){
			return originalVoucher;
		}
		
		
		String SQL=this.getSaveOriginalVoucherSQL(originalVoucher);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOriginalVoucherParameters(originalVoucher);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		originalVoucher.incVersion();
		return originalVoucher;
	
	}
	public SmartList<OriginalVoucher> saveOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOriginalVoucherList(originalVoucherList);
		
		batchOriginalVoucherCreate((List<OriginalVoucher>)lists[CREATE_LIST_INDEX]);
		
		batchOriginalVoucherUpdate((List<OriginalVoucher>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OriginalVoucher originalVoucher:originalVoucherList){
			if(originalVoucher.isChanged()){
				originalVoucher.incVersion();
			}
			
		
		}
		
		
		return originalVoucherList;
	}

	public SmartList<OriginalVoucher> removeOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options){
		
		
		super.removeList(originalVoucherList, options);
		
		return originalVoucherList;
		
		
	}
	
	protected List<Object[]> prepareOriginalVoucherBatchCreateArgs(List<OriginalVoucher> originalVoucherList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucher originalVoucher:originalVoucherList ){
			Object [] parameters = prepareOriginalVoucherCreateParameters(originalVoucher);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOriginalVoucherBatchUpdateArgs(List<OriginalVoucher> originalVoucherList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucher originalVoucher:originalVoucherList ){
			if(!originalVoucher.isChanged()){
				continue;
			}
			Object [] parameters = prepareOriginalVoucherUpdateParameters(originalVoucher);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOriginalVoucherCreate(List<OriginalVoucher> originalVoucherList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOriginalVoucherBatchCreateArgs(originalVoucherList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOriginalVoucherUpdate(List<OriginalVoucher> originalVoucherList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOriginalVoucherBatchUpdateArgs(originalVoucherList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOriginalVoucherList(List<OriginalVoucher> originalVoucherList){
		
		List<OriginalVoucher> originalVoucherCreateList=new ArrayList<OriginalVoucher>();
		List<OriginalVoucher> originalVoucherUpdateList=new ArrayList<OriginalVoucher>();
		
		for(OriginalVoucher originalVoucher: originalVoucherList){
			if(isUpdateRequest(originalVoucher)){
				originalVoucherUpdateList.add( originalVoucher);
				continue;
			}
			originalVoucherCreateList.add(originalVoucher);
		}
		
		return new Object[]{originalVoucherCreateList,originalVoucherUpdateList};
	}
	
	protected boolean isUpdateRequest(OriginalVoucher originalVoucher){
 		return originalVoucher.getVersion() > 0;
 	}
 	protected String getSaveOriginalVoucherSQL(OriginalVoucher originalVoucher){
 		if(isUpdateRequest(originalVoucher)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOriginalVoucherParameters(OriginalVoucher originalVoucher){
 		if(isUpdateRequest(originalVoucher) ){
 			return prepareOriginalVoucherUpdateParameters(originalVoucher);
 		}
 		return prepareOriginalVoucherCreateParameters(originalVoucher);
 	}
 	protected Object[] prepareOriginalVoucherUpdateParameters(OriginalVoucher originalVoucher){
 		Object[] parameters = new Object[13];
 
 		parameters[0] = originalVoucher.getTitle();
 		parameters[1] = originalVoucher.getMadeBy();
 		parameters[2] = originalVoucher.getReceivedBy();
 		parameters[3] = originalVoucher.getVoucherType();
 		parameters[4] = originalVoucher.getVoucherImage(); 	
 		if(originalVoucher.getBelongsTo() != null){
 			parameters[5] = originalVoucher.getBelongsTo().getId();
 		}
  	
 		if(originalVoucher.getCreation() != null){
 			parameters[6] = originalVoucher.getCreation().getId();
 		}
  	
 		if(originalVoucher.getConfirmation() != null){
 			parameters[7] = originalVoucher.getConfirmation().getId();
 		}
  	
 		if(originalVoucher.getAuditing() != null){
 			parameters[8] = originalVoucher.getAuditing().getId();
 		}
 
 		parameters[9] = originalVoucher.getCurrentStatus();		
 		parameters[10] = originalVoucher.nextVersion();
 		parameters[11] = originalVoucher.getId();
 		parameters[12] = originalVoucher.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOriginalVoucherCreateParameters(OriginalVoucher originalVoucher){
		Object[] parameters = new Object[11];
		String newOriginalVoucherId=getNextId();
		originalVoucher.setId(newOriginalVoucherId);
		parameters[0] =  originalVoucher.getId();
 
 		parameters[1] = originalVoucher.getTitle();
 		parameters[2] = originalVoucher.getMadeBy();
 		parameters[3] = originalVoucher.getReceivedBy();
 		parameters[4] = originalVoucher.getVoucherType();
 		parameters[5] = originalVoucher.getVoucherImage(); 	
 		if(originalVoucher.getBelongsTo() != null){
 			parameters[6] = originalVoucher.getBelongsTo().getId();
 		
 		}
 		 	
 		if(originalVoucher.getCreation() != null){
 			parameters[7] = originalVoucher.getCreation().getId();
 		
 		}
 		 	
 		if(originalVoucher.getConfirmation() != null){
 			parameters[8] = originalVoucher.getConfirmation().getId();
 		
 		}
 		 	
 		if(originalVoucher.getAuditing() != null){
 			parameters[9] = originalVoucher.getAuditing().getId();
 		
 		}
 		
 		parameters[10] = originalVoucher.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected OriginalVoucher saveInternalOriginalVoucher(OriginalVoucher originalVoucher, Map<String,Object> options){
		
		saveOriginalVoucher(originalVoucher);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(originalVoucher, options);
 		}
  	
 		if(isSaveCreationEnabled(options)){
	 		saveCreation(originalVoucher, options);
 		}
  	
 		if(isSaveConfirmationEnabled(options)){
	 		saveConfirmation(originalVoucher, options);
 		}
  	
 		if(isSaveAuditingEnabled(options)){
	 		saveAuditing(originalVoucher, options);
 		}
 
		
		return originalVoucher;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected OriginalVoucher saveBelongsTo(OriginalVoucher originalVoucher, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(originalVoucher.getBelongsTo() == null){
 			return originalVoucher;//do nothing when it is null
 		}
 		
 		getAccountingDocumentDAO().save(originalVoucher.getBelongsTo(),options);
 		return originalVoucher;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected OriginalVoucher saveCreation(OriginalVoucher originalVoucher, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(originalVoucher.getCreation() == null){
 			return originalVoucher;//do nothing when it is null
 		}
 		
 		getOriginalVoucherCreationDAO().save(originalVoucher.getCreation(),options);
 		return originalVoucher;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected OriginalVoucher saveConfirmation(OriginalVoucher originalVoucher, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(originalVoucher.getConfirmation() == null){
 			return originalVoucher;//do nothing when it is null
 		}
 		
 		getOriginalVoucherConfirmationDAO().save(originalVoucher.getConfirmation(),options);
 		return originalVoucher;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected OriginalVoucher saveAuditing(OriginalVoucher originalVoucher, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(originalVoucher.getAuditing() == null){
 			return originalVoucher;//do nothing when it is null
 		}
 		
 		getOriginalVoucherAuditingDAO().save(originalVoucher.getAuditing(),options);
 		return originalVoucher;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public OriginalVoucher present(OriginalVoucher originalVoucher,Map<String, Object> options){
	

		return originalVoucher;
	
	}
		

	

	protected String getTableName(){
		return OriginalVoucherTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<OriginalVoucher> originalVoucherList) {		
		this.enhanceListInternal(originalVoucherList, this.getOriginalVoucherMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<OriginalVoucher> originalVoucherList = ownerEntity.collectRefsWithType(OriginalVoucher.INTERNAL_TYPE);
		this.enhanceList(originalVoucherList);
		
	}
	
	@Override
	public SmartList<OriginalVoucher> findOriginalVoucherWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getOriginalVoucherMapper());

	}
	@Override
	public int countOriginalVoucherWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countOriginalVoucherWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<OriginalVoucher> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getOriginalVoucherMapper());
	}
}


