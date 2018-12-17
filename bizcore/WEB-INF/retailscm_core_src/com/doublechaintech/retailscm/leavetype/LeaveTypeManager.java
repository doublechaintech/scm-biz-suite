
package com.doublechaintech.retailscm.leavetype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface LeaveTypeManager{

		

	public LeaveType createLeaveType(RetailscmUserContext userContext, String code, String companyId, String description, String detailDescription) throws Exception;	
	public LeaveType updateLeaveType(RetailscmUserContext userContext,String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LeaveType loadLeaveType(RetailscmUserContext userContext, String leaveTypeId, String [] tokensExpr) throws Exception;
	public LeaveType internalSaveLeaveType(RetailscmUserContext userContext, LeaveType leaveType) throws Exception;
	public LeaveType internalSaveLeaveType(RetailscmUserContext userContext, LeaveType leaveType,Map<String,Object>option) throws Exception;
	
	public LeaveType transferToAnotherCompany(RetailscmUserContext userContext, String leaveTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String leaveTypeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, LeaveType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  EmployeeLeaveManager getEmployeeLeaveManager(RetailscmUserContext userContext, String leaveTypeId, String whoId, int leaveDurationHour, String remark ,String [] tokensExpr)  throws Exception;
	
	public  LeaveType addEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, String whoId, int leaveDurationHour, String remark , String [] tokensExpr)  throws Exception;
	public  LeaveType removeEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr)  throws Exception;
	public  LeaveType updateEmployeeLeave(RetailscmUserContext userContext, String leaveTypeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


