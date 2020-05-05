
package com.doublechaintech.retailscm.employeeworkexperience;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface EmployeeWorkExperienceManager extends BaseManager{

		

	public EmployeeWorkExperience createEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId,Date start,Date end,String company,String description) throws Exception;
	public EmployeeWorkExperience updateEmployeeWorkExperience(RetailscmUserContext userContext,String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EmployeeWorkExperience loadEmployeeWorkExperience(RetailscmUserContext userContext, String employeeWorkExperienceId, String [] tokensExpr) throws Exception;
	public EmployeeWorkExperience internalSaveEmployeeWorkExperience(RetailscmUserContext userContext, EmployeeWorkExperience employeeWorkExperience) throws Exception;
	public EmployeeWorkExperience internalSaveEmployeeWorkExperience(RetailscmUserContext userContext, EmployeeWorkExperience employeeWorkExperience,Map<String,Object>option) throws Exception;

	public EmployeeWorkExperience transferToAnotherEmployee(RetailscmUserContext userContext, String employeeWorkExperienceId, String anotherEmployeeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String employeeWorkExperienceId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeWorkExperience newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByEmployee(RetailscmUserContext userContext,String employeeId) throws Exception;
	public Object listPageByEmployee(RetailscmUserContext userContext,String employeeId, int start, int count) throws Exception;
  

}


