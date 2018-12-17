
package com.doublechaintech.retailscm.consumerorderpaymentgroup;

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







public class ConsumerOrderPaymentGroupManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderPaymentGroupManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderPaymentGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ConsumerOrderPaymentGroupManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderPaymentGroupManagerException(message);

	}
	
	

 	protected ConsumerOrderPaymentGroup saveConsumerOrderPaymentGroup(RetailscmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderPaymentGroupDAO().save(consumerOrderPaymentGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, tokens);
 	}
 	
 	protected ConsumerOrderPaymentGroup saveConsumerOrderPaymentGroupDetail(RetailscmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup) throws Exception{	

 		
 		return saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, allTokens());
 	}
 	
 	public ConsumerOrderPaymentGroup loadConsumerOrderPaymentGroup(RetailscmUserContext userContext, String consumerOrderPaymentGroupId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderPaymentGroupManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = loadConsumerOrderPaymentGroup( userContext, consumerOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderPaymentGroup, tokens);
 	}
 	
 	
 	 public ConsumerOrderPaymentGroup searchConsumerOrderPaymentGroup(RetailscmUserContext userContext, String consumerOrderPaymentGroupId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderPaymentGroupManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = loadConsumerOrderPaymentGroup( userContext, consumerOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderPaymentGroup, tokens);
 	}
 	
 	

 	protected ConsumerOrderPaymentGroup present(RetailscmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderPaymentGroup,tokens);
		
		
		ConsumerOrderPaymentGroup  consumerOrderPaymentGroupToPresent = userContext.getDAOGroup().getConsumerOrderPaymentGroupDAO().present(consumerOrderPaymentGroup, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderPaymentGroupToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getConsumerOrderPaymentGroupDAO().alias(entityListToNaming);
		
		return  consumerOrderPaymentGroupToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderPaymentGroup loadConsumerOrderPaymentGroupDetail(RetailscmUserContext userContext, String consumerOrderPaymentGroupId) throws Exception{	
 		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = loadConsumerOrderPaymentGroup( userContext, consumerOrderPaymentGroupId, allTokens());
 		return present(userContext,consumerOrderPaymentGroup, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String consumerOrderPaymentGroupId) throws Exception{	
 		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = loadConsumerOrderPaymentGroup( userContext, consumerOrderPaymentGroupId, viewTokens());
 		return present(userContext,consumerOrderPaymentGroup, allTokens());
		
 	}
 	protected ConsumerOrderPaymentGroup saveConsumerOrderPaymentGroup(RetailscmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getConsumerOrderPaymentGroupDAO().save(consumerOrderPaymentGroup, tokens);
 	}
 	protected ConsumerOrderPaymentGroup loadConsumerOrderPaymentGroup(RetailscmUserContext userContext, String consumerOrderPaymentGroupId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderPaymentGroupManagerException.class);

 
 		return userContext.getDAOGroup().getConsumerOrderPaymentGroupDAO().load(consumerOrderPaymentGroupId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderPaymentGroup, tokens);
		
		addAction(userContext, consumerOrderPaymentGroup, tokens,"@create","createConsumerOrderPaymentGroup","createConsumerOrderPaymentGroup/","main","primary");
		addAction(userContext, consumerOrderPaymentGroup, tokens,"@update","updateConsumerOrderPaymentGroup","updateConsumerOrderPaymentGroup/"+consumerOrderPaymentGroup.getId()+"/","main","primary");
		addAction(userContext, consumerOrderPaymentGroup, tokens,"@copy","cloneConsumerOrderPaymentGroup","cloneConsumerOrderPaymentGroup/"+consumerOrderPaymentGroup.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrderPaymentGroup, tokens,"consumer_order_payment_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderPaymentGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderPaymentGroup createConsumerOrderPaymentGroup(RetailscmUserContext userContext,String name, String bizOrderId, String cardNumber) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfConsumerOrderPaymentGroup(name);
		userContext.getChecker().checkCardNumberOfConsumerOrderPaymentGroup(cardNumber);
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderPaymentGroupManagerException.class);


		ConsumerOrderPaymentGroup consumerOrderPaymentGroup=createNewConsumerOrderPaymentGroup();	

		consumerOrderPaymentGroup.setName(name);
			
		ConsumerOrder bizOrder = loadConsumerOrder(userContext, bizOrderId,emptyOptions());
		consumerOrderPaymentGroup.setBizOrder(bizOrder);
		
		
		consumerOrderPaymentGroup.setCardNumber(cardNumber);

		consumerOrderPaymentGroup = saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderPaymentGroup);
		return consumerOrderPaymentGroup;

		
	}
	protected ConsumerOrderPaymentGroup createNewConsumerOrderPaymentGroup() 
	{
		
		return new ConsumerOrderPaymentGroup();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderPaymentGroup(RetailscmUserContext userContext,String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupId);
		userContext.getChecker().checkVersionOfConsumerOrderPaymentGroup( consumerOrderPaymentGroupVersion);
		

		if(ConsumerOrderPaymentGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfConsumerOrderPaymentGroup(parseString(newValueExpr));
		}		

		
		if(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkCardNumberOfConsumerOrderPaymentGroup(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderPaymentGroupManagerException.class);
	
		
	}
	
	
	
	public ConsumerOrderPaymentGroup clone(RetailscmUserContext userContext, String fromConsumerOrderPaymentGroupId) throws Exception{
		
		return userContext.getDAOGroup().getConsumerOrderPaymentGroupDAO().clone(fromConsumerOrderPaymentGroupId, this.allTokens());
	}
	
	public ConsumerOrderPaymentGroup internalSaveConsumerOrderPaymentGroup(RetailscmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup) throws Exception 
	{
		return internalSaveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, allTokens());

	}
	public ConsumerOrderPaymentGroup internalSaveConsumerOrderPaymentGroup(RetailscmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(consumerOrderPaymentGroup){ 
			//will be good when the consumerOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPaymentGroup.
			
			
			consumerOrderPaymentGroup = saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, options);
			return consumerOrderPaymentGroup;
			
		}

	}
	
	public ConsumerOrderPaymentGroup updateConsumerOrderPaymentGroup(RetailscmUserContext userContext,String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);
		
		
		
		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = loadConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, allTokens());
		if(consumerOrderPaymentGroup.getVersion() != consumerOrderPaymentGroupVersion){
			String message = "The target version("+consumerOrderPaymentGroup.getVersion()+") is not equals to version("+consumerOrderPaymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderPaymentGroup){ 
			//will be good when the consumerOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPaymentGroup.
			
			consumerOrderPaymentGroup.changeProperty(property, newValueExpr);
			consumerOrderPaymentGroup = saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, tokens().done());
			return present(userContext,consumerOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, tokens().done());
		}

	}
	
	public ConsumerOrderPaymentGroup updateConsumerOrderPaymentGroupProperty(RetailscmUserContext userContext,String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = loadConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, allTokens());
		if(consumerOrderPaymentGroup.getVersion() != consumerOrderPaymentGroupVersion){
			String message = "The target version("+consumerOrderPaymentGroup.getVersion()+") is not equals to version("+consumerOrderPaymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderPaymentGroup){ 
			//will be good when the consumerOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPaymentGroup.
			
			consumerOrderPaymentGroup.changeProperty(property, newValueExpr);
			
			consumerOrderPaymentGroup = saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, tokens().done());
			return present(userContext,consumerOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderPaymentGroupTokens tokens(){
		return ConsumerOrderPaymentGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderPaymentGroupTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderPaymentGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfConsumerOrderPaymentGroup(consumerOrderPaymentGroupId);
 		userContext.getChecker().checkIdOfConsumerOrder(anotherBizOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderPaymentGroupManagerException.class);
 		
 	}
 	public ConsumerOrderPaymentGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderPaymentGroupId,anotherBizOrderId);
 
		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = loadConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroupId, allTokens());	
		synchronized(consumerOrderPaymentGroup){
			//will be good when the consumerOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(userContext, anotherBizOrderId, emptyOptions());		
			consumerOrderPaymentGroup.updateBizOrder(bizOrder);		
			consumerOrderPaymentGroup = saveConsumerOrderPaymentGroup(userContext, consumerOrderPaymentGroup, emptyOptions());
			
			return present(userContext,consumerOrderPaymentGroup, allTokens());
			
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
		SmartList<ConsumerOrder> candidateList = userContext.getDAOGroup().getConsumerOrderDAO().requestCandidateConsumerOrderForConsumerOrderPaymentGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion) throws Exception{
			
		userContext.getDAOGroup().getConsumerOrderPaymentGroupDAO().delete(consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);
	}
	
	public ConsumerOrderPaymentGroup forgetByAll(RetailscmUserContext userContext, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);		
	}
	protected ConsumerOrderPaymentGroup forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion) throws Exception{
			
		return userContext.getDAOGroup().getConsumerOrderPaymentGroupDAO().disconnectFromAll(consumerOrderPaymentGroupId, consumerOrderPaymentGroupVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderPaymentGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getConsumerOrderPaymentGroupDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderPaymentGroup newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


