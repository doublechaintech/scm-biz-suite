package com.doublechaintech.retailscm.retailstoreorder;

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
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;

import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemDAO;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupDAO;

public interface RetailStoreOrderDAO extends BaseDAO {

  public SmartList<RetailStoreOrder> loadAll();

  public Stream<RetailStoreOrder> loadAllAsStream();

  public RetailStoreOrder load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<RetailStoreOrder> retailStoreOrderList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public RetailStoreOrder present(RetailStoreOrder retailStoreOrder, Map<String, Object> options)
      throws Exception;

  public RetailStoreOrder clone(String id, Map<String, Object> options) throws Exception;

  public RetailStoreOrder save(RetailStoreOrder retailStoreOrder, Map<String, Object> options);

  public SmartList<RetailStoreOrder> saveRetailStoreOrderList(
      SmartList<RetailStoreOrder> retailStoreOrderList, Map<String, Object> options);

  public SmartList<RetailStoreOrder> removeRetailStoreOrderList(
      SmartList<RetailStoreOrder> retailStoreOrderList, Map<String, Object> options);

  public SmartList<RetailStoreOrder> findRetailStoreOrderWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countRetailStoreOrderWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countRetailStoreOrderWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public RetailStoreOrder disconnectFromAll(String retailStoreOrderId, int version)
      throws Exception;

  public void resetNextId();

  public RetailStoreOrderLineItemDAO getRetailStoreOrderLineItemDAO();

  public RetailStoreOrderShippingGroupDAO getRetailStoreOrderShippingGroupDAO();

  public RetailStoreOrderPaymentGroupDAO getRetailStoreOrderPaymentGroupDAO();

  public GoodsDAO getGoodsDAO();

  public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForRetailStoreOrderLineItem(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public SmartList<RetailStoreOrder>
      requestCandidateRetailStoreOrderForRetailStoreOrderShippingGroup(
          RetailscmUserContext userContext,
          String ownerClass,
          String id,
          String filterKey,
          int pageNo,
          int pageSize)
          throws Exception;

  public SmartList<RetailStoreOrder>
      requestCandidateRetailStoreOrderForRetailStoreOrderPaymentGroup(
          RetailscmUserContext userContext,
          String ownerClass,
          String id,
          String filterKey,
          int pageNo,
          int pageSize)
          throws Exception;

  public SmartList<RetailStoreOrder> requestCandidateRetailStoreOrderForGoods(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public RetailStoreOrder planToRemoveRetailStoreOrderLineItemList(
      RetailStoreOrder retailStoreOrder,
      String retailStoreOrderLineItemIds[],
      Map<String, Object> options)
      throws Exception;

  public RetailStoreOrder planToRemoveRetailStoreOrderShippingGroupList(
      RetailStoreOrder retailStoreOrder,
      String retailStoreOrderShippingGroupIds[],
      Map<String, Object> options)
      throws Exception;

  public RetailStoreOrder planToRemoveRetailStoreOrderPaymentGroupList(
      RetailStoreOrder retailStoreOrder,
      String retailStoreOrderPaymentGroupIds[],
      Map<String, Object> options)
      throws Exception;

  public RetailStoreOrder planToRemoveGoodsList(
      RetailStoreOrder retailStoreOrder, String goodsIds[], Map<String, Object> options)
      throws Exception;

  // disconnect RetailStoreOrder with sku in Goods
  public RetailStoreOrder planToRemoveGoodsListWithSku(
      RetailStoreOrder retailStoreOrder, String skuId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithSku(
      String retailStoreOrderId, String skuId, Map<String, Object> options) throws Exception;

  // disconnect RetailStoreOrder with receiving_space in Goods
  public RetailStoreOrder planToRemoveGoodsListWithReceivingSpace(
      RetailStoreOrder retailStoreOrder, String receivingSpaceId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithReceivingSpace(
      String retailStoreOrderId, String receivingSpaceId, Map<String, Object> options)
      throws Exception;

  // disconnect RetailStoreOrder with goods_allocation in Goods
  public RetailStoreOrder planToRemoveGoodsListWithGoodsAllocation(
      RetailStoreOrder retailStoreOrder, String goodsAllocationId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithGoodsAllocation(
      String retailStoreOrderId, String goodsAllocationId, Map<String, Object> options)
      throws Exception;

  // disconnect RetailStoreOrder with smart_pallet in Goods
  public RetailStoreOrder planToRemoveGoodsListWithSmartPallet(
      RetailStoreOrder retailStoreOrder, String smartPalletId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithSmartPallet(
      String retailStoreOrderId, String smartPalletId, Map<String, Object> options)
      throws Exception;

  // disconnect RetailStoreOrder with shipping_space in Goods
  public RetailStoreOrder planToRemoveGoodsListWithShippingSpace(
      RetailStoreOrder retailStoreOrder, String shippingSpaceId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithShippingSpace(
      String retailStoreOrderId, String shippingSpaceId, Map<String, Object> options)
      throws Exception;

  // disconnect RetailStoreOrder with transport_task in Goods
  public RetailStoreOrder planToRemoveGoodsListWithTransportTask(
      RetailStoreOrder retailStoreOrder, String transportTaskId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithTransportTask(
      String retailStoreOrderId, String transportTaskId, Map<String, Object> options)
      throws Exception;

  // disconnect RetailStoreOrder with retail_store in Goods
  public RetailStoreOrder planToRemoveGoodsListWithRetailStore(
      RetailStoreOrder retailStoreOrder, String retailStoreId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithRetailStore(
      String retailStoreOrderId, String retailStoreId, Map<String, Object> options)
      throws Exception;

  // disconnect RetailStoreOrder with biz_order in Goods
  public RetailStoreOrder planToRemoveGoodsListWithBizOrder(
      RetailStoreOrder retailStoreOrder, String bizOrderId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithBizOrder(
      String retailStoreOrderId, String bizOrderId, Map<String, Object> options) throws Exception;

  public SmartList<RetailStoreOrder> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<RetailStoreOrder> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateRetailStoreOrder executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<RetailStoreOrder> findRetailStoreOrderByBuyer(
      String retailStoreId, Map<String, Object> options);

  public int countRetailStoreOrderByBuyer(String retailStoreId, Map<String, Object> options);

  public Map<String, Integer> countRetailStoreOrderByBuyerIds(
      String[] ids, Map<String, Object> options);

  public SmartList<RetailStoreOrder> findRetailStoreOrderByBuyer(
      String retailStoreId, int start, int count, Map<String, Object> options);

  public void analyzeRetailStoreOrderByBuyer(
      SmartList<RetailStoreOrder> resultList, String retailStoreId, Map<String, Object> options);

  public SmartList<RetailStoreOrder> findRetailStoreOrderBySeller(
      String retailStoreCountryCenterId, Map<String, Object> options);

  public int countRetailStoreOrderBySeller(
      String retailStoreCountryCenterId, Map<String, Object> options);

  public Map<String, Integer> countRetailStoreOrderBySellerIds(
      String[] ids, Map<String, Object> options);

  public SmartList<RetailStoreOrder> findRetailStoreOrderBySeller(
      String retailStoreCountryCenterId, int start, int count, Map<String, Object> options);

  public void analyzeRetailStoreOrderBySeller(
      SmartList<RetailStoreOrder> resultList,
      String retailStoreCountryCenterId,
      Map<String, Object> options);

  List<RetailStoreOrder> search(RetailStoreOrderRequest pRequest);
}
