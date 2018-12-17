
package com.doublechaintech.retailscm.originalvoucher;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;


import com.doublechaintech.retailscm.Message;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;

import com.doublechaintech.retailscm.RetailscmUserContext;
//import com.doublechaintech.retailscm.BaseManagerImpl;
import com.doublechaintech.retailscm.RetailscmCheckerManager;
import com.doublechaintech.retailscm.CustomRetailscmCheckerManager;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.doublechaintech.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.doublechaintech.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;

import com.doublechaintech.retailscm.accountingdocument.CandidateAccountingDocument;
import com.doublechaintech.retailscm.originalvouchercreation.CandidateOriginalVoucherCreation;
import com.doublechaintech.retailscm.originalvoucherauditing.CandidateOriginalVoucherAuditing;
import com.doublechaintech.retailscm.originalvoucherconfirmation.CandidateOriginalVoucherConfirmation;







public class OriginalVoucherManagerImpl extends CustomRetailscmCheckerManager implements OriginalVoucherManager {
	
	private static final String SERVICE_TYPE = "OriginalVoucher";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws OriginalVoucherManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new OriginalVoucherManagerException(message);

	}
	
	

 	protected OriginalVoucher saveOriginalVoucher(RetailscmUserContext userContext, OriginalVoucher originalVoucher, String [] tokensExpr) throws Exception{	
 		//return getOriginalVoucherDAO().save(originalVoucher, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOriginalVoucher(userContext, originalVoucher, tokens);
 	}
 	
 	protected OriginalVoucher saveOriginalVoucherDetail(RetailscmUserContext userContext, OriginalVoucher originalVoucher) throws Exception{	

 		
 		return saveOriginalVoucher(userContext, originalVoucher, allTokens());
 	}
 	
 	public OriginalVoucher loadOriginalVoucher(RetailscmUserContext userContext, String originalVoucherId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().throwExceptionIfHasErrors( OriginalVoucherManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucher, tokens);
 	}
 	
 	
 	 public OriginalVoucher searchOriginalVoucher(RetailscmUserContext userContext, String originalVoucherId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().throwExceptionIfHasErrors( OriginalVoucherManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucher, tokens);
 	}
 	
 	

 	protected OriginalVoucher present(RetailscmUserContext userContext, OriginalVoucher originalVoucher, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,originalVoucher,tokens);
		
		
		OriginalVoucher  originalVoucherToPresent = userContext.getDAOGroup().getOriginalVoucherDAO().present(originalVoucher, tokens);
		
		List<BaseEntity> entityListToNaming = originalVoucherToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getOriginalVoucherDAO().alias(entityListToNaming);
		
		return  originalVoucherToPresent;
		
		
	}
 
 	
 	
 	public OriginalVoucher loadOriginalVoucherDetail(RetailscmUserContext userContext, String originalVoucherId) throws Exception{	
 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, allTokens());
 		return present(userContext,originalVoucher, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String originalVoucherId) throws Exception{	
 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, viewTokens());
 		return present(userContext,originalVoucher, allTokens());
		
 	}
 	protected OriginalVoucher saveOriginalVoucher(RetailscmUserContext userContext, OriginalVoucher originalVoucher, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getOriginalVoucherDAO().save(originalVoucher, tokens);
 	}
 	protected OriginalVoucher loadOriginalVoucher(RetailscmUserContext userContext, String originalVoucherId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().throwExceptionIfHasErrors( OriginalVoucherManagerException.class);

 
 		return userContext.getDAOGroup().getOriginalVoucherDAO().load(originalVoucherId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OriginalVoucher originalVoucher, Map<String, Object> tokens){
		super.addActions(userContext, originalVoucher, tokens);
		
		addAction(userContext, originalVoucher, tokens,"@create","createOriginalVoucher","createOriginalVoucher/","main","primary");
		addAction(userContext, originalVoucher, tokens,"@update","updateOriginalVoucher","updateOriginalVoucher/"+originalVoucher.getId()+"/","main","primary");
		addAction(userContext, originalVoucher, tokens,"@copy","cloneOriginalVoucher","cloneOriginalVoucher/"+originalVoucher.getId()+"/","main","primary");
		
		addAction(userContext, originalVoucher, tokens,"original_voucher.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+originalVoucher.getId()+"/","main","primary");
		addAction(userContext, originalVoucher, tokens,"original_voucher.create","create","createActionForm/"+originalVoucher.getId()+"/","main","primary");
		addAction(userContext, originalVoucher, tokens,"original_voucher.confirm","confirm","confirmActionForm/"+originalVoucher.getId()+"/","main","success");
		addAction(userContext, originalVoucher, tokens,"original_voucher.audit","audit","auditActionForm/"+originalVoucher.getId()+"/","main","success");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OriginalVoucher originalVoucher, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OriginalVoucher createOriginalVoucher(RetailscmUserContext userContext,String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId) throws Exception
	{
		
		

		

		userContext.getChecker().checkTitleOfOriginalVoucher(title);
		userContext.getChecker().checkMadeByOfOriginalVoucher(madeBy);
		userContext.getChecker().checkReceivedByOfOriginalVoucher(receivedBy);
		userContext.getChecker().checkVoucherTypeOfOriginalVoucher(voucherType);
		userContext.getChecker().checkVoucherImageOfOriginalVoucher(voucherImage);
	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherManagerException.class);


		OriginalVoucher originalVoucher=createNewOriginalVoucher();	

		originalVoucher.setTitle(title);
		originalVoucher.setMadeBy(madeBy);
		originalVoucher.setReceivedBy(receivedBy);
		originalVoucher.setVoucherType(voucherType);
		originalVoucher.setVoucherImage(voucherImage);
			
		AccountingDocument belongsTo = loadAccountingDocument(userContext, belongsToId,emptyOptions());
		originalVoucher.setBelongsTo(belongsTo);
		
		
		originalVoucher.setCurrentStatus("INIT");

		originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
		
		onNewInstanceCreated(userContext, originalVoucher);
		return originalVoucher;

		
	}
	protected OriginalVoucher createNewOriginalVoucher() 
	{
		
		return new OriginalVoucher();		
	}
	
	protected void checkParamsForUpdatingOriginalVoucher(RetailscmUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().checkVersionOfOriginalVoucher( originalVoucherVersion);
		

		if(OriginalVoucher.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfOriginalVoucher(parseString(newValueExpr));
		}
		if(OriginalVoucher.MADE_BY_PROPERTY.equals(property)){
			userContext.getChecker().checkMadeByOfOriginalVoucher(parseString(newValueExpr));
		}
		if(OriginalVoucher.RECEIVED_BY_PROPERTY.equals(property)){
			userContext.getChecker().checkReceivedByOfOriginalVoucher(parseString(newValueExpr));
		}
		if(OriginalVoucher.VOUCHER_TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkVoucherTypeOfOriginalVoucher(parseString(newValueExpr));
		}
		if(OriginalVoucher.VOUCHER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkVoucherImageOfOriginalVoucher(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherManagerException.class);
	
		
	}
	
	
	
	public OriginalVoucher clone(RetailscmUserContext userContext, String fromOriginalVoucherId) throws Exception{
		
		return userContext.getDAOGroup().getOriginalVoucherDAO().clone(fromOriginalVoucherId, this.allTokens());
	}
	
	public OriginalVoucher internalSaveOriginalVoucher(RetailscmUserContext userContext, OriginalVoucher originalVoucher) throws Exception 
	{
		return internalSaveOriginalVoucher(userContext, originalVoucher, allTokens());

	}
	public OriginalVoucher internalSaveOriginalVoucher(RetailscmUserContext userContext, OriginalVoucher originalVoucher, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherId, originalVoucherVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(originalVoucher){ 
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucher.
			
			
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, options);
			return originalVoucher;
			
		}

	}
	
	public OriginalVoucher updateOriginalVoucher(RetailscmUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherId, originalVoucherVersion, property, newValueExpr, tokensExpr);
		
		
		
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());
		if(originalVoucher.getVersion() != originalVoucherVersion){
			String message = "The target version("+originalVoucher.getVersion()+") is not equals to version("+originalVoucherVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucher){ 
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucher.
			
			originalVoucher.changeProperty(property, newValueExpr);
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().done());
			return present(userContext,originalVoucher, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucher(userContext, originalVoucher, tokens().done());
		}

	}
	
	public OriginalVoucher updateOriginalVoucherProperty(RetailscmUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherId, originalVoucherVersion, property, newValueExpr, tokensExpr);
		
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());
		if(originalVoucher.getVersion() != originalVoucherVersion){
			String message = "The target version("+originalVoucher.getVersion()+") is not equals to version("+originalVoucherVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucher){ 
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucher.
			
			originalVoucher.changeProperty(property, newValueExpr);
			
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().done());
			return present(userContext,originalVoucher, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucher(userContext, originalVoucher, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OriginalVoucherTokens tokens(){
		return OriginalVoucherTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OriginalVoucherTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OriginalVoucherTokens.mergeAll(tokens).done();
	}
	
	private static final String [] STATUS_SEQUENCE={"CREATED","CONFIRMED","AUDITED"};
 	protected String[] getNextCandidateStatus(RetailscmUserContext userContext, String currentStatus) throws Exception{
 	
 		if("INIT".equals(currentStatus)){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE;
 		}
 		/*
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throwExceptionWithMessage("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		
 		//this is not the last one, just return it.
 		*/
 		return STATUS_SEQUENCE;
 	
 	}/**/
 	protected void ensureStatus(RetailscmUserContext userContext, OriginalVoucher originalVoucher, String expectedNextStatus) throws Exception{
		String currentStatus = originalVoucher.getCurrentStatus();
		//'null' is fine for function getNextStatus
		String candidateStatus[] = getNextCandidateStatus(userContext, currentStatus);
		
		if(candidateStatus == null){
			//no more next status
			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'HIDDEN'";
			throwExceptionWithMessage(message);
		}
		int index = Arrays.asList(candidateStatus).indexOf(expectedNextStatus);
		if(index<0){
			String message = "The current status '"+currentStatus+"' next candidate status should be one of '"+candidateStatus+"', but you want to transit the status to '"+expectedNextStatus+"'";
			throwExceptionWithMessage(message);
		}
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailscmUserContext userContext, String originalVoucherId, String anotherBelongsToId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
 		userContext.getChecker().checkIdOfAccountingDocument(anotherBelongsToId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherManagerException.class);
 		
 	}
 	public OriginalVoucher transferToAnotherBelongsTo(RetailscmUserContext userContext, String originalVoucherId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, originalVoucherId,anotherBelongsToId);
 
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocument belongsTo = loadAccountingDocument(userContext, anotherBelongsToId, emptyOptions());		
			originalVoucher.updateBelongsTo(belongsTo);		
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
			
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateAccountingDocument requestCandidateBelongsTo(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocument result = new CandidateAccountingDocument();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocument> candidateList = userContext.getDAOGroup().getAccountingDocumentDAO().requestCandidateAccountingDocumentForOriginalVoucher(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherCreation(RetailscmUserContext userContext, String originalVoucherId, String anotherCreationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
 		userContext.getChecker().checkIdOfOriginalVoucherCreation(anotherCreationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherManagerException.class);
 		
 	}
 	public OriginalVoucher transferToAnotherCreation(RetailscmUserContext userContext, String originalVoucherId, String anotherCreationId) throws Exception
 	{
 		checkParamsForTransferingAnotherCreation(userContext, originalVoucherId,anotherCreationId);
 
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			OriginalVoucherCreation creation = loadOriginalVoucherCreation(userContext, anotherCreationId, emptyOptions());		
			originalVoucher.updateCreation(creation);		
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
			
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateOriginalVoucherCreation requestCandidateCreation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateOriginalVoucherCreation result = new CandidateOriginalVoucherCreation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<OriginalVoucherCreation> candidateList = userContext.getDAOGroup().getOriginalVoucherCreationDAO().requestCandidateOriginalVoucherCreationForOriginalVoucher(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String CREATED_STATUS = "CREATED";
 	protected void checkParamsForCreation(RetailscmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
) throws Exception
 	{
 				userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().checkWhoOfOriginalVoucherCreation(who);
		userContext.getChecker().checkCommentsOfOriginalVoucherCreation(comments);
		userContext.getChecker().checkMakeDateOfOriginalVoucherCreation(makeDate);

	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherManagerException.class);

 	}
 	public OriginalVoucher create(RetailscmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForCreation(userContext, originalVoucherId, who, comments, makeDate);
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForCreation(userContext,originalVoucher);
 		

			originalVoucher.updateCurrentStatus(CREATED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			OriginalVoucherCreation creation = createCreation(userContext, who, comments, makeDate);		
			originalVoucher.updateCreation(creation);		
			
			
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().withCreation().done());
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public OriginalVoucherForm createActionForm(RetailscmUserContext userContext, String originalVoucherId) throws Exception
 	{
		return new OriginalVoucherForm()
			.withTitle("create")
			.originalVoucherIdField(originalVoucherId)
			.whoFieldOfOriginalVoucherCreation()
			.commentsFieldOfOriginalVoucherCreation()
			.makeDateFieldOfOriginalVoucherCreation()
			.createAction();
 	}
	
 	
 	protected OriginalVoucherCreation createCreation(RetailscmUserContext userContext, String who, String comments, Date makeDate){
 		OriginalVoucherCreation creation = new OriginalVoucherCreation();
 		//who, comments, makeDate
 		
		creation.setWho(who);
		creation.setComments(comments);
		creation.setMakeDate(makeDate);

 		
 		
 		
 		return userContext.getDAOGroup().getOriginalVoucherCreationDAO().save(creation,emptyOptions());
 	}
 	protected void checkIfEligibleForCreation(RetailscmUserContext userContext, OriginalVoucher originalVoucher) throws Exception{
 
 		ensureStatus(userContext,originalVoucher, CREATED_STATUS);
 		
 		OriginalVoucherCreation creation = originalVoucher.getCreation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = creation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( creation != null){
				throwExceptionWithMessage("The OriginalVoucher("+originalVoucher.getId()+") has already been "+ CREATED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherConfirmation(RetailscmUserContext userContext, String originalVoucherId, String anotherConfirmationId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
 		userContext.getChecker().checkIdOfOriginalVoucherConfirmation(anotherConfirmationId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherManagerException.class);
 		
 	}
 	public OriginalVoucher transferToAnotherConfirmation(RetailscmUserContext userContext, String originalVoucherId, String anotherConfirmationId) throws Exception
 	{
 		checkParamsForTransferingAnotherConfirmation(userContext, originalVoucherId,anotherConfirmationId);
 
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			OriginalVoucherConfirmation confirmation = loadOriginalVoucherConfirmation(userContext, anotherConfirmationId, emptyOptions());		
			originalVoucher.updateConfirmation(confirmation);		
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
			
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateOriginalVoucherConfirmation requestCandidateConfirmation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateOriginalVoucherConfirmation result = new CandidateOriginalVoucherConfirmation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<OriginalVoucherConfirmation> candidateList = userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().requestCandidateOriginalVoucherConfirmationForOriginalVoucher(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String CONFIRMED_STATUS = "CONFIRMED";
 	protected void checkParamsForConfirmation(RetailscmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
) throws Exception
 	{
 				userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().checkWhoOfOriginalVoucherConfirmation(who);
		userContext.getChecker().checkCommentsOfOriginalVoucherConfirmation(comments);
		userContext.getChecker().checkMakeDateOfOriginalVoucherConfirmation(makeDate);

	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherManagerException.class);

 	}
 	public OriginalVoucher confirm(RetailscmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForConfirmation(userContext, originalVoucherId, who, comments, makeDate);
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForConfirmation(userContext,originalVoucher);
 		

			originalVoucher.updateCurrentStatus(CONFIRMED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			OriginalVoucherConfirmation confirmation = createConfirmation(userContext, who, comments, makeDate);		
			originalVoucher.updateConfirmation(confirmation);		
			
			
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().withConfirmation().done());
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public OriginalVoucherForm confirmActionForm(RetailscmUserContext userContext, String originalVoucherId) throws Exception
 	{
		return new OriginalVoucherForm()
			.withTitle("confirm")
			.originalVoucherIdField(originalVoucherId)
			.whoFieldOfOriginalVoucherConfirmation()
			.commentsFieldOfOriginalVoucherConfirmation()
			.makeDateFieldOfOriginalVoucherConfirmation()
			.confirmAction();
 	}
	
 	
 	protected OriginalVoucherConfirmation createConfirmation(RetailscmUserContext userContext, String who, String comments, Date makeDate){
 		OriginalVoucherConfirmation confirmation = new OriginalVoucherConfirmation();
 		//who, comments, makeDate
 		
		confirmation.setWho(who);
		confirmation.setComments(comments);
		confirmation.setMakeDate(makeDate);

 		
 		
 		
 		return userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().save(confirmation,emptyOptions());
 	}
 	protected void checkIfEligibleForConfirmation(RetailscmUserContext userContext, OriginalVoucher originalVoucher) throws Exception{
 
 		ensureStatus(userContext,originalVoucher, CONFIRMED_STATUS);
 		
 		OriginalVoucherConfirmation confirmation = originalVoucher.getConfirmation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = confirmation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( confirmation != null){
				throwExceptionWithMessage("The OriginalVoucher("+originalVoucher.getId()+") has already been "+ CONFIRMED_STATUS+".");
		}
 		
 		
 	}
	protected void checkParamsForTransferingAnotherAuditing(RetailscmUserContext userContext, String originalVoucherId, String anotherAuditingId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
 		userContext.getChecker().checkIdOfOriginalVoucherAuditing(anotherAuditingId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherManagerException.class);
 		
 	}
 	public OriginalVoucher transferToAnotherAuditing(RetailscmUserContext userContext, String originalVoucherId, String anotherAuditingId) throws Exception
 	{
 		checkParamsForTransferingAnotherAuditing(userContext, originalVoucherId,anotherAuditingId);
 
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			OriginalVoucherAuditing auditing = loadOriginalVoucherAuditing(userContext, anotherAuditingId, emptyOptions());		
			originalVoucher.updateAuditing(auditing);		
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
			
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateOriginalVoucherAuditing requestCandidateAuditing(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateOriginalVoucherAuditing result = new CandidateOriginalVoucherAuditing();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<OriginalVoucherAuditing> candidateList = userContext.getDAOGroup().getOriginalVoucherAuditingDAO().requestCandidateOriginalVoucherAuditingForOriginalVoucher(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String AUDITED_STATUS = "AUDITED";
 	protected void checkParamsForAuditing(RetailscmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
) throws Exception
 	{
 				userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().checkWhoOfOriginalVoucherAuditing(who);
		userContext.getChecker().checkCommentsOfOriginalVoucherAuditing(comments);
		userContext.getChecker().checkMakeDateOfOriginalVoucherAuditing(makeDate);

	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherManagerException.class);

 	}
 	public OriginalVoucher audit(RetailscmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForAuditing(userContext, originalVoucherId, who, comments, makeDate);
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForAuditing(userContext,originalVoucher);
 		

			originalVoucher.updateCurrentStatus(AUDITED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			OriginalVoucherAuditing auditing = createAuditing(userContext, who, comments, makeDate);		
			originalVoucher.updateAuditing(auditing);		
			
			
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().withAuditing().done());
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public OriginalVoucherForm auditActionForm(RetailscmUserContext userContext, String originalVoucherId) throws Exception
 	{
		return new OriginalVoucherForm()
			.withTitle("audit")
			.originalVoucherIdField(originalVoucherId)
			.whoFieldOfOriginalVoucherAuditing()
			.commentsFieldOfOriginalVoucherAuditing()
			.makeDateFieldOfOriginalVoucherAuditing()
			.auditAction();
 	}
	
 	
 	protected OriginalVoucherAuditing createAuditing(RetailscmUserContext userContext, String who, String comments, Date makeDate){
 		OriginalVoucherAuditing auditing = new OriginalVoucherAuditing();
 		//who, comments, makeDate
 		
		auditing.setWho(who);
		auditing.setComments(comments);
		auditing.setMakeDate(makeDate);

 		
 		
 		
 		return userContext.getDAOGroup().getOriginalVoucherAuditingDAO().save(auditing,emptyOptions());
 	}
 	protected void checkIfEligibleForAuditing(RetailscmUserContext userContext, OriginalVoucher originalVoucher) throws Exception{
 
 		ensureStatus(userContext,originalVoucher, AUDITED_STATUS);
 		
 		OriginalVoucherAuditing auditing = originalVoucher.getAuditing();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = auditing 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( auditing != null){
				throwExceptionWithMessage("The OriginalVoucher("+originalVoucher.getId()+") has already been "+ AUDITED_STATUS+".");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected OriginalVoucherCreation loadOriginalVoucherCreation(RetailscmUserContext userContext, String newCreationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getOriginalVoucherCreationDAO().load(newCreationId, options);
 	}
 	
 	
 	
	
	 	
 	protected AccountingDocument loadAccountingDocument(RetailscmUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getAccountingDocumentDAO().load(newBelongsToId, options);
 	}
 	
 	
 	
	
	 	
 	protected OriginalVoucherConfirmation loadOriginalVoucherConfirmation(RetailscmUserContext userContext, String newConfirmationId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().load(newConfirmationId, options);
 	}
 	
 	
 	
	
	 	
 	protected OriginalVoucherAuditing loadOriginalVoucherAuditing(RetailscmUserContext userContext, String newAuditingId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getOriginalVoucherAuditingDAO().load(newAuditingId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String originalVoucherId, int originalVoucherVersion) throws Exception {
		//deleteInternal(userContext, originalVoucherId, originalVoucherVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String originalVoucherId, int originalVoucherVersion) throws Exception{
			
		userContext.getDAOGroup().getOriginalVoucherDAO().delete(originalVoucherId, originalVoucherVersion);
	}
	
	public OriginalVoucher forgetByAll(RetailscmUserContext userContext, String originalVoucherId, int originalVoucherVersion) throws Exception {
		return forgetByAllInternal(userContext, originalVoucherId, originalVoucherVersion);		
	}
	protected OriginalVoucher forgetByAllInternal(RetailscmUserContext userContext,
			String originalVoucherId, int originalVoucherVersion) throws Exception{
			
		return userContext.getDAOGroup().getOriginalVoucherDAO().disconnectFromAll(originalVoucherId, originalVoucherVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OriginalVoucherManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getOriginalVoucherDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, OriginalVoucher newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


