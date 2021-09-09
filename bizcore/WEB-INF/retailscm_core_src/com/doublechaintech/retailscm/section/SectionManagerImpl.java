
package com.doublechaintech.retailscm.section;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.page.CandidatePage;import com.doublechaintech.retailscm.page.Page;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class SectionManagerImpl extends CustomRetailscmCheckerManager implements SectionManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "Section";
	@Override
	public SectionDAO daoOf(RetailscmUserContext userContext) {
		return sectionDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws SectionManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new SectionManagerException(message);

	}



 	protected Section saveSection(RetailscmUserContext userContext, Section section, String [] tokensExpr) throws Exception{
 		//return getSectionDAO().save(section, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveSection(userContext, section, tokens);
 	}

 	protected Section saveSectionDetail(RetailscmUserContext userContext, Section section) throws Exception{


 		return saveSection(userContext, section, allTokens());
 	}

 	public Section loadSection(RetailscmUserContext userContext, String sectionId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfSection(sectionId);

		checkerOf(userContext).throwExceptionIfHasErrors( SectionManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		Section section = loadSection( userContext, sectionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,section, tokens);
 	}


 	 public Section searchSection(RetailscmUserContext userContext, String sectionId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfSection(sectionId);

		checkerOf(userContext).throwExceptionIfHasErrors( SectionManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		Section section = loadSection( userContext, sectionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,section, tokens);
 	}



 	protected Section present(RetailscmUserContext userContext, Section section, Map<String, Object> tokens) throws Exception {


		addActions(userContext,section,tokens);
    

		Section  sectionToPresent = sectionDaoOf(userContext).present(section, tokens);

		List<BaseEntity> entityListToNaming = sectionToPresent.collectRefercencesFromLists();
		sectionDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,section,tokens);

		return  sectionToPresent;


	}



 	public Section loadSectionDetail(RetailscmUserContext userContext, String sectionId) throws Exception{
 		Section section = loadSection( userContext, sectionId, allTokens());
 		return present(userContext,section, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String sectionId) throws Exception{
 		Section section = loadSection( userContext, sectionId, viewTokens());
 		markVisited(userContext, section);
 		return present(userContext,section, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String sectionId) throws Exception{
		Section section = loadSection( userContext, sectionId, viewTokens());
		section.summarySuffix();
		markVisited(userContext, section);
 		return present(userContext,section, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String sectionId) throws Exception{
		Section section = loadSection( userContext, sectionId, analyzeTokens());
		markVisited(userContext, section);
		return present(userContext,section, analyzeTokens());

	}
 	protected Section saveSection(RetailscmUserContext userContext, Section section, Map<String,Object>tokens) throws Exception{
 	
 		return sectionDaoOf(userContext).save(section, tokens);
 	}
 	protected Section loadSection(RetailscmUserContext userContext, String sectionId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfSection(sectionId);

		checkerOf(userContext).throwExceptionIfHasErrors( SectionManagerException.class);



 		return sectionDaoOf(userContext).load(sectionId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Section section, Map<String, Object> tokens){
		super.addActions(userContext, section, tokens);

		addAction(userContext, section, tokens,"@create","createSection","createSection/","main","primary");
		addAction(userContext, section, tokens,"@update","updateSection","updateSection/"+section.getId()+"/","main","primary");
		addAction(userContext, section, tokens,"@copy","cloneSection","cloneSection/"+section.getId()+"/","main","primary");

		addAction(userContext, section, tokens,"section.transfer_to_page","transferToAnotherPage","transferToAnotherPage/"+section.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Section section, Map<String, Object> tokens){








  @Override
  public List<Section> searchSectionList(RetailscmUserContext ctx, SectionRequest pRequest){
      pRequest.setUserContext(ctx);
      List<Section> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public Section searchSection(RetailscmUserContext ctx, SectionRequest pRequest){
    pRequest.limit(0, 1);
    List<Section> list = searchSectionList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public Section createSection(RetailscmUserContext userContext, String title,String brief,String icon,int displayOrder,String viewGroup,String linkToUrl,String pageId) throws Exception
	{





		checkerOf(userContext).checkTitleOfSection(title);
		checkerOf(userContext).checkBriefOfSection(brief);
		checkerOf(userContext).checkIconOfSection(icon);
		checkerOf(userContext).checkDisplayOrderOfSection(displayOrder);
		checkerOf(userContext).checkViewGroupOfSection(viewGroup);
		checkerOf(userContext).checkLinkToUrlOfSection(linkToUrl);


		checkerOf(userContext).throwExceptionIfHasErrors(SectionManagerException.class);



		Section section=createNewSection();	

		section.setTitle(title);
		section.setBrief(brief);
		section.setIcon(icon);
		section.setDisplayOrder(displayOrder);
		section.setViewGroup(viewGroup);
		section.setLinkToUrl(linkToUrl);
			
		Page page = loadPage(userContext, pageId,emptyOptions());
		section.setPage(page);
		
		

		section = saveSection(userContext, section, emptyOptions());
		
		onNewInstanceCreated(userContext, section);
		return section;


	}
	protected Section createNewSection()
	{

		return new Section();
	}

	protected void checkParamsForUpdatingSection(RetailscmUserContext userContext,String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfSection(sectionId);
		checkerOf(userContext).checkVersionOfSection( sectionVersion);


		if(Section.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfSection(parseString(newValueExpr));
		

		}
		if(Section.BRIEF_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBriefOfSection(parseString(newValueExpr));
		

		}
		if(Section.ICON_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkIconOfSection(parseString(newValueExpr));
		

		}
		if(Section.DISPLAY_ORDER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDisplayOrderOfSection(parseInt(newValueExpr));
		

		}
		if(Section.VIEW_GROUP_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkViewGroupOfSection(parseString(newValueExpr));
		

		}
		if(Section.LINK_TO_URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLinkToUrlOfSection(parseString(newValueExpr));
		

		}

		


		checkerOf(userContext).throwExceptionIfHasErrors(SectionManagerException.class);



	}



	public Section clone(RetailscmUserContext userContext, String fromSectionId) throws Exception{

		return sectionDaoOf(userContext).clone(fromSectionId, this.allTokens());
	}

	public Section internalSaveSection(RetailscmUserContext userContext, Section section) throws Exception
	{
		return internalSaveSection(userContext, section, allTokens());

	}
	public Section internalSaveSection(RetailscmUserContext userContext, Section section, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingSection(userContext, sectionId, sectionVersion, property, newValueExpr, tokensExpr);


		synchronized(section){
			//will be good when the section loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Section.
			if (section.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixSection(section);
			section = saveSection(userContext, section, options);
			return section;

		}

	}

	public Section updateSection(RetailscmUserContext userContext,String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSection(userContext, sectionId, sectionVersion, property, newValueExpr, tokensExpr);



		Section section = loadSection(userContext, sectionId, allTokens());
		if(section.getVersion() != sectionVersion){
			String message = "The target version("+section.getVersion()+") is not equals to version("+sectionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(section){
			//will be good when the section loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Section.
			
			section.changeProperty(property, newValueExpr);
			section = saveSection(userContext, section, tokens().done());
			return present(userContext,section, mergedAllTokens(tokensExpr));
			//return saveSection(userContext, section, tokens().done());
		}

	}

	public Section updateSectionProperty(RetailscmUserContext userContext,String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSection(userContext, sectionId, sectionVersion, property, newValueExpr, tokensExpr);

		Section section = loadSection(userContext, sectionId, allTokens());
		if(section.getVersion() != sectionVersion){
			String message = "The target version("+section.getVersion()+") is not equals to version("+sectionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(section){
			//will be good when the section loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Section.

			section.changeProperty(property, newValueExpr);
			
			section = saveSection(userContext, section, tokens().done());
			return present(userContext,section, mergedAllTokens(tokensExpr));
			//return saveSection(userContext, section, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected SectionTokens tokens(){
		return SectionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SectionTokens.all();
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
		return SectionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPage(RetailscmUserContext userContext, String sectionId, String anotherPageId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSection(sectionId);
 		checkerOf(userContext).checkIdOfPage(anotherPageId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(SectionManagerException.class);

 	}
 	public Section transferToAnotherPage(RetailscmUserContext userContext, String sectionId, String anotherPageId) throws Exception
 	{
 		checkParamsForTransferingAnotherPage(userContext, sectionId,anotherPageId);
 
		Section section = loadSection(userContext, sectionId, allTokens());
		synchronized(section){
			//will be good when the section loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Page page = loadPage(userContext, anotherPageId, emptyOptions());
			section.updatePage(page);
			
			section = saveSection(userContext, section, emptyOptions());

			return present(userContext,section, allTokens());

		}

 	}

	


	public CandidatePage requestCandidatePage(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePage result = new CandidatePage();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("pageTitle");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Page> candidateList = pageDaoOf(userContext).requestCandidatePageForSection(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Page loadPage(RetailscmUserContext userContext, String newPageId, Map<String,Object> options) throws Exception
 	{
    
 		return pageDaoOf(userContext).load(newPageId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String sectionId, int sectionVersion) throws Exception {
		//deleteInternal(userContext, sectionId, sectionVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String sectionId, int sectionVersion) throws Exception{

		sectionDaoOf(userContext).delete(sectionId, sectionVersion);
	}

	public Section forgetByAll(RetailscmUserContext userContext, String sectionId, int sectionVersion) throws Exception {
		return forgetByAllInternal(userContext, sectionId, sectionVersion);
	}
	protected Section forgetByAllInternal(RetailscmUserContext userContext,
			String sectionId, int sectionVersion) throws Exception{

		return sectionDaoOf(userContext).disconnectFromAll(sectionId, sectionVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SectionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return sectionDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, Section newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    sectionDaoOf(ctx).loadAllAsStream().forEach(
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
		//   Section newSection = this.createSection(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSection
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
    key.put(UserApp.APP_TYPE_PROPERTY, Section.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<Section> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Page> pageList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Page.class);
		userContext.getDAOGroup().enhanceList(pageList, Page.class);


    }
	
	public Object listByPage(RetailscmUserContext userContext,String pageId) throws Exception {
		return listPageByPage(userContext, pageId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPage(RetailscmUserContext userContext,String pageId, int start, int count) throws Exception {
		SmartList<Section> list = sectionDaoOf(userContext).findSectionByPage(pageId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Section.class);
		page.setContainerObject(Page.withId(pageId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("板块列表");
		page.setRequestName("listByPage");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByPage/%s/",  getBeanName(), pageId)));

		page.assemblerContent(userContext, "listByPage");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String sectionId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		Section merchantObj = (Section) this.view(userContext, sectionId);
    String merchantObjId = sectionId;
    String linkToUrl =	"sectionManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "板块"+"详情";
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
				MapUtil.put("id", "3-brief")
				    .put("fieldName", "brief")
				    .put("label", "短暂的")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("brief", merchantObj.getBrief());

		propList.add(
				MapUtil.put("id", "4-icon")
				    .put("fieldName", "icon")
				    .put("label", "图标")
				    .put("type", "image")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("icon", merchantObj.getIcon());

		propList.add(
				MapUtil.put("id", "5-displayOrder")
				    .put("fieldName", "displayOrder")
				    .put("label", "顺序")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("displayOrder", merchantObj.getDisplayOrder());

		propList.add(
				MapUtil.put("id", "6-viewGroup")
				    .put("fieldName", "viewGroup")
				    .put("label", "视图组")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("viewGroup", merchantObj.getViewGroup());

		propList.add(
				MapUtil.put("id", "7-linkToUrl")
				    .put("fieldName", "linkToUrl")
				    .put("label", "链接网址")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("linkToUrl", merchantObj.getLinkToUrl());

		propList.add(
				MapUtil.put("id", "8-page")
				    .put("fieldName", "page")
				    .put("label", "页面")
				    .put("type", "auto")
				    .put("linkToUrl", "pageManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"display_order\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"page_title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("page", merchantObj.getPage());

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




