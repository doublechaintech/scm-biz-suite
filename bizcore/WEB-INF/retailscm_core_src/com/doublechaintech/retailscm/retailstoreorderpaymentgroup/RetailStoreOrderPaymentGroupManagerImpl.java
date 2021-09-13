
package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.retailstoreorder.CandidateRetailStoreOrder;import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class RetailStoreOrderPaymentGroupManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOrderPaymentGroupManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "RetailStoreOrderPaymentGroup";
	@Override
	public RetailStoreOrderPaymentGroupDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreOrderPaymentGroupDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws RetailStoreOrderPaymentGroupManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOrderPaymentGroupManagerException(message);

	}



 	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, String [] tokensExpr) throws Exception{
 		//return getRetailStoreOrderPaymentGroupDAO().save(retailStoreOrderPaymentGroup, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens);
 	}

 	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroupDetail(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup) throws Exception{


 		return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, allTokens());
 	}

 	public RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderPaymentGroupManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderPaymentGroup, tokens);
 	}


 	 public RetailStoreOrderPaymentGroup searchRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderPaymentGroupManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOrderPaymentGroup, tokens);
 	}



 	protected RetailStoreOrderPaymentGroup present(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String, Object> tokens) throws Exception {


		addActions(userContext,retailStoreOrderPaymentGroup,tokens);
    

		RetailStoreOrderPaymentGroup  retailStoreOrderPaymentGroupToPresent = retailStoreOrderPaymentGroupDaoOf(userContext).present(retailStoreOrderPaymentGroup, tokens);

		List<BaseEntity> entityListToNaming = retailStoreOrderPaymentGroupToPresent.collectRefercencesFromLists();
		retailStoreOrderPaymentGroupDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,retailStoreOrderPaymentGroup,tokens);

		return  retailStoreOrderPaymentGroupToPresent;


	}



 	public RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroupDetail(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId) throws Exception{
 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, allTokens());
 		return present(userContext,retailStoreOrderPaymentGroup, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId) throws Exception{
 		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, viewTokens());
 		markVisited(userContext, retailStoreOrderPaymentGroup);
 		return present(userContext,retailStoreOrderPaymentGroup, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId) throws Exception{
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, viewTokens());
		retailStoreOrderPaymentGroup.summarySuffix();
		markVisited(userContext, retailStoreOrderPaymentGroup);
 		return present(userContext,retailStoreOrderPaymentGroup, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId) throws Exception{
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup( userContext, retailStoreOrderPaymentGroupId, analyzeTokens());
		markVisited(userContext, retailStoreOrderPaymentGroup);
		return present(userContext,retailStoreOrderPaymentGroup, analyzeTokens());

	}
 	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object>tokens) throws Exception{
 	
 		return retailStoreOrderPaymentGroupDaoOf(userContext).save(retailStoreOrderPaymentGroup, tokens);
 	}
 	protected RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOrderPaymentGroupManagerException.class);



 		return retailStoreOrderPaymentGroupDaoOf(userContext).load(retailStoreOrderPaymentGroupId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOrderPaymentGroup, tokens);

		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"@create","createRetailStoreOrderPaymentGroup","createRetailStoreOrderPaymentGroup/","main","primary");
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"@update","updateRetailStoreOrderPaymentGroup","updateRetailStoreOrderPaymentGroup/"+retailStoreOrderPaymentGroup.getId()+"/","main","primary");
		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"@copy","cloneRetailStoreOrderPaymentGroup","cloneRetailStoreOrderPaymentGroup/"+retailStoreOrderPaymentGroup.getId()+"/","main","primary");

		addAction(userContext, retailStoreOrderPaymentGroup, tokens,"retail_store_order_payment_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreOrderPaymentGroup.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String, Object> tokens){








  @Override
  public List<RetailStoreOrderPaymentGroup> searchRetailStoreOrderPaymentGroupList(RetailscmUserContext ctx, RetailStoreOrderPaymentGroupRequest pRequest){
      pRequest.setUserContext(ctx);
      List<RetailStoreOrderPaymentGroup> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public RetailStoreOrderPaymentGroup searchRetailStoreOrderPaymentGroup(RetailscmUserContext ctx, RetailStoreOrderPaymentGroupRequest pRequest){
    pRequest.limit(0, 1);
    List<RetailStoreOrderPaymentGroup> list = searchRetailStoreOrderPaymentGroupList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String name,String bizOrderId,String cardNumber) throws Exception
	{





		checkerOf(userContext).checkNameOfRetailStoreOrderPaymentGroup(name);
		checkerOf(userContext).checkCardNumberOfRetailStoreOrderPaymentGroup(cardNumber);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPaymentGroupManagerException.class);



		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup=createNewRetailStoreOrderPaymentGroup();	

		retailStoreOrderPaymentGroup.setName(name);
			
		RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, bizOrderId,emptyOptions());
		retailStoreOrderPaymentGroup.setBizOrder(bizOrder);
		
		
		retailStoreOrderPaymentGroup.setCardNumber(cardNumber);

		retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOrderPaymentGroup);
		return retailStoreOrderPaymentGroup;


	}
	protected RetailStoreOrderPaymentGroup createNewRetailStoreOrderPaymentGroup()
	{

		return new RetailStoreOrderPaymentGroup();
	}

	protected void checkParamsForUpdatingRetailStoreOrderPaymentGroup(RetailscmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
		checkerOf(userContext).checkVersionOfRetailStoreOrderPaymentGroup( retailStoreOrderPaymentGroupVersion);


		if(RetailStoreOrderPaymentGroup.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreOrderPaymentGroup(parseString(newValueExpr));
		

		}

		
		if(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCardNumberOfRetailStoreOrderPaymentGroup(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPaymentGroupManagerException.class);



	}



	public RetailStoreOrderPaymentGroup clone(RetailscmUserContext userContext, String fromRetailStoreOrderPaymentGroupId) throws Exception{

		return retailStoreOrderPaymentGroupDaoOf(userContext).clone(fromRetailStoreOrderPaymentGroupId, this.allTokens());
	}

	public RetailStoreOrderPaymentGroup internalSaveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup) throws Exception
	{
		return internalSaveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, allTokens());

	}
	public RetailStoreOrderPaymentGroup internalSaveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreOrderPaymentGroup){
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPaymentGroup.
			if (retailStoreOrderPaymentGroup.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroup);
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, options);
			return retailStoreOrderPaymentGroup;

		}

	}

	public RetailStoreOrderPaymentGroup updateRetailStoreOrderPaymentGroup(RetailscmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);



		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, allTokens());
		if(retailStoreOrderPaymentGroup.getVersion() != retailStoreOrderPaymentGroupVersion){
			String message = "The target version("+retailStoreOrderPaymentGroup.getVersion()+") is not equals to version("+retailStoreOrderPaymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderPaymentGroup){
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPaymentGroup.
			
			retailStoreOrderPaymentGroup.changeProperty(property, newValueExpr);
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
			return present(userContext,retailStoreOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
		}

	}

	public RetailStoreOrderPaymentGroup updateRetailStoreOrderPaymentGroupProperty(RetailscmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);

		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, allTokens());
		if(retailStoreOrderPaymentGroup.getVersion() != retailStoreOrderPaymentGroupVersion){
			String message = "The target version("+retailStoreOrderPaymentGroup.getVersion()+") is not equals to version("+retailStoreOrderPaymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOrderPaymentGroup){
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOrderPaymentGroup.

			retailStoreOrderPaymentGroup.changeProperty(property, newValueExpr);
			
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
			return present(userContext,retailStoreOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreOrderPaymentGroupTokens tokens(){
		return RetailStoreOrderPaymentGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOrderPaymentGroupTokens.all();
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
		return RetailStoreOrderPaymentGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroupId);
 		checkerOf(userContext).checkIdOfRetailStoreOrder(anotherBizOrderId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOrderPaymentGroupManagerException.class);

 	}
 	public RetailStoreOrderPaymentGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreOrderPaymentGroupId,anotherBizOrderId);
 
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroupId, allTokens());
		synchronized(retailStoreOrderPaymentGroup){
			//will be good when the retailStoreOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOrder bizOrder = loadRetailStoreOrder(userContext, anotherBizOrderId, emptyOptions());
			retailStoreOrderPaymentGroup.updateBizOrder(bizOrder);
			
			retailStoreOrderPaymentGroup = saveRetailStoreOrderPaymentGroup(userContext, retailStoreOrderPaymentGroup, emptyOptions());

			return present(userContext,retailStoreOrderPaymentGroup, allTokens());

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
		SmartList<RetailStoreOrder> candidateList = retailStoreOrderDaoOf(userContext).requestCandidateRetailStoreOrderForRetailStoreOrderPaymentGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception{

		retailStoreOrderPaymentGroupDaoOf(userContext).delete(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
	}

	public RetailStoreOrderPaymentGroup forgetByAll(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
	}
	protected RetailStoreOrderPaymentGroup forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion) throws Exception{

		return retailStoreOrderPaymentGroupDaoOf(userContext).disconnectFromAll(retailStoreOrderPaymentGroupId, retailStoreOrderPaymentGroupVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOrderPaymentGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreOrderPaymentGroupDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    retailStoreOrderPaymentGroupDaoOf(ctx).loadAllAsStream().forEach(
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
		//   RetailStoreOrderPaymentGroup newRetailStoreOrderPaymentGroup = this.createRetailStoreOrderPaymentGroup(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreOrderPaymentGroup
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreOrderPaymentGroup.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreOrderPaymentGroup> list) throws Exception {
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
		SmartList<RetailStoreOrderPaymentGroup> list = retailStoreOrderPaymentGroupDaoOf(userContext).findRetailStoreOrderPaymentGroupByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStoreOrderPaymentGroup.class);
		page.setContainerObject(RetailStoreOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("生超订单付款组列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		RetailStoreOrderPaymentGroup merchantObj = (RetailStoreOrderPaymentGroup) this.view(userContext, retailStoreOrderPaymentGroupId);
    String merchantObjId = retailStoreOrderPaymentGroupId;
    String linkToUrl =	"retailStoreOrderPaymentGroupManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超订单付款组"+"详情";
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
				MapUtil.put("id", "4-cardNumber")
				    .put("fieldName", "cardNumber")
				    .put("label", "卡号码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("cardNumber", merchantObj.getCardNumber());

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




