
package com.doublechaintech.retailscm.retailstoreclosing;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;


public interface RetailStoreClosingDAO{

	
	public RetailStoreClosing load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreClosing> retailStoreClosingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreClosing present(RetailStoreClosing retailStoreClosing,Map<String,Object> options) throws Exception;
	public RetailStoreClosing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreClosing save(RetailStoreClosing retailStoreClosing,Map<String,Object> options);
	public SmartList<RetailStoreClosing> saveRetailStoreClosingList(SmartList<RetailStoreClosing> retailStoreClosingList,Map<String,Object> options);
	public SmartList<RetailStoreClosing> removeRetailStoreClosingList(SmartList<RetailStoreClosing> retailStoreClosingList,Map<String,Object> options);
	public SmartList<RetailStoreClosing> findRetailStoreClosingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreClosingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreClosingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreClosingId, int version) throws Exception;
	public RetailStoreClosing disconnectFromAll(String retailStoreClosingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreDAO getRetailStoreDAO();
		
	
 	public SmartList<RetailStoreClosing> requestCandidateRetailStoreClosingForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreClosing planToRemoveRetailStoreList(RetailStoreClosing retailStoreClosing, String retailStoreIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreClosing with retail_store_country_center in RetailStore
	public RetailStoreClosing planToRemoveRetailStoreListWithRetailStoreCountryCenter(RetailStoreClosing retailStoreClosing, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithRetailStoreCountryCenter(String retailStoreClosingId, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreClosing with city_service_center in RetailStore
	public RetailStoreClosing planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreClosing retailStoreClosing, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCityServiceCenter(String retailStoreClosingId, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreClosing> queryList(String sql, Object ... parmeters);
}


