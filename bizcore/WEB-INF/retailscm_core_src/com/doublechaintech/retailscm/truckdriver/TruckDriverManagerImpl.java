package com.doublechaintech.retailscm.truckdriver;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.transportfleet.CandidateTransportFleet;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.caf.baseelement.PlainText;
import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;

public class TruckDriverManagerImpl extends CustomRetailscmCheckerManager
    implements TruckDriverManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens = TruckDriverTokens.start().withTokenFromListName(listName).done();
    TruckDriver truckDriver = (TruckDriver) this.loadTruckDriver(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = truckDriver.collectReferencesFromLists();
    truckDriverDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, truckDriver, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new TruckDriverGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "TruckDriver";

  @Override
  public TruckDriverDAO daoOf(RetailscmUserContext userContext) {
    return truckDriverDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws TruckDriverManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new TruckDriverManagerException(message);
  }

  protected TruckDriver saveTruckDriver(
      RetailscmUserContext userContext, TruckDriver truckDriver, String[] tokensExpr)
      throws Exception {
    // return getTruckDriverDAO().save(truckDriver, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveTruckDriver(userContext, truckDriver, tokens);
  }

  protected TruckDriver saveTruckDriverDetail(
      RetailscmUserContext userContext, TruckDriver truckDriver) throws Exception {

    return saveTruckDriver(userContext, truckDriver, allTokens());
  }

  public TruckDriver loadTruckDriver(
      RetailscmUserContext userContext, String truckDriverId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);

    checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, tokens);
    // do some calc before sent to customer?
    return present(userContext, truckDriver, tokens);
  }

  public TruckDriver searchTruckDriver(
      RetailscmUserContext userContext,
      String truckDriverId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);

    checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, tokens);
    // do some calc before sent to customer?
    return present(userContext, truckDriver, tokens);
  }

  protected TruckDriver present(
      RetailscmUserContext userContext, TruckDriver truckDriver, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, truckDriver, tokens);

    TruckDriver truckDriverToPresent = truckDriverDaoOf(userContext).present(truckDriver, tokens);

    List<BaseEntity> entityListToNaming = truckDriverToPresent.collectReferencesFromLists();
    truckDriverDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, truckDriver, tokens);

    return truckDriverToPresent;
  }

  public TruckDriver loadTruckDriverDetail(RetailscmUserContext userContext, String truckDriverId)
      throws Exception {
    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
    return present(userContext, truckDriver, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String truckDriverId) throws Exception {
    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, viewTokens());
    markVisited(userContext, truckDriver);
    return present(userContext, truckDriver, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String truckDriverId)
      throws Exception {
    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, viewTokens());
    truckDriver.summarySuffix();
    markVisited(userContext, truckDriver);
    return present(userContext, truckDriver, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String truckDriverId) throws Exception {
    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, analyzeTokens());
    markVisited(userContext, truckDriver);
    return present(userContext, truckDriver, analyzeTokens());
  }

  protected TruckDriver saveTruckDriver(
      RetailscmUserContext userContext, TruckDriver truckDriver, Map<String, Object> tokens)
      throws Exception {

    return truckDriverDaoOf(userContext).save(truckDriver, tokens);
  }

  protected TruckDriver loadTruckDriver(
      RetailscmUserContext userContext, String truckDriverId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);

    checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);

    return truckDriverDaoOf(userContext).load(truckDriverId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, TruckDriver truckDriver, Map<String, Object> tokens) {
    super.addActions(userContext, truckDriver, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, TruckDriver truckDriver, Map<String, Object> tokens){

  @Override
  public List<TruckDriver> searchTruckDriverList(
      RetailscmUserContext ctx, TruckDriverRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<TruckDriver> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public TruckDriver searchTruckDriver(RetailscmUserContext ctx, TruckDriverRequest pRequest) {
    pRequest.limit(0, 1);
    List<TruckDriver> list = searchTruckDriverList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public TruckDriver createTruckDriver(
      RetailscmUserContext userContext,
      String name,
      String driverLicenseNumber,
      String contactNumber,
      String belongsToId)
      throws Exception {

    checkerOf(userContext).checkNameOfTruckDriver(name);
    checkerOf(userContext).checkDriverLicenseNumberOfTruckDriver(driverLicenseNumber);
    checkerOf(userContext).checkContactNumberOfTruckDriver(contactNumber);

    checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);

    TruckDriver truckDriver = createNewTruckDriver();

    truckDriver.setName(name);
    truckDriver.setDriverLicenseNumber(driverLicenseNumber);
    truckDriver.setContactNumber(contactNumber);

    TransportFleet belongsTo = loadTransportFleet(userContext, belongsToId, emptyOptions());
    truckDriver.setBelongsTo(belongsTo);

    truckDriver = saveTruckDriver(userContext, truckDriver, emptyOptions());

    onNewInstanceCreated(userContext, truckDriver);
    return truckDriver;
  }

  protected TruckDriver createNewTruckDriver() {

    return new TruckDriver();
  }

  protected void checkParamsForUpdatingTruckDriver(
      RetailscmUserContext userContext,
      String truckDriverId,
      int truckDriverVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
    checkerOf(userContext).checkVersionOfTruckDriver(truckDriverVersion);

    if (TruckDriver.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfTruckDriver(parseString(newValueExpr));
    }
    if (TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY.equals(property)) {

      checkerOf(userContext).checkDriverLicenseNumberOfTruckDriver(parseString(newValueExpr));
    }
    if (TruckDriver.CONTACT_NUMBER_PROPERTY.equals(property)) {

      checkerOf(userContext).checkContactNumberOfTruckDriver(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);
  }

  public TruckDriver clone(RetailscmUserContext userContext, String fromTruckDriverId)
      throws Exception {

    return truckDriverDaoOf(userContext).clone(fromTruckDriverId, this.allTokens());
  }

  public TruckDriver internalSaveTruckDriver(
      RetailscmUserContext userContext, TruckDriver truckDriver) throws Exception {
    return internalSaveTruckDriver(userContext, truckDriver, allTokens());
  }

  public TruckDriver internalSaveTruckDriver(
      RetailscmUserContext userContext, TruckDriver truckDriver, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingTruckDriver(userContext, truckDriverId, truckDriverVersion, property,
    // newValueExpr, tokensExpr);

    synchronized (truckDriver) {
      // will be good when the truckDriver loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to TruckDriver.
      if (truckDriver.isChanged()) {}

      // checkerOf(userContext).checkAndFixTruckDriver(truckDriver);
      truckDriver = saveTruckDriver(userContext, truckDriver, options);
      return truckDriver;
    }
  }

  public TruckDriver updateTruckDriver(
      RetailscmUserContext userContext,
      String truckDriverId,
      int truckDriverVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingTruckDriver(
        userContext, truckDriverId, truckDriverVersion, property, newValueExpr, tokensExpr);

    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
    if (truckDriver.getVersion() != truckDriverVersion) {
      String message =
          "The target version("
              + truckDriver.getVersion()
              + ") is not equals to version("
              + truckDriverVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (truckDriver) {
      // will be good when the truckDriver loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to TruckDriver.

      truckDriver.changeProperty(property, newValueExpr);
      truckDriver = saveTruckDriver(userContext, truckDriver, tokens().done());
      return present(userContext, truckDriver, mergedAllTokens(tokensExpr));
      // return saveTruckDriver(userContext, truckDriver, tokens().done());
    }
  }

  public TruckDriver updateTruckDriverProperty(
      RetailscmUserContext userContext,
      String truckDriverId,
      int truckDriverVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingTruckDriver(
        userContext, truckDriverId, truckDriverVersion, property, newValueExpr, tokensExpr);

    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
    if (truckDriver.getVersion() != truckDriverVersion) {
      String message =
          "The target version("
              + truckDriver.getVersion()
              + ") is not equals to version("
              + truckDriverVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (truckDriver) {
      // will be good when the truckDriver loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to TruckDriver.

      truckDriver.changeProperty(property, newValueExpr);

      truckDriver = saveTruckDriver(userContext, truckDriver, tokens().done());
      return present(userContext, truckDriver, mergedAllTokens(tokensExpr));
      // return saveTruckDriver(userContext, truckDriver, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected TruckDriverTokens tokens() {
    return TruckDriverTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return TruckDriverTokens.all();
  }

  protected Map<String, Object> analyzeTokens() {
    return tokens().allTokens().analyzeAllLists().done();
  }

  protected Map<String, Object> summaryTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> viewTokens() {
    return tokens()
        .allTokens()
        .sortTransportTaskListWith(TransportTask.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return TruckDriverTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherBelongsTo(
      RetailscmUserContext userContext, String truckDriverId, String anotherBelongsToId)
      throws Exception {

    checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
    checkerOf(userContext)
        .checkIdOfTransportFleet(anotherBelongsToId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);
  }

  public TruckDriver transferToAnotherBelongsTo(
      RetailscmUserContext userContext, String truckDriverId, String anotherBelongsToId)
      throws Exception {
    checkParamsForTransferingAnotherBelongsTo(userContext, truckDriverId, anotherBelongsToId);

    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
    synchronized (truckDriver) {
      // will be good when the truckDriver loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      TransportFleet belongsTo =
          loadTransportFleet(userContext, anotherBelongsToId, emptyOptions());
      truckDriver.updateBelongsTo(belongsTo);

      truckDriver = saveTruckDriver(userContext, truckDriver, emptyOptions());

      return present(userContext, truckDriver, allTokens());
    }
  }

  public CandidateTransportFleet requestCandidateBelongsTo(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateTransportFleet result = new CandidateTransportFleet();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<TransportFleet> candidateList =
        transportFleetDaoOf(userContext)
            .requestCandidateTransportFleetForTruckDriver(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected TransportFleet loadTransportFleet(
      RetailscmUserContext userContext, String newBelongsToId, Map<String, Object> options)
      throws Exception {

    return transportFleetDaoOf(userContext).load(newBelongsToId, options);
  }

  // --------------------------------------------------------------

  public TruckDriver forgetByAll(
      RetailscmUserContext userContext, String truckDriverId, int truckDriverVersion)
      throws Exception {
    return forgetByAllInternal(userContext, truckDriverId, truckDriverVersion);
  }

  protected TruckDriver forgetByAllInternal(
      RetailscmUserContext userContext, String truckDriverId, int truckDriverVersion)
      throws Exception {

    return truckDriverDaoOf(userContext).disconnectFromAll(truckDriverId, truckDriverVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new TruckDriverManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingTransportTask(
      RetailscmUserContext userContext,
      String truckDriverId,
      String name,
      String start,
      Date beginTime,
      String endId,
      String truckId,
      String belongsToId,
      BigDecimal latitude,
      BigDecimal longitude,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);

    checkerOf(userContext).checkNameOfTransportTask(name);

    checkerOf(userContext).checkStartOfTransportTask(start);

    checkerOf(userContext).checkBeginTimeOfTransportTask(beginTime);

    checkerOf(userContext).checkEndIdOfTransportTask(endId);

    checkerOf(userContext).checkTruckIdOfTransportTask(truckId);

    checkerOf(userContext).checkBelongsToIdOfTransportTask(belongsToId);

    checkerOf(userContext).checkLatitudeOfTransportTask(latitude);

    checkerOf(userContext).checkLongitudeOfTransportTask(longitude);

    checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);
  }

  public TruckDriver addTransportTask(
      RetailscmUserContext userContext,
      String truckDriverId,
      String name,
      String start,
      Date beginTime,
      String endId,
      String truckId,
      String belongsToId,
      BigDecimal latitude,
      BigDecimal longitude,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingTransportTask(
        userContext,
        truckDriverId,
        name,
        start,
        beginTime,
        endId,
        truckId,
        belongsToId,
        latitude,
        longitude,
        tokensExpr);

    TransportTask transportTask =
        createTransportTask(
            userContext, name, start, beginTime, endId, truckId, belongsToId, latitude, longitude);

    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, emptyOptions());
    synchronized (truckDriver) {
      // Will be good when the truckDriver loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      truckDriver.addTransportTask(transportTask);
      truckDriver =
          saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());

      transportTaskManagerOf(userContext).onNewInstanceCreated(userContext, transportTask);
      return present(userContext, truckDriver, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingTransportTaskProperties(
      RetailscmUserContext userContext,
      String truckDriverId,
      String id,
      String name,
      String start,
      Date beginTime,
      BigDecimal latitude,
      BigDecimal longitude,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
    checkerOf(userContext).checkIdOfTransportTask(id);

    checkerOf(userContext).checkNameOfTransportTask(name);
    checkerOf(userContext).checkStartOfTransportTask(start);
    checkerOf(userContext).checkBeginTimeOfTransportTask(beginTime);
    checkerOf(userContext).checkLatitudeOfTransportTask(latitude);
    checkerOf(userContext).checkLongitudeOfTransportTask(longitude);

    checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);
  }

  public TruckDriver updateTransportTaskProperties(
      RetailscmUserContext userContext,
      String truckDriverId,
      String id,
      String name,
      String start,
      Date beginTime,
      BigDecimal latitude,
      BigDecimal longitude,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingTransportTaskProperties(
        userContext, truckDriverId, id, name, start, beginTime, latitude, longitude, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withTransportTaskListList()
            .searchTransportTaskListWith(TransportTask.ID_PROPERTY, tokens().is(), id)
            .done();

    TruckDriver truckDriverToUpdate = loadTruckDriver(userContext, truckDriverId, options);

    if (truckDriverToUpdate.getTransportTaskList().isEmpty()) {
      throw new TruckDriverManagerException("TransportTask is NOT FOUND with id: '" + id + "'");
    }

    TransportTask item = truckDriverToUpdate.getTransportTaskList().first();
    beforeUpdateTransportTaskProperties(
        userContext,
        item,
        truckDriverId,
        id,
        name,
        start,
        beginTime,
        latitude,
        longitude,
        tokensExpr);
    item.updateName(name);
    item.updateStart(start);
    item.updateBeginTime(beginTime);
    item.updateLatitude(latitude);
    item.updateLongitude(longitude);

    // checkParamsForAddingTransportTask(userContext,truckDriverId,name, code, used,tokensExpr);
    TruckDriver truckDriver =
        saveTruckDriver(userContext, truckDriverToUpdate, tokens().withTransportTaskList().done());
    synchronized (truckDriver) {
      return present(userContext, truckDriver, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateTransportTaskProperties(
      RetailscmUserContext userContext,
      TransportTask item,
      String truckDriverId,
      String id,
      String name,
      String start,
      Date beginTime,
      BigDecimal latitude,
      BigDecimal longitude,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected TransportTask createTransportTask(
      RetailscmUserContext userContext,
      String name,
      String start,
      Date beginTime,
      String endId,
      String truckId,
      String belongsToId,
      BigDecimal latitude,
      BigDecimal longitude)
      throws Exception {

    TransportTask transportTask = new TransportTask();

    transportTask.setName(name);
    transportTask.setStart(start);
    transportTask.setBeginTime(beginTime);
    RetailStore end = new RetailStore();
    end.setId(endId);
    transportTask.setEnd(end);
    TransportTruck truck = new TransportTruck();
    truck.setId(truckId);
    transportTask.setTruck(truck);
    TransportFleet belongsTo = new TransportFleet();
    belongsTo.setId(belongsToId);
    transportTask.setBelongsTo(belongsTo);
    transportTask.setLatitude(latitude);
    transportTask.setLongitude(longitude);

    return transportTask;
  }

  protected TransportTask createIndexedTransportTask(String id, int version) {

    TransportTask transportTask = new TransportTask();
    transportTask.setId(id);
    transportTask.setVersion(version);
    return transportTask;
  }

  protected void checkParamsForRemovingTransportTaskList(
      RetailscmUserContext userContext,
      String truckDriverId,
      String transportTaskIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
    for (String transportTaskIdItem : transportTaskIds) {
      checkerOf(userContext).checkIdOfTransportTask(transportTaskIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);
  }

  public TruckDriver removeTransportTaskList(
      RetailscmUserContext userContext,
      String truckDriverId,
      String transportTaskIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingTransportTaskList(
        userContext, truckDriverId, transportTaskIds, tokensExpr);

    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
    synchronized (truckDriver) {
      // Will be good when the truckDriver loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      truckDriverDaoOf(userContext)
          .planToRemoveTransportTaskList(truckDriver, transportTaskIds, allTokens());
      truckDriver =
          saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
      deleteRelationListInGraph(userContext, truckDriver.getTransportTaskList());
      return present(userContext, truckDriver, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingTransportTask(
      RetailscmUserContext userContext,
      String truckDriverId,
      String transportTaskId,
      int transportTaskVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
    checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
    checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);
  }

  public TruckDriver removeTransportTask(
      RetailscmUserContext userContext,
      String truckDriverId,
      String transportTaskId,
      int transportTaskVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingTransportTask(
        userContext, truckDriverId, transportTaskId, transportTaskVersion, tokensExpr);

    TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
    synchronized (truckDriver) {
      // Will be good when the truckDriver loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      truckDriver.removeTransportTask(transportTask);
      truckDriver =
          saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
      deleteRelationInGraph(userContext, transportTask);
      return present(userContext, truckDriver, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingTransportTask(
      RetailscmUserContext userContext,
      String truckDriverId,
      String transportTaskId,
      int transportTaskVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
    checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
    checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);
  }

  public TruckDriver copyTransportTaskFrom(
      RetailscmUserContext userContext,
      String truckDriverId,
      String transportTaskId,
      int transportTaskVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingTransportTask(
        userContext, truckDriverId, transportTaskId, transportTaskVersion, tokensExpr);

    TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, allTokens());
    synchronized (truckDriver) {
      // Will be good when the truckDriver loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      truckDriver.copyTransportTaskFrom(transportTask);
      truckDriver =
          saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());

      transportTaskManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (TransportTask) truckDriver.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, truckDriver, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingTransportTask(
      RetailscmUserContext userContext,
      String truckDriverId,
      String transportTaskId,
      int transportTaskVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
    checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
    checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);

    if (TransportTask.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfTransportTask(parseString(newValueExpr));
    }

    if (TransportTask.START_PROPERTY.equals(property)) {
      checkerOf(userContext).checkStartOfTransportTask(parseString(newValueExpr));
    }

    if (TransportTask.BEGIN_TIME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkBeginTimeOfTransportTask(parseDate(newValueExpr));
    }

    if (TransportTask.LATITUDE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkLatitudeOfTransportTask(parseBigDecimal(newValueExpr));
    }

    if (TransportTask.LONGITUDE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkLongitudeOfTransportTask(parseBigDecimal(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(TruckDriverManagerException.class);
  }

  public TruckDriver updateTransportTask(
      RetailscmUserContext userContext,
      String truckDriverId,
      String transportTaskId,
      int transportTaskVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingTransportTask(
        userContext,
        truckDriverId,
        transportTaskId,
        transportTaskVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withTransportTaskList()
            .searchTransportTaskListWith(
                TransportTask.ID_PROPERTY, tokens().equals(), transportTaskId)
            .done();

    TruckDriver truckDriver = loadTruckDriver(userContext, truckDriverId, loadTokens);

    synchronized (truckDriver) {
      // Will be good when the truckDriver loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // truckDriver.removeTransportTask( transportTask );
      // make changes to AcceleraterAccount.
      TransportTask transportTaskIdVersionKey =
          createIndexedTransportTask(transportTaskId, transportTaskVersion);

      TransportTask transportTask = truckDriver.findTheTransportTask(transportTaskIdVersionKey);
      if (transportTask == null) {
        throw new TruckDriverManagerException(transportTaskId + " is NOT FOUND");
      }

      beforeUpdateTransportTask(
          userContext,
          transportTask,
          truckDriverId,
          transportTaskId,
          transportTaskVersion,
          property,
          newValueExpr,
          tokensExpr);
      transportTask.changeProperty(property, newValueExpr);

      truckDriver =
          saveTruckDriver(userContext, truckDriver, tokens().withTransportTaskList().done());
      transportTaskManagerOf(userContext)
          .onUpdated(userContext, transportTask, this, "updateTransportTask");
      return present(userContext, truckDriver, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateTransportTask(
      RetailscmUserContext userContext,
      TransportTask existed,
      String truckDriverId,
      String transportTaskId,
      int transportTaskVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, TruckDriver newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    truckDriverDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
  }

  // -----------------------------------//  登录部分处理 \\-----------------------------------
  @Override
  protected BusinessHandler getLoginProcessBizHandler(RetailscmUserContextImpl userContext) {
    return this;
  }

  public void onAuthenticationFailed(
      RetailscmUserContext userContext,
      LoginContext loginContext,
      LoginResult loginResult,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler)
      throws Exception {
    // by default, failed is failed, nothing can do
  }
  // when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd
  // party service.
  public void onAuthenticateNewUserLogged(
      RetailscmUserContext userContext,
      LoginContext loginContext,
      LoginResult loginResult,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler)
      throws Exception {
    // Generally speaking, when authenticated user logined, we will create a new account for
    // him/her.
    // you need do it like :
    // First, you should create new data such as:
    //   TruckDriver newTruckDriver = this.createTruckDriver(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newTruckDriver
    //   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(),
    // ...
    // Also, set it into loginContext:
    //   loginContext.getLoginTarget().setUserApp(userApp);
    // and in most case, this should be considered as "login success"
    //   loginResult.setSuccess(true);
    //
    // Since many of detailed info were depending business requirement, So,
    throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
  }

  protected SmartList<UserApp> getRelatedUserAppList(
      RetailscmUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, TruckDriver.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(RetailscmUserContext userContext, SmartList<TruckDriver> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<TransportFleet> belongsToList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, TransportFleet.class);
    userContext.getDAOGroup().enhanceList(belongsToList, TransportFleet.class);
  }

  public Object listByBelongsTo(RetailscmUserContext userContext, String belongsToId)
      throws Exception {
    return listPageByBelongsTo(userContext, belongsToId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByBelongsTo(
      RetailscmUserContext userContext, String belongsToId, int start, int count) throws Exception {
    SmartList<TruckDriver> list =
        truckDriverDaoOf(userContext)
            .findTruckDriverByBelongsTo(belongsToId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(TruckDriver.class);
    page.setContainerObject(TransportFleet.withId(belongsToId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("卡车司机列表");
    page.setRequestName("listByBelongsTo");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByBelongsTo/%s/", getBeanName(), belongsToId)));

    page.assemblerContent(userContext, "listByBelongsTo");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String truckDriverId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    TruckDriver merchantObj = (TruckDriver) this.view(userContext, truckDriverId);
    String merchantObjId = truckDriverId;
    String linkToUrl = "truckDriverManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "卡车司机" + "详情";
    Map result = new HashMap();
    List propList = new ArrayList();
    List sections = new ArrayList();

    propList.add(
        MapUtil.put("id", "1-id")
            .put("fieldName", "id")
            .put("label", "ID")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("id", merchantObj.getId());

    propList.add(
        MapUtil.put("id", "2-name")
            .put("fieldName", "name")
            .put("label", "名称")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("name", merchantObj.getName());

    propList.add(
        MapUtil.put("id", "3-driverLicenseNumber")
            .put("fieldName", "driverLicenseNumber")
            .put("label", "驾驶执照号码")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("driverLicenseNumber", merchantObj.getDriverLicenseNumber());

    propList.add(
        MapUtil.put("id", "4-contactNumber")
            .put("fieldName", "contactNumber")
            .put("label", "联系电话")
            .put("type", "mobile")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("contactNumber", merchantObj.getContactNumber());

    propList.add(
        MapUtil.put("id", "5-belongsTo")
            .put("fieldName", "belongsTo")
            .put("label", "属于")
            .put("type", "document")
            .put("linkToUrl", "transportFleetManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"document\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("belongsTo", merchantObj.getBelongsTo());

    // 处理 sectionList

    // 处理Section：transportTaskListSection
    Map transportTaskListSection =
        ListofUtils.buildSection(
            "transportTaskListSection",
            "运输任务列表",
            null,
            "",
            "__no_group",
            "transportTaskManager/listByDriver/" + merchantObjId + "/",
            "auto");
    sections.add(transportTaskListSection);

    result.put(
        "transportTaskListSection",
        ListofUtils.toShortList(merchantObj.getTransportTaskList(), "transportTask"));

    result.put("propList", propList);
    result.put("sectionList", sections);
    result.put("pageTitle", pageTitle);
    result.put("linkToUrl", linkToUrl);

    vscope
        .field("propList", SerializeScope.EXCLUDE())
        .field("sectionList", SerializeScope.EXCLUDE())
        .field("pageTitle", SerializeScope.EXCLUDE())
        .field("linkToUrl", SerializeScope.EXCLUDE());
    userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
    return BaseViewPage.serialize(result, vscope);
  }
}
