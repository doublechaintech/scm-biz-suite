
package com.doublechaintech.retailscm.retailstoredecoration;
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


public interface RetailStoreDecorationDAO extends BaseDAO{

	public SmartList<RetailStoreDecoration> loadAll();
	public RetailStoreDecoration load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreDecoration> retailStoreDecorationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreDecoration present(RetailStoreDecoration retailStoreDecoration,Map<String,Object> options) throws Exception;
	public RetailStoreDecoration clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreDecoration save(RetailStoreDecoration retailStoreDecoration,Map<String,Object> options);
	public SmartList<RetailStoreDecoration> saveRetailStoreDecorationList(SmartList<RetailStoreDecoration> retailStoreDecorationList,Map<String,Object> options);
	public SmartList<RetailStoreDecoration> removeRetailStoreDecorationList(SmartList<RetailStoreDecoration> retailStoreDecorationList,Map<String,Object> options);
	public SmartList<RetailStoreDecoration> findRetailStoreDecorationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreDecorationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreDecorationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreDecorationId, int version) throws Exception;
	public RetailStoreDecoration disconnectFromAll(String retailStoreDecorationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreDAO getRetailStoreDAO();
		
	
 	public SmartList<RetailStoreDecoration> requestCandidateRetailStoreDecorationForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreDecoration planToRemoveRetailStoreList(RetailStoreDecoration retailStoreDecoration, String retailStoreIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreDecoration with retail_store_country_center in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithRetailStoreCountryCenter(RetailStoreDecoration retailStoreDecoration, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithRetailStoreCountryCenter(String retailStoreDecorationId, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreDecoration with city_service_center in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreDecoration retailStoreDecoration, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCityServiceCenter(String retailStoreDecorationId, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreDecoration with creation in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithCreation(RetailStoreDecoration retailStoreDecoration, String creationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCreation(String retailStoreDecorationId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreDecoration with investment_invitation in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithInvestmentInvitation(RetailStoreDecoration retailStoreDecoration, String investmentInvitationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithInvestmentInvitation(String retailStoreDecorationId, String investmentInvitationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreDecoration with franchising in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithFranchising(RetailStoreDecoration retailStoreDecoration, String franchisingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithFranchising(String retailStoreDecorationId, String franchisingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreDecoration with opening in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithOpening(RetailStoreDecoration retailStoreDecoration, String openingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithOpening(String retailStoreDecorationId, String openingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreDecoration with closing in RetailStore
	public RetailStoreDecoration planToRemoveRetailStoreListWithClosing(RetailStoreDecoration retailStoreDecoration, String closingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithClosing(String retailStoreDecorationId, String closingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreDecoration> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreDecoration executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:RetailStore的decoration的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(RetailscmUserContext userContext, List<RetailStoreDecoration> us, Map<String,Object> options) throws Exception;
	
}


