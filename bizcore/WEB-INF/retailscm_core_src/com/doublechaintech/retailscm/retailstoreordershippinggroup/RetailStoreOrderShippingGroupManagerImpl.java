
package com.doublechaintech.retailscm.retailstoreordershippinggroup;

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







public class RetailStoreOrderShippingGroupManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderShippingGroupManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOrderShippingGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderShippingGroupManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderShippingGroupManagerException(message);

	}
	
	

 	protected RetailStoreOrderShippingGroup saveRetailStoreOrderShippingGroup(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOrderShippingGroupDAO().save(retailStoreOrderShippingGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens);
 	}
 	
 	protected RetailStoreOrderShippingGroup saveRetailStoreOrderShippingGroupDetail(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) throws Exception{	

 		
 		return saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, allTokens());
 	}
 	
 	public RetailStoreOrderShippingGroup loadRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderShippingGroupManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderShippingGroup, tokens);
 	}
 	
 	
 	 public RetailStoreOrderShippingGroup searchRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderShippingGroupManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderShippingGroup, tokens);
 	}
 	
 	

 	protected RetailStoreOrderShippingGroup present(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOrderShippingGroup,tokens);
		
		
		RetailStoreOrderShippingGroup  retailStoreOrderShippingGroupToPresent = userContext.getDAOGroup().getRetailStoreOrderShippingGroupDAO().present(retailStoreOrderShippingGroup, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOrderShippingGroupToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreOrderShippingGroupDAO().alias(entityListToNaming);
		
		return  retailStoreOrderShippingGroupToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOrderShippingGroup loadRetailStoreOrderShippingGroupDetail(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId) throws Exception{	
 		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, allTokens());
 		return present(userContext,retailStoreOrderShippingGroup, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId) throws Exception{	
 		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, viewTokens());
 		return present(userContext,retailStoreOrderShippingGroup, allTokens());
		
 	}
 	protected RetailStoreOrderShippingGroup saveRetailStoreOrderShippingGroup(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreOrderShippingGroupDAO().save(retailStoreOrderShippingGroup, tokens);
 	}
 	protected RetailStoreOrderShippingGroup loadRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOrderShippingGroupManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreOrderShippingGroupDAO().load(retailStoreOrderShippingGroupId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderShippingGroup, tokens);
		
		addAction(userContext, retailStoreOrderShippingGroup, tokens,"@create","createRetailStoreOrderShippingGroup","createRetailStoreOrderShippingGroup/","main","primary");
		addAction(userContext, retailStoreOrderShippingGroup, tokens,"@update","updateRetailStoreOrderShippingGroup","updateRetailStoreOrderShippingGroup/"+retailStoreOrderShippingGroup.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderShippingGroup, tokens,"@copy","cloneRetailStoreOrderShippingGroup","cloneRetailStoreOrderShippingGroup/"+retailStoreOrderShippingGroup.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOrderShippingGroup, tokens,"retail_store_order_shipping_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreOrderShippingGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOrderShippingGroup createRetailStoreOrderShippingGroup(RetailscmUserContext userContext,String name, String bizOrderId, BigDecimal amount) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfRetailStoreOrderShippingGroup(name);
		userContext.getChecker().checkAmountOfRetailStoreOrderShippingGroup(amount);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderShippingGroupManagerException.class);


		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup=createNewRetailStoreOrderShippingGroup();	

		retailStoreOrderShippingGroup.setName(name);
			
		RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, bizOrderId,emptyOptions());
		retailStoreOrderShippingGroup.setBizOrder(bizOrder);
		
		
		retailStoreOrderShippingGroup.setAmount(amount);

		retailStoreOrderShippingGroup = saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderShippingGroup);
		return retailStoreOrderShippingGroup;

		
	}
	protected RetailStoreOrderShippingGroup createNewRetailStoreOrderShippingGroup() 
	{
		
		return new RetailStoreOrderShippingGroup();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrderShippingGroup(RetailscmUserContext userContext,String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);
		userContext.getChecker().checkVersionOfRetailStoreOrderShippingGroup( retailStoreOrderShippingGroupVersion);
		

		if(RetailStoreOrderShippingGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStoreOrderShippingGroup(parseString(newValueExpr));
		}		

		
		if(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfRetailStoreOrderShippingGroup(parseBigDecimal(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderShippingGroupManagerException.class);
	
		
	}
	
	
	
	public RetailStoreOrderShippingGroup clone(RetailscmUserContext userContext, String fromRetailStoreOrderShippingGroupId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreOrderShippingGroupDAO().clone(fromRetailStoreOrderShippingGroupId, this.allTokens());
	}
	
	public RetailStoreOrderShippingGroup internalSaveRetailStoreOrderShippingGroup(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) throws Exception 
	{
		return internalSaveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, allTokens());

	}
	public RetailStoreOrderShippingGroup internalSaveRetailStoreOrderShippingGroup(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreOrderShippingGroup){ 
			//will be good when the retailStoreOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderShippingGroup.
			
			
			retailStoreOrderShippingGroup = saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, options);
			return retailStoreOrderShippingGroup;
			
		}

	}
	
	public RetailStoreOrderShippingGroup updateRetailStoreOrderShippingGroup(RetailscmUserContext userContext,String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, allTokens());
		if(retailStoreOrderShippingGroup.getVersion() != retailStoreOrderShippingGroupVersion){
			String message = "The target version("+retailStoreOrderShippingGroup.getVersion()+") is not equals to version("+retailStoreOrderShippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderShippingGroup){ 
			//will be good when the retailStoreOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderShippingGroup.
			
			retailStoreOrderShippingGroup.changeProperty(property, newValueExpr);
			retailStoreOrderShippingGroup = saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens().done());
			return present(userContext,retailStoreOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens().done());
		}

	}
	
	public RetailStoreOrderShippingGroup updateRetailStoreOrderShippingGroupProperty(RetailscmUserContext userContext,String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, allTokens());
		if(retailStoreOrderShippingGroup.getVersion() != retailStoreOrderShippingGroupVersion){
			String message = "The target version("+retailStoreOrderShippingGroup.getVersion()+") is not equals to version("+retailStoreOrderShippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderShippingGroup){ 
			//will be good when the retailStoreOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderShippingGroup.
			
			retailStoreOrderShippingGroup.changeProperty(property, newValueExpr);
			
			retailStoreOrderShippingGroup = saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens().done());
			return present(userContext,retailStoreOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOrderShippingGroupTokens tokens(){
		return RetailStoreOrderShippingGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderShippingGroupTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOrderShippingGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);
 		userContext.getChecker().checkIdOfRetailStoreOrder(anotherBizOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOrderShippingGroupManagerException.class);
 		
 	}
 	public RetailStoreOrderShippingGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreOrderShippingGroupId,anotherBizOrderId);
 
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, allTokens());	
		synchronized(retailStoreOrderShippingGroup){
			//will be good when the retailStoreOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, anotherBizOrderId, emptyOptions());		
			retailStoreOrderShippingGroup.updateBizOrder(bizOrder);		
			retailStoreOrderShippingGroup = saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, emptyOptions());
			
			return present(userContext,retailStoreOrderShippingGroup, allTokens());
			
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
		SmartList<RetailStoreOrder> candidateList = userContext.getDAOGroup().getRetailStoreOrderDAO().requestCandidateRetailStoreOrderForRetailStoreOrderShippingGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreOrderShippingGroupDAO().delete(retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
	}
	
	public RetailStoreOrderShippingGroup forgetByAll(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);		
	}
	protected RetailStoreOrderShippingGroup forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreOrderShippingGroupDAO().disconnectFromAll(retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderShippingGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreOrderShippingGroupDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderShippingGroup newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


