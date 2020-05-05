
package com.doublechaintech.retailscm.shippingspace;
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
import com.doublechaintech.retailscm.warehouse.Warehouse;

import com.doublechaintech.retailscm.warehouse.WarehouseDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;


public interface ShippingSpaceDAO extends BaseDAO{

	public SmartList<ShippingSpace> loadAll();
	public ShippingSpace load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ShippingSpace> shippingSpaceList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ShippingSpace present(ShippingSpace shippingSpace,Map<String,Object> options) throws Exception;
	public ShippingSpace clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ShippingSpace save(ShippingSpace shippingSpace,Map<String,Object> options);
	public SmartList<ShippingSpace> saveShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList,Map<String,Object> options);
	public SmartList<ShippingSpace> removeShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList,Map<String,Object> options);
	public SmartList<ShippingSpace> findShippingSpaceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countShippingSpaceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countShippingSpaceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String shippingSpaceId, int version) throws Exception;
	public ShippingSpace disconnectFromAll(String shippingSpaceId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public GoodsDAO getGoodsDAO();
		
	
 	public SmartList<ShippingSpace> requestCandidateShippingSpaceForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ShippingSpace planToRemoveGoodsList(ShippingSpace shippingSpace, String goodsIds[], Map<String,Object> options)throws Exception;


	//disconnect ShippingSpace with sku in Goods
	public ShippingSpace planToRemoveGoodsListWithSku(ShippingSpace shippingSpace, String skuId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSku(String shippingSpaceId, String skuId, Map<String,Object> options)throws Exception;
	
	//disconnect ShippingSpace with receiving_space in Goods
	public ShippingSpace planToRemoveGoodsListWithReceivingSpace(ShippingSpace shippingSpace, String receivingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithReceivingSpace(String shippingSpaceId, String receivingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect ShippingSpace with goods_allocation in Goods
	public ShippingSpace planToRemoveGoodsListWithGoodsAllocation(ShippingSpace shippingSpace, String goodsAllocationId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithGoodsAllocation(String shippingSpaceId, String goodsAllocationId, Map<String,Object> options)throws Exception;
	
	//disconnect ShippingSpace with smart_pallet in Goods
	public ShippingSpace planToRemoveGoodsListWithSmartPallet(ShippingSpace shippingSpace, String smartPalletId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSmartPallet(String shippingSpaceId, String smartPalletId, Map<String,Object> options)throws Exception;
	
	//disconnect ShippingSpace with transport_task in Goods
	public ShippingSpace planToRemoveGoodsListWithTransportTask(ShippingSpace shippingSpace, String transportTaskId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithTransportTask(String shippingSpaceId, String transportTaskId, Map<String,Object> options)throws Exception;
	
	//disconnect ShippingSpace with retail_store in Goods
	public ShippingSpace planToRemoveGoodsListWithRetailStore(ShippingSpace shippingSpace, String retailStoreId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStore(String shippingSpaceId, String retailStoreId, Map<String,Object> options)throws Exception;
	
	//disconnect ShippingSpace with biz_order in Goods
	public ShippingSpace planToRemoveGoodsListWithBizOrder(ShippingSpace shippingSpace, String bizOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithBizOrder(String shippingSpaceId, String bizOrderId, Map<String,Object> options)throws Exception;
	
	//disconnect ShippingSpace with retail_store_order in Goods
	public ShippingSpace planToRemoveGoodsListWithRetailStoreOrder(ShippingSpace shippingSpace, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStoreOrder(String shippingSpaceId, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ShippingSpace> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateShippingSpace executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<ShippingSpace> findShippingSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countShippingSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public Map<String, Integer> countShippingSpaceByWarehouseIds(String[] ids, Map<String,Object> options);
 	public SmartList<ShippingSpace> findShippingSpaceByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 	public void analyzeShippingSpaceByWarehouse(SmartList<ShippingSpace> resultList, String warehouseId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Goods的shippingSpace的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<ShippingSpace> us, Map<String,Object> options) throws Exception;
	
}


