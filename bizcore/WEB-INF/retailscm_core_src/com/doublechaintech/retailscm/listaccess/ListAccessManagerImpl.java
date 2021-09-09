
package com.doublechaintech.retailscm.listaccess;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.CandidateUserApp;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class ListAccessManagerImpl extends CustomRetailscmCheckerManager implements ListAccessManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "ListAccess";
	@Override
	public ListAccessDAO daoOf(RetailscmUserContext userContext) {
		return listAccessDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws ListAccessManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ListAccessManagerException(message);

	}



 	protected ListAccess saveListAccess(RetailscmUserContext userContext, ListAccess listAccess, String [] tokensExpr) throws Exception{
 		//return getListAccessDAO().save(listAccess, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveListAccess(userContext, listAccess, tokens);
 	}

 	protected ListAccess saveListAccessDetail(RetailscmUserContext userContext, ListAccess listAccess) throws Exception{


 		return saveListAccess(userContext, listAccess, allTokens());
 	}

 	public ListAccess loadListAccess(RetailscmUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfListAccess(listAccessId);

		checkerOf(userContext).throwExceptionIfHasErrors( ListAccessManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		ListAccess listAccess = loadListAccess( userContext, listAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,listAccess, tokens);
 	}


 	 public ListAccess searchListAccess(RetailscmUserContext userContext, String listAccessId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfListAccess(listAccessId);

		checkerOf(userContext).throwExceptionIfHasErrors( ListAccessManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		ListAccess listAccess = loadListAccess( userContext, listAccessId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,listAccess, tokens);
 	}



 	protected ListAccess present(RetailscmUserContext userContext, ListAccess listAccess, Map<String, Object> tokens) throws Exception {


		addActions(userContext,listAccess,tokens);
    

		ListAccess  listAccessToPresent = listAccessDaoOf(userContext).present(listAccess, tokens);

		List<BaseEntity> entityListToNaming = listAccessToPresent.collectRefercencesFromLists();
		listAccessDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,listAccess,tokens);

		return  listAccessToPresent;


	}



 	public ListAccess loadListAccessDetail(RetailscmUserContext userContext, String listAccessId) throws Exception{
 		ListAccess listAccess = loadListAccess( userContext, listAccessId, allTokens());
 		return present(userContext,listAccess, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String listAccessId) throws Exception{
 		ListAccess listAccess = loadListAccess( userContext, listAccessId, viewTokens());
 		markVisited(userContext, listAccess);
 		return present(userContext,listAccess, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String listAccessId) throws Exception{
		ListAccess listAccess = loadListAccess( userContext, listAccessId, viewTokens());
		listAccess.summarySuffix();
		markVisited(userContext, listAccess);
 		return present(userContext,listAccess, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String listAccessId) throws Exception{
		ListAccess listAccess = loadListAccess( userContext, listAccessId, analyzeTokens());
		markVisited(userContext, listAccess);
		return present(userContext,listAccess, analyzeTokens());

	}
 	protected ListAccess saveListAccess(RetailscmUserContext userContext, ListAccess listAccess, Map<String,Object>tokens) throws Exception{
 	
 		return listAccessDaoOf(userContext).save(listAccess, tokens);
 	}
 	protected ListAccess loadListAccess(RetailscmUserContext userContext, String listAccessId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfListAccess(listAccessId);

		checkerOf(userContext).throwExceptionIfHasErrors( ListAccessManagerException.class);



 		return listAccessDaoOf(userContext).load(listAccessId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ListAccess listAccess, Map<String, Object> tokens){
		super.addActions(userContext, listAccess, tokens);

		addAction(userContext, listAccess, tokens,"@create","createListAccess","createListAccess/","main","primary");
		addAction(userContext, listAccess, tokens,"@update","updateListAccess","updateListAccess/"+listAccess.getId()+"/","main","primary");
		addAction(userContext, listAccess, tokens,"@copy","cloneListAccess","cloneListAccess/"+listAccess.getId()+"/","main","primary");

		addAction(userContext, listAccess, tokens,"list_access.transfer_to_app","transferToAnotherApp","transferToAnotherApp/"+listAccess.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ListAccess listAccess, Map<String, Object> tokens){








  @Override
  public List<ListAccess> searchListAccessList(RetailscmUserContext ctx, ListAccessRequest pRequest){
      pRequest.setUserContext(ctx);
      List<ListAccess> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public ListAccess searchListAccess(RetailscmUserContext ctx, ListAccessRequest pRequest){
    pRequest.limit(0, 1);
    List<ListAccess> list = searchListAccessList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public ListAccess createListAccess(RetailscmUserContext userContext, String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission,String appId) throws Exception
	{





		checkerOf(userContext).checkNameOfListAccess(name);
		checkerOf(userContext).checkInternalNameOfListAccess(internalName);
		checkerOf(userContext).checkReadPermissionOfListAccess(readPermission);
		checkerOf(userContext).checkCreatePermissionOfListAccess(createPermission);
		checkerOf(userContext).checkDeletePermissionOfListAccess(deletePermission);
		checkerOf(userContext).checkUpdatePermissionOfListAccess(updatePermission);
		checkerOf(userContext).checkExecutionPermissionOfListAccess(executionPermission);


		checkerOf(userContext).throwExceptionIfHasErrors(ListAccessManagerException.class);



		ListAccess listAccess=createNewListAccess();	

		listAccess.setName(name);
		listAccess.setInternalName(internalName);
		listAccess.setReadPermission(readPermission);
		listAccess.setCreatePermission(createPermission);
		listAccess.setDeletePermission(deletePermission);
		listAccess.setUpdatePermission(updatePermission);
		listAccess.setExecutionPermission(executionPermission);
			
		UserApp app = loadUserApp(userContext, appId,emptyOptions());
		listAccess.setApp(app);
		
		

		listAccess = saveListAccess(userContext, listAccess, emptyOptions());
		
		onNewInstanceCreated(userContext, listAccess);
		return listAccess;


	}
	protected ListAccess createNewListAccess()
	{

		return new ListAccess();
	}

	protected void checkParamsForUpdatingListAccess(RetailscmUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfListAccess(listAccessId);
		checkerOf(userContext).checkVersionOfListAccess( listAccessVersion);


		if(ListAccess.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfListAccess(parseString(newValueExpr));
		

		}
		if(ListAccess.INTERNAL_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkInternalNameOfListAccess(parseString(newValueExpr));
		

		}
		if(ListAccess.READ_PERMISSION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkReadPermissionOfListAccess(parseBoolean(newValueExpr));
		

		}
		if(ListAccess.CREATE_PERMISSION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCreatePermissionOfListAccess(parseBoolean(newValueExpr));
		

		}
		if(ListAccess.DELETE_PERMISSION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDeletePermissionOfListAccess(parseBoolean(newValueExpr));
		

		}
		if(ListAccess.UPDATE_PERMISSION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUpdatePermissionOfListAccess(parseBoolean(newValueExpr));
		

		}
		if(ListAccess.EXECUTION_PERMISSION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkExecutionPermissionOfListAccess(parseBoolean(newValueExpr));
		

		}

		


		checkerOf(userContext).throwExceptionIfHasErrors(ListAccessManagerException.class);



	}



	public ListAccess clone(RetailscmUserContext userContext, String fromListAccessId) throws Exception{

		return listAccessDaoOf(userContext).clone(fromListAccessId, this.allTokens());
	}

	public ListAccess internalSaveListAccess(RetailscmUserContext userContext, ListAccess listAccess) throws Exception
	{
		return internalSaveListAccess(userContext, listAccess, allTokens());

	}
	public ListAccess internalSaveListAccess(RetailscmUserContext userContext, ListAccess listAccess, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingListAccess(userContext, listAccessId, listAccessVersion, property, newValueExpr, tokensExpr);


		synchronized(listAccess){
			//will be good when the listAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ListAccess.
			if (listAccess.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixListAccess(listAccess);
			listAccess = saveListAccess(userContext, listAccess, options);
			return listAccess;

		}

	}

	public ListAccess updateListAccess(RetailscmUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingListAccess(userContext, listAccessId, listAccessVersion, property, newValueExpr, tokensExpr);



		ListAccess listAccess = loadListAccess(userContext, listAccessId, allTokens());
		if(listAccess.getVersion() != listAccessVersion){
			String message = "The target version("+listAccess.getVersion()+") is not equals to version("+listAccessVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(listAccess){
			//will be good when the listAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ListAccess.
			
			listAccess.changeProperty(property, newValueExpr);
			listAccess = saveListAccess(userContext, listAccess, tokens().done());
			return present(userContext,listAccess, mergedAllTokens(tokensExpr));
			//return saveListAccess(userContext, listAccess, tokens().done());
		}

	}

	public ListAccess updateListAccessProperty(RetailscmUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingListAccess(userContext, listAccessId, listAccessVersion, property, newValueExpr, tokensExpr);

		ListAccess listAccess = loadListAccess(userContext, listAccessId, allTokens());
		if(listAccess.getVersion() != listAccessVersion){
			String message = "The target version("+listAccess.getVersion()+") is not equals to version("+listAccessVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(listAccess){
			//will be good when the listAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ListAccess.

			listAccess.changeProperty(property, newValueExpr);
			
			listAccess = saveListAccess(userContext, listAccess, tokens().done());
			return present(userContext,listAccess, mergedAllTokens(tokensExpr));
			//return saveListAccess(userContext, listAccess, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ListAccessTokens tokens(){
		return ListAccessTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ListAccessTokens.all();
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
		return ListAccessTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherApp(RetailscmUserContext userContext, String listAccessId, String anotherAppId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfListAccess(listAccessId);
 		checkerOf(userContext).checkIdOfUserApp(anotherAppId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(ListAccessManagerException.class);

 	}
 	public ListAccess transferToAnotherApp(RetailscmUserContext userContext, String listAccessId, String anotherAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherApp(userContext, listAccessId,anotherAppId);
 
		ListAccess listAccess = loadListAccess(userContext, listAccessId, allTokens());
		synchronized(listAccess){
			//will be good when the listAccess loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserApp app = loadUserApp(userContext, anotherAppId, emptyOptions());
			listAccess.updateApp(app);
			
			listAccess = saveListAccess(userContext, listAccess, emptyOptions());

			return present(userContext,listAccess, allTokens());

		}

 	}

	


	public CandidateUserApp requestCandidateApp(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserApp result = new CandidateUserApp();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserApp> candidateList = userAppDaoOf(userContext).requestCandidateUserAppForListAccess(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected UserApp loadUserApp(RetailscmUserContext userContext, String newAppId, Map<String,Object> options) throws Exception
 	{
    
 		return userAppDaoOf(userContext).load(newAppId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String listAccessId, int listAccessVersion) throws Exception {
		//deleteInternal(userContext, listAccessId, listAccessVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String listAccessId, int listAccessVersion) throws Exception{

		listAccessDaoOf(userContext).delete(listAccessId, listAccessVersion);
	}

	public ListAccess forgetByAll(RetailscmUserContext userContext, String listAccessId, int listAccessVersion) throws Exception {
		return forgetByAllInternal(userContext, listAccessId, listAccessVersion);
	}
	protected ListAccess forgetByAllInternal(RetailscmUserContext userContext,
			String listAccessId, int listAccessVersion) throws Exception{

		return listAccessDaoOf(userContext).disconnectFromAll(listAccessId, listAccessVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ListAccessManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return listAccessDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, ListAccess newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    listAccessDaoOf(ctx).loadAllAsStream().forEach(
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
		//   ListAccess newListAccess = this.createListAccess(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newListAccess
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
    key.put(UserApp.APP_TYPE_PROPERTY, ListAccess.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<ListAccess> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<UserApp> appList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, UserApp.class);
		userContext.getDAOGroup().enhanceList(appList, UserApp.class);


    }
	
	public Object listByApp(RetailscmUserContext userContext,String appId) throws Exception {
		return listPageByApp(userContext, appId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByApp(RetailscmUserContext userContext,String appId, int start, int count) throws Exception {
		SmartList<ListAccess> list = listAccessDaoOf(userContext).findListAccessByApp(appId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(ListAccess.class);
		page.setContainerObject(UserApp.withId(appId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("列表访问控制列表");
		page.setRequestName("listByApp");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByApp/%s/",  getBeanName(), appId)));

		page.assemblerContent(userContext, "listByApp");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String listAccessId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		ListAccess merchantObj = (ListAccess) this.view(userContext, listAccessId);
    String merchantObjId = listAccessId;
    String linkToUrl =	"listAccessManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "列表访问控制"+"详情";
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
				MapUtil.put("id", "3-internalName")
				    .put("fieldName", "internalName")
				    .put("label", "内部名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("internalName", merchantObj.getInternalName());

		propList.add(
				MapUtil.put("id", "4-readPermission")
				    .put("fieldName", "readPermission")
				    .put("label", "可读")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("readPermission", merchantObj.getReadPermission());

		propList.add(
				MapUtil.put("id", "5-createPermission")
				    .put("fieldName", "createPermission")
				    .put("label", "可创建")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("createPermission", merchantObj.getCreatePermission());

		propList.add(
				MapUtil.put("id", "6-deletePermission")
				    .put("fieldName", "deletePermission")
				    .put("label", "可删除")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("deletePermission", merchantObj.getDeletePermission());

		propList.add(
				MapUtil.put("id", "7-updatePermission")
				    .put("fieldName", "updatePermission")
				    .put("label", "可更新")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("updatePermission", merchantObj.getUpdatePermission());

		propList.add(
				MapUtil.put("id", "8-executionPermission")
				    .put("fieldName", "executionPermission")
				    .put("label", "可执行")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("executionPermission", merchantObj.getExecutionPermission());

		propList.add(
				MapUtil.put("id", "9-app")
				    .put("fieldName", "app")
				    .put("label", "应用")
				    .put("type", "auto")
				    .put("linkToUrl", "userAppManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"app_icon\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("app", merchantObj.getApp());

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




