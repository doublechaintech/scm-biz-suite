
package com.doublechaintech.retailscm.consumerorderconfirmation;

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









public class ConsumerOrderConfirmationManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderConfirmationManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderConfirmation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ConsumerOrderConfirmationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderConfirmationManagerException(message);

	}
	
	

 	protected ConsumerOrderConfirmation saveConsumerOrderConfirmation(RetailscmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderConfirmationDAO().save(consumerOrderConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens);
 	}
 	
 	protected ConsumerOrderConfirmation saveConsumerOrderConfirmationDetail(RetailscmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation) throws Exception{	

 		
 		return saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, allTokens());
 	}
 	
 	public ConsumerOrderConfirmation loadConsumerOrderConfirmation(RetailscmUserContext userContext, String consumerOrderConfirmationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderConfirmation(consumerOrderConfirmationId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderConfirmationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation( userContext, consumerOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderConfirmation, tokens);
 	}
 	
 	
 	 public ConsumerOrderConfirmation searchConsumerOrderConfirmation(RetailscmUserContext userContext, String consumerOrderConfirmationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderConfirmation(consumerOrderConfirmationId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderConfirmationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation( userContext, consumerOrderConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderConfirmation, tokens);
 	}
 	
 	

 	protected ConsumerOrderConfirmation present(RetailscmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderConfirmation,tokens);
		
		
		ConsumerOrderConfirmation  consumerOrderConfirmationToPresent = userContext.getDAOGroup().getConsumerOrderConfirmationDAO().present(consumerOrderConfirmation, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderConfirmationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getConsumerOrderConfirmationDAO().alias(entityListToNaming);
		
		return  consumerOrderConfirmationToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderConfirmation loadConsumerOrderConfirmationDetail(RetailscmUserContext userContext, String consumerOrderConfirmationId) throws Exception{	
 		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation( userContext, consumerOrderConfirmationId, allTokens());
 		return present(userContext,consumerOrderConfirmation, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String consumerOrderConfirmationId) throws Exception{	
 		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation( userContext, consumerOrderConfirmationId, viewTokens());
 		return present(userContext,consumerOrderConfirmation, allTokens());
		
 	}
 	protected ConsumerOrderConfirmation saveConsumerOrderConfirmation(RetailscmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getConsumerOrderConfirmationDAO().save(consumerOrderConfirmation, tokens);
 	}
 	protected ConsumerOrderConfirmation loadConsumerOrderConfirmation(RetailscmUserContext userContext, String consumerOrderConfirmationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfConsumerOrderConfirmation(consumerOrderConfirmationId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderConfirmationManagerException.class);

 
 		return userContext.getDAOGroup().getConsumerOrderConfirmationDAO().load(consumerOrderConfirmationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderConfirmation, tokens);
		
		addAction(userContext, consumerOrderConfirmation, tokens,"@create","createConsumerOrderConfirmation","createConsumerOrderConfirmation/","main","primary");
		addAction(userContext, consumerOrderConfirmation, tokens,"@update","updateConsumerOrderConfirmation","updateConsumerOrderConfirmation/"+consumerOrderConfirmation.getId()+"/","main","primary");
		addAction(userContext, consumerOrderConfirmation, tokens,"@copy","cloneConsumerOrderConfirmation","cloneConsumerOrderConfirmation/"+consumerOrderConfirmation.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderConfirmation createConsumerOrderConfirmation(RetailscmUserContext userContext,String who, Date confirmTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfConsumerOrderConfirmation(who);
		userContext.getChecker().checkConfirmTimeOfConsumerOrderConfirmation(confirmTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderConfirmationManagerException.class);


		ConsumerOrderConfirmation consumerOrderConfirmation=createNewConsumerOrderConfirmation();	

		consumerOrderConfirmation.setWho(who);
		consumerOrderConfirmation.setConfirmTime(confirmTime);

		consumerOrderConfirmation = saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderConfirmation);
		return consumerOrderConfirmation;

		
	}
	protected ConsumerOrderConfirmation createNewConsumerOrderConfirmation() 
	{
		
		return new ConsumerOrderConfirmation();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderConfirmation(RetailscmUserContext userContext,String consumerOrderConfirmationId, int consumerOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfConsumerOrderConfirmation(consumerOrderConfirmationId);
		userContext.getChecker().checkVersionOfConsumerOrderConfirmation( consumerOrderConfirmationVersion);
		

		if(ConsumerOrderConfirmation.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfConsumerOrderConfirmation(parseString(newValueExpr));
		}
		if(ConsumerOrderConfirmation.CONFIRM_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkConfirmTimeOfConsumerOrderConfirmation(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderConfirmationManagerException.class);
	
		
	}
	
	
	
	public ConsumerOrderConfirmation clone(RetailscmUserContext userContext, String fromConsumerOrderConfirmationId) throws Exception{
		
		return userContext.getDAOGroup().getConsumerOrderConfirmationDAO().clone(fromConsumerOrderConfirmationId, this.allTokens());
	}
	
	public ConsumerOrderConfirmation internalSaveConsumerOrderConfirmation(RetailscmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation) throws Exception 
	{
		return internalSaveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, allTokens());

	}
	public ConsumerOrderConfirmation internalSaveConsumerOrderConfirmation(RetailscmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, consumerOrderConfirmationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(consumerOrderConfirmation){ 
			//will be good when the consumerOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderConfirmation.
			
			
			consumerOrderConfirmation = saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, options);
			return consumerOrderConfirmation;
			
		}

	}
	
	public ConsumerOrderConfirmation updateConsumerOrderConfirmation(RetailscmUserContext userContext,String consumerOrderConfirmationId, int consumerOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, consumerOrderConfirmationVersion, property, newValueExpr, tokensExpr);
		
		
		
		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, allTokens());
		if(consumerOrderConfirmation.getVersion() != consumerOrderConfirmationVersion){
			String message = "The target version("+consumerOrderConfirmation.getVersion()+") is not equals to version("+consumerOrderConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderConfirmation){ 
			//will be good when the consumerOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderConfirmation.
			
			consumerOrderConfirmation.changeProperty(property, newValueExpr);
			consumerOrderConfirmation = saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens().done());
			return present(userContext,consumerOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens().done());
		}

	}
	
	public ConsumerOrderConfirmation updateConsumerOrderConfirmationProperty(RetailscmUserContext userContext,String consumerOrderConfirmationId, int consumerOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, consumerOrderConfirmationVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderConfirmation consumerOrderConfirmation = loadConsumerOrderConfirmation(userContext, consumerOrderConfirmationId, allTokens());
		if(consumerOrderConfirmation.getVersion() != consumerOrderConfirmationVersion){
			String message = "The target version("+consumerOrderConfirmation.getVersion()+") is not equals to version("+consumerOrderConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderConfirmation){ 
			//will be good when the consumerOrderConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderConfirmation.
			
			consumerOrderConfirmation.changeProperty(property, newValueExpr);
			
			consumerOrderConfirmation = saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens().done());
			return present(userContext,consumerOrderConfirmation, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderConfirmation(userContext, consumerOrderConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderConfirmationTokens tokens(){
		return ConsumerOrderConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderConfirmationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderConfirmationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String consumerOrderConfirmationId, int consumerOrderConfirmationVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderConfirmationId, consumerOrderConfirmationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderConfirmationId, int consumerOrderConfirmationVersion) throws Exception{
			
		userContext.getDAOGroup().getConsumerOrderConfirmationDAO().delete(consumerOrderConfirmationId, consumerOrderConfirmationVersion);
	}
	
	public ConsumerOrderConfirmation forgetByAll(RetailscmUserContext userContext, String consumerOrderConfirmationId, int consumerOrderConfirmationVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderConfirmationId, consumerOrderConfirmationVersion);		
	}
	protected ConsumerOrderConfirmation forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderConfirmationId, int consumerOrderConfirmationVersion) throws Exception{
			
		return userContext.getDAOGroup().getConsumerOrderConfirmationDAO().disconnectFromAll(consumerOrderConfirmationId, consumerOrderConfirmationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getConsumerOrderConfirmationDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderConfirmation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


