
package com.doublechaintech.retailscm.accountingsubject;
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
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineDAO;
import com.doublechaintech.retailscm.accountset.AccountSetDAO;


public interface AccountingSubjectDAO extends BaseDAO{

	public SmartList<AccountingSubject> loadAll();
	public Stream<AccountingSubject> loadAllAsStream();
	public AccountingSubject load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountingSubject> accountingSubjectList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public AccountingSubject present(AccountingSubject accountingSubject,Map<String,Object> options) throws Exception;
	public AccountingSubject clone(String id, Map<String,Object> options) throws Exception;

	

	public AccountingSubject save(AccountingSubject accountingSubject,Map<String,Object> options);
	public SmartList<AccountingSubject> saveAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList,Map<String,Object> options);
	public SmartList<AccountingSubject> removeAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList,Map<String,Object> options);
	public SmartList<AccountingSubject> findAccountingSubjectWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountingSubjectWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountingSubjectWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountingSubjectId, int version) throws Exception;
	public AccountingSubject disconnectFromAll(String accountingSubjectId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AccountingDocumentLineDAO getAccountingDocumentLineDAO();
		
	
 	public SmartList<AccountingSubject> requestCandidateAccountingSubjectForAccountingDocumentLine(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountingSubject planToRemoveAccountingDocumentLineList(AccountingSubject accountingSubject, String accountingDocumentLineIds[], Map<String,Object> options)throws Exception;


	//disconnect AccountingSubject with belongs_to in AccountingDocumentLine
	public AccountingSubject planToRemoveAccountingDocumentLineListWithBelongsTo(AccountingSubject accountingSubject, String belongsToId, Map<String,Object> options)throws Exception;
	public int countAccountingDocumentLineListWithBelongsTo(String accountingSubjectId, String belongsToId, Map<String,Object> options)throws Exception;
	

	public SmartList<AccountingSubject> queryList(String sql, Object ... parmeters);
	public Stream<AccountingSubject> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateAccountingSubject executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<AccountingSubject> findAccountingSubjectByAccountSet(String accountSetId, Map<String,Object> options);
 	public int countAccountingSubjectByAccountSet(String accountSetId, Map<String,Object> options);
 	public Map<String, Integer> countAccountingSubjectByAccountSetIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountingSubject> findAccountingSubjectByAccountSet(String accountSetId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountingSubjectByAccountSet(SmartList<AccountingSubject> resultList, String accountSetId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:AccountingDocumentLine的accountingSubject的AccountingDocumentLineList
	public SmartList<AccountingDocumentLine> loadOurAccountingDocumentLineList(RetailscmUserContext userContext, List<AccountingSubject> us, Map<String,Object> options) throws Exception;
	
}


