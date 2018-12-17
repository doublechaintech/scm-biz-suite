
package com.doublechaintech.retailscm.accountingdocumentcreation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface AccountingDocumentCreationManager{

		

	public AccountingDocumentCreation createAccountingDocumentCreation(RetailscmUserContext userContext, String who, String comments, Date makeDate) throws Exception;	
	public AccountingDocumentCreation updateAccountingDocumentCreation(RetailscmUserContext userContext,String accountingDocumentCreationId, int accountingDocumentCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocumentCreation loadAccountingDocumentCreation(RetailscmUserContext userContext, String accountingDocumentCreationId, String [] tokensExpr) throws Exception;
	public AccountingDocumentCreation internalSaveAccountingDocumentCreation(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation) throws Exception;
	public AccountingDocumentCreation internalSaveAccountingDocumentCreation(RetailscmUserContext userContext, AccountingDocumentCreation accountingDocumentCreation,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String accountingDocumentCreationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentCreation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  AccountingDocumentManager getAccountingDocumentManager(RetailscmUserContext userContext, String accountingDocumentCreationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId ,String [] tokensExpr)  throws Exception;
	
	public  AccountingDocumentCreation addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId , String [] tokensExpr)  throws Exception;
	public  AccountingDocumentCreation removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentCreation updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentCreationId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  AccountingDocumentCreation associateAccountingDocumentListToNewConfirmation(RetailscmUserContext userContext, String accountingDocumentCreationId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentCreation associateAccountingDocumentListToConfirmation(RetailscmUserContext userContext, String accountingDocumentCreationId, String  accountingDocumentIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentCreation associateAccountingDocumentListToNewAuditing(RetailscmUserContext userContext, String accountingDocumentCreationId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentCreation associateAccountingDocumentListToAuditing(RetailscmUserContext userContext, String accountingDocumentCreationId, String  accountingDocumentIds[],String auditingId, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentCreation associateAccountingDocumentListToNewPosting(RetailscmUserContext userContext, String accountingDocumentCreationId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentCreation associateAccountingDocumentListToPosting(RetailscmUserContext userContext, String accountingDocumentCreationId, String  accountingDocumentIds[],String postingId, String [] tokensExpr) throws Exception ;

	*/



}


