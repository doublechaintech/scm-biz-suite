
package com.doublechaintech.retailscm.interviewtype;
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




public interface InterviewTypeManager extends BaseManager{

		

  List<InterviewType> searchInterviewTypeList(RetailscmUserContext ctx, InterviewTypeRequest pRequest);
  InterviewType searchInterviewType(RetailscmUserContext ctx, InterviewTypeRequest pRequest);
	public InterviewType createInterviewType(RetailscmUserContext userContext, String code,String companyId,String description,String detailDescription) throws Exception;
	public InterviewType updateInterviewType(RetailscmUserContext userContext,String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public InterviewType loadInterviewType(RetailscmUserContext userContext, String interviewTypeId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public InterviewType internalSaveInterviewType(RetailscmUserContext userContext, InterviewType interviewType) throws Exception;
	public InterviewType internalSaveInterviewType(RetailscmUserContext userContext, InterviewType interviewType,Map<String,Object>option) throws Exception;

	public InterviewType transferToAnotherCompany(RetailscmUserContext userContext, String interviewTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String interviewTypeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, InterviewType newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, InterviewType updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeInterviewManager getEmployeeInterviewManager(RetailscmUserContext userContext, String interviewTypeId, String employeeId, String remark ,String [] tokensExpr)  throws Exception;

	public  InterviewType addEmployeeInterview(RetailscmUserContext userContext, String interviewTypeId, String employeeId, String remark , String [] tokensExpr)  throws Exception;
	public  InterviewType removeEmployeeInterview(RetailscmUserContext userContext, String interviewTypeId, String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr)  throws Exception;
	public  InterviewType updateEmployeeInterview(RetailscmUserContext userContext, String interviewTypeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception;
  




}


