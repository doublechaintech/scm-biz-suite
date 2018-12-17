
package com.doublechaintech.retailscm.retailstoreopening;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;


public interface RetailStoreOpeningDAO{

	
	public RetailStoreOpening load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOpening> retailStoreOpeningList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOpening present(RetailStoreOpening retailStoreOpening,Map<String,Object> options) throws Exception;
	public RetailStoreOpening clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOpening save(RetailStoreOpening retailStoreOpening,Map<String,Object> options);
	public SmartList<RetailStoreOpening> saveRetailStoreOpeningList(SmartList<RetailStoreOpening> retailStoreOpeningList,Map<String,Object> options);
	public SmartList<RetailStoreOpening> removeRetailStoreOpeningList(SmartList<RetailStoreOpening> retailStoreOpeningList,Map<String,Object> options);
	public SmartList<RetailStoreOpening> findRetailStoreOpeningWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOpeningWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOpeningWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOpeningId, int version) throws Exception;
	public RetailStoreOpening disconnectFromAll(String retailStoreOpeningId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreDAO getRetailStoreDAO();
		
	
 	public SmartList<RetailStoreOpening> requestCandidateRetailStoreOpeningForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreOpening planToRemoveRetailStoreList(RetailStoreOpening retailStoreOpening, String retailStoreIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreOpening with retail_store_country_center in RetailStore
	public RetailStoreOpening planToRemoveRetailStoreListWithRetailStoreCountryCenter(RetailStoreOpening retailStoreOpening, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithRetailStoreCountryCenter(String retailStoreOpeningId, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOpening with city_service_center in RetailStore
	public RetailStoreOpening planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreOpening retailStoreOpening, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCityServiceCenter(String retailStoreOpeningId, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOpening> queryList(String sql, Object ... parmeters);
}


