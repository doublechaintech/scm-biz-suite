
package com.doublechaintech.retailscm.receivingspace;
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

import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.warehouse.Warehouse;

import com.doublechaintech.retailscm.warehouse.WarehouseDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;


public interface ReceivingSpaceDAO extends BaseDAO{

	public SmartList<ReceivingSpace> loadAll();
	public Stream<ReceivingSpace> loadAllAsStream();
	public ReceivingSpace load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ReceivingSpace> receivingSpaceList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public ReceivingSpace present(ReceivingSpace receivingSpace,Map<String,Object> options) throws Exception;
	public ReceivingSpace clone(String id, Map<String,Object> options) throws Exception;

	

	public ReceivingSpace save(ReceivingSpace receivingSpace,Map<String,Object> options);
	public SmartList<ReceivingSpace> saveReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList,Map<String,Object> options);
	public SmartList<ReceivingSpace> removeReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList,Map<String,Object> options);
	public SmartList<ReceivingSpace> findReceivingSpaceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countReceivingSpaceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countReceivingSpaceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String receivingSpaceId, int version) throws Exception;
	public ReceivingSpace disconnectFromAll(String receivingSpaceId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public GoodsDAO getGoodsDAO();
		
	
 	public SmartList<ReceivingSpace> requestCandidateReceivingSpaceForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ReceivingSpace planToRemoveGoodsList(ReceivingSpace receivingSpace, String goodsIds[], Map<String,Object> options)throws Exception;


	//disconnect ReceivingSpace with sku in Goods
	public ReceivingSpace planToRemoveGoodsListWithSku(ReceivingSpace receivingSpace, String skuId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSku(String receivingSpaceId, String skuId, Map<String,Object> options)throws Exception;
	
	//disconnect ReceivingSpace with goods_allocation in Goods
	public ReceivingSpace planToRemoveGoodsListWithGoodsAllocation(ReceivingSpace receivingSpace, String goodsAllocationId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithGoodsAllocation(String receivingSpaceId, String goodsAllocationId, Map<String,Object> options)throws Exception;
	
	//disconnect ReceivingSpace with smart_pallet in Goods
	public ReceivingSpace planToRemoveGoodsListWithSmartPallet(ReceivingSpace receivingSpace, String smartPalletId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSmartPallet(String receivingSpaceId, String smartPalletId, Map<String,Object> options)throws Exception;
	
	//disconnect ReceivingSpace with shipping_space in Goods
	public ReceivingSpace planToRemoveGoodsListWithShippingSpace(ReceivingSpace receivingSpace, String shippingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithShippingSpace(String receivingSpaceId, String shippingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect ReceivingSpace with transport_task in Goods
	public ReceivingSpace planToRemoveGoodsListWithTransportTask(ReceivingSpace receivingSpace, String transportTaskId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithTransportTask(String receivingSpaceId, String transportTaskId, Map<String,Object> options)throws Exception;
	
	//disconnect ReceivingSpace with retail_store in Goods
	public ReceivingSpace planToRemoveGoodsListWithRetailStore(ReceivingSpace receivingSpace, String retailStoreId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStore(String receivingSpaceId, String retailStoreId, Map<String,Object> options)throws Exception;
	
	//disconnect ReceivingSpace with biz_order in Goods
	public ReceivingSpace planToRemoveGoodsListWithBizOrder(ReceivingSpace receivingSpace, String bizOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithBizOrder(String receivingSpaceId, String bizOrderId, Map<String,Object> options)throws Exception;
	
	//disconnect ReceivingSpace with retail_store_order in Goods
	public ReceivingSpace planToRemoveGoodsListWithRetailStoreOrder(ReceivingSpace receivingSpace, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStoreOrder(String receivingSpaceId, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	

	public SmartList<ReceivingSpace> queryList(String sql, Object ... parmeters);
	public Stream<ReceivingSpace> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateReceivingSpace executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<ReceivingSpace> findReceivingSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countReceivingSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public Map<String, Integer> countReceivingSpaceByWarehouseIds(String[] ids, Map<String,Object> options);
 	public SmartList<ReceivingSpace> findReceivingSpaceByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 	public void analyzeReceivingSpaceByWarehouse(SmartList<ReceivingSpace> resultList, String warehouseId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:Goods的receivingSpace的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<ReceivingSpace> us, Map<String,Object> options) throws Exception;
	
}


