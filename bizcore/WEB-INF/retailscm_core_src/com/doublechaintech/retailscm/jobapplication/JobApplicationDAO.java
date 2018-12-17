
package com.doublechaintech.retailscm.jobapplication;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface JobApplicationDAO{

	
	public JobApplication load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<JobApplication> jobApplicationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public JobApplication present(JobApplication jobApplication,Map<String,Object> options) throws Exception;
	public JobApplication clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public JobApplication save(JobApplication jobApplication,Map<String,Object> options);
	public SmartList<JobApplication> saveJobApplicationList(SmartList<JobApplication> jobApplicationList,Map<String,Object> options);
	public SmartList<JobApplication> removeJobApplicationList(SmartList<JobApplication> jobApplicationList,Map<String,Object> options);
	public SmartList<JobApplication> findJobApplicationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countJobApplicationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countJobApplicationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String jobApplicationId, int version) throws Exception;
	public JobApplication disconnectFromAll(String jobApplicationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<JobApplication> requestCandidateJobApplicationForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public JobApplication planToRemoveEmployeeList(JobApplication jobApplication, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect JobApplication with company in Employee
	public JobApplication planToRemoveEmployeeListWithCompany(JobApplication jobApplication, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String jobApplicationId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect JobApplication with department in Employee
	public JobApplication planToRemoveEmployeeListWithDepartment(JobApplication jobApplication, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String jobApplicationId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect JobApplication with occupation in Employee
	public JobApplication planToRemoveEmployeeListWithOccupation(JobApplication jobApplication, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String jobApplicationId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect JobApplication with responsible_for in Employee
	public JobApplication planToRemoveEmployeeListWithResponsibleFor(JobApplication jobApplication, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String jobApplicationId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect JobApplication with current_salary_grade in Employee
	public JobApplication planToRemoveEmployeeListWithCurrentSalaryGrade(JobApplication jobApplication, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String jobApplicationId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<JobApplication> queryList(String sql, Object ... parmeters);
}


