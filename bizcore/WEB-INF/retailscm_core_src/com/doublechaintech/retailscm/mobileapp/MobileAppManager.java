
package com.doublechaintech.retailscm.mobileapp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;




public interface MobileAppManager extends BaseManager{

		

  List<MobileApp> searchMobileAppList(RetailscmUserContext ctx, MobileAppRequest pRequest);
  MobileApp searchMobileApp(RetailscmUserContext ctx, MobileAppRequest pRequest);
	public MobileApp createMobileApp(RetailscmUserContext userContext, String name) throws Exception;
	public MobileApp updateMobileApp(RetailscmUserContext userContext,String mobileAppId, int mobileAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MobileApp loadMobileApp(RetailscmUserContext userContext, String mobileAppId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public MobileApp internalSaveMobileApp(RetailscmUserContext userContext, MobileApp mobileApp) throws Exception;
	public MobileApp internalSaveMobileApp(RetailscmUserContext userContext, MobileApp mobileApp,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String mobileAppId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, MobileApp newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, MobileApp updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PageManager getPageManager(RetailscmUserContext userContext, String mobileAppId, String pageTitle, String linkToUrl, String pageTypeId, int displayOrder ,String [] tokensExpr)  throws Exception;

	public  MobileApp addPage(RetailscmUserContext userContext, String mobileAppId, String pageTitle, String linkToUrl, String pageTypeId, int displayOrder , String [] tokensExpr)  throws Exception;
	public  MobileApp removePage(RetailscmUserContext userContext, String mobileAppId, String pageId, int pageVersion,String [] tokensExpr)  throws Exception;
	public  MobileApp updatePage(RetailscmUserContext userContext, String mobileAppId, String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PageTypeManager getPageTypeManager(RetailscmUserContext userContext, String mobileAppId, String name, String code, boolean footerTab ,String [] tokensExpr)  throws Exception;

	public  MobileApp addPageType(RetailscmUserContext userContext, String mobileAppId, String name, String code, boolean footerTab , String [] tokensExpr)  throws Exception;
	public  MobileApp removePageType(RetailscmUserContext userContext, String mobileAppId, String pageTypeId, int pageTypeVersion,String [] tokensExpr)  throws Exception;
	public  MobileApp updatePageType(RetailscmUserContext userContext, String mobileAppId, String pageTypeId, int pageTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/






}


