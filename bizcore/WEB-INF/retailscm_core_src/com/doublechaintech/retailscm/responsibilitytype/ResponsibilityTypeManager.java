
package com.doublechaintech.retailscm.responsibilitytype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface ResponsibilityTypeManager{

		

	public ResponsibilityType createResponsibilityType(RetailscmUserContext userContext, String code, String companyId, String baseDescription, String detailDescription) throws Exception;	
	public ResponsibilityType updateResponsibilityType(RetailscmUserContext userContext,String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ResponsibilityType loadResponsibilityType(RetailscmUserContext userContext, String responsibilityTypeId, String [] tokensExpr) throws Exception;
	public ResponsibilityType internalSaveResponsibilityType(RetailscmUserContext userContext, ResponsibilityType responsibilityType) throws Exception;
	public ResponsibilityType internalSaveResponsibilityType(RetailscmUserContext userContext, ResponsibilityType responsibilityType,Map<String,Object>option) throws Exception;
	
	public ResponsibilityType transferToAnotherCompany(RetailscmUserContext userContext, String responsibilityTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String responsibilityTypeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ResponsibilityType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	
	public  ResponsibilityType addEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount , String [] tokensExpr)  throws Exception;
	public  ResponsibilityType removeEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  ResponsibilityType updateEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  ResponsibilityType associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToJobApplication(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[],String jobApplicationId, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[],String professionInterviewId, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToHrInterview(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[],String hrInterviewId, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[],String offerApprovalId, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[],String offerAcceptanceId, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[],String employeeBoardingId, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToNewTermination(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception ;
	public  ResponsibilityType associateEmployeeListToTermination(RetailscmUserContext userContext, String responsibilityTypeId, String  employeeIds[],String terminationId, String [] tokensExpr) throws Exception ;

	*/



}


