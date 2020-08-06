
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


public interface KeypairIdentityDAO extends BaseDAO{

	public SmartList<KeypairIdentity> loadAll();
	public Stream<KeypairIdentity> loadAllAsStream();
	public KeypairIdentity load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<KeypairIdentity> keypairIdentityList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public KeypairIdentity present(KeypairIdentity keypairIdentity,Map<String,Object> options) throws Exception;
	public KeypairIdentity clone(String id, Map<String,Object> options) throws Exception;

	

	public KeypairIdentity save(KeypairIdentity keypairIdentity,Map<String,Object> options);
	public SmartList<KeypairIdentity> saveKeypairIdentityList(SmartList<KeypairIdentity> keypairIdentityList,Map<String,Object> options);
	public SmartList<KeypairIdentity> removeKeypairIdentityList(SmartList<KeypairIdentity> keypairIdentityList,Map<String,Object> options);
	public SmartList<KeypairIdentity> findKeypairIdentityWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countKeypairIdentityWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countKeypairIdentityWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String keypairIdentityId, int version) throws Exception;
	public KeypairIdentity disconnectFromAll(String keypairIdentityId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	

	public SmartList<KeypairIdentity> queryList(String sql, Object ... parmeters);
	public Stream<KeypairIdentity> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateKeypairIdentity executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<KeypairIdentity> findKeypairIdentityByKeyType(String publicKeyTypeId, Map<String,Object> options);
 	public int countKeypairIdentityByKeyType(String publicKeyTypeId, Map<String,Object> options);
 	public Map<String, Integer> countKeypairIdentityByKeyTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<KeypairIdentity> findKeypairIdentityByKeyType(String publicKeyTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeKeypairIdentityByKeyType(SmartList<KeypairIdentity> resultList, String publicKeyTypeId, Map<String,Object> options);


 
 	public SmartList<KeypairIdentity> findKeypairIdentityBySecUser(String secUserId, Map<String,Object> options);
 	public int countKeypairIdentityBySecUser(String secUserId, Map<String,Object> options);
 	public Map<String, Integer> countKeypairIdentityBySecUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<KeypairIdentity> findKeypairIdentityBySecUser(String secUserId, int start, int count, Map<String,Object> options);
 	public void analyzeKeypairIdentityBySecUser(SmartList<KeypairIdentity> resultList, String secUserId, Map<String,Object> options);


 
}


