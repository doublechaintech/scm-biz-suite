package com.doublechaintech.retailscm.supplyorderlineitem;

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

public interface SupplyOrderLineItemManager extends BaseManager {

  List<SupplyOrderLineItem> searchSupplyOrderLineItemList(
      RetailscmUserContext ctx, SupplyOrderLineItemRequest pRequest);

  SupplyOrderLineItem searchSupplyOrderLineItem(
      RetailscmUserContext ctx, SupplyOrderLineItemRequest pRequest);

  public SupplyOrderLineItem createSupplyOrderLineItem(
      RetailscmUserContext userContext,
      String bizOrderId,
      String skuId,
      String skuName,
      BigDecimal amount,
      int quantity,
      String unitOfMeasurement)
      throws Exception;

  public SupplyOrderLineItem updateSupplyOrderLineItem(
      RetailscmUserContext userContext,
      String supplyOrderLineItemId,
      int supplyOrderLineItemVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public SupplyOrderLineItem loadSupplyOrderLineItem(
      RetailscmUserContext userContext, String supplyOrderLineItemId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public SupplyOrderLineItem internalSaveSupplyOrderLineItem(
      RetailscmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem) throws Exception;

  public SupplyOrderLineItem internalSaveSupplyOrderLineItem(
      RetailscmUserContext userContext,
      SupplyOrderLineItem supplyOrderLineItem,
      Map<String, Object> option)
      throws Exception;

  public SupplyOrderLineItem transferToAnotherBizOrder(
      RetailscmUserContext userContext, String supplyOrderLineItemId, String anotherBizOrderId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderLineItem newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext,
      SupplyOrderLineItem updated,
      Object actor,
      String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByBizOrder(RetailscmUserContext userContext, String bizOrderId)
      throws Exception;

  public Object listPageByBizOrder(
      RetailscmUserContext userContext, String bizOrderId, int start, int count) throws Exception;
}
