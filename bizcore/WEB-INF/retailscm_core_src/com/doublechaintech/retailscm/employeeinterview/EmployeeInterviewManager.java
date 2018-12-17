
package com.doublechaintech.retailscm.employeeinterview;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface EmployeeInterviewManager{

		

	public EmployeeInterview createEmployeeInterview(RetailscmUserContext userContext, String employeeId, String interviewTypeId, String remark) throws Exception;	
	public EmployeeInterview updateEmployeeInterview(RetailscmUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeInterview loadEmployeeInterview(RetailscmUserContext userContext, String employeeInterviewId, String [] tokensExpr) throws Exception;
	public EmployeeInterview internalSaveEmployeeInterview(RetailscmUserContext userContext, EmployeeInterview employeeInterview) throws Exception;
	public EmployeeInterview internalSaveEmployeeInterview(RetailscmUserContext userContext, EmployeeInterview employeeInterview,Map<String,Object>option) throws Exception;
	
	public EmployeeInterview transferToAnotherEmployee(RetailscmUserContext userContext, String employeeInterviewId, String anotherEmployeeId)  throws Exception;
 	public EmployeeInterview transferToAnotherInterviewType(RetailscmUserContext userContext, String employeeInterviewId, String anotherInterviewTypeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String employeeInterviewId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeInterview newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


