
package com.doublechaintech.retailscm.page;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.retailscm.slide.Slide;
import com.doublechaintech.retailscm.section.Section;
import com.doublechaintech.retailscm.uiaction.UiAction;
import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.pagetype.PageType;

import com.doublechaintech.retailscm.mobileapp.CandidateMobileApp;
import com.doublechaintech.retailscm.pagetype.CandidatePageType;

import com.doublechaintech.retailscm.page.Page;






public class PageManagerImpl extends CustomRetailscmCheckerManager implements PageManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = PageTokens.start().withTokenFromListName(listName).done();
		Page  page = (Page) this.loadPage(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = page.collectRefercencesFromLists();
		pageDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, page, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new PageGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "Page";
	@Override
	public PageDAO daoOf(RetailscmUserContext userContext) {
		return pageDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws PageManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new PageManagerException(message);

	}



 	protected Page savePage(RetailscmUserContext userContext, Page page, String [] tokensExpr) throws Exception{	
 		//return getPageDAO().save(page, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePage(userContext, page, tokens);
 	}
 	
 	protected Page savePageDetail(RetailscmUserContext userContext, Page page) throws Exception{	

 		
 		return savePage(userContext, page, allTokens());
 	}
 	
 	public Page loadPage(RetailscmUserContext userContext, String pageId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).throwExceptionIfHasErrors( PageManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Page page = loadPage( userContext, pageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,page, tokens);
 	}
 	
 	
 	 public Page searchPage(RetailscmUserContext userContext, String pageId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).throwExceptionIfHasErrors( PageManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Page page = loadPage( userContext, pageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,page, tokens);
 	}
 	
 	

 	protected Page present(RetailscmUserContext userContext, Page page, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,page,tokens);
		
		
		Page  pageToPresent = pageDaoOf(userContext).present(page, tokens);
		
		List<BaseEntity> entityListToNaming = pageToPresent.collectRefercencesFromLists();
		pageDaoOf(userContext).alias(entityListToNaming);
		
		return  pageToPresent;
		
		
	}
 
 	
 	
 	public Page loadPageDetail(RetailscmUserContext userContext, String pageId) throws Exception{	
 		Page page = loadPage( userContext, pageId, allTokens());
 		return present(userContext,page, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String pageId) throws Exception{	
 		Page page = loadPage( userContext, pageId, viewTokens());
 		return present(userContext,page, allTokens());
		
 	}
 	protected Page savePage(RetailscmUserContext userContext, Page page, Map<String,Object>tokens) throws Exception{	
 		return pageDaoOf(userContext).save(page, tokens);
 	}
 	protected Page loadPage(RetailscmUserContext userContext, String pageId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).throwExceptionIfHasErrors( PageManagerException.class);

 
 		return pageDaoOf(userContext).load(pageId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Page page, Map<String, Object> tokens){
		super.addActions(userContext, page, tokens);
		
		addAction(userContext, page, tokens,"@create","createPage","createPage/","main","primary");
		addAction(userContext, page, tokens,"@update","updatePage","updatePage/"+page.getId()+"/","main","primary");
		addAction(userContext, page, tokens,"@copy","clonePage","clonePage/"+page.getId()+"/","main","primary");
		
		addAction(userContext, page, tokens,"page.transfer_to_page_type","transferToAnotherPageType","transferToAnotherPageType/"+page.getId()+"/","main","primary");
		addAction(userContext, page, tokens,"page.transfer_to_mobile_app","transferToAnotherMobileApp","transferToAnotherMobileApp/"+page.getId()+"/","main","primary");
		addAction(userContext, page, tokens,"page.addSlide","addSlide","addSlide/"+page.getId()+"/","slideList","primary");
		addAction(userContext, page, tokens,"page.removeSlide","removeSlide","removeSlide/"+page.getId()+"/","slideList","primary");
		addAction(userContext, page, tokens,"page.updateSlide","updateSlide","updateSlide/"+page.getId()+"/","slideList","primary");
		addAction(userContext, page, tokens,"page.copySlideFrom","copySlideFrom","copySlideFrom/"+page.getId()+"/","slideList","primary");
		addAction(userContext, page, tokens,"page.addUiAction","addUiAction","addUiAction/"+page.getId()+"/","uiActionList","primary");
		addAction(userContext, page, tokens,"page.removeUiAction","removeUiAction","removeUiAction/"+page.getId()+"/","uiActionList","primary");
		addAction(userContext, page, tokens,"page.updateUiAction","updateUiAction","updateUiAction/"+page.getId()+"/","uiActionList","primary");
		addAction(userContext, page, tokens,"page.copyUiActionFrom","copyUiActionFrom","copyUiActionFrom/"+page.getId()+"/","uiActionList","primary");
		addAction(userContext, page, tokens,"page.addSection","addSection","addSection/"+page.getId()+"/","sectionList","primary");
		addAction(userContext, page, tokens,"page.removeSection","removeSection","removeSection/"+page.getId()+"/","sectionList","primary");
		addAction(userContext, page, tokens,"page.updateSection","updateSection","updateSection/"+page.getId()+"/","sectionList","primary");
		addAction(userContext, page, tokens,"page.copySectionFrom","copySectionFrom","copySectionFrom/"+page.getId()+"/","sectionList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Page page, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Page createPage(RetailscmUserContext userContext, String pageTitle,String linkToUrl,String pageTypeId,int displayOrder,String mobileAppId) throws Exception
	//public Page createPage(RetailscmUserContext userContext,String pageTitle, String linkToUrl, String pageTypeId, int displayOrder, String mobileAppId) throws Exception
	{

		

		

		checkerOf(userContext).checkPageTitleOfPage(pageTitle);
		checkerOf(userContext).checkLinkToUrlOfPage(linkToUrl);
		checkerOf(userContext).checkDisplayOrderOfPage(displayOrder);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);


		Page page=createNewPage();	

		page.setPageTitle(pageTitle);
		page.setLinkToUrl(linkToUrl);
			
		PageType pageType = loadPageType(userContext, pageTypeId,emptyOptions());
		page.setPageType(pageType);
		
		
		page.setDisplayOrder(displayOrder);
			
		MobileApp mobileApp = loadMobileApp(userContext, mobileAppId,emptyOptions());
		page.setMobileApp(mobileApp);
		
		

		page = savePage(userContext, page, emptyOptions());
		
		onNewInstanceCreated(userContext, page);
		return page;


	}
	protected Page createNewPage()
	{

		return new Page();
	}

	protected void checkParamsForUpdatingPage(RetailscmUserContext userContext,String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkVersionOfPage( pageVersion);
		

		if(Page.PAGE_TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPageTitleOfPage(parseString(newValueExpr));
		
			
		}
		if(Page.LINK_TO_URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLinkToUrlOfPage(parseString(newValueExpr));
		
			
		}		

		
		if(Page.DISPLAY_ORDER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDisplayOrderOfPage(parseInt(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);


	}



	public Page clone(RetailscmUserContext userContext, String fromPageId) throws Exception{

		return pageDaoOf(userContext).clone(fromPageId, this.allTokens());
	}

	public Page internalSavePage(RetailscmUserContext userContext, Page page) throws Exception
	{
		return internalSavePage(userContext, page, allTokens());

	}
	public Page internalSavePage(RetailscmUserContext userContext, Page page, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingPage(userContext, pageId, pageVersion, property, newValueExpr, tokensExpr);


		synchronized(page){
			//will be good when the page loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Page.
			if (page.isChanged()){
			
			}
			page = savePage(userContext, page, options);
			return page;

		}

	}

	public Page updatePage(RetailscmUserContext userContext,String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPage(userContext, pageId, pageVersion, property, newValueExpr, tokensExpr);



		Page page = loadPage(userContext, pageId, allTokens());
		if(page.getVersion() != pageVersion){
			String message = "The target version("+page.getVersion()+") is not equals to version("+pageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(page){
			//will be good when the page loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Page.
			
			page.changeProperty(property, newValueExpr);
			page = savePage(userContext, page, tokens().done());
			return present(userContext,page, mergedAllTokens(tokensExpr));
			//return savePage(userContext, page, tokens().done());
		}

	}

	public Page updatePageProperty(RetailscmUserContext userContext,String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPage(userContext, pageId, pageVersion, property, newValueExpr, tokensExpr);

		Page page = loadPage(userContext, pageId, allTokens());
		if(page.getVersion() != pageVersion){
			String message = "The target version("+page.getVersion()+") is not equals to version("+pageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(page){
			//will be good when the page loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Page.

			page.changeProperty(property, newValueExpr);
			
			page = savePage(userContext, page, tokens().done());
			return present(userContext,page, mergedAllTokens(tokensExpr));
			//return savePage(userContext, page, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected PageTokens tokens(){
		return PageTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PageTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortSlideListWith("id","desc")
		.sortUiActionListWith("id","desc")
		.sortSectionListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PageTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPageType(RetailscmUserContext userContext, String pageId, String anotherPageTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfPage(pageId);
 		checkerOf(userContext).checkIdOfPageType(anotherPageTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

 	}
 	public Page transferToAnotherPageType(RetailscmUserContext userContext, String pageId, String anotherPageTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherPageType(userContext, pageId,anotherPageTypeId);
 
		Page page = loadPage(userContext, pageId, allTokens());	
		synchronized(page){
			//will be good when the page loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PageType pageType = loadPageType(userContext, anotherPageTypeId, emptyOptions());		
			page.updatePageType(pageType);		
			page = savePage(userContext, page, emptyOptions());
			
			return present(userContext,page, allTokens());
			
		}

 	}

	

	protected void checkParamsForTransferingAnotherPageTypeWithCode(RetailscmUserContext userContext, String pageId, String anotherCode) throws Exception
 	{

 		checkerOf(userContext).checkIdOfPage(pageId);
 		checkerOf(userContext).checkCodeOfPageType( anotherCode);
 		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

 	}

 	public Page transferToAnotherPageTypeWithCode(RetailscmUserContext userContext, String pageId, String anotherCode) throws Exception
 	{
 		checkParamsForTransferingAnotherPageTypeWithCode(userContext, pageId,anotherCode);
 		Page page = loadPage(userContext, pageId, allTokens());
		synchronized(page){
			//will be good when the page loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			PageType pageType = loadPageTypeWithCode(userContext, anotherCode, emptyOptions());
			page.updatePageType(pageType);
			page = savePage(userContext, page, emptyOptions());

			return present(userContext,page, allTokens());

		}
 	}

	 


	public CandidatePageType requestCandidatePageType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePageType result = new CandidatePageType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<PageType> candidateList = pageTypeDaoOf(userContext).requestCandidatePageTypeForPage(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherMobileApp(RetailscmUserContext userContext, String pageId, String anotherMobileAppId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfPage(pageId);
 		checkerOf(userContext).checkIdOfMobileApp(anotherMobileAppId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

 	}
 	public Page transferToAnotherMobileApp(RetailscmUserContext userContext, String pageId, String anotherMobileAppId) throws Exception
 	{
 		checkParamsForTransferingAnotherMobileApp(userContext, pageId,anotherMobileAppId);
 
		Page page = loadPage(userContext, pageId, allTokens());	
		synchronized(page){
			//will be good when the page loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			MobileApp mobileApp = loadMobileApp(userContext, anotherMobileAppId, emptyOptions());		
			page.updateMobileApp(mobileApp);		
			page = savePage(userContext, page, emptyOptions());
			
			return present(userContext,page, allTokens());
			
		}

 	}

	


	public CandidateMobileApp requestCandidateMobileApp(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateMobileApp result = new CandidateMobileApp();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<MobileApp> candidateList = mobileAppDaoOf(userContext).requestCandidateMobileAppForPage(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected PageType loadPageType(RetailscmUserContext userContext, String newPageTypeId, Map<String,Object> options) throws Exception
 	{

 		return pageTypeDaoOf(userContext).load(newPageTypeId, options);
 	}
 	
 	protected PageType loadPageTypeWithCode(RetailscmUserContext userContext, String newCode, Map<String,Object> options) throws Exception
 	{

 		return pageTypeDaoOf(userContext).loadByCode(newCode, options);
 	}

 	


	

 	protected MobileApp loadMobileApp(RetailscmUserContext userContext, String newMobileAppId, Map<String,Object> options) throws Exception
 	{

 		return mobileAppDaoOf(userContext).load(newMobileAppId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String pageId, int pageVersion) throws Exception {
		//deleteInternal(userContext, pageId, pageVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String pageId, int pageVersion) throws Exception{

		pageDaoOf(userContext).delete(pageId, pageVersion);
	}

	public Page forgetByAll(RetailscmUserContext userContext, String pageId, int pageVersion) throws Exception {
		return forgetByAllInternal(userContext, pageId, pageVersion);
	}
	protected Page forgetByAllInternal(RetailscmUserContext userContext,
			String pageId, int pageVersion) throws Exception{

		return pageDaoOf(userContext).disconnectFromAll(pageId, pageVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PageManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return pageDaoOf(userContext).deleteAll();
	}








	protected void checkParamsForAddingSlide(RetailscmUserContext userContext, String pageId, String name, int displayOrder, String imageUrl, String videoUrl, String linkToUrl,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPage(pageId);

		
		checkerOf(userContext).checkNameOfSlide(name);
		
		checkerOf(userContext).checkDisplayOrderOfSlide(displayOrder);
		
		checkerOf(userContext).checkImageUrlOfSlide(imageUrl);
		
		checkerOf(userContext).checkVideoUrlOfSlide(videoUrl);
		
		checkerOf(userContext).checkLinkToUrlOfSlide(linkToUrl);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);


	}
	public  Page addSlide(RetailscmUserContext userContext, String pageId, String name, int displayOrder, String imageUrl, String videoUrl, String linkToUrl, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSlide(userContext,pageId,name, displayOrder, imageUrl, videoUrl, linkToUrl,tokensExpr);

		Slide slide = createSlide(userContext,name, displayOrder, imageUrl, videoUrl, linkToUrl);

		Page page = loadPage(userContext, pageId, emptyOptions());
		synchronized(page){
			//Will be good when the page loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			page.addSlide( slide );
			page = savePage(userContext, page, tokens().withSlideList().done());
			
			userContext.getManagerGroup().getSlideManager().onNewInstanceCreated(userContext, slide);
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSlideProperties(RetailscmUserContext userContext, String pageId,String id,String name,int displayOrder,String imageUrl,String videoUrl,String linkToUrl,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkIdOfSlide(id);

		checkerOf(userContext).checkNameOfSlide( name);
		checkerOf(userContext).checkDisplayOrderOfSlide( displayOrder);
		checkerOf(userContext).checkImageUrlOfSlide( imageUrl);
		checkerOf(userContext).checkVideoUrlOfSlide( videoUrl);
		checkerOf(userContext).checkLinkToUrlOfSlide( linkToUrl);

		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}
	public  Page updateSlideProperties(RetailscmUserContext userContext, String pageId, String id,String name,int displayOrder,String imageUrl,String videoUrl,String linkToUrl, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSlideProperties(userContext,pageId,id,name,displayOrder,imageUrl,videoUrl,linkToUrl,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSlideListList()
				.searchSlideListWith(Slide.ID_PROPERTY, "is", id).done();

		Page pageToUpdate = loadPage(userContext, pageId, options);

		if(pageToUpdate.getSlideList().isEmpty()){
			throw new PageManagerException("Slide is NOT FOUND with id: '"+id+"'");
		}

		Slide item = pageToUpdate.getSlideList().first();

		item.updateName( name );
		item.updateDisplayOrder( displayOrder );
		item.updateImageUrl( imageUrl );
		item.updateVideoUrl( videoUrl );
		item.updateLinkToUrl( linkToUrl );


		//checkParamsForAddingSlide(userContext,pageId,name, code, used,tokensExpr);
		Page page = savePage(userContext, pageToUpdate, tokens().withSlideList().done());
		synchronized(page){
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}
	}


	protected Slide createSlide(RetailscmUserContext userContext, String name, int displayOrder, String imageUrl, String videoUrl, String linkToUrl) throws Exception{

		Slide slide = new Slide();
		
		
		slide.setName(name);		
		slide.setDisplayOrder(displayOrder);		
		slide.setImageUrl(imageUrl);		
		slide.setVideoUrl(videoUrl);		
		slide.setLinkToUrl(linkToUrl);
	
		
		return slide;


	}

	protected Slide createIndexedSlide(String id, int version){

		Slide slide = new Slide();
		slide.setId(id);
		slide.setVersion(version);
		return slide;

	}

	protected void checkParamsForRemovingSlideList(RetailscmUserContext userContext, String pageId,
			String slideIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPage(pageId);
		for(String slideIdItem: slideIds){
			checkerOf(userContext).checkIdOfSlide(slideIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}
	public  Page removeSlideList(RetailscmUserContext userContext, String pageId,
			String slideIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSlideList(userContext, pageId,  slideIds, tokensExpr);


			Page page = loadPage(userContext, pageId, allTokens());
			synchronized(page){
				//Will be good when the page loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				pageDaoOf(userContext).planToRemoveSlideList(page, slideIds, allTokens());
				page = savePage(userContext, page, tokens().withSlideList().done());
				deleteRelationListInGraph(userContext, page.getSlideList());
				return present(userContext,page, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSlide(RetailscmUserContext userContext, String pageId,
		String slideId, int slideVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPage( pageId);
		checkerOf(userContext).checkIdOfSlide(slideId);
		checkerOf(userContext).checkVersionOfSlide(slideVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}
	public  Page removeSlide(RetailscmUserContext userContext, String pageId,
		String slideId, int slideVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSlide(userContext,pageId, slideId, slideVersion,tokensExpr);

		Slide slide = createIndexedSlide(slideId, slideVersion);
		Page page = loadPage(userContext, pageId, allTokens());
		synchronized(page){
			//Will be good when the page loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			page.removeSlide( slide );
			page = savePage(userContext, page, tokens().withSlideList().done());
			deleteRelationInGraph(userContext, slide);
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSlide(RetailscmUserContext userContext, String pageId,
		String slideId, int slideVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPage( pageId);
		checkerOf(userContext).checkIdOfSlide(slideId);
		checkerOf(userContext).checkVersionOfSlide(slideVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}
	public  Page copySlideFrom(RetailscmUserContext userContext, String pageId,
		String slideId, int slideVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSlide(userContext,pageId, slideId, slideVersion,tokensExpr);

		Slide slide = createIndexedSlide(slideId, slideVersion);
		Page page = loadPage(userContext, pageId, allTokens());
		synchronized(page){
			//Will be good when the page loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			page.copySlideFrom( slide );
			page = savePage(userContext, page, tokens().withSlideList().done());
			
			userContext.getManagerGroup().getSlideManager().onNewInstanceCreated(userContext, (Slide)page.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSlide(RetailscmUserContext userContext, String pageId, String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkIdOfSlide(slideId);
		checkerOf(userContext).checkVersionOfSlide(slideVersion);
		

		if(Slide.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfSlide(parseString(newValueExpr));
		
		}
		
		if(Slide.DISPLAY_ORDER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDisplayOrderOfSlide(parseInt(newValueExpr));
		
		}
		
		if(Slide.IMAGE_URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkImageUrlOfSlide(parseString(newValueExpr));
		
		}
		
		if(Slide.VIDEO_URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkVideoUrlOfSlide(parseString(newValueExpr));
		
		}
		
		if(Slide.LINK_TO_URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLinkToUrlOfSlide(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}

	public  Page updateSlide(RetailscmUserContext userContext, String pageId, String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSlide(userContext, pageId, slideId, slideVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSlideList().searchSlideListWith(Slide.ID_PROPERTY, "eq", slideId).done();



		Page page = loadPage(userContext, pageId, loadTokens);

		synchronized(page){
			//Will be good when the page loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//page.removeSlide( slide );
			//make changes to AcceleraterAccount.
			Slide slideIndex = createIndexedSlide(slideId, slideVersion);

			Slide slide = page.findTheSlide(slideIndex);
			if(slide == null){
				throw new PageManagerException(slide+" is NOT FOUND" );
			}

			slide.changeProperty(property, newValueExpr);
			
			page = savePage(userContext, page, tokens().withSlideList().done());
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingUiAction(RetailscmUserContext userContext, String pageId, String code, String icon, String title, int displayOrder, String brief, String imageUrl, String linkToUrl, String extraData,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPage(pageId);

		
		checkerOf(userContext).checkCodeOfUiAction(code);
		
		checkerOf(userContext).checkIconOfUiAction(icon);
		
		checkerOf(userContext).checkTitleOfUiAction(title);
		
		checkerOf(userContext).checkDisplayOrderOfUiAction(displayOrder);
		
		checkerOf(userContext).checkBriefOfUiAction(brief);
		
		checkerOf(userContext).checkImageUrlOfUiAction(imageUrl);
		
		checkerOf(userContext).checkLinkToUrlOfUiAction(linkToUrl);
		
		checkerOf(userContext).checkExtraDataOfUiAction(extraData);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);


	}
	public  Page addUiAction(RetailscmUserContext userContext, String pageId, String code, String icon, String title, int displayOrder, String brief, String imageUrl, String linkToUrl, String extraData, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingUiAction(userContext,pageId,code, icon, title, displayOrder, brief, imageUrl, linkToUrl, extraData,tokensExpr);

		UiAction uiAction = createUiAction(userContext,code, icon, title, displayOrder, brief, imageUrl, linkToUrl, extraData);

		Page page = loadPage(userContext, pageId, emptyOptions());
		synchronized(page){
			//Will be good when the page loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			page.addUiAction( uiAction );
			page = savePage(userContext, page, tokens().withUiActionList().done());
			
			userContext.getManagerGroup().getUiActionManager().onNewInstanceCreated(userContext, uiAction);
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUiActionProperties(RetailscmUserContext userContext, String pageId,String id,String code,String icon,String title,int displayOrder,String brief,String imageUrl,String linkToUrl,String extraData,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkIdOfUiAction(id);

		checkerOf(userContext).checkCodeOfUiAction( code);
		checkerOf(userContext).checkIconOfUiAction( icon);
		checkerOf(userContext).checkTitleOfUiAction( title);
		checkerOf(userContext).checkDisplayOrderOfUiAction( displayOrder);
		checkerOf(userContext).checkBriefOfUiAction( brief);
		checkerOf(userContext).checkImageUrlOfUiAction( imageUrl);
		checkerOf(userContext).checkLinkToUrlOfUiAction( linkToUrl);
		checkerOf(userContext).checkExtraDataOfUiAction( extraData);

		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}
	public  Page updateUiActionProperties(RetailscmUserContext userContext, String pageId, String id,String code,String icon,String title,int displayOrder,String brief,String imageUrl,String linkToUrl,String extraData, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUiActionProperties(userContext,pageId,id,code,icon,title,displayOrder,brief,imageUrl,linkToUrl,extraData,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUiActionListList()
				.searchUiActionListWith(UiAction.ID_PROPERTY, "is", id).done();

		Page pageToUpdate = loadPage(userContext, pageId, options);

		if(pageToUpdate.getUiActionList().isEmpty()){
			throw new PageManagerException("UiAction is NOT FOUND with id: '"+id+"'");
		}

		UiAction item = pageToUpdate.getUiActionList().first();

		item.updateCode( code );
		item.updateIcon( icon );
		item.updateTitle( title );
		item.updateDisplayOrder( displayOrder );
		item.updateBrief( brief );
		item.updateImageUrl( imageUrl );
		item.updateLinkToUrl( linkToUrl );
		item.updateExtraData( extraData );


		//checkParamsForAddingUiAction(userContext,pageId,name, code, used,tokensExpr);
		Page page = savePage(userContext, pageToUpdate, tokens().withUiActionList().done());
		synchronized(page){
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}
	}


	protected UiAction createUiAction(RetailscmUserContext userContext, String code, String icon, String title, int displayOrder, String brief, String imageUrl, String linkToUrl, String extraData) throws Exception{

		UiAction uiAction = new UiAction();
		
		
		uiAction.setCode(code);		
		uiAction.setIcon(icon);		
		uiAction.setTitle(title);		
		uiAction.setDisplayOrder(displayOrder);		
		uiAction.setBrief(brief);		
		uiAction.setImageUrl(imageUrl);		
		uiAction.setLinkToUrl(linkToUrl);		
		uiAction.setExtraData(extraData);
	
		
		return uiAction;


	}

	protected UiAction createIndexedUiAction(String id, int version){

		UiAction uiAction = new UiAction();
		uiAction.setId(id);
		uiAction.setVersion(version);
		return uiAction;

	}

	protected void checkParamsForRemovingUiActionList(RetailscmUserContext userContext, String pageId,
			String uiActionIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPage(pageId);
		for(String uiActionIdItem: uiActionIds){
			checkerOf(userContext).checkIdOfUiAction(uiActionIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}
	public  Page removeUiActionList(RetailscmUserContext userContext, String pageId,
			String uiActionIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingUiActionList(userContext, pageId,  uiActionIds, tokensExpr);


			Page page = loadPage(userContext, pageId, allTokens());
			synchronized(page){
				//Will be good when the page loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				pageDaoOf(userContext).planToRemoveUiActionList(page, uiActionIds, allTokens());
				page = savePage(userContext, page, tokens().withUiActionList().done());
				deleteRelationListInGraph(userContext, page.getUiActionList());
				return present(userContext,page, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingUiAction(RetailscmUserContext userContext, String pageId,
		String uiActionId, int uiActionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPage( pageId);
		checkerOf(userContext).checkIdOfUiAction(uiActionId);
		checkerOf(userContext).checkVersionOfUiAction(uiActionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}
	public  Page removeUiAction(RetailscmUserContext userContext, String pageId,
		String uiActionId, int uiActionVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingUiAction(userContext,pageId, uiActionId, uiActionVersion,tokensExpr);

		UiAction uiAction = createIndexedUiAction(uiActionId, uiActionVersion);
		Page page = loadPage(userContext, pageId, allTokens());
		synchronized(page){
			//Will be good when the page loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			page.removeUiAction( uiAction );
			page = savePage(userContext, page, tokens().withUiActionList().done());
			deleteRelationInGraph(userContext, uiAction);
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingUiAction(RetailscmUserContext userContext, String pageId,
		String uiActionId, int uiActionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPage( pageId);
		checkerOf(userContext).checkIdOfUiAction(uiActionId);
		checkerOf(userContext).checkVersionOfUiAction(uiActionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}
	public  Page copyUiActionFrom(RetailscmUserContext userContext, String pageId,
		String uiActionId, int uiActionVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingUiAction(userContext,pageId, uiActionId, uiActionVersion,tokensExpr);

		UiAction uiAction = createIndexedUiAction(uiActionId, uiActionVersion);
		Page page = loadPage(userContext, pageId, allTokens());
		synchronized(page){
			//Will be good when the page loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			page.copyUiActionFrom( uiAction );
			page = savePage(userContext, page, tokens().withUiActionList().done());
			
			userContext.getManagerGroup().getUiActionManager().onNewInstanceCreated(userContext, (UiAction)page.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingUiAction(RetailscmUserContext userContext, String pageId, String uiActionId, int uiActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkIdOfUiAction(uiActionId);
		checkerOf(userContext).checkVersionOfUiAction(uiActionVersion);
		

		if(UiAction.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfUiAction(parseString(newValueExpr));
		
		}
		
		if(UiAction.ICON_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkIconOfUiAction(parseString(newValueExpr));
		
		}
		
		if(UiAction.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfUiAction(parseString(newValueExpr));
		
		}
		
		if(UiAction.DISPLAY_ORDER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDisplayOrderOfUiAction(parseInt(newValueExpr));
		
		}
		
		if(UiAction.BRIEF_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBriefOfUiAction(parseString(newValueExpr));
		
		}
		
		if(UiAction.IMAGE_URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkImageUrlOfUiAction(parseString(newValueExpr));
		
		}
		
		if(UiAction.LINK_TO_URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLinkToUrlOfUiAction(parseString(newValueExpr));
		
		}
		
		if(UiAction.EXTRA_DATA_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkExtraDataOfUiAction(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}

	public  Page updateUiAction(RetailscmUserContext userContext, String pageId, String uiActionId, int uiActionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingUiAction(userContext, pageId, uiActionId, uiActionVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withUiActionList().searchUiActionListWith(UiAction.ID_PROPERTY, "eq", uiActionId).done();



		Page page = loadPage(userContext, pageId, loadTokens);

		synchronized(page){
			//Will be good when the page loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//page.removeUiAction( uiAction );
			//make changes to AcceleraterAccount.
			UiAction uiActionIndex = createIndexedUiAction(uiActionId, uiActionVersion);

			UiAction uiAction = page.findTheUiAction(uiActionIndex);
			if(uiAction == null){
				throw new PageManagerException(uiAction+" is NOT FOUND" );
			}

			uiAction.changeProperty(property, newValueExpr);
			
			page = savePage(userContext, page, tokens().withUiActionList().done());
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingSection(RetailscmUserContext userContext, String pageId, String title, String brief, String icon, int displayOrder, String viewGroup, String linkToUrl,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPage(pageId);

		
		checkerOf(userContext).checkTitleOfSection(title);
		
		checkerOf(userContext).checkBriefOfSection(brief);
		
		checkerOf(userContext).checkIconOfSection(icon);
		
		checkerOf(userContext).checkDisplayOrderOfSection(displayOrder);
		
		checkerOf(userContext).checkViewGroupOfSection(viewGroup);
		
		checkerOf(userContext).checkLinkToUrlOfSection(linkToUrl);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);


	}
	public  Page addSection(RetailscmUserContext userContext, String pageId, String title, String brief, String icon, int displayOrder, String viewGroup, String linkToUrl, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSection(userContext,pageId,title, brief, icon, displayOrder, viewGroup, linkToUrl,tokensExpr);

		Section section = createSection(userContext,title, brief, icon, displayOrder, viewGroup, linkToUrl);

		Page page = loadPage(userContext, pageId, emptyOptions());
		synchronized(page){
			//Will be good when the page loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			page.addSection( section );
			page = savePage(userContext, page, tokens().withSectionList().done());
			
			userContext.getManagerGroup().getSectionManager().onNewInstanceCreated(userContext, section);
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSectionProperties(RetailscmUserContext userContext, String pageId,String id,String title,String brief,String icon,int displayOrder,String viewGroup,String linkToUrl,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkIdOfSection(id);

		checkerOf(userContext).checkTitleOfSection( title);
		checkerOf(userContext).checkBriefOfSection( brief);
		checkerOf(userContext).checkIconOfSection( icon);
		checkerOf(userContext).checkDisplayOrderOfSection( displayOrder);
		checkerOf(userContext).checkViewGroupOfSection( viewGroup);
		checkerOf(userContext).checkLinkToUrlOfSection( linkToUrl);

		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}
	public  Page updateSectionProperties(RetailscmUserContext userContext, String pageId, String id,String title,String brief,String icon,int displayOrder,String viewGroup,String linkToUrl, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSectionProperties(userContext,pageId,id,title,brief,icon,displayOrder,viewGroup,linkToUrl,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSectionListList()
				.searchSectionListWith(Section.ID_PROPERTY, "is", id).done();

		Page pageToUpdate = loadPage(userContext, pageId, options);

		if(pageToUpdate.getSectionList().isEmpty()){
			throw new PageManagerException("Section is NOT FOUND with id: '"+id+"'");
		}

		Section item = pageToUpdate.getSectionList().first();

		item.updateTitle( title );
		item.updateBrief( brief );
		item.updateIcon( icon );
		item.updateDisplayOrder( displayOrder );
		item.updateViewGroup( viewGroup );
		item.updateLinkToUrl( linkToUrl );


		//checkParamsForAddingSection(userContext,pageId,name, code, used,tokensExpr);
		Page page = savePage(userContext, pageToUpdate, tokens().withSectionList().done());
		synchronized(page){
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}
	}


	protected Section createSection(RetailscmUserContext userContext, String title, String brief, String icon, int displayOrder, String viewGroup, String linkToUrl) throws Exception{

		Section section = new Section();
		
		
		section.setTitle(title);		
		section.setBrief(brief);		
		section.setIcon(icon);		
		section.setDisplayOrder(displayOrder);		
		section.setViewGroup(viewGroup);		
		section.setLinkToUrl(linkToUrl);
	
		
		return section;


	}

	protected Section createIndexedSection(String id, int version){

		Section section = new Section();
		section.setId(id);
		section.setVersion(version);
		return section;

	}

	protected void checkParamsForRemovingSectionList(RetailscmUserContext userContext, String pageId,
			String sectionIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPage(pageId);
		for(String sectionIdItem: sectionIds){
			checkerOf(userContext).checkIdOfSection(sectionIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}
	public  Page removeSectionList(RetailscmUserContext userContext, String pageId,
			String sectionIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSectionList(userContext, pageId,  sectionIds, tokensExpr);


			Page page = loadPage(userContext, pageId, allTokens());
			synchronized(page){
				//Will be good when the page loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				pageDaoOf(userContext).planToRemoveSectionList(page, sectionIds, allTokens());
				page = savePage(userContext, page, tokens().withSectionList().done());
				deleteRelationListInGraph(userContext, page.getSectionList());
				return present(userContext,page, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSection(RetailscmUserContext userContext, String pageId,
		String sectionId, int sectionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPage( pageId);
		checkerOf(userContext).checkIdOfSection(sectionId);
		checkerOf(userContext).checkVersionOfSection(sectionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}
	public  Page removeSection(RetailscmUserContext userContext, String pageId,
		String sectionId, int sectionVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSection(userContext,pageId, sectionId, sectionVersion,tokensExpr);

		Section section = createIndexedSection(sectionId, sectionVersion);
		Page page = loadPage(userContext, pageId, allTokens());
		synchronized(page){
			//Will be good when the page loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			page.removeSection( section );
			page = savePage(userContext, page, tokens().withSectionList().done());
			deleteRelationInGraph(userContext, section);
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSection(RetailscmUserContext userContext, String pageId,
		String sectionId, int sectionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPage( pageId);
		checkerOf(userContext).checkIdOfSection(sectionId);
		checkerOf(userContext).checkVersionOfSection(sectionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}
	public  Page copySectionFrom(RetailscmUserContext userContext, String pageId,
		String sectionId, int sectionVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSection(userContext,pageId, sectionId, sectionVersion,tokensExpr);

		Section section = createIndexedSection(sectionId, sectionVersion);
		Page page = loadPage(userContext, pageId, allTokens());
		synchronized(page){
			//Will be good when the page loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			page.copySectionFrom( section );
			page = savePage(userContext, page, tokens().withSectionList().done());
			
			userContext.getManagerGroup().getSectionManager().onNewInstanceCreated(userContext, (Section)page.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSection(RetailscmUserContext userContext, String pageId, String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkIdOfSection(sectionId);
		checkerOf(userContext).checkVersionOfSection(sectionVersion);
		

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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PageManagerException.class);

	}

	public  Page updateSection(RetailscmUserContext userContext, String pageId, String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSection(userContext, pageId, sectionId, sectionVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSectionList().searchSectionListWith(Section.ID_PROPERTY, "eq", sectionId).done();



		Page page = loadPage(userContext, pageId, loadTokens);

		synchronized(page){
			//Will be good when the page loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//page.removeSection( section );
			//make changes to AcceleraterAccount.
			Section sectionIndex = createIndexedSection(sectionId, sectionVersion);

			Section section = page.findTheSection(sectionIndex);
			if(section == null){
				throw new PageManagerException(section+" is NOT FOUND" );
			}

			section.changeProperty(property, newValueExpr);
			
			page = savePage(userContext, page, tokens().withSectionList().done());
			return present(userContext,page, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, Page newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
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
		//   Page newPage = this.createPage(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newPage
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Page.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<Page> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<PageType> pageTypeList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, PageType.class);
		userContext.getDAOGroup().enhanceList(pageTypeList, PageType.class);
		List<MobileApp> mobileAppList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, MobileApp.class);
		userContext.getDAOGroup().enhanceList(mobileAppList, MobileApp.class);


    }
	
	public Object listByPageType(RetailscmUserContext userContext,String pageTypeId) throws Exception {
		return listPageByPageType(userContext, pageTypeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPageType(RetailscmUserContext userContext,String pageTypeId, int start, int count) throws Exception {
		SmartList<Page> list = pageDaoOf(userContext).findPageByPageType(pageTypeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Page.class);
		page.setContainerObject(PageType.withId(pageTypeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("页面列表");
		page.setRequestName("listByPageType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByPageType/%s/",  getBeanName(), pageTypeId)));

		page.assemblerContent(userContext, "listByPageType");
		return page.doRender(userContext);
	}
  
	public Object listByMobileApp(RetailscmUserContext userContext,String mobileAppId) throws Exception {
		return listPageByMobileApp(userContext, mobileAppId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByMobileApp(RetailscmUserContext userContext,String mobileAppId, int start, int count) throws Exception {
		SmartList<Page> list = pageDaoOf(userContext).findPageByMobileApp(mobileAppId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(Page.class);
		page.setContainerObject(MobileApp.withId(mobileAppId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("页面列表");
		page.setRequestName("listByMobileApp");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByMobileApp/%s/",  getBeanName(), mobileAppId)));

		page.assemblerContent(userContext, "listByMobileApp");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String pageId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getPageDetailScope().clone();
		Page merchantObj = (Page) this.view(userContext, pageId);
    String merchantObjId = pageId;
    String linkToUrl =	"pageManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "页面"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-pageTitle")
				    .put("fieldName", "pageTitle")
				    .put("label", "页面标题")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("pageTitle", merchantObj.getPageTitle());

		propList.add(
				MapUtil.put("id", "3-linkToUrl")
				    .put("fieldName", "linkToUrl")
				    .put("label", "链接网址")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("linkToUrl", merchantObj.getLinkToUrl());

		propList.add(
				MapUtil.put("id", "4-pageType")
				    .put("fieldName", "pageType")
				    .put("label", "页面类型")
				    .put("type", "status")
				    .put("linkToUrl", "")
				    .put("displayMode", "{\"brief\":\"code\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("pageType", merchantObj.getPageType());

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
				MapUtil.put("id", "6-mobileApp")
				    .put("fieldName", "mobileApp")
				    .put("label", "手机应用程序")
				    .put("type", "auto")
				    .put("linkToUrl", "mobileAppManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("mobileApp", merchantObj.getMobileApp());

		//处理 sectionList

		//处理Section：slideListSection
		Map slideListSection = ListofUtils.buildSection(
		    "slideListSection",
		    "幻灯片列表",
		    null,
		    "",
		    "__no_group",
		    "slideManager/listByPage/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(slideListSection);

		result.put("slideListSection", ListofUtils.toShortList(merchantObj.getSlideList(), "slide"));
		vscope.field("slideListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Slide.class.getName(), null));

		//处理Section：uiActionListSection
		Map uiActionListSection = ListofUtils.buildSection(
		    "uiActionListSection",
		    "Ui动作列表",
		    null,
		    "",
		    "__no_group",
		    "uiActionManager/listByPage/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(uiActionListSection);

		result.put("uiActionListSection", ListofUtils.toShortList(merchantObj.getUiActionList(), "uiAction"));
		vscope.field("uiActionListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( UiAction.class.getName(), null));

		//处理Section：sectionListSection
		Map sectionListSection = ListofUtils.buildSection(
		    "sectionListSection",
		    "部分列表",
		    null,
		    "",
		    "__no_group",
		    "sectionManager/listByPage/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(sectionListSection);

		result.put("sectionListSection", ListofUtils.toShortList(merchantObj.getSectionList(), "section"));
		vscope.field("sectionListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Section.class.getName(), null));

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


