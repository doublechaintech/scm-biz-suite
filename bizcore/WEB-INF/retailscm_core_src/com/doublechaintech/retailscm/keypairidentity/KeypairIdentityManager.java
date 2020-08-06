
package com.doublechaintech.retailscm.keypairidentity;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface KeypairIdentityManager extends BaseManager{

		

	public KeypairIdentity createKeypairIdentity(RetailscmUserContext userContext, String publicKey,String keyTypeId,String secUserId) throws Exception;
	public KeypairIdentity updateKeypairIdentity(RetailscmUserContext userContext,String keypairIdentityId, int keypairIdentityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public KeypairIdentity loadKeypairIdentity(RetailscmUserContext userContext, String keypairIdentityId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public KeypairIdentity internalSaveKeypairIdentity(RetailscmUserContext userContext, KeypairIdentity keypairIdentity) throws Exception;
	public KeypairIdentity internalSaveKeypairIdentity(RetailscmUserContext userContext, KeypairIdentity keypairIdentity,Map<String,Object>option) throws Exception;

	public KeypairIdentity transferToAnotherKeyType(RetailscmUserContext userContext, String keypairIdentityId, String anotherKeyTypeId)  throws Exception;
 	public KeypairIdentity transferToAnotherSecUser(RetailscmUserContext userContext, String keypairIdentityId, String anotherSecUserId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String keypairIdentityId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, KeypairIdentity newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByKeyType(RetailscmUserContext userContext,String keyTypeId) throws Exception;
	public Object listPageByKeyType(RetailscmUserContext userContext,String keyTypeId, int start, int count) throws Exception;
  
	public Object listBySecUser(RetailscmUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(RetailscmUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


