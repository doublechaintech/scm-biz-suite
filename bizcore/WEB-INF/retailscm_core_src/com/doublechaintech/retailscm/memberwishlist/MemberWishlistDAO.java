
package com.doublechaintech.retailscm.memberwishlist;
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

import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductDAO;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;


public interface MemberWishlistDAO extends BaseDAO{

	public SmartList<MemberWishlist> loadAll();
	public Stream<MemberWishlist> loadAllAsStream();
	public MemberWishlist load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<MemberWishlist> memberWishlistList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public MemberWishlist present(MemberWishlist memberWishlist,Map<String,Object> options) throws Exception;
	public MemberWishlist clone(String id, Map<String,Object> options) throws Exception;

	

	public MemberWishlist save(MemberWishlist memberWishlist,Map<String,Object> options);
	public SmartList<MemberWishlist> saveMemberWishlistList(SmartList<MemberWishlist> memberWishlistList,Map<String,Object> options);
	public SmartList<MemberWishlist> removeMemberWishlistList(SmartList<MemberWishlist> memberWishlistList,Map<String,Object> options);
	public SmartList<MemberWishlist> findMemberWishlistWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countMemberWishlistWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countMemberWishlistWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String memberWishlistId, int version) throws Exception;
	public MemberWishlist disconnectFromAll(String memberWishlistId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public MemberWishlistProductDAO getMemberWishlistProductDAO();
		
	
 	public SmartList<MemberWishlist> requestCandidateMemberWishlistForMemberWishlistProduct(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public MemberWishlist planToRemoveMemberWishlistProductList(MemberWishlist memberWishlist, String memberWishlistProductIds[], Map<String,Object> options)throws Exception;



	public SmartList<MemberWishlist> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<MemberWishlist> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateMemberWishlist executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<MemberWishlist> findMemberWishlistByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countMemberWishlistByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public Map<String, Integer> countMemberWishlistByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<MemberWishlist> findMemberWishlistByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 	public void analyzeMemberWishlistByOwner(SmartList<MemberWishlist> resultList, String retailStoreMemberId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:MemberWishlistProduct的owner的MemberWishlistProductList
	public SmartList<MemberWishlistProduct> loadOurMemberWishlistProductList(RetailscmUserContext userContext, List<MemberWishlist> us, Map<String,Object> options) throws Exception;
	

	List<MemberWishlist> search(MemberWishlistRequest pRequest);
}


