
package com.doublechaintech.retailscm.retailstorefranchising;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreFranchisingManager{

		

	public RetailStoreFranchising createRetailStoreFranchising(RetailscmUserContext userContext, String comment) throws Exception;	
	public RetailStoreFranchising updateRetailStoreFranchising(RetailscmUserContext userContext,String retailStoreFranchisingId, int retailStoreFranchisingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreFranchising loadRetailStoreFranchising(RetailscmUserContext userContext, String retailStoreFranchisingId, String [] tokensExpr) throws Exception;
	public RetailStoreFranchising internalSaveRetailStoreFranchising(RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising) throws Exception;
	public RetailStoreFranchising internalSaveRetailStoreFranchising(RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String retailStoreFranchisingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreFranchising newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RetailStoreManager getRetailStoreManager(RetailscmUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreFranchising addRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreFranchising removeRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreFranchising updateRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreFranchising associateRetailStoreListToNewCreation(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreFranchising associateRetailStoreListToCreation(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[],String creationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreFranchising associateRetailStoreListToNewInvestmentInvitation(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreFranchising associateRetailStoreListToInvestmentInvitation(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[],String investmentInvitationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreFranchising associateRetailStoreListToNewDecoration(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreFranchising associateRetailStoreListToDecoration(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[],String decorationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreFranchising associateRetailStoreListToNewOpening(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreFranchising associateRetailStoreListToOpening(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[],String openingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreFranchising associateRetailStoreListToNewClosing(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreFranchising associateRetailStoreListToClosing(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[],String closingId, String [] tokensExpr) throws Exception ;

	*/



}


