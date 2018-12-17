
package com.doublechaintech.retailscm.cityevent;

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

import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstorecityservicecenter.CandidateRetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEvent;






public class CityEventManagerImpl extends CustomRetailscmCheckerManager implements CityEventManager {
	
	private static final String SERVICE_TYPE = "CityEvent";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws CityEventManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new CityEventManagerException(message);

	}
	
	

 	protected CityEvent saveCityEvent(RetailscmUserContext userContext, CityEvent cityEvent, String [] tokensExpr) throws Exception{	
 		//return getCityEventDAO().save(cityEvent, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCityEvent(userContext, cityEvent, tokens);
 	}
 	
 	protected CityEvent saveCityEventDetail(RetailscmUserContext userContext, CityEvent cityEvent) throws Exception{	

 		
 		return saveCityEvent(userContext, cityEvent, allTokens());
 	}
 	
 	public CityEvent loadCityEvent(RetailscmUserContext userContext, String cityEventId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCityEvent(cityEventId);
		userContext.getChecker().throwExceptionIfHasErrors( CityEventManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CityEvent cityEvent = loadCityEvent( userContext, cityEventId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityEvent, tokens);
 	}
 	
 	
 	 public CityEvent searchCityEvent(RetailscmUserContext userContext, String cityEventId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCityEvent(cityEventId);
		userContext.getChecker().throwExceptionIfHasErrors( CityEventManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		CityEvent cityEvent = loadCityEvent( userContext, cityEventId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityEvent, tokens);
 	}
 	
 	

 	protected CityEvent present(RetailscmUserContext userContext, CityEvent cityEvent, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,cityEvent,tokens);
		
		
		CityEvent  cityEventToPresent = userContext.getDAOGroup().getCityEventDAO().present(cityEvent, tokens);
		
		List<BaseEntity> entityListToNaming = cityEventToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getCityEventDAO().alias(entityListToNaming);
		
		return  cityEventToPresent;
		
		
	}
 
 	
 	
 	public CityEvent loadCityEventDetail(RetailscmUserContext userContext, String cityEventId) throws Exception{	
 		CityEvent cityEvent = loadCityEvent( userContext, cityEventId, allTokens());
 		return present(userContext,cityEvent, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String cityEventId) throws Exception{	
 		CityEvent cityEvent = loadCityEvent( userContext, cityEventId, viewTokens());
 		return present(userContext,cityEvent, allTokens());
		
 	}
 	protected CityEvent saveCityEvent(RetailscmUserContext userContext, CityEvent cityEvent, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getCityEventDAO().save(cityEvent, tokens);
 	}
 	protected CityEvent loadCityEvent(RetailscmUserContext userContext, String cityEventId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfCityEvent(cityEventId);
		userContext.getChecker().throwExceptionIfHasErrors( CityEventManagerException.class);

 
 		return userContext.getDAOGroup().getCityEventDAO().load(cityEventId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, CityEvent cityEvent, Map<String, Object> tokens){
		super.addActions(userContext, cityEvent, tokens);
		
		addAction(userContext, cityEvent, tokens,"@create","createCityEvent","createCityEvent/","main","primary");
		addAction(userContext, cityEvent, tokens,"@update","updateCityEvent","updateCityEvent/"+cityEvent.getId()+"/","main","primary");
		addAction(userContext, cityEvent, tokens,"@copy","cloneCityEvent","cloneCityEvent/"+cityEvent.getId()+"/","main","primary");
		
		addAction(userContext, cityEvent, tokens,"city_event.transfer_to_city_service_center","transferToAnotherCityServiceCenter","transferToAnotherCityServiceCenter/"+cityEvent.getId()+"/","main","primary");
		addAction(userContext, cityEvent, tokens,"city_event.addEventAttendance","addEventAttendance","addEventAttendance/"+cityEvent.getId()+"/","eventAttendanceList","primary");
		addAction(userContext, cityEvent, tokens,"city_event.removeEventAttendance","removeEventAttendance","removeEventAttendance/"+cityEvent.getId()+"/","eventAttendanceList","primary");
		addAction(userContext, cityEvent, tokens,"city_event.updateEventAttendance","updateEventAttendance","updateEventAttendance/"+cityEvent.getId()+"/","eventAttendanceList","primary");
		addAction(userContext, cityEvent, tokens,"city_event.copyEventAttendanceFrom","copyEventAttendanceFrom","copyEventAttendanceFrom/"+cityEvent.getId()+"/","eventAttendanceList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, CityEvent cityEvent, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public CityEvent createCityEvent(RetailscmUserContext userContext,String name, String mobile, String cityServiceCenterId, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfCityEvent(name);
		userContext.getChecker().checkMobileOfCityEvent(mobile);
		userContext.getChecker().checkDescriptionOfCityEvent(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(CityEventManagerException.class);


		CityEvent cityEvent=createNewCityEvent();	

		cityEvent.setName(name);
		cityEvent.setMobile(mobile);
			
		RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(userContext, cityServiceCenterId,emptyOptions());
		cityEvent.setCityServiceCenter(cityServiceCenter);
		
		
		cityEvent.setDescription(description);
		cityEvent.setLastUpdateTime(userContext.now());

		cityEvent = saveCityEvent(userContext, cityEvent, emptyOptions());
		
		onNewInstanceCreated(userContext, cityEvent);
		return cityEvent;

		
	}
	protected CityEvent createNewCityEvent() 
	{
		
		return new CityEvent();		
	}
	
	protected void checkParamsForUpdatingCityEvent(RetailscmUserContext userContext,String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfCityEvent(cityEventId);
		userContext.getChecker().checkVersionOfCityEvent( cityEventVersion);
		

		if(CityEvent.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfCityEvent(parseString(newValueExpr));
		}
		if(CityEvent.MOBILE_PROPERTY.equals(property)){
			userContext.getChecker().checkMobileOfCityEvent(parseString(newValueExpr));
		}		

		
		if(CityEvent.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfCityEvent(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(CityEventManagerException.class);
	
		
	}
	
	
	
	public CityEvent clone(RetailscmUserContext userContext, String fromCityEventId) throws Exception{
		
		return userContext.getDAOGroup().getCityEventDAO().clone(fromCityEventId, this.allTokens());
	}
	
	public CityEvent internalSaveCityEvent(RetailscmUserContext userContext, CityEvent cityEvent) throws Exception 
	{
		return internalSaveCityEvent(userContext, cityEvent, allTokens());

	}
	public CityEvent internalSaveCityEvent(RetailscmUserContext userContext, CityEvent cityEvent, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingCityEvent(userContext, cityEventId, cityEventVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(cityEvent){ 
			//will be good when the cityEvent loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityEvent.
			
			
			cityEvent = saveCityEvent(userContext, cityEvent, options);
			return cityEvent;
			
		}

	}
	
	public CityEvent updateCityEvent(RetailscmUserContext userContext,String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCityEvent(userContext, cityEventId, cityEventVersion, property, newValueExpr, tokensExpr);
		
		
		
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		if(cityEvent.getVersion() != cityEventVersion){
			String message = "The target version("+cityEvent.getVersion()+") is not equals to version("+cityEventVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(cityEvent){ 
			//will be good when the cityEvent loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityEvent.
			cityEvent.updateLastUpdateTime(userContext.now());
			cityEvent.changeProperty(property, newValueExpr);
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().done());
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
			//return saveCityEvent(userContext, cityEvent, tokens().done());
		}

	}
	
	public CityEvent updateCityEventProperty(RetailscmUserContext userContext,String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCityEvent(userContext, cityEventId, cityEventVersion, property, newValueExpr, tokensExpr);
		
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		if(cityEvent.getVersion() != cityEventVersion){
			String message = "The target version("+cityEvent.getVersion()+") is not equals to version("+cityEventVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(cityEvent){ 
			//will be good when the cityEvent loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityEvent.
			
			cityEvent.changeProperty(property, newValueExpr);
			cityEvent.updateLastUpdateTime(userContext.now());
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().done());
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
			//return saveCityEvent(userContext, cityEvent, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CityEventTokens tokens(){
		return CityEventTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CityEventTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEventAttendanceListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CityEventTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCityServiceCenter(RetailscmUserContext userContext, String cityEventId, String anotherCityServiceCenterId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfCityEvent(cityEventId);
 		userContext.getChecker().checkIdOfRetailStoreCityServiceCenter(anotherCityServiceCenterId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(CityEventManagerException.class);
 		
 	}
 	public CityEvent transferToAnotherCityServiceCenter(RetailscmUserContext userContext, String cityEventId, String anotherCityServiceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityServiceCenter(userContext, cityEventId,anotherCityServiceCenterId);
 
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());	
		synchronized(cityEvent){
			//will be good when the cityEvent loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(userContext, anotherCityServiceCenterId, emptyOptions());		
			cityEvent.updateCityServiceCenter(cityServiceCenter);		
			cityEvent = saveCityEvent(userContext, cityEvent, emptyOptions());
			
			return present(userContext,cityEvent, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCityServiceCenter requestCandidateCityServiceCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCityServiceCenter result = new CandidateRetailStoreCityServiceCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCityServiceCenter> candidateList = userContext.getDAOGroup().getRetailStoreCityServiceCenterDAO().requestCandidateRetailStoreCityServiceCenterForCityEvent(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(RetailscmUserContext userContext, String newCityServiceCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCityServiceCenterDAO().load(newCityServiceCenterId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String cityEventId, int cityEventVersion) throws Exception {
		//deleteInternal(userContext, cityEventId, cityEventVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String cityEventId, int cityEventVersion) throws Exception{
			
		userContext.getDAOGroup().getCityEventDAO().delete(cityEventId, cityEventVersion);
	}
	
	public CityEvent forgetByAll(RetailscmUserContext userContext, String cityEventId, int cityEventVersion) throws Exception {
		return forgetByAllInternal(userContext, cityEventId, cityEventVersion);		
	}
	protected CityEvent forgetByAllInternal(RetailscmUserContext userContext,
			String cityEventId, int cityEventVersion) throws Exception{
			
		return userContext.getDAOGroup().getCityEventDAO().disconnectFromAll(cityEventId, cityEventVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CityEventManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getCityEventDAO().deleteAll();
	}


	//disconnect CityEvent with potential_customer in EventAttendance
	protected CityEvent breakWithEventAttendanceByPotentialCustomer(RetailscmUserContext userContext, String cityEventId, String potentialCustomerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());

			synchronized(cityEvent){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCityEventDAO().planToRemoveEventAttendanceListWithPotentialCustomer(cityEvent, potentialCustomerId, this.emptyOptions());

				cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
				return cityEvent;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEventAttendance(RetailscmUserContext userContext, String cityEventId, String name, String potentialCustomerId, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfCityEvent(cityEventId);

		
		userContext.getChecker().checkNameOfEventAttendance(name);
		
		userContext.getChecker().checkPotentialCustomerIdOfEventAttendance(potentialCustomerId);
		
		userContext.getChecker().checkDescriptionOfEventAttendance(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(CityEventManagerException.class);

	
	}
	public  CityEvent addEventAttendance(RetailscmUserContext userContext, String cityEventId, String name, String potentialCustomerId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEventAttendance(userContext,cityEventId,name, potentialCustomerId, description,tokensExpr);
		
		EventAttendance eventAttendance = createEventAttendance(userContext,name, potentialCustomerId, description);
		
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		synchronized(cityEvent){ 
			//Will be good when the cityEvent loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityEvent.addEventAttendance( eventAttendance );		
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
			
			userContext.getManagerGroup().getEventAttendanceManager().onNewInstanceCreated(userContext, eventAttendance);
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEventAttendanceProperties(RetailscmUserContext userContext, String cityEventId,String id,String name,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCityEvent(cityEventId);
		userContext.getChecker().checkIdOfEventAttendance(id);
		
		userContext.getChecker().checkNameOfEventAttendance( name);
		userContext.getChecker().checkDescriptionOfEventAttendance( description);

		userContext.getChecker().throwExceptionIfHasErrors(CityEventManagerException.class);
		
	}
	public  CityEvent updateEventAttendanceProperties(RetailscmUserContext userContext, String cityEventId, String id,String name,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEventAttendanceProperties(userContext,cityEventId,id,name,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEventAttendanceListList()
				.searchEventAttendanceListWith(EventAttendance.ID_PROPERTY, "is", id).done();
		
		CityEvent cityEventToUpdate = loadCityEvent(userContext, cityEventId, options);
		
		if(cityEventToUpdate.getEventAttendanceList().isEmpty()){
			throw new CityEventManagerException("EventAttendance is NOT FOUND with id: '"+id+"'");
		}
		
		EventAttendance item = cityEventToUpdate.getEventAttendanceList().first();
		
		item.updateName( name );
		item.updateDescription( description );

		
		//checkParamsForAddingEventAttendance(userContext,cityEventId,name, code, used,tokensExpr);
		CityEvent cityEvent = saveCityEvent(userContext, cityEventToUpdate, tokens().withEventAttendanceList().done());
		synchronized(cityEvent){ 
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EventAttendance createEventAttendance(RetailscmUserContext userContext, String name, String potentialCustomerId, String description) throws Exception{

		EventAttendance eventAttendance = new EventAttendance();
		
		
		eventAttendance.setName(name);		
		PotentialCustomer  potentialCustomer = new PotentialCustomer();
		potentialCustomer.setId(potentialCustomerId);		
		eventAttendance.setPotentialCustomer(potentialCustomer);		
		eventAttendance.setDescription(description);
	
		
		return eventAttendance;
	
		
	}
	
	protected EventAttendance createIndexedEventAttendance(String id, int version){

		EventAttendance eventAttendance = new EventAttendance();
		eventAttendance.setId(id);
		eventAttendance.setVersion(version);
		return eventAttendance;			
		
	}
	
	protected void checkParamsForRemovingEventAttendanceList(RetailscmUserContext userContext, String cityEventId, 
			String eventAttendanceIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCityEvent(cityEventId);
		for(String eventAttendanceId: eventAttendanceIds){
			userContext.getChecker().checkIdOfEventAttendance(eventAttendanceId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(CityEventManagerException.class);
		
	}
	public  CityEvent removeEventAttendanceList(RetailscmUserContext userContext, String cityEventId, 
			String eventAttendanceIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEventAttendanceList(userContext, cityEventId,  eventAttendanceIds, tokensExpr);
			
			
			CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
			synchronized(cityEvent){ 
				//Will be good when the cityEvent loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getCityEventDAO().planToRemoveEventAttendanceList(cityEvent, eventAttendanceIds, allTokens());
				cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
				deleteRelationListInGraph(userContext, cityEvent.getEventAttendanceList());
				return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEventAttendance(RetailscmUserContext userContext, String cityEventId, 
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCityEvent( cityEventId);
		userContext.getChecker().checkIdOfEventAttendance(eventAttendanceId);
		userContext.getChecker().checkVersionOfEventAttendance(eventAttendanceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CityEventManagerException.class);
	
	}
	public  CityEvent removeEventAttendance(RetailscmUserContext userContext, String cityEventId, 
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEventAttendance(userContext,cityEventId, eventAttendanceId, eventAttendanceVersion,tokensExpr);
		
		EventAttendance eventAttendance = createIndexedEventAttendance(eventAttendanceId, eventAttendanceVersion);
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		synchronized(cityEvent){ 
			//Will be good when the cityEvent loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityEvent.removeEventAttendance( eventAttendance );		
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
			deleteRelationInGraph(userContext, eventAttendance);
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEventAttendance(RetailscmUserContext userContext, String cityEventId, 
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCityEvent( cityEventId);
		userContext.getChecker().checkIdOfEventAttendance(eventAttendanceId);
		userContext.getChecker().checkVersionOfEventAttendance(eventAttendanceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CityEventManagerException.class);
	
	}
	public  CityEvent copyEventAttendanceFrom(RetailscmUserContext userContext, String cityEventId, 
		String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEventAttendance(userContext,cityEventId, eventAttendanceId, eventAttendanceVersion,tokensExpr);
		
		EventAttendance eventAttendance = createIndexedEventAttendance(eventAttendanceId, eventAttendanceVersion);
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, allTokens());
		synchronized(cityEvent){ 
			//Will be good when the cityEvent loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			cityEvent.copyEventAttendanceFrom( eventAttendance );		
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
			
			userContext.getManagerGroup().getEventAttendanceManager().onNewInstanceCreated(userContext, (EventAttendance)cityEvent.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEventAttendance(RetailscmUserContext userContext, String cityEventId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfCityEvent(cityEventId);
		userContext.getChecker().checkIdOfEventAttendance(eventAttendanceId);
		userContext.getChecker().checkVersionOfEventAttendance(eventAttendanceVersion);
		

		if(EventAttendance.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfEventAttendance(parseString(newValueExpr));
		}
		
		if(EventAttendance.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfEventAttendance(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(CityEventManagerException.class);
	
	}
	
	public  CityEvent updateEventAttendance(RetailscmUserContext userContext, String cityEventId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEventAttendance(userContext, cityEventId, eventAttendanceId, eventAttendanceVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEventAttendanceList().searchEventAttendanceListWith(EventAttendance.ID_PROPERTY, "eq", eventAttendanceId).done();
		
		
		
		CityEvent cityEvent = loadCityEvent(userContext, cityEventId, loadTokens);
		
		synchronized(cityEvent){ 
			//Will be good when the cityEvent loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//cityEvent.removeEventAttendance( eventAttendance );	
			//make changes to AcceleraterAccount.
			EventAttendance eventAttendanceIndex = createIndexedEventAttendance(eventAttendanceId, eventAttendanceVersion);
		
			EventAttendance eventAttendance = cityEvent.findTheEventAttendance(eventAttendanceIndex);
			if(eventAttendance == null){
				throw new CityEventManagerException(eventAttendance+" is NOT FOUND" );
			}
			
			eventAttendance.changeProperty(property, newValueExpr);
			
			cityEvent = saveCityEvent(userContext, cityEvent, tokens().withEventAttendanceList().done());
			return present(userContext,cityEvent, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, CityEvent newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


