
package com.doublechaintech.retailscm.listaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface ListAccessManager extends BaseManager{

		

	public ListAccess createListAccess(RetailscmUserContext userContext, String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission,String appId) throws Exception;
	public ListAccess updateListAccess(RetailscmUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ListAccess loadListAccess(RetailscmUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception;
	public ListAccess internalSaveListAccess(RetailscmUserContext userContext, ListAccess listAccess) throws Exception;
	public ListAccess internalSaveListAccess(RetailscmUserContext userContext, ListAccess listAccess,Map<String,Object>option) throws Exception;

	public ListAccess transferToAnotherApp(RetailscmUserContext userContext, String listAccessId, String anotherAppId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String listAccessId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ListAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByApp(RetailscmUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(RetailscmUserContext userContext,String appId, int start, int count) throws Exception;
  

}


