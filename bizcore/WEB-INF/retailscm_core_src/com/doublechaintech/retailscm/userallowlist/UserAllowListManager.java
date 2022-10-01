package com.doublechaintech.retailscm.userallowlist;

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

public interface UserAllowListManager extends BaseManager {

  List<UserAllowList> searchUserAllowListList(
      RetailscmUserContext ctx, UserAllowListRequest pRequest);

  UserAllowList searchUserAllowList(RetailscmUserContext ctx, UserAllowListRequest pRequest);

  public UserAllowList createUserAllowList(
      RetailscmUserContext userContext,
      String userIdentity,
      String userSpecialFunctions,
      String domainId)
      throws Exception;

  public UserAllowList updateUserAllowList(
      RetailscmUserContext userContext,
      String userAllowListId,
      int userAllowListVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public UserAllowList loadUserAllowList(
      RetailscmUserContext userContext, String userAllowListId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public UserAllowList internalSaveUserAllowList(
      RetailscmUserContext userContext, UserAllowList userAllowList) throws Exception;

  public UserAllowList internalSaveUserAllowList(
      RetailscmUserContext userContext, UserAllowList userAllowList, Map<String, Object> option)
      throws Exception;

  public UserAllowList transferToAnotherDomain(
      RetailscmUserContext userContext, String userAllowListId, String anotherDomainId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, UserAllowList newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, UserAllowList updated, Object actor, String methodName)
      throws Exception {};

  public UserAllowList updateUserRole(
      RetailscmUserContext ctx, String userIdentity, String roleName, boolean add) throws Exception;

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByDomain(RetailscmUserContext userContext, String domainId) throws Exception;

  public Object listPageByDomain(
      RetailscmUserContext userContext, String domainId, int start, int count) throws Exception;
}
