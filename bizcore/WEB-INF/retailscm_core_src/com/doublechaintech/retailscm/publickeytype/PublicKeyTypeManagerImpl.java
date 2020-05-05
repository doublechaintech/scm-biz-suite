
package com.doublechaintech.retailscm.publickeytype;

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


import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.keypairidentify.KeypairIdentify;

import com.doublechaintech.retailscm.userdomain.CandidateUserDomain;

import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;






public class PublicKeyTypeManagerImpl extends CustomRetailscmCheckerManager implements PublicKeyTypeManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = PublicKeyTypeTokens.start().withTokenFromListName(listName).done();
		PublicKeyType  publicKeyType = (PublicKeyType) this.loadPublicKeyType(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = publicKeyType.collectRefercencesFromLists();
		publicKeyTypeDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, publicKeyType, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new PublicKeyTypeGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "PublicKeyType";
	@Override
	public PublicKeyTypeDAO daoOf(RetailscmUserContext userContext) {
		return publicKeyTypeDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws PublicKeyTypeManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new PublicKeyTypeManagerException(message);

	}



 	protected PublicKeyType savePublicKeyType(RetailscmUserContext userContext, PublicKeyType publicKeyType, String [] tokensExpr) throws Exception{	
 		//return getPublicKeyTypeDAO().save(publicKeyType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePublicKeyType(userContext, publicKeyType, tokens);
 	}
 	
 	protected PublicKeyType savePublicKeyTypeDetail(RetailscmUserContext userContext, PublicKeyType publicKeyType) throws Exception{	

 		
 		return savePublicKeyType(userContext, publicKeyType, allTokens());
 	}
 	
 	public PublicKeyType loadPublicKeyType(RetailscmUserContext userContext, String publicKeyTypeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( PublicKeyTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PublicKeyType publicKeyType = loadPublicKeyType( userContext, publicKeyTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,publicKeyType, tokens);
 	}
 	
 	
 	 public PublicKeyType searchPublicKeyType(RetailscmUserContext userContext, String publicKeyTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( PublicKeyTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		PublicKeyType publicKeyType = loadPublicKeyType( userContext, publicKeyTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,publicKeyType, tokens);
 	}
 	
 	

 	protected PublicKeyType present(RetailscmUserContext userContext, PublicKeyType publicKeyType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,publicKeyType,tokens);
		
		
		PublicKeyType  publicKeyTypeToPresent = publicKeyTypeDaoOf(userContext).present(publicKeyType, tokens);
		
		List<BaseEntity> entityListToNaming = publicKeyTypeToPresent.collectRefercencesFromLists();
		publicKeyTypeDaoOf(userContext).alias(entityListToNaming);
		
		return  publicKeyTypeToPresent;
		
		
	}
 
 	
 	
 	public PublicKeyType loadPublicKeyTypeDetail(RetailscmUserContext userContext, String publicKeyTypeId) throws Exception{	
 		PublicKeyType publicKeyType = loadPublicKeyType( userContext, publicKeyTypeId, allTokens());
 		return present(userContext,publicKeyType, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String publicKeyTypeId) throws Exception{	
 		PublicKeyType publicKeyType = loadPublicKeyType( userContext, publicKeyTypeId, viewTokens());
 		return present(userContext,publicKeyType, allTokens());
		
 	}
 	protected PublicKeyType savePublicKeyType(RetailscmUserContext userContext, PublicKeyType publicKeyType, Map<String,Object>tokens) throws Exception{	
 		return publicKeyTypeDaoOf(userContext).save(publicKeyType, tokens);
 	}
 	protected PublicKeyType loadPublicKeyType(RetailscmUserContext userContext, String publicKeyTypeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( PublicKeyTypeManagerException.class);

 
 		return publicKeyTypeDaoOf(userContext).load(publicKeyTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, PublicKeyType publicKeyType, Map<String, Object> tokens){
		super.addActions(userContext, publicKeyType, tokens);
		
		addAction(userContext, publicKeyType, tokens,"@create","createPublicKeyType","createPublicKeyType/","main","primary");
		addAction(userContext, publicKeyType, tokens,"@update","updatePublicKeyType","updatePublicKeyType/"+publicKeyType.getId()+"/","main","primary");
		addAction(userContext, publicKeyType, tokens,"@copy","clonePublicKeyType","clonePublicKeyType/"+publicKeyType.getId()+"/","main","primary");
		
		addAction(userContext, publicKeyType, tokens,"public_key_type.transfer_to_domain","transferToAnotherDomain","transferToAnotherDomain/"+publicKeyType.getId()+"/","main","primary");
		addAction(userContext, publicKeyType, tokens,"public_key_type.addKeypairIdentify","addKeypairIdentify","addKeypairIdentify/"+publicKeyType.getId()+"/","keypairIdentifyList","primary");
		addAction(userContext, publicKeyType, tokens,"public_key_type.removeKeypairIdentify","removeKeypairIdentify","removeKeypairIdentify/"+publicKeyType.getId()+"/","keypairIdentifyList","primary");
		addAction(userContext, publicKeyType, tokens,"public_key_type.updateKeypairIdentify","updateKeypairIdentify","updateKeypairIdentify/"+publicKeyType.getId()+"/","keypairIdentifyList","primary");
		addAction(userContext, publicKeyType, tokens,"public_key_type.copyKeypairIdentifyFrom","copyKeypairIdentifyFrom","copyKeypairIdentifyFrom/"+publicKeyType.getId()+"/","keypairIdentifyList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, PublicKeyType publicKeyType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public PublicKeyType createPublicKeyType(RetailscmUserContext userContext, String name,String code,String domainId) throws Exception
	//public PublicKeyType createPublicKeyType(RetailscmUserContext userContext,String name, String code, String domainId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfPublicKeyType(name);
		checkerOf(userContext).checkCodeOfPublicKeyType(code);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);


		PublicKeyType publicKeyType=createNewPublicKeyType();	

		publicKeyType.setName(name);
		publicKeyType.setCode(code);
			
		UserDomain domain = loadUserDomain(userContext, domainId,emptyOptions());
		publicKeyType.setDomain(domain);
		
		

		publicKeyType = savePublicKeyType(userContext, publicKeyType, emptyOptions());
		
		onNewInstanceCreated(userContext, publicKeyType);
		return publicKeyType;


	}
	protected PublicKeyType createNewPublicKeyType()
	{

		return new PublicKeyType();
	}

	protected void checkParamsForUpdatingPublicKeyType(RetailscmUserContext userContext,String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
		checkerOf(userContext).checkVersionOfPublicKeyType( publicKeyTypeVersion);
		

		if(PublicKeyType.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfPublicKeyType(parseString(newValueExpr));
		
			
		}
		if(PublicKeyType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfPublicKeyType(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);


	}



	public PublicKeyType clone(RetailscmUserContext userContext, String fromPublicKeyTypeId) throws Exception{

		return publicKeyTypeDaoOf(userContext).clone(fromPublicKeyTypeId, this.allTokens());
	}

	public PublicKeyType internalSavePublicKeyType(RetailscmUserContext userContext, PublicKeyType publicKeyType) throws Exception
	{
		return internalSavePublicKeyType(userContext, publicKeyType, allTokens());

	}
	public PublicKeyType internalSavePublicKeyType(RetailscmUserContext userContext, PublicKeyType publicKeyType, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingPublicKeyType(userContext, publicKeyTypeId, publicKeyTypeVersion, property, newValueExpr, tokensExpr);


		synchronized(publicKeyType){
			//will be good when the publicKeyType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PublicKeyType.
			if (publicKeyType.isChanged()){
			
			}
			publicKeyType = savePublicKeyType(userContext, publicKeyType, options);
			return publicKeyType;

		}

	}

	public PublicKeyType updatePublicKeyType(RetailscmUserContext userContext,String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPublicKeyType(userContext, publicKeyTypeId, publicKeyTypeVersion, property, newValueExpr, tokensExpr);



		PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());
		if(publicKeyType.getVersion() != publicKeyTypeVersion){
			String message = "The target version("+publicKeyType.getVersion()+") is not equals to version("+publicKeyTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(publicKeyType){
			//will be good when the publicKeyType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PublicKeyType.
			
			publicKeyType.changeProperty(property, newValueExpr);
			publicKeyType = savePublicKeyType(userContext, publicKeyType, tokens().done());
			return present(userContext,publicKeyType, mergedAllTokens(tokensExpr));
			//return savePublicKeyType(userContext, publicKeyType, tokens().done());
		}

	}

	public PublicKeyType updatePublicKeyTypeProperty(RetailscmUserContext userContext,String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPublicKeyType(userContext, publicKeyTypeId, publicKeyTypeVersion, property, newValueExpr, tokensExpr);

		PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());
		if(publicKeyType.getVersion() != publicKeyTypeVersion){
			String message = "The target version("+publicKeyType.getVersion()+") is not equals to version("+publicKeyTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(publicKeyType){
			//will be good when the publicKeyType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PublicKeyType.

			publicKeyType.changeProperty(property, newValueExpr);
			
			publicKeyType = savePublicKeyType(userContext, publicKeyType, tokens().done());
			return present(userContext,publicKeyType, mergedAllTokens(tokensExpr));
			//return savePublicKeyType(userContext, publicKeyType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected PublicKeyTypeTokens tokens(){
		return PublicKeyTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PublicKeyTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortKeypairIdentifyListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PublicKeyTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherDomain(RetailscmUserContext userContext, String publicKeyTypeId, String anotherDomainId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
 		checkerOf(userContext).checkIdOfUserDomain(anotherDomainId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);

 	}
 	public PublicKeyType transferToAnotherDomain(RetailscmUserContext userContext, String publicKeyTypeId, String anotherDomainId) throws Exception
 	{
 		checkParamsForTransferingAnotherDomain(userContext, publicKeyTypeId,anotherDomainId);
 
		PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());	
		synchronized(publicKeyType){
			//will be good when the publicKeyType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserDomain domain = loadUserDomain(userContext, anotherDomainId, emptyOptions());		
			publicKeyType.updateDomain(domain);		
			publicKeyType = savePublicKeyType(userContext, publicKeyType, emptyOptions());
			
			return present(userContext,publicKeyType, allTokens());
			
		}

 	}

	


	public CandidateUserDomain requestCandidateDomain(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserDomain result = new CandidateUserDomain();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserDomain> candidateList = userDomainDaoOf(userContext).requestCandidateUserDomainForPublicKeyType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected UserDomain loadUserDomain(RetailscmUserContext userContext, String newDomainId, Map<String,Object> options) throws Exception
 	{

 		return userDomainDaoOf(userContext).load(newDomainId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String publicKeyTypeId, int publicKeyTypeVersion) throws Exception {
		//deleteInternal(userContext, publicKeyTypeId, publicKeyTypeVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String publicKeyTypeId, int publicKeyTypeVersion) throws Exception{

		publicKeyTypeDaoOf(userContext).delete(publicKeyTypeId, publicKeyTypeVersion);
	}

	public PublicKeyType forgetByAll(RetailscmUserContext userContext, String publicKeyTypeId, int publicKeyTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, publicKeyTypeId, publicKeyTypeVersion);
	}
	protected PublicKeyType forgetByAllInternal(RetailscmUserContext userContext,
			String publicKeyTypeId, int publicKeyTypeVersion) throws Exception{

		return publicKeyTypeDaoOf(userContext).disconnectFromAll(publicKeyTypeId, publicKeyTypeVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PublicKeyTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return publicKeyTypeDaoOf(userContext).deleteAll();
	}


	//disconnect PublicKeyType with sec_user in KeypairIdentify
	protected PublicKeyType breakWithKeypairIdentifyBySecUser(RetailscmUserContext userContext, String publicKeyTypeId, String secUserId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());

			synchronized(publicKeyType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				publicKeyTypeDaoOf(userContext).planToRemoveKeypairIdentifyListWithSecUser(publicKeyType, secUserId, this.emptyOptions());

				publicKeyType = savePublicKeyType(userContext, publicKeyType, tokens().withKeypairIdentifyList().done());
				return publicKeyType;
			}
	}






	protected void checkParamsForAddingKeypairIdentify(RetailscmUserContext userContext, String publicKeyTypeId, String publicKey, String secUserId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);

		
		checkerOf(userContext).checkPublicKeyOfKeypairIdentify(publicKey);
		
		checkerOf(userContext).checkSecUserIdOfKeypairIdentify(secUserId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);


	}
	public  PublicKeyType addKeypairIdentify(RetailscmUserContext userContext, String publicKeyTypeId, String publicKey, String secUserId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingKeypairIdentify(userContext,publicKeyTypeId,publicKey, secUserId,tokensExpr);

		KeypairIdentify keypairIdentify = createKeypairIdentify(userContext,publicKey, secUserId);

		PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, emptyOptions());
		synchronized(publicKeyType){
			//Will be good when the publicKeyType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			publicKeyType.addKeypairIdentify( keypairIdentify );
			publicKeyType = savePublicKeyType(userContext, publicKeyType, tokens().withKeypairIdentifyList().done());
			
			userContext.getManagerGroup().getKeypairIdentifyManager().onNewInstanceCreated(userContext, keypairIdentify);
			return present(userContext,publicKeyType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingKeypairIdentifyProperties(RetailscmUserContext userContext, String publicKeyTypeId,String id,String publicKey,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
		checkerOf(userContext).checkIdOfKeypairIdentify(id);

		checkerOf(userContext).checkPublicKeyOfKeypairIdentify( publicKey);

		checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);

	}
	public  PublicKeyType updateKeypairIdentifyProperties(RetailscmUserContext userContext, String publicKeyTypeId, String id,String publicKey, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingKeypairIdentifyProperties(userContext,publicKeyTypeId,id,publicKey,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withKeypairIdentifyListList()
				.searchKeypairIdentifyListWith(KeypairIdentify.ID_PROPERTY, "is", id).done();

		PublicKeyType publicKeyTypeToUpdate = loadPublicKeyType(userContext, publicKeyTypeId, options);

		if(publicKeyTypeToUpdate.getKeypairIdentifyList().isEmpty()){
			throw new PublicKeyTypeManagerException("KeypairIdentify is NOT FOUND with id: '"+id+"'");
		}

		KeypairIdentify item = publicKeyTypeToUpdate.getKeypairIdentifyList().first();

		item.updatePublicKey( publicKey );


		//checkParamsForAddingKeypairIdentify(userContext,publicKeyTypeId,name, code, used,tokensExpr);
		PublicKeyType publicKeyType = savePublicKeyType(userContext, publicKeyTypeToUpdate, tokens().withKeypairIdentifyList().done());
		synchronized(publicKeyType){
			return present(userContext,publicKeyType, mergedAllTokens(tokensExpr));
		}
	}


	protected KeypairIdentify createKeypairIdentify(RetailscmUserContext userContext, String publicKey, String secUserId) throws Exception{

		KeypairIdentify keypairIdentify = new KeypairIdentify();
		
		
		keypairIdentify.setPublicKey(publicKey);		
		SecUser  secUser = new SecUser();
		secUser.setId(secUserId);		
		keypairIdentify.setSecUser(secUser);		
		keypairIdentify.setCreateTime(userContext.now());
	
		
		return keypairIdentify;


	}

	protected KeypairIdentify createIndexedKeypairIdentify(String id, int version){

		KeypairIdentify keypairIdentify = new KeypairIdentify();
		keypairIdentify.setId(id);
		keypairIdentify.setVersion(version);
		return keypairIdentify;

	}

	protected void checkParamsForRemovingKeypairIdentifyList(RetailscmUserContext userContext, String publicKeyTypeId,
			String keypairIdentifyIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
		for(String keypairIdentifyIdItem: keypairIdentifyIds){
			checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);

	}
	public  PublicKeyType removeKeypairIdentifyList(RetailscmUserContext userContext, String publicKeyTypeId,
			String keypairIdentifyIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingKeypairIdentifyList(userContext, publicKeyTypeId,  keypairIdentifyIds, tokensExpr);


			PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());
			synchronized(publicKeyType){
				//Will be good when the publicKeyType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				publicKeyTypeDaoOf(userContext).planToRemoveKeypairIdentifyList(publicKeyType, keypairIdentifyIds, allTokens());
				publicKeyType = savePublicKeyType(userContext, publicKeyType, tokens().withKeypairIdentifyList().done());
				deleteRelationListInGraph(userContext, publicKeyType.getKeypairIdentifyList());
				return present(userContext,publicKeyType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingKeypairIdentify(RetailscmUserContext userContext, String publicKeyTypeId,
		String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPublicKeyType( publicKeyTypeId);
		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
		checkerOf(userContext).checkVersionOfKeypairIdentify(keypairIdentifyVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);

	}
	public  PublicKeyType removeKeypairIdentify(RetailscmUserContext userContext, String publicKeyTypeId,
		String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingKeypairIdentify(userContext,publicKeyTypeId, keypairIdentifyId, keypairIdentifyVersion,tokensExpr);

		KeypairIdentify keypairIdentify = createIndexedKeypairIdentify(keypairIdentifyId, keypairIdentifyVersion);
		PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());
		synchronized(publicKeyType){
			//Will be good when the publicKeyType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			publicKeyType.removeKeypairIdentify( keypairIdentify );
			publicKeyType = savePublicKeyType(userContext, publicKeyType, tokens().withKeypairIdentifyList().done());
			deleteRelationInGraph(userContext, keypairIdentify);
			return present(userContext,publicKeyType, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingKeypairIdentify(RetailscmUserContext userContext, String publicKeyTypeId,
		String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPublicKeyType( publicKeyTypeId);
		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
		checkerOf(userContext).checkVersionOfKeypairIdentify(keypairIdentifyVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);

	}
	public  PublicKeyType copyKeypairIdentifyFrom(RetailscmUserContext userContext, String publicKeyTypeId,
		String keypairIdentifyId, int keypairIdentifyVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingKeypairIdentify(userContext,publicKeyTypeId, keypairIdentifyId, keypairIdentifyVersion,tokensExpr);

		KeypairIdentify keypairIdentify = createIndexedKeypairIdentify(keypairIdentifyId, keypairIdentifyVersion);
		PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());
		synchronized(publicKeyType){
			//Will be good when the publicKeyType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			publicKeyType.copyKeypairIdentifyFrom( keypairIdentify );
			publicKeyType = savePublicKeyType(userContext, publicKeyType, tokens().withKeypairIdentifyList().done());
			
			userContext.getManagerGroup().getKeypairIdentifyManager().onNewInstanceCreated(userContext, (KeypairIdentify)publicKeyType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,publicKeyType, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingKeypairIdentify(RetailscmUserContext userContext, String publicKeyTypeId, String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
		checkerOf(userContext).checkIdOfKeypairIdentify(keypairIdentifyId);
		checkerOf(userContext).checkVersionOfKeypairIdentify(keypairIdentifyVersion);
		

		if(KeypairIdentify.PUBLIC_KEY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPublicKeyOfKeypairIdentify(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);

	}

	public  PublicKeyType updateKeypairIdentify(RetailscmUserContext userContext, String publicKeyTypeId, String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingKeypairIdentify(userContext, publicKeyTypeId, keypairIdentifyId, keypairIdentifyVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withKeypairIdentifyList().searchKeypairIdentifyListWith(KeypairIdentify.ID_PROPERTY, "eq", keypairIdentifyId).done();



		PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, loadTokens);

		synchronized(publicKeyType){
			//Will be good when the publicKeyType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//publicKeyType.removeKeypairIdentify( keypairIdentify );
			//make changes to AcceleraterAccount.
			KeypairIdentify keypairIdentifyIndex = createIndexedKeypairIdentify(keypairIdentifyId, keypairIdentifyVersion);

			KeypairIdentify keypairIdentify = publicKeyType.findTheKeypairIdentify(keypairIdentifyIndex);
			if(keypairIdentify == null){
				throw new PublicKeyTypeManagerException(keypairIdentify+" is NOT FOUND" );
			}

			keypairIdentify.changeProperty(property, newValueExpr);
			
			publicKeyType = savePublicKeyType(userContext, publicKeyType, tokens().withKeypairIdentifyList().done());
			return present(userContext,publicKeyType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, PublicKeyType newCreated) throws Exception{
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
		//   PublicKeyType newPublicKeyType = this.createPublicKeyType(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newPublicKeyType
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, PublicKeyType.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<PublicKeyType> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<UserDomain> domainList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, UserDomain.class);
		userContext.getDAOGroup().enhanceList(domainList, UserDomain.class);


    }
	
	public Object listByDomain(RetailscmUserContext userContext,String domainId) throws Exception {
		return listPageByDomain(userContext, domainId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDomain(RetailscmUserContext userContext,String domainId, int start, int count) throws Exception {
		SmartList<PublicKeyType> list = publicKeyTypeDaoOf(userContext).findPublicKeyTypeByDomain(domainId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(PublicKeyType.class);
		page.setContainerObject(UserDomain.withId(domainId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("公共密钥类型列表");
		page.setRequestName("listByDomain");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDomain/%s/",  getBeanName(), domainId)));

		page.assemblerContent(userContext, "listByDomain");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String publicKeyTypeId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getPublicKeyTypeDetailScope().clone();
		PublicKeyType merchantObj = (PublicKeyType) this.view(userContext, publicKeyTypeId);
    String merchantObjId = publicKeyTypeId;
    String linkToUrl =	"publicKeyTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "公共密钥类型"+"详情";
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
				MapUtil.put("id", "3-code")
				    .put("fieldName", "code")
				    .put("label", "代码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("code", merchantObj.getCode());

		propList.add(
				MapUtil.put("id", "4-domain")
				    .put("fieldName", "domain")
				    .put("label", "域")
				    .put("type", "auto")
				    .put("linkToUrl", "userDomainManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("domain", merchantObj.getDomain());

		//处理 sectionList

		//处理Section：keypairIdentifyListSection
		Map keypairIdentifyListSection = ListofUtils.buildSection(
		    "keypairIdentifyListSection",
		    "密钥对识别列表",
		    null,
		    "",
		    "__no_group",
		    "keypairIdentifyManager/listByKeyType/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(keypairIdentifyListSection);

		result.put("keypairIdentifyListSection", ListofUtils.toShortList(merchantObj.getKeypairIdentifyList(), "keypairIdentify"));
		vscope.field("keypairIdentifyListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( KeypairIdentify.class.getName(), null));

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


