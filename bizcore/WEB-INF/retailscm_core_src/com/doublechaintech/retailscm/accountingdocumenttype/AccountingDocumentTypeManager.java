
package com.doublechaintech.retailscm.accountingdocumenttype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface AccountingDocumentTypeManager{

		

	public AccountingDocumentType createAccountingDocumentType(RetailscmUserContext userContext, String name, String description, String accountingPeriodId) throws Exception;	
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
	public  AccountingDocumentType associateAccountingDocumentListToNewCreation(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentType associateAccountingDocumentListToCreation(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[],String creationId, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentType associateAccountingDocumentListToNewConfirmation(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentType associateAccountingDocumentListToConfirmation(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentType associateAccountingDocumentListToNewAuditing(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentType associateAccountingDocumentListToAuditing(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[],String auditingId, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentType associateAccountingDocumentListToNewPosting(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocumentType associateAccountingDocumentListToPosting(RetailscmUserContext userContext, String accountingDocumentTypeId, String  accountingDocumentIds[],String postingId, String [] tokensExpr) throws Exception ;

	*/



}


