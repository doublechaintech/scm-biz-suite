
package com.doublechaintech.retailscm.keypairidentity;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.publickeytype.CandidatePublicKeyType;import com.doublechaintech.retailscm.publickeytype.PublicKeyType;import com.doublechaintech.retailscm.secuser.CandidateSecUser;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class KeyPairIdentityManagerImpl extends CustomRetailscmCheckerManager implements KeyPairIdentityManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "KeyPairIdentity";
	@Override
	public KeyPairIdentityDAO daoOf(RetailscmUserContext userContext) {
		return keyPairIdentityDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws KeyPairIdentityManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new KeyPairIdentityManagerException(message);

	}



 	protected KeyPairIdentity saveKeyPairIdentity(RetailscmUserContext userContext, KeyPairIdentity keyPairIdentity, String [] tokensExpr) throws Exception{
 		//return getKeyPairIdentityDAO().save(keyPairIdentity, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveKeyPairIdentity(userContext, keyPairIdentity, tokens);
 	}

 	protected KeyPairIdentity saveKeyPairIdentityDetail(RetailscmUserContext userContext, KeyPairIdentity keyPairIdentity) throws Exception{


 		return saveKeyPairIdentity(userContext, keyPairIdentity, allTokens());
 	}

 	public KeyPairIdentity loadKeyPairIdentity(RetailscmUserContext userContext, String keyPairIdentityId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);

		checkerOf(userContext).throwExceptionIfHasErrors( KeyPairIdentityManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity( userContext, keyPairIdentityId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,keyPairIdentity, tokens);
 	}


 	 public KeyPairIdentity searchKeyPairIdentity(RetailscmUserContext userContext, String keyPairIdentityId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);

		checkerOf(userContext).throwExceptionIfHasErrors( KeyPairIdentityManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity( userContext, keyPairIdentityId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,keyPairIdentity, tokens);
 	}



 	protected KeyPairIdentity present(RetailscmUserContext userContext, KeyPairIdentity keyPairIdentity, Map<String, Object> tokens) throws Exception {


		addActions(userContext,keyPairIdentity,tokens);
    

		KeyPairIdentity  keyPairIdentityToPresent = keyPairIdentityDaoOf(userContext).present(keyPairIdentity, tokens);

		List<BaseEntity> entityListToNaming = keyPairIdentityToPresent.collectRefercencesFromLists();
		keyPairIdentityDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,keyPairIdentity,tokens);

		return  keyPairIdentityToPresent;


	}



 	public KeyPairIdentity loadKeyPairIdentityDetail(RetailscmUserContext userContext, String keyPairIdentityId) throws Exception{
 		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity( userContext, keyPairIdentityId, allTokens());
 		return present(userContext,keyPairIdentity, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String keyPairIdentityId) throws Exception{
 		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity( userContext, keyPairIdentityId, viewTokens());
 		markVisited(userContext, keyPairIdentity);
 		return present(userContext,keyPairIdentity, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String keyPairIdentityId) throws Exception{
		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity( userContext, keyPairIdentityId, viewTokens());
		keyPairIdentity.summarySuffix();
		markVisited(userContext, keyPairIdentity);
 		return present(userContext,keyPairIdentity, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String keyPairIdentityId) throws Exception{
		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity( userContext, keyPairIdentityId, analyzeTokens());
		markVisited(userContext, keyPairIdentity);
		return present(userContext,keyPairIdentity, analyzeTokens());

	}
 	protected KeyPairIdentity saveKeyPairIdentity(RetailscmUserContext userContext, KeyPairIdentity keyPairIdentity, Map<String,Object>tokens) throws Exception{
 	
 		return keyPairIdentityDaoOf(userContext).save(keyPairIdentity, tokens);
 	}
 	protected KeyPairIdentity loadKeyPairIdentity(RetailscmUserContext userContext, String keyPairIdentityId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);

		checkerOf(userContext).throwExceptionIfHasErrors( KeyPairIdentityManagerException.class);



 		return keyPairIdentityDaoOf(userContext).load(keyPairIdentityId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, KeyPairIdentity keyPairIdentity, Map<String, Object> tokens){
		super.addActions(userContext, keyPairIdentity, tokens);

		addAction(userContext, keyPairIdentity, tokens,"@create","createKeyPairIdentity","createKeyPairIdentity/","main","primary");
		addAction(userContext, keyPairIdentity, tokens,"@update","updateKeyPairIdentity","updateKeyPairIdentity/"+keyPairIdentity.getId()+"/","main","primary");
		addAction(userContext, keyPairIdentity, tokens,"@copy","cloneKeyPairIdentity","cloneKeyPairIdentity/"+keyPairIdentity.getId()+"/","main","primary");

		addAction(userContext, keyPairIdentity, tokens,"key_pair_identity.transfer_to_key_type","transferToAnotherKeyType","transferToAnotherKeyType/"+keyPairIdentity.getId()+"/","main","primary");
		addAction(userContext, keyPairIdentity, tokens,"key_pair_identity.transfer_to_sec_user","transferToAnotherSecUser","transferToAnotherSecUser/"+keyPairIdentity.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, KeyPairIdentity keyPairIdentity, Map<String, Object> tokens){








  @Override
  public List<KeyPairIdentity> searchKeyPairIdentityList(RetailscmUserContext ctx, KeyPairIdentityRequest pRequest){
      pRequest.setUserContext(ctx);
      List<KeyPairIdentity> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public KeyPairIdentity searchKeyPairIdentity(RetailscmUserContext ctx, KeyPairIdentityRequest pRequest){
    pRequest.limit(0, 1);
    List<KeyPairIdentity> list = searchKeyPairIdentityList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public KeyPairIdentity createKeyPairIdentity(RetailscmUserContext userContext, String publicKey,String keyTypeId,String secUserId) throws Exception
	{





		checkerOf(userContext).checkPublicKeyOfKeyPairIdentity(publicKey);


		checkerOf(userContext).throwExceptionIfHasErrors(KeyPairIdentityManagerException.class);



		KeyPairIdentity keyPairIdentity=createNewKeyPairIdentity();	

		keyPairIdentity.setPublicKey(publicKey);
			
		PublicKeyType keyType = loadPublicKeyType(userContext, keyTypeId,emptyOptions());
		keyPairIdentity.setKeyType(keyType);
		
		
			
		SecUser secUser = loadSecUser(userContext, secUserId,emptyOptions());
		keyPairIdentity.setSecUser(secUser);
		
		
		keyPairIdentity.setCreateTime(userContext.now());

		keyPairIdentity = saveKeyPairIdentity(userContext, keyPairIdentity, emptyOptions());
		
		onNewInstanceCreated(userContext, keyPairIdentity);
		return keyPairIdentity;


	}
	protected KeyPairIdentity createNewKeyPairIdentity()
	{

		return new KeyPairIdentity();
	}

	protected void checkParamsForUpdatingKeyPairIdentity(RetailscmUserContext userContext,String keyPairIdentityId, int keyPairIdentityVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);
		checkerOf(userContext).checkVersionOfKeyPairIdentity( keyPairIdentityVersion);


		if(KeyPairIdentity.PUBLIC_KEY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPublicKeyOfKeyPairIdentity(parseString(newValueExpr));
		

		}

		

		


		checkerOf(userContext).throwExceptionIfHasErrors(KeyPairIdentityManagerException.class);



	}



	public KeyPairIdentity clone(RetailscmUserContext userContext, String fromKeyPairIdentityId) throws Exception{

		return keyPairIdentityDaoOf(userContext).clone(fromKeyPairIdentityId, this.allTokens());
	}

	public KeyPairIdentity internalSaveKeyPairIdentity(RetailscmUserContext userContext, KeyPairIdentity keyPairIdentity) throws Exception
	{
		return internalSaveKeyPairIdentity(userContext, keyPairIdentity, allTokens());

	}
	public KeyPairIdentity internalSaveKeyPairIdentity(RetailscmUserContext userContext, KeyPairIdentity keyPairIdentity, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingKeyPairIdentity(userContext, keyPairIdentityId, keyPairIdentityVersion, property, newValueExpr, tokensExpr);


		synchronized(keyPairIdentity){
			//will be good when the keyPairIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to KeyPairIdentity.
			if (keyPairIdentity.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixKeyPairIdentity(keyPairIdentity);
			keyPairIdentity = saveKeyPairIdentity(userContext, keyPairIdentity, options);
			return keyPairIdentity;

		}

	}

	public KeyPairIdentity updateKeyPairIdentity(RetailscmUserContext userContext,String keyPairIdentityId, int keyPairIdentityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingKeyPairIdentity(userContext, keyPairIdentityId, keyPairIdentityVersion, property, newValueExpr, tokensExpr);



		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity(userContext, keyPairIdentityId, allTokens());
		if(keyPairIdentity.getVersion() != keyPairIdentityVersion){
			String message = "The target version("+keyPairIdentity.getVersion()+") is not equals to version("+keyPairIdentityVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(keyPairIdentity){
			//will be good when the keyPairIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to KeyPairIdentity.
			
			keyPairIdentity.changeProperty(property, newValueExpr);
			keyPairIdentity = saveKeyPairIdentity(userContext, keyPairIdentity, tokens().done());
			return present(userContext,keyPairIdentity, mergedAllTokens(tokensExpr));
			//return saveKeyPairIdentity(userContext, keyPairIdentity, tokens().done());
		}

	}

	public KeyPairIdentity updateKeyPairIdentityProperty(RetailscmUserContext userContext,String keyPairIdentityId, int keyPairIdentityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingKeyPairIdentity(userContext, keyPairIdentityId, keyPairIdentityVersion, property, newValueExpr, tokensExpr);

		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity(userContext, keyPairIdentityId, allTokens());
		if(keyPairIdentity.getVersion() != keyPairIdentityVersion){
			String message = "The target version("+keyPairIdentity.getVersion()+") is not equals to version("+keyPairIdentityVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(keyPairIdentity){
			//will be good when the keyPairIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to KeyPairIdentity.

			keyPairIdentity.changeProperty(property, newValueExpr);
			
			keyPairIdentity = saveKeyPairIdentity(userContext, keyPairIdentity, tokens().done());
			return present(userContext,keyPairIdentity, mergedAllTokens(tokensExpr));
			//return saveKeyPairIdentity(userContext, keyPairIdentity, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected KeyPairIdentityTokens tokens(){
		return KeyPairIdentityTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return KeyPairIdentityTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return KeyPairIdentityTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherKeyType(RetailscmUserContext userContext, String keyPairIdentityId, String anotherKeyTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);
 		checkerOf(userContext).checkIdOfPublicKeyType(anotherKeyTypeId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(KeyPairIdentityManagerException.class);

 	}
 	public KeyPairIdentity transferToAnotherKeyType(RetailscmUserContext userContext, String keyPairIdentityId, String anotherKeyTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherKeyType(userContext, keyPairIdentityId,anotherKeyTypeId);
 
		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity(userContext, keyPairIdentityId, allTokens());
		synchronized(keyPairIdentity){
			//will be good when the keyPairIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PublicKeyType keyType = loadPublicKeyType(userContext, anotherKeyTypeId, emptyOptions());
			keyPairIdentity.updateKeyType(keyType);
			
			keyPairIdentity = saveKeyPairIdentity(userContext, keyPairIdentity, emptyOptions());

			return present(userContext,keyPairIdentity, allTokens());

		}

 	}

	


	public CandidatePublicKeyType requestCandidateKeyType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePublicKeyType result = new CandidatePublicKeyType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("keyAlg");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<PublicKeyType> candidateList = publicKeyTypeDaoOf(userContext).requestCandidatePublicKeyTypeForKeyPairIdentity(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherSecUser(RetailscmUserContext userContext, String keyPairIdentityId, String anotherSecUserId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);
 		checkerOf(userContext).checkIdOfSecUser(anotherSecUserId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(KeyPairIdentityManagerException.class);

 	}
 	public KeyPairIdentity transferToAnotherSecUser(RetailscmUserContext userContext, String keyPairIdentityId, String anotherSecUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUser(userContext, keyPairIdentityId,anotherSecUserId);
 
		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity(userContext, keyPairIdentityId, allTokens());
		synchronized(keyPairIdentity){
			//will be good when the keyPairIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());
			keyPairIdentity.updateSecUser(secUser);
			
			keyPairIdentity = saveKeyPairIdentity(userContext, keyPairIdentity, emptyOptions());

			return present(userContext,keyPairIdentity, allTokens());

		}

 	}

	

	protected void checkParamsForTransferingAnotherSecUserWithLogin(RetailscmUserContext userContext, String keyPairIdentityId, String anotherLogin) throws Exception
 	{

 		checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);
 		checkerOf(userContext).checkLoginOfSecUser( anotherLogin);

 		checkerOf(userContext).throwExceptionIfHasErrors(KeyPairIdentityManagerException.class);

 	}

 	public KeyPairIdentity transferToAnotherSecUserWithLogin(RetailscmUserContext userContext, String keyPairIdentityId, String anotherLogin) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithLogin(userContext, keyPairIdentityId,anotherLogin);
 		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity(userContext, keyPairIdentityId, allTokens());
		synchronized(keyPairIdentity){
			//will be good when the keyPairIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());
			keyPairIdentity.updateSecUser(secUser);
			keyPairIdentity = saveKeyPairIdentity(userContext, keyPairIdentity, emptyOptions());

			return present(userContext,keyPairIdentity, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithEmail(RetailscmUserContext userContext, String keyPairIdentityId, String anotherEmail) throws Exception
 	{

 		checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);
 		checkerOf(userContext).checkEmailOfSecUser( anotherEmail);

 		checkerOf(userContext).throwExceptionIfHasErrors(KeyPairIdentityManagerException.class);

 	}

 	public KeyPairIdentity transferToAnotherSecUserWithEmail(RetailscmUserContext userContext, String keyPairIdentityId, String anotherEmail) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithEmail(userContext, keyPairIdentityId,anotherEmail);
 		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity(userContext, keyPairIdentityId, allTokens());
		synchronized(keyPairIdentity){
			//will be good when the keyPairIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());
			keyPairIdentity.updateSecUser(secUser);
			keyPairIdentity = saveKeyPairIdentity(userContext, keyPairIdentity, emptyOptions());

			return present(userContext,keyPairIdentity, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithMobile(RetailscmUserContext userContext, String keyPairIdentityId, String anotherMobile) throws Exception
 	{

 		checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);
 		checkerOf(userContext).checkMobileOfSecUser( anotherMobile);

 		checkerOf(userContext).throwExceptionIfHasErrors(KeyPairIdentityManagerException.class);

 	}

 	public KeyPairIdentity transferToAnotherSecUserWithMobile(RetailscmUserContext userContext, String keyPairIdentityId, String anotherMobile) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithMobile(userContext, keyPairIdentityId,anotherMobile);
 		KeyPairIdentity keyPairIdentity = loadKeyPairIdentity(userContext, keyPairIdentityId, allTokens());
		synchronized(keyPairIdentity){
			//will be good when the keyPairIdentity loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());
			keyPairIdentity.updateSecUser(secUser);
			keyPairIdentity = saveKeyPairIdentity(userContext, keyPairIdentity, emptyOptions());

			return present(userContext,keyPairIdentity, allTokens());

		}
 	}

	 


	public CandidateSecUser requestCandidateSecUser(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSecUser result = new CandidateSecUser();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("login");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SecUser> candidateList = secUserDaoOf(userContext).requestCandidateSecUserForKeyPairIdentity(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected PublicKeyType loadPublicKeyType(RetailscmUserContext userContext, String newKeyTypeId, Map<String,Object> options) throws Exception
 	{
    
 		return publicKeyTypeDaoOf(userContext).load(newKeyTypeId, options);
 	  
 	}
 	


	

 	protected SecUser loadSecUser(RetailscmUserContext userContext, String newSecUserId, Map<String,Object> options) throws Exception
 	{
    
 		return secUserDaoOf(userContext).load(newSecUserId, options);
 	  
 	}
 	
 	protected SecUser loadSecUserWithLogin(RetailscmUserContext userContext, String newLogin, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByLogin(newLogin, options);
 	}

 	
 	protected SecUser loadSecUserWithEmail(RetailscmUserContext userContext, String newEmail, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByEmail(newEmail, options);
 	}

 	
 	protected SecUser loadSecUserWithMobile(RetailscmUserContext userContext, String newMobile, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByMobile(newMobile, options);
 	}

 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String keyPairIdentityId, int keyPairIdentityVersion) throws Exception {
		//deleteInternal(userContext, keyPairIdentityId, keyPairIdentityVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String keyPairIdentityId, int keyPairIdentityVersion) throws Exception{

		keyPairIdentityDaoOf(userContext).delete(keyPairIdentityId, keyPairIdentityVersion);
	}

	public KeyPairIdentity forgetByAll(RetailscmUserContext userContext, String keyPairIdentityId, int keyPairIdentityVersion) throws Exception {
		return forgetByAllInternal(userContext, keyPairIdentityId, keyPairIdentityVersion);
	}
	protected KeyPairIdentity forgetByAllInternal(RetailscmUserContext userContext,
			String keyPairIdentityId, int keyPairIdentityVersion) throws Exception{

		return keyPairIdentityDaoOf(userContext).disconnectFromAll(keyPairIdentityId, keyPairIdentityVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new KeyPairIdentityManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return keyPairIdentityDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, KeyPairIdentity newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    keyPairIdentityDaoOf(ctx).loadAllAsStream().forEach(
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
		//   KeyPairIdentity newKeyPairIdentity = this.createKeyPairIdentity(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newKeyPairIdentity
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
    key.put(UserApp.APP_TYPE_PROPERTY, KeyPairIdentity.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<KeyPairIdentity> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<PublicKeyType> keyTypeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, PublicKeyType.class);
		userContext.getDAOGroup().enhanceList(keyTypeList, PublicKeyType.class);
		List<SecUser> secUserList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SecUser.class);
		userContext.getDAOGroup().enhanceList(secUserList, SecUser.class);


    }
	
	public Object listByKeyType(RetailscmUserContext userContext,String keyTypeId) throws Exception {
		return listPageByKeyType(userContext, keyTypeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByKeyType(RetailscmUserContext userContext,String keyTypeId, int start, int count) throws Exception {
		SmartList<KeyPairIdentity> list = keyPairIdentityDaoOf(userContext).findKeyPairIdentityByKeyType(keyTypeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(KeyPairIdentity.class);
		page.setContainerObject(PublicKeyType.withId(keyTypeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("秘钥对认证列表");
		page.setRequestName("listByKeyType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByKeyType/%s/",  getBeanName(), keyTypeId)));

		page.assemblerContent(userContext, "listByKeyType");
		return page.doRender(userContext);
	}
  
	public Object listBySecUser(RetailscmUserContext userContext,String secUserId) throws Exception {
		return listPageBySecUser(userContext, secUserId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageBySecUser(RetailscmUserContext userContext,String secUserId, int start, int count) throws Exception {
		SmartList<KeyPairIdentity> list = keyPairIdentityDaoOf(userContext).findKeyPairIdentityBySecUser(secUserId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(KeyPairIdentity.class);
		page.setContainerObject(SecUser.withId(secUserId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("秘钥对认证列表");
		page.setRequestName("listBySecUser");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listBySecUser/%s/",  getBeanName(), secUserId)));

		page.assemblerContent(userContext, "listBySecUser");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String keyPairIdentityId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		KeyPairIdentity merchantObj = (KeyPairIdentity) this.view(userContext, keyPairIdentityId);
    String merchantObjId = keyPairIdentityId;
    String linkToUrl =	"keyPairIdentityManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "秘钥对认证"+"详情";
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
				MapUtil.put("id", "2-publicKey")
				    .put("fieldName", "publicKey")
				    .put("label", "公钥")
				    .put("type", "longtext")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("publicKey", merchantObj.getPublicKey());

		propList.add(
				MapUtil.put("id", "3-keyType")
				    .put("fieldName", "keyType")
				    .put("label", "秘钥类型")
				    .put("type", "auto")
				    .put("linkToUrl", "publicKeyTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"sign_alg\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"key_alg\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("keyType", merchantObj.getKeyType());

		propList.add(
				MapUtil.put("id", "4-secUser")
				    .put("fieldName", "secUser")
				    .put("label", "系统用户")
				    .put("type", "auto")
				    .put("linkToUrl", "secUserManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"verification_code\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"login\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("secUser", merchantObj.getSecUser());

		propList.add(
				MapUtil.put("id", "5-createTime")
				    .put("fieldName", "createTime")
				    .put("label", "创建时间")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("createTime", merchantObj.getCreateTime());

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




