
package com.doublechaintech.retailscm.retailstoreopening;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOpeningManager extends BaseManager{

		

	public RetailStoreOpening createRetailStoreOpening(RetailscmUserContext userContext, String comment) throws Exception;
	public RetailStoreOpening updateRetailStoreOpening(RetailscmUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOpening loadRetailStoreOpening(RetailscmUserContext userContext, String retailStoreOpeningId, String [] tokensExpr) throws Exception;
	public RetailStoreOpening internalSaveRetailStoreOpening(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening) throws Exception;
	public RetailStoreOpening internalSaveRetailStoreOpening(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String retailStoreOpeningId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOpening newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  RetailStoreManager getRetailStoreManager(RetailscmUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;

	public  RetailStoreOpening addRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreOpening removeRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOpening updateRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


