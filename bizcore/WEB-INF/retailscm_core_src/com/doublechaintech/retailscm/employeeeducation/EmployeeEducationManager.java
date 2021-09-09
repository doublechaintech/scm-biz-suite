
package com.doublechaintech.retailscm.employeeeducation;
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




public interface EmployeeEducationManager extends BaseManager{

		

  List<EmployeeEducation> searchEmployeeEducationList(RetailscmUserContext ctx, EmployeeEducationRequest pRequest);
  EmployeeEducation searchEmployeeEducation(RetailscmUserContext ctx, EmployeeEducationRequest pRequest);
	public EmployeeEducation createEmployeeEducation(RetailscmUserContext userContext, String employeeId,Date completeTime,String type,String remark) throws Exception;
	public EmployeeEducation updateEmployeeEducation(RetailscmUserContext userContext,String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeEducation loadEmployeeEducation(RetailscmUserContext userContext, String employeeEducationId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public EmployeeEducation internalSaveEmployeeEducation(RetailscmUserContext userContext, EmployeeEducation employeeEducation) throws Exception;
	public EmployeeEducation internalSaveEmployeeEducation(RetailscmUserContext userContext, EmployeeEducation employeeEducation,Map<String,Object>option) throws Exception;

	public EmployeeEducation transferToAnotherEmployee(RetailscmUserContext userContext, String employeeEducationId, String anotherEmployeeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String employeeEducationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeEducation newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, EmployeeEducation updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(RetailscmUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(RetailscmUserContext userContext,String employeeId, int start, int count) throws Exception;
  




}


