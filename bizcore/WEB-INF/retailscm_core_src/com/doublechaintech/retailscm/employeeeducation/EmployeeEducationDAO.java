
package com.doublechaintech.retailscm.employeeeducation;
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

import com.doublechaintech.retailscm.employee.EmployeeDAO;


public interface EmployeeEducationDAO extends BaseDAO{

	public SmartList<EmployeeEducation> loadAll();
	public Stream<EmployeeEducation> loadAllAsStream();
	public EmployeeEducation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeEducation> employeeEducationList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public EmployeeEducation present(EmployeeEducation employeeEducation,Map<String,Object> options) throws Exception;
	public EmployeeEducation clone(String id, Map<String,Object> options) throws Exception;

	

	public EmployeeEducation save(EmployeeEducation employeeEducation,Map<String,Object> options);
	public SmartList<EmployeeEducation> saveEmployeeEducationList(SmartList<EmployeeEducation> employeeEducationList,Map<String,Object> options);
	public SmartList<EmployeeEducation> removeEmployeeEducationList(SmartList<EmployeeEducation> employeeEducationList,Map<String,Object> options);
	public SmartList<EmployeeEducation> findEmployeeEducationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeEducationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeEducationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeEducationId, int version) throws Exception;
	public EmployeeEducation disconnectFromAll(String employeeEducationId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	
	

	public SmartList<EmployeeEducation> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<EmployeeEducation> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateEmployeeEducation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<EmployeeEducation> findEmployeeEducationByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeEducationByEmployee(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeEducationByEmployeeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeEducation> findEmployeeEducationByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeEducationByEmployee(SmartList<EmployeeEducation> resultList, String employeeId, Map<String,Object> options);


 

	List<EmployeeEducation> search(EmployeeEducationRequest pRequest);
}


