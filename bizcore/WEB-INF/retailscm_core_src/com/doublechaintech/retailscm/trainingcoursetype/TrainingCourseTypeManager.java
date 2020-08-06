
package com.doublechaintech.retailscm.trainingcoursetype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface TrainingCourseTypeManager extends BaseManager{

		

	public TrainingCourseType createTrainingCourseType(RetailscmUserContext userContext, String code,String companyId,String name,String description) throws Exception;
	public TrainingCourseType updateTrainingCourseType(RetailscmUserContext userContext,String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TrainingCourseType loadTrainingCourseType(RetailscmUserContext userContext, String trainingCourseTypeId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public TrainingCourseType internalSaveTrainingCourseType(RetailscmUserContext userContext, TrainingCourseType trainingCourseType) throws Exception;
	public TrainingCourseType internalSaveTrainingCourseType(RetailscmUserContext userContext, TrainingCourseType trainingCourseType,Map<String,Object>option) throws Exception;

	public TrainingCourseType transferToAnotherCompany(RetailscmUserContext userContext, String trainingCourseTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String trainingCourseTypeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, TrainingCourseType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CompanyTrainingManager getCompanyTrainingManager(RetailscmUserContext userContext, String trainingCourseTypeId, String title, String companyId, String instructorId, Date timeStart, int durationHours ,String [] tokensExpr)  throws Exception;

	public  TrainingCourseType addCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, String title, String companyId, String instructorId, Date timeStart, int durationHours , String [] tokensExpr)  throws Exception;
	public  TrainingCourseType removeCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, String companyTrainingId, int companyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  TrainingCourseType updateCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


