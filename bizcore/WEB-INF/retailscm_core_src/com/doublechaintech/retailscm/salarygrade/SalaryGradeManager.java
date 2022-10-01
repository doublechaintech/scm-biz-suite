package com.doublechaintech.retailscm.salarygrade;

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

public interface SalaryGradeManager extends BaseManager {

  List<SalaryGrade> searchSalaryGradeList(RetailscmUserContext ctx, SalaryGradeRequest pRequest);

  SalaryGrade searchSalaryGrade(RetailscmUserContext ctx, SalaryGradeRequest pRequest);

  public SalaryGrade createSalaryGrade(
      RetailscmUserContext userContext,
      String code,
      String companyId,
      String name,
      String detailDescription)
      throws Exception;

  public SalaryGrade updateSalaryGrade(
      RetailscmUserContext userContext,
      String salaryGradeId,
      int salaryGradeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public SalaryGrade loadSalaryGrade(
      RetailscmUserContext userContext, String salaryGradeId, String[] tokensExpr) throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public SalaryGrade internalSaveSalaryGrade(
      RetailscmUserContext userContext, SalaryGrade salaryGrade) throws Exception;

  public SalaryGrade internalSaveSalaryGrade(
      RetailscmUserContext userContext, SalaryGrade salaryGrade, Map<String, Object> option)
      throws Exception;

  public SalaryGrade transferToAnotherCompany(
      RetailscmUserContext userContext, String salaryGradeId, String anotherCompanyId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, SalaryGrade newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, SalaryGrade updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String
  // salaryGradeId, String companyId, String title, String departmentId, String familyName, String
  // givenName, String email, String city, String address, String cellPhone, String occupationId,
  // String responsibleForId, String salaryAccount ,String [] tokensExpr)  throws Exception;

  public SalaryGrade addEmployee(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String companyId,
      String title,
      String departmentId,
      String familyName,
      String givenName,
      String email,
      String city,
      String address,
      String cellPhone,
      String occupationId,
      String responsibleForId,
      String salaryAccount,
      String[] tokensExpr)
      throws Exception;

  public SalaryGrade removeEmployee(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeId,
      int employeeVersion,
      String[] tokensExpr)
      throws Exception;

  public SalaryGrade updateEmployee(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeId,
      int employeeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  // public  EmployeeSalarySheetManager getEmployeeSalarySheetManager(RetailscmUserContext
  // userContext, String salaryGradeId, String employeeId, BigDecimal baseSalary, BigDecimal bonus,
  // BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound,
  // BigDecimal jobInsurance, String payingOffId ,String [] tokensExpr)  throws Exception;

  public SalaryGrade addEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeId,
      BigDecimal baseSalary,
      BigDecimal bonus,
      BigDecimal reward,
      BigDecimal personalTax,
      BigDecimal socialSecurity,
      BigDecimal housingFound,
      BigDecimal jobInsurance,
      String payingOffId,
      String[] tokensExpr)
      throws Exception;

  public SalaryGrade removeEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeSalarySheetId,
      int employeeSalarySheetVersion,
      String[] tokensExpr)
      throws Exception;

  public SalaryGrade updateEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String salaryGradeId,
      String employeeSalarySheetId,
      int employeeSalarySheetVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  public Object listByCompany(RetailscmUserContext userContext, String companyId) throws Exception;

  public Object listPageByCompany(
      RetailscmUserContext userContext, String companyId, int start, int count) throws Exception;
}
