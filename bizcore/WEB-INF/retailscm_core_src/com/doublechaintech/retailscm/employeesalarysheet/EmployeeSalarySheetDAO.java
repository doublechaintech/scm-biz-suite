
package com.doublechaintech.retailscm.employeesalarysheet;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;

import com.doublechaintech.retailscm.salarygrade.SalaryGradeDAO;
import com.doublechaintech.retailscm.payingoff.PayingOffDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface EmployeeSalarySheetDAO extends BaseDAO{

	public SmartList<EmployeeSalarySheet> loadAll();
	public EmployeeSalarySheet load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeSalarySheet> employeeSalarySheetList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EmployeeSalarySheet present(EmployeeSalarySheet employeeSalarySheet,Map<String,Object> options) throws Exception;
	public EmployeeSalarySheet clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeSalarySheet save(EmployeeSalarySheet employeeSalarySheet,Map<String,Object> options);
	public SmartList<EmployeeSalarySheet> saveEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList,Map<String,Object> options);
	public SmartList<EmployeeSalarySheet> removeEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList,Map<String,Object> options);
	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeSalarySheetWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeSalarySheetWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeSalarySheetId, int version) throws Exception;
	public EmployeeSalarySheet disconnectFromAll(String employeeSalarySheetId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<EmployeeSalarySheet> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateEmployeeSalarySheet executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeSalarySheetByEmployee(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeSalarySheetByEmployeeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeSalarySheetByEmployee(SmartList<EmployeeSalarySheet> resultList, String employeeId, Map<String,Object> options);

 
  
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId, Map<String,Object> options);
 	public int countEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeSalarySheetByCurrentSalaryGradeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeSalarySheetByCurrentSalaryGrade(SmartList<EmployeeSalarySheet> resultList, String salaryGradeId, Map<String,Object> options);

 
  
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByPayingOff(String payingOffId, Map<String,Object> options);
 	public int countEmployeeSalarySheetByPayingOff(String payingOffId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeSalarySheetByPayingOffIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByPayingOff(String payingOffId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeSalarySheetByPayingOff(SmartList<EmployeeSalarySheet> resultList, String payingOffId, Map<String,Object> options);

 
 
}


