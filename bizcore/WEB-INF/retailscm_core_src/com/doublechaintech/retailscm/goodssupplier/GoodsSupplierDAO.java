
package com.doublechaintech.retailscm.goodssupplier;
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
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.supplierproduct.SupplierProductDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.accountset.AccountSetDAO;


public interface GoodsSupplierDAO extends BaseDAO{

	public SmartList<GoodsSupplier> loadAll();
	public Stream<GoodsSupplier> loadAllAsStream();
	public GoodsSupplier load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<GoodsSupplier> goodsSupplierList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public GoodsSupplier present(GoodsSupplier goodsSupplier,Map<String,Object> options) throws Exception;
	public GoodsSupplier clone(String id, Map<String,Object> options) throws Exception;

	

	public GoodsSupplier save(GoodsSupplier goodsSupplier,Map<String,Object> options);
	public SmartList<GoodsSupplier> saveGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList,Map<String,Object> options);
	public SmartList<GoodsSupplier> removeGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList,Map<String,Object> options);
	public SmartList<GoodsSupplier> findGoodsSupplierWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countGoodsSupplierWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countGoodsSupplierWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String goodsSupplierId, int version) throws Exception;
	public GoodsSupplier disconnectFromAll(String goodsSupplierId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public SupplierProductDAO getSupplierProductDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	public AccountSetDAO getAccountSetDAO();
		
	
 	public SmartList<GoodsSupplier> requestCandidateGoodsSupplierForSupplierProduct(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<GoodsSupplier> requestCandidateGoodsSupplierForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<GoodsSupplier> requestCandidateGoodsSupplierForAccountSet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public GoodsSupplier planToRemoveSupplierProductList(GoodsSupplier goodsSupplier, String supplierProductIds[], Map<String,Object> options)throws Exception;


	public GoodsSupplier planToRemoveSupplyOrderList(GoodsSupplier goodsSupplier, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect GoodsSupplier with buyer in SupplyOrder
	public GoodsSupplier planToRemoveSupplyOrderListWithBuyer(GoodsSupplier goodsSupplier, String buyerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithBuyer(String goodsSupplierId, String buyerId, Map<String,Object> options)throws Exception;
	
	public GoodsSupplier planToRemoveAccountSetList(GoodsSupplier goodsSupplier, String accountSetIds[], Map<String,Object> options)throws Exception;


	//disconnect GoodsSupplier with country_center in AccountSet
	public GoodsSupplier planToRemoveAccountSetListWithCountryCenter(GoodsSupplier goodsSupplier, String countryCenterId, Map<String,Object> options)throws Exception;
	public int countAccountSetListWithCountryCenter(String goodsSupplierId, String countryCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect GoodsSupplier with retail_store in AccountSet
	public GoodsSupplier planToRemoveAccountSetListWithRetailStore(GoodsSupplier goodsSupplier, String retailStoreId, Map<String,Object> options)throws Exception;
	public int countAccountSetListWithRetailStore(String goodsSupplierId, String retailStoreId, Map<String,Object> options)throws Exception;
	

	public SmartList<GoodsSupplier> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<GoodsSupplier> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateGoodsSupplier executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<GoodsSupplier> findGoodsSupplierByBelongTo(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countGoodsSupplierByBelongTo(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsSupplierByBelongToIds(String[] ids, Map<String,Object> options);
 	public SmartList<GoodsSupplier> findGoodsSupplierByBelongTo(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsSupplierByBelongTo(SmartList<GoodsSupplier> resultList, String retailStoreCountryCenterId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:SupplierProduct的supplier的SupplierProductList
	public SmartList<SupplierProduct> loadOurSupplierProductList(RetailscmUserContext userContext, List<GoodsSupplier> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrder的seller的SupplyOrderList
	public SmartList<SupplyOrder> loadOurSupplyOrderList(RetailscmUserContext userContext, List<GoodsSupplier> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:AccountSet的goodsSupplier的AccountSetList
	public SmartList<AccountSet> loadOurAccountSetList(RetailscmUserContext userContext, List<GoodsSupplier> us, Map<String,Object> options) throws Exception;
	

	List<GoodsSupplier> search(GoodsSupplierRequest pRequest);
}


