
package com.doublechaintech.retailscm.scoring;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface ScoringManager extends BaseManager{

		

	public Scoring createScoring(RetailscmUserContext userContext, String scoredBy,int score,String comment) throws Exception;
	public Scoring updateScoring(RetailscmUserContext userContext,String scoringId, int scoringVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Scoring loadScoring(RetailscmUserContext userContext, String scoringId, String [] tokensExpr) throws Exception;
	public Scoring internalSaveScoring(RetailscmUserContext userContext, Scoring scoring) throws Exception;
	public Scoring internalSaveScoring(RetailscmUserContext userContext, Scoring scoring,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String scoringId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, Scoring newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeCompanyTrainingManager getEmployeeCompanyTrainingManager(RetailscmUserContext userContext, String scoringId, String employeeId, String trainingId ,String [] tokensExpr)  throws Exception;

	public  Scoring addEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, String employeeId, String trainingId , String [] tokensExpr)  throws Exception;
	public  Scoring removeEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  Scoring updateEmployeeCompanyTraining(RetailscmUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


