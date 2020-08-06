
package com.doublechaintech.retailscm.potentialcustomercontact;

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



import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;

import com.doublechaintech.retailscm.potentialcustomer.CandidatePotentialCustomer;
import com.doublechaintech.retailscm.citypartner.CandidateCityPartner;
import com.doublechaintech.retailscm.potentialcustomercontactperson.CandidatePotentialCustomerContactPerson;







public class PotentialCustomerContactManagerImpl extends CustomRetailscmCheckerManager implements PotentialCustomerContactManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "PotentialCustomerContact";
	@Override
	public PotentialCustomerContactDAO daoOf(RetailscmUserContext userContext) {
		return potentialCustomerContactDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws PotentialCustomerContactManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new PotentialCustomerContactManagerException(message);

	}



 	protected PotentialCustomerContact savePotentialCustomerContact(RetailscmUserContext userContext, PotentialCustomerContact potentialCustomerContact, String [] tokensExpr) throws Exception{	
 		//return getPotentialCustomerContactDAO().save(potentialCustomerContact, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePotentialCustomerContact(userContext, potentialCustomerContact, tokens);
 	}
 	
 	protected PotentialCustomerContact savePotentialCustomerContactDetail(RetailscmUserContext userContext, PotentialCustomerContact potentialCustomerContact) throws Exception{	

 		
 		return savePotentialCustomerContact(userContext, potentialCustomerContact, allTokens());
 	}
 	
 	public PotentialCustomerContact loadPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		checkerOf(userContext).throwExceptionIfHasErrors( PotentialCustomerContactManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact( userContext, potentialCustomerContactId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,potentialCustomerContact, tokens);
 	}
 	
 	
 	 public PotentialCustomerContact searchPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		checkerOf(userContext).throwExceptionIfHasErrors( PotentialCustomerContactManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact( userContext, potentialCustomerContactId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,potentialCustomerContact, tokens);
 	}
 	
 	

 	protected PotentialCustomerContact present(RetailscmUserContext userContext, PotentialCustomerContact potentialCustomerContact, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,potentialCustomerContact,tokens);
		
		
		PotentialCustomerContact  potentialCustomerContactToPresent = potentialCustomerContactDaoOf(userContext).present(potentialCustomerContact, tokens);
		
		List<BaseEntity> entityListToNaming = potentialCustomerContactToPresent.collectRefercencesFromLists();
		potentialCustomerContactDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,potentialCustomerContact,tokens);
		
		return  potentialCustomerContactToPresent;
		
		
	}
 
 	
 	
 	public PotentialCustomerContact loadPotentialCustomerContactDetail(RetailscmUserContext userContext, String potentialCustomerContactId) throws Exception{	
 		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact( userContext, potentialCustomerContactId, allTokens());
 		return present(userContext,potentialCustomerContact, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String potentialCustomerContactId) throws Exception{	
 		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact( userContext, potentialCustomerContactId, viewTokens());
 		return present(userContext,potentialCustomerContact, allTokens());
		
 	}
 	protected PotentialCustomerContact savePotentialCustomerContact(RetailscmUserContext userContext, PotentialCustomerContact potentialCustomerContact, Map<String,Object>tokens) throws Exception{	
 		return potentialCustomerContactDaoOf(userContext).save(potentialCustomerContact, tokens);
 	}
 	protected PotentialCustomerContact loadPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		checkerOf(userContext).throwExceptionIfHasErrors( PotentialCustomerContactManagerException.class);

 
 		return potentialCustomerContactDaoOf(userContext).load(potentialCustomerContactId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, PotentialCustomerContact potentialCustomerContact, Map<String, Object> tokens){
		super.addActions(userContext, potentialCustomerContact, tokens);
		
		addAction(userContext, potentialCustomerContact, tokens,"@create","createPotentialCustomerContact","createPotentialCustomerContact/","main","primary");
		addAction(userContext, potentialCustomerContact, tokens,"@update","updatePotentialCustomerContact","updatePotentialCustomerContact/"+potentialCustomerContact.getId()+"/","main","primary");
		addAction(userContext, potentialCustomerContact, tokens,"@copy","clonePotentialCustomerContact","clonePotentialCustomerContact/"+potentialCustomerContact.getId()+"/","main","primary");
		
		addAction(userContext, potentialCustomerContact, tokens,"potential_customer_contact.transfer_to_potential_customer","transferToAnotherPotentialCustomer","transferToAnotherPotentialCustomer/"+potentialCustomerContact.getId()+"/","main","primary");
		addAction(userContext, potentialCustomerContact, tokens,"potential_customer_contact.transfer_to_city_partner","transferToAnotherCityPartner","transferToAnotherCityPartner/"+potentialCustomerContact.getId()+"/","main","primary");
		addAction(userContext, potentialCustomerContact, tokens,"potential_customer_contact.transfer_to_contact_to","transferToAnotherContactTo","transferToAnotherContactTo/"+potentialCustomerContact.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, PotentialCustomerContact potentialCustomerContact, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public PotentialCustomerContact createPotentialCustomerContact(RetailscmUserContext userContext, String name,Date contactDate,String contactMethod,String potentialCustomerId,String cityPartnerId,String contactToId,String description) throws Exception
	//public PotentialCustomerContact createPotentialCustomerContact(RetailscmUserContext userContext,String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String contactToId, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfPotentialCustomerContact(name);
		checkerOf(userContext).checkContactDateOfPotentialCustomerContact(contactDate);
		checkerOf(userContext).checkContactMethodOfPotentialCustomerContact(contactMethod);
		checkerOf(userContext).checkDescriptionOfPotentialCustomerContact(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);


		PotentialCustomerContact potentialCustomerContact=createNewPotentialCustomerContact();	

		potentialCustomerContact.setName(name);
		potentialCustomerContact.setContactDate(contactDate);
		potentialCustomerContact.setContactMethod(contactMethod);
			
		PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, potentialCustomerId,emptyOptions());
		potentialCustomerContact.setPotentialCustomer(potentialCustomer);
		
		
			
		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId,emptyOptions());
		potentialCustomerContact.setCityPartner(cityPartner);
		
		
			
		PotentialCustomerContactPerson contactTo = loadPotentialCustomerContactPerson(userContext, contactToId,emptyOptions());
		potentialCustomerContact.setContactTo(contactTo);
		
		
		potentialCustomerContact.setDescription(description);
		potentialCustomerContact.setLastUpdateTime(userContext.now());

		potentialCustomerContact = savePotentialCustomerContact(userContext, potentialCustomerContact, emptyOptions());
		
		onNewInstanceCreated(userContext, potentialCustomerContact);
		return potentialCustomerContact;


	}
	protected PotentialCustomerContact createNewPotentialCustomerContact()
	{

		return new PotentialCustomerContact();
	}

	protected void checkParamsForUpdatingPotentialCustomerContact(RetailscmUserContext userContext,String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		checkerOf(userContext).checkVersionOfPotentialCustomerContact( potentialCustomerContactVersion);
		

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
	
		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);


	}



	public PotentialCustomerContact clone(RetailscmUserContext userContext, String fromPotentialCustomerContactId) throws Exception{

		return potentialCustomerContactDaoOf(userContext).clone(fromPotentialCustomerContactId, this.allTokens());
	}

	public PotentialCustomerContact internalSavePotentialCustomerContact(RetailscmUserContext userContext, PotentialCustomerContact potentialCustomerContact) throws Exception
	{
		return internalSavePotentialCustomerContact(userContext, potentialCustomerContact, allTokens());

	}
	public PotentialCustomerContact internalSavePotentialCustomerContact(RetailscmUserContext userContext, PotentialCustomerContact potentialCustomerContact, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingPotentialCustomerContact(userContext, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr, tokensExpr);


		synchronized(potentialCustomerContact){
			//will be good when the potentialCustomerContact loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PotentialCustomerContact.
			if (potentialCustomerContact.isChanged()){
			potentialCustomerContact.updateLastUpdateTime(userContext.now());
			}
			potentialCustomerContact = savePotentialCustomerContact(userContext, potentialCustomerContact, options);
			return potentialCustomerContact;

		}

	}

	public PotentialCustomerContact updatePotentialCustomerContact(RetailscmUserContext userContext,String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPotentialCustomerContact(userContext, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr, tokensExpr);



		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());
		if(potentialCustomerContact.getVersion() != potentialCustomerContactVersion){
			String message = "The target version("+potentialCustomerContact.getVersion()+") is not equals to version("+potentialCustomerContactVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(potentialCustomerContact){
			//will be good when the potentialCustomerContact loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PotentialCustomerContact.
			potentialCustomerContact.updateLastUpdateTime(userContext.now());
			potentialCustomerContact.changeProperty(property, newValueExpr);
			potentialCustomerContact = savePotentialCustomerContact(userContext, potentialCustomerContact, tokens().done());
			return present(userContext,potentialCustomerContact, mergedAllTokens(tokensExpr));
			//return savePotentialCustomerContact(userContext, potentialCustomerContact, tokens().done());
		}

	}

	public PotentialCustomerContact updatePotentialCustomerContactProperty(RetailscmUserContext userContext,String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPotentialCustomerContact(userContext, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr, tokensExpr);

		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());
		if(potentialCustomerContact.getVersion() != potentialCustomerContactVersion){
			String message = "The target version("+potentialCustomerContact.getVersion()+") is not equals to version("+potentialCustomerContactVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(potentialCustomerContact){
			//will be good when the potentialCustomerContact loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PotentialCustomerContact.

			potentialCustomerContact.changeProperty(property, newValueExpr);
			potentialCustomerContact.updateLastUpdateTime(userContext.now());
			potentialCustomerContact = savePotentialCustomerContact(userContext, potentialCustomerContact, tokens().done());
			return present(userContext,potentialCustomerContact, mergedAllTokens(tokensExpr));
			//return savePotentialCustomerContact(userContext, potentialCustomerContact, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected PotentialCustomerContactTokens tokens(){
		return PotentialCustomerContactTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PotentialCustomerContactTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PotentialCustomerContactTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPotentialCustomer(RetailscmUserContext userContext, String potentialCustomerContactId, String anotherPotentialCustomerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
 		checkerOf(userContext).checkIdOfPotentialCustomer(anotherPotentialCustomerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);

 	}
 	public PotentialCustomerContact transferToAnotherPotentialCustomer(RetailscmUserContext userContext, String potentialCustomerContactId, String anotherPotentialCustomerId) throws Exception
 	{
 		checkParamsForTransferingAnotherPotentialCustomer(userContext, potentialCustomerContactId,anotherPotentialCustomerId);
 
		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());	
		synchronized(potentialCustomerContact){
			//will be good when the potentialCustomerContact loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PotentialCustomer potentialCustomer = loadPotentialCustomer(userContext, anotherPotentialCustomerId, emptyOptions());		
			potentialCustomerContact.updatePotentialCustomer(potentialCustomer);		
			potentialCustomerContact = savePotentialCustomerContact(userContext, potentialCustomerContact, emptyOptions());
			
			return present(userContext,potentialCustomerContact, allTokens());
			
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
		SmartList<PotentialCustomer> candidateList = potentialCustomerDaoOf(userContext).requestCandidatePotentialCustomerForPotentialCustomerContact(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherCityPartner(RetailscmUserContext userContext, String potentialCustomerContactId, String anotherCityPartnerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
 		checkerOf(userContext).checkIdOfCityPartner(anotherCityPartnerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);

 	}
 	public PotentialCustomerContact transferToAnotherCityPartner(RetailscmUserContext userContext, String potentialCustomerContactId, String anotherCityPartnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityPartner(userContext, potentialCustomerContactId,anotherCityPartnerId);
 
		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());	
		synchronized(potentialCustomerContact){
			//will be good when the potentialCustomerContact loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			CityPartner cityPartner = loadCityPartner(userContext, anotherCityPartnerId, emptyOptions());		
			potentialCustomerContact.updateCityPartner(cityPartner);		
			potentialCustomerContact = savePotentialCustomerContact(userContext, potentialCustomerContact, emptyOptions());
			
			return present(userContext,potentialCustomerContact, allTokens());
			
		}

 	}

	


	public CandidateCityPartner requestCandidateCityPartner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCityPartner result = new CandidateCityPartner();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<CityPartner> candidateList = cityPartnerDaoOf(userContext).requestCandidateCityPartnerForPotentialCustomerContact(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherContactTo(RetailscmUserContext userContext, String potentialCustomerContactId, String anotherContactToId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
 		checkerOf(userContext).checkIdOfPotentialCustomerContactPerson(anotherContactToId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(PotentialCustomerContactManagerException.class);

 	}
 	public PotentialCustomerContact transferToAnotherContactTo(RetailscmUserContext userContext, String potentialCustomerContactId, String anotherContactToId) throws Exception
 	{
 		checkParamsForTransferingAnotherContactTo(userContext, potentialCustomerContactId,anotherContactToId);
 
		PotentialCustomerContact potentialCustomerContact = loadPotentialCustomerContact(userContext, potentialCustomerContactId, allTokens());	
		synchronized(potentialCustomerContact){
			//will be good when the potentialCustomerContact loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PotentialCustomerContactPerson contactTo = loadPotentialCustomerContactPerson(userContext, anotherContactToId, emptyOptions());		
			potentialCustomerContact.updateContactTo(contactTo);		
			potentialCustomerContact = savePotentialCustomerContact(userContext, potentialCustomerContact, emptyOptions());
			
			return present(userContext,potentialCustomerContact, allTokens());
			
		}

 	}

	


	public CandidatePotentialCustomerContactPerson requestCandidateContactTo(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePotentialCustomerContactPerson result = new CandidatePotentialCustomerContactPerson();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<PotentialCustomerContactPerson> candidateList = potentialCustomerContactPersonDaoOf(userContext).requestCandidatePotentialCustomerContactPersonForPotentialCustomerContact(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	


	

 	protected CityPartner loadCityPartner(RetailscmUserContext userContext, String newCityPartnerId, Map<String,Object> options) throws Exception
 	{

 		return cityPartnerDaoOf(userContext).load(newCityPartnerId, options);
 	}
 	


	

 	protected PotentialCustomerContactPerson loadPotentialCustomerContactPerson(RetailscmUserContext userContext, String newContactToId, Map<String,Object> options) throws Exception
 	{

 		return potentialCustomerContactPersonDaoOf(userContext).load(newContactToId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String potentialCustomerContactId, int potentialCustomerContactVersion) throws Exception {
		//deleteInternal(userContext, potentialCustomerContactId, potentialCustomerContactVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String potentialCustomerContactId, int potentialCustomerContactVersion) throws Exception{

		potentialCustomerContactDaoOf(userContext).delete(potentialCustomerContactId, potentialCustomerContactVersion);
	}

	public PotentialCustomerContact forgetByAll(RetailscmUserContext userContext, String potentialCustomerContactId, int potentialCustomerContactVersion) throws Exception {
		return forgetByAllInternal(userContext, potentialCustomerContactId, potentialCustomerContactVersion);
	}
	protected PotentialCustomerContact forgetByAllInternal(RetailscmUserContext userContext,
			String potentialCustomerContactId, int potentialCustomerContactVersion) throws Exception{

		return potentialCustomerContactDaoOf(userContext).disconnectFromAll(potentialCustomerContactId, potentialCustomerContactVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PotentialCustomerContactManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return potentialCustomerContactDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(RetailscmUserContext userContext, PotentialCustomerContact newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    potentialCustomerContactDaoOf(ctx).loadAllAsStream().forEach(
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
		//   PotentialCustomerContact newPotentialCustomerContact = this.createPotentialCustomerContact(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newPotentialCustomerContact
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, PotentialCustomerContact.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<PotentialCustomerContact> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<PotentialCustomer> potentialCustomerList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, PotentialCustomer.class);
		userContext.getDAOGroup().enhanceList(potentialCustomerList, PotentialCustomer.class);
		List<CityPartner> cityPartnerList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, CityPartner.class);
		userContext.getDAOGroup().enhanceList(cityPartnerList, CityPartner.class);
		List<PotentialCustomerContactPerson> contactToList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, PotentialCustomerContactPerson.class);
		userContext.getDAOGroup().enhanceList(contactToList, PotentialCustomerContactPerson.class);


    }
	
	public Object listByPotentialCustomer(RetailscmUserContext userContext,String potentialCustomerId) throws Exception {
		return listPageByPotentialCustomer(userContext, potentialCustomerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPotentialCustomer(RetailscmUserContext userContext,String potentialCustomerId, int start, int count) throws Exception {
		SmartList<PotentialCustomerContact> list = potentialCustomerContactDaoOf(userContext).findPotentialCustomerContactByPotentialCustomer(potentialCustomerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(PotentialCustomerContact.class);
		page.setContainerObject(PotentialCustomer.withId(potentialCustomerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("潜在客户联系列表");
		page.setRequestName("listByPotentialCustomer");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByPotentialCustomer/%s/",  getBeanName(), potentialCustomerId)));

		page.assemblerContent(userContext, "listByPotentialCustomer");
		return page.doRender(userContext);
	}
  
	public Object listByCityPartner(RetailscmUserContext userContext,String cityPartnerId) throws Exception {
		return listPageByCityPartner(userContext, cityPartnerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCityPartner(RetailscmUserContext userContext,String cityPartnerId, int start, int count) throws Exception {
		SmartList<PotentialCustomerContact> list = potentialCustomerContactDaoOf(userContext).findPotentialCustomerContactByCityPartner(cityPartnerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(PotentialCustomerContact.class);
		page.setContainerObject(CityPartner.withId(cityPartnerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("潜在客户联系列表");
		page.setRequestName("listByCityPartner");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCityPartner/%s/",  getBeanName(), cityPartnerId)));

		page.assemblerContent(userContext, "listByCityPartner");
		return page.doRender(userContext);
	}
  
	public Object listByContactTo(RetailscmUserContext userContext,String contactToId) throws Exception {
		return listPageByContactTo(userContext, contactToId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByContactTo(RetailscmUserContext userContext,String contactToId, int start, int count) throws Exception {
		SmartList<PotentialCustomerContact> list = potentialCustomerContactDaoOf(userContext).findPotentialCustomerContactByContactTo(contactToId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(PotentialCustomerContact.class);
		page.setContainerObject(PotentialCustomerContactPerson.withId(contactToId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("潜在客户联系列表");
		page.setRequestName("listByContactTo");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByContactTo/%s/",  getBeanName(), contactToId)));

		page.assemblerContent(userContext, "listByContactTo");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String potentialCustomerContactId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getPotentialCustomerContactDetailScope().clone();
		PotentialCustomerContact merchantObj = (PotentialCustomerContact) this.view(userContext, potentialCustomerContactId);
    String merchantObjId = potentialCustomerContactId;
    String linkToUrl =	"potentialCustomerContactManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "潜在客户联系"+"详情";
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
				MapUtil.put("id", "3-contactDate")
				    .put("fieldName", "contactDate")
				    .put("label", "接触日期")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("contactDate", merchantObj.getContactDate());

		propList.add(
				MapUtil.put("id", "4-contactMethod")
				    .put("fieldName", "contactMethod")
				    .put("label", "接触法")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("contactMethod", merchantObj.getContactMethod());

		propList.add(
				MapUtil.put("id", "5-potentialCustomer")
				    .put("fieldName", "potentialCustomer")
				    .put("label", "潜在的客户")
				    .put("type", "auto")
				    .put("linkToUrl", "potentialCustomerManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("potentialCustomer", merchantObj.getPotentialCustomer());

		propList.add(
				MapUtil.put("id", "6-cityPartner")
				    .put("fieldName", "cityPartner")
				    .put("label", "城市合伙人")
				    .put("type", "auto")
				    .put("linkToUrl", "cityPartnerManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("cityPartner", merchantObj.getCityPartner());

		propList.add(
				MapUtil.put("id", "7-contactTo")
				    .put("fieldName", "contactTo")
				    .put("label", "接触")
				    .put("type", "auto")
				    .put("linkToUrl", "potentialCustomerContactPersonManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("contactTo", merchantObj.getContactTo());

		propList.add(
				MapUtil.put("id", "8-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "9-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "更新于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

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


