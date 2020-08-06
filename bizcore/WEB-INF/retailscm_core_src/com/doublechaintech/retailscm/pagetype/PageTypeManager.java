
package com.doublechaintech.retailscm.pagetype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface PageTypeManager extends BaseManager{

		


	public PageType loadPageTypeWithCode(RetailscmUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public PageType createPageType(RetailscmUserContext userContext, String name,String code,String mobileAppId,boolean footerTab) throws Exception;
	public PageType updatePageType(RetailscmUserContext userContext,String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PageType loadPageType(RetailscmUserContext userContext, String pageTypeId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public PageType internalSavePageType(RetailscmUserContext userContext, PageType pageType) throws Exception;
	public PageType internalSavePageType(RetailscmUserContext userContext, PageType pageType,Map<String,Object>option) throws Exception;

	public PageType transferToAnotherMobileApp(RetailscmUserContext userContext, String pageTypeId, String anotherMobileAppId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String pageTypeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, PageType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PageManager getPageManager(RetailscmUserContext userContext, String pageTypeId, String pageTitle, String linkToUrl, int displayOrder, String mobileAppId ,String [] tokensExpr)  throws Exception;

	public  PageType addPage(RetailscmUserContext userContext, String pageTypeId, String pageTitle, String linkToUrl, int displayOrder, String mobileAppId , String [] tokensExpr)  throws Exception;
	public  PageType removePage(RetailscmUserContext userContext, String pageTypeId, String pageId, int pageVersion,String [] tokensExpr)  throws Exception;
	public  PageType updatePage(RetailscmUserContext userContext, String pageTypeId, String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByMobileApp(RetailscmUserContext userContext,String mobileAppId) throws Exception;
	public Object listPageByMobileApp(RetailscmUserContext userContext,String mobileAppId, int start, int count) throws Exception;
  

}


