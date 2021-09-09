
package com.doublechaintech.retailscm.employee;
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
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformance;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducation;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.doublechaintech.retailscm.employeeaward.EmployeeAward;

import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetDAO;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeDAO;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeDAO;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkillDAO;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewDAO;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceDAO;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeaveDAO;
import com.doublechaintech.retailscm.occupationtype.OccupationTypeDAO;
import com.doublechaintech.retailscm.employeeaward.EmployeeAwardDAO;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceDAO;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierDAO;
import com.doublechaintech.retailscm.payingoff.PayingOffDAO;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentDAO;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingDAO;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducationDAO;


public interface EmployeeDAO extends BaseDAO{

	public SmartList<Employee> loadAll();
	public Stream<Employee> loadAllAsStream();
	public Employee load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Employee> employeeList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public Employee present(Employee employee,Map<String,Object> options) throws Exception;
	public Employee clone(String id, Map<String,Object> options) throws Exception;

	

	public Employee save(Employee employee,Map<String,Object> options);
	public SmartList<Employee> saveEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options);
	public SmartList<Employee> removeEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options);
	public SmartList<Employee> findEmployeeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeId, int version) throws Exception;
	public Employee disconnectFromAll(String employeeId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO();
		
	public EmployeeSkillDAO getEmployeeSkillDAO();
		
	public EmployeePerformanceDAO getEmployeePerformanceDAO();
		
	public EmployeeWorkExperienceDAO getEmployeeWorkExperienceDAO();
		
	public EmployeeLeaveDAO getEmployeeLeaveDAO();
		
	public EmployeeInterviewDAO getEmployeeInterviewDAO();
		
	public EmployeeAttendanceDAO getEmployeeAttendanceDAO();
		
	public EmployeeQualifierDAO getEmployeeQualifierDAO();
		
	public EmployeeEducationDAO getEmployeeEducationDAO();
		
	public EmployeeAwardDAO getEmployeeAwardDAO();
		
	public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO();
		
	public PayingOffDAO getPayingOffDAO();
		
	
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeCompanyTraining(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeSkill(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeePerformance(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeWorkExperience(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeLeave(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeInterview(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeAttendance(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeQualifier(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeEducation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeAward(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForEmployeeSalarySheet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Employee> requestCandidateEmployeeForPayingOff(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Employee planToRemoveEmployeeCompanyTrainingList(Employee employee, String employeeCompanyTrainingIds[], Map<String,Object> options)throws Exception;


	//disconnect Employee with training in EmployeeCompanyTraining
	public Employee planToRemoveEmployeeCompanyTrainingListWithTraining(Employee employee, String trainingId, Map<String,Object> options)throws Exception;
	public int countEmployeeCompanyTrainingListWithTraining(String employeeId, String trainingId, Map<String,Object> options)throws Exception;
	
	//disconnect Employee with scoring in EmployeeCompanyTraining
	public Employee planToRemoveEmployeeCompanyTrainingListWithScoring(Employee employee, String scoringId, Map<String,Object> options)throws Exception;
	public int countEmployeeCompanyTrainingListWithScoring(String employeeId, String scoringId, Map<String,Object> options)throws Exception;
	
	public Employee planToRemoveEmployeeSkillList(Employee employee, String employeeSkillIds[], Map<String,Object> options)throws Exception;


	//disconnect Employee with skill_type in EmployeeSkill
	public Employee planToRemoveEmployeeSkillListWithSkillType(Employee employee, String skillTypeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSkillListWithSkillType(String employeeId, String skillTypeId, Map<String,Object> options)throws Exception;
	
	public Employee planToRemoveEmployeePerformanceList(Employee employee, String employeePerformanceIds[], Map<String,Object> options)throws Exception;


	public Employee planToRemoveEmployeeWorkExperienceList(Employee employee, String employeeWorkExperienceIds[], Map<String,Object> options)throws Exception;


	public Employee planToRemoveEmployeeLeaveList(Employee employee, String employeeLeaveIds[], Map<String,Object> options)throws Exception;


	//disconnect Employee with type in EmployeeLeave
	public Employee planToRemoveEmployeeLeaveListWithType(Employee employee, String typeId, Map<String,Object> options)throws Exception;
	public int countEmployeeLeaveListWithType(String employeeId, String typeId, Map<String,Object> options)throws Exception;
	
	public Employee planToRemoveEmployeeInterviewList(Employee employee, String employeeInterviewIds[], Map<String,Object> options)throws Exception;


	//disconnect Employee with interview_type in EmployeeInterview
	public Employee planToRemoveEmployeeInterviewListWithInterviewType(Employee employee, String interviewTypeId, Map<String,Object> options)throws Exception;
	public int countEmployeeInterviewListWithInterviewType(String employeeId, String interviewTypeId, Map<String,Object> options)throws Exception;
	
	public Employee planToRemoveEmployeeAttendanceList(Employee employee, String employeeAttendanceIds[], Map<String,Object> options)throws Exception;


	public Employee planToRemoveEmployeeQualifierList(Employee employee, String employeeQualifierIds[], Map<String,Object> options)throws Exception;


	public Employee planToRemoveEmployeeEducationList(Employee employee, String employeeEducationIds[], Map<String,Object> options)throws Exception;


	public Employee planToRemoveEmployeeAwardList(Employee employee, String employeeAwardIds[], Map<String,Object> options)throws Exception;


	public Employee planToRemoveEmployeeSalarySheetList(Employee employee, String employeeSalarySheetIds[], Map<String,Object> options)throws Exception;


	//disconnect Employee with current_salary_grade in EmployeeSalarySheet
	public Employee planToRemoveEmployeeSalarySheetListWithCurrentSalaryGrade(Employee employee, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSalarySheetListWithCurrentSalaryGrade(String employeeId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	//disconnect Employee with paying_off in EmployeeSalarySheet
	public Employee planToRemoveEmployeeSalarySheetListWithPayingOff(Employee employee, String payingOffId, Map<String,Object> options)throws Exception;
	public int countEmployeeSalarySheetListWithPayingOff(String employeeId, String payingOffId, Map<String,Object> options)throws Exception;
	
	public Employee planToRemovePayingOffList(Employee employee, String payingOffIds[], Map<String,Object> options)throws Exception;



	public SmartList<Employee> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<Employee> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateEmployee executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<Employee> findEmployeeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countEmployeeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByCompany(SmartList<Employee> resultList, String retailStoreCountryCenterId, Map<String,Object> options);


 
 	public SmartList<Employee> findEmployeeByDepartment(String levelThreeDepartmentId, Map<String,Object> options);
 	public int countEmployeeByDepartment(String levelThreeDepartmentId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByDepartmentIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByDepartment(String levelThreeDepartmentId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByDepartment(SmartList<Employee> resultList, String levelThreeDepartmentId, Map<String,Object> options);


 
 	public SmartList<Employee> findEmployeeByOccupation(String occupationTypeId, Map<String,Object> options);
 	public int countEmployeeByOccupation(String occupationTypeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByOccupationIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByOccupation(String occupationTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByOccupation(SmartList<Employee> resultList, String occupationTypeId, Map<String,Object> options);


 
 	public SmartList<Employee> findEmployeeByResponsibleFor(String responsibilityTypeId, Map<String,Object> options);
 	public int countEmployeeByResponsibleFor(String responsibilityTypeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByResponsibleForIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByResponsibleFor(String responsibilityTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByResponsibleFor(SmartList<Employee> resultList, String responsibilityTypeId, Map<String,Object> options);


 
 	public SmartList<Employee> findEmployeeByCurrentSalaryGrade(String salaryGradeId, Map<String,Object> options);
 	public int countEmployeeByCurrentSalaryGrade(String salaryGradeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeByCurrentSalaryGradeIds(String[] ids, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByCurrentSalaryGrade(String salaryGradeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeByCurrentSalaryGrade(SmartList<Employee> resultList, String salaryGradeId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:EmployeeCompanyTraining的employee的EmployeeCompanyTrainingList
	public SmartList<EmployeeCompanyTraining> loadOurEmployeeCompanyTrainingList(RetailscmUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeSkill的employee的EmployeeSkillList
	public SmartList<EmployeeSkill> loadOurEmployeeSkillList(RetailscmUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeePerformance的employee的EmployeePerformanceList
	public SmartList<EmployeePerformance> loadOurEmployeePerformanceList(RetailscmUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeWorkExperience的employee的EmployeeWorkExperienceList
	public SmartList<EmployeeWorkExperience> loadOurEmployeeWorkExperienceList(RetailscmUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeLeave的who的EmployeeLeaveList
	public SmartList<EmployeeLeave> loadOurEmployeeLeaveList(RetailscmUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeInterview的employee的EmployeeInterviewList
	public SmartList<EmployeeInterview> loadOurEmployeeInterviewList(RetailscmUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeAttendance的employee的EmployeeAttendanceList
	public SmartList<EmployeeAttendance> loadOurEmployeeAttendanceList(RetailscmUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeQualifier的employee的EmployeeQualifierList
	public SmartList<EmployeeQualifier> loadOurEmployeeQualifierList(RetailscmUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeEducation的employee的EmployeeEducationList
	public SmartList<EmployeeEducation> loadOurEmployeeEducationList(RetailscmUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeAward的employee的EmployeeAwardList
	public SmartList<EmployeeAward> loadOurEmployeeAwardList(RetailscmUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeSalarySheet的employee的EmployeeSalarySheetList
	public SmartList<EmployeeSalarySheet> loadOurEmployeeSalarySheetList(RetailscmUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:PayingOff的paidFor的PayingOffList
	public SmartList<PayingOff> loadOurPayingOffList(RetailscmUserContext userContext, List<Employee> us, Map<String,Object> options) throws Exception;
	

	List<Employee> search(EmployeeRequest pRequest);
}


