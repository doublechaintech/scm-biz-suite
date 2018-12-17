
package com.doublechaintech.retailscm.retailstoreorderlineitem;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;


public interface RetailStoreOrderLineItemDAO{

	
	public RetailStoreOrderLineItem load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreOrderLineItem> retailStoreOrderLineItemList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public RetailStoreOrderLineItem present(RetailStoreOrderLineItem retailStoreOrderLineItem,Map<String,Object> options) throws Exception;
	public RetailStoreOrderLineItem clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderLineItem save(RetailStoreOrderLineItem retailStoreOrderLineItem,Map<String,Object> options);
	public SmartList<RetailStoreOrderLineItem> saveRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList,Map<String,Object> options);
	public SmartList<RetailStoreOrderLineItem> removeRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList,Map<String,Object> options);
	public SmartList<RetailStoreOrderLineItem> findRetailStoreOrderLineItemWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreOrderLineItemWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreOrderLineItemWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreOrderLineItemId, int version) throws Exception;
	public RetailStoreOrderLineItem disconnectFromAll(String retailStoreOrderLineItemId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<RetailStoreOrderLineItem> queryList(String sql, Object ... parmeters);
 
 	public SmartList<RetailStoreOrderLineItem> findRetailStoreOrderLineItemByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public int countRetailStoreOrderLineItemByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreOrderLineItemByBizOrderIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStoreOrderLineItem> findRetailStoreOrderLineItemByBizOrder(String retailStoreOrderId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreOrderLineItemByBizOrder(SmartList<RetailStoreOrderLineItem> resultList, String retailStoreOrderId, Map<String,Object> options);

 
 }


