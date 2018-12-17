
package com.doublechaintech.retailscm.terminationreason;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.termination.TerminationDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface TerminationReasonDAO{

	
	public TerminationReason load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TerminationReason> terminationReasonList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TerminationReason present(TerminationReason terminationReason,Map<String,Object> options) throws Exception;
	public TerminationReason clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TerminationReason save(TerminationReason terminationReason,Map<String,Object> options);
	public SmartList<TerminationReason> saveTerminationReasonList(SmartList<TerminationReason> terminationReasonList,Map<String,Object> options);
	public SmartList<TerminationReason> removeTerminationReasonList(SmartList<TerminationReason> terminationReasonList,Map<String,Object> options);
	public SmartList<TerminationReason> findTerminationReasonWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTerminationReasonWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTerminationReasonWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String terminationReasonId, int version) throws Exception;
	public TerminationReason disconnectFromAll(String terminationReasonId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TerminationDAO getTerminationDAO();
		
	
 	public SmartList<TerminationReason> requestCandidateTerminationReasonForTermination(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public TerminationReason planToRemoveTerminationList(TerminationReason terminationReason, String terminationIds[], Map<String,Object> options)throws Exception;


	//disconnect TerminationReason with type in Termination
	public TerminationReason planToRemoveTerminationListWithType(TerminationReason terminationReason, String typeId, Map<String,Object> options)throws Exception;
	public int countTerminationListWithType(String terminationReasonId, String typeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<TerminationReason> queryList(String sql, Object ... parmeters);
 
 	public SmartList<TerminationReason> findTerminationReasonByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countTerminationReasonByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countTerminationReasonByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<TerminationReason> findTerminationReasonByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeTerminationReasonByCompany(SmartList<TerminationReason> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 }


