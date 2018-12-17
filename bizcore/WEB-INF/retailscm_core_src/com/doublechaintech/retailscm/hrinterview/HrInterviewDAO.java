
package com.doublechaintech.retailscm.hrinterview;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface HrInterviewDAO{

	
	public HrInterview load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<HrInterview> hrInterviewList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public HrInterview present(HrInterview hrInterview,Map<String,Object> options) throws Exception;
	public HrInterview clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public HrInterview save(HrInterview hrInterview,Map<String,Object> options);
	public SmartList<HrInterview> saveHrInterviewList(SmartList<HrInterview> hrInterviewList,Map<String,Object> options);
	public SmartList<HrInterview> removeHrInterviewList(SmartList<HrInterview> hrInterviewList,Map<String,Object> options);
	public SmartList<HrInterview> findHrInterviewWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countHrInterviewWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countHrInterviewWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String hrInterviewId, int version) throws Exception;
	public HrInterview disconnectFromAll(String hrInterviewId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<HrInterview> requestCandidateHrInterviewForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public HrInterview planToRemoveEmployeeList(HrInterview hrInterview, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect HrInterview with company in Employee
	public HrInterview planToRemoveEmployeeListWithCompany(HrInterview hrInterview, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String hrInterviewId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with department in Employee
	public HrInterview planToRemoveEmployeeListWithDepartment(HrInterview hrInterview, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String hrInterviewId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with occupation in Employee
	public HrInterview planToRemoveEmployeeListWithOccupation(HrInterview hrInterview, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String hrInterviewId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with responsible_for in Employee
	public HrInterview planToRemoveEmployeeListWithResponsibleFor(HrInterview hrInterview, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String hrInterviewId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect HrInterview with current_salary_grade in Employee
	public HrInterview planToRemoveEmployeeListWithCurrentSalaryGrade(HrInterview hrInterview, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String hrInterviewId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<HrInterview> queryList(String sql, Object ... parmeters);
}


