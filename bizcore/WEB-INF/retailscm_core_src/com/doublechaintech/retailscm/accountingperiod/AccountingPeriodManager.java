package com.doublechaintech.retailscm.accountingperiod;

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

public interface AccountingPeriodManager extends BaseManager {

  List<AccountingPeriod> searchAccountingPeriodList(
      RetailscmUserContext ctx, AccountingPeriodRequest pRequest);

  AccountingPeriod searchAccountingPeriod(
      RetailscmUserContext ctx, AccountingPeriodRequest pRequest);

  public AccountingPeriod createAccountingPeriod(
      RetailscmUserContext userContext,
      String name,
      Date startDate,
      Date endDate,
      String accountSetId)
      throws Exception;

  public AccountingPeriod updateAccountingPeriod(
      RetailscmUserContext userContext,
      String accountingPeriodId,
      int accountingPeriodVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public AccountingPeriod loadAccountingPeriod(
      RetailscmUserContext userContext, String accountingPeriodId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public AccountingPeriod internalSaveAccountingPeriod(
      RetailscmUserContext userContext, AccountingPeriod accountingPeriod) throws Exception;

  public AccountingPeriod internalSaveAccountingPeriod(
      RetailscmUserContext userContext,
      AccountingPeriod accountingPeriod,
      Map<String, Object> option)
      throws Exception;

  public AccountingPeriod transferToAnotherAccountSet(
      RetailscmUserContext userContext, String accountingPeriodId, String anotherAccountSetId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, AccountingPeriod newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, AccountingPeriod updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  AccountingDocumentManager getAccountingDocumentManager(RetailscmUserContext
  // userContext, String accountingPeriodId, String name, Date accountingDocumentDate, String
  // documentTypeId ,String [] tokensExpr)  throws Exception;

  public AccountingPeriod addAccountingDocument(
      RetailscmUserContext userContext,
      String accountingPeriodId,
      String name,
      Date accountingDocumentDate,
      String documentTypeId,
      String[] tokensExpr)
      throws Exception;

  public AccountingPeriod removeAccountingDocument(
      RetailscmUserContext userContext,
      String accountingPeriodId,
      String accountingDocumentId,
      int accountingDocumentVersion,
      String[] tokensExpr)
      throws Exception;

  public AccountingPeriod updateAccountingDocument(
      RetailscmUserContext userContext,
      String accountingPeriodId,
      String accountingDocumentId,
      int accountingDocumentVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  public Object listByAccountSet(RetailscmUserContext userContext, String accountSetId)
      throws Exception;

  public Object listPageByAccountSet(
      RetailscmUserContext userContext, String accountSetId, int start, int count) throws Exception;
}
