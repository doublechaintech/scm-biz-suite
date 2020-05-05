
package com.doublechaintech.retailscm.retailstorefranchising;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreFranchisingManager extends BaseManager{

		

	public RetailStoreFranchising createRetailStoreFranchising(RetailscmUserContext userContext, String comment) throws Exception;
	public RetailStoreFranchising updateRetailStoreFranchising(RetailscmUserContext userContext,String retailStoreFranchisingId, int retailStoreFranchisingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreFranchising loadRetailStoreFranchising(RetailscmUserContext userContext, String retailStoreFranchisingId, String [] tokensExpr) throws Exception;
	public RetailStoreFranchising internalSaveRetailStoreFranchising(RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising) throws Exception;
	public RetailStoreFranchising internalSaveRetailStoreFranchising(RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String retailStoreFranchisingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreFranchising newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreManager getRetailStoreManager(RetailscmUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreFranchising addRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreFranchising removeRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreFranchising updateRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


