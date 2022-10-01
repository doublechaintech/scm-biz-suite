package com.doublechaintech.retailscm.retailstoremembergiftcard;

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

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;

import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordDAO;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class RetailStoreMemberGiftCardJDBCTemplateDAO extends RetailscmBaseDAOImpl
    implements RetailStoreMemberGiftCardDAO {

  protected RetailStoreMemberDAO retailStoreMemberDAO;

  public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO) {

    if (retailStoreMemberDAO == null) {
      throw new IllegalStateException("Do not try to set retailStoreMemberDAO to null.");
    }
    this.retailStoreMemberDAO = retailStoreMemberDAO;
  }

  public RetailStoreMemberDAO getRetailStoreMemberDAO() {
    if (this.retailStoreMemberDAO == null) {
      throw new IllegalStateException(
          "The retailStoreMemberDAO is not configured yet, please config it some where.");
    }

    return this.retailStoreMemberDAO;
  }

  protected RetailStoreMemberGiftCardConsumeRecordDAO retailStoreMemberGiftCardConsumeRecordDAO;

  public void setRetailStoreMemberGiftCardConsumeRecordDAO(
      RetailStoreMemberGiftCardConsumeRecordDAO retailStoreMemberGiftCardConsumeRecordDAO) {

    if (retailStoreMemberGiftCardConsumeRecordDAO == null) {
      throw new IllegalStateException(
          "Do not try to set retailStoreMemberGiftCardConsumeRecordDAO to null.");
    }
    this.retailStoreMemberGiftCardConsumeRecordDAO = retailStoreMemberGiftCardConsumeRecordDAO;
  }

  public RetailStoreMemberGiftCardConsumeRecordDAO getRetailStoreMemberGiftCardConsumeRecordDAO() {
    if (this.retailStoreMemberGiftCardConsumeRecordDAO == null) {
      throw new IllegalStateException(
          "The retailStoreMemberGiftCardConsumeRecordDAO is not configured yet, please config it some where.");
    }

    return this.retailStoreMemberGiftCardConsumeRecordDAO;
  }

  /*
  protected RetailStoreMemberGiftCard load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalRetailStoreMemberGiftCard(accessKey, options);
  }
  */

  public SmartList<RetailStoreMemberGiftCard> loadAll() {
    return this.loadAll(getRetailStoreMemberGiftCardMapper());
  }

  public Stream<RetailStoreMemberGiftCard> loadAllAsStream() {
    return this.loadAllAsStream(getRetailStoreMemberGiftCardMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public RetailStoreMemberGiftCard load(String id, Map<String, Object> options) throws Exception {
    return loadInternalRetailStoreMemberGiftCard(
        RetailStoreMemberGiftCardTable.withId(id), options);
  }

  public RetailStoreMemberGiftCard save(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> options) {

    String methodName =
        "save(RetailStoreMemberGiftCard retailStoreMemberGiftCard,Map<String,Object> options)";

    assertMethodArgumentNotNull(retailStoreMemberGiftCard, methodName, "retailStoreMemberGiftCard");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalRetailStoreMemberGiftCard(retailStoreMemberGiftCard, options);
  }

  public RetailStoreMemberGiftCard clone(
      String retailStoreMemberGiftCardId, Map<String, Object> options) throws Exception {

    return clone(RetailStoreMemberGiftCardTable.withId(retailStoreMemberGiftCardId), options);
  }

  protected RetailStoreMemberGiftCard clone(AccessKey accessKey, Map<String, Object> options)
      throws Exception {

    String methodName = "clone(String retailStoreMemberGiftCardId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    RetailStoreMemberGiftCard newRetailStoreMemberGiftCard =
        loadInternalRetailStoreMemberGiftCard(accessKey, options);
    newRetailStoreMemberGiftCard.setVersion(0);

    if (isSaveRetailStoreMemberGiftCardConsumeRecordListEnabled(options)) {
      for (RetailStoreMemberGiftCardConsumeRecord item :
          newRetailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList()) {
        item.setVersion(0);
      }
    }

    saveInternalRetailStoreMemberGiftCard(newRetailStoreMemberGiftCard, options);

    return newRetailStoreMemberGiftCard;
  }

  protected void throwIfHasException(String retailStoreMemberGiftCardId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new RetailStoreMemberGiftCardVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new RetailStoreMemberGiftCardNotFoundException(
          "The "
              + this.getTableName()
              + "("
              + retailStoreMemberGiftCardId
              + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public RetailStoreMemberGiftCard disconnectFromAll(
      String retailStoreMemberGiftCardId, int version) throws Exception {

    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        loadInternalRetailStoreMemberGiftCard(
            RetailStoreMemberGiftCardTable.withId(retailStoreMemberGiftCardId), emptyOptions());
    retailStoreMemberGiftCard.clearFromAll();
    this.saveRetailStoreMemberGiftCard(retailStoreMemberGiftCard);
    return retailStoreMemberGiftCard;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return RetailStoreMemberGiftCardTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "retail_store_member_gift_card";
  }

  @Override
  protected String getBeanName() {

    return "retailStoreMemberGiftCard";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return RetailStoreMemberGiftCardTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractOwnerEnabled(Map<String, Object> options) {

    return checkOptions(options, RetailStoreMemberGiftCardTokens.OWNER);
  }

  protected boolean isSaveOwnerEnabled(Map<String, Object> options) {

    return checkOptions(options, RetailStoreMemberGiftCardTokens.OWNER);
  }

  protected boolean isExtractRetailStoreMemberGiftCardConsumeRecordListEnabled(
      Map<String, Object> options) {
    return checkOptions(
        options, RetailStoreMemberGiftCardTokens.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
  }

  protected boolean isAnalyzeRetailStoreMemberGiftCardConsumeRecordListEnabled(
      Map<String, Object> options) {
    return RetailStoreMemberGiftCardTokens.of(options)
        .analyzeRetailStoreMemberGiftCardConsumeRecordListEnabled();
  }

  protected boolean isSaveRetailStoreMemberGiftCardConsumeRecordListEnabled(
      Map<String, Object> options) {
    return checkOptions(
        options, RetailStoreMemberGiftCardTokens.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
  }

  protected RetailStoreMemberGiftCardMapper getRetailStoreMemberGiftCardMapper() {
    return new RetailStoreMemberGiftCardMapper();
  }

  protected RetailStoreMemberGiftCard extractRetailStoreMemberGiftCard(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {
    try {
      RetailStoreMemberGiftCard retailStoreMemberGiftCard =
          loadSingleObject(accessKey, getRetailStoreMemberGiftCardMapper());
      return retailStoreMemberGiftCard;
    } catch (EmptyResultDataAccessException e) {
      throw new RetailStoreMemberGiftCardNotFoundException(
          "RetailStoreMemberGiftCard(" + accessKey + ") is not found!");
    }
  }

  protected RetailStoreMemberGiftCard loadInternalRetailStoreMemberGiftCard(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    RetailStoreMemberGiftCard retailStoreMemberGiftCard =
        extractRetailStoreMemberGiftCard(accessKey, loadOptions);

    if (isExtractOwnerEnabled(loadOptions)) {
      extractOwner(retailStoreMemberGiftCard, loadOptions);
    }

    if (isExtractRetailStoreMemberGiftCardConsumeRecordListEnabled(loadOptions)) {
      extractRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCard, loadOptions);
    }

    if (isAnalyzeRetailStoreMemberGiftCardConsumeRecordListEnabled(loadOptions)) {
      analyzeRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCard, loadOptions);
    }

    return retailStoreMemberGiftCard;
  }

  protected RetailStoreMemberGiftCard extractOwner(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> options)
      throws Exception {

    if (retailStoreMemberGiftCard.getOwner() == null) {
      return retailStoreMemberGiftCard;
    }
    String ownerId = retailStoreMemberGiftCard.getOwner().getId();
    if (ownerId == null) {
      return retailStoreMemberGiftCard;
    }
    RetailStoreMember owner = getRetailStoreMemberDAO().load(ownerId, options);
    if (owner != null) {
      retailStoreMemberGiftCard.setOwner(owner);
    }

    return retailStoreMemberGiftCard;
  }

  protected void enhanceRetailStoreMemberGiftCardConsumeRecordList(
      SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList,
      Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected RetailStoreMemberGiftCard extractRetailStoreMemberGiftCardConsumeRecordList(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> options) {

    if (retailStoreMemberGiftCard == null) {
      return null;
    }
    if (retailStoreMemberGiftCard.getId() == null) {
      return retailStoreMemberGiftCard;
    }

    SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList =
        getRetailStoreMemberGiftCardConsumeRecordDAO()
            .findRetailStoreMemberGiftCardConsumeRecordByOwner(
                retailStoreMemberGiftCard.getId(), options);
    if (retailStoreMemberGiftCardConsumeRecordList != null) {
      enhanceRetailStoreMemberGiftCardConsumeRecordList(
          retailStoreMemberGiftCardConsumeRecordList, options);
      retailStoreMemberGiftCard.setRetailStoreMemberGiftCardConsumeRecordList(
          retailStoreMemberGiftCardConsumeRecordList);
    }

    return retailStoreMemberGiftCard;
  }

  protected RetailStoreMemberGiftCard analyzeRetailStoreMemberGiftCardConsumeRecordList(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> options) {

    if (retailStoreMemberGiftCard == null) {
      return null;
    }
    if (retailStoreMemberGiftCard.getId() == null) {
      return retailStoreMemberGiftCard;
    }

    SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList =
        retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList();
    if (retailStoreMemberGiftCardConsumeRecordList != null) {
      getRetailStoreMemberGiftCardConsumeRecordDAO()
          .analyzeRetailStoreMemberGiftCardConsumeRecordByOwner(
              retailStoreMemberGiftCardConsumeRecordList,
              retailStoreMemberGiftCard.getId(),
              options);
    }

    return retailStoreMemberGiftCard;
  }

  public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardByOwner(
      String retailStoreMemberId, Map<String, Object> options) {

    SmartList<RetailStoreMemberGiftCard> resultList =
        queryWith(
            RetailStoreMemberGiftCardTable.COLUMN_OWNER,
            retailStoreMemberId,
            options,
            getRetailStoreMemberGiftCardMapper());
    // analyzeRetailStoreMemberGiftCardByOwner(resultList, retailStoreMemberId, options);
    return resultList;
  }

  public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardByOwner(
      String retailStoreMemberId, int start, int count, Map<String, Object> options) {

    SmartList<RetailStoreMemberGiftCard> resultList =
        queryWithRange(
            RetailStoreMemberGiftCardTable.COLUMN_OWNER,
            retailStoreMemberId,
            options,
            getRetailStoreMemberGiftCardMapper(),
            start,
            count);
    // analyzeRetailStoreMemberGiftCardByOwner(resultList, retailStoreMemberId, options);
    return resultList;
  }

  public void analyzeRetailStoreMemberGiftCardByOwner(
      SmartList<RetailStoreMemberGiftCard> resultList,
      String retailStoreMemberId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countRetailStoreMemberGiftCardByOwner(
      String retailStoreMemberId, Map<String, Object> options) {

    return countWith(RetailStoreMemberGiftCardTable.COLUMN_OWNER, retailStoreMemberId, options);
  }

  @Override
  public Map<String, Integer> countRetailStoreMemberGiftCardByOwnerIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(RetailStoreMemberGiftCardTable.COLUMN_OWNER, ids, options);
  }

  protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCard(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard) {

    if (!retailStoreMemberGiftCard.isChanged()) {
      return retailStoreMemberGiftCard;
    }

    Beans.dbUtil().cacheCleanUp(retailStoreMemberGiftCard);
    String SQL = this.getSaveRetailStoreMemberGiftCardSQL(retailStoreMemberGiftCard);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveRetailStoreMemberGiftCardParameters(retailStoreMemberGiftCard);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    retailStoreMemberGiftCard.incVersion();
    retailStoreMemberGiftCard.afterSave();
    return retailStoreMemberGiftCard;
  }

  public SmartList<RetailStoreMemberGiftCard> saveRetailStoreMemberGiftCardList(
      SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,
      Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitRetailStoreMemberGiftCardList(retailStoreMemberGiftCardList);

    batchRetailStoreMemberGiftCardCreate(
        (List<RetailStoreMemberGiftCard>) lists[CREATE_LIST_INDEX]);
    batchRetailStoreMemberGiftCardUpdate(
        (List<RetailStoreMemberGiftCard>) lists[UPDATE_LIST_INDEX]);
    batchRetailStoreMemberGiftCardRemove(
        (List<RetailStoreMemberGiftCard>) lists[REMOVE_LIST_INDEX]);
    batchRetailStoreMemberGiftCardRecover(
        (List<RetailStoreMemberGiftCard>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (RetailStoreMemberGiftCard retailStoreMemberGiftCard : retailStoreMemberGiftCardList) {
      if (retailStoreMemberGiftCard.isChanged()) {
        retailStoreMemberGiftCard.incVersion();
        retailStoreMemberGiftCard.afterSave();
      }
      if (retailStoreMemberGiftCard.isToRecover() || retailStoreMemberGiftCard.isToRemove()) {
        retailStoreMemberGiftCard.setVersion(-retailStoreMemberGiftCard.getVersion());
      }
    }

    return retailStoreMemberGiftCardList;
  }

  public SmartList<RetailStoreMemberGiftCard> removeRetailStoreMemberGiftCardList(
      SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,
      Map<String, Object> options) {

    super.removeList(retailStoreMemberGiftCardList, options);

    return retailStoreMemberGiftCardList;
  }

  protected List<Object[]> prepareRetailStoreMemberGiftCardBatchCreateArgs(
      List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreMemberGiftCard retailStoreMemberGiftCard : retailStoreMemberGiftCardList) {
      Object[] parameters =
          prepareRetailStoreMemberGiftCardCreateParameters(retailStoreMemberGiftCard);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreMemberGiftCardBatchUpdateArgs(
      List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreMemberGiftCard retailStoreMemberGiftCard : retailStoreMemberGiftCardList) {
      if (!retailStoreMemberGiftCard.isChanged()) {
        continue;
      }
      Object[] parameters =
          prepareRetailStoreMemberGiftCardUpdateParameters(retailStoreMemberGiftCard);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreMemberGiftCardBatchRecoverArgs(
      List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreMemberGiftCard retailStoreMemberGiftCard : retailStoreMemberGiftCardList) {
      if (!retailStoreMemberGiftCard.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(retailStoreMemberGiftCard);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareRetailStoreMemberGiftCardBatchRemoveArgs(
      List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (RetailStoreMemberGiftCard retailStoreMemberGiftCard : retailStoreMemberGiftCardList) {
      if (!retailStoreMemberGiftCard.isToRemove()) {
        continue;
      }
      Object[] parameters =
          prepareRetailStoreMemberGiftCardRemoveParameters(retailStoreMemberGiftCard);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchRetailStoreMemberGiftCardCreate(
      List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList) {
    String SQL = getCreateSQL();
    List<Object[]> args =
        prepareRetailStoreMemberGiftCardBatchCreateArgs(retailStoreMemberGiftCardList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchRetailStoreMemberGiftCardUpdate(
      List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList) {
    String SQL = getUpdateSQL();
    List<Object[]> args =
        prepareRetailStoreMemberGiftCardBatchUpdateArgs(retailStoreMemberGiftCardList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchRetailStoreMemberGiftCardRemove(
      List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList) {
    String SQL = getRemoveSQL();
    List<Object[]> args =
        prepareRetailStoreMemberGiftCardBatchRemoveArgs(retailStoreMemberGiftCardList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchRetailStoreMemberGiftCardRecover(
      List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList) {
    String SQL = getRecoverSQL();
    List<Object[]> args =
        prepareRetailStoreMemberGiftCardBatchRecoverArgs(retailStoreMemberGiftCardList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitRetailStoreMemberGiftCardList(
      List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList) {

    List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardCreateList =
        new ArrayList<RetailStoreMemberGiftCard>();
    List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardUpdateList =
        new ArrayList<RetailStoreMemberGiftCard>();
    List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardRemoveList =
        new ArrayList<RetailStoreMemberGiftCard>();
    List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardRecoverList =
        new ArrayList<RetailStoreMemberGiftCard>();

    for (RetailStoreMemberGiftCard retailStoreMemberGiftCard : retailStoreMemberGiftCardList) {
      if (retailStoreMemberGiftCard.isToRemove()) {
        retailStoreMemberGiftCardRemoveList.add(retailStoreMemberGiftCard);
        continue;
      }
      if (retailStoreMemberGiftCard.isToRecover()) {
        retailStoreMemberGiftCardRecoverList.add(retailStoreMemberGiftCard);
        continue;
      }
      if (isUpdateRequest(retailStoreMemberGiftCard)) {
        if (retailStoreMemberGiftCard.isChanged()) {
          retailStoreMemberGiftCardUpdateList.add(retailStoreMemberGiftCard);
        }
        continue;
      }

      if (retailStoreMemberGiftCard.isChanged()) {
        retailStoreMemberGiftCardCreateList.add(retailStoreMemberGiftCard);
      }
    }

    return new Object[] {
      retailStoreMemberGiftCardCreateList,
      retailStoreMemberGiftCardUpdateList,
      retailStoreMemberGiftCardRemoveList,
      retailStoreMemberGiftCardRecoverList
    };
  }

  protected boolean isUpdateRequest(RetailStoreMemberGiftCard retailStoreMemberGiftCard) {
    return retailStoreMemberGiftCard.getVersion() > 0;
  }

  protected String getSaveRetailStoreMemberGiftCardSQL(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard) {
    if (retailStoreMemberGiftCard.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(retailStoreMemberGiftCard)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveRetailStoreMemberGiftCardParameters(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard) {
    if (retailStoreMemberGiftCard.isToRemove()) {
      return prepareRetailStoreMemberGiftCardRemoveParameters(retailStoreMemberGiftCard);
    }
    if (retailStoreMemberGiftCard.isToRecover()) {
      return prepareRecoverParameters(retailStoreMemberGiftCard);
    }

    if (isUpdateRequest(retailStoreMemberGiftCard)) {
      return prepareRetailStoreMemberGiftCardUpdateParameters(retailStoreMemberGiftCard);
    }
    return prepareRetailStoreMemberGiftCardCreateParameters(retailStoreMemberGiftCard);
  }

  protected Object[] prepareRetailStoreMemberGiftCardRemoveParameters(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard) {
    return super.prepareRemoveParameters(retailStoreMemberGiftCard);
  }

  protected Object[] prepareRetailStoreMemberGiftCardUpdateParameters(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard) {
    Object[] parameters = new Object[7];

    parameters[0] = retailStoreMemberGiftCard.getName();

    if (retailStoreMemberGiftCard.getOwner() != null) {
      parameters[1] = retailStoreMemberGiftCard.getOwner().getId();
    }

    parameters[2] = retailStoreMemberGiftCard.getNumber();

    parameters[3] = retailStoreMemberGiftCard.getRemain();

    parameters[4] = retailStoreMemberGiftCard.nextVersion();
    parameters[5] = retailStoreMemberGiftCard.getId();
    parameters[6] = retailStoreMemberGiftCard.getVersion();

    return parameters;
  }

  protected Object[] prepareRetailStoreMemberGiftCardCreateParameters(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard) {
    Object[] parameters = new Object[5];
    if (retailStoreMemberGiftCard.getId() == null) {
      String newRetailStoreMemberGiftCardId = getNextId();
      retailStoreMemberGiftCard.setId(newRetailStoreMemberGiftCardId);
    }
    parameters[0] = retailStoreMemberGiftCard.getId();

    parameters[1] = retailStoreMemberGiftCard.getName();

    if (retailStoreMemberGiftCard.getOwner() != null) {
      parameters[2] = retailStoreMemberGiftCard.getOwner().getId();
    }

    parameters[3] = retailStoreMemberGiftCard.getNumber();

    parameters[4] = retailStoreMemberGiftCard.getRemain();

    return parameters;
  }

  protected RetailStoreMemberGiftCard saveInternalRetailStoreMemberGiftCard(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> options) {

    if (isSaveOwnerEnabled(options)) {
      saveOwner(retailStoreMemberGiftCard, options);
    }

    saveRetailStoreMemberGiftCard(retailStoreMemberGiftCard);

    if (isSaveRetailStoreMemberGiftCardConsumeRecordListEnabled(options)) {
      saveRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCard, options);
      // removeRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCard, options);
      // Not delete the record

    }

    return retailStoreMemberGiftCard;
  }

  // ======================================================================================

  protected RetailStoreMemberGiftCard saveOwner(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (retailStoreMemberGiftCard.getOwner() == null) {
      return retailStoreMemberGiftCard; // do nothing when it is null
    }

    getRetailStoreMemberDAO().save(retailStoreMemberGiftCard.getOwner(), options);
    return retailStoreMemberGiftCard;
  }

  public RetailStoreMemberGiftCard planToRemoveRetailStoreMemberGiftCardConsumeRecordList(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard,
      String retailStoreMemberGiftCardConsumeRecordIds[],
      Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(
        RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY, retailStoreMemberGiftCard.getId());
    key.put(
        RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY,
        retailStoreMemberGiftCardConsumeRecordIds);

    SmartList<RetailStoreMemberGiftCardConsumeRecord>
        externalRetailStoreMemberGiftCardConsumeRecordList =
            getRetailStoreMemberGiftCardConsumeRecordDAO()
                .findRetailStoreMemberGiftCardConsumeRecordWithKey(key, options);
    if (externalRetailStoreMemberGiftCardConsumeRecordList == null) {
      return retailStoreMemberGiftCard;
    }
    if (externalRetailStoreMemberGiftCardConsumeRecordList.isEmpty()) {
      return retailStoreMemberGiftCard;
    }

    for (RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordItem :
        externalRetailStoreMemberGiftCardConsumeRecordList) {

      retailStoreMemberGiftCardConsumeRecordItem.clearFromAll();
    }

    SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList =
        retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList();
    retailStoreMemberGiftCardConsumeRecordList.addAllToRemoveList(
        externalRetailStoreMemberGiftCardConsumeRecordList);
    return retailStoreMemberGiftCard;
  }

  // disconnect RetailStoreMemberGiftCard with biz_order in RetailStoreMemberGiftCardConsumeRecord
  public RetailStoreMemberGiftCard
      planToRemoveRetailStoreMemberGiftCardConsumeRecordListWithBizOrder(
          RetailStoreMemberGiftCard retailStoreMemberGiftCard,
          String bizOrderId,
          Map<String, Object> options)
          throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(
        RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY, retailStoreMemberGiftCard.getId());
    key.put(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY, bizOrderId);

    SmartList<RetailStoreMemberGiftCardConsumeRecord>
        externalRetailStoreMemberGiftCardConsumeRecordList =
            getRetailStoreMemberGiftCardConsumeRecordDAO()
                .findRetailStoreMemberGiftCardConsumeRecordWithKey(key, options);
    if (externalRetailStoreMemberGiftCardConsumeRecordList == null) {
      return retailStoreMemberGiftCard;
    }
    if (externalRetailStoreMemberGiftCardConsumeRecordList.isEmpty()) {
      return retailStoreMemberGiftCard;
    }

    for (RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordItem :
        externalRetailStoreMemberGiftCardConsumeRecordList) {
      retailStoreMemberGiftCardConsumeRecordItem.clearBizOrder();
      retailStoreMemberGiftCardConsumeRecordItem.clearOwner();
    }

    SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList =
        retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList();
    retailStoreMemberGiftCardConsumeRecordList.addAllToRemoveList(
        externalRetailStoreMemberGiftCardConsumeRecordList);
    return retailStoreMemberGiftCard;
  }

  public int countRetailStoreMemberGiftCardConsumeRecordListWithBizOrder(
      String retailStoreMemberGiftCardId, String bizOrderId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY, retailStoreMemberGiftCardId);
    key.put(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY, bizOrderId);

    int count =
        getRetailStoreMemberGiftCardConsumeRecordDAO()
            .countRetailStoreMemberGiftCardConsumeRecordWithKey(key, options);
    return count;
  }

  protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCardConsumeRecordList(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> options) {

    SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList =
        retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList();
    if (retailStoreMemberGiftCardConsumeRecordList == null) {
      // null list means nothing
      return retailStoreMemberGiftCard;
    }
    SmartList<RetailStoreMemberGiftCardConsumeRecord>
        mergedUpdateRetailStoreMemberGiftCardConsumeRecordList =
            new SmartList<RetailStoreMemberGiftCardConsumeRecord>();

    mergedUpdateRetailStoreMemberGiftCardConsumeRecordList.addAll(
        retailStoreMemberGiftCardConsumeRecordList);
    if (retailStoreMemberGiftCardConsumeRecordList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateRetailStoreMemberGiftCardConsumeRecordList.addAll(
          retailStoreMemberGiftCardConsumeRecordList.getToRemoveList());
      retailStoreMemberGiftCardConsumeRecordList.removeAll(
          retailStoreMemberGiftCardConsumeRecordList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getRetailStoreMemberGiftCardConsumeRecordDAO()
        .saveRetailStoreMemberGiftCardConsumeRecordList(
            mergedUpdateRetailStoreMemberGiftCardConsumeRecordList, options);

    if (retailStoreMemberGiftCardConsumeRecordList.getToRemoveList() != null) {
      retailStoreMemberGiftCardConsumeRecordList.removeAll(
          retailStoreMemberGiftCardConsumeRecordList.getToRemoveList());
    }

    return retailStoreMemberGiftCard;
  }

  protected RetailStoreMemberGiftCard removeRetailStoreMemberGiftCardConsumeRecordList(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> options) {

    SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList =
        retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList();
    if (retailStoreMemberGiftCardConsumeRecordList == null) {
      return retailStoreMemberGiftCard;
    }

    SmartList<RetailStoreMemberGiftCardConsumeRecord>
        toRemoveRetailStoreMemberGiftCardConsumeRecordList =
            retailStoreMemberGiftCardConsumeRecordList.getToRemoveList();

    if (toRemoveRetailStoreMemberGiftCardConsumeRecordList == null) {
      return retailStoreMemberGiftCard;
    }
    if (toRemoveRetailStoreMemberGiftCardConsumeRecordList.isEmpty()) {
      return retailStoreMemberGiftCard; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getRetailStoreMemberGiftCardConsumeRecordDAO()
        .removeRetailStoreMemberGiftCardConsumeRecordList(
            toRemoveRetailStoreMemberGiftCardConsumeRecordList, options);

    return retailStoreMemberGiftCard;
  }

  public RetailStoreMemberGiftCard present(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> options) {

    presentRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCard, options);

    return retailStoreMemberGiftCard;
  }

  // Using java8 feature to reduce the code significantly
  protected RetailStoreMemberGiftCard presentRetailStoreMemberGiftCardConsumeRecordList(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> options) {

    SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList =
        retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList();
    SmartList<RetailStoreMemberGiftCardConsumeRecord> newList =
        presentSubList(
            retailStoreMemberGiftCard.getId(),
            retailStoreMemberGiftCardConsumeRecordList,
            options,
            getRetailStoreMemberGiftCardConsumeRecordDAO()
                ::countRetailStoreMemberGiftCardConsumeRecordByOwner,
            getRetailStoreMemberGiftCardConsumeRecordDAO()
                ::findRetailStoreMemberGiftCardConsumeRecordByOwner);

    retailStoreMemberGiftCard.setRetailStoreMemberGiftCardConsumeRecordList(newList);

    return retailStoreMemberGiftCard;
  }

  public SmartList<RetailStoreMemberGiftCard>
      requestCandidateRetailStoreMemberGiftCardForRetailStoreMemberGiftCardConsumeRecord(
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
        RetailStoreMemberGiftCardTable.COLUMN_NAME,
        RetailStoreMemberGiftCardTable.COLUMN_OWNER,
        filterKey,
        pageNo,
        pageSize,
        getRetailStoreMemberGiftCardMapper());
  }

  protected String getTableName() {
    return RetailStoreMemberGiftCardTable.TABLE_NAME;
  }

  public void enhanceList(List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList) {
    this.enhanceListInternal(
        retailStoreMemberGiftCardList, this.getRetailStoreMemberGiftCardMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList =
        ownerEntity.collectRefsWithType(RetailStoreMemberGiftCard.INTERNAL_TYPE);
    this.enhanceList(retailStoreMemberGiftCardList);
  }

  @Override
  public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getRetailStoreMemberGiftCardMapper());
  }

  @Override
  public int countRetailStoreMemberGiftCardWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countRetailStoreMemberGiftCardWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<RetailStoreMemberGiftCard> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getRetailStoreMemberGiftCardMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<RetailStoreMemberGiftCard> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getRetailStoreMemberGiftCardMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateRetailStoreMemberGiftCard executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateRetailStoreMemberGiftCard result = new CandidateRetailStoreMemberGiftCard();
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
  public List<RetailStoreMemberGiftCard> search(RetailStoreMemberGiftCardRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected RetailStoreMemberGiftCardMapper mapper() {
    return getRetailStoreMemberGiftCardMapper();
  }

  @Override
  protected RetailStoreMemberGiftCardMapper mapperForClazz(Class<?> clazz) {
    return RetailStoreMemberGiftCardMapper.mapperForClass(clazz);
  }
}
