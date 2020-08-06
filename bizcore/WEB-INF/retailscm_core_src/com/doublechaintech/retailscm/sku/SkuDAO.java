
package com.doublechaintech.retailscm.sku;
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
import com.doublechaintech.retailscm.product.Product;

import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.product.ProductDAO;


public interface SkuDAO extends BaseDAO{

	public SmartList<Sku> loadAll();
	public Stream<Sku> loadAllAsStream();
	public Sku load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Sku> skuList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public Sku present(Sku sku,Map<String,Object> options) throws Exception;
	public Sku clone(String id, Map<String,Object> options) throws Exception;

	

	public Sku save(Sku sku,Map<String,Object> options);
	public SmartList<Sku> saveSkuList(SmartList<Sku> skuList,Map<String,Object> options);
	public SmartList<Sku> removeSkuList(SmartList<Sku> skuList,Map<String,Object> options);
	public SmartList<Sku> findSkuWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSkuWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSkuWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String skuId, int version) throws Exception;
	public Sku disconnectFromAll(String skuId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public GoodsDAO getGoodsDAO();
		
	
 	public SmartList<Sku> requestCandidateSkuForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Sku planToRemoveGoodsList(Sku sku, String goodsIds[], Map<String,Object> options)throws Exception;


	//disconnect Sku with receiving_space in Goods
	public Sku planToRemoveGoodsListWithReceivingSpace(Sku sku, String receivingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithReceivingSpace(String skuId, String receivingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect Sku with goods_allocation in Goods
	public Sku planToRemoveGoodsListWithGoodsAllocation(Sku sku, String goodsAllocationId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithGoodsAllocation(String skuId, String goodsAllocationId, Map<String,Object> options)throws Exception;
	
	//disconnect Sku with smart_pallet in Goods
	public Sku planToRemoveGoodsListWithSmartPallet(Sku sku, String smartPalletId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSmartPallet(String skuId, String smartPalletId, Map<String,Object> options)throws Exception;
	
	//disconnect Sku with shipping_space in Goods
	public Sku planToRemoveGoodsListWithShippingSpace(Sku sku, String shippingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithShippingSpace(String skuId, String shippingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect Sku with transport_task in Goods
	public Sku planToRemoveGoodsListWithTransportTask(Sku sku, String transportTaskId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithTransportTask(String skuId, String transportTaskId, Map<String,Object> options)throws Exception;
	
	//disconnect Sku with retail_store in Goods
	public Sku planToRemoveGoodsListWithRetailStore(Sku sku, String retailStoreId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStore(String skuId, String retailStoreId, Map<String,Object> options)throws Exception;
	
	//disconnect Sku with biz_order in Goods
	public Sku planToRemoveGoodsListWithBizOrder(Sku sku, String bizOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithBizOrder(String skuId, String bizOrderId, Map<String,Object> options)throws Exception;
	
	//disconnect Sku with retail_store_order in Goods
	public Sku planToRemoveGoodsListWithRetailStoreOrder(Sku sku, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStoreOrder(String skuId, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	

	public SmartList<Sku> queryList(String sql, Object ... parmeters);
	public Stream<Sku> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateSku executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<Sku> findSkuByProduct(String productId, Map<String,Object> options);
 	public int countSkuByProduct(String productId, Map<String,Object> options);
 	public Map<String, Integer> countSkuByProductIds(String[] ids, Map<String,Object> options);
 	public SmartList<Sku> findSkuByProduct(String productId, int start, int count, Map<String,Object> options);
 	public void analyzeSkuByProduct(SmartList<Sku> resultList, String productId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:Goods的sku的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<Sku> us, Map<String,Object> options) throws Exception;
	
}


