
package com.doublechaintech.retailscm.employee;
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




public interface EmployeeManager extends BaseManager{

		

  List<Employee> searchEmployeeList(RetailscmUserContext ctx, EmployeeRequest pRequest);
  Employee searchEmployee(RetailscmUserContext ctx, EmployeeRequest pRequest);
	public Employee createEmployee(RetailscmUserContext userContext, String companyId,String title,String departmentId,String familyName,String givenName,String email,String city,String address,String cellPhone,String occupationId,String responsibleForId,String currentSalaryGradeId,String salaryAccount) throws Exception;
	public Employee updateEmployee(RetailscmUserContext userContext,String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Employee loadEmployee(RetailscmUserContext userContext, String employeeId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public Employee internalSaveEmployee(RetailscmUserContext userContext, Employee employee) throws Exception;
	public Employee internalSaveEmployee(RetailscmUserContext userContext, Employee employee,Map<String,Object>option) throws Exception;

	public Employee transferToAnotherCompany(RetailscmUserContext userContext, String employeeId, String anotherCompanyId)  throws Exception;
 	public Employee transferToAnotherDepartment(RetailscmUserContext userContext, String employeeId, String anotherDepartmentId)  throws Exception;
 	public Employee transferToAnotherOccupation(RetailscmUserContext userContext, String employeeId, String anotherOccupationId)  throws Exception;
 	public Employee transferToAnotherResponsibleFor(RetailscmUserContext userContext, String employeeId, String anotherResponsibleForId)  throws Exception;
 	public Employee transferToAnotherCurrentSalaryGrade(RetailscmUserContext userContext, String employeeId, String anotherCurrentSalaryGradeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String employeeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, Employee newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, Employee updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeCompanyTrainingManager getEmployeeCompanyTrainingManager(RetailscmUserContext userContext, String employeeId, String trainingId, String scoringId ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, String trainingId, String scoringId , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeSkillManager getEmployeeSkillManager(RetailscmUserContext userContext, String employeeId, String skillTypeId, String description ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeSkill(RetailscmUserContext userContext, String employeeId, String skillTypeId, String description , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeSkill(RetailscmUserContext userContext, String employeeId, String employeeSkillId, int employeeSkillVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeSkill(RetailscmUserContext userContext, String employeeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeePerformanceManager getEmployeePerformanceManager(RetailscmUserContext userContext, String employeeId, String performanceComment ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeePerformance(RetailscmUserContext userContext, String employeeId, String performanceComment , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeePerformance(RetailscmUserContext userContext, String employeeId, String employeePerformanceId, int employeePerformanceVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeePerformance(RetailscmUserContext userContext, String employeeId, String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeWorkExperienceManager getEmployeeWorkExperienceManager(RetailscmUserContext userContext, String employeeId, Date start, Date end, String company, String description ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId, Date start, Date end, String company, String description , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId, String employeeWorkExperienceId, int employeeWorkExperienceVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId, String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeLeaveManager getEmployeeLeaveManager(RetailscmUserContext userContext, String employeeId, String typeId, int leaveDurationHour, String remark ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeLeave(RetailscmUserContext userContext, String employeeId, String typeId, int leaveDurationHour, String remark , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeLeave(RetailscmUserContext userContext, String employeeId, String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeLeave(RetailscmUserContext userContext, String employeeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeInterviewManager getEmployeeInterviewManager(RetailscmUserContext userContext, String employeeId, String interviewTypeId, String remark ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeInterview(RetailscmUserContext userContext, String employeeId, String interviewTypeId, String remark , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeInterview(RetailscmUserContext userContext, String employeeId, String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeInterview(RetailscmUserContext userContext, String employeeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeAttendanceManager getEmployeeAttendanceManager(RetailscmUserContext userContext, String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeAttendance(RetailscmUserContext userContext, String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeAttendance(RetailscmUserContext userContext, String employeeId, String employeeAttendanceId, int employeeAttendanceVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeAttendance(RetailscmUserContext userContext, String employeeId, String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeQualifierManager getEmployeeQualifierManager(RetailscmUserContext userContext, String employeeId, Date qualifiedTime, String type, String level, String remark ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeQualifier(RetailscmUserContext userContext, String employeeId, Date qualifiedTime, String type, String level, String remark , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeQualifier(RetailscmUserContext userContext, String employeeId, String employeeQualifierId, int employeeQualifierVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeQualifier(RetailscmUserContext userContext, String employeeId, String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeEducationManager getEmployeeEducationManager(RetailscmUserContext userContext, String employeeId, Date completeTime, String type, String remark ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeEducation(RetailscmUserContext userContext, String employeeId, Date completeTime, String type, String remark , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeEducation(RetailscmUserContext userContext, String employeeId, String employeeEducationId, int employeeEducationVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeEducation(RetailscmUserContext userContext, String employeeId, String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeAwardManager getEmployeeAwardManager(RetailscmUserContext userContext, String employeeId, Date completeTime, String type, String remark ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeAward(RetailscmUserContext userContext, String employeeId, Date completeTime, String type, String remark , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeAward(RetailscmUserContext userContext, String employeeId, String employeeAwardId, int employeeAwardVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeAward(RetailscmUserContext userContext, String employeeId, String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeSalarySheetManager getEmployeeSalarySheetManager(RetailscmUserContext userContext, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String payingOffId ,String [] tokensExpr)  throws Exception;

	public  Employee addEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance, String payingOffId , String [] tokensExpr)  throws Exception;
	public  Employee removeEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr)  throws Exception;
	public  Employee updateEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PayingOffManager getPayingOffManager(RetailscmUserContext userContext, String employeeId, String who, Date paidTime, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  Employee addPayingOff(RetailscmUserContext userContext, String employeeId, String who, Date paidTime, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  Employee removePayingOff(RetailscmUserContext userContext, String employeeId, String payingOffId, int payingOffVersion,String [] tokensExpr)  throws Exception;
	public  Employee updatePayingOff(RetailscmUserContext userContext, String employeeId, String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception;
  
	public Object listByDepartment(RetailscmUserContext userContext,String departmentId) throws Exception;
	public Object listPageByDepartment(RetailscmUserContext userContext,String departmentId, int start, int count) throws Exception;
  
	public Object listByOccupation(RetailscmUserContext userContext,String occupationId) throws Exception;
	public Object listPageByOccupation(RetailscmUserContext userContext,String occupationId, int start, int count) throws Exception;
  
	public Object listByResponsibleFor(RetailscmUserContext userContext,String responsibleForId) throws Exception;
	public Object listPageByResponsibleFor(RetailscmUserContext userContext,String responsibleForId, int start, int count) throws Exception;
  
	public Object listByCurrentSalaryGrade(RetailscmUserContext userContext,String currentSalaryGradeId) throws Exception;
	public Object listPageByCurrentSalaryGrade(RetailscmUserContext userContext,String currentSalaryGradeId, int start, int count) throws Exception;
  




}


