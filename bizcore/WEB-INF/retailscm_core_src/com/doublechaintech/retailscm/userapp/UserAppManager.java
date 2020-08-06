
package com.doublechaintech.retailscm.userapp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface UserAppManager extends BaseManager{

		

	public UserApp createUserApp(RetailscmUserContext userContext, String title,String secUserId,String appIcon,boolean fullAccess,String permission,String objectType,String objectId,String location) throws Exception;
	public UserApp updateUserApp(RetailscmUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserApp loadUserApp(RetailscmUserContext userContext, String userAppId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public UserApp internalSaveUserApp(RetailscmUserContext userContext, UserApp userApp) throws Exception;
	public UserApp internalSaveUserApp(RetailscmUserContext userContext, UserApp userApp,Map<String,Object>option) throws Exception;

	public UserApp transferToAnotherSecUser(RetailscmUserContext userContext, String userAppId, String anotherSecUserId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String userAppId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, UserApp newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  QuickLinkManager getQuickLinkManager(RetailscmUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget ,String [] tokensExpr)  throws Exception;

	public  UserApp addQuickLink(RetailscmUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget , String [] tokensExpr)  throws Exception;
	public  UserApp removeQuickLink(RetailscmUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateQuickLink(RetailscmUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ListAccessManager getListAccessManager(RetailscmUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission ,String [] tokensExpr)  throws Exception;

	public  UserApp addListAccess(RetailscmUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission , String [] tokensExpr)  throws Exception;
	public  UserApp removeListAccess(RetailscmUserContext userContext, String userAppId, String listAccessId, int listAccessVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateListAccess(RetailscmUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listBySecUser(RetailscmUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(RetailscmUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


