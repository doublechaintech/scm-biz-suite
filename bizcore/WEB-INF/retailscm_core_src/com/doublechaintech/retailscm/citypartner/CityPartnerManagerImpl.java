
package com.doublechaintech.retailscm.citypartner;

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

import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstorecityservicecenter.CandidateRetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;






public class CityPartnerManagerImpl extends CustomRetailscmCheckerManager implements CityPartnerManager {
	
	private static final String SERVICE_TYPE = "CityPartner";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws CityPartnerManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new CityPartnerManagerException(message);

	}
	
	

 	protected CityPartner saveCityPartner(RetailscmUserContext userContext, CityPartner cityPartner, String [] tokensExpr) throws Exception{	
 		//return getCityPartnerDAO().save(cityPartner, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCityPartner(userContext, cityPartner, tokens);
 	}
 	
 	protected CityPartner saveCityPartnerDetail(RetailscmUserContext userContext, CityPartner cityPartner) throws Exception{	

 		
 		return saveCityPartner(userContext, cityPartner, allTokens());
 	}
 	
 	public CityPartner loadCityPartner(RetailscmUserContext userContext, String cityPartnerId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);
		userContext.getChecker().throwExceptionIfHasErrors( CityPartnerManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CityPartner cityPartner = loadCityPartner( userContext, cityPartnerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityPartner, tokens);
 	}
 	
 	
 	 public CityPartner searchCityPartner(RetailscmUserContext userContext, String cityPartnerId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);
		userContext.getChecker().throwExceptionIfHasErrors( CityPartnerManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		CityPartner cityPartner = loadCityPartner( userContext, cityPartnerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityPartner, tokens);
 	}
 	
 	

 	protected CityPartner present(RetailscmUserContext userContext, CityPartner cityPartner, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,cityPartner,tokens);
		
		
		CityPartner  cityPartnerToPresent = userContext.getDAOGroup().getCityPartnerDAO().present(cityPartner, tokens);
		
		List<BaseEntity> entityListToNaming = cityPartnerToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getCityPartnerDAO().alias(entityListToNaming);
		
		return  cityPartnerToPresent;
		
		
	}
 
 	
 	
 	public CityPartner loadCityPartnerDetail(RetailscmUserContext userContext, String cityPartnerId) throws Exception{	
 		CityPartner cityPartner = loadCityPartner( userContext, cityPartnerId, allTokens());
 		return present(userContext,cityPartner, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String cityPartnerId) throws Exception{	
 		CityPartner cityPartner = loadCityPartner( userContext, cityPartnerId, viewTokens());
 		return present(userContext,cityPartner, allTokens());
		
 	}
 	protected CityPartner saveCityPartner(RetailscmUserContext userContext, CityPartner cityPartner, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getCityPartnerDAO().save(cityPartner, tokens);
 	}
 	protected CityPartner loadCityPartner(RetailscmUserContext userContext, String cityPartnerId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);
		userContext.getChecker().throwExceptionIfHasErrors( CityPartnerManagerException.class);

 
 		return userContext.getDAOGroup().getCityPartnerDAO().load(cityPartnerId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, CityPartner cityPartner, Map<String, Object> tokens){
		super.addActions(userContext, cityPartner, tokens);
		
		addAction(userContext, cityPartner, tokens,"@create","createCityPartner","createCityPartner/","main","primary");
		addAction(userContext, cityPartner, tokens,"@update","updateCityPartner","updateCityPartner/"+cityPartner.getId()+"/","main","primary");
		addAction(userContext, cityPartner, tokens,"@copy","cloneCityPartner","cloneCityPartner/"+cityPartner.getId()+"/","main","primary");
		
		addAction(userContext, cityPartner, tokens,"city_partner.transfer_to_city_service_center","transferToAnotherCityServiceCenter","transferToAnotherCityServiceCenter/"+cityPartner.getId()+"/","main","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.addPotentialCustomer","addPotentialCustomer","addPotentialCustomer/"+cityPartner.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.removePotentialCustomer","removePotentialCustomer","removePotentialCustomer/"+cityPartner.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.updatePotentialCustomer","updatePotentialCustomer","updatePotentialCustomer/"+cityPartner.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.copyPotentialCustomerFrom","copyPotentialCustomerFrom","copyPotentialCustomerFrom/"+cityPartner.getId()+"/","potentialCustomerList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.addPotentialCustomerContact","addPotentialCustomerContact","addPotentialCustomerContact/"+cityPartner.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.removePotentialCustomerContact","removePotentialCustomerContact","removePotentialCustomerContact/"+cityPartner.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.updatePotentialCustomerContact","updatePotentialCustomerContact","updatePotentialCustomerContact/"+cityPartner.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, cityPartner, tokens,"city_partner.copyPotentialCustomerContactFrom","copyPotentialCustomerContactFrom","copyPotentialCustomerContactFrom/"+cityPartner.getId()+"/","potentialCustomerContactList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, CityPartner cityPartner, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public CityPartner createCityPartner(RetailscmUserContext userContext,String name, String mobile, String cityServiceCenterId, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfCityPartner(name);
		userContext.getChecker().checkMobileOfCityPartner(mobile);
		userContext.getChecker().checkDescriptionOfCityPartner(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);


		CityPartner cityPartner=createNewCityPartner();	

		cityPartner.setName(name);
		cityPartner.setMobile(mobile);
			
		RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(userContext, cityServiceCenterId,emptyOptions());
		cityPartner.setCityServiceCenter(cityServiceCenter);
		
		
		cityPartner.setDescription(description);
		cityPartner.setLastUpdateTime(userContext.now());

		cityPartner = saveCityPartner(userContext, cityPartner, emptyOptions());
		
		onNewInstanceCreated(userContext, cityPartner);
		return cityPartner;

		
	}
	protected CityPartner createNewCityPartner() 
	{
		
		return new CityPartner();		
	}
	
	protected void checkParamsForUpdatingCityPartner(RetailscmUserContext userContext,String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);
		userContext.getChecker().checkVersionOfCityPartner( cityPartnerVersion);
		

		if(CityPartner.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfCityPartner(parseString(newValueExpr));
		}
		if(CityPartner.MOBILE_PROPERTY.equals(property)){
			userContext.getChecker().checkMobileOfCityPartner(parseString(newValueExpr));
		}		

		
		if(CityPartner.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfCityPartner(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);
	
		
	}
	
	
	
	public CityPartner clone(RetailscmUserContext userContext, String fromCityPartnerId) throws Exception{
		
		return userContext.getDAOGroup().getCityPartnerDAO().clone(fromCityPartnerId, this.allTokens());
	}
	
	public CityPartner internalSaveCityPartner(RetailscmUserContext userContext, CityPartner cityPartner) throws Exception 
	{
		return internalSaveCityPartner(userContext, cityPartner, allTokens());

	}
	public CityPartner internalSaveCityPartner(RetailscmUserContext userContext, CityPartner cityPartner, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingCityPartner(userContext, cityPartnerId, cityPartnerVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(cityPartner){ 
			//will be good when the cityPartner loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityPartner.
			
			
			cityPartner = saveCityPartner(userContext, cityPartner, options);
			return cityPartner;
			
		}

	}
	
	public CityPartner updateCityPartner(RetailscmUserContext userContext,String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCityPartner(userContext, cityPartnerId, cityPartnerVersion, property, newValueExpr, tokensExpr);
		
		
		
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		if(cityPartner.getVersion() != cityPartnerVersion){
			String message = "The target version("+cityPartner.getVersion()+") is not equals to version("+cityPartnerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(cityPartner){ 
			//will be good when the cityPartner loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityPartner.
			cityPartner.updateLastUpdateTime(userContext.now());
			cityPartner.changeProperty(property, newValueExpr);
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
			//return saveCityPartner(userContext, cityPartner, tokens().done());
		}

	}
	
	public CityPartner updateCityPartnerProperty(RetailscmUserContext userContext,String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCityPartner(userContext, cityPartnerId, cityPartnerVersion, property, newValueExpr, tokensExpr);
		
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		if(cityPartner.getVersion() != cityPartnerVersion){
			String message = "The target version("+cityPartner.getVersion()+") is not equals to version("+cityPartnerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(cityPartner){ 
			//will be good when the cityPartner loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CityPartner.
			
			cityPartner.changeProperty(property, newValueExpr);
			cityPartner.updateLastUpdateTime(userContext.now());
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
			//return saveCityPartner(userContext, cityPartner, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CityPartnerTokens tokens(){
		return CityPartnerTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CityPartnerTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortPotentialCustomerListWith("id","desc")
		.sortPotentialCustomerContactListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CityPartnerTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCityServiceCenter(RetailscmUserContext userContext, String cityPartnerId, String anotherCityServiceCenterId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);
 		userContext.getChecker().checkIdOfRetailStoreCityServiceCenter(anotherCityServiceCenterId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);
 		
 	}
 	public CityPartner transferToAnotherCityServiceCenter(RetailscmUserContext userContext, String cityPartnerId, String anotherCityServiceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityServiceCenter(userContext, cityPartnerId,anotherCityServiceCenterId);
 
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());	
		synchronized(cityPartner){
			//will be good when the cityPartner loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(userContext, anotherCityServiceCenterId, emptyOptions());		
			cityPartner.updateCityServiceCenter(cityServiceCenter);		
			cityPartner = saveCityPartner(userContext, cityPartner, emptyOptions());
			
			return present(userContext,cityPartner, allTokens());
			
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
		SmartList<RetailStoreCityServiceCenter> candidateList = userContext.getDAOGroup().getRetailStoreCityServiceCenterDAO().requestCandidateRetailStoreCityServiceCenterForCityPartner(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String cityPartnerId, int cityPartnerVersion) throws Exception {
		//deleteInternal(userContext, cityPartnerId, cityPartnerVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String cityPartnerId, int cityPartnerVersion) throws Exception{
			
		userContext.getDAOGroup().getCityPartnerDAO().delete(cityPartnerId, cityPartnerVersion);
	}
	
	public CityPartner forgetByAll(RetailscmUserContext userContext, String cityPartnerId, int cityPartnerVersion) throws Exception {
		return forgetByAllInternal(userContext, cityPartnerId, cityPartnerVersion);		
	}
	protected CityPartner forgetByAllInternal(RetailscmUserContext userContext,
			String cityPartnerId, int cityPartnerVersion) throws Exception{
			
		return userContext.getDAOGroup().getCityPartnerDAO().disconnectFromAll(cityPartnerId, cityPartnerVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CityPartnerManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getCityPartnerDAO().deleteAll();
	}


	//disconnect CityPartner with city_service_center in PotentialCustomer
	protected CityPartner breakWithPotentialCustomerByCityServiceCenter(RetailscmUserContext userContext, String cityPartnerId, String cityServiceCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());

			synchronized(cityPartner){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCityPartnerDAO().planToRemovePotentialCustomerListWithCityServiceCenter(cityPartner, cityServiceCenterId, this.emptyOptions());

				cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
				return cityPartner;
			}
	}
	//disconnect CityPartner with potential_customer in PotentialCustomerContact
	protected CityPartner breakWithPotentialCustomerContactByPotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, String potentialCustomerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());

			synchronized(cityPartner){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCityPartnerDAO().planToRemovePotentialCustomerContactListWithPotentialCustomer(cityPartner, potentialCustomerId, this.emptyOptions());

				cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
				return cityPartner;
			}
	}
	//disconnect CityPartner with contact_to in PotentialCustomerContact
	protected CityPartner breakWithPotentialCustomerContactByContactTo(RetailscmUserContext userContext, String cityPartnerId, String contactToId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());

			synchronized(cityPartner){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getCityPartnerDAO().planToRemovePotentialCustomerContactListWithContactTo(cityPartner, contactToId, this.emptyOptions());

				cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
				return cityPartner;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingPotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, String name, String mobile, String cityServiceCenterId, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);

		
		userContext.getChecker().checkNameOfPotentialCustomer(name);
		
		userContext.getChecker().checkMobileOfPotentialCustomer(mobile);
		
		userContext.getChecker().checkCityServiceCenterIdOfPotentialCustomer(cityServiceCenterId);
		
		userContext.getChecker().checkDescriptionOfPotentialCustomer(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);

	
	}
	public  CityPartner addPotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, String name, String mobile, String cityServiceCenterId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPotentialCustomer(userContext,cityPartnerId,name, mobile, cityServiceCenterId, description,tokensExpr);
		
		PotentialCustomer potentialCustomer = createPotentialCustomer(userContext,name, mobile, cityServiceCenterId, description);
		
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityPartner.addPotentialCustomer( potentialCustomer );		
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
			
			userContext.getManagerGroup().getPotentialCustomerManager().onNewInstanceCreated(userContext, potentialCustomer);
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPotentialCustomerProperties(RetailscmUserContext userContext, String cityPartnerId,String id,String name,String mobile,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);
		userContext.getChecker().checkIdOfPotentialCustomer(id);
		
		userContext.getChecker().checkNameOfPotentialCustomer( name);
		userContext.getChecker().checkMobileOfPotentialCustomer( mobile);
		userContext.getChecker().checkDescriptionOfPotentialCustomer( description);

		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);
		
	}
	public  CityPartner updatePotentialCustomerProperties(RetailscmUserContext userContext, String cityPartnerId, String id,String name,String mobile,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingPotentialCustomerProperties(userContext,cityPartnerId,id,name,mobile,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPotentialCustomerListList()
				.searchPotentialCustomerListWith(PotentialCustomer.ID_PROPERTY, "is", id).done();
		
		CityPartner cityPartnerToUpdate = loadCityPartner(userContext, cityPartnerId, options);
		
		if(cityPartnerToUpdate.getPotentialCustomerList().isEmpty()){
			throw new CityPartnerManagerException("PotentialCustomer is NOT FOUND with id: '"+id+"'");
		}
		
		PotentialCustomer item = cityPartnerToUpdate.getPotentialCustomerList().first();
		
		item.updateName( name );
		item.updateMobile( mobile );
		item.updateDescription( description );

		
		//checkParamsForAddingPotentialCustomer(userContext,cityPartnerId,name, code, used,tokensExpr);
		CityPartner cityPartner = saveCityPartner(userContext, cityPartnerToUpdate, tokens().withPotentialCustomerList().done());
		synchronized(cityPartner){ 
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected PotentialCustomer createPotentialCustomer(RetailscmUserContext userContext, String name, String mobile, String cityServiceCenterId, String description) throws Exception{

		PotentialCustomer potentialCustomer = new PotentialCustomer();
		
		
		potentialCustomer.setName(name);		
		potentialCustomer.setMobile(mobile);		
		RetailStoreCityServiceCenter  cityServiceCenter = new RetailStoreCityServiceCenter();
		cityServiceCenter.setId(cityServiceCenterId);		
		potentialCustomer.setCityServiceCenter(cityServiceCenter);		
		potentialCustomer.setDescription(description);		
		potentialCustomer.setLastUpdateTime(userContext.now());
	
		
		return potentialCustomer;
	
		
	}
	
	protected PotentialCustomer createIndexedPotentialCustomer(String id, int version){

		PotentialCustomer potentialCustomer = new PotentialCustomer();
		potentialCustomer.setId(id);
		potentialCustomer.setVersion(version);
		return potentialCustomer;			
		
	}
	
	protected void checkParamsForRemovingPotentialCustomerList(RetailscmUserContext userContext, String cityPartnerId, 
			String potentialCustomerIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);
		for(String potentialCustomerId: potentialCustomerIds){
			userContext.getChecker().checkIdOfPotentialCustomer(potentialCustomerId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);
		
	}
	public  CityPartner removePotentialCustomerList(RetailscmUserContext userContext, String cityPartnerId, 
			String potentialCustomerIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingPotentialCustomerList(userContext, cityPartnerId,  potentialCustomerIds, tokensExpr);
			
			
			CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
			synchronized(cityPartner){ 
				//Will be good when the cityPartner loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getCityPartnerDAO().planToRemovePotentialCustomerList(cityPartner, potentialCustomerIds, allTokens());
				cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
				deleteRelationListInGraph(userContext, cityPartner.getPotentialCustomerList());
				return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingPotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, 
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCityPartner( cityPartnerId);
		userContext.getChecker().checkIdOfPotentialCustomer(potentialCustomerId);
		userContext.getChecker().checkVersionOfPotentialCustomer(potentialCustomerVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);
	
	}
	public  CityPartner removePotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, 
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPotentialCustomer(userContext,cityPartnerId, potentialCustomerId, potentialCustomerVersion,tokensExpr);
		
		PotentialCustomer potentialCustomer = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityPartner.removePotentialCustomer( potentialCustomer );		
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
			deleteRelationInGraph(userContext, potentialCustomer);
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingPotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, 
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCityPartner( cityPartnerId);
		userContext.getChecker().checkIdOfPotentialCustomer(potentialCustomerId);
		userContext.getChecker().checkVersionOfPotentialCustomer(potentialCustomerVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);
	
	}
	public  CityPartner copyPotentialCustomerFrom(RetailscmUserContext userContext, String cityPartnerId, 
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPotentialCustomer(userContext,cityPartnerId, potentialCustomerId, potentialCustomerVersion,tokensExpr);
		
		PotentialCustomer potentialCustomer = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			potentialCustomer.updateLastUpdateTime(userContext.now());
			
			cityPartner.copyPotentialCustomerFrom( potentialCustomer );		
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
			
			userContext.getManagerGroup().getPotentialCustomerManager().onNewInstanceCreated(userContext, (PotentialCustomer)cityPartner.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingPotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);
		userContext.getChecker().checkIdOfPotentialCustomer(potentialCustomerId);
		userContext.getChecker().checkVersionOfPotentialCustomer(potentialCustomerVersion);
		

		if(PotentialCustomer.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPotentialCustomer(parseString(newValueExpr));
		}
		
		if(PotentialCustomer.MOBILE_PROPERTY.equals(property)){
			userContext.getChecker().checkMobileOfPotentialCustomer(parseString(newValueExpr));
		}
		
		if(PotentialCustomer.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfPotentialCustomer(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);
	
	}
	
	public  CityPartner updatePotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPotentialCustomer(userContext, cityPartnerId, potentialCustomerId, potentialCustomerVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withPotentialCustomerList().searchPotentialCustomerListWith(PotentialCustomer.ID_PROPERTY, "eq", potentialCustomerId).done();
		
		
		
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, loadTokens);
		
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//cityPartner.removePotentialCustomer( potentialCustomer );	
			//make changes to AcceleraterAccount.
			PotentialCustomer potentialCustomerIndex = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);
		
			PotentialCustomer potentialCustomer = cityPartner.findThePotentialCustomer(potentialCustomerIndex);
			if(potentialCustomer == null){
				throw new CityPartnerManagerException(potentialCustomer+" is NOT FOUND" );
			}
			
			potentialCustomer.changeProperty(property, newValueExpr);
			potentialCustomer.updateLastUpdateTime(userContext.now());
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingPotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);

		
		userContext.getChecker().checkNameOfPotentialCustomerContact(name);
		
		userContext.getChecker().checkContactDateOfPotentialCustomerContact(contactDate);
		
		userContext.getChecker().checkContactMethodOfPotentialCustomerContact(contactMethod);
		
		userContext.getChecker().checkPotentialCustomerIdOfPotentialCustomerContact(potentialCustomerId);
		
		userContext.getChecker().checkContactToIdOfPotentialCustomerContact(contactToId);
		
		userContext.getChecker().checkDescriptionOfPotentialCustomerContact(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);

	
	}
	public  CityPartner addPotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPotentialCustomerContact(userContext,cityPartnerId,name, contactDate, contactMethod, potentialCustomerId, contactToId, description,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createPotentialCustomerContact(userContext,name, contactDate, contactMethod, potentialCustomerId, contactToId, description);
		
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityPartner.addPotentialCustomerContact( potentialCustomerContact );		
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
			
			userContext.getManagerGroup().getPotentialCustomerContactManager().onNewInstanceCreated(userContext, potentialCustomerContact);
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPotentialCustomerContactProperties(RetailscmUserContext userContext, String cityPartnerId,String id,String name,Date contactDate,String contactMethod,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);
		userContext.getChecker().checkIdOfPotentialCustomerContact(id);
		
		userContext.getChecker().checkNameOfPotentialCustomerContact( name);
		userContext.getChecker().checkContactDateOfPotentialCustomerContact( contactDate);
		userContext.getChecker().checkContactMethodOfPotentialCustomerContact( contactMethod);
		userContext.getChecker().checkDescriptionOfPotentialCustomerContact( description);

		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);
		
	}
	public  CityPartner updatePotentialCustomerContactProperties(RetailscmUserContext userContext, String cityPartnerId, String id,String name,Date contactDate,String contactMethod,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingPotentialCustomerContactProperties(userContext,cityPartnerId,id,name,contactDate,contactMethod,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPotentialCustomerContactListList()
				.searchPotentialCustomerContactListWith(PotentialCustomerContact.ID_PROPERTY, "is", id).done();
		
		CityPartner cityPartnerToUpdate = loadCityPartner(userContext, cityPartnerId, options);
		
		if(cityPartnerToUpdate.getPotentialCustomerContactList().isEmpty()){
			throw new CityPartnerManagerException("PotentialCustomerContact is NOT FOUND with id: '"+id+"'");
		}
		
		PotentialCustomerContact item = cityPartnerToUpdate.getPotentialCustomerContactList().first();
		
		item.updateName( name );
		item.updateContactDate( contactDate );
		item.updateContactMethod( contactMethod );
		item.updateDescription( description );

		
		//checkParamsForAddingPotentialCustomerContact(userContext,cityPartnerId,name, code, used,tokensExpr);
		CityPartner cityPartner = saveCityPartner(userContext, cityPartnerToUpdate, tokens().withPotentialCustomerContactList().done());
		synchronized(cityPartner){ 
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected PotentialCustomerContact createPotentialCustomerContact(RetailscmUserContext userContext, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description) throws Exception{

		PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();
		
		
		potentialCustomerContact.setName(name);		
		potentialCustomerContact.setContactDate(contactDate);		
		potentialCustomerContact.setContactMethod(contactMethod);		
		PotentialCustomer  potentialCustomer = new PotentialCustomer();
		potentialCustomer.setId(potentialCustomerId);		
		potentialCustomerContact.setPotentialCustomer(potentialCustomer);		
		PotentialCustomerContactPerson  contactTo = new PotentialCustomerContactPerson();
		contactTo.setId(contactToId);		
		potentialCustomerContact.setContactTo(contactTo);		
		potentialCustomerContact.setDescription(description);		
		potentialCustomerContact.setLastUpdateTime(userContext.now());
	
		
		return potentialCustomerContact;
	
		
	}
	
	protected PotentialCustomerContact createIndexedPotentialCustomerContact(String id, int version){

		PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();
		potentialCustomerContact.setId(id);
		potentialCustomerContact.setVersion(version);
		return potentialCustomerContact;			
		
	}
	
	protected void checkParamsForRemovingPotentialCustomerContactList(RetailscmUserContext userContext, String cityPartnerId, 
			String potentialCustomerContactIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);
		for(String potentialCustomerContactId: potentialCustomerContactIds){
			userContext.getChecker().checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);
		
	}
	public  CityPartner removePotentialCustomerContactList(RetailscmUserContext userContext, String cityPartnerId, 
			String potentialCustomerContactIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingPotentialCustomerContactList(userContext, cityPartnerId,  potentialCustomerContactIds, tokensExpr);
			
			
			CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
			synchronized(cityPartner){ 
				//Will be good when the cityPartner loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getCityPartnerDAO().planToRemovePotentialCustomerContactList(cityPartner, potentialCustomerContactIds, allTokens());
				cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
				deleteRelationListInGraph(userContext, cityPartner.getPotentialCustomerContactList());
				return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingPotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCityPartner( cityPartnerId);
		userContext.getChecker().checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		userContext.getChecker().checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);
	
	}
	public  CityPartner removePotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPotentialCustomerContact(userContext,cityPartnerId, potentialCustomerContactId, potentialCustomerContactVersion,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityPartner.removePotentialCustomerContact( potentialCustomerContact );		
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
			deleteRelationInGraph(userContext, potentialCustomerContact);
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingPotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfCityPartner( cityPartnerId);
		userContext.getChecker().checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		userContext.getChecker().checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);
		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);
	
	}
	public  CityPartner copyPotentialCustomerContactFrom(RetailscmUserContext userContext, String cityPartnerId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPotentialCustomerContact(userContext,cityPartnerId, potentialCustomerContactId, potentialCustomerContactVersion,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			potentialCustomerContact.updateLastUpdateTime(userContext.now());
			
			cityPartner.copyPotentialCustomerContactFrom( potentialCustomerContact );		
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
			
			userContext.getManagerGroup().getPotentialCustomerContactManager().onNewInstanceCreated(userContext, (PotentialCustomerContact)cityPartner.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingPotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfCityPartner(cityPartnerId);
		userContext.getChecker().checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		userContext.getChecker().checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);
		

		if(PotentialCustomerContact.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPotentialCustomerContact(parseString(newValueExpr));
		}
		
		if(PotentialCustomerContact.CONTACT_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkContactDateOfPotentialCustomerContact(parseDate(newValueExpr));
		}
		
		if(PotentialCustomerContact.CONTACT_METHOD_PROPERTY.equals(property)){
			userContext.getChecker().checkContactMethodOfPotentialCustomerContact(parseString(newValueExpr));
		}
		
		if(PotentialCustomerContact.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfPotentialCustomerContact(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(CityPartnerManagerException.class);
	
	}
	
	public  CityPartner updatePotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPotentialCustomerContact(userContext, cityPartnerId, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withPotentialCustomerContactList().searchPotentialCustomerContactListWith(PotentialCustomerContact.ID_PROPERTY, "eq", potentialCustomerContactId).done();
		
		
		
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, loadTokens);
		
		synchronized(cityPartner){ 
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//cityPartner.removePotentialCustomerContact( potentialCustomerContact );	
			//make changes to AcceleraterAccount.
			PotentialCustomerContact potentialCustomerContactIndex = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		
			PotentialCustomerContact potentialCustomerContact = cityPartner.findThePotentialCustomerContact(potentialCustomerContactIndex);
			if(potentialCustomerContact == null){
				throw new CityPartnerManagerException(potentialCustomerContact+" is NOT FOUND" );
			}
			
			potentialCustomerContact.changeProperty(property, newValueExpr);
			potentialCustomerContact.updateLastUpdateTime(userContext.now());
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, CityPartner newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


