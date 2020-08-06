
package com.doublechaintech.retailscm.levelonedepartment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface LevelOneDepartmentManager extends BaseManager{

		

	public LevelOneDepartment createLevelOneDepartment(RetailscmUserContext userContext, String belongsToId,String name,String description,String manager,Date founded) throws Exception;
	public LevelOneDepartment updateLevelOneDepartment(RetailscmUserContext userContext,String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelOneDepartment loadLevelOneDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public LevelOneDepartment internalSaveLevelOneDepartment(RetailscmUserContext userContext, LevelOneDepartment levelOneDepartment) throws Exception;
	public LevelOneDepartment internalSaveLevelOneDepartment(RetailscmUserContext userContext, LevelOneDepartment levelOneDepartment,Map<String,Object>option) throws Exception;

	public LevelOneDepartment transferToAnotherBelongsTo(RetailscmUserContext userContext, String levelOneDepartmentId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String levelOneDepartmentId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelOneDepartment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  LevelTwoDepartmentManager getLevelTwoDepartmentManager(RetailscmUserContext userContext, String levelOneDepartmentId, String name, String description, Date founded ,String [] tokensExpr)  throws Exception;

	public  LevelOneDepartment addLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String name, String description, Date founded , String [] tokensExpr)  throws Exception;
	public  LevelOneDepartment removeLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String levelTwoDepartmentId, int levelTwoDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  LevelOneDepartment updateLevelTwoDepartment(RetailscmUserContext userContext, String levelOneDepartmentId, String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongsTo(RetailscmUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(RetailscmUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


