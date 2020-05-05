
package com.doublechaintech.retailscm.goodsshelf;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface GoodsShelfManager extends BaseManager{

		

	public GoodsShelf createGoodsShelf(RetailscmUserContext userContext, String location,String storageSpaceId,String supplierSpaceId,String damageSpaceId) throws Exception;
	public GoodsShelf updateGoodsShelf(RetailscmUserContext userContext,String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GoodsShelf loadGoodsShelf(RetailscmUserContext userContext, String goodsShelfId, String [] tokensExpr) throws Exception;
	public GoodsShelf internalSaveGoodsShelf(RetailscmUserContext userContext, GoodsShelf goodsShelf) throws Exception;
	public GoodsShelf internalSaveGoodsShelf(RetailscmUserContext userContext, GoodsShelf goodsShelf,Map<String,Object>option) throws Exception;

	public GoodsShelf transferToAnotherStorageSpace(RetailscmUserContext userContext, String goodsShelfId, String anotherStorageSpaceId)  throws Exception;
 	public GoodsShelf transferToAnotherSupplierSpace(RetailscmUserContext userContext, String goodsShelfId, String anotherSupplierSpaceId)  throws Exception;
 	public GoodsShelf transferToAnotherDamageSpace(RetailscmUserContext userContext, String goodsShelfId, String anotherDamageSpaceId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String goodsShelfId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsShelf newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsShelfStockCountManager getGoodsShelfStockCountManager(RetailscmUserContext userContext, String goodsShelfId, String title, Date countTime, String summary ,String [] tokensExpr)  throws Exception;

	public  GoodsShelf addGoodsShelfStockCount(RetailscmUserContext userContext, String goodsShelfId, String title, Date countTime, String summary , String [] tokensExpr)  throws Exception;
	public  GoodsShelf removeGoodsShelfStockCount(RetailscmUserContext userContext, String goodsShelfId, String goodsShelfStockCountId, int goodsShelfStockCountVersion,String [] tokensExpr)  throws Exception;
	public  GoodsShelf updateGoodsShelfStockCount(RetailscmUserContext userContext, String goodsShelfId, String goodsShelfStockCountId, int goodsShelfStockCountVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  GoodsAllocationManager getGoodsAllocationManager(RetailscmUserContext userContext, String goodsShelfId, String location, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  GoodsShelf addGoodsAllocation(RetailscmUserContext userContext, String goodsShelfId, String location, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  GoodsShelf removeGoodsAllocation(RetailscmUserContext userContext, String goodsShelfId, String goodsAllocationId, int goodsAllocationVersion,String [] tokensExpr)  throws Exception;
	public  GoodsShelf updateGoodsAllocation(RetailscmUserContext userContext, String goodsShelfId, String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByStorageSpace(RetailscmUserContext userContext,String storageSpaceId) throws Exception;
	public Object listPageByStorageSpace(RetailscmUserContext userContext,String storageSpaceId, int start, int count) throws Exception;
  
	public Object listBySupplierSpace(RetailscmUserContext userContext,String supplierSpaceId) throws Exception;
	public Object listPageBySupplierSpace(RetailscmUserContext userContext,String supplierSpaceId, int start, int count) throws Exception;
  
	public Object listByDamageSpace(RetailscmUserContext userContext,String damageSpaceId) throws Exception;
	public Object listPageByDamageSpace(RetailscmUserContext userContext,String damageSpaceId, int start, int count) throws Exception;
  

}


