package com.doublechaintech.retailscm.keypairidentity;

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

public interface KeyPairIdentityManager extends BaseManager {

  List<KeyPairIdentity> searchKeyPairIdentityList(
      RetailscmUserContext ctx, KeyPairIdentityRequest pRequest);

  KeyPairIdentity searchKeyPairIdentity(RetailscmUserContext ctx, KeyPairIdentityRequest pRequest);

  public KeyPairIdentity createKeyPairIdentity(
      RetailscmUserContext userContext, String publicKey, String keyTypeId, String secUserId)
      throws Exception;

  public KeyPairIdentity updateKeyPairIdentity(
      RetailscmUserContext userContext,
      String keyPairIdentityId,
      int keyPairIdentityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public KeyPairIdentity loadKeyPairIdentity(
      RetailscmUserContext userContext, String keyPairIdentityId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public KeyPairIdentity internalSaveKeyPairIdentity(
      RetailscmUserContext userContext, KeyPairIdentity keyPairIdentity) throws Exception;

  public KeyPairIdentity internalSaveKeyPairIdentity(
      RetailscmUserContext userContext, KeyPairIdentity keyPairIdentity, Map<String, Object> option)
      throws Exception;

  public KeyPairIdentity transferToAnotherKeyType(
      RetailscmUserContext userContext, String keyPairIdentityId, String anotherKeyTypeId)
      throws Exception;

  public KeyPairIdentity transferToAnotherSecUser(
      RetailscmUserContext userContext, String keyPairIdentityId, String anotherSecUserId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, KeyPairIdentity newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, KeyPairIdentity updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByKeyType(RetailscmUserContext userContext, String keyTypeId) throws Exception;

  public Object listPageByKeyType(
      RetailscmUserContext userContext, String keyTypeId, int start, int count) throws Exception;

  public Object listBySecUser(RetailscmUserContext userContext, String secUserId) throws Exception;

  public Object listPageBySecUser(
      RetailscmUserContext userContext, String secUserId, int start, int count) throws Exception;
}
