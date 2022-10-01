package com.doublechaintech.retailscm.retailstoremembergiftcard;

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

public interface RetailStoreMemberGiftCardManager extends BaseManager {

  List<RetailStoreMemberGiftCard> searchRetailStoreMemberGiftCardList(
      RetailscmUserContext ctx, RetailStoreMemberGiftCardRequest pRequest);

  RetailStoreMemberGiftCard searchRetailStoreMemberGiftCard(
      RetailscmUserContext ctx, RetailStoreMemberGiftCardRequest pRequest);

  public RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(
      RetailscmUserContext userContext,
      String name,
      String ownerId,
      String number,
      BigDecimal remain)
      throws Exception;

  public RetailStoreMemberGiftCard updateRetailStoreMemberGiftCard(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      int retailStoreMemberGiftCardVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public RetailStoreMemberGiftCard loadRetailStoreMemberGiftCard(
      RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public RetailStoreMemberGiftCard internalSaveRetailStoreMemberGiftCard(
      RetailscmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard)
      throws Exception;

  public RetailStoreMemberGiftCard internalSaveRetailStoreMemberGiftCard(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCard retailStoreMemberGiftCard,
      Map<String, Object> option)
      throws Exception;

  public RetailStoreMemberGiftCard transferToAnotherOwner(
      RetailscmUserContext userContext, String retailStoreMemberGiftCardId, String anotherOwnerId)
      throws Exception;

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, RetailStoreMemberGiftCard newCreated) throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext,
      RetailStoreMemberGiftCard updated,
      Object actor,
      String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  RetailStoreMemberGiftCardConsumeRecordManager
  // getRetailStoreMemberGiftCardConsumeRecordManager(RetailscmUserContext userContext, String
  // retailStoreMemberGiftCardId, Date occureTime, String bizOrderId, String number, BigDecimal
  // amount ,String [] tokensExpr)  throws Exception;

  public RetailStoreMemberGiftCard addRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      Date occureTime,
      String bizOrderId,
      String number,
      BigDecimal amount,
      String[] tokensExpr)
      throws Exception;

  public RetailStoreMemberGiftCard removeRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String[] tokensExpr)
      throws Exception;

  public RetailStoreMemberGiftCard updateRetailStoreMemberGiftCardConsumeRecord(
      RetailscmUserContext userContext,
      String retailStoreMemberGiftCardId,
      String retailStoreMemberGiftCardConsumeRecordId,
      int retailStoreMemberGiftCardConsumeRecordVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  public Object listByOwner(RetailscmUserContext userContext, String ownerId) throws Exception;

  public Object listPageByOwner(
      RetailscmUserContext userContext, String ownerId, int start, int count) throws Exception;
}
