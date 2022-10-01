package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;

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

public interface RetailStoreMemberGiftCardConsumeRecordManager extends BaseManager {

  List<RetailStoreMemberGiftCardConsumeRecord> searchRetailStoreMemberGiftCardConsumeRecordList(
      RetailscmUserContext ctx, RetailStoreMemberGiftCardConsumeRecordRequest pRequest);

  RetailStoreMemberGiftCardConsumeRecord searchRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext ctx, RetailStoreMemberGiftCardConsumeRecordRequest pRequest);

  public RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      Date occureTime,
      String ownerId,
      String bizOrderId,
      String number,
      BigDecimal amount)
      throws Exception;

  public RetailStoreMemberGiftCardConsumeRecord updateRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public RetailStoreMemberGiftCardConsumeRecord loadRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardConsumeRecordId,
      String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public RetailStoreMemberGiftCardConsumeRecord internalSaveRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord)
      throws Exception;

  public RetailStoreMemberGiftCardConsumeRecord internalSaveRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,
      Map<String, Object> option)
      throws Exception;

  public RetailStoreMemberGiftCardConsumeRecord transferToAnotherOwner(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardConsumeRecordId,
      String anotherOwnerId)
      throws Exception;

  public RetailStoreMemberGiftCardConsumeRecord transferToAnotherBizOrder(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardConsumeRecordId,
      String anotherBizOrderId)
      throws Exception;

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCardConsumeRecord updated,
      Object actor,
      String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByOwner(RetailscmUserContext userContext, String ownerId) throws Exception;

  public Object listPageByOwner(
      RetailscmUserContext userContext, String ownerId, int start, int count) throws Exception;

  public Object listByBizOrder(RetailscmUserContext userContext, String bizOrderId)
      throws Exception;

  public Object listPageByBizOrder(
      RetailscmUserContext userContext, String bizOrderId, int start, int count) throws Exception;
}
