package com.doublechaintech.retailscm.instructor;

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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

import com.doublechaintech.retailscm.companytraining.CompanyTrainingDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

public interface InstructorDAO extends BaseDAO {

  public SmartList<Instructor> loadAll();

  public Stream<Instructor> loadAllAsStream();

  public Instructor load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<Instructor> instructorList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public Instructor present(Instructor instructor, Map<String, Object> options) throws Exception;

  public Instructor clone(String id, Map<String, Object> options) throws Exception;

  public Instructor save(Instructor instructor, Map<String, Object> options);

  public SmartList<Instructor> saveInstructorList(
      SmartList<Instructor> instructorList, Map<String, Object> options);

  public SmartList<Instructor> removeInstructorList(
      SmartList<Instructor> instructorList, Map<String, Object> options);

  public SmartList<Instructor> findInstructorWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countInstructorWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countInstructorWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public Instructor disconnectFromAll(String instructorId, int version) throws Exception;

  public void resetNextId();

  public CompanyTrainingDAO getCompanyTrainingDAO();

  public SmartList<Instructor> requestCandidateInstructorForCompanyTraining(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public Instructor planToRemoveCompanyTrainingList(
      Instructor instructor, String companyTrainingIds[], Map<String, Object> options)
      throws Exception;

  // disconnect Instructor with company in CompanyTraining
  public Instructor planToRemoveCompanyTrainingListWithCompany(
      Instructor instructor, String companyId, Map<String, Object> options) throws Exception;

  public int countCompanyTrainingListWithCompany(
      String instructorId, String companyId, Map<String, Object> options) throws Exception;

  // disconnect Instructor with training_course_type in CompanyTraining
  public Instructor planToRemoveCompanyTrainingListWithTrainingCourseType(
      Instructor instructor, String trainingCourseTypeId, Map<String, Object> options)
      throws Exception;

  public int countCompanyTrainingListWithTrainingCourseType(
      String instructorId, String trainingCourseTypeId, Map<String, Object> options)
      throws Exception;

  public SmartList<Instructor> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<Instructor> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateInstructor executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<Instructor> findInstructorByCompany(
      String retailStoreCountryCenterId, Map<String, Object> options);

  public int countInstructorByCompany(
      String retailStoreCountryCenterId, Map<String, Object> options);

  public Map<String, Integer> countInstructorByCompanyIds(
      String[] ids, Map<String, Object> options);

  public SmartList<Instructor> findInstructorByCompany(
      String retailStoreCountryCenterId, int start, int count, Map<String, Object> options);

  public void analyzeInstructorByCompany(
      SmartList<Instructor> resultList,
      String retailStoreCountryCenterId,
      Map<String, Object> options);

  List<Instructor> search(InstructorRequest pRequest);
}
