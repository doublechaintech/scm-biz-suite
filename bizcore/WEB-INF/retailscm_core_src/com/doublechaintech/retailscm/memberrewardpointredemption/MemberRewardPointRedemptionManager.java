package com.doublechaintech.retailscm.memberrewardpointredemption;

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

public interface MemberRewardPointRedemptionManager extends BaseManager {

  List<MemberRewardPointRedemption> searchMemberRewardPointRedemptionList(
      RetailscmUserContext ctx, MemberRewardPointRedemptionRequest pRequest);

  MemberRewardPointRedemption searchMemberRewardPointRedemption(
      RetailscmUserContext ctx, MemberRewardPointRedemptionRequest pRequest);

  public MemberRewardPointRedemption createMemberRewardPointRedemption(
      RetailscmUserContext userContext, String name, int point, String ownerId) throws Exception;

  public MemberRewardPointRedemption updateMemberRewardPointRedemption(
      RetailscmUserContext userContext,
      String memberRewardPointRedemptionId,
      int memberRewardPointRedemptionVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public MemberRewardPointRedemption loadMemberRewardPointRedemption(
      RetailscmUserContext userContext, String memberRewardPointRedemptionId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public MemberRewardPointRedemption internalSaveMemberRewardPointRedemption(
      RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption)
      throws Exception;

  public MemberRewardPointRedemption internalSaveMemberRewardPointRedemption(
      RetailscmUserContext userContext,
      MemberRewardPointRedemption memberRewardPointRedemption,
      Map<String, Object> option)
      throws Exception;

  public MemberRewardPointRedemption transferToAnotherOwner(
      RetailscmUserContext userContext, String memberRewardPointRedemptionId, String anotherOwnerId)
      throws Exception;

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, MemberRewardPointRedemption newCreated) throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext,
      MemberRewardPointRedemption updated,
      Object actor,
      String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByOwner(RetailscmUserContext userContext, String ownerId) throws Exception;

  public Object listPageByOwner(
      RetailscmUserContext userContext, String ownerId, int start, int count) throws Exception;
}
