
package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;

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

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;

import com.doublechaintech.retailscm.consumerorder.CandidateConsumerOrder;
import com.doublechaintech.retailscm.retailstoremembergiftcard.CandidateRetailStoreMemberGiftCard;







public class RetailStoreMemberGiftCardConsumeRecordManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreMemberGiftCardConsumeRecordManager {
	
	private static final String SERVICE_TYPE = "RetailStoreMemberGiftCardConsumeRecord";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreMemberGiftCardConsumeRecordManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreMemberGiftCardConsumeRecordManagerException(message);

	}
	
	

 	protected RetailStoreMemberGiftCardConsumeRecord saveRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreMemberGiftCardConsumeRecordDAO().save(retailStoreMemberGiftCardConsumeRecord, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens);
 	}
 	
 	protected RetailStoreMemberGiftCardConsumeRecord saveRetailStoreMemberGiftCardConsumeRecordDetail(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) throws Exception{	

 		
 		return saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, allTokens());
 	}
 	
 	public RetailStoreMemberGiftCardConsumeRecord loadRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreMemberGiftCardConsumeRecordManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberGiftCardConsumeRecord, tokens);
 	}
 	
 	
 	 public RetailStoreMemberGiftCardConsumeRecord searchRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreMemberGiftCardConsumeRecordManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberGiftCardConsumeRecord, tokens);
 	}
 	
 	

 	protected RetailStoreMemberGiftCardConsumeRecord present(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreMemberGiftCardConsumeRecord,tokens);
		
		
		RetailStoreMemberGiftCardConsumeRecord  retailStoreMemberGiftCardConsumeRecordToPresent = userContext.getDAOGroup().getRetailStoreMemberGiftCardConsumeRecordDAO().present(retailStoreMemberGiftCardConsumeRecord, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreMemberGiftCardConsumeRecordToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreMemberGiftCardConsumeRecordDAO().alias(entityListToNaming);
		
		return  retailStoreMemberGiftCardConsumeRecordToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreMemberGiftCardConsumeRecord loadRetailStoreMemberGiftCardConsumeRecordDetail(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId) throws Exception{	
 		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());
 		return present(userContext,retailStoreMemberGiftCardConsumeRecord, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId) throws Exception{	
 		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, viewTokens());
 		return present(userContext,retailStoreMemberGiftCardConsumeRecord, allTokens());
		
 	}
 	protected RetailStoreMemberGiftCardConsumeRecord saveRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreMemberGiftCardConsumeRecordDAO().save(retailStoreMemberGiftCardConsumeRecord, tokens);
 	}
 	protected RetailStoreMemberGiftCardConsumeRecord loadRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreMemberGiftCardConsumeRecordManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreMemberGiftCardConsumeRecordDAO().load(retailStoreMemberGiftCardConsumeRecordId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMemberGiftCardConsumeRecord, tokens);
		
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"@create","createRetailStoreMemberGiftCardConsumeRecord","createRetailStoreMemberGiftCardConsumeRecord/","main","primary");
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"@update","updateRetailStoreMemberGiftCardConsumeRecord","updateRetailStoreMemberGiftCardConsumeRecord/"+retailStoreMemberGiftCardConsumeRecord.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"@copy","cloneRetailStoreMemberGiftCardConsumeRecord","cloneRetailStoreMemberGiftCardConsumeRecord/"+retailStoreMemberGiftCardConsumeRecord.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"retail_store_member_gift_card_consume_record.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMemberGiftCardConsumeRecord.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"retail_store_member_gift_card_consume_record.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreMemberGiftCardConsumeRecord.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext,Date occureTime, String ownerId, String bizOrderId, String number, BigDecimal amount) throws Exception
	{
		
		

		

		userContext.getChecker().checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(occureTime);
		userContext.getChecker().checkNumberOfRetailStoreMemberGiftCardConsumeRecord(number);
		userContext.getChecker().checkAmountOfRetailStoreMemberGiftCardConsumeRecord(amount);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardConsumeRecordManagerException.class);


		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord=createNewRetailStoreMemberGiftCardConsumeRecord();	

		retailStoreMemberGiftCardConsumeRecord.setOccureTime(occureTime);
			
		RetailStoreMemberGiftCard owner = loadRetailStoreMemberGiftCard(userContext, ownerId,emptyOptions());
		retailStoreMemberGiftCardConsumeRecord.setOwner(owner);
		
		
			
		ConsumerOrder bizOrder = loadConsumerOrder(userContext, bizOrderId,emptyOptions());
		retailStoreMemberGiftCardConsumeRecord.setBizOrder(bizOrder);
		
		
		retailStoreMemberGiftCardConsumeRecord.setNumber(number);
		retailStoreMemberGiftCardConsumeRecord.setAmount(amount);

		retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreMemberGiftCardConsumeRecord);
		return retailStoreMemberGiftCardConsumeRecord;

		
	}
	protected RetailStoreMemberGiftCardConsumeRecord createNewRetailStoreMemberGiftCardConsumeRecord() 
	{
		
		return new RetailStoreMemberGiftCardConsumeRecord();		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext,String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		userContext.getChecker().checkVersionOfRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecordVersion);
		

		if(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(parseDate(newValueExpr));
		}		

				

		
		if(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkNumberOfRetailStoreMemberGiftCardConsumeRecord(parseString(newValueExpr));
		}
		if(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfRetailStoreMemberGiftCardConsumeRecord(parseBigDecimal(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardConsumeRecordManagerException.class);
	
		
	}
	
	
	
	public RetailStoreMemberGiftCardConsumeRecord clone(RetailscmUserContext userContext, String fromRetailStoreMemberGiftCardConsumeRecordId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreMemberGiftCardConsumeRecordDAO().clone(fromRetailStoreMemberGiftCardConsumeRecordId, this.allTokens());
	}
	
	public RetailStoreMemberGiftCardConsumeRecord internalSaveRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) throws Exception 
	{
		return internalSaveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, allTokens());

	}
	public RetailStoreMemberGiftCardConsumeRecord internalSaveRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreMemberGiftCardConsumeRecord){ 
			//will be good when the retailStoreMemberGiftCardConsumeRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberGiftCardConsumeRecord.
			
			
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, options);
			return retailStoreMemberGiftCardConsumeRecord;
			
		}

	}
	
	public RetailStoreMemberGiftCardConsumeRecord updateRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext,String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());
		if(retailStoreMemberGiftCardConsumeRecord.getVersion() != retailStoreMemberGiftCardConsumeRecordVersion){
			String message = "The target version("+retailStoreMemberGiftCardConsumeRecord.getVersion()+") is not equals to version("+retailStoreMemberGiftCardConsumeRecordVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMemberGiftCardConsumeRecord){ 
			//will be good when the retailStoreMemberGiftCardConsumeRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberGiftCardConsumeRecord.
			
			retailStoreMemberGiftCardConsumeRecord.changeProperty(property, newValueExpr);
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens().done());
			return present(userContext,retailStoreMemberGiftCardConsumeRecord, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens().done());
		}

	}
	
	public RetailStoreMemberGiftCardConsumeRecord updateRetailStoreMemberGiftCardConsumeRecordProperty(RetailscmUserContext userContext,String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());
		if(retailStoreMemberGiftCardConsumeRecord.getVersion() != retailStoreMemberGiftCardConsumeRecordVersion){
			String message = "The target version("+retailStoreMemberGiftCardConsumeRecord.getVersion()+") is not equals to version("+retailStoreMemberGiftCardConsumeRecordVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMemberGiftCardConsumeRecord){ 
			//will be good when the retailStoreMemberGiftCardConsumeRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberGiftCardConsumeRecord.
			
			retailStoreMemberGiftCardConsumeRecord.changeProperty(property, newValueExpr);
			
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens().done());
			return present(userContext,retailStoreMemberGiftCardConsumeRecord, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreMemberGiftCardConsumeRecordTokens tokens(){
		return RetailStoreMemberGiftCardConsumeRecordTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberGiftCardConsumeRecordTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberGiftCardConsumeRecordTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherOwnerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
 		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(anotherOwnerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardConsumeRecordManagerException.class);
 		
 	}
 	public RetailStoreMemberGiftCardConsumeRecord transferToAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberGiftCardConsumeRecordId,anotherOwnerId);
 
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());	
		synchronized(retailStoreMemberGiftCardConsumeRecord){
			//will be good when the retailStoreMemberGiftCardConsumeRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMemberGiftCard owner = loadRetailStoreMemberGiftCard(userContext, anotherOwnerId, emptyOptions());		
			retailStoreMemberGiftCardConsumeRecord.updateOwner(owner);		
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, emptyOptions());
			
			return present(userContext,retailStoreMemberGiftCardConsumeRecord, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreMemberGiftCard requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreMemberGiftCard result = new CandidateRetailStoreMemberGiftCard();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreMemberGiftCard> candidateList = userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().requestCandidateRetailStoreMemberGiftCardForRetailStoreMemberGiftCardConsumeRecord(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherBizOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
 		userContext.getChecker().checkIdOfConsumerOrder(anotherBizOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardConsumeRecordManagerException.class);
 		
 	}
 	public RetailStoreMemberGiftCardConsumeRecord transferToAnotherBizOrder(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreMemberGiftCardConsumeRecordId,anotherBizOrderId);
 
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());	
		synchronized(retailStoreMemberGiftCardConsumeRecord){
			//will be good when the retailStoreMemberGiftCardConsumeRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(userContext, anotherBizOrderId, emptyOptions());		
			retailStoreMemberGiftCardConsumeRecord.updateBizOrder(bizOrder);		
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, emptyOptions());
			
			return present(userContext,retailStoreMemberGiftCardConsumeRecord, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateConsumerOrder requestCandidateBizOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateConsumerOrder result = new CandidateConsumerOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ConsumerOrder> candidateList = userContext.getDAOGroup().getConsumerOrderDAO().requestCandidateConsumerOrderForRetailStoreMemberGiftCardConsumeRecord(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected ConsumerOrder loadConsumerOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getConsumerOrderDAO().load(newBizOrderId, options);
 	}
 	
 	
 	
	
	 	
 	protected RetailStoreMemberGiftCard loadRetailStoreMemberGiftCard(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().load(newOwnerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion) throws Exception {
		//deleteInternal(userContext, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreMemberGiftCardConsumeRecordDAO().delete(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
	}
	
	public RetailStoreMemberGiftCardConsumeRecord forgetByAll(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);		
	}
	protected RetailStoreMemberGiftCardConsumeRecord forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreMemberGiftCardConsumeRecordDAO().disconnectFromAll(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberGiftCardConsumeRecordManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreMemberGiftCardConsumeRecordDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


