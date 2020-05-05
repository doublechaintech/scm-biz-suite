
package com.doublechaintech.retailscm.retailstoremembercoupon;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;


public interface RetailStoreMemberCouponDAO extends BaseDAO{

	public SmartList<RetailStoreMemberCoupon> loadAll();
	public RetailStoreMemberCoupon load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreMemberCoupon> retailStoreMemberCouponList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreMemberCoupon present(RetailStoreMemberCoupon retailStoreMemberCoupon,Map<String,Object> options) throws Exception;
	public RetailStoreMemberCoupon clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreMemberCoupon save(RetailStoreMemberCoupon retailStoreMemberCoupon,Map<String,Object> options);
	public SmartList<RetailStoreMemberCoupon> saveRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList,Map<String,Object> options);
	public SmartList<RetailStoreMemberCoupon> removeRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList,Map<String,Object> options);
	public SmartList<RetailStoreMemberCoupon> findRetailStoreMemberCouponWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreMemberCouponWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreMemberCouponWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreMemberCouponId, int version) throws Exception;
	public RetailStoreMemberCoupon disconnectFromAll(String retailStoreMemberCouponId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<RetailStoreMemberCoupon> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreMemberCoupon executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<RetailStoreMemberCoupon> findRetailStoreMemberCouponByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countRetailStoreMemberCouponByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreMemberCouponByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreMemberCoupon> findRetailStoreMemberCouponByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreMemberCouponByOwner(SmartList<RetailStoreMemberCoupon> resultList, String retailStoreMemberId, Map<String,Object> options);

 
 
}


