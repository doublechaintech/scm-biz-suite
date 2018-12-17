
package com.doublechaintech.retailscm.memberrewardpoint;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;


public interface MemberRewardPointDAO{

	
	public MemberRewardPoint load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<MemberRewardPoint> memberRewardPointList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public MemberRewardPoint present(MemberRewardPoint memberRewardPoint,Map<String,Object> options) throws Exception;
	public MemberRewardPoint clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public MemberRewardPoint save(MemberRewardPoint memberRewardPoint,Map<String,Object> options);
	public SmartList<MemberRewardPoint> saveMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList,Map<String,Object> options);
	public SmartList<MemberRewardPoint> removeMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList,Map<String,Object> options);
	public SmartList<MemberRewardPoint> findMemberRewardPointWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countMemberRewardPointWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countMemberRewardPointWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String memberRewardPointId, int version) throws Exception;
	public MemberRewardPoint disconnectFromAll(String memberRewardPointId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<MemberRewardPoint> queryList(String sql, Object ... parmeters);
 
 	public SmartList<MemberRewardPoint> findMemberRewardPointByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countMemberRewardPointByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public Map<String, Integer> countMemberRewardPointByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<MemberRewardPoint> findMemberRewardPointByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 	public void analyzeMemberRewardPointByOwner(SmartList<MemberRewardPoint> resultList, String retailStoreMemberId, Map<String,Object> options);

 
 }


