
package com.doublechaintech.retailscm.companytraining;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface CompanyTrainingManager extends BaseManager{

		

	public CompanyTraining createCompanyTraining(RetailscmUserContext userContext, String title,String companyId,String instructorId,String trainingCourseTypeId,Date timeStart,int durationHours) throws Exception;
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


	//public  EmployeeCompanyTrainingManager getEmployeeCompanyTrainingManager(RetailscmUserContext userContext, String companyTrainingId, String employeeId, String scoringId ,String [] tokensExpr)  throws Exception;

	public  CompanyTraining addEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeId, String scoringId , String [] tokensExpr)  throws Exception;
	public  CompanyTraining removeEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  CompanyTraining updateEmployeeCompanyTraining(RetailscmUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception;
  
	public Object listByInstructor(RetailscmUserContext userContext,String instructorId) throws Exception;
	public Object listPageByInstructor(RetailscmUserContext userContext,String instructorId, int start, int count) throws Exception;
  
	public Object listByTrainingCourseType(RetailscmUserContext userContext,String trainingCourseTypeId) throws Exception;
	public Object listPageByTrainingCourseType(RetailscmUserContext userContext,String trainingCourseTypeId, int start, int count) throws Exception;
  

}


