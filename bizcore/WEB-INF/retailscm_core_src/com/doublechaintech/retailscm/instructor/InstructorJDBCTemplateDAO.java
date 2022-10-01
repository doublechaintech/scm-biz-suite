package com.doublechaintech.retailscm.instructor;

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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

import com.doublechaintech.retailscm.companytraining.CompanyTrainingDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class InstructorJDBCTemplateDAO extends RetailscmBaseDAOImpl implements InstructorDAO {

  protected RetailStoreCountryCenterDAO retailStoreCountryCenterDAO;

  public void setRetailStoreCountryCenterDAO(
      RetailStoreCountryCenterDAO retailStoreCountryCenterDAO) {

    if (retailStoreCountryCenterDAO == null) {
      throw new IllegalStateException("Do not try to set retailStoreCountryCenterDAO to null.");
    }
    this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
  }

  public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO() {
    if (this.retailStoreCountryCenterDAO == null) {
      throw new IllegalStateException(
          "The retailStoreCountryCenterDAO is not configured yet, please config it some where.");
    }

    return this.retailStoreCountryCenterDAO;
  }

  protected CompanyTrainingDAO companyTrainingDAO;

  public void setCompanyTrainingDAO(CompanyTrainingDAO companyTrainingDAO) {

    if (companyTrainingDAO == null) {
      throw new IllegalStateException("Do not try to set companyTrainingDAO to null.");
    }
    this.companyTrainingDAO = companyTrainingDAO;
  }

  public CompanyTrainingDAO getCompanyTrainingDAO() {
    if (this.companyTrainingDAO == null) {
      throw new IllegalStateException(
          "The companyTrainingDAO is not configured yet, please config it some where.");
    }

    return this.companyTrainingDAO;
  }

  /*
  protected Instructor load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalInstructor(accessKey, options);
  }
  */

  public SmartList<Instructor> loadAll() {
    return this.loadAll(getInstructorMapper());
  }

  public Stream<Instructor> loadAllAsStream() {
    return this.loadAllAsStream(getInstructorMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public Instructor load(String id, Map<String, Object> options) throws Exception {
    return loadInternalInstructor(InstructorTable.withId(id), options);
  }

  public Instructor save(Instructor instructor, Map<String, Object> options) {

    String methodName = "save(Instructor instructor,Map<String,Object> options)";

    assertMethodArgumentNotNull(instructor, methodName, "instructor");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalInstructor(instructor, options);
  }

  public Instructor clone(String instructorId, Map<String, Object> options) throws Exception {

    return clone(InstructorTable.withId(instructorId), options);
  }

  protected Instructor clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String instructorId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    Instructor newInstructor = loadInternalInstructor(accessKey, options);
    newInstructor.setVersion(0);

    if (isSaveCompanyTrainingListEnabled(options)) {
      for (CompanyTraining item : newInstructor.getCompanyTrainingList()) {
        item.setVersion(0);
      }
    }

    saveInternalInstructor(newInstructor, options);

    return newInstructor;
  }

  protected void throwIfHasException(String instructorId, int version, int count) throws Exception {
    if (count == 1) {
      throw new InstructorVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new InstructorNotFoundException(
          "The " + this.getTableName() + "(" + instructorId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public Instructor disconnectFromAll(String instructorId, int version) throws Exception {

    Instructor instructor =
        loadInternalInstructor(InstructorTable.withId(instructorId), emptyOptions());
    instructor.clearFromAll();
    this.saveInstructor(instructor);
    return instructor;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return InstructorTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "instructor";
  }

  @Override
  protected String getBeanName() {

    return "instructor";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return InstructorTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractCompanyEnabled(Map<String, Object> options) {

    return checkOptions(options, InstructorTokens.COMPANY);
  }

  protected boolean isSaveCompanyEnabled(Map<String, Object> options) {

    return checkOptions(options, InstructorTokens.COMPANY);
  }

  protected boolean isExtractCompanyTrainingListEnabled(Map<String, Object> options) {
    return checkOptions(options, InstructorTokens.COMPANY_TRAINING_LIST);
  }

  protected boolean isAnalyzeCompanyTrainingListEnabled(Map<String, Object> options) {
    return InstructorTokens.of(options).analyzeCompanyTrainingListEnabled();
  }

  protected boolean isSaveCompanyTrainingListEnabled(Map<String, Object> options) {
    return checkOptions(options, InstructorTokens.COMPANY_TRAINING_LIST);
  }

  protected InstructorMapper getInstructorMapper() {
    return new InstructorMapper();
  }

  protected Instructor extractInstructor(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      Instructor instructor = loadSingleObject(accessKey, getInstructorMapper());
      return instructor;
    } catch (EmptyResultDataAccessException e) {
      throw new InstructorNotFoundException("Instructor(" + accessKey + ") is not found!");
    }
  }

  protected Instructor loadInternalInstructor(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {

    Instructor instructor = extractInstructor(accessKey, loadOptions);

    if (isExtractCompanyEnabled(loadOptions)) {
      extractCompany(instructor, loadOptions);
    }

    if (isExtractCompanyTrainingListEnabled(loadOptions)) {
      extractCompanyTrainingList(instructor, loadOptions);
    }

    if (isAnalyzeCompanyTrainingListEnabled(loadOptions)) {
      analyzeCompanyTrainingList(instructor, loadOptions);
    }

    return instructor;
  }

  protected Instructor extractCompany(Instructor instructor, Map<String, Object> options)
      throws Exception {

    if (instructor.getCompany() == null) {
      return instructor;
    }
    String companyId = instructor.getCompany().getId();
    if (companyId == null) {
      return instructor;
    }
    RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId, options);
    if (company != null) {
      instructor.setCompany(company);
    }

    return instructor;
  }

  protected void enhanceCompanyTrainingList(
      SmartList<CompanyTraining> companyTrainingList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Instructor extractCompanyTrainingList(
      Instructor instructor, Map<String, Object> options) {

    if (instructor == null) {
      return null;
    }
    if (instructor.getId() == null) {
      return instructor;
    }

    SmartList<CompanyTraining> companyTrainingList =
        getCompanyTrainingDAO().findCompanyTrainingByInstructor(instructor.getId(), options);
    if (companyTrainingList != null) {
      enhanceCompanyTrainingList(companyTrainingList, options);
      instructor.setCompanyTrainingList(companyTrainingList);
    }

    return instructor;
  }

  protected Instructor analyzeCompanyTrainingList(
      Instructor instructor, Map<String, Object> options) {

    if (instructor == null) {
      return null;
    }
    if (instructor.getId() == null) {
      return instructor;
    }

    SmartList<CompanyTraining> companyTrainingList = instructor.getCompanyTrainingList();
    if (companyTrainingList != null) {
      getCompanyTrainingDAO()
          .analyzeCompanyTrainingByInstructor(companyTrainingList, instructor.getId(), options);
    }

    return instructor;
  }

  public SmartList<Instructor> findInstructorByCompany(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    SmartList<Instructor> resultList =
        queryWith(
            InstructorTable.COLUMN_COMPANY,
            retailStoreCountryCenterId,
            options,
            getInstructorMapper());
    // analyzeInstructorByCompany(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public SmartList<Instructor> findInstructorByCompany(
      String retailStoreCountryCenterId, int start, int count, Map<String, Object> options) {

    SmartList<Instructor> resultList =
        queryWithRange(
            InstructorTable.COLUMN_COMPANY,
            retailStoreCountryCenterId,
            options,
            getInstructorMapper(),
            start,
            count);
    // analyzeInstructorByCompany(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public void analyzeInstructorByCompany(
      SmartList<Instructor> resultList,
      String retailStoreCountryCenterId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(Instructor.COMPANY_PROPERTY, retailStoreCountryCenterId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // Instructor.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("讲师");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(Instructor.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(Instructor.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countInstructorByCompany(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    return countWith(InstructorTable.COLUMN_COMPANY, retailStoreCountryCenterId, options);
  }

  @Override
  public Map<String, Integer> countInstructorByCompanyIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(InstructorTable.COLUMN_COMPANY, ids, options);
  }

  protected Instructor saveInstructor(Instructor instructor) {

    if (!instructor.isChanged()) {
      return instructor;
    }

    Beans.dbUtil().cacheCleanUp(instructor);
    String SQL = this.getSaveInstructorSQL(instructor);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveInstructorParameters(instructor);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    instructor.incVersion();
    instructor.afterSave();
    return instructor;
  }

  public SmartList<Instructor> saveInstructorList(
      SmartList<Instructor> instructorList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitInstructorList(instructorList);

    batchInstructorCreate((List<Instructor>) lists[CREATE_LIST_INDEX]);
    batchInstructorUpdate((List<Instructor>) lists[UPDATE_LIST_INDEX]);
    batchInstructorRemove((List<Instructor>) lists[REMOVE_LIST_INDEX]);
    batchInstructorRecover((List<Instructor>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (Instructor instructor : instructorList) {
      if (instructor.isChanged()) {
        instructor.incVersion();
        instructor.afterSave();
      }
      if (instructor.isToRecover() || instructor.isToRemove()) {
        instructor.setVersion(-instructor.getVersion());
      }
    }

    return instructorList;
  }

  public SmartList<Instructor> removeInstructorList(
      SmartList<Instructor> instructorList, Map<String, Object> options) {

    super.removeList(instructorList, options);

    return instructorList;
  }

  protected List<Object[]> prepareInstructorBatchCreateArgs(List<Instructor> instructorList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Instructor instructor : instructorList) {
      Object[] parameters = prepareInstructorCreateParameters(instructor);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareInstructorBatchUpdateArgs(List<Instructor> instructorList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Instructor instructor : instructorList) {
      if (!instructor.isChanged()) {
        continue;
      }
      Object[] parameters = prepareInstructorUpdateParameters(instructor);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareInstructorBatchRecoverArgs(List<Instructor> instructorList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Instructor instructor : instructorList) {
      if (!instructor.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(instructor);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareInstructorBatchRemoveArgs(List<Instructor> instructorList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Instructor instructor : instructorList) {
      if (!instructor.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareInstructorRemoveParameters(instructor);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchInstructorCreate(List<Instructor> instructorList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareInstructorBatchCreateArgs(instructorList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchInstructorUpdate(List<Instructor> instructorList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareInstructorBatchUpdateArgs(instructorList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchInstructorRemove(List<Instructor> instructorList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareInstructorBatchRemoveArgs(instructorList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchInstructorRecover(List<Instructor> instructorList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareInstructorBatchRecoverArgs(instructorList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitInstructorList(List<Instructor> instructorList) {

    List<Instructor> instructorCreateList = new ArrayList<Instructor>();
    List<Instructor> instructorUpdateList = new ArrayList<Instructor>();
    List<Instructor> instructorRemoveList = new ArrayList<Instructor>();
    List<Instructor> instructorRecoverList = new ArrayList<Instructor>();

    for (Instructor instructor : instructorList) {
      if (instructor.isToRemove()) {
        instructorRemoveList.add(instructor);
        continue;
      }
      if (instructor.isToRecover()) {
        instructorRecoverList.add(instructor);
        continue;
      }
      if (isUpdateRequest(instructor)) {
        if (instructor.isChanged()) {
          instructorUpdateList.add(instructor);
        }
        continue;
      }

      if (instructor.isChanged()) {
        instructorCreateList.add(instructor);
      }
    }

    return new Object[] {
      instructorCreateList, instructorUpdateList, instructorRemoveList, instructorRecoverList
    };
  }

  protected boolean isUpdateRequest(Instructor instructor) {
    return instructor.getVersion() > 0;
  }

  protected String getSaveInstructorSQL(Instructor instructor) {
    if (instructor.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(instructor)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveInstructorParameters(Instructor instructor) {
    if (instructor.isToRemove()) {
      return prepareInstructorRemoveParameters(instructor);
    }
    if (instructor.isToRecover()) {
      return prepareRecoverParameters(instructor);
    }

    if (isUpdateRequest(instructor)) {
      return prepareInstructorUpdateParameters(instructor);
    }
    return prepareInstructorCreateParameters(instructor);
  }

  protected Object[] prepareInstructorRemoveParameters(Instructor instructor) {
    return super.prepareRemoveParameters(instructor);
  }

  protected Object[] prepareInstructorUpdateParameters(Instructor instructor) {
    Object[] parameters = new Object[11];

    parameters[0] = instructor.getTitle();

    parameters[1] = instructor.getFamilyName();

    parameters[2] = instructor.getGivenName();

    parameters[3] = instructor.getCellPhone();

    parameters[4] = instructor.getEmail();

    if (instructor.getCompany() != null) {
      parameters[5] = instructor.getCompany().getId();
    }

    parameters[6] = instructor.getIntroduction();

    parameters[7] = instructor.getLastUpdateTime();

    parameters[8] = instructor.nextVersion();
    parameters[9] = instructor.getId();
    parameters[10] = instructor.getVersion();

    return parameters;
  }

  protected Object[] prepareInstructorCreateParameters(Instructor instructor) {
    Object[] parameters = new Object[9];
    if (instructor.getId() == null) {
      String newInstructorId = getNextId();
      instructor.setId(newInstructorId);
    }
    parameters[0] = instructor.getId();

    parameters[1] = instructor.getTitle();

    parameters[2] = instructor.getFamilyName();

    parameters[3] = instructor.getGivenName();

    parameters[4] = instructor.getCellPhone();

    parameters[5] = instructor.getEmail();

    if (instructor.getCompany() != null) {
      parameters[6] = instructor.getCompany().getId();
    }

    parameters[7] = instructor.getIntroduction();

    parameters[8] = instructor.getLastUpdateTime();

    return parameters;
  }

  protected Instructor saveInternalInstructor(Instructor instructor, Map<String, Object> options) {

    if (isSaveCompanyEnabled(options)) {
      saveCompany(instructor, options);
    }

    saveInstructor(instructor);

    if (isSaveCompanyTrainingListEnabled(options)) {
      saveCompanyTrainingList(instructor, options);
      // removeCompanyTrainingList(instructor, options);
      // Not delete the record

    }

    return instructor;
  }

  // ======================================================================================

  protected Instructor saveCompany(Instructor instructor, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (instructor.getCompany() == null) {
      return instructor; // do nothing when it is null
    }

    getRetailStoreCountryCenterDAO().save(instructor.getCompany(), options);
    return instructor;
  }

  public Instructor planToRemoveCompanyTrainingList(
      Instructor instructor, String companyTrainingIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(CompanyTraining.INSTRUCTOR_PROPERTY, instructor.getId());
    key.put(CompanyTraining.ID_PROPERTY, companyTrainingIds);

    SmartList<CompanyTraining> externalCompanyTrainingList =
        getCompanyTrainingDAO().findCompanyTrainingWithKey(key, options);
    if (externalCompanyTrainingList == null) {
      return instructor;
    }
    if (externalCompanyTrainingList.isEmpty()) {
      return instructor;
    }

    for (CompanyTraining companyTrainingItem : externalCompanyTrainingList) {

      companyTrainingItem.clearFromAll();
    }

    SmartList<CompanyTraining> companyTrainingList = instructor.getCompanyTrainingList();
    companyTrainingList.addAllToRemoveList(externalCompanyTrainingList);
    return instructor;
  }

  // disconnect Instructor with company in CompanyTraining
  public Instructor planToRemoveCompanyTrainingListWithCompany(
      Instructor instructor, String companyId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(CompanyTraining.INSTRUCTOR_PROPERTY, instructor.getId());
    key.put(CompanyTraining.COMPANY_PROPERTY, companyId);

    SmartList<CompanyTraining> externalCompanyTrainingList =
        getCompanyTrainingDAO().findCompanyTrainingWithKey(key, options);
    if (externalCompanyTrainingList == null) {
      return instructor;
    }
    if (externalCompanyTrainingList.isEmpty()) {
      return instructor;
    }

    for (CompanyTraining companyTrainingItem : externalCompanyTrainingList) {
      companyTrainingItem.clearCompany();
      companyTrainingItem.clearInstructor();
    }

    SmartList<CompanyTraining> companyTrainingList = instructor.getCompanyTrainingList();
    companyTrainingList.addAllToRemoveList(externalCompanyTrainingList);
    return instructor;
  }

  public int countCompanyTrainingListWithCompany(
      String instructorId, String companyId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(CompanyTraining.INSTRUCTOR_PROPERTY, instructorId);
    key.put(CompanyTraining.COMPANY_PROPERTY, companyId);

    int count = getCompanyTrainingDAO().countCompanyTrainingWithKey(key, options);
    return count;
  }

  // disconnect Instructor with training_course_type in CompanyTraining
  public Instructor planToRemoveCompanyTrainingListWithTrainingCourseType(
      Instructor instructor, String trainingCourseTypeId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(CompanyTraining.INSTRUCTOR_PROPERTY, instructor.getId());
    key.put(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, trainingCourseTypeId);

    SmartList<CompanyTraining> externalCompanyTrainingList =
        getCompanyTrainingDAO().findCompanyTrainingWithKey(key, options);
    if (externalCompanyTrainingList == null) {
      return instructor;
    }
    if (externalCompanyTrainingList.isEmpty()) {
      return instructor;
    }

    for (CompanyTraining companyTrainingItem : externalCompanyTrainingList) {
      companyTrainingItem.clearTrainingCourseType();
      companyTrainingItem.clearInstructor();
    }

    SmartList<CompanyTraining> companyTrainingList = instructor.getCompanyTrainingList();
    companyTrainingList.addAllToRemoveList(externalCompanyTrainingList);
    return instructor;
  }

  public int countCompanyTrainingListWithTrainingCourseType(
      String instructorId, String trainingCourseTypeId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(CompanyTraining.INSTRUCTOR_PROPERTY, instructorId);
    key.put(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, trainingCourseTypeId);

    int count = getCompanyTrainingDAO().countCompanyTrainingWithKey(key, options);
    return count;
  }

  protected Instructor saveCompanyTrainingList(Instructor instructor, Map<String, Object> options) {

    SmartList<CompanyTraining> companyTrainingList = instructor.getCompanyTrainingList();
    if (companyTrainingList == null) {
      // null list means nothing
      return instructor;
    }
    SmartList<CompanyTraining> mergedUpdateCompanyTrainingList = new SmartList<CompanyTraining>();

    mergedUpdateCompanyTrainingList.addAll(companyTrainingList);
    if (companyTrainingList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateCompanyTrainingList.addAll(companyTrainingList.getToRemoveList());
      companyTrainingList.removeAll(companyTrainingList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getCompanyTrainingDAO().saveCompanyTrainingList(mergedUpdateCompanyTrainingList, options);

    if (companyTrainingList.getToRemoveList() != null) {
      companyTrainingList.removeAll(companyTrainingList.getToRemoveList());
    }

    return instructor;
  }

  protected Instructor removeCompanyTrainingList(
      Instructor instructor, Map<String, Object> options) {

    SmartList<CompanyTraining> companyTrainingList = instructor.getCompanyTrainingList();
    if (companyTrainingList == null) {
      return instructor;
    }

    SmartList<CompanyTraining> toRemoveCompanyTrainingList = companyTrainingList.getToRemoveList();

    if (toRemoveCompanyTrainingList == null) {
      return instructor;
    }
    if (toRemoveCompanyTrainingList.isEmpty()) {
      return instructor; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getCompanyTrainingDAO().removeCompanyTrainingList(toRemoveCompanyTrainingList, options);

    return instructor;
  }

  public Instructor present(Instructor instructor, Map<String, Object> options) {

    presentCompanyTrainingList(instructor, options);

    return instructor;
  }

  // Using java8 feature to reduce the code significantly
  protected Instructor presentCompanyTrainingList(
      Instructor instructor, Map<String, Object> options) {

    SmartList<CompanyTraining> companyTrainingList = instructor.getCompanyTrainingList();
    SmartList<CompanyTraining> newList =
        presentSubList(
            instructor.getId(),
            companyTrainingList,
            options,
            getCompanyTrainingDAO()::countCompanyTrainingByInstructor,
            getCompanyTrainingDAO()::findCompanyTrainingByInstructor);

    instructor.setCompanyTrainingList(newList);

    return instructor;
  }

  public SmartList<Instructor> requestCandidateInstructorForCompanyTraining(
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
        InstructorTable.COLUMN_TITLE,
        InstructorTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getInstructorMapper());
  }

  protected String getTableName() {
    return InstructorTable.TABLE_NAME;
  }

  public void enhanceList(List<Instructor> instructorList) {
    this.enhanceListInternal(instructorList, this.getInstructorMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<Instructor> instructorList = ownerEntity.collectRefsWithType(Instructor.INTERNAL_TYPE);
    this.enhanceList(instructorList);
  }

  @Override
  public SmartList<Instructor> findInstructorWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getInstructorMapper());
  }

  @Override
  public int countInstructorWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countInstructorWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<Instructor> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getInstructorMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<Instructor> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getInstructorMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateInstructor executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateInstructor result = new CandidateInstructor();
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
  public List<Instructor> search(InstructorRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected InstructorMapper mapper() {
    return getInstructorMapper();
  }

  @Override
  protected InstructorMapper mapperForClazz(Class<?> clazz) {
    return InstructorMapper.mapperForClass(clazz);
  }
}
