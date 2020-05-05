
package com.doublechaintech.retailscm.userwhitelist;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface UserWhiteListManager extends BaseManager{

		

	public UserWhiteList createUserWhiteList(RetailscmUserContext userContext, String userIdentity,String userSpecialFunctions,String domainId) throws Exception;
	public UserWhiteList updateUserWhiteList(RetailscmUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserWhiteList loadUserWhiteList(RetailscmUserContext userContext, String userWhiteListId, String [] tokensExpr) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(RetailscmUserContext userContext, UserWhiteList userWhiteList) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(RetailscmUserContext userContext, UserWhiteList userWhiteList,Map<String,Object>option) throws Exception;

	public UserWhiteList transferToAnotherDomain(RetailscmUserContext userContext, String userWhiteListId, String anotherDomainId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String userWhiteListId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, UserWhiteList newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByDomain(RetailscmUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(RetailscmUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


