
package com.doublechaintech.retailscm.goodsshelf;
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

import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.storagespace.StorageSpace;

import com.doublechaintech.retailscm.damagespace.DamageSpaceDAO;
import com.doublechaintech.retailscm.supplierspace.SupplierSpaceDAO;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocationDAO;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountDAO;
import com.doublechaintech.retailscm.storagespace.StorageSpaceDAO;


public interface GoodsShelfDAO extends BaseDAO{

	public SmartList<GoodsShelf> loadAll();
	public Stream<GoodsShelf> loadAllAsStream();
	public GoodsShelf load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<GoodsShelf> goodsShelfList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public GoodsShelf present(GoodsShelf goodsShelf,Map<String,Object> options) throws Exception;
	public GoodsShelf clone(String id, Map<String,Object> options) throws Exception;

	

	public GoodsShelf save(GoodsShelf goodsShelf,Map<String,Object> options);
	public SmartList<GoodsShelf> saveGoodsShelfList(SmartList<GoodsShelf> goodsShelfList,Map<String,Object> options);
	public SmartList<GoodsShelf> removeGoodsShelfList(SmartList<GoodsShelf> goodsShelfList,Map<String,Object> options);
	public SmartList<GoodsShelf> findGoodsShelfWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countGoodsShelfWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countGoodsShelfWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String goodsShelfId, int version) throws Exception;
	public GoodsShelf disconnectFromAll(String goodsShelfId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public GoodsShelfStockCountDAO getGoodsShelfStockCountDAO();
		
	public GoodsAllocationDAO getGoodsAllocationDAO();
		
	
 	public SmartList<GoodsShelf> requestCandidateGoodsShelfForGoodsShelfStockCount(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<GoodsShelf> requestCandidateGoodsShelfForGoodsAllocation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public GoodsShelf planToRemoveGoodsShelfStockCountList(GoodsShelf goodsShelf, String goodsShelfStockCountIds[], Map<String,Object> options)throws Exception;


	public GoodsShelf planToRemoveGoodsAllocationList(GoodsShelf goodsShelf, String goodsAllocationIds[], Map<String,Object> options)throws Exception;



	public SmartList<GoodsShelf> queryList(String sql, Object ... parmeters);
	public Stream<GoodsShelf> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateGoodsShelf executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<GoodsShelf> findGoodsShelfByStorageSpace(String storageSpaceId, Map<String,Object> options);
 	public int countGoodsShelfByStorageSpace(String storageSpaceId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsShelfByStorageSpaceIds(String[] ids, Map<String,Object> options);
 	public SmartList<GoodsShelf> findGoodsShelfByStorageSpace(String storageSpaceId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsShelfByStorageSpace(SmartList<GoodsShelf> resultList, String storageSpaceId, Map<String,Object> options);


 
 	public SmartList<GoodsShelf> findGoodsShelfBySupplierSpace(String supplierSpaceId, Map<String,Object> options);
 	public int countGoodsShelfBySupplierSpace(String supplierSpaceId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsShelfBySupplierSpaceIds(String[] ids, Map<String,Object> options);
 	public SmartList<GoodsShelf> findGoodsShelfBySupplierSpace(String supplierSpaceId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsShelfBySupplierSpace(SmartList<GoodsShelf> resultList, String supplierSpaceId, Map<String,Object> options);


 
 	public SmartList<GoodsShelf> findGoodsShelfByDamageSpace(String damageSpaceId, Map<String,Object> options);
 	public int countGoodsShelfByDamageSpace(String damageSpaceId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsShelfByDamageSpaceIds(String[] ids, Map<String,Object> options);
 	public SmartList<GoodsShelf> findGoodsShelfByDamageSpace(String damageSpaceId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsShelfByDamageSpace(SmartList<GoodsShelf> resultList, String damageSpaceId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:GoodsShelfStockCount的shelf的GoodsShelfStockCountList
	public SmartList<GoodsShelfStockCount> loadOurGoodsShelfStockCountList(RetailscmUserContext userContext, List<GoodsShelf> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:GoodsAllocation的goodsShelf的GoodsAllocationList
	public SmartList<GoodsAllocation> loadOurGoodsAllocationList(RetailscmUserContext userContext, List<GoodsShelf> us, Map<String,Object> options) throws Exception;
	
}


