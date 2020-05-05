
package com.doublechaintech.retailscm.mobileapp;

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


import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.page.Page;


import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.pagetype.PageType;






public class MobileAppManagerImpl extends CustomRetailscmCheckerManager implements MobileAppManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = MobileAppTokens.start().withTokenFromListName(listName).done();
		MobileApp  mobileApp = (MobileApp) this.loadMobileApp(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = mobileApp.collectRefercencesFromLists();
		mobileAppDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, mobileApp, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new MobileAppGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "MobileApp";
	@Override
	public MobileAppDAO daoOf(RetailscmUserContext userContext) {
		return mobileAppDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws MobileAppManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new MobileAppManagerException(message);

	}



 	protected MobileApp saveMobileApp(RetailscmUserContext userContext, MobileApp mobileApp, String [] tokensExpr) throws Exception{	
 		//return getMobileAppDAO().save(mobileApp, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveMobileApp(userContext, mobileApp, tokens);
 	}
 	
 	protected MobileApp saveMobileAppDetail(RetailscmUserContext userContext, MobileApp mobileApp) throws Exception{	

 		
 		return saveMobileApp(userContext, mobileApp, allTokens());
 	}
 	
 	public MobileApp loadMobileApp(RetailscmUserContext userContext, String mobileAppId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
		checkerOf(userContext).throwExceptionIfHasErrors( MobileAppManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		MobileApp mobileApp = loadMobileApp( userContext, mobileAppId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,mobileApp, tokens);
 	}
 	
 	
 	 public MobileApp searchMobileApp(RetailscmUserContext userContext, String mobileAppId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
		checkerOf(userContext).throwExceptionIfHasErrors( MobileAppManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		MobileApp mobileApp = loadMobileApp( userContext, mobileAppId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,mobileApp, tokens);
 	}
 	
 	

 	protected MobileApp present(RetailscmUserContext userContext, MobileApp mobileApp, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,mobileApp,tokens);
		
		
		MobileApp  mobileAppToPresent = mobileAppDaoOf(userContext).present(mobileApp, tokens);
		
		List<BaseEntity> entityListToNaming = mobileAppToPresent.collectRefercencesFromLists();
		mobileAppDaoOf(userContext).alias(entityListToNaming);
		
		return  mobileAppToPresent;
		
		
	}
 
 	
 	
 	public MobileApp loadMobileAppDetail(RetailscmUserContext userContext, String mobileAppId) throws Exception{	
 		MobileApp mobileApp = loadMobileApp( userContext, mobileAppId, allTokens());
 		return present(userContext,mobileApp, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String mobileAppId) throws Exception{	
 		MobileApp mobileApp = loadMobileApp( userContext, mobileAppId, viewTokens());
 		return present(userContext,mobileApp, allTokens());
		
 	}
 	protected MobileApp saveMobileApp(RetailscmUserContext userContext, MobileApp mobileApp, Map<String,Object>tokens) throws Exception{	
 		return mobileAppDaoOf(userContext).save(mobileApp, tokens);
 	}
 	protected MobileApp loadMobileApp(RetailscmUserContext userContext, String mobileAppId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
		checkerOf(userContext).throwExceptionIfHasErrors( MobileAppManagerException.class);

 
 		return mobileAppDaoOf(userContext).load(mobileAppId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, MobileApp mobileApp, Map<String, Object> tokens){
		super.addActions(userContext, mobileApp, tokens);
		
		addAction(userContext, mobileApp, tokens,"@create","createMobileApp","createMobileApp/","main","primary");
		addAction(userContext, mobileApp, tokens,"@update","updateMobileApp","updateMobileApp/"+mobileApp.getId()+"/","main","primary");
		addAction(userContext, mobileApp, tokens,"@copy","cloneMobileApp","cloneMobileApp/"+mobileApp.getId()+"/","main","primary");
		
		addAction(userContext, mobileApp, tokens,"mobile_app.addPage","addPage","addPage/"+mobileApp.getId()+"/","pageList","primary");
		addAction(userContext, mobileApp, tokens,"mobile_app.removePage","removePage","removePage/"+mobileApp.getId()+"/","pageList","primary");
		addAction(userContext, mobileApp, tokens,"mobile_app.updatePage","updatePage","updatePage/"+mobileApp.getId()+"/","pageList","primary");
		addAction(userContext, mobileApp, tokens,"mobile_app.copyPageFrom","copyPageFrom","copyPageFrom/"+mobileApp.getId()+"/","pageList","primary");
		addAction(userContext, mobileApp, tokens,"mobile_app.addPageType","addPageType","addPageType/"+mobileApp.getId()+"/","pageTypeList","primary");
		addAction(userContext, mobileApp, tokens,"mobile_app.removePageType","removePageType","removePageType/"+mobileApp.getId()+"/","pageTypeList","primary");
		addAction(userContext, mobileApp, tokens,"mobile_app.updatePageType","updatePageType","updatePageType/"+mobileApp.getId()+"/","pageTypeList","primary");
		addAction(userContext, mobileApp, tokens,"mobile_app.copyPageTypeFrom","copyPageTypeFrom","copyPageTypeFrom/"+mobileApp.getId()+"/","pageTypeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, MobileApp mobileApp, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public MobileApp createMobileApp(RetailscmUserContext userContext, String name) throws Exception
	//public MobileApp createMobileApp(RetailscmUserContext userContext,String name) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfMobileApp(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);


		MobileApp mobileApp=createNewMobileApp();	

		mobileApp.setName(name);

		mobileApp = saveMobileApp(userContext, mobileApp, emptyOptions());
		
		onNewInstanceCreated(userContext, mobileApp);
		return mobileApp;


	}
	protected MobileApp createNewMobileApp()
	{

		return new MobileApp();
	}

	protected void checkParamsForUpdatingMobileApp(RetailscmUserContext userContext,String mobileAppId, int mobileAppVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
		checkerOf(userContext).checkVersionOfMobileApp( mobileAppVersion);
		

		if(MobileApp.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfMobileApp(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);


	}



	public MobileApp clone(RetailscmUserContext userContext, String fromMobileAppId) throws Exception{

		return mobileAppDaoOf(userContext).clone(fromMobileAppId, this.allTokens());
	}

	public MobileApp internalSaveMobileApp(RetailscmUserContext userContext, MobileApp mobileApp) throws Exception
	{
		return internalSaveMobileApp(userContext, mobileApp, allTokens());

	}
	public MobileApp internalSaveMobileApp(RetailscmUserContext userContext, MobileApp mobileApp, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingMobileApp(userContext, mobileAppId, mobileAppVersion, property, newValueExpr, tokensExpr);


		synchronized(mobileApp){
			//will be good when the mobileApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MobileApp.
			if (mobileApp.isChanged()){
			
			}
			mobileApp = saveMobileApp(userContext, mobileApp, options);
			return mobileApp;

		}

	}

	public MobileApp updateMobileApp(RetailscmUserContext userContext,String mobileAppId, int mobileAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingMobileApp(userContext, mobileAppId, mobileAppVersion, property, newValueExpr, tokensExpr);



		MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
		if(mobileApp.getVersion() != mobileAppVersion){
			String message = "The target version("+mobileApp.getVersion()+") is not equals to version("+mobileAppVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(mobileApp){
			//will be good when the mobileApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MobileApp.
			
			mobileApp.changeProperty(property, newValueExpr);
			mobileApp = saveMobileApp(userContext, mobileApp, tokens().done());
			return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
			//return saveMobileApp(userContext, mobileApp, tokens().done());
		}

	}

	public MobileApp updateMobileAppProperty(RetailscmUserContext userContext,String mobileAppId, int mobileAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingMobileApp(userContext, mobileAppId, mobileAppVersion, property, newValueExpr, tokensExpr);

		MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
		if(mobileApp.getVersion() != mobileAppVersion){
			String message = "The target version("+mobileApp.getVersion()+") is not equals to version("+mobileAppVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(mobileApp){
			//will be good when the mobileApp loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MobileApp.

			mobileApp.changeProperty(property, newValueExpr);
			
			mobileApp = saveMobileApp(userContext, mobileApp, tokens().done());
			return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
			//return saveMobileApp(userContext, mobileApp, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected MobileAppTokens tokens(){
		return MobileAppTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return MobileAppTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortPageListWith("id","desc")
		.sortPageTypeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return MobileAppTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String mobileAppId, int mobileAppVersion) throws Exception {
		//deleteInternal(userContext, mobileAppId, mobileAppVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String mobileAppId, int mobileAppVersion) throws Exception{

		mobileAppDaoOf(userContext).delete(mobileAppId, mobileAppVersion);
	}

	public MobileApp forgetByAll(RetailscmUserContext userContext, String mobileAppId, int mobileAppVersion) throws Exception {
		return forgetByAllInternal(userContext, mobileAppId, mobileAppVersion);
	}
	protected MobileApp forgetByAllInternal(RetailscmUserContext userContext,
			String mobileAppId, int mobileAppVersion) throws Exception{

		return mobileAppDaoOf(userContext).disconnectFromAll(mobileAppId, mobileAppVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new MobileAppManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return mobileAppDaoOf(userContext).deleteAll();
	}


	//disconnect MobileApp with page_type in Page
	protected MobileApp breakWithPageByPageType(RetailscmUserContext userContext, String mobileAppId, String pageTypeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());

			synchronized(mobileApp){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				mobileAppDaoOf(userContext).planToRemovePageListWithPageType(mobileApp, pageTypeId, this.emptyOptions());

				mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageList().done());
				return mobileApp;
			}
	}






	protected void checkParamsForAddingPage(RetailscmUserContext userContext, String mobileAppId, String pageTitle, String linkToUrl, String pageTypeId, int displayOrder,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfMobileApp(mobileAppId);

		
		checkerOf(userContext).checkPageTitleOfPage(pageTitle);
		
		checkerOf(userContext).checkLinkToUrlOfPage(linkToUrl);
		
		checkerOf(userContext).checkPageTypeIdOfPage(pageTypeId);
		
		checkerOf(userContext).checkDisplayOrderOfPage(displayOrder);
	
		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);


	}
	public  MobileApp addPage(RetailscmUserContext userContext, String mobileAppId, String pageTitle, String linkToUrl, String pageTypeId, int displayOrder, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingPage(userContext,mobileAppId,pageTitle, linkToUrl, pageTypeId, displayOrder,tokensExpr);

		Page page = createPage(userContext,pageTitle, linkToUrl, pageTypeId, displayOrder);

		MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, emptyOptions());
		synchronized(mobileApp){
			//Will be good when the mobileApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			mobileApp.addPage( page );
			mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageList().done());
			
			userContext.getManagerGroup().getPageManager().onNewInstanceCreated(userContext, page);
			return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPageProperties(RetailscmUserContext userContext, String mobileAppId,String id,String pageTitle,String linkToUrl,int displayOrder,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
		checkerOf(userContext).checkIdOfPage(id);

		checkerOf(userContext).checkPageTitleOfPage( pageTitle);
		checkerOf(userContext).checkLinkToUrlOfPage( linkToUrl);
		checkerOf(userContext).checkDisplayOrderOfPage( displayOrder);

		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

	}
	public  MobileApp updatePageProperties(RetailscmUserContext userContext, String mobileAppId, String id,String pageTitle,String linkToUrl,int displayOrder, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPageProperties(userContext,mobileAppId,id,pageTitle,linkToUrl,displayOrder,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPageListList()
				.searchPageListWith(Page.ID_PROPERTY, "is", id).done();

		MobileApp mobileAppToUpdate = loadMobileApp(userContext, mobileAppId, options);

		if(mobileAppToUpdate.getPageList().isEmpty()){
			throw new MobileAppManagerException("Page is NOT FOUND with id: '"+id+"'");
		}

		Page item = mobileAppToUpdate.getPageList().first();

		item.updatePageTitle( pageTitle );
		item.updateLinkToUrl( linkToUrl );
		item.updateDisplayOrder( displayOrder );


		//checkParamsForAddingPage(userContext,mobileAppId,name, code, used,tokensExpr);
		MobileApp mobileApp = saveMobileApp(userContext, mobileAppToUpdate, tokens().withPageList().done());
		synchronized(mobileApp){
			return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
		}
	}


	protected Page createPage(RetailscmUserContext userContext, String pageTitle, String linkToUrl, String pageTypeId, int displayOrder) throws Exception{

		Page page = new Page();
		
		
		page.setPageTitle(pageTitle);		
		page.setLinkToUrl(linkToUrl);		
		PageType  pageType = new PageType();
		pageType.setId(pageTypeId);		
		page.setPageType(pageType);		
		page.setDisplayOrder(displayOrder);
	
		
		return page;


	}

	protected Page createIndexedPage(String id, int version){

		Page page = new Page();
		page.setId(id);
		page.setVersion(version);
		return page;

	}

	protected void checkParamsForRemovingPageList(RetailscmUserContext userContext, String mobileAppId,
			String pageIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
		for(String pageIdItem: pageIds){
			checkerOf(userContext).checkIdOfPage(pageIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

	}
	public  MobileApp removePageList(RetailscmUserContext userContext, String mobileAppId,
			String pageIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingPageList(userContext, mobileAppId,  pageIds, tokensExpr);


			MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
			synchronized(mobileApp){
				//Will be good when the mobileApp loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				mobileAppDaoOf(userContext).planToRemovePageList(mobileApp, pageIds, allTokens());
				mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageList().done());
				deleteRelationListInGraph(userContext, mobileApp.getPageList());
				return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingPage(RetailscmUserContext userContext, String mobileAppId,
		String pageId, int pageVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfMobileApp( mobileAppId);
		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkVersionOfPage(pageVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

	}
	public  MobileApp removePage(RetailscmUserContext userContext, String mobileAppId,
		String pageId, int pageVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingPage(userContext,mobileAppId, pageId, pageVersion,tokensExpr);

		Page page = createIndexedPage(pageId, pageVersion);
		MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
		synchronized(mobileApp){
			//Will be good when the mobileApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			mobileApp.removePage( page );
			mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageList().done());
			deleteRelationInGraph(userContext, page);
			return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingPage(RetailscmUserContext userContext, String mobileAppId,
		String pageId, int pageVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfMobileApp( mobileAppId);
		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkVersionOfPage(pageVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

	}
	public  MobileApp copyPageFrom(RetailscmUserContext userContext, String mobileAppId,
		String pageId, int pageVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingPage(userContext,mobileAppId, pageId, pageVersion,tokensExpr);

		Page page = createIndexedPage(pageId, pageVersion);
		MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
		synchronized(mobileApp){
			//Will be good when the mobileApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			mobileApp.copyPageFrom( page );
			mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageList().done());
			
			userContext.getManagerGroup().getPageManager().onNewInstanceCreated(userContext, (Page)mobileApp.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingPage(RetailscmUserContext userContext, String mobileAppId, String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
		checkerOf(userContext).checkIdOfPage(pageId);
		checkerOf(userContext).checkVersionOfPage(pageVersion);
		

		if(Page.PAGE_TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkPageTitleOfPage(parseString(newValueExpr));
		
		}
		
		if(Page.LINK_TO_URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLinkToUrlOfPage(parseString(newValueExpr));
		
		}
		
		if(Page.DISPLAY_ORDER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDisplayOrderOfPage(parseInt(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

	}

	public  MobileApp updatePage(RetailscmUserContext userContext, String mobileAppId, String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingPage(userContext, mobileAppId, pageId, pageVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withPageList().searchPageListWith(Page.ID_PROPERTY, "eq", pageId).done();



		MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, loadTokens);

		synchronized(mobileApp){
			//Will be good when the mobileApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//mobileApp.removePage( page );
			//make changes to AcceleraterAccount.
			Page pageIndex = createIndexedPage(pageId, pageVersion);

			Page page = mobileApp.findThePage(pageIndex);
			if(page == null){
				throw new MobileAppManagerException(page+" is NOT FOUND" );
			}

			page.changeProperty(property, newValueExpr);
			
			mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageList().done());
			return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingPageType(RetailscmUserContext userContext, String mobileAppId, String name, String code, boolean footerTab,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfMobileApp(mobileAppId);

		
		checkerOf(userContext).checkNameOfPageType(name);
		
		checkerOf(userContext).checkCodeOfPageType(code);
		
		checkerOf(userContext).checkFooterTabOfPageType(footerTab);
	
		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);


	}
	public  MobileApp addPageType(RetailscmUserContext userContext, String mobileAppId, String name, String code, boolean footerTab, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingPageType(userContext,mobileAppId,name, code, footerTab,tokensExpr);

		PageType pageType = createPageType(userContext,name, code, footerTab);

		MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, emptyOptions());
		synchronized(mobileApp){
			//Will be good when the mobileApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			mobileApp.addPageType( pageType );
			mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageTypeList().done());
			
			userContext.getManagerGroup().getPageTypeManager().onNewInstanceCreated(userContext, pageType);
			return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPageTypeProperties(RetailscmUserContext userContext, String mobileAppId,String id,String name,String code,boolean footerTab,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
		checkerOf(userContext).checkIdOfPageType(id);

		checkerOf(userContext).checkNameOfPageType( name);
		checkerOf(userContext).checkCodeOfPageType( code);
		checkerOf(userContext).checkFooterTabOfPageType( footerTab);

		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

	}
	public  MobileApp updatePageTypeProperties(RetailscmUserContext userContext, String mobileAppId, String id,String name,String code,boolean footerTab, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPageTypeProperties(userContext,mobileAppId,id,name,code,footerTab,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPageTypeListList()
				.searchPageTypeListWith(PageType.ID_PROPERTY, "is", id).done();

		MobileApp mobileAppToUpdate = loadMobileApp(userContext, mobileAppId, options);

		if(mobileAppToUpdate.getPageTypeList().isEmpty()){
			throw new MobileAppManagerException("PageType is NOT FOUND with id: '"+id+"'");
		}

		PageType item = mobileAppToUpdate.getPageTypeList().first();

		item.updateName( name );
		item.updateCode( code );
		item.updateFooterTab( footerTab );


		//checkParamsForAddingPageType(userContext,mobileAppId,name, code, used,tokensExpr);
		MobileApp mobileApp = saveMobileApp(userContext, mobileAppToUpdate, tokens().withPageTypeList().done());
		synchronized(mobileApp){
			return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
		}
	}


	protected PageType createPageType(RetailscmUserContext userContext, String name, String code, boolean footerTab) throws Exception{

		PageType pageType = new PageType();
		
		
		pageType.setName(name);		
		pageType.setCode(code);		
		pageType.setFooterTab(footerTab);
	
		
		return pageType;


	}

	protected PageType createIndexedPageType(String id, int version){

		PageType pageType = new PageType();
		pageType.setId(id);
		pageType.setVersion(version);
		return pageType;

	}

	protected void checkParamsForRemovingPageTypeList(RetailscmUserContext userContext, String mobileAppId,
			String pageTypeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
		for(String pageTypeIdItem: pageTypeIds){
			checkerOf(userContext).checkIdOfPageType(pageTypeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

	}
	public  MobileApp removePageTypeList(RetailscmUserContext userContext, String mobileAppId,
			String pageTypeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingPageTypeList(userContext, mobileAppId,  pageTypeIds, tokensExpr);


			MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
			synchronized(mobileApp){
				//Will be good when the mobileApp loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				mobileAppDaoOf(userContext).planToRemovePageTypeList(mobileApp, pageTypeIds, allTokens());
				mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageTypeList().done());
				deleteRelationListInGraph(userContext, mobileApp.getPageTypeList());
				return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingPageType(RetailscmUserContext userContext, String mobileAppId,
		String pageTypeId, int pageTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfMobileApp( mobileAppId);
		checkerOf(userContext).checkIdOfPageType(pageTypeId);
		checkerOf(userContext).checkVersionOfPageType(pageTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

	}
	public  MobileApp removePageType(RetailscmUserContext userContext, String mobileAppId,
		String pageTypeId, int pageTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingPageType(userContext,mobileAppId, pageTypeId, pageTypeVersion,tokensExpr);

		PageType pageType = createIndexedPageType(pageTypeId, pageTypeVersion);
		MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
		synchronized(mobileApp){
			//Will be good when the mobileApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			mobileApp.removePageType( pageType );
			mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageTypeList().done());
			deleteRelationInGraph(userContext, pageType);
			return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingPageType(RetailscmUserContext userContext, String mobileAppId,
		String pageTypeId, int pageTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfMobileApp( mobileAppId);
		checkerOf(userContext).checkIdOfPageType(pageTypeId);
		checkerOf(userContext).checkVersionOfPageType(pageTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

	}
	public  MobileApp copyPageTypeFrom(RetailscmUserContext userContext, String mobileAppId,
		String pageTypeId, int pageTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingPageType(userContext,mobileAppId, pageTypeId, pageTypeVersion,tokensExpr);

		PageType pageType = createIndexedPageType(pageTypeId, pageTypeVersion);
		MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
		synchronized(mobileApp){
			//Will be good when the mobileApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			mobileApp.copyPageTypeFrom( pageType );
			mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageTypeList().done());
			
			userContext.getManagerGroup().getPageTypeManager().onNewInstanceCreated(userContext, (PageType)mobileApp.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingPageType(RetailscmUserContext userContext, String mobileAppId, String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
		checkerOf(userContext).checkIdOfPageType(pageTypeId);
		checkerOf(userContext).checkVersionOfPageType(pageTypeVersion);
		

		if(PageType.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfPageType(parseString(newValueExpr));
		
		}
		
		if(PageType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfPageType(parseString(newValueExpr));
		
		}
		
		if(PageType.FOOTER_TAB_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFooterTabOfPageType(parseBoolean(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

	}

	public  MobileApp updatePageType(RetailscmUserContext userContext, String mobileAppId, String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingPageType(userContext, mobileAppId, pageTypeId, pageTypeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withPageTypeList().searchPageTypeListWith(PageType.ID_PROPERTY, "eq", pageTypeId).done();



		MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, loadTokens);

		synchronized(mobileApp){
			//Will be good when the mobileApp loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//mobileApp.removePageType( pageType );
			//make changes to AcceleraterAccount.
			PageType pageTypeIndex = createIndexedPageType(pageTypeId, pageTypeVersion);

			PageType pageType = mobileApp.findThePageType(pageTypeIndex);
			if(pageType == null){
				throw new MobileAppManagerException(pageType+" is NOT FOUND" );
			}

			pageType.changeProperty(property, newValueExpr);
			
			mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageTypeList().done());
			return present(userContext,mobileApp, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, MobileApp newCreated) throws Exception{
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
		//   MobileApp newMobileApp = this.createMobileApp(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newMobileApp
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, MobileApp.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<MobileApp> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String mobileAppId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getMobileAppDetailScope().clone();
		MobileApp merchantObj = (MobileApp) this.view(userContext, mobileAppId);
    String merchantObjId = mobileAppId;
    String linkToUrl =	"mobileAppManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "手机应用程序"+"详情";
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
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		//处理 sectionList

		//处理Section：pageListSection
		Map pageListSection = ListofUtils.buildSection(
		    "pageListSection",
		    "页面列表",
		    null,
		    "",
		    "__no_group",
		    "pageManager/listByMobileApp/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(pageListSection);

		result.put("pageListSection", ListofUtils.toShortList(merchantObj.getPageList(), "page"));
		vscope.field("pageListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Page.class.getName(), null));

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


