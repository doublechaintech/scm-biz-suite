
package com.doublechaintech.retailscm.supplyorderpaymentgroup;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.supplyorder.CandidateSupplyOrder;import com.doublechaintech.retailscm.supplyorder.SupplyOrder;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class SupplyOrderPaymentGroupManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderPaymentGroupManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "SupplyOrderPaymentGroup";
	@Override
	public SupplyOrderPaymentGroupDAO daoOf(RetailscmUserContext userContext) {
		return supplyOrderPaymentGroupDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws SupplyOrderPaymentGroupManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderPaymentGroupManagerException(message);

	}



 	protected SupplyOrderPaymentGroup saveSupplyOrderPaymentGroup(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, String [] tokensExpr) throws Exception{
 		//return getSupplyOrderPaymentGroupDAO().save(supplyOrderPaymentGroup, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens);
 	}

 	protected SupplyOrderPaymentGroup saveSupplyOrderPaymentGroupDetail(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup) throws Exception{


 		return saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, allTokens());
 	}

 	public SupplyOrderPaymentGroup loadSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);

		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderPaymentGroupManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderPaymentGroup, tokens);
 	}


 	 public SupplyOrderPaymentGroup searchSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);

		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderPaymentGroupManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderPaymentGroup, tokens);
 	}



 	protected SupplyOrderPaymentGroup present(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String, Object> tokens) throws Exception {


		addActions(userContext,supplyOrderPaymentGroup,tokens);
    

		SupplyOrderPaymentGroup  supplyOrderPaymentGroupToPresent = supplyOrderPaymentGroupDaoOf(userContext).present(supplyOrderPaymentGroup, tokens);

		List<BaseEntity> entityListToNaming = supplyOrderPaymentGroupToPresent.collectRefercencesFromLists();
		supplyOrderPaymentGroupDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,supplyOrderPaymentGroup,tokens);

		return  supplyOrderPaymentGroupToPresent;


	}



 	public SupplyOrderPaymentGroup loadSupplyOrderPaymentGroupDetail(RetailscmUserContext userContext, String supplyOrderPaymentGroupId) throws Exception{
 		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, allTokens());
 		return present(userContext,supplyOrderPaymentGroup, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String supplyOrderPaymentGroupId) throws Exception{
 		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, viewTokens());
 		markVisited(userContext, supplyOrderPaymentGroup);
 		return present(userContext,supplyOrderPaymentGroup, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String supplyOrderPaymentGroupId) throws Exception{
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, viewTokens());
		supplyOrderPaymentGroup.summarySuffix();
		markVisited(userContext, supplyOrderPaymentGroup);
 		return present(userContext,supplyOrderPaymentGroup, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String supplyOrderPaymentGroupId) throws Exception{
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, analyzeTokens());
		markVisited(userContext, supplyOrderPaymentGroup);
		return present(userContext,supplyOrderPaymentGroup, analyzeTokens());

	}
 	protected SupplyOrderPaymentGroup saveSupplyOrderPaymentGroup(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String,Object>tokens) throws Exception{
 	
 		return supplyOrderPaymentGroupDaoOf(userContext).save(supplyOrderPaymentGroup, tokens);
 	}
 	protected SupplyOrderPaymentGroup loadSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);

		checkerOf(userContext).throwExceptionIfHasErrors( SupplyOrderPaymentGroupManagerException.class);



 		return supplyOrderPaymentGroupDaoOf(userContext).load(supplyOrderPaymentGroupId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderPaymentGroup, tokens);

		addAction(userContext, supplyOrderPaymentGroup, tokens,"@create","createSupplyOrderPaymentGroup","createSupplyOrderPaymentGroup/","main","primary");
		addAction(userContext, supplyOrderPaymentGroup, tokens,"@update","updateSupplyOrderPaymentGroup","updateSupplyOrderPaymentGroup/"+supplyOrderPaymentGroup.getId()+"/","main","primary");
		addAction(userContext, supplyOrderPaymentGroup, tokens,"@copy","cloneSupplyOrderPaymentGroup","cloneSupplyOrderPaymentGroup/"+supplyOrderPaymentGroup.getId()+"/","main","primary");

		addAction(userContext, supplyOrderPaymentGroup, tokens,"supply_order_payment_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+supplyOrderPaymentGroup.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String, Object> tokens){








  @Override
  public List<SupplyOrderPaymentGroup> searchSupplyOrderPaymentGroupList(RetailscmUserContext ctx, SupplyOrderPaymentGroupRequest pRequest){
      pRequest.setUserContext(ctx);
      List<SupplyOrderPaymentGroup> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public SupplyOrderPaymentGroup searchSupplyOrderPaymentGroup(RetailscmUserContext ctx, SupplyOrderPaymentGroupRequest pRequest){
    pRequest.limit(0, 1);
    List<SupplyOrderPaymentGroup> list = searchSupplyOrderPaymentGroupList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public SupplyOrderPaymentGroup createSupplyOrderPaymentGroup(RetailscmUserContext userContext, String name,String bizOrderId,String cardNumber) throws Exception
	{





		checkerOf(userContext).checkNameOfSupplyOrderPaymentGroup(name);
		checkerOf(userContext).checkCardNumberOfSupplyOrderPaymentGroup(cardNumber);


		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderPaymentGroupManagerException.class);



		SupplyOrderPaymentGroup supplyOrderPaymentGroup=createNewSupplyOrderPaymentGroup();	

		supplyOrderPaymentGroup.setName(name);
			
		SupplyOrder bizOrder = loadSupplyOrder(userContext, bizOrderId,emptyOptions());
		supplyOrderPaymentGroup.setBizOrder(bizOrder);
		
		
		supplyOrderPaymentGroup.setCardNumber(cardNumber);

		supplyOrderPaymentGroup = saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderPaymentGroup);
		return supplyOrderPaymentGroup;


	}
	protected SupplyOrderPaymentGroup createNewSupplyOrderPaymentGroup()
	{

		return new SupplyOrderPaymentGroup();
	}

	protected void checkParamsForUpdatingSupplyOrderPaymentGroup(RetailscmUserContext userContext,String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
		checkerOf(userContext).checkVersionOfSupplyOrderPaymentGroup( supplyOrderPaymentGroupVersion);


		if(SupplyOrderPaymentGroup.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfSupplyOrderPaymentGroup(parseString(newValueExpr));
		

		}

		
		if(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCardNumberOfSupplyOrderPaymentGroup(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderPaymentGroupManagerException.class);



	}



	public SupplyOrderPaymentGroup clone(RetailscmUserContext userContext, String fromSupplyOrderPaymentGroupId) throws Exception{

		return supplyOrderPaymentGroupDaoOf(userContext).clone(fromSupplyOrderPaymentGroupId, this.allTokens());
	}

	public SupplyOrderPaymentGroup internalSaveSupplyOrderPaymentGroup(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup) throws Exception
	{
		return internalSaveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, allTokens());

	}
	public SupplyOrderPaymentGroup internalSaveSupplyOrderPaymentGroup(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);


		synchronized(supplyOrderPaymentGroup){
			//will be good when the supplyOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderPaymentGroup.
			if (supplyOrderPaymentGroup.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixSupplyOrderPaymentGroup(supplyOrderPaymentGroup);
			supplyOrderPaymentGroup = saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, options);
			return supplyOrderPaymentGroup;

		}

	}

	public SupplyOrderPaymentGroup updateSupplyOrderPaymentGroup(RetailscmUserContext userContext,String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);



		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, allTokens());
		if(supplyOrderPaymentGroup.getVersion() != supplyOrderPaymentGroupVersion){
			String message = "The target version("+supplyOrderPaymentGroup.getVersion()+") is not equals to version("+supplyOrderPaymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderPaymentGroup){
			//will be good when the supplyOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderPaymentGroup.
			
			supplyOrderPaymentGroup.changeProperty(property, newValueExpr);
			supplyOrderPaymentGroup = saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens().done());
			return present(userContext,supplyOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens().done());
		}

	}

	public SupplyOrderPaymentGroup updateSupplyOrderPaymentGroupProperty(RetailscmUserContext userContext,String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);

		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, allTokens());
		if(supplyOrderPaymentGroup.getVersion() != supplyOrderPaymentGroupVersion){
			String message = "The target version("+supplyOrderPaymentGroup.getVersion()+") is not equals to version("+supplyOrderPaymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderPaymentGroup){
			//will be good when the supplyOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderPaymentGroup.

			supplyOrderPaymentGroup.changeProperty(property, newValueExpr);
			
			supplyOrderPaymentGroup = saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens().done());
			return present(userContext,supplyOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected SupplyOrderPaymentGroupTokens tokens(){
		return SupplyOrderPaymentGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderPaymentGroupTokens.all();
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
		return SupplyOrderPaymentGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
 		checkerOf(userContext).checkIdOfSupplyOrder(anotherBizOrderId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(SupplyOrderPaymentGroupManagerException.class);

 	}
 	public SupplyOrderPaymentGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, supplyOrderPaymentGroupId,anotherBizOrderId);
 
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, allTokens());
		synchronized(supplyOrderPaymentGroup){
			//will be good when the supplyOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrder bizOrder = loadSupplyOrder(userContext, anotherBizOrderId, emptyOptions());
			supplyOrderPaymentGroup.updateBizOrder(bizOrder);
			
			supplyOrderPaymentGroup = saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, emptyOptions());

			return present(userContext,supplyOrderPaymentGroup, allTokens());

		}

 	}

	


	public CandidateSupplyOrder requestCandidateBizOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrder result = new CandidateSupplyOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("buyer");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrder> candidateList = supplyOrderDaoOf(userContext).requestCandidateSupplyOrderForSupplyOrderPaymentGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected SupplyOrder loadSupplyOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{
    
 		return supplyOrderDaoOf(userContext).load(newBizOrderId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion) throws Exception{

		supplyOrderPaymentGroupDaoOf(userContext).delete(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
	}

	public SupplyOrderPaymentGroup forgetByAll(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
	}
	protected SupplyOrderPaymentGroup forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion) throws Exception{

		return supplyOrderPaymentGroupDaoOf(userContext).disconnectFromAll(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderPaymentGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return supplyOrderPaymentGroupDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderPaymentGroup newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    supplyOrderPaymentGroupDaoOf(ctx).loadAllAsStream().forEach(
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
		//   SupplyOrderPaymentGroup newSupplyOrderPaymentGroup = this.createSupplyOrderPaymentGroup(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSupplyOrderPaymentGroup
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
    key.put(UserApp.APP_TYPE_PROPERTY, SupplyOrderPaymentGroup.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<SupplyOrderPaymentGroup> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<SupplyOrder> bizOrderList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, SupplyOrder.class);
		userContext.getDAOGroup().enhanceList(bizOrderList, SupplyOrder.class);


    }
	
	public Object listByBizOrder(RetailscmUserContext userContext,String bizOrderId) throws Exception {
		return listPageByBizOrder(userContext, bizOrderId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBizOrder(RetailscmUserContext userContext,String bizOrderId, int start, int count) throws Exception {
		SmartList<SupplyOrderPaymentGroup> list = supplyOrderPaymentGroupDaoOf(userContext).findSupplyOrderPaymentGroupByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(SupplyOrderPaymentGroup.class);
		page.setContainerObject(SupplyOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("供应订单付款组列表");
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
 	public Object wxappview(RetailscmUserContext userContext, String supplyOrderPaymentGroupId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		SupplyOrderPaymentGroup merchantObj = (SupplyOrderPaymentGroup) this.view(userContext, supplyOrderPaymentGroupId);
    String merchantObjId = supplyOrderPaymentGroupId;
    String linkToUrl =	"supplyOrderPaymentGroupManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "供应订单付款组"+"详情";
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
				    .put("linkToUrl", "supplyOrderManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"total_amount\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
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




