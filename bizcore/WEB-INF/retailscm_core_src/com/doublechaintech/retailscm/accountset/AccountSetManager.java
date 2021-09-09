
package com.doublechaintech.retailscm.accountset;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;




public interface AccountSetManager extends BaseManager{

		

  List<AccountSet> searchAccountSetList(RetailscmUserContext ctx, AccountSetRequest pRequest);
  AccountSet searchAccountSet(RetailscmUserContext ctx, AccountSetRequest pRequest);
	public AccountSet createAccountSet(RetailscmUserContext userContext, String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber,String countryCenterId,String retailStoreId,String goodsSupplierId) throws Exception;
	public AccountSet updateAccountSet(RetailscmUserContext userContext,String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountSet loadAccountSet(RetailscmUserContext userContext, String accountSetId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public AccountSet internalSaveAccountSet(RetailscmUserContext userContext, AccountSet accountSet) throws Exception;
	public AccountSet internalSaveAccountSet(RetailscmUserContext userContext, AccountSet accountSet,Map<String,Object>option) throws Exception;

	public AccountSet transferToAnotherCountryCenter(RetailscmUserContext userContext, String accountSetId, String anotherCountryCenterId)  throws Exception;
 	public AccountSet transferToAnotherRetailStore(RetailscmUserContext userContext, String accountSetId, String anotherRetailStoreId)  throws Exception;
 	public AccountSet transferToAnotherGoodsSupplier(RetailscmUserContext userContext, String accountSetId, String anotherGoodsSupplierId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String accountSetId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountSet newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, AccountSet updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  AccountingSubjectManager getAccountingSubjectManager(RetailscmUserContext userContext, String accountSetId, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName ,String [] tokensExpr)  throws Exception;

	public  AccountSet addAccountingSubject(RetailscmUserContext userContext, String accountSetId, String accountingSubjectCode, String accountingSubjectName, int accountingSubjectClassCode, String accountingSubjectClassName , String [] tokensExpr)  throws Exception;
	public  AccountSet removeAccountingSubject(RetailscmUserContext userContext, String accountSetId, String accountingSubjectId, int accountingSubjectVersion,String [] tokensExpr)  throws Exception;
	public  AccountSet updateAccountingSubject(RetailscmUserContext userContext, String accountSetId, String accountingSubjectId, int accountingSubjectVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AccountingPeriodManager getAccountingPeriodManager(RetailscmUserContext userContext, String accountSetId, String name, Date startDate, Date endDate ,String [] tokensExpr)  throws Exception;

	public  AccountSet addAccountingPeriod(RetailscmUserContext userContext, String accountSetId, String name, Date startDate, Date endDate , String [] tokensExpr)  throws Exception;
	public  AccountSet removeAccountingPeriod(RetailscmUserContext userContext, String accountSetId, String accountingPeriodId, int accountingPeriodVersion,String [] tokensExpr)  throws Exception;
	public  AccountSet updateAccountingPeriod(RetailscmUserContext userContext, String accountSetId, String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AccountingDocumentTypeManager getAccountingDocumentTypeManager(RetailscmUserContext userContext, String accountSetId, String name, String description ,String [] tokensExpr)  throws Exception;

	public  AccountSet addAccountingDocumentType(RetailscmUserContext userContext, String accountSetId, String name, String description , String [] tokensExpr)  throws Exception;
	public  AccountSet removeAccountingDocumentType(RetailscmUserContext userContext, String accountSetId, String accountingDocumentTypeId, int accountingDocumentTypeVersion,String [] tokensExpr)  throws Exception;
	public  AccountSet updateAccountingDocumentType(RetailscmUserContext userContext, String accountSetId, String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCountryCenter(RetailscmUserContext userContext,String countryCenterId) throws Exception;
	public Object listPageByCountryCenter(RetailscmUserContext userContext,String countryCenterId, int start, int count) throws Exception;
  
	public Object listByRetailStore(RetailscmUserContext userContext,String retailStoreId) throws Exception;
	public Object listPageByRetailStore(RetailscmUserContext userContext,String retailStoreId, int start, int count) throws Exception;
  
	public Object listByGoodsSupplier(RetailscmUserContext userContext,String goodsSupplierId) throws Exception;
	public Object listPageByGoodsSupplier(RetailscmUserContext userContext,String goodsSupplierId, int start, int count) throws Exception;
  




}


