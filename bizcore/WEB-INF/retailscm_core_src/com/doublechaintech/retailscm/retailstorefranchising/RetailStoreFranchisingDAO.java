
package com.doublechaintech.retailscm.retailstorefranchising;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.retailstore.RetailStore;

import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;


public interface RetailStoreFranchisingDAO extends BaseDAO{

	public SmartList<RetailStoreFranchising> loadAll();
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
	
	//disconnect RetailStoreFranchising with creation in RetailStore
	public RetailStoreFranchising planToRemoveRetailStoreListWithCreation(RetailStoreFranchising retailStoreFranchising, String creationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCreation(String retailStoreFranchisingId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreFranchising with investment_invitation in RetailStore
	public RetailStoreFranchising planToRemoveRetailStoreListWithInvestmentInvitation(RetailStoreFranchising retailStoreFranchising, String investmentInvitationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithInvestmentInvitation(String retailStoreFranchisingId, String investmentInvitationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreFranchising with decoration in RetailStore
	public RetailStoreFranchising planToRemoveRetailStoreListWithDecoration(RetailStoreFranchising retailStoreFranchising, String decorationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithDecoration(String retailStoreFranchisingId, String decorationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreFranchising with opening in RetailStore
	public RetailStoreFranchising planToRemoveRetailStoreListWithOpening(RetailStoreFranchising retailStoreFranchising, String openingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithOpening(String retailStoreFranchisingId, String openingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreFranchising with closing in RetailStore
	public RetailStoreFranchising planToRemoveRetailStoreListWithClosing(RetailStoreFranchising retailStoreFranchising, String closingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithClosing(String retailStoreFranchisingId, String closingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreFranchising> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreFranchising executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:RetailStore的franchising的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(RetailscmUserContext userContext, List<RetailStoreFranchising> us, Map<String,Object> options) throws Exception;
	
}


