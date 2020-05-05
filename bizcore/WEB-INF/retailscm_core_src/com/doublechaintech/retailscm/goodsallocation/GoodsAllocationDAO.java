
package com.doublechaintech.retailscm.goodsallocation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

import com.doublechaintech.retailscm.goodsshelf.GoodsShelfDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;


public interface GoodsAllocationDAO extends BaseDAO{

	public SmartList<GoodsAllocation> loadAll();
	public GoodsAllocation load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<GoodsAllocation> goodsAllocationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public GoodsAllocation present(GoodsAllocation goodsAllocation,Map<String,Object> options) throws Exception;
	public GoodsAllocation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GoodsAllocation save(GoodsAllocation goodsAllocation,Map<String,Object> options);
	public SmartList<GoodsAllocation> saveGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList,Map<String,Object> options);
	public SmartList<GoodsAllocation> removeGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList,Map<String,Object> options);
	public SmartList<GoodsAllocation> findGoodsAllocationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countGoodsAllocationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countGoodsAllocationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String goodsAllocationId, int version) throws Exception;
	public GoodsAllocation disconnectFromAll(String goodsAllocationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public GoodsDAO getGoodsDAO();
		
	
 	public SmartList<GoodsAllocation> requestCandidateGoodsAllocationForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public GoodsAllocation planToRemoveGoodsList(GoodsAllocation goodsAllocation, String goodsIds[], Map<String,Object> options)throws Exception;


	//disconnect GoodsAllocation with sku in Goods
	public GoodsAllocation planToRemoveGoodsListWithSku(GoodsAllocation goodsAllocation, String skuId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSku(String goodsAllocationId, String skuId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsAllocation with receiving_space in Goods
	public GoodsAllocation planToRemoveGoodsListWithReceivingSpace(GoodsAllocation goodsAllocation, String receivingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithReceivingSpace(String goodsAllocationId, String receivingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsAllocation with smart_pallet in Goods
	public GoodsAllocation planToRemoveGoodsListWithSmartPallet(GoodsAllocation goodsAllocation, String smartPalletId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSmartPallet(String goodsAllocationId, String smartPalletId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsAllocation with shipping_space in Goods
	public GoodsAllocation planToRemoveGoodsListWithShippingSpace(GoodsAllocation goodsAllocation, String shippingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithShippingSpace(String goodsAllocationId, String shippingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsAllocation with transport_task in Goods
	public GoodsAllocation planToRemoveGoodsListWithTransportTask(GoodsAllocation goodsAllocation, String transportTaskId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithTransportTask(String goodsAllocationId, String transportTaskId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsAllocation with retail_store in Goods
	public GoodsAllocation planToRemoveGoodsListWithRetailStore(GoodsAllocation goodsAllocation, String retailStoreId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStore(String goodsAllocationId, String retailStoreId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsAllocation with biz_order in Goods
	public GoodsAllocation planToRemoveGoodsListWithBizOrder(GoodsAllocation goodsAllocation, String bizOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithBizOrder(String goodsAllocationId, String bizOrderId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsAllocation with retail_store_order in Goods
	public GoodsAllocation planToRemoveGoodsListWithRetailStoreOrder(GoodsAllocation goodsAllocation, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStoreOrder(String goodsAllocationId, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<GoodsAllocation> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateGoodsAllocation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<GoodsAllocation> findGoodsAllocationByGoodsShelf(String goodsShelfId, Map<String,Object> options);
 	public int countGoodsAllocationByGoodsShelf(String goodsShelfId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsAllocationByGoodsShelfIds(String[] ids, Map<String,Object> options);
 	public SmartList<GoodsAllocation> findGoodsAllocationByGoodsShelf(String goodsShelfId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsAllocationByGoodsShelf(SmartList<GoodsAllocation> resultList, String goodsShelfId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Goods的goodsAllocation的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<GoodsAllocation> us, Map<String,Object> options) throws Exception;
	
}


