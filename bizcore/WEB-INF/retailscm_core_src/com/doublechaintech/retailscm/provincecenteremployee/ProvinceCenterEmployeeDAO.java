
package com.doublechaintech.retailscm.provincecenteremployee;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;

import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentDAO;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;


public interface ProvinceCenterEmployeeDAO extends BaseDAO{

	public SmartList<ProvinceCenterEmployee> loadAll();
	public ProvinceCenterEmployee load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ProvinceCenterEmployee> provinceCenterEmployeeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ProvinceCenterEmployee present(ProvinceCenterEmployee provinceCenterEmployee,Map<String,Object> options) throws Exception;
	public ProvinceCenterEmployee clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ProvinceCenterEmployee save(ProvinceCenterEmployee provinceCenterEmployee,Map<String,Object> options);
	public SmartList<ProvinceCenterEmployee> saveProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList,Map<String,Object> options);
	public SmartList<ProvinceCenterEmployee> removeProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList,Map<String,Object> options);
	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProvinceCenterEmployeeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProvinceCenterEmployeeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String provinceCenterEmployeeId, int version) throws Exception;
	public ProvinceCenterEmployee disconnectFromAll(String provinceCenterEmployeeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ProvinceCenterEmployee> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateProvinceCenterEmployee executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByDepartment(String provinceCenterDepartmentId, Map<String,Object> options);
 	public int countProvinceCenterEmployeeByDepartment(String provinceCenterDepartmentId, Map<String,Object> options);
 	public Map<String, Integer> countProvinceCenterEmployeeByDepartmentIds(String[] ids, Map<String,Object> options);
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByDepartment(String provinceCenterDepartmentId, int start, int count, Map<String,Object> options);
 	public void analyzeProvinceCenterEmployeeByDepartment(SmartList<ProvinceCenterEmployee> resultList, String provinceCenterDepartmentId, Map<String,Object> options);

 
  
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByProvinceCenter(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public int countProvinceCenterEmployeeByProvinceCenter(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public Map<String, Integer> countProvinceCenterEmployeeByProvinceCenterIds(String[] ids, Map<String,Object> options);
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByProvinceCenter(String retailStoreProvinceCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeProvinceCenterEmployeeByProvinceCenter(SmartList<ProvinceCenterEmployee> resultList, String retailStoreProvinceCenterId, Map<String,Object> options);

 
 
}


