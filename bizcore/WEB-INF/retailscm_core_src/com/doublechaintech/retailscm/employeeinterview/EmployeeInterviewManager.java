package com.doublechaintech.retailscm.employeeinterview;

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

public interface EmployeeInterviewManager extends BaseManager {

  List<EmployeeInterview> searchEmployeeInterviewList(
      RetailscmUserContext ctx, EmployeeInterviewRequest pRequest);

  EmployeeInterview searchEmployeeInterview(
      RetailscmUserContext ctx, EmployeeInterviewRequest pRequest);

  public EmployeeInterview createEmployeeInterview(
      RetailscmUserContext userContext, String employeeId, String interviewTypeId, String remark)
      throws Exception;

  public EmployeeInterview updateEmployeeInterview(
      RetailscmUserContext userContext,
      String employeeInterviewId,
      int employeeInterviewVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public EmployeeInterview loadEmployeeInterview(
      RetailscmUserContext userContext, String employeeInterviewId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public EmployeeInterview internalSaveEmployeeInterview(
      RetailscmUserContext userContext, EmployeeInterview employeeInterview) throws Exception;

  public EmployeeInterview internalSaveEmployeeInterview(
      RetailscmUserContext userContext,
      EmployeeInterview employeeInterview,
      Map<String, Object> option)
      throws Exception;

  public EmployeeInterview transferToAnotherEmployee(
      RetailscmUserContext userContext, String employeeInterviewId, String anotherEmployeeId)
      throws Exception;

  public EmployeeInterview transferToAnotherInterviewType(
      RetailscmUserContext userContext, String employeeInterviewId, String anotherInterviewTypeId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, EmployeeInterview newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, EmployeeInterview updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByEmployee(RetailscmUserContext userContext, String employeeId)
      throws Exception;

  public Object listPageByEmployee(
      RetailscmUserContext userContext, String employeeId, int start, int count) throws Exception;

  public Object listByInterviewType(RetailscmUserContext userContext, String interviewTypeId)
      throws Exception;

  public Object listPageByInterviewType(
      RetailscmUserContext userContext, String interviewTypeId, int start, int count)
      throws Exception;
}
