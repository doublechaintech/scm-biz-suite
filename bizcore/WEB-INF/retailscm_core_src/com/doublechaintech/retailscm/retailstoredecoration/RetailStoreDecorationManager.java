
package com.doublechaintech.retailscm.retailstoredecoration;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreDecorationManager extends BaseManager{

		

	public RetailStoreDecoration createRetailStoreDecoration(RetailscmUserContext userContext, String comment) throws Exception;
	public RetailStoreDecoration updateRetailStoreDecoration(RetailscmUserContext userContext,String retailStoreDecorationId, int retailStoreDecorationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreDecoration loadRetailStoreDecoration(RetailscmUserContext userContext, String retailStoreDecorationId, String [] tokensExpr) throws Exception;
	public RetailStoreDecoration internalSaveRetailStoreDecoration(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration) throws Exception;
	public RetailStoreDecoration internalSaveRetailStoreDecoration(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String retailStoreDecorationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreDecoration newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreManager getRetailStoreManager(RetailscmUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreDecoration addRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreDecoration removeRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreDecoration updateRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


