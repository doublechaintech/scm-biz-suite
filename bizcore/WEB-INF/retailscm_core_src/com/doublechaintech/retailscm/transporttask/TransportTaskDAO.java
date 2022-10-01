package com.doublechaintech.retailscm.transporttask;

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
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;

import com.doublechaintech.retailscm.transporttruck.TransportTruckDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackDAO;
import com.doublechaintech.retailscm.transportfleet.TransportFleetDAO;
import com.doublechaintech.retailscm.truckdriver.TruckDriverDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;

public interface TransportTaskDAO extends BaseDAO {

  public SmartList<TransportTask> loadAll();

  public Stream<TransportTask> loadAllAsStream();

  public TransportTask load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<TransportTask> transportTaskList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public TransportTask present(TransportTask transportTask, Map<String, Object> options)
      throws Exception;

  public TransportTask clone(String id, Map<String, Object> options) throws Exception;

  public TransportTask save(TransportTask transportTask, Map<String, Object> options);

  public SmartList<TransportTask> saveTransportTaskList(
      SmartList<TransportTask> transportTaskList, Map<String, Object> options);

  public SmartList<TransportTask> removeTransportTaskList(
      SmartList<TransportTask> transportTaskList, Map<String, Object> options);

  public SmartList<TransportTask> findTransportTaskWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countTransportTaskWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countTransportTaskWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public TransportTask disconnectFromAll(String transportTaskId, int version) throws Exception;

  public void resetNextId();

  public GoodsDAO getGoodsDAO();

  public TransportTaskTrackDAO getTransportTaskTrackDAO();

  public SmartList<TransportTask> requestCandidateTransportTaskForGoods(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public SmartList<TransportTask> requestCandidateTransportTaskForTransportTaskTrack(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public TransportTask planToRemoveGoodsList(
      TransportTask transportTask, String goodsIds[], Map<String, Object> options) throws Exception;

  // disconnect TransportTask with sku in Goods
  public TransportTask planToRemoveGoodsListWithSku(
      TransportTask transportTask, String skuId, Map<String, Object> options) throws Exception;

  public int countGoodsListWithSku(
      String transportTaskId, String skuId, Map<String, Object> options) throws Exception;

  // disconnect TransportTask with receiving_space in Goods
  public TransportTask planToRemoveGoodsListWithReceivingSpace(
      TransportTask transportTask, String receivingSpaceId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithReceivingSpace(
      String transportTaskId, String receivingSpaceId, Map<String, Object> options)
      throws Exception;

  // disconnect TransportTask with goods_allocation in Goods
  public TransportTask planToRemoveGoodsListWithGoodsAllocation(
      TransportTask transportTask, String goodsAllocationId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithGoodsAllocation(
      String transportTaskId, String goodsAllocationId, Map<String, Object> options)
      throws Exception;

  // disconnect TransportTask with smart_pallet in Goods
  public TransportTask planToRemoveGoodsListWithSmartPallet(
      TransportTask transportTask, String smartPalletId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithSmartPallet(
      String transportTaskId, String smartPalletId, Map<String, Object> options) throws Exception;

  // disconnect TransportTask with shipping_space in Goods
  public TransportTask planToRemoveGoodsListWithShippingSpace(
      TransportTask transportTask, String shippingSpaceId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithShippingSpace(
      String transportTaskId, String shippingSpaceId, Map<String, Object> options) throws Exception;

  // disconnect TransportTask with retail_store in Goods
  public TransportTask planToRemoveGoodsListWithRetailStore(
      TransportTask transportTask, String retailStoreId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithRetailStore(
      String transportTaskId, String retailStoreId, Map<String, Object> options) throws Exception;

  // disconnect TransportTask with biz_order in Goods
  public TransportTask planToRemoveGoodsListWithBizOrder(
      TransportTask transportTask, String bizOrderId, Map<String, Object> options) throws Exception;

  public int countGoodsListWithBizOrder(
      String transportTaskId, String bizOrderId, Map<String, Object> options) throws Exception;

  // disconnect TransportTask with retail_store_order in Goods
  public TransportTask planToRemoveGoodsListWithRetailStoreOrder(
      TransportTask transportTask, String retailStoreOrderId, Map<String, Object> options)
      throws Exception;

  public int countGoodsListWithRetailStoreOrder(
      String transportTaskId, String retailStoreOrderId, Map<String, Object> options)
      throws Exception;

  public TransportTask planToRemoveTransportTaskTrackList(
      TransportTask transportTask, String transportTaskTrackIds[], Map<String, Object> options)
      throws Exception;

  public SmartList<TransportTask> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<TransportTask> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateTransportTask executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<TransportTask> findTransportTaskByEnd(
      String retailStoreId, Map<String, Object> options);

  public int countTransportTaskByEnd(String retailStoreId, Map<String, Object> options);

  public Map<String, Integer> countTransportTaskByEndIds(String[] ids, Map<String, Object> options);

  public SmartList<TransportTask> findTransportTaskByEnd(
      String retailStoreId, int start, int count, Map<String, Object> options);

  public void analyzeTransportTaskByEnd(
      SmartList<TransportTask> resultList, String retailStoreId, Map<String, Object> options);

  public SmartList<TransportTask> findTransportTaskByDriver(
      String truckDriverId, Map<String, Object> options);

  public int countTransportTaskByDriver(String truckDriverId, Map<String, Object> options);

  public Map<String, Integer> countTransportTaskByDriverIds(
      String[] ids, Map<String, Object> options);

  public SmartList<TransportTask> findTransportTaskByDriver(
      String truckDriverId, int start, int count, Map<String, Object> options);

  public void analyzeTransportTaskByDriver(
      SmartList<TransportTask> resultList, String truckDriverId, Map<String, Object> options);

  public SmartList<TransportTask> findTransportTaskByTruck(
      String transportTruckId, Map<String, Object> options);

  public int countTransportTaskByTruck(String transportTruckId, Map<String, Object> options);

  public Map<String, Integer> countTransportTaskByTruckIds(
      String[] ids, Map<String, Object> options);

  public SmartList<TransportTask> findTransportTaskByTruck(
      String transportTruckId, int start, int count, Map<String, Object> options);

  public void analyzeTransportTaskByTruck(
      SmartList<TransportTask> resultList, String transportTruckId, Map<String, Object> options);

  public SmartList<TransportTask> findTransportTaskByBelongsTo(
      String transportFleetId, Map<String, Object> options);

  public int countTransportTaskByBelongsTo(String transportFleetId, Map<String, Object> options);

  public Map<String, Integer> countTransportTaskByBelongsToIds(
      String[] ids, Map<String, Object> options);

  public SmartList<TransportTask> findTransportTaskByBelongsTo(
      String transportFleetId, int start, int count, Map<String, Object> options);

  public void analyzeTransportTaskByBelongsTo(
      SmartList<TransportTask> resultList, String transportFleetId, Map<String, Object> options);

  List<TransportTask> search(TransportTaskRequest pRequest);
}
