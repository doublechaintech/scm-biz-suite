
package com.doublechaintech.retailscm.companytraining;
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
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

import com.doublechaintech.retailscm.instructor.InstructorDAO;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingDAO;


public interface CompanyTrainingDAO extends BaseDAO{

	public SmartList<CompanyTraining> loadAll();
	public Stream<CompanyTraining> loadAllAsStream();
	public CompanyTraining load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<CompanyTraining> companyTrainingList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public CompanyTraining present(CompanyTraining companyTraining,Map<String,Object> options) throws Exception;
	public CompanyTraining clone(String id, Map<String,Object> options) throws Exception;

	

	public CompanyTraining save(CompanyTraining companyTraining,Map<String,Object> options);
	public SmartList<CompanyTraining> saveCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList,Map<String,Object> options);
	public SmartList<CompanyTraining> removeCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList,Map<String,Object> options);
	public SmartList<CompanyTraining> findCompanyTrainingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCompanyTrainingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCompanyTrainingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String companyTrainingId, int version) throws Exception;
	public CompanyTraining disconnectFromAll(String companyTrainingId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO();
		
	
 	public SmartList<CompanyTraining> requestCandidateCompanyTrainingForEmployeeCompanyTraining(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public CompanyTraining planToRemoveEmployeeCompanyTrainingList(CompanyTraining companyTraining, String employeeCompanyTrainingIds[], Map<String,Object> options)throws Exception;


	//disconnect CompanyTraining with employee in EmployeeCompanyTraining
	public CompanyTraining planToRemoveEmployeeCompanyTrainingListWithEmployee(CompanyTraining companyTraining, String employeeId, Map<String,Object> options)throws Exception;
	public int countEmployeeCompanyTrainingListWithEmployee(String companyTrainingId, String employeeId, Map<String,Object> options)throws Exception;
	
	//disconnect CompanyTraining with scoring in EmployeeCompanyTraining
	public CompanyTraining planToRemoveEmployeeCompanyTrainingListWithScoring(CompanyTraining companyTraining, String scoringId, Map<String,Object> options)throws Exception;
	public int countEmployeeCompanyTrainingListWithScoring(String companyTrainingId, String scoringId, Map<String,Object> options)throws Exception;
	

	public SmartList<CompanyTraining> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<CompanyTraining> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateCompanyTraining executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<CompanyTraining> findCompanyTrainingByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countCompanyTrainingByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countCompanyTrainingByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<CompanyTraining> findCompanyTrainingByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeCompanyTrainingByCompany(SmartList<CompanyTraining> resultList, String retailStoreCountryCenterId, Map<String,Object> options);


 
 	public SmartList<CompanyTraining> findCompanyTrainingByInstructor(String instructorId, Map<String,Object> options);
 	public int countCompanyTrainingByInstructor(String instructorId, Map<String,Object> options);
 	public Map<String, Integer> countCompanyTrainingByInstructorIds(String[] ids, Map<String,Object> options);
 	public SmartList<CompanyTraining> findCompanyTrainingByInstructor(String instructorId, int start, int count, Map<String,Object> options);
 	public void analyzeCompanyTrainingByInstructor(SmartList<CompanyTraining> resultList, String instructorId, Map<String,Object> options);


 
 	public SmartList<CompanyTraining> findCompanyTrainingByTrainingCourseType(String trainingCourseTypeId, Map<String,Object> options);
 	public int countCompanyTrainingByTrainingCourseType(String trainingCourseTypeId, Map<String,Object> options);
 	public Map<String, Integer> countCompanyTrainingByTrainingCourseTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<CompanyTraining> findCompanyTrainingByTrainingCourseType(String trainingCourseTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeCompanyTrainingByTrainingCourseType(SmartList<CompanyTraining> resultList, String trainingCourseTypeId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:EmployeeCompanyTraining的training的EmployeeCompanyTrainingList
	public SmartList<EmployeeCompanyTraining> loadOurEmployeeCompanyTrainingList(RetailscmUserContext userContext, List<CompanyTraining> us, Map<String,Object> options) throws Exception;
	

	List<CompanyTraining> search(CompanyTrainingRequest pRequest);
}


