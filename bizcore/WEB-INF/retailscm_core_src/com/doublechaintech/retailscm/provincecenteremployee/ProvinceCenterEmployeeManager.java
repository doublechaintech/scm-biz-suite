
package com.doublechaintech.retailscm.provincecenteremployee;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface ProvinceCenterEmployeeManager{

		

	public ProvinceCenterEmployee createProvinceCenterEmployee(RetailscmUserContext userContext, String name, String mobile, String email, Date founded, String departmentId, String provinceCenterId) throws Exception;	
	public ProvinceCenterEmployee updateProvinceCenterEmployee(RetailscmUserContext userContext,String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ProvinceCenterEmployee loadProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterEmployeeId, String [] tokensExpr) throws Exception;
	public ProvinceCenterEmployee internalSaveProvinceCenterEmployee(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee) throws Exception;
	public ProvinceCenterEmployee internalSaveProvinceCenterEmployee(RetailscmUserContext userContext, ProvinceCenterEmployee provinceCenterEmployee,Map<String,Object>option) throws Exception;
	
	public ProvinceCenterEmployee transferToAnotherDepartment(RetailscmUserContext userContext, String provinceCenterEmployeeId, String anotherDepartmentId)  throws Exception;
 	public ProvinceCenterEmployee transferToAnotherProvinceCenter(RetailscmUserContext userContext, String provinceCenterEmployeeId, String anotherProvinceCenterId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String provinceCenterEmployeeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ProvinceCenterEmployee newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


