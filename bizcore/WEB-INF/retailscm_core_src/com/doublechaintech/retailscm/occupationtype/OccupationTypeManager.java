package com.doublechaintech.retailscm.occupationtype;

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

public interface OccupationTypeManager extends BaseManager {

  List<OccupationType> searchOccupationTypeList(
      RetailscmUserContext ctx, OccupationTypeRequest pRequest);

  OccupationType searchOccupationType(RetailscmUserContext ctx, OccupationTypeRequest pRequest);

  public OccupationType createOccupationType(
      RetailscmUserContext userContext,
      String code,
      String companyId,
      String description,
      String detailDescription)
      throws Exception;

  public OccupationType updateOccupationType(
      RetailscmUserContext userContext,
      String occupationTypeId,
      int occupationTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public OccupationType loadOccupationType(
      RetailscmUserContext userContext, String occupationTypeId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public OccupationType internalSaveOccupationType(
      RetailscmUserContext userContext, OccupationType occupationType) throws Exception;

  public OccupationType internalSaveOccupationType(
      RetailscmUserContext userContext, OccupationType occupationType, Map<String, Object> option)
      throws Exception;

  public OccupationType transferToAnotherCompany(
      RetailscmUserContext userContext, String occupationTypeId, String anotherCompanyId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, OccupationType newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, OccupationType updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String
  // occupationTypeId, String companyId, String title, String departmentId, String familyName,
  // String givenName, String email, String city, String address, String cellPhone, String
  // responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)
  // throws Exception;

  public OccupationType addEmployee(
      RetailscmUserContext userContext,
      String occupationTypeId,
      String companyId,
      String title,
      String departmentId,
      String familyName,
      String givenName,
      String email,
      String city,
      String address,
      String cellPhone,
      String responsibleForId,
      String currentSalaryGradeId,
      String salaryAccount,
      String[] tokensExpr)
      throws Exception;

  public OccupationType removeEmployee(
      RetailscmUserContext userContext,
      String occupationTypeId,
      String employeeId,
      int employeeVersion,
      String[] tokensExpr)
      throws Exception;

  public OccupationType updateEmployee(
      RetailscmUserContext userContext,
      String occupationTypeId,
      String employeeId,
      int employeeVersion,
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
