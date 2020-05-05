
package com.doublechaintech.retailscm.occupationtype;
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


public interface OccupationTypeDAO extends BaseDAO{

	public SmartList<OccupationType> loadAll();
	public OccupationType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<OccupationType> occupationTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public OccupationType present(OccupationType occupationType,Map<String,Object> options) throws Exception;
	public OccupationType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OccupationType save(OccupationType occupationType,Map<String,Object> options);
	public SmartList<OccupationType> saveOccupationTypeList(SmartList<OccupationType> occupationTypeList,Map<String,Object> options);
	public SmartList<OccupationType> removeOccupationTypeList(SmartList<OccupationType> occupationTypeList,Map<String,Object> options);
	public SmartList<OccupationType> findOccupationTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countOccupationTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countOccupationTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String occupationTypeId, int version) throws Exception;
	public OccupationType disconnectFromAll(String occupationTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<OccupationType> requestCandidateOccupationTypeForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public OccupationType planToRemoveEmployeeList(OccupationType occupationType, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect OccupationType with company in Employee
	public OccupationType planToRemoveEmployeeListWithCompany(OccupationType occupationType, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String occupationTypeId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect OccupationType with department in Employee
	public OccupationType planToRemoveEmployeeListWithDepartment(OccupationType occupationType, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String occupationTypeId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect OccupationType with responsible_for in Employee
	public OccupationType planToRemoveEmployeeListWithResponsibleFor(OccupationType occupationType, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String occupationTypeId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect OccupationType with current_salary_grade in Employee
	public OccupationType planToRemoveEmployeeListWithCurrentSalaryGrade(OccupationType occupationType, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String occupationTypeId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<OccupationType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateOccupationType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<OccupationType> findOccupationTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countOccupationTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countOccupationTypeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<OccupationType> findOccupationTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeOccupationTypeByCompany(SmartList<OccupationType> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Employee的occupation的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<OccupationType> us, Map<String,Object> options) throws Exception;
	
}


