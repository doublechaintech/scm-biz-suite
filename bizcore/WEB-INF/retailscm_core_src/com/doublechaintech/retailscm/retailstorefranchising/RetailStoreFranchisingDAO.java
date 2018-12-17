
package com.doublechaintech.retailscm.retailstorefranchising;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;


public interface RetailStoreFranchisingDAO{

	
	public RetailStoreFranchising load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreFranchising> retailStoreFranchisingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreFranchising present(RetailStoreFranchising retailStoreFranchising,Map<String,Object> options) throws Exception;
	public RetailStoreFranchising clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreFranchising save(RetailStoreFranchising retailStoreFranchising,Map<String,Object> options);
	public SmartList<RetailStoreFranchising> saveRetailStoreFranchisingList(SmartList<RetailStoreFranchising> retailStoreFranchisingList,Map<String,Object> options);
	public SmartList<RetailStoreFranchising> removeRetailStoreFranchisingList(SmartList<RetailStoreFranchising> retailStoreFranchisingList,Map<String,Object> options);
	public SmartList<RetailStoreFranchising> findRetailStoreFranchisingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreFranchisingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreFranchisingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreFranchisingId, int version) throws Exception;
	public RetailStoreFranchising disconnectFromAll(String retailStoreFranchisingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreDAO getRetailStoreDAO();
		
	
 	public SmartList<RetailStoreFranchising> requestCandidateRetailStoreFranchisingForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreFranchising planToRemoveRetailStoreList(RetailStoreFranchising retailStoreFranchising, String retailStoreIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreFranchising with retail_store_country_center in RetailStore
	public RetailStoreFranchising planToRemoveRetailStoreListWithRetailStoreCountryCenter(RetailStoreFranchising retailStoreFranchising, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithRetailStoreCountryCenter(String retailStoreFranchisingId, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreFranchising with city_service_center in RetailStore
	public RetailStoreFranchising planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreFranchising retailStoreFranchising, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCityServiceCenter(String retailStoreFranchisingId, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreFranchising> queryList(String sql, Object ... parmeters);
}


