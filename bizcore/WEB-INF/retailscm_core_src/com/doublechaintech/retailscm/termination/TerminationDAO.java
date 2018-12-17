
package com.doublechaintech.retailscm.termination;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.terminationtype.TerminationTypeDAO;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface TerminationDAO{

	
	public Termination load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Termination> terminationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Termination present(Termination termination,Map<String,Object> options) throws Exception;
	public Termination clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Termination save(Termination termination,Map<String,Object> options);
	public SmartList<Termination> saveTerminationList(SmartList<Termination> terminationList,Map<String,Object> options);
	public SmartList<Termination> removeTerminationList(SmartList<Termination> terminationList,Map<String,Object> options);
	public SmartList<Termination> findTerminationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTerminationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTerminationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String terminationId, int version) throws Exception;
	public Termination disconnectFromAll(String terminationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<Termination> requestCandidateTerminationForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Termination planToRemoveEmployeeList(Termination termination, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect Termination with company in Employee
	public Termination planToRemoveEmployeeListWithCompany(Termination termination, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String terminationId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with department in Employee
	public Termination planToRemoveEmployeeListWithDepartment(Termination termination, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String terminationId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with occupation in Employee
	public Termination planToRemoveEmployeeListWithOccupation(Termination termination, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String terminationId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with responsible_for in Employee
	public Termination planToRemoveEmployeeListWithResponsibleFor(Termination termination, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String terminationId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect Termination with current_salary_grade in Employee
	public Termination planToRemoveEmployeeListWithCurrentSalaryGrade(Termination termination, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String terminationId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Termination> queryList(String sql, Object ... parmeters);
 
 	public SmartList<Termination> findTerminationByReason(String terminationReasonId, Map<String,Object> options);
 	public int countTerminationByReason(String terminationReasonId, Map<String,Object> options);
 	public Map<String, Integer> countTerminationByReasonIds(String[] ids, Map<String,Object> options);
 	public SmartList<Termination> findTerminationByReason(String terminationReasonId, int start, int count, Map<String,Object> options);
 	public void analyzeTerminationByReason(SmartList<Termination> resultList, String terminationReasonId, Map<String,Object> options);

 
  
 	public SmartList<Termination> findTerminationByType(String terminationTypeId, Map<String,Object> options);
 	public int countTerminationByType(String terminationTypeId, Map<String,Object> options);
 	public Map<String, Integer> countTerminationByTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<Termination> findTerminationByType(String terminationTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeTerminationByType(SmartList<Termination> resultList, String terminationTypeId, Map<String,Object> options);

 
 }


