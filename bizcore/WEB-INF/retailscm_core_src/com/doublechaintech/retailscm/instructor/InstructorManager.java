
package com.doublechaintech.retailscm.instructor;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface InstructorManager extends BaseManager{

		

	public Instructor createInstructor(RetailscmUserContext userContext, String title,String familyName,String givenName,String cellPhone,String email,String companyId,String introduction) throws Exception;
	public Instructor updateInstructor(RetailscmUserContext userContext,String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Instructor loadInstructor(RetailscmUserContext userContext, String instructorId, String [] tokensExpr) throws Exception;
	public Instructor internalSaveInstructor(RetailscmUserContext userContext, Instructor instructor) throws Exception;
	public Instructor internalSaveInstructor(RetailscmUserContext userContext, Instructor instructor,Map<String,Object>option) throws Exception;

	public Instructor transferToAnotherCompany(RetailscmUserContext userContext, String instructorId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String instructorId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, Instructor newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CompanyTrainingManager getCompanyTrainingManager(RetailscmUserContext userContext, String instructorId, String title, String companyId, String trainingCourseTypeId, Date timeStart, int durationHours ,String [] tokensExpr)  throws Exception;

	public  Instructor addCompanyTraining(RetailscmUserContext userContext, String instructorId, String title, String companyId, String trainingCourseTypeId, Date timeStart, int durationHours , String [] tokensExpr)  throws Exception;
	public  Instructor removeCompanyTraining(RetailscmUserContext userContext, String instructorId, String companyTrainingId, int companyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  Instructor updateCompanyTraining(RetailscmUserContext userContext, String instructorId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


