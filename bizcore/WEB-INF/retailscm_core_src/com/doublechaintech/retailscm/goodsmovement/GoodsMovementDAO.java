
package com.doublechaintech.retailscm.goodsmovement;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.goods.Goods;

import com.doublechaintech.retailscm.goods.GoodsDAO;


public interface GoodsMovementDAO extends BaseDAO{

	public SmartList<GoodsMovement> loadAll();
	public GoodsMovement load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<GoodsMovement> goodsMovementList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public GoodsMovement present(GoodsMovement goodsMovement,Map<String,Object> options) throws Exception;
	public GoodsMovement clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GoodsMovement save(GoodsMovement goodsMovement,Map<String,Object> options);
	public SmartList<GoodsMovement> saveGoodsMovementList(SmartList<GoodsMovement> goodsMovementList,Map<String,Object> options);
	public SmartList<GoodsMovement> removeGoodsMovementList(SmartList<GoodsMovement> goodsMovementList,Map<String,Object> options);
	public SmartList<GoodsMovement> findGoodsMovementWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countGoodsMovementWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countGoodsMovementWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String goodsMovementId, int version) throws Exception;
	public GoodsMovement disconnectFromAll(String goodsMovementId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<GoodsMovement> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateGoodsMovement executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<GoodsMovement> findGoodsMovementByGoods(String goodsId, Map<String,Object> options);
 	public int countGoodsMovementByGoods(String goodsId, Map<String,Object> options);
 	public Map<String, Integer> countGoodsMovementByGoodsIds(String[] ids, Map<String,Object> options);
 	public SmartList<GoodsMovement> findGoodsMovementByGoods(String goodsId, int start, int count, Map<String,Object> options);
 	public void analyzeGoodsMovementByGoods(SmartList<GoodsMovement> resultList, String goodsId, Map<String,Object> options);

 
 
}


