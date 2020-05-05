
package com.doublechaintech.retailscm.accountingdocumenttype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface AccountingDocumentTypeManager extends BaseManager{

		

	public AccountingDocumentType createAccountingDocumentType(RetailscmUserContext userContext, String name,String description,String accountingPeriodId) throws Exception;
	public AccountingDocumentType updateAccountingDocumentType(RetailscmUserContext userContext,String accountingDocumentTypeId, int accountingDocumentTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocumentType loadAccountingDocumentType(RetailscmUserContext userContext, String accountingDocumentTypeId, String [] tokensExpr) throws Exception;
	public AccountingDocumentType internalSaveAccountingDocumentType(RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType) throws Exception;
	public AccountingDocumentType internalSaveAccountingDocumentType(RetailscmUserContext userContext, AccountingDocumentType accountingDocumentType,Map<String,Object>option) throws Exception;

	public AccountingDocumentType transferToAnotherAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentTypeId, String anotherAccountingPeriodId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String accountingDocumentTypeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  AccountingDocumentManager getAccountingDocumentManager(RetailscmUserContext userContext, String accountingDocumentTypeId, String name, Date accountingDocumentDate, String accountingPeriodId ,String [] tokensExpr)  throws Exception;

	public  AccountingDocumentType addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId, String name, Date accountingDocumentDate, String accountingPeriodId , String [] tokensExpr)  throws Exception;
	public  AccountingDocumentType removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentType updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentTypeId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByAccountingPeriod(RetailscmUserContext userContext,String accountingPeriodId) throws Exception;
	public Object listPageByAccountingPeriod(RetailscmUserContext userContext,String accountingPeriodId, int start, int count) throws Exception;
  

}


