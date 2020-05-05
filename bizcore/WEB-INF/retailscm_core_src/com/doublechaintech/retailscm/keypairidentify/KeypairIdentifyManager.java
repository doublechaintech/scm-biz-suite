
package com.doublechaintech.retailscm.keypairidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface KeypairIdentifyManager extends BaseManager{

		

	public KeypairIdentify createKeypairIdentify(RetailscmUserContext userContext, String publicKey,String keyTypeId,String secUserId) throws Exception;
	public KeypairIdentify updateKeypairIdentify(RetailscmUserContext userContext,String keypairIdentifyId, int keypairIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public KeypairIdentify loadKeypairIdentify(RetailscmUserContext userContext, String keypairIdentifyId, String [] tokensExpr) throws Exception;
	public KeypairIdentify internalSaveKeypairIdentify(RetailscmUserContext userContext, KeypairIdentify keypairIdentify) throws Exception;
	public KeypairIdentify internalSaveKeypairIdentify(RetailscmUserContext userContext, KeypairIdentify keypairIdentify,Map<String,Object>option) throws Exception;

	public KeypairIdentify transferToAnotherKeyType(RetailscmUserContext userContext, String keypairIdentifyId, String anotherKeyTypeId)  throws Exception;
 	public KeypairIdentify transferToAnotherSecUser(RetailscmUserContext userContext, String keypairIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String keypairIdentifyId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, KeypairIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByKeyType(RetailscmUserContext userContext,String keyTypeId) throws Exception;
	public Object listPageByKeyType(RetailscmUserContext userContext,String keyTypeId, int start, int count) throws Exception;
  
	public Object listBySecUser(RetailscmUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(RetailscmUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


