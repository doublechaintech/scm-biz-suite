
package com.doublechaintech.retailscm.responsibilitytype;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface ResponsibilityTypeDAO extends BaseDAO{

	public SmartList<ResponsibilityType> loadAll();
	public ResponsibilityType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ResponsibilityType> responsibilityTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ResponsibilityType present(ResponsibilityType responsibilityType,Map<String,Object> options) throws Exception;
	public ResponsibilityType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ResponsibilityType save(ResponsibilityType responsibilityType,Map<String,Object> options);
	public SmartList<ResponsibilityType> saveResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList,Map<String,Object> options);
	public SmartList<ResponsibilityType> removeResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList,Map<String,Object> options);
	public SmartList<ResponsibilityType> findResponsibilityTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countResponsibilityTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countResponsibilityTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String responsibilityTypeId, int version) throws Exception;
	public ResponsibilityType disconnectFromAll(String responsibilityTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<ResponsibilityType> requestCandidateResponsibilityTypeForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ResponsibilityType planToRemoveEmployeeList(ResponsibilityType responsibilityType, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect ResponsibilityType with company in Employee
	public ResponsibilityType planToRemoveEmployeeListWithCompany(ResponsibilityType responsibilityType, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String responsibilityTypeId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with department in Employee
	public ResponsibilityType planToRemoveEmployeeListWithDepartment(ResponsibilityType responsibilityType, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String responsibilityTypeId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with occupation in Employee
	public ResponsibilityType planToRemoveEmployeeListWithOccupation(ResponsibilityType responsibilityType, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String responsibilityTypeId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect ResponsibilityType with current_salary_grade in Employee
	public ResponsibilityType planToRemoveEmployeeListWithCurrentSalaryGrade(ResponsibilityType responsibilityType, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String responsibilityTypeId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ResponsibilityType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateResponsibilityType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<ResponsibilityType> findResponsibilityTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countResponsibilityTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countResponsibilityTypeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<ResponsibilityType> findResponsibilityTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeResponsibilityTypeByCompany(SmartList<ResponsibilityType> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Employee的responsibleFor的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<ResponsibilityType> us, Map<String,Object> options) throws Exception;
	
}


