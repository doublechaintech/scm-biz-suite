
package com.doublechaintech.retailscm.employeeperformance;
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




public interface EmployeePerformanceManager extends BaseManager{

		

  List<EmployeePerformance> searchEmployeePerformanceList(RetailscmUserContext ctx, EmployeePerformanceRequest pRequest);
  EmployeePerformance searchEmployeePerformance(RetailscmUserContext ctx, EmployeePerformanceRequest pRequest);
	public EmployeePerformance createEmployeePerformance(RetailscmUserContext userContext, String employeeId,String performanceComment) throws Exception;
	public EmployeePerformance updateEmployeePerformance(RetailscmUserContext userContext,String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeePerformance loadEmployeePerformance(RetailscmUserContext userContext, String employeePerformanceId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public EmployeePerformance internalSaveEmployeePerformance(RetailscmUserContext userContext, EmployeePerformance employeePerformance) throws Exception;
	public EmployeePerformance internalSaveEmployeePerformance(RetailscmUserContext userContext, EmployeePerformance employeePerformance,Map<String,Object>option) throws Exception;

	public EmployeePerformance transferToAnotherEmployee(RetailscmUserContext userContext, String employeePerformanceId, String anotherEmployeeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String employeePerformanceId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeePerformance newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, EmployeePerformance updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(RetailscmUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(RetailscmUserContext userContext,String employeeId, int start, int count) throws Exception;
  




}


