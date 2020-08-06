
package com.doublechaintech.retailscm.wechatworkappidentity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface WechatWorkappIdentityManager extends BaseManager{

		

	public WechatWorkappIdentity createWechatWorkappIdentity(RetailscmUserContext userContext, String corpId,String userId,String secUserId,DateTime lastLoginTime) throws Exception;
	public WechatWorkappIdentity updateWechatWorkappIdentity(RetailscmUserContext userContext,String wechatWorkappIdentityId, int wechatWorkappIdentityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatWorkappIdentity loadWechatWorkappIdentity(RetailscmUserContext userContext, String wechatWorkappIdentityId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public WechatWorkappIdentity internalSaveWechatWorkappIdentity(RetailscmUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity) throws Exception;
	public WechatWorkappIdentity internalSaveWechatWorkappIdentity(RetailscmUserContext userContext, WechatWorkappIdentity wechatWorkappIdentity,Map<String,Object>option) throws Exception;

	public WechatWorkappIdentity transferToAnotherSecUser(RetailscmUserContext userContext, String wechatWorkappIdentityId, String anotherSecUserId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String wechatWorkappIdentityId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, WechatWorkappIdentity newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(RetailscmUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(RetailscmUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


