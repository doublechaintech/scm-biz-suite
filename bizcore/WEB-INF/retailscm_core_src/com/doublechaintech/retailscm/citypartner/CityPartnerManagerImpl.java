
package com.doublechaintech.retailscm.citypartner;

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
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstorecityservicecenter.CandidateRetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;






public class CityPartnerManagerImpl extends CustomRetailscmCheckerManager implements CityPartnerManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = CityPartnerTokens.start().withTokenFromListName(listName).done();
		CityPartner  cityPartner = (CityPartner) this.loadCityPartner(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = cityPartner.collectRefercencesFromLists();
		cityPartnerDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, cityPartner, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new CityPartnerGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "CityPartner";
	@Override
	public CityPartnerDAO daoOf(RetailscmUserContext userContext) {
		return cityPartnerDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityPartnerManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CityPartner cityPartner = loadCityPartner( userContext, cityPartnerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityPartner, tokens);
 	}
 	
 	
 	 public CityPartner searchCityPartner(RetailscmUserContext userContext, String cityPartnerId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityPartnerManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		CityPartner cityPartner = loadCityPartner( userContext, cityPartnerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,cityPartner, tokens);
 	}
 	
 	

 	protected CityPartner present(RetailscmUserContext userContext, CityPartner cityPartner, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,cityPartner,tokens);
		
		
		CityPartner  cityPartnerToPresent = cityPartnerDaoOf(userContext).present(cityPartner, tokens);
		
		List<BaseEntity> entityListToNaming = cityPartnerToPresent.collectRefercencesFromLists();
		cityPartnerDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,cityPartner,tokens);
		
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
 		return cityPartnerDaoOf(userContext).save(cityPartner, tokens);
 	}
 	protected CityPartner loadCityPartner(RetailscmUserContext userContext, String cityPartnerId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityPartnerManagerException.class);

 
 		return cityPartnerDaoOf(userContext).load(cityPartnerId, tokens);
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
	
 	
 	
 
 	
 	

	public CityPartner createCityPartner(RetailscmUserContext userContext, String name,String mobile,String cityServiceCenterId,String description) throws Exception
	//public CityPartner createCityPartner(RetailscmUserContext userContext,String name, String mobile, String cityServiceCenterId, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfCityPartner(name);
		checkerOf(userContext).checkMobileOfCityPartner(mobile);
		checkerOf(userContext).checkDescriptionOfCityPartner(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
		checkerOf(userContext).checkVersionOfCityPartner( cityPartnerVersion);
		

		if(CityPartner.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCityPartner(parseString(newValueExpr));
		
			
		}
		if(CityPartner.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfCityPartner(parseString(newValueExpr));
		
			
		}		

		
		if(CityPartner.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfCityPartner(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);


	}



	public CityPartner clone(RetailscmUserContext userContext, String fromCityPartnerId) throws Exception{

		return cityPartnerDaoOf(userContext).clone(fromCityPartnerId, this.allTokens());
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
			if (cityPartner.isChanged()){
			cityPartner.updateLastUpdateTime(userContext.now());
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CityPartnerTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCityServiceCenter(RetailscmUserContext userContext, String cityPartnerId, String anotherCityServiceCenterId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
 		checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(anotherCityServiceCenterId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);

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
		SmartList<RetailStoreCityServiceCenter> candidateList = retailStoreCityServiceCenterDaoOf(userContext).requestCandidateRetailStoreCityServiceCenterForCityPartner(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(RetailscmUserContext userContext, String newCityServiceCenterId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCityServiceCenterDaoOf(userContext).load(newCityServiceCenterId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String cityPartnerId, int cityPartnerVersion) throws Exception {
		//deleteInternal(userContext, cityPartnerId, cityPartnerVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String cityPartnerId, int cityPartnerVersion) throws Exception{

		cityPartnerDaoOf(userContext).delete(cityPartnerId, cityPartnerVersion);
	}

	public CityPartner forgetByAll(RetailscmUserContext userContext, String cityPartnerId, int cityPartnerVersion) throws Exception {
		return forgetByAllInternal(userContext, cityPartnerId, cityPartnerVersion);
	}
	protected CityPartner forgetByAllInternal(RetailscmUserContext userContext,
			String cityPartnerId, int cityPartnerVersion) throws Exception{

		return cityPartnerDaoOf(userContext).disconnectFromAll(cityPartnerId, cityPartnerVersion);
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
		return cityPartnerDaoOf(userContext).deleteAll();
	}


	//disconnect CityPartner with city_service_center in PotentialCustomer
	protected CityPartner breakWithPotentialCustomerByCityServiceCenter(RetailscmUserContext userContext, String cityPartnerId, String cityServiceCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());

			synchronized(cityPartner){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				cityPartnerDaoOf(userContext).planToRemovePotentialCustomerListWithCityServiceCenter(cityPartner, cityServiceCenterId, this.emptyOptions());

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

				cityPartnerDaoOf(userContext).planToRemovePotentialCustomerContactListWithPotentialCustomer(cityPartner, potentialCustomerId, this.emptyOptions());

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

				cityPartnerDaoOf(userContext).planToRemovePotentialCustomerContactListWithContactTo(cityPartner, contactToId, this.emptyOptions());

				cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
				return cityPartner;
			}
	}






	protected void checkParamsForAddingPotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, String name, String mobile, String cityServiceCenterId, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);

		
		checkerOf(userContext).checkNameOfPotentialCustomer(name);
		
		checkerOf(userContext).checkMobileOfPotentialCustomer(mobile);
		
		checkerOf(userContext).checkCityServiceCenterIdOfPotentialCustomer(cityServiceCenterId);
		
		checkerOf(userContext).checkDescriptionOfPotentialCustomer(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);


	}
	public  CityPartner addPotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, String name, String mobile, String cityServiceCenterId, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingPotentialCustomer(userContext,cityPartnerId,name, mobile, cityServiceCenterId, description,tokensExpr);

		PotentialCustomer potentialCustomer = createPotentialCustomer(userContext,name, mobile, cityServiceCenterId, description);

		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, emptyOptions());
		synchronized(cityPartner){
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityPartner.addPotentialCustomer( potentialCustomer );
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
			
			potentialCustomerManagerOf(userContext).onNewInstanceCreated(userContext, potentialCustomer);
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPotentialCustomerProperties(RetailscmUserContext userContext, String cityPartnerId,String id,String name,String mobile,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
		checkerOf(userContext).checkIdOfPotentialCustomer(id);

		checkerOf(userContext).checkNameOfPotentialCustomer( name);
		checkerOf(userContext).checkMobileOfPotentialCustomer( mobile);
		checkerOf(userContext).checkDescriptionOfPotentialCustomer( description);

		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);

	}
	public  CityPartner updatePotentialCustomerProperties(RetailscmUserContext userContext, String cityPartnerId, String id,String name,String mobile,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPotentialCustomerProperties(userContext,cityPartnerId,id,name,mobile,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPotentialCustomerListList()
				.searchPotentialCustomerListWith(PotentialCustomer.ID_PROPERTY, tokens().is(), id).done();

		CityPartner cityPartnerToUpdate = loadCityPartner(userContext, cityPartnerId, options);

		if(cityPartnerToUpdate.getPotentialCustomerList().isEmpty()){
			throw new CityPartnerManagerException("PotentialCustomer is NOT FOUND with id: '"+id+"'");
		}

		PotentialCustomer item = cityPartnerToUpdate.getPotentialCustomerList().first();
		beforeUpdatePotentialCustomerProperties(userContext,item, cityPartnerId,id,name,mobile,description,tokensExpr);
		item.updateName( name );
		item.updateMobile( mobile );
		item.updateDescription( description );


		//checkParamsForAddingPotentialCustomer(userContext,cityPartnerId,name, code, used,tokensExpr);
		CityPartner cityPartner = saveCityPartner(userContext, cityPartnerToUpdate, tokens().withPotentialCustomerList().done());
		synchronized(cityPartner){
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdatePotentialCustomerProperties(RetailscmUserContext userContext, PotentialCustomer item, String cityPartnerId, String id,String name,String mobile,String description, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
		for(String potentialCustomerIdItem: potentialCustomerIds){
			checkerOf(userContext).checkIdOfPotentialCustomer(potentialCustomerIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);

	}
	public  CityPartner removePotentialCustomerList(RetailscmUserContext userContext, String cityPartnerId,
			String potentialCustomerIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingPotentialCustomerList(userContext, cityPartnerId,  potentialCustomerIds, tokensExpr);


			CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
			synchronized(cityPartner){
				//Will be good when the cityPartner loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				cityPartnerDaoOf(userContext).planToRemovePotentialCustomerList(cityPartner, potentialCustomerIds, allTokens());
				cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
				deleteRelationListInGraph(userContext, cityPartner.getPotentialCustomerList());
				return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingPotentialCustomer(RetailscmUserContext userContext, String cityPartnerId,
		String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCityPartner( cityPartnerId);
		checkerOf(userContext).checkIdOfPotentialCustomer(potentialCustomerId);
		checkerOf(userContext).checkVersionOfPotentialCustomer(potentialCustomerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);

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
		
		checkerOf(userContext).checkIdOfCityPartner( cityPartnerId);
		checkerOf(userContext).checkIdOfPotentialCustomer(potentialCustomerId);
		checkerOf(userContext).checkVersionOfPotentialCustomer(potentialCustomerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);

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
			
			potentialCustomerManagerOf(userContext).onNewInstanceCreated(userContext, (PotentialCustomer)cityPartner.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingPotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
		checkerOf(userContext).checkIdOfPotentialCustomer(potentialCustomerId);
		checkerOf(userContext).checkVersionOfPotentialCustomer(potentialCustomerVersion);


		if(PotentialCustomer.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfPotentialCustomer(parseString(newValueExpr));
		}
		
		if(PotentialCustomer.MOBILE_PROPERTY.equals(property)){
			checkerOf(userContext).checkMobileOfPotentialCustomer(parseString(newValueExpr));
		}
		
		if(PotentialCustomer.DESCRIPTION_PROPERTY.equals(property)){
			checkerOf(userContext).checkDescriptionOfPotentialCustomer(parseString(newValueExpr));
		}
		

		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);

	}

	public  CityPartner updatePotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingPotentialCustomer(userContext, cityPartnerId, potentialCustomerId, potentialCustomerVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withPotentialCustomerList().searchPotentialCustomerListWith(PotentialCustomer.ID_PROPERTY, tokens().equals(), potentialCustomerId).done();



		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, loadTokens);

		synchronized(cityPartner){
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//cityPartner.removePotentialCustomer( potentialCustomer );
			//make changes to AcceleraterAccount.
			PotentialCustomer potentialCustomerIdVersionKey = createIndexedPotentialCustomer(potentialCustomerId, potentialCustomerVersion);

			PotentialCustomer potentialCustomer = cityPartner.findThePotentialCustomer(potentialCustomerIdVersionKey);
			if(potentialCustomer == null){
				throw new CityPartnerManagerException(potentialCustomerId+" is NOT FOUND" );
			}

			beforeUpdatePotentialCustomer(userContext, potentialCustomer, cityPartnerId, potentialCustomerId, potentialCustomerVersion, property, newValueExpr,  tokensExpr);
			potentialCustomer.changeProperty(property, newValueExpr);
			potentialCustomer.updateLastUpdateTime(userContext.now());
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerList().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdatePotentialCustomer(RetailscmUserContext userContext, PotentialCustomer existed, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingPotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);

		
		checkerOf(userContext).checkNameOfPotentialCustomerContact(name);
		
		checkerOf(userContext).checkContactDateOfPotentialCustomerContact(contactDate);
		
		checkerOf(userContext).checkContactMethodOfPotentialCustomerContact(contactMethod);
		
		checkerOf(userContext).checkPotentialCustomerIdOfPotentialCustomerContact(potentialCustomerId);
		
		checkerOf(userContext).checkContactToIdOfPotentialCustomerContact(contactToId);
		
		checkerOf(userContext).checkDescriptionOfPotentialCustomerContact(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);


	}
	public  CityPartner addPotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingPotentialCustomerContact(userContext,cityPartnerId,name, contactDate, contactMethod, potentialCustomerId, contactToId, description,tokensExpr);

		PotentialCustomerContact potentialCustomerContact = createPotentialCustomerContact(userContext,name, contactDate, contactMethod, potentialCustomerId, contactToId, description);

		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, emptyOptions());
		synchronized(cityPartner){
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			cityPartner.addPotentialCustomerContact( potentialCustomerContact );
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
			
			potentialCustomerContactManagerOf(userContext).onNewInstanceCreated(userContext, potentialCustomerContact);
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPotentialCustomerContactProperties(RetailscmUserContext userContext, String cityPartnerId,String id,String name,Date contactDate,String contactMethod,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
		checkerOf(userContext).checkIdOfPotentialCustomerContact(id);

		checkerOf(userContext).checkNameOfPotentialCustomerContact( name);
		checkerOf(userContext).checkContactDateOfPotentialCustomerContact( contactDate);
		checkerOf(userContext).checkContactMethodOfPotentialCustomerContact( contactMethod);
		checkerOf(userContext).checkDescriptionOfPotentialCustomerContact( description);

		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);

	}
	public  CityPartner updatePotentialCustomerContactProperties(RetailscmUserContext userContext, String cityPartnerId, String id,String name,Date contactDate,String contactMethod,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPotentialCustomerContactProperties(userContext,cityPartnerId,id,name,contactDate,contactMethod,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPotentialCustomerContactListList()
				.searchPotentialCustomerContactListWith(PotentialCustomerContact.ID_PROPERTY, tokens().is(), id).done();

		CityPartner cityPartnerToUpdate = loadCityPartner(userContext, cityPartnerId, options);

		if(cityPartnerToUpdate.getPotentialCustomerContactList().isEmpty()){
			throw new CityPartnerManagerException("PotentialCustomerContact is NOT FOUND with id: '"+id+"'");
		}

		PotentialCustomerContact item = cityPartnerToUpdate.getPotentialCustomerContactList().first();
		beforeUpdatePotentialCustomerContactProperties(userContext,item, cityPartnerId,id,name,contactDate,contactMethod,description,tokensExpr);
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

	protected  void beforeUpdatePotentialCustomerContactProperties(RetailscmUserContext userContext, PotentialCustomerContact item, String cityPartnerId, String id,String name,Date contactDate,String contactMethod,String description, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
		for(String potentialCustomerContactIdItem: potentialCustomerContactIds){
			checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);

	}
	public  CityPartner removePotentialCustomerContactList(RetailscmUserContext userContext, String cityPartnerId,
			String potentialCustomerContactIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingPotentialCustomerContactList(userContext, cityPartnerId,  potentialCustomerContactIds, tokensExpr);


			CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, allTokens());
			synchronized(cityPartner){
				//Will be good when the cityPartner loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				cityPartnerDaoOf(userContext).planToRemovePotentialCustomerContactList(cityPartner, potentialCustomerContactIds, allTokens());
				cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
				deleteRelationListInGraph(userContext, cityPartner.getPotentialCustomerContactList());
				return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingPotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId,
		String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCityPartner( cityPartnerId);
		checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		checkerOf(userContext).checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);

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
		
		checkerOf(userContext).checkIdOfCityPartner( cityPartnerId);
		checkerOf(userContext).checkIdOfPotentialCustomerContact(potentialCustomerContactId);
		checkerOf(userContext).checkVersionOfPotentialCustomerContact(potentialCustomerContactVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);

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
			
			potentialCustomerContactManagerOf(userContext).onNewInstanceCreated(userContext, (PotentialCustomerContact)cityPartner.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingPotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfCityPartner(cityPartnerId);
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
		

		checkerOf(userContext).throwExceptionIfHasErrors(CityPartnerManagerException.class);

	}

	public  CityPartner updatePotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingPotentialCustomerContact(userContext, cityPartnerId, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withPotentialCustomerContactList().searchPotentialCustomerContactListWith(PotentialCustomerContact.ID_PROPERTY, tokens().equals(), potentialCustomerContactId).done();



		CityPartner cityPartner = loadCityPartner(userContext, cityPartnerId, loadTokens);

		synchronized(cityPartner){
			//Will be good when the cityPartner loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//cityPartner.removePotentialCustomerContact( potentialCustomerContact );
			//make changes to AcceleraterAccount.
			PotentialCustomerContact potentialCustomerContactIdVersionKey = createIndexedPotentialCustomerContact(potentialCustomerContactId, potentialCustomerContactVersion);

			PotentialCustomerContact potentialCustomerContact = cityPartner.findThePotentialCustomerContact(potentialCustomerContactIdVersionKey);
			if(potentialCustomerContact == null){
				throw new CityPartnerManagerException(potentialCustomerContactId+" is NOT FOUND" );
			}

			beforeUpdatePotentialCustomerContact(userContext, potentialCustomerContact, cityPartnerId, potentialCustomerContactId, potentialCustomerContactVersion, property, newValueExpr,  tokensExpr);
			potentialCustomerContact.changeProperty(property, newValueExpr);
			potentialCustomerContact.updateLastUpdateTime(userContext.now());
			cityPartner = saveCityPartner(userContext, cityPartner, tokens().withPotentialCustomerContactList().done());
			return present(userContext,cityPartner, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdatePotentialCustomerContact(RetailscmUserContext userContext, PotentialCustomerContact existed, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, CityPartner newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    cityPartnerDaoOf(ctx).loadAllAsStream().forEach(
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
		//   CityPartner newCityPartner = this.createCityPartner(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newCityPartner
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, CityPartner.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<CityPartner> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCityServiceCenter> cityServiceCenterList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCityServiceCenter.class);
		userContext.getDAOGroup().enhanceList(cityServiceCenterList, RetailStoreCityServiceCenter.class);


    }
	
	public Object listByCityServiceCenter(RetailscmUserContext userContext,String cityServiceCenterId) throws Exception {
		return listPageByCityServiceCenter(userContext, cityServiceCenterId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCityServiceCenter(RetailscmUserContext userContext,String cityServiceCenterId, int start, int count) throws Exception {
		SmartList<CityPartner> list = cityPartnerDaoOf(userContext).findCityPartnerByCityServiceCenter(cityServiceCenterId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(CityPartner.class);
		page.setContainerObject(RetailStoreCityServiceCenter.withId(cityServiceCenterId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("城市合伙人列表");
		page.setRequestName("listByCityServiceCenter");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCityServiceCenter/%s/",  getBeanName(), cityServiceCenterId)));

		page.assemblerContent(userContext, "listByCityServiceCenter");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String cityPartnerId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getCityPartnerDetailScope().clone();
		CityPartner merchantObj = (CityPartner) this.view(userContext, cityPartnerId);
    String merchantObjId = cityPartnerId;
    String linkToUrl =	"cityPartnerManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "城市合伙人"+"详情";
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
				MapUtil.put("id", "4-cityServiceCenter")
				    .put("fieldName", "cityServiceCenter")
				    .put("label", "城市服务中心")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCityServiceCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("cityServiceCenter", merchantObj.getCityServiceCenter());

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

		propList.add(
				MapUtil.put("id", "6-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "更新于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：potentialCustomerListSection
		Map potentialCustomerListSection = ListofUtils.buildSection(
		    "potentialCustomerListSection",
		    "潜在客户列表",
		    null,
		    "",
		    "__no_group",
		    "potentialCustomerManager/listByCityPartner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(potentialCustomerListSection);

		result.put("potentialCustomerListSection", ListofUtils.toShortList(merchantObj.getPotentialCustomerList(), "potentialCustomer"));
		vscope.field("potentialCustomerListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( PotentialCustomer.class.getName(), null));

		//处理Section：potentialCustomerContactListSection
		Map potentialCustomerContactListSection = ListofUtils.buildSection(
		    "potentialCustomerContactListSection",
		    "潜在客户联络名单",
		    null,
		    "",
		    "__no_group",
		    "potentialCustomerContactManager/listByCityPartner/"+merchantObjId+"/",
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


