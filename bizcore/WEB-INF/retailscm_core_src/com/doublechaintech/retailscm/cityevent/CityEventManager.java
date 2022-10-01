package com.doublechaintech.retailscm.cityevent;

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

public interface CityEventManager extends BaseManager {

  List<CityEvent> searchCityEventList(RetailscmUserContext ctx, CityEventRequest pRequest);

  CityEvent searchCityEvent(RetailscmUserContext ctx, CityEventRequest pRequest);

  public CityEvent createCityEvent(
      RetailscmUserContext userContext,
      String name,
      String mobile,
      String cityServiceCenterId,
      String description)
      throws Exception;

  public CityEvent updateCityEvent(
      RetailscmUserContext userContext,
      String cityEventId,
      int cityEventVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public CityEvent loadCityEvent(
      RetailscmUserContext userContext, String cityEventId, String[] tokensExpr) throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public CityEvent internalSaveCityEvent(RetailscmUserContext userContext, CityEvent cityEvent)
      throws Exception;

  public CityEvent internalSaveCityEvent(
      RetailscmUserContext userContext, CityEvent cityEvent, Map<String, Object> option)
      throws Exception;

  public CityEvent transferToAnotherCityServiceCenter(
      RetailscmUserContext userContext, String cityEventId, String anotherCityServiceCenterId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, CityEvent newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, CityEvent updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  EventAttendanceManager getEventAttendanceManager(RetailscmUserContext userContext,
  // String cityEventId, String name, String potentialCustomerId, String description ,String []
  // tokensExpr)  throws Exception;

  public CityEvent addEventAttendance(
      RetailscmUserContext userContext,
      String cityEventId,
      String name,
      String potentialCustomerId,
      String description,
      String[] tokensExpr)
      throws Exception;

  public CityEvent removeEventAttendance(
      RetailscmUserContext userContext,
      String cityEventId,
      String eventAttendanceId,
      int eventAttendanceVersion,
      String[] tokensExpr)
      throws Exception;

  public CityEvent updateEventAttendance(
      RetailscmUserContext userContext,
      String cityEventId,
      String eventAttendanceId,
      int eventAttendanceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  public Object listByCityServiceCenter(
      RetailscmUserContext userContext, String cityServiceCenterId) throws Exception;

  public Object listPageByCityServiceCenter(
      RetailscmUserContext userContext, String cityServiceCenterId, int start, int count)
      throws Exception;
}
