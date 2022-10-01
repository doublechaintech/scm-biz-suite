package com.doublechaintech.retailscm.employeeperformance;

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

public interface EmployeePerformanceDAO extends BaseDAO {

  public SmartList<EmployeePerformance> loadAll();

  public Stream<EmployeePerformance> loadAllAsStream();

  public EmployeePerformance load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<EmployeePerformance> employeePerformanceList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public EmployeePerformance present(
      EmployeePerformance employeePerformance, Map<String, Object> options) throws Exception;

  public EmployeePerformance clone(String id, Map<String, Object> options) throws Exception;

  public EmployeePerformance save(
      EmployeePerformance employeePerformance, Map<String, Object> options);

  public SmartList<EmployeePerformance> saveEmployeePerformanceList(
      SmartList<EmployeePerformance> employeePerformanceList, Map<String, Object> options);

  public SmartList<EmployeePerformance> removeEmployeePerformanceList(
      SmartList<EmployeePerformance> employeePerformanceList, Map<String, Object> options);

  public SmartList<EmployeePerformance> findEmployeePerformanceWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countEmployeePerformanceWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countEmployeePerformanceWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public EmployeePerformance disconnectFromAll(String employeePerformanceId, int version)
      throws Exception;

  public void resetNextId();

  public SmartList<EmployeePerformance> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<EmployeePerformance> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateEmployeePerformance executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<EmployeePerformance> findEmployeePerformanceByEmployee(
      String employeeId, Map<String, Object> options);

  public int countEmployeePerformanceByEmployee(String employeeId, Map<String, Object> options);

  public Map<String, Integer> countEmployeePerformanceByEmployeeIds(
      String[] ids, Map<String, Object> options);

  public SmartList<EmployeePerformance> findEmployeePerformanceByEmployee(
      String employeeId, int start, int count, Map<String, Object> options);

  public void analyzeEmployeePerformanceByEmployee(
      SmartList<EmployeePerformance> resultList, String employeeId, Map<String, Object> options);

  List<EmployeePerformance> search(EmployeePerformanceRequest pRequest);
}
