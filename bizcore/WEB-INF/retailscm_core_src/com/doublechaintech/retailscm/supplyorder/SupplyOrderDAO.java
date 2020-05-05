
package com.doublechaintech.retailscm.supplyorder;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;

import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupDAO;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemDAO;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface SupplyOrderDAO extends BaseDAO{

	public SmartList<SupplyOrder> loadAll();
	public SupplyOrder load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplyOrder> supplyOrderList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplyOrder present(SupplyOrder supplyOrder,Map<String,Object> options) throws Exception;
	public SupplyOrder clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrder save(SupplyOrder supplyOrder,Map<String,Object> options);
	public SmartList<SupplyOrder> saveSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options);
	public SmartList<SupplyOrder> removeSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options);
	public SmartList<SupplyOrder> findSupplyOrderWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplyOrderWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplyOrderWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplyOrderId, int version) throws Exception;
	public SupplyOrder disconnectFromAll(String supplyOrderId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public SupplyOrderLineItemDAO getSupplyOrderLineItemDAO();
		
	public SupplyOrderShippingGroupDAO getSupplyOrderShippingGroupDAO();
		
	public SupplyOrderPaymentGroupDAO getSupplyOrderPaymentGroupDAO();
		
	public GoodsDAO getGoodsDAO();
		
	
 	public SmartList<SupplyOrder> requestCandidateSupplyOrderForSupplyOrderLineItem(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SupplyOrder> requestCandidateSupplyOrderForSupplyOrderShippingGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SupplyOrder> requestCandidateSupplyOrderForSupplyOrderPaymentGroup(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SupplyOrder> requestCandidateSupplyOrderForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplyOrder planToRemoveSupplyOrderLineItemList(SupplyOrder supplyOrder, String supplyOrderLineItemIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrder with sku_id in SupplyOrderLineItem
	public SupplyOrder planToRemoveSupplyOrderLineItemListWithSkuId(SupplyOrder supplyOrder, String skuIdId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderLineItemListWithSkuId(String supplyOrderId, String skuIdId, Map<String,Object> options)throws Exception;
	
	public SupplyOrder planToRemoveSupplyOrderShippingGroupList(SupplyOrder supplyOrder, String supplyOrderShippingGroupIds[], Map<String,Object> options)throws Exception;


	public SupplyOrder planToRemoveSupplyOrderPaymentGroupList(SupplyOrder supplyOrder, String supplyOrderPaymentGroupIds[], Map<String,Object> options)throws Exception;


	public SupplyOrder planToRemoveGoodsList(SupplyOrder supplyOrder, String goodsIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplyOrder with sku in Goods
	public SupplyOrder planToRemoveGoodsListWithSku(SupplyOrder supplyOrder, String skuId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSku(String supplyOrderId, String skuId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrder with receiving_space in Goods
	public SupplyOrder planToRemoveGoodsListWithReceivingSpace(SupplyOrder supplyOrder, String receivingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithReceivingSpace(String supplyOrderId, String receivingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrder with goods_allocation in Goods
	public SupplyOrder planToRemoveGoodsListWithGoodsAllocation(SupplyOrder supplyOrder, String goodsAllocationId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithGoodsAllocation(String supplyOrderId, String goodsAllocationId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrder with smart_pallet in Goods
	public SupplyOrder planToRemoveGoodsListWithSmartPallet(SupplyOrder supplyOrder, String smartPalletId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSmartPallet(String supplyOrderId, String smartPalletId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrder with shipping_space in Goods
	public SupplyOrder planToRemoveGoodsListWithShippingSpace(SupplyOrder supplyOrder, String shippingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithShippingSpace(String supplyOrderId, String shippingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrder with transport_task in Goods
	public SupplyOrder planToRemoveGoodsListWithTransportTask(SupplyOrder supplyOrder, String transportTaskId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithTransportTask(String supplyOrderId, String transportTaskId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrder with retail_store in Goods
	public SupplyOrder planToRemoveGoodsListWithRetailStore(SupplyOrder supplyOrder, String retailStoreId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStore(String supplyOrderId, String retailStoreId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplyOrder with retail_store_order in Goods
	public SupplyOrder planToRemoveGoodsListWithRetailStoreOrder(SupplyOrder supplyOrder, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStoreOrder(String supplyOrderId, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplyOrder> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSupplyOrder executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<SupplyOrder> findSupplyOrderByBuyer(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countSupplyOrderByBuyer(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countSupplyOrderByBuyerIds(String[] ids, Map<String,Object> options);
 	public SmartList<SupplyOrder> findSupplyOrderByBuyer(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeSupplyOrderByBuyer(SmartList<SupplyOrder> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
  
 	public SmartList<SupplyOrder> findSupplyOrderBySeller(String goodsSupplierId, Map<String,Object> options);
 	public int countSupplyOrderBySeller(String goodsSupplierId, Map<String,Object> options);
 	public Map<String, Integer> countSupplyOrderBySellerIds(String[] ids, Map<String,Object> options);
 	public SmartList<SupplyOrder> findSupplyOrderBySeller(String goodsSupplierId, int start, int count, Map<String,Object> options);
 	public void analyzeSupplyOrderBySeller(SmartList<SupplyOrder> resultList, String goodsSupplierId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:SupplyOrderLineItem的bizOrder的SupplyOrderLineItemList
	public SmartList<SupplyOrderLineItem> loadOurSupplyOrderLineItemList(RetailscmUserContext userContext, List<SupplyOrder> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrderShippingGroup的bizOrder的SupplyOrderShippingGroupList
	public SmartList<SupplyOrderShippingGroup> loadOurSupplyOrderShippingGroupList(RetailscmUserContext userContext, List<SupplyOrder> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrderPaymentGroup的bizOrder的SupplyOrderPaymentGroupList
	public SmartList<SupplyOrderPaymentGroup> loadOurSupplyOrderPaymentGroupList(RetailscmUserContext userContext, List<SupplyOrder> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Goods的bizOrder的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<SupplyOrder> us, Map<String,Object> options) throws Exception;
	
}


