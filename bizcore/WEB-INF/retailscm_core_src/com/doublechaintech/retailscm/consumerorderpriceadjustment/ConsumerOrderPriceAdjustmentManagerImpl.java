
package com.doublechaintech.retailscm.consumerorderpriceadjustment;

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







public class ConsumerOrderPriceAdjustmentManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderPriceAdjustmentManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderPriceAdjustment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ConsumerOrderPriceAdjustmentManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderPriceAdjustmentManagerException(message);

	}
	
	

 	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustment(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderPriceAdjustmentDAO().save(consumerOrderPriceAdjustment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens);
 	}
 	
 	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustmentDetail(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment) throws Exception{	

 		
 		return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, allTokens());
 	}
 	
 	public ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderPriceAdjustmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderPriceAdjustment, tokens);
 	}
 	
 	
 	 public ConsumerOrderPriceAdjustment searchConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderPriceAdjustmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderPriceAdjustment, tokens);
 	}
 	
 	

 	protected ConsumerOrderPriceAdjustment present(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderPriceAdjustment,tokens);
		
		
		ConsumerOrderPriceAdjustment  consumerOrderPriceAdjustmentToPresent = userContext.getDAOGroup().getConsumerOrderPriceAdjustmentDAO().present(consumerOrderPriceAdjustment, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderPriceAdjustmentToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getConsumerOrderPriceAdjustmentDAO().alias(entityListToNaming);
		
		return  consumerOrderPriceAdjustmentToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustmentDetail(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId) throws Exception{	
 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, allTokens());
 		return present(userContext,consumerOrderPriceAdjustment, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId) throws Exception{	
 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, viewTokens());
 		return present(userContext,consumerOrderPriceAdjustment, allTokens());
		
 	}
 	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustment(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getConsumerOrderPriceAdjustmentDAO().save(consumerOrderPriceAdjustment, tokens);
 	}
 	protected ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderPriceAdjustmentManagerException.class);

 
 		return userContext.getDAOGroup().getConsumerOrderPriceAdjustmentDAO().load(consumerOrderPriceAdjustmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderPriceAdjustment, tokens);
		
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"@create","createConsumerOrderPriceAdjustment","createConsumerOrderPriceAdjustment/","main","primary");
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"@update","updateConsumerOrderPriceAdjustment","updateConsumerOrderPriceAdjustment/"+consumerOrderPriceAdjustment.getId()+"/","main","primary");
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"@copy","cloneConsumerOrderPriceAdjustment","cloneConsumerOrderPriceAdjustment/"+consumerOrderPriceAdjustment.getId()+"/","main","primary");
		
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"consumer_order_price_adjustment.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderPriceAdjustment.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(RetailscmUserContext userContext,String name, String bizOrderId, BigDecimal amount, String provider) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfConsumerOrderPriceAdjustment(name);
		userContext.getChecker().checkAmountOfConsumerOrderPriceAdjustment(amount);
		userContext.getChecker().checkProviderOfConsumerOrderPriceAdjustment(provider);
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderPriceAdjustmentManagerException.class);


		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment=createNewConsumerOrderPriceAdjustment();	

		consumerOrderPriceAdjustment.setName(name);
			
		ConsumerOrder bizOrder = loadConsumerOrder(userContext, bizOrderId,emptyOptions());
		consumerOrderPriceAdjustment.setBizOrder(bizOrder);
		
		
		consumerOrderPriceAdjustment.setAmount(amount);
		consumerOrderPriceAdjustment.setProvider(provider);

		consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderPriceAdjustment);
		return consumerOrderPriceAdjustment;

		
	}
	protected ConsumerOrderPriceAdjustment createNewConsumerOrderPriceAdjustment() 
	{
		
		return new ConsumerOrderPriceAdjustment();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderPriceAdjustment(RetailscmUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
		userContext.getChecker().checkVersionOfConsumerOrderPriceAdjustment( consumerOrderPriceAdjustmentVersion);
		

		if(ConsumerOrderPriceAdjustment.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfConsumerOrderPriceAdjustment(parseString(newValueExpr));
		}		

		
		if(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfConsumerOrderPriceAdjustment(parseBigDecimal(newValueExpr));
		}
		if(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY.equals(property)){
			userContext.getChecker().checkProviderOfConsumerOrderPriceAdjustment(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderPriceAdjustmentManagerException.class);
	
		
	}
	
	
	
	public ConsumerOrderPriceAdjustment clone(RetailscmUserContext userContext, String fromConsumerOrderPriceAdjustmentId) throws Exception{
		
		return userContext.getDAOGroup().getConsumerOrderPriceAdjustmentDAO().clone(fromConsumerOrderPriceAdjustmentId, this.allTokens());
	}
	
	public ConsumerOrderPriceAdjustment internalSaveConsumerOrderPriceAdjustment(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment) throws Exception 
	{
		return internalSaveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, allTokens());

	}
	public ConsumerOrderPriceAdjustment internalSaveConsumerOrderPriceAdjustment(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(consumerOrderPriceAdjustment){ 
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPriceAdjustment.
			
			
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, options);
			return consumerOrderPriceAdjustment;
			
		}

	}
	
	public ConsumerOrderPriceAdjustment updateConsumerOrderPriceAdjustment(RetailscmUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion, property, newValueExpr, tokensExpr);
		
		
		
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, allTokens());
		if(consumerOrderPriceAdjustment.getVersion() != consumerOrderPriceAdjustmentVersion){
			String message = "The target version("+consumerOrderPriceAdjustment.getVersion()+") is not equals to version("+consumerOrderPriceAdjustmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderPriceAdjustment){ 
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPriceAdjustment.
			
			consumerOrderPriceAdjustment.changeProperty(property, newValueExpr);
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
			return present(userContext,consumerOrderPriceAdjustment, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
		}

	}
	
	public ConsumerOrderPriceAdjustment updateConsumerOrderPriceAdjustmentProperty(RetailscmUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, allTokens());
		if(consumerOrderPriceAdjustment.getVersion() != consumerOrderPriceAdjustmentVersion){
			String message = "The target version("+consumerOrderPriceAdjustment.getVersion()+") is not equals to version("+consumerOrderPriceAdjustmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderPriceAdjustment){ 
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPriceAdjustment.
			
			consumerOrderPriceAdjustment.changeProperty(property, newValueExpr);
			
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
			return present(userContext,consumerOrderPriceAdjustment, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderPriceAdjustmentTokens tokens(){
		return ConsumerOrderPriceAdjustmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderPriceAdjustmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderPriceAdjustmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, String anotherBizOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
 		userContext.getChecker().checkIdOfConsumerOrder(anotherBizOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderPriceAdjustmentManagerException.class);
 		
 	}
 	public ConsumerOrderPriceAdjustment transferToAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderPriceAdjustmentId,anotherBizOrderId);
 
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, allTokens());	
		synchronized(consumerOrderPriceAdjustment){
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(userContext, anotherBizOrderId, emptyOptions());		
			consumerOrderPriceAdjustment.updateBizOrder(bizOrder);		
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, emptyOptions());
			
			return present(userContext,consumerOrderPriceAdjustment, allTokens());
			
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
		SmartList<ConsumerOrder> candidateList = userContext.getDAOGroup().getConsumerOrderDAO().requestCandidateConsumerOrderForConsumerOrderPriceAdjustment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception{
			
		userContext.getDAOGroup().getConsumerOrderPriceAdjustmentDAO().delete(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
	}
	
	public ConsumerOrderPriceAdjustment forgetByAll(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);		
	}
	protected ConsumerOrderPriceAdjustment forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception{
			
		return userContext.getDAOGroup().getConsumerOrderPriceAdjustmentDAO().disconnectFromAll(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderPriceAdjustmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getConsumerOrderPriceAdjustmentDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


