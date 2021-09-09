
package com.doublechaintech.retailscm.payingoff;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;

import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface PayingOffDAO extends BaseDAO{

	public SmartList<PayingOff> loadAll();
	public Stream<PayingOff> loadAllAsStream();
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
	public void resetNextId();

	public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO();
		
	
 	public SmartList<PayingOff> requestCandidatePayingOffForEmployeeSalarySheet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public PayingOff planToRemoveEmployeeSalarySheetList(PayingOff payingOff, String employeeSalarySheetIds[], Map<String,Object> options)throws Exception;


	//disconnect PayingOff with employee in EmployeeSalarySheet
	public PayingOff planToRemoveEmployeeSalarySheetListWithEmployee(PayingOff payingOff, String employeeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSalarySheetListWithEmployee(String payingOffId, String employeeId, Map<String,Object> options)throws Exception;
	
	//disconnect PayingOff with current_salary_grade in EmployeeSalarySheet
	public PayingOff planToRemoveEmployeeSalarySheetListWithCurrentSalaryGrade(PayingOff payingOff, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSalarySheetListWithCurrentSalaryGrade(String payingOffId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	

	public SmartList<PayingOff> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<PayingOff> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidatePayingOff executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<PayingOff> findPayingOffByPaidFor(String employeeId, Map<String,Object> options);
 	public int countPayingOffByPaidFor(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countPayingOffByPaidForIds(String[] ids, Map<String,Object> options);
 	public SmartList<PayingOff> findPayingOffByPaidFor(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzePayingOffByPaidFor(SmartList<PayingOff> resultList, String employeeId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:EmployeeSalarySheet的payingOff的EmployeeSalarySheetList
	public SmartList<EmployeeSalarySheet> loadOurEmployeeSalarySheetList(RetailscmUserContext userContext, List<PayingOff> us, Map<String,Object> options) throws Exception;
	

	List<PayingOff> search(PayingOffRequest pRequest);
}


