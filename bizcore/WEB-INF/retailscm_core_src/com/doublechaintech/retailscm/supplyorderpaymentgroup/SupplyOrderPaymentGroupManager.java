package com.doublechaintech.retailscm.supplyorderpaymentgroup;

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

public interface SupplyOrderPaymentGroupManager extends BaseManager {

  List<SupplyOrderPaymentGroup> searchSupplyOrderPaymentGroupList(
      RetailscmUserContext ctx, SupplyOrderPaymentGroupRequest pRequest);

  SupplyOrderPaymentGroup searchSupplyOrderPaymentGroup(
      RetailscmUserContext ctx, SupplyOrderPaymentGroupRequest pRequest);

  public SupplyOrderPaymentGroup createSupplyOrderPaymentGroup(
      RetailscmUserContext userContext, String name, String bizOrderId, String cardNumber)
      throws Exception;

  public SupplyOrderPaymentGroup updateSupplyOrderPaymentGroup(
      RetailscmUserContext userContext,
      String supplyOrderPaymentGroupId,
      int supplyOrderPaymentGroupVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public SupplyOrderPaymentGroup loadSupplyOrderPaymentGroup(
      RetailscmUserContext userContext, String supplyOrderPaymentGroupId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public SupplyOrderPaymentGroup internalSaveSupplyOrderPaymentGroup(
      RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup)
      throws Exception;

  public SupplyOrderPaymentGroup internalSaveSupplyOrderPaymentGroup(
      RetailscmUserContext userContext,
      SupplyOrderPaymentGroup supplyOrderPaymentGroup,
      Map<String, Object> option)
      throws Exception;

  public SupplyOrderPaymentGroup transferToAnotherBizOrder(
      RetailscmUserContext userContext, String supplyOrderPaymentGroupId, String anotherBizOrderId)
      throws Exception;

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, SupplyOrderPaymentGroup newCreated) throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext,
      SupplyOrderPaymentGroup updated,
      Object actor,
      String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByBizOrder(RetailscmUserContext userContext, String bizOrderId)
      throws Exception;

  public Object listPageByBizOrder(
      RetailscmUserContext userContext, String bizOrderId, int start, int count) throws Exception;
}
