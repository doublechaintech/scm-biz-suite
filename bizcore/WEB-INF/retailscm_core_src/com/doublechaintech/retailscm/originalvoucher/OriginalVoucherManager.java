
package com.doublechaintech.retailscm.originalvoucher;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface OriginalVoucherManager extends BaseManager{

		

	public OriginalVoucher createOriginalVoucher(RetailscmUserContext userContext, String title,String madeBy,String receivedBy,String voucherType,String voucherImage,String belongsToId) throws Exception;
	public OriginalVoucher updateOriginalVoucher(RetailscmUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OriginalVoucher loadOriginalVoucher(RetailscmUserContext userContext, String originalVoucherId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public OriginalVoucher internalSaveOriginalVoucher(RetailscmUserContext userContext, OriginalVoucher originalVoucher) throws Exception;
	public OriginalVoucher internalSaveOriginalVoucher(RetailscmUserContext userContext, OriginalVoucher originalVoucher,Map<String,Object>option) throws Exception;

	public OriginalVoucher transferToAnotherBelongsTo(RetailscmUserContext userContext, String originalVoucherId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String originalVoucherId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, OriginalVoucher newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBelongsTo(RetailscmUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(RetailscmUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


