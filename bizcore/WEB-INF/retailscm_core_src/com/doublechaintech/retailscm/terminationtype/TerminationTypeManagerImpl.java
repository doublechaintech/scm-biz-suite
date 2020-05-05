
package com.doublechaintech.retailscm.terminationtype;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;






public class TerminationTypeManagerImpl extends CustomRetailscmCheckerManager implements TerminationTypeManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = TerminationTypeTokens.start().withTokenFromListName(listName).done();
		TerminationType  terminationType = (TerminationType) this.loadTerminationType(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = terminationType.collectRefercencesFromLists();
		terminationTypeDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, terminationType, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new TerminationTypeGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "TerminationType";
	@Override
	public TerminationTypeDAO daoOf(RetailscmUserContext userContext) {
		return terminationTypeDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfTerminationType(terminationTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( TerminationTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TerminationType terminationType = loadTerminationType( userContext, terminationTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,terminationType, tokens);
 	}
 	
 	
 	 public TerminationType searchTerminationType(RetailscmUserContext userContext, String terminationTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfTerminationType(terminationTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( TerminationTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		TerminationType terminationType = loadTerminationType( userContext, terminationTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,terminationType, tokens);
 	}
 	
 	

 	protected TerminationType present(RetailscmUserContext userContext, TerminationType terminationType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,terminationType,tokens);
		
		
		TerminationType  terminationTypeToPresent = terminationTypeDaoOf(userContext).present(terminationType, tokens);
		
		List<BaseEntity> entityListToNaming = terminationTypeToPresent.collectRefercencesFromLists();
		terminationTypeDaoOf(userContext).alias(entityListToNaming);
		
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
 		return terminationTypeDaoOf(userContext).save(terminationType, tokens);
 	}
 	protected TerminationType loadTerminationType(RetailscmUserContext userContext, String terminationTypeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfTerminationType(terminationTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( TerminationTypeManagerException.class);

 
 		return terminationTypeDaoOf(userContext).load(terminationTypeId, tokens);
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
	
 	
 	
 
 	
 	

	public TerminationType createTerminationType(RetailscmUserContext userContext, String code,String companyId,String baseDescription,String detailDescription) throws Exception
	//public TerminationType createTerminationType(RetailscmUserContext userContext,String code, String companyId, String baseDescription, String detailDescription) throws Exception
	{

		

		

		checkerOf(userContext).checkCodeOfTerminationType(code);
		checkerOf(userContext).checkBaseDescriptionOfTerminationType(baseDescription);
		checkerOf(userContext).checkDetailDescriptionOfTerminationType(detailDescription);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TerminationTypeManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfTerminationType(terminationTypeId);
		checkerOf(userContext).checkVersionOfTerminationType( terminationTypeVersion);
		

		if(TerminationType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfTerminationType(parseString(newValueExpr));
		
			
		}		

		
		if(TerminationType.BASE_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBaseDescriptionOfTerminationType(parseString(newValueExpr));
		
			
		}
		if(TerminationType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDetailDescriptionOfTerminationType(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(TerminationTypeManagerException.class);


	}



	public TerminationType clone(RetailscmUserContext userContext, String fromTerminationTypeId) throws Exception{

		return terminationTypeDaoOf(userContext).clone(fromTerminationTypeId, this.allTokens());
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
			if (terminationType.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TerminationTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String terminationTypeId, String anotherCompanyId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTerminationType(terminationTypeId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(TerminationTypeManagerException.class);

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForTerminationType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newCompanyId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String terminationTypeId, int terminationTypeVersion) throws Exception {
		//deleteInternal(userContext, terminationTypeId, terminationTypeVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String terminationTypeId, int terminationTypeVersion) throws Exception{

		terminationTypeDaoOf(userContext).delete(terminationTypeId, terminationTypeVersion);
	}

	public TerminationType forgetByAll(RetailscmUserContext userContext, String terminationTypeId, int terminationTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, terminationTypeId, terminationTypeVersion);
	}
	protected TerminationType forgetByAllInternal(RetailscmUserContext userContext,
			String terminationTypeId, int terminationTypeVersion) throws Exception{

		return terminationTypeDaoOf(userContext).disconnectFromAll(terminationTypeId, terminationTypeVersion);
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
		return terminationTypeDaoOf(userContext).deleteAll();
	}


	//disconnect TerminationType with reason in Termination
	protected TerminationType breakWithTerminationByReason(RetailscmUserContext userContext, String terminationTypeId, String reasonId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());

			synchronized(terminationType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				terminationTypeDaoOf(userContext).planToRemoveTerminationListWithReason(terminationType, reasonId, this.emptyOptions());

				terminationType = saveTerminationType(userContext, terminationType, tokens().withTerminationList().done());
				return terminationType;
			}
	}






	protected void checkParamsForAddingTermination(RetailscmUserContext userContext, String terminationTypeId, String reasonId, String comment,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfTerminationType(terminationTypeId);

		
		checkerOf(userContext).checkReasonIdOfTermination(reasonId);
		
		checkerOf(userContext).checkCommentOfTermination(comment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(TerminationTypeManagerException.class);


	}
	public  TerminationType addTermination(RetailscmUserContext userContext, String terminationTypeId, String reasonId, String comment, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingTermination(userContext,terminationTypeId,reasonId, comment,tokensExpr);

		Termination termination = createTermination(userContext,reasonId, comment);

		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, emptyOptions());
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

		checkerOf(userContext).checkIdOfTerminationType(terminationTypeId);
		checkerOf(userContext).checkIdOfTermination(id);

		checkerOf(userContext).checkCommentOfTermination( comment);

		checkerOf(userContext).throwExceptionIfHasErrors(TerminationTypeManagerException.class);

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

		checkerOf(userContext).checkIdOfTerminationType(terminationTypeId);
		for(String terminationIdItem: terminationIds){
			checkerOf(userContext).checkIdOfTermination(terminationIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(TerminationTypeManagerException.class);

	}
	public  TerminationType removeTerminationList(RetailscmUserContext userContext, String terminationTypeId,
			String terminationIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTerminationList(userContext, terminationTypeId,  terminationIds, tokensExpr);


			TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());
			synchronized(terminationType){
				//Will be good when the terminationType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				terminationTypeDaoOf(userContext).planToRemoveTerminationList(terminationType, terminationIds, allTokens());
				terminationType = saveTerminationType(userContext, terminationType, tokens().withTerminationList().done());
				deleteRelationListInGraph(userContext, terminationType.getTerminationList());
				return present(userContext,terminationType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTermination(RetailscmUserContext userContext, String terminationTypeId,
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTerminationType( terminationTypeId);
		checkerOf(userContext).checkIdOfTermination(terminationId);
		checkerOf(userContext).checkVersionOfTermination(terminationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TerminationTypeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfTerminationType( terminationTypeId);
		checkerOf(userContext).checkIdOfTermination(terminationId);
		checkerOf(userContext).checkVersionOfTermination(terminationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(TerminationTypeManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfTerminationType(terminationTypeId);
		checkerOf(userContext).checkIdOfTermination(terminationId);
		checkerOf(userContext).checkVersionOfTermination(terminationVersion);
		

		if(Termination.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfTermination(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(TerminationTypeManagerException.class);

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
		//   TerminationType newTerminationType = this.createTerminationType(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newTerminationType
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, TerminationType.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<TerminationType> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> companyList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(companyList, RetailStoreCountryCenter.class);


    }
	
	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception {
		return listPageByCompany(userContext, companyId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception {
		SmartList<TerminationType> list = terminationTypeDaoOf(userContext).findTerminationTypeByCompany(companyId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(TerminationType.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("雇佣终止类型列表");
		page.setRequestName("listByCompany");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCompany/%s/",  getBeanName(), companyId)));

		page.assemblerContent(userContext, "listByCompany");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String terminationTypeId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getTerminationTypeDetailScope().clone();
		TerminationType merchantObj = (TerminationType) this.view(userContext, terminationTypeId);
    String merchantObjId = terminationTypeId;
    String linkToUrl =	"terminationTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "雇佣终止类型"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-code")
				    .put("fieldName", "code")
				    .put("label", "代码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("code", merchantObj.getCode());

		propList.add(
				MapUtil.put("id", "3-company")
				    .put("fieldName", "company")
				    .put("label", "公司")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("company", merchantObj.getCompany());

		propList.add(
				MapUtil.put("id", "4-baseDescription")
				    .put("fieldName", "baseDescription")
				    .put("label", "基本描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("baseDescription", merchantObj.getBaseDescription());

		propList.add(
				MapUtil.put("id", "5-detailDescription")
				    .put("fieldName", "detailDescription")
				    .put("label", "详细描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("detailDescription", merchantObj.getDetailDescription());

		//处理 sectionList

		//处理Section：terminationListSection
		Map terminationListSection = ListofUtils.buildSection(
		    "terminationListSection",
		    "终止列表",
		    null,
		    "",
		    "__no_group",
		    "terminationManager/listByType/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(terminationListSection);

		result.put("terminationListSection", ListofUtils.toShortList(merchantObj.getTerminationList(), "termination"));
		vscope.field("terminationListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Termination.class.getName(), null));

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


