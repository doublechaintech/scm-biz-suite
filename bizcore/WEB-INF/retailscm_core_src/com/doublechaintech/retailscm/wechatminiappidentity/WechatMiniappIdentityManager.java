
package com.doublechaintech.retailscm.wechatminiappidentity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface WechatMiniappIdentityManager extends BaseManager{

		

	public WechatMiniappIdentity createWechatMiniappIdentity(RetailscmUserContext userContext, String openId,String appId,String secUserId,DateTime lastLoginTime) throws Exception;
	public WechatMiniappIdentity updateWechatMiniappIdentity(RetailscmUserContext userContext,String wechatMiniappIdentityId, int wechatMiniappIdentityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatMiniappIdentity loadWechatMiniappIdentity(RetailscmUserContext userContext, String wechatMiniappIdentityId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public WechatMiniappIdentity internalSaveWechatMiniappIdentity(RetailscmUserContext userContext, WechatMiniappIdentity wechatMiniappIdentity) throws Exception;
	public WechatMiniappIdentity internalSaveWechatMiniappIdentity(RetailscmUserContext userContext, WechatMiniappIdentity wechatMiniappIdentity,Map<String,Object>option) throws Exception;

	public WechatMiniappIdentity transferToAnotherSecUser(RetailscmUserContext userContext, String wechatMiniappIdentityId, String anotherSecUserId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String wechatMiniappIdentityId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, WechatMiniappIdentity newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listBySecUser(RetailscmUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(RetailscmUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


