
package com.doublechaintech.retailscm.terminationreason;

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






public class TerminationReasonManagerImpl extends CustomRetailscmCheckerManager implements TerminationReasonManager {
	
	private static final String SERVICE_TYPE = "TerminationReason";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws TerminationReasonManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new TerminationReasonManagerException(message);

	}
	
	

 	protected TerminationReason saveTerminationReason(RetailscmUserContext userContext, TerminationReason terminationReason, String [] tokensExpr) throws Exception{	
 		//return getTerminationReasonDAO().save(terminationReason, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTerminationReason(userContext, terminationReason, tokens);
 	}
 	
 	protected TerminationReason saveTerminationReasonDetail(RetailscmUserContext userContext, TerminationReason terminationReason) throws Exception{	

 		
 		return saveTerminationReason(userContext, terminationReason, allTokens());
 	}
 	
 	public TerminationReason loadTerminationReason(RetailscmUserContext userContext, String terminationReasonId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTerminationReason(terminationReasonId);
		userContext.getChecker().throwExceptionIfHasErrors( TerminationReasonManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,terminationReason, tokens);
 	}
 	
 	
 	 public TerminationReason searchTerminationReason(RetailscmUserContext userContext, String terminationReasonId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfTerminationReason(terminationReasonId);
		userContext.getChecker().throwExceptionIfHasErrors( TerminationReasonManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,terminationReason, tokens);
 	}
 	
 	

 	protected TerminationReason present(RetailscmUserContext userContext, TerminationReason terminationReason, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,terminationReason,tokens);
		
		
		TerminationReason  terminationReasonToPresent = userContext.getDAOGroup().getTerminationReasonDAO().present(terminationReason, tokens);
		
		List<BaseEntity> entityListToNaming = terminationReasonToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getTerminationReasonDAO().alias(entityListToNaming);
		
		return  terminationReasonToPresent;
		
		
	}
 
 	
 	
 	public TerminationReason loadTerminationReasonDetail(RetailscmUserContext userContext, String terminationReasonId) throws Exception{	
 		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, allTokens());
 		return present(userContext,terminationReason, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String terminationReasonId) throws Exception{	
 		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, viewTokens());
 		return present(userContext,terminationReason, allTokens());
		
 	}
 	protected TerminationReason saveTerminationReason(RetailscmUserContext userContext, TerminationReason terminationReason, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getTerminationReasonDAO().save(terminationReason, tokens);
 	}
 	protected TerminationReason loadTerminationReason(RetailscmUserContext userContext, String terminationReasonId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfTerminationReason(terminationReasonId);
		userContext.getChecker().throwExceptionIfHasErrors( TerminationReasonManagerException.class);

 
 		return userContext.getDAOGroup().getTerminationReasonDAO().load(terminationReasonId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TerminationReason terminationReason, Map<String, Object> tokens){
		super.addActions(userContext, terminationReason, tokens);
		
		addAction(userContext, terminationReason, tokens,"@create","createTerminationReason","createTerminationReason/","main","primary");
		addAction(userContext, terminationReason, tokens,"@update","updateTerminationReason","updateTerminationReason/"+terminationReason.getId()+"/","main","primary");
		addAction(userContext, terminationReason, tokens,"@copy","cloneTerminationReason","cloneTerminationReason/"+terminationReason.getId()+"/","main","primary");
		
		addAction(userContext, terminationReason, tokens,"termination_reason.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+terminationReason.getId()+"/","main","primary");
		addAction(userContext, terminationReason, tokens,"termination_reason.addTermination","addTermination","addTermination/"+terminationReason.getId()+"/","terminationList","primary");
		addAction(userContext, terminationReason, tokens,"termination_reason.removeTermination","removeTermination","removeTermination/"+terminationReason.getId()+"/","terminationList","primary");
		addAction(userContext, terminationReason, tokens,"termination_reason.updateTermination","updateTermination","updateTermination/"+terminationReason.getId()+"/","terminationList","primary");
		addAction(userContext, terminationReason, tokens,"termination_reason.copyTerminationFrom","copyTerminationFrom","copyTerminationFrom/"+terminationReason.getId()+"/","terminationList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TerminationReason terminationReason, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TerminationReason createTerminationReason(RetailscmUserContext userContext,String code, String companyId, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkCodeOfTerminationReason(code);
		userContext.getChecker().checkDescriptionOfTerminationReason(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(TerminationReasonManagerException.class);


		TerminationReason terminationReason=createNewTerminationReason();	

		terminationReason.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		terminationReason.setCompany(company);
		
		
		terminationReason.setDescription(description);

		terminationReason = saveTerminationReason(userContext, terminationReason, emptyOptions());
		
		onNewInstanceCreated(userContext, terminationReason);
		return terminationReason;

		
	}
	protected TerminationReason createNewTerminationReason() 
	{
		
		return new TerminationReason();		
	}
	
	protected void checkParamsForUpdatingTerminationReason(RetailscmUserContext userContext,String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfTerminationReason(terminationReasonId);
		userContext.getChecker().checkVersionOfTerminationReason( terminationReasonVersion);
		

		if(TerminationReason.CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkCodeOfTerminationReason(parseString(newValueExpr));
		}		

		
		if(TerminationReason.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfTerminationReason(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(TerminationReasonManagerException.class);
	
		
	}
	
	
	
	public TerminationReason clone(RetailscmUserContext userContext, String fromTerminationReasonId) throws Exception{
		
		return userContext.getDAOGroup().getTerminationReasonDAO().clone(fromTerminationReasonId, this.allTokens());
	}
	
	public TerminationReason internalSaveTerminationReason(RetailscmUserContext userContext, TerminationReason terminationReason) throws Exception 
	{
		return internalSaveTerminationReason(userContext, terminationReason, allTokens());

	}
	public TerminationReason internalSaveTerminationReason(RetailscmUserContext userContext, TerminationReason terminationReason, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingTerminationReason(userContext, terminationReasonId, terminationReasonVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(terminationReason){ 
			//will be good when the terminationReason loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TerminationReason.
			
			
			terminationReason = saveTerminationReason(userContext, terminationReason, options);
			return terminationReason;
			
		}

	}
	
	public TerminationReason updateTerminationReason(RetailscmUserContext userContext,String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTerminationReason(userContext, terminationReasonId, terminationReasonVersion, property, newValueExpr, tokensExpr);
		
		
		
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());
		if(terminationReason.getVersion() != terminationReasonVersion){
			String message = "The target version("+terminationReason.getVersion()+") is not equals to version("+terminationReasonVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(terminationReason){ 
			//will be good when the terminationReason loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TerminationReason.
			
			terminationReason.changeProperty(property, newValueExpr);
			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().done());
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
			//return saveTerminationReason(userContext, terminationReason, tokens().done());
		}

	}
	
	public TerminationReason updateTerminationReasonProperty(RetailscmUserContext userContext,String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTerminationReason(userContext, terminationReasonId, terminationReasonVersion, property, newValueExpr, tokensExpr);
		
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());
		if(terminationReason.getVersion() != terminationReasonVersion){
			String message = "The target version("+terminationReason.getVersion()+") is not equals to version("+terminationReasonVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(terminationReason){ 
			//will be good when the terminationReason loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TerminationReason.
			
			terminationReason.changeProperty(property, newValueExpr);
			
			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().done());
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
			//return saveTerminationReason(userContext, terminationReason, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TerminationReasonTokens tokens(){
		return TerminationReasonTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TerminationReasonTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTerminationListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TerminationReasonTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String terminationReasonId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfTerminationReason(terminationReasonId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(TerminationReasonManagerException.class);
 		
 	}
 	public TerminationReason transferToAnotherCompany(RetailscmUserContext userContext, String terminationReasonId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, terminationReasonId,anotherCompanyId);
 
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());	
		synchronized(terminationReason){
			//will be good when the terminationReason loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			terminationReason.updateCompany(company);		
			terminationReason = saveTerminationReason(userContext, terminationReason, emptyOptions());
			
			return present(userContext,terminationReason, allTokens());
			
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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForTerminationReason(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String terminationReasonId, int terminationReasonVersion) throws Exception {
		//deleteInternal(userContext, terminationReasonId, terminationReasonVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String terminationReasonId, int terminationReasonVersion) throws Exception{
			
		userContext.getDAOGroup().getTerminationReasonDAO().delete(terminationReasonId, terminationReasonVersion);
	}
	
	public TerminationReason forgetByAll(RetailscmUserContext userContext, String terminationReasonId, int terminationReasonVersion) throws Exception {
		return forgetByAllInternal(userContext, terminationReasonId, terminationReasonVersion);		
	}
	protected TerminationReason forgetByAllInternal(RetailscmUserContext userContext,
			String terminationReasonId, int terminationReasonVersion) throws Exception{
			
		return userContext.getDAOGroup().getTerminationReasonDAO().disconnectFromAll(terminationReasonId, terminationReasonVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TerminationReasonManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getTerminationReasonDAO().deleteAll();
	}


	//disconnect TerminationReason with type in Termination
	protected TerminationReason breakWithTerminationByType(RetailscmUserContext userContext, String terminationReasonId, String typeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());

			synchronized(terminationReason){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getTerminationReasonDAO().planToRemoveTerminationListWithType(terminationReason, typeId, this.emptyOptions());

				terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
				return terminationReason;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingTermination(RetailscmUserContext userContext, String terminationReasonId, String typeId, String comment,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfTerminationReason(terminationReasonId);

		
		userContext.getChecker().checkTypeIdOfTermination(typeId);
		
		userContext.getChecker().checkCommentOfTermination(comment);
	
		userContext.getChecker().throwExceptionIfHasErrors(TerminationReasonManagerException.class);

	
	}
	public  TerminationReason addTermination(RetailscmUserContext userContext, String terminationReasonId, String typeId, String comment, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTermination(userContext,terminationReasonId,typeId, comment,tokensExpr);
		
		Termination termination = createTermination(userContext,typeId, comment);
		
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());
		synchronized(terminationReason){ 
			//Will be good when the terminationReason loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			terminationReason.addTermination( termination );		
			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
			
			userContext.getManagerGroup().getTerminationManager().onNewInstanceCreated(userContext, termination);
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTerminationProperties(RetailscmUserContext userContext, String terminationReasonId,String id,String comment,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTerminationReason(terminationReasonId);
		userContext.getChecker().checkIdOfTermination(id);
		
		userContext.getChecker().checkCommentOfTermination( comment);

		userContext.getChecker().throwExceptionIfHasErrors(TerminationReasonManagerException.class);
		
	}
	public  TerminationReason updateTerminationProperties(RetailscmUserContext userContext, String terminationReasonId, String id,String comment, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingTerminationProperties(userContext,terminationReasonId,id,comment,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTerminationListList()
				.searchTerminationListWith(Termination.ID_PROPERTY, "is", id).done();
		
		TerminationReason terminationReasonToUpdate = loadTerminationReason(userContext, terminationReasonId, options);
		
		if(terminationReasonToUpdate.getTerminationList().isEmpty()){
			throw new TerminationReasonManagerException("Termination is NOT FOUND with id: '"+id+"'");
		}
		
		Termination item = terminationReasonToUpdate.getTerminationList().first();
		
		item.updateComment( comment );

		
		//checkParamsForAddingTermination(userContext,terminationReasonId,name, code, used,tokensExpr);
		TerminationReason terminationReason = saveTerminationReason(userContext, terminationReasonToUpdate, tokens().withTerminationList().done());
		synchronized(terminationReason){ 
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Termination createTermination(RetailscmUserContext userContext, String typeId, String comment) throws Exception{

		Termination termination = new Termination();
		
		
		TerminationType  type = new TerminationType();
		type.setId(typeId);		
		termination.setType(type);		
		termination.setComment(comment);
	
		
		return termination;
	
		
	}
	
	protected Termination createIndexedTermination(String id, int version){

		Termination termination = new Termination();
		termination.setId(id);
		termination.setVersion(version);
		return termination;			
		
	}
	
	protected void checkParamsForRemovingTerminationList(RetailscmUserContext userContext, String terminationReasonId, 
			String terminationIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfTerminationReason(terminationReasonId);
		for(String terminationId: terminationIds){
			userContext.getChecker().checkIdOfTermination(terminationId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(TerminationReasonManagerException.class);
		
	}
	public  TerminationReason removeTerminationList(RetailscmUserContext userContext, String terminationReasonId, 
			String terminationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingTerminationList(userContext, terminationReasonId,  terminationIds, tokensExpr);
			
			
			TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());
			synchronized(terminationReason){ 
				//Will be good when the terminationReason loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getTerminationReasonDAO().planToRemoveTerminationList(terminationReason, terminationIds, allTokens());
				terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
				deleteRelationListInGraph(userContext, terminationReason.getTerminationList());
				return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingTermination(RetailscmUserContext userContext, String terminationReasonId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTerminationReason( terminationReasonId);
		userContext.getChecker().checkIdOfTermination(terminationId);
		userContext.getChecker().checkVersionOfTermination(terminationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TerminationReasonManagerException.class);
	
	}
	public  TerminationReason removeTermination(RetailscmUserContext userContext, String terminationReasonId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTermination(userContext,terminationReasonId, terminationId, terminationVersion,tokensExpr);
		
		Termination termination = createIndexedTermination(terminationId, terminationVersion);
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());
		synchronized(terminationReason){ 
			//Will be good when the terminationReason loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			terminationReason.removeTermination( termination );		
			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
			deleteRelationInGraph(userContext, termination);
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingTermination(RetailscmUserContext userContext, String terminationReasonId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfTerminationReason( terminationReasonId);
		userContext.getChecker().checkIdOfTermination(terminationId);
		userContext.getChecker().checkVersionOfTermination(terminationVersion);
		userContext.getChecker().throwExceptionIfHasErrors(TerminationReasonManagerException.class);
	
	}
	public  TerminationReason copyTerminationFrom(RetailscmUserContext userContext, String terminationReasonId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTermination(userContext,terminationReasonId, terminationId, terminationVersion,tokensExpr);
		
		Termination termination = createIndexedTermination(terminationId, terminationVersion);
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());
		synchronized(terminationReason){ 
			//Will be good when the terminationReason loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			terminationReason.copyTerminationFrom( termination );		
			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
			
			userContext.getManagerGroup().getTerminationManager().onNewInstanceCreated(userContext, (Termination)terminationReason.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingTermination(RetailscmUserContext userContext, String terminationReasonId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfTerminationReason(terminationReasonId);
		userContext.getChecker().checkIdOfTermination(terminationId);
		userContext.getChecker().checkVersionOfTermination(terminationVersion);
		

		if(Termination.COMMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentOfTermination(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(TerminationReasonManagerException.class);
	
	}
	
	public  TerminationReason updateTermination(RetailscmUserContext userContext, String terminationReasonId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTermination(userContext, terminationReasonId, terminationId, terminationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withTerminationList().searchTerminationListWith(Termination.ID_PROPERTY, "eq", terminationId).done();
		
		
		
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, loadTokens);
		
		synchronized(terminationReason){ 
			//Will be good when the terminationReason loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//terminationReason.removeTermination( termination );	
			//make changes to AcceleraterAccount.
			Termination terminationIndex = createIndexedTermination(terminationId, terminationVersion);
		
			Termination termination = terminationReason.findTheTermination(terminationIndex);
			if(termination == null){
				throw new TerminationReasonManagerException(termination+" is NOT FOUND" );
			}
			
			termination.changeProperty(property, newValueExpr);
			
			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, TerminationReason newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


