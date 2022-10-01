package com.doublechaintech.retailscm.eventattendance;

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

public interface EventAttendanceManager extends BaseManager {

  List<EventAttendance> searchEventAttendanceList(
      RetailscmUserContext ctx, EventAttendanceRequest pRequest);

  EventAttendance searchEventAttendance(RetailscmUserContext ctx, EventAttendanceRequest pRequest);

  public EventAttendance createEventAttendance(
      RetailscmUserContext userContext,
      String name,
      String potentialCustomerId,
      String cityEventId,
      String description)
      throws Exception;

  public EventAttendance updateEventAttendance(
      RetailscmUserContext userContext,
      String eventAttendanceId,
      int eventAttendanceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public EventAttendance loadEventAttendance(
      RetailscmUserContext userContext, String eventAttendanceId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public EventAttendance internalSaveEventAttendance(
      RetailscmUserContext userContext, EventAttendance eventAttendance) throws Exception;

  public EventAttendance internalSaveEventAttendance(
      RetailscmUserContext userContext, EventAttendance eventAttendance, Map<String, Object> option)
      throws Exception;

  public EventAttendance transferToAnotherPotentialCustomer(
      RetailscmUserContext userContext, String eventAttendanceId, String anotherPotentialCustomerId)
      throws Exception;

  public EventAttendance transferToAnotherCityEvent(
      RetailscmUserContext userContext, String eventAttendanceId, String anotherCityEventId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, EventAttendance newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, EventAttendance updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByPotentialCustomer(
      RetailscmUserContext userContext, String potentialCustomerId) throws Exception;

  public Object listPageByPotentialCustomer(
      RetailscmUserContext userContext, String potentialCustomerId, int start, int count)
      throws Exception;

  public Object listByCityEvent(RetailscmUserContext userContext, String cityEventId)
      throws Exception;

  public Object listPageByCityEvent(
      RetailscmUserContext userContext, String cityEventId, int start, int count) throws Exception;
}
