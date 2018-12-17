
package com.doublechaintech.retailscm.companytraining;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface CompanyTrainingManager{

		

	public CompanyTraining createCompanyTraining(RetailscmUserContext userContext, String title, String companyId, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours) throws Exception;	
	public CompanyTraining updateCompanyTraining(RetailscmUserContext userContext,String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CompanyTraining loadCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String [] tokensExpr) throws Exception;
	public CompanyTraining internalSaveCompanyTraining(RetailscmUserContext userContext, CompanyTraining companyTraining) throws Exception;
	public CompanyTraining internalSaveCompanyTraining(RetailscmUserContext userContext, CompanyTraining companyTraining,Map<String,Object>option) throws Exception;
	
	public CompanyTraining transferToAnotherCompany(RetailscmUserContext userContext, String companyTrainingId, String anotherCompanyId)  throws Exception;
 	public CompanyTraining transferToAnotherInstructor(RetailscmUserContext userContext, String companyTrainingId, String anotherInstructorId)  throws Exception;
 	public CompanyTraining transferToAnotherTrainingCourseType(RetailscmUserContext userContext, String companyTrainingId, String anotherTrainingCourseTypeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String companyTrainingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, CompanyTraining newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  EmployeeCompanyTrainingManager getEmployeeCompanyTrainingManager(RetailscmUserContext userContext, String companyTrainingId, String employeeId ,String [] tokensExpr)  throws Exception;
	
	public  CompanyTraining addEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeId , String [] tokensExpr)  throws Exception;
	public  CompanyTraining removeEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  CompanyTraining updateEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  CompanyTraining associateEmployeeCompanyTrainingListToNewScoring(RetailscmUserContext userContext, String companyTrainingId, String  employeeCompanyTrainingIds[], String scoredBy, int score, String comment, String [] tokensExpr) throws Exception ;
	public  CompanyTraining associateEmployeeCompanyTrainingListToScoring(RetailscmUserContext userContext, String companyTrainingId, String  employeeCompanyTrainingIds[],String scoringId, String [] tokensExpr) throws Exception ;

	*/



}


