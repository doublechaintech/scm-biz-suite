
package com.doublechaintech.retailscm.leavetype;
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




public interface LeaveTypeManager extends BaseManager{

		

  List<LeaveType> searchLeaveTypeList(RetailscmUserContext ctx, LeaveTypeRequest pRequest);
  LeaveType searchLeaveType(RetailscmUserContext ctx, LeaveTypeRequest pRequest);
	public LeaveType createLeaveType(RetailscmUserContext userContext, String code,String companyId,String description,String detailDescription) throws Exception;
	public LeaveType updateLeaveType(RetailscmUserContext userContext,String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LeaveType loadLeaveType(RetailscmUserContext userContext, String leaveTypeId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public LeaveType internalSaveLeaveType(RetailscmUserContext userContext, LeaveType leaveType) throws Exception;
	public LeaveType internalSaveLeaveType(RetailscmUserContext userContext, LeaveType leaveType,Map<String,Object>option) throws Exception;

	public LeaveType transferToAnotherCompany(RetailscmUserContext userContext, String leaveTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String leaveTypeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, LeaveType newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, LeaveType updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeLeaveManager getEmployeeLeaveManager(RetailscmUserContext userContext, String leaveTypeId, String whoId, int leaveDurationHour, String remark ,String [] tokensExpr)  throws Exception;

	public  LeaveType addEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, String whoId, int leaveDurationHour, String remark , String [] tokensExpr)  throws Exception;
	public  LeaveType removeEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr)  throws Exception;
	public  LeaveType updateEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception;
  




}


