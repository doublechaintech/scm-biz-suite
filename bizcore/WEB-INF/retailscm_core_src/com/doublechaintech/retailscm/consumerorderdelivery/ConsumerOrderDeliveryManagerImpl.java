
package com.doublechaintech.retailscm.consumerorderdelivery;

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









public class ConsumerOrderDeliveryManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderDeliveryManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderDelivery";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ConsumerOrderDeliveryManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderDeliveryManagerException(message);

	}
	
	

 	protected ConsumerOrderDelivery saveConsumerOrderDelivery(RetailscmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderDeliveryDAO().save(consumerOrderDelivery, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderDelivery(userContext, consumerOrderDelivery, tokens);
 	}
 	
 	protected ConsumerOrderDelivery saveConsumerOrderDeliveryDetail(RetailscmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery) throws Exception{	

 		
 		return saveConsumerOrderDelivery(userContext, consumerOrderDelivery, allTokens());
 	}
 	
 	public ConsumerOrderDelivery loadConsumerOrderDelivery(RetailscmUserContext userContext, String consumerOrderDeliveryId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderDelivery(consumerOrderDeliveryId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderDeliveryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderDelivery consumerOrderDelivery = loadConsumerOrderDelivery( userContext, consumerOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderDelivery, tokens);
 	}
 	
 	
 	 public ConsumerOrderDelivery searchConsumerOrderDelivery(RetailscmUserContext userContext, String consumerOrderDeliveryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderDelivery(consumerOrderDeliveryId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderDeliveryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderDelivery consumerOrderDelivery = loadConsumerOrderDelivery( userContext, consumerOrderDeliveryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderDelivery, tokens);
 	}
 	
 	

 	protected ConsumerOrderDelivery present(RetailscmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderDelivery,tokens);
		
		
		ConsumerOrderDelivery  consumerOrderDeliveryToPresent = userContext.getDAOGroup().getConsumerOrderDeliveryDAO().present(consumerOrderDelivery, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderDeliveryToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getConsumerOrderDeliveryDAO().alias(entityListToNaming);
		
		return  consumerOrderDeliveryToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderDelivery loadConsumerOrderDeliveryDetail(RetailscmUserContext userContext, String consumerOrderDeliveryId) throws Exception{	
 		ConsumerOrderDelivery consumerOrderDelivery = loadConsumerOrderDelivery( userContext, consumerOrderDeliveryId, allTokens());
 		return present(userContext,consumerOrderDelivery, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String consumerOrderDeliveryId) throws Exception{	
 		ConsumerOrderDelivery consumerOrderDelivery = loadConsumerOrderDelivery( userContext, consumerOrderDeliveryId, viewTokens());
 		return present(userContext,consumerOrderDelivery, allTokens());
		
 	}
 	protected ConsumerOrderDelivery saveConsumerOrderDelivery(RetailscmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getConsumerOrderDeliveryDAO().save(consumerOrderDelivery, tokens);
 	}
 	protected ConsumerOrderDelivery loadConsumerOrderDelivery(RetailscmUserContext userContext, String consumerOrderDeliveryId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfConsumerOrderDelivery(consumerOrderDeliveryId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderDeliveryManagerException.class);

 
 		return userContext.getDAOGroup().getConsumerOrderDeliveryDAO().load(consumerOrderDeliveryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderDelivery, tokens);
		
		addAction(userContext, consumerOrderDelivery, tokens,"@create","createConsumerOrderDelivery","createConsumerOrderDelivery/","main","primary");
		addAction(userContext, consumerOrderDelivery, tokens,"@update","updateConsumerOrderDelivery","updateConsumerOrderDelivery/"+consumerOrderDelivery.getId()+"/","main","primary");
		addAction(userContext, consumerOrderDelivery, tokens,"@copy","cloneConsumerOrderDelivery","cloneConsumerOrderDelivery/"+consumerOrderDelivery.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderDelivery createConsumerOrderDelivery(RetailscmUserContext userContext,String who, Date deliveryTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfConsumerOrderDelivery(who);
		userContext.getChecker().checkDeliveryTimeOfConsumerOrderDelivery(deliveryTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderDeliveryManagerException.class);


		ConsumerOrderDelivery consumerOrderDelivery=createNewConsumerOrderDelivery();	

		consumerOrderDelivery.setWho(who);
		consumerOrderDelivery.setDeliveryTime(deliveryTime);

		consumerOrderDelivery = saveConsumerOrderDelivery(userContext, consumerOrderDelivery, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderDelivery);
		return consumerOrderDelivery;

		
	}
	protected ConsumerOrderDelivery createNewConsumerOrderDelivery() 
	{
		
		return new ConsumerOrderDelivery();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderDelivery(RetailscmUserContext userContext,String consumerOrderDeliveryId, int consumerOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfConsumerOrderDelivery(consumerOrderDeliveryId);
		userContext.getChecker().checkVersionOfConsumerOrderDelivery( consumerOrderDeliveryVersion);
		

		if(ConsumerOrderDelivery.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfConsumerOrderDelivery(parseString(newValueExpr));
		}
		if(ConsumerOrderDelivery.DELIVERY_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkDeliveryTimeOfConsumerOrderDelivery(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderDeliveryManagerException.class);
	
		
	}
	
	
	
	public ConsumerOrderDelivery clone(RetailscmUserContext userContext, String fromConsumerOrderDeliveryId) throws Exception{
		
		return userContext.getDAOGroup().getConsumerOrderDeliveryDAO().clone(fromConsumerOrderDeliveryId, this.allTokens());
	}
	
	public ConsumerOrderDelivery internalSaveConsumerOrderDelivery(RetailscmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery) throws Exception 
	{
		return internalSaveConsumerOrderDelivery(userContext, consumerOrderDelivery, allTokens());

	}
	public ConsumerOrderDelivery internalSaveConsumerOrderDelivery(RetailscmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingConsumerOrderDelivery(userContext, consumerOrderDeliveryId, consumerOrderDeliveryVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(consumerOrderDelivery){ 
			//will be good when the consumerOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderDelivery.
			
			
			consumerOrderDelivery = saveConsumerOrderDelivery(userContext, consumerOrderDelivery, options);
			return consumerOrderDelivery;
			
		}

	}
	
	public ConsumerOrderDelivery updateConsumerOrderDelivery(RetailscmUserContext userContext,String consumerOrderDeliveryId, int consumerOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderDelivery(userContext, consumerOrderDeliveryId, consumerOrderDeliveryVersion, property, newValueExpr, tokensExpr);
		
		
		
		ConsumerOrderDelivery consumerOrderDelivery = loadConsumerOrderDelivery(userContext, consumerOrderDeliveryId, allTokens());
		if(consumerOrderDelivery.getVersion() != consumerOrderDeliveryVersion){
			String message = "The target version("+consumerOrderDelivery.getVersion()+") is not equals to version("+consumerOrderDeliveryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderDelivery){ 
			//will be good when the consumerOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderDelivery.
			
			consumerOrderDelivery.changeProperty(property, newValueExpr);
			consumerOrderDelivery = saveConsumerOrderDelivery(userContext, consumerOrderDelivery, tokens().done());
			return present(userContext,consumerOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderDelivery(userContext, consumerOrderDelivery, tokens().done());
		}

	}
	
	public ConsumerOrderDelivery updateConsumerOrderDeliveryProperty(RetailscmUserContext userContext,String consumerOrderDeliveryId, int consumerOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderDelivery(userContext, consumerOrderDeliveryId, consumerOrderDeliveryVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderDelivery consumerOrderDelivery = loadConsumerOrderDelivery(userContext, consumerOrderDeliveryId, allTokens());
		if(consumerOrderDelivery.getVersion() != consumerOrderDeliveryVersion){
			String message = "The target version("+consumerOrderDelivery.getVersion()+") is not equals to version("+consumerOrderDeliveryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderDelivery){ 
			//will be good when the consumerOrderDelivery loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderDelivery.
			
			consumerOrderDelivery.changeProperty(property, newValueExpr);
			
			consumerOrderDelivery = saveConsumerOrderDelivery(userContext, consumerOrderDelivery, tokens().done());
			return present(userContext,consumerOrderDelivery, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderDelivery(userContext, consumerOrderDelivery, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderDeliveryTokens tokens(){
		return ConsumerOrderDeliveryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderDeliveryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderDeliveryTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String consumerOrderDeliveryId, int consumerOrderDeliveryVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderDeliveryId, consumerOrderDeliveryVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderDeliveryId, int consumerOrderDeliveryVersion) throws Exception{
			
		userContext.getDAOGroup().getConsumerOrderDeliveryDAO().delete(consumerOrderDeliveryId, consumerOrderDeliveryVersion);
	}
	
	public ConsumerOrderDelivery forgetByAll(RetailscmUserContext userContext, String consumerOrderDeliveryId, int consumerOrderDeliveryVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderDeliveryId, consumerOrderDeliveryVersion);		
	}
	protected ConsumerOrderDelivery forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderDeliveryId, int consumerOrderDeliveryVersion) throws Exception{
			
		return userContext.getDAOGroup().getConsumerOrderDeliveryDAO().disconnectFromAll(consumerOrderDeliveryId, consumerOrderDeliveryVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderDeliveryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getConsumerOrderDeliveryDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderDelivery newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


