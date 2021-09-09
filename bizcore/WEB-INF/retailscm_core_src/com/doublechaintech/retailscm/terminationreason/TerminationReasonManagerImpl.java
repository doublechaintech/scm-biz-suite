
package com.doublechaintech.retailscm.terminationreason;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.termination.Termination;import com.doublechaintech.retailscm.terminationreason.TerminationReason;import com.doublechaintech.retailscm.terminationtype.TerminationType;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class TerminationReasonManagerImpl extends CustomRetailscmCheckerManager implements TerminationReasonManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = TerminationReasonTokens.start().withTokenFromListName(listName).done();
		TerminationReason  terminationReason = (TerminationReason) this.loadTerminationReason(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = terminationReason.collectRefercencesFromLists();
		terminationReasonDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, terminationReason, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new TerminationReasonGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "TerminationReason";
	@Override
	public TerminationReasonDAO daoOf(RetailscmUserContext userContext) {
		return terminationReasonDaoOf(userContext);
	}

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

 		checkerOf(userContext).checkIdOfTerminationReason(terminationReasonId);

		checkerOf(userContext).throwExceptionIfHasErrors( TerminationReasonManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,terminationReason, tokens);
 	}


 	 public TerminationReason searchTerminationReason(RetailscmUserContext userContext, String terminationReasonId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfTerminationReason(terminationReasonId);

		checkerOf(userContext).throwExceptionIfHasErrors( TerminationReasonManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,terminationReason, tokens);
 	}



 	protected TerminationReason present(RetailscmUserContext userContext, TerminationReason terminationReason, Map<String, Object> tokens) throws Exception {


		addActions(userContext,terminationReason,tokens);
    

		TerminationReason  terminationReasonToPresent = terminationReasonDaoOf(userContext).present(terminationReason, tokens);

		List<BaseEntity> entityListToNaming = terminationReasonToPresent.collectRefercencesFromLists();
		terminationReasonDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,terminationReason,tokens);

		return  terminationReasonToPresent;


	}



 	public TerminationReason loadTerminationReasonDetail(RetailscmUserContext userContext, String terminationReasonId) throws Exception{
 		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, allTokens());
 		return present(userContext,terminationReason, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String terminationReasonId) throws Exception{
 		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, viewTokens());
 		markVisited(userContext, terminationReason);
 		return present(userContext,terminationReason, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String terminationReasonId) throws Exception{
		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, viewTokens());
		terminationReason.summarySuffix();
		markVisited(userContext, terminationReason);
 		return present(userContext,terminationReason, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String terminationReasonId) throws Exception{
		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, analyzeTokens());
		markVisited(userContext, terminationReason);
		return present(userContext,terminationReason, analyzeTokens());

	}
 	protected TerminationReason saveTerminationReason(RetailscmUserContext userContext, TerminationReason terminationReason, Map<String,Object>tokens) throws Exception{
 	
 		return terminationReasonDaoOf(userContext).save(terminationReason, tokens);
 	}
 	protected TerminationReason loadTerminationReason(RetailscmUserContext userContext, String terminationReasonId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfTerminationReason(terminationReasonId);

		checkerOf(userContext).throwExceptionIfHasErrors( TerminationReasonManagerException.class);



 		return terminationReasonDaoOf(userContext).load(terminationReasonId, tokens);
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








  @Override
  public List<TerminationReason> searchTerminationReasonList(RetailscmUserContext ctx, TerminationReasonRequest pRequest){
      pRequest.setUserContext(ctx);
      List<TerminationReason> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public TerminationReason searchTerminationReason(RetailscmUserContext ctx, TerminationReasonRequest pRequest){
    pRequest.limit(0, 1);
    List<TerminationReason> list = searchTerminationReasonList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public TerminationReason createTerminationReason(RetailscmUserContext userContext, String code,String companyId,String description) throws Exception
	{





		checkerOf(userContext).checkCodeOfTerminationReason(code);
		checkerOf(userContext).checkDescriptionOfTerminationReason(description);


		checkerOf(userContext).throwExceptionIfHasErrors(TerminationReasonManagerException.class);



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
		



		checkerOf(userContext).checkIdOfTerminationReason(terminationReasonId);
		checkerOf(userContext).checkVersionOfTerminationReason( terminationReasonVersion);


		if(TerminationReason.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfTerminationReason(parseString(newValueExpr));
		

		}

		
		if(TerminationReason.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfTerminationReason(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(TerminationReasonManagerException.class);



	}



	public TerminationReason clone(RetailscmUserContext userContext, String fromTerminationReasonId) throws Exception{

		return terminationReasonDaoOf(userContext).clone(fromTerminationReasonId, this.allTokens());
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
			if (terminationReason.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixTerminationReason(terminationReason);
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
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTerminationListWith(Termination.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TerminationReasonTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String terminationReasonId, String anotherCompanyId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTerminationReason(terminationReasonId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(TerminationReasonManagerException.class);

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForTerminationReason(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String terminationReasonId, int terminationReasonVersion) throws Exception {
		//deleteInternal(userContext, terminationReasonId, terminationReasonVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String terminationReasonId, int terminationReasonVersion) throws Exception{

		terminationReasonDaoOf(userContext).delete(terminationReasonId, terminationReasonVersion);
	}

	public TerminationReason forgetByAll(RetailscmUserContext userContext, String terminationReasonId, int terminationReasonVersion) throws Exception {
		return forgetByAllInternal(userContext, terminationReasonId, terminationReasonVersion);
	}
	protected TerminationReason forgetByAllInternal(RetailscmUserContext userContext,
			String terminationReasonId, int terminationReasonVersion) throws Exception{

		return terminationReasonDaoOf(userContext).disconnectFromAll(terminationReasonId, terminationReasonVersion);
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
		return terminationReasonDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingTermination(RetailscmUserContext userContext, String terminationReasonId, String typeId, String comment,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfTerminationReason(terminationReasonId);


		checkerOf(userContext).checkTypeIdOfTermination(typeId);

		checkerOf(userContext).checkCommentOfTermination(comment);


		checkerOf(userContext).throwExceptionIfHasErrors(TerminationReasonManagerException.class);



	}
	public  TerminationReason addTermination(RetailscmUserContext userContext, String terminationReasonId, String typeId, String comment, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingTermination(userContext,terminationReasonId,typeId, comment,tokensExpr);

		Termination termination = createTermination(userContext,typeId, comment);

		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, emptyOptions());
		synchronized(terminationReason){
			//Will be good when the terminationReason loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			terminationReason.addTermination( termination );
			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
			
			terminationManagerOf(userContext).onNewInstanceCreated(userContext, termination);
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTerminationProperties(RetailscmUserContext userContext, String terminationReasonId,String id,String comment,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTerminationReason(terminationReasonId);
		checkerOf(userContext).checkIdOfTermination(id);

		checkerOf(userContext).checkCommentOfTermination( comment);


		checkerOf(userContext).throwExceptionIfHasErrors(TerminationReasonManagerException.class);


	}
	public  TerminationReason updateTerminationProperties(RetailscmUserContext userContext, String terminationReasonId, String id,String comment, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTerminationProperties(userContext,terminationReasonId,id,comment,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTerminationListList()
				.searchTerminationListWith(Termination.ID_PROPERTY, tokens().is(), id).done();

		TerminationReason terminationReasonToUpdate = loadTerminationReason(userContext, terminationReasonId, options);

		if(terminationReasonToUpdate.getTerminationList().isEmpty()){
			throw new TerminationReasonManagerException("Termination is NOT FOUND with id: '"+id+"'");
		}

		Termination item = terminationReasonToUpdate.getTerminationList().first();
		beforeUpdateTerminationProperties(userContext,item, terminationReasonId,id,comment,tokensExpr);
		item.updateComment( comment );


		//checkParamsForAddingTermination(userContext,terminationReasonId,name, code, used,tokensExpr);
		TerminationReason terminationReason = saveTerminationReason(userContext, terminationReasonToUpdate, tokens().withTerminationList().done());
		synchronized(terminationReason){
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateTerminationProperties(RetailscmUserContext userContext, Termination item, String terminationReasonId, String id,String comment, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfTerminationReason(terminationReasonId);
		for(String terminationIdItem: terminationIds){
			checkerOf(userContext).checkIdOfTermination(terminationIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(TerminationReasonManagerException.class);

	}
	public  TerminationReason removeTerminationList(RetailscmUserContext userContext, String terminationReasonId,
			String terminationIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTerminationList(userContext, terminationReasonId,  terminationIds, tokensExpr);


			TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());
			synchronized(terminationReason){
				//Will be good when the terminationReason loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				terminationReasonDaoOf(userContext).planToRemoveTerminationList(terminationReason, terminationIds, allTokens());
				terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
				deleteRelationListInGraph(userContext, terminationReason.getTerminationList());
				return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTermination(RetailscmUserContext userContext, String terminationReasonId,
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTerminationReason( terminationReasonId);
		checkerOf(userContext).checkIdOfTermination(terminationId);
		checkerOf(userContext).checkVersionOfTermination(terminationVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(TerminationReasonManagerException.class);


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
		
		checkerOf(userContext).checkIdOfTerminationReason( terminationReasonId);
		checkerOf(userContext).checkIdOfTermination(terminationId);
		checkerOf(userContext).checkVersionOfTermination(terminationVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(TerminationReasonManagerException.class);


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
			
			terminationManagerOf(userContext).onNewInstanceCreated(userContext, (Termination)terminationReason.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingTermination(RetailscmUserContext userContext, String terminationReasonId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfTerminationReason(terminationReasonId);
		checkerOf(userContext).checkIdOfTermination(terminationId);
		checkerOf(userContext).checkVersionOfTermination(terminationVersion);


		if(Termination.COMMENT_PROPERTY.equals(property)){
			checkerOf(userContext).checkCommentOfTermination(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(TerminationReasonManagerException.class);


	}

	public  TerminationReason updateTermination(RetailscmUserContext userContext, String terminationReasonId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingTermination(userContext, terminationReasonId, terminationId, terminationVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withTerminationList().searchTerminationListWith(Termination.ID_PROPERTY, tokens().equals(), terminationId).done();



		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, loadTokens);

		synchronized(terminationReason){
			//Will be good when the terminationReason loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//terminationReason.removeTermination( termination );
			//make changes to AcceleraterAccount.
			Termination terminationIdVersionKey = createIndexedTermination(terminationId, terminationVersion);

			Termination termination = terminationReason.findTheTermination(terminationIdVersionKey);
			if(termination == null){
				throw new TerminationReasonManagerException(terminationId+" is NOT FOUND" );
			}

			beforeUpdateTermination(userContext, termination, terminationReasonId, terminationId, terminationVersion, property, newValueExpr,  tokensExpr);
			termination.changeProperty(property, newValueExpr);
			
			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
			terminationManagerOf(userContext).onUpdated(userContext, termination, this, "updateTermination");
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateTermination(RetailscmUserContext userContext, Termination existed, String terminationReasonId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, TerminationReason newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    terminationReasonDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
  }



	// -----------------------------------//  登录部分处理 \\-----------------------------------
	@Override
  protected BusinessHandler getLoginProcessBizHandler(RetailscmUserContextImpl userContext) {
    return this;
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
		//   TerminationReason newTerminationReason = this.createTerminationReason(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newTerminationReason
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// and in most case, this should be considered as "login success"
		//   loginResult.setSuccess(true);
		//
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	protected SmartList<UserApp> getRelatedUserAppList(RetailscmUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, TerminationReason.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<TerminationReason> list) throws Exception {
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
		SmartList<TerminationReason> list = terminationReasonDaoOf(userContext).findTerminationReasonByCompany(companyId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(TerminationReason.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("雇佣终止的原因列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String terminationReasonId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		TerminationReason merchantObj = (TerminationReason) this.view(userContext, terminationReasonId);
    String merchantObjId = terminationReasonId;
    String linkToUrl =	"terminationReasonManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "雇佣终止的原因"+"详情";
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
				MapUtil.put("id", "4-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		//处理 sectionList

		//处理Section：terminationListSection
		Map terminationListSection = ListofUtils.buildSection(
		    "terminationListSection",
		    "终止列表",
		    null,
		    "",
		    "__no_group",
		    "terminationManager/listByReason/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(terminationListSection);

		result.put("terminationListSection", ListofUtils.toShortList(merchantObj.getTerminationList(), "termination"));

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




