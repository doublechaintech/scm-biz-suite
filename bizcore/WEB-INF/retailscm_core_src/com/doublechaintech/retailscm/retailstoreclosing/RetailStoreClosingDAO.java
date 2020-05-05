
package com.doublechaintech.retailscm.retailstoreclosing;
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


public interface RetailStoreClosingDAO extends BaseDAO{

	public SmartList<RetailStoreClosing> loadAll();
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
	
	//disconnect RetailStoreClosing with creation in RetailStore
	public RetailStoreClosing planToRemoveRetailStoreListWithCreation(RetailStoreClosing retailStoreClosing, String creationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCreation(String retailStoreClosingId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreClosing with investment_invitation in RetailStore
	public RetailStoreClosing planToRemoveRetailStoreListWithInvestmentInvitation(RetailStoreClosing retailStoreClosing, String investmentInvitationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithInvestmentInvitation(String retailStoreClosingId, String investmentInvitationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreClosing with franchising in RetailStore
	public RetailStoreClosing planToRemoveRetailStoreListWithFranchising(RetailStoreClosing retailStoreClosing, String franchisingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithFranchising(String retailStoreClosingId, String franchisingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreClosing with decoration in RetailStore
	public RetailStoreClosing planToRemoveRetailStoreListWithDecoration(RetailStoreClosing retailStoreClosing, String decorationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithDecoration(String retailStoreClosingId, String decorationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreClosing with opening in RetailStore
	public RetailStoreClosing planToRemoveRetailStoreListWithOpening(RetailStoreClosing retailStoreClosing, String openingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithOpening(String retailStoreClosingId, String openingId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreClosing> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreClosing executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:RetailStore的closing的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(RetailscmUserContext userContext, List<RetailStoreClosing> us, Map<String,Object> options) throws Exception;
	
}


