
package com.doublechaintech.retailscm.offerapproval;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface OfferApprovalDAO{

	
	public OfferApproval load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<OfferApproval> offerApprovalList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public OfferApproval present(OfferApproval offerApproval,Map<String,Object> options) throws Exception;
	public OfferApproval clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OfferApproval save(OfferApproval offerApproval,Map<String,Object> options);
	public SmartList<OfferApproval> saveOfferApprovalList(SmartList<OfferApproval> offerApprovalList,Map<String,Object> options);
	public SmartList<OfferApproval> removeOfferApprovalList(SmartList<OfferApproval> offerApprovalList,Map<String,Object> options);
	public SmartList<OfferApproval> findOfferApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countOfferApprovalWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countOfferApprovalWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String offerApprovalId, int version) throws Exception;
	public OfferApproval disconnectFromAll(String offerApprovalId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<OfferApproval> requestCandidateOfferApprovalForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public OfferApproval planToRemoveEmployeeList(OfferApproval offerApproval, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect OfferApproval with company in Employee
	public OfferApproval planToRemoveEmployeeListWithCompany(OfferApproval offerApproval, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String offerApprovalId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferApproval with department in Employee
	public OfferApproval planToRemoveEmployeeListWithDepartment(OfferApproval offerApproval, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String offerApprovalId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferApproval with occupation in Employee
	public OfferApproval planToRemoveEmployeeListWithOccupation(OfferApproval offerApproval, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String offerApprovalId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferApproval with responsible_for in Employee
	public OfferApproval planToRemoveEmployeeListWithResponsibleFor(OfferApproval offerApproval, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String offerApprovalId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect OfferApproval with current_salary_grade in Employee
	public OfferApproval planToRemoveEmployeeListWithCurrentSalaryGrade(OfferApproval offerApproval, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String offerApprovalId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<OfferApproval> queryList(String sql, Object ... parmeters);
}


