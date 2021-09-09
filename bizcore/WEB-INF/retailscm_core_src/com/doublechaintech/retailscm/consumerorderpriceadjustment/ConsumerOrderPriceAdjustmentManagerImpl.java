
package com.doublechaintech.retailscm.consumerorderpriceadjustment;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.consumerorder.CandidateConsumerOrder;import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class ConsumerOrderPriceAdjustmentManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderPriceAdjustmentManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "ConsumerOrderPriceAdjustment";
	@Override
	public ConsumerOrderPriceAdjustmentDAO daoOf(RetailscmUserContext userContext) {
		return consumerOrderPriceAdjustmentDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws ConsumerOrderPriceAdjustmentManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderPriceAdjustmentManagerException(message);

	}



 	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustment(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, String [] tokensExpr) throws Exception{
 		//return getConsumerOrderPriceAdjustmentDAO().save(consumerOrderPriceAdjustment, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens);
 	}

 	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustmentDetail(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment) throws Exception{


 		return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, allTokens());
 	}

 	public ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);

		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderPriceAdjustmentManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderPriceAdjustment, tokens);
 	}


 	 public ConsumerOrderPriceAdjustment searchConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);

		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderPriceAdjustmentManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderPriceAdjustment, tokens);
 	}



 	protected ConsumerOrderPriceAdjustment present(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String, Object> tokens) throws Exception {


		addActions(userContext,consumerOrderPriceAdjustment,tokens);
    

		ConsumerOrderPriceAdjustment  consumerOrderPriceAdjustmentToPresent = consumerOrderPriceAdjustmentDaoOf(userContext).present(consumerOrderPriceAdjustment, tokens);

		List<BaseEntity> entityListToNaming = consumerOrderPriceAdjustmentToPresent.collectRefercencesFromLists();
		consumerOrderPriceAdjustmentDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,consumerOrderPriceAdjustment,tokens);

		return  consumerOrderPriceAdjustmentToPresent;


	}



 	public ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustmentDetail(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId) throws Exception{
 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, allTokens());
 		return present(userContext,consumerOrderPriceAdjustment, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId) throws Exception{
 		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, viewTokens());
 		markVisited(userContext, consumerOrderPriceAdjustment);
 		return present(userContext,consumerOrderPriceAdjustment, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId) throws Exception{
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, viewTokens());
		consumerOrderPriceAdjustment.summarySuffix();
		markVisited(userContext, consumerOrderPriceAdjustment);
 		return present(userContext,consumerOrderPriceAdjustment, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId) throws Exception{
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment( userContext, consumerOrderPriceAdjustmentId, analyzeTokens());
		markVisited(userContext, consumerOrderPriceAdjustment);
		return present(userContext,consumerOrderPriceAdjustment, analyzeTokens());

	}
 	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustment(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object>tokens) throws Exception{
 	
 		return consumerOrderPriceAdjustmentDaoOf(userContext).save(consumerOrderPriceAdjustment, tokens);
 	}
 	protected ConsumerOrderPriceAdjustment loadConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);

		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderPriceAdjustmentManagerException.class);



 		return consumerOrderPriceAdjustmentDaoOf(userContext).load(consumerOrderPriceAdjustmentId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderPriceAdjustment, tokens);

		addAction(userContext, consumerOrderPriceAdjustment, tokens,"@create","createConsumerOrderPriceAdjustment","createConsumerOrderPriceAdjustment/","main","primary");
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"@update","updateConsumerOrderPriceAdjustment","updateConsumerOrderPriceAdjustment/"+consumerOrderPriceAdjustment.getId()+"/","main","primary");
		addAction(userContext, consumerOrderPriceAdjustment, tokens,"@copy","cloneConsumerOrderPriceAdjustment","cloneConsumerOrderPriceAdjustment/"+consumerOrderPriceAdjustment.getId()+"/","main","primary");

		addAction(userContext, consumerOrderPriceAdjustment, tokens,"consumer_order_price_adjustment.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderPriceAdjustment.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String, Object> tokens){








  @Override
  public List<ConsumerOrderPriceAdjustment> searchConsumerOrderPriceAdjustmentList(RetailscmUserContext ctx, ConsumerOrderPriceAdjustmentRequest pRequest){
      pRequest.setUserContext(ctx);
      List<ConsumerOrderPriceAdjustment> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public ConsumerOrderPriceAdjustment searchConsumerOrderPriceAdjustment(RetailscmUserContext ctx, ConsumerOrderPriceAdjustmentRequest pRequest){
    pRequest.limit(0, 1);
    List<ConsumerOrderPriceAdjustment> list = searchConsumerOrderPriceAdjustmentList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String name,String bizOrderId,BigDecimal amount,String provider) throws Exception
	{





		checkerOf(userContext).checkNameOfConsumerOrderPriceAdjustment(name);
		checkerOf(userContext).checkAmountOfConsumerOrderPriceAdjustment(amount);
		checkerOf(userContext).checkProviderOfConsumerOrderPriceAdjustment(provider);


		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderPriceAdjustmentManagerException.class);



		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment=createNewConsumerOrderPriceAdjustment();	

		consumerOrderPriceAdjustment.setName(name);
			
		ConsumerOrder bizOrder = loadConsumerOrder(userContext, bizOrderId,emptyOptions());
		consumerOrderPriceAdjustment.setBizOrder(bizOrder);
		
		
		consumerOrderPriceAdjustment.setAmount(amount);
		consumerOrderPriceAdjustment.setProvider(provider);

		consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderPriceAdjustment);
		return consumerOrderPriceAdjustment;


	}
	protected ConsumerOrderPriceAdjustment createNewConsumerOrderPriceAdjustment()
	{

		return new ConsumerOrderPriceAdjustment();
	}

	protected void checkParamsForUpdatingConsumerOrderPriceAdjustment(RetailscmUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
		checkerOf(userContext).checkVersionOfConsumerOrderPriceAdjustment( consumerOrderPriceAdjustmentVersion);


		if(ConsumerOrderPriceAdjustment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfConsumerOrderPriceAdjustment(parseString(newValueExpr));
		

		}

		
		if(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfConsumerOrderPriceAdjustment(parseBigDecimal(newValueExpr));
		

		}
		if(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkProviderOfConsumerOrderPriceAdjustment(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderPriceAdjustmentManagerException.class);



	}



	public ConsumerOrderPriceAdjustment clone(RetailscmUserContext userContext, String fromConsumerOrderPriceAdjustmentId) throws Exception{

		return consumerOrderPriceAdjustmentDaoOf(userContext).clone(fromConsumerOrderPriceAdjustmentId, this.allTokens());
	}

	public ConsumerOrderPriceAdjustment internalSaveConsumerOrderPriceAdjustment(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment) throws Exception
	{
		return internalSaveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, allTokens());

	}
	public ConsumerOrderPriceAdjustment internalSaveConsumerOrderPriceAdjustment(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion, property, newValueExpr, tokensExpr);


		synchronized(consumerOrderPriceAdjustment){
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPriceAdjustment.
			if (consumerOrderPriceAdjustment.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixConsumerOrderPriceAdjustment(consumerOrderPriceAdjustment);
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, options);
			return consumerOrderPriceAdjustment;

		}

	}

	public ConsumerOrderPriceAdjustment updateConsumerOrderPriceAdjustment(RetailscmUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion, property, newValueExpr, tokensExpr);



		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, allTokens());
		if(consumerOrderPriceAdjustment.getVersion() != consumerOrderPriceAdjustmentVersion){
			String message = "The target version("+consumerOrderPriceAdjustment.getVersion()+") is not equals to version("+consumerOrderPriceAdjustmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderPriceAdjustment){
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPriceAdjustment.
			
			consumerOrderPriceAdjustment.changeProperty(property, newValueExpr);
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
			return present(userContext,consumerOrderPriceAdjustment, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
		}

	}

	public ConsumerOrderPriceAdjustment updateConsumerOrderPriceAdjustmentProperty(RetailscmUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion, property, newValueExpr, tokensExpr);

		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, allTokens());
		if(consumerOrderPriceAdjustment.getVersion() != consumerOrderPriceAdjustmentVersion){
			String message = "The target version("+consumerOrderPriceAdjustment.getVersion()+") is not equals to version("+consumerOrderPriceAdjustmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderPriceAdjustment){
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderPriceAdjustment.

			consumerOrderPriceAdjustment.changeProperty(property, newValueExpr);
			
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
			return present(userContext,consumerOrderPriceAdjustment, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ConsumerOrderPriceAdjustmentTokens tokens(){
		return ConsumerOrderPriceAdjustmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderPriceAdjustmentTokens.all();
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
		return ConsumerOrderPriceAdjustmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfConsumerOrderPriceAdjustment(consumerOrderPriceAdjustmentId);
 		checkerOf(userContext).checkIdOfConsumerOrder(anotherBizOrderId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderPriceAdjustmentManagerException.class);

 	}
 	public ConsumerOrderPriceAdjustment transferToAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderPriceAdjustmentId,anotherBizOrderId);
 
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustmentId, allTokens());
		synchronized(consumerOrderPriceAdjustment){
			//will be good when the consumerOrderPriceAdjustment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(userContext, anotherBizOrderId, emptyOptions());
			consumerOrderPriceAdjustment.updateBizOrder(bizOrder);
			
			consumerOrderPriceAdjustment = saveConsumerOrderPriceAdjustment(userContext, consumerOrderPriceAdjustment, emptyOptions());

			return present(userContext,consumerOrderPriceAdjustment, allTokens());

		}

 	}

	


	public CandidateConsumerOrder requestCandidateBizOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateConsumerOrder result = new CandidateConsumerOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ConsumerOrder> candidateList = consumerOrderDaoOf(userContext).requestCandidateConsumerOrderForConsumerOrderPriceAdjustment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected ConsumerOrder loadConsumerOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{
    
 		return consumerOrderDaoOf(userContext).load(newBizOrderId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception{

		consumerOrderPriceAdjustmentDaoOf(userContext).delete(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
	}

	public ConsumerOrderPriceAdjustment forgetByAll(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
	}
	protected ConsumerOrderPriceAdjustment forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion) throws Exception{

		return consumerOrderPriceAdjustmentDaoOf(userContext).disconnectFromAll(consumerOrderPriceAdjustmentId, consumerOrderPriceAdjustmentVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderPriceAdjustmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return consumerOrderPriceAdjustmentDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderPriceAdjustment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    consumerOrderPriceAdjustmentDaoOf(ctx).loadAllAsStream().forEach(
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
		//   ConsumerOrderPriceAdjustment newConsumerOrderPriceAdjustment = this.createConsumerOrderPriceAdjustment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newConsumerOrderPriceAdjustment
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
    key.put(UserApp.APP_TYPE_PROPERTY, ConsumerOrderPriceAdjustment.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<ConsumerOrderPriceAdjustment> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<ConsumerOrder> bizOrderList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, ConsumerOrder.class);
		userContext.getDAOGroup().enhanceList(bizOrderList, ConsumerOrder.class);


    }
	
	public Object listByBizOrder(RetailscmUserContext userContext,String bizOrderId) throws Exception {
		return listPageByBizOrder(userContext, bizOrderId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBizOrder(RetailscmUserContext userContext,String bizOrderId, int start, int count) throws Exception {
		SmartList<ConsumerOrderPriceAdjustment> list = consumerOrderPriceAdjustmentDaoOf(userContext).findConsumerOrderPriceAdjustmentByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(ConsumerOrderPriceAdjustment.class);
		page.setContainerObject(ConsumerOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("消费品价格调整列表");
		page.setRequestName("listByBizOrder");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBizOrder/%s/",  getBeanName(), bizOrderId)));

		page.assemblerContent(userContext, "listByBizOrder");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String consumerOrderPriceAdjustmentId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		ConsumerOrderPriceAdjustment merchantObj = (ConsumerOrderPriceAdjustment) this.view(userContext, consumerOrderPriceAdjustmentId);
    String merchantObjId = consumerOrderPriceAdjustmentId;
    String linkToUrl =	"consumerOrderPriceAdjustmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "消费品价格调整"+"详情";
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
				MapUtil.put("id", "3-bizOrder")
				    .put("fieldName", "bizOrder")
				    .put("label", "订单")
				    .put("type", "auto")
				    .put("linkToUrl", "consumerOrderManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("bizOrder", merchantObj.getBizOrder());

		propList.add(
				MapUtil.put("id", "4-amount")
				    .put("fieldName", "amount")
				    .put("label", "金额")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("amount", merchantObj.getAmount());

		propList.add(
				MapUtil.put("id", "5-provider")
				    .put("fieldName", "provider")
				    .put("label", "供应商")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("provider", merchantObj.getProvider());

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




