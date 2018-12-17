
package com.doublechaintech.retailscm.retailstorecityservicecenter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.doublechaintech.retailscm.cityevent.CityEventDAO;
import com.doublechaintech.retailscm.citypartner.CityPartnerDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;


public interface RetailStoreCityServiceCenterDAO{

	
	public RetailStoreCityServiceCenter load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreCityServiceCenter present(RetailStoreCityServiceCenter retailStoreCityServiceCenter,Map<String,Object> options) throws Exception;
	public RetailStoreCityServiceCenter clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreCityServiceCenter save(RetailStoreCityServiceCenter retailStoreCityServiceCenter,Map<String,Object> options);
	public SmartList<RetailStoreCityServiceCenter> saveRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList,Map<String,Object> options);
	public SmartList<RetailStoreCityServiceCenter> removeRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList,Map<String,Object> options);
	public SmartList<RetailStoreCityServiceCenter> findRetailStoreCityServiceCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreCityServiceCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreCityServiceCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreCityServiceCenterId, int version) throws Exception;
	public RetailStoreCityServiceCenter disconnectFromAll(String retailStoreCityServiceCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public CityPartnerDAO getCityPartnerDAO();
		
	public PotentialCustomerDAO getPotentialCustomerDAO();
		
	public CityEventDAO getCityEventDAO();
		
	public RetailStoreDAO getRetailStoreDAO();
		
	
 	public SmartList<RetailStoreCityServiceCenter> requestCandidateRetailStoreCityServiceCenterForCityPartner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCityServiceCenter> requestCandidateRetailStoreCityServiceCenterForPotentialCustomer(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCityServiceCenter> requestCandidateRetailStoreCityServiceCenterForCityEvent(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCityServiceCenter> requestCandidateRetailStoreCityServiceCenterForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreCityServiceCenter planToRemoveCityPartnerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String cityPartnerIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCityServiceCenter planToRemovePotentialCustomerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String potentialCustomerIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCityServiceCenter with city_partner in PotentialCustomer
	public RetailStoreCityServiceCenter planToRemovePotentialCustomerListWithCityPartner(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String cityPartnerId, Map<String,Object> options)throws Exception;
	public int countPotentialCustomerListWithCityPartner(String retailStoreCityServiceCenterId, String cityPartnerId, Map<String,Object> options)throws Exception;
	
	public RetailStoreCityServiceCenter planToRemoveCityEventList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String cityEventIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCityServiceCenter planToRemoveRetailStoreList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String retailStoreIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCityServiceCenter with retail_store_country_center in RetailStore
	public RetailStoreCityServiceCenter planToRemoveRetailStoreListWithRetailStoreCountryCenter(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithRetailStoreCountryCenter(String retailStoreCityServiceCenterId, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreCityServiceCenter> queryList(String sql, Object ... parmeters);
 
 	public SmartList<RetailStoreCityServiceCenter> findRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public int countRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreCityServiceCenterByBelongsToIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreCityServiceCenter> findRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreCityServiceCenterByBelongsTo(SmartList<RetailStoreCityServiceCenter> resultList, String retailStoreProvinceCenterId, Map<String,Object> options);

 
 }


