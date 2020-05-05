
package com.doublechaintech.retailscm.retailstorecreation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreCreationManager extends BaseManager{

		

	public RetailStoreCreation createRetailStoreCreation(RetailscmUserContext userContext, String comment) throws Exception;
	public RetailStoreCreation updateRetailStoreCreation(RetailscmUserContext userContext,String retailStoreCreationId, int retailStoreCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreCreation loadRetailStoreCreation(RetailscmUserContext userContext, String retailStoreCreationId, String [] tokensExpr) throws Exception;
	public RetailStoreCreation internalSaveRetailStoreCreation(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation) throws Exception;
	public RetailStoreCreation internalSaveRetailStoreCreation(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String retailStoreCreationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreCreation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreManager getRetailStoreManager(RetailscmUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreCreation addRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCreation removeRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCreation updateRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


