
package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;
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


public interface RetailStoreInvestmentInvitationDAO extends BaseDAO{

	public SmartList<RetailStoreInvestmentInvitation> loadAll();
	public RetailStoreInvestmentInvitation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreInvestmentInvitation present(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String,Object> options) throws Exception;
	public RetailStoreInvestmentInvitation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreInvestmentInvitation save(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String,Object> options);
	public SmartList<RetailStoreInvestmentInvitation> saveRetailStoreInvestmentInvitationList(SmartList<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList,Map<String,Object> options);
	public SmartList<RetailStoreInvestmentInvitation> removeRetailStoreInvestmentInvitationList(SmartList<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList,Map<String,Object> options);
	public SmartList<RetailStoreInvestmentInvitation> findRetailStoreInvestmentInvitationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreInvestmentInvitationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreInvestmentInvitationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreInvestmentInvitationId, int version) throws Exception;
	public RetailStoreInvestmentInvitation disconnectFromAll(String retailStoreInvestmentInvitationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreDAO getRetailStoreDAO();
		
	
 	public SmartList<RetailStoreInvestmentInvitation> requestCandidateRetailStoreInvestmentInvitationForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreList(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String retailStoreIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreInvestmentInvitation with retail_store_country_center in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithRetailStoreCountryCenter(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithRetailStoreCountryCenter(String retailStoreInvestmentInvitationId, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreInvestmentInvitation with city_service_center in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCityServiceCenter(String retailStoreInvestmentInvitationId, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreInvestmentInvitation with creation in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithCreation(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String creationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCreation(String retailStoreInvestmentInvitationId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreInvestmentInvitation with franchising in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithFranchising(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String franchisingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithFranchising(String retailStoreInvestmentInvitationId, String franchisingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreInvestmentInvitation with decoration in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithDecoration(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String decorationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithDecoration(String retailStoreInvestmentInvitationId, String decorationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreInvestmentInvitation with opening in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithOpening(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String openingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithOpening(String retailStoreInvestmentInvitationId, String openingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreInvestmentInvitation with closing in RetailStore
	public RetailStoreInvestmentInvitation planToRemoveRetailStoreListWithClosing(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String closingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithClosing(String retailStoreInvestmentInvitationId, String closingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreInvestmentInvitation> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreInvestmentInvitation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:RetailStore的investmentInvitation的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(RetailscmUserContext userContext, List<RetailStoreInvestmentInvitation> us, Map<String,Object> options) throws Exception;
	
}


