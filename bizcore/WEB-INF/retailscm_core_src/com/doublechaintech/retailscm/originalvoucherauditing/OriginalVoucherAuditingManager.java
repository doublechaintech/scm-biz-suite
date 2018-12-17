
package com.doublechaintech.retailscm.originalvoucherauditing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface OriginalVoucherAuditingManager{

		

	public OriginalVoucherAuditing createOriginalVoucherAuditing(RetailscmUserContext userContext, String who, String comments, Date makeDate) throws Exception;	
	public OriginalVoucherAuditing updateOriginalVoucherAuditing(RetailscmUserContext userContext,String originalVoucherAuditingId, int originalVoucherAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OriginalVoucherAuditing loadOriginalVoucherAuditing(RetailscmUserContext userContext, String originalVoucherAuditingId, String [] tokensExpr) throws Exception;
	public OriginalVoucherAuditing internalSaveOriginalVoucherAuditing(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing) throws Exception;
	public OriginalVoucherAuditing internalSaveOriginalVoucherAuditing(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String originalVoucherAuditingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, OriginalVoucherAuditing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  OriginalVoucherManager getOriginalVoucherManager(RetailscmUserContext userContext, String originalVoucherAuditingId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId ,String [] tokensExpr)  throws Exception;
	
	public  OriginalVoucherAuditing addOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId , String [] tokensExpr)  throws Exception;
	public  OriginalVoucherAuditing removeOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherAuditing updateOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  OriginalVoucherAuditing associateOriginalVoucherListToNewCreation(RetailscmUserContext userContext, String originalVoucherAuditingId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  OriginalVoucherAuditing associateOriginalVoucherListToCreation(RetailscmUserContext userContext, String originalVoucherAuditingId, String  originalVoucherIds[],String creationId, String [] tokensExpr) throws Exception ;
	public  OriginalVoucherAuditing associateOriginalVoucherListToNewConfirmation(RetailscmUserContext userContext, String originalVoucherAuditingId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  OriginalVoucherAuditing associateOriginalVoucherListToConfirmation(RetailscmUserContext userContext, String originalVoucherAuditingId, String  originalVoucherIds[],String confirmationId, String [] tokensExpr) throws Exception ;

	*/



}


