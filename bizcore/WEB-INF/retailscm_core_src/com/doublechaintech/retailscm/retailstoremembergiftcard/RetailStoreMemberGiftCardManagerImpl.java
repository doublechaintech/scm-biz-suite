
package com.doublechaintech.retailscm.retailstoremembergiftcard;

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

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;

import com.doublechaintech.retailscm.retailstoremember.CandidateRetailStoreMember;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;






public class RetailStoreMemberGiftCardManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreMemberGiftCardManager {
	
	private static final String SERVICE_TYPE = "RetailStoreMemberGiftCard";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreMemberGiftCardManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreMemberGiftCardManagerException(message);

	}
	
	

 	protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCard(RetailscmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreMemberGiftCardDAO().save(retailStoreMemberGiftCard, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens);
 	}
 	
 	protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCardDetail(RetailscmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard) throws Exception{	

 		
 		return saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, allTokens());
 	}
 	
 	public RetailStoreMemberGiftCard loadRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreMemberGiftCardManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard( userContext, retailStoreMemberGiftCardId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberGiftCard, tokens);
 	}
 	
 	
 	 public RetailStoreMemberGiftCard searchRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreMemberGiftCardManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard( userContext, retailStoreMemberGiftCardId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberGiftCard, tokens);
 	}
 	
 	

 	protected RetailStoreMemberGiftCard present(RetailscmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreMemberGiftCard,tokens);
		
		
		RetailStoreMemberGiftCard  retailStoreMemberGiftCardToPresent = userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().present(retailStoreMemberGiftCard, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreMemberGiftCardToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().alias(entityListToNaming);
		
		return  retailStoreMemberGiftCardToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreMemberGiftCard loadRetailStoreMemberGiftCardDetail(RetailscmUserContext userContext, String retailStoreMemberGiftCardId) throws Exception{	
 		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard( userContext, retailStoreMemberGiftCardId, allTokens());
 		return present(userContext,retailStoreMemberGiftCard, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreMemberGiftCardId) throws Exception{	
 		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard( userContext, retailStoreMemberGiftCardId, viewTokens());
 		return present(userContext,retailStoreMemberGiftCard, allTokens());
		
 	}
 	protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCard(RetailscmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().save(retailStoreMemberGiftCard, tokens);
 	}
 	protected RetailStoreMemberGiftCard loadRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreMemberGiftCardManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().load(retailStoreMemberGiftCardId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMemberGiftCard, tokens);
		
		addAction(userContext, retailStoreMemberGiftCard, tokens,"@create","createRetailStoreMemberGiftCard","createRetailStoreMemberGiftCard/","main","primary");
		addAction(userContext, retailStoreMemberGiftCard, tokens,"@update","updateRetailStoreMemberGiftCard","updateRetailStoreMemberGiftCard/"+retailStoreMemberGiftCard.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberGiftCard, tokens,"@copy","cloneRetailStoreMemberGiftCard","cloneRetailStoreMemberGiftCard/"+retailStoreMemberGiftCard.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreMemberGiftCard, tokens,"retail_store_member_gift_card.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMemberGiftCard.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberGiftCard, tokens,"retail_store_member_gift_card.addRetailStoreMemberGiftCardConsumeRecord","addRetailStoreMemberGiftCardConsumeRecord","addRetailStoreMemberGiftCardConsumeRecord/"+retailStoreMemberGiftCard.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
		addAction(userContext, retailStoreMemberGiftCard, tokens,"retail_store_member_gift_card.removeRetailStoreMemberGiftCardConsumeRecord","removeRetailStoreMemberGiftCardConsumeRecord","removeRetailStoreMemberGiftCardConsumeRecord/"+retailStoreMemberGiftCard.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
		addAction(userContext, retailStoreMemberGiftCard, tokens,"retail_store_member_gift_card.updateRetailStoreMemberGiftCardConsumeRecord","updateRetailStoreMemberGiftCardConsumeRecord","updateRetailStoreMemberGiftCardConsumeRecord/"+retailStoreMemberGiftCard.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
		addAction(userContext, retailStoreMemberGiftCard, tokens,"retail_store_member_gift_card.copyRetailStoreMemberGiftCardConsumeRecordFrom","copyRetailStoreMemberGiftCardConsumeRecordFrom","copyRetailStoreMemberGiftCardConsumeRecordFrom/"+retailStoreMemberGiftCard.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(RetailscmUserContext userContext,String name, String ownerId, String number, BigDecimal remain) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfRetailStoreMemberGiftCard(name);
		userContext.getChecker().checkNumberOfRetailStoreMemberGiftCard(number);
		userContext.getChecker().checkRemainOfRetailStoreMemberGiftCard(remain);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);


		RetailStoreMemberGiftCard retailStoreMemberGiftCard=createNewRetailStoreMemberGiftCard();	

		retailStoreMemberGiftCard.setName(name);
			
		RetailStoreMember owner = loadRetailStoreMember(userContext, ownerId,emptyOptions());
		retailStoreMemberGiftCard.setOwner(owner);
		
		
		retailStoreMemberGiftCard.setNumber(number);
		retailStoreMemberGiftCard.setRemain(remain);

		retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreMemberGiftCard);
		return retailStoreMemberGiftCard;

		
	}
	protected RetailStoreMemberGiftCard createNewRetailStoreMemberGiftCard() 
	{
		
		return new RetailStoreMemberGiftCard();		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberGiftCard(RetailscmUserContext userContext,String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		userContext.getChecker().checkVersionOfRetailStoreMemberGiftCard( retailStoreMemberGiftCardVersion);
		

		if(RetailStoreMemberGiftCard.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStoreMemberGiftCard(parseString(newValueExpr));
		}		

		
		if(RetailStoreMemberGiftCard.NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkNumberOfRetailStoreMemberGiftCard(parseString(newValueExpr));
		}
		if(RetailStoreMemberGiftCard.REMAIN_PROPERTY.equals(property)){
			userContext.getChecker().checkRemainOfRetailStoreMemberGiftCard(parseBigDecimal(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
	
		
	}
	
	
	
	public RetailStoreMemberGiftCard clone(RetailscmUserContext userContext, String fromRetailStoreMemberGiftCardId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().clone(fromRetailStoreMemberGiftCardId, this.allTokens());
	}
	
	public RetailStoreMemberGiftCard internalSaveRetailStoreMemberGiftCard(RetailscmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard) throws Exception 
	{
		return internalSaveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, allTokens());

	}
	public RetailStoreMemberGiftCard internalSaveRetailStoreMemberGiftCard(RetailscmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreMemberGiftCard){ 
			//will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberGiftCard.
			
			
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, options);
			return retailStoreMemberGiftCard;
			
		}

	}
	
	public RetailStoreMemberGiftCard updateRetailStoreMemberGiftCard(RetailscmUserContext userContext,String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
		if(retailStoreMemberGiftCard.getVersion() != retailStoreMemberGiftCardVersion){
			String message = "The target version("+retailStoreMemberGiftCard.getVersion()+") is not equals to version("+retailStoreMemberGiftCardVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMemberGiftCard){ 
			//will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberGiftCard.
			
			retailStoreMemberGiftCard.changeProperty(property, newValueExpr);
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().done());
			return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().done());
		}

	}
	
	public RetailStoreMemberGiftCard updateRetailStoreMemberGiftCardProperty(RetailscmUserContext userContext,String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
		if(retailStoreMemberGiftCard.getVersion() != retailStoreMemberGiftCardVersion){
			String message = "The target version("+retailStoreMemberGiftCard.getVersion()+") is not equals to version("+retailStoreMemberGiftCardVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMemberGiftCard){ 
			//will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberGiftCard.
			
			retailStoreMemberGiftCard.changeProperty(property, newValueExpr);
			
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().done());
			return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreMemberGiftCardTokens tokens(){
		return RetailStoreMemberGiftCardTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberGiftCardTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreMemberGiftCardConsumeRecordListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberGiftCardTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String anotherOwnerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
 		userContext.getChecker().checkIdOfRetailStoreMember(anotherOwnerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
 		
 	}
 	public RetailStoreMemberGiftCard transferToAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberGiftCardId,anotherOwnerId);
 
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());	
		synchronized(retailStoreMemberGiftCard){
			//will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember owner = loadRetailStoreMember(userContext, anotherOwnerId, emptyOptions());		
			retailStoreMemberGiftCard.updateOwner(owner);		
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, emptyOptions());
			
			return present(userContext,retailStoreMemberGiftCard, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreMember requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreMember result = new CandidateRetailStoreMember();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreMember> candidateList = userContext.getDAOGroup().getRetailStoreMemberDAO().requestCandidateRetailStoreMemberForRetailStoreMemberGiftCard(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreMember loadRetailStoreMember(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreMemberDAO().load(newOwnerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion) throws Exception {
		//deleteInternal(userContext, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().delete(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
	}
	
	public RetailStoreMemberGiftCard forgetByAll(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);		
	}
	protected RetailStoreMemberGiftCard forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().disconnectFromAll(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberGiftCardManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().deleteAll();
	}


	//disconnect RetailStoreMemberGiftCard with biz_order in RetailStoreMemberGiftCardConsumeRecord
	protected RetailStoreMemberGiftCard breakWithRetailStoreMemberGiftCardConsumeRecordByBizOrder(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());

			synchronized(retailStoreMemberGiftCard){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().planToRemoveRetailStoreMemberGiftCardConsumeRecordListWithBizOrder(retailStoreMemberGiftCard, bizOrderId, this.emptyOptions());

				retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
				return retailStoreMemberGiftCard;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, Date occureTime, String bizOrderId, String number, BigDecimal amount,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);

		
		userContext.getChecker().checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(occureTime);
		
		userContext.getChecker().checkBizOrderIdOfRetailStoreMemberGiftCardConsumeRecord(bizOrderId);
		
		userContext.getChecker().checkNumberOfRetailStoreMemberGiftCardConsumeRecord(number);
		
		userContext.getChecker().checkAmountOfRetailStoreMemberGiftCardConsumeRecord(amount);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);

	
	}
	public  RetailStoreMemberGiftCard addRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, Date occureTime, String bizOrderId, String number, BigDecimal amount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(userContext,retailStoreMemberGiftCardId,occureTime, bizOrderId, number, amount,tokensExpr);
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createRetailStoreMemberGiftCardConsumeRecord(userContext,occureTime, bizOrderId, number, amount);
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
		synchronized(retailStoreMemberGiftCard){ 
			//Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMemberGiftCard.addRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecord );		
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberGiftCardConsumeRecordManager().onNewInstanceCreated(userContext, retailStoreMemberGiftCardConsumeRecord);
			return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecordProperties(RetailscmUserContext userContext, String retailStoreMemberGiftCardId,String id,Date occureTime,String number,BigDecimal amount,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCardConsumeRecord(id);
		
		userContext.getChecker().checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord( occureTime);
		userContext.getChecker().checkNumberOfRetailStoreMemberGiftCardConsumeRecord( number);
		userContext.getChecker().checkAmountOfRetailStoreMemberGiftCardConsumeRecord( amount);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
		
	}
	public  RetailStoreMemberGiftCard updateRetailStoreMemberGiftCardConsumeRecordProperties(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String id,Date occureTime,String number,BigDecimal amount, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecordProperties(userContext,retailStoreMemberGiftCardId,id,occureTime,number,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreMemberGiftCardConsumeRecordListList()
				.searchRetailStoreMemberGiftCardConsumeRecordListWith(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY, "is", id).done();
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCardToUpdate = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, options);
		
		if(retailStoreMemberGiftCardToUpdate.getRetailStoreMemberGiftCardConsumeRecordList().isEmpty()){
			throw new RetailStoreMemberGiftCardManagerException("RetailStoreMemberGiftCardConsumeRecord is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreMemberGiftCardConsumeRecord item = retailStoreMemberGiftCardToUpdate.getRetailStoreMemberGiftCardConsumeRecordList().first();
		
		item.updateOccureTime( occureTime );
		item.updateNumber( number );
		item.updateAmount( amount );

		
		//checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(userContext,retailStoreMemberGiftCardId,name, code, used,tokensExpr);
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardToUpdate, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
		synchronized(retailStoreMemberGiftCard){ 
			return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, Date occureTime, String bizOrderId, String number, BigDecimal amount) throws Exception{

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		
		
		retailStoreMemberGiftCardConsumeRecord.setOccureTime(occureTime);		
		ConsumerOrder  bizOrder = new ConsumerOrder();
		bizOrder.setId(bizOrderId);		
		retailStoreMemberGiftCardConsumeRecord.setBizOrder(bizOrder);		
		retailStoreMemberGiftCardConsumeRecord.setNumber(number);		
		retailStoreMemberGiftCardConsumeRecord.setAmount(amount);
	
		
		return retailStoreMemberGiftCardConsumeRecord;
	
		
	}
	
	protected RetailStoreMemberGiftCardConsumeRecord createIndexedRetailStoreMemberGiftCardConsumeRecord(String id, int version){

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		retailStoreMemberGiftCardConsumeRecord.setId(id);
		retailStoreMemberGiftCardConsumeRecord.setVersion(version);
		return retailStoreMemberGiftCardConsumeRecord;			
		
	}
	
	protected void checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecordList(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, 
			String retailStoreMemberGiftCardConsumeRecordIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		for(String retailStoreMemberGiftCardConsumeRecordId: retailStoreMemberGiftCardConsumeRecordIds){
			userContext.getChecker().checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
		
	}
	public  RetailStoreMemberGiftCard removeRetailStoreMemberGiftCardConsumeRecordList(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, 
			String retailStoreMemberGiftCardConsumeRecordIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecordList(userContext, retailStoreMemberGiftCardId,  retailStoreMemberGiftCardConsumeRecordIds, tokensExpr);
			
			
			RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
			synchronized(retailStoreMemberGiftCard){ 
				//Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().planToRemoveRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCard, retailStoreMemberGiftCardConsumeRecordIds, allTokens());
				retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
				deleteRelationListInGraph(userContext, retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList());
				return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, 
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard( retailStoreMemberGiftCardId);
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		userContext.getChecker().checkVersionOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
	
	}
	public  RetailStoreMemberGiftCard removeRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, 
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(userContext,retailStoreMemberGiftCardId, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion,tokensExpr);
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createIndexedRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
		synchronized(retailStoreMemberGiftCard){ 
			//Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMemberGiftCard.removeRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecord );		
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			deleteRelationInGraph(userContext, retailStoreMemberGiftCardConsumeRecord);
			return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, 
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard( retailStoreMemberGiftCardId);
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		userContext.getChecker().checkVersionOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
	
	}
	public  RetailStoreMemberGiftCard copyRetailStoreMemberGiftCardConsumeRecordFrom(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, 
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreMemberGiftCardConsumeRecord(userContext,retailStoreMemberGiftCardId, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion,tokensExpr);
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createIndexedRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
		synchronized(retailStoreMemberGiftCard){ 
			//Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStoreMemberGiftCard.copyRetailStoreMemberGiftCardConsumeRecordFrom( retailStoreMemberGiftCardConsumeRecord );		
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberGiftCardConsumeRecordManager().onNewInstanceCreated(userContext, (RetailStoreMemberGiftCardConsumeRecord)retailStoreMemberGiftCard.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		userContext.getChecker().checkVersionOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordVersion);
		

		if(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(parseDate(newValueExpr));
		}
		
		if(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkNumberOfRetailStoreMemberGiftCardConsumeRecord(parseString(newValueExpr));
		}
		
		if(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfRetailStoreMemberGiftCardConsumeRecord(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);
	
	}
	
	public  RetailStoreMemberGiftCard updateRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardId, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreMemberGiftCardConsumeRecordList().searchRetailStoreMemberGiftCardConsumeRecordListWith(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY, "eq", retailStoreMemberGiftCardConsumeRecordId).done();
		
		
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, loadTokens);
		
		synchronized(retailStoreMemberGiftCard){ 
			//Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMemberGiftCard.removeRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecord );	
			//make changes to AcceleraterAccount.
			RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordIndex = createIndexedRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
		
			RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = retailStoreMemberGiftCard.findTheRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordIndex);
			if(retailStoreMemberGiftCardConsumeRecord == null){
				throw new RetailStoreMemberGiftCardManagerException(retailStoreMemberGiftCardConsumeRecord+" is NOT FOUND" );
			}
			
			retailStoreMemberGiftCardConsumeRecord.changeProperty(property, newValueExpr);
			
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreMemberGiftCard newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


