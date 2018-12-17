
package com.doublechaintech.retailscm.consumerorderapproval;

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









public class ConsumerOrderApprovalManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderApprovalManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderApproval";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ConsumerOrderApprovalManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderApprovalManagerException(message);

	}
	
	

 	protected ConsumerOrderApproval saveConsumerOrderApproval(RetailscmUserContext userContext, ConsumerOrderApproval consumerOrderApproval, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderApprovalDAO().save(consumerOrderApproval, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderApproval(userContext, consumerOrderApproval, tokens);
 	}
 	
 	protected ConsumerOrderApproval saveConsumerOrderApprovalDetail(RetailscmUserContext userContext, ConsumerOrderApproval consumerOrderApproval) throws Exception{	

 		
 		return saveConsumerOrderApproval(userContext, consumerOrderApproval, allTokens());
 	}
 	
 	public ConsumerOrderApproval loadConsumerOrderApproval(RetailscmUserContext userContext, String consumerOrderApprovalId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderApproval(consumerOrderApprovalId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderApprovalManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderApproval consumerOrderApproval = loadConsumerOrderApproval( userContext, consumerOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderApproval, tokens);
 	}
 	
 	
 	 public ConsumerOrderApproval searchConsumerOrderApproval(RetailscmUserContext userContext, String consumerOrderApprovalId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderApproval(consumerOrderApprovalId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderApprovalManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderApproval consumerOrderApproval = loadConsumerOrderApproval( userContext, consumerOrderApprovalId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderApproval, tokens);
 	}
 	
 	

 	protected ConsumerOrderApproval present(RetailscmUserContext userContext, ConsumerOrderApproval consumerOrderApproval, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderApproval,tokens);
		
		
		ConsumerOrderApproval  consumerOrderApprovalToPresent = userContext.getDAOGroup().getConsumerOrderApprovalDAO().present(consumerOrderApproval, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderApprovalToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getConsumerOrderApprovalDAO().alias(entityListToNaming);
		
		return  consumerOrderApprovalToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderApproval loadConsumerOrderApprovalDetail(RetailscmUserContext userContext, String consumerOrderApprovalId) throws Exception{	
 		ConsumerOrderApproval consumerOrderApproval = loadConsumerOrderApproval( userContext, consumerOrderApprovalId, allTokens());
 		return present(userContext,consumerOrderApproval, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String consumerOrderApprovalId) throws Exception{	
 		ConsumerOrderApproval consumerOrderApproval = loadConsumerOrderApproval( userContext, consumerOrderApprovalId, viewTokens());
 		return present(userContext,consumerOrderApproval, allTokens());
		
 	}
 	protected ConsumerOrderApproval saveConsumerOrderApproval(RetailscmUserContext userContext, ConsumerOrderApproval consumerOrderApproval, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getConsumerOrderApprovalDAO().save(consumerOrderApproval, tokens);
 	}
 	protected ConsumerOrderApproval loadConsumerOrderApproval(RetailscmUserContext userContext, String consumerOrderApprovalId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfConsumerOrderApproval(consumerOrderApprovalId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderApprovalManagerException.class);

 
 		return userContext.getDAOGroup().getConsumerOrderApprovalDAO().load(consumerOrderApprovalId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderApproval consumerOrderApproval, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderApproval, tokens);
		
		addAction(userContext, consumerOrderApproval, tokens,"@create","createConsumerOrderApproval","createConsumerOrderApproval/","main","primary");
		addAction(userContext, consumerOrderApproval, tokens,"@update","updateConsumerOrderApproval","updateConsumerOrderApproval/"+consumerOrderApproval.getId()+"/","main","primary");
		addAction(userContext, consumerOrderApproval, tokens,"@copy","cloneConsumerOrderApproval","cloneConsumerOrderApproval/"+consumerOrderApproval.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderApproval consumerOrderApproval, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderApproval createConsumerOrderApproval(RetailscmUserContext userContext,String who, Date approveTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfConsumerOrderApproval(who);
		userContext.getChecker().checkApproveTimeOfConsumerOrderApproval(approveTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderApprovalManagerException.class);


		ConsumerOrderApproval consumerOrderApproval=createNewConsumerOrderApproval();	

		consumerOrderApproval.setWho(who);
		consumerOrderApproval.setApproveTime(approveTime);

		consumerOrderApproval = saveConsumerOrderApproval(userContext, consumerOrderApproval, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderApproval);
		return consumerOrderApproval;

		
	}
	protected ConsumerOrderApproval createNewConsumerOrderApproval() 
	{
		
		return new ConsumerOrderApproval();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderApproval(RetailscmUserContext userContext,String consumerOrderApprovalId, int consumerOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfConsumerOrderApproval(consumerOrderApprovalId);
		userContext.getChecker().checkVersionOfConsumerOrderApproval( consumerOrderApprovalVersion);
		

		if(ConsumerOrderApproval.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfConsumerOrderApproval(parseString(newValueExpr));
		}
		if(ConsumerOrderApproval.APPROVE_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkApproveTimeOfConsumerOrderApproval(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderApprovalManagerException.class);
	
		
	}
	
	
	
	public ConsumerOrderApproval clone(RetailscmUserContext userContext, String fromConsumerOrderApprovalId) throws Exception{
		
		return userContext.getDAOGroup().getConsumerOrderApprovalDAO().clone(fromConsumerOrderApprovalId, this.allTokens());
	}
	
	public ConsumerOrderApproval internalSaveConsumerOrderApproval(RetailscmUserContext userContext, ConsumerOrderApproval consumerOrderApproval) throws Exception 
	{
		return internalSaveConsumerOrderApproval(userContext, consumerOrderApproval, allTokens());

	}
	public ConsumerOrderApproval internalSaveConsumerOrderApproval(RetailscmUserContext userContext, ConsumerOrderApproval consumerOrderApproval, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingConsumerOrderApproval(userContext, consumerOrderApprovalId, consumerOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(consumerOrderApproval){ 
			//will be good when the consumerOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderApproval.
			
			
			consumerOrderApproval = saveConsumerOrderApproval(userContext, consumerOrderApproval, options);
			return consumerOrderApproval;
			
		}

	}
	
	public ConsumerOrderApproval updateConsumerOrderApproval(RetailscmUserContext userContext,String consumerOrderApprovalId, int consumerOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderApproval(userContext, consumerOrderApprovalId, consumerOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		
		
		ConsumerOrderApproval consumerOrderApproval = loadConsumerOrderApproval(userContext, consumerOrderApprovalId, allTokens());
		if(consumerOrderApproval.getVersion() != consumerOrderApprovalVersion){
			String message = "The target version("+consumerOrderApproval.getVersion()+") is not equals to version("+consumerOrderApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderApproval){ 
			//will be good when the consumerOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderApproval.
			
			consumerOrderApproval.changeProperty(property, newValueExpr);
			consumerOrderApproval = saveConsumerOrderApproval(userContext, consumerOrderApproval, tokens().done());
			return present(userContext,consumerOrderApproval, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderApproval(userContext, consumerOrderApproval, tokens().done());
		}

	}
	
	public ConsumerOrderApproval updateConsumerOrderApprovalProperty(RetailscmUserContext userContext,String consumerOrderApprovalId, int consumerOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderApproval(userContext, consumerOrderApprovalId, consumerOrderApprovalVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderApproval consumerOrderApproval = loadConsumerOrderApproval(userContext, consumerOrderApprovalId, allTokens());
		if(consumerOrderApproval.getVersion() != consumerOrderApprovalVersion){
			String message = "The target version("+consumerOrderApproval.getVersion()+") is not equals to version("+consumerOrderApprovalVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderApproval){ 
			//will be good when the consumerOrderApproval loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderApproval.
			
			consumerOrderApproval.changeProperty(property, newValueExpr);
			
			consumerOrderApproval = saveConsumerOrderApproval(userContext, consumerOrderApproval, tokens().done());
			return present(userContext,consumerOrderApproval, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderApproval(userContext, consumerOrderApproval, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderApprovalTokens tokens(){
		return ConsumerOrderApprovalTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderApprovalTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderApprovalTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String consumerOrderApprovalId, int consumerOrderApprovalVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderApprovalId, consumerOrderApprovalVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderApprovalId, int consumerOrderApprovalVersion) throws Exception{
			
		userContext.getDAOGroup().getConsumerOrderApprovalDAO().delete(consumerOrderApprovalId, consumerOrderApprovalVersion);
	}
	
	public ConsumerOrderApproval forgetByAll(RetailscmUserContext userContext, String consumerOrderApprovalId, int consumerOrderApprovalVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderApprovalId, consumerOrderApprovalVersion);		
	}
	protected ConsumerOrderApproval forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderApprovalId, int consumerOrderApprovalVersion) throws Exception{
			
		return userContext.getDAOGroup().getConsumerOrderApprovalDAO().disconnectFromAll(consumerOrderApprovalId, consumerOrderApprovalVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderApprovalManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getConsumerOrderApprovalDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderApproval newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


