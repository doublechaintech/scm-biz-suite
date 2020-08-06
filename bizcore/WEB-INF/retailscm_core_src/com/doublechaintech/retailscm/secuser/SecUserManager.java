
package com.doublechaintech.retailscm.secuser;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SecUserManager extends BaseManager{

		


	public SecUser loadSecUserWithLogin(RetailscmUserContext userContext, String login, Map<String,Object>tokens) throws Exception;

	 


	public SecUser loadSecUserWithEmail(RetailscmUserContext userContext, String email, Map<String,Object>tokens) throws Exception;

	 


	public SecUser loadSecUserWithMobile(RetailscmUserContext userContext, String mobile, Map<String,Object>tokens) throws Exception;

	 

	public SecUser createSecUser(RetailscmUserContext userContext, String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime,String domainId) throws Exception;
	public SecUser updateSecUser(RetailscmUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUser loadSecUser(RetailscmUserContext userContext, String secUserId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public SecUser internalSaveSecUser(RetailscmUserContext userContext, SecUser secUser) throws Exception;
	public SecUser internalSaveSecUser(RetailscmUserContext userContext, SecUser secUser,Map<String,Object>option) throws Exception;

	public SecUser transferToAnotherDomain(RetailscmUserContext userContext, String secUserId, String anotherDomainId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String secUserId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SecUser newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  UserAppManager getUserAppManager(RetailscmUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location ,String [] tokensExpr)  throws Exception;

	public  SecUser addUserApp(RetailscmUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location , String [] tokensExpr)  throws Exception;
	public  SecUser removeUserApp(RetailscmUserContext userContext, String secUserId, String userAppId, int userAppVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateUserApp(RetailscmUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LoginHistoryManager getLoginHistoryManager(RetailscmUserContext userContext, String secUserId, String fromIp, String description ,String [] tokensExpr)  throws Exception;

	public  SecUser addLoginHistory(RetailscmUserContext userContext, String secUserId, String fromIp, String description , String [] tokensExpr)  throws Exception;
	public  SecUser removeLoginHistory(RetailscmUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateLoginHistory(RetailscmUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatWorkappIdentityManager getWechatWorkappIdentityManager(RetailscmUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  SecUser addWechatWorkappIdentity(RetailscmUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatWorkappIdentity(RetailscmUserContext userContext, String secUserId, String wechatWorkappIdentityId, int wechatWorkappIdentityVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatWorkappIdentity(RetailscmUserContext userContext, String secUserId, String wechatWorkappIdentityId, int wechatWorkappIdentityVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatMiniappIdentityManager getWechatMiniappIdentityManager(RetailscmUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;

	public  SecUser addWechatMiniappIdentity(RetailscmUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatMiniappIdentity(RetailscmUserContext userContext, String secUserId, String wechatMiniappIdentityId, int wechatMiniappIdentityVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatMiniappIdentity(RetailscmUserContext userContext, String secUserId, String wechatMiniappIdentityId, int wechatMiniappIdentityVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  KeypairIdentityManager getKeypairIdentityManager(RetailscmUserContext userContext, String secUserId, String publicKey, String keyTypeId ,String [] tokensExpr)  throws Exception;

	public  SecUser addKeypairIdentity(RetailscmUserContext userContext, String secUserId, String publicKey, String keyTypeId , String [] tokensExpr)  throws Exception;
	public  SecUser removeKeypairIdentity(RetailscmUserContext userContext, String secUserId, String keypairIdentityId, int keypairIdentityVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateKeypairIdentity(RetailscmUserContext userContext, String secUserId, String keypairIdentityId, int keypairIdentityVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDomain(RetailscmUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(RetailscmUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


