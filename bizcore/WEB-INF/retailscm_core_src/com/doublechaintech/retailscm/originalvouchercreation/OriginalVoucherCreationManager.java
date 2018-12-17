
package com.doublechaintech.retailscm.originalvouchercreation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface OriginalVoucherCreationManager{

		

	public OriginalVoucherCreation createOriginalVoucherCreation(RetailscmUserContext userContext, String who, String comments, Date makeDate) throws Exception;	
	public OriginalVoucherCreation updateOriginalVoucherCreation(RetailscmUserContext userContext,String originalVoucherCreationId, int originalVoucherCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OriginalVoucherCreation loadOriginalVoucherCreation(RetailscmUserContext userContext, String originalVoucherCreationId, String [] tokensExpr) throws Exception;
	public OriginalVoucherCreation internalSaveOriginalVoucherCreation(RetailscmUserContext userContext, OriginalVoucherCreation originalVoucherCreation) throws Exception;
	public OriginalVoucherCreation internalSaveOriginalVoucherCreation(RetailscmUserContext userContext, OriginalVoucherCreation originalVoucherCreation,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String originalVoucherCreationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, OriginalVoucherCreation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  OriginalVoucherManager getOriginalVoucherManager(RetailscmUserContext userContext, String originalVoucherCreationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId ,String [] tokensExpr)  throws Exception;
	
	public  OriginalVoucherCreation addOriginalVoucher(RetailscmUserContext userContext, String originalVoucherCreationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId , String [] tokensExpr)  throws Exception;
	public  OriginalVoucherCreation removeOriginalVoucher(RetailscmUserContext userContext, String originalVoucherCreationId, String originalVoucherId, int originalVoucherVersion,String [] tokensExpr)  throws Exception;
	public  OriginalVoucherCreation updateOriginalVoucher(RetailscmUserContext userContext, String originalVoucherCreationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  OriginalVoucherCreation associateOriginalVoucherListToNewConfirmation(RetailscmUserContext userContext, String originalVoucherCreationId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  OriginalVoucherCreation associateOriginalVoucherListToConfirmation(RetailscmUserContext userContext, String originalVoucherCreationId, String  originalVoucherIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  OriginalVoucherCreation associateOriginalVoucherListToNewAuditing(RetailscmUserContext userContext, String originalVoucherCreationId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception ;
	public  OriginalVoucherCreation associateOriginalVoucherListToAuditing(RetailscmUserContext userContext, String originalVoucherCreationId, String  originalVoucherIds[],String auditingId, String [] tokensExpr) throws Exception ;

	*/



}


