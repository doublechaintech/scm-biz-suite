
package com.doublechaintech.retailscm.publicholiday;

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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;







public class PublicHolidayManagerImpl extends CustomRetailscmCheckerManager implements PublicHolidayManager {
	
	private static final String SERVICE_TYPE = "PublicHoliday";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PublicHolidayManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PublicHolidayManagerException(message);

	}
	
	

 	protected PublicHoliday savePublicHoliday(RetailscmUserContext userContext, PublicHoliday publicHoliday, String [] tokensExpr) throws Exception{	
 		//return getPublicHolidayDAO().save(publicHoliday, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePublicHoliday(userContext, publicHoliday, tokens);
 	}
 	
 	protected PublicHoliday savePublicHolidayDetail(RetailscmUserContext userContext, PublicHoliday publicHoliday) throws Exception{	

 		
 		return savePublicHoliday(userContext, publicHoliday, allTokens());
 	}
 	
 	public PublicHoliday loadPublicHoliday(RetailscmUserContext userContext, String publicHolidayId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPublicHoliday(publicHolidayId);
		userContext.getChecker().throwExceptionIfHasErrors( PublicHolidayManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PublicHoliday publicHoliday = loadPublicHoliday( userContext, publicHolidayId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,publicHoliday, tokens);
 	}
 	
 	
 	 public PublicHoliday searchPublicHoliday(RetailscmUserContext userContext, String publicHolidayId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfPublicHoliday(publicHolidayId);
		userContext.getChecker().throwExceptionIfHasErrors( PublicHolidayManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		PublicHoliday publicHoliday = loadPublicHoliday( userContext, publicHolidayId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,publicHoliday, tokens);
 	}
 	
 	

 	protected PublicHoliday present(RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,publicHoliday,tokens);
		
		
		PublicHoliday  publicHolidayToPresent = userContext.getDAOGroup().getPublicHolidayDAO().present(publicHoliday, tokens);
		
		List<BaseEntity> entityListToNaming = publicHolidayToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getPublicHolidayDAO().alias(entityListToNaming);
		
		return  publicHolidayToPresent;
		
		
	}
 
 	
 	
 	public PublicHoliday loadPublicHolidayDetail(RetailscmUserContext userContext, String publicHolidayId) throws Exception{	
 		PublicHoliday publicHoliday = loadPublicHoliday( userContext, publicHolidayId, allTokens());
 		return present(userContext,publicHoliday, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String publicHolidayId) throws Exception{	
 		PublicHoliday publicHoliday = loadPublicHoliday( userContext, publicHolidayId, viewTokens());
 		return present(userContext,publicHoliday, allTokens());
		
 	}
 	protected PublicHoliday savePublicHoliday(RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getPublicHolidayDAO().save(publicHoliday, tokens);
 	}
 	protected PublicHoliday loadPublicHoliday(RetailscmUserContext userContext, String publicHolidayId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfPublicHoliday(publicHolidayId);
		userContext.getChecker().throwExceptionIfHasErrors( PublicHolidayManagerException.class);

 
 		return userContext.getDAOGroup().getPublicHolidayDAO().load(publicHolidayId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> tokens){
		super.addActions(userContext, publicHoliday, tokens);
		
		addAction(userContext, publicHoliday, tokens,"@create","createPublicHoliday","createPublicHoliday/","main","primary");
		addAction(userContext, publicHoliday, tokens,"@update","updatePublicHoliday","updatePublicHoliday/"+publicHoliday.getId()+"/","main","primary");
		addAction(userContext, publicHoliday, tokens,"@copy","clonePublicHoliday","clonePublicHoliday/"+publicHoliday.getId()+"/","main","primary");
		
		addAction(userContext, publicHoliday, tokens,"public_holiday.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+publicHoliday.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public PublicHoliday createPublicHoliday(RetailscmUserContext userContext,String code, String companyId, String name, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkCodeOfPublicHoliday(code);
		userContext.getChecker().checkNameOfPublicHoliday(name);
		userContext.getChecker().checkDescriptionOfPublicHoliday(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(PublicHolidayManagerException.class);


		PublicHoliday publicHoliday=createNewPublicHoliday();	

		publicHoliday.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		publicHoliday.setCompany(company);
		
		
		publicHoliday.setName(name);
		publicHoliday.setDescription(description);

		publicHoliday = savePublicHoliday(userContext, publicHoliday, emptyOptions());
		
		onNewInstanceCreated(userContext, publicHoliday);
		return publicHoliday;

		
	}
	protected PublicHoliday createNewPublicHoliday() 
	{
		
		return new PublicHoliday();		
	}
	
	protected void checkParamsForUpdatingPublicHoliday(RetailscmUserContext userContext,String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfPublicHoliday(publicHolidayId);
		userContext.getChecker().checkVersionOfPublicHoliday( publicHolidayVersion);
		

		if(PublicHoliday.CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkCodeOfPublicHoliday(parseString(newValueExpr));
		}		

		
		if(PublicHoliday.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfPublicHoliday(parseString(newValueExpr));
		}
		if(PublicHoliday.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfPublicHoliday(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(PublicHolidayManagerException.class);
	
		
	}
	
	
	
	public PublicHoliday clone(RetailscmUserContext userContext, String fromPublicHolidayId) throws Exception{
		
		return userContext.getDAOGroup().getPublicHolidayDAO().clone(fromPublicHolidayId, this.allTokens());
	}
	
	public PublicHoliday internalSavePublicHoliday(RetailscmUserContext userContext, PublicHoliday publicHoliday) throws Exception 
	{
		return internalSavePublicHoliday(userContext, publicHoliday, allTokens());

	}
	public PublicHoliday internalSavePublicHoliday(RetailscmUserContext userContext, PublicHoliday publicHoliday, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPublicHoliday(userContext, publicHolidayId, publicHolidayVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(publicHoliday){ 
			//will be good when the publicHoliday loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PublicHoliday.
			
			
			publicHoliday = savePublicHoliday(userContext, publicHoliday, options);
			return publicHoliday;
			
		}

	}
	
	public PublicHoliday updatePublicHoliday(RetailscmUserContext userContext,String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPublicHoliday(userContext, publicHolidayId, publicHolidayVersion, property, newValueExpr, tokensExpr);
		
		
		
		PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, allTokens());
		if(publicHoliday.getVersion() != publicHolidayVersion){
			String message = "The target version("+publicHoliday.getVersion()+") is not equals to version("+publicHolidayVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(publicHoliday){ 
			//will be good when the publicHoliday loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PublicHoliday.
			
			publicHoliday.changeProperty(property, newValueExpr);
			publicHoliday = savePublicHoliday(userContext, publicHoliday, tokens().done());
			return present(userContext,publicHoliday, mergedAllTokens(tokensExpr));
			//return savePublicHoliday(userContext, publicHoliday, tokens().done());
		}

	}
	
	public PublicHoliday updatePublicHolidayProperty(RetailscmUserContext userContext,String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPublicHoliday(userContext, publicHolidayId, publicHolidayVersion, property, newValueExpr, tokensExpr);
		
		PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, allTokens());
		if(publicHoliday.getVersion() != publicHolidayVersion){
			String message = "The target version("+publicHoliday.getVersion()+") is not equals to version("+publicHolidayVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(publicHoliday){ 
			//will be good when the publicHoliday loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PublicHoliday.
			
			publicHoliday.changeProperty(property, newValueExpr);
			
			publicHoliday = savePublicHoliday(userContext, publicHoliday, tokens().done());
			return present(userContext,publicHoliday, mergedAllTokens(tokensExpr));
			//return savePublicHoliday(userContext, publicHoliday, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PublicHolidayTokens tokens(){
		return PublicHolidayTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PublicHolidayTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PublicHolidayTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String publicHolidayId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfPublicHoliday(publicHolidayId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(PublicHolidayManagerException.class);
 		
 	}
 	public PublicHoliday transferToAnotherCompany(RetailscmUserContext userContext, String publicHolidayId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, publicHolidayId,anotherCompanyId);
 
		PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, allTokens());	
		synchronized(publicHoliday){
			//will be good when the publicHoliday loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			publicHoliday.updateCompany(company);		
			publicHoliday = savePublicHoliday(userContext, publicHoliday, emptyOptions());
			
			return present(userContext,publicHoliday, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateCompany(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForPublicHoliday(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String publicHolidayId, int publicHolidayVersion) throws Exception {
		//deleteInternal(userContext, publicHolidayId, publicHolidayVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String publicHolidayId, int publicHolidayVersion) throws Exception{
			
		userContext.getDAOGroup().getPublicHolidayDAO().delete(publicHolidayId, publicHolidayVersion);
	}
	
	public PublicHoliday forgetByAll(RetailscmUserContext userContext, String publicHolidayId, int publicHolidayVersion) throws Exception {
		return forgetByAllInternal(userContext, publicHolidayId, publicHolidayVersion);		
	}
	protected PublicHoliday forgetByAllInternal(RetailscmUserContext userContext,
			String publicHolidayId, int publicHolidayVersion) throws Exception{
			
		return userContext.getDAOGroup().getPublicHolidayDAO().disconnectFromAll(publicHolidayId, publicHolidayVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PublicHolidayManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getPublicHolidayDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, PublicHoliday newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


