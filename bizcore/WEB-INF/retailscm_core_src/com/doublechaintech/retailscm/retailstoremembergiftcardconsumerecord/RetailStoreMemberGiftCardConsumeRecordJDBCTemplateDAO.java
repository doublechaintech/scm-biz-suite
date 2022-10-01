package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;

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

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class RetailStoreMemberGiftCardConsumeRecordJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements RetailStoreMemberGiftCardConsumeRecordDAO {

  protected RetailStoreMemberGiftCardDAO retailStoreMemberGiftCardDAO;

  public void setRetailStoreMemberGiftCardDAO(
      RetailStoreMemberGiftCardDAO retailStoreMemberGiftCardDAO) {

    if (retailStoreMemberGiftCardDAO == null) {
      throw new IllegalStateException("Do not try to set retailStoreMemberGiftCardDAO to null.");
    }
    this.retailStoreMemberGiftCardDAO = retailStoreMemberGiftCardDAO;
  }

  public RetailStoreMemberGiftCardDAO getRetailStoreMemberGiftCardDAO() {
    if (this.retailStoreMemberGiftCardDAO == null) {
      throw new IllegalStateException(
          "The retailStoreMemberGiftCardDAO is not configured yet, please config it some where.");
    }

    return this.retailStoreMemberGiftCardDAO;
  }

  protected ConsumerOrderDAO consumerOrderDAO;

  public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO) {

    if (consumerOrderDAO == null) {
      throw new IllegalStateException("Do not try to set consumerOrderDAO to null.");
    }
    this.consumerOrderDAO = consumerOrderDAO;
  }

  public ConsumerOrderDAO getConsumerOrderDAO() {
    if (this.consumerOrderDAO == null) {
      throw new IllegalStateException(
          "The consumerOrderDAO is not configured yet, please config it some where.");
    }

    return this.consumerOrderDAO;
  }

  /*
  protected RetailStoreMemberGiftCardConsumeRecord load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalRetailStoreMemberGiftCardConsumeRecord(accessKey, options);
  }
  */

  public SmartList<RetailStoreMemberGiftCardConsumeRecord> loadAll() {
    return this.loadAll(getRetailStoreMemberGiftCardConsumeRecordMapper());
  }

  public Stream<RetailStoreMemberGiftCardConsumeRecord> loadAllAsStream() {
    return this.loadAllAsStream(getRetailStoreMemberGiftCardConsumeRecordMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public RetailStoreMemberGiftCardConsumeRecord load(String id, Map<String, Object> options)
      throws Exception {
    return loadInternalRetailStoreMemberGiftCardConsumeRecord(
        RetailStoreMemberGiftCardConsumeRecordTable.withId(id), options);
  }

  public RetailStoreMemberGiftCardConsumeRecord save(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,
      Map<String, Object> options) {

    String methodName =
        "save(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,Map<String,Object> options)";

    assertMethodArgumentNotNull(
        retailStoreMemberGiftCardConsumeRecord,
        methodName,
        "retailStoreMemberGiftCardConsumeRecord");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalRetailStoreMemberGiftCardConsumeRecord(
        retailStoreMemberGiftCardConsumeRecord, options);
  }

  public RetailStoreMemberGiftCardConsumeRecord clone(
      String retailStoreMemberGiftCardConsumeRecordId, Map<String, Object> options)
      throws Exception {

    return clone(
        RetailStoreMemberGiftCardConsumeRecordTable.withId(
            retailStoreMemberGiftCardConsumeRecordId),
        options);
  }

  protected RetailStoreMemberGiftCardConsumeRecord clone(
      AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName =
        "clone(String retailStoreMemberGiftCardConsumeRecordId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    RetailStoreMemberGiftCardConsumeRecord newRetailStoreMemberGiftCardConsumeRecord =
        loadInternalRetailStoreMemberGiftCardConsumeRecord(accessKey, options);
    newRetailStoreMemberGiftCardConsumeRecord.setVersion(0);

    saveInternalRetailStoreMemberGiftCardConsumeRecord(
        newRetailStoreMemberGiftCardConsumeRecord, options);

    return newRetailStoreMemberGiftCardConsumeRecord;
  }

  protected void throwIfHasException(
      String retailStoreMemberGiftCardConsumeRecordId, int version, int count) throws Exception {
    if (count == 1) {
      throw new RetailStoreMemberGiftCardConsumeRecordVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new RetailStoreMemberGiftCardConsumeRecordNotFoundException(
          "The "
              + this.getTableName()
              + "("
              + retailStoreMemberGiftCardConsumeRecordId
              + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public RetailStoreMemberGiftCardConsumeRecord disconnectFromAll(
      String retailStoreMemberGiftCardConsumeRecordId, int version) throws Exception {

    RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
        loadInternalRetailStoreMemberGiftCardConsumeRecord(
            RetailStoreMemberGiftCardConsumeRecordTable.withId(
                retailStoreMemberGiftCardConsumeRecordId),
            emptyOptions());
    retailStoreMemberGiftCardConsumeRecord.clearFromAll();
    this.saveRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecord);
    return retailStoreMemberGiftCardConsumeRecord;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return RetailStoreMemberGiftCardConsumeRecordTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "retail_store_member_gift_card_consume_record";
  }

  @Override
  protected String getBeanName() {

    return "retailStoreMemberGiftCardConsumeRecord";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return RetailStoreMemberGiftCardConsumeRecordTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractOwnerEnabled(Map<String, Object> options) {

    return checkOptions(options, RetailStoreMemberGiftCardConsumeRecordTokens.OWNER);
  }

  protected boolean isSaveOwnerEnabled(Map<String, Object> options) {

    return checkOptions(options, RetailStoreMemberGiftCardConsumeRecordTokens.OWNER);
  }

  protected boolean isExtractBizOrderEnabled(Map<String, Object> options) {

    return checkOptions(options, RetailStoreMemberGiftCardConsumeRecordTokens.BIZORDER);
  }

  protected boolean isSaveBizOrderEnabled(Map<String, Object> options) {

    return checkOptions(options, RetailStoreMemberGiftCardConsumeRecordTokens.BIZORDER);
  }

  protected RetailStoreMemberGiftCardConsumeRecordMapper
      getRetailStoreMemberGiftCardConsumeRecordMapper() {
    return new RetailStoreMemberGiftCardConsumeRecordMapper();
  }

  protected RetailStoreMemberGiftCardConsumeRecord extractRetailStoreMemberGiftCardConsumeRecord(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
          loadSingleObject(accessKey, getRetailStoreMemberGiftCardConsumeRecordMapper());
      return retailStoreMemberGiftCardConsumeRecord;
    } catch (EmptyResultDataAccessException e) {
      throw new RetailStoreMemberGiftCardConsumeRecordNotFoundException(
          "RetailStoreMemberGiftCardConsumeRecord(" + accessKey + ") is not found!");
    }
  }

  protected RetailStoreMemberGiftCardConsumeRecord
      loadInternalRetailStoreMemberGiftCardConsumeRecord(
          AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord =
        extractRetailStoreMemberGiftCardConsumeRecord(accessKey, loadOptions);

    if (isExtractOwnerEnabled(loadOptions)) {
      extractOwner(retailStoreMemberGiftCardConsumeRecord, loadOptions);
    }

    if (isExtractBizOrderEnabled(loadOptions)) {
      extractBizOrder(retailStoreMemberGiftCardConsumeRecord, loadOptions);
    }

    return retailStoreMemberGiftCardConsumeRecord;
  }

  protected RetailStoreMemberGiftCardConsumeRecord extractOwner(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,
      Map<String, Object> options)
      throws Exception {

    if (retailStoreMemberGiftCardConsumeRecord.getOwner() == null) {
      return retailStoreMemberGiftCardConsumeRecord;
    }
    String ownerId = retailStoreMemberGiftCardConsumeRecord.getOwner().getId();
    if (ownerId == null) {
      return retailStoreMemberGiftCardConsumeRecord;
    }
    RetailStoreMemberGiftCard owner = getRetailStoreMemberGiftCardDAO().load(ownerId, options);
    if (owner != null) {
      retailStoreMemberGiftCardConsumeRecord.setOwner(owner);
    }

    return retailStoreMemberGiftCardConsumeRecord;
  }

  protected RetailStoreMemberGiftCardConsumeRecord extractBizOrder(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,
      Map<String, Object> options)
      throws Exception {

    if (retailStoreMemberGiftCardConsumeRecord.getBizOrder() == null) {
      return retailStoreMemberGiftCardConsumeRecord;
    }
    String bizOrderId = retailStoreMemberGiftCardConsumeRecord.getBizOrder().getId();
    if (bizOrderId == null) {
      return retailStoreMemberGiftCardConsumeRecord;
    }
    ConsumerOrder bizOrder = getConsumerOrderDAO().load(bizOrderId, options);
    if (bizOrder != null) {
      retailStoreMemberGiftCardConsumeRecord.setBizOrder(bizOrder);
    }

    return retailStoreMemberGiftCardConsumeRecord;
  }

  public SmartList<RetailStoreMemberGiftCardConsumeRecord>
      findRetailStoreMemberGiftCardConsumeRecordByOwner(
          String retailStoreMemberGiftCardId, Map<String, Object> options) {

    SmartList<RetailStoreMemberGiftCardConsumeRecord> resultList =
        queryWith(
            RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_OWNER,
            retailStoreMemberGiftCardId,
            options,
            getRetailStoreMemberGiftCardConsumeRecordMapper());
    // analyzeRetailStoreMemberGiftCardConsumeRecordByOwner(resultList, retailStoreMemberGiftCardId,
    // options);
    return resultList;
  }

  public SmartList<RetailStoreMemberGiftCardConsumeRecord>
      findRetailStoreMemberGiftCardConsumeRecordByOwner(
          String retailStoreMemberGiftCardId, int start, int count, Map<String, Object> options) {

    SmartList<RetailStoreMemberGiftCardConsumeRecord> resultList =
        queryWithRange(
            RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_OWNER,
            retailStoreMemberGiftCardId,
            options,
            getRetailStoreMemberGiftCardConsumeRecordMapper(),
            start,
            count);
    // analyzeRetailStoreMemberGiftCardConsumeRecordByOwner(resultList, retailStoreMemberGiftCardId,
    // options);
    return resultList;
  }

  public void analyzeRetailStoreMemberGiftCardConsumeRecordByOwner(
      SmartList<RetailStoreMemberGiftCardConsumeRecord> resultList,
      String retailStoreMemberGiftCardId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(
        RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY, retailStoreMemberGiftCardId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    resultList.setStatsInfo(info);
  }

  @Override
  public int countRetailStoreMemberGiftCardConsumeRecordByOwner(
      String retailStoreMemberGiftCardId, Map<String, Object> options) {

    return countWith(
        RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_OWNER,
        retailStoreMemberGiftCardId,
        options);
  }

  @Override
  public Map<String, Integer> countRetailStoreMemberGiftCardConsumeRecordByOwnerIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_OWNER, ids, options);
  }

  public SmartList<RetailStoreMemberGiftCardConsumeRecord>
      findRetailStoreMemberGiftCardConsumeRecordByBizOrder(
          String consumerOrderId, Map<String, Object> options) {

    SmartList<RetailStoreMemberGiftCardConsumeRecord> resultList =
        queryWith(
            RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_BIZ_ORDER,
            consumerOrderId,
            options,
            getRetailStoreMemberGiftCardConsumeRecordMapper());
    // analyzeRetailStoreMemberGiftCardConsumeRecordByBizOrder(resultList, consumerOrderId,
    // options);
    return resultList;
  }

  public SmartList<RetailStoreMemberGiftCardConsumeRecord>
      findRetailStoreMemberGiftCardConsumeRecordByBizOrder(
          String consumerOrderId, int start, int count, Map<String, Object> options) {

    SmartList<RetailStoreMemberGiftCardConsumeRecord> resultList =
        queryWithRange(
            RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_BIZ_ORDER,
            consumerOrderId,
            options,
            getRetailStoreMemberGiftCardConsumeRecordMapper(),
            start,
            count);
    // analyzeRetailStoreMemberGiftCardConsumeRecordByBizOrder(resultList, consumerOrderId,
    // options);
    return resultList;
  }

  public void analyzeRetailStoreMemberGiftCardConsumeRecordByBizOrder(
      SmartList<RetailStoreMemberGiftCardConsumeRecord> resultList,
      String consumerOrderId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY, consumerOrderId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    resultList.setStatsInfo(info);
  }

  @Override
  public int countRetailStoreMemberGiftCardConsumeRecordByBizOrder(
      String consumerOrderId, Map<String, Object> options) {

    return countWith(
        RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_BIZ_ORDER, consumerOrderId, options);
  }

  @Override
  public Map<String, Integer> countRetailStoreMemberGiftCardConsumeRecordByBizOrderIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_BIZ_ORDER, ids, options);
  }

  protected RetailStoreMemberGiftCardConsumeRecord saveRetailStoreMemberGiftCardConsumeRecord(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) {

    if (!retailStoreMemberGiftCardConsumeRecord.isChanged()) {
      return retailStoreMemberGiftCardConsumeRecord;
    }

    Beans.dbUtil().cacheCleanUp(retailStoreMemberGiftCardConsumeRecord);
    String SQL =
        this.getSaveRetailStoreMemberGiftCardConsumeRecordSQL(
            retailStoreMemberGiftCardConsumeRecord);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters =
        getSaveRetailStoreMemberGiftCardConsumeRecordParameters(
            retailStoreMemberGiftCardConsumeRecord);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    retailStoreMemberGiftCardConsumeRecord.incVersion();
    retailStoreMemberGiftCardConsumeRecord.afterSave();
    return retailStoreMemberGiftCardConsumeRecord;
  }

  public SmartList<RetailStoreMemberGiftCardConsumeRecord>
      saveRetailStoreMemberGiftCardConsumeRecordList(
          SmartList<RetailStoreMemberGiftCardConsumeRecord>
              retailStoreMemberGiftCardConsumeRecordList,
          Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists =
        splitRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCardConsumeRecordList);

    batchRetailStoreMemberGiftCardConsumeRecordCreate(
        (List<RetailStoreMemberGiftCardConsumeRecord>) lists[CREATE_LIST_INDEX]);
    batchRetailStoreMemberGiftCardConsumeRecordUpdate(
        (List<RetailStoreMemberGiftCardConsumeRecord>) lists[UPDATE_LIST_INDEX]);
    batchRetailStoreMemberGiftCardConsumeRecordRemove(
        (List<RetailStoreMemberGiftCardConsumeRecord>) lists[REMOVE_LIST_INDEX]);
    batchRetailStoreMemberGiftCardConsumeRecordRecover(
        (List<RetailStoreMemberGiftCardConsumeRecord>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord :
        retailStoreMemberGiftCardConsumeRecordList) {
      if (retailStoreMemberGiftCardConsumeRecord.isChanged()) {
        retailStoreMemberGiftCardConsumeRecord.incVersion();
        retailStoreMemberGiftCardConsumeRecord.afterSave();
      }
      if (retailStoreMemberGiftCardConsumeRecord.isToRecover()
          || retailStoreMemberGiftCardConsumeRecord.isToRemove()) {
        retailStoreMemberGiftCardConsumeRecord.setVersion(
            -retailStoreMemberGiftCardConsumeRecord.getVersion());
      }
    }

    return retailStoreMemberGiftCardConsumeRecordList;
  }

  public SmartList<RetailStoreMemberGiftCardConsumeRecord>
      removeRetailStoreMemberGiftCardConsumeRecordList(
          SmartList<RetailStoreMemberGiftCardConsumeRecord>
              retailStoreMemberGiftCardConsumeRecordList,
          Map<String, Object> options) {

    super.removeList(retailStoreMemberGiftCardConsumeRecordList, options);

    return retailStoreMemberGiftCardConsumeRecordList;
  }

  protected List<Object[]> prepareRetailStoreMemberGiftCardConsumeRecordBatchCreateArgs(
      List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord :
        retailStoreMemberGiftCardConsumeRecordList) {
      Object[] parameters =
          prepareRetailStoreMemberGiftCardConsumeRecordCreateParameters(
              retailStoreMemberGiftCardConsumeRecord);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreMemberGiftCardConsumeRecordBatchUpdateArgs(
      List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord :
        retailStoreMemberGiftCardConsumeRecordList) {
      if (!retailStoreMemberGiftCardConsumeRecord.isChanged()) {
        continue;
      }
      Object[] parameters =
          prepareRetailStoreMemberGiftCardConsumeRecordUpdateParameters(
              retailStoreMemberGiftCardConsumeRecord);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreMemberGiftCardConsumeRecordBatchRecoverArgs(
      List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord :
        retailStoreMemberGiftCardConsumeRecordList) {
      if (!retailStoreMemberGiftCardConsumeRecord.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(retailStoreMemberGiftCardConsumeRecord);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreMemberGiftCardConsumeRecordBatchRemoveArgs(
      List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord :
        retailStoreMemberGiftCardConsumeRecordList) {
      if (!retailStoreMemberGiftCardConsumeRecord.isToRemove()) {
        continue;
      }
      Object[] parameters =
          prepareRetailStoreMemberGiftCardConsumeRecordRemoveParameters(
              retailStoreMemberGiftCardConsumeRecord);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchRetailStoreMemberGiftCardConsumeRecordCreate(
      List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList) {
    String SQL = getCreateSQL();
    List<Object[]> args =
        prepareRetailStoreMemberGiftCardConsumeRecordBatchCreateArgs(
            retailStoreMemberGiftCardConsumeRecordList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchRetailStoreMemberGiftCardConsumeRecordUpdate(
      List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList) {
    String SQL = getUpdateSQL();
    List<Object[]> args =
        prepareRetailStoreMemberGiftCardConsumeRecordBatchUpdateArgs(
            retailStoreMemberGiftCardConsumeRecordList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchRetailStoreMemberGiftCardConsumeRecordRemove(
      List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList) {
    String SQL = getRemoveSQL();
    List<Object[]> args =
        prepareRetailStoreMemberGiftCardConsumeRecordBatchRemoveArgs(
            retailStoreMemberGiftCardConsumeRecordList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchRetailStoreMemberGiftCardConsumeRecordRecover(
      List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList) {
    String SQL = getRecoverSQL();
    List<Object[]> args =
        prepareRetailStoreMemberGiftCardConsumeRecordBatchRecoverArgs(
            retailStoreMemberGiftCardConsumeRecordList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitRetailStoreMemberGiftCardConsumeRecordList(
      List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList) {

    List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordCreateList =
        new ArrayList<RetailStoreMemberGiftCardConsumeRecord>();
    List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordUpdateList =
        new ArrayList<RetailStoreMemberGiftCardConsumeRecord>();
    List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordRemoveList =
        new ArrayList<RetailStoreMemberGiftCardConsumeRecord>();
    List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordRecoverList =
        new ArrayList<RetailStoreMemberGiftCardConsumeRecord>();

    for (RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord :
        retailStoreMemberGiftCardConsumeRecordList) {
      if (retailStoreMemberGiftCardConsumeRecord.isToRemove()) {
        retailStoreMemberGiftCardConsumeRecordRemoveList.add(
            retailStoreMemberGiftCardConsumeRecord);
        continue;
      }
      if (retailStoreMemberGiftCardConsumeRecord.isToRecover()) {
        retailStoreMemberGiftCardConsumeRecordRecoverList.add(
            retailStoreMemberGiftCardConsumeRecord);
        continue;
      }
      if (isUpdateRequest(retailStoreMemberGiftCardConsumeRecord)) {
        if (retailStoreMemberGiftCardConsumeRecord.isChanged()) {
          retailStoreMemberGiftCardConsumeRecordUpdateList.add(
              retailStoreMemberGiftCardConsumeRecord);
        }
        continue;
      }

      if (retailStoreMemberGiftCardConsumeRecord.isChanged()) {
        retailStoreMemberGiftCardConsumeRecordCreateList.add(
            retailStoreMemberGiftCardConsumeRecord);
      }
    }

    return new Object[] {
      retailStoreMemberGiftCardConsumeRecordCreateList,
      retailStoreMemberGiftCardConsumeRecordUpdateList,
      retailStoreMemberGiftCardConsumeRecordRemoveList,
      retailStoreMemberGiftCardConsumeRecordRecoverList
    };
  }

  protected boolean isUpdateRequest(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) {
    return retailStoreMemberGiftCardConsumeRecord.getVersion() > 0;
  }

  protected String getSaveRetailStoreMemberGiftCardConsumeRecordSQL(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) {
    if (retailStoreMemberGiftCardConsumeRecord.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(retailStoreMemberGiftCardConsumeRecord)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveRetailStoreMemberGiftCardConsumeRecordParameters(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) {
    if (retailStoreMemberGiftCardConsumeRecord.isToRemove()) {
      return prepareRetailStoreMemberGiftCardConsumeRecordRemoveParameters(
          retailStoreMemberGiftCardConsumeRecord);
    }
    if (retailStoreMemberGiftCardConsumeRecord.isToRecover()) {
      return prepareRecoverParameters(retailStoreMemberGiftCardConsumeRecord);
    }

    if (isUpdateRequest(retailStoreMemberGiftCardConsumeRecord)) {
      return prepareRetailStoreMemberGiftCardConsumeRecordUpdateParameters(
          retailStoreMemberGiftCardConsumeRecord);
    }
    return prepareRetailStoreMemberGiftCardConsumeRecordCreateParameters(
        retailStoreMemberGiftCardConsumeRecord);
  }

  protected Object[] prepareRetailStoreMemberGiftCardConsumeRecordRemoveParameters(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) {
    return super.prepareRemoveParameters(retailStoreMemberGiftCardConsumeRecord);
  }

  protected Object[] prepareRetailStoreMemberGiftCardConsumeRecordUpdateParameters(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) {
    Object[] parameters = new Object[8];

    parameters[0] = retailStoreMemberGiftCardConsumeRecord.getOccureTime();

    if (retailStoreMemberGiftCardConsumeRecord.getOwner() != null) {
      parameters[1] = retailStoreMemberGiftCardConsumeRecord.getOwner().getId();
    }

    if (retailStoreMemberGiftCardConsumeRecord.getBizOrder() != null) {
      parameters[2] = retailStoreMemberGiftCardConsumeRecord.getBizOrder().getId();
    }

    parameters[3] = retailStoreMemberGiftCardConsumeRecord.getNumber();

    parameters[4] = retailStoreMemberGiftCardConsumeRecord.getAmount();

    parameters[5] = retailStoreMemberGiftCardConsumeRecord.nextVersion();
    parameters[6] = retailStoreMemberGiftCardConsumeRecord.getId();
    parameters[7] = retailStoreMemberGiftCardConsumeRecord.getVersion();

    return parameters;
  }

  protected Object[] prepareRetailStoreMemberGiftCardConsumeRecordCreateParameters(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) {
    Object[] parameters = new Object[6];
    if (retailStoreMemberGiftCardConsumeRecord.getId() == null) {
      String newRetailStoreMemberGiftCardConsumeRecordId = getNextId();
      retailStoreMemberGiftCardConsumeRecord.setId(newRetailStoreMemberGiftCardConsumeRecordId);
    }
    parameters[0] = retailStoreMemberGiftCardConsumeRecord.getId();

    parameters[1] = retailStoreMemberGiftCardConsumeRecord.getOccureTime();

    if (retailStoreMemberGiftCardConsumeRecord.getOwner() != null) {
      parameters[2] = retailStoreMemberGiftCardConsumeRecord.getOwner().getId();
    }

    if (retailStoreMemberGiftCardConsumeRecord.getBizOrder() != null) {
      parameters[3] = retailStoreMemberGiftCardConsumeRecord.getBizOrder().getId();
    }

    parameters[4] = retailStoreMemberGiftCardConsumeRecord.getNumber();

    parameters[5] = retailStoreMemberGiftCardConsumeRecord.getAmount();

    return parameters;
  }

  protected RetailStoreMemberGiftCardConsumeRecord
      saveInternalRetailStoreMemberGiftCardConsumeRecord(
          RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,
          Map<String, Object> options) {

    if (isSaveOwnerEnabled(options)) {
      saveOwner(retailStoreMemberGiftCardConsumeRecord, options);
    }

    if (isSaveBizOrderEnabled(options)) {
      saveBizOrder(retailStoreMemberGiftCardConsumeRecord, options);
    }

    saveRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecord);

    return retailStoreMemberGiftCardConsumeRecord;
  }

  // ======================================================================================

  protected RetailStoreMemberGiftCardConsumeRecord saveOwner(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,
      Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (retailStoreMemberGiftCardConsumeRecord.getOwner() == null) {
      return retailStoreMemberGiftCardConsumeRecord; // do nothing when it is null
    }

    getRetailStoreMemberGiftCardDAO()
        .save(retailStoreMemberGiftCardConsumeRecord.getOwner(), options);
    return retailStoreMemberGiftCardConsumeRecord;
  }

  protected RetailStoreMemberGiftCardConsumeRecord saveBizOrder(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,
      Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (retailStoreMemberGiftCardConsumeRecord.getBizOrder() == null) {
      return retailStoreMemberGiftCardConsumeRecord; // do nothing when it is null
    }

    getConsumerOrderDAO().save(retailStoreMemberGiftCardConsumeRecord.getBizOrder(), options);
    return retailStoreMemberGiftCardConsumeRecord;
  }

  public RetailStoreMemberGiftCardConsumeRecord present(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,
      Map<String, Object> options) {

    return retailStoreMemberGiftCardConsumeRecord;
  }

  protected String getTableName() {
    return RetailStoreMemberGiftCardConsumeRecordTable.TABLE_NAME;
  }

  public void enhanceList(
      List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList) {
    this.enhanceListInternal(
        retailStoreMemberGiftCardConsumeRecordList,
        this.getRetailStoreMemberGiftCardConsumeRecordMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList =
        ownerEntity.collectRefsWithType(RetailStoreMemberGiftCardConsumeRecord.INTERNAL_TYPE);
    this.enhanceList(retailStoreMemberGiftCardConsumeRecordList);
  }

  @Override
  public SmartList<RetailStoreMemberGiftCardConsumeRecord>
      findRetailStoreMemberGiftCardConsumeRecordWithKey(
          MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getRetailStoreMemberGiftCardConsumeRecordMapper());
  }

  @Override
  public int countRetailStoreMemberGiftCardConsumeRecordWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countRetailStoreMemberGiftCardConsumeRecordWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<RetailStoreMemberGiftCardConsumeRecord> queryList(
      String sql, Object... parameters) {
    return this.queryForList(
        sql, parameters, this.getRetailStoreMemberGiftCardConsumeRecordMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<RetailStoreMemberGiftCardConsumeRecord> queryStream(
      String sql, Object... parameters) {
    return this.queryForStream(
        sql, parameters, this.getRetailStoreMemberGiftCardConsumeRecordMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateRetailStoreMemberGiftCardConsumeRecord executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateRetailStoreMemberGiftCardConsumeRecord result =
        new CandidateRetailStoreMemberGiftCardConsumeRecord();
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
  public List<RetailStoreMemberGiftCardConsumeRecord> search(
      RetailStoreMemberGiftCardConsumeRecordRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected RetailStoreMemberGiftCardConsumeRecordMapper mapper() {
    return getRetailStoreMemberGiftCardConsumeRecordMapper();
  }

  @Override
  protected RetailStoreMemberGiftCardConsumeRecordMapper mapperForClazz(Class<?> clazz) {
    return RetailStoreMemberGiftCardConsumeRecordMapper.mapperForClass(clazz);
  }
}
