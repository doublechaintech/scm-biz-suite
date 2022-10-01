package com.doublechaintech.retailscm.userdomain;

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

public interface UserDomainManager extends BaseManager {

  List<UserDomain> searchUserDomainList(RetailscmUserContext ctx, UserDomainRequest pRequest);

  UserDomain searchUserDomain(RetailscmUserContext ctx, UserDomainRequest pRequest);

  public UserDomain createUserDomain(RetailscmUserContext userContext, String name)
      throws Exception;

  public UserDomain updateUserDomain(
      RetailscmUserContext userContext,
      String userDomainId,
      int userDomainVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public UserDomain loadUserDomain(
      RetailscmUserContext userContext, String userDomainId, String[] tokensExpr) throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public UserDomain internalSaveUserDomain(RetailscmUserContext userContext, UserDomain userDomain)
      throws Exception;

  public UserDomain internalSaveUserDomain(
      RetailscmUserContext userContext, UserDomain userDomain, Map<String, Object> option)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, UserDomain newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, UserDomain updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  UserAllowListManager getUserAllowListManager(RetailscmUserContext userContext, String
  // userDomainId, String userIdentity, String userSpecialFunctions ,String [] tokensExpr)  throws
  // Exception;

  public UserDomain addUserAllowList(
      RetailscmUserContext userContext,
      String userDomainId,
      String userIdentity,
      String userSpecialFunctions,
      String[] tokensExpr)
      throws Exception;

  public UserDomain removeUserAllowList(
      RetailscmUserContext userContext,
      String userDomainId,
      String userAllowListId,
      int userAllowListVersion,
      String[] tokensExpr)
      throws Exception;

  public UserDomain updateUserAllowList(
      RetailscmUserContext userContext,
      String userDomainId,
      String userAllowListId,
      int userAllowListVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  // public  SecUserManager getSecUserManager(RetailscmUserContext userContext, String userDomainId,
  // String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid,
  // String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime
  // lastLoginTime ,String [] tokensExpr)  throws Exception;

  public UserDomain addSecUser(
      RetailscmUserContext userContext,
      String userDomainId,
      String login,
      String mobile,
      String email,
      String pwd,
      String weixinOpenid,
      String weixinAppid,
      String accessToken,
      int verificationCode,
      DateTime verificationCodeExpire,
      DateTime lastLoginTime,
      String[] tokensExpr)
      throws Exception;

  public UserDomain removeSecUser(
      RetailscmUserContext userContext,
      String userDomainId,
      String secUserId,
      int secUserVersion,
      String[] tokensExpr)
      throws Exception;

  public UserDomain updateSecUser(
      RetailscmUserContext userContext,
      String userDomainId,
      String secUserId,
      int secUserVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  // public  PublicKeyTypeManager getPublicKeyTypeManager(RetailscmUserContext userContext, String
  // userDomainId, String keyAlg, String signAlg ,String [] tokensExpr)  throws Exception;

  public UserDomain addPublicKeyType(
      RetailscmUserContext userContext,
      String userDomainId,
      String keyAlg,
      String signAlg,
      String[] tokensExpr)
      throws Exception;

  public UserDomain removePublicKeyType(
      RetailscmUserContext userContext,
      String userDomainId,
      String publicKeyTypeId,
      int publicKeyTypeVersion,
      String[] tokensExpr)
      throws Exception;

  public UserDomain updatePublicKeyType(
      RetailscmUserContext userContext,
      String userDomainId,
      String publicKeyTypeId,
      int publicKeyTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

}
