
package com.doublechaintech.retailscm.levelonecategory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface LevelOneCategoryManager extends BaseManager{

		

	public LevelOneCategory createLevelOneCategory(RetailscmUserContext userContext, String catalogId,String name) throws Exception;
	public LevelOneCategory updateLevelOneCategory(RetailscmUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelOneCategory loadLevelOneCategory(RetailscmUserContext userContext, String levelOneCategoryId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public LevelOneCategory internalSaveLevelOneCategory(RetailscmUserContext userContext, LevelOneCategory levelOneCategory) throws Exception;
	public LevelOneCategory internalSaveLevelOneCategory(RetailscmUserContext userContext, LevelOneCategory levelOneCategory,Map<String,Object>option) throws Exception;

	public LevelOneCategory transferToAnotherCatalog(RetailscmUserContext userContext, String levelOneCategoryId, String anotherCatalogId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String levelOneCategoryId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelOneCategory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  LevelTwoCategoryManager getLevelTwoCategoryManager(RetailscmUserContext userContext, String levelOneCategoryId, String name ,String [] tokensExpr)  throws Exception;

	public  LevelOneCategory addLevelTwoCategory(RetailscmUserContext userContext, String levelOneCategoryId, String name , String [] tokensExpr)  throws Exception;
	public  LevelOneCategory removeLevelTwoCategory(RetailscmUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelOneCategory updateLevelTwoCategory(RetailscmUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCatalog(RetailscmUserContext userContext,String catalogId) throws Exception;
	public Object listPageByCatalog(RetailscmUserContext userContext,String catalogId, int start, int count) throws Exception;
  

}


