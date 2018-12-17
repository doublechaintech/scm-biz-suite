
package com.doublechaintech.retailscm.professioninterview;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface ProfessionInterviewManager{

		

	public ProfessionInterview createProfessionInterview(RetailscmUserContext userContext, String who, Date interviewTime, String comments) throws Exception;	
	public ProfessionInterview updateProfessionInterview(RetailscmUserContext userContext,String professionInterviewId, int professionInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ProfessionInterview loadProfessionInterview(RetailscmUserContext userContext, String professionInterviewId, String [] tokensExpr) throws Exception;
	public ProfessionInterview internalSaveProfessionInterview(RetailscmUserContext userContext, ProfessionInterview professionInterview) throws Exception;
	public ProfessionInterview internalSaveProfessionInterview(RetailscmUserContext userContext, ProfessionInterview professionInterview,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String professionInterviewId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ProfessionInterview newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	
	public  ProfessionInterview addEmployee(RetailscmUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount , String [] tokensExpr)  throws Exception;
	public  ProfessionInterview removeEmployee(RetailscmUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  ProfessionInterview updateEmployee(RetailscmUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  ProfessionInterview associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception ;
	public  ProfessionInterview associateEmployeeListToJobApplication(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[],String jobApplicationId, String [] tokensExpr) throws Exception ;
	public  ProfessionInterview associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  ProfessionInterview associateEmployeeListToHrInterview(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[],String hrInterviewId, String [] tokensExpr) throws Exception ;
	public  ProfessionInterview associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception ;
	public  ProfessionInterview associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[],String offerApprovalId, String [] tokensExpr) throws Exception ;
	public  ProfessionInterview associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception ;
	public  ProfessionInterview associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[],String offerAcceptanceId, String [] tokensExpr) throws Exception ;
	public  ProfessionInterview associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception ;
	public  ProfessionInterview associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[],String employeeBoardingId, String [] tokensExpr) throws Exception ;
	public  ProfessionInterview associateEmployeeListToNewTermination(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception ;
	public  ProfessionInterview associateEmployeeListToTermination(RetailscmUserContext userContext, String professionInterviewId, String  employeeIds[],String terminationId, String [] tokensExpr) throws Exception ;

	*/



}


