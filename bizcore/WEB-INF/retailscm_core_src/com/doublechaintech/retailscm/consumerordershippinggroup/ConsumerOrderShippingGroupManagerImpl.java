
package com.doublechaintech.retailscm.consumerordershippinggroup;

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

import com.doublechaintech.retailscm.consumerorder.CandidateConsumerOrder;







public class ConsumerOrderShippingGroupManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderShippingGroupManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderShippingGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ConsumerOrderShippingGroupManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderShippingGroupManagerException(message);

	}
	
	

 	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderShippingGroupDAO().save(consumerOrderShippingGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens);
 	}
 	
 	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroupDetail(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup) throws Exception{	

 		
 		return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, allTokens());
 	}
 	
 	public ConsumerOrderShippingGroup loadConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderShippingGroupManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderShippingGroup, tokens);
 	}
 	
 	
 	 public ConsumerOrderShippingGroup searchConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderShippingGroupManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderShippingGroup, tokens);
 	}
 	
 	

 	protected ConsumerOrderShippingGroup present(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderShippingGroup,tokens);
		
		
		ConsumerOrderShippingGroup  consumerOrderShippingGroupToPresent = userContext.getDAOGroup().getConsumerOrderShippingGroupDAO().present(consumerOrderShippingGroup, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderShippingGroupToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getConsumerOrderShippingGroupDAO().alias(entityListToNaming);
		
		return  consumerOrderShippingGroupToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderShippingGroup loadConsumerOrderShippingGroupDetail(RetailscmUserContext userContext, String consumerOrderShippingGroupId) throws Exception{	
 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, allTokens());
 		return present(userContext,consumerOrderShippingGroup, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String consumerOrderShippingGroupId) throws Exception{	
 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, viewTokens());
 		return present(userContext,consumerOrderShippingGroup, allTokens());
		
 	}
 	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getConsumerOrderShippingGroupDAO().save(consumerOrderShippingGroup, tokens);
 	}
 	protected ConsumerOrderShippingGroup loadConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderShippingGroupId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderShippingGroupManagerException.class);

 
 		return userContext.getDAOGroup().getConsumerOrderShippingGroupDAO().load(consumerOrderShippingGroupId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderShippingGroup, tokens);
		
		addAction(userContext, consumerOrderShippingGroup, tokens,"@create","createConsumerOrderShippingGroup","createConsumerOrderShippingGroup/","main","primary");
		addAction(userContext, consumerOrderShippingGroup, tokens,"@update","updateConsumerOrderShippingGroup","updateConsumerOrderShippingGroup/"+consumerOrderShippingGroup.getId()+"/","main","primary");
		addAction(userContext, consumerOrderShippingGroup, tokens,"@copy","cloneConsumerOrderShippingGroup","cloneConsumerOrderShippingGroup/"+consumerOrderShippingGroup.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrderShippingGroup, tokens,"consumer_order_shipping_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderShippingGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderShippingGroup createConsumerOrderShippingGroup(RetailscmUserContext userContext,String name, String bizOrderId, BigDecimal amount) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfConsumerOrderShippingGroup(name);
		userContext.getChecker().checkAmountOfConsumerOrderShippingGroup(amount);
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderShippingGroupManagerException.class);


		ConsumerOrderShippingGroup consumerOrderShippingGroup=createNewConsumerOrderShippingGroup();	

		consumerOrderShippingGroup.setName(name);
			
		ConsumerOrder bizOrder = loadConsumerOrder(userContext, bizOrderId,emptyOptions());
		consumerOrderShippingGroup.setBizOrder(bizOrder);
		
		
		consumerOrderShippingGroup.setAmount(amount);

		consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderShippingGroup);
		return consumerOrderShippingGroup;

		
	}
	protected ConsumerOrderShippingGroup createNewConsumerOrderShippingGroup() 
	{
		
		return new ConsumerOrderShippingGroup();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderShippingGroup(RetailscmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
		userContext.getChecker().checkVersionOfConsumerOrderShippingGroup( consumerOrderShippingGroupVersion);
		

		if(ConsumerOrderShippingGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfConsumerOrderShippingGroup(parseString(newValueExpr));
		}		

		
		if(ConsumerOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfConsumerOrderShippingGroup(parseBigDecimal(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderShippingGroupManagerException.class);
	
		
	}
	
	
	
	public ConsumerOrderShippingGroup clone(RetailscmUserContext userContext, String fromConsumerOrderShippingGroupId) throws Exception{
		
		return userContext.getDAOGroup().getConsumerOrderShippingGroupDAO().clone(fromConsumerOrderShippingGroupId, this.allTokens());
	}
	
	public ConsumerOrderShippingGroup internalSaveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup) throws Exception 
	{
		return internalSaveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, allTokens());

	}
	public ConsumerOrderShippingGroup internalSaveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(consumerOrderShippingGroup){ 
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShippingGroup.
			
			
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, options);
			return consumerOrderShippingGroup;
			
		}

	}
	
	public ConsumerOrderShippingGroup updateConsumerOrderShippingGroup(RetailscmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion, property, newValueExpr, tokensExpr);
		
		
		
		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, allTokens());
		if(consumerOrderShippingGroup.getVersion() != consumerOrderShippingGroupVersion){
			String message = "The target version("+consumerOrderShippingGroup.getVersion()+") is not equals to version("+consumerOrderShippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderShippingGroup){ 
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShippingGroup.
			
			consumerOrderShippingGroup.changeProperty(property, newValueExpr);
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
			return present(userContext,consumerOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
		}

	}
	
	public ConsumerOrderShippingGroup updateConsumerOrderShippingGroupProperty(RetailscmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, allTokens());
		if(consumerOrderShippingGroup.getVersion() != consumerOrderShippingGroupVersion){
			String message = "The target version("+consumerOrderShippingGroup.getVersion()+") is not equals to version("+consumerOrderShippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderShippingGroup){ 
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShippingGroup.
			
			consumerOrderShippingGroup.changeProperty(property, newValueExpr);
			
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
			return present(userContext,consumerOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderShippingGroupTokens tokens(){
		return ConsumerOrderShippingGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderShippingGroupTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderShippingGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
 		userContext.getChecker().checkIdOfConsumerOrder(anotherBizOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderShippingGroupManagerException.class);
 		
 	}
 	public ConsumerOrderShippingGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderShippingGroupId,anotherBizOrderId);
 
		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, allTokens());	
		synchronized(consumerOrderShippingGroup){
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(userContext, anotherBizOrderId, emptyOptions());		
			consumerOrderShippingGroup.updateBizOrder(bizOrder);		
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, emptyOptions());
			
			return present(userContext,consumerOrderShippingGroup, allTokens());
			
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
		SmartList<ConsumerOrder> candidateList = userContext.getDAOGroup().getConsumerOrderDAO().requestCandidateConsumerOrderForConsumerOrderShippingGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception{
			
		userContext.getDAOGroup().getConsumerOrderShippingGroupDAO().delete(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
	}
	
	public ConsumerOrderShippingGroup forgetByAll(RetailscmUserContext userContext, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);		
	}
	protected ConsumerOrderShippingGroup forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception{
			
		return userContext.getDAOGroup().getConsumerOrderShippingGroupDAO().disconnectFromAll(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderShippingGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getConsumerOrderShippingGroupDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderShippingGroup newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


