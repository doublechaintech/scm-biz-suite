package com.doublechaintech.retailscm.retailstoremembergiftcard;

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

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;

import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordDAO;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;

public interface RetailStoreMemberGiftCardDAO extends BaseDAO {

  public SmartList<RetailStoreMemberGiftCard> loadAll();

  public Stream<RetailStoreMemberGiftCard> loadAllAsStream();

  public RetailStoreMemberGiftCard load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public RetailStoreMemberGiftCard present(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> options)
      throws Exception;

  public RetailStoreMemberGiftCard clone(String id, Map<String, Object> options) throws Exception;

  public RetailStoreMemberGiftCard save(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> options);

  public SmartList<RetailStoreMemberGiftCard> saveRetailStoreMemberGiftCardList(
      SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,
      Map<String, Object> options);

  public SmartList<RetailStoreMemberGiftCard> removeRetailStoreMemberGiftCardList(
      SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,
      Map<String, Object> options);

  public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countRetailStoreMemberGiftCardWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countRetailStoreMemberGiftCardWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public RetailStoreMemberGiftCard disconnectFromAll(
      String retailStoreMemberGiftCardId, int version) throws Exception;

  public void resetNextId();

  public RetailStoreMemberGiftCardConsumeRecordDAO getRetailStoreMemberGiftCardConsumeRecordDAO();

  public SmartList<RetailStoreMemberGiftCard>
      requestCandidateRetailStoreMemberGiftCardForRetailStoreMemberGiftCardConsumeRecord(
          RetailscmUserContext userContext,
          String ownerClass,
          String id,
          String filterKey,
          int pageNo,
          int pageSize)
          throws Exception;

  public RetailStoreMemberGiftCard planToRemoveRetailStoreMemberGiftCardConsumeRecordList(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard,
      String retailStoreMemberGiftCardConsumeRecordIds[],
      Map<String, Object> options)
      throws Exception;

  // disconnect RetailStoreMemberGiftCard with biz_order in RetailStoreMemberGiftCardConsumeRecord
  public RetailStoreMemberGiftCard
      planToRemoveRetailStoreMemberGiftCardConsumeRecordListWithBizOrder(
          RetailStoreMemberGiftCard retailStoreMemberGiftCard,
          String bizOrderId,
          Map<String, Object> options)
          throws Exception;

  public int countRetailStoreMemberGiftCardConsumeRecordListWithBizOrder(
      String retailStoreMemberGiftCardId, String bizOrderId, Map<String, Object> options)
      throws Exception;

  public SmartList<RetailStoreMemberGiftCard> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<RetailStoreMemberGiftCard> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateRetailStoreMemberGiftCard executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardByOwner(
      String retailStoreMemberId, Map<String, Object> options);

  public int countRetailStoreMemberGiftCardByOwner(
      String retailStoreMemberId, Map<String, Object> options);

  public Map<String, Integer> countRetailStoreMemberGiftCardByOwnerIds(
      String[] ids, Map<String, Object> options);

  public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardByOwner(
      String retailStoreMemberId, int start, int count, Map<String, Object> options);

  public void analyzeRetailStoreMemberGiftCardByOwner(
      SmartList<RetailStoreMemberGiftCard> resultList,
      String retailStoreMemberId,
      Map<String, Object> options);

  List<RetailStoreMemberGiftCard> search(RetailStoreMemberGiftCardRequest pRequest);
}
