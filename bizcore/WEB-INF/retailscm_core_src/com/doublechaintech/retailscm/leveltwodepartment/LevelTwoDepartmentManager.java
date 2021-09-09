
package com.doublechaintech.retailscm.leveltwodepartment;
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




public interface LevelTwoDepartmentManager extends BaseManager{

		

  List<LevelTwoDepartment> searchLevelTwoDepartmentList(RetailscmUserContext ctx, LevelTwoDepartmentRequest pRequest);
  LevelTwoDepartment searchLevelTwoDepartment(RetailscmUserContext ctx, LevelTwoDepartmentRequest pRequest);
	public LevelTwoDepartment createLevelTwoDepartment(RetailscmUserContext userContext, String belongsToId,String name,String description,Date founded) throws Exception;
	public LevelTwoDepartment updateLevelTwoDepartment(RetailscmUserContext userContext,String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelTwoDepartment loadLevelTwoDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public LevelTwoDepartment internalSaveLevelTwoDepartment(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment) throws Exception;
	public LevelTwoDepartment internalSaveLevelTwoDepartment(RetailscmUserContext userContext, LevelTwoDepartment levelTwoDepartment,Map<String,Object>option) throws Exception;

	public LevelTwoDepartment transferToAnotherBelongsTo(RetailscmUserContext userContext, String levelTwoDepartmentId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String levelTwoDepartmentId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelTwoDepartment newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, LevelTwoDepartment updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  LevelThreeDepartmentManager getLevelThreeDepartmentManager(RetailscmUserContext userContext, String levelTwoDepartmentId, String name, String description, Date founded ,String [] tokensExpr)  throws Exception;

	public  LevelTwoDepartment addLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String name, String description, Date founded , String [] tokensExpr)  throws Exception;
	public  LevelTwoDepartment removeLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  LevelTwoDepartment updateLevelThreeDepartment(RetailscmUserContext userContext, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongsTo(RetailscmUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(RetailscmUserContext userContext,String belongsToId, int start, int count) throws Exception;
  




}


