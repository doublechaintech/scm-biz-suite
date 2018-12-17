
package com.doublechaintech.retailscm.retailstoredecoration;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreDecorationManager{

		

	public RetailStoreDecoration createRetailStoreDecoration(RetailscmUserContext userContext, String comment) throws Exception;	
	public RetailStoreDecoration updateRetailStoreDecoration(RetailscmUserContext userContext,String retailStoreDecorationId, int retailStoreDecorationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreDecoration loadRetailStoreDecoration(RetailscmUserContext userContext, String retailStoreDecorationId, String [] tokensExpr) throws Exception;
	public RetailStoreDecoration internalSaveRetailStoreDecoration(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration) throws Exception;
	public RetailStoreDecoration internalSaveRetailStoreDecoration(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String retailStoreDecorationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreDecoration newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RetailStoreManager getRetailStoreManager(RetailscmUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreDecoration addRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreDecoration removeRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreDecoration updateRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreDecoration associateRetailStoreListToNewCreation(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreDecoration associateRetailStoreListToCreation(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[],String creationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreDecoration associateRetailStoreListToNewInvestmentInvitation(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreDecoration associateRetailStoreListToInvestmentInvitation(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[],String investmentInvitationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreDecoration associateRetailStoreListToNewFranchising(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreDecoration associateRetailStoreListToFranchising(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[],String franchisingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreDecoration associateRetailStoreListToNewOpening(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreDecoration associateRetailStoreListToOpening(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[],String openingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreDecoration associateRetailStoreListToNewClosing(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreDecoration associateRetailStoreListToClosing(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[],String closingId, String [] tokensExpr) throws Exception ;

	*/



}


