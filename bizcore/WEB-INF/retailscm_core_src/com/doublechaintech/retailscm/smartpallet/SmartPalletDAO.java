
package com.doublechaintech.retailscm.smartpallet;
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


public interface SmartPalletDAO extends BaseDAO{

	public SmartList<SmartPallet> loadAll();
	public Stream<SmartPallet> loadAllAsStream();
	public SmartPallet load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SmartPallet> smartPalletList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public SmartPallet present(SmartPallet smartPallet,Map<String,Object> options) throws Exception;
	public SmartPallet clone(String id, Map<String,Object> options) throws Exception;

	

	public SmartPallet save(SmartPallet smartPallet,Map<String,Object> options);
	public SmartList<SmartPallet> saveSmartPalletList(SmartList<SmartPallet> smartPalletList,Map<String,Object> options);
	public SmartList<SmartPallet> removeSmartPalletList(SmartList<SmartPallet> smartPalletList,Map<String,Object> options);
	public SmartList<SmartPallet> findSmartPalletWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSmartPalletWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSmartPalletWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String smartPalletId, int version) throws Exception;
	public SmartPallet disconnectFromAll(String smartPalletId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public GoodsDAO getGoodsDAO();
		
	
 	public SmartList<SmartPallet> requestCandidateSmartPalletForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SmartPallet planToRemoveGoodsList(SmartPallet smartPallet, String goodsIds[], Map<String,Object> options)throws Exception;


	//disconnect SmartPallet with sku in Goods
	public SmartPallet planToRemoveGoodsListWithSku(SmartPallet smartPallet, String skuId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSku(String smartPalletId, String skuId, Map<String,Object> options)throws Exception;
	
	//disconnect SmartPallet with receiving_space in Goods
	public SmartPallet planToRemoveGoodsListWithReceivingSpace(SmartPallet smartPallet, String receivingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithReceivingSpace(String smartPalletId, String receivingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect SmartPallet with goods_allocation in Goods
	public SmartPallet planToRemoveGoodsListWithGoodsAllocation(SmartPallet smartPallet, String goodsAllocationId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithGoodsAllocation(String smartPalletId, String goodsAllocationId, Map<String,Object> options)throws Exception;
	
	//disconnect SmartPallet with shipping_space in Goods
	public SmartPallet planToRemoveGoodsListWithShippingSpace(SmartPallet smartPallet, String shippingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithShippingSpace(String smartPalletId, String shippingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect SmartPallet with transport_task in Goods
	public SmartPallet planToRemoveGoodsListWithTransportTask(SmartPallet smartPallet, String transportTaskId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithTransportTask(String smartPalletId, String transportTaskId, Map<String,Object> options)throws Exception;
	
	//disconnect SmartPallet with retail_store in Goods
	public SmartPallet planToRemoveGoodsListWithRetailStore(SmartPallet smartPallet, String retailStoreId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStore(String smartPalletId, String retailStoreId, Map<String,Object> options)throws Exception;
	
	//disconnect SmartPallet with biz_order in Goods
	public SmartPallet planToRemoveGoodsListWithBizOrder(SmartPallet smartPallet, String bizOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithBizOrder(String smartPalletId, String bizOrderId, Map<String,Object> options)throws Exception;
	
	//disconnect SmartPallet with retail_store_order in Goods
	public SmartPallet planToRemoveGoodsListWithRetailStoreOrder(SmartPallet smartPallet, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStoreOrder(String smartPalletId, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	

	public SmartList<SmartPallet> queryList(String sql, Object ... parmeters);
	public Stream<SmartPallet> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateSmartPallet executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<SmartPallet> findSmartPalletByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countSmartPalletByWarehouse(String warehouseId, Map<String,Object> options);
 	public Map<String, Integer> countSmartPalletByWarehouseIds(String[] ids, Map<String,Object> options);
 	public SmartList<SmartPallet> findSmartPalletByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 	public void analyzeSmartPalletByWarehouse(SmartList<SmartPallet> resultList, String warehouseId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:Goods的smartPallet的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<SmartPallet> us, Map<String,Object> options) throws Exception;
	
}


