package com.doublechaintech.retailscm.goodsshelfstockcount;

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

public interface GoodsShelfStockCountManager extends BaseManager {

  List<GoodsShelfStockCount> searchGoodsShelfStockCountList(
      RetailscmUserContext ctx, GoodsShelfStockCountRequest pRequest);

  GoodsShelfStockCount searchGoodsShelfStockCount(
      RetailscmUserContext ctx, GoodsShelfStockCountRequest pRequest);

  public GoodsShelfStockCount createGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String title,
      Date countTime,
      String summary,
      String shelfId)
      throws Exception;

  public GoodsShelfStockCount updateGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public GoodsShelfStockCount loadGoodsShelfStockCount(
      RetailscmUserContext userContext, String goodsShelfStockCountId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public GoodsShelfStockCount internalSaveGoodsShelfStockCount(
      RetailscmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount) throws Exception;

  public GoodsShelfStockCount internalSaveGoodsShelfStockCount(
      RetailscmUserContext userContext,
      GoodsShelfStockCount goodsShelfStockCount,
      Map<String, Object> option)
      throws Exception;

  public GoodsShelfStockCount transferToAnotherShelf(
      RetailscmUserContext userContext, String goodsShelfStockCountId, String anotherShelfId)
      throws Exception;

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, GoodsShelfStockCount newCreated) throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext,
      GoodsShelfStockCount updated,
      Object actor,
      String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  StockCountIssueTrackManager getStockCountIssueTrackManager(RetailscmUserContext
  // userContext, String goodsShelfStockCountId, String title, Date countTime, String summary
  // ,String [] tokensExpr)  throws Exception;

  public GoodsShelfStockCount addStockCountIssueTrack(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String title,
      Date countTime,
      String summary,
      String[] tokensExpr)
      throws Exception;

  public GoodsShelfStockCount removeStockCountIssueTrack(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String stockCountIssueTrackId,
      int stockCountIssueTrackVersion,
      String[] tokensExpr)
      throws Exception;

  public GoodsShelfStockCount updateStockCountIssueTrack(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String stockCountIssueTrackId,
      int stockCountIssueTrackVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  public Object listByShelf(RetailscmUserContext userContext, String shelfId) throws Exception;

  public Object listPageByShelf(
      RetailscmUserContext userContext, String shelfId, int start, int count) throws Exception;
}
