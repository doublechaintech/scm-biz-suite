
package com.doublechaintech.retailscm.stockcountissuetrack;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.goodsshelfstockcount.CandidateGoodsShelfStockCount;import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class StockCountIssueTrackManagerImpl extends CustomRetailscmCheckerManager implements StockCountIssueTrackManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "StockCountIssueTrack";
	@Override
	public StockCountIssueTrackDAO daoOf(RetailscmUserContext userContext) {
		return stockCountIssueTrackDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws StockCountIssueTrackManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new StockCountIssueTrackManagerException(message);

	}



 	protected StockCountIssueTrack saveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, String [] tokensExpr) throws Exception{
 		//return getStockCountIssueTrackDAO().save(stockCountIssueTrack, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens);
 	}

 	protected StockCountIssueTrack saveStockCountIssueTrackDetail(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack) throws Exception{


 		return saveStockCountIssueTrack(userContext, stockCountIssueTrack, allTokens());
 	}

 	public StockCountIssueTrack loadStockCountIssueTrack(RetailscmUserContext userContext, String stockCountIssueTrackId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);

		checkerOf(userContext).throwExceptionIfHasErrors( StockCountIssueTrackManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,stockCountIssueTrack, tokens);
 	}


 	 public StockCountIssueTrack searchStockCountIssueTrack(RetailscmUserContext userContext, String stockCountIssueTrackId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);

		checkerOf(userContext).throwExceptionIfHasErrors( StockCountIssueTrackManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,stockCountIssueTrack, tokens);
 	}



 	protected StockCountIssueTrack present(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String, Object> tokens) throws Exception {


		addActions(userContext,stockCountIssueTrack,tokens);
    

		StockCountIssueTrack  stockCountIssueTrackToPresent = stockCountIssueTrackDaoOf(userContext).present(stockCountIssueTrack, tokens);

		List<BaseEntity> entityListToNaming = stockCountIssueTrackToPresent.collectRefercencesFromLists();
		stockCountIssueTrackDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,stockCountIssueTrack,tokens);

		return  stockCountIssueTrackToPresent;


	}



 	public StockCountIssueTrack loadStockCountIssueTrackDetail(RetailscmUserContext userContext, String stockCountIssueTrackId) throws Exception{
 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, allTokens());
 		return present(userContext,stockCountIssueTrack, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String stockCountIssueTrackId) throws Exception{
 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, viewTokens());
 		markVisited(userContext, stockCountIssueTrack);
 		return present(userContext,stockCountIssueTrack, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String stockCountIssueTrackId) throws Exception{
		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, viewTokens());
		stockCountIssueTrack.summarySuffix();
		markVisited(userContext, stockCountIssueTrack);
 		return present(userContext,stockCountIssueTrack, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String stockCountIssueTrackId) throws Exception{
		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, analyzeTokens());
		markVisited(userContext, stockCountIssueTrack);
		return present(userContext,stockCountIssueTrack, analyzeTokens());

	}
 	protected StockCountIssueTrack saveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String,Object>tokens) throws Exception{
 	
 		return stockCountIssueTrackDaoOf(userContext).save(stockCountIssueTrack, tokens);
 	}
 	protected StockCountIssueTrack loadStockCountIssueTrack(RetailscmUserContext userContext, String stockCountIssueTrackId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);

		checkerOf(userContext).throwExceptionIfHasErrors( StockCountIssueTrackManagerException.class);



 		return stockCountIssueTrackDaoOf(userContext).load(stockCountIssueTrackId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String, Object> tokens){
		super.addActions(userContext, stockCountIssueTrack, tokens);

		addAction(userContext, stockCountIssueTrack, tokens,"@create","createStockCountIssueTrack","createStockCountIssueTrack/","main","primary");
		addAction(userContext, stockCountIssueTrack, tokens,"@update","updateStockCountIssueTrack","updateStockCountIssueTrack/"+stockCountIssueTrack.getId()+"/","main","primary");
		addAction(userContext, stockCountIssueTrack, tokens,"@copy","cloneStockCountIssueTrack","cloneStockCountIssueTrack/"+stockCountIssueTrack.getId()+"/","main","primary");

		addAction(userContext, stockCountIssueTrack, tokens,"stock_count_issue_track.transfer_to_stock_count","transferToAnotherStockCount","transferToAnotherStockCount/"+stockCountIssueTrack.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String, Object> tokens){








  @Override
  public List<StockCountIssueTrack> searchStockCountIssueTrackList(RetailscmUserContext ctx, StockCountIssueTrackRequest pRequest){
      pRequest.setUserContext(ctx);
      List<StockCountIssueTrack> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public StockCountIssueTrack searchStockCountIssueTrack(RetailscmUserContext ctx, StockCountIssueTrackRequest pRequest){
    pRequest.limit(0, 1);
    List<StockCountIssueTrack> list = searchStockCountIssueTrackList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public StockCountIssueTrack createStockCountIssueTrack(RetailscmUserContext userContext, String title,Date countTime,String summary,String stockCountId) throws Exception
	{





		checkerOf(userContext).checkTitleOfStockCountIssueTrack(title);
		checkerOf(userContext).checkCountTimeOfStockCountIssueTrack(countTime);
		checkerOf(userContext).checkSummaryOfStockCountIssueTrack(summary);


		checkerOf(userContext).throwExceptionIfHasErrors(StockCountIssueTrackManagerException.class);



		StockCountIssueTrack stockCountIssueTrack=createNewStockCountIssueTrack();	

		stockCountIssueTrack.setTitle(title);
		stockCountIssueTrack.setCountTime(countTime);
		stockCountIssueTrack.setSummary(summary);
			
		GoodsShelfStockCount stockCount = loadGoodsShelfStockCount(userContext, stockCountId,emptyOptions());
		stockCountIssueTrack.setStockCount(stockCount);
		
		

		stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, emptyOptions());
		
		onNewInstanceCreated(userContext, stockCountIssueTrack);
		return stockCountIssueTrack;


	}
	protected StockCountIssueTrack createNewStockCountIssueTrack()
	{

		return new StockCountIssueTrack();
	}

	protected void checkParamsForUpdatingStockCountIssueTrack(RetailscmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
		checkerOf(userContext).checkVersionOfStockCountIssueTrack( stockCountIssueTrackVersion);


		if(StockCountIssueTrack.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfStockCountIssueTrack(parseString(newValueExpr));
		

		}
		if(StockCountIssueTrack.COUNT_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCountTimeOfStockCountIssueTrack(parseDate(newValueExpr));
		

		}
		if(StockCountIssueTrack.SUMMARY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSummaryOfStockCountIssueTrack(parseString(newValueExpr));
		

		}

		


		checkerOf(userContext).throwExceptionIfHasErrors(StockCountIssueTrackManagerException.class);



	}



	public StockCountIssueTrack clone(RetailscmUserContext userContext, String fromStockCountIssueTrackId) throws Exception{

		return stockCountIssueTrackDaoOf(userContext).clone(fromStockCountIssueTrackId, this.allTokens());
	}

	public StockCountIssueTrack internalSaveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack) throws Exception
	{
		return internalSaveStockCountIssueTrack(userContext, stockCountIssueTrack, allTokens());

	}
	public StockCountIssueTrack internalSaveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingStockCountIssueTrack(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion, property, newValueExpr, tokensExpr);


		synchronized(stockCountIssueTrack){
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StockCountIssueTrack.
			if (stockCountIssueTrack.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixStockCountIssueTrack(stockCountIssueTrack);
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, options);
			return stockCountIssueTrack;

		}

	}

	public StockCountIssueTrack updateStockCountIssueTrack(RetailscmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingStockCountIssueTrack(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion, property, newValueExpr, tokensExpr);



		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack(userContext, stockCountIssueTrackId, allTokens());
		if(stockCountIssueTrack.getVersion() != stockCountIssueTrackVersion){
			String message = "The target version("+stockCountIssueTrack.getVersion()+") is not equals to version("+stockCountIssueTrackVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(stockCountIssueTrack){
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StockCountIssueTrack.
			
			stockCountIssueTrack.changeProperty(property, newValueExpr);
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
			return present(userContext,stockCountIssueTrack, mergedAllTokens(tokensExpr));
			//return saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
		}

	}

	public StockCountIssueTrack updateStockCountIssueTrackProperty(RetailscmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingStockCountIssueTrack(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion, property, newValueExpr, tokensExpr);

		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack(userContext, stockCountIssueTrackId, allTokens());
		if(stockCountIssueTrack.getVersion() != stockCountIssueTrackVersion){
			String message = "The target version("+stockCountIssueTrack.getVersion()+") is not equals to version("+stockCountIssueTrackVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(stockCountIssueTrack){
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StockCountIssueTrack.

			stockCountIssueTrack.changeProperty(property, newValueExpr);
			
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
			return present(userContext,stockCountIssueTrack, mergedAllTokens(tokensExpr));
			//return saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected StockCountIssueTrackTokens tokens(){
		return StockCountIssueTrackTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return StockCountIssueTrackTokens.all();
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
		return StockCountIssueTrackTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherStockCount(RetailscmUserContext userContext, String stockCountIssueTrackId, String anotherStockCountId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
 		checkerOf(userContext).checkIdOfGoodsShelfStockCount(anotherStockCountId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(StockCountIssueTrackManagerException.class);

 	}
 	public StockCountIssueTrack transferToAnotherStockCount(RetailscmUserContext userContext, String stockCountIssueTrackId, String anotherStockCountId) throws Exception
 	{
 		checkParamsForTransferingAnotherStockCount(userContext, stockCountIssueTrackId,anotherStockCountId);
 
		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack(userContext, stockCountIssueTrackId, allTokens());
		synchronized(stockCountIssueTrack){
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsShelfStockCount stockCount = loadGoodsShelfStockCount(userContext, anotherStockCountId, emptyOptions());
			stockCountIssueTrack.updateStockCount(stockCount);
			
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, emptyOptions());

			return present(userContext,stockCountIssueTrack, allTokens());

		}

 	}

	


	public CandidateGoodsShelfStockCount requestCandidateStockCount(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGoodsShelfStockCount result = new CandidateGoodsShelfStockCount();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GoodsShelfStockCount> candidateList = goodsShelfStockCountDaoOf(userContext).requestCandidateGoodsShelfStockCountForStockCountIssueTrack(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected GoodsShelfStockCount loadGoodsShelfStockCount(RetailscmUserContext userContext, String newStockCountId, Map<String,Object> options) throws Exception
 	{
    
 		return goodsShelfStockCountDaoOf(userContext).load(newStockCountId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception {
		//deleteInternal(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception{

		stockCountIssueTrackDaoOf(userContext).delete(stockCountIssueTrackId, stockCountIssueTrackVersion);
	}

	public StockCountIssueTrack forgetByAll(RetailscmUserContext userContext, String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception {
		return forgetByAllInternal(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion);
	}
	protected StockCountIssueTrack forgetByAllInternal(RetailscmUserContext userContext,
			String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception{

		return stockCountIssueTrackDaoOf(userContext).disconnectFromAll(stockCountIssueTrackId, stockCountIssueTrackVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new StockCountIssueTrackManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return stockCountIssueTrackDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, StockCountIssueTrack newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    stockCountIssueTrackDaoOf(ctx).loadAllAsStream().forEach(
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
		//   StockCountIssueTrack newStockCountIssueTrack = this.createStockCountIssueTrack(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newStockCountIssueTrack
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
    key.put(UserApp.APP_TYPE_PROPERTY, StockCountIssueTrack.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<StockCountIssueTrack> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<GoodsShelfStockCount> stockCountList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, GoodsShelfStockCount.class);
		userContext.getDAOGroup().enhanceList(stockCountList, GoodsShelfStockCount.class);


    }
	
	public Object listByStockCount(RetailscmUserContext userContext,String stockCountId) throws Exception {
		return listPageByStockCount(userContext, stockCountId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByStockCount(RetailscmUserContext userContext,String stockCountId, int start, int count) throws Exception {
		SmartList<StockCountIssueTrack> list = stockCountIssueTrackDaoOf(userContext).findStockCountIssueTrackByStockCount(stockCountId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(StockCountIssueTrack.class);
		page.setContainerObject(GoodsShelfStockCount.withId(stockCountId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("库存计数问题跟踪列表");
		page.setRequestName("listByStockCount");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByStockCount/%s/",  getBeanName(), stockCountId)));

		page.assemblerContent(userContext, "listByStockCount");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String stockCountIssueTrackId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		StockCountIssueTrack merchantObj = (StockCountIssueTrack) this.view(userContext, stockCountIssueTrackId);
    String merchantObjId = stockCountIssueTrackId;
    String linkToUrl =	"stockCountIssueTrackManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "库存计数问题跟踪"+"详情";
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
				MapUtil.put("id", "3-countTime")
				    .put("fieldName", "countTime")
				    .put("label", "计数时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("countTime", merchantObj.getCountTime());

		propList.add(
				MapUtil.put("id", "4-summary")
				    .put("fieldName", "summary")
				    .put("label", "概览")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("summary", merchantObj.getSummary());

		propList.add(
				MapUtil.put("id", "5-stockCount")
				    .put("fieldName", "stockCount")
				    .put("label", "盘点")
				    .put("type", "auto")
				    .put("linkToUrl", "goodsShelfStockCountManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"summary\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("stockCount", merchantObj.getStockCount());

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




