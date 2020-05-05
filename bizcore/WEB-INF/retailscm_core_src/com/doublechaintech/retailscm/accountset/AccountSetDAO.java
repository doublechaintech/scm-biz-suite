
package com.doublechaintech.retailscm.accountset;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;

import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodDAO;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierDAO;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubjectDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface AccountSetDAO extends BaseDAO{

	public SmartList<AccountSet> loadAll();
	public AccountSet load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AccountSet> accountSetList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AccountSet present(AccountSet accountSet,Map<String,Object> options) throws Exception;
	public AccountSet clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountSet save(AccountSet accountSet,Map<String,Object> options);
	public SmartList<AccountSet> saveAccountSetList(SmartList<AccountSet> accountSetList,Map<String,Object> options);
	public SmartList<AccountSet> removeAccountSetList(SmartList<AccountSet> accountSetList,Map<String,Object> options);
	public SmartList<AccountSet> findAccountSetWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAccountSetWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAccountSetWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String accountSetId, int version) throws Exception;
	public AccountSet disconnectFromAll(String accountSetId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AccountingSubjectDAO getAccountingSubjectDAO();
		
	public AccountingPeriodDAO getAccountingPeriodDAO();
		
	public AccountingDocumentTypeDAO getAccountingDocumentTypeDAO();
		
	
 	public SmartList<AccountSet> requestCandidateAccountSetForAccountingSubject(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<AccountSet> requestCandidateAccountSetForAccountingPeriod(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<AccountSet> requestCandidateAccountSetForAccountingDocumentType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public AccountSet planToRemoveAccountingSubjectList(AccountSet accountSet, String accountingSubjectIds[], Map<String,Object> options)throws Exception;


	public AccountSet planToRemoveAccountingPeriodList(AccountSet accountSet, String accountingPeriodIds[], Map<String,Object> options)throws Exception;


	public AccountSet planToRemoveAccountingDocumentTypeList(AccountSet accountSet, String accountingDocumentTypeIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<AccountSet> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateAccountSet executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<AccountSet> findAccountSetByCountryCenter(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countAccountSetByCountryCenter(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countAccountSetByCountryCenterIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountSet> findAccountSetByCountryCenter(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountSetByCountryCenter(SmartList<AccountSet> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
  
 	public SmartList<AccountSet> findAccountSetByRetailStore(String retailStoreId, Map<String,Object> options);
 	public int countAccountSetByRetailStore(String retailStoreId, Map<String,Object> options);
 	public Map<String, Integer> countAccountSetByRetailStoreIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountSet> findAccountSetByRetailStore(String retailStoreId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountSetByRetailStore(SmartList<AccountSet> resultList, String retailStoreId, Map<String,Object> options);

 
  
 	public SmartList<AccountSet> findAccountSetByGoodsSupplier(String goodsSupplierId, Map<String,Object> options);
 	public int countAccountSetByGoodsSupplier(String goodsSupplierId, Map<String,Object> options);
 	public Map<String, Integer> countAccountSetByGoodsSupplierIds(String[] ids, Map<String,Object> options);
 	public SmartList<AccountSet> findAccountSetByGoodsSupplier(String goodsSupplierId, int start, int count, Map<String,Object> options);
 	public void analyzeAccountSetByGoodsSupplier(SmartList<AccountSet> resultList, String goodsSupplierId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:AccountingSubject的accountSet的AccountingSubjectList
	public SmartList<AccountingSubject> loadOurAccountingSubjectList(RetailscmUserContext userContext, List<AccountSet> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:AccountingPeriod的accountSet的AccountingPeriodList
	public SmartList<AccountingPeriod> loadOurAccountingPeriodList(RetailscmUserContext userContext, List<AccountSet> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:AccountingDocumentType的accountingPeriod的AccountingDocumentTypeList
	public SmartList<AccountingDocumentType> loadOurAccountingDocumentTypeList(RetailscmUserContext userContext, List<AccountSet> us, Map<String,Object> options) throws Exception;
	
}


