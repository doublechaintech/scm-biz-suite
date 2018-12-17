
package com.doublechaintech.retailscm.salarygrade;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface SalaryGradeManager{

		

	public SalaryGrade createSalaryGrade(RetailscmUserContext userContext, String code, String companyId, String name, String detailDescription) throws Exception;	
	public SalaryGrade updateSalaryGrade(RetailscmUserContext userContext,String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SalaryGrade loadSalaryGrade(RetailscmUserContext userContext, String salaryGradeId, String [] tokensExpr) throws Exception;
	public SalaryGrade internalSaveSalaryGrade(RetailscmUserContext userContext, SalaryGrade salaryGrade) throws Exception;
	public SalaryGrade internalSaveSalaryGrade(RetailscmUserContext userContext, SalaryGrade salaryGrade,Map<String,Object>option) throws Exception;
	
	public SalaryGrade transferToAnotherCompany(RetailscmUserContext userContext, String salaryGradeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String salaryGradeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SalaryGrade newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String salaryGradeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	
	public  SalaryGrade addEmployee(RetailscmUserContext userContext, String salaryGradeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String salaryAccount , String [] tokensExpr)  throws Exception;
	public  SalaryGrade removeEmployee(RetailscmUserContext userContext, String salaryGradeId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  SalaryGrade updateEmployee(RetailscmUserContext userContext, String salaryGradeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SalaryGrade associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToJobApplication(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[],String jobApplicationId, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[],String professionInterviewId, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToHrInterview(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[],String hrInterviewId, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[],String offerApprovalId, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[],String offerAcceptanceId, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[],String employeeBoardingId, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToNewTermination(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeListToTermination(RetailscmUserContext userContext, String salaryGradeId, String  employeeIds[],String terminationId, String [] tokensExpr) throws Exception ;

	*/

	//public  EmployeeSalarySheetManager getEmployeeSalarySheetManager(RetailscmUserContext userContext, String salaryGradeId, String employeeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance ,String [] tokensExpr)  throws Exception;
	
	public  SalaryGrade addEmployeeSalarySheet(RetailscmUserContext userContext, String salaryGradeId, String employeeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance , String [] tokensExpr)  throws Exception;
	public  SalaryGrade removeEmployeeSalarySheet(RetailscmUserContext userContext, String salaryGradeId, String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr)  throws Exception;
	public  SalaryGrade updateEmployeeSalarySheet(RetailscmUserContext userContext, String salaryGradeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SalaryGrade associateEmployeeSalarySheetListToNewPayingOff(RetailscmUserContext userContext, String salaryGradeId, String  employeeSalarySheetIds[], String who, String paidForId, Date paidTime, BigDecimal amount, String [] tokensExpr) throws Exception ;
	public  SalaryGrade associateEmployeeSalarySheetListToPayingOff(RetailscmUserContext userContext, String salaryGradeId, String  employeeSalarySheetIds[],String payingOffId, String [] tokensExpr) throws Exception ;

	*/



}


