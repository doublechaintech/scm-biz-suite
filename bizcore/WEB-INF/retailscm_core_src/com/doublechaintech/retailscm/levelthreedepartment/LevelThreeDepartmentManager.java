
package com.doublechaintech.retailscm.levelthreedepartment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface LevelThreeDepartmentManager{

		

	public LevelThreeDepartment createLevelThreeDepartment(RetailscmUserContext userContext, String belongsToId, String name, String description, Date founded) throws Exception;	
	public LevelThreeDepartment updateLevelThreeDepartment(RetailscmUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LevelThreeDepartment loadLevelThreeDepartment(RetailscmUserContext userContext, String levelThreeDepartmentId, String [] tokensExpr) throws Exception;
	public LevelThreeDepartment internalSaveLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment) throws Exception;
	public LevelThreeDepartment internalSaveLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment,Map<String,Object>option) throws Exception;
	
	public LevelThreeDepartment transferToAnotherBelongsTo(RetailscmUserContext userContext, String levelThreeDepartmentId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String levelThreeDepartmentId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelThreeDepartment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	
	public  LevelThreeDepartment addEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount , String [] tokensExpr)  throws Exception;
	public  LevelThreeDepartment removeEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  LevelThreeDepartment updateEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  LevelThreeDepartment associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToJobApplication(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[],String jobApplicationId, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[],String professionInterviewId, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToHrInterview(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[],String hrInterviewId, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[],String offerApprovalId, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[],String offerAcceptanceId, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[],String employeeBoardingId, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToNewTermination(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception ;
	public  LevelThreeDepartment associateEmployeeListToTermination(RetailscmUserContext userContext, String levelThreeDepartmentId, String  employeeIds[],String terminationId, String [] tokensExpr) throws Exception ;

	*/



}


