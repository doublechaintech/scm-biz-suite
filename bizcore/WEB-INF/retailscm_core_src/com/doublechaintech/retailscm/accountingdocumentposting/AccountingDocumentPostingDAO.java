
package com.doublechaintech.retailscm.accountingdocumentposting;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentDAO;


public interface AccountingDocumentPostingDAO{

	
	public AccountingDocumentPosting load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingDocumentPosting> accountingDocumentPostingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AccountingDocumentPosting present(AccountingDocumentPosting accountingDocumentPosting,Map<String,Object> options) throws Exception;
	public AccountingDocumentPosting clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentPosting save(AccountingDocumentPosting accountingDocumentPosting,Map<String,Object> options);
	public SmartList<AccountingDocumentPosting> saveAccountingDocumentPostingList(SmartList<AccountingDocumentPosting> accountingDocumentPostingList,Map<String,Object> options);
	public SmartList<AccountingDocumentPosting> removeAccountingDocumentPostingList(SmartList<AccountingDocumentPosting> accountingDocumentPostingList,Map<String,Object> options);
	public SmartList<AccountingDocumentPosting> findAccountingDocumentPostingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingDocumentPostingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingDocumentPostingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingDocumentPostingId, int version) throws Exception;
	public AccountingDocumentPosting disconnectFromAll(String accountingDocumentPostingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AccountingDocumentDAO getAccountingDocumentDAO();
		
	
 	public SmartList<AccountingDocumentPosting> requestCandidateAccountingDocumentPostingForAccountingDocument(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingDocumentPosting planToRemoveAccountingDocumentList(AccountingDocumentPosting accountingDocumentPosting, String accountingDocumentIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingDocumentPosting with accounting_period in AccountingDocument
	public AccountingDocumentPosting planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentPosting accountingDocumentPosting, String accountingPeriodId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentPostingId, String accountingPeriodId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentPosting with document_type in AccountingDocument
	public AccountingDocumentPosting planToRemoveAccountingDocumentListWithDocumentType(AccountingDocumentPosting accountingDocumentPosting, String documentTypeId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithDocumentType(String accountingDocumentPostingId, String documentTypeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<AccountingDocumentPosting> queryList(String sql, Object ... parmeters);
}


