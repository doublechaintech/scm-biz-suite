
package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;

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

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.retailstoreorder.CandidateRetailStoreOrder;







public class RetailStoreOrderPaymentGroupManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderPaymentGroupManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderPaymentGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderPaymentGroupManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderPaymentGroupManagerException(message);

	}
	
	

 	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderPaymentGroupDAO().save(retailStoreOrderPaymentGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens);
 	}
 	
 	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroupDetail(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup) throws Exception{	

 		
 		return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, allTokens());
 	}
 	
 	public RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderPaymentGroupManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderPaymentGroup, tokens);
 	}
 	
 	
 	 public RetailStoreOrderPaymentGroup searchRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderPaymentGroupManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderPaymentGroup, tokens);
 	}
 	
 	

 	protected RetailStoreOrderPaymentGroup present(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderPaymentGroup,tokens);
		
		
		RetailStoreOrderPaymentGroup  retailStoreOrderPaymentGroupToPresent = userContext.getDAOGroup().getRetailStoreOrderPaymentGroupDAO().present(retailStoreOrderPaymentGroup, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderPaymentGroupToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreOrderPaymentGroupDAO().alias(entityListToNaming);
		
		return  retailStoreOrderPaymentGroupToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroupDetail(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId) throws Exception{	
 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, allTokens());
 		return present(userContext,retailStoreOrderPaymentGroup, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId) throws Exception{	
 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, viewTokens());
 		return present(userContext,retailStoreOrderPaymentGroup, allTokens());
		
 	}
 	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreOrderPaymentGroupDAO().save(retailStoreOrderPaymentGroup, tokens);
 	}
 	protected RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderPaymentGroupManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreOrderPaymentGroupDAO().load(retailStoreOrderPaymentGroupId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderPaymentGroup, tokens);
		
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"@create","createRetailStoreOrderPaymentGroup","createRetailStoreOrderPaymentGroup/","main","primary");
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"@update","updateRetailStoreOrderPaymentGroup","updateRetailStoreOrderPaymentGroup/"+retailStoreOrderPaymentGroup.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"@copy","cloneRetailStoreOrderPaymentGroup","cloneRetailStoreOrderPaymentGroup/"+retailStoreOrderPaymentGroup.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"retail_store_order_payment_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreOrderPaymentGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(RetailscmUserContext userContext,String name, String bizOrderId, String cardNumber) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfRetailStoreOrderPaymentGroup(name);
		userContext.getChecker().checkCardNumberOfRetailStoreOrderPaymentGroup(cardNumber);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderPaymentGroupManagerException.class);


		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup=createNewRetailStoreOrderPaymentGroup();	

		retailStoreOrderPaymentGroup.setName(name);
			
		RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, bizOrderId,emptyOptions());
		retailStoreOrderPaymentGroup.setBizOrder(bizOrder);
		
		
		retailStoreOrderPaymentGroup.setCardNumber(cardNumber);

		retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderPaymentGroup);
		return retailStoreOrderPaymentGroup;

		
	}
	protected RetailStoreOrderPaymentGroup createNewRetailStoreOrderPaymentGroup() 
	{
		
		return new RetailStoreOrderPaymentGroup();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderPaymentGroup(RetailscmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		userContext.getChecker().checkVersionOfRetailStoreOrderPaymentGroup( retailStoreOrderPaymentGroupVersion);
		

		if(RetailStoreOrderPaymentGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStoreOrderPaymentGroup(parseString(newValueExpr));
		}		

		
		if(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkCardNumberOfRetailStoreOrderPaymentGroup(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderPaymentGroupManagerException.class);
	
		
	}
	
	
	
	public RetailStoreOrderPaymentGroup clone(RetailscmUserContext userContext, String fromRetailStoreOrderPaymentGroupId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreOrderPaymentGroupDAO().clone(fromRetailStoreOrderPaymentGroupId, this.allTokens());
	}
	
	public RetailStoreOrderPaymentGroup internalSaveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup) throws Exception 
	{
		return internalSaveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, allTokens());

	}
	public RetailStoreOrderPaymentGroup internalSaveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreOrderPaymentGroup){ 
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPaymentGroup.
			
			
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, options);
			return retailStoreOrderPaymentGroup;
			
		}

	}
	
	public RetailStoreOrderPaymentGroup updateRetailStoreOrderPaymentGroup(RetailscmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, allTokens());
		if(retailStoreOrderPaymentGroup.getVersion() != retailStoreOrderPaymentGroupVersion){
			String message = "The target version("+retailStoreOrderPaymentGroup.getVersion()+") is not equals to version("+retailStoreOrderPaymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderPaymentGroup){ 
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPaymentGroup.
			
			retailStoreOrderPaymentGroup.changeProperty(property, newValueExpr);
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
			return present(userContext,retailStoreOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
		}

	}
	
	public RetailStoreOrderPaymentGroup updateRetailStoreOrderPaymentGroupProperty(RetailscmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, allTokens());
		if(retailStoreOrderPaymentGroup.getVersion() != retailStoreOrderPaymentGroupVersion){
			String message = "The target version("+retailStoreOrderPaymentGroup.getVersion()+") is not equals to version("+retailStoreOrderPaymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderPaymentGroup){ 
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPaymentGroup.
			
			retailStoreOrderPaymentGroup.changeProperty(property, newValueExpr);
			
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
			return present(userContext,retailStoreOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderPaymentGroupTokens tokens(){
		return RetailStoreOrderPaymentGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderPaymentGroupTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderPaymentGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
 		userContext.getChecker().checkIdOfRetailStoreOrder(anotherBizOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderPaymentGroupManagerException.class);
 		
 	}
 	public RetailStoreOrderPaymentGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreOrderPaymentGroupId,anotherBizOrderId);
 
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, allTokens());	
		synchronized(retailStoreOrderPaymentGroup){
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, anotherBizOrderId, emptyOptions());		
			retailStoreOrderPaymentGroup.updateBizOrder(bizOrder);		
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, emptyOptions());
			
			return present(userContext,retailStoreOrderPaymentGroup, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreOrder requestCandidateBizOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOrder result = new CandidateRetailStoreOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("buyer");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOrder> candidateList = userContext.getDAOGroup().getRetailStoreOrderDAO().requestCandidateRetailStoreOrderForRetailStoreOrderPaymentGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreOrder loadRetailStoreOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreOrderDAO().load(newBizOrderId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreOrderPaymentGroupDAO().delete(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
	}
	
	public RetailStoreOrderPaymentGroup forgetByAll(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);		
	}
	protected RetailStoreOrderPaymentGroup forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreOrderPaymentGroupDAO().disconnectFromAll(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderPaymentGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreOrderPaymentGroupDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


