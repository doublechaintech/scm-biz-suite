
package com.doublechaintech.retailscm.accountingdocumentposting;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface AccountingDocumentPostingManager{

		

	public AccountingDocumentPosting createAccountingDocumentPosting(RetailscmUserContext userContext, String who, String comments, Date makeDate) throws Exception;	
	public AccountingDocumentPosting updateAccountingDocumentPosting(RetailscmUserContext userContext,String accountingDocumentPostingId, int accountingDocumentPostingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocumentPosting loadAccountingDocumentPosting(RetailscmUserContext userContext, String accountingDocumentPostingId, String [] tokensExpr) throws Exception;
	public AccountingDocumentPosting internalSaveAccountingDocumentPosting(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting) throws Exception;
	public AccountingDocumentPosting internalSaveAccountingDocumentPosting(RetailscmUserContext userContext, AccountingDocumentPosting accountingDocumentPosting,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String accountingDocumentPostingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentPosting newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  AccountingDocumentManager getAccountingDocumentManager(RetailscmUserContext userContext, String accountingDocumentPostingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId ,String [] tokensExpr)  throws Exception;
	
	public  AccountingDocumentPosting addAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId , String [] tokensExpr)  throws Exception;
	public  AccountingDocumentPosting removeAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, String accountingDocumentId, int accountingDocumentVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocumentPosting updateAccountingDocument(RetailscmUserContext userContext, String accountingDocumentPostingId, String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  AccountingDocumentPosting associateAccountingDocumentListToNewCreation(RetailscmUserContext userContext, String accountingDocumentPostingId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentPosting associateAccountingDocumentListToCreation(RetailscmUserContext userContext, String accountingDocumentPostingId, String  accountingDocumentIds[],String creationId, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentPosting associateAccountingDocumentListToNewConfirmation(RetailscmUserContext userContext, String accountingDocumentPostingId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentPosting associateAccountingDocumentListToConfirmation(RetailscmUserContext userContext, String accountingDocumentPostingId, String  accountingDocumentIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentPosting associateAccountingDocumentListToNewAuditing(RetailscmUserContext userContext, String accountingDocumentPostingId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentPosting associateAccountingDocumentListToAuditing(RetailscmUserContext userContext, String accountingDocumentPostingId, String  accountingDocumentIds[],String auditingId, String [] tokensExpr) throws Exception ;

	*/



}


