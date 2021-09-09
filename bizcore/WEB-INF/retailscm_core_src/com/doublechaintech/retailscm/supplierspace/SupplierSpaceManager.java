
package com.doublechaintech.retailscm.supplierspace;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;




public interface SupplierSpaceManager extends BaseManager{

		

  List<SupplierSpace> searchSupplierSpaceList(RetailscmUserContext ctx, SupplierSpaceRequest pRequest);
  SupplierSpace searchSupplierSpace(RetailscmUserContext ctx, SupplierSpaceRequest pRequest);
	public SupplierSpace createSupplierSpace(RetailscmUserContext userContext, String location,String contactNumber,String totalArea,String warehouseId,BigDecimal latitude,BigDecimal longitude) throws Exception;
	public SupplierSpace updateSupplierSpace(RetailscmUserContext userContext,String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplierSpace loadSupplierSpace(RetailscmUserContext userContext, String supplierSpaceId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public SupplierSpace internalSaveSupplierSpace(RetailscmUserContext userContext, SupplierSpace supplierSpace) throws Exception;
	public SupplierSpace internalSaveSupplierSpace(RetailscmUserContext userContext, SupplierSpace supplierSpace,Map<String,Object>option) throws Exception;

	public SupplierSpace transferToAnotherWarehouse(RetailscmUserContext userContext, String supplierSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String supplierSpaceId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplierSpace newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, SupplierSpace updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsShelfManager getGoodsShelfManager(RetailscmUserContext userContext, String supplierSpaceId, String location, String storageSpaceId, String damageSpaceId ,String [] tokensExpr)  throws Exception;

	public  SupplierSpace addGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, String location, String storageSpaceId, String damageSpaceId , String [] tokensExpr)  throws Exception;
	public  SupplierSpace removeGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion,String [] tokensExpr)  throws Exception;
	public  SupplierSpace updateGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByWarehouse(RetailscmUserContext userContext,String warehouseId) throws Exception;
	public Object listPageByWarehouse(RetailscmUserContext userContext,String warehouseId, int start, int count) throws Exception;
  




}


