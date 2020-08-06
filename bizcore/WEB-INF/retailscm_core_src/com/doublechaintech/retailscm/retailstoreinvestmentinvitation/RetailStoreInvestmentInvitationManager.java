
package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreInvestmentInvitationManager extends BaseManager{

		

	public RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String comment) throws Exception;
	public RetailStoreInvestmentInvitation updateRetailStoreInvestmentInvitation(RetailscmUserContext userContext,String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public RetailStoreInvestmentInvitation internalSaveRetailStoreInvestmentInvitation(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation) throws Exception;
	public RetailStoreInvestmentInvitation internalSaveRetailStoreInvestmentInvitation(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreInvestmentInvitation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreManager getRetailStoreManager(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreInvestmentInvitation addRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreInvestmentInvitation removeRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreInvestmentInvitation updateRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


