package com.doublechaintech.retailscm.publickeytype;

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

import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;
import com.doublechaintech.retailscm.userdomain.UserDomain;

import com.doublechaintech.retailscm.userdomain.UserDomainDAO;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class PublicKeyTypeJDBCTemplateDAO extends RetailscmBaseDAOImpl implements PublicKeyTypeDAO {

  protected UserDomainDAO userDomainDAO;

  public void setUserDomainDAO(UserDomainDAO userDomainDAO) {

    if (userDomainDAO == null) {
      throw new IllegalStateException("Do not try to set userDomainDAO to null.");
    }
    this.userDomainDAO = userDomainDAO;
  }

  public UserDomainDAO getUserDomainDAO() {
    if (this.userDomainDAO == null) {
      throw new IllegalStateException(
          "The userDomainDAO is not configured yet, please config it some where.");
    }

    return this.userDomainDAO;
  }

  protected KeyPairIdentityDAO keyPairIdentityDAO;

  public void setKeyPairIdentityDAO(KeyPairIdentityDAO keyPairIdentityDAO) {

    if (keyPairIdentityDAO == null) {
      throw new IllegalStateException("Do not try to set keyPairIdentityDAO to null.");
    }
    this.keyPairIdentityDAO = keyPairIdentityDAO;
  }

  public KeyPairIdentityDAO getKeyPairIdentityDAO() {
    if (this.keyPairIdentityDAO == null) {
      throw new IllegalStateException(
          "The keyPairIdentityDAO is not configured yet, please config it some where.");
    }

    return this.keyPairIdentityDAO;
  }

  /*
  protected PublicKeyType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalPublicKeyType(accessKey, options);
  }
  */

  public SmartList<PublicKeyType> loadAll() {
    return this.loadAll(getPublicKeyTypeMapper());
  }

  public Stream<PublicKeyType> loadAllAsStream() {
    return this.loadAllAsStream(getPublicKeyTypeMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public PublicKeyType load(String id, Map<String, Object> options) throws Exception {
    return loadInternalPublicKeyType(PublicKeyTypeTable.withId(id), options);
  }

  public PublicKeyType save(PublicKeyType publicKeyType, Map<String, Object> options) {

    String methodName = "save(PublicKeyType publicKeyType,Map<String,Object> options)";

    assertMethodArgumentNotNull(publicKeyType, methodName, "publicKeyType");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalPublicKeyType(publicKeyType, options);
  }

  public PublicKeyType clone(String publicKeyTypeId, Map<String, Object> options) throws Exception {

    return clone(PublicKeyTypeTable.withId(publicKeyTypeId), options);
  }

  protected PublicKeyType clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String publicKeyTypeId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    PublicKeyType newPublicKeyType = loadInternalPublicKeyType(accessKey, options);
    newPublicKeyType.setVersion(0);

    if (isSaveKeyPairIdentityListEnabled(options)) {
      for (KeyPairIdentity item : newPublicKeyType.getKeyPairIdentityList()) {
        item.setVersion(0);
      }
    }

    saveInternalPublicKeyType(newPublicKeyType, options);

    return newPublicKeyType;
  }

  protected void throwIfHasException(String publicKeyTypeId, int version, int count)
      throws Exception {
    if (count == 1) {
      throw new PublicKeyTypeVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new PublicKeyTypeNotFoundException(
          "The " + this.getTableName() + "(" + publicKeyTypeId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public PublicKeyType disconnectFromAll(String publicKeyTypeId, int version) throws Exception {

    PublicKeyType publicKeyType =
        loadInternalPublicKeyType(PublicKeyTypeTable.withId(publicKeyTypeId), emptyOptions());
    publicKeyType.clearFromAll();
    this.savePublicKeyType(publicKeyType);
    return publicKeyType;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return PublicKeyTypeTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "public_key_type";
  }

  @Override
  protected String getBeanName() {

    return "publicKeyType";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return PublicKeyTypeTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractDomainEnabled(Map<String, Object> options) {

    return checkOptions(options, PublicKeyTypeTokens.DOMAIN);
  }

  protected boolean isSaveDomainEnabled(Map<String, Object> options) {

    return checkOptions(options, PublicKeyTypeTokens.DOMAIN);
  }

  protected boolean isExtractKeyPairIdentityListEnabled(Map<String, Object> options) {
    return checkOptions(options, PublicKeyTypeTokens.KEY_PAIR_IDENTITY_LIST);
  }

  protected boolean isAnalyzeKeyPairIdentityListEnabled(Map<String, Object> options) {
    return PublicKeyTypeTokens.of(options).analyzeKeyPairIdentityListEnabled();
  }

  protected boolean isSaveKeyPairIdentityListEnabled(Map<String, Object> options) {
    return checkOptions(options, PublicKeyTypeTokens.KEY_PAIR_IDENTITY_LIST);
  }

  protected PublicKeyTypeMapper getPublicKeyTypeMapper() {
    return new PublicKeyTypeMapper();
  }

  protected PublicKeyType extractPublicKeyType(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      PublicKeyType publicKeyType = loadSingleObject(accessKey, getPublicKeyTypeMapper());
      return publicKeyType;
    } catch (EmptyResultDataAccessException e) {
      throw new PublicKeyTypeNotFoundException("PublicKeyType(" + accessKey + ") is not found!");
    }
  }

  protected PublicKeyType loadInternalPublicKeyType(
      AccessKey accessKey, Map<String, Object> loadOptions) throws Exception {

    PublicKeyType publicKeyType = extractPublicKeyType(accessKey, loadOptions);

    if (isExtractDomainEnabled(loadOptions)) {
      extractDomain(publicKeyType, loadOptions);
    }

    if (isExtractKeyPairIdentityListEnabled(loadOptions)) {
      extractKeyPairIdentityList(publicKeyType, loadOptions);
    }

    if (isAnalyzeKeyPairIdentityListEnabled(loadOptions)) {
      analyzeKeyPairIdentityList(publicKeyType, loadOptions);
    }

    return publicKeyType;
  }

  protected PublicKeyType extractDomain(PublicKeyType publicKeyType, Map<String, Object> options)
      throws Exception {

    if (publicKeyType.getDomain() == null) {
      return publicKeyType;
    }
    String domainId = publicKeyType.getDomain().getId();
    if (domainId == null) {
      return publicKeyType;
    }
    UserDomain domain = getUserDomainDAO().load(domainId, options);
    if (domain != null) {
      publicKeyType.setDomain(domain);
    }

    return publicKeyType;
  }

  protected void enhanceKeyPairIdentityList(
      SmartList<KeyPairIdentity> keyPairIdentityList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected PublicKeyType extractKeyPairIdentityList(
      PublicKeyType publicKeyType, Map<String, Object> options) {

    if (publicKeyType == null) {
      return null;
    }
    if (publicKeyType.getId() == null) {
      return publicKeyType;
    }

    SmartList<KeyPairIdentity> keyPairIdentityList =
        getKeyPairIdentityDAO().findKeyPairIdentityByKeyType(publicKeyType.getId(), options);
    if (keyPairIdentityList != null) {
      enhanceKeyPairIdentityList(keyPairIdentityList, options);
      publicKeyType.setKeyPairIdentityList(keyPairIdentityList);
    }

    return publicKeyType;
  }

  protected PublicKeyType analyzeKeyPairIdentityList(
      PublicKeyType publicKeyType, Map<String, Object> options) {

    if (publicKeyType == null) {
      return null;
    }
    if (publicKeyType.getId() == null) {
      return publicKeyType;
    }

    SmartList<KeyPairIdentity> keyPairIdentityList = publicKeyType.getKeyPairIdentityList();
    if (keyPairIdentityList != null) {
      getKeyPairIdentityDAO()
          .analyzeKeyPairIdentityByKeyType(keyPairIdentityList, publicKeyType.getId(), options);
    }

    return publicKeyType;
  }

  public SmartList<PublicKeyType> findPublicKeyTypeByDomain(
      String userDomainId, Map<String, Object> options) {

    SmartList<PublicKeyType> resultList =
        queryWith(
            PublicKeyTypeTable.COLUMN_DOMAIN, userDomainId, options, getPublicKeyTypeMapper());
    // analyzePublicKeyTypeByDomain(resultList, userDomainId, options);
    return resultList;
  }

  public SmartList<PublicKeyType> findPublicKeyTypeByDomain(
      String userDomainId, int start, int count, Map<String, Object> options) {

    SmartList<PublicKeyType> resultList =
        queryWithRange(
            PublicKeyTypeTable.COLUMN_DOMAIN,
            userDomainId,
            options,
            getPublicKeyTypeMapper(),
            start,
            count);
    // analyzePublicKeyTypeByDomain(resultList, userDomainId, options);
    return resultList;
  }

  public void analyzePublicKeyTypeByDomain(
      SmartList<PublicKeyType> resultList, String userDomainId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }
  }

  @Override
  public int countPublicKeyTypeByDomain(String userDomainId, Map<String, Object> options) {

    return countWith(PublicKeyTypeTable.COLUMN_DOMAIN, userDomainId, options);
  }

  @Override
  public Map<String, Integer> countPublicKeyTypeByDomainIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(PublicKeyTypeTable.COLUMN_DOMAIN, ids, options);
  }

  protected PublicKeyType savePublicKeyType(PublicKeyType publicKeyType) {

    if (!publicKeyType.isChanged()) {
      return publicKeyType;
    }

    Beans.dbUtil().cacheCleanUp(publicKeyType);
    String SQL = this.getSavePublicKeyTypeSQL(publicKeyType);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSavePublicKeyTypeParameters(publicKeyType);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    publicKeyType.incVersion();
    publicKeyType.afterSave();
    return publicKeyType;
  }

  public SmartList<PublicKeyType> savePublicKeyTypeList(
      SmartList<PublicKeyType> publicKeyTypeList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitPublicKeyTypeList(publicKeyTypeList);

    batchPublicKeyTypeCreate((List<PublicKeyType>) lists[CREATE_LIST_INDEX]);
    batchPublicKeyTypeUpdate((List<PublicKeyType>) lists[UPDATE_LIST_INDEX]);
    batchPublicKeyTypeRemove((List<PublicKeyType>) lists[REMOVE_LIST_INDEX]);
    batchPublicKeyTypeRecover((List<PublicKeyType>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (PublicKeyType publicKeyType : publicKeyTypeList) {
      if (publicKeyType.isChanged()) {
        publicKeyType.incVersion();
        publicKeyType.afterSave();
      }
      if (publicKeyType.isToRecover() || publicKeyType.isToRemove()) {
        publicKeyType.setVersion(-publicKeyType.getVersion());
      }
    }

    return publicKeyTypeList;
  }

  public SmartList<PublicKeyType> removePublicKeyTypeList(
      SmartList<PublicKeyType> publicKeyTypeList, Map<String, Object> options) {

    super.removeList(publicKeyTypeList, options);

    return publicKeyTypeList;
  }

  protected List<Object[]> preparePublicKeyTypeBatchCreateArgs(
      List<PublicKeyType> publicKeyTypeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PublicKeyType publicKeyType : publicKeyTypeList) {
      Object[] parameters = preparePublicKeyTypeCreateParameters(publicKeyType);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> preparePublicKeyTypeBatchUpdateArgs(
      List<PublicKeyType> publicKeyTypeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PublicKeyType publicKeyType : publicKeyTypeList) {
      if (!publicKeyType.isChanged()) {
        continue;
      }
      Object[] parameters = preparePublicKeyTypeUpdateParameters(publicKeyType);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> preparePublicKeyTypeBatchRecoverArgs(
      List<PublicKeyType> publicKeyTypeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PublicKeyType publicKeyType : publicKeyTypeList) {
      if (!publicKeyType.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(publicKeyType);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> preparePublicKeyTypeBatchRemoveArgs(
      List<PublicKeyType> publicKeyTypeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (PublicKeyType publicKeyType : publicKeyTypeList) {
      if (!publicKeyType.isToRemove()) {
        continue;
      }
      Object[] parameters = preparePublicKeyTypeRemoveParameters(publicKeyType);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchPublicKeyTypeCreate(List<PublicKeyType> publicKeyTypeList) {
    String SQL = getCreateSQL();
    List<Object[]> args = preparePublicKeyTypeBatchCreateArgs(publicKeyTypeList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchPublicKeyTypeUpdate(List<PublicKeyType> publicKeyTypeList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = preparePublicKeyTypeBatchUpdateArgs(publicKeyTypeList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchPublicKeyTypeRemove(List<PublicKeyType> publicKeyTypeList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = preparePublicKeyTypeBatchRemoveArgs(publicKeyTypeList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchPublicKeyTypeRecover(List<PublicKeyType> publicKeyTypeList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = preparePublicKeyTypeBatchRecoverArgs(publicKeyTypeList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitPublicKeyTypeList(List<PublicKeyType> publicKeyTypeList) {

    List<PublicKeyType> publicKeyTypeCreateList = new ArrayList<PublicKeyType>();
    List<PublicKeyType> publicKeyTypeUpdateList = new ArrayList<PublicKeyType>();
    List<PublicKeyType> publicKeyTypeRemoveList = new ArrayList<PublicKeyType>();
    List<PublicKeyType> publicKeyTypeRecoverList = new ArrayList<PublicKeyType>();

    for (PublicKeyType publicKeyType : publicKeyTypeList) {
      if (publicKeyType.isToRemove()) {
        publicKeyTypeRemoveList.add(publicKeyType);
        continue;
      }
      if (publicKeyType.isToRecover()) {
        publicKeyTypeRecoverList.add(publicKeyType);
        continue;
      }
      if (isUpdateRequest(publicKeyType)) {
        if (publicKeyType.isChanged()) {
          publicKeyTypeUpdateList.add(publicKeyType);
        }
        continue;
      }

      if (publicKeyType.isChanged()) {
        publicKeyTypeCreateList.add(publicKeyType);
      }
    }

    return new Object[] {
      publicKeyTypeCreateList,
      publicKeyTypeUpdateList,
      publicKeyTypeRemoveList,
      publicKeyTypeRecoverList
    };
  }

  protected boolean isUpdateRequest(PublicKeyType publicKeyType) {
    return publicKeyType.getVersion() > 0;
  }

  protected String getSavePublicKeyTypeSQL(PublicKeyType publicKeyType) {
    if (publicKeyType.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(publicKeyType)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSavePublicKeyTypeParameters(PublicKeyType publicKeyType) {
    if (publicKeyType.isToRemove()) {
      return preparePublicKeyTypeRemoveParameters(publicKeyType);
    }
    if (publicKeyType.isToRecover()) {
      return prepareRecoverParameters(publicKeyType);
    }

    if (isUpdateRequest(publicKeyType)) {
      return preparePublicKeyTypeUpdateParameters(publicKeyType);
    }
    return preparePublicKeyTypeCreateParameters(publicKeyType);
  }

  protected Object[] preparePublicKeyTypeRemoveParameters(PublicKeyType publicKeyType) {
    return super.prepareRemoveParameters(publicKeyType);
  }

  protected Object[] preparePublicKeyTypeUpdateParameters(PublicKeyType publicKeyType) {
    Object[] parameters = new Object[6];

    parameters[0] = publicKeyType.getKeyAlg();

    parameters[1] = publicKeyType.getSignAlg();

    if (publicKeyType.getDomain() != null) {
      parameters[2] = publicKeyType.getDomain().getId();
    }

    parameters[3] = publicKeyType.nextVersion();
    parameters[4] = publicKeyType.getId();
    parameters[5] = publicKeyType.getVersion();

    return parameters;
  }

  protected Object[] preparePublicKeyTypeCreateParameters(PublicKeyType publicKeyType) {
    Object[] parameters = new Object[4];
    if (publicKeyType.getId() == null) {
      String newPublicKeyTypeId = getNextId();
      publicKeyType.setId(newPublicKeyTypeId);
    }
    parameters[0] = publicKeyType.getId();

    parameters[1] = publicKeyType.getKeyAlg();

    parameters[2] = publicKeyType.getSignAlg();

    if (publicKeyType.getDomain() != null) {
      parameters[3] = publicKeyType.getDomain().getId();
    }

    return parameters;
  }

  protected PublicKeyType saveInternalPublicKeyType(
      PublicKeyType publicKeyType, Map<String, Object> options) {

    if (isSaveDomainEnabled(options)) {
      saveDomain(publicKeyType, options);
    }

    savePublicKeyType(publicKeyType);

    if (isSaveKeyPairIdentityListEnabled(options)) {
      saveKeyPairIdentityList(publicKeyType, options);
      // removeKeyPairIdentityList(publicKeyType, options);
      // Not delete the record

    }

    return publicKeyType;
  }

  // ======================================================================================

  protected PublicKeyType saveDomain(PublicKeyType publicKeyType, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (publicKeyType.getDomain() == null) {
      return publicKeyType; // do nothing when it is null
    }

    getUserDomainDAO().save(publicKeyType.getDomain(), options);
    return publicKeyType;
  }

  public PublicKeyType planToRemoveKeyPairIdentityList(
      PublicKeyType publicKeyType, String keyPairIdentityIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(KeyPairIdentity.KEY_TYPE_PROPERTY, publicKeyType.getId());
    key.put(KeyPairIdentity.ID_PROPERTY, keyPairIdentityIds);

    SmartList<KeyPairIdentity> externalKeyPairIdentityList =
        getKeyPairIdentityDAO().findKeyPairIdentityWithKey(key, options);
    if (externalKeyPairIdentityList == null) {
      return publicKeyType;
    }
    if (externalKeyPairIdentityList.isEmpty()) {
      return publicKeyType;
    }

    for (KeyPairIdentity keyPairIdentityItem : externalKeyPairIdentityList) {

      keyPairIdentityItem.clearFromAll();
    }

    SmartList<KeyPairIdentity> keyPairIdentityList = publicKeyType.getKeyPairIdentityList();
    keyPairIdentityList.addAllToRemoveList(externalKeyPairIdentityList);
    return publicKeyType;
  }

  // disconnect PublicKeyType with sec_user in KeyPairIdentity
  public PublicKeyType planToRemoveKeyPairIdentityListWithSecUser(
      PublicKeyType publicKeyType, String secUserId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(KeyPairIdentity.KEY_TYPE_PROPERTY, publicKeyType.getId());
    key.put(KeyPairIdentity.SEC_USER_PROPERTY, secUserId);

    SmartList<KeyPairIdentity> externalKeyPairIdentityList =
        getKeyPairIdentityDAO().findKeyPairIdentityWithKey(key, options);
    if (externalKeyPairIdentityList == null) {
      return publicKeyType;
    }
    if (externalKeyPairIdentityList.isEmpty()) {
      return publicKeyType;
    }

    for (KeyPairIdentity keyPairIdentityItem : externalKeyPairIdentityList) {
      keyPairIdentityItem.clearSecUser();
      keyPairIdentityItem.clearKeyType();
    }

    SmartList<KeyPairIdentity> keyPairIdentityList = publicKeyType.getKeyPairIdentityList();
    keyPairIdentityList.addAllToRemoveList(externalKeyPairIdentityList);
    return publicKeyType;
  }

  public int countKeyPairIdentityListWithSecUser(
      String publicKeyTypeId, String secUserId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(KeyPairIdentity.KEY_TYPE_PROPERTY, publicKeyTypeId);
    key.put(KeyPairIdentity.SEC_USER_PROPERTY, secUserId);

    int count = getKeyPairIdentityDAO().countKeyPairIdentityWithKey(key, options);
    return count;
  }

  protected PublicKeyType saveKeyPairIdentityList(
      PublicKeyType publicKeyType, Map<String, Object> options) {

    SmartList<KeyPairIdentity> keyPairIdentityList = publicKeyType.getKeyPairIdentityList();
    if (keyPairIdentityList == null) {
      // null list means nothing
      return publicKeyType;
    }
    SmartList<KeyPairIdentity> mergedUpdateKeyPairIdentityList = new SmartList<KeyPairIdentity>();

    mergedUpdateKeyPairIdentityList.addAll(keyPairIdentityList);
    if (keyPairIdentityList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateKeyPairIdentityList.addAll(keyPairIdentityList.getToRemoveList());
      keyPairIdentityList.removeAll(keyPairIdentityList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getKeyPairIdentityDAO().saveKeyPairIdentityList(mergedUpdateKeyPairIdentityList, options);

    if (keyPairIdentityList.getToRemoveList() != null) {
      keyPairIdentityList.removeAll(keyPairIdentityList.getToRemoveList());
    }

    return publicKeyType;
  }

  protected PublicKeyType removeKeyPairIdentityList(
      PublicKeyType publicKeyType, Map<String, Object> options) {

    SmartList<KeyPairIdentity> keyPairIdentityList = publicKeyType.getKeyPairIdentityList();
    if (keyPairIdentityList == null) {
      return publicKeyType;
    }

    SmartList<KeyPairIdentity> toRemoveKeyPairIdentityList = keyPairIdentityList.getToRemoveList();

    if (toRemoveKeyPairIdentityList == null) {
      return publicKeyType;
    }
    if (toRemoveKeyPairIdentityList.isEmpty()) {
      return publicKeyType; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getKeyPairIdentityDAO().removeKeyPairIdentityList(toRemoveKeyPairIdentityList, options);

    return publicKeyType;
  }

  public PublicKeyType present(PublicKeyType publicKeyType, Map<String, Object> options) {

    presentKeyPairIdentityList(publicKeyType, options);

    return publicKeyType;
  }

  // Using java8 feature to reduce the code significantly
  protected PublicKeyType presentKeyPairIdentityList(
      PublicKeyType publicKeyType, Map<String, Object> options) {

    SmartList<KeyPairIdentity> keyPairIdentityList = publicKeyType.getKeyPairIdentityList();
    SmartList<KeyPairIdentity> newList =
        presentSubList(
            publicKeyType.getId(),
            keyPairIdentityList,
            options,
            getKeyPairIdentityDAO()::countKeyPairIdentityByKeyType,
            getKeyPairIdentityDAO()::findKeyPairIdentityByKeyType);

    publicKeyType.setKeyPairIdentityList(newList);

    return publicKeyType;
  }

  public SmartList<PublicKeyType> requestCandidatePublicKeyTypeForKeyPairIdentity(
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
        PublicKeyTypeTable.COLUMN_KEY_ALG,
        PublicKeyTypeTable.COLUMN_DOMAIN,
        filterKey,
        pageNo,
        pageSize,
        getPublicKeyTypeMapper());
  }

  protected String getTableName() {
    return PublicKeyTypeTable.TABLE_NAME;
  }

  public void enhanceList(List<PublicKeyType> publicKeyTypeList) {
    this.enhanceListInternal(publicKeyTypeList, this.getPublicKeyTypeMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<PublicKeyType> publicKeyTypeList =
        ownerEntity.collectRefsWithType(PublicKeyType.INTERNAL_TYPE);
    this.enhanceList(publicKeyTypeList);
  }

  @Override
  public SmartList<PublicKeyType> findPublicKeyTypeWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getPublicKeyTypeMapper());
  }

  @Override
  public int countPublicKeyTypeWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countPublicKeyTypeWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<PublicKeyType> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getPublicKeyTypeMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<PublicKeyType> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getPublicKeyTypeMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidatePublicKeyType executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidatePublicKeyType result = new CandidatePublicKeyType();
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
  public List<PublicKeyType> search(PublicKeyTypeRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected PublicKeyTypeMapper mapper() {
    return getPublicKeyTypeMapper();
  }

  @Override
  protected PublicKeyTypeMapper mapperForClazz(Class<?> clazz) {
    return PublicKeyTypeMapper.mapperForClass(clazz);
  }
}
