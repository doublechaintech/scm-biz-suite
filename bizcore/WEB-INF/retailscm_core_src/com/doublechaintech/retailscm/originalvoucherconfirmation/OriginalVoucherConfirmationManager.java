
package com.doublechaintech.retailscm.originalvoucherconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface OriginalVoucherConfirmationManager{

		

	public OriginalVoucherConfirmation createOriginalVoucherConfirmation(RetailscmUserContext userContext, String who, String comments, Date makeDate) throws Exception;	
	public OriginalVoucherConfirmation updateOriginalVoucherConfirmation(RetailscmUserContext userContext,String originalVoucherConfirmationId, int originalVoucherConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OriginalVoucherConfirmation loadOriginalVoucherConfirmation(RetailscmUserContext userContext, String originalVoucherConfirmationId, String [] tokensExpr) throws Exception;
	public OriginalVoucherConfirmation internalSaveOriginalVoucherConfirmation(RetailscmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation) throws Exception;
	public OriginalVoucherConfirmation internalSaveOriginalVoucherConfirmation(RetailscmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String originalVoucherConfirmationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, OriginalVoucherConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  OriginalVoucherManager getOriginalVoucherManager(RetailscmUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId ,String [] tokensExpr)  throws Exception;
	
	public  OriginalVoucherConfirmation addOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId , String [] tokensExpr)  throws Exception;
	public  OriginalVoucherConfirmation removeOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherConfirmation updateOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  OriginalVoucherConfirmation associateOriginalVoucherListToNewCreation(RetailscmUserContext userContext, String originalVoucherConfirmationId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  OriginalVoucherConfirmation associateOriginalVoucherListToCreation(RetailscmUserContext userContext, String originalVoucherConfirmationId, String  originalVoucherIds[],String creationId, String [] tokensExpr) throws Exception ;
	public  OriginalVoucherConfirmation associateOriginalVoucherListToNewAuditing(RetailscmUserContext userContext, String originalVoucherConfirmationId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  OriginalVoucherConfirmation associateOriginalVoucherListToAuditing(RetailscmUserContext userContext, String originalVoucherConfirmationId, String  originalVoucherIds[],String auditingId, String [] tokensExpr) throws Exception ;

	*/



}


