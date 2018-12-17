
package com.doublechaintech.retailscm.employeeleave;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface EmployeeLeaveManager{

		

	public EmployeeLeave createEmployeeLeave(RetailscmUserContext userContext, String whoId, String typeId, int leaveDurationHour, String remark) throws Exception;	
	public EmployeeLeave updateEmployeeLeave(RetailscmUserContext userContext,String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeLeave loadEmployeeLeave(RetailscmUserContext userContext, String employeeLeaveId, String [] tokensExpr) throws Exception;
	public EmployeeLeave internalSaveEmployeeLeave(RetailscmUserContext userContext, EmployeeLeave employeeLeave) throws Exception;
	public EmployeeLeave internalSaveEmployeeLeave(RetailscmUserContext userContext, EmployeeLeave employeeLeave,Map<String,Object>option) throws Exception;
	
	public EmployeeLeave transferToAnotherWho(RetailscmUserContext userContext, String employeeLeaveId, String anotherWhoId)  throws Exception;
 	public EmployeeLeave transferToAnotherType(RetailscmUserContext userContext, String employeeLeaveId, String anotherTypeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String employeeLeaveId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeLeave newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


