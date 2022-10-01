package com.doublechaintech.retailscm.keypairidentity;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;

import com.doublechaintech.retailscm.secuser.SecUserDAO;
import com.doublechaintech.retailscm.publickeytype.PublicKeyTypeDAO;

public interface KeyPairIdentityDAO extends BaseDAO {

  public SmartList<KeyPairIdentity> loadAll();

  public Stream<KeyPairIdentity> loadAllAsStream();

  public KeyPairIdentity load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<KeyPairIdentity> keyPairIdentityList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public KeyPairIdentity present(KeyPairIdentity keyPairIdentity, Map<String, Object> options)
      throws Exception;

  public KeyPairIdentity clone(String id, Map<String, Object> options) throws Exception;

  public KeyPairIdentity save(KeyPairIdentity keyPairIdentity, Map<String, Object> options);

  public SmartList<KeyPairIdentity> saveKeyPairIdentityList(
      SmartList<KeyPairIdentity> keyPairIdentityList, Map<String, Object> options);

  public SmartList<KeyPairIdentity> removeKeyPairIdentityList(
      SmartList<KeyPairIdentity> keyPairIdentityList, Map<String, Object> options);

  public SmartList<KeyPairIdentity> findKeyPairIdentityWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countKeyPairIdentityWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countKeyPairIdentityWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public KeyPairIdentity disconnectFromAll(String keyPairIdentityId, int version) throws Exception;

  public void resetNextId();

  public SmartList<KeyPairIdentity> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<KeyPairIdentity> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateKeyPairIdentity executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<KeyPairIdentity> findKeyPairIdentityByKeyType(
      String publicKeyTypeId, Map<String, Object> options);

  public int countKeyPairIdentityByKeyType(String publicKeyTypeId, Map<String, Object> options);

  public Map<String, Integer> countKeyPairIdentityByKeyTypeIds(
      String[] ids, Map<String, Object> options);

  public SmartList<KeyPairIdentity> findKeyPairIdentityByKeyType(
      String publicKeyTypeId, int start, int count, Map<String, Object> options);

  public void analyzeKeyPairIdentityByKeyType(
      SmartList<KeyPairIdentity> resultList, String publicKeyTypeId, Map<String, Object> options);

  public SmartList<KeyPairIdentity> findKeyPairIdentityBySecUser(
      String secUserId, Map<String, Object> options);

  public int countKeyPairIdentityBySecUser(String secUserId, Map<String, Object> options);

  public Map<String, Integer> countKeyPairIdentityBySecUserIds(
      String[] ids, Map<String, Object> options);

  public SmartList<KeyPairIdentity> findKeyPairIdentityBySecUser(
      String secUserId, int start, int count, Map<String, Object> options);

  public void analyzeKeyPairIdentityBySecUser(
      SmartList<KeyPairIdentity> resultList, String secUserId, Map<String, Object> options);

  List<KeyPairIdentity> search(KeyPairIdentityRequest pRequest);
}
