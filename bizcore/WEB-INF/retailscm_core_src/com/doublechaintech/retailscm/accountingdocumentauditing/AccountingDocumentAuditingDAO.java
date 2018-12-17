
package com.doublechaintech.retailscm.accountingdocumentauditing;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentDAO;


public interface AccountingDocumentAuditingDAO{

	
	public AccountingDocumentAuditing load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingDocumentAuditing> accountingDocumentAuditingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AccountingDocumentAuditing present(AccountingDocumentAuditing accountingDocumentAuditing,Map<String,Object> options) throws Exception;
	public AccountingDocumentAuditing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentAuditing save(AccountingDocumentAuditing accountingDocumentAuditing,Map<String,Object> options);
	public SmartList<AccountingDocumentAuditing> saveAccountingDocumentAuditingList(SmartList<AccountingDocumentAuditing> accountingDocumentAuditingList,Map<String,Object> options);
	public SmartList<AccountingDocumentAuditing> removeAccountingDocumentAuditingList(SmartList<AccountingDocumentAuditing> accountingDocumentAuditingList,Map<String,Object> options);
	public SmartList<AccountingDocumentAuditing> findAccountingDocumentAuditingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingDocumentAuditingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingDocumentAuditingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingDocumentAuditingId, int version) throws Exception;
	public AccountingDocumentAuditing disconnectFromAll(String accountingDocumentAuditingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AccountingDocumentDAO getAccountingDocumentDAO();
		
	
 	public SmartList<AccountingDocumentAuditing> requestCandidateAccountingDocumentAuditingForAccountingDocument(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingDocumentAuditing planToRemoveAccountingDocumentList(AccountingDocumentAuditing accountingDocumentAuditing, String accountingDocumentIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingDocumentAuditing with accounting_period in AccountingDocument
	public AccountingDocumentAuditing planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentAuditing accountingDocumentAuditing, String accountingPeriodId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentAuditingId, String accountingPeriodId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentAuditing with document_type in AccountingDocument
	public AccountingDocumentAuditing planToRemoveAccountingDocumentListWithDocumentType(AccountingDocumentAuditing accountingDocumentAuditing, String documentTypeId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithDocumentType(String accountingDocumentAuditingId, String documentTypeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<AccountingDocumentAuditing> queryList(String sql, Object ... parmeters);
}


