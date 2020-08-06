
package com.doublechaintech.retailscm.potentialcustomercontactperson;

import java.util.*;
import java.math.BigDecimal;
import com.terapico.caf.baseelement.PlainText;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;



import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;

import com.doublechaintech.retailscm.potentialcustomer.CandidatePotentialCustomer;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;






public class PotentialCustomerContactPersonManagerImpl extends CustomRetailscmCheckerManager implements PotentialCustomerContactPersonManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = PotentialCustomerContactPersonTokens.start().withTokenFromListName(listName).done();
		PotentialCustomerContactPerson  potentialCustomerContactPerson = (PotentialCustomerContactPerson) this.loadPotentialCustomerContactPerson(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = potentialCustomerContactPerson.collectRefercencesFromLists();
		potentialCustomerContactPersonDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, potentialCustomerContactPerson, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new PotentialCustomerContactPersonGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "PotentialCustomerContactPerson";
	@Override
	public PotentialCustomerContactPersonDAO daoOf(RetailscmUserContext userContext) {
		return potentialCustomerContactPersonDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		checkerOf(userContext).throwExceptionIfHasErrors( PotentialCustomerContactPersonManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson( userContext, potentialCustomerContactPersonId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,potentialCustomerContactPerson, tokens);
 	}
 	
 	
 	 public PotentialCustomerContactPerson searchPotentialCustomerContactPerson(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		checkerOf(userContext).throwExceptionIfHasErrors( PotentialCustomerContactPersonManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson( userContext, potentialCustomerContactPersonId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,potentialCustomerContactPerson, tokens);
 	}
 	
 	

 	protected PotentialCustomerContactPerson present(RetailscmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,potentialCustomerContactPerson,tokens);
		
		
		PotentialCustomerContactPerson  potentialCustomerContactPersonToPresent = potentialCustomerContactPersonDaoOf(userContext).present(potentialCustomerContactPerson, tokens);
		
		List<BaseEntity> entityListToNaming = potentialCustomerContactPersonToPresent.collectRefercencesFromLists();
		potentialCustomerContactPersonDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,potentialCustomerContactPerson,tokens);
		
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
 		return potentialCustomerContactPersonDaoOf(userContext).save(potentialCustomerContactPerson, tokens);
 	}
 	protected PotentialCustomerContactPerson loadPotentialCustomerContactPerson(RetailscmUserContext userContext, String potentialCustomerContactPersonId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		checkerOf(userContext).throwExceptionIfHasErrors( PotentialCustomerContactPersonManagerException.class);

 
 		return potentialCustomerContactPersonDaoOf(userContext).load(potentialCustomerContactPersonId, tokens);
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
	
 	
 	
 
 	
 	

	public PotentialCustomerContactPerson createPotentialCustomerContactPerson(RetailscmUserContext userContext, String name,String mobile,String potentialCustomerId,String description) throws Exception
	//public PotentialCustomerContactPerson createPotentialCustomerContactPerson(RetailscmUserContext userContext,String name, String mobile, String potentialCustomerId, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfPotentialCustomerContactPerson(name);
		checkerOf(userContext).checkMobileOfPotentialCustomerContactPerson(mobile);
		checkerOf(userContext).checkDescriptionOfPotentialCustomerContactPerson(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		checkerOf(userContext).checkVersionOfPotentialCustomerContactPerson( potentialCustomerContactPersonVersion);
		

		if(PotentialCustomerContactPerson.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfPotentialCustomerContactPerson(parseString(newValueExpr));
		
			
		}
		if(PotentialCustomerContactPerson.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfPotentialCustomerContactPerson(parseString(newValueExpr));
		
			
		}		

		
		if(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfPotentialCustomerContactPerson(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);


	}



	public PotentialCustomerContactPerson clone(RetailscmUserContext userContext, String fromPotentialCustomerContactPersonId) throws Exception{

		return potentialCustomerContactPersonDaoOf(userContext).clone(fromPotentialCustomerContactPersonId, this.allTokens());
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
			if (potentialCustomerContactPerson.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PotentialCustomerContactPersonTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPotentialCustomer(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String anotherPotentialCustomerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
 		checkerOf(userContext).checkIdOfPotentialCustomer(anotherPotentialCustomerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);

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
		SmartList<PotentialCustomer> candidateList = potentialCustomerDaoOf(userContext).requestCandidatePotentialCustomerForPotentialCustomerContactPerson(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected PotentialCustomer loadPotentialCustomer(RetailscmUserContext userContext, String newPotentialCustomerId, Map<String,Object> options) throws Exception
 	{

 		return potentialCustomerDaoOf(userContext).load(newPotentialCustomerId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion) throws Exception {
		//deleteInternal(userContext, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion) throws Exception{

		potentialCustomerContactPersonDaoOf(userContext).delete(potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);
	}

	public PotentialCustomerContactPerson forgetByAll(RetailscmUserContext userContext, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion) throws Exception {
		return forgetByAllInternal(userContext, potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);
	}
	protected PotentialCustomerContactPerson forgetByAllInternal(RetailscmUserContext userContext,
			String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion) throws Exception{

		return potentialCustomerContactPersonDaoOf(userContext).disconnectFromAll(potentialCustomerContactPersonId, potentialCustomerContactPersonVersion);
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
		return potentialCustomerContactPersonDaoOf(userContext).deleteAll();
	}


	//disconnect PotentialCustomerContactPerson with potential_customer in PotentialCustomerContact
	protected PotentialCustomerContactPerson breakWithPotentialCustomerContactByPotentialCustomer(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());

			synchronized(potentialCustomerContactPerson){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				potentialCustomerContactPersonDaoOf(userContext).planToRemovePotentialCustomerContactListWithPotentialCustomer(potentialCustomerContactPerson, potentialCustomerId, this.emptyOptions());

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

				potentialCustomerContactPersonDaoOf(userContext).planToRemovePotentialCustomerContactListWithCityPartner(potentialCustomerContactPerson, cityPartnerId, this.emptyOptions());

				potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
				return potentialCustomerContactPerson;
			}
	}






	protected void checkParamsForAddingPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);

		
		checkerOf(userContext).checkNameOfPotentialCustomerContact(name);
		
		checkerOf(userContext).checkContactDateOfPotentialCustomerContact(contactDate);
		
		checkerOf(userContext).checkContactMethodOfPotentialCustomerContact(contactMethod);
		
		checkerOf(userContext).checkPotentialCustomerIdOfPotentialCustomerContact(potentialCustomerId);
		
		checkerOf(userContext).checkCityPartnerIdOfPotentialCustomerContact(cityPartnerId);
		
		checkerOf(userContext).checkDescriptionOfPotentialCustomerContact(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);


	}
	public  PotentialCustomerContactPerson addPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingPotentialCustomerContact(userContext,potentialCustomerContactPersonId,name, contactDate, contactMethod, potentialCustomerId, cityPartnerId, description,tokensExpr);

		PotentialCustomerContact potentialCustomerContact = createPotentialCustomerContact(userContext,name, contactDate, contactMethod, potentialCustomerId, cityPartnerId, description);

		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, emptyOptions());
		synchronized(potentialCustomerContactPerson){
			//Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			potentialCustomerContactPerson.addPotentialCustomerContact( potentialCustomerContact );
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
			
			potentialCustomerContactManagerOf(userContext).onNewInstanceCreated(userContext, potentialCustomerContact);
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPotentialCustomerContactProperties(RetailscmUserContext userContext, String potentialCustomerContactPersonId,String id,String name,Date contactDate,String contactMethod,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		checkerOf(userContext).checkIdOfPotentialCustomerContact(id);

		checkerOf(userContext).checkNameOfPotentialCustomerContact( name);
		checkerOf(userContext).checkContactDateOfPotentialCustomerContact( contactDate);
		checkerOf(userContext).checkContactMethodOfPotentialCustomerContact( contactMethod);
		checkerOf(userContext).checkDescriptionOfPotentialCustomerContact( description);

		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);

	}
	public  PotentialCustomerContactPerson updatePotentialCustomerContactProperties(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String id,String name,Date contactDate,String contactMethod,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPotentialCustomerContactProperties(userContext,potentialCustomerContactPersonId,id,name,contactDate,contactMethod,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPotentialCustomerContactListList()
				.searchPotentialCustomerContactListWith(PotentialCustomerContact.ID_PROPERTY, tokens().is(), id).done();

		PotentialCustomerContactPerson potentialCustomerContactPersonToUpdate = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, options);

		if(potentialCustomerContactPersonToUpdate.getPotentialCustomerContactList().isEmpty()){
			throw new PotentialCustomerContactPersonManagerException("PotentialCustomerContact is NOT FOUND with id: '"+id+"'");
		}

		PotentialCustomerContact item = potentialCustomerContactPersonToUpdate.getPotentialCustomerContactList().first();
		beforeUpdatePotentialCustomerContactProperties(userContext,item, potentialCustomerContactPersonId,id,name,contactDate,contactMethod,description,tokensExpr);
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

	protected  void beforeUpdatePotentialCustomerContactProperties(RetailscmUserContext userContext, PotentialCustomerContact item, String potentialCustomerContactPersonId, String id,String name,Date contactDate,String contactMethod,String description, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		for(String potentialCustomerContactIdItem: potentialCustomerContactIds){
			checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);

	}
	public  PotentialCustomerContactPerson removePotentialCustomerContactList(RetailscmUserContext userContext, String potentialCustomerContactPersonId,
			String potentialCustomerContactIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingPotentialCustomerContactList(userContext, potentialCustomerContactPersonId,  potentialCustomerContactIds, tokensExpr);


			PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, allTokens());
			synchronized(potentialCustomerContactPerson){
				//Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				potentialCustomerContactPersonDaoOf(userContext).planToRemovePotentialCustomerContactList(potentialCustomerContactPerson, potentialCustomerContactIds, allTokens());
				potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
				deleteRelationListInGraph(userContext, potentialCustomerContactPerson.getPotentialCustomerContactList());
				return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId,
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPotentialCustomerContactPerson( potentialCustomerContactPersonId);
		checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		checkerOf(userContext).checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);

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
		
		checkerOf(userContext).checkIdOfPotentialCustomerContactPerson( potentialCustomerContactPersonId);
		checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		checkerOf(userContext).checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);

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
			
			potentialCustomerContactManagerOf(userContext).onNewInstanceCreated(userContext, (PotentialCustomerContact)potentialCustomerContactPerson.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPotentialCustomerContactPerson(potentialCustomerContactPersonId);
		checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		checkerOf(userContext).checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);


		if(PotentialCustomerContact.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfPotentialCustomerContact(parseString(newValueExpr));
		}
		
		if(PotentialCustomerContact.CONTACT_DATE_PROPERTY.equals(property)){
			checkerOf(userContext).checkContactDateOfPotentialCustomerContact(parseDate(newValueExpr));
		}
		
		if(PotentialCustomerContact.CONTACT_METHOD_PROPERTY.equals(property)){
			checkerOf(userContext).checkContactMethodOfPotentialCustomerContact(parseString(newValueExpr));
		}
		
		if(PotentialCustomerContact.DESCRIPTION_PROPERTY.equals(property)){
			checkerOf(userContext).checkDescriptionOfPotentialCustomerContact(parseString(newValueExpr));
		}
		

		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactPersonManagerException.class);

	}

	public  PotentialCustomerContactPerson updatePotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingPotentialCustomerContact(userContext, potentialCustomerContactPersonId, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withPotentialCustomerContactList().searchPotentialCustomerContactListWith(PotentialCustomerContact.ID_PROPERTY, tokens().equals(), potentialCustomerContactId).done();



		PotentialCustomerContactPerson potentialCustomerContactPerson = loadPotentialCustomerContactPerson(userContext, potentialCustomerContactPersonId, loadTokens);

		synchronized(potentialCustomerContactPerson){
			//Will be good when the potentialCustomerContactPerson loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//potentialCustomerContactPerson.removePotentialCustomerContact( potentialCustomerContact );
			//make changes to AcceleraterAccount.
			PotentialCustomerContact potentialCustomerContactIdVersionKey = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);

			PotentialCustomerContact potentialCustomerContact = potentialCustomerContactPerson.findThePotentialCustomerContact(potentialCustomerContactIdVersionKey);
			if(potentialCustomerContact == null){
				throw new PotentialCustomerContactPersonManagerException(potentialCustomerContactId+" is NOT FOUND" );
			}

			beforeUpdatePotentialCustomerContact(userContext, potentialCustomerContact, potentialCustomerContactPersonId, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr,  tokensExpr);
			potentialCustomerContact.changeProperty(property, newValueExpr);
			potentialCustomerContact.updateLastUpdateTime(userContext.now());
			potentialCustomerContactPerson = savePotentialCustomerContactPerson(userContext, potentialCustomerContactPerson, tokens().withPotentialCustomerContactList().done());
			return present(userContext,potentialCustomerContactPerson, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdatePotentialCustomerContact(RetailscmUserContext userContext, PotentialCustomerContact existed, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, PotentialCustomerContactPerson newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    potentialCustomerContactPersonDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
  }

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}

		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   PotentialCustomerContactPerson newPotentialCustomerContactPerson = this.createPotentialCustomerContactPerson(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newPotentialCustomerContactPerson
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, PotentialCustomerContactPerson.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<PotentialCustomerContactPerson> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<PotentialCustomer> potentialCustomerList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, PotentialCustomer.class);
		userContext.getDAOGroup().enhanceList(potentialCustomerList, PotentialCustomer.class);


    }
	
	public Object listByPotentialCustomer(RetailscmUserContext userContext,String potentialCustomerId) throws Exception {
		return listPageByPotentialCustomer(userContext, potentialCustomerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPotentialCustomer(RetailscmUserContext userContext,String potentialCustomerId, int start, int count) throws Exception {
		SmartList<PotentialCustomerContactPerson> list = potentialCustomerContactPersonDaoOf(userContext).findPotentialCustomerContactPersonByPotentialCustomer(potentialCustomerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(PotentialCustomerContactPerson.class);
		page.setContainerObject(PotentialCustomer.withId(potentialCustomerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("潜在客户联络人列表");
		page.setRequestName("listByPotentialCustomer");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByPotentialCustomer/%s/",  getBeanName(), potentialCustomerId)));

		page.assemblerContent(userContext, "listByPotentialCustomer");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String potentialCustomerContactPersonId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getPotentialCustomerContactPersonDetailScope().clone();
		PotentialCustomerContactPerson merchantObj = (PotentialCustomerContactPerson) this.view(userContext, potentialCustomerContactPersonId);
    String merchantObjId = potentialCustomerContactPersonId;
    String linkToUrl =	"potentialCustomerContactPersonManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "潜在客户联络人"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "ID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-mobile")
				    .put("fieldName", "mobile")
				    .put("label", "手机")
				    .put("type", "mobile")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("mobile", merchantObj.getMobile());

		propList.add(
				MapUtil.put("id", "4-potentialCustomer")
				    .put("fieldName", "potentialCustomer")
				    .put("label", "潜在的客户")
				    .put("type", "auto")
				    .put("linkToUrl", "potentialCustomerManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("potentialCustomer", merchantObj.getPotentialCustomer());

		propList.add(
				MapUtil.put("id", "5-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		//处理 sectionList

		//处理Section：potentialCustomerContactListSection
		Map potentialCustomerContactListSection = ListofUtils.buildSection(
		    "potentialCustomerContactListSection",
		    "潜在客户联络名单",
		    null,
		    "",
		    "__no_group",
		    "potentialCustomerContactManager/listByContactTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(potentialCustomerContactListSection);

		result.put("potentialCustomerContactListSection", ListofUtils.toShortList(merchantObj.getPotentialCustomerContactList(), "potentialCustomerContact"));
		vscope.field("potentialCustomerContactListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( PotentialCustomerContact.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}



}


