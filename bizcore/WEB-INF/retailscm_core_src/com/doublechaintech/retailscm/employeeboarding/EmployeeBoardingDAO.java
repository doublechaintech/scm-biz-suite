
package com.doublechaintech.retailscm.employeeboarding;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface EmployeeBoardingDAO{

	
	public EmployeeBoarding load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeBoarding> employeeBoardingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EmployeeBoarding present(EmployeeBoarding employeeBoarding,Map<String,Object> options) throws Exception;
	public EmployeeBoarding clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeBoarding save(EmployeeBoarding employeeBoarding,Map<String,Object> options);
	public SmartList<EmployeeBoarding> saveEmployeeBoardingList(SmartList<EmployeeBoarding> employeeBoardingList,Map<String,Object> options);
	public SmartList<EmployeeBoarding> removeEmployeeBoardingList(SmartList<EmployeeBoarding> employeeBoardingList,Map<String,Object> options);
	public SmartList<EmployeeBoarding> findEmployeeBoardingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeBoardingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeBoardingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeBoardingId, int version) throws Exception;
	public EmployeeBoarding disconnectFromAll(String employeeBoardingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<EmployeeBoarding> requestCandidateEmployeeBoardingForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public EmployeeBoarding planToRemoveEmployeeList(EmployeeBoarding employeeBoarding, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect EmployeeBoarding with company in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithCompany(EmployeeBoarding employeeBoarding, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String employeeBoardingId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with department in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithDepartment(EmployeeBoarding employeeBoarding, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String employeeBoardingId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with occupation in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithOccupation(EmployeeBoarding employeeBoarding, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String employeeBoardingId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with responsible_for in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithResponsibleFor(EmployeeBoarding employeeBoarding, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String employeeBoardingId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect EmployeeBoarding with current_salary_grade in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithCurrentSalaryGrade(EmployeeBoarding employeeBoarding, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String employeeBoardingId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<EmployeeBoarding> queryList(String sql, Object ... parmeters);
}


