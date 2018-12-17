
package com.doublechaintech.retailscm.transporttasktrack;

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

import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.transporttask.CandidateTransportTask;







public class TransportTaskTrackManagerImpl extends CustomRetailscmCheckerManager implements TransportTaskTrackManager {
	
	private static final String SERVICE_TYPE = "TransportTaskTrack";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TransportTaskTrackManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TransportTaskTrackManagerException(message);

	}
	
	

 	protected TransportTaskTrack saveTransportTaskTrack(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, String [] tokensExpr) throws Exception{	
 		//return getTransportTaskTrackDAO().save(transportTaskTrack, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportTaskTrack(userContext, transportTaskTrack, tokens);
 	}
 	
 	protected TransportTaskTrack saveTransportTaskTrackDetail(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception{	

 		
 		return saveTransportTaskTrack(userContext, transportTaskTrack, allTokens());
 	}
 	
 	public TransportTaskTrack loadTransportTaskTrack(RetailscmUserContext userContext, String transportTaskTrackId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTaskTrackManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTaskTrack, tokens);
 	}
 	
 	
 	 public TransportTaskTrack searchTransportTaskTrack(RetailscmUserContext userContext, String transportTaskTrackId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTaskTrackManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTaskTrack, tokens);
 	}
 	
 	

 	protected TransportTaskTrack present(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportTaskTrack,tokens);
		
		
		TransportTaskTrack  transportTaskTrackToPresent = userContext.getDAOGroup().getTransportTaskTrackDAO().present(transportTaskTrack, tokens);
		
		List<BaseEntity> entityListToNaming = transportTaskTrackToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTransportTaskTrackDAO().alias(entityListToNaming);
		
		return  transportTaskTrackToPresent;
		
		
	}
 
 	
 	
 	public TransportTaskTrack loadTransportTaskTrackDetail(RetailscmUserContext userContext, String transportTaskTrackId) throws Exception{	
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, allTokens());
 		return present(userContext,transportTaskTrack, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String transportTaskTrackId) throws Exception{	
 		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack( userContext, transportTaskTrackId, viewTokens());
 		return present(userContext,transportTaskTrack, allTokens());
		
 	}
 	protected TransportTaskTrack saveTransportTaskTrack(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTransportTaskTrackDAO().save(transportTaskTrack, tokens);
 	}
 	protected TransportTaskTrack loadTransportTaskTrack(RetailscmUserContext userContext, String transportTaskTrackId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
		userContext.getChecker().throwExceptionIfHasErrors( TransportTaskTrackManagerException.class);

 
 		return userContext.getDAOGroup().getTransportTaskTrackDAO().load(transportTaskTrackId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens){
		super.addActions(userContext, transportTaskTrack, tokens);
		
		addAction(userContext, transportTaskTrack, tokens,"@create","createTransportTaskTrack","createTransportTaskTrack/","main","primary");
		addAction(userContext, transportTaskTrack, tokens,"@update","updateTransportTaskTrack","updateTransportTaskTrack/"+transportTaskTrack.getId()+"/","main","primary");
		addAction(userContext, transportTaskTrack, tokens,"@copy","cloneTransportTaskTrack","cloneTransportTaskTrack/"+transportTaskTrack.getId()+"/","main","primary");
		
		addAction(userContext, transportTaskTrack, tokens,"transport_task_track.transfer_to_movement","transferToAnotherMovement","transferToAnotherMovement/"+transportTaskTrack.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransportTaskTrack createTransportTaskTrack(RetailscmUserContext userContext,Date trackTime, BigDecimal latitude, BigDecimal longitude, String movementId) throws Exception
	{
		
		

		

		userContext.getChecker().checkTrackTimeOfTransportTaskTrack(trackTime);
		userContext.getChecker().checkLatitudeOfTransportTaskTrack(latitude);
		userContext.getChecker().checkLongitudeOfTransportTaskTrack(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);


		TransportTaskTrack transportTaskTrack=createNewTransportTaskTrack();	

		transportTaskTrack.setTrackTime(trackTime);
		transportTaskTrack.setLatitude(latitude);
		transportTaskTrack.setLongitude(longitude);
			
		TransportTask movement = loadTransportTask(userContext, movementId,emptyOptions());
		transportTaskTrack.setMovement(movement);
		
		

		transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, emptyOptions());
		
		onNewInstanceCreated(userContext, transportTaskTrack);
		return transportTaskTrack;

		
	}
	protected TransportTaskTrack createNewTransportTaskTrack() 
	{
		
		return new TransportTaskTrack();		
	}
	
	protected void checkParamsForUpdatingTransportTaskTrack(RetailscmUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
		userContext.getChecker().checkVersionOfTransportTaskTrack( transportTaskTrackVersion);
		

		if(TransportTaskTrack.TRACK_TIME_PROPERTY.equals(property)){
			userContext.getChecker().checkTrackTimeOfTransportTaskTrack(parseDate(newValueExpr));
		}
		if(TransportTaskTrack.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfTransportTaskTrack(parseBigDecimal(newValueExpr));
		}
		if(TransportTaskTrack.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfTransportTaskTrack(parseBigDecimal(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);
	
		
	}
	
	
	
	public TransportTaskTrack clone(RetailscmUserContext userContext, String fromTransportTaskTrackId) throws Exception{
		
		return userContext.getDAOGroup().getTransportTaskTrackDAO().clone(fromTransportTaskTrackId, this.allTokens());
	}
	
	public TransportTaskTrack internalSaveTransportTaskTrack(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception 
	{
		return internalSaveTransportTaskTrack(userContext, transportTaskTrack, allTokens());

	}
	public TransportTaskTrack internalSaveTransportTaskTrack(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(transportTaskTrack){ 
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskTrack.
			
			
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, options);
			return transportTaskTrack;
			
		}

	}
	
	public TransportTaskTrack updateTransportTaskTrack(RetailscmUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr, tokensExpr);
		
		
		
		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());
		if(transportTaskTrack.getVersion() != transportTaskTrackVersion){
			String message = "The target version("+transportTaskTrack.getVersion()+") is not equals to version("+transportTaskTrackVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTaskTrack){ 
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskTrack.
			
			transportTaskTrack.changeProperty(property, newValueExpr);
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
			return present(userContext,transportTaskTrack, mergedAllTokens(tokensExpr));
			//return saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
		}

	}
	
	public TransportTaskTrack updateTransportTaskTrackProperty(RetailscmUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr, tokensExpr);
		
		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());
		if(transportTaskTrack.getVersion() != transportTaskTrackVersion){
			String message = "The target version("+transportTaskTrack.getVersion()+") is not equals to version("+transportTaskTrackVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportTaskTrack){ 
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTaskTrack.
			
			transportTaskTrack.changeProperty(property, newValueExpr);
			
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
			return present(userContext,transportTaskTrack, mergedAllTokens(tokensExpr));
			//return saveTransportTaskTrack(userContext, transportTaskTrack, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransportTaskTrackTokens tokens(){
		return TransportTaskTrackTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportTaskTrackTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportTaskTrackTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherMovement(RetailscmUserContext userContext, String transportTaskTrackId, String anotherMovementId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTransportTaskTrack(transportTaskTrackId);
 		userContext.getChecker().checkIdOfTransportTask(anotherMovementId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TransportTaskTrackManagerException.class);
 		
 	}
 	public TransportTaskTrack transferToAnotherMovement(RetailscmUserContext userContext, String transportTaskTrackId, String anotherMovementId) throws Exception
 	{
 		checkParamsForTransferingAnotherMovement(userContext, transportTaskTrackId,anotherMovementId);
 
		TransportTaskTrack transportTaskTrack = loadTransportTaskTrack(userContext, transportTaskTrackId, allTokens());	
		synchronized(transportTaskTrack){
			//will be good when the transportTaskTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportTask movement = loadTransportTask(userContext, anotherMovementId, emptyOptions());		
			transportTaskTrack.updateMovement(movement);		
			transportTaskTrack = saveTransportTaskTrack(userContext, transportTaskTrack, emptyOptions());
			
			return present(userContext,transportTaskTrack, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateTransportTask requestCandidateMovement(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTransportTask result = new CandidateTransportTask();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TransportTask> candidateList = userContext.getDAOGroup().getTransportTaskDAO().requestCandidateTransportTaskForTransportTaskTrack(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected TransportTask loadTransportTask(RetailscmUserContext userContext, String newMovementId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getTransportTaskDAO().load(newMovementId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String transportTaskTrackId, int transportTaskTrackVersion) throws Exception {
		//deleteInternal(userContext, transportTaskTrackId, transportTaskTrackVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String transportTaskTrackId, int transportTaskTrackVersion) throws Exception{
			
		userContext.getDAOGroup().getTransportTaskTrackDAO().delete(transportTaskTrackId, transportTaskTrackVersion);
	}
	
	public TransportTaskTrack forgetByAll(RetailscmUserContext userContext, String transportTaskTrackId, int transportTaskTrackVersion) throws Exception {
		return forgetByAllInternal(userContext, transportTaskTrackId, transportTaskTrackVersion);		
	}
	protected TransportTaskTrack forgetByAllInternal(RetailscmUserContext userContext,
			String transportTaskTrackId, int transportTaskTrackVersion) throws Exception{
			
		return userContext.getDAOGroup().getTransportTaskTrackDAO().disconnectFromAll(transportTaskTrackId, transportTaskTrackVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportTaskTrackManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTransportTaskTrackDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, TransportTaskTrack newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


