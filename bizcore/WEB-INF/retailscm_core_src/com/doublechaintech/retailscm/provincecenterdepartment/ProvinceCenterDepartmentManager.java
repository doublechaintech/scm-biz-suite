
package com.doublechaintech.retailscm.provincecenterdepartment;
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




public interface ProvinceCenterDepartmentManager extends BaseManager{

		

  List<ProvinceCenterDepartment> searchProvinceCenterDepartmentList(RetailscmUserContext ctx, ProvinceCenterDepartmentRequest pRequest);
  ProvinceCenterDepartment searchProvinceCenterDepartment(RetailscmUserContext ctx, ProvinceCenterDepartmentRequest pRequest);
	public ProvinceCenterDepartment createProvinceCenterDepartment(RetailscmUserContext userContext, String name,Date founded,String provinceCenterId,String manager) throws Exception;
	public ProvinceCenterDepartment updateProvinceCenterDepartment(RetailscmUserContext userContext,String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ProvinceCenterDepartment loadProvinceCenterDepartment(RetailscmUserContext userContext, String provinceCenterDepartmentId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public ProvinceCenterDepartment internalSaveProvinceCenterDepartment(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment) throws Exception;
	public ProvinceCenterDepartment internalSaveProvinceCenterDepartment(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment,Map<String,Object>option) throws Exception;

	public ProvinceCenterDepartment transferToAnotherProvinceCenter(RetailscmUserContext userContext, String provinceCenterDepartmentId, String anotherProvinceCenterId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String provinceCenterDepartmentId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ProvinceCenterDepartment newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, ProvinceCenterDepartment updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ProvinceCenterEmployeeManager getProvinceCenterEmployeeManager(RetailscmUserContext userContext, String provinceCenterDepartmentId, String name, String mobile, String email, Date founded, String provinceCenterId ,String [] tokensExpr)  throws Exception;

	public  ProvinceCenterDepartment addProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, String name, String mobile, String email, Date founded, String provinceCenterId , String [] tokensExpr)  throws Exception;
	public  ProvinceCenterDepartment removeProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr)  throws Exception;
	public  ProvinceCenterDepartment updateProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByProvinceCenter(RetailscmUserContext userContext,String provinceCenterId) throws Exception;
	public Object listPageByProvinceCenter(RetailscmUserContext userContext,String provinceCenterId, int start, int count) throws Exception;
  




}


