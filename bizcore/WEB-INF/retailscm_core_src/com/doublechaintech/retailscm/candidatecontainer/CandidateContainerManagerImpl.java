
package com.doublechaintech.retailscm.candidatecontainer;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;import com.doublechaintech.retailscm.candidateelement.CandidateElement;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class CandidateContainerManagerImpl extends CustomRetailscmCheckerManager implements CandidateContainerManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "CandidateContainer";
	@Override
	public CandidateContainerDAO daoOf(RetailscmUserContext userContext) {
		return candidateContainerDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws CandidateContainerManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new CandidateContainerManagerException(message);

	}



 	protected CandidateContainer saveCandidateContainer(RetailscmUserContext userContext, CandidateContainer candidateContainer, String [] tokensExpr) throws Exception{
 		//return getCandidateContainerDAO().save(candidateContainer, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveCandidateContainer(userContext, candidateContainer, tokens);
 	}

 	protected CandidateContainer saveCandidateContainerDetail(RetailscmUserContext userContext, CandidateContainer candidateContainer) throws Exception{


 		return saveCandidateContainer(userContext, candidateContainer, allTokens());
 	}

 	public CandidateContainer loadCandidateContainer(RetailscmUserContext userContext, String candidateContainerId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);

		checkerOf(userContext).throwExceptionIfHasErrors( CandidateContainerManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,candidateContainer, tokens);
 	}


 	 public CandidateContainer searchCandidateContainer(RetailscmUserContext userContext, String candidateContainerId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);

		checkerOf(userContext).throwExceptionIfHasErrors( CandidateContainerManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,candidateContainer, tokens);
 	}



 	protected CandidateContainer present(RetailscmUserContext userContext, CandidateContainer candidateContainer, Map<String, Object> tokens) throws Exception {


		addActions(userContext,candidateContainer,tokens);
    

		CandidateContainer  candidateContainerToPresent = candidateContainerDaoOf(userContext).present(candidateContainer, tokens);

		List<BaseEntity> entityListToNaming = candidateContainerToPresent.collectRefercencesFromLists();
		candidateContainerDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,candidateContainer,tokens);

		return  candidateContainerToPresent;


	}



 	public CandidateContainer loadCandidateContainerDetail(RetailscmUserContext userContext, String candidateContainerId) throws Exception{
 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, allTokens());
 		return present(userContext,candidateContainer, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String candidateContainerId) throws Exception{
 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, viewTokens());
 		markVisited(userContext, candidateContainer);
 		return present(userContext,candidateContainer, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String candidateContainerId) throws Exception{
		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, viewTokens());
		candidateContainer.summarySuffix();
		markVisited(userContext, candidateContainer);
 		return present(userContext,candidateContainer, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String candidateContainerId) throws Exception{
		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, analyzeTokens());
		markVisited(userContext, candidateContainer);
		return present(userContext,candidateContainer, analyzeTokens());

	}
 	protected CandidateContainer saveCandidateContainer(RetailscmUserContext userContext, CandidateContainer candidateContainer, Map<String,Object>tokens) throws Exception{
 	
 		return candidateContainerDaoOf(userContext).save(candidateContainer, tokens);
 	}
 	protected CandidateContainer loadCandidateContainer(RetailscmUserContext userContext, String candidateContainerId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);

		checkerOf(userContext).throwExceptionIfHasErrors( CandidateContainerManagerException.class);



 		return candidateContainerDaoOf(userContext).load(candidateContainerId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, CandidateContainer candidateContainer, Map<String, Object> tokens){
		super.addActions(userContext, candidateContainer, tokens);

		addAction(userContext, candidateContainer, tokens,"@create","createCandidateContainer","createCandidateContainer/","main","primary");
		addAction(userContext, candidateContainer, tokens,"@update","updateCandidateContainer","updateCandidateContainer/"+candidateContainer.getId()+"/","main","primary");
		addAction(userContext, candidateContainer, tokens,"@copy","cloneCandidateContainer","cloneCandidateContainer/"+candidateContainer.getId()+"/","main","primary");

		addAction(userContext, candidateContainer, tokens,"candidate_container.addCandidateElement","addCandidateElement","addCandidateElement/"+candidateContainer.getId()+"/","candidateElementList","primary");
		addAction(userContext, candidateContainer, tokens,"candidate_container.removeCandidateElement","removeCandidateElement","removeCandidateElement/"+candidateContainer.getId()+"/","candidateElementList","primary");
		addAction(userContext, candidateContainer, tokens,"candidate_container.updateCandidateElement","updateCandidateElement","updateCandidateElement/"+candidateContainer.getId()+"/","candidateElementList","primary");
		addAction(userContext, candidateContainer, tokens,"candidate_container.copyCandidateElementFrom","copyCandidateElementFrom","copyCandidateElementFrom/"+candidateContainer.getId()+"/","candidateElementList","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, CandidateContainer candidateContainer, Map<String, Object> tokens){








  @Override
  public List<CandidateContainer> searchCandidateContainerList(RetailscmUserContext ctx, CandidateContainerRequest pRequest){
      pRequest.setUserContext(ctx);
      List<CandidateContainer> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public CandidateContainer searchCandidateContainer(RetailscmUserContext ctx, CandidateContainerRequest pRequest){
    pRequest.limit(0, 1);
    List<CandidateContainer> list = searchCandidateContainerList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public CandidateContainer createCandidateContainer(RetailscmUserContext userContext, String name) throws Exception
	{





		checkerOf(userContext).checkNameOfCandidateContainer(name);


		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);



		CandidateContainer candidateContainer=createNewCandidateContainer();	

		candidateContainer.setName(name);

		candidateContainer = saveCandidateContainer(userContext, candidateContainer, emptyOptions());
		
		onNewInstanceCreated(userContext, candidateContainer);
		return candidateContainer;


	}
	protected CandidateContainer createNewCandidateContainer()
	{

		return new CandidateContainer();
	}

	protected void checkParamsForUpdatingCandidateContainer(RetailscmUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).checkVersionOfCandidateContainer( candidateContainerVersion);


		if(CandidateContainer.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCandidateContainer(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);



	}



	public CandidateContainer clone(RetailscmUserContext userContext, String fromCandidateContainerId) throws Exception{

		return candidateContainerDaoOf(userContext).clone(fromCandidateContainerId, this.allTokens());
	}

	public CandidateContainer internalSaveCandidateContainer(RetailscmUserContext userContext, CandidateContainer candidateContainer) throws Exception
	{
		return internalSaveCandidateContainer(userContext, candidateContainer, allTokens());

	}
	public CandidateContainer internalSaveCandidateContainer(RetailscmUserContext userContext, CandidateContainer candidateContainer, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingCandidateContainer(userContext, candidateContainerId, candidateContainerVersion, property, newValueExpr, tokensExpr);


		synchronized(candidateContainer){
			//will be good when the candidateContainer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateContainer.
			if (candidateContainer.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixCandidateContainer(candidateContainer);
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, options);
			return candidateContainer;

		}

	}

	public CandidateContainer updateCandidateContainer(RetailscmUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCandidateContainer(userContext, candidateContainerId, candidateContainerVersion, property, newValueExpr, tokensExpr);



		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		if(candidateContainer.getVersion() != candidateContainerVersion){
			String message = "The target version("+candidateContainer.getVersion()+") is not equals to version("+candidateContainerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(candidateContainer){
			//will be good when the candidateContainer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateContainer.
			
			candidateContainer.changeProperty(property, newValueExpr);
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().done());
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
			//return saveCandidateContainer(userContext, candidateContainer, tokens().done());
		}

	}

	public CandidateContainer updateCandidateContainerProperty(RetailscmUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCandidateContainer(userContext, candidateContainerId, candidateContainerVersion, property, newValueExpr, tokensExpr);

		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		if(candidateContainer.getVersion() != candidateContainerVersion){
			String message = "The target version("+candidateContainer.getVersion()+") is not equals to version("+candidateContainerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(candidateContainer){
			//will be good when the candidateContainer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateContainer.

			candidateContainer.changeProperty(property, newValueExpr);
			
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().done());
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
			//return saveCandidateContainer(userContext, candidateContainer, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected CandidateContainerTokens tokens(){
		return CandidateContainerTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CandidateContainerTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortCandidateElementListWith(CandidateElement.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CandidateContainerTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String candidateContainerId, int candidateContainerVersion) throws Exception {
		//deleteInternal(userContext, candidateContainerId, candidateContainerVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String candidateContainerId, int candidateContainerVersion) throws Exception{

		candidateContainerDaoOf(userContext).delete(candidateContainerId, candidateContainerVersion);
	}

	public CandidateContainer forgetByAll(RetailscmUserContext userContext, String candidateContainerId, int candidateContainerVersion) throws Exception {
		return forgetByAllInternal(userContext, candidateContainerId, candidateContainerVersion);
	}
	protected CandidateContainer forgetByAllInternal(RetailscmUserContext userContext,
			String candidateContainerId, int candidateContainerVersion) throws Exception{

		return candidateContainerDaoOf(userContext).disconnectFromAll(candidateContainerId, candidateContainerVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CandidateContainerManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return candidateContainerDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingCandidateElement(RetailscmUserContext userContext, String candidateContainerId, String name, String type, String image,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);


		checkerOf(userContext).checkNameOfCandidateElement(name);

		checkerOf(userContext).checkTypeOfCandidateElement(type);

		checkerOf(userContext).checkImageOfCandidateElement(image);


		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);



	}
	public  CandidateContainer addCandidateElement(RetailscmUserContext userContext, String candidateContainerId, String name, String type, String image, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingCandidateElement(userContext,candidateContainerId,name, type, image,tokensExpr);

		CandidateElement candidateElement = createCandidateElement(userContext,name, type, image);

		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, emptyOptions());
		synchronized(candidateContainer){
			//Will be good when the candidateContainer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			candidateContainer.addCandidateElement( candidateElement );
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
			
			candidateElementManagerOf(userContext).onNewInstanceCreated(userContext, candidateElement);
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCandidateElementProperties(RetailscmUserContext userContext, String candidateContainerId,String id,String name,String type,String image,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).checkIdOfCandidateElement(id);

		checkerOf(userContext).checkNameOfCandidateElement( name);
		checkerOf(userContext).checkTypeOfCandidateElement( type);
		checkerOf(userContext).checkImageOfCandidateElement( image);


		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);


	}
	public  CandidateContainer updateCandidateElementProperties(RetailscmUserContext userContext, String candidateContainerId, String id,String name,String type,String image, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCandidateElementProperties(userContext,candidateContainerId,id,name,type,image,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCandidateElementListList()
				.searchCandidateElementListWith(CandidateElement.ID_PROPERTY, tokens().is(), id).done();

		CandidateContainer candidateContainerToUpdate = loadCandidateContainer(userContext, candidateContainerId, options);

		if(candidateContainerToUpdate.getCandidateElementList().isEmpty()){
			throw new CandidateContainerManagerException("CandidateElement is NOT FOUND with id: '"+id+"'");
		}

		CandidateElement item = candidateContainerToUpdate.getCandidateElementList().first();
		beforeUpdateCandidateElementProperties(userContext,item, candidateContainerId,id,name,type,image,tokensExpr);
		item.updateName( name );
		item.updateType( type );
		item.updateImage( image );


		//checkParamsForAddingCandidateElement(userContext,candidateContainerId,name, code, used,tokensExpr);
		CandidateContainer candidateContainer = saveCandidateContainer(userContext, candidateContainerToUpdate, tokens().withCandidateElementList().done());
		synchronized(candidateContainer){
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateCandidateElementProperties(RetailscmUserContext userContext, CandidateElement item, String candidateContainerId, String id,String name,String type,String image, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected CandidateElement createCandidateElement(RetailscmUserContext userContext, String name, String type, String image) throws Exception{

		CandidateElement candidateElement = new CandidateElement();
		
		
		candidateElement.setName(name);		
		candidateElement.setType(type);		
		candidateElement.setImage(image);
	
		
		return candidateElement;


	}

	protected CandidateElement createIndexedCandidateElement(String id, int version){

		CandidateElement candidateElement = new CandidateElement();
		candidateElement.setId(id);
		candidateElement.setVersion(version);
		return candidateElement;

	}

	protected void checkParamsForRemovingCandidateElementList(RetailscmUserContext userContext, String candidateContainerId,
			String candidateElementIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		for(String candidateElementIdItem: candidateElementIds){
			checkerOf(userContext).checkIdOfCandidateElement(candidateElementIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);

	}
	public  CandidateContainer removeCandidateElementList(RetailscmUserContext userContext, String candidateContainerId,
			String candidateElementIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCandidateElementList(userContext, candidateContainerId,  candidateElementIds, tokensExpr);


			CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
			synchronized(candidateContainer){
				//Will be good when the candidateContainer loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				candidateContainerDaoOf(userContext).planToRemoveCandidateElementList(candidateContainer, candidateElementIds, allTokens());
				candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
				deleteRelationListInGraph(userContext, candidateContainer.getCandidateElementList());
				return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCandidateElement(RetailscmUserContext userContext, String candidateContainerId,
		String candidateElementId, int candidateElementVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCandidateContainer( candidateContainerId);
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).checkVersionOfCandidateElement(candidateElementVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);


	}
	public  CandidateContainer removeCandidateElement(RetailscmUserContext userContext, String candidateContainerId,
		String candidateElementId, int candidateElementVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingCandidateElement(userContext,candidateContainerId, candidateElementId, candidateElementVersion,tokensExpr);

		CandidateElement candidateElement = createIndexedCandidateElement(candidateElementId, candidateElementVersion);
		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		synchronized(candidateContainer){
			//Will be good when the candidateContainer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			candidateContainer.removeCandidateElement( candidateElement );
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
			deleteRelationInGraph(userContext, candidateElement);
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingCandidateElement(RetailscmUserContext userContext, String candidateContainerId,
		String candidateElementId, int candidateElementVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCandidateContainer( candidateContainerId);
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).checkVersionOfCandidateElement(candidateElementVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);


	}
	public  CandidateContainer copyCandidateElementFrom(RetailscmUserContext userContext, String candidateContainerId,
		String candidateElementId, int candidateElementVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingCandidateElement(userContext,candidateContainerId, candidateElementId, candidateElementVersion,tokensExpr);

		CandidateElement candidateElement = createIndexedCandidateElement(candidateElementId, candidateElementVersion);
		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		synchronized(candidateContainer){
			//Will be good when the candidateContainer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			candidateContainer.copyCandidateElementFrom( candidateElement );
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
			
			candidateElementManagerOf(userContext).onNewInstanceCreated(userContext, (CandidateElement)candidateContainer.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingCandidateElement(RetailscmUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).checkVersionOfCandidateElement(candidateElementVersion);


		if(CandidateElement.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfCandidateElement(parseString(newValueExpr));
		}
		
		if(CandidateElement.TYPE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTypeOfCandidateElement(parseString(newValueExpr));
		}
		
		if(CandidateElement.IMAGE_PROPERTY.equals(property)){
			checkerOf(userContext).checkImageOfCandidateElement(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);


	}

	public  CandidateContainer updateCandidateElement(RetailscmUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingCandidateElement(userContext, candidateContainerId, candidateElementId, candidateElementVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withCandidateElementList().searchCandidateElementListWith(CandidateElement.ID_PROPERTY, tokens().equals(), candidateElementId).done();



		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, loadTokens);

		synchronized(candidateContainer){
			//Will be good when the candidateContainer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//candidateContainer.removeCandidateElement( candidateElement );
			//make changes to AcceleraterAccount.
			CandidateElement candidateElementIdVersionKey = createIndexedCandidateElement(candidateElementId, candidateElementVersion);

			CandidateElement candidateElement = candidateContainer.findTheCandidateElement(candidateElementIdVersionKey);
			if(candidateElement == null){
				throw new CandidateContainerManagerException(candidateElementId+" is NOT FOUND" );
			}

			beforeUpdateCandidateElement(userContext, candidateElement, candidateContainerId, candidateElementId, candidateElementVersion, property, newValueExpr,  tokensExpr);
			candidateElement.changeProperty(property, newValueExpr);
			
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
			candidateElementManagerOf(userContext).onUpdated(userContext, candidateElement, this, "updateCandidateElement");
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateCandidateElement(RetailscmUserContext userContext, CandidateElement existed, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, CandidateContainer newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    candidateContainerDaoOf(ctx).loadAllAsStream().forEach(
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
		//   CandidateContainer newCandidateContainer = this.createCandidateContainer(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newCandidateContainer
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
    key.put(UserApp.APP_TYPE_PROPERTY, CandidateContainer.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<CandidateContainer> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String candidateContainerId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		CandidateContainer merchantObj = (CandidateContainer) this.view(userContext, candidateContainerId);
    String merchantObjId = candidateContainerId;
    String linkToUrl =	"candidateContainerManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "候选容器"+"详情";
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

		//处理 sectionList

		//处理Section：candidateElementListSection
		Map candidateElementListSection = ListofUtils.buildSection(
		    "candidateElementListSection",
		    "候选人元素列表",
		    null,
		    "",
		    "__no_group",
		    "candidateElementManager/listByContainer/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(candidateElementListSection);

		result.put("candidateElementListSection", ListofUtils.toShortList(merchantObj.getCandidateElementList(), "candidateElement"));

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




