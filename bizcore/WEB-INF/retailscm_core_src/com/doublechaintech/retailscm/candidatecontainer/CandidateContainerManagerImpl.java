
package com.doublechaintech.retailscm.candidatecontainer;

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



import com.doublechaintech.retailscm.candidateelement.CandidateElement;


import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;






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
 	
 	public Object view(RetailscmUserContext userContext, String candidateContainerId) throws Exception{	
 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, viewTokens());
 		return present(userContext,candidateContainer, allTokens());
		
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
	
 	
 	
 
 	
 	

	public CandidateContainer createCandidateContainer(RetailscmUserContext userContext, String name) throws Exception
	//public CandidateContainer createCandidateContainer(RetailscmUserContext userContext,String name) throws Exception
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
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortCandidateElementListWith("id","desc")
		.analyzeAllLists().done();

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

    if (methodName.equals("ensureModelInDB")){
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
		//   CandidateContainer newCandidateContainer = this.createCandidateContainer(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newCandidateContainer
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, CandidateContainer.INTERNAL_TYPE);
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
	  SerializeScope vscope = RetailscmViewScope.getInstance().getCandidateContainerDetailScope().clone();
		CandidateContainer merchantObj = (CandidateContainer) this.view(userContext, candidateContainerId);
    String merchantObjId = candidateContainerId;
    String linkToUrl =	"candidateContainerManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "候选人容器"+"详情";
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
		vscope.field("candidateElementListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( CandidateElement.class.getName(), null));

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


