package com.doublechaintech.retailscm.payingoff;

import com.doublechaintech.retailscm.Beans;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.retailscm.RetailscmBaseDAOImpl;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;

import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class PayingOffJDBCTemplateDAO extends RetailscmBaseDAOImpl implements PayingOffDAO {

  protected EmployeeDAO employeeDAO;

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {

    if (employeeDAO == null) {
      throw new IllegalStateException("Do not try to set employeeDAO to null.");
    }
    this.employeeDAO = employeeDAO;
  }

  public EmployeeDAO getEmployeeDAO() {
    if (this.employeeDAO == null) {
      throw new IllegalStateException(
          "The employeeDAO is not configured yet, please config it some where.");
    }

    return this.employeeDAO;
  }

  protected EmployeeSalarySheetDAO employeeSalarySheetDAO;

  public void setEmployeeSalarySheetDAO(EmployeeSalarySheetDAO employeeSalarySheetDAO) {

    if (employeeSalarySheetDAO == null) {
      throw new IllegalStateException("Do not try to set employeeSalarySheetDAO to null.");
    }
    this.employeeSalarySheetDAO = employeeSalarySheetDAO;
  }

  public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO() {
    if (this.employeeSalarySheetDAO == null) {
      throw new IllegalStateException(
          "The employeeSalarySheetDAO is not configured yet, please config it some where.");
    }

    return this.employeeSalarySheetDAO;
  }

  /*
  protected PayingOff load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalPayingOff(accessKey, options);
  }
  */

  public SmartList<PayingOff> loadAll() {
    return this.loadAll(getPayingOffMapper());
  }

  public Stream<PayingOff> loadAllAsStream() {
    return this.loadAllAsStream(getPayingOffMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public PayingOff load(String id, Map<String, Object> options) throws Exception {
    return loadInternalPayingOff(PayingOffTable.withId(id), options);
  }

  public PayingOff save(PayingOff payingOff, Map<String, Object> options) {

    String methodName = "save(PayingOff payingOff,Map<String,Object> options)";

    assertMethodArgumentNotNull(payingOff, methodName, "payingOff");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalPayingOff(payingOff, options);
  }

  public PayingOff clone(String payingOffId, Map<String, Object> options) throws Exception {

    return clone(PayingOffTable.withId(payingOffId), options);
  }

  protected PayingOff clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String payingOffId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    PayingOff newPayingOff = loadInternalPayingOff(accessKey, options);
    newPayingOff.setVersion(0);

    if (isSaveEmployeeSalarySheetListEnabled(options)) {
      for (EmployeeSalarySheet item : newPayingOff.getEmployeeSalarySheetList()) {
        item.setVersion(0);
      }
    }

    saveInternalPayingOff(newPayingOff, options);

    return newPayingOff;
  }

  protected void throwIfHasException(String payingOffId, int version, int count) throws Exception {
    if (count == 1) {
      throw new PayingOffVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new PayingOffNotFoundException(
          "The " + this.getTableName() + "(" + payingOffId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public PayingOff disconnectFromAll(String payingOffId, int version) throws Exception {

    PayingOff payingOff = loadInternalPayingOff(PayingOffTable.withId(payingOffId), emptyOptions());
    payingOff.clearFromAll();
    this.savePayingOff(payingOff);
    return payingOff;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return PayingOffTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "paying_off";
  }

  @Override
  protected String getBeanName() {

    return "payingOff";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return PayingOffTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractPaidForEnabled(Map<String, Object> options) {

    return checkOptions(options, PayingOffTokens.PAIDFOR);
  }

  protected boolean isSavePaidForEnabled(Map<String, Object> options) {

    return checkOptions(options, PayingOffTokens.PAIDFOR);
  }

  protected boolean isExtractEmployeeSalarySheetListEnabled(Map<String, Object> options) {
    return checkOptions(options, PayingOffTokens.EMPLOYEE_SALARY_SHEET_LIST);
  }

  protected boolean isAnalyzeEmployeeSalarySheetListEnabled(Map<String, Object> options) {
    return PayingOffTokens.of(options).analyzeEmployeeSalarySheetListEnabled();
  }

  protected boolean isSaveEmployeeSalarySheetListEnabled(Map<String, Object> options) {
    return checkOptions(options, PayingOffTokens.EMPLOYEE_SALARY_SHEET_LIST);
  }

  protected PayingOffMapper getPayingOffMapper() {
    return new PayingOffMapper();
  }

  protected PayingOff extractPayingOff(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      PayingOff payingOff = loadSingleObject(accessKey, getPayingOffMapper());
      return payingOff;
    } catch (EmptyResultDataAccessException e) {
      throw new PayingOffNotFoundException("PayingOff(" + accessKey + ") is not found!");
    }
  }

  protected PayingOff loadInternalPayingOff(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {

    PayingOff payingOff = extractPayingOff(accessKey, loadOptions);

    if (isExtractPaidForEnabled(loadOptions)) {
      extractPaidFor(payingOff, loadOptions);
    }

    if (isExtractEmployeeSalarySheetListEnabled(loadOptions)) {
      extractEmployeeSalarySheetList(payingOff, loadOptions);
    }

    if (isAnalyzeEmployeeSalarySheetListEnabled(loadOptions)) {
      analyzeEmployeeSalarySheetList(payingOff, loadOptions);
    }

    return payingOff;
  }

  protected PayingOff extractPaidFor(PayingOff payingOff, Map<String, Object> options)
      throws Exception {

    if (payingOff.getPaidFor() == null) {
      return payingOff;
    }
    String paidForId = payingOff.getPaidFor().getId();
    if (paidForId == null) {
      return payingOff;
    }
    Employee paidFor = getEmployeeDAO().load(paidForId, options);
    if (paidFor != null) {
      payingOff.setPaidFor(paidFor);
    }

    return payingOff;
  }

  protected void enhanceEmployeeSalarySheetList(
      SmartList<EmployeeSalarySheet> employeeSalarySheetList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected PayingOff extractEmployeeSalarySheetList(
      PayingOff payingOff, Map<String, Object> options) {

    if (payingOff == null) {
      return null;
    }
    if (payingOff.getId() == null) {
      return payingOff;
    }

    SmartList<EmployeeSalarySheet> employeeSalarySheetList =
        getEmployeeSalarySheetDAO().findEmployeeSalarySheetByPayingOff(payingOff.getId(), options);
    if (employeeSalarySheetList != null) {
      enhanceEmployeeSalarySheetList(employeeSalarySheetList, options);
      payingOff.setEmployeeSalarySheetList(employeeSalarySheetList);
    }

    return payingOff;
  }

  protected PayingOff analyzeEmployeeSalarySheetList(
      PayingOff payingOff, Map<String, Object> options) {

    if (payingOff == null) {
      return null;
    }
    if (payingOff.getId() == null) {
      return payingOff;
    }

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = payingOff.getEmployeeSalarySheetList();
    if (employeeSalarySheetList != null) {
      getEmployeeSalarySheetDAO()
          .analyzeEmployeeSalarySheetByPayingOff(
              employeeSalarySheetList, payingOff.getId(), options);
    }

    return payingOff;
  }

  public SmartList<PayingOff> findPayingOffByPaidFor(
      String employeeId, Map<String, Object> options) {

    SmartList<PayingOff> resultList =
        queryWith(PayingOffTable.COLUMN_PAID_FOR, employeeId, options, getPayingOffMapper());
    // analyzePayingOffByPaidFor(resultList, employeeId, options);
    return resultList;
  }

  public SmartList<PayingOff> findPayingOffByPaidFor(
      String employeeId, int start, int count, Map<String, Object> options) {

    SmartList<PayingOff> resultList =
        queryWithRange(
            PayingOffTable.COLUMN_PAID_FOR,
            employeeId,
            options,
            getPayingOffMapper(),
            start,
            count);
    // analyzePayingOffByPaidFor(resultList, employeeId, options);
    return resultList;
  }

  public void analyzePayingOffByPaidFor(
      SmartList<PayingOff> resultList, String employeeId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countPayingOffByPaidFor(String employeeId, Map<String, Object> options) {

    return countWith(PayingOffTable.COLUMN_PAID_FOR, employeeId, options);
  }

  @Override
  public Map<String, Integer> countPayingOffByPaidForIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(PayingOffTable.COLUMN_PAID_FOR, ids, options);
  }

  protected PayingOff savePayingOff(PayingOff payingOff) {

    if (!payingOff.isChanged()) {
      return payingOff;
    }

    Beans.dbUtil().cacheCleanUp(payingOff);
    String SQL = this.getSavePayingOffSQL(payingOff);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSavePayingOffParameters(payingOff);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    payingOff.incVersion();
    payingOff.afterSave();
    return payingOff;
  }

  public SmartList<PayingOff> savePayingOffList(
      SmartList<PayingOff> payingOffList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitPayingOffList(payingOffList);

    batchPayingOffCreate((List<PayingOff>) lists[CREATE_LIST_INDEX]);
    batchPayingOffUpdate((List<PayingOff>) lists[UPDATE_LIST_INDEX]);
    batchPayingOffRemove((List<PayingOff>) lists[REMOVE_LIST_INDEX]);
    batchPayingOffRecover((List<PayingOff>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (PayingOff payingOff : payingOffList) {
      if (payingOff.isChanged()) {
        payingOff.incVersion();
        payingOff.afterSave();
      }
      if (payingOff.isToRecover() || payingOff.isToRemove()) {
        payingOff.setVersion(-payingOff.getVersion());
      }
    }

    return payingOffList;
  }

  public SmartList<PayingOff> removePayingOffList(
      SmartList<PayingOff> payingOffList, Map<String, Object> options) {

    super.removeList(payingOffList, options);

    return payingOffList;
  }

  protected List<Object[]> preparePayingOffBatchCreateArgs(List<PayingOff> payingOffList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PayingOff payingOff : payingOffList) {
      Object[] parameters = preparePayingOffCreateParameters(payingOff);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> preparePayingOffBatchUpdateArgs(List<PayingOff> payingOffList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PayingOff payingOff : payingOffList) {
      if (!payingOff.isChanged()) {
        continue;
      }
      Object[] parameters = preparePayingOffUpdateParameters(payingOff);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> preparePayingOffBatchRecoverArgs(List<PayingOff> payingOffList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PayingOff payingOff : payingOffList) {
      if (!payingOff.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(payingOff);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> preparePayingOffBatchRemoveArgs(List<PayingOff> payingOffList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PayingOff payingOff : payingOffList) {
      if (!payingOff.isToRemove()) {
        continue;
      }
      Object[] parameters = preparePayingOffRemoveParameters(payingOff);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchPayingOffCreate(List<PayingOff> payingOffList) {
    String SQL = getCreateSQL();
    List<Object[]> args = preparePayingOffBatchCreateArgs(payingOffList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchPayingOffUpdate(List<PayingOff> payingOffList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = preparePayingOffBatchUpdateArgs(payingOffList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchPayingOffRemove(List<PayingOff> payingOffList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = preparePayingOffBatchRemoveArgs(payingOffList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchPayingOffRecover(List<PayingOff> payingOffList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = preparePayingOffBatchRecoverArgs(payingOffList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitPayingOffList(List<PayingOff> payingOffList) {

    List<PayingOff> payingOffCreateList = new ArrayList<PayingOff>();
    List<PayingOff> payingOffUpdateList = new ArrayList<PayingOff>();
    List<PayingOff> payingOffRemoveList = new ArrayList<PayingOff>();
    List<PayingOff> payingOffRecoverList = new ArrayList<PayingOff>();

    for (PayingOff payingOff : payingOffList) {
      if (payingOff.isToRemove()) {
        payingOffRemoveList.add(payingOff);
        continue;
      }
      if (payingOff.isToRecover()) {
        payingOffRecoverList.add(payingOff);
        continue;
      }
      if (isUpdateRequest(payingOff)) {
        if (payingOff.isChanged()) {
          payingOffUpdateList.add(payingOff);
        }
        continue;
      }

      if (payingOff.isChanged()) {
        payingOffCreateList.add(payingOff);
      }
    }

    return new Object[] {
      payingOffCreateList, payingOffUpdateList, payingOffRemoveList, payingOffRecoverList
    };
  }

  protected boolean isUpdateRequest(PayingOff payingOff) {
    return payingOff.getVersion() > 0;
  }

  protected String getSavePayingOffSQL(PayingOff payingOff) {
    if (payingOff.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(payingOff)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSavePayingOffParameters(PayingOff payingOff) {
    if (payingOff.isToRemove()) {
      return preparePayingOffRemoveParameters(payingOff);
    }
    if (payingOff.isToRecover()) {
      return prepareRecoverParameters(payingOff);
    }

    if (isUpdateRequest(payingOff)) {
      return preparePayingOffUpdateParameters(payingOff);
    }
    return preparePayingOffCreateParameters(payingOff);
  }

  protected Object[] preparePayingOffRemoveParameters(PayingOff payingOff) {
    return super.prepareRemoveParameters(payingOff);
  }

  protected Object[] preparePayingOffUpdateParameters(PayingOff payingOff) {
    Object[] parameters = new Object[7];

    parameters[0] = payingOff.getWho();

    if (payingOff.getPaidFor() != null) {
      parameters[1] = payingOff.getPaidFor().getId();
    }

    parameters[2] = payingOff.getPaidTime();

    parameters[3] = payingOff.getAmount();

    parameters[4] = payingOff.nextVersion();
    parameters[5] = payingOff.getId();
    parameters[6] = payingOff.getVersion();

    return parameters;
  }

  protected Object[] preparePayingOffCreateParameters(PayingOff payingOff) {
    Object[] parameters = new Object[5];
    if (payingOff.getId() == null) {
      String newPayingOffId = getNextId();
      payingOff.setId(newPayingOffId);
    }
    parameters[0] = payingOff.getId();

    parameters[1] = payingOff.getWho();

    if (payingOff.getPaidFor() != null) {
      parameters[2] = payingOff.getPaidFor().getId();
    }

    parameters[3] = payingOff.getPaidTime();

    parameters[4] = payingOff.getAmount();

    return parameters;
  }

  protected PayingOff saveInternalPayingOff(PayingOff payingOff, Map<String, Object> options) {

    if (isSavePaidForEnabled(options)) {
      savePaidFor(payingOff, options);
    }

    savePayingOff(payingOff);

    if (isSaveEmployeeSalarySheetListEnabled(options)) {
      saveEmployeeSalarySheetList(payingOff, options);
      // removeEmployeeSalarySheetList(payingOff, options);
      // Not delete the record

    }

    return payingOff;
  }

  // ======================================================================================

  protected PayingOff savePaidFor(PayingOff payingOff, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (payingOff.getPaidFor() == null) {
      return payingOff; // do nothing when it is null
    }

    getEmployeeDAO().save(payingOff.getPaidFor(), options);
    return payingOff;
  }

  public PayingOff planToRemoveEmployeeSalarySheetList(
      PayingOff payingOff, String employeeSalarySheetIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSalarySheet.PAYING_OFF_PROPERTY, payingOff.getId());
    key.put(EmployeeSalarySheet.ID_PROPERTY, employeeSalarySheetIds);

    SmartList<EmployeeSalarySheet> externalEmployeeSalarySheetList =
        getEmployeeSalarySheetDAO().findEmployeeSalarySheetWithKey(key, options);
    if (externalEmployeeSalarySheetList == null) {
      return payingOff;
    }
    if (externalEmployeeSalarySheetList.isEmpty()) {
      return payingOff;
    }

    for (EmployeeSalarySheet employeeSalarySheetItem : externalEmployeeSalarySheetList) {

      employeeSalarySheetItem.clearFromAll();
    }

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = payingOff.getEmployeeSalarySheetList();
    employeeSalarySheetList.addAllToRemoveList(externalEmployeeSalarySheetList);
    return payingOff;
  }

  // disconnect PayingOff with employee in EmployeeSalarySheet
  public PayingOff planToRemoveEmployeeSalarySheetListWithEmployee(
      PayingOff payingOff, String employeeId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSalarySheet.PAYING_OFF_PROPERTY, payingOff.getId());
    key.put(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employeeId);

    SmartList<EmployeeSalarySheet> externalEmployeeSalarySheetList =
        getEmployeeSalarySheetDAO().findEmployeeSalarySheetWithKey(key, options);
    if (externalEmployeeSalarySheetList == null) {
      return payingOff;
    }
    if (externalEmployeeSalarySheetList.isEmpty()) {
      return payingOff;
    }

    for (EmployeeSalarySheet employeeSalarySheetItem : externalEmployeeSalarySheetList) {
      employeeSalarySheetItem.clearEmployee();
      employeeSalarySheetItem.clearPayingOff();
    }

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = payingOff.getEmployeeSalarySheetList();
    employeeSalarySheetList.addAllToRemoveList(externalEmployeeSalarySheetList);
    return payingOff;
  }

  public int countEmployeeSalarySheetListWithEmployee(
      String payingOffId, String employeeId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSalarySheet.PAYING_OFF_PROPERTY, payingOffId);
    key.put(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employeeId);

    int count = getEmployeeSalarySheetDAO().countEmployeeSalarySheetWithKey(key, options);
    return count;
  }

  // disconnect PayingOff with current_salary_grade in EmployeeSalarySheet
  public PayingOff planToRemoveEmployeeSalarySheetListWithCurrentSalaryGrade(
      PayingOff payingOff, String currentSalaryGradeId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSalarySheet.PAYING_OFF_PROPERTY, payingOff.getId());
    key.put(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);

    SmartList<EmployeeSalarySheet> externalEmployeeSalarySheetList =
        getEmployeeSalarySheetDAO().findEmployeeSalarySheetWithKey(key, options);
    if (externalEmployeeSalarySheetList == null) {
      return payingOff;
    }
    if (externalEmployeeSalarySheetList.isEmpty()) {
      return payingOff;
    }

    for (EmployeeSalarySheet employeeSalarySheetItem : externalEmployeeSalarySheetList) {
      employeeSalarySheetItem.clearCurrentSalaryGrade();
      employeeSalarySheetItem.clearPayingOff();
    }

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = payingOff.getEmployeeSalarySheetList();
    employeeSalarySheetList.addAllToRemoveList(externalEmployeeSalarySheetList);
    return payingOff;
  }

  public int countEmployeeSalarySheetListWithCurrentSalaryGrade(
      String payingOffId, String currentSalaryGradeId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSalarySheet.PAYING_OFF_PROPERTY, payingOffId);
    key.put(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);

    int count = getEmployeeSalarySheetDAO().countEmployeeSalarySheetWithKey(key, options);
    return count;
  }

  protected PayingOff saveEmployeeSalarySheetList(
      PayingOff payingOff, Map<String, Object> options) {

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = payingOff.getEmployeeSalarySheetList();
    if (employeeSalarySheetList == null) {
      // null list means nothing
      return payingOff;
    }
    SmartList<EmployeeSalarySheet> mergedUpdateEmployeeSalarySheetList =
        new SmartList<EmployeeSalarySheet>();

    mergedUpdateEmployeeSalarySheetList.addAll(employeeSalarySheetList);
    if (employeeSalarySheetList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeeSalarySheetList.addAll(employeeSalarySheetList.getToRemoveList());
      employeeSalarySheetList.removeAll(employeeSalarySheetList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeeSalarySheetDAO()
        .saveEmployeeSalarySheetList(mergedUpdateEmployeeSalarySheetList, options);

    if (employeeSalarySheetList.getToRemoveList() != null) {
      employeeSalarySheetList.removeAll(employeeSalarySheetList.getToRemoveList());
    }

    return payingOff;
  }

  protected PayingOff removeEmployeeSalarySheetList(
      PayingOff payingOff, Map<String, Object> options) {

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = payingOff.getEmployeeSalarySheetList();
    if (employeeSalarySheetList == null) {
      return payingOff;
    }

    SmartList<EmployeeSalarySheet> toRemoveEmployeeSalarySheetList =
        employeeSalarySheetList.getToRemoveList();

    if (toRemoveEmployeeSalarySheetList == null) {
      return payingOff;
    }
    if (toRemoveEmployeeSalarySheetList.isEmpty()) {
      return payingOff; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeeSalarySheetDAO()
        .removeEmployeeSalarySheetList(toRemoveEmployeeSalarySheetList, options);

    return payingOff;
  }

  public PayingOff present(PayingOff payingOff, Map<String, Object> options) {

    presentEmployeeSalarySheetList(payingOff, options);

    return payingOff;
  }

  // Using java8 feature to reduce the code significantly
  protected PayingOff presentEmployeeSalarySheetList(
      PayingOff payingOff, Map<String, Object> options) {

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = payingOff.getEmployeeSalarySheetList();
    SmartList<EmployeeSalarySheet> newList =
        presentSubList(
            payingOff.getId(),
            employeeSalarySheetList,
            options,
            getEmployeeSalarySheetDAO()::countEmployeeSalarySheetByPayingOff,
            getEmployeeSalarySheetDAO()::findEmployeeSalarySheetByPayingOff);

    payingOff.setEmployeeSalarySheetList(newList);

    return payingOff;
  }

  public SmartList<PayingOff> requestCandidatePayingOffForEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        PayingOffTable.COLUMN_WHO,
        PayingOffTable.COLUMN_PAID_FOR,
        filterKey,
        pageNo,
        pageSize,
        getPayingOffMapper());
  }

  protected String getTableName() {
    return PayingOffTable.TABLE_NAME;
  }

  public void enhanceList(List<PayingOff> payingOffList) {
    this.enhanceListInternal(payingOffList, this.getPayingOffMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<PayingOff> payingOffList = ownerEntity.collectRefsWithType(PayingOff.INTERNAL_TYPE);
    this.enhanceList(payingOffList);
  }

  @Override
  public SmartList<PayingOff> findPayingOffWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getPayingOffMapper());
  }

  @Override
  public int countPayingOffWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countPayingOffWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<PayingOff> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getPayingOffMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<PayingOff> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getPayingOffMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidatePayingOff executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidatePayingOff result = new CandidatePayingOff();
    int pageNo = Math.max(1, query.getPageNo());
    result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
    result.setOwnerId(query.getOwnerId());
    result.setFilterKey(query.getFilterKey());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
    result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

    SmartList candidateList = queryList(sql, parmeters);
    this.alias(candidateList);
    result.setCandidates(candidateList);
    int offSet = (pageNo - 1) * query.getPageSize();
    if (candidateList.size() > query.getPageSize()) {
      result.setTotalPage(pageNo + 1);
    } else {
      result.setTotalPage(pageNo);
    }
    return result;
  }

  @Override
  public List<PayingOff> search(PayingOffRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected PayingOffMapper mapper() {
    return getPayingOffMapper();
  }

  @Override
  protected PayingOffMapper mapperForClazz(Class<?> clazz) {
    return PayingOffMapper.mapperForClass(clazz);
  }
}
