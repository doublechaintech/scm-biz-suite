package com.doublechaintech.retailscm.employeeaward;

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

public interface EmployeeAwardDAO extends BaseDAO {

  public SmartList<EmployeeAward> loadAll();

  public Stream<EmployeeAward> loadAllAsStream();

  public EmployeeAward load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<EmployeeAward> employeeAwardList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public EmployeeAward present(EmployeeAward employeeAward, Map<String, Object> options)
      throws Exception;

  public EmployeeAward clone(String id, Map<String, Object> options) throws Exception;

  public EmployeeAward save(EmployeeAward employeeAward, Map<String, Object> options);

  public SmartList<EmployeeAward> saveEmployeeAwardList(
      SmartList<EmployeeAward> employeeAwardList, Map<String, Object> options);

  public SmartList<EmployeeAward> removeEmployeeAwardList(
      SmartList<EmployeeAward> employeeAwardList, Map<String, Object> options);

  public SmartList<EmployeeAward> findEmployeeAwardWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countEmployeeAwardWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countEmployeeAwardWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public EmployeeAward disconnectFromAll(String employeeAwardId, int version) throws Exception;

  public void resetNextId();

  public SmartList<EmployeeAward> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<EmployeeAward> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateEmployeeAward executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<EmployeeAward> findEmployeeAwardByEmployee(
      String employeeId, Map<String, Object> options);

  public int countEmployeeAwardByEmployee(String employeeId, Map<String, Object> options);

  public Map<String, Integer> countEmployeeAwardByEmployeeIds(
      String[] ids, Map<String, Object> options);

  public SmartList<EmployeeAward> findEmployeeAwardByEmployee(
      String employeeId, int start, int count, Map<String, Object> options);

  public void analyzeEmployeeAwardByEmployee(
      SmartList<EmployeeAward> resultList, String employeeId, Map<String, Object> options);

  List<EmployeeAward> search(EmployeeAwardRequest pRequest);
}
