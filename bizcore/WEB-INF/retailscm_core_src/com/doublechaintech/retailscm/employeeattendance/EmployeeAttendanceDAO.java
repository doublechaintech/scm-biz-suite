package com.doublechaintech.retailscm.employeeattendance;

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

import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.employee.EmployeeDAO;

public interface EmployeeAttendanceDAO extends BaseDAO {

  public SmartList<EmployeeAttendance> loadAll();

  public Stream<EmployeeAttendance> loadAllAsStream();

  public EmployeeAttendance load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<EmployeeAttendance> employeeAttendanceList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public EmployeeAttendance present(
      EmployeeAttendance employeeAttendance, Map<String, Object> options) throws Exception;

  public EmployeeAttendance clone(String id, Map<String, Object> options) throws Exception;

  public EmployeeAttendance save(
      EmployeeAttendance employeeAttendance, Map<String, Object> options);

  public SmartList<EmployeeAttendance> saveEmployeeAttendanceList(
      SmartList<EmployeeAttendance> employeeAttendanceList, Map<String, Object> options);

  public SmartList<EmployeeAttendance> removeEmployeeAttendanceList(
      SmartList<EmployeeAttendance> employeeAttendanceList, Map<String, Object> options);

  public SmartList<EmployeeAttendance> findEmployeeAttendanceWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countEmployeeAttendanceWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countEmployeeAttendanceWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public EmployeeAttendance disconnectFromAll(String employeeAttendanceId, int version)
      throws Exception;

  public void resetNextId();

  public SmartList<EmployeeAttendance> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<EmployeeAttendance> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateEmployeeAttendance executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<EmployeeAttendance> findEmployeeAttendanceByEmployee(
      String employeeId, Map<String, Object> options);

  public int countEmployeeAttendanceByEmployee(String employeeId, Map<String, Object> options);

  public Map<String, Integer> countEmployeeAttendanceByEmployeeIds(
      String[] ids, Map<String, Object> options);

  public SmartList<EmployeeAttendance> findEmployeeAttendanceByEmployee(
      String employeeId, int start, int count, Map<String, Object> options);

  public void analyzeEmployeeAttendanceByEmployee(
      SmartList<EmployeeAttendance> resultList, String employeeId, Map<String, Object> options);

  List<EmployeeAttendance> search(EmployeeAttendanceRequest pRequest);
}
