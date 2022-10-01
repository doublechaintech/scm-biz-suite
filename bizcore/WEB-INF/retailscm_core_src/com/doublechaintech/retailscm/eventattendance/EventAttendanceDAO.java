package com.doublechaintech.retailscm.eventattendance;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEvent;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.doublechaintech.retailscm.cityevent.CityEventDAO;

public interface EventAttendanceDAO extends BaseDAO {

  public SmartList<EventAttendance> loadAll();

  public Stream<EventAttendance> loadAllAsStream();

  public EventAttendance load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<EventAttendance> eventAttendanceList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public EventAttendance present(EventAttendance eventAttendance, Map<String, Object> options)
      throws Exception;

  public EventAttendance clone(String id, Map<String, Object> options) throws Exception;

  public EventAttendance save(EventAttendance eventAttendance, Map<String, Object> options);

  public SmartList<EventAttendance> saveEventAttendanceList(
      SmartList<EventAttendance> eventAttendanceList, Map<String, Object> options);

  public SmartList<EventAttendance> removeEventAttendanceList(
      SmartList<EventAttendance> eventAttendanceList, Map<String, Object> options);

  public SmartList<EventAttendance> findEventAttendanceWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countEventAttendanceWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countEventAttendanceWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public EventAttendance disconnectFromAll(String eventAttendanceId, int version) throws Exception;

  public void resetNextId();

  public SmartList<EventAttendance> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<EventAttendance> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateEventAttendance executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<EventAttendance> findEventAttendanceByPotentialCustomer(
      String potentialCustomerId, Map<String, Object> options);

  public int countEventAttendanceByPotentialCustomer(
      String potentialCustomerId, Map<String, Object> options);

  public Map<String, Integer> countEventAttendanceByPotentialCustomerIds(
      String[] ids, Map<String, Object> options);

  public SmartList<EventAttendance> findEventAttendanceByPotentialCustomer(
      String potentialCustomerId, int start, int count, Map<String, Object> options);

  public void analyzeEventAttendanceByPotentialCustomer(
      SmartList<EventAttendance> resultList,
      String potentialCustomerId,
      Map<String, Object> options);

  public SmartList<EventAttendance> findEventAttendanceByCityEvent(
      String cityEventId, Map<String, Object> options);

  public int countEventAttendanceByCityEvent(String cityEventId, Map<String, Object> options);

  public Map<String, Integer> countEventAttendanceByCityEventIds(
      String[] ids, Map<String, Object> options);

  public SmartList<EventAttendance> findEventAttendanceByCityEvent(
      String cityEventId, int start, int count, Map<String, Object> options);

  public void analyzeEventAttendanceByCityEvent(
      SmartList<EventAttendance> resultList, String cityEventId, Map<String, Object> options);

  List<EventAttendance> search(EventAttendanceRequest pRequest);
}
