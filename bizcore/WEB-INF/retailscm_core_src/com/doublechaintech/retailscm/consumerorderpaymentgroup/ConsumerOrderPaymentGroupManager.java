package com.doublechaintech.retailscm.consumerorderpaymentgroup;

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

public interface ConsumerOrderPaymentGroupManager extends BaseManager {

  List<ConsumerOrderPaymentGroup> searchConsumerOrderPaymentGroupList(
      RetailscmUserContext ctx, ConsumerOrderPaymentGroupRequest pRequest);

  ConsumerOrderPaymentGroup searchConsumerOrderPaymentGroup(
      RetailscmUserContext ctx, ConsumerOrderPaymentGroupRequest pRequest);

  public ConsumerOrderPaymentGroup createConsumerOrderPaymentGroup(
      RetailscmUserContext userContext, String name, String bizOrderId, String cardNumber)
      throws Exception;

  public ConsumerOrderPaymentGroup updateConsumerOrderPaymentGroup(
      RetailscmUserContext userContext,
      String consumerOrderPaymentGroupId,
      int consumerOrderPaymentGroupVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public ConsumerOrderPaymentGroup loadConsumerOrderPaymentGroup(
      RetailscmUserContext userContext, String consumerOrderPaymentGroupId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public ConsumerOrderPaymentGroup internalSaveConsumerOrderPaymentGroup(
      RetailscmUserContext userContext, ConsumerOrderPaymentGroup consumerOrderPaymentGroup)
      throws Exception;

  public ConsumerOrderPaymentGroup internalSaveConsumerOrderPaymentGroup(
      RetailscmUserContext userContext,
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup,
      Map<String, Object> option)
      throws Exception;

  public ConsumerOrderPaymentGroup transferToAnotherBizOrder(
      RetailscmUserContext userContext,
      String consumerOrderPaymentGroupId,
      String anotherBizOrderId)
      throws Exception;

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, ConsumerOrderPaymentGroup newCreated) throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext,
      ConsumerOrderPaymentGroup updated,
      Object actor,
      String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByBizOrder(RetailscmUserContext userContext, String bizOrderId)
      throws Exception;

  public Object listPageByBizOrder(
      RetailscmUserContext userContext, String bizOrderId, int start, int count) throws Exception;
}
