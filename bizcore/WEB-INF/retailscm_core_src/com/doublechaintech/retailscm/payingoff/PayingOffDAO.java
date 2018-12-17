
package com.doublechaintech.retailscm.payingoff;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface PayingOffDAO{

	
	public PayingOff load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PayingOff> payingOffList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public PayingOff present(PayingOff payingOff,Map<String,Object> options) throws Exception;
	public PayingOff clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PayingOff save(PayingOff payingOff,Map<String,Object> options);
	public SmartList<PayingOff> savePayingOffList(SmartList<PayingOff> payingOffList,Map<String,Object> options);
	public SmartList<PayingOff> removePayingOffList(SmartList<PayingOff> payingOffList,Map<String,Object> options);
	public SmartList<PayingOff> findPayingOffWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPayingOffWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPayingOffWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String payingOffId, int version) throws Exception;
	public PayingOff disconnectFromAll(String payingOffId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO();
		
	
 	public SmartList<PayingOff> requestCandidatePayingOffForEmployeeSalarySheet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public PayingOff planToRemoveEmployeeSalarySheetList(PayingOff payingOff, String employeeSalarySheetIds[], Map<String,Object> options)throws Exception;


	//disconnect PayingOff with employee in EmployeeSalarySheet
	public PayingOff planToRemoveEmployeeSalarySheetListWithEmployee(PayingOff payingOff, String employeeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSalarySheetListWithEmployee(String payingOffId, String employeeId, Map<String,Object> options)throws Exception;
	
	//disconnect PayingOff with current_salary_grade in EmployeeSalarySheet
	public PayingOff planToRemoveEmployeeSalarySheetListWithCurrentSalaryGrade(PayingOff payingOff, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSalarySheetListWithCurrentSalaryGrade(String payingOffId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<PayingOff> queryList(String sql, Object ... parmeters);
 
 	public SmartList<PayingOff> findPayingOffByPaidFor(String employeeId, Map<String,Object> options);
 	public int countPayingOffByPaidFor(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countPayingOffByPaidForIds(String[] ids, Map<String,Object> options);
 	public SmartList<PayingOff> findPayingOffByPaidFor(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzePayingOffByPaidFor(SmartList<PayingOff> resultList, String employeeId, Map<String,Object> options);

 
 }


