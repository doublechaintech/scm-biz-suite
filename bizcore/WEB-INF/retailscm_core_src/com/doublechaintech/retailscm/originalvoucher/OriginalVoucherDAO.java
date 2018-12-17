
package com.doublechaintech.retailscm.originalvoucher;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.originalvoucherauditing.OriginalVoucherAuditingDAO;
import com.doublechaintech.retailscm.originalvouchercreation.OriginalVoucherCreationDAO;
import com.doublechaintech.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmationDAO;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentDAO;


public interface OriginalVoucherDAO{

	
	public OriginalVoucher load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<OriginalVoucher> originalVoucherList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public OriginalVoucher present(OriginalVoucher originalVoucher,Map<String,Object> options) throws Exception;
	public OriginalVoucher clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OriginalVoucher save(OriginalVoucher originalVoucher,Map<String,Object> options);
	public SmartList<OriginalVoucher> saveOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options);
	public SmartList<OriginalVoucher> removeOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options);
	public SmartList<OriginalVoucher> findOriginalVoucherWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countOriginalVoucherWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countOriginalVoucherWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String originalVoucherId, int version) throws Exception;
	public OriginalVoucher disconnectFromAll(String originalVoucherId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<OriginalVoucher> queryList(String sql, Object ... parmeters);
 
 	public SmartList<OriginalVoucher> findOriginalVoucherByBelongsTo(String accountingDocumentId, Map<String,Object> options);
 	public int countOriginalVoucherByBelongsTo(String accountingDocumentId, Map<String,Object> options);
 	public Map<String, Integer> countOriginalVoucherByBelongsToIds(String[] ids, Map<String,Object> options);
 	public SmartList<OriginalVoucher> findOriginalVoucherByBelongsTo(String accountingDocumentId, int start, int count, Map<String,Object> options);
 	public void analyzeOriginalVoucherByBelongsTo(SmartList<OriginalVoucher> resultList, String accountingDocumentId, Map<String,Object> options);

 
  
 	public SmartList<OriginalVoucher> findOriginalVoucherByCreation(String originalVoucherCreationId, Map<String,Object> options);
 	public int countOriginalVoucherByCreation(String originalVoucherCreationId, Map<String,Object> options);
 	public Map<String, Integer> countOriginalVoucherByCreationIds(String[] ids, Map<String,Object> options);
 	public SmartList<OriginalVoucher> findOriginalVoucherByCreation(String originalVoucherCreationId, int start, int count, Map<String,Object> options);
 	public void analyzeOriginalVoucherByCreation(SmartList<OriginalVoucher> resultList, String originalVoucherCreationId, Map<String,Object> options);

 
  
 	public SmartList<OriginalVoucher> findOriginalVoucherByConfirmation(String originalVoucherConfirmationId, Map<String,Object> options);
 	public int countOriginalVoucherByConfirmation(String originalVoucherConfirmationId, Map<String,Object> options);
 	public Map<String, Integer> countOriginalVoucherByConfirmationIds(String[] ids, Map<String,Object> options);
 	public SmartList<OriginalVoucher> findOriginalVoucherByConfirmation(String originalVoucherConfirmationId, int start, int count, Map<String,Object> options);
 	public void analyzeOriginalVoucherByConfirmation(SmartList<OriginalVoucher> resultList, String originalVoucherConfirmationId, Map<String,Object> options);

 
  
 	public SmartList<OriginalVoucher> findOriginalVoucherByAuditing(String originalVoucherAuditingId, Map<String,Object> options);
 	public int countOriginalVoucherByAuditing(String originalVoucherAuditingId, Map<String,Object> options);
 	public Map<String, Integer> countOriginalVoucherByAuditingIds(String[] ids, Map<String,Object> options);
 	public SmartList<OriginalVoucher> findOriginalVoucherByAuditing(String originalVoucherAuditingId, int start, int count, Map<String,Object> options);
 	public void analyzeOriginalVoucherByAuditing(SmartList<OriginalVoucher> resultList, String originalVoucherAuditingId, Map<String,Object> options);

 
 }


