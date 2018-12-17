
package com.doublechaintech.retailscm.retailstorecreation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreCreationManager{

		

	public RetailStoreCreation createRetailStoreCreation(RetailscmUserContext userContext, String comment) throws Exception;	
	public RetailStoreCreation updateRetailStoreCreation(RetailscmUserContext userContext,String retailStoreCreationId, int retailStoreCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreCreation loadRetailStoreCreation(RetailscmUserContext userContext, String retailStoreCreationId, String [] tokensExpr) throws Exception;
	public RetailStoreCreation internalSaveRetailStoreCreation(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation) throws Exception;
	public RetailStoreCreation internalSaveRetailStoreCreation(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String retailStoreCreationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreCreation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RetailStoreManager getRetailStoreManager(RetailscmUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCreation addRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCreation removeRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCreation updateRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreCreation associateRetailStoreListToNewInvestmentInvitation(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreCreation associateRetailStoreListToInvestmentInvitation(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[],String investmentInvitationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCreation associateRetailStoreListToNewFranchising(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreCreation associateRetailStoreListToFranchising(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[],String franchisingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCreation associateRetailStoreListToNewDecoration(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreCreation associateRetailStoreListToDecoration(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[],String decorationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCreation associateRetailStoreListToNewOpening(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreCreation associateRetailStoreListToOpening(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[],String openingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCreation associateRetailStoreListToNewClosing(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreCreation associateRetailStoreListToClosing(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[],String closingId, String [] tokensExpr) throws Exception ;

	*/



}


