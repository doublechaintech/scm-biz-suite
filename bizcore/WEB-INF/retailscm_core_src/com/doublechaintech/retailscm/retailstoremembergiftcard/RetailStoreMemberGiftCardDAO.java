
package com.doublechaintech.retailscm.retailstoremembergiftcard;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordDAO;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;


public interface RetailStoreMemberGiftCardDAO{

	
	public RetailStoreMemberGiftCard load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreMemberGiftCard present(RetailStoreMemberGiftCard retailStoreMemberGiftCard,Map<String,Object> options) throws Exception;
	public RetailStoreMemberGiftCard clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreMemberGiftCard save(RetailStoreMemberGiftCard retailStoreMemberGiftCard,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCard> saveRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCard> removeRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreMemberGiftCardWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreMemberGiftCardWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreMemberGiftCardId, int version) throws Exception;
	public RetailStoreMemberGiftCard disconnectFromAll(String retailStoreMemberGiftCardId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RetailStoreMemberGiftCardConsumeRecordDAO getRetailStoreMemberGiftCardConsumeRecordDAO();
		
	
 	public SmartList<RetailStoreMemberGiftCard> requestCandidateRetailStoreMemberGiftCardForRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreMemberGiftCard planToRemoveRetailStoreMemberGiftCardConsumeRecordList(RetailStoreMemberGiftCard retailStoreMemberGiftCard, String retailStoreMemberGiftCardConsumeRecordIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreMemberGiftCard with biz_order in RetailStoreMemberGiftCardConsumeRecord
	public RetailStoreMemberGiftCard planToRemoveRetailStoreMemberGiftCardConsumeRecordListWithBizOrder(RetailStoreMemberGiftCard retailStoreMemberGiftCard, String bizOrderId, Map<String,Object> options)throws Exception;
	public int countRetailStoreMemberGiftCardConsumeRecordListWithBizOrder(String retailStoreMemberGiftCardId, String bizOrderId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<RetailStoreMemberGiftCard> queryList(String sql, Object ... parmeters);
 
 	public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countRetailStoreMemberGiftCardByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreMemberGiftCardByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreMemberGiftCardByOwner(SmartList<RetailStoreMemberGiftCard> resultList, String retailStoreMemberId, Map<String,Object> options);

 
 }


