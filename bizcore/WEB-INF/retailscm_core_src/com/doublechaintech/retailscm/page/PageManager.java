
package com.doublechaintech.retailscm.page;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface PageManager extends BaseManager{

		

	public Page createPage(RetailscmUserContext userContext, String pageTitle,String linkToUrl,String pageTypeId,int displayOrder,String mobileAppId) throws Exception;
	public Page updatePage(RetailscmUserContext userContext,String pageId, int pageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Page loadPage(RetailscmUserContext userContext, String pageId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public Page internalSavePage(RetailscmUserContext userContext, Page page) throws Exception;
	public Page internalSavePage(RetailscmUserContext userContext, Page page,Map<String,Object>option) throws Exception;

	public Page transferToAnotherPageType(RetailscmUserContext userContext, String pageId, String anotherPageTypeId)  throws Exception;
 	public Page transferToAnotherMobileApp(RetailscmUserContext userContext, String pageId, String anotherMobileAppId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String pageId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, Page newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SlideManager getSlideManager(RetailscmUserContext userContext, String pageId, String name, int displayOrder, String imageUrl, String videoUrl, String linkToUrl ,String [] tokensExpr)  throws Exception;

	public  Page addSlide(RetailscmUserContext userContext, String pageId, String name, int displayOrder, String imageUrl, String videoUrl, String linkToUrl , String [] tokensExpr)  throws Exception;
	public  Page removeSlide(RetailscmUserContext userContext, String pageId, String slideId, int slideVersion,String [] tokensExpr)  throws Exception;
	public  Page updateSlide(RetailscmUserContext userContext, String pageId, String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  UiActionManager getUiActionManager(RetailscmUserContext userContext, String pageId, String code, String icon, String title, int displayOrder, String brief, String imageUrl, String linkToUrl, String extraData ,String [] tokensExpr)  throws Exception;

	public  Page addUiAction(RetailscmUserContext userContext, String pageId, String code, String icon, String title, int displayOrder, String brief, String imageUrl, String linkToUrl, String extraData , String [] tokensExpr)  throws Exception;
	public  Page removeUiAction(RetailscmUserContext userContext, String pageId, String uiActionId, int uiActionVersion,String [] tokensExpr)  throws Exception;
	public  Page updateUiAction(RetailscmUserContext userContext, String pageId, String uiActionId, int uiActionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SectionManager getSectionManager(RetailscmUserContext userContext, String pageId, String title, String brief, String icon, int displayOrder, String viewGroup, String linkToUrl ,String [] tokensExpr)  throws Exception;

	public  Page addSection(RetailscmUserContext userContext, String pageId, String title, String brief, String icon, int displayOrder, String viewGroup, String linkToUrl , String [] tokensExpr)  throws Exception;
	public  Page removeSection(RetailscmUserContext userContext, String pageId, String sectionId, int sectionVersion,String [] tokensExpr)  throws Exception;
	public  Page updateSection(RetailscmUserContext userContext, String pageId, String sectionId, int sectionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByPageType(RetailscmUserContext userContext,String pageTypeId) throws Exception;
	public Object listPageByPageType(RetailscmUserContext userContext,String pageTypeId, int start, int count) throws Exception;
  
	public Object listByMobileApp(RetailscmUserContext userContext,String mobileAppId) throws Exception;
	public Object listPageByMobileApp(RetailscmUserContext userContext,String mobileAppId, int start, int count) throws Exception;
  

}


