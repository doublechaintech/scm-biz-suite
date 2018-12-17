
package com.doublechaintech.retailscm.terminationtype;

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

import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;






public class TerminationTypeManagerImpl extends CustomRetailscmCheckerManager implements TerminationTypeManager {
	
	private static final String SERVICE_TYPE = "TerminationType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TerminationTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TerminationTypeManagerException(message);

	}
	
	

 	protected TerminationType saveTerminationType(RetailscmUserContext userContext, TerminationType terminationType, String [] tokensExpr) throws Exception{	
 		//return getTerminationTypeDAO().save(terminationType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTerminationType(userContext, terminationType, tokens);
 	}
 	
 	protected TerminationType saveTerminationTypeDetail(RetailscmUserContext userContext, TerminationType terminationType) throws Exception{	

 		
 		return saveTerminationType(userContext, terminationType, allTokens());
 	}
 	
 	public TerminationType loadTerminationType(RetailscmUserContext userContext, String terminationTypeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTerminationType(terminationTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( TerminationTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TerminationType terminationType = loadTerminationType( userContext, terminationTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,terminationType, tokens);
 	}
 	
 	
 	 public TerminationType searchTerminationType(RetailscmUserContext userContext, String terminationTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTerminationType(terminationTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( TerminationTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TerminationType terminationType = loadTerminationType( userContext, terminationTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,terminationType, tokens);
 	}
 	
 	

 	protected TerminationType present(RetailscmUserContext userContext, TerminationType terminationType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,terminationType,tokens);
		
		
		TerminationType  terminationTypeToPresent = userContext.getDAOGroup().getTerminationTypeDAO().present(terminationType, tokens);
		
		List<BaseEntity> entityListToNaming = terminationTypeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTerminationTypeDAO().alias(entityListToNaming);
		
		return  terminationTypeToPresent;
		
		
	}
 
 	
 	
 	public TerminationType loadTerminationTypeDetail(RetailscmUserContext userContext, String terminationTypeId) throws Exception{	
 		TerminationType terminationType = loadTerminationType( userContext, terminationTypeId, allTokens());
 		return present(userContext,terminationType, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String terminationTypeId) throws Exception{	
 		TerminationType terminationType = loadTerminationType( userContext, terminationTypeId, viewTokens());
 		return present(userContext,terminationType, allTokens());
		
 	}
 	protected TerminationType saveTerminationType(RetailscmUserContext userContext, TerminationType terminationType, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTerminationTypeDAO().save(terminationType, tokens);
 	}
 	protected TerminationType loadTerminationType(RetailscmUserContext userContext, String terminationTypeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTerminationType(terminationTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( TerminationTypeManagerException.class);

 
 		return userContext.getDAOGroup().getTerminationTypeDAO().load(terminationTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TerminationType terminationType, Map<String, Object> tokens){
		super.addActions(userContext, terminationType, tokens);
		
		addAction(userContext, terminationType, tokens,"@create","createTerminationType","createTerminationType/","main","primary");
		addAction(userContext, terminationType, tokens,"@update","updateTerminationType","updateTerminationType/"+terminationType.getId()+"/","main","primary");
		addAction(userContext, terminationType, tokens,"@copy","cloneTerminationType","cloneTerminationType/"+terminationType.getId()+"/","main","primary");
		
		addAction(userContext, terminationType, tokens,"termination_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+terminationType.getId()+"/","main","primary");
		addAction(userContext, terminationType, tokens,"termination_type.addTermination","addTermination","addTermination/"+terminationType.getId()+"/","terminationList","primary");
		addAction(userContext, terminationType, tokens,"termination_type.removeTermination","removeTermination","removeTermination/"+terminationType.getId()+"/","terminationList","primary");
		addAction(userContext, terminationType, tokens,"termination_type.updateTermination","updateTermination","updateTermination/"+terminationType.getId()+"/","terminationList","primary");
		addAction(userContext, terminationType, tokens,"termination_type.copyTerminationFrom","copyTerminationFrom","copyTerminationFrom/"+terminationType.getId()+"/","terminationList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TerminationType terminationType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TerminationType createTerminationType(RetailscmUserContext userContext,String code, String companyId, String baseDescription, String detailDescription) throws Exception
	{
		
		

		

		userContext.getChecker().checkCodeOfTerminationType(code);
		userContext.getChecker().checkBaseDescriptionOfTerminationType(baseDescription);
		userContext.getChecker().checkDetailDescriptionOfTerminationType(detailDescription);
	
		userContext.getChecker().throwExceptionIfHasErrors(TerminationTypeManagerException.class);


		TerminationType terminationType=createNewTerminationType();	

		terminationType.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		terminationType.setCompany(company);
		
		
		terminationType.setBaseDescription(baseDescription);
		terminationType.setDetailDescription(detailDescription);

		terminationType = saveTerminationType(userContext, terminationType, emptyOptions());
		
		onNewInstanceCreated(userContext, terminationType);
		return terminationType;

		
	}
	protected TerminationType createNewTerminationType() 
	{
		
		return new TerminationType();		
	}
	
	protected void checkParamsForUpdatingTerminationType(RetailscmUserContext userContext,String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTerminationType(terminationTypeId);
		userContext.getChecker().checkVersionOfTerminationType( terminationTypeVersion);
		

		if(TerminationType.CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkCodeOfTerminationType(parseString(newValueExpr));
		}		

		
		if(TerminationType.BASE_DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkBaseDescriptionOfTerminationType(parseString(newValueExpr));
		}
		if(TerminationType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDetailDescriptionOfTerminationType(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(TerminationTypeManagerException.class);
	
		
	}
	
	
	
	public TerminationType clone(RetailscmUserContext userContext, String fromTerminationTypeId) throws Exception{
		
		return userContext.getDAOGroup().getTerminationTypeDAO().clone(fromTerminationTypeId, this.allTokens());
	}
	
	public TerminationType internalSaveTerminationType(RetailscmUserContext userContext, TerminationType terminationType) throws Exception 
	{
		return internalSaveTerminationType(userContext, terminationType, allTokens());

	}
	public TerminationType internalSaveTerminationType(RetailscmUserContext userContext, TerminationType terminationType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTerminationType(userContext, terminationTypeId, terminationTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(terminationType){ 
			//will be good when the terminationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TerminationType.
			
			
			terminationType = saveTerminationType(userContext, terminationType, options);
			return terminationType;
			
		}

	}
	
	public TerminationType updateTerminationType(RetailscmUserContext userContext,String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTerminationType(userContext, terminationTypeId, terminationTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());
		if(terminationType.getVersion() != terminationTypeVersion){
			String message = "The target version("+terminationType.getVersion()+") is not equals to version("+terminationTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(terminationType){ 
			//will be good when the terminationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TerminationType.
			
			terminationType.changeProperty(property, newValueExpr);
			terminationType = saveTerminationType(userContext, terminationType, tokens().done());
			return present(userContext,terminationType, mergedAllTokens(tokensExpr));
			//return saveTerminationType(userContext, terminationType, tokens().done());
		}

	}
	
	public TerminationType updateTerminationTypeProperty(RetailscmUserContext userContext,String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTerminationType(userContext, terminationTypeId, terminationTypeVersion, property, newValueExpr, tokensExpr);
		
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());
		if(terminationType.getVersion() != terminationTypeVersion){
			String message = "The target version("+terminationType.getVersion()+") is not equals to version("+terminationTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(terminationType){ 
			//will be good when the terminationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TerminationType.
			
			terminationType.changeProperty(property, newValueExpr);
			
			terminationType = saveTerminationType(userContext, terminationType, tokens().done());
			return present(userContext,terminationType, mergedAllTokens(tokensExpr));
			//return saveTerminationType(userContext, terminationType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TerminationTypeTokens tokens(){
		return TerminationTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TerminationTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTerminationListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TerminationTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String terminationTypeId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTerminationType(terminationTypeId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TerminationTypeManagerException.class);
 		
 	}
 	public TerminationType transferToAnotherCompany(RetailscmUserContext userContext, String terminationTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, terminationTypeId,anotherCompanyId);
 
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());	
		synchronized(terminationType){
			//will be good when the terminationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			terminationType.updateCompany(company);		
			terminationType = saveTerminationType(userContext, terminationType, emptyOptions());
			
			return present(userContext,terminationType, allTokens());
			
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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForTerminationType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String terminationTypeId, int terminationTypeVersion) throws Exception {
		//deleteInternal(userContext, terminationTypeId, terminationTypeVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String terminationTypeId, int terminationTypeVersion) throws Exception{
			
		userContext.getDAOGroup().getTerminationTypeDAO().delete(terminationTypeId, terminationTypeVersion);
	}
	
	public TerminationType forgetByAll(RetailscmUserContext userContext, String terminationTypeId, int terminationTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, terminationTypeId, terminationTypeVersion);		
	}
	protected TerminationType forgetByAllInternal(RetailscmUserContext userContext,
			String terminationTypeId, int terminationTypeVersion) throws Exception{
			
		return userContext.getDAOGroup().getTerminationTypeDAO().disconnectFromAll(terminationTypeId, terminationTypeVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TerminationTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTerminationTypeDAO().deleteAll();
	}


	//disconnect TerminationType with reason in Termination
	protected TerminationType breakWithTerminationByReason(RetailscmUserContext userContext, String terminationTypeId, String reasonId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());

			synchronized(terminationType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTerminationTypeDAO().planToRemoveTerminationListWithReason(terminationType, reasonId, this.emptyOptions());

				terminationType = saveTerminationType(userContext, terminationType, tokens().withTerminationList().done());
				return terminationType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTermination(RetailscmUserContext userContext, String terminationTypeId, String reasonId, String comment,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTerminationType(terminationTypeId);

		
		userContext.getChecker().checkReasonIdOfTermination(reasonId);
		
		userContext.getChecker().checkCommentOfTermination(comment);
	
		userContext.getChecker().throwExceptionIfHasErrors(TerminationTypeManagerException.class);

	
	}
	public  TerminationType addTermination(RetailscmUserContext userContext, String terminationTypeId, String reasonId, String comment, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTermination(userContext,terminationTypeId,reasonId, comment,tokensExpr);
		
		Termination termination = createTermination(userContext,reasonId, comment);
		
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());
		synchronized(terminationType){ 
			//Will be good when the terminationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			terminationType.addTermination( termination );		
			terminationType = saveTerminationType(userContext, terminationType, tokens().withTerminationList().done());
			
			userContext.getManagerGroup().getTerminationManager().onNewInstanceCreated(userContext, termination);
			return present(userContext,terminationType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTerminationProperties(RetailscmUserContext userContext, String terminationTypeId,String id,String comment,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTerminationType(terminationTypeId);
		userContext.getChecker().checkIdOfTermination(id);
		
		userContext.getChecker().checkCommentOfTermination( comment);

		userContext.getChecker().throwExceptionIfHasErrors(TerminationTypeManagerException.class);
		
	}
	public  TerminationType updateTerminationProperties(RetailscmUserContext userContext, String terminationTypeId, String id,String comment, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTerminationProperties(userContext,terminationTypeId,id,comment,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTerminationListList()
				.searchTerminationListWith(Termination.ID_PROPERTY, "is", id).done();
		
		TerminationType terminationTypeToUpdate = loadTerminationType(userContext, terminationTypeId, options);
		
		if(terminationTypeToUpdate.getTerminationList().isEmpty()){
			throw new TerminationTypeManagerException("Termination is NOT FOUND with id: '"+id+"'");
		}
		
		Termination item = terminationTypeToUpdate.getTerminationList().first();
		
		item.updateComment( comment );

		
		//checkParamsForAddingTermination(userContext,terminationTypeId,name, code, used,tokensExpr);
		TerminationType terminationType = saveTerminationType(userContext, terminationTypeToUpdate, tokens().withTerminationList().done());
		synchronized(terminationType){ 
			return present(userContext,terminationType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Termination createTermination(RetailscmUserContext userContext, String reasonId, String comment) throws Exception{

		Termination termination = new Termination();
		
		
		TerminationReason  reason = new TerminationReason();
		reason.setId(reasonId);		
		termination.setReason(reason);		
		termination.setComment(comment);
	
		
		return termination;
	
		
	}
	
	protected Termination createIndexedTermination(String id, int version){

		Termination termination = new Termination();
		termination.setId(id);
		termination.setVersion(version);
		return termination;			
		
	}
	
	protected void checkParamsForRemovingTerminationList(RetailscmUserContext userContext, String terminationTypeId, 
			String terminationIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTerminationType(terminationTypeId);
		for(String terminationId: terminationIds){
			userContext.getChecker().checkIdOfTermination(terminationId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TerminationTypeManagerException.class);
		
	}
	public  TerminationType removeTerminationList(RetailscmUserContext userContext, String terminationTypeId, 
			String terminationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTerminationList(userContext, terminationTypeId,  terminationIds, tokensExpr);
			
			
			TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());
			synchronized(terminationType){ 
				//Will be good when the terminationType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTerminationTypeDAO().planToRemoveTerminationList(terminationType, terminationIds, allTokens());
				terminationType = saveTerminationType(userContext, terminationType, tokens().withTerminationList().done());
				deleteRelationListInGraph(userContext, terminationType.getTerminationList());
				return present(userContext,terminationType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTermination(RetailscmUserContext userContext, String terminationTypeId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTerminationType( terminationTypeId);
		userContext.getChecker().checkIdOfTermination(terminationId);
		userContext.getChecker().checkVersionOfTermination(terminationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TerminationTypeManagerException.class);
	
	}
	public  TerminationType removeTermination(RetailscmUserContext userContext, String terminationTypeId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTermination(userContext,terminationTypeId, terminationId, terminationVersion,tokensExpr);
		
		Termination termination = createIndexedTermination(terminationId, terminationVersion);
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());
		synchronized(terminationType){ 
			//Will be good when the terminationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			terminationType.removeTermination( termination );		
			terminationType = saveTerminationType(userContext, terminationType, tokens().withTerminationList().done());
			deleteRelationInGraph(userContext, termination);
			return present(userContext,terminationType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTermination(RetailscmUserContext userContext, String terminationTypeId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTerminationType( terminationTypeId);
		userContext.getChecker().checkIdOfTermination(terminationId);
		userContext.getChecker().checkVersionOfTermination(terminationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TerminationTypeManagerException.class);
	
	}
	public  TerminationType copyTerminationFrom(RetailscmUserContext userContext, String terminationTypeId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTermination(userContext,terminationTypeId, terminationId, terminationVersion,tokensExpr);
		
		Termination termination = createIndexedTermination(terminationId, terminationVersion);
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());
		synchronized(terminationType){ 
			//Will be good when the terminationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			terminationType.copyTerminationFrom( termination );		
			terminationType = saveTerminationType(userContext, terminationType, tokens().withTerminationList().done());
			
			userContext.getManagerGroup().getTerminationManager().onNewInstanceCreated(userContext, (Termination)terminationType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,terminationType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTermination(RetailscmUserContext userContext, String terminationTypeId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTerminationType(terminationTypeId);
		userContext.getChecker().checkIdOfTermination(terminationId);
		userContext.getChecker().checkVersionOfTermination(terminationVersion);
		

		if(Termination.COMMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentOfTermination(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TerminationTypeManagerException.class);
	
	}
	
	public  TerminationType updateTermination(RetailscmUserContext userContext, String terminationTypeId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTermination(userContext, terminationTypeId, terminationId, terminationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTerminationList().searchTerminationListWith(Termination.ID_PROPERTY, "eq", terminationId).done();
		
		
		
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, loadTokens);
		
		synchronized(terminationType){ 
			//Will be good when the terminationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//terminationType.removeTermination( termination );	
			//make changes to AcceleraterAccount.
			Termination terminationIndex = createIndexedTermination(terminationId, terminationVersion);
		
			Termination termination = terminationType.findTheTermination(terminationIndex);
			if(termination == null){
				throw new TerminationTypeManagerException(termination+" is NOT FOUND" );
			}
			
			termination.changeProperty(property, newValueExpr);
			
			terminationType = saveTerminationType(userContext, terminationType, tokens().withTerminationList().done());
			return present(userContext,terminationType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, TerminationType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


