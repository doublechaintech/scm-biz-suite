
package com.doublechaintech.retailscm.retailstoreprovincecenter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreProvinceCenterManager{

		

	public RetailStoreProvinceCenter createRetailStoreProvinceCenter(RetailscmUserContext userContext, String name, Date founded, String countryId) throws Exception;	
	public RetailStoreProvinceCenter updateRetailStoreProvinceCenter(RetailscmUserContext userContext,String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreProvinceCenter loadRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String [] tokensExpr) throws Exception;
	public RetailStoreProvinceCenter internalSaveRetailStoreProvinceCenter(RetailscmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter) throws Exception;
	public RetailStoreProvinceCenter internalSaveRetailStoreProvinceCenter(RetailscmUserContext userContext, RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String,Object>option) throws Exception;
	
	public RetailStoreProvinceCenter transferToAnotherCountry(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String anotherCountryId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String retailStoreProvinceCenterId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreProvinceCenter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ProvinceCenterDepartmentManager getProvinceCenterDepartmentManager(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String manager ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreProvinceCenter addProvinceCenterDepartment(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String manager , String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter removeProvinceCenterDepartment(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter updateProvinceCenterDepartment(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProvinceCenterEmployeeManager getProvinceCenterEmployeeManager(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String name, String mobile, String email, Date founded, String departmentId ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreProvinceCenter addProvinceCenterEmployee(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String name, String mobile, String email, Date founded, String departmentId , String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter removeProvinceCenterEmployee(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter updateProvinceCenterEmployee(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreCityServiceCenterManager getRetailStoreCityServiceCenterManager(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreProvinceCenter addRetailStoreCityServiceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded , String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter removeRetailStoreCityServiceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter updateRetailStoreCityServiceCenter(RetailscmUserContext userContext, String retailStoreProvinceCenterId, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


