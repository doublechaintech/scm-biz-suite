
package com.doublechaintech.retailscm.professioninterview;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface ProfessionInterviewDAO{

	
	public ProfessionInterview load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ProfessionInterview> professionInterviewList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ProfessionInterview present(ProfessionInterview professionInterview,Map<String,Object> options) throws Exception;
	public ProfessionInterview clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ProfessionInterview save(ProfessionInterview professionInterview,Map<String,Object> options);
	public SmartList<ProfessionInterview> saveProfessionInterviewList(SmartList<ProfessionInterview> professionInterviewList,Map<String,Object> options);
	public SmartList<ProfessionInterview> removeProfessionInterviewList(SmartList<ProfessionInterview> professionInterviewList,Map<String,Object> options);
	public SmartList<ProfessionInterview> findProfessionInterviewWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProfessionInterviewWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProfessionInterviewWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String professionInterviewId, int version) throws Exception;
	public ProfessionInterview disconnectFromAll(String professionInterviewId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<ProfessionInterview> requestCandidateProfessionInterviewForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ProfessionInterview planToRemoveEmployeeList(ProfessionInterview professionInterview, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect ProfessionInterview with company in Employee
	public ProfessionInterview planToRemoveEmployeeListWithCompany(ProfessionInterview professionInterview, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String professionInterviewId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with department in Employee
	public ProfessionInterview planToRemoveEmployeeListWithDepartment(ProfessionInterview professionInterview, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String professionInterviewId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with occupation in Employee
	public ProfessionInterview planToRemoveEmployeeListWithOccupation(ProfessionInterview professionInterview, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String professionInterviewId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with responsible_for in Employee
	public ProfessionInterview planToRemoveEmployeeListWithResponsibleFor(ProfessionInterview professionInterview, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String professionInterviewId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect ProfessionInterview with current_salary_grade in Employee
	public ProfessionInterview planToRemoveEmployeeListWithCurrentSalaryGrade(ProfessionInterview professionInterview, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String professionInterviewId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ProfessionInterview> queryList(String sql, Object ... parmeters);
}


