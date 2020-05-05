
package com.doublechaintech.retailscm.skilltype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SkillTypeManager extends BaseManager{

		

	public SkillType createSkillType(RetailscmUserContext userContext, String code,String companyId,String description) throws Exception;
	public SkillType updateSkillType(RetailscmUserContext userContext,String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SkillType loadSkillType(RetailscmUserContext userContext, String skillTypeId, String [] tokensExpr) throws Exception;
	public SkillType internalSaveSkillType(RetailscmUserContext userContext, SkillType skillType) throws Exception;
	public SkillType internalSaveSkillType(RetailscmUserContext userContext, SkillType skillType,Map<String,Object>option) throws Exception;

	public SkillType transferToAnotherCompany(RetailscmUserContext userContext, String skillTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String skillTypeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SkillType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeSkillManager getEmployeeSkillManager(RetailscmUserContext userContext, String skillTypeId, String employeeId, String description ,String [] tokensExpr)  throws Exception;

	public  SkillType addEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, String employeeId, String description , String [] tokensExpr)  throws Exception;
	public  SkillType removeEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, String employeeSkillId, int employeeSkillVersion,String [] tokensExpr)  throws Exception;
	public  SkillType updateEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


