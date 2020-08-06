
package com.doublechaintech.retailscm.loginhistory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface LoginHistoryManager extends BaseManager{

		

	public LoginHistory createLoginHistory(RetailscmUserContext userContext, String fromIp,String description,String secUserId) throws Exception;
	public LoginHistory updateLoginHistory(RetailscmUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LoginHistory loadLoginHistory(RetailscmUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public LoginHistory internalSaveLoginHistory(RetailscmUserContext userContext, LoginHistory loginHistory) throws Exception;
	public LoginHistory internalSaveLoginHistory(RetailscmUserContext userContext, LoginHistory loginHistory,Map<String,Object>option) throws Exception;

	public LoginHistory transferToAnotherSecUser(RetailscmUserContext userContext, String loginHistoryId, String anotherSecUserId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String loginHistoryId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, LoginHistory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(RetailscmUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(RetailscmUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


