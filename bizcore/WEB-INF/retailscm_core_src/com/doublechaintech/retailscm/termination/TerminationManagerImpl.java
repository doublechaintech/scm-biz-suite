
package com.doublechaintech.retailscm.termination;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.terminationreason.CandidateTerminationReason;import com.doublechaintech.retailscm.terminationreason.TerminationReason;import com.doublechaintech.retailscm.terminationtype.CandidateTerminationType;import com.doublechaintech.retailscm.terminationtype.TerminationType;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class TerminationManagerImpl extends CustomRetailscmCheckerManager implements TerminationManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "Termination";
	@Override
	public TerminationDAO daoOf(RetailscmUserContext userContext) {
		return terminationDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws TerminationManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new TerminationManagerException(message);

	}



 	protected Termination saveTermination(RetailscmUserContext userContext, Termination termination, String [] tokensExpr) throws Exception{
 		//return getTerminationDAO().save(termination, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveTermination(userContext, termination, tokens);
 	}

 	protected Termination saveTerminationDetail(RetailscmUserContext userContext, Termination termination) throws Exception{


 		return saveTermination(userContext, termination, allTokens());
 	}

 	public Termination loadTermination(RetailscmUserContext userContext, String terminationId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfTermination(terminationId);

		checkerOf(userContext).throwExceptionIfHasErrors( TerminationManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		Termination termination = loadTermination( userContext, terminationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,termination, tokens);
 	}


 	 public Termination searchTermination(RetailscmUserContext userContext, String terminationId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfTermination(terminationId);

		checkerOf(userContext).throwExceptionIfHasErrors( TerminationManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		Termination termination = loadTermination( userContext, terminationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,termination, tokens);
 	}



 	protected Termination present(RetailscmUserContext userContext, Termination termination, Map<String, Object> tokens) throws Exception {


		addActions(userContext,termination,tokens);
    

		Termination  terminationToPresent = terminationDaoOf(userContext).present(termination, tokens);

		List<BaseEntity> entityListToNaming = terminationToPresent.collectRefercencesFromLists();
		terminationDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,termination,tokens);

		return  terminationToPresent;


	}



 	public Termination loadTerminationDetail(RetailscmUserContext userContext, String terminationId) throws Exception{
 		Termination termination = loadTermination( userContext, terminationId, allTokens());
 		return present(userContext,termination, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String terminationId) throws Exception{
 		Termination termination = loadTermination( userContext, terminationId, viewTokens());
 		markVisited(userContext, termination);
 		return present(userContext,termination, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String terminationId) throws Exception{
		Termination termination = loadTermination( userContext, terminationId, viewTokens());
		termination.summarySuffix();
		markVisited(userContext, termination);
 		return present(userContext,termination, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String terminationId) throws Exception{
		Termination termination = loadTermination( userContext, terminationId, analyzeTokens());
		markVisited(userContext, termination);
		return present(userContext,termination, analyzeTokens());

	}
 	protected Termination saveTermination(RetailscmUserContext userContext, Termination termination, Map<String,Object>tokens) throws Exception{
 	
 		return terminationDaoOf(userContext).save(termination, tokens);
 	}
 	protected Termination loadTermination(RetailscmUserContext userContext, String terminationId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfTermination(terminationId);

		checkerOf(userContext).throwExceptionIfHasErrors( TerminationManagerException.class);



 		return terminationDaoOf(userContext).load(terminationId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Termination termination, Map<String, Object> tokens){
		super.addActions(userContext, termination, tokens);

		addAction(userContext, termination, tokens,"@create","createTermination","createTermination/","main","primary");
		addAction(userContext, termination, tokens,"@update","updateTermination","updateTermination/"+termination.getId()+"/","main","primary");
		addAction(userContext, termination, tokens,"@copy","cloneTermination","cloneTermination/"+termination.getId()+"/","main","primary");

		addAction(userContext, termination, tokens,"termination.transfer_to_reason","transferToAnotherReason","transferToAnotherReason/"+termination.getId()+"/","main","primary");
		addAction(userContext, termination, tokens,"termination.transfer_to_type","transferToAnotherType","transferToAnotherType/"+termination.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Termination termination, Map<String, Object> tokens){








  @Override
  public List<Termination> searchTerminationList(RetailscmUserContext ctx, TerminationRequest pRequest){
      pRequest.setUserContext(ctx);
      List<Termination> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public Termination searchTermination(RetailscmUserContext ctx, TerminationRequest pRequest){
    pRequest.limit(0, 1);
    List<Termination> list = searchTerminationList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public Termination createTermination(RetailscmUserContext userContext, String reasonId,String typeId,String comment) throws Exception
	{





		checkerOf(userContext).checkCommentOfTermination(comment);


		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);



		Termination termination=createNewTermination();	

			
		TerminationReason reason = loadTerminationReason(userContext, reasonId,emptyOptions());
		termination.setReason(reason);
		
		
			
		TerminationType type = loadTerminationType(userContext, typeId,emptyOptions());
		termination.setType(type);
		
		
		termination.setComment(comment);

		termination = saveTermination(userContext, termination, emptyOptions());
		
		onNewInstanceCreated(userContext, termination);
		return termination;


	}
	protected Termination createNewTermination()
	{

		return new Termination();
	}

	protected void checkParamsForUpdatingTermination(RetailscmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfTermination(terminationId);
		checkerOf(userContext).checkVersionOfTermination( terminationVersion);



		

		
		if(Termination.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfTermination(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);



	}



	public Termination clone(RetailscmUserContext userContext, String fromTerminationId) throws Exception{

		return terminationDaoOf(userContext).clone(fromTerminationId, this.allTokens());
	}

	public Termination internalSaveTermination(RetailscmUserContext userContext, Termination termination) throws Exception
	{
		return internalSaveTermination(userContext, termination, allTokens());

	}
	public Termination internalSaveTermination(RetailscmUserContext userContext, Termination termination, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingTermination(userContext, terminationId, terminationVersion, property, newValueExpr, tokensExpr);


		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Termination.
			if (termination.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixTermination(termination);
			termination = saveTermination(userContext, termination, options);
			return termination;

		}

	}

	public Termination updateTermination(RetailscmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTermination(userContext, terminationId, terminationVersion, property, newValueExpr, tokensExpr);



		Termination termination = loadTermination(userContext, terminationId, allTokens());
		if(termination.getVersion() != terminationVersion){
			String message = "The target version("+termination.getVersion()+") is not equals to version("+terminationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Termination.
			
			termination.changeProperty(property, newValueExpr);
			termination = saveTermination(userContext, termination, tokens().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
			//return saveTermination(userContext, termination, tokens().done());
		}

	}

	public Termination updateTerminationProperty(RetailscmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTermination(userContext, terminationId, terminationVersion, property, newValueExpr, tokensExpr);

		Termination termination = loadTermination(userContext, terminationId, allTokens());
		if(termination.getVersion() != terminationVersion){
			String message = "The target version("+termination.getVersion()+") is not equals to version("+terminationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Termination.

			termination.changeProperty(property, newValueExpr);
			
			termination = saveTermination(userContext, termination, tokens().done());
			return present(userContext,termination, mergedAllTokens(tokensExpr));
			//return saveTermination(userContext, termination, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected TerminationTokens tokens(){
		return TerminationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TerminationTokens.all();
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
		return TerminationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherReason(RetailscmUserContext userContext, String terminationId, String anotherReasonId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTermination(terminationId);
 		checkerOf(userContext).checkIdOfTerminationReason(anotherReasonId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);

 	}
 	public Termination transferToAnotherReason(RetailscmUserContext userContext, String terminationId, String anotherReasonId) throws Exception
 	{
 		checkParamsForTransferingAnotherReason(userContext, terminationId,anotherReasonId);
 
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TerminationReason reason = loadTerminationReason(userContext, anotherReasonId, emptyOptions());
			termination.updateReason(reason);
			
			termination = saveTermination(userContext, termination, emptyOptions());

			return present(userContext,termination, allTokens());

		}

 	}

	


	public CandidateTerminationReason requestCandidateReason(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTerminationReason result = new CandidateTerminationReason();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TerminationReason> candidateList = terminationReasonDaoOf(userContext).requestCandidateTerminationReasonForTermination(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherType(RetailscmUserContext userContext, String terminationId, String anotherTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTermination(terminationId);
 		checkerOf(userContext).checkIdOfTerminationType(anotherTypeId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(TerminationManagerException.class);

 	}
 	public Termination transferToAnotherType(RetailscmUserContext userContext, String terminationId, String anotherTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherType(userContext, terminationId,anotherTypeId);
 
		Termination termination = loadTermination(userContext, terminationId, allTokens());
		synchronized(termination){
			//will be good when the termination loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TerminationType type = loadTerminationType(userContext, anotherTypeId, emptyOptions());
			termination.updateType(type);
			
			termination = saveTermination(userContext, termination, emptyOptions());

			return present(userContext,termination, allTokens());

		}

 	}

	


	public CandidateTerminationType requestCandidateType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateTerminationType result = new CandidateTerminationType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("code");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<TerminationType> candidateList = terminationTypeDaoOf(userContext).requestCandidateTerminationTypeForTermination(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected TerminationReason loadTerminationReason(RetailscmUserContext userContext, String newReasonId, Map<String,Object> options) throws Exception
 	{
    
 		return terminationReasonDaoOf(userContext).load(newReasonId, options);
 	  
 	}
 	


	

 	protected TerminationType loadTerminationType(RetailscmUserContext userContext, String newTypeId, Map<String,Object> options) throws Exception
 	{
    
 		return terminationTypeDaoOf(userContext).load(newTypeId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String terminationId, int terminationVersion) throws Exception {
		//deleteInternal(userContext, terminationId, terminationVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String terminationId, int terminationVersion) throws Exception{

		terminationDaoOf(userContext).delete(terminationId, terminationVersion);
	}

	public Termination forgetByAll(RetailscmUserContext userContext, String terminationId, int terminationVersion) throws Exception {
		return forgetByAllInternal(userContext, terminationId, terminationVersion);
	}
	protected Termination forgetByAllInternal(RetailscmUserContext userContext,
			String terminationId, int terminationVersion) throws Exception{

		return terminationDaoOf(userContext).disconnectFromAll(terminationId, terminationVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TerminationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return terminationDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, Termination newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    terminationDaoOf(ctx).loadAllAsStream().forEach(
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
		//   Termination newTermination = this.createTermination(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newTermination
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
    key.put(UserApp.APP_TYPE_PROPERTY, Termination.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<Termination> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<TerminationReason> reasonList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TerminationReason.class);
		userContext.getDAOGroup().enhanceList(reasonList, TerminationReason.class);
		List<TerminationType> typeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TerminationType.class);
		userContext.getDAOGroup().enhanceList(typeList, TerminationType.class);


    }
	
	public Object listByReason(RetailscmUserContext userContext,String reasonId) throws Exception {
		return listPageByReason(userContext, reasonId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByReason(RetailscmUserContext userContext,String reasonId, int start, int count) throws Exception {
		SmartList<Termination> list = terminationDaoOf(userContext).findTerminationByReason(reasonId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Termination.class);
		page.setContainerObject(TerminationReason.withId(reasonId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("雇佣终止列表");
		page.setRequestName("listByReason");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByReason/%s/",  getBeanName(), reasonId)));

		page.assemblerContent(userContext, "listByReason");
		return page.doRender(userContext);
	}
  
	public Object listByType(RetailscmUserContext userContext,String typeId) throws Exception {
		return listPageByType(userContext, typeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByType(RetailscmUserContext userContext,String typeId, int start, int count) throws Exception {
		SmartList<Termination> list = terminationDaoOf(userContext).findTerminationByType(typeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Termination.class);
		page.setContainerObject(TerminationType.withId(typeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("雇佣终止列表");
		page.setRequestName("listByType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByType/%s/",  getBeanName(), typeId)));

		page.assemblerContent(userContext, "listByType");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String terminationId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		Termination merchantObj = (Termination) this.view(userContext, terminationId);
    String merchantObjId = terminationId;
    String linkToUrl =	"terminationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "雇佣终止"+"详情";
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
				MapUtil.put("id", "2-reason")
				    .put("fieldName", "reason")
				    .put("label", "原因")
				    .put("type", "auto")
				    .put("linkToUrl", "terminationReasonManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"code\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("reason", merchantObj.getReason());

		propList.add(
				MapUtil.put("id", "3-type")
				    .put("fieldName", "type")
				    .put("label", "类型")
				    .put("type", "auto")
				    .put("linkToUrl", "terminationTypeManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"base_description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"code\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("type", merchantObj.getType());

		propList.add(
				MapUtil.put("id", "4-comment")
				    .put("fieldName", "comment")
				    .put("label", "评论")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("comment", merchantObj.getComment());

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




