
package com.doublechaintech.retailscm.retailstoremembergiftcard;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;

import com.doublechaintech.retailscm.retailstoremember.CandidateRetailStoreMember;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;






public class RetailStoreMemberGiftCardManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreMemberGiftCardManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreMemberGiftCardTokens.start().withTokenFromListName(listName).done();
		RetailStoreMemberGiftCard  retailStoreMemberGiftCard = (RetailStoreMemberGiftCard) this.loadRetailStoreMemberGiftCard(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreMemberGiftCard.collectRefercencesFromLists();
		retailStoreMemberGiftCardDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreMemberGiftCard, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreMemberGiftCardGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreMemberGiftCard";
	@Override
	public RetailStoreMemberGiftCardDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreMemberGiftCardDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberGiftCardManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard( userContext, retailStoreMemberGiftCardId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberGiftCard, tokens);
 	}
 	
 	
 	 public RetailStoreMemberGiftCard searchRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberGiftCardManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard( userContext, retailStoreMemberGiftCardId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberGiftCard, tokens);
 	}
 	
 	

 	protected RetailStoreMemberGiftCard present(RetailscmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreMemberGiftCard,tokens);
		
		
		RetailStoreMemberGiftCard  retailStoreMemberGiftCardToPresent = retailStoreMemberGiftCardDaoOf(userContext).present(retailStoreMemberGiftCard, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreMemberGiftCardToPresent.collectRefercencesFromLists();
		retailStoreMemberGiftCardDaoOf(userContext).alias(entityListToNaming);
		
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
 		return retailStoreMemberGiftCardDaoOf(userContext).save(retailStoreMemberGiftCard, tokens);
 	}
 	protected RetailStoreMemberGiftCard loadRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberGiftCardManagerException.class);

 
 		return retailStoreMemberGiftCardDaoOf(userContext).load(retailStoreMemberGiftCardId, tokens);
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
	
 	
 	
 
 	
 	

	public RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(RetailscmUserContext userContext, String name,String ownerId,String number,BigDecimal remain) throws Exception
	//public RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(RetailscmUserContext userContext,String name, String ownerId, String number, BigDecimal remain) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfRetailStoreMemberGiftCard(name);
		checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCard(number);
		checkerOf(userContext).checkRemainOfRetailStoreMemberGiftCard(remain);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCard( retailStoreMemberGiftCardVersion);
		

		if(RetailStoreMemberGiftCard.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreMemberGiftCard(parseString(newValueExpr));
		
			
		}		

		
		if(RetailStoreMemberGiftCard.NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCard(parseString(newValueExpr));
		
			
		}
		if(RetailStoreMemberGiftCard.REMAIN_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkRemainOfRetailStoreMemberGiftCard(parseBigDecimal(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);


	}



	public RetailStoreMemberGiftCard clone(RetailscmUserContext userContext, String fromRetailStoreMemberGiftCardId) throws Exception{

		return retailStoreMemberGiftCardDaoOf(userContext).clone(fromRetailStoreMemberGiftCardId, this.allTokens());
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
			if (retailStoreMemberGiftCard.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberGiftCardTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String anotherOwnerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
 		checkerOf(userContext).checkIdOfRetailStoreMember(anotherOwnerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);

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
		SmartList<RetailStoreMember> candidateList = retailStoreMemberDaoOf(userContext).requestCandidateRetailStoreMemberForRetailStoreMemberGiftCard(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreMember loadRetailStoreMember(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreMemberDaoOf(userContext).load(newOwnerId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion) throws Exception {
		//deleteInternal(userContext, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion) throws Exception{

		retailStoreMemberGiftCardDaoOf(userContext).delete(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
	}

	public RetailStoreMemberGiftCard forgetByAll(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
	}
	protected RetailStoreMemberGiftCard forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion) throws Exception{

		return retailStoreMemberGiftCardDaoOf(userContext).disconnectFromAll(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
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
		return retailStoreMemberGiftCardDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreMemberGiftCard with biz_order in RetailStoreMemberGiftCardConsumeRecord
	protected RetailStoreMemberGiftCard breakWithRetailStoreMemberGiftCardConsumeRecordByBizOrder(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String bizOrderId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());

			synchronized(retailStoreMemberGiftCard){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreMemberGiftCardDaoOf(userContext).planToRemoveRetailStoreMemberGiftCardConsumeRecordListWithBizOrder(retailStoreMemberGiftCard, bizOrderId, this.emptyOptions());

				retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
				return retailStoreMemberGiftCard;
			}
	}






	protected void checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, Date occureTime, String bizOrderId, String number, BigDecimal amount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);

		
		checkerOf(userContext).checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(occureTime);
		
		checkerOf(userContext).checkBizOrderIdOfRetailStoreMemberGiftCardConsumeRecord(bizOrderId);
		
		checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCardConsumeRecord(number);
		
		checkerOf(userContext).checkAmountOfRetailStoreMemberGiftCardConsumeRecord(amount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);


	}
	public  RetailStoreMemberGiftCard addRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardId, Date occureTime, String bizOrderId, String number, BigDecimal amount, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(userContext,retailStoreMemberGiftCardId,occureTime, bizOrderId, number, amount,tokensExpr);

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createRetailStoreMemberGiftCardConsumeRecord(userContext,occureTime, bizOrderId, number, amount);

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, emptyOptions());
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

		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(id);

		checkerOf(userContext).checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord( occureTime);
		checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCardConsumeRecord( number);
		checkerOf(userContext).checkAmountOfRetailStoreMemberGiftCardConsumeRecord( amount);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);

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

		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		for(String retailStoreMemberGiftCardConsumeRecordIdItem: retailStoreMemberGiftCardConsumeRecordIds){
			checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);

	}
	public  RetailStoreMemberGiftCard removeRetailStoreMemberGiftCardConsumeRecordList(RetailscmUserContext userContext, String retailStoreMemberGiftCardId,
			String retailStoreMemberGiftCardConsumeRecordIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecordList(userContext, retailStoreMemberGiftCardId,  retailStoreMemberGiftCardConsumeRecordIds, tokensExpr);


			RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
			synchronized(retailStoreMemberGiftCard){
				//Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberGiftCardDaoOf(userContext).planToRemoveRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCard, retailStoreMemberGiftCardConsumeRecordIds, allTokens());
				retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
				deleteRelationListInGraph(userContext, retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList());
				return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardId,
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard( retailStoreMemberGiftCardId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);

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
		
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard( retailStoreMemberGiftCardId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordVersion);
		

		if(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(parseDate(newValueExpr));
		
		}
		
		if(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCardConsumeRecord(parseString(newValueExpr));
		
		}
		
		if(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfRetailStoreMemberGiftCardConsumeRecord(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardManagerException.class);

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

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   RetailStoreMemberGiftCard newRetailStoreMemberGiftCard = this.createRetailStoreMemberGiftCard(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreMemberGiftCard
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreMemberGiftCard.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreMemberGiftCard> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreMember> ownerList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreMember.class);
		userContext.getDAOGroup().enhanceList(ownerList, RetailStoreMember.class);


    }
	
	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception {
		return listPageByOwner(userContext, ownerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception {
		SmartList<RetailStoreMemberGiftCard> list = retailStoreMemberGiftCardDaoOf(userContext).findRetailStoreMemberGiftCardByOwner(ownerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStoreMemberGiftCard.class);
		page.setContainerObject(RetailStoreMember.withId(ownerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("零售店会员礼品卡列表");
		page.setRequestName("listByOwner");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByOwner/%s/",  getBeanName(), ownerId)));

		page.assemblerContent(userContext, "listByOwner");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreMemberGiftCardId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getRetailStoreMemberGiftCardDetailScope().clone();
		RetailStoreMemberGiftCard merchantObj = (RetailStoreMemberGiftCard) this.view(userContext, retailStoreMemberGiftCardId);
    String merchantObjId = retailStoreMemberGiftCardId;
    String linkToUrl =	"retailStoreMemberGiftCardManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "零售店会员礼品卡"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-owner")
				    .put("fieldName", "owner")
				    .put("label", "业主")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreMemberManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"mobile_phone\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("owner", merchantObj.getOwner());

		propList.add(
				MapUtil.put("id", "4-number")
				    .put("fieldName", "number")
				    .put("label", "数")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("number", merchantObj.getNumber());

		propList.add(
				MapUtil.put("id", "5-remain")
				    .put("fieldName", "remain")
				    .put("label", "保持")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("remain", merchantObj.getRemain());

		//处理 sectionList

		//处理Section：retailStoreMemberGiftCardConsumeRecordListSection
		Map retailStoreMemberGiftCardConsumeRecordListSection = ListofUtils.buildSection(
		    "retailStoreMemberGiftCardConsumeRecordListSection",
		    "零售会员礼品卡消费记录列表",
		    null,
		    "",
		    "__no_group",
		    "retailStoreMemberGiftCardConsumeRecordManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreMemberGiftCardConsumeRecordListSection);

		result.put("retailStoreMemberGiftCardConsumeRecordListSection", ListofUtils.toShortList(merchantObj.getRetailStoreMemberGiftCardConsumeRecordList(), "retailStoreMemberGiftCardConsumeRecord"));
		vscope.field("retailStoreMemberGiftCardConsumeRecordListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( RetailStoreMemberGiftCardConsumeRecord.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

}


