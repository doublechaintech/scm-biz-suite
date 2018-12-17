
package com.doublechaintech.retailscm.hrinterview;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface HrInterviewManager{

		

	public HrInterview createHrInterview(RetailscmUserContext userContext, String who, Date interviewTime, String comments) throws Exception;	
	public HrInterview updateHrInterview(RetailscmUserContext userContext,String hrInterviewId, int hrInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public HrInterview loadHrInterview(RetailscmUserContext userContext, String hrInterviewId, String [] tokensExpr) throws Exception;
	public HrInterview internalSaveHrInterview(RetailscmUserContext userContext, HrInterview hrInterview) throws Exception;
	public HrInterview internalSaveHrInterview(RetailscmUserContext userContext, HrInterview hrInterview,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String hrInterviewId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, HrInterview newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	
	public  HrInterview addEmployee(RetailscmUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount , String [] tokensExpr)  throws Exception;
	public  HrInterview removeEmployee(RetailscmUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  HrInterview updateEmployee(RetailscmUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  HrInterview associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception ;
	public  HrInterview associateEmployeeListToJobApplication(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[],String jobApplicationId, String [] tokensExpr) throws Exception ;
	public  HrInterview associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  HrInterview associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[],String professionInterviewId, String [] tokensExpr) throws Exception ;
	public  HrInterview associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception ;
	public  HrInterview associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[],String offerApprovalId, String [] tokensExpr) throws Exception ;
	public  HrInterview associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception ;
	public  HrInterview associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[],String offerAcceptanceId, String [] tokensExpr) throws Exception ;
	public  HrInterview associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception ;
	public  HrInterview associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[],String employeeBoardingId, String [] tokensExpr) throws Exception ;
	public  HrInterview associateEmployeeListToNewTermination(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception ;
	public  HrInterview associateEmployeeListToTermination(RetailscmUserContext userContext, String hrInterviewId, String  employeeIds[],String terminationId, String [] tokensExpr) throws Exception ;

	*/



}


