
package com.doublechaintech.retailscm.responsibilitytype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface ResponsibilityTypeManager extends BaseManager{

		

	public ResponsibilityType createResponsibilityType(RetailscmUserContext userContext, String code,String companyId,String baseDescription,String detailDescription) throws Exception;
	public ResponsibilityType updateResponsibilityType(RetailscmUserContext userContext,String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ResponsibilityType loadResponsibilityType(RetailscmUserContext userContext, String responsibilityTypeId, String [] tokensExpr) throws Exception;
	public ResponsibilityType internalSaveResponsibilityType(RetailscmUserContext userContext, ResponsibilityType responsibilityType) throws Exception;
	public ResponsibilityType internalSaveResponsibilityType(RetailscmUserContext userContext, ResponsibilityType responsibilityType,Map<String,Object>option) throws Exception;

	public ResponsibilityType transferToAnotherCompany(RetailscmUserContext userContext, String responsibilityTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String responsibilityTypeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ResponsibilityType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;

	public  ResponsibilityType addEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount , String [] tokensExpr)  throws Exception;
	public  ResponsibilityType removeEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  ResponsibilityType updateEmployee(RetailscmUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


