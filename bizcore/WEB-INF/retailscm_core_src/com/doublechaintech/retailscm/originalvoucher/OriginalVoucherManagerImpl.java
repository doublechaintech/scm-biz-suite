
package com.doublechaintech.retailscm.originalvoucher;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;import com.doublechaintech.retailscm.accountingdocument.CandidateAccountingDocument;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class OriginalVoucherManagerImpl extends CustomRetailscmCheckerManager implements OriginalVoucherManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "OriginalVoucher";
	@Override
	public OriginalVoucherDAO daoOf(RetailscmUserContext userContext) {
		return originalVoucherDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws OriginalVoucherManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new OriginalVoucherManagerException(message);

	}



 	protected OriginalVoucher saveOriginalVoucher(RetailscmUserContext userContext, OriginalVoucher originalVoucher, String [] tokensExpr) throws Exception{
 		//return getOriginalVoucherDAO().save(originalVoucher, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveOriginalVoucher(userContext, originalVoucher, tokens);
 	}

 	protected OriginalVoucher saveOriginalVoucherDetail(RetailscmUserContext userContext, OriginalVoucher originalVoucher) throws Exception{


 		return saveOriginalVoucher(userContext, originalVoucher, allTokens());
 	}

 	public OriginalVoucher loadOriginalVoucher(RetailscmUserContext userContext, String originalVoucherId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);

		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucher, tokens);
 	}


 	 public OriginalVoucher searchOriginalVoucher(RetailscmUserContext userContext, String originalVoucherId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);

		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucher, tokens);
 	}



 	protected OriginalVoucher present(RetailscmUserContext userContext, OriginalVoucher originalVoucher, Map<String, Object> tokens) throws Exception {


		addActions(userContext,originalVoucher,tokens);
    

		OriginalVoucher  originalVoucherToPresent = originalVoucherDaoOf(userContext).present(originalVoucher, tokens);

		List<BaseEntity> entityListToNaming = originalVoucherToPresent.collectRefercencesFromLists();
		originalVoucherDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,originalVoucher,tokens);

		return  originalVoucherToPresent;


	}



 	public OriginalVoucher loadOriginalVoucherDetail(RetailscmUserContext userContext, String originalVoucherId) throws Exception{
 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, allTokens());
 		return present(userContext,originalVoucher, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String originalVoucherId) throws Exception{
 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, viewTokens());
 		markVisited(userContext, originalVoucher);
 		return present(userContext,originalVoucher, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String originalVoucherId) throws Exception{
		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, viewTokens());
		originalVoucher.summarySuffix();
		markVisited(userContext, originalVoucher);
 		return present(userContext,originalVoucher, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String originalVoucherId) throws Exception{
		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, analyzeTokens());
		markVisited(userContext, originalVoucher);
		return present(userContext,originalVoucher, analyzeTokens());

	}
 	protected OriginalVoucher saveOriginalVoucher(RetailscmUserContext userContext, OriginalVoucher originalVoucher, Map<String,Object>tokens) throws Exception{
 	
 		return originalVoucherDaoOf(userContext).save(originalVoucher, tokens);
 	}
 	protected OriginalVoucher loadOriginalVoucher(RetailscmUserContext userContext, String originalVoucherId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);

		checkerOf(userContext).throwExceptionIfHasErrors( OriginalVoucherManagerException.class);



 		return originalVoucherDaoOf(userContext).load(originalVoucherId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OriginalVoucher originalVoucher, Map<String, Object> tokens){
		super.addActions(userContext, originalVoucher, tokens);

		addAction(userContext, originalVoucher, tokens,"@create","createOriginalVoucher","createOriginalVoucher/","main","primary");
		addAction(userContext, originalVoucher, tokens,"@update","updateOriginalVoucher","updateOriginalVoucher/"+originalVoucher.getId()+"/","main","primary");
		addAction(userContext, originalVoucher, tokens,"@copy","cloneOriginalVoucher","cloneOriginalVoucher/"+originalVoucher.getId()+"/","main","primary");

		addAction(userContext, originalVoucher, tokens,"original_voucher.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+originalVoucher.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OriginalVoucher originalVoucher, Map<String, Object> tokens){








  @Override
  public List<OriginalVoucher> searchOriginalVoucherList(RetailscmUserContext ctx, OriginalVoucherRequest pRequest){
      pRequest.setUserContext(ctx);
      List<OriginalVoucher> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public OriginalVoucher searchOriginalVoucher(RetailscmUserContext ctx, OriginalVoucherRequest pRequest){
    pRequest.limit(0, 1);
    List<OriginalVoucher> list = searchOriginalVoucherList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public OriginalVoucher createOriginalVoucher(RetailscmUserContext userContext, String title,String madeBy,String receivedBy,String voucherType,String voucherImage,String belongsToId) throws Exception
	{





		checkerOf(userContext).checkTitleOfOriginalVoucher(title);
		checkerOf(userContext).checkMadeByOfOriginalVoucher(madeBy);
		checkerOf(userContext).checkReceivedByOfOriginalVoucher(receivedBy);
		checkerOf(userContext).checkVoucherTypeOfOriginalVoucher(voucherType);
		checkerOf(userContext).checkVoucherImageOfOriginalVoucher(voucherImage);


		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherManagerException.class);



		OriginalVoucher originalVoucher=createNewOriginalVoucher();	

		originalVoucher.setTitle(title);
		originalVoucher.setMadeBy(madeBy);
		originalVoucher.setReceivedBy(receivedBy);
		originalVoucher.setVoucherType(voucherType);
		originalVoucher.setVoucherImage(voucherImage);
			
		AccountingDocument belongsTo = loadAccountingDocument(userContext, belongsToId,emptyOptions());
		originalVoucher.setBelongsTo(belongsTo);
		
		

		originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
		
		onNewInstanceCreated(userContext, originalVoucher);
		return originalVoucher;


	}
	protected OriginalVoucher createNewOriginalVoucher()
	{

		return new OriginalVoucher();
	}

	protected void checkParamsForUpdatingOriginalVoucher(RetailscmUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
		checkerOf(userContext).checkVersionOfOriginalVoucher( originalVoucherVersion);


		if(OriginalVoucher.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfOriginalVoucher(parseString(newValueExpr));
		

		}
		if(OriginalVoucher.MADE_BY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMadeByOfOriginalVoucher(parseString(newValueExpr));
		

		}
		if(OriginalVoucher.RECEIVED_BY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkReceivedByOfOriginalVoucher(parseString(newValueExpr));
		

		}
		if(OriginalVoucher.VOUCHER_TYPE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkVoucherTypeOfOriginalVoucher(parseString(newValueExpr));
		

		}
		if(OriginalVoucher.VOUCHER_IMAGE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkVoucherImageOfOriginalVoucher(parseString(newValueExpr));
		

		}

		


		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherManagerException.class);



	}



	public OriginalVoucher clone(RetailscmUserContext userContext, String fromOriginalVoucherId) throws Exception{

		return originalVoucherDaoOf(userContext).clone(fromOriginalVoucherId, this.allTokens());
	}

	public OriginalVoucher internalSaveOriginalVoucher(RetailscmUserContext userContext, OriginalVoucher originalVoucher) throws Exception
	{
		return internalSaveOriginalVoucher(userContext, originalVoucher, allTokens());

	}
	public OriginalVoucher internalSaveOriginalVoucher(RetailscmUserContext userContext, OriginalVoucher originalVoucher, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherId, originalVoucherVersion, property, newValueExpr, tokensExpr);


		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucher.
			if (originalVoucher.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixOriginalVoucher(originalVoucher);
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, options);
			return originalVoucher;

		}

	}

	public OriginalVoucher updateOriginalVoucher(RetailscmUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherId, originalVoucherVersion, property, newValueExpr, tokensExpr);



		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());
		if(originalVoucher.getVersion() != originalVoucherVersion){
			String message = "The target version("+originalVoucher.getVersion()+") is not equals to version("+originalVoucherVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucher.
			
			originalVoucher.changeProperty(property, newValueExpr);
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().done());
			return present(userContext,originalVoucher, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucher(userContext, originalVoucher, tokens().done());
		}

	}

	public OriginalVoucher updateOriginalVoucherProperty(RetailscmUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherId, originalVoucherVersion, property, newValueExpr, tokensExpr);

		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());
		if(originalVoucher.getVersion() != originalVoucherVersion){
			String message = "The target version("+originalVoucher.getVersion()+") is not equals to version("+originalVoucherVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucher.

			originalVoucher.changeProperty(property, newValueExpr);
			
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().done());
			return present(userContext,originalVoucher, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucher(userContext, originalVoucher, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected OriginalVoucherTokens tokens(){
		return OriginalVoucherTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OriginalVoucherTokens.all();
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
		return OriginalVoucherTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailscmUserContext userContext, String originalVoucherId, String anotherBelongsToId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfOriginalVoucher(originalVoucherId);
 		checkerOf(userContext).checkIdOfAccountingDocument(anotherBelongsToId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(OriginalVoucherManagerException.class);

 	}
 	public OriginalVoucher transferToAnotherBelongsTo(RetailscmUserContext userContext, String originalVoucherId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, originalVoucherId,anotherBelongsToId);
 
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocument belongsTo = loadAccountingDocument(userContext, anotherBelongsToId, emptyOptions());
			originalVoucher.updateBelongsTo(belongsTo);
			
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());

			return present(userContext,originalVoucher, allTokens());

		}

 	}

	


	public CandidateAccountingDocument requestCandidateBelongsTo(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateAccountingDocument result = new CandidateAccountingDocument();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<AccountingDocument> candidateList = accountingDocumentDaoOf(userContext).requestCandidateAccountingDocumentForOriginalVoucher(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected AccountingDocument loadAccountingDocument(RetailscmUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{
    
 		return accountingDocumentDaoOf(userContext).load(newBelongsToId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String originalVoucherId, int originalVoucherVersion) throws Exception {
		//deleteInternal(userContext, originalVoucherId, originalVoucherVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String originalVoucherId, int originalVoucherVersion) throws Exception{

		originalVoucherDaoOf(userContext).delete(originalVoucherId, originalVoucherVersion);
	}

	public OriginalVoucher forgetByAll(RetailscmUserContext userContext, String originalVoucherId, int originalVoucherVersion) throws Exception {
		return forgetByAllInternal(userContext, originalVoucherId, originalVoucherVersion);
	}
	protected OriginalVoucher forgetByAllInternal(RetailscmUserContext userContext,
			String originalVoucherId, int originalVoucherVersion) throws Exception{

		return originalVoucherDaoOf(userContext).disconnectFromAll(originalVoucherId, originalVoucherVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OriginalVoucherManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return originalVoucherDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, OriginalVoucher newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    originalVoucherDaoOf(ctx).loadAllAsStream().forEach(
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
		//   OriginalVoucher newOriginalVoucher = this.createOriginalVoucher(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newOriginalVoucher
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
    key.put(UserApp.APP_TYPE_PROPERTY, OriginalVoucher.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<OriginalVoucher> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<AccountingDocument> belongsToList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, AccountingDocument.class);
		userContext.getDAOGroup().enhanceList(belongsToList, AccountingDocument.class);


    }
	
	public Object listByBelongsTo(RetailscmUserContext userContext,String belongsToId) throws Exception {
		return listPageByBelongsTo(userContext, belongsToId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBelongsTo(RetailscmUserContext userContext,String belongsToId, int start, int count) throws Exception {
		SmartList<OriginalVoucher> list = originalVoucherDaoOf(userContext).findOriginalVoucherByBelongsTo(belongsToId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(OriginalVoucher.class);
		page.setContainerObject(AccountingDocument.withId(belongsToId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("原始凭证列表");
		page.setRequestName("listByBelongsTo");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBelongsTo/%s/",  getBeanName(), belongsToId)));

		page.assemblerContent(userContext, "listByBelongsTo");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String originalVoucherId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		OriginalVoucher merchantObj = (OriginalVoucher) this.view(userContext, originalVoucherId);
    String merchantObjId = originalVoucherId;
    String linkToUrl =	"originalVoucherManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "原始凭证"+"详情";
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
				MapUtil.put("id", "2-title")
				    .put("fieldName", "title")
				    .put("label", "头衔")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("title", merchantObj.getTitle());

		propList.add(
				MapUtil.put("id", "3-madeBy")
				    .put("fieldName", "madeBy")
				    .put("label", "由")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("madeBy", merchantObj.getMadeBy());

		propList.add(
				MapUtil.put("id", "4-receivedBy")
				    .put("fieldName", "receivedBy")
				    .put("label", "受")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("receivedBy", merchantObj.getReceivedBy());

		propList.add(
				MapUtil.put("id", "5-voucherType")
				    .put("fieldName", "voucherType")
				    .put("label", "凭证类型")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("voucherType", merchantObj.getVoucherType());

		propList.add(
				MapUtil.put("id", "6-voucherImage")
				    .put("fieldName", "voucherImage")
				    .put("label", "凭证图像")
				    .put("type", "image")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("voucherImage", merchantObj.getVoucherImage());

		propList.add(
				MapUtil.put("id", "7-belongsTo")
				    .put("fieldName", "belongsTo")
				    .put("label", "属于")
				    .put("type", "auto")
				    .put("linkToUrl", "accountingDocumentManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"accounting_document_date\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("belongsTo", merchantObj.getBelongsTo());

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




