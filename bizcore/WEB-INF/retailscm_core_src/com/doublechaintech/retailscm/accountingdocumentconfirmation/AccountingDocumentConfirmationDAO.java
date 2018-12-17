
package com.doublechaintech.retailscm.accountingdocumentconfirmation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentDAO;


public interface AccountingDocumentConfirmationDAO{

	
	public AccountingDocumentConfirmation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingDocumentConfirmation> accountingDocumentConfirmationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AccountingDocumentConfirmation present(AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String,Object> options) throws Exception;
	public AccountingDocumentConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountingDocumentConfirmation save(AccountingDocumentConfirmation accountingDocumentConfirmation,Map<String,Object> options);
	public SmartList<AccountingDocumentConfirmation> saveAccountingDocumentConfirmationList(SmartList<AccountingDocumentConfirmation> accountingDocumentConfirmationList,Map<String,Object> options);
	public SmartList<AccountingDocumentConfirmation> removeAccountingDocumentConfirmationList(SmartList<AccountingDocumentConfirmation> accountingDocumentConfirmationList,Map<String,Object> options);
	public SmartList<AccountingDocumentConfirmation> findAccountingDocumentConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingDocumentConfirmationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingDocumentConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingDocumentConfirmationId, int version) throws Exception;
	public AccountingDocumentConfirmation disconnectFromAll(String accountingDocumentConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AccountingDocumentDAO getAccountingDocumentDAO();
		
	
 	public SmartList<AccountingDocumentConfirmation> requestCandidateAccountingDocumentConfirmationForAccountingDocument(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingDocumentConfirmation planToRemoveAccountingDocumentList(AccountingDocumentConfirmation accountingDocumentConfirmation, String accountingDocumentIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingDocumentConfirmation with accounting_period in AccountingDocument
	public AccountingDocumentConfirmation planToRemoveAccountingDocumentListWithAccountingPeriod(AccountingDocumentConfirmation accountingDocumentConfirmation, String accountingPeriodId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithAccountingPeriod(String accountingDocumentConfirmationId, String accountingPeriodId, Map<String,Object> options)throws Exception;
	
	//disconnect AccountingDocumentConfirmation with document_type in AccountingDocument
	public AccountingDocumentConfirmation planToRemoveAccountingDocumentListWithDocumentType(AccountingDocumentConfirmation accountingDocumentConfirmation, String documentTypeId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentListWithDocumentType(String accountingDocumentConfirmationId, String documentTypeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<AccountingDocumentConfirmation> queryList(String sql, Object ... parmeters);
}


