package com.doublechaintech.retailscm.goods;

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

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovement;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.smartpallet.SmartPalletDAO;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocationDAO;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;
import com.doublechaintech.retailscm.shippingspace.ShippingSpaceDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;
import com.doublechaintech.retailscm.sku.SkuDAO;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovementDAO;
import com.doublechaintech.retailscm.transporttask.TransportTaskDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpaceDAO;

public interface GoodsDAO extends BaseDAO {

  public SmartList<Goods> loadAll();

  public Stream<Goods> loadAllAsStream();

  public Goods load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<Goods> goodsList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public Goods present(Goods goods, Map<String, Object> options) throws Exception;

  public Goods clone(String id, Map<String, Object> options) throws Exception;

  public Goods save(Goods goods, Map<String, Object> options);

  public SmartList<Goods> saveGoodsList(SmartList<Goods> goodsList, Map<String, Object> options);

  public SmartList<Goods> removeGoodsList(SmartList<Goods> goodsList, Map<String, Object> options);

  public SmartList<Goods> findGoodsWithKey(MultipleAccessKey key, Map<String, Object> options);

  public int countGoodsWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countGoodsWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public Goods disconnectFromAll(String goodsId, int version) throws Exception;

  public void resetNextId();

  public GoodsMovementDAO getGoodsMovementDAO();

  public SmartList<Goods> requestCandidateGoodsForGoodsMovement(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public Goods planToRemoveGoodsMovementList(
      Goods goods, String goodsMovementIds[], Map<String, Object> options) throws Exception;

  public SmartList<Goods> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<Goods> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateGoods executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<Goods> findGoodsBySku(String skuId, Map<String, Object> options);

  public int countGoodsBySku(String skuId, Map<String, Object> options);

  public Map<String, Integer> countGoodsBySkuIds(String[] ids, Map<String, Object> options);

  public SmartList<Goods> findGoodsBySku(
      String skuId, int start, int count, Map<String, Object> options);

  public void analyzeGoodsBySku(
      SmartList<Goods> resultList, String skuId, Map<String, Object> options);

  public SmartList<Goods> findGoodsByReceivingSpace(
      String receivingSpaceId, Map<String, Object> options);

  public int countGoodsByReceivingSpace(String receivingSpaceId, Map<String, Object> options);

  public Map<String, Integer> countGoodsByReceivingSpaceIds(
      String[] ids, Map<String, Object> options);

  public SmartList<Goods> findGoodsByReceivingSpace(
      String receivingSpaceId, int start, int count, Map<String, Object> options);

  public void analyzeGoodsByReceivingSpace(
      SmartList<Goods> resultList, String receivingSpaceId, Map<String, Object> options);

  public SmartList<Goods> findGoodsByGoodsAllocation(
      String goodsAllocationId, Map<String, Object> options);

  public int countGoodsByGoodsAllocation(String goodsAllocationId, Map<String, Object> options);

  public Map<String, Integer> countGoodsByGoodsAllocationIds(
      String[] ids, Map<String, Object> options);

  public SmartList<Goods> findGoodsByGoodsAllocation(
      String goodsAllocationId, int start, int count, Map<String, Object> options);

  public void analyzeGoodsByGoodsAllocation(
      SmartList<Goods> resultList, String goodsAllocationId, Map<String, Object> options);

  public SmartList<Goods> findGoodsBySmartPallet(String smartPalletId, Map<String, Object> options);

  public int countGoodsBySmartPallet(String smartPalletId, Map<String, Object> options);

  public Map<String, Integer> countGoodsBySmartPalletIds(String[] ids, Map<String, Object> options);

  public SmartList<Goods> findGoodsBySmartPallet(
      String smartPalletId, int start, int count, Map<String, Object> options);

  public void analyzeGoodsBySmartPallet(
      SmartList<Goods> resultList, String smartPalletId, Map<String, Object> options);

  public SmartList<Goods> findGoodsByShippingSpace(
      String shippingSpaceId, Map<String, Object> options);

  public int countGoodsByShippingSpace(String shippingSpaceId, Map<String, Object> options);

  public Map<String, Integer> countGoodsByShippingSpaceIds(
      String[] ids, Map<String, Object> options);

  public SmartList<Goods> findGoodsByShippingSpace(
      String shippingSpaceId, int start, int count, Map<String, Object> options);

  public void analyzeGoodsByShippingSpace(
      SmartList<Goods> resultList, String shippingSpaceId, Map<String, Object> options);

  public SmartList<Goods> findGoodsByTransportTask(
      String transportTaskId, Map<String, Object> options);

  public int countGoodsByTransportTask(String transportTaskId, Map<String, Object> options);

  public Map<String, Integer> countGoodsByTransportTaskIds(
      String[] ids, Map<String, Object> options);

  public SmartList<Goods> findGoodsByTransportTask(
      String transportTaskId, int start, int count, Map<String, Object> options);

  public void analyzeGoodsByTransportTask(
      SmartList<Goods> resultList, String transportTaskId, Map<String, Object> options);

  public SmartList<Goods> findGoodsByRetailStore(String retailStoreId, Map<String, Object> options);

  public int countGoodsByRetailStore(String retailStoreId, Map<String, Object> options);

  public Map<String, Integer> countGoodsByRetailStoreIds(String[] ids, Map<String, Object> options);

  public SmartList<Goods> findGoodsByRetailStore(
      String retailStoreId, int start, int count, Map<String, Object> options);

  public void analyzeGoodsByRetailStore(
      SmartList<Goods> resultList, String retailStoreId, Map<String, Object> options);

  public SmartList<Goods> findGoodsByBizOrder(String supplyOrderId, Map<String, Object> options);

  public int countGoodsByBizOrder(String supplyOrderId, Map<String, Object> options);

  public Map<String, Integer> countGoodsByBizOrderIds(String[] ids, Map<String, Object> options);

  public SmartList<Goods> findGoodsByBizOrder(
      String supplyOrderId, int start, int count, Map<String, Object> options);

  public void analyzeGoodsByBizOrder(
      SmartList<Goods> resultList, String supplyOrderId, Map<String, Object> options);

  public SmartList<Goods> findGoodsByRetailStoreOrder(
      String retailStoreOrderId, Map<String, Object> options);

  public int countGoodsByRetailStoreOrder(String retailStoreOrderId, Map<String, Object> options);

  public Map<String, Integer> countGoodsByRetailStoreOrderIds(
      String[] ids, Map<String, Object> options);

  public SmartList<Goods> findGoodsByRetailStoreOrder(
      String retailStoreOrderId, int start, int count, Map<String, Object> options);

  public void analyzeGoodsByRetailStoreOrder(
      SmartList<Goods> resultList, String retailStoreOrderId, Map<String, Object> options);

  List<Goods> search(GoodsRequest pRequest);
}
