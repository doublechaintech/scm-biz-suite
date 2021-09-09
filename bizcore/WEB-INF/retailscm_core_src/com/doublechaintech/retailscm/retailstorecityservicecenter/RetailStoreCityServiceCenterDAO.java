
package com.doublechaintech.retailscm.retailstorecityservicecenter;
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

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEvent;
import com.doublechaintech.retailscm.citypartner.CityPartner;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.doublechaintech.retailscm.cityevent.CityEventDAO;
import com.doublechaintech.retailscm.citypartner.CityPartnerDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;


public interface RetailStoreCityServiceCenterDAO extends BaseDAO{

	public SmartList<RetailStoreCityServiceCenter> loadAll();
	public Stream<RetailStoreCityServiceCenter> loadAllAsStream();
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
	public void resetNextId();

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
	
	//disconnect RetailStoreCityServiceCenter with creation in RetailStore
	public RetailStoreCityServiceCenter planToRemoveRetailStoreListWithCreation(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String creationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCreation(String retailStoreCityServiceCenterId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCityServiceCenter with investment_invitation in RetailStore
	public RetailStoreCityServiceCenter planToRemoveRetailStoreListWithInvestmentInvitation(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String investmentInvitationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithInvestmentInvitation(String retailStoreCityServiceCenterId, String investmentInvitationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCityServiceCenter with franchising in RetailStore
	public RetailStoreCityServiceCenter planToRemoveRetailStoreListWithFranchising(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String franchisingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithFranchising(String retailStoreCityServiceCenterId, String franchisingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCityServiceCenter with decoration in RetailStore
	public RetailStoreCityServiceCenter planToRemoveRetailStoreListWithDecoration(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String decorationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithDecoration(String retailStoreCityServiceCenterId, String decorationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCityServiceCenter with opening in RetailStore
	public RetailStoreCityServiceCenter planToRemoveRetailStoreListWithOpening(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String openingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithOpening(String retailStoreCityServiceCenterId, String openingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCityServiceCenter with closing in RetailStore
	public RetailStoreCityServiceCenter planToRemoveRetailStoreListWithClosing(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String closingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithClosing(String retailStoreCityServiceCenterId, String closingId, Map<String,Object> options)throws Exception;
	

	public SmartList<RetailStoreCityServiceCenter> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<RetailStoreCityServiceCenter> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateRetailStoreCityServiceCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<RetailStoreCityServiceCenter> findRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public int countRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreCityServiceCenterByBelongsToIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreCityServiceCenter> findRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreCityServiceCenterByBelongsTo(SmartList<RetailStoreCityServiceCenter> resultList, String retailStoreProvinceCenterId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:CityPartner的cityServiceCenter的CityPartnerList
	public SmartList<CityPartner> loadOurCityPartnerList(RetailscmUserContext userContext, List<RetailStoreCityServiceCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomer的cityServiceCenter的PotentialCustomerList
	public SmartList<PotentialCustomer> loadOurPotentialCustomerList(RetailscmUserContext userContext, List<RetailStoreCityServiceCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:CityEvent的cityServiceCenter的CityEventList
	public SmartList<CityEvent> loadOurCityEventList(RetailscmUserContext userContext, List<RetailStoreCityServiceCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStore的cityServiceCenter的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(RetailscmUserContext userContext, List<RetailStoreCityServiceCenter> us, Map<String,Object> options) throws Exception;
	

	List<RetailStoreCityServiceCenter> search(RetailStoreCityServiceCenterRequest pRequest);
}


