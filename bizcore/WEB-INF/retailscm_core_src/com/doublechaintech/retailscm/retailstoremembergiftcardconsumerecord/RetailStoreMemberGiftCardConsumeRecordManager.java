
package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreMemberGiftCardConsumeRecordManager{

		

	public RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, Date occureTime, String ownerId, String bizOrderId, String number, BigDecimal amount) throws Exception;	
	public RetailStoreMemberGiftCardConsumeRecord updateRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext,String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreMemberGiftCardConsumeRecord loadRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String [] tokensExpr) throws Exception;
	public RetailStoreMemberGiftCardConsumeRecord internalSaveRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) throws Exception;
	public RetailStoreMemberGiftCardConsumeRecord internalSaveRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,Map<String,Object>option) throws Exception;
	
	public RetailStoreMemberGiftCardConsumeRecord transferToAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherOwnerId)  throws Exception;
 	public RetailStoreMemberGiftCardConsumeRecord transferToAnotherBizOrder(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


