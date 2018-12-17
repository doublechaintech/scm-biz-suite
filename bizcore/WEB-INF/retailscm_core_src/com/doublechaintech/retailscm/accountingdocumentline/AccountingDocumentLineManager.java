
package com.doublechaintech.retailscm.accountingdocumentline;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface AccountingDocumentLineManager{

		

	public AccountingDocumentLine createAccountingDocumentLine(RetailscmUserContext userContext, String name, String code, String direct, BigDecimal amount, String belongsToId, String accountingSubjectId) throws Exception;	
	public AccountingDocumentLine updateAccountingDocumentLine(RetailscmUserContext userContext,String accountingDocumentLineId, int accountingDocumentLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AccountingDocumentLine loadAccountingDocumentLine(RetailscmUserContext userContext, String accountingDocumentLineId, String [] tokensExpr) throws Exception;
	public AccountingDocumentLine internalSaveAccountingDocumentLine(RetailscmUserContext userContext, AccountingDocumentLine accountingDocumentLine) throws Exception;
	public AccountingDocumentLine internalSaveAccountingDocumentLine(RetailscmUserContext userContext, AccountingDocumentLine accountingDocumentLine,Map<String,Object>option) throws Exception;
	
	public AccountingDocumentLine transferToAnotherBelongsTo(RetailscmUserContext userContext, String accountingDocumentLineId, String anotherBelongsToId)  throws Exception;
 	public AccountingDocumentLine transferToAnotherAccountingSubject(RetailscmUserContext userContext, String accountingDocumentLineId, String anotherAccountingSubjectId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String accountingDocumentLineId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingDocumentLine newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


