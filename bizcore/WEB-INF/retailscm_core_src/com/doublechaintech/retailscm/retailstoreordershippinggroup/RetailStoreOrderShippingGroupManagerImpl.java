
package com.doublechaintech.retailscm.retailstoreordershippinggroup;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.retailstoreorder.CandidateRetailStoreOrder;import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class RetailStoreOrderShippingGroupManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderShippingGroupManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "RetailStoreOrderShippingGroup";
	@Override
	public RetailStoreOrderShippingGroupDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreOrderShippingGroupDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderShippingGroupManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderShippingGroupManagerException(message);

	}



 	protected RetailStoreOrderShippingGroup saveRetailStoreOrderShippingGroup(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, String [] tokensExpr) throws Exception{
 		//return getRetailStoreOrderShippingGroupDAO().save(retailStoreOrderShippingGroup, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens);
 	}

 	protected RetailStoreOrderShippingGroup saveRetailStoreOrderShippingGroupDetail(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) throws Exception{


 		return saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, allTokens());
 	}

 	public RetailStoreOrderShippingGroup loadRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderShippingGroupManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderShippingGroup, tokens);
 	}


 	 public RetailStoreOrderShippingGroup searchRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderShippingGroupManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderShippingGroup, tokens);
 	}



 	protected RetailStoreOrderShippingGroup present(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> tokens) throws Exception {


		addActions(userContext,retailStoreOrderShippingGroup,tokens);
    

		RetailStoreOrderShippingGroup  retailStoreOrderShippingGroupToPresent = retailStoreOrderShippingGroupDaoOf(userContext).present(retailStoreOrderShippingGroup, tokens);

		List<BaseEntity> entityListToNaming = retailStoreOrderShippingGroupToPresent.collectRefercencesFromLists();
		retailStoreOrderShippingGroupDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,retailStoreOrderShippingGroup,tokens);

		return  retailStoreOrderShippingGroupToPresent;


	}



 	public RetailStoreOrderShippingGroup loadRetailStoreOrderShippingGroupDetail(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId) throws Exception{
 		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, allTokens());
 		return present(userContext,retailStoreOrderShippingGroup, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId) throws Exception{
 		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, viewTokens());
 		markVisited(userContext, retailStoreOrderShippingGroup);
 		return present(userContext,retailStoreOrderShippingGroup, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId) throws Exception{
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, viewTokens());
		retailStoreOrderShippingGroup.summarySuffix();
		markVisited(userContext, retailStoreOrderShippingGroup);
 		return present(userContext,retailStoreOrderShippingGroup, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId) throws Exception{
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup( userContext, retailStoreOrderShippingGroupId, analyzeTokens());
		markVisited(userContext, retailStoreOrderShippingGroup);
		return present(userContext,retailStoreOrderShippingGroup, analyzeTokens());

	}
 	protected RetailStoreOrderShippingGroup saveRetailStoreOrderShippingGroup(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String,Object>tokens) throws Exception{
 	
 		return retailStoreOrderShippingGroupDaoOf(userContext).save(retailStoreOrderShippingGroup, tokens);
 	}
 	protected RetailStoreOrderShippingGroup loadRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderShippingGroupManagerException.class);



 		return retailStoreOrderShippingGroupDaoOf(userContext).load(retailStoreOrderShippingGroupId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderShippingGroup, tokens);

		addAction(userContext, retailStoreOrderShippingGroup, tokens,"@create","createRetailStoreOrderShippingGroup","createRetailStoreOrderShippingGroup/","main","primary");
		addAction(userContext, retailStoreOrderShippingGroup, tokens,"@update","updateRetailStoreOrderShippingGroup","updateRetailStoreOrderShippingGroup/"+retailStoreOrderShippingGroup.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderShippingGroup, tokens,"@copy","cloneRetailStoreOrderShippingGroup","cloneRetailStoreOrderShippingGroup/"+retailStoreOrderShippingGroup.getId()+"/","main","primary");

		addAction(userContext, retailStoreOrderShippingGroup, tokens,"retail_store_order_shipping_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreOrderShippingGroup.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String, Object> tokens){








  @Override
  public List<RetailStoreOrderShippingGroup> searchRetailStoreOrderShippingGroupList(RetailscmUserContext ctx, RetailStoreOrderShippingGroupRequest pRequest){
      pRequest.setUserContext(ctx);
      List<RetailStoreOrderShippingGroup> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public RetailStoreOrderShippingGroup searchRetailStoreOrderShippingGroup(RetailscmUserContext ctx, RetailStoreOrderShippingGroupRequest pRequest){
    pRequest.limit(0, 1);
    List<RetailStoreOrderShippingGroup> list = searchRetailStoreOrderShippingGroupList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public RetailStoreOrderShippingGroup createRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String name,String bizOrderId,BigDecimal amount) throws Exception
	{





		checkerOf(userContext).checkNameOfRetailStoreOrderShippingGroup(name);
		checkerOf(userContext).checkAmountOfRetailStoreOrderShippingGroup(amount);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderShippingGroupManagerException.class);



		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup=createNewRetailStoreOrderShippingGroup();	

		retailStoreOrderShippingGroup.setName(name);
			
		RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, bizOrderId,emptyOptions());
		retailStoreOrderShippingGroup.setBizOrder(bizOrder);
		
		
		retailStoreOrderShippingGroup.setAmount(amount);

		retailStoreOrderShippingGroup = saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderShippingGroup);
		return retailStoreOrderShippingGroup;


	}
	protected RetailStoreOrderShippingGroup createNewRetailStoreOrderShippingGroup()
	{

		return new RetailStoreOrderShippingGroup();
	}

	protected void checkParamsForUpdatingRetailStoreOrderShippingGroup(RetailscmUserContext userContext,String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);
		checkerOf(userContext).checkVersionOfRetailStoreOrderShippingGroup( retailStoreOrderShippingGroupVersion);


		if(RetailStoreOrderShippingGroup.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreOrderShippingGroup(parseString(newValueExpr));
		

		}

		
		if(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfRetailStoreOrderShippingGroup(parseBigDecimal(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderShippingGroupManagerException.class);



	}



	public RetailStoreOrderShippingGroup clone(RetailscmUserContext userContext, String fromRetailStoreOrderShippingGroupId) throws Exception{

		return retailStoreOrderShippingGroupDaoOf(userContext).clone(fromRetailStoreOrderShippingGroupId, this.allTokens());
	}

	public RetailStoreOrderShippingGroup internalSaveRetailStoreOrderShippingGroup(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) throws Exception
	{
		return internalSaveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, allTokens());

	}
	public RetailStoreOrderShippingGroup internalSaveRetailStoreOrderShippingGroup(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreOrderShippingGroup){
			//will be good when the retailStoreOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderShippingGroup.
			if (retailStoreOrderShippingGroup.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixRetailStoreOrderShippingGroup(retailStoreOrderShippingGroup);
			retailStoreOrderShippingGroup = saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, options);
			return retailStoreOrderShippingGroup;

		}

	}

	public RetailStoreOrderShippingGroup updateRetailStoreOrderShippingGroup(RetailscmUserContext userContext,String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion, property, newValueExpr, tokensExpr);



		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, allTokens());
		if(retailStoreOrderShippingGroup.getVersion() != retailStoreOrderShippingGroupVersion){
			String message = "The target version("+retailStoreOrderShippingGroup.getVersion()+") is not equals to version("+retailStoreOrderShippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderShippingGroup){
			//will be good when the retailStoreOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderShippingGroup.
			
			retailStoreOrderShippingGroup.changeProperty(property, newValueExpr);
			retailStoreOrderShippingGroup = saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens().done());
			return present(userContext,retailStoreOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens().done());
		}

	}

	public RetailStoreOrderShippingGroup updateRetailStoreOrderShippingGroupProperty(RetailscmUserContext userContext,String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion, property, newValueExpr, tokensExpr);

		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, allTokens());
		if(retailStoreOrderShippingGroup.getVersion() != retailStoreOrderShippingGroupVersion){
			String message = "The target version("+retailStoreOrderShippingGroup.getVersion()+") is not equals to version("+retailStoreOrderShippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderShippingGroup){
			//will be good when the retailStoreOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderShippingGroup.

			retailStoreOrderShippingGroup.changeProperty(property, newValueExpr);
			
			retailStoreOrderShippingGroup = saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens().done());
			return present(userContext,retailStoreOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreOrderShippingGroupTokens tokens(){
		return RetailStoreOrderShippingGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderShippingGroupTokens.all();
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
		return RetailStoreOrderShippingGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStoreOrderShippingGroup(retailStoreOrderShippingGroupId);
 		checkerOf(userContext).checkIdOfRetailStoreOrder(anotherBizOrderId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderShippingGroupManagerException.class);

 	}
 	public RetailStoreOrderShippingGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreOrderShippingGroupId,anotherBizOrderId);
 
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = loadRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroupId, allTokens());
		synchronized(retailStoreOrderShippingGroup){
			//will be good when the retailStoreOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, anotherBizOrderId, emptyOptions());
			retailStoreOrderShippingGroup.updateBizOrder(bizOrder);
			
			retailStoreOrderShippingGroup = saveRetailStoreOrderShippingGroup(userContext, retailStoreOrderShippingGroup, emptyOptions());

			return present(userContext,retailStoreOrderShippingGroup, allTokens());

		}

 	}

	


	public CandidateRetailStoreOrder requestCandidateBizOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOrder result = new CandidateRetailStoreOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("buyer");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOrder> candidateList = retailStoreOrderDaoOf(userContext).requestCandidateRetailStoreOrderForRetailStoreOrderShippingGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreOrder loadRetailStoreOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreOrderDaoOf(userContext).load(newBizOrderId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion) throws Exception{

		retailStoreOrderShippingGroupDaoOf(userContext).delete(retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
	}

	public RetailStoreOrderShippingGroup forgetByAll(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
	}
	protected RetailStoreOrderShippingGroup forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion) throws Exception{

		return retailStoreOrderShippingGroupDaoOf(userContext).disconnectFromAll(retailStoreOrderShippingGroupId, retailStoreOrderShippingGroupVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderShippingGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreOrderShippingGroupDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderShippingGroup newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    retailStoreOrderShippingGroupDaoOf(ctx).loadAllAsStream().forEach(
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
		//   RetailStoreOrderShippingGroup newRetailStoreOrderShippingGroup = this.createRetailStoreOrderShippingGroup(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreOrderShippingGroup
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreOrderShippingGroup.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreOrderShippingGroup> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreOrder> bizOrderList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreOrder.class);
		userContext.getDAOGroup().enhanceList(bizOrderList, RetailStoreOrder.class);


    }
	
	public Object listByBizOrder(RetailscmUserContext userContext,String bizOrderId) throws Exception {
		return listPageByBizOrder(userContext, bizOrderId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBizOrder(RetailscmUserContext userContext,String bizOrderId, int start, int count) throws Exception {
		SmartList<RetailStoreOrderShippingGroup> list = retailStoreOrderShippingGroupDaoOf(userContext).findRetailStoreOrderShippingGroupByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStoreOrderShippingGroup.class);
		page.setContainerObject(RetailStoreOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("生超订单送货分组列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		RetailStoreOrderShippingGroup merchantObj = (RetailStoreOrderShippingGroup) this.view(userContext, retailStoreOrderShippingGroupId);
    String merchantObjId = retailStoreOrderShippingGroupId;
    String linkToUrl =	"retailStoreOrderShippingGroupManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超订单送货分组"+"详情";
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
				    .put("type", "document")
				    .put("linkToUrl", "retailStoreOrderManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"total_amount\",\"imageUrl\":\"\",\"name\":\"document\",\"title\":\"title\",\"imageList\":\"\"}")
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




