
package com.doublechaintech.retailscm.publickeytype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;




public interface PublicKeyTypeManager extends BaseManager{

		

  List<PublicKeyType> searchPublicKeyTypeList(RetailscmUserContext ctx, PublicKeyTypeRequest pRequest);
  PublicKeyType searchPublicKeyType(RetailscmUserContext ctx, PublicKeyTypeRequest pRequest);
	public PublicKeyType createPublicKeyType(RetailscmUserContext userContext, String keyAlg,String signAlg,String domainId) throws Exception;
	public PublicKeyType updatePublicKeyType(RetailscmUserContext userContext,String publicKeyTypeId, int publicKeyTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PublicKeyType loadPublicKeyType(RetailscmUserContext userContext, String publicKeyTypeId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public PublicKeyType internalSavePublicKeyType(RetailscmUserContext userContext, PublicKeyType publicKeyType) throws Exception;
	public PublicKeyType internalSavePublicKeyType(RetailscmUserContext userContext, PublicKeyType publicKeyType,Map<String,Object>option) throws Exception;

	public PublicKeyType transferToAnotherDomain(RetailscmUserContext userContext, String publicKeyTypeId, String anotherDomainId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String publicKeyTypeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, PublicKeyType newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, PublicKeyType updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  KeyPairIdentityManager getKeyPairIdentityManager(RetailscmUserContext userContext, String publicKeyTypeId, String publicKey, String secUserId ,String [] tokensExpr)  throws Exception;

	public  PublicKeyType addKeyPairIdentity(RetailscmUserContext userContext, String publicKeyTypeId, String publicKey, String secUserId , String [] tokensExpr)  throws Exception;
	public  PublicKeyType removeKeyPairIdentity(RetailscmUserContext userContext, String publicKeyTypeId, String keyPairIdentityId, int keyPairIdentityVersion,String [] tokensExpr)  throws Exception;
	public  PublicKeyType updateKeyPairIdentity(RetailscmUserContext userContext, String publicKeyTypeId, String keyPairIdentityId, int keyPairIdentityVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDomain(RetailscmUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(RetailscmUserContext userContext,String domainId, int start, int count) throws Exception;
  




}


