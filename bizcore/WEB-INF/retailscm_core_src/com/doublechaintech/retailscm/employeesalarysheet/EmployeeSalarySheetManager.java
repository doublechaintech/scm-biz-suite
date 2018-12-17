
package com.doublechaintech.retailscm.employeesalarysheet;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface EmployeeSalarySheetManager{

		

	public EmployeeSalarySheet createEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance) throws Exception;	
	public EmployeeSalarySheet updateEmployeeSalarySheet(RetailscmUserContext userContext,String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeSalarySheet loadEmployeeSalarySheet(RetailscmUserContext userContext, String employeeSalarySheetId, String [] tokensExpr) throws Exception;
	public EmployeeSalarySheet internalSaveEmployeeSalarySheet(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet) throws Exception;
	public EmployeeSalarySheet internalSaveEmployeeSalarySheet(RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet,Map<String,Object>option) throws Exception;
	
	public EmployeeSalarySheet transferToAnotherEmployee(RetailscmUserContext userContext, String employeeSalarySheetId, String anotherEmployeeId)  throws Exception;
 	public EmployeeSalarySheet transferToAnotherCurrentSalaryGrade(RetailscmUserContext userContext, String employeeSalarySheetId, String anotherCurrentSalaryGradeId)  throws Exception;
 	public EmployeeSalarySheet payOff(RetailscmUserContext userContext, String employeeSalarySheetId, String who, String paidForId, Date paidTime, BigDecimal amount
)  throws Exception;


	public void delete(RetailscmUserContext userContext, String employeeSalarySheetId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeSalarySheet newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


