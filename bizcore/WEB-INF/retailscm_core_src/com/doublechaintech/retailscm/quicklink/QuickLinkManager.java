
package com.doublechaintech.retailscm.quicklink;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface QuickLinkManager extends BaseManager{

		

	public QuickLink createQuickLink(RetailscmUserContext userContext, String name,String icon,String imagePath,String linkTarget,String appId) throws Exception;
	public QuickLink updateQuickLink(RetailscmUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public QuickLink loadQuickLink(RetailscmUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception;
	public QuickLink internalSaveQuickLink(RetailscmUserContext userContext, QuickLink quickLink) throws Exception;
	public QuickLink internalSaveQuickLink(RetailscmUserContext userContext, QuickLink quickLink,Map<String,Object>option) throws Exception;

	public QuickLink transferToAnotherApp(RetailscmUserContext userContext, String quickLinkId, String anotherAppId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String quickLinkId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, QuickLink newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByApp(RetailscmUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(RetailscmUserContext userContext,String appId, int start, int count) throws Exception;
  

}


