package com.doublechaintech.retailscm.retailstoreclosing;

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

public interface RetailStoreClosingManager extends BaseManager {

  List<RetailStoreClosing> searchRetailStoreClosingList(
      RetailscmUserContext ctx, RetailStoreClosingRequest pRequest);

  RetailStoreClosing searchRetailStoreClosing(
      RetailscmUserContext ctx, RetailStoreClosingRequest pRequest);

  public RetailStoreClosing createRetailStoreClosing(
      RetailscmUserContext userContext, String comment) throws Exception;

  public RetailStoreClosing updateRetailStoreClosing(
      RetailscmUserContext userContext,
      String retailStoreClosingId,
      int retailStoreClosingVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public RetailStoreClosing loadRetailStoreClosing(
      RetailscmUserContext userContext, String retailStoreClosingId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public RetailStoreClosing internalSaveRetailStoreClosing(
      RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing) throws Exception;

  public RetailStoreClosing internalSaveRetailStoreClosing(
      RetailscmUserContext userContext,
      RetailStoreClosing retailStoreClosing,
      Map<String, Object> option)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreClosing newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, RetailStoreClosing updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  RetailStoreManager getRetailStoreManager(RetailscmUserContext userContext, String
  // retailStoreClosingId, String name, String telephone, String owner, String
  // retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String
  // investmentInvitationId, String franchisingId, String decorationId, String openingId, Date
  // founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)
  // throws Exception;

  public RetailStoreClosing addRetailStore(
      RetailscmUserContext userContext,
      String retailStoreClosingId,
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
      Date founded,
      BigDecimal latitude,
      BigDecimal longitude,
      String description,
      String[] tokensExpr)
      throws Exception;

  public RetailStoreClosing removeRetailStore(
      RetailscmUserContext userContext,
      String retailStoreClosingId,
      String retailStoreId,
      int retailStoreVersion,
      String[] tokensExpr)
      throws Exception;

  public RetailStoreClosing updateRetailStore(
      RetailscmUserContext userContext,
      String retailStoreClosingId,
      String retailStoreId,
      int retailStoreVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

}
