
package com.doublechaintech.retailscm.consumerordershipment;

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









public class ConsumerOrderShipmentManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderShipmentManager {
	
	private static final String SERVICE_TYPE = "ConsumerOrderShipment";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ConsumerOrderShipmentManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderShipmentManagerException(message);

	}
	
	

 	protected ConsumerOrderShipment saveConsumerOrderShipment(RetailscmUserContext userContext, ConsumerOrderShipment consumerOrderShipment, String [] tokensExpr) throws Exception{	
 		//return getConsumerOrderShipmentDAO().save(consumerOrderShipment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens);
 	}
 	
 	protected ConsumerOrderShipment saveConsumerOrderShipmentDetail(RetailscmUserContext userContext, ConsumerOrderShipment consumerOrderShipment) throws Exception{	

 		
 		return saveConsumerOrderShipment(userContext, consumerOrderShipment, allTokens());
 	}
 	
 	public ConsumerOrderShipment loadConsumerOrderShipment(RetailscmUserContext userContext, String consumerOrderShipmentId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderShipment(consumerOrderShipmentId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderShipmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment( userContext, consumerOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderShipment, tokens);
 	}
 	
 	
 	 public ConsumerOrderShipment searchConsumerOrderShipment(RetailscmUserContext userContext, String consumerOrderShipmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfConsumerOrderShipment(consumerOrderShipmentId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderShipmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment( userContext, consumerOrderShipmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderShipment, tokens);
 	}
 	
 	

 	protected ConsumerOrderShipment present(RetailscmUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,consumerOrderShipment,tokens);
		
		
		ConsumerOrderShipment  consumerOrderShipmentToPresent = userContext.getDAOGroup().getConsumerOrderShipmentDAO().present(consumerOrderShipment, tokens);
		
		List<BaseEntity> entityListToNaming = consumerOrderShipmentToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getConsumerOrderShipmentDAO().alias(entityListToNaming);
		
		return  consumerOrderShipmentToPresent;
		
		
	}
 
 	
 	
 	public ConsumerOrderShipment loadConsumerOrderShipmentDetail(RetailscmUserContext userContext, String consumerOrderShipmentId) throws Exception{	
 		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment( userContext, consumerOrderShipmentId, allTokens());
 		return present(userContext,consumerOrderShipment, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String consumerOrderShipmentId) throws Exception{	
 		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment( userContext, consumerOrderShipmentId, viewTokens());
 		return present(userContext,consumerOrderShipment, allTokens());
		
 	}
 	protected ConsumerOrderShipment saveConsumerOrderShipment(RetailscmUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getConsumerOrderShipmentDAO().save(consumerOrderShipment, tokens);
 	}
 	protected ConsumerOrderShipment loadConsumerOrderShipment(RetailscmUserContext userContext, String consumerOrderShipmentId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfConsumerOrderShipment(consumerOrderShipmentId);
		userContext.getChecker().throwExceptionIfHasErrors( ConsumerOrderShipmentManagerException.class);

 
 		return userContext.getDAOGroup().getConsumerOrderShipmentDAO().load(consumerOrderShipmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderShipment, tokens);
		
		addAction(userContext, consumerOrderShipment, tokens,"@create","createConsumerOrderShipment","createConsumerOrderShipment/","main","primary");
		addAction(userContext, consumerOrderShipment, tokens,"@update","updateConsumerOrderShipment","updateConsumerOrderShipment/"+consumerOrderShipment.getId()+"/","main","primary");
		addAction(userContext, consumerOrderShipment, tokens,"@copy","cloneConsumerOrderShipment","cloneConsumerOrderShipment/"+consumerOrderShipment.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ConsumerOrderShipment createConsumerOrderShipment(RetailscmUserContext userContext,String who, Date shipTime) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfConsumerOrderShipment(who);
		userContext.getChecker().checkShipTimeOfConsumerOrderShipment(shipTime);
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderShipmentManagerException.class);


		ConsumerOrderShipment consumerOrderShipment=createNewConsumerOrderShipment();	

		consumerOrderShipment.setWho(who);
		consumerOrderShipment.setShipTime(shipTime);

		consumerOrderShipment = saveConsumerOrderShipment(userContext, consumerOrderShipment, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderShipment);
		return consumerOrderShipment;

		
	}
	protected ConsumerOrderShipment createNewConsumerOrderShipment() 
	{
		
		return new ConsumerOrderShipment();		
	}
	
	protected void checkParamsForUpdatingConsumerOrderShipment(RetailscmUserContext userContext,String consumerOrderShipmentId, int consumerOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfConsumerOrderShipment(consumerOrderShipmentId);
		userContext.getChecker().checkVersionOfConsumerOrderShipment( consumerOrderShipmentVersion);
		

		if(ConsumerOrderShipment.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfConsumerOrderShipment(parseString(newValueExpr));
		}
		if(ConsumerOrderShipment.SHIP_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkShipTimeOfConsumerOrderShipment(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(ConsumerOrderShipmentManagerException.class);
	
		
	}
	
	
	
	public ConsumerOrderShipment clone(RetailscmUserContext userContext, String fromConsumerOrderShipmentId) throws Exception{
		
		return userContext.getDAOGroup().getConsumerOrderShipmentDAO().clone(fromConsumerOrderShipmentId, this.allTokens());
	}
	
	public ConsumerOrderShipment internalSaveConsumerOrderShipment(RetailscmUserContext userContext, ConsumerOrderShipment consumerOrderShipment) throws Exception 
	{
		return internalSaveConsumerOrderShipment(userContext, consumerOrderShipment, allTokens());

	}
	public ConsumerOrderShipment internalSaveConsumerOrderShipment(RetailscmUserContext userContext, ConsumerOrderShipment consumerOrderShipment, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingConsumerOrderShipment(userContext, consumerOrderShipmentId, consumerOrderShipmentVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(consumerOrderShipment){ 
			//will be good when the consumerOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShipment.
			
			
			consumerOrderShipment = saveConsumerOrderShipment(userContext, consumerOrderShipment, options);
			return consumerOrderShipment;
			
		}

	}
	
	public ConsumerOrderShipment updateConsumerOrderShipment(RetailscmUserContext userContext,String consumerOrderShipmentId, int consumerOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderShipment(userContext, consumerOrderShipmentId, consumerOrderShipmentVersion, property, newValueExpr, tokensExpr);
		
		
		
		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment(userContext, consumerOrderShipmentId, allTokens());
		if(consumerOrderShipment.getVersion() != consumerOrderShipmentVersion){
			String message = "The target version("+consumerOrderShipment.getVersion()+") is not equals to version("+consumerOrderShipmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderShipment){ 
			//will be good when the consumerOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShipment.
			
			consumerOrderShipment.changeProperty(property, newValueExpr);
			consumerOrderShipment = saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens().done());
			return present(userContext,consumerOrderShipment, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens().done());
		}

	}
	
	public ConsumerOrderShipment updateConsumerOrderShipmentProperty(RetailscmUserContext userContext,String consumerOrderShipmentId, int consumerOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingConsumerOrderShipment(userContext, consumerOrderShipmentId, consumerOrderShipmentVersion, property, newValueExpr, tokensExpr);
		
		ConsumerOrderShipment consumerOrderShipment = loadConsumerOrderShipment(userContext, consumerOrderShipmentId, allTokens());
		if(consumerOrderShipment.getVersion() != consumerOrderShipmentVersion){
			String message = "The target version("+consumerOrderShipment.getVersion()+") is not equals to version("+consumerOrderShipmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderShipment){ 
			//will be good when the consumerOrderShipment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShipment.
			
			consumerOrderShipment.changeProperty(property, newValueExpr);
			
			consumerOrderShipment = saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens().done());
			return present(userContext,consumerOrderShipment, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderShipment(userContext, consumerOrderShipment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ConsumerOrderShipmentTokens tokens(){
		return ConsumerOrderShipmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderShipmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ConsumerOrderShipmentTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String consumerOrderShipmentId, int consumerOrderShipmentVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderShipmentId, consumerOrderShipmentVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderShipmentId, int consumerOrderShipmentVersion) throws Exception{
			
		userContext.getDAOGroup().getConsumerOrderShipmentDAO().delete(consumerOrderShipmentId, consumerOrderShipmentVersion);
	}
	
	public ConsumerOrderShipment forgetByAll(RetailscmUserContext userContext, String consumerOrderShipmentId, int consumerOrderShipmentVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderShipmentId, consumerOrderShipmentVersion);		
	}
	protected ConsumerOrderShipment forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderShipmentId, int consumerOrderShipmentVersion) throws Exception{
			
		return userContext.getDAOGroup().getConsumerOrderShipmentDAO().disconnectFromAll(consumerOrderShipmentId, consumerOrderShipmentVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderShipmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getConsumerOrderShipmentDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderShipment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


