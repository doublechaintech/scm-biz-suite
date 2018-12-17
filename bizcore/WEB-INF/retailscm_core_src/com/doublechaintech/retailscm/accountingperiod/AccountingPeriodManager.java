
package com.doublechaintech.retailscm.accountingperiod;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface AccountingPeriodManager{

		

	public AccountingPeriod createAccountingPeriod(RetailscmUserContext userContext, String name, Date startDate, Date endDate, String accountSetId) throws Exception;	
	public AccountingPeriod updateAccountingPeriod(RetailscmUserContext userContext,String accountingPeriodId, int accountingPeriodVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingPeriod loadAccountingPeriod(RetailscmUserContext userContext, String accountingPeriodId, String [] tokensExpr) throws Exception;
	public AccountingPeriod internalSaveAccountingPeriod(RetailscmUserContext userContext, AccountingPeriod accountingPeriod) throws Exception;
	public AccountingPeriod internalSaveAccountingPeriod(RetailscmUserContext userContext, AccountingPeriod accountingPeriod,Map<String,Object>option) throws Exception;
	
	public AccountingPeriod transferToAnotherAccountSet(RetailscmUserContext userContext, String accountingPeriodId, String anotherAccountSetId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String accountingPeriodId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingPeriod newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  AccountingDocumentManager getAccountingDocumentManager(RetailscmUserContext userContext, String accountingPeriodId, String name, Date accountingDocumentDate, String documentTypeId ,String [] tokensExpr)  throws Exception;
	
	public  AccountingPeriod addAccountingDocument(RetailscmUserContext userContext, String accountingPeriodId, String name, Date accountingDocumentDate, String documentTypeId , String [] tokensExpr)  throws Exception;
	public  AccountingPeriod removeAccountingDocument(RetailscmUserContext userContext, String accountingPeriodId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingPeriod updateAccountingDocument(RetailscmUserContext userContext, String accountingPeriodId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  AccountingPeriod associateAccountingDocumentListToNewCreation(RetailscmUserContext userContext, String accountingPeriodId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingPeriod associateAccountingDocumentListToCreation(RetailscmUserContext userContext, String accountingPeriodId, String  accountingDocumentIds[],String creationId, String [] tokensExpr) throws Exception ;
	public  AccountingPeriod associateAccountingDocumentListToNewConfirmation(RetailscmUserContext userContext, String accountingPeriodId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingPeriod associateAccountingDocumentListToConfirmation(RetailscmUserContext userContext, String accountingPeriodId, String  accountingDocumentIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  AccountingPeriod associateAccountingDocumentListToNewAuditing(RetailscmUserContext userContext, String accountingPeriodId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingPeriod associateAccountingDocumentListToAuditing(RetailscmUserContext userContext, String accountingPeriodId, String  accountingDocumentIds[],String auditingId, String [] tokensExpr) throws Exception ;
	public  AccountingPeriod associateAccountingDocumentListToNewPosting(RetailscmUserContext userContext, String accountingPeriodId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingPeriod associateAccountingDocumentListToPosting(RetailscmUserContext userContext, String accountingPeriodId, String  accountingDocumentIds[],String postingId, String [] tokensExpr) throws Exception ;

	*/



}


