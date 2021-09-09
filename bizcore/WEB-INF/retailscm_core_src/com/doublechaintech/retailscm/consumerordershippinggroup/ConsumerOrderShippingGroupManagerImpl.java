
package com.doublechaintech.retailscm.consumerordershippinggroup;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.consumerorder.CandidateConsumerOrder;import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class ConsumerOrderShippingGroupManagerImpl extends CustomRetailscmCheckerManager implements ConsumerOrderShippingGroupManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "ConsumerOrderShippingGroup";
	@Override
	public ConsumerOrderShippingGroupDAO daoOf(RetailscmUserContext userContext) {
		return consumerOrderShippingGroupDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws ConsumerOrderShippingGroupManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ConsumerOrderShippingGroupManagerException(message);

	}



 	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, String [] tokensExpr) throws Exception{
 		//return getConsumerOrderShippingGroupDAO().save(consumerOrderShippingGroup, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens);
 	}

 	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroupDetail(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup) throws Exception{


 		return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, allTokens());
 	}

 	public ConsumerOrderShippingGroup loadConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);

		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderShippingGroupManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderShippingGroup, tokens);
 	}


 	 public ConsumerOrderShippingGroup searchConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);

		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderShippingGroupManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,consumerOrderShippingGroup, tokens);
 	}



 	protected ConsumerOrderShippingGroup present(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String, Object> tokens) throws Exception {


		addActions(userContext,consumerOrderShippingGroup,tokens);
    

		ConsumerOrderShippingGroup  consumerOrderShippingGroupToPresent = consumerOrderShippingGroupDaoOf(userContext).present(consumerOrderShippingGroup, tokens);

		List<BaseEntity> entityListToNaming = consumerOrderShippingGroupToPresent.collectRefercencesFromLists();
		consumerOrderShippingGroupDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,consumerOrderShippingGroup,tokens);

		return  consumerOrderShippingGroupToPresent;


	}



 	public ConsumerOrderShippingGroup loadConsumerOrderShippingGroupDetail(RetailscmUserContext userContext, String consumerOrderShippingGroupId) throws Exception{
 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, allTokens());
 		return present(userContext,consumerOrderShippingGroup, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String consumerOrderShippingGroupId) throws Exception{
 		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, viewTokens());
 		markVisited(userContext, consumerOrderShippingGroup);
 		return present(userContext,consumerOrderShippingGroup, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String consumerOrderShippingGroupId) throws Exception{
		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, viewTokens());
		consumerOrderShippingGroup.summarySuffix();
		markVisited(userContext, consumerOrderShippingGroup);
 		return present(userContext,consumerOrderShippingGroup, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String consumerOrderShippingGroupId) throws Exception{
		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup( userContext, consumerOrderShippingGroupId, analyzeTokens());
		markVisited(userContext, consumerOrderShippingGroup);
		return present(userContext,consumerOrderShippingGroup, analyzeTokens());

	}
 	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object>tokens) throws Exception{
 	
 		return consumerOrderShippingGroupDaoOf(userContext).save(consumerOrderShippingGroup, tokens);
 	}
 	protected ConsumerOrderShippingGroup loadConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderShippingGroupId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);

		checkerOf(userContext).throwExceptionIfHasErrors( ConsumerOrderShippingGroupManagerException.class);



 		return consumerOrderShippingGroupDaoOf(userContext).load(consumerOrderShippingGroupId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String, Object> tokens){
		super.addActions(userContext, consumerOrderShippingGroup, tokens);

		addAction(userContext, consumerOrderShippingGroup, tokens,"@create","createConsumerOrderShippingGroup","createConsumerOrderShippingGroup/","main","primary");
		addAction(userContext, consumerOrderShippingGroup, tokens,"@update","updateConsumerOrderShippingGroup","updateConsumerOrderShippingGroup/"+consumerOrderShippingGroup.getId()+"/","main","primary");
		addAction(userContext, consumerOrderShippingGroup, tokens,"@copy","cloneConsumerOrderShippingGroup","cloneConsumerOrderShippingGroup/"+consumerOrderShippingGroup.getId()+"/","main","primary");

		addAction(userContext, consumerOrderShippingGroup, tokens,"consumer_order_shipping_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+consumerOrderShippingGroup.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String, Object> tokens){








  @Override
  public List<ConsumerOrderShippingGroup> searchConsumerOrderShippingGroupList(RetailscmUserContext ctx, ConsumerOrderShippingGroupRequest pRequest){
      pRequest.setUserContext(ctx);
      List<ConsumerOrderShippingGroup> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public ConsumerOrderShippingGroup searchConsumerOrderShippingGroup(RetailscmUserContext ctx, ConsumerOrderShippingGroupRequest pRequest){
    pRequest.limit(0, 1);
    List<ConsumerOrderShippingGroup> list = searchConsumerOrderShippingGroupList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public ConsumerOrderShippingGroup createConsumerOrderShippingGroup(RetailscmUserContext userContext, String name,String bizOrderId,BigDecimal amount) throws Exception
	{





		checkerOf(userContext).checkNameOfConsumerOrderShippingGroup(name);
		checkerOf(userContext).checkAmountOfConsumerOrderShippingGroup(amount);


		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderShippingGroupManagerException.class);



		ConsumerOrderShippingGroup consumerOrderShippingGroup=createNewConsumerOrderShippingGroup();	

		consumerOrderShippingGroup.setName(name);
			
		ConsumerOrder bizOrder = loadConsumerOrder(userContext, bizOrderId,emptyOptions());
		consumerOrderShippingGroup.setBizOrder(bizOrder);
		
		
		consumerOrderShippingGroup.setAmount(amount);

		consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, consumerOrderShippingGroup);
		return consumerOrderShippingGroup;


	}
	protected ConsumerOrderShippingGroup createNewConsumerOrderShippingGroup()
	{

		return new ConsumerOrderShippingGroup();
	}

	protected void checkParamsForUpdatingConsumerOrderShippingGroup(RetailscmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
		checkerOf(userContext).checkVersionOfConsumerOrderShippingGroup( consumerOrderShippingGroupVersion);


		if(ConsumerOrderShippingGroup.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfConsumerOrderShippingGroup(parseString(newValueExpr));
		

		}

		
		if(ConsumerOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfConsumerOrderShippingGroup(parseBigDecimal(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderShippingGroupManagerException.class);



	}



	public ConsumerOrderShippingGroup clone(RetailscmUserContext userContext, String fromConsumerOrderShippingGroupId) throws Exception{

		return consumerOrderShippingGroupDaoOf(userContext).clone(fromConsumerOrderShippingGroupId, this.allTokens());
	}

	public ConsumerOrderShippingGroup internalSaveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup) throws Exception
	{
		return internalSaveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, allTokens());

	}
	public ConsumerOrderShippingGroup internalSaveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion, property, newValueExpr, tokensExpr);


		synchronized(consumerOrderShippingGroup){
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShippingGroup.
			if (consumerOrderShippingGroup.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixConsumerOrderShippingGroup(consumerOrderShippingGroup);
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, options);
			return consumerOrderShippingGroup;

		}

	}

	public ConsumerOrderShippingGroup updateConsumerOrderShippingGroup(RetailscmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion, property, newValueExpr, tokensExpr);



		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, allTokens());
		if(consumerOrderShippingGroup.getVersion() != consumerOrderShippingGroupVersion){
			String message = "The target version("+consumerOrderShippingGroup.getVersion()+") is not equals to version("+consumerOrderShippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderShippingGroup){
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShippingGroup.
			
			consumerOrderShippingGroup.changeProperty(property, newValueExpr);
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
			return present(userContext,consumerOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
		}

	}

	public ConsumerOrderShippingGroup updateConsumerOrderShippingGroupProperty(RetailscmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion, property, newValueExpr, tokensExpr);

		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, allTokens());
		if(consumerOrderShippingGroup.getVersion() != consumerOrderShippingGroupVersion){
			String message = "The target version("+consumerOrderShippingGroup.getVersion()+") is not equals to version("+consumerOrderShippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(consumerOrderShippingGroup){
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ConsumerOrderShippingGroup.

			consumerOrderShippingGroup.changeProperty(property, newValueExpr);
			
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
			return present(userContext,consumerOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ConsumerOrderShippingGroupTokens tokens(){
		return ConsumerOrderShippingGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ConsumerOrderShippingGroupTokens.all();
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
		return ConsumerOrderShippingGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfConsumerOrderShippingGroup(consumerOrderShippingGroupId);
 		checkerOf(userContext).checkIdOfConsumerOrder(anotherBizOrderId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(ConsumerOrderShippingGroupManagerException.class);

 	}
 	public ConsumerOrderShippingGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, consumerOrderShippingGroupId,anotherBizOrderId);
 
		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadConsumerOrderShippingGroup(userContext, consumerOrderShippingGroupId, allTokens());
		synchronized(consumerOrderShippingGroup){
			//will be good when the consumerOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(userContext, anotherBizOrderId, emptyOptions());
			consumerOrderShippingGroup.updateBizOrder(bizOrder);
			
			consumerOrderShippingGroup = saveConsumerOrderShippingGroup(userContext, consumerOrderShippingGroup, emptyOptions());

			return present(userContext,consumerOrderShippingGroup, allTokens());

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
		SmartList<ConsumerOrder> candidateList = consumerOrderDaoOf(userContext).requestCandidateConsumerOrderForConsumerOrderShippingGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception {
		//deleteInternal(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception{

		consumerOrderShippingGroupDaoOf(userContext).delete(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
	}

	public ConsumerOrderShippingGroup forgetByAll(RetailscmUserContext userContext, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
	}
	protected ConsumerOrderShippingGroup forgetByAllInternal(RetailscmUserContext userContext,
			String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion) throws Exception{

		return consumerOrderShippingGroupDaoOf(userContext).disconnectFromAll(consumerOrderShippingGroupId, consumerOrderShippingGroupVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ConsumerOrderShippingGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return consumerOrderShippingGroupDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderShippingGroup newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    consumerOrderShippingGroupDaoOf(ctx).loadAllAsStream().forEach(
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
		//   ConsumerOrderShippingGroup newConsumerOrderShippingGroup = this.createConsumerOrderShippingGroup(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newConsumerOrderShippingGroup
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
    key.put(UserApp.APP_TYPE_PROPERTY, ConsumerOrderShippingGroup.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<ConsumerOrderShippingGroup> list) throws Exception {
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
		SmartList<ConsumerOrderShippingGroup> list = consumerOrderShippingGroupDaoOf(userContext).findConsumerOrderShippingGroupByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(ConsumerOrderShippingGroup.class);
		page.setContainerObject(ConsumerOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("消费订单送货分组列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String consumerOrderShippingGroupId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		ConsumerOrderShippingGroup merchantObj = (ConsumerOrderShippingGroup) this.view(userContext, consumerOrderShippingGroupId);
    String merchantObjId = consumerOrderShippingGroupId;
    String linkToUrl =	"consumerOrderShippingGroupManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "消费订单送货分组"+"详情";
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




