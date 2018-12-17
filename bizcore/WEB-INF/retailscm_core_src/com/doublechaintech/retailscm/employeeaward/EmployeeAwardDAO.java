
package com.doublechaintech.retailscm.employeeaward;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface EmployeeAwardDAO{

	
	public EmployeeAward load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeAward> employeeAwardList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EmployeeAward present(EmployeeAward employeeAward,Map<String,Object> options) throws Exception;
	public EmployeeAward clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeAward save(EmployeeAward employeeAward,Map<String,Object> options);
	public SmartList<EmployeeAward> saveEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList,Map<String,Object> options);
	public SmartList<EmployeeAward> removeEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList,Map<String,Object> options);
	public SmartList<EmployeeAward> findEmployeeAwardWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeAwardWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeAwardWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeAwardId, int version) throws Exception;
	public EmployeeAward disconnectFromAll(String employeeAwardId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<EmployeeAward> queryList(String sql, Object ... parmeters);
 
 	public SmartList<EmployeeAward> findEmployeeAwardByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeAwardByEmployee(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeAwardByEmployeeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeAward> findEmployeeAwardByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeAwardByEmployee(SmartList<EmployeeAward> resultList, String employeeId, Map<String,Object> options);

 
 }


