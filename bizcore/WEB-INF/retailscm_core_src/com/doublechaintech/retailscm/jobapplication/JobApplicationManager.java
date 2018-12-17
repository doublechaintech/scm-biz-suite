
package com.doublechaintech.retailscm.jobapplication;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface JobApplicationManager{

		

	public JobApplication createJobApplication(RetailscmUserContext userContext, Date applicationTime, String who, String comments) throws Exception;	
	public JobApplication updateJobApplication(RetailscmUserContext userContext,String jobApplicationId, int jobApplicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public JobApplication loadJobApplication(RetailscmUserContext userContext, String jobApplicationId, String [] tokensExpr) throws Exception;
	public JobApplication internalSaveJobApplication(RetailscmUserContext userContext, JobApplication jobApplication) throws Exception;
	public JobApplication internalSaveJobApplication(RetailscmUserContext userContext, JobApplication jobApplication,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String jobApplicationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, JobApplication newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	
	public  JobApplication addEmployee(RetailscmUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount , String [] tokensExpr)  throws Exception;
	public  JobApplication removeEmployee(RetailscmUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  JobApplication updateEmployee(RetailscmUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  JobApplication associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  JobApplication associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[],String professionInterviewId, String [] tokensExpr) throws Exception ;
	public  JobApplication associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  JobApplication associateEmployeeListToHrInterview(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[],String hrInterviewId, String [] tokensExpr) throws Exception ;
	public  JobApplication associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception ;
	public  JobApplication associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[],String offerApprovalId, String [] tokensExpr) throws Exception ;
	public  JobApplication associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception ;
	public  JobApplication associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[],String offerAcceptanceId, String [] tokensExpr) throws Exception ;
	public  JobApplication associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception ;
	public  JobApplication associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[],String employeeBoardingId, String [] tokensExpr) throws Exception ;
	public  JobApplication associateEmployeeListToNewTermination(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception ;
	public  JobApplication associateEmployeeListToTermination(RetailscmUserContext userContext, String jobApplicationId, String  employeeIds[],String terminationId, String [] tokensExpr) throws Exception ;

	*/



}


