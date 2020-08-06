
package com.doublechaintech.retailscm.product;
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

import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.sku.Sku;

import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryDAO;
import com.doublechaintech.retailscm.sku.SkuDAO;


public interface ProductDAO extends BaseDAO{

	public SmartList<Product> loadAll();
	public Stream<Product> loadAllAsStream();
	public Product load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Product> productList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public Product present(Product product,Map<String,Object> options) throws Exception;
	public Product clone(String id, Map<String,Object> options) throws Exception;

	

	public Product save(Product product,Map<String,Object> options);
	public SmartList<Product> saveProductList(SmartList<Product> productList,Map<String,Object> options);
	public SmartList<Product> removeProductList(SmartList<Product> productList,Map<String,Object> options);
	public SmartList<Product> findProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProductWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String productId, int version) throws Exception;
	public Product disconnectFromAll(String productId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public SkuDAO getSkuDAO();
		
	
 	public SmartList<Product> requestCandidateProductForSku(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Product planToRemoveSkuList(Product product, String skuIds[], Map<String,Object> options)throws Exception;



	public SmartList<Product> queryList(String sql, Object ... parmeters);
	public Stream<Product> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateProduct executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<Product> findProductByParentCategory(String levelThreeCategoryId, Map<String,Object> options);
 	public int countProductByParentCategory(String levelThreeCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countProductByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<Product> findProductByParentCategory(String levelThreeCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeProductByParentCategory(SmartList<Product> resultList, String levelThreeCategoryId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:Sku的product的SkuList
	public SmartList<Sku> loadOurSkuList(RetailscmUserContext userContext, List<Product> us, Map<String,Object> options) throws Exception;
	
}


