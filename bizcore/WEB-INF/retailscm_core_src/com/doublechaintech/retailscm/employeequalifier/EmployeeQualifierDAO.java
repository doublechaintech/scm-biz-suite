
package com.doublechaintech.retailscm.employeequalifier;
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


public interface EmployeeQualifierDAO extends BaseDAO{

	public SmartList<EmployeeQualifier> loadAll();
	public Stream<EmployeeQualifier> loadAllAsStream();
	public EmployeeQualifier load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<EmployeeQualifier> employeeQualifierList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public EmployeeQualifier present(EmployeeQualifier employeeQualifier,Map<String,Object> options) throws Exception;
	public EmployeeQualifier clone(String id, Map<String,Object> options) throws Exception;

	

	public EmployeeQualifier save(EmployeeQualifier employeeQualifier,Map<String,Object> options);
	public SmartList<EmployeeQualifier> saveEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList,Map<String,Object> options);
	public SmartList<EmployeeQualifier> removeEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList,Map<String,Object> options);
	public SmartList<EmployeeQualifier> findEmployeeQualifierWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countEmployeeQualifierWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countEmployeeQualifierWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String employeeQualifierId, int version) throws Exception;
	public EmployeeQualifier disconnectFromAll(String employeeQualifierId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	
	

	public SmartList<EmployeeQualifier> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<EmployeeQualifier> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateEmployeeQualifier executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<EmployeeQualifier> findEmployeeQualifierByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeQualifierByEmployee(String employeeId, Map<String,Object> options);
 	public Map<String, Integer> countEmployeeQualifierByEmployeeIds(String[] ids, Map<String,Object> options);
 	public SmartList<EmployeeQualifier> findEmployeeQualifierByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 	public void analyzeEmployeeQualifierByEmployee(SmartList<EmployeeQualifier> resultList, String employeeId, Map<String,Object> options);


 

	List<EmployeeQualifier> search(EmployeeQualifierRequest pRequest);
}


