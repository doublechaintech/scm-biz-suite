
package com.doublechaintech.retailscm.provincecenterdepartment;
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

import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;

import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeDAO;


public interface ProvinceCenterDepartmentDAO extends BaseDAO{

	public SmartList<ProvinceCenterDepartment> loadAll();
	public Stream<ProvinceCenterDepartment> loadAllAsStream();
	public ProvinceCenterDepartment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ProvinceCenterDepartment> provinceCenterDepartmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public ProvinceCenterDepartment present(ProvinceCenterDepartment provinceCenterDepartment,Map<String,Object> options) throws Exception;
	public ProvinceCenterDepartment clone(String id, Map<String,Object> options) throws Exception;

	

	public ProvinceCenterDepartment save(ProvinceCenterDepartment provinceCenterDepartment,Map<String,Object> options);
	public SmartList<ProvinceCenterDepartment> saveProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList,Map<String,Object> options);
	public SmartList<ProvinceCenterDepartment> removeProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList,Map<String,Object> options);
	public SmartList<ProvinceCenterDepartment> findProvinceCenterDepartmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProvinceCenterDepartmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProvinceCenterDepartmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String provinceCenterDepartmentId, int version) throws Exception;
	public ProvinceCenterDepartment disconnectFromAll(String provinceCenterDepartmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public ProvinceCenterEmployeeDAO getProvinceCenterEmployeeDAO();
		
	
 	public SmartList<ProvinceCenterDepartment> requestCandidateProvinceCenterDepartmentForProvinceCenterEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ProvinceCenterDepartment planToRemoveProvinceCenterEmployeeList(ProvinceCenterDepartment provinceCenterDepartment, String provinceCenterEmployeeIds[], Map<String,Object> options)throws Exception;


	//disconnect ProvinceCenterDepartment with province_center in ProvinceCenterEmployee
	public ProvinceCenterDepartment planToRemoveProvinceCenterEmployeeListWithProvinceCenter(ProvinceCenterDepartment provinceCenterDepartment, String provinceCenterId, Map<String,Object> options)throws Exception;
	public int countProvinceCenterEmployeeListWithProvinceCenter(String provinceCenterDepartmentId, String provinceCenterId, Map<String,Object> options)throws Exception;
	

	public SmartList<ProvinceCenterDepartment> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<ProvinceCenterDepartment> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateProvinceCenterDepartment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<ProvinceCenterDepartment> findProvinceCenterDepartmentByProvinceCenter(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public int countProvinceCenterDepartmentByProvinceCenter(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public Map<String, Integer> countProvinceCenterDepartmentByProvinceCenterIds(String[] ids, Map<String,Object> options);
 	public SmartList<ProvinceCenterDepartment> findProvinceCenterDepartmentByProvinceCenter(String retailStoreProvinceCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeProvinceCenterDepartmentByProvinceCenter(SmartList<ProvinceCenterDepartment> resultList, String retailStoreProvinceCenterId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:ProvinceCenterEmployee的department的ProvinceCenterEmployeeList
	public SmartList<ProvinceCenterEmployee> loadOurProvinceCenterEmployeeList(RetailscmUserContext userContext, List<ProvinceCenterDepartment> us, Map<String,Object> options) throws Exception;
	

	List<ProvinceCenterDepartment> search(ProvinceCenterDepartmentRequest pRequest);
}


