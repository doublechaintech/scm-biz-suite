
package com.doublechaintech.retailscm.goodspackaging;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.goods.GoodsDAO;


public interface GoodsPackagingDAO{

	
	public GoodsPackaging load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<GoodsPackaging> goodsPackagingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public GoodsPackaging present(GoodsPackaging goodsPackaging,Map<String,Object> options) throws Exception;
	public GoodsPackaging clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GoodsPackaging save(GoodsPackaging goodsPackaging,Map<String,Object> options);
	public SmartList<GoodsPackaging> saveGoodsPackagingList(SmartList<GoodsPackaging> goodsPackagingList,Map<String,Object> options);
	public SmartList<GoodsPackaging> removeGoodsPackagingList(SmartList<GoodsPackaging> goodsPackagingList,Map<String,Object> options);
	public SmartList<GoodsPackaging> findGoodsPackagingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countGoodsPackagingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countGoodsPackagingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String goodsPackagingId, int version) throws Exception;
	public GoodsPackaging disconnectFromAll(String goodsPackagingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public GoodsDAO getGoodsDAO();
		
	
 	public SmartList<GoodsPackaging> requestCandidateGoodsPackagingForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public GoodsPackaging planToRemoveGoodsList(GoodsPackaging goodsPackaging, String goodsIds[], Map<String,Object> options)throws Exception;


	//disconnect GoodsPackaging with sku in Goods
	public GoodsPackaging planToRemoveGoodsListWithSku(GoodsPackaging goodsPackaging, String skuId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSku(String goodsPackagingId, String skuId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsPackaging with receiving_space in Goods
	public GoodsPackaging planToRemoveGoodsListWithReceivingSpace(GoodsPackaging goodsPackaging, String receivingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithReceivingSpace(String goodsPackagingId, String receivingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsPackaging with goods_allocation in Goods
	public GoodsPackaging planToRemoveGoodsListWithGoodsAllocation(GoodsPackaging goodsPackaging, String goodsAllocationId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithGoodsAllocation(String goodsPackagingId, String goodsAllocationId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsPackaging with smart_pallet in Goods
	public GoodsPackaging planToRemoveGoodsListWithSmartPallet(GoodsPackaging goodsPackaging, String smartPalletId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSmartPallet(String goodsPackagingId, String smartPalletId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsPackaging with shipping_space in Goods
	public GoodsPackaging planToRemoveGoodsListWithShippingSpace(GoodsPackaging goodsPackaging, String shippingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithShippingSpace(String goodsPackagingId, String shippingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsPackaging with transport_task in Goods
	public GoodsPackaging planToRemoveGoodsListWithTransportTask(GoodsPackaging goodsPackaging, String transportTaskId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithTransportTask(String goodsPackagingId, String transportTaskId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsPackaging with retail_store in Goods
	public GoodsPackaging planToRemoveGoodsListWithRetailStore(GoodsPackaging goodsPackaging, String retailStoreId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStore(String goodsPackagingId, String retailStoreId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsPackaging with biz_order in Goods
	public GoodsPackaging planToRemoveGoodsListWithBizOrder(GoodsPackaging goodsPackaging, String bizOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithBizOrder(String goodsPackagingId, String bizOrderId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsPackaging with retail_store_order in Goods
	public GoodsPackaging planToRemoveGoodsListWithRetailStoreOrder(GoodsPackaging goodsPackaging, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStoreOrder(String goodsPackagingId, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<GoodsPackaging> queryList(String sql, Object ... parmeters);
}


