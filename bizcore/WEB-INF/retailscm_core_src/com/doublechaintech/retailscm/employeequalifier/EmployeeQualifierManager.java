
package com.doublechaintech.retailscm.employeequalifier;
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




public interface EmployeeQualifierManager extends BaseManager{

		

  List<EmployeeQualifier> searchEmployeeQualifierList(RetailscmUserContext ctx, EmployeeQualifierRequest pRequest);
  EmployeeQualifier searchEmployeeQualifier(RetailscmUserContext ctx, EmployeeQualifierRequest pRequest);
	public EmployeeQualifier createEmployeeQualifier(RetailscmUserContext userContext, String employeeId,Date qualifiedTime,String type,String level,String remark) throws Exception;
	public EmployeeQualifier updateEmployeeQualifier(RetailscmUserContext userContext,String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeQualifier loadEmployeeQualifier(RetailscmUserContext userContext, String employeeQualifierId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public EmployeeQualifier internalSaveEmployeeQualifier(RetailscmUserContext userContext, EmployeeQualifier employeeQualifier) throws Exception;
	public EmployeeQualifier internalSaveEmployeeQualifier(RetailscmUserContext userContext, EmployeeQualifier employeeQualifier,Map<String,Object>option) throws Exception;

	public EmployeeQualifier transferToAnotherEmployee(RetailscmUserContext userContext, String employeeQualifierId, String anotherEmployeeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String employeeQualifierId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeQualifier newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, EmployeeQualifier updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(RetailscmUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(RetailscmUserContext userContext,String employeeId, int start, int count) throws Exception;
  




}


