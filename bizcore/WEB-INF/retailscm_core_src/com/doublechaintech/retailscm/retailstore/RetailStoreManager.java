package com.doublechaintech.retailscm.retailstore;

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

public interface RetailStoreManager extends BaseManager {

  List<RetailStore> searchRetailStoreList(RetailscmUserContext ctx, RetailStoreRequest pRequest);

  RetailStore searchRetailStore(RetailscmUserContext ctx, RetailStoreRequest pRequest);

  public RetailStore createRetailStore(
      RetailscmUserContext userContext,
      String name,
      String telephone,
      String owner,
      String retailStoreCountryCenterId,
      String cityServiceCenterId,
      String creationId,
      String investmentInvitationId,
      String franchisingId,
      String decorationId,
      String openingId,
      String closingId,
      Date founded,
      BigDecimal latitude,
      BigDecimal longitude,
      String description)
      throws Exception;

  public RetailStore updateRetailStore(
      RetailscmUserContext userContext,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public RetailStore loadRetailStore(
      RetailscmUserContext userContext, String retailStoreId, String[] tokensExpr) throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public RetailStore internalSaveRetailStore(
      RetailscmUserContext userContext, RetailStore retailStore) throws Exception;

  public RetailStore internalSaveRetailStore(
      RetailscmUserContext userContext, RetailStore retailStore, Map<String, Object> option)
      throws Exception;

  public RetailStore transferToAnotherRetailStoreCountryCenter(
      RetailscmUserContext userContext,
      String retailStoreId,
      String anotherRetailStoreCountryCenterId)
      throws Exception;

  public RetailStore transferToAnotherCityServiceCenter(
      RetailscmUserContext userContext, String retailStoreId, String anotherCityServiceCenterId)
      throws Exception;

  public RetailStore transferToAnotherCreation(
      RetailscmUserContext userContext, String retailStoreId, String anotherCreationId)
      throws Exception;

  public RetailStore transferToAnotherInvestmentInvitation(
      RetailscmUserContext userContext, String retailStoreId, String anotherInvestmentInvitationId)
      throws Exception;

  public RetailStore transferToAnotherFranchising(
      RetailscmUserContext userContext, String retailStoreId, String anotherFranchisingId)
      throws Exception;

  public RetailStore transferToAnotherDecoration(
      RetailscmUserContext userContext, String retailStoreId, String anotherDecorationId)
      throws Exception;

  public RetailStore transferToAnotherOpening(
      RetailscmUserContext userContext, String retailStoreId, String anotherOpeningId)
      throws Exception;

  public RetailStore transferToAnotherClosing(
      RetailscmUserContext userContext, String retailStoreId, String anotherClosingId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStore newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, RetailStore updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String
  // retailStoreId, String title, String consumerId ,String [] tokensExpr)  throws Exception;

  public RetailStore addConsumerOrder(
      RetailscmUserContext userContext,
      String retailStoreId,
      String title,
      String consumerId,
      String[] tokensExpr)
      throws Exception;

  public RetailStore removeConsumerOrder(
      RetailscmUserContext userContext,
      String retailStoreId,
      String consumerOrderId,
      int consumerOrderVersion,
      String[] tokensExpr)
      throws Exception;

  public RetailStore updateConsumerOrder(
      RetailscmUserContext userContext,
      String retailStoreId,
      String consumerOrderId,
      int consumerOrderVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  // public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext,
  // String retailStoreId, String sellerId, String title, BigDecimal totalAmount, String contract
  // ,String [] tokensExpr)  throws Exception;

  public RetailStore addRetailStoreOrder(
      RetailscmUserContext userContext,
      String retailStoreId,
      String sellerId,
      String title,
      BigDecimal totalAmount,
      String contract,
      String[] tokensExpr)
      throws Exception;

  public RetailStore removeRetailStoreOrder(
      RetailscmUserContext userContext,
      String retailStoreId,
      String retailStoreOrderId,
      int retailStoreOrderVersion,
      String[] tokensExpr)
      throws Exception;

  public RetailStore updateRetailStoreOrder(
      RetailscmUserContext userContext,
      String retailStoreId,
      String retailStoreOrderId,
      int retailStoreOrderVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  // public  GoodsManager getGoodsManager(RetailscmUserContext userContext, String retailStoreId,
  // String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String
  // receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId,
  // String transportTaskId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)
  // throws Exception;

  public RetailStore addGoods(
      RetailscmUserContext userContext,
      String retailStoreId,
      String name,
      String rfid,
      String uom,
      int maxPackage,
      Date expireTime,
      String skuId,
      String receivingSpaceId,
      String goodsAllocationId,
      String smartPalletId,
      String shippingSpaceId,
      String transportTaskId,
      String bizOrderId,
      String retailStoreOrderId,
      String[] tokensExpr)
      throws Exception;

  public RetailStore removeGoods(
      RetailscmUserContext userContext,
      String retailStoreId,
      String goodsId,
      int goodsVersion,
      String[] tokensExpr)
      throws Exception;

  public RetailStore updateGoods(
      RetailscmUserContext userContext,
      String retailStoreId,
      String goodsId,
      int goodsVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  // public  TransportTaskManager getTransportTaskManager(RetailscmUserContext userContext, String
  // retailStoreId, String name, String start, Date beginTime, String driverId, String truckId,
  // String belongsToId, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws
  // Exception;

  public RetailStore addTransportTask(
      RetailscmUserContext userContext,
      String retailStoreId,
      String name,
      String start,
      Date beginTime,
      String driverId,
      String truckId,
      String belongsToId,
      BigDecimal latitude,
      BigDecimal longitude,
      String[] tokensExpr)
      throws Exception;

  public RetailStore removeTransportTask(
      RetailscmUserContext userContext,
      String retailStoreId,
      String transportTaskId,
      int transportTaskVersion,
      String[] tokensExpr)
      throws Exception;

  public RetailStore updateTransportTask(
      RetailscmUserContext userContext,
      String retailStoreId,
      String transportTaskId,
      int transportTaskVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  // public  AccountSetManager getAccountSetManager(RetailscmUserContext userContext, String
  // retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String
  // domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber,
  // String countryCenterId, String goodsSupplierId ,String [] tokensExpr)  throws Exception;

  public RetailStore addAccountSet(
      RetailscmUserContext userContext,
      String retailStoreId,
      String name,
      String yearSet,
      Date effectiveDate,
      String accountingSystem,
      String domesticCurrencyCode,
      String domesticCurrencyName,
      String openingBank,
      String accountNumber,
      String countryCenterId,
      String goodsSupplierId,
      String[] tokensExpr)
      throws Exception;

  public RetailStore removeAccountSet(
      RetailscmUserContext userContext,
      String retailStoreId,
      String accountSetId,
      int accountSetVersion,
      String[] tokensExpr)
      throws Exception;

  public RetailStore updateAccountSet(
      RetailscmUserContext userContext,
      String retailStoreId,
      String accountSetId,
      int accountSetVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  public Object listByRetailStoreCountryCenter(
      RetailscmUserContext userContext, String retailStoreCountryCenterId) throws Exception;

  public Object listPageByRetailStoreCountryCenter(
      RetailscmUserContext userContext, String retailStoreCountryCenterId, int start, int count)
      throws Exception;

  public Object listByCityServiceCenter(
      RetailscmUserContext userContext, String cityServiceCenterId) throws Exception;

  public Object listPageByCityServiceCenter(
      RetailscmUserContext userContext, String cityServiceCenterId, int start, int count)
      throws Exception;

  public Object listByCreation(RetailscmUserContext userContext, String creationId)
      throws Exception;

  public Object listPageByCreation(
      RetailscmUserContext userContext, String creationId, int start, int count) throws Exception;

  public Object listByInvestmentInvitation(
      RetailscmUserContext userContext, String investmentInvitationId) throws Exception;

  public Object listPageByInvestmentInvitation(
      RetailscmUserContext userContext, String investmentInvitationId, int start, int count)
      throws Exception;

  public Object listByFranchising(RetailscmUserContext userContext, String franchisingId)
      throws Exception;

  public Object listPageByFranchising(
      RetailscmUserContext userContext, String franchisingId, int start, int count)
      throws Exception;

  public Object listByDecoration(RetailscmUserContext userContext, String decorationId)
      throws Exception;

  public Object listPageByDecoration(
      RetailscmUserContext userContext, String decorationId, int start, int count) throws Exception;

  public Object listByOpening(RetailscmUserContext userContext, String openingId) throws Exception;

  public Object listPageByOpening(
      RetailscmUserContext userContext, String openingId, int start, int count) throws Exception;

  public Object listByClosing(RetailscmUserContext userContext, String closingId) throws Exception;

  public Object listPageByClosing(
      RetailscmUserContext userContext, String closingId, int start, int count) throws Exception;
}
