
package com.doublechaintech.retailscm.employeeskill;
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




public interface EmployeeSkillManager extends BaseManager{

		

  List<EmployeeSkill> searchEmployeeSkillList(RetailscmUserContext ctx, EmployeeSkillRequest pRequest);
  EmployeeSkill searchEmployeeSkill(RetailscmUserContext ctx, EmployeeSkillRequest pRequest);
	public EmployeeSkill createEmployeeSkill(RetailscmUserContext userContext, String employeeId,String skillTypeId,String description) throws Exception;
	public EmployeeSkill updateEmployeeSkill(RetailscmUserContext userContext,String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeSkill loadEmployeeSkill(RetailscmUserContext userContext, String employeeSkillId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public EmployeeSkill internalSaveEmployeeSkill(RetailscmUserContext userContext, EmployeeSkill employeeSkill) throws Exception;
	public EmployeeSkill internalSaveEmployeeSkill(RetailscmUserContext userContext, EmployeeSkill employeeSkill,Map<String,Object>option) throws Exception;

	public EmployeeSkill transferToAnotherEmployee(RetailscmUserContext userContext, String employeeSkillId, String anotherEmployeeId)  throws Exception;
 	public EmployeeSkill transferToAnotherSkillType(RetailscmUserContext userContext, String employeeSkillId, String anotherSkillTypeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String employeeSkillId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeSkill newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, EmployeeSkill updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(RetailscmUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(RetailscmUserContext userContext,String employeeId, int start, int count) throws Exception;
  
	public Object listBySkillType(RetailscmUserContext userContext,String skillTypeId) throws Exception;
	public Object listPageBySkillType(RetailscmUserContext userContext,String skillTypeId, int start, int count) throws Exception;
  




}


