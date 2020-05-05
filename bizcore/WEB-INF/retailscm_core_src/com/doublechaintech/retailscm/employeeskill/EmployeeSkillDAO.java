
package com.doublechaintech.retailscm.employeeskill;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.skilltype.SkillTypeDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface EmployeeSkillDAO extends BaseDAO{

	public SmartList<EmployeeSkill> loadAll();
	public EmployeeSkill load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeSkill> employeeSkillList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public EmployeeSkill present(EmployeeSkill employeeSkill,Map<String,Object> options) throws Exception;
	public EmployeeSkill clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeSkill save(EmployeeSkill employeeSkill,Map<String,Object> options);
	public SmartList<EmployeeSkill> saveEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList,Map<String,Object> options);
	public SmartList<EmployeeSkill> removeEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList,Map<String,Object> options);
	public SmartList<EmployeeSkill> findEmployeeSkillWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeSkillWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeSkillWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeSkillId, int version) throws Exception;
	public EmployeeSkill disconnectFromAll(String employeeSkillId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<EmployeeSkill> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateEmployeeSkill executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<EmployeeSkill> findEmployeeSkillByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeSkillByEmployee(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeSkillByEmployeeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeSkill> findEmployeeSkillByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeSkillByEmployee(SmartList<EmployeeSkill> resultList, String employeeId, Map<String,Object> options);

 
  
 	public SmartList<EmployeeSkill> findEmployeeSkillBySkillType(String skillTypeId, Map<String,Object> options);
 	public int countEmployeeSkillBySkillType(String skillTypeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeSkillBySkillTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeSkill> findEmployeeSkillBySkillType(String skillTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeSkillBySkillType(SmartList<EmployeeSkill> resultList, String skillTypeId, Map<String,Object> options);

 
 
}


