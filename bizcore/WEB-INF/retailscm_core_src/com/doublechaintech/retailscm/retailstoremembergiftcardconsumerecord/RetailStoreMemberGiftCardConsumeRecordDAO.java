
package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardDAO;


public interface RetailStoreMemberGiftCardConsumeRecordDAO extends BaseDAO{

	public SmartList<RetailStoreMemberGiftCardConsumeRecord> loadAll();
	public RetailStoreMemberGiftCardConsumeRecord load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreMemberGiftCardConsumeRecord present(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,Map<String,Object> options) throws Exception;
	public RetailStoreMemberGiftCardConsumeRecord clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreMemberGiftCardConsumeRecord save(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCardConsumeRecord> saveRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCardConsumeRecord> removeRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreMemberGiftCardConsumeRecordWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreMemberGiftCardConsumeRecordWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreMemberGiftCardConsumeRecordId, int version) throws Exception;
	public RetailStoreMemberGiftCardConsumeRecord disconnectFromAll(String retailStoreMemberGiftCardConsumeRecordId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<RetailStoreMemberGiftCardConsumeRecord> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreMemberGiftCardConsumeRecord executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordByOwner(String retailStoreMemberGiftCardId, Map<String,Object> options);
 	public int countRetailStoreMemberGiftCardConsumeRecordByOwner(String retailStoreMemberGiftCardId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreMemberGiftCardConsumeRecordByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordByOwner(String retailStoreMemberGiftCardId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreMemberGiftCardConsumeRecordByOwner(SmartList<RetailStoreMemberGiftCardConsumeRecord> resultList, String retailStoreMemberGiftCardId, Map<String,Object> options);

 
  
 	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public int countRetailStoreMemberGiftCardConsumeRecordByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreMemberGiftCardConsumeRecordByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordByBizOrder(String consumerOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreMemberGiftCardConsumeRecordByBizOrder(SmartList<RetailStoreMemberGiftCardConsumeRecord> resultList, String consumerOrderId, Map<String,Object> options);

 
 
}


