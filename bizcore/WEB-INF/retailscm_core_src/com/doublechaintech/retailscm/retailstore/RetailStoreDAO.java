
package com.doublechaintech.retailscm.retailstore;
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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingDAO;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationDAO;
import com.doublechaintech.retailscm.accountset.AccountSetDAO;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationDAO;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningDAO;
import com.doublechaintech.retailscm.transporttask.TransportTaskDAO;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingDAO;


public interface RetailStoreDAO extends BaseDAO{

	public SmartList<RetailStore> loadAll();
	public Stream<RetailStore> loadAllAsStream();
	public RetailStore load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStore> retailStoreList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public RetailStore present(RetailStore retailStore,Map<String,Object> options) throws Exception;
	public RetailStore clone(String id, Map<String,Object> options) throws Exception;

	

	public RetailStore save(RetailStore retailStore,Map<String,Object> options);
	public SmartList<RetailStore> saveRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options);
	public SmartList<RetailStore> removeRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options);
	public SmartList<RetailStore> findRetailStoreWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreId, int version) throws Exception;
	public RetailStore disconnectFromAll(String retailStoreId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ConsumerOrderDAO getConsumerOrderDAO();
		
	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	public GoodsDAO getGoodsDAO();
		
	public TransportTaskDAO getTransportTaskDAO();
		
	public AccountSetDAO getAccountSetDAO();
		
	
 	public SmartList<RetailStore> requestCandidateRetailStoreForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStore> requestCandidateRetailStoreForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStore> requestCandidateRetailStoreForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStore> requestCandidateRetailStoreForTransportTask(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStore> requestCandidateRetailStoreForAccountSet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStore planToRemoveConsumerOrderList(RetailStore retailStore, String consumerOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStore with consumer in ConsumerOrder
	public RetailStore planToRemoveConsumerOrderListWithConsumer(RetailStore retailStore, String consumerId, Map<String,Object> options)throws Exception;
	public int countConsumerOrderListWithConsumer(String retailStoreId, String consumerId, Map<String,Object> options)throws Exception;
	
	public RetailStore planToRemoveRetailStoreOrderList(RetailStore retailStore, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStore with seller in RetailStoreOrder
	public RetailStore planToRemoveRetailStoreOrderListWithSeller(RetailStore retailStore, String sellerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithSeller(String retailStoreId, String sellerId, Map<String,Object> options)throws Exception;
	
	public RetailStore planToRemoveGoodsList(RetailStore retailStore, String goodsIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStore with sku in Goods
	public RetailStore planToRemoveGoodsListWithSku(RetailStore retailStore, String skuId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSku(String retailStoreId, String skuId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStore with receiving_space in Goods
	public RetailStore planToRemoveGoodsListWithReceivingSpace(RetailStore retailStore, String receivingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithReceivingSpace(String retailStoreId, String receivingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStore with goods_allocation in Goods
	public RetailStore planToRemoveGoodsListWithGoodsAllocation(RetailStore retailStore, String goodsAllocationId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithGoodsAllocation(String retailStoreId, String goodsAllocationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStore with smart_pallet in Goods
	public RetailStore planToRemoveGoodsListWithSmartPallet(RetailStore retailStore, String smartPalletId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithSmartPallet(String retailStoreId, String smartPalletId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStore with shipping_space in Goods
	public RetailStore planToRemoveGoodsListWithShippingSpace(RetailStore retailStore, String shippingSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithShippingSpace(String retailStoreId, String shippingSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStore with transport_task in Goods
	public RetailStore planToRemoveGoodsListWithTransportTask(RetailStore retailStore, String transportTaskId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithTransportTask(String retailStoreId, String transportTaskId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStore with biz_order in Goods
	public RetailStore planToRemoveGoodsListWithBizOrder(RetailStore retailStore, String bizOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithBizOrder(String retailStoreId, String bizOrderId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStore with retail_store_order in Goods
	public RetailStore planToRemoveGoodsListWithRetailStoreOrder(RetailStore retailStore, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	public int countGoodsListWithRetailStoreOrder(String retailStoreId, String retailStoreOrderId, Map<String,Object> options)throws Exception;
	
	public RetailStore planToRemoveTransportTaskList(RetailStore retailStore, String transportTaskIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStore with driver in TransportTask
	public RetailStore planToRemoveTransportTaskListWithDriver(RetailStore retailStore, String driverId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithDriver(String retailStoreId, String driverId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStore with truck in TransportTask
	public RetailStore planToRemoveTransportTaskListWithTruck(RetailStore retailStore, String truckId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithTruck(String retailStoreId, String truckId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStore with belongs_to in TransportTask
	public RetailStore planToRemoveTransportTaskListWithBelongsTo(RetailStore retailStore, String belongsToId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithBelongsTo(String retailStoreId, String belongsToId, Map<String,Object> options)throws Exception;
	
	public RetailStore planToRemoveAccountSetList(RetailStore retailStore, String accountSetIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStore with country_center in AccountSet
	public RetailStore planToRemoveAccountSetListWithCountryCenter(RetailStore retailStore, String countryCenterId, Map<String,Object> options)throws Exception;
	public int countAccountSetListWithCountryCenter(String retailStoreId, String countryCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStore with goods_supplier in AccountSet
	public RetailStore planToRemoveAccountSetListWithGoodsSupplier(RetailStore retailStore, String goodsSupplierId, Map<String,Object> options)throws Exception;
	public int countAccountSetListWithGoodsSupplier(String retailStoreId, String goodsSupplierId, Map<String,Object> options)throws Exception;
	

	public SmartList<RetailStore> queryList(String sql, Object ... parmeters);
	public Stream<RetailStore> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStore executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<RetailStore> findRetailStoreByRetailStoreCountryCenter(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countRetailStoreByRetailStoreCountryCenter(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreByRetailStoreCountryCenterIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByRetailStoreCountryCenter(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreByRetailStoreCountryCenter(SmartList<RetailStore> resultList, String retailStoreCountryCenterId, Map<String,Object> options);


 
 	public SmartList<RetailStore> findRetailStoreByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public int countRetailStoreByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreByCityServiceCenterIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreByCityServiceCenter(SmartList<RetailStore> resultList, String retailStoreCityServiceCenterId, Map<String,Object> options);


 
 	public SmartList<RetailStore> findRetailStoreByCreation(String retailStoreCreationId, Map<String,Object> options);
 	public int countRetailStoreByCreation(String retailStoreCreationId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreByCreationIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByCreation(String retailStoreCreationId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreByCreation(SmartList<RetailStore> resultList, String retailStoreCreationId, Map<String,Object> options);


 
 	public SmartList<RetailStore> findRetailStoreByInvestmentInvitation(String retailStoreInvestmentInvitationId, Map<String,Object> options);
 	public int countRetailStoreByInvestmentInvitation(String retailStoreInvestmentInvitationId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreByInvestmentInvitationIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByInvestmentInvitation(String retailStoreInvestmentInvitationId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreByInvestmentInvitation(SmartList<RetailStore> resultList, String retailStoreInvestmentInvitationId, Map<String,Object> options);


 
 	public SmartList<RetailStore> findRetailStoreByFranchising(String retailStoreFranchisingId, Map<String,Object> options);
 	public int countRetailStoreByFranchising(String retailStoreFranchisingId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreByFranchisingIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByFranchising(String retailStoreFranchisingId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreByFranchising(SmartList<RetailStore> resultList, String retailStoreFranchisingId, Map<String,Object> options);


 
 	public SmartList<RetailStore> findRetailStoreByDecoration(String retailStoreDecorationId, Map<String,Object> options);
 	public int countRetailStoreByDecoration(String retailStoreDecorationId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreByDecorationIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByDecoration(String retailStoreDecorationId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreByDecoration(SmartList<RetailStore> resultList, String retailStoreDecorationId, Map<String,Object> options);


 
 	public SmartList<RetailStore> findRetailStoreByOpening(String retailStoreOpeningId, Map<String,Object> options);
 	public int countRetailStoreByOpening(String retailStoreOpeningId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreByOpeningIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByOpening(String retailStoreOpeningId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreByOpening(SmartList<RetailStore> resultList, String retailStoreOpeningId, Map<String,Object> options);


 
 	public SmartList<RetailStore> findRetailStoreByClosing(String retailStoreClosingId, Map<String,Object> options);
 	public int countRetailStoreByClosing(String retailStoreClosingId, Map<String,Object> options);
 	public Map<String, Integer> countRetailStoreByClosingIds(String[] ids, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByClosing(String retailStoreClosingId, int start, int count, Map<String,Object> options);
 	public void analyzeRetailStoreByClosing(SmartList<RetailStore> resultList, String retailStoreClosingId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:ConsumerOrder的store的ConsumerOrderList
	public SmartList<ConsumerOrder> loadOurConsumerOrderList(RetailscmUserContext userContext, List<RetailStore> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrder的buyer的RetailStoreOrderList
	public SmartList<RetailStoreOrder> loadOurRetailStoreOrderList(RetailscmUserContext userContext, List<RetailStore> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Goods的retailStore的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<RetailStore> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:TransportTask的end的TransportTaskList
	public SmartList<TransportTask> loadOurTransportTaskList(RetailscmUserContext userContext, List<RetailStore> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:AccountSet的retailStore的AccountSetList
	public SmartList<AccountSet> loadOurAccountSetList(RetailscmUserContext userContext, List<RetailStore> us, Map<String,Object> options) throws Exception;
	
}


