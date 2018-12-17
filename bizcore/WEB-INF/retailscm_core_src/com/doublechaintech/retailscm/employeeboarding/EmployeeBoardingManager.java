
package com.doublechaintech.retailscm.employeeboarding;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface EmployeeBoardingManager{

		

	public EmployeeBoarding createEmployeeBoarding(RetailscmUserContext userContext, String who, Date employTime, String comments) throws Exception;	
	public EmployeeBoarding updateEmployeeBoarding(RetailscmUserContext userContext,String employeeBoardingId, int employeeBoardingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeBoarding loadEmployeeBoarding(RetailscmUserContext userContext, String employeeBoardingId, String [] tokensExpr) throws Exception;
	public EmployeeBoarding internalSaveEmployeeBoarding(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding) throws Exception;
	public EmployeeBoarding internalSaveEmployeeBoarding(RetailscmUserContext userContext, EmployeeBoarding employeeBoarding,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String employeeBoardingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeBoarding newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	
	public  EmployeeBoarding addEmployee(RetailscmUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount , String [] tokensExpr)  throws Exception;
	public  EmployeeBoarding removeEmployee(RetailscmUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  EmployeeBoarding updateEmployee(RetailscmUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  EmployeeBoarding associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception ;
	public  EmployeeBoarding associateEmployeeListToJobApplication(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[],String jobApplicationId, String [] tokensExpr) throws Exception ;
	public  EmployeeBoarding associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  EmployeeBoarding associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[],String professionInterviewId, String [] tokensExpr) throws Exception ;
	public  EmployeeBoarding associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  EmployeeBoarding associateEmployeeListToHrInterview(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[],String hrInterviewId, String [] tokensExpr) throws Exception ;
	public  EmployeeBoarding associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception ;
	public  EmployeeBoarding associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[],String offerApprovalId, String [] tokensExpr) throws Exception ;
	public  EmployeeBoarding associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception ;
	public  EmployeeBoarding associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[],String offerAcceptanceId, String [] tokensExpr) throws Exception ;
	public  EmployeeBoarding associateEmployeeListToNewTermination(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception ;
	public  EmployeeBoarding associateEmployeeListToTermination(RetailscmUserContext userContext, String employeeBoardingId, String  employeeIds[],String terminationId, String [] tokensExpr) throws Exception ;

	*/



}


