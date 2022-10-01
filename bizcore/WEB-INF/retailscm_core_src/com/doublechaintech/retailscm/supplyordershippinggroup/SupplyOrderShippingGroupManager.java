package com.doublechaintech.retailscm.supplyordershippinggroup;

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

public interface SupplyOrderShippingGroupManager extends BaseManager {

  List<SupplyOrderShippingGroup> searchSupplyOrderShippingGroupList(
      RetailscmUserContext ctx, SupplyOrderShippingGroupRequest pRequest);

  SupplyOrderShippingGroup searchSupplyOrderShippingGroup(
      RetailscmUserContext ctx, SupplyOrderShippingGroupRequest pRequest);

  public SupplyOrderShippingGroup createSupplyOrderShippingGroup(
      RetailscmUserContext userContext, String name, String bizOrderId, BigDecimal amount)
      throws Exception;

  public SupplyOrderShippingGroup updateSupplyOrderShippingGroup(
      RetailscmUserContext userContext,
      String supplyOrderShippingGroupId,
      int supplyOrderShippingGroupVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public SupplyOrderShippingGroup loadSupplyOrderShippingGroup(
      RetailscmUserContext userContext, String supplyOrderShippingGroupId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public SupplyOrderShippingGroup internalSaveSupplyOrderShippingGroup(
      RetailscmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup)
      throws Exception;

  public SupplyOrderShippingGroup internalSaveSupplyOrderShippingGroup(
      RetailscmUserContext userContext,
      SupplyOrderShippingGroup supplyOrderShippingGroup,
      Map<String, Object> option)
      throws Exception;

  public SupplyOrderShippingGroup transferToAnotherBizOrder(
      RetailscmUserContext userContext, String supplyOrderShippingGroupId, String anotherBizOrderId)
      throws Exception;

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, SupplyOrderShippingGroup newCreated) throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext,
      SupplyOrderShippingGroup updated,
      Object actor,
      String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByBizOrder(RetailscmUserContext userContext, String bizOrderId)
      throws Exception;

  public Object listPageByBizOrder(
      RetailscmUserContext userContext, String bizOrderId, int start, int count) throws Exception;
}
