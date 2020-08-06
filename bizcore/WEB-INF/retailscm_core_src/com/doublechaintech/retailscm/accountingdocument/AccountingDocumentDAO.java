
package com.doublechaintech.retailscm.accountingdocument;
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

import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;

import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodDAO;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucherDAO;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineDAO;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeDAO;


public interface AccountingDocumentDAO extends BaseDAO{

	public SmartList<AccountingDocument> loadAll();
	public Stream<AccountingDocument> loadAllAsStream();
	public AccountingDocument load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingDocument> accountingDocumentList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public AccountingDocument present(AccountingDocument accountingDocument,Map<String,Object> options) throws Exception;
	public AccountingDocument clone(String id, Map<String,Object> options) throws Exception;

	

	public AccountingDocument save(AccountingDocument accountingDocument,Map<String,Object> options);
	public SmartList<AccountingDocument> saveAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options);
	public SmartList<AccountingDocument> removeAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList,Map<String,Object> options);
	public SmartList<AccountingDocument> findAccountingDocumentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingDocumentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingDocumentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingDocumentId, int version) throws Exception;
	public AccountingDocument disconnectFromAll(String accountingDocumentId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public OriginalVoucherDAO getOriginalVoucherDAO();
		
	public AccountingDocumentLineDAO getAccountingDocumentLineDAO();
		
	
 	public SmartList<AccountingDocument> requestCandidateAccountingDocumentForOriginalVoucher(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<AccountingDocument> requestCandidateAccountingDocumentForAccountingDocumentLine(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingDocument planToRemoveOriginalVoucherList(AccountingDocument accountingDocument, String originalVoucherIds[], Map<String,Object> options)throws Exception;


	public AccountingDocument planToRemoveAccountingDocumentLineList(AccountingDocument accountingDocument, String accountingDocumentLineIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingDocument with accounting_subject in AccountingDocumentLine
	public AccountingDocument planToRemoveAccountingDocumentLineListWithAccountingSubject(AccountingDocument accountingDocument, String accountingSubjectId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentLineListWithAccountingSubject(String accountingDocumentId, String accountingSubjectId, Map<String,Object> options)throws Exception;
	

	public SmartList<AccountingDocument> queryList(String sql, Object ... parmeters);
	public Stream<AccountingDocument> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateAccountingDocument executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<AccountingDocument> findAccountingDocumentByAccountingPeriod(String accountingPeriodId, Map<String,Object> options);
 	public int countAccountingDocumentByAccountingPeriod(String accountingPeriodId, Map<String,Object> options);
 	public Map<String, Integer> countAccountingDocumentByAccountingPeriodIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByAccountingPeriod(String accountingPeriodId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountingDocumentByAccountingPeriod(SmartList<AccountingDocument> resultList, String accountingPeriodId, Map<String,Object> options);


 
 	public SmartList<AccountingDocument> findAccountingDocumentByDocumentType(String accountingDocumentTypeId, Map<String,Object> options);
 	public int countAccountingDocumentByDocumentType(String accountingDocumentTypeId, Map<String,Object> options);
 	public Map<String, Integer> countAccountingDocumentByDocumentTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountingDocument> findAccountingDocumentByDocumentType(String accountingDocumentTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountingDocumentByDocumentType(SmartList<AccountingDocument> resultList, String accountingDocumentTypeId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:OriginalVoucher的belongsTo的OriginalVoucherList
	public SmartList<OriginalVoucher> loadOurOriginalVoucherList(RetailscmUserContext userContext, List<AccountingDocument> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:AccountingDocumentLine的belongsTo的AccountingDocumentLineList
	public SmartList<AccountingDocumentLine> loadOurAccountingDocumentLineList(RetailscmUserContext userContext, List<AccountingDocument> us, Map<String,Object> options) throws Exception;
	
}


