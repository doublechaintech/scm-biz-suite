package com.doublechaintech.retailscm.accountingdocumentline;

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

public interface AccountingDocumentLineManager extends BaseManager {

  List<AccountingDocumentLine> searchAccountingDocumentLineList(
      RetailscmUserContext ctx, AccountingDocumentLineRequest pRequest);

  AccountingDocumentLine searchAccountingDocumentLine(
      RetailscmUserContext ctx, AccountingDocumentLineRequest pRequest);

  public AccountingDocumentLine createAccountingDocumentLine(
      RetailscmUserContext userContext,
      String name,
      String code,
      String direct,
      BigDecimal amount,
      String belongsToId,
      String accountingSubjectId)
      throws Exception;

  public AccountingDocumentLine updateAccountingDocumentLine(
      RetailscmUserContext userContext,
      String accountingDocumentLineId,
      int accountingDocumentLineVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public AccountingDocumentLine loadAccountingDocumentLine(
      RetailscmUserContext userContext, String accountingDocumentLineId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public AccountingDocumentLine internalSaveAccountingDocumentLine(
      RetailscmUserContext userContext, AccountingDocumentLine accountingDocumentLine)
      throws Exception;

  public AccountingDocumentLine internalSaveAccountingDocumentLine(
      RetailscmUserContext userContext,
      AccountingDocumentLine accountingDocumentLine,
      Map<String, Object> option)
      throws Exception;

  public AccountingDocumentLine transferToAnotherBelongsTo(
      RetailscmUserContext userContext, String accountingDocumentLineId, String anotherBelongsToId)
      throws Exception;

  public AccountingDocumentLine transferToAnotherAccountingSubject(
      RetailscmUserContext userContext,
      String accountingDocumentLineId,
      String anotherAccountingSubjectId)
      throws Exception;

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, AccountingDocumentLine newCreated) throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext,
      AccountingDocumentLine updated,
      Object actor,
      String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByBelongsTo(RetailscmUserContext userContext, String belongsToId)
      throws Exception;

  public Object listPageByBelongsTo(
      RetailscmUserContext userContext, String belongsToId, int start, int count) throws Exception;

  public Object listByAccountingSubject(
      RetailscmUserContext userContext, String accountingSubjectId) throws Exception;

  public Object listPageByAccountingSubject(
      RetailscmUserContext userContext, String accountingSubjectId, int start, int count)
      throws Exception;
}
