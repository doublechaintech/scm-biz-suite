
package com.doublechaintech.retailscm.levelthreedepartment;
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

import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface LevelThreeDepartmentDAO extends BaseDAO{

	public SmartList<LevelThreeDepartment> loadAll();
	public Stream<LevelThreeDepartment> loadAllAsStream();
	public LevelThreeDepartment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LevelThreeDepartment> levelThreeDepartmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public LevelThreeDepartment present(LevelThreeDepartment levelThreeDepartment,Map<String,Object> options) throws Exception;
	public LevelThreeDepartment clone(String id, Map<String,Object> options) throws Exception;

	

	public LevelThreeDepartment save(LevelThreeDepartment levelThreeDepartment,Map<String,Object> options);
	public SmartList<LevelThreeDepartment> saveLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList,Map<String,Object> options);
	public SmartList<LevelThreeDepartment> removeLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList,Map<String,Object> options);
	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLevelThreeDepartmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLevelThreeDepartmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String levelThreeDepartmentId, int version) throws Exception;
	public LevelThreeDepartment disconnectFromAll(String levelThreeDepartmentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeDAO getEmployeeDAO();
		
	
 	public SmartList<LevelThreeDepartment> requestCandidateLevelThreeDepartmentForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LevelThreeDepartment planToRemoveEmployeeList(LevelThreeDepartment levelThreeDepartment, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect LevelThreeDepartment with company in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithCompany(LevelThreeDepartment levelThreeDepartment, String companyId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCompany(String levelThreeDepartmentId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with occupation in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithOccupation(LevelThreeDepartment levelThreeDepartment, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String levelThreeDepartmentId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with responsible_for in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithResponsibleFor(LevelThreeDepartment levelThreeDepartment, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String levelThreeDepartmentId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect LevelThreeDepartment with current_salary_grade in Employee
	public LevelThreeDepartment planToRemoveEmployeeListWithCurrentSalaryGrade(LevelThreeDepartment levelThreeDepartment, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String levelThreeDepartmentId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	

	public SmartList<LevelThreeDepartment> queryList(String sql, Object ... parmeters);
	public Stream<LevelThreeDepartment> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateLevelThreeDepartment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId, Map<String,Object> options);
 	public int countLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId, Map<String,Object> options);
 	public Map<String, Integer> countLevelThreeDepartmentByBelongsToIds(String[] ids, Map<String,Object> options);
 	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId, int start, int count, Map<String,Object> options);
 	public void analyzeLevelThreeDepartmentByBelongsTo(SmartList<LevelThreeDepartment> resultList, String levelTwoDepartmentId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:Employee的department的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<LevelThreeDepartment> us, Map<String,Object> options) throws Exception;
	
}


