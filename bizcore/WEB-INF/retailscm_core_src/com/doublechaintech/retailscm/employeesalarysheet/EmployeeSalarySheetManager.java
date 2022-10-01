package com.doublechaintech.retailscm.employeesalarysheet;

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

public interface EmployeeSalarySheetManager extends BaseManager {

  List<EmployeeSalarySheet> searchEmployeeSalarySheetList(
      RetailscmUserContext ctx, EmployeeSalarySheetRequest pRequest);

  EmployeeSalarySheet searchEmployeeSalarySheet(
      RetailscmUserContext ctx, EmployeeSalarySheetRequest pRequest);

  public EmployeeSalarySheet createEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String employeeId,
      String currentSalaryGradeId,
      BigDecimal baseSalary,
      BigDecimal bonus,
      BigDecimal reward,
      BigDecimal personalTax,
      BigDecimal socialSecurity,
      BigDecimal housingFound,
      BigDecimal jobInsurance,
      String payingOffId)
      throws Exception;

  public EmployeeSalarySheet updateEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String employeeSalarySheetId,
      int employeeSalarySheetVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public EmployeeSalarySheet loadEmployeeSalarySheet(
      RetailscmUserContext userContext, String employeeSalarySheetId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public EmployeeSalarySheet internalSaveEmployeeSalarySheet(
      RetailscmUserContext userContext, EmployeeSalarySheet employeeSalarySheet) throws Exception;

  public EmployeeSalarySheet internalSaveEmployeeSalarySheet(
      RetailscmUserContext userContext,
      EmployeeSalarySheet employeeSalarySheet,
      Map<String, Object> option)
      throws Exception;

  public EmployeeSalarySheet transferToAnotherEmployee(
      RetailscmUserContext userContext, String employeeSalarySheetId, String anotherEmployeeId)
      throws Exception;

  public EmployeeSalarySheet transferToAnotherCurrentSalaryGrade(
      RetailscmUserContext userContext,
      String employeeSalarySheetId,
      String anotherCurrentSalaryGradeId)
      throws Exception;

  public EmployeeSalarySheet transferToAnotherPayingOff(
      RetailscmUserContext userContext, String employeeSalarySheetId, String anotherPayingOffId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeSalarySheet newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext,
      EmployeeSalarySheet updated,
      Object actor,
      String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByEmployee(RetailscmUserContext userContext, String employeeId)
      throws Exception;

  public Object listPageByEmployee(
      RetailscmUserContext userContext, String employeeId, int start, int count) throws Exception;

  public Object listByCurrentSalaryGrade(
      RetailscmUserContext userContext, String currentSalaryGradeId) throws Exception;

  public Object listPageByCurrentSalaryGrade(
      RetailscmUserContext userContext, String currentSalaryGradeId, int start, int count)
      throws Exception;

  public Object listByPayingOff(RetailscmUserContext userContext, String payingOffId)
      throws Exception;

  public Object listPageByPayingOff(
      RetailscmUserContext userContext, String payingOffId, int start, int count) throws Exception;
}
