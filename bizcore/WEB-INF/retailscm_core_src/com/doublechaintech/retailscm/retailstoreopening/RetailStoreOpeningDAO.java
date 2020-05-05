
package com.doublechaintech.retailscm.retailstoreopening;
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


public interface RetailStoreOpeningDAO extends BaseDAO{

	public SmartList<RetailStoreOpening> loadAll();
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
	
	//disconnect RetailStoreOpening with creation in RetailStore
	public RetailStoreOpening planToRemoveRetailStoreListWithCreation(RetailStoreOpening retailStoreOpening, String creationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCreation(String retailStoreOpeningId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOpening with investment_invitation in RetailStore
	public RetailStoreOpening planToRemoveRetailStoreListWithInvestmentInvitation(RetailStoreOpening retailStoreOpening, String investmentInvitationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithInvestmentInvitation(String retailStoreOpeningId, String investmentInvitationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOpening with franchising in RetailStore
	public RetailStoreOpening planToRemoveRetailStoreListWithFranchising(RetailStoreOpening retailStoreOpening, String franchisingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithFranchising(String retailStoreOpeningId, String franchisingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOpening with decoration in RetailStore
	public RetailStoreOpening planToRemoveRetailStoreListWithDecoration(RetailStoreOpening retailStoreOpening, String decorationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithDecoration(String retailStoreOpeningId, String decorationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreOpening with closing in RetailStore
	public RetailStoreOpening planToRemoveRetailStoreListWithClosing(RetailStoreOpening retailStoreOpening, String closingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithClosing(String retailStoreOpeningId, String closingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreOpening> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreOpening executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:RetailStore的opening的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(RetailscmUserContext userContext, List<RetailStoreOpening> us, Map<String,Object> options) throws Exception;
	
}


