
package com.doublechaintech.retailscm.potentialcustomercontactperson;

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

import com.doublechaintech.retailscm.potentialcustomer.CandidatePotentialCustomer;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;






public class PotentialCustomerContactPersonManagerImpl extends CustomRetailscmCheckerManager implements PotentialCustomerContactPersonManager {
	
	private static final String SERVICE_TYPE = "PotentialCustomerContactPerson";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PotentialCustomerContactPersonManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PotentialCustomerContactPersonManagerException(message);

	}
	
	

 	protected PotentialCustomerContactPerson savePotentialCustomerContactPerson(RetailscmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, String [] tokensExpr) throws Exception{	
 		//return getPotentialCustomerContactPersonDAO().save(potentialCustomerContactPerson, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens);
 	}
 	
 	protected PotentialCustomerContactPerson savePotentialCustomerContactPersonDetail(RetailscmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson) throws Exception{	

 		
 		return savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, allTokens());
 	}
 	
 	public PotentialCustomerContactPerson loadPotentialCustomerContactPerson(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		userContext.getChecker().throwExceptionIfHasErrors( PotentialCustomerContactPersonManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson( userContext, potentialCustomerContactPersonId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,potentialCustomerContactPerson, tokens);
 	}
 	
 	
 	 public PotentialCustomerContactPerson searchPotentialCustomerContactPerson(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		userContext.getChecker().throwExceptionIfHasErrors( PotentialCustomerContactPersonManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson( userContext, potentialCustomerContactPersonId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,potentialCustomerContactPerson, tokens);
 	}
 	
 	

 	protected PotentialCustomerContactPerson present(RetailscmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,potentialCustomerContactPerson,tokens);
		
		
		PotentialCustomerContactPerson  potentialCustomerContactPersonToPresent = userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().present(potentialCustomerContactPerson, tokens);
		
		List<BaseEntity> entityListToNaming = potentialCustomerContactPersonToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().alias(entityListToNaming);
		
		return  potentialCustomerContactPersonToPresent;
		
		
	}
 
 	
 	
 	public PotentialCustomerContactPerson loadPotentialCustomerContactPersonDetail(RetailscmUserContext userContext, String potentialCustomerContactPersonId) throws Exception{	
 		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson( userContext, potentialCustomerContactPersonId, allTokens());
 		return present(userContext,potentialCustomerContactPerson, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String potentialCustomerContactPersonId) throws Exception{	
 		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson( userContext, potentialCustomerContactPersonId, viewTokens());
 		return present(userContext,potentialCustomerContactPerson, allTokens());
		
 	}
 	protected PotentialCustomerContactPerson savePotentialCustomerContactPerson(RetailscmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().save(potentialCustomerContactPerson, tokens);
 	}
 	protected PotentialCustomerContactPerson loadPotentialCustomerContactPerson(RetailscmUserContext userContext, String potentialCustomerContactPersonId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		userContext.getChecker().throwExceptionIfHasErrors( PotentialCustomerContactPersonManagerException.class);

 
 		return userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().load(potentialCustomerContactPersonId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String, Object> tokens){
		super.addActions(userContext, potentialCustomerContactPerson, tokens);
		
		addAction(userContext, potentialCustomerContactPerson, tokens,"@create","createPotentialCustomerContactPerson","createPotentialCustomerContactPerson/","main","primary");
		addAction(userContext, potentialCustomerContactPerson, tokens,"@update","updatePotentialCustomerContactPerson","updatePotentialCustomerContactPerson/"+potentialCustomerContactPerson.getId()+"/","main","primary");
		addAction(userContext, potentialCustomerContactPerson, tokens,"@copy","clonePotentialCustomerContactPerson","clonePotentialCustomerContactPerson/"+potentialCustomerContactPerson.getId()+"/","main","primary");
		
		addAction(userContext, potentialCustomerContactPerson, tokens,"potential_customer_contact_person.transfer_to_potential_customer","transferToAnotherPotentialCustomer","transferToAnotherPotentialCustomer/"+potentialCustomerContactPerson.getId()+"/","main","primary");
		addAction(userContext, potentialCustomerContactPerson, tokens,"potential_customer_contact_person.addPotentialCustomerContact","addPotentialCustomerContact","addPotentialCustomerContact/"+potentialCustomerContactPerson.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, potentialCustomerContactPerson, tokens,"potential_customer_contact_person.removePotentialCustomerContact","removePotentialCustomerContact","removePotentialCustomerContact/"+potentialCustomerContactPerson.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, potentialCustomerContactPerson, tokens,"potential_customer_contact_person.updatePotentialCustomerContact","updatePotentialCustomerContact","updatePotentialCustomerContact/"+potentialCustomerContactPerson.getId()+"/","potentialCustomerContactList","primary");
		addAction(userContext, potentialCustomerContactPerson, tokens,"potential_customer_contact_person.copyPotentialCustomerContactFrom","copyPotentialCustomerContactFrom","copyPotentialCustomerContactFrom/"+potentialCustomerContactPerson.getId()+"/","potentialCustomerContactList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public PotentialCustomerContactPerson createPotentialCustomerContactPerson(RetailscmUserContext userContext,String name, String mobile, String potentialCustomerId, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfPotentialCustomerContactPerson(name);
		userContext.getChecker().checkMobileOfPotentialCustomerContactPerson(mobile);
		userContext.getChecker().checkDescriptionOfPotentialCustomerContactPerson(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);


		PotentialCustomerContactPerson potentialCustomerContactPerson=createNewPotentialCustomerContactPerson();	

		potentialCustomerContactPerson.setName(name);
		potentialCustomerContactPerson.setMobile(mobile);
			
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId,emptyOptions());
		potentialCustomerContactPerson.setPotentialCustomer(potentialCustomer);
		
		
		potentialCustomerContactPerson.setDescription(description);

		potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, emptyOptions());
		
		onNewInstanceCreated(userContext, potentialCustomerContactPerson);
		return potentialCustomerContactPerson;

		
	}
	protected PotentialCustomerContactPerson createNewPotentialCustomerContactPerson() 
	{
		
		return new PotentialCustomerContactPerson();		
	}
	
	protected void checkParamsForUpdatingPotentialCustomerContactPerson(RetailscmUserContext userContext,String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		userContext.getChecker().checkVersionOfPotentialCustomerContactPerson( potentialCustomerContactPersonVersion);
		

		if(PotentialCustomerContactPerson.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPotentialCustomerContactPerson(parseString(newValueExpr));
		}
		if(PotentialCustomerContactPerson.MOBILE_PROPERTY.equals(property)){
			userContext.getChecker().checkMobileOfPotentialCustomerContactPerson(parseString(newValueExpr));
		}		

		
		if(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfPotentialCustomerContactPerson(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
	
		
	}
	
	
	
	public PotentialCustomerContactPerson clone(RetailscmUserContext userContext, String fromPotentialCustomerContactPersonId) throws Exception{
		
		return userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().clone(fromPotentialCustomerContactPersonId, this.allTokens());
	}
	
	public PotentialCustomerContactPerson internalSavePotentialCustomerContactPerson(RetailscmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson) throws Exception 
	{
		return internalSavePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, allTokens());

	}
	public PotentialCustomerContactPerson internalSavePotentialCustomerContactPerson(RetailscmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(potentialCustomerContactPerson){ 
			//will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PotentialCustomerContactPerson.
			
			
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, options);
			return potentialCustomerContactPerson;
			
		}

	}
	
	public PotentialCustomerContactPerson updatePotentialCustomerContactPerson(RetailscmUserContext userContext,String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion, property, newValueExpr, tokensExpr);
		
		
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());
		if(potentialCustomerContactPerson.getVersion() != potentialCustomerContactPersonVersion){
			String message = "The target version("+potentialCustomerContactPerson.getVersion()+") is not equals to version("+potentialCustomerContactPersonVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(potentialCustomerContactPerson){ 
			//will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PotentialCustomerContactPerson.
			
			potentialCustomerContactPerson.changeProperty(property, newValueExpr);
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().done());
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
			//return savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().done());
		}

	}
	
	public PotentialCustomerContactPerson updatePotentialCustomerContactPersonProperty(RetailscmUserContext userContext,String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion, property, newValueExpr, tokensExpr);
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());
		if(potentialCustomerContactPerson.getVersion() != potentialCustomerContactPersonVersion){
			String message = "The target version("+potentialCustomerContactPerson.getVersion()+") is not equals to version("+potentialCustomerContactPersonVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(potentialCustomerContactPerson){ 
			//will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PotentialCustomerContactPerson.
			
			potentialCustomerContactPerson.changeProperty(property, newValueExpr);
			
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().done());
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
			//return savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PotentialCustomerContactPersonTokens tokens(){
		return PotentialCustomerContactPersonTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PotentialCustomerContactPersonTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortPotentialCustomerContactListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PotentialCustomerContactPersonTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPotentialCustomer(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String anotherPotentialCustomerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
 		userContext.getChecker().checkIdOfPotentialCustomer(anotherPotentialCustomerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
 		
 	}
 	public PotentialCustomerContactPerson transferToAnotherPotentialCustomer(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String anotherPotentialCustomerId) throws Exception
 	{
 		checkParamsForTransferingAnotherPotentialCustomer(userContext, potentialCustomerContactPersonId,anotherPotentialCustomerId);
 
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());	
		synchronized(potentialCustomerContactPerson){
			//will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, anotherPotentialCustomerId, emptyOptions());		
			potentialCustomerContactPerson.updatePotentialCustomer(potentialCustomer);		
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, emptyOptions());
			
			return present(userContext,potentialCustomerContactPerson, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePotentialCustomer requestCandidatePotentialCustomer(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePotentialCustomer result = new CandidatePotentialCustomer();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<PotentialCustomer> candidateList = userContext.getDAOGroup().getPotentialCustomerDAO().requestCandidatePotentialCustomerForPotentialCustomerContactPerson(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected PotentialCustomer loadPotentialCustomer(RetailscmUserContext userContext, String newPotentialCustomerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getPotentialCustomerDAO().load(newPotentialCustomerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion) throws Exception {
		//deleteInternal(userContext, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion) throws Exception{
			
		userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().delete(potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);
	}
	
	public PotentialCustomerContactPerson forgetByAll(RetailscmUserContext userContext, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion) throws Exception {
		return forgetByAllInternal(userContext, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);		
	}
	protected PotentialCustomerContactPerson forgetByAllInternal(RetailscmUserContext userContext,
			String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion) throws Exception{
			
		return userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().disconnectFromAll(potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PotentialCustomerContactPersonManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().deleteAll();
	}


	//disconnect PotentialCustomerContactPerson with potential_customer in PotentialCustomerContact
	protected PotentialCustomerContactPerson breakWithPotentialCustomerContactByPotentialCustomer(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());

			synchronized(potentialCustomerContactPerson){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().planToRemovePotentialCustomerContactListWithPotentialCustomer(potentialCustomerContactPerson, potentialCustomerId, this.emptyOptions());

				potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
				return potentialCustomerContactPerson;
			}
	}
	//disconnect PotentialCustomerContactPerson with city_partner in PotentialCustomerContact
	protected PotentialCustomerContactPerson breakWithPotentialCustomerContactByCityPartner(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String cityPartnerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());

			synchronized(potentialCustomerContactPerson){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().planToRemovePotentialCustomerContactListWithCityPartner(potentialCustomerContactPerson, cityPartnerId, this.emptyOptions());

				potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
				return potentialCustomerContactPerson;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);

		
		userContext.getChecker().checkNameOfPotentialCustomerContact(name);
		
		userContext.getChecker().checkContactDateOfPotentialCustomerContact(contactDate);
		
		userContext.getChecker().checkContactMethodOfPotentialCustomerContact(contactMethod);
		
		userContext.getChecker().checkPotentialCustomerIdOfPotentialCustomerContact(potentialCustomerId);
		
		userContext.getChecker().checkCityPartnerIdOfPotentialCustomerContact(cityPartnerId);
		
		userContext.getChecker().checkDescriptionOfPotentialCustomerContact(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);

	
	}
	public  PotentialCustomerContactPerson addPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPotentialCustomerContact(userContext,potentialCustomerContactPersonId,name, contactDate, contactMethod, potentialCustomerId, cityPartnerId, description,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createPotentialCustomerContact(userContext,name, contactDate, contactMethod, potentialCustomerId, cityPartnerId, description);
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());
		synchronized(potentialCustomerContactPerson){ 
			//Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomerContactPerson.addPotentialCustomerContact( potentialCustomerContact );		
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
			
			userContext.getManagerGroup().getPotentialCustomerContactManager().onNewInstanceCreated(userContext, potentialCustomerContact);
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPotentialCustomerContactProperties(RetailscmUserContext userContext, String potentialCustomerContactPersonId,String id,String name,Date contactDate,String contactMethod,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		userContext.getChecker().checkIdOfPotentialCustomerContact(id);
		
		userContext.getChecker().checkNameOfPotentialCustomerContact( name);
		userContext.getChecker().checkContactDateOfPotentialCustomerContact( contactDate);
		userContext.getChecker().checkContactMethodOfPotentialCustomerContact( contactMethod);
		userContext.getChecker().checkDescriptionOfPotentialCustomerContact( description);

		userContext.getChecker().throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
		
	}
	public  PotentialCustomerContactPerson updatePotentialCustomerContactProperties(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String id,String name,Date contactDate,String contactMethod,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingPotentialCustomerContactProperties(userContext,potentialCustomerContactPersonId,id,name,contactDate,contactMethod,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPotentialCustomerContactListList()
				.searchPotentialCustomerContactListWith(PotentialCustomerContact.ID_PROPERTY, "is", id).done();
		
		PotentialCustomerContactPerson potentialCustomerContactPersonToUpdate = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, options);
		
		if(potentialCustomerContactPersonToUpdate.getPotentialCustomerContactList().isEmpty()){
			throw new PotentialCustomerContactPersonManagerException("PotentialCustomerContact is NOT FOUND with id: '"+id+"'");
		}
		
		PotentialCustomerContact item = potentialCustomerContactPersonToUpdate.getPotentialCustomerContactList().first();
		
		item.updateName( name );
		item.updateContactDate( contactDate );
		item.updateContactMethod( contactMethod );
		item.updateDescription( description );

		
		//checkParamsForAddingPotentialCustomerContact(userContext,potentialCustomerContactPersonId,name, code, used,tokensExpr);
		PotentialCustomerContactPerson potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPersonToUpdate, tokens().withPotentialCustomerContactList().done());
		synchronized(potentialCustomerContactPerson){ 
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected PotentialCustomerContact createPotentialCustomerContact(RetailscmUserContext userContext, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description) throws Exception{

		PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();
		
		
		potentialCustomerContact.setName(name);		
		potentialCustomerContact.setContactDate(contactDate);		
		potentialCustomerContact.setContactMethod(contactMethod);		
		PotentialCustomer  potentialCustomer = new PotentialCustomer();
		potentialCustomer.setId(potentialCustomerId);		
		potentialCustomerContact.setPotentialCustomer(potentialCustomer);		
		CityPartner  cityPartner = new CityPartner();
		cityPartner.setId(cityPartnerId);		
		potentialCustomerContact.setCityPartner(cityPartner);		
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
	
	protected void checkParamsForRemovingPotentialCustomerContactList(RetailscmUserContext userContext, String potentialCustomerContactPersonId, 
			String potentialCustomerContactIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		for(String potentialCustomerContactId: potentialCustomerContactIds){
			userContext.getChecker().checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
		
	}
	public  PotentialCustomerContactPerson removePotentialCustomerContactList(RetailscmUserContext userContext, String potentialCustomerContactPersonId, 
			String potentialCustomerContactIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingPotentialCustomerContactList(userContext, potentialCustomerContactPersonId,  potentialCustomerContactIds, tokensExpr);
			
			
			PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());
			synchronized(potentialCustomerContactPerson){ 
				//Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().planToRemovePotentialCustomerContactList(potentialCustomerContactPerson, potentialCustomerContactIds, allTokens());
				potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
				deleteRelationListInGraph(userContext, potentialCustomerContactPerson.getPotentialCustomerContactList());
				return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPotentialCustomerContactPerson( potentialCustomerContactPersonId);
		userContext.getChecker().checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		userContext.getChecker().checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
	
	}
	public  PotentialCustomerContactPerson removePotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPotentialCustomerContact(userContext,potentialCustomerContactPersonId, potentialCustomerContactId, potentialCustomerContactVersion,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());
		synchronized(potentialCustomerContactPerson){ 
			//Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomerContactPerson.removePotentialCustomerContact( potentialCustomerContact );		
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
			deleteRelationInGraph(userContext, potentialCustomerContact);
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfPotentialCustomerContactPerson( potentialCustomerContactPersonId);
		userContext.getChecker().checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		userContext.getChecker().checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);
		userContext.getChecker().throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
	
	}
	public  PotentialCustomerContactPerson copyPotentialCustomerContactFrom(RetailscmUserContext userContext, String potentialCustomerContactPersonId, 
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPotentialCustomerContact(userContext,potentialCustomerContactPersonId, potentialCustomerContactId, potentialCustomerContactVersion,tokensExpr);
		
		PotentialCustomerContact potentialCustomerContact = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());
		synchronized(potentialCustomerContactPerson){ 
			//Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			potentialCustomerContact.updateLastUpdateTime(userContext.now());
			
			potentialCustomerContactPerson.copyPotentialCustomerContactFrom( potentialCustomerContact );		
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
			
			userContext.getManagerGroup().getPotentialCustomerContactManager().onNewInstanceCreated(userContext, (PotentialCustomerContact)potentialCustomerContactPerson.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);
	
	}
	
	public  PotentialCustomerContactPerson updatePotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPotentialCustomerContact(userContext, potentialCustomerContactPersonId, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withPotentialCustomerContactList().searchPotentialCustomerContactListWith(PotentialCustomerContact.ID_PROPERTY, "eq", potentialCustomerContactId).done();
		
		
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, loadTokens);
		
		synchronized(potentialCustomerContactPerson){ 
			//Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//potentialCustomerContactPerson.removePotentialCustomerContact( potentialCustomerContact );	
			//make changes to AcceleraterAccount.
			PotentialCustomerContact potentialCustomerContactIndex = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);
		
			PotentialCustomerContact potentialCustomerContact = potentialCustomerContactPerson.findThePotentialCustomerContact(potentialCustomerContactIndex);
			if(potentialCustomerContact == null){
				throw new PotentialCustomerContactPersonManagerException(potentialCustomerContact+" is NOT FOUND" );
			}
			
			potentialCustomerContact.changeProperty(property, newValueExpr);
			potentialCustomerContact.updateLastUpdateTime(userContext.now());
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, PotentialCustomerContactPerson newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


