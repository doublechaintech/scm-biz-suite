
package com.doublechaintech.retailscm.accountingdocument;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface AccountingDocumentManager{

		

	public AccountingDocument createAccountingDocument(RetailscmUserContext userContext, String name, Date accountingDocumentDate, String accountingPeriodId, String documentTypeId) throws Exception;	
	public AccountingDocument updateAccountingDocument(RetailscmUserContext userContext,String accountingDocumentId, int accountingDocumentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocument loadAccountingDocument(RetailscmUserContext userContext, String accountingDocumentId, String [] tokensExpr) throws Exception;
	public AccountingDocument internalSaveAccountingDocument(RetailscmUserContext userContext, AccountingDocument accountingDocument) throws Exception;
	public AccountingDocument internalSaveAccountingDocument(RetailscmUserContext userContext, AccountingDocument accountingDocument,Map<String,Object>option) throws Exception;
	
	public AccountingDocument transferToAnotherAccountingPeriod(RetailscmUserContext userContext, String accountingDocumentId, String anotherAccountingPeriodId)  throws Exception;
 	public AccountingDocument transferToAnotherDocumentType(RetailscmUserContext userContext, String accountingDocumentId, String anotherDocumentTypeId)  throws Exception;
 	public AccountingDocument create(RetailscmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
)  throws Exception;
	public AccountingDocument confirm(RetailscmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
)  throws Exception;
	public AccountingDocument audit(RetailscmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
)  throws Exception;
	public AccountingDocument post(RetailscmUserContext userContext, String accountingDocumentId, String who, String comments, Date makeDate
)  throws Exception;


	public void delete(RetailscmUserContext userContext, String accountingDocumentId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocument newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  OriginalVoucherManager getOriginalVoucherManager(RetailscmUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage ,String [] tokensExpr)  throws Exception;
	
	public  AccountingDocument addOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage , String [] tokensExpr)  throws Exception;
	public  AccountingDocument removeOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocument updateOriginalVoucher(RetailscmUserContext userContext, String accountingDocumentId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  AccountingDocument associateOriginalVoucherListToNewCreation(RetailscmUserContext userContext, String accountingDocumentId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocument associateOriginalVoucherListToCreation(RetailscmUserContext userContext, String accountingDocumentId, String  originalVoucherIds[],String creationId, String [] tokensExpr) throws Exception ;
	public  AccountingDocument associateOriginalVoucherListToNewConfirmation(RetailscmUserContext userContext, String accountingDocumentId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocument associateOriginalVoucherListToConfirmation(RetailscmUserContext userContext, String accountingDocumentId, String  originalVoucherIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  AccountingDocument associateOriginalVoucherListToNewAuditing(RetailscmUserContext userContext, String accountingDocumentId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  AccountingDocument associateOriginalVoucherListToAuditing(RetailscmUserContext userContext, String accountingDocumentId, String  originalVoucherIds[],String auditingId, String [] tokensExpr) throws Exception ;

	*/

	//public  AccountingDocumentLineManager getAccountingDocumentLineManager(RetailscmUserContext userContext, String accountingDocumentId, String name, String code, String direct, BigDecimal amount, String accountingSubjectId ,String [] tokensExpr)  throws Exception;
	
	public  AccountingDocument addAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, String name, String code, String direct, BigDecimal amount, String accountingSubjectId , String [] tokensExpr)  throws Exception;
	public  AccountingDocument removeAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion,String [] tokensExpr)  throws Exception;
	public  AccountingDocument updateAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentId, String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


