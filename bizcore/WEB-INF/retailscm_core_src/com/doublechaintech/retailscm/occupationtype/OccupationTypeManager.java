
package com.doublechaintech.retailscm.occupationtype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface OccupationTypeManager{

		

	public OccupationType createOccupationType(RetailscmUserContext userContext, String code, String companyId, String description, String detailDescription) throws Exception;	
	public OccupationType updateOccupationType(RetailscmUserContext userContext,String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public OccupationType loadOccupationType(RetailscmUserContext userContext, String occupationTypeId, String [] tokensExpr) throws Exception;
	public OccupationType internalSaveOccupationType(RetailscmUserContext userContext, OccupationType occupationType) throws Exception;
	public OccupationType internalSaveOccupationType(RetailscmUserContext userContext, OccupationType occupationType,Map<String,Object>option) throws Exception;
	
	public OccupationType transferToAnotherCompany(RetailscmUserContext userContext, String occupationTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String occupationTypeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, OccupationType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String occupationTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	
	public  OccupationType addEmployee(RetailscmUserContext userContext, String occupationTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount , String [] tokensExpr)  throws Exception;
	public  OccupationType removeEmployee(RetailscmUserContext userContext, String occupationTypeId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  OccupationType updateEmployee(RetailscmUserContext userContext, String occupationTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  OccupationType associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToJobApplication(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[],String jobApplicationId, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[],String professionInterviewId, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToHrInterview(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[],String hrInterviewId, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[],String offerApprovalId, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[],String offerAcceptanceId, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[],String employeeBoardingId, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToNewTermination(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception ;
	public  OccupationType associateEmployeeListToTermination(RetailscmUserContext userContext, String occupationTypeId, String  employeeIds[],String terminationId, String [] tokensExpr) throws Exception ;

	*/



}


