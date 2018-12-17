
package com.doublechaintech.retailscm.employeeskill;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface EmployeeSkillManager{

		

	public EmployeeSkill createEmployeeSkill(RetailscmUserContext userContext, String employeeId, String skillTypeId, String description) throws Exception;	
	public EmployeeSkill updateEmployeeSkill(RetailscmUserContext userContext,String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeSkill loadEmployeeSkill(RetailscmUserContext userContext, String employeeSkillId, String [] tokensExpr) throws Exception;
	public EmployeeSkill internalSaveEmployeeSkill(RetailscmUserContext userContext, EmployeeSkill employeeSkill) throws Exception;
	public EmployeeSkill internalSaveEmployeeSkill(RetailscmUserContext userContext, EmployeeSkill employeeSkill,Map<String,Object>option) throws Exception;
	
	public EmployeeSkill transferToAnotherEmployee(RetailscmUserContext userContext, String employeeSkillId, String anotherEmployeeId)  throws Exception;
 	public EmployeeSkill transferToAnotherSkillType(RetailscmUserContext userContext, String employeeSkillId, String anotherSkillTypeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String employeeSkillId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeSkill newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


