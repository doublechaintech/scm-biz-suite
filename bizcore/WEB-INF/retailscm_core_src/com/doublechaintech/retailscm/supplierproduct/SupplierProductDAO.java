
package com.doublechaintech.retailscm.supplierproduct;
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

import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;

import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationDAO;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierDAO;


public interface SupplierProductDAO extends BaseDAO{

	public SmartList<SupplierProduct> loadAll();
	public Stream<SupplierProduct> loadAllAsStream();
	public SupplierProduct load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplierProduct> supplierProductList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public SupplierProduct present(SupplierProduct supplierProduct,Map<String,Object> options) throws Exception;
	public SupplierProduct clone(String id, Map<String,Object> options) throws Exception;

	

	public SupplierProduct save(SupplierProduct supplierProduct,Map<String,Object> options);
	public SmartList<SupplierProduct> saveSupplierProductList(SmartList<SupplierProduct> supplierProductList,Map<String,Object> options);
	public SmartList<SupplierProduct> removeSupplierProductList(SmartList<SupplierProduct> supplierProductList,Map<String,Object> options);
	public SmartList<SupplierProduct> findSupplierProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplierProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplierProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplierProductId, int version) throws Exception;
	public SupplierProduct disconnectFromAll(String supplierProductId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ProductSupplyDurationDAO getProductSupplyDurationDAO();
		
	
 	public SmartList<SupplierProduct> requestCandidateSupplierProductForProductSupplyDuration(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplierProduct planToRemoveProductSupplyDurationList(SupplierProduct supplierProduct, String productSupplyDurationIds[], Map<String,Object> options)throws Exception;



	public SmartList<SupplierProduct> queryList(String sql, Object ... parmeters);
	public Stream<SupplierProduct> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateSupplierProduct executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<SupplierProduct> findSupplierProductBySupplier(String goodsSupplierId, Map<String,Object> options);
 	public int countSupplierProductBySupplier(String goodsSupplierId, Map<String,Object> options);
 	public Map<String, Integer> countSupplierProductBySupplierIds(String[] ids, Map<String,Object> options);
 	public SmartList<SupplierProduct> findSupplierProductBySupplier(String goodsSupplierId, int start, int count, Map<String,Object> options);
 	public void analyzeSupplierProductBySupplier(SmartList<SupplierProduct> resultList, String goodsSupplierId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:ProductSupplyDuration的product的ProductSupplyDurationList
	public SmartList<ProductSupplyDuration> loadOurProductSupplyDurationList(RetailscmUserContext userContext, List<SupplierProduct> us, Map<String,Object> options) throws Exception;
	
}


