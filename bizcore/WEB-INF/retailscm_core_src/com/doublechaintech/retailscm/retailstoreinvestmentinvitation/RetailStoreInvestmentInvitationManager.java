
package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreInvestmentInvitationManager{

		

	public RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String comment) throws Exception;	
	public RetailStoreInvestmentInvitation updateRetailStoreInvestmentInvitation(RetailscmUserContext userContext,String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String [] tokensExpr) throws Exception;
	public RetailStoreInvestmentInvitation internalSaveRetailStoreInvestmentInvitation(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation) throws Exception;
	public RetailStoreInvestmentInvitation internalSaveRetailStoreInvestmentInvitation(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreInvestmentInvitation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RetailStoreManager getRetailStoreManager(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreInvestmentInvitation addRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreInvestmentInvitation removeRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreInvestmentInvitation updateRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreInvestmentInvitation associateRetailStoreListToNewCreation(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreInvestmentInvitation associateRetailStoreListToCreation(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[],String creationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreInvestmentInvitation associateRetailStoreListToNewFranchising(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreInvestmentInvitation associateRetailStoreListToFranchising(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[],String franchisingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreInvestmentInvitation associateRetailStoreListToNewDecoration(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreInvestmentInvitation associateRetailStoreListToDecoration(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[],String decorationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreInvestmentInvitation associateRetailStoreListToNewOpening(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreInvestmentInvitation associateRetailStoreListToOpening(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[],String openingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreInvestmentInvitation associateRetailStoreListToNewClosing(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreInvestmentInvitation associateRetailStoreListToClosing(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[],String closingId, String [] tokensExpr) throws Exception ;

	*/



}


