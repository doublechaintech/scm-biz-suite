
package com.doublechaintech.retailscm.catalog;
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




public interface CatalogManager extends BaseManager{

		

  List<Catalog> searchCatalogList(RetailscmUserContext ctx, CatalogRequest pRequest);
  Catalog searchCatalog(RetailscmUserContext ctx, CatalogRequest pRequest);
	public Catalog createCatalog(RetailscmUserContext userContext, String name,String ownerId,int subCount,BigDecimal amount) throws Exception;
	public Catalog updateCatalog(RetailscmUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Catalog loadCatalog(RetailscmUserContext userContext, String catalogId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public Catalog internalSaveCatalog(RetailscmUserContext userContext, Catalog catalog) throws Exception;
	public Catalog internalSaveCatalog(RetailscmUserContext userContext, Catalog catalog,Map<String,Object>option) throws Exception;

	public Catalog transferToAnotherOwner(RetailscmUserContext userContext, String catalogId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String catalogId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, Catalog newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, Catalog updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  LevelOneCategoryManager getLevelOneCategoryManager(RetailscmUserContext userContext, String catalogId, String name ,String [] tokensExpr)  throws Exception;

	public  Catalog addLevelOneCategory(RetailscmUserContext userContext, String catalogId, String name , String [] tokensExpr)  throws Exception;
	public  Catalog removeLevelOneCategory(RetailscmUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateLevelOneCategory(RetailscmUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception;
  




}


