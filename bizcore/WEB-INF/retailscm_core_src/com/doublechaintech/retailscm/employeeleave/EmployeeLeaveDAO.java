
package com.doublechaintech.retailscm.employeeleave;
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
import com.doublechaintech.retailscm.leavetype.LeaveType;

import com.doublechaintech.retailscm.leavetype.LeaveTypeDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface EmployeeLeaveDAO extends BaseDAO{

	public SmartList<EmployeeLeave> loadAll();
	public EmployeeLeave load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeLeave> employeeLeaveList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EmployeeLeave present(EmployeeLeave employeeLeave,Map<String,Object> options) throws Exception;
	public EmployeeLeave clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeLeave save(EmployeeLeave employeeLeave,Map<String,Object> options);
	public SmartList<EmployeeLeave> saveEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList,Map<String,Object> options);
	public SmartList<EmployeeLeave> removeEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList,Map<String,Object> options);
	public SmartList<EmployeeLeave> findEmployeeLeaveWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeLeaveWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeLeaveWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeLeaveId, int version) throws Exception;
	public EmployeeLeave disconnectFromAll(String employeeLeaveId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<EmployeeLeave> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateEmployeeLeave executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<EmployeeLeave> findEmployeeLeaveByWho(String employeeId, Map<String,Object> options);
 	public int countEmployeeLeaveByWho(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeLeaveByWhoIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeLeave> findEmployeeLeaveByWho(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeLeaveByWho(SmartList<EmployeeLeave> resultList, String employeeId, Map<String,Object> options);

 
  
 	public SmartList<EmployeeLeave> findEmployeeLeaveByType(String leaveTypeId, Map<String,Object> options);
 	public int countEmployeeLeaveByType(String leaveTypeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeLeaveByTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeLeave> findEmployeeLeaveByType(String leaveTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeLeaveByType(SmartList<EmployeeLeave> resultList, String leaveTypeId, Map<String,Object> options);

 
 
}


