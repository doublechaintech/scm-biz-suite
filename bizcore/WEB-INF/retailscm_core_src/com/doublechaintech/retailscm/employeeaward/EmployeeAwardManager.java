
package com.doublechaintech.retailscm.employeeaward;
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




public interface EmployeeAwardManager extends BaseManager{

		

  List<EmployeeAward> searchEmployeeAwardList(RetailscmUserContext ctx, EmployeeAwardRequest pRequest);
  EmployeeAward searchEmployeeAward(RetailscmUserContext ctx, EmployeeAwardRequest pRequest);
	public EmployeeAward createEmployeeAward(RetailscmUserContext userContext, String employeeId,Date completeTime,String type,String remark) throws Exception;
	public EmployeeAward updateEmployeeAward(RetailscmUserContext userContext,String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeAward loadEmployeeAward(RetailscmUserContext userContext, String employeeAwardId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public EmployeeAward internalSaveEmployeeAward(RetailscmUserContext userContext, EmployeeAward employeeAward) throws Exception;
	public EmployeeAward internalSaveEmployeeAward(RetailscmUserContext userContext, EmployeeAward employeeAward,Map<String,Object>option) throws Exception;

	public EmployeeAward transferToAnotherEmployee(RetailscmUserContext userContext, String employeeAwardId, String anotherEmployeeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String employeeAwardId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeAward newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, EmployeeAward updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(RetailscmUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(RetailscmUserContext userContext,String employeeId, int start, int count) throws Exception;
  




}


