package com.doublechaintech.retailscm.transporttruck;

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

public interface TransportTruckManager extends BaseManager {

  List<TransportTruck> searchTransportTruckList(
      RetailscmUserContext ctx, TransportTruckRequest pRequest);

  TransportTruck searchTransportTruck(RetailscmUserContext ctx, TransportTruckRequest pRequest);

  public TransportTruck createTransportTruck(
      RetailscmUserContext userContext,
      String name,
      String plateNumber,
      String contactNumber,
      String vehicleLicenseNumber,
      String engineNumber,
      Date makeDate,
      String mileage,
      String bodyColor,
      String ownerId)
      throws Exception;

  public TransportTruck updateTransportTruck(
      RetailscmUserContext userContext,
      String transportTruckId,
      int transportTruckVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public TransportTruck loadTransportTruck(
      RetailscmUserContext userContext, String transportTruckId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public TransportTruck internalSaveTransportTruck(
      RetailscmUserContext userContext, TransportTruck transportTruck) throws Exception;

  public TransportTruck internalSaveTransportTruck(
      RetailscmUserContext userContext, TransportTruck transportTruck, Map<String, Object> option)
      throws Exception;

  public TransportTruck transferToAnotherOwner(
      RetailscmUserContext userContext, String transportTruckId, String anotherOwnerId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, TransportTruck newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, TransportTruck updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  TransportTaskManager getTransportTaskManager(RetailscmUserContext userContext, String
  // transportTruckId, String name, String start, Date beginTime, String endId, String driverId,
  // String belongsToId, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws
  // Exception;

  public TransportTruck addTransportTask(
      RetailscmUserContext userContext,
      String transportTruckId,
      String name,
      String start,
      Date beginTime,
      String endId,
      String driverId,
      String belongsToId,
      BigDecimal latitude,
      BigDecimal longitude,
      String[] tokensExpr)
      throws Exception;

  public TransportTruck removeTransportTask(
      RetailscmUserContext userContext,
      String transportTruckId,
      String transportTaskId,
      int transportTaskVersion,
      String[] tokensExpr)
      throws Exception;

  public TransportTruck updateTransportTask(
      RetailscmUserContext userContext,
      String transportTruckId,
      String transportTaskId,
      int transportTaskVersion,
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
