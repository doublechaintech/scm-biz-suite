
package com.doublechaintech.retailscm.retailstoreprovincecenter;
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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentDAO;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface RetailStoreProvinceCenterDAO extends BaseDAO{

	public SmartList<RetailStoreProvinceCenter> loadAll();
	public Stream<RetailStoreProvinceCenter> loadAllAsStream();
	public RetailStoreProvinceCenter load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public RetailStoreProvinceCenter present(RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String,Object> options) throws Exception;
	public RetailStoreProvinceCenter clone(String id, Map<String,Object> options) throws Exception;

	

	public RetailStoreProvinceCenter save(RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String,Object> options);
	public SmartList<RetailStoreProvinceCenter> saveRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList,Map<String,Object> options);
	public SmartList<RetailStoreProvinceCenter> removeRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList,Map<String,Object> options);
	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreProvinceCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreProvinceCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreProvinceCenterId, int version) throws Exception;
	public RetailStoreProvinceCenter disconnectFromAll(String retailStoreProvinceCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ProvinceCenterDepartmentDAO getProvinceCenterDepartmentDAO();
		
	public ProvinceCenterEmployeeDAO getProvinceCenterEmployeeDAO();
		
	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO();
		
	
 	public SmartList<RetailStoreProvinceCenter> requestCandidateRetailStoreProvinceCenterForProvinceCenterDepartment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreProvinceCenter> requestCandidateRetailStoreProvinceCenterForProvinceCenterEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreProvinceCenter> requestCandidateRetailStoreProvinceCenterForRetailStoreCityServiceCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreProvinceCenter planToRemoveProvinceCenterDepartmentList(RetailStoreProvinceCenter retailStoreProvinceCenter, String provinceCenterDepartmentIds[], Map<String,Object> options)throws Exception;


	public RetailStoreProvinceCenter planToRemoveProvinceCenterEmployeeList(RetailStoreProvinceCenter retailStoreProvinceCenter, String provinceCenterEmployeeIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreProvinceCenter with department in ProvinceCenterEmployee
	public RetailStoreProvinceCenter planToRemoveProvinceCenterEmployeeListWithDepartment(RetailStoreProvinceCenter retailStoreProvinceCenter, String departmentId, Map<String,Object> options)throws Exception;
	public int countProvinceCenterEmployeeListWithDepartment(String retailStoreProvinceCenterId, String departmentId, Map<String,Object> options)throws Exception;
	
	public RetailStoreProvinceCenter planToRemoveRetailStoreCityServiceCenterList(RetailStoreProvinceCenter retailStoreProvinceCenter, String retailStoreCityServiceCenterIds[], Map<String,Object> options)throws Exception;



	public SmartList<RetailStoreProvinceCenter> queryList(String sql, Object ... parmeters);
	public Stream<RetailStoreProvinceCenter> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreProvinceCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreProvinceCenterByCountryIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreProvinceCenterByCountry(SmartList<RetailStoreProvinceCenter> resultList, String retailStoreCountryCenterId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:ProvinceCenterDepartment的provinceCenter的ProvinceCenterDepartmentList
	public SmartList<ProvinceCenterDepartment> loadOurProvinceCenterDepartmentList(RetailscmUserContext userContext, List<RetailStoreProvinceCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ProvinceCenterEmployee的provinceCenter的ProvinceCenterEmployeeList
	public SmartList<ProvinceCenterEmployee> loadOurProvinceCenterEmployeeList(RetailscmUserContext userContext, List<RetailStoreProvinceCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreCityServiceCenter的belongsTo的RetailStoreCityServiceCenterList
	public SmartList<RetailStoreCityServiceCenter> loadOurRetailStoreCityServiceCenterList(RetailscmUserContext userContext, List<RetailStoreProvinceCenter> us, Map<String,Object> options) throws Exception;
	
}


