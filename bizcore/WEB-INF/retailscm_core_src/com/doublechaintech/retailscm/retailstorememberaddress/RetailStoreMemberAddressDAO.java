
package com.doublechaintech.retailscm.retailstorememberaddress;
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

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;


public interface RetailStoreMemberAddressDAO extends BaseDAO{

	public SmartList<RetailStoreMemberAddress> loadAll();
	public Stream<RetailStoreMemberAddress> loadAllAsStream();
	public RetailStoreMemberAddress load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreMemberAddress> retailStoreMemberAddressList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public RetailStoreMemberAddress present(RetailStoreMemberAddress retailStoreMemberAddress,Map<String,Object> options) throws Exception;
	public RetailStoreMemberAddress clone(String id, Map<String,Object> options) throws Exception;

	

	public RetailStoreMemberAddress save(RetailStoreMemberAddress retailStoreMemberAddress,Map<String,Object> options);
	public SmartList<RetailStoreMemberAddress> saveRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList,Map<String,Object> options);
	public SmartList<RetailStoreMemberAddress> removeRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList,Map<String,Object> options);
	public SmartList<RetailStoreMemberAddress> findRetailStoreMemberAddressWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreMemberAddressWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreMemberAddressWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreMemberAddressId, int version) throws Exception;
	public RetailStoreMemberAddress disconnectFromAll(String retailStoreMemberAddressId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	

	public SmartList<RetailStoreMemberAddress> queryList(String sql, Object ... parmeters);
	public Stream<RetailStoreMemberAddress> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreMemberAddress executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<RetailStoreMemberAddress> findRetailStoreMemberAddressByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countRetailStoreMemberAddressByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreMemberAddressByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreMemberAddress> findRetailStoreMemberAddressByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreMemberAddressByOwner(SmartList<RetailStoreMemberAddress> resultList, String retailStoreMemberId, Map<String,Object> options);


 
}


