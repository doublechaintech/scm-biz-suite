
package com.doublechaintech.retailscm.uiaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface UiActionManager extends BaseManager{

		

	public UiAction createUiAction(RetailscmUserContext userContext, String code,String icon,String title,int displayOrder,String brief,String imageUrl,String linkToUrl,String extraData,String pageId) throws Exception;
	public UiAction updateUiAction(RetailscmUserContext userContext,String uiActionId, int uiActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UiAction loadUiAction(RetailscmUserContext userContext, String uiActionId, String [] tokensExpr) throws Exception;
	public UiAction internalSaveUiAction(RetailscmUserContext userContext, UiAction uiAction) throws Exception;
	public UiAction internalSaveUiAction(RetailscmUserContext userContext, UiAction uiAction,Map<String,Object>option) throws Exception;

	public UiAction transferToAnotherPage(RetailscmUserContext userContext, String uiActionId, String anotherPageId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String uiActionId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, UiAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPage(RetailscmUserContext userContext,String pageId) throws Exception;
	public Object listPageByPage(RetailscmUserContext userContext,String pageId, int start, int count) throws Exception;
  

}


