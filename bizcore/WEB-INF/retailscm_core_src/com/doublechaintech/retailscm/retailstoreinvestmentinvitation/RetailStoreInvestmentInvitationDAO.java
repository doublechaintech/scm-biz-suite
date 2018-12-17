
package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;


public interface RetailStoreInvestmentInvitationDAO{

	
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
	
	
	public SmartList<RetailStoreInvestmentInvitation> queryList(String sql, Object ... parmeters);
}


