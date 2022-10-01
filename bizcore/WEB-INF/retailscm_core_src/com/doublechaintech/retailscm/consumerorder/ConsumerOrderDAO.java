package com.doublechaintech.retailscm.consumerorder;

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

import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;

import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupDAO;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupDAO;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentDAO;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordDAO;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;

public interface ConsumerOrderDAO extends BaseDAO {

  public SmartList<ConsumerOrder> loadAll();

  public Stream<ConsumerOrder> loadAllAsStream();

  public ConsumerOrder load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<ConsumerOrder> consumerOrderList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public ConsumerOrder present(ConsumerOrder consumerOrder, Map<String, Object> options)
      throws Exception;

  public ConsumerOrder clone(String id, Map<String, Object> options) throws Exception;

  public ConsumerOrder save(ConsumerOrder consumerOrder, Map<String, Object> options);

  public SmartList<ConsumerOrder> saveConsumerOrderList(
      SmartList<ConsumerOrder> consumerOrderList, Map<String, Object> options);

  public SmartList<ConsumerOrder> removeConsumerOrderList(
      SmartList<ConsumerOrder> consumerOrderList, Map<String, Object> options);

  public SmartList<ConsumerOrder> findConsumerOrderWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countConsumerOrderWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countConsumerOrderWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public ConsumerOrder disconnectFromAll(String consumerOrderId, int version) throws Exception;

  public void resetNextId();

  public ConsumerOrderLineItemDAO getConsumerOrderLineItemDAO();

  public ConsumerOrderShippingGroupDAO getConsumerOrderShippingGroupDAO();

  public ConsumerOrderPaymentGroupDAO getConsumerOrderPaymentGroupDAO();

  public ConsumerOrderPriceAdjustmentDAO getConsumerOrderPriceAdjustmentDAO();

  public RetailStoreMemberGiftCardConsumeRecordDAO getRetailStoreMemberGiftCardConsumeRecordDAO();

  public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderLineItem(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderShippingGroup(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderPaymentGroup(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public SmartList<ConsumerOrder> requestCandidateConsumerOrderForConsumerOrderPriceAdjustment(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public SmartList<ConsumerOrder>
      requestCandidateConsumerOrderForRetailStoreMemberGiftCardConsumeRecord(
          RetailscmUserContext userContext,
          String ownerClass,
          String id,
          String filterKey,
          int pageNo,
          int pageSize)
          throws Exception;

  public ConsumerOrder planToRemoveConsumerOrderLineItemList(
      ConsumerOrder consumerOrder, String consumerOrderLineItemIds[], Map<String, Object> options)
      throws Exception;

  public ConsumerOrder planToRemoveConsumerOrderShippingGroupList(
      ConsumerOrder consumerOrder,
      String consumerOrderShippingGroupIds[],
      Map<String, Object> options)
      throws Exception;

  public ConsumerOrder planToRemoveConsumerOrderPaymentGroupList(
      ConsumerOrder consumerOrder,
      String consumerOrderPaymentGroupIds[],
      Map<String, Object> options)
      throws Exception;

  public ConsumerOrder planToRemoveConsumerOrderPriceAdjustmentList(
      ConsumerOrder consumerOrder,
      String consumerOrderPriceAdjustmentIds[],
      Map<String, Object> options)
      throws Exception;

  public ConsumerOrder planToRemoveRetailStoreMemberGiftCardConsumeRecordList(
      ConsumerOrder consumerOrder,
      String retailStoreMemberGiftCardConsumeRecordIds[],
      Map<String, Object> options)
      throws Exception;

  // disconnect ConsumerOrder with owner in RetailStoreMemberGiftCardConsumeRecord
  public ConsumerOrder planToRemoveRetailStoreMemberGiftCardConsumeRecordListWithOwner(
      ConsumerOrder consumerOrder, String ownerId, Map<String, Object> options) throws Exception;

  public int countRetailStoreMemberGiftCardConsumeRecordListWithOwner(
      String consumerOrderId, String ownerId, Map<String, Object> options) throws Exception;

  public SmartList<ConsumerOrder> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<ConsumerOrder> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateConsumerOrder executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<ConsumerOrder> findConsumerOrderByConsumer(
      String retailStoreMemberId, Map<String, Object> options);

  public int countConsumerOrderByConsumer(String retailStoreMemberId, Map<String, Object> options);

  public Map<String, Integer> countConsumerOrderByConsumerIds(
      String[] ids, Map<String, Object> options);

  public SmartList<ConsumerOrder> findConsumerOrderByConsumer(
      String retailStoreMemberId, int start, int count, Map<String, Object> options);

  public void analyzeConsumerOrderByConsumer(
      SmartList<ConsumerOrder> resultList, String retailStoreMemberId, Map<String, Object> options);

  public SmartList<ConsumerOrder> findConsumerOrderByStore(
      String retailStoreId, Map<String, Object> options);

  public int countConsumerOrderByStore(String retailStoreId, Map<String, Object> options);

  public Map<String, Integer> countConsumerOrderByStoreIds(
      String[] ids, Map<String, Object> options);

  public SmartList<ConsumerOrder> findConsumerOrderByStore(
      String retailStoreId, int start, int count, Map<String, Object> options);

  public void analyzeConsumerOrderByStore(
      SmartList<ConsumerOrder> resultList, String retailStoreId, Map<String, Object> options);

  List<ConsumerOrder> search(ConsumerOrderRequest pRequest);
}
