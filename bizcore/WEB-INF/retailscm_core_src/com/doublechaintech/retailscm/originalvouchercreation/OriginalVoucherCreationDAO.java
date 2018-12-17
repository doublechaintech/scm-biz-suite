
package com.doublechaintech.retailscm.originalvouchercreation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucherDAO;


public interface OriginalVoucherCreationDAO{

	
	public OriginalVoucherCreation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<OriginalVoucherCreation> originalVoucherCreationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public OriginalVoucherCreation present(OriginalVoucherCreation originalVoucherCreation,Map<String,Object> options) throws Exception;
	public OriginalVoucherCreation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OriginalVoucherCreation save(OriginalVoucherCreation originalVoucherCreation,Map<String,Object> options);
	public SmartList<OriginalVoucherCreation> saveOriginalVoucherCreationList(SmartList<OriginalVoucherCreation> originalVoucherCreationList,Map<String,Object> options);
	public SmartList<OriginalVoucherCreation> removeOriginalVoucherCreationList(SmartList<OriginalVoucherCreation> originalVoucherCreationList,Map<String,Object> options);
	public SmartList<OriginalVoucherCreation> findOriginalVoucherCreationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countOriginalVoucherCreationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countOriginalVoucherCreationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String originalVoucherCreationId, int version) throws Exception;
	public OriginalVoucherCreation disconnectFromAll(String originalVoucherCreationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public OriginalVoucherDAO getOriginalVoucherDAO();
		
	
 	public SmartList<OriginalVoucherCreation> requestCandidateOriginalVoucherCreationForOriginalVoucher(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public OriginalVoucherCreation planToRemoveOriginalVoucherList(OriginalVoucherCreation originalVoucherCreation, String originalVoucherIds[], Map<String,Object> options)throws Exception;


	//disconnect OriginalVoucherCreation with belongs_to in OriginalVoucher
	public OriginalVoucherCreation planToRemoveOriginalVoucherListWithBelongsTo(OriginalVoucherCreation originalVoucherCreation, String belongsToId, Map<String,Object> options)throws Exception;
	public int countOriginalVoucherListWithBelongsTo(String originalVoucherCreationId, String belongsToId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<OriginalVoucherCreation> queryList(String sql, Object ... parmeters);
}


