
package com.doublechaintech.retailscm.offerapproval;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface OfferApprovalManager{

		

	public OfferApproval createOfferApproval(RetailscmUserContext userContext, String who, Date approveTime, String comments) throws Exception;	
	public OfferApproval updateOfferApproval(RetailscmUserContext userContext,String offerApprovalId, int offerApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OfferApproval loadOfferApproval(RetailscmUserContext userContext, String offerApprovalId, String [] tokensExpr) throws Exception;
	public OfferApproval internalSaveOfferApproval(RetailscmUserContext userContext, OfferApproval offerApproval) throws Exception;
	public OfferApproval internalSaveOfferApproval(RetailscmUserContext userContext, OfferApproval offerApproval,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String offerApprovalId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, OfferApproval newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String offerApprovalId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	
	public  OfferApproval addEmployee(RetailscmUserContext userContext, String offerApprovalId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount , String [] tokensExpr)  throws Exception;
	public  OfferApproval removeEmployee(RetailscmUserContext userContext, String offerApprovalId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  OfferApproval updateEmployee(RetailscmUserContext userContext, String offerApprovalId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  OfferApproval associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception ;
	public  OfferApproval associateEmployeeListToJobApplication(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[],String jobApplicationId, String [] tokensExpr) throws Exception ;
	public  OfferApproval associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  OfferApproval associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[],String professionInterviewId, String [] tokensExpr) throws Exception ;
	public  OfferApproval associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  OfferApproval associateEmployeeListToHrInterview(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[],String hrInterviewId, String [] tokensExpr) throws Exception ;
	public  OfferApproval associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception ;
	public  OfferApproval associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[],String offerAcceptanceId, String [] tokensExpr) throws Exception ;
	public  OfferApproval associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception ;
	public  OfferApproval associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[],String employeeBoardingId, String [] tokensExpr) throws Exception ;
	public  OfferApproval associateEmployeeListToNewTermination(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception ;
	public  OfferApproval associateEmployeeListToTermination(RetailscmUserContext userContext, String offerApprovalId, String  employeeIds[],String terminationId, String [] tokensExpr) throws Exception ;

	*/



}


