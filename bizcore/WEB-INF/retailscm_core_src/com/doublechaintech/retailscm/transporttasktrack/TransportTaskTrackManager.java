package com.doublechaintech.retailscm.transporttasktrack;

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

public interface TransportTaskTrackManager extends BaseManager {

  List<TransportTaskTrack> searchTransportTaskTrackList(
      RetailscmUserContext ctx, TransportTaskTrackRequest pRequest);

  TransportTaskTrack searchTransportTaskTrack(
      RetailscmUserContext ctx, TransportTaskTrackRequest pRequest);

  public TransportTaskTrack createTransportTaskTrack(
      RetailscmUserContext userContext,
      Date trackTime,
      BigDecimal latitude,
      BigDecimal longitude,
      String movementId)
      throws Exception;

  public TransportTaskTrack updateTransportTaskTrack(
      RetailscmUserContext userContext,
      String transportTaskTrackId,
      int transportTaskTrackVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public TransportTaskTrack loadTransportTaskTrack(
      RetailscmUserContext userContext, String transportTaskTrackId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public TransportTaskTrack internalSaveTransportTaskTrack(
      RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception;

  public TransportTaskTrack internalSaveTransportTaskTrack(
      RetailscmUserContext userContext,
      TransportTaskTrack transportTaskTrack,
      Map<String, Object> option)
      throws Exception;

  public TransportTaskTrack transferToAnotherMovement(
      RetailscmUserContext userContext, String transportTaskTrackId, String anotherMovementId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, TransportTaskTrack newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, TransportTaskTrack updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByMovement(RetailscmUserContext userContext, String movementId)
      throws Exception;

  public Object listPageByMovement(
      RetailscmUserContext userContext, String movementId, int start, int count) throws Exception;
}
