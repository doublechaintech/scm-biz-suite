
package com.doublechaintech.retailscm.employeecompanytraining;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;




public interface EmployeeCompanyTrainingManager extends BaseManager{

		

  List<EmployeeCompanyTraining> searchEmployeeCompanyTrainingList(RetailscmUserContext ctx, EmployeeCompanyTrainingRequest pRequest);
  EmployeeCompanyTraining searchEmployeeCompanyTraining(RetailscmUserContext ctx, EmployeeCompanyTrainingRequest pRequest);
	public EmployeeCompanyTraining createEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId,String trainingId,String scoringId) throws Exception;
	public EmployeeCompanyTraining updateEmployeeCompanyTraining(RetailscmUserContext userContext,String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeCompanyTraining loadEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeCompanyTrainingId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public EmployeeCompanyTraining internalSaveEmployeeCompanyTraining(RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining) throws Exception;
	public EmployeeCompanyTraining internalSaveEmployeeCompanyTraining(RetailscmUserContext userContext, EmployeeCompanyTraining employeeCompanyTraining,Map<String,Object>option) throws Exception;

	public EmployeeCompanyTraining transferToAnotherEmployee(RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherEmployeeId)  throws Exception;
 	public EmployeeCompanyTraining transferToAnotherTraining(RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherTrainingId)  throws Exception;
 	public EmployeeCompanyTraining transferToAnotherScoring(RetailscmUserContext userContext, String employeeCompanyTrainingId, String anotherScoringId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String employeeCompanyTrainingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeCompanyTraining newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, EmployeeCompanyTraining updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(RetailscmUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(RetailscmUserContext userContext,String employeeId, int start, int count) throws Exception;
  
	public Object listByTraining(RetailscmUserContext userContext,String trainingId) throws Exception;
	public Object listPageByTraining(RetailscmUserContext userContext,String trainingId, int start, int count) throws Exception;
  
	public Object listByScoring(RetailscmUserContext userContext,String scoringId) throws Exception;
	public Object listPageByScoring(RetailscmUserContext userContext,String scoringId, int start, int count) throws Exception;
  




}


