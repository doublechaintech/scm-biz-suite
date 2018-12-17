
package com.doublechaintech.retailscm.retailstoreopening;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOpeningManager{

		

	public RetailStoreOpening createRetailStoreOpening(RetailscmUserContext userContext, String comment) throws Exception;	
	public RetailStoreOpening updateRetailStoreOpening(RetailscmUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOpening loadRetailStoreOpening(RetailscmUserContext userContext, String retailStoreOpeningId, String [] tokensExpr) throws Exception;
	public RetailStoreOpening internalSaveRetailStoreOpening(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening) throws Exception;
	public RetailStoreOpening internalSaveRetailStoreOpening(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String retailStoreOpeningId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOpening newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RetailStoreManager getRetailStoreManager(RetailscmUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreOpening addRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreOpening removeRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOpening updateRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreOpening associateRetailStoreListToNewCreation(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreOpening associateRetailStoreListToCreation(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[],String creationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOpening associateRetailStoreListToNewInvestmentInvitation(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreOpening associateRetailStoreListToInvestmentInvitation(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[],String investmentInvitationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOpening associateRetailStoreListToNewFranchising(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreOpening associateRetailStoreListToFranchising(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[],String franchisingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOpening associateRetailStoreListToNewDecoration(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreOpening associateRetailStoreListToDecoration(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[],String decorationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOpening associateRetailStoreListToNewClosing(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreOpening associateRetailStoreListToClosing(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[],String closingId, String [] tokensExpr) throws Exception ;

	*/



}


