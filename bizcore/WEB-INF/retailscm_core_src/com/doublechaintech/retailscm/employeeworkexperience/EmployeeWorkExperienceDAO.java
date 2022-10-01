package com.doublechaintech.retailscm.employeeworkexperience;

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

public interface EmployeeWorkExperienceDAO extends BaseDAO {

  public SmartList<EmployeeWorkExperience> loadAll();

  public Stream<EmployeeWorkExperience> loadAllAsStream();

  public EmployeeWorkExperience load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<EmployeeWorkExperience> employeeWorkExperienceList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public EmployeeWorkExperience present(
      EmployeeWorkExperience employeeWorkExperience, Map<String, Object> options) throws Exception;

  public EmployeeWorkExperience clone(String id, Map<String, Object> options) throws Exception;

  public EmployeeWorkExperience save(
      EmployeeWorkExperience employeeWorkExperience, Map<String, Object> options);

  public SmartList<EmployeeWorkExperience> saveEmployeeWorkExperienceList(
      SmartList<EmployeeWorkExperience> employeeWorkExperienceList, Map<String, Object> options);

  public SmartList<EmployeeWorkExperience> removeEmployeeWorkExperienceList(
      SmartList<EmployeeWorkExperience> employeeWorkExperienceList, Map<String, Object> options);

  public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countEmployeeWorkExperienceWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countEmployeeWorkExperienceWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public EmployeeWorkExperience disconnectFromAll(String employeeWorkExperienceId, int version)
      throws Exception;

  public void resetNextId();

  public SmartList<EmployeeWorkExperience> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<EmployeeWorkExperience> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateEmployeeWorkExperience executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceByEmployee(
      String employeeId, Map<String, Object> options);

  public int countEmployeeWorkExperienceByEmployee(String employeeId, Map<String, Object> options);

  public Map<String, Integer> countEmployeeWorkExperienceByEmployeeIds(
      String[] ids, Map<String, Object> options);

  public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceByEmployee(
      String employeeId, int start, int count, Map<String, Object> options);

  public void analyzeEmployeeWorkExperienceByEmployee(
      SmartList<EmployeeWorkExperience> resultList, String employeeId, Map<String, Object> options);

  List<EmployeeWorkExperience> search(EmployeeWorkExperienceRequest pRequest);
}
