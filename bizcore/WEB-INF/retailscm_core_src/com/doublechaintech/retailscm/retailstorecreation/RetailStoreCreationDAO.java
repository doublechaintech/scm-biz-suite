
package com.doublechaintech.retailscm.retailstorecreation;
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

import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;


public interface RetailStoreCreationDAO extends BaseDAO{

	public SmartList<RetailStoreCreation> loadAll();
	public Stream<RetailStoreCreation> loadAllAsStream();
	public RetailStoreCreation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreCreation> retailStoreCreationList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public RetailStoreCreation present(RetailStoreCreation retailStoreCreation,Map<String,Object> options) throws Exception;
	public RetailStoreCreation clone(String id, Map<String,Object> options) throws Exception;

	

	public RetailStoreCreation save(RetailStoreCreation retailStoreCreation,Map<String,Object> options);
	public SmartList<RetailStoreCreation> saveRetailStoreCreationList(SmartList<RetailStoreCreation> retailStoreCreationList,Map<String,Object> options);
	public SmartList<RetailStoreCreation> removeRetailStoreCreationList(SmartList<RetailStoreCreation> retailStoreCreationList,Map<String,Object> options);
	public SmartList<RetailStoreCreation> findRetailStoreCreationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreCreationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreCreationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreCreationId, int version) throws Exception;
	public RetailStoreCreation disconnectFromAll(String retailStoreCreationId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public RetailStoreDAO getRetailStoreDAO();
		
	
 	public SmartList<RetailStoreCreation> requestCandidateRetailStoreCreationForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreCreation planToRemoveRetailStoreList(RetailStoreCreation retailStoreCreation, String retailStoreIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCreation with retail_store_country_center in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithRetailStoreCountryCenter(RetailStoreCreation retailStoreCreation, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithRetailStoreCountryCenter(String retailStoreCreationId, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCreation with city_service_center in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreCreation retailStoreCreation, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCityServiceCenter(String retailStoreCreationId, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCreation with investment_invitation in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithInvestmentInvitation(RetailStoreCreation retailStoreCreation, String investmentInvitationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithInvestmentInvitation(String retailStoreCreationId, String investmentInvitationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCreation with franchising in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithFranchising(RetailStoreCreation retailStoreCreation, String franchisingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithFranchising(String retailStoreCreationId, String franchisingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCreation with decoration in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithDecoration(RetailStoreCreation retailStoreCreation, String decorationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithDecoration(String retailStoreCreationId, String decorationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCreation with opening in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithOpening(RetailStoreCreation retailStoreCreation, String openingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithOpening(String retailStoreCreationId, String openingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCreation with closing in RetailStore
	public RetailStoreCreation planToRemoveRetailStoreListWithClosing(RetailStoreCreation retailStoreCreation, String closingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithClosing(String retailStoreCreationId, String closingId, Map<String,Object> options)throws Exception;
	

	public SmartList<RetailStoreCreation> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<RetailStoreCreation> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateRetailStoreCreation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:RetailStore的creation的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(RetailscmUserContext userContext, List<RetailStoreCreation> us, Map<String,Object> options) throws Exception;
	

	List<RetailStoreCreation> search(RetailStoreCreationRequest pRequest);
}


