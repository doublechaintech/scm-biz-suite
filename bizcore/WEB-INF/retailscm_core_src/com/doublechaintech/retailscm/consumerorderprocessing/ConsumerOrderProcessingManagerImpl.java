
package com.doublechaintech.retailscm.consumerorderprocessing;

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









public class ConsumerOrderProcessingManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderProcessingManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderProcessing";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ConsumerOrderProcessingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderProcessingManagerException(message);

	}
	
	

 	protected ConsumerOrderProcessing saveConsumerOrderProcessing(RetailscmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderProcessingDAO().save(consumerOrderProcessing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens);
 	}
 	
 	protected ConsumerOrderProcessing saveConsumerOrderProcessingDetail(RetailscmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing) throws Exception{	

 		
 		return saveConsumerOrderProcessing(userContext, consumerOrderProcessing, allTokens());
 	}
 	
 	public ConsumerOrderProcessing loadConsumerOrderProcessing(RetailscmUserContext userContext, String consumerOrderProcessingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderProcessing(consumerOrderProcessingId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderProcessingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing( userContext, consumerOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderProcessing, tokens);
 	}
 	
 	
 	 public ConsumerOrderProcessing searchConsumerOrderProcessing(RetailscmUserContext userContext, String consumerOrderProcessingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderProcessing(consumerOrderProcessingId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderProcessingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing( userContext, consumerOrderProcessingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderProcessing, tokens);
 	}
 	
 	

 	protected ConsumerOrderProcessing present(RetailscmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderProcessing,tokens);
		
		
		ConsumerOrderProcessing  consumerOrderProcessingToPresent = userContext.getDAOGroup().getConsumerOrderProcessingDAO().present(consumerOrderProcessing, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderProcessingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getConsumerOrderProcessingDAO().alias(entityListToNaming);
		
		return  consumerOrderProcessingToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderProcessing loadConsumerOrderProcessingDetail(RetailscmUserContext userContext, String consumerOrderProcessingId) throws Exception{	
 		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing( userContext, consumerOrderProcessingId, allTokens());
 		return present(userContext,consumerOrderProcessing, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String consumerOrderProcessingId) throws Exception{	
 		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing( userContext, consumerOrderProcessingId, viewTokens());
 		return present(userContext,consumerOrderProcessing, allTokens());
		
 	}
 	protected ConsumerOrderProcessing saveConsumerOrderProcessing(RetailscmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getConsumerOrderProcessingDAO().save(consumerOrderProcessing, tokens);
 	}
 	protected ConsumerOrderProcessing loadConsumerOrderProcessing(RetailscmUserContext userContext, String consumerOrderProcessingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfConsumerOrderProcessing(consumerOrderProcessingId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderProcessingManagerException.class);

 
 		return userContext.getDAOGroup().getConsumerOrderProcessingDAO().load(consumerOrderProcessingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderProcessing, tokens);
		
		addAction(userContext, consumerOrderProcessing, tokens,"@create","createConsumerOrderProcessing","createConsumerOrderProcessing/","main","primary");
		addAction(userContext, consumerOrderProcessing, tokens,"@update","updateConsumerOrderProcessing","updateConsumerOrderProcessing/"+consumerOrderProcessing.getId()+"/","main","primary");
		addAction(userContext, consumerOrderProcessing, tokens,"@copy","cloneConsumerOrderProcessing","cloneConsumerOrderProcessing/"+consumerOrderProcessing.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderProcessing createConsumerOrderProcessing(RetailscmUserContext userContext,String who, Date processTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfConsumerOrderProcessing(who);
		userContext.getChecker().checkProcessTimeOfConsumerOrderProcessing(processTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderProcessingManagerException.class);


		ConsumerOrderProcessing consumerOrderProcessing=createNewConsumerOrderProcessing();	

		consumerOrderProcessing.setWho(who);
		consumerOrderProcessing.setProcessTime(processTime);

		consumerOrderProcessing = saveConsumerOrderProcessing(userContext, consumerOrderProcessing, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderProcessing);
		return consumerOrderProcessing;

		
	}
	protected ConsumerOrderProcessing createNewConsumerOrderProcessing() 
	{
		
		return new ConsumerOrderProcessing();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderProcessing(RetailscmUserContext userContext,String consumerOrderProcessingId, int consumerOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfConsumerOrderProcessing(consumerOrderProcessingId);
		userContext.getChecker().checkVersionOfConsumerOrderProcessing( consumerOrderProcessingVersion);
		

		if(ConsumerOrderProcessing.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfConsumerOrderProcessing(parseString(newValueExpr));
		}
		if(ConsumerOrderProcessing.PROCESS_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkProcessTimeOfConsumerOrderProcessing(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderProcessingManagerException.class);
	
		
	}
	
	
	
	public ConsumerOrderProcessing clone(RetailscmUserContext userContext, String fromConsumerOrderProcessingId) throws Exception{
		
		return userContext.getDAOGroup().getConsumerOrderProcessingDAO().clone(fromConsumerOrderProcessingId, this.allTokens());
	}
	
	public ConsumerOrderProcessing internalSaveConsumerOrderProcessing(RetailscmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing) throws Exception 
	{
		return internalSaveConsumerOrderProcessing(userContext, consumerOrderProcessing, allTokens());

	}
	public ConsumerOrderProcessing internalSaveConsumerOrderProcessing(RetailscmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingConsumerOrderProcessing(userContext, consumerOrderProcessingId, consumerOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(consumerOrderProcessing){ 
			//will be good when the consumerOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderProcessing.
			
			
			consumerOrderProcessing = saveConsumerOrderProcessing(userContext, consumerOrderProcessing, options);
			return consumerOrderProcessing;
			
		}

	}
	
	public ConsumerOrderProcessing updateConsumerOrderProcessing(RetailscmUserContext userContext,String consumerOrderProcessingId, int consumerOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderProcessing(userContext, consumerOrderProcessingId, consumerOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		
		
		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing(userContext, consumerOrderProcessingId, allTokens());
		if(consumerOrderProcessing.getVersion() != consumerOrderProcessingVersion){
			String message = "The target version("+consumerOrderProcessing.getVersion()+") is not equals to version("+consumerOrderProcessingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderProcessing){ 
			//will be good when the consumerOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderProcessing.
			
			consumerOrderProcessing.changeProperty(property, newValueExpr);
			consumerOrderProcessing = saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens().done());
			return present(userContext,consumerOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens().done());
		}

	}
	
	public ConsumerOrderProcessing updateConsumerOrderProcessingProperty(RetailscmUserContext userContext,String consumerOrderProcessingId, int consumerOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderProcessing(userContext, consumerOrderProcessingId, consumerOrderProcessingVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderProcessing consumerOrderProcessing = loadConsumerOrderProcessing(userContext, consumerOrderProcessingId, allTokens());
		if(consumerOrderProcessing.getVersion() != consumerOrderProcessingVersion){
			String message = "The target version("+consumerOrderProcessing.getVersion()+") is not equals to version("+consumerOrderProcessingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderProcessing){ 
			//will be good when the consumerOrderProcessing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderProcessing.
			
			consumerOrderProcessing.changeProperty(property, newValueExpr);
			
			consumerOrderProcessing = saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens().done());
			return present(userContext,consumerOrderProcessing, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderProcessing(userContext, consumerOrderProcessing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderProcessingTokens tokens(){
		return ConsumerOrderProcessingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderProcessingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderProcessingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String consumerOrderProcessingId, int consumerOrderProcessingVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderProcessingId, consumerOrderProcessingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderProcessingId, int consumerOrderProcessingVersion) throws Exception{
			
		userContext.getDAOGroup().getConsumerOrderProcessingDAO().delete(consumerOrderProcessingId, consumerOrderProcessingVersion);
	}
	
	public ConsumerOrderProcessing forgetByAll(RetailscmUserContext userContext, String consumerOrderProcessingId, int consumerOrderProcessingVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderProcessingId, consumerOrderProcessingVersion);		
	}
	protected ConsumerOrderProcessing forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderProcessingId, int consumerOrderProcessingVersion) throws Exception{
			
		return userContext.getDAOGroup().getConsumerOrderProcessingDAO().disconnectFromAll(consumerOrderProcessingId, consumerOrderProcessingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderProcessingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getConsumerOrderProcessingDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderProcessing newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


