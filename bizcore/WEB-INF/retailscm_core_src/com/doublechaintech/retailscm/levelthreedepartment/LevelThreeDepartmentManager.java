
package com.doublechaintech.retailscm.levelthreedepartment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface LevelThreeDepartmentManager extends BaseManager{

		

	public LevelThreeDepartment createLevelThreeDepartment(RetailscmUserContext userContext, String belongsToId,String name,String description,Date founded) throws Exception;
	public LevelThreeDepartment updateLevelThreeDepartment(RetailscmUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelThreeDepartment loadLevelThreeDepartment(RetailscmUserContext userContext, String levelThreeDepartmentId, String [] tokensExpr) throws Exception;
	public LevelThreeDepartment internalSaveLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment) throws Exception;
	public LevelThreeDepartment internalSaveLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment,Map<String,Object>option) throws Exception;

	public LevelThreeDepartment transferToAnotherBelongsTo(RetailscmUserContext userContext, String levelThreeDepartmentId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String levelThreeDepartmentId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelThreeDepartment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;

	public  LevelThreeDepartment addEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount , String [] tokensExpr)  throws Exception;
	public  LevelThreeDepartment removeEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  LevelThreeDepartment updateEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongsTo(RetailscmUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(RetailscmUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


