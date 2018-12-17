
package com.doublechaintech.retailscm.offeracceptance;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface OfferAcceptanceDAO{

	
	public OfferAcceptance load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<OfferAcceptance> offerAcceptanceList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public OfferAcceptance present(OfferAcceptance offerAcceptance,Map<String,Object> options) throws Exception;
	public OfferAcceptance clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OfferAcceptance save(OfferAcceptance offerAcceptance,Map<String,Object> options);
	public SmartList<OfferAcceptance> saveOfferAcceptanceList(SmartList<OfferAcceptance> offerAcceptanceList,Map<String,Object> options);
	public SmartList<OfferAcceptance> removeOfferAcceptanceList(SmartList<OfferAcceptance> offerAcceptanceList,Map<String,Object> options);
	public SmartList<OfferAcceptance> findOfferAcceptanceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countOfferAcceptanceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countOfferAcceptanceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String offerAcceptanceId, int version) throws Exception;
	public OfferAcceptance disconnectFromAll(String offerAcceptanceId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<OfferAcceptance> requestCandidateOfferAcceptanceForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public OfferAcceptance planToRemoveEmployeeList(OfferAcceptance offerAcceptance, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect OfferAcceptance with company in Employee
	public OfferAcceptance planToRemoveEmployeeListWithCompany(OfferAcceptance offerAcceptance, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String offerAcceptanceId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with department in Employee
	public OfferAcceptance planToRemoveEmployeeListWithDepartment(OfferAcceptance offerAcceptance, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String offerAcceptanceId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with occupation in Employee
	public OfferAcceptance planToRemoveEmployeeListWithOccupation(OfferAcceptance offerAcceptance, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String offerAcceptanceId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with responsible_for in Employee
	public OfferAcceptance planToRemoveEmployeeListWithResponsibleFor(OfferAcceptance offerAcceptance, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String offerAcceptanceId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferAcceptance with current_salary_grade in Employee
	public OfferAcceptance planToRemoveEmployeeListWithCurrentSalaryGrade(OfferAcceptance offerAcceptance, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String offerAcceptanceId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<OfferAcceptance> queryList(String sql, Object ... parmeters);
}


